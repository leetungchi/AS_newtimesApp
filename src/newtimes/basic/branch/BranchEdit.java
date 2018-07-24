package newtimes.basic.branch;

import java.awt.*;
import newtimes.*;
import javax.swing.*;
import java.awt.event.*;
import exgui.*;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author unascribed
 * @version 1.0
 */

public class BranchEdit extends JPanel {
  Frame1 frame;
  private JTextField txtAdd1 = new JTextField();
  private JButton butnDel = new JButton();
  private JTextField txtBranchBrief = new JTextField();
  private JTextField txtBranchName = new JTextField();
  private JButton butnModify = new JButton();
  private JButton butnExit = new JButton();
  private JLabel textAreaStatus = new JLabel();
  private JLabel jTextField5 = new JLabel();
  private JLabel jTextField4 = new JLabel();
  private JLabel jTextField3 = new JLabel();
  private JLabel jTextField2 = new JLabel();
  private JLabel jTextField1 = new JLabel();
  private JLabel jLabel1 = new JLabel();
  private JLabel jTextField6 = new JLabel();
  private JTextField txtAdd2 = new JTextField();
  private JLabel jTextField8 = new JLabel();
  private JTextField txtAdd3 = new JTextField();
  private JLabel jTextField13 = new JLabel();
  private JTextField txtTel1 = new JTextField();
  private JLabel jTextField15 = new JLabel();
  private JTextField txtTel2 = new JTextField();
  private JLabel jTextField17 = new JLabel();
  private JTextField txtFax1 = new JTextField();
  private JTextField txtFax2 = new JTextField();
  private JComboBox cmboCntry = new JComboBox();
  private exgui.DataBindJCombobox dbJCBXCnty = null;
  private java.util.HashMap hm =
      (java.util.HashMap)util.ApplicationProperites.getProperties("recDetail");
  JTextField txtPrefix = new JTextField();
  JLabel jTextField7 = new JLabel();
  static boolean isExit = false;
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel12 = new BlueBkgWhiteCharLabel();
  JTextField txtAdd4 = new JTextField();
  exgui.DataBindJCombobox dbCBX_Center=null;
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel13 = new BlueBkgWhiteCharLabel();
  JScrollPane jScrollPnl4Centers = new JScrollPane();
  PnlCenterSelections pnlCenterSelections1 = new PnlCenterSelections();
  public BranchEdit(Frame1 _frame) {
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
    jLabel1.setFont(new java.awt.Font("Dialog", 1, 13));
    jLabel1.setForeground(new Color(10,36,106));
    jLabel1.setBorder(BorderFactory.createEtchedBorder());
    jLabel1.setHorizontalAlignment(SwingConstants.CENTER);
    jLabel1.setText("      ============  Branch Edit  ============      ");
    jLabel1.setBounds(new Rectangle(117, 26, 566, 24));
    jTextField1.setBackground(new Color(143, 143, 188));
    jTextField1.setFont(new java.awt.Font("Dialog", 1, 12));
    jTextField1.setForeground(new Color(10,36,106));
    jTextField1.setBorder(null);
    jTextField1.setOpaque(true);
    //jTextField1.setEditable(false);
    jTextField1.setText(" Branch Name :");
    jTextField1.setBounds(new Rectangle(45, 170, 100, 23));
    jTextField2.setBackground(new Color(143, 143, 188));
    jTextField2.setFont(new java.awt.Font("Dialog", 1, 12));
    jTextField2.setForeground(new Color(10,36,106));
    jTextField2.setBorder(null);
    jTextField2.setOpaque(true);
    //jTextField2.setEditable(false);
    jTextField2.setText(" * Branch Brief :");
    jTextField2.setBounds(new Rectangle(45, 106, 100, 23));
    jTextField3.setBackground(new Color(143, 143, 188));
    jTextField3.setFont(new java.awt.Font("Dialog", 1, 12));
    jTextField3.setForeground(Color.white);
    jTextField3.setBorder(null);
    jTextField3.setOpaque(true);
    jTextField3.setRequestFocusEnabled(true);
    //jTextField3.setEditable(false);
    jTextField3.setText(" Address 1 :");
    jTextField3.setBounds(new Rectangle(45, 202, 100, 23));
    jTextField4.setBounds(new Rectangle(45, 234, 100, 23));
    jTextField4.setText(" Address 2 :");
    jTextField4.setBorder(null);
    jTextField4.setOpaque(true);
    //jTextField4.setEditable(false);
    jTextField4.setForeground(new Color(10,36,106));
    jTextField4.setFont(new java.awt.Font("Dialog", 1, 12));
    jTextField4.setBackground(new Color(143, 143, 188));
    jTextField5.setBounds(new Rectangle(45, 266, 100, 23));
    jTextField5.setText(" Address 3 :");
    jTextField5.setBorder(null);
    jTextField5.setOpaque(true);
    //jTextField5.setEditable(false);
    jTextField5.setForeground(Color.white);
    jTextField5.setFont(new java.awt.Font("Dialog", 1, 12));
    jTextField5.setBackground(new Color(143, 143, 188));
    textAreaStatus.setBackground(new Color(143, 143, 188));
    textAreaStatus.setBorder(null);
    textAreaStatus.setOpaque(true);
    //textAreaStatus.setEditable(false);
    textAreaStatus.setBounds(new Rectangle(0, 540, 800, 30));
    butnExit.setBackground(Color.lightGray);
    butnExit.setBounds(new Rectangle(472, 495, 80, 25));
    butnExit.setFont(new java.awt.Font("Dialog", 1, 13));
    butnExit.setForeground(Color.darkGray);
    butnExit.setText("Exit");
    butnExit.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        butnExit_actionPerformed(e);
      }
    });
    butnModify.setBackground(Color.lightGray);
    butnModify.setBounds(new Rectangle(225, 495, 134, 25));
    butnModify.setFont(new java.awt.Font("Dialog", 1, 13));
    butnModify.setForeground(Color.darkGray);
    butnModify.setText("Confirm Modify");
    butnModify.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        butnModify_actionPerformed(e);
      }
    });
    txtBranchName.setBounds(new Rectangle(147, 169, 271, 23));
    txtBranchBrief.setBounds(new Rectangle(147, 105, 271, 23));
    txtBranchBrief.setEnabled(false);
    txtBranchBrief.setEditable(false);
    butnDel.setBackground(Color.lightGray);
    butnDel.setBounds(new Rectangle(376, 495, 80, 25));
    butnDel.setFont(new java.awt.Font("Dialog", 1, 13));
    butnDel.setForeground(Color.darkGray);
    butnDel.setText("Delete");
    butnDel.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        butnDel_actionPerformed(e);
      }
    });
    txtAdd1.setBounds(new Rectangle(147, 201, 344, 23));
    this.setLayout(null);
    this.setSize(800,600);
    this.setBackground(new Color(204, 204, 225));
    jTextField6.setBackground(new Color(143, 143, 188));
    jTextField6.setFont(new java.awt.Font("Dialog", 1, 12));
    jTextField6.setForeground(new Color(10,36,106));
    jTextField6.setBorder(null);
    jTextField6.setOpaque(true);
    //jTextField6.setEditable(false);
    jTextField6.setText(" TEL 1 :");
    jTextField6.setBounds(new Rectangle(46, 331, 100, 23));
    txtAdd2.setBounds(new Rectangle(147, 233, 344, 23));
    jTextField8.setBackground(new Color(143, 143, 188));
    jTextField8.setFont(new java.awt.Font("Dialog", 1, 12));
    jTextField8.setForeground(Color.white);
    jTextField8.setBorder(null);
    jTextField8.setOpaque(true);
    //jTextField8.setEditable(false);
    jTextField8.setText(" TEL 2 :");
    jTextField8.setBounds(new Rectangle(46, 363, 100, 23));
    txtAdd3.setBounds(new Rectangle(147, 265, 344, 23));
    jTextField13.setBackground(new Color(143, 143, 188));
    jTextField13.setFont(new java.awt.Font("Dialog", 1, 12));
    jTextField13.setForeground(new Color(10,36,106));
    jTextField13.setBorder(null);
    jTextField13.setOpaque(true);
    //jTextField13.setEditable(false);
    jTextField13.setText(" FAX 1 :");
    jTextField13.setBounds(new Rectangle(46, 395, 100, 23));
    txtTel1.setBounds(new Rectangle(148, 330, 271, 23));
    jTextField15.setBackground(new Color(143, 143, 188));
    jTextField15.setFont(new java.awt.Font("Dialog", 1, 12));
    jTextField15.setForeground(Color.white);
    jTextField15.setBorder(null);
    jTextField15.setOpaque(true);
    //jTextField15.setEditable(false);
    jTextField15.setText(" FAX 2 :");
    jTextField15.setBounds(new Rectangle(46, 427, 100, 23));
    txtTel2.setBounds(new Rectangle(148, 362, 271, 23));
    jTextField17.setBackground(new Color(143, 143, 188));
    jTextField17.setFont(new java.awt.Font("Dialog", 1, 12));
    jTextField17.setForeground(new Color(10,36,106));
    jTextField17.setBorder(null);
    jTextField17.setOpaque(true);
    //jTextField17.setEditable(false);
    jTextField17.setText(" Country :");
    jTextField17.setBounds(new Rectangle(45, 459, 100, 23));
    txtFax1.setBounds(new Rectangle(148, 394, 271, 23));
    txtFax2.setBounds(new Rectangle(148, 426, 271, 23));
    cmboCntry.setBounds(new Rectangle(148, 458, 271, 23));
    cmboCntry.setBackground(Color.white);
    txtPrefix.setEnabled(false);
    txtPrefix.setEditable(false);
    txtPrefix.setBounds(new Rectangle(147, 136, 38, 23));
    jTextField7.setBounds(new Rectangle(45, 137, 100, 23));
    jTextField7.setText(" * Prefix :");
    //jTextField7.setEditable(false);
    //jTextField7.setSelectedTextColor(Color.white);
    jTextField7.setBorder(null);
    jTextField7.setOpaque(true);
    jTextField7.setForeground(Color.white);
    jTextField7.setFont(new java.awt.Font("Dialog", 1, 12));
    jTextField7.setBackground(new Color(143, 143, 188));
    blueBkgWhiteCharLabel12.setHorizontalAlignment(SwingConstants.LEADING);
    blueBkgWhiteCharLabel12.setText("Address 4:");
    blueBkgWhiteCharLabel12.setBounds(new Rectangle(45, 297, 100, 22));
    txtAdd4.setBounds(new Rectangle(147, 296, 344, 23));
    blueBkgWhiteCharLabel13.setBounds(new Rectangle(501, 65, 230, 26));
    blueBkgWhiteCharLabel13.setText("Selectable Centers");
    jScrollPnl4Centers.setBounds(new Rectangle(501, 92, 230, 390));
    pnlCenterSelections1.setCenterCammaString("");
    this.add(textAreaStatus, null);
    this.add(jLabel1, null);
    this.add(butnModify, null);
    this.add(butnExit, null);
    this.add(butnDel, null);
    this.add(jTextField2, null);
    this.add(jTextField7, null);
    this.add(jTextField1, null);
    this.add(jTextField3, null);
    this.add(jTextField4, null);
    this.add(jTextField5, null);
    this.add(blueBkgWhiteCharLabel12, null);
    this.add(jTextField6, null);
    this.add(jTextField8, null);
    this.add(jTextField13, null);
    this.add(jTextField15, null);
    this.add(jTextField17, null);
    this.add(txtBranchBrief, null);
    this.add(txtPrefix, null);
    this.add(txtBranchName, null);
    this.add(txtAdd1, null);
    this.add(txtAdd2, null);
    this.add(txtAdd3, null);
    this.add(txtAdd4, null);
    this.add(txtTel1, null);
    this.add(txtTel2, null);
    this.add(txtFax1, null);
    this.add(txtFax2, null);
    this.add(cmboCntry, null);
    this.add(blueBkgWhiteCharLabel13, null);
    this.add(jScrollPnl4Centers, null);
    jScrollPnl4Centers.getViewport().add(pnlCenterSelections1, null);
    this.setCmboBranch();
    this.setData2Fields();
  }
  void butnExit_actionPerformed(ActionEvent e) {
    isExit = true;
    frame.showPanel(new newtimes.basic.branch.BranchList(frame));
  }

  void butnDel_actionPerformed(ActionEvent e) {
    int result = exgui2.InfoMessage.Yes_No_Option(frame,"Delete ?");
    if(result == 0){
      setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
      try {
        isExit = true;
        hm.clear();
        hm.put("BRNCH_BRIEF", txtBranchBrief.getText());
        hm.put("delete_user", util.PublicVariable.USER_RECORD.get("USR_CODE"));
        boolean isOk = exgui2.CONST.BASIC_MAIN_EJB.deleteBranch(hm);
        if (isOk) {
          exgui2.InfoMessage.infoMessage(frame, "Delete Succeed.");
          frame.showPanel(new newtimes.basic.branch.BranchList(frame));
        } else {
          exgui2.InfoMessage.warningMessage(frame, "Delete Failed.");
        }
      } catch (Exception eDel) {
        eDel.printStackTrace();
        util.ExceptionLog.exp2File(eDel, "error at delete data." + hm.toString());
      }
      setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
    }
  }

  void setCmboBranch() {
    java.util.Vector vDataCntry = null;
    try {
      vDataCntry = exgui2.CONST.BASIC_MAIN_EJB.getCountryAll("CNTY_NAME,CNTY_WEIGHT", "CNTY_NAME");
      database.datatype.Record rec = (database.datatype.Record) vDataCntry.get(0);
      dbJCBXCnty = new exgui.DataBindJCombobox(cmboCntry, vDataCntry, "CNTY_NAME",
                                           "CNTY_NAME", rec.get("CNTY_NAME"));
    } catch (Exception e) {
      e.printStackTrace();
      util.ExceptionLog.exp2File(e, "branch data:"+vDataCntry.toString());
    }
  }

  void setData2Fields() {
    database.datatype.Record recDetail = null;

    try {
      recDetail = (database.datatype.Record)hm.get("recDetail");
      pnlCenterSelections1.setCenterCammaString((String)recDetail.get("BRNCH_CEN_CODE"));
      txtBranchBrief.setText(recDetail.get("brnch_brief")==null?"":recDetail.get("brnch_brief").toString());
      txtPrefix.setText(recDetail.get("BRNCH_PREFIX")==null?"":recDetail.get("BRNCH_PREFIX").toString());
      txtBranchName.setText(recDetail.get("brnch_name")==null?"":recDetail.get("brnch_name").toString());
      txtAdd1.setText(recDetail.get("brnch_addr1")==null?"":recDetail.get("brnch_addr1").toString());
      txtAdd2.setText(recDetail.get("brnch_addr2")==null?"":recDetail.get("brnch_addr2").toString());
      txtAdd3.setText(recDetail.get("brnch_addr3")==null?"":recDetail.get("brnch_addr3").toString());
      txtAdd4.setText(recDetail.get("brnch_addr4")==null?"":recDetail.get("brnch_addr4").toString());
      txtTel1.setText(recDetail.get("brnch_tel1")==null?"":recDetail.get("brnch_tel1").toString());
      txtTel2.setText(recDetail.get("brnch_tel2")==null?"":recDetail.get("brnch_tel2").toString());
      txtFax1.setText(recDetail.get("brnch_fax1")==null?"":recDetail.get("brnch_fax1").toString());
      txtFax2.setText(recDetail.get("brnch_fax2")==null?"":recDetail.get("brnch_fax2").toString());
      cmboCntry.setSelectedItem(recDetail.get("BRNCH_CNTY_NAME")==null?"":recDetail.get("BRNCH_CNTY_NAME").toString());
    } catch (Exception e) {
      e.printStackTrace();
      util.ExceptionLog.exp2File(e, "error at set datas to fields."+recDetail.toString());
    }
  }

  void butnModify_actionPerformed(ActionEvent e) {
    int result = exgui2.InfoMessage.Yes_No_Option(frame,"Modify ?");
    if(result == 0){
      setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
      try {
        isExit = true;
        hm.clear();
        hm.put("BRNCH_CEN_CODE", pnlCenterSelections1.getCenterCammaString());
        hm.put("update_user", util.PublicVariable.USER_RECORD.get("USR_CODE"));
        hm.put("BRNCH_BRIEF", txtBranchBrief.getText().trim().toUpperCase());
        hm.put("BRNCH_PREFIX", txtPrefix.getText().trim().toUpperCase());
        hm.put("BRNCH_NAME", txtBranchName.getText().trim().toUpperCase());
        hm.put("BRNCH_ADDR1", txtAdd1.getText().trim().toUpperCase());
        hm.put("BRNCH_ADDR2", txtAdd2.getText().trim().toUpperCase());
        hm.put("BRNCH_ADDR3", txtAdd3.getText().trim().toUpperCase());
        hm.put("BRNCH_ADDR4", txtAdd4.getText().trim().toUpperCase());
        hm.put("BRNCH_TEL1", txtTel1.getText().trim().toUpperCase());
        hm.put("BRNCH_TEL2", txtTel2.getText().trim().toUpperCase());
        hm.put("BRNCH_FAX1", txtFax1.getText().trim().toUpperCase());
        hm.put("BRNCH_FAX2", txtFax2.getText().trim().toUpperCase());
        hm.put("BRNCH_CNTY_NAME", dbJCBXCnty.getSelectedValue().toString());
        boolean isOk = exgui2.CONST.BASIC_MAIN_EJB.updateBranch(hm);
        if (isOk) {
          exgui2.InfoMessage.infoMessage(frame, "Modify Succeed.");
          frame.showPanel(new newtimes.basic.branch.BranchList(frame));
        } else {
          exgui2.InfoMessage.warningMessage(frame, "Modify Failed.");
        }
      } catch (Exception eDel) {
        eDel.printStackTrace();
        util.ExceptionLog.exp2File(eDel, "error at modify data." + hm.toString());
      }
      setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
    }
  }

  void setMaxLength(){
    exgui.DataBindText tx = null;
    tx = new exgui.DataBindText(txtPrefix,null,"",2);
    tx = new exgui.DataBindText(txtBranchBrief,null,"",20);
    tx = new exgui.DataBindText(txtBranchName,null,"",60);
    tx = new exgui.DataBindText(txtAdd1,null,"",60);
    tx = new exgui.DataBindText(txtAdd2,null,"",60);
    tx = new exgui.DataBindText(txtAdd3,null,"",60);
    tx = new exgui.DataBindText(txtAdd4,null,"",60);
    tx = new exgui.DataBindText(txtTel1,null,"",15);
    tx = new exgui.DataBindText(txtTel2,null,"",15);
    tx = new exgui.DataBindText(txtFax1,null,"",15);
    tx = new exgui.DataBindText(txtFax2,null,"",15);
  }
}
