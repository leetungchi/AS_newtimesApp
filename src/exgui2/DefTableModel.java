package exgui2;

import javax.swing.JComponent;
import javax.swing.table.*;
import javax.swing.*;
import java.util.Vector;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author unascribed
 * @version 1.0
 */

public class DefTableModel extends DefaultTableModel {
  private DefaultTableModel dfModel = null;
  private JTable jTable1 = null;

  public DefTableModel() {
  }

  public JTable DefTabelModel(Object[][] data, Object[] head){
    try{
      dfModel = new DefaultTableModel(data, head);
      jTable1 = new JTable(dfModel);
      jTable1.getTableHeader().setReorderingAllowed(false);
    }catch(Exception e){
      e.printStackTrace();
    }
    return jTable1;
  }

  public Class getColumnClass(int c) {
    return getValueAt(0, c).getClass();
  }
}
