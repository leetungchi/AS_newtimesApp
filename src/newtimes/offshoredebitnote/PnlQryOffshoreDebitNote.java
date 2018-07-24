package newtimes.offshoredebitnote;

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

public class PnlQryOffshoreDebitNote extends JPanel {
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel1 = new BlueBkgWhiteCharLabel();
  JButton btnAddNew = new JButton();
  JButton btnExit = new JButton();
  JButton btnQry = new JButton();
  static java.util.Vector vctDep;
  static java.util.Vector vctCountry;
  JLabel jLabel1 = new JLabel();
  JComboBox cbxCountry = new JComboBox();
  JLabel jLabel2 = new JLabel();
  JComboBox cbxDep = new JComboBox();
  JLabel jLabel3 = new JLabel();
  JTextField txtDrCr = new JTextField();
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel5 = new BlueBkgWhiteCharLabel();
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel9 = new BlueBkgWhiteCharLabel();
  JTextField txDateTo = new JTextField();
  JTextField txDateFrom = new JTextField();
  exgui.DataBindJCombobox DbJcbxcbxDep,DbJcbxcbxCountry;
  exgui.DataBindTextWithChecker dbTxtDateFrom,dbTxtDateTo;
  static database.encoders.OracleEncoder dbEncodeTyp=new database.encoders.OracleEncoder();

  public PnlQryOffshoreDebitNote() {
    try {
      jbInit();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }

  void jbInit() throws Exception {
    blueBkgWhiteCharLabel1.setText("QUERY OFFSHORE DEBIT NOTES");
    blueBkgWhiteCharLabel1.setBounds(new Rectangle(0, 33, 790, 31));
    this.setLayout(null);
    btnAddNew.setBounds(new Rectangle(401, 522, 93, 26));
    btnAddNew.setFont(new java.awt.Font("Dialog", 1, 11));
    btnAddNew.setText("ADD");
    btnAddNew.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnAddNew_actionPerformed(e);
      }
    });
    btnExit.setText("EXIT");
    btnExit.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnExit_actionPerformed(e);
      }
    });
    btnExit.setBounds(new Rectangle(630, 522, 93, 26));
    btnExit.setFont(new java.awt.Font("Dialog", 1, 11));
    btnQry.setText("QUERY");
    btnQry.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnQry_actionPerformed(e);
      }
    });
    btnQry.setBounds(new Rectangle(145, 522, 93, 26));
    btnQry.setFont(new java.awt.Font("Dialog", 1, 11));
    jLabel1.setBackground(new Color(143, 143, 188));
    jLabel1.setFont(new java.awt.Font("Dialog", 1, 11));
    jLabel1.setForeground(Color.white);
    jLabel1.setOpaque(true);
    jLabel1.setHorizontalAlignment(SwingConstants.CENTER);
    jLabel1.setText("COUNTRY : ");
    jLabel1.setBounds(new Rectangle(168, 106, 113, 26));
    cbxCountry.setBounds(new Rectangle(285, 106, 273, 23));
    jLabel2.setBounds(new Rectangle(168, 143, 113, 26));
    jLabel2.setText("DEPARTMENT : ");
    jLabel2.setBackground(new Color(143, 143, 188));
    jLabel2.setFont(new java.awt.Font("Dialog", 1, 11));
    jLabel2.setForeground(Color.white);
    jLabel2.setOpaque(true);
    jLabel2.setHorizontalAlignment(SwingConstants.CENTER);
    cbxDep.setBounds(new Rectangle(285, 143, 271, 25));
    jLabel3.setBackground(new Color(143, 143, 188));
    jLabel3.setFont(new java.awt.Font("Dialog", 1, 11));
    jLabel3.setForeground(Color.white);
    jLabel3.setOpaque(true);
    jLabel3.setHorizontalAlignment(SwingConstants.CENTER);
    jLabel3.setText("DR/CR Start From : ");
    jLabel3.setBounds(new Rectangle(168, 186, 113, 26));
    txtDrCr.setText("");
    txtDrCr.setBounds(new Rectangle(285, 186, 232, 24));
    blueBkgWhiteCharLabel5.setBounds(new Rectangle(168, 251, 113, 23));
    blueBkgWhiteCharLabel5.setText("DATE");
    blueBkgWhiteCharLabel9.setBounds(new Rectangle(373, 251, 45, 23));
    blueBkgWhiteCharLabel9.setText("~");
    txDateTo.setText("");
    txDateTo.setBounds(new Rectangle(418, 251, 97, 23));
    txDateFrom.setBounds(new Rectangle(285, 251, 90, 23));
    txDateFrom.setText("");
    this.add(blueBkgWhiteCharLabel1, null);
    this.add(btnExit, null);
    this.add(btnQry, null);
    this.add(btnAddNew, null);
    this.add(jLabel1, null);
    this.add(cbxCountry, null);
    this.add(jLabel2, null);
    this.add(cbxDep, null);
    this.add(jLabel3, null);    if(vctDep==null){vctDep=exgui2.CONST.BASIC_MAIN_EJB.getDatas(
      util.PublicVariable.USER_RECORD,
      "select dep_code from OFS_DEBIT_NOTE_DEP order by dep_code",1,9999);}

    if(vctCountry==null){vctCountry=exgui2.CONST.BASIC_MAIN_EJB.getDatas(
      util.PublicVariable.USER_RECORD,
      "select cnty_pk,cnty_name from OFS_DEBIT_NOTE_COUNTRY order by cnty_name",1,9999);}


  DbJcbxcbxDep =
      new exgui.DataBindJCombobox(cbxDep,
                                  "DTL_DEP_CODE ",
                                  vctDep,
                                  "DEP_CODE",
                                  "DEP_CODE", null, "ALL", null);

  DbJcbxcbxCountry =
      new exgui.DataBindJCombobox(cbxCountry, "DTL_CNTY_PK",
                                  vctCountry, "CNTY_NAME", "CNTY_PK", null,"ALL", null);

    this.add(txtDrCr, null);
    this.add(blueBkgWhiteCharLabel5, null);
    this.add(txDateFrom, null);
    this.add(blueBkgWhiteCharLabel9, null);
    this.add(txDateTo, null);

