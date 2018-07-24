package newtimes.production.process.prodmaintain;
import exgui.ultratable.PagedDataFactoryAdapter;
import database.datatype.Record;
import java.util.*;
/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class DB_StyUpload extends PagedDataFactoryAdapter {
  boolean isInitOk;
  public DB_StyUpload() {
    try{
      newtimesejb.production.StyleUploadFacadeHome ejbHome=
          (newtimesejb.production.StyleUploadFacadeHome)
          info_ejb.WeblogicServiceLocator.locateServiceHome(
          util.PublicVariable.SERVER_URL,"newtimesejb.production.StyleUploadFacade");
      super.ejb= ejbHome.create();
      super.blankRecord=ejb.getBlankRecord();
      blankRecord.getFieldName().add(
       ((newtimesejb.production.StyleUploadFacade)ejb).PSUDO_COLUMN_FILES_DATA);
      blankRecord.getValueFields().add(null);
      isInitOk=true;
    }catch(Exception e){
      isInitOk=false;
      e.printStackTrace();
      util.ExceptionLog.exp2File(e,"Initializing DB_StyUpload");
      exgui.verification.VerifyLib.showAlert(
      "Connection Or Server Side Error\nPlease Contact System Manager",
      "Error in Initialzing DB_StyUpload");
    }
  }
  public boolean isInitOK(){return isInitOk;}
  public Record getRecordByPk(int sty_seq)throws Exception{
    return ((newtimesejb.production.StyleUploadFacade)ejb).getRecordAndByts(sty_seq);
  }
  public Record updateRecord(Record rec)throws Exception{
    ejb.updateRecord(rec);
    return rec;
  }
  public Record getBlankRecord()throws Exception{
    Record rec=(Record)util.MiscFunc.deepCopy(blankRecord);
    rec.set("record_create_user",
            util.PublicVariable.USER_RECORD.get("USR_CODE"));
    rec.set("sty_file_sty_pk",
            newtimes.production.ProdMaintain_Properties.CURRENT_SELECTED_STYLE_SEQ_IN_STYLE_LIST);
    return rec;
  }
  public Vector getRecords(int bgn,int count)throws Exception{
     java.util.HashMap hm=new java.util.HashMap();
     hm.put("sty_file_sty_pk",
            String.valueOf(
            newtimes.production.ProdMaintain_Properties.CURRENT_SELECTED_STYLE_SEQ_IN_STYLE_LIST));
     return ejb.getRecords(bgn,count,hm);
  }
}
