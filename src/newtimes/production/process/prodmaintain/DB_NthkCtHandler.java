package newtimes.production.process.prodmaintain;

import exgui.ultratable.PagedDataFactoryAdapter;
import java.util.*;
/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class DB_NthkCtHandler extends PagedDataFactoryAdapter {
  public DB_NthkCtHandler() {
    try{
      newtimesejb.production.NTHK_CT_FacadeHome ejbHome=
          (newtimesejb.production.NTHK_CT_FacadeHome)
          info_ejb.WeblogicServiceLocator.locateServiceHome(
          util.PublicVariable.SERVER_URL,
         "newtimesejb.production.NTHK_CT_Facade");
         newtimesejb.production.NTHK_CT_Facade thisEjb=
             ejbHome.create();
         super.ejb=thisEjb;
         super.blankRecord=thisEjb.getBlankRecord();
         //PROD_HEAD_PK, PROD_MAKER, PROD_SC_NO, PROD_CT_SEQ, PROD_CT_CURRENCY,
         //PROD_CT_PRX_TRM, PROD_CT_PORT, PROD_CT_ISSU, PROD_CT_PYT_TRM
         blankRecord.set(0,newtimes.preproduction.Constants.CURRENT_PREPROD_HEAD_PK);
         blankRecord.set(1,newtimes.preproduction.Constants.CURRENT_PREPROD_HEAD_RECORD.get("prod_maker"));
         blankRecord.set(2,
                         newtimes.preproduction.Constants.CURRENT_PREPROD_HEAD_RECORD.get("prod_sc_no"));
         blankRecord.set(3,1);
         blankRecord.set(4,"USD");

         if("NTHK".equals(util.PublicVariable.OPERATTING_CENTER)){
           blankRecord.set(5,"CNF");
         }else{
           blankRecord.set(5,"FOB");
         }

         blankRecord.set(6,".");
         blankRecord.set(7,new java.sql.Date(System.currentTimeMillis()));
         blankRecord.set(8,"T/T");
    }catch(Exception exp){
      exp.printStackTrace();
      util.ExceptionLog.exp2File(exp,"");
    }
  }
  public void updateRecords(Vector vct)throws Exception{
    if(vct==null || vct.size()==0) updateSyncCtHead();
    super.updateRecords(vct);
    newtimes.preproduction.process.DB_Preprod db=newtimes.preproduction.process.DB_NthkPreProd.getInstance();
    database.datatype.Record rec=(database.datatype.Record)
         db.findbyPk(newtimes.preproduction.Constants.CURRENT_PREPROD_HEAD_PK);  //pgTblList.getDisplayingRecords().get(recAt);
    processhandler.template.Properties.getCenteralControler().setCurrentEditingMasterRecord(rec);
    newtimes.production.ProdMaintain_Properties.PRODUCTION_AUDIT_STATUS_COLUMN_NAME="PRODUCTION_AUDIT_STATUS";
    newtimes.preproduction.Constants.CURRENT_PREPROD_HEAD_PK=rec.getInt(0);
    newtimes.preproduction.Constants.CURRENT_PREPROD_HEAD_RECORD=rec;

  }
  public void updateSyncCtHead()throws Exception{
    ((newtimesejb.production.NTHK_CT_Facade)ejb).chkAndUpdateCtToMisc(
      (String)newtimes.preproduction.Constants.CURRENT_PREPROD_HEAD_RECORD.get("prod_sc_no"),
        (String)util.PublicVariable.USER_RECORD.get(0));
  }
  public Vector getRecords(int bgn,int rowcount)throws Exception{
    /*
    java.util.HashMap hm=new java.util.HashMap();
    hm.put("record_delete_flag","1");
    hm.put("prod_head_pk",newtimes.preproduction.Constants.CURRENT_PREPROD_HEAD_RECORD.get("prod_sc_no"));
    return ejb.getRecords(bgn,rowcount,hm);
     */
    //sb.append("select a.*,");

    StringBuffer sb=new StringBuffer();

      sb.append("select ");
      sb.append("a.PROD_HEAD_PK ,");//0
      sb.append("a.PROD_MAKER ,");//1
      sb.append("a.PROD_SC_NO ,");//2
      sb.append("a.PROD_CT_SEQ,");//3
      sb.append("a.PROD_CT_CURRENCY,");//4
      sb.append("a.PROD_CT_PRX_TRM,");//5
      sb.append("a.PROD_CT_PORT,");//6
      sb.append("a.PROD_CT_ISSU,");//7
      sb.append("a.PROD_CT_PYT_TRM,");//8
      sb.append("a.RECORD_CREATE_USER,");//9
      sb.append("a.RECORD_CREATE_DATE,");//10
      sb.append("a.RECORD_DELETE_FLAG,");//11
      sb.append("a.RECORD_DELETE_DATE,");//12
      sb.append("a.RECORD_DELETE_USER,");//13
      sb.append("a.RECORD_MODIFY_DATE,");//14
      sb.append("a.RECORD_MODIFY_USER,");//15
      sb.append("a.PROD_CNTY         ,");//16
      sb.append("a.PROD_CITY         ,");//17
    sb.append("nvl(b.BYMKR_HK_CODE,b.BYMKR_BRIEF) as maker_code,");//18
    sb.append("'...' as dots,'0' as is_maker_changed,");//19,20
    sb.append("b.BYMKR_NAME,b.BYMKR_ADDR1,b.BYMKR_ADDR2, ");//21 //22 //23
    sb.append("b.BYMKR_ADDR3,b.BYMKR_ADDR4");//24//25

    if(newtimes.preproduction.Constants.CURRENT_PREPROD_HEAD_RECORD.getInt("production_audit_status")==7 ){
     sb.append(",(select count(*) from ship_style,style where ship_style.sty_seq=style.sty_seq and ");
     sb.append(" style.prod_head_pk=c.prod_head_pk and style.record_delete_flag='1' and ship_style.record_delete_flag='1'");
     sb.append(" and rownum=1)");
     sb.append("as shipped_count "); //26
    }else{
      sb.append(",0 as shipped_count "); //26
    }
    //add fields for NTHK vender and bank collection.
    sb.append(",a.VENDER_SEQ        ");//27
    sb.append(",a.COLLECT_BANK      ");//28
    sb.append(",a.BANK_ADD1         ");//29
    sb.append(",a.BANK_ADD2         ");//30
    sb.append(",a.SWIFT             ");//31
    sb.append(",a.COLLECT_BY        ");//32
    sb.append(",a.ACC_NO            ");//33
    sb.append(",nvl(d.BYMKR_HK_CODE,d.BYMKR_BRIEF) as vendor_code ");//34
    sb.append(",'...' as dots4vendor");//35
    sb.append(",'0' as is_vendor_changed ");//36
    sb.append(", e.prod_year ");//37

    sb.append(",d.BYMKR_NAME  as VDR_NAME  ,d.BYMKR_ADDR1 as VDR_ADDR1 ,d.BYMKR_ADDR2 as VDR_ADDR2, ");//38~40
    sb.append("d.BYMKR_ADDR3 as VDR_ADDR3 ,d.BYMKR_ADDR4 as VDR_ADDR4 ");//41 & 42
    if(util.PublicVariable.USER_RECORD.get(0).equals("NTERIC")){
      sb.append(",(select pdpnt.PRINT_DATE from PROD_CT_PRINT pdpnt where pdpnt.prod_head_pk=a.prod_head_pk) as PRINT_DATE ");
    }
    sb.append(" from prod_ct_infor a,buyer_maker b ,production c, buyer_maker d,prod_head e  where ");
    sb.append(" a.prod_head_pk=e.prod_head_pk  ");
    sb.append(" and a.prod_head_pk=c.prod_head_pk  ");
    sb.append(" and a.PROD_MAKER=b.BYMKR_SEQ(+) ");
    sb.append(" and a.VENDER_SEQ=d.BYMKR_SEQ(+) ");
    sb.append(" and a.record_delete_flag='1' and a.prod_sc_no='");
    sb.append((String)newtimes.preproduction.Constants.CURRENT_PREPROD_HEAD_RECORD.get("prod_sc_no"));
    sb.append("' order by prod_ct_seq ");

    /*
    sb.append(" select a.*,");
    sb.append("(select nvl(BYMKR_HK_CODE,BYMKR_BRIEF) from buyer_maker where BYMKR_SEQ=PROD_MAKER)");
    sb.append(" as maker_code ,'...' as dots,'0' as is_maker_changed ");
    sb.append("from prod_ct_infor a where a.record_delete_flag='1' and a.prod_sc_no='");
    sb.append((String)newtimes.preproduction.Constants.CURRENT_PREPROD_HEAD_RECORD.get("prod_sc_no"));
    sb.append("' order by prod_ct_seq");
    */
    return exgui2.CONST.BASIC_MAIN_EJB.getDatas(
           util.PublicVariable.USER_RECORD,sb.toString(),1,99999);
  }
}
