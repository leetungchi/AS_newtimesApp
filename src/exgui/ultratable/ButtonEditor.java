/* (swing1.1beta3) */

package exgui.ultratable;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;

/**
 * @version 1.0 11/09/98
 */
public class ButtonEditor extends DefaultCellEditor {
  protected JButton button;
  private String    label;
  private boolean   isPushed;
  protected java.awt.event.MouseListener[] mousLis;
  protected JTable orgTbl;
  public ButtonEditor(JCheckBox checkBox) {
    super(checkBox);
    button = new JButton();
    button.setOpaque(true);
    button.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        fireEditingStopped();
      }
    });
  }

  public Component getTableCellEditorComponent(JTable table, Object value,
                   boolean isSelected, int row, int column) {
    if (isSelected) {
      button.setForeground(table.getSelectionForeground());
      button.setBackground(table.getSelectionBackground());
    } else{
      button.setForeground(table.getForeground());
      button.setBackground(table.getBackground());
    }
    label = (value ==null) ? "" : value.toString();
    button.setText( label );
    isPushed = true;
    orgTbl=table;
    return button;
  }

  public Object getCellEditorValue() {
    if (isPushed)  {
      //
      //
      //JOptionPane.showMessageDialog(button ,label + ": Ouch!");
      // System.out.println(label + ": Ouch!");
      //java.awt.event.MouseListener mouListn[]=orgTbl.getMouseListeners();
      //if(mouListn!=null){
      //  for(int i=0;i<mouListn.length;i++)
      //    mouListn[i].mouseClicked(null);
     // }
    }
    isPushed = false;
    return new String( label ) ;
  }

  public boolean stopCellEditing() {
    isPushed = false;
    return super.stopCellEditing();
  }

  protected void fireEditingStopped() {
    super.fireEditingStopped();
  }
}

