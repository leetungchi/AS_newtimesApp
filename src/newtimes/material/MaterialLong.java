package newtimes.material;

import java.awt.*;
import javax.swing.*;
import java.util.HashMap;
import java.util.Vector;
import database.datatype.Record;
import util.PublicVariable;
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

public class MaterialLong extends JPanel implements CommonFunc{
  private Vector CenterList  = null;

  private Record CurrUser = PublicVariable.USER_RECORD;
  exgui.DataBindJCombobox dbJCBXCat = null;

  private final newtimes.material.CONST.MTR.EJB MTR_EJB = null;
  private final newtimes.material.CONST.COMMON COMMON = null;
  private final newtimes.material.CONST.CEN.EJB CEN_EJB = null;
  private final newtimes.material.CONST.MTR.APP.SEARCH MTR_SEARCH = null;
  private final newtimes.material.CONST.MTRDTL.APP.LIST MTRDTL_COND=null;
  private final java.util.HashMap conds =
      (java.util.HashMap)util.ApplicationProperites.getProperties(MTR_SEARCH.CONDITIONS);


  private JPanel jPanel1= new JPanel();
  private JLabel jLabel1 = new JLabel();
  private newtimes.material.CONST.MTR.APP.SEARCH MTR_COND=null;
  private newtimes.material.CONST.MTRHIST.APP.LIST MTRHIST_COND=null;
  private String DELETE_FLAG = newtimes.material.CONST.COMMON.DELETE_FLAG;

  private JLabel jTextField1 = new JLabel();
  private JLabel jTextField2 = new JLabel();
  private JLabel jTextField3 = new JLabel();
  private JLabel jTextField4 = new JLabel();
  private JLabel jTextField5 = new JLabel();
  private JLabel jTextField6 = new JLabel();
  private JLabel jTextField7 = new JLabel();
  private JLabel jTextField8 = new JLabel();
  private JLabel jTextField9 = new JLabel();
  private JLabel jTextField10 = new JLabel();
  private JLabel jTextField11 = new JLabel();
  private JLabel jTextField12 = new JLabel();
  private JLabel jTextField13 = new JLabel();
  private JLabel jTextField14 = new JLabel();
  private JLabel jTextField15 = new JLabel();
  private JLabel jTextField16 = new JLabel();
  private JLabel jTextField17 = new JLabel();


  private JTextField tfMTR_NO = new JTextField();
  private JTextField tfDescription = new JTextField();
  private JTextField tfContent = new JTextField();
  private JTextField tfConst = new JTextField();
  private JTextField tfRemark = new JTextField();
  private JTextField tfFinish = new JTextField();
  private JTextField tfWidth = new JTextField();
  private JTextField tfC_Width = new JTextField();
  private JTextField tfWeight = new JTextField();
  private JTextField tfY_End = new JTextField();
  private JTextField tfY_Gauge = new JTextField();
  private JTextField tfY_Horizon = new JTextField();
  private JTextField tfY_Vertic = new JTextField();
  private JTextField tfWash = new JTextField();
  private JTextField tfPackage = new JTextField();

  private JComboBox cboCenter = new JComboBox();
  private JComboBox cboType = new JComboBox();
  private static boolean switchNewBtn = false;

  public Record currRecord = null;
  JComboBox cboMTR01 = new JComboBox();
  JComboBox cboMTR04 = new JComboBox();
  JButton jButton1 = new JButton();
  JCheckBox ckbRestore = new JCheckBox();
  JButton jButton2 = new JButton();

  JTextField[] tfGroup = new JTextField[17];
  JLabel jTextField18 = new JLabel();
  JTextField tfPatternName = new JTextField();
  JTextField tfTariffNo = new JTextField();
  JLabel jTextField19 = new JLabel();
  JLabel jTextField110 = new JLabel();
  JComboBox cboQuota = new JComboBox();
  BorderLayout borderLayout1 = new BorderLayout();
  JLabel jLabel2 = new JLabel();
  JTextField txtMillMtrNoList = new JTextField();
  JButton btnChkMillMtrNo = new JButton();

