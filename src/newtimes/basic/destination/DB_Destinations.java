package newtimes.basic.destination;

import exgui.ultratable.PagedDataFactoryAdapter;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class DB_Destinations extends PagedDataFactoryAdapter {
  private static DB_Destinations my_instance;
  private DB_Destinations() {
    try{
      BasicMdlEJBs.BasicBaseEJB.DestinationFacadeHome ejbHome =
          (BasicMdlEJBs.BasicBaseEJB.DestinationFacadeHome)
          info_ejb.WeblogicServiceLocator.locateServiceHome(
          util.PublicVariable.SERVER_URL,
          "BasicMdlEJBs.BasicBaseEJB.DestinationFacade");
           ejb=ejbHome.create();
           blankRecord=ejb.getBlankRecord();
           //blankRecord.set("record_create_user",util.PublicVariable.USER_RECORD.get("USR_CODE"));
       my_instance=this;
    }catch(Exception e){
        e.printStackTrace();
        util.ExceptionLog.exp2File(e,"while in crating instance DB_Destinations Instance");
        exgui.verification.VerifyLib.showAlert(
        "Server Side Error","EJB Creationg Error");
    }

  }
  public static DB_Destinations getInstance(){
    if(my_instance==null) my_instance=new DB_Destinations();
    return my_instance;
  }

}
