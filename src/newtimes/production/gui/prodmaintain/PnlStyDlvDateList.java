package newtimes.production.gui.prodmaintain;

import util.InsertionOrderedHashMap;
import exgui.ultratable.*;
import java.util.Hashtable;
import java.util.Vector;

public class PnlStyDlvDateList extends PnlStyMiscList {
  //Group 1:orginal
  static String DISP_STY_ORG_DLV="DELIVERY";
  static String DB_STY_ORG_DLV="STY_ORIG_DEL";
  static String DISP_STY_ORG_WAY="Ship Method¡¿";
  static String DB_STY_ORG_WAY="STY_ORIG_WAY";
  //Group 2:Reconfirm
  static String DISP_STY_RCFM_DLV="DELIVERY ";
  static String DB_STY_RCFM_DLV="STY_RECFM_DEL";
  static String DISP_STY_RCFM_SHIP="Ship Method¡¿ ";
  static String DB_STY_RCFM_SHIP="STY_RECFM_SHIP";
  //Group 3:Weekly updated
  static String DISP_STY_WKLY_DLV=" DELIVERY";
  static String DB_STY_WKLY_DLV="STY_UPDT";
  static String DISP_STY_WKLY_SHIP=" Ship Method¡¿";
  static String DB_STY_WLKY_SHIP="STY_UPDT_SHIP";
  //Group 4:Off Shore
//  static String DISP_STY_OFSHR_DLV="DELIVERY  ";
//  static String DB_STY_OFSHR_DLV="STY_OFF_SHORE";
//  static String DISP_STY_OFSHR_SHIP=" ShipMethod¡¿  ";
//  static String DB_STY_OFSHR_SHIP="STY_OFF_SHORE_SHIP";

  static String DISP_STY_LC_LIST_NO="L x W x H";
  static String DB_STY_LC_LIST_NO="STY_LC_LIST_NO";
       static String DISP_STY_LC_NO="CBM";
  static String DB_STY_LC_NO="STY_LC_NO";


