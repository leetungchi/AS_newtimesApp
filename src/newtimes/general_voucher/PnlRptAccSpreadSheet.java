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

public class PnlRptAccSpreadSheet
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
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel2 = new BlueBkgWhiteCharLabel();
  JTextField txtItemFrm = new JTextField();
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel3 = new BlueBkgWhiteCharLabel();
  JTextField txtItemTo = new JTextField();
  public PnlRptAccSpreadSheet() {
    try {
      //jbInit();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }

  void jbInit() throws Exception {
    blueBkgWhiteCharLabel1.setFont(new java.awt.Font("Dialog", 1, 16));
    blueBkgWhiteCharLabel1.setText("試算表");
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
    btnRpt.setBounds(new Rectangle(698, 76, 89, 27));
    btnRpt.setFont(new java.awt.Font("Dialog", 1, 12));
    btnRpt.setText("REPORT");
    btnRpt.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnRpt_actionPerformed(e);
      }
    });
    blueBkgWhiteCharLabel2.setText("科目起迄");
    blueBkgWhiteCharLabel2.setBounds(new Rectangle(257, 76, 128, 23));
    txtItemFrm.setToolTipText("");
    txtItemFrm.setText("1101");
    txtItemFrm.setBounds(new Rectangle(384, 76, 70, 23));
    blueBkgWhiteCharLabel3.setBounds(new Rectangle(452, 76, 59, 23));
    blueBkgWhiteCharLabel3.setText("~");
    txtItemTo.setBounds(new Rectangle(510, 76, 70, 23));
    txtItemTo.setText("1102");
    txtItemTo.setToolTipText("");
    this.add(blueBkgWhiteCharLabel1, null);
    this.add(whiteBkgBlueCharLabel1, null);
    this.add(cbxCompany, null);
    this.add(whiteBkgBlueCharLabel3, null);
    this.add(txtDataYM, null);
    this.add(whiteBkgBlueCharLabel2, null);
    this.add(txtTitleYM, null);
    this.add(blueBkgWhiteCharLabel2, null);
    this.add(txtItemFrm, null);
    this.add(blueBkgWhiteCharLabel3, null);
    this.add(txtItemTo, null);
    this.add(btnRpt, null);
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
      Object vctItemRange=exgui.verification.CellFormat.getOrdinaryFieldNotAllowNull(10);

      /*
            java.util.Calendar gc=java.util.GregorianCalendar.getInstance();
            gc.set(gc.MONTH,gc.get(gc.MONTH)-1);
            gc.set(gc.DATE,1);
            java.util.Date dateFrom=new java.util.Date(gc.getTimeInMillis());
       */
      dbTxtPayDateFrom = new exgui.
          DataBindTextWithChecker(txtTitleYM,
                                  "P_TITLE_YM",
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

     DataBindTextWithChecker dbTxtItemRangeFm = new exgui.
          DataBindTextWithChecker(txtItemFrm,
                                  "P_ITEM_FM",
                                  "1101", 10,
                                  (exgui.Object2String)vctItemRange,
                                  (exgui.ultratable.CellTxtEditorFormat)
                                  vctItemRange);
      dataBindComps.add(dbTxtItemRangeFm);

      DataBindTextWithChecker dbTxtItemRangeTo = new exgui.
           DataBindTextWithChecker(txtItemTo,
                                   "P_ITEM_TO",
                                   "1102", 10,
                                   (exgui.Object2String)vctItemRange,
                                   (exgui.ultratable.CellTxtEditorFormat)
                                   vctItemRange);
       dataBindComps.add(dbTxtItemRangeTo);


      reportName = "ACC_SPREADSHEET.rpt";
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
