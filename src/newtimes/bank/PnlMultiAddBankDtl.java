package newtimes.bank;

import exgui.ultratable.*;
import database.datatype.*;
import util.InsertionOrderedHashMap;
import java.util.Hashtable;
import java.awt.*;
import javax.swing.JPanel;
import exgui.*;
import java.util.*;
import database.datatype.Record;
import javax.swing.JComboBox;
import javax.swing.event.PopupMenuEvent;
import javax.swing.event.PopupMenuListener;
import java.awt.event.ItemListener;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;
import javax.swing.event.*;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class PnlMultiAddBankDtl extends exgui.ultratable.FuncAbstractUltraTablePanel {
  static java.util.HashMap hmCompanyBank=null;
  static exgui.ultratable.Wraper4tblCbx emptyBank[]=null;
  JComboBox cbxCompany=null;
  JComboBox cbxBank=null;
  //static String companies[]=null;
  static exgui.ultratable.Wraper4tblCbx companies[]=null;
  CompanyModifyListener companyModefied=null;
  static boolean isRealChangeCompany=true;
  boolean isMakerChanged=false;
  static String Disp_COLUMN_COMPANY="COMPANY▼      ";
  static String DB_COLUMN_COMPANY="COMP_ID";
  static String Disp_COLUMN_BANK="   BANK▼   ";
  static String DB_COLUMN_BANK="BANK_ID";
  static String Disp_COLUMN_CHK_NO=" CHK - NO ";
  static String DB_COLUMN_CHK_NO="CHK_NO";//char (10)
  static String Disp_COLUMN_PAY_DD=" PAY-DD  ";
  static String DB_COLUMN_PAY_DD="PAY_DD";//char(9),ROK year
  static String Disp_COLUMN_DC="D/C";
  static String DB_COLUMN_DC="D_C";
  static String Disp_COLUMN_TYPE="TYPE";
  static String DB_COLUMN_TYPE="TYPE4USD";
  static String Disp_COLUMN_AMT=" AMOUNT ";
  static String DB_COLUMN_AMT="AMOUNT";
  static String Disp_COLUMN_PAYEE="     PAYEE       ";
  static String DB_COLUMN_PAYEE="PAYEE";
  static String Disp_COLUMN_EXCHANGE=" EXCHANGE ";
  static String DB_COLUMN_EXCHANGE="EXCHANGE";
  JButton btnExit=null;
  JButton btnCopy=null;
  JButton btnPast=null;
  JButton btnUpate=null;
  JButton btnReload=null;
  String cd[]=new String[]{"C","D"};
  static Record blankRecordOfTable;
  String payeeeItem[]=null;
  String typeVal [] = null;

  DataBindComboboxTable testCbx=new   DataBindComboboxTable();
  PopMenuObj popmenu;
  int selectedRow;
  int selectedCol;
  PayeeTextMouseListener payeeTextClickedListener=new PayeeTextMouseListener();
  boolean ifHaveEditiorNow;
  exgui.ultratable.MultiEditorJTable superTable=null;
  static boolean isOkPressed=false;
  public PnlMultiAddBankDtl() {
    //super();
    super.jbtn1st.setVisible(false);
    super.jbtnLast.setVisible(false);
    super.jbtnPrev.setVisible(false);
    super.jbtnNext.setVisible(false);
    popmenu=new PopMenuObj(Constants.VCT_PAYEE_ITEMS);

    payeeeItem=new String[Constants.VCT_PAYEE_ITEMS.size()];
    for(int i=0;i<Constants.VCT_PAYEE_ITEMS.size();i++){
      Record recPayeeItem=(Record)Constants.VCT_PAYEE_ITEMS.get(i);
      payeeeItem[i]=(String)recPayeeItem.get(1);
    }
    typeVal=new String[Constants.VCT_TYPE4USD.size()];
    for(int i=0;i<Constants.VCT_TYPE4USD.size();i++){
      Record recType=(Record)Constants.VCT_TYPE4USD.get(i);
      typeVal[i]=(String)recType.get(0);
    }




    btnExit=new JButton("EXIT");
    btnCopy=new JButton("COPY");
    btnPast=new JButton("PASTE");
    btnUpate=new JButton(" ADD ");
    btnReload=new JButton("載入上次資料");
    StringBuffer sb=new StringBuffer();
    sb.append("<html><body>");
    sb.append("支票資料批次新增功能");
    sb.append("<br>");
    sb.append("無選填公司者,該列將忽略不計");
    sb.append("</body></html>");
    JLabel lblTitle=new JLabel();
    lblTitle.setHorizontalAlignment(lblTitle.CENTER);
    lblTitle.setText(sb.toString());
    add(
      //"Please Fill In the Data For Batch Insert Of Check DETAIL"
      lblTitle,
      java.awt.BorderLayout.NORTH
      );
    ClickListener listen=new ClickListener();
    btnExit.addMouseListener(listen);
    btnCopy.addMouseListener(listen);
    btnPast.addMouseListener(listen);
    btnUpate.addMouseListener(listen);
    btnReload.addMouseListener(listen);

    getLowerRightPanel().add(btnCopy);
    getLowerRightPanel().add(btnPast);
    getLowerRightPanel().add(btnUpate);
    getLowerRightPanel().add(btnReload);
    getLowerRightPanel().add(new javax.swing.JLabel(" "));
    getLowerRightPanel().add(btnExit);
    util.InsertionOrderedHashMap iso=new util.InsertionOrderedHashMap();
    iso.put("ITEM","ITEM_NAME");
    testCbx.init("",Constants.VCT_PAYEE_ITEMS,iso,100,50,"ITEM_NAME","ITEM_NAME",null);

    try{
        Constants.updateBankCompanyData();
        Constants.updateMapOfCampanyBank();

      if (companyModefied == null) {
        companyModefied = new CompanyModifyListener();

      }
      if (emptyBank == null) {
        emptyBank = new exgui.ultratable.Wraper4tblCbx[1];
        emptyBank[0] = new exgui.ultratable.Wraper4tblCbx();
        emptyBank[0].setValue(null);
        emptyBank[0].setString("");
      }

      if (hmCompanyBank == null) {
        //this map is to be used while user change the country field,so as the city combobox's model will be changed
        hmCompanyBank = new java.util.HashMap();

        Vector vctCompany = new Vector();

        exgui.ultratable.Wraper4tblCbx itemBlank=new exgui.ultratable.Wraper4tblCbx();
        itemBlank.setValue(null);itemBlank.setString("");
        vctCompany.add(itemBlank);
        for (int i = 0; i < Constants.vctCompany.size();i++) {
          Record recTmp =
              (Record)Constants.vctCompany.get(i);

          String key = (String)recTmp.get(0); //"COMPANY ID"--country name
          exgui.ultratable.Wraper4tblCbx item=new exgui.ultratable.Wraper4tblCbx();
          item.setValue(key);item.setString((String)recTmp.get(1));
          vctCompany.add(item);
          Vector vct = (Vector)Constants.HM_COMPANY_BANK_MAP.get(key);
          if (vct == null) {
               hmCompanyBank.put(key, emptyBank);
          } else {
            /*
            exgui.ultratable.Wraper4tblCbx obj2put[] =
                new exgui.ultratable.Wraper4tblCbx[vct.size() + 1];
            obj2put[0] = new exgui.ultratable.Wraper4tblCbx();
            obj2put[0].setValue(null);
            obj2put[0].setString("");

            for (int j = 0; j < vct.size(); j++) {
              Record recBank = (Record)vct.get(j);
              obj2put[j + 1] = new exgui.ultratable.Wraper4tblCbx();
              obj2put[j + 1].setValue(recBank.get(0));
              obj2put[j + 1].setString((String)recBank.get(1));
            }*/
            exgui.ultratable.Wraper4tblCbx obj2put[] =
                new exgui.ultratable.Wraper4tblCbx[vct.size()];
            for (int j = 0; j < vct.size(); j++) {
              Record recBank = (Record)vct.get(j);
              obj2put[j] = new exgui.ultratable.Wraper4tblCbx();
              obj2put[j].setValue(recBank.get(0));
              obj2put[j].setString((String)recBank.get(1));
            }
            hmCompanyBank.put(key, obj2put);
          }
        }
        companies = (exgui.ultratable.Wraper4tblCbx[])vctCompany.toArray(new exgui.ultratable.Wraper4tblCbx[0]);

        /*companies=new exgui.ultratable.Wraper4tblCbx[vctCompany.size()];
        for(int ii=0;ii<vctCompany.size();ii++){
          companies[ii]=(exgui.ultratable.Wraper4tblCbx)vctCompany.get(ii);
        }*/
      }
    }catch(Exception exp){
        exp.printStackTrace();
    }
  }
  public void firstPage(){
    super.firstPage();
    getJtable().addMouseListener(new MouseListen4menu(getJtable()));
  }
  public class MouseListen4menu extends java.awt.event.MouseAdapter{
    JTable tbl2listen ;
    public MouseListen4menu(JTable _tbl2listen){
      tbl2listen=_tbl2listen;
    }
    public void mouseClicked(java.awt.event.MouseEvent me){
      if ((me.getModifiers() & java.awt.event.InputEvent.BUTTON3_MASK) == java.awt.event.InputEvent.BUTTON3_MASK){
         selectedRow = tbl2listen.rowAtPoint(me.getPoint());
         selectedCol  = tbl2listen.columnAtPoint(me.getPoint());
        if(selectedCol!=6)return;
        ifHaveEditiorNow=false;
        popmenu.show(getJtable(),me.getX(),me.getY());

      }
    }
  }
  public class PopMenuObj extends javax.swing.JPopupMenu implements java.awt.event.ActionListener {
     public PopMenuObj(Vector vctitems){
       super();
       for(int i=0;i<vctitems.size();i++){
         Record rec=(Record)vctitems.get(i);
         JMenuItem menuItem=new JMenuItem((String)rec.get(1));
         menuItem.addActionListener(this);
         add(menuItem);
       }

     }
     public void show(java.awt.Component  comp,int x,int y){
       super.show(comp,x,y);
     }
     public void actionPerformed(java.awt.event.ActionEvent ae){
         JMenuItem itemselected=(JMenuItem)ae.getSource();
         final String text=itemselected.getText();

         if(!ifHaveEditiorNow){
           getJtable().changeSelection(selectedRow, selectedCol, false, false);
         }
         getJtable().setValueAt(text, selectedRow, 6);
         superTable.mt.m_Text=text;

         final javax.swing.text.JTextComponent txtEdit =
             (javax.swing.text.JTextComponent)getJtable().getEditorComponent();


         javax.swing.SwingUtilities.invokeLater(
             new Runnable() {
                public void run() {
                 txtEdit.setText(text);
                 txtEdit.select(0, 0);
                 txtEdit.setCaretPosition(0);
               }
             }
         );


     }
}

  class ClickListener extends java.awt.event.MouseAdapter{
    void reloadLastInput(){
      java.io.File fBackup=new java.io.File("c:\\bnkdata2backup.newtimes");
      if(!fBackup.exists()){
        exgui.verification.VerifyLib.showAlert("沒有上次登打的資料可供載入","無資料備分");
        return;
      }
      if(!exgui.verification.VerifyLib.showConfirm("載入上次的資料會覆蓋你目前頁面所打的資料\n確定要繼續嗎?","Over Write?",false))return;
      try{
        java.io.ObjectInputStream ois = new java.io.ObjectInputStream(new java.
            io.FileInputStream(fBackup));
         Object objArr[]=(Object[])ois.readObject();
         int rowCnt=getJtable().getRowCount();
         int clmCnt=getJtable().getColumnCount();
         for(int i=0;i<rowCnt;i++){
           for(int j=0;j<clmCnt;j++){
             getJtable().setValueAt(objArr[i*clmCnt+j],i,j);
           }
         }
      }catch(Exception exp){
      }

    }
    boolean isCheckOk(){
      //if any row had chose company,have to check other fields.
      getJtable().changeSelection(0,0,false,false);

      for(int i=0;i<getJtable().getRowCount();i++){
        exgui.ultratable.Wraper4tblCbx obj_CompID=(exgui.ultratable.Wraper4tblCbx)getJtable().getValueAt(i,0);
        if(getJtable().getValueAt(i,0)!=null &&
           obj_CompID.toString().trim().length()>0){

          exgui.ultratable.Wraper4tblCbx obj_BANKID=(exgui.ultratable.Wraper4tblCbx)getJtable().getValueAt(i,1);

          if(obj_BANKID==null||obj_BANKID.toString().trim().length()==0){
            getJtable().changeSelection(i,1,false,false);
            exgui.verification.VerifyLib.showAlert("Please Assigne Bank","Please Assigne Bank");
            return false;
          }
          if(getJtable().getValueAt(i,2)==null || getJtable().getValueAt(i,2).toString().trim().length()==0){
            getJtable().changeSelection(i,2,false,false);
            exgui.verification.VerifyLib.showAlert("Please Assigne Check NO","Please Assigne Check NO");
            return false;
          }
          Object objCheckDate=getJtable().getValueAt(i,3);
          if(objCheckDate==null||objCheckDate.toString().trim().length()==0){
            getJtable().changeSelection(i,3,false,false);
            exgui.verification.VerifyLib.showAlert("Please Assigne PAY Date","Please Assigne Pay Date");
            return false;
          }
          Object objCD=getJtable().getValueAt(i,4);
          if(objCD==null||objCD.toString().length()==0||
             (!(objCD.toString().equals("C")||objCD.toString().equals("D")))){
            getJtable().changeSelection(i,4,false,false);
            exgui.verification.VerifyLib.showAlert("Please Assigne \"C\" or \"D\"","Please Assigne \"C\" or \"D\"");
            return false;

          }


          Object objCheck=new ROC_YEAR_date();
          java.util.Date valueCheckDate=
              (java.util.Date)
              ((exgui.ultratable.CellTxtEditorFormat)objCheck).cellStringToObject((String)objCheckDate);

          if(Constants.hmCheckDateMap.get(obj_CompID.getValue()+"_"+obj_BANKID.getValue())==null){
            getJtable().changeSelection(i,1,false,false);
            exgui.verification.VerifyLib.showAlert("Please Select Company & Bank","Please Select Company & Bank");
            return false;
          }
          if(valueCheckDate.before(
            (java.util.Date)Constants.hmCheckDateMap.get(obj_CompID.getValue()+"_"+obj_BANKID.getValue()))){
           getJtable().changeSelection(i,3,false,false);

           String chkDate=((exgui.Object2String)objCheck).Obj2String(
            (java.util.Date)Constants.hmCheckDateMap.get(obj_CompID.getValue()+"_"+obj_BANKID.getValue()));
            exgui.verification.VerifyLib.showAlert("Pay Data Cant not Before "+chkDate,
                                                   "Pay Data Cant not Before "+chkDate);
           return false;
          }
          if(getJtable().getValueAt(i,5)==null ||
             getJtable().getValueAt(i,5).toString().trim().length()==0||
             Double.parseDouble(getJtable().getValueAt(i,5).toString())==0 ){
            getJtable().changeSelection(i,5,false,false);
            exgui.verification.VerifyLib.showAlert("Please Input Amount",
                                                   "Please Amount Can not be zero");
            return false;
          }
          if(getJtable().getValueAt(i,6)==null ||
             getJtable().getValueAt(i,6).toString().trim().length()==0){
            getJtable().changeSelection(i,6,false,false);
            exgui.verification.VerifyLib.showAlert("Please Input PAYEE",
                                                   "Please Input PAYEE");
            return false;
          }

        }
      }
      return true;
    }
     public void mouseClicked(java.awt.event.MouseEvent me){
       if(me.getSource()==btnReload){
         reloadLastInput();
         return;
       }
       if(me.getSource()==btnCopy){
         doCopy();
       }
       if(me.getSource()==btnPast){
         doPast();
       }
       if(me.getSource()==btnUpate){
         try{
           if(!isCheckOk()){

             return;
           }
           //write current page to c:\\
           isOkPressed=true;
           confirmUpdate();
           exgui.verification.VerifyLib.showAlert("Insert OK","Insert OK");
           processhandler.template.Properties.getCenteralControler().goBack();
         }catch(Exception exp){
           exp.printStackTrace();
           util.ExceptionLog.exp2File(exp,"");
         }
       }
       if(me.getSource()==btnExit){
         try {
           processhandler.template.Properties.getCenteralControler().goBack();
         } catch (Exception exp) {
           exp.printStackTrace();
         }
       }
     }
  }
  public  class CompanyModifyListener implements ItemListener{
     public void itemStateChanged(ItemEvent ie){
       if(isRealChangeCompany){
         //if(ie.getID() !=ie.ITEM_STATE_CHANGED )return;
         int row = getJtable().getSelectedRow();
         if(row<0)return;
         exgui.ultratable.Wraper4tblCbx item=new exgui.ultratable.Wraper4tblCbx();
         item.setString("");
         item.setValue(null);
         getJtable().setValueAt(item, row, 1);
         /*
         exgui.ultratable.Wraper4tblCbx companyValue=(exgui.ultratable.Wraper4tblCbx)getJtable().getValueAt(row,0);
         exgui.ultratable.Wraper4tblCbx item2set=
             (exgui.ultratable.Wraper4tblCbx)hmCompanyBank.get(companyValue.getValue());
         getJtable().setValueAt(item2set, row, 1);
         */
       }
     }
  }
  public class DfxEditor4Company extends DefaultCellEditor{
    public DfxEditor4Company(JComboBox cbx){
      super(cbx);
    }
    public synchronized Component getTableCellEditorComponent(JTable table,
          Object value, boolean isSelected, int row, int column) {

      isRealChangeCompany=false;
      Component cmp2Return= super.getTableCellEditorComponent(table,value,isSelected,row,column);
      isRealChangeCompany=true;
      return cmp2Return;
    }

  }
  public class DfxEditor extends DefaultCellEditor{
    private Object prev_value ;
    private JComboBox cbx;
    public DfxEditor(JComboBox cbx){
      super(cbx);
      this.cbx=cbx;
    }
    public  synchronized Component getTableCellEditorComponent(JTable table,
          Object value, boolean isSelected, int row, int column) {
     /*
      System.out.println(
      "getTableCellEdiorComponetCalled: value="+value+
      " isSelected "+String.valueOf(isSelected)+
      " row "+row+" column "+column);
      */

      iniComboboxModel(row);
      exgui.ultratable.Wraper4tblCbx obj2Rap=new exgui.ultratable.Wraper4tblCbx();
      value=prev_value;
      obj2Rap.setValue(value);
      obj2Rap.setString((value==null)?"":value.toString());
 //     cbxBank.setSelectedItem(obj2Rap);
      System.out.println("prev value is : "+prev_value);
 //     cbxBank.setSelectedItem(prev_value);


      return super.getTableCellEditorComponent(table,value,isSelected,row,column);
    }
    public boolean shouldSelectCell(EventObject anEvent) {
      //selectEditor((MouseEvent)anEvent);
      return super.shouldSelectCell(anEvent) ;
    }
    protected void iniComboboxModel(int row){
      //Object objCompany=getJtable().getValueAt(row,0);
      exgui.ultratable.Wraper4tblCbx  objCompany=(exgui.ultratable.Wraper4tblCbx)getJtable().getValueAt(row,0);
      if (row != 0 ) {
          prev_value = getJtable().getValueAt(row-1,1);
      }
      if(objCompany==null||objCompany.getValue()==null||objCompany.toString().trim().equals("")){
        cbxBank.removeAllItems();
        cbxBank.setModel(new DefaultComboBoxModel(emptyBank));
      }else{

        exgui.ultratable.Wraper4tblCbx obj[]=
           (exgui.ultratable.Wraper4tblCbx[])hmCompanyBank.get(objCompany.getValue());
            //(exgui.ultratable.Wraper4tblCbx[])hmCompanyBank.get(objCompany.toString());
        javax.swing.DefaultComboBoxModel mdl=new javax.swing.DefaultComboBoxModel(obj);
        cbxBank.removeAllItems();
        cbxBank.setModel(mdl);
      }
    }
  }


  protected void setBankComboBox(){
    cbxBank=new JComboBox();
    exgui.MultiClassTableModel dtm=(exgui.MultiClassTableModel)getJtable().getModel();
    dtm.registEditableColumn(getJtable().getColumnName(1));
    DefaultCellEditor  ere=new DfxEditor(cbxBank);
    ere.setClickCountToStart(0);
    getJtable().getColumnModel().getColumn(1).setCellEditor(ere);
  }

  protected Record setObject2Record(Record rec, int columnAt, Object value2update) {
    try{
      rec.set(storedRecordColumn[columnAt],value2update);
      return rec;
    }catch(Exception exp){
      exp.printStackTrace();
      return null;
    }
  }
  protected InsertionOrderedHashMap getHeadColumnMap() {
    util.InsertionOrderedHashMap iso=new util.InsertionOrderedHashMap();
    iso.put(Disp_COLUMN_COMPANY,DB_COLUMN_COMPANY);
    iso.put(Disp_COLUMN_BANK,DB_COLUMN_BANK);
    iso.put(Disp_COLUMN_CHK_NO,DB_COLUMN_CHK_NO);
    iso.put(Disp_COLUMN_PAY_DD,DB_COLUMN_PAY_DD);
    iso.put(Disp_COLUMN_DC,DB_COLUMN_DC);
    iso.put(Disp_COLUMN_AMT,DB_COLUMN_AMT);
    iso.put(Disp_COLUMN_PAYEE,DB_COLUMN_PAYEE);
    iso.put(Disp_COLUMN_TYPE,DB_COLUMN_TYPE);
     iso.put(Disp_COLUMN_EXCHANGE,DB_COLUMN_EXCHANGE);
    return iso;
  }
  protected int getEachPageRowCount() {
    /**@todo Implement this exgui.ultratable.AbstractUltraTablePanel abstract method*/
    return 15;
  }
  protected void setCompanyComboBox(){
    cbxCompany=new JComboBox();
    cbxCompany.addItemListener(companyModefied);
    exgui.MultiClassTableModel dtm=(exgui.MultiClassTableModel)getJtable().getModel();
    dtm.registEditableColumn(getJtable().getColumnName(0));
    javax.swing.DefaultComboBoxModel mdl=new javax.swing.DefaultComboBoxModel(companies);
    cbxCompany.removeAllItems();
    cbxCompany.setModel(mdl)  ;
    javax.swing.DefaultCellEditor dce=new DfxEditor4Company(cbxCompany);//new javax.swing.DefaultCellEditor(cbxCompany);
    dce.setClickCountToStart(0);
    getJtable().getColumnModel().getColumn(0).setCellEditor(dce);
  }

  protected void refineEditors(MultiEditorJTable multiEditorJTableInSuper) {
    /**@todo Implement this exgui.ultratable.AbstractUltraTablePanel abstract method*/
    setCompanyComboBox();  //0
    setBankComboBox(); //1

    multiEditorJTableInSuper.addJComboBox(4,cd,false);
    multiEditorJTableInSuper.setTextEditorVerifiers(getObject2StringConvertor());

 //   multiEditorJTableInSuper.addJComboBoxEditable(6,payeeeItem,35);

   //  multiEditorJTableInSuper.addJComboBoxEditable(7,typeVal,4);
     multiEditorJTableInSuper.addJComboBox(7,typeVal,false);

    testCbx.setLocation(500,100);
    superTable=multiEditorJTableInSuper;
  }

  class BankDetalHandler extends exgui.ultratable.PagedDataFactoryAdapter   {
    newtimesejb.bank.BankCheckFacade _ejb=null;
    BankDetalHandler(){
      try{
        try{
          newtimesejb.bank.BankCheckFacadeHome ejbHome = (newtimesejb.bank.
              BankCheckFacadeHome)
              info_ejb.WeblogicServiceLocator.locateServiceHome(
              util.PublicVariable.SERVER_URL,
              "newtimesejb.bank.BankCheckFacade");
              _ejb = ejbHome.create();
        }catch(Exception exp){
          _ejb=null;
          exp.printStackTrace();
        }
        if(_ejb==null){
          try{
            newtimesejb.bank.BankCheckFacadeHome ejbHome = (newtimesejb.bank.
                BankCheckFacadeHome)
                info_ejb.WeblogicServiceLocator.locateServiceHome(
                util.PublicVariable.SERVER_URL,
                "newtimesejb.bank.BankCheckFacade");
                _ejb = ejbHome.create();
          }catch(Exception exp){
            _ejb=null;
            exp.printStackTrace();
          }
        }
        if(_ejb==null){
            newtimesejb.bank.BankCheckFacadeHome ejbHome =
                (newtimesejb.bank.BankCheckFacadeHome)
                info_ejb.WeblogicServiceLocator.locateServiceHome(
                util.PublicVariable.SERVER_URL,"newtimesejb.bank.BankCheckFacade");
                _ejb = ejbHome.create();
        }
         super.ejb=_ejb;
         super.blankRecord=_ejb.getBlankRecord();
         blankRecord.set("record_create_user",util.PublicVariable.USER_RECORD.get(0));
         blankRecord.set(0,-1);//this is flag ,if pk is negtive,means to insert.
         blankRecordOfTable=(Record)util.MiscFunc.deepCopy(blankRecord);
      }catch(Exception exp){
         exp.printStackTrace();
         util.ExceptionLog.exp2File(exp,"");
         exgui.verification.VerifyLib.showAlert("Error While Creating EJB\nPlease Contact System Manager",
                                                "Server Side Error");
      }

    }

    public void updateRecords(Vector vct)throws Exception{
 //     System.out.println(vct);
      Vector vct2add=new Vector();
      for(int i=0;i<vct.size();i++){
        Record rec=(Record)vct.get(i);
        if(rec.get(0)==null||rec.get(0).toString().trim().length()==0) continue;//if no company,skip it
        if(rec.get(1)==null||rec.get(1).toString().trim().length()==0) continue;//if no company,skip it
        if(rec.get(6)==null ||
           rec.get(6).toString().trim().length()==0||
           Double.parseDouble(rec.get(6).toString())==0){
          continue; //if no amount,skip it
        }
        vct2add.add(rec);

      }
      if(isOkPressed){
        int clmCnt=getJtable().getColumnCount();
        int rowCnt=getJtable().getRowCount();
        Object objArr[]=new Object[clmCnt*rowCnt];
        for(int i=0;i<rowCnt;i++){
          for(int j=0;j<clmCnt;j++){
            objArr[i*clmCnt+j]=getJtable().getValueAt(i,j);
          }
        }

        java.io.File fBackup = new java.io.File("c:\\bnkdata2backup.newtimes");
        java.io.FileOutputStream bo = new java.io.FileOutputStream(fBackup);
        java.io.ObjectOutputStream oos = new java.io.ObjectOutputStream(bo);
        //oos.writeObject(vct);
        oos.writeObject(objArr);
        oos.flush();
        bo.flush();
        bo.close();
        oos.close();
        isOkPressed=false;

      }

//       System.out.println(">>> "+vct2add);
      util.MiscFunc.showProcessingMessage();
      newtimesejb.bank.BankCheckFacade tempEjb=null;
      try{
        newtimesejb.bank.BankCheckFacadeHome ejbHome = (newtimesejb.bank.
            BankCheckFacadeHome)
            info_ejb.WeblogicServiceLocator.locateServiceHome(
            util.PublicVariable.SERVER_URL,
            "newtimesejb.bank.BankCheckFacade");
            tempEjb = ejbHome.create();
            tempEjb.insertRecords(vct2add);
            util.MiscFunc.hideProcessingMessage();
            return;
      }catch(Exception exp){
        exp.printStackTrace();
        util.ExceptionLog.exp2File(exp,"");
        tempEjb=null;
      }
      if(tempEjb==null){
        try{
          newtimesejb.bank.BankCheckFacadeHome ejbHome = (newtimesejb.bank.
              BankCheckFacadeHome)
              info_ejb.WeblogicServiceLocator.locateServiceHome(
              util.PublicVariable.SERVER_URL,
              "newtimesejb.bank.BankCheckFacade");
              tempEjb = ejbHome.create();
              tempEjb.insertRecords(vct2add);
              util.MiscFunc.hideProcessingMessage();
              return;
        }catch(Exception exp){
          exp.printStackTrace();
          util.ExceptionLog.exp2File(exp,"");
          tempEjb=null;
        }
      }
      if(tempEjb==null){
        try{
          newtimesejb.bank.BankCheckFacadeHome ejbHome =
              (newtimesejb.bank.BankCheckFacadeHome)
              info_ejb.WeblogicServiceLocator.locateServiceHome(
              util.PublicVariable.SERVER_URL,
              "newtimesejb.bank.BankCheckFacade");
          tempEjb = ejbHome.create();
          tempEjb.insertRecords(vct2add);
          util.MiscFunc.hideProcessingMessage();
          return;
        }catch(Exception exp){
          exp.printStackTrace();
          util.ExceptionLog.exp2File(exp,"");
          tempEjb=null;
        }
      }
      if(tempEjb==null){
        try{
          newtimesejb.bank.BankCheckFacadeHome ejbHome =
              (newtimesejb.bank.BankCheckFacadeHome)
              info_ejb.WeblogicServiceLocator.locateServiceHome(
              util.PublicVariable.SERVER_URL,
              "newtimesejb.bank.BankCheckFacade");
          tempEjb = ejbHome.create();
          tempEjb.insertRecords(vct2add);
          util.MiscFunc.hideProcessingMessage();
          return;
        }catch(Exception exp){
          exp.printStackTrace();
          util.ExceptionLog.exp2File(exp,"");
          tempEjb=null;
        }
      }

      if(tempEjb==null){
        exgui.verification.VerifyLib.showAlert("Error In Inserting Record\nPlease Contact System Manager",
                                               "Server Side Error");

        throw new Exception("Error in Creating BankCheckFacadeEJB");
      }

        tempEjb.insertRecords(vct2add);

      util.MiscFunc.hideProcessingMessage();
    }
    public Vector getRecords(int bgn,int end)throws Exception{
//      System.gc();
      Vector vctReturn=new Vector();
      for(int i=0;i<15;i++){
        Record blankRec=(Record)util.MiscFunc.deepCopy(blankRecordOfTable);
        blankRec.set(0,-1*i);
        blankRec.set(5,"D");
        blankRec.set(6,null);//amount object
        vctReturn.add(blankRec);
      }
      return vctReturn;
    }
  }
  protected Hashtable getObject2StringConvertor() {
    Hashtable ht=new Hashtable();

    Object objVfh10Char=exgui.verification.CellFormat.getOrdinaryField(10);
    Object objVfCD=exgui.verification.CellFormat.getOrdinaryField(1);
    ht.put(Disp_COLUMN_DC,objVfCD);
    ht.put(Disp_COLUMN_CHK_NO,objVfh10Char);
    Object objVfh25Char=new OrdinaryField4Menu(100,exgui.verification.CellFormat.getOrdinaryField(100));
    Object vftxtChkDD=RocDateFormator.getRocDateFormat();
    ht.put(Disp_COLUMN_PAY_DD,vftxtChkDD);

    //Object DCvfy=exgui.verification.CellFormat.getOrdinaryField(1);
    //ht.put(Disp_COLUMN_DC,DCvfy);

    Object amtVfy=exgui.verification.CellFormat.getDoubleFormat(13,2);
    ht.put(Disp_COLUMN_AMT,amtVfy);

    //Object objVfh25Char=exgui.verification.CellFormat.getOrdinaryField(25);
    ht.put(Disp_COLUMN_PAYEE,objVfh25Char);
    Object exchangeVfy=exgui.verification.CellFormat.getDoubleFormat(6,3);
     ht.put(Disp_COLUMN_EXCHANGE,exchangeVfy);



    return ht;
  }
  class PayeeKeyListener extends KeyAdapter
    implements exgui.ultratable.KeyProcess{
   protected javax.swing.text.JTextComponent myTextComponent=null;
   public void keyPressed(java.awt.event.KeyEvent e){
   }
   protected void updateToMonitor(){
       java.awt.Container parentCon=myTextComponent.getParent();
       while(parentCon!=null){
         if(parentCon instanceof exgui.ultratable.MultiEditorJTable){
           myTextComponent.validate();

             ((exgui.ultratable.MultiEditorJTable)parentCon).mt.m_Text =
                 myTextComponent.getText();

            ///System.out.println(" update to ((exgui.ultratable.MultiEditorJTable)parentCon).mt.m_Text :"+myTextComponent.getText());
            break;
         }
         //System.out.println("keep lookup parent ,current parent is "+parentCon.getClass().getName());
         parentCon=parentCon.getParent();
       }
   }
   public void keyReleased(java.awt.event.KeyEvent e){
     //System.out.println("get Key Code:"+e.getKeyCode());
     updateToMonitor();
   }
   public void keyTyped(java.awt.event.KeyEvent e){
   }
   public void bind2TextComponent(javax.swing.text.JTextComponent txtcmp){
     myTextComponent=txtcmp;
     myTextComponent.addKeyListener(this);
     myTextComponent.addMouseListener(payeeTextClickedListener);
   }
}
  class PayeeTextMouseListener extends java.awt.event.MouseAdapter{
    public void mouseClicked(java.awt.event.MouseEvent me){
      if ((me.getModifiers() & java.awt.event.InputEvent.BUTTON3_MASK) == java.awt.event.InputEvent.BUTTON3_MASK){
         selectedRow = getJtable().getSelectedRow();
         selectedCol  = getJtable().getSelectedColumn();
         if(selectedRow<0)return;
         if(selectedCol<0)return;
        if(selectedCol!=6)return;
        ifHaveEditiorNow=true;
        popmenu.show(getJtable().getEditorComponent(),me.getX(),me.getY());

      }

    }
  }

  class OrdinaryField4Menu implements exgui.ultratable.CellTxtEditorFormat,exgui.Object2String{
     int _maxLength;
     String promptMsg=null;
     exgui.ultratable.CellTxtEditorFormat parent;
     PayeeKeyListener keyListen2=new PayeeKeyListener();
     OrdinaryField4Menu(int limitSize,exgui.ultratable.CellTxtEditorFormat _parent){
       _maxLength=limitSize;
       parent=_parent;
       promptMsg="String can not exceed "+_maxLength+" bytes ";
     }

     public KeyProcess getKeyListener(){
       return keyListen2;
     }
    public int getMaxLength(){return _maxLength;}
    public String formatPromptMsg(){
      return promptMsg;
    }
    public boolean isFormatValid(String inStr,int row,int column){
      return parent.isFormatValid(inStr,row,column);
    };
     public Object cellStringToObject(String String2kvt){
        return parent.cellStringToObject(String2kvt);
     }
    public String Obj2String(Object obj){
      if(obj==null) return "";
      return obj.toString().toUpperCase();
    }
  }

  protected PagedDataFactory getPagedDataFactory() {
    if(dbHandler==null){
      BankDetalHandler xHandler = new BankDetalHandler();
      dbHandler = xHandler;
    }
    return dbHandler;

  }

}

