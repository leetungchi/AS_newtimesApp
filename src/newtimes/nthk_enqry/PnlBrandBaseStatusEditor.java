package newtimes.nthk_enqry;

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

public class PnlBrandBaseStatusEditor extends exgui.ultratable.AbstractUltraTablePanel   {
  JButton btnExit=new JButton("EXIT");
  JButton btnUpdate=new JButton("UPDATE");
  public PnlBrandBaseStatusEditor (exgui.ultratable.PagedDataFactory pagedDataFxy,
        int rowlength,util.InsertionOrderedHashMap columnMapping,
        java.util.Hashtable object2StringConvertor){
        super(pagedDataFxy,rowlength,columnMapping,object2StringConvertor);
        _rowPosition=0;
        btnExit.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(ActionEvent e) {
            btnExit_actionPerformed(e);
         }
        });
        super.getLowerRightPanel().removeAll();
        super.getLowerRightPanel().add(btnUpdate);
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(ActionEvent e) {
            btnUpdate_actionPerformed(e);
         }
        });

        super.getLowerRightPanel().add(btnExit);
        super.jbtn1st.setVisible(false);
        super.jbtnLast.setVisible(false);
        super.jbtnNext.setVisible(false);
        super.jbtnPrev.setVisible(false);


  }

  public int getEachPageRowCount(){return _rowCounts;}
  public java.util.Hashtable getObject2StringConvertor() {return klmObjKvtHt;}
  public util.InsertionOrderedHashMap getHeadColumnMap(){return tblHeadColumn;}
  public exgui.ultratable.PagedDataFactory getPagedDataFactory(){return dbHandler;}
  public Record setObject2Record(Record rec,int col,Object value){
    try{
      rec.set(super.storedRecordColumn[col],value);
      return rec;
    }catch(Exception exp){
      exp.printStackTrace();
      return null;
    }

  }
  public void refineEditors(exgui.ultratable.MultiEditorJTable meTbl){
    meTbl.setTextEditorVerifiers(getObject2StringConvertor());
    meTbl.getJTable().getColumnModel().getColumn(3).setPreferredWidth(47);
    meTbl.getJTable().getColumnModel().getColumn(4).setPreferredWidth(100);
    meTbl.getJTable().getColumnModel().getColumn(5).setPreferredWidth(39);
    meTbl.getJTable().getColumnModel().getColumn(6).setPreferredWidth(38);
  }
  void btnUpdate_actionPerformed(ActionEvent e) {
     try{
       util.MiscFunc.showProcessingMessage();
       super.confirmUpdate();
       this.reload();
       util.MiscFunc.hideProcessingMessage();
     }catch(Exception exp){
       exp.printStackTrace();
       exgui.verification.VerifyLib.showAlert("Update Failed!!\nPlease Contact System Mananger","Update Failed");
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
