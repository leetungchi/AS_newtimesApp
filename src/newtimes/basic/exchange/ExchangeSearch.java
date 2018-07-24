package newtimes.basic.exchange;

import java.awt.*;
import newtimes.*;
import javax.swing.*;
import java.awt.event.*;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author unascribed
 * @version 1.0
 */

public class ExchangeSearch extends JPanel {
  Frame1 frame;
  private JTextField jTextField2 = new JTextField();
  private JTextField jTextField1 = new JTextField();
  private JLabel textAreaStatus = new JLabel();
  private JButton butnExtra = new JButton();
  private JLabel jLabel1 = new JLabel();
  private JButton butnExit = new JButton();
  private JComboBox cmboBase = new JComboBox();
  private JLabel jLabel13 = new JLabel();
  private JTextField txtYear = new JTextField();
  private JTextField txtMonth = new JTextField();
  private JLabel jLabel3 = new JLabel();
  private exgui.DataBindJCombobox dbJCBXBase = null;
  private exgui.DataBindJCombobox dbJCBXExchange = null;
  private exgui.DataBindJCombobox dbJCBXCen = null;
  JComboBox cmboExchange = new JComboBox();
  JTextField jTextField3 = new JTextField();
  JComboBox cmboCen = new JComboBox();
  JTextField jTextField4 = new JTextField();

