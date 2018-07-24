package newtimes.bank;

import java.awt.*;
import exgui.*;
import javax.swing.*;
import java.awt.event.*;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class PnlQryBankHead extends JPanel {
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel1 = new BlueBkgWhiteCharLabel();
  JButton btnQry = new JButton();
  JButton btnAddNew = new JButton();
  JButton btnExit = new JButton();
  JTextField txtChkDDFrom = new JTextField();
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel6 = new BlueBkgWhiteCharLabel();
  JTextField txtAccNo = new JTextField();
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel3 = new BlueBkgWhiteCharLabel();
  JComboBox cbxBank = new JComboBox();
  JComboBox cbxCompany = new JComboBox();
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel2 = new BlueBkgWhiteCharLabel();
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel4 = new BlueBkgWhiteCharLabel();
  JTextField txtChkDDTo = new JTextField();
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel7 = new BlueBkgWhiteCharLabel();
  static database.encoders.OracleEncoder dbEncodeTyp=new database.encoders.OracleEncoder();
  public PnlQryBankHead() {
    try {
      jbInit();
    }
    catch(Exception e) {
      e.printStackTrace();
    }
  }

  public PnlQryBankHead(LayoutManager p0, boolean p1) {
    super(p0, p1);
  }

  public PnlQryBankHead(LayoutManager p0) {
    super(p0);
  }

  public PnlQryBankHead(boolean p0) {
    super(p0);
  }
  private void jbInit() throws Exception {
    blueBkgWhiteCharLabel1.setText("QUERY FOR BANK HEAD");
    blueBkgWhiteCharLabel1.setBounds(new Rectangle(2, 24, 797, 25));
    this.setLayout(null);
    btnQry.setBounds(new Rectangle(124, 499, 124, 23));
    btnQry.setFont(new java.awt.Font("Dialog", 1, 11));
    btnQry.setText("EXTRACT");
    btnQry.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnQry_actionPerformed(e);
      }
    });
    btnAddNew.setBounds(new Rectangle(315, 496, 109, 26));
    btnAddNew.setFont(new java.awt.Font("Dialog", 1, 11));
    btnAddNew.setText("NEW");
    btnAddNew.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnAddNew_actionPerformed(e);
      }
    });
    btnExit.setBounds(new Rectangle(496, 497, 110, 23));
    btnExit.setFont(new java.awt.Font("Dialog", 1, 11));
    btnExit.setText("EXIT");
    btnExit.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnExit_actionPerformed(e);
      }
    });
    this.setBackground(new Color(202, 202, 224));
    txtChkDDFrom.setBounds(new Rectangle(329, 315, 94, 23));
    txtChkDDFrom.setText("jTextField1");
    txtChkDDFrom.setText("");
    blueBkgWhiteCharLabel6.setText("CHK_DD:");
    blueBkgWhiteCharLabel6.setBounds(new Rectangle(167, 315, 162, 23));
    txtAccNo.setText("");
    txtAccNo.setBounds(new Rectangle(328, 223, 233, 23));
    blueBkgWhiteCharLabel3.setBounds(new Rectangle(167, 142, 162, 23));
    blueBkgWhiteCharLabel3.setText("BANK:");
    cbxBank.setBounds(new Rectangle(327, 142, 233, 22));
    cbxCompany.setBounds(new Rectangle(330, 62, 235, 22));
    blueBkgWhiteCharLabel2.setText("COMPANY:");
    blueBkgWhiteCharLabel2.setBounds(new Rectangle(167, 62, 162, 23));
    blueBkgWhiteCharLabel4.setBounds(new Rectangle(167, 223, 162, 23));
    blueBkgWhiteCharLabel4.setText("ACCOUNT NO:");
    txtChkDDTo.setText("");
    txtChkDDTo.setText("");
    txtChkDDTo.setBounds(new Rectangle(457, 315, 109, 23));
    blueBkgWhiteCharLabel7.setBounds(new Rectangle(422, 315, 37, 23));
    blueBkgWhiteCharLabel7.setText("~");
    this.add(blueBkgWhiteCharLabel1, null);
    this.add(btnQry, null);
    this.add(btnExit, null);
    this.add(txtAccNo, null);
    this.add(blueBkgWhiteCharLabel3, null);
    this.add(cbxBank, null);
    this.add(cbxCompany, null);
    this.add(blueBkgWhiteCharLabel2, null);
    this.add(blueBkgWhiteCharLabel4, null);
    this.add(blueBkgWhiteCharLabel6, null);
    this.add(txtChkDDFrom, null);
    this.add(txtChkDDTo, null);
    this.add(blueBkgWhiteCharLabel7, null);
    if(util.PublicVariable.USER_RECORD.getInt(2)==
      newtimesejb.preproduction.PreProductionHead.USER_TYPE_SUPERVIOSER_MIS||
      util.PublicVariable.USER_RECORD.getInt(2)==
      newtimesejb.preproduction.PreProductionHead.USER_TYPE_ACCOUNTING_USERS
      ){
     this.add(btnAddNew, null);//only MIS allow to use add new function.
    }
    genGui();
  }
  protected void genGui(){
      try{
        java.util.Vector vctCompany=Constants.vctCompany;
        DbJcbxcbxCompany =
            new exgui.DataBindJCombobox(cbxCompany,
                                        "COMP_ID",
                                        vctCompany,
                                        "COMPANY_NAME",
                                        "COMPANY_CODE",null,"ALL",null);

        java.util.Vector vctBanks=Constants.vctBank;
        DbJcbxcbxBank =
            new exgui.DataBindJCombobox(cbxBank,"BANK_ID",
                                        vctBanks,"BANK_NAME","BANK_CODE",null,
                                        "ALL",null);

        Object vftxtAccNo=exgui.verification.CellFormat.getOrdinaryField(15);
         new exgui.DataBindTextWithChecker(txtAccNo,"ACCT_NO",
             null,15,(exgui.Object2String)vftxtAccNo,
             (exgui.ultratable.CellTxtEditorFormat)vftxtAccNo);




        Object vftxtChkDD=RocDateFormator.getRocDateFormat();
      dbTxtChkDDFrom=  new exgui.DataBindTextWithChecker(
             txtChkDDFrom,"CHK_DD>=",
              null,9,
             (exgui.Object2String)vftxtChkDD,
             (exgui.ultratable.CellTxtEditorFormat)vftxtChkDD);

        dbTxtChkDDTo=   new exgui.DataBindTextWithChecker(
                txtChkDDTo,"CHK_DD<=",
                null,9,
                (exgui.Object2String)vftxtChkDD,
                (exgui.ultratable.CellTxtEditorFormat)vftxtChkDD);

      }catch(Exception exp){
        exp.printStackTrace();
      }
    }

  exgui.DataBindJCombobox   DbJcbxcbxCompany,DbJcbxcbxBank;
  exgui.DataBindTextWithChecker dbTxtChkDDFrom,dbTxtChkDDTo;

  protected java.util.HashMap getConditions(){
    java.util.HashMap hm=new java.util.HashMap();
    StringBuffer sb=new StringBuffer();
    sb.append("select * from bank_head where record_delete_flag='1' ");
    if(DbJcbxcbxCompany.getSelectedValue()!=null){
      sb.append(" and ");
      sb.append(DbJcbxcbxCompany.getOrgRecField());
      sb.append(" ='");
      sb.append(DbJcbxcbxCompany.getSelectedValue());
      sb.append("' ");
    }
    if(DbJcbxcbxBank.getSelectedValue()!=null){
      sb.append(" and ");
      sb.append(DbJcbxcbxBank.getOrgRecField());sb.append(" ='");
      sb.append(DbJcbxcbxBank.getSelectedValue());sb.append("' ");
    }
    if(txtAccNo.getText().trim().length()>0){
      sb.append(" and ");
      sb.append("ACCT_NO");
      sb.append(" like '");
      sb.append(txtAccNo.getText().trim().toUpperCase());
      sb.append("%' ");
    }
    Object objDDFrom=dbTxtChkDDFrom.getSelectedValue();
    Object objDDTo=dbTxtChkDDTo.getSelectedValue();
    if(objDDFrom!=null){
      java.sql.Date d1=new java.sql.Date(((java.util.Date)objDDFrom).getTime());
      java.util.Date datafrom=
      util.MiscFunc.toDate000000(util.MiscFunc.getYear(d1),
                                 util.MiscFunc.getMonth(d1),
                                 util.MiscFunc.getDay(d1));
     sb.append(" and ");
     sb.append(" CHK_DD >=");
     sb.append(dbEncodeTyp.encode(datafrom));
    }
    if(objDDTo!=null){
      java.sql.Date d1=new java.sql.Date(((java.util.Date)objDDTo).getTime());
      java.util.Date dataTo=
      util.MiscFunc.toDate235959(util.MiscFunc.getYear(d1),
                                 util.MiscFunc.getMonth(d1),
                                 util.MiscFunc.getDay(d1));

      sb.append(" and ");
      sb.append(" CHK_DD <=");
      sb.append(dbEncodeTyp.encode(dataTo));
    }
    sb.append(" order by COMP_ID ");
    hm.put("BANK_QRY_STRING",sb.toString());
    return hm;
  }
  void btnQry_actionPerformed(ActionEvent e) {
    try{
      java.util.HashMap hm=getConditions();
      if(hm==null)return;
      Constants.BEGIN_POSITION_OF_BANK_HEAD_QRY=0;
      processhandler.template.Properties.getCenteralControler().
          setDataProcesser(null);
      processhandler.template.Properties.getCenteralControler().doCommandExecute(
      new TgrListBankHead(hm));
    }catch(Exception exp){
      exp.printStackTrace();
    }

  }

  void btnAddNew_actionPerformed(ActionEvent e) {
    try{
      processhandler.template.Properties.getCenteralControler().
          setDataProcesser(null);
      Constants.CURRENT_EDITING_BANK_HEAD_RECORD=(new DbBankHead()).getBlankRecord();
      processhandler.template.Properties.getCenteralControler().doCommandExecute(
      new TgrEditBankHead());
    }catch(Exception exp){
      exp.printStackTrace();
    }

  }

  void btnExit_actionPerformed(ActionEvent e) {
    try{
      processhandler.template.Properties.getCenteralControler().
          setDataProcesser(null);
      processhandler.template.Properties.getCenteralControler().goBack();

    }catch(Exception exp){
      exp.printStackTrace();
    }

  }
}
