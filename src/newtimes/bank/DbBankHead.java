package newtimes.bank;

import exgui.ultratable.PagedDataFactoryAdapter;
import java.util.*;
import database.datatype.Record;
/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class DbBankHead extends PagedDataFactoryAdapter {
  static int QRY_LIST_BEGIN_ROW;
  public DbBankHead() {
    try{
      newtimesejb.bank.BankFacadeHome ejbHome=(newtimesejb.bank.BankFacadeHome)
          info_ejb.WeblogicServiceLocator.locateServiceHome(
          util.PublicVariable.SERVER_URL,"newtimesejb.bank.BankFacade");
       newtimesejb.bank.BankFacade _ejb=ejbHome.create();
       super.ejb=_ejb;
       super.blankRecord=_ejb.getBlankRecord();
       blankRecord.set(1,"E");
       blankRecord.set(2,"C");
       blankRecord.set("record_create_user",util.PublicVariable.USER_RECORD.get(0));
       blankRecord.set(0,-1);//this is flag ,if pk is negtive,means to insert.
    }catch(Exception exp){
       exp.printStackTrace();
       util.ExceptionLog.exp2File(exp,"");
    }
  }
  public void updateRecords(java.util.Vector vct)throws Exception{
    newtimesejb.bank.BankFacadeHome ejbHome=(newtimesejb.bank.BankFacadeHome)
        info_ejb.WeblogicServiceLocator.locateServiceHome(
        util.PublicVariable.SERVER_URL,"newtimesejb.bank.BankFacade");
     newtimesejb.bank.BankFacade _ejb=ejbHome.create();
     _ejb.updateRecords(vct);
  }
  public java.util.Vector getRecords(int bgn,int rowcount)throws Exception{
    String BANK_QRY_STRING=(String)conditions.get("BANK_QRY_STRING");
    if(BANK_QRY_STRING!=null){
      return exgui2.CONST.BASIC_MAIN_EJB.getDatas(
        util.PublicVariable.USER_RECORD,
       BANK_QRY_STRING,bgn,rowcount);
    }else{
      return super.getRecords(bgn,rowcount);
    }
   //return super.getRecords(bgn,rowcount);
    /*
    return exgui2.CONST.BASIC_MAIN_EJB.getDatas(
      util.PublicVariable.USER_RECORD,
     "select * from BANK_HEAD where record_delete_flag='1'",1,9999);*/
  }
}
