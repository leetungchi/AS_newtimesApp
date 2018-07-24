package newtimes;
import java.util.*;
import java.io.File;
import jxl.*;
import database.datatype.Record;
import database.datatype.*;


/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class ExcelClient {
  static String DBURL="jdbc:oracle:thin:@172.16.0.72:1521:UTF8";
  //static String DBURL="jdbc:oracle:thin:@220.130.146.128:1521:NTS1";
  static java.util.HashMap hmPo2ProdHeadRec=new java.util.HashMap();
  static java.util.HashMap hmBuyer=new java.util.HashMap();
  static java.util.HashMap hmVender=new java.util.HashMap();
  static java.util.HashMap hmMaker=new java.util.HashMap();
  static database.DatabaseX db=null;
  static database.datatype.Table tblCenter=null;
  static java.text.DateFormat df=new java.text.SimpleDateFormat("yyyy/MM/dd");
  //static java.text.NumberFormat df=new java.text.DecimalFormat("#########0.00");
  static java.util.HashMap hmCountry=new java.util.HashMap();
  static String timeMillString="12342341243";//currentTimeMillis
  static String userCode="JOHN";
  static String dtlFile;
  public ExcelClient(){
    try{
      Workbook workbook = Workbook.getWorkbook(new File("c:\\blankList.xls"));
     jxl.write.WritableWorkbook copy =
          Workbook.createWorkbook(new File("c:\\output.xls"), workbook);
     //jxl.write.WritableCell cell=copy.getSheet(1).getWritableCell(1,1);
     jxl.write.Label label = new jxl.write.Label(1, 2, "at 1,2");
     copy.getSheet(0).addCell(label);
     jxl.write.Label labe2 = new jxl.write.Label(1, 1, "at 1,1");
     copy.getSheet(0).addCell(labe2);
     /*
     ((jxl.write.Label)cell).setString("test string at 1,1");
     cell=copy.getSheet(1).getWritableCell(1,2);
     ((jxl.write.Label)cell).setString("test string at 1,2");
     */
     copy.write();
     copy.close();
    }catch(Exception exp){
      exp.printStackTrace();
    }

  }
  public void ExcelClientOrg() {
    try{

      com.csvreader.CsvReader reader = new com.csvreader.CsvReader("E:\\uploadEDI\\SC_TEST.csv");
      while(reader.readRecord()){
        String poStr=reader.get(0);
        System.out.println(poStr);
      }
      reader.close();

      util.ExceptionLog.setLogPath("C:\\newtimes_migration_error.log");
      util.SqlLog.setLogDirectory("C:\\SQLLogDirectory");
      oracle.jdbc.pool.OracleDataSource dbSrc=new oracle.jdbc.pool.OracleConnectionPoolDataSource();
      dbSrc.setURL(DBURL);
      dbSrc.setPassword("newtimes");
      dbSrc.setUser("newtimes");
      db=new database.DatabaseX(dbSrc,new database.encoders.OracleEncoder());
      tblCenter=new database.datatype.CommonTable("center",db,"cen_code");

      Vector buyers=tblCenter.SQL2Records("select * from buyer_maker where SELECTABLE_CENTER like '%,NTD,%'");
      Vector countries=tblCenter.SQL2Records("select * from country");
      for(int i=0;i<countries.size();i++){
        Record recCnty=(Record)countries.get(i);
        hmCountry.put(recCnty.get("CNTY_DATE"),recCnty);
      }
      for(int i=0;i<buyers.size();i++){
        Record rec=(Record)buyers.get(i);
        if(((String)rec.get("BYMKR_MULTI_TYPE")).indexOf(",1,")!=-1){
          if(null!=rec.get("BYMKR_HK_CODE"))
            hmBuyer.put(rec.get("BYMKR_HK_CODE"),rec);
          else
            hmBuyer.put(rec.get("BYMKR_BRIEF"),rec);
        }
        if(((String)rec.get("BYMKR_MULTI_TYPE")).indexOf(",2,")!=-1){
          if(null!=rec.get("BYMKR_HK_CODE"))
            hmMaker.put(rec.get("BYMKR_HK_CODE"),rec);
          else
            hmMaker.put(rec.get("BYMKR_BRIEF"),rec);
        }

        if(((String)rec.get("BYMKR_MULTI_TYPE")).indexOf(",13,")!=-1){
          if(null!=rec.get("BYMKR_HK_CODE"))
            hmVender.put(rec.get("BYMKR_HK_CODE"),rec);
          else
            hmVender.put(rec.get("BYMKR_BRIEF"),rec);
        }

        }

     /*
     Record recProd=(Record)tblCenter.SQL2Records("select * from production where prod_head_pk=79414").get(0);
     Record recStyle=(Record)tblCenter.SQL2Records("select * from Style where prod_head_pk=79414").get(0);
     String strTxt=generateSC_DOWN_RMK(recProd,recStyle,false,false,new HashMap());
     System.out.println(strTxt);
      */
    }catch(Exception exp){
      exp.printStackTrace();
    }
  }

  public static void main(String[] args) {
    ExcelClient excelClient1 = new ExcelClient();
  }
  public static String getYearFromStyle(String _poStr)throws Exception{
      com.csvreader.CsvReader reader = new com.csvreader.CsvReader(dtlFile);
      while(reader.readRecord()){
        String poStr=reader.get(0);
        if(poStr.equals(_poStr)){
          String dlvDate=reader.get(3);
          reader.close();
          return util.MiscFunc.split(dlvDate,"/")[0];

        }else continue;
      }
      reader.close();
      throw new Exception("PO:\""+_poStr+"\" not found in detail file,Can not get PROD-Year field of new PO");
  }
  public static void handleScHead(String scFile)throws Exception{

    com.csvreader.CsvReader reader = new com.csvreader.CsvReader(scFile);
    newtimesejb.preproduction.PreProductionHeadHome ejbPreprodHome=
        (newtimesejb.preproduction.PreProductionHeadHome)
        info_ejb.WeblogicServiceLocator.locateServiceHome("172.16.0.72","newtimesejb.preproduction.PreProductionHead");
    newtimesejb.preproduction.PreProductionHead ejbPreprodHead=ejbPreprodHome.create();
    //info_ejb.WeblogicServiceLocator.getInitialContext("t3://127.0.0.1:7001").lookup("ProgHandler");
    reader.readHeaders();
    while (reader.readRecord()) {
      String poStr=reader.get(0);
      StringBuffer sbSql=new StringBuffer();
      sbSql.append("select a.prod_head_pk  ");
      sbSql.append("from production a,prod_head b ");
      sbSql.append("where A.PROD_HEAD_PK=b.prod_head_pk ");
      sbSql.append("and a.record_delete_flag='1' and b.record_delete_flag='1' ");
      sbSql.append("and B.PROD_CEN_CODE='NTD' ");
      sbSql.append("and a.prod_byr_sc_no='");
      sbSql.append(poStr);
      sbSql.append("'");

      Vector vctTest=tblCenter.SQL2Records(sbSql.toString());
      Record recProduction=null;
      int prodHeadPk=-1;
      if(vctTest.size()==0){
        recProduction=ejbPreprodHead.getBlankRecord();
        recProduction.set(0,prodHeadPk);
      }else{
        prodHeadPk=((Record)vctTest.get(0)).getInt(0);
        recProduction=ejbPreprodHead.findByPk(prodHeadPk);
      }
      recProduction.getFieldName().add("PRODUCTION_SC_HEAD_RMRK");
      recProduction.getValueFields().add(null);

      recProduction.set("PRODUCTION_BYR_SC_NO",poStr);
      String buyerCode=reader.get(5);
      Record recBuyer=(Record)hmBuyer.get(buyerCode);
      if(null==recBuyer){
        exgui.verification.VerifyLib.showAlert("NO Buyer found for code \""+buyerCode+"\"","NO buyer found");
        throw new Exception("NO Buyer found for code \""+buyerCode+"\"");
      }
      recProduction.set("prod_buyer",recBuyer.get(0));
      recProduction.set("PROD_OFFSHORE_CENTER","NTD");
      recProduction.set("PROD_CENTER","NTD");


      String depCode=reader.get(3);
      if(depCode==null||depCode.trim().equals(""))depCode=reader.get(2);
      if(depCode==null||depCode.trim().equals(""))depCode=reader.get(1);
      if(null==depCode||depCode.trim().length()==0)
        depCode="DB";
       else
        depCode="D"+depCode;

      recProduction.set("PROD_DEPTMENT",depCode);
      recProduction.set("PROD_MNG_CODE","None Manager");
      String sznStr=reader.get(4);
      if(sznStr.trim().length()==0)sznStr=".";
      //PROD_YEAR field,is from the year of delivery field of 1st style record.
      if(null==recProduction.get("PROD_YEAR")){
        recProduction.set("PROD_YEAR",getYearFromStyle(poStr));
      }
      recProduction.set("PROD_SEASON",sznStr);//hear field,left untill dlv date of style determed
      //type object.
      recProduction.set("PRODUCTION_TYPE","A");//type is always accesory
      //store BUnit_Desc
      String typeBrf=reader.get(6);
      String typeName=reader.get(7);
      String typeFullName=((typeBrf==null||typeBrf.trim().length()==0)?(typeName):(typeBrf+"("+typeName+")"));
      recProduction.set("PROD_GROUP",typeFullName);
      recProduction.set("PRODUCTION_LABEL",reader.get(8));
      recProduction.set("PRODUCTION_BRNCH_BRIEF","NTD");
      recProduction.set("PRODUCTION_QC_CNTY",((String)reader.get(9)).toUpperCase());
      //note,the "PRODUCTION_BYR_PLAN_DEL" is delivery date of style.
      recProduction.set("PRODUCTION_BYR_PLAN_DEL",new java.sql.Date(System.currentTimeMillis()));
      recProduction.set("PROduction_SC_PRC_TRM",reader.get(10));
      recProduction.set("PRODUCTION_SC_CURRENCY",reader.get(17));
      String strScDest=reader.get(11);
      if(strScDest.trim().length()>20)strScDest=strScDest.substring(0,20);
      recProduction.set("PRODUCTION_SC_DEST",strScDest);
      //find out isscue date
      recProduction.set("PRODUCTION_BYR_SC_ISSUE",df.parse(reader.get(18)));
      //good dest.
      String goodDest=reader.get(12);
      if(goodDest==null)goodDest="";
      if(goodDest.indexOf(",")==-1){
        recProduction.set("PRODUCTION_TGT_DEST",goodDest);
      }else{
        String cntyCodes[]=util.MiscFunc.split(goodDest,",");
        String cntyCode=cntyCodes[cntyCodes.length-1].trim();
        if(cntyCode.equals("SP"))cntyCode="ES";//for current system,the CODE "SP" is for Saipen,but for Global system,is spain
        Record rec=(Record)hmCountry.get(cntyCode);
        if(null==rec){
          recProduction.set("PRODUCTION_TGT_DEST",cntyCode);
        }else{
          recProduction.set("PRODUCTION_TGT_DEST",rec.get("CNTY_NAME"));
        }

      }
      //sc payment term
      recProduction.set("PRODUCTION_PYT_TRM",reader.get(10));
      //get PROD_SC_HEAD_RMRK
      String upRemark=reader.get(19);
      recProduction.set("PRODUCTION_SC_HEAD_RMRK",upRemark);
      //when every thing ready ,set into database
      if(recProduction.getInt(0)<1)recProduction.set("RECORD_CREATE_USER",userCode);
      recProduction.set("RECORD_MODIFY_USER",userCode);
      recProduction=ejbPreprodHead.handlePreproductionAndHead4NTHK(recProduction,null);
      hmPo2ProdHeadRec.put(poStr,recProduction);
    }
    reader.close();
  }
  public static void handleCtHead(String ctFile)throws Exception{
    com.csvreader.CsvReader reader = new com.csvreader.CsvReader(ctFile);
    reader.readHeaders();
    AutoIncInterface tblBuyerMaker=null;
    newtimesejb.production.NTHK_CT_FacadeHome  ejbCtHome=
        (newtimesejb.production.NTHK_CT_FacadeHome)
        info_ejb.WeblogicServiceLocator.locateServiceHome("172.16.0.72","newtimesejb.production.NTHK_CT_Facade");
    newtimesejb.production.NTHK_CT_Facade ejbCt=ejbCtHome.create();

    while (reader.readRecord()) {
       String poStr=reader.get(0);
       Record recPdxn=(Record)hmPo2ProdHeadRec.get(poStr);
       if(null==recPdxn){
         exgui.verification.VerifyLib.showAlert("PO:\""+poStr+"\" Not Found in S/C head.csv conversion process\nPlease check csv file",
                             "PO not Found in SC_HEAD.csv");

         throw new Exception("PO:\""+poStr+"\" Not Found in S/C head.csv conversion process\nPlease check csv file");
       }
       //since we have to update some additional maker infor in prod-head,have to query ct as GUI does.
       StringBuffer sb=new StringBuffer();
         sb.append("select ");
         sb.append("a.PROD_HEAD_PK ,");//0
         sb.append("a.PROD_MAKER ,");//1
         sb.append("a.PROD_SC_NO ,");//2
         sb.append("a.PROD_CT_SEQ,");//3
         sb.append("a.PROD_CT_CURRENCY,");//4
         sb.append("a.PROD_CT_PRX_TRM,");//5
         sb.append("a.PROD_CT_PORT,");//6
         sb.append("a.PROD_CT_ISSU,");//7
         sb.append("a.PROD_CT_PYT_TRM,");//8
         sb.append("a.RECORD_CREATE_USER,");//9
         sb.append("a.RECORD_CREATE_DATE,");//10
         sb.append("a.RECORD_DELETE_FLAG,");//11
         sb.append("a.RECORD_DELETE_DATE,");//12
         sb.append("a.RECORD_DELETE_USER,");//13
         sb.append("a.RECORD_MODIFY_DATE,");//14
         sb.append("a.RECORD_MODIFY_USER,");//15
         sb.append("a.PROD_CNTY         ,");//16
         sb.append("a.PROD_CITY         ,");//17
       sb.append("nvl(b.BYMKR_HK_CODE,b.BYMKR_BRIEF) as maker_code,");//18
       sb.append("'...' as dots,'0' as is_maker_changed,");//19,20
       sb.append("b.BYMKR_NAME,b.BYMKR_ADDR1,b.BYMKR_ADDR2, ");//21 //22 //23
       sb.append("b.BYMKR_ADDR3,b.BYMKR_ADDR4");//24//25
         sb.append(",0 as shipped_count "); //26
       //add fields for NTHK vender and bank collection.
       sb.append(",a.VENDER_SEQ        ");//27
       sb.append(",a.COLLECT_BANK      ");//28
       sb.append(",a.BANK_ADD1         ");//29
       sb.append(",a.BANK_ADD2         ");//30
       sb.append(",a.SWIFT             ");//31
       sb.append(",a.COLLECT_BY        ");//32
       sb.append(",a.ACC_NO            ");//33
       sb.append(",nvl(d.BYMKR_HK_CODE,d.BYMKR_BRIEF) as vendor_code ");//34
       sb.append(",'...' as dots4vendor");//35
       sb.append(",'0' as is_vendor_changed ");//36
       sb.append(", e.prod_year ");//37
       sb.append(",d.BYMKR_NAME  as VDR_NAME  ,d.BYMKR_ADDR1 as VDR_ADDR1 ,d.BYMKR_ADDR2 as VDR_ADDR2, ");//38~40
       sb.append("d.BYMKR_ADDR3 as VDR_ADDR3 ,d.BYMKR_ADDR4 as VDR_ADDR4 ");//41 & 42
       sb.append(" from prod_ct_infor a,buyer_maker b ,production c, buyer_maker d,prod_head e  where ");
       sb.append(" a.prod_head_pk=e.prod_head_pk  ");
       sb.append(" and a.prod_head_pk=c.prod_head_pk  ");
       sb.append(" and a.PROD_MAKER=b.BYMKR_SEQ(+) ");
       sb.append(" and a.VENDER_SEQ=d.BYMKR_SEQ(+) ");
       sb.append(" and a.record_delete_flag='1' and a.prod_head_pk=");
       sb.append(String.valueOf(recPdxn.getInt(0)));
       sb.append(" order by prod_ct_seq ");
       Record recCtHead=(Record)tblCenter.SQL2Records(sb.toString()).get(0);

       //find out vender if exits or not .
       String venderCode=reader.get(1);
       Record recVndr=(Record)hmVender.get(venderCode);
       if(null==recVndr){
         recVndr=(Record)hmMaker.get(venderCode);
       }
       //if this is new vender data,add into database.
       if(null==recVndr){
        Record maker=(Record)hmMaker.get("00000066");
        Record recNewVndr=tblBuyerMaker.newRecord();
        for(int i=0;i<maker.getFieldName().size();i++){
          recNewVndr.set(i,maker.get(i));
        }
        recNewVndr.set("BYMKR_HK_CODE",venderCode);
        recNewVndr.set("BYMKR_BRIEF",venderCode);
        String vdnrName=reader.get(2).trim();
        if(vdnrName.length()>60)vdnrName=vdnrName.substring(0,60);
        recNewVndr.set("BYMKR_NAME",vdnrName);
        long seq=tblBuyerMaker.insertRecord(recNewVndr,"BYMKR_SEQ");
        recVndr=tblBuyerMaker.findRecordByPk(seq);
        hmMaker.put(venderCode,recVndr);
       }
       int seq=recVndr.getInt(0);
       recCtHead.set(1,seq);
       recCtHead.set(27,seq);
       String addLine=reader.get(3)+reader.get(4);
       String addLine2=reader.get(5)+reader.get(6);
       if(reader.get(6).trim().length()==0){
         addLine=reader.get(3);
         addLine2=reader.get(4)+reader.get(5);
       }else{
          addLine=reader.get(3)+reader.get(4);
          addLine2=reader.get(5)+reader.get(6);
       }
       //set to address of vender
       recCtHead.set(29,addLine);
       recCtHead.set(30,addLine2);
       /*how to deal with address ? to maker data or vender of CT head?*/

       recCtHead.set("PROD_CT_CURRENCY",recPdxn.get("PRODUCTION_SC_CURRENCY"));
       recCtHead.set("PROD_CT_ISSU",recPdxn.get("PRODUCTION_BYR_SC_ISSUE"));//CSV RCV DATE

       recCtHead.set("RECORD_MODIFY_USER",userCode);
       ejbCt.updateRecord(recCtHead);

    }
     reader.close();
  }
  public static Record genStyleRecord(String[] styColArr)throws Exception{
    //find out the style list of co-responding s/c
    Record recProduction=(Record)hmPo2ProdHeadRec.get(styColArr[0]);
    String scNO=(String)recProduction.get("PRODUCTION_SC_NO");
    StringBuffer sql=new StringBuffer();
    sql.append("select * from style where sty_sc_no='");
    sql.append(scNO);sql.append("' and record_delete_flag='1' and sty_img is not null and sty_img<>'");
    sql.append(timeMillString);
    sql.append("'");
    Vector vctStyle=tblCenter.SQL2Records(sql.toString());
    TableInterface tblStyle=null;
    Record recStyleNew=null;
    boolean isNewRec=false;
    if(vctStyle.size()==0){
      recStyleNew=tblStyle.newRecord();
      recStyleNew.set("RECORD_CREATE_USER",userCode);
      recStyleNew.set(1,recProduction.getInt(0));//prod_head_pk
      isNewRec=true;
    }else{
      recStyleNew = (Record)vctStyle.get(0);
    }
    /*
    newtimesejb.singletons.StyleNoFactoryHome  styNoHome =(newtimesejb.singletons.StyleNoFactoryHome)
      info_ejb.WeblogicServiceLocator.getInitialContext("t3://"+seqGenIp+":7001").lookup("StyleNoFactory");
      newtimesejb.singletons.StyleNoFactory styNofty = styNoHome.create();
    */
   newtimesejb.singletons.StyleNoFactoryHome  styNoHome=
       (newtimesejb.singletons.StyleNoFactoryHome)
       info_ejb.WeblogicServiceLocator.locateServiceHome("172.16.0.72","StyleNoFactory");
   newtimesejb.singletons.StyleNoFactory styNofty=styNoHome.create();


     recStyleNew.set("sty_no",styNofty.getStyleNo(recProduction.getInt(0)));

    recStyleNew.set("STY_UNIT","PC");
    recStyleNew.set("STY_CT_PRC_TRM",recProduction.get("PRODUCTION_SC_PRC_TRM"));
    recStyleNew.set("STY_CT_DEST",recProduction.get("PRODUCTION_SC_DEST"));
    recStyleNew.set("STY_CT_CURRENCY","USD");
    recStyleNew.set("record_modify_date",new java.sql.Date(System.currentTimeMillis()) );
    recStyleNew.set("STY_PO",styColArr[0]);
    recStyleNew.set("STY_STYLE",styColArr[1]);
    recStyleNew.set(7,styColArr[2]);//org ship mode
    recStyleNew.set(6,df.parse(styColArr[3]));//org dlv date
    recStyleNew.set("STY_MKR_DEL",df.parse(styColArr[4]));//maker dlv date
    recStyleNew.set("STY_IMG",timeMillString);
    recStyleNew.set("RECORD_MODIFY_USER",userCode);
    recStyleNew.set("STY_SC_UP_RMRK",styColArr[5]);
    recStyleNew.set("STY_SIZE_COLUMN",styColArr[6]);
    if(isNewRec)
      tblStyle.insertRecord(recStyleNew);
    else
      tblStyle.updateRecord(recStyleNew);
    return recStyleNew;
    //Vector vctStyle="select * from style where sty_sc_no='"+scNo+"'"
  }
  public static void clearStyle(String po)throws Exception{
    Record recProduction=(Record)hmPo2ProdHeadRec.get(po);
    StringBuffer sb=new StringBuffer("delete from style where sty_sc_no='");
    sb.append((String)recProduction.get("production_sc_no"));
    sb.append("' and record_delete_flag='1' and ");
    sb.append(" sty_img is not null and ");
    sb.append(" sty_img <>'");
    sb.append(timeMillString);
    sb.append("'");
    tblCenter.exeSQL(sb.toString());
  }

  public static void   handleBriefQty2TableRecord(Vector vctBrfQty,Vector vctPcixBoard)throws Exception{
    //revers the sequce of brf qty,cause is ninuse sequenced
    TableInterface tblBrfQty=null;
    int sty_Seq=0;
    for(int i=0;i<vctBrfQty.size();i++){
      Record recBrfQty=(Record)vctBrfQty.get(i);
      if(sty_Seq==0)sty_Seq=recBrfQty.getInt(1);
      if(null==recBrfQty.get(0)){
        tblBrfQty.insertRecord(recBrfQty);
      }else{
        tblBrfQty.updateRecord(recBrfQty);
      }
    }
    //doUpdateToQtyTable(sty_Seq);
    //update to qty/price/color
  }

  public static void handleStyleAndBrfQty(String[] styColArr,Vector vctBrifQty)throws Exception{
    //split color reords by diff price if even same color name.
    String lastByrDocPrx="";
    String lastByrActPrx="";
    String lastMkrDocPrx="";
    String lastMkrActPrx="";
    String lastColorName="";
    TableInterface tblBrfQty=null;
    if(vctBrifQty.size()==0) return;
    String[] brfQtyRow=(String[])vctBrifQty.get(0);
    lastByrDocPrx=brfQtyRow[6-5];
    lastByrActPrx=brfQtyRow[7-5];
    lastMkrDocPrx=brfQtyRow[8-5];
    lastMkrActPrx=brfQtyRow[9-5];
    lastColorName=brfQtyRow[11-5];

    // size string is like "S,,M,,L,,XL,,XXL",saperated by dobule camma
    //fristly,find out the size list
    util.InsertionOrderedHashMap iso=new util.InsertionOrderedHashMap();
    java.util.Vector vctBrfQtyResult=new java.util.Vector();
    java.util.Vector vctPcixBoard=new java.util.Vector();
    StringBuffer sbSizeCamaList=new StringBuffer();
    for(int i=0;i<vctBrifQty.size();i++){
      brfQtyRow=(String[])vctBrifQty.get(i);
      String sizeStr=brfQtyRow[5-5];
      if(iso.containsKey(sizeStr))continue;
      iso.put(sizeStr,String.valueOf(iso.entrySet().size()));
      if(sbSizeCamaList.length()>0)sbSizeCamaList.append(",,");
      sbSizeCamaList.append(sizeStr);
    }
    styColArr[6]=sbSizeCamaList.toString();
    Record recStyle=genStyleRecord(styColArr);
    int sty_seq=recStyle.getInt(0);
    String poStr=(String)recStyle.get("STY_PO");
    String styleStr=(String)recStyle.get("STY_STYLE");

    if(iso.entrySet().size()>14){
      exgui.verification.VerifyLib.showAlert("PO:\""+poStr+"\" STYLE:\""+styleStr+"\" Contains More than 14 Size Column\nPlease Split it into 2 Style Records",
                          "Size List More Than 14 items");

      throw new Exception("PO:\""+poStr+"\" STYLE:\""+styleStr+"\" Contains More than 14 Size ");
    }
     Vector orgBrfQty=tblCenter.SQL2Records("select * from BRIEF_QTY where STY_PK="+sty_seq+" order by BRF_QTY_PK Desc");
     Record recBrfQty=(orgBrfQty.size()>0)?(Record)orgBrfQty.remove(0):tblBrfQty.newRecord();
     recBrfQty.set(1,sty_seq);
     boolean otherFieldInited=false;
     Record tempPcixBoardRecord=(Record)util.MiscFunc.deepCopy(recBrfQty);
     tempPcixBoardRecord.getFieldName().clear();
     tempPcixBoardRecord.getValueFields().clear();
     tempPcixBoardRecord.getFieldName().add("PCIX");
     tempPcixBoardRecord.getValueFields().add(null);
     tempPcixBoardRecord.getFieldName().add("BOARD");
     tempPcixBoardRecord.getValueFields().add(null);
     tempPcixBoardRecord.getModifiedFields().clear();

    for(int i=0;i<vctBrifQty.size();i++){
      brfQtyRow=(String[])vctBrifQty.get(i);
      String sizeStr=brfQtyRow[6-6];
      String xntByrDocPrx=brfQtyRow[7-6];
      String xntByrActPrx=brfQtyRow[8-6];
      String xntMkrDocPrx=brfQtyRow[9-6];
      String xntMkrActPrx=brfQtyRow[10-6];

      String xntColorCode=brfQtyRow[11-6];
      String xntColorName=brfQtyRow[12-6];
      if(xntColorCode.trim().length()==0)xntColorCode=xntColorName.substring(0,3);
      String pcixStr =brfQtyRow[13-6];
      String boardStr=brfQtyRow[14-6];
      String qtyStr=brfQtyRow[15-6];

      if((!xntByrDocPrx.equals(lastByrDocPrx))||(!xntByrActPrx.equals(lastByrActPrx))||
         (!xntMkrDocPrx.equals(lastMkrDocPrx))||(!xntMkrActPrx.equals(lastMkrActPrx))||
         (!xntColorName.equals(lastColorName))){
        //this is new price/color record.
        //handleBriefQtyRecord(recBrfQty);

        vctBrfQtyResult.add(recBrfQty);
        vctPcixBoard.add(tempPcixBoardRecord);

        recBrfQty=(orgBrfQty.size()>0)?(Record)orgBrfQty.remove(0):tblBrfQty.newRecord();
        tempPcixBoardRecord=(Record)util.MiscFunc.deepCopy(tempPcixBoardRecord);
        tempPcixBoardRecord.getModifiedFields().clear();

        recBrfQty.set(1,sty_seq);
        otherFieldInited=false;

        lastByrDocPrx=xntByrDocPrx;
        lastByrActPrx=xntByrActPrx;
        lastMkrDocPrx=xntMkrDocPrx;
        lastMkrActPrx=xntMkrActPrx;
        lastColorName=xntColorName;
        if(xntColorCode.trim().length()==0)xntColorCode=xntColorName.substring(0,3);
      }


      if(!otherFieldInited){
        //recBrfQty.set("PCIX",pcixStr);
        //recBrfQty.set("BOARD",boardStr);
        tempPcixBoardRecord.set("PCIX",pcixStr);
        tempPcixBoardRecord.set("BOARD",boardStr);
        recBrfQty.set("COLOR_CODE",xntColorCode);
        recBrfQty.set("COLOR_NAME",xntColorName);
        recBrfQty.set("BYR_ACT_PRX",xntByrActPrx);
        recBrfQty.set("BYR_DOC_PRX",xntByrDocPrx);
        recBrfQty.set("MKR_ACT_PRX",xntMkrActPrx);
        recBrfQty.set("MKR_DOC_PRX",xntMkrDocPrx);
        otherFieldInited=true;
      }
      //find out the cell index in the BriefQty record
      int cellIndex=Integer.parseInt(iso.get(sizeStr).toString());
      recBrfQty.set(cellIndex+8,qtyStr);
    }
    vctBrfQtyResult.add(recBrfQty);
    vctPcixBoard.add(tempPcixBoardRecord);
    handleBriefQty2TableRecord(vctBrfQtyResult,vctPcixBoard);
    //clear un-needed brief qty
    for(int i=0;i<orgBrfQty.size();i++){
      Record recbrfQty=(Record)orgBrfQty.get(i);
      tblCenter.exeSQL("delete from BRIEF_QTY where BRF_QTY_PK="+recbrfQty.getInt(0));
    }
  }
  public static void handleStyles(String dtlFile)throws Exception{
    com.csvreader.CsvReader reader = new com.csvreader.CsvReader(dtlFile);
    reader.readHeaders();
    //PO,style,Shipmode,DLVdate,MkrDlv,Upremark,sizeCamaList
    String strStyle[]=new String[]{"","","","","","",""};//last field,to store the size-column-with camma
    Vector vctBrifQtyRows=new Vector();
    int row=0;
    String lastPo="",lastStyle="",lastDlvDate="",lastMkrDlv="",lastShipMode="";
    String xntPo,xntStyle,xntDlvDate,xntMkrDlv,xntShipMode;//actuall,Dlvdate always same as mkr dlv date.
    while (reader.readRecord()) {
     //detail item,is distinguish by po & style & DLV date
      xntPo=reader.get(0);xntStyle=reader.get(1);xntShipMode=reader.get(2);xntDlvDate=reader.get(3);xntMkrDlv=reader.get(4);
      if(0==row){
        lastPo=xntPo;lastStyle=xntStyle;lastDlvDate=xntDlvDate;lastMkrDlv=xntMkrDlv;
        lastShipMode=xntShipMode;
        strStyle[0]=lastPo;strStyle[1]=lastStyle;strStyle[3]=lastDlvDate;strStyle[4]=lastMkrDlv;
        strStyle[2]=lastShipMode;
        strStyle[5]=reader.get(5);//remark
      }
      if((!xntPo.equals(lastPo))||(!xntStyle.equals(lastStyle))||
         (!xntDlvDate.equals(lastDlvDate))||(!xntMkrDlv.equals(lastMkrDlv))||
         (!xntShipMode.equals(lastShipMode))){
         handleStyleAndBrfQty(strStyle,vctBrifQtyRows);
         if(!lastPo.equals("") && (!xntPo.equals(lastPo))){
            clearStyle(lastPo);
         }
         lastPo=xntPo;lastStyle=xntStyle;lastDlvDate=xntDlvDate;xntMkrDlv=lastMkrDlv;
         lastShipMode=xntShipMode;
         strStyle[0]=lastPo;strStyle[1]=lastStyle;strStyle[2]=lastShipMode;strStyle[3]=lastDlvDate;strStyle[4]=lastMkrDlv;
         strStyle[5]=reader.get(5);//remark
         vctBrifQtyRows.clear();
      }
      String colorPrxBrkDown[]=new String[10];
      for(int i=0;i<10;i++){
        colorPrxBrkDown[i]=reader.get(i+6);
      }
      vctBrifQtyRows.add(colorPrxBrkDown);
      row++;
    }
    //last un-handled qtys,have to be finished
    if(vctBrifQtyRows.size()>0){
      handleStyleAndBrfQty(strStyle,vctBrifQtyRows);
      clearStyle(lastPo);
    }
    reader.close();
  }

}
