package newtimes.general_voucher;

import java.awt.*;
import exgui.*;
import javax.swing.*;
import java.awt.event.*;
import newtimes.general_voucher.rush.*;
/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class PnlGvBasicFunList extends JPanel {
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel1 = new BlueBkgWhiteCharLabel();
  JButton btnExit = new JButton();
  JButton btnAccItem = new JButton();
  JButton btnVhAccMtn = new JButton();
  JButton btnTelCodeMaintain = new JButton();
  JButton btnRush = new JButton();
  JButton btnAccChkGap = new JButton();
  JButton btnAccSpecial = new JButton();
  JButton btnFileRestore = new JButton();
  JButton btnRptAccOptCost = new JButton();
  JButton btnFormMaintain = new JButton();
  JButton btnRptAccSS = new JButton();
  JButton btnRptAccAsstLiab = new JButton();
  JButton bntRptAccCostOfset = new JButton();
  JButton bntF107FuncList = new JButton();
  JButton btnRptAcc5123 = new JButton();
  JButton btnVhAccBatchMtn = new JButton();
  JButton btnAirCoMtn = new JButton();
  JButton btnTvlAgcMtn = new JButton();
  JButton btnSeatClassMtn = new JButton();
  JButton btnTktType = new JButton();

  public PnlGvBasicFunList() {
    try {
      jbInit();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }

  void jbInit() throws Exception {
    blueBkgWhiteCharLabel1.setText("GENERAL VOUCHER MIS");
    blueBkgWhiteCharLabel1.setBounds(new Rectangle(-2, 15, 802, 33));
    this.setBackground(new Color(202, 202, 224));
    this.setLayout(null);
    btnExit.setBounds(new Rectangle(361, 527, 77, 31));
    btnExit.setFont(new java.awt.Font("Dialog", 1, 11));
    btnExit.setText("EXIT");
    btnExit.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnExit_actionPerformed(e);
      }
    });
    btnAccItem.setBackground(Color.white);
    btnAccItem.setBounds(new Rectangle(98, 61, 245, 35));
    btnAccItem.setFont(new java.awt.Font("Dialog", 1, 11));
    btnAccItem.setText("ACCOUNTING ITEM MAINTAIN");
    btnAccItem.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnAccItem_actionPerformed(e);
      }
    });
    btnVhAccMtn.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnVhAccMtn_actionPerformed(e);
      }
    });
    btnVhAccMtn.setText("VOUCHER ACCOUNT MAINTAIN");
    btnVhAccMtn.setFont(new java.awt.Font("Dialog", 1, 11));
    btnVhAccMtn.setBounds(new Rectangle(98, 115, 245, 35));
    btnVhAccMtn.setBackground(Color.white);
    btnTelCodeMaintain.setBackground(Color.white);
    btnTelCodeMaintain.setBounds(new Rectangle(98, 168, 245, 35));
    btnTelCodeMaintain.setFont(new java.awt.Font("Dialog", 0, 16));
    btnTelCodeMaintain.setText("電信編號 維護");
    btnTelCodeMaintain.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnTelCodeMaintain_actionPerformed(e);
      }
    });
    btnRush.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnRush_actionPerformed(e);
      }
    });
    btnRush.setText("沖帳單元");
    btnRush.setFont(new java.awt.Font("Dialog", 0, 16));
    btnRush.setBounds(new Rectangle(98, 222, 245, 35));
    btnRush.setBackground(Color.white);
    btnAccChkGap.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnAccChkGap_actionPerformed(e);
      }
    });
    btnAccChkGap.setText("傳票張數表");
    btnAccChkGap.setFont(new java.awt.Font("Dialog", 0, 16));
    btnAccChkGap.setBounds(new Rectangle(98, 276, 245, 35));
    btnAccChkGap.setBackground(Color.white);
    btnAccSpecial.setBackground(Color.white);
    btnAccSpecial.setBounds(new Rectangle(98, 329, 245, 35));
    btnAccSpecial.setFont(new java.awt.Font("Dialog", 0, 16));
    btnAccSpecial.setText("特殊傳票");
    btnAccSpecial.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnAccSpecial_actionPerformed(e);
      }
    });
    btnFileRestore.setText("檔案截轉");
    btnFileRestore.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnFileRestore_actionPerformed(e);
      }
    });
    btnFileRestore.setFont(new java.awt.Font("Dialog", 0, 16));
    btnFileRestore.setBounds(new Rectangle(98, 385, 245, 35));
    btnFileRestore.setBackground(Color.white);
    btnRptAccOptCost.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnRptAccOptCost_actionPerformed(e);
      }
    });
    btnRptAccOptCost.setText("營業費用表");
    btnRptAccOptCost.setFont(new java.awt.Font("Dialog", 1, 14));
    btnRptAccOptCost.setBounds(new Rectangle(468, 61, 245, 35));
    btnRptAccOptCost.setBackground(Color.white);
    btnFormMaintain.setBackground(Color.white);
    btnFormMaintain.setBounds(new Rectangle(468, 222, 245, 35));
    btnFormMaintain.setFont(new java.awt.Font("Dialog", 1, 14));
    btnFormMaintain.setText("損益表欄位維護");
    btnFormMaintain.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnFormMaintain_actionPerformed(e);
      }
    });
    btnRptAccSS.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnRptAccSS_actionPerformed(e);
      }
    });
    btnRptAccSS.setText("損益表");
    btnRptAccSS.setFont(new java.awt.Font("Dialog", 1, 14));
    btnRptAccSS.setBounds(new Rectangle(468, 168, 245, 35));
    btnRptAccSS.setBackground(Color.white);
    btnRptAccAsstLiab.setBackground(Color.white);
    btnRptAccAsstLiab.setBounds(new Rectangle(468, 115, 245, 35));
    btnRptAccAsstLiab.setFont(new java.awt.Font("Dialog", 1, 14));
    btnRptAccAsstLiab.setText("資產負債表");
    btnRptAccAsstLiab.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnRptAccAsstLiab_actionPerformed(e);
      }
    });
    bntRptAccCostOfset.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        bntRptAccCostOfset_actionPerformed(e);
      }
    });
    bntRptAccCostOfset.setText("營業費用攤入表");
    bntRptAccCostOfset.setFont(new java.awt.Font("Dialog", 0, 16));
    bntRptAccCostOfset.setBounds(new Rectangle(468, 276, 245, 35));
    bntRptAccCostOfset.setBackground(Color.white);
    bntF107FuncList.setBackground(Color.white);
    bntF107FuncList.setBounds(new Rectangle(468, 329, 245, 35));
    bntF107FuncList.setFont(new java.awt.Font("Dialog", 0, 16));
    bntF107FuncList.setText("美金台幣毛利單元");
    bntF107FuncList.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        bntF107FuncList_actionPerformed(e);
      }
    });
    btnRptAcc5123.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnRptAcc5123_actionPerformed(e);
      }
    });
    btnRptAcc5123.setText("匯出外銷佣金支出明細表");
    btnRptAcc5123.setFont(new java.awt.Font("Dialog", 0, 16));
    btnRptAcc5123.setBounds(new Rectangle(468, 385, 245, 35));
    btnRptAcc5123.setBackground(Color.white);
    btnVhAccBatchMtn.setBackground(Color.white);
    btnVhAccBatchMtn.setBounds(new Rectangle(98, 441, 245, 35));
    btnVhAccBatchMtn.setFont(new java.awt.Font("Dialog", 1, 11));
    btnVhAccBatchMtn.setText("BATCH VOUCHER ACCOUNT MAINTAIN");
    btnVhAccBatchMtn.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnVhAccBatchMtn_actionPerformed(e);
      }
    });
    btnAirCoMtn.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnAirCoMtn_actionPerformed(e);
      }
    });
    btnAirCoMtn.setText("航空公司");
    btnAirCoMtn.setFont(new java.awt.Font("Dialog", 0, 16));
    btnAirCoMtn.setMargin(new Insets(0, 0, 0, 0));
    btnAirCoMtn.setBounds(new Rectangle(403, 440, 76, 35));
    btnAirCoMtn.setBackground(Color.white);
    btnTvlAgcMtn.setBackground(Color.white);
    btnTvlAgcMtn.setBounds(new Rectangle(487, 440, 76, 35));
    btnTvlAgcMtn.setFont(new java.awt.Font("Dialog", 0, 16));
    btnTvlAgcMtn.setText("旅行社");
    btnTvlAgcMtn.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnTvlAgcMtn_actionPerformed(e);
      }
    });
    btnTvlAgcMtn.setMargin(new Insets(0, 0, 0, 0));
    btnSeatClassMtn.setMargin(new Insets(0, 0, 0, 0));
    btnSeatClassMtn.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnSeatClassMtn_actionPerformed(e);
      }
    });
    btnSeatClassMtn.setText("艙等");
    btnSeatClassMtn.setFont(new java.awt.Font("Dialog", 0, 16));
    btnSeatClassMtn.setBounds(new Rectangle(571, 440, 54, 35));
    btnSeatClassMtn.setBackground(Color.white);
    btnTktType.setMargin(new Insets(0, 0, 0, 0));
    btnTktType.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnTktType_actionPerformed(e);
      }
    });
    btnTktType.setText("機票型態");
    btnTktType.setFont(new java.awt.Font("Dialog", 0, 16));
    btnTktType.setBounds(new Rectangle(633, 440, 80, 35));
    btnTktType.setBackground(Color.white);
    this.add(blueBkgWhiteCharLabel1, null);
    this.add(btnExit, null);
    this.add(btnAccItem, null);
    this.add(btnVhAccMtn, null);
    this.add(btnTelCodeMaintain, null);
    this.add(btnRush, null);
    this.add(btnRptAccOptCost, null);
    this.add(btnRptAccAsstLiab, null);
    this.add(btnRptAccSS, null);
    this.add(btnFormMaintain, null);
    this.add(bntRptAccCostOfset, null);
    this.add(bntF107FuncList, null);
    this.add(btnAccSpecial, null);
    this.add(btnAccChkGap, null);
    this.add(btnFileRestore, null);
    this.add(btnRptAcc5123, null);
    this.add(btnVhAccBatchMtn, null);
    this.add(btnTktType, null);
    this.add(btnAirCoMtn, null);
    this.add(btnTvlAgcMtn, null);
    this.add(btnSeatClassMtn, null);
    Constants.HT_ACC_COMPANY =null;
    Constants.HT_ACC_ITEM =null;

  }

  void btnExit_actionPerformed(ActionEvent e) {
    try{
       processhandler.template.Properties.getCenteralControler().goBack();
    }catch(Exception exp){
      exp.printStackTrace();
     }
  }

  void btnAccItem_actionPerformed(ActionEvent e) {
    newtimes.general_voucher.DlgAccItem dlg=new newtimes.general_voucher.DlgAccItem(util.PublicVariable.APP_FRAME,"Accounting Items",true);
    dlg.setSize(400,400);
    exgui.UIHelper.setToScreenCenter(dlg);
    dlg.show();
  }
  void btnVhAccMtn_actionPerformed(ActionEvent e) {
    try{
       Constants.initMaps();
       Constants.PNL_ACC_MAINTAIN_QRY=null;
       TgrAccDataMaintainQry tgr=new TgrAccDataMaintainQry();
       processhandler.template.Properties.getCenteralControler().doCommandExecute(tgr);
    }catch(Exception exp){
      exp.printStackTrace();
     }


  }
  void btnTelCodeMaintain_actionPerformed(ActionEvent e) {
    try{
      TgrTelCodeEdit tgr = new TgrTelCodeEdit();
      processhandler.template.Properties.getCenteralControler().
          doCommandExecute(tgr);
    }catch(Exception exp){
      exp.printStackTrace();
    }
  }
  void btnRush_actionPerformed(ActionEvent e) {
    try{
      TgrRxFuncList tgr = new TgrRxFuncList();
      processhandler.template.Properties.getCenteralControler().
          doCommandExecute(tgr);
    }catch(Exception exp){
      exp.printStackTrace();
    }

  }
  void btnAccChkGap_actionPerformed(ActionEvent e) {
    try{
      TgrRptAccChkGrp  tgr = new TgrRptAccChkGrp();
      processhandler.template.Properties.getCenteralControler().
          doCommandExecute(tgr);
    }catch(Exception exp){
      exp.printStackTrace();
    }

  }
  void btnAccSpecial_actionPerformed(ActionEvent e) {
    try{
      TgrRptAccSpecial  tgr = new TgrRptAccSpecial();
      processhandler.template.Properties.getCenteralControler().
          doCommandExecute(tgr);
    }catch(Exception exp){
      exp.printStackTrace();
    }

  }

  void btnFileRestore_actionPerformed(ActionEvent e) {
    try{
      JPasswordField pf = new JPasswordField();
      Object[] message = new Object[] {"Enter Password To Print", pf};
      Object[] options = new String[] {"OK", "Cancel"};
      JOptionPane op = new JOptionPane(
             message, JOptionPane.PLAIN_MESSAGE,
             JOptionPane.OK_CANCEL_OPTION, null, options);
      JDialog dialog = op.createDialog(null, "Enter PassWord Please");
      dialog.show();
      char chars[]=pf.getPassword();

      if(chars==null){
        return;
      }else{

        String result=new String(chars);
        if(result.trim().equals(""))return;
        if(!result.trim().equals("168168")){
          exgui.verification.VerifyLib.showAlert("Password Error",
                                                 "Password Error");
          return;
        }
      }


      newtimes.general_voucher.rush.TgrFileManagment  tgr = new newtimes.general_voucher.rush.TgrFileManagment();
      processhandler.template.Properties.getCenteralControler().
          doCommandExecute(tgr);
    }catch(Exception exp){
      exp.printStackTrace();
    }

  }
  void btnRptAccOptCost_actionPerformed(ActionEvent e) {
    try{
      processhandler.template.Properties.getCenteralControler().doCommandExecute(
      new newtimes.general_voucher.stock.TgrRptAccOptCost());
    }catch(Exception exp){
      exp.printStackTrace();
    }

  }
  void btnFormMaintain_actionPerformed(ActionEvent e) {
    try{
      processhandler.template.Properties.getCenteralControler().doCommandExecute(
      new newtimes.general_voucher.TgrFormMaintain());
    }catch(Exception exp){
      exp.printStackTrace();
    }

  }
  void btnRptAccSS_actionPerformed(ActionEvent e) {
    try{
      processhandler.template.Properties.getCenteralControler().doCommandExecute(
      new newtimes.general_voucher.TgrRptAccSS());
    }catch(Exception exp){
      exp.printStackTrace();
    }

  }
  void btnRptAccAsstLiab_actionPerformed(ActionEvent e) {
    try{
      processhandler.template.Properties.getCenteralControler().doCommandExecute(
      new newtimes.general_voucher.TgrRptAccAsstLiab());
    }catch(Exception exp){
      exp.printStackTrace();
    }

  }
  void bntRptAccCostOfset_actionPerformed(ActionEvent e) {
    try{
      processhandler.template.Properties.getCenteralControler().doCommandExecute(
      new newtimes.general_voucher.TgrRptAccCostOfset());
    }catch(Exception exp){
      exp.printStackTrace();
    }

  }
  void bntF107FuncList_actionPerformed(ActionEvent e) {
    try{
      /*
      processhandler.template.Properties.getCenteralControler().doCommandExecute(
      new newtimes.general_voucher.F107.TgrF107FuncList());
      */
     processhandler.template.Properties.getCenteralControler().doCommandExecute(
     new newtimes.general_voucher.F107.TgrF107GenMtn());

    }catch(Exception exp){
      exp.printStackTrace();
    }

  }
  void btnRptAcc5123_actionPerformed(ActionEvent e) {
    try{
      processhandler.template.Properties.getCenteralControler().doCommandExecute(
      new newtimes.general_voucher.TgrRptAcc5123());
    }catch(Exception exp){
      exp.printStackTrace();
    }

  }
  void btnVhAccBatchMtn_actionPerformed(ActionEvent e) {
    try{
      Constants.initMaps();
      Constants.PNL_ACC_MAINTAIN_QRY=null;

      TgrAccDataBatchMaintain  tgr = new TgrAccDataBatchMaintain();
      processhandler.template.Properties.getCenteralControler().
          doCommandExecute(tgr);
    }catch(Exception exp){
      exp.printStackTrace();
    }

  }

  void btnAirCoMtn_actionPerformed(ActionEvent e) {
    Dlg4AirTvlMiscMaintain.KEY_FIELD_LENGTH=2;
    Dlg4AirTvlMiscMaintain.VALUE_FIELD_LENGTH=20;
    Dlg4AirTvlMiscMaintain.KeyColumnNameInDb="CO_CODE";
    Dlg4AirTvlMiscMaintain.ValueColumnNameInDb="CO_NAME";
    Dlg4AirTvlMiscMaintain.tableName="VH_DTL_TKT_AIR_CO";
    Dlg4AirTvlMiscMaintain.REF_COLUMN="AIR_CO";
    Dlg4AirTvlMiscMaintain dlg=new Dlg4AirTvlMiscMaintain(util.PublicVariable.APP_FRAME,"航空公司",true);
    dlg.lblTitle.setText("航空公司 維護");
    dlg.setSize(530,400);
    exgui.UIHelper.setToScreenCenter(dlg);
    dlg.show();
  }
  void btnTvlAgcMtn_actionPerformed(ActionEvent e) {
    Dlg4AirTvlMiscMaintain.KEY_FIELD_LENGTH=2;
    Dlg4AirTvlMiscMaintain.VALUE_FIELD_LENGTH=20;
    Dlg4AirTvlMiscMaintain.KeyColumnNameInDb="AGC_CODE";
    Dlg4AirTvlMiscMaintain.ValueColumnNameInDb="AGC_NAME";
    Dlg4AirTvlMiscMaintain.tableName="VH_DTL_TKT_TRL_AGC";
    Dlg4AirTvlMiscMaintain.REF_COLUMN="TVL_AGNT";
    Dlg4AirTvlMiscMaintain dlg=new Dlg4AirTvlMiscMaintain(util.PublicVariable.APP_FRAME,"旅行社",true);
    dlg.lblTitle.setText("旅行社 維護");
    dlg.setSize(530,400);
    exgui.UIHelper.setToScreenCenter(dlg);
    dlg.show();

  }
  void btnSeatClassMtn_actionPerformed(ActionEvent e) {
    Dlg4AirTvlMiscMaintain.KEY_FIELD_LENGTH=1;
    Dlg4AirTvlMiscMaintain.VALUE_FIELD_LENGTH=20;
    Dlg4AirTvlMiscMaintain.KeyColumnNameInDb="CLASS_CODE";
    Dlg4AirTvlMiscMaintain.ValueColumnNameInDb="CLASS_NAME";
    Dlg4AirTvlMiscMaintain.tableName="VH_DTL_TKT_SEAT_CLASS";
    Dlg4AirTvlMiscMaintain.REF_COLUMN="SEAT_CLASS";
    Dlg4AirTvlMiscMaintain dlg=new Dlg4AirTvlMiscMaintain(util.PublicVariable.APP_FRAME,"艙等",true);
    dlg.lblTitle.setText("艙等 維護");
    dlg.setSize(530,400);
    exgui.UIHelper.setToScreenCenter(dlg);
    dlg.show();

  }
  void btnTktType_actionPerformed(ActionEvent e) {
    Dlg4AirTvlMiscMaintain.KEY_FIELD_LENGTH=1;
    Dlg4AirTvlMiscMaintain.VALUE_FIELD_LENGTH=20;
    Dlg4AirTvlMiscMaintain.KeyColumnNameInDb="TYPE_CODE";
    Dlg4AirTvlMiscMaintain.ValueColumnNameInDb="TYPE_NAME";
    Dlg4AirTvlMiscMaintain.tableName="VH_DTL_TKT_TYPE";
    Dlg4AirTvlMiscMaintain.REF_COLUMN="TKT_TYPE";
    Dlg4AirTvlMiscMaintain dlg=new Dlg4AirTvlMiscMaintain(util.PublicVariable.APP_FRAME,"機票型態",true);
    dlg.lblTitle.setText("機票型態 維護");
    dlg.setSize(530,400);
    exgui.UIHelper.setToScreenCenter(dlg);
    dlg.show();

  }
  /*
  void btnAccDbCrOffset_actionPerformed(ActionEvent e) {
    try{
      TgrRptAccDbCrOffset  tgr = new TgrRptAccDbCrOffset();
      processhandler.template.Properties.getCenteralControler().
          doCommandExecute(tgr);
    }catch(Exception exp){
      exp.printStackTrace();
    }
  }
  */
}
