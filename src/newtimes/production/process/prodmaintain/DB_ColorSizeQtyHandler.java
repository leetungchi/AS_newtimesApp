package newtimes.production.process.prodmaintain;
import exgui.ultratable.PagedDataFactoryAdapter;
import java.util.*;
import database.datatype.*;
/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class DB_ColorSizeQtyHandler extends PagedDataFactoryAdapter {
  public Vector ProdColors=null;
  public Vector Licensees=null;
  public Vector Prices=null;
  protected Vector ClrLixPrx=null;
  protected HashMap mapRec2TblCell=new HashMap();
  protected Record tempBlankRecord;
  protected boolean isInitOk=false;
  protected String[] extendedRecordColumns;
  protected Vector orgQryRecords=null;
  protected util.InsertionOrderedHashMap mappedColumName=new util.InsertionOrderedHashMap();//this object is created while records are retrived
  static public  HashMap DozeToDecMapping=null;
  static public HashMap DecToDozeMapping=null;
  static public Record BLANK_ORG_QTY_RECORD=null;
  public static java.text.NumberFormat testNoFormater=new java.text.DecimalFormat("######0.00");
  protected HashMap PRX_ClrLxyPrx;
  public static final String _SHOW_LXY_COLOR="_SHOW_LXY_COLOR";
  public DB_ColorSizeQtyHandler() {
    /*
     prepare for Dozimal pluse/minuse function.
     .08->1
     .16->2
     .25->3
     .33->4
     .41->5
     .50->6
     .58->7
     .66->8
     .75->9
     .83->10
     .91->11
     */
    if(DozeToDecMapping==null){
      DozeToDecMapping=new HashMap();
      DozeToDecMapping.put("1", "08");
      DozeToDecMapping.put("2", "16");
      DozeToDecMapping.put("3", "25");
      DozeToDecMapping.put("4", "33");
      DozeToDecMapping.put("5", "41");
      DozeToDecMapping.put("6", "50");
      DozeToDecMapping.put("7", "58");
      DozeToDecMapping.put("8", "66");
      DozeToDecMapping.put("9", "75");
      DozeToDecMapping.put("10", "83");
      DozeToDecMapping.put("11", "91");
      DozeToDecMapping.put("0", "0");

      DecToDozeMapping=new HashMap();
      DecToDozeMapping.put("08","1");
      DecToDozeMapping.put("16","2");
      DecToDozeMapping.put("25","3");
      DecToDozeMapping.put("33","4");
      DecToDozeMapping.put("41","5");
      DecToDozeMapping.put("50","6");
      DecToDozeMapping.put("58","7");
      DecToDozeMapping.put("66","8");
      DecToDozeMapping.put("75","9");
      DecToDozeMapping.put("83","10");
      DecToDozeMapping.put("91","11");
      DecToDozeMapping.put("00", "0");
    }

    try{
      newtimesejb.production.ColorSizeQtyFacadeHome ejbHome =
          (newtimesejb.production.ColorSizeQtyFacadeHome)
          info_ejb.WeblogicServiceLocator.locateServiceHome(
          util.PublicVariable.SERVER_URL,
          "newtimesejb.production.ColorSizeQtyFacade"
          );
      newtimesejb.production.ColorSizeQtyFacade xejb = ejbHome.create();
     ClrLixPrx=xejb.getClrLixPrx(
          newtimes.production.ProdMaintain_Properties.CURRENT_SELECTED_STYLE_SEQ_IN_STYLE_LIST,
          newtimes.preproduction.Constants.CURRENT_PREPROD_HEAD_PK,
          (String)util.PublicVariable.USER_RECORD.get("usr_code"));
     if(ClrLixPrx.size()==0){
       exgui.verification.VerifyLib.showPlanMsg(
         "Please Define Production Colors Before Define Qty",
         "Please Define Production Colors Before Define Qty");
      isInitOk=false;
      return;
     }
         //replace the null data to "N/A", and make the combined column for licensee_color_name
     /*
      select a.pri_seq,a.PRI_BYR_ACT_PRX,
      (select b.PROD_COLOR_name from prod_color b where b.PROD_COLOR_PK=a.PROD_COLOR_PK) as color_name,
      (select c.BYMKR_BRIEF from buyer_maker c where c.BYMKR_SEQ=a.PRI_LICENSEE_NAME) as licensee
      from price a where  a.record_delete_flag='1' and a.pri_sty_seq=67
     */
    PRX_ClrLxyPrx=new HashMap();
     for(int i=0;i<ClrLixPrx.size();i++){
       Record rec=(Record)ClrLixPrx.get(i);
       Object objLxy=rec.get(3);
       Object objColor=rec.get(2);
       Object objPrx=rec.get(1);
       if(objLxy==null){
         objLxy="N/A";
         rec.set(3,objLxy);
       }
       if(objColor==null){
         objColor="N/A";
         rec.set(2,objColor);
       }
       if(objPrx==null){
         objPrx="N/A";
         rec.set(1,objPrx);
       }
       rec.getFieldName().add("licensee_color_name");
       rec.getValueFields().add(objLxy.toString()+"/"+objColor.toString());
       /*
       String[] arrAPRX_Data={objPrx.toString(),
                              objLxy.toString(),
                              objColor.toString(),
                              objLxy.toString()+"/"+objColor.toString()};
        */
       PRX_ClrLxyPrx.put(rec.get(0).toString(),objPrx);
     }
     this.ejb = xejb;
     tempBlankRecord = ejb.getBlankRecord(); //we will append lot cell into it latter.
     BLANK_ORG_QTY_RECORD=(Record)util.MiscFunc.deepCopy(tempBlankRecord);
     tempBlankRecord.set("record_create_user",
                         util.PublicVariable.USER_RECORD.get("usr_code"));
     tempBlankRecord.set("QTY_STY_SEQ",
                         newtimes.production.ProdMaintain_Properties.
                         CURRENT_SELECTED_STYLE_SEQ_IN_STYLE_LIST);
     tempBlankRecord.set("PRI_SEQ", ((Record)ClrLixPrx.get(0)).get(0));

      //apppend the blank record to co-responding size columns to the tail of it.
      String extClmString=
          (String)newtimes.production.ProdMaintain_Properties.EDITING_STYLE_RECORD.get("STY_SIZE_COLUMN");
      if(extClmString==null)extClmString="";
      extendedRecordColumns=util.MiscFunc.split(extClmString,",,");
      if(extendedRecordColumns.length==1 && extendedRecordColumns[0].trim().length()==0){
       extendedRecordColumns=new String[]{};
      }

      for(int i=0;i<extendedRecordColumns.length;i++){
        tempBlankRecord.getFieldName().add("##"+extendedRecordColumns[i]);
        tempBlankRecord.getValueFields().add(null);//default value is null;
      }
      tempBlankRecord.getFieldName().add("_TABLE_ROW_AT");//for latter to mapping.
      tempBlankRecord.getValueFields().add(null);
      tempBlankRecord.getFieldName().add("_TOTAL_VALUE");
      tempBlankRecord.getValueFields().add(null);

      tempBlankRecord.getFieldName().add(_SHOW_LXY_COLOR);//for latter to mapping.
      tempBlankRecord.getValueFields().add(null);
      tempBlankRecord.getFieldName().add("color_name");//for latter to mapping.
      tempBlankRecord.getValueFields().add(null);
      tempBlankRecord.getFieldName().add("licensee");//for latter to mapping.
      tempBlankRecord.getValueFields().add(null);


      this.blankRecord=tempBlankRecord;

      BLANK_ORG_QTY_RECORD.set("qty_seq",-1);
      BLANK_ORG_QTY_RECORD.set("record_delete_flag",1);
      BLANK_ORG_QTY_RECORD.set("QTY_STY_SEQ",
                          newtimes.production.ProdMaintain_Properties.
                          CURRENT_SELECTED_STYLE_SEQ_IN_STYLE_LIST);
      BLANK_ORG_QTY_RECORD.set("record_create_user",
                          util.PublicVariable.USER_RECORD.get("usr_code"));
      isInitOk=true;
    }catch(Exception e){
       e.printStackTrace();
       exgui.verification.VerifyLib.showPlanMsg("Server Side Connection Error\nPlease Contact System Manager",
                                                "EJB Creation Erro");
       isInitOk=false;
    }
  }
  public Vector getClrLxyPrxs(){
    return ClrLixPrx;
  }
  public HashMap getPriSeqMapPrx(){return PRX_ClrLxyPrx;}
  public void deleteAllQty() throws Exception{
    ((newtimesejb.production.ColorSizeQtyFacade)ejb).deleteAllQty(
        newtimes.production.ProdMaintain_Properties.
                          CURRENT_SELECTED_STYLE_SEQ_IN_STYLE_LIST,
            (String)util.PublicVariable.USER_RECORD.get("usr_code"));
      newtimes.production.ProdMaintain_Properties.EDITING_STYLE_RECORD.set("STY_QTY_TYPE","12");
      newtimes.production.ProdMaintain_Properties.EDITING_STYLE_RECORD.set("STY_SIZE_COLUMN","");
  }
  /**
   * obtain the stored stored mapping record ,for update & delete......
   * @return HashMap,key is "row_NoOfExtendedRecordColumns",value is orginal Store Record
   */
  public HashMap getMappedRec2TblCell(){
    return mapRec2TblCell;
  }
  protected boolean isDzUnit(){
    try{
      String unit=(String)
       newtimes.production.ProdMaintain_Properties.EDITING_STYLE_RECORD.get("STY_UNIT");
      return (unit.toLowerCase().trim().startsWith("dz"));
    }catch(Exception e){
      e.printStackTrace();
      return false;
    }
  }
  public boolean isDBHandlerInitOK(){return isInitOk;}
  public Vector getRecords(int bgn,int row)throws Exception{
   int currentMappingRowNo=0;
   mapRec2TblCell.clear();
   Vector convertedRecords=new Vector();
    orgQryRecords = ((newtimesejb.production.ColorSizeQtyFacade)ejb).getRecords(
        newtimes.production.ProdMaintain_Properties.CURRENT_SELECTED_STYLE_SEQ_IN_STYLE_LIST
        ,bgn,row);
     //it time to make linear to table now.
  //column to fill..
  //QTY_STY_SEQ, QTY_SIZE_SIZE, QTY_SIZE_SEQ,
  //QTY_PCS, QTY_QTY, PROD_COLOR_PK, PRI_SEQ, QTY_LICENSEE_NAME
  byte sty_qty_type_num=(byte)
   newtimes.production.ProdMaintain_Properties.EDITING_STYLE_RECORD.getInt("STY_QTY_TYPE");

    if(orgQryRecords.size()==0) orgQryRecords=makeAllBlankQtyData();//make all required blank data directly for user
    boolean isDz=isDzUnit();
      for (int i = 0; i < orgQryRecords.size(); i++) {
        Record recBlank2Fill = getBlankRecord();
        if (extendedRecordColumns.length > 0) {
          float xntRowTotalQty = 0;
          Object price_seq=null;
          for (int j = 0; j < extendedRecordColumns.length; j++) {
            Record rec = (Record) orgQryRecords.get(i);
            if (j == 0) {
              price_seq=rec.get("PRI_SEQ");
              recBlank2Fill.set("QTY_STY_SEQ", rec.get("QTY_STY_SEQ"));
              recBlank2Fill.set("PROD_COLOR_PK", rec.get("PROD_COLOR_PK"));
              recBlank2Fill.set("PRI_SEQ", rec.get("PRI_SEQ"));
              recBlank2Fill.set("QTY_LICENSEE_NAME",
                                rec.get("QTY_LICENSEE_NAME"));
              recBlank2Fill.set("_TABLE_ROW_AT", currentMappingRowNo);
              mapRec2TblCell.put(String.valueOf(currentMappingRowNo) + "_" +
                                 String.valueOf(j), rec);
            }

            mapRec2TblCell.put(String.valueOf(currentMappingRowNo) + "_" +
                               String.valueOf(j), rec);
            //append the qty valu to end of the composed blank record.
            float convertedQty = Dz2float(rec);
            recBlank2Fill.set("##" + extendedRecordColumns[j], convertedQty);
            if (isDz)
              xntRowTotalQty = addDzValue(xntRowTotalQty, convertedQty);
            else
              xntRowTotalQty += convertedQty;
            i++;
          }
          recBlank2Fill.set("_TOTAL_VALUE", xntRowTotalQty);
          recBlank2Fill.set(_SHOW_LXY_COLOR, price_seq);

          recBlank2Fill.set("PRI_SEQ",getPriSeqMapPrx().get(price_seq.toString()));

          convertedRecords.add(recBlank2Fill);
          //System.out.println("composed record is:"+recBlank2Fill);
          --i; //adjust.
          currentMappingRowNo++;

        }
        else {
          Record rec = (Record) orgQryRecords.get(i);
          Object price_seq=rec.get("PRI_SEQ");
          recBlank2Fill.set("QTY_STY_SEQ", rec.get("QTY_STY_SEQ"));
          recBlank2Fill.set("PROD_COLOR_PK", rec.get("PROD_COLOR_PK"));
          recBlank2Fill.set("PROD_COLOR_PK", rec.get("PROD_COLOR_PK"));
          recBlank2Fill.set("PRI_SEQ", rec.get("PRI_SEQ"));
          recBlank2Fill.set("QTY_LICENSEE_NAME", rec.get("QTY_LICENSEE_NAME"));
          recBlank2Fill.set("_TABLE_ROW_AT", currentMappingRowNo);
          recBlank2Fill.set("_TOTAL_VALUE", Dz2float(rec));
          mapRec2TblCell.put(String.valueOf(i) + "_" + String.valueOf(0), rec);
          recBlank2Fill.set(_SHOW_LXY_COLOR, price_seq);
          if(sty_qty_type_num==8){//only size & price
          }else{//with licensee or color....,need to fill coresponding price.
            recBlank2Fill.set("PRI_SEQ",
                              getPriSeqMapPrx().get(price_seq.toString()));
          }

          convertedRecords.add(recBlank2Fill);
          currentMappingRowNo++;
        }
      }
    if(convertedRecords.size()>0){
      //append the blank row for "Total"
      Record recBlank2Fill=getBlankRecord();
      recBlank2Fill.set("_TABLE_ROW_AT",-1);//as key to detern this is a summed row.
      convertedRecords.add(recBlank2Fill);
    }
   return convertedRecords;
  }
  public void udpateQtyTbl2Text(String tbl2Text) throws Exception{
    ((newtimesejb.production.ColorSizeQtyFacade)ejb).updateStyleQtyDesc(
        newtimes.production.ProdMaintain_Properties.CURRENT_SELECTED_STYLE_SEQ_IN_STYLE_LIST,
        tbl2Text,
        (String)util.PublicVariable.USER_RECORD.get("usr_code"));
  }
 public void updateRecords(Vector vct2update)throws Exception{
    ((newtimesejb.production.ColorSizeQtyFacade)ejb).updateRecords(vct2update);
 }
  public void deleteRecords(Vector vct2delete)throws Exception{
    ((newtimesejb.production.ColorSizeQtyFacade)ejb).deleteRecords(vct2delete);
  }
  public Record addRecord(Record rec)throws Exception{
    Record rec2add=getBlankRecord();
    return ((newtimesejb.production.ColorSizeQtyFacade)ejb).insertRecord(rec2add);
  }
  static public float Dz2float(Record qtyRec){
    //get qty_qty and pluse pcs with mapping of Dozimal
    try{
     String unit=(String)
      newtimes.production.ProdMaintain_Properties.EDITING_STYLE_RECORD.get("STY_UNIT");
      if(unit.toLowerCase().trim().startsWith("dz")){
        Object objQty=qtyRec.get("QTY_QTY");
        Object objPcs=qtyRec.get("QTY_PCS");
        String intPart=(objQty==null)?"0":String.valueOf(Integer.parseInt(util.MiscFunc.split(objQty.toString(),".")[0]));
        String pcsPart=(objPcs==null)?"0":String.valueOf(Integer.parseInt(objPcs.toString()));
        String decPart=(String)DozeToDecMapping.get(pcsPart);
        if(decPart==null)decPart="0";
        return Float.parseFloat(intPart+"."+decPart);
      }else{
        Object obj=qtyRec.get("QTY_QTY");
        return (obj==null)?0:Float.parseFloat(obj.toString());
      }
    }catch(Exception e){
      e.printStackTrace();
      return 0;
    }
  }
  static public void Dz2Record(Record qtyRec,String displayValue){
    if(displayValue==null||displayValue.trim().length()==0){
      Dz2Record(qtyRec,0);
    }else
    Dz2Record(qtyRec,Float.parseFloat(displayValue));
  }
  static public void Dz2Record(Record qtyRec,float displayValue){
    try{
     String unit=(String)
      newtimes.production.ProdMaintain_Properties.EDITING_STYLE_RECORD.get("STY_UNIT");
      if(unit.toLowerCase().trim().startsWith("dz")){
          String totalResult=testNoFormater.format(displayValue);
          String  parts[]=util.MiscFunc.split(totalResult,".");
          String tmpStr=
              (String)DecToDozeMapping.get(parts[1]);

          int pcsValue=
              Integer.parseInt((tmpStr==null)?"0":tmpStr);

          int qtyValue=
              Integer.parseInt(parts[0]);
       qtyRec.set("QTY_QTY",qtyValue);
       qtyRec.set("QTY_PCS",pcsValue);
     }else{
       qtyRec.set("QTY_QTY",displayValue);
       qtyRec.set("QTY_PCS",0);
     }
    }catch(Exception e){
      e.printStackTrace();
    }
  }
  static public float addDzValue(float orgValue,float value2add){
    //assumed "unit" of current style record is detected by cell format checker.
    String orgValueString[]=
        util.MiscFunc.split(testNoFormater.format(orgValue),".");
    String value2addString[]=
        util.MiscFunc.split(testNoFormater.format(value2add),".");

    int orgValueInt=(orgValue==0)?0:
        Integer.parseInt(orgValueString[0]);
    String tmpStr=(String)DecToDozeMapping.get(orgValueString[1]);
    int orgValueDec=(orgValue==0)?0:
        Integer.parseInt((tmpStr==null)?"0":tmpStr);

    int addValueInt=(value2add==0)?0:
        Integer.parseInt(value2addString[0]);

      tmpStr=(String)DecToDozeMapping.get(value2addString[1]);
    int addValueDec=(value2add==0)?0:
        Integer.parseInt((tmpStr==null)?"0":tmpStr);

    int totalIntPart=orgValueInt+addValueInt;
    int totalDecPart=(addValueDec+orgValueDec)%12;
    if((addValueDec+orgValueDec)>11){
      ++totalIntPart;
    }
    String decPartStr=(String)DozeToDecMapping.get(String.valueOf(totalDecPart));
    if(decPartStr==null)decPartStr="0";
    String totalString=String.valueOf(totalIntPart)+"."+decPartStr;
    return Float.parseFloat(totalString);
  }
  static public float minusDzValue(float orgValue,float value2minus){
    //assumed "unit" of current style record is detected by cell format checker.
    String orgValueString[]=
        util.MiscFunc.split(testNoFormater.format(orgValue),".");
    String value2addString[]=
        util.MiscFunc.split(testNoFormater.format(value2minus),".");

    int orgValueInt=(orgValue==0)?0:
        Integer.parseInt(orgValueString[0]);

    String tmpStr=(String)DecToDozeMapping.get(orgValueString[1]);
    int orgValueDec=(orgValue==0)?0:
        Integer.parseInt((tmpStr==null)?"0":tmpStr);

    int addValueInt=(value2minus==0)?0:
        Integer.parseInt(value2addString[0]);

    tmpStr=(String)DecToDozeMapping.get(value2addString[1]);
    int addValueDec=(value2minus==0)?0:
        Integer.parseInt((tmpStr==null)?"0":tmpStr);

    int totalIntPart=orgValueInt-addValueInt;
    int totalDecPart=0;
    if(addValueDec>orgValueDec){
      --totalIntPart;
      totalDecPart=(orgValueDec+12-addValueDec)%12;
    }else{
      totalDecPart=(orgValueDec-addValueDec);
    }

   String decPartStr=(String)DozeToDecMapping.get(String.valueOf(totalDecPart));
   if(decPartStr==null)decPartStr="0";
    String totalString=String.valueOf(totalIntPart)+"."+decPartStr;
    return Float.parseFloat(totalString);
  }
  public Vector makeAllBlankQtyData()throws Exception{
    Vector outputVector=new Vector();
    for(int i=0;i<getClrLxyPrxs().size();i++){
      Record recClrLixPrx=(Record)getClrLxyPrxs().get(i);
        if(extendedRecordColumns.length>0){
          for(int j=0;j<extendedRecordColumns.length;j++){
            Record rec=(Record)util.MiscFunc.deepCopy(BLANK_ORG_QTY_RECORD);
            rec.set("PRI_SEQ",recClrLixPrx.get(0));
            //QTY_STY_SEQ, QTY_SIZE_SIZE
            rec.set("QTY_SIZE_SEQ",j+1);
            rec.set("QTY_SIZE_SIZE",extendedRecordColumns[j]);
            outputVector.add(rec);
          }
        }else{
          Record rec=(Record)util.MiscFunc.deepCopy(BLANK_ORG_QTY_RECORD);
          rec.set("PRI_SEQ",recClrLixPrx.get(0));
          outputVector.add(rec);
        }
    }
    return outputVector;
  }
}
