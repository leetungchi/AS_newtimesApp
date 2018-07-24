package newtimes.production.process.prodmaintain;

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

public class DbBriefQtyHandler extends PagedDataFactoryAdapter {
  int styleSeq=0;
  public Record recEditingStyle;
  public Record recEditingProdHead;
  public DbBriefQtyHandler(int stySeq,Record recStyle) {
      try{
        newtimesejb.production.BriefQtyFacadeHome ejbHome=
            (newtimesejb.production.BriefQtyFacadeHome)
            info_ejb.WeblogicServiceLocator.locateServiceHome(
            util.PublicVariable.SERVER_URL,"newtimesejb.production.BriefQtyFacade");
        newtimesejb.production.BriefQtyFacade ejb=ejbHome.create();
        super.ejb=ejb;
        super.blankRecord=ejb.getBlankRecord();
        styleSeq=stySeq;
        blankRecord.set(1,styleSeq);
        blankRecord.set("record_create_user",util.PublicVariable.USER_RECORD.get(0));
        recEditingStyle=recStyle;
      }catch(Exception exp){
         exp.printStackTrace();
         util.ExceptionLog.exp2File(exp,"");
      }
  }
  public void updateRecords(Vector vct,Record recToStoreHead)throws Exception{
    newtimesejb.production.BriefQtyFacadeHome ejbHome=
        (newtimesejb.production.BriefQtyFacadeHome)
        info_ejb.WeblogicServiceLocator.locateServiceHome(
        util.PublicVariable.SERVER_URL,"newtimesejb.production.BriefQtyFacade");
    newtimesejb.production.BriefQtyFacade ejb2handle=ejbHome.create();
    //ejb2handle.updateRecords(vct,recToStoreHead,util.PublicVariable.USER_RECORD.get(0).toString());
    ejb2handle.directUpdateBrfQty2PrxColor(vct,recToStoreHead,util.PublicVariable.USER_RECORD.get(0).toString());
    /*
    ((newtimesejb.production.BriefQtyFacade)ejb).updateRecords(vct,recToStoreHead,
        util.PublicVariable.USER_RECORD.get(0).toString());
    */
  }
  public void update2QtyTable(int stySeq)throws Exception{

    newtimesejb.production.BriefQtyFacadeHome ejbHome=
        (newtimesejb.production.BriefQtyFacadeHome)
        info_ejb.WeblogicServiceLocator.locateServiceHome(
        util.PublicVariable.SERVER_URL,"newtimesejb.production.BriefQtyFacade");
    newtimesejb.production.BriefQtyFacade ejb2handle=ejbHome.create();

   ejb2handle.doUpdateToQtyTable(
      stySeq,util.PublicVariable.USER_RECORD.get(0).toString());
  }
  public void updateRecords(Vector vct)throws Exception{
    return;
    /*
    if(vct==null)return;
    if(vct.size()==0)return;
    ((newtimesejb.production.BriefQtyFacade)ejb).updateRecords(vct,null,
        util.PublicVariable.USER_RECORD.get(0).toString());*/
  }
  public void updateSizeColumn(String sizeColumn)throws Exception{
    Record recToStoreHead=getBlankRecord();
    if(sizeColumn.trim().length()>0){
      String str[]=util.MiscFunc.split(sizeColumn,",,");
      for(int i=0;i<str.length;i++){
        recToStoreHead.set(8+i,str[i]);
      }
    }
    ((newtimesejb.production.BriefQtyFacade)ejb).directUpdateBrfQty2PrxColor(new Vector(),recToStoreHead,
        util.PublicVariable.USER_RECORD.get(0).toString());
  }
  public Vector getRecords(int bgn,int rowcount)throws Exception{

      HashMap hm=new HashMap();
      hm.put("STY_PK",String.valueOf(styleSeq));
      hm.put("RECORD_DELETE_FLAG","1");
      hm.put("isFromColorPrx","isFromColorPrx");
      Vector vct=null;
      try{
         vct = ejb.getRecords(1, 999999, hm);
      }catch(Exception exp){
         exp.printStackTrace();
      }
      if(vct==null)vct = ejb.getRecords(1, 999999, hm);
      return vct;

      //Vector vct2return=new Vector();
      /*
      Vector vct=null;
      try{
         vct = ejb.getRecords(1, 999999, hm);
      }catch(Exception exp){
         exp.printStackTrace();
      }
      //try twice.
      if(vct==null)vct = ejb.getRecords(1, 999999, hm);
      //complete to 40 rows,for stupid user to us.
      int appBgn=40-vct.size();
      Vector vctDest=new Vector();
      int negSeq=0;
      for(int i=0;i<40;i++){
        Record rec2add=null;
        if(i<vct.size()){
          rec2add=(Record)vct.get(i);
        }else{
          negSeq--;
          rec2add=getBlankRecord();
          rec2add.set(0,negSeq);
        }
        vctDest.add(rec2add);
      }
      return vctDest;
     //return vct2return;
     */
  }
}
