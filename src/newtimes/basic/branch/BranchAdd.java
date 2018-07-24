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

public class BranchAdd extends JPanel {
  Frame1 frame;
  private JTextField txtFax2 = new JTextField();
  private JTextField txtFax1 = new JTextField();
  private JTextField txtTel2 = new JTextField();
  private JTextField txtTel1 = new JTextField();
  private JTextField txtAdd1 = new JTextField();
  private JTextField txtBranchBrief = new JTextField();
  private JTextField txtBranchName = new JTextField();
  private JButton butnExit = new JButton();
  private JTextField txtAdd3 = new JTextField();
  private JLabel textAreaStatus = new JLabel();
  private JTextField txtAdd2 = new JTextField();
  private JLabel jLabel1 = new JLabel();
  private JButton butnAdd = new JButton();
  private JComboBox cmboCntry = new JComboBox();
  private exgui.DataBindJCombobox dbJCBXCnty = null,dbCBX_Center=null;
  JTextField txtPrefix = new JTextField();
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel1 = new BlueBkgWhiteCharLabel();
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel2 = new BlueBkgWhiteCharLabel();
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel3 = new BlueBkgWhiteCharLabel();
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel4 = new BlueBkgWhiteCharLabel();
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel5 = new BlueBkgWhiteCharLabel();
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel6 = new BlueBkgWhiteCharLabel();
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel7 = new BlueBkgWhiteCharLabel();
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel8 = new BlueBkgWhiteCharLabel();
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel9 = new BlueBkgWhiteCharLabel();
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel10 = new BlueBkgWhiteCharLabel();
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel11 = new BlueBkgWhiteCharLabel();
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel12 = new BlueBkgWhiteCharLabel();
  JTextField txtAdd4 = new JTextField();
  JScrollPane jScrollPnl4Centers = new JScrollPane();
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel13 = new BlueBkgWhiteCharLabel();
  PnlCenterSelections pnlCenterSelections1 = new PnlCenterSelections();

//  private BasicMdlEJBs.BasicMaintainEJB.BasicMaintainEJB basicMainEJB =
//    (BasicMdlEJBs.BasicMaintainEJB.BasicMaintainEJB)util.ApplicationProperites.getProperties("basicMainEJB");

