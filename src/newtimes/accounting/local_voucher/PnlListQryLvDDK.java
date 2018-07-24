package newtimes.accounting.local_voucher;
import java.awt.*;
import exgui.*;
import javax.swing.*;
import database.datatype.Record;
import java.util.*;
import java.awt.event.*;
/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class PnlListQryLvDDK extends JPanel {
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel1 = new BlueBkgWhiteCharLabel();
  JButton btnEXIT = new JButton();
  JButton btnDeduct = new JButton();
  JButton btnFillAmt = new JButton();
  Panel2List pnl2list = null;
  DbLocalVoucherDDK dbHandler=new DbLocalVoucherDDK();
  java.util.HashMap hmDDKRecords;
  Vector vct2update;
  JTextField txtChkDeductDate = new JTextField();
  JTextField txtChkAmt = new JTextField();
  WhiteBkgBlueCharLabel whiteBkgBlueCharLabel2 = new WhiteBkgBlueCharLabel();
  JTextField txtChkNo = new JTextField();
  WhiteBkgBlueCharLabel whiteBkgBlueCharLabel1 = new WhiteBkgBlueCharLabel();
  WhiteBkgBlueCharLabel whiteBkgBlueCharLabel3 = new WhiteBkgBlueCharLabel();
  exgui.DataBindTextWithChecker dbTxtChkNo,dbTxtChkAmt,dbDeductDate,
                                dbTxtAccVoucherNo,dbTxtPurchaseVoucherNo;

  java.text.NumberFormat nf=new java.text.DecimalFormat("###########0.00");
  WhiteBkgBlueCharLabel whiteBkgBlueCharLabel4 = new WhiteBkgBlueCharLabel();
  JTextField txtAccVoucherNo = new JTextField();
  WhiteBkgBlueCharLabel whiteBkgBlueCharLabel7 = new WhiteBkgBlueCharLabel();
  JTextField txtPurchaseVoucherNo = new JTextField();
  public PnlListQryLvDDK() {
    try {
      jbInit();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }
 protected  void getPnl2List(){
   util.InsertionOrderedHashMap iso=new util.InsertionOrderedHashMap();
   Object objDate=exgui.verification.CellFormat.getDateStringFormaterAllowNull();
   Object dcmCnv=exgui.verification.CellFormat.getDoubleFormatDot00RiteAligne(11,2); //.getDoubleFormatAllowNull(11,2);
   Object chr30=exgui.verification.CellFormat.getOrdinaryField(30);
   iso.put("   SHIP  NO   ","SHIP_NO");
   iso.put("CREATE DATE","record_create_date");
   iso.put(" ETD DATE ","SHIP_ETD_DATE");
   iso.put("XRate","Exchange_rate");
   iso.put("BLNC AMT","local_voucher_balance");
   iso.put("DEDUCT AMT","ddk_amt");
   iso.put("OTHER AMT","other_amt");
   iso.put("  DESC  ","other_amt_desc");

   Hashtable ht=new Hashtable();
   ht.put("CREATE DATE",objDate);
   ht.put(" ETD DATE ",objDate);
   ht.put("XRate",dcmCnv);
   ht.put("BLNC AMT",dcmCnv);
   ht.put("DEDUCT AMT",dcmCnv);
   ht.put("OTHER AMT",dcmCnv);
   ht.put("  DESC  ",chr30);


   pnl2list=new Panel2List(
       dbHandler,
       99999,iso,
       ht);
    pnl2list.getPanelContainsButtons().removeAll();
    pnl2list.firstPage();
 }
  void jbInit() throws Exception {
    blueBkgWhiteCharLabel1.setText("LOCAL VOUCHER DEDUCT MAINTENANCE DEDUCT LIST");
    blueBkgWhiteCharLabel1.setBounds(new Rectangle(-5, 7, 808, 29));
    this.setBackground(new Color(202, 202, 224));
    this.setLayout(null);
    btnEXIT.setBounds(new Rectangle(662, 536, 106, 30));
    btnEXIT.setFont(new java.awt.Font("Dialog", 1, 11));
    btnEXIT.setText("EXIT");
    btnEXIT.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnEXIT_actionPerformed(e);
      }
    });
    btnDeduct.setText("DEDUCT");
    btnDeduct.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnDeduct_actionPerformed(e);
      }
    });
    btnDeduct.setBounds(new Rectangle(121, 536, 106, 30));
    btnDeduct.setFont(new java.awt.Font("Dialog", 1, 11));
    btnFillAmt.setText("FILL BALANCE AMT");
    btnFillAmt.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnFillAmt_actionPerformed(e);
      }
    });
    btnFillAmt.setFont(new java.awt.Font("Dialog", 1, 11));
    btnFillAmt.setBounds(new Rectangle(408, 536, 164, 30));

    txtChkDeductDate.setText("");
    txtChkDeductDate.setText("");
    txtChkDeductDate.setBounds(new Rectangle(671, 43, 93, 26));
    txtChkAmt.setBounds(new Rectangle(384, 43, 117, 26));
    txtChkAmt.setText("jTextField1");
    txtChkAmt.setText("");
    whiteBkgBlueCharLabel2.setBounds(new Rectangle(282, 43, 101, 26));
    whiteBkgBlueCharLabel2.setText("CHECK AMT.");
    txtChkNo.setText("");
    txtChkNo.setBounds(new Rectangle(107, 43, 164, 26));
    whiteBkgBlueCharLabel1.setText("CHECK NO.");
    whiteBkgBlueCharLabel1.setBounds(new Rectangle(6, 43, 101, 26));
    whiteBkgBlueCharLabel3.setText("DEDUCT DATE");
    whiteBkgBlueCharLabel3.setBounds(new Rectangle(567, 43, 101, 26));
    whiteBkgBlueCharLabel4.setFont(new java.awt.Font("Dialog", 0, 16));
    whiteBkgBlueCharLabel4.setText("傳票號碼:");
    whiteBkgBlueCharLabel4.setBounds(new Rectangle(669, 72, 120, 27));
    txtAccVoucherNo.setBounds(new Rectangle(669, 101, 120, 26));
    txtAccVoucherNo.setText("");
    whiteBkgBlueCharLabel7.setBounds(new Rectangle(669, 135, 120, 27));
    whiteBkgBlueCharLabel7.setText("發票號碼:");
    whiteBkgBlueCharLabel7.setFont(new java.awt.Font("Dialog", 0, 16));
    txtPurchaseVoucherNo.setText("");
    txtPurchaseVoucherNo.setBounds(new Rectangle(669, 165, 120, 26));
    this.add(blueBkgWhiteCharLabel1, null);
    this.add(btnFillAmt, null);
    this.add(btnDeduct, null);
    this.add(btnEXIT, null);
    this.add(whiteBkgBlueCharLabel1, null);
    this.add(txtChkNo, null);
    getPnl2List();
    pnl2list.setBounds(new Rectangle(9, 77, 660, 472));
    this.add(pnl2list, null);
    this.add(whiteBkgBlueCharLabel3, null);
    this.add(txtChkDeductDate, null);
    this.add(whiteBkgBlueCharLabel2, null);
    this.add(txtChkAmt, null);
    this.add(whiteBkgBlueCharLabel4, null);
    this.add(txtAccVoucherNo, null);
    this.add(whiteBkgBlueCharLabel7, null);
    this.add(txtPurchaseVoucherNo, null);

    Object objDate=exgui.verification.CellFormat.getDateStringFormaterAllowNull();
    Object dcmCnv=exgui.verification.CellFormat.getDoubleFormatDot00RiteAligne(11,2); //.getDoubleFormatAllowNull(11,2);
    Object chkCnv=exgui.verification.CellFormat.getOrdinaryField(20);
    //Object chk100Cnv=exgui.verification.CellFormat.getOrdinaryField(100);
    //java.util.Calendar cldr=java.util.Calendar.getInstance();

   dbTxtChkNo= new exgui.DataBindTextWithChecker(txtChkNo, "",
                                      "", 20,
                                      (exgui.Object2String)chkCnv,
                                      (exgui.ultratable.CellTxtEditorFormat)
                                      chkCnv);

    dbTxtAccVoucherNo= new exgui.DataBindTextWithChecker(txtAccVoucherNo, "",
                                       "", 20,
                                       (exgui.Object2String)chkCnv,
                                       (exgui.ultratable.CellTxtEditorFormat)
                                       chkCnv);

   dbTxtPurchaseVoucherNo= new exgui.DataBindTextWithChecker(txtPurchaseVoucherNo, "",
                                      "", 20,
                                      (exgui.Object2String)chkCnv,
                                      (exgui.ultratable.CellTxtEditorFormat)
                                      chkCnv);



   dbTxtChkAmt= new exgui.DataBindTextWithChecker(txtChkAmt, "",
                                      new Double(0), 13,
                                      (exgui.Object2String)dcmCnv,
                                      (exgui.ultratable.CellTxtEditorFormat)
                                      dcmCnv);



   dbDeductDate= new exgui.DataBindTextWithChecker(txtChkDeductDate, "",
                                      new java.sql.Date(System.currentTimeMillis()), 10,
                                      (exgui.Object2String)objDate,
                                      (exgui.ultratable.CellTxtEditorFormat)
                                      objDate);


  }
  public boolean isCheckAmtDateReady(){
    if(txtChkAmt.getText().trim().length()==0||Double.parseDouble(txtChkAmt.getText().trim())==0){
      exgui.verification.VerifyLib.showAlert("Please Assign CHECK AMOUNT",
                                             "Please Assign CHECK AMOUNT");
      txtChkAmt.grabFocus();
      txtChkAmt.selectAll();
      return false;
    }
    if(dbDeductDate.getSelectedValue()==null){
      exgui.verification.VerifyLib.showAlert("Please Assign Deduct Date",
                                             "Please Assign Deduct Date");
      txtChkDeductDate.grabFocus();
      txtChkDeductDate.selectAll();
      return false;
    }

    if(dbTxtAccVoucherNo.getSelectedValue()==null){
      exgui.verification.VerifyLib.showAlert("請輸入傳票號碼",
                                             "請輸入傳票號碼");
      txtAccVoucherNo.grabFocus();
      txtAccVoucherNo.selectAll();
      return false;
    }
    return true;
  }
  class EditPolicy implements  exgui.CellEditablePolicy{
     public boolean isCellEditable(int row,int col){
       if(col==5 || col==6){
         return true;
       }
       if(col==7){
         if((pnl2list.getJtable().getValueAt(row,5)!=null &&
            pnl2list.getJtable().getValueAt(row,5).toString().trim().length()>0) ||
           (pnl2list.getJtable().getValueAt(row,6)!=null &&
            pnl2list.getJtable().getValueAt(row,6).toString().trim().length()>0))
           {

           return true;
         }else{
           return false;
         }
       }
       return false;
     }
  }
  class CellRenderAmt extends JLabel
     implements javax.swing.table.TableCellRenderer{
     public CellRenderAmt(){
     super();
    //setBorder(javax.swing.BorderFactory.createRaisedBevelBorder());
    setOpaque(true); /* it\u00B4s essential */
    setHorizontalAlignment(super.RIGHT);
 }
  public Component getTableCellRendererComponent(
        javax.swing.JTable table, Object value,
        boolean isSelected, boolean hasFocus,
        int row, int column){
       String text = (value==null)?"0":value.toString();
       text=text.equals("")?"":nf.format(Double.parseDouble(text));
       setBackground(new java.awt.Color(0xFF, 0xFF, 0xFF)); // Decides the color
       if(isSelected)setBackground(new java.awt.Color(0xFF, 0xE3, 0x8C));
       setText(text);
    return this;
   }
 }

  class Panel2List extends exgui.ultratable.FuncAbstractUltraTablePanel {
    public Panel2List(exgui.ultratable.PagedDataFactory pagedDataFxy,
                      int rowCounts,util.InsertionOrderedHashMap columnMapping,
                     java.util.Hashtable object2StringConvertor){
        super(pagedDataFxy, rowCounts, columnMapping, object2StringConvertor);
    }
    public void doPrint(){}
    public int getEachPageRowCount(){return _rowCounts;}
    public Hashtable getObject2StringConvertor() {return klmObjKvtHt;}
    public util.InsertionOrderedHashMap getHeadColumnMap(){return tblHeadColumn;}
    public exgui.ultratable.PagedDataFactory getPagedDataFactory(){return dbHandler;}
    public Record setObject2Record(Record rec,int col,Object obj){
      try{
        rec.set(storedRecordColumn[col], obj);
        //hmDDKRecords.put(rec.get(0),rec);
        return rec;
      }catch(Exception exp){
        exp.printStackTrace();
        return null;
      }
    }
    public void doUpdate()throws Exception{
      dbHandler.updateRecords(vct2update);
    }
    public void makeTable(Vector vct){
      super.makeTable(vct);
      getJtable().getColumnModel().getColumn(0).setPreferredWidth(105);
      getJtable().getColumnModel().getColumn(1).setPreferredWidth(87);
      getJtable().getColumnModel().getColumn(2).setPreferredWidth(75);
      getJtable().getColumnModel().getColumn(3).setPreferredWidth(40);
      getJtable().getColumnModel().getColumn(4).setPreferredWidth(80);
      getJtable().getColumnModel().getColumn(5).setPreferredWidth(90);
      getJtable().getColumnModel().getColumn(6).setPreferredWidth(75);
      getJtable().getColumnModel().getColumn(7).setPreferredWidth(135);

    }
    public void refineEditors(exgui.ultratable.MultiEditorJTable me ){
      me.setTextEditorVerifiers(klmObjKvtHt);
      /*
      ((exgui.MultiClassTableModel)me.getJTable().getModel()).removeEditableColumn("BLNC AMT");
      ((exgui.MultiClassTableModel)me.getJTable().getModel()).removeEditableColumn("CREATE DATE");
      me.setColumnEditable("DEDUCT AMT");
      me.setColumnEditable("OTHER AMT");
      me.setColumnEditable("  DESC  ");
      me.getJTable().getColumnModel().getColumn(3).setCellRenderer(new exgui.ultratable.CellRenderor4Amount());
      me.getJTable().getColumnModel().getColumn(4).setCellRenderer(new exgui.ultratable.CellRenderor4Amount());
      me.getJTable().getColumnModel().getColumn(5).setCellRenderer(new exgui.ultratable.CellRenderor4Amount());
      */
      ((exgui.MultiClassTableModel)me.getJTable().getModel()).setCellEditablePolicy(new EditPolicy());
      CellRenderAmt cellRdn=new CellRenderAmt();
      getJtable().getColumnModel().getColumn(3).setCellRenderer(cellRdn);
      getJtable().getColumnModel().getColumn(4).setCellRenderer(cellRdn);
      getJtable().getColumnModel().getColumn(5).setCellRenderer(cellRdn);
      getJtable().getColumnModel().getColumn(6).setCellRenderer(cellRdn);
    }
  }

  void btnEXIT_actionPerformed(ActionEvent e) {
    try{
      processhandler.template.Properties.getCenteralControler().goBack();
    }catch(Exception exp){
      exp.printStackTrace();
    }

  }

  void btnDeduct_actionPerformed(ActionEvent e) {
    try{
      if(!isCheckAmtDateReady())return;
      Object ddkDate=dbDeductDate.getSelectedValue();
      Object chkNo=dbTxtChkNo.getSelectedValue();
      Object chkAmt=dbTxtChkAmt.getSelectedValue();
      //'' as chk_no,'' as chk_amt,'' as ddk_date
      vct2update=new Vector();
      int ddkAmtAt=pnl2list.getJtable().getColumnCount()-3;
      int balanaceAmtAt=pnl2list.getJtable().getColumnCount()-4;
      int otherAmtAt=pnl2list.getJtable().getColumnCount()-2;
      int otherAmtDescAt=pnl2list.getJtable().getColumnCount()-1;
      double sumedDeductAmt=0;
      for(int i=0;i<pnl2list.getDisplayingRecords().size();i++){
        Object objDDKAmt=pnl2list.getJtable().getValueAt(i,ddkAmtAt);
        Object objOtherAmt=pnl2list.getJtable().getValueAt(i,otherAmtAt);
        double dblDDKAmt= (objDDKAmt==null)?0:Double.parseDouble(objDDKAmt.toString().equals("")?"0":objDDKAmt.toString());
        double dblOtherAmt=(objOtherAmt==null)?0:Double.parseDouble(objOtherAmt.toString().equals("")?"0":objOtherAmt.toString());
        if(dblDDKAmt!=0 || dblOtherAmt!=0){
          Object obBlanaceAmt=pnl2list.getJtable().getValueAt(i,balanaceAmtAt);
          double blanaceAmt=Double.parseDouble((obBlanaceAmt==null||obBlanaceAmt.toString().trim().equals(""))?"0":obBlanaceAmt.toString());
          if(util.MiscFunc.getDoubleAdd(dblDDKAmt,dblOtherAmt) > blanaceAmt){
            exgui.verification.VerifyLib.showAlert("Deduct  Amount Can Not Greater Than Balance Amount",
                                                   "Deduct  Amount Can Not Greater Than Balance Amount");
            pnl2list.getJtable().changeSelection(i,ddkAmtAt,false,false);
            return;
          }
          sumedDeductAmt=util.MiscFunc.getDoubleAdd(sumedDeductAmt,util.MiscFunc.getDoubleAdd(dblDDKAmt,0));
          Record rec=(Record)pnl2list.getDisplayingRecords().get(i);
          Record recBlank=dbHandler.getBlankRecord();
          recBlank.set(1,rec.get(0));//ship_no
          recBlank.set(2,ddkDate);//deduct date
          recBlank.set(3,dblDDKAmt);//ddkamt
          recBlank.set(4,chkNo);//CHK_NO
          recBlank.set(5,chkAmt);//CHK_AMT
          //Object otherAmtObj=pnl2list.getJtable().getValueAt(i,otherAmtAt);
          recBlank.set(13,dblOtherAmt);//other amt
          Object otherAmtDescObj=pnl2list.getJtable().getValueAt(i,otherAmtDescAt);
          recBlank.set(14,otherAmtDescObj);//other amt desc
          recBlank.set(15,dbTxtAccVoucherNo.getSelectedValue());//acc voucher no
          recBlank.set(16,dbTxtPurchaseVoucherNo.getSelectedValue());//purchase voucher no
          recBlank.set(17,rec.get(2) );//discount amt
          recBlank.set(18,rec.get(1) );//exchagne rate ,also have to keep it,in case change other time
          recBlank.set(19,rec.get(17));//discount USD amt of current local voucher.
          vct2update.add(recBlank);
        }
      }
      double orgChkAmt=Double.parseDouble((txtChkAmt.getText().trim().equals(""))?"0":txtChkAmt.getText().trim());

      //orgChkAmt=util.MiscFunc.getDoubleAdd(orgChkAmt,otherAmt);
      orgChkAmt=java.lang.Math.floor(orgChkAmt*100)/100;
      sumedDeductAmt=java.lang.Math.floor(sumedDeductAmt*100)/100;
      if(orgChkAmt!=sumedDeductAmt){
        exgui.verification.VerifyLib.showAlert("Total Deduct Amount Should Equal To Check  Amount",
                                               "Total Deduct Amount Should Equal To Check  Amount");
        txtChkAmt.grabFocus();
        txtChkAmt.selectAll();
        return;
      }
      if(vct2update.size()==0){
        exgui.verification.VerifyLib.showPlanMsg("No Amount To Deduct","No Amount To Deduct");
        return;
      }
      pnl2list.doUpdate();
      exgui.verification.VerifyLib.showPlanMsg("Deduct Ok","Deduct Ok");
      btnEXIT_actionPerformed(null);
    }catch(Exception exp){
      exp.printStackTrace();
    }
  }

  void btnFillAmt_actionPerformed(ActionEvent e) {
      int rows[]=pnl2list.getJtable().getSelectedRows();
      if(rows.length==0){
        exgui.verification.VerifyLib.showAlert("Please Select Row(s)",
                                               "Please Select Row(s)");
        return;
      }
      int balanaceAmtAt=pnl2list.getJtable().getColumnCount()-4;
      int dbkamtAt=pnl2list.getJtable().getColumnCount()-3;
      for(int i=0;i<rows.length;i++){
        pnl2list.getJtable().setValueAt(
             pnl2list.getJtable().getValueAt(rows[i],balanaceAmtAt),
             rows[i],dbkamtAt
        );
      }
  }
}
