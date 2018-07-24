package newtimes.accounting.debit_note;

import exgui.ultratable.PagedDataFactoryAdapter;
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

public class DbDebitNoteDDK extends PagedDataFactoryAdapter {
  newtimesejb.debitNote.DebitNoteFacde debitnoteHeadFacade;
  public DbDebitNoteDDK() {
    try{
      newtimesejb.debitNote.DebitNoteFacdeHome ejbHome=
          (newtimesejb.debitNote.DebitNoteFacdeHome)
          info_ejb.WeblogicServiceLocator.locateServiceHome(
             util.PublicVariable.SERVER_URL,"newtimesejb.debitNote.DebitNoteFacde");

      debitnoteHeadFacade=ejbHome.create();
      blankRecord=exgui2.CONST.BASIC_MAIN_EJB.getBlankRecord("DEBITNOTE_DEDUCT_tbl");
      blankRecord.set("record_create_user",util.PublicVariable.USER_RECORD.get(0));
      blankRecord.set("record_delete_flag","1");
      blankRecord.set(0,0);
      //blankRecord.set("DBNT_COLLECT_DESC","COLLECTION OF     CHARGE WITH DETAILS AS FOLLWS");
    }catch(Exception exp){
      exp.printStackTrace();
      exgui.verification.VerifyLib.showAlert("Error While creating DbDebitNote Deduct \nPlease Contact System Manager",
                                             "Error While creating DbDebitNote Deduct");

    }
  }
  public Record addRecord(Record rec2add)throws Exception{
    util.MiscFunc.showProcessingMessage();
    Record rec2return= debitnoteHeadFacade.editDebitNoteDeduct(rec2add);
    util.MiscFunc.hideProcessingMessage();
    return rec2return;
  }
  public Record getRecordByPk(int  ddpSeq)throws Exception{
    Vector vct=exgui2.CONST.BASIC_MAIN_EJB.getDatas(
      util.PublicVariable.USER_RECORD,
      "select * from DEBITNOTE_DEDUCT WHERE DBNT_DDK_SEQ="+ddpSeq,
        1,1);
     if(vct.size()==0)return null;
     return (Record)vct.get(0);

  }
  public Vector getRecords(int bgn,int rowcount)throws Exception{
    Vector vct=null;
    StringBuffer sb=new StringBuffer();
    sb.append("select a.*,round(a.dbnt_total_amt-get_ddk_amt(a.dbnt_no),2) as dbcr_balance,null as ddk_amt,'' as chk_no,'' as chk_amt,'' as ddk_date,'' as ddk_other_amt,'' as ddk_desc  from debitnote_head a where 1=1 ");
    sb.append(" and a.cen_code='");
    sb.append(util.MiscFunc.Replace(util.PublicVariable.OPERATTING_CENTER,"'","''"));
    sb.append("' ");

    if(newtimes.accounting.debit_note.Constans.DRCR_QRY_HEAD_CONDITION.get(PnlQryDebitNote.CONDITION_DATE_FROM)!=null){
      String dataFrom=(String)newtimes.accounting.debit_note.Constans.DRCR_QRY_HEAD_CONDITION.get(PnlQryDebitNote.CONDITION_DATE_FROM);
      sb.append(" and length(a.dbnt_no)<>14 ");
      sb.append(" and '20'||substr(a.dbnt_no,3,4)||'01' >='");
      sb.append(dataFrom);sb.append("01");
      sb.append("' ");
    }

    if(newtimes.accounting.debit_note.Constans.DRCR_QRY_HEAD_CONDITION.get(PnlQryDebitNote.CONDITION_DATE_TO)!=null){
      String dataTO=(String)newtimes.accounting.debit_note.Constans.DRCR_QRY_HEAD_CONDITION.get(PnlQryDebitNote.CONDITION_DATE_TO);
      sb.append(" and length(a.dbnt_no)<>14 ");
      sb.append(" and '20'||substr(a.dbnt_no,3,4)||'01' <='");
      sb.append(dataTO);sb.append("01");
      sb.append("' ");
    }
    if(newtimes.accounting.debit_note.Constans.DRCR_QRY_HEAD_CONDITION.get(PnlQryDebitNote.CONDITION_DEPT)!=null){
      sb.append(" and substr(a.dbnt_no,1,2)='");
      String depBrief=
          (String)newtimes.accounting.debit_note.Constans.DRCR_QRY_HEAD_CONDITION.get(PnlQryDebitNote.CONDITION_DEPT);
      sb.append(depBrief);
      sb.append("' ");
    }
    if(newtimes.accounting.debit_note.Constans.DRCR_QRY_HEAD_CONDITION.get(PnlQryDebitNote.CONDITION_BUYER_MAKER)!=null){
      String buymaker_seq=
          (String)newtimes.accounting.debit_note.Constans.DRCR_QRY_HEAD_CONDITION.get(PnlQryDebitNote.CONDITION_BUYER_MAKER);
      sb.append(" and a.DBNT_BYMKR_SEQ=");
      sb.append(buymaker_seq);
    }
    if(newtimes.accounting.debit_note.Constans.DRCR_QRY_HEAD_CONDITION.get(PnlQryDebitNote.CONDITION_TYPE)!=null){
      String typeChar=
          (String)newtimes.accounting.debit_note.Constans.DRCR_QRY_HEAD_CONDITION.get(PnlQryDebitNote.CONDITION_TYPE);
      sb.append(" and substr(a.dbnt_no,7,1) in ('");
      sb.append(typeChar);sb.append("','C','D')");

    }
    if(newtimes.accounting.debit_note.Constans.DRCR_QRY_HEAD_CONDITION.get(PnlQryDebitNote.CONDITION_BUYER_MAKER_NAME)!=null){
      String buyermaker_name=
          (String)newtimes.accounting.debit_note.Constans.DRCR_QRY_HEAD_CONDITION.get(PnlQryDebitNote.CONDITION_BUYER_MAKER_NAME);
      sb.append(" and a.DBNT_BYMKR_NAME='");
      sb.append(util.MiscFunc.Replace(buyermaker_name,"'","''"));
      sb.append("' ");
    }


   sb.append(" and round((a.dbnt_total_amt-get_ddk_amt(a.dbnt_no)),2)>0");
   sb.append(" order by a.dbnt_no ");
    util.MiscFunc.showProcessingMessage();
      vct= exgui2.CONST.BASIC_MAIN_EJB.getDatas(
         util.PublicVariable.USER_RECORD,
         sb.toString(),
         bgn, rowcount);
    //for displaying requirement,we have to test the type of debitnote
    //if is credit/debit type,allow to use "pay-detail"
    util.MiscFunc.hideProcessingMessage();
    return vct;
  }

  public void updateRecords(Vector vct)throws Exception{
    if(vct==null || vct.size()==0)return;
    util.MiscFunc.showProcessingMessage();
    for(int i=0;i<vct.size();i++){
      Record rec=(Record)vct.get(i);
      debitnoteHeadFacade.editDebitNoteDeduct(rec);
    }
    util.MiscFunc.hideProcessingMessage();
  }

}
