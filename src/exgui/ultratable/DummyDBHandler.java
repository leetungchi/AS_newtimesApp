package exgui.ultratable;
import database.datatype.Record;
import java.util.*;
/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class DummyDBHandler implements PagedDataFactory {
  protected util.InsertionOrderedHashMap dummyDatas=
      new util.InsertionOrderedHashMap();
  protected util.InsertionOrderedHashMap deletedDummyDatas=
      new util.InsertionOrderedHashMap();
  protected Record blankRec;
  protected String[] pkColumns;
  protected int recColumnsCount=0;
  public DummyDBHandler() {
    //user have to generate blank record,from remote interface or serialized data


  }
  public Vector  getRecords(int startPosition,int rowCounts)throws Exception{
      Set keys=dummyDatas.keySet();
      Object keyArr[]=keys.toArray();
      Vector vct2return=new Vector();
      //according to habit of pagedDataFactory usage, row position is base from "1",not zero,
      for(int i=startPosition-1;i<(startPosition-1+rowCounts);i++){
        if(i==keyArr.length)break;//out of bound
        Record rec=(Record)dummyDatas.get(keyArr[i]);
        vct2return.add(rec);
      }
      return vct2return;
  }
  public void InitByOrgData(Vector recordsToFilled)throws Exception{
    dummyDatas.clear();
    deletedDummyDatas.clear();
    for(int i=0;i<recordsToFilled.size();i++){
       Record rec=(Record)recordsToFilled.get(i);
       if(i==0 && pkColumns==null) initpkColumns(rec);
       dummyDatas.put(getPKObj(rec),rec);
    }
  }
  public void setPkColumns(String pk[]){pkColumns=pk;}
  public void setPkColumns(String pk){
      pkColumns=new String[1];
      pkColumns[0]=pk;
  }
  public void deleteRecord(Record rec2delete)throws Exception{
    //find out the records.set to delete flags
    Record rec=(Record)dummyDatas.remove(getPKObj(rec2delete));
    deletedDummyDatas.put(getPKObj(rec),rec);
  }
  public void restoreRecord(Record rec2restore)throws Exception{
    Record rec=(Record)deletedDummyDatas.remove(getPKObj(rec2restore));
    dummyDatas.put(getPKObj(rec),rec);
  }
  public Record addRecord(Record rec2add)throws Exception{
    if(rec2add==null) rec2add=getBlankRecord();
    for(int i=0;i<pkColumns.length;i++){
      rec2add.set(pkColumns[i],(System.currentTimeMillis()&0xffff)*-1);
    }
    dummyDatas.put(getPKObj(rec2add).toString(),rec2add);
    return rec2add;
  }
  protected String getPKObj(Record rec)throws Exception{
    StringBuffer dataString=new StringBuffer();
    for(int i=0;i<pkColumns.length;i++){
      if(dataString.length()>0)dataString.append("_");
      dataString.append(rec.get(pkColumns[i]).toString());
    }
    return dataString.toString();
  }
  protected void initpkColumns(Record rec){
    Vector pkColumnVct=rec.getPk();
    pkColumns=new String[pkColumnVct.size()];
    for(int i=0;i<pkColumnVct.size();i++){
      pkColumns[i]=(String)pkColumnVct.get(i);
    }
  }

  protected void initpkColumns(){
    initpkColumns(blankRec);
  }
  public Record getBlankRecord()throws Exception{
    if(pkColumns==null)initpkColumns();
    return (Record)util.MiscFunc.deepCopy(blankRec);
  }
  public void updateRecords(Vector recs2update)throws Exception{
   for(int i=0;i<recs2update.size();i++){
     if(i==0){
       recColumnsCount=
           ((Record)recs2update.get(0)).getFieldName().size();
     }
     //find out records stored at hashmap ,remove the old one,update with current value
     Record orgStoredRecord=(Record)dummyDatas.get(getPKObj(((Record)recs2update.get(i))));
     Record dupBlankRec=(Record)util.MiscFunc.deepCopy(orgStoredRecord);
     //because our record object will keep the modified column,we need to force each column modified.
     for(int j=0;j<recColumnsCount;j++){
       dupBlankRec.set(j,orgStoredRecord.get(j));
     }
     dummyDatas.put(getPKObj(dupBlankRec),dupBlankRec);
   }
  }

  public boolean listforRestore(){return false;}
}