  public MaterialLong() {
    this(null,true);
  }
  public MaterialLong(Record rec,boolean canEdit) {
    this(rec, canEdit, false);
  }
  public MaterialLong(Record rec,boolean canEdit, boolean isRestore) {
    currRecord = rec;
    try {
      jbInit();
      initAllFields();
      editable(canEdit);
      restoreFunc(isRestore);
      UIAdjust(isRestore);
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }

  void jbInit() throws Exception {
    this.setMaxLength();
    CONST.pageFlag = true; //add by Chloe
    this.setLayout(borderLayout1);
    this.setBackground(new Color(204, 204, 225));
    this.setSize(new Dimension(773, 781));
    jPanel1.setLayout(null);
    jPanel1.setBackground(new Color(204, 204, 225));
    jPanel1.setAlignmentY((float) 0.5);

    jLabel1.setBounds(new Rectangle(103, 15, 566, 24));
    jLabel1.setHorizontalAlignment(SwingConstants.CENTER);
    jLabel1.setForeground(new Color(10,36,106));
    jLabel1.setFont(new java.awt.Font("Dialog", 1, 13));

    tfMTR_NO.setBounds(new Rectangle(547, 95, 209, 23));
    tfDescription.setBounds(new Rectangle(547, 168, 209, 23));
    tfDescription.addKeyListener(new MaterialLong_tfDescription_keyAdapter(this));
    tfContent.setBounds(new Rectangle(172, 168, 209, 23));
    tfConst.setText("");
    tfConst.setBounds(new Rectangle(547, 204, 209, 23));
    //tfConst.addKeyListener(new MaterialLong_tfConst_keyAdapter(this));
    tfRemark.setBounds(new Rectangle(172, 204, 209, 23));
    tfFinish.setBounds(new Rectangle(547, 241, 209, 23));
    //tfFinish.addKeyListener(new MaterialLong_tfFinish_keyAdapter(this));
    tfWidth.setBounds(new Rectangle(172, 241, 209, 23));
    //tfWidth.addKeyListener(new MaterialLong_tfWidth_keyAdapter(this));
    tfC_Width.setBounds(new Rectangle(547, 277, 209, 23));
    //tfC_Width.addKeyListener(new MaterialLong_tfC_Width_keyAdapter(this));
    tfWeight.setBounds(new Rectangle(172, 277, 209, 23));
    //tfWeight.addKeyListener(new MaterialLong_tfWeight_keyAdapter(this));
    tfY_End.setBounds(new Rectangle(172, 314, 209, 23));
    //tfY_End.addKeyListener(new MaterialLong_tfY_End_keyAdapter(this));
    tfY_Gauge.setBounds(new Rectangle(547, 314, 209, 23));
    //tfY_Gauge.addKeyListener(new MaterialLong_tfY_Gauge_keyAdapter(this));
    tfY_Horizon.setBounds(new Rectangle(172, 350, 209, 23));
    //tfY_Horizon.addKeyListener(new MaterialLong_tfY_Horizon_keyAdapter(this));
    tfY_Vertic.setBounds(new Rectangle(547, 350, 209, 23));
    //tfY_Vertic.addKeyListener(new MaterialLong_tfY_Vertic_keyAdapter(this));
    tfWash.setBounds(new Rectangle(172, 386, 209, 23));
    //tfWash.addKeyListener(new MaterialLong_tfWash_keyAdapter(this));
    tfPackage.setBounds(new Rectangle(547, 386, 209, 23));

    jTextField10.setBackground(new Color(143, 143, 188));
    jTextField10.setFont(new java.awt.Font("Dialog", 1, 12));
    jTextField10.setForeground(new Color(10,36,106));
    jTextField10.setBorder(null);
    jTextField10.setText(" Cutable Width :");
    jTextField10.setBounds(new Rectangle(391, 277, 155, 23));
    jTextField10.setOpaque(true);
    jTextField1.setBackground(new Color(143, 143, 188));
    jTextField1.setFont(new java.awt.Font("Dialog", 1, 12));
    jTextField1.setForeground(Color.white);
    jTextField1.setBorder(null);
    jTextField1.setText(" Center :");
    jTextField1.setBounds(new Rectangle(16, 95, 155, 23));
    jTextField1.setOpaque(true);
    jTextField2.setBackground(new Color(143, 143, 188));
    jTextField2.setFont(new java.awt.Font("Dialog", 1, 12));
    jTextField2.setForeground(Color.white);
    jTextField2.setBorder(null);
    jTextField2.setText(" MTR-NO. :");
    jTextField2.setBounds(new Rectangle(391, 95, 155, 23));
    jTextField2.setOpaque(true);
    jTextField3.setBackground(new Color(143, 143, 188));
    jTextField3.setFont(new java.awt.Font("Dialog", 1, 12));
    jTextField3.setForeground(new Color(10,36,106));
    jTextField3.setBorder(null);
    jTextField3.setText(" Type :");
    jTextField3.setBounds(new Rectangle(16, 132, 155, 23));
    jTextField3.setOpaque(true);
    jTextField4.setBackground(new Color(143, 143, 188));
    jTextField4.setFont(new java.awt.Font("Dialog", 1, 12));
    jTextField4.setForeground(Color.white);
    jTextField4.setBorder(null);
    jTextField4.setText(" Description :");
    jTextField4.setBounds(new Rectangle(391, 168, 155, 23));
    jTextField4.setOpaque(true);
    jTextField5.setBackground(new Color(143, 143, 188));
    jTextField5.setFont(new java.awt.Font("Dialog", 1, 12));
    jTextField5.setForeground(Color.white);
    jTextField5.setBorder(null);
    jTextField5.setText(" Content :");
    jTextField5.setBounds(new Rectangle(16, 168, 155, 23));
    jTextField5.setOpaque(true);
    jTextField6.setBackground(new Color(143, 143, 188));
    jTextField6.setFont(new java.awt.Font("Dialog", 1, 12));
    jTextField6.setForeground(new Color(10,36,106));
    jTextField6.setBorder(null);
    jTextField6.setText(" Construstion :");
    jTextField6.setBounds(new Rectangle(391, 204, 155, 23));
    jTextField6.setOpaque(true);
    jTextField7.setBackground(new Color(143, 143, 188));
    jTextField7.setFont(new java.awt.Font("Dialog", 1, 12));
    jTextField7.setForeground(new Color(10,36,106));
    jTextField7.setBorder(null);
    jTextField7.setText(" Head Remark :");
    jTextField7.setBounds(new Rectangle(16, 204, 155, 23));
    jTextField7.setOpaque(true);
    jTextField8.setBackground(new Color(143, 143, 188));
    jTextField8.setFont(new java.awt.Font("Dialog", 1, 12));
    jTextField8.setForeground(Color.white);
    jTextField8.setBorder(null);
    jTextField8.setText(" Finish :");
    jTextField8.setBounds(new Rectangle(391, 241, 155, 23));
    jTextField8.setOpaque(true);
    jTextField9.setBackground(new Color(143, 143, 188));
    jTextField9.setFont(new java.awt.Font("Dialog", 1, 12));
    jTextField9.setForeground(Color.white);
    jTextField9.setBorder(null);
    jTextField9.setText(" Full Width :");
    jTextField9.setBounds(new Rectangle(16, 241, 155, 23));
    jTextField9.setOpaque(true);
    jTextField11.setBackground(new Color(143, 143, 188));
    jTextField11.setFont(new java.awt.Font("Dialog", 1, 12));
    jTextField11.setForeground(new Color(10,36,106));
    jTextField11.setBorder(null);
    jTextField11.setText(" Weight :");
    jTextField11.setBounds(new Rectangle(16, 277, 155, 23));
    jTextField11.setOpaque(true);
    jTextField12.setBackground(new Color(143, 143, 188));
    jTextField12.setFont(new java.awt.Font("Dialog", 1, 12));
    jTextField12.setForeground(Color.white);
    jTextField12.setBorder(null);
    jTextField12.setText(" Yarn Ends :");
    jTextField12.setBounds(new Rectangle(16, 314, 155, 23));
    jTextField12.setOpaque(true);
    jTextField13.setBackground(new Color(143, 143, 188));
    jTextField13.setFont(new java.awt.Font("Dialog", 1, 12));
    jTextField13.setForeground(Color.white);
    jTextField13.setBorder(null);
    jTextField13.setText(" Yarn Gauge :");
    jTextField13.setBounds(new Rectangle(391, 314, 155, 23));
    jTextField13.setOpaque(true);
    jTextField14.setBackground(new Color(143, 143, 188));
    jTextField14.setFont(new java.awt.Font("Dialog", 1, 12));
    jTextField14.setForeground(new Color(10,36,106));
    jTextField14.setBorder(null);
    jTextField14.setText(" Yarn Horizon :");
    jTextField14.setBounds(new Rectangle(16, 350, 155, 23));
    jTextField14.setOpaque(true);
    jTextField15.setBackground(new Color(143, 143, 188));
    jTextField15.setFont(new java.awt.Font("Dialog", 1, 12));
    jTextField15.setForeground(new Color(10,36,106));
    jTextField15.setBorder(null);
    jTextField15.setText(" Yarn Vertical :");
    jTextField15.setBounds(new Rectangle(391, 350, 155, 23));
    jTextField15.setOpaque(true);
    jTextField16.setBackground(new Color(143, 143, 188));
    jTextField16.setFont(new java.awt.Font("Dialog", 1, 12));
    jTextField16.setForeground(Color.white);
    jTextField16.setBorder(null);
    jTextField16.setText(" Wash Method :");
    jTextField16.setBounds(new Rectangle(16, 386, 155, 23));
    jTextField16.setOpaque(true);
    jTextField17.setBackground(new Color(143, 143, 188));
    jTextField17.setFont(new java.awt.Font("Dialog", 1, 12));
    jTextField17.setForeground(Color.white);
    jTextField17.setBorder(null);
    jTextField17.setText(" Package :");
    jTextField17.setBounds(new Rectangle(391, 386, 155, 23));
    jTextField17.setOpaque(true);

    cboCenter.setBackground(Color.white);
    cboCenter.setEnabled(false);
    cboCenter.setEditable(false);
    cboCenter.setBounds(new Rectangle(172, 95, 209, 23));
    cboType.setBackground(Color.white);
    cboType.setBounds(new Rectangle(172, 132, 209, 23));

    cboMTR01.setBounds(new Rectangle(532, 114, 41, 21));
    cboMTR04.setBounds(new Rectangle(572, 114, 41, 21));
    jButton1.setBackground(Color.lightGray);
    jButton1.setBounds(new Rectangle(547, 119, 209, 20));
    jButton1.setFont(new java.awt.Font("Dialog", 0, 12));
    jButton1.setForeground(new Color(10,36,106));
    jButton1.setToolTipText("");
    jButton1.setHorizontalAlignment(SwingConstants.CENTER);
    jButton1.setHorizontalTextPosition(SwingConstants.CENTER);
    jButton1.setMargin(new Insets(2, 14, 2, 14));
    jButton1.setText("Get New MTR-NO");
    jButton1.setVerticalAlignment(SwingConstants.CENTER);
    jButton1.addActionListener(new MaterialLong_jButton1_actionAdapter(this));
    ckbRestore.setBackground(Color.cyan);
    ckbRestore.setFont(new java.awt.Font("Dialog", 1, 12));
    ckbRestore.setForeground(Color.white);
    ckbRestore.setText("");
    ckbRestore.setBounds(new Rectangle(50, 82, 24, 24));
    ckbRestore.setEnabled(false);
    jButton2.setBackground(Color.lightGray);
    jButton2.setBounds(new Rectangle(16, 59, 80, 23));
    jButton2.setFont(new java.awt.Font("Dialog", 1, 12));
    jButton2.setText("Restore");
    jButton2.addActionListener(new MaterialLong_jButton2_actionAdapter(this));
    jTextField18.setOpaque(true);
    jTextField18.setBounds(new Rectangle(16, 423, 155, 23));
    jTextField18.setText(" Pattern Name :");
    jTextField18.setBorder(null);
    jTextField18.setForeground(new Color(10,36,106));
    jTextField18.setFont(new java.awt.Font("Dialog", 1, 12));
    jTextField18.setBackground(new Color(143, 143, 188));
    tfPatternName.setBounds(new Rectangle(172, 423, 209, 23));
    //tfPatternName.addKeyListener(new MaterialLong_tfPatternName_keyAdapter(this));
    tfTariffNo.setBounds(new Rectangle(547, 423, 209, 23));
    //tfTariffNo.addKeyListener(new MaterialLong_tfTariffNo_keyAdapter(this));
    jTextField19.setOpaque(true);
    jTextField19.setBounds(new Rectangle(391, 423, 155, 23));
    jTextField19.setText(" Tariff No :");
    jTextField19.setBorder(null);
    jTextField19.setForeground(new Color(10,36,106));
    jTextField19.setFont(new java.awt.Font("Dialog", 1, 12));
    jTextField19.setBackground(new Color(143, 143, 188));
    jTextField110.setOpaque(true);
    jTextField110.setBounds(new Rectangle(16, 459, 155, 23));
    jTextField110.setText(" Quota :");
    jTextField110.setBorder(null);
    jTextField110.setForeground(Color.white);
    jTextField110.setFont(new java.awt.Font("Dialog", 1, 12));
    jTextField110.setBackground(new Color(143, 143, 188));
    cboQuota.setBounds(new Rectangle(172, 459, 209, 23));
    cboQuota.setBackground(Color.white);
    jLabel2.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel2.setForeground(new Color(220, 0, 0));
    jLabel2.setText("^");
    jLabel2.setBounds(new Rectangle(712, 224, 15, 20));
    txtMillMtrNoList.setToolTipText("Please Input Mill Mtr No,sperated by camma");
    txtMillMtrNoList.setMargin(new Insets(0, 0, 0, 0));
    txtMillMtrNoList.setText("");
    txtMillMtrNoList.setBounds(new Rectangle(530, 456, 228, 29));
    btnChkMillMtrNo.setBounds(new Rectangle(391, 457, 140, 27));
    btnChkMillMtrNo.setFont(new java.awt.Font("Dialog", 1, 11));
    btnChkMillMtrNo.setText("Check Mill MTR No.");
    btnChkMillMtrNo.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnChkMillMtrNo_actionPerformed(e);
      }
    });
    jPanel1.add(jLabel1, null);
    jPanel1.add(jTextField4, null);
    jPanel1.add(jTextField6, null);
    jPanel1.add(jTextField8, null);
    jPanel1.add(jTextField10, null);
    jPanel1.add(jTextField13, null);
    jPanel1.add(jTextField15, null);
    jPanel1.add(jTextField17, null);
    jPanel1.add(jTextField19, null);
    jPanel1.add(tfPackage, null);
    jPanel1.add(tfTariffNo, null);
    jPanel1.add(tfDescription, null);
    jPanel1.add(tfConst, null);
    jPanel1.add(tfFinish, null);
    jPanel1.add(tfC_Width, null);
    jPanel1.add(tfY_Gauge, null);
    jPanel1.add(tfY_Vertic, null);
    jPanel1.add(jTextField7, null);
    jPanel1.add(jTextField11, null);
    jPanel1.add(tfY_Horizon, null);
    jPanel1.add(jTextField9, null);
    jPanel1.add(tfRemark, null);
    jPanel1.add(jTextField12, null);
    jPanel1.add(jTextField18, null);
    jPanel1.add(tfWeight, null);
    jPanel1.add(jTextField3, null);
    jPanel1.add(tfWidth, null);
    jPanel1.add(tfContent, null);
    jPanel1.add(cboType, null);
    jPanel1.add(jTextField110, null);
    jPanel1.add(tfWash, null);
    jPanel1.add(tfY_End, null);
    jPanel1.add(tfPatternName, null);
    jPanel1.add(jTextField16, null);
    jPanel1.add(jTextField14, null);
    jPanel1.add(jTextField5, null);
    jPanel1.add(cboQuota, null);
    //jPanel1.add(jButton1, null);
    //jPanel1.add(jButton2, null);
    jPanel1.add(jTextField1, null);
    jPanel1.add(cboCenter, null);
    jPanel1.add(jTextField2, null);
    jPanel1.add(tfMTR_NO, null);
    jPanel1.add(jLabel2, null);
    jPanel1.add(btnChkMillMtrNo, null);
    jPanel1.add(txtMillMtrNoList, null);
    this.setPreferredSize(new java.awt.Dimension(300,500));
    this.add(jPanel1, BorderLayout.CENTER);
    initGroupField();

  }

  private void initGroupField(){
    tfGroup[0] = this.tfC_Width;
    tfGroup[1] = this.tfConst;
    tfGroup[2] = this.tfContent;
    tfGroup[3] = this.tfDescription;
    tfGroup[4] = this.tfFinish;
    tfGroup[5] = this.tfPackage;
    tfGroup[6] = this.tfRemark;
    tfGroup[7] = this.tfWash;
    tfGroup[8] = this.tfWeight;
    tfGroup[9] = this.tfWidth;
    tfGroup[10] = this.tfWidth;
    tfGroup[11] = this.tfY_End;
    tfGroup[12] = this.tfY_Gauge;
    tfGroup[13] = this.tfY_Horizon;
    tfGroup[14] = this.tfY_Vertic;
    tfGroup[15] = this.tfPatternName;
    tfGroup[16] = this.tfTariffNo;
  }

  void editable(boolean val){
    //tfMTR_NO.setEnabled(val);
    tfMTR_NO.setEnabled(false);
    tfContent.setEnabled(val);
    tfRemark.setEnabled(val);
    tfWidth.setEnabled(val);
    tfWeight.setEnabled(val);
    tfDescription.setEnabled(val);
    tfConst.setEnabled(val);
    tfFinish.setEnabled(val);
    tfC_Width.setEnabled(val);
    tfY_End.setEnabled(val);
    tfY_Gauge.setEnabled(val);
    tfY_Horizon.setEnabled(val);
    tfY_Vertic.setEnabled(val);
    tfWash.setEnabled(val);
    tfPackage.setEnabled(val);
    cboMTR01.setEnabled(val);
    cboMTR04.setEnabled(val);
    cboType.setEnabled(val);
    jButton1.setEnabled(val);
    tfPatternName.setEnabled(val);
    tfTariffNo.setEnabled(val);
    cboQuota.setEnabled(val);
    if(val==true){
      jPanel1.setBackground(new Color(204, 204, 225));
    }
    else{
      jPanel1.setBackground(new Color(212, 208, 200));
    }
  }
  void initAllFields(){
    try{
      initAllCombo();
      if (currRecord != null) {
        Object entry = currRecord.get(MTR_EJB.NO);
        tfMTR_NO.setText((entry==null)?(""):((String)entry));

        entry = currRecord.get(MTR_EJB.CONTENT);
        tfContent.setText((entry==null)?(""):((String)entry));

        entry = currRecord.get(MTR_EJB.GEN_REMARK);
        tfRemark.setText((entry==null)?(""):((String)entry));

        entry = currRecord.get(MTR_EJB.WIDTH);
        tfWidth.setText((entry==null)?(""):((String)entry));

        entry = currRecord.get(MTR_EJB.WEIGHT);
        tfWeight.setText((entry==null)?(""):((String)entry));

        entry = currRecord.get(MTR_EJB.DESC);
        tfDescription.setText((entry==null)?(""):((String)entry));

        entry = currRecord.get(MTR_EJB.CONSTRUCTION);
        tfConst.setText((entry==null)?(""):((String)entry));

        entry = currRecord.get(MTR_EJB.FINISH);
        tfFinish.setText((entry==null)?(""):((String)entry));

        entry = currRecord.get(MTR_EJB.CUTABLE_WIDTH);
        tfC_Width.setText((entry==null)?(""):((String)entry));

        entry = currRecord.get(MTR_EJB.YARN_ENDS);
        tfY_End.setText((entry==null)?(""):((String)entry));

        entry = currRecord.get(MTR_EJB.YARN_GAUGE);
        tfY_Gauge.setText((entry==null)?(""):((String)entry));

        entry = currRecord.get(MTR_EJB.YARN_HORIZON);
        tfY_Horizon.setText((entry==null)?(""):((String)entry));

        entry = currRecord.get(MTR_EJB.YARN_VERTIC);
        tfY_Vertic.setText((entry==null)?(""):((String)entry));

        entry = currRecord.get(MTR_EJB.WASH_METHOD);
        tfWash.setText((entry==null)?(""):((String)entry));

        entry = currRecord.get(MTR_EJB.PACKAGE);
        tfPackage.setText((entry==null)?(""):((String)entry));

        entry = currRecord.get(MTR_EJB.TYPE);
        cboType.setSelectedItem((entry==null)?(""):((String)entry));

        entry = currRecord.get(MTR_EJB.PATTERN_NAME);
        tfPatternName.setText((entry==null)?(""):((String)entry));

        entry = currRecord.get(MTR_EJB.TARIFF_NO);
        tfTariffNo.setText((entry==null)?(""):((String)entry));

        entry = currRecord.get(MTR_EJB.QTA);
        cboQuota.setSelectedItem((entry==null)?(""):((String)entry));

      }
    }
    catch(Exception e){
      e.printStackTrace();
    }
  }
  //Modify by Chloe 2003.09.25
  void restoreFunc(boolean isRestore){
    if(isRestore){
      try{
        if( ((String) currRecord.get(COMMON.DELETE_FLAG)).trim().equals("1") ){
          jButton2.setEnabled(false);
//          ckbRestore.setSelected(true);
        }
        else{
//          ckbRestore.setSelected(false);
          jButton2.setEnabled(true);
        }
//        jPanel1.add(ckbRestore, null);
        jPanel1.add(jButton2, null);
      }
      catch(Exception e){
        e.printStackTrace();
      }
    }
  }

  void initAllCombo(){
    try{
      cboMTR01.addItem("J");
      cboMTR01.addItem("H");
      cboMTR01.addItem("C");

      cboMTR04.addItem("W");
      cboMTR04.addItem("K");
      cboMTR04.addItem("S");
      cboMTR04.addItem("F");

      cboType.addItem("");
      cboType.addItem("fabric");
      cboType.addItem("yarn");
      cboType.addItem("accessories");
      cboType.addItem("home furnished");
      cboType.addItem("ready made product");
      CenterList = exgui2.CONST.Material_EJB.getAllCenter();
      Util.setComboValues(cboCenter, CenterList, CEN_EJB.NAME, false);

      String cenCode = ((String)conds.get(MTR_SEARCH.CEN_CODE)).trim();;
      for(int i=0; i<CenterList.size(); i++){
        Record rec = (Record)CenterList.get(i);
        if(cenCode.equals((String)rec.get(CEN_EJB.CODE))){
          cboCenter.setSelectedItem(rec.get(CEN_EJB.NAME));
          break;
        }
      }

      java.util.Vector vDataCat = null;
      vDataCat = exgui2.CONST.BASIC_MAIN_EJB.getQuotaAll("DISTINCT QTA_CAT","QTA_CAT");
      database.datatype.Record recCat = (database.datatype.Record)vDataCat.get(0);
      dbJCBXCat = new exgui.DataBindJCombobox(cboQuota, vDataCat, "QTA_CAT",
                                              "QTA_CAT", recCat.get("QTA_CAT"),"",null);
      cboQuota.setSelectedIndex(0);
    }
    catch(Exception e){
      e.printStackTrace();
    }
  }

  private void HKReqirement(){
    try{
      String cenCode = ((String)conds.get(MTR_SEARCH.CEN_CODE)).trim();
      if(currRecord!=null){
        Object entry = currRecord.get(MTR_EJB.CEN_CODE);
        //tfMTR_NO.setBounds(new Rectangle(451, 113, 199, 20));
        tfMTR_NO.setEditable(false);
      }
      else{
        if(!cenCode.equals("002")){//Not HK's center code
//          jPanel1.add(cboMTR01, null);
//          jPanel1.add(cboMTR04, null);
          jPanel1.add(jButton1, null);
          tfMTR_NO.setEditable(false);
        }
        else{
          //tfMTR_NO.setBounds(new Rectangle(451, 113, 199, 20));
          tfMTR_NO.setEditable(true);
        }
      }
    }
    catch(Exception e){
      e.printStackTrace();
    }

  }

  private void UIAdjust(boolean isRestore){
    if(isRestore){
      jLabel1.setText("      ============  Deleted Material  ============      ");
      btnChkMillMtrNo.setVisible(false);
      txtMillMtrNoList.setVisible(false);
    }
    else{
      if (currRecord == null) {
        jLabel1.setText("      ============  Add New Material  ============      ");
        btnChkMillMtrNo.setVisible(true);
        txtMillMtrNoList.setVisible(true);
      }
      else {
        jLabel1.setText("      ============  Material  ============      ");
        btnChkMillMtrNo.setVisible(false);
        txtMillMtrNoList.setVisible(false);
      }
    }
    //HKReqirement();
  }

  private void SaveMtrRec(){
    try{
      String mtrNo = tfMTR_NO.getText().trim();
      String cenCode = null;
      String selCenName = (cboCenter.getSelectedItem()==null)?(""):(String)(cboCenter.getSelectedItem());
      util.MiscFunc.showProcessingMessage();
      for(int i=0; i<CenterList.size(); i++){
        Record cenRec = (Record)CenterList.get(i);
        if(selCenName.equals((String)cenRec.get(CEN_EJB.NAME))){
          cenCode = (String)cenRec.get(CEN_EJB.CODE);
          break;
        }
      }
      boolean isAddNew=false;
      if(cenCode!=null && !cenCode.equals("")){

        if(mtrNo.equals("")){
          // add mode
          isAddNew=true;
          //mtrNo=jButton1_actionPerformed(null);
        }

        Record rec = exgui2.CONST.Material_EJB.getBlankRecord();
        rec.set(MTR_EJB.NO, mtrNo);
        rec.set(MTR_EJB.CEN_CODE, cenCode);
        rec.set(MTR_EJB.TYPE,          this.cboType.getSelectedItem());
        rec.set(MTR_EJB.DESC,          this.tfDescription.getText().trim().toUpperCase());
        rec.set(MTR_EJB.CONTENT,       this.tfContent.getText().trim().toUpperCase());
        rec.set(MTR_EJB.CONSTRUCTION,  this.tfConst.getText().trim().toUpperCase());
        rec.set(MTR_EJB.WEIGHT,        this.tfWeight.getText().trim().toUpperCase());
        rec.set(MTR_EJB.WIDTH,         this.tfWidth.getText().trim().toUpperCase());
        rec.set(MTR_EJB.CUTABLE_WIDTH, this.tfC_Width.getText().trim().toUpperCase());
        rec.set(MTR_EJB.FINISH,        this.tfFinish.getText().trim().toUpperCase());
        rec.set(MTR_EJB.YARN_ENDS,     this.tfY_End.getText().trim().toUpperCase());
        rec.set(MTR_EJB.YARN_GAUGE,    this.tfY_Gauge.getText().trim().toUpperCase());
        rec.set(MTR_EJB.YARN_HORIZON,  this.tfY_Horizon.getText().trim().toUpperCase());
        rec.set(MTR_EJB.YARN_VERTIC,   this.tfY_Vertic.getText().trim().toUpperCase());
        rec.set(MTR_EJB.WASH_METHOD,   this.tfWash.getText().trim().toUpperCase());
        rec.set(MTR_EJB.PACKAGE,       this.tfPackage.getText().trim().toUpperCase());
        rec.set(MTR_EJB.GEN_REMARK,    this.tfRemark.getText().trim().toUpperCase());
        rec.set(MTR_EJB.PATTERN_NAME,  this.tfPatternName.getText().trim().toUpperCase());
        rec.set(MTR_EJB.TARIFF_NO,     this.tfTariffNo.getText().trim().toUpperCase());
        rec.set(MTR_EJB.QTA,           this.dbJCBXCat.getSelectedValue());

        if(isAddNew){
          rec.set(COMMON.CREATE_USER, CurrUser.get("USR_CODE"));
          rec.set(COMMON.DELETE_FLAG, "1");
          rec.set(COMMON.MODIFY_USER, CurrUser.get("USR_CODE"));

          Record rectmp= exgui2.CONST.Material_EJB.insertRecord(rec,
              (String)util.PublicVariable.USER_RECORD.get("CEN_PREFIX"),
              (String)util.PublicVariable.USER_RECORD.get("DEP_PREFIX"));
          util.MiscFunc.hideProcessingMessage();
          exgui.verification.VerifyLib.showPlanMsg(
           "Material Head Insert OK,MTR-NO. is:"+rectmp.get(0),
           "Insert OK");
           tfMTR_NO.setText((String)rectmp.get(0));
        }else{
          rec.set(COMMON.MODIFY_USER, CurrUser.get("USR_CODE"));
          exgui2.CONST.Material_EJB.updateRecord(rec);
          /*
          exgui.verification.VerifyLib.showPlanMsg(
           "Update OK","Update OK");
          */
        }
        HashMap hm = new HashMap();
        hm.put(MTR_SEARCH.MTR_NO, mtrNo);
        util.ApplicationProperites.setProperties(MTRDTL_COND.CONDITIONS, hm);
        /*
        mtrWarnDialog message =
              new mtrWarnDialog(null, "Save", "Record(s) Saved!", true);
        */
        this.switchNewBtn = true;
      }
      else{
        exgui2.InfoMessage.warningMessage(
            new JFrame(), "Insert Failed! Please Check or Generate MTR-NO.");
      }
    }
    catch(Exception e){
      e.printStackTrace();
      mtrWarnDialog message =
              new mtrWarnDialog(null, "Error", "Exception occured!", true);
    }finally{
      util.MiscFunc.hideProcessingMessage();
    }
  }

