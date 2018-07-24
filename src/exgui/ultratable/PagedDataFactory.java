package exgui.ultratable;
import java.util.*;
import database.datatype.Record;
/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2002</p>
 * <p>Company: </p>
 * @author unascribed
 * @version 1.0
 */

public interface PagedDataFactory {
   public Vector  getRecords(int startPosition,int rowCounts)throws Exception;
   public void deleteRecord(Record rec2delete)throws Exception;
   public void restoreRecord(Record rec2restore)throws Exception;
   public Record addRecord(Record rec2add)throws Exception;
   public Record getBlankRecord()throws Exception;
   public void updateRecords(Vector recs2update)throws Exception;
   public boolean listforRestore();
   //public Vector getRecords4Restore(int startPosition,int rowCounts)throws Exception;
}