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

public class PnlDebitNotePayDtlList extends JPanel {
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel1 = new BlueBkgWhiteCharLabel();
  JButton btnAddNew = new JButton();
  JButton btnExit = new JButton();
  exgui.ultratable.PagedTablePanel pnl2list=null;
  DbDebitNotePayDtl dbHandler=new DbDebitNotePayDtl();
  Record rec2Edit;
  public PnlDebitNotePayDtlList() {
    try {
      Record recHead=Constans.EDITING_DEBITNOTE_HEAD_ECORD;
      Constans.QRY_DEBITNOTE_NO=(String)recHead.get("DBNT_NO");

      util.InsertionOrderedHashMap iso=new util.InsertionOrderedHashMap();
      iso.put(" BUYER ","DBNT_PAYDTL_BUYERNAME");
      iso.put("STYLE\nITEM","DBNT_PAYDTL_STY_ITEM");
      iso.put("MERCH","DBNT_PAYDTL_MERCHID");
      iso.put("MERCH\nREF","DBNT_PAYDTL_MERCHREF");
      iso.put("  FTY  ","DBNT_PAYDTL_FTY");
      iso.put(" FTY-INV ","DBNT_PAYDTL_FTY_INV");
      iso.put("CUR","DBNT_PAYDTL_CURRENCY");
      iso.put("FULL AMT.","DBNT_PAYDTL_FULLAMT");
      iso.put(" 發票號碼 ","DBNT_PAYDTL_RCPT");


      Hashtable ht=new Hashtable();
      Object objDecCnv=exgui.verification.CellFormat.getDoubleFormat(11,2);
      ht.put("FULL AMT.",objDecCnv);
      pnl2list=new exgui.ultratable.PagedTablePanel(dbHandler,99999,iso,ht);
      pnl2list.getJtable().addMouseListener(new TblListener());
      pnl2list.getJtable().getColumnModel().getColumn(7).setCellRenderer(new CellRenderAmt());
      jbInit();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }
  class CellRenderAmt extends JLabel
    implements javax.swing.table.TableCellRenderer{
   java.text.NumberFormat nf=new java.text.DecimalFormat("##########0.00");
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

  class TblListener extends java.awt.event.MouseAdapter{
    public void mouseClicked(java.awt.event.MouseEvent me){
      try{
        rec2Edit = dbHandler.getRecordByPk(
            ((Record)pnl2list.getDisplayingRecords().get(pnl2list.getJtable().
            getSelectedRow())).getInt(0));
        //(Record)pnl2list.getDisplayingRecords().get(pnl2list.getJtable().getSelectedRow());
        toEditPayDetail();
      }catch(Exception epx){
        epx.printStackTrace();
      }
    }
  }
  void jbInit() throws Exception {
    blueBkgWhiteCharLabel1.setText(" Debit Note #"+Constans.QRY_DEBITNOTE_NO+ "   細項明細");
    blueBkgWhiteCharLabel1.setBounds(new Rectangle(0, 36, 802, 25));
    this.setBackground(new Color(202, 202, 244));
    this.setLayout(null);
    pnl2list.setBounds(new Rectangle(28, 94, 749, 410));
    btnAddNew.setBounds(new Rectangle(78, 530, 85, 30));
    btnAddNew.setFont(new java.awt.Font("Dialog", 1, 11));
    btnAddNew.setText("ADD NEW");
    btnAddNew.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnAddNew_actionPerformed(e);
      }
    });
    btnExit.setBounds(new Rectangle(480, 530, 85, 30));
    btnExit.setFont(new java.awt.Font("Dialog", 1, 11));
    btnExit.setText("EXIT");
    btnExit.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnExit_actionPerformed(e);
      }
    });
    this.add(blueBkgWhiteCharLabel1, null);
    this.add(pnl2list, null);
    this.add(btnExit, null);
    this.add(btnAddNew, null);
  }

  void btnAddNew_actionPerformed(ActionEvent e) {
    try{
      rec2Edit=dbHandler.getBlankRecord();
      rec2Edit.set(1,Constans.QRY_DEBITNOTE_NO);
      toEditPayDetail();
    }catch(Exception exp){
      exp.printStackTrace();
     }
    /*
    try{
       processhandler.template.Properties.getCenteralControler().doCommandExecute(
       new newtimes.accounting.debit_note.TgrEditDebitNoteDetail());
    }catch(Exception exp){
      exp.printStackTrace();
     }*/

  }
  void toEditPayDetail(){
    DlgEditDebitNotePayDtl dlg=
        new DlgEditDebitNotePayDtl (util.PublicVariable.APP_FRAME,(rec2Edit.getInt(0)<1)?"新增細項":"細項編輯",
                                     true,dbHandler ,rec2Edit);
    dlg.setSize(600,480);
    exgui.UIHelper.setToScreenCenter(dlg);
    dlg.show();
    pnl2list.reload();
    pnl2list.getJtable().getColumnModel().getColumn(7).setCellRenderer(new CellRenderAmt());
  }

  void btnExit_actionPerformed(ActionEvent e) {
    try{
       processhandler.template.Properties.getCenteralControler().goBack();
    }catch(Exception exp){
      exp.printStackTrace();
     }

  }
}
