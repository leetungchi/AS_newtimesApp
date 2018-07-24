package newtimes.nthk_accounting_enqry;
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

public class EnqDataEnginXCenter extends EnqDataEngin {
  public EnqDataEnginXCenter() {
    StringBuffer sb=new StringBuffer();
    sb.append("select ");
    sb.append("sss.sty_seq,");
    sb.append("prodXN.prod_sc_no,");
    sb.append("sss.STY_STYLE,");
    sb.append("sss.sty_po,");
    sb.append("prx.PRI_BYR_ACT_PRX as buyer_act_prx,");
    sb.append("prx.PRI_BYR_DOC_PRX as buyer_doc_prx,");
    sb.append("prx.PRI_MKR_ACT_PRX as maker_act_prx,");
    sb.append("prx.PRI_MKR_DOC_PRX as maker_doc_prx,");
    sb.append("pc.prod_color_pk,");// 8th column
    sb.append("pc.prod_color_code,");
    sb.append("pc.prod_color_name,");
    sb.append("GET_ORDER_QTY_BY_COLOR_STY(sss.sty_seq,pc.prod_color_pk) as color_qty,");
    sb.append("GET_COLOR_SHIPPEDQTY(sss.sty_seq,pc.prod_color_pk) as shipped_qty,");
    sb.append("'' as SRN_LIST ");

    /*
    sb.append("select sss.sty_seq,");
    sb.append("prodXN.prod_sc_no,sss.STY_STYLE,sss.sty_po, ");
    sb.append("(select PRI_BYR_ACT_PRX from price where pri_sty_seq=sss.sty_seq and record_delete_flag='1' and rownum=1) as buyer_act_prx,");
    sb.append("(select PRI_BYR_DOC_PRX from price where pri_sty_seq=sss.sty_seq and record_delete_flag='1' and rownum=1) as buyer_doc_prx,");
    sb.append("(select PRI_MKR_ACT_PRX from price where pri_sty_seq=sss.sty_seq and record_delete_flag='1' and rownum=1) as maker_act_prx,");
    sb.append("(select PRI_MKR_DOC_PRX from price where pri_sty_seq=sss.sty_seq and record_delete_flag='1' and rownum=1) as maker_doc_prx,");
    sb.append("sss.STY_TOTAL_QTY,");
    sb.append("(select sum(SHIP_STY_TOTAL_QTY) from ship_style where ship_style.sty_seq=sss.sty_seq ");
    sb.append(" and record_delete_flag='1') as ship_qty ");
    sb.append(" ,'' as SRN_LIST ");*/

    //sb.append("from prod_head a,department dep,production prodXN,prod_ct_infor ctinfor,style sss ,prod_color pc,price prx ");
    sb.append("from prod_head a,department dep,production prodXN,style sss ,prod_color pc,price prx ");
    sb.append(" where  1=1 ");

    sb.append("and a.prod_head_pk=prodXN.prod_head_pk and sss.prod_head_pk=a.prod_head_pk ");
    sb.append("and pc.prod_color_pk=prx.prod_color_pk ");
    sb.append("and sss.sty_seq=prx.pri_sty_seq ");
    sb.append("and prx.record_delete_flag='1' and pc.record_delete_flag='1' ");
    sb.append("and sss.record_delete_flag='1' ");


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
  public HashMap getSrnList(Vector vct)throws Exception{
    java.util.HashMap hm=new java.util.HashMap();
    StringBuffer sb=new StringBuffer();
    sb.append("select prod_color_pk,GET_SRN_LIST_STR_OF_PRODCOLOR(prod_color_pk) from prod_color where prod_color_pk in (");
    sb.append("0");
    for(int i=0;i<vct.size();i++){
      Record rec=(Record)vct.get(i);
      sb.append(",");
      sb.append(rec.get(8).toString());
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
          recOrg.set("SRN_LIST",hm.get(recOrg.get(8).toString()));
          vct2Return.add(recOrg);
        }
        return vct2Return;
  }

}
