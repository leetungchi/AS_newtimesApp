package newtimes.fty_exam;

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

public class PnlEmailList extends JPanel {
  JPanel jPanel1 = new JPanel();
  Border border1;
  TitledBorder titledBorder1;
  JButton btnAdd = new JButton();
  JButton btnExit = new JButton();
  exgui.ultratable.PagedTablePanel pnlListFtyEmailPagePanel=null;
  DlgListFtyExamEmail parentDlg=null;
  PnlEmailList pnlEmailListThis;
  public PnlEmailList() {
    try {
      jbInit();
      pnlEmailListThis=this;
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
    jPanel1.setBounds(new Rectangle(13, 18, 817, 387));
    btnAdd.setBounds(new Rectangle(140, 423, 121, 30));
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
    btnExit.setBounds(new Rectangle(601, 423, 121, 30));
    this.add(jPanel1, null);
    util.InsertionOrderedHashMap iso=new util.InsertionOrderedHashMap();
    iso.put("BUYER NAME","BUYER_NAME");
    iso.put("EMAIL LIST     (Connect by \";\")    ","RCV_ADD");
    pnlListFtyEmailPagePanel=
        new exgui.ultratable.PagedTablePanel(new TempDb(),20,iso,null);
    pnlListFtyEmailPagePanel.getJtable().setRowHeight(100);
   pnlListFtyEmailPagePanel.setSize(jPanel1.getSize());
   pnlListFtyEmailPagePanel.setBounds(jPanel1.getBounds());
   pnlListFtyEmailPagePanel.setBorder(jPanel1.getBorder());
   pnlListFtyEmailPagePanel.getJtable().addMouseListener(new MouseClick());
   this.remove(jPanel1);
   this.add(pnlListFtyEmailPagePanel,null);
    this.add(btnAdd, null);
    this.add(btnExit, null);
  }
  class MouseClick extends java.awt.event.MouseAdapter{
    public void mouseClicked(java.awt.event.MouseEvent me){
       Record rec=(Record)pnlListFtyEmailPagePanel.getDisplayingRecords().get(
       pnlListFtyEmailPagePanel.getJtable().getSelectedRow());
       DlgEditFtyExamEmail dlg = new
           DlgEditFtyExamEmail(util.PublicVariable.APP_FRAME,
                                  "FTY-EMAIL CONTACT LIST", true, rec);
      dlg.setSize(630,265);
      dlg.pnlParent=pnlEmailListThis;
      exgui.UIHelper.setToScreenCenter(dlg);
      dlg.show();

    }
  }
  class TempDb extends exgui.ultratable.PagedDataFactoryAdapter {
    String sql=null;
    TempDb(){
      StringBuffer sb=new StringBuffer();
      sb.append("select * ");
      sb.append(" from fty_exam_email order by buyer_name ,seq ");
      sql=sb.toString();
    }
    public Vector getRecords(int bgn,int rowcount)throws Exception{
      Vector vct=exgui2.CONST.BASIC_MAIN_EJB.getDatas(
         util.PublicVariable.USER_RECORD,
         sql,bgn,rowcount);
      for(int i=0;i<vct.size();i++){
        Record rec=(Record)vct.get(i);
        //replace char(10) to <br>,
        String addressList=(String)rec.get(2);
        if(addressList==null)addressList="";
        addressList="<HTML><body>"+util.MiscFunc.Replace(addressList,"\n","<br>")+"</body></html>";
        rec.set(2,addressList);
        vct.set(i,rec);
      }
      return vct;
    }
  }

  void btnExit_actionPerformed(ActionEvent e) {
     parentDlg.hide();
  }

  void btnAdd_actionPerformed(ActionEvent e) {
    try{
      Record rec = exgui2.CONST.BASIC_MAIN_EJB.getBlankRecord(
          "FTY_EXAM_EMAIL_tbl");
          rec.set("record_create_user",util.PublicVariable.USER_RECORD.get(0));
          rec.set("record_delete_flag","-1");
      DlgEditFtyExamEmail dlg = new
          DlgEditFtyExamEmail(util.PublicVariable.APP_FRAME,
                                    "Add FTY-EMAIL CONTACT LIST", true, rec);
      dlg.pnlParent=this;
      dlg.setSize(630,265);
      exgui.UIHelper.setToScreenCenter(dlg);
      dlg.show();
    }catch(Exception exp){
      exp.printStackTrace();
    }
  }

}
