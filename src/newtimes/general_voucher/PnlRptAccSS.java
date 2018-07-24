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

public class PnlRptAccSS
    extends AbsQryPanel{
    //extends JPanel {
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel1 = new BlueBkgWhiteCharLabel();
  WhiteBkgBlueCharLabel whiteBkgBlueCharLabel1 = new WhiteBkgBlueCharLabel();
  JComboBox cbxCompany = new JComboBox();
  WhiteBkgBlueCharLabel whiteBkgBlueCharLabel2 = new WhiteBkgBlueCharLabel();
  JTextField txtFrom = new JTextField();
  WhiteBkgBlueCharLabel whiteBkgBlueCharLabel3 = new WhiteBkgBlueCharLabel();
  JTextField txtTo = new JTextField();
  JButton btnRpt = new JButton();
  exgui.DataBindJCombobox dbCbxCompany;
  exgui.DataBindTextWithChecker dbTxtPayDateFrom, dbTxtPayDateTo;
  java.text.DateFormat df=new java.text.SimpleDateFormat("yyyyMMdd");
  JPanel jPanel1 = new JPanel();

  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel2 = new BlueBkgWhiteCharLabel();
  JTextField txtUpdateYYYYMM = new JTextField();
  JButton btnUpdate = new JButton();
  JFrame frame;
  public PnlRptAccSS(JFrame frame) {
    try {
      this.frame=frame;
      //jbInit();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }

  void jbInit() throws Exception {
    blueBkgWhiteCharLabel1.setFont(new java.awt.Font("Dialog", 1, 16));
    blueBkgWhiteCharLabel1.setText("損益表");
    blueBkgWhiteCharLabel1.setBounds(new Rectangle(-1, 7, 803, 31));
    this.setBackground(new Color(202, 202, 224));
    this.setLayout(null);
    whiteBkgBlueCharLabel1.setForeground(new Color(113, 113, 178));
    whiteBkgBlueCharLabel1.setText("Company");
    whiteBkgBlueCharLabel1.setBounds(new Rectangle(17, 46, 78, 23));
    cbxCompany.setBounds(new Rectangle(95, 46, 172, 23));
    whiteBkgBlueCharLabel2.setBounds(new Rectangle(291, 46, 129, 23));
    whiteBkgBlueCharLabel2.setForeground(new Color(113, 113, 178));
    whiteBkgBlueCharLabel2.setText("From(YYYY/MM/DD):");
    txtFrom.setText("");
    txtFrom.setBounds(new Rectangle(422, 46, 70, 23));
    whiteBkgBlueCharLabel3.setText("To");
    whiteBkgBlueCharLabel3.setForeground(new Color(113, 113, 178));
    whiteBkgBlueCharLabel3.setBounds(new Rectangle(492, 46, 40, 23));
    txtTo.setText("");
    txtTo.setBounds(new Rectangle(533, 46, 70, 23));
    btnRpt.setBounds(new Rectangle(685, 46, 97, 27));
    btnRpt.setFont(new java.awt.Font("Dialog", 1, 12));
    btnRpt.setText("REPORT");
    btnRpt.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnRpt_actionPerformed(e);
      }
    });
    jPanel1.setBackground(Color.lightGray);
    jPanel1.setBorder(BorderFactory.createLoweredBevelBorder());
    jPanel1.setBounds(new Rectangle(289, 74, 341, 39));
    jPanel1.setLayout(null);
    blueBkgWhiteCharLabel2.setFont(new java.awt.Font("Dialog", 0, 16));
    blueBkgWhiteCharLabel2.setRequestFocusEnabled(false);
    blueBkgWhiteCharLabel2.setText("資料年月(YYYYMM)");
    blueBkgWhiteCharLabel2.setBounds(new Rectangle(6, 6, 156, 26));
    txtUpdateYYYYMM.setText("200912");
    txtUpdateYYYYMM.setBounds(new Rectangle(162, 6, 52, 26));
    btnUpdate.setBounds(new Rectangle(227, 6, 103, 26));
    btnUpdate.setFont(new java.awt.Font("Dialog", 1, 11));
    btnUpdate.setForeground(Color.red);
    btnUpdate.setText("UPDATE");
    btnUpdate.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        int res = exgui2.InfoMessage.Yes_No_Option(frame,"Are You Sure ?");
        if ( res == 0 )
        {
          btnUpdate_actionPerformed(e);
        }
      }
    });
    this.add(blueBkgWhiteCharLabel1, null);
    this.add(whiteBkgBlueCharLabel1, null);
    this.add(cbxCompany, null);
    this.add(whiteBkgBlueCharLabel2, null);
    this.add(txtFrom, null);
    this.add(whiteBkgBlueCharLabel3, null);
    this.add(txtTo, null);
    this.add(btnRpt, null);
    this.add(jPanel1, null);
    jPanel1.add(blueBkgWhiteCharLabel2, null);
    jPanel1.add(txtUpdateYYYYMM, null);
    jPanel1.add(btnUpdate, null);
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

      dbCbxCompany =
          new exgui.DataBindJCombobox(cbxCompany, "P_COMP",
                                      vct,
                                      "comp_code_and_name", "cmp_code", null);
      dataBindComps.add(dbCbxCompany);
      Object vftxtChkDD = exgui.verification.CellFormat.getDateStringFormater();
      /*
            java.util.Calendar gc=java.util.GregorianCalendar.getInstance();
            gc.set(gc.MONTH,gc.get(gc.MONTH)-1);
            gc.set(gc.DATE,1);
            java.util.Date dateFrom=new java.util.Date(gc.getTimeInMillis());
       */
      dbTxtPayDateFrom = new exgui.
          DataBindTextWithChecker(txtFrom,
                                  "P_DATE_FM",
                                  null, 10,
                                  (exgui.Object2String)vftxtChkDD,
                                  (exgui.ultratable.CellTxtEditorFormat)
                                  vftxtChkDD);
      dataBindComps.add(dbTxtPayDateFrom);

      dbTxtPayDateTo = new exgui.
          DataBindTextWithChecker(txtTo,
                                  "P_DATE_TO",
                                  null, 10,
                                  (exgui.Object2String)vftxtChkDD,
                                  (exgui.ultratable.CellTxtEditorFormat)
                                  vftxtChkDD);
      dataBindComps.add(dbTxtPayDateTo);

      Object objyyyymmVfy=exgui.verification.CellFormat.getIntVerifierAllowNull(6);
      exgui.DataBindTextWithChecker dbTxtYYYYMM= new exgui.DataBindTextWithChecker(txtUpdateYYYYMM,
                               "P_YYYYMM",
                               "999999", 6,
                               (exgui.Object2String)objyyyymmVfy,
                               (exgui.ultratable.CellTxtEditorFormat)objyyyymmVfy);

      reportName = "ACC_SS.rpt";
    }catch(Exception exp){
      exp.printStackTrace();
      util.ExceptionLog.exp2File(exp,"");
    }
   }
  public HashMap composeParameters(){
    HashMap hm=super.composeParameters();
    //get BM_Date
    try{
      java.util.Date dateEnd = (java.util.Date)dbTxtPayDateTo.getSelectedValue();
      java.util.Date dateBM = (java.util.Date)util.MiscFunc.deepCopy(dateEnd);
      java.util.Calendar cld=java.util.GregorianCalendar.getInstance();
      cld.setTime(dateBM);
      cld.set(cld.DAY_OF_MONTH,1);
      hm.put("P_DATE_BM",super.convertDate2QueryPara(new java.sql.Date(cld.getTimeInMillis())));
    }catch(Exception exp){
      exp.printStackTrace();
    }

    return hm;
  }
  void btnRpt_actionPerformed(ActionEvent e) {
     if(dbTxtPayDateFrom.getSelectedValue()==null){
       exgui.verification.VerifyLib.showAlert("Please Input Begin Date","Please Input Begin Date");
       return;
     }
     if(dbTxtPayDateTo.getSelectedValue()==null){
       exgui.verification.VerifyLib.showAlert("Please Input End Date","Please Input End Date");
       return;
     }
     newtimes.production.report.ReportCmdSet.myReportEngin.reportServerURL=
  "http://rpt2.nttpe.com.tw:9000/?file:///cc53//rpt//";
  super.JButtonQueryButtonAction(null);
   newtimes.production.report.ReportCmdSet.myReportEngin.reportServerURL=
     "http://rpt.nttpe.com.tw:9000/?file:///d://rpt//";


  }

  void btnUpdate_actionPerformed(ActionEvent e) {
   //txtUpdateYYYYMM
   if(dbTxtPayDateFrom.getSelectedValue()==null){
     exgui.verification.VerifyLib.showAlert("Please Input Begin Date","Please Input Begin Date");
     return;
   }
   if(dbTxtPayDateTo.getSelectedValue()==null){
     exgui.verification.VerifyLib.showAlert("Please Input End Date","Please Input End Date");
     return;
   }
  if(txtUpdateYYYYMM.getText().trim().length()!=6){
    exgui.verification.VerifyLib.showAlert("請輸入資料年月","請輸入資料年月");
    return;
  }
  boolean isUpdatting=false;
  try{
       isUpdatting=true;
        util.MiscFunc.showProcessingMessage();
       newtimesejb.GnVoucher.GnVoucherFacadeHome gvEjbHome=
        (newtimesejb.GnVoucher.GnVoucherFacadeHome)
        info_ejb.WeblogicServiceLocator.locateServiceHome(util.PublicVariable.SERVER_URL,
        "newtimesejb.GnVoucher.GnVoucherFacade");
        newtimesejb.GnVoucher.GnVoucherFacade ejb=gvEjbHome.create();

        java.util.Date dateEnd = (java.util.Date)dbTxtPayDateTo.getSelectedValue();
        java.util.Date dateBM = (java.util.Date)util.MiscFunc.deepCopy(dateEnd);
        java.util.Calendar cld=java.util.GregorianCalendar.getInstance();
        cld.setTime(dateBM);
        cld.set(cld.DAY_OF_MONTH,1);
        //hm.put("P_DATE_BM",super.convertDate2QueryPara(new java.sql.Date(cld.getTimeInMillis())));



         ejb.update4AccSsRpt(dbCbxCompany.getSelectedValue().toString(),
                                cld.getTime(),
                                (java.util.Date)dbTxtPayDateTo.getSelectedValue(),
                              txtUpdateYYYYMM.getText(),
                              util.PublicVariable.USER_RECORD.get(0).toString());
           exgui.verification.VerifyLib.showPlanMsg("Update Ok","Create Ok");

   }catch(Exception exp){
     exp.printStackTrace();
     util.ExceptionLog.exp2File(exp,"");
     exgui.verification.VerifyLib.showAlert("Error While Update\nPlease Contact System Manager",
                                            "Error While Update");
   }finally{
     isUpdatting=false;
     util.MiscFunc.hideProcessingMessage();
   }

  }
}
