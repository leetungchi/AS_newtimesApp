package newtimes.production.gui.prodmaintain;
import newtimes.production.process.prodmaintain.DB_FabricColorQtyYieldCul;
import processhandler.template.PnlTableEditor;
import exgui.ultratable.*;
import database.datatype.*;
import util.InsertionOrderedHashMap;
import processhandler.*;
import java.util.*;
import javax.swing.*;
public class PnlFabricColorQty extends PnlTableEditor
  implements javax.swing.event.TableModelListener{
  //java.awt.event.ItemListener {
  JComboBox colorCbx;
  Vector colorRecords;
  boolean isRefinding;
  JLabel lblTotal=new JLabel("TOTAL:");
  JLabel lblTotalPIQTY=new JLabel("P/I QTY:0");
  JLabel lblTotalSHIP=new JLabel("  SHIP:0");
  int totalPIQTY_VALUE=0;
  int totalShipYield_VALUE=0;
  Hashtable piQtyValueTbl=new Hashtable();
  Hashtable ShipYieldValueTbl=new Hashtable();
  HashMap colorCodeNameMapping;
  static java.text.NumberFormat nf=new java.text.DecimalFormat("########.##");
  public PnlFabricColorQty() {
    super();
    jbtn1st.setVisible(false);
    jbtnLast.setVisible(false);
    jbtnNext.setVisible(false);
    jbtnPrev.setVisible(false);
    getLowerRightPanel().add(lblTotal);
    getLowerRightPanel().add(lblTotalPIQTY);
    getLowerRightPanel().add(lblTotalSHIP);
  }
  protected Record setObject2Record(Record rec, int columnAt, Object value2update) {
    String allowUpdateColumn="PROD_COLOR_PK,FCQ_PI_QTY,FCQ_SHIP_YIELD";
   try{
     String columnName=
         storedRecordColumn[columnAt].toUpperCase();
     if(allowUpdateColumn.indexOf(columnName)==-1) return null;//other column name are not allow to upate
     rec.set(columnName,value2update);
     return rec;
   }catch(Exception e){
     e.printStackTrace();
     return null;
   }
  }
  protected InsertionOrderedHashMap getHeadColumnMap() {
   //FCQ.PROD_COLOR_PK,PC.PROD_COLOR_NAME,fcqx_color_code,fcq.FCQ_PI_QTY,
   //fcq.FCQ_SHIP_YIELD,NEED_YIELD
    InsertionOrderedHashMap iso=new InsertionOrderedHashMap();
    iso.put("COLOR NAME¡¿","PROD_COLOR_PK");
    iso.put("COLOR CODE","PROD_COLOR_CODE");
    iso.put("P/I QTY","FCQ_PI_QTY");
    iso.put("SHIP\nYIELD","FCQ_SHIP_YIELD");
    iso.put("NEED\nYIELD","NEED_YIELD");
    iso.put("DIFF\nYIELD","YIELD_diff");
    return iso;
  }
  public void doPrint() throws java.lang.Exception {
    /**@todo Implement this processhandler.DataProcesser abstract method*/
  }
  protected void refineEditors(MultiEditorJTable multiEditorJTableInSuper) {
    isRefinding=true;
      if(colorRecords==null){
        colorRecords=((DB_FabricColorQtyYieldCul)dbHandler).getColors();
      }
      multiEditorJTableInSuper.addJComboBox(0,colorRecords,"PROD_COLOR_NAME","PROD_COLOR_PK");

    isRefinding =false;
    javax.swing.DefaultCellEditor tce = (javax.swing.DefaultCellEditor)
          multiEditorJTableInSuper.getJTable().getColumnModel().getColumn(0).
          getCellEditor();
       colorCbx = (javax.swing.JComboBox) tce.getComponent();
      //colorCbx.addItemListener(this);
      try{
      colorCodeNameMapping=
          newtimes.preproduction.Constants.mapping4ComboboxKeyInt(colorRecords,
          "PROD_COLOR_PK","PROD_COLOR_CODE");
      }catch(Exception e){
         e.printStackTrace();
      }
    getJtable().getModel().addTableModelListener(this);
    multiEditorJTableInSuper.setTextEditorVerifiers(getObject2StringConvertor());
    ((exgui.MultiClassTableModel)multiEditorJTableInSuper.getJTable().getModel()).removeEditableColumn("NEED\nYIELD");
  }
  public void tableChanged(javax.swing.event.TableModelEvent te){
    if(te.getColumn()!=0)return;
    int row=te.getFirstRow();
    int col=te.getColumn();
    //System.out.println("obj in row,col is "+getJtable().getValueAt(row,col).getClass().getName());
    if(getJtable().getValueAt(row,col) instanceof exgui.ultratable.Wraper4tblCbx){
    exgui.ultratable.Wraper4tblCbx valueObj=
        (exgui.ultratable.Wraper4tblCbx)getJtable().getValueAt(row,col);
    getJtable().setValueAt(colorCodeNameMapping.get(valueObj.getValue().toString()),row,1);
    }
  }

  public void itemStateChanged(java.awt.event.ItemEvent e){
    if(!isRefinding){
     int slkAt=colorCbx.getSelectedIndex();
     if(slkAt<0) slkAt=0;
     database.datatype.Record rec=(database.datatype.Record)colorRecords.get(slkAt);
     /*
     getJtable().setValueAt(new exgui.ultratable.Wraper4tblCbx(rec.get(0),(String)rec.get(1)),
                            getJtable().getSelectedRow(),0);
     */
     getJtable().setValueAt(rec.get(2),getJtable().getSelectedRow(),1);

    }
  }
  public void makeTotalValueHashTable(){
    for(int i=0;i<getJtable().getRowCount();i++){
      Object shipYildValue=getJtable().getValueAt(i,3);
      Object PIValue=getJtable().getValueAt(i,2);
      if(shipYildValue==null){
        ShipYieldValueTbl.put(String.valueOf(i)+"_"+String.valueOf(3),new Integer(0));
      }else if(shipYildValue.toString().trim().length()==0){
        ShipYieldValueTbl.put(String.valueOf(i)+"_"+String.valueOf(3),new Integer(0));
      }else{
        totalShipYield_VALUE+=new Integer(shipYildValue.toString()).intValue();
        ShipYieldValueTbl.put(String.valueOf(i)+"_"+String.valueOf(3),new Integer(shipYildValue.toString()));
      }
      if(PIValue==null){
        piQtyValueTbl.put(String.valueOf(i)+"_"+String.valueOf(2),new Integer(0));
      }else if(PIValue.toString().trim().length()==0){
        piQtyValueTbl.put(String.valueOf(i)+"_"+String.valueOf(2),new Integer(0));
      }else{
        piQtyValueTbl.put(String.valueOf(i)+"_"+String.valueOf(2),new Integer(PIValue.toString()));
        totalPIQTY_VALUE+=new Integer(PIValue.toString()).intValue();
      }
    }
    lblTotalPIQTY.setText("P/I QTY:"+String.valueOf(totalPIQTY_VALUE));
    lblTotalSHIP.setText("    Ship Yield:"+String.valueOf(totalShipYield_VALUE));
  }
  protected int getEachPageRowCount() {
    /**@todo Implement this exgui.ultratable.AbstractUltraTablePanel abstract method*/
    return 9999;
  }
  protected Hashtable getObject2StringConvertor() {
    Hashtable ht=new Hashtable();
    Object objNeedYieldCnv=exgui.verification.CellFormat.getDoubleFormatAllowNull(7,2);
    ht.put("P/I QTY",new PIfldVfyObj(this.getJtable()));
    ht.put("SHIP\nYIELD",new ShipfldVfyObj(this.getJtable()));
    ht.put("NEED\nYIELD",objNeedYieldCnv);
    return ht;
  }
  protected PagedDataFactory getPagedDataFactory() {
    DB_FabricColorQtyYieldCul db=new DB_FabricColorQtyYieldCul();
    dbHandler=db;
    return dbHandler;
  }
  protected void makeTable(java.util.Vector vct){
    super.makeTable(vct);
    makeTotalValueHashTable();
  }
  public void doAddNew() throws Exception{
   //super.addRecord();
   //pop out the sub panel.allow user to add 20 record by bacth
   DlgBchAddFbcClrQty dlg2add=new DlgBchAddFbcClrQty(
       processhandler.template.Properties.getMainFrame(),
       "Add Colors",true,
       (DB_FabricColorQtyYieldCul)this.dbHandler);
   dlg2add.setSize(400,350);
   dlg2add.show();
   if(dlg2add.getOperationStatus()==dlg2add.STATUS_CLOSE_CANCEL||
      dlg2add.getOperationStatus()==dlg2add.STATUS_OPERATING)return;
   this.goPage(_rowPosition,_rowCounts);
 }

  public boolean isInitOK(){
    if(dbHandler==null) return false;
    return ((DB_FabricColorQtyYieldCul)dbHandler).isInitOK();
  }
  //==========================use modify detecter=====================
  class ShipfldVfyObj extends PIfldVfyObj{
    ShipfldVfyObj(javax.swing.JTable jtable){
      super(jtable);
    }
    void modifiedYYvalue(String str,int row,int column ){
      //find out the last sumned row & column of YY1,
      int orgPiValue=((Integer)ShipYieldValueTbl.get(String.valueOf(row)+"_"+String.valueOf(3))).intValue();
      totalShipYield_VALUE-=orgPiValue;
      int newShipYildValue=0;
      if(str==null|| str.trim().length()==0){
         ShipYieldValueTbl.put(String.valueOf(row)+"_"+String.valueOf(3),new Integer(0));
      }else{
        Integer newValue=new Integer(str);
        ShipYieldValueTbl.put(String.valueOf(row)+"_"+String.valueOf(3),newValue);
        totalShipYield_VALUE+=newValue.intValue();
        newShipYildValue=newValue.intValue();
      }

      Object needYldObj=_jtable.getValueAt(row,_jtable.getColumnCount()-2);
      String needYld=(needYldObj==null)?"0":needYldObj.toString();
      double needYldValue=(needYld.trim().length()>0)?Double.parseDouble(needYld):0;
      _jtable.setValueAt(nf.format(newShipYildValue-needYldValue),
                         row,_jtable.getColumnCount()-1);

      lblTotalSHIP.setText("    Ship Yield:"+String.valueOf(totalShipYield_VALUE));
    }
  }

  class PIfldVfyObj implements exgui.ultratable.CellTxtEditorFormat {
   javax.swing.JTable _jtable;
   PIfldVfyObj(javax.swing.JTable jtable){
     _jtable=jtable;
   }
    exgui.ultratable.CellTxtEditorFormat vfyObj=
        exgui.verification.CellFormat.getIntVerifierAllowNull(7);
   String myWarnningMsg="String must be in integer format";
   public int getMaxLength(){return 7;}
   public String formatPromptMsg(){
    return myWarnningMsg;
   }
   public Object cellStringToObject(String str){
    return vfyObj.cellStringToObject(str);
   }
   public exgui.ultratable.KeyProcess getKeyListener(){
     return ((exgui.ultratable.CellTxtEditorFormat)vfyObj).getKeyListener();
   }

   void modifiedYYvalue(String str,int row,int column ){
     //find out the last sumned row & column of YY1,
     int orgPiValue=((Integer)piQtyValueTbl.get(String.valueOf(row)+"_"+String.valueOf(2))).intValue();
     totalPIQTY_VALUE-=orgPiValue;
     if(str==null|| str.trim().length()==0){
        piQtyValueTbl.put(String.valueOf(row)+"_"+String.valueOf(2),new Integer(0));
     }else{
       Integer newValue=new Integer(str);
       piQtyValueTbl.put(String.valueOf(row)+"_"+String.valueOf(2),newValue);
       totalPIQTY_VALUE+=newValue.intValue();
     }
     lblTotalPIQTY.setText("P/I QTY:"+String.valueOf(totalPIQTY_VALUE));
   }
   synchronized public boolean isFormatValid(String instr,int row,int column){
     if(!vfyObj.isFormatValid(instr,row,column)){
       myWarnningMsg=vfyObj.formatPromptMsg();
       _jtable.editCellAt(row,column);
       return false;
     }
     modifiedYYvalue(instr,row,column);
     return true;
    }
  }
}
