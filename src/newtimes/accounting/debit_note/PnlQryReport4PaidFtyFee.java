package newtimes.accounting.debit_note;

import java.awt.*;
import exgui.*;
import javax.swing.*;
import java.awt.event.*;
import newtimes.preproduction.buyermakerselect.*;
import javax.swing.border.*;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class PnlQryReport4PaidFtyFee extends JPanel {
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel1 = new BlueBkgWhiteCharLabel();
  WhiteBkgBlueCharLabel lblCenter1 = new WhiteBkgBlueCharLabel();
  JTextField txtDateFrom = new JTextField();
  JTextField txtDateTo = new JTextField();
  WhiteBkgBlueCharLabel lblCenter2 = new WhiteBkgBlueCharLabel();
  JComboBox cbxBuyerMakerType = new JComboBox(new String[]{"BUYER","MAKER","OTHER"});
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel3 = new BlueBkgWhiteCharLabel();
  WhiteBkgBlueCharLabel lblCenter4 = new WhiteBkgBlueCharLabel();
  SelectBuyerMaker selectBuyerMaker = new SelectBuyerMaker();
  WhiteBkgBlueCharLabel lblCenter5 = new WhiteBkgBlueCharLabel();
  JComboBox cbxMerchId = new JComboBox();
  JComboBox cbxFactory = new JComboBox();
  JRadioButton rdoAllRec = new JRadioButton();
  ButtonGroup buttonGroup1 = new ButtonGroup();
  JRadioButton rdoCloseRecord = new JRadioButton();
  JRadioButton rdoBlnRec = new JRadioButton();
  WhiteBkgBlueCharLabel lblCenter6 = new WhiteBkgBlueCharLabel();
  JComboBox cbxCurrency = new JComboBox(new String[]{"ALL","USD","TWD","RMB"});
  JButton btnExit = new JButton();
  JButton btnReport = new JButton();
  exgui.DataBindJCombobox dbCbxDep[],DbJcbxcbxMerchID;
  exgui.DataBindEditableJCombobox DbJcbxcbxFactory ;
  JPanel jPanel1 = new JPanel();
  Border border1;
  TitledBorder titledBorder1;
  JComboBox cbxDep[] = new JComboBox[8];
  WhiteBkgBlueCharLabel lblCenter13 = new WhiteBkgBlueCharLabel();
  WhiteBkgBlueCharLabel lblCenterText = new WhiteBkgBlueCharLabel();
  WhiteBkgBlueCharLabel lblCenter7 = new WhiteBkgBlueCharLabel();
  public PnlQryReport4PaidFtyFee() {
    try {
      dbCbxDep=new exgui.DataBindJCombobox[8];
      jbInit();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }

  void jbInit() throws Exception {
    for(int i=0;i<8;i++){
      cbxDep[i]=new JComboBox();
    }
    border1 = new EtchedBorder(EtchedBorder.RAISED,Color.white,new Color(141, 141, 156));
    titledBorder1 = new TitledBorder(border1,"DEP.");
    blueBkgWhiteCharLabel1.setText("支付工廠費用統計表");
    blueBkgWhiteCharLabel1.setFont(new java.awt.Font("Dialog", 0, 16));
    blueBkgWhiteCharLabel1.setBounds(new Rectangle(0, 20, 801, 32));
    this.setBackground(new Color(202, 202, 224));
    this.setLayout(null);
    lblCenter1.setBounds(new Rectangle(42, 220, 117, 25));
    lblCenter1.setBackground(new Color(143, 143, 188));
    lblCenter1.setForeground(Color.white);
    lblCenter1.setText("YYYYMM From:");
    txtDateFrom.setSelectionStart(0);
    txtDateFrom.setText("");
    txtDateFrom.setBounds(new Rectangle(159, 220, 58, 25));
    txtDateTo.setBounds(new Rectangle(254, 220, 58, 25));
    txtDateTo.setText("");
    lblCenter2.setBackground(new Color(143, 143, 188));
    lblCenter2.setForeground(Color.white);
    lblCenter2.setText("TO");
    lblCenter2.setBounds(new Rectangle(216, 220, 38, 25));
    cbxBuyerMakerType.setBounds(new Rectangle(165, 340, 81, 26));
    cbxBuyerMakerType.addItemListener(new java.awt.event.ItemListener() {
      public void itemStateChanged(ItemEvent e) {
        cbxBuyerMakerType_itemStateChanged(e);
      }
    });
    blueBkgWhiteCharLabel3.setBounds(new Rectangle(42, 302, 123, 25));
    blueBkgWhiteCharLabel3.setText("MERCH-ID");
    blueBkgWhiteCharLabel3.setForeground(SystemColor.text);
    lblCenter4.setText("BUYER / MAKER");
    lblCenter4.setBounds(new Rectangle(42, 340, 123, 25));
    selectBuyerMaker.setBounds(new Rectangle(247, 340, 289, 26));
    lblCenter5.setBounds(new Rectangle(42, 380, 123, 25));
    lblCenter5.setBackground(new Color(143, 143, 188));
    lblCenter5.setForeground(Color.white);
    lblCenter5.setText("FACTORY");
    cbxMerchId.setBounds(new Rectangle(165, 302, 123, 25));
    cbxFactory.setBounds(new Rectangle(165, 380, 257, 25));
    cbxFactory.setEditable(true);
    rdoAllRec.setBackground(Color.white);
    rdoAllRec.setFont(new java.awt.Font("Dialog", 1, 11));
    rdoAllRec.setSelected(true);
    rdoAllRec.setText("All Records");
    rdoAllRec.setBounds(new Rectangle(42, 262, 137, 24));
    rdoCloseRecord.setBounds(new Rectangle(178, 262, 120, 24));
    rdoCloseRecord.setText("CLOSE RECORD");
    rdoCloseRecord.setBackground(Color.white);
    rdoCloseRecord.setFont(new java.awt.Font("Dialog", 1, 11));
    rdoBlnRec.setFont(new java.awt.Font("Dialog", 1, 11));
    rdoBlnRec.setBackground(Color.white);
    rdoBlnRec.setText("BALANCE RECORD");
    rdoBlnRec.setBounds(new Rectangle(296, 262, 237, 24));
    lblCenter6.setBounds(new Rectangle(42, 419, 123, 25));
    lblCenter6.setText("CURRENCY");
    cbxCurrency.setBounds(new Rectangle(165, 419, 81, 26));
    btnExit.setBounds(new Rectangle(495, 482, 118, 28));
    btnExit.setFont(new java.awt.Font("Dialog", 1, 11));
    btnExit.setText("EXIT");
    btnExit.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnExit_actionPerformed(e);
      }
    });
    btnReport.setText("REPORT");
    btnReport.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnReport_actionPerformed(e);
      }
    });
    btnReport.setBounds(new Rectangle(260, 482, 118, 28));
    btnReport.setFont(new java.awt.Font("Dialog", 1, 11));
    jPanel1.setBackground(new Color(202, 202, 224));
    jPanel1.setBorder(titledBorder1);
    jPanel1.setBounds(new Rectangle(42, 80, 708, 125));
    jPanel1.setLayout(null);
    cbxDep[2].setBounds(new Rectangle(350, 25, 148, 26));
    cbxDep[3].setBounds(new Rectangle(520, 25, 148, 26));
    cbxDep[1].setBounds(new Rectangle(181, 25, 148, 26));
    cbxDep[0].setBounds(new Rectangle(11, 25, 148, 26));
    cbxDep[4].setBounds(new Rectangle(351, 74, 148, 26));
    cbxDep[5].setBounds(new Rectangle(521, 74, 148, 26));
    cbxDep[6].setBounds(new Rectangle(182, 74, 148, 26));
    cbxDep[7].setBounds(new Rectangle(11, 74, 148, 26));


    lblCenterText.setText("CENTER");

    lblCenterText.setBounds(new Rectangle(35, 203, 123, 25));
    lblCenterText.setText("BUYER / MAKER");
    lblCenterText.setBounds(new Rectangle(164, 56, 196, 25));
    lblCenter7.setText("CENTER");
    lblCenter7.setBounds(new Rectangle(42, 56, 123, 25));
    this.add(blueBkgWhiteCharLabel1, null);
    selectBuyerMaker.init("", null, selectBuyerMaker.TYPE_BUYER, true);
    buttonGroup1.add(rdoAllRec);
    buttonGroup1.add(rdoCloseRecord);
    buttonGroup1.add(rdoBlnRec);
    this.add(btnReport, null);
    this.add(btnExit, null);
    this.add(rdoAllRec, null);
    this.add(rdoCloseRecord, null);
    this.add(rdoBlnRec, null);
    this.add(blueBkgWhiteCharLabel3, null);
    this.add(cbxMerchId, null);
    this.add(lblCenter4, null);
    this.add(cbxBuyerMakerType, null);
    this.add(selectBuyerMaker, null);
    this.add(lblCenter5, null);
    this.add(cbxFactory, null);
    this.add(lblCenter6, null);
    this.add(cbxCurrency, null);
    this.add(jPanel1, null);
    jPanel1.add(cbxDep[2], null);
    jPanel1.add(cbxDep[3], null);
    jPanel1.add(cbxDep[1], null);
    jPanel1.add(cbxDep[0], null);
    jPanel1.add(cbxDep[4], null);
    jPanel1.add(cbxDep[5], null);
    jPanel1.add(cbxDep[6], null);
    jPanel1.add(cbxDep[7], null);
    this.add(lblCenter1, null);
    this.add(txtDateFrom, null);
    this.add(lblCenter2, null);
    this.add(txtDateTo, null);

    this.add(lblCenterText, null);
    this.add(lblCenter7, null);
    String centerName=
    (String)((database.datatype.Record)Constans.recGetCenterRec(util.PublicVariable.OPERATTING_CENTER)).get(1);
    lblCenterText.setText(centerName);

    if(Constans.VCT_FTY_NAMES==null){
      Constans.VCT_FTY_NAMES=
          exgui2.CONST.BASIC_MAIN_EJB.getDatas(util.PublicVariable.USER_RECORD,
               "select nvl(buyer_maker.BYMKR_CHINESE_BRIEF,buyer_maker.BYMKR_NAME) as bymker_tmp_name  "+
               "from buyer_maker where selectable_center   like '%,001,%' and buyer_maker.BYMKR_MULTI_TYPE like '%,2,%'"+
               " and record_delete_flag='1' order by bymker_tmp_name"
               ,1,99999);
    }


    java.util.Vector vctFty=Constans.VCT_FTY_NAMES;


     DbJcbxcbxFactory = new exgui.DataBindEditableJCombobox(cbxFactory,
                                           "DBNT_PAYDTL_FTY",
                                           vctFty,
                                           "BYMKER_TMP_NAME","BYMKER_TMP_NAME",
                                          null,100);
    for(int i=0;i<8;i++){
      dbCbxDep[i] = new exgui.DataBindJCombobox(
          cbxDep[i], "",
          newtimes.preproduction.guis.tempProperties.tmpDepartment,
          "DEP_NAME", "DEP_CODE",
          null, "", null);
    }


     if(Constans.VCT_MERCH ==null){
       Constans.VCT_MERCH=
           exgui2.CONST.BASIC_MAIN_EJB.getDatas(util.PublicVariable.USER_RECORD,
                "select usr_code,usr_name from debitnote_user where cen_code='"+util.PublicVariable.OPERATTING_CENTER+"' order by usr_name"
                ,1,99999);
     }




    java.util.Vector dbntUsers=Constans.VCT_MERCH;
    DbJcbxcbxMerchID = new exgui.DataBindJCombobox(
                          cbxMerchId,"DBNT_PAYDTL_MERCHID",
                          dbntUsers,"USR_NAME","USR_CODE",
                          null,"",null);


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
  void cbxBuyerMakerType_itemStateChanged(ItemEvent e) {

       selectBuyerMaker.init("",null,
                             Integer.parseInt(
                             (String)
                              newtimes.accounting.debit_note.Constans.hmBuyerMakerType.get(cbxBuyerMakerType.getSelectedItem())
                              ), true);

  }

  void btnExit_actionPerformed(ActionEvent e) {
    try{
      processhandler.template.Properties.getCenteralControler().goBack();
    }catch(Exception exp){

    }
  }

  void btnReport_actionPerformed(ActionEvent e) {
     //check date.

     if(txtDateFrom.getText().trim().length()>0){
       if(txtDateFrom.getText().trim().length()<6){
         exgui.verification.VerifyLib.showAlert("DATE FORMATE IS YYYYMM","DATE FORMATE IS YYYYMM");
         txtDateFrom.grabFocus();
         txtDateFrom.selectAll();
         return ;
       }
       if(Integer.parseInt(txtDateFrom.getText().trim().substring(0,4))<2006){
         exgui.verification.VerifyLib.showAlert("YEAR CAN NOT LESS THAN 2006","YEAR CAN NOT LESS THAN 2006");
         txtDateFrom.grabFocus();
         txtDateFrom.selectAll();
         return ;
       }
       if(Integer.parseInt(txtDateFrom.getText().trim().substring(4,6))<1||
          Integer.parseInt(txtDateFrom.getText().trim().substring(4,6))>12){
         exgui.verification.VerifyLib.showAlert("MONTH RANGE 01~12 ","MONTH RANGE ERROR");
         txtDateFrom.grabFocus();
         txtDateFrom.selectAll();
         return ;
       }
     }

     if(txtDateTo.getText().trim().length()>0){
       if (txtDateTo.getText().trim().length() < 6) {
         exgui.verification.VerifyLib.showAlert("DATE FORMATE IS YYYYMM",
                                                "DATE FORMATE IS YYYYMM");
         txtDateTo.grabFocus();
         txtDateTo.selectAll();
         return ;
       }
       if (Integer.parseInt(txtDateTo.getText().trim().substring(0, 4)) < 2006) {
         exgui.verification.VerifyLib.showAlert("YEAR CAN NOT LESS THAN 2006",
                                                "YEAR CAN NOT LESS THAN 2006");
         txtDateTo.grabFocus();
         txtDateTo.selectAll();
         return ;
       }
       if (Integer.parseInt(txtDateTo.getText().trim().substring(4, 6)) < 1 ||
           Integer.parseInt(txtDateTo.getText().trim().substring(4, 6)) > 12) {
         exgui.verification.VerifyLib.showAlert("MONTH RANGE 01~12 ",
                                                "MONTH RANGE ERROR");
         txtDateTo.grabFocus();
         txtDateTo.selectAll();
         return ;
       }
     }
      if(txtDateFrom.getText().trim().length()>0 &&
         txtDateTo.getText().trim().length()>0 ){
         if(Integer.parseInt(txtDateFrom.getText().trim())>
            Integer.parseInt(txtDateTo.getText().trim())){
           exgui.verification.VerifyLib.showAlert("\"From\" Date Can Not After \"To\" Date","Date Compare Error");
           return ;
         }
      }


      //generate hash map for report.
      java.util.HashMap hm=new java.util.HashMap();

      /*Object objDep=dbcbxDep[0].getSelectedValue();
      hm.put("P_DEP",(objDep==null)?"ALL":objDep.toString());*/
      StringBuffer sbDep=new StringBuffer();
      for(int i=0;i<8;i++){
        Object objDep=dbCbxDep[i].getSelectedValue();
        if(objDep!=null){
          if(sbDep.length()>0)sbDep.append(",");
          sbDep.append("'");sbDep.append(objDep.toString());sbDep.append("'");
        }
      }
      String depParaString=(sbDep.length()==0)?("['ALL']"):("["+sbDep.toString()+"]");
      System.out.println("DEP PARA LIST :"+depParaString);
      hm.put("P_DEP",depParaString);


      String dateFrom=txtDateFrom.getText().trim();
      hm.put("P_YYYYMM_FM",(dateFrom.equals(""))?"ALL":dateFrom);

      String dataTo=txtDateTo.getText().trim();
      hm.put("P_YYYYMM_TO",(dataTo.equals(""))?"ALL":dataTo);

      String acpCode=
      (rdoAllRec.isSelected())?"A":
       ((rdoCloseRecord.isSelected())?"C":
       ((rdoBlnRec.isSelected())?"P":"A"));
      hm.put("P_ACP",acpCode);

      Object merchangId=DbJcbxcbxMerchID.getSelectedValue();
      hm.put("P_MER",(merchangId==null)?"ALL":merchangId.toString());

      Object objBuyer=selectBuyerMaker.getSelectedValue();
      hm.put("P_BUYER",((objBuyer==null)?"ALL":objBuyer.toString()));

      String strFty=((javax.swing.text.JTextComponent)cbxFactory.getEditor().getEditorComponent()).getText();
      hm.put("P_FTY",("".equals(strFty.trim()))?"ALL":strFty);

      hm.put("P_CURRENCY",cbxCurrency.getSelectedItem());
      hm.put("P_CENTER",util.PublicVariable.OPERATTING_CENTER);

      try{
        //show debit note report,
        com.inet.viewer.ReportViewerBean viewer = util.PublicVariable.
            inet_report_viewer;
        String rpt_name = "db_pay.rpt";
        newtimes.production.report.ReportCmdSet.myReportEngin.
            setReportNameAndParas(viewer, rpt_name, hm);
        viewer.setHasGroupTree(false);
        //viewer.setReportData(newtimes.production.report.ReportCmdSet.myReportEngin);
        viewer.start();
        JPanel pnl = new JPanel();
        pnl.setLayout(new java.awt.BorderLayout());
        pnl.add(viewer);

        newtimes.preproduction.guis.DlgViewRpt dlg = new newtimes.preproduction.
            guis.DlgViewRpt(
            processhandler.template.Properties.getMainFrame(),
            "支付工廠費用統計表",
            pnl, true);
        dlg.setSize(700, 500);
        dlg.show();
      }catch(Exception exp){
        exp.printStackTrace();

      }


  }
}
