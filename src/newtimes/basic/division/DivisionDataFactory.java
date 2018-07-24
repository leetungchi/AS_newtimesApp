package newtimes.basic.division;

import exgui.ultratable.PagedDataFactory;
import java.util.Vector;
import database.datatype.Record;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class DivisionDataFactory implements PagedDataFactory {
//  private BasicMdlEJBs.BasicMaintainEJB.BasicMaintainEJB basicMainEJB =
//  (BasicMdlEJBs.BasicMaintainEJB.BasicMaintainEJB)util.ApplicationProperites.getProperties("basicMainEJB");
  static String sql=null;
  private java.util.HashMap hm4Div = null;
  public DivisionDataFactory(java.util.HashMap hm) {
    StringBuffer sb=new StringBuffer();
    sb.append("SELECT DIV_CODE,DIV_NAME,DIV_BYMKR_SEQ,");
    sb.append("DIV_WEIGHT,BYMKR_SEQ,BYMKR_BRIEF,BYMKR_NAME,");
    sb.append("DIVISION.BUY_COMM,");
    sb.append("DIVISION.BUY_COMM_PC,");
    sb.append("DIVISION.BUY_COMM_DZ,");
    sb.append("DIVISION.BUY_COMM_LUMP_SUM,");
    sb.append("DIVISION.MKR_DSCT_PER,");
    sb.append("DIVISION.MKR_DSCT_PC,");
    sb.append("DIVISION.MKR_DSCT_DZ,");
    sb.append("DIVISION.MKR_DSCT_LUMP_SUM, ");
    sb.append("DIVISION.DIV_ADDR ");
    sb.append("FROM DIVISION,BUYER_MAKER ");
    sb.append("WHERE DIVISION.RECORD_DELETE_FLAG = '1' ");
    sb.append("AND DIV_BYMKR_SEQ = BYMKR_SEQ(+) ");
    sb.append("and buyer_maker.SELECTABLE_CENTER like '%,");
    sb.append(util.PublicVariable.OPERATTING_CENTER);
    sb.append(",%'");
    sb.append(" ORDER BY BYMKR_NAME");
    sql=sb.toString();
    hm4Div = hm;
  }
  public Vector getRecords(int startPosition, int rowCounts) throws Exception {
    return exgui2.CONST.BASIC_MAIN_EJB.getDatas(
      util.PublicVariable.USER_RECORD,sql,startPosition,rowCounts);
    //Vector vCenData = exgui2.CONST.BASIC_MAIN_EJB.getDivisionList(startPosition, rowCounts, hm4Div);
    //return vCenData;
  }
  public void deleteRecord(Record rec2delete) throws Exception {
    /**@todo Implement this exgui.ultratable.PagedDataFactory method*/
    throw new java.lang.UnsupportedOperationException("Method deleteRecord() not yet implemented.");
  }
  public void restoreRecord(Record rec2restore) throws Exception {
    /**@todo Implement this exgui.ultratable.PagedDataFactory method*/
    throw new java.lang.UnsupportedOperationException("Method restoreRecord() not yet implemented.");
  }
  public Record addRecord(Record rec2add) throws Exception {
    /**@todo Implement this exgui.ultratable.PagedDataFactory method*/
    throw new java.lang.UnsupportedOperationException("Method addRecord() not yet implemented.");
  }
  public Record getBlankRecord() throws Exception {
    /**@todo Implement this exgui.ultratable.PagedDataFactory method*/
    throw new java.lang.UnsupportedOperationException("Method getBlankRecord() not yet implemented.");
  }
  public void updateRecords(Vector recs2update) throws Exception {
  }
  public boolean listforRestore() {
    /**@todo Implement this exgui.ultratable.PagedDataFactory method*/
    throw new java.lang.UnsupportedOperationException("Method listforRestore() not yet implemented.");
  }

}
