package newtimes.production.gui.prodmaintain;

import util.InsertionOrderedHashMap;
import exgui.ultratable.*;
import java.util.Hashtable;

public class PnlStyHangTagList extends PnlStyMiscList {
  //STY_HTG_NO1, STY_HTG_NO2, STY_HTG_NO3,
 // STY_HTG_QTY1, STY_HTG_QTY2, STY_HTG_QTY3,
  //STY_HTG_RCVD_DD1, STY_HTG_RCVD_DD2, STY_HTG_RCVD_DD3
  static String DISP_GRP_HANGTAG_1="HANG TAG I.";
  static String DISP_GRP_HANGTAG_2="HANG TAG II.";
  static String DISP_GRP_HANGTAG_3="HANG TAG III.";

  static String DISP_STY_HTG_NO1="HTG-NO ";
  static String DISP_STY_HTG_NO2=" HTG-NO";
  static String DISP_STY_HTG_NO3="HTG-NO";
  static String CLM_STY_HTG_NO1="STY_HTG_NO1";
  static String CLM_STY_HTG_NO2="STY_HTG_NO2";
  static String CLM_STY_HTG_NO3="STY_HTG_NO3";


  static String DISP_STY_HTG_QTY1="HTG-QTY ";
  static String DISP_STY_HTG_QTY2=" HTG-QTY";
  static String DISP_STY_HTG_QTY3="HTG-QTY";
  static String CLM_STY_HTG_QTY1="STY_HTG_QTY1";
  static String CLM_STY_HTG_QTY2="STY_HTG_QTY2";
  static String CLM_STY_HTG_QTY3="STY_HTG_QTY3";


  static String DISP_STY_HTG_RCVD_DD1="RCVD-DD ";
  static String DISP_STY_HTG_RCVD_DD2=" RCVD-DD";
  static String DISP_STY_HTG_RCVD_DD3="RCVD-DD";
  static String CLM_STY_HTG_RCVD_DD1="STY_HTG_RCVD_DD1";
  static String CLM_STY_HTG_RCVD_DD2="STY_HTG_RCVD_DD2";
  static String CLM_STY_HTG_RCVD_DD3="STY_HTG_RCVD_DD3";


  public PnlStyHangTagList() {

  }
  protected InsertionOrderedHashMap getHeadColumnMap() {
     InsertionOrderedHashMap iso=new InsertionOrderedHashMap();
     iso.put(DISP_STY_NO,DB_STY_NO);
     iso.put(DISP_STY_PO,DB_STY_PO);
     iso.put(DISP_STY_HTG_NO1,CLM_STY_HTG_NO1);
     iso.put(DISP_STY_HTG_QTY1,CLM_STY_HTG_QTY1);
     iso.put(DISP_STY_HTG_RCVD_DD1,CLM_STY_HTG_RCVD_DD1);
     iso.put(DISP_STY_HTG_NO2,CLM_STY_HTG_NO2);
     iso.put(DISP_STY_HTG_QTY2,CLM_STY_HTG_QTY2);
     iso.put(DISP_STY_HTG_RCVD_DD2,CLM_STY_HTG_RCVD_DD2);
     iso.put(DISP_STY_HTG_NO3,CLM_STY_HTG_NO3);
     iso.put(DISP_STY_HTG_QTY3,CLM_STY_HTG_QTY3);
     iso.put(DISP_STY_HTG_RCVD_DD3,CLM_STY_HTG_RCVD_DD3);
     return iso;
  }
  protected void refineEditors(MultiEditorJTable multiEditorJTableInSuper) {
    multiEditorJTableInSuper.setTableColumn2Grp(DISP_GRP_HANGTAG_1,2);
    multiEditorJTableInSuper.setTableColumn2Grp(DISP_GRP_HANGTAG_1,3);
    multiEditorJTableInSuper.setTableColumn2Grp(DISP_GRP_HANGTAG_1,4);
    multiEditorJTableInSuper.setTableColumn2Grp(DISP_GRP_HANGTAG_2,5);
    multiEditorJTableInSuper.setTableColumn2Grp(DISP_GRP_HANGTAG_2,6);
    multiEditorJTableInSuper.setTableColumn2Grp(DISP_GRP_HANGTAG_2,7);
    multiEditorJTableInSuper.setTableColumn2Grp(DISP_GRP_HANGTAG_3,8);
    multiEditorJTableInSuper.setTableColumn2Grp(DISP_GRP_HANGTAG_3,9);
    multiEditorJTableInSuper.setTableColumn2Grp(DISP_GRP_HANGTAG_3,10);
    multiEditorJTableInSuper.setTextEditorVerifiers(getObject2StringConvertor());
    hookInRefineEditor(multiEditorJTableInSuper);
  }
  protected Hashtable getObject2StringConvertor() {
     Object vc40=exgui.verification.CellFormat.getOrdinaryField(40);
     Object vc8=exgui.verification.CellFormat.getOrdinaryField(8);
     Object qty8=exgui.verification.CellFormat.getIntVerifierAllowNull(8);
     Object dt=exgui.verification.CellFormat.getDateStringFormaterAllowNull();
     Hashtable ht=new Hashtable();
     ht.put(DISP_STY_HTG_NO1,vc40);
     ht.put(DISP_STY_HTG_NO2,vc8);
     ht.put(DISP_STY_HTG_NO3,vc8);
     ht.put(DISP_STY_HTG_QTY1,qty8);
     ht.put(DISP_STY_HTG_QTY2,qty8);
     ht.put(DISP_STY_HTG_QTY3,qty8);
     ht.put(DISP_STY_HTG_RCVD_DD1,dt);
     ht.put(DISP_STY_HTG_RCVD_DD2,dt);
     ht.put(DISP_STY_HTG_RCVD_DD3,dt);
     return ht;
  }

}