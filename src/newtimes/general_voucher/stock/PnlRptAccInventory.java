package newtimes.general_voucher.stock;

import java.awt.*;
import exgui.*;
import javax.swing.*;
import java.awt.event.*;
import exgui.*;
import javax.swing.*;
import java.awt.*;
import exgui.*;
import javax.swing.*;
import newtimes.preproduction.buyermakerselect.*;
import java.awt.event.*;
import newtimes.production.report.*;
import java.util.*;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class PnlRptAccInventory extends AbsQryPanel {
  //extends JPanel {
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel1 = new BlueBkgWhiteCharLabel();
  WhiteBkgBlueCharLabel whiteBkgBlueCharLabel1 = new WhiteBkgBlueCharLabel();
  JComboBox cbxCompany = new JComboBox();
  WhiteBkgBlueCharLabel whiteBkgBlueCharLabel2 = new WhiteBkgBlueCharLabel();
  JTextField txtYYYYMM = new JTextField();
  JButton btnQry = new JButton();
  WhiteBkgBlueCharLabel whiteBkgBlueCharLabel3 = new WhiteBkgBlueCharLabel();
  JTextField txtTitleYYYYMM = new JTextField();

  public PnlRptAccInventory() {
    try {
      jbInit();
    } catch (Exception ex) {
      ex.printStackTrace();
    }
  }

  void jbInit() throws Exception {
    blueBkgWhiteCharLabel1.setFont(new java.awt.Font("Dialog", 1, 16));
    blueBkgWhiteCharLabel1.setText("期末存貨明細表");
    blueBkgWhiteCharLabel1.setBounds(new Rectangle( -4, 8, 809, 34));
    this.setLayout(null);
    this.setBackground(new Color(202, 202, 224));
    whiteBkgBlueCharLabel1.setForeground(Color.blue);
    whiteBkgBlueCharLabel1.setHorizontalAlignment(SwingConstants.CENTER);
    whiteBkgBlueCharLabel1.setText("公司");
    whiteBkgBlueCharLabel1.setBounds(new Rectangle(12, 47, 49, 22));
    cbxCompany.setBounds(new Rectangle(62, 47, 169, 22));
    whiteBkgBlueCharLabel2.setBounds(new Rectangle(237, 46, 125, 22));
    whiteBkgBlueCharLabel2.setText("資料年月(YYYYMM)");
    whiteBkgBlueCharLabel2.setHorizontalAlignment(SwingConstants.CENTER);
    whiteBkgBlueCharLabel2.setForeground(Color.blue);
    txtYYYYMM.setText("");
    txtYYYYMM.setBounds(new Rectangle(361, 46, 70, 22));
    btnQry.setBounds(new Rectangle(669, 46, 112, 27));
    btnQry.setFont(new java.awt.Font("Dialog", 1, 11));
    btnQry.setText("REPORT");
    btnQry.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnQry_actionPerformed(e);
      }
    });
    whiteBkgBlueCharLabel3.setForeground(Color.blue);
    whiteBkgBlueCharLabel3.setHorizontalAlignment(SwingConstants.CENTER);
    whiteBkgBlueCharLabel3.setText("表頭年月(YYYYMM)");
    whiteBkgBlueCharLabel3.setBounds(new Rectangle(453, 47, 128, 22));
    txtTitleYYYYMM.setBounds(new Rectangle(580, 47, 70, 22));
    txtTitleYYYYMM.setText("");
    this.add(blueBkgWhiteCharLabel1, null);
    this.add(whiteBkgBlueCharLabel1, null);
    this.add(cbxCompany, null);
    this.add(btnQry, null);
    this.add(whiteBkgBlueCharLabel3, null);
    this.add(txtTitleYYYYMM, null);
    this.add(whiteBkgBlueCharLabel2, null);
    this.add(txtYYYYMM, null);
    genDataBindObj();
  }

  public void genDataBindObj() {
    exgui.DataBindJCombobox dbCbxCompany =
        new exgui.DataBindJCombobox(cbxCompany, "P_COMP",
                                    newtimes.general_voucher.daily_voucher.
                                    Constants.VCT_GV_ACC_COMPANY,
                                    "comp_code_and_name", "cmp_code", null,
                                    "ALL", "ALL");
    dataBindComps.add(dbCbxCompany);
    Object objyyyymmVfy = exgui.verification.CellFormat.getIntVerifierAllowNull(
        6);
    exgui.DataBindTextWithChecker dbTxtYYYYMM = new exgui.
        DataBindTextWithChecker(txtYYYYMM,
                                "P_YYYYMM",
                                "999999", 6,
                                (exgui.Object2String)objyyyymmVfy,
                                (exgui.ultratable.CellTxtEditorFormat)
                                objyyyymmVfy);
    dataBindComps.add(dbTxtYYYYMM);
    exgui.DataBindTextWithChecker dbTxtTitleYYYYMM = new exgui.
        DataBindTextWithChecker(txtTitleYYYYMM,
                                "P_TITLE_YM",
                                "999999", 6,
                                (exgui.Object2String)objyyyymmVfy,
                                (exgui.ultratable.CellTxtEditorFormat)
                                objyyyymmVfy);
    dataBindComps.add(dbTxtTitleYYYYMM);

    super.reportName = "ACC_INVENTORY.rpt";
  }

  void btnQry_actionPerformed(ActionEvent e) {
    String tmpURL = newtimes.production.report.ReportCmdSet.myReportEngin.
        reportServerURL;
    newtimes.production.report.ReportCmdSet.myReportEngin.reportServerURL =
        "http://rpt2.nttpe.com.tw:9000/?file:///cc53//rpt//";
    super.JButtonQueryButtonAction(null);
    newtimes.production.report.ReportCmdSet.myReportEngin.reportServerURL =
        tmpURL;

  }
}
