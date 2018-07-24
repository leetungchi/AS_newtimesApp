package newtimes.preproduction.process;
import database.datatype.Record;
import exgui.ultratable.PagedDataFactoryAdapter;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class DB_CostSheet extends PagedDataFactoryAdapter {
  public static Record EDITING_COST_RECORD;
  static newtimesejb.preproduction.CostSheetFacade myejb=null;
  static DB_CostSheet instanceOfMe=null;
  protected DB_CostSheet() {
    try{
      newtimesejb.preproduction.CostSheetFacadeHome home=
          (newtimesejb.preproduction.CostSheetFacadeHome)
          info_ejb.WeblogicServiceLocator.locateServiceHome(
           util.PublicVariable.SERVER_URL,
           "newtimesejb.preproduction.CostSheetFacade"
          );
      myejb=home.create();
      super.ejb=myejb;
      blankRecord=myejb.getBlankRecord();
    }catch(Exception e){
      e.printStackTrace();
      super.ejb=null;
      myejb=null;
    }
  }
  public static DB_CostSheet getInstanceOfCostSheet(){
    if(instanceOfMe==null||myejb==null){
      instanceOfMe=new DB_CostSheet();
    }
    return instanceOfMe;
  }
}