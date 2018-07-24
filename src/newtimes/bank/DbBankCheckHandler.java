package newtimes.bank;

import exgui.ultratable.PagedDataFactoryAdapter;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class DbBankCheckHandler extends PagedDataFactoryAdapter {
  public DbBankCheckHandler() {
    try{
      newtimesejb.bank.BankCheckFacadeHome  ejbHome=(newtimesejb.bank.BankCheckFacadeHome)
          info_ejb.WeblogicServiceLocator.locateServiceHome(
          util.PublicVariable.SERVER_URL,"newtimesejb.bank.BankCheckFacade");
       newtimesejb.bank.BankCheckFacade _ejb=ejbHome.create();
       super.ejb=_ejb;
       super.blankRecord=_ejb.getBlankRecord();
       blankRecord.set("record_create_user",util.PublicVariable.USER_RECORD.get(0));
       blankRecord.set(0,-1);//this is flag ,if pk is negtive,means to insert.
    }catch(Exception exp){
       exp.printStackTrace();
       util.ExceptionLog.exp2File(exp,"");
    }
  }
  public void updateRecords(java.util.Vector vct)throws Exception{
    newtimesejb.bank.BankCheckFacadeHome  ejbHome=(newtimesejb.bank.BankCheckFacadeHome)
        info_ejb.WeblogicServiceLocator.locateServiceHome(
        util.PublicVariable.SERVER_URL,"newtimesejb.bank.BankCheckFacade");
     newtimesejb.bank.BankCheckFacade _ejb=ejbHome.create();
     _ejb.updateRecords(vct);
  }


  public java.util.Vector getRecords(int bgn,int rowcount)throws Exception{
    String sql=(String)conditions.get("BANK_CHK_DTL_QRY_STRING");
    if(sql==null){
      return getRecords(bgn,rowcount);
    }else{
      return exgui2.CONST.BASIC_MAIN_EJB.getDatas(
        util.PublicVariable.USER_RECORD,
       sql,bgn,rowcount);
    }
    /*
    return exgui2.CONST.BASIC_MAIN_EJB.getDatas(
      util.PublicVariable.USER_RECORD,
     "select * from BANK_CHK_DETAIL where record_delete_flag='1'",1,9999);
   */
  }


}
