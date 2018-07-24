package newtimes.production.report;

import java.awt.*;
import exgui.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.Vector;
import database.datatype.Record;
import java.util.Calendar;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class PnlQryDelayOdr
    //extends JPanel {
    extends AbsQryPanel{
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel1 = new BlueBkgWhiteCharLabel();
  JLabel jLabel1 = new JLabel();
  JTextField txtFrom = new JTextField();
  JLabel jLabel2 = new JLabel();
  JTextField txtTo = new JTextField();
  JLabel jLabel3 = new JLabel();
  JComboBox cbxDep = new JComboBox(),cbxCenter=new JComboBox();
  JButton btnGenReport = new JButton();
  exgui.DataBindTextWithChecker dbTxtDateBgn,dbTxtDateEnd,dbTxtDateEntry;
  exgui.DataBindJCombobox  dbCbxDep,dbCbxCenter;
  int indexCbxDep=0;
  public PnlQryDelayOdr() {
    try {
      jbInit();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }

  void jbInit() throws Exception {
    setBackground(new Color(204, 204, 225));
    blueBkgWhiteCharLabel1.setText("DELAY ORDER CHECK LIST");
    blueBkgWhiteCharLabel1.setBounds(new Rectangle(0, 12, 802, 26));
    this.setLayout(null);
    jLabel1.setText("DELIVER DATE FROM:");
    jLabel1.setBounds(new Rectangle(18, 113, 136, 20));
    txtFrom.setText("");
    txtFrom.setBounds(new Rectangle(166, 112, 74, 20));
    jLabel2.setBounds(new Rectangle(271, 114, 28, 20));
    jLabel2.setText("TO:");
    txtTo.setBounds(new Rectangle(299, 113, 71, 20));

    jLabel3.setText("DEPARTMENT:");
    jLabel3.setBounds(new Rectangle(247, 59, 94, 23));
    cbxDep.setBounds(new Rectangle(340, 59, 156, 23));
    btnGenReport.setBounds(new Rectangle(653, 156, 110, 23));
    btnGenReport.setFont(new java.awt.Font("Dialog", 1, 11));
    btnGenReport.setText("REPORT");
    btnGenReport.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnGenReport_actionPerformed(e);
      }
    });
    jLabel4.setText("CENTER:");
    jLabel4.setBounds(new Rectangle(20, 61, 70, 23));
    cbxCenter.setBounds(new Rectangle(94, 61, 126, 23));
    jLabel5.setText("RETURN DATE:");
    jLabel5.setBounds(new Rectangle(426, 153, 91, 23));
    txtEntryDate.setText("");
    txtEntryDate.setBounds(new Rectangle(517, 155, 111, 21));
    rdoIncludeSCNULL.setBackground(new Color(204, 204, 225));
    rdoIncludeSCNULL.setSelected(true);
    rdoIncludeSCNULL.setText("NO");
    rdoIncludeSCNULL.setBounds(new Rectangle(261, 152, 50, 29));
    rdoIncludeSCNULL.addActionListener(new PnlQryDelayOdr_rdoIncludeSCNULL_actionAdapter(this));
    rdoXcldSCNULL.setBackground(new Color(204, 204, 225));
    rdoXcldSCNULL.setText("YES");
    rdoXcldSCNULL.setBounds(new Rectangle(163, 152, 79, 29));
    jLabel6.setText("EXCLUDE SC IS SPACE:");
    jLabel6.setBounds(new Rectangle(22, 153, 153, 27));
    userCombo.setBounds(new Rectangle(514, 109, 122, 27));
    genUser.setBounds(new Rectangle(653, 110, 106, 28));
    genUser.setForeground(Color.red);
    genUser.setActionCommand("genUser");
    genUser.setText("GenUser");

    genUser.addActionListener(new PnlQryDelayOdr_genUser_actionAdapter(this));

    userCombo.addItem("ALL");
    jLabel7.setText("Select User :");
    jLabel7.setBounds(new Rectangle(431, 108, 79, 29));
    this.add(blueBkgWhiteCharLabel1, null);
    this.add(jLabel1, null);
    this.add(jLabel4, null);
    this.add(cbxCenter, null);
    this.add(btnGenReport, null);
    this.add(jLabel5, null);
    this.add(txtEntryDate, null);
    this.add(txtFrom, null);
    this.add(jLabel3, null);
    this.add(cbxDep, null);
    this.add(jLabel2, null);
    this.add(txtTo, null);
    this.add(jLabel6, null);
    this.add(rdoXcldSCNULL, null);
    this.add(rdoIncludeSCNULL, null);
    genDataBindObj();
    buttonGroup1.add(rdoXcldSCNULL);
    buttonGroup1.add(rdoIncludeSCNULL);
  }
  protected void genDataBindObj(){
    try{
      dataBindComps.clear();
      Object dateVfy = exgui.verification.CellFormat.getDateStringFormaterAllowNull();
      dbTxtDateBgn =
          new exgui.DataBindTextWithChecker(txtFrom, "DEL_BE", null,
                                            10, (exgui.Object2String)dateVfy,
                                            (exgui.ultratable.
                                             CellTxtEditorFormat)dateVfy);
      dataBindComps.add(dbTxtDateBgn);

      Calendar c = Calendar.getInstance();
      c.set(Calendar.DATE,1);
      c.add(Calendar.DATE,-1);
      dbTxtDateEnd =
          new exgui.DataBindTextWithChecker(txtTo, "DEL_EN",
                                            new java.sql.Date(c.getTimeInMillis()),
                                            10, (exgui.Object2String)dateVfy,
                                            (exgui.ultratable.
                                             CellTxtEditorFormat)dateVfy);
      dataBindComps.add(dbTxtDateEnd);


      dbTxtDateEntry =
          new exgui.DataBindTextWithChecker(txtEntryDate, "RTN_DATE",
                                            new java.sql.Date(System.currentTimeMillis()),
                                            10, (exgui.Object2String)dateVfy,
                                            (exgui.ultratable.
                                             CellTxtEditorFormat)dateVfy);
      dataBindComps.add(dbTxtDateEntry);


      dbCbxCenter =
           new exgui.DataBindJCombobox(
           cbxCenter, "CENTER_CODE",
          newtimes.preproduction.guis.tempProperties.tmpCenters,
           "CEN_NAME", "CEN_CODE",
           (String)util.PublicVariable.USER_RECORD.get("usr_cen_code"));

      dataBindComps.add(dbCbxCenter);
      indexCbxDep=dataBindComps.size();
      dataBindComps.add(null);
      this.add(btnGenReport, null);
      this.add(cbxDep, null);
      this.add(jLabel3, null);
      this.add(cbxDep, null);
      this.add(jLabel4, null);
      this.add(cbxCenter, null);
      this.add(jLabel3, null);
      this.add(genUser, null);
      this.add(userCombo, null);
      this.add(btnGenReport, null);
      this.add(jLabel5, null);
      this.add(txtEntryDate, null);
      this.add(jLabel2, null);
      this.add(txtTo, null);
      this.add(jLabel7, null);
      this.add(jLabel2, null);
      /*
      Vector depVects=
          (Vector)newtimes.preproduction.guis.tempProperties.tmpH_tbl_CenterDepMap.get(
          dbCbxCenter.getSelectedValue());

         dbCbxDep =
            new exgui.DataBindJCombobox(
            cbxDep, "DEP_CODE",
            depVects,
            "DEP_NAME", "DEP_CODE",
            null,
            "ALL", "ALL");
      dataBindComps.add(dbCbxDep);
      */
      reportName ="delay_od.rpt";
      cbxCenter.addItemListener(new cbxCenterItemChanged());
      cbxCenter.getItemListeners()[0].itemStateChanged(null);
    }catch(Exception exp){
       exp.printStackTrace();
    }
  }
  class cbxCenterItemChanged implements java.awt.event.ItemListener {
    public void itemStateChanged(ItemEvent e) {
       udpateDepComboBox();
    }
  }

  protected void udpateDepComboBox(){
    Vector depVects=
        (Vector)newtimes.preproduction.guis.tempProperties.tmpH_tbl_CenterDepMap.get(
        dbCbxCenter.getSelectedValue());
       dbCbxDep =
          new exgui.DataBindJCombobox(
          cbxDep, "DEP_CODE",
          depVects,
          "DEP_NAME", "DEP_CODE",
          null,
          "ALL", "ALL");
    dataBindComps.set(indexCbxDep,dbCbxDep);

  }


  protected java.util.HashMap composeParameters(){
    java.util.HashMap hm=super.composeParameters();
    Object dateBgn=dbTxtDateBgn.getSelectedValue();
    Object dateEnd = dbTxtDateEnd.getSelectedValue();
    if (dateBgn == null) {
      hm.put("DEL_BE", "DATE(2000,01,01)");
    }
    if (dateEnd == null) {
      hm.put("DEL_EN", "DATE(2099,12,31)");
    }
    if(rdoXcldSCNULL.isSelected()){
      hm.put("EXC_SC","Y");
    }else{
      hm.put("EXC_SC","N");
    }
      hm.put("P_USER",userCombo.getSelectedItem().toString());
    return hm;
  }
  void btnGenReport_actionPerformed(ActionEvent e) {
     if(txtEntryDate.getText().trim().length()==0){
       exgui.verification.VerifyLib.showAlert("Please Input \"Entry Date\"","Please Input \"Entry Date\"");
       txtEntryDate.grabFocus();
       return;
     }
     String prtSever=newtimes.production.report.ReportCmdSet.myReportEngin.reportServerURL;
    newtimes.production.report.ReportCmdSet.myReportEngin.reportServerURL=
    "http://rpt2.nttpe.com.tw:9000/?file:///cc53//rpt//";

     super.JButtonQueryButtonAction(e);
      newtimes.production.report.ReportCmdSet.myReportEngin.reportServerURL=prtSever;
  }
  JLabel jLabel4 = new JLabel();
  JLabel jLabel5 = new JLabel();
  JTextField txtEntryDate = new JTextField();
  JRadioButton rdoIncludeSCNULL = new JRadioButton();
  ButtonGroup buttonGroup1 = new ButtonGroup();
  JRadioButton rdoXcldSCNULL = new JRadioButton();
  JLabel jLabel6 = new JLabel();
  JComboBox userCombo = new JComboBox();
  JButton genUser = new JButton();
  JLabel jLabel7 = new JLabel();

  void genUser_actionPerformed(ActionEvent e) {
       try {

             StringBuffer sb = new StringBuffer();
             sb.append("SELECT distinct PROD_HEAD.RECORD_CREATE_USER ");
             sb.append("FROM PRODUCTION,PROD_HEAD,STYLE,V_STY_BALANCE ");
             sb.append("WHERE PRODUCTION.PROD_HEAD_PK=PROD_HEAD.PROD_HEAD_PK and ");
             sb.append("PRODUCTION.PROD_HEAD_PK=STYLE.PROD_HEAD_PK and ");
             sb.append("STYLE.STY_SEQ=V_STY_BALANCE.STYLE_PK and ");
             sb.append("PROD_HEAD.RECORD_DELETE_FLAG = '1' and PRODUCTION.RECORD_DELETE_FLAG = '1' and ");
             sb.append("STYLE.RECORD_DELETE_FLAG = '1' and not STYLE.STY_CLOSE = 'Y' and ");
             sb.append("PROD_HEAD.PROD_CEN_CODE = '001' and  ");

             sb.append("NVL(STYLE.STY_RECFM_DEL,STYLE.STY_ORIG_DEL) <= to_date('"+txtTo.getText()+"','yyyy/mm/dd')  ");
             sb.append("AND V_STY_BALANCE.BALANCE_QTY > 0" );
             if(rdoXcldSCNULL.isSelected()){
                 sb.append("and not  PRODUCTION.PROD_SC_NO IS NULL ");
             }
             Vector  vct2return = exgui2.CONST.BASIC_MAIN_EJB.getDatas(
                                             util.PublicVariable.USER_RECORD,
                                             sb.toString(),
                                              1, 99999);
            userCombo.removeAllItems();
            userCombo.addItem("ALL");
            for (int i=0;i<vct2return.size();i++) {
                 Record rec = (Record)vct2return.get(i);
                 userCombo.addItem(rec.get(0).toString());
            }
//            System.out.println(genUser.getForeground()+" >< "+Color.red);
            if ( genUser.getForeground().equals(Color.red)) {
                 genUser.setForeground(Color.blue);
            } else {
                 genUser.setForeground(Color.red);
            };
       }
       catch(Exception exp) {
             exp.printStackTrace();
       }
  }

  void rdoIncludeSCNULL_actionPerformed(ActionEvent e) {

  }
}

class PnlQryDelayOdr_genUser_actionAdapter implements java.awt.event.ActionListener {
  PnlQryDelayOdr adaptee;

  PnlQryDelayOdr_genUser_actionAdapter(PnlQryDelayOdr adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.genUser_actionPerformed(e);
  }
}

class PnlQryDelayOdr_rdoIncludeSCNULL_actionAdapter implements java.awt.event.ActionListener {
  PnlQryDelayOdr adaptee;

  PnlQryDelayOdr_rdoIncludeSCNULL_actionAdapter(PnlQryDelayOdr adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.rdoIncludeSCNULL_actionPerformed(e);
  }
}
