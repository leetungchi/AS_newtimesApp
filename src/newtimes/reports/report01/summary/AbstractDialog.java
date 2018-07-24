package newtimes.reports.report01.summary;

import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;
import java.awt.event.*;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public abstract class AbstractDialog extends JDialog {
  private JPanel panel1 = new JPanel();
  private BorderLayout borderLayout1 = new BorderLayout();
  private JPanel jPanel1 = new JPanel();
  private JLabel jLabel1 = new JLabel();
  private BorderLayout borderLayout2 = new BorderLayout();
  private JScrollPane jScrollPane1 = new JScrollPane();
  private JList listSelected = new JList();
  private BorderLayout borderLayout4 = new BorderLayout();
  private JPanel jPanel4 = new JPanel();
  private JButton butnApply = new JButton();
  private JButton butnExit = new JButton();
  private JScrollPane jScrollPane2 = new JScrollPane();
  private JScrollPane jScrollPane3 = new JScrollPane();
  private JSplitPane jSplitPane1 = new JSplitPane();
  private JPanel jPanel3 = new JPanel();
  private JList listData = new JList();
  private JList listLetter = new JList();
  private java.util.Vector getItems = new java.util.Vector();
  private JLabel jLabel2 = new JLabel();
  private java.util.Vector vSelected = new java.util.Vector();
  private boolean isExit = false;

  public AbstractDialog(Frame frame, String title, boolean modal) {
    super(frame, title, modal);
    try {
      jbInit();
      pack();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }

  public AbstractDialog() {
    this(null, "", false);
  }
  private void jbInit() throws Exception {
    this.setLocation(this.setLocation_X(), this.setLocation_Y());
    panel1.setLayout(borderLayout1);
    jLabel1.setText(" Already Selected (Double Click to Un-Select) :");
    jPanel1.setLayout(borderLayout2);
    jPanel3.setLayout(borderLayout4);
    //butnApply.setEnabled(false);
    butnApply.setText("Apply");
    butnApply.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        butnApply_actionPerformed(e);
      }
    });
    butnExit.setText("Exit");
    butnExit.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        butnExit_actionPerformed(e);
      }
    });
    jSplitPane1.setContinuousLayout(true);
    listData.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(MouseEvent e) {
        listData_mouseClicked(e);
      }
    });
    listSelected.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(MouseEvent e) {
        listSelected_mouseClicked(e);
      }
    });
    listSelected.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    listData.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    jLabel2.setText(" Double Click to Select Datas :");
    getContentPane().add(panel1);
    panel1.add(jPanel1,  BorderLayout.NORTH);
    jPanel1.add(jLabel1, BorderLayout.NORTH);
    jPanel1.add(jScrollPane1, BorderLayout.CENTER);
    jPanel1.add(jLabel2,  BorderLayout.SOUTH);
    jScrollPane1.getViewport().add(listSelected, null);
    panel1.add(jPanel3,  BorderLayout.CENTER);
    jPanel3.add(jPanel4,  BorderLayout.SOUTH);
    jPanel4.add(butnApply, null);
    jPanel4.add(butnExit, null);
    jPanel3.add(jSplitPane1,  BorderLayout.CENTER);
    jSplitPane1.add(jScrollPane2, JSplitPane.LEFT);
    jScrollPane2.getViewport().add(listLetter, null);
    jSplitPane1.add(jScrollPane3, JSplitPane.RIGHT);
    jScrollPane3.getViewport().add(listData, null);
    if (this.setShowListData() != null) {
      this.setListData();
    } else {
      this.setFirstLetter();
    }
  }

  private void setFirstLetter() {
    try {
      java.util.Vector v = new java.util.Vector();
      listLetter.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
        public void valueChanged(ListSelectionEvent e) {
          listLetter_valueChanged(e);
        }
      });
      v.add("All");
      for (int i = 0; i < 10; i++) {
        v.add(new Integer(i));
      }
      for (char j = 'A'; j <= 'Z'; j++ ) {
        v.add(new Character(j));
      }
      listLetter.setListData(v);
    } catch(Exception e) {
      e.printStackTrace();
    }
  }

  private void setListData() {
    this.setShowListData();
  }

  private void listLetter_valueChanged(ListSelectionEvent e) {
    this.setShowingData();
  }

  private void butnExit_actionPerformed(ActionEvent e) {
    setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
    isExit = true;
    this.dispose();
    setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
  }

  private void butnApply_actionPerformed(ActionEvent e) {
    isExit = false;
    this.actionApply();
  }

  private void listData_mouseClicked(MouseEvent e) {
    if (e.getClickCount() == 2) {
      getItems.add(listData.getSelectedValue());
      vSelected.add(listData.getSelectedValue());
      listSelected.setListData(getItems);
    }
  }

  private void listSelected_mouseClicked(MouseEvent e) {
    if (e.getClickCount() == 2) {
      if (listSelected.getSelectedIndex() > -1) {
        getItems.remove(listSelected.getSelectedIndex());
        vSelected.removeElementAt(listSelected.getSelectedIndex());
        listSelected.setListData(getItems);
      }
    }
  }

  protected java.util.Vector getSelectedName() {
    return vSelected;
  }

  protected void removeListLetter() {
    jPanel3.removeAll();
    panel1.add(jPanel3, BorderLayout.CENTER);
    jPanel3.add(jScrollPane3, BorderLayout.CENTER);
    jPanel3.add(jPanel4,  BorderLayout.SOUTH);
    jPanel4.add(butnApply, null);
    jPanel4.add(butnExit, null);
    jScrollPane3.getViewport().add(listData, null);
    jPanel3.validate();
  }

  protected JList getListLetter() {
    return listLetter;
  }

  protected JList getListData() {
    return listData;
  }

  protected JList getListSelected() {
    return listSelected;
  }

  protected boolean isExit() {
    return isExit;
  }

  public abstract java.util.Vector setShowingData();
  public abstract exgui.DataBindJList setShowListData();
  public abstract void actionApply();
  public abstract int setLocation_X();
  public abstract int setLocation_Y();
  public abstract boolean setIsExit();
}