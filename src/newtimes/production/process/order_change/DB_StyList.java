package newtimes.production.process.order_change;
import exgui.ultratable.PagedDataFactoryAdapter;
import java.util.*;
import database.datatype.Record;
public class DB_StyList extends PagedDataFactoryAdapter {
  boolean initOk;
  newtimesejb.production.StyleListFacade myEJB;
  public static Vector qtaVct=null;
  public DB_StyList() {
    try{
      newtimesejb.production.StyleListFacadeHome ejbHome=
          (newtimesejb.production.StyleListFacadeHome)
          info_ejb.WeblogicServiceLocator.locateServiceHome(
          util.PublicVariable.SERVER_URL ,
          "newtimesejb.production.StyleListFacade");
      myEJB=ejbHome.create();
      qtaVct=myEJB.getPlanQuota2Select();
      initOk=true;
    }catch(Exception e){
      exgui.verification.VerifyLib.showAlert(
          "Server Connection Error\nPlease Notify System Manager",
          "EJB Creation Exception");
      util.ExceptionLog.exp2File(e,"ejb Create Exception");
      e.printStackTrace();
      initOk=false;
    }
  }

  public boolean isInitOk(){return initOk;}
  public Vector getRecords(int bgn,int rowcount)throws Exception{
    HashMap hm=new HashMap();
    //hm.put("record_delete_flag","1");
    hm.put(
      ((newtimesejb.production.StyleListFacade)ejb).CONDITION_STYLE_RECORD_DELETE_FLAG,
                   "1");


    hm.put(myEJB.CONDITION_PROD_SEQ,
           new Integer(
           newtimes.preproduction.Constants.CURRENT_PREPROD_HEAD_PK
           ));
    //Vector vct= myEJB.getRecords(bgn,rowcount,hm);
    Vector vct=exgui2.CONST.BASIC_MAIN_EJB.getDatas(
      util.PublicVariable.USER_RECORD,
      "select a.*,concat(a.STY_qta_cat,a.STY_qta_area) as STY_QTA from style a where a.record_delete_flag='1' and a.prod_head_pk="+newtimes.preproduction.Constants.CURRENT_PREPROD_HEAD_PK+" order by sty_no,sty_seq "
      ,bgn,rowcount);
    Record prodRec=
       newtimes.preproduction.Constants.CURRENT_PREPROD_HEAD_RECORD;
   //copy FTY DIV SEA YEAR RNG S/C NO-->SC_NO
     String FTY=(String)prodRec.get("j_maker");
     String DIV=(String)prodRec.get("j_div");
     String SEA=(String)prodRec.get("j_sea");
     String YEAR=(String)prodRec.get("PROD_YEAR");
     String RNG=(String)prodRec.get("prod_range");
     String SC_NO=(String)prodRec.get("PROD_SC_NO");
    for(int i=0;i<vct.size();i++){
       Record styRec=(Record)vct.get(i);
       styRec.getFieldName().add("FTY");
       styRec.getValueFields().add(FTY);
       styRec.getFieldName().add("DIV");
       styRec.getValueFields().add(DIV);
       styRec.getFieldName().add("SEA");
       styRec.getValueFields().add(SEA);
       styRec.getFieldName().add("YEAR");
       styRec.getValueFields().add(YEAR);
       styRec.getFieldName().add("RNG");
       styRec.getValueFields().add(RNG);
       styRec.getFieldName().add("SC_NO");
       styRec.getValueFields().add(SC_NO);
    }
   return vct;
  }
}
