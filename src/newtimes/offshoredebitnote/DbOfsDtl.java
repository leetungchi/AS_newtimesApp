package newtimes.offshoredebitnote;

import exgui.ultratable.PagedDataFactoryAdapter;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class DbOfsDtl extends PagedDataFactoryAdapter {
  public DbOfsDtl() {
    try{
      newtimesejb.bank.OffShoreFacadeHome   _ejbHome=(newtimesejb.bank.OffShoreFacadeHome)
          info_ejb.WeblogicServiceLocator.locateServiceHome(
          util.PublicVariable.SERVER_URL,"newtimesejb.bank.OffShoreFacade");
       newtimesejb.bank.OffShoreFacade _ejb=_ejbHome.create();
       super.ejb=_ejb;
       super.blankRecord=ejb.getBlankRecord();
       blankRecord.set("record_create_user",util.PublicVariable.USER_RECORD.get(0));
       blankRecord.set(0,-1);//this is flag ,if pk is negtive,means to insert.
    }catch(Exception exp){
       exp.printStackTrace();
       util.ExceptionLog.exp2File(exp,"");
    }
  }
  public void updateRecords(java.util.Vector vct)throws Exception {
    newtimesejb.bank.OffShoreFacadeHome   _ejbHome=(newtimesejb.bank.OffShoreFacadeHome)
        info_ejb.WeblogicServiceLocator.locateServiceHome(
        util.PublicVariable.SERVER_URL,"newtimesejb.bank.OffShoreFacade");
     newtimesejb.bank.OffShoreFacade _ejb=_ejbHome.create();
     _ejb.updateRecords(vct);
  }
  public java.util.Vector getRecords(int bgn,int rowcount)throws Exception{
    String sql=Constants.SQL4QRY;
    if(sql==null){
      return getRecords(bgn,rowcount);
    }else{
      return exgui2.CONST.BASIC_MAIN_EJB.getDatas(
        util.PublicVariable.USER_RECORD,
       sql,bgn,rowcount);
    }
  }
}
