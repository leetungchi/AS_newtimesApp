package newtimes.shipping_admin.guis.shippingmaintain;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */


import processhandler.template.PnlTableEditor;
import exgui.ultratable.*;
import database.datatype.*;
import util.InsertionOrderedHashMap;
import processhandler.*;
import java.util.Hashtable;
import processhandler.template.PnlTableEditor;
import exgui.ultratable.*;
import database.datatype.*;
import util.InsertionOrderedHashMap;
import processhandler.*;
import java.util.Hashtable;
import java.awt.*;
import javax.swing.*;
/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class PnlListStyle2AddFromAsn extends PnlTableEditor  {
  static final String BUYER="  Buyer  ";
  static final String FTY = "  Maker  ";
  //static final String DIV = "Division";
  //static final String SEA = "Season";
  //static final String YEAR = "Year";
  //static final String RANGE = "Range";
  static final String SC_NO = " S/C NO. ";
  static final String ASN_NO = "ASN#";
  static final String FTYINV_NO = "FTY\nINV#";
  static final String DEL_DATE = "DEL\nDATE";
  static final String SHIP_WAY = "SHIP\nMODE";

  static final String PRX_TERM="PRICE\nTERM";
  static final String GOODS_DEST="DESTI-\nNATION";
  static final String STYLE = "  Style  ";
  static final String PO = "  PO  ";
  static final String UNIT = "Unit";
  static final String O_QTY = "ORDER\nQTY";
  static final String S_QTY = "SHIP\nQTY";
  static final String B_QTY = "BALANCE\nQTY";
  static final String SHIP_DRUP_DEST="Drop\nDest";
  static final String CLOSE="QTY\nDtl.";
  static final String ASN_PKG_QTY="ASN \nQTY";
  static InsertionOrderedHashMap iso = null;
  static public int rowPosition=-1;
  static public java.util.HashMap HM_ROW_CHECKED=new java.util.HashMap();
  static public java.util.HashMap HM_ADDED_RECORDS=new java.util.HashMap();
  JButton btnSlkAll=new JButton("Select All");
  JButton btnAddChkkedRec=new JButton("ADD CHECKED ROWS TO SRN");
  static  String Asn2Add=null;
  PnlListStyle2AddFromAsn _me;
  public PnlListStyle2AddFromAsn() {
    getJtable().setRowHeight(20);
    getJtable().addMouseListener(new myMouseListener());
    newtimes.shipping_admin.process.shiippingmaintain.ToListAddedStyles.PAGE_BEGIN=0;
    getLowerRightPanel().removeAll();
    getLowerRightPanel().add(btnSlkAll);
    getLowerRightPanel().add(btnAddChkkedRec);
    java.awt.event.ActionListener [] axnLs=btnAddChkkedRec.getActionListeners();
    for(int i=0;i<axnLs.length;i++){
      btnAddChkkedRec.removeActionListener(axnLs[i]);
    }
    btnAddChkkedRec.addActionListener(new BtnActionListener());

    java.awt.event.ActionListener [] axnLsSlkAll=btnSlkAll.getActionListeners();
    for(int i=0;i<axnLsSlkAll.length;i++){
      btnSlkAll.removeActionListener(axnLsSlkAll[i]);
    }
    btnSlkAll.addActionListener(new BtnSlkAllListener());


    _me=this;
  }
  public void doAddNew()throws Exception{
    /*
    if(null!=newtimes.shipping_admin.guis.shippingmaintain.PnlListStyle2AddFromAsn.HM_ADDED_RECORDS){
      newtimes.shipping_admin.guis.shippingmaintain.PnlListStyle2AddFromAsn.HM_ADDED_RECORDS.clear();
    }else{
      newtimes.shipping_admin.guis.shippingmaintain.PnlListStyle2AddFromAsn.HM_ADDED_RECORDS=new java.util.HashMap();
    }
    if(null!=newtimes.shipping_admin.guis.shippingmaintain.PnlListStyle2AddFromAsn.HM_ROW_CHECKED){
      newtimes.shipping_admin.guis.shippingmaintain.PnlListStyle2AddFromAsn.HM_ROW_CHECKED.clear();
    }else{
      newtimes.shipping_admin.guis.shippingmaintain.PnlListStyle2AddFromAsn.HM_ROW_CHECKED=new java.util.HashMap();
    }
    */
    processhandler.template.Properties.getCenteralControler().
        doCommandExecute(
        new newtimes.shipping_admin.process.shiippingmaintain.TgrToQryPoFtyInv()
        );

  }
  class BtnSlkAllListener implements java.awt.event.ActionListener{
    public void actionPerformed(java.awt.event.ActionEvent ae){
      try{
        for (int i = 0; i < getJtable().getRowCount(); i++) {
          Record rec = (Record)getDisplayingRecords().get(i);
          String keStr = rec.get("STY_SEQ").toString()+"||"+rec.get("vendorinv_no").toString() + "||" +(String)rec.get("ASN_NO");
          if(HM_ADDED_RECORDS.containsKey(keStr)){
            getJtable().setValueAt(new Boolean(false), i,getJtable().getColumnCount() - 2);
          }else{
            getJtable().setValueAt(new Boolean(true), i,getJtable().getColumnCount() - 2);
          }
        }
      }catch(Exception exp){
        exp.printStackTrace();
        util.ExceptionLog.exp2File(exp,"");
      }
    }
  }
  class BtnActionListener implements java.awt.event.ActionListener{
    public void actionPerformed(java.awt.event.ActionEvent ae){
      try{
        if(isOverShip())return;
        getherSelectRows();
        //java.util.Iterator itrBackUp=HM_ROW_CHECKED.keySet().iterator();
        //java.util.Iterator itr=(java.util.Iterator)util.MiscFunc.deepCopy(itrBackUp);
        java.util.HashMap hmbackup=(java.util.HashMap)util.MiscFunc.deepCopy(HM_ROW_CHECKED);
        java.util.Iterator itr=hmbackup.keySet().iterator();

        util.MiscFunc.showProcessingMessage();
        java.util.Vector vct2upload=new java.util.Vector();
        while (itr.hasNext()) {
          String keyString=(String)itr.next();
          if(HM_ADDED_RECORDS.containsKey(keyString))continue;
          Record rec = (Record)HM_ROW_CHECKED.get(keyString);
          vct2upload.add(rec);
          /*
          newtimes.shipping_admin.ShippingAdmin_Const.EDIT_SHIP_STYLE_SEQ_INT = -1; //new record
          newtimes.shipping_admin.ShippingAdmin_Const.
              EDIT_SHIP_STYLE_STYLE_INT_SEQ = rec.getInt("sty_seq");
          newtimes.shipping_admin.process.shiippingmaintain.
              TgrToAddSty2Shipping.
              RECORD_SHIP_DETAIL_FROM_ASN = rec;
          newtimes.shipping_admin.process.shiippingmaintain.
              ToAddStyle2Shipping4Asn
              Handler = new newtimes.shipping_admin.process.shiippingmaintain.
              ToAddStyle2Shipping4Asn();
          util.MiscFunc.showProcessingMessage();
            Handler.Add2Asn();
          */
        }
        ShippingAdmin.SRN_Style.ShipStyleFacadeHome ejbHome =
            (ShippingAdmin.SRN_Style.ShipStyleFacadeHome)
            info_ejb.WeblogicServiceLocator.locateServiceHome(
            util.PublicVariable.SERVER_URL,
            "ShippingAdmin.SRN_Style.ShipStyleFacade");
        ShippingAdmin.SRN_Style.ShipStyleFacade ejb = ejbHome.create();
        ejb.batchInsertAsnDtl(vct2upload,newtimes.shipping_admin.ShippingAdmin_Const.CURRENT_EDITING_SHIP_SRN,
                              (String)util.PublicVariable.USER_RECORD.get(0));

        util.MiscFunc.hideProcessingMessage();
        for(int i=0;i<vct2upload.size();i++){
          Record recProcessed=(Record)vct2upload.get(i);
          String asnNo=(String)recProcessed.get("asn_no");
          String vendorinv_no=(String)recProcessed.get("vendorinv_no");
          String sty_seq=recProcessed.get("STY_SEQ").toString();
          String keStr=String.valueOf(sty_seq)+"||"+vendorinv_no+"||"+asnNo;
          newtimes.shipping_admin.guis.shippingmaintain.PnlListStyle2AddFromAsn.HM_ROW_CHECKED.remove(keStr);
          newtimes.shipping_admin.guis.shippingmaintain.PnlListStyle2AddFromAsn.HM_ADDED_RECORDS.put(keStr,recProcessed);
        }
        _me.firstPage();
        //exgui.verification.VerifyLib.showPlanMsg("Insert OK","Insert OK");
        doExit();
      }catch(Exception exp){
        exp.printStackTrace();
        util.ExceptionLog.exp2File(exp,"");
        exgui.verification.VerifyLib.showAlert("Insert Ship Detail Failed!!\nPlease Contact System Manager",
                                               "Insert Failed");
      }

    }
  }
 public Record setObject2Record(Record rec,int col,Object obj){
   try{
     if (col == getJtable().getColumnCount() - 2) {
       Boolean blValue = (Boolean)obj;
       String keStr=rec.get("STY_SEQ").toString()+"||"+rec.get("vendorinv_no").toString()+"||"+(String)rec.get("ASN_NO");
       if (blValue.booleanValue()) {
         HM_ROW_CHECKED.put(keStr, rec);
       } else {
         HM_ROW_CHECKED.remove(keStr);
       }
     }
     return null;
   }catch(Exception exp){
     exp.printStackTrace();
     util.ExceptionLog.exp2File(exp,"");
     return null;
   }

 }
  public void firstPage(){
    if(rowPosition>0){
      goPage(rowPosition,_rowCounts);
    }else{
      super.firstPage();
    }
  }
  public class CellRender extends JLabel
      implements javax.swing.table.TableCellRenderer{
      public CellRender(){
      super();
     setBorder(javax.swing.BorderFactory.createRaisedBevelBorder());
     setOpaque(true); /* it\u00B4s essential */
     setHorizontalAlignment(JLabel.CENTER);
  }
   public Component getTableCellRendererComponent(
         javax.swing.JTable table, Object value,
         boolean isSelected, boolean hasFocus,
         int row, int column){
        String text =" ... "; //(value==null)?"":value.toString();
        setBackground(new java.awt.Color(0xF0,0xF0,0xF0)); // Decides the color
        setText(text);
     return this;
    }
  }

  protected InsertionOrderedHashMap getHeadColumnMap() {
    if(iso == null){
      iso = new InsertionOrderedHashMap();
      iso.put(ASN_NO,"ASN_NO");//2-->0
      iso.put(FTYINV_NO,"VENDORINV_NO");//3-->1
      iso.put(DEL_DATE,"STY_DEL_DATE");//4-->2
      iso.put(SHIP_WAY,"STY_SHIP_MODE");//5-->3
      iso.put(STYLE, "STYLE");//5-->8-->4
      iso.put(PO, "CUST_PO");//6-->9-->5
      iso.put(UNIT, "UNIT");//7-->10-->6
      iso.put(O_QTY, "O_QTY");//8-->11-->7
      iso.put(ASN_PKG_QTY,"qty_2_ship");
      iso.put(S_QTY, "S_QTY");//9-->12-->9
      iso.put(B_QTY, "B_QTY");//10--13-->10
      iso.put("V","X");//11-->14-->11
      iso.put(CLOSE,"CLOSED");//12-->15-->12
    }
    return iso;
  }
  boolean isOverShip()throws Exception{
    //shipQty>styQty*1.05
    util.MiscFunc.showProcessingMessage();
    StringBuffer sb=new StringBuffer();
    for(int i=0;i<getJtable().getRowCount();i++){
      boolean chk=((Boolean)getJtable().getValueAt(i,11)).booleanValue();
      if(chk){

        float shippedQty=Float.parseFloat(getJtable().getValueAt(i,9).toString());
        float qty2Ship=Float.parseFloat(getJtable().getValueAt(i,8).toString());
        float orderQty=Float.parseFloat(getJtable().getValueAt(i,7).toString());
        //System.out.println("shipped qty is "+shippedQty+" qty 2 ship is :"+qty2Ship+" order qty is "+orderQty);
        if((shippedQty+qty2Ship)>orderQty*1.05){
          //sb.append(" Row: "+String.valueOf(i+1));
          //sb.append("\n");
          Record rec=(Record)getDisplayingRecords().get(i);
          //htStySeqAndRow.put(rec.get("STY_SEQ").toString(),String.valueOf(i+1));
          StringBuffer sbSql=new StringBuffer();
          sbSql.append("select ");
          sbSql.append(" (select ship_no from ship_sc where ship_sc_pk=A.SHIP_SC_PK) as SRN_NO, ");
          sbSql.append("  A.SHIP_STY_TOTAL_QTY ,a.sty_seq ");
          sbSql.append("from ship_style a  where sty_seq=");
          sbSql.append(rec.get("STY_SEQ").toString());
          java.util.Vector vctShipped=exgui2.CONST.BASIC_MAIN_EJB.getDatas(
           util.PublicVariable.USER_RECORD,sbSql.toString(),1,99999);
             sb.append("ROW:"+String.valueOf((i+1)));sb.append(" ");
           for(int j=0;j<vctShipped.size();j++){
             if(j>0)sb.append(",");
             Record recShipped=(Record)vctShipped.get(j);
             sb.append("SRN:");sb.append(recShipped.get(0));sb.append(" Qty:");sb.append(recShipped.get(1));
           }
          sb.append("\n");
        }
      }
    }
    /*
    //the msg of overship warning is
    // row:1 shipped xxxsrnxxx,Qty:...,xxxsrnxxx,Qty:...
    // row:5 shipped xxxsrnxxx,Qty:...,.......
    //are u sure to continue ?
    if(!htStySeqAndRow.isEmpty()){
      StringBuffer sbSql=new StringBuffer();
     sbSql.append("select ");
     sbSql.append(" (select ship_no from ship_sc where ship_sc_pk=A.SHIP_SC_PK) as SRN_NO, ");
     sbSql.append("  A.SHIP_STY_TOTAL_QTY ,a.sty_seq ");
     sbSql.append("from ship_style a  ");
     sbSql.append("where sty_seq in ( ");
      java.util.Enumeration enu=htStySeqAndRow.keys();
      boolean isCps=false;
      while(enu.hasMoreElements()){
        String stySeq=(String)enu.nextElement();
        if(isCps)sbSql.append(",");
        sbSql.append(stySeq);
        if(!isCps)isCps=true;
      }
     sbSql.append(")");
     java.util.Vector vct=exgui2.CONST.BASIC_MAIN_EJB.getDatas(
       util.PublicVariable.USER_RECORD,sbSql.toString(),1,9999);
      sb.append("ASN RECORD Shipped:");
      Hashtable msgMap=new Hashtable();
      for(int i=0;i<vct.size();i++){
       Record testShip=(Record)vct.get(i);
       String stySeq=testShip.get(2).toString();
       String msg=(String)msgMap.get(stySeq);
       if(msg==null){
          msg="ROW";
          msg+=htStySeqAndRow.get(stySeq);
          msg+=" :";
       }
       msg+=(" SRN:"+testShip.get(0).toString()+" QTY:"+testShip.get(1).toString());
       msg+=",";
       msgMap.put(stySeq,msg);
      }
      java.util.Vector vctMsg=new java.util.Vector();
      vctMsg.addAll(vct);
    }
    */

    if(sb.length()>0){

      if(!exgui.verification.VerifyLib.showConfirm("Order Shipped: \n"+sb.toString()+" Are You Sure To Continue?",
                                                   "Over ship Warning",false)){
        return true;
      }
    }
    util.MiscFunc.hideProcessingMessage();
    return false;
  }
  public void getherSelectRows(){
    try{
    for(int i=0;i<getJtable().getRowCount();i++){
      Record rec=(Record)getDisplayingRecords().get(i);
      Boolean bl=(Boolean)getJtable().getValueAt(i,getJtable().getColumnCount()-2);
      String keStr=rec.get("STY_SEQ").toString()+"||"+rec.get("vendorinv_no").toString()+"||"+(String)rec.get("ASN_NO");
      if(bl.booleanValue()){
        HM_ROW_CHECKED.put(keStr,rec);
      }else{
        HM_ROW_CHECKED.remove(keStr);
      }
    }
    }catch(Exception exp){
      exp.printStackTrace();
    }
  }
  public void doPrint() throws java.lang.Exception {
    /**@todo Implement this processhandler.DataProcesser abstract method*/
  }
  protected void refineEditors(MultiEditorJTable multiEditorJTableInSuper) {
    /**@todo Implement this exgui.ultratable.AbstractUltraTablePanel abstract method*/
    this.getJtable().getColumnModel().getColumn(12).setCellRenderer(new CellRender());
    multiEditorJTableInSuper.addCheckbox(11,"1");
    ((exgui.MultiClassTableModel)multiEditorJTableInSuper.getJTable().getModel()).setCellEditablePolicy(new EditPolicy());
  }
  public void makeTable(java.util.Vector vct){
    //add the checked columns,
    if(null==HM_ROW_CHECKED){
      HM_ROW_CHECKED=new java.util.HashMap();
    }
    java.util.Vector vctRec2Process=new java.util.Vector();
    try{
      for (int i = 0; i < vct.size(); i++) {
        Record recOrg = (Record)vct.get(i);
        recOrg.getFieldName().add("X");
        recOrg.getValueFields().add("0");
        String keStr=recOrg.get("STY_SEQ").toString()+"||"+recOrg.get("vendorinv_no").toString()+"||"+(String)recOrg.get("ASN_NO");
        if (HM_ROW_CHECKED.get(keStr) != null) {
          recOrg.set("X", "1");
        }
        recOrg.getModifiedFields().clear();
        vctRec2Process.add(recOrg);
      }
    }catch(Exception exp){
      exp.printStackTrace();
      util.ExceptionLog.exp2File(exp,"");
    }
    super.makeTable(vctRec2Process);
    //set width of eacht column

    /*
      iso.put(ASN_NO,"ASN_NO");//2-->0
      iso.put(FTYINV_NO,"VENDORINV_NO");//3-->1
      iso.put(DEL_DATE,"STY_DEL_DATE");//4-->2
      iso.put(SHIP_WAY,"STY_SHIP_MODE");//5-->3
      iso.put(STYLE, "STYLE");//5-->8-->4
      iso.put(PO, "CUST_PO");//6-->9-->5
      iso.put(UNIT, "UNIT");//7-->10-->6
      iso.put(O_QTY, "O_QTY");//8-->11-->7
      iso.put(ASN_PKG_QTY,"qty_2_ship");
      iso.put(S_QTY, "S_QTY");//9-->12-->9
      iso.put(B_QTY, "B_QTY");//10--13-->10
      iso.put("V","X");//11-->14-->11
      iso.put(CLOSE,"CLOSED");//12-->15-->12
     */
    getJtable().getColumnModel().getColumn(0).setPreferredWidth(90); //asn NO
    getJtable().getColumnModel().getColumn(1).setPreferredWidth(95); //fty inv NO
    getJtable().getColumnModel().getColumn(3).setPreferredWidth(40); //ship way
    getJtable().getColumnModel().getColumn(4).setPreferredWidth(75); //STYLE
    getJtable().getColumnModel().getColumn(5).setPreferredWidth(70); //PO
    getJtable().getColumnModel().getColumn(6).setPreferredWidth(40); //UNIT
    getJtable().getColumnModel().getColumn(7).setPreferredWidth(55); //Order Qty
    getJtable().getColumnModel().getColumn(8).setPreferredWidth(55); //Order Qty
    getJtable().getColumnModel().getColumn(9).setPreferredWidth(40); //Ship Qty
    getJtable().getColumnModel().getColumn(10).setPreferredWidth(55); //Balance Qty
    getJtable().getColumnModel().getColumn(11).setPreferredWidth(10); //Balance Qty
    getJtable().getColumnModel().getColumn(12).setPreferredWidth(55); //CLOSE
    try{
      for (int i = 0; i < vctRec2Process.size(); i++) {
        Record recTmp = (Record)vctRec2Process.get(i);
        if (recTmp.getInt("sty_seq") ==
            newtimes.shipping_admin.ShippingAdmin_Const.
            EDIT_SHIP_STYLE_STYLE_INT_SEQ && recTmp.get("ASN_NO").equals(Asn2Add)) {
          //System.out.print("row selected at:"+i);
          getJtable().changeSelection(i, 0, false, false);
          break;
        }
      }
    }catch(Exception exp){
      exp.printStackTrace();
    }

  }

  protected int getEachPageRowCount() {
    return 9999999;
  }
  protected Hashtable getObject2StringConvertor() {
    return new java.util.Hashtable();
  }
  public boolean isContextModified(){
    getherSelectRows();
    return false;
  }
  class EditPolicy implements  exgui.CellEditablePolicy{
     public boolean isCellEditable(int row,int col){
       if(col!=11){
         return false;
       }
       try{
         Record recXntRec = (Record)getDisplayingRecords().get(row);
         String keStr = recXntRec.get("STY_SEQ").toString()+"||"+recXntRec.get("vendorinv_no").toString() + "||" +(String)recXntRec.get("ASN_NO");
         if(HM_ADDED_RECORDS.containsKey(keStr)){
           return false;
         }
         return true;
       }catch(Exception exp){
         exp.printStackTrace();
         util.ExceptionLog.exp2File(exp,"");
         return false;
       }
     }
  }

  public void genDetailWindow(){
    //util.MiscFunc.showProcessingMessage();
    //System.out.println("");
    try{
      //newtimes.production.ProdMaintain_Properties.setWaitCursor();
      javax.swing.JDialog dlg = new newtimes.shipping_admin.guis.
          shippingmaintain.DlgShowPoQtyDlt(
          util.PublicVariable.APP_FRAME, "Color Price Break Down Detail", true);
      dlg.setSize(775, 336);
      exgui.UIHelper.setToScreenCenter(dlg);
      dlg.show();
      //util.MiscFunc.hideProcessingMessage();
    }finally{
      //newtimes.production.ProdMaintain_Properties.setNormalCursor();
    }
  }
  class myMouseListener extends java.awt.event.MouseAdapter{

    public void mouseClicked(java.awt.event.MouseEvent e){
      //find out the click row,and activate the edit new ship style record command.
     if(getJtable().getSelectedRow()==-1)return;

     Record rec=(Record)getDisplayingRecords().get(getJtable().getSelectedRow());
     try{
       if (rec.get("FTY") == null) {
         exgui.verification.VerifyLib.showAlert("Maker Not Assigned Yet\nPlease Assigne Maker Of Po Before Shipping",
                                                "Maker Not Assigned");
         return;
       }
     }catch(Exception exp){
       exp.printStackTrace();
     }
     System.out.println("record to add of org style is :"+rec.toString());
     rowPosition=_rowPosition;
      try {
       newtimes.shipping_admin.ShippingAdmin_Const.EDIT_SHIP_STYLE_SEQ_INT = - 1; //new record
         newtimes.shipping_admin.ShippingAdmin_Const.EDIT_SHIP_STYLE_STYLE_INT_SEQ =rec.getInt("sty_seq");
         if(getJtable().getSelectedColumn()== getJtable().getColumnCount()-1){
           // click the "..." button
           genDetailWindow();
           return;
         }

         if(getJtable().getSelectedColumn()== getJtable().getColumnCount()-2){
           // click the "..." button
           if(null==HM_ROW_CHECKED){
             HM_ROW_CHECKED=new java.util.HashMap();
           }
           return;
         }

         Asn2Add=(String)rec.get("ASN_NO");
           //----------------------------------------------------------------
           //20060729,for those stupid user,always confuse current phase is to select to add,not to edit,
           //have to enter the "edit" mode if click row are the added row
           String keStr=rec.get("STY_SEQ").toString()+"||"+rec.get("vendorinv_no").toString()+"||"+(String)rec.get("ASN_NO");
           if(HM_ADDED_RECORDS.containsKey(keStr)){
              String destShipStyleSeq=(String)HM_ADDED_RECORDS.get(keStr);
             newtimes.shipping_admin.ShippingAdmin_Const.EDIT_SHIP_STYLE_SEQ_INT = Integer.parseInt(destShipStyleSeq);
                   processhandler.template.Properties.getCenteralControler().doCommandExecute(
                         new newtimes.shipping_admin.process.shiippingmaintain.TgrToEditAddedStyle(rec));
             return;
           }
           //------------------------------------------------------------------------
           PnlEditShipStyle.isEditingShipQty=true;
           //newtimes.shipping_admin.ShipPrxQty.PnlCplxShipStylePW.CUST_PO=(String)rec.get("CUST_PO");
           newtimes.shipping_admin.process.shiippingmaintain.TgrToAddSty2Shipping.RECORD_SHIP_DETAIL_FROM_ASN=rec;
           processhandler.template.Properties.getCenteralControler().doCommandExecute(
                  new newtimes.shipping_admin.process.shiippingmaintain.TgrAddShipStyle4Lauren());
                 //new newtimes.shipping_admin.process.shiippingmaintain.TgrToAddSty2Shipping());

      } catch (Exception exp) {
          exp.printStackTrace();
      }

    }
  }
  protected PagedDataFactory getPagedDataFactory() {
    /**@todo Implement this exgui.ultratable.AbstractUltraTablePanel abstract method*/
    newtimes.shipping_admin.process.shiippingmaintain.DB_StyleList4Add handler=
        newtimes.shipping_admin.process.shiippingmaintain.DB_StyleList4Add.getInstance();
    dbHandler=handler;
    return handler;
  }

}
