package newtimes.general_voucher;

import java.awt.*;
import exgui.*;
import javax.swing.*;
import java.awt.event.*;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class PnlAccDataMaintain extends JPanel {
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel1 = new BlueBkgWhiteCharLabel();
  JButton btnExit = new JButton();
  JButton btnDailyVoucher = new JButton();
  JButton btnCommonTermMtn = new JButton();
  JButton btnRptOpExp = new JButton();
  JButton btnRptBalance = new JButton();
  JButton btnFeesReport = new JButton();
  JButton btnStock = new JButton();
  JButton btnRptAccSpreadSheet = new JButton();
  JButton btnPostAndRecover = new JButton();
  JButton btnRpt5105Analyze = new JButton();
  JButton btn1102x0I3RxFucList = new JButton();
  JButton btnIrReport = new JButton();

  public PnlAccDataMaintain() {
    try {
      jbInit();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }

  void jbInit() throws Exception {
    blueBkgWhiteCharLabel1.setText("GENERAL VOUCHER DAILY");
    blueBkgWhiteCharLabel1.setBounds(new Rectangle(-3, 24, 805, 34));
    this.setLayout(null);
    btnExit.setBounds(new Rectangle(364, 525, 73, 30));
    btnExit.setFont(new java.awt.Font("Dialog", 1, 11));
    btnExit.setText("EXIT");
    btnExit.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnExit_actionPerformed(e);
      }
    });
    this.setBackground(new Color(202, 202, 224));
    btnDailyVoucher.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnDailyVoucher_actionPerformed(e);
      }
    });
    btnDailyVoucher.setText("DAILY VOUCHER");
    btnDailyVoucher.setFont(new java.awt.Font("Dialog", 1, 11));
    btnDailyVoucher.setBounds(new Rectangle(116, 70, 252, 34));
    btnDailyVoucher.setBackground(Color.white);
    btnCommonTermMtn.setBackground(Color.white);
    btnCommonTermMtn.setBounds(new Rectangle(116, 124, 252, 34));
    btnCommonTermMtn.setFont(new java.awt.Font("Dialog", 0, 16));
    btnCommonTermMtn.setFocusPainted(true);
    btnCommonTermMtn.setText("常用字 維護");
    btnCommonTermMtn.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnCommonTermMtn_actionPerformed(e);
      }
    });
    btnRptOpExp.setBackground(Color.white);
    btnRptOpExp.setBounds(new Rectangle(116, 178, 252, 34));
    btnRptOpExp.setFont(new java.awt.Font("Dialog", 0, 16));
    btnRptOpExp.setText("收入/費用明細表");
    btnRptOpExp.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnRptOpExp_actionPerformed(e);
      }
    });
    btnRptBalance.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnRptBalance_actionPerformed(e);
      }
    });
    btnRptBalance.setText("資產負債明細帳");
    btnRptBalance.setFont(new java.awt.Font("Dialog", 0, 16));
    btnRptBalance.setBounds(new Rectangle(116, 232, 252, 34));
    btnRptBalance.setBackground(Color.white);
    btnFeesReport.setBackground(Color.white);
    btnFeesReport.setBounds(new Rectangle(116, 285, 252, 34));
    btnFeesReport.setFont(new java.awt.Font("Dialog", 0, 16));
    btnFeesReport.setActionCommand("");
    btnFeesReport.setText("旅費,郵電費,機票");
    btnFeesReport.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnFeesReport_actionPerformed(e);
      }
    });
    btnStock.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnStock_actionPerformed(e);
      }
    });
    btnStock.setText("進銷存系統");
    btnStock.setActionCommand("");
    btnStock.setFont(new java.awt.Font("Dialog", 0, 16));
    btnStock.setBounds(new Rectangle(116, 339, 252, 34));
    btnStock.setBackground(Color.white);
    btnRptAccSpreadSheet.setBackground(Color.white);
    btnRptAccSpreadSheet.setBounds(new Rectangle(116, 393, 252, 34));
    btnRptAccSpreadSheet.setFont(new java.awt.Font("Dialog", 0, 16));
    btnRptAccSpreadSheet.setActionCommand("");
    btnRptAccSpreadSheet.setText("試算表");
    btnRptAccSpreadSheet.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnRptAccSpreadSheet_actionPerformed(e);
      }
    });
    btnPostAndRecover.setBackground(Color.white);
    btnPostAndRecover.setBounds(new Rectangle(116, 451, 252, 35));
    btnPostAndRecover.setFont(new java.awt.Font("Dialog", 0, 16));
    btnPostAndRecover.setText("過帳  & 還原");
    btnPostAndRecover.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnPostAndRecover_actionPerformed(e);
      }
    });
    btnRpt5105Analyze.setBackground(Color.white);
    btnRpt5105Analyze.setBounds(new Rectangle(407, 70, 252, 34));
    btnRpt5105Analyze.setFont(new java.awt.Font("Dialog", 0, 16));
    btnRpt5105Analyze.setText("GUESS 運費分析表");
    btnRpt5105Analyze.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnRpt5105Analyze_actionPerformed(e);
      }
    });
    btn1102x0I3RxFucList.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btn1102x0I3RxFucList_actionPerformed(e);
      }
    });
    btn1102x0I3RxFucList.setText("兆豐美乙 勾沖單元");
    btn1102x0I3RxFucList.setFont(new java.awt.Font("Dialog", 0, 16));
    btn1102x0I3RxFucList.setBounds(new Rectangle(407, 124, 252, 34));
    btn1102x0I3RxFucList.setBackground(Color.white);
    btnIrReport.setBackground(Color.white);
    btnIrReport.setBounds(new Rectangle(407, 178, 252, 34));
    btnIrReport.setFont(new java.awt.Font("Dialog", 0, 16));
    btnIrReport.setText("驗貨報告追蹤表");
    btnIrReport.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnIrReport_actionPerformed(e);
      }
    });
    this.add(blueBkgWhiteCharLabel1, null);
    this.add(btnExit, null);
    this.add(btnDailyVoucher, null);
    this.add(btnRpt5105Analyze, null);
    this.add(btnCommonTermMtn, null);
    this.add(btnRptOpExp, null);
    this.add(btnRptBalance, null);
    this.add(btnFeesReport, null);
    this.add(btnStock, null);
    this.add(btnRptAccSpreadSheet, null);
    this.add(btnPostAndRecover, null);
    this.add(btn1102x0I3RxFucList, null);
    this.add(btnIrReport, null);
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
  void btnDailyVoucher_actionPerformed(ActionEvent e) {
    try{
      util.MiscFunc.showProcessingMessage();
      newtimes.general_voucher.daily_voucher.Constants.hmCompanyAndAccCodeTwName=null;
      newtimes.general_voucher.daily_voucher.Constants.VCT_GV_ACC_COMPANY=null;
      newtimes.general_voucher.daily_voucher.Constants.VCT_STAFF=null;
      newtimes.general_voucher.daily_voucher.Constants.COMMON_TERMS=null;
      newtimes.general_voucher.daily_voucher.TgrDailyVoucherQry.pnlQryGui =null;
       newtimes.general_voucher.daily_voucher.TgrDailyVoucherQry tgr=
           new newtimes.general_voucher.daily_voucher.TgrDailyVoucherQry();
       processhandler.template.Properties.getCenteralControler().doCommandExecute(tgr);
    }catch(Exception exp){
      exp.printStackTrace();
     }finally{
       util.MiscFunc.hideProcessingMessage();
     }

  }
  void btnCommonTermMtn_actionPerformed(ActionEvent e) {
    newtimes.production.ProdMaintain_Properties.setWaitCursor();
    try{
      while(!newtimes.preproduction.process.AttributeFactory.isAllAccsAttribReady()){
        try{
          Thread.currentThread().sleep(100);
        }catch(java.lang.InterruptedException ie){
        }
      }

      newtimes.general_voucher.daily_voucher.DlgCommonTermMaintain dlg=new
          newtimes.general_voucher.daily_voucher.DlgCommonTermMaintain(util.PublicVariable.APP_FRAME,
          "常用字維護",true);
       dlg.setSize(400,425);
        exgui.UIHelper.setToScreenCenter(dlg);
        dlg.show();

    }catch(Exception exp){
      exp.printStackTrace();
    }finally{
       newtimes.production.ProdMaintain_Properties.setNormalCursor();
    }

  }
  void btnRptOpExp_actionPerformed(ActionEvent e) {
  try{
    newtimes.general_voucher.daily_voucher.TgrOpExpReport tgr =
        new newtimes.general_voucher.daily_voucher.TgrOpExpReport();
    processhandler.template.Properties.getCenteralControler().
        doCommandExecute(tgr);
  } catch (Exception exp) {
    exp.printStackTrace();
  } finally {
    util.MiscFunc.hideProcessingMessage();
  }

  }
  void btnRptBalance_actionPerformed(ActionEvent e) {
    try{
      newtimes.general_voucher.daily_voucher.TgrBalanceRpt tgr =
          new newtimes.general_voucher.daily_voucher.TgrBalanceRpt();
      processhandler.template.Properties.getCenteralControler().
          doCommandExecute(tgr);
    } catch (Exception exp) {
      exp.printStackTrace();
    } finally {
      util.MiscFunc.hideProcessingMessage();
    }

  }
  void btnFeesReport_actionPerformed(ActionEvent e) {
    try{
      newtimes.general_voucher.daily_voucher.TgrFeeReportList tgr =
          new newtimes.general_voucher.daily_voucher.TgrFeeReportList();
      processhandler.template.Properties.getCenteralControler().
          doCommandExecute(tgr);
    } catch (Exception exp) {
      exp.printStackTrace();
    } finally {
      util.MiscFunc.hideProcessingMessage();
    }

  }
  void btnStock_actionPerformed(ActionEvent e) {
    try{
      newtimes.general_voucher.stock.TgrStockFunList tgr =
          new newtimes.general_voucher.stock.TgrStockFunList();
      processhandler.template.Properties.getCenteralControler().
          doCommandExecute(tgr);
    } catch (Exception exp) {
      exp.printStackTrace();
    } finally {
      util.MiscFunc.hideProcessingMessage();
    }

  }
  void btnRptAccSpreadSheet_actionPerformed(ActionEvent e) {
    try{
      newtimes.general_voucher.TgrRptAccSpreadSheet tgr =
          new newtimes.general_voucher.TgrRptAccSpreadSheet();
      processhandler.template.Properties.getCenteralControler().
          doCommandExecute(tgr);
    } catch (Exception exp) {
      exp.printStackTrace();
    } finally {
      util.MiscFunc.hideProcessingMessage();
    }

  }
  void btnPostAndRecover_actionPerformed(ActionEvent e) {
    try{
      newtimes.general_voucher.rush.TgrPostAndRecover  tgr =
          new newtimes.general_voucher.rush.TgrPostAndRecover();
      processhandler.template.Properties.getCenteralControler().
          doCommandExecute(tgr);
    }catch(Exception exp){
      exp.printStackTrace();
    }

  }
  void btnRpt5105Analyze_actionPerformed(ActionEvent e) {
    try{
      newtimes.general_voucher.daily_voucher.Tgr5105AnalyzeRpt  tgr =
          new newtimes.general_voucher.daily_voucher.Tgr5105AnalyzeRpt();
      processhandler.template.Properties.getCenteralControler().
          doCommandExecute(tgr);
    }catch(Exception exp){
      exp.printStackTrace();
    }

  }
  void btn1102x0I3RxFucList_actionPerformed(ActionEvent e) {
    try{
      newtimes.general_voucher.daily_voucher.TgrShow1102x0I3RxFuncList tgr =
          new newtimes.general_voucher.daily_voucher.TgrShow1102x0I3RxFuncList();
      processhandler.template.Properties.getCenteralControler().
          doCommandExecute(tgr);
    }catch(Exception exp){
      exp.printStackTrace();
    }

  }
  void btnIrReport_actionPerformed(ActionEvent e) {
    try{
      newtimes.general_voucher.TgrIrReportUnit tgr =
          new newtimes.general_voucher.TgrIrReportUnit();
      processhandler.template.Properties.getCenteralControler().
          doCommandExecute(tgr);
    }catch(Exception exp){
      exp.printStackTrace();
    }

  }
}
