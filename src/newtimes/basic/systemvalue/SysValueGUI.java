package newtimes.basic.systemvalue;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class SysValueGUI extends JPanel {
  JLabel jLabel1 = new JLabel();
  JLabel jTextField7 = new JLabel();
  JLabel jTextField3 = new JLabel();
  JButton butnExit = new JButton();
  JLabel jTextField2 = new JLabel();
  JLabel textAreaStatus = new JLabel();
  JLabel jTextField1 = new JLabel();
  JTextField txtIC = new JTextField();
  JButton butnDel = new JButton();
  JLabel jTextField4 = new JLabel();
  JButton butnModify = new JButton();
  JComboBox cmboCen = new JComboBox();
  JComboBox cmboCrncy = new JComboBox();
  String titleName = null;
  exgui.DataBindJCombobox dbJCBXCen = null;
  exgui.DataBindJCombobox dbJCBXCrncy = null;
  JButton butnAdd = new JButton();
  JLabel jTextField5 = new JLabel();
  JLabel jTextField6 = new JLabel();
  JLabel jTextField8 = new JLabel();
  JLabel jTextField9 = new JLabel();
  JTextField txtCurrentYear = new JTextField();
  JTextField txtYearRngBgn = new JTextField();
  JLabel jLabel4 = new JLabel();
  JTextField txtYearRngEnd = new JTextField();
  JLabel jLabel5 = new JLabel();
  JTextField txtPlanDelEnd = new JTextField();
  JTextField txtPlanDelBgn = new JTextField();
  JLabel jLabel6 = new JLabel();
  JTextField txtDelvRngEnd = new JTextField();
  JTextField txtDelvRngBgn = new JTextField();
  exgui.DataBindTextWithChecker dbCurrYear;
  exgui.DataBindTextWithChecker dbYearBgn,dbYearEnd,dbShipCloseBefore;
  exgui.DataBindTextWithChecker dbPlanDelBgn,dbPlanDelEnd;
  exgui.DataBindTextWithChecker dbDelvBgn,dbDelvEnd;
  exgui.DataBindTextWithChecker dbXchg,dbTwdChg,dbRmbChg,dbHkdChg,dbFHA;
  JTextField txtXchg = new JTextField();
  JTextField txtFHA = new JTextField();
  JLabel jLabel2 = new JLabel();
  JLabel jLabel3 = new JLabel();
  JLabel jLabel7 = new JLabel();
  JLabel jTextField10 = new JLabel();
  JTextField txtTwdXchg = new JTextField();
  JTextField txtRmbXchg = new JTextField();
  JLabel jTextField11 = new JLabel();
  JLabel jLabel8 = new JLabel();
  JTextField txtHkdXchg = new JTextField();
  JLabel jTextField12 = new JLabel();
  JLabel jLabel9 = new JLabel();
  JLabel jTextField13 = new JLabel();
  JTextField txtShipCloseB4 = new JTextField();
  JButton btnOtherTpeRange = new JButton();

  public SysValueGUI(String _titleName) {
    titleName = _titleName;
    try {
      jbInit();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }
  void jbInit() throws Exception {
    this.setMaxLength();
    butnModify.setText("Confirm Modify");
    butnModify.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        butnModify_actionPerformed(e);
      }
    });
    butnModify.setForeground(Color.darkGray);
    butnModify.setFont(new java.awt.Font("Dialog", 1, 13));
    butnModify.setBounds(new Rectangle(232, 512, 134, 25));
    butnModify.setBackground(Color.lightGray);
    jTextField4.setBackground(new Color(143, 143, 188));
    jTextField4.setFont(new java.awt.Font("Dialog", 1, 12));
    jTextField4.setForeground(new Color(10,36,106));
    jTextField4.setOpaque(true);
    jTextField4.setBorder(null);
    jTextField4.setText(" FHA :");
    jTextField4.setBounds(new Rectangle(139, 234, 155, 23));
    butnDel.setText("Delete");
    butnDel.setForeground(Color.darkGray);
    butnDel.setFont(new java.awt.Font("Dialog", 1, 13));
    butnDel.setBounds(new Rectangle(383, 512, 80, 25));
    butnDel.setBackground(Color.lightGray);
    txtIC.setBounds(new Rectangle(295, 138, 364, 23));
    jTextField1.setBounds(new Rectangle(139, 170, 155, 23));
    jTextField1.setText(" Currency :");
    jTextField1.setOpaque(true);
    jTextField1.setBorder(null);
    jTextField1.setForeground(new Color(10,36,106));
    jTextField1.setFont(new java.awt.Font("Dialog", 1, 12));
    jTextField1.setBackground(new Color(143, 143, 188));
    textAreaStatus.setBounds(new Rectangle(0, 540, 800, 30));
    textAreaStatus.setOpaque(true);
    textAreaStatus.setBorder(null);
    textAreaStatus.setBackground(new Color(143, 143, 188));
    jTextField2.setBounds(new Rectangle(139, 106, 155, 23));
    jTextField2.setText(" * Center :");
    jTextField2.setOpaque(true);
    jTextField2.setBorder(null);
    jTextField2.setForeground(new Color(10,36,106));
    jTextField2.setFont(new java.awt.Font("Dialog", 1, 12));
    jTextField2.setBackground(new Color(143, 143, 188));
    butnExit.setText("Exit");
    butnExit.setForeground(Color.darkGray);
    butnExit.setFont(new java.awt.Font("Dialog", 1, 13));
    butnExit.setBounds(new Rectangle(479, 512, 80, 25));
    butnExit.setBackground(Color.lightGray);
    jTextField3.setBounds(new Rectangle(139, 202, 155, 23));
    jTextField3.setText(" Exchange :");
    jTextField3.setOpaque(true);
    jTextField3.setBorder(null);
    jTextField3.setForeground(Color.white);
    jTextField3.setFont(new java.awt.Font("Dialog", 1, 12));
    jTextField3.setBackground(new Color(143, 143, 188));
    jTextField7.setBackground(new Color(143, 143, 188));
    jTextField7.setFont(new java.awt.Font("Dialog", 1, 12));
    jTextField7.setForeground(Color.white);
    jTextField7.setBorder(null);
    //jTextField7.setSelectedTextColor(Color.white);
    jTextField7.setOpaque(true);
    jTextField7.setText(" * IC :");
    jTextField7.setBounds(new Rectangle(139, 138, 155, 23));
    jLabel1.setBounds(new Rectangle(117, 26, 566, 24));
    jLabel1.setText("      ============  "+titleName+"  ============      ");
    jLabel1.setHorizontalAlignment(SwingConstants.CENTER);
    jLabel1.setBorder(BorderFactory.createEtchedBorder());
    jLabel1.setForeground(new Color(10,36,106));
    jLabel1.setFont(new java.awt.Font("Dialog", 1, 13));
    this.setLayout(null);
    this.setSize(800,600);
    this.setBackground(new Color(204, 204, 225));
    cmboCen.setBounds(new Rectangle(295, 106, 364, 21));
    cmboCrncy.setBounds(new Rectangle(295, 170, 364, 20));
    cmboCen.setBackground(Color.white);
    cmboCrncy.setBackground(Color.white);
    butnAdd.setBackground(Color.lightGray);
    butnAdd.setBounds(new Rectangle(141, 513, 80, 25));
    butnAdd.setFont(new java.awt.Font("Dialog", 1, 13));
    butnAdd.setForeground(Color.darkGray);
    butnAdd.setText("Add");
    butnAdd.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        butnAdd_actionPerformed(e);
      }
    });
    jTextField5.setBackground(new Color(143, 143, 188));
    jTextField5.setFont(new java.awt.Font("Dialog", 1, 12));
    jTextField5.setForeground(Color.white);
    jTextField5.setBorder(null);
    jTextField5.setOpaque(true);
    jTextField5.setText(" DEFAULT YEAR:");
    jTextField5.setBounds(new Rectangle(139, 272, 155, 23));
    jTextField6.setBounds(new Rectangle(139, 304, 155, 23));
    jTextField6.setText(" YEAR RANGE:");
    jTextField6.setBorder(null);
    jTextField6.setOpaque(true);
    jTextField6.setForeground(new Color(10, 36, 106));
    jTextField6.setFont(new java.awt.Font("Dialog", 1, 12));
    jTextField6.setBackground(new Color(143, 143, 188));
    jTextField8.setBackground(new Color(143, 143, 188));
    jTextField8.setFont(new java.awt.Font("Dialog", 1, 12));
    jTextField8.setForeground(new Color(10,36,106));
    jTextField8.setOpaque(true);
    jTextField8.setBorder(null);
    jTextField8.setText(" DELIVERY RANGE:");
    jTextField8.setBounds(new Rectangle(139, 369, 155, 23));
    jTextField9.setBounds(new Rectangle(139, 337, 155, 23));
    jTextField9.setText(" ETD DEL. RANGE:");
    jTextField9.setOpaque(true);
    jTextField9.setBorder(null);
    jTextField9.setForeground(Color.white);
    jTextField9.setFont(new java.awt.Font("Dialog", 1, 12));
    jTextField9.setBackground(new Color(143, 143, 188));
    txtCurrentYear.setText("");
    txtCurrentYear.setBounds(new Rectangle(294, 272, 71, 21));
    txtYearRngBgn.setText("");
    txtYearRngBgn.setBounds(new Rectangle(295, 304, 71, 24));
    jLabel4.setFont(new java.awt.Font("Dialog", 1, 11));
    jLabel4.setText("TO");
    jLabel4.setBounds(new Rectangle(375, 304, 24, 23));
    txtYearRngEnd.setBounds(new Rectangle(397, 304, 71, 24));
    txtYearRngEnd.setText("");
    jLabel5.setBounds(new Rectangle(375, 337, 24, 23));
    jLabel5.setText("TO");
    jLabel5.setFont(new java.awt.Font("Dialog", 1, 11));
    txtPlanDelEnd.setText("");
    txtPlanDelEnd.setBounds(new Rectangle(397, 337, 71, 24));
    txtPlanDelBgn.setBounds(new Rectangle(295, 337, 71, 24));
    txtPlanDelBgn.setText("");
    jLabel6.setBounds(new Rectangle(375, 370, 24, 23));
    jLabel6.setText("TO");
    jLabel6.setFont(new java.awt.Font("Dialog", 1, 11));
    txtDelvRngEnd.setText("");
    txtDelvRngEnd.setBounds(new Rectangle(397, 370, 71, 24));
    txtDelvRngBgn.setBounds(new Rectangle(295, 370, 71, 24));
    txtDelvRngBgn.setText("");
    txtXchg.setText("");
    txtXchg.setBounds(new Rectangle(294, 202, 93, 23));
    txtFHA.setText("");
    txtFHA.setBounds(new Rectangle(293, 234, 93, 23));
    jLabel2.setText("(#####.####)");
    jLabel2.setBounds(new Rectangle(388, 205, 108, 23));
    jLabel3.setBounds(new Rectangle(388, 236, 51, 23));
    jLabel3.setText("(###.##)");
    jLabel7.setBounds(new Rectangle(393, 396, 108, 23));
    jLabel7.setText("(#####.####)");
    jTextField10.setBackground(new Color(143, 143, 188));
    jTextField10.setFont(new java.awt.Font("Dialog", 1, 12));
    jTextField10.setForeground(Color.white);
    jTextField10.setBorder(null);
    jTextField10.setOpaque(true);
    jTextField10.setText(" TWD Exchange :");
    jTextField10.setBounds(new Rectangle(139, 397, 155, 23));
    txtTwdXchg.setBounds(new Rectangle(294, 397, 93, 23));
    txtTwdXchg.setText("");
    txtRmbXchg.setText("");
    txtRmbXchg.setBounds(new Rectangle(295, 425, 93, 23));
    jTextField11.setBounds(new Rectangle(140, 425, 155, 23));
    jTextField11.setText(" RMB Exchange :");
    jTextField11.setOpaque(true);
    jTextField11.setBorder(null);
    jTextField11.setForeground(new Color(10, 36, 106));
    jTextField11.setFont(new java.awt.Font("Dialog", 1, 12));
    jTextField11.setBackground(new Color(143, 143, 188));
    jLabel8.setText("(#####.####)");
    jLabel8.setBounds(new Rectangle(395, 424, 108, 23));
    txtHkdXchg.setText("");
    txtHkdXchg.setBounds(new Rectangle(294, 453, 93, 23));
    jTextField12.setBounds(new Rectangle(139, 453, 155, 23));
    jTextField12.setText(" HKD Exchange :");
    jTextField12.setOpaque(true);
    jTextField12.setBorder(null);
    jTextField12.setForeground(Color.white);
    jTextField12.setFont(new java.awt.Font("Dialog", 1, 12));
    jTextField12.setBackground(new Color(143, 143, 188));
    jLabel9.setText("(#####.####)");
    jLabel9.setBounds(new Rectangle(396, 452, 108, 23));
    jTextField13.setBounds(new Rectangle(398, 272, 155, 23));
    jTextField13.setText(" SHIP CLOSE BEFORE:");
    jTextField13.setBorder(null);
    jTextField13.setOpaque(true);
    jTextField13.setForeground(new Color(10,36,106));
    jTextField13.setFont(new java.awt.Font("Dialog", 1, 12));
    jTextField13.setBackground(new Color(143, 143, 188));
    txtShipCloseB4.setText("");
    txtShipCloseB4.setBounds(new Rectangle(554, 272, 71, 24));
    btnOtherTpeRange.setBounds(new Rectangle(497, 304, 216, 29));
    btnOtherTpeRange.setFont(new java.awt.Font("Dialog", 1, 11));
    btnOtherTpeRange.setText("OTHER TPE RANGE");
    btnOtherTpeRange.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnOtherTpeRange_actionPerformed(e);
      }
    });
    this.add(textAreaStatus, null);
    this.add(jLabel1, null);
    this.add(jTextField1, null);
    this.add(txtIC, null);
    this.add(jTextField4, null);
    this.add(jTextField7, null);
    this.add(jTextField3, null);
    this.add(jTextField2, null);
    this.add(cmboCen, null);
    this.add(cmboCrncy, null);
    this.add(jTextField9, null);
    this.add(jTextField8, null);
    this.add(jTextField5, null);
    this.add(jTextField6, null);
    this.add(txtCurrentYear, null);
    this.add(txtYearRngBgn, null);
    this.add(jLabel4, null);
    this.add(txtYearRngEnd, null);
    this.add(jLabel5, null);
    this.add(txtPlanDelEnd, null);
    this.add(txtPlanDelBgn, null);
    this.add(jLabel6, null);
    this.add(txtDelvRngEnd, null);
    this.add(txtDelvRngBgn, null);
    this.add(txtXchg, null);
    this.add(txtFHA, null);
    this.add(jLabel2, null);
    this.add(jLabel3, null);
    this.add(jTextField10, null);
    this.add(txtTwdXchg, null);
    this.add(jLabel7, null);
    this.add(butnModify, null);
    this.add(butnDel, null);
    this.add(butnExit, null);
    this.add(jTextField12, null);
    this.add(txtHkdXchg, null);
    this.add(jLabel9, null);
    this.add(jTextField11, null);
    this.add(txtRmbXchg, null);
    this.add(jLabel8, null);
    this.add(butnAdd, null);
    this.add(jTextField13, null);
    this.add(txtShipCloseB4, null);
    this.setCmbo();


  }
  void setMaxLength(){
    exgui.DataBindText tx = null;
    tx = new exgui.DataBindText(txtIC,null,"",40);
    //tx = new exgui.DataBindText(txtEx_1,null,"",3);
    //tx = new exgui.DataBindText(txtEx_2,null,"",2);
    //tx = new exgui.DataBindText(txtFHA_1,null,"",3);
    //tx = new exgui.DataBindText(txtFHA_2,null,"",2);

    Object chkDcm32=exgui.verification.CellFormat.getDoubleFormatAllowNull(5,4);
    dbXchg =
        new  exgui.DataBindTextWithChecker(txtXchg,
                                     "exchange_rate",
                                      null,
                                      10,
                                      (exgui.Object2String)chkDcm32,
                                      (exgui.ultratable.CellTxtEditorFormat)chkDcm32);



    dbTwdChg =
        new  exgui.DataBindTextWithChecker(txtTwdXchg,
                                     "TWD_XCHG_RATE",
                                      null,
                                      10,
                                      (exgui.Object2String)chkDcm32,
                                      (exgui.ultratable.CellTxtEditorFormat)chkDcm32);
    dbRmbChg =
        new  exgui.DataBindTextWithChecker(txtRmbXchg,
                                     "RMB_XCHG_RATE",
                                      null,
                                      10,
                                      (exgui.Object2String)chkDcm32,
                                      (exgui.ultratable.CellTxtEditorFormat)chkDcm32);
    dbHkdChg =
        new  exgui.DataBindTextWithChecker(txtHkdXchg,
                                     "HKD_XCHG_RATE",
                                      null,
                                      10,
                                      (exgui.Object2String)chkDcm32,
                                      (exgui.ultratable.CellTxtEditorFormat)chkDcm32);



    dbFHA =
        new  exgui.DataBindTextWithChecker(txtFHA,
                                     "FHA",
                                      null,
                                      6,
                                      (exgui.Object2String)chkDcm32,
                                      (exgui.ultratable.CellTxtEditorFormat)chkDcm32);


    Object objInt4Cnv=exgui.verification.CellFormat.getIntVerifierAllowNull(4);
    dbCurrYear =
        new  exgui.DataBindTextWithChecker(txtCurrentYear,
                                     "current_year",
                                      null,
                                      4,
                                      (exgui.Object2String)objInt4Cnv,
                                      (exgui.ultratable.CellTxtEditorFormat)objInt4Cnv);
   Date000000Conv dateBgn=new Date000000Conv();
   Date235959Conv dateEnd=new Date235959Conv();

   dbYearBgn =
       new exgui.DataBindTextWithChecker(txtYearRngBgn,
                                         "year_rng_bgn",
                                         null,
                                         4,
                                         (exgui.Object2String)objInt4Cnv,
                                         (exgui.ultratable.
                                          CellTxtEditorFormat)objInt4Cnv
                                         );
   dbYearEnd =
       new exgui.DataBindTextWithChecker(txtYearRngEnd,
                                         "year_rng_end",
                                         null,
                                         4,
                                         (exgui.Object2String)objInt4Cnv,
                                         (exgui.ultratable.
                                          CellTxtEditorFormat)objInt4Cnv
                                         );

   dbPlanDelBgn =
       new exgui.DataBindTextWithChecker(txtPlanDelBgn,
                                         "plan_del_bgn",
                                         null,
                                         10,
                                         (exgui.Object2String)dateBgn,
                                         (exgui.ultratable.
                                          CellTxtEditorFormat)dateBgn
                                         );


   dbShipCloseBefore =
       new exgui.DataBindTextWithChecker(txtShipCloseB4,
                                         "SHIP_CLOSE_B4",
                                         null,
                                         10,
                                         (exgui.Object2String)dateBgn,
                                         (exgui.ultratable.
                                          CellTxtEditorFormat)dateBgn
                                         );


   dbPlanDelEnd =
       new exgui.DataBindTextWithChecker(txtPlanDelEnd,
                                         "plan_del_end",
                                         null,
                                         10,
                                         (exgui.Object2String)dateEnd,
                                         (exgui.ultratable.
                                          CellTxtEditorFormat)dateEnd
                                         );


   dbDelvBgn  =
       new exgui.DataBindTextWithChecker(txtDelvRngBgn ,
                                         "delv_rng_bgn",
                                         null,
                                         10,
                                         (exgui.Object2String)dateBgn,
                                         (exgui.ultratable.
                                          CellTxtEditorFormat)dateBgn
                                         );

   dbDelvEnd =
       new exgui.DataBindTextWithChecker(txtDelvRngEnd,
                                         "delv_rng_end",
                                         null,
                                         10,
                                         (exgui.Object2String)dateEnd,
                                         (exgui.ultratable.
                                          CellTxtEditorFormat)dateEnd
                                         );

  }
