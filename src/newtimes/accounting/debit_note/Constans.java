package newtimes.accounting.debit_note;
import java.util.*;
import database.datatype.Record;
public class Constans {
  public Constans() {
  }
  public static String QRY_DEBITNOTE_NO;
  public static int BGN_POS_OF_QRY_DRCR_NO;
  public static int BGN_POS_OF_QRY_PAY_DTL_DRCR_NO;

  public static java.util.Vector VCT_DIVISION=new java.util.Vector();
  protected static database.datatype.Record EDITING_DEBITNOTE_HEAD_ECORD;
  protected static java.util.Vector VCT_BRANCH=null;
  protected static java.util.Vector VCT_DEBITNOTE_KIND=null;
  protected static DbDebitNoteHead DEBIT_NOTE_HEAD_DBHANDLER=new DbDebitNoteHead();
  protected static HashMap DRCR_QRY_HEAD_CONDITION=new HashMap();
  public static PnlQryDebitNote PNL2QUERY=null;
  public static PnlQryDebitNotePayDtl PNL2QUERY_PAY_DETAIL=null;
  public static PnlQryDDK PNL2QRYDDK=null;

  public static java.util.HashMap BankDataString=null;
  public static Vector VCT_BUYERNAMES=null;
  public static Vector VCT_FTY_NAMES=null;
  public static Vector VCT_MERCH=null;
  public static java.util.HashMap hmBuyerMakerType=null;
  public static Record recGetCenterRec(String cenCode){
    java.util.Vector vct=newtimes.preproduction.guis.tempProperties.tmpCenters;
    if(vct.size()==1){
      return (database.datatype.Record)vct.get(0);
    }else{
      for(int i=0;i<vct.size();i++){
        database.datatype.Record rec=(database.datatype.Record)vct.get(i);
        if(rec.get(0).equals(cenCode)) return rec;
      }
    }
    exgui.verification.VerifyLib.showAlert("Error In Retreiving Center Record for Center Code:"+cenCode,
                                           "Can Not Find Center Prefix Code");
    return null;

  }
  public static String getCenterPrefix(String cenCode){
    Record rec=recGetCenterRec(cenCode);
    if(null!=rec)return (String)rec.get(18);
    if(rec==null)
      exgui.verification.VerifyLib.showAlert("Error In Retreiving Center Prefix for Center Code:"+cenCode,
                                             "Can Not Find Center Prefix Code");
      return null;

  }
}
