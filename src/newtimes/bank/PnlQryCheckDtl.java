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

public class PnlQryCheckDtl extends JPanel {
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel1 = new BlueBkgWhiteCharLabel();
  JButton btnExit = new JButton();
  JButton btnQry = new JButton();
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel5 = new BlueBkgWhiteCharLabel();
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel7 = new BlueBkgWhiteCharLabel();
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel4 = new BlueBkgWhiteCharLabel();
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel8 = new BlueBkgWhiteCharLabel();
  JTextField txtIssueDateFrom = new JTextField();
  JTextField txtPayDateFrom = new JTextField();
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel10 = new BlueBkgWhiteCharLabel();
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel20 = new BlueBkgWhiteCharLabel();
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel3 = new BlueBkgWhiteCharLabel();
  JTextField txtCheckNO = new JTextField();
  JComboBox cbxBank = new JComboBox();
  JTextField txtDC = new JTextField();
  JComboBox cbxCompany = new JComboBox();
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel2 = new BlueBkgWhiteCharLabel();
  JButton btnAddNew = new JButton();
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel6 = new BlueBkgWhiteCharLabel();
  JTextField txtPayDateTo = new JTextField();
  JTextField txtIssueDateTo = new JTextField();
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel9 = new BlueBkgWhiteCharLabel();
  exgui.DataBindEditableJCombobox dbCbxPayee;
  exgui.DataBindEditableJCombobox dbCbxType;
  public PnlQryCheckDtl() {
    try {
      jbInit();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }

  void jbInit() throws Exception {
    blueBkgWhiteCharLabel1.setText("QUERY CHECK DETAILS");
    blueBkgWhiteCharLabel1.setBounds(new Rectangle(0, 23, 800, 21));
    this.setLayout(null);
    btnExit.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnExit_actionPerformed(e);
      }
    });
    btnExit.setBounds(new Rectangle(502, 521, 110, 31));
    btnExit.setFont(new java.awt.Font("Dialog", 1, 11));
    btnExit.setText("EXIT");
    btnQry.setBounds(new Rectangle(130, 521, 124, 31));
    btnQry.setFont(new java.awt.Font("Dialog", 1, 11));
    btnQry.setText("EXTRACT");
    btnQry.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnQry_actionPerformed(e);
      }
    });
    blueBkgWhiteCharLabel5.setBounds(new Rectangle(136, 243, 162, 23));
    blueBkgWhiteCharLabel5.setText("ISSUE-DD");
    blueBkgWhiteCharLabel7.setText("PAY-DD");
    blueBkgWhiteCharLabel7.setBounds(new Rectangle(137, 301, 162, 23));
    blueBkgWhiteCharLabel4.setText("CHECK NO . ");
    blueBkgWhiteCharLabel4.setBounds(new Rectangle(136, 184, 162, 23));
    blueBkgWhiteCharLabel8.setBounds(new Rectangle(136, 360, 162, 23));
    blueBkgWhiteCharLabel8.setText("D / C");
    txtIssueDateFrom.setBounds(new Rectangle(298, 243, 90, 23));
    txtIssueDateFrom.setText("");
    txtPayDateFrom.setText("");
    txtPayDateFrom.setBounds(new Rectangle(299, 301, 93, 23));
    blueBkgWhiteCharLabel10.setBounds(new Rectangle(136, 419, 162, 23));
    blueBkgWhiteCharLabel10.setText("PAYEE");
    blueBkgWhiteCharLabel3.setBounds(new Rectangle(136, 125, 162, 23));
    blueBkgWhiteCharLabel3.setText("BANK:");
    txtCheckNO.setText("");
    txtCheckNO.setBounds(new Rectangle(298, 184, 235, 23));
    cbxBank.setBounds(new Rectangle(298, 125, 235, 22));
    txtDC.setBounds(new Rectangle(297, 360, 235, 23));
    txtDC.setText("");
    cbxCompany.setBounds(new Rectangle(299, 66, 235, 22));
    cbxCompany.addItemListener(new java.awt.event.ItemListener() {
      public void itemStateChanged(ItemEvent e) {
        cbxCompany_itemStateChanged(e);
      }
    });
    blueBkgWhiteCharLabel2.setText("COMPANY:");
    blueBkgWhiteCharLabel2.setBounds(new Rectangle(136, 66, 162, 23));
    this.setBackground(new Color(202, 202, 224));
    btnAddNew.setBounds(new Rectangle(331, 521, 93, 31));
    btnAddNew.setFont(new java.awt.Font("Dialog", 1, 11));
    btnAddNew.setText("NEW");
    btnAddNew.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnAddNew_actionPerformed(e);
      }
    });
    blueBkgWhiteCharLabel6.setText("~");
    blueBkgWhiteCharLabel6.setBounds(new Rectangle(391, 301, 45, 23));
    txtPayDateTo.setBounds(new Rectangle(436, 301, 97, 23));
    txtPayDateTo.setText("");
    txtIssueDateTo.setText("");
    txtIssueDateTo.setBounds(new Rectangle(431, 243, 97, 23));
    blueBkgWhiteCharLabel9.setBounds(new Rectangle(386, 243, 45, 23));
    blueBkgWhiteCharLabel9.setText("~");
    cbxPayeeItem.addItemListener(new java.awt.event.ItemListener() {
      public void itemStateChanged(ItemEvent e) {
        cbxPayeeItem_itemStateChanged(e);
      }
    });

    cbxPayeeItem.setEditable(true);
    cbxPayeeItem.setBounds(new Rectangle(297, 419, 235, 22));
    cbxType.setBounds(new Rectangle(297, 460, 235, 22));
     cbxType.setEditable(true);
    blueBkgWhiteCharLabel20.setBounds(new Rectangle(136, 460, 162, 23));
    blueBkgWhiteCharLabel20.setText("TYPE");
    this.add(blueBkgWhiteCharLabel1, null);
    this.add(blueBkgWhiteCharLabel5, null);
    this.add(blueBkgWhiteCharLabel4, null);
    this.add(blueBkgWhiteCharLabel8, null);
    this.add(blueBkgWhiteCharLabel10, null);
    this.add(blueBkgWhiteCharLabel20, null);
    this.add(blueBkgWhiteCharLabel3, null);
    this.add(cbxCompany, null);
    this.add(blueBkgWhiteCharLabel2, null);
    this.add(btnQry, null);
    this.add(btnExit, null);
    this.add(btnAddNew, null);
    this.add(blueBkgWhiteCharLabel7, null);
    this.add(txtDC, null);
    this.add(txtPayDateFrom, null);
    this.add(blueBkgWhiteCharLabel6, null);
    this.add(txtPayDateTo, null);
    this.add(txtIssueDateFrom, null);
    this.add(blueBkgWhiteCharLabel9, null);
    this.add(txtIssueDateTo, null);
    this.add(txtCheckNO, null);
    this.add(cbxBank, null);
    this.add(cbxPayeeItem, null);
    this.add(cbxType, null);
    genGui();
  }
  protected void genGui(){
      try{
        java.util.Vector vctCompany = Constants.vctCompany;
        Object vftxtChkDD=RocDateFormator.getRocDateFormat();
        DbJcbxcbxCompany =
            new exgui.DataBindJCombobox(cbxCompany,
                                        "COMP_ID",
                                        vctCompany,
                                        "COMPANY_NAME",
                                        "COMPANY_CODE", null, "ALL", null);

        java.util.Vector vctBanks = Constants.vctBank;
        DbJcbxcbxBank =
            new exgui.DataBindJCombobox(cbxBank, "BANK_ID",
                                        vctBanks, "BANK_NAME", "BANK_CODE", null,
                                        "ALL", null);

      Object vftxtCheckNO = exgui.verification.CellFormat.getOrdinaryField(10);
        new exgui.DataBindTextWithChecker(txtCheckNO, "CHK_NO",
            null, 10,
            (exgui.Object2String)vftxtCheckNO,
                          (exgui.ultratable.CellTxtEditorFormat)vftxtCheckNO);

      dbTxtIssueDateFrom= new exgui.DataBindTextWithChecker(txtIssueDateFrom,
            "ISSUE_DATE",
            null, 9,
            (exgui.Object2String)vftxtChkDD,
                          (exgui.ultratable.CellTxtEditorFormat)vftxtChkDD);
      dbTxtIssueDateTo= new exgui.DataBindTextWithChecker(txtIssueDateTo,
                           "ISSUE_DATE", null, 9,
                            (exgui.Object2String)vftxtChkDD,
                            (exgui.ultratable.CellTxtEditorFormat)vftxtChkDD);


      dbTxtPayDateFrom= new exgui.DataBindTextWithChecker(txtPayDateFrom,
                              "ISSUE_DATE",
                              null, 9,
                              (exgui.Object2String)vftxtChkDD,
                              (exgui.ultratable.CellTxtEditorFormat)vftxtChkDD);
      dbTxtPayDateTo= new exgui.DataBindTextWithChecker(txtPayDateTo,
                         "ISSUE_DATE", null, 9,
                         (exgui.Object2String)vftxtChkDD,
                         (exgui.ultratable.CellTxtEditorFormat)vftxtChkDD);

       dbCbxPayee  = new exgui.DataBindEditableJCombobox(cbxPayeeItem,"PAYEE",Constants.VCT_PAYEE_ITEMS,
                                                               "ITEM_NAME","ITEM_NAME",null,25);

       dbCbxType  = new exgui.DataBindEditableJCombobox(cbxType,"TYPE4USD",Constants.VCT_TYPE4USD,
                                                               "TYPE","TYPE",null,4);

        //Object vftxtDC = exgui.verification.CellFormat.getOrdinaryFieldNotAllowNull(1);
        Object vftxtDC = exgui.verification.CellFormat.getOrdinaryField(1);
            new exgui.DataBindTextWithChecker(
            txtDC, "D_C",
            null, 1,
            (exgui.Object2String)vftxtDC,
            (exgui.ultratable.CellTxtEditorFormat)vftxtDC);

      }catch(Exception exp){
        exp.printStackTrace();
      }
  }
  exgui.DataBindJCombobox DbJcbxcbxCompany,DbJcbxcbxBank;
  exgui.DataBindTextWithChecker dbTxtIssueDateFrom,dbTxtIssueDateTo,dbTxtPayDateFrom,dbTxtPayDateTo;
  static database.encoders.OracleEncoder dbEncodeTyp=new database.encoders.OracleEncoder();
  JComboBox cbxPayeeItem = new JComboBox();
  JComboBox cbxType = new JComboBox();
  protected java.util.HashMap genCondition(){
    java.util.HashMap hm=new java.util.HashMap();
    if(txtDC.getText().trim().length()>0 &&
    (!(txtDC.getText().trim().equalsIgnoreCase("D")||txtDC.getText().trim().equalsIgnoreCase("C")))){
      exgui.verification.VerifyLib.showAlert("C/D field Value should be \"C\" OR \"D\"",
                                             "C/D field value invalid.");
      txtDC.grabFocus();
      return null;
    }

    StringBuffer sb=new StringBuffer();
    sb.append("select * from BANK_CHK_DETAIL where record_delete_flag='1' ");
    if(txtDC.getText().trim().length()>0){
      sb.append(" and ");
      sb.append(" D_C='");sb.append(txtDC.getText().toUpperCase().trim());
      sb.append("' ");
    }
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
    if(txtCheckNO.getText().trim().length()>0){
      sb.append(" and ");
      sb.append("CHK_NO");
      sb.append(" like '");
      sb.append(txtCheckNO.getText().trim().toUpperCase());
      sb.append("%' ");
    }
    if(dbCbxPayee.getSelectedValue()!=null && dbCbxPayee.getSelectedValue().toString().trim().length() >0){
      sb.append(" and ");
      sb.append("PAYEE");
      sb.append(" like '");
      sb.append(util.MiscFunc.Replace(dbCbxPayee.getSelectedValue().toString().trim().toUpperCase(),"'","''"));
      sb.append("%' ");
    }
    if(dbCbxType.getSelectedValue()!=null && dbCbxType.getSelectedValue().toString().trim().length() >0){
      sb.append(" and ");
      sb.append("TYPE4USD");
      sb.append(" = '");
      sb.append(util.MiscFunc.Replace(dbCbxType.getSelectedValue().toString().trim().toUpperCase(),"'","''"));
      sb.append("' ");
    }



    Object objDDFrom=dbTxtIssueDateFrom.getSelectedValue();
    Object objDDTo=dbTxtIssueDateTo.getSelectedValue();
    if(objDDFrom!=null){
      java.sql.Date d1=new java.sql.Date(((java.util.Date)objDDFrom).getTime());
      java.util.Date datafrom=
      util.MiscFunc.toDate000000(util.MiscFunc.getYear(d1),
                                 util.MiscFunc.getMonth(d1),
                                 util.MiscFunc.getDay(d1));
     sb.append(" and ");
     sb.append(" ISSUE_DATE >=");
     sb.append(dbEncodeTyp.encode(datafrom));
    }
    if(objDDTo!=null){
      java.sql.Date d1=new java.sql.Date(((java.util.Date)objDDTo).getTime());
      java.util.Date dataTo=
      util.MiscFunc.toDate235959(util.MiscFunc.getYear(d1),
                                 util.MiscFunc.getMonth(d1),
                                 util.MiscFunc.getDay(d1));

      sb.append(" and ");
      sb.append(" ISSUE_DATE <=");
      sb.append(dbEncodeTyp.encode(dataTo));
    }

    Object objPayDDFrom=dbTxtPayDateFrom.getSelectedValue();
    Object objPayDDTo=dbTxtPayDateTo.getSelectedValue();
    if(objPayDDFrom!=null){
      java.sql.Date d1=new java.sql.Date(((java.util.Date)objPayDDFrom).getTime());
      java.util.Date datafrom=
      util.MiscFunc.toDate000000(util.MiscFunc.getYear(d1),
                                 util.MiscFunc.getMonth(d1),
                                 util.MiscFunc.getDay(d1));
     sb.append(" and ");
     sb.append(" PAY_DD >=");
     sb.append(dbEncodeTyp.encode(datafrom));
    }
    if(objPayDDTo!=null){
      java.sql.Date d1=new java.sql.Date(((java.util.Date)objPayDDTo).getTime());
      java.util.Date dataTo=
      util.MiscFunc.toDate235959(util.MiscFunc.getYear(d1),
                                 util.MiscFunc.getMonth(d1),
                                 util.MiscFunc.getDay(d1));

      sb.append(" and ");
      sb.append(" PAY_DD <=");
      sb.append(dbEncodeTyp.encode(dataTo));
    }
    sb.append(" order by bank_chk_pk ");
    hm.put("BANK_CHK_DTL_QRY_STRING",sb.toString());
    return hm;

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
  void btnQry_actionPerformed(ActionEvent e) {
    java.util.HashMap hm=genCondition();
    if(hm==null)return;
    try{
      processhandler.template.Properties.getCenteralControler().
          setDataProcesser(null);
      Constants.BEGIN_POSITION_OF_BANK_CHK_DTL_QRY=0;
      processhandler.template.Properties.getCenteralControler().doCommandExecute(
      new TgrListChkDtl(hm));
    }catch(Exception exp){
      exp.printStackTrace();
    }

  }
  void cbxCompany_itemStateChanged(ItemEvent e) {

  }

  void btnAddNew_actionPerformed(ActionEvent e) {
    try{
      processhandler.template.Properties.getCenteralControler().
          setDataProcesser(null);

      processhandler.template.Properties.getCenteralControler().doCommandExecute(
      new TgrToAddMultiBankCheckDtl());

      /*
      Constants.CURRENT_EDITING_BANK_CHK_DTL_RECORD=(new DbBankCheckHandler()).getBlankRecord();
      processhandler.template.Properties.getCenteralControler().doCommandExecute(
      new TgrEditBankChkDtl());
      */
    }catch(Exception exp){
      exp.printStackTrace();
    }
  }
  void cbxPayeeItem_itemStateChanged(ItemEvent e) {

  }
}
