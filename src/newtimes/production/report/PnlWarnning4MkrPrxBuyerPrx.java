package newtimes.production.report;
import java.awt.*;
import exgui.*;
import javax.swing.*;
import newtimes.production.report.AbsQryPanel;
import java.util.*;
import exgui.verification.CellFormat;
import database.datatype.Record;
import exgui.ultratable.CellTxtEditorFormat;
import java.awt.event.*;
import javax.swing.border.*;
import newtimes.preproduction.guis.*;


/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class PnlWarnning4MkrPrxBuyerPrx extends
    AbsQryPanel {
    //JPanel{
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel1 = new BlueBkgWhiteCharLabel();
  WhiteBkgBlueCharLabel whiteBkgBlueCharLabel1 = new WhiteBkgBlueCharLabel();
  JComboBox cbxCntr = new JComboBox();
  WhiteBkgBlueCharLabel whiteBkgBlueCharLabel2 = new WhiteBkgBlueCharLabel();
  JTextField txtDelFrom = new JTextField();
  WhiteBkgBlueCharLabel whiteBkgBlueCharLabel3 = new WhiteBkgBlueCharLabel();
  JTextField txtDelTo = new JTextField();
  JButton btnPrint = new JButton();
  DataBindTextWithChecker yyyymmddDate,yyyymmddDate2;
  exgui.DataBindJCombobox DbJcbxcbxCntr;
  JPanel pnlPlaceView=null;
  JPanel jPanel1 = new JPanel();
  Border border1;
  TitledBorder titledBorder1;
  JTextField txtSC[] = new JTextField[6];
  /*
  JTextField txtSC[0] = new JTextField();
  JTextField txtSC[1] = new JTextField();
  JTextField txtSC[2] = new JTextField();
  JTextField txtSC[3] = new JTextField();
  JTextField txtSC[4] = new JTextField();
  JTextField txtSC[5] = new JTextField();
  */
  public PnlWarnning4MkrPrxBuyerPrx(JPanel p) {
    pnlPlaceView=p;
  }
  public void jbInit() throws Exception {
    for(int i=0;i<6;i++){
      txtSC[i] = new JTextField();
    }
    border1 = BorderFactory.createBevelBorder(BevelBorder.LOWERED,Color.white,Color.white,new Color(103, 101, 98),new Color(148, 145, 140));
    titledBorder1 = new TitledBorder(border1,"S/C NO (¦X¦P¸¹)");
    blueBkgWhiteCharLabel1.setText("WARNNING FOR MAKER PRICE QUAL OR OVER BUYER PRICE");
    blueBkgWhiteCharLabel1.setBounds(new Rectangle(0, 3, 802, 34));
    this.setLayout(null);
    whiteBkgBlueCharLabel1.setText("CENTER");
    whiteBkgBlueCharLabel1.setBounds(new Rectangle(7, 45, 97, 24));
    cbxCntr.setBounds(new Rectangle(106, 45, 161, 24));
    whiteBkgBlueCharLabel2.setText("DEL From:");
    whiteBkgBlueCharLabel2.setBounds(new Rectangle(6, 73, 91, 24));
    txtDelFrom.setText("");
    txtDelFrom.setBounds(new Rectangle(98, 73, 74, 24));
    whiteBkgBlueCharLabel3.setBounds(new Rectangle(171, 73, 28, 24));
    whiteBkgBlueCharLabel3.setText("TO");
    txtDelTo.setText("");
    txtDelTo.setBounds(new Rectangle(200, 74, 70, 24));
    btnPrint.setBounds(new Rectangle(690, 49, 80, 32));
    btnPrint.setFont(new java.awt.Font("Dialog", 1, 11));
    btnPrint.setText("Query");
    btnPrint.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnPrint_actionPerformed(e);
      }
    });
    jPanel1.setBorder(titledBorder1);
    jPanel1.setBounds(new Rectangle(271, 33, 412, 76));
    jPanel1.setLayout(null);
    txtSC[0].setText("");
    txtSC[0].setBounds(new Rectangle(5, 17, 127, 26));
    txtSC[1].setBounds(new Rectangle(143, 17, 127, 26));
    txtSC[1].setText("jTextField1");
    txtSC[1].setText("");
    txtSC[2].setBounds(new Rectangle(280, 17, 127, 26));
    txtSC[2].setText("jTextField1");
    txtSC[2].setText("");
    txtSC[3].setBounds(new Rectangle(5, 44, 127, 26));
    txtSC[3].setText("jTextField1");
    txtSC[3].setText("");
    txtSC[4].setBounds(new Rectangle(143, 44, 127, 26));
    txtSC[4].setText("");
    txtSC[5].setText("");
    txtSC[5].setText("");
    txtSC[5].setBounds(new Rectangle(280, 44, 127, 26));
    this.add(blueBkgWhiteCharLabel1, null);
    this.add(whiteBkgBlueCharLabel1, null);
    this.add(cbxCntr, null);
    this.add(whiteBkgBlueCharLabel2, null);
    this.add(txtDelFrom, null);
    this.add(jPanel1, null);
    this.add(whiteBkgBlueCharLabel3, null);
    this.add(txtDelTo, null);
    jPanel1.add(txtSC[0], null);
    jPanel1.add(txtSC[1], null);
    jPanel1.add(txtSC[2], null);
    jPanel1.add(txtSC[3], null);
    jPanel1.add(txtSC[4], null);
    jPanel1.add(txtSC[5], null);
    this.add(btnPrint, null);
    genDataBindObj();

 }
 public HashMap composeParameters() {
   HashMap hm=super.composeParameters();
   if(null==yyyymmddDate.getSelectedValue()){
     hm.put(yyyymmddDate.getOrgRecField(),super.convert2QueryPara(util.MiscFunc.toDate(2000,01,01)));
     //super.convert2QueryPara(dbDelDateFrom.getSelectedValue()==null?util.MiscFunc.toDate(2000,01,01)
   }
   if(null==yyyymmddDate2.getSelectedValue()){
     hm.put(yyyymmddDate2.getOrgRecField(),super.convert2QueryPara(util.MiscFunc.toDate(2099,12,31)));
   }


   StringBuffer sbSc=new StringBuffer();
   for(int i=0;i<6;i++){
     if(txtSC[i].getText().trim().length()>0){
       if(sbSc.length()>0)sbSc.append(",");
       sbSc.append("'");
       sbSc.append(txtSC[i].getText().trim());
       sbSc.append("'");
     }
   }
   if(sbSc.length()==0)sbSc.append("'ALL'");
   hm.put("P_SC_NO","["+sbSc.toString()+"]");
   return hm;
 }
 public void genDataBindObj() {
   try{
     dataBindComps.clear();

     if (tempProperties.tmpCenters.size() > 1) {
       DbJcbxcbxCntr =
           new exgui.DataBindJCombobox(
           cbxCntr, "P_CENTER",
           tempProperties.tmpCenters,
           "CEN_NAME", "CEN_CODE",
           (String)util.PublicVariable.USER_RECORD.get("usr_cen_code"));
       dataBindComps.add(DbJcbxcbxCntr);
     } else {
       DbJcbxcbxCntr =
           new exgui.DataBindJCombobox(
           cbxCntr, "P_CENTER",
           tempProperties.tmpCenters,
           "CEN_NAME", "CEN_CODE",
           (String)util.PublicVariable.USER_RECORD.get("usr_cen_code"));
       dataBindComps.add(DbJcbxcbxCntr);
     }


     Object chkYearMon=CellFormat.getDateStringFormaterAllowNull();
     java.util.Calendar cld=java.util.Calendar.getInstance();
     cld.set(cld.DATE,1);
     java.util.Date dFrom=cld.getTime();
     cld.set(cld.DATE,cld.getActualMaximum(cld.DAY_OF_MONTH));
     java.util.Date dEnd=cld.getTime();

     yyyymmddDate = new DataBindTextWithChecker(txtDelFrom, "P_CREATE_FM",
                                            dFrom, 10,
                                            (Object2String)chkYearMon,
                                            (CellTxtEditorFormat)chkYearMon);
    dataBindComps.add(yyyymmddDate);



     yyyymmddDate2 = new DataBindTextWithChecker(txtDelTo, "P_CREATE_TO",
                                         dEnd, 10,
                                        (Object2String)chkYearMon,
                                        (CellTxtEditorFormat)chkYearMon);

    dataBindComps.add(yyyymmddDate2);
   }catch(Exception exp){
     exp.printStackTrace();
   }

 }

  void btnPrint_actionPerformed(ActionEvent e) {
       reportName="BYR_MKR_COMP.rpt";
    String tempURL= newtimes.production.report.ReportProxyEngine.reportServerURL ;
    newtimes.production.report.ReportProxyEngine.reportServerURL="http://rpt2.nttpe.com.tw:9000/?file:///rpt//";
    super.JButtonQueryButtonAction(e);
    newtimes.production.report.ReportProxyEngine.reportServerURL =tempURL;
  }
  /*
  protected void generateReport(java.util.HashMap paraHm,String reportName)throws Exception{
   try{
    newtimes.production.ProdMaintain_Properties.setWaitCursor();
    com.inet.viewer.ReportViewerBean viewer= util.PublicVariable.inet_report_viewer;
    newtimes.production.report.ReportCmdSet.myReportEngin.setReportNameAndParas(viewer,reportName,paraHm);
    viewer.setHasGroupTree(false);
    viewer.start();
    pnlPlaceView.removeAll();
    pnlPlaceView.setLayout(new java.awt.BorderLayout());
    pnlPlaceView.add(viewer);
    pnlPlaceView.repaint();
    pnlPlaceView.validate();
  }finally{
     newtimes.production.ProdMaintain_Properties.setNormalCursor();
  }

 }*/


}
