package newtimes.tpe_user_report;

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

  public class PnlRptWss4KomarChdg
      extends AbsQryPanel{
       // extends JPanel {
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

    public PnlRptWss4KomarChdg() {
      try {
        //jbInit();
      }catch(Exception ex) {
        ex.printStackTrace();
      }
    }

    void jbInit() throws Exception {
      blueBkgWhiteCharLabel1.setText("WSS FOR KOMAR / CHDG");
      blueBkgWhiteCharLabel1.setBounds(new Rectangle(-2, 3, 803, 34));
      this.setBackground(new Color(202, 202, 224));
      this.setLayout(null);
      btnPrint.setBounds(new Rectangle(698, 70, 93, 27));
      btnPrint.setFont(new java.awt.Font("Dialog", 1, 11));
      btnPrint.setText("REPORT");
      btnPrint.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(ActionEvent e) {
          btnPrint_actionPerformed(e);
        }
      });
      jLabel4.setBounds(new Rectangle(552, 77, 26, 22));
      jLabel4.setText("~");
      jLabel4.setHorizontalAlignment(SwingConstants.CENTER);
      jLabel4.setFont(new java.awt.Font("Dialog", 1, 11));
      txtDelTo.setToolTipText("YYYY");
      txtDelTo.setText(String.valueOf(year));
      txtDelTo.setBounds(new Rectangle(578, 77, 79, 22));
      jLabel5.setBounds(new Rectangle(440, 77, 38, 22));
      jLabel5.setText("DEL:");
      jLabel5.setFont(new java.awt.Font("Dialog", 1, 11));
      txtDelFrom.setToolTipText("YYYY");
      txtDelFrom.setText(String.valueOf(year));
      txtDelFrom.setBounds(new Rectangle(479, 77, 76, 22));
      jLabel8.setBounds(new Rectangle(4, 40, 49, 22));
      jLabel8.setText("BUYER :");
      jLabel8.setFont(new java.awt.Font("Dialog", 1, 11));
      cbxBuyer.setBounds(new Rectangle(50, 40, 141, 23));
    cbxCountry.setBounds(new Rectangle(274, 40, 141, 23));
    jLabel9.setFont(new java.awt.Font("Dialog", 1, 11));
    jLabel9.setText("COUNTRY:");
    jLabel9.setBounds(new Rectangle(209, 40, 68, 22));
    jLabel10.setBounds(new Rectangle(425, 40, 68, 22));
    jLabel10.setText("FACTORY:");
    jLabel10.setFont(new java.awt.Font("Dialog", 1, 11));
    slkMaker.setBounds(new Rectangle(481, 40, 177, 23));
    jLabel6.setFont(new java.awt.Font("Dialog", 1, 11));
    jLabel6.setHorizontalAlignment(SwingConstants.CENTER);
    jLabel6.setText("~");
    jLabel6.setBounds(new Rectangle(312, 77, 26, 22));
    txtInputTo.setBounds(new Rectangle(338, 77, 79, 22));
    txtInputTo.setText(String.valueOf(year));
    txtInputTo.setToolTipText("YYYY");
    txtInputFrom.setBounds(new Rectangle(239, 77, 76, 22));
    txtInputFrom.setText(String.valueOf(year));
    txtInputFrom.setToolTipText("YYYY");
    jLabel7.setFont(new java.awt.Font("Dialog", 1, 11));
    jLabel7.setText("INPUT DATA RANGE:");
    jLabel7.setBounds(new Rectangle(123, 77, 115, 22));
    this.add(blueBkgWhiteCharLabel1, null);
      this.add(btnPrint, null);
      this.add(jLabel8, null);
    this.add(cbxBuyer, null);
    this.add(cbxCountry, null);
    this.add(jLabel9, null);
    this.add(jLabel10, null);
    this.add(slkMaker, null);
    this.add(txtDelFrom, null);
    this.add(jLabel4, null);
    this.add(txtDelTo, null);
    this.add(jLabel5, null);
    this.add(txtInputTo, null);
    this.add(jLabel7, null);
    this.add(txtInputFrom, null);
    this.add(jLabel6, null);

      genDataBindObj();
    }

    protected  void genDataBindObj(){
    try{
      slkMaker.init("P_FACTORY",null,slkMaker.TYPE_MAKER,true);
      dataBindComps.clear();

      exgui.DataBindJCombobox dbCbxCountry =
          new exgui.DataBindJCombobox(
          cbxCountry, "P_COUNTRY",
          newtimes.preproduction.guis.tempProperties.tmpCountries,
          "CNTY_NAME", "CNTY_NAME", "ALL", "ALL", null);
      dataBindComps.add(dbCbxCountry);



      Object chkDelDate = CellFormat.getDateStringFormaterAllowNull();
       dbDelDateFrom = new DataBindTextWithChecker(txtDelFrom, "",
          null, 10,
          (Object2String)chkDelDate,
          (CellTxtEditorFormat)chkDelDate);

       dbDelDateTo = new DataBindTextWithChecker(txtDelTo, "",
          null, 10,
          (Object2String)chkDelDate,
          (CellTxtEditorFormat)chkDelDate);

        java.util.Calendar cldToday=java.util.Calendar.getInstance();
        java.util.Calendar cldTodayTo=java.util.Calendar.getInstance();
        cldToday.add(cldToday.DAY_OF_MONTH,-7);
        java.sql.Date lastWeekday=new java.sql.Date(cldToday.getTimeInMillis());
       DataBindTextWithChecker dbInputDateFrom = new DataBindTextWithChecker(txtInputFrom, "P_NEW_FM",
          lastWeekday, 10,
          (Object2String)chkDelDate,
          (CellTxtEditorFormat)chkDelDate);
      dataBindComps.add(dbInputDateFrom);

      cldTodayTo.add(cldToday.DAY_OF_MONTH,-1);
      java.sql.Date yestoday=new java.sql.Date(cldTodayTo.getTimeInMillis());
      DataBindTextWithChecker   dbInputDateTo = new DataBindTextWithChecker(txtInputTo, "P_NEW_TO",
          yestoday, 10,
          (Object2String)chkDelDate,
          (CellTxtEditorFormat)chkDelDate);
       dataBindComps.add(dbInputDateTo);

       super.reportName="KOMAR_BALANCE.rpt";
     }catch(Exception exp){
        exp.printStackTrace();
     }
    }

    protected java.util.HashMap composeParameters(){
     java.util.HashMap hm=super.composeParameters();//new java.util.HashMap();
     hm.put("P_BUYER",cbxBuyer.getSelectedItem().toString());
     Object fty=slkMaker.getSelectedValue();
     hm.put("P_FACTORY",((fty==null)?"0":fty.toString()));
     hm.put("P_DEL_FM",super.convert2QueryPara(dbDelDateFrom.getSelectedValue()==null?util.MiscFunc.toDate(2000,01,01):dbDelDateFrom.getSelectedValue()));
     hm.put("P_DEL_TO",super.convert2QueryPara(dbDelDateTo.getSelectedValue()==null?util.MiscFunc.toDate(2099,01,01):dbDelDateTo.getSelectedValue()));
     return hm;
    }
    void btnPrint_actionPerformed(ActionEvent e) {
      if(txtInputFrom.getText().trim().length()==0){
          exgui.verification.VerifyLib.showAlert("請輸入 \"Input date Range \"起始日","請輸入 \"Input date Range \"起始日");
          return;
      }
      if(txtInputTo.getText().trim().length()==0){
          exgui.verification.VerifyLib.showAlert("請輸入 \"Input date Range \"截止日","請輸入 \"Input date Range \"截止日");
          return;
      }

      String tempURL= newtimes.production.report.ReportProxyEngine.reportServerURL ;
      newtimes.production.report.ReportProxyEngine.reportServerURL="http://rpt2.nttpe.com.tw:9000/?file:///rpt//";
      super.JButtonQueryButtonAction(null);
      newtimes.production.report.ReportProxyEngine.reportServerURL =tempURL;
    }
    JLabel jLabel8 = new JLabel();
  JComboBox cbxBuyer = new JComboBox(new String[]{"KOMAR","CHDG"});
  JComboBox cbxCountry = new JComboBox();
  JLabel jLabel9 = new JLabel();
  JLabel jLabel10 = new JLabel();
  SelectBuyerMaker slkMaker = new SelectBuyerMaker();
  JLabel jLabel6 = new JLabel();
  JTextField txtInputTo = new JTextField();
  JTextField txtInputFrom = new JTextField();
  JLabel jLabel7 = new JLabel();
  }

