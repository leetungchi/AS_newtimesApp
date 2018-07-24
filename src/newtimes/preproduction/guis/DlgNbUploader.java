package newtimes.preproduction.guis;
import database.datatype.Record;
import java.util.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import jxl.*;
/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class DlgNbUploader extends JDialog {
  JPanel panel1 = new JPanel();
  JLabel jLabel1 = new JLabel();
  JTextField txtXlsFile = new JTextField();
  JButton btnSlkFile = new JButton();
  JButton btnUpLoad = new JButton();
  JButton btnExit = new JButton();
  java.io.File exlHandle=null;
  java.util.HashMap hm_SEASON=new java.util.HashMap();
  java.util.HashMap hm_MAKER=new java.util.HashMap();
  java.util.HashMap hm_OFFSHORE_CENTER=new java.util.HashMap();
  java.util.HashMap hm_QC_CNTY=new java.util.HashMap();
  java.util.HashMap hm_QC_CITY=new java.util.HashMap();
  java.util.HashMap hm_TYPE=new java.util.HashMap();
  java.util.HashMap hm_COLLECTION=new java.util.HashMap();
  java.util.HashMap hm_PO_CENTER=new java.util.HashMap();
  java.util.HashMap hm_FINAL_DESTINATION= new java.util.HashMap();
  java.util.HashMap hm_PRICE_TERM=new java.util.HashMap();
  java.util.HashMap hm_PORT =new java.util.HashMap();
  java.util.HashMap hm_CURRENCY=new java.util.HashMap();
  java.util.HashMap hm_PAYMENT_TERM=new java.util.HashMap();
  java.util.HashMap hm_SHIP_MODE=new java.util.HashMap();
  java.util.HashMap hm_UNIT=new java.util.HashMap();
  static String STRING_ARRAY_AS_="STRING_ARRAY_AS_";
  static int SEASON_COLUMN_INDEX=1,MAKER_COLUMN_INDEX=3,OFFSHORE_CENTER_COLUMN_INDEX=4;
  static int QC_CNTY_COLUMN_INDEX=5,QC_CITY_COLUMN_INDEX=6,TYPE_COLUMN_INDEX=7,COLLECTION_COLUMN_INDEX=8;
  static int PO_CENTER_COLUMN_INDEX=15,FINAL_DEST_COLUMN_AT=18,PRICE_TERM_COLUMN_AT=30,PORT_COLUMN_AT=31;
  static int CURRENCY_COLUMN_INDEX=32,PAYMENT_TERM_COLUMN_INDEX=35,SHIP_MODE_COLUMN_INDEX=37;
  static int UNIT_COLUMN_INDEX=39,STYLE_COLUMN_INDEX=10;
  DlgNbUploader _this;
  JScrollPane jScrollPane1 = new JScrollPane();
  JTextArea txtAreaUploadMsg = new JTextArea();
  boolean endOfProcess=false;
  JLabel jLabel2 = new JLabel();
  JComboBox cbxCreateUser = new JComboBox();
  public DlgNbUploader(Frame frame, String title, boolean modal) {
    super(frame, title, modal);
    try {
      jbInit();
      pack();
      _this=this;
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }

  public DlgNbUploader() {
    this(null, "", false);
  }

  private void jbInit() throws Exception {
    panel1.setLayout(null);
    jLabel1.setFont(new java.awt.Font("Dialog", 1, 11));
    jLabel1.setText("EXL FILE PATH:");
    jLabel1.setBounds(new Rectangle(13, 43, 90, 28));
    txtXlsFile.setText("");
    txtXlsFile.setBounds(new Rectangle(101, 47, 380, 25));
    btnSlkFile.setBounds(new Rectangle(484, 47, 45, 24));
    btnSlkFile.setFont(new java.awt.Font("Dialog", 1, 11));
    btnSlkFile.setText("...");
    btnSlkFile.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnSlkFile_actionPerformed(e);
      }
    });
    btnUpLoad.setBounds(new Rectangle(137, 107, 100, 28));
    btnUpLoad.setFont(new java.awt.Font("Dialog", 1, 11));
    btnUpLoad.setText("UPLOAD");
    btnUpLoad.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnUpLoad_actionPerformed(e);
      }
    });
    btnExit.setText("EXIT");
    btnExit.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnExit_actionPerformed(e);
      }
    });
    btnExit.setBounds(new Rectangle(331, 107, 100, 28));
    btnExit.setFont(new java.awt.Font("Dialog", 1, 11));
    btnExit.setForeground(Color.red);
    jScrollPane1.setBounds(new Rectangle(16, 159, 534, 148));
    txtAreaUploadMsg.setText("");
    jLabel2.setBounds(new Rectangle(56, 76, 90, 28));
    jLabel2.setText("Create User:");
    jLabel2.setFont(new java.awt.Font("Dialog", 1, 11));
    cbxCreateUser.setBounds(new Rectangle(131, 79, 344, 23));
    getContentPane().add(panel1);
    panel1.add(jLabel1, null);
    panel1.add(txtXlsFile, null);
    panel1.add(btnSlkFile, null);
    panel1.add(btnUpLoad, null);
    panel1.add(btnExit, null);
    panel1.add(jScrollPane1, null);
    panel1.add(jLabel2, null);
    panel1.add(cbxCreateUser, null);
    jScrollPane1.getViewport().add(txtAreaUploadMsg, null);
    Vector vctuer=exgui2.CONST.BASIC_MAIN_EJB.getDatas(
      util.PublicVariable.USER_RECORD,
      "select usr_code from userfile where usr_cen_code='001' and record_delete_flag='1' order by usr_code"
      ,1,9999999);
     java.util.List  strListName=new java.util.ArrayList();
     strListName.add("");
     for(int i=0;i<vctuer.size();i++){
       Record rec=(Record)vctuer.get(i);
       strListName.add((String)rec.get(0));
     }
     cbxCreateUser.setModel(new javax.swing.DefaultComboBoxModel((String[])strListName.toArray(new String[0])));
  }
  void uploadStop(){
    //notified by DlgNbUploader4Dictionary,user press the "STOP" button
    //incase user have to add item for EPR selections
    endOfProcess=true;
    this.dispose();

    return;

  }
  void btnUpLoad_actionPerformed(ActionEvent e) {
    try{
      String createUserCode=(String)cbxCreateUser.getSelectedItem();
       if(null==createUserCode||createUserCode.trim().length()==0){
         exgui.verification.VerifyLib.showAlert("Please Select Create user","Please Select Create user");
         return;
       }
       endOfProcess=false;
      if(txtXlsFile.getText().trim().length()==0){
        exgui.verification.VerifyLib.showAlert("Please Input File Path","Please Input File Path");
        return;
      }
      exlHandle=new java.io.File(txtXlsFile.getText().trim());
      NbExcelExameHandler handler=new NbExcelExameHandler();
      handler.isFormatOk(exlHandle);
      /*
      util.MiscFunc.showProcessingMessage();
      java.io.BufferedInputStream bisASN = new
          java.io.BufferedInputStream(new java.io.FileInputStream(txtAsnFile.getText()));
      byte[] asnByte = new byte[bisASN.available()];
      bisASN.read(asnByte);
      bisASN.close();

      NTD_Upload.AsnUploadFacadeHome ejbHome=
          (NTD_Upload.AsnUploadFacadeHome)
          info_ejb.WeblogicServiceLocator.locateServiceHome(util.PublicVariable.SERVER_URL,"NTD_Upload.AsnUploadFacade");
        NTD_Upload.AsnUploadFacade ejb=ejbHome.create();
        ejb.doUpload(asnByte,util.PublicVariable.USER_RECORD.get(0).toString());
      util.MiscFunc.hideProcessingMessage();
      exgui.verification.VerifyLib.showPlanMsg("Upload OK!!","Upload OK!!");
      */
    }catch(Exception exp){
      exp.printStackTrace();
      util.ExceptionLog.exp2File(exp,"");
      exgui.verification.VerifyLib.showAlert("UPLOAD FAILED!!\nPlease Contact System Manager","UPLOAD FAILED!!");
    }
  }

  void btnExit_actionPerformed(ActionEvent e) {
    this.dispose();
  }

  void btnSlkFile_actionPerformed(ActionEvent e) {
    showFileChooser(btnSlkFile);
  }
  class myFilter extends javax.swing.filechooser.FileFilter{
     public String ext;
     public String des;

     public boolean accept(java.io.File file){
         if(file != null) {
           if(file.isDirectory()) {
              return true;
           }
           String filename=file.getName();
           return filename.endsWith(ext);
         }
         return false;
     }
     public String getDescription(){
        return des;
    }

     public myFilter(String extension, String description) {
       if(extension!=null) ext=extension;
       if(description!=null) des=description;
     }

 }
  public void showFileChooser(Object btn){
    JFileChooser fc = new JFileChooser();
    fc.setDialogType(fc.OPEN_DIALOG);
    fc.setAcceptAllFileFilterUsed(false);
    fc.addChoosableFileFilter(new myFilter("xls","xls,Microsoft Excel NB format"));
    setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
    int returnVal = fc.showDialog(this, "SELECT FILE");
    if (returnVal == JFileChooser.APPROVE_OPTION) {
     java.io.File srcFile = fc.getSelectedFile();
      if(btn==btnSlkFile){
        txtXlsFile.setText(srcFile.getPath());
      }

    }
  }
  class NbExcelExameHandler {
     public boolean isFormatOk(java.io.File file)throws Exception {
       txtAreaUploadMsg.append("CHECKING FILE FORMAT....\n");
        Workbook workbook =Workbook.getWorkbook(file);
        Sheet sheet = workbook.getSheet(0);
        //test if old format
        Cell[] cell0= sheet.getRow(0);
        if(cell0.length >0 && cleanString( cell0[0].getContents()).equalsIgnoreCase("REF")){
          try{
            newtimesejb.excelhandler.ExcelUploadHandlerHome uploader =
                (newtimesejb.excelhandler.ExcelUploadHandlerHome)
                info_ejb.WeblogicServiceLocator.locateServiceHome(util.
                PublicVariable.SERVER_URL,
                "newtimesejb.excelhandler.ExcelUploadHandler");
            newtimesejb.excelhandler.ExcelUploadHandler ejbupload = uploader.
                create();
            String timeStr = null;
              java.io.BufferedInputStream   bis=new
                  java.io.BufferedInputStream(new java.io.FileInputStream(file));
              byte[] data2upload =new byte[bis.available()];
              bis.read(data2upload);
              bis.close();
              util.MiscFunc.showProcessingMessage();
              String createUserCode=(String)cbxCreateUser.getSelectedItem();
            timeStr = ejbupload.doUploadFileTpeX(data2upload,createUserCode);
            util.MiscFunc.hideProcessingMessage();
            exgui.verification.VerifyLib.showPlanMsg("UPLOAD OK","UPLOAD OK");
            _this.dispose();
            return true;
          }catch(Exception exp){
            exp.printStackTrace();
            util.ExceptionLog.exp2File(exp,"");
            exgui.verification.VerifyLib.showAlert("UPLOAD FAILD!! \nPlease contat System manager","upload Failed");
            _this.dispose();
            return true;
          }

        }
        Cell[] cells = sheet.getRow(3);

           if(cells.length==0)return true;//finished
        if(!"YEAR".equals(cells[0].getContents())){
          exgui.verification.VerifyLib.showAlert("Excel 格式錯誤","格式錯誤");
          return false;
        }

        //btnUpLoad.setEnabled(false);
        //cells=sheet.getRow(5);
        //test style.


        if(!isStyeleStringOk(sheet))return false;
        if(!isSeasonOk(sheet))return false;
        if(!isMakerOk(sheet))return false;
        if(!isOffshoreCenterOk(sheet))return false;
        if(!isQcCntyOk(sheet))return false;
        if(!isQcCityOk(sheet))return false;
        if(!isTypeOk(sheet))return false;
        if(!isCollectionOk(sheet))return false;
        if(!isPoCenterOk(sheet))return false;
        if(!isFinalDestOk(sheet))return false;
        if(!isPrxTrmOk(sheet))return false;
        if(!isPortOk(sheet))return false;
        if(!isCurrencyOk(sheet))return false;
        if(!isPaymentTermOk(sheet))return false;
        if(!isShipModeOk(sheet))return false;
        if(!isUnitOk(sheet))return false;
       util.MiscFunc.showProcessingMessage();
        txtAreaUploadMsg.append("Uploading,Please Wait....\n");
        newtimesejb.excelhandler.TpeNbUploadFacadeHome uploader=
            (newtimesejb.excelhandler.TpeNbUploadFacadeHome)
            info_ejb.WeblogicServiceLocator.locateServiceHome(util.PublicVariable.SERVER_URL,
            "newtimesejb.excelhandler.TpeNbUploadFacade");
        newtimesejb.excelhandler.TpeNbUploadFacade ejbupload=uploader.create();
          java.io.BufferedInputStream   bis=new
              java.io.BufferedInputStream(new java.io.FileInputStream(file));
          byte[] data2upload =new byte[bis.available()];
          bis.read(data2upload);
          bis.close();
        txtAreaUploadMsg.append("Upload Ok,result is \n");

        String createUserCode=(String)cbxCreateUser.getSelectedItem();
        String msg=ejbupload.uploadTpeNbData( data2upload,createUserCode);
        txtAreaUploadMsg.append("\n"+msg);
        exgui.verification.VerifyLib.showPlanMsg("Upload OK!!\nPlease Check Message Text Box","Upload OK!!");
        return true;
     }
     void udpateCheckingMsg(int row,String clm,String value){
       String orgMsg=txtAreaUploadMsg.getText();
        String msg="row:"+row+"    COLUMN:"+clm+"  ==> VALUE:"+value+"\n";
        txtAreaUploadMsg.append(msg);
        txtAreaUploadMsg.validate();
        //txtAreaUploadMsg.repaint();
     }
     String cleanString(String str){
        if(str==null)return "";
        String destStr=str.trim().toUpperCase();
        destStr=util.MiscFunc.Replace(destStr,"\n","");
        return destStr;
     }
     void showNotFoundMsg(int row,String exlClmName){
        exgui.verification.VerifyLib.showAlert( exlClmName+" is Blank At Row"+(row+1),exlClmName+" Not Found");
     }
     void parepareMap(final java.util.HashMap hm,String sql,String exlClmName){
       try{
         util.MiscFunc.showProcessingMessage();
         hm.clear();
         java.util.List stringArr=new java.util.ArrayList();
         java.util.Vector vct=exgui2.CONST.BASIC_MAIN_EJB.getDatas(
          util.PublicVariable.USER_RECORD,
          sql,1,999999999);
         for(int i=0;i<vct.size();i++){
            Record rec=(Record)vct.get(i);
            Object value=rec.get(0).toString();
            if(value!=null){
              hm.put(cleanString(value.toString()),
                     cleanString(value.toString()));
              stringArr.add(cleanString(value.toString()));
            }
         }
         Vector vctFromDxnary=
             exgui2.CONST.BASIC_MAIN_EJB.getDatas(
           util.PublicVariable.USER_RECORD,
          "select EXL_VALUE,ERP_VALUE from NB_UPLOAD_DICTIONARY where EXL_CLM_NAME='"+exlClmName+"' order by EXL_VALUE"
          ,1,999999);
          for(int i=0;i<vctFromDxnary.size();i++){
             Record rec=(Record)vctFromDxnary.get(i);
             String key2Test=cleanString(rec.get(0).toString());
             if(!hm.containsKey(key2Test))hm.put(key2Test,cleanString(rec.get(1).toString()));
          }
          hm.put(STRING_ARRAY_AS_,(String[])stringArr.toArray(new String[0]));
          txtAreaUploadMsg.validate();
          util.MiscFunc.hideProcessingMessage();
       }catch(Exception exp){
          exp.printStackTrace();
          util.ExceptionLog.exp2File(exp,"");
          exgui.verification.VerifyLib.showAlert("Error While Generate Map for "+sql,"");
       }
     }

     boolean isStyeleStringOk(Sheet sheet){
       for(int i=5;i<sheet.getRows();i++){
         if(endOfProcess)return false;
          Cell[] cells=sheet.getRow(i);
          if(cells.length==0)return true;//finished
          String year=cells[0].getContents();
          if(year==null)year="";
          String szn=cells[SEASON_COLUMN_INDEX].getContents();
          if(szn==null)szn="";
          if(year.trim().length()==0 && szn.trim().length()==0)continue;
          String strStyle=cells[STYLE_COLUMN_INDEX].getContents();
          if(strStyle==null ||strStyle.trim().length()==0) continue;
          if(strStyle.trim().length()>4){
            //maybe ,4th character is "o",should be zero ?
            if(strStyle.trim().substring(3,4).toUpperCase().equals("O")){
              if(exgui.verification.VerifyLib.showConfirm("第"+(i+1)+"列, Style的第四個字元是O而非零,你要終止作業嗎?",
                                                          "Style's 4th charcter is O,not Zero",false)){

                udpateCheckingMsg(i+1,"style","O,is not zero,process terminated");
                return false;
              }
            }
          }

       }
       return true;

     }

     boolean  isSeasonOk(Sheet sheet)throws Exception{
        String xlCmlName="SEASON";
        parepareMap(hm_SEASON,"select sea_name from season order by sea_name",xlCmlName);
        for(int i=5;i<sheet.getRows();i++){
          if(endOfProcess)return false;
           Cell[] cells=sheet.getRow(i);
           if(cells.length==0)return true;//finished
           String strSzn=cells[SEASON_COLUMN_INDEX].getContents();
           udpateCheckingMsg(i+1,xlCmlName,strSzn);
           if(strSzn==null||strSzn.trim().length()==0){
              //showNotFoundMsg(i,xlCmlName);
              //return false;
              continue;
           }

           if(!hm_SEASON.containsKey(cleanString(strSzn))){
             DlgNbUploader4Dictionary dlg=new
                 DlgNbUploader4Dictionary(util.PublicVariable.APP_FRAME,
                                          "Please Select Mapping Item",true,
                                          xlCmlName,cleanString(strSzn),
                                          _this,hm_SEASON);
             dlg.setSize(640,180);
             exgui.UIHelper.setToScreenCenter(dlg);
             dlg.show();

           }
        }
        return true;
     }
     boolean isMakerOk(Sheet sheet)throws Exception{
        java.util.HashMap hmCheckdMaker=new java.util.HashMap();
        for(int i=5;i<sheet.getRows();i++){
          if(endOfProcess)return false;
           Cell[] cells=sheet.getRow(i);
           if(cells.length==0)return true;//finished
           String year=cells[0].getContents();
           if(year==null)year="";
           String szn=cells[SEASON_COLUMN_INDEX].getContents();
           if(szn==null)szn="";
           if(year.trim().length()==0 && szn.trim().length()==0)continue;
           String maker=cells[MAKER_COLUMN_INDEX].getContents();

           udpateCheckingMsg(i+1,"MAKER",maker);
           if(maker==null||maker.trim().length()==0){
             exgui.verification.VerifyLib.showAlert("Maker  is Blank At Row"+(i+1),"Maker Not Found");
             return false;
           }
           maker=cleanString(maker);
           if(maker.equalsIgnoreCase("SPC"))maker="SINTEX";
           if(hmCheckdMaker.containsKey(maker))continue;
           StringBuffer sql=new StringBuffer();
           sql.append("select bymkr_seq,bymkr_name,BUYER_MAKER.BYMKR_BRIEF from buyer_maker ");
           sql.append("where bymkr_seq in (201,10944,157,308,447,10358,10892,11204,11234,11333,11501,11525,11526,11527,11528,11529,11530,11531,11532,11533,11542,11543,11544,");
           sql.append("11508,100,11713,9424,11614,10358,7727,11665,447,200,7669,11473,168,7818,309,135,9770,7885,101,8372,10532,12131,12214,11473,12341,400,412,12361) ");
           sql.append("and (bymkr_name like '%");sql.append(util.MiscFunc.Replace(maker,"'","''"));sql.append("%' ");
           sql.append("or bymkr_brief like '%");sql.append(util.MiscFunc.Replace(maker,"'","''"));sql.append("%') ");
           Vector vctTest=exgui2.CONST.BASIC_MAIN_EJB.getDatas(
           util.PublicVariable.USER_RECORD,sql.toString(),1,9999999);
           if(vctTest.size()==0){
             exgui.verification.VerifyLib.showAlert("Maker :\""+maker+"\" not Defined At Row"+(i+1),
                                                    "Maker Not Found");
             return false;
           }else{

             hmCheckdMaker.put(maker,maker);

           }
        }
        return true;
     }

     boolean isOffshoreCenterOk(Sheet sheet)throws Exception{
       String xlCmlName="OFFSHORE_CENTER";
       parepareMap(hm_OFFSHORE_CENTER,"select cen_name from center order by cen_name",xlCmlName);
       for(int i=5;i<sheet.getRows();i++){
         if(endOfProcess)return false;
          Cell[] cells=sheet.getRow(i);
           if(cells.length==0)return true;//finished
           String year=cells[0].getContents();
           if(year==null)year="";
           String szn=cells[SEASON_COLUMN_INDEX].getContents();
           if(szn==null)szn="";
           if(year.trim().length()==0 && szn.trim().length()==0)continue;

          String strOffshoreCenter=cells[OFFSHORE_CENTER_COLUMN_INDEX].getContents();
          udpateCheckingMsg(i+1,xlCmlName,strOffshoreCenter);
          if(strOffshoreCenter==null||strOffshoreCenter.trim().length()==0){
            showNotFoundMsg(i,xlCmlName);
            return false;
          }
          if(!hm_OFFSHORE_CENTER.containsKey(cleanString(strOffshoreCenter))){
            DlgNbUploader4Dictionary dlg=new
                DlgNbUploader4Dictionary(util.PublicVariable.APP_FRAME,
                                         "Please Select Mapping Item",true,
                                         xlCmlName,cleanString(strOffshoreCenter),
                                         _this,hm_OFFSHORE_CENTER);
            dlg.setSize(640,180);
            exgui.UIHelper.setToScreenCenter(dlg);
            dlg.show();

          }
       }
       return true;
     }
     boolean isQcCntyOk(Sheet sheet)throws Exception{
       String xlCmlName="QC_COUNTRY";
       parepareMap(hm_QC_CNTY,"select CNTY_name from country order by cnty_name",xlCmlName);
       for(int i=5;i<sheet.getRows();i++){
         if(endOfProcess)return false;
          Cell[] cells=sheet.getRow(i);
           if(cells.length==0)return true;//finished
           String year=cells[0].getContents();
           if(year==null)year="";
           String szn=cells[SEASON_COLUMN_INDEX].getContents();
           if(szn==null)szn="";
           if(year.trim().length()==0 && szn.trim().length()==0)continue;

          String strCntyName=cells[QC_CNTY_COLUMN_INDEX].getContents();
          udpateCheckingMsg(i+1,xlCmlName,strCntyName);
          if(strCntyName==null||strCntyName.trim().length()==0){
            showNotFoundMsg(i,xlCmlName);
            return false;
          }
          if(!hm_QC_CNTY.containsKey(cleanString(strCntyName))){
            DlgNbUploader4Dictionary dlg=new
                DlgNbUploader4Dictionary(util.PublicVariable.APP_FRAME,
                                         "Please Select Mapping Item",true,
                                         xlCmlName,cleanString(strCntyName),
                                         _this,hm_QC_CNTY);
            dlg.setSize(640,180);
            exgui.UIHelper.setToScreenCenter(dlg);
            dlg.show();

          }
       }

        return true;
     }
     boolean isQcCityOk(Sheet sheet){
       String xlCmlName="QC_CITY";
       parepareMap(hm_QC_CITY,"select CITY_name from CITY order by CITY_name",xlCmlName);
       for(int i=5;i<sheet.getRows();i++){
         if(endOfProcess)return false;
          Cell[] cells=sheet.getRow(i);
           if(cells.length==0)return true;//finished
           String year=cells[0].getContents();
           if(year==null)year="";
           String szn=cells[SEASON_COLUMN_INDEX].getContents();
           if(szn==null)szn="";
           if(year.trim().length()==0 && szn.trim().length()==0)continue;

          String strCityName=cells[QC_CITY_COLUMN_INDEX].getContents();
          udpateCheckingMsg(i+1,xlCmlName,strCityName);
          if(strCityName==null||strCityName.trim().length()==0)continue;
          if(!hm_QC_CITY.containsKey(cleanString(strCityName))){
            DlgNbUploader4Dictionary dlg=new
                DlgNbUploader4Dictionary(util.PublicVariable.APP_FRAME,
                                         "Please Select Mapping Item",true,
                                         xlCmlName,cleanString(strCityName),
                                         _this,hm_QC_CITY);
            dlg.setSize(640,180);
            exgui.UIHelper.setToScreenCenter(dlg);
            dlg.show();

          }
       }
       return true;
     }
     boolean isTypeOk(Sheet sheet){
        String typelist=",,W,,K,,S,,SMS,,PHOTO,,";

       for(int i=5;i<sheet.getRows();i++){
         if(endOfProcess)return false;
          Cell[] cells=sheet.getRow(i);
           if(cells.length==0)return true;//finished
          String year=cells[0].getContents();
          if(year==null)year="";
          String szn=cells[SEASON_COLUMN_INDEX].getContents();
          if(szn==null)szn="";
          if(year.trim().length()==0 && szn.trim().length()==0)continue;
          String type=cells[TYPE_COLUMN_INDEX].getContents();
          udpateCheckingMsg(i+1,"TYPE",type);
          if(type==null)type="";
          type=cleanString(type);
          if(type.trim().length()==0){
            exgui.verification.VerifyLib.showAlert("TYPE is blank at row:"+(i+1),"Type is blank" );
            return false;
          }
          if(typelist.indexOf(",,"+type+",,")== -1){
            exgui.verification.VerifyLib.showAlert("Type:\""+type+"\" Not Defined at row:"+(i+1),"Type Not Defined" );
            return false;
          }
       }
       return true;
     }
     boolean isCollectionOk(Sheet sheet){
       StringBuffer sql=new StringBuffer();
       sql.append("select div_name from division where div_bymkr_seq in (11226,11227,362) ");
       sql.append("group by div_name ");
       String xlCmlName="COLLECTION";
       parepareMap(hm_COLLECTION,sql.toString(),xlCmlName);
       for(int i=5;i<sheet.getRows();i++){
         if(endOfProcess)return false;
          Cell[] cells=sheet.getRow(i);
           if(cells.length==0)return true;//finished
           String year=cells[0].getContents();
           if(year==null)year="";
           String szn=cells[SEASON_COLUMN_INDEX].getContents();
           if(szn==null)szn="";
           if(year.trim().length()==0 && szn.trim().length()==0)continue;

          String strCollectionName=cells[COLLECTION_COLUMN_INDEX].getContents();
          udpateCheckingMsg(i+1,xlCmlName,strCollectionName);
          if(strCollectionName==null||strCollectionName.trim().length()==0){
            showNotFoundMsg(i,xlCmlName);
            return false;
          }
          if(!hm_COLLECTION.containsKey(cleanString(strCollectionName))){
            DlgNbUploader4Dictionary dlg=new
                DlgNbUploader4Dictionary(util.PublicVariable.APP_FRAME,
                                         "Please Select Mapping Item",true,
                                         xlCmlName,cleanString(strCollectionName),
                                         _this,hm_COLLECTION);
            dlg.setSize(640,180);
            exgui.UIHelper.setToScreenCenter(dlg);
            dlg.show();

          }
       }

        return true;
     }
     boolean isPoCenterOk(Sheet sheet){
       String poCenterList=",,USA,,UK,,BURTON,,";

      for(int i=5;i<sheet.getRows();i++){
        if(endOfProcess)return false;
         Cell[] cells=sheet.getRow(i);
           if(cells.length==0)return true;//finished
         String year=cells[0].getContents();
         if(year==null)year="";
         String szn=cells[SEASON_COLUMN_INDEX].getContents();
         if(szn==null)szn="";
         if(year.trim().length()==0 && szn.trim().length()==0)continue;
         String poCenter=cells[PO_CENTER_COLUMN_INDEX].getContents();
         udpateCheckingMsg(i+1,"Po Center",poCenter);
         if(poCenter==null)poCenter="";
         poCenter=cleanString(poCenter);
         if(poCenter.trim().length()==0){
           exgui.verification.VerifyLib.showAlert("PO-CENTER is blank at row:"+(i+1),"PO-CENTER is blank" );
           return false;
         }
         if(poCenterList.indexOf(",,"+poCenter+",,")== -1){
           exgui.verification.VerifyLib.showAlert("PO-CENTER:\""+poCenter+"\" Not Defined at row:"+(i+1),"PO-Center Not Defined" );
           return false;
         }
      }
      return true;
     }
     boolean isFinalDestOk(Sheet sheet){
       StringBuffer sql=new StringBuffer();
       sql.append("select dest_name from destination order by dest_name ");
       String xlCmlName="FINAL_DESTINATION";
       parepareMap(hm_FINAL_DESTINATION,sql.toString(),xlCmlName);
       for(int i=5;i<sheet.getRows();i++){
         if(endOfProcess)return false;
          Cell[] cells=sheet.getRow(i);
           if(cells.length==0)return true;//finished
           String year=cells[0].getContents();
           if(year==null)year="";
           String szn=cells[SEASON_COLUMN_INDEX].getContents();
           if(szn==null)szn="";
           if(year.trim().length()==0 && szn.trim().length()==0)continue;

          String strFinalDest=cells[FINAL_DEST_COLUMN_AT].getContents();
          udpateCheckingMsg(i+1,xlCmlName,strFinalDest);
          if(strFinalDest==null||strFinalDest.trim().length()==0){
            showNotFoundMsg(i,xlCmlName);
            return false;
          }
          if(!hm_FINAL_DESTINATION.containsKey(cleanString(strFinalDest))){
            DlgNbUploader4Dictionary dlg=new
                DlgNbUploader4Dictionary(util.PublicVariable.APP_FRAME,
                                         "Please Select Mapping Item",true,
                                         xlCmlName,cleanString(strFinalDest),
                                         _this,hm_FINAL_DESTINATION);
            dlg.setSize(640,180);
            exgui.UIHelper.setToScreenCenter(dlg);
            dlg.show();
          }
       }
       return true;
     }
     boolean isPrxTrmOk(Sheet sheet){
       StringBuffer sql=new StringBuffer();
       sql.append("select prc_trm from price_term order by prc_trm");
       String xlCmlName="PRICE_TERM";
       parepareMap(hm_PRICE_TERM,sql.toString(),xlCmlName);
       for(int i=5;i<sheet.getRows();i++){
         if(endOfProcess)return false;
          Cell[] cells=sheet.getRow(i);
           if(cells.length==0)return true;//finished
           String year=cells[0].getContents();
           if(year==null)year="";
           String szn=cells[SEASON_COLUMN_INDEX].getContents();
           if(szn==null)szn="";
           if(year.trim().length()==0 && szn.trim().length()==0)continue;

          String strPrxTrm=cells[PRICE_TERM_COLUMN_AT].getContents();
          udpateCheckingMsg(i+1,xlCmlName,strPrxTrm);
          if(strPrxTrm==null||strPrxTrm.trim().length()==0){
            showNotFoundMsg(i+1,"Price Term");
            return false;
          }

          if(!hm_PRICE_TERM.containsKey(cleanString(strPrxTrm))){
            DlgNbUploader4Dictionary dlg=new
                DlgNbUploader4Dictionary(util.PublicVariable.APP_FRAME,
                                         "Please Select Mapping Item",true,
                                         xlCmlName,cleanString(strPrxTrm),
                                         _this,hm_PRICE_TERM);
            dlg.setSize(640,180);
            exgui.UIHelper.setToScreenCenter(dlg);
            dlg.show();
          }
       }
       return true;
     }
     boolean isPortOk(Sheet sheet){
       StringBuffer sql=new StringBuffer();
       sql.append("select dest_name from destination order by dest_name ");
       String xlCmlName="PORT";
       parepareMap(hm_PORT,sql.toString(),xlCmlName);
       for(int i=5;i<sheet.getRows();i++){
         if(endOfProcess)return false;
          Cell[] cells=sheet.getRow(i);
           if(cells.length==0)return true;//finished
           String year=cells[0].getContents();
           if(year==null)year="";
           String szn=cells[SEASON_COLUMN_INDEX].getContents();
           if(szn==null)szn="";
           if(year.trim().length()==0 && szn.trim().length()==0)continue;

          String strPort=cells[PORT_COLUMN_AT].getContents();
          udpateCheckingMsg(i+1,xlCmlName,strPort);
          if(strPort==null||strPort.trim().length()==0){
            showNotFoundMsg(i+1,xlCmlName);
            return false;
          }
          if(!hm_PORT.containsKey(cleanString(strPort))){
            DlgNbUploader4Dictionary dlg=new
                DlgNbUploader4Dictionary(util.PublicVariable.APP_FRAME,
                                         "Please Select Mapping Item",true,
                                         xlCmlName,cleanString(strPort),
                                         _this,hm_PORT);
            dlg.setSize(640,180);
            exgui.UIHelper.setToScreenCenter(dlg);
            dlg.show();
          }
       }
       return true;
     }
     boolean isCurrencyOk(Sheet sheet){
       String currencyList=",,USD,,TWD,,RMB,,HKD,,EUR,,";

      for(int i=5;i<sheet.getRows();i++){
        if(endOfProcess)return false;
         Cell[] cells=sheet.getRow(i);
           if(cells.length==0)return true;//finished

         String year=cells[0].getContents();
         if(year==null)year="";
         String szn=cells[SEASON_COLUMN_INDEX].getContents();
         if(szn==null)szn="";
         if(year.trim().length()==0 && szn.trim().length()==0)continue;
         String currency=cells[CURRENCY_COLUMN_INDEX].getContents();
         udpateCheckingMsg(i+1,"CURRENCY",currency);
         if(currency==null)currency="";
         currency=cleanString(currency);
         if(currency.trim().length()==0){
           exgui.verification.VerifyLib.showAlert("currency is blank at row:"+(i+1),"currency is blank" );
           return false;
         }
         if(currencyList.indexOf(",,"+currency+",,")== -1){
           exgui.verification.VerifyLib.showAlert("currency:\""+currency+"\" Not Defined at row:"+(i+1),"currency Not Defined" );
           return false;
         }
      }
      return true;
     }
     boolean isPaymentTermOk(Sheet sheet){
       StringBuffer sql=new StringBuffer();
       sql.append("select pyt_trm from payment_term order by pyt_trm");
       String xlCmlName="PAYMENT_TERM";
       parepareMap(hm_PAYMENT_TERM,sql.toString(),xlCmlName);
       for(int i=5;i<sheet.getRows();i++){
         if(endOfProcess)return false;
          Cell[] cells=sheet.getRow(i);
           if(cells.length==0)return true;//finished
           String year=cells[0].getContents();
           if(year==null)year="";
           String szn=cells[SEASON_COLUMN_INDEX].getContents();
           if(szn==null)szn="";
           if(year.trim().length()==0 && szn.trim().length()==0)continue;

          String strPaymentTerm=cells[PAYMENT_TERM_COLUMN_INDEX].getContents();
          udpateCheckingMsg(i+1,xlCmlName,strPaymentTerm);
          if(strPaymentTerm==null||strPaymentTerm.trim().length()==0){
             showNotFoundMsg(i+1,xlCmlName);
             return false;
          }
          if(!hm_PAYMENT_TERM.containsKey(cleanString(strPaymentTerm))){
            DlgNbUploader4Dictionary dlg=new
                DlgNbUploader4Dictionary(util.PublicVariable.APP_FRAME,
                                         "Please Select Mapping Item",true,
                                         xlCmlName,cleanString(strPaymentTerm),
                                         _this,hm_PAYMENT_TERM);
            dlg.setSize(640,180);
            exgui.UIHelper.setToScreenCenter(dlg);
            dlg.show();
          }
       }
       return true;
     }
     boolean isShipModeOk(Sheet sheet){
       StringBuffer sql=new StringBuffer();
       sql.append("select SHIP_MODE_NAME from ship_modes order by ship_mode_name");
       String xlCmlName="SHIP_MODE";
       parepareMap(hm_SHIP_MODE,sql.toString(),xlCmlName);
       for(int i=5;i<sheet.getRows();i++){
         if(endOfProcess)return false;
          Cell[] cells=sheet.getRow(i);
           if(cells.length==0)return true;//finished
           String year=cells[0].getContents();
           if(year==null)year="";
           String szn=cells[SEASON_COLUMN_INDEX].getContents();
           if(szn==null)szn="";
           if(year.trim().length()==0 && szn.trim().length()==0)continue;

          String strShipMode=cells[SHIP_MODE_COLUMN_INDEX].getContents();
          udpateCheckingMsg(i+1,xlCmlName,strShipMode);
          if(strShipMode==null||strShipMode.trim().length()==0){
            showNotFoundMsg(i+1,xlCmlName);
            return false;
          }
          if(!hm_SHIP_MODE.containsKey(cleanString(strShipMode))){
            DlgNbUploader4Dictionary dlg=new
                DlgNbUploader4Dictionary(util.PublicVariable.APP_FRAME,
                                         "Please Select Mapping Item",true,
                                         xlCmlName,cleanString(strShipMode),
                                         _this,hm_SHIP_MODE);
            dlg.setSize(640,180);
            exgui.UIHelper.setToScreenCenter(dlg);
            dlg.show();
          }
       }
       return true;
     }
     boolean isUnitOk(Sheet sheet){
       StringBuffer sql=new StringBuffer();
       sql.append("select unit from unit order by unit");
       String xlCmlName="UNIT";
       parepareMap(hm_UNIT,sql.toString(),xlCmlName);
       for(int i=5;i<sheet.getRows();i++){
         if(endOfProcess)return false;
          Cell[] cells=sheet.getRow(i);
           if(cells.length==0)return true;//finished
           String year=cells[0].getContents();
           if(year==null)year="";
           String szn=cells[SEASON_COLUMN_INDEX].getContents();
           if(szn==null)szn="";
           if(year.trim().length()==0 && szn.trim().length()==0)continue;
          if(cells.length==UNIT_COLUMN_INDEX)continue;
          String strUnit=cells[UNIT_COLUMN_INDEX].getContents();

          udpateCheckingMsg(i+1,xlCmlName,strUnit);
          if(strUnit==null||strUnit.trim().length()==0){
             continue;
          }
          if(!hm_UNIT.containsKey(cleanString(strUnit))){
            DlgNbUploader4Dictionary dlg=new
                DlgNbUploader4Dictionary(util.PublicVariable.APP_FRAME,
                                         "Please Select Mapping Item",true,
                                         xlCmlName,cleanString(strUnit),
                                         _this,hm_UNIT);
            dlg.setSize(640,180);
            exgui.UIHelper.setToScreenCenter(dlg);
            dlg.show();
          }
       }
       return true;
     }

  }
}
