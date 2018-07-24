package newtimes.accounting.debit_note;

import java.awt.*;
import exgui.*;
import newtimes.preproduction.buyermakerselect.*;
import java.awt.event.*;
import newtimes.production.report.*;
import javax.swing.*;
import javax.swing.border.*;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class PnlDbCrPrtByMonth extends
     AbsQryPanel{
     // JPanel {
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel1 = new BlueBkgWhiteCharLabel();
  BlueBkgWhiteCharLabel lblDBNO1 = new BlueBkgWhiteCharLabel();
  WhiteBkgBlueCharLabel lblCenter3 = new WhiteBkgBlueCharLabel();
  WhiteBkgBlueCharLabel lblCenter1 = new WhiteBkgBlueCharLabel();
  WhiteBkgBlueCharLabel lblCenter4 = new WhiteBkgBlueCharLabel();
  JTextField txtDateFrom = new JTextField();
  SelectBuyerMaker slkBuyer = new SelectBuyerMaker();
  JComboBox cbxDep = new JComboBox();
  JTextField txtDateTo = new JTextField();

  JComboBox cbxKind = new JComboBox();
  WhiteBkgBlueCharLabel lblCenter2 = new WhiteBkgBlueCharLabel();
  SelectBuyerMaker slkMaker = new SelectBuyerMaker();
  WhiteBkgBlueCharLabel lblCenter5 = new WhiteBkgBlueCharLabel();
  BlueBkgWhiteCharLabel lblDBNO3 = new BlueBkgWhiteCharLabel();
  ButtonGroup buttonGroup1 = new ButtonGroup();
  WhiteBkgBlueCharLabel lblCenter6 = new WhiteBkgBlueCharLabel();
  JComboBox cbxBranch = new JComboBox();
  exgui.DataBindJCombobox DbJcbxcbxKind,dbCbxDep,DbJcbxcbxBranch;
  exgui.ultratable.Wraper4tblCbx DrCrType[]=new exgui.ultratable.Wraper4tblCbx[5];
  JTextField txtTwdUsd= new JTextField();
  JTextField txtRmbUsd= new JTextField();
  JTextField txtHkdUsd= new JTextField();
  JButton btnReport = new JButton();
  JPanel pnlType = new JPanel();
  TitledBorder titledBorder1;
  TitledBorder titledBorder2;
  /*
  JCheckBox chkDebit = new JCheckBox();
  JCheckBox chkCredit = new JCheckBox();
  JCheckBox chkMakerDisc = new JCheckBox();
  JCheckBox chkBuyerComm = new JCheckBox();
  */
  String typeStr[]=new String[]{"'D'","'C'","'M'","'B'"};
  JCheckBox chkboxType[]=new JCheckBox[4];
  JComboBox cbxSummaryYN = new JComboBox(new String[]{"NO","YES"});
  BlueBkgWhiteCharLabel lblDBNO4 = new BlueBkgWhiteCharLabel();
  JComboBox cbxPassYN = new JComboBox(new String[]{"YES","NO"});

  public PnlDbCrPrtByMonth() {
    try {
      //jbInit();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }
  public java.util.HashMap composeParameters(){
    java.util.HashMap hm=super.composeParameters();
    if(slkBuyer.getSelectedValue()==null){
      hm.put(slkBuyer.getOrgRecField(),"0");
    }
    if(slkMaker.getSelectedValue()==null){
      hm.put(slkMaker.getOrgRecField(),"0");
    }

    if(txtDateFrom.getText().trim().length()==0){
      hm.put("P_DATE_FROM","200001");
    }else{
      hm.put("P_DATE_FROM",txtDateFrom.getText().trim());
    }

    if(txtDateTo.getText().trim().length()==0){
      hm.put("P_DATE_TO","209912");
    }else{
      hm.put("P_DATE_TO",txtDateTo.getText().trim());
    }
    //exgui.ultratable.Wraper4tblCbx selecTypeObj=(exgui.ultratable.Wraper4tblCbx)cbxType.getSelectedItem();

    //hm.put("P_TYPE",selecTypeObj.getValue());
    StringBuffer sb=new StringBuffer();
    for(int i=0;i<4;i++){
      if(chkboxType[i].isSelected()){
        if(sb.length()>0)sb.append(",");
        sb.append(typeStr[i]);
      }
    }
    System.out.println("["+sb.toString()+"]");
    if(sb.length()>0){
      hm.put("P_TYPE","["+sb.toString()+"]");
    }else{
      hm.put("P_TYPE","['ALL']");
    }

    hm.put("P_SUM",cbxSummaryYN.getSelectedItem().toString().substring(0,1));
    hm.put("P_CENTER",util.PublicVariable.OPERATTING_CENTER);
    hm.put("P_PASS",cbxPassYN.getSelectedItem().toString().substring(0,1));
    return hm;
  }
 public void genDataBindObj(){
   dataBindComps.clear();
   dbCbxDep=
      new exgui.DataBindJCombobox(
           cbxDep,"P_DEP",
           newtimes.preproduction.guis.tempProperties.tmpDepartment,
           "DEP_NAME", "DEP_CODE",
           null,"ALL","ALL");
    dataBindComps.add(dbCbxDep);

     for(int i=0;i<5;i++){
          DrCrType[i]=new exgui.ultratable.Wraper4tblCbx();
          DrCrType[i].setValue(PnlQryDebitNote.DrCrTypeValue[i]);
          DrCrType[i].setString(PnlQryDebitNote.DrCrTypeString[i]);
       }
       DrCrType[0].setValue(" ");

     slkBuyer.init("P_BUYER",null,slkBuyer.TYPE_BUYER,true);
     dataBindComps.add(slkBuyer);
     slkMaker.init("P_MAKER",null,slkBuyer.TYPE_MAKER,true);
     dataBindComps.add(slkMaker);
    this.add(btnReport, null);
    this.add(lblCenter1, null);
    this.add(txtDateFrom, null);
    this.add(lblCenter2, null);
    this.add(txtDateTo, null);
    this.add(lblCenter3, null);
    this.add(cbxKind, null);
    //this.add(rdoSmyNo, null);
    this.add(lblCenter6, null);
    this.add(cbxBranch, null);
    this.add(lblCenter1, null);
    this.add(txtDateFrom, null);
    this.add(lblCenter2, null);
    this.add(txtDateTo, null);
    this.add(lblCenter6, null);
    this.add(cbxBranch, null);
    this.add(lblCenter3, null);
    this.add(cbxKind, null);
    this.add(lblCenter5, null);
    this.add(slkMaker, null);
    this.add(lblDBNO3, null);
    this.add(cbxSummaryYN, null);
    this.add(pnlType, null);
    this.add(cbxDep, null);
    this.add(lblCenter1, null);
    this.add(lblCenter3, null);
    this.add(cbxKind, null);
    this.add(lblDBNO4, null);
    this.add(cbxPassYN, null);
    this.add(txtDateFrom, null);
    this.add(lblCenter2, null);
    this.add(txtDateTo, null);
    this.add(lblCenter6, null);
    this.add(cbxBranch, null);
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
           null, "", "0");

       dataBindComps.add(DbJcbxcbxKind);

        if(newtimes.accounting.debit_note.Constans.VCT_BRANCH==null){
          newtimes.accounting.debit_note.Constans.VCT_BRANCH=
              exgui2.CONST.BASIC_MAIN_EJB.getDatas(
              util.PublicVariable.USER_RECORD,
              "select * from branch where record_delete_flag='1'",
             1,9999999);
        }
        DbJcbxcbxBranch = new exgui.DataBindJCombobox(cbxBranch,"P_BRANCH",
                                       newtimes.accounting.debit_note.Constans.VCT_BRANCH,
                                       "BRNCH_NAME","BRNCH_BRIEF",
                                       null,"ALL","ALL");

         dataBindComps.add(DbJcbxcbxBranch);


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

      }catch(Exception exp){
        exp.printStackTrace();
      }
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



 }
 public void jbInit() throws Exception {
      for(int i=0;i<4;i++) chkboxType[i]=new JCheckBox();

    titledBorder1 = new TitledBorder("");
    titledBorder2 = new TitledBorder(BorderFactory.createEtchedBorder(Color.white,new Color(148, 145, 140)),"TYPE");
    blueBkgWhiteCharLabel1.setText("DB/CR REPORT BY MONTH / SUMMARY");
    blueBkgWhiteCharLabel1.setBounds(new Rectangle(-1, 0, 800, 25));
    this.setLayout(null);
    lblDBNO1.setBounds(new Rectangle(5, 29, 54, 26));
    lblDBNO1.setText("DEP. :");
    lblCenter3.setText("KIND:");
    lblCenter3.setBounds(new Rectangle(645, 29, 44, 25));
    lblCenter1.setBounds(new Rectangle(158, 29, 102, 25));
    lblCenter1.setText("YYYYMM From:");
    lblCenter4.setText("BUYER");
    lblCenter4.setBounds(new Rectangle(5, 66, 60, 25));
    txtDateFrom.setText("");
    txtDateFrom.setBounds(new Rectangle(260, 29, 52, 25));
    slkBuyer.setBounds(new Rectangle(64, 66, 130, 25));
    cbxDep.setBounds(new Rectangle(59, 29, 95, 26));
    txtDateTo.setBounds(new Rectangle(342, 29, 52, 25));
    txtDateTo.setText("");
    cbxKind.setBounds(new Rectangle(689, 29, 100, 25));
    lblCenter2.setText("TO");
    lblCenter2.setBounds(new Rectangle(312, 29, 30, 25));
    slkMaker.setBounds(new Rectangle(65, 98, 130, 25));
    lblCenter5.setBounds(new Rectangle(4, 98, 60, 25));
    lblCenter5.setText("MAKER");
    lblDBNO3.setBounds(new Rectangle(200, 66, 95, 25));
    lblDBNO3.setText("SUMMARY");
    lblCenter6.setBounds(new Rectangle(398, 29, 62, 25));
    lblCenter6.setText("BRANCH");
    cbxBranch.setBounds(new Rectangle(462, 29, 181, 25));
    btnReport.setBounds(new Rectangle(676, 98, 111, 29));
    btnReport.setFont(new java.awt.Font("Dialog", 1, 11));
    btnReport.setText("QUERY");
    btnReport.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnReport_actionPerformed(e);
      }
    });
    pnlType.setBackground(new Color(202, 202, 224));
    pnlType.setBorder(titledBorder2);
    pnlType.setBounds(new Rectangle(382, 61, 268, 69));
    pnlType.setLayout(null);
    chkboxType[0].setBackground(new Color(202, 202, 224));
    chkboxType[0].setFont(new java.awt.Font("Dialog", 1, 11));
    chkboxType[0].setText("DEBIT");
    chkboxType[0].setBounds(new Rectangle(11, 14, 81, 22));
    chkboxType[1].setBounds(new Rectangle(11, 37, 81, 22));
    chkboxType[1].setBackground(new Color(202, 202, 224));
    chkboxType[1].setFont(new java.awt.Font("Dialog", 1, 11));
    chkboxType[1].setText("CREDIT");
    chkboxType[2].setBounds(new Rectangle(109, 14, 126, 22));
    chkboxType[2].setBackground(new Color(202, 202, 224));
    chkboxType[2].setFont(new java.awt.Font("Dialog", 1, 11));
    chkboxType[2].setText("MAKER DISCOUNT");
    chkboxType[3].setBounds(new Rectangle(109, 37, 151, 22));
    chkboxType[3].setBackground(new Color(202, 202, 224));
    chkboxType[3].setFont(new java.awt.Font("Dialog", 1, 11));
    chkboxType[3].setText("BUYER COMMISSION");
    this.setBackground(new Color(202, 202, 224));
    cbxSummaryYN.setBounds(new Rectangle(296, 66, 71, 25));
    lblDBNO4.setText("PASS COMM.");
    lblDBNO4.setBounds(new Rectangle(200, 98, 95, 25));
    cbxPassYN.setBounds(new Rectangle(296, 98, 71, 25));
    this.add(blueBkgWhiteCharLabel1, null);
    this.add(lblCenter4, null);
    this.add(slkBuyer, null);
    this.add(lblCenter5, null);
    this.add(slkMaker, null);
    this.add(lblCenter2, null);
    this.add(lblCenter1, null);
    this.add(txtDateFrom, null);
    this.add(txtDateTo, null);
    this.add(lblDBNO1, null);
    this.add(cbxDep, null);
    this.add(lblDBNO3, null);
    slkBuyer.init("", null, slkBuyer.TYPE_BUYER, true);
    slkMaker.init("", null, slkMaker.TYPE_BUYER, true);
    pnlType.add(chkboxType[0], null);
    pnlType.add(chkboxType[1], null);
    pnlType.add(chkboxType[2], null);
    pnlType.add(chkboxType[3], null);
    this.add(btnReport, null);
    this.add(lblCenter3, null);
    this.add(cbxKind, null);
    this.add(lblCenter6, null);
    this.add(cbxBranch, null);
    chkboxType[0].setSelected(true);
    chkboxType[1].setSelected(true);
    genDataBindObj();
    super.reportName="DBNO_LIST.rpt";
  }

  void btnReport_actionPerformed(ActionEvent e) {
     super.JButtonQueryButtonAction(e);
  }
}
