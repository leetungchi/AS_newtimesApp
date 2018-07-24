package exgui2;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

/**
 * <p>Title: DialogFactory</p>
 * <p>Description: The DialogFactory extends JDialog to produce by PopSelect
 *                 component that provides accessing and processing database
 *                 when you select first letter by JCompoBox.  This component
 *                 is abstract class, so must implments setDB2ListItems() method.</p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author Chloe.H
 * @version 1.0
 */

/**
   * Definition values for buyer maker type.
   *
   *  Values    Buyer Maker Type
   * ===========================
   *     1      Buyer
   *     2      Maker
   *     3      Fabric Mill
   *     4      Wash Mill
   *     5      Sewing Shop
   *     6      Licensee
   *     7      Shipping
   *     8      Others
   * ===========================
   */
public abstract class DialogFactory extends JDialog {
  protected JPanel panel1 = new JPanel();
  protected JTextField jTextField27 = new JTextField();
  protected JComboBox firstLetterJCB = new JComboBox();
  protected JTextField jTextField28 = new JTextField();
  protected JButton butnSelect = new JButton();
  protected JButton butnExit = new JButton();
  protected java.util.Vector vFirstLetter = new java.util.Vector();
  protected JScrollPane jScrollPane1 = new JScrollPane();
  protected JList listItems = new JList();
  protected GridBagLayout gridBagLayout1 = new GridBagLayout();
  protected database.datatype.Record recDB = null;
  protected java.util.Vector vCode = new java.util.Vector();
  protected static Object _getSelectedBuyerValue = null;
  protected static Object _getSelectedMakerValue = null;
  protected static Object _getSelectedFabricMillValue = null;
  protected static Object _getSelectedWashMillValue = null;
  protected static Object _getSelectedSewingShopValue = null;
  protected static Object _getSelectedLicenseeValue = null;
  protected static Object _getSelectedShippingValue = null;
  protected static Object _getSelectedOthersValue = null;
  protected static int type = 1;
  protected int _count = 0;
  /**
   * Provides first letter by JComboBox selected.
   */
  public Object getFirstLetter = null;
  JTextField jTextField29 = new JTextField();
  JTextField txt1stTwnChar = new JTextField();
  JButton btnSearch = new JButton();

