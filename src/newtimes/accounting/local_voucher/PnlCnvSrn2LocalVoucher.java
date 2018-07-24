package newtimes.accounting.local_voucher;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import exgui.*;
import javax.swing.border.*;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class PnlCnvSrn2LocalVoucher extends JPanel {
  JButton btnExit = new JButton();
  JButton btnExport = new JButton();
  JButton btnExportSingle = new JButton();
  JTextField txtEtdFrom = new JTextField();
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel1 = new BlueBkgWhiteCharLabel();
  JComboBox cbxDep = new JComboBox();
  JTextField txtEtdTo = new JTextField();
  WhiteBkgBlueCharLabel whiteBkgBlueCharLabel3 = new WhiteBkgBlueCharLabel();
  JPanel jPanel1 = new JPanel();
  WhiteBkgBlueCharLabel whiteBkgBlueCharLabel2 = new WhiteBkgBlueCharLabel();
  JTextField txtSRN = new JTextField();
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel2 = new BlueBkgWhiteCharLabel();
  WhiteBkgBlueCharLabel whiteBkgBlueCharLabel1 = new WhiteBkgBlueCharLabel();
  Border border1;
  TitledBorder titledBorder1;
  exgui.DataBindTextWithChecker dbTxtFrom,dbTxtTo;
  exgui.DataBindJCombobox dbCbxDep;
  java.text.DateFormat df=null;

  public PnlCnvSrn2LocalVoucher() {
    try {
      jbInit();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }

  void jbInit() throws Exception {
    border1 = new EtchedBorder(EtchedBorder.RAISED,Color.white,new Color(141, 141, 156));
    titledBorder1 = new TitledBorder(border1,"SINGLE SRN EXPORT");
    jPanel1.setLayout(null);
    jPanel1.setBounds(new Rectangle(24, 151, 734, 98));
    jPanel1.setAlignmentY((float) 0.5);
    jPanel1.setBorder(titledBorder1);
    jPanel1.setBackground(new Color(202, 202, 224));
    whiteBkgBlueCharLabel3.setText("TO");
    whiteBkgBlueCharLabel3.setBounds(new Rectangle(432, 87, 38, 23));
    txtEtdTo.setText("");
    txtEtdTo.setBounds(new Rectangle(469, 87, 73, 23));
    cbxDep.setBounds(new Rectangle(103, 88, 150, 24));
    blueBkgWhiteCharLabel1.setBounds(new Rectangle(0, 13, 804, 38));
    blueBkgWhiteCharLabel1.setText("EXPORT MAKER DISCOUNT TO LOCAL VOUCHER");
    txtEtdFrom.setBounds(new Rectangle(359, 87, 74, 23));
    txtEtdFrom.setText("");
    btnExportSingle.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnExportSingle_actionPerformed(e);
      }
    });
    btnExportSingle.setText("SINGLE SRN EXPORT");
    btnExportSingle.setFont(new java.awt.Font("Dialog", 1, 11));
    btnExportSingle.setBounds(new Rectangle(298, 35, 178, 26));
    btnExport.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnExport_actionPerformed(e);
      }
    });
    btnExport.setText("EXPORT");
    btnExport.setFont(new java.awt.Font("Dialog", 1, 11));
    btnExport.setBounds(new Rectangle(555, 87, 124, 26));
    btnExit.setFont(new java.awt.Font("Dialog", 1, 11));
    btnExit.setBounds(new Rectangle(558, 411, 124, 26));
    btnExit.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnExit_actionPerformed(e);
      }
    });
    btnExit.setText("EXIT");
    this.setBackground(new Color(202, 202, 224));
    this.setLayout(null);
    whiteBkgBlueCharLabel2.setText("ETD FROM:");
    whiteBkgBlueCharLabel2.setBounds(new Rectangle(265, 87, 89, 23));
    txtSRN.setText("");
    txtSRN.setBounds(new Rectangle(145, 35, 135, 26));
    blueBkgWhiteCharLabel2.setText("SRN:");
    blueBkgWhiteCharLabel2.setBounds(new Rectangle(10, 35, 135, 26));
    whiteBkgBlueCharLabel1.setText("DEP.");
    whiteBkgBlueCharLabel1.setBounds(new Rectangle(17, 88, 85, 23));
    jPanel1.add(blueBkgWhiteCharLabel2, null);
    jPanel1.add(txtSRN, null);
    jPanel1.add(btnExportSingle, null);
    this.add(whiteBkgBlueCharLabel2, null);
    this.add(whiteBkgBlueCharLabel1, null);
    this.add(btnExit, null);
    this.add(btnExport, null);
    this.add(txtEtdFrom, null);
    this.add(blueBkgWhiteCharLabel1, null);
    this.add(cbxDep, null);
    this.add(txtEtdTo, null);
    this.add(whiteBkgBlueCharLabel3, null);
    this.add(jPanel1, null);
    int ship_no_length=12;
    if(!("001".equals(util.PublicVariable.OPERATTING_CENTER)||"NTHK".equals(util.PublicVariable.OPERATTING_CENTER))){
      ship_no_length=13;
    }
    dbCbxDep=
       new exgui.DataBindJCombobox(
            cbxDep,"",newtimes.preproduction.guis.tempProperties.tmpDepartment,
            "DEP_NAME","DEP_PREFIX",null,"ALL",null);
         Object vftxtDate = exgui.verification.CellFormat.getDateStringFormaterAllowNull();
         java.util.Calendar cldr=java.util.Calendar.getInstance();
        cldr.set(cldr.MONTH, cldr.get(cldr.MONTH)-2);
       dbTxtFrom=new exgui.DataBindTextWithChecker(txtEtdFrom, "",
                                           cldr.getTime(), 10,
                                           (exgui.Object2String)vftxtDate,
                                           (exgui.ultratable.CellTxtEditorFormat)
                                           vftxtDate);


     cldr.set(cldr.MONTH, cldr.get(cldr.MONTH)+3);
     dbTxtTo=new exgui.DataBindTextWithChecker(txtEtdTo, "",
                                         new java.sql.Date(cldr.getTimeInMillis()), 10,
                                         (exgui.Object2String)vftxtDate,
                                         (exgui.ultratable.CellTxtEditorFormat)
                                         vftxtDate);
     if(util.PublicVariable.USER_RECORD.getInt(2)!=
        newtimesejb.preproduction.PreProductionHead.USER_TYPE_SUPERVIOSER_MIS){
       txtEtdFrom.setEditable(false);
       txtEtdTo.setEditable(false);
     }
  }

  void btnExit_actionPerformed(ActionEvent e) {
    try{
      processhandler.template.Properties.getCenteralControler().goBack();
    }catch(Exception exp){
      exp.printStackTrace();
    }
  }
  void btnExport_actionPerformed(ActionEvent e) {
    util.MiscFunc.showProcessingMessage();
    StringBuffer sb=new StringBuffer();
    sb.append("select ");
    sb.append("aa.ship_no,");
    sb.append("(select bymkr_warehouse from buyer_maker where bymkr_seq=");
    sb.append("(select prod_maker from prod_head where prod_head_pk=");
    sb.append("(select a.prod_head_pk from ship_sc a where a.ship_no=aa.ship_no");
    sb.append(" and a.record_delete_flag='1' and rownum=1)))");
    sb.append(" as buyer_wharehouse,");
    sb.append("0 as dbnt_dtl_amt ");
    sb.append("from shipping  aa where aa.record_delete_flag='1' ");
    if(util.PublicVariable.OPERATTING_CENTER.equals("001")){
       sb.append(" and aa.ship_no like 'ZATW");
    }else if(util.PublicVariable.OPERATTING_CENTER.equals("NTHK")){
       sb.append(" and aa.ship_no like 'ZNNT");
    }else {
      sb.append(" and aa.ship_no like 'Z__");
      sb.append(newtimes.accounting.debit_note.Constans.getCenterPrefix(util.PublicVariable.OPERATTING_CENTER));
    }

    if(dbCbxDep.getSelectedValue()!=null) sb.append((String)dbCbxDep.getSelectedValue());
    sb.append("%' ");
    sb.append("and  aa.ship_status='Y' ");
    sb.append("and  aa.ship_etd_date >= to_date('");sb.append(txtEtdFrom.getText());sb.append("','yyyy/mm/dd') ");
    sb.append("and  aa.ship_etd_date <= to_date('");sb.append(txtEtdTo.getText());  sb.append("','yyyy/mm/dd') ");
    sb.append("and  aa.ship_no not in ( select ship_no from LOCAL_VOUCHER ) ");
    sb.append("and ((select bymkr_warehouse from buyer_maker where bymkr_seq=");
    sb.append("(select prod_maker from prod_head where prod_head_pk=");
    sb.append("(select a.prod_head_pk from ship_sc a where a.ship_no=aa.ship_no ");
    sb.append("and a.record_delete_flag='1' and rownum=1)))");
    sb.append("like '%Z%')");
    try{
      java.util.Vector vct=exgui2.CONST.BASIC_MAIN_EJB.getDatas(
      util.PublicVariable.USER_RECORD,
      sb.toString(),1,9999);
      if(vct.size()==0){
        exgui.verification.VerifyLib.showAlert("No Invoice Data Converted","No Data To Convert");
        return;
      }
      java.util.ArrayList srnList=new java.util.ArrayList();
      for(int i=0;i<vct.size();i++){
        database.datatype.Record rec=(database.datatype.Record)vct.get(i);
        srnList.add((String)rec.get(0));
      }
      srnList.add(util.PublicVariable.OPERATTING_CENTER);//tail element is center code;
      String srn[]=(String[])srnList.toArray(new String[0]);
       newtimesejb.debitNote.LocalVoucherFacadeHome ejbHome=
           (newtimesejb.debitNote.LocalVoucherFacadeHome)
           info_ejb.WeblogicServiceLocator.locateServiceHome(util.PublicVariable.SERVER_URL,
           "newtimesejb.debitNote.LocalVoucherFacade");
       newtimesejb.debitNote.LocalVoucherFacade ejb=ejbHome.create();
       int cnvCount=ejb.con2LocalVoucher(srn,(String)util.PublicVariable.USER_RECORD.get(0),false);
         exgui.verification.VerifyLib.showPlanMsg("Records Count Converted To Local Voucher  is "+cnvCount,"Convert OK");
         return;
    }catch(Exception exp){
      exp.printStackTrace();
      exgui.verification.VerifyLib.showAlert("Convert Fail!!\nPlease Contact System Manager","Convert Fail!!");
    }finally{
      util.MiscFunc.hideProcessingMessage();
    }


  }
  void btnExportSingle_actionPerformed(ActionEvent e) {
    String inputsrn = txtSRN.getText().trim();
    if(inputsrn.length()<12){
      exgui.verification.VerifyLib.showAlert("SRN Too Short","SRN Too Short");
      return;
    }
    util.MiscFunc.showProcessingMessage();
    StringBuffer sb=new StringBuffer();
    sb.append("select ");
    sb.append("aa.ship_no,");
    sb.append("(select bymkr_warehouse from buyer_maker where bymkr_seq=");
    sb.append("(select prod_maker from prod_head where prod_head_pk=");
    sb.append("(select a.prod_head_pk from ship_sc a where a.ship_no=aa.ship_no");
    sb.append(" and a.record_delete_flag='1' and rownum=1)))");
    sb.append(" as buyer_wharehouse,");
    sb.append("0 as dbnt_dtl_amt ");
    sb.append("from shipping  aa ");
    sb.append("where aa.record_delete_flag='1' and aa.ship_no='");
    sb.append(inputsrn);
    sb.append("' ");
    sb.append("and  aa.ship_status='Y' ");
    sb.append("and ((select bymkr_warehouse from buyer_maker where bymkr_seq=");
    sb.append("(select prod_maker from prod_head where prod_head_pk=");
    sb.append("(select a.prod_head_pk from ship_sc a where a.ship_no=aa.ship_no ");
    sb.append("and a.record_delete_flag='1' and rownum=1)))");
    sb.append("like '%Z%')");
    try{
      //System.out.println(sb.toString());
      java.util.Vector vct=exgui2.CONST.BASIC_MAIN_EJB.getDatas(
      util.PublicVariable.USER_RECORD,
      sb.toString(),1,9999);
      if(vct.size()==0){
        exgui.verification.VerifyLib.showAlert("No Invoice Data Converted","No Data To Convert");
        return;
      }
      java.util.ArrayList srnList=new java.util.ArrayList();
      for(int i=0;i<vct.size();i++){
        database.datatype.Record rec=(database.datatype.Record)vct.get(i);
        srnList.add((String)rec.get(0));
      }
      srnList.add(util.PublicVariable.OPERATTING_CENTER);
      String srn[]=(String[])srnList.toArray(new String[0]);
       newtimesejb.debitNote.LocalVoucherFacadeHome ejbHome=
           (newtimesejb.debitNote.LocalVoucherFacadeHome)
           info_ejb.WeblogicServiceLocator.locateServiceHome(util.PublicVariable.SERVER_URL,
           "newtimesejb.debitNote.LocalVoucherFacade");
       newtimesejb.debitNote.LocalVoucherFacade ejb=ejbHome.create();
       int cnvCount=ejb.con2LocalVoucher(srn,(String)util.PublicVariable.USER_RECORD.get(0),true);
         exgui.verification.VerifyLib.showPlanMsg("Records Count Converted To Local Voucher  is "+cnvCount,"Convert OK");
         return;
    }catch(Exception exp){
      exp.printStackTrace();
      exgui.verification.VerifyLib.showAlert("Convert Fail!!\nPlease Contact System Manager","Convert Fail!!");
    }finally{
      util.MiscFunc.hideProcessingMessage();
    }

  }
}