//Implementation of CommonFunc interface
  public void RecSave(){
    java.awt.Cursor tCur = this.getParent().getCursor();
    this.getParent().setCursor(new java.awt.Cursor(java.awt.Cursor.WAIT_CURSOR));
    SaveMtrRec();
    try {
      java.util.HashMap mtrDtlConds = new java.util.HashMap();
      mtrDtlConds.put(MTR_COND.MTR_NO, tfMTR_NO.getText());
      mtrDtlConds.put(DELETE_FLAG, "1");
      util.ApplicationProperites.setProperties(MTRDTL_COND.CONDITIONS,
                                               mtrDtlConds);

      java.util.HashMap mtrHistConds = new java.util.HashMap();
      mtrHistConds.put(MTR_COND.MTR_NO, tfMTR_NO.getText());
      mtrHistConds.put(MTR_COND.CEN_CODE,
                       util.PublicVariable.USER_RECORD.get("USR_CEN_CODE_DF"));
      util.ApplicationProperites.setProperties(MTRHIST_COND.CONDITIONS,
                                               mtrHistConds);
    } catch(Exception e) {
      e.printStackTrace();
    }

    this.getParent().setCursor(tCur);
  }

  public void PrevStep(){
  }

  public void RecDelete(){
    try{
      java.awt.Cursor tCur = this.getParent().getCursor();
      this.getParent().setCursor(new java.awt.Cursor(java.awt.Cursor.WAIT_CURSOR));
      util.MiscFunc.showProcessingMessage();
      String mtrNo = tfMTR_NO.getText().trim();
      //if(exgui2.CONST.Material_EJB.isExisted(mtrNo)){
        Record rec = exgui2.CONST.Material_EJB.getBlankRecord();
        rec.set(MTR_EJB.NO, mtrNo);
        rec.set(COMMON.DELETE_FLAG, "0");
        rec.set(COMMON.MODIFY_USER, CurrUser.get("USR_CODE"));
        rec.set(COMMON.DELETE_USER, CurrUser.get("USR_CODE"));
        exgui2.CONST.Material_EJB.updateRecord(rec);
        /*
        mtrWarnDialog message =
              new mtrWarnDialog(null, "Delete", "Record deleted!", true);
         */
      //}
      this.getParent().setCursor(tCur);
    }catch(Exception e){
      util.ExceptionLog.exp2File(e,"exp while delete ");
      e.printStackTrace();
      exgui.verification.VerifyLib.showAlert("Delete Fail,Please Notify System Manager",
                                             "Delete Fail!!");
    }finally{
      util.MiscFunc.hideProcessingMessage();
    }
  }

  public void RecRestore(){
    try{
      String mtrNo = tfMTR_NO.getText().trim();
      util.MiscFunc.showProcessingMessage();
      if(mtrNo!=null && !mtrNo.equals("") ){
        Record rec = exgui2.CONST.Material_EJB.getBlankRecord();
        rec.set(MTR_EJB.NO, mtrNo);
        rec.set(COMMON.DELETE_FLAG, "1");
        rec.set(COMMON.MODIFY_USER, CurrUser.get("USR_CODE"));
        Record updateRec = exgui2.CONST.Material_EJB.updateRecord(rec);
        if (updateRec != null) {
          exgui2.InfoMessage.infoMessage(new JFrame(), "Restore Succeed.");
        } else {
          exgui2.InfoMessage.infoMessage(new JFrame(), "Restore Failed.");
        }
      }
    }
    catch(Exception e){
      e.printStackTrace();
    }finally{
      util.MiscFunc.hideProcessingMessage();
    }
  }
  public void RecCopy(){
    Integer Type = new Integer(cboType.getSelectedIndex());
    HashMap hm = new HashMap();
    for(int i=0; i<tfGroup.length; i++){
      String id = "tf"+i;
      String value = tfGroup[i].getText();
      hm.put(id, value);
    }
    hm.put("QTA",cboQuota.getSelectedItem());
    hm.put("Type",Type);
    util.ApplicationProperites.setProperties("copyMaterial", hm);
  }
  public void RecPaste(){
    try{
      Object entry = util.ApplicationProperites.getProperties("copyMaterial");
      if (entry != null) {
        HashMap hm = (HashMap) entry;
        Integer typeIndex = (Integer) hm.get("Type");
        cboType.setSelectedIndex(typeIndex.intValue());
        for(int i=0; i<tfGroup.length; i++){
          String id = "tf"+i;
          tfGroup[i].setText((String)hm.get(id));
        }
        cboQuota.setSelectedItem(hm.get("QTA"));
        this.validate();
      }
    }
    catch(Exception exp){
      exp.printStackTrace();
    }
  }
  //Modify by Chloe
  String jButton1_actionPerformed(ActionEvent e) {
    try{
      String se01 = (String) cboMTR01.getSelectedItem();
      String se04 = (String) cboMTR04.getSelectedItem();
      String mtrSEQ = exgui2.CONST.Material_EJB.getMTR_SEQ(se01 + se04);
      java.util.Date date1 = new java.util.Date(System.currentTimeMillis());
      java.text.DateFormat df = new java.text.SimpleDateFormat("yy");
      String currYear = df.format(date1).substring(1);
      String generatedMtrNo="M"+
                       util.PublicVariable.USER_RECORD.get("CEN_PREFIX")+
                       util.PublicVariable.USER_RECORD.get("DEP_PREFIX")+
                       currYear+
                       mtrSEQ;

      tfMTR_NO.setText(generatedMtrNo);
      /*
      if (mtrSEQ != null || !mtrSEQ.equals("")) {
        jButton1.setEnabled(false);
      }
      */
     return generatedMtrNo;

    }
    catch(Exception exp){
      util.ExceptionLog.exp2File(exp,"Error in generating MTR-NO");
      exp.printStackTrace();
      exgui.verification.VerifyLib.showAlert(
      "Error Occured While Generating MTR-NO\nPlease Contact System Manager",
      "Error in generating MTR-NO");
      return null;
    }
  }

  static boolean getSwitchNewBtn() {
    return switchNewBtn;
  }

  static void setSwitchNewBtn(boolean b) {
    switchNewBtn = b;
  }

  void jButton2_actionPerformed(ActionEvent e) {
    if(ckbRestore.isSelected()==false){
      RecRestore();
    }
  }

  void tfPatternName_keyTyped(KeyEvent e) {
    Util.CheckInputLength(e,tfPatternName.getText(),15);
  }

  void tfTariffNo_keyTyped(KeyEvent e) {
    Util.CheckInputLength(e,tfTariffNo.getText(),15);
  }

  void tfConst_keyTyped(KeyEvent e) {
    Util.CheckInputLength(e,tfConst.getText(),60);
  }

  void tfWeight_keyTyped(KeyEvent e) {
    Util.CheckInputLength(e,tfWeight.getText(),10);
  }

  void tfWidth_keyTyped(KeyEvent e) {
    Util.CheckInputLength(e,tfWidth.getText(),10);
  }

  void tfC_Width_keyTyped(KeyEvent e) {
    Util.CheckInputLength(e,tfC_Width.getText(),10);
  }

  void tfDescription_keyTyped(KeyEvent e) {
    Util.CheckInputLength(e,tfDescription.getText(),40);
  }

  void tfFinish_keyTyped(KeyEvent e) {
    Util.CheckInputLength(e,tfFinish.getText(),40);
  }

  void tfY_End_keyTyped(KeyEvent e) {
    Util.CheckInputLength(e,tfY_End.getText(),10);
  }

  void tfY_Gauge_keyTyped(KeyEvent e) {
    Util.CheckInputLength(e,tfY_Gauge.getText(),10);
  }

  void tfY_Horizon_keyTyped(KeyEvent e) {
    Util.CheckInputLength(e,tfY_Horizon.getText(),10);
  }

  void tfY_Vertic_keyTyped(KeyEvent e) {
    Util.CheckInputLength(e,tfY_Vertic.getText(),10);
  }

  void tfWash_keyTyped(KeyEvent e) {
    Util.CheckInputLength(e,tfWash.getText(),40);
  }

  void setMaxLength(){
    exgui.DataBindText tx = null;
    tx = new exgui.DataBindText(tfContent,null,"",60);
    tx = new exgui.DataBindText(tfRemark,null,"",200);
    tx = new exgui.DataBindText(tfPackage,null,"",200);
    tx = new exgui.DataBindText(tfPatternName,null,"",15);
    tx = new exgui.DataBindText(tfTariffNo,null,"",15);
    tx = new exgui.DataBindText(tfConst,null,"",60);
    tx = new exgui.DataBindText(tfWeight,null,"",10);
    tx = new exgui.DataBindText(tfWidth,null,"",10);
    tx = new exgui.DataBindText(tfC_Width,null,"",10);
    tx = new exgui.DataBindText(tfDescription,null,"",40);
    tx = new exgui.DataBindText(tfFinish,null,"",40);
    tx = new exgui.DataBindText(tfY_End,null,"",10);
    tx = new exgui.DataBindText(tfY_Gauge,null,"",10);
    tx = new exgui.DataBindText(tfY_Horizon,null,"",10);
    tx = new exgui.DataBindText(tfY_Vertic,null,"",10);
    tx = new exgui.DataBindText(tfWash,null,"",40);
  }
  void btnChkMillMtrNo_actionPerformed(ActionEvent e) {
        if(txtMillMtrNoList.getText().trim().length()==0)return;
        txtMillMtrNoList.setText(txtMillMtrNoList.getText().toUpperCase());
        DlgListMillMtr4Chk dlg2chkMillNo=new DlgListMillMtr4Chk(util.PublicVariable.APP_FRAME,
            "Mill\'s Mtr No Used",true,txtMillMtrNoList.getText().toUpperCase());
        dlg2chkMillNo.setSize(470,320);
        exgui.UIHelper.setToScreenCenter(dlg2chkMillNo);
        dlg2chkMillNo.show();
  }
}

