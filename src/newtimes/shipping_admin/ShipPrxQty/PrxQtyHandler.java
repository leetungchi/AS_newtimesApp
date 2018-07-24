package newtimes.shipping_admin.ShipPrxQty;

import exgui.ultratable.DummyDBHandler;
import java.util.*;
import database.datatype.Record;
/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class PrxQtyHandler extends DummyDBHandler {
   ShippingAdmin.SRN_Style.ShipPriceQtyFacade ejb=null;
   //Record shipStyleRec=null;
  //public PrxQtyHandler(Record _shipStyleRec) {
  Vector vct2delete=new Vector();
  Vector vctColorCode=null;
  public PrxQtyHandler(boolean iniByShipQtyOrPoQty) {
    //super();
    try{

      //shipStyleRec=_shipStyleRec;
      ShippingAdmin.SRN_Style.ShipPriceQtyFacadeHome ejbHome=
          (ShippingAdmin.SRN_Style.ShipPriceQtyFacadeHome)
          info_ejb.WeblogicServiceLocator.locateServiceHome(
          util.PublicVariable.SERVER_URL,
          "ShippingAdmin.SRN_Style.ShipPriceQtyFacade");
      ejb=ejbHome.create();
      super.setPkColumns("ship_price_pk");
      super.blankRec=ejb.getBlankRecord();
      blankRec.set("record_create_user",util.PublicVariable.USER_RECORD.get(0));
      Vector returnVct=ejb.getRecords(
      ((iniByShipQtyOrPoQty)?
      newtimes.shipping_admin.ShippingAdmin_Const.EDIT_SHIP_STYLE_SEQ_INT:-5),
      newtimes.shipping_admin.ShippingAdmin_Const.EDIT_SHIP_STYLE_STYLE_INT_SEQ,
      iniByShipQtyOrPoQty);

      super.InitByOrgData(returnVct);
     //have to set defalut valule of blank data.
     getColorVct();
     if(vctColorCode.size()>0){
       Record recColor=(Record)vctColorCode.get(0);
       blankRec.set(2,recColor.get(0));//set prod_color_pk;
     }
    }catch(Exception exp){
      exp.printStackTrace();
    }
  }

  protected String getPKObj(Record rec)throws Exception{
    return rec.get(0).toString();
  }

  public Vector  getRecords(int startPosition,int rowCounts)throws Exception{
     //return super.getRecords(startPosition,rowCounts);
     Object keyArr[]=dummyDatas.keySet().toArray();
      Iterator itr=dummyDatas.entrySet().iterator();
      int index=0;
      while(itr.hasNext()){
        if(index==keyArr.length)break;
        //System.out.println("iter for dummydata is :"+dummyDatas.get(itr.next()).toString());
        keyArr[index]=itr.next();
        index++;
      }

      Vector vct2return=new Vector();
      for(int i=startPosition-1;i<(startPosition-1+rowCounts);i++){
        if(i==keyArr.length)break;//out of bound
        //System.out.println("keyArr["+i+"]="+keyArr[i]);
        Record rec=(Record)dummyDatas.get(keyArr[i]);
        //System.out.println("rec===>" + rec.toString());
        vct2return.add(rec);
      }
     return vct2return;
  }

  public java.util.Vector getColorVct(){
    if(vctColorCode==null){
      vctColorCode=new Vector();
      try {
        StringBuffer sb = new StringBuffer();
        sb.append("select prod_color_pk,prod_color_code,prod_color_name||decode(prod_remark,null,'',' <'||prod_remark||'>') as prod_color_name ");
        sb.append("from prod_color where prod_color_pk in ");
        sb.append("(select prod_color_pk from price where pri_sty_seq=");
        sb.append(newtimes.shipping_admin.ShippingAdmin_Const.
                  EDIT_SHIP_STYLE_STYLE_INT_SEQ);
        sb.append(") order by prod_color_pk");
        Vector vct = exgui2.CONST.BASIC_MAIN_EJB.getDatas(
            util.PublicVariable.USER_RECORD, sb.toString(), 1, 999
            );

        for (int i = 0; i < vct.size(); i++) {
          Record recTmpColor = (Record)vct.get(i);
          vctColorCode.add(recTmpColor);
        }

      } catch (Exception exp) {
        exp.printStackTrace();
      }
    }
    return vctColorCode;
  }

  public Vector  getDeletRecords()throws Exception{
      Set keys=deletedDummyDatas.keySet();
      Object keyArr[]=keys.toArray();
      Vector vct2return=new Vector();
      //according to habit of pagedDataFactory usage, row position is base from "1",not zero,
      for(int i=0;i<99999;i++){
        if(i==keyArr.length)break;//out of bound
        Record rec=(Record)deletedDummyDatas.get(keyArr[i]);
        vct2return.add(rec);
      }
      return vct2return;
  }

  public Record finalUpdate()throws Exception{
       Vector vct2delete=getDeletRecords();
       Vector vct2update=getRecords(1,99999);
       /*
       while(itr.hasNext()){
         String key=(String)itr.next();
         vct2update.add(dummyDatas.get(key));
       }*/
       Record rec2update=newtimes.shipping_admin.ShippingAdmin_Const.EDITING_SHIPPING_STYLE_RECORD;
       if(rec2update.get(0)==null ||
          (rec2update.getInt(0)<0 && rec2update.getInt(0)<-4000)){
         /*
         rec2update.set("ship_sty_size_column",
                        newtimes.shipping_admin.ShippingAdmin_Const.recnvDblCamaString(
                       (String)rec2update.get("_$ORG_STY_SIZE_COLUMN")));
         */
         rec2update.set("record_create_user",util.PublicVariable.USER_RECORD.get(0));
         rec2update.set("record_modify_user",util.PublicVariable.USER_RECORD.get(0));
       }else{
         rec2update.set("record_modify_user",util.PublicVariable.USER_RECORD.get(0));
       }
       /*
       System.out.println("===========rec 2 update is =================");
       for(int i=0;i<vct2update.size();i++){
         Record recTest=(Record)vct2update.get(i);
         System.out.println("===>"+recTest.toString());
       }
       System.out.println("===========rec 2 update is =================");
       */
      rec2update=ejb.doUpdateToShipQtyTable(
         vct2update,vct2delete,
         util.PublicVariable.USER_RECORD.get(0).toString(),
         (String)rec2update.get("_$ORG_STYLE_UNIT"),
         rec2update);
     return rec2update;
  }
}
