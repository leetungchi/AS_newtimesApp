package newtimes.accounting.local_voucher;

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

public class PnlQryLvDDK extends JPanel {
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel1 = new BlueBkgWhiteCharLabel();
  WhiteBkgBlueCharLabel whiteBkgBlueCharLabel1 = new WhiteBkgBlueCharLabel();
  WhiteBkgBlueCharLabel whiteBkgBlueCharLabel2 = new WhiteBkgBlueCharLabel();
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel2 = new BlueBkgWhiteCharLabel();
  JTextField txtMakerName = new JTextField();
  WhiteBkgBlueCharLabel whiteBkgBlueCharLabel3 = new WhiteBkgBlueCharLabel();
  JTextField txtShipEtdFrom = new JTextField();
  WhiteBkgBlueCharLabel whiteBkgBlueCharLabel4 = new WhiteBkgBlueCharLabel();
  JTextField txtShipEtdEnd = new JTextField();
  JButton btnQry = new JButton();
  JButton btnExit = new JButton();
  exgui.DataBindTextWithChecker dbShipEtdFrom,dbShipEtdTo;
  public PnlQryLvDDK() {
    try {
      jbInit();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }

  void jbInit() throws Exception {
    blueBkgWhiteCharLabel1.setText("LOCAL VOUCHER DEDUCT MAINTENANCE");
    blueBkgWhiteCharLabel1.setBounds(new Rectangle(-2, 19, 803, 36));
    this.setLayout(null);
    whiteBkgBlueCharLabel1.setText("CENTER:");
    whiteBkgBlueCharLabel1.setBounds(new Rectangle(206, 121, 147, 30));
    whiteBkgBlueCharLabel2.setText("TAIPEI");
    whiteBkgBlueCharLabel2.setBounds(new Rectangle(351, 121, 262, 30));
    blueBkgWhiteCharLabel2.setFont(new java.awt.Font("Dialog", 0, 16));
    blueBkgWhiteCharLabel2.setText("廠商:");
    blueBkgWhiteCharLabel2.setBounds(new Rectangle(206, 162, 147, 30));
    this.setBackground(new Color(202, 202, 224));
    txtMakerName.setText("");
    txtMakerName.setBounds(new Rectangle(353, 162, 259, 30));
    whiteBkgBlueCharLabel3.setBounds(new Rectangle(206, 202, 147, 30));
    whiteBkgBlueCharLabel3.setText("ETD FROM :");
    txtShipEtdFrom.setText("");
    txtShipEtdFrom.setBounds(new Rectangle(354, 202, 81, 30));
    whiteBkgBlueCharLabel4.setText("TO");
    whiteBkgBlueCharLabel4.setBounds(new Rectangle(434, 202, 100, 30));
    txtShipEtdEnd.setBounds(new Rectangle(533, 202, 81, 30));
    txtShipEtdEnd.setText("");
    btnQry.setBounds(new Rectangle(224, 390, 102, 32));
    btnQry.setFont(new java.awt.Font("Dialog", 1, 11));
    btnQry.setText("QUERY");
    btnQry.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnQry_actionPerformed(e);
      }
    });
    btnExit.setText("EXIT");
    btnExit.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnExit_actionPerformed(e);
      }
    });
    btnExit.setBounds(new Rectangle(511, 390, 102, 32));
    btnExit.setFont(new java.awt.Font("Dialog", 1, 11));
    this.add(blueBkgWhiteCharLabel1, null);
    this.add(whiteBkgBlueCharLabel1, null);
    this.add(whiteBkgBlueCharLabel2, null);
    this.add(blueBkgWhiteCharLabel2, null);
    this.add(txtMakerName, null);
    this.add(whiteBkgBlueCharLabel3, null);
    this.add(txtShipEtdFrom, null);
    this.add(whiteBkgBlueCharLabel4, null);
    this.add(txtShipEtdEnd, null);
    this.add(btnQry, null);
    this.add(btnExit, null);
    Object objDate=exgui.verification.CellFormat.getDateStringFormaterAllowNull();

          java.util.Calendar ggc=java.util.GregorianCalendar.getInstance();
          ggc.set(2007,9,1);


          dbShipEtdFrom  =new exgui.DataBindTextWithChecker(txtShipEtdFrom, "",
                                              new java.sql.Date(ggc.getTimeInMillis()), 10,
                                              (exgui.Object2String)objDate,
                                              (exgui.ultratable.CellTxtEditorFormat)
                                              objDate);

          ggc.clear();
          ggc.setTimeInMillis(System.currentTimeMillis());
          int year=ggc.get(ggc.YEAR);
          year++;
          ggc.set(ggc.YEAR,year);
          ggc.set(ggc.MONTH,11);
          ggc.set(ggc.DAY_OF_MONTH,1);

          dbShipEtdTo=  new exgui.DataBindTextWithChecker(txtShipEtdEnd , "",
                                              new java.sql.Date(ggc.getTimeInMillis()), 10,
                                              (exgui.Object2String)objDate,
                                              (exgui.ultratable.CellTxtEditorFormat)
                                              objDate);



  }

  void btnExit_actionPerformed(ActionEvent e) {
    try{
      TgrQryLvDDK.pnl=null;
      processhandler.template.Properties.getCenteralControler().goBack();
    }catch(Exception exp){
      exp.printStackTrace();
    }

  }
   boolean checkDate(){
     if(txtMakerName.getText().trim().length()==0){
       exgui.verification.VerifyLib.showAlert("請輸入廠商名稱",
                                              "請輸入廠商名稱");
       return false;
     }
    if(txtShipEtdEnd.getText().trim().length()!=0 &&
       txtShipEtdFrom.getText().trim().length()!=0 ){
       if(((java.util.Date)dbShipEtdFrom.getSelectedValue()).after(
        (java.util.Date)dbShipEtdTo.getSelectedValue())){
          exgui.verification.VerifyLib.showAlert("\"FROM ETD DAET\" Should Before \"END ETD DATE\"",
                                                 "\"FROM ETD DAET\" Should Before \"END ETD DATE\"");
          return false;
        }
    }
    return true;
  }
  void btnQry_actionPerformed(ActionEvent e) {
    if(!checkDate())return;
    DbLocalVoucherDDK.HM_QRY_CONDITION.clear();

    if(txtMakerName.getText().trim().length()>0){
      DbLocalVoucherDDK.HM_QRY_CONDITION.put(DbLocalVoucherDDK.QUERY_KEY_FACTORY_ZH_NAME,
                                            txtMakerName.getText().trim());
    }
    if(txtShipEtdFrom.getText().trim().length()>0){
      DbLocalVoucherDDK.HM_QRY_CONDITION.put(DbLocalVoucherDDK.QUERY_KEY_ETD_FROM,
                                            txtShipEtdFrom.getText().trim());
    }
    if(txtShipEtdFrom.getText().trim().length()>0){
      DbLocalVoucherDDK.HM_QRY_CONDITION.put(DbLocalVoucherDDK.QUERY_KEY_ETD_FROM,
                                            txtShipEtdFrom.getText().trim());
    }

    try{
      processhandler.template.Properties.getCenteralControler().doCommandExecute(
       new newtimes.accounting.local_voucher.TgrListQryLvDDK()
      );
    }catch(Exception exp){
      exp.printStackTrace();
    }

  }
}
