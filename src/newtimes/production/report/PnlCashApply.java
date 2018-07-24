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

public class PnlCashApply
  //extends JPanel {
  extends AbsQryPanel {
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel1 = new BlueBkgWhiteCharLabel();
  JComboBox cbxCenter = new JComboBox();
  JLabel lblCenter = new JLabel();
  JPanel pnlInvoices = new JPanel();
  TitledBorder titledBorder1;
  TitledBorder titledBorder2;
  JLabel jLabel1 = new JLabel();
  JTextField txtInvFrom = new JTextField();
  JLabel jLabel2 = new JLabel();
  JTextField txtInvTo = new JTextField();
  JTextField txtInvX[] = new JTextField[6];
  JButton btnQry = new JButton();
  DataBindJCombobox dbCbxCenter;
  public PnlCashApply() {
    try {
      for(int i=0;i<6;i++){
        txtInvX[i] = new JTextField();
      }
      jbInit();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }

  void jbInit() throws Exception {
    titledBorder1 = new TitledBorder("");
    titledBorder2 = new TitledBorder(BorderFactory.createEtchedBorder(Color.white,new Color(141, 141, 156)),"INVOICE NO.");
    blueBkgWhiteCharLabel1.setText("Cash Apply Form");
    blueBkgWhiteCharLabel1.setBounds(new Rectangle(-1, 18, 801, 25));
    this.setBackground(new Color(202, 202, 224));
    this.setLayout(null);
    cbxCenter.setBounds(new Rectangle(6, 71, 135, 22));
    lblCenter.setFont(new java.awt.Font("Dialog", 1, 11));
    lblCenter.setText("CENTER");
    lblCenter.setBounds(new Rectangle(6, 46, 79, 22));
    pnlInvoices.setBackground(new Color(202, 202, 224));
    pnlInvoices.setBorder(titledBorder2);
    pnlInvoices.setBounds(new Rectangle(144, 51, 525, 89));
    pnlInvoices.setLayout(null);
    jLabel1.setBackground(Color.white);
    jLabel1.setFont(new java.awt.Font("Dialog", 1, 11));
    jLabel1.setOpaque(true);
    jLabel1.setHorizontalAlignment(SwingConstants.CENTER);
    jLabel1.setText("FROM:");
    jLabel1.setBounds(new Rectangle(8, 18, 50, 24));
    txtInvFrom.setText("");
    txtInvFrom.setBounds(new Rectangle(58, 18, 96, 23));
    jLabel2.setBounds(new Rectangle(8, 42, 50, 21));
    jLabel2.setText("TO:");
    jLabel2.setBackground(Color.white);
    jLabel2.setFont(new java.awt.Font("Dialog", 1, 11));
    jLabel2.setOpaque(true);
    jLabel2.setHorizontalAlignment(SwingConstants.CENTER);
    txtInvTo.setBounds(new Rectangle(58, 42, 96, 23));
    txtInvTo.setText("");
    txtInvX[0].setText("");
    txtInvX[0].setBounds(new Rectangle(204, 13, 96, 23));
    txtInvX[1].setText("");
    txtInvX[1].setBounds(new Rectangle(307, 13, 96, 23));
    txtInvX[2].setText("");
    txtInvX[2].setBounds(new Rectangle(407, 13, 96, 23));
    txtInvX[3].setText("");
    txtInvX[3].setBounds(new Rectangle(204, 44, 96, 23));
    txtInvX[4].setText("");
    txtInvX[4].setBounds(new Rectangle(307, 44, 96, 23));
    txtInvX[5].setText("");
    txtInvX[5].setBounds(new Rectangle(407, 44, 96, 23));
    btnQry.setBounds(new Rectangle(691, 109, 97, 27));
    btnQry.setFont(new java.awt.Font("Dialog", 1, 11));
    btnQry.setText("QUERY");
    btnQry.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnQry_actionPerformed(e);
      }
    });
    this.add(blueBkgWhiteCharLabel1, null);
    this.add(pnlInvoices, null);
    pnlInvoices.add(jLabel1, null);
    pnlInvoices.add(jLabel2, null);
    pnlInvoices.add(txtInvFrom, null);
    pnlInvoices.add(txtInvTo, null);
    pnlInvoices.add(txtInvX[1], null);
    pnlInvoices.add(txtInvX[0], null);
    pnlInvoices.add(txtInvX[3], null);
    pnlInvoices.add(txtInvX[4], null);
    pnlInvoices.add(txtInvX[5], null);
    pnlInvoices.add(txtInvX[2], null);
    this.add(lblCenter, null);
    this.add(cbxCenter, null);
    this.add(btnQry, null);
    genDataBindObj();
  }
  protected java.util.HashMap composeParameters(){
     java.util.HashMap hm= super.composeParameters();
     if(txtInvFrom.getText().trim().length()>0){
       hm.put("P_INV_FM",txtInvFrom.getText());
       if(txtInvTo.getText().trim().length()==0){
         //hm.put("P_INV_TO",txtInvTo.getText());
         txtInvTo.setText(txtInvFrom.getText());
       }
     }
     if(txtInvTo.getText().trim().length()>0){
       hm.put("P_INV_TO",txtInvTo.getText());
     }
     StringBuffer sb=new StringBuffer();
     for(int i=0;i<6;i++){
       if(txtInvX[i].getText().trim().length()>0){
         if(sb.length()>0)sb.append(",");
         sb.append("'");
         sb.append(txtInvX[i].getText().trim());
         sb.append("'");
       }
     }
     if(sb.length()>0){
       hm.put("P_INV","["+sb.toString()+"]");
     }else{
       //hm.put("P_INV","NULL");
         hm.put("P_INV","'0'");
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
      reportName="FTY_FUND.rpt";
    }catch(Exception exp){
      exp.printStackTrace();
    }

  }

  void btnQry_actionPerformed(ActionEvent e) {
    JButtonQueryButtonAction(e);

  }
}
