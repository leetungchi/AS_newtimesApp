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

public class DbDebitNoteHead extends PagedDataFactoryAdapter {
  newtimesejb.debitNote.DebitNoteFacde debitnoteHeadFacade;
  java.text.NumberFormat nf=new java.text.DecimalFormat("###########0.00");
  public DbDebitNoteHead() {
    try{
      newtimesejb.debitNote.DebitNoteFacdeHome ejbHome=
          (newtimesejb.debitNote.DebitNoteFacdeHome)
          info_ejb.WeblogicServiceLocator.locateServiceHome(
             util.PublicVariable.SERVER_URL,"newtimesejb.debitNote.DebitNoteFacde");

      debitnoteHeadFacade=ejbHome.create();
      blankRecord=exgui2.CONST.BASIC_MAIN_EJB.getBlankRecord("DEBITNOTE_HEAD_tbl");
      blankRecord.set("record_create_user",util.PublicVariable.USER_RECORD.get(0));
      blankRecord.set("record_delete_flag",-1);
      blankRecord.set(8,"USD");
      blankRecord.set(1,"NEWTIMES INT''L");
      newtimes.accounting.debit_note.TgrShowQryGui.setBankDataString();
      blankRecord.set(20,Constans.BankDataString.get("NEWTIMES INT''L"));
      //blankRecord.set(24,"    REF NO.               DESCRIPTION");//DBNT_STY_RMK_COL1
      //blankRecord.set("DBNT_COLLECT_DESC","COLLECTION OF     CHARGE WITH DETAILS AS FOLLWS");
      blankRecord.set("cen_code",util.PublicVariable.OPERATTING_CENTER);
    }catch(Exception exp){
      exp.printStackTrace();
      exgui.verification.VerifyLib.showAlert("Error While creating DbDebitNoteHead \nPlease Contact System Manager",
                                             "Error While creating DbDebitNoteHead");

    }
  }
  public void updateDbCrNo(String orgDbCrNo,String newDbCrNo)throws Exception{
    debitnoteHeadFacade.updateTempDbCrNo(orgDbCrNo,newDbCrNo,
                                         (String)util.PublicVariable.USER_RECORD.get(0));
  }
  public Record addRecord(Record rec2add)throws Exception{
    util.MiscFunc.showProcessingMessage();
    Record rec2return= debitnoteHeadFacade.editDebitNoteHead(rec2add);
    util.MiscFunc.hideProcessingMessage();
    return rec2return;
  }
  public Record getRecordByPk(String DrCrNo)throws Exception{
    Vector vct=exgui2.CONST.BASIC_MAIN_EJB.getDatas(
      util.PublicVariable.USER_RECORD,
      "select a.* ,IS_OUTOF_DATE_RANGE(a.yyyymm,'DB',a.cen_code) as editable_flag from DEBITNOTE_HEAD a WHERE a.DBNT_NO='"+DrCrNo+"'",
        1,1);
     if(vct.size()==0)return null;
     return (Record)vct.get(0);

  }
  public Vector getRecords(int bgn,int rowcount)throws Exception{
    Vector vct=null;
    StringBuffer sb=new StringBuffer();
    sb.append("select a.*,'...' as dots,'...' as dots2payDtl,'...' as Deduct,IS_OUTOF_DATE_RANGE(a.yyyymm,'DB',a.cen_code) as editable_flag from debitnote_head a where 1=1 ");
    if(newtimes.accounting.debit_note.Constans.DRCR_QRY_HEAD_CONDITION.get(
         PnlQryDebitNote.CONDITION_CENTER_CODE)!=null){
       String centerCode=(String)
              newtimes.accounting.debit_note.Constans.DRCR_QRY_HEAD_CONDITION.get(
                 PnlQryDebitNote.CONDITION_CENTER_CODE);

        sb.append(" and  a.cen_code='");
        sb.append(util.MiscFunc.Replace(centerCode,"'","''"));
        sb.append("' ");
    }

    if(newtimes.accounting.debit_note.Constans.DRCR_QRY_HEAD_CONDITION.get(
         PnlQryDebitNote.CONDITION_SINGLE_DB_NO)!=null){
         String tmpDbCrNo= (String)
                 newtimes.accounting.debit_note.Constans.DRCR_QRY_HEAD_CONDITION.get(
                    PnlQryDebitNote.CONDITION_SINGLE_DB_NO);
          if("".equals(tmpDbCrNo)){
            sb.append(" and  length(a.dbnt_no)<>14 ");
          }else{
            sb.append(" and length(a.dbnt_no)<>14 ");
            sb.append(" and a.dbnt_no = '");
            sb.append(tmpDbCrNo);
            sb.append("'");
          }

    }


    if(newtimes.accounting.debit_note.Constans.DRCR_QRY_HEAD_CONDITION.get(
         PnlQryDebitNote.CONDITION_TEMP_DBCRNO)!=null){
         String tmpDbCrNo= (String)
                 newtimes.accounting.debit_note.Constans.DRCR_QRY_HEAD_CONDITION.get(PnlQryDebitNote.CONDITION_TEMP_DBCRNO);
          if("".equals(tmpDbCrNo)){
            sb.append(" and length(a.dbnt_no)=14");
          }else{
            sb.append(" and length(a.dbnt_no)=14");
            sb.append(" and a.dbnt_no like '%");
            sb.append(tmpDbCrNo);
            sb.append("'");
          }

    }
    if(newtimes.accounting.debit_note.Constans.DRCR_QRY_HEAD_CONDITION.get(
         PnlQryDebitNote.CONDITION_QRY_EXACT_BATCH)!=null){
         String batchNo= (String)
                 newtimes.accounting.debit_note.Constans.DRCR_QRY_HEAD_CONDITION.get(PnlQryDebitNote.CONDITION_QRY_EXACT_BATCH);
            sb.append(" and a.DBNT_MKRCNV_BATCHNO = '");
            sb.append(util.MiscFunc.Replace(batchNo,"'","''"));
            sb.append("'");

    }

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
    //and substr(a.dbnt_no,7,1)='D' type
    if(newtimes.accounting.debit_note.Constans.DRCR_QRY_HEAD_CONDITION.get(PnlQryDebitNote.CONDITION_TYPE)!=null){
      String typeChar=
          (String)newtimes.accounting.debit_note.Constans.DRCR_QRY_HEAD_CONDITION.get(PnlQryDebitNote.CONDITION_TYPE);
      sb.append(" and substr(a.dbnt_no,7,1)='");
      sb.append(typeChar);sb.append("' ");
    }
    // and a.DBNT_NO in (select dbnt_no from debitnote_detail where dbnt_dtl_kind='5') <--KIND
    if(newtimes.accounting.debit_note.Constans.DRCR_QRY_HEAD_CONDITION.get(PnlQryDebitNote.CONDITION_KIND)!=null){
      String kindChar=
          (String)newtimes.accounting.debit_note.Constans.DRCR_QRY_HEAD_CONDITION.get(PnlQryDebitNote.CONDITION_KIND);
      sb.append(" and a.DBNT_NO in (select dbnt_no from debitnote_detail where dbnt_dtl_kind='");
      sb.append(kindChar);sb.append("') ");
    }

    if(newtimes.accounting.debit_note.Constans.DRCR_QRY_HEAD_CONDITION.get(PnlQryDebitNote.CONDITION_DDK_CHECKNO)!=null){
      String ddkChkNo=
          (String)newtimes.accounting.debit_note.Constans.DRCR_QRY_HEAD_CONDITION.get(PnlQryDebitNote.CONDITION_DDK_CHECKNO);
      ddkChkNo=util.MiscFunc.Replace(ddkChkNo,"'","''");
      sb.append(" and a.DBNT_NO in (select dbnt_no from debitnote_deduct where chk_no like '%");
      sb.append(ddkChkNo);sb.append("%') ");
    }

    if(newtimes.accounting.debit_note.Constans.DRCR_QRY_HEAD_CONDITION.get(PnlQryDebitNote.CONDITION_QRY_SHIP_NO)!=null){
      String shipNo=
          (String)newtimes.accounting.debit_note.Constans.DRCR_QRY_HEAD_CONDITION.get(PnlQryDebitNote.CONDITION_QRY_SHIP_NO);
      shipNo=util.MiscFunc.Replace(shipNo,"'","''");
      sb.append(" and a.DBNT_NO in (select dbnt_no from debitnote_detail where DBNT_DTL_ITEM_SEQ ='");
      sb.append(shipNo);sb.append("') ");
    }
   sb.append(" order by  a.DBNT_NO ");
    util.MiscFunc.showProcessingMessage();
      vct= exgui2.CONST.BASIC_MAIN_EJB.getDatas(
         util.PublicVariable.USER_RECORD,
         sb.toString(),
         bgn, rowcount);
    //for displaying requirement,we have to test the type of debitnote
    //if is credit/debit type,allow to use "pay-detail"
    //if is "maker" type,allow to use "de-duct"
    Vector vct2Output=new Vector();
    for(int i=0;i<vct.size();i++){
       Record rec=(Record)vct.get(i);
       //convert debitnote _amt to ########.00 fromat
       Object dbtamt=rec.get(9);
       if(dbtamt==null)dbtamt="0";
       rec.set(9,nf.format(Double.parseDouble(dbtamt.toString())));
       String dbcrno=(String)rec.get(0);
       if(dbcrno.length()==14){
         //掛帳者,不允許用銷帳
         rec.set(29,"");
         vct2Output.add(rec);
         continue;
       }

       String type=dbcrno.substring(6,7);
       if(type.equals("B")){
         rec.set(28,"");
         //rec.set(29,"");
         //rec.getModifiedFields().clear();
         vct2Output.add(rec);
         continue;
       }

       if(type.equals("M")){
         rec.set(28,"");
         //rec.getModifiedFields().clear();
         vct2Output.add(rec);
         continue;
       }
       if(type.equals("C")||type.equals("D")){
         //rec.set(29,"");//C & D type have detail and deduct
         //rec.getModifiedFields().clear();

         vct2Output.add(rec);
         continue;
       }

    }
    util.MiscFunc.hideProcessingMessage();
    return vct2Output;
  }

  public void updateRecords(Vector vct)throws Exception{
    if(vct==null || vct.size()==0)return;
    util.MiscFunc.showProcessingMessage();
    for(int i=0;i<vct.size();i++){
      Record rec=(Record)vct.get(i);
      debitnoteHeadFacade.editDebitNoteHead(rec);
    }
    util.MiscFunc.hideProcessingMessage();
  }

}
