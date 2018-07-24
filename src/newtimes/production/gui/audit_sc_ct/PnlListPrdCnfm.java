package newtimes.production.gui.audit_sc_ct;

import processhandler.template.PnlTableEditor;
import exgui.ultratable.*;
import database.datatype.*;
import util.InsertionOrderedHashMap;
import processhandler.*;
import java.util.Hashtable;

public class PnlListPrdCnfm extends PnlTableEditor
    implements java.awt.event.MouseListener  {
  public static String prod_status_code[]={"N/A",
                                    "Editig",
                                    "Wait\nConfirm",
                                    "Confirmed",
                                    "Reject",
                                    "Printed"};
  public PnlListPrdCnfm() {
  }
  protected Record setObject2Record(Record rec, int columnAt, Object value2update) {
    /**@todo Implement this exgui.ultratable.AbstractUltraTablePanel abstract method*/
    return null;
  }
  protected InsertionOrderedHashMap getHeadColumnMap() {
   /*
    select a.PROD_HEAD_PK,
    (select b.CEN_NAME from center b where b.CEN_CODE=a.PROD_CEN_CODE) as j_cen,
    PROD_DEPTMENT as dep_code,
    (select c.DEP_ABBR from department c where c.DEP_CODE=a.PROD_DEPTMENT) as j_dep,
    a.PROD_YEAR,(select d.SEA_NAME from season d where d.SEA_NAME=a.PROD_SEASON) as j_sea,
    PROD_FIRST_MTR_NO(a.PROD_HEAD_PK) as mtr_no,
    (select e.DIV_NAME from division e where e.DIV_CODE=a.PROD_BUYER_DIVISION) as j_div,
    (select f.BYMKR_BRIEF from buyer_maker f where f.BYMKR_SEQ=a.PROD_BUYER) as j_buyer,
    (select g.BYMKR_BRIEF from buyer_maker g where g.BYMKR_SEQ=a.PROD_MAKER) as j_maker,
    a.prod_range,a.prod_group,a.prod_group_name,Pdsn.PROD_SC_NO,Pdsn.PROD_AUDIT_STATUS,
    pprod.preprod_proto_no
   */
    InsertionOrderedHashMap iso=new InsertionOrderedHashMap();
    iso.put("CENTER","j_cen");
    iso.put("DEPARTMENT","j_dep");
    iso.put("YEAR","PROD_YEAR");
    iso.put("SEASON","j_sea");
    iso.put("DIV","j_div");
    iso.put("FTY","j_maker");
    iso.put("RANGE","prod_range");
    iso.put("S/C No.","PROD_SC_NO");
    iso.put("GRP No.","prod_group");
    iso.put("GRP Name.","PROD_GROUP_NAME");
    iso.put("PROTO","PREPROD_PROTO_NO");
    iso.put("MTR-NO","mtr_no");
    iso.put("STATUS","PROD_AUDIT_STATUS");
    return iso;
  }
  public void doPrint() throws java.lang.Exception {
    /**@todo Implement this processhandler.DataProcesser abstract method*/
  }
  public void mouseClicked(java.awt.event.MouseEvent  e){
    //
    //get row data,
    if(getJtable().getSelectedRow()==-1)return;
    try{
      this.setCursor(new java.awt.Cursor(java.awt.Cursor.WAIT_CURSOR));
      util.ApplicationProperites.setProperties("newtimes.production.gui.audit_sc_ct.PnlListPrdCnfm.PagePageRowAt"
                                                  ,new Integer(this._rowPosition));
      newtimes.production.ProdMaintain_Properties.PRODUCTION_AUDIT_STATUS_COLUMN_NAME="PROD_AUDIT_STATUS";
      newtimes.preproduction.Constants.CURRENT_PREPROD_HEAD_RECORD=
          (Record)getDisplayingRecords().get(getJtable().getSelectedRow());
      newtimes.preproduction.Constants.CURRENT_PREPROD_HEAD_PK=
          newtimes.preproduction.Constants.CURRENT_PREPROD_HEAD_RECORD.getInt(0);
      processhandler.template.Properties.getCenteralControler().doCommandExecute(
      new newtimes.production.process.audit_sc_ct.TgrToEditAudit());
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

  protected void refineEditors(MultiEditorJTable multiEditorJTableInSuper) {
    /**@todo Implement this exgui.ultratable.AbstractUltraTablePanel abstract method*/
    multiEditorJTableInSuper.setTextEditorVerifiers(getObject2StringConvertor());
    ((exgui.MultiClassTableModel)getJtable().getModel()).removeAllEditableColumn();
    getJtable().addMouseListener(this);
  }

  protected int getEachPageRowCount() {
    /**@todo Implement this exgui.ultratable.AbstractUltraTablePanel abstract method*/
    return 5;
  }
  protected void makeTable(java.util.Vector vct){
    super.makeTable(vct,false);
  }
  public boolean isContextModified(){return false;}
  protected Hashtable getObject2StringConvertor() {
    /**@todo Implement this exgui.ultratable.AbstractUltraTablePanel abstract method*/
   Hashtable ht=new Hashtable();
   ht.put("STATUS",new ProdStatusConv());
   return ht;
  }
  protected PagedDataFactory getPagedDataFactory() {
    /**@todo Implement this exgui.ultratable.AbstractUltraTablePanel abstract method*/
    newtimes.production.process.audit_sc_ct.DB_ProdCnfm Handler=
        new newtimes.production.process.audit_sc_ct.DB_ProdCnfm();
    if(!Handler.isInitOk())return null;
    dbHandler=Handler;
    return Handler;
  }
  public class ProdStatusConv implements exgui.Object2String,exgui.ultratable.CellTxtEditorFormat {
    public String Obj2String(Object valueObj){
      if(valueObj==null) return "N/A";
      return prod_status_code[Integer.parseInt(valueObj.toString())];
    }
    public Object cellStringToObject(String str){
      return null;
    }
    public exgui.ultratable.KeyProcess getKeyListener(){
      return null;
    }
    public int getMaxLength(){return 20;}
    public boolean isFormatValid(String str,int row,int col){return true;}
    public String formatPromptMsg(){
      return null;
    }
  }

}
