package newtimes.production.gui.prodmaintain;

import java.awt.*;
import javax.swing.*;
import java.awt.*;
import javax.swing.*;
import exgui.chaindialog.*;
import java.util.Vector;
import java.awt.event.*;
import newtimes.production.gui.prodmaintain.PnlRspShowMark;
import database.datatype.Record;
import java.util.*;
import javax.swing.*;
import javax.swing.table.*;
import javax.swing.event.*;
import javax.swing.border.*;


/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class PnlRspNthkShowShipMaks extends JPanel implements  Responsible {
  BorderLayout borderLayout1 = new BorderLayout();
  JTable tblListMarks = null;
  JScrollPane jScrollPane1 = new JScrollPane();//new JTable();

  public PnlRspNthkShowShipMaks(Vector vctRecords) {
    try {
      jbInit();
      setTable(vctRecords);
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }

  void jbInit() throws Exception {
    this.setLayout(borderLayout1);
    this.add(jScrollPane1, BorderLayout.CENTER);
  }
  protected void setTable(Vector vctRec){
    Vector ctx=new Vector();
    for(int i=0;i<vctRec.size();i++){
      Record rec=(Record)vctRec.get(i);
      PnlRspShowMark temPln = new PnlRspShowMark((String)rec.get(2),
          (String)rec.get(3));
      Vector dataRow=new Vector();
      dataRow.add(temPln.txtMarkContent.getText());
      ctx.add(dataRow);
    }
    Vector titleVct=new Vector();
    titleVct.add("             MARK CONTEXT             ");

    tblListMarks=new JTable(ctx,titleVct);
    tblListMarks.setTableHeader(null);
    ScrollableCellRenderer renderer=new ScrollableCellRenderer();
    tblListMarks.getColumnModel().getColumn(0).setCellRenderer(renderer);

    ScrollableCellEditor txtEditor=new ScrollableCellEditor();
    tblListMarks.getColumnModel().getColumn(0).setCellEditor(txtEditor);
    tblListMarks.setRowHeight(200);
    jScrollPane1.getViewport().add(tblListMarks,null);
    //this.add(tblListMarks,  BorderLayout.CENTER);
  }
  public JComponent getGUI(){return this;}
  public void setDefalutNext(Responsible dfltRsp){}
  public Responsible next()throws NextResponsibleIsNotReady{
    int rowselect=tblListMarks.getSelectedRow();
     if(rowselect==-1){
       //rowselect=0;
       exgui.verification.VerifyLib.showAlert("Please select A Row","Select Data Please");
       throw new  NextResponsibleIsNotReady();
     }
     storedMap.put(PnlRspShowMark.KEY_TEXT_AREA_DATA,
                   tblListMarks.getValueAt(rowselect,0));
     return null;
  }
  public boolean isAllowOkNow(){return true;}

  public class ScrollableCellRenderer extends JScrollPane implements TableCellRenderer
  {

      public Component getTableCellRendererComponent(JTable table,
                                                     java.lang.Object value,
                                                     boolean isSelected,
                                                     boolean hasFocus,
                                                     int row,
                                                     int column)
      {

          setValue(value);

          return this;
      }

      protected void setValue(Object value)
      {
          //System.err.println("TextViewTableCellRenderer:setValue:"+((value == null) ? "" : value.toString()));
              JTextArea textArea = new JTextArea();
              textArea.setFont(new java.awt.Font("DialogInput", 0, 12));
              textArea.append((value == null) ? "" : value.toString());
          textArea.setLineWrap(true);
          textArea.setWrapStyleWord(true);
              setViewportView( textArea );
      }

  }
  public class ScrollableCellEditor extends JScrollPane implements TableCellEditor
  {

      public Component getTableCellEditorComponent(JTable table,
                                                     java.lang.Object value,
                                                     boolean isSelected,
                                                     int row,
                                                     int column)
      {

          setValue(value);

          return this;
      }

      protected void setValue(Object value)
      {
          //System.err.println("TextViewTableCellRenderer:setValue:"+((value == null) ? "" : value.toString()));
              JTextArea textArea = new JTextArea();
              textArea.setFont(new java.awt.Font("DialogInput", 0, 12));
              textArea.append((value == null) ? "" : value.toString());
          textArea.setLineWrap(true);
          textArea.setEditable(false);
              setViewportView( textArea );
      }

        protected EventListenerList listenerList = new EventListenerList();
        public Object getCellEditorValue() { return this; }

        public boolean isCellEditable(EventObject evt)
        { return true; }

        public boolean shouldSelectCell(EventObject anEvent) { return true; }
        public boolean stopCellEditing() { return true; }
        public void cancelCellEditing() {}
        public void addCellEditorListener(CellEditorListener l) {    listenerList.add(CellEditorListener.class, l);    }
        public void removeCellEditorListener(CellEditorListener l)
        {
          listenerList.remove(CellEditorListener.class, l);
          }

  }


}
