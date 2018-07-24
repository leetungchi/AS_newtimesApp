package newtimes.production.report;
import java.awt.*;
import exgui.*;
import javax.swing.*;
import javax.swing.border.*;
import exgui.*;
import java.awt.event.*;
/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class PnlRptInqCustPoInfor
  //extends JPanel {
  extends AbsQryPanel {
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel1 = new BlueBkgWhiteCharLabel();
  JComboBox cbxCenter = new JComboBox();
  JLabel lblCenter = new JLabel();
  TitledBorder titledBorder1;
  TitledBorder titledBorder2;
  JLabel jLabel1 = new JLabel();
  JTextField txtPoFrom = new JTextField();
  JLabel jLabel2 = new JLabel();
  JTextField txtPoTo = new JTextField();
  JButton btnQry = new JButton();
  DataBindJCombobox dbCbxCenter;
  public PnlRptInqCustPoInfor() {
    try {
      //jbInit();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }

  void jbInit() throws Exception {
    titledBorder1 = new TitledBorder("");
    titledBorder2 = new TitledBorder(BorderFactory.createEtchedBorder(Color.white,new Color(141, 141, 156)),"INVOICE NO.");
    blueBkgWhiteCharLabel1.setText("INQUERY CUST P.O. INFORMATION");
    blueBkgWhiteCharLabel1.setBounds(new Rectangle(-1, 3, 801, 25));
    this.setBackground(new Color(202, 202, 224));
    this.setLayout(null);
    cbxCenter.setBounds(new Rectangle(66, 33, 135, 22));
    lblCenter.setFont(new java.awt.Font("Dialog", 1, 11));
    lblCenter.setText("CENTER");
    lblCenter.setBounds(new Rectangle(5, 33, 62, 22));
    jLabel1.setBackground(Color.white);
    jLabel1.setFont(new java.awt.Font("Dialog", 1, 11));
    jLabel1.setOpaque(true);
    jLabel1.setHorizontalAlignment(SwingConstants.CENTER);
    jLabel1.setText("PO FROM:");
    jLabel1.setBounds(new Rectangle(334, 33, 88, 24));
    txtPoFrom.setText("");
    txtPoFrom.setBounds(new Rectangle(422, 33, 96, 24));
    jLabel2.setBounds(new Rectangle(518, 33, 50, 24));
    jLabel2.setText("TO:");
    jLabel2.setBackground(Color.white);
    jLabel2.setFont(new java.awt.Font("Dialog", 1, 11));
    jLabel2.setOpaque(true);
    jLabel2.setHorizontalAlignment(SwingConstants.CENTER);
    txtPoTo.setBounds(new Rectangle(568, 33, 96, 24));
    txtPoTo.setText("");
    btnQry.setBounds(new Rectangle(687, 33, 97, 27));
    btnQry.setFont(new java.awt.Font("Dialog", 1, 11));
    btnQry.setText("QUERY");
    btnQry.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnQry_actionPerformed(e);
      }
    });
    this.add(blueBkgWhiteCharLabel1, null);
    this.add(txtPoTo, null);
    this.add(lblCenter, null);
    this.add(cbxCenter, null);
    this.add(jLabel1, null);
    this.add(txtPoFrom, null);
    this.add(jLabel2, null);
    this.add(btnQry, null);
    genDataBindObj();
  }
  protected java.util.HashMap composeParameters(){
     java.util.HashMap hm= super.composeParameters();
     if(txtPoFrom.getText().trim().length()>0){
       hm.put("P_PO_FM",txtPoFrom.getText());
     }
     if(txtPoTo.getText().trim().length()>0){
       hm.put("P_PO_TO",txtPoTo.getText());
     }
     return hm;
  }
  protected void genDataBindObj(){
    try{
      dataBindComps.clear();
      dbCbxCenter =
           new exgui.DataBindJCombobox(
           cbxCenter, "P_CENTER",
          newtimes.preproduction.guis.tempProperties.tmpCenters,
           "CEN_NAME", "CEN_CODE",
           (String)util.PublicVariable.USER_RECORD.get("usr_cen_code"));
      dataBindComps.add(dbCbxCenter);
      reportName="QUY_PO_SHIP.rpt";
    }catch(Exception exp){
      exp.printStackTrace();
    }

  }

  void btnQry_actionPerformed(ActionEvent e) {
    if(txtPoFrom.getText().trim().length()==0){
      exgui.verification.VerifyLib.showAlert("Please Input Begin PO","Please Input Begin PO");
      txtPoFrom.grabFocus();
      return;
    }
    if(txtPoTo.getText().trim().length()==0){
      exgui.verification.VerifyLib.showAlert("Please Input End PO","Please Input End PO");
      txtPoTo.grabFocus();
      return;
    }

    String tempURL=newtimes.production.report.ReportProxyEngine.reportServerURL;
    newtimes.production.report.ReportProxyEngine.reportServerURL="http://rpt2.nttpe.com.tw:9000/?file:///rpt//";
    super.JButtonQueryButtonAction(null);
    newtimes.production.report.ReportProxyEngine.reportServerURL =tempURL;

  }
}
