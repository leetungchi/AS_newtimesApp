package newtimes.basic.buyermaker;

import java.awt.*;
import newtimes.*;
import javax.swing.*;
import java.awt.event.*;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author unascribed
 * @version 1.0
 */

public class BuyerMakerSearch extends JPanel {
  Frame1 frame;
  private JTextField txtMasCo = new JTextField();
  private JTextField txtName = new JTextField();
  private JTextField txtChBrief = new JTextField();
  private JTextField textAreaStatus = new JTextField();
  private JTextField txtBrief = new JTextField();
  private JTextField jTextField6 = new JTextField();
  private JTextField jTextField5 = new JTextField();
  private JTextField jTextField4 = new JTextField();
  private JTextField jTextField3 = new JTextField();
  private JTextField jTextField2 = new JTextField();
  private JTextField jTextField1 = new JTextField();
  private JLabel jLabel1 = new JLabel();
  private JButton butnAdd = new JButton();
  private JButton butnExtract = new JButton();
  private JButton butnExit = new JButton();
  private JLabel jLabel2 = new JLabel();
  private JLabel jLabel3 = new JLabel();
  private JLabel jLabel4 = new JLabel();
  private JLabel jLabel5 = new JLabel();
  private JComboBox cmboCnty = new JComboBox();
  private JComboBox cmboType = new JComboBox();
  private exgui.DataBindJCombobox dbJCBXCnty = null,dbCbxCenters=null;
  JTextField jTextField7 = new JTextField();
  JComboBox cbxCenters = new JComboBox();
  public static java.util.Vector vSelectCenters;
  JLabel jLabel6 = new JLabel();
  JTextField txtHkCode = new JTextField();
  JTextField jTextField8 = new JTextField();
//  private BasicMdlEJBs.BasicMaintainEJB.BasicMaintainEJB basicMainEJB =
//    (BasicMdlEJBs.BasicMaintainEJB.BasicMaintainEJB)util.ApplicationProperites.getProperties("basicMainEJB");


