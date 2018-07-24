package newtimes.preproduction.process;
import java.util.*;
import database.datatype.Record;
public class ProdDuplicationHandler {
  protected int new_prod_head_pk;
  protected java.util.HashMap hmStyleKeyHistoryMap=new java.util.HashMap();
  protected java.util.HashMap hmColorKeyHistoryMap=new java.util.HashMap();
  protected java.util.HashMap hmPriceKeyHistoryMap=new java.util.HashMap();
  protected String processing_user;
  protected int org_prod_head_pk;
  public ProdDuplicationHandler(int srcProdHeadPk,String usrCode) {
    org_prod_head_pk=srcProdHeadPk;
    processing_user=usrCode;
  }
  public int doCopyAllNow()throws Exception{
    exgui.DlgPhasesProcesses dlg=null;
    try{
      String headString = "<html><body>";
      String endString = "</body></html>";
      StringBuffer sb = new StringBuffer();
      dlg = new exgui.DlgPhasesProcesses(
          util.PublicVariable.APP_FRAME,
          "Processing Duplication Of All Attribues Of This Production", false);
      dlg.setSize(500, 300);
      dlg.setMessage("Duplicating Production Head....");
      exgui.UIHelper.setToScreenCenter(dlg);
      dlg.show();
      dupProdHead();
      dlg.setMessage(headString +
                     "Duplicating Production Head..........OK<br>" +
                     "Duplicating Colors Of Production....." +
                     endString);

      duplicateProdColor();
      dlg.setMessage(headString +
                     "Duplicating Production Head..........OK<br>" +
                     "Duplicating Colors Of Production.....OK<br>" +
                     "Duplicating Styles Of Production....." +
                     endString);

      duplicateStyle();
      dlg.setMessage(headString +
                     "Duplicating Production Head..........OK<br>" +
                     "Duplicating Colors Of Production.....OK<br>" +
                     "Duplicating Styles Of Production.....OK<br>" +
                     "Duplicating Prices Of Production....." +
                     endString);
      duplicatePrice();
      dlg.setMessage(headString +
                     "Duplicating Production Head..........OK<br>" +
                     "Duplicating Colors Of Production.....OK<br>" +
                     "Duplicating Styles Of Production.....OK<br>" +
                     "Duplicating Prices Of Production.....OK<br>" +
                     "Duplicating Qty    Of Production....." +
                     endString);
      duplicateQtys();
      dlg.stopProcessing(headString +
                         "Duplicating Production Head..........OK<br>" +
                         "Duplicating Colors Of Production.....OK<br>" +
                         "Duplicating Styles Of Production.....OK<br>" +
                         "Duplicating Prices Of Production.....OK<br>" +
                         "Duplicating Qty    Of Production.....OK<br>" +
                         "<br>" +
                         "Duplicate Whole Production OK!!<br>Ref No. Of New Production is:" +
                         new_prod_head_pk +
                         endString);
      dlg=null;
      return new_prod_head_pk;
    }catch(Exception exp){
      if(dlg!=null){
        dlg.stopProcessing("<html><body>Processing Error!!<br>Please Contact System Manager</body></html>");
      }
      dlg=null;
      throw exp;
    }
  }
  public int dupProdHead()throws Exception{

    //create dest data to copy

    Record srcRecPreProd=(Record)exgui2.CONST.BASIC_MAIN_EJB.getDatas(
                         util.PublicVariable.USER_RECORD,
                         "select * from preprod where PREPROD_PROD_PK="+org_prod_head_pk,1,1).get(0);
    Record srcRecProdHead=(Record)exgui2.CONST.BASIC_MAIN_EJB.getDatas(
                                          util.PublicVariable.USER_RECORD,
                                          "select * from prod_head where PROD_HEAD_PK="+org_prod_head_pk,1,1).get(0);
    Record srcRecProduction=(Record)exgui2.CONST.BASIC_MAIN_EJB.getDatas(
                               util.PublicVariable.USER_RECORD,
                               "select * from production where PROD_HEAD_PK="+org_prod_head_pk,1,1).get(0);

    Record blankRecPreProd=(Record)util.MiscFunc.deepCopy(srcRecPreProd);//exgui2.CONST.BASIC_MAIN_EJB.getBlankRecord("preprod_tbl");//<--this table is in charge of sequence no generating
    Record blankRecProdHead=(Record)util.MiscFunc.deepCopy(srcRecProdHead);//exgui2.CONST.BASIC_MAIN_EJB.getBlankRecord("prod_head_tbl");
    Record blankRecProduction=(Record)util.MiscFunc.deepCopy(srcRecProduction);//exgui2.CONST.BASIC_MAIN_EJB.getBlankRecord("production_tbl");
    //-----------------copy preprod--------------------------------
    int columncount=srcRecPreProd.getFieldName().size();
    for(int i=0;i<columncount;i++){
      blankRecPreProd.set(i,srcRecPreProd.get(i));
    }
    blankRecPreProd.set("record_create_user",processing_user);
    Record producedRecord= exgui2.CONST.BASIC_MAIN_EJB.insertRecord("preprod_tbl",blankRecPreProd);
    new_prod_head_pk= producedRecord.getInt(0);
    //-------------------copy prod head----------------------------
    columncount=srcRecProdHead.getFieldName().size();
    for(int i=1;i<columncount;i++){
      blankRecProdHead.set(i,srcRecProdHead.get(i));
    }
    blankRecProdHead.set("record_create_user",processing_user);
    blankRecProdHead.set(0,new_prod_head_pk);
    //----------------------copy production---------------------------
    columncount=srcRecProduction.getFieldName().size();
    for(int i=1;i<columncount;i++){
      blankRecProduction.set(i,srcRecProduction.get(i));
    }
    blankRecProduction.set(0,new_prod_head_pk);
    blankRecProduction.set("PROD_SC_NO",null);
    blankRecProduction.set("PROD_AUDIT_STATUS","1");
    //PROD_FABCOMM_CONTRACT, PROD_FABCOMM_REFNO
    blankRecProduction.set("PROD_FABCOMM_CONTRACT",null);//default fabric-trim commision is null;
    blankRecProduction.set("PROD_FABCOMM_REFNO",null);
    blankRecProduction.set("record_create_user",processing_user);


    exgui2.CONST.BASIC_MAIN_EJB.insertRecord("prod_head_tbl",blankRecProdHead);
    exgui2.CONST.BASIC_MAIN_EJB.insertRecord("production_tbl",blankRecProduction);

    Vector vctMtrV=exgui2.CONST.BASIC_MAIN_EJB.getDatas(
      util.PublicVariable.USER_RECORD,"select * from MTR_V_PREPROD where MTR_V_PREPROD_PROD_HEAD_PK="+ org_prod_head_pk,1,999999);
    Vector vctDestMtrl=(Vector)util.MiscFunc.deepCopy(vctMtrV);
    recordCloner(vctMtrV,vctDestMtrl);
    Record destMtrVRec=null;
    //-------------------------copy materal data of this prodction----------------------------------
    for(int i=0;i<vctDestMtrl.size();i++){
      Record orgMtrVRec=(Record)vctDestMtrl.get(i);
      if(i==0){
        destMtrVRec=(Record)util.MiscFunc.deepCopy(orgMtrVRec);
        columncount=destMtrVRec.getFieldName().size();
      }
      for(int j=1;j<columncount;j++){
        destMtrVRec.set(j,orgMtrVRec.get(j));
      }
      destMtrVRec.set(0,new_prod_head_pk);
      destMtrVRec.set(2,processing_user);//record_create_user
      exgui2.CONST.BASIC_MAIN_EJB.insertRecord("mtr_v_preprod_tbl",destMtrVRec);
    }
    return new_prod_head_pk;
  }
  public void duplicateProdColor()throws Exception{
    Vector orgProdColors=exgui2.CONST.BASIC_MAIN_EJB.getDatas(
      util.PublicVariable.USER_RECORD,
      "select * from prod_color where PROD_HEAD_PK="+org_prod_head_pk +" and record_delete_flag='1' order by PROD_COLOR_PK"
      ,1,9999999);
    Vector destProdColors=(Vector)util.MiscFunc.deepCopy(orgProdColors);
    recordCloner(orgProdColors,destProdColors);
    hmColorKeyHistoryMap.clear();
    for(int i=0;i<destProdColors.size();i++){
        Record destRec=(Record)destProdColors.get(i);
        Record orgColorRec=(Record)orgProdColors.get(i);
        destRec=exgui2.CONST.BASIC_MAIN_EJB.insertRecord("prod_color_tbl",destRec);
        hmColorKeyHistoryMap.put(orgColorRec.get(0).toString(),destRec.get(0).toString());
        System.out.println("color map set :"+orgColorRec.get(0).toString()+","+destRec.get(0).toString());
    }
  }
  public void duplicateQtys()throws Exception{
    Vector orgQtys=exgui2.CONST.BASIC_MAIN_EJB.getDatas(
      util.PublicVariable.USER_RECORD,
      "select * from qty where qty_STY_SEQ in (select sty_seq from style where prod_head_pk=" +org_prod_head_pk +
      " and record_delete_flag='1') and record_delete_flag='1' order by QTY_SEQ"
      ,1,9999999);
    Vector destQtys=(Vector)util.MiscFunc.deepCopy(orgQtys);
    recordCloner(orgQtys,destQtys);
    for(int i=0;i<orgQtys.size();i++){
        Record destRec=(Record)destQtys.get(i);
        destRec=exgui2.CONST.BASIC_MAIN_EJB.insertRecord("QTY_tbl",destRec);
    }
  }

