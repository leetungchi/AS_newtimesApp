package newtimes.shipping_admin.ShipPrxQty;
import java.util.*;
import processhandler.template.PnlTableEditor;
import exgui.ultratable.*;
import database.datatype.*;
import util.InsertionOrderedHashMap;
import processhandler.*;
import java.util.Hashtable;
import processhandler.template.PnlTableEditor;
import exgui.ultratable.*;
import database.datatype.*;
import util.InsertionOrderedHashMap;
import processhandler.*;
import java.util.Hashtable;
import java.awt.*;
import javax.swing.*;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class PnlPoDetailForLauren extends PnlTableEditor{
  public static int sty_seq;
  public static String sizeString=null;
  static String  COLUMN_COLOR_CODE=   "COLOR\nCODE";
  static int COLUMN_COLOR_CODE_AT=0;
  static String  COLUMN_COLOR_DESC=   "COLOR\nNAME";
  static int COLUMN_COLOR_NAME_AT=1;

  static String  COLUMN_BUYER_ACT_PRX=" Act.";
  static int COLUM_BUYER_ACT_PRX_AT=0;static int COLUM_BUYER_DOC_PRX_AT=0;
  static int COLUM_MAKER_ACT_PRX_AT=0;static int COLUM_MAKER_DOC_PRX_AT=0;
  static String  COLUMN_BUYER_DOC_PRX=" Doc.";
  static String  COLUMN_MAKER_ACT_PRX="Act. ";
  static String  COLUMN_MAKER_DOC_PRX="Doc. ";
  static int COLUMN_QTY_1_AT=0;
  static String  COLUMN_SIZE_QTY_TOTAL=" TOTAL ";
  public PnlPoDetailForLauren() {
    super();
    getPanelContainsButtons().removeAll();

  }
  protected InsertionOrderedHashMap getHeadColumnMap() {
  util.InsertionOrderedHashMap iso=new util.InsertionOrderedHashMap();

  iso.put(COLUMN_COLOR_CODE,"PROD_COLOR_CODE");
  iso.put(COLUMN_COLOR_DESC,"PROD_COLOR_NAME");

  COLUM_BUYER_DOC_PRX_AT=iso.entrySet().size();
  iso.put(COLUMN_BUYER_DOC_PRX,"PRI_BYR_DOC_PRX");

  COLUM_BUYER_ACT_PRX_AT=iso.entrySet().size();
  iso.put(COLUMN_BUYER_ACT_PRX,"PRI_BYR_ACT_PRX");

  COLUM_MAKER_DOC_PRX_AT=iso.entrySet().size();
  iso.put(COLUMN_MAKER_DOC_PRX,"PRI_MKR_DOC_PRX");

  COLUM_MAKER_ACT_PRX_AT=iso.entrySet().size();
  iso.put(COLUMN_MAKER_ACT_PRX,"PRI_MKR_ACT_PRX");
  if(sizeString.indexOf(",,")!=-1){
    String strSize[] = util.MiscFunc.split(sizeString, ",,");
    for (int i = 0; i < strSize.length; i++) {
      iso.put(strSize[i], "qty_" + String.valueOf(i + 1));
    }
  }

  iso.put(COLUMN_SIZE_QTY_TOTAL,"qty_ttl");
  return iso;
}

  public void doPrint() throws java.lang.Exception {
    /**@todo Implement this processhandler.DataProcesser abstract method*/
  }
  protected int getEachPageRowCount() {
    /**@todo Implement this exgui.ultratable.AbstractUltraTablePanel abstract method*/
    //throw new java.lang.UnsupportedOperationException("Method getEachPageRowCount() not yet implemented.");
    return 999;
  }
  public PagedDataFactory getPagedDataFactory(){
    return new MyDb();
  }
  protected Record setObject2Record(Record rec, int columnAt, Object value2update) {
    return null;
  }
  protected void refineEditors(MultiEditorJTable multiEditorJTableInSuper) {
    /**@todo Implement this exgui.ultratable.AbstractUltraTablePanel abstract method*/

     multiEditorJTableInSuper.setTableColumn2Grp("BUYER Prx",2);
     multiEditorJTableInSuper.setTableColumn2Grp("BUYER Prx",3);
     multiEditorJTableInSuper.setTableColumn2Grp("MAKER Prx",4);
     multiEditorJTableInSuper.setTableColumn2Grp("MAKER Prx",5);

     multiEditorJTableInSuper.setTextEditorVerifiers(getObject2StringConvertor());
     ((exgui.MultiClassTableModel)multiEditorJTableInSuper.getJTable().getModel()).removeAllEditableColumn();
  }
  protected Hashtable getObject2StringConvertor() {
     return new Hashtable();
  }


  class MyDb extends exgui.ultratable.PagedDataFactoryAdapter{
    public Vector getRecords(int bgn,int rowcount)throws Exception{
      StringBuffer sb=new StringBuffer();
      sb.append("select ");
      sb.append("  a.PRI_SEQ,  ");
      sb.append("  a.PRI_STY_SEQ,  ");
      sb.append("  a.PROD_COLOR_PK,  ");
      sb.append("  (select PROD_COLOR_CODE from prod_color where prod_color_pk=a.PROD_COLOR_PK) as prod_color_code,  ");
      sb.append("  (select PROD_COLOR_name from prod_color where prod_color_pk=a.PROD_COLOR_PK) as prod_color_name, ");
      sb.append("a.PRI_BYR_ACT_PRX, ");
      sb.append("a.PRI_BYR_DOC_PRX, ");
      sb.append("a.PRI_MKR_ACT_PRX,  ");
      sb.append("a.PRI_MKR_DOC_PRX, ");

      sb.append("(select qty.QTY_QTY+trunc((qty_pcs*(100/12 + 0.01)))*0.01 from qty where qty.PRI_SEQ=a.PRI_SEQ and (QTY_SIZE_SEQ=1 or qty_size_seq is null)) as qty_1,  ");
      sb.append("  (select qty.QTY_QTY+trunc((qty_pcs*(100/12 + 0.01)))*0.01 from qty where qty.PRI_SEQ=a.PRI_SEQ and (QTY_SIZE_SEQ=2 )) as qty_2,  ");
      sb.append("  (select qty.QTY_QTY+trunc((qty_pcs*(100/12 + 0.01)))*0.01 from qty where qty.PRI_SEQ=a.PRI_SEQ and (QTY_SIZE_SEQ=3 )) as qty_3,  ");
      sb.append("  (select qty.QTY_QTY+trunc((qty_pcs*(100/12 + 0.01)))*0.01 from qty where qty.PRI_SEQ=a.PRI_SEQ and (QTY_SIZE_SEQ=4 )) as qty_4,  ");
      sb.append("  (select qty.QTY_QTY+trunc((qty_pcs*(100/12 + 0.01)))*0.01 from qty where qty.PRI_SEQ=a.PRI_SEQ and (QTY_SIZE_SEQ=5 )) as qty_5,  ");
      sb.append("  (select qty.QTY_QTY+trunc((qty_pcs*(100/12 + 0.01)))*0.01 from qty where qty.PRI_SEQ=a.PRI_SEQ and (QTY_SIZE_SEQ=6 )) as qty_6,  ");
      sb.append("  (select qty.QTY_QTY+trunc((qty_pcs*(100/12 + 0.01)))*0.01 from qty where qty.PRI_SEQ=a.PRI_SEQ and (QTY_SIZE_SEQ=7 )) as qty_7,  ");
      sb.append("  (select qty.QTY_QTY+trunc((qty_pcs*(100/12 + 0.01)))*0.01 from qty where qty.PRI_SEQ=a.PRI_SEQ and (QTY_SIZE_SEQ=8 )) as qty_8,  ");
      sb.append("  (select qty.QTY_QTY+trunc((qty_pcs*(100/12 + 0.01)))*0.01 from qty where qty.PRI_SEQ=a.PRI_SEQ and (QTY_SIZE_SEQ=9 )) as qty_9,  ");
      sb.append("  (select qty.QTY_QTY+trunc((qty_pcs*(100/12 + 0.01)))*0.01 from qty where qty.PRI_SEQ=a.PRI_SEQ and (QTY_SIZE_SEQ=10 )) as qty_10,  ");
      sb.append("  (select qty.QTY_QTY+trunc((qty_pcs*(100/12 + 0.01)))*0.01 from qty where qty.PRI_SEQ=a.PRI_SEQ and (QTY_SIZE_SEQ=11 )) as qty_11,  ");
      sb.append("  (select qty.QTY_QTY+trunc((qty_pcs*(100/12 + 0.01)))*0.01 from qty where qty.PRI_SEQ=a.PRI_SEQ and (QTY_SIZE_SEQ=12 )) as qty_12,  ");
      sb.append("  (select qty.QTY_QTY+trunc((qty_pcs*(100/12 + 0.01)))*0.01 from qty where qty.PRI_SEQ=a.PRI_SEQ and (QTY_SIZE_SEQ=13 )) as qty_13,  ");
      sb.append("  (select qty.QTY_QTY+trunc((qty_pcs*(100/12 + 0.01)))*0.01 from qty where qty.PRI_SEQ=a.PRI_SEQ and (QTY_SIZE_SEQ=14 )) as qty_14,  ");
      sb.append("  (select qty.QTY_QTY+trunc((qty_pcs*(100/12 + 0.01)))*0.01 from qty where qty.PRI_SEQ=a.PRI_SEQ and (QTY_SIZE_SEQ=15 )) as qty_15,  ");

      sb.append("  (select qty.QTY_QTY+trunc((qty_pcs*(100/12 + 0.01)))*0.01 from qty where qty.PRI_SEQ=a.PRI_SEQ and (QTY_SIZE_SEQ=16 )) as qty_16,  ");
      sb.append("  (select qty.QTY_QTY+trunc((qty_pcs*(100/12 + 0.01)))*0.01 from qty where qty.PRI_SEQ=a.PRI_SEQ and (QTY_SIZE_SEQ=17 )) as qty_17,  ");
      sb.append("  (select qty.QTY_QTY+trunc((qty_pcs*(100/12 + 0.01)))*0.01 from qty where qty.PRI_SEQ=a.PRI_SEQ and (QTY_SIZE_SEQ=18 )) as qty_18,  ");
      sb.append("  (select qty.QTY_QTY+trunc((qty_pcs*(100/12 + 0.01)))*0.01 from qty where qty.PRI_SEQ=a.PRI_SEQ and (QTY_SIZE_SEQ=19 )) as qty_19,  ");
      sb.append("  (select qty.QTY_QTY+trunc((qty_pcs*(100/12 + 0.01)))*0.01 from qty where qty.PRI_SEQ=a.PRI_SEQ and (QTY_SIZE_SEQ=20 )) as qty_20,  ");
      sb.append("  (select qty.QTY_QTY+trunc((qty_pcs*(100/12 + 0.01)))*0.01 from qty where qty.PRI_SEQ=a.PRI_SEQ and (QTY_SIZE_SEQ=21)) as qty_21,  ");
      sb.append("  (select qty.QTY_QTY+trunc((qty_pcs*(100/12 + 0.01)))*0.01 from qty where qty.PRI_SEQ=a.PRI_SEQ and (QTY_SIZE_SEQ=22 )) as qty_22,  ");
      sb.append("  (select qty.QTY_QTY+trunc((qty_pcs*(100/12 + 0.01)))*0.01 from qty where qty.PRI_SEQ=a.PRI_SEQ and (QTY_SIZE_SEQ=23 )) as qty_23,  ");
      sb.append("  (select qty.QTY_QTY+trunc((qty_pcs*(100/12 + 0.01)))*0.01 from qty where qty.PRI_SEQ=a.PRI_SEQ and (QTY_SIZE_SEQ=24 )) as qty_24, ");


      sb.append("  GET_ORDER_QTY_BY_PRICE_STY(a.PRI_STY_SEQ,a.PRI_SEQ) as qty_ttl,  ");
      sb.append("  '1' as record_delete_flag,  ");
      sb.append("  a.record_create_date,  ");
      sb.append("  a.record_create_user,  ");
      sb.append("  a.record_modify_date,  ");
      sb.append("  null record_modify_user  ");
      sb.append("  from price a  ");
      sb.append("  where  ");
      sb.append("  a.record_delete_flag='1'  ");
      sb.append("  and pri_sty_seq=");sb.append(String.valueOf(sty_seq));
      sb.append(" order by pri_seq ");
      return exgui2.CONST.BASIC_MAIN_EJB.getDatas(
        util.PublicVariable.USER_RECORD,
        sb.toString(),1,999999
      );

    }
  }
}
