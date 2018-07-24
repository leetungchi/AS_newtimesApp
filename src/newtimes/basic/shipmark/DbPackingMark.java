package newtimes.basic.shipmark;

import exgui.ultratable.PagedDataFactoryAdapter;

public class DbPackingMark extends PagedDataFactoryAdapter {
  boolean initOk=false;
  public DbPackingMark(java.util.HashMap hm) {
    try{
      BasicMdlEJBs.BasicBaseEJB.PackingMarkFacadeHome ejbHome=
          (BasicMdlEJBs.BasicBaseEJB.PackingMarkFacadeHome)info_ejb.WeblogicServiceLocator.locateServiceHome(
            util.PublicVariable.SERVER_URL,"BasicMdlEJBs.BasicBaseEJB.PackingMarkFacade"
          );
       super.ejb=ejbHome.create();
       initOk=true;
       super.conditions=hm;
       blankRecord=ejb.getBlankRecord();
    }catch(Exception exp){
      exp.printStackTrace();
      initOk=false;
      util.ExceptionLog.exp2File(exp,"");
      exgui.verification.VerifyLib.showAlert("Connection Error Or Server Side Error\nPlease Contact System Manager",
                                             "EJB Create Error");
    }

  }

}
