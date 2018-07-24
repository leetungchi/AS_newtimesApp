package newtimes.basic.shipmark;

import java.awt.*;
import newtimes.*;
import javax.swing.*;
import java.awt.event.*;
import newtimes.preproduction.buyermakerselect.*;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author unascribed
 * @version 1.0
 */

public class ShipmarkEdit extends JPanel {
  Frame1 frame;
   JLabel textAreaStatus = new JLabel();
   JLabel jLabel1 = new JLabel();
   JButton butnDel = new JButton();
   JButton butnModify = new JButton();
  JButton butnExit = new JButton();
  JLabel jTextField6 = new JLabel();
  JLabel jTextField7 = new JLabel();
  JLabel jTextField8 = new JLabel();
  JLabel jTextField9 = new JLabel();
  exgui.DataBindJCombobox dbJCBXBuyer = null;
  java.util.HashMap hm =
    (java.util.HashMap)util.ApplicationProperites.getProperties("recDetail");
  JScrollPane jScrollPane2 = new JScrollPane();
  JScrollPane jScrollPane4 = new JScrollPane();
  JTextArea txtAreaMain = new JTextArea();
  JTextArea txtAreaPacking = new JTextArea();
  String _shipmarkPK = null;
  static boolean isExit = false;
  JScrollPane jScrollPane1 = new JScrollPane();
  JTextArea txtAreaSide = new JTextArea();
  Object buyer_maker_seqObj=null;
  SelectBuyerMaker slkChzBuyer = new SelectBuyerMaker();
  public ShipmarkEdit(Frame1 _frame) {
    frame = _frame;
    try {
      jbInit();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }
  void jbInit() throws Exception {
    txtAreaSide.setFont(new java.awt.Font("DialogInput", 0, 12));
    txtAreaMain.setFont(new java.awt.Font("DialogInput", 0, 12));
    this.setMaxLength();
    jLabel1.setFont(new java.awt.Font("DialogInput", 1, 13));
    jLabel1.setForeground(new Color(10,36,106));
    jLabel1.setBorder(BorderFactory.createEtchedBorder());
    jLabel1.setHorizontalAlignment(SwingConstants.CENTER);
    jLabel1.setText("      ============  Shipmark Edit  ============      ");
    jLabel1.setBounds(new Rectangle(117, 26, 566, 24));
    textAreaStatus.setBackground(new Color(143, 143, 188));
    textAreaStatus.setBorder(null);
    textAreaStatus.setOpaque(true);
    //textAreaStatus.setEditable(false);
    textAreaStatus.setBounds(new Rectangle(0, 540, 800, 30));
    this.setLayout(null);
    this.setSize(800,600);
    this.setBackground(new Color(204, 204, 225));
    butnDel.setBackground(Color.lightGray);
    butnDel.setBounds(new Rectangle(386, 514, 80, 25));
    butnDel.setFont(new java.awt.Font("DialogInput", 1, 13));
    butnDel.setForeground(Color.darkGray);
    butnDel.setText("Delete");
    butnDel.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        butnDel_actionPerformed(e);
      }
    });
    butnModify.setBackground(Color.lightGray);
    butnModify.setBounds(new Rectangle(236, 514, 133, 25));
    butnModify.setFont(new java.awt.Font("DialogInput", 1, 13));
    butnModify.setForeground(Color.darkGray);
    butnModify.setText("Confirm Modify");
    butnModify.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        butnModify_actionPerformed(e);
      }
    });
    butnExit.setBackground(Color.lightGray);
    butnExit.setBounds(new Rectangle(483, 514, 80, 25));
    butnExit.setFont(new java.awt.Font("DialogInput", 1, 13));
    butnExit.setForeground(Color.darkGray);
    butnExit.setText("Exit");
    butnExit.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        butnExitxtAreaSide_actionPerformed(e);
      }
    });
    jTextField6.setBackground(new Color(143, 143, 188));
    jTextField6.setFont(new java.awt.Font("DialogInput", 1, 12));
    jTextField6.setForeground(Color.white);
    //jTextField6.setEditable(false);
    jTextField6.setBorder(null);
    jTextField6.setOpaque(true);
    jTextField6.setText(" Main Mark :");
    jTextField6.setBounds(new Rectangle(115, 80, 155, 227));
    jTextField7.setBounds(new Rectangle(115, 55, 155, 23));
    jTextField7.setText(" Buyer :");
    jTextField7.setBorder(null);
    jTextField7.setOpaque(true);
    //jTextField7.setEditable(false);
    jTextField7.setForeground(new Color(10,36,106));
    jTextField7.setFont(new java.awt.Font("DialogInput", 1, 12));
    jTextField7.setBackground(new Color(143, 143, 188));
    jTextField8.setBounds(new Rectangle(114, 314, 155, 181));
    jTextField8.setText(" Side Mark :");
    jTextField8.setBorder(null);
    jTextField8.setOpaque(true);
    //jTextField8.setEditable(false);
    jTextField8.setForeground(new Color(10,36,106));
    jTextField8.setFont(new java.awt.Font("DialogInput", 1, 12));
    jTextField8.setBackground(new Color(143, 143, 188));
    jTextField9.setBackground(new Color(143, 143, 188));
    jTextField9.setFont(new java.awt.Font("DialogInput", 1, 12));
    jTextField9.setForeground(Color.white);
    jTextField9.setBorder(null);
    jTextField9.setOpaque(true);
    //jTextField9.setEditable(false);
    jTextField9.setText(" Packing Mark :");
    jTextField9.setBounds(new Rectangle(114, 301, 155, 68));
    jScrollPane2.setBounds(new Rectangle(271, 80, 424, 229));
    jScrollPane4.setBounds(new Rectangle(271, 301, 423, 68));
    txtAreaMain.setText("");
    txtAreaMain.setLineWrap(true);
    txtAreaPacking.setText("");
    txtAreaPacking.setLineWrap(true);
    jScrollPane1.setBounds(new Rectangle(270, 315, 427, 182));
    txtAreaSide.setText("");
    txtAreaSide.setLineWrap(true);
    slkChzBuyer.setBounds(new Rectangle(271, 55, 423, 23));
    this.add(textAreaStatus, null);
    this.add(jLabel1, null);
    //this.add(jScrollPane4, null);
    //this.add(jTextField9, null);
    this.add(jTextField7, null);
    this.add(slkChzBuyer, null);
    this.add(jTextField6, null);
    this.add(jScrollPane2, null);
    this.add(butnModify, null);
    this.add(butnDel, null);
    this.add(butnExit, null);
    this.add(jTextField8, null);
    this.add(jScrollPane1, null);
    jScrollPane1.getViewport().add(txtAreaSide, null);
    jScrollPane2.getViewport().add(txtAreaMain, null);
    jScrollPane4.getViewport().add(txtAreaPacking, null);
    this.setData2Fields();
    this.setCmboBuyer();
  }

  void butnExitxtAreaSide_actionPerformed(ActionEvent e) {
    setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
    isExit = true;
    frame.showPanel(new newtimes.basic.shipmark.ShipmarkList(frame));
    setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
  }

  void butnDel_actionPerformed(ActionEvent e) {
    int result = exgui2.InfoMessage.Yes_No_Option(frame,"Delete ?");
    if(result == 0){
      setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
      try {
        isExit = true;
        hm.clear();
        hm.put("SHIPMARK_PK", this._shipmarkPK);
        hm.put("delete_user", util.PublicVariable.USER_RECORD.get("USR_CODE"));
        boolean isOk = exgui2.CONST.BASIC_MAIN_EJB.deleteShipmark(hm);
        if (isOk) {
          exgui2.InfoMessage.infoMessage(frame, "Delete Succeed.");
          frame.showPanel(new newtimes.basic.shipmark.ShipmarkList(frame));
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

  void butnModify_actionPerformed(ActionEvent e) {
    int result = exgui2.InfoMessage.Yes_No_Option(frame,"Modify ?");
    if(result == 0){
      setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
      try {
        isExit = true;
        hm.clear();
        hm.put("update_user", util.PublicVariable.USER_RECORD.get("USR_CODE"));
        hm.put("SHIPMARK_BYMKR_SEQ",slkChzBuyer.getSelectedValue()); //dbJCBXBuyer.getSelectedValue().toString());
        hm.put("SHIPMARK_MAIN_MARK", txtAreaMain.getText());
        hm.put("SHIPMARK_SIDE_MARK", txtAreaSide.getText());
        hm.put("SHIPMARK_PACKING", txtAreaPacking.getText());
        hm.put("SHIPMARK_PK", this._shipmarkPK);
        boolean isOk = exgui2.CONST.BASIC_MAIN_EJB.updateShipmark(hm);
        if (isOk) {
          exgui2.InfoMessage.infoMessage(frame, "Modify Succeed.");
          frame.showPanel(new newtimes.basic.shipmark.ShipmarkList(frame));
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

  void setCmboBuyer() {
    java.util.Vector vDataBuyer = null;
    try {
      /*
      vDataBuyer = exgui2.CONST.BASIC_MAIN_EJB.getBuyerMakerAllByType("BYMKR_SEQ,BYMKR_BRIEF", "BYMKR_BRIEF",1);
      database.datatype.Record rec = (database.datatype.Record) vDataBuyer.get(0);
      dbJCBXBuyer = new exgui.DataBindJCombobox(cmboBuyer, vDataBuyer, "BYMKR_BRIEF",
                                           "BYMKR_SEQ", buyer_maker_seqObj,"","");
      */
       slkChzBuyer.init("",buyer_maker_seqObj,slkChzBuyer.TYPE_BUYER,true);
    } catch (Exception e) {
      e.printStackTrace();
      util.ExceptionLog.exp2File(e, "buyer data:"+vDataBuyer.toString());
    }
  }

  void setMaxLength(){
    exgui.DataBindText tx = null;
    tx = new exgui.DataBindText(txtAreaMain,null,"",1000);
    tx = new exgui.DataBindText(txtAreaSide,null,"",1000);
    tx = new exgui.DataBindText(txtAreaPacking,null,"",300);
  }

  void setData2Fields() {
    database.datatype.Record recDetail = null;
    try {
      recDetail = (database.datatype.Record)hm.get("recDetail");
      this._shipmarkPK = recDetail.get("SHIPMARK_PK").toString();
      txtAreaMain.setText(recDetail.get("SHIPMARK_MAIN_MARK")==null?"":recDetail.get("SHIPMARK_MAIN_MARK").toString());
      txtAreaSide.setText(recDetail.get("SHIPMARK_SIDE_MARK")==null?"":recDetail.get("SHIPMARK_SIDE_MARK").toString());
      txtAreaPacking.setText(recDetail.get("SHIPMARK_PACKING")==null?"":recDetail.get("SHIPMARK_PACKING").toString());
      //cmboBuyer.setSelectedItem(recDetail.get("BYMKR_BRIEF")==null?"":recDetail.get("BYMKR_BRIEF").toString());
      buyer_maker_seqObj=recDetail.get("SHIPMARK_BYMKR_SEQ");
      /*
      if(buyer_maker_seqObj!=null){
        buyer_maker_seqObj=new java.math.BigDecimal(buyer_maker_seqObj.toString());
      }*/

    } catch (Exception e) {
      e.printStackTrace();
      util.ExceptionLog.exp2File(e, "error at set datas to fields."+recDetail.toString());
    }
  }
}
