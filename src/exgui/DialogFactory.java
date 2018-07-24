package exgui;

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

public abstract class DialogFactory extends JDialog {
  private JPanel panel1 = new JPanel();
  private JTextField jTextField27 = new JTextField();
  private JComboBox firstLetterJCB = new JComboBox();
  private JTextField jTextField28 = new JTextField();
  private JButton butnSelect = new JButton();
  private JButton butnExit = new JButton();
  private java.util.Vector vFirstLetter = new java.util.Vector();
  private JScrollPane jScrollPane1 = new JScrollPane();
  private JList listItems = new JList();
  private GridBagLayout gridBagLayout1 = new GridBagLayout();
  private database.datatype.Record recDB = null;
  private java.util.Vector vCode = new java.util.Vector();
  protected static Object _getSelectCode = null;
  private int _count = 0;
  /**
   * Provides first letter by JComboBox selected.
   */
  public Object getFirstLetter = null;

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
    this.setTitle("Select Item :");
    this.setModal(true);
    panel1.setLayout(null);
    panel1.setBackground(new Color(204, 204, 225));
    jTextField27.setText(" Select First Letter  :");
    jTextField27.setBounds(new Rectangle(16, 22, 118, 23));
    jTextField27.setBorder(null);
    jTextField27.setEditable(false);
    jTextField27.setForeground(new Color(10,36,106));
    jTextField27.setFont(new java.awt.Font("Dialog", 1, 12));
    jTextField27.setBackground(new Color(143, 143, 188));
    firstLetterJCB.setBackground(Color.white);
    firstLetterJCB.setEnabled(true);
    firstLetterJCB.setBorder(BorderFactory.createEtchedBorder());
    firstLetterJCB.setEditable(false);
    firstLetterJCB.setBounds(new Rectangle(136, 22, 49, 23));
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
    jTextField28.setBounds(new Rectangle(16, 55, 118, 136));
    butnSelect.setBackground(Color.lightGray);
    butnSelect.setBounds(new Rectangle(99, 211, 76, 25));
    butnSelect.setFont(new java.awt.Font("Dialog", 1, 12));
    butnSelect.setBorder(BorderFactory.createEtchedBorder());
    butnSelect.setText("Select");
    butnSelect.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        butnSelect_actionPerformed(e);
      }
    });
    butnExit.setBackground(Color.lightGray);
    butnExit.setBounds(new Rectangle(198, 211, 76, 25));
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
    jScrollPane1.setBounds(new Rectangle(136, 55, 228, 136));
    listItems.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    getContentPane().add(panel1,  new GridBagConstraints(0, 0, 1, 1, 1.0, 1.0
            ,GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 381, 262));
    panel1.add(firstLetterJCB, null);
    panel1.add(jTextField27, null);
    panel1.add(jTextField28, null);
    panel1.add(jScrollPane1, null);
    jScrollPane1.getViewport().add(listItems, null);
    panel1.add(butnExit, null);
    panel1.add(butnSelect, null);
    this.setFirstLetterJCB();
  }

  /**
   * Creates first letters, default values : 0~1,A~Z.  If specifics requirement
   * that will be overwrite it.
   */
  public void setFirstLetterJCB() {
    try {
      firstLetterJCB.addItem("---");
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
    this.dispose();
  }

  void firstLetterJCB_itemStateChanged(ItemEvent e) {
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
          if (exgui.PopAndSelect2Text._showField != null &&
              exgui.PopAndSelect2Text._pkField != null) {
            vBrief.add(recDB.get(exgui.PopAndSelect2Text._showField));
            vCode.add(recDB.get(exgui.PopAndSelect2Text._pkField));
          }
        }
        listItems.setListData(vBrief);
      } catch (Exception ex) {
        ex.printStackTrace();
      }
    }
  }

  void butnSelect_actionPerformed(ActionEvent e) {
    try {
      if (listItems.getSelectedValue() != null) {
        exgui.PopAndSelect2Text.setSelectedItem = listItems.getSelectedValue();
        this._getSelectCode = vCode.get(listItems.getSelectedIndex());
      }
    } catch (Exception eSel) {
      eSel.printStackTrace();
    } finally {
      this.dispose();
    }
  }

  /**
   * Implements setDB2ListItems().  This method will able to accessing and
   * processing database.
   * @return java.util.Vector
   */
  public abstract java.util.Vector setDB2ListItems();
}
