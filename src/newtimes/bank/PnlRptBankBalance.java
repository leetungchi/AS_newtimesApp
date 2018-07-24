package newtimes.bank;
import java.awt.*;
import exgui.*;
import javax.swing.*;
import newtimes.preproduction.buyermakerselect.*;
import java.awt.event.*;
import newtimes.production.report.*;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class PnlRptBankBalance
    //extends JPanel {
    extends AbsQryPanel{
  JTextField txpPayDate = new JTextField();
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel3 = new BlueBkgWhiteCharLabel();
  JComboBox cbxBank = new JComboBox();
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel7 = new BlueBkgWhiteCharLabel();
  JComboBox cbxCompany = new JComboBox();
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel2 = new BlueBkgWhiteCharLabel();
  JButton btnPrint = new JButton();
  WhiteBkgBlueCharLabel whiteBkgBlueCharLabel1 = new WhiteBkgBlueCharLabel();
  exgui.DataBindJCombobox DbJcbxcbxCompany,DbJcbxcbxBank;
  exgui.DataBindTextWithChecker dbTxtPayDate;
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel4 = new BlueBkgWhiteCharLabel();
  JComboBox formCbx = new JComboBox();
  public PnlRptBankBalance() {
    try {
      //jbInit();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }

  void jbInit() throws Exception {
    whiteBkgBlueCharLabel1.setBounds(new Rectangle(-1, 2, 804, 28));
    whiteBkgBlueCharLabel1.setText("BALANCE REPORT");
    btnPrint.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnPrint_actionPerformed(e);
      }
    });
    btnPrint.setText("PRINT");
    btnPrint.setFont(new java.awt.Font("Dialog", 1, 11));
    btnPrint.setBounds(new Rectangle(628, 35, 149, 27));
    blueBkgWhiteCharLabel2.setText("COMPANY:");
    blueBkgWhiteCharLabel2.setBounds(new Rectangle(1, 35, 113, 23));
    cbxCompany.setBounds(new Rectangle(114, 35, 123, 22));
    cbxCompany.addItemListener(new java.awt.event.ItemListener() {
      public void itemStateChanged(ItemEvent e) {
        cbxCompany_itemStateChanged(e);
      }
    });
    blueBkgWhiteCharLabel7.setText("PAY-DD");
    blueBkgWhiteCharLabel7.setBounds(new Rectangle(449, 35, 72, 23));
    cbxBank.setBounds(new Rectangle(314, 35, 132, 22));
    blueBkgWhiteCharLabel3.setBounds(new Rectangle(240, 35, 73, 23));
    blueBkgWhiteCharLabel3.setText("BANK:");
    txpPayDate.setBounds(new Rectangle(521, 35, 58, 23));
    txpPayDate.setText("");
    formCbx.addItem("Form 1");
    formCbx.addItem("Form 2");
    formCbx.addItem("Form 3");

    formCbx.setSelectedItem("Form 1");
    this.setLayout(null);
    this.setBackground(new Color(202, 202, 224));
    blueBkgWhiteCharLabel4.setBounds(new Rectangle(1, 62, 113, 23));
    blueBkgWhiteCharLabel4.setToolTipText("");
    blueBkgWhiteCharLabel4.setText("FORM TYPE :");
    formCbx.setBounds(new Rectangle(116, 61, 122, 24));
    this.add(whiteBkgBlueCharLabel1, null);
    this.add(btnPrint, null);
    this.add(blueBkgWhiteCharLabel2, null);
    this.add(cbxCompany, null);
    this.add(blueBkgWhiteCharLabel3, null);
    this.add(cbxBank, null);
    this.add(blueBkgWhiteCharLabel7, null);
    this.add(txpPayDate, null);
    this.add(blueBkgWhiteCharLabel4, null);
    this.add(formCbx, null);
    genDataBindObj();


  }
  void cbxCompany_itemStateChanged(ItemEvent e) {

  }
  public void genDataBindObj(){
    super.dataBindComps.clear();
    java.util.Vector vctCompany = Constants.vctCompany;
    Object vftxtChkDD=RocDateFormator.getRocDateFormat();
    DbJcbxcbxCompany =
        new exgui.DataBindJCombobox(cbxCompany,"P_COMP",
                                    vctCompany,
                                    "COMPANY_NAME",
                                    "COMPANY_CODE", "ALL", "ALL", "ALL");
   dataBindComps.add(DbJcbxcbxCompany);

    java.util.Vector vctBanks = Constants.vctBank;
    DbJcbxcbxBank =
        new exgui.DataBindJCombobox(cbxBank, "P_BANK",
                                    vctBanks, "BANK_NAME", "BANK_CODE", "ALL",
                                    "ALL", "ALL");
   dataBindComps.add(DbJcbxcbxBank);

   java.util.GregorianCalendar gc=new java.util.GregorianCalendar();
   gc.set(gc.MONTH ,gc.DECEMBER);
   gc.set(gc.DATE,31);
   dbTxtPayDate = new exgui.DataBindTextWithChecker(txpPayDate,
       "P_PAY_DD",
       new java.sql.Date(gc.getTimeInMillis()), 9,
       (exgui.Object2String)vftxtChkDD,
       (exgui.ultratable.CellTxtEditorFormat)vftxtChkDD);
   dataBindComps.add(dbTxtPayDate);

  }
  void btnPrint_actionPerformed(ActionEvent e) {
    if (formCbx.getSelectedItem().toString().equals("Form 3") ) {
      newtimes.production.report.ReportCmdSet.myReportEngin.reportServerURL=
     "http://rpt2.nttpe.com.tw:9000/?file:///cc53//rpt//";
         super.reportName = "BANK_BLNC3.rpt";
    } else {
         super.reportName = "BANK_BLNC.rpt";
    }
   if (formCbx.getSelectedItem().toString().equals("Form 1") ) {
     newtimes.production.report.ReportCmdSet.myReportEngin.reportServerURL=
     "http://rpt2.nttpe.com.tw:9000/?file:///cc53//rpt//";
        super.reportName = "BANK_BLNC1.rpt";
   }
   super.JButtonQueryButtonAction(e);
   newtimes.production.report.ReportCmdSet.myReportEngin.reportServerURL=
   "http://rpt.nttpe.com.tw:9000/?file:///d://rpt//";

  }
}
