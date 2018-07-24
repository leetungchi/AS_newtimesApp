package newtimes.accounting.debit_note;

import java.awt.*;
import exgui.*;
import javax.swing.*;
import newtimes.production.report.AbsQryPanel;
//import newtimes.production.report.QryPanel;
import java.util.*;
import exgui.verification.CellFormat;
import database.datatype.Record;
import exgui.ultratable.CellTxtEditorFormat;
import java.awt.event.*;
import newtimes.preproduction.buyermakerselect.*;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class PnlRptBuyerCommList
    extends AbsQryPanel{
    //extends JPanel {
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel1 = new BlueBkgWhiteCharLabel();
  JButton btnPrint = new JButton();
  int year=java.util.Calendar.getInstance().get(java.util.Calendar.getInstance().YEAR);
  ButtonGroup buttonGroup1 = new ButtonGroup();
  exgui.DataBindJCombobox dbCbxSzn;
  JLabel jLabel4 = new JLabel();
  JTextField txtDelTo = new JTextField();
  JLabel jLabel5 = new JLabel();
  JTextField txtDelFrom = new JTextField();
  DataBindTextWithChecker dbDelDateFrom,dbDelDateTo;
  HashMap bhm = new HashMap() ;
  HashMap dest_hm = new HashMap() ;
  int indexOfDivision;

  public PnlRptBuyerCommList() {
    try {
      //jbInit();
    }catch(Exception ex) {
      ex.printStackTrace();
    }
  }

  void jbInit() throws Exception {
    blueBkgWhiteCharLabel1.setText("DEBIT NOTE BUYER COMM LIST");
    blueBkgWhiteCharLabel1.setBounds(new Rectangle(-2, 3, 803, 34));
    this.setBackground(new Color(202, 202, 224));
    this.setLayout(null);
    btnPrint.setBounds(new Rectangle(700, 40, 93, 27));
    btnPrint.setFont(new java.awt.Font("Dialog", 1, 11));
    btnPrint.setText("REPORT");
    btnPrint.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnPrint_actionPerformed(e);
      }
    });
    jLabel4.setBounds(new Rectangle(586, 41, 26, 22));
    jLabel4.setText("~");
    jLabel4.setHorizontalAlignment(SwingConstants.CENTER);
    jLabel4.setFont(new java.awt.Font("Dialog", 1, 11));
    txtDelTo.setToolTipText("YYYY");
    txtDelTo.setText(String.valueOf(year));
    txtDelTo.setBounds(new Rectangle(612, 41, 79, 22));
    jLabel5.setBounds(new Rectangle(405, 42, 110, 22));
    jLabel5.setText("DEBIT NOTE DATE :");
    jLabel5.setFont(new java.awt.Font("Dialog", 1, 11));
    txtDelFrom.setToolTipText("YYYY");
    txtDelFrom.setText(String.valueOf(year));
    txtDelFrom.setBounds(new Rectangle(513, 41, 76, 22));
    slkBuyer.setBounds(new Rectangle(2, 71, 250, 21));
    jLabel8.setBounds(new Rectangle(6, 40, 73, 22));
    jLabel8.setText("BUYER :");
    jLabel8.setFont(new java.awt.Font("Dialog", 1, 11));
    ComboBuyer.setBounds(new Rectangle(52, 40, 181, 26));
    bhm.put("Quiksilver","[12141,12284,12285,12286,12287,12288,12289,12294]");
    bhm.put("Jones","[11369]");
    ComboBuyer.addItem("Quiksilver");
    ComboBuyer.addItem("Jones");
    dest_hm.put("U.S.A./CANADA","['U.S.A.','CANADA']");
    dest_hm.put("AUSTRALIA","['AUSTRALIA']");
    dest_hm.put("EUROPE","['EUROPE']");
    dest_hm.put("HONG KONG","['HONG KONG']");
    dest_hm.put("JAPAN","['JAPAN']");
    dest_hm.put("KOREA","['KOREA']");
    dest_hm.put("MEXICO","['MEXICO']");
    dest_hm.put("INDONESIA","['INDONESIA']");
    dest_combo.addItem("U.S.A./CANADA");
    dest_combo.addItem("AUSTRALIA");
    dest_combo.addItem("EUROPE");
    dest_combo.addItem("HONG KONG");
    dest_combo.addItem("JAPAN");
    dest_combo.addItem("KOREA");
    dest_combo.addItem("MEXICO");
    dest_combo.addItem("INDONESIA");
    dest_combo.setBounds(new Rectangle(514, 71, 180, 23));
    jLabel1.setFont(new java.awt.Font("Dialog", 1, 11));
    jLabel1.setText("Destination for QS :");
    jLabel1.setVerticalAlignment(javax.swing.SwingConstants.CENTER);
    jLabel1.setVerticalTextPosition(javax.swing.SwingConstants.CENTER);
    jLabel1.setBounds(new Rectangle(398, 71, 114, 23));
    this.add(blueBkgWhiteCharLabel1, null);
    this.add(txtDelFrom, null);
    this.add(jLabel8, null);
    this.add(jLabel4, null);
    this.add(txtDelTo, null);
    this.add(btnPrint, null);
    this.add(jLabel5, null);
    this.add(ComboBuyer, null);
    this.add(slkBuyer, null);
    this.add(dest_combo, null);
    this.add(jLabel1, null);
    slkBuyer.setVisible(false);
    genDataBindObj();
  }

  protected  void genDataBindObj(){
  try{
    slkBuyer.init("P_BUYER",new Integer(2078),slkBuyer.TYPE_BUYER,true);
    dataBindComps.clear();
    /*
    Vector division=
     exgui2.CONST.BASIC_MAIN_EJB.getDatas(
        util.PublicVariable.USER_RECORD,
        "select DIV_CODE,DIV_NAME from DIVISION where DIV_BYMKR_SEQ=82 and record_delete_flag='1' ",
        1,9999);

    exgui.DataBindJCombobox dbDivCbx= new exgui.DataBindJCombobox(
        cbxDiv,"P_DIV",
        division,"DIV_NAME","DIV_CODE",null,"ALL","ALL");
    dataBindComps.add(dbDivCbx);*/
     dataBindComps.add(null);
     indexOfDivision=dataBindComps.size()-1;


    Object chkDelDate = CellFormat.getDateStringFormaterAllowNull();
     dbDelDateFrom = new DataBindTextWithChecker(txtDelFrom, "",
        null, 10,
        (Object2String)chkDelDate,
        (CellTxtEditorFormat)chkDelDate);

     dbDelDateTo = new DataBindTextWithChecker(txtDelTo, "",
        null, 10,
        (Object2String)chkDelDate,
        (CellTxtEditorFormat)chkDelDate);

     super.reportName="ACC_DB_BUY_COMM.rpt";
   }catch(Exception exp){
      exp.printStackTrace();
   }
  }

  protected java.util.HashMap composeParameters(){
   //java.util.HashMap hm=super.composeParameters();//new java.util.HashMap();
   java.util.HashMap hm=new java.util.HashMap();
   //hm.put("BUYER","82");
 //  hm.put(slkBuyer.getOrgRecField(),(slkBuyer.getSelectedValue()==null)?"0":slkBuyer.getSelectedValue().toString());
   hm.put(slkBuyer.getOrgRecField(),bhm.get(ComboBuyer.getSelectedItem()));
   hm.put("P_DATE_FM",super.convert2QueryPara(dbDelDateFrom.getSelectedValue()==null?util.MiscFunc.toDate(2000,01,01):dbDelDateFrom.getSelectedValue()));
   hm.put("P_DATE_TO",super.convert2QueryPara(dbDelDateTo.getSelectedValue()==null?util.MiscFunc.toDate(2099,01,01):dbDelDateTo.getSelectedValue()));
   hm.put("P_DEST",dest_hm.get(dest_combo.getSelectedItem()));
   return hm;
  }
  void btnPrint_actionPerformed(ActionEvent e) {
    String tempURL= newtimes.production.report.ReportProxyEngine.reportServerURL ;
    newtimes.production.report.ReportProxyEngine.reportServerURL="http://rpt2.nttpe.com.tw:9000/?file:///rpt//";
    super.JButtonQueryButtonAction(null);
    newtimes.production.report.ReportProxyEngine.reportServerURL =tempURL;
  }
  SelectBuyerMaker slkBuyer = new SelectBuyerMaker();
  JLabel jLabel8 = new JLabel();
  JComboBox ComboBuyer = new JComboBox();
  JComboBox dest_combo = new JComboBox();
  JLabel jLabel1 = new JLabel();
}
