package newtimes.production.gui.order_change;

import processhandler.template.PnlTableEditor;
import exgui.ultratable.*;
import database.datatype.*;
import util.InsertionOrderedHashMap;
import processhandler.*;
import java.util.Hashtable;

public class PnlStyList4Chg extends PnlTableEditor
 implements java.awt.event.MouseListener{
  boolean initOk;
  public PnlStyList4Chg() {
    initOk=((newtimes.production.process.order_change.DB_StyList)dbHandler).isInitOk();
    getJtable().addMouseListener(this);
  }
  public void mouseClicked(java.awt.event.MouseEvent  e){
    //
    //get row data,
    if(getJtable().getSelectedRow()==-1)return;
    try{
      this.setCursor(new java.awt.Cursor(java.awt.Cursor.WAIT_CURSOR));
      newtimes.production.process.order_change.tempDataCenter.tempStoredChangeStyleData =
          (Record)getDisplayingRecords().get(getJtable().getSelectedRow());
      newtimes.production.ProdMaintain_Properties.EDITING_STYLE_RECORD=
          newtimes.production.process.order_change.tempDataCenter.tempStoredChangeStyleData;
      newtimes.production.process.order_change.tempDataCenter.ORIGINAL_STYLE_RECORD=
          (Record)util.MiscFunc.deepCopy(
          newtimes.production.process.order_change.tempDataCenter.tempStoredChangeStyleData);
      newtimes.production.ProdMaintain_Properties.CURRENT_SELECTED_STYLE_SEQ_IN_STYLE_LIST=
          newtimes.production.process.order_change.tempDataCenter.tempStoredChangeStyleData.getInt(0);
      processhandler.template.Properties.getCenteralControler().doCommandExecute(
      new newtimes.production.process.order_change.TgrToFieldsModify());
    }catch(Exception exp){
      exp.printStackTrace();
    }finally{
        this.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
    }
  }
  public void mouseExited(java.awt.event.MouseEvent  e){
  }
  public void mouseEntered(java.awt.event.MouseEvent  e){
  }
  public void mouseReleased(java.awt.event.MouseEvent  e){
 }
 public void mousePressed(java.awt.event.MouseEvent  e){
 }

  protected Record setObject2Record(Record rec, int columnAt, Object value2update) {
    /**@todo Implement this exgui.ultratable.AbstractUltraTablePanel abstract method*/
    return null;
  }
  protected InsertionOrderedHashMap getHeadColumnMap() {
    InsertionOrderedHashMap iso=new InsertionOrderedHashMap();
    //copy FTY DIV SEA YEAR RNG S/C NO-->SC_NO
    iso.put("FTY     ","FTY");
    iso.put("DIV     ","DIV");
    iso.put("SEA     ", "SEA");
    iso.put("YEAR  ","YEAR");
    iso.put("RNG   ","RNG");
    iso.put("S/C NO   ","SC_NO");
    iso.put("STYLE  ","STY_STYLE");//STY_STYLE, STY_PO
    iso.put("PO   ","STY_PO");
    return iso;
  }
  public void doPrint() throws java.lang.Exception {
    /**@todo Implement this processhandler.DataProcesser abstract method*/
  }
  protected void refineEditors(MultiEditorJTable multiEditorJTableInSuper) {
    /**@todo Implement this exgui.ultratable.AbstractUltraTablePanel abstract method*/
  }
  protected int getEachPageRowCount() {
    /**@todo Implement this exgui.ultratable.AbstractUltraTablePanel abstract method*/
    return 999;
  }
  protected Hashtable getObject2StringConvertor() {
    /**@todo Implement this exgui.ultratable.AbstractUltraTablePanel abstract method*/
    return null;
  }
  protected void makeTable(java.util.Vector vct){
    super.makeTable(vct,false);
  }
  public boolean isContextModified(){return false;}
  protected PagedDataFactory getPagedDataFactory() {
    /**@todo Implement this exgui.ultratable.AbstractUltraTablePanel abstract method*/
    dbHandler=
        new newtimes.production.process.order_change.DB_StyList();
        ((newtimes.production.process.order_change.DB_StyList)dbHandler).isInitOk();
    return dbHandler;
  }
  public boolean isInitOk(){return initOk;}
}
