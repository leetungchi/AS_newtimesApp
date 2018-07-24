package newtimes.production.report;
import java.awt.*;
import exgui.*;
import javax.swing.*;
import javax.swing.border.*;
import newtimes.preproduction.buyermakerselect.*;
import java.awt.event.*;
import exgui.*;
import java.util.*;
/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class PnlRptCustPoList
    extends AbsQryPanel{
    //extends JPanel {
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel1 = new BlueBkgWhiteCharLabel();
  TitledBorder titledBorder1;
  //JComboBox cbxDep1 = new JComboBox();
  //JComboBox cbxDep2 = new JComboBox();
  //JComboBox cbxDep3 = new JComboBox();
  //JComboBox cbxDep4 = new JComboBox();
  //JComboBox cbxDep5 = new JComboBox();
  String centerCode;
  JLabel jLabel1 = new JLabel();
  SelectBuyerMaker slkBuyer = new SelectBuyerMaker();
  JLabel jLabel2 = new JLabel();
  SelectBuyerMaker slkMaker = new SelectBuyerMaker();
  JLabel jLabel4 = new JLabel();
  JTextField txtDelFrom = new JTextField();
  JLabel jLabel5 = new JLabel();
  JTextField txtDelTo = new JTextField();
  JButton btnQry = new JButton();
  protected   DataBindTextWithChecker dbTxtDateBgn,dbTxtDateEnd;
  protected  int itemCount=6;
  JLabel jLabel3 = new JLabel();
  JComboBox cbxPort = new JComboBox();
  JComboBox cbxDest = new JComboBox();
  JLabel jLabel6 = new JLabel();
  JLabel jLabel7 = new JLabel();
  JTextField txtPo = new JTextField();

  public PnlRptCustPoList() {
    try {
      //jbInit();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }
  protected void jbInit() throws Exception {
    setBackground(new Color(204, 204, 225));
    centerCode=(String)util.PublicVariable.USER_RECORD.get("USR_CEN_CODE");

    titledBorder1 = new TitledBorder(new EtchedBorder(EtchedBorder.RAISED,Color.white,new Color(148, 145, 140)),"DEPARTMENTS");
    blueBkgWhiteCharLabel1.setBounds(new Rectangle(0, 6, 799, 23));
    blueBkgWhiteCharLabel1.setText("CUST. P.O. LIST");
    this.setLayout(null);
    jLabel1.setText("BUYER:");
    jLabel1.setBounds(new Rectangle(5, 41, 64, 25));
    slkBuyer.setBounds(new Rectangle(55, 41, 183, 23));
    jLabel2.setBounds(new Rectangle(252, 41, 64, 25));
    jLabel2.setText("MAKER:");
    jLabel2.setVerticalAlignment(javax.swing.SwingConstants.CENTER);
    slkMaker.setBounds(new Rectangle(304, 41, 183, 23));
    jLabel4.setText("FROM:");
    jLabel4.setBounds(new Rectangle(512, 69, 45, 22));
    txtDelFrom.setBounds(new Rectangle(550, 69, 71, 21));
    jLabel5.setText("TO:");
    jLabel5.setBounds(new Rectangle(624, 66, 31, 24));
    txtDelTo.setText("");
    txtDelTo.setBounds(new Rectangle(648, 67, 71, 24));
    btnQry.setBounds(new Rectangle(726, 63, 70, 28));
    btnQry.setFont(new java.awt.Font("Dialog", 1, 11));
    btnQry.setText("REPORT");
    btnQry.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnQry_actionPerformed(e);
      }
    });
    jLabel3.setText("PORT:");
    jLabel3.setBounds(new Rectangle(4, 70, 43, 23));
    cbxPort.setBounds(new Rectangle(41, 69, 200, 24));
    cbxDest.setBounds(new Rectangle(306, 69, 200, 24));
    jLabel6.setBounds(new Rectangle(269, 69, 43, 23));
    jLabel6.setText("DEST:");
    jLabel7.setText("PO :");
    jLabel7.setBounds(new Rectangle(509, 42, 43, 23));
    txtPo.setText("");
    txtPo.setBounds(new Rectangle(536, 41, 183, 23));
    this.add(blueBkgWhiteCharLabel1, null);
    this.add(jLabel1, null);
    this.add(slkBuyer, null);
    this.add(jLabel2, null);
    this.add(slkMaker, null);
    this.add(cbxPort, null);
    this.add(jLabel3, null);
    this.add(cbxDest, null);
    this.add(jLabel6, null);
    this.add(txtDelTo, null);
    this.add(btnQry, null);
    this.add(jLabel7, null);
    this.add(txtPo, null);
    this.add(jLabel5, null);
    this.add(jLabel4, null);
    this.add(txtDelFrom, null);
    genDataBindObj();
  }
  protected void genDataBindObj(){
    try{
       dataBindComps.clear();
       Object dateVfy = exgui.verification.CellFormat.getDateStringFormaterAllowNull();
       dbTxtDateBgn =
           new exgui.DataBindTextWithChecker(txtDelFrom, "P_DEL_FM", null,
                                             10, (exgui.Object2String)dateVfy,
                                             (exgui.ultratable.
                                              CellTxtEditorFormat)dateVfy);
       dataBindComps.add(dbTxtDateBgn);
       dbTxtDateEnd =
           new exgui.DataBindTextWithChecker(txtDelTo, "P_DEL_TO", null,
                                             10, (exgui.Object2String)dateVfy,
                                             (exgui.ultratable.
                                              CellTxtEditorFormat)dateVfy);
       dataBindComps.add(dbTxtDateEnd);
       slkBuyer.init("P_BUYER",null,slkBuyer.TYPE_BUYER,true);
       slkMaker.init("P_MAKER",null,slkBuyer.TYPE_MAKER,true);
      Vector vctDest=exgui2.CONST.BASIC_MAIN_EJB.getDatas(
        util.PublicVariable.USER_RECORD,
        "select dest_name from destination where record_delete_flag='1' order by dest_name"
        ,1,99999
      );


     exgui.DataBindJCombobox dbCbxDest= new exgui.DataBindJCombobox(
       cbxDest, "P_DEST",
       vctDest,
       "DEST_NAME", "DEST_NAME",
       null," ", null);
      dataBindComps.add(dbCbxDest);

      exgui.DataBindJCombobox dbCbxPort= new exgui.DataBindJCombobox(
        cbxPort, "P_PORT",
        vctDest,
        "DEST_NAME", "DEST_NAME",
        null," ", null);
       dataBindComps.add(dbCbxPort);

       super.reportName="QUY_PO.rpt";

    }catch(Exception exp){
       exp.printStackTrace();
    }
  }
  protected HashMap composeParameters(){
    HashMap hm=super.composeParameters();
    StringBuffer sbDEP=new StringBuffer();
    if(slkBuyer.getSelectedValue()==null){
      hm.put("P_BUYER","0");
    }else{
      hm.put("P_BUYER",String.valueOf(slkBuyer.getSelectedValue().toString()));
    }
    if(slkMaker.getSelectedValue()==null){
      hm.put("P_Maker","0");
    }else{
      hm.put("P_Maker",String.valueOf(slkMaker.getSelectedValue().toString()));
    }

    Object dateBgn=dbTxtDateBgn.getSelectedValue();
    Object dateEnd=dbTxtDateEnd.getSelectedValue();
    int xntYear=util.MiscFunc.getYear(new java.sql.Date(System.currentTimeMillis()));
    if(dateBgn==null){
      hm.put("P_DEL_FM","DATE("+String.valueOf(xntYear)+",01,01)");
    }
    if(dateEnd==null){
      hm.put("P_DEL_TO","DATE("+String.valueOf(xntYear)+",12,31)");
    }
    hm.put("P_CENTER",centerCode);
    if(txtPo.getText().trim().length()>0){
      hm.put("P_PO",txtPo.getText());
    }

   return hm;
  }
  void btnQry_actionPerformed(ActionEvent e) {
    String tempURL=newtimes.production.report.ReportProxyEngine.reportServerURL;
    newtimes.production.report.ReportProxyEngine.reportServerURL="http://rpt2.nttpe.com.tw:9000/?file:///rpt//";
    super.JButtonQueryButtonAction(null);
    newtimes.production.report.ReportProxyEngine.reportServerURL =tempURL;
  }
}
