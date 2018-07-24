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

public class DbDebitNotePayDtl extends PagedDataFactoryAdapter {
  newtimesejb.debitNote.DebitNoteFacde debitnoteHeadFacade;
  public DbDebitNotePayDtl() {
    try{
      newtimesejb.debitNote.DebitNoteFacdeHome ejbHome=
          (newtimesejb.debitNote.DebitNoteFacdeHome)
          info_ejb.WeblogicServiceLocator.locateServiceHome(
             util.PublicVariable.SERVER_URL,"newtimesejb.debitNote.DebitNoteFacde");

      debitnoteHeadFacade=ejbHome.create();
      blankRecord=exgui2.CONST.BASIC_MAIN_EJB.getBlankRecord("DEBITNOTE_PAY_DETAIL_tbl");
      blankRecord.set("record_create_user",util.PublicVariable.USER_RECORD.get(0));
      blankRecord.set("record_delete_flag","1");
      blankRecord.set(0,0);
      blankRecord.set("DBNT_PAYDTL_CURRENCY","USD");
    }catch(Exception exp){
      exp.printStackTrace();
      exgui.verification.VerifyLib.showAlert("Error While creating DbDebitNotePayDtl \nPlease Contact System Manager",
                                             "Error While creating DbDebitNotePayDtl");

    }
  }
  public Record addRecord(Record rec2add)throws Exception{
    return debitnoteHeadFacade.editDebitNoteDetail(rec2add);
  }
  public Record getRecordByPk(int pk)throws Exception{
    Vector vct=exgui2.CONST.BASIC_MAIN_EJB.getDatas(
      util.PublicVariable.USER_RECORD,
      "select * from DEBITNOTE_PAY_DETAIL WHERE DBNT_PAYDTL_SEQ="+pk,
        1,1);
     if(vct.size()==0)return null;
     return (Record)vct.get(0);

  }
  public Vector getRecords(int bgn,int rowcount)throws Exception{
    Vector vct=null;
    String DrCrNo=Constans.QRY_DEBITNOTE_NO;
    StringBuffer sb=new StringBuffer();
    sb.append("select a.* ");
    sb.append("from DEBITNOTE_PAY_DETAIL a WHERE a.RECORD_DELETE_FLAG='1' and a.DBNT_NO ='");
    sb.append(DrCrNo);sb.append("' order by a.dbnt_paydtl_seq");
      vct= exgui2.CONST.BASIC_MAIN_EJB.getDatas(
         util.PublicVariable.USER_RECORD,
         sb.toString(),
         bgn, rowcount);
     return vct;
  }

  public void updateRecords(Vector vct)throws Exception{
    if(vct==null || vct.size()==0)return;
    util.MiscFunc.showProcessingMessage();
    for(int i=0;i<vct.size();i++){
      Record rec=(Record)vct.get(i);
      debitnoteHeadFacade.editDebitNotePayDetail(rec);
    }
    util.MiscFunc.hideProcessingMessage();
  }

}
