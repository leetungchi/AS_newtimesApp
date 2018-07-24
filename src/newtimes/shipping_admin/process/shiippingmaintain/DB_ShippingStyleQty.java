package newtimes.shipping_admin.process.shiippingmaintain;
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

public class DB_ShippingStyleQty extends PagedDataFactoryAdapter {
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
  public static  HashMap PRICE_PK_MAP_COLOR_LICENSEE;
  public static final String _SHOW_LXY_COLOR="_SHOW_LXY_COLOR";
  protected static String unit_string=null;
  protected static int currentOperationPk=-1;
  public static String TAIL_STRING_OF_COLOR_LICENSEE_KEY="###EndOFQtyRecordKey###";
  public DB_ShippingStyleQty() {
    PRICE_PK_MAP_COLOR_LICENSEE=new java.util.HashMap();
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
       currentOperationPk=
          newtimes.shipping_admin.ShippingAdmin_Const.EDIT_SHIP_STYLE_SEQ_INT;
       ShippingMdlEJBs.ShippingQty.ShippingQtyFacadeHome  ejbHome =
          (ShippingMdlEJBs.ShippingQty.ShippingQtyFacadeHome)
          info_ejb.WeblogicServiceLocator.locateServiceHome(
          util.PublicVariable.SERVER_URL,
          "ShippingMdlEJBs.ShippingQty.ShippingQtyFacade"
          );
      ShippingMdlEJBs.ShippingQty.ShippingQtyFacade xejb = ejbHome.create();
     ClrLixPrx=xejb.getClrLixPrx(currentOperationPk );
     if(ClrLixPrx.size()==0){
       exgui.verification.VerifyLib.showPlanMsg(
         "Please Define Style Qty Before Define Qty",
         "Please Define Style Qty  Before Define Qty");
      isInitOk=false;
      return;
     }
         //replace the null data to "N/A", and make the combined column for licensee_color_name
     this.ejb = xejb;
     tempBlankRecord = ejb.getBlankRecord(); //we will append lot cell into it latter.
     BLANK_ORG_QTY_RECORD=(Record)util.MiscFunc.deepCopy(tempBlankRecord);
     tempBlankRecord.set("record_create_user",
                         util.PublicVariable.USER_RECORD.get("usr_code"));
     tempBlankRecord.set("SHIP_STYLE_PK",currentOperationPk);
     tempBlankRecord.set("SHIP_PRICE_PK", ((Record)ClrLixPrx.get(0)).get(0));

      //apppend the blank record to co-responding size columns to the tail of it.
      Record org_sylte_rec = newtimes.shipping_admin.ShippingAdmin_Const.EDITING_SHIPPING_STYLE_RECORD;
      String extClmString=
          (String)org_sylte_rec.get("_$org_sty_size_column");


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

      BLANK_ORG_QTY_RECORD.set("ship_qty_pk",-1);
      BLANK_ORG_QTY_RECORD.set("record_delete_flag",1);
      BLANK_ORG_QTY_RECORD.set("ship_style_pk",currentOperationPk);
      BLANK_ORG_QTY_RECORD.set("record_create_user",
                          util.PublicVariable.USER_RECORD.get("usr_code"));
      unit_string =(String)newtimes.shipping_admin.ShippingAdmin_Const.EDITING_SHIPPING_STYLE_RECORD.get("_$ORG_STYLE_UNIT");
      isInitOk=true;
    }catch(Exception e){
       e.printStackTrace();
       exgui.verification.VerifyLib.showPlanMsg("Server Side Connection Error\nPlease Contact System Manager",
                                                "EJB Creation Erro");
       isInitOk=false;
    }
  }
  public Vector getClrLxyPrxs(){
    try{
      //ClrLixPrx = ((ShippingMdlEJBs.ShippingQty.ShippingQtyFacade)ejb).getClrLixPrx(currentOperationPk);
      return ClrLixPrx;
      //force system to refresh color licensee and price again.
    }catch(Exception e){
      e.printStackTrace();
      util.ExceptionLog.exp2File(e,"exception while get Color Licensee and Price of DB_ShippingQty");
      exgui.verification.VerifyLib.showAlert("Server Side Connection Error\nPlesae Contact System Manager",
                                             "REMOTE EXCEPTION");
      return null;
    }
  }
  protected void makePRICE_PK_MAP_COLOR_LICENSEE()throws Exception{
    if(ClrLixPrx==null||ClrLixPrx.size()==0)getPriSeqMapPrx();
    for(int i=0;i<ClrLixPrx.size();i++){
      Record rec=(Record)ClrLixPrx.get(i);
      StringBuffer sb=new StringBuffer();
      Object licenseeeObj=rec.get("PRI_LICENSEE_NAME");
      String licenseePk=(licenseeeObj==null)?"":licenseeeObj.toString();
      Object prodColorObj=rec.get("PROD_COLOR_PK");
      String prodColorPk=(prodColorObj==null)?"":prodColorObj.toString();
      sb.append("###licenseeKey###");
      sb.append(licenseePk);
      sb.append("###ColorKey###");
      sb.append(prodColorPk);
      sb.append("###sizeKey###");
      //System.out.println("put key: "+rec.get("ship_price_pk").toString()+" and value :"+sb.toString());
      PRICE_PK_MAP_COLOR_LICENSEE.put(rec.get("ship_price_pk").toString(),sb.toString());
    }

  }
  public HashMap getPriSeqMapPrx()throws Exception{
    ClrLixPrx=((ShippingMdlEJBs.ShippingQty.ShippingQtyFacade)ejb).getClrLixPrx(currentOperationPk );
    if(ClrLixPrx.size()==0){
      exgui.verification.VerifyLib.showPlanMsg(
        "Please Define Style Qty Before Define Qty",
        "Please Define Style Qty  Before Define Qty");
        throw  new Exception("qty without pre-defined qty");
    }
        //replace the null data to "N/A", and make the combined column for licensee_color_name
   PRX_ClrLxyPrx=new HashMap();
   //System.out.println("compose the PRX_ClrLxyPrx hashMap");
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
      PRX_ClrLxyPrx.put(rec.get(0).toString(),objPrx);
    }
    return PRX_ClrLxyPrx;
  }
  public void deleteAllQty() throws Exception{
    /*
    ((newtimesejb.production.ColorSizeQtyFacade)ejb).deleteAllQty(
        newtimes.production.ProdMaintain_Properties.
                          CURRENT_SELECTED_STYLE_SEQ_IN_STYLE_LIST,
            (String)util.PublicVariable.USER_RECORD.get("usr_code"));
      newtimes.production.ProdMaintain_Properties.EDITING_STYLE_RECORD.set("STY_QTY_TYPE","12");
      newtimes.production.ProdMaintain_Properties.EDITING_STYLE_RECORD.set("STY_SIZE_COLUMN","");
    */
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
      Record rec=newtimes.shipping_admin.ShippingAdmin_Const.EDITING_SHIPPING_STYLE_RECORD;
      String unit=(String)rec.get("_$ORG_STYLE_UNIT");
      return (unit.toLowerCase().trim().startsWith("dz"));
    }catch(Exception e){
      e.printStackTrace();
      return false;
    }
  }
  public HashMap getBalanceQtyMap()throws Exception{
    HashMap hm= ((ShippingMdlEJBs.ShippingQty.ShippingQtyFacade)ejb).getEachQtyBalance(
      newtimes.shipping_admin.ShippingAdmin_Const.EDIT_SHIP_STYLE_STYLE_INT_SEQ,
      newtimes.shipping_admin.ShippingAdmin_Const.EDIT_SHIP_STYLE_SEQ_INT);
    return hm;
  }
  public boolean isDBHandlerInitOK(){return isInitOk;}
  public Vector getRecords(int bgn,int row)throws Exception{
   makePRICE_PK_MAP_COLOR_LICENSEE();
   int currentMappingRowNo=0;
   mapRec2TblCell.clear();
   Vector convertedRecords=new Vector();
    orgQryRecords = ((ShippingMdlEJBs.ShippingQty.ShippingQtyFacade)ejb).getRecords(
        currentOperationPk,bgn,row);
     //it time to make linear to table now.
  //column to fill..
  //QTY_STY_SEQ, QTY_SIZE_SIZE, QTY_SIZE_SEQ,
  //QTY_PCS, QTY_QTY, PROD_COLOR_PK, PRI_SEQ, QTY_LICENSEE_NAME
  Record rec_org_shipping_style=newtimes.shipping_admin.ShippingAdmin_Const.EDITING_SHIPPING_STYLE_RECORD;
  byte sty_qty_type_num=(byte)rec_org_shipping_style.getInt("_$ORG_STY_QTY_TYPE");
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
              price_seq=rec.get("SHIP_PRICE_PK");
              recBlank2Fill.set("SHIP_STYLE_PK", rec.get("SHIP_STYLE_PK"));
              recBlank2Fill.set("PROD_COLOR_PK", rec.get("PROD_COLOR_PK"));
              recBlank2Fill.set("SHIP_PRICE_PK", rec.get("SHIP_PRICE_PK"));
              //System.out.println("set to displaying records  ship_price_pk="+rec.get("SHIP_PRICE_PK"));
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

          if(sty_qty_type_num==2){//only size & price
          }else{//with licensee or color....,need to fill coresponding price.
            recBlank2Fill.set("SHIP_PRICE_PK",
                              getPriSeqMapPrx().get(price_seq.toString()));
          }

          convertedRecords.add(recBlank2Fill);
          //System.out.println("composed record is:"+recBlank2Fill);
          --i; //adjust.
          currentMappingRowNo++;

        }
        else {
          Record rec = (Record) orgQryRecords.get(i);
          Object price_seq=rec.get("SHIP_PRICE_PK");
          recBlank2Fill.set("SHIP_STYLE_PK", rec.get("SHIP_STYLE_PK"));
          recBlank2Fill.set("PROD_COLOR_PK", rec.get("PROD_COLOR_PK"));
          recBlank2Fill.set("SHIP_PRICE_PK", rec.get("SHIP_PRICE_PK"));
          //System.out.println("set to displaying records ship_price_pk="+rec.get("SHIP_PRICE_PK"));
          recBlank2Fill.set("QTY_LICENSEE_NAME", rec.get("QTY_LICENSEE_NAME"));
          recBlank2Fill.set("_TABLE_ROW_AT", currentMappingRowNo);
          recBlank2Fill.set("_TOTAL_VALUE", Dz2float(rec));
          mapRec2TblCell.put(String.valueOf(i) + "_" + String.valueOf(0), rec);
          recBlank2Fill.set(_SHOW_LXY_COLOR, price_seq);
          if(sty_qty_type_num==8){//only size & price
          }else{//with licensee or color....,need to fill coresponding price.
            recBlank2Fill.set("SHIP_PRICE_PK",
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
    ((ShippingMdlEJBs.ShippingQty.ShippingQtyFacade)ejb).updateStyleQtyDesc(
        currentOperationPk,tbl2Text,
        (String)util.PublicVariable.USER_RECORD.get("usr_code"));
  }
 public void updateRecords(Vector vct2update)throws Exception{
    ((ShippingMdlEJBs.ShippingQty.ShippingQtyFacade)ejb).updateRecords(vct2update);
 }
  public void deleteRecords(Vector vct2delete)throws Exception{
    ((ShippingMdlEJBs.ShippingQty.ShippingQtyFacade)ejb).deleteRecords(vct2delete);
  }
  public Record addRecord(Record rec)throws Exception{
    Record rec2add=getBlankRecord();
    return ((ShippingMdlEJBs.ShippingQty.ShippingQtyFacade)ejb).insertRecord(rec2add);
  }
  static public float Dz2float(Record qtyRec){
    //get qty_qty and pluse pcs with mapping of Dozimal
    try{
     String unit=unit_string;
      if(unit.toLowerCase().trim().startsWith("dz")){
        Object objQty=qtyRec.get("SHIP_QTY");
        Object objPcs=qtyRec.get("QTY_PCS");
        String intPart=(objQty==null)?"0":String.valueOf(Integer.parseInt(objQty.toString()));
        String pcsPart=(objPcs==null)?"0":String.valueOf(Integer.parseInt(objPcs.toString()));
        String decPart=(String)DozeToDecMapping.get(pcsPart);
        return Float.parseFloat(intPart+"."+decPart);
      }else{
        Object obj=qtyRec.get("SHIP_QTY");
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
     String unit=unit_string;
      if(unit.toLowerCase().trim().startsWith("dz")){
          String totalResult=testNoFormater.format(displayValue);
          String  parts[]=util.MiscFunc.split(totalResult,".");
          int pcsValue=
              Integer.parseInt((String)DecToDozeMapping.get(parts[1]));
          int qtyValue=
              Integer.parseInt(parts[0]);
       qtyRec.set("SHIP_QTY",qtyValue);
       qtyRec.set("QTY_PCS",pcsValue);
     }else{
       qtyRec.set("SHIP_QTY",displayValue);
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
    int orgValueDec=(orgValue==0)?0:
        Integer.parseInt((String)DecToDozeMapping.get(orgValueString[1]));

    int addValueInt=(value2add==0)?0:
        Integer.parseInt(value2addString[0]);
    int addValueDec=(value2add==0)?0:
        Integer.parseInt((String)DecToDozeMapping.get(value2addString[1]));
    int totalIntPart=orgValueInt+addValueInt;
    int totalDecPart=(addValueDec+orgValueDec)%12;
    if((addValueDec+orgValueDec)>11){
      ++totalIntPart;
    }
    String totalString=String.valueOf(totalIntPart)+"."+
       (String)DozeToDecMapping.get(String.valueOf(totalDecPart));

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
    int orgValueDec=(orgValue==0)?0:
        Integer.parseInt((String)DecToDozeMapping.get(orgValueString[1]));

    int addValueInt=(value2minus==0)?0:
        Integer.parseInt(value2addString[0]);
    int addValueDec=(value2minus==0)?0:
        Integer.parseInt((String)DecToDozeMapping.get(value2addString[1]));
    int totalIntPart=orgValueInt-addValueInt;
    int totalDecPart=0;
    if(addValueDec>orgValueDec){
      --totalIntPart;
      totalDecPart=(orgValueDec+12-addValueDec)%12;
    }else{
      totalDecPart=(orgValueDec-addValueDec);
    }
    String totalString=String.valueOf(totalIntPart)+"."+
       (String)DozeToDecMapping.get(String.valueOf(totalDecPart));

    return Float.parseFloat(totalString);
  }
  public Vector makeAllBlankQtyData()throws Exception{
    Vector outputVector=new Vector();
    for(int i=0;i<getClrLxyPrxs().size();i++){
      Record recClrLixPrx=(Record)getClrLxyPrxs().get(i);
        if(extendedRecordColumns.length>0){
          for(int j=0;j<extendedRecordColumns.length;j++){
            Record rec=(Record)util.MiscFunc.deepCopy(BLANK_ORG_QTY_RECORD);
            rec.set("SHIP_PRICE_PK",recClrLixPrx.get(0));
            //QTY_STY_SEQ, QTY_SIZE_SIZE
            rec.set("QTY_SIZE_SEQ",j+1);
            rec.set("QTY_SIZE_SIZE",extendedRecordColumns[j]);
            rec.set("SHIP_QTY",0);
            outputVector.add(rec);
          }
        }else{
          Record rec=(Record)util.MiscFunc.deepCopy(BLANK_ORG_QTY_RECORD);
          rec.set("SHIP_PRICE_PK",recClrLixPrx.get(0));
          rec.set("SHIP_QTY",0);
          outputVector.add(rec);
        }
    }
    return outputVector;
  }


}
