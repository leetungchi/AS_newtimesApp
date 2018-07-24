package newtimes.reports.report01.ReportPS;

import exgui.ultratable.*;
import database.datatype.*;
import util.InsertionOrderedHashMap;
import java.util.Hashtable;
import java.util.HashMap;
import java.util.Vector;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class RepPsAbsPanel extends AbstractUltraTablePanel {
  private static String TT_BUYER    ="BUYER";
  private static String TT_FTY      = "MAKER";
  private static String TT_PO       = "P.O.";
  private static String TT_STYLE    = "STYLE";
  private static String TT_QTY      = "QTY";
  private static String TT_PS       = "PS";
  private static String TT_ORI_DEL  = " DELIVERY";
  private static String TT_W1       = " W";
  private static String TTL_ORG_DEL_DATA="Original \nDEL.";
  private static String TT_X        = "CLOSE";
  private static String TT_RE_DEL   = "DELIVERY";
  private static String TT_W2       = "ShipMode";
  private static String GROUP_TITLE_MAKER_BUYER_GROUPNAME="BUYER         \nMAKER\nGROUP";
  private static String GROUP_TITLE_SCNO_STYLE_PO="SC NO             \nSTYLE\nPO";
  private static String GROUP_TITLE_QTY_ORGDEL_ORGSHIP="QTY\nOrg DEL.\nShipMode";
  /*
  private static String TT_W_UPDATE = "WEEKLY\nUPDATE";
  private static String TT_W3       = "W2";
  private static String TT_SIZE     = "SIZE\nSET";
  private static String TT_PIL_SMPL = "PILOT\nSMPL";
  private static String TT_TOP_SMPL = "TOP\nSMPL";
  private static String TT_SHOP1    = "SEWING\nSHOP1";
  private static String TT_SHOP2    = "SHOP2";
  private static String TT_SHOP3    = "SHOP3";
  private static String TT_SHOP4    = "SHOP4";
  private static String TT_SHOP5    = "SHOP5";
  */
  private static String TT_REMARK   = "              REMARK                     ";
  static Hashtable obj2StrConv=null;

  private ReportEJBs.RepPsEJB.RepPS repPsEJB =
      (ReportEJBs.RepPsEJB.RepPS)util.ApplicationProperites.getProperties("repPsEJB");
  private RepPsDataFactory repPsDataSrc = null;
  private String userID = null;
  protected HashMap dataMap2Update=new HashMap();//key is sty seq,record is "style" record to update.

  private void initData(){
    try{
      userID = (String)(util.PublicVariable.USER_RECORD.get("USR_CODE"));
    }
    catch(Exception exp){
      exp.printStackTrace();
    }
  }
  public RepPsAbsPanel() {
    super();
    initData();
    super.jbtn1st.setVisible(false);
    super.jbtnLast.setVisible(false);
    super.jbtnNext.setVisible(false);
    super.jbtnPrev.setVisible(false);
  }
  protected Record setObject2Record(Record rec, int columnAt, Object value2update) {
    Record rec2update=null;
    String sty_seq_string=rec.get(0).toString();
    try{

      if(dataMap2Update.containsKey(sty_seq_string)){
        rec2update=(Record)dataMap2Update.get(sty_seq_string);
      }else{
        rec2update=dbHandler.getBlankRecord();
        rec2update.set(0,sty_seq_string);
        //System.out.println("new rec2update:"+rec2update.toString() );
      }
      if(columnAt==5){
        if(((Boolean)value2update).booleanValue()){
          rec.set("STY_PS_CLOSE","Y");
          rec2update.set("STY_PS_CLOSE","Y");
        }else{
          rec.set("STY_PS_CLOSE","N");
          rec2update.set("STY_PS_CLOSE","N");
        }
        //System.out.println("");
        //System.out.println("rec="+rec.toString());
        dataMap2Update.put(sty_seq_string,rec2update);
        return rec;
      }
      String Column[]=getStoredRecordColumns();
      String destColumName="";
      if(Column[columnAt].equalsIgnoreCase("RECFM_DEL")){
        destColumName="STY_RECFM_DEL";
      }else{
        destColumName=Column[columnAt];
      }
      rec.set(Column[columnAt],value2update);
      //rec.set("RECORD_MODIFY_USER", userID);
      rec2update.set(destColumName,value2update);
    }catch(Exception e){
      e.printStackTrace();
    }
    finally{
      //System.out.println("rec="+rec.toString());
      dataMap2Update.put(sty_seq_string,rec2update);
      return rec;
    }

  }
  protected InsertionOrderedHashMap getHeadColumnMap() {
    util.InsertionOrderedHashMap headHm = new util.InsertionOrderedHashMap();
    /*
    headHm.put(TT_BUYER,    "BUYER"); //0
    headHm.put(TT_FTY,      "FTY");//1
    headHm.put(TT_PO,       "STY_PO");//2
    headHm.put(TT_STYLE,    "STY_STYLE");//3
    headHm.put(TT_QTY,      "QTY");//4
    headHm.put(TTL_ORG_DEL_DATA,"org_del_data");//5
    headHm.put(TT_RE_DEL,   "RECFM_DEL");//6
    headHm.put(TT_W2,       "STY_RECFM_SHIP");//7
    headHm.put(TT_X,        "STY_PS_CLOSE");//8
    headHm.put(TT_REMARK,   "STY_PS_RMRK");//10
    */
   headHm.put(GROUP_TITLE_MAKER_BUYER_GROUPNAME, "buyer_maker_group");//0
   headHm.put(GROUP_TITLE_SCNO_STYLE_PO, "style_po_sc");//1
   headHm.put(GROUP_TITLE_QTY_ORGDEL_ORGSHIP, "qty_orgdel_data");//2
   headHm.put(TT_RE_DEL,   "RECFM_DEL");//3
   headHm.put(TT_W2,       "STY_RECFM_SHIP");//4
   headHm.put(TT_X,        "STY_PS_CLOSE");//5
   headHm.put(TT_REMARK,   "STY_PS_RMRK");//6

    return headHm;

  }
  public void doUpdate(){
    try{
      if(!getMultiEditorJTable().isTableOk())return;
      _records2Update=kvtModifiedField2Records(
          getMultiEditorJTable().getModifiedRowAndColumn()
      );

      util.MiscFunc.showProcessingMessage();
      String usr_code = (String)util.PublicVariable.USER_RECORD.get("usr_code");
      Vector vct2update = new Vector();
      java.util.Iterator itr = dataMap2Update.keySet().iterator();
      while (itr.hasNext()) {
        Record rec = (Record)dataMap2Update.get(itr.next());
        rec.set("record_modify_user", usr_code);
        //System.out.println("record to update :"+rec.toString());
        vct2update.add(rec);
      }
      if (vct2update.size() == 0)return ;
      dbHandler.updateRecords(vct2update);
      dataMap2Update.clear();
      this.reload();

    }catch(Exception exp){
      exp.printStackTrace();
      util.ExceptionLog.exp2File(exp,"");
      exgui.verification.VerifyLib.showAlert("Update Fail,Please Contact System Manager",
                                             "Update Fail");
    }finally{
      util.MiscFunc.hideProcessingMessage();
    }
  }
  protected void refineEditors(MultiEditorJTable multiEditorJTableInSuper) {
    try{
      //multiEditorJTableInSuper.setTableColumn2Grp("ORIGINAL",5);
      //multiEditorJTableInSuper.setTableColumn2Grp("ORIGINAL",6);
      multiEditorJTableInSuper.setTableColumn2Grp("RECONFIRM",3);
      multiEditorJTableInSuper.setTableColumn2Grp("RECONFIRM",4);
      multiEditorJTableInSuper.addCheckbox(5,"Y");
      multiEditorJTableInSuper.setTextEditorVerifiers(getObject2StringConvertor());
      //multiEditorJTableInSuper.setColumnUnEditable(TT_ORI_DEL);
      //multiEditorJTableInSuper.setColumnUnEditable(TT_W1);
      multiEditorJTableInSuper.setColumnUnEditable(TTL_ORG_DEL_DATA);
      multiEditorJTableInSuper.addTextAreaEditor(6,200,35);
      MyRenderer myder=new MyRenderer();
      //this.getJtable().getColumnModel().getColumn(3).setCellRenderer(myder);
      getJtable().setRowHeight(90);
    }
    catch(Exception exp){
      exp.printStackTrace();
    }
  }
  public class MyRenderer extends javax.swing.JLabel
      implements javax.swing.table.TableCellRenderer{
      public MyRenderer(){
      super();
     setOpaque(true); /* it\u00B4s essential */
  }
   public java.awt.Component getTableCellRendererComponent(
         javax.swing.JTable table, Object value,
         boolean isSelected, boolean hasFocus,
         int row, int column){
          String text = (value==null)?"":value.toString();
        //if(text.equals("Waiting")) /*
        setBackground(new java.awt.Color(0x90,0xFF,0x90)); // Decides the color
        setText(text); /* Put the current text in the JLabel */
     return this;
    }
  }

  protected int getEachPageRowCount() {
    return 9999999;
  }
  protected Hashtable getObject2StringConvertor() {
    if(obj2StrConv==null){
      //Object text40Field = exgui.verification.CellFormat.getOrdinaryField(300);
      Object dateField = exgui.verification.CellFormat.getDateStringFormaterAllowNull();
      Object char1=exgui.verification.CellFormat.getOrdinaryField(1);
      obj2StrConv = new Hashtable();
      obj2StrConv.put(TT_RE_DEL,dateField);
      //obj2StrConv.put(TT_ORI_DEL,dateField);
      /*
      obj2StrConv.put(TT_W_UPDATE,dateField);
      obj2StrConv.put(TT_PIL_SMPL,dateField);
      obj2StrConv.put(TT_TOP_SMPL,dateField);
      obj2StrConv.put(TT_SIZE,dateField);
      */
      //obj2StrConv.put(TT_W1,char1);
      obj2StrConv.put(TT_W2,char1);
      //obj2StrConv.put(TT_REMARK,text40Field);
    }
    return obj2StrConv;

  }
  protected PagedDataFactory getPagedDataFactory() {
    if(this.repPsDataSrc != null) return this.repPsDataSrc;
    HashMap hm = (HashMap)util.ApplicationProperites.getProperties("RepPsSearchConds");
    this.repPsDataSrc = new RepPsDataFactory(hm);
    return this.repPsDataSrc;
  }

}
