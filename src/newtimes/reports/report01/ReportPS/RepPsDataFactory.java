package newtimes.reports.report01.ReportPS;

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

public class RepPsDataFactory implements PagedDataFactory {
  private ReportEJBs.RepPsEJB.RepPS repPsEJB =
      (ReportEJBs.RepPsEJB.RepPS)util.ApplicationProperites.getProperties("repPsEJB");
  private java.util.HashMap condition = null;
  Record blankRecord=null;
  public RepPsDataFactory(java.util.HashMap hm) {
    try{
      condition = hm;
      blankRecord=repPsEJB.getBlankRecord();
    }catch(Exception exp){
      exp.printStackTrace();
      util.ExceptionLog.exp2File(exp,"");
      exgui.verification.VerifyLib.showAlert("Error While Initializing RepPsDataFactory\nPlease Contact System Manager",
                                             "Error In PS Report List Handler");
    }

  }
  public Vector getRecords(int startPosition, int rowCounts) throws Exception {

    Vector vec= repPsEJB.getRecords(startPosition, rowCounts, condition);
    //Vector newVec = new Vector();
    /*
    for(int i=0;i<vec.size();i++){
      Record rec=(Record)vec.get(i);
      rec.getFieldName().add("RECORD_MODIFY_USER");
      rec.getValueFields().add(null);
      rec.getFieldName().add("RECORD_MODIFY_DATE");
      rec.getValueFields().add(null);
      newVec.add(rec);
    }
    */
    //return newVec;
    return vec;

    //return repPsEJB.getRecords(startPosition, rowCounts, condition);
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
    return (Record)util.MiscFunc.deepCopy(blankRecord);
  }
  public void updateRecords(Vector recs2update) throws Exception {
    repPsEJB.updateRecords(recs2update);
  }
  public boolean listforRestore() {
    /**@todo Implement this exgui.ultratable.PagedDataFactory method*/
    throw new java.lang.UnsupportedOperationException("Method listforRestore() not yet implemented.");
  }

}
