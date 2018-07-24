package newtimes.material;

import exgui.ultratable.*;
import database.datatype.*;
import util.InsertionOrderedHashMap;
import java.util.Hashtable;
import java.util.HashMap;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class MtrHistListAbsPanel extends AbstractUltraTablePanel {
         static String TT_HIS_NO    = "SEQ";
         static String TT_DATE   = "Date";
         static String TT_CIF    = "Price";
         static String TT_COLOR  = "Color\nPattern";
         static String TT_O_YEAR = "Origin\nYear";
         static String TT_O_SEA  = "Origin\nSeason¡¿";
         static String TT_BUYER="Offer\nBUYER  ¡¿";
         static String TT_O_DIV  = "Origin         \nDiv       ¡¿";
         static String TT_PKG_SM = "Package\nSide Mark";
  //private static String TT_NJ     = "N/J";
         static String TT_L_BUYER     = "Lock In\nBuyer  ¡¿";
         static String TT_L_YEAR = "Lock In\nYear";
         static String TT_L_SEA  = "Lock In\nSeason¡¿";
         static String TT_L_DIV  = "Lock In      \nDiv        ¡¿";
         static String TT_L_DATE = "Lock In\nDate";
  static Hashtable obj2StrConv=null;
         newtimes.material.CONST.MTRHIST.APP.LIST MTRHIST_LIST= null;
         newtimes.material.CONST.MTRHIST.EJB MTRHIST_EJB=null;
         newtimes.material.CONST.COMMON COMMON=null;
  String userID = null;
         MtrHistDataFactory mtrHistDataSrc = null;
         static java.util.Vector divList=null;

  void initData(){
    try{
      userID = (String)(util.PublicVariable.USER_RECORD.get("USR_CODE"));
    }
    catch(Exception exp){
      exp.printStackTrace();
    }
  }
  public MtrHistListAbsPanel() {
    super();
    firstPage();
    initData();
  }

  protected Record setObject2Record(Record rec, int columnAt, Object value2update) {
    try{
      String Column[]=getStoredRecordColumns();
      rec.set(Column[columnAt],value2update);
      rec.set("RECORD_MODIFY_USER", userID);
    }catch(Exception e){
      e.printStackTrace();
    }
    finally{
      return rec;
    }

  }
  protected InsertionOrderedHashMap getHeadColumnMap() {
    util.InsertionOrderedHashMap headHm = new util.InsertionOrderedHashMap();

    //headHm.put(TT_SEQ, MTRHIST_EJB.SEQ);
    headHm.put(TT_HIS_NO, MTRHIST_EJB.HIS_NO);
    headHm.put(TT_DATE, COMMON.CREATE_DATE);
    headHm.put(TT_CIF, MTRHIST_EJB.CIF_YD);
    headHm.put(TT_COLOR, MTRHIST_EJB.COL_PTN);
    headHm.put(TT_O_YEAR, MTRHIST_EJB.ORIG_YR);
    headHm.put(TT_O_SEA, MTRHIST_EJB.ORIG_SEA);
    headHm.put(TT_O_DIV, MTRHIST_EJB.ORIG_DIV);//6
    headHm.put(TT_BUYER,"bymkr_seq");//7
    headHm.put(TT_PKG_SM, MTRHIST_EJB.PACKG_SENT);
    //headHm.put(TT_NJ, MTRHIST_EJB.NJ);
    headHm.put(TT_L_BUYER, "LOCK_IN_BYMKR_SEQ");
    headHm.put(TT_L_YEAR, MTRHIST_EJB.LOCK_YR);
    headHm.put(TT_L_SEA, MTRHIST_EJB.LOCK_SEA);
    headHm.put(TT_L_DIV, MTRHIST_EJB.LOCK_DIV);
    headHm.put(TT_L_DATE, MTRHIST_EJB.LOCK_DATE);
    return headHm;
  }
  protected void refineEditors(MultiEditorJTable multiEditorJTableInSuper) {
    try{
      /*
      String[] TT_NJ_value = {"","N", "J"};
      multiEditorJTableInSuper.addJComboBox(9, TT_NJ_value, false);
      */
      java.util.Vector seaList = exgui2.CONST.Material_EJB.getAllSeason();
      String[] seaNameList = new String[seaList.size()+1];
      seaNameList[0] = "";
      java.util.Vector vctBuyers=this.mtrHistDataSrc.getBuyers();
      for(int i=0; i<seaList.size(); i++){
        seaNameList[i+1] = (String)((Record)seaList.get(i)).get("SEA_NAME");
      }
      multiEditorJTableInSuper.addJComboBox(5,seaNameList,false);
      multiEditorJTableInSuper.addJComboBox(11,seaNameList,false);

      if(divList==null)divList = exgui2.CONST.Material_EJB.getAllDivision(util.PublicVariable.OPERATTING_CENTER);

      Record blank = (Record)util.MiscFunc.deepCopy(divList.get(0));
      blank.set("DIV_CODE", null);
      blank.set("DIV_NAME", null);
      divList.insertElementAt(blank, 0);
      multiEditorJTableInSuper.addJComboBox(6, divList, "DIV_NAME", "DIV_CODE");
      multiEditorJTableInSuper.addJComboBox(7,vctBuyers,"BYMKR_BRIEF","bymkr_seq");
      multiEditorJTableInSuper.addJComboBox(9,vctBuyers,"BYMKR_BRIEF","bymkr_seq");
      multiEditorJTableInSuper.addJComboBox(12, divList, "DIV_NAME", "DIV_CODE");
      multiEditorJTableInSuper.setTextEditorVerifiers(getObject2StringConvertor());
    }
    catch(Exception e){
      e.printStackTrace();
    }
  }
  protected int getEachPageRowCount() {
    return 14;
  }
  protected Hashtable getObject2StringConvertor() {
    if(obj2StrConv==null){
      //Object text20Field = exgui.verification.CellFormat.getOrdinaryField(20);
      Object text40Field = exgui.verification.CellFormat.getOrdinaryField(40);
      Object text7Field = exgui.verification.CellFormat.getOrdinaryField(7);
      Object text4Field = exgui.verification.CellFormat.getOrdinaryField(4);
      Object dateField = exgui.verification.CellFormat.getDateStringFormaterAllowNull();
      Object numberField = exgui.verification.CellFormat.getDoubleFormatAllowNull(7,3);

      obj2StrConv = new Hashtable();
      obj2StrConv.put(TT_CIF,numberField);
      obj2StrConv.put(TT_COLOR,text7Field);
      obj2StrConv.put(TT_O_YEAR,text4Field);
      obj2StrConv.put(TT_PKG_SM,text40Field);
      obj2StrConv.put(TT_L_YEAR,text4Field);
      obj2StrConv.put(TT_L_DATE,dateField);
    }
    return obj2StrConv;
  }
  protected PagedDataFactory getPagedDataFactory() {
    if(this.mtrHistDataSrc != null) return this.mtrHistDataSrc;
    HashMap hm = (HashMap)util.ApplicationProperites.getProperties(MTRHIST_LIST.CONDITIONS);
    MtrHistDataFactory _usrDataSrc = new MtrHistDataFactory(hm);
    this.mtrHistDataSrc = _usrDataSrc;
    return mtrHistDataSrc;
  }



}
