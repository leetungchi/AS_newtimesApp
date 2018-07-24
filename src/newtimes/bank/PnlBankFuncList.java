package newtimes.bank;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import exgui.*;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class PnlBankFuncList extends JPanel {
  JButton btnEditChkDtl = new JButton();
  JButton btnBankHeadEdit = new JButton();
  JButton btnExit = new JButton();
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel1 = new BlueBkgWhiteCharLabel();
  JButton btnEditPayeeItem = new JButton();
  JButton btnChkDtlRpt = new JButton();
  JButton btnBankBalance = new JButton();
  JButton btnUSDBalance = new JButton();
  JButton btnBankDeposit = new JButton();

  public PnlBankFuncList() {
    try {
      Constants.PNL4QRYBANKDTL=null;
      Constants.PNL4QRYHEAD=null;
      jbInit();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }

  void jbInit() throws Exception {
    btnBankHeadEdit.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnBankHeadEdit_actionPerformed(e);
      }
    });
    btnBankHeadEdit.setText("BANK HEAD EDIT");
    btnBankHeadEdit.setFont(new java.awt.Font("Dialog", 1, 11));
    btnBankHeadEdit.setBounds(new Rectangle(226, 76, 348, 28));
    btnEditChkDtl.setText("CHECK DETAIL");
    btnEditChkDtl.setFont(new java.awt.Font("Dialog", 1, 11));
    btnEditChkDtl.setBounds(new Rectangle(226, 115, 348, 28));
    btnEditChkDtl.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnEditChkDtl_actionPerformed(e);
      }
    });
    this.setLayout(null);
    btnExit.setBounds(new Rectangle(250, 497, 80, 24));
    btnExit.setFont(new java.awt.Font("Dialog", 1, 11));
    btnExit.setText("EXIT");
    btnExit.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnExit_actionPerformed(e);
      }
    });
    this.setBackground(new Color(202, 202, 224));
    blueBkgWhiteCharLabel1.setAlignmentY((float) 0.5);
    blueBkgWhiteCharLabel1.setText("BANK & CHECK DETAIL MAINTAIN");
    blueBkgWhiteCharLabel1.setBounds(new Rectangle(-1, 28, 803, 32));
    btnEditPayeeItem.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnEditPayeeItem_actionPerformed(e);
      }
    });
    btnEditPayeeItem.setBounds(new Rectangle(226, 154, 348, 28));
    btnEditPayeeItem.setFont(new java.awt.Font("Dialog", 1, 11));
    btnEditPayeeItem.setText("PAYEE ITEMS");
    btnChkDtlRpt.setText("CHECK DETAIL REPORT");
    btnChkDtlRpt.setFont(new java.awt.Font("Dialog", 1, 11));
    btnChkDtlRpt.setBounds(new Rectangle(228, 194, 348, 28));
    btnChkDtlRpt.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnChkDtlRpt_actionPerformed(e);
      }
    });
    btnBankBalance.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnBankBalance_actionPerformed(e);
      }
    });
    btnBankBalance.setBounds(new Rectangle(228, 233, 348, 28));
    btnBankBalance.setFont(new java.awt.Font("Dialog", 1, 11));
    btnBankBalance.setText("BANK BALANCE REPORT");
    btnUSDBalance.setText("USD BALANCE REPORT");
    btnUSDBalance.setFont(new java.awt.Font("Dialog", 1, 11));
    btnUSDBalance.setBounds(new Rectangle(228, 269, 348, 28));
    btnUSDBalance.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnUSDBalance_actionPerformed(e);
      }
    });
    btnBankDeposit.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnBankDeposit_actionPerformed(e);
      }
    });
    btnBankDeposit.setBounds(new Rectangle(229, 311, 348, 28));
    btnBankDeposit.setFont(new java.awt.Font("Dialog", 1, 11));
    btnBankDeposit.setSelectedIcon(null);
    btnBankDeposit.setText("銀行定存資料");
    this.add(btnExit, null);
    this.add(blueBkgWhiteCharLabel1, null);
    this.add(btnBankHeadEdit, null);
    this.add(btnEditChkDtl, null);
    this.add(btnEditPayeeItem, null);
    this.add(btnChkDtlRpt, null);
    this.add(btnUSDBalance, null);
    this.add(btnBankBalance, null);
    this.add(btnBankDeposit, null);
    if(Constants.vctBank.size()==0||Constants.vctCompany.size()==0){
      java.util.Vector vctCompany=exgui2.CONST.BASIC_MAIN_EJB.getDatas(
       util.PublicVariable.USER_RECORD,
       "select * from COMPANY4BANK",1,9999);
      Constants.vctCompany.clear();
      for(int i=0;i<vctCompany.size();i++){
         Constants.vctCompany.add(vctCompany.get(i));
      }


    java.util.Vector vctBanks=exgui2.CONST.BASIC_MAIN_EJB.getDatas(
     util.PublicVariable.USER_RECORD,
     "select * from bank",1,9999);
      Constants.vctBank.clear();
      for(int i=0;i<vctBanks.size();i++){
        Constants.vctBank.add(vctBanks.get(i));
      }
    }
  }
  void btnEditChkDtl_actionPerformed(ActionEvent e) {
    try{
      System.gc();
      processhandler.template.Properties.getCenteralControler().setDataProcesser(null);
      if(Constants.VCT_PAYEE_ITEMS==null) Constants.VCT_PAYEE_ITEMS=new java.util.Vector();
      Constants.VCT_PAYEE_ITEMS.clear();
      java.util.Vector vct=exgui2.CONST.BASIC_MAIN_EJB.getDatas(
      util.PublicVariable.USER_RECORD,
      "select * from BANK_PAYEE_ITEM where record_delete_flag='1' order by id",1,99999);
      Constants.VCT_PAYEE_ITEMS.addAll(vct);

      if(Constants.VCT_TYPE4USD==null) Constants.VCT_TYPE4USD=new java.util.Vector();

      Constants.VCT_TYPE4USD.clear();
      java.util.Vector vctx =exgui2.CONST.BASIC_MAIN_EJB.getDatas(
      util.PublicVariable.USER_RECORD,
      "select TYPE from BANK_TYPE4USD order by WEIGHT",1,99999);
      Constants.VCT_TYPE4USD.addAll(vctx);


      processhandler.template.Properties.getCenteralControler().doCommandExecute(
      new TgrQryChkDtl());
    }catch(Exception exp){
      exp.printStackTrace();
    }

  }
  void btnBankHeadEdit_actionPerformed(ActionEvent e) {
    try{
      processhandler.template.Properties.getCenteralControler().
          setDataProcesser(null);
      processhandler.template.Properties.getCenteralControler().doCommandExecute(
      new TgrQryBankHead());
    }catch(Exception exp){
      exp.printStackTrace();
    }

  }

  void btnExit_actionPerformed(ActionEvent e) {
    try{
      processhandler.template.Properties.getCenteralControler().
          setDataProcesser(null);
      processhandler.template.Properties.getCenteralControler().goBack();
    }catch(Exception exp){
      exp.printStackTrace();
    }

  }
  void btnEditPayeeItem_actionPerformed(ActionEvent e) {
    DlgEditCommonPayeeItem dlg=new DlgEditCommonPayeeItem(util.PublicVariable.APP_FRAME,"PAYEE ITEM EDIT FUNCTION",true);
    dlg.setSize(260,400);
    exgui.UIHelper.setToScreenCenter(dlg);
    dlg.show();
  }
  void btnChkDtlRpt_actionPerformed(ActionEvent e) {
    try{
      if(Constants.VCT_PAYEE_ITEMS==null) Constants.VCT_PAYEE_ITEMS=new java.util.Vector();
      Constants.VCT_PAYEE_ITEMS.clear();
      java.util.Vector vct=exgui2.CONST.BASIC_MAIN_EJB.getDatas(
      util.PublicVariable.USER_RECORD,
      "select * from BANK_PAYEE_ITEM where record_delete_flag='1' order by id",1,99999);
      Constants.VCT_PAYEE_ITEMS.addAll(vct);

      processhandler.template.Properties.getCenteralControler().
          setDataProcesser(null);
      processhandler.template.Properties.getCenteralControler().doCommandExecute(
      new TgrChkDtlRpt());
    }catch(Exception exp){
      exp.printStackTrace();
    }

  }
  void btnBankBalance_actionPerformed(ActionEvent e) {
    try{
      processhandler.template.Properties.getCenteralControler().
          setDataProcesser(null);
      processhandler.template.Properties.getCenteralControler().doCommandExecute(
        new TgrBankBalanceRpt()
      );
    }catch(Exception exp){
      exp.printStackTrace();
    }

  }
  void btnUSDBalance_actionPerformed(ActionEvent e) {
    try{
        processhandler.template.Properties.getCenteralControler().
        setDataProcesser(null);
        processhandler.template.Properties.getCenteralControler().doCommandExecute(
        new TgrUSDBalanceRpt()
 );
}catch(Exception exp){
 exp.printStackTrace();
}

  }
  void btnBankDeposit_actionPerformed(ActionEvent e) {
    try{
  processhandler.template.Properties.getCenteralControler().
  setDataProcesser(null);
  processhandler.template.Properties.getCenteralControler().doCommandExecute(
    new TgrBankDeposit()
  );
}catch(Exception exp){
exp.printStackTrace();
}

  }
}
