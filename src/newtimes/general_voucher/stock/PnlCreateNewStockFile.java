package newtimes.general_voucher.stock;

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

public class PnlCreateNewStockFile extends JPanel {
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel1 = new BlueBkgWhiteCharLabel();
  WhiteBkgBlueCharLabel whiteBkgBlueCharLabel1 = new WhiteBkgBlueCharLabel();
  JComboBox cbxCompany = new JComboBox();
  WhiteBkgBlueCharLabel whiteBkgBlueCharLabel2 = new WhiteBkgBlueCharLabel();
  JTextField txtYYYYMM = new JTextField();
  JButton btnGo = new JButton();
  JButton btnExit = new JButton();
  exgui.DataBindJCombobox dbCbxCompany;
  public PnlCreateNewStockFile() {
    try {
      jbInit();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }

  void jbInit() throws Exception {
    blueBkgWhiteCharLabel1.setText("Create New Stok File");
    blueBkgWhiteCharLabel1.setBounds(new Rectangle(-1, 23, 812, 32));
    this.setBackground(new Color(202, 202, 224));
    this.setLayout(null);
    whiteBkgBlueCharLabel1.setText("COMPANY");
    whiteBkgBlueCharLabel1.setBounds(new Rectangle(46, 88, 90, 24));
    cbxCompany.setBounds(new Rectangle(137, 88, 188, 24));
    whiteBkgBlueCharLabel2.setBounds(new Rectangle(393, 88, 90, 24));
    whiteBkgBlueCharLabel2.setText("YYYYMM");
    txtYYYYMM.setText("");
    txtYYYYMM.setBounds(new Rectangle(483, 88, 72, 24));
    btnGo.setBounds(new Rectangle(633, 88, 87, 26));
    btnGo.setFont(new java.awt.Font("Dialog", 1, 11));
    btnGo.setText("CREATE");
    btnGo.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnGo_actionPerformed(e);
      }
    });
    btnExit.setBounds(new Rectangle(369, 503, 90, 27));
    btnExit.setFont(new java.awt.Font("Dialog", 1, 11));
    btnExit.setText("EXIT");
    btnExit.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnExit_actionPerformed(e);
      }
    });
    this.add(blueBkgWhiteCharLabel1, null);
    this.add(whiteBkgBlueCharLabel1, null);
    this.add(cbxCompany, null);
    this.add(whiteBkgBlueCharLabel2, null);
    this.add(txtYYYYMM, null);
    this.add(btnGo, null);
    this.add(btnExit, null);
    dbCbxCompany =
      new exgui.DataBindJCombobox(cbxCompany, "",
                                  newtimes.general_voucher.daily_voucher.
                                  Constants.VCT_GV_ACC_COMPANY,
                                  "comp_code_and_name", "cmp_code",null);
    Object objyyyymmVfy=exgui.verification.CellFormat.getIntVerifierAllowNull(6);
     exgui.DataBindTextWithChecker dbTxtYYYYMM= new exgui.DataBindTextWithChecker(txtYYYYMM,
                           "P_YYYYMM",
                           "999999", 6,
                           (exgui.Object2String)objyyyymmVfy,
                           (exgui.ultratable.CellTxtEditorFormat)objyyyymmVfy);


  }

  void btnExit_actionPerformed(ActionEvent e) {
    try{
      processhandler.template.Properties.getCenteralControler().goBack();
    }catch(Exception exp){
      exp.printStackTrace();
    }

  }

  void btnGo_actionPerformed(ActionEvent e) {

    if(txtYYYYMM.getText().trim().length()!=6){
      exgui.verification.VerifyLib.showAlert("Please Check YYYYMM","Please Check YYYYMM");
      return;
    }
    try{
      util.MiscFunc.showProcessingMessage();
      newtimesejb.dailyVoucher.StockFacadeHome stockEjbHome=
          (newtimesejb.dailyVoucher.StockFacadeHome)
          info_ejb.WeblogicServiceLocator.locateServiceHome(util.PublicVariable.SERVER_URL,
          "newtimesejb.dailyVoucher.StockFacade");
      newtimesejb.dailyVoucher.StockFacade ejb=stockEjbHome.create();
      ejb.createNewStockFile(dbCbxCompany.getSelectedValue().toString(),txtYYYYMM.getText(),
                                    util.PublicVariable.USER_RECORD.get(0).toString());
      exgui.verification.VerifyLib.showPlanMsg("Create New Stock File OK","Create Ok");

    }catch(Exception exp){
      exp.printStackTrace();
      util.ExceptionLog.exp2File(exp,"");
      exgui.verification.VerifyLib.showAlert("Error While Create New Stock File\nPlease Contact System Manager",
                                             "Error While Create New Stock File");
    }finally{
      util.MiscFunc.hideProcessingMessage();
    }
  }
}
