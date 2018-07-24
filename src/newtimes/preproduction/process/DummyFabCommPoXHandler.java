package newtimes.preproduction.process;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class DummyFabCommPoXHandler extends DummyFabCommHandler {
  public DummyFabCommPoXHandler() {
    try{
      newtimesejb.preproduction.Fab_Com_PoExtFavadeHome  ejbHome=
        (newtimesejb.preproduction.Fab_Com_PoExtFavadeHome)info_ejb.WeblogicServiceLocator.locateServiceHome(
        util.PublicVariable.SERVER_URL,"newtimesejb.preproduction.Fab_Com_PoExtFavade");
      newtimesejb.preproduction.Fab_Com_PoExtFavade ejb=ejbHome.create();
      blankRec=ejb.getBlankRecord();
      blankRec.set("FAB_COMM_UNIT","PC");
      blankRec.set("FAB_COMM_TYPE","FABRIC");
      blankRec.set("FAB_COMM_DISCOUNT_KIND",new Integer(1));
      blankRec.set("record_create_user",util.PublicVariable.USER_RECORD.get("usr_code"));
      blankRec.set("record_delete_flag","1");
      blankRec.set(14,-1);
      initOK=true;
    }catch(Exception exp){
      exp.printStackTrace();
      util.ExceptionLog.exp2File(exp,"");
      initOK=false;
    }

  }

}
