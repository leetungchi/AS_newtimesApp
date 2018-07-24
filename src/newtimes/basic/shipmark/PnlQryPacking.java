package newtimes.basic.shipmark;
import newtimes.*;
import java.awt.*;
import newtimes.*;
import javax.swing.*;
import java.awt.event.*;


public class PnlQryPacking
    extends JPanel{
 //extends ShipmarkSearch {
  static java.util.HashMap qryConditions;
  static int beginRowPos;
  public static PnlQryPacking me;
  JLabel jLabel4 = new JLabel();
  JTextField jTextField6 = new JTextField();
  JComboBox cmboCnty = new JComboBox();
  JLabel jLabel3 = new JLabel();
  JTextField jTextField3 = new JTextField();
  JTextField txtFullName = new JTextField();
  JTextField txtBrief = new JTextField();
  JLabel jLabel2 = new JLabel();
  JTextField txtChBrief = new JTextField();
  JTextField jTextField1 = new JTextField();
  JTextField jTextField5 = new JTextField();
  JTextField jTextField4 = new JTextField();
  JTextField txtCompany = new JTextField();
  JLabel jLabel5 = new JLabel();
  newtimes.Frame1 frame;
  exgui.DataBindJCombobox dbJCBXCnty = null;
  JButton btnQry = new JButton();
  JButton btnAddNew = new JButton();
  JButton btnExit = new JButton();
  JLabel lblTitle = new JLabel();
  public PnlQryPacking() {
    try{
      jbInit();
       frame=(newtimes.Frame1)util.PublicVariable.APP_FRAME;

    }catch(Exception e){
      e.printStackTrace();
    }
  }
  void setCmboShipmark() {
    java.util.Vector vDataCnty = null;
    try {
      vDataCnty = exgui2.CONST.BASIC_MAIN_EJB.getCountryAll("CNTY_NAME,CNTY_WEIGHT", "CNTY_NAME");
      database.datatype.Record rec = (database.datatype.Record) vDataCnty.get(0);
      dbJCBXCnty = new exgui.DataBindJCombobox(cmboCnty, vDataCnty, "CNTY_NAME",
                                           "CNTY_NAME", rec.get("CNTY_NAME"),"","null");
      cmboCnty.setSelectedIndex(0);
    } catch (Exception e) {
      e.printStackTrace();
      util.ExceptionLog.exp2File(e, "country data:"+vDataCnty.toString());
    }
  }

  void setMaxLength(){
    exgui.DataBindText tx = null;
    tx = new exgui.DataBindText(txtFullName,null,"",60);
    tx = new exgui.DataBindText(txtBrief,null,"",15);
    tx = new exgui.DataBindText(txtChBrief,null,"",8);
    tx = new exgui.DataBindText(txtCompany,null,"",15);
  }

  void butnExtract_actionPerformed(ActionEvent e) {
    java.util.HashMap hm = new java.util.HashMap();
    try {
      setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
      hm.put("CNTY_NAME",dbJCBXCnty.getSelectedValue());
      hm.put("BYMKR_BRIEF",txtBrief.getText().trim().equals("")?"null":txtBrief.getText());
      hm.put("BYMKR_NAME",txtFullName.getText().trim().equals("")?"null":txtFullName.getText());
      hm.put("BYMKR_CHINESE_BRIEF",txtChBrief.getText().trim().equals("")?"null":txtChBrief.getText());
      hm.put("BYMKR_MASTER_COMPANY",txtCompany.getText().trim().equals("")?"null":txtCompany.getText());
      hm.put("CNTY_NAME_ITEM",cmboCnty.getSelectedItem());
      qryConditions=hm;
      beginRowPos=1;
      PnlListPacking pnl=new PnlListPacking();
      //frame.showPanel(pnl);
      //this.removeAll();
      me=this;
      frame.contentPane.removeAll();
      frame.contentPane.add(pnl, null);
       pnl.setBounds(16, 82, 760, 406);
       pnl.repaint();
       pnl.validate();
       pnl.firstPage();
      //util.ApplicationProperites.setProperties("allData", hm);
      //frame.showPanel(new newtimes.basic.shipmark.ShipmarkList(frame));

    } catch (Exception eHm) {
      eHm.printStackTrace();
      util.ExceptionLog.exp2File(eHm, "error at HashMap."+hm.toString());
    } finally {
      setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
    }
  }

  void butnAdd_actionPerformed(ActionEvent e) {
    try{
      setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
      PnlPackingAdd pnl = new newtimes.basic.shipmark.PnlPackingAdd();
      DbPackingMark db = new DbPackingMark(new java.util.HashMap());

      database.datatype.Record rec = db.getBlankRecord();
      pnl.setHandlerAndRecord(db, rec);
      frame.showPanel(pnl);
      setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
    }catch(Exception exp){
      exp.printStackTrace();
      util.ExceptionLog.exp2File(exp,"");
    }
  }

  void butnExit_actionPerformed(ActionEvent e) {
    setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
    frame.showPanel(new newtimes.basic.MiscMenu(frame));
    setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
  }

  protected void jbInit() throws Exception {
    setBackground(new Color(204, 204, 225));
    jLabel5.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel5.setForeground(new Color(143, 143, 188));
    jLabel5.setText("(Input First Letter)");
    jLabel5.setBounds(new Rectangle(494, 236, 111, 23));
    txtCompany.setBounds(new Rectangle(334, 236, 155, 23));
    jTextField4.setBackground(new Color(143, 143, 188));
    jTextField4.setFont(new java.awt.Font("Dialog", 1, 12));
    jTextField4.setForeground(Color.white);
    jTextField4.setEditable(false);
    jTextField4.setBorder(null);
    jTextField4.setText(" Buyer Brief :");
    jTextField4.setBounds(new Rectangle(177, 173, 155, 23));
    jTextField5.setBackground(new Color(143, 143, 188));
    jTextField5.setFont(new java.awt.Font("Dialog", 1, 12));
    jTextField5.setForeground(new Color(10,36,106));
    jTextField5.setEditable(false);
    jTextField5.setBorder(null);
    jTextField5.setText(" Chinese Brief :");
    jTextField5.setBounds(new Rectangle(177, 205, 155, 23));
    jTextField1.setBounds(new Rectangle(177, 109, 155, 23));
    jTextField1.setText(" Country :");
    jTextField1.setEditable(false);
    jTextField1.setBorder(null);
    jTextField1.setForeground(new Color(10,36,106));
    jTextField1.setFont(new java.awt.Font("Dialog", 1, 12));
    jTextField1.setBackground(new Color(143, 143, 188));
    txtChBrief.setBounds(new Rectangle(334, 205, 155, 23));
    jLabel2.setBounds(new Rectangle(494, 141, 111, 23));
    jLabel2.setText("(Input First Letter)");
    jLabel2.setForeground(new Color(143, 143, 188));
    jLabel2.setFont(new java.awt.Font("Dialog", 1, 12));
    txtBrief.setBounds(new Rectangle(334, 173, 155, 23));
    txtFullName.setBounds(new Rectangle(334, 141, 155, 23));
    jTextField3.setBounds(new Rectangle(177, 141, 155, 23));
    jTextField3.setText(" Buyer Name :");
    jTextField3.setBorder(null);
    jTextField3.setForeground(new Color(10,36,106));
    jTextField3.setFont(new java.awt.Font("Dialog", 1, 12));
    jTextField3.setBackground(new Color(143, 143, 188));
    jLabel3.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel3.setForeground(new Color(143, 143, 188));
    jLabel3.setText("(Input First Letter)");
    jLabel3.setBounds(new Rectangle(494, 173, 111, 23));

    cmboCnty.setBounds(new Rectangle(334, 109, 271, 23));
    jTextField6.setBounds(new Rectangle(177, 236, 155, 23));
    jTextField6.setText(" Master Company :");
    jTextField6.setEditable(false);
    jTextField6.setBorder(null);
    jTextField6.setForeground(Color.white);
    jTextField6.setFont(new java.awt.Font("Dialog", 1, 12));
    jTextField6.setBackground(new Color(143, 143, 188));
    jLabel4.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel4.setForeground(new Color(143, 143, 188));
    jLabel4.setText("(Input First Letter)");
    jLabel4.setBounds(new Rectangle(494, 205, 111, 23));
    this.setLayout(null);
    btnQry.setBounds(new Rectangle(216, 415, 113, 25));
    btnQry.setText("EXTRACT");
    btnQry.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnQry_actionPerformed(e);
      }
    });
    btnAddNew.setBounds(new Rectangle(374, 415, 99, 27));
    btnAddNew.setText("ADD NEW");
    btnAddNew.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnAddNew_actionPerformed(e);
      }
    });
    btnExit.setBounds(new Rectangle(517, 415, 112, 26));
    btnExit.setText("EXIT");
    btnExit.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnExit_actionPerformed(e);
      }
    });
    lblTitle.setBackground(new Color(143, 143, 188));
    lblTitle.setFont(new java.awt.Font("Dialog", 1, 12));
    lblTitle.setForeground(new Color(10,36,106));
    lblTitle.setBorder(null);
    //lblTitle.setEditable(false);
    lblTitle.setText("Search For Packing Mark");
    lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
    lblTitle.setBounds(new Rectangle(1, 21, 800, 23));
    this.add(jLabel4, null);
    this.add(jTextField6, null);
    this.add(cmboCnty, null);
    this.add(jLabel3, null);
    this.add(jTextField3, null);
    this.add(txtFullName, null);
    this.add(txtBrief, null);
    this.add(jLabel2, null);
    this.add(txtChBrief, null);
    this.add(jTextField1, null);
    this.add(jTextField5, null);
    this.add(jTextField4, null);
    this.add(txtCompany, null);
    this.add(jLabel5, null);
    this.add(btnQry, null);
    this.add(btnAddNew, null);
    this.add(btnExit, null);
    this.add(lblTitle, null);
    setMaxLength();
    setCmboShipmark();
  }

  void btnQry_actionPerformed(ActionEvent e) {
    butnExtract_actionPerformed(null);
  }

  void btnAddNew_actionPerformed(ActionEvent e) {
    butnAdd_actionPerformed(null);
  }

  void btnExit_actionPerformed(ActionEvent e) {
     butnExit_actionPerformed(null);
  }

}
