package newtimes.production.report;

import java.awt.*;
import javax.swing.*;
import exgui.*;
import javax.swing.border.*;
import java.awt.event.*;
import java.util.Vector;
import newtimes.preproduction.buyermakerselect.*;
import jxl.*;
import database.datatype.*;
/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class Pnl_Tpe_MIS_Func extends JPanel {
  JButton btnExit = new JButton();
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel1 = new BlueBkgWhiteCharLabel();
  JPanel pnlUpdateDebitNote = new JPanel();
  Border border1;
  TitledBorder titledBorder1;
  JButton btnCancelDebitNoteFlag = new JButton();
  JLabel jLabel1 = new JLabel();
  JTextField txtShipNo = new JTextField();
  JPanel PnlProfitShareCode = new JPanel();
  TitledBorder titledBorder2;
  Border border2;
  TitledBorder titledBorder3;
  JTextField txtEtdFrom = new JTextField();
  JTextField txtEtdTo = new JTextField();
  JButton btnUpdateProfitCode = new JButton();
  JLabel jLabel2 = new JLabel();
  JLabel jLabel3 = new JLabel();
  newtimesejb.TPE_MIS.TpeMisFunc ejbFunc=null;
  exgui.DataBindTextWithChecker dbTxtDateBgn,dbTxtDateTo;
  exgui.DataBindJCombobox dbCbxDep;
  public Pnl_Tpe_MIS_Func() {
    try {
      jbInit();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }

  void jbInit() throws Exception {
    border1 = new EtchedBorder(EtchedBorder.RAISED,Color.white,new Color(148, 145, 140));
    titledBorder1 = new TitledBorder(new EtchedBorder(EtchedBorder.RAISED,Color.white,new Color(148, 145, 140)),"取消 Debit Note 轉換碼");
    titledBorder2 = new TitledBorder("");
    border2 = BorderFactory.createEtchedBorder(Color.white,new Color(148, 145, 140));
    titledBorder3 = new TitledBorder(BorderFactory.createEtchedBorder(Color.white,new Color(148, 145, 140)),"Transfer Profit Share Code");
    border3 = new EtchedBorder(EtchedBorder.RAISED,Color.white,new Color(148, 145, 140));
    titledBorder4 = new TitledBorder(border3,"全年度分類帳");
    border4 = new EtchedBorder(EtchedBorder.RAISED,Color.white,new Color(141, 141, 156));
    titledBorder5 = new TitledBorder(border4,"NB BATCH PROCECSS");
    titledBorder4.setTitleFont(new java.awt.Font("新細明體", 0, 16));
    pnlUpdateDebitNote.setBackground(new Color(202, 202, 224));
    pnlUpdateDebitNote.setBorder(titledBorder1);
    pnlUpdateDebitNote.setBounds(new Rectangle(15, 65, 286, 81));
    pnlUpdateDebitNote.setLayout(null);
    this.setLayout(null);
    btnExit.setBounds(new Rectangle(276, 528, 153, 33));
    btnExit.setFont(new java.awt.Font("Dialog", 1, 11));
    btnExit.setFocusPainted(true);
    btnExit.setText("EXIT");
    btnExit.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnExit_actionPerformed(e);
      }
    });
    blueBkgWhiteCharLabel1.setFont(new java.awt.Font("Dialog", 0, 12));
    blueBkgWhiteCharLabel1.setText("台北MIS專用功能區");
    blueBkgWhiteCharLabel1.setBounds(new Rectangle(-1, 16, 801, 37));
    btnCancelDebitNoteFlag.setBounds(new Rectangle(172, 30, 89, 26));
    btnCancelDebitNoteFlag.setFont(new java.awt.Font("Dialog", 1, 11));
    btnCancelDebitNoteFlag.setText("Update");
    btnCancelDebitNoteFlag.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnCancelDebitNoteFlag_actionPerformed(e);
      }
    });
    jLabel1.setFont(new java.awt.Font("Dialog", 1, 11));
    jLabel1.setHorizontalAlignment(SwingConstants.CENTER);
    jLabel1.setText("SHIP NO:");
    jLabel1.setBounds(new Rectangle(9, 30, 69, 26));
    txtShipNo.setBounds(new Rectangle(71, 30, 101, 26));
    PnlProfitShareCode.setBackground(new Color(202, 202, 224));
    PnlProfitShareCode.setFont(new java.awt.Font("細明體", 0, 16));
    PnlProfitShareCode.setBorder(titledBorder3);
    PnlProfitShareCode.setBounds(new Rectangle(314, 65, 473, 108));
    PnlProfitShareCode.setLayout(null);
    txtEtdFrom.setText("");
    txtEtdFrom.setBounds(new Rectangle(55, 73, 91, 22));
    txtEtdTo.setText("");
    txtEtdTo.setBounds(new Rectangle(201, 73, 111, 22));
    btnUpdateProfitCode.setBounds(new Rectangle(324, 73, 65, 25));
    btnUpdateProfitCode.setFont(new java.awt.Font("Dialog", 1, 11));
    btnUpdateProfitCode.setText("GO!!");
    btnUpdateProfitCode.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnUpdateProfitCode_actionPerformed(e);
      }
    });
    jLabel2.setFont(new java.awt.Font("Dialog", 1, 11));
    jLabel2.setHorizontalAlignment(SwingConstants.CENTER);
    jLabel2.setText("<html><body>ETD<br>From</body></html>");
    jLabel2.setBounds(new Rectangle(5, 67, 61, 36));
    jLabel3.setBounds(new Rectangle(158, 73, 48, 22));
    jLabel3.setText("TO");
    jLabel3.setHorizontalAlignment(SwingConstants.CENTER);
    jLabel3.setFont(new java.awt.Font("Dialog", 1, 11));
    this.setBackground(new Color(202, 202, 224));
    btnChgPftShareCode.setBounds(new Rectangle(16, 186, 331, 33));
    btnChgPftShareCode.setFont(new java.awt.Font("Dialog", 1, 11));
    btnChgPftShareCode.setText("Query & Change Profit Share Code");
    btnChgPftShareCode.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnChgPftShareCode_actionPerformed(e);
      }
    });
    btnDebitNoteUserMaintain.setBounds(new Rectangle(359, 186, 389, 33));
    btnDebitNoteUserMaintain.setFont(new java.awt.Font("Dialog", 1, 11));
    btnDebitNoteUserMaintain.setText("DEBIT NOTE USER MAINTAIN");
    btnDebitNoteUserMaintain.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnDebitNoteUserMaintain_actionPerformed(e);
      }
    });
    jLabel4.setBounds(new Rectangle(5, 18, 51, 22));
    jLabel4.setText("DEP:");
    jLabel4.setHorizontalAlignment(SwingConstants.CENTER);
    jLabel4.setFont(new java.awt.Font("Dialog", 1, 11));
    cbxDep.setBounds(new Rectangle(49, 18, 139, 21));
    cbxIsForceOverWriteProftShareCode.setBackground(new Color(202, 202, 224));
    cbxIsForceOverWriteProftShareCode.setFont(new java.awt.Font("Dialog", 1, 11));
    cbxIsForceOverWriteProftShareCode.setText("Overwrite Existing ProfitShare Code");
    cbxIsForceOverWriteProftShareCode.setBounds(new Rectangle(12, 48, 283, 20));
    slkMakerToFiterSc4ProfitShare.setBounds(new Rectangle(271, 18, 191, 22));
    jLabel5.setFont(new java.awt.Font("Dialog", 1, 11));
    jLabel5.setHorizontalAlignment(SwingConstants.CENTER);
    jLabel5.setText("MAKER:");
    jLabel5.setBounds(new Rectangle(207, 18, 62, 22));
    btnCurrencyReport.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnCurrencyReport_actionPerformed(e);
      }
    });
    btnCurrencyReport.setText("EXCHANGE RATE LIST");
    btnCurrencyReport.setFont(new java.awt.Font("Dialog", 1, 11));
    btnCurrencyReport.setBounds(new Rectangle(16, 235, 331, 33));
    pnlYY_accItem.setBackground(new Color(202, 202, 224));
    pnlYY_accItem.setFont(new java.awt.Font("Dialog", 0, 12));
    pnlYY_accItem.setBorder(titledBorder4);
    pnlYY_accItem.setBounds(new Rectangle(356, 221, 414, 62));
    pnlYY_accItem.setLayout(null);
    btnRptAccOpInout.setBounds(new Rectangle(10, 23, 110, 29));
    btnRptAccOpInout.setFont(new java.awt.Font("Dialog", 0, 16));
    btnRptAccOpInout.setText("費用/收入");
    btnRptAccOpInout.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnRptAccOpInout_actionPerformed(e);
      }
    });
    btnRpt_1101_1102.setText("現金,銀行");
    btnRpt_1101_1102.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnRpt_1101_1102_actionPerformed(e);
      }
    });
    btnRpt_1101_1102.setBounds(new Rectangle(146, 23, 110, 29));
    btnRpt_1101_1102.setFont(new java.awt.Font("Dialog", 0, 16));
    btnRpt_1103_3zzz.setFont(new java.awt.Font("Dialog", 0, 16));
    btnRpt_1103_3zzz.setBounds(new Rectangle(281, 23, 110, 29));
    btnRpt_1103_3zzz.setText("資產,負債");
    btnRpt_1103_3zzz.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnRpt_1103_3zzz_actionPerformed(e);
      }
    });
    pnlNBbatchFunc.setBackground(new Color(202, 202, 224));
    pnlNBbatchFunc.setBorder(titledBorder5);
    pnlNBbatchFunc.setBounds(new Rectangle(21, 295, 415, 69));
    pnlNBbatchFunc.setLayout(null);
    btnBatchAdd.setBounds(new Rectangle(10, 24, 181, 29));
    btnBatchAdd.setFont(new java.awt.Font("Dialog", 1, 11));
    btnBatchAdd.setText("BATCH ADD PROD-HEAD");
    btnBatchAdd.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnBatchAdd_actionPerformed(e);
      }
    });
    btnBatchUpdateRemark.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnBatchUpdateRemark_actionPerformed(e);
      }
    });
    btnBatchUpdateRemark.setText("BATCH UPDATE REMARK");
    btnBatchUpdateRemark.setFont(new java.awt.Font("Dialog", 1, 11));
    btnBatchUpdateRemark.setBounds(new Rectangle(209, 24, 181, 29));
    btnBurtonRotateExcel.setBounds(new Rectangle(439, 285, 151, 32));
    btnBurtonRotateExcel.setFont(new java.awt.Font("Dialog", 1, 11));
    btnBurtonRotateExcel.setText("BURTON -> EXCEL");
    btnBurtonRotateExcel.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnBurtonRotateExcel_actionPerformed(e);
      }
    });
    btnNthkShipMark.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnNthkShipMark_actionPerformed(e);
      }
    });
    btnNthkShipMark.setText("NTHK ShipMark");
    btnNthkShipMark.setFont(new java.awt.Font("Dialog", 1, 11));
    btnNthkShipMark.setBounds(new Rectangle(618, 295, 151, 32));
    btnNtfeShipMark.setBounds(new Rectangle(618, 337, 151, 32));
    btnNtfeShipMark.setFont(new java.awt.Font("Dialog", 1, 11));
    btnNtfeShipMark.setText("NTFE ShipMark");
    btnNtfeShipMark.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnNtfeShipMark_actionPerformed(e);
      }
    });
    btnBurtonPriceUpdate.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnBurtonPriceUpdate_actionPerformed(e);
      }
    });
    btnBurtonPriceUpdate.setText("BURTON  Price Update");
    btnBurtonPriceUpdate.setFont(new java.awt.Font("Dialog", 1, 11));
    btnBurtonPriceUpdate.setMargin(new Insets(0, 0, 0, 0));
    btnBurtonPriceUpdate.setBounds(new Rectangle(440, 332, 151, 32));
    this.add(blueBkgWhiteCharLabel1, null);
    this.add(btnExit, null);
    pnlUpdateDebitNote.add(jLabel1, null);
    this.add(btnDebitNoteUserMaintain, null);
    this.add(btnChgPftShareCode, null);
    this.add(PnlProfitShareCode, null);
    this.add(pnlUpdateDebitNote, null);
    PnlProfitShareCode.add(jLabel2, null);
    PnlProfitShareCode.add(cbxIsForceOverWriteProftShareCode, null);
    PnlProfitShareCode.add(jLabel4, null);
    PnlProfitShareCode.add(cbxDep, null);
    PnlProfitShareCode.add(txtEtdFrom, null);
    PnlProfitShareCode.add(jLabel3, null);
    PnlProfitShareCode.add(txtEtdTo, null);
    PnlProfitShareCode.add(btnUpdateProfitCode, null);
    PnlProfitShareCode.add(slkMakerToFiterSc4ProfitShare, null);
    PnlProfitShareCode.add(jLabel5, null);
    pnlUpdateDebitNote.add(txtShipNo, null);
    pnlUpdateDebitNote.add(btnCancelDebitNoteFlag, null);
    this.add(btnCurrencyReport, null);
    this.add(pnlYY_accItem, null);
    pnlYY_accItem.add(btnRptAccOpInout, null);
    pnlYY_accItem.add(btnRpt_1101_1102, null);
    pnlYY_accItem.add(btnRpt_1103_3zzz, null);
    this.add(pnlNBbatchFunc, null);
    pnlNBbatchFunc.add(btnBatchAdd, null);
    pnlNBbatchFunc.add(btnBatchUpdateRemark, null);
    /*
    this.add(btnNthkShipMark, null);
    this.add(btnNtfeShipMark, null);
    */
    this.add(btnBurtonRotateExcel, null);
    this.add(btnBurtonPriceUpdate, null);
    Object dateVfy = exgui.verification.CellFormat.getDateStringFormaterAllowNull();
     dbTxtDateBgn =
        new exgui.DataBindTextWithChecker(txtEtdFrom, "P_DEL_FM", null,
                                          10, (exgui.Object2String)dateVfy,
                                          (exgui.ultratable.
                                           CellTxtEditorFormat)dateVfy);
    dbTxtDateTo =
        new exgui.DataBindTextWithChecker(txtEtdTo, "P_DEL_TO", null,
                                          10, (exgui.Object2String)dateVfy,
                                          (exgui.ultratable.
                                           CellTxtEditorFormat)dateVfy);
    setCursor(new java.awt.Cursor(java.awt.Cursor.WAIT_CURSOR));
    while(!newtimes.preproduction.process.AttributeFactory.isAllAccsAttribReady()){

      try{

        Thread.currentThread().sleep(100);

      }catch(java.lang.InterruptedException ie){

      }
    }
    setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
    dbCbxDep=
       new exgui.DataBindJCombobox(
            cbxDep,"",
            newtimes.preproduction.guis.tempProperties.tmpDepartment,
            "DEP_NAME", "DEP_ABBR",
           null,"",null);

    slkMakerToFiterSc4ProfitShare.init("",null,slkMakerToFiterSc4ProfitShare.TYPE_MAKER,true);

  }
  protected void getEJB()throws Exception{
    newtimesejb.TPE_MIS.TpeMisFuncHome ejbHome=
        (newtimesejb.TPE_MIS.TpeMisFuncHome)
        info_ejb.WeblogicServiceLocator.locateServiceHome(
        util.PublicVariable.SERVER_URL,"newtimesejb.TPE_MIS.TpeMisFunc");
    ejbFunc=ejbHome.create();
  }
  void btnCancelDebitNoteFlag_actionPerformed(ActionEvent e) {
    try{
      //test if srn is correct.
      if(txtShipNo.getText().trim().length()==0){
        exgui.verification.VerifyLib.showAlert("Please Input SHIP NO to cancel",
                                               "Please Input Ship No");
        return;
      }
      Vector vct=exgui2.CONST.BASIC_MAIN_EJB.getDatas(
      util.PublicVariable.USER_RECORD,
      "select * from shipping where ship_no='"+
      util.MiscFunc.Replace(txtShipNo.getText().toUpperCase().trim(),"'","''")+"'"
      ,1,1);
      if(vct.size()==0){
        exgui.verification.VerifyLib.showAlert("No Such Ship NO.",
                                               "Shipping Data Not Found");
        return;
      }
      if (ejbFunc == null) {
        getEJB();
      }
      if (ejbFunc != null) {
        ejbFunc.updateDebitNote4SRN(util.PublicVariable.USER_RECORD.get(0).
                                    toString(),
                                    txtShipNo.getText().trim().toUpperCase());
        exgui.verification.VerifyLib.showPlanMsg("Update OK","Update OK");
        return;
      }
    }catch(Exception exp){
      exp.printStackTrace();
       util.ExceptionLog.exp2File(exp,"");
        exgui.verification.VerifyLib.showAlert("Server Side Error\nPlease Contact System Manager",
                                         "Remote Error");
      return;
    }

  }

  void btnUpdateProfitCode_actionPerformed(ActionEvent e) {
    Object dateFrom=dbTxtDateBgn.getSelectedValue();
    Object dateTo=dbTxtDateTo.getSelectedValue();
    if(dateFrom==null &&
       dateTo==null){
      exgui.verification.VerifyLib.showAlert("Please Assign At Least One ETD DATE",
                                             "Please Assign At Least One ETD DATE");
      return;
    }
    try{
      if (ejbFunc == null) {
        getEJB();
      }
    }catch(Exception exp){
      exp.printStackTrace();
    }
    try{
      if (ejbFunc == null) {
        getEJB();
      }
    }catch(Exception exp){
      exp.printStackTrace();
    }
    try{
      if (ejbFunc == null) {
        getEJB();
      }
    }catch(Exception exp){
      exp.printStackTrace();
    }
    try{
      if (ejbFunc == null) {
        getEJB();
      }
    }catch(Exception exp){
      exp.printStackTrace();
    }
    if(ejbFunc==null){
      exgui.verification.VerifyLib.showAlert("Failed To lookup EJB for updating profit share code\nPlease Contact System Manager",
                                             "Failed To lookup EJB");
      return;
    }
    try{
      if (ejbFunc != null) {
        String depPrefix=(String)dbCbxDep.getSelectedValue();
        java.util.HashMap hmPara=new java.util.HashMap();
        hmPara.put("DEP_PREFIX",(depPrefix==null||depPrefix.equals(""))?null:depPrefix);
        hmPara.put("IS_FORCE_OVER_WRITE",new Boolean(cbxIsForceOverWriteProftShareCode.isSelected()));
        Object makerSeq=slkMakerToFiterSc4ProfitShare.getSelectedValue();
        hmPara.put("PROD_MAKER_SEQ",(makerSeq==null)?null:makerSeq.toString());
        util.MiscFunc.showProcessingMessage();
        ejbFunc.updateProfitShareCode(
            util.PublicVariable.USER_RECORD.get(0).toString(),
           ((dateFrom==null)?null:txtEtdFrom.getText().trim()),
           ((dateTo==null)?null:txtEtdTo.getText().trim()),
           hmPara);


        /*
         ejbFunc.updateProfitShareCode(
             util.PublicVariable.USER_RECORD.get(0).toString(),
            ((dateFrom==null)?null:txtEtdFrom.getText().trim()),
            ((dateTo==null)?null:txtEtdTo.getText().trim()));
          */
        exgui.verification.VerifyLib.showPlanMsg("Update OK","Update OK");
        util.MiscFunc.hideProcessingMessage();
        return;
      }else{
        exgui.verification.VerifyLib.showAlert("Error While Connect To server\nPlease Contact System Manager",
                                               "Error While Connect To server");
      }
    }catch(Exception exp){
      exp.printStackTrace();
       util.ExceptionLog.exp2File(exp,"");
        exgui.verification.VerifyLib.showAlert("Server Side Error\nPlease Contact System Manager",
                                         "Remote Error");
      return;
    }


  }

  void btnExit_actionPerformed(ActionEvent e) {
    try{
      processhandler.template.Properties.getCenteralControler().goBack();
    }catch(Exception exp){
      exp.printStackTrace();
    }


  }
  JButton btnChgPftShareCode = new JButton();
  JButton btnDebitNoteUserMaintain = new JButton();
  JLabel jLabel4 = new JLabel();
  JComboBox cbxDep = new JComboBox();
  JCheckBox cbxIsForceOverWriteProftShareCode = new JCheckBox();
  SelectBuyerMaker slkMakerToFiterSc4ProfitShare = new SelectBuyerMaker();
  JLabel jLabel5 = new JLabel();
  JButton btnCurrencyReport = new JButton();
  JPanel pnlYY_accItem = new JPanel();
  Border border3;
  TitledBorder titledBorder4;
  JButton btnRptAccOpInout = new JButton();
  JButton btnRpt_1101_1102 = new JButton();
  JButton btnRpt_1103_3zzz = new JButton();
  JPanel pnlNBbatchFunc = new JPanel();
  Border border4;
  TitledBorder titledBorder5;
  JButton btnBatchAdd = new JButton();
  JButton btnBatchUpdateRemark = new JButton();
  JButton btnBurtonRotateExcel = new JButton();
  JButton btnNthkShipMark = new JButton();
  JButton btnNtfeShipMark = new JButton();
  JButton btnBurtonPriceUpdate = new JButton();

  void btnChgPftShareCode_actionPerformed(ActionEvent e) {
    try{
      processhandler.template.Properties.getCenteralControler().doCommandExecute(
      new TgrToGenTPE_CHG_PROFIT_SHARE_CODE());
    }catch(Exception exp){
      exp.printStackTrace();
    }
  }

  void btnDebitNoteUserMaintain_actionPerformed(ActionEvent e) {
    try{
      newtimes.accounting.debit_note_user.Constants.pnl2Qry=null;
      processhandler.template.Properties.getCenteralControler().doCommandExecute(
      new newtimes.accounting.debit_note_user.TgrQryGui());
    }catch(Exception exp){
      exp.printStackTrace();
    }

  }
  void btnFtyExam_actionPerformed(ActionEvent e) {
    /*
    try{
      processhandler.template.Properties.getCenteralControler().doCommandExecute(
      new newtimes.fty_exam.TgrFtyExamFuncList());
    }catch(Exception exp){
      exp.printStackTrace();
    }
    */

  }
  void btnCurrencyReport_actionPerformed(ActionEvent e) {
    try{
      processhandler.template.Properties.getCenteralControler().doCommandExecute(
      new TgrExchangeRate());
    }catch(Exception exp){
      exp.printStackTrace();
    }

  }

  void btnRptAccOpInout_actionPerformed(ActionEvent e) {
    try{
      processhandler.template.Properties.getCenteralControler().doCommandExecute(
      new TgrRptAccItemYearly("ACC_OP_INOUT.rpt","全年度分類帳(費用/收入)"));
    }catch(Exception exp){
      exp.printStackTrace();
    }

  }

  void btnRpt_1101_1102_actionPerformed(ActionEvent e) {
    try{
      processhandler.template.Properties.getCenteralControler().doCommandExecute(
            new TgrRptAccItemYearly("ACC_1101_1102.rpt","全年度分類帳(現金,銀行)"));
    }catch(Exception exp){
      exp.printStackTrace();
    }

  }

  void btnRpt_1103_3zzz_actionPerformed(ActionEvent e) {
    try{
      processhandler.template.Properties.getCenteralControler().doCommandExecute(
            new TgrRptAccItemYearly("ACC_1103_3ZZZ.rpt","全年度分類帳(資產,負債)"));
    }catch(Exception exp){
      exp.printStackTrace();
    }

  }

  void btnBatchAdd_actionPerformed(ActionEvent e) {
     DlgTpeBatchAddNbProdHead dlg=new DlgTpeBatchAddNbProdHead(util.PublicVariable.APP_FRAME,
          "Batch Generate Prod Head",true);
      dlg.setSize(400,460);
      exgui.UIHelper.setToScreenCenter(dlg);
      dlg.show();
  }
  void btnBatchUpdateRemark_actionPerformed(ActionEvent e) {
      try{
        processhandler.template.Properties.getCenteralControler().doCommandExecute(
              new TgrToGenPnlBatchUpdateRemarks());

      }catch(Exception exp){
        exp.printStackTrace();
      }

  }

  void  btnBurtonPriceUpdate_actionPerformed(ActionEvent e) {
    class myFilter extends javax.swing.filechooser.FileFilter{
        public String ext;
        public String des;

        public boolean accept(java.io.File file){
            if(file != null) {
              if(file.isDirectory()) {
                 return true;
              }
              String filename=file.getName();
              return filename.endsWith(ext);
            }
            return false;
        }
        public String getDescription(){
           return des;
       }

        public myFilter(String extension, String description) {
          if(extension!=null) ext=extension;
          if(description!=null) des=description;
        }

    }


       JFileChooser fc = new JFileChooser();
       fc.setDialogType(fc.OPEN_DIALOG);
       fc.setAcceptAllFileFilterUsed(false);
       fc.addChoosableFileFilter(new myFilter("xls","MS Excel file"));
       setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
       int returnVal = fc.showDialog(this, "SELECT FILE");

       if (returnVal == JFileChooser.APPROVE_OPTION) {

       }else{
         return;
       }

    try{
       util.MiscFunc.showProcessingMessage();
         java.io.File srcFile =fc.getSelectedFile();

         Workbook workbook =Workbook.getWorkbook(srcFile);
         Sheet sheet = workbook.getSheet(0);
         if(sheet.getRows()<2)return;
         Record recBlank=(Record)util.MiscFunc.deepCopy(util.PublicVariable.USER_RECORD);
         recBlank.getValueFields().clear();
         recBlank.getFieldName().clear();
         recBlank.getFieldName().add("PROD_HEAD_PK");
         recBlank.getValueFields().add(null);

         recBlank.getFieldName().add("STY");
         recBlank.getValueFields().add(null);

         recBlank.getFieldName().add("PO");
         recBlank.getValueFields().add(null);

         recBlank.getFieldName().add("COLOR_CODE");
         recBlank.getValueFields().add(null);

         recBlank.getFieldName().add("BUYER_DOC_PRX");
         recBlank.getValueFields().add(null);
         recBlank.getFieldName().add("BUYER_ACT_PRX");
         recBlank.getValueFields().add(null);

         recBlank.getFieldName().add("MAKER_DOC_PRX");
         recBlank.getValueFields().add(null);
         recBlank.getFieldName().add("MAKER_ACT_PRX");
         recBlank.getValueFields().add(null);
         Vector vct=new java.util.Vector();
         for(int i=1;i<sheet.getRows();i++){
           Cell[] cells=sheet.getRow(i);
           if(cells.length<8)continue;
           Record rec2Proc=(Record)util.MiscFunc.deepCopy(recBlank);
           for(int j=0;j<8;j++)rec2Proc.set(j,cellToString(cells[j]));
           vct.add(rec2Proc);
         }
         if(ejbFunc==null)getEJB();
         java.util.HashMap hmParam=new java.util.HashMap();
         hmParam.put("TPEMISCFUNC_ACTION_CODE","UPDATE_BURTON_PRICE");
         hmParam.put("BURTON_PRICE_VCT",vct);
         hmParam.put("USERID",util.PublicVariable.USER_RECORD.get(0));
         ejbFunc.tpeMisFunc(hmParam);
         exgui.verification.VerifyLib.showPlanMsg("Update Ok","Update OK");
    }catch(Exception exp){
      exp.printStackTrace();
      util.ExceptionLog.exp2File(exp,"");
      exgui.verification.VerifyLib.showAlert("Conversion failed\nPlease Contact System Manger",
                                             "Conversion Failed");

    }finally{
      util.MiscFunc.hideProcessingMessage();
    }

  }
  String cellToString(jxl.Cell cell){
     String str=cell.getContents();
     if(str!=null)return str.trim().toUpperCase();
     return str;
  }

  void btnNthkShipMark_actionPerformed(ActionEvent e) {
    try{
       util.MiscFunc.showProcessingMessage();
        newtimesejb.excelhandler.BurtonXlsCnvtHome uploader =
            (newtimesejb.excelhandler.BurtonXlsCnvtHome)
            info_ejb.WeblogicServiceLocator.locateServiceHome(util.
            PublicVariable.SERVER_URL,
            "newtimesejb.excelhandler.BurtonXlsCnvt");
         newtimesejb.excelhandler.BurtonXlsCnvt ejbupload = uploader.create();
          byte[] data2store=ejbupload.getShipMark("NTHK");
          long xntTime=System.currentTimeMillis();
          String fileName=xntTime+"_sip_mark.xls";
          java.io.File fileOutput=new java.io.File("C:\\"+fileName);
          java.io.FileOutputStream fo=new java.io.FileOutputStream(fileOutput);
          fo.write(data2store);
          fo.close();
          exgui.verification.VerifyLib.showAlert("Conversion OK\nFile Name is C:\\"+fileName,"Conversion OK");
    }catch(Exception exp){
      exp.printStackTrace();
      util.ExceptionLog.exp2File(exp,"");
      exgui.verification.VerifyLib.showAlert("Conversion failed\nPlease Contact System Manger",
                                             "Conversion Failed");

    }finally{
      util.MiscFunc.hideProcessingMessage();
    }

  }
  void btnNtfeShipMark_actionPerformed(ActionEvent e) {
    try{
       util.MiscFunc.showProcessingMessage();
        newtimesejb.excelhandler.BurtonXlsCnvtHome uploader =
            (newtimesejb.excelhandler.BurtonXlsCnvtHome)
            info_ejb.WeblogicServiceLocator.locateServiceHome(util.
            PublicVariable.SERVER_URL,
            "newtimesejb.excelhandler.BurtonXlsCnvt");
         newtimesejb.excelhandler.BurtonXlsCnvt ejbupload = uploader.create();
          byte[] data2store=ejbupload.getShipMark("NTFE");
          long xntTime=System.currentTimeMillis();
          String fileName=xntTime+"_sip_mark.xls";
          java.io.File fileOutput=new java.io.File("C:\\"+fileName);
          java.io.FileOutputStream fo=new java.io.FileOutputStream(fileOutput);
          fo.write(data2store);
          fo.close();
          exgui.verification.VerifyLib.showAlert("Conversion OK\nFile Name is C:\\"+fileName,"Conversion OK");
    }catch(Exception exp){
      exp.printStackTrace();
      util.ExceptionLog.exp2File(exp,"");
      exgui.verification.VerifyLib.showAlert("Conversion failed\nPlease Contact System Manger",
                                             "Conversion Failed");

    }finally{
      util.MiscFunc.hideProcessingMessage();
    }

  }
  void btnBurtonRotateExcel_actionPerformed(ActionEvent e) {

    class myFilter extends javax.swing.filechooser.FileFilter{
        public String ext;
        public String des;

        public boolean accept(java.io.File file){
            if(file != null) {
              if(file.isDirectory()) {
                 return true;
              }
              String filename=file.getName();
              return filename.endsWith(ext);
            }
            return false;
        }
        public String getDescription(){
           return des;
       }

        public myFilter(String extension, String description) {
          if(extension!=null) ext=extension;
          if(description!=null) des=description;
        }

    }


       JFileChooser fc = new JFileChooser();
       fc.setDialogType(fc.OPEN_DIALOG);
       fc.setAcceptAllFileFilterUsed(false);
       fc.addChoosableFileFilter(new myFilter("xls","MS Excel file"));
       setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
       int returnVal = fc.showDialog(this, "SELECT FILE");

       if (returnVal == JFileChooser.APPROVE_OPTION) {

       }else{
         return;
       }

    try{
       util.MiscFunc.showProcessingMessage();

        newtimesejb.excelhandler.BurtonXlsCnvtHome uploader =
            (newtimesejb.excelhandler.BurtonXlsCnvtHome)
            info_ejb.WeblogicServiceLocator.locateServiceHome(util.
            PublicVariable.SERVER_URL,
            "newtimesejb.excelhandler.BurtonXlsCnvt");
         newtimesejb.excelhandler.BurtonXlsCnvt ejbupload = uploader.create();
         java.io.File srcFile =fc.getSelectedFile();
           java.io.BufferedInputStream   bis=new
               java.io.BufferedInputStream(new java.io.FileInputStream(srcFile));
           byte[] data2upload =new byte[bis.available()];
           bis.read(data2upload);
           bis.close();
          java.util.HashMap hmResult=ejbupload.rotateExcel(data2upload);
          Object objResult=hmResult.get("RESULT");
          if(null!=objResult){
            String strMsg=(String)hmResult.get("MSG");
            //System.out.println("\n\n"+strMsg);
            byte[] data2store=(byte[])objResult;
            long xntTime=System.currentTimeMillis();
            String fileName=xntTime+"_burton.xls";
            java.io.File fileOutput=new java.io.File("C:\\"+fileName);
            java.io.FileOutputStream fo=new java.io.FileOutputStream(fileOutput);
            fo.write(data2store);
            fo.close();
            exgui.verification.VerifyLib.showAlert("Conversion OK\nFile Name is C:\\"+fileName,"Conversion OK");
          }else{
            String msg=(String)hmResult.get("Error");
            exgui.verification.VerifyLib.showAlert("Error:"+msg,"Conversion failed!!");
          }


    }catch(Exception exp){
      exp.printStackTrace();
      util.ExceptionLog.exp2File(exp,"");
      exgui.verification.VerifyLib.showAlert("Conversion failed\nPlease Contact System Manger",
                                             "Conversion Failed");

    }finally{
      util.MiscFunc.hideProcessingMessage();
    }


  }

}
