package exgui.ultratable;
import java.util.Vector;
import java.util.HashMap;
import database.datatype.Record;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */
public class PagedDataFactoryAdapter implements PagedDataFactory{
  protected boolean xntRestoreFlag=false;
  protected basepkg.CommonDBHandler ejb;
  protected database.datatype.Record blankRecord;
  protected HashMap conditions;
  public final boolean TO_LIST_FOR_RESTORE=true;
  public final boolean TO_LIST_FOR_NORMAL=false;
  /**
   * client class should assign the ejb--basepkg.CommonDBHandler ejb
   * and conditions at constructor
   */
  public PagedDataFactoryAdapter() {
  }
  public Record getRecordByPk(int pk)throws Exception{
    return ejb.findBypk(pk);
  }
  public Record getRecordByPk(long pk)throws Exception{
    return ejb.findBypk(pk);
  }
  public Record getRecordByPk(String pk)throws Exception{
   return ejb.findBypk(pk);
  }

  public Record getRecordByPk(Vector pk)throws Exception{
    return ejb.findBypk(pk);
  }

  public void setRemoteDBHandlerInterface(basepkg.CommonDBHandler _remoteIntf){
    ejb=_remoteIntf;
  }
  public void setConditions(HashMap _conditions){
    conditions=_conditions;
  }
  public void setToRestoreOrNot(boolean toRestore){
    xntRestoreFlag=toRestore;
  }
  public Vector  getRecords(int startPosition,int rowCounts)throws Exception{
   return ejb.getRecords(startPosition,rowCounts,conditions);
  }
  public void deleteRecord(Record rec2delete)throws Exception{
    rec2delete.set("record_modify_user",util.PublicVariable.USER_RECORD.get("usr_code"));
    ejb.deleteRecord(rec2delete);
  }
  public void restoreRecord(Record rec2restore)throws Exception{
    rec2restore.set("record_delete_flag","1");
    ejb.updateRecord(rec2restore);
  }
  public Record addRecord(Record rec2add)throws Exception{
    if(rec2add==null)
      rec2add=getBlankRecord();
    return ejb.insertRecord(rec2add);
  }
  public Record getBlankRecord()throws Exception{
    Record rec=(Record)util.MiscFunc.deepCopy(blankRecord);
     rec.set("record_create_user"
                   ,util.PublicVariable.USER_RECORD.get("usr_code"));
    return rec;
  }
  public void updateRecords(Vector recs2update)throws Exception{
    if(recs2update==null||recs2update.size()==0)return;
    for(int i=0;i<recs2update.size();i++){
      Record rec=(Record)recs2update.get(i);
      rec.set("record_modify_user",util.PublicVariable.USER_RECORD.get("usr_code"));
    }
    ejb.updateRecords(recs2update);
  }
  public boolean listforRestore(){
     return xntRestoreFlag;
  }

}