  public void duplicatePrice()throws Exception{
    Vector orgPrices=exgui2.CONST.BASIC_MAIN_EJB.getDatas(
      util.PublicVariable.USER_RECORD,
      "select * from price where PRI_STY_SEQ in (select sty_seq from style where prod_head_pk=" +org_prod_head_pk +
      " and record_delete_flag='1') and record_delete_flag='1' order by PRI_SEQ"
      ,1,9999999);
    Vector destPrices=(Vector)util.MiscFunc.deepCopy(orgPrices);
    recordCloner(orgPrices,destPrices);
    hmPriceKeyHistoryMap.clear();
    for(int i=0;i<orgPrices.size();i++){
        Record destRec=(Record)destPrices.get(i);
        Record orgRec=(Record)orgPrices.get(i);
        destRec=exgui2.CONST.BASIC_MAIN_EJB.insertRecord("PRICE_tbl",destRec);
        hmPriceKeyHistoryMap.put(orgRec.get(0).toString(),destRec.get(0).toString());
        System.out.println("price map set "+orgRec.get(0).toString()+","+destRec.get(0).toString());
    }
  }


  public void duplicateStyle()throws Exception{
    Vector orgStyles=exgui2.CONST.BASIC_MAIN_EJB.getDatas(
      util.PublicVariable.USER_RECORD,
      "select * from style where PROD_HEAD_PK="+org_prod_head_pk +"  order by sty_seq"
      ,1,9999999);
    Vector destStyles=(Vector)util.MiscFunc.deepCopy(orgStyles);
    recordCloner(orgStyles,destStyles);
    hmStyleKeyHistoryMap.clear();
    newtimes.production.process.prodmaintain.DB_StyleListHandler db=
        new newtimes.production.process.prodmaintain.DB_StyleListHandler();

    for(int i=0;i<destStyles.size();i++){
        Record destRec=(Record)destStyles.get(i);
        Record orgRec=(Record)orgStyles.get(i);
        destRec=db.addRecord(destRec);
        hmStyleKeyHistoryMap.put(orgRec.get(0).toString(),destRec.get(0).toString());
        System.out.println("style map set :"+orgRec.get(0).toString()+","+destRec.get(0).toString());
    }
  }


