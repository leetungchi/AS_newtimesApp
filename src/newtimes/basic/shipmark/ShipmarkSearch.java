package newtimes.basic.shipmark;

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

public class ShipmarkSearch extends JPanel {
  Frame1 frame;
  JTextField jTextField6 = new JTextField();
  JTextField jTextField5 = new JTextField();
  JTextField jTextField4 = new JTextField();
  JTextField txtCompany = new JTextField();
  JTextField jTextField3 = new JTextField();
  JComboBox cmboCnty = new JComboBox();
  JTextField txtFullName = new JTextField();
  JTextField jTextField1 = new JTextField();
  JTextField textAreaStatus = new JTextField();
  JButton butnExtract = new JButton();
  JButton butnAdd = new JButton();
  JTextField txtChBrief = new JTextField();
  JLabel jLabel1 = new JLabel();
  JButton butnExit = new JButton();
  JTextField txtBrief = new JTextField();
  JLabel jLabel5 = new JLabel();
  JLabel jLabel4 = new JLabel();
  JLabel jLabel3 = new JLabel();
  JLabel jLabel2 = new JLabel();
  exgui.DataBindJCombobox dbJCBXCnty = null;
  JTextField txtShipMarkSeq = new JTextField();
  JTextField jTextField7 = new JTextField();
  JLabel jLabel6 = new JLabel();
  JTextField jTextField8 = new JTextField();
  JTextField txtHkCode = new JTextField();
  JLabel jLabel7 = new JLabel();

