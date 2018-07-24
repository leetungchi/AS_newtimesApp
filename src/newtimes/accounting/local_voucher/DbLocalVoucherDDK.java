package newtimes.accounting.local_voucher;
import exgui.ultratable.*;
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

public class DbLocalVoucherDDK extends PagedDataFactoryAdapter {
  newtimesejb.debitNote.LocalVoucherFacade localVoucherFacade;
  static java.util.HashMap HM_QRY_CONDITION=new java.util.HashMap();
  static String QUERY_KEY_ETD_FROM="QUERY_KEY_ETD_FROM";
  static String QUERY_KEY_ETD_END= "QUERY_KEY_ETD_END";
  static String QUERY_KEY_FACTORY_ZH_NAME="QUERY_MAKER_ZH_NAME";


  public DbLocalVoucherDDK() {
    try {
      newtimesejb.debitNote.LocalVoucherFacadeHome ejbHome =
          (newtimesejb.debitNote.LocalVoucherFacadeHome)
          info_ejb.WeblogicServiceLocator.locateServiceHome(
          util.PublicVariable.SERVER_URL,
          "newtimesejb.debitNote.LocalVoucherFacade");

      localVoucherFacade = ejbHome.create();
      blankRecord = exgui2.CONST.BASIC_MAIN_EJB.getBlankRecord(
          "LOCAL_VOUCHER_DEDUCT_tbl");
      blankRecord.set("record_create_user",
                      util.PublicVariable.USER_RECORD.get(0));
      blankRecord.set("record_delete_flag", "1");
      blankRecord.set(0, 0);
      //blankRecord.set("DBNT_COLLECT_DESC","COLLECTION OF     CHARGE WITH DETAILS AS FOLLWS");
    } catch (Exception exp) {
      exp.printStackTrace();
      exgui.verification.VerifyLib.showAlert(
          "Error While creating DbDebitNote Deduct \nPlease Contact System Manager",
          "Error While creating DbDebitNote Deduct");

    }
  }
  public Record addRecord(Record rec2add)throws Exception{
    util.MiscFunc.showProcessingMessage();
    Record rec2return= localVoucherFacade.editLocalVoucherDeduct(rec2add);
    util.MiscFunc.hideProcessingMessage();
    return rec2return;
  }
  public Vector getRecords(int bgn,int rowcount)throws Exception{
    StringBuffer sb=new StringBuffer();
    sb.append("select   a.*, ");
    sb.append("round( ");
    sb.append("disc_amt + ");
    sb.append(" ( decode(nvl(exchange_rate,0),0,1,exchange_rate) *  nvl(diff_ttl,0))");
    sb.append("- nvl ((select sum(c.DDK_AMT)  ");
    sb.append("        from LOCAL_VOUCHER_DEDUCT c ");
    sb.append("        where c.SHIP_NO=a.ship_no and c.record_delete_flag='1'),0) ");

    sb.append(" -nvl ((select sum(c.OTHER_AMT)  ");
    sb.append("        from LOCAL_VOUCHER_DEDUCT c ");
    sb.append("        where c.SHIP_NO=a.ship_no and c.record_delete_flag='1'),0) ");

    sb.append(",decode(EXCHANGE_RATE,null,2,0)) ");

    sb.append(" as local_voucher_balance ");


    sb.append(",'' as ddk_amt ");
    sb.append(",'' as other_amt ");
    sb.append(",'' as other_amt_desc ");
    sb.append(",nvl((select sum(lvdk.DDK_AMT)  ");
    sb.append("        from LOCAL_VOUCHER_DEDUCT lvdk ");
    sb.append("        where lvdk.SHIP_NO=a.ship_no and lvdk.record_delete_flag='1'),0) ");

    sb.append(" - nvl((select sum(lvdk.OTHER_AMT)  ");
    sb.append("        from LOCAL_VOUCHER_DEDUCT lvdk ");
    sb.append("        where lvdk.SHIP_NO=a.ship_no and lvdk.record_delete_flag='1'),0) ");

    sb.append(" as local_voucher_ddk_sum ");
    sb.append("from local_voucher a,shipping b  ");
    sb.append("where a.ship_no=b.ship_no ");

    sb.append("and (round( ");
    sb.append("disc_amt +");
    sb.append(" ( decode(nvl(exchange_rate,0),0,1,exchange_rate) *  nvl(diff_ttl,0)) ");
    sb.append("- nvl ((select sum(c.DDK_AMT)  ");
    sb.append("        from LOCAL_VOUCHER_DEDUCT c ");
    sb.append("        where c.SHIP_NO=a.ship_no and c.record_delete_flag='1' ),0) ");

    sb.append("- nvl ((select sum(c.OTHER_AMT)  ");
    sb.append("        from LOCAL_VOUCHER_DEDUCT c ");
    sb.append("        where c.SHIP_NO=a.ship_no and c.record_delete_flag='1' ),0) ");

    sb.append("  ,decode(EXCHANGE_RATE,null,2,0))) ");

    sb.append(" > 0 ");

    if(HM_QRY_CONDITION.containsKey(QUERY_KEY_FACTORY_ZH_NAME)){
      String buyerTwnName=(String)HM_QRY_CONDITION.get(QUERY_KEY_FACTORY_ZH_NAME);
      sb.append(" and ");
      sb.append("(select BYMKR_CHINESE_BRIEF from buyer_maker where bymkr_seq= ");
      sb.append("(select prod_maker from prod_head where prod_head_pk= ");
      sb.append("(select cc.prod_head_pk from ship_sc cc where cc.ship_no=b.ship_no ");
      sb.append(" and cc.record_delete_flag='1' and rownum=1))) like '");
      sb.append(util.MiscFunc.Replace(buyerTwnName,"'","''"));
      sb.append("%' ");
    }

    if(HM_QRY_CONDITION.containsKey(QUERY_KEY_ETD_FROM)){
      String etdFrom=(String)HM_QRY_CONDITION.get(QUERY_KEY_ETD_FROM);
      sb.append(" and  a.ship_etd_date >= to_date('");
      sb.append(etdFrom);
      sb.append("','yyyy/mm/dd') ");
    }

    if(HM_QRY_CONDITION.containsKey(QUERY_KEY_ETD_END)){
      String etdEnd=(String)HM_QRY_CONDITION.get(QUERY_KEY_ETD_END);
      sb.append(" and  a.ship_etd_date <= to_date('");
      sb.append(etdEnd);
      sb.append("','yyyy/mm/dd') ");
    }
    int ship_no_length=12;
    if("001".equals(util.PublicVariable.OPERATTING_CENTER)){
      sb.append(" and a.ship_no like 'ZATW%' ");
    }else if("001".equals(util.PublicVariable.OPERATTING_CENTER)){
      sb.append(" and a.ship_no like 'ZNNT%' ");
    }else{
      ship_no_length=13;
      String prefix=newtimes.accounting.debit_note.Constans.getCenterPrefix(util.PublicVariable.OPERATTING_CENTER);
      sb.append(" and a.ship_no like 'Z__");
      sb.append(prefix);
      sb.append("%' ");
    }
    sb.append(" and length(a.ship_no)=");
    sb.append(String.valueOf(ship_no_length));
    sb.append(" ");


    //System.out.println(sb.toString());
    util.MiscFunc.showProcessingMessage();
     java.util.Vector vct= exgui2.CONST.BASIC_MAIN_EJB.getDatas(
         util.PublicVariable.USER_RECORD,
         sb.toString(),
         bgn, rowcount);
      util.MiscFunc.hideProcessingMessage();
      return vct;
  }
  public void updateRecords(java.util.Vector vct)throws Exception{
    if(vct==null || vct.size()==0)return;
    util.MiscFunc.showProcessingMessage();
    for(int i=0;i<vct.size();i++){
      Record rec=(Record)vct.get(i);
      if(rec.getInt("record_delete_flag")!=-1)rec.set("record_modify_user",util.PublicVariable.USER_RECORD.get(0));
      localVoucherFacade.editLocalVoucherDeduct(rec);
    }
    util.MiscFunc.hideProcessingMessage();
  }

}
