package newtimes.production.process.prodmaintain;
import exgui.ultratable.PagedDataFactoryAdapter;
import database.datatype.Record;
/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class DB_FbcClrQty extends PagedDataFactoryAdapter {
  java.util.Vector fabricpo=null;
  boolean alreadyAlert=false;
  static int FCQD_STY_QTY1_AT=0;
  static int FCQD_STY_QTY2_AT=0;
  static int FCQD_STY_QTY3_AT=0;
  static int FCQD_STY_QTY4_AT=0;
  static java.text.NumberFormat nf=new java.text.DecimalFormat("######.##");
  public DB_FbcClrQty() {
    try{
    newtimesejb.production.FabricColorQtyFacadeHome ejbhome=
        (newtimesejb.production.FabricColorQtyFacadeHome)
        info_ejb.WeblogicServiceLocator.locateServiceHome(
          util.PublicVariable.SERVER_URL,"newtimesejb.production.FabricColorQtyFacade");
    newtimesejb.production.FabricColorQtyFacade _ejb=
        ejbhome.create();
     super.ejb=_ejb;
     super.blankRecord=ejb.getBlankRecord();
     fabricpo=_ejb.getFabricPO(newtimes.preproduction.Constants.CURRENT_PREPROD_HEAD_PK,
                               newtimes.production.ProdMaintain_Properties.CURRENT_SELECTED_STYLE_SEQ_IN_STYLE_LIST);
     blankRecord.set("record_create_user",util.PublicVariable.USER_RECORD.get("usr_code"));
     if(fabricpo.size()==0){
       alreadyAlert=true;
       exgui.verification.VerifyLib.showAlert("Fabric PO record is empty \n"+
                                              "Please Define \"Fabric-Color-Qty\n"+
                                              "before processing this procedure",
                                              "Fabric PO Not Defined");
       throw new Exception("Fabric PO Not Defined");
     }
     Record tmpFbkPORec=(Record)fabricpo.get(0);
     blankRecord.set("FCQ_SEQ",tmpFbkPORec.get(0));
     blankRecord.set("FCQD_STY_SEQ",
                     newtimes.production.ProdMaintain_Properties.CURRENT_SELECTED_STYLE_SEQ_IN_STYLE_LIST
                     );
     super.conditions=new java.util.HashMap();
     conditions.put("FCQD_STY_SEQ",new Integer(newtimes.production.ProdMaintain_Properties.CURRENT_SELECTED_STYLE_SEQ_IN_STYLE_LIST));
    }catch(Exception e){
      e.printStackTrace();
      util.ExceptionLog.exp2File(e,"exp while generate the DB_FbcClrQty instance");
      if(!alreadyAlert) exgui.verification.VerifyLib.showAlert("Server Side Connection Error,Please Nofity System manager","EJB craete fail");
    }
  }
  public void addRecords(java.util.Vector vct2update)throws Exception{
    for(int i=0;i<vct2update.size();i++){
      Record rec=(Record)vct2update.get(i);
      Record recDup=getBlankRecord();
      recDup.set("record_create_date",rec.get("record_create_date"));
      recDup.set("record_create_user",rec.get("record_create_user"));
      recDup.set(0,rec.get(0));//fcqd_pk
      recDup.set(1,rec.get(1));//fcq_seq
      recDup.set(2,
      newtimes.production.ProdMaintain_Properties.CURRENT_SELECTED_STYLE_SEQ_IN_STYLE_LIST);//fcq_sty_seq
      java.util.List modiFld=rec.getModifiedFields();
      for(int j=0;j<modiFld.size();j++){
        String lkmName=(String)rec.getFieldName().get(((Integer)modiFld.get(j)).intValue());
        if(!lkmName.toUpperCase().startsWith("FCQX_")){
          recDup.set(lkmName,rec.get(lkmName));
        }
      }
      vct2update.set(i,recDup);
    }
    super.updateRecords(vct2update);
  }
  public void updateRecords(java.util.Vector vct2update)throws Exception{
      //trim some composed column...
      Object yy1Obj=null;
      Object yy2Obj=null;
      Object yy3Obj=null;
      Object yy4Obj=null;
      for(int i=0;i<vct2update.size();i++){
        Record rec=(Record)vct2update.get(i);
        if(FCQD_STY_QTY1_AT==0){
          FCQD_STY_QTY1_AT= util.MiscFunc.getFieldIndexAtRecord(rec,"FCQD_STY_QTY1");
          FCQD_STY_QTY2_AT= util.MiscFunc.getFieldIndexAtRecord(rec,"FCQD_STY_QTY2");
          FCQD_STY_QTY3_AT= util.MiscFunc.getFieldIndexAtRecord(rec,"FCQD_STY_QTY3");
          FCQD_STY_QTY4_AT= util.MiscFunc.getFieldIndexAtRecord(rec,"FCQD_STY_QTY4");
        }
        Record recDup=getBlankRecord();
        recDup.set("record_create_date",rec.get("record_create_date"));
        recDup.set("record_create_user",rec.get("record_create_user"));
        recDup.set(0,rec.get(0));//fcqd_pk
        recDup.set(1,rec.get(1));//fcq_seq
        recDup.set(2,
        newtimes.production.ProdMaintain_Properties.CURRENT_SELECTED_STYLE_SEQ_IN_STYLE_LIST);//fcq_sty_seq
        java.util.List modiFld=rec.getModifiedFields();
        for(int j=0;j<modiFld.size();j++){
          String lkmName=(String)rec.getFieldName().get(((Integer)modiFld.get(j)).intValue());
          if(!lkmName.toUpperCase().startsWith("FCQX_")){
            recDup.set(lkmName,rec.get(lkmName));
          }
        }
        //this if this record need to delete...
        //FCQD_STY_QTY1=160|FCQD_STY_QTY2=null|FCQD_STY_QTY3=null|FCQD_STY_QTY4=null
        yy1Obj=rec.get(FCQD_STY_QTY1_AT);
        yy2Obj=rec.get(FCQD_STY_QTY2_AT);
        yy3Obj=rec.get(FCQD_STY_QTY3_AT);
        yy4Obj=rec.get(FCQD_STY_QTY4_AT);
        int yy1Int=((yy1Obj==null)?0:Integer.parseInt(yy1Obj.toString()));
        int yy2Int=((yy2Obj==null)?0:Integer.parseInt(yy2Obj.toString()));
        int yy3Int=((yy3Obj==null)?0:Integer.parseInt(yy3Obj.toString()));
        int yy4Int=((yy4Obj==null)?0:Integer.parseInt(yy4Obj.toString()));
        if(yy1Int==0&&yy2Int==0&&yy3Int==0&&yy4Int==0) recDup.set("record_delete_flag","0");
        vct2update.set(i,recDup);
      }
      super.updateRecords(vct2update);
  }
  public java.util.Vector getRecords(int bgn,int rowcount)throws Exception{
    java.util.Vector orgVct=super.getRecords(bgn,rowcount);

    //if(orgVct==null||orgVct.size()==0) return orgVct;
    if(orgVct.size()==0){
      //make null data for default chose.
      for(int i=0;i<fabricpo.size();i++){
           Record poRec=(Record)fabricpo.get(i);
           Record psudoRec=(Record)util.MiscFunc.deepCopy(blankRecord);
           psudoRec.set(0,-1);//FCQ_PK
           psudoRec.set(1,poRec.get(0));//"FCQ_SEQ"
           psudoRec.set(3,poRec.get(7));//FCQD_STY_QTY1,default by--DEF_YY1
           orgVct.add(psudoRec);
      }
      super.updateRecords(orgVct);//add default data
      orgVct=super.getRecords(bgn,rowcount);
    }
    int styYY1At=
        util.MiscFunc.getFieldIndexAtRecord(newtimes.production.ProdMaintain_Properties.EDITING_STYLE_RECORD,"STY_YY1");
    int FcqYYAt=
        util.MiscFunc.getFieldIndexAtRecord((Record)orgVct.get(0),"FCQD_STY_QTY1");
    for(int i=0;i<orgVct.size();i++){
      Record rec=(Record)orgVct.get(i);
      rec.getFieldName().add("fcqx_total_yield");
      float totalSumedYield=0;
      for(int j=0;j<4;j++){
        Object styYY=
            newtimes.production.ProdMaintain_Properties.EDITING_STYLE_RECORD.get(styYY1At+j);
        Object orgYY=
            rec.get(FcqYYAt+j);
        if(styYY==null||orgYY==null){
          totalSumedYield+=0;
        }else{
          totalSumedYield+=
              (Double.parseDouble(styYY.toString())*Integer.parseInt(orgYY.toString()));
        }
      }
      rec.getValueFields().add(nf.format(totalSumedYield));
      orgVct.set(i,rec);
    }
    return orgVct;
  }
  public java.util.Vector getFabPo2Select(){return fabricpo;}
}
