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
import newtimes.preproduction.buyermakerselect.*;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class Pnlchkcoo
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
  int indexOfDivision;

  public Pnlchkcoo() {
    try {
      //jbInit();
    }catch(Exception ex) {
      ex.printStackTrace();
    }
  }

  void jbInit() throws Exception {
    System.out.println(this.getBounds());
    blueBkgWhiteCharLabel1.setText("Check Order Coo");
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
    jLabel5.setBounds(new Rectangle(460, 41, 67, 22));
    jLabel5.setText("DEL DD:");
    jLabel5.setFont(new java.awt.Font("Dialog", 1, 11));
    txtDelFrom.setToolTipText("YYYY");
    txtDelFrom.setText(String.valueOf(year));
    txtDelFrom.setBounds(new Rectangle(513, 41, 76, 22));
    slkBuyer.setBounds(new Rectangle(53, 38, 125, 21));
    slkBuyer0.setBounds(new Rectangle(180, 38, 125, 21));
    slkBuyer1.setBounds(new Rectangle(310, 38, 125, 21));
    slkMaker.setBounds(new Rectangle(53, 58, 125, 21));

    jLabel8.setBounds(new Rectangle(6, 37, 73, 22));
    jLabel9.setBounds(new Rectangle(6, 57, 73, 22));
    jLabel8.setText("BUYER :");
    jLabel9.setText("MAKER :");
    jLabel8.setFont(new java.awt.Font("Dialog", 1, 11));
    jLabel9.setFont(new java.awt.Font("Dialog", 1, 11));
    this.add(blueBkgWhiteCharLabel1, null);
    this.add(txtDelFrom, null);
//    this.add(jLabel8, null);
//    this.add(slkBuyer, null);
//    this.add(slkBuyer0, null);
//    this.add(slkBuyer1, null);
//    this.add(jLabel9, null);
//    this.add(slkMaker, null);
    this.add(jLabel5, null);
    this.add(jLabel4, null);
    this.add(txtDelTo, null);
    this.add(btnPrint, null);

    genDataBindObj();
  }

  protected  void genDataBindObj(){
  try{
    slkBuyer.init("P_BUYER",new Integer(2078),slkBuyer.TYPE_BUYER,true);
    slkBuyer0.init("P_BUYER",new Integer(0),slkBuyer.TYPE_BUYER,true);
    slkBuyer1.init("P_BUYER",new Integer(0),slkBuyer.TYPE_BUYER,true);
    slkMaker.init("P_MAKER",new Integer(0),slkBuyer.TYPE_MAKER,true);
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

     super.reportName="Coo_check.rpt";
   }catch(Exception exp){
      exp.printStackTrace();
   }
  }

  protected java.util.HashMap composeParameters(){
   //java.util.HashMap hm=super.composeParameters();//new java.util.HashMap();
   java.util.HashMap hm=new java.util.HashMap();
   //hm.put("BUYER","82");
   String byr_seq_str="";
   if (slkBuyer.getSelectedValue()!=null) {
       byr_seq_str=byr_seq_str+","+slkBuyer.getSelectedValue().toString();
   }
   if (slkBuyer0.getSelectedValue()!=null) {
      byr_seq_str=byr_seq_str+","+slkBuyer0.getSelectedValue().toString();
   }
   if (slkBuyer1.getSelectedValue()!=null) {
    byr_seq_str=byr_seq_str+","+slkBuyer1.getSelectedValue().toString();
   }

   if (byr_seq_str.equals("")) {
       byr_seq_str=byr_seq_str+"[0]";
   } else {
       byr_seq_str="["+byr_seq_str.replaceFirst(",","")+"]";
   }
 //  System.out.println(byr_seq_str);
 //  hm.put(slkBuyer.getOrgRecField(),(slkBuyer.getSelectedValue()==null)?"[0]":slkBuyer.getSelectedValue().toString());
 //  hm.put("P_BUYER",byr_seq_str);
 //  hm.put(slkMaker.getOrgRecField(),(slkMaker.getSelectedValue()==null)?"0":slkMaker.getSelectedValue().toString());
   hm.put("P_DEL_FM",super.convert2QueryPara(dbDelDateFrom.getSelectedValue()==null?util.MiscFunc.toDate(2000,01,01):dbDelDateFrom.getSelectedValue()));
   hm.put("P_DEL_TO",super.convert2QueryPara(dbDelDateTo.getSelectedValue()==null?util.MiscFunc.toDate(2099,01,01):dbDelDateTo.getSelectedValue()));
   return hm;
  }
  void btnPrint_actionPerformed(ActionEvent e) {
    String tempURL= newtimes.production.report.ReportProxyEngine.reportServerURL ;
    newtimes.production.report.ReportProxyEngine.reportServerURL="http://rpt2.nttpe.com.tw:9000/?file:///rpt//";
    super.JButtonQueryButtonAction(null);
    newtimes.production.report.ReportProxyEngine.reportServerURL =tempURL;
  }

  SelectBuyerMaker slkBuyer = new SelectBuyerMaker();
  SelectBuyerMaker slkBuyer0 = new SelectBuyerMaker();
  SelectBuyerMaker slkBuyer1 = new SelectBuyerMaker();
  SelectBuyerMaker slkMaker = new SelectBuyerMaker();
  JLabel jLabel8 = new JLabel();
  JLabel jLabel9 = new JLabel();
}