  public BuyerMakerSearch(Frame1 _frame) {
    frame = _frame;
    try {
      jbInit();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }
  void jbInit() throws Exception {
    this.setMaxLength();
    jLabel1.setBounds(new Rectangle(117, 26, 566, 24));
    jLabel1.setText("      ============  Buyer - Maker Search  ============      ");
    jLabel1.setHorizontalAlignment(SwingConstants.CENTER);
    jLabel1.setBorder(BorderFactory.createEtchedBorder());
    jLabel1.setForeground(new Color(10,36,106));
    jLabel1.setFont(new java.awt.Font("Dialog", 1, 13));
    jTextField1.setBounds(new Rectangle(193, 139, 155, 23));
    jTextField1.setText(" Country :");
    jTextField1.setBorder(null);
    jTextField1.setEditable(false);
    jTextField1.setForeground(new Color(10,36,106));
    jTextField1.setFont(new java.awt.Font("Dialog", 1, 12));
    jTextField1.setBackground(new Color(143, 143, 188));
    jTextField2.setBounds(new Rectangle(193, 171, 155, 23));
    jTextField2.setText(" Type :");
    jTextField2.setBorder(null);
    jTextField2.setEditable(false);
    jTextField2.setForeground(Color.white);
    jTextField2.setFont(new java.awt.Font("Dialog", 1, 12));
    jTextField2.setBackground(new Color(143, 143, 188));
    jTextField3.setBounds(new Rectangle(193, 203, 155, 23));
    jTextField3.setText(" Name :");
    jTextField3.setBorder(null);
    jTextField3.setEditable(false);
    jTextField3.setForeground(new Color(10,36,106));
    jTextField3.setFont(new java.awt.Font("Dialog", 1, 12));
    jTextField3.setBackground(new Color(143, 143, 188));
    jTextField4.setBackground(new Color(143, 143, 188));
    jTextField4.setFont(new java.awt.Font("Dialog", 1, 12));
    jTextField4.setForeground(Color.white);
    jTextField4.setBorder(null);
    jTextField4.setEditable(false);
    jTextField4.setText(" Brief :");
    jTextField4.setBounds(new Rectangle(193, 235, 155, 23));
    jTextField5.setBackground(new Color(143, 143, 188));
    jTextField5.setFont(new java.awt.Font("Dialog", 1, 12));
    jTextField5.setForeground(new Color(10,36,106));
    jTextField5.setBorder(null);
    jTextField5.setEditable(false);
    jTextField5.setText(" Chinese Brief :");
    jTextField5.setBounds(new Rectangle(193, 267, 155, 23));
    jTextField6.setBounds(new Rectangle(193, 298, 155, 23));
    jTextField6.setText(" Master Company :");
    jTextField6.setBorder(null);
    jTextField6.setEditable(false);
    jTextField6.setForeground(Color.white);
    jTextField6.setFont(new java.awt.Font("Dialog", 1, 12));
    jTextField6.setBackground(new Color(143, 143, 188));
    txtBrief.setBounds(new Rectangle(349, 235, 155, 23));
    textAreaStatus.setBounds(new Rectangle(0, 540, 800, 30));
    textAreaStatus.setEditable(false);
    textAreaStatus.setBorder(null);
    textAreaStatus.setBackground(new Color(143, 143, 188));
    txtChBrief.setBounds(new Rectangle(349, 267, 155, 23));
    txtName.setBounds(new Rectangle(349, 203, 155, 23));
    txtMasCo.setBounds(new Rectangle(349, 298, 155, 23));
    this.setLayout(null);
    this.setSize(800,600);
    this.setBackground(new Color(204, 204, 225));
    butnAdd.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        butnAdd_actionPerformed(e);
      }
    });
    butnAdd.setText("Add New");
    butnAdd.setForeground(Color.darkGray);
    butnAdd.setFont(new java.awt.Font("Dialog", 1, 13));
    butnAdd.setBounds(new Rectangle(360, 495, 100, 25));
    butnAdd.setBackground(Color.lightGray);
    butnExtract.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        butnExtract_actionPerformed(e);
      }
    });
    butnExtract.setText("Extract");
    butnExtract.setForeground(Color.darkGray);
    butnExtract.setFont(new java.awt.Font("Dialog", 1, 13));
    butnExtract.setBounds(new Rectangle(261, 495, 80, 25));
    butnExtract.setBackground(Color.lightGray);
    butnExit.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        butnExit_actionPerformed(e);
      }
    });
    butnExit.setText("Exit");
    butnExit.setForeground(Color.darkGray);
    butnExit.setFont(new java.awt.Font("Dialog", 1, 13));
    butnExit.setBounds(new Rectangle(479, 495, 80, 25));
    butnExit.setBackground(Color.lightGray);
    jLabel2.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel2.setForeground(new Color(143, 143, 188));
    jLabel2.setText("(Input First Letter)");
    jLabel2.setBounds(new Rectangle(509, 203, 111, 23));
    jLabel3.setBounds(new Rectangle(509, 235, 111, 23));
    jLabel3.setText("(Input First Letter)");
    jLabel3.setForeground(new Color(143, 143, 188));
    jLabel3.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel4.setBounds(new Rectangle(509, 267, 111, 23));
    jLabel4.setText("(Input First Letter)");
    jLabel4.setForeground(new Color(143, 143, 188));
    jLabel4.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel5.setBounds(new Rectangle(509, 298, 111, 23));
    jLabel5.setText("(Input First Letter)");
    jLabel5.setForeground(new Color(143, 143, 188));
    jLabel5.setFont(new java.awt.Font("Dialog", 1, 12));
    cmboCnty.setBounds(new Rectangle(349, 139, 271, 23));
    cmboType.setBounds(new Rectangle(349, 171, 271, 23));
    cmboCnty.setBackground(Color.white);
    cmboType.setBackground(Color.white);
    jTextField7.setBackground(new Color(143, 143, 188));
    jTextField7.setFont(new java.awt.Font("Dialog", 1, 12));
    jTextField7.setForeground(Color.white);
    jTextField7.setEditable(false);
    jTextField7.setBorder(null);
    jTextField7.setText(" Center :");
    jTextField7.setBounds(new Rectangle(193, 109, 155, 23));
    cbxCenters.setBounds(new Rectangle(349, 109, 271, 23));
    jLabel6.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel6.setForeground(new Color(143, 143, 188));
    jLabel6.setText("(Input First Letter)");
    jLabel6.setBounds(new Rectangle(509, 322, 111, 23));
    txtHkCode.setBounds(new Rectangle(349, 322, 155, 23));
    jTextField8.setBounds(new Rectangle(193, 322, 155, 23));
    jTextField8.setText(" HK CODE :");
    jTextField8.setEditable(false);
    jTextField8.setBorder(null);
    jTextField8.setForeground(new Color(10,36,106));
    jTextField8.setFont(new java.awt.Font("Dialog", 1, 12));
    jTextField8.setBackground(new Color(143, 143, 188));
    this.add(textAreaStatus, null);
    this.add(jLabel1, null);
    this.add(butnExit, null);
    this.add(butnAdd, null);
    this.add(butnExtract, null);
    this.add(jTextField1, null);
    this.add(cmboCnty, null);
    this.add(jTextField2, null);
    this.add(cmboType, null);
    this.add(jTextField3, null);
    this.add(txtName, null);
    this.add(jTextField4, null);
    this.add(txtBrief, null);
    this.add(jTextField5, null);
    this.add(txtChBrief, null);
    this.add(jTextField6, null);
    this.add(txtMasCo, null);
    this.add(jLabel2, null);
    this.add(jLabel3, null);
    this.add(jLabel4, null);
    this.add(jLabel5, null);
    this.add(jTextField7, null);
    this.add(cbxCenters, null);
    this.add(jLabel6, null);
    this.add(txtHkCode, null);
    this.add(jTextField8, null);
    this.setCmboData();
    if(util.ApplicationProperites.getProperties("allData")!=null){
      this.ResetOrigValue((java.util.HashMap) util.ApplicationProperites.getProperties("allData"));
    }
    cbxCenters.addItem("");
  }

  void butnAdd_actionPerformed(ActionEvent e) {
    setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
    frame.showPanel(new newtimes.basic.buyermaker.BuyerMakerAdd(frame));
    setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
  }

  void butnExtract_actionPerformed(ActionEvent e) {
    java.util.HashMap hm = new java.util.HashMap();
    try {
      setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
      hm.put("BYMKR_CNTY_CODE",dbJCBXCnty.getSelectedValue());
      hm.put("BYMKR_TYPE",exgui2.Stuff.getBuyMkTypeValue4JComboBox(cmboType,true));
      hm.put("BYMKR_BRIEF",txtBrief.getText().trim().equals("")?"null":txtBrief.getText());
      hm.put("BYMKR_NAME",txtName.getText().trim().equals("")?"null":txtName.getText());
      hm.put("BYMKR_CHINESE_BRIEF",txtChBrief.getText().trim().equals("")?"null":txtChBrief.getText());
      hm.put("BYMKR_MASTER_COMPANY",txtMasCo.getText().trim().equals("")?"null":txtMasCo.getText());
      //for reset user setting value
      hm.put("BYMKR_CNTY_CODE_ITEM",cmboCnty.getSelectedItem());
      hm.put("BYMKR_TYPE_ITEM",cmboType.getSelectedItem());
      hm.put("SELECTABLE_CENTER",dbCbxCenters.getSelectedValue());
      util.ApplicationProperites.setProperties("allData", hm);
      if(txtHkCode.getText().trim().length()>0){
        hm.put("BYMKR_HK_CODE",txtHkCode.getText().trim().toUpperCase());
      }
      frame.showPanel(new newtimes.basic.buyermaker.BuyerMakerList(frame));
    } catch (Exception eHm) {
      eHm.printStackTrace();
      util.ExceptionLog.exp2File(eHm, "error at HashMap."+hm.toString());
    } finally {
      setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
    }
  }

  void butnExit_actionPerformed(ActionEvent e) {
    setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
    util.ApplicationProperites.removeProperites("allData");
    frame.showPanel(new newtimes.basic.MiscMenu(frame));
    setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
  }

  void setCmboData() {
    java.util.Vector vDataCnty = null;
    try {
      vDataCnty = exgui2.CONST.BASIC_MAIN_EJB.getCountryAll("CNTY_NAME,CNTY_WEIGHT", "CNTY_NAME");
      if(vSelectCenters==null){
        vSelectCenters=
            exgui2.CONST.BASIC_MAIN_EJB.getDatas(
             util.PublicVariable.USER_RECORD,
             "select CEN_CODE, CEN_NAME from center where record_delete_flag='1' order by cen_name",1,999);
         java.util.HashMap hm=new java.util.HashMap();
         for(int i=0;i<vSelectCenters.size();i++){
           database.datatype.Record rec=(database.datatype.Record)vSelectCenters.get(i);
           hm.put(rec.get(0),rec.get(1));
         }
         BuyerMakerAbsTable.hmlistCenters=hm;
      }
      database.datatype.Record rec = (database.datatype.Record) vDataCnty.get(0);
      dbJCBXCnty = new exgui.DataBindJCombobox(cmboCnty, vDataCnty, "CNTY_NAME",
                                           "CNTY_NAME", rec.get("CNTY_NAME"),"","null");


      dbCbxCenters = new exgui.DataBindJCombobox(cbxCenters,
          "SELECTABLE_CENTER",vSelectCenters, "CEN_NAME",
          "CEN_CODE",
          null,"",null);

      cmboType.addItem("");
      exgui2.Stuff.getBuyMkType4JComboBox(cmboType);
      cmboCnty.setSelectedIndex(0);
    } catch (Exception e) {
      e.printStackTrace();
      util.ExceptionLog.exp2File(e, "country data:"+vDataCnty.toString());
    }
  }

  void setMaxLength(){
    exgui.DataBindText tx = null;
    tx = new exgui.DataBindText(txtName,null,"",60);
    tx = new exgui.DataBindText(txtBrief,null,"",15);
    tx = new exgui.DataBindText(txtChBrief,null,"",8);
    tx = new exgui.DataBindText(txtMasCo,null,"",15);
    tx = new exgui.DataBindText(txtHkCode,null,"",15);
  }

  void ResetOrigValue(java.util.HashMap hm){
    cmboCnty.setSelectedItem(hm.get("BYMKR_CNTY_CODE_ITEM"));
    cmboType.setSelectedItem(hm.get("BYMKR_TYPE_ITEM"));
    //cbxCenters.setSelectedItem(hm.get("SELECTABLE_CENTER"));
    dbCbxCenters = new exgui.DataBindJCombobox(cbxCenters,
        "SELECTABLE_CENTER",vSelectCenters, "CEN_NAME",
        "CEN_CODE",
        hm.get("SELECTABLE_CENTER")
        ,"",null);

    txtBrief.setText(hm.get("BYMKR_BRIEF").toString().equals("null")?"":(String)hm.get("BYMKR_BRIEF"));
    txtName.setText(hm.get("BYMKR_NAME").toString().equals("null")?"":hm.get("BYMKR_NAME").toString());
    txtChBrief.setText(hm.get("BYMKR_CHINESE_BRIEF").toString().equals("null")?"":hm.get("BYMKR_CHINESE_BRIEF").toString());
    txtMasCo.setText(hm.get("BYMKR_MASTER_COMPANY").toString().equals("null")?"":hm.get("BYMKR_MASTER_COMPANY").toString());
    txtHkCode.setText(
       (hm.get("BYMKR_HK_CODE")==null||hm.get("BYMKR_HK_CODE").toString().equals("null"))?"":
       hm.get("BYMKR_HK_CODE").toString());
  }

}
