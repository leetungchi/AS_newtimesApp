package newtimes.general_voucher.daily_voucher;

import java.awt.*;
import exgui.*;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.event.*;
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

public class PnlRptTelComFee
    //extends JPanel {
    extends AbsQryPanel{
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel1 = new BlueBkgWhiteCharLabel();
  JPanel pnlDep = new JPanel();
  TitledBorder titledBorder1;
  JTextField txtDep[] = new JTextField[5];

  //JComboBox txtDep[0] = new JComboBox();
  //JComboBox txtDep[1] = new JComboBox();
  //JComboBox txtDep[2] = new JComboBox();
  //JComboBox txtDep[3] = new JComboBox();
  //JComboBox txtDep[4] = new JComboBox();
  WhiteBkgBlueCharLabel whiteBkgBlueCharLabel1 = new WhiteBkgBlueCharLabel();
  JComboBox cbxSrc = new JComboBox();
  WhiteBkgBlueCharLabel whiteBkgBlueCharLabel2 = new WhiteBkgBlueCharLabel();
  JTextField txtDateFrom = new JTextField();
  WhiteBkgBlueCharLabel whiteBkgBlueCharLabel3 = new WhiteBkgBlueCharLabel();
  JTextField txtDateTo = new JTextField();
  JCheckBox chkT88 = new JCheckBox();
  JCheckBox chkT99 = new JCheckBox();
  JButton btnQry = new JButton();
  String defaultDep[]=new String[]{"DD","GG","LL",null,null};
  exgui.DataBindTextWithChecker dbTxtDep[]=new exgui.DataBindTextWithChecker[5];
  public PnlRptTelComFee() {
    try {
      //jbInit();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }

  void jbInit() throws Exception {
    for(int i=0;i<5;i++)txtDep[i]=new JTextField();

    titledBorder1 = new TitledBorder(BorderFactory.createEtchedBorder(Color.white,new Color(148, 145, 140)),"DEPARTMENT");
    blueBkgWhiteCharLabel1.setFont(new java.awt.Font("Dialog", 0, 16));
    blueBkgWhiteCharLabel1.setText("郵電費匯總表");
    blueBkgWhiteCharLabel1.setBounds(new Rectangle(0, 15, 802, 30));
    this.setBackground(new Color(202, 202, 224));
    this.setLayout(null);
    pnlDep.setBackground(new Color(202, 202, 224));
    pnlDep.setBorder(titledBorder1);
    pnlDep.setBounds(new Rectangle(5, 47, 657, 51));
    pnlDep.setLayout(null);
    txtDep[0].setBounds(new Rectangle(7, 15, 122, 23));
    txtDep[1].setBounds(new Rectangle(134, 15, 122, 23));
    txtDep[2].setBounds(new Rectangle(256, 15, 122, 23));
    txtDep[3].setBounds(new Rectangle(385, 15, 122, 23));
    txtDep[4].setBounds(new Rectangle(521, 15, 122, 23));
    whiteBkgBlueCharLabel1.setFont(new java.awt.Font("Dialog", 0, 16));
    whiteBkgBlueCharLabel1.setText("來源");
    whiteBkgBlueCharLabel1.setBounds(new Rectangle(8, 98, 58, 24));
    cbxSrc.setBounds(new Rectangle(67, 98, 217, 24));
    whiteBkgBlueCharLabel2.setBounds(new Rectangle(295, 98, 58, 24));
    whiteBkgBlueCharLabel2.setText("日期");
    whiteBkgBlueCharLabel2.setFont(new java.awt.Font("Dialog", 0, 16));
    txtDateFrom.setText("");
    txtDateFrom.setBounds(new Rectangle(354, 98, 69, 24));
    whiteBkgBlueCharLabel3.setFont(new java.awt.Font("Dialog", 1, 16));
    whiteBkgBlueCharLabel3.setText("~");
    whiteBkgBlueCharLabel3.setBounds(new Rectangle(423, 98, 36, 24));
    txtDateTo.setBounds(new Rectangle(460, 98, 69, 24));
    txtDateTo.setText("");
    chkT88.setBackground(new Color(202, 202, 224));
    chkT88.setFont(new java.awt.Font("Dialog", 0, 16));
    chkT88.setMaximumSize(new Dimension(125, 33));
    chkT88.setText("包括其他郵資T88");
    chkT88.setBounds(new Rectangle(9, 128, 169, 24));
    chkT99.setBounds(new Rectangle(232, 128, 169, 24));
    chkT99.setText("包括自費請款T99");
    chkT99.setMaximumSize(new Dimension(125, 33));
    chkT99.setFont(new java.awt.Font("Dialog", 0, 16));
    chkT99.setBackground(new Color(202, 202, 224));
    btnQry.setBounds(new Rectangle(698, 82, 80, 26));
    btnQry.setFont(new java.awt.Font("Dialog", 1, 11));
    btnQry.setText("REPORT");
    btnQry.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnQry_actionPerformed(e);
      }
    });
    this.add(blueBkgWhiteCharLabel1, null);
    pnlDep.add(txtDep[0], null);
    pnlDep.add(txtDep[1], null);
    pnlDep.add(txtDep[2], null);
    pnlDep.add(txtDep[3], null);
    pnlDep.add(txtDep[4], null);
    this.add(pnlDep, null);
    this.add(whiteBkgBlueCharLabel2, null);
    this.add(whiteBkgBlueCharLabel1, null);
    this.add(cbxSrc, null);
    this.add(txtDateFrom, null);
    this.add(whiteBkgBlueCharLabel3, null);
    this.add(txtDateTo, null);
    this.add(chkT88, null);
    this.add(chkT99, null);
    this.add(btnQry, null);
    chkT88.setSelected(true);
    chkT99.setSelected(true);
    genDataBindObj();
  }
  exgui.DataBindTextWithChecker dbTxtPayDateTo,dbTxtPayDateFrom;
  public void  genDataBindObj(){
    try{
      dataBindComps.clear();
      Object vftxtChkDep=exgui.verification.CellFormat.getOrdinaryField(2);

      super.reportName="ACC_TEL.rpt";
         for(int i=0;i<5;i++){
            dbTxtDep[i]= new exgui.DataBindTextWithChecker(txtDep[i],
                                    "P_DEP",
                                    defaultDep[i], 10,
                                    (exgui.Object2String)vftxtChkDep,
                                    (exgui.ultratable.CellTxtEditorFormat)vftxtChkDep);

         }
       Vector  vctTelComSrc=exgui2.CONST.BASIC_MAIN_EJB.getDatas(
           util.PublicVariable.USER_RECORD,
           "select * from VH_DTL_TELECOM_SRC",1,99999);


      exgui.DataBindJCombobox telSrc=  new exgui.DataBindJCombobox(
                                    cbxSrc,"P_SOURCE",vctTelComSrc,
                                    "SRC_NAME","SRC_CODE",
                                    null,"ALL","ALL"
                                    );
          dataBindComps.add(telSrc);

          Object vftxtChkDD=exgui.verification.CellFormat.getDateStringFormater();

           int yearNow=util.MiscFunc.getYear(new java.sql.Date(System.currentTimeMillis()));
            dbTxtPayDateFrom= new exgui.DataBindTextWithChecker(txtDateFrom,
                                    "P_DATE_FM",
                                    null, 10,
                                    (exgui.Object2String)vftxtChkDD,
                                    (exgui.ultratable.CellTxtEditorFormat)vftxtChkDD);
            dataBindComps.add(dbTxtPayDateFrom);

             dbTxtPayDateTo= new exgui.DataBindTextWithChecker(txtDateTo,
                                     "P_DATE_TO",
                                     null, 10,
                                     (exgui.Object2String)vftxtChkDD,
                                     (exgui.ultratable.CellTxtEditorFormat)vftxtChkDD);
             dataBindComps.add(dbTxtPayDateTo);
             txtDateFrom.setText(String.valueOf(yearNow)+"/01/01");
             txtDateTo.setText(String.valueOf(yearNow)+"/12/31");

    }catch(Exception exp){
      exp.printStackTrace();
      util.ExceptionLog.exp2File(exp,"");
    }
  }
  public HashMap composeParameters(){
    HashMap hm=super.composeParameters();
    hm.put("P_T88",chkT88.isSelected()?"Y":"N");
    hm.put("P_T99",chkT99.isSelected()?"Y":"N");
    StringBuffer sb=new StringBuffer();
    for(int i=0;i<5;i++){
      String dep=(String)dbTxtDep[i].getSelectedValue();
      if(dep!=null && (!"ALL".equals(dep))){
        if(sb.length()>0)sb.append(",");
        sb.append("'");
        sb.append(dep);
        sb.append("'");
      }
    }
    if(sb.length()==0){
      hm.put("P_DEP", "['ALL']");
    }else{
      hm.put("P_DEP","["+sb.toString()+"]");
    }
    return hm;
  }
  void btnQry_actionPerformed(ActionEvent e) {
    //test if date out of range
    java.util.Date dateFrom=(java.util.Date)dbTxtPayDateFrom.getSelectedValue();
    java.util.Date dateTo=(java.util.Date)dbTxtPayDateTo.getSelectedValue();
    if(dateFrom==null){
      exgui.verification.VerifyLib.showAlert("Please Input Begin Date","Please Input Begin Date");
      return;
    }

    if(dateTo==null){
      exgui.verification.VerifyLib.showAlert("Please Input End Date","Please Input End Date");
      return;
    }
    String yearFrom=txtDateFrom.getText().substring(0,4);
    String yearTo=txtDateTo.getText().substring(0,4);
    if(!yearFrom.equalsIgnoreCase(yearTo)){
      //test over than 12 monthes
      if (dateFrom.after(dateTo)) {
        java.util.Date dateTemp = dateTo;
        dateTo = dateFrom;
        dateFrom = dateTemp;
      }
      java.util.Calendar cldEnd = java.util.GregorianCalendar.getInstance();
      cldEnd.setTime(dateFrom);
      cldEnd.add(cldEnd.MONTH, 12);
      if (dateTo.after(cldEnd.getTime())) {
        exgui.verification.VerifyLib.showAlert(
            "Date Range Can Not Over Than 12 Monthes", "Date Range Too Large");
        return;
      }
    }

    String tmpUrl=newtimes.production.report.ReportCmdSet.myReportEngin.reportServerURL;
    newtimes.production.report.ReportCmdSet.myReportEngin.reportServerURL=
    "http://rpt2.nttpe.com.tw:9000/?file:///cc53//rpt//";
    super.JButtonQueryButtonAction(null);
     newtimes.production.report.ReportCmdSet.myReportEngin.reportServerURL=tmpUrl;
  }
}
