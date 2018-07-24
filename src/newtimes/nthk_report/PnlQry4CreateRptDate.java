package newtimes.nthk_report;

import java.awt.*;
import exgui.*;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.event.*;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class PnlQry4CreateRptDate extends JPanel {
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel1 = new BlueBkgWhiteCharLabel();
  JPanel jPanel1 = new JPanel();
  Border border1;
  TitledBorder titledBorder1;
  JTextField txtSRN[] = new JTextField[6];
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel2 = new BlueBkgWhiteCharLabel();
  JTextField txtEtdFrom = new JTextField();
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel3 = new BlueBkgWhiteCharLabel();
  JTextField txtEtdTo = new JTextField();
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel4 = new BlueBkgWhiteCharLabel();
  JTextField txtCreateFrom = new JTextField();
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel5 = new BlueBkgWhiteCharLabel();
  JTextField txtCreateTo = new JTextField();
  JButton btnQry = new JButton();
  JButton btnExit = new JButton();
  static String sql;
  static boolean IS_NTHK_CENTER=true;;
  public PnlQry4CreateRptDate() {
    try {
      sql=null;
      jbInit();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }

  void jbInit() throws Exception {
    border1 = new EtchedBorder(EtchedBorder.RAISED,Color.white,new Color(134, 134, 134));
    titledBorder1 = new TitledBorder(new EtchedBorder(EtchedBorder.RAISED,Color.white,new Color(134, 134, 134)),"INVOICE NO,Please Input Numeric Part Of SRN");
    blueBkgWhiteCharLabel1.setText("QUERY FOR MAINTAINNING CREATE DATE & REPORT ETD DATE");
    blueBkgWhiteCharLabel1.setBounds(new Rectangle(0, 34, 799, 27));
    this.setLayout(null);
    jPanel1.setBackground(new Color(202, 202, 244));
    jPanel1.setBorder(titledBorder1);
    jPanel1.setDebugGraphicsOptions(0);
    jPanel1.setBounds(new Rectangle(27, 92, 745, 132));
    jPanel1.setLayout(null);
    for(int i=0;i<6;i++){
      txtSRN[i]=new JTextField();
    }
    txtSRN[0].setText("");
    txtSRN[0].setBounds(new Rectangle(20, 26, 176, 26));
    txtSRN[1].setBounds(new Rectangle(244, 26, 176, 26));
    txtSRN[1].setText("jTextField1");
    txtSRN[1].setText("");
    txtSRN[2].setBounds(new Rectangle(467, 26, 176, 26));
    txtSRN[2].setText("jTextField1");
    txtSRN[2].setText("");
    txtSRN[3].setBounds(new Rectangle(20, 82, 176, 26));
    txtSRN[3].setText("jTextField1");
    txtSRN[3].setText("");
    txtSRN[4].setBounds(new Rectangle(244, 82, 176, 26));
    txtSRN[4].setText("jTextField1");
    txtSRN[4].setText("");
    txtSRN[5].setBounds(new Rectangle(467, 82, 176, 26));
    txtSRN[5].setText("jTextField1");
    txtSRN[5].setText("");
    blueBkgWhiteCharLabel2.setText("ETD FROM:");
    blueBkgWhiteCharLabel2.setBounds(new Rectangle(29, 247, 133, 28));
    txtEtdFrom.setText("");
    txtEtdFrom.setBounds(new Rectangle(163, 248, 114, 28));
    blueBkgWhiteCharLabel3.setBounds(new Rectangle(276, 248, 79, 28));
    blueBkgWhiteCharLabel3.setText("TO");
    txtEtdTo.setBounds(new Rectangle(355, 248, 114, 28));
    txtEtdTo.setText("");
    blueBkgWhiteCharLabel4.setText("TO");
    blueBkgWhiteCharLabel4.setBounds(new Rectangle(275, 293, 79, 28));
    txtCreateFrom.setBounds(new Rectangle(162, 293, 114, 28));
    txtCreateFrom.setText("");
    blueBkgWhiteCharLabel5.setBounds(new Rectangle(28, 292, 133, 28));
    blueBkgWhiteCharLabel5.setText("CREATE FROM:");
    txtCreateTo.setText("");
    txtCreateTo.setBounds(new Rectangle(354, 293, 114, 28));
    btnQry.setBackground(Color.white);
    btnQry.setBounds(new Rectangle(296, 479, 160, 34));
    btnQry.setFont(new java.awt.Font("Dialog", 1, 11));
    btnQry.setText("EXTRACT");
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
    btnExit.setFont(new java.awt.Font("Dialog", 1, 11));
    btnExit.setBounds(new Rectangle(600, 479, 160, 34));
    btnExit.setBackground(Color.white);
    this.setBackground(new Color(202, 202, 244));
    this.add(blueBkgWhiteCharLabel1, null);
    this.add(jPanel1, null);
    jPanel1.add(txtSRN[0], null);
    jPanel1.add(txtSRN[1], null);
    jPanel1.add(txtSRN[2], null);
    jPanel1.add(txtSRN[3], null);
    jPanel1.add(txtSRN[4], null);
    jPanel1.add(txtSRN[5], null);
    this.add(blueBkgWhiteCharLabel2, null);
    this.add(txtEtdFrom, null);
    this.add(blueBkgWhiteCharLabel3, null);
    this.add(txtEtdTo, null);
    this.add(blueBkgWhiteCharLabel4, null);
    this.add(txtCreateFrom, null);
    this.add(blueBkgWhiteCharLabel5, null);
    this.add(txtCreateTo, null);
    this.add(btnQry, null);
    this.add(btnExit, null);
    limitFields();
  }
 //set the field limits
  void limitFields(){
    Object objChkSRN = exgui.verification.CellFormat.getIntVerifier(6);
    for(int i=0;i<6;i++){
      exgui.DataBindTextWithChecker dbTxtProdPo = new exgui.
          DataBindTextWithChecker(
          txtSRN[i], "prodxn.prod_byr_sc_no", null, 6,
          (exgui.Object2String)objChkSRN,
          (exgui.ultratable.CellTxtEditorFormat)objChkSRN);
      txtSRN[i].setText("");
    }

    Object dateVfy=exgui.verification.CellFormat.getDateStringFormaterAllowNull();
    new exgui.DataBindTextWithChecker(txtEtdFrom,
                                "",
                                null,
                                10,
                                (exgui.Object2String) dateVfy,
                                (exgui.ultratable.CellTxtEditorFormat) dateVfy);


   new exgui.DataBindTextWithChecker(txtEtdTo,
                                "",
                                null,
                                10,
                                (exgui.Object2String)dateVfy,
                                (exgui.ultratable.CellTxtEditorFormat)dateVfy);

    new exgui.DataBindTextWithChecker(txtCreateFrom,
                                "",
                                null,
                                10,
                                (exgui.Object2String) dateVfy,
                                (exgui.ultratable.CellTxtEditorFormat) dateVfy);


   new exgui.DataBindTextWithChecker(txtCreateTo,
                                "",
                                null,
                                10,
                                (exgui.Object2String)dateVfy,
                                (exgui.ultratable.CellTxtEditorFormat)dateVfy);

  }
  void btnQry_actionPerformed(ActionEvent e) {
    try {
      //check if SRN is too short
      String finalSQL=composeSQL();
      if(finalSQL==null)return;
      sql=finalSQL;
      System.out.println("sql is "+sql);
      processhandler.template.Properties.getCenteralControler().doCommandExecute(
          new newtimes.nthk_report.TgrListRptEtdCreateDate());
    } catch (Exception eP) {
      eP.printStackTrace();
    }

  }
  String composeSQL(){
    StringBuffer sb=new StringBuffer();
    if(IS_NTHK_CENTER){
      sb.append("select * from shipping where 1=1 and record_delete_flag='1' and length(ship_no)=12 and ship_no like 'ZNNT%' ");
    }else{
      sb.append("select * from shipping where 1=1 and record_delete_flag='1' and length(ship_no)=13 and ship_dep in ");
      sb.append(" ('BS','BK','BW','CW','CS','CK','EX','EW','ES','EK','PK','PW') ");
    }
    StringBuffer sbSRN=new StringBuffer();
    for(int i=0;i<6;i++){
      if(txtSRN[i].getText().length()>0){
        if(txtSRN[i].getText().length()<6){
          exgui.verification.VerifyLib.showAlert("Numeric Part is 6 Digits","Numeric Part too short");
          return null;
        }else{
          if(sbSRN.length()>0)sbSRN.append(" or ");
          sbSRN.append("(ship_no like '%");
          sbSRN.append(txtSRN[i].getText().trim());
          sbSRN.append("') ");
        }
      }
    }
    if(sbSRN.length()>0){
     sb.append(" and (");
     sb.append(sbSRN.toString());
     sb.append(") ");
    }
    if (txtEtdFrom.getText().length() == 10) {
      sb.append("and ship_etd_date >= to_date('");
      sb.append(txtEtdFrom.getText().trim());
      sb.append("','YYYY/MM/DD') ");
    }
    if (txtEtdTo.getText().length() == 10) {
      sb.append("and ship_etd_date <= to_date('");
      sb.append(txtEtdTo.getText().trim());
      sb.append("','YYYY/MM/DD') ");
    }
    if (txtCreateFrom.getText().length() == 10) {
      sb.append("and record_create_date >= to_date('");
      sb.append(txtCreateFrom.getText().trim());
      sb.append("','YYYY/MM/DD') ");
    }
    if (txtCreateTo.getText().length() == 10) {
      sb.append("and record_create_date <= to_date('");
      sb.append(txtCreateTo.getText().trim());
      sb.append("','YYYY/MM/DD') ");
    }
    return sb.toString();
  }
  void btnExit_actionPerformed(ActionEvent e) {
    try {
      processhandler.template.Properties.getCenteralControler().goBack();
    } catch (Exception eP) {
      eP.printStackTrace();
    }

  }
}
