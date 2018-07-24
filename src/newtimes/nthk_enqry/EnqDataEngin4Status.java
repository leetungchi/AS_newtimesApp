package newtimes.nthk_enqry;
import java.util.*;
import newtimesejb.preproduction.PreProductionHead;
import database.datatype.Record;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class EnqDataEngin4Status extends EnqDataEngin {
  static newtimesejb.NthkAppvCnfm.AppvCnfmFacade appHandler=null;
  public EnqDataEngin4Status() {
     super();
     StringBuffer sb=new StringBuffer();
     sb.append("select ");
     sb.append("a.PROD_HEAD_PK,");//0
     sb.append("prodXN.prod_sc_no as sc_no,");//1
     sb.append("prodXN.prod_byr_sc_no as cust_po,");//2
     sb.append("prodXn.PROD_SC_PRC_TRM,");//3
     sb.append("prodXn.PROD_PYT_TRM,prodXn.prod_ct_pyt_trm,");//4,5
     sb.append("(select b.CEN_NAME from center b where b.CEN_CODE=a.PROD_CEN_CODE) as j_cen,");//6
     sb.append("dep.DEP_name as j_dep,");//7
     sb.append("a.PROD_YEAR,");//8
     sb.append("(select d.SEA_NAME from season d where d.SEA_NAME=a.PROD_SEASON) as j_sea,");//9
     sb.append("(select nvl(f.BYMKR_HK_CODE,f.BYMKR_BRIEF) from buyer_maker f where f.BYMKR_SEQ=a.PROD_BUYER) as j_buyer,");//10
     sb.append("(select f2.BYMKR_NAME from buyer_maker f2 where f2.BYMKR_SEQ=a.PROD_BUYER) as j_buyer_full_name,");//11
     sb.append("'' as buyer_name,");//12
     sb.append("(select f3.BYMKR_ADDR1 from buyer_maker f3 where f3.BYMKR_SEQ=a.PROD_BUYER) as j_buyer_addr1,");//13
     sb.append("(select f3.BYMKR_ADDR2 from buyer_maker f3 where f3.BYMKR_SEQ=a.PROD_BUYER) as j_buyer_addr2,");//14
     sb.append("(select f3.BYMKR_ADDR3 from buyer_maker f3 where f3.BYMKR_SEQ=a.PROD_BUYER) as j_buyer_addr3,");//15
     sb.append("(select f3.BYMKR_ADDR4 from buyer_maker f3 where f3.BYMKR_SEQ=a.PROD_BUYER) as j_buyer_addr4,");//16
     sb.append("'' as buyer_address,");//17

     sb.append("(select nvl(g.BYMKR_HK_CODE,g.BYMKR_BRIEF) from buyer_maker g where g.BYMKR_SEQ=a.PROD_MAKER) as j_maker,");//18
     sb.append("(select g2.BYMKR_NAME from buyer_maker g2 where g2.BYMKR_SEQ=a.PROD_MAKER) as j_maker_full_name,");//19
     sb.append("'' as maker_name,");//20
     sb.append("(select f3.BYMKR_ADDR1 from buyer_maker f3 where f3.BYMKR_SEQ=a.PROD_MAKER) as j_maker_addr1,");//21
     sb.append("(select f3.BYMKR_ADDR2 from buyer_maker f3 where f3.BYMKR_SEQ=a.PROD_MAKER) as j_maker_addr2,");//22
     sb.append("(select f3.BYMKR_ADDR3 from buyer_maker f3 where f3.BYMKR_SEQ=a.PROD_MAKER) as j_maker_addr3,");//23
     sb.append("(select f3.BYMKR_ADDR4 from buyer_maker f3 where f3.BYMKR_SEQ=a.PROD_MAKER) as j_maker_addr4,");//24
     sb.append("'' as maker_address,");//25
     sb.append("a.PROD_CONFIRM_MNG, to_char(a.RECORD_modify_DATE,'YYYY/MM/DD HH24:MI:SS') as record_modify_at");//26,27
     sb.append(",decode(prodXN.prod_audit_status,'2','3',prodXN.prod_audit_status) as prod_audit_status, ");//28
     sb.append("'....' as xbutton,'' as testCheck,");//29,//30
     //sb.append("a.record_modify_user ");//31
     sb.append(" nvl(GET_LAST_MODIFY_USER(a.prod_head_pk),a.record_modify_user) as record_modify_user "); //31
     //-------20070809------
     sb.append(",nvl((select  max(m_dtae) from order_m_h where prod_head_pk=a.prod_head_pk),a.record_modify_date) as final_modify_date ");
     //----end of 20070809----------
     sb.append("from prod_head a,department dep,production prodXN ");
     sb.append("where  1=1 ");
     sb.append("and a.PROD_DEPTMENT=dep.DEP_CODE ");
     sb.append("and prodXN.prod_head_pk=a.prod_head_pk ");
     initialHeadSQL=sb.toString();
  }
  public Vector getRecords(int bgn,int rowcount){
    try
    {
      if(lastBgn==bgn && lastLength ==rowcount){
        return lestVector4Return;
      }

     if(CURRENT_QRY_SQL==null){
      if (conditions == null)conditions = new HashMap();
      conditions.clear();
      conditions.putAll(STATIC_CONDITIONS);
      Iterator itr = conditions.keySet().iterator();
      StringBuffer sb = new StringBuffer(initialHeadSQL);
      sb.append(" and (a.record_delete_flag='1' or a.record_delete_flag='z')" ); // <----even reject record,can be regard as reject.
      while (itr.hasNext()) {
        sb.append(" and ");
        String key = (String)itr.next();
        if (!key.equals(PreProductionHead.QRY_CONDITION_MATERIAL)) {
          if (key.equals(PreProductionHead.CONDITION_KEY_PROTO_NO)) {
            sb.append(
                " a.PROD_HEAD_PK in ( select h.PREPROD_PROD_PK from PREPROD h where ");
            sb.append(key);
            sb.append("=");
            sb.append("'");
            sb.append(util.MiscFunc.Replace((String)conditions.get(key), "'",
                                            "''"));
            sb.append("')");
          } else if (key.equals("prodxn.prod_byr_sc_no")) {
            /*
            //sb.append("( ");
            sb.append(" prodxn.prod_byr_sc_no ");
            sb.append(" like ");
            sb.append("'");
            sb.append(util.MiscFunc.Replace((String)conditions.get(key), "'",
                                            "''"));
            sb.append("%' ");
            */
          }else if(key.equals(PreProductionHead.CONDITION_KEY_STY_PO)){
            sb.append("( ");
            sb.append(" a.PROD_HEAD_PK in (select PROD_HEAD_PK from STYLE where ");
            sb.append(key);
            //sb.append("=");
            sb.append(" like ");
            sb.append("'");
            sb.append(util.MiscFunc.Replace((String)conditions.get(key),"'","''"));
            //sb.append("' and STYLE.record_delete_flag='1')");
            sb.append("%' and STYLE.record_delete_flag='1')");

            sb.append(" or ");
            sb.append(" prodXN.prod_byr_sc_no like '");
            sb.append(util.MiscFunc.Replace((String)conditions.get(key),"'","''"));
            sb.append("%')");

          }else if(key.equals(PreProductionHead.CONDITION_KEY_STY_STYLE)){
            sb.append(
            " a.PROD_HEAD_PK in ( select PROD_HEAD_PK from STYLE where ");
            sb.append(key);
            //sb.append("=");
            sb.append(" like ");
            sb.append("'");
            sb.append(util.MiscFunc.Replace((String)conditions.get(key),"'","''"));
            //sb.append("' and STYLE.record_delete_flag='1') ");
            sb.append("%' and STYLE.record_delete_flag='1') ");

          } else if (key.equals(PreProductionHead.CONDITION_KEY_BGN_SC_NO)) {
            String centerCode=(String)conditions.get(PreProductionHead.QRY_CONDITION_CENTER);
            if(centerCode.equals("001")||centerCode.equals("NTHK")){
              sb.append(key);
              sb.append(" like '");
              sb.append(util.MiscFunc.Replace((String)conditions.get(key),
                                              "'",
                                              "''"));
              sb.append("%'");

            }else{
              sb.append(key);
              sb.append(" like '%");
              sb.append(util.MiscFunc.Replace((String)conditions.get(key),
                                              "'",
                                              "''"));
              sb.append("%'");
            }

          }else if  (key.equals(CONDITION_KEY_SHIP_FTY_INV)) {
            String fty_inv=(String)conditions.get(CONDITION_KEY_SHIP_FTY_INV);
            sb.append(" prodXN.prod_head_pk in (select style.prod_head_pk from style where sty_seq in ");
            sb.append(" (");
            sb.append(
                "   select sty_seq from ship_style where ship_sc_pk in ");
            sb.append("   (select ship_sc_pk from ship_sc where ship_no in ");
            sb.append(
                "     (select ship_no from shipping where ship_fty_inv like '%");
            sb.append(util.MiscFunc.Replace(fty_inv,"'","''"));
            sb.append("%')) ");
            sb.append("         and ship_style.record_delete_flag='1'");
            sb.append(" ))");
          } else if (key.equals(CONDITION_KEY_ETD_FROM)) {
            java.util.Date fromDate = (java.util.Date)conditions.get(
                CONDITION_KEY_ETD_FROM);
            sb.append(" prodXN.prod_head_pk in (select style.prod_head_pk from style where sty_seq in ");
            sb.append(" (");
            sb.append(
                "   select sty_seq from ship_style where ship_sc_pk in ");
            sb.append("   (select ship_sc_pk from ship_sc where ship_no in ");
            sb.append(
                "     (select ship_no from shipping where ship_etd_date >= ");
            sb.append(currentEncoder.encode(fromDate));
            sb.append(")) ");
            sb.append("         and ship_style.record_delete_flag='1'");
            sb.append(" ))");

          } else if (key.equals(CONDITION_KEY_ETD_TO)) {
            java.util.Date toDate = (java.util.Date)conditions.get(
                CONDITION_KEY_ETD_TO);
            sb.append("  prodXN.prod_head_pk in (select style.prod_head_pk from style where sty_seq in ");
            sb.append(" (");
            sb.append(
                "   select sty_seq from ship_style where ship_sc_pk in ");
            sb.append("   (select ship_sc_pk from ship_sc where ship_no in ");
            sb.append(
                "     (select ship_no from shipping where ship_etd_date <= ");
            sb.append(currentEncoder.encode(toDate));
            sb.append(")) ");
            sb.append("         and ship_style.record_delete_flag='1'");
            sb.append(" )) ");
          } else if (key.equals(CONDITION_KEY_ETD_FROM_AND_TO)) {
            java.util.Date[] dateRange = (java.util.Date[])conditions.get(
                CONDITION_KEY_ETD_FROM_AND_TO);
            sb.append("  prodXN.prod_head_pk in (select style.prod_head_pk from style where sty_seq in");
            sb.append(" (");
            sb.append(
                "   select sty_seq from ship_style where ship_sc_pk in ");
            sb.append("   (select ship_sc_pk from ship_sc where ship_no in ");
            sb.append(
                "     (select ship_no from shipping where ship_etd_date >= ");
            sb.append(currentEncoder.encode(dateRange[0]));
            sb.append(" and ship_etd_date <=");
            sb.append(currentEncoder.encode(dateRange[1]));
            sb.append(")) ");
            sb.append("         and ship_style.record_delete_flag='1'");
            sb.append(" ))");
          } else {
            sb.append(key);
            Object obj = conditions.get(key);
            if (obj instanceof java.lang.String) {
              sb.append("='");
              sb.append(util.MiscFunc.Replace((String)conditions.get(key),
                                              "'",
                                              "''"));
              sb.append("'");
            } else {
              sb.append("=");
              sb.append(obj);
            }
          }
        } else {
          sb.append(" ( a.PROD_HEAD_PK in (select MTR_V_PREPROD_PROD_HEAD_PK from mtr_v_preprod  where MTR_V_PREPROD_MTRDTL_PK='");
          sb.append(conditions.get(key));
          sb.append("'))");
        }

      }
      sb.append(" order by to_char(a.RECORD_create_DATE,'YYYY/MM/DD HH24:MI:SS') ");
      System.out.println("sql is " + sb.toString());
      CURRENT_QRY_SQL=sb.toString();
    }


        Vector vct2Return = exgui2.CONST.BASIC_MAIN_EJB.getDatas(
         util.PublicVariable.USER_RECORD,
         CURRENT_QRY_SQL,bgn,rowcount);

      //tblTmp.SQL2Records(sb.toString(), startAt, length);
        if(vct2Return == null)
        {
            throw new Exception("sql exception");
        } else
        {
            Vector vector = makerLinesWithFullBuyerMakerData(vct2Return);
            lastBgn=bgn;
            lastLength=rowcount;
            lestVector4Return=vector;
            return vector;
        }
    }
    catch(Exception e){
        e.printStackTrace();
        util.ExceptionLog.exp2File(e, "exception while generate records depends on the conditions.");
        return null;
    }

  }
  public  static void updatePoStatus(String sc_no,String statusCode,String remark)throws Exception{
    if(appHandler==null){
      try{
        newtimesejb.NthkAppvCnfm.AppvCnfmFacadeHome apHome=
            (newtimesejb.NthkAppvCnfm.AppvCnfmFacadeHome)
            info_ejb.WeblogicServiceLocator.locateServiceHome(util.PublicVariable.SERVER_URL,
            "newtimesejb.NthkAppvCnfm.AppvCnfmFacade");
        appHandler=apHome.create();
      }catch(Exception exp){
        exp.printStackTrace();
        util.ExceptionLog.exp2File(exp,"");
        exgui.verification.VerifyLib.showAlert(
         "Server Side Error\nPlease Contatct System Manager",
         "EJB create Failed");
         appHandler=null;
      }
   }
    appHandler.updateAudit(sc_no,statusCode,remark,
                           (String)util.PublicVariable.USER_RECORD.get(0));
  }
  public void updatePoStatus(java.util.HashMap scStatusMap,java.util.HashMap scCancelRznMap)throws Exception{
    if(appHandler==null){
      try{
        newtimesejb.NthkAppvCnfm.AppvCnfmFacadeHome apHome=
            (newtimesejb.NthkAppvCnfm.AppvCnfmFacadeHome)
            info_ejb.WeblogicServiceLocator.locateServiceHome(util.PublicVariable.SERVER_URL,
            "newtimesejb.NthkAppvCnfm.AppvCnfmFacade");
        appHandler=apHome.create();
      }catch(Exception exp){
        exp.printStackTrace();
        util.ExceptionLog.exp2File(exp,"");
        exgui.verification.VerifyLib.showAlert(
         "Server Side Error\nPlease Contatct System Manager",
         "EJB create Failed");
         appHandler=null;
      }
   }

     appHandler.batchUpdateStatus(scStatusMap,scCancelRznMap,
                                  (String)util.PublicVariable.USER_RECORD.get(0));

  }

}
