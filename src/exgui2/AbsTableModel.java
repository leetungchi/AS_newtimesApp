package exgui2;

import javax.swing.table.*;


/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author unascribed
 * @version 1.0
 */

public class AbsTableModel extends AbstractTableModel {
  private Object[][] data = null;
  private String[] head = null;

  public AbsTableModel(Object[][] data, String[] head) {
    this.data = data;
    this.head = head;
  }

  public int getColumnCount() {
    return head.length;
  }

  public Object getValueAt(int rowIndex, int columnIndex) {
    return data[rowIndex][columnIndex];
  }

  public int getRowCount() {
    return data.length;
  }

  public Class getColumnClass(int c) {
    return getValueAt(0, c).getClass();
  }

  public String getColumnName(int col) {
    return head[col];
  }

  public boolean isCellEditable(int rowIndex, int columnIndex) {
    return true;
  }

  public void setValueAt(Object value, int row, int column) {
    data[row][column] = value;
    fireTableCellUpdated(row, column);
  }
}
