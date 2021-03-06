package newtimes.general_voucher;
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

public class PnlRptAccAsstLiab
    extends AbsQryPanel{
    //extends JPanel {
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel1 = new BlueBkgWhiteCharLabel();
  WhiteBkgBlueCharLabel whiteBkgBlueCharLabel1 = new WhiteBkgBlueCharLabel();
  JComboBox cbxCompany = new JComboBox();
  WhiteBkgBlueCharLabel whiteBkgBlueCharLabel2 = new WhiteBkgBlueCharLabel();
  JTextField txtTitleYM = new JTextField();
  WhiteBkgBlueCharLabel whiteBkgBlueCharLabel3 = new WhiteBkgBlueCharLabel();
  JTextField txtDataYM = new JTextField();
  JButton btnRpt = new JButton();
  exgui.DataBindTextWithChecker dbTxtPayDateFrom, dbTxtPayDateTo;
  java.text.DateFormat df=new java.text.SimpleDateFormat("yyyyMMdd");
  public PnlRptAccAsstLiab() {
    try {
      //jbInit();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }

  void jbInit() throws Exception {
    blueBkgWhiteCharLabel1.setFont(new java.awt.Font("Dialog", 1, 16));
    blueBkgWhiteCharLabel1.setText("資產負債類表");
    blueBkgWhiteCharLabel1.setBounds(new Rectangle(-1, 7, 803, 31));
    this.setBackground(new Color(202, 202, 224));
    this.setLayout(null);
    whiteBkgBlueCharLabel1.setForeground(new Color(113, 113, 178));
    whiteBkgBlueCharLabel1.setText("Company");
    whiteBkgBlueCharLabel1.setBounds(new Rectangle(8, 46, 78, 23));
    cbxCompany.setBounds(new Rectangle(86, 46, 172, 23));
    whiteBkgBlueCharLabel2.setBounds(new Rectangle(463, 46, 163, 23));
    whiteBkgBlueCharLabel2.setForeground(new Color(113, 113, 178));
    whiteBkgBlueCharLabel2.setText("表頭年月日(YYYYMMDD):");
    txtTitleYM.setText("");
    txtTitleYM.setBounds(new Rectangle(626, 46, 70, 23));
    whiteBkgBlueCharLabel3.setText("資料年月(YYYYMM)");
    whiteBkgBlueCharLabel3.setForeground(new Color(113, 113, 178));
    whiteBkgBlueCharLabel3.setBounds(new Rectangle(259, 46, 124, 23));
    txtDataYM.setText("");
    txtDataYM.setBounds(new Rectangle(384, 46, 70, 23));
    btnRpt.setBounds(new Rectangle(705, 46, 89, 27));
    btnRpt.setFont(new java.awt.Font("Dialog", 1, 12));
    btnRpt.setText("REPORT");
    btnRpt.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnRpt_actionPerformed(e);
      }
    });
    this.add(blueBkgWhiteCharLabel1, null);
    this.add(btnRpt, null);
    this.add(whiteBkgBlueCharLabel1, null);
    this.add(cbxCompany, null);
    this.add(whiteBkgBlueCharLabel3, null);
    this.add(txtDataYM, null);
    this.add(whiteBkgBlueCharLabel2, null);
    this.add(txtTitleYM, null);
    genDataBindObj();
  }
  public void genDataBindObj(){
    dataBindComps.clear();
    try{
      StringBuffer sb = new StringBuffer();
      sb.append("select substr(field_name,length(field_name),1) as cmp_code, ");
      sb.append("field_desc as cmp_name,");
      sb.append("substr(field_name,length(field_name),1)||'--'||field_desc  as comp_code_and_name ");
      sb.append(" from TPE_DATE_RANGE  ");
      sb.append("where record_delete_flag='1'  ");
      sb.append("and CEN_CODE='");
      sb.append(util.PublicVariable.OPERATTING_CENTER);
      sb.append("' ");
      sb.append("and FIELD_NAME LIKE 'GV_COMP_%' ");
      Vector vct = exgui2.CONST.BASIC_MAIN_EJB.getDatas(
          util.PublicVariable.USER_RECORD,
          sb.toString(), 1, 9999);

      exgui.DataBindJCombobox dbCbxCompany =
          new exgui.DataBindJCombobox(cbxCompany, "P_COMP",
                                      vct,
                                      "comp_code_and_name", "cmp_code", null);
      dataBindComps.add(dbCbxCompany);
      Object vftxtChkDD = exgui.verification.CellFormat.getIntVerifierAllowNull(6);
      Object vftxtChkYYYYMMDD = exgui.verification.CellFormat.getIntVerifierAllowNull(8);
      /*
            java.util.Calendar gc=java.util.GregorianCalendar.getInstance();
            gc.set(gc.MONTH,gc.get(gc.MONTH)-1);
            gc.set(gc.DATE,1);
            java.util.Date dateFrom=new java.util.Date(gc.getTimeInMillis());
       */
      dbTxtPayDateFrom = new exgui.
          DataBindTextWithChecker(txtTitleYM,
                                  "P_YYYYMMDD",
                                  null, 8,
                                  (exgui.Object2String)vftxtChkYYYYMMDD,
                                  (exgui.ultratable.CellTxtEditorFormat)
                                  vftxtChkYYYYMMDD);
      dataBindComps.add(dbTxtPayDateFrom);

      dbTxtPayDateTo = new exgui.
          DataBindTextWithChecker(txtDataYM,
                                  "P_YYYYMM",
                                  null, 6,
                                  (exgui.Object2String)vftxtChkDD,
                                  (exgui.ultratable.CellTxtEditorFormat)
                                  vftxtChkDD);
      dataBindComps.add(dbTxtPayDateTo);
      reportName = "ACC_ASST_LIAB.rpt";
      txtDataYM.setText("999999");
    }catch(Exception exp){
      exp.printStackTrace();
      util.ExceptionLog.exp2File(exp,"");
    }
   }

  void btnRpt_actionPerformed(ActionEvent e) {
     if(dbTxtPayDateFrom.getSelectedValue()==null){
       exgui.verification.VerifyLib.showAlert("Please Input TITLE Date","Please Input TITLE Date");
       return;
     }
     if(dbTxtPayDateTo.getSelectedValue()==null){
       exgui.verification.VerifyLib.showAlert("Please Input YYYYMM","Please Input YYYYMM");
       return;
     }
     String tmpUrl=newtimes.production.report.ReportCmdSet.myReportEngin.reportServerURL;
     newtimes.production.report.ReportCmdSet.myReportEngin.reportServerURL=
  "http://rpt2.nttpe.com.tw:9000/?file:///cc53//rpt//";
  super.JButtonQueryButtonAction(null);
   newtimes.production.report.ReportCmdSet.myReportEngin.reportServerURL=tmpUrl;
  }
}
