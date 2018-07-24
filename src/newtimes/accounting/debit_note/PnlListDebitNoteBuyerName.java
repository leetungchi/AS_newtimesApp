package newtimes.accounting.debit_note;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
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

public class PnlListDebitNoteBuyerName extends JPanel {
  JPanel jPanel1 = new JPanel();
  Border border1;
  TitledBorder titledBorder1;
  JButton btnAdd = new JButton();
  JButton btnExit = new JButton();
  exgui.ultratable.PagedTablePanel pnlListBuyerName=null;
  DlgListDebitNoteBuyerName parentDlg=null;
  PnlListDebitNoteBuyerName pnlListDebitNoteBuyerNameThis;
  public PnlListDebitNoteBuyerName() {
    try {
      jbInit();
      pnlListDebitNoteBuyerNameThis=this;
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }

  void jbInit() throws Exception {
    border1 = BorderFactory.createEtchedBorder(Color.white,new Color(148, 145, 140));
    titledBorder1 = new TitledBorder(BorderFactory.createEtchedBorder(Color.white,new Color(148, 145, 140)),"List Of Buyer Name,Click Any Row to Edit/Delete");
    this.setLayout(null);
    jPanel1.setBorder(titledBorder1);
    jPanel1.setBounds(new Rectangle(13, 18, 417, 387));
    btnAdd.setBounds(new Rectangle(299, 426, 121, 30));
    btnAdd.setFont(new java.awt.Font("Dialog", 1, 11));
    btnAdd.setText("ADD");
    btnAdd.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnAdd_actionPerformed(e);
      }
    });
    btnExit.setText("EXIT");
    btnExit.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnExit_actionPerformed(e);
      }
    });
    btnExit.setFont(new java.awt.Font("Dialog", 1, 11));
    btnExit.setForeground(Color.red);
    btnExit.setBounds(new Rectangle(40, 426, 121, 30));
    this.add(jPanel1, null);
    this.add(btnAdd, null);
    this.add(btnExit, null);
    util.InsertionOrderedHashMap iso=new util.InsertionOrderedHashMap();
    iso.put("BUYER NAME","bymkr_name");
    iso.put("D/B BUYER NAME","DBNT_BYMKR_NAME");
    pnlListBuyerName=
        new exgui.ultratable.PagedTablePanel(new TempDb(),20,iso,null);
   pnlListBuyerName.setSize(jPanel1.getSize());
   pnlListBuyerName.setBounds(jPanel1.getBounds());
   pnlListBuyerName.setBorder(jPanel1.getBorder());
   pnlListBuyerName.getJtable().addMouseListener(new MouseClick());
   this.remove(jPanel1);
   this.add(pnlListBuyerName,null);
  }
  class MouseClick extends java.awt.event.MouseAdapter{
    public void mouseClicked(java.awt.event.MouseEvent me){
       Record rec=(Record)pnlListBuyerName.getDisplayingRecords().get(
       pnlListBuyerName.getJtable().getSelectedRow());
       DlgEditDebitNoteBuyerName dlg = new
           DlgEditDebitNoteBuyerName(util.PublicVariable.APP_FRAME,
                                  "Edit Buyer Name", true, rec);
      dlg.setSize(530,265);
      dlg.pnlParent=pnlListDebitNoteBuyerNameThis;
      exgui.UIHelper.setToScreenCenter(dlg);
      dlg.show();

    }
  }
  class TempDb extends exgui.ultratable.PagedDataFactoryAdapter {
    String sql=null;
    TempDb(){
      StringBuffer sb=new StringBuffer();
      sb.append("select ");
         sb.append("a.DBNT_BYMKR_NAME, ");//0
         sb.append("a.DBNT_BYMKR_SEQ, ");//1
         sb.append("b.bymkr_name, ");//2
         sb.append("a.DBNT_BYMKR_NAME as org_name, ");//3
         sb.append("a.DBNT_BYMKR_SEQ as org_bymnkr_seq, ");//4
         sb.append("a.record_delete_flag, ");
         sb.append("a.record_modify_user, ");
         sb.append("a.record_modify_date ");
      sb.append("from DEBITNOTE_BYMKR_NAME a, buyer_maker b ");
      sb.append("where a.DBNT_BYMKR_SEQ=b.bymkr_seq ");
      sb.append("order by DBNT_BYMKR_SEQ ");
      sql=sb.toString();
    }
    public Vector getRecords(int bgn,int rowcount)throws Exception{
      Vector vct=exgui2.CONST.BASIC_MAIN_EJB.getDatas(
         util.PublicVariable.USER_RECORD,
         sql,bgn,rowcount);
      return vct;
    }
  }

  void btnExit_actionPerformed(ActionEvent e) {
     parentDlg.hide();
  }

  void btnAdd_actionPerformed(ActionEvent e) {
    try{
      Record rec = exgui2.CONST.BASIC_MAIN_EJB.getBlankRecord(
          "DEBITNOTE_BYMKR_NAME_tbl");
          rec.set("record_create_user",util.PublicVariable.USER_RECORD.get(0));
          rec.set("record_delete_flag","-1");
      DlgEditDebitNoteBuyerName dlg = new
          DlgEditDebitNoteBuyerName(util.PublicVariable.APP_FRAME,
                                    "Add Buyer Name", true, rec);
      dlg.pnlParent=this;
      dlg.setSize(530,265);
      exgui.UIHelper.setToScreenCenter(dlg);
      dlg.show();
    }catch(Exception exp){
      exp.printStackTrace();
    }
  }

}
