package newtimes.accounting.debit_note;

import java.awt.*;
import exgui.*;
import javax.swing.*;
import java.awt.event.*;
import database.datatype.Record;
import java.util.*;
/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class PnlListQryDebitNote extends JPanel {
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel1 = new BlueBkgWhiteCharLabel();
  JButton btnAddNew = new JButton();
  JButton btnExit = new JButton();
  //static exgui.ultratable.PagedTablePanel Pnl2List=null;
  Panel2List Pnl2List=null;
  public PnlListQryDebitNote() {
    try {
      jbInit();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }

  protected void jbInit() throws Exception {
    blueBkgWhiteCharLabel1.setText("Listing Of Debit Notes");
    blueBkgWhiteCharLabel1.setBounds(new Rectangle(-48, 19, 861, 37));
    this.setBackground(new Color(202, 202, 244));
    this.setLayout(null);
    btnAddNew.setBounds(new Rectangle(70, 537, 112, 27));
    btnAddNew.setFont(new java.awt.Font("Dialog", 1, 11));
    btnAddNew.setText("Add New");
    btnAddNew.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnAddNew_actionPerformed(e);
      }
    });
    btnExit.setBounds(new Rectangle(549, 537, 95, 27));
    btnExit.setFont(new java.awt.Font("Dialog", 1, 11));
    btnExit.setText("EXIT");
    btnExit.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnExit_actionPerformed(e);
      }
    });

    this.add(blueBkgWhiteCharLabel1, null);
    if(Pnl2List==null){
        generatePnl2List();
    }
    this.add(Pnl2List,null);
    this.add(btnExit, null);
    this.add(btnAddNew, null);
  }
  void generatePnl2List(){
    Object objDateConv=exgui.verification.CellFormat.getDateStringFormaterAllowNull();
    java.util.Hashtable ht=new java.util.Hashtable();
    ht.put(" CREATE DATE ",objDateConv);
    util.InsertionOrderedHashMap iso=new util.InsertionOrderedHashMap();
    iso.put("    DB/CR #   ","DBNT_NO");
    iso.put(" CREATE DATE ","record_create_date");
    iso.put("          BUYER/MAKER    NAME      ","DBNT_BYMKR_NAME");
    iso.put(" AMOUNT ","DBNT_TOTAL_AMT");
    iso.put("DETAIL","dots");
    iso.put("²Ó¶µ","dots2payDtl");
    iso.put("¾P±b","Deduct");
    Pnl2List=new Panel2List(
      new newtimes.accounting.debit_note.DbDebitNoteHead(),
                                                   15,iso,ht);
    Pnl2List.setBounds(new Rectangle(15, 75, 778, 461));
    Pnl2List.getJtable().addMouseListener(new MyMouseListener());
    Pnl2List._rowPosition=Constans.BGN_POS_OF_QRY_DRCR_NO;
    Pnl2List.reload();
    Pnl2List.getJtable().setRowHeight(25);

  }
  class MyMouseListener extends java.awt.event.MouseAdapter{
    public void readyRecord()throws Exception{
      util.PublicVariable.APP_FRAME.getContentPane().setCursor(new Cursor(Cursor.WAIT_CURSOR));
      Constans.BGN_POS_OF_QRY_DRCR_NO=Pnl2List._rowPosition;
        Record recOrg=(Record)Pnl2List.getDisplayingRecords().get(Pnl2List.getJtable().getSelectedRow());
        newtimes.accounting.debit_note.Constans.EDITING_DEBITNOTE_HEAD_ECORD=
          Constans.DEBIT_NOTE_HEAD_DBHANDLER.getRecordByPk((String)recOrg.get(0));
    }
    public void mouseClicked(java.awt.event.MouseEvent me){
     if(Pnl2List.getJtable().getSelectedRow()!=-1) {
       Object objSelected=Pnl2List.getJtable().getValueAt(Pnl2List.getJtable().getSelectedRow(),
                                                          Pnl2List.getJtable().getSelectedColumn());

       try{

       //last column is to detail action.
       if(Pnl2List.getJtable().getSelectedColumn()==Pnl2List.getJtable().getColumnCount()-1){
         if(objSelected.equals(""))return;
         readyRecord();
         processhandler.template.Properties.getCenteralControler().
             doCommandExecute(
             new newtimes.accounting.debit_note.TgrListDDKOfADbcr());
        }else  if(Pnl2List.getJtable().getSelectedColumn()==Pnl2List.getJtable().getColumnCount()-3){
          readyRecord();
          processhandler.template.Properties.getCenteralControler().
              doCommandExecute(
              new newtimes.accounting.debit_note.TgrListDebitNoteDetail());
        }else if(Pnl2List.getJtable().getSelectedColumn()==Pnl2List.getJtable().getColumnCount()-2){
           if(objSelected.equals(""))return;
           readyRecord();
            processhandler.template.Properties.getCenteralControler().
             doCommandExecute(new newtimes.accounting.debit_note.TgrListDebitNotePayDtl());
        }else{
          readyRecord();
          processhandler.template.Properties.getCenteralControler().
              doCommandExecute(
              new newtimes.accounting.debit_note.TgrEditDebitNoteHead());
        }

       }catch(Exception exp){
         exp.printStackTrace();
       }
     }

    }
  }
  void btnAddNew_actionPerformed(ActionEvent e) {
    try{
      DlgAddDebitNoteNo dlg=new DlgAddDebitNoteNo(util.PublicVariable.APP_FRAME,
                                                  "ADD NEW DB/CR RECORD",true);
      dlg.setSize(400,325);
      exgui.UIHelper.setToScreenCenter(dlg);
      dlg.show();
      /*
       processhandler.template.Properties.getCenteralControler().doCommandExecute(

       new newtimes.accounting.debit_note.TgrEditDebitNoteHead());
        */
      }catch(Exception exp){
        exp.printStackTrace();
     }

  }

  void btnExit_actionPerformed(ActionEvent e) {
    try{
       processhandler.template.Properties.getCenteralControler().goBack();
    }catch(Exception exp){
      exp.printStackTrace();
     }

  }
  class Panel2List extends processhandler.template.PnlTableEditor{
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
    public Record setObject2Record(Record rec,int col,Object obj){return null;}
    public void refineEditors(exgui.ultratable.MultiEditorJTable me ){
      CellRender cellrdr=new CellRender();
      this.getJtable().getColumnModel().getColumn(0).setCellRenderer(new CellRender4DbCrNo());
      this.getJtable().getColumnModel().getColumn(3).setCellRenderer(new CellRenderAmt());
      this.getJtable().getColumnModel().getColumn(4).setCellRenderer(cellrdr);
      this.getJtable().getColumnModel().getColumn(5).setCellRenderer(cellrdr);
      this.getJtable().getColumnModel().getColumn(6).setCellRenderer(cellrdr);
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
       String text = (value==null)?"":value.toString();
       setBackground(new java.awt.Color(0xFF, 0xFF, 0xFF)); // Decides the color
       if(isSelected)setBackground(new java.awt.Color(0xFF, 0xE3, 0x8C));
       setText(text);
    return this;
   }
 }

 class CellRender4DbCrNo extends JLabel
     implements javax.swing.table.TableCellRenderer{
     public CellRender4DbCrNo(){
     super();
    //setBorder(javax.swing.BorderFactory.createRaisedBevelBorder());
    setOpaque(true); /* it\u00B4s essential */
    setHorizontalAlignment(JLabel.LEADING);
 }
  public Component getTableCellRendererComponent(
        javax.swing.JTable table, Object value,
        boolean isSelected, boolean hasFocus,
        int row, int column){
       String text = (value==null)?"":value.toString();
       if(text.length()>12){
         text=text.substring(text.length()-12,text.length());
       }
       setBackground(new java.awt.Color(0xFF, 0xFF, 0xFF)); // Decides the color
       if(isSelected)setBackground(new java.awt.Color(0xFF, 0xE3, 0x8C));
       setText(text);
    return this;
   }
 }

  class CellRender extends JLabel
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
        String text = (value==null)?"":value.toString();
        if(text.trim().equals("")){
          setBackground(new java.awt.Color(0xFF, 0xFF, 0xFF)); // Decides the color
        }else{
            setBackground(new java.awt.Color(0xE0, 0xE0, 0xE0)); // Decides the color
        }
        setText(text);
     return this;
    }
  }

}
