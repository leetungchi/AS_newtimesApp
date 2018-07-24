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

public class DB_NTHKStyleListHandler extends DB_StyleListHandler {
  static String sc_no;
  String initSQL;
  static java.util.HashMap hmCtMapKeyIsProdPk,hmCtMapKeyIsCtSeq;
  static newtimesejb.production.StyleNthkListFacade staticHandler;
  public DB_NTHKStyleListHandler(String sc,boolean istoListForRestore) {
    this(sc);
    conditions.put(((newtimesejb.production.StyleListFacade)ejb).CONDITION_STYLE_RECORD_DELETE_FLAG,
                   istoListForRestore?"0":"1");
    setToRestoreOrNot(istoListForRestore);

  }
  public DB_NTHKStyleListHandler(String sc) {
    super();
    conditions.put(
      ((newtimesejb.production.StyleListFacade)ejb).CONDITION_STYLE_RECORD_DELETE_FLAG,"1");
    setToRestoreOrNot(false);
    sc_no=sc;
    try{
      if(util.PublicVariable.OPERATTING_CENTER.equals("NTHK")){
        blankRecord.set("STY_UNIT", "DZS");
      }else{
        blankRecord.set("STY_UNIT", "PCS");
      }
      newtimesejb.production.StyleNthkListFacadeHome   ejbhome=
          (newtimesejb.production.StyleNthkListFacadeHome)
           info_ejb.WeblogicServiceLocator.locateServiceHome(
            util.PublicVariable.SERVER_URL,
            "newtimesejb.production.StyleNthkListFacade"
           );
      super.ejb=ejbhome.create();
      staticHandler=(newtimesejb.production.StyleNthkListFacade)ejb;
      //force2UpdateCtProdPkMap();
      if(newtimes.preproduction.Constants.CURRENT_PREPROD_HEAD_RECORD.get("production_combin_pk_list")!=null){
        force2UpdateCtProdPkMap();
      }else{
        hmCtMapKeyIsCtSeq=new java.util.HashMap();
        hmCtMapKeyIsProdPk=new java.util.HashMap();
        int prodPk=newtimes.preproduction.Constants.CURRENT_PREPROD_HEAD_PK;
        hmCtMapKeyIsCtSeq.put("1",String.valueOf(prodPk));
        hmCtMapKeyIsProdPk.put(String.valueOf(prodPk),"1");
      }
     //setTempCtProdPkMap();
    }catch(Exception exp){
      exp.printStackTrace();
      util.ExceptionLog.exp2File(exp,"");
    }

  }
  public Vector getRecords(int bgn,int rowcount)throws Exception{
    java.util.HashMap hm=new java.util.HashMap();
    hm.put("SPECIALLY_FOR_STY_SC_NO",sc_no);
    if(newtimes.preproduction.Constants.CURRENT_PREPROD_HEAD_RECORD.getInt("production_audit_status")==7){
      hm.put("ABLE_TO_EDIT","FALSE");
    }else{
      hm.put("ABLE_TO_EDIT","TRUE");
    }
    //hm.put("ABLE_TO_EDIT",(newtimes.production.ProdMaintain_Properties.isAbleToEdit())?"TRUE":"FALSE");
    //hm.put("ABLE_TO_EDIT","TRUE");
    hm.put("CENTER_CODE",util.PublicVariable.OPERATTING_CENTER.toString());
    hm.put("LISTFORRESTORE",listforRestore()?"0":"1");
    return ejb.getRecords(bgn,rowcount,hm);
  }
  protected static newtimesejb.production.StyleNthkListFacade getEjb()throws Exception{
    if(staticHandler==null){
      newtimesejb.production.StyleNthkListFacadeHome   ejbhome=
          (newtimesejb.production.StyleNthkListFacadeHome)
           info_ejb.WeblogicServiceLocator.locateServiceHome(
            util.PublicVariable.SERVER_URL,
            "newtimesejb.production.StyleNthkListFacade"
           );
      staticHandler=ejbhome.create();
    }
    return staticHandler;
  }
  public static void udpateColorSizeBreakDownRemark(String ScNo,boolean isSC,boolean isDocPrx,
                                                   boolean isWithColorCodeName)throws Exception{
    if(staticHandler==null)getEjb();
    java.util.HashMap hm=new java.util.HashMap();
    if(isSC)hm.put("isSC","TRUE");
    if(isDocPrx)hm.put("isDocPrice","TRUE");
    if(!isSC){
      if(!isWithColorCodeName)hm.put("isWithColorCodeName","FALSE");
    }
      staticHandler.updateStyleColorSizeBreakDownRemark4XCenter(
       ScNo,hm,(String)util.PublicVariable.USER_RECORD.get(0));
  }
  public static Vector force2UpdateCtProdPkMap()throws Exception{
    StringBuffer sb=new StringBuffer();
    sb.append("select to_char(prod_ct_seq) as prod_ct_seq ,to_char(prod_head_pk) as prod_head_pk,");
    sb.append("(select production.prod_ct_revice_no from production where production.prod_head_pk=prod_ct_infor.prod_head_pk) as ct_rev_no ");
    sb.append(" from prod_ct_infor where record_delete_flag='1' and prod_sc_no='");
    sb.append(sc_no);
    sb.append("' order by prod_ct_seq");
    Vector vct = exgui2.CONST.BASIC_MAIN_EJB.getDatas(
        util.PublicVariable.USER_RECORD,sb.toString(),
        1, 99999);
    hmCtMapKeyIsCtSeq=new java.util.HashMap();
    hmCtMapKeyIsProdPk=new java.util.HashMap();
    for (int i = 0; i < vct.size(); i++) {
      Record rec = (Record)vct.get(i);
      hmCtMapKeyIsCtSeq.put(rec.get(0).toString(), rec.get(1).toString());
      hmCtMapKeyIsProdPk.put(rec.get(1).toString(), rec.get(0).toString());
    }
    return vct;
  }
  public HashMap getCtMapKeyCtSeq()throws Exception{
    return hmCtMapKeyIsCtSeq;
  }
  public HashMap getCtMapKeyIsProdPK()throws Exception{
    return hmCtMapKeyIsProdPk;
  }
  public void bachUpdateColumns(Record styleRec,Record priceRec,String Qty)throws Exception{
    ((newtimesejb.production.StyleNthkListFacade)ejb).updateAttris(styleRec,priceRec,Qty,
        sc_no ,
        (String)util.PublicVariable.USER_RECORD.get("usr_code"));
  }

}