Object vftxtNO = exgui.verification.CellFormat.getOrdinaryField(20);
  new exgui.DataBindTextWithChecker(txtDrCr, "DTL_DRCR_NO ",
      null, 10,
      (exgui.Object2String)vftxtNO,
                    (exgui.ultratable.CellTxtEditorFormat)vftxtNO);


  Object vftxtChkDD=exgui.verification.CellFormat.getDateStringFormaterAllowNull();
  dbTxtDateFrom= new exgui.DataBindTextWithChecker(txDateFrom,
        "DTL_DATE",
        null, 10,
        (exgui.Object2String)vftxtChkDD,
                      (exgui.ultratable.CellTxtEditorFormat)vftxtChkDD);
  dbTxtDateTo= new exgui.DataBindTextWithChecker(txDateTo,
                       "DTL_DATE", null, 10,
                        (exgui.Object2String)vftxtChkDD,
                        (exgui.ultratable.CellTxtEditorFormat)vftxtChkDD);


  }
  protected void genSql(){
    Object objDDFrom=dbTxtDateFrom.getSelectedValue();
    Object objDDTo=dbTxtDateTo.getSelectedValue();
    StringBuffer sb=new StringBuffer();

    sb.append("select * from OFS_DEBIT_NOTE_DTL where record_delete_flag='1' ");
    if(DbJcbxcbxDep.getSelectedValue()!=null){
      sb.append(" and ");
      sb.append(DbJcbxcbxDep.getOrgRecField());
      sb.append(" ='");
      sb.append(DbJcbxcbxDep.getSelectedValue());
      sb.append("' ");
    }
    if(DbJcbxcbxCountry.getSelectedValue()!=null){
      sb.append(" and ");
      sb.append(DbJcbxcbxCountry.getOrgRecField());sb.append(" ='");
      sb.append(DbJcbxcbxCountry.getSelectedValue());sb.append("' ");
    }
    if(txtDrCr.getText().trim().length()>0){
      sb.append(" and ");
      sb.append("DTL_DRCR_NO ");
      sb.append(" like '");
      sb.append(txtDrCr.getText().trim().toUpperCase());
      sb.append("%' ");
    }

    if(objDDFrom!=null){
      java.sql.Date d1=new java.sql.Date(((java.util.Date)objDDFrom).getTime());
      java.util.Date datafrom=
      util.MiscFunc.toDate000000(util.MiscFunc.getYear(d1),
                                 util.MiscFunc.getMonth(d1),
                                 util.MiscFunc.getDay(d1));
     sb.append(" and ");
     sb.append(" DTL_DATE >=");
     sb.append(dbEncodeTyp.encode(datafrom));
    }
    if(objDDTo!=null){
      java.sql.Date d1=new java.sql.Date(((java.util.Date)objDDTo).getTime());
      java.util.Date dataTo=
      util.MiscFunc.toDate235959(util.MiscFunc.getYear(d1),
                                 util.MiscFunc.getMonth(d1),
                                 util.MiscFunc.getDay(d1));

      sb.append(" and ");
      sb.append(" DTL_DATE <=");
      sb.append(dbEncodeTyp.encode(dataTo));
    }
    Constants.SQL4QRY =sb.toString();
    //System.out.println("SQL is "+sb.toString());
  }
  void btnQry_actionPerformed(ActionEvent e) {
    try{
      genSql();
      processhandler.template.Properties.getCenteralControler().
          setDataProcesser(null);
      processhandler.template.Properties.getCenteralControler().doCommandExecute(
      new TgrListOffshoreDebitNote());
    }catch(Exception exp){
      exp.printStackTrace();
    }


  }

  void btnAddNew_actionPerformed(ActionEvent e) {
    if(vctDep==null||vctDep.size()==0){
      exgui.verification.VerifyLib.showAlert("Please Define Departments Before Add Offshore Debit Note Details",
                                             "Departments Not Defined Yet");
      return;
    }
    if(vctCountry==null||vctCountry.size()==0){
      exgui.verification.VerifyLib.showAlert("Please Define Countries Before Add Offshore Debit Note Details",
                                             "Countries Not Defined Yet");
      return;
    }



    try{

      database.datatype.Record recBlankCnty=((database.datatype.Record)util.MiscFunc.deepCopy(vctCountry.get(0)));
      database.datatype.Record recBlankDep=((database.datatype.Record)util.MiscFunc.deepCopy(vctDep.get(0)));
      recBlankCnty.set(0,null);
      recBlankCnty.set(1,null);
      recBlankDep.set(0,null);

      PnlBatchAddOfsDbtDtl.vctCountry=new java.util.Vector();
      PnlBatchAddOfsDbtDtl.vctCountry.addAll(vctCountry);
      PnlBatchAddOfsDbtDtl.vctCountry.add(recBlankCnty);

      PnlBatchAddOfsDbtDtl.vctDep=new java.util.Vector();
      PnlBatchAddOfsDbtDtl.vctDep.addAll(vctDep);
      PnlBatchAddOfsDbtDtl.vctDep.add(recBlankDep);



      processhandler.template.Properties.getCenteralControler().
          setDataProcesser(null);
      processhandler.template.Properties.getCenteralControler().doCommandExecute(
      new TgrBatchAddOffshoreDebitNote());
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
