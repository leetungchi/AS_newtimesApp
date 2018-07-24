package newtimes.basic.offshore_rule;

import java.awt.*;
import exgui.*;
import javax.swing.*;
import newtimes.preproduction.buyermakerselect.*;
import java.awt.event.*;
import java.util.*;
/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class PnlQryOffShoreRule extends JPanel {
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel1 = new BlueBkgWhiteCharLabel();
  JButton btnQry = new JButton();
  JButton btnExit = new JButton();
  JButton btnAdd = new JButton();
  WhiteBkgBlueCharLabel whiteBkgBlueCharLabel1 = new WhiteBkgBlueCharLabel();
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel2 = new BlueBkgWhiteCharLabel();
  JComboBox cbxCenterBuyer = new JComboBox();
  JComboBox cbxCenterMaker = new JComboBox();
  SelectBuyerMaker slkBuyer = new SelectBuyerMaker();
  SelectBuyerMaker slkMaker = new SelectBuyerMaker();
  JComboBox cbxCenter = new JComboBox();
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel3 = new BlueBkgWhiteCharLabel();
  JComboBox cbxCountry = new JComboBox();
  WhiteBkgBlueCharLabel whiteBkgBlueCharLabel2 = new WhiteBkgBlueCharLabel();
  exgui.DataBindJCombobox dbCBX_BuyerCenter,dbCBX_MakerCenter,dbCBX_Center,DbJcbxcbxQcCountry;
  public PnlQryOffShoreRule() {
    try {
      jbInit();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }

  void jbInit() throws Exception {
    blueBkgWhiteCharLabel1.setText("Offshore Rule  Maintain--Query");
    blueBkgWhiteCharLabel1.setBounds(new Rectangle(-4, 22, 799, 26));
    this.setLayout(null);
    btnQry.setBounds(new Rectangle(117, 531, 154, 26));
    btnQry.setFont(new java.awt.Font("Dialog", 1, 11));
    btnQry.setText("QUERY");
    btnQry.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnQry_actionPerformed(e);
      }
    });
    btnExit.setText("EXIT");
    btnExit.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnExit_actionPerformed(e);
      }
    });
    btnExit.setBounds(new Rectangle(535, 531, 154, 26));
    btnExit.setFont(new java.awt.Font("Dialog", 1, 11));
    btnExit.setForeground(Color.red);
    btnAdd.setText("ADD");
    btnAdd.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnAdd_actionPerformed(e);
      }
    });
    btnAdd.setFont(new java.awt.Font("Dialog", 1, 11));
    btnAdd.setBounds(new Rectangle(330, 531, 154, 26));
    this.setBackground(new Color(204, 204, 225));
    whiteBkgBlueCharLabel1.setText("BUYER");
    whiteBkgBlueCharLabel1.setBounds(new Rectangle(131, 135, 114, 25));
    blueBkgWhiteCharLabel2.setText("MAKER");
    blueBkgWhiteCharLabel2.setBounds(new Rectangle(131, 182, 117, 25));
    cbxCenterBuyer.setBounds(new Rectangle(246, 134, 167, 25));
    cbxCenterMaker.setBounds(new Rectangle(246, 182, 167, 26));

    slkBuyer.setBounds(new Rectangle(413, 134, 250, 25));
    slkMaker.setBounds(new Rectangle(413, 182, 250, 25));
    cbxCenter.setBounds(new Rectangle(246, 285, 167, 26));
    blueBkgWhiteCharLabel3.setBounds(new Rectangle(131, 285, 117, 25));
    blueBkgWhiteCharLabel3.setText("CENTER");
    cbxCountry.setBounds(new Rectangle(246, 237, 167, 25));
    whiteBkgBlueCharLabel2.setBounds(new Rectangle(131, 238, 114, 25));
    whiteBkgBlueCharLabel2.setText("COUNTRY");
    this.add(blueBkgWhiteCharLabel1, null);
    this.add(btnExit, null);
    this.add(btnQry, null);
    this.add(btnAdd, null);
    this.add(cbxCenterMaker, null);
    this.add(whiteBkgBlueCharLabel1, null);
    this.add(cbxCenterBuyer, null);
    this.add(slkBuyer, null);
    this.add(blueBkgWhiteCharLabel2, null);
    this.add(slkMaker, null);
    this.add(cbxCenter, null);
    this.add(blueBkgWhiteCharLabel3, null);
    this.add(cbxCountry, null);
    this.add(whiteBkgBlueCharLabel2, null);

    slkBuyer.init("BUYER_ID",null,slkBuyer.TYPE_BUYER,true);
    slkMaker.init("MAKER_ID",null,slkBuyer.TYPE_MAKER,true);

    java.util.Vector centRecords=
        exgui2.CONST.BASIC_MAIN_EJB.getDatas(
        util.PublicVariable.USER_RECORD,
        "select * from center ",1,9999);

    dbCBX_Center= new exgui.DataBindJCombobox(
          cbxCenter,"CENTER",
          centRecords,"CEN_NAME",
          "CEN_CODE",
          null,"ALL",null);

    dbCBX_BuyerCenter= new exgui.DataBindJCombobox(
          cbxCenterBuyer,"CENTER",
          centRecords,"CEN_NAME",
          "CEN_CODE",
          util.PublicVariable.OPERATTING_CENTER);


    dbCBX_MakerCenter= new exgui.DataBindJCombobox(
            cbxCenterMaker,"CENTER",
            centRecords,"CEN_NAME",
            "CEN_CODE",
            null);

   /*
   Vector vctCountry=(Vector)util.MiscFunc.deepCopy(newtimes.preproduction.guis.tempProperties.tmpCountries);
   database.datatype.Record recCnty=(database.datatype.Record)util.MiscFunc.deepCopy(newtimes.preproduction.guis.tempProperties.tmpCountries.get(0));
   recCnty.set("CNTY_NAME",null);
   */
    DbJcbxcbxQcCountry =
       new exgui.DataBindJCombobox(cbxCountry,
                                   "COUNTRY",
                                   newtimes.preproduction.guis.tempProperties.tmpCountries,
                                   "CNTY_NAME", "CNTY_NAME",
                                   null,
                                   "ALL",null
                                   );

   cbxCenterBuyer.addItemListener(new java.awt.event.ItemListener() {
     public void itemStateChanged(ItemEvent e) {
       cbxCenterBuyer_itemStateChanged(e);
     }
   });
   cbxCenterMaker.addItemListener(new java.awt.event.ItemListener() {
     public void itemStateChanged(ItemEvent e) {
       cbxCenterMaker_itemStateChanged(e);
     }
   });


  }

  void cbxCenterBuyer_itemStateChanged(ItemEvent e) {
     slkBuyer.setSelectingCenter((String)dbCBX_BuyerCenter.getSelectedValue());
     slkBuyer.init("BUYER_ID",null,slkBuyer.TYPE_BUYER,true);
  }

  void cbxCenterMaker_itemStateChanged(ItemEvent e) {
    slkMaker.setSelectingCenter((String)dbCBX_MakerCenter.getSelectedValue());
    slkMaker.init("MAKER_ID",null,slkBuyer.TYPE_MAKER,true);
  }

  void btnExit_actionPerformed(ActionEvent e) {
    ToDoAxn.Exit2BasiIIFunc();
  }

  void btnQry_actionPerformed(ActionEvent e) {
     ToDoAxn.ShowListGUI();
  }

  void btnAdd_actionPerformed(ActionEvent e) {
    try{
      database.datatype.Record recBlank = exgui2.CONST.BASIC_MAIN_EJB.
          getBlankRecord("unit_tbl");
      recBlank.getFieldName().clear();
      recBlank.getValueFields().clear();
      /*
         BUYER_ID            NUMBER                    NOT NULL,
         MAKER_ID            NUMBER                    NOT NULL,
         COUNTRY             VARCHAR2(60)              NOT NULL,
         CENTER              VARCHAR2(5)               NOT NULL,
         RECORD_CREATE_USER  VARCHAR2(20),
         RECORD_CREATE_DATE  DATE                      DEFAULT SYSDATE               NOT NULL,
         RECORD_DELETE_FLAG  CHAR(1)                   DEFAULT '1'                   NOT NULL,
         RECORD_DELETE_USER  VARCHAR2(20),
         RECORD_MODIFY_USER  VARCHAR2(20),
         RECORD_MODIFY_DATE  DATE,
         RULE_SEQ            NUMBER                    NOT NULL
       */
      recBlank.getFieldName().add("BUYER_ID");recBlank.getValueFields().add(null);
      recBlank.getFieldName().add("MAKER_ID");recBlank.getValueFields().add(null);
      recBlank.getFieldName().add("COUNTRY");recBlank.getValueFields().add("CHINA");
      recBlank.getFieldName().add("CENTER");recBlank.getValueFields().add("003");
      recBlank.getFieldName().add("RECORD_CREATE_USER");recBlank.getValueFields().add(null);
      recBlank.getFieldName().add("RECORD_CREATE_DATE");recBlank.getValueFields().add(new java.sql.Date(System.currentTimeMillis()));
      recBlank.getFieldName().add("RECORD_DELETE_FLAG");recBlank.getValueFields().add("-1");
      recBlank.getFieldName().add("RECORD_DELETE_USER");recBlank.getValueFields().add(null);
      recBlank.getFieldName().add("RECORD_MODIFY_USER");recBlank.getValueFields().add(null);
      recBlank.getFieldName().add("RECORD_MODIFY_DATE");recBlank.getValueFields().add(null);
      recBlank.getFieldName().add("RULE_SEQ");recBlank.getValueFields().add("001971");
      recBlank.set("RECORD_CREATE_USER",util.PublicVariable.USER_RECORD.get(0));
      DlgEditRule dlg= new DlgEditRule(util.PublicVariable.APP_FRAME,"EDIT RULE",true,recBlank);
      dlg.setSize(550,290);
      exgui.UIHelper.setToScreenCenter(dlg);
      dlg.show();


    }catch(Exception exp){

    }

  }

}
