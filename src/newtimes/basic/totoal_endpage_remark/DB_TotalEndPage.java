package newtimes.basic.totoal_endpage_remark;

import exgui.ultratable.PagedDataFactoryAdapter;

public class DB_TotalEndPage extends PagedDataFactoryAdapter {
  static private DB_TotalEndPage my_instance;
  public DB_TotalEndPage() {
    try {
      BasicMdlEJBs.BasicBaseEJB.TotalEndPageRemarkFacadeHome ejbHome =
          (BasicMdlEJBs.BasicBaseEJB.TotalEndPageRemarkFacadeHome)
          info_ejb.WeblogicServiceLocator.locateServiceHome(
          util.PublicVariable.SERVER_URL,
          "BasicMdlEJBs.BasicBaseEJB.TotalEndPageRemarkFacade");
      ejb = ejbHome.create();
      blankRecord = ejb.getBlankRecord();
      //blankRecord.set("record_create_user",util.PublicVariable.USER_RECORD.get("USR_CODE"));
      my_instance = this;
    } catch (Exception e) {
      e.printStackTrace();
      util.ExceptionLog.exp2File(e,
          "while in crating instance DB_TotalendPage Instance");
      exgui.verification.VerifyLib.showAlert(
          "Server Side Error", "EJB Creationg Error");
    }
  }
    public static DB_TotalEndPage getInstance(){
      if(my_instance==null) my_instance=new DB_TotalEndPage();
      return my_instance;
    }




}
