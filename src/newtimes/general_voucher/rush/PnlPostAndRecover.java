package newtimes.general_voucher.rush;

import java.awt.*;
import exgui.*;
import javax.swing.*;
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

public class PnlPostAndRecover extends JPanel {
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel1 = new BlueBkgWhiteCharLabel();
  JPanel pnlPost = new JPanel();
  TitledBorder titledBorder1;
  WhiteBkgBlueCharLabel whiteBkgBlueCharLabel1 = new WhiteBkgBlueCharLabel();
  JComboBox cbxCompany = new JComboBox();
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel2 = new BlueBkgWhiteCharLabel();
  JTextField txtGvYYYYMM = new JTextField();
  JTextField txtVhDateFrom = new JTextField();
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel3 = new BlueBkgWhiteCharLabel();
  JButton btnToPost = new JButton();
  JButton btnToRecover = new JButton();
  JTextField txtGvYYYYMM4Recover = new JTextField();
  JComboBox cbxCompany4Recover = new JComboBox();
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel5 = new BlueBkgWhiteCharLabel();
  JPanel pnlRecover = new JPanel();
  WhiteBkgBlueCharLabel whiteBkgBlueCharLabel2 = new WhiteBkgBlueCharLabel();
  Border border1;
  TitledBorder titledBorder2;
  JButton btnExit = new JButton();
  exgui.DataBindJCombobox dbCbxCompany=null,dbCbxCompany4Recover=null;
  public PnlPostAndRecover() {
    try {
      jbInit();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }

  void jbInit() throws Exception {
    titledBorder1 = new TitledBorder(BorderFactory.createEtchedBorder(Color.white,new Color(148, 145, 140)),"過帳作業");
    border1 = BorderFactory.createEtchedBorder(Color.white,new Color(148, 145, 140));
    titledBorder2 = new TitledBorder(border1,"還原作業");
    blueBkgWhiteCharLabel1.setFont(new java.awt.Font("Dialog", 1, 16));
    blueBkgWhiteCharLabel1.setText("過帳 & 還原作業");
    blueBkgWhiteCharLabel1.setBounds(new Rectangle(-4, 14, 806, 34));
    this.setBackground(new Color(202, 202, 224));
    this.setLayout(null);
    pnlPost.setBackground(new Color(202, 202, 228));
    pnlPost.setBorder(titledBorder1);
    pnlPost.setBounds(new Rectangle(18, 71, 754, 109));
    pnlPost.setLayout(null);
    whiteBkgBlueCharLabel1.setText("公司");
    whiteBkgBlueCharLabel1.setBounds(new Rectangle(27, 27, 78, 26));
    cbxCompany.setBounds(new Rectangle(104, 27, 274, 26));
    blueBkgWhiteCharLabel2.setFont(new java.awt.Font("Dialog", 1, 16));
    blueBkgWhiteCharLabel2.setText("~");
    blueBkgWhiteCharLabel2.setBounds(new Rectangle(337, 63, 50, 26));
    txtGvYYYYMM.setText("");
    txtGvYYYYMM.setBounds(new Rectangle(517, 27, 86, 26));
    txtVhDateFrom.setBounds(new Rectangle(250, 63, 86, 26));
    txtVhDateFrom.setText("jTextField1");
    txtVhDateFrom.setText("");
    blueBkgWhiteCharLabel3.setBounds(new Rectangle(27, 63, 223, 26));
    blueBkgWhiteCharLabel3.setText("傳票主檔(YYYY/MM/DD)");
    blueBkgWhiteCharLabel3.setFont(new java.awt.Font("Dialog", 1, 16));
    btnToPost.setBounds(new Rectangle(595, 66, 148, 28));
    btnToPost.setFont(new java.awt.Font("Dialog", 1, 16));
    btnToPost.setText("過帳");
    btnToPost.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnToPost_actionPerformed(e);
      }
    });
    btnToRecover.setText("還原");
    btnToRecover.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnToRecover_actionPerformed(e);
      }
    });
    btnToRecover.setFont(new java.awt.Font("Dialog", 1, 16));
    btnToRecover.setBounds(new Rectangle(598, 64, 148, 28));
    txtGvYYYYMM4Recover.setBounds(new Rectangle(560, 27, 86, 26));
    txtGvYYYYMM4Recover.setText("999999");
    cbxCompany4Recover.setBounds(new Rectangle(104, 27, 274, 26));
    blueBkgWhiteCharLabel5.setBounds(new Rectangle(406, 27, 153, 26));
    blueBkgWhiteCharLabel5.setText("科目主檔(YYYYMM)");
    blueBkgWhiteCharLabel5.setFont(new java.awt.Font("Dialog", 1, 16));
    pnlRecover.setLayout(null);
    pnlRecover.setBounds(new Rectangle(18, 209, 754, 184));
    pnlRecover.setBorder(titledBorder2);
    pnlRecover.setBackground(new Color(202, 202, 228));
    whiteBkgBlueCharLabel2.setText("公司");
    whiteBkgBlueCharLabel2.setBounds(new Rectangle(27, 27, 78, 26));
    btnExit.setBounds(new Rectangle(326, 519, 148, 28));
    btnExit.setFont(new java.awt.Font("Dialog", 1, 16));
    btnExit.setText("EXIT");
    btnExit.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnExit_actionPerformed(e);
      }
    });
    txtVhDateTo.setText("");
    txtVhDateTo.setSelectionStart(11);
    txtVhDateTo.setText("");
    txtVhDateTo.setBounds(new Rectangle(387, 63, 86, 26));
    whiteBkgBlueCharLabel3.setBounds(new Rectangle(398, 27, 118, 26));
    whiteBkgBlueCharLabel3.setText("科目主檔(YYYYMM)");
    txtVhDateFrom4Rcvr.setText("");
    txtVhDateFrom4Rcvr.setText("");
    txtVhDateFrom4Rcvr.setBounds(new Rectangle(295, 64, 86, 26));
    txtVhDateTo4Rcvr.setBounds(new Rectangle(432, 64, 86, 26));
    txtVhDateTo4Rcvr.setText("");
    txtVhDateTo4Rcvr.setSelectionStart(11);
    txtVhDateTo4Rcvr.setText("");
    blueBkgWhiteCharLabel4.setFont(new java.awt.Font("Dialog", 1, 16));
    blueBkgWhiteCharLabel4.setText("Clear Detail YYYY/MM/DD for Cost");
    blueBkgWhiteCharLabel4.setBounds(new Rectangle(27, 64, 269, 26));
    blueBkgWhiteCharLabel6.setBounds(new Rectangle(382, 64, 50, 26));
    blueBkgWhiteCharLabel6.setText("~");
    blueBkgWhiteCharLabel6.setFont(new java.awt.Font("Dialog", 1, 16));
    this.add(blueBkgWhiteCharLabel1, null);
    this.add(pnlPost, null);
    pnlPost.add(whiteBkgBlueCharLabel1, null);
    pnlPost.add(cbxCompany, null);
    pnlPost.add(btnToPost, null);
    pnlPost.add(blueBkgWhiteCharLabel3, null);
    pnlPost.add(txtVhDateFrom, null);
    pnlPost.add(blueBkgWhiteCharLabel2, null);
    pnlPost.add(txtVhDateTo, null);
    pnlRecover.add(whiteBkgBlueCharLabel2, null);
    pnlRecover.add(cbxCompany4Recover, null);
    pnlRecover.add(blueBkgWhiteCharLabel5, null);
    pnlRecover.add(txtGvYYYYMM4Recover, null);
    pnlRecover.add(blueBkgWhiteCharLabel4, null);
    pnlRecover.add(txtVhDateFrom4Rcvr, null);
    pnlRecover.add(blueBkgWhiteCharLabel6, null);
    pnlRecover.add(txtVhDateTo4Rcvr, null);
    pnlRecover.add(btnToRecover, null);
    this.add(pnlRecover, null);
    this.add(btnExit, null);
    pnlPost.add(whiteBkgBlueCharLabel3, null);
    pnlPost.add(txtGvYYYYMM, null);

    dbCbxCompany =
      new exgui.DataBindJCombobox(cbxCompany, "",
                                  newtimes.general_voucher.daily_voucher.
                                  Constants.VCT_GV_ACC_COMPANY,
                                  "comp_code_and_name", "cmp_code",null);

    dbCbxCompany4Recover =
       new exgui.DataBindJCombobox(cbxCompany4Recover, "",
                                newtimes.general_voucher.daily_voucher.
                                Constants.VCT_GV_ACC_COMPANY,
                                "comp_code_and_name", "cmp_code",null);
