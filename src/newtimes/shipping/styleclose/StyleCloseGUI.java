package newtimes.shipping.styleclose;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import exgui2.*;
import newtimes.preproduction.buyermakerselect.*;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class StyleCloseGUI extends JPanel {
  JLabel jLabel1112 = new JLabel();
  JLabel jLabel21 = new JLabel();
  JLabel jLabel19 = new JLabel();
  JLabel jLabel115 = new JLabel();
  JTextField txtLessThan = new JTextField();
  JLabel jLabel7 = new JLabel();
  JLabel jLabel22 = new JLabel();
  JLabel jLabel15 = new JLabel();
  JLabel jLabel9 = new JLabel();
  JLabel jLabel10 = new JLabel();
  JRadioButton rb_UnClose = new JRadioButton();
  JRadioButton rb_Closed = new JRadioButton();
  JRadioButton rb_All = new JRadioButton();
  ButtonGroup buttonGroup1 = new ButtonGroup();
  JButton butnExtract = new JButton();
  JLabel jLabel1 = new JLabel();
  GetBuyerMaker dlgBuyer = new GetBuyerMaker(1);
  GetBuyerMaker dlgMaker = new GetBuyerMaker(2);
  JComboBox cmboDep = new JComboBox();
  JComboBox cmboDiv = new JComboBox();
  JComboBox cmboCen = new JComboBox();
  JComboBox cmboSeason = new JComboBox();
  JLabel jLabel2 = new JLabel();
  JTextField txtYear = new JTextField();
  exgui.DataBindJCombobox dbJCBXDep = null;
  exgui.DataBindJCombobox dbJCBXCen = null;
  exgui.DataBindJCombobox dbJCBXDiv = null;
  exgui.DataBindJCombobox dbJCBXSeason = null;
  private String usrCenCodeDf = null;
  private StyleCloseListGUI listGUI = new StyleCloseListGUI();
  int checkNo = 1;
  String check = "N";
  SelectBuyerMaker slkProdBuyer = new SelectBuyerMaker();
  SelectBuyerMaker slkMaker = new SelectBuyerMaker();
  JLabel jLabel11 = new JLabel();
  JTextField txtSC_Bgn = new JTextField();
  JLabel jLabel121 = new JLabel();
  JTextField txtDelFrom = new JTextField();
  JLabel jLabel122 = new JLabel();
  JTextField txtDelTo = new JTextField();
   exgui.DataBindTextWithChecker dbTxtDateBgn,dbTxtDateEnd;
  public StyleCloseGUI() {
    try {
      usrCenCodeDf = util.PublicVariable.USER_RECORD.get("USR_CEN_CODE_DF").toString();
      jbInit();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }
  void jbInit() throws Exception {
    this.setMaxLength();
    jLabel10.setBounds(new Rectangle(19, 120, 155, 20));
    jLabel10.setText(" Year :");
    jLabel10.setHorizontalAlignment(SwingConstants.LEFT);
    jLabel10.setOpaque(true);
    jLabel10.setForeground(Color.white);
    jLabel10.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel10.setBackground(new Color(143, 143, 188));
    jLabel9.setBounds(new Rectangle(19, 144, 155, 20));
    jLabel9.setText(" Unship % Less Than :");
    jLabel9.setHorizontalAlignment(SwingConstants.LEFT);
    jLabel9.setOpaque(true);
    jLabel9.setForeground(new Color(10,36,106));
    jLabel9.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel9.setBackground(new Color(143, 143, 188));
    jLabel15.setBackground(new Color(143, 143, 188));
    jLabel15.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel15.setForeground(new Color(10,36,106));
    jLabel15.setOpaque(true);
    jLabel15.setHorizontalAlignment(SwingConstants.LEFT);
    jLabel15.setText(" Center :");
    jLabel15.setBounds(new Rectangle(19, 38, 155, 20));
    jLabel22.setBounds(new Rectangle(19, 64, 155, 20));
    jLabel22.setText(" Buyer :");
    jLabel22.setHorizontalAlignment(SwingConstants.LEFT);
    jLabel22.setOpaque(true);
    jLabel22.setForeground(new Color(10,36,106));
    jLabel22.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel22.setBackground(new Color(143, 143, 188));
    jLabel7.setBackground(new Color(143, 143, 188));
    jLabel7.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel7.setForeground(new Color(10,36,106));
    jLabel7.setOpaque(true);
    jLabel7.setHorizontalAlignment(SwingConstants.LEFT);
    jLabel7.setText(" Division :");
    jLabel7.setBounds(new Rectangle(19, 93, 155, 20));
    txtLessThan.setBounds(new Rectangle(167, 136, 209, 20));
    txtLessThan.setBounds(new Rectangle(176, 144, 209, 20));
    jLabel115.setBounds(new Rectangle(408, 117, 156, 20));
    jLabel115.setText(" STATUS :");
    jLabel115.setHorizontalAlignment(SwingConstants.LEFT);
    jLabel115.setOpaque(true);
    jLabel115.setForeground(Color.white);
    jLabel115.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel115.setBackground(new Color(143, 143, 188));
    jLabel19.setBounds(new Rectangle(408, 64, 155, 20));
    jLabel19.setText("MAKER :");
    jLabel19.setHorizontalAlignment(SwingConstants.LEFT);
    jLabel19.setOpaque(true);
    jLabel19.setForeground(Color.white);
    jLabel19.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel19.setBackground(new Color(143, 143, 188));
    jLabel21.setBackground(new Color(143, 143, 188));
    jLabel21.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel21.setForeground(Color.white);
    jLabel21.setOpaque(true);
    jLabel21.setHorizontalAlignment(SwingConstants.LEFT);
    jLabel21.setText(" Season :");
    jLabel21.setBounds(new Rectangle(408, 93, 155, 20));
    jLabel1112.setBackground(new Color(143, 143, 188));
    jLabel1112.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel1112.setForeground(new Color(10,36,106));
    jLabel1112.setOpaque(true);
    jLabel1112.setHorizontalAlignment(SwingConstants.LEFT);
    jLabel1112.setText(" Department :");
    jLabel1112.setBounds(new Rectangle(408, 38, 155, 20));
    this.setLayout(null);
    this.setSize(new Dimension(800, 208));
    this.setBackground(new Color(204, 204, 225));
    rb_UnClose.setBackground(Color.white);
    rb_UnClose.setFont(new java.awt.Font("Dialog", 1, 11));
    rb_UnClose.setForeground(Color.darkGray);
    rb_UnClose.setSelected(true);
    rb_UnClose.setText("Not Close");
    rb_UnClose.setBounds(new Rectangle(563, 117, 82, 20));
    rb_Closed.setBackground(Color.white);
    rb_Closed.setFont(new java.awt.Font("Dialog", 1, 11));
    rb_Closed.setForeground(Color.darkGray);
    rb_Closed.setText("Closed");
    rb_Closed.setBounds(new Rectangle(644, 117, 72, 20));
    rb_All.setBackground(Color.white);
    rb_All.setFont(new java.awt.Font("Dialog", 1, 11));
    rb_All.setForeground(Color.darkGray);
    rb_All.setText("All");
    rb_All.setBounds(new Rectangle(716, 117, 57, 20));
    butnExtract.setText("Extract");
    butnExtract.setForeground(Color.darkGray);
    butnExtract.setFont(new java.awt.Font("Dialog", 1, 13));
    butnExtract.setBounds(new Rectangle(704, 171, 80, 26));
    butnExtract.setBackground(Color.lightGray);
    jLabel1.setBounds(new Rectangle(117, 12, 566, 24));
    jLabel1.setHorizontalAlignment(SwingConstants.CENTER);
    jLabel1.setBorder(BorderFactory.createEtchedBorder());
    jLabel1.setForeground(new Color(10,36,106));
    jLabel1.setFont(new java.awt.Font("Dialog", 1, 13));
    jLabel1.setText("      ============  Style Close Maintain  ============      ");
    cmboDep.setDebugGraphicsOptions(0);
    cmboDep.setBounds(new Rectangle(565, 38, 209, 20));
    cmboDep.setBackground(Color.white);
    cmboDiv.setBounds(new Rectangle(176, 93, 209, 20));
    cmboDiv.setBackground(Color.white);
    cmboCen.setBounds(new Rectangle(176, 38, 209, 20));
    cmboCen.setBackground(Color.white);
    cmboSeason.setBounds(new Rectangle(565, 93, 209, 20));
    cmboSeason.setBackground(Color.white);
    jLabel2.setBounds(new Rectangle(237, 120, 55, 20));
    jLabel2.setText("( Year )");
    jLabel2.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel2.setForeground(new Color(143, 143, 188));
    txtYear.setBounds(new Rectangle(214, 240, 54, 20));
    txtYear.setBounds(new Rectangle(176, 120, 54, 20));
    //txtYear.setText(exgui2.Stuff.System_Year.toString());
    txtYear.setText("");
    rb_UnClose.addItemListener(new java.awt.event.ItemListener() {
      public void itemStateChanged(ItemEvent e) {
        rb_UnClose_itemStateChanged(e);
      }
    });
    rb_Closed.addItemListener(new java.awt.event.ItemListener() {
      public void itemStateChanged(ItemEvent e) {
        rb_Closed_itemStateChanged(e);
      }
    });
    rb_All.addItemListener(new java.awt.event.ItemListener() {
      public void itemStateChanged(ItemEvent e) {
        rb_All_itemStateChanged(e);
      }
    });
    slkProdBuyer.setBounds(new Rectangle(175, 64, 210, 20));
    slkMaker.setBounds(new Rectangle(565, 65, 208, 19));
    jLabel11.setBackground(new Color(143, 143, 188));
    jLabel11.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel11.setForeground(Color.white);
    jLabel11.setOpaque(true);
    jLabel11.setHorizontalAlignment(SwingConstants.LEFT);
    jLabel11.setText(" S/C No. :");
    jLabel11.setBounds(new Rectangle(20, 170, 155, 20));
    txtSC_Bgn.setText("");
    txtSC_Bgn.setBounds(new Rectangle(176, 170, 209, 20));
    jLabel121.setBounds(new Rectangle(408, 142, 81, 20));
    jLabel121.setText("DEL. FROM:");
    jLabel121.setHorizontalAlignment(SwingConstants.LEFT);
    jLabel121.setOpaque(true);
    jLabel121.setForeground(new Color(10,36,106));
    jLabel121.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel121.setBackground(new Color(143, 143, 188));
    txtDelFrom.setText("");
    txtDelFrom.setBounds(new Rectangle(488, 142, 85, 20));
    jLabel122.setBackground(new Color(143, 143, 188));
    jLabel122.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel122.setForeground(new Color(10,36,106));
    jLabel122.setOpaque(true);
    jLabel122.setHorizontalAlignment(SwingConstants.LEFT);
    jLabel122.setText("To");
    jLabel122.setBounds(new Rectangle(573, 142, 31, 20));
    txtDelTo.setBounds(new Rectangle(603, 142, 85, 20));
    txtDelTo.setText("");
    rdoSC_not_space.setBackground(new Color(204, 204, 225));
    rdoSC_not_space.setFont(new java.awt.Font("Dialog", 1, 11));
    rdoSC_not_space.setSelected(true);
    rdoSC_not_space.setText("S/C NOT SPACE");
    rdoSC_not_space.setBounds(new Rectangle(399, 174, 122, 21));
    rdoSC_Space.setBounds(new Rectangle(524, 174, 99, 21));
    rdoSC_Space.setText("S/C SPACE");
    rdoSC_Space.setFont(new java.awt.Font("Dialog", 1, 11));
    rdoSC_Space.setSelected(true);
    rdoSC_Space.setBackground(new Color(204, 204, 225));
    rdoSC_ALL.setBackground(new Color(204, 204, 225));
    rdoSC_ALL.setFont(new java.awt.Font("Dialog", 1, 11));
    rdoSC_ALL.setSelected(true);
    rdoSC_ALL.setText("ALL");
    rdoSC_ALL.setBounds(new Rectangle(624, 174, 73, 21));
    this.add(jLabel1, null);
    buttonGroup1.add(rb_UnClose);
    buttonGroup1.add(rb_Closed);
    buttonGroup1.add(rb_All);
    this.add(jLabel15, null);
    this.add(cmboCen, null);
    this.add(jLabel1112, null);
    this.add(cmboDep, null);
    this.add(jLabel22, null);
    this.add(slkProdBuyer, null);
    this.add(jLabel19, null);
    this.add(slkMaker, null);
    this.add(jLabel7, null);
    this.add(cmboDiv, null);
    this.add(jLabel21, null);
    this.add(cmboSeason, null);
    this.add(jLabel10, null);
    this.add(txtYear, null);
    this.add(jLabel2, null);
    this.add(jLabel9, null);
    this.add(txtLessThan, null);
    this.add(jLabel11, null);
    this.add(txtSC_Bgn, null);
    this.add(jLabel115, null);
    this.add(rb_All, null);
    this.add(jLabel121, null);
    this.add(txtDelFrom, null);
    this.add(jLabel122, null);
    this.add(txtDelTo, null);
    this.add(rdoSC_not_space, null);
    this.setCmboData();
    slkProdBuyer.init("",null,slkProdBuyer.TYPE_BUYER,true);
    slkMaker.init("",null,slkProdBuyer.TYPE_MAKER,true);
    buttonGroup2.add(rdoSC_not_space);
    buttonGroup2.add(rdoSC_Space);
    this.add(rdoSC_Space, null);
    this.add(rdoSC_ALL, null);
    this.add(butnExtract, null);
    buttonGroup2.add(rdoSC_ALL);
    this.add(rb_UnClose, null);
    this.add(rb_Closed, null);
  }

  void setCmboData() {
    java.util.Vector vDataCen = null;
    java.util.Vector vDataSeason = null;
    java.util.Vector vDataDiv = null;
    try {
      String iniCenterCode=(String)util.PublicVariable.USER_RECORD.get("usr_cen_code");

      vDataCen = //exgui2.CONST.BASIC_BASE_EJB.getCenterAll("CEN_CODE,CEN_NAME", "CEN_NAME");
        exgui2.CONST.BASIC_MAIN_EJB.getDatas(
          util.PublicVariable.USER_RECORD,
          "select * from center where cen_code='"+iniCenterCode+"'",1,1);
      database.datatype.Record recCen = (database.datatype.Record) vDataCen.get(0);
      dbJCBXCen = new exgui.DataBindJCombobox(
          cmboCen, vDataCen, "CEN_NAME", "CEN_CODE", recCen.get("CEN_CODE"));

      java.util.Vector vDataDep = exgui2.CONST.BASIC_BASE_EJB.getDepByCenterCode(
          dbJCBXCen.getSelectedValue().toString(),"CEN_NAME,DEP_NAME");

      vDataSeason = exgui2.CONST.BASIC_MAIN_EJB.getSeasonAll("SEA_NAME", "SEA_NAME");
      database.datatype.Record recSeason = (database.datatype.Record) vDataSeason.get(0);
      dbJCBXSeason = new exgui.DataBindJCombobox(
          cmboSeason, vDataSeason, "SEA_NAME", "SEA_NAME", recSeason.get("SEA_NAME"),"","null");
      vDataDiv = exgui2.CONST.BASIC_MAIN_EJB.getDivisionAll("DIV_CODE,DIV_NAME", "DIV_NAME");
      database.datatype.Record recDiv = (database.datatype.Record) vDataDiv.get(0);
      dbJCBXDiv = new exgui.DataBindJCombobox(
          cmboDiv, vDataDiv, "DIV_NAME", "DIV_CODE", recDiv.get("DIV_CODE"),"","null");

      cmboSeason.setSelectedIndex(0);
      cmboDiv.setSelectedIndex(0);
      cmboCen.addItemListener(new java.awt.event.ItemListener() {
        public void itemStateChanged(ItemEvent e) {
          cmboCen_itemStateChanged(e);
        }
      });
      String whereClause="DEP_CEN_CODE = '"+iniCenterCode+"'";
       vDataDep = exgui2.CONST.BASIC_BASE_EJB.getDepartment("DEP_CODE,DEP_NAME", whereClause, "DEP_NAME");
      if (vDataDep.size() > 0) {
        database.datatype.Record recDep = (database.datatype.Record)vDataDep.get(0);
        dbJCBXDep = new exgui.DataBindJCombobox(
            cmboDep, vDataDep, "DEP_NAME", "DEP_CODE",
            util.PublicVariable.USER_RECORD.get("usr_dep_code"), "", "null");
      }

      cmboCen.setSelectedIndex(0);

      Object dateVfy = exgui.verification.CellFormat.getDateStringFormaterAllowNull();
       dbTxtDateBgn =
          new exgui.DataBindTextWithChecker(txtDelFrom, "P_DEL_FM", null,
                                            10, (exgui.Object2String)dateVfy,
                                            (exgui.ultratable.
                                             CellTxtEditorFormat)dateVfy);

      dbTxtDateEnd =
          new exgui.DataBindTextWithChecker(txtDelTo, "P_DEL_TO", null,
                                            10, (exgui.Object2String)dateVfy,
                                            (exgui.ultratable.
                                             CellTxtEditorFormat)dateVfy);

    } catch (Exception eDep) {
      eDep.printStackTrace();
      util.ExceptionLog.exp2File(eDep, "error at Department JComboBox.");
    }
  }

  void cmboCen_itemStateChanged(ItemEvent e) {
    try {
      if (!dbJCBXCen.getSelectedValue().equals("null")) {
        this.setDepItem("DEP_CEN_CODE = '"+dbJCBXCen.getSelectedValue()+"'");
      }
    } catch (Exception eItem) {
      eItem.printStackTrace();
      util.ExceptionLog.exp2File(eItem, "error at change department item.");
    }
  }

  void setDepItem(String whereClause) {
    java.util.Vector vDataDep = null;
    try {
      vDataDep = exgui2.CONST.BASIC_BASE_EJB.getDepartment("DEP_CODE,DEP_NAME", whereClause, "DEP_NAME");
      if (vDataDep.size() > 0) {
        database.datatype.Record recDep = (database.datatype.Record)vDataDep.get(0);
        dbJCBXDep = new exgui.DataBindJCombobox(
            cmboDep, vDataDep, "DEP_NAME", "DEP_CODE", recDep.get("DEP_CODE"), "", "null");
      } else {
        cmboDep.removeAllItems();
      }
    } catch (Exception eD) {
      eD.printStackTrace();
      util.ExceptionLog.exp2File(eD, "error at set Dep. items.\n"+"vector:"+vDataDep.toString());
    }
  }

  void getQueryDatas() {
    java.util.HashMap hm = new java.util.HashMap();
    try {
      setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
      hm.put("PROD_CEN_CODE", dbJCBXCen==null?"null":dbJCBXCen.getSelectedValue());
      hm.put("PROD_DEPTMENT", dbJCBXDep==null?"null":dbJCBXDep.getSelectedValue());
      hm.put("PROD_BUYER", slkProdBuyer.getSelectedValue());//popBuyer.getSelectedBuyerValue());
      hm.put("PROD_MAKER", slkMaker.getSelectedValue());//popMaker.getSelectedMakerValue());
      hm.put("PROD_BUYER_DIVISION", dbJCBXDiv==null?"null":dbJCBXDiv.getSelectedValue());
      hm.put("PROD_SEASON", dbJCBXSeason==null?"null":dbJCBXSeason.getSelectedValue());
      hm.put("PROD_YEAR", txtYear.getText().trim().equals("")?"null":txtYear.getText().trim());
      //hm.put("PROD_RANGE", txtRange.getText().trim().equals("")?"null":txtRange.getText().trim());
      hm.put("ratio", txtLessThan.getText().trim().equals("")?"null":txtLessThan.getText().trim());
      hm.put("close", this.check);
      hm.put("FINAL_Del_FROM",dbTxtDateBgn.getSelectedValue());
      java.util.Date endDate=(java.util.Date)dbTxtDateEnd.getSelectedValue();
      if(endDate!=null){
        java.sql.Date orgDate=new java.sql.Date(endDate.getTime());
        endDate=
            util.MiscFunc.toDate235959(
               util.MiscFunc.getYear(orgDate),
               util.MiscFunc.getMonth(orgDate),
               util.MiscFunc.getDay(orgDate));
      }
      hm.put("FINAL_Del_TO",endDate);
      if(txtSC_Bgn.getText().trim().length()>0){
        hm.put("PROD_SC_NO",txtSC_Bgn.getText().trim().toUpperCase());
        rdoSC_not_space.setSelected(true);
      }
      if(rdoSC_not_space.isSelected()){
        hm.put("is_sc_null"," and prod_sc_no is not null ");
      }
      if(rdoSC_Space.isSelected() ){
        hm.put("is_sc_null"," and prod_sc_no is null ");
      }
      if(rdoSC_ALL.isSelected()){
        hm.put("is_sc_null"," ");
      }

      util.ApplicationProperites.setProperties("getData", hm);
    } catch (Exception eGet) {
      eGet.printStackTrace();
      util.ExceptionLog.exp2File(eGet, "error at get fields data.\n"+
                                 "hm:"+hm.toString());
    } finally {
      setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
    }
  }

  void rb_UnClose_itemStateChanged(ItemEvent e) {
    if (rb_UnClose.isSelected()) {
      System.out.println("unclose");
      this.checkNo = 1;
      this.check = "N";
    }
  }

  void rb_Closed_itemStateChanged(ItemEvent e) {
    if (rb_Closed.isSelected()) {
      System.out.println("close");
      this.checkNo = 0;
      this.check = "Y";
    }
  }

  void rb_All_itemStateChanged(ItemEvent e) {
    if (rb_All.isSelected()) {
      System.out.println("all");
      this.checkNo = 3;
      this.check = null;
    }
  }

  void setMaxLength(){
    exgui.DataBindText tx = null;
    tx = new exgui.DataBindText(txtYear,null,"",4);
  }
  ButtonGroup buttonGroup2 = new ButtonGroup();
  JRadioButton rdoSC_not_space = new JRadioButton();
  JRadioButton rdoSC_Space = new JRadioButton();
  JRadioButton rdoSC_ALL = new JRadioButton();
  /*
  void rb_onBoard_itemStateChanged(ItemEvent e) {
      if (rb_onBoard.isSelected()) {
        System.out.println("OnBoard");
        this.checkNo = 2;
        this.check = "B";
      }

  }
  */

}