class MaterialLong_jButton1_actionAdapter implements java.awt.event.ActionListener {
  MaterialLong adaptee;

  MaterialLong_jButton1_actionAdapter(MaterialLong adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.jButton1_actionPerformed(e);
  }
}

class MaterialLong_jButton2_actionAdapter implements java.awt.event.ActionListener {
  MaterialLong adaptee;

  MaterialLong_jButton2_actionAdapter(MaterialLong adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.jButton2_actionPerformed(e);
  }


}

class MaterialLong_tfPatternName_keyAdapter extends java.awt.event.KeyAdapter {
  MaterialLong adaptee;

  MaterialLong_tfPatternName_keyAdapter(MaterialLong adaptee) {
    this.adaptee = adaptee;
  }
  public void keyTyped(KeyEvent e) {
    adaptee.tfPatternName_keyTyped(e);
  }
}

class MaterialLong_tfTariffNo_keyAdapter extends java.awt.event.KeyAdapter {
  MaterialLong adaptee;

  MaterialLong_tfTariffNo_keyAdapter(MaterialLong adaptee) {
    this.adaptee = adaptee;
  }
  public void keyTyped(KeyEvent e) {
    adaptee.tfTariffNo_keyTyped(e);
  }
}

class MaterialLong_tfConst_keyAdapter extends java.awt.event.KeyAdapter {
  MaterialLong adaptee;

