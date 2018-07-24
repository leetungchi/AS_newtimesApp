package newtimes.bank;

import java.awt.*;
import exgui.*;
import javax.swing.*;
import java.awt.event.*;
import database.datatype.Record;
/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class PnlListChkDtl extends exgui.ultratable.AbstractUltraTablePanel   {
  JButton btnExit=new JButton("EXIT");
  public PnlListChkDtl(exgui.ultratable.PagedDataFactory pagedDataFxy,
        int rowlength,util.InsertionOrderedHashMap columnMapping,
        java.util.Hashtable object2StringConvertor){
        super(pagedDataFxy,rowlength,columnMapping,object2StringConvertor);
        _rowPosition=Constants.BEGIN_POSITION_OF_BANK_HEAD_QRY;
        btnExit.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(ActionEvent e) {
            btnExit_actionPerformed(e);
         }
        });
        getJtable().addMouseListener(new TblMouseListener());
        super.getLowerRightPanel().removeAll();
        super.getLowerRightPanel().add(btnExit);
        /*
        super.jbtn1st.setVisible(false);
        super.jbtnLast.setVisible(false);
        super.jbtnNext.setVisible(false);
        super.jbtnPrev.setVisible(false);*/
  }
  public class MyRenderer extends JLabel
    implements javax.swing.table.TableCellRenderer{
    public MyRenderer(){
    super();
   setOpaque(true); /* it\u00B4s essential */
}
 public Component getTableCellRendererComponent(
       javax.swing.JTable table, Object value,
       boolean isSelected, boolean hasFocus,
       int row, int column){
       String text = (value==null)?"":value.toString();
       setBackground(new java.awt.Color(0xFF,0xFF,0xFF)); // Decides the color
       setText(text+"    ");
       setHorizontalAlignment(RIGHT);
   return this;
  }
}

  class TblMouseListener extends java.awt.event.MouseAdapter{
    public void mouseClicked(java.awt.event.MouseEvent me){
      Constants.BEGIN_POSITION_OF_BANK_CHK_DTL_QRY=_rowPosition;
      Constants.CURRENT_EDITING_BANK_CHK_DTL_RECORD=(Record)
          getDisplayingRecords().get(getJtable().getSelectedRow());
      try{
        processhandler.template.Properties.getCenteralControler().doCommandExecute(
           new TgrEditBankChkDtl());

      }catch(Exception exp){
        exp.printStackTrace();
      }
    }
  }
  public int getEachPageRowCount(){return _rowCounts;}
  public java.util.Hashtable getObject2StringConvertor() {return klmObjKvtHt;}
  public util.InsertionOrderedHashMap getHeadColumnMap(){return tblHeadColumn;}
  public exgui.ultratable.PagedDataFactory getPagedDataFactory(){return dbHandler;}
  public Record setObject2Record(Record rec,int col,Object value){return null;}
  class EditPalicy implements exgui.CellEditablePolicy{
     public boolean isCellEditable(int row,int column) {return false;}
  }

  public void refineEditors(exgui.ultratable.MultiEditorJTable meTbl){
    try{
      meTbl.addJComboBox(0, Constants.vctCompany, "COMPANY_NAME",
                         "COMPANY_CODE");
      java.util.Vector vctTempBank = new java.util.Vector();
      vctTempBank.addAll(Constants.vctBank);
      Record blankBankRec = (Record)util.MiscFunc.deepCopy(Constants.vctBank.
          get(0));
      blankBankRec.set(0, null);
      blankBankRec.set(1, "");
      vctTempBank.add(blankBankRec);
      meTbl.addJComboBox(1, vctTempBank, "BANK_NAME", "BANK_CODE");
      //meTbl.addJComboBox(1,Constants.vctBank,"BANK_NAME","BANK_CODE");
      meTbl.setTextEditorVerifiers(getObject2StringConvertor());
      ((exgui.MultiClassTableModel)meTbl.getJTable().getModel()).
          setCellEditablePolicy(new EditPalicy());
      MyRenderer myder = new MyRenderer();
      this.getJtable().getColumnModel().getColumn(5).setCellRenderer(myder);
    }catch(Exception exp){
      exp.printStackTrace();
    }

  }
  void btnExit_actionPerformed(ActionEvent e) {
    try{
      processhandler.template.Properties.getCenteralControler().
          setDataProcesser(null);
      processhandler.template.Properties.getCenteralControler().goBack();
    }catch(Exception exp){
      exp.printStackTrace();
    }
  }
}