  /**
   * Creates a DialogFactory.
   * @param frame
   */
  protected DialogFactory(Frame frame) {
    super(frame);
    try {
      jbInit();
      pack();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }

  /**
   * Creates a DialogFactory.
   */
  protected DialogFactory() {
    this(null);
  }

  private void jbInit() throws Exception {
    this.setLocation(300, 250);
    this.setTitle("Select Item :");
    this.setModal(true);
    panel1.setLayout(null);
    panel1.setBackground(new Color(204, 204, 225));
    jTextField27.setText(" Select First Letter  :");
    jTextField27.setBounds(new Rectangle(17, 45, 118, 23));
    jTextField27.setBorder(null);
    jTextField27.setEditable(false);
    jTextField27.setForeground(new Color(10,36,106));
    jTextField27.setFont(new java.awt.Font("Dialog", 1, 12));
    jTextField27.setBackground(new Color(143, 143, 188));
    firstLetterJCB.setBackground(Color.white);
    firstLetterJCB.setEnabled(true);
    firstLetterJCB.setBorder(BorderFactory.createEtchedBorder());
    firstLetterJCB.setEditable(false);
    firstLetterJCB.setBounds(new Rectangle(138, 45, 49, 23));
    firstLetterJCB.addItemListener(new java.awt.event.ItemListener() {
      public void itemStateChanged(ItemEvent e) {
        firstLetterJCB_itemStateChanged(e);
      }
    });
    jTextField28.setBackground(new Color(143, 143, 188));
    jTextField28.setFont(new java.awt.Font("Dialog", 1, 12));
    jTextField28.setForeground(Color.white);
    jTextField28.setEditable(false);
    jTextField28.setBorder(null);
    jTextField28.setText(" Selected Result  :");
    jTextField28.setBounds(new Rectangle(17, 78, 118, 136));
    butnSelect.setBackground(Color.lightGray);
    butnSelect.setBounds(new Rectangle(101, 234, 76, 25));
    butnSelect.setFont(new java.awt.Font("Dialog", 1, 12));
    butnSelect.setBorder(BorderFactory.createEtchedBorder());
    butnSelect.setText("Select");
    butnSelect.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        butnSelect_actionPerformed(e);
      }
    });
    butnExit.setBackground(Color.lightGray);
    butnExit.setBounds(new Rectangle(200, 234, 76, 25));
    butnExit.setFont(new java.awt.Font("Dialog", 1, 12));
    butnExit.setBorder(BorderFactory.createEtchedBorder());
    butnExit.setText("Exit");
    butnExit.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        butnExit_actionPerformed(e);
      }
    });
    this.getContentPane().setLayout(gridBagLayout1);
    jScrollPane1.setBorder(BorderFactory.createEtchedBorder());
    jScrollPane1.setBounds(new Rectangle(138, 78, 228, 136));
    listItems.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    jTextField29.setBackground(new Color(143, 143, 188));
    jTextField29.setFont(new java.awt.Font("Dialog", 1, 12));
    jTextField29.setForeground(new Color(10,36,106));
    jTextField29.setEditable(false);
    jTextField29.setBorder(null);
    jTextField29.setBounds(new Rectangle(17, 19, 117, 21));
    jTextField29.setText("中文起始字:");
    txt1stTwnChar.setBounds(new Rectangle(137, 19, 45, 21));
    btnSearch.setBounds(new Rectangle(187, 19, 88, 23));
    btnSearch.setText("查詢");
    btnSearch.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnSearch_actionPerformed(e);
      }
    });
    getContentPane().add(panel1,  new GridBagConstraints(0, 0, 1, 1, 1.0, 1.0
            ,GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 381, 262));
    panel1.add(jTextField28, null);
    panel1.add(jTextField29, null);
    panel1.add(txt1stTwnChar, null);
    panel1.add(btnSearch, null);
    panel1.add(jTextField27, null);
    panel1.add(firstLetterJCB, null);
    panel1.add(jScrollPane1, null);
    panel1.add(butnSelect, null);
    panel1.add(butnExit, null);
    jScrollPane1.getViewport().add(listItems, null);
    this.setFirstLetterJCB();
    exgui.DataBindText atext=
        new exgui.DataBindText(txt1stTwnChar,null,null,1);
  }

  /**
   * Creates first letters, default values : 0~1,A~Z.  If specifics requirement
   * that will be overwrite it.
   */
  public void setFirstLetterJCB() {
    try {
      firstLetterJCB.addItem("---");
      firstLetterJCB.addItem("All");
      for (int i = 0; i < 10; i++) {
        firstLetterJCB.addItem(new Integer(i));
      }
      for (char j = 'A'; j <= 'Z'; j++ ) {
        firstLetterJCB.addItem(new Character(j));
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  void butnExit_actionPerformed(ActionEvent e) {
    setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
    exgui2.PopAndSelect2Text.isExit = true;
    this.dispose();
    setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
  }

  void firstLetterJCB_itemStateChanged(ItemEvent e) {
    txt1stTwnChar.setText("");
    setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
    this._count++;
    this.getFirstLetter = firstLetterJCB.getSelectedItem();
    if (!this.getFirstLetter.equals("---") && this._count == 2) {
      this._count = 0;
      java.util.Vector vDB = this.setDB2ListItems();
      java.util.Vector vBrief = new java.util.Vector();
      try {
        vCode.clear();
        listItems.removeAll();
        for (int i = 0; i < vDB.size(); i++) {
          recDB = (database.datatype.Record)vDB.get(i);
          if (exgui2.PopAndSelect2Text._showField != null &&
              exgui2.PopAndSelect2Text._pkField != null) {
            vBrief.add(recDB.get(exgui2.PopAndSelect2Text._showField));
            vCode.add(recDB.get(exgui2.PopAndSelect2Text._pkField));
          }
        }
        listItems.setListData(vBrief);
      } catch (Exception ex) {
        ex.printStackTrace();
      }
    }
    setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
  }

  void butnSelect_actionPerformed(ActionEvent e) {
    try {
      setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
      if (listItems.getSelectedValue() != null) {
        exgui2.PopAndSelect2Text.setSelectedItem = listItems.getSelectedValue();
        switch(setBuyerMakerType()){
          case 1:
            _getSelectedBuyerValue = vCode.get(listItems.getSelectedIndex());
            break;
          case 2:
            _getSelectedMakerValue = vCode.get(listItems.getSelectedIndex());
            break;
          case 3:
            _getSelectedFabricMillValue = vCode.get(listItems.getSelectedIndex());
            break;
          case 4:
            _getSelectedWashMillValue = vCode.get(listItems.getSelectedIndex());
            break;
          case 5:
            _getSelectedSewingShopValue = vCode.get(listItems.getSelectedIndex());
            break;
          case 6:
            _getSelectedLicenseeValue = vCode.get(listItems.getSelectedIndex());
            break;
          case 7:
            _getSelectedShippingValue = vCode.get(listItems.getSelectedIndex());
            break;
          case 8:
            _getSelectedOthersValue = vCode.get(listItems.getSelectedIndex());
            break;
          case 23:
            _getSelectedFabricMillValue = vCode.get(listItems.getSelectedIndex());
        }
      }
    } catch (Exception eSel) {
      eSel.printStackTrace();
    } finally {
      this.dispose();
      setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
    }
  }

  /**
   * Implements setDB2ListItems().  This method will able to accessing and
   * processing database.
   * @return java.util.Vector
   */
  public abstract java.util.Vector setDB2ListItems();
  public abstract int setBuyerMakerType();

  protected void btnSearch_actionPerformed(ActionEvent e) {
  }
}
