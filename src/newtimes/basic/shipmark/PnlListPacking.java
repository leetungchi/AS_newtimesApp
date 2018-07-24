package newtimes.basic.shipmark;

import exgui.ultratable.*;
import database.datatype.*;
import util.InsertionOrderedHashMap;
import java.util.Hashtable;
import javax.swing.JButton;
public class PnlListPacking extends AbstractUltraTablePanel {
  static final String PACKING_MARK_SEQ="No.";
  static final String BYMKR_BRIEF = "Buyer Brief";
  static final String BYMKR_NAME = "Buyer Name   ";
  static final String BYMKR_CHINESE_BRIEF = "Chinese Brief";
  static final String BYMKR_MASTER_COMPANY = "Master Company";
  static final String CNTY_NAME = "Country";
  JButton btnExit=new JButton("EXIT");
  public PnlListPacking() {
    _rowPosition=PnlQryPacking.beginRowPos;
    btnExit.addMouseListener(new goExitAxn());
    getLowerRightPanel().add(btnExit);
    getJtable().addMouseListener(new goEditAxn());
    reload();
    this.setBounds(new java.awt.Rectangle(16, 82, 760, 406));
    this.setBackground(new java.awt.Color(204, 204, 225));
  }
  class goExitAxn extends java.awt.event.MouseAdapter {
    //go query page.
    public void mouseClicked(java.awt.event.MouseEvent e){
      if(PnlQryPacking.me!=null){
        ((newtimes.Frame1)util.PublicVariable.APP_FRAME).showPanel(PnlQryPacking.me);
        ((newtimes.Frame1)util.PublicVariable.APP_FRAME).repaint();
        ((newtimes.Frame1)util.PublicVariable.APP_FRAME).validate();
      }else{
         PnlQryPacking.me=new PnlQryPacking();
        ((newtimes.Frame1)util.PublicVariable.APP_FRAME).showPanel(PnlQryPacking.me);
        ((newtimes.Frame1)util.PublicVariable.APP_FRAME).repaint();
        ((newtimes.Frame1)util.PublicVariable.APP_FRAME).validate();
      }
    }
  }
  class goEditAxn extends java.awt.event.MouseAdapter{
    public void mouseClicked(java.awt.event.MouseEvent e){
      try{
        int rowAt = getJtable().getSelectedRow();
        if (rowAt == -1)return;
        Record rec = ((exgui.ultratable.PagedDataFactoryAdapter)dbHandler).
            getRecordByPk((
            (Record)getDisplayingRecords().get(rowAt)).getInt(0));
        PnlPackingEdit pnl = new PnlPackingEdit();
        PnlQryPacking.beginRowPos=_rowPosition;
        pnl.setHandlerAndRecord(dbHandler, rec);
        ((newtimes.Frame1)util.PublicVariable.APP_FRAME).showPanel(pnl);
      }catch(Exception exp){
        exp.printStackTrace();
        util.ExceptionLog.exp2File(exp,"");
        exgui.verification.VerifyLib.showAlert("Error While Retrieving Packing Mark Data To Edit","Connection Or Server Side Error");
      }
    }
  }
  protected Record setObject2Record(Record rec, int columnAt, Object value2update) {
    /**@todo Implement this exgui.ultratable.AbstractUltraTablePanel abstract method*/
    throw new java.lang.UnsupportedOperationException("Method setObject2Record() not yet implemented.");
  }
  protected InsertionOrderedHashMap getHeadColumnMap() {
     util.InsertionOrderedHashMap headHm = new util.InsertionOrderedHashMap();
      headHm.put(PACKING_MARK_SEQ, "PACKING_PK");
      headHm.put(BYMKR_BRIEF, "BYMKR_BRIEF");
      headHm.put(BYMKR_NAME, "BYMKR_NAME");
      headHm.put(BYMKR_CHINESE_BRIEF, "BYMKR_CHINESE_BRIEF");
      //headHm.put(BYMKR_MASTER_COMPANY, "BYMKR_MASTER_COMPANY");
      headHm.put(BYMKR_MASTER_COMPANY,"Master_Company");
      headHm.put(CNTY_NAME, "CNTY_NAME");
     return headHm;
  }
  protected void refineEditors(MultiEditorJTable multiEditorJTableInSuper) {
    /**@todo Implement this exgui.ultratable.AbstractUltraTablePanel abstract method*/
  }
  protected int getEachPageRowCount() {
    return 20;//10;
  }
  protected Hashtable getObject2StringConvertor() {
    return null;
  }
  protected PagedDataFactory getPagedDataFactory() {
    /**@todo Implement this exgui.ultratable.AbstractUltraTablePanel abstract method*/
     DbPackingMark db=new DbPackingMark(PnlQryPacking.qryConditions);
     return db;
  }

}
