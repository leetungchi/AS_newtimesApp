package newtimes.general_voucher.daily_voucher;

import java.awt.*;
import exgui.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import exgui.*;
import javax.swing.*;
import newtimes.preproduction.buyermakerselect.*;
import java.awt.event.*;
import newtimes.production.report.*;
import java.util.*;
import javax.swing.border.*;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class PnlRptTktFee
    //extends JPanel {
     extends AbsQryPanel{
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel1 = new BlueBkgWhiteCharLabel();
  WhiteBkgBlueCharLabel whiteBkgBlueCharLabel1 = new WhiteBkgBlueCharLabel();
  JComboBox cbxCompany = new JComboBox();
  WhiteBkgBlueCharLabel whiteBkgBlueCharLabel2 = new WhiteBkgBlueCharLabel();
  JTextField txtDateFrom = new JTextField();
  JTextField txtDateTo = new JTextField();
  WhiteBkgBlueCharLabel whiteBkgBlueCharLabel3 = new WhiteBkgBlueCharLabel();
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel2 = new BlueBkgWhiteCharLabel();
  JComboBox cbxTvlAgc = new JComboBox();
  JComboBox cbxAirCo = new JComboBox();
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel3 = new BlueBkgWhiteCharLabel();
  JComboBox cbxClass = new JComboBox();
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel4 = new BlueBkgWhiteCharLabel();
  JComboBox cbxType = new JComboBox();
  WhiteBkgBlueCharLabel whiteBkgBlueCharLabel4 = new WhiteBkgBlueCharLabel();
  WhiteBkgBlueCharLabel whiteBkgBlueCharLabel5 = new WhiteBkgBlueCharLabel();
  JComboBox cbxCnty = new JComboBox();
  JComboBox cbxGrpBy = null;//new JComboBox();
  WhiteBkgBlueCharLabel whiteBkgBlueCharLabel6 = new WhiteBkgBlueCharLabel();
  JButton btnQry = new JButton();

  public PnlRptTktFee() {
    try {
      //jbInit();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }

public  void jbInit() throws Exception {
    exgui.ultratable.Wraper4tblCbx mdl[]=new exgui.ultratable.Wraper4tblCbx[2];
    mdl[0]=new exgui.ultratable.Wraper4tblCbx("A","航空公司");
    mdl[1]=new exgui.ultratable.Wraper4tblCbx("C","旅行社");
    cbxGrpBy=new JComboBox(mdl);

    blueBkgWhiteCharLabel1.setFont(new java.awt.Font("Dialog", 0, 16));
    blueBkgWhiteCharLabel1.setText("購買機票明細");
    blueBkgWhiteCharLabel1.setBounds(new Rectangle(-1, 9, 806, 26));
    this.setBackground(new Color(202, 202, 224));
    this.setLayout(null);
    whiteBkgBlueCharLabel1.setText("公司");
    whiteBkgBlueCharLabel1.setBounds(new Rectangle(3, 42, 63, 24));
    cbxCompany.setBounds(new Rectangle(66, 42, 200, 24));
    whiteBkgBlueCharLabel2.setBounds(new Rectangle(282, 42, 63, 24));
    whiteBkgBlueCharLabel2.setFont(new java.awt.Font("Dialog", 0, 12));
    whiteBkgBlueCharLabel2.setText("傳票日期");
    txtDateFrom.setText("");
    txtDateFrom.setBounds(new Rectangle(345, 42, 69, 26));
    txtDateTo.setBounds(new Rectangle(453, 42, 69, 26));
    txtDateTo.setText("2009/12/31");
    txtDateTo.setText("");
    whiteBkgBlueCharLabel3.setText("~");
    whiteBkgBlueCharLabel3.setFont(new java.awt.Font("Dialog", 1, 16));
    whiteBkgBlueCharLabel3.setBounds(new Rectangle(413, 42, 39, 24));
    blueBkgWhiteCharLabel2.setFont(new java.awt.Font("Dialog", 0, 16));
    blueBkgWhiteCharLabel2.setText("旅行社");
    blueBkgWhiteCharLabel2.setBounds(new Rectangle(3, 74, 63, 24));
    cbxTvlAgc.setBounds(new Rectangle(66, 74, 143, 24));
    cbxAirCo.setBounds(new Rectangle(300, 74, 179, 24));
    blueBkgWhiteCharLabel3.setBounds(new Rectangle(216, 74, 85, 24));
    blueBkgWhiteCharLabel3.setText("航空公司");
    blueBkgWhiteCharLabel3.setFont(new java.awt.Font("Dialog", 0, 16));
    cbxClass.setBounds(new Rectangle(553, 74, 138, 24));
    blueBkgWhiteCharLabel4.setBounds(new Rectangle(490, 74, 63, 24));
    blueBkgWhiteCharLabel4.setText("艙等");
    blueBkgWhiteCharLabel4.setFont(new java.awt.Font("Dialog", 0, 16));
    cbxType.setBounds(new Rectangle(90, 106, 176, 24));
    whiteBkgBlueCharLabel4.setBounds(new Rectangle(3, 106, 88, 24));
    whiteBkgBlueCharLabel4.setFont(new java.awt.Font("Dialog", 0, 16));
    whiteBkgBlueCharLabel4.setText("機票型態");
    whiteBkgBlueCharLabel5.setText("出差國家 ");
    whiteBkgBlueCharLabel5.setFont(new java.awt.Font("Dialog", 0, 16));
    whiteBkgBlueCharLabel5.setBounds(new Rectangle(283, 106, 88, 24));
    cbxCnty.setBounds(new Rectangle(370, 106, 176, 24));
    cbxGrpBy.setBounds(new Rectangle(626, 42, 132, 24));
    whiteBkgBlueCharLabel6.setBounds(new Rectangle(532, 42, 93, 24));
    whiteBkgBlueCharLabel6.setText("Group By");
    btnQry.setBounds(new Rectangle(664, 105, 118, 25));
    btnQry.setFont(new java.awt.Font("Dialog", 1, 11));
    btnQry.setText("REPORT");
    btnQry.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnQry_actionPerformed(e);
      }
    });
    this.add(blueBkgWhiteCharLabel1, null);
    this.add(whiteBkgBlueCharLabel1, null);
    this.add(cbxCompany, null);
    this.add(blueBkgWhiteCharLabel2, null);
    this.add(cbxTvlAgc, null);
    this.add(blueBkgWhiteCharLabel3, null);
    this.add(cbxAirCo, null);
    this.add(blueBkgWhiteCharLabel4, null);
    this.add(cbxClass, null);
    this.add(cbxType, null);
    this.add(whiteBkgBlueCharLabel4, null);
    this.add(whiteBkgBlueCharLabel5, null);
    this.add(cbxCnty, null);
    this.add(whiteBkgBlueCharLabel6, null);
    this.add(whiteBkgBlueCharLabel3, null);
    this.add(whiteBkgBlueCharLabel2, null);
    this.add(txtDateFrom, null);
    this.add(txtDateTo, null);
    this.add(cbxGrpBy, null);
    this.add(btnQry, null);
    genDataBindObj();
  }
  public void genDataBindObj(){
    try{
      super.reportName="ACC_AIR_TKT.rpt";
      StringBuffer sb=new StringBuffer();
      sb.append("select substr(field_name,length(field_name),1) as cmp_code, ");
      sb.append("field_desc as cmp_name,");
      sb.append("substr(field_name,length(field_name),1)||'--'||field_desc  as comp_code_and_name ");
      sb.append(" from TPE_DATE_RANGE  ");
      sb.append("where record_delete_flag='1'  ");
      sb.append("and CEN_CODE='");sb.append(util.PublicVariable.OPERATTING_CENTER);sb.append("' ");
      sb.append("and FIELD_NAME LIKE 'GV_COMP_%' ");
       Vector vctCmp =exgui2.CONST.BASIC_MAIN_EJB.getDatas(
        util.PublicVariable.USER_RECORD,
        sb.toString(),1,9999);
    exgui.DataBindJCombobox  dbCbxCompany =
         new exgui.DataBindJCombobox(cbxCompany, "P_COMP",
                                     vctCmp,
                                     "comp_code_and_name", "cmp_code",null,"ALL","ALL");
    dataBindComps.add(dbCbxCompany);
    Object vftxtChkDD=exgui.verification.CellFormat.getDateStringFormater();

     exgui.DataBindTextWithChecker dbTxtPayDateFrom= new exgui.DataBindTextWithChecker(txtDateFrom,
                              "P_DATE_FM",
                              null, 10,
                              (exgui.Object2String)vftxtChkDD,
                              (exgui.ultratable.CellTxtEditorFormat)vftxtChkDD);
      dataBindComps.add(dbTxtPayDateFrom);

      exgui.DataBindTextWithChecker dbTxtPayDateTo= new exgui.DataBindTextWithChecker(txtDateTo,
                               "P_DATE_TO",
                               null, 10,
                               (exgui.Object2String)vftxtChkDD,
                               (exgui.ultratable.CellTxtEditorFormat)vftxtChkDD);
       dataBindComps.add(dbTxtPayDateTo);

      Vector VCT_TRAVEL_AGENCY=exgui2.CONST.BASIC_MAIN_EJB.getDatas(
         util.PublicVariable.USER_RECORD,
         "select * from VH_DTL_TKT_TRL_AGC",1,9999);

     Vector VCT_AIRE_CO=exgui2.CONST.BASIC_MAIN_EJB.getDatas(
       util.PublicVariable.USER_RECORD,
       "select * from VH_DTL_TKT_AIR_CO",1,9999);

    Vector VCT_SEAT_CLASS=exgui2.CONST.BASIC_MAIN_EJB.getDatas(
      util.PublicVariable.USER_RECORD,
       "select * from VH_DTL_TKT_SEAT_CLASS",1,9999);

    Vector    VCT_TICKET_TYPE=exgui2.CONST.BASIC_MAIN_EJB.getDatas(
         util.PublicVariable.USER_RECORD,
         "select * from VH_DTL_TKT_TYPE",1,9999);

   exgui.DataBindJCombobox dbCbxTravelAgency = new exgui.DataBindJCombobox(
       cbxTvlAgc, "P_AG", VCT_TRAVEL_AGENCY, "AGC_NAME", "AGC_CODE",
       null,"ALL","ALL");
   dataBindComps.add(dbCbxTravelAgency);

   exgui.DataBindJCombobox dbAirCo =
       new exgui.DataBindJCombobox(cbxAirCo, "P_AC",
                                   VCT_AIRE_CO, "CO_NAME", "CO_CODE",
                                   null,"ALL","ALL");
   dataBindComps.add(dbAirCo);

   exgui.DataBindJCombobox DbJcbxcbxSeatClass =
       new exgui.DataBindJCombobox(cbxClass, "P_CLASS",
                                   VCT_SEAT_CLASS, "CLASS_NAME",
                                   "CLASS_CODE",
                                   null,"ALL","ALL");
   dataBindComps.add(DbJcbxcbxSeatClass);

   exgui.DataBindJCombobox DbJcbxcbxTktType =
       new exgui.DataBindJCombobox(cbxType, "P_TYPE",
                                   VCT_TICKET_TYPE, "TYPE_NAME", "TYPE_CODE",
                                   null,"ALL","ALL");
   dataBindComps.add(DbJcbxcbxTktType);

 exgui.DataBindJCombobox   DbJcbxcbxCnty1 =
       new exgui.DataBindJCombobox(cbxCnty, "P_COUNTRY",
                                   newtimes.preproduction.guis.
                                   tempProperties.tmpCountries, "CNTY_NAME",
                                   "CNTY_NAME",
                                   null,"ALL","ALL");
   dataBindComps.add(DbJcbxcbxCnty1);
    } catch(Exception exp){
      exp.printStackTrace();
    }
  }
  public HashMap composeParameters(){
    HashMap hm=super.composeParameters();
    exgui.ultratable.Wraper4tblCbx cbxGrpByValue=(exgui.ultratable.Wraper4tblCbx)cbxGrpBy.getSelectedItem();
    hm.put("P_GRP",cbxGrpByValue.getValue());
    int year=util.MiscFunc.getYear(new java.sql.Date(System.currentTimeMillis()));
    if(txtDateFrom.getText().trim().length()==0){
      hm.put("P_DATE_FM","DATE("+String.valueOf(year)+",01,01)");
    }
    if(txtDateTo.getText().trim().length()==0){
      hm.put("P_DATE_TO","DATE("+String.valueOf(year)+",12,31)");
    }

    return hm;
  }
  void btnQry_actionPerformed(ActionEvent e) {
    String tmpUrl=newtimes.production.report.ReportCmdSet.myReportEngin.reportServerURL;
    newtimes.production.report.ReportCmdSet.myReportEngin.reportServerURL=
    "http://rpt2.nttpe.com.tw:9000/?file:///cc53//rpt//";
  super.JButtonQueryButtonAction(null);
   newtimes.production.report.ReportCmdSet.myReportEngin.reportServerURL=tmpUrl;

  }
}
