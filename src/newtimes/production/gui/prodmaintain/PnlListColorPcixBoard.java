package newtimes.production.gui.prodmaintain;
import processhandler.template.*;
import java.awt.*;
import javax.swing.JPanel;
import database.datatype.*;
/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class PnlListColorPcixBoard extends  PnlTableEditor{
  public PnlListColorPcixBoard() {
     super();
     super.jbtn1st.setVisible(false);
     super.jbtnLast.setVisible(false);
     super.jbtnNext.setVisible(false);
     super.jbtnPrev.setVisible(false);

  }
  public void doPrint(){}
  public void doUpdate(){
    try{
      super.doUpdate();
    }catch(Exception exp){
      exp.printStackTrace();
      util.ExceptionLog.exp2File(exp,"");
      exgui.verification.VerifyLib.showAlert("Update Failed\nPlease Contact System Manager","Update Failed");
    }
  }
  public void doAddNew(){}
  public exgui.ultratable.PagedDataFactory getPagedDataFactory(){
    Db4PcixBoard dbHandler=new Db4PcixBoard();
    return dbHandler;
  }
  public void refineEditors(exgui.ultratable.MultiEditorJTable me){
    me.setTextEditorVerifiers(getObject2StringConvertor());
  }
  public int getEachPageRowCount(){return 999999;}
  public util.InsertionOrderedHashMap getHeadColumnMap(){
    util.InsertionOrderedHashMap iso=new util.InsertionOrderedHashMap();
    iso.put("STYLE","STY_STYLE");
    iso.put("PO      ","STY_PO");
    iso.put("BUYER\nDoc. Prx","PRI_BYR_ACT_PRX");
    iso.put("BUYER\nAct. Prx","PRI_BYR_DOC_PRX");
    iso.put("MAKER\nDoc. Prx","PRI_MKR_ACT_PRX");
    iso.put("MAKER\nAct. Prx","PRI_MKR_DOC_PRX");
    iso.put("QTY","PRI_TOTAL_QTY");
    iso.put("   COLOR    ","PROD_COLOR_NAME");
    iso.put("   PCIX     ","PCIX");
    iso.put("   BOARD    ","BOARD");
    return iso;
  }
  protected java.util.Hashtable getObject2StringConvertor() {
    java.util.Hashtable ht=new java.util.Hashtable();
    Object chr100Vfy=exgui.verification.CellFormat.getOrdinaryField(100);
    ht.put("   PCIX     ",chr100Vfy);
    ht.put("   BOARD    ",chr100Vfy);
    return ht;
  }

  protected Record setObject2Record(Record rec, int columnAt, Object value2update) {
    try{
      String columnName=storedRecordColumn[columnAt];
      rec.set(columnName,value2update);
      return rec;
    }catch(Exception e){
      e.printStackTrace();
      return null;
    }
  }
  class Db4PcixBoard extends exgui.ultratable.PagedDataFactoryAdapter{
    public Db4PcixBoard(){
    }
    public void updateRecords(java.util.Vector vct2update)throws Exception{
      if(vct2update==null||vct2update.size()==0)return;
      for(int i=0;i<vct2update.size();i++){
        Record rec=(Record)vct2update.get(i);
        rec.set("record_modify_user",util.PublicVariable.USER_RECORD.get("usr_code"));
      }

      NTD_Upload.EdiUploadFacadeHome ejbHome=
          (NTD_Upload.EdiUploadFacadeHome)
          info_ejb.WeblogicServiceLocator.locateServiceHome(util.PublicVariable.SERVER_URL,
          "NTD_Upload.EdiUploadFacade");
      NTD_Upload.EdiUploadFacade ejb=ejbHome.create();
      ejb.updatePcixBoard(vct2update);

    }
    public java.util.Vector getRecords(int bgn,int rowcount)throws Exception{
      StringBuffer sb=new StringBuffer();
      sb.append("select ");
      sb.append("c.prod_color_pk  ");
      sb.append(",b.sty_style ");
      sb.append(",B.STY_PO ");
      sb.append(",A.PRI_BYR_ACT_PRX,A.PRI_BYR_DOC_PRX ");
      sb.append(",A.PRI_MKR_ACT_PRX,A.PRI_MKR_DOC_PRX ");
      sb.append(",get_order_qty_prx_sty_unit(b.sty_seq,b.sty_unit,a.pri_seq) as pri_total_qty ");
      sb.append(",C.PROD_COLOR_CODE ");
      sb.append(",C.PROD_COLOR_NAME ");
      sb.append(",C.PCIX ");
      sb.append(",c.board  ");
      sb.append(",c.record_delete_flag ");
      sb.append(",c.record_create_user ");
      sb.append(",c.record_create_date ");
      sb.append(",c.record_modify_user ");
      sb.append(",c.record_modify_date ");
      sb.append("from  ");
      sb.append("price a,style b,prod_color c ");
      sb.append("where  ");
      sb.append("A.PRI_STY_SEQ  =B.STY_SEQ ");
      sb.append("and b.sty_img is not null ");//this is upload data
      sb.append("and a.prod_color_pk=C.PROD_COLOR_PK ");
      sb.append("and c.prod_head_pk=b.prod_head_pk ");
      sb.append("and a.record_delete_flag='1' ");
      sb.append("and c.record_delete_flag='1' ");
      sb.append("and b.record_delete_flag='1' ");
      sb.append("and b.sty_sc_no='");
      String sc_no=(String)newtimes.preproduction.Constants.CURRENT_PREPROD_HEAD_RECORD.get("prod_sc_no");
      sb.append(sc_no);
      sb.append("' ");
      sb.append("order by pri_sty_seq  ");

      java.util.Vector vct=exgui2.CONST.BASIC_MAIN_EJB.getDatas(
      util.PublicVariable.USER_RECORD,
      sb.toString(),1,9999999);

      return vct;
    }
  }
}