  public BranchAdd(Frame1 _frame) {
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
    jLabel1.setText("      ============  Branch Add  ============      ");
    jLabel1.setHorizontalAlignment(SwingConstants.CENTER);
    jLabel1.setBorder(BorderFactory.createEtchedBorder());
    jLabel1.setForeground(new Color(10,36,106));
    jLabel1.setFont(new java.awt.Font("Dialog", 1, 13));
    txtAdd2.setBounds(new Rectangle(152, 210, 344, 23));
    textAreaStatus.setBounds(new Rectangle(0, 540, 800, 30));
    //textAreaStatus.setEditable(false);
    textAreaStatus.setBorder(null);
    textAreaStatus.setOpaque(true);
    textAreaStatus.setBackground(new Color(143, 143, 188));
    txtAdd3.setBounds(new Rectangle(152, 240, 344, 23));
    cmboCntry.setBackground(Color.white);
    butnExit.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        butnExit_actionPerformed(e);
      }
    });
    butnExit.setText("Exit");
    butnExit.setForeground(Color.darkGray);
    butnExit.setFont(new java.awt.Font("Dialog", 1, 13));
    butnExit.setBounds(new Rectangle(428, 495, 80, 25));
    butnExit.setBackground(Color.lightGray);
    txtBranchName.setBounds(new Rectangle(152, 146, 271, 23));
    txtBranchBrief.setBounds(new Rectangle(152, 80, 271, 26));
    txtAdd1.setBounds(new Rectangle(152, 177, 344, 23));
    txtTel1.setBounds(new Rectangle(152, 306, 271, 23));
    txtTel2.setBounds(new Rectangle(152, 338, 271, 23));
    txtFax1.setBounds(new Rectangle(152, 370, 271, 23));
    txtFax2.setBounds(new Rectangle(152, 402, 271, 23));
    this.setLayout(null);
    this.setSize(800,600);
    this.setBackground(new Color(204, 204, 225));
    this.setToolTipText("");
    butnAdd.setBackground(Color.lightGray);
    butnAdd.setBounds(new Rectangle(329, 495, 80, 25));
    butnAdd.setFont(new java.awt.Font("Dialog", 1, 13));
    butnAdd.setForeground(Color.darkGray);
    butnAdd.setText("Add");
    butnAdd.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        butnAdd_actionPerformed(e);
      }
    });
    cmboCntry.setBounds(new Rectangle(152, 434, 271, 23));
    txtPrefix.setBounds(new Rectangle(152, 115, 38, 23));
    blueBkgWhiteCharLabel1.setForeground(new Color(10,36,106));
    blueBkgWhiteCharLabel1.setText(" * Branch Brief :");
    blueBkgWhiteCharLabel1.setBounds(new Rectangle(33, 81, 117, 22));
    blueBkgWhiteCharLabel2.setBounds(new Rectangle(33, 147, 117, 22));
    blueBkgWhiteCharLabel2.setText(" Branch Name:");
    blueBkgWhiteCharLabel2.setForeground(new Color(10,36,106));
    blueBkgWhiteCharLabel3.setBounds(new Rectangle(33, 210, 117, 22));
    blueBkgWhiteCharLabel3.setText("Address 2:");
    blueBkgWhiteCharLabel3.setForeground(new Color(10,36,106));
    blueBkgWhiteCharLabel4.setBounds(new Rectangle(33, 305, 117, 22));
    blueBkgWhiteCharLabel4.setText("TEL 1:");
    blueBkgWhiteCharLabel4.setForeground(new Color(10,36,106));
    blueBkgWhiteCharLabel5.setBounds(new Rectangle(33, 370, 117, 22));
    blueBkgWhiteCharLabel5.setText("FAX 1:");
    blueBkgWhiteCharLabel5.setForeground(new Color(10,36,106));
    blueBkgWhiteCharLabel6.setBounds(new Rectangle(33, 432, 117, 22));
    blueBkgWhiteCharLabel6.setText("Country:");
    blueBkgWhiteCharLabel6.setForeground(new Color(10,36,106));
    blueBkgWhiteCharLabel7.setText("Prefix:");
    blueBkgWhiteCharLabel7.setBounds(new Rectangle(33, 114, 117, 22));
    blueBkgWhiteCharLabel8.setBounds(new Rectangle(33, 177, 117, 22));
    blueBkgWhiteCharLabel8.setText("Address 1:");
    blueBkgWhiteCharLabel9.setBounds(new Rectangle(33, 240, 117, 22));
    blueBkgWhiteCharLabel9.setText("Address 3:");
    blueBkgWhiteCharLabel10.setBounds(new Rectangle(33, 336, 117, 22));
    blueBkgWhiteCharLabel10.setText("TEL 2:");
    blueBkgWhiteCharLabel11.setBounds(new Rectangle(33, 402, 117, 22));
    blueBkgWhiteCharLabel11.setText("FAX 2:");
    blueBkgWhiteCharLabel12.setText("Address 4:");
    blueBkgWhiteCharLabel12.setBounds(new Rectangle(33, 272, 117, 22));
    txtAdd4.setBounds(new Rectangle(152, 272, 344, 23));
    jScrollPnl4Centers.setBounds(new Rectangle(525, 105, 230, 351));
    blueBkgWhiteCharLabel13.setBounds(new Rectangle(525, 78, 230, 26));
    blueBkgWhiteCharLabel13.setText("Selectable Centers");
    this.add(textAreaStatus, null);
    this.add(jLabel1, null);
    this.add(butnExit, null);
    this.add(butnAdd, null);
    this.add(blueBkgWhiteCharLabel1, null);
    this.add(txtBranchBrief, null);
    this.add(blueBkgWhiteCharLabel7, null);
    this.add(txtPrefix, null);
    this.add(blueBkgWhiteCharLabel2, null);
    this.add(txtBranchName, null);
    this.add(blueBkgWhiteCharLabel8, null);
    this.add(txtAdd1, null);
    this.add(blueBkgWhiteCharLabel3, null);
    this.add(txtAdd2, null);
    this.add(blueBkgWhiteCharLabel9, null);
    this.add(txtAdd3, null);
    this.add(blueBkgWhiteCharLabel12, null);
    this.add(txtAdd4, null);
    this.add(blueBkgWhiteCharLabel4, null);
    this.add(txtTel1, null);
    this.add(blueBkgWhiteCharLabel10, null);
    this.add(txtTel2, null);
    this.add(blueBkgWhiteCharLabel5, null);
    this.add(txtFax1, null);
    this.add(blueBkgWhiteCharLabel11, null);
    this.add(txtFax2, null);
    this.add(blueBkgWhiteCharLabel6, null);
    this.add(cmboCntry, null);
    this.add(jScrollPnl4Centers, null);
    jScrollPnl4Centers.getViewport().add(pnlCenterSelections1, null);
    this.add(blueBkgWhiteCharLabel13, null);
    this.setCmboBranch();
  }

  void butnExit_actionPerformed(ActionEvent e) {
    setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
    frame.showPanel(new newtimes.basic.branch.BranchList(frame));
    setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
  }

  void setCmboBranch() {
    java.util.Vector vDataCntry = null;
    try {
      vDataCntry = exgui2.CONST.BASIC_MAIN_EJB.getCountryAll("CNTY_NAME,CNTY_WEIGHT", "CNTY_NAME");
      database.datatype.Record rec = (database.datatype.Record) vDataCntry.get(0);
      dbJCBXCnty = new exgui.DataBindJCombobox(cmboCntry, vDataCntry, "CNTY_NAME",
                                           "CNTY_NAME", rec.get("CNTY_NAME"));
      pnlCenterSelections1.setCenterCammaString("");
    } catch (Exception e) {
      e.printStackTrace();
      util.ExceptionLog.exp2File(e, "country data:"+vDataCntry.toString());
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

  boolean checkFieldsData() {
    boolean nameNull = exgui2.Stuff.checkNull(frame, txtBranchBrief.getText(),"Branch Brief can't be empty.");
    boolean prefixNull = exgui2.Stuff.checkNull(frame,txtPrefix.getText(),"Branch Prefix can't be empty.");
    if (nameNull && prefixNull) { return true; }
    else { return false; }
  }

  void butnAdd_actionPerformed(ActionEvent e) {
    setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
    if (this.checkFieldsData()) {
      java.util.HashMap hm = new java.util.HashMap();
      try {
        hm.put("BRNCH_CEN_CODE", pnlCenterSelections1.getCenterCammaString());
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
        hm.put("create_user", util.PublicVariable.USER_RECORD.get("USR_CODE"));
        int isOk = exgui2.CONST.BASIC_MAIN_EJB.insertBranch(hm);
        if (exgui2.Stuff.insertMessage(frame, isOk))
          frame.showPanel(new newtimes.basic.branch.BranchList(frame));
      } catch (Exception eAdd) {
        eAdd.printStackTrace();
        util.ExceptionLog.exp2File(eAdd, "error at insert data." + hm.toString()+
                                   "\neAdd:"+eAdd.getMessage());
      }
    }
    setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
  }
}
