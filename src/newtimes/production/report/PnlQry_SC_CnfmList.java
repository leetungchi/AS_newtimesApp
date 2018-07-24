package newtimes.production.report;

import java.awt.*;
import exgui.*;
import javax.swing.*;
import newtimes.preproduction.buyermakerselect.*;
import java.awt.event.*;
import java.util.*;
import newtimes.preproduction.guis.tempProperties;
/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class PnlQry_SC_CnfmList
    //extends JPanel {
    extends AbsQryPanel{
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel1 = new BlueBkgWhiteCharLabel();
  JLabel jLabel1 = new JLabel();
  JComboBox cbxCenter = new JComboBox();
  JLabel jLabel2 = new JLabel();
  JTextField txtIsuFrom = new JTextField();
  JLabel jLabel3 = new JLabel();
  JTextField txtIsuTo = new JTextField();
  JLabel jLabel4 = new JLabel();
  SelectBuyerMaker slkBuyer = new SelectBuyerMaker();
  JButton btnReport = new JButton();
  exgui.DataBindTextWithChecker dbTxtDateBgn,dbTxtDateEnd,dbTxtDlvBgn,dbTxtDlvTo,dbTxtScFrom,dbTxtScTo;

  exgui.DataBindJCombobox dbCbxCenter,DbJcbxcbxDep;
  JRadioButton rdoIncludeSCNULL = new JRadioButton();
  ButtonGroup buttonGroup1 = new ButtonGroup();
  JRadioButton rdoXcldSCNULL = new JRadioButton();
  JLabel lblToExcludeSC = new JLabel();
  JComboBox cbxDep = new JComboBox();
  JLabel depLbl = new JLabel();
  JLabel jLabel5 = new JLabel();
  JLabel jLabel6 = new JLabel();
  JTextField txtDelFrom = new JTextField();
  JTextField txtDelTo = new JTextField();
  JTextField txtScTo = new JTextField();
  JLabel jLabel7 = new JLabel();
  JTextField txtScFrom = new JTextField();
  JLabel jLabel8 = new JLabel();
  int depCbxDBGUI_index=0;
  boolean doingDB2Gui=false;
  cbxCenterItemChanged cbxListener=new cbxCenterItemChanged();
  public PnlQry_SC_CnfmList() {
    try {
      jbInit();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }

 protected void jbInit() throws Exception {
    blueBkgWhiteCharLabel1.setText("LIST OF CONFIRMATION (BY DEL-DATE)");
    blueBkgWhiteCharLabel1.setBounds(new Rectangle(0, 17, 801, 24));
    this.setLayout(null);
    jLabel1.setRequestFocusEnabled(false);
    jLabel1.setText("CENTER");
    jLabel1.setBounds(new Rectangle(45, 55, 55, 21));
    cbxCenter.setBounds(new Rectangle(100, 55, 149, 21));
    jLabel2.setText("ISSUE DATE FROM:");
    jLabel2.setBounds(new Rectangle(22, 150, 119, 21));
    txtIsuFrom.setText("");
    txtIsuFrom.setBounds(new Rectangle(147, 149, 101, 21));
    jLabel3.setText("TO");
    jLabel3.setBounds(new Rectangle(269, 150, 39, 21));
    txtIsuTo.setBounds(new Rectangle(328, 150, 101, 21));
    txtIsuTo.setText("");
    jLabel4.setText("BUYER:");
    jLabel4.setBounds(new Rectangle(266, 55, 55, 21));
    slkBuyer.setBounds(new Rectangle(322, 55, 149, 21));
    btnReport.setBounds(new Rectangle(553, 150, 87, 24));
    btnReport.setFont(new java.awt.Font("Dialog", 1, 11));
    btnReport.setText("REPORT");
    btnReport.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnReport_actionPerformed(e);
      }
    });
    rdoIncludeSCNULL.setBackground(new Color(204, 204, 225));
    rdoIncludeSCNULL.setSelected(true);
    rdoIncludeSCNULL.setText("NO");
    rdoIncludeSCNULL.setBounds(new Rectangle(580, 67, 101, 19));
    rdoXcldSCNULL.setBackground(new Color(204, 204, 225));
    rdoXcldSCNULL.setText("YES");
    rdoXcldSCNULL.setBounds(new Rectangle(491, 67, 79, 19));
    lblToExcludeSC.setText("EXCLUDE S/C NO IS SPACE:");
    lblToExcludeSC.setBounds(new Rectangle(487, 46, 170, 25));
    this.setBackground(new Color(204, 204, 225));
    cbxDep.setBounds(new Rectangle(129, 88, 191, 21));
    depLbl.setBounds(new Rectangle(43, 86, 89, 21));
    depLbl.setText("DEPARTMENT");
    depLbl.setRequestFocusEnabled(false);
    jLabel5.setBounds(new Rectangle(23, 125, 119, 21));
    jLabel5.setText("DEL DATE FROM:");
    jLabel6.setBounds(new Rectangle(270, 125, 39, 21));
    jLabel6.setText("TO");
    txtDelFrom.setBounds(new Rectangle(148, 124, 101, 21));
    txtDelFrom.setText("");
    txtDelTo.setText("");
    txtDelTo.setBounds(new Rectangle(328, 125, 101, 21));
    txtScTo.setBounds(new Rectangle(602, 89, 101, 21));
    txtScTo.setText("");
    jLabel7.setText("TO");
    jLabel7.setBounds(new Rectangle(544, 89, 39, 21));
    txtScFrom.setText("");
    txtScFrom.setBounds(new Rectangle(434, 89, 101, 21));
    jLabel8.setText("S/C# FROM:");
    jLabel8.setBounds(new Rectangle(335, 89, 119, 21));
    this.add(blueBkgWhiteCharLabel1, null);
    this.add(jLabel1, null);
    this.add(cbxCenter, null);
    this.add(jLabel4, null);
    this.add(slkBuyer, null);
    this.add(lblToExcludeSC, null);
    this.add(rdoXcldSCNULL, null);
    this.add(rdoIncludeSCNULL, null);
    this.add(jLabel2, null);
    this.add(txtIsuFrom, null);
    this.add(btnReport, null);
    this.add(depLbl, null);
    this.add(cbxDep, null);
    genDataBindObj();
    buttonGroup1.add(rdoXcldSCNULL);
    buttonGroup1.add(rdoIncludeSCNULL);
    this.add(jLabel5, null);
    this.add(txtDelFrom, null);
    this.add(txtDelTo, null);
    this.add(txtIsuTo, null);
    this.add(jLabel6, null);
    this.add(jLabel3, null);
    this.add(jLabel8, null);
    this.add(jLabel7, null);
    this.add(txtScTo, null);
    this.add(txtScFrom, null);
    cbxCenter.addItemListener(cbxListener);
  }
  protected void genDataBindObj(){
    try{
      doingDB2Gui=true;
      slkBuyer.init("P_BUYER",null,slkBuyer.TYPE_BUYER,true);
      dataBindComps.clear();
      dataBindComps.add(null);
      depCbxDBGUI_index=0;
      Object scVfy = exgui.verification.CellFormat.getOrdinaryField(20);
      dbTxtScFrom  =
          new exgui.DataBindTextWithChecker(txtScFrom , "P_SC_FM", null,
                                            20, (exgui.Object2String)scVfy,
                                            (exgui.ultratable.
                                             CellTxtEditorFormat)scVfy);
      dataBindComps.add(dbTxtScFrom);

      dbTxtScTo =
          new exgui.DataBindTextWithChecker(txtScTo, "P_SC_TO", null,
                                            20, (exgui.Object2String)scVfy,
                                            (exgui.ultratable.
                                             CellTxtEditorFormat)scVfy);
      dataBindComps.add(dbTxtScTo);


      Object dateVfy = exgui.verification.CellFormat.getDateStringFormaterAllowNull();
      dbTxtDateBgn =
          new exgui.DataBindTextWithChecker(txtIsuFrom, "DEL_DD_FM", null,
                                            10, (exgui.Object2String)dateVfy,
                                            (exgui.ultratable.
                                             CellTxtEditorFormat)dateVfy);
      dataBindComps.add(dbTxtDateBgn);

      dbTxtDateEnd =
          new exgui.DataBindTextWithChecker(txtIsuTo, "DEL_DD_EN", null,
                                            10, (exgui.Object2String)dateVfy,
                                            (exgui.ultratable.
                                             CellTxtEditorFormat)dateVfy);
      dataBindComps.add(dbTxtDateEnd);


      dbTxtDlvBgn =
          new exgui.DataBindTextWithChecker(txtDelFrom, "P_DEL_FM", null,
                                            10, (exgui.Object2String)dateVfy,
                                            (exgui.ultratable.
                                             CellTxtEditorFormat)dateVfy);
      dataBindComps.add(dbTxtDlvBgn);

      dbTxtDlvTo =
          new exgui.DataBindTextWithChecker(txtDelTo, "P_DEL_TO", null,
                                            10, (exgui.Object2String)dateVfy,
                                            (exgui.ultratable.
                                             CellTxtEditorFormat)dateVfy);
      dataBindComps.add(dbTxtDlvTo);




      dbCbxCenter =
           new exgui.DataBindJCombobox(
           cbxCenter, "P_CENTER",
          newtimes.preproduction.guis.tempProperties.tmpCenters,
           "CEN_NAME", "CEN_CODE",
           (String)util.PublicVariable.USER_RECORD.get("usr_cen_code"));




      dataBindComps.add(dbCbxCenter);
      reportName ="LST_CONF.rpt";

      doingDB2Gui=false;
      cbxListener.itemStateChanged(null);
    }catch(Exception exp){
      exp.printStackTrace();

    }
  }
  class cbxCenterItemChanged implements java.awt.event.ItemListener{
    public void itemStateChanged(ItemEvent e){
      if(doingDB2Gui)return;
      try{
        //and d.cen_code='001'
        //and e.dep_code='TPJ05'
        //find out the vector to add dbDeps.
        if (dbCbxCenter.getSelectedValue()==null) {
          //only the all dep is allow to add now.
           DbJcbxcbxDep =
              new exgui.DataBindJCombobox(
              cbxDep,"P_DEP" ,
              new Vector(),
              "DEP_NAME", "DEP_CODE",
              null,
              "ALL", "ALL");
          if(depCbxDBGUI_index == dataBindComps.size()) {
            dataBindComps.add(DbJcbxcbxDep);
          }else{
            //just replace after display & change;
            dataBindComps.set(depCbxDBGUI_index,DbJcbxcbxDep);
          }
        }else {
          slkBuyer.setSelectingCenter((String)dbCbxCenter.getSelectedValue());
          slkBuyer.init("P_BUYER",null,slkBuyer.TYPE_BUYER,true);
          //deps and "ALL"dep allow to add.
          Vector depVects=
              (Vector)tempProperties.tmpH_tbl_CenterDepMap.get(
              dbCbxCenter.getSelectedValue());
         DbJcbxcbxDep=null;
          if(depVects==null){
            DbJcbxcbxDep =
               new exgui.DataBindJCombobox(
               cbxDep,"P_DEP",
               new Vector(),
               "DEP_NAME", "DEP_CODE",
               null,
               "ALL", "ALL");
          }else if(depVects.size()>1){
             DbJcbxcbxDep =
                new exgui.DataBindJCombobox(
                cbxDep,"P_DEP",
                depVects,
                "DEP_NAME", "DEP_CODE",
                null,
                "ALL", "ALL");
            //guis.add(DbJcbxcbxDep);
          }else{
            DbJcbxcbxDep =
                new exgui.DataBindJCombobox(
                cbxDep, "P_DEP",
                depVects,
                "DEP_NAME", "DEP_CODE",
                null);
            //guis.add(DbJcbxcbxDep);
          }

          if (depCbxDBGUI_index == dataBindComps.size()) {
             dataBindComps.add(DbJcbxcbxDep);
          }else{
            dataBindComps.set(depCbxDBGUI_index,DbJcbxcbxDep);
          }
          //String centerCode=dbCbxCenter.getSelectedValue().toString();
          //newtimes.shipping_admin.ShippingAdmin_Const.CurrentWorkingCenterCode=centerCode;
        }
        String centerCode=(String)dbCbxCenter.getSelectedValue();
        if(centerCode==null || centerCode.trim().length()==0) centerCode=(String)util.PublicVariable.OPERATTING_CENTER;
        slkBuyer.setSelectingCenter(centerCode);
      }catch(Exception exp){
        exp.printStackTrace();
      }
    }
  }

  protected java.util.HashMap composeParameters(){
    java.util.HashMap hm=super.composeParameters();
    Object dateBgn=dbTxtDateBgn.getSelectedValue();
    Object dateEnd = dbTxtDateEnd.getSelectedValue();
    if (dateBgn == null) {
      hm.put("DEL_DD_FM", "DATE(2000,01,01)");
    }
    if (dateEnd == null) {
      hm.put("DEL_DD_EN", "DATE(2099,12,31)");
    }

    Object delBgn=dbTxtDlvBgn.getSelectedValue();
    Object delEnd = dbTxtDlvTo.getSelectedValue();
    if (delBgn == null) {
      hm.put("P_DEL_FM", "DATE(2000,01,01)");
    }
    if (delEnd == null) {
      hm.put("P_DEL_TO", "DATE(2099,12,31)");
    }

    Object objBuyer=slkBuyer.getSelectedValue();
    if(objBuyer==null){
      hm.put("P_BUYER","0");
    }else{
      hm.put("P_BUYER",objBuyer.toString());
    }
    if(rdoXcldSCNULL.isSelected()){
      hm.put("EXC_SC","Y");
    }else{
      hm.put("EXC_SC","N");
    }

    return hm;
  }

  void btnReport_actionPerformed(ActionEvent e) {
     super.JButtonQueryButtonAction(e);
  }
}
