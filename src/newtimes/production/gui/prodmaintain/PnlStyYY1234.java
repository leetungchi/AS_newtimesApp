package newtimes.production.gui.prodmaintain;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Vector;
import exgui.ultratable.MultiEditorJTable;
import util.InsertionOrderedHashMap;
/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class PnlStyYY1234 extends PnlStyMiscList {
  static String DISP_STY_NO="STYLE NO";
  static String DB_STY_NO="STY_STYLE";
  static String DISP_STY_PO="PO";
  static String DB_STY_PO="STY_PO";
  static String DISP_STY_YY1="YY1";
  static String DB_STY_YY1="STY_YY1";
  static String DISP_STY_YY2="YY2";
  static String DB_STY_YY2="STY_YY2";
  static String DISP_STY_YY3="YY3";
  static String DB_STY_YY3="STY_YY3";
  static String DISP_STY_YY4="YY4";
  static String DB_STY_YY4="STY_YY4";

  public PnlStyYY1234() {
  }
  protected InsertionOrderedHashMap getHeadColumnMap() {
    InsertionOrderedHashMap iso = new InsertionOrderedHashMap();
    iso.put(DISP_STY_NO, DB_STY_NO);//0
    iso.put(DISP_STY_PO, DB_STY_PO);//1
    //STY_YY1, STY_YY2, STY_YY3
    iso.put(DISP_STY_YY1,DB_STY_YY1);//7
    iso.put(DISP_STY_YY2,DB_STY_YY2);//8
    iso.put(DISP_STY_YY3,DB_STY_YY3);//9
    iso.put(DISP_STY_YY4,DB_STY_YY4);//10
    return iso;
  }
  protected void refineEditors(MultiEditorJTable multiEditorJTableInSuper) {
    try{
      multiEditorJTableInSuper.setTextEditorVerifiers(getObject2StringConvertor());
      hookInRefineEditor(multiEditorJTableInSuper);
    }catch(Exception e){
      e.printStackTrace();
    }
  }
  protected Hashtable getObject2StringConvertor() {
     Hashtable iso=new Hashtable();
     //STY_YY1, STY_YY2, STY_YY3
     Object DInt1F2=exgui.verification.CellFormat.getDoubleFormatAllowNull(2,3);
     iso.put(DISP_STY_YY1,DInt1F2);
     iso.put(DISP_STY_YY2,DInt1F2);
     iso.put(DISP_STY_YY3,DInt1F2);
     iso.put(DISP_STY_YY4,DInt1F2);
     return iso;
  }



}
