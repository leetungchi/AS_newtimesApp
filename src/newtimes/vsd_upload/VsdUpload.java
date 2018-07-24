package newtimes.vsd_upload;
import java.util.*;
import database.datatype.*;
import VsdCsvObject.*;
/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class VsdUpload {
  Vector vctVsdRec=null;
  //database.datatype.TableInterface tblBrfQty;
  Record blankBriefQtyRec=null;
  java.text.DateFormat df=new java.text.SimpleDateFormat("yyyy/MM/dd HH:mm");
  java.text.DateFormat db_df=new java.text.SimpleDateFormat("yyyy/MM/dd");
  java.util.HashMap hmPoProdHeadPk=new java.util.HashMap();//key is PO,value is prod heasd pk
  java.util.HashMap hmOrgStyleAndPo=new java.util.HashMap();
  java.util.HashMap hmShipWays=new java.util.HashMap();
   //NTD_Upload.VsdUpload ejbUpload=null;
   DlgUpload dlgUpload=null;
   boolean is2OverWrite=false;
   VsdCsvObject.LineNoObj xntPrcVsdObjLineObj;
   VsdCsvObject.VSD_Rec_Unit xntPrcVsdObj;
   java.util.Vector vctVSD2uploadAndGetResult=null;
   String opTime;
  public VsdUpload() {
    //gether all PO of VSD
    /*
    try{
      blankBriefQtyRec=exgui2.CONST.BASIC_MAIN_EJB.getBlankRecord("BRIEF_QTY_tbl");
      NTD_Upload.VsdUploadHome ejbHome =
          (NTD_Upload.VsdUploadHome)
          info_ejb.WeblogicServiceLocator.locateServiceHome(util.PublicVariable.
          SERVER_URL, "NTD_Upload.VsdUpload");
      ejbUpload=ejbHome.create();

    }catch(Exception exp){
      exp.printStackTrace();
      util.ExceptionLog.exp2File(exp,"");
      ejbUpload=null;
      exgui.verification.VerifyLib.showAlert("VSD upload Handler Initiate Failed\nPlease Contact System Manager",
                                             "VSD upload Handler Initiate Failed");
    }
    */
  }
  Hashtable htThreads2Upload=null;
  class ThreadUpload implements java.lang.Runnable{
    String msId;
    VSD_Rec_Unit vsdObj;
    ThreadUpload(VSD_Rec_Unit _vsdObj){
      vsdObj=_vsdObj;
      msId=String.valueOf(System.currentTimeMillis());
      if(htThreads2Upload.containsKey(msId)){
        msId= String.valueOf ((Long.parseLong(msId))*-1);
      }
      htThreads2Upload.put(msId,vsdObj);
    }
    public void run(){
      try{
        NTD_Upload.VsdUploadHome ejbHome =
            (NTD_Upload.VsdUploadHome)
            info_ejb.WeblogicServiceLocator.locateServiceHome(util.PublicVariable.
            SERVER_URL, "NTD_Upload.VsdUpload");
        NTD_Upload.VsdUpload ejb=ejbHome.create();
        ejb.insertIntoTemp(vsdObj,opTime,(String)util.PublicVariable.USER_RECORD.get(0));
        htThreads2Upload.remove(msId);
      }catch(Exception exp){
        exp.printStackTrace();
      }
    }
  }

  public void startCsvUpload(String file){
    if(!this.readCSV(file))return;
    try{
      htThreads2Upload=new Hashtable();
      java.text.SimpleDateFormat sdf=new java.text.SimpleDateFormat("yyyyMMdd-HHmm");
      opTime= sdf.format(new java.sql.Date(System.currentTimeMillis()));
      vctVSD2uploadAndGetResult=new java.util.Vector();
      for (int i = 0; i < vctVsdRec.size(); i++) {
        util.MiscFunc.showProcessingMessage();
        VsdCsvObject.VSD_Rec_Unit vsdObj = (VsdCsvObject.VSD_Rec_Unit)vctVsdRec.get(i);
        compareStyleAndUpload(vsdObj);
      }
      dlgUpload.txtMsg.append(" Wait for Last Temp VSD upload\n");
      while(!htThreads2Upload.isEmpty()){
        try{
          Thread.currentThread().sleep(100);
        }catch(java.lang.InterruptedException ie){
        }
      }
      dlgUpload.txtMsg.setText("Wait for getting diff report\n");
      util.MiscFunc.showProcessingMessage();
      NTD_Upload.VsdUploadHome ejbHome =
          (NTD_Upload.VsdUploadHome)
          info_ejb.WeblogicServiceLocator.locateServiceHome(util.PublicVariable.
          SERVER_URL, "NTD_Upload.VsdUpload");
      NTD_Upload.VsdUpload ejb=ejbHome.create();
      byte[] data2save4Ins= ejb.genNewScPoReport(opTime);
      String fileNameIns="c:\\"+opTime+"_VSD_INSERT.xls";
      java.io.File fileOutIns=new java.io.File(fileNameIns);
      if(fileOutIns.exists())fileOutIns.delete();
      java.io.FileOutputStream foIns=new java.io.FileOutputStream(fileOutIns);
      foIns.write(data2save4Ins);
      foIns.close();

      NTD_Upload.VsdUploadHome ejbHomeCmp =
          (NTD_Upload.VsdUploadHome)
          info_ejb.WeblogicServiceLocator.locateServiceHome(util.PublicVariable.
          SERVER_URL, "NTD_Upload.VsdUpload");
      NTD_Upload.VsdUpload ejbCmp=ejbHomeCmp.create();


      byte[] data2save=ejbCmp.getCompareResult(opTime,util.PublicVariable.USER_RECORD.get(0).toString());
        //write to  c:\\
        String fileName="c:\\"+opTime+"_VSD_DIFF.xls";
        java.io.File fileOut=new java.io.File(fileName);
        if(fileOut.exists())fileOut.delete();
        java.io.FileOutputStream fo=new java.io.FileOutputStream(fileOut);
        fo.write(data2save);
        fo.close();

        StringBuffer msg4PlanMsg=new StringBuffer();
        msg4PlanMsg.append("Upload Finished,please check:\n");
        msg4PlanMsg.append(fileNameIns);msg4PlanMsg.append("\n");
        msg4PlanMsg.append(fileName);msg4PlanMsg.append("\n");
        msg4PlanMsg.append(" for upload result");

        exgui.verification.VerifyLib.showPlanMsg(msg4PlanMsg.toString(),"Upload Finished");
        dlgUpload.txtMsg.append(" DONE!!\n");

    }catch(Exception exp){
      exp.printStackTrace();
      util.ExceptionLog.exp2File(exp,"");
      vctVsdRec=null;
      exgui.verification.VerifyLib.showAlert("Upload Error,Please Check Log and Notify System Manager",
                                             "Upload Error");
    }finally{
      util.MiscFunc.hideProcessingMessage();
    }
  }
  public void compareStyleAndUpload(VsdCsvObject.VSD_Rec_Unit vsdObj)throws Exception {
    StringBuffer sbSql=new StringBuffer();

    sbSql.append("select ");
    sbSql.append("a.sty_seq,a.sty_style ");
    sbSql.append(",a.sty_po,a.sty_orig_del ");
    sbSql.append(",a.sty_mkr_del,a.sty_orig_way ");
    sbSql.append(",(select SHIP_MODE_NAME from ship_modes where ship_mode_code=a.sty_orig_way ) as ship_mode ");
    sbSql.append(",a.STY_SC_UP_RMRK ");
    sbSql.append(",B.PROD_BYR_SC_ISSUE as sc_issue ");
    sbSql.append(",D.PROD_CT_ISSU as ct_issue ");
    sbSql.append(",a.record_create_date ");
    sbSql.append(",(select count(*) from ship_style ss where SS.STY_SEQ=a.sty_seq and ss.record_delete_flag='1' ) as ship_count ");
    sbSql.append(",a.sty_size_column ");
    sbSql.append("from style a ,production b,prod_head c,prod_ct_infor d  ");
    sbSql.append("where ");
    sbSql.append(" a.prod_head_pk=b.prod_head_pk ");
    sbSql.append(" and b.prod_head_pk=c.prod_head_pk ");
    sbSql.append(" and c.prod_head_pk=d.prod_head_pk ");
    sbSql.append(" and c.prod_cen_code='PW' and c.prod_deptment='PR' and c.prod_buyer=6987 ");
    sbSql.append(" and a.record_delete_flag='1' ");
    sbSql.append(" and A.STY_PO='");sbSql.append(util.MiscFunc.Replace(vsdObj.sty_po,"'","''"));sbSql.append("' ");
    sbSql.append(" and a.sty_style='");sbSql.append(util.MiscFunc.Replace(vsdObj.sty_style,"'","''"));sbSql.append("' ");
    sbSql.append(" and b.PROD_BYR_SC_NO='");sbSql.append(util.MiscFunc.Replace(vsdObj.prod_po,"'","''"));sbSql.append("' ");
    Vector vctTest=exgui2.CONST.BASIC_MAIN_EJB.getDatas(
      util.PublicVariable.USER_RECORD,sbSql.toString(),1,99999);
    if(vctTest.size()==0){
      //process insert statement.
      blankBriefQtyRec=exgui2.CONST.BASIC_MAIN_EJB.getBlankRecord("BRIEF_QTY_tbl");
       NTD_Upload.VsdUploadHome ejbHome =
          (NTD_Upload.VsdUploadHome)
          info_ejb.WeblogicServiceLocator.locateServiceHome(util.PublicVariable.
          SERVER_URL, "NTD_Upload.VsdUpload");
        NTD_Upload.VsdUpload ejbUpload=ejbHome.create();
        ejbUpload.VsdUpload(vsdObj,(String)util.PublicVariable.USER_RECORD.get(0),opTime);
       //String msg2show=ejbUpload.VsdUpload(vsdObj,(String)util.PublicVariable.USER_RECORD.get(0),opTime);
       //dlgUpload.txtMsg.append(msg2show);
       return;
    }else{
      //test create date,if Csv create date is after
      // if shipped,also have to skip
      //show the difference copmare GUI ,wait for determination to update or not.
      Record recStyle=(Record)vctTest.get(0);
      /*this shipped mark,will display in excel of difference,just keep upload
      if(recStyle.getInt("ship_count")>0){
        StringBuffer sbMsg=new StringBuffer();
        sbMsg.append("PO:"+vsdObj.prod_po);
        sbMsg.append(" STYLE:"+vsdObj.sty_style);
        sbMsg.append(" Shipped,and Skipped");
        sbMsg.append("\n");
        dlgUpload.txtMsg.append(sbMsg.toString());
        return;
      }
      */
      java.util.Iterator lineNoItr=vsdObj.isoLineNo.entrySet().iterator();
      java.util.Map.Entry entry=(java.util.Map.Entry)lineNoItr.next();
      VsdCsvObject.LineNoObj testLineObj=(VsdCsvObject.LineNoObj)vsdObj.isoLineNo.get(entry.getKey());
      xntPrcVsdObj=vsdObj;
      if(((java.util.Date)recStyle.get("record_create_date")).before(
           testLineObj.createDate_24)){
             xntPrcVsdObj.sty_seq=recStyle.getInt(0);
             //fork thread 2 run...
             Thread thread2run=new Thread(new ThreadUpload(xntPrcVsdObj));
             thread2run.start();
             //vctVSD2uploadAndGetResult.add(xntPrcVsdObj);
      }

    }
    //dlgUpload.lblFilePath.setText("");
    //exgui.verification.VerifyLib.showPlanMsg("Upload Finished!!","Upload Finished");

    //if after/equal and color/prx diff.list to diff.
  }

  public void doBatchUpload(){
    try{

      NTD_Upload.VsdUploadHome ejbHome =
          (NTD_Upload.VsdUploadHome)
          info_ejb.WeblogicServiceLocator.locateServiceHome(util.PublicVariable.
          SERVER_URL, "NTD_Upload.VsdUpload");
      NTD_Upload.VsdUpload ejb=ejbHome.create();

      for(int i=0;i<vctVsdRec.size();i++){
        VsdCsvObject.VSD_Rec_Unit vsdObj=(VsdCsvObject.VSD_Rec_Unit)vctVsdRec.get(i);
        /*
        cnvLineObj2BrfQty(vsdObj);
        for(int j=0;j<vsdObj.vctBrfQty.size();j++){
          Record recBrfQty=(Record)vsdObj.vctBrfQty.get(j);
          System.out.println(recBrfQty.toString());
        }
        */
        ejb.VsdUpload(vsdObj,util.PublicVariable.USER_RECORD.get(0).toString(),opTime);
      }


    }catch(Exception exp){
      exp.printStackTrace();
      util.ExceptionLog.exp2File(exp,"");
    }

  }
  public void cnvLineObj2BrfQty(final VsdCsvObject.VSD_Rec_Unit vsdStlyeUnit)throws Exception{
    //please do it after Sty_seq and prod_head_pk determed.
    //list all lineNo obj
    java.util.Iterator lineNoItr=vsdStlyeUnit.isoLineNo.entrySet().iterator();
    StringBuffer sizeCamaSb=new StringBuffer();
    String iniColorCode=null;
    String iniColorName=null;
    Record recXntBrfQty;
    int colorRowIndex=0;
    while(lineNoItr.hasNext()){
      java.util.Map.Entry entry=(java.util.Map.Entry)lineNoItr.next();
      String key=(String)entry.getKey();
      LineNoObj lineNoObj=(LineNoObj)vsdStlyeUnit.isoLineNo.get(key);
      /*
      if(lineNoObj==null){
        System.out.println("PO="+vsdStlyeUnit.prod_po);
        System.out.println("STYLE_PO="+vsdStlyeUnit.sty_po);
        System.out.println("STYLE="+vsdStlyeUnit.sty_style);
        System.out.println("KEY="+key);
      }
      */
      if(iniColorCode==null)iniColorCode=lineNoObj.colorCode_15;
      if(iniColorName==null)iniColorCode=lineNoObj.colorName_16;
      if(!vsdStlyeUnit.isoSizeClmIndex.containsKey(lineNoObj.size_18)){
        vsdStlyeUnit.isoSizeClmIndex.put(lineNoObj.size_18,String.valueOf(vsdStlyeUnit.isoSizeClmIndex.entrySet().size()));
        if(sizeCamaSb.length()>0)sizeCamaSb.append(",,");
        sizeCamaSb.append(lineNoObj.size_18);
      }
      String prxColor=lineNoObj.colorCode_15+"||"+lineNoObj.colorName_16+"||"+lineNoObj.price_23;
      if(!vsdStlyeUnit.isoColorAndPrxRowIndex.containsKey(prxColor)){
        vsdStlyeUnit.isoColorAndPrxRowIndex.put(prxColor,String.valueOf(vsdStlyeUnit.isoColorAndPrxRowIndex.entrySet().size()));
        recXntBrfQty=(Record)util.MiscFunc.deepCopy(blankBriefQtyRec);
        recXntBrfQty.set(1,vsdStlyeUnit.sty_seq);
        vsdStlyeUnit.vctBrfQty.add(recXntBrfQty);
      }else{
        recXntBrfQty=(Record)vsdStlyeUnit.vctBrfQty.get(Integer.parseInt((String)vsdStlyeUnit.isoColorAndPrxRowIndex.get(prxColor)));
      }
      colorRowIndex=Integer.parseInt((String)vsdStlyeUnit.isoColorAndPrxRowIndex.get(prxColor));
      recXntBrfQty.set(2,lineNoObj.colorCode_15);
      recXntBrfQty.set(3,lineNoObj.colorName_16);
      //for over than 14 size,set to total qty
      Object objTotal=recXntBrfQty.get(22);
      double  totalQty=Double.parseDouble(((objTotal==null)?"0":objTotal.toString())); //recXntBrfQty.getDouble(22);
      if(Integer.parseInt((String)vsdStlyeUnit.isoSizeClmIndex.get(lineNoObj.size_18))<15){
        recXntBrfQty.set(8 +Integer.parseInt((String)vsdStlyeUnit.isoSizeClmIndex.get(lineNoObj.size_18)),
                         lineNoObj.Qty_19);
         totalQty+= Double.parseDouble(lineNoObj.Qty_19);
      }else{
         totalQty+= Double.parseDouble(lineNoObj.Qty_19);
         for(int i=0;i<13;i++) recXntBrfQty.set(9+i,0);
         recXntBrfQty.set(8,totalQty);//set to 1st size column if one size.
      }
      recXntBrfQty.set(22,totalQty);
      vsdStlyeUnit.vctBrfQty.set(colorRowIndex,recXntBrfQty);
    }
    vsdStlyeUnit.sizeCammaString=sizeCamaSb.toString();

  }

  public boolean readCSV(String fileName){
    VSD_Rec_Unit xntVsdObj=new VSD_Rec_Unit();
    boolean isFirstRow=true;
    try{
      com.csvreader.CsvReader reader = new com.csvreader.CsvReader(fileName);
       while(reader.readRecord()){
         if(isFirstRow){
           isFirstRow = false;
           continue;
         }
         String prod_po=reader.get(7).trim();//CPO
         String sty_style=reader.get(14).trim();// CUSTSTYLE
         String sty_po=prod_po+"("+reader.get(5).trim()+")";// VPONO
         String lineNo=reader.get(9).trim();//LINENO
         if(!xntVsdObj.prod_po.equals(prod_po)||
            !xntVsdObj.sty_style.equals(sty_style)||
            !xntVsdObj.sty_po.equals(sty_po)){
            if(vctVsdRec==null){
              vctVsdRec=new Vector();
            }else{
              VSD_Rec_Unit VsdObj2Add=(VSD_Rec_Unit)util.MiscFunc.deepCopy(xntVsdObj);
              vctVsdRec.add(VsdObj2Add);//1st time,no need to add
            }

             xntVsdObj=new VSD_Rec_Unit();
             xntVsdObj.sty_style=sty_style;
             xntVsdObj.prod_po=prod_po;
             xntVsdObj.sty_po=sty_po;
         }
         LineNoObj xntLineNoObj=new LineNoObj();
         xntLineNoObj.colorCode_15=reader.get(20).trim();//  CUSTCOLORCODE
         xntLineNoObj.colorName_16=reader.get(21).trim();// CUSTCOLORDESC
         xntLineNoObj.createDate_24=df.parse(reader.get(31).trim());// CREATEDDATE
         xntLineNoObj.issueDate_25=df.parse(reader.get(32).trim());// ISSUSEDDATE
         xntLineNoObj.lineNo_5=reader.get(9).trim();//LINENO
         xntLineNoObj.price_23=reader.get(28).trim();// FACTORYCOST
         xntLineNoObj.Qty_19=reader.get(24).trim();// ORDERQTY
         xntLineNoObj.revDate_3=df.parse(reader.get(6).trim());//REVDATE
         xntLineNoObj.shipDate_1=db_df.parse(reader.get(1).trim());// SHIPDATE
         xntLineNoObj.shipModeName_22=reader.get(27).trim().toUpperCase();//SHIPMODE
         xntLineNoObj.size_18=reader.get(23).trim();// CUSTSIZEDESC
         xntLineNoObj.styUpRemark_10=reader.get(15).trim();// CUSTSTYLEDESC

         if(xntVsdObj.isoLineNo.containsKey(lineNo)){
           //test if the exsited line's create date earlier than current one.
           LineNoObj lastObj=(LineNoObj)xntVsdObj.isoLineNo.get(lineNo);
           if(xntLineNoObj.createDate_24.after(lastObj.createDate_24)){
             //xntVsdObj.isoLineNo.put(lineNo,xntLineNoObj);
             xntVsdObj.isoLineNo.remove(lineNo);
             xntVsdObj.isoLineNo.put(lineNo,xntLineNoObj);
           }
         }else{
           //xntVsdObj.isoLineNo.remove(lineNo);
           xntVsdObj.isoLineNo.put(lineNo,xntLineNoObj);
         }
       }
       /* test key of line No.*/
       /*
       java.util.Iterator itr= xntVsdObj.isoLineNo.entrySet().iterator();
       while(itr.hasNext()){
         java.util.Map.Entry entry=(java.util.Map.Entry)itr.next();
         String key=(String)entry.getKey();
         System.out.println(" key of Line No is "+key);
       }
       */
       vctVsdRec.add(xntVsdObj);//add the final one
       reader.close();
       return true;
    }catch(Exception exp){
      exp.printStackTrace();
      util.ExceptionLog.exp2File(exp,"");
      exgui.verification.VerifyLib.showAlert("Read CSV File Failed\nPlease Contact System Manager",
                                             "CSV Read Failed");
      return false;
    }

  }


}
