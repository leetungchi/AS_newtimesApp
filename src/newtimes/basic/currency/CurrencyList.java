package newtimes.basic.currency;

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

public class CurrencyList extends JPanel {
  Frame1 frame;
  private JLabel textAreaStatus = new JLabel();
  private JButton butnExit = new JButton();
  private JButton butnAdd = new JButton();
  private JLabel jLabel1 = new JLabel();
  private CurrencyAbsTable crncyAbsTable = new CurrencyAbsTable();
  private JTable jTable = crncyAbsTable.getJtable();

  public CurrencyList(Frame1 _frame) {
    frame = _frame;
    try {
      jbInit();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }
  void jbInit() throws Exception {
    if (CurrencyEdit.isExit) {
      int _rowCounts = Integer.parseInt(util.ApplicationProperites.getProperties("_rowCounts").toString());
      int _rowPosition = Integer.parseInt(util.ApplicationProperites.getProperties("_rowPosition").toString());
      crncyAbsTable.goPage(_rowPosition,_rowCounts,true);
      /*int skip = Math.abs(_rowPosition/_rowCounts);
      for (int i = 0; i < skip; i++) {
        crncyAbsTable.nextPage();
      }*/
    }

    butnAdd.setText("Add New");
    butnAdd.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        butnAdd_actionPerformed(e);
      }
    });
    butnAdd.setForeground(Color.darkGray);
    butnAdd.setFont(new java.awt.Font("Dialog", 1, 13));
    butnAdd.setBounds(new Rectangle(289, 506, 92, 25));
    butnAdd.setBackground(Color.lightGray);
    butnExit.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        butnExit_actionPerformed(e);
      }
    });
    jTable.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseReleased(MouseEvent e) {
        jTable_mouseReleased(e);
      }
    });
    butnExit.setText("Exit");
    butnExit.setForeground(Color.darkGray);
    butnExit.setFont(new java.awt.Font("Dialog", 1, 13));
    butnExit.setBounds(new Rectangle(400, 506, 80, 25));
    butnExit.setBackground(Color.lightGray);
    textAreaStatus.setBackground(new Color(143, 143, 188));
    textAreaStatus.setBorder(null);
    textAreaStatus.setOpaque(true);
    textAreaStatus.setBounds(new Rectangle(0, 540, 800, 30));
    this.setLayout(null);
    this.setSize(800,600);
    this.setBackground(new Color(204, 204, 225));
    jLabel1.setFont(new java.awt.Font("Dialog", 1, 13));
    jLabel1.setForeground(new Color(10,36,106));
    jLabel1.setBorder(BorderFactory.createEtchedBorder());
    jLabel1.setHorizontalAlignment(SwingConstants.CENTER);
    jLabel1.setText("      ============  Currency List  ============      ");
    jLabel1.setBounds(new Rectangle(117, 26, 566, 24));
    crncyAbsTable.setBounds(new Rectangle(16, 82, 760, 406));
    this.add(textAreaStatus, null);
    this.add(jLabel1, null);
    this.add(butnAdd, null);
    this.add(butnExit, null);
    this.add(crncyAbsTable, null);
  }

  void butnExit_actionPerformed(ActionEvent e) {
    setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
    CurrencyEdit.isExit = false;
    util.ApplicationProperites.removeProperites("_rowCounts");
    util.ApplicationProperites.removeProperites("_rowPosition");

    util.ApplicationProperites.removeProperites("allData");
    util.ApplicationProperites.removeProperites("recDetail");
    frame.showPanel(new newtimes.basic.BasicMenu(frame));
    setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
  }

  void jTable_mouseReleased(MouseEvent e) {
    java.util.HashMap hm = new java.util.HashMap();
    try {
      crncyAbsTable.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
      util.ApplicationProperites.setProperties("_rowCounts", new Integer(crncyAbsTable._rowCounts));
      util.ApplicationProperites.setProperties("_rowPosition", new Integer(crncyAbsTable._rowPosition));
      int getRow = jTable.getSelectedRow();
      java.util.Vector vDetail = crncyAbsTable.getDisplayingRecords();
      database.datatype.Record recDetail = (database.datatype.Record) vDetail.get(getRow);
      hm.put("recDetail", recDetail);
      util.ApplicationProperites.setProperties("recDetail", hm);
      frame.showPanel(new newtimes.basic.currency.CurrencyEdit(frame));
    } catch (Exception eRow) {
      eRow.printStackTrace();
      util.ExceptionLog.exp2File(eRow, "error at get record." + hm.toString());
    } finally {
      crncyAbsTable.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
    }
  }

  void butnAdd_actionPerformed(ActionEvent e) {
    setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
    frame.showPanel(new newtimes.basic.currency.CurrencyAdd(frame));
    setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
  }
}