  MaterialLong_tfConst_keyAdapter(MaterialLong adaptee) {
    this.adaptee = adaptee;
  }
  public void keyTyped(KeyEvent e) {
    adaptee.tfConst_keyTyped(e);
  }
}

class MaterialLong_tfWeight_keyAdapter extends java.awt.event.KeyAdapter {
  MaterialLong adaptee;

  MaterialLong_tfWeight_keyAdapter(MaterialLong adaptee) {
    this.adaptee = adaptee;
  }
  public void keyTyped(KeyEvent e) {
    adaptee.tfWeight_keyTyped(e);
  }
}

class MaterialLong_tfWidth_keyAdapter extends java.awt.event.KeyAdapter {
  MaterialLong adaptee;

  MaterialLong_tfWidth_keyAdapter(MaterialLong adaptee) {
    this.adaptee = adaptee;
  }
  public void keyTyped(KeyEvent e) {
    adaptee.tfWidth_keyTyped(e);
  }
}

class MaterialLong_tfC_Width_keyAdapter extends java.awt.event.KeyAdapter {
  MaterialLong adaptee;

  MaterialLong_tfC_Width_keyAdapter(MaterialLong adaptee) {
    this.adaptee = adaptee;
  }
  public void keyTyped(KeyEvent e) {
    adaptee.tfC_Width_keyTyped(e);
  }
}

