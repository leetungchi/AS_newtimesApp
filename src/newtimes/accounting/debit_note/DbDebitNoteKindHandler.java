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

public class DbDebitNoteKindHandler extends PagedDataFactoryAdapter {
  newtimesejb.debitNote.DebitNoteFacde debitnoteHeadFacade;
  public DbDebitNoteKindHandler() {
    try{
      newtimesejb.debitNote.DebitNoteFacdeHome ejbHome=
          (newtimesejb.debitNote.DebitNoteFacdeHome)
          info_ejb.WeblogicServiceLocator.locateServiceHome(
             util.PublicVariable.SERVER_URL,"newtimesejb.debitNote.DebitNoteFacde");

      debitnoteHeadFacade=ejbHome.create();
      blankRecord=exgui2.CONST.BASIC_MAIN_EJB.getBlankRecord("DEBITNOTE_KIND_tbl");
      blankRecord.set("record_create_user",util.PublicVariable.USER_RECORD.get(0));
      blankRecord.set("record_delete_flag",1);
    }catch(Exception exp){
      exp.printStackTrace();
      exgui.verification.VerifyLib.showAlert("Error While creating DbDebitNoteKind \nPlease Contact System Manager",
                                             "Error While creating DbDebitNoteKind");

    }
  }
  public Record addRecord(Record rec2add)throws Exception{
    return debitnoteHeadFacade.editDebitNoteKind(rec2add);
  }
  public Record getRecordByPk(int kindSeq)throws Exception{
    Vector vct=exgui2.CONST.BASIC_MAIN_EJB.getDatas(
      util.PublicVariable.USER_RECORD,
      "select * from DEBITNOTE_KIND WHERE DBNT_KIND_SEQ="+kindSeq,
        1,1);
     if(vct.size()==0)return null;
     return (Record)vct.get(0);

  }
  public Vector getRecords(int bgn,int rowcount)throws Exception{
    StringBuffer sb=new StringBuffer();
    sb.append("select a.*,(select count(*) from DEBITNOTE_DETAIL b ");
    sb.append(" where b.DBNT_DTL_KIND=a.DBNT_KIND_SEQ and b.record_delete_flag='1' ) as used_count ");
    sb.append( "from DEBITNOTE_KIND a WHERE a.RECORD_DELETE_FLAG='1' ");
    Vector vct=null;
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
      debitnoteHeadFacade.editDebitNoteKind(rec);
    }
    util.MiscFunc.hideProcessingMessage();
  }

}
