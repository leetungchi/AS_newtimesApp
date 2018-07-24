package exgui.ultratable;

import java.awt.Component;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.AbstractButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.JTable;
import javax.swing.KeyStroke;
import javax.swing.SwingUtilities;
import javax.swing.event.ChangeEvent;
import javax.swing.event.EventListenerList;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.TableColumnModelEvent;
import javax.swing.event.TableModelEvent;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import javax.swing.text.JTextComponent;


/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author : May 22, 2003 4:36 PM (reply 2 of 2),http://forum.java.sun.com/thread.jspa?forumID=57&threadID=402164
 * Author: mboorgu
 * @version 1.0
 */

public class JTableBindKeyStroke   extends JTable {
  protected boolean processKeyBinding(KeyStroke stroke, KeyEvent evt,
                                       int condition,boolean pressed) {

          Component cellEditorComp = this.getEditorComponent();

          // If the editor is a combo box, and the key is down arrow, pass the event to Drop down
          if ((cellEditorComp != null) &&
              (cellEditorComp instanceof JComboBox) &&
              (evt.getKeyCode() == KeyEvent.VK_DOWN))
                  return super.processKeyBinding(stroke, evt, condition, pressed);

          // if the current cell is in edit mode, pass the event to editor component
          // for right and left arrow keys
          // For combo box do not pass the event, instead handle left and right arrow key press.
          if ((getCellEditor() != null) &&
          !(cellEditorComp instanceof JComboBox) &&
          ((evt.getKeyCode() == KeyEvent.VK_LEFT) ||
          (evt.getKeyCode() == KeyEvent.VK_RIGHT)))
                  return super.processKeyBinding(stroke, evt, condition, pressed);

          // To avoid handling of the keys more than once,
          // the following condition is checked.
          if (pressed)
                  return true;

          if ((evt.getKeyCode() == KeyEvent.VK_TAB) &&
             (!evt.isAltDown())) {

                  if (evt.isShiftDown())
                          processShiftTabKey();
                  else
                          processTabKey();
          }
          else if (evt.getKeyCode() == KeyEvent.VK_LEFT){
                  processShiftTabKey();
          }
          else if (evt.getKeyCode() == KeyEvent.VK_RIGHT){
                  processTabKey();
          }
          else if (evt.getKeyCode() == KeyEvent.VK_UP){
                  processUpArrow();
          }
          else if (evt.getKeyCode() == KeyEvent.VK_DOWN){
                  processDownArrow();
          }
          else
                  return super.processKeyBinding(stroke, evt, condition, pressed);

          return true;
  }

  /**
   * Method to select a table cell
   */
  public void setSelectedCell(int pRow, int pCol) {
          try {
                  this.grabFocus();
                  this.addColumnSelectionInterval(pCol, pCol);
                  this.addRowSelectionInterval(pRow,pRow);
                  this.editCellAt(pRow,pCol);
                  if (this.getEditorComponent() != null)
                          this.getEditorComponent().requestFocus();

                  // make the cell visible, it may not be visible sometimes.
                  scrollRectToVisible(getCellRect(pRow, pCol, true));
          } catch (Exception e) {
                  System.out.println("ERROR: attempting to select cell at row " + pRow + " & column " + pCol);
          }
  }

  /*
   * PROCESS SHIFT + TAB KEY
   */
  public void processShiftTabKey(){
          int nRow = this.getEditingRow();
              int nCol = this.getEditingColumn();

              // if the cell is in edit mode, stop it.
              if (this.getCellEditor() != null)
                      this.getCellEditor().stopCellEditing();

                  int newCol = findPreviousEditableColumn(nRow, nCol);
                  while (nCol == newCol){
                          nRow--; // check the next row
                          nCol = this.getColumnCount(); // to start with last col
                          if (nRow < 0){
                                  this.transferFocus();
                                  return;
                          }
                          newCol = findPreviousEditableColumn(nRow, nCol);
                  }

              setSelectedCell(nRow, newCol);
  }

  public int findPreviousEditableColumn(int nRow, int nCol){

          if ((nRow >= 0) &&
                  (nRow < this.getRowCount())&&
                  (nCol >= 0)){
                      for(int i=nCol-1; i!=-1; i--){
                          if (this.isCellEditable(nRow, i)){
                                  return i;
                          }
                      }
              }
              return nCol;
  }

  /*
   * PROCESS TAB KEY
   */
  public void processTabKey(){
              int nRow = this.getEditingRow();
              if (nRow == -1)
                  return;
              int nCol = this.getEditingColumn();

              // if the cell is in edit mode, stop it.
              if (this.getCellEditor() != null)
                     this.getCellEditor().stopCellEditing();

                  int newCol = findNextEditableColumn(nRow, nCol);
                  while (nCol == newCol){
                          nRow++; // check the next row
                          nCol = -1; // to start with 1st col
                          if (nRow >= this.getRowCount()){
                                  this.transferFocus();
                                  return;
                          }
                          newCol = findNextEditableColumn(nRow, nCol);
                  }

          setSelectedCell(nRow, newCol);
  }

  /*
   * PROCESS UP ARROW KEY
   */
  public void processUpArrow(){
          int nRow = this.getEditingRow();
          if (nRow <= 0)
                  return;
          int nCol = this.getEditingColumn();
          // if the cell is in edit mode, stop it.
          if (this.getCellEditor() != null)
                  this.getCellEditor().stopCellEditing();

          setSelectedCell(nRow-1, nCol);
  }

  /*
   * PROCESS DOWN ARROW KEY
   */
  public void processDownArrow(){
          int nRow = this.getEditingRow();
          if ((nRow == -1) ||
             ((nRow+1) == this.getRowCount()))
                  return;

          int nCol = this.getEditingColumn();

          // if the cell is in edit mode, stop it.
          if (this.getCellEditor() != null)
                  this.getCellEditor().stopCellEditing();

          setSelectedCell(nRow+1, nCol);
  }

  public int findNextEditableColumn(int nRow, int nCol){

              if ((nRow >= 0) &&
               (nRow < this.getRowCount())){

                  for(int i=nCol+1; i<this.getColumnCount(); i++){
                          if (this.isCellEditable(nRow, i)){
                                  return i;
                          }
                      }
              }
              return nCol;
  }
}
