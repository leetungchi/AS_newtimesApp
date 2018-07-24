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

public class Db4BrandBaseStatus extends exgui.ultratable.PagedDataFactoryAdapter {
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
  public Db4BrandBaseStatus() {
    StringBuffer sb=new StringBuffer();
    sb.append("select ");
    sb.append("price.pri_seq,a.PROD_HEAD_PK,prodXN.prod_sc_no as sc_no, ");
    sb.append("nvl(style.sty_po,prodxn.prod_byr_sc_no) as sty_po, ");
    sb.append("style.sty_style, style.STY_ORIG_DEL as etd_date , ");
    sb.append("prodxn.PROD_TGT_DEST as cnty_dest,");
    sb.append("(select prod_color_code from prod_color where prod_color.prod_color_pk=price.prod_color_pk) as color_code, ");
    sb.append("(select prod_color_name from prod_color where prod_color.prod_color_pk=price.prod_color_pk) as color, ");
    sb.append("PRICE.PRI_BYR_DOC_PRX as cost, ");
    sb.append("GET_COLOR_QTY(price.pri_seq) as prx_qty, ");
    sb.append("(select APRVL_REQ_DATE from NTFE_BRADBASE_STATUS bbs where bbs.pri_seq=price.pri_seq) as APRVL_REQ_DATE, ");
    sb.append("(select BUYER_APRVL_DATE from NTFE_BRADBASE_STATUS bbs where bbs.pri_seq=price.pri_seq) as BUYER_APRVL_DATE ");
    sb.append("from prod_head a,department dep,production prodXN,prod_ct_infor ctinfor ,style ,price ");
    sb.append("where  1=1 ");
    sb.append("and a.PROD_DEPTMENT=dep.DEP_CODE ");
    sb.append("and prodXN.prod_head_pk=a.prod_head_pk ");
    sb.append("and a.prod_head_pk=ctinfor.prod_head_pk(+) ");
    sb.append("and style.prod_head_pk=prodxn.prod_head_pk  ");
    sb.append("and style.record_delete_flag='1' ");
    sb.append("and pri_sty_seq=style.sty_seq ");
    sb.append("and price.record_delete_flag='1' ");

    initialHeadSQL=sb.toString();
    sb=new StringBuffer();
    sb.append("  style.sty_seq in ");
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
    sb.append(" )");
    ship_condition_sql=sb.toString();
  }
  public static void setReCondition(java.util.HashMap hm){
    STATIC_CONDITIONS.clear();
    if(util.PublicVariable.USER_RECORD.getInt(2)==
       newtimesejb.preproduction.PreProductionHead.USER_TYPE_ABROAD_USERS){
      hm.put("a.PROD_OFFSHORE_CENTER", util.PublicVariable.USER_RECORD.get(4));
    }
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
    try
    {
      if(lastBgn==bgn && lastLength ==rowcount){
        return lestVector4Return;
      }

     if(CURRENT_QRY_SQL==null){
      if (conditions == null)conditions = new HashMap();
      conditions.clear();
      conditions.putAll(STATIC_CONDITIONS);
      boolean isShipmentConditionConbined=false;
      /*
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
      */


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
      String venderSeq=null;
      if(conditions.containsKey("CT_VENDER")){
         Object venderSeqobj=conditions.get("CT_VENDER");
         venderSeq=((venderSeqobj==null)?null:venderSeqobj.toString());
        //conditions.remove("CT_VENDER");
      }

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

      StringBuffer sb = new StringBuffer(initialHeadSQL);
      sb.append(" and a.record_delete_flag='1'");

      if (conditions.containsKey(CONDITION_KEY_ETD_TO)){
         java.util.Date toDate = (java.util.Date)conditions.get(CONDITION_KEY_ETD_TO);
         sb.append("and  style.STY_ORIG_DEL <= ");
         sb.append(currentEncoder.encode(toDate));
         conditions.remove(CONDITION_KEY_ETD_TO);

      }
      if (conditions.containsKey(CONDITION_KEY_ETD_FROM)){
         java.util.Date fromDate = (java.util.Date)conditions.get(CONDITION_KEY_ETD_FROM);
         sb.append("and  style.STY_ORIG_DEL >= ");
         sb.append(currentEncoder.encode(fromDate));
         conditions.remove(CONDITION_KEY_ETD_FROM);
      }


      Iterator itr = conditions.keySet().iterator();
      while (itr.hasNext()) {
        sb.append(" and ");
        String key = (String)itr.next();

        if(key.equalsIgnoreCase("a.PROD_BUYER")){
           sb.append(" a.PROD_BUYER in (");
           sb.append("11108,11779)");
           sb.append(" ");
           continue;
        }
        if (!key.equals(PreProductionHead.QRY_CONDITION_MATERIAL)) {
          if(key.equals("CT_VENDER")){
            if(venderSeq!=null){
              sb.append(" ctinfor.vender_seq=");
              sb.append(venderSeq);
              sb.append(" ");
            }
            venderSeq=null;
          }else if (key.equals(PreProductionHead.CONDITION_KEY_PROTO_NO)) {
            sb.append(" a.PROD_HEAD_PK in ( select h.PREPROD_PROD_PK from PREPROD h where ");
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
            sb.append(key);
            //sb.append("=");
            sb.append(" like ");
            sb.append("'");
            sb.append(util.MiscFunc.Replace((String)conditions.get(key),"'","''"));
            sb.append("%' ");

            sb.append(" or ");
            sb.append(" prodXN.prod_byr_sc_no like '");
            sb.append(util.MiscFunc.Replace((String)conditions.get(key),"'","''"));
            sb.append("%')");

          }else if(key.equals(PreProductionHead.CONDITION_KEY_STY_STYLE)){
            sb.append(key);
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
            sb.append(" style.sty_seq in ");
            sb.append(" (");
            sb.append(
                "   select sty_seq from ship_style where ship_sc_pk in ");
            sb.append("   (select ship_sc_pk from ship_sc where ship_no in ");
            sb.append(
                "     (select ship_no from shipping where ship_fty_inv like '%");
            sb.append(util.MiscFunc.Replace(fty_inv,"'","''"));
            sb.append("%')) ");
            sb.append("         and ship_style.record_delete_flag='1'");
            sb.append(" )");

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
            //Vector vector = makerLinesWithFullBuyerMakerData(vct2Return,true);
            lastBgn=bgn;
            lastLength=rowcount;
            lestVector4Return=vct2Return;
            return vct2Return;
        }
    }
    catch(Exception e){
        e.printStackTrace();
        util.ExceptionLog.exp2File(e, "exception while generate records depends on the conditions.");
        return null;
    }
  }
  public void updateRecords(Vector vct)throws Exception{
    try {
      if(vct==null||vct.size()==0)return;
      newtimesejb.TPE_MIS.TpeMisFuncHome ejbHome=
          (newtimesejb.TPE_MIS.TpeMisFuncHome)
          info_ejb.WeblogicServiceLocator.locateServiceHome(
          util.PublicVariable.SERVER_URL,
          "newtimesejb.TPE_MIS.TpeMisFunc");

      newtimesejb.TPE_MIS.TpeMisFunc ejb2update=ejbHome.create();
      java.util.HashMap hmParam=new java.util.HashMap();
      hmParam.put("TPEMISCFUNC_ACTION_CODE","AXN_CODE:updateBrandBaseStatus");
      hmParam.put("VCT:BrandBaseStatus",vct);
      hmParam.put("userId",util.PublicVariable.USER_RECORD.get(0));
      ejb2update.tpeMisFunc(hmParam);
      exgui.verification.VerifyLib.showPlanMsg("UPDATE OK","UPDATE OK");
    }catch(Exception exp){
      exp.printStackTrace();
    }

  }
  protected Vector makerLinesWithFullBuyerMakerData(Vector vct)throws Exception{
    return makerLinesWithFullBuyerMakerData(vct,false);
  }
  protected String obj2String(Object obj){
    if(obj==null)return "";
    return obj.toString();
  }
  protected Vector makerLinesWithFullBuyerMakerData(Vector vct,boolean withPoStyle)throws Exception{
    Vector vct2return=new Vector();
    for(int i=0;i<vct.size();i++){
      Record rec=(Record)vct.get(i);
      //combine brief name & full name to be 2 lines name data,
        StringBuffer sb=new StringBuffer();
        sb.append("<html><body>");
        sb.append(obj2String(rec.get(10)));sb.append("<br>");
        sb.append(obj2String(rec.get(11)));
        sb.append("</body></html>");
        rec.set(12,sb.toString());//set to buyer_name field

        StringBuffer sbBuyerAdd=new StringBuffer();
        sbBuyerAdd.append("<html><body>");
        if(rec.get(13)!=null)sbBuyerAdd.append(rec.get(13));
        if(rec.get(14)!=null){sbBuyerAdd.append("<br>");sbBuyerAdd.append(rec.get(14));}
        if(rec.get(15)!=null){sbBuyerAdd.append("<br>");sbBuyerAdd.append(rec.get(15));}
        if(rec.get(16)!=null){sbBuyerAdd.append(" ");sbBuyerAdd.append(rec.get(16));}
        sbBuyerAdd.append("</body></html>");
        rec.set(17,sbBuyerAdd.toString());

        StringBuffer sb2=new StringBuffer();
        sb2.append("<html><body>");
        sb2.append(obj2String(rec.get(18)));sb2.append("<br>");
        sb2.append(obj2String(rec.get(19)));
        sb2.append("</body></html>");
        rec.set(20,sb2.toString());//set to maker_name field

        StringBuffer sbMakerAdd=new StringBuffer();
        sbMakerAdd.append("<html><body>");
        if(rec.get(21)!=null)sbMakerAdd.append(rec.get(21));
        if(rec.get(22)!=null){sbMakerAdd.append("<br>");sbMakerAdd.append(rec.get(22));}
        if(rec.get(23)!=null){sbMakerAdd.append("<br>");sbMakerAdd.append(rec.get(23));}
        if(rec.get(24)!=null){sbMakerAdd.append(" ");sbMakerAdd.append(rec.get(24));}
        sbMakerAdd.append("</body></html>");
        rec.set(25,sbMakerAdd.toString());
        if(withPoStyle){
          //-----------------20060727,add style and po field---------
          StringBuffer sbStylePo = new StringBuffer();
          sbStylePo.append("<html><body>");
          Object objStyle = rec.get(33);
          Object poObj = (rec.get(2) == null) ? rec.get(34) : rec.get(2);
          sbStylePo.append((poObj == null) ? "" : poObj);
          sbStylePo.append("<br>");
          sbStylePo.append((objStyle == null) ? "" : (String)objStyle);
          sbStylePo.append("</body></html>");
          rec.set(35, sbStylePo.toString()); //set to PO_AND_STYLE
          //--------end---------20060727--------------------------------
          //         BGN 20060801 ,the damm PW/BW ship user,require price term & destination
          StringBuffer sbPrxTermGoodsDest=new StringBuffer();
           sbPrxTermGoodsDest.append("<html><body>");
           sbPrxTermGoodsDest.append(obj2String(rec.get(39)));
           sbPrxTermGoodsDest.append("<br>");
           sbPrxTermGoodsDest.append(obj2String(rec.get(40)));
           sbPrxTermGoodsDest.append("</body></html>");
           rec.set(38,sbPrxTermGoodsDest.toString()) ;
          //         END 20060801
        }
      //combine full address lines into address field

      vct2return.add(rec);
    }
    return  vct2return;
  }
}
