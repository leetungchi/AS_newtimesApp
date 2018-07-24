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

public class Dlg5105xHCX extends JDialog {
  //JPanel pnlEdit = new JPanel();
  Pnl2Edit pnlEdit=null;
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel1 = new BlueBkgWhiteCharLabel();
  WhiteBkgBlueCharLabel whiteBkgBlueCharLabel1 = new WhiteBkgBlueCharLabel();
  JTextField txtCD = new JTextField();
  Border border1;
  TitledBorder titledBorder1;
  JButton btnUdate = new JButton();
  JButton btnExit = new JButton();
  java.text.NumberFormat nf=new java.text.DecimalFormat("############.##");
  Dlg5105xHCX pThis;
  WhiteBkgBlueCharLabel whiteBkgBlueCharLabel2 = new WhiteBkgBlueCharLabel();
  JComboBox cbxCountry =new JComboBox();  //new JComboBox(new String[]{"美國","義大利","歐洲"});
  //JPanel pnlListDtl = new JPanel();
  JLabel lblReminding = new JLabel();
  PnlList5105Dtl pnlListDtl=null;
  public Dlg5105xHCX(Frame frame, String title, boolean modal) {
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

  public Dlg5105xHCX() {
    this(null, "", false);
  }

  private void jbInit() throws Exception {
    this.setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
    getContentPane().add(pnlEdit);
    /*
    lblReminding.setFont(new java.awt.Font("Dialog", 0, 14));
    lblReminding.setText("出口日期空白者,略予不計");
    lblReminding.setBounds(new Rectangle(14, 87, 413, 19));
    whiteBkgBlueCharLabel2.setBounds(new Rectangle(130, 51, 74, 23));
    whiteBkgBlueCharLabel2.setRequestFocusEnabled(true);
    whiteBkgBlueCharLabel2.setText("COUNTRY");
    cbxCountry.setBounds(new Rectangle(204, 51, 146, 26));
    pnlListDtl.setBounds(new Rectangle(14, 118, 531, 236));
    getContentPane().add(pnlEdit);
    pnlEdit.setLayout(null);
    border1 = new EtchedBorder(EtchedBorder.RAISED,Color.white,new Color(148, 145, 140));
    titledBorder1 = new TitledBorder(new EtchedBorder(EtchedBorder.RAISED,Color.white,new Color(148, 145, 140)),"B / L No.");
    blueBkgWhiteCharLabel1.setFont(new java.awt.Font("Dialog", 0, 16));
    blueBkgWhiteCharLabel1.setText("運費明細");
    blueBkgWhiteCharLabel1.setBounds(new Rectangle(0, 10, 562, 33));
    whiteBkgBlueCharLabel1.setText("C / D");
    whiteBkgBlueCharLabel1.setBounds(new Rectangle(7, 51, 74, 23));
    txtCD.setText("");
    txtCD.setBounds(new Rectangle(83, 51, 38, 23));
    btnUdate.setBounds(new Rectangle(153, 366, 107, 25));
    btnUdate.setFont(new java.awt.Font("Dialog", 1, 12));
    btnUdate.setText("OK");
    btnExit.setText("EXIT");
    btnExit.setFont(new java.awt.Font("Dialog", 1, 12));
    btnExit.setForeground(Color.red);
    btnExit.setBounds(new Rectangle(324, 366, 107, 25));
    pnlEdit.add(blueBkgWhiteCharLabel1, null);
    pnlEdit.add(whiteBkgBlueCharLabel1, null);
    pnlEdit.add(txtCD, null);
    pnlEdit.add(btnExit, null);
    pnlEdit.add(btnUdate, null);
    pnlEdit.add(whiteBkgBlueCharLabel2, null);
    pnlEdit.add(cbxCountry, null);
    pnlEdit.add(pnlListDtl, null);
    pnlEdit.add(lblReminding, null);
    btnUdate.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        //btnOK_actionPerformed(e);
      }
    });
    btnExit.setText("EXIT");
    btnExit.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        //btnExit_actionPerformed(e);
      }
    });
    */

  }
  class Pnl2Edit extends  PnlFieldsEditor{
    Vector vctDetail2Edit;
    Pnl2Edit() {
      //jbInit();
    }
    public void jbInit(){
      setLayout(null);
      lblReminding.setFont(new java.awt.Font("Dialog", 0, 14));
      lblReminding.setText("出口日期空白者,略予不計");
      lblReminding.setBounds(new Rectangle(14, 87, 413, 19));

      whiteBkgBlueCharLabel2.setBounds(new Rectangle(130, 51, 74, 23));
      whiteBkgBlueCharLabel2.setRequestFocusEnabled(true);
      whiteBkgBlueCharLabel2.setText("COUNTRY");
      cbxCountry.setBounds(new Rectangle(204, 51, 146, 26));
      Object dateVfy=exgui.verification.CellFormat.getDateStringFormaterAllowNull();
      Object curVfy=exgui.verification.CellFormat.getOrdinaryField(20);
      Object blNoVfy=exgui.verification.CellFormat.getOrdinaryField(4);
      Object objAmtVry=exgui.verification.CellFormat.getDoubleFormatAllowNull(10,2);
      util.InsertionOrderedHashMap iso=new util.InsertionOrderedHashMap();
      iso.put("出口日期","EXP_DATE");
      iso.put("COURIER","COURIER");
      iso.put("BL# 1","BL_NO1");iso.put("BL# 2","BL_NO2");iso.put("BL# 3","BL_NO3");
      iso.put("   AMT   ","AMT");
      java.util.Hashtable ht=new java.util.Hashtable();
      ht.put("出口日期",dateVfy);
      //ht.put("COURIER",curVfy);
      ht.put("BL# 1",blNoVfy);ht.put("BL# 2",blNoVfy);ht.put("BL# 3",blNoVfy);
      ht.put("   AMT   ",objAmtVry);
      DpTemp dbTemp=new DpTemp(recToMapping.get(0).toString(),vctDetail2Edit);
      dbTemp.vctOrg=vctDetail2Edit;
      pnlListDtl=new PnlList5105Dtl(dbTemp,99999,iso,ht);
      pnlListDtl.setBounds(new Rectangle(14, 118, 531, 236));
      border1 = new EtchedBorder(EtchedBorder.RAISED,Color.white,new Color(148, 145, 140));
      titledBorder1 = new TitledBorder(new EtchedBorder(EtchedBorder.RAISED,Color.white,new Color(148, 145, 140)),"B / L No.");
      blueBkgWhiteCharLabel1.setFont(new java.awt.Font("Dialog", 0, 16));
      blueBkgWhiteCharLabel1.setText("運費明細");
      blueBkgWhiteCharLabel1.setBounds(new Rectangle(0, 10, 562, 33));
      whiteBkgBlueCharLabel1.setText("C / D");
      whiteBkgBlueCharLabel1.setBounds(new Rectangle(7, 51, 74, 23));
      txtCD.setText("");
      txtCD.setBounds(new Rectangle(83, 51, 38, 23));
      btnUdate.setBounds(new Rectangle(153, 366, 107, 25));
      btnUdate.setFont(new java.awt.Font("Dialog", 1, 12));
      btnUdate.setText("OK");
      btnExit.setText("EXIT");
      btnExit.setFont(new java.awt.Font("Dialog", 1, 12));
      btnExit.setForeground(Color.red);
      btnExit.setBounds(new Rectangle(324, 366, 107, 25));
      add(blueBkgWhiteCharLabel1, null);
      add(whiteBkgBlueCharLabel1, null);
      add(txtCD, null);
      add(btnExit, null);
      add(btnUdate, null);
      add(whiteBkgBlueCharLabel2, null);
      add(cbxCountry, null);
      add(pnlListDtl, null);
      add(lblReminding);
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
         //updateDescriptionTextField();//in case user type some extra infor
         try{
           if(!pnlListDtl.confirmUpdate())return;
           //list all record
           int rowCount=pnlListDtl.getJtable().getRowCount();
           double totalAmt=0;
           Vector vct2Store=new Vector();
           java.text.DateFormat df=new java.text.SimpleDateFormat("yyyy/MM/dd");
           for(int i=0;i<rowCount;i++){
              Object objDate=pnlListDtl.getJtable().getValueAt(i,0);
              Record rec=pnlListDtl.getPagedDataFactory().getBlankRecord();
              if(objDate!=null && objDate.toString().trim().length()>0){
                 rec.set(0,recToMapping.get(0));
                 rec.set(1,vct2Store.size()+1);
                 String cur=(String)pnlListDtl.getJtable().getValueAt(i,1);
                 if(cur==null||cur.trim().length()==0){
                   exgui.verification.VerifyLib.showAlert("Please Input COURIER","Please Input COURIER");
                   return;
                 }
                 String bl1=(String)pnlListDtl.getJtable().getValueAt(i,2);
                 String bl2=(String)pnlListDtl.getJtable().getValueAt(i,3);
                 String bl3=(String)pnlListDtl.getJtable().getValueAt(i,4);
                 Object amtInDtl=pnlListDtl.getJtable().getValueAt(i,5);
                 if(amtInDtl==null||amtInDtl.toString().trim().length()==0){
                   exgui.verification.VerifyLib.showAlert("Please Input Amount","Please Input Amount");
                   return;
                 }
                 totalAmt+=Double.parseDouble(amtInDtl.toString().trim());
                 java.util.Date dt= df.parse(objDate.toString());
                 rec.set("EXP_DATE",dt);
                 rec.set("COURIER",cur);
                 rec.set("BL_NO1",bl1);rec.set("BL_NO2",bl2);rec.set("BL_NO3",bl3);
                 rec.set("AMT",amtInDtl);
                 rec.set("record_create_user",util.PublicVariable.USER_RECORD.get(0));
                 vct2Store.add(rec);
              }

           }
           recToMapping.set("TOTAL_AMT",nf.format(totalAmt));
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
           sb.append("運寄文件及樣品 GUESS ");
           sb.append(cbxCountry.getSelectedItem().toString());
           recToMapping.set("VH_DESC",sb.toString());
           Constants.Pnl_Tbl2EditDailyVoucher.getJtable().setValueAt(recToMapping.get("VH_DESC"),
               row,Constants.Pnl_Tbl2EditDailyVoucher.DESCRIPTION_COLUMN_AT);
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
         }catch(Exception exp){
           exp.printStackTrace();
           util.ExceptionLog.exp2File(exp,"");
           exgui.verification.VerifyLib.showAlert("update failed!\nPlease Contact System Manager","update Failed");
         }
         pThis.dispose();
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
           String strCnty[]=new String[]{"美國","義大利","歐洲"};
           Vector vctCnty=new Vector();
           for(int i=0;i<3;i++){
             Record recCnty=(Record)util.MiscFunc.deepCopy(util.PublicVariable.USER_RECORD);
             recCnty.getFieldName().clear();
             recCnty.getValueFields().clear();
             recCnty.getFieldName().add("CNTY");
             recCnty.getValueFields().add(strCnty[i]);
             vctCnty.add(recCnty);
           }
          dataBoundGUIs.add(
                  new exgui.DataBindJCombobox(cbxCountry,"CNTY",vctCnty,"CNTY","CNTY",recToMapping.get("CNTY"))
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
      return true;
    }
  }
  class PnlList5105Dtl extends processhandler.template.PnlTableEditor{
    public  PnlList5105Dtl(exgui.ultratable.PagedDataFactory pagedDataFxy,
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
      String curArr[]={"","DHL","FEDEX","UPS"};
      mt.addJComboBox(1,curArr,false);
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
        recBlankProtoType=exgui2.CONST.BASIC_MAIN_EJB.getBlankRecord("VH_5105HCX_DTL_tbl");
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

