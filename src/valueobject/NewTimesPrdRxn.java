package valueobject;
import database.*;
import database.datatype.*;
/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2002</p>
 * <p>Company: </p>
 * @author unascribed
 * @version 1.0
 */

public class NewTimesPrdRxn extends RelationFactoryImp {
  public NewTimesPrdRxn(TableInterface tf) {
    super(tf);
  }
  protected void killRealRecord(Record rec)throws Exception{
     //TableInterface tempTable=new CommonTable(rec.getSrcTableName(),_table.getDataBase(),pk2Field(rec.getPk()));
     TableInterface tempTable=getTable(rec);
     rec.set("delete_flag",0);
     tempTable.updateRecord(rec);
  }
}