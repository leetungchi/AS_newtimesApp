package newtimes.general_voucher.daily_voucher;
import java.awt.*;
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

public class PnlRpt5105Analyze
    //extends JPanel {
    extends AbsQryPanel{
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel1 = new BlueBkgWhiteCharLabel();
  WhiteBkgBlueCharLabel whiteBkgBlueCharLabel1 = new WhiteBkgBlueCharLabel();
  JTextField txtDateFrom = new JTextField();
  WhiteBkgBlueCharLabel whiteBkgBlueCharLabel2 = new WhiteBkgBlueCharLabel();
  JTextField txtDateTo = new JTextField();
  JButton btnQry = new JButton();
  WhiteBkgBlueCharLabel whiteBkgBlueCharLabel3 = new WhiteBkgBlueCharLabel();
  JTextField txtExpDateFrom = new JTextField();
  WhiteBkgBlueCharLabel whiteBkgBlueCharLabel4 = new WhiteBkgBlueCharLabel();
  JTextField txtExpDateTo = new JTextField();
  WhiteBkgBlueCharLabel whiteBkgBlueCharLabel5 = new WhiteBkgBlueCharLabel();
  JComboBox cbxCnty = new JComboBox(new String[]{"","美國","義大利","歐洲"});
  WhiteBkgBlueCharLabel whiteBkgBlueCharLabel6 = new WhiteBkgBlueCharLabel();
  JComboBox cbxCur = new JComboBox(new String[]{"","DHL","FEDEX","UPS"});;
  WhiteBkgBlueCharLabel whiteBkgBlueCharLabel7 = new WhiteBkgBlueCharLabel();
  JTextField txtBLNo1 = new JTextField();
  JTextField txtBLNo2 = new JTextField();
  JTextField txtBLNo3 = new JTextField();

  public PnlRpt5105Analyze() {
    try {
      //jbInit();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }

  void jbInit() throws Exception {
    blueBkgWhiteCharLabel1.setFont(new java.awt.Font("Dialog", 1, 14));
    blueBkgWhiteCharLabel1.setText("GUESS 運費分析表");
    blueBkgWhiteCharLabel1.setBounds(new Rectangle(-2, 1, 806, 25));
    this.setLayout(null);
    whiteBkgBlueCharLabel1.setFont(new java.awt.Font("Dialog", 0, 14));
    whiteBkgBlueCharLabel1.setText("傳票日期:");
    whiteBkgBlueCharLabel1.setBounds(new Rectangle(263, 32, 82, 25));
    txtDateFrom.setText("");
    txtDateFrom.setBounds(new Rectangle(344, 32, 70, 25));
    whiteBkgBlueCharLabel2.setBounds(new Rectangle(414, 32, 28, 25));
    whiteBkgBlueCharLabel2.setText("~");
    whiteBkgBlueCharLabel2.setFont(new java.awt.Font("Dialog", 0, 14));
    txtDateTo.setText("");
    txtDateTo.setBounds(new Rectangle(443, 32, 70, 25));
    btnQry.setBounds(new Rectangle(643, 76, 106, 27));
    btnQry.setFont(new java.awt.Font("Dialog", 1, 12));
    btnQry.setText("REPORT");
    btnQry.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnQry_actionPerformed(e);
      }
    });
    this.setBackground(new Color(202, 202, 224));
    whiteBkgBlueCharLabel3.setFont(new java.awt.Font("Dialog", 0, 14));
    whiteBkgBlueCharLabel3.setText("~");
    whiteBkgBlueCharLabel3.setBounds(new Rectangle(155, 32, 28, 25));
    txtExpDateFrom.setText("");
    txtExpDateFrom.setBounds(new Rectangle(85, 32, 70, 25));
    whiteBkgBlueCharLabel4.setBounds(new Rectangle(4, 32, 82, 25));
    whiteBkgBlueCharLabel4.setText("出口日期:");
    whiteBkgBlueCharLabel4.setFont(new java.awt.Font("Dialog", 0, 14));
    txtExpDateTo.setBounds(new Rectangle(184, 32, 70, 25));
    txtExpDateTo.setText("");
    whiteBkgBlueCharLabel5.setFont(new java.awt.Font("Dialog", 0, 14));
    whiteBkgBlueCharLabel5.setText("國別:");
    whiteBkgBlueCharLabel5.setBounds(new Rectangle(528, 32, 63, 25));
    cbxCnty.setBounds(new Rectangle(591, 32, 146, 25));
    whiteBkgBlueCharLabel6.setBounds(new Rectangle(4, 70, 94, 25));
    whiteBkgBlueCharLabel6.setText("COURIER:");
    whiteBkgBlueCharLabel6.setFont(new java.awt.Font("Dialog", 0, 14));
    cbxCur.setBounds(new Rectangle(98, 70, 130, 25));
    whiteBkgBlueCharLabel7.setFont(new java.awt.Font("Dialog", 0, 14));
    whiteBkgBlueCharLabel7.setText("B/L #:");
    whiteBkgBlueCharLabel7.setBounds(new Rectangle(236, 70, 53, 25));
    txtBLNo1.setText("");
    txtBLNo1.setBounds(new Rectangle(291, 70, 70, 25));
    txtBLNo2.setBounds(new Rectangle(365, 70, 70, 25));
    txtBLNo2.setText("");
    txtBLNo3.setBounds(new Rectangle(441, 70, 70, 25));
    txtBLNo3.setText("");
    this.add(btnQry, null);
    this.add(blueBkgWhiteCharLabel1, null);
    this.add(txtExpDateTo, null);
    this.add(whiteBkgBlueCharLabel4, null);
    this.add(txtExpDateFrom, null);
    this.add(whiteBkgBlueCharLabel3, null);
    this.add(txtDateFrom, null);
    this.add(whiteBkgBlueCharLabel1, null);
    this.add(whiteBkgBlueCharLabel2, null);
    this.add(txtDateTo, null);
    this.add(whiteBkgBlueCharLabel5, null);
    this.add(cbxCnty, null);
    this.add(whiteBkgBlueCharLabel6, null);
    this.add(cbxCur, null);
    this.add(whiteBkgBlueCharLabel7, null);
    this.add(txtBLNo1, null);
    this.add(txtBLNo2, null);
    this.add(txtBLNo3, null);
    genDataBindObj();
  }
  public void genDataBindObj(){
    try{

     Object vftxtChkDD=exgui.verification.CellFormat.getDateStringFormaterAllowNull();
    exgui.DataBindTextWithChecker dbTxtExpDateFrom= new exgui.DataBindTextWithChecker(txtExpDateFrom,
                             "P_DATE_FM",
                             null, 10,
                             (exgui.Object2String)vftxtChkDD,
                             (exgui.ultratable.CellTxtEditorFormat)vftxtChkDD);
     dataBindComps.add(dbTxtExpDateFrom);

     exgui.DataBindTextWithChecker dbTxtExpDateTo= new exgui.DataBindTextWithChecker(txtExpDateTo,
                        "P_DATE_TO", null, 10,
                        (exgui.Object2String)vftxtChkDD,
                        (exgui.ultratable.CellTxtEditorFormat)vftxtChkDD);
      dataBindComps.add(dbTxtExpDateTo);


      exgui.DataBindTextWithChecker dbTxtVhDateFrom= new exgui.DataBindTextWithChecker(txtDateFrom,
                               "P_NO_FM",
                               null, 10,
                               (exgui.Object2String)vftxtChkDD,
                               (exgui.ultratable.CellTxtEditorFormat)vftxtChkDD);
       dataBindComps.add(dbTxtVhDateFrom);

       exgui.DataBindTextWithChecker dbTxtVhDateTo= new exgui.DataBindTextWithChecker(txtDateTo,
                          "P_NO_TO", null, 10,
                          (exgui.Object2String)vftxtChkDD,
                          (exgui.ultratable.CellTxtEditorFormat)vftxtChkDD);
        dataBindComps.add(dbTxtVhDateTo);




      Object vftxtAccNO = exgui.verification.CellFormat.getOrdinaryField(4);
        new exgui.DataBindTextWithChecker(txtBLNo1, "",
            "", 4,
            (exgui.Object2String)vftxtAccNO,
                          (exgui.ultratable.CellTxtEditorFormat)vftxtAccNO);

       new exgui.DataBindTextWithChecker(txtBLNo2, "",
           "", 4,
           (exgui.Object2String)vftxtAccNO,
                         (exgui.ultratable.CellTxtEditorFormat)vftxtAccNO);

      new exgui.DataBindTextWithChecker(txtBLNo3, "",
          "", 4,
          (exgui.Object2String)vftxtAccNO,
                        (exgui.ultratable.CellTxtEditorFormat)vftxtAccNO);



     super.reportName="ACC_GUESS_FRET.rpt";
    }catch(Exception exp){
      exp.printStackTrace();
    }

  }
  public  HashMap composeParameters(){
    HashMap hm=super.composeParameters();
    Object cntyValue=cbxCnty.getSelectedItem();
    hm.put("P_COUNTRY",("".equals(cntyValue))?null:cntyValue.toString() );
    Object curValue=cbxCur.getSelectedItem();
    hm.put("P_COURIER",("".equals(curValue))?null:curValue.toString() );
    hm.put("P_BL_NO",txtBLNo1.getText().trim()+txtBLNo2.getText().trim()+txtBLNo3.getText().trim());
    return hm;
  }
  void btnQry_actionPerformed(ActionEvent e) {

    if(txtDateFrom.getText().trim().length()==0){
     exgui.verification.VerifyLib.showAlert("請輸入傳票起始日","Date From is blank");
     return;
    }
    if(txtDateTo.getText().trim().length()==0){
     exgui.verification.VerifyLib.showAlert("請輸入傳票截止日","End From is blank");
     return;
    }

    if(txtExpDateFrom.getText().trim().length()==0){
     exgui.verification.VerifyLib.showAlert("請輸入出口起始日","Date From is blank");
     return;
    }
    if(txtExpDateTo.getText().trim().length()==0){
     exgui.verification.VerifyLib.showAlert("請輸入出口截止日","End From is blank");
     return;
    }


   String orgURL=newtimes.production.report.ReportCmdSet.myReportEngin.reportServerURL;
    newtimes.production.report.ReportCmdSet.myReportEngin.reportServerURL=
 "http://rpt2.nttpe.com.tw:9000/?file:///cc53//rpt//";
 super.JButtonQueryButtonAction(null);
  newtimes.production.report.ReportCmdSet.myReportEngin.reportServerURL=orgURL;

  }
}