  public ExchangeSearch(Frame1 _frame) {
    frame = _frame;
    try {
      jbInit();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }
  void jbInit() throws Exception {
    this.setMaxLength();
    butnExit.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        butnExit_actionPerformed(e);
      }
    });
    butnExit.setText("Exit");
    butnExit.setForeground(Color.darkGray);
    butnExit.setFont(new java.awt.Font("Dialog", 1, 13));
    butnExit.setBounds(new Rectangle(407, 495, 80, 25));
    butnExit.setBackground(Color.lightGray);
    jLabel1.setBounds(new Rectangle(117, 26, 566, 24));
    jLabel1.setText("      ============  Exchange Rate Search  ============      ");
    jLabel1.setHorizontalAlignment(SwingConstants.CENTER);
    jLabel1.setBorder(BorderFactory.createEtchedBorder());
    jLabel1.setForeground(new Color(10,36,106));
    jLabel1.setFont(new java.awt.Font("Dialog", 1, 13));
    butnExtra.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        butnExtra_actionPerformed(e);
      }
    });
    butnExtra.setText("Extract");
    butnExtra.setForeground(Color.darkGray);
    butnExtra.setFont(new java.awt.Font("Dialog", 1, 13));
    butnExtra.setBounds(new Rectangle(308, 495, 80, 25));
    butnExtra.setBackground(Color.lightGray);
    textAreaStatus.setBounds(new Rectangle(0, 540, 800, 30));
    //textAreaStatus.setEditable(false);
    textAreaStatus.setBorder(null);
    textAreaStatus.setBackground(new Color(143, 143, 188));
    jTextField1.setBounds(new Rectangle(193, 138, 155, 23));
    jTextField1.setText(" * Year / Month :");
    jTextField1.setBorder(null);
    jTextField1.setEditable(false);
    jTextField1.setForeground(Color.white);
    jTextField1.setFont(new java.awt.Font("Dialog", 1, 12));
    jTextField1.setBackground(new Color(143, 143, 188));
    jTextField2.setBounds(new Rectangle(193, 171, 155, 23));
    jTextField2.setText(" Base Currency :");
    jTextField2.setBorder(null);
    jTextField2.setEditable(false);
    jTextField2.setForeground(new Color(10,36,106));
    jTextField2.setFont(new java.awt.Font("Dialog", 1, 12));
    jTextField2.setBackground(new Color(143, 143, 188));
    this.setLayout(null);
    this.setSize(800,600);
    this.setBackground(new Color(204, 204, 225));
    cmboBase.setBounds(new Rectangle(350, 171, 271, 23));
    jLabel13.setBounds(new Rectangle(210, 23, 13, 25));
    jLabel13.setText("/");
    jLabel13.setFont(new java.awt.Font("Dialog", 1, 18));
    jLabel13.setBounds(new Rectangle(409, 138, 13, 25));
    txtYear.setText("");
    txtYear.setBounds(new Rectangle(350, 138, 54, 23));
    txtMonth.setBounds(new Rectangle(419, 138, 27, 23));
    jLabel3.setBounds(new Rectangle(451, 138, 99, 23));
    jLabel3.setText("( Year / Month )");
    jLabel3.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel3.setForeground(new Color(143, 143, 188));
    cmboBase.setBackground(Color.white);
    cmboExchange.setBounds(new Rectangle(350, 203, 271, 23));
    jTextField3.setBackground(new Color(143, 143, 188));
    jTextField3.setFont(new java.awt.Font("Dialog", 1, 12));
    jTextField3.setForeground(Color.white);
    jTextField3.setEditable(false);
    jTextField3.setBorder(null);
    jTextField3.setText(" Exchange Currency :");
    jTextField3.setBounds(new Rectangle(193, 203, 155, 23));
    cmboCen.setBounds(new Rectangle(350, 106, 271, 23));
    jTextField4.setBackground(new Color(143, 143, 188));
    jTextField4.setFont(new java.awt.Font("Dialog", 1, 12));
    jTextField4.setForeground(new Color(10,36,106));
    jTextField4.setEditable(false);
    jTextField4.setBorder(null);
    jTextField4.setText(" Center :");
    jTextField4.setBounds(new Rectangle(193, 106, 155, 23));
    cmboCen.setBackground(Color.white);
    cmboExchange.setBackground(Color.white);
    this.add(textAreaStatus, null);
    this.add(jLabel1, null);
    this.add(butnExit, null);
    this.add(butnExtra, null);
    this.add(jTextField4, null);
    this.add(jTextField1, null);
    this.add(jTextField2, null);
    this.add(cmboBase, null);
    this.add(txtYear, null);
    this.add(jLabel13, null);
    this.add(txtMonth, null);
    this.add(jLabel3, null);
    this.add(jTextField3, null);
    this.add(cmboExchange, null);
    this.add(cmboCen, null);
    this.setCmboCrncy();
    txtYear.setText(exgui2.Stuff.System_Year.toString());
    txtMonth.setText(exgui2.Stuff.System_Month.toString());
    if(util.ApplicationProperites.getProperties("recDetail")!=null){
      this.ResetOrigValue((java.util.HashMap) util.ApplicationProperites.getProperties("recDetail"));
    }
  }

  void butnExtra_actionPerformed(ActionEvent e) {
    if (this.checkFieldsData()) {
      java.util.HashMap hm = new java.util.HashMap();
      try {
        setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        String m = txtMonth.getText().length() < 2 ?
            "0"+txtMonth.getText() : txtMonth.getText();
        hm.put("ymDate",txtYear.getText()+m);
        hm.put("EXRATE_BASE_CURRENCY",dbJCBXBase.getSelectedValue());
        hm.put("EXRATE_CEN_CODE",dbJCBXCen.getSelectedValue());
        hm.put("CENTER",cmboCen.getSelectedItem());
        hm.put("EXRATE_NAME",dbJCBXExchange.getSelectedValue());
        // for reset user setting
        hm.put("CEN_CODE_ITEM",cmboCen.getSelectedItem());
        hm.put("BASE_CURRENCY_ITEM",cmboBase.getSelectedItem());
        hm.put("EXCHANGE_CURRENCY_ITEM",cmboExchange.getSelectedItem());
        hm.put("MONTH",txtMonth.getText());
        hm.put("YEAR",txtYear.getText());
        util.ApplicationProperites.setProperties("recDetail", hm);
        frame.showPanel(new newtimes.basic.BasicMenu(frame));
      } catch (Exception eHm) {
        eHm.printStackTrace();
        util.ExceptionLog.exp2File(eHm, "error at HashMap."+hm.toString());
      } finally {
        frame.showPanel(new newtimes.basic.exchange.ExchangeEdit(frame));
      }
    }
  }

  void butnExit_actionPerformed(ActionEvent e) {
    setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
    //util.ApplicationProperites.removeProperites("allData");
    util.ApplicationProperites.removeProperites("recDetail");
    frame.showPanel(new newtimes.basic.BasicMenu(frame));
    setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
  }

  void setCmboCrncy() {
    java.util.Vector vDataCrncy = null;
    java.util.Vector vDataCen = null;
    java.util.Vector vDataExchante = null;
    try {
      vDataCen = exgui2.CONST.BASIC_BASE_EJB.getCenterAll("CEN_CODE,CEN_NAME", "cen_name");
      database.datatype.Record recCen = (database.datatype.Record) vDataCen.get(0);
      dbJCBXCen = new exgui.DataBindJCombobox(cmboCen, vDataCen, "CEN_NAME",
                                           "CEN_CODE", recCen.get("CEN_CODE"));

      vDataExchante = exgui2.CONST.BASIC_MAIN_EJB.getCurrencyAll("CRNCY_NAME", "CRNCY_NAME");
      database.datatype.Record recEx = (database.datatype.Record) vDataExchante.get(0);
      dbJCBXExchange = new exgui.DataBindJCombobox(cmboExchange, vDataExchante, "CRNCY_NAME",
                                           "CRNCY_NAME", recEx.get("CRNCY_NAME"));

      vDataCrncy = exgui2.CONST.BASIC_MAIN_EJB.getCurrencyAll("CRNCY_NAME", "CRNCY_NAME");
      database.datatype.Record rec = (database.datatype.Record) vDataCrncy.get(0);
      dbJCBXBase = new exgui.DataBindJCombobox(cmboBase, vDataCrncy, "CRNCY_NAME",
                                           "CRNCY_NAME", rec.get("CRNCY_NAME"));
      cmboBase.setSelectedIndex(0);
      cmboExchange.setSelectedIndex(0);
      cmboCen.setSelectedIndex(0);
    } catch (Exception e) {
      e.printStackTrace();
      util.ExceptionLog.exp2File(e, "currency data:"+vDataCrncy.toString());
    }
  }

  void setMaxLength(){
    exgui.DataBindText tx = null;
    tx = new exgui.DataBindText(txtYear,null,"",4);
    tx = new exgui.DataBindText(txtMonth,null,"",2);
  }

  boolean checkFieldsData() {
    boolean yNull = exgui2.Stuff.checkNull(frame,txtYear.getText(),"Year can't be empty.");
    boolean mNull = exgui2.Stuff.checkNull(frame,txtMonth.getText(),"Month can't be empty.");
    boolean chkYearInt = exgui2.Stuff.checkInteger(frame, txtYear.getText(),"Year must be less than 2999");
    boolean chkMonthInt = exgui2.Stuff.checkInteger(frame, txtYear.getText(),"Month must be 1~12");
    if (yNull && mNull && chkYearInt && chkMonthInt) { return true; }
    else { return false; }
  }

  void ResetOrigValue(java.util.HashMap hm){
    cmboCen.setSelectedItem(hm.get("CEN_CODE_ITEM"));
    cmboBase.setSelectedItem(hm.get("BASE_CURRENCY_ITEM"));
    cmboExchange.setSelectedItem(hm.get("EXCHANGE_CURRENCY_ITEM"));
    txtMonth.setText((String)hm.get("MONTH"));
    txtYear.setText((String)hm.get("YEAR"));
  }

}