  static String DISP_STY_PPK="PPK";
  static String DB_STY_PPK="STY_TOP_SMPL";
  public PnlStyDlvDateList() {
  }
  protected InsertionOrderedHashMap getHeadColumnMap() {
    InsertionOrderedHashMap iso=new InsertionOrderedHashMap();

    iso.put(DISP_STY_NO,DB_STY_NO);
    iso.put(DISP_STY_PO,DB_STY_PO);
    //Group 1:orginal
    iso.put(DISP_STY_ORG_DLV,DB_STY_ORG_DLV);
    iso.put(DISP_STY_ORG_WAY,DB_STY_ORG_WAY);
    //Group 2:Reconfirm
    iso.put(DISP_STY_RCFM_DLV,DB_STY_RCFM_DLV);
    iso.put(DISP_STY_RCFM_SHIP,DB_STY_RCFM_SHIP);
    iso.put("MAKER\nDELIVERY","STY_MKR_DEL");
    //Group 3:Weekly updated
    /*
    iso.put(DISP_STY_WKLY_DLV,DB_STY_WKLY_DLV);
    iso.put(DISP_STY_WKLY_SHIP,DB_STY_WLKY_SHIP);
    */
   iso.put("CT ISSUE\nDATE","STY_VENDER_ISSUE");
   iso.put(DISP_STY_PPK,DB_STY_PPK);

    //Group 4:Off Shore
    iso.put(DISP_STY_LC_LIST_NO,DB_STY_LC_LIST_NO);
    iso.put(DISP_STY_LC_NO,DB_STY_LC_NO);



     iso.put("GSP\nRECEIVED","STY_GSP_RCVD");
     iso.put("GSP\nCOMPLETE","STY_GSP_CMPLT");
     iso.put("PPS SENT\nDATE","STY_PPS_SENT_DATE");
     iso.put("PPS APPR\nDATE","STY_PPS_APPROVAL_DATE");
     iso.put("WASH\nDATE","STY_WASH_DATE");
     iso.put("PILOT\nSMPLE-DD","STY_PILOT_SMPL");
     //iso.put("TOP\nSMPLE-DD","STY_TOP_SMPL");
     iso.put("SIZE SET\nDATE","STY_SIZE_SET");
     //iso.put("CT ISSUE\nDATE","STY_VENDER_ISSUE");
     iso.put("FTY ORI-DELDATE","STY_VENDER_ORIGINAL_DEL");
     iso.put("FTY REV-DELDATE","STY_VENDER_REVISED_DEL");
     iso.put("FTY EXPORT DATE","STY_FTY_EX_DATE");
    return iso;

  }
  protected void refineEditors(MultiEditorJTable multiEditorJTableInSuper) {
    multiEditorJTableInSuper.setTableColumn2Grp("ORIGINAL",2);
    multiEditorJTableInSuper.setTableColumn2Grp("ORIGINAL",3);
    multiEditorJTableInSuper.setTableColumn2Grp("RECONFIRM",4);
    multiEditorJTableInSuper.setTableColumn2Grp("RECONFIRM",5);

    //multiEditorJTableInSuper.setTableColumn2Grp("WEEKLY UPDATED",6);
    //multiEditorJTableInSuper.setTableColumn2Grp("WEEKLY UPDATED",7);
    //mixed with columns--Maker delivery & c/t issue date.
    try{
       Vector vctShipModes=(Vector)util.MiscFunc.deepCopy(newtimes.preproduction.guis.tempProperties.tempShipModes);
       database.datatype.Record nullRec=(database.datatype.Record)util.MiscFunc.deepCopy(vctShipModes.get(0));
       nullRec.set(0,null);nullRec.set(1,"");
       vctShipModes.add(nullRec);
       multiEditorJTableInSuper.addJComboBox(3,vctShipModes,"SHIP_MODE_NAME","SHIP_MODE_CODE");
       multiEditorJTableInSuper.addJComboBox(5,vctShipModes,"SHIP_MODE_NAME","SHIP_MODE_CODE");
  //     multiEditorJTableInSuper.addJComboBox(9+1,vctShipModes,"SHIP_MODE_NAME","SHIP_MODE_CODE");

    }catch(Exception exp){
      exp.printStackTrace();
      util.ExceptionLog.exp2File(exp,"");
    }

//    multiEditorJTableInSuper.setTableColumn2Grp("   PACKING   ",8+1);
 //   multiEditorJTableInSuper.setTableColumn2Grp("   OFF SHORE  ",9+1);
//    multiEditorJTableInSuper.setTableColumn2Grp("   PACKING   ",9+1);
    multiEditorJTableInSuper.setTextEditorVerifiers(getObject2StringConvertor());
    hookInRefineEditor(multiEditorJTableInSuper);
  }
  public class DelvChk
     implements exgui.ultratable.CellTxtEditorFormat,exgui.Object2String{
     Object dateVfy=exgui.verification.CellFormat.getDateStringFormaterAllowNull();
     Object objDlvBgn=
         newtimes.preproduction.Constants.SYSTEM_DEFAULT_RECORD.get(18);//delv_rng_bgn of system_default_value
     Object objDlvnEnd=
         newtimes.preproduction.Constants.SYSTEM_DEFAULT_RECORD.get(19);//delv_rng_bgn of system_default_value
    String prompt4Invailid;
    java.text.DateFormat df=
        new java.text.SimpleDateFormat("yyyy/MM/dd");
    public DelvChk(){
      //System.out.println("buyPlanBgn class is "+buyPlanBgn.getClass().getName());
      df.setLenient(false);
      if(objDlvBgn!=null && objDlvnEnd==null){
        prompt4Invailid="String format is yyyy/mm/dd and after "+
            df.format((java.sql.Timestamp)objDlvnEnd);
        return;
      }
      if(objDlvBgn==null && objDlvnEnd!=null){
        prompt4Invailid="String format is yyyy/mm/dd and before "+
            df.format((java.sql.Timestamp)objDlvnEnd);
        return;
      }
      if(objDlvBgn!=null && objDlvnEnd!=null){
        prompt4Invailid="String format is yyyy/mm/dd and between "+
            df.format((java.sql.Timestamp)objDlvBgn)+"~"+df.format((java.sql.Timestamp)objDlvnEnd);
        return;
      }
      prompt4Invailid="String format is yyyy/mm/dd";
    }
    public exgui.ultratable.KeyProcess getKeyListener(){
      return ((exgui.ultratable.CellTxtEditorFormat)dateVfy).getKeyListener();
    }
    public String Obj2String(Object vluObj){return ((exgui.Object2String)dateVfy).Obj2String(vluObj);}
    public Object cellStringToObject(String str){
      return ((exgui.ultratable.CellTxtEditorFormat)dateVfy).cellStringToObject(str);
    }
    public String formatPromptMsg(){
      return prompt4Invailid;
    }
    public boolean isFormatValid(String dataStr,int i,int j){
      if(dataStr==null||dataStr.trim().length()==0)return true;
      if(!((exgui.ultratable.CellTxtEditorFormat)dateVfy).isFormatValid(dataStr,i,j))
        return false;
      //test if between the system-default-value of plan delivery date need to check or not
      if(objDlvBgn==null&&objDlvnEnd==null){
        return true;
      }
      long miscSecBgn=(objDlvBgn==null)?0:((java.sql.Timestamp)objDlvBgn).getTime();
      long miscSecEnd=(objDlvnEnd==null)?0:((java.sql.Timestamp)objDlvnEnd).getTime();
      long miscPlanDel=
          ((java.util.Date)cellStringToObject(dataStr)).getTime();
      if(miscSecBgn!=0){
        if(miscPlanDel<miscSecBgn)return false;
      }
      if(miscSecEnd!=0){
        if(miscPlanDel>miscSecEnd)return false;
      }
      return true;
    }
    public int getMaxLength(){return 10;}
  }

