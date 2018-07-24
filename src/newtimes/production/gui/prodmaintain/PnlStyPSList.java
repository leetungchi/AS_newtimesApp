package newtimes.production.gui.prodmaintain;

import util.InsertionOrderedHashMap;
import exgui.ultratable.*;
import java.util.Hashtable;
import newtimes.production.process.prodmaintain.DB_Style_PS_Misc;
public class PnlStyPSList extends PnlStyMiscList {
  static String DISP_STY_NO="    STYLE NO    ";
  static String DB_STY_NO="STY_STYLE";
  static String DISP_STY_PO="     PO    ";
  static String DB_STY_PO="STY_PO";
  static String DISP_STY_DLV="       DELIVERY    ";
  public PnlStyPSList() {
    getJtable().addMouseListener(new myclick());
  }
  class myclick extends java.awt.event.MouseAdapter{
    public void mouseClicked(java.awt.event.MouseEvent me){
     int selectrow=getJtable().getSelectedRow();
       if(selectrow==-1)return;
       javax.swing.JTable _jTable1=getJtable();
       _jTable1.editCellAt(selectrow,3);
      javax.swing.JComponent  txtArea= ((javax.swing.JComponent)_jTable1.getEditorComponent());
      txtArea.grabFocus();
      //txtArea.setCaretPosition(txtArea.getDocument().getLength());
    }
  }
  protected InsertionOrderedHashMap getHeadColumnMap() {
    util.InsertionOrderedHashMap iso=new util.InsertionOrderedHashMap();
    iso.put(DISP_STY_NO,DB_STY_NO);
    iso.put(DISP_STY_PO,DB_STY_PO);
    iso.put(DISP_STY_DLV,"temp_del_data");
    /*
     iso.put("I","STY_PS1");
     iso.put("I I","STY_PS2");
     iso.put("I I I","STY_PS3");
    */
     iso.put("        PS REMARK              ","STY_PS_RMRK");
     iso.put("        Factory Response       ","STY_RMRK");
    return iso;
  }
  protected PagedDataFactory getPagedDataFactory() {
    dbHandler=new DB_Style_PS_Misc();
    return dbHandler;
  }
  protected void refineEditors(MultiEditorJTable multiEditorJTableInSuper) {
    /*
    multiEditorJTableInSuper.setTableColumn2Grp("PROD STATUS",3);
    multiEditorJTableInSuper.setTableColumn2Grp("PROD STATUS",4);
    multiEditorJTableInSuper.setTableColumn2Grp("PROD STATUS",5);
    */
    multiEditorJTableInSuper.setTextEditorVerifiers(getObject2StringConvertor());
    multiEditorJTableInSuper.setColumnUnEditable(DISP_STY_DLV);
    multiEditorJTableInSuper.addTextAreaEditor(3,478,80);
    multiEditorJTableInSuper.addTextAreaEditor(4,478,80);
    getJtable().getColumnModel().getColumn(3).setPreferredWidth(216);
    getJtable().getColumnModel().getColumn(4).setPreferredWidth(216);
    getJtable().setRowHeight(90);
    hookInRefineEditor(multiEditorJTableInSuper);
  }
  protected Hashtable getObject2StringConvertor() {
    Hashtable ht=new Hashtable();
    //Object c2=exgui.verification.CellFormat.getOrdinaryField(2);
    //Object c200=exgui.verification.CellFormat.getOrdinaryField(200);
    /*
    Object c2=new PS_fldVfyObj();
    ht.put("I",c2);
    ht.put("I I",c2);
    ht.put("I I I",c2);
    */
    return ht;
  }
 protected class PS_fldVfyObj implements
     exgui.ultratable.CellTxtEditorFormat,exgui.Object2String{
   Object intVfy=exgui.verification.CellFormat.getIntVerifierAllowNull(2);
   public String Obj2String(Object cnv){
     return ((exgui.Object2String)intVfy).Obj2String(cnv);
   }
   public exgui.ultratable.KeyProcess getKeyListener(){
     return ((exgui.ultratable.CellTxtEditorFormat)intVfy).getKeyListener();
   }

   public Object cellStringToObject(String strInCell){
     return ((exgui.ultratable.CellTxtEditorFormat)intVfy).cellStringToObject(strInCell);
   }
   public String formatPromptMsg(){
     return "Status Code should between 0~13";
   }
   public boolean isFormatValid(String strInCell,int row,int col){
     if(!((exgui.ultratable.CellTxtEditorFormat)intVfy).isFormatValid(strInCell,row,col)) return false;
     if(strInCell==null)return true;
     if(strInCell.trim().length()==0)return true;
     int intVal=Integer.parseInt(strInCell);
     if(intVal<0||intVal>13)return false;
     return true;
   }
   public int getMaxLength(){return 2;}
 }
}
