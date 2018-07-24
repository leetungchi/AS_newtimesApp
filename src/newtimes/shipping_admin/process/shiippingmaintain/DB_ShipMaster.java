package newtimes.shipping_admin.process.shiippingmaintain;
import exgui.ultratable.PagedDataFactoryAdapter;
import java.util.Vector;
import database.datatype.Record;

public class DB_ShipMaster extends PagedDataFactoryAdapter {
  static boolean initOK = false;
  public static Vector vctCountry = null;
  public static Vector vctShipPriceTerm = null;
  public static Vector vctSzn = null;
  public static Vector vctDivisions = null;
  public boolean is2ShowForDirectHeadUse=false;
  StringBuffer sb=null;
  public DB_ShipMaster() {
    try {
      ShippingAdmin.SRN_Style.ShipHeadFacadeHome ejbHome =
          (ShippingAdmin.SRN_Style.ShipHeadFacadeHome)
          info_ejb.WeblogicServiceLocator.locateServiceHome(
          util.PublicVariable.SERVER_URL,
          "ShippingAdmin.SRN_Style.ShipHeadFacade");
      ejb = ejbHome.create();
      blankRecord = ejb.getBlankRecord();
      initOK = true;
    } catch (Exception e) {
      util.ExceptionLog.exp2File(e, "error in DB_ShipMaster");
      e.printStackTrace();
      exgui.verification.VerifyLib.showAlert(
          "Server Side Connection Fail\nPlease Contact System Manager",
          "Connection Fail");
      initOK = false;
    }
  }
  protected void initSql(){
    sb=new StringBuffer();
    sb.append("select ");
    sb.append("a.prod_head_pk,");
    sb.append("a.prod_nbf_code,");
    sb.append("(select count(b.FAB_COMM_PK) from fab_comm b where ");
    sb.append("b.FAB_COMM_PROD_PK=a.prod_head_pk ");
    sb.append("and b.record_delete_flag='1' ) as fab_comm_count,");
    sb.append("d.PROD_COMM_N_REASON ");
    sb.append("from production a,PROD_COMM_N_REASON d ");


  }
  public  void updateShippingPrintStatus4Buyer()throws Exception{
     ((ShippingAdmin.SRN_Style.ShipHeadFacade)ejb).updatePrintStatus("SHIP_ACC_PRINT_BY_BUYER");
  }
  public  void updateShippingPrintStatus4Maker()throws Exception{
     ((ShippingAdmin.SRN_Style.ShipHeadFacade)ejb).updatePrintStatus("SHIP_ACC_PRINT_BY_MAKER");
  }

