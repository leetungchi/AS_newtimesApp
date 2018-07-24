/*
 * (swing1.1beta3)
 *
 */

package exgui;

import java.util.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.table.*;
import java.io.*;

/**
  * ColumnGroup
  *
  * @version 1.0 10/20/98
  * @author Nobuo Tamemasa
  */

public class ColumnGroup {
  //protected TableCellRenderer renderer;
  protected MultiLineHeaderRenderer  renderer;
  protected Vector v;
  protected String text;
  protected int margin=-3;

  public ColumnGroup(String text) {
    this(null,text);
  }

  //public ColumnGroup(TableCellRenderer renderer,String text) {
  public ColumnGroup(MultiLineHeaderRenderer  renderer,String text) {
    if (renderer == null) {
     this.renderer=new MultiLineHeaderRenderer(){
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
            int maxLengthWidth=maxLength * table.getFont().getSize()+10;
            //this.setSize(maxLengthWidth,(int)orgSize.getHeight());

            //table.getColumnModel().getColumn(column).setPreferredWidth(maxLengthWidth);
            //table.getColumnModel().getColumn(column).setMinWidth(maxLengthWidth);

            setListData(v);
            return this;
          }
     };
    } else {
      this.renderer = renderer;
    }
    this.text = text;
    v = new Vector();
  }


  /**
   * @param obj    TableColumn or ColumnGroup
   */
  public void add(Object obj) {
    if (obj == null) { return; }
    v.addElement(obj);
  }


  /**
   * @param c    TableColumn
   * @param v    ColumnGroups
   */
  public Vector getColumnGroups(TableColumn c, Vector g) {
    g.addElement(this);
    if (v.contains(c)) return g;
    Enumeration enum_ = v.elements();
    while (enum_.hasMoreElements()) {
      Object obj = enum_.nextElement();
      if (obj instanceof ColumnGroup) {
        Vector groups =
          (Vector)((ColumnGroup)obj).getColumnGroups(c,(Vector)g.clone());
        if (groups != null) return groups;
      }
    }
    return null;
  }

  //public TableCellRenderer getHeaderRenderer() {
  public MultiLineHeaderRenderer  getHeaderRenderer() {
    return renderer;
  }

 // public void setHeaderRenderer(TableCellRenderer renderer) {
 public void setHeaderRenderer(MultiLineHeaderRenderer renderer) {
    if (renderer != null) {
      this.renderer = renderer;
    }
  }
  public Object getHeaderValue() {
    return text;
  }

  public Dimension getSize(JTable table) {
    Component comp = renderer.getTableCellRendererComponent(
        table, getHeaderValue(), false, false,-1, -1);
    int height = comp.getPreferredSize().height;
    int width  = 0;
    Enumeration enum_ = v.elements();
    while (enum_.hasMoreElements()) {
      Object obj = enum_.nextElement();
      if (obj instanceof TableColumn) {
        TableColumn aColumn = (TableColumn)obj;
        width += aColumn.getWidth();
        width += margin;
      } else {
        width += ((ColumnGroup)obj).getSize(table).width;
      }
    }
    return new Dimension(width, height);
  }

  public void setColumnMargin(int margin) {
    this.margin = margin;
    Enumeration enum_ = v.elements();
    while (enum_.hasMoreElements()) {
      Object obj = enum_.nextElement();
      if (obj instanceof ColumnGroup) {
        ((ColumnGroup)obj).setColumnMargin(margin);
      }
    }
  }
}

