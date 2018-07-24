package exgui;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public interface CellEditablePolicy {
   /**
    * will  be called by MultiClassTableModel's isCellEditable(row,column)
    * @param row,row position of jtable.
    * @param column,column position of related jtable.
    * @return if cell in jtable is editable.
    */
   public boolean isCellEditable(int row,int column);


}