  protected void recordCloner(Vector vctOrgRecords,Vector vctDestRecords){
    //construct the mapping between name and column,for faster index.
    if(vctOrgRecords==null || vctOrgRecords.size()==0)return;
    Record tmpRec=(Record)vctOrgRecords.get(0);
    String fieldNames[]=(String[])tmpRec.getFieldName().toArray(new String[0]);
    for(int i=0;i<vctDestRecords.size();i++){
      Record orgRec=(Record)vctOrgRecords.get(i);
      Record destRec=(Record)vctDestRecords.get(i);
      for(int j=0;j<fieldNames.length;j++){
        if(fieldNames[j].toLowerCase().indexOf("prod_head_pk")!=-1){
          destRec.set(j,new_prod_head_pk);
          continue;
        }
        if(fieldNames[j].toLowerCase().indexOf("_color_pk")!=-1){
          Object orgColorPkValue=orgRec.get(j);
          if(orgColorPkValue!=null){
            Object newProdColorPk=hmColorKeyHistoryMap.get(orgColorPkValue.toString());
            System.out.println("read color,key is "+orgColorPkValue+",value is: "+newProdColorPk );
            destRec.set(j,newProdColorPk);
            continue;
          }
        }
        if(fieldNames[j].toLowerCase().indexOf("_sty_seq")!=-1){
          Object orgStyPkValue=orgRec.get(j);
          if(orgStyPkValue!=null){
            Object newStyPk=hmStyleKeyHistoryMap.get(orgStyPkValue.toString());
            System.out.println("read style,key is "+orgStyPkValue+",value is: "+newStyPk );
            destRec.set(j,newStyPk);
            continue;
          }
        }
        if(fieldNames[j].toLowerCase().indexOf("pri_seq")!=-1){
          Object orgPrxPkValue=orgRec.get(j);
          if(orgPrxPkValue!=null){
            Object newPrxPk=hmPriceKeyHistoryMap.get(orgPrxPkValue.toString());
            System.out.println("read price,key is "+orgPrxPkValue+",value is: "+newPrxPk );
            destRec.set(j,newPrxPk);
            continue;
          }
        }
        if(fieldNames[j].toLowerCase().endsWith("_sc_no")){
          destRec.set(j,null);
          continue;
        }
        if(fieldNames[j].equalsIgnoreCase("record_create_user")){
          destRec.set(j,processing_user);
          continue;
        }
        destRec.set(j,orgRec.get(j));
      }
    }
  }
}
