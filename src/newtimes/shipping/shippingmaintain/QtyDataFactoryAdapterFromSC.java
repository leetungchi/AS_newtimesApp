package newtimes.shipping.shippingmaintain;

import exgui.ultratable.PagedDataFactoryAdapter;
import java.util.Vector;
import database.datatype.Record;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class QtyDataFactoryAdapterFromSC extends PagedDataFactoryAdapter {
  public Vector colors = null;
  public Vector licensees = null;
  public Vector shipPrices = null;
  public Vector sizeType = null;
  public static java.util.HashMap DozeToDecMapping = null;
  public static java.util.HashMap DecToDozeMapping = null;
  java.util.HashMap hm = (java.util.HashMap)util.ApplicationProperites.getProperties("recDetail");
  private int stySeq = 0;
  static database.datatype.Record rec = null;
  database.datatype.Record recShipQty = null;
  protected Vector vecSizeType = new java.util.Vector();
  protected Vector orgQryRecords = null;
  protected Record tempBlankRecord = null;
  protected Vector sizeShipQty = null;
  protected boolean isInitOk = false;
  protected java.util.HashMap mapRec2TblCell = new java.util.HashMap();
  static java.text.NumberFormat testNoFormater = new java.text.DecimalFormat("######0.00");
  static Vector convRecords = new Vector();

  public QtyDataFactoryAdapterFromSC() {

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
      DozeToDecMapping = new java.util.HashMap();
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

      DecToDozeMapping = new java.util.HashMap();
      DecToDozeMapping.put("08", "1");
      DecToDozeMapping.put("16", "2");
      DecToDozeMapping.put("25", "3");
      DecToDozeMapping.put("33", "4");
      DecToDozeMapping.put("41", "5");
      DecToDozeMapping.put("50", "6");
      DecToDozeMapping.put("58", "7");
      DecToDozeMapping.put("66", "8");
      DecToDozeMapping.put("75", "9");
      DecToDozeMapping.put("83", "10");
      DecToDozeMapping.put("91", "11");
      DecToDozeMapping.put("00", "0");
    }

    try{
      super.ejb = exgui2.CONST.SHIP_QTY_EJB;
      rec = (database.datatype.Record)hm.get("recDetail");
      stySeq = Integer.parseInt(rec.get("STY_SEQ").toString());
      int prodSeq = Integer.parseInt(rec.get("PROD_HEAD_PK").toString());
      Object byerSeq = rec.get("PROD_BUYER");
      if (byerSeq != null) {
        licensees = exgui2.CONST.SHIP_QTY_EJB.getLicensee(Integer.parseInt(byerSeq.toString()));
      } else {
        licensees = new Vector();
      }
      colors = exgui2.CONST.SHIP_QTY_EJB.getColors(prodSeq);
      shipPrices = exgui2.CONST.SHIP_QTY_EJB.getPrice(Integer.parseInt(rec.get("SHIP_STYLE_PK").toString()));
      this.sizeType = exgui2.CONST.SHIP_QTY_EJB.getSizeType(stySeq);
      tempBlankRecord = ejb.getBlankRecord(); //we will append lot cell into it latter.
      tempBlankRecord.getFieldName().add("SHIP_STYLE_PK");
      tempBlankRecord.getValueFields().add(null); //default value is null;
      tempBlankRecord.getFieldName().add("SHIP_PRICE_PK");
      tempBlankRecord.getValueFields().add(null); //default value is null;
      tempBlankRecord.set("record_create_user", util.PublicVariable.USER_RECORD.get("USR_CODE"));
      tempBlankRecord.set("SHIP_STYLE_PK", Integer.parseInt(rec.get("SHIP_STYLE_PK").toString()));
      Record recNullColor = (Record)util.MiscFunc.deepCopy(colors.get(0));
      recNullColor.set(0, null);
      recNullColor.set(1, null);
      recNullColor.set(2, "N/A");
      recNullColor.set(3, "N/A");
      colors.add(recNullColor); //ProdColors Allow Null.
      Record recNullLicensee = null;
      if (!licensees.isEmpty()) {
        recNullLicensee = (Record)util.MiscFunc.deepCopy(licensees.get(0));
        recNullLicensee.set(0, null);
        recNullLicensee.set(1, "N/A");
        recNullLicensee.set(2, "N/A");
      }
      licensees.add(recNullLicensee); //Licensee allow Null
      if (shipPrices.size() == 0) {
        exgui.verification.VerifyLib.showPlanMsg(
            "Please Define Ship Price Bofore this Editing Ship QTY",
            "Message Dialg");
        isInitOk = false;
        return;
      }
      tempBlankRecord.set("SHIP_PRICE_PK", null);

      if (!this.sizeType.isEmpty()) {
        for (int i = 0; i < this.sizeType.size(); i++) {
          database.datatype.Record recSize = (database.datatype.Record)this.sizeType.get(i);
          vecSizeType.add(recSize.get("QTY_SIZE_SIZE"));
        }
      }

      for (int i = 0; i < vecSizeType.size(); i++) {
        tempBlankRecord.getFieldName().add("##" + vecSizeType.get(i));
        tempBlankRecord.getValueFields().add(null); //default value is null;
      }
      tempBlankRecord.getFieldName().add("_TABLE_ROW_AT"); //for latter to mapping.
      tempBlankRecord.getValueFields().add(null);
      tempBlankRecord.getFieldName().add("_TOTAL_VALUE");
      tempBlankRecord.getValueFields().add(null);
      this.blankRecord = tempBlankRecord;
      System.out.println("activate QtyDataFactoryAdapterFromSC");
      isInitOk = true;
    } catch(Exception e) {
      e.printStackTrace();
      isInitOk = false;
      exgui.verification.VerifyLib.showAlert(
          "Server side Connection Failed", "Server side Connection Failed");
    }
  }

  public boolean isDBHandlerInitOK(){
    return isInitOk;
  }

  public java.util.Vector getRecords(int bgn, int rowcount)throws Exception {
    mapRec2TblCell.clear();

    orgQryRecords = exgui2.CONST.SHIP_QTY_EJB.getSizeTypeFromShipQTY(
        Integer.parseInt(rec.get("SHIP_STYLE_PK").toString()),
        this.stySeq);
    if (orgQryRecords.size() == 0 && !ShipDetailEditFromSC.isShipQTY) {
      orgQryRecords = exgui2.CONST.SHIP_QTY_EJB.getSizeTypeFromQTY(this.
          stySeq);
    } else {
      ShipDetailEditFromSC.isShipQTY = true;
      convRecords = this.genRecords(orgQryRecords);
    }
    return convRecords;
  }

  private Vector genRecords(Vector orgQryRecords) throws Exception {
    int currentMappingRowNo = 0;
    Vector convertedRecords = new Vector();
    boolean isDz = isDzUnit();
    for (int i = 0; i < orgQryRecords.size(); i++) {
      Record recBlank2Fill = getBlankRecord();
      if (!vecSizeType.isEmpty()) {
        float xntRowTotalQty = 0;
        for (int j = 0; j < vecSizeType.size(); j++) {
          Record rec = (Record)orgQryRecords.get(i);
          if (j == 0) {
            recBlank2Fill.set("SHIP_STYLE_PK", rec.get("SHIP_STYLE_PK"));
            recBlank2Fill.set("PROD_COLOR_PK", rec.get("PROD_COLOR_PK"));
            recBlank2Fill.set("SHIP_PRICE_PK", rec.get("SHIP_PRICE_PK"));
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
          recBlank2Fill.set("##" + vecSizeType.get(j), convertedQty);
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

      } else {
        Record rec = (Record)orgQryRecords.get(i);
        recBlank2Fill.set("SHIP_STYLE_PK", rec.get("SHIP_STYLE_PK"));
        recBlank2Fill.set("PROD_COLOR_PK", rec.get("PROD_COLOR_PK"));
        recBlank2Fill.set("SHIP_PRICE_PK", rec.get("SHIP_PRICE_PK"));
        recBlank2Fill.set("QTY_LICENSEE_NAME", rec.get("QTY_LICENSEE_NAME"));
        recBlank2Fill.set("_TABLE_ROW_AT", currentMappingRowNo);
        recBlank2Fill.set("_TOTAL_VALUE", Dz2float(rec));
        mapRec2TblCell.put(String.valueOf(i) + "_" + String.valueOf(0), rec);
        convertedRecords.add(recBlank2Fill);
        currentMappingRowNo++;
      }
    }
    if (convertedRecords.size() > 0) {
      //append the blank row for "Total"
      Record recBlank2Fill = getBlankRecord();
      recBlank2Fill.set("_TABLE_ROW_AT", -1); //as key to detern this is a summed row.
      convertedRecords.add(recBlank2Fill);
    }
    return convertedRecords;
  }


  public void deleteRecords(Vector vct2delete) throws Exception {
    exgui2.CONST.SHIP_QTY_EJB.deleteRecords(vct2delete);
  }

  public Record addRecord(Record rec)throws Exception{
    Record rec2add = getBlankRecord();
    Record recInsert = exgui2.CONST.SHIP_QTY_EJB.insertRecord(rec2add, util.PublicVariable.USER_RECORD.get("USR_CODE").toString());
    return recInsert;
  }

  public void udpateQtyTbl2Text(String tbl2Text) throws Exception{
    exgui2.CONST.SHIP_QTY_EJB.updateStyleQtyDesc(
        Integer.parseInt(rec.get("SHIP_STYLE_PK").toString()),
        tbl2Text,(String)util.PublicVariable.USER_RECORD.get("usr_code"));
  }

  public java.util.HashMap getMappedRec2TblCell(){
    return mapRec2TblCell;
  }

  boolean isDzUnit(){
    try{
      String unit = rec.get("STY_UNIT")==null?"":rec.get("STY_UNIT").toString();
      return (unit.toLowerCase().trim().startsWith("dz"));
    }catch(Exception e){
      e.printStackTrace();
      return false;
    }
  }

  static public float Dz2float(Record qtyRec){
    //get qty_qty and pluse pcs with mapping of Dozimal
    try{
      String unit = rec.get("STY_UNIT")==null?"":rec.get("STY_UNIT").toString();
      if (unit.toLowerCase().trim().startsWith("dz")) {
        Object objQty = qtyRec.get("SHIP_QTY");
        Object objPcs = qtyRec.get("QTY_PCS");
        String intPart = (objQty == null) ? "0" : String.valueOf(Integer.parseInt(objQty.toString()));
        String pcsPart= (objPcs == null) ? "0" : String.valueOf(Integer.parseInt(objPcs.toString()));
        String decPart= (String)DozeToDecMapping.get(pcsPart);
        return Float.parseFloat(intPart + "." + decPart);
      } else {
        Object obj = qtyRec.get("SHIP_QTY");
        return (obj == null) ? 0 : Float.parseFloat(obj.toString());
      }
    } catch(Exception e) {
      e.printStackTrace();
      return 0;
    }
  }

  static public void Dz2Record(Record qtyRec, String displayValue){
    Dz2Record(qtyRec, Float.parseFloat(displayValue));
  }

  static public void Dz2Record(Record qtyRec, float displayValue){
    try {
      String unit = rec.get("STY_UNIT")==null?"":rec.get("STY_UNIT").toString();
      if (unit.toLowerCase().trim().startsWith("dz")) {
        String totalResult = testNoFormater.format(displayValue);
        String  parts[] = util.MiscFunc.split(totalResult, ".");
        int pcsValue =
              Integer.parseInt((String)DecToDozeMapping.get(parts[1]));
        int qtyValue =
              Integer.parseInt(parts[0]);
        qtyRec.set("SHIP_QTY", qtyValue);
        qtyRec.set("QTY_PCS", pcsValue);
      } else {
        qtyRec.set("SHIP_QTY", displayValue);
      }
    } catch(Exception e) {
      e.printStackTrace();
    }
  }

  static public float addDzValue(float orgValue, float value2add){
    //assumed "unit" of current style record is detected by cell format checker.
    String orgValueString[] =
        util.MiscFunc.split(testNoFormater.format(orgValue), ".");
    String value2addString[] =
        util.MiscFunc.split(testNoFormater.format(value2add), ".");

    int orgValueInt = (orgValue == 0) ? 0 :
        Integer.parseInt(orgValueString[0]);
    int orgValueDec = (orgValue == 0) ? 0 :
        Integer.parseInt((String)DecToDozeMapping.get(orgValueString[1]));
    int addValueInt = (value2add == 0) ? 0 :
        Integer.parseInt(value2addString[0]);
    int addValueDec = (value2add == 0) ? 0 :
        Integer.parseInt((String)DecToDozeMapping.get(value2addString[1]));
    int totalIntPart = orgValueInt + addValueInt;
    int totalDecPart = (addValueDec + orgValueDec) % 12;
    if ((addValueDec + orgValueDec) > 11)  {
      ++ totalIntPart;
    }
    String totalString = String.valueOf(totalIntPart) + "." +
       (String)DozeToDecMapping.get(String.valueOf(totalDecPart));

    return Float.parseFloat(totalString);
  }

  static public float minusDzValue(float orgValue, float value2minus){
    //assumed "unit" of current style record is detected by cell format checker.
    String orgValueString[] =
        util.MiscFunc.split(testNoFormater.format(orgValue), ".");
    String value2addString[] =
        util.MiscFunc.split(testNoFormater.format(value2minus), ".");

    int orgValueInt = (orgValue == 0) ? 0 :
        Integer.parseInt(orgValueString[0]);
    int orgValueDec = (orgValue == 0) ? 0 :
        Integer.parseInt((String)DecToDozeMapping.get(orgValueString[1]));

    int addValueInt = (value2minus == 0) ? 0 :
        Integer.parseInt(value2addString[0]);
    int addValueDec = (value2minus == 0) ? 0 :
        Integer.parseInt((String)DecToDozeMapping.get(value2addString[1]));
    int totalIntPart = orgValueInt - addValueInt;
    int totalDecPart = 0;
    if (addValueDec > orgValueDec) {
      -- totalIntPart;
      totalDecPart = (orgValueDec + 12 - addValueDec) % 12;
    } else {
      totalDecPart = (orgValueDec - addValueDec);
    }
    String totalString = String.valueOf(totalIntPart) + "." +
       (String)DozeToDecMapping.get(String.valueOf(totalDecPart));

    return Float.parseFloat(totalString);
  }
}
