package newtimes.general_voucher.daily_voucher;

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

public class PnlFeeReportList extends JPanel {
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel1 = new BlueBkgWhiteCharLabel();
  JButton btnExit = new JButton();
  JButton btnTravelFeeReport = new JButton();
  JButton btnTktFeeReport = new JButton();
  JButton btnRptTelComFee = new JButton();
  JButton btnRptTravelFeeChk = new JButton();

  public PnlFeeReportList() {
    try {
      jbInit();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }

  void jbInit() throws Exception {
    blueBkgWhiteCharLabel1.setFont(new java.awt.Font("Dialog", 0, 16));
    blueBkgWhiteCharLabel1.setText("旅費 / 郵電費 / 機票");
    blueBkgWhiteCharLabel1.setBounds(new Rectangle(-1, 19, 803, 27));
    this.setBackground(new Color(202, 202, 224));
    this.setLayout(null);
    btnExit.setBounds(new Rectangle(353, 487, 95, 28));
    btnExit.setFont(new java.awt.Font("Dialog", 1, 11));
    btnExit.setText("EXIT");
    btnExit.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnExit_actionPerformed(e);
      }
    });
    btnTravelFeeReport.setBounds(new Rectangle(232, 75, 336, 33));
    btnTravelFeeReport.setFont(new java.awt.Font("Dialog", 0, 14));
    btnTravelFeeReport.setText("旅費明細表");
    btnTravelFeeReport.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnTravelFeeReport_actionPerformed(e);
      }
    });
    btnTktFeeReport.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnTktFeeReport_actionPerformed(e);
      }
    });
    btnTktFeeReport.setText("購買機票明細表");
    btnTktFeeReport.setFont(new java.awt.Font("Dialog", 0, 14));
    btnTktFeeReport.setBounds(new Rectangle(232, 198, 336, 33));
    btnRptTelComFee.setBounds(new Rectangle(232, 260, 336, 33));
    btnRptTelComFee.setFont(new java.awt.Font("Dialog", 0, 14));
    btnRptTelComFee.setText("郵電費匯總表");
    btnRptTelComFee.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnRptTelComFee_actionPerformed(e);
      }
    });
    btnRptTravelFeeChk.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnRptTravelFeeChk_actionPerformed(e);
      }
    });
    btnRptTravelFeeChk.setText("旅費核對表");
    btnRptTravelFeeChk.setFont(new java.awt.Font("Dialog", 0, 14));
    btnRptTravelFeeChk.setBounds(new Rectangle(234, 137, 336, 33));
    this.add(blueBkgWhiteCharLabel1, null);
    this.add(btnExit, null);
    this.add(btnTravelFeeReport, null);
    this.add(btnRptTelComFee, null);
    this.add(btnTktFeeReport, null);
    this.add(btnRptTravelFeeChk, null);
  }

  void btnExit_actionPerformed(ActionEvent e) {
    try{
       processhandler.template.Properties.getCenteralControler().goBack();
    }catch(Exception exp){
      exp.printStackTrace();
     }

  }

  void btnTravelFeeReport_actionPerformed(ActionEvent e) {
    try{
      newtimes.general_voucher.daily_voucher.TgrRptFees tgr =
          new newtimes.general_voucher.daily_voucher.TgrRptFees();
      processhandler.template.Properties.getCenteralControler().
          doCommandExecute(tgr);
    } catch (Exception exp) {
      exp.printStackTrace();
    } finally {
      util.MiscFunc.hideProcessingMessage();
    }

  }
  void btnTktFeeReport_actionPerformed(ActionEvent e) {
    try{
      newtimes.general_voucher.daily_voucher.TgrRptTktFee tgr =
          new newtimes.general_voucher.daily_voucher.TgrRptTktFee();
      processhandler.template.Properties.getCenteralControler().
          doCommandExecute(tgr);
    } catch (Exception exp) {
      exp.printStackTrace();
    } finally {
      util.MiscFunc.hideProcessingMessage();
    }

  }
  void btnRptTelComFee_actionPerformed(ActionEvent e) {
    try{
      newtimes.general_voucher.daily_voucher.TgrRptTelComFee tgr =
          new newtimes.general_voucher.daily_voucher.TgrRptTelComFee();
      processhandler.template.Properties.getCenteralControler().
          doCommandExecute(tgr);
    } catch (Exception exp) {
      exp.printStackTrace();
    } finally {
      util.MiscFunc.hideProcessingMessage();
    }

  }
  void btnRptTravelFeeChk_actionPerformed(ActionEvent e) {
    try{
      newtimes.general_voucher.daily_voucher.TgrRptTravelFeeChk tgr =
          new newtimes.general_voucher.daily_voucher.TgrRptTravelFeeChk();
      processhandler.template.Properties.getCenteralControler().
          doCommandExecute(tgr);
    } catch (Exception exp) {
      exp.printStackTrace();
    } finally {
      util.MiscFunc.hideProcessingMessage();
    }

  }
}
