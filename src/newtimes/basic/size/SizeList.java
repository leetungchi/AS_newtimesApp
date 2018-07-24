package newtimes.basic.size;

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

public class SizeList extends JPanel {
  Frame1 frame;
  private JLabel textAreaStatus = new JLabel();
  private JButton butnExit = new JButton();
  private JButton butnAdd = new JButton();
  private JLabel jLabel1 = new JLabel();
  private SizeAbsTable sizeAbsTable = new SizeAbsTable();
  private JTable jTable = sizeAbsTable.getJtable();

  public SizeList(Frame1 _frame) {
    frame = _frame;
    try {
      jbInit();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }
  void jbInit() throws Exception {
    if (SizeEdit.isExit) {
      int _rowCounts = Integer.parseInt(util.ApplicationProperites.getProperties("_rowCounts").toString());
      int _rowPosition = Integer.parseInt(util.ApplicationProperites.getProperties("_rowPosition").toString());
      sizeAbsTable.goPage(_rowPosition,_rowCounts,true);
      /*
      int skip = Math.abs(_rowPosition/_rowCounts);
      for (int i = 0; i < skip; i++) {
        sizeAbsTable.nextPage();
      }*/
    }

    butnAdd.setBackground(Color.lightGray);
    butnAdd.setBounds(new Rectangle(302, 506, 91, 25));
    butnAdd.setFont(new java.awt.Font("Dialog", 1, 13));
    butnAdd.setForeground(Color.darkGray);
    butnAdd.setText("Add New");
    butnAdd.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        butnAdd_actionPerformed(e);
      }
    });
    butnExit.setBackground(Color.lightGray);
    butnExit.setBounds(new Rectangle(417, 506, 80, 25));
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
    textAreaStatus.setBounds(new Rectangle(0, 540, 800, 30));
    textAreaStatus.setOpaque(true);
    textAreaStatus.setBorder(null);
    textAreaStatus.setBackground(new Color(143, 143, 188));
    this.setLayout(null);
    this.setSize(800,600);
    this.setBackground(new Color(204, 204, 225));
    jLabel1.setFont(new java.awt.Font("Dialog", 1, 13));
    jLabel1.setForeground(new Color(10,36,106));
    jLabel1.setBorder(BorderFactory.createEtchedBorder());
    jLabel1.setHorizontalAlignment(SwingConstants.CENTER);
    jLabel1.setText("      ============  Size List  ============      ");
    jLabel1.setBounds(new Rectangle(117, 26, 566, 24));
    sizeAbsTable.setBounds(new Rectangle(16, 82, 760, 406));
    this.add(textAreaStatus, null);
    this.add(jLabel1, null);
    this.add(sizeAbsTable, null);
    this.add(butnExit, null);
    this.add(butnAdd, null);
  }

  void butnExit_actionPerformed(ActionEvent e) {
    setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
    SizeEdit.isExit = false;
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
      sizeAbsTable.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
      util.ApplicationProperites.setProperties("_rowCounts", new Integer(sizeAbsTable._rowCounts));
      util.ApplicationProperites.setProperties("_rowPosition", new Integer(sizeAbsTable._rowPosition));
      int getRow = jTable.getSelectedRow();
      java.util.Vector vDetail = sizeAbsTable.getDisplayingRecords();
      database.datatype.Record recDetail = (database.datatype.Record) vDetail.get(getRow);
      hm.put("recDetail", recDetail);
      util.ApplicationProperites.setProperties("recDetail", hm);
      frame.showPanel(new newtimes.basic.size.SizeEdit(frame));
    } catch (Exception eRow) {
      eRow.printStackTrace();
      util.ExceptionLog.exp2File(eRow, "error at get record." + hm.toString());
    } finally {
      sizeAbsTable.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
    }
  }

  void butnAdd_actionPerformed(ActionEvent e) {
    setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
    frame.showPanel(new newtimes.basic.size.SizeAdd(frame));
    setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
  }
}
