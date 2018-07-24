package newtimes.general_voucher.daily_voucher;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import database.datatype.*;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class DlgI5101HCXHaveDialog extends JDialog {
  JPanel panel1 = new JPanel();
  JCheckBox chkHaveSubSystem = new JCheckBox();
  JButton btnOK = new JButton();
  JButton btnExit = new JButton();
  PnlTbl2EditDailyVoucher pnlDailyVoucherEditor;
  boolean isOrgChecked=false;
  String glbSeq=null;
  public DlgI5101HCXHaveDialog(Frame frame, String title, boolean modal,PnlTbl2EditDailyVoucher _pnlDailyVoucherEditor) {
    super(frame, title, modal);
    pnlDailyVoucherEditor=_pnlDailyVoucherEditor;
    try {
      jbInit();
      pack();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }

  public DlgI5101HCXHaveDialog() {
    this(null, "", false,null);
  }

  private void jbInit() throws Exception {
    panel1.setLayout(null);
    chkHaveSubSystem.setFont(new java.awt.Font("Dialog", 1, 14));
    chkHaveSubSystem.setText("使用明細子畫面");
    chkHaveSubSystem.setBounds(new Rectangle(26, 13, 164, 26));
    btnOK.setBounds(new Rectangle(17, 47, 93, 23));
    btnOK.setFont(new java.awt.Font("Dialog", 1, 12));
    btnOK.setText("OK");
    btnOK.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnOK_actionPerformed(e);
      }
    });
    btnExit.setText("EXIT");
    btnExit.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnExit_actionPerformed(e);
      }
    });
    btnExit.setBounds(new Rectangle(143, 47, 93, 23));
    btnExit.setFont(new java.awt.Font("Dialog", 1, 12));
    this.setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
    getContentPane().add(panel1);
    panel1.add(chkHaveSubSystem, null);
    panel1.add(btnOK, null);
    panel1.add(btnExit, null);
    Record recVh=(Record)pnlDailyVoucherEditor.getDisplayingRecords().get(
      pnlDailyVoucherEditor.getJtable().getSelectedRow());
    glbSeq=recVh.get(0).toString();
    Record rec=(Record)pnlDailyVoucherEditor.htSubSystemRecords.get(glbSeq);
    //if(pnlDailyVoucherEditor.htSubSystemRecords.containsKey(glbSeq)){
    if(rec!=null && rec.getInt("record_delete_flag")>0){
      chkHaveSubSystem.setSelected(true);
      isOrgChecked=true;
    }else{
      chkHaveSubSystem.setSelected(false);
      isOrgChecked=false;
    }
  }

  void btnOK_actionPerformed(ActionEvent e) {
    boolean result=chkHaveSubSystem.isSelected();
    if(isOrgChecked!=result){
      //clear all field
      int colCount=pnlDailyVoucherEditor.getJtable().getColumnCount();
      int row=pnlDailyVoucherEditor.getJtable().getSelectedRow();
      for(int i=3;i<colCount;i++){
        pnlDailyVoucherEditor.getJtable().setValueAt(null,row,i);
      }
      //pnlDailyVoucherEditor.getJtable().
      if(result){
        //but blank record into subsystem map
        try{
          Record rec2Return=exgui2.CONST.BASIC_MAIN_EJB.getBlankRecord(
             pnlDailyVoucherEditor.TABLE_NAME_5105xHCX+"_tbl");
          rec2Return.set(0,glbSeq);
          rec2Return.set("record_delete_flag","1");
          rec2Return.set("record_create_user",util.PublicVariable.USER_RECORD.get(0));
          rec2Return.getFieldName().add("SOURCE_TABLE");
          rec2Return.getValueFields().add(pnlDailyVoucherEditor.TABLE_NAME_5105xHCX);
          //these 2 column are needed in editor dialog GUI
          rec2Return.getFieldName().add("DB_AMT");
          rec2Return.getValueFields().add(null);
          rec2Return.getFieldName().add("VH_DESC");
          rec2Return.getValueFields().add(null);
          rec2Return.getModifiedFields().clear();
          pnlDailyVoucherEditor.htSubSystemRecords.put(glbSeq,rec2Return);
        }catch(Exception exp){
          exp.printStackTrace();
        }
      }else{
        //test if have record,update to delete.
        Record recOrgSubStyem=(Record)pnlDailyVoucherEditor.htSubSystemRecords.get(glbSeq);
        if(recOrgSubStyem.get(0).toString().indexOf(".")!=-1){
          pnlDailyVoucherEditor.htSubSystemRecords.remove(glbSeq);
        }else{
          try{
            recOrgSubStyem.set("record_delete_flag","0");
            pnlDailyVoucherEditor.htSubSystemRecords.put(glbSeq,recOrgSubStyem);
          }catch(Exception exp){
               exp.printStackTrace();
           }
        }
      }
    }
    this.dispose();
  }

  void btnExit_actionPerformed(ActionEvent e) {
    this.dispose();
  }
}
