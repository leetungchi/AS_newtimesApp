package newtimes.shipping_admin.process.packing;
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

public class DB_ShipStylePacking extends PagedDataFactoryAdapter {
  public Vector ProdColors=null;
  public Vector Cartons=null;
  protected HashMap mapRec2TblCell=new HashMap();
  protected Record tempBlankRecord;
  protected boolean isInitOk=false;
  protected String[] extendedRecordColumns;
  protected Vector orgQryRecords=null;
  protected util.InsertionOrderedHashMap mappedColumName=new util.InsertionOrderedHashMap();//this object is created while records are retrived
  static public  HashMap DozeToDecMapping=null;
  static public HashMap DecToDozeMapping=null;
  public Record BLANK_ORG_QTY_RECORD=null;
  public java.util.HashMap CARTON_REC_MAP=null;
  public static java.text.NumberFormat testNoFormater=new java.text.DecimalFormat("######0.00");
  int iniPriSeq=0;
  public Record recShipStyle=null;
  public Record recOrgStyle=null;
  public int ship_style_pk=-1;
  public int org_po_style_pk=-1;
  public Vector vct2updateTempStay;
  protected Record blankPriceAndCartonCombinedRec=null;
  public int appendRowIndex=0;
  public boolean is2Append=false;
  public Vector vct2append=null;
  public DB_ShipStylePacking(Record _recShipStyle) {
    org_po_style_pk=_recShipStyle.getInt(2);
    recShipStyle=_recShipStyle;
    ship_style_pk=recShipStyle.getInt(0);
    try{
      recOrgStyle = (new newtimes.production.process.prodmaintain.DB_StyleMisc()).getRecordByPk(org_po_style_pk);
    }catch(Exception exp){
      exp.printStackTrace();
      util.ExceptionLog.exp2File(exp,"");
    }
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
      newtimesejb.packing.PackingFacaodeHome  ejbHome =
          (newtimesejb.packing.PackingFacaodeHome)
          info_ejb.WeblogicServiceLocator.locateServiceHome(
          util.PublicVariable.SERVER_URL,
          "newtimesejb.packing.PackingFacaode"
          );
      newtimesejb.packing.PackingFacaode xejb = ejbHome.create();
      CARTON_REC_MAP=new java.util.HashMap();
      if(ProdColors!=null){
        ProdColors.clear();
        ProdColors.addElement(xejb.getProdColors(recOrgStyle.getInt(1)));
      }else{
        ProdColors = xejb.getProdColors(recOrgStyle.getInt(1));
      }
      Record orgTmpPriceRec=xejb.getOrgPrice(recOrgStyle.getInt(0));
      iniPriSeq=-1;
      int lastPricePk=0;
      if(iniPriSeq==-1)iniPriSeq=lastPricePk;
      this.ejb = xejb;
      tempBlankRecord = ejb.getBlankRecord(); //we will append lot cell into it latter.
      BLANK_ORG_QTY_RECORD=(Record)util.MiscFunc.deepCopy(tempBlankRecord);
      tempBlankRecord.set("record_create_user",
                         util.PublicVariable.USER_RECORD.get("usr_code"));
      tempBlankRecord.set("SHIP_STYLE_PK",
                         newtimes.production.ProdMaintain_Properties.
                         CURRENT_SELECTED_STYLE_SEQ_IN_STYLE_LIST);


      //apppend the blank record to co-responding size columns to the tail of it.
      String extClmString=
          (String)recShipStyle.get("SHIP_STY_SIZE_COLUMN");
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

      //tempBlankRecord.getFieldName().add(_SHOW_LXY_COLOR);//for latter to mapping.
      //tempBlankRecord.getValueFields().add(null);

      makeBlankPriceAndCartonRec();


      tempBlankRecord.getFieldName().add("$$PROD_COLOR_PK");//for latter to mapping.
      tempBlankRecord.getValueFields().add(orgTmpPriceRec.get("PROD_COLOR_PK"));;//null);
      blankPriceAndCartonCombinedRec.set("PROD_COLOR_PK",orgTmpPriceRec.get("PROD_COLOR_PK"));

      tempBlankRecord.getFieldName().add("$$PRI_LICENSEE_NAME");//for latter to mapping.
      tempBlankRecord.getValueFields().add(orgTmpPriceRec.get("PRI_LICENSEE_NAME"));//null);
      blankPriceAndCartonCombinedRec.set("PRI_LICENSEE_NAME",orgTmpPriceRec.get("PRI_LICENSEE_NAME"));

      //PRI_BYR_ACT_PRX, PRI_BYR_DOC_PRX, PRI_MKR_ACT_PRX, PRI_MKR_DOC_PRX,PROD_COLOR_PK, PRI_LICENSEE_NAME
      tempBlankRecord.getFieldName().add("$$PRI_BYR_ACT_PRX");//for latter to mapping.
      tempBlankRecord.getValueFields().add(orgTmpPriceRec.get("PRI_BYR_ACT_PRX"));//null);
      blankPriceAndCartonCombinedRec.set("PRI_BYR_ACT_PRX",orgTmpPriceRec.get("PRI_BYR_ACT_PRX"));

      tempBlankRecord.getFieldName().add("$$PRI_BYR_DOC_PRX");//for latter to mapping.
      tempBlankRecord.getValueFields().add(orgTmpPriceRec.get("PRI_BYR_DOC_PRX"));//null);
      blankPriceAndCartonCombinedRec.set("PRI_BYR_DOC_PRX",orgTmpPriceRec.get("PRI_BYR_DOC_PRX"));

      tempBlankRecord.getFieldName().add("$$PRI_MKR_ACT_PRX");//for latter to mapping.
      tempBlankRecord.getValueFields().add(orgTmpPriceRec.get("PRI_MKR_ACT_PRX"));//null);
      blankPriceAndCartonCombinedRec.set("PRI_MKR_ACT_PRX",orgTmpPriceRec.get("PRI_MKR_ACT_PRX"));


      tempBlankRecord.getFieldName().add("$$PRI_MKR_DOC_PRX");//for latter to mapping.
      tempBlankRecord.getValueFields().add(orgTmpPriceRec.get("PRI_MKR_DOC_PRX"));//null);
      blankPriceAndCartonCombinedRec.set("PRI_MKR_DOC_PRX",orgTmpPriceRec.get("PRI_MKR_DOC_PRX"));

      tempBlankRecord.getFieldName().add("@@CTN_PK");
      tempBlankRecord.getValueFields().add(null);

      tempBlankRecord.getFieldName().add("@@BGN_CTN");
      tempBlankRecord.getValueFields().add(null);

      tempBlankRecord.getFieldName().add("@@END_CTN");
      tempBlankRecord.getValueFields().add(null);

      tempBlankRecord.getFieldName().add("@@NET_WT");
      tempBlankRecord.getValueFields().add(null);

      tempBlankRecord.getFieldName().add("@@GROSS_WT");
      tempBlankRecord.getValueFields().add(null);

      tempBlankRecord.getFieldName().add("@@NNW");
      tempBlankRecord.getValueFields().add(null);

      tempBlankRecord.getFieldName().add("@@MEAS");
      tempBlankRecord.getValueFields().add(null);

      tempBlankRecord.getFieldName().add("@@MEAS_UNIT");
      tempBlankRecord.getValueFields().add("CM");
      blankPriceAndCartonCombinedRec.set("MEAS_UNIT","CM");

      tempBlankRecord.getFieldName().add("@@CBM");
      tempBlankRecord.getValueFields().add(null);
      //MEAS_W, MEAS_L, MEAS_H, WT_UNIT
      tempBlankRecord.getFieldName().add("@@MEAS_W");
      tempBlankRecord.getValueFields().add(null);

      tempBlankRecord.getFieldName().add("@@MEAS_L");
      tempBlankRecord.getValueFields().add(null);

      tempBlankRecord.getFieldName().add("@@MEAS_H");
      tempBlankRecord.getValueFields().add(null);

      tempBlankRecord.getFieldName().add("@@WT_UNIT");
      tempBlankRecord.getValueFields().add("KG");
      blankPriceAndCartonCombinedRec.set("WT_UNIT","KG");

      tempBlankRecord.set("@@CTN_PK",-1);
      tempBlankRecord.set("SHIP_PRICE_PK",-1);
      blankPriceAndCartonCombinedRec.set("SHIP_PRICE_PK",-1);
      blankPriceAndCartonCombinedRec.set("CTN_PK",-1);



      this.blankRecord=tempBlankRecord;

      BLANK_ORG_QTY_RECORD.set("ship_qty_pk",-1);
      BLANK_ORG_QTY_RECORD.set("record_delete_flag",1);
      BLANK_ORG_QTY_RECORD.set("SHIP_STYLE_PK",
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
  protected void makeBlankPriceAndCartonRec()throws Exception{
    Record blankShipPrice=exgui2.CONST.BASIC_MAIN_EJB.getBlankRecord("ship_price_tbl");
    Record blankCarton=exgui2.CONST.BASIC_MAIN_EJB.getBlankRecord("ship_carton_tbl");
    //select a.*,b.* from ship_price a,packing_carton b where a.ship_price_pk =b.ship_price_pk and a.ship_style_pk="+shipStySeq
    blankPriceAndCartonCombinedRec=(Record)util.MiscFunc.deepCopy(blankShipPrice);
    blankPriceAndCartonCombinedRec.getFieldName().addAll(blankCarton.getFieldName()) ;
    blankPriceAndCartonCombinedRec.getValueFields().addAll(blankCarton.getValueFields());
    blankPriceAndCartonCombinedRec.set("ship_price_pk",-1);
  }
  //public HashMap getPriSeqMapPrx(){return PRX_ClrLxyPrx;}
  public void reGenProdColors()throws Exception{
    if(ProdColors!=null){
      ProdColors.clear();
      ProdColors.addElement(((newtimesejb.packing.PackingFacaode)ejb).getProdColors(recOrgStyle.getInt(1)));
    }else{
      ProdColors = ((newtimesejb.packing.PackingFacaode)ejb).getProdColors(recOrgStyle.getInt(1));
    }
  }
  public void deleteAllQty() throws Exception{
     return;
     /*
    ((newtimesejb.packing.PackingFacaode)ejb).deleteAllQty(
        newtimes.production.ProdMaintain_Properties.
                          CURRENT_SELECTED_STYLE_SEQ_IN_STYLE_LIST,
            (String)util.PublicVariable.USER_RECORD.get("usr_code"));
      recShipStyle.set("STY_QTY_TYPE","12");
      recShipStyle.set("SHIP_STY_SIZE_COLUMN","");
    */
  }
  /**
   * obtain the stored stored mapping record ,for update & delete......
   * @return HashMap,key is "row_NoOfExtendedRecordColumns",value is orginal Store Record
   */
  public HashMap getMappedRec2TblCell(){
    return mapRec2TblCell;
  }
  public void clearAllCartons()throws Exception{
    ((newtimesejb.packing.PackingFacaode)ejb).deleteAllCartons(
      recShipStyle.getInt(0),(String)util.PublicVariable.USER_RECORD.get("usr_code"));
  }
  public void force2regetPriceCartonRecords()throws Exception{
    //CARTON_REC_MAP=new HashMap();
    if(CARTON_REC_MAP!=null)CARTON_REC_MAP.clear();
    Cartons=new Vector();
    Vector Prices=((newtimesejb.packing.PackingFacaode)ejb).getCartonPrice(ship_style_pk);
    //CARTON_REC_MAP.put(String.valueOf(-1), blankPriceAndCartonCombinedRec);
     if(Prices.size()==0){
       CARTON_REC_MAP.put(String.valueOf(-1), blankPriceAndCartonCombinedRec);
       Cartons.add(blankPriceAndCartonCombinedRec);
     }else{
       for (int i = 0; i < Prices.size(); i++) {
         Record recPrx = (Record)Prices.get(i);
         if (recPrx.get("prod_color_pk") != null && iniPriSeq == -1)iniPriSeq =
             recPrx.getInt(0);
         CARTON_REC_MAP.put(String.valueOf(recPrx.getInt(0)), recPrx);
         Cartons.add(recPrx);
       }
     }
  }

  public void updateRecords(Vector vct2update)throws Exception{
    vct2updateTempStay=new java.util.Vector();
    vct2updateTempStay.addAll(vct2update);
  }
  protected boolean isDzUnit(){
    try{
      String unit=(String)
       recOrgStyle.get("STY_UNIT");
      return (unit.toLowerCase().trim().startsWith("dz"));
    }catch(Exception e){
      e.printStackTrace();
      return false;
    }
  }
  public boolean isDBHandlerInitOK(){return isInitOk;}
  public Vector getRecordsWitAppends(int bgn,int row,boolean is2Append)throws Exception{
    //recOrgStyle.getInt("STY_QTY_TYPE");
  int currentMappingRowNo=0;
  mapRec2TblCell.clear();

  Vector convertedRecords=new Vector();
   orgQryRecords = ((newtimesejb.packing.PackingFacaode)ejb).getRecords(
       ship_style_pk ,bgn,row);
    //it time to make linear to table now.
 //column to fill..
 //SHIP_STYLE_PK, QTY_SIZE_SIZE, QTY_SIZE_SEQ,
 //QTY_PCS, QTY_QTY, PROD_COLOR_PK, SHIP_PRICE_PK, QTY_LICENSEE_NAME
   //if(orgQryRecords.size()==0) orgQryRecords=makeAllBlankQtyData();//make all required blank data directly for user
   vct2append=null;
   if(orgQryRecords.size()==0){
     orgQryRecords=makeBlankQtyData2Append(0); //makeAllBlankQtyData();
     vct2append=orgQryRecords;
     appendRowIndex=0;
     newtimes.shipping_admin.ShippingAdmin_Const.SHIPPING_EDIT_PANEL.setButtons(false,true,true,true,false);
   }else{
     //isDisplayingDummyRows=false;
     newtimes.shipping_admin.ShippingAdmin_Const.SHIPPING_EDIT_PANEL.setButtons(true,true,true,true,true);
     appendRowIndex=((extendedRecordColumns.length==0)?orgQryRecords.size():orgQryRecords.size()/extendedRecordColumns.length);
      if(is2Append){
         vct2append=makeBlankQtyData2Append(appendRowIndex);
         orgQryRecords.addAll(vct2append);
      }
    }
   force2regetPriceCartonRecords();

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
             recBlank2Fill.set("QTY_LICENSEE_NAME",
                               rec.get("QTY_LICENSEE_NAME"));
             //recBlank2Fill.set("_TABLE_ROW_AT", currentMappingRowNo);
             //System.out.println("put into :"+String.valueOf(currentMappingRowNo) + "_" + String.valueOf(j)+"      RECORD="+rec.toString() );

             mapRec2TblCell.put(String.valueOf(currentMappingRowNo) + "_" +
                                String.valueOf(j), rec);

             Record storedPriceRec=(Record)CARTON_REC_MAP.get(String.valueOf(price_seq));
             if(storedPriceRec==null){
               storedPriceRec = (Record)Cartons.get(0);
               storedPriceRec.set("CTN_PK",-1);
             }

             recBlank2Fill.set("$$PROD_COLOR_PK",storedPriceRec.get("PROD_COLOR_PK"));
             recBlank2Fill.set("$$PRI_LICENSEE_NAME",storedPriceRec.get("PRI_LICENSEE_NAME"));
             recBlank2Fill.set("$$PRI_BYR_ACT_PRX",storedPriceRec.get("PRI_BYR_ACT_PRX"));
             recBlank2Fill.set("$$PRI_BYR_DOC_PRX",storedPriceRec.get("PRI_BYR_DOC_PRX"));
             recBlank2Fill.set("$$PRI_MKR_ACT_PRX",storedPriceRec.get("PRI_MKR_ACT_PRX"));
             recBlank2Fill.set("$$PRI_MKR_DOC_PRX",storedPriceRec.get("PRI_MKR_DOC_PRX"));
             Object objCtnPk=storedPriceRec.get("CTN_PK");
             recBlank2Fill.set("@@CTN_PK",storedPriceRec.get("CTN_PK"));
             if(objCtnPk==null || objCtnPk.toString().trim().equals("-1")){
               recBlank2Fill.set("@@BGN_CTN",null);
               recBlank2Fill.set("@@END_CTN",null);
               recBlank2Fill.set("@@NET_WT",null);
               recBlank2Fill.set("@@GROSS_WT",null);
               recBlank2Fill.set("@@NNW",null);
               recBlank2Fill.set("@@MEAS",null);
               recBlank2Fill.set("@@MEAS_UNIT",storedPriceRec.get("MEAS_UNIT"));
               recBlank2Fill.set("@@CBM",null);
               //MEAS_W, MEAS_L, MEAS_H, WT_UNIT
               recBlank2Fill.set("@@MEAS_W",null);
               recBlank2Fill.set("@@MEAS_L",null);
               recBlank2Fill.set("@@MEAS_H",null);
               recBlank2Fill.set("@@WT_UNIT",storedPriceRec.get("WT_UNIT"));
             }else{
               recBlank2Fill.set("@@BGN_CTN",storedPriceRec.get("BGN_CTN"));
               recBlank2Fill.set("@@END_CTN",storedPriceRec.get("END_CTN"));
               recBlank2Fill.set("@@NET_WT",storedPriceRec.get("NET_WT"));
               recBlank2Fill.set("@@GROSS_WT",storedPriceRec.get("GROSS_WT"));
               recBlank2Fill.set("@@NNW",storedPriceRec.get("NNW"));
               recBlank2Fill.set("@@MEAS",storedPriceRec.get("MEAS"));
               recBlank2Fill.set("@@MEAS_UNIT",storedPriceRec.get("MEAS_UNIT"));
               recBlank2Fill.set("@@CBM",storedPriceRec.get("CBM"));
               //MEAS_W, MEAS_L, MEAS_H, WT_UNIT
               recBlank2Fill.set("@@MEAS_W",storedPriceRec.get("MEAS_W"));
               recBlank2Fill.set("@@MEAS_L",storedPriceRec.get("MEAS_L"));
               recBlank2Fill.set("@@MEAS_H",storedPriceRec.get("MEAS_H"));
               recBlank2Fill.set("@@WT_UNIT",storedPriceRec.get("WT_UNIT"));

             }

           }
           //System.out.println("put into :"+String.valueOf(currentMappingRowNo) + "_" + String.valueOf(j)+"      RECORD="+rec.toString() );
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
         convertedRecords.add(recBlank2Fill);
         --i; //adjust.
         currentMappingRowNo++;
       }
       else {
         Record rec = (Record) orgQryRecords.get(i);
         Object price_seq=rec.get("SHIP_PRICE_PK");
         //System.out.println("price_seq="+price_seq.toString());
         recBlank2Fill.set("SHIP_STYLE_PK", rec.get("SHIP_STYLE_PK"));
         recBlank2Fill.set("PROD_COLOR_PK", rec.get("PROD_COLOR_PK"));
         recBlank2Fill.set("PROD_COLOR_PK", rec.get("PROD_COLOR_PK"));
         recBlank2Fill.set("SHIP_PRICE_PK", rec.get("SHIP_PRICE_PK"));
         recBlank2Fill.set("QTY_LICENSEE_NAME", rec.get("QTY_LICENSEE_NAME"));
         recBlank2Fill.set("_TABLE_ROW_AT", currentMappingRowNo);
         recBlank2Fill.set("_TOTAL_VALUE", Dz2float(rec));

         Record storedPriceRec=(Record)CARTON_REC_MAP.get(String.valueOf(price_seq));
         if(storedPriceRec==null){
           storedPriceRec=(Record)Cartons.get(0);
           storedPriceRec.set("CTN_PK",-1);
           System.out.println("Error!!===>price pk "+String.valueOf(price_seq)+" look up result is null");
         }
         recBlank2Fill.set("$$PROD_COLOR_PK",storedPriceRec.get("PROD_COLOR_PK"));
         recBlank2Fill.set("$$PRI_LICENSEE_NAME",storedPriceRec.get("PRI_LICENSEE_NAME"));
         recBlank2Fill.set("$$PRI_BYR_ACT_PRX",storedPriceRec.get("PRI_BYR_ACT_PRX"));
         recBlank2Fill.set("$$PRI_BYR_DOC_PRX",storedPriceRec.get("PRI_BYR_DOC_PRX"));
         recBlank2Fill.set("$$PRI_MKR_ACT_PRX",storedPriceRec.get("PRI_MKR_ACT_PRX"));
         recBlank2Fill.set("$$PRI_MKR_DOC_PRX",storedPriceRec.get("PRI_MKR_DOC_PRX"));
         recBlank2Fill.set("@@CTN_PK",storedPriceRec.get("CTN_PK"));
         Object objCtnPk=storedPriceRec.get("CTN_PK");
         if(objCtnPk==null || objCtnPk.toString().trim().equals("-1")){
           recBlank2Fill.set("@@BGN_CTN",null);
           recBlank2Fill.set("@@END_CTN",null);
           recBlank2Fill.set("@@NET_WT",null);
           recBlank2Fill.set("@@GROSS_WT",null);
           recBlank2Fill.set("@@NNW",null);
           recBlank2Fill.set("@@MEAS",null);
           recBlank2Fill.set("@@MEAS_UNIT",storedPriceRec.get("MEAS_UNIT"));
           recBlank2Fill.set("@@CBM",null);
           //MEAS_W, MEAS_L, MEAS_H, WT_UNIT
           recBlank2Fill.set("@@MEAS_W",null);
           recBlank2Fill.set("@@MEAS_L",null);
           recBlank2Fill.set("@@MEAS_H",null);
           recBlank2Fill.set("@@WT_UNIT",storedPriceRec.get("WT_UNIT"));

         }else{
           recBlank2Fill.set("@@BGN_CTN",storedPriceRec.get("BGN_CTN"));
           recBlank2Fill.set("@@END_CTN",storedPriceRec.get("END_CTN"));
           recBlank2Fill.set("@@NET_WT",storedPriceRec.get("NET_WT"));
           recBlank2Fill.set("@@GROSS_WT",storedPriceRec.get("GROSS_WT"));
           recBlank2Fill.set("@@NNW",storedPriceRec.get("NNW"));
           recBlank2Fill.set("@@MEAS",storedPriceRec.get("MEAS"));
           recBlank2Fill.set("@@MEAS_UNIT",storedPriceRec.get("MEAS_UNIT"));
           recBlank2Fill.set("@@CBM",storedPriceRec.get("CBM"));
           //MEAS_W, MEAS_L, MEAS_H, WT_UNIT
           recBlank2Fill.set("@@MEAS_W",storedPriceRec.get("MEAS_W"));
           recBlank2Fill.set("@@MEAS_L",storedPriceRec.get("MEAS_L"));
           recBlank2Fill.set("@@MEAS_H",storedPriceRec.get("MEAS_H"));
           recBlank2Fill.set("@@WT_UNIT",storedPriceRec.get("WT_UNIT"));

         }



         //System.out.println("put into :"+String.valueOf(i) + "_" + String.valueOf(0)+"      RECORD="+rec.toString() );

         mapRec2TblCell.put(String.valueOf(i) + "_" + String.valueOf(0), rec);
         //recBlank2Fill.set(_SHOW_LXY_COLOR, price_seq);
         recBlank2Fill.set("SHIP_PRICE_PK",price_seq.toString());
         convertedRecords.add(recBlank2Fill);
         currentMappingRowNo++;
       }
     }

