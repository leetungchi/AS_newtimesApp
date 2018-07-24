package newtimes.nthk_enqry;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class EnqDataEngin4StatusNTFE extends EnqDataEngin4Status {
  public EnqDataEngin4StatusNTFE() {
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
    sb.append(",decode(prodXN.prod_audit_status,'1','3','2','3',prodXN.prod_audit_status) as prod_audit_status, ");//28
    sb.append("'....' as xbutton,'' as testCheck,");//29,//30
    //sb.append("a.record_modify_user ");
    sb.append(" nvl(GET_LAST_MODIFY_USER(a.prod_head_pk),a.record_modify_user) as record_modify_user ");
    //-------20070809------
    sb.append(",nvl((select  max(m_dtae) from order_m_h where prod_head_pk=a.prod_head_pk),a.record_modify_date) as final_modify_date ");
    //----end of 20070809----------
    sb.append("from prod_head a,department dep,production prodXN ");
    sb.append("where  1=1 ");
    sb.append("and a.PROD_DEPTMENT=dep.DEP_CODE ");
    sb.append("and prodXN.prod_head_pk=a.prod_head_pk ");
    initialHeadSQL=sb.toString();
  }

}
