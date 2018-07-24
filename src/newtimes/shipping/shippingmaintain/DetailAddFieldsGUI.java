package newtimes.shipping.shippingmaintain;

import java.awt.*;
import javax.swing.*;
import newtimes.shipping.ScrollPaneGUI;
import java.awt.event.*;
import exgui2.*;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class DetailAddFieldsGUI extends JPanel {
  JTextField txtPo5 = new JTextField();
  JTextField txtSty6 = new JTextField();
  JTextField txtScNo1 = new JTextField();
  JTextField txtSty10 = new JTextField();
  JTextField txtSty5 = new JTextField();
  JTextField txtPo8 = new JTextField();
  JTextField txtPo7 = new JTextField();
  JTextField txtPo6 = new JTextField();
  JTextField txtSty1 = new JTextField();
  JTextField txtSty9 = new JTextField();
  JLabel jLabel117 = new JLabel();
  JTextField txtPo10 = new JTextField();
  JLabel jLabel9 = new JLabel();
  JTextField txtScNo3 = new JTextField();
  JTextField txtSty2 = new JTextField();
  JTextField txtSty14 = new JTextField();
  JLabel jLabel111 = new JLabel();
  JTextField txtPo12 = new JTextField();
  JTextField txtPo11 = new JTextField();
  JTextField txtPo4 = new JTextField();
  JTextField txtRange = new JTextField();
  JTextField txtScNo4 = new JTextField();
  JTextField txtPo1 = new JTextField();
  JPanel jPanel1 = new JPanel();
  JTextField txtSty4 = new JTextField();
  JTextField txtSty13 = new JTextField();
  JLabel jLabel8 = new JLabel();
  JLabel jLabel21 = new JLabel();
  JLabel jLabel2 = new JLabel();
  JTextField txtSty15 = new JTextField();
  JTextField txtSty3 = new JTextField();
  JPanel jPanel2 = new JPanel();
  JTextField txtSty8 = new JTextField();
  JTextField txtPo15 = new JTextField();
  JLabel jLabel19 = new JLabel();
  JLabel jLabel11 = new JLabel();
  JTextField txtPo9 = new JTextField();
  JTextField txtScNo2 = new JTextField();
  JLabel jLabel7 = new JLabel();
  JTextField txtSty7 = new JTextField();
  JTextField txtSty11 = new JTextField();
  JTextField txtPo13 = new JTextField();
  JTextField txtScNo5 = new JTextField();
  JLabel jLabel120 = new JLabel();
  JTextField txtSty12 = new JTextField();
  JTextField txtPo2 = new JTextField();
  JTextField txtPo14 = new JTextField();
  JLabel jLabel22 = new JLabel();
  JLabel jLabel10 = new JLabel();
  JTextField txtPo3 = new JTextField();
  JComboBox cmboCen = new JComboBox();
  JComboBox cmboDep = new JComboBox();
  JComboBox cmboDiv = new JComboBox();
  JComboBox cmboSeason = new JComboBox();
  JTextField txtYear = new JTextField();
  JTextField txtPo18 = new JTextField();
  JTextField txtPo16 = new JTextField();
  JTextField txtPo17 = new JTextField();
  JTextField txtSty18 = new JTextField();
  JTextField txtSty16 = new JTextField();
  JTextField txtSty17 = new JTextField();
  JButton butnExtract = new JButton();
  exgui.DataBindJCombobox dbJCBXDep = null;
  exgui.DataBindJCombobox dbJCBXCen = null;
  exgui.DataBindJCombobox dbJCBXDiv = null;
  exgui.DataBindJCombobox dbJCBXSeason = null;
  ButtonGroup buttonGroup1 = new ButtonGroup();
  GetBuyerMaker dlgBuyer = new GetBuyerMaker(1);
  GetBuyerMaker dlgMaker = new GetBuyerMaker(2);
  PopAndSelect2Text popBuyer = new PopAndSelect2Text(dlgBuyer, "BYMKR_SEQ", "BYMKR_BRIEF");
  PopAndSelect2Text popMaker = new PopAndSelect2Text(dlgMaker, "BYMKR_SEQ", "BYMKR_BRIEF");
  private String usrType = null;
  private String usrCenCodeDf = null;
  JTextField[] txtSC_NO = {txtScNo1,txtScNo2,txtScNo3,txtScNo4,txtScNo5};
  JTextField[] txtPO = {txtPo1,txtPo2,txtPo3,txtPo4,txtPo5,txtPo6,txtPo7,txtPo8,txtPo9,
                        txtPo10,txtPo11,txtPo12,txtPo13,txtPo14,txtPo15,txtPo16,txtPo17,txtPo18};
  JTextField[] txtStyle = {txtSty1,txtSty2,txtSty3,txtSty4,txtSty5,txtSty6,txtSty7,txtSty8,txtSty9,
                           txtSty10,txtSty11,txtSty12,txtSty13,txtSty14,txtSty15,txtSty16,txtSty17,txtSty18};
  JLabel jLabel110 = new JLabel();
  JRadioButton rb_Prod = new JRadioButton();
  JRadioButton rb_PO_Style = new JRadioButton();
  private boolean _isCenSelected = false;

  public DetailAddFieldsGUI() {
    try {
      usrType = util.PublicVariable.USER_RECORD.get("USR_TYPE").toString();
      usrCenCodeDf = util.PublicVariable.USER_RECORD.get("USR_CEN_CODE_DF").toString();
      jbInit();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }
  void jbInit() throws Exception {
    this.setMaxLength();
    jPanel1.setBorder(BorderFactory.createTitledBorder(" Condition of Production "));
    jPanel1.setBackground(new Color(204, 204, 225));
    jPanel1.setLayout(null);
    jPanel1.setBounds(new Rectangle(11, 63, 752, 179));
    txtPo1.setBounds(new Rectangle(165, 34, 96, 20));
    txtPo1.setForeground(new Color(10,36,106));
    txtPo1.setEditable(false);
    txtScNo4.setForeground(new Color(10,36,106));
    txtScNo4.setBounds(new Rectangle(513, 144, 115, 20));
    txtRange.setForeground(new Color(10,36,106));
    txtRange.setBounds(new Rectangle(535, 115, 209, 20));
    txtPo4.setBounds(new Rectangle(456, 34, 96, 20));
    txtPo4.setForeground(new Color(10,36,106));
    txtPo4.setEditable(false);
    txtPo11.setBounds(new Rectangle(553, 56, 96, 20));
    txtPo11.setForeground(new Color(10,36,106));
    txtPo11.setEditable(false);
    txtPo12.setForeground(new Color(10,36,106));
    txtPo12.setEditable(false);
    txtPo12.setBounds(new Rectangle(650, 56, 96, 20));
    jLabel111.setBackground(new Color(143, 143, 188));
    jLabel111.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel111.setForeground(new Color(10,36,106));
    jLabel111.setOpaque(true);
    jLabel111.setHorizontalAlignment(SwingConstants.LEFT);
    jLabel111.setText(" Department :");
    jLabel111.setBounds(new Rectangle(378, 29, 155, 20));
    txtSty14.setForeground(new Color(10,36,106));
    txtSty14.setEditable(false);
    txtSty14.setBounds(new Rectangle(262, 154, 96, 20));
    txtSty2.setBounds(new Rectangle(262, 110, 96, 20));
    txtSty2.setForeground(new Color(10,36,106));
    txtSty2.setEditable(false);
    txtScNo3.setBounds(new Rectangle(398, 144, 115, 20));
    txtScNo3.setForeground(new Color(10,36,106));
    jLabel9.setBackground(new Color(143, 143, 188));
    jLabel9.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel9.setForeground(new Color(10,36,106));
    jLabel9.setOpaque(true);
    jLabel9.setHorizontalAlignment(SwingConstants.LEFT);
    jLabel9.setText(" SC No. :");
    jLabel9.setBounds(new Rectangle(9, 144, 155, 20));
    txtPo10.setForeground(new Color(10,36,106));
    txtPo10.setEditable(false);
    txtPo10.setBounds(new Rectangle(456, 56, 96, 20));
    jLabel117.setBackground(new Color(143, 143, 188));
    jLabel117.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel117.setForeground(new Color(10,36,106));
    jLabel117.setOpaque(true);
    jLabel117.setHorizontalAlignment(SwingConstants.LEFT);
    jLabel117.setText(" PO :");
    jLabel117.setBounds(new Rectangle(8, 34, 155, 63));
    txtSty9.setForeground(new Color(10,36,106));
    txtSty9.setDoubleBuffered(false);
    txtSty9.setEditable(false);
    txtSty9.setBounds(new Rectangle(359, 132, 96, 20));
    txtSty1.setForeground(new Color(10,36,106));
    txtSty1.setEditable(false);
    txtSty1.setBounds(new Rectangle(165, 110, 96, 20));
    txtPo6.setBounds(new Rectangle(650, 34, 96, 20));
    txtPo6.setForeground(new Color(10,36,106));
    txtPo6.setEditable(false);
    txtPo7.setForeground(new Color(10,36,106));
    txtPo7.setEditable(false);
    txtPo7.setBounds(new Rectangle(165, 56, 96, 20));
    txtPo8.setBounds(new Rectangle(262, 56, 96, 20));
    txtPo8.setForeground(new Color(10,36,106));
    txtPo8.setEditable(false);
    txtSty5.setBounds(new Rectangle(553, 110, 96, 20));
    txtSty5.setForeground(new Color(10,36,106));
    txtSty5.setEditable(false);
    txtSty10.setBounds(new Rectangle(456, 132, 96, 20));
    txtSty10.setForeground(new Color(10,36,106));
    txtSty10.setEditable(false);
    txtScNo1.setForeground(new Color(10,36,106));
    txtScNo1.setBounds(new Rectangle(166, 144, 115, 20));
    txtSty6.setForeground(new Color(10,36,106));
    txtSty6.setEditable(false);
    txtSty6.setBounds(new Rectangle(650, 110, 96, 20));
    txtPo5.setForeground(new Color(10,36,106));
    txtPo5.setEditable(false);
    txtPo5.setBounds(new Rectangle(553, 34, 96, 20));
    this.setLayout(null);
    this.setSize(800,600);
    this.setBackground(new Color(204, 204, 225));
    txtSty4.setBounds(new Rectangle(456, 110, 96, 20));
    txtSty4.setForeground(new Color(10,36,106));
    txtSty4.setEditable(false);
    txtSty13.setForeground(new Color(10,36,106));
    txtSty13.setEditable(false);
    txtSty13.setBounds(new Rectangle(165, 154, 96, 20));
    jLabel8.setBackground(new Color(143, 143, 188));
    jLabel8.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel8.setForeground(new Color(10,36,106));
    jLabel8.setOpaque(true);
    jLabel8.setHorizontalAlignment(SwingConstants.LEFT);
    jLabel8.setText(" Division :");
    jLabel8.setBounds(new Rectangle(9, 87, 155, 20));
    jLabel21.setBounds(new Rectangle(378, 87, 155, 20));
    jLabel21.setText(" Season :");
    jLabel21.setHorizontalAlignment(SwingConstants.LEFT);
    jLabel21.setOpaque(true);
    jLabel21.setForeground(new Color(10,36,106));
    jLabel21.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel21.setBackground(new Color(143, 143, 188));
    jLabel2.setBounds(new Rectangle(227, 115, 55, 20));
    jLabel2.setText("( Year )");
    jLabel2.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel2.setForeground(new Color(143, 143, 188));
    txtSty15.setBounds(new Rectangle(359, 154, 96, 20));
    txtSty15.setForeground(new Color(10,36,106));
    txtSty15.setEditable(false);
    txtSty3.setForeground(new Color(10,36,106));
    txtSty3.setEditable(false);
    txtSty3.setBounds(new Rectangle(359, 110, 96, 20));
    jPanel2.setBounds(new Rectangle(11, 255, 752, 190));
    jPanel2.setLayout(null);
    jPanel2.setBackground(new Color(204, 204, 225));
    jPanel2.setBorder(BorderFactory.createTitledBorder(" Condition of "));
    txtSty8.setBounds(new Rectangle(262, 132, 96, 20));
    txtSty8.setForeground(new Color(10,36,106));
    txtSty8.setEditable(false);
    txtPo15.setForeground(new Color(10,36,106));
    txtPo15.setEditable(false);
    txtPo15.setBounds(new Rectangle(359, 78, 96, 20));
    jLabel19.setBackground(new Color(143, 143, 188));
    jLabel19.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel19.setForeground(new Color(10,36,106));
    jLabel19.setOpaque(true);
    jLabel19.setHorizontalAlignment(SwingConstants.LEFT);
    jLabel19.setText(" Center :");
    jLabel19.setVerticalAlignment(SwingConstants.CENTER);
    jLabel19.setBounds(new Rectangle(9, 29, 155, 20));
    jLabel11.setBounds(new Rectangle(8, 110, 155, 63));
    jLabel11.setText(" Style :");
    jLabel11.setHorizontalAlignment(SwingConstants.LEFT);
    jLabel11.setOpaque(true);
    jLabel11.setForeground(Color.white);
    jLabel11.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel11.setBackground(new Color(143, 143, 188));
    txtPo9.setForeground(new Color(10,36,106));
    txtPo9.setEditable(false);
    txtPo9.setBounds(new Rectangle(359, 56, 96, 20));
    txtScNo2.setForeground(new Color(10,36,106));
    txtScNo2.setBounds(new Rectangle(282, 144, 115, 20));
    jLabel7.setBounds(new Rectangle(9, 58, 155, 20));
    jLabel7.setText(" FTY :");
    jLabel7.setHorizontalAlignment(SwingConstants.LEFT);
    jLabel7.setOpaque(true);
    jLabel7.setForeground(Color.white);
    jLabel7.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel7.setBackground(new Color(143, 143, 188));
    txtSty7.setForeground(new Color(10,36,106));
    txtSty7.setEditable(false);
    txtSty7.setBounds(new Rectangle(165, 132, 96, 20));
    txtSty11.setBounds(new Rectangle(553, 132, 96, 20));
    txtSty11.setForeground(new Color(10,36,106));
    txtSty11.setEditable(false);
    txtPo13.setBounds(new Rectangle(165, 78, 96, 20));
    txtPo13.setForeground(new Color(10,36,106));
    txtPo13.setEditable(false);
    txtScNo5.setForeground(new Color(10,36,106));
    txtScNo5.setBounds(new Rectangle(629, 144, 115, 20));
    jLabel120.setBounds(new Rectangle(378, 115, 155, 20));
    jLabel120.setText(" Range :");
    jLabel120.setHorizontalAlignment(SwingConstants.LEFT);
    jLabel120.setOpaque(true);
    jLabel120.setForeground(Color.white);
    jLabel120.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel120.setBackground(new Color(143, 143, 188));
    txtSty12.setForeground(new Color(10,36,106));
    txtSty12.setEditable(false);
    txtSty12.setBounds(new Rectangle(650, 132, 96, 20));
    txtPo2.setBounds(new Rectangle(262, 34, 96, 20));
    txtPo2.setForeground(new Color(10,36,106));
    txtPo2.setEditable(false);
    txtPo14.setForeground(new Color(10,36,106));
    txtPo14.setEditable(false);
    txtPo14.setBounds(new Rectangle(262, 78, 96, 20));
    jLabel22.setBackground(new Color(143, 143, 188));
    jLabel22.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel22.setForeground(Color.white);
    jLabel22.setOpaque(true);
    jLabel22.setHorizontalAlignment(SwingConstants.LEFT);
    jLabel22.setText(" Buyer :");
    jLabel22.setBounds(new Rectangle(378, 58, 155, 20));
    jLabel10.setBackground(new Color(143, 143, 188));
    jLabel10.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel10.setForeground(Color.white);
    jLabel10.setOpaque(true);
    jLabel10.setHorizontalAlignment(SwingConstants.LEFT);
    jLabel10.setText(" Year :");
    jLabel10.setBounds(new Rectangle(9, 115, 155, 20));
    txtPo3.setBounds(new Rectangle(359, 34, 96, 20));
    txtPo3.setForeground(new Color(10,36,106));
    txtPo3.setEditable(false);
    cmboCen.setBounds(new Rectangle(166, 29, 209, 20));
    cmboDep.setDebugGraphicsOptions(0);
    cmboDep.setBounds(new Rectangle(535, 29, 209, 20));
    cmboDiv.setBounds(new Rectangle(166, 87, 209, 20));
    cmboSeason.setBounds(new Rectangle(535, 87, 209, 20));
    txtYear.setBounds(new Rectangle(214, 240, 54, 20));
    txtYear.setBounds(new Rectangle(166, 115, 54, 20));
    txtPo18.setBounds(new Rectangle(650, 78, 96, 20));
    txtPo18.setForeground(new Color(10,36,106));
    txtPo18.setEditable(false);
    txtPo16.setForeground(new Color(10,36,106));
    txtPo16.setEditable(false);
    txtPo16.setBounds(new Rectangle(456, 78, 96, 20));
    txtPo17.setBounds(new Rectangle(553, 78, 96, 20));
    txtPo17.setForeground(new Color(10,36,106));
    txtPo17.setEditable(false);
    txtSty18.setForeground(new Color(10,36,106));
    txtSty18.setEditable(false);
    txtSty18.setBounds(new Rectangle(650, 154, 96, 20));
    txtSty16.setBounds(new Rectangle(456, 154, 96, 20));
    txtSty16.setForeground(new Color(10,36,106));
    txtSty16.setEditable(false);
    txtSty17.setForeground(new Color(10,36,106));
    txtSty17.setEditable(false);
    txtSty17.setBounds(new Rectangle(553, 154, 96, 20));
    cmboCen.setBackground(Color.white);
    cmboDep.setBackground(Color.white);
    cmboDiv.setBackground(Color.white);
    cmboSeason.setBackground(Color.white);
    butnExtract.setText("Extract");
    butnExtract.setForeground(Color.darkGray);
    butnExtract.setFont(new java.awt.Font("Dialog", 1, 13));
    butnExtract.setBounds(new Rectangle(347, 450, 80, 25));
    butnExtract.setBackground(Color.lightGray);
    popBuyer.setBounds(new Rectangle(535, 58, 209, 20));
    popMaker.setBounds(new Rectangle(166, 58, 209, 20));
    jLabel110.setBounds(new Rectangle(11, 22, 155, 20));
    jLabel110.setVerticalAlignment(SwingConstants.CENTER);
    jLabel110.setText(" Condition of :");
    jLabel110.setHorizontalAlignment(SwingConstants.LEFT);
    jLabel110.setOpaque(true);
    jLabel110.setForeground(Color.white);
    jLabel110.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel110.setBackground(new Color(143, 143, 188));
    rb_Prod.setBackground(Color.white);
    rb_Prod.setFont(new java.awt.Font("Dialog", 1, 12));
    rb_Prod.setForeground(Color.darkGray);
    rb_Prod.setHorizontalAlignment(SwingConstants.LEADING);
    rb_Prod.setSelected(true);
    rb_Prod.setText("Production");
    rb_Prod.setBounds(new Rectangle(168, 22, 129, 20));
    rb_Prod.addItemListener(new java.awt.event.ItemListener() {
      public void itemStateChanged(ItemEvent e) {
        rb_Prod_itemStateChanged(e);
      }
    });
    rb_PO_Style.setBackground(Color.white);
    rb_PO_Style.setFont(new java.awt.Font("Dialog", 1, 12));
    rb_PO_Style.setForeground(Color.darkGray);
    rb_PO_Style.setText("PO and Style");
    rb_PO_Style.setBounds(new Rectangle(296, 22, 129, 20));
    rb_PO_Style.addItemListener(new java.awt.event.ItemListener() {
      public void itemStateChanged(ItemEvent e) {
        rb_PO_Style_itemStateChanged(e);
      }
    });
    jPanel1.add(jLabel19, null);
    jPanel1.add(jLabel7, null);
    jPanel1.add(jLabel8, null);
    jPanel1.add(jLabel10, null);
    jPanel1.add(jLabel9, null);
    jPanel1.add(jLabel120, null);
    jPanel1.add(txtRange, null);
    jPanel1.add(jLabel21, null);
    jPanel1.add(jLabel22, null);
    jPanel1.add(cmboDiv, null);
    jPanel1.add(cmboSeason, null);
    jPanel1.add(cmboCen, null);
    jPanel1.add(jLabel111, null);
    jPanel1.add(cmboDep, null);
    jPanel1.add(jLabel2, null);
    jPanel1.add(txtScNo5, null);
    jPanel1.add(txtYear, null);
    jPanel1.add(txtScNo1, null);
    jPanel1.add(txtScNo2, null);
    jPanel1.add(txtScNo3, null);
    jPanel1.add(txtScNo4, null);
    jPanel1.add(popMaker, null);
    jPanel1.add(popBuyer, null);
    jPanel2.add(jLabel117, null);
    jPanel2.add(jLabel11, null);
    jPanel2.add(txtPo7, null);
    jPanel2.add(txtPo8, null);
    jPanel2.add(txtPo9, null);
    jPanel2.add(txtPo10, null);
    jPanel2.add(txtPo11, null);
    jPanel2.add(txtPo12, null);
    jPanel2.add(txtPo18, null);
    jPanel2.add(txtPo17, null);
    jPanel2.add(txtPo16, null);
    jPanel2.add(txtPo15, null);
    jPanel2.add(txtPo14, null);
    jPanel2.add(txtPo13, null);
    jPanel2.add(txtSty1, null);
    jPanel2.add(txtSty2, null);
    jPanel2.add(txtSty3, null);
    jPanel2.add(txtSty4, null);
    jPanel2.add(txtSty5, null);
    jPanel2.add(txtSty6, null);
    jPanel2.add(txtSty12, null);
    jPanel2.add(txtSty18, null);
    jPanel2.add(txtSty17, null);
    jPanel2.add(txtSty11, null);
    jPanel2.add(txtSty10, null);
    jPanel2.add(txtSty16, null);
    jPanel2.add(txtSty15, null);
    jPanel2.add(txtSty9, null);
    jPanel2.add(txtSty8, null);
    jPanel2.add(txtSty14, null);
    jPanel2.add(txtSty13, null);
    jPanel2.add(txtSty7, null);
    jPanel2.add(txtPo1, null);
    jPanel2.add(txtPo2, null);
    jPanel2.add(txtPo3, null);
    jPanel2.add(txtPo4, null);
    jPanel2.add(txtPo5, null);
    jPanel2.add(txtPo6, null);
    this.add(butnExtract, null);
    this.add(jLabel110, null);
    this.add(rb_Prod, null);
    this.add(rb_PO_Style, null);
    this.add(jPanel1, null);
    this.add(jPanel2, null);
    this.setCmboData();
    txtYear.setText(exgui2.Stuff.System_Year.toString());
    buttonGroup1.add(rb_Prod);
    buttonGroup1.add(rb_PO_Style);
  }

  void setCmboData() {
    java.util.Vector vDataCen = null;
    java.util.Vector vDataSeason = null;
    java.util.Vector vDataDiv = null;
    try {
      vDataCen = exgui2.CONST.BASIC_BASE_EJB.getCenterAll("CEN_CODE,CEN_NAME", "CEN_NAME");
      database.datatype.Record recCen = (database.datatype.Record) vDataCen.get(0);
      dbJCBXCen = new exgui.DataBindJCombobox(
          cmboCen, vDataCen, "CEN_NAME", "CEN_CODE", recCen.get("CEN_CODE"),"","null");
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

      if (!usrType.equals("7")) {
        cmboCen.setSelectedItem(util.PublicVariable.USER_RECORD.get("CEN_NAME_DF").toString());
        cmboCen.setEnabled(false);
        this._isCenSelected = false;
        this.setDepItem("DEP_CEN_CODE = '"+usrCenCodeDf+"'");
      } else if (usrType.equals("7")) {
        this._isCenSelected = true;
        cmboCen.addItemListener(new java.awt.event.ItemListener() {
          public void itemStateChanged(ItemEvent e) {
            cmboCen_itemStateChanged(e);
          }
        });
        cmboCen.setSelectedIndex(0);
      }
    } catch (Exception eDep) {
      eDep.printStackTrace();
      util.ExceptionLog.exp2File(eDep, "error at Department JComboBox.");
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
        cmboDep.setSelectedIndex(0);
      } else {
        cmboDep.removeAllItems();
      }
    } catch (Exception eD) {
      eD.printStackTrace();
      util.ExceptionLog.exp2File(eD, "error at set Dep. items.\n"+"vector:"+vDataDep.toString());
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

  void setMaxLength() {
    exgui.DataBindText tx = null;
    tx = new exgui.DataBindText(txtYear, null, "", 4);
    tx = new exgui.DataBindText(txtRange, null, "", 40);
    for (int i = 0; i < txtSC_NO.length; i++)
      tx = new exgui.DataBindText(txtSC_NO[i], null, "", 20);
    for (int x = 0; x < 18; x++){
      tx = new exgui.DataBindText(txtPO[x], null, "", 20);
      tx = new exgui.DataBindText(txtStyle[x], null, "", 25);
    }
  }

  void rb_Prod_itemStateChanged(ItemEvent e) {
    if (rb_Prod.isSelected()) {
      for (int i = 0; i < 18; i++) {
        txtPO[i].setEditable(false);
        txtStyle[i].setEditable(false);
      }
      if (!this._isCenSelected)
        cmboCen.setEnabled(this._isCenSelected);
      else
        cmboCen.setEnabled(this._isCenSelected);
      cmboDep.setEnabled(true);
      popBuyer.setEditable(true);
      popMaker.setEditable(true);
      cmboDiv.setEnabled(true);
      cmboSeason.setEnabled(true);
      txtYear.setEditable(true);
      txtRange.setEditable(true);
      for (int x = 0; x < 5; x++)
        txtSC_NO[x].setEditable(true);
    }
  }

  void rb_PO_Style_itemStateChanged(ItemEvent e) {
    if (rb_PO_Style.isSelected()) {
      for (int i = 0; i < 18; i++) {
        txtPO[i].setEditable(true);
        txtStyle[i].setEditable(true);
      }
      cmboCen.setEnabled(false);
      cmboDep.setEnabled(false);
      popBuyer.setEditable(false);
      popMaker.setEditable(false);
      cmboDiv.setEnabled(false);
      cmboSeason.setEnabled(false);
      txtYear.setEditable(false);
      txtRange.setEditable(false);
      for (int x = 0; x < 5; x++)
        txtSC_NO[x].setEditable(false);
    }
  }

  boolean checkFieldsData() {
    int po = 0;
    int style = 0;
    for (int y = 1; y <= 18; y++) {
      if (!txtPO[y - 1].getText().trim().equals(""))
        po++;
      if (!txtStyle[y - 1].getText().trim().equals(""))
        style++;
    }

    if (po == 0 && style == 0) {
      return false;
    } else {
      return true;
    }
  }
}
