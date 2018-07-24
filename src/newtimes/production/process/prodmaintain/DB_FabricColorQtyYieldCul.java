package newtimes.production.process.prodmaintain;
import exgui.ultratable.PagedDataFactoryAdapter;
import database.datatype.Record;
import java.util.*;

public class DB_FabricColorQtyYieldCul extends PagedDataFactoryAdapter {
  Vector colors=null;
  boolean iniOK=false;
  int fab_seq;
  int prodSeq;
  Record blankRec4Mdf=null;
  static java.text.NumberFormat nf=new java.text.DecimalFormat("##########.##");
  public DB_FabricColorQtyYieldCul() {
     try{
       newtimesejb.production.FabricColorQtyYieldFacadeHome ejbhome
           =(newtimesejb.production.FabricColorQtyYieldFacadeHome)
            info_ejb.WeblogicServiceLocator.locateServiceHome(
            util.PublicVariable.SERVER_URL,
            "newtimesejb.production.FabricColorQtyYieldFacade");
       ejb=ejbhome.create();
       blankRecord=ejb.getBlankRecord();//pre-initialize blank record.
       blankRec4Mdf=(Record)util.MiscFunc.deepCopy(blankRecord);
       fab_seq=newtimes.production.ProdMaintain_Properties.CURRENT_SELECTED_FABRIC_PO_SEQ_IN_FABRIC_PO_LIST;
       prodSeq=
           newtimes.preproduction.Constants.CURRENT_PREPROD_HEAD_PK;
       colors=((newtimesejb.production.FabricColorQtyYieldFacade)ejb).getColorNameCode(prodSeq);
       if(colors.size()==0){
          iniOK=false;
          exgui.verification.VerifyLib.showPlanMsg("Please Define Production Colors Before Using This Unit",
                                                   "Define Production Colors First,Please");
          return;
       }
       blankRecord.set("fcq_fab_seq",fab_seq);
       Record colorTmpRec=(Record)colors.get(0);
       blankRecord.set("prod_color_pk",colorTmpRec.get("PROD_COLOR_PK"));
       blankRecord.set("record_create_user",util.PublicVariable.USER_RECORD.get("usr_code"));
       iniOK=true;
     }catch(Exception e){
       e.printStackTrace();
       iniOK=false;
       exgui.verification.VerifyLib.showAlert("Server Side ERROR,please Notify System Manager"
                                              ,"EJB Creation Fail");
     }
  }
 public boolean isInitOK(){return iniOK;}
 public Vector getRecords(int bgn,int rowcount)throws Exception{
   Vector vcts=((newtimesejb.production.FabricColorQtyYieldFacade)ejb).getRecords(bgn,rowcount,fab_seq,prodSeq);
   //calculate the yield differents
   for(int i=0;i<vcts.size();i++){
      Record rec=(Record)vcts.get(i);
      rec.getFieldName().add("YIELD_diff");
      Object obj=rec.get("FCQ_SHIP_YIELD");
      int ship_yield=(obj==null)?0:Integer.parseInt(obj.toString());
      Object needYld= rec.get("NEED_YIELD");
      double need_yield=(needYld==null)?0:Double.parseDouble(needYld.toString());
      rec.getValueFields().add(nf.format((double)(ship_yield-need_yield)));
      //System.out.println("org fab-qty rec is :"+rec.toString());
   }
   return vcts;
 }
 public void deleteRecord(Record rec2delete)throws Exception{
   //System.out.println("data to delete is :"+rec2delete.toString());
   Record rec2del= this.getBlankRecord();
   rec2del.set(0,rec2delete.get(0));
   rec2del.set("record_modify_user",util.PublicVariable.USER_RECORD.get("usr_code"));
   ejb.deleteRecord(rec2del);
 }
 public void updateRecords(Vector recd2update)throws Exception{
   Vector vc=new Vector();
   for(int i=0;i<recd2update.size();i++){
     Record tmpRec=(Record)util.MiscFunc.deepCopy(blankRec4Mdf);
     Record srcRec=(Record)recd2update.get(i);
     tmpRec.set(0,srcRec.get(0));//fcq_seq
     tmpRec.set(1,fab_seq);//fab_seq;
     tmpRec.set(2,srcRec.get(1));//prod_color_pk;
     tmpRec.set(3,srcRec.get(4));//pi qty
     tmpRec.set(4,srcRec.get(5));//ship yield
     tmpRec.set("Record_modify_user",util.PublicVariable.USER_RECORD.get("usr_code"));
     vc.add(tmpRec);
   }
  super.updateRecords(vc);
 }
 public void addRecords(Vector rec2add)throws Exception{
   ((newtimesejb.production.FabricColorQtyYieldFacade)ejb).addRecords(rec2add);
 }
 public Vector getColors(){
   return colors;
 }
}