  public ShipmarkSearch(Frame1 _frame) {
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
    txtBrief.setBounds(new Rectangle(350, 170, 155, 23));
    butnExit.setBackground(Color.lightGray);
    butnExit.setBounds(new Rectangle(479, 495, 80, 25));
    butnExit.setFont(new java.awt.Font("Dialog", 1, 13));
    butnExit.setForeground(Color.darkGray);
    butnExit.setText("Exit");
    butnExit.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        butnExit_actionPerformed(e);
      }
    });
    jLabel1.setFont(new java.awt.Font("Dialog", 1, 13));
    jLabel1.setForeground(new Color(10,36,106));
    jLabel1.setBorder(BorderFactory.createEtchedBorder());
    jLabel1.setHorizontalAlignment(SwingConstants.CENTER);
    jLabel1.setText("      ============  Shipmark Search  ============      ");
    jLabel1.setBounds(new Rectangle(117, 26, 566, 24));
    txtChBrief.setBounds(new Rectangle(350, 202, 155, 23));
    butnAdd.setBackground(Color.lightGray);
    butnAdd.setBounds(new Rectangle(360, 495, 100, 25));
    butnAdd.setFont(new java.awt.Font("Dialog", 1, 13));
    butnAdd.setForeground(Color.darkGray);
    butnAdd.setText("Add New");
    butnAdd.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        butnAdd_actionPerformed(e);
      }
    });
    butnExtract.setBackground(Color.lightGray);
    butnExtract.setBounds(new Rectangle(261, 495, 80, 25));
    butnExtract.setFont(new java.awt.Font("Dialog", 1, 13));
    butnExtract.setForeground(Color.darkGray);
    butnExtract.setText("Extract");
    butnExtract.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        butnExtract_actionPerformed(e);
      }
    });
    textAreaStatus.setBackground(new Color(143, 143, 188));
    textAreaStatus.setBorder(null);
    textAreaStatus.setEditable(false);
    textAreaStatus.setBounds(new Rectangle(0, 540, 800, 30));
    jTextField1.setBackground(new Color(143, 143, 188));
    jTextField1.setFont(new java.awt.Font("Dialog", 1, 12));
    jTextField1.setForeground(new Color(10,36,106));
    jTextField1.setBorder(null);
    jTextField1.setEditable(false);
    jTextField1.setText(" Country :");
    jTextField1.setBounds(new Rectangle(193, 106, 155, 23));
    txtFullName.setBounds(new Rectangle(350, 138, 155, 23));
    cmboCnty.setBounds(new Rectangle(350, 106, 271, 23));
    jTextField3.setBackground(new Color(143, 143, 188));
    jTextField3.setFont(new java.awt.Font("Dialog", 1, 12));
    jTextField3.setForeground(new Color(10,36,106));
    jTextField3.setBorder(null);
    jTextField3.setText(" Buyer Name :");
    jTextField3.setBounds(new Rectangle(193, 138, 155, 23));
    txtCompany.setBounds(new Rectangle(350, 233, 155, 23));
    jTextField4.setBounds(new Rectangle(193, 170, 155, 23));
    jTextField4.setText(" Buyer Brief :");
    jTextField4.setBorder(null);
    jTextField4.setEditable(false);
    jTextField4.setForeground(Color.white);
    jTextField4.setFont(new java.awt.Font("Dialog", 1, 12));
    jTextField4.setBackground(new Color(143, 143, 188));
    jTextField5.setBounds(new Rectangle(193, 202, 155, 23));
    jTextField5.setText(" Chinese Brief :");
    jTextField5.setBorder(null);
    jTextField5.setEditable(false);
    jTextField5.setForeground(new Color(10,36,106));
    jTextField5.setFont(new java.awt.Font("Dialog", 1, 12));
    jTextField5.setBackground(new Color(143, 143, 188));
    jTextField6.setBackground(new Color(143, 143, 188));
    jTextField6.setFont(new java.awt.Font("Dialog", 1, 12));
    jTextField6.setForeground(Color.white);
    jTextField6.setBorder(null);
    jTextField6.setEditable(false);
    jTextField6.setText(" Master Company :");
    jTextField6.setBounds(new Rectangle(193, 233, 155, 23));
    this.setLayout(null);
    this.setSize(800,600);
    this.setBackground(new Color(204, 204, 225));
    jLabel5.setBounds(new Rectangle(510, 233, 111, 23));
    jLabel5.setText("(Input First Letter)");
    jLabel5.setForeground(new Color(143, 143, 188));
    jLabel5.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel4.setBounds(new Rectangle(510, 202, 111, 23));
    jLabel4.setText("(Input First Letter)");
    jLabel4.setForeground(new Color(143, 143, 188));
    jLabel4.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel3.setBounds(new Rectangle(510, 170, 111, 23));
    jLabel3.setText("(Input First Letter)");
    jLabel3.setForeground(new Color(143, 143, 188));
    jLabel3.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel2.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel2.setForeground(new Color(143, 143, 188));
    jLabel2.setText("(Input First Letter)");
    jLabel2.setBounds(new Rectangle(510, 138, 111, 23));
    cmboCnty.setBackground(Color.white);
    txtShipMarkSeq.setBounds(new Rectangle(243, 290, 72, 23));
    jTextField7.setBackground(new Color(143, 143, 188));
    jTextField7.setFont(new java.awt.Font("Dialog", 1, 12));
    jTextField7.setForeground(new Color(10,36,106));
    jTextField7.setEditable(false);
    jTextField7.setBorder(null);
    jTextField7.setText(" No. :");
    jTextField7.setHorizontalAlignment(SwingConstants.CENTER);
    jTextField7.setBounds(new Rectangle(193, 290, 51, 23));
    jLabel6.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel6.setForeground(new Color(143, 143, 188));
    jLabel6.setText("(To Query Directly By Seq. Of ShipMark in DataBase)");
    jLabel6.setBounds(new Rectangle(318, 288, 317, 26));
    jTextField8.setBounds(new Rectangle(193, 315, 155, 23));
    jTextField8.setText("HK CODE :");
    jTextField8.setHorizontalAlignment(SwingConstants.CENTER);
    jTextField8.setEditable(false);
    jTextField8.setBorder(null);
    jTextField8.setForeground(Color.white);
    jTextField8.setFont(new java.awt.Font("Dialog", 1, 12));
    jTextField8.setBackground(new Color(143, 143, 188));
    txtHkCode.setBounds(new Rectangle(347, 315, 155, 23));
    jLabel7.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel7.setForeground(new Color(143, 143, 188));
    jLabel7.setText("(Input First Letter)");
    jLabel7.setBounds(new Rectangle(503, 316, 111, 23));
    this.add(textAreaStatus, null);
    this.add(jTextField1, null);
    this.add(butnExtract, null);
    this.add(butnAdd, null);
    this.add(jLabel1, null);
    this.add(butnExit, null);
    this.add(cmboCnty, null);
    this.add(jLabel4, null);
    this.add(txtFullName, null);
    this.add(jTextField3, null);
    this.add(jTextField6, null);
    this.add(jTextField5, null);
    this.add(jTextField4, null);
    this.add(jLabel5, null);
    this.add(txtBrief, null);
    this.add(txtChBrief, null);
    this.add(txtCompany, null);
    this.add(jLabel2, null);
    this.add(jLabel3, null);
    this.add(jTextField7, null);
    this.add(jLabel6, null);
    this.add(txtShipMarkSeq, null);
    this.add(jTextField8, null);
    this.add(txtHkCode, null);
    this.add(jLabel7, null);
    this.setCmboShipmark();
    if(util.ApplicationProperites.getProperties("allData")!=null){
      this.ResetOrigValue((java.util.HashMap) util.ApplicationProperites.getProperties("allData"));
    }
  }

  void butnExtract_actionPerformed(ActionEvent e) {
    java.util.HashMap hm = new java.util.HashMap();
    try {
      setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
      hm.put("CNTY_NAME",dbJCBXCnty.getSelectedValue());
      hm.put("BYMKR_BRIEF",txtBrief.getText().trim().equals("")?"null":txtBrief.getText());
      hm.put("BYMKR_NAME",txtFullName.getText().trim().equals("")?"null":txtFullName.getText());
      hm.put("BYMKR_CHINESE_BRIEF",txtChBrief.getText().trim().equals("")?"null":txtChBrief.getText());
      hm.put("BYMKR_MASTER_COMPANY",txtCompany.getText().trim().equals("")?"null":txtCompany.getText());
      hm.put("CNTY_NAME_ITEM",cmboCnty.getSelectedItem());
      hm.put("BYMKR_HK_CODE",txtHkCode.getText().trim().equals("")?"null":txtHkCode.getText());
      hm.put("SHIPMARK_PK",txtShipMarkSeq.getText().trim().equals("")?"null":txtShipMarkSeq.getText());

      util.ApplicationProperites.setProperties("allData", hm);
      frame.showPanel(new newtimes.basic.shipmark.ShipmarkList(frame));
    } catch (Exception eHm) {
      eHm.printStackTrace();
      util.ExceptionLog.exp2File(eHm, "error at HashMap."+hm.toString());
    } finally {
      setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
    }
  }

  void butnAdd_actionPerformed(ActionEvent e) {
    setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
    frame.showPanel(new newtimes.basic.shipmark.ShipmarkAdd(frame));
    setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
  }

  void butnExit_actionPerformed(ActionEvent e) {
    setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
    util.ApplicationProperites.removeProperites("allData");
    frame.showPanel(new newtimes.basic.MiscMenu(frame));
    setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
  }

  void setCmboShipmark() {
    java.util.Vector vDataCnty = null;
    try {
      vDataCnty = exgui2.CONST.BASIC_MAIN_EJB.getCountryAll("CNTY_NAME,CNTY_WEIGHT", "CNTY_NAME");
      database.datatype.Record rec = (database.datatype.Record) vDataCnty.get(0);
      dbJCBXCnty = new exgui.DataBindJCombobox(cmboCnty, vDataCnty, "CNTY_NAME",
                                           "CNTY_NAME", rec.get("CNTY_NAME"),"","null");
      cmboCnty.setSelectedIndex(0);
    } catch (Exception e) {
      e.printStackTrace();
      util.ExceptionLog.exp2File(e, "country data:"+vDataCnty.toString());
    }
  }

  void setMaxLength(){
    exgui.DataBindText tx = null;
    tx = new exgui.DataBindText(txtFullName,null,"",60);
    tx = new exgui.DataBindText(txtBrief,null,"",15);
    tx = new exgui.DataBindText(txtChBrief,null,"",8);
    tx = new exgui.DataBindText(txtCompany,null,"",15);
    tx = new exgui.DataBindText(txtHkCode,null,"",10);
    Object intVfy=exgui.verification.CellFormat.getIntVerifierAllowNull(10);
    exgui.DataBindTextWithChecker dbTxtProdHeadPK=new  exgui.DataBindTextWithChecker(
              txtShipMarkSeq,
              "",
              null,10,
              (exgui.Object2String)intVfy,
              (exgui.ultratable.CellTxtEditorFormat)intVfy);
  }
  void ResetOrigValue(java.util.HashMap hm){
    cmboCnty.setSelectedItem(hm.get("CNTY_NAME_ITEM"));
    txtBrief.setText(hm.get("BYMKR_BRIEF").toString().equals("null")?"":(String)hm.get("BYMKR_BRIEF"));
    txtFullName.setText(hm.get("BYMKR_NAME").toString().equals("null")?"":hm.get("BYMKR_NAME").toString());
    txtChBrief.setText(hm.get("BYMKR_CHINESE_BRIEF").toString().equals("null")?"":hm.get("BYMKR_CHINESE_BRIEF").toString());
    txtCompany.setText(hm.get("BYMKR_MASTER_COMPANY").toString().equals("null")?"":hm.get("BYMKR_MASTER_COMPANY").toString());
    txtHkCode.setText(hm.get("BYMKR_HK_CODE").toString().equals("null")?"":hm.get("BYMKR_HK_CODE").toString());
    txtShipMarkSeq.setText(hm.get("SHIPMARK_PK").toString().equals("null")?"":hm.get("SHIPMARK_PK").toString());
  }

}
