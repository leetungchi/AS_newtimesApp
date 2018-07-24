package newtimes.basic.ashworth_unit;

import java.awt.*;
import exgui.*;
import javax.swing.*;
import newtimes.preproduction.buyermakerselect.*;
import java.awt.event.*;
import database.datatype.Record;
import exgui.DataBindJCombobox;
import exgui.DataBindTextWithChecker;
import java.util.*;
/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class PnlAshMkrRmkFunc extends JPanel {
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel1 = new BlueBkgWhiteCharLabel();
  JLabel lblYear = new JLabel();
  JTextField txtYear = new JTextField();
  JLabel lblSeason = new JLabel();
  JComboBox cbxSzn = new JComboBox();
  JLabel lblDivision = new JLabel();
  JComboBox cbxDiv = new JComboBox();
  JComboBox cbxUser = new JComboBox();
  JLabel lblUser = new JLabel();
  JButton btnExit = new JButton();
  JButton btnAddNew = new JButton();
  JButton btnQry = new JButton();
  SelectBuyerMaker slkMaker = new SelectBuyerMaker();
  JLabel lblMaker = new JLabel();
  DataBindJCombobox DbJcbxcbxSzn,DbJcbxcbxDiv,DbJcbxcbxUser;
  DataBindTextWithChecker dbTxtYear;
  static Vector vctDiv=null,users=null;
  public static HashMap conditions;
  public PnlAshMkrRmkFunc() {
    try {
      vctDiv=null;
      users=null;
      jbInit();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }

  void jbInit() throws Exception {
    setSize(800,600);
    this.setBackground(new Color(202, 202, 224));
    setPreferredSize(new Dimension(800,600));

    blueBkgWhiteCharLabel1.setText("ASHWORTH MAKER REMARK MAINTAIN");
    blueBkgWhiteCharLabel1.setBounds(new Rectangle(-1, 20, 802, 36));
    this.setLayout(null);
    lblYear.setFont(new java.awt.Font("Dialog", 1, 11));
    lblYear.setText("YEAR");
    lblYear.setBounds(new Rectangle(239, 89, 74, 22));
    txtYear.setText("");
    txtYear.setBounds(new Rectangle(319, 89, 149, 22));
    lblSeason.setBounds(new Rectangle(239, 125, 74, 22));
    lblSeason.setText("SEASON");
    lblSeason.setFont(new java.awt.Font("Dialog", 1, 11));
    cbxSzn.setBounds(new Rectangle(319, 125, 153, 22));
    lblDivision.setFont(new java.awt.Font("Dialog", 1, 11));
    lblDivision.setText("DIVISION");
    lblDivision.setBounds(new Rectangle(238, 223, 74, 22));
    cbxDiv.setBounds(new Rectangle(318, 223, 157, 22));
    cbxUser.setBounds(new Rectangle(319, 191, 153, 22));
    lblUser.setBounds(new Rectangle(239, 191, 74, 22));
    lblUser.setText("USER");
    lblUser.setFont(new java.awt.Font("Dialog", 1, 11));
    btnExit.setBounds(new Rectangle(518, 402, 97, 25));
    btnExit.setFont(new java.awt.Font("Dialog", 1, 11));
    btnExit.setText("EXIT");
    btnExit.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnExit_actionPerformed(e);
      }
    });
    btnAddNew.setText("ADD");
    btnAddNew.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnAddNew_actionPerformed(e);
      }
    });
    btnAddNew.setBounds(new Rectangle(359, 402, 97, 25));
    btnAddNew.setFont(new java.awt.Font("Dialog", 1, 11));
    btnQry.setText("QUERY");
    btnQry.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnQry_actionPerformed(e);
      }
    });
    btnQry.setBounds(new Rectangle(200, 402, 97, 25));
    btnQry.setFont(new java.awt.Font("Dialog", 1, 11));
    btnQry.setSelected(true);
    slkMaker.setBounds(new Rectangle(319, 155, 157, 22));
    lblMaker.setFont(new java.awt.Font("Dialog", 1, 11));
    lblMaker.setText("MAKER");
    lblMaker.setBounds(new Rectangle(239, 155, 74, 22));
    this.add(blueBkgWhiteCharLabel1, null);
    this.add(lblYear, null);
    this.add(txtYear, null);
    this.add(lblSeason, null);
    this.add(cbxSzn, null);
    this.add(btnAddNew, null);
    this.add(btnExit, null);
    this.add(btnQry, null);
    this.add(lblMaker, null);
    this.add(lblUser, null);
    this.add(cbxUser, null);
    this.add(slkMaker, null);
    //this.add(lblDivision, null);
    //this.add(cbxDiv, null);
    //data bound GUI.

  }
  protected void initDataBound(Record recInit)throws Exception{

    Object vftxtYear=exgui.verification.CellFormat.getOrdinaryField(10);
    dbTxtYear= new exgui.DataBindTextWithChecker(
               txtYear,"YEAR",
               recInit.get("YEAR"),10,
               (exgui.Object2String)vftxtYear,
               (exgui.ultratable.CellTxtEditorFormat)vftxtYear);
    DbJcbxcbxSzn =
        new exgui.DataBindJCombobox
        (cbxSzn,"SEASON",newtimes.preproduction.guis.tempProperties.tmpSeason,
         "SEA_NAME","SEA_NAME",
         recInit.get("SEASON"),"ALL",
         null);
    if(vctDiv==null){
      vctDiv=
          exgui2.CONST.BASIC_MAIN_EJB.getDatas(
          util.PublicVariable.USER_RECORD,
          "select * from division where div_bymkr_seq=82 and record_delete_flag='1'",1,9999999);
    }
    DbJcbxcbxDiv =
        new exgui.DataBindJCombobox(cbxDiv,
                                    "DIV_CODE",
                                    vctDiv,
                                    "DIV_NAME",
                                    "DIV_CODE",
                                    recInit.get("DIV_CODE"),"ALL",null);
    slkMaker.init("MKR_SEQ",null,slkMaker.TYPE_MAKER,true);

    if(users==null)users=new Vector();
    Record rec0=(Record)util.MiscFunc.deepCopy(util.PublicVariable.USER_RECORD);
    rec0.getFieldName().clear();
    rec0.getValueFields().clear();

    rec0.getFieldName().add("NAME");
    rec0.getValueFields().add("MELISA WANG KS");
    users.add(rec0);

    Record rec1=(Record)util.MiscFunc.deepCopy(rec0);
    rec1.set(0,"RICHARD KAO");
    users.add(rec1);

    Record rec2=(Record)util.MiscFunc.deepCopy(rec0);
    rec2.set(0,"GREEN KU");
    users.add(rec2);
    Record rec2_=(Record)util.MiscFunc.deepCopy(rec0);
   rec2_.set(0,"GREEN KU HA");
   users.add(rec2_);

    Record rec3=(Record)util.MiscFunc.deepCopy(rec0);
    rec3.set(0,"TRACY CHIEN");
    users.add(rec3);


    DbJcbxcbxUser =
        new exgui.DataBindJCombobox
        (cbxUser,"USR",users,
         "NAME","NAME",
         recInit.get("USR"),"ALL",
         null);



    txtYear.setText("");
  }
  void btnExit_actionPerformed(ActionEvent e) {
    try {
      processhandler.template.Properties.getCenteralControler().goBack();
    } catch (Exception eP) {
      eP.printStackTrace();
    }
    /*
    JPanel panel = new newtimes.MainFunction((newtimes.Frame1)util.PublicVariable.APP_FRAME);
    this.removeAll();
    this.add(panel, null);
    panel.setBounds(0, 0, 800, 600);
    panel.repaint();
    panel.validate();
    */
  }
  protected void composePara(){
    if(conditions==null)conditions=new HashMap();
    conditions.clear();
    conditions.put(dbTxtYear.getOrgRecField(),dbTxtYear.getSelectedValue());
    conditions.put(DbJcbxcbxSzn.getOrgRecField() ,DbJcbxcbxSzn.getSelectedValue());
    conditions.put(DbJcbxcbxDiv.getOrgRecField() ,DbJcbxcbxDiv.getSelectedValue());
    conditions.put(DbJcbxcbxUser.getOrgRecField() ,DbJcbxcbxUser.getSelectedValue());
    conditions.put(slkMaker.getOrgRecField(),slkMaker.getSelectedValue());
  }
  void btnQry_actionPerformed(ActionEvent e) {
    try {
      composePara();
      TgrListQryMkrRmk.rowStartPosition=1;
      processhandler.template.Properties.getCenteralControler().doCommandExecute(
          new newtimes.basic.ashworth_unit.TgrListQryMkrRmk());
    } catch (Exception eP) {
      eP.printStackTrace();
    }
  }

  void btnAddNew_actionPerformed(ActionEvent e) {
    try {
      processhandler.template.Properties.getCenteralControler().doCommandExecute(
         new newtimes.basic.ashworth_unit.TgrAshMkrRmkAdd()
      );
    } catch (Exception eP) {
      eP.printStackTrace();
    }

  }
}
