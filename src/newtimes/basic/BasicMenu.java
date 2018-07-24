package newtimes.basic;

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

public class BasicMenu extends JPanel {
  Frame1 frame;
  private JTextField textAreaStatus = new JTextField();
  private JLabel labelTitle = new JLabel();
  private JLabel jLabel1 = new JLabel();
  private JButton butn_USER = new JButton();
  private JButton butn_CENTER = new JButton();
  private JButton butn_DEPARTMENT = new JButton();
  private JButton butn_EXCHANGE_RATE = new JButton();
  private JButton butn_MANAGER = new JButton();
  private JButton butn_PAYMENT_TERM = new JButton();
  private JButton butn_BRANCH = new JButton();
  private JButton butn_PRICE_TERM = new JButton();
  private JButton butn_COUNTRY = new JButton();
  private JButton butn_QUOTA = new JButton();
  private JButton butn_SIZE = new JButton();
  private JButton butn_SEASON = new JButton();
  private JButton butn_CURRENCY = new JButton();
  private JButton butn_CITY = new JButton();
  private JButton butn_UNIT = new JButton();
  private JButton butnLogout = new JButton();
  private JButton butnExit = new JButton();
  JButton butn_Destination = new JButton();

  public BasicMenu(Frame1 _frame) {
    frame = _frame;
    try {
      jbInit();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }
  void jbInit() throws Exception {
    jLabel1.setBounds(new Rectangle(117, 93, 566, 24));
    jLabel1.setText("      ============  Basic I Maintain  ============      ");
    jLabel1.setHorizontalAlignment(SwingConstants.CENTER);
    jLabel1.setBorder(BorderFactory.createEtchedBorder());
    jLabel1.setForeground(new Color(10,36,106));
    jLabel1.setFont(new java.awt.Font("Dialog", 1, 13));
    labelTitle.setBounds(new Rectangle(0, 0, 800, 50));
    labelTitle.setIcon(exgui.UIHelper.getIcon("title04.jpg"));
    labelTitle.setBounds(new Rectangle(0, 0, 800, 50));
    labelTitle.setText("title");
    textAreaStatus.setBounds(new Rectangle(0, 540, 800, 30));
    textAreaStatus.setEditable(false);
    textAreaStatus.setBorder(null);
    textAreaStatus.setBackground(new Color(143, 143, 188));
    this.setLayout(null);
    this.setSize(800,600);
    this.setBackground(new Color(204, 204, 225));
    butn_USER.setBackground(Color.white);
    butn_USER.setBounds(new Rectangle(61, 169, 325, 23));
    butn_USER.setFont(new java.awt.Font("Dialog", 0, 12));
    butn_USER.setBorder(BorderFactory.createRaisedBevelBorder());
    butn_USER.setHorizontalAlignment(SwingConstants.LEFT);
    butn_USER.setText(" 1.  User");
    butn_USER.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        butn_USER_actionPerformed(e);
      }
    });
    butn_CENTER.setBackground(Color.white);
    butn_CENTER.setBounds(new Rectangle(61, 202, 325, 23));
    butn_CENTER.setFont(new java.awt.Font("Dialog", 0, 12));
    butn_CENTER.setBorder(BorderFactory.createRaisedBevelBorder());
    butn_CENTER.setHorizontalAlignment(SwingConstants.LEFT);
    butn_CENTER.setText(" 2.  Center");
    butn_CENTER.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        butn_CENTER_actionPerformed(e);
      }
    });
    butn_DEPARTMENT.setBackground(Color.white);
    butn_DEPARTMENT.setBounds(new Rectangle(61, 235, 325, 23));
    butn_DEPARTMENT.setFont(new java.awt.Font("Dialog", 0, 12));
    butn_DEPARTMENT.setBorder(BorderFactory.createRaisedBevelBorder());
    butn_DEPARTMENT.setHorizontalAlignment(SwingConstants.LEFT);
    butn_DEPARTMENT.setText(" 3.  Department");
    butn_DEPARTMENT.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        butn_DEPARTMENT_actionPerformed(e);
      }
    });
    butn_EXCHANGE_RATE.setBackground(Color.white);
    butn_EXCHANGE_RATE.setBounds(new Rectangle(413, 169, 325, 23));
    butn_EXCHANGE_RATE.setFont(new java.awt.Font("Dialog", 0, 12));
    butn_EXCHANGE_RATE.setBorder(BorderFactory.createRaisedBevelBorder());
    butn_EXCHANGE_RATE.setHorizontalAlignment(SwingConstants.LEFT);
    butn_EXCHANGE_RATE.setText(" 9.  Exchange Rate");
    butn_EXCHANGE_RATE.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        butn_EXCHANGE_RATE_actionPerformed(e);
      }
    });
    butn_MANAGER.setBackground(Color.white);
    butn_MANAGER.setBounds(new Rectangle(61, 268, 325, 23));
    butn_MANAGER.setFont(new java.awt.Font("Dialog", 0, 12));
    butn_MANAGER.setBorder(BorderFactory.createRaisedBevelBorder());
    butn_MANAGER.setHorizontalAlignment(SwingConstants.LEFT);
    butn_MANAGER.setText(" 4.  Manager");
    butn_MANAGER.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        butn_MANAGER_actionPerformed(e);
      }
    });
    butn_PAYMENT_TERM.setBackground(Color.white);
    butn_PAYMENT_TERM.setBounds(new Rectangle(413, 202, 325, 23));
    butn_PAYMENT_TERM.setFont(new java.awt.Font("Dialog", 0, 12));
    butn_PAYMENT_TERM.setBorder(BorderFactory.createRaisedBevelBorder());
    butn_PAYMENT_TERM.setHorizontalAlignment(SwingConstants.LEFT);
    butn_PAYMENT_TERM.setText(" 10.  Payment Term");
    butn_PAYMENT_TERM.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        butn_PAYMENT_TERM_actionPerformed(e);
      }
    });
    butn_BRANCH.setBackground(Color.white);
    butn_BRANCH.setBounds(new Rectangle(61, 300, 325, 23));
    butn_BRANCH.setFont(new java.awt.Font("Dialog", 0, 12));
    butn_BRANCH.setBorder(BorderFactory.createRaisedBevelBorder());
    butn_BRANCH.setHorizontalAlignment(SwingConstants.LEFT);
    butn_BRANCH.setText(" 5.  Branch");
    butn_BRANCH.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        butn_BRANCH_actionPerformed(e);
      }
    });
    butn_PRICE_TERM.setBackground(Color.white);
    butn_PRICE_TERM.setBounds(new Rectangle(413, 235, 325, 23));
    butn_PRICE_TERM.setFont(new java.awt.Font("Dialog", 0, 12));
    butn_PRICE_TERM.setBorder(BorderFactory.createRaisedBevelBorder());
    butn_PRICE_TERM.setHorizontalAlignment(SwingConstants.LEFT);
    butn_PRICE_TERM.setText(" 11.  Price Term");
    butn_PRICE_TERM.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        butn_PRICE_TERM_actionPerformed(e);
      }
    });
    butn_COUNTRY.setBackground(Color.white);
    butn_COUNTRY.setBounds(new Rectangle(61, 333, 325, 23));
    butn_COUNTRY.setFont(new java.awt.Font("Dialog", 0, 12));
    butn_COUNTRY.setBorder(BorderFactory.createRaisedBevelBorder());
    butn_COUNTRY.setHorizontalAlignment(SwingConstants.LEFT);
    butn_COUNTRY.setText(" 6.  Country");
    butn_COUNTRY.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        butn_COUNTRY_actionPerformed(e);
      }
    });
    butn_QUOTA.setBackground(Color.white);
    butn_QUOTA.setBounds(new Rectangle(413, 268, 325, 23));
    butn_QUOTA.setFont(new java.awt.Font("Dialog", 0, 12));
    butn_QUOTA.setBorder(BorderFactory.createRaisedBevelBorder());
    butn_QUOTA.setHorizontalAlignment(SwingConstants.LEFT);
    butn_QUOTA.setText(" 12.  Quota");
    butn_QUOTA.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        butn_QUOTA_actionPerformed(e);
      }
    });
    butn_SIZE.setBackground(Color.white);
    butn_SIZE.setBounds(new Rectangle(413, 300, 325, 23));
    butn_SIZE.setFont(new java.awt.Font("Dialog", 0, 12));
    butn_SIZE.setBorder(BorderFactory.createRaisedBevelBorder());
    butn_SIZE.setToolTipText("");
    butn_SIZE.setHorizontalAlignment(SwingConstants.LEFT);
    butn_SIZE.setText(" 13.  Size");
    butn_SIZE.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        butn_SIZE_actionPerformed(e);
      }
    });
    butn_SEASON.setBackground(Color.white);
    butn_SEASON.setBounds(new Rectangle(61, 366, 325, 23));
    butn_SEASON.setFont(new java.awt.Font("Dialog", 0, 12));
    butn_SEASON.setBorder(BorderFactory.createRaisedBevelBorder());
    butn_SEASON.setHorizontalAlignment(SwingConstants.LEFT);
    butn_SEASON.setText(" 7.  Season");
    butn_SEASON.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        butn_SEASON_actionPerformed(e);
      }
    });
    butn_CURRENCY.setBackground(Color.white);
    butn_CURRENCY.setBounds(new Rectangle(413, 333, 325, 23));
    butn_CURRENCY.setFont(new java.awt.Font("Dialog", 0, 12));
    butn_CURRENCY.setBorder(BorderFactory.createRaisedBevelBorder());
    butn_CURRENCY.setHorizontalAlignment(SwingConstants.LEFT);
    butn_CURRENCY.setText(" 14.  Currency");
    butn_CURRENCY.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        butn_CURRENCY_actionPerformed(e);
      }
    });
    butn_CITY.setBackground(Color.white);
    butn_CITY.setBounds(new Rectangle(61, 404, 325, 23));
    butn_CITY.setFont(new java.awt.Font("Dialog", 0, 12));
    butn_CITY.setBorder(BorderFactory.createRaisedBevelBorder());
    butn_CITY.setHorizontalAlignment(SwingConstants.LEFT);
    butn_CITY.setText(" 8.  City");
    butn_CITY.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        butn_CITY_actionPerformed(e);
      }
    });
    butn_UNIT.setBackground(Color.white);
    butn_UNIT.setBounds(new Rectangle(413, 366, 325, 23));
    butn_UNIT.setFont(new java.awt.Font("Dialog", 0, 12));
    butn_UNIT.setBorder(BorderFactory.createRaisedBevelBorder());
    butn_UNIT.setHorizontalAlignment(SwingConstants.LEFT);
    butn_UNIT.setText(" 15.  Unit");
    butn_UNIT.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        butn_UNIT_actionPerformed(e);
      }
    });
    butnLogout.setBackground(Color.lightGray);
    butnLogout.setBounds(new Rectangle(290, 492, 80, 25));
    butnLogout.setFont(new java.awt.Font("Dialog", 1, 13));
    butnLogout.setForeground(Color.darkGray);
    butnLogout.setText("Logout");
    butnLogout.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        butnLogout_actionPerformed(e);
      }
    });
    butnExit.setBackground(Color.lightGray);
    butnExit.setBounds(new Rectangle(432, 492, 80, 25));
    butnExit.setFont(new java.awt.Font("Dialog", 1, 13));
    butnExit.setForeground(Color.darkGray);
    butnExit.setText("Exit");
    butnExit.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        butnExit_actionPerformed(e);
      }
    });
    butn_Destination.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        butn_Destination_actionPerformed(e);
      }
    });
    butn_Destination.setText("16.  Destinations");
    butn_Destination.setHorizontalAlignment(SwingConstants.LEFT);
    butn_Destination.setBorder(BorderFactory.createRaisedBevelBorder());
    butn_Destination.setFont(new java.awt.Font("Dialog", 0, 12));
    butn_Destination.setBounds(new Rectangle(413, 404, 325, 23));
    butn_Destination.setBackground(Color.white);
    this.add(textAreaStatus, null);
    this.add(jLabel1, null);
    this.add(labelTitle, null);
    this.add(butnExit, null);
    this.add(butnLogout, null);
    this.add(butn_USER, null);
    this.add(butn_CENTER, null);
    this.add(butn_DEPARTMENT, null);
    this.add(butn_EXCHANGE_RATE, null);
    this.add(butn_MANAGER, null);
    this.add(butn_PAYMENT_TERM, null);
    this.add(butn_BRANCH, null);
    this.add(butn_PRICE_TERM, null);
    this.add(butn_COUNTRY, null);
    this.add(butn_QUOTA, null);
    this.add(butn_SIZE, null);
    this.add(butn_SEASON, null);
    this.add(butn_CURRENCY, null);
    this.add(butn_UNIT, null);
    this.add(butn_CITY, null);
    this.add(butn_Destination, null);
  }
  void butnLogout_actionPerformed(ActionEvent e) {
    setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
    frame.showPanel(new Login(frame));
    setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
  }
  void butnExit_actionPerformed(ActionEvent e) {
    setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
    frame.showPanel(new MainFunction(frame));
    setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
  }

  void butn_USER_actionPerformed(ActionEvent e) {
    setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
    frame.showPanel(new newtimes.basic.user.UserSearch(frame));
    setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
  }

  void butn_CENTER_actionPerformed(ActionEvent e) {
    setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
    frame.showPanel(new newtimes.basic.center.CenterList(frame));
    setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
  }

  void butn_DEPARTMENT_actionPerformed(ActionEvent e) {
    setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
    frame.showPanel(new newtimes.basic.department.DepSearch(frame));
    setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
  }

  void butn_MANAGER_actionPerformed(ActionEvent e) {
    setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
    frame.showPanel(new newtimes.basic.manager.ManagerSearch(frame));
    setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
  }

  void butn_BRANCH_actionPerformed(ActionEvent e) {
    if(newtimes.basic.branch.BranchAbsTable.hmlistCenters==null){
      try{
        java.util.Vector vSelectCenters =
            exgui2.CONST.BASIC_MAIN_EJB.getDatas(
            util.PublicVariable.USER_RECORD,
            "select CEN_CODE, CEN_NAME from center where record_delete_flag='1' order by cen_name",
            1, 999);
        java.util.HashMap hm = new java.util.HashMap();
        for (int i = 0; i < vSelectCenters.size(); i++) {
          database.datatype.Record rec = (database.datatype.Record)
              vSelectCenters.get(i);
          hm.put(rec.get(0), rec.get(1));
        }
        newtimes.basic.branch.BranchAbsTable.hmlistCenters = hm;
      }catch(Exception exp){
        exp.printStackTrace();
        util.ExceptionLog .exp2File(exp,"");
      }
    }
    setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
    frame.showPanel(new newtimes.basic.branch.BranchList(frame));
    setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
  }

  void butn_COUNTRY_actionPerformed(ActionEvent e) {
    setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
    frame.showPanel(new newtimes.basic.country.CountryList(frame));
    setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
  }

  void butn_DIVISION_actionPerformed(ActionEvent e) {
    setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
    frame.showPanel(new newtimes.basic.division.DivisionList(frame));
    setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
  }

  void butn_SEASON_actionPerformed(ActionEvent e) {
    setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
    frame.showPanel(new newtimes.basic.season.SeasonList(frame));
    setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
  }

  void butn_CITY_actionPerformed(ActionEvent e) {
    if(newtimes.basic.branch.BranchAbsTable.hmlistCenters!=null){
      newtimes.basic.city.CityAbsTable.hmlistCenters= new java.util.HashMap();
      newtimes.basic.city.CityAbsTable.hmlistCenters.putAll(newtimes.basic.branch.BranchAbsTable.hmlistCenters);
    }
    if(newtimes.basic.branch.BranchAbsTable.hmlistCenters==null){
      try{
        java.util.Vector vSelectCenters =
            exgui2.CONST.BASIC_MAIN_EJB.getDatas(
            util.PublicVariable.USER_RECORD,
            "select CEN_CODE, CEN_NAME from center where record_delete_flag='1' order by cen_name",
            1, 999);
        java.util.HashMap hm = new java.util.HashMap();
        for (int i = 0; i < vSelectCenters.size(); i++) {
          database.datatype.Record rec = (database.datatype.Record)
              vSelectCenters.get(i);
          hm.put(rec.get(0), rec.get(1));
        }
        newtimes.basic.branch.BranchAbsTable.hmlistCenters = hm;
        newtimes.basic.city.CityAbsTable.hmlistCenters= new java.util.HashMap();
        newtimes.basic.city.CityAbsTable.hmlistCenters.putAll(newtimes.basic.branch.BranchAbsTable.hmlistCenters);
      }catch(Exception exp){
        exp.printStackTrace();
        util.ExceptionLog .exp2File(exp,"");
      }
    }

    setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
    frame.showPanel(new newtimes.basic.city.CitySearch(frame));
    setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
  }

  void butn_BUYER_MAKER_actionPerformed(ActionEvent e) {
    setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
    frame.showPanel(new newtimes.basic.buyermaker.BuyerMakerSearch(frame));
    setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
  }

  void butn_SHIPMARK_actionPerformed(ActionEvent e) {
    setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
    frame.showPanel(new newtimes.basic.shipmark.ShipmarkSearch(frame));
    setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
  }

  void butn_EXCHANGE_RATE_actionPerformed(ActionEvent e) {
    setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
    frame.showPanel(new newtimes.basic.exchange.ExchangeSearch(frame));
    setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
  }

  void butn_PAYMENT_TERM_actionPerformed(ActionEvent e) {
    setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
    frame.showPanel(new newtimes.basic.paymentterm.PaymentTermList(frame));
    setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
  }

  void butn_PRICE_TERM_actionPerformed(ActionEvent e) {
    setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
    frame.showPanel(new newtimes.basic.priceterm.PriceTermList(frame));
    setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
  }

  void butn_QUOTA_actionPerformed(ActionEvent e) {
    setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
    frame.showPanel(new newtimes.basic.quota.QuotaLit(frame));
    setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
  }

  void butn_SIZE_actionPerformed(ActionEvent e) {
    setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
    frame.showPanel(new newtimes.basic.size.SizeList(frame));
    setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
  }

  void butn_CURRENCY_actionPerformed(ActionEvent e) {
    setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
    frame.showPanel(new newtimes.basic.currency.CurrencyList(frame));
    setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
  }

  void butn_UNIT_actionPerformed(ActionEvent e) {
    setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
    frame.showPanel(new newtimes.basic.unit.UnitList(frame));
    setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
  }
  void butn_Destination_actionPerformed(ActionEvent e) {
    setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
    frame.showPanel(new newtimes.basic.destination.PnlContantDestList());
    setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
  }
}
