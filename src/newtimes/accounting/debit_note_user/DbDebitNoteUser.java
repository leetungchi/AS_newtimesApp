package newtimes.accounting.debit_note_user;

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

public class DbDebitNoteUser extends PagedDataFactoryAdapter {
  newtimesejb.debitNote.DebitNoteFacde debitnoteHeadFacade;
  public DbDebitNoteUser() {
    try{
      newtimesejb.debitNote.DebitNoteFacdeHome ejbHome=
          (newtimesejb.debitNote.DebitNoteFacdeHome)
          info_ejb.WeblogicServiceLocator.locateServiceHome(
             util.PublicVariable.SERVER_URL,"newtimesejb.debitNote.DebitNoteFacde");

      debitnoteHeadFacade=ejbHome.create();
      blankRecord=exgui2.CONST.BASIC_MAIN_EJB.getBlankRecord("DEBITNOTE_USER_tbl");
      blankRecord.set("record_create_user",util.PublicVariable.USER_RECORD.get(0));
      blankRecord.set("record_delete_flag",-1);
      blankRecord.set("cen_code",util.PublicVariable.OPERATTING_CENTER);
    }catch(Exception exp){
      exp.printStackTrace();
      exgui.verification.VerifyLib.showAlert("Error While creating DbDebitNoteUSer \nPlease Contact System Manager",
                                             "Error While creating DbDebitNoteUSer");

    }
  }
  public Record addRecord(Record rec2add)throws Exception{
    return debitnoteHeadFacade.editDebitNoteKind(rec2add);
  }
  public Record getRecordByPk(String usrCode)throws Exception{
    String cenCode=(String)util.PublicVariable.OPERATTING_CENTER;
    Vector vct=exgui2.CONST.BASIC_MAIN_EJB.getDatas(
      util.PublicVariable.USER_RECORD,
      "select * from DEBITNOTE_USER WHERE USR_CODE='"+usrCode+"' and Cen_code='"+cenCode+"'",
        1,1);
     if(vct.size()==0)return null;
     return (Record)vct.get(0);

  }
  String composeCondition(){
    java.util.Iterator itr=Constants.HM_QRY_CONDITION.keySet().iterator();
    StringBuffer sb=new StringBuffer();
    while(itr.hasNext()){
      sb.append(" and ");
      String key=(String)itr.next();
      String value=(String)Constants.HM_QRY_CONDITION.get(key);
      sb.append(key);
      sb.append(" like ");
      sb.append("'");
      sb.append(value);
      sb.append("%'");
    }
    return sb.toString();
  }
  public Vector getRecords(int bgn,int rowcount)throws Exception{
    StringBuffer sb=new StringBuffer();
    String cenCode=(String)util.PublicVariable.OPERATTING_CENTER;
    sb.append("Select * from DEBITNOTE_USER where record_delete_flag='1' and cen_code='"+cenCode+"'");
    sb.append(composeCondition());
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
      debitnoteHeadFacade.editDebitUser(rec);
    }
    util.MiscFunc.hideProcessingMessage();
  }
  public void deleteRecord(Record rec2delete)throws Exception{
    rec2delete.set("record_modify_user",util.PublicVariable.USER_RECORD.get("usr_code"));
    rec2delete.set("record_delete_flag","0");
    debitnoteHeadFacade.editDebitUser(rec2delete);
  }

}
