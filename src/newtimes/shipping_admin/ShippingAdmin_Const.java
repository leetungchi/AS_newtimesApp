package newtimes.shipping_admin;
import database.datatype.Record;
/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class ShippingAdmin_Const {
  static public java.awt.Color PANEL_BACKGROUNDCOLOR=new java.awt.Color(204,204,225);
  static public String SHIPPING_ADMIN_COMMAND="newtimes.shipping_admin.SHIPPING_ADMIN_COMMAND";
  static public String SHIPPING_PACKING_COMMAND="newtimes.shipping_admin.SHIPPING_ADMIN_PACKING";
  static public PnlBaseContainer SHIPPING_EDIT_PANEL=null;
  static public Record SHIPPING_EDITING_HEAD_RECORD=null;
  static public String CURRENT_EDITING_SHIP_SRN=null;
  static public  newtimes.shipping_admin.process.shiippingmaintain.DB_ShipMaster
               DB_SHIP_SRN_HEAD_HANDLER =new newtimes.shipping_admin.process.shiippingmaintain.DB_ShipMaster();
  static public java.util.HashMap HM_CONDITION_QRY_STYLES;
  public static int  EDIT_SHIP_STYLE_STYLE_INT_SEQ=0;
  public static int  EDIT_SHIP_STYLE_SEQ_INT=0;
  public static Record EDITING_SHIPPING_STYLE_RECORD;
  public static Record EDITING_SHIPPING_SI_RECORD;
  public static int  EDIT_SHIP_SI_PK_INT=0;
  public static javax.swing.JPanel pnlQryStylesByScPo=null;
  public static java.util.Vector DESTINATIONS;
  public static java.util.HashMap SHIP_MASTER_QRY_CONDITION=new java.util.HashMap();
  public static javax.swing.JPanel PNL_QRY_SHIPMASTER_CONDITIONS=null;
  public static String CurrentWorkingCenterCode;
  public static String lastOpCenter=null;
  public static String lastOpCenterPrefix=null;
  public static String strIsShipClosed=null;
  public static java.util.Vector vctSignatuers=null;
  public static java.util.HashMap hmSignatureTitle=null;
  static public java.util.HashMap hmPoStyleMap2ShipStyle=new java.util.HashMap();
  static public String OFFSHORE_CENTER=null;
  static public String INIT_ASN_CODE=null;
  static public boolean IS_LORAN_MODE=false;
  static public String INIT_QRY_LAUREN_PO=null;
  static public String INIT_QRY_LAUREN_FTY_INV=null;
  public static String getCenterPrefix(String cenCode){
    for(int i=0;i<newtimes.preproduction.guis.tempProperties.tmpCenters.size();i++){
      Record rec=(Record)newtimes.preproduction.guis.tempProperties.tmpCenters.get(i);
      if(rec.get(0).equals(cenCode)){
        return rec.get(18).toString();
      }
    }
    return null;
  }
  public  static boolean isShipClosed(Record recShipDtl){
    if(null==recShipDtl){
      return false;
    }
    if(isUserEric())return false;
    System.out.println("recShipDtl To Test  Close is ==============>"+recShipDtl.toString());
    if(util.PublicVariable.USER_RECORD.get(0).equals("NTERIC")||
       util.PublicVariable.USER_RECORD.get(0).equals("CG")){
      return false;
    }
    try{
      Object objShipCloseb4 =
          newtimes.preproduction.Constants.SYSTEM_DEFAULT_RECORD.get(
          "ship_close_b4");
      if (objShipCloseb4 == null){
        return false;
      }
      //for tpe,always check by etd date.
      //SHIP_ETD_DATE

      Object objShipCreateDate=
          recShipDtl.get(
               util.PublicVariable.OPERATTING_CENTER.equals("001")?"SHIP_ETD_DATE":"Ship_head_create_date"
               );
          //recShipDtl.get("Ship_head_create_date");//or judug by Ship_head_create_date

      if(objShipCreateDate==null){
        return false;
      }
       if (((java.util.Date)objShipCreateDate).after((java.util.Date)
           objShipCloseb4)) {
         return false;
       }

     return true;
    }catch(Exception exp){
      exp.printStackTrace();
      return false;
    }

  }

  public static boolean isShipClosed(){
    if(isUserEric()){
      return false;
    }
    if(strIsShipClosed!=null){
      return new Boolean(strIsShipClosed).booleanValue();
    }
    try{
      Object objShipCloseb4 =
          newtimes.preproduction.Constants.SYSTEM_DEFAULT_RECORD.get(
          "ship_close_b4");
      if (objShipCloseb4 == null){
        strIsShipClosed="FALSE";
        return false;
      }
      Object objShipCreateDate=
          newtimes.shipping_admin.ShippingAdmin_Const.SHIPPING_EDITING_HEAD_RECORD.get(
               util.PublicVariable.OPERATTING_CENTER.equals("001")?"SHIP_ETD_DATE":"record_create_date"
               );
      if(objShipCreateDate==null){
        strIsShipClosed="FALSE";
        return false;
      }
     System.out.print("objShipCreateDate object class name is "+objShipCreateDate.getClass().getName());
     System.out.print("objShipCloseb4 object class name is "+objShipCloseb4.getClass().getName());
     /*
      if(util.PublicVariable.OPERATTING_CENTER.equals("NTHK")){
        StringBuffer sb=new StringBuffer();
        sb.append("select get_rptdate((select nvl(record_create_date,ship_rpt_create) from shipping where ship_no='");
        sb.append(newtimes.shipping_admin.ShippingAdmin_Const.SHIPPING_EDITING_HEAD_RECORD.get(0));
        sb.append("'),");
        sb.append("(select nvl(SHIP_RPT_ETD,SHIP_ETD_DATE)from shipping where ship_no='");
        sb.append("')) from dual");

        Record rec=(Record)exgui2.CONST.BASIC_MAIN_EJB.getDatas(
          util.PublicVariable.USER_RECORD,
          sb.toString(),1,1).get(0);
         objShipCreateDate=rec.get(0);
      }*/
       if (((java.util.Date)objShipCreateDate).after((java.util.Date)
           objShipCloseb4)) {
         strIsShipClosed = "FALSE";
         return false;
       }

     strIsShipClosed="TRUE";
     return true;
    }catch(Exception exp){
      exp.printStackTrace();
      return false;
    }
  }
  public static boolean isUserEric(){
    String userId=(String)util.PublicVariable.USER_RECORD.get(0);
    if(userId.equals("NTERIC")||
       userId.equals("DENNIS")||
       userId.equals("CG")||
       (userId.length()>=10 &&
        userId.substring(userId.length()-10,userId.length()).equals("ANTHONYLIU"))){
      return true;
    }
    return false;
  }
  public static Record completeSrnByNumRecord(String iniNumber)throws Exception{
    String headingStr=null;
    boolean isXCenter=false;
    if(!util.PublicVariable.OPERATTING_CENTER.equals(lastOpCenter)){
      lastOpCenter=(String)util.PublicVariable.OPERATTING_CENTER;
      Record recCenter=(Record)exgui2.CONST.BASIC_MAIN_EJB.getDatas(
       util.PublicVariable.USER_RECORD,
       "select * from center where cen_code='"+lastOpCenter+"'",1,1).get(0);
      lastOpCenterPrefix=((String)recCenter.get("CEN_NUMCODE"))+((String)recCenter.get("CEN_PREFIX"));
    }else{

    }
    if(util.PublicVariable.OPERATTING_CENTER.equals("001")||util.PublicVariable.OPERATTING_CENTER.equals("NTHK")){
      isXCenter=false;
    }else{
      isXCenter=true;
    }
    headingStr = "Z" + lastOpCenterPrefix;
    //select * from shipping where (ship_no like 'ZNNT%' and ship_no like '%520254')
    StringBuffer sb =null;
    if(!isXCenter){
      String sql = "select ship_no, (select C_B_DESC FROM SHIPPING_CONSOLIDATION_BOX where SHIPPING_CONSOLIDATION_BOX.ship_no=shipping.ship_no) as CB_DESC from shipping where  (ship_no like '";
      sb= new StringBuffer(sql);
      sb.append(headingStr);
      sb.append("%'");
      sb.append(" and ship_no like '%");
      sb.append(String.valueOf(iniNumber));
      sb.append("') and record_delete_flag='1'");
    }else{
      String sql = "select ship_no,(select C_B_DESC FROM SHIPPING_CONSOLIDATION_BOX where SHIPPING_CONSOLIDATION_BOX.ship_no=shipping.ship_no) as CB_DESC ,SHIP_DIM_CUFT from shipping where  (ship_no like 'Z%'";
      sb= new StringBuffer(sql);
      sb.append(" and substr(ship_no,4,2)='");
      sb.append(lastOpCenterPrefix.substring(1,3));sb.append("'");
      sb.append(" and ship_no like '%");
      sb.append(String.valueOf(iniNumber));
      sb.append("') and record_delete_flag='1' and length(ship_no)=13 " );
    }

    java.util.Vector vct=exgui2.CONST.BASIC_MAIN_EJB.getDatas(
      util.PublicVariable.USER_RECORD,
      sb.toString(),1,1);
    if(vct==null)return null;
    if(vct.size()==0)return null;
    Record recTmp=(Record)vct.get(0);
    return recTmp;
  }
  public static String completeSrnByNum(String iniNumber)throws Exception{
    Record rec=completeSrnByNumRecord(iniNumber);
    return (String)rec.get(0);
  }
  public static String recnvDblCamaString(String strIn){
    if(strIn==null)return"";
    String str[]=util.MiscFunc.split(strIn,",,");
    StringBuffer sb=new StringBuffer();
    for(int i=0;i<str.length;i++){
      if(str[i].trim().length()>0){
        if(sb.length()>0)sb.append(",,");
        sb.append(str[i]);
      }
    }
    if(sb.toString().equals("QTY")) return "";
    return sb.toString();
  }
  public ShippingAdmin_Const() {
  }
}
