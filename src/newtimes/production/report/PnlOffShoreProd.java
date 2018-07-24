package newtimes.production.report;

import java.awt.*;
import exgui.*;
import javax.swing.*;
import newtimes.production.report.AbsQryPanel;
import java.util.*;
import exgui.verification.CellFormat;
import database.datatype.Record;
import exgui.ultratable.CellTxtEditorFormat;
import java.awt.event.*;
import newtimes.preproduction.guis.*;
import newtimes.preproduction.buyermakerselect.*;



public class PnlOffShoreProd
    //extends JPanel {
    extends AbsQryPanel {
  JLabel blueBkgWhiteCharLabel3 = new JLabel();
  JTextField txtTo = new JTextField();
  JLabel jLabel1 = new JLabel();
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel1 = new BlueBkgWhiteCharLabel();
  JLabel jLabel3 = new JLabel();
  JComboBox cbxCntr = new JComboBox();
  JTextField txtYYYYMMDD = new JTextField();
  JButton btnQry = new JButton();
  exgui.DataBindJCombobox DbJcbxcbxCntr;
  protected   JTextField txtTwdUsd=new JTextField();
  protected   JTextField txtHkdUsd=new JTextField();
  protected   JTextField txtRmbUsd=new JTextField();
  JLabel blueBkgWhiteCharLabel4 = new JLabel();
  JComboBox cbxUnship = new JComboBox(new String[]{"NO","YES"});

  public PnlOffShoreProd() {
    try {
      jbInit();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }

  public void  jbInit() throws Exception {
    btnQry.setText("REPORT");
    btnQry.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnQry_actionPerformed(e);
      }
    });
    btnQry.setFocusPainted(true);
    btnQry.setFont(new java.awt.Font("Dialog", 1, 11));
    btnQry.setBounds(new Rectangle(694, 51, 89, 25));
    txtYYYYMMDD.setBounds(new Rectangle(291, 51, 77, 24));
    //cbxCntr.addItemListener(new cbxCenterItemChanged());
    cbxCntr.setBounds(new Rectangle(57, 51, 130, 22));
    jLabel3.setBounds(new Rectangle(375, 51, 36, 26));
    jLabel3.setFont(new java.awt.Font("Dialog", 1, 11));
    jLabel3.setText("To:");
    blueBkgWhiteCharLabel1.setText("PRODUCTION OFFSHORE REPORT");
    blueBkgWhiteCharLabel1.setBounds(new Rectangle(-4, 6, 802, 30));
    jLabel1.setFont(new java.awt.Font("Dialog", 1, 11));
    jLabel1.setForeground(Color.black);
    jLabel1.setText("DEL Date From:");
    jLabel1.setBounds(new Rectangle(194, 51, 97, 26));
    txtTo.setBounds(new Rectangle(408, 51, 77, 24));
    blueBkgWhiteCharLabel3.setBounds(new Rectangle(0, 51, 60, 19));
    blueBkgWhiteCharLabel3.setFont(new java.awt.Font("Dialog", 1, 11));
    blueBkgWhiteCharLabel3.setText("Center");
    this.setLayout(null);
    this.setBackground(new Color(202, 202, 224));
    blueBkgWhiteCharLabel4.setText("UNSHIP");
    blueBkgWhiteCharLabel4.setFont(new java.awt.Font("Dialog", 1, 11));
    blueBkgWhiteCharLabel4.setBounds(new Rectangle(513, 51, 52, 19));
    cbxUnship.setBounds(new Rectangle(562, 51, 130, 22));
    this.add(blueBkgWhiteCharLabel1, null);
    this.add(blueBkgWhiteCharLabel3, null);
    this.add(cbxCntr, null);
    this.add(jLabel1, null);
    this.add(txtYYYYMMDD, null);
    this.add(jLabel3, null);
    this.add(txtTo, null);
    this.add(blueBkgWhiteCharLabel4, null);
    this.add(cbxUnship, null);
    this.add(btnQry, null);
    genDataBindObj();
  }
  public void genDataBindObj(){
    dataBindComps.clear();
    try {
    Vector vctCenter=exgui2.CONST.BASIC_MAIN_EJB.getDatas(
       util.PublicVariable.USER_RECORD,"select * from center where cen_name in ('VIETNAM','THAILAND','INDONESIA') ",1,99999);

    DbJcbxcbxCntr =
        new exgui.DataBindJCombobox(
        cbxCntr, "P_CENTER",
        vctCenter,
        "CEN_NAME", "CEN_CODE","THI"
        );
     dataBindComps.add(DbJcbxcbxCntr);


      Object chkYearMon=CellFormat.getDateStringFormaterAllowNull();
     DataBindTextWithChecker yyyymmddDate = new DataBindTextWithChecker(txtYYYYMMDD, "P_DEL_FM",
                                             new java.sql.Date(System.currentTimeMillis()), 10,
                                             (Object2String)chkYearMon,
                                             (CellTxtEditorFormat)chkYearMon);
     dataBindComps.add(yyyymmddDate);

     DataBindTextWithChecker yyyymmddDate2 = new DataBindTextWithChecker(txtTo, "P_DEL_TO",
                                             new java.sql.Date(System.currentTimeMillis()), 10,
                                             (Object2String)chkYearMon,
                                             (CellTxtEditorFormat)chkYearMon);
     dataBindComps.add(yyyymmddDate2);
     Vector vct = exgui2.CONST.BASIC_MAIN_EJB.getDatas(util.PublicVariable.USER_RECORD, "select * from system_default_value where CENTER='" + (String)util.PublicVariable.USER_RECORD.get("USR_CEN_CODE") + "' and record_delete_flag=1", 1, 1);
     Record recSystem = (Record)vct.get(0);
    Object chkDcm32 = CellFormat.getDoubleFormatAllowNull(5, 4);
     DataBindTextWithChecker dbTwdChg = new DataBindTextWithChecker(txtTwdUsd, "TWD_USD", recSystem.get("TWD_XCHG_RATE"), 10, (Object2String)chkDcm32, (CellTxtEditorFormat)chkDcm32);
     dataBindComps.add(dbTwdChg);
     DataBindTextWithChecker dbRmbChg = new DataBindTextWithChecker(txtRmbUsd, "RMB_USD", recSystem.get("RMB_XCHG_RATE"), 10, (Object2String)chkDcm32, (CellTxtEditorFormat)chkDcm32);
     dataBindComps.add(dbRmbChg);
     DataBindTextWithChecker dbHkdChg = new DataBindTextWithChecker(txtHkdUsd, "HKD_USD", recSystem.get("HKD_XCHG_RATE"), 10, (Object2String)chkDcm32, (CellTxtEditorFormat)chkDcm32);
     dataBindComps.add(dbHkdChg);

     reportName="HK_PROD_OFS.rpt";
    } catch (Exception exp) {
       exp.printStackTrace();
       util.ExceptionLog.exp2File(exp,"");
    }
  }
  public java.util.HashMap composeParameters(){
    java.util.HashMap hm=super.composeParameters();
    if(txtYYYYMMDD.getText().trim().length()==0){
      hm.put("P_DEL_FM","DATE(2000,01,01)");
    }
    if(txtTo.getText().trim().length()==0){
      hm.put("P_DEL_TO","DATE(2099,12,31)");
    }
    hm.put("UNSHIP",cbxUnship.getSelectedItem().toString().substring(0,1));
    return hm;
  }
  void btnQry_actionPerformed(ActionEvent e) {
     super.JButtonQueryButtonAction(e);
  }
}