  public static boolean isInitOk() {return initOK; }
  public Vector getRecords(int bgn,int rowcount)throws Exception{
    //
    String storedCenter=
        (String)newtimes.shipping_admin.ShippingAdmin_Const.SHIP_MASTER_QRY_CONDITION.get("d.CEN_CODE");
    boolean isListUniqSC=false;
    if(newtimes.shipping_admin.ShippingAdmin_Const.SHIP_MASTER_QRY_CONDITION.get("LIST_BY_SRN")!=null){
      isListUniqSC= ((Boolean)newtimes.shipping_admin.ShippingAdmin_Const.SHIP_MASTER_QRY_CONDITION.get("LIST_BY_SRN")).booleanValue();
    }
    String srn_no=
       (String)newtimes.shipping_admin.ShippingAdmin_Const.SHIP_MASTER_QRY_CONDITION.get("a.SHIP_NO");
    if((storedCenter!=null && storedCenter.equals("001")) && isListUniqSC && srn_no!=null && srn_no.length()>10){
      StringBuffer sb=new StringBuffer();
      sb.append("select a.SHIP_ETD_DATE,a.SHIP_NO,");
      sb.append("b.PROD_HEAD_PK,b.PROD_CEN_CODE,d.CEN_NAME,");
      sb.append("e.DEP_NAME,b.PROD_BUYER,");
      sb.append("b.PROD_MAKER,pdx.prod_sc_no,");
      sb.append("c.ship_sc_pk,");
      sb.append("b.prod_year,pdx.prod_qc_cnty,");
      sb.append("b.prod_season,");
      sb.append("(select div_name from division where div_code=b.PROD_BUYER_DIVISION) as division_name,");
      sb.append("(select MNG_ABBR from manager where mng_code=b.PROD_MNG_CODE) as mamanger,");
      sb.append("(select bymkr_brief from buyer_maker where buyer_maker.bymkr_seq=b.PROD_BUYER) as buyer, ");
      sb.append("(select bymkr_brief from buyer_maker where buyer_maker.bymkr_seq=b.PROD_Maker) as maker ");
      sb.append("from shipping a ,prod_head b,ship_sc c,center d,department e  ,production pdx ,V_SHIP_OFFSHORE ship_of  ");
      sb.append("where 1=1  ");
      sb.append(" and a.ship_no=ship_of.ship_no ");
      if(util.PublicVariable.USER_RECORD.getInt(2)==newtimesejb.preproduction.PreProductionHead.USER_TYPE_ABROAD_USERS){
        sb.append(" and ship_of.OFF_CENTER='");
        sb.append(util.MiscFunc.Replace(newtimes.shipping_admin.ShippingAdmin_Const.OFFSHORE_CENTER,"'", "''"));
        sb.append("' ");
      }
      sb.append("and pdx.prod_head_pk=b.prod_head_pk ");
      sb.append("and c.SHIP_NO=a.SHIP_NO and a.record_delete_flag='1' ");
      sb.append("and b.PROD_HEAD_PK=c.PROD_HEAD_PK ");
      sb.append("and b.record_delete_flag='1' ");
      sb.append("and b.PROD_CEN_CODE=d.CEN_CODE ");
      sb.append("and b.PROD_DEPTMENT=e.DEP_CODE  ");
      sb.append("and d.CEN_CODE='001' ");
      sb.append("and c.ship_no like '");
      sb.append(util.MiscFunc.Replace(srn_no,"'","''"));
      sb.append("%' ");
      if(srn_no.trim().length()<"ZATWJJ502045".length()){
        sb.append(" and b.prod_head_pk in ");
        sb.append(" (select prod_head_pk from ship_sc where ship_no=a.ship_no and rownum=1) ");
      }else{
        sb.append(" and rownum=1 ");
      }
      sb.append(" order by a.ship_no ");

      return exgui2.CONST.BASIC_MAIN_EJB.getDatas(util.PublicVariable.USER_RECORD,sb.toString(),bgn,rowcount);
    }


    //
    //this hash map is set up in query interface.

    if(util.PublicVariable.USER_RECORD.getInt(2)==newtimesejb.preproduction.PreProductionHead.USER_TYPE_ABROAD_USERS){
      newtimes.shipping_admin.ShippingAdmin_Const.SHIP_MASTER_QRY_CONDITION.put(
          "PROD_OFFSHORE_CENTER",newtimes.shipping_admin.ShippingAdmin_Const.OFFSHORE_CENTER);
    }
    Vector vct= ejb.getRecords(bgn,rowcount,
                          newtimes.shipping_admin.ShippingAdmin_Const.SHIP_MASTER_QRY_CONDITION);
    Vector vct2Return=new Vector();
    //if user type is accounting,need to check fabric commision is "N" and reason
    if(is2ShowForDirectHeadUse &&
       util.PublicVariable.OPERATTING_CENTER.equals("001") &&
       (util.PublicVariable.USER_RECORD.getInt(2)==newtimesejb.preproduction.PreProductionHead.USER_TYPE_ACCOUNTING_USERS||
        util.PublicVariable.USER_RECORD.getInt(2)==newtimesejb.preproduction.PreProductionHead.USER_TYPE_SUPERVIOSER_MIS))
     {
      if(vct.size()>0){
        StringBuffer sbProdPk = new StringBuffer();
        java.util.HashMap hm=new java.util.HashMap();
        try {
          for (int i = 0; i < vct.size(); i++) {
            Record rec = (Record)vct.get(i);
            if (sbProdPk.length() > 0)sbProdPk.append(",");
            int prod_pk=rec.getInt("prod_head_pk");
            sbProdPk.append(String.valueOf(prod_pk));
          }
          if(sb==null)initSql();
          StringBuffer sbFinalSql = new StringBuffer(sb.toString());
          sbFinalSql.append(" where a.prod_head_pk in (");
          sbFinalSql.append(sbProdPk.toString());
          sbFinalSql.append(")and a.prod_head_pk=d.prod_head_pk(+)");
          Vector vctFabComm_N_Reason=exgui2.CONST.BASIC_MAIN_EJB.getDatas(
          util.PublicVariable.USER_RECORD,
          sbFinalSql.toString(),1,999999);
          for(int i=0;i<vctFabComm_N_Reason.size();i++){
            Record rec=(Record)vctFabComm_N_Reason.get(i);
            hm.put(rec.get(0).toString(),rec);
          }
          for(int i=0;i<vct.size();i++){
             Record recOrg=(Record)vct.get(i);
             Record recFabComm=(Record)hm.get(recOrg.get("prod_head_pk").toString());
             recOrg.getFieldName().add("prod_nbf_code");
             recOrg.getValueFields().add(recFabComm.get(1));
             recOrg.getFieldName().add("fab_comm_count");
             recOrg.getValueFields().add(recFabComm.get(2));
             recOrg.getFieldName().add("PROD_COMM_N_REASON");
             recOrg.getValueFields().add(recFabComm.get(3));
             vct2Return.add(recOrg);
          }
           //applend the data to the row to display.
        } catch (Exception exp) {
          exp.printStackTrace();
          util.ExceptionLog.exp2File(exp, "");
        }
      }
      return vct2Return;
    }else{

      return vct;
    }
  }
  public void reUpdateSc(int prod_head_pk,String srn)throws Exception{
    ((ShippingAdmin.SRN_Style.ShipHeadFacade)ejb).reUpdateSrnSc(prod_head_pk,srn);
  }
  public Record getSiRecord(int ship_sc_pk)throws Exception{
    return ((ShippingAdmin.SRN_Style.ShipHeadFacade)ejb).getScRecord(ship_sc_pk);
  }
  public void updateSiRecord(Record si_record)throws Exception{
    si_record.set("record_modify_user",util.PublicVariable.USER_RECORD.get(0));
    ((ShippingAdmin.SRN_Style.ShipHeadFacade)ejb).updateScRecord(si_record);
  }
  public database.datatype.Record getRecordByPk(String testSRN)
      throws database.datatype.RecordNotFoundException,java.rmi.RemoteException {
        return ejb.findBypk(testSRN);

  }

  public int hasSuchSC(String testScNo)throws Exception{
    String centerPrefixCode=newtimes.shipping_admin.ShippingAdmin_Const.getCenterPrefix(util.PublicVariable.OPERATTING_CENTER);
    return ((ShippingAdmin.SRN_Style.ShipHeadFacade)ejb).checkHasSC(testScNo,centerPrefixCode,
        util.PublicVariable.OPERATTING_CENTER);
  }
}
