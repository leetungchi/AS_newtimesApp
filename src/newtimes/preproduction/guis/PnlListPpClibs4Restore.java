package newtimes.preproduction.guis;
import java.awt.*;
import processhandler.template.PnlTableEditor;
import java.util.*;
/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class PnlListPpClibs4Restore extends PnlTableEditor {
  newtimes.preproduction.process.DB_PreProdColorLib myHandler;
  boolean checked=false;
  public static util.InsertionOrderedHashMap iso=null;
  public static Hashtable obj2strCnv=new Hashtable();
  public PnlListPpClibs4Restore() {
    myHandler.isInitialzing(true);
    this.firstPage();
    myHandler.isInitialzing(false);
  }
 public void doPrint(){
 }
 public int getEachPageRowCount(){
   return 5;
 }
 public Hashtable getObject2StringConvertor(){
   //return null;
   return obj2strCnv;
 }
 public util.InsertionOrderedHashMap getHeadColumnMap(){
   if(iso==null){
     iso=new util.InsertionOrderedHashMap();
     iso.put("Check To Restore","record_delete_flag");
     iso.put("Color Code","PCLIB_COLOR_CODE");
     iso.put("Color Name","PCLIB_COLOR_NAME");
     iso.put("Lab Ref.","PCLIB_LABDIP_LAB_REF");
   }
   return iso;
 }
 public exgui.ultratable.PagedDataFactory getPagedDataFactory(){
   newtimes.preproduction.process.DB_PreProdColorLib db=
       newtimes.preproduction.process.DB_PreProdColorLib.getInstance();
   db.setToRestoreOrNot(db.TO_LIST_FOR_RESTORE);
   myHandler=db;
   return db;
 }
 public database.datatype.Record setObject2Record(database.datatype.Record rec,int columnAt,Object Obj){
   Boolean blValue=(Boolean)Obj;
   try{
     if (blValue.booleanValue()) {
       rec.set("record_delete_flag", "1");
     }
     else {
       rec.set("record_delete_flag", "0");
     }
   }catch(Exception e){
     e.printStackTrace();
   }
   checked=true;
   return rec;
 }
 public void doUpdate()throws Exception{
    try{
      newtimes.production.ProdMaintain_Properties.setWaitCursor();
      super.doUpdate();
    }finally{
      newtimes.production.ProdMaintain_Properties.setNormalCursor();
    }
   //processhandler.template.Properties.getCenteralControler().goBack();
 }
 public void refineEditors(exgui.ultratable.MultiEditorJTable multiEditorJTableInSuper){
   multiEditorJTableInSuper.addCheckbox(0,"1");
 }
}