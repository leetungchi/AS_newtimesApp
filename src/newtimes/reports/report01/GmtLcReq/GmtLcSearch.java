package newtimes.reports.report01.GmtLcReq;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.Vector;
import java.util.HashMap;
import newtimes.*;
import newtimes.material.Util;
import javax.swing.border.*;
import exgui2.*;


/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class GmtLcSearch extends JPanel {
  GmtLcList parent=null;

  private final newtimes.material.CONST.MTR.EJB MTR_EJB = null;
  private final newtimes.material.CONST.DIV.EJB DIV_EJB = null;
  private final newtimes.material.CONST.BYMK.EJB BYMK_EJB = null;
  private final newtimes.material.CONST.SEASON.EJB SEA_EJB = null;
  private Vector DivList     = null;
  private Vector SeaList     = null;
  JPanel jPanel1 = new JPanel();
  TitledBorder titledBorder1;
  TitledBorder titledBorder2;
  JPanel jPanel2 = new JPanel();
  TitledBorder titledBorder3;
  TitledBorder titledBorder4;
  GetBuyerMaker dlgMaker = new GetBuyerMaker(2);
  PopAndSelect2Text popMaker = new PopAndSelect2Text(dlgMaker, "BYMKR_SEQ", "BYMKR_BRIEF");
  JLabel jLabel2 = new JLabel();
  JLabel jLabel4 = new JLabel();
  JTextField tfRange = new JTextField();
  JComboBox cboSEA = new JComboBox();
  JTextField tfYear = new JTextField();
  JComboBox cboDIV = new JComboBox();
  JLabel jLabel6 = new JLabel();
  JLabel jLabel3 = new JLabel();
  JLabel jLabel5 = new JLabel();
  JLabel jLabel8 = new JLabel();
  JTextField tfListNO = new JTextField();
  JButton btnListNO = new JButton();
  JLabel jLabel1 = new JLabel();
  JLabel jLabel7 = new JLabel();
  JTextField tfLcNO = new JTextField();
  JButton btnLcNO = new JButton();
  JButton btnExtract = new JButton();


  public GmtLcSearch(GmtLcList _parent) {
    parent = _parent;
    try {
      jbInit();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }
  void jbInit() throws Exception {
    titledBorder1 = new TitledBorder("");
    titledBorder2 = new TitledBorder("");
    titledBorder3 = new TitledBorder("");
    titledBorder4 = new TitledBorder("");
    this.setBackground(new Color(204, 204, 225));
    this.setOpaque(true);
    this.setLayout(null);
    this.setSize(new Dimension(800, 136));
    jPanel1.setBackground(new Color(204, 204, 225));
    jPanel1.setBorder(titledBorder2);
    jPanel1.setBounds(new Rectangle(18, 5, 371, 123));
    jPanel1.setLayout(null);
    jPanel2.setBackground(new Color(204, 204, 225));
    jPanel2.setBorder(titledBorder4);
    jPanel2.setBounds(new Rectangle(395, 5, 371, 123));
    jPanel2.setLayout(null);
    popMaker.setBounds(new Rectangle(75, 9, 209, 20));
    jLabel2.setBounds(new Rectangle(10, 9, 56, 20));
    jLabel2.setText("FTY :");
    jLabel2.setForeground(new Color(10,36,106));
    jLabel2.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel4.setForeground(new Color(10,36,106));
    jLabel4.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel4.setText("Season :");
    jLabel4.setBounds(new Rectangle(10, 64, 56, 20));
    tfRange.setBounds(new Rectangle(293, 64, 67, 22));
    cboSEA.setBackground(Color.WHITE);
    cboSEA.setBounds(new Rectangle(75, 64, 161, 22));
    tfYear.setBounds(new Rectangle(293, 36, 67, 22));
    cboDIV.setBackground(Color.WHITE);
    cboDIV.setBounds(new Rectangle(75, 36, 161, 22));
    jLabel6.setForeground(new Color(10,36,106));
    jLabel6.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel6.setText("Range :");
    jLabel6.setBounds(new Rectangle(244, 64, 48, 20));
    jLabel3.setForeground(new Color(10,36,106));
    jLabel3.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel3.setText("Division :");
    jLabel3.setBounds(new Rectangle(10, 36, 56, 20));
    jLabel5.setForeground(new Color(10,36,106));
    jLabel5.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel5.setText("Year :");
    jLabel5.setBounds(new Rectangle(244, 36, 48, 20));
    jLabel8.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel8.setForeground(new Color(10,36,106));
    jLabel8.setToolTipText("");
    jLabel8.setText("or");
    jLabel8.setBounds(new Rectangle(9, 44, 47, 18));
    tfListNO.setBounds(new Rectangle(70, 11, 147, 25));
    tfListNO.setText("");
    btnListNO.setText("Search by LIST NO");
    btnListNO.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnListNO_actionPerformed(e);
      }
    });
    btnListNO.setForeground(Color.darkGray);
    btnListNO.setFont(new java.awt.Font("Dialog", 1, 12));
    btnListNO.setBounds(new Rectangle(219, 11, 139, 25));
    btnListNO.setBackground(Color.lightGray);
    jLabel1.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel1.setForeground(new Color(10,36,106));
    jLabel1.setText("List NO : ");
    jLabel1.setBounds(new Rectangle(9, 11, 52, 25));
    jLabel7.setBounds(new Rectangle(9, 68, 52, 25));
    jLabel7.setText("L/C NO: ");
    jLabel7.setForeground(new Color(10,36,106));
    jLabel7.setFont(new java.awt.Font("Dialog", 1, 12));
    tfLcNO.setBounds(new Rectangle(70, 69, 147, 25));
    btnLcNO.setText("Search by L/C NO");
    btnLcNO.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnLcNO_actionPerformed(e);
      }
    });
    btnLcNO.setForeground(Color.darkGray);
    btnLcNO.setFont(new java.awt.Font("Dialog", 1, 12));
    btnLcNO.setBounds(new Rectangle(219, 69, 139, 25));
    btnLcNO.setBackground(Color.lightGray);
    btnExtract.setBackground(Color.lightGray);
    btnExtract.setBounds(new Rectangle(75, 92, 80, 25));
    btnExtract.setFont(new java.awt.Font("Dialog", 1, 13));
    btnExtract.setForeground(Color.darkGray);
    btnExtract.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnExtract_actionPerformed(e);
      }
    });
    btnExtract.setText("Extract");
    jPanel1.add(btnExtract, null);
    jPanel1.add(popMaker, null);
    jPanel1.add(cboDIV, null);
    jPanel1.add(cboSEA, null);
    jPanel1.add(jLabel5, null);
    jPanel1.add(tfYear, null);
    jPanel1.add(jLabel6, null);
    jPanel1.add(tfRange, null);
    jPanel1.add(jLabel2, null);
    jPanel1.add(jLabel3, null);
    jPanel1.add(jLabel4, null);
    this.add(jPanel2, null);
    jPanel2.add(tfLcNO, null);
    jPanel2.add(btnLcNO, null);
    jPanel2.add(tfListNO, null);
    jPanel2.add(jLabel7, null);
    jPanel2.add(jLabel1, null);
    jPanel2.add(jLabel8, null);
    jPanel2.add(btnListNO, null);
    this.add(jPanel1, null);
    initAllComboBox();
  }

  void btnExtract_actionPerformed(ActionEvent e) {
    HashMap hm = setConds();
    query(hm);
  }

  void btnListNO_actionPerformed(ActionEvent e) {
    HashMap hm = setConds();
    hm.put("LIST_NO", tfListNO.getText().trim());
    query(hm);
  }

  void btnLcNO_actionPerformed(ActionEvent e) {
    HashMap hm = setConds();
    hm.put("LC_NO", tfLcNO.getText().trim());
    query(hm);
  }

  private void query(HashMap hm){
    System.out.println("Condition:"+hm);
    util.ApplicationProperites.setProperties("gmtLcSearchConds", hm);
    parent.refreshCurrQuery();
  }


  private void initAllComboBox(){
    try{
      HashMap hm = exgui2.CONST.Material_EJB.getAllSelctData();
      DivList    = (Vector)hm.get(MTR_EJB.DIVISION);
      SeaList    = exgui2.CONST.Material_EJB.getAllSeason();
      Util.setComboValues(cboSEA, SeaList, SEA_EJB.NAME, true);
      Util.setComboValues(cboDIV, DivList, DIV_EJB.NAME,true);
    }
    catch(Exception e){
      e.printStackTrace();
      util.ExceptionLog.exp2File(e, "error at MaterialSearch.initAllComboBox()");
    }
  }

  private HashMap setConds(){
    HashMap hm = new HashMap();
    try{
      Object obj = util.PublicVariable.USER_RECORD.get("USR_TYPE");
      String userType = (obj==null)?(""):((String)obj);
      if(userType.equals("2") || userType.equals("3") || userType.equals("4") ||
         userType.equals("5") || userType.equals("6")
        ){
        obj = util.PublicVariable.USER_RECORD.get("USR_CEN_CODE");
        String userCen = (obj==null)?(""):((String)obj);
        hm.put("CEN", userCen);
      }
      else{
        hm.put("CEN", "");
      }
      hm.put("FTY", popMaker.getText());
      hm.put("DIV", cboDIV.getSelectedItem());
      hm.put("SEASON", cboSEA.getSelectedItem());
      hm.put("YEAR", tfYear.getText().trim());
      hm.put("RANGE", tfRange.getText().trim());
    }
    catch(Exception exp){
      exp.printStackTrace();
    }
    finally{
      return hm;
    }
  }
}
