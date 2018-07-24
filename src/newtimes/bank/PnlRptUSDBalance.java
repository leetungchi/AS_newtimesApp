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

public class PnlRptUSDBalance
    //extends JPanel {
    extends AbsQryPanel{
  JTextField txpPayDate = new JTextField();
  JTextField txpPayDateTo = new JTextField();
  JLabel ll = new JLabel("To");
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel3 = new BlueBkgWhiteCharLabel();
  JComboBox cbxBank = new JComboBox();
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel7 = new BlueBkgWhiteCharLabel();
  JComboBox cbxCompany = new JComboBox();
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel2 = new BlueBkgWhiteCharLabel();
  JButton btnPrint = new JButton();
  WhiteBkgBlueCharLabel whiteBkgBlueCharLabel1 = new WhiteBkgBlueCharLabel();
  exgui.DataBindJCombobox DbJcbxcbxCompany,DbJcbxcbxBank;
  exgui.DataBindTextWithChecker dbTxtPayDate;
   exgui.DataBindTextWithChecker dbTxtPayDateTo;
  public PnlRptUSDBalance() {
    try {
      //jbInit();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }

  void jbInit() throws Exception {
    whiteBkgBlueCharLabel1.setBounds(new Rectangle(-1, 2, 804, 28));
    whiteBkgBlueCharLabel1.setText("USD BALANCE REPORT");
    btnPrint.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnPrint_actionPerformed(e);
      }
    });
    btnPrint.setText("PRINT");
    btnPrint.setFont(new java.awt.Font("Dialog", 1, 11));
    btnPrint.setBounds(new Rectangle(632, 40, 149, 27));
    blueBkgWhiteCharLabel2.setText("COMPANY:");
    blueBkgWhiteCharLabel2.setBounds(new Rectangle(5, 40, 113, 23));
    cbxCompany.setBounds(new Rectangle(118, 40, 123, 22));
    cbxCompany.addItemListener(new java.awt.event.ItemListener() {
      public void itemStateChanged(ItemEvent e) {
        cbxCompany_itemStateChanged(e);
      }
    });
    blueBkgWhiteCharLabel7.setText("PAY-DD");
    blueBkgWhiteCharLabel7.setBounds(new Rectangle(253, 40, 72, 23));
    /*
    cbxBank.setBounds(new Rectangle(318, 40, 132, 22));
    blueBkgWhiteCharLabel3.setBounds(new Rectangle(244, 40, 73, 23));
    blueBkgWhiteCharLabel3.setText("BANK:");
    */
      txpPayDate.setBounds(new Rectangle(327, 40, 65, 23));
      txpPayDateTo.setBounds(new Rectangle(427, 40, 65, 23));
      ll.setBounds(new Rectangle(400, 42, 65, 23));
    txpPayDate.setText("");
     txpPayDateTo.setText("");
    this.setLayout(null);
    this.setBackground(new Color(202, 202, 224));
    this.add(whiteBkgBlueCharLabel1, null);
    this.add(blueBkgWhiteCharLabel2, null);
    this.add(cbxCompany, null);
 //   this.add(blueBkgWhiteCharLabel3, null);
    this.add(blueBkgWhiteCharLabel7,null);
    this.add(txpPayDate, null);
     this.add(txpPayDateTo, null);
      this.add(ll, null);
    this.add(btnPrint, null);
    genDataBindObj();
    super.reportName="BANK_USD_BALANCE.rpt";
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
    /*
    DbJcbxcbxBank =
        new exgui.DataBindJCombobox(cbxBank, "P_BANK",
                                    vctBanks, "BANK_NAME", "BANK_CODE", "ALL",
                                    "ALL", "ALL");
   dataBindComps.add(DbJcbxcbxBank);
*/


   java.util.GregorianCalendar gc=new java.util.GregorianCalendar();

   gc.set(gc.MONTH ,gc.JANUARY);
   gc.set(gc.DATE,1);

   java.sql.Date fromDate=java.sql.Date.valueOf("2007-01-01");

   dbTxtPayDate = new exgui.DataBindTextWithChecker(txpPayDate,
       "P_PAY_FROM",
//       new java.sql.Date(gc.getTimeInMillis()), 9,
       fromDate, 9,
       (exgui.Object2String)vftxtChkDD,
       (exgui.ultratable.CellTxtEditorFormat)vftxtChkDD);
   dataBindComps.add(dbTxtPayDate);
   gc.set(gc.MONTH ,gc.DECEMBER);
   gc.set(gc.DATE,31);
   dbTxtPayDateTo = new exgui.DataBindTextWithChecker(txpPayDateTo,
       "P_PAY_TO",
       new java.sql.Date(gc.getTimeInMillis()), 9,
       (exgui.Object2String)vftxtChkDD,
       (exgui.ultratable.CellTxtEditorFormat)vftxtChkDD);
   dataBindComps.add(dbTxtPayDateTo);



  }
  void btnPrint_actionPerformed(ActionEvent e) {
    newtimes.production.report.ReportCmdSet.myReportEngin.reportServerURL=
   "http://rpt2.nttpe.com.tw:9000/?file:///cc53//rpt//";
   super.JButtonQueryButtonAction(e);
   newtimes.production.report.ReportCmdSet.myReportEngin.reportServerURL=
   "http://rpt.nttpe.com.tw:9000/?file:///d://rpt//";
  }
}
