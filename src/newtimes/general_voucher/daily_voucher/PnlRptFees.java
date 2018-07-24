package newtimes.general_voucher.daily_voucher;

import java.awt.*;
import exgui.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.*;
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

public class PnlRptFees
    //extends JPanel {
     extends AbsQryPanel{
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel1 = new BlueBkgWhiteCharLabel();
  WhiteBkgBlueCharLabel whiteBkgBlueCharLabel1 = new WhiteBkgBlueCharLabel();
  JComboBox cbxCompany = new JComboBox();
  WhiteBkgBlueCharLabel whiteBkgBlueCharLabel4 = new WhiteBkgBlueCharLabel();
  JTextField txtVhDateFrom = new JTextField();
  JTextField txtVhDateTo = new JTextField();
  WhiteBkgBlueCharLabel whiteBkgBlueCharLabel5 = new WhiteBkgBlueCharLabel();
  JComboBox cbxStaffType = new JComboBox();
  WhiteBkgBlueCharLabel whiteBkgBlueCharLabel6 = new WhiteBkgBlueCharLabel();
  JButton btnQry = new JButton();
  WhiteBkgBlueCharLabel whiteBkgBlueCharLabel7 = new WhiteBkgBlueCharLabel();
  JComboBox cbxBy = new JComboBox(new String[]{"人員","國家"});
  JPanel jPanel1 = new JPanel();
  TitledBorder titledBorder1;
  Border border1;
  TitledBorder titledBorder2;
  JComboBox cbxCountry[] = new JComboBox[5];
  /*
  JComboBox cbxCountry1 = new JComboBox();
  JComboBox cbxCountry2 = new JComboBox();
  JComboBox cbxCountry3 = new JComboBox();
  JComboBox cbxCountry4 = new JComboBox();
  */
  JPanel jPanel2 = new JPanel();
  TitledBorder titledBorder3;
  Border border2;
  TitledBorder titledBorder4;
  JComboBox cbxStaff[] = new JComboBox[5];
  /*
  JComboBox cbxStaff1 = new JComboBox();
  JComboBox cbxStaff2 = new JComboBox();
  JComboBox cbxStaff3 = new JComboBox();
  JComboBox cbxStaff4 = new JComboBox();
  */
  exgui.DataBindJCombobox  dbCbxStaff[]=new exgui.DataBindJCombobox[5];
  exgui.DataBindJCombobox  dbCbxCnty[]=new exgui.DataBindJCombobox[5];
  public PnlRptFees() {
    try {
      //jbInit();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }

  void jbInit() throws Exception {
    for(int i=0;i<5;i++){
       cbxStaff[i]=new JComboBox();
       cbxCountry[i]=new JComboBox();
    }

    titledBorder1 = new TitledBorder("");
    border1 = BorderFactory.createEtchedBorder(Color.white,new Color(148, 145, 140));
    titledBorder2 = new TitledBorder(border1,"Country");
    titledBorder3 = new TitledBorder("");
    border2 = BorderFactory.createEtchedBorder(Color.white,new Color(148, 145, 140));
    titledBorder4 = new TitledBorder(border2,"員工");
    blueBkgWhiteCharLabel1.setFont(new java.awt.Font("Dialog", 0, 16));
    blueBkgWhiteCharLabel1.setText("旅費明細表");
    blueBkgWhiteCharLabel1.setBounds(new Rectangle(-1, 14, 804, 28));
    this.setBackground(new Color(202, 202, 224));
    this.setLayout(null);
    whiteBkgBlueCharLabel1.setFont(new java.awt.Font("Dialog", 0, 16));
    whiteBkgBlueCharLabel1.setText("公司");
    whiteBkgBlueCharLabel1.setBounds(new Rectangle(8, 48, 61, 21));
    cbxCompany.setBounds(new Rectangle(70, 48, 183, 21));
    cbxCountry[0].setBounds(new Rectangle(11, 21, 278, 21));
    whiteBkgBlueCharLabel4.setForeground(Color.white);
    whiteBkgBlueCharLabel4.setFont(new java.awt.Font("Dialog", 0, 16));
    whiteBkgBlueCharLabel4.setBackground(new Color(143, 143, 188));
    whiteBkgBlueCharLabel4.setText("傳票起迄:");
    whiteBkgBlueCharLabel4.setBounds(new Rectangle(257, 48, 96, 21));
    txtVhDateFrom.setText("");
    txtVhDateFrom.setBounds(new Rectangle(353, 48, 67, 21));
    txtVhDateTo.setText("");
    txtVhDateTo.setBounds(new Rectangle(461, 48, 67, 21));
    whiteBkgBlueCharLabel5.setBounds(new Rectangle(420, 48, 41, 21));
    whiteBkgBlueCharLabel5.setText("~");
    whiteBkgBlueCharLabel5.setBackground(new Color(143, 143, 188));
    whiteBkgBlueCharLabel5.setFont(new java.awt.Font("Dialog", 0, 16));
    whiteBkgBlueCharLabel5.setForeground(Color.white);
    cbxStaffType.setBounds(new Rectangle(631, 47, 131, 21));
    whiteBkgBlueCharLabel6.setFont(new java.awt.Font("Dialog", 0, 16));
    whiteBkgBlueCharLabel6.setText("人員類別");
    whiteBkgBlueCharLabel6.setBounds(new Rectangle(541, 47, 90, 21));
    btnQry.setBounds(new Rectangle(654, 111, 126, 27));
    btnQry.setFont(new java.awt.Font("Dialog", 1, 11));
    btnQry.setText("Query");
    btnQry.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnQry_actionPerformed(e);
      }
    });
    whiteBkgBlueCharLabel7.setBounds(new Rectangle(612, 75, 61, 21));
    whiteBkgBlueCharLabel7.setText("BY");
    whiteBkgBlueCharLabel7.setFont(new java.awt.Font("Dialog", 0, 16));
    cbxBy.setBounds(new Rectangle(671, 75, 91, 21));
    jPanel1.setBackground(new Color(202, 202, 224));
    jPanel1.setBorder(titledBorder2);
    jPanel1.setBounds(new Rectangle(9, 74, 297, 168));
    jPanel1.setLayout(null);
    cbxCountry[1].setBounds(new Rectangle(11, 49, 278, 21));
    cbxCountry[2].setBounds(new Rectangle(11, 76, 278, 21));
    cbxCountry[3].setBounds(new Rectangle(11, 104, 278, 21));
    cbxCountry[4].setBounds(new Rectangle(11, 131, 278, 21));
    jPanel2.setBackground(new Color(202, 202, 224));
    jPanel2.setBorder(titledBorder4);
    jPanel2.setBounds(new Rectangle(306, 81, 252, 157));
    jPanel2.setLayout(null);
    cbxStaff[0].setBounds(new Rectangle(8, 19, 233, 21));
    cbxStaff[1].setBounds(new Rectangle(8, 46, 233, 21));
    cbxStaff[2].setBounds(new Rectangle(8, 73, 233, 21));
    cbxStaff[3].setBounds(new Rectangle(8, 100, 233, 21));
    cbxStaff[4].setBounds(new Rectangle(8, 127, 233, 21));
    this.add(blueBkgWhiteCharLabel1, null);
    this.add(whiteBkgBlueCharLabel1, null);
    this.add(cbxCompany, null);
    jPanel1.add(cbxCountry[0], null);
    jPanel1.add(cbxCountry[1], null);
    jPanel1.add(cbxCountry[2], null);
    jPanel1.add(cbxCountry[3], null);
    jPanel1.add(cbxCountry[4], null);
    this.add(jPanel2, null);
    this.add(whiteBkgBlueCharLabel5, null);
    this.add(whiteBkgBlueCharLabel4, null);
    this.add(txtVhDateFrom, null);
    this.add(txtVhDateTo, null);
    jPanel2.add(cbxStaff[0], null);
    jPanel2.add(cbxStaff[1], null);
    jPanel2.add(cbxStaff[2], null);
    jPanel2.add(cbxStaff[3], null);
    jPanel2.add(cbxStaff[4], null);
    this.add(whiteBkgBlueCharLabel6, null);
    this.add(cbxStaffType, null);
    this.add(cbxBy, null);
    this.add(btnQry, null);
    this.add(whiteBkgBlueCharLabel7, null);
    this.add(jPanel1, null);
    genDataBindObj();
  }
   public void genDataBindObj(){
     try{
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
     //DEBITNOTE_USER
     sb=new StringBuffer();
     sb.append("select  USR_CODE,USR_CODE||'--'||USR_NAME as usr_code_name   from  DEBITNOTE_USER order by usr_CODE ");
     Vector vctStaff =exgui2.CONST.BASIC_MAIN_EJB.getDatas(
      util.PublicVariable.USER_RECORD,
      sb.toString(),1,9999);
     for(int i=0;i<5;i++){
        dbCbxStaff[i] =
           new exgui.DataBindJCombobox(cbxStaff[i], "P_USER",
                                       vctStaff,
                                       "usr_code_name", "USR_CODE", null,
                                       "ALL", null);
     }


       Vector vctCnty =exgui2.CONST.BASIC_MAIN_EJB.getDatas(
        util.PublicVariable.USER_RECORD,
        "SELECT  CNTY_NAME from country order by cnty_name",1,9999);

         for(int i=0;i<5;i++){
           dbCbxCnty[i] =
               new exgui.DataBindJCombobox(cbxCountry[i], "P_COUNTRY",
                                           vctCnty,
                                           "CNTY_NAME", "CNTY_NAME", null, "ALL",
                                           null);
         }



         Vector vctStaffType =exgui2.CONST.BASIC_MAIN_EJB.getDatas(
          util.PublicVariable.USER_RECORD,
          "select distinct remark_1 from debitnote_user",1,9999);
          exgui.DataBindJCombobox  dbCbxStaffType =
              new exgui.DataBindJCombobox(cbxStaffType, "P_CAT",
                                       vctStaffType,
                                       "REMARK_1", "REMARK_1",null,"ALL","ALL");
           dataBindComps.add(dbCbxStaffType);
          Object vftxtChkDD=exgui.verification.CellFormat.getDateStringFormaterAllowNull();

           exgui.DataBindTextWithChecker dbTxtPayDateFrom= new exgui.DataBindTextWithChecker(txtVhDateFrom,
                                    "P_DATE_FM",
                                    null, 10,
                                    (exgui.Object2String)vftxtChkDD,
                                    (exgui.ultratable.CellTxtEditorFormat)vftxtChkDD);
            dataBindComps.add(dbTxtPayDateFrom);

            exgui.DataBindTextWithChecker dbTxtPayDateTo= new exgui.DataBindTextWithChecker(txtVhDateTo,
                                     "P_DATE_TO",
                                     null, 10,
                                     (exgui.Object2String)vftxtChkDD,
                                     (exgui.ultratable.CellTxtEditorFormat)vftxtChkDD);
             dataBindComps.add(dbTxtPayDateTo);
             reportName="ACC_DETAIL_TRV.rpt";
     }catch(Exception epx){
       epx.printStackTrace();
       util.ExceptionLog.exp2File(epx,"");
     }
   }
  public HashMap composeParameters(){
    HashMap hm=super.composeParameters();
    StringBuffer sb=new StringBuffer();
    for(int i=0;i<5;i++){
      String staffCode=(String)dbCbxStaff[i].getSelectedValue();
      if(null!=staffCode){
        if(sb.length()>0)sb.append(",");
        sb.append("'");
        sb.append(staffCode);
        sb.append("'");
      }
    }
    if(sb.length()>0){
      hm.put("P_USER","["+sb.toString()+"]");
    }else{
      hm.put("P_USER","['ALL']");
    }

    sb=new StringBuffer();
        for(int i=0;i<5;i++){
          String cnty=(String)dbCbxCnty[i].getSelectedValue();
          if(null!=cnty){
            if(sb.length()>0)sb.append(",");
            sb.append("'");
            sb.append(cnty);
            sb.append("'");
          }
        }
        if(sb.length()>0){
          hm.put("P_COUNTRY","["+sb.toString()+"]");
        }else{
          hm.put("P_COUNTRY","['ALL']");
        }
    /*
    if(txtVhDateFrom.getText().trim().length()==0){
      hm.put("P_DATE_FM","DATE(2009,01,01)");
    }
    if(txtVhDateTo.getText().trim().length()==0){
      hm.put("P_DATE_TO","DATE(2009,06,30)");
    }
    */

    if(cbxBy.getSelectedItem().equals("人員")){
      hm.put("P_GRP","C");
    } else{
      hm.put("P_GRP","U");
     }
    return hm;
  }
  void btnQry_actionPerformed(ActionEvent e) {
    int yearNow=util.MiscFunc.getYear(new java.sql.Date(System.currentTimeMillis()));
    if(txtVhDateFrom.getText().trim().length()==0){
      txtVhDateFrom.setText(String.valueOf(yearNow)+"/01/01");
    }
    if(txtVhDateTo.getText().trim().length()==0){
      txtVhDateTo.setText(String.valueOf(yearNow)+"/12/31");
    }

    String tmpUrl=newtimes.production.report.ReportCmdSet.myReportEngin.reportServerURL;
    newtimes.production.report.ReportCmdSet.myReportEngin.reportServerURL=
    "http://rpt2.nttpe.com.tw:9000/?file:///cc53//rpt//";
 super.JButtonQueryButtonAction(null);
  newtimes.production.report.ReportCmdSet.myReportEngin.reportServerURL=tmpUrl;


  }
}