class MaterialLong_tfDescription_keyAdapter extends java.awt.event.KeyAdapter {
  MaterialLong adaptee;

  MaterialLong_tfDescription_keyAdapter(MaterialLong adaptee) {
    this.adaptee = adaptee;
  }
  public void keyTyped(KeyEvent e) {
    adaptee.tfDescription_keyTyped(e);
  }
}

class MaterialLong_tfFinish_keyAdapter extends java.awt.event.KeyAdapter {
  MaterialLong adaptee;

  MaterialLong_tfFinish_keyAdapter(MaterialLong adaptee) {
    this.adaptee = adaptee;
  }
  public void keyTyped(KeyEvent e) {
    adaptee.tfFinish_keyTyped(e);
  }
}

class MaterialLong_tfY_End_keyAdapter extends java.awt.event.KeyAdapter {
  MaterialLong adaptee;

  MaterialLong_tfY_End_keyAdapter(MaterialLong adaptee) {
    this.adaptee = adaptee;
  }
  public void keyTyped(KeyEvent e) {
    adaptee.tfY_End_keyTyped(e);
  }
}

class MaterialLong_tfY_Gauge_keyAdapter extends java.awt.event.KeyAdapter {
  MaterialLong adaptee;

  MaterialLong_tfY_Gauge_keyAdapter(MaterialLong adaptee) {
    this.adaptee = adaptee;
  }
  public void keyTyped(KeyEvent e) {
    adaptee.tfY_Gauge_keyTyped(e);
  }
}

class MaterialLong_tfY_Horizon_keyAdapter extends java.awt.event.KeyAdapter {
  MaterialLong adaptee;

  MaterialLong_tfY_Horizon_keyAdapter(MaterialLong adaptee) {
    this.adaptee = adaptee;
  }
  public void keyTyped(KeyEvent e) {
    adaptee.tfY_Horizon_keyTyped(e);
  }
}

class MaterialLong_tfY_Vertic_keyAdapter extends java.awt.event.KeyAdapter {
  MaterialLong adaptee;

  MaterialLong_tfY_Vertic_keyAdapter(MaterialLong adaptee) {
    this.adaptee = adaptee;
  }
  public void keyTyped(KeyEvent e) {
    adaptee.tfY_Vertic_keyTyped(e);
  }
}

class MaterialLong_tfWash_keyAdapter extends java.awt.event.KeyAdapter {
  MaterialLong adaptee;

  MaterialLong_tfWash_keyAdapter(MaterialLong adaptee) {
    this.adaptee = adaptee;
  }
  public void keyTyped(KeyEvent e) {
    adaptee.tfWash_keyTyped(e);
  }
}
