package newtimes.basic.chinese_area;
import exgui.ultratable.*;
import java.util.*;
import database.datatype.Record;
public class DB_AreaDb implements exgui.ultratable.PagedDataFactory {
  BasicMdlEJBs.BasicBaseEJB.ChineseAreaFacade ejb=null;
  Vector allocatedCityRecords=null;
  Record editingAreaRecord=null;
  public DB_AreaDb() {
    try{
      BasicMdlEJBs.BasicBaseEJB.ChineseAreaFacadeHome ejbHome =
          (BasicMdlEJBs.BasicBaseEJB.ChineseAreaFacadeHome)
          info_ejb.WeblogicServiceLocator.locateServiceHome(util.PublicVariable.
          SERVER_URL,
          "BasicMdlEJBs.BasicBaseEJB.ChineseAreaFacade");
       ejb=ejbHome.create();
    }catch(Exception exp){
      exp.printStackTrace();
      util.ExceptionLog.exp2File(exp,"");
      exgui.verification.VerifyLib.showAlert("Server Side Error\nPlease Contact System Manager",
                                             "Error While Creating REMOTE INTERFACE");
    }

  }
  public Vector  getRecords(int startPosition,int rowCounts)throws Exception{
      return ejb.getAreasMap();
  }
  public Record findByPk(int area_pk)throws Exception{
     Record rec=ejb.findByPk(area_pk);
     editingAreaRecord=rec;
     allocatedCityRecords=ejb.getCitys(area_pk);
     return rec;
  }
  public void deleteRecord(Record rec2delete)throws Exception{
    ejb.deleteAreaData(rec2delete);
  }
  public void restoreRecord(Record rec2restore)throws Exception{
    return;
  }
  public Record addRecord(Record rec2add)throws Exception{
    ejb.insertAreaData(rec2add,allocatedCityRecords);
    return null;
  }

  public Record getBlankRecord()throws Exception{
    return ejb.getBlankAreaRecord();
  }
  public void updateRecord(Record rec)throws Exception{
     ejb.updateAreaData(rec,allocatedCityRecords);
  }
  public void updateRecords(Vector recs2update)throws Exception{
    return;
  }
  public Vector getCityToSelect()throws Exception{
    return ejb.getCity2Select(0);
  }
  public boolean listforRestore(){
    return false;
  }


}
