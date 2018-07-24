package newtimes.basic.ashworth_unit;
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

public class DbAshHandler extends exgui.ultratable.PagedDataFactoryAdapter {
  newtimesejb.TPE_MIS.TpeMisFunc tpeMisFuncEjb;
  public DbAshHandler() {
    try{
      super.blankRecord =
          exgui2.CONST.BASIC_MAIN_EJB.getBlankRecord("ASHWORTH_MAKER_REMARK_tbl");
      blankRecord.set(0,-4);
      newtimesejb.TPE_MIS.TpeMisFuncHome ejbTpeMisHome=
          (newtimesejb.TPE_MIS.TpeMisFuncHome)
          info_ejb.WeblogicServiceLocator.locateServiceHome(
          util.PublicVariable.SERVER_URL,"newtimesejb.TPE_MIS.TpeMisFunc");
      tpeMisFuncEjb=ejbTpeMisHome.create();
    }catch(Exception exp){
      exp.printStackTrace();
    }
  }
  public Vector getRecords(int bgn,int rowcount)throws Exception{
    HashMap current_conditions=PnlAshMkrRmkFunc.conditions;
    StringBuffer sb=new StringBuffer();
    sb.append("select ashworth_maker_remark.* , ");
    sb.append("(select bymkr_name from buyer_maker where bymkr_seq=ashworth_maker_remark.mkr_seq) as maker_name,");
    sb.append("(select dv.div_name from division dv where dv.div_code=ashworth_maker_remark.div_code) as div_name ");
    sb.append("from ashworth_maker_remark  where ashworth_maker_remark.record_delete_flag='1' ");
    Iterator itrKey=current_conditions.keySet().iterator();
    while(itrKey.hasNext()){
      Object objKey=itrKey.next();
      Object objValue=current_conditions.get(objKey);
      if(objValue!=null){
        sb.append(" and ");
        sb.append(objKey);
        sb.append("='");
        sb.append(util.MiscFunc.Replace(objValue.toString(),"'","''"));
        sb.append("'");
      }
    }
    Vector vctOrg=
    exgui2.CONST.BASIC_MAIN_EJB.getDatas(
      util.PublicVariable.USER_RECORD,
      sb.toString(),bgn,rowcount);
     Vector vct2Return=new Vector();
     for(int i=0;i<vctOrg.size();i++){
       Record rec=(Record)vctOrg.get(i);
       String orgRemarkCtx=(String)rec.get("remark");
       rec.getFieldName().add("REMARK_HTML_CONTEXT");
       if(orgRemarkCtx!=null){
         StringBuffer sb2=new StringBuffer();
         sb2.append("<html><body>");
         sb2.append(util.MiscFunc.Replace(orgRemarkCtx,"\n","<br>"));
         sb2.append("</body></html>");
         rec.getValueFields().add(sb2.toString());
       }else{
         rec.getValueFields().add(null);
       }
       vct2Return.add(rec);
     }
     return vct2Return;
  }
  public void deleteRecord(Record rec) throws Exception{
    rec.set("record_delete_flag","0");
    rec.set("record_delete_user",util.PublicVariable.USER_RECORD.get(0));
    HashMap hmPara=new HashMap();
    hmPara.put("TPEMISCFUNC_ACTION_CODE","ASHWORTH_MAKER_REMARK_HANDLER");
    hmPara.put("ASHWORTH_MAKER_REMARK_HANDLER_RECORD",rec);
    tpeMisFuncEjb.tpeMisFunc(hmPara);
  }
  public void updateRecords(Vector vct)throws Exception{
    if(vct.size()==0)return;
    Record rec=(Record)vct.get(0);
    HashMap hmPara=new HashMap();
    hmPara.put("TPEMISCFUNC_ACTION_CODE","ASHWORTH_MAKER_REMARK_HANDLER");
    hmPara.put("ASHWORTH_MAKER_REMARK_HANDLER_RECORD",rec);
    tpeMisFuncEjb.tpeMisFunc(hmPara);
    //return (Record)hm.get("RETURN_RECORD");
  }
  public Record addRecord(Record rec)throws Exception{
     HashMap hmPara=new HashMap();
     hmPara.put("TPEMISCFUNC_ACTION_CODE","ASHWORTH_MAKER_REMARK_HANDLER");
     hmPara.put("ASHWORTH_MAKER_REMARK_HANDLER_RECORD",rec);
     HashMap hm=tpeMisFuncEjb.tpeMisFunc(hmPara);
     return (Record)hm.get("RETURN_RECORD");
  }
}
