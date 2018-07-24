package newtimes.reports.report01.pps;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class PpsListGUI extends JPanel {
  static PpsTableEditor tableEditor = null;
  static java.util.Vector vStySeq = new java.util.Vector();
  static java.util.Vector vPool = new java.util.Vector();
  static java.util.Vector vec = new java.util.Vector();
  static int rowStartAt = 0;
  static String USR_NAME = null;

  public PpsListGUI(PpsTableEditor _tableEditor) {
    try {
      USR_NAME = util.PublicVariable.USER_RECORD.get("USR_CODE").toString();
      this.tableEditor = _tableEditor;
      jbInit();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }
  void jbInit() throws Exception {
    if (tableEditor != null) {
      tableEditor.getJtable().addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseReleased(MouseEvent e) {
          jTable_mouseReleased(e);
        }
      });
    }

    this.setLayout(null);
    this.setSize(800,600);
    this.setBackground(new Color(204, 204, 225));
    tableEditor.setBounds(new Rectangle(10, 10, 770, 470));
    this.add(tableEditor, null);
  }

  void jTable_mouseReleased(MouseEvent e) {
    java.util.Vector vDetail = null;
    try {
      tableEditor.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
      int getRow = tableEditor.getJtable().getSelectedRow();
      vDetail = tableEditor.getDisplayingRecords();
      database.datatype.Record recDetail = (database.datatype.Record) vDetail.get(getRow);
      Object isCheck = tableEditor.getJtable().getValueAt(getRow, 0);
      int currentStartRow = tableEditor.getCurrentRowStartAtPosition();
      if (isCheck.toString().equals("true")) {
        vStySeq.add(recDetail.get("STY_SEQ"));
        vPool.add(currentStartRow+"|"+getRow);
      } else if (isCheck.toString().equals("false")) {
        vStySeq.remove(recDetail.get("STY_SEQ"));
        vPool.remove(currentStartRow+"|"+getRow);
      }
    } catch (Exception eRow) {
      eRow.printStackTrace();
      util.ExceptionLog.exp2File(eRow, "error at get record." + vStySeq.toString());
    } finally {
      tableEditor.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
    }
  }

  static void setCheckRecord2JTable(int _rowStartAt) {
    try {
      rowStartAt = _rowStartAt;
      for (int i = 0; i < vPool.size(); i++) {
        vec = (exgui2.Stuff.splitString(vPool.get(i).toString(), "|"));
        if (String.valueOf(_rowStartAt).equals(vec.get(0).toString())) {
          tableEditor.getJtable().setValueAt(
                new Boolean(true), Integer.parseInt(vec.get(1).toString()), 0);
        }
      }
    } catch (Exception ex) {
      ex.printStackTrace();
    }
  }
}
