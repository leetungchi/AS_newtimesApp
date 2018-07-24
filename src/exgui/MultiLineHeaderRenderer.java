package exgui;

import java.io.*;
import java.util.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.table.*;


/**
 * @version 1.0 11/09/98
 */
public class MultiLineHeaderRenderer extends JList implements TableCellRenderer {
  public MultiLineHeaderRenderer() {
    setOpaque(true);
    setForeground(UIManager.getColor("TableHeader.foreground"));
    setBackground(UIManager.getColor("TableHeader.background"));
    setBorder(UIManager.getBorder("TableHeader.cellBorder"));
    ListCellRenderer renderer = getCellRenderer();
    ((JLabel)renderer).setHorizontalAlignment(JLabel.LEFT);
    setCellRenderer(renderer);
  }

  public Component getTableCellRendererComponent(JTable table, Object value,
                   boolean isSelected, boolean hasFocus, int row, int column) {
    setFont(table.getFont());
    String str = (value == null) ? "" : value.toString();
    BufferedReader br = new BufferedReader(new StringReader(str));
    String line;
    int maxLength=0;
    Vector v = new Vector();
    try {
      while ((line = br.readLine()) != null) {
        v.addElement(line);
        if(line.length()>maxLength){
         maxLength=line.length();
        }
      }
    } catch (IOException ex) {
      ex.printStackTrace();
    }
    Dimension orgSize=this.getSize();
    int maxLengthWidth=maxLength * (table.getFont().getSize()-5);
    this.setSize(maxLengthWidth,(int)orgSize.getHeight());
    //table.getColumnModel().getColumn(column).setPreferredWidth(maxLengthWidth);
    table.getColumnModel().getColumn(column).setResizable(true);
    table.getColumnModel().getColumn(column).setMinWidth(maxLengthWidth);
    setListData(v);
    return this;
  }
}

