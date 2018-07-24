package newtimes.accounting.debit_note;

import java.awt.*;
import exgui.*;
import javax.swing.*;
import java.awt.event.*;
import newtimes.preproduction.buyermakerselect.*;
import javax.swing.border.*;
import java.awt.*;
import exgui.*;
import javax.swing.*;
import newtimes.preproduction.buyermakerselect.*;
import java.awt.event.*;
import newtimes.production.report.*;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class PnlDbCrListRpt
    //extends JPanel {
    extends AbsQryPanel{
  BlueBkgWhiteCharLabel lblDBNO1 = new BlueBkgWhiteCharLabel();
  WhiteBkgBlueCharLabel lblCenter1 = new WhiteBkgBlueCharLabel();

  JTextField txtDateFrom = new JTextField();
  JTextField txtTwdUsd= new JTextField();
  JTextField txtRmbUsd= new JTextField();
  JTextField txtHkdUsd= new JTextField();

  JButton btnQry = new JButton();
  JComboBox cbxDep = new JComboBox();
  SelectBuyerMaker slkMaker = new SelectBuyerMaker();
  JTextField txtDateTo = new JTextField();
  BlueBkgWhiteCharLabel lblDBNO2 = new BlueBkgWhiteCharLabel();
  WhiteBkgBlueCharLabel lblCenter2 = new WhiteBkgBlueCharLabel();
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel1 = new BlueBkgWhiteCharLabel();
  SelectBuyerMaker slkBuyer = new SelectBuyerMaker();
  BlueBkgWhiteCharLabel lblDBNO3 = new BlueBkgWhiteCharLabel();
  JPanel jPanel1 = new JPanel();
  Border border1;
  TitledBorder titledBorder1;
  JCheckBox chkReportType[] = new JCheckBox[4];
  //JCheckBox chkDebitType = new JCheckBox();
  //JCheckBox chkCreditType = new JCheckBox();
  //JCheckBox chkBuyerComm = new JCheckBox();
  //JCheckBox chkMakerDisc = new JCheckBox();

  BlueBkgWhiteCharLabel lblKInd = new BlueBkgWhiteCharLabel();
  JComboBox cbxKind = new JComboBox();
  JComboBox cbxListType = new JComboBox();
  String wrapPSumString[]=new String[]{"DETAIL LIST","SUMMARY LIST"};
   String wrapPSumValue[]=new String[]{"N","Y"};
   String chkTypeName[]=new String[]{"'D'","'B'","'C'","'M'"};

  BlueBkgWhiteCharLabel lblDBNO5 = new BlueBkgWhiteCharLabel();
  exgui.DataBindJCombobox dbCbxDep,DbJcbxcbxKind;
  exgui.ultratable.Wraper4tblCbx wrapPSum[]=new exgui.ultratable.Wraper4tblCbx[2];
  exgui.DataBindTextWithChecker dbDateFrom,dbDateTo;
  String finallyTypeListString=null;
  public PnlDbCrListRpt() {
    try {
      jbInit();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }

  void jbInit() throws Exception {
    for(int i=0;i<4;i++){
      chkReportType[i]=new JCheckBox();
    }
    wrapPSum[0]=new exgui.ultratable.Wraper4tblCbx();
    wrapPSum[0].setString(wrapPSumString[0]);wrapPSum[0].setValue(wrapPSumValue[0]);

    wrapPSum[1]=new exgui.ultratable.Wraper4tblCbx();
    wrapPSum[1].setString(wrapPSumString[1]);wrapPSum[1].setValue(wrapPSumValue[1]);

    cbxListType.setModel(new javax.swing.DefaultComboBoxModel(wrapPSum));

    border1 = new EtchedBorder(EtchedBorder.RAISED,Color.white,new Color(141, 141, 156));
    titledBorder1 = new TitledBorder(border1,"TYPE");
    lblCenter2.setBounds(new Rectangle(345, 37, 24, 25));
    lblCenter2.setText("TO");
    lblDBNO2.setBounds(new Rectangle(236, 68, 62, 26));
    lblDBNO2.setText("MAKER");
    txtDateTo.setText("");
    txtDateTo.setBounds(new Rectangle(368, 37, 75, 25));
    slkMaker.setBounds(new Rectangle(297, 68, 157, 26));
    cbxDep.setBounds(new Rectangle(59, 37, 113, 26));
    btnQry.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnQry_actionPerformed(e);
      }
    });
    btnQry.setText("QUERY");
    btnQry.setFont(new java.awt.Font("Dialog", 1, 11));
    btnQry.setBounds(new Rectangle(682, 98, 105, 28));
    txtDateFrom.setText("");
    txtDateFrom.setBounds(new Rectangle(270, 37, 75, 25));
    lblCenter1.setHorizontalAlignment(SwingConstants.LEADING);
    lblCenter1.setText(" YYYYMM From:");
    lblCenter1.setBounds(new Rectangle(177, 37, 113, 25));
    lblDBNO1.setText("DEP. :");
    lblDBNO1.setBounds(new Rectangle(3, 37, 57, 26));
    this.setBackground(new Color(202, 202, 224));
    this.setFont(new java.awt.Font("Dialog", 0, 11));
    this.setLayout(null);
    slkMaker.init("MAKER", null, slkMaker.TYPE_MAKER, true);
    blueBkgWhiteCharLabel1.setText("DEBIT/ CREDIT LIST");
    blueBkgWhiteCharLabel1.setBounds(new Rectangle(-1, 1, 801, 31));
    slkBuyer.setBounds(new Rectangle(66, 68, 159, 26));
    lblDBNO3.setBounds(new Rectangle(3, 68, 62, 26));
    lblDBNO3.setBackground(Color.white);
    lblDBNO3.setForeground(new Color(143, 143, 188));
    lblDBNO3.setText("BUYER");
    jPanel1.setBackground(new Color(202, 202, 224));
    jPanel1.setBorder(titledBorder1);
    jPanel1.setBounds(new Rectangle(458, 33-2, 333, 62+4));
    jPanel1.setLayout(null);

    chkReportType[0].setBackground(new Color(202, 202, 224));
    chkReportType[0].setFont(new java.awt.Font("Dialog", 1, 11));
    chkReportType[0].setSelected(true);
    chkReportType[0].setText("DEBIT");
    chkReportType[0].setBounds(new Rectangle(8, 13+2, 90, 25));

    chkReportType[2].setBounds(new Rectangle(8, 34+3, 105, 25));
    chkReportType[2].setText("CREDIT");
    chkReportType[2].setFont(new java.awt.Font("Dialog", 1, 11));
    chkReportType[2].setSelected(true);
    chkReportType[2].setBackground(new Color(202, 202, 224));

    chkReportType[1].setBounds(new Rectangle(149, 13+3, 136, 25));
    chkReportType[1].setText("BUYER COMM.");
    chkReportType[1].setFont(new java.awt.Font("Dialog", 1, 11));
    chkReportType[1].setBackground(new Color(202, 202, 224));

    chkReportType[3].setBackground(new Color(202, 202, 224));
    chkReportType[3].setFont(new java.awt.Font("Dialog", 1, 11));
    chkReportType[3].setText("MAKER DISC.");
    chkReportType[3].setBounds(new Rectangle(149, 34+3, 132, 25));

    lblKInd.setBounds(new Rectangle(3, 101, 57, 26));
    lblKInd.setText("KIND");
    cbxKind.setBounds(new Rectangle(59, 101, 144, 26));
    cbxListType.setBounds(new Rectangle(415, 101, 198, 26));
    lblDBNO5.setText("DETAIL / SUMMARY LIST");
    lblDBNO5.setForeground(new Color(143, 143, 188));
    lblDBNO5.setBackground(Color.white);
    lblDBNO5.setBounds(new Rectangle(236, 101, 178, 26));
    jPanel1.add(chkReportType[0], null);
    jPanel1.add(chkReportType[3], null);
    jPanel1.add(chkReportType[1], null);
    jPanel1.add(chkReportType[2], null);
    this.add(slkBuyer, null);
    this.add(lblDBNO3, null);
    this.add(btnQry, null);
    this.add(lblKInd, null);
    this.add(cbxKind, null);
    this.add(blueBkgWhiteCharLabel1, null);
    this.add(lblDBNO1, null);
    this.add(cbxDep, null);
    this.add(jPanel1, null);
    this.add(slkMaker, null);
    this.add(lblDBNO2, null);
    this.add(lblDBNO5, null);
    this.add(cbxListType, null);
    this.add(txtDateTo, null);
    this.add(txtDateFrom, null);
    this.add(lblCenter1, null);
    this.add(lblCenter2, null);
    slkMaker.init("MAKER", null, slkBuyer.TYPE_MAKER, true);
    slkBuyer.init("BUYER", null, slkBuyer.TYPE_BUYER, true);
    genDataBindObj();
  }
  public void genDataBindObj(){
    super.dataBindComps.clear();
    dbCbxDep=
       new exgui.DataBindJCombobox(
            cbxDep,"P_DEP",
            newtimes.preproduction.guis.tempProperties.tmpDepartment,
            "DEP_NAME", "DEP_CODE",
            "ALL","","ALL");
     dataBindComps.add(dbCbxDep);

     try{
       if (newtimes.accounting.debit_note.Constans.VCT_DEBITNOTE_KIND == null) {
         newtimes.accounting.debit_note.Constans.VCT_DEBITNOTE_KIND =
             exgui2.CONST.BASIC_MAIN_EJB.getDatas(
             util.PublicVariable.USER_RECORD,
             "select a.*,to_char(a.dbnt_kind_seq) as seq_str from DEBITNOTE_KIND a where a.record_delete_flag='1'",
             1, 9999999);
       }

       DbJcbxcbxKind =
           new exgui.DataBindJCombobox(
           cbxKind, "P_KIND",
           Constans.VCT_DEBITNOTE_KIND,
           "DBNT_KIND_DESC",
           "SEQ_STR",
           "0", "", "0");
      dataBindComps.add(DbJcbxcbxKind);

      Object vftxtYearMonth = exgui.verification.CellFormat.getIntVerifierAllowNull(6);
      //java.util.Calendar cldr=java.util.Calendar.getInstance();
      new exgui.DataBindTextWithChecker(txtDateFrom, "_YEAR",
                                        "", 6,
                                        (exgui.Object2String)vftxtYearMonth,
                                        (exgui.ultratable.CellTxtEditorFormat)
                                        vftxtYearMonth);
      new exgui.DataBindTextWithChecker(txtDateTo, "_YEAR",
                                        "", 6,
                                        (exgui.Object2String)vftxtYearMonth,
                                        (exgui.ultratable.CellTxtEditorFormat)
                                        vftxtYearMonth);

      /*
        Object dateVfy = exgui.verification.CellFormat.getDateStringFormaterAllowNull();
        dbDateFrom  =
            new exgui.DataBindTextWithChecker(txtDateFrom , "DEL_BE", null,
                                              10, (exgui.Object2String)dateVfy,
                                              (exgui.ultratable.
                                               CellTxtEditorFormat)dateVfy);
         dbCbxDep.add(dbDateFrom);

        dbDateTo =
            new exgui.DataBindTextWithChecker(txtDateTo , "DEL_EN", null,
                                              10, (exgui.Object2String)dateVfy,
                                              (exgui.ultratable.
                                               CellTxtEditorFormat)dateVfy);
         dbCbxDep.add(dbDateFrom);*/

         Object chkDcm32 = exgui.verification.CellFormat.getDoubleFormatAllowNull(5, 4);
         java.util.Vector vct = exgui2.CONST.BASIC_MAIN_EJB.getDatas(
           util.PublicVariable.USER_RECORD,
           "select * from system_default_value where CENTER='" + (String)util.PublicVariable.USER_RECORD.get("USR_CEN_CODE") + "' and record_delete_flag=1",
           1, 1);
         database.datatype.Record recSystem = (database.datatype.Record)vct.get(0);
        exgui.DataBindTextWithChecker dbTwdChg = new DataBindTextWithChecker(txtTwdUsd, "TWD_E", recSystem.get("TWD_XCHG_RATE"), 10, (Object2String)chkDcm32, (exgui.ultratable.CellTxtEditorFormat)chkDcm32);
         dataBindComps.add(dbTwdChg);
        exgui.DataBindTextWithChecker dbRmbChg = new DataBindTextWithChecker(txtRmbUsd, "RMB_E", recSystem.get("RMB_XCHG_RATE"), 10, (Object2String)chkDcm32, (exgui.ultratable.CellTxtEditorFormat)chkDcm32);
         dataBindComps.add(dbRmbChg);
        exgui.DataBindTextWithChecker dbHkdChg = new DataBindTextWithChecker(txtHkdUsd, "HKD_E", recSystem.get("HKD_XCHG_RATE"), 10, (Object2String)chkDcm32, (exgui.ultratable.CellTxtEditorFormat)chkDcm32);
         dataBindComps.add(dbHkdChg);
        reportName="DBNO_LIST.rpt";
     }catch(Exception exp){
       exp.printStackTrace();
     }
  }

  public boolean isDateOk(){
    if(txtDateFrom.getText().trim().length()>0){
      if(txtDateFrom.getText().trim().length()<6){
        exgui.verification.VerifyLib.showAlert("DATE FORMATE IS YYYYMM","DATE FORMATE IS YYYYMM");
        txtDateFrom.grabFocus();
        txtDateFrom.selectAll();
        return false;
      }
      if(Integer.parseInt(txtDateFrom.getText().trim().substring(0,4))<2005){
        exgui.verification.VerifyLib.showAlert("YEAR CAN NOT LESS THAN 2005","YEAR CAN NOT LESS THAN 2005");
        txtDateFrom.grabFocus();
        txtDateFrom.selectAll();
        return false;
      }
      if(Integer.parseInt(txtDateFrom.getText().trim().substring(4,6))<1||
         Integer.parseInt(txtDateFrom.getText().trim().substring(4,6))>12){
        exgui.verification.VerifyLib.showAlert("MONTH RANGE 01~12 ","MONTH RANGE ERROR");
        txtDateFrom.grabFocus();
        txtDateFrom.selectAll();
        return false;
      }
    }

     if(txtDateTo.getText().trim().length()>0){
       if (txtDateTo.getText().trim().length() < 6) {
         exgui.verification.VerifyLib.showAlert("DATE FORMATE IS YYYYMM",
                                                "DATE FORMATE IS YYYYMM");
         txtDateTo.grabFocus();
         txtDateTo.selectAll();
         return false;
       }
       if (Integer.parseInt(txtDateTo.getText().trim().substring(0, 4)) < 2005) {
         exgui.verification.VerifyLib.showAlert("YEAR CAN NOT LESS THAN 2005",
                                                "YEAR CAN NOT LESS THAN 2005");
         txtDateTo.grabFocus();
         txtDateTo.selectAll();
         return false;
       }
       if (Integer.parseInt(txtDateTo.getText().trim().substring(4, 6)) < 1 ||
           Integer.parseInt(txtDateTo.getText().trim().substring(4, 6)) > 12) {
         exgui.verification.VerifyLib.showAlert("MONTH RANGE 01~12 ",
                                                "MONTH RANGE ERROR");
         txtDateTo.grabFocus();
         txtDateTo.selectAll();
         return false;
       }
     }
      if(txtDateFrom.getText().trim().length()>0 &&
         txtDateTo.getText().trim().length()>0 ){
         if(Integer.parseInt(txtDateFrom.getText().trim())>
            Integer.parseInt(txtDateTo.getText().trim())){
           exgui.verification.VerifyLib.showAlert("\"From\" Date Can Not After \"To\" Date","Date Compare Error");
           return false;
         }
      }
      return true;
  }


  String composeTypeList(){
    StringBuffer sb=new StringBuffer();
    for(int i=0;i<4;i++){
      if(chkReportType[i].isSelected()){
        if(sb.length()>0)sb.append(",");
        sb.append(chkTypeName[i]);
      }
    }
    if(sb.toString().length()==0)return null;
    return "["+sb.toString()+"]";
  }
  public java.util.HashMap composeParameters(){
    java.util.HashMap hm=super.composeParameters();
    hm.put("P_DATE_FROM",(txtDateFrom.getText().trim().length()==0)?"200501":txtDateFrom.getText().trim());
    hm.put("P_DATE_TO",(txtDateTo.getText().trim().length()==0)?"209912":txtDateTo.getText().trim());
    //hm.put("P_DATE_FROM",super.convert2QueryPara(dbDateFrom.getSelectedValue()==null?util.MiscFunc.toDate(2000,01,01):dbDateFrom.getSelectedValue()));
    //hm.put("P_DATE_TO",super.convert2QueryPara(dbDateTo.getSelectedValue()==null?util.MiscFunc.toDate(2099,12,31):dbDateTo.getSelectedValue()));

    hm.put("P_BUYER",slkBuyer.getSelectedValue()==null?"0":slkBuyer.getSelectedValue().toString());
    hm.put("P_MAKER",slkMaker.getSelectedValue()==null?"0":slkMaker.getSelectedValue().toString());
    String isSummaryStr=(String)((exgui.ultratable.Wraper4tblCbx)cbxListType.getSelectedItem()).getValue();
    hm.put("P_SUM",isSummaryStr);
    hm.put("P_TYPE",finallyTypeListString );
    hm.put("P_CENTER",util.PublicVariable.OPERATTING_CENTER);
    return hm;
  }
  void btnQry_actionPerformed(ActionEvent e) {
    if(!isDateOk())return;
    finallyTypeListString=composeTypeList();
    if(finallyTypeListString==null){
      exgui.verification.VerifyLib.showAlert("Please Select At Least One Report Type",
                                             "Please Select At Least One Report Type");
      return;
    }
    super.JButtonQueryButtonAction(e);
  }
}
