package newtimes.production.process.audit_sc_ct;
import java.util.*;
import exgui.ultratable.PagedDataFactoryAdapter;
import database.datatype.Record;
public class DB_ProdCnfm extends PagedDataFactoryAdapter {
  public boolean initOk=false;
  public newtimesejb.preproduction.ProdCnfmFacade ourEJB;
  public DB_ProdCnfm() {
    try{
      newtimesejb.preproduction.ProdCnfmFacadeHome ejbHome=
        (newtimesejb.preproduction.ProdCnfmFacadeHome)
        info_ejb.WeblogicServiceLocator.locateServiceHome(
          util.PublicVariable.SERVER_URL,
          "newtimesejb.preproduction.ProdCnfmFacade"
        );
       ourEJB =ejbHome.create();
      initOk=true;
    }catch(Exception e){
      e.printStackTrace();
      util.ExceptionLog.exp2File(e,"exp while lookup ejb in production confirm list");
      exgui.verification.VerifyLib.showAlert("Connection Error,Please Notify System Manager",
                                             "EJB Creation Exception");
      initOk=false;
    }
  }
  public boolean isInitOk(){return initOk;}
  public Vector getRecords(int bgn,int row)throws Exception{
    //test if is manager level...Director or manager,user type =3,4
    Record recUser=util.PublicVariable.USER_RECORD;
    HashMap hm=new HashMap();
    Object typeObj=recUser.get("USR_TYPE");
    int userType=
        (typeObj==null)?0:Integer.parseInt(typeObj.toString());
    if(userType==3||
       userType==4){
       hm.put(ourEJB.CONDITION_ON_MANAGER,
              (String)recUser.get("USR_CODE"));
    }else{
       hm.put(ourEJB.CONDITION_ON_USER,
              (String)recUser.get("USR_CODE"));
    }
    return ourEJB.getRecords(hm,bgn,row);
  }
}