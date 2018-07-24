package newtimes.accounting.debit_note;

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

public class PnlListQryDDK extends JPanel {
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel1 = new BlueBkgWhiteCharLabel();
  JButton btnEXIT = new JButton();
  JButton btnDeduct = new JButton();
  JButton btnFillAmt = new JButton();
  Panel2List pnl2list = null;
  DbDebitNoteDDK dbHandler=new DbDebitNoteDDK();
  java.util.HashMap hmDDKRecords;
  Vector vct2update;
  JTextField txtChkDeductDate = new JTextField();
  JTextField txtChkAmt = new JTextField();
  WhiteBkgBlueCharLabel whiteBkgBlueCharLabel2 = new WhiteBkgBlueCharLabel();
  JTextField txtChkNo = new JTextField();
  WhiteBkgBlueCharLabel whiteBkgBlueCharLabel1 = new WhiteBkgBlueCharLabel();
  WhiteBkgBlueCharLabel whiteBkgBlueCharLabel3 = new WhiteBkgBlueCharLabel();
  exgui.DataBindTextWithChecker dbTxtChkNo,dbTxtChkAmt,dbDeductDate;
  java.text.NumberFormat nf=new java.text.DecimalFormat("###########0.00");
  public PnlListQryDDK() {
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
   iso.put("    DB/CR    ","DBNT_NO");//0
   iso.put("  CREATE DATE  ","record_create_date");//1
   iso.put("CURRENCY","DBNT_CURRENCY");//2
   iso.put("  BALANCE AMT  ","dbcr_balance");//3
   iso.put("  DEBIT AMT    ","ddk_amt");//4
   iso.put("OTHER AMT","ddk_other_amt");//5
   iso.put("      DESCRIPTION      ","ddk_desc");//6
   Hashtable ht=new Hashtable();
   ht.put("  CREATE DATE  ",objDate);
   ht.put("  BALANCE AMT  ",dcmCnv);
   ht.put("  DEBIT AMT    ",dcmCnv);
   ht.put("OTHER AMT",dcmCnv);
   Object objChkCnv100=exgui.verification.CellFormat.getOrdinaryField(100);
   ht.put("      DESCRIPTION      ",objChkCnv100);

   pnl2list=new Panel2List(
       dbHandler,
       99999,iso,
       ht);
    pnl2list.getPanelContainsButtons().removeAll();
    pnl2list.firstPage();
 }
  void jbInit() throws Exception {
    blueBkgWhiteCharLabel1.setText("DEDUCT MAINTENANCE DEDUCT LIST");
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
    txtChkDeductDate.setBounds(new Rectangle(688, 43, 93, 26));
    txtChkAmt.setBounds(new Rectangle(407, 43, 117, 26));
    txtChkAmt.setText("jTextField1");
    txtChkAmt.setText("");
    whiteBkgBlueCharLabel2.setBounds(new Rectangle(304, 43, 101, 26));
    whiteBkgBlueCharLabel2.setText("CHECK AMT.");
    txtChkNo.setText("");
    txtChkNo.setBounds(new Rectangle(110, 43, 183, 26));
    whiteBkgBlueCharLabel1.setText("CHECK NO.");
    whiteBkgBlueCharLabel1.setBounds(new Rectangle(6, 43, 101, 26));
    whiteBkgBlueCharLabel3.setText("DEDUCT DATE");
    whiteBkgBlueCharLabel3.setBounds(new Rectangle(585, 43, 101, 26));
    this.add(blueBkgWhiteCharLabel1, null);
    this.add(btnFillAmt, null);
    this.add(btnDeduct, null);
    this.add(btnEXIT, null);
    this.add(whiteBkgBlueCharLabel3, null);
    this.add(txtChkDeductDate, null);
    this.add(whiteBkgBlueCharLabel1, null);
    this.add(txtChkNo, null);
    this.add(whiteBkgBlueCharLabel2, null);
    this.add(txtChkAmt, null);
    getPnl2List();
    pnl2list.setBounds(new Rectangle(9, 77, 780, 472));
    this.add(pnl2list, null);

    Object objDate=exgui.verification.CellFormat.getDateStringFormaterAllowNull();
    Object dcmCnv=exgui.verification.CellFormat.getDoubleFormatDot00RiteAligne(11,2); //.getDoubleFormatAllowNull(11,2);
    Object chkCnv=exgui.verification.CellFormat.getOrdinaryField(20);
    //java.util.Calendar cldr=java.util.Calendar.getInstance();
   dbTxtChkNo= new exgui.DataBindTextWithChecker(txtChkNo, "",
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
    if(txtChkAmt.getText().trim().length()==0){
       //||Double.parseDouble(txtChkAmt.getText().trim())==0){ //sometimes,just want to deduct OTHER AMT
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
    if(dbTxtChkNo.getSelectedValue()==null){
      exgui.verification.VerifyLib.showAlert("Please Assign Check No",
                                             "Please Assign Check No");
      txtChkNo.grabFocus();
      txtChkNo.selectAll();
      return false;
    }
    return true;
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
       text=nf.format(Double.parseDouble(text));
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
    public void refineEditors(exgui.ultratable.MultiEditorJTable me ){
      me.setTextEditorVerifiers(klmObjKvtHt);
      ((exgui.MultiClassTableModel)me.getJTable().getModel()).removeEditableColumn("  BALANCE AMT  ");
      ((exgui.MultiClassTableModel)me.getJTable().getModel()).removeEditableColumn("  CREATE DATE  ");
      me.setColumnEditable("  DEBIT AMT    ");
      me.setColumnEditable("OTHER AMT");
      me.setColumnEditable("      DESCRIPTION      ");

      javax.swing.table.TableCellRenderer amtRdr=new exgui.ultratable.CellRenderor4Amount();
      me.getJTable().getColumnModel().getColumn(3).setCellRenderer(amtRdr);
      me.getJTable().getColumnModel().getColumn(4).setCellRenderer(amtRdr);
      me.getJTable().getColumnModel().getColumn(5).setCellRenderer(amtRdr);
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
      int dbAmtAt=4;//pnl2list.getJtable().getColumnCount()-1;
      int balanaceAmtAt=3;//pnl2list.getJtable().getColumnCount()-2;
      int otherAmtAt=5;
      int ddkDescAt=6;
      double sumedDeductAmt=0;

      for(int i=0;i<pnl2list.getDisplayingRecords().size();i++){
        Object objDdkAmt=pnl2list.getJtable().getValueAt(i,dbAmtAt);
        Object objOther=pnl2list.getJtable().getValueAt(i,otherAmtAt);

        double deductAmt=Double.parseDouble((objDdkAmt==null||objDdkAmt.toString().trim().equals(""))?"0":objDdkAmt.toString());
        double otherAmt=Double.parseDouble((objOther==null||objOther.toString().trim().equals(""))?"0":objOther.toString());
        //for credit ,have to conver ddk amt & other amt to minus
        String dbntno=pnl2list.getJtable().getValueAt(i,0).toString();
        //MM0712C005
        boolean isCrdit=false;
        if(dbntno.substring(6,7).equals("C")){
          deductAmt=-1*deductAmt;
          otherAmt=-1*otherAmt;
          isCrdit=true;
        }

        if(deductAmt!=0 || otherAmt!=0){
          Object obBlanaceAmt=pnl2list.getJtable().getValueAt(i,balanaceAmtAt);
          double blanaceAmt=Double.parseDouble((obBlanaceAmt==null||obBlanaceAmt.toString().trim().equals(""))?"0":obBlanaceAmt.toString());
          if(java.lang.Math.abs(deductAmt)>blanaceAmt){
            exgui.verification.VerifyLib.showAlert("Deduct Amount Can Not Greater Than Balance Amount",
                                                   "Deduct Amount Can Not Greater Than Balance Amount");
            pnl2list.getJtable().changeSelection(i,dbAmtAt,false,false);
            return;
          }
          sumedDeductAmt=util.MiscFunc.getDoubleAdd(sumedDeductAmt,deductAmt);
          Record rec=(Record)pnl2list.getDisplayingRecords().get(i);
          Object ddkDesc=pnl2list.getJtable().getValueAt(i,ddkDescAt);
          Record recBlank=dbHandler.getBlankRecord();
          recBlank.set(1,rec.get(0));//dbcr No.
          recBlank.set(2,ddkDate);//deduct date
          recBlank.set(3,objDdkAmt);//ddkamt
          recBlank.set(4,chkNo);//CHK_NO
          recBlank.set(5,chkAmt);//CHK_AMT
          //recBlank.set(13,otherAmt);
          recBlank.set(13,objOther);
          recBlank.set(14,ddkDesc);
          vct2update.add(recBlank);
        }
      }
      double orgChkAmt=Double.parseDouble((txtChkAmt.getText().trim().equals(""))?"0":txtChkAmt.getText().trim());
            orgChkAmt=java.lang.Math.floor(orgChkAmt*100)/100;
            sumedDeductAmt=java.lang.Math.floor(sumedDeductAmt*100)/100;
      if(orgChkAmt!=sumedDeductAmt){
        exgui.verification.VerifyLib.showAlert("Total Deduct Amount Should Equal To Check Amount",
                                               "Total Deduct Amount Should Equal To Check Amount");
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
      int balanaceAmtAt=3;//pnl2list.getJtable().getColumnCount()-2;
      int dbamtAt=4;//pnl2list.getJtable().getColumnCount()-1;
      for(int i=0;i<rows.length;i++){
        pnl2list.getJtable().setValueAt(
             pnl2list.getJtable().getValueAt(rows[i],balanaceAmtAt),
             rows[i],dbamtAt
        );
      }
  }
}
