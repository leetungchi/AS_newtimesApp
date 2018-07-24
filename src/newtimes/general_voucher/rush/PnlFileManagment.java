package newtimes.general_voucher.rush;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import exgui.*;
import javax.swing.border.*;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class PnlFileManagment extends JPanel {
  JButton btnExit = new JButton();
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel1 = new BlueBkgWhiteCharLabel();
  WhiteBkgBlueCharLabel whiteBkgBlueCharLabel1 = new WhiteBkgBlueCharLabel();
  JComboBox cbxFileType =null;
  WhiteBkgBlueCharLabel whiteBkgBlueCharLabel2 = new WhiteBkgBlueCharLabel();
  JTextField txtFromYYYYMM = new JTextField();
  WhiteBkgBlueCharLabel whiteBkgBlueCharLabel3 = new WhiteBkgBlueCharLabel();
  JTextField txtToYYYYMM = new JTextField();
  JButton btnAxnCopy = new JButton();
  JButton btnAxnDelete = new JButton();
  JButton btnAxnRename = new JButton();
  JComboBox cbxCompany = new JComboBox();
  exgui.DataBindJCombobox dbCbxCompany,dbCbxCompanyYearMonth;
  WhiteBkgBlueCharLabel whiteBkgBlueCharLabel4 = new WhiteBkgBlueCharLabel();
  JPanel jPanel1 = new JPanel();
  TitledBorder titledBorder1;
  WhiteBkgBlueCharLabel whiteBkgBlueCharLabel5 = new WhiteBkgBlueCharLabel();
  WhiteBkgBlueCharLabel whiteBkgBlueCharLabel6 = new WhiteBkgBlueCharLabel();
  JTextField txtYYYYMMYearMonth = new JTextField();
  JComboBox cbxCompany4MonthYear = new JComboBox();
  JButton btnYear = new JButton();
  JButton btnMonth = new JButton();

  public PnlFileManagment() {
    try {
      jbInit();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }

  void jbInit() throws Exception {
    exgui.ultratable.Wraper4tblCbx mdl[]=new exgui.ultratable.Wraper4tblCbx[3];
    mdl[0]=new exgui.ultratable.Wraper4tblCbx("GV_ACC_DATA","科目主檔");
    mdl[1]=new exgui.ultratable.Wraper4tblCbx("VH_DETAIL_RUSH","沖帳檔");
    mdl[2]=new exgui.ultratable.Wraper4tblCbx("VH_DETAIL_STOCK","進銷存");
    cbxFileType=new JComboBox(mdl);
    titledBorder1 = new TitledBorder(BorderFactory.createEtchedBorder(Color.white,new Color(141, 141, 156)),"年結與月結");
    cbxCompany4MonthYear = new JComboBox(mdl);
    titledBorder1.setTitleFont(new java.awt.Font("Dialog", 0, 16));
    btnExit.setBackground(UIManager.getColor("control"));
    btnExit.setBounds(new Rectangle(350, 534, 106, 31));
    btnExit.setFont(new java.awt.Font("Dialog", 1, 12));
    btnExit.setText("EXIT");
    btnExit.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnExit_actionPerformed(e);
      }
    });
    this.setLayout(null);
    this.setBackground(new Color(202, 202, 224));
    blueBkgWhiteCharLabel1.setFont(new java.awt.Font("Dialog", 0, 16));
    blueBkgWhiteCharLabel1.setText("檔案截轉");
    blueBkgWhiteCharLabel1.setBounds(new Rectangle(0, 13, 801, 31));
    whiteBkgBlueCharLabel1.setFont(new java.awt.Font("Dialog", 0, 16));
    whiteBkgBlueCharLabel1.setForeground(Color.blue);
    whiteBkgBlueCharLabel1.setText("檔案");
    whiteBkgBlueCharLabel1.setBounds(new Rectangle(26, 94, 87, 23));
    cbxFileType.setBounds(new Rectangle(114, 94, 189, 23));
    whiteBkgBlueCharLabel2.setForeground(Color.blue);
    whiteBkgBlueCharLabel2.setText("FROM (YYYYMM)");
    whiteBkgBlueCharLabel2.setBounds(new Rectangle(337, 94, 128, 23));
    txtFromYYYYMM.setBounds(new Rectangle(465, 94, 63, 23));
    whiteBkgBlueCharLabel3.setBounds(new Rectangle(541, 94, 128, 23));
    whiteBkgBlueCharLabel3.setForeground(Color.blue);
    whiteBkgBlueCharLabel3.setText("TO (YYYYMM)");
    txtToYYYYMM.setBounds(new Rectangle(669, 94, 63, 23));
    txtToYYYYMM.setText("");
    btnAxnCopy.setBounds(new Rectangle(53, 153, 126, 26));
    btnAxnCopy.setFont(new java.awt.Font("Dialog", 1, 12));
    btnAxnCopy.setText("COPY");
    btnAxnCopy.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnAxnCopy_actionPerformed(e);
      }
    });
    btnAxnDelete.setText("DELETE");
    btnAxnDelete.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnAxnDelete_actionPerformed(e);
      }
    });
    btnAxnDelete.setBounds(new Rectangle(323, 153, 126, 26));
    btnAxnDelete.setFont(new java.awt.Font("Dialog", 1, 12));
    btnAxnDelete.setForeground(Color.red);
    btnAxnDelete.setHorizontalAlignment(SwingConstants.CENTER);
    btnAxnRename.setText("RENAME");
    btnAxnRename.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnAxnRename_actionPerformed(e);
      }
    });
    btnAxnRename.setBounds(new Rectangle(593, 153, 126, 26));
    btnAxnRename.setFont(new java.awt.Font("Dialog", 1, 12));
    cbxCompany.setBounds(new Rectangle(114, 61, 189, 23));
    whiteBkgBlueCharLabel4.setBounds(new Rectangle(26, 61, 87, 23));
    whiteBkgBlueCharLabel4.setText("公司");
    whiteBkgBlueCharLabel4.setForeground(Color.blue);
    whiteBkgBlueCharLabel4.setFont(new java.awt.Font("Dialog", 0, 16));
    jPanel1.setBackground(new Color(202, 202, 224));
    jPanel1.setFont(new java.awt.Font("Dialog", 0, 11));
    jPanel1.setBorder(titledBorder1);
    jPanel1.setBounds(new Rectangle(18, 221, 752, 108));
    jPanel1.setLayout(null);
    whiteBkgBlueCharLabel5.setFont(new java.awt.Font("Dialog", 0, 16));
    whiteBkgBlueCharLabel5.setForeground(Color.blue);
    whiteBkgBlueCharLabel5.setText("公司");
    whiteBkgBlueCharLabel5.setBounds(new Rectangle(29, 35, 87, 23));
    whiteBkgBlueCharLabel6.setBounds(new Rectangle(340, 35, 128, 23));
    whiteBkgBlueCharLabel6.setText("YYYYMM");
    whiteBkgBlueCharLabel6.setForeground(Color.blue);
    txtYYYYMMYearMonth.setText("999999");
    txtYYYYMMYearMonth.setBounds(new Rectangle(468, 35, 63, 23));
    cbxCompany4MonthYear.setBounds(new Rectangle(117, 35, 189, 23));
    btnYear.setBounds(new Rectangle(574, 69, 153, 28));
    btnYear.setFont(new java.awt.Font("Dialog", 0, 16));
    btnYear.setText("年結");
    btnYear.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnYear_actionPerformed(e);
      }
    });
    btnMonth.setText("月結");
    btnMonth.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnMonth_actionPerformed(e);
      }
    });
    btnMonth.setBounds(new Rectangle(37, 69, 153, 28));
    btnMonth.setFont(new java.awt.Font("Dialog", 0, 16));
    this.add(btnExit, null);
    this.add(blueBkgWhiteCharLabel1, null);
    this.add(btnAxnCopy, null);
    this.add(btnAxnDelete, null);
    this.add(btnAxnRename, null);
    this.add(whiteBkgBlueCharLabel1, null);
    this.add(cbxFileType, null);
    this.add(whiteBkgBlueCharLabel2, null);
    this.add(txtFromYYYYMM, null);
    this.add(whiteBkgBlueCharLabel3, null);
    this.add(txtToYYYYMM, null);
    this.add(cbxCompany, null);
    this.add(whiteBkgBlueCharLabel4, null);
    this.add(jPanel1, null);
    jPanel1.add(whiteBkgBlueCharLabel5, null);
    jPanel1.add(whiteBkgBlueCharLabel6, null);
    jPanel1.add(txtYYYYMMYearMonth, null);
    jPanel1.add(cbxCompany4MonthYear, null);
    jPanel1.add(btnMonth, null);
    jPanel1.add(btnYear, null);
    Object objyyyymmVfy=exgui.verification.CellFormat.getIntVerifierAllowNull(6);
    exgui.DataBindTextWithChecker dbTxtYYYYMM= new exgui.DataBindTextWithChecker(txtFromYYYYMM,
                             "P_YYYYMM",
                             "999999", 6,
                             (exgui.Object2String)objyyyymmVfy,
                             (exgui.ultratable.CellTxtEditorFormat)objyyyymmVfy);

       exgui.DataBindTextWithChecker dbTxtYYYYMMTo= new exgui.DataBindTextWithChecker(txtToYYYYMM,
                                "P_YYYYMM",
                                "", 6,
                                (exgui.Object2String)objyyyymmVfy,
                                (exgui.ultratable.CellTxtEditorFormat)objyyyymmVfy);
      txtFromYYYYMM.setText("999999");
      exgui.DataBindTextWithChecker dbTxtYYYYMM_YearMonth= new exgui.DataBindTextWithChecker(txtYYYYMMYearMonth,
                               "YYYYMM",
                               "", 6,
                               (exgui.Object2String)objyyyymmVfy,
                               (exgui.ultratable.CellTxtEditorFormat)objyyyymmVfy);
                           txtYYYYMMYearMonth.setText("999999");

      dbCbxCompany =
        new exgui.DataBindJCombobox(cbxCompany, "",
                                    newtimes.general_voucher.daily_voucher.
                                    Constants.VCT_GV_ACC_COMPANY,
                                    "comp_code_and_name", "cmp_code",null);

    dbCbxCompanyYearMonth =
      new exgui.DataBindJCombobox(cbxCompany4MonthYear, "",
                                  newtimes.general_voucher.daily_voucher.
                                  Constants.VCT_GV_ACC_COMPANY,
                                  "comp_code_and_name", "cmp_code",null);

  }

  void btnExit_actionPerformed(ActionEvent e) {
    try{
      processhandler.template.Properties.getCenteralControler().goBack();
    }catch(Exception exp){
      exp.printStackTrace();
    }

  }
  void doAction(String axnCode){
    try{
      util.MiscFunc.showProcessingMessage();
      newtimesejb.dailyVoucher.RushFacadeHome rushEjbHome =
          (newtimesejb.dailyVoucher.RushFacadeHome)
          info_ejb.WeblogicServiceLocator.locateServiceHome(util.PublicVariable.
          SERVER_URL,
          "newtimesejb.dailyVoucher.RushFacade");
      newtimesejb.dailyVoucher.RushFacade ejb = rushEjbHome.create();
      String tableName=(String)((exgui.ultratable.Wraper4tblCbx)cbxFileType.getSelectedItem()).getValue();
      ejb.fileManagement(tableName,txtFromYYYYMM.getText().trim(),
                         txtToYYYYMM.getText().trim(),util.PublicVariable.USER_RECORD.get(0).toString()
                         ,axnCode,(String)dbCbxCompany.getSelectedValue());

      exgui.verification.VerifyLib.showPlanMsg("OK\nProcess Finished!!","OK");
    }catch(Exception exp){
      exp.printStackTrace();
      util.ExceptionLog.exp2File(exp,"");
      exgui.verification.VerifyLib.showAlert("Error While processing File Management\nPlease Contact System Manager",
                                             "Error!!");

    }
  }
  void btnAxnCopy_actionPerformed(ActionEvent e) {
    if(txtFromYYYYMM.getText().trim().length()<6){
      exgui.verification.VerifyLib.showAlert("\"FROM YYYYMM\" format Error","\"FROM YYYYMM\" format Error");
      return;
    }
    if(txtToYYYYMM.getText().trim().length()<6){
      exgui.verification.VerifyLib.showAlert("\"TO YYYYMM\" format Error","\"TO YYYYMM\" format Error");
      return;
    }
    doAction("COPY");
  }

  void btnAxnDelete_actionPerformed(ActionEvent e) {
    if(txtFromYYYYMM.getText().trim().length()<6){
      exgui.verification.VerifyLib.showAlert("\"FROM YYYYMM\" format Error","\"FROM YYYYMM\" format Error");
      return;
    }
    if(!exgui.verification.VerifyLib.showConfirm("Do You Sure To Delete?","Do You Sure To Delete?",false))return;
    doAction("DELETE");
  }

  void btnAxnRename_actionPerformed(ActionEvent e) {
    if(txtFromYYYYMM.getText().trim().length()<6){
      exgui.verification.VerifyLib.showAlert("\"FROM YYYYMM\" format Error","\"FROM YYYYMM\" format Error");
      return;
    }
    if(txtToYYYYMM.getText().trim().length()<6){
      exgui.verification.VerifyLib.showAlert("\"TO YYYYMM\" format Error","\"TO YYYYMM\" format Error");
      return;
    }
   doAction("RENAME");
  }

  void btnMonth_actionPerformed(ActionEvent e) {
    try{
      if(txtYYYYMMYearMonth.getText().trim().length()<6){
        exgui.verification.VerifyLib.showAlert("\"FROM YYYYMM\" format Error","\"FROM YYYYMM\" format Error");
        return;
      }

      util.MiscFunc.showProcessingMessage();
      newtimesejb.dailyVoucher.RushFacadeHome rushEjbHome =
          (newtimesejb.dailyVoucher.RushFacadeHome)
          info_ejb.WeblogicServiceLocator.locateServiceHome(util.PublicVariable.
          SERVER_URL,
          "newtimesejb.dailyVoucher.RushFacade");
      newtimesejb.dailyVoucher.RushFacade ejb = rushEjbHome.create();
      //String tableName=(String)((exgui.ultratable.Wraper4tblCbx)cbxFileType.getSelectedItem()).getValue();
       ///public void fileManagementYear(String companyCode,String yyyymm,String userId)
      ejb.fileManagementMonth((String)dbCbxCompanyYearMonth.getSelectedValue(),txtYYYYMMYearMonth.getText().trim(),
                              util.PublicVariable.USER_RECORD.get(0).toString() );

      exgui.verification.VerifyLib.showPlanMsg("OK\nProcess Finished!!","OK");
    }catch(Exception exp){
      exp.printStackTrace();
      util.ExceptionLog.exp2File(exp,"");
      exgui.verification.VerifyLib.showAlert("Error While processing File Management\nPlease Contact System Manager",
                                             "Error!!");

    }

  }

  void btnYear_actionPerformed(ActionEvent e) {
    try{
      if(txtYYYYMMYearMonth.getText().trim().length()<6){
        exgui.verification.VerifyLib.showAlert("\"FROM YYYYMM\" format Error","\"FROM YYYYMM\" format Error");
        return;
      }

      util.MiscFunc.showProcessingMessage();
      newtimesejb.dailyVoucher.RushFacadeHome rushEjbHome =
          (newtimesejb.dailyVoucher.RushFacadeHome)
          info_ejb.WeblogicServiceLocator.locateServiceHome(util.PublicVariable.
          SERVER_URL,
          "newtimesejb.dailyVoucher.RushFacade");
      newtimesejb.dailyVoucher.RushFacade ejb = rushEjbHome.create();
      String tableName=(String)((exgui.ultratable.Wraper4tblCbx)cbxFileType.getSelectedItem()).getValue();
       ///public void fileManagementYear(String companyCode,String yyyymm,String userId)
      ejb.fileManagementYear((String)dbCbxCompanyYearMonth.getSelectedValue(),txtYYYYMMYearMonth.getText().trim(),
                              util.PublicVariable.USER_RECORD.get(0).toString() );

      exgui.verification.VerifyLib.showPlanMsg("OK\nProcess Finished!!","OK");
    }catch(Exception exp){
      exp.printStackTrace();
      util.ExceptionLog.exp2File(exp,"");
      exgui.verification.VerifyLib.showAlert("Error While processing File Management\nPlease Contact System Manager",
                                             "Error!!");

    }

  }
}
