package newtimes.production.process.prodmaintain;
import java.util.*;
import database.datatype.Record;
/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class DB_Style_PS_Misc extends DB_StyleMisc {
  int orgDelAt=0,orgWayAt=0;
  int reconfirmDelAt=0,reconfirmWayAt=0;
  int weeklyDelAt=0,weeklyDelWay=0;
  exgui.Object2String objDateCnv=
      exgui.verification.CellFormat.getDateStringFormaterAllowNull();
  public DB_Style_PS_Misc() {
    super();
    try{
      Record rec = ejb.getBlankRecord();
      orgDelAt = util.MiscFunc.getFieldIndexAtRecord(rec, "STY_ORIG_DEL");
      orgWayAt = util.MiscFunc.getFieldIndexAtRecord(rec, "STY_ORIG_WAY");

      reconfirmDelAt = util.MiscFunc.getFieldIndexAtRecord(rec, "STY_RECFM_DEL");
      reconfirmWayAt = util.MiscFunc.getFieldIndexAtRecord(rec,
          "STY_RECFM_SHIP");

      weeklyDelAt = util.MiscFunc.getFieldIndexAtRecord(rec, "STY_UPDT");
      weeklyDelWay = util.MiscFunc.getFieldIndexAtRecord(rec, "STY_UPDT_SHIP");
    }catch(Exception e){
      e.printStackTrace();
      isInitOk=false;
    }
  }
  protected void getDeliveryData(Record rec){
    Object objOrgDel=rec.get(orgDelAt);
    Object objOrgWayAt=rec.get(orgWayAt);
    Object objrecfmDel=rec.get(reconfirmDelAt);
    Object objrecfmWayAt=rec.get(reconfirmWayAt);
    Object objweeklyDel=rec.get(weeklyDelAt);
    Object objweeklyWayAt=rec.get(weeklyDelWay);
    rec.getFieldName().add("temp_del_data");
    if(objweeklyDel!=null ){
      rec.getValueFields().add(objDateCnv.Obj2String(objweeklyDel)+" "+
                               ((objweeklyWayAt==null)?"":objweeklyWayAt.toString()));
      return;
    }

    if(objrecfmDel!=null ){
      rec.getValueFields().add(objDateCnv.Obj2String(objrecfmDel)+" "+
                               ((objrecfmWayAt==null)?"":objrecfmWayAt.toString()));
      return;
    }
    if(objOrgDel!=null ){
      rec.getValueFields().add(objDateCnv.Obj2String(objOrgDel)+" "+
                               ((objOrgWayAt==null)?"":objOrgWayAt.toString()));
      return;
    }
    rec.getValueFields().add(null);
  }
  public Vector getRecords(int bgn,int rowcount)throws Exception{
    //compose the deliver data from ps list page.
    HashMap hm=new HashMap();
    hm.put("PROD_HEAD_PK",String.valueOf(newtimes.preproduction.Constants.CURRENT_PREPROD_HEAD_PK));
    Vector vct= ejb.getRecords(bgn,rowcount,hm);
    for(int i=0;i<vct.size();i++){
      getDeliveryData((Record)vct.get(i));
    }
    return vct;
  }

}
