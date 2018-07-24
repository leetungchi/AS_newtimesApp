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

public class PnlDebitNoteDtlList extends JPanel {
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel1 = new BlueBkgWhiteCharLabel();
  JButton btnAddNew = new JButton();
  JButton btnExit = new JButton();
  exgui.ultratable.PagedTablePanel pnl2list=null;
  DbDebitNoteDetail dbHandler=new DbDebitNoteDetail();
  Record rec2Edit;
  public PnlDebitNoteDtlList() {
    try {
      Record recHead=Constans.EDITING_DEBITNOTE_HEAD_ECORD;
      Constans.QRY_DEBITNOTE_NO=(String)recHead.get("DBNT_NO");
      String currency=(String)recHead.get("DBNT_CURRENCY");
      util.InsertionOrderedHashMap iso=new util.InsertionOrderedHashMap();
      iso.put("SEQ","DBNT_DTL_ITEM_SEQ");
      iso.put("KIND","kind_desc");
      iso.put("            DESCRIPTION                ","DBNT_DTL_DESC");
      iso.put("   AMT ("+currency+")","DBNT_DTL_AMT");

      Hashtable ht=new Hashtable();
      Object objDecCnv=exgui.verification.CellFormat.getDoubleFormat(11,2);
      ht.put("   AMT ("+currency+")",objDecCnv);
      pnl2list=new PnlListDtl(dbHandler,99999,iso,ht);//new exgui.ultratable.PagedTablePanel(dbHandler,99999,iso,ht);
      pnl2list.getJtable().addMouseListener(new TblListener());
      jbInit();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }
  class PnlListDtl extends  exgui.ultratable.PagedTablePanel{
    PnlListDtl(exgui.ultratable.PagedDataFactory pgDb,int rowcount,util.InsertionOrderedHashMap iso,java.util.Hashtable ht){
      super(pgDb,rowcount,iso,ht);
    }

    public void makeTable(Vector vct){
      super.makeTable(vct);
      getJtable().getColumnModel().getColumn(0).setPreferredWidth(180);
      getJtable().getColumnModel().getColumn(1).setPreferredWidth(70);
      getJtable().getColumnModel().getColumn(2).setPreferredWidth(440);
      if(vct!=null && vct.size()>0){
         super.getJtable().getColumnModel().getColumn(3).setCellRenderer(new CellRenderAmt());
      }
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
        toEditDetail();
      }catch(Exception epx){
        epx.printStackTrace();
      }
    }
  }
  void jbInit() throws Exception {
    blueBkgWhiteCharLabel1.setText("Detail Listing of Debit Note #"+Constans.QRY_DEBITNOTE_NO);
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
    if("0".equals(Constans.EDITING_DEBITNOTE_HEAD_ECORD.get("editable_flag").toString())){
      btnAddNew.setEnabled(false);
    }
  }

  void btnAddNew_actionPerformed(ActionEvent e) {
    try{
      rec2Edit=dbHandler.getBlankRecord();
      rec2Edit.set(1,Constans.QRY_DEBITNOTE_NO);
      toEditDetail();
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
  void toEditDetail(){
    DlgContainDebitNoteDetail dlg=
        new DlgContainDebitNoteDetail(util.PublicVariable.APP_FRAME,(rec2Edit.getInt(0)<1)?"ADD DEBIT NOTE DETAIL":"EDIT DEBIT NOTE DETAIL",
                                     true,dbHandler ,rec2Edit);
    dlg.setSize(653,420);
    exgui.UIHelper.setToScreenCenter(dlg);
    dlg.show();
    pnl2list.reload();
  }

  void btnExit_actionPerformed(ActionEvent e) {
    try{
      //because amount may changed due to delete or update of detail.
       Record rec=Constans.DEBIT_NOTE_HEAD_DBHANDLER.getRecordByPk(Constans.QRY_DEBITNOTE_NO);
       Constans.EDITING_DEBITNOTE_HEAD_ECORD.set("dbnt_total_amt",rec.get("dbnt_total_amt"));
       processhandler.template.Properties.getCenteralControler().goBack();
    }catch(Exception exp){
      exp.printStackTrace();
     }

  }
}
