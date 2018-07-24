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

public class PnlAdd2Stock extends JPanel {
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel1 = new BlueBkgWhiteCharLabel();
  JComboBox cbxCompany = new JComboBox();
  WhiteBkgBlueCharLabel whiteBkgBlueCharLabel1 = new WhiteBkgBlueCharLabel();
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel2 = new BlueBkgWhiteCharLabel();
  JTextField txtVhDateFrom = new JTextField();
  JButton btnAdd2Stock = new JButton();
  JButton btnExit = new JButton();
  exgui.DataBindJCombobox    dbCbxCompany=null;
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel3 = new BlueBkgWhiteCharLabel();
  JTextField txtVhDateTo = new JTextField();
  public PnlAdd2Stock() {
    try {
      jbInit();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }

  void jbInit() throws Exception {
    blueBkgWhiteCharLabel1.setText("ADD To Stock");
    blueBkgWhiteCharLabel1.setBounds(new Rectangle(-4, 18, 807, 36));
    this.setLayout(null);
    cbxCompany.setBounds(new Rectangle(311, 114, 211, 24));
    whiteBkgBlueCharLabel1.setText("COMPANY");
    whiteBkgBlueCharLabel1.setBounds(new Rectangle(146, 114, 166, 24));
    blueBkgWhiteCharLabel2.setFont(new java.awt.Font("Dialog", 0, 16));
    blueBkgWhiteCharLabel2.setText("�ǲ�����_�� YYYYMMDD");
    blueBkgWhiteCharLabel2.setBounds(new Rectangle(145, 148, 208, 24));
    txtVhDateFrom.setText("");
    txtVhDateFrom.setBounds(new Rectangle(355, 148, 70, 24));
    btnAdd2Stock.setBounds(new Rectangle(368, 194, 154, 25));
    btnAdd2Stock.setFont(new java.awt.Font("Dialog", 1, 14));
    btnAdd2Stock.setText("ADD TO  9999/99");
    btnAdd2Stock.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnAdd2Stock_actionPerformed(e);
      }
    });
    btnExit.setBounds(new Rectangle(343, 532, 115, 25));
    btnExit.setFont(new java.awt.Font("Dialog", 1, 11));
    btnExit.setText("EXIT");
    btnExit.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnExit_actionPerformed(e);
      }
    });
    this.setBackground(new Color(202, 202, 224));
    blueBkgWhiteCharLabel3.setBounds(new Rectangle(425, 148, 26, 24));
    blueBkgWhiteCharLabel3.setFont(new java.awt.Font("Dialog", 1, 16));
    blueBkgWhiteCharLabel3.setText("~");
    txtVhDateTo.setBounds(new Rectangle(450, 148, 72, 24));
    this.add(blueBkgWhiteCharLabel1, null);
    this.add(cbxCompany, null);
    this.add(whiteBkgBlueCharLabel1, null);
    this.add(blueBkgWhiteCharLabel2, null);
    this.add(btnAdd2Stock, null);
    this.add(btnExit, null);
    this.add(txtVhDateTo, null);
    this.add(blueBkgWhiteCharLabel3, null);
    this.add(txtVhDateFrom, null);
      dbCbxCompany =
        new exgui.DataBindJCombobox(cbxCompany, "",
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

  void btnAdd2Stock_actionPerformed(ActionEvent e) {
    if(txtVhDateFrom.getText().trim().length()==0){
      exgui.verification.VerifyLib.showAlert("Please Input FROM YYYYMMDD","Please Input FROM YYYYMMDD");
      return;
    }
    if(txtVhDateFrom.getText().trim().length()!=8){
      exgui.verification.VerifyLib.showAlert("YYYYMM Format Error","YYYYMM Formate Error");
      return;
    }
    if(txtVhDateTo.getText().trim().length()==0){
      exgui.verification.VerifyLib.showAlert("Please Input TO YYYYMMDD","Please Input TO YYYYMMDD");
      return;
    }
    if(txtVhDateTo.getText().trim().length()!=8){
      exgui.verification.VerifyLib.showAlert("YYYYMM Format Error","YYYYMM Formate Error");
      return;
    }
    java.text.DateFormat df=new java.text.SimpleDateFormat("yyyyMMdd");
    df.setLenient(false);
    try{
      df.parse(txtVhDateFrom.getText());
    }catch(Exception exp){
       exgui.verification.VerifyLib.showAlert("FROM YYYYMMDD Format Error","FROM YYYYMM Format Error");
       return;
    }
    try{
      df.parse(txtVhDateTo.getText());
    }catch(Exception exp){
       exgui.verification.VerifyLib.showAlert("TO YYYYMMDD Format Error","TO YYYYMM Format Error");
       return;
    }

    //all ready,call server to import vh data into run data.
    try{
      util.MiscFunc.showProcessingMessage();
      newtimesejb.dailyVoucher.StockFacadeHome stockEjbHome=
          (newtimesejb.dailyVoucher.StockFacadeHome)
          info_ejb.WeblogicServiceLocator.locateServiceHome(util.PublicVariable.SERVER_URL,
          "newtimesejb.dailyVoucher.StockFacade");
      newtimesejb.dailyVoucher.StockFacade ejb=stockEjbHome.create();
      int stockRowCount=ejb.add2Stock(dbCbxCompany.getSelectedValue().toString(),txtVhDateFrom.getText().trim()+"~"+txtVhDateTo.getText().trim(),
                                    util.PublicVariable.USER_RECORD.get(0).toString());
      exgui.verification.VerifyLib.showPlanMsg("Add TO Stock OK!!\nRECORD COUNT:"+stockRowCount,"Add To Stock OK");

    }catch(Exception exp){
      exp.printStackTrace();
      util.ExceptionLog.exp2File(exp,"");
      exgui.verification.VerifyLib.showAlert("Error While Move Voucher into Stock File\nPlease Contact System Manager",
                                             "Error While Move Voucher into Stock File");
    }finally{
      util.MiscFunc.hideProcessingMessage();
    }
  }
}
