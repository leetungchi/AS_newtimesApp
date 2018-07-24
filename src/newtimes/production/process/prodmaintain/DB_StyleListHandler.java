package newtimes.production.process.prodmaintain;
import exgui.ultratable.PagedDataFactoryAdapter;
import database.datatype.Record;
import java.util.Vector;
/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class DB_StyleListHandler extends PagedDataFactoryAdapter {
  protected java.util.Vector planqtadatas=null;
  public java.util.Vector UnitsData=null;
  public java.util.Vector StoreData=null;
  protected boolean exceptionMsgShowed=false;
  public DB_StyleListHandler(boolean toList4Restore){
    this();
    conditions.put(((newtimesejb.production.StyleListFacade)ejb).CONDITION_STYLE_RECORD_DELETE_FLAG,
                   toList4Restore?"0":"1");
  }
  /*
  public Vector getRecords(int bgn,int rows)throws Exception {
    Vector vct2return=super.getRecords(bgn,rows);
    for(int i=0;i<vct2return.size();i++){
      System.out.println("Style REcord:"+vct2return.get(i).toString());
    }
     return vct2return;
  }*/
  public DB_StyleListHandler() {
    try{
      newtimesejb.production.StyleListFacadeHome ejbhome=
          (newtimesejb.production.StyleListFacadeHome)
           info_ejb.WeblogicServiceLocator.locateServiceHome(
            util.PublicVariable.SERVER_URL,
            "newtimesejb.production.StyleListFacade"
           );
      super.ejb=ejbhome.create();
      super.conditions=new java.util.HashMap();
      conditions.put(((newtimesejb.production.StyleListFacade)ejb).CONDITION_PROD_SEQ,
                     new Integer(newtimes.preproduction.Constants.CURRENT_PREPROD_HEAD_PK));

      UnitsData= newtimes.preproduction.guis.tempProperties.tmpUnits;  //((newtimesejb.production.StyleListFacade)ejb).getUnits();
      super.blankRecord=ejb.getBlankRecord();
      //System.out.println("blank record of style is:"+blankRecord);
      blankRecord.set("record_create_user",
                      util.PublicVariable.USER_RECORD.get("usr_code"));
      blankRecord.set("PROD_HEAD_PK",
                      newtimes.preproduction.Constants.CURRENT_PREPROD_HEAD_PK);
      blankRecord.set("sty_orig_del",
                      newtimes.preproduction.Constants.CURRENT_PREPROD_HEAD_RECORD.get(
                       "PRODUCTION_BYR_PLAN_DEL"));

      blankRecord.set("STY_MKR_DEL",
                newtimes.preproduction.Constants.CURRENT_PREPROD_HEAD_RECORD.get(
                "PRODUCTION_BYR_PLAN_DEL"));


      //blankRecord.set("STY_UNIT",((Record)(UnitsData.get(0))).get(0));
      blankRecord.set("STY_UNIT","PC");
      blankRecord.set("sty_ct_currency","USD");
      if(newtimes.preproduction.guis.tempProperties.tmpCATData.size()==0){
        planqtadatas = ((newtimesejb.production.StyleListFacade)ejb).getPlanQuota2Select();
        if (planqtadatas != null && planqtadatas.size() > 0) {
          Record recNull = (Record)util.MiscFunc.deepCopy(planqtadatas.get(0));
          recNull.set("cat_data", "N/A");
          planqtadatas.add(recNull);
        }
        newtimes.preproduction.guis.tempProperties.tmpCATData.addAll(planqtadatas);
      }
      //STY_CT_CURRENCY, STY_CT_PRC_TRM
      blankRecord.set("STY_CT_CURRENCY",
       newtimes.preproduction.Constants.CURRENT_PREPROD_HEAD_RECORD.get(
          "PRODUCTION_SC_CURRENCY"));

      blankRecord.set("STY_CT_PRC_TRM",
       newtimes.preproduction.Constants.CURRENT_PREPROD_HEAD_RECORD.get(
          "PRODUCTION_SC_PRC_TRM"));

    }catch(Exception e){
      e.printStackTrace();
    }
  }
  public void copyStylesTo(String styleList,int src_Headpk,int dest_prod_head_pk)throws Exception{
    ((newtimesejb.production.StyleListFacade)ejb).copyStylesTo(
        styleList,src_Headpk,dest_prod_head_pk,
        (String)util.PublicVariable.USER_RECORD.get("USR_CODE"));
  }

  public void moveStyles(String styleList,int prod_head_pk)throws Exception{
    ((newtimesejb.production.StyleListFacade)ejb).moveStylesTo(styleList,prod_head_pk,
        (String)util.PublicVariable.USER_RECORD.get("USR_CODE"));
  }
  public void restoreStyles(Vector vct2Restore)throws Exception{
    ((newtimesejb.production.StyleListFacade)ejb).restoreStylesAndProdHead(
         vct2Restore,newtimes.preproduction.Constants.CURRENT_PREPROD_HEAD_PK,
         (String)util.PublicVariable.USER_RECORD.get("USR_CODE"));
  }
  public void updateStylesAndQty(java.util.Vector vctStyles,java.util.HashMap styleSeqQty)throws Exception{
    ((newtimesejb.production.StyleListFacade)ejb).updateWithTotalQty(
      vctStyles,styleSeqQty,(String)util.PublicVariable.USER_RECORD.get("usr_code"));
  }
  public void updateStylesAndQtyPrice(java.util.Vector vctStyles,java.util.HashMap styleSeqQty,java.util.HashMap stySeqPrice)throws Exception{
    ((newtimesejb.production.StyleListFacade)ejb).updateWithTotalQty(
      vctStyles,styleSeqQty,stySeqPrice,(String)util.PublicVariable.USER_RECORD.get("usr_code"));
  }
  public void updateStylesAndQtyPriceWithFabPo(
    java.util.Vector vctStyles,java.util.HashMap styleSeqQty,java.util.HashMap stySeqPrice,
    java.util.HashMap hmStySeqFabPo)throws Exception{
    ((newtimesejb.production.StyleListFacade)ejb).updateWithTotalQtyWithStyFabPo(
      vctStyles,styleSeqQty,stySeqPrice,
      hmStySeqFabPo,
      (String)util.PublicVariable.USER_RECORD.get("usr_code"));
  }

  public void addSequencialAddStyles(java.util.Vector vctStyles,java.util.HashMap priceAndQty,String styNo4Follow)throws Exception{
    ((newtimesejb.production.StyleListFacade)ejb).sequencialAddStyles(vctStyles,priceAndQty,styNo4Follow);
  }
  public void addSequencialAddStyles(java.util.Vector vctStyles,java.util.HashMap priceAndQty)throws Exception{
    ((newtimesejb.production.StyleListFacade)ejb).sequencialAddStyles(vctStyles,priceAndQty);
  }

  public void reSetBuyerCommision(int prodHeadPk)throws Exception{
    ((newtimesejb.production.StyleListFacade)ejb).updateCommision4BuyerChanged(prodHeadPk,
        (String)util.PublicVariable.USER_RECORD.get("usr_code"));
  }
  public java.util.Vector getMgr4Cnfm(){
    //director & manager can take participate in confirm process.

    try{
      Record directorRec=
          ((newtimesejb.production.StyleListFacade)ejb).getProdDepDirector(
           (String)
            newtimes.preproduction.Constants.CURRENT_PREPROD_HEAD_RECORD.get("PROD_DEPTMENT")
          );
      if(newtimes.preproduction.guis.tempProperties.tmpManagerRecs==null||
         newtimes.preproduction.guis.tempProperties.tmpManagerRecs.size()==0){
        Vector tmpVct=new Vector();
        tmpVct.add(directorRec);
        return tmpVct;
      }
      if(newtimes.preproduction.guis.tempProperties.tmpManagerRecs.size()==0){
        exgui.verification.VerifyLib.showAlert("NO Managers Defined","No Managers Defined");
        return null;
      }
      java.util.Vector tmpVct =
          (java.util.Vector) util.MiscFunc.deepCopy(
          newtimes.preproduction.guis.tempProperties.tmpManagerRecs);
      Record rec2App=(Record)util.MiscFunc.deepCopy(tmpVct.get(0));
      //MNG_CODE, MNG_ABBR
      rec2App.set("MNG_CODE",
         directorRec.get(
          "USR_CODE"));
      rec2App.set("MNG_ABBR",
         directorRec.get(
          "USR_CODE"));
      tmpVct.add(rec2App);
      return tmpVct;
    }catch(Exception e){
      e.printStackTrace();
      return null;
    }
  }
  public void bachUpdateColumns(Record styleRec,Record priceRec,String Qty)throws Exception{
    ((newtimesejb.production.StyleListFacade)ejb).updateAttris(styleRec,priceRec,Qty,
        newtimes.preproduction.Constants.CURRENT_PREPROD_HEAD_PK,
        (String)util.PublicVariable.USER_RECORD.get("usr_code"));
  }
  public void addRecords(Vector recs,String styNo2Follow)throws Exception{
    ((newtimesejb.production.StyleListFacade)ejb).addRecords(recs,styNo2Follow);
  }
  public void addRecords(Vector recs)throws Exception{
    ((newtimesejb.production.StyleListFacade)ejb).addRecords(recs);
  }

  public java.util.Vector getPlanQuota2Selsct(){
      //return planqtadatas;
      return newtimes.preproduction.guis.tempProperties.tmpCATData;
  }
  public void sendSCconfirm(int prodSeq,String cnfmMgrCode)throws Exception{
     ((newtimesejb.production.StyleListFacade)ejb).set2WaitConfirm(prodSeq,
            (String)util.PublicVariable.USER_RECORD.get("usr_code"),cnfmMgrCode);
  }
}