static public  class Date000000Conv extends  Date235959Conv {
    public Object cellStringToObject(String str){
      Object obj= ((exgui.ultratable.CellTxtEditorFormat)dateChecker).cellStringToObject(str);
      if(obj!=null){
        java.sql.Date orgDate=new java.sql.Date(((java.util.Date)obj).getTime());
        java.util.Date dateObj=util.MiscFunc.toDate000000(
           util.MiscFunc.getYear(orgDate),
          util.MiscFunc.getMonth(orgDate),
          util.MiscFunc.getDay(orgDate));
        return  dateObj;
      }else
      return null;
    }
}
static public  class Date235959Conv implements exgui.Object2String,exgui.ultratable.CellTxtEditorFormat{
    Object dateChecker=exgui.verification.CellFormat.getDateStringFormaterAllowNull();
    public Object cellStringToObject(String str){
      Object obj= ((exgui.ultratable.CellTxtEditorFormat)dateChecker).cellStringToObject(str);
      if(obj!=null){
        java.sql.Date orgDate=new java.sql.Date(((java.util.Date)obj).getTime());
        java.util.Date dateObj=util.MiscFunc.toDate235959(
           util.MiscFunc.getYear(orgDate),
          util.MiscFunc.getMonth(orgDate),
          util.MiscFunc.getDay(orgDate));
        return  dateObj;
      }else
      return null;
    }
    public exgui.ultratable.KeyProcess getKeyListener(){
      return ((exgui.ultratable.CellTxtEditorFormat)dateChecker).getKeyListener();
    }
    public String Obj2String(Object obj){return
        ((exgui.Object2String)dateChecker).Obj2String(obj) ;
    }
    public boolean isFormatValid(String str,int x,int y){
      return ((exgui.ultratable.CellTxtEditorFormat)dateChecker).isFormatValid(str,x,y);}
    public String formatPromptMsg(){return
    ((exgui.ultratable.CellTxtEditorFormat)dateChecker).formatPromptMsg();}
    public int getMaxLength(){return 10;}


  }
  void setCmbo() {
    java.util.Vector vDataCrncy = null;
    java.util.Vector vDataCen = null;
    try {
      vDataCen = exgui2.CONST.BASIC_BASE_EJB.getCenterAll("CEN_CODE,CEN_NAME","cen_name");
      database.datatype.Record recCen = (database.datatype.Record) vDataCen.get(0);
      dbJCBXCen = new exgui.DataBindJCombobox(cmboCen, vDataCen, "CEN_NAME",
                                    "CEN_CODE", recCen.get("CEN_CODE"));
      vDataCrncy = exgui2.CONST.BASIC_MAIN_EJB.getCurrencyAll("CRNCY_NAME", "CRNCY_NAME");
      database.datatype.Record rec = (database.datatype.Record) vDataCrncy.get(0);
      dbJCBXCrncy = new exgui.DataBindJCombobox(cmboCrncy, vDataCrncy, "CRNCY_NAME",
                                           "CRNCY_NAME", rec.get("CRNCY_NAME"),"","null");

      cmboCrncy.setSelectedIndex(0);
    } catch (Exception e) {
      e.printStackTrace();
      util.ExceptionLog.exp2File(e, "error at set CmboBox datas.");
    }
  }
  boolean checkFieldsData() {
    //boolean chkEx_1 = exgui2.Stuff.checkInteger(new JFrame(), txtEx_1.getText(),"Exchange must be less than 999.99");
    //boolean chkEx_2 = exgui2.Stuff.checkInteger(new JFrame(), txtEx_2.getText(),"Exchange must be less than 999.99");
    //boolean chkFHA_1 = exgui2.Stuff.checkInteger(new JFrame(), txtFHA_1.getText(),"FHA must be less than 999.99");
    //boolean chkFHA_2 = exgui2.Stuff.checkInteger(new JFrame(), txtFHA_2.getText(),"FHA must be less than 999.99");
    if(!dbCurrYear.isValidx()){
      exgui.verification.VerifyLib.showAlert("YEAR Should Be 4 Digits",
                                             "Format Error");

      return false;
    }
    if(!dbYearBgn.isValidx()){
      exgui.verification.VerifyLib.showAlert("YEAR Begin Error",
                                             "Format Error");

      return false;
    }
    if(!dbYearEnd.isValidx()){
      exgui.verification.VerifyLib.showAlert("YEAR End Error",
                                             "Format Error");

      return false;
    }
    if(!dbPlanDelBgn.isValidx()){
      exgui.verification.VerifyLib.showAlert("\"Plan Delivery Begin\" Error",
                                             "Format Error");

      return false;
    }
    if(!dbPlanDelEnd.isValidx()){
      exgui.verification.VerifyLib.showAlert("\"Plan Delivery End\" Error",
                                             "Format Error");

      return false;
    }
    if(!dbDelvBgn.isValidx()){
      exgui.verification.VerifyLib.showAlert("\"Delivery Begin\" Error",
                                             "Format Error");

      return false;
    }
    if(!dbDelvEnd.isValidx()){
      exgui.verification.VerifyLib.showAlert("\"Delivery End\" Error",
                                             "Format Error");

      return false;
    }
    if(!dbFHA.isValidx()){
      exgui.verification.VerifyLib.showAlert("FHA value Error",
                                             "Format Error");

      return false;
    }
    if(!dbXchg.isValidx()){
      exgui.verification.VerifyLib.showAlert("EXCHANGE RATE ERROR",
                                             "Format Error");

      return false;
    }
    if(!dbTwdChg.isValidx()){
      exgui.verification.VerifyLib.showAlert("TWD EXCHANGE RATE ERROR",
                                             "Format Error");

      return false;
    }
    if(!dbRmbChg.isValidx()){
      exgui.verification.VerifyLib.showAlert("RMB EXCHANGE RATE ERROR",
                                             "Format Error");

      return false;
    }
    if(!dbHkdChg.isValidx()){
      exgui.verification.VerifyLib.showAlert("HKD EXCHANGE RATE ERROR",
                                             "Format Error");

      return false;
    }

    //if (chkEx_1 && chkEx_2 && chkFHA_1 && chkFHA_2) { return true; }
    return true;
  }

  void butnModify_actionPerformed(ActionEvent e) {

  }

  void butnAdd_actionPerformed(ActionEvent e) {

  }

  void btnOtherTpeRange_actionPerformed(ActionEvent e) {
     util.MiscFunc.showProcessingMessage();
     PnlOtherDateRange pnl2list=new PnlOtherDateRange((String)dbJCBXCen.getSelectedValue());
     DlgOtherDateRange dlg=
         new DlgOtherDateRange(util.PublicVariable.APP_FRAME,"Other Range Definition",true,pnl2list);
     dlg.setSize(530,340);
     exgui.UIHelper.setToScreenCenter(dlg);
     util.MiscFunc.hideProcessingMessage();
     dlg.show();

   }
}
