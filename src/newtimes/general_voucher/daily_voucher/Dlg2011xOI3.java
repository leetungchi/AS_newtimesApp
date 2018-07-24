package newtimes.general_voucher.daily_voucher;

import java.awt.*;
import javax.swing.*;
import exgui.*;
import newtimes.preproduction.buyermakerselect.*;
import javax.swing.border.*;
import processhandler.template.*;
import java.awt.event.*;
import java.util.*;
import database.datatype.*;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class Dlg2011xOI3 extends JDialog {
  //JPanel pnlEdit = new JPanel();
  Pnl2Edit pnlEdit=null;
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel1 = new BlueBkgWhiteCharLabel();
  WhiteBkgBlueCharLabel whiteBkgBlueCharLabel1 = new WhiteBkgBlueCharLabel();
  JTextField txtCD = new JTextField();
  Border border1;
  JButton btnUdate = new JButton();
  JButton btnExit = new JButton();
  java.text.NumberFormat nf=new java.text.DecimalFormat("############.##");
  Dlg2011xOI3 pThis;
  WhiteBkgBlueCharLabel whiteBkgBlueCharLabel2 = new WhiteBkgBlueCharLabel();//new JComboBox(new String[]{"美國","義大利","歐洲"});
  //JPanel pnlListDtl = new JPanel();
  JLabel lblReminding = new JLabel();
  PnlList1102Dtl pnlListDtl=null;
  //JPanel pnlListDtl=new JPanel();
  JLabel jLabel1 = new JLabel();
  JLabel lblUSD = new JLabel();
  JTextField txtInvNo = new JTextField();
  WhiteBkgBlueCharLabel whiteBkgBlueCharLabel3 = new WhiteBkgBlueCharLabel();
  JTextField txtAmt = new JTextField();
  JTextField txtDesc = new JTextField();
  WhiteBkgBlueCharLabel whiteBkgBlueCharLabel4 = new WhiteBkgBlueCharLabel();
  public Dlg2011xOI3(Frame frame, String title, boolean modal) {
    super(frame, title, modal);
    pThis=this;
    try {
      pnlEdit=new Pnl2Edit();
      jbInit();
      pack();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }

  public Dlg2011xOI3() {
    this(null, "", false);
  }

  private void jbInit() throws Exception {
    this.setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
    getContentPane().add(pnlEdit);
  }
  class AmtVfy implements exgui.ultratable.CellTxtEditorFormat,exgui.Object2String{
    java.text.DecimalFormat formatter = null;//new java.text.DecimalFormat("######.###");
    Object amtVfy=null;
    public AmtVfy(int intDigitLength,int floatDigitLength){
      amtVfy=exgui.verification.CellFormat.getDoubleFormatAllowNull(intDigitLength,floatDigitLength);
    }

    public int getMaxLength(){return ((exgui.ultratable.CellTxtEditorFormat)amtVfy).getMaxLength();}
    public exgui.ultratable.KeyProcess getKeyListener(){
      return ((exgui.ultratable.CellTxtEditorFormat)amtVfy).getKeyListener();
    }
    public String formatPromptMsg(){
      return ((exgui.ultratable.CellTxtEditorFormat)amtVfy).formatPromptMsg();
    }
    public boolean isFormatValid(String inStr,int row,int column){
      boolean result=((exgui.ultratable.CellTxtEditorFormat)amtVfy).isFormatValid(inStr,row,column);
      if(!result)return false;
      update2UsdAmt();
      return true;
    }
    public String Obj2String(Object obj2kvt){
      return ((exgui.Object2String)amtVfy).Obj2String(obj2kvt);
    }
     public Object cellStringToObject(String String2kvt){
        return ((exgui.ultratable.CellTxtEditorFormat)amtVfy).cellStringToObject(String2kvt);
     }
  }
   public void update2UsdAmt(){
     java.text.DecimalFormat formatter =new java.text.DecimalFormat("######.###");
     int rowcount=pnlListDtl.getJtable().getRowCount();
     double usdAmt=0;
     for(int i=0;i<rowcount;i++){
       Object objAmt=pnlListDtl.getJtable().getValueAt(i,3);
       if(objAmt!=null && objAmt.toString().length()>0){
         usdAmt+= Double.parseDouble(objAmt.toString());
       }
     }
     lblUSD.setText(formatter.format(usdAmt));

   }

  class Pnl2Edit extends  PnlFieldsEditor{
    Vector vctDetail2Edit;
    Pnl2Edit() {
      //jbInit();
    }
    public void jbInit(){
      setLayout(null);
      setLayout(null);

  lblReminding.setFont(new java.awt.Font("Dialog", 0, 14));
  lblReminding.setText("款項類別空白者,略予不計");
  lblReminding.setBounds(new Rectangle(14, 87, 413, 19));

  whiteBkgBlueCharLabel2.setBounds(new Rectangle(130, 51, 57, 23));
  whiteBkgBlueCharLabel2.setRequestFocusEnabled(true);
  whiteBkgBlueCharLabel2.setText("INV#");

      Object dateVfy=exgui.verification.CellFormat.getDateStringFormaterAllowNull();
      Object curVfy=exgui.verification.CellFormat.getOrdinaryField(20);
      //Object objAmtVry=exgui.verification.CellFormat.getDoubleFormatAllowNull(10,2);

  util.InsertionOrderedHashMap iso=new util.InsertionOrderedHashMap();
  iso.put("項款類別","TYPE");
  iso.put("匯入日期","PAY_DATE");
  iso.put("BUYER","BUYER");
  iso.put("   AMT   ","AMT");
  iso.put("MAKER","MAKER");
  java.util.Hashtable ht=new java.util.Hashtable();
  ht.put("匯入日期",dateVfy);
  ht.put("   AMT   ",new AmtVfy(12,2));
  ht.put("BUYER",curVfy);
  ht.put("MAKER",curVfy);
  DpTemp dbTemp=new DpTemp(recToMapping.get(0).toString(),vctDetail2Edit);
  dbTemp.vctOrg=vctDetail2Edit;
  pnlListDtl=new PnlList1102Dtl(dbTemp,99999,iso,ht);


  pnlListDtl.setBounds(new Rectangle(14, 118, 531, 236));
  border1 = new EtchedBorder(EtchedBorder.RAISED,Color.white,new Color(148, 145, 140));
  blueBkgWhiteCharLabel1.setFont(new java.awt.Font("Dialog", 0, 16));
  blueBkgWhiteCharLabel1.setText("兆豐 美乙/人乙 明細");
  blueBkgWhiteCharLabel1.setBounds(new Rectangle(0, 10, 562, 33));
  whiteBkgBlueCharLabel1.setText("C / D");
  whiteBkgBlueCharLabel1.setBounds(new Rectangle(7, 51, 74, 23));
  txtCD.setText("");
  txtCD.setBounds(new Rectangle(83, 51, 38, 23));
  btnUdate.setBounds(new Rectangle(150, 435, 107, 25));
  btnUdate.setFont(new java.awt.Font("Dialog", 1, 12));
  btnUdate.setText("OK");
  btnExit.setText("EXIT");
  btnExit.setFont(new java.awt.Font("Dialog", 1, 12));
  btnExit.setForeground(Color.red);
  btnExit.setBounds(new Rectangle(321, 435, 107, 25));
  jLabel1.setFont(new java.awt.Font("Dialog", 1, 14));
  jLabel1.setText("TOTAL :");
  jLabel1.setBounds(new Rectangle(18, 378, 96, 27));
  lblUSD.setBounds(new Rectangle(115, 378, 132, 27));
  lblUSD.setText("0");
  lblUSD.setFont(new java.awt.Font("Dialog", 1, 14));
  txtInvNo.setBounds(new Rectangle(189, 51, 78, 23));
  txtInvNo.setFont(new java.awt.Font("Dialog", 0, 12));
  txtInvNo.setText("");
  whiteBkgBlueCharLabel3.setRequestFocusEnabled(true);
  whiteBkgBlueCharLabel3.setText("AMT:");
  whiteBkgBlueCharLabel3.setBounds(new Rectangle(290, 51, 72, 23));
  txtAmt.setText("");
  txtAmt.setFont(new java.awt.Font("Dialog", 0, 12));
  txtAmt.setBounds(new Rectangle(364, 51, 147, 23));
  txtDesc.setBounds(new Rectangle(126, 406, 405, 23));
  txtDesc.setFont(new java.awt.Font("Dialog", 0, 12));
  txtDesc.setText("");
  whiteBkgBlueCharLabel4.setBounds(new Rectangle(12, 406, 114, 23));
  whiteBkgBlueCharLabel4.setText("DESCRIPTION");
  whiteBkgBlueCharLabel4.setRequestFocusEnabled(true);
  add(blueBkgWhiteCharLabel1, null);
  add(whiteBkgBlueCharLabel1, null);
  add(txtCD, null);
  add(whiteBkgBlueCharLabel2, null);
  add(pnlListDtl, null);
  add(lblReminding);
  add(btnExit, null);
  add(btnUdate, null);
  add(txtInvNo, null);
  add(whiteBkgBlueCharLabel3, null);
  add(txtAmt, null);
  add(whiteBkgBlueCharLabel4, null);
  add(txtDesc, null);
  add(lblUSD, null);
  add(jLabel1, null);
  add(pnlListDtl,null);


      btnUdate.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(ActionEvent e) {
          btnOK_actionPerformed(e);
        }
      });
      btnExit.setText("EXIT");
      btnExit.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(ActionEvent e) {
          btnExit_actionPerformed(e);
        }
      });

    }
    String formateNumber(Object objValue){
      if(objValue==null||objValue.toString().trim().length()==0) return null;
      return nf.format(Double.parseDouble(objValue.toString()));
    }

     void btnOK_actionPerformed(ActionEvent e){
       if(!gui2Record()){
         return;
       }else{
         update2UsdAmt();
         //updateDescriptionTextField();//in case user type some extra infor
         try{
           if(!pnlListDtl.confirmUpdate())return;
           //list all record
           int rowCount=pnlListDtl.getJtable().getRowCount();
           //double totalAmt=0;
           Vector vct2Store=new Vector();
           java.text.DateFormat df=new java.text.SimpleDateFormat("yyyy/MM/dd");
           /*
            column order
              TYPE              0
              PAY_DATE           1
              BUYER              2
              AMT                3
              MAKER              4
           */
           for(int i=0;i<rowCount;i++){
              Object objType=pnlListDtl.getJtable().getValueAt(i,0);
              Record rec=pnlListDtl.getPagedDataFactory().getBlankRecord();
              if(objType!=null && objType.toString().trim().length()>0){
                 rec.set(0,recToMapping.get(0));
                 rec.set(1,vct2Store.size()+1);
                 Object amtInDtl=pnlListDtl.getJtable().getValueAt(i,3);
                 if(amtInDtl==null||amtInDtl.toString().trim().length()==0){
                   exgui.verification.VerifyLib.showAlert("Please Input Amount","Please Input Amount");
                   return;
                 }
                 //totalAmt+=Double.parseDouble(amtInDtl.toString().trim());
                 Object objDate=pnlListDtl.getJtable().getValueAt(i,1);//匯入日期.
                 if(objDate!=null && objDate.toString().trim().length()>0){
                   java.util.Date dt= df.parse(objDate.toString());
                   rec.set("PAY_DATE",dt);
                 }
                 rec.set("TYPE",objType.toString());
                 rec.set("AMT",amtInDtl);

                 Object objBuyer=pnlListDtl.getJtable().getValueAt(i,2);
                 rec.set("BUYER",objBuyer);
                 Object objMaker=pnlListDtl.getJtable().getValueAt(i,4);
                 rec.set("MAKER",objMaker);
                 rec.set("record_create_user",util.PublicVariable.USER_RECORD.get(0));
                 vct2Store.add(rec);
              }

           }
           recToMapping.set("clm2StoreVector",vct2Store);

           //write back to parnet's GUI
           String cdCode=(String)recToMapping.get("C_D");
           int row=Constants.Pnl_Tbl2EditDailyVoucher.getJtable().getSelectedRow();
           Object dc_AMT=recToMapping.get("TOTAL_AMT");
           String strAmt;
           strAmt=dc_AMT.toString();
           if(strAmt.startsWith("-")){
             String intValueAmt=strAmt.substring(1,strAmt.length());
             intValueAmt=formateNumber(intValueAmt);
             if("C".equalsIgnoreCase(cdCode)){
               Constants.Pnl_Tbl2EditDailyVoucher.getJtable().setValueAt(intValueAmt,row,
                   Constants.Pnl_Tbl2EditDailyVoucher.DEBIT_AMT_COLUMN_AT);

               Constants.Pnl_Tbl2EditDailyVoucher.getJtable().setValueAt(null,
                   row,Constants.Pnl_Tbl2EditDailyVoucher.CREDIT_AMT_COLUMN_AT);

             }else{
               Constants.Pnl_Tbl2EditDailyVoucher.getJtable().setValueAt(intValueAmt,row,
                   Constants.Pnl_Tbl2EditDailyVoucher.CREDIT_AMT_COLUMN_AT);

               Constants.Pnl_Tbl2EditDailyVoucher.getJtable().setValueAt(null,
                   row,Constants.Pnl_Tbl2EditDailyVoucher.DEBIT_AMT_COLUMN_AT);

             }



           }else{
             strAmt=formateNumber(strAmt);
             if("C".equalsIgnoreCase(cdCode)){
               Constants.Pnl_Tbl2EditDailyVoucher.getJtable().setValueAt(strAmt,
                   row,Constants.Pnl_Tbl2EditDailyVoucher.CREDIT_AMT_COLUMN_AT);

               Constants.Pnl_Tbl2EditDailyVoucher.getJtable().setValueAt(null,row,
                   Constants.Pnl_Tbl2EditDailyVoucher.DEBIT_AMT_COLUMN_AT);
             }else{
               Constants.Pnl_Tbl2EditDailyVoucher.getJtable().setValueAt(strAmt,row,
                   Constants.Pnl_Tbl2EditDailyVoucher.DEBIT_AMT_COLUMN_AT);

               Constants.Pnl_Tbl2EditDailyVoucher.getJtable().setValueAt(null,
                   row,Constants.Pnl_Tbl2EditDailyVoucher.CREDIT_AMT_COLUMN_AT);

             }
           }
           //vh dec is composed by export date,currier,and B/L#
           StringBuffer sb=new StringBuffer();
           sb.append(txtDesc.getText().trim());
           recToMapping.set("VH_DESC",sb.toString());
           Constants.Pnl_Tbl2EditDailyVoucher.getJtable().setValueAt(recToMapping.get("VH_DESC"),
               row,Constants.Pnl_Tbl2EditDailyVoucher.DESCRIPTION_COLUMN_AT);

           Constants.Pnl_Tbl2EditDailyVoucher.getJtable().setValueAt(recToMapping.get("INV_NO"),
               row,Constants.Pnl_Tbl2EditDailyVoucher.INVOICE_NO_COLUMN_AT);

         Constants.Pnl_Tbl2EditDailyVoucher.isContextModified=true;
           //set to database for auditing....
           recToMapping.set("record_modify_user",util.PublicVariable.USER_RECORD.get(0));
           recToMapping.set("record_modify_date",new java.sql.Date(System.currentTimeMillis()));

           //force ejb to handle all columns,cause server side used "delete & insert" to replace the "update" statement
           database.datatype.Record recTest=(database.datatype.Record)util.MiscFunc.deepCopy(recToMapping);
           for(int i=0;i<recToMapping.getFieldName().size();i++){
             recToMapping.set(i,recTest.get(i));
           }
           java.util.Vector vec = new java.util.Vector();
           vec.add(recToMapping);
           dbprc.updateRecords(vec);
           Constants.Pnl_EditDaily_Voucher.update2TotalLabel();
           pThis.dispose();
         }catch(Exception exp){
           exp.printStackTrace();
           util.ExceptionLog.exp2File(exp,"");
           exgui.verification.VerifyLib.showAlert("update failed!\nPlease Contact System Manager","update Failed");
         }

       }



     }
      void btnExit_actionPerformed(ActionEvent e){

        if(pnlEdit.isContextModified()||
           pnlListDtl.isContextModified()){
          if(!exgui.verification.VerifyLib.showConfirm("Context Modified\nAre You Sure To Exit Without Confirmation?",
                                                       "Context Modified",false))return;
        }
        pThis.dispose();


     }
    public void record2Gui(){
      try{
        dataBoundGUIs.clear();
        Object vftxtCD=exgui.verification.CellFormat.getOrdinaryField(1);
         dataBoundGUIs.add(  new exgui.DataBindTextWithChecker(txtCD,"C_D",recToMapping.get("C_D"),1,(exgui.Object2String)vftxtCD,(exgui.ultratable.CellTxtEditorFormat)vftxtCD)
        );

        Object objAmtVry=exgui.verification.CellFormat.getDoubleFormatAllowNull(10,2);
        dataBoundGUIs.add(
              new exgui.DataBindTextWithChecker(txtAmt,"TOTAL_AMT",
                                                recToMapping.get("TOTAL_AMT"),12,
                                                (exgui.Object2String)objAmtVry,
                                                (exgui.ultratable.CellTxtEditorFormat)objAmtVry)
        );

        Object vftxtInvNo=exgui.verification.CellFormat.getOrdinaryField(20);
         dataBoundGUIs.add(  new exgui.DataBindTextWithChecker(txtInvNo,"INV_NO",
             recToMapping.get("INV_NO"),20,
             (exgui.Object2String)vftxtInvNo,
             (exgui.ultratable.CellTxtEditorFormat)vftxtInvNo)
        );

        Object vftxtDesc=exgui.verification.CellFormat.getOrdinaryField(1000);
         dataBoundGUIs.add(  new exgui.DataBindTextWithChecker(txtDesc,"VH_DESC",
             recToMapping.get("VH_DESC"),1000,
             (exgui.Object2String)vftxtDesc,
             (exgui.ultratable.CellTxtEditorFormat)vftxtDesc)
        );


        pnlListDtl.firstPage();
      }catch(Exception exp){
        exp.printStackTrace();
      }

    }
    public void doPrint(){}
    public boolean gui2Record(){
      boolean result=super.gui2Record();
      if(!result)return false;
      String cdCode=txtCD.getText().trim();
      if(!("C".equalsIgnoreCase(cdCode)||"D".equalsIgnoreCase(cdCode))){
        exgui.verification.VerifyLib.showAlert("Please Input C/D","Please Input C/D");
        return false;
      }
      //tset inv# if inputed.
      String invNo=txtInvNo.getText().trim();
      if(invNo.length()>0){
        invNo=("ZATW"+util.MiscFunc.Replace(invNo,"'","''"));
        StringBuffer sbSql=new StringBuffer();
        sbSql.append("select a.ship_no ");
        sbSql.append("from ship_sc a ");
        sbSql.append("where a.ship_no ='");sbSql.append(invNo);sbSql.append("' and a.record_delete_flag='1' ");
        try{
          Vector vct = exgui2.CONST.BASIC_MAIN_EJB.getDatas(
           util.PublicVariable.USER_RECORD, sbSql.toString(), 1, 9999);
          if(vct.size()==0){
            exgui.verification.VerifyLib.showAlert("INVOICE# not Found","Invoice # Not Found");
            return false;
          }
        }catch(Exception exp){
          exp.printStackTrace();
        }
      }
      if(txtAmt.getText().trim().length()==0){
        exgui.verification.VerifyLib.showAlert("Please Input Total Amount",
                                               "Please Input Total Amount");
        return false;
      }
      if(txtDesc.getText().trim().length()==0){
        exgui.verification.VerifyLib.showAlert("Please Input Description",
                                               "Please Input Description");
        return false;
      }


      return true;
    }
  }
  class PnlList1102Dtl extends processhandler.template.PnlTableEditor{
    public  PnlList1102Dtl(exgui.ultratable.PagedDataFactory pagedDataFxy,
                      int rowCounts,util.InsertionOrderedHashMap columnMapping,
                     java.util.Hashtable object2StringConvertor){
        super(pagedDataFxy, rowCounts, columnMapping, object2StringConvertor);
        super.getPanelContainsButtons().removeAll();
    }
    public void doPrint(){}
    public int getEachPageRowCount(){return _rowCounts;}
    public Hashtable getObject2StringConvertor() {return klmObjKvtHt;}
    public util.InsertionOrderedHashMap getHeadColumnMap(){return tblHeadColumn;}
    public exgui.ultratable.PagedDataFactory getPagedDataFactory(){return dbHandler;}
    public void refineEditors(exgui.ultratable.MultiEditorJTable mt ){
      String typeArr[]={"","工廠未付","自有資金","墊款","暫收款","DN"};
      mt.addJComboBox(0,typeArr,false);
      mt.setTextEditorVerifiers(getObject2StringConvertor());
    }
    public Record setObject2Record(Record rec,int col,Object obj){
        try{
          String colName=super.storedRecordColumn[col];
          rec.set(colName,obj);
          return rec;
        }catch(Exception exp){
          exp.printStackTrace();
          return null;
        }
    }



  }


  class DpTemp extends exgui.ultratable.PagedDataFactoryAdapter{
    String glbSeq="";
    Record recBlankProtoType;
    Vector vctOrg=null;
    DpTemp(String _glbSeq,Vector _vctorg){
      glbSeq=_glbSeq;
      vctOrg=_vctorg;
      try{
        recBlankProtoType=exgui2.CONST.BASIC_MAIN_EJB.getBlankRecord("VH_1102X0I3_DTL_tbl");
      }catch(Exception exp){
        exp.printStackTrace();
      }
    }
    public Record getBlankRecord()throws Exception{
      return (Record)util.MiscFunc.deepCopy(recBlankProtoType);
    }
    public void updateRecords(Vector vct2update){

    }
    public  Vector getRecords(int rowcount,int bgn)throws Exception{
      //always add 6  new record to end of vector.
      return vctOrg;
      //find out form database.
    }
  }

}

