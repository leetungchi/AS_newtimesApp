package newtimes.basic.area_maintain;

import exgui.ultratable.PagedDataFactoryAdapter;
import database.datatype.Record;
public class DB_AreaHandler extends PagedDataFactoryAdapter {
  BasicMdlEJBs.BasicBaseEJB.AreaManageFacade myEjb;
  public DB_AreaHandler() {
    try{
      BasicMdlEJBs.BasicBaseEJB.AreaManageFacadeHome ejbHome=
          (BasicMdlEJBs.BasicBaseEJB.AreaManageFacadeHome)
          info_ejb.WeblogicServiceLocator.locateServiceHome(util.PublicVariable.SERVER_URL,
           "BasicMdlEJBs.BasicBaseEJB.AreaManageFacade");
       myEjb=ejbHome.create();
       ejb=myEjb;
       blankRecord =myEjb.getBlankRecord();
    }catch(Exception exp){
      exp.printStackTrace();
      util.ExceptionLog.exp2File(exp,"");
      exgui.verification.VerifyLib.showAlert("Error While Creating EJB\nPlease Contact System Manager",
                                             "Error In Connection");
    }
  }
  public java.util.Vector getRecords(int bgn,int rowcount)throws Exception{
    return myEjb.getRecords(bgn,rowcount,new java.util.HashMap());
  }
  public void deleteRecord(Record rec2Del)throws Exception{
    myEjb.deleteAreaRecord(rec2Del);
  }
}
