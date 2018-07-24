package newtimes.production.gui.order_change;
import newtimes.production.process.order_change.*;
import processhandler.template.PnlTableEditor;
import exgui.ultratable.*;
import database.datatype.*;
import util.InsertionOrderedHashMap;
import processhandler.*;
import java.util.*;
import javax.swing.JLabel;
import newtimes.production.process.order_change.*;
import java.awt.Cursor;
public class PnlPrxList extends PnlTableEditor {
 public javax.swing.JButton btnContinue=new javax.swing.JButton("Next-->Quantity");
 boolean _abl2Edt;
  public PnlPrxList(boolean editable) {
    /*
    this.add(new JLabel("Org price data"),
             java.awt.BorderLayout.NORTH);
    */
   super();
   _abl2Edt=editable;
   super.jbtn1st.setVisible(false);
   super.jbtnLast.setVisible(false);
   super.jbtnNext.setVisible(false);
   super.jbtnPrev.setVisible(false);
   java.awt.FlowLayout flout=new java.awt.FlowLayout();
   super.getLowerRightPanel().setLayout(flout);

   super.getLowerRightPanel().add(btnContinue,null);
   btnContinue.addMouseListener(new myMouseListener());
 }
protected void saveTblQtyChg(){
  javax.swing.JTable tbl=getJtable();
  java.util.List arrList=new java.util.ArrayList();
  for(int i=0;i<tbl.getRowCount();i++){
    Record rec=(Record)getDisplayingRecords().get(i);
    arrList.add(
       tbl.getValueAt(i,0).toString()+
       tempDataCenter.Splet4str_arr_NEW_PRI_SEQ_LXY_CLR_PRX_data+
       tbl.getValueAt(i,1).toString()+
       tempDataCenter.Splet4str_arr_NEW_PRI_SEQ_LXY_CLR_PRX_data+
       tbl.getValueAt(i,4).toString()+
       tempDataCenter.Splet4str_arr_NEW_PRI_SEQ_LXY_CLR_PRX_data+
       rec.get(0).toString());
  }
  //each element contents licensee,color,buyer actual price & pri_seq
  tempDataCenter.str_arr_NEW_LXY_CLR_PRX_PRI_SEQ_data=
      (String[])arrList.toArray(new String[0]);
}
public void doConfirmNow(){
   try{
      this.setCursor(new Cursor(Cursor.WAIT_CURSOR));
      if(!confirmUpdate()) return;
      saveTblQtyChg();
     processhandler.template.Properties.getCenteralControler().doCommandExecute(
     new newtimes.production.process.order_change.TgrToChangeQty());
   }catch(Exception exp){
     exp.printStackTrace();
   }finally{
     this.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
   }
}
protected class myMouseListener extends java.awt.event.MouseAdapter {
   public void mouseClicked(java.awt.event.MouseEvent e){
     doConfirmNow();
   }
 }

  protected Record setObject2Record(Record rec, int columnAt, Object value2update) {
    /**@todo Implement this exgui.ultratable.AbstractUltraTablePanel abstract method*/
    //throw new java.lang.UnsupportedOperationException("Method setObject2Record() not yet implemented.");
    String clm= storedRecordColumn[columnAt];
    try{
      rec.set(clm,value2update);
      return rec;
    }catch(Exception e){
      e.printStackTrace();
      return null;
    }
  }
  protected InsertionOrderedHashMap getHeadColumnMap() {
    /**@todo Implement this exgui.ultratable.AbstractUltraTablePanel abstract method*/
   //PRI_BYR_ACT_PRX, PRI_BYR_DOC_PRX,
   //PRI_MKR_ACT_PRX, PRI_MKR_DOC_PRX, PROD_COLOR_PK, PRI_LICENSEE_NAME
    InsertionOrderedHashMap iso=
        new InsertionOrderedHashMap();
    iso.put("LICENSEE","PRI_LICENSEE_NAME");
    iso.put("COLOR","PROD_COLOR_PK");
    iso.put("CMT\nPRICE","CMT_PRICE");
    iso.put("FOB\nPRICE","PRI_BYR_DOC_PRX");
    iso.put("BUYER ACT\nPRICE","PRI_BYR_ACT_PRX");
    iso.put("MAKER DOC\nPRICE","PRI_MKR_DOC_PRX");
    iso.put("MAKER ACT\nPRICE","PRI_MKR_ACT_PRX");
    return iso;
  }
  public void doPrint() throws java.lang.Exception {
    /**@todo Implement this processhandler.DataProcesser abstract method*/
  }
  protected void refineEditors(MultiEditorJTable multiEditorJTableInSuper) {
    Proxy_PriceList  mydbHandler=(Proxy_PriceList)dbHandler;
    //unitsRecords=mydbHandler.UnitsData;
    Vector styleRecords=mydbHandler.SytlesAndPo;
    Vector colorRecords=mydbHandler.ProdColors;
    Vector buyerLicensee=mydbHandler.LicenseeData;
    multiEditorJTableInSuper.addJComboBox(0,buyerLicensee,"BYMKR_BRIEF","BYMKR_SEQ");
    multiEditorJTableInSuper.addJComboBox(1,colorRecords,"PROD_COLOR_NAME","PROD_COLOR_PK");
    multiEditorJTableInSuper.setTextEditorVerifiers(getObject2StringConvertor());
    ((exgui.MultiClassTableModel)multiEditorJTableInSuper.getJTable().getModel()).removeEditableColumn("CMT\nPRICE");
    if(!_abl2Edt){
      ((exgui.MultiClassTableModel)multiEditorJTableInSuper.getJTable().getModel()).removeAllEditableColumn();
    }
  }
  protected int getEachPageRowCount() {
    return 999;
  }
  protected Hashtable getObject2StringConvertor() {
    /**@todo Implement this exgui.ultratable.AbstractUltraTablePanel abstract method*/
    //throw new java.lang.UnsupportedOperationException("Method getObject2StringConvertor() not yet implemented.");
    Object cnv73=exgui.verification.CellFormat.getDoubleFormatAllowNull(7,3);
    Hashtable ht=new Hashtable();
    ht.put("CMT\nPRICE",cnv73);
    ht.put("FOB\nPRICE",cnv73);
    ht.put("BUYER ACT\nPRICE",cnv73);
    ht.put("MAKER DOC\nPRICE",cnv73);
    ht.put("MAKER ACT\nPRICE",cnv73);
    return ht;
  }
  protected PagedDataFactory getPagedDataFactory() {
    Proxy_PriceList xDl=new Proxy_PriceList();
    dbHandler=xDl;
    return dbHandler;
  }
  public boolean isInitOK(){
    return ((Proxy_PriceList)dbHandler).isInitOk();
  }

}