     is2Append=false;
  return convertedRecords;
  }
  public Vector getRecords(int bgn,int row)throws Exception{
    return getRecordsWitAppends(bgn,row,this.is2Append);
  }
  public void udpateQtyTbl2Text(String tbl2Text) throws Exception{
  return;/*
    ((newtimesejb.packing.PackingFacaode)ejb).updateStyleQtyDesc(
        newtimes.production.ProdMaintain_Properties.CURRENT_SELECTED_STYLE_SEQ_IN_STYLE_LIST,
        tbl2Text,
        (String)util.PublicVariable.USER_RECORD.get("usr_code"));*/
  }
 public void updatePriceCartonQty(Vector qtys)throws Exception{
   //some  field of co-responding ship style record is modified,also have to be modified in the database.
   if(recShipStyle.getModifiedFields().size()>0){
     ((newtimesejb.packing.PackingFacaode)ejb).updatePriceCarTonAndQty(
         vct2updateTempStay, qtys,recShipStyle);
        recShipStyle.getModifiedFields().clear();
   }else{
     ((newtimesejb.packing.PackingFacaode)ejb).updatePriceCarTonAndQty(
         vct2updateTempStay, qtys,null);
   }
 }
  public void deleteRecords(Vector vct2delete)throws Exception{
    for(int i=0;i<vct2delete.size();i++){
      Record rec = (Record)vct2delete.get(i);
          ((newtimesejb.packing.PackingFacaode)ejb).deleteRecord(rec);
    }
  }
  public Record addRecords(Vector recs)throws Exception{
    if(recs==null||recs.size()==0)return null;
    //Record rec2add=(Record)recs.get(0);
    if(recShipStyle.getInt(0)>0){
      //rec2add.set("ship_style_pk",recShipStyle.getInt(0));
      return ((newtimesejb.packing.PackingFacaode)ejb).insertRecord(null,recs);
    }else{
      Record recdest=((newtimesejb.packing.PackingFacaode)ejb).insertRecord(recShipStyle,recs);
      ship_style_pk=recdest.getInt("ship_style_pk");
      recShipStyle=(Record)
           exgui2.CONST.BASIC_MAIN_EJB.getDatas(util.PublicVariable.USER_RECORD,
                                                "select * from ship_style where ship_style_pk="+ship_style_pk,1,1
                                                ).get(0);
      blankRecord.set("ship_style_pk",ship_style_pk);
      return recdest;
    }
  }
  public Record addRecord(Record rec)throws Exception{
    Record rec2add=((rec==null)?getBlankRecord():rec);
    //rec2add.set("SHIP_PRICE_PK",iniPriSeq);
    if(recShipStyle.getInt(0)>0){
      rec2add.set("ship_style_pk",recShipStyle.getInt(0));
      return ((newtimesejb.packing.PackingFacaode)ejb).insertRecord(null,rec2add);
    }else{
      Record recdest=((newtimesejb.packing.PackingFacaode)ejb).insertRecord(recShipStyle,rec2add);
      ship_style_pk=recdest.getInt("ship_style_pk");
      recShipStyle=(Record)
           exgui2.CONST.BASIC_MAIN_EJB.getDatas(util.PublicVariable.USER_RECORD,
                                                "select * from ship_style where ship_style_pk="+ship_style_pk,1,1
                                                ).get(0);
      blankRecord.set("ship_style_pk",ship_style_pk);
      return recdest;
    }
  }
   public float Dz2float(Record qtyRec){
    //get qty_qty and pluse pcs with mapping of Dozimal
    try{

     String unit=(String)
      recOrgStyle.get("STY_UNIT");
      if(unit.toLowerCase().trim().startsWith("dz")){
        Object objQty=qtyRec.get("SHIP_QTY");
        Object objPcs=qtyRec.get("QTY_PCS");
        String intPart=(objQty==null)?"0":String.valueOf(Integer.parseInt(util.MiscFunc.split(objQty.toString(),".")[0]));
        String pcsPart=(objPcs==null)?"0":String.valueOf(Integer.parseInt(objPcs.toString()));
        String decPart=(String)DozeToDecMapping.get(pcsPart);
        if(decPart==null)decPart="0";
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
   public void Dz2Record(Record qtyRec,String displayValue){
    if(displayValue==null||displayValue.trim().length()==0){
      Dz2Record(qtyRec,0);
    }else
    Dz2Record(qtyRec,Float.parseFloat(displayValue));
  }
   public void Dz2Record(Record qtyRec,float displayValue){
    try{
     String unit=(String)
      recOrgStyle.get("STY_UNIT");
      if(unit.toLowerCase().trim().startsWith("dz")){
          String totalResult=testNoFormater.format(displayValue);
          String  parts[]=util.MiscFunc.split(totalResult,".");
          String tmpStr=
              (String)DecToDozeMapping.get(parts[1]);

          int pcsValue=
              Integer.parseInt((tmpStr==null)?"0":tmpStr);

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
   public float addDzValue(float orgValue,float value2add){
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
   public float minusDzValue(float orgValue,float value2minus){
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
  public void deleteShipStyle(Record recShipStyle)throws Exception{
    ((newtimesejb.packing.PackingFacaode)ejb).deleteShipStyleRecord(recShipStyle);
  }
  public Vector makeBlankQtyData2Append(int rowBeginIndex)throws Exception{
    Vector outputVector=new Vector();
    //for(int i=0;i<Cartons.size();i++){
    //if(BLANK_ORG_QTY_RECORD.getInt("ship_style_pk")==0){
      BLANK_ORG_QTY_RECORD.set("ship_style_pk",recShipStyle.getInt(0));
    //}
    for(int i=rowBeginIndex;i<40+rowBeginIndex;i++){
      Record blankTempShipPriceRec=(Record)util.MiscFunc.deepCopy(blankPriceAndCartonCombinedRec);
      CARTON_REC_MAP.put(String.valueOf(-1*(i+1)),blankTempShipPriceRec);
      //Record recClrLixPrx=(Record)Cartons.get(0);
        if(extendedRecordColumns.length>0){
          for(int j=0;j<extendedRecordColumns.length;j++){
            Record rec=(Record)util.MiscFunc.deepCopy(BLANK_ORG_QTY_RECORD);
            //rec.set("SHIP_PRICE_PK",recClrLixPrx.get(0));
            rec.set("SHIP_PRICE_PK",-1*(i+1));
            //SHIP_STYLE_PK, QTY_SIZE_SIZE
            rec.set("QTY_SIZE_SEQ",j+1);
            rec.set("SHIP_QTY",null);
            rec.set("QTY_SIZE_SIZE",extendedRecordColumns[j]);
            outputVector.add(rec);
          }
        }else{
          Record rec=(Record)util.MiscFunc.deepCopy(BLANK_ORG_QTY_RECORD);
          //rec.set("SHIP_PRICE_PK",recClrLixPrx.get(0));
          rec.set("SHIP_QTY",null);
          rec.set("SHIP_PRICE_PK",-1*(i+1));
          outputVector.add(rec);
        }
    }
    return outputVector;
  }
  public Vector makeAllBlankQtyData()throws Exception{
    return makeBlankQtyData2Append(0);
  }
}
