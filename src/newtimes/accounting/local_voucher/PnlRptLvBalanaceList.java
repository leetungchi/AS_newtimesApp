package newtimes.accounting.local_voucher;

import java.awt.*;
import exgui.*;
import javax.swing.*;
import newtimes.preproduction.buyermakerselect.*;
import java.awt.*;
import exgui.*;
import javax.swing.*;
import newtimes.preproduction.buyermakerselect.*;
import java.awt.event.*;
import newtimes.production.report.*;
import javax.swing.border.*;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class PnlRptLvBalanaceList
  //extends JPanel {
  extends AbsQryPanel{
  WhiteBkgBlueCharLabel whiteBkgBlueCharLabel1 = new WhiteBkgBlueCharLabel();
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel1 = new BlueBkgWhiteCharLabel();
  JComboBox cbxDep = new JComboBox();
  JTextField txtEtdFrom = new JTextField();
  JTextField txtEtdTo = new JTextField();
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel4 = new BlueBkgWhiteCharLabel();
  JButton btnQry = new JButton();
  exgui.DataBindTextWithChecker dbTxtFrom,dbTxtEnd;
  DataBindJCombobox dbCbxDep;
  JTextField txtMakerNameEng = new JTextField();
  JTextField txtMakerNameMdn = new JTextField();
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel5 = new BlueBkgWhiteCharLabel();
  String makerSeq;
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel6 = new BlueBkgWhiteCharLabel();
  JComboBox cbxRptName = new JComboBox(new String[]{"SUMMARY 1","SUMMARY 2","DETAIL"});
  JTextField txtRemarkAt = new JTextField();
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel7 = new BlueBkgWhiteCharLabel();
  JPanel pnlEtdFromTo = new JPanel();
  Border border1;
  TitledBorder titledBorder1;
  JLabel jLabel1 = new JLabel();
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel8 = new BlueBkgWhiteCharLabel();
  SelectBuyerMaker slkBuyer = new SelectBuyerMaker();
  public PnlRptLvBalanaceList() {
    try {
      //jbInit();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }

  void jbInit() throws Exception {
    border1 = BorderFactory.createEmptyBorder();
    titledBorder1 = new TitledBorder(new EtchedBorder(EtchedBorder.RAISED,Color.white,new Color(148, 145, 140)),"ETD FROM & TO");
    whiteBkgBlueCharLabel1.setText("LOCAL VOUCHER BALANCE LIST");
    whiteBkgBlueCharLabel1.setBounds(new Rectangle(-1, 4, 804, 25));
    this.setBackground(new Color(202, 202, 224));
    this.setLayout(null);
    blueBkgWhiteCharLabel1.setText("DEP.");
    blueBkgWhiteCharLabel1.setBounds(new Rectangle(2, 44, 52, 26));
    cbxDep.setBounds(new Rectangle(52, 44, 170, 26));
    txtEtdFrom.setText("");
    txtEtdFrom.setBounds(new Rectangle(5, 15, 72, 26));
    txtEtdTo.setText("");
    txtEtdTo.setBounds(new Rectangle(95, 15, 71, 26));
    blueBkgWhiteCharLabel4.setBounds(new Rectangle(223, 85, 71, 26));
    blueBkgWhiteCharLabel4.setText("MAKER");
    btnQry.setBounds(new Rectangle(708, 85, 76, 28));
    btnQry.setFont(new java.awt.Font("Dialog", 1, 11));
    btnQry.setText("REPORT");
    btnQry.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnQry_actionPerformed(e);
      }
    });
    txtMakerNameEng.setText("");
    txtMakerNameEng.setBounds(new Rectangle(294, 85, 141, 26));
    txtMakerNameMdn.setBounds(new Rectangle(294, 44, 142, 26));
    txtMakerNameMdn.setText("jTextField1");
    txtMakerNameMdn.setText("");
    blueBkgWhiteCharLabel5.setFont(new java.awt.Font("Dialog", 0, 14));
    blueBkgWhiteCharLabel5.setText("¼t°Ó¦WºÙ");
    blueBkgWhiteCharLabel5.setBounds(new Rectangle(223, 44, 71, 26));
    blueBkgWhiteCharLabel6.setBounds(new Rectangle(2, 85, 107, 26));
    blueBkgWhiteCharLabel6.setText("REPORT TYPE");
    cbxRptName.setBounds(new Rectangle(110, 85, 112, 26));
    cbxRptName.setSelectedIndex(1);
    txtRemarkAt.setBounds(new Rectangle(578, 44, 48, 26));
    txtRemarkAt.setToolTipText("YYYYMM");
    txtRemarkAt.setText("");
    blueBkgWhiteCharLabel7.setText("REMARK AT (YYYYMM) :");
    blueBkgWhiteCharLabel7.setBounds(new Rectangle(438, 44, 141, 26));
    pnlEtdFromTo.setBackground(new Color(202, 202, 224));
    pnlEtdFromTo.setBorder(titledBorder1);
    pnlEtdFromTo.setBounds(new Rectangle(625, 31, 171, 50));
    pnlEtdFromTo.setLayout(null);
    jLabel1.setFont(new java.awt.Font("Dialog", 1, 11));
    jLabel1.setHorizontalAlignment(SwingConstants.CENTER);
    jLabel1.setHorizontalTextPosition(SwingConstants.CENTER);
    jLabel1.setText("TO");
    jLabel1.setBounds(new Rectangle(77, 16, 19, 24));
    blueBkgWhiteCharLabel8.setText("BUYER");
    blueBkgWhiteCharLabel8.setBounds(new Rectangle(438, 85, 71, 26));
    slkBuyer.setBounds(new Rectangle(509, 85, 187, 26));
    pnlEtdFromTo.add(txtEtdFrom, null);
    pnlEtdFromTo.add(jLabel1, null);
    pnlEtdFromTo.add(txtEtdTo, null);
    this.add(blueBkgWhiteCharLabel7, null);
    this.add(blueBkgWhiteCharLabel1, null);
    this.add(cbxDep, null);
    this.add(blueBkgWhiteCharLabel5, null);
    this.add(txtMakerNameMdn, null);
    this.add(txtRemarkAt, null);
    this.add(pnlEtdFromTo, null);
    this.add(btnQry, null);
    this.add(blueBkgWhiteCharLabel6, null);
    this.add(cbxRptName, null);
    this.add(blueBkgWhiteCharLabel4, null);
    this.add(txtMakerNameEng, null);
    this.add(whiteBkgBlueCharLabel1, null);
    this.add(blueBkgWhiteCharLabel8, null);
    this.add(slkBuyer, null);
    slkBuyer.init("",null,slkBuyer.TYPE_BUYER,true);
    genDataBindObj();
    reportName="DB_BLNC.rpt";

  }
  public void genDataBindObj(){
    try{
      dataBindComps.clear();

      //slkMaker.init("P_MAKER", null, slkMaker.TYPE_MAKER, true);
      dbCbxDep=
         new exgui.DataBindJCombobox(
              cbxDep,"P_DEP",
              newtimes.preproduction.guis.tempProperties.tmpDepartment,
              "DEP_NAME", "DEP_CODE",
              "ALL","ALL","ALL");
      dataBindComps.add(dbCbxDep);



        Object vftxtYearMonth = exgui.verification.CellFormat.getDateStringFormaterAllowNull();
        //java.util.Calendar cldr=java.util.Calendar.getInstance();
       dbTxtFrom= new exgui.DataBindTextWithChecker(txtEtdFrom, "P_ETD_FM",
                                          null, 10,
                                          (exgui.Object2String)vftxtYearMonth,
                                          (exgui.ultratable.CellTxtEditorFormat)
                                          vftxtYearMonth);
       dbTxtEnd= new exgui.DataBindTextWithChecker(txtEtdTo, "P_ETD_TO",
                                          null, 10,
                                          (exgui.Object2String)vftxtYearMonth,
                                          (exgui.ultratable.CellTxtEditorFormat)
                                          vftxtYearMonth);

     dataBindComps.add(dbTxtFrom);
     dataBindComps.add(dbTxtEnd);

    }catch(Exception exp){
      exp.printStackTrace();
    }
  }
  public java.util.HashMap composeParameters(){
    java.util.HashMap hm=super.composeParameters();
    /*
    if(!"ALL".equals(dbCbxDep.getSelectedValue())){
      hm.put(dbCbxDep.getOrgRecField(),"'"+dbCbxDep.getSelectedValue()+"'");
    }*/
    //Object objMaker=slkMaker.getSelectedValue();
    //hm.put(slkMaker.getOrgRecField(),(null==objMaker)?"0": objMaker.toString());
    hm.put("P_MAKER","["+makerSeq+"]");
    Object objEtdFrom=dbTxtFrom.getSelectedValue();
    Object objEtdTo=dbTxtEnd.getSelectedValue();
    if(null==objEtdFrom)hm.put(dbTxtFrom.getOrgRecField(),"DATE(2000,01,01)");
    if(null==objEtdTo)hm.put(dbTxtEnd.getOrgRecField(),"DATE(2099,12,31)");
    hm.put("P_CENTER",util.PublicVariable.OPERATTING_CENTER);
    if(txtRemarkAt.getText().trim().length()==0){
       hm.put("P_RMK_YM","209912");
    }else{
      hm.put("P_RMK_YM",txtRemarkAt.getText());
    }
     Object buyerObj=slkBuyer.getSelectedValue();
    hm.put("P_BUYER",(buyerObj==null)?"0":buyerObj.toString());
    return hm;
  }

  void btnQry_actionPerformed(ActionEvent e) {
    //test if maker name exists
    if(txtMakerNameMdn.getText().trim().length()>0 || txtMakerNameEng.getText().trim().length()>0){
      util.MiscFunc.showProcessingMessage();
      StringBuffer sb = new StringBuffer();
      sb.append("select bymkr_seq from buyer_maker where record_delete_flag='1' ");
      sb.append(" and BYMKR_MULTI_TYPE like '%,2,%' ");
      sb.append(" and SELECTABLE_CENTER like '%,");
      sb.append(util.PublicVariable.OPERATTING_CENTER);
      sb.append(",%' ");

      if (txtMakerNameEng.getText().trim().length() > 0) {
        String makerName = txtMakerNameEng.getText().trim();
        sb.append(" and (");
        sb.append(" bymkr_brief like '%");
        sb.append(util.MiscFunc.Replace(makerName, "'", "''"));
        sb.append("%' or ");

        sb.append(" BYMKR_CHINESE_BRIEF like '%");
        sb.append(util.MiscFunc.Replace(makerName, "'", "''"));
        sb.append("%' ) ");
      }

      if (txtMakerNameMdn.getText().trim().length() > 0) {
        String makerName = txtMakerNameMdn.getText().trim();
        sb.append(" and (");
        sb.append(" bymkr_brief like '%");
        sb.append(util.MiscFunc.Replace(makerName, "'", "''"));
        sb.append("%' or ");

        sb.append(" BYMKR_CHINESE_BRIEF like '%");
        sb.append(util.MiscFunc.Replace(makerName, "'", "''"));
        sb.append("%' ) ");
      }
      try {
        java.util.Vector vct = exgui2.CONST.BASIC_MAIN_EJB.getDatas(
            util.PublicVariable.USER_RECORD,
            sb.toString(),
            1, 99999
            );
        if (vct.size()!= 0){
              /*
              database.datatype.Record recMaker = (database.datatype.Record)vct.get(0);
              makerSeq = recMaker.getInt(0);
              */
             StringBuffer sbMkr=new StringBuffer();
             for(int i=0;i<vct.size();i++){
               database.datatype.Record recMaker = (database.datatype.Record)vct.get(i);
               if(i>0)sbMkr.append(",");
               sbMkr.append(recMaker.get(0).toString());
             }
             makerSeq=sbMkr.toString();
          }else makerSeq = "0";
      } catch (Exception exp) {
        exp.printStackTrace();
        util.ExceptionLog.exp2File(exp, "");
        exgui.verification.VerifyLib.showAlert(
            "Error In Retrieving Maker Data\nPlease Contact System Manager",
            "Error In Retrieving Maker Data");
      }

      util.MiscFunc.hideProcessingMessage();
    }else{
      makerSeq="0";
    }

    String tempURL= newtimes.production.report.ReportProxyEngine.reportServerURL ;
    newtimes.production.report.ReportProxyEngine.reportServerURL="http://rpt2.nttpe.com.tw:9000/?file:///rpt//";
    if(cbxRptName.getSelectedIndex()==0){
      reportName="DB_BLNC_SUM.rpt";
    } else  if(cbxRptName.getSelectedIndex()==1){
       reportName="DB_BLNC_SUM_2.rpt";
    }else{
      reportName="DB_BLNC.rpt";
    }
    super.JButtonQueryButtonAction(null);
    newtimes.production.report.ReportProxyEngine.reportServerURL =tempURL;
  }
}
