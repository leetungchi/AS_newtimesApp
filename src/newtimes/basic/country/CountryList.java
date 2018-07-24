package newtimes.basic.country;

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

public class CountryList extends JPanel {
  Frame1 frame;
  private JButton butnAdd = new JButton();
  private JButton butnExit = new JButton();
  private JLabel textAreaStatus = new JLabel();
  private JLabel jLabel1 = new JLabel();
  private CountryAbsTable countryAbsTable = new CountryAbsTable();
  private JTable jTable = countryAbsTable.getJtable();

  public CountryList(Frame1 _frame) {
    frame = _frame;
    try {
      jbInit();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }
  void jbInit() throws Exception {
    if (CountryEdit.isExit) {
      int _rowCounts = Integer.parseInt(util.ApplicationProperites.getProperties("_rowCounts").toString());
      int _rowPosition = Integer.parseInt(util.ApplicationProperites.getProperties("_rowPosition").toString());
      countryAbsTable.goPage(_rowPosition,_rowCounts,true);
      /*int skip = Math.abs(_rowPosition/_rowCounts);
      for (int i = 0; i < skip; i++) {
        countryAbsTable.nextPage();
      }*/
    }

    butnAdd.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        butnAdd_actionPerformed(e);
      }
    });
    butnAdd.setText("Add New");
    butnAdd.setForeground(Color.darkGray);
    butnAdd.setFont(new java.awt.Font("Dialog", 1, 13));
    butnAdd.setBounds(new Rectangle(285, 503, 92, 25));
    butnAdd.setBackground(Color.lightGray);
    this.setLayout(null);
    this.setSize(800,600);
    this.setBackground(new Color(204, 204, 225));
    butnExit.setBackground(Color.lightGray);
    butnExit.setBounds(new Rectangle(390, 503, 80, 25));
    butnExit.setFont(new java.awt.Font("Dialog", 1, 13));
    butnExit.setForeground(Color.darkGray);
    butnExit.setText("Exit");
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
    textAreaStatus.setBackground(new Color(143, 143, 188));
    textAreaStatus.setBorder(null);
    textAreaStatus.setOpaque(true);
    textAreaStatus.setBounds(new Rectangle(0, 540, 800, 30));
    jLabel1.setFont(new java.awt.Font("Dialog", 1, 13));
    jLabel1.setForeground(new Color(10,36,106));
    jLabel1.setBorder(BorderFactory.createEtchedBorder());
    jLabel1.setHorizontalAlignment(SwingConstants.CENTER);
    jLabel1.setText("      ============  Country List  ============      ");
    jLabel1.setBounds(new Rectangle(117, 26, 566, 24));
    countryAbsTable.setBounds(new Rectangle(16, 82, 760, 406));
    this.add(textAreaStatus, null);
    this.add(jLabel1, null);
    this.add(butnAdd, null);
    this.add(butnExit, null);
    this.add(countryAbsTable, null);
  }

  void butnAdd_actionPerformed(ActionEvent e) {
    setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
    frame.showPanel(new newtimes.basic.country.CountryAdd(frame));
    setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
  }

  void butnExit_actionPerformed(ActionEvent e) {
    setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
    CountryEdit.isExit = false;
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
      countryAbsTable.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
      util.ApplicationProperites.setProperties("_rowCounts", new Integer(countryAbsTable._rowCounts));
      util.ApplicationProperites.setProperties("_rowPosition", new Integer(countryAbsTable._rowPosition));
      int getRow = jTable.getSelectedRow();
      java.util.Vector vDetail = countryAbsTable.getDisplayingRecords();
      database.datatype.Record recDetail = (database.datatype.Record) vDetail.get(getRow);
      hm.put("recDetail", recDetail);
      util.ApplicationProperites.setProperties("recDetail", hm);
      frame.showPanel(new newtimes.basic.country.CountryEdit(frame));
    } catch (Exception eRow) {
      eRow.printStackTrace();
      util.ExceptionLog.exp2File(eRow, "error at get record." + hm.toString());
    } finally {
      countryAbsTable.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
    }
  }
}
