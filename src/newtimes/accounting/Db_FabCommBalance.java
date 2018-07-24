package newtimes.accounting;

import exgui.ultratable.PagedDataFactoryAdapter;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class Db_FabCommBalance extends PagedDataFactoryAdapter {
  String xntuser;
  public Db_FabCommBalance() {
    try{
      newtimesejb.accounting.FabComBalanceFacadeHome  ejbHome=
          (newtimesejb.accounting.FabComBalanceFacadeHome)
          info_ejb.WeblogicServiceLocator.locateServiceHome(
           util.PublicVariable.SERVER_URL,
           "newtimesejb.accounting.FabComBalanceFacade"
          );
      super.ejb=ejbHome.create();
      super.blankRecord =ejb.getBlankRecord();
      xntuser=(String)util.PublicVariable.USER_RECORD.get("USR_CODE");
      super.blankRecord.set("record_create_user",xntuser);
      super.conditions=new java.util.HashMap();
      //super.conditions.put("FAB_PROD_HEAD_PK",new Integer(prodHeadSeq));
      super.conditions.put("record_delete_flag","1");
    }catch(Exception e){
      e.printStackTrace();
      exgui.verification.VerifyLib.showAlert("Server Side Exception\nPlease Notify System Manager",
                                             "Conenction or EJB creation Exception");
    }

  }
  public java.util.Vector getRecords(int bgn,int row)throws Exception {
    AcctFunsConsts.CONDITIONS_QRY_FAB_COMM.put("c.prod_cen_code=",util.PublicVariable.OPERATTING_CENTER);
    return ejb.getRecords(bgn,row,AcctFunsConsts.CONDITIONS_QRY_FAB_COMM);
  }
}
