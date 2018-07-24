package newtimes.preproduction.process;

import exgui.ultratable.PagedDataFactoryAdapter;
import database.datatype.Record;
import java.util.Vector;
/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class DB_FabComm extends PagedDataFactoryAdapter {
  boolean initOK=false;
  int _prodSeq;
  public DB_FabComm(int prodSeq) {
    try{
      _prodSeq=prodSeq;
     newtimesejb.preproduction.FabCommFacadeHome ejbHome=
        (newtimesejb.preproduction.FabCommFacadeHome)info_ejb.WeblogicServiceLocator.locateServiceHome(
        util.PublicVariable.SERVER_URL,"newtimesejb.preproduction.FabCommFacade");
      super.ejb=ejbHome.create();
      super.blankRecord=ejb.getBlankRecord();
      blankRecord.set("record_create_user",util.PublicVariable.USER_RECORD.get("usr_code"));
      blankRecord.set("record_delete_flag","1");
      blankRecord.set("FAB_COMM_UNIT","PC");
      blankRecord.set("FAB_COMM_TYPE","FABRIC");
      blankRecord.set("FAB_COMM_DISCOUNT_KIND",new Integer(1));
      blankRecord.set("FAB_COMM_PROD_PK",_prodSeq);
      blankRecord.set("FAB_COMM_CUR","USD");
      initOK=true;
      super.conditions=new java.util.HashMap();
    }catch(Exception exp){
      exp.printStackTrace();
      util.ExceptionLog.exp2File(exp,"");
      initOK=false;
    }
  }
 boolean isInitOK(){return initOK;}

 public java.util.Vector getRecords(int rowBgn,int rowcount)throws Exception{
        conditions.put("record_delete_flag","1");
        conditions.put("FAB_COMM_PROD_PK",new Integer(_prodSeq));
        return ejb.getRecords(rowBgn,rowcount,conditions);
 }
}
