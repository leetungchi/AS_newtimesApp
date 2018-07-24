package newtimes.nthk_accounting_enqry;
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

public class EnqDataEngin extends exgui.ultratable.PagedDataFactoryAdapter {
  String initialHeadSQL=null;
  protected static java.util.HashMap STATIC_CONDITIONS=new HashMap();
  static String CONDITION_KEY_ETD_FROM="CONDITION_KEY_ETD_FROM";
  static String CONDITION_KEY_ETD_TO="CONDITION_KEY_ETD_TO";
  static String CONDITION_KEY_ETD_FROM_AND_TO="CONDITION_KEY_ETD_FROM_AND_TO";
  static String CONDITION_KEY_SHIP_FTY_INV="CONDITION_KEY_SHIP_FTY_INV";
  static String CONDITION_KEY_SHIP_STYLE_CREATE_DATE="CONDITION_KEY_SHIP_STYLE_CREATE_DATE";
  static String CONDITION_KEY_SHIP_STYLE_CREATE_USER="CONDITION_KEY_SHIP_STYLE_CREATE_USER";
  static String CONDITION_KEY_SHIP_IC_INV_TYPE="CONDITION_KEY_SHIP_IC_INV_TYPE";
  static database.Encoder currentEncoder=new database.encoders.OracleEncoder();
  protected static String CURRENT_QRY_SQL=null;
   int lastBgn=-1;
   int lastLength=-1;
  Vector lestVector4Return;
  String ship_condition_sql;
  public EnqDataEngin() {
    StringBuffer sb=new StringBuffer();
    sb.append("select sss.sty_seq,");
    sb.append("prodXN.prod_sc_no,sss.STY_STYLE,sss.sty_po, ");
    sb.append("(select PRI_BYR_ACT_PRX from price where pri_sty_seq=sss.sty_seq and record_delete_flag='1' and rownum=1) as buyer_act_prx,");
    sb.append("(select PRI_BYR_DOC_PRX from price where pri_sty_seq=sss.sty_seq and record_delete_flag='1' and rownum=1) as buyer_doc_prx,");
    sb.append("(select PRI_MKR_ACT_PRX from price where pri_sty_seq=sss.sty_seq and record_delete_flag='1' and rownum=1) as maker_act_prx,");
    sb.append("(select PRI_MKR_DOC_PRX from price where pri_sty_seq=sss.sty_seq and record_delete_flag='1' and rownum=1) as maker_doc_prx,");
    sb.append("sss.STY_TOTAL_QTY,");
    sb.append("(select sum(SHIP_STY_TOTAL_QTY) from ship_style where ship_style.sty_seq=sss.sty_seq ");
    sb.append(" and record_delete_flag='1') as ship_qty ");
    sb.append(" ,'' as SRN_LIST ");
    //sb.append("from prod_head a,department dep,production prodXN,prod_ct_infor ctinfor,style sss ");
    sb.append("from prod_head a,department dep,production prodXN,style sss ");
    sb.append("where  1=1 ");
    sb.append("and a.prod_head_pk=sss.prod_head_pk ");
    sb.append("and a.PROD_DEPTMENT=dep.DEP_CODE ");
    sb.append("and prodXN.prod_head_pk=a.prod_head_pk ");
    //sb.append("and a.prod_head_pk=ctinfor.prod_head_pk(+) ");
    initialHeadSQL=sb.toString();
    sb=new StringBuffer();
    sb.append(" prodXN.prod_head_pk in (select style.prod_head_pk from style where sty_seq in ");
    sb.append(" (");
    sb.append("   select sty_seq from ship_style where 3=3 and 4=4 and ship_sc_pk in ");//ship-style-create user, &date
    sb.append("   (select ship_sc_pk from ship_sc where _conditions_shipno_len_ and _conditions_shipno_prfix_ and ship_no in (select ship_no from shipping where ");
    sb.append("    1=1 ");//ship_etd_date from
    sb.append("   and 2=2 ");//ship_etd_date to
    sb.append("   and 5=5 ");//ship-inv_ic_type.
    //sb.append("(select ship_no from shipping where ship_etd_date >= ");
    //sb.append(currentEncoder.encode(fromDate));
    //sb.append(")");
    sb.append("))");
    sb.append("         and ship_style.record_delete_flag='1'");
    sb.append(" ))");
    ship_condition_sql=sb.toString();
  }
  public static void setReCondition(java.util.HashMap hm){
    STATIC_CONDITIONS.clear();
    STATIC_CONDITIONS.putAll(hm);
    CURRENT_QRY_SQL=null;
  }
  public static String getCeterPrifx(String centercode)throws Exception{
    for(int i=0;i<newtimes.preproduction.guis.tempProperties.tmpCenters.size();i++){
      Record recCenter=(Record)newtimes.preproduction.guis.tempProperties.tmpCenters.get(i);
      if(recCenter.get("cen_code").equals(centercode)){
        return (String)recCenter.get("cen_prefix");
      }
    }
    return null;
  }
  public Vector getRecords(int bgn,int rowcount){
    try{
      util.MiscFunc.showProcessingMessage();
      if(lastBgn==bgn && lastLength ==rowcount){
        return lestVector4Return;
      }

     if(CURRENT_QRY_SQL==null){
      if (conditions == null)conditions = new HashMap();
      conditions.clear();
      conditions.putAll(STATIC_CONDITIONS);
      boolean isShipmentConditionConbined=false;

      if (conditions.containsKey(CONDITION_KEY_ETD_FROM)){
       if(!isShipmentConditionConbined){
         isShipmentConditionConbined=true;
       }
       java.util.Date fromDate = (java.util.Date)conditions.get(CONDITION_KEY_ETD_FROM);
       StringBuffer sbCondition=new StringBuffer();
       sbCondition.append(" ship_etd_date >= ");
       sbCondition.append(currentEncoder.encode(fromDate));
       sbCondition.append("");
       ship_condition_sql=util.MiscFunc.Replace(ship_condition_sql,"1=1",sbCondition.toString());
       conditions.remove(CONDITION_KEY_ETD_FROM);
      }


      if (conditions.containsKey(CONDITION_KEY_ETD_TO)){
       if(!isShipmentConditionConbined){
         isShipmentConditionConbined=true;
       }
       java.util.Date toDate = (java.util.Date)conditions.get(CONDITION_KEY_ETD_TO);
       StringBuffer sbCondition=new StringBuffer();
       sbCondition.append(" ship_etd_date <= ");
       sbCondition.append(currentEncoder.encode(toDate));
       sbCondition.append("");
       ship_condition_sql=util.MiscFunc.Replace(ship_condition_sql,"2=2",sbCondition.toString());
       conditions.remove(CONDITION_KEY_ETD_TO);
      }

      if (conditions.containsKey(CONDITION_KEY_SHIP_STYLE_CREATE_DATE)){
       if(!isShipmentConditionConbined){
         isShipmentConditionConbined=true;
       }
       java.util.Date shipStyleCreteDate = (java.util.Date)conditions.get(CONDITION_KEY_SHIP_STYLE_CREATE_DATE);
       StringBuffer sbCondition=new StringBuffer();
       sbCondition.append(" ship_style.record_create_date>= ");
       sbCondition.append(currentEncoder.encode(shipStyleCreteDate));
       sbCondition.append(" ");
       ship_condition_sql=util.MiscFunc.Replace(ship_condition_sql,"3=3",sbCondition.toString());
       conditions.remove(CONDITION_KEY_SHIP_STYLE_CREATE_DATE);
      }

      if (conditions.containsKey(CONDITION_KEY_SHIP_STYLE_CREATE_USER)){
       if(!isShipmentConditionConbined){
         isShipmentConditionConbined=true;
       }
       String createUserId=(String)conditions.get(CONDITION_KEY_SHIP_STYLE_CREATE_USER);
       createUserId=util.MiscFunc.Replace(createUserId,"'","''");
       StringBuffer sbCondition=new StringBuffer();
       sbCondition.append(" ship_style.record_create_user like '%");
       sbCondition.append(createUserId);
       sbCondition.append("%'");
       ship_condition_sql=util.MiscFunc.Replace(ship_condition_sql,"4=4",sbCondition.toString());
       conditions.remove(CONDITION_KEY_SHIP_STYLE_CREATE_USER);
      }


      if (conditions.containsKey(CONDITION_KEY_SHIP_IC_INV_TYPE)){
       if(!isShipmentConditionConbined){
         isShipmentConditionConbined=true;
       }
       String shipIcInvType=(String)conditions.get(CONDITION_KEY_SHIP_IC_INV_TYPE);
       StringBuffer sbCondition=new StringBuffer();
       sbCondition.append(" get_ship_ic_inv_type(shipping.ship_no)='");
       sbCondition.append(shipIcInvType);
       sbCondition.append("'");
       ship_condition_sql=util.MiscFunc.Replace(ship_condition_sql,"5=5",sbCondition.toString());
       conditions.remove(CONDITION_KEY_SHIP_IC_INV_TYPE);
      }
      //_conditions_shipno_len_ and _conditions_shipno_prfix_

      if(isShipmentConditionConbined){
        int ship_no_len=13;
        if(util.PublicVariable.OPERATTING_CENTER.equals("NTHK")||
           util.PublicVariable.OPERATTING_CENTER.equals("001")){
          ship_no_len=12;
        }
        ship_condition_sql=
            util.MiscFunc.Replace(ship_condition_sql,"_conditions_shipno_len_"," length(ship_no)="+String.valueOf(ship_no_len),false);
        String test4prefix=null;
        if(util.PublicVariable.OPERATTING_CENTER.equals("NTHK")){
           test4prefix="substr(ship_no,1,4)='ZNNT'";
        }else  if(util.PublicVariable.OPERATTING_CENTER.equals("001")){
           test4prefix="substr(ship_no,1,4)='ZATW'";
        }else {
          String centerprix=getCeterPrifx(util.PublicVariable.OPERATTING_CENTER);
          test4prefix="substr(ship_no,4,2)='"+centerprix+"'";
        }
        ship_condition_sql=
            util.MiscFunc.Replace(ship_condition_sql,"_conditions_shipno_prfix_", test4prefix,false);

      }

      Iterator itr = conditions.keySet().iterator();
      StringBuffer sb = new StringBuffer(initialHeadSQL);
      sb.append(" and a.record_delete_flag='1'");

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
            sb.append("(");
            sb.append(" sss.sty_po like ");
            sb.append("'");
            sb.append(util.MiscFunc.Replace((String)conditions.get(key),"'","''"));
            sb.append("%' ");
            sb.append(" or ");
            sb.append(" prodXN.prod_byr_sc_no like '");
            sb.append(util.MiscFunc.Replace((String)conditions.get(key),"'","''"));
            sb.append("%'");
            sb.append(")");

            /*
            sb.append("( ");
            sb.append(" a.PROD_HEAD_PK in (select PROD_HEAD_PK from STYLE where ");
            sb.append(key);
            sb.append(" like ");
            sb.append("'");
            sb.append(util.MiscFunc.Replace((String)conditions.get(key),"'","''"));
            sb.append("%' and STYLE.record_delete_flag='1')");
            sb.append(" or ");
            sb.append(" prodXN.prod_byr_sc_no like '");
            sb.append(util.MiscFunc.Replace((String)conditions.get(key),"'","''"));
            sb.append("%')");*/

          }else if(key.equals(PreProductionHead.CONDITION_KEY_STY_STYLE)){
            sb.append(
            " sss.sty_style ");
            //sb.append(key);
            //sb.append("=");
            sb.append(" like ");
            sb.append("'");
            sb.append(util.MiscFunc.Replace((String)conditions.get(key),"'","''"));
            //sb.append("' and STYLE.record_delete_flag='1') ");
            sb.append("%' ");

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

            /*
            sb.append(key);
            sb.append(" like '");
            sb.append(util.MiscFunc.Replace((String)conditions.get(key), "'",
                                            "''"));
            sb.append("%'");*/

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
      if(isShipmentConditionConbined){
        sb.append("and ");
        sb.append( ship_condition_sql );
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
            Vector vector = makeVecterWithSRNList(vct2Return);
            lastBgn=bgn;
            lastLength=rowcount;
            return vector;
        }
    }
    catch(Exception e){
        e.printStackTrace();
        util.ExceptionLog.exp2File(e, "exception while generate records depends on the conditions.");
        return null;
    }finally{
      util.MiscFunc.hideProcessingMessage();
    }
  }
  public HashMap getSrnList(Vector vct)throws Exception{
    java.util.HashMap hm=new java.util.HashMap();
    StringBuffer sb=new StringBuffer();
    sb.append("select sty_seq,GET_SRN_LIST_STR_OF_STYSEQ(sty_seq) from style where sty_seq in (");
    sb.append("0");
    for(int i=0;i<vct.size();i++){
      Record rec=(Record)vct.get(i);
      sb.append(",");
      sb.append(rec.get(0).toString());
    }
    sb.append(")");
    Vector vctSrn=exgui2.CONST.BASIC_MAIN_EJB.getDatas(
      util.PublicVariable.USER_RECORD,
      sb.toString(),1,99999
      );
    for(int i=0;i<vctSrn.size();i++){
      Record recTmp=(Record)vctSrn.get(i);
      hm.put(recTmp.get(0).toString(),(String)recTmp.get(1));
    }
    return hm;
  }
  public void updateRecords(Vector vct)throws Exception{}

  public Vector makeVecterWithSRNList(Vector orgVct)throws Exception{
        java.util.HashMap hm=getSrnList(orgVct);
        Vector vct2Return=new Vector();
        for(int i=0;i<orgVct.size();i++){
          Record recOrg=(Record)orgVct.get(i);
          recOrg.set("SRN_LIST",hm.get(recOrg.get(0).toString()));
          vct2Return.add(recOrg);
        }
        return vct2Return;
  }

  protected String obj2String(Object obj){
    if(obj==null)return "";
    return obj.toString();
  }
}