  protected Hashtable getObject2StringConvertor() {
    Hashtable iso=new Hashtable();
    //Group 1:orginal
    Object dateCnv=new DelvChk();
    Object dateCnvNormal= exgui.verification.CellFormat.getDateStringFormaterAllowNull();
    Object char1=exgui.verification.CellFormat.getOrdinaryField(1);
    Object ppkCnv=exgui.verification.CellFormat.getIntVerifierAllowNull(4);
    Object lwhCnv=exgui.verification.CellFormat.getText_CaseSensitive(20);
    Object cbmCnv=exgui.verification.CellFormat.getText_CaseSensitive(20);
    iso.put(DISP_STY_PPK,ppkCnv);

    iso.put(DISP_STY_LC_LIST_NO,lwhCnv);
    iso.put(DISP_STY_LC_NO,cbmCnv);

    iso.put(DISP_STY_ORG_DLV,dateCnv);
    //iso.put(DISP_STY_ORG_WAY,char1);
    //Group 2:Reconfirm
    iso.put(DISP_STY_RCFM_DLV,dateCnv);
    //iso.put(DISP_STY_RCFM_SHIP,char1);
    //Group 3:Weekly updated
    iso.put(DISP_STY_WKLY_DLV,dateCnv);
    //iso.put(DISP_STY_WKLY_SHIP,char1);
    //Group 4:Off Shore
  //  iso.put(DISP_STY_OFSHR_DLV,dateCnv);
    //iso.put(DISP_STY_OFSHR_SHIP,char1);

    //iso.put("MAKER\nDELIVERY",dateCnvNormal);

    iso.put("MAKER\nDELIVERY",dateCnv);
    iso.put("GSP\nRECEIVED",dateCnvNormal);
    iso.put("GSP\nCOMPLETE",dateCnvNormal);
    iso.put("PPS SENT\nDATE",dateCnvNormal);
    iso.put("PPS APPR\nDATE",dateCnvNormal);
    iso.put("WASH\nDATE",dateCnvNormal);
    iso.put("PILOT\nSMPLE-DD",dateCnvNormal);
    //iso.put("TOP\nSMPLE-DD",dateCnvNormal);
    iso.put("SIZE SET\nDATE",dateCnvNormal);
    iso.put("CT ISSUE\nDATE",dateCnvNormal);
    iso.put("FTY ORI-DELDATE",dateCnvNormal);
    iso.put("FTY REV-DELDATE",dateCnvNormal);
    iso.put("FTY EXPORT DATE",dateCnvNormal);

    return iso;
  }

}
