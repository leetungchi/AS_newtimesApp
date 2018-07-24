package newtimes.material;

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

public class MtrHistDataFactory implements PagedDataFactory {
  private java.util.HashMap condition = null;
  protected static java.util.Vector buyer4MtrlHistory=new java.util.Vector();
  private int currentMtlDtlSeq=0;
  Record blankRec=null;
  public MtrHistDataFactory(java.util.HashMap hm) {
    condition=hm;
    if(condition.get("MTR_DTL_PK")!=null){
      currentMtlDtlSeq=Integer.parseInt(condition.get("MTR_DTL_PK").toString());
    }
    try{
      blankRec = exgui2.CONST.Material_Hist_EJB.getBlankRecord();
    }catch(Exception e){
      e.printStackTrace();
      util.ExceptionLog.exp2File(e,"error while initialize MtrHisDataFactory");
      exgui.verification.VerifyLib.showAlert(
      "Error in initializing MtrHisDataFactory\nPlease Contact System Manager",
      "Error!!");
    }
  }
  public static java.util.Vector getBuyers(){
    try{
      if (buyer4MtrlHistory.size()==0){
        //buyer4MtrlHistory.addAll(exgui2.CONST.Material_Hist_EJB.getBuyers((String)util.PublicVariable.OPERATTING_CENTER));
        java.util.Vector vct=exgui2.CONST.Material_Hist_EJB.getBuyers(util.PublicVariable.OPERATTING_CENTER);
        for(int i=0;i<vct.size();i++){
          buyer4MtrlHistory.add(vct.get(i));
        }
      }
        //buyer4MtrlHistory.addAll(exgui2.CONST.Material_Hist_EJB.getBuyers());
    }catch(Exception e){
      e.printStackTrace();
      exgui.verification.VerifyLib.showAlert("Error In Getting Buyers",
                                             "Error In Getting Buyers");
    }
    return buyer4MtrlHistory;
  }
  public void setCurrentMtlDtlSeq(int seq){currentMtlDtlSeq=seq;}
  public Vector getRecords(int startPosition, int rowCounts) throws Exception {
    condition.put("MTR_DTL_PK",new Integer(currentMtlDtlSeq));
    return exgui2.CONST.Material_Hist_EJB.getRecords(startPosition, rowCounts, condition);
  }
  public void deleteRecord(Record rec2delete) throws Exception {
    exgui2.CONST.Material_Hist_EJB.deleteRecord(rec2delete);
  }

  public void restoreRecord(Record rec2restore) throws Exception {
    /**@todo Implement this exgui.ultratable.PagedDataFactory method*/
    throw new java.lang.UnsupportedOperationException("Method restoreRecord() not yet implemented.");
  }
  public Record addRecord(Record rec2add) throws Exception {
    rec2add.set("MTR_DTL_PK",currentMtlDtlSeq);
    exgui2.CONST.Material_Hist_EJB.insertRecord(rec2add);
    return rec2add;
  }
  public Record getBlankRecord() throws Exception {
    Record rec2use=(Record)util.MiscFunc.deepCopy(blankRec);
    rec2use.set("MTR_DTL_PK",currentMtlDtlSeq);
    rec2use.set("record_create_user",util.PublicVariable.USER_RECORD.get("usr_code"));
    return rec2use;
  }
  public void updateRecords(Vector recs2update) throws Exception {
    exgui2.CONST.Material_Hist_EJB.updateRecords(recs2update);
  }
  public boolean listforRestore() {
    /**@todo Implement this exgui.ultratable.PagedDataFactory method*/
    throw new java.lang.UnsupportedOperationException("Method listforRestore() not yet implemented.");
  }

}