Object objyyyymmVfy=exgui.verification.CellFormat.getIntVerifierAllowNull(6);
exgui.DataBindTextWithChecker dbTxtYYYYMM= new exgui.DataBindTextWithChecker(txtGvYYYYMM,
                         "P_YYYYMM",
                         "999999", 6,
                         (exgui.Object2String)objyyyymmVfy,
                         (exgui.ultratable.CellTxtEditorFormat)objyyyymmVfy);

 exgui.DataBindTextWithChecker dbTxtYYYYMM4Recover= new exgui.DataBindTextWithChecker(txtGvYYYYMM4Recover,
                          "P_YYYYMM",
                          "", 6,
                          (exgui.Object2String)objyyyymmVfy,
                          (exgui.ultratable.CellTxtEditorFormat)objyyyymmVfy);

      Object objDateVfh=exgui.verification.CellFormat.getDateStringFormaterAllowNull();
      exgui.DataBindTextWithChecker dbTxtVhFrom= new exgui.DataBindTextWithChecker(txtVhDateFrom,
                               "P_VH_DATE_FROM",
                                null, 10,
                               (exgui.Object2String)objDateVfh,
                               (exgui.ultratable.CellTxtEditorFormat)objDateVfh);

     exgui.DataBindTextWithChecker dbTxtVhTo= new exgui.DataBindTextWithChecker(txtVhDateTo,
                              "P_VH_DATE_TO",
                              null, 10,
                              (exgui.Object2String)objDateVfh,
                              (exgui.ultratable.CellTxtEditorFormat)objDateVfh);
          exgui.DataBindTextWithChecker dbTxtVhFrom4Rcvr= new exgui.DataBindTextWithChecker(txtVhDateFrom4Rcvr,
                                   "P_VH_DATE_FROM4Rcvr",
                                    null, 10,
                                   (exgui.Object2String)objDateVfh,
                                   (exgui.ultratable.CellTxtEditorFormat)objDateVfh);

         exgui.DataBindTextWithChecker dbTxtVhTo4Rcvr= new exgui.DataBindTextWithChecker(txtVhDateTo4Rcvr,
                                  "P_VH_DATE_TO4Rcvr",
                                  null, 10,
                                  (exgui.Object2String)objDateVfh,
                                  (exgui.ultratable.CellTxtEditorFormat)objDateVfh);




    txtGvYYYYMM4Recover.setText("999999");
    if(util.PublicVariable.USER_RECORD.getInt(2)!=newtimesejb.preproduction.PreProductionHead.USER_TYPE_SUPERVIOSER_MIS){
      txtGvYYYYMM4Recover.setEditable(false);
      txtGvYYYYMM.setEditable(false);
    }

  }

  void btnExit_actionPerformed(ActionEvent e) {
    try{
      processhandler.template.Properties.getCenteralControler().goBack();
    }catch(Exception exp){
      exp.printStackTrace();
    }

  }

  void btnToPost_actionPerformed(ActionEvent e) {
    if(txtGvYYYYMM.getText().trim().length()==0){
      txtGvYYYYMM.setText("999999");
    }
    if(txtVhDateFrom.getText().trim().length()==0){
      exgui.verification.VerifyLib.showAlert("Please Input VH Begin Date","Please Input VH Begin Date");
      return;
    }
    if(txtVhDateTo.getText().trim().length()==0){
      exgui.verification.VerifyLib.showAlert("Please Input VH End Date","Please Input VH End Date");
      return;
    }

    /*
    if(txtVhDateFrom.getText().trim().length()!=6){
      exgui.verification.VerifyLib.showAlert("VH Date Format Error","VH Date Format Error");
      txtVhDateFrom.selectAll();
      txtVhDateFrom.grabFocus();
      return;
    }
    */
    if(txtGvYYYYMM.getText().trim().length()!=6){
      exgui.verification.VerifyLib.showAlert("GV YYYYMM Format Error","GV YYYYMM Format Error");
      txtGvYYYYMM.selectAll();
      txtGvYYYYMM.grabFocus();
      return;
    }

    try{

      util.MiscFunc.showProcessingMessage();
      StringBuffer sb=new StringBuffer();
      String destYyyyMm=txtGvYYYYMM.getText().trim();
      sb.append("select a.* ,");
      sb.append("(select D_C from gv_acc_data where ACC_CODE=A.VH_ACCOUNT and yyyymm='"+destYyyyMm+"' and  rownum=1 ) as cd_of_gv, ");
      sb.append("(select REC_DESC from gv_acc_data where ACC_CODE=A.VH_ACCOUNT and yyyymm='"+destYyyyMm+"'and rownum=1 ) as acc_tw_name ");
      sb.append("from vh_detail a where a.record_delete_flag='1'  ");
      sb.append(" and substr(A.VH_NO,1,1)='");
      sb.append((String)dbCbxCompany.getSelectedValue());
      sb.append("' ");
      //sb.append(" and a.vh_date=to_date('");sb.append(txtVhDateFrom.getText().trim());sb.append("','yyyymm') ");
      sb.append(" and a.vh_date>=to_date('");sb.append(txtVhDateFrom.getText().trim());sb.append("','yyyy/mm/dd') ");
      sb.append(" and a.vh_date<=to_date('");sb.append(txtVhDateTo.getText().trim());sb.append("','yyyy/mm/dd') ");
      sb.append(" order by a.vh_no,a.vh_seq");

      Vector vct=exgui2.CONST.BASIC_MAIN_EJB.getDatas(
      util.PublicVariable.USER_RECORD,
      sb.toString(),1,9999999);
      //test if colum 21--cd_of_gv is blank,if so, stop the process of posting
      for(int i=0;i<vct.size();i++){
        if(((Record)vct.get(i)).get(21)==null){
          Record rec=(Record)vct.get(i);
          String vhNo=rec.get(1).toString();
          int seq=rec.getInt(2);
          exgui.verification.VerifyLib.showAlert("會計科目不符 -- VH#:"+vhNo+" , SEQ:"+seq,"會計科目不符");
          return;
        }
      }
      newtimesejb.dailyVoucher.RushFacadeHome rushEjbHome=
          (newtimesejb.dailyVoucher.RushFacadeHome)
          info_ejb.WeblogicServiceLocator.locateServiceHome(util.PublicVariable.SERVER_URL,
          "newtimesejb.dailyVoucher.RushFacade");
      newtimesejb.dailyVoucher.RushFacade ejb=rushEjbHome.create();
      ejb.postVhToGv(vct,txtGvYYYYMM.getText().trim(),(String)util.PublicVariable.USER_RECORD.get(0));
      exgui.verification.VerifyLib.showPlanMsg("POST Process finished","Process Ok");
      util.MiscFunc.hideProcessingMessage();
    }catch(Exception exp){
      exp.printStackTrace();
      util.ExceptionLog.exp2File(exp,"");
      exgui.verification.VerifyLib.showAlert("Error While Processing \"Post\" Process","Error");
    }

  }

  void btnToRecover_actionPerformed(ActionEvent e) {
    try{


      if(txtVhDateFrom4Rcvr.getText().trim().length()<10){
        exgui.verification.VerifyLib.showAlert("Please Input VH Begin Date For Cost Recovery\n Or Format Error","Please Input VH DTL Begin Date");
        txtVhDateFrom4Rcvr.grabFocus();
        txtVhDateFrom4Rcvr.selectAll();
        return;
      }
      if(txtVhDateTo4Rcvr.getText().trim().length()<10){
        exgui.verification.VerifyLib.showAlert("Please Input VH End Date For Cost Recovery\n Or Format Error","Please Input VH DTL End Date");
        txtVhDateTo4Rcvr.grabFocus();
        txtVhDateTo4Rcvr.selectAll();
        return;
      }


      if(txtGvYYYYMM4Recover.getText().trim().length()==0){
        txtGvYYYYMM4Recover.setText("999999");
      }
      if(txtGvYYYYMM4Recover.getText().trim().length()!=6){
        exgui.verification.VerifyLib.showAlert("GV YYYYMM Format Error","GV YYYYMM Format Error");
        txtGvYYYYMM4Recover.selectAll();
        txtGvYYYYMM4Recover.grabFocus();
        return;
      }
      util.MiscFunc.showProcessingMessage();
      newtimesejb.dailyVoucher.RushFacadeHome rushEjbHome=
          (newtimesejb.dailyVoucher.RushFacadeHome)
          info_ejb.WeblogicServiceLocator.locateServiceHome(util.PublicVariable.SERVER_URL,
          "newtimesejb.dailyVoucher.RushFacade");
      newtimesejb.dailyVoucher.RushFacade ejb=rushEjbHome.create();
      String paramStr=txtGvYYYYMM4Recover.getText().trim()+"||"
                      +txtVhDateFrom4Rcvr.getText().trim()+"||"
                      +txtVhDateTo4Rcvr.getText().trim();
      ejb.recoverFromGv((String)dbCbxCompany4Recover.getSelectedValue(),paramStr,(String)util.PublicVariable.USER_RECORD.get(0));
      exgui.verification.VerifyLib.showPlanMsg("Recover Process finished","Process Ok");
      util.MiscFunc.hideProcessingMessage();


    }catch(Exception exp){
      exp.printStackTrace();
      util.ExceptionLog.exp2File(exp,"");
      exgui.verification.VerifyLib.showAlert("Error While Processing \"Recorver\" Process","Error");
    }
  }
  JTextField txtVhDateTo = new JTextField();
  WhiteBkgBlueCharLabel whiteBkgBlueCharLabel3 = new WhiteBkgBlueCharLabel();
  JTextField txtVhDateFrom4Rcvr = new JTextField();
  JTextField txtVhDateTo4Rcvr = new JTextField();
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel4 = new BlueBkgWhiteCharLabel();
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel6 = new BlueBkgWhiteCharLabel();
}
