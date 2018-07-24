package newtimes.production.process.prodmaintain;

import exgui.ultratable.PagedDataFactoryAdapter;
import java.util.Vector;
/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class DB_ProdSC extends PagedDataFactoryAdapter {
 static  DB_ProdSC instanceOfMe=null;
 //public static Vector payment_terms;
 public static Vector BRANCHES;
 public static Vector DESTINATIONS;
  protected DB_ProdSC() {
    try{
      newtimesejb.production.ProductionFacadeHome ejbHome=
          (newtimesejb.production.ProductionFacadeHome)
           info_ejb.WeblogicServiceLocator.locateServiceHome(
            util.PublicVariable.SERVER_URL,"newtimesejb.production.ProductionFacade");
      super.ejb=ejbHome.create();
      //payment_terms=((newtimesejb.production.ProductionFacade)(super.ejb)).getPaymentTerms();
      if(BRANCHES==null||BRANCHES.size()==0)reloadDestAndBranch();
    }catch(Exception e){
      e.printStackTrace();
      exgui.verification.VerifyLib.showAlert(
          "EJB Creation Exception,please notify System manager","EJB Creation Exception"
      );
     instanceOfMe=null;
    }
  }

  public static Vector getBranches()throws Exception{
    if(BRANCHES==null ||BRANCHES.size()==0) reloadDestAndBranch();
    return BRANCHES;
  }
  public static Vector getDestinations()throws Exception{
    if(DESTINATIONS==null ||DESTINATIONS.size()==0) reloadDestAndBranch();
    return DESTINATIONS;
  }
  public static DB_ProdSC getInstanceOfProdSCHandler(){
    if(instanceOfMe==null){
      instanceOfMe=new DB_ProdSC();
    }
    try{
      if(BRANCHES==null||BRANCHES.size()==0)reloadDestAndBranch();
    //((newtimesejb.production.ProductionFacade)(instanceOfMe.ejb)).getBranches();
    }catch(Exception e){
      util.ExceptionLog.exp2File(e,"DB_PRODSC get instance and get Brief");
      e.printStackTrace();
      exgui.verification.VerifyLib.showAlert("Error While Get Briefs Data\nPlease Contact System Manager",
                                             "Connection Error");
    }
    return instanceOfMe;
  }
  public void updateCtDatas(Vector recs)throws Exception{
    ejb.updateRecords(recs);
  }
  public static void reloadDestAndBranch()throws Exception{
    BRANCHES = exgui2.CONST.BASIC_MAIN_EJB.getDatas(
      util.PublicVariable.USER_RECORD,
      "select * from branch where BRNCH_CEN_CODE like '%,"+util.PublicVariable.OPERATTING_CENTER+",%'",1,9999);
    newtimes.basic.destination.DB_Destinations dbx=
       newtimes.basic.destination.DB_Destinations.getInstance();
     DESTINATIONS= dbx.getRecords(1,99999);
  }
}
