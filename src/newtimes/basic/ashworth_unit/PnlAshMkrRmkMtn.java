package newtimes.basic.ashworth_unit;

import java.awt.*;
import javax.swing.*;
import newtimes.preproduction.buyermakerselect.*;
import exgui.*;
import javax.swing.border.*;
import java.awt.event.*;
import java.util.*;
import database.datatype.Record;
/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class PnlAshMkrRmkMtn
    //extends JPanel {
    extends processhandler.template.PnlFieldsEditor{
  JButton btnExit = new JButton();
  JLabel lblSeason = new JLabel();
  JButton btnAddNew = new JButton();
  JComboBox cbxUser = new JComboBox();
  JComboBox cbxDiv = new JComboBox();
  JLabel lblYear = new JLabel();
  JTextField txtYear = new JTextField();
  JLabel lblUser = new JLabel();
  JComboBox cbxSzn = new JComboBox();
  SelectBuyerMaker slkMaker = new SelectBuyerMaker();
  JLabel lblMaker = new JLabel();
  JLabel lblDivision = new JLabel();
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel1 = new BlueBkgWhiteCharLabel();
  JPanel pnlRemark = new JPanel();
  BorderLayout borderLayout1 = new BorderLayout();
  Border border1;
  JScrollPane jScrollPane1 = new JScrollPane();
  JTextArea txtRemark = new JTextArea();
  DataBindJCombobox DbJcbxcbxSzn,DbJcbxcbxDiv,DbJcbxcbxUser;
  DataBindTextWithChecker dbTxtYear;
  Vector vctDiv=null;
  Vector vctUser=null;
  JButton btnDelete = new JButton();

  public PnlAshMkrRmkMtn() {
    try {
      jbInit();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }
  public void record2Gui(){
    try{
      super.dataBoundGUIs.clear();
      Object vftxtYear = exgui.verification.CellFormat.
          getOrdinaryFieldNotAllowNull(10);
      dbTxtYear = new exgui.DataBindTextWithChecker(
          txtYear, "YEAR",
          recToMapping.get("YEAR"), 10,
          (exgui.Object2String)vftxtYear,
          (exgui.ultratable.CellTxtEditorFormat)vftxtYear);
      dataBoundGUIs.add(dbTxtYear);

      Object vftxtREmark = exgui.verification.CellFormat.
          getOrdinaryFieldNotAllowNull(1000);
     DataBindText  dbTxtRemark= new exgui.DataBindTextWithChecker(
          txtRemark, "REMARK",
          recToMapping.get("REMARK"), 1000,
          (exgui.Object2String)vftxtREmark,
          (exgui.ultratable.CellTxtEditorFormat)vftxtREmark);
      dataBoundGUIs.add(dbTxtRemark);
      Object objRemark=recToMapping.get("REMARK");
      txtRemark.setText(objRemark==null?"":objRemark.toString());

      DbJcbxcbxSzn =
          new exgui.DataBindJCombobox
          (cbxSzn, "SEASON",
           newtimes.preproduction.guis.tempProperties.tmpSeason,
           "SEA_NAME", "SEA_NAME",
           recToMapping.get("SEASON"), "ALL",
           null);
     dataBoundGUIs.add(DbJcbxcbxSzn);
      vctDiv=newtimes.basic.ashworth_unit.PnlAshMkrRmkFunc.vctDiv;
      DbJcbxcbxDiv =
          new exgui.DataBindJCombobox(cbxDiv,
                                      "DIV_CODE",
                                      vctDiv,
                                      "DIV_NAME",
                                      "DIV_CODE",
                                      recToMapping.get("DIV_CODE"), "ALL", null);
      dataBoundGUIs.add(DbJcbxcbxDiv);

      slkMaker.init("MKR_SEQ", recToMapping.get("MKR_SEQ"), slkMaker.TYPE_MAKER, true);
      dataBoundGUIs.add(slkMaker);

      Vector users=newtimes.basic.ashworth_unit.PnlAshMkrRmkFunc.users;

      DbJcbxcbxUser =
          new exgui.DataBindJCombobox
          (cbxUser,"USR",users,
           "NAME","NAME",
           recToMapping.get("USR"),"ALL",
           null);
      dataBoundGUIs.add(DbJcbxcbxUser);
      if(recToMapping.getInt(0)<1){
        btnAddNew.setText("ADD");
        btnDelete.setEnabled(false);
      }else{
        btnAddNew.setText("CONFIRM EDIT");
      }
    }catch(Exception exdp){
      exdp.printStackTrace();
    }
  }
  public void doPrint(){

  }
  public void jbInit() throws Exception {
    setSize(800,600);
    this.setBackground(new Color(202, 202, 224));
    setPreferredSize(new Dimension(800,600));

    border1 = new TitledBorder(new EtchedBorder(EtchedBorder.RAISED,Color.white,new Color(134, 134, 134)),"REMARK");
    lblDivision.setBounds(new Rectangle(407, 190, 74, 22));
    lblDivision.setText("DIVISION");
    lblDivision.setFont(new java.awt.Font("Dialog", 1, 11));
    lblMaker.setBounds(new Rectangle(404, 159, 74, 22));
    lblMaker.setText("MAKER");
    lblMaker.setFont(new java.awt.Font("Dialog", 1, 11));
    slkMaker.setBounds(new Rectangle(484, 159, 153, 22));
    cbxSzn.setBounds(new Rectangle(484, 130, 153, 22));
    lblUser.setFont(new java.awt.Font("Dialog", 1, 11));
    lblUser.setText("USER");
    lblUser.setBounds(new Rectangle(152, 159, 74, 22));
    txtYear.setBounds(new Rectangle(233, 130, 149, 22));
    txtYear.setText("");
    lblYear.setBounds(new Rectangle(153, 130, 74, 22));
    lblYear.setText("YEAR");
    lblYear.setFont(new java.awt.Font("Dialog", 1, 11));
    cbxDiv.setBounds(new Rectangle(487, 190, 149, 22));
    cbxUser.setBounds(new Rectangle(232, 159, 149, 22));
    btnAddNew.setFont(new java.awt.Font("Dialog", 1, 11));
    btnAddNew.setBounds(new Rectangle(205, 454, 142, 25));
    btnAddNew.setText("ADD");
    btnAddNew.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnAddNew_actionPerformed(e);
      }
    });
    lblSeason.setFont(new java.awt.Font("Dialog", 1, 11));
    lblSeason.setText("SEASON");
    lblSeason.setBounds(new Rectangle(404, 130, 74, 22));
    btnExit.setText("EXIT");
    btnExit.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnExit_actionPerformed(e);
      }
    });
    btnExit.setFont(new java.awt.Font("Dialog", 1, 11));
    btnExit.setBounds(new Rectangle(556, 454, 97, 25));
    this.setLayout(null);
    blueBkgWhiteCharLabel1.setText("ASHWORTH MAKER REMARK");
    blueBkgWhiteCharLabel1.setBounds(new Rectangle(0, 13, 800, 35));
    pnlRemark.setBorder(border1);
    pnlRemark.setBounds(new Rectangle(157, 236, 488, 181));
    pnlRemark.setLayout(borderLayout1);
    txtRemark.setText("");
    btnDelete.setBounds(new Rectangle(396, 454, 112, 25));
    btnDelete.setFont(new java.awt.Font("Dialog", 1, 11));
    btnDelete.setText("DELETE");
    btnDelete.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnDelete_actionPerformed(e);
      }
    });
    this.add(blueBkgWhiteCharLabel1, null);
    this.add(btnAddNew, null);
    this.add(pnlRemark, null);
    pnlRemark.add(jScrollPane1, BorderLayout.CENTER);
    this.add(lblYear, null);
    this.add(txtYear, null);
    this.add(lblSeason, null);
    this.add(lblMaker, null);
    this.add(cbxSzn, null);
    this.add(slkMaker, null);
    this.add(btnExit, null);
    this.add(btnDelete, null);
    //this.add(lblDivision, null);
    //this.add(cbxDiv, null);
    this.add(lblUser, null);
    this.add(cbxUser, null);
    jScrollPane1.getViewport().add(txtRemark, null);
  }

  void btnExit_actionPerformed(ActionEvent e) {
    try{
      if(super.isContextModified()){
        if(!exgui.verification.VerifyLib.showConfirm("Data Modified\nDo you really want to Exit ?","Do You Sure ?")){
          return ;
        }
      }
      doExit();
    }catch(Exception exp){
      exp.printStackTrace();
    }
    /*
    try {
      processhandler.template.Properties.getCenteralControler().goBack();
    } catch (Exception eP) {
      eP.printStackTrace();
    }*/

  }
  public boolean gui2Record(){
    boolean result=super.gui2Record();
    try{
      recToMapping.set("REMARK", txtRemark.getText().trim()); //case sensitive
    }catch(Exception exp){
      exp.printStackTrace();
    }
    return result;
  }
  void btnAddNew_actionPerformed(ActionEvent e) {
    try{
      if(recToMapping.getInt(0)<0){
        super.doAddNew();
      }else{
        super.doUpdate();
      }
      btnExit_actionPerformed(null);
    }catch(Exception exp){
      exp.printStackTrace();
    }
  }

  void btnDelete_actionPerformed(ActionEvent e) {
    try{
      if(!exgui.verification.VerifyLib.showConfirm("Do You Really Want To Delete This Record ?","Are you Sure ?")){
        return ;
      }
      doDelete();
      processhandler.template.Properties.getCenteralControler().goBack();
    }catch(Exception exp){
      exp.printStackTrace();
    }
  }
}
