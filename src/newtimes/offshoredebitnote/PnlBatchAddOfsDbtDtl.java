package newtimes.offshoredebitnote;

import java.awt.*;
import exgui.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import exgui.*;
import javax.swing.border.*;
import database.datatype.Record;
import exgui.ultratable.MultiEditorJTable;
import exgui.ultratable.PagedDataFactory;
import java.util.*;
import java.awt.event.*;
/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class PnlBatchAddOfsDbtDtl extends JPanel {
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel1 = new BlueBkgWhiteCharLabel();
  JLabel jLabel1 = new JLabel();
  JPanel pnl2PlaceGrid = new JPanel();
  BorderLayout borderLayout1 = new BorderLayout();
  JButton btnExit=new JButton("EXIT");
  JButton btnUpdate=new JButton("ADD");
  JButton btnCopy=new JButton("COPY");
  JButton btnPast=new JButton("PASTE");
  PnlOfsDtl pnlDb=null;
  static Vector vctDep;
  static Vector vctCountry;

  public PnlBatchAddOfsDbtDtl() {
    try {
      jbInit();
    }catch(Exception ex) {
      ex.printStackTrace();
    }
  }

  void jbInit() throws Exception {
    blueBkgWhiteCharLabel1.setBounds(new Rectangle(0, 7, 800, 34));
    blueBkgWhiteCharLabel1.setText("ADD Details Of Offshore Debit Note");
    this.setLayout(null);
    jLabel1.setText("DEPARTMENT 空白者,不予計算");
    jLabel1.setBounds(new Rectangle(153, 44, 458, 24));
    pnl2PlaceGrid.setBounds(new Rectangle(6, 74, 780, 490));
    pnl2PlaceGrid.setLayout(borderLayout1);
    this.add(blueBkgWhiteCharLabel1, null);
    this.add(pnl2PlaceGrid, null);
    this.add(jLabel1, null);

    btnCopy.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnCopy_actionPerformed(e);
      }
    });

    btnPast.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnPast_actionPerformed(e);
      }
    });

    btnUpdate.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnUpdate_actionPerformed(e);
      }
    });

    btnExit.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnExit_actionPerformed(e);
      }
    });
    /*
        DTL_PK              NUMBER(10)                NOT NULL,
       DTL_DEP_CODE        VARCHAR2(2)               NOT NULL,
       DTL_CNTY_PK         NUMBER(10)                NOT NULL,
       DTL_DRCR_NO         VARCHAR2(10)              NOT NULL,
       DTL_DATE            DATE                      NOT NULL,
       DTL_COMM_FEE        NUMBER(13,2),
       DTL_MISC_FEE        NUMBER(13,2),
       DTL_SMPL_FEE        NUMBER(13,2),
       DTL_TRVL_FEE        NUMBER(13,2),
       DTL_TRNPORT_FEE     NUMBER(13,2),
       DTL_SOCIAL_FEE      NUMBER(13,2),
       DTL_TEL_FEE         NUMBER(13,2),
       DTL_CLAIM_FEE       NUMBER(13,2),
       DTL_AP_FEE          NUMBER(13,2),
       DTL_AR_FEE          NUMBER(13,2),

     */
    util.InsertionOrderedHashMap iso=new util.InsertionOrderedHashMap();
    iso.put("DEP.▼","DTL_DEP_CODE");
    iso.put("COUNTRY▼","DTL_CNTY_PK");
    iso.put("DATE","DTL_DATE");
    iso.put("DR/CR NO","DTL_DRCR_NO");
    iso.put("佣金支出","DTL_COMM_FEE");
    iso.put(" 什 費 ","DTL_MISC_FEE");
    iso.put("樣品費","DTL_SMPL_FEE");
    iso.put("旅費","DTL_TRVL_FEE");
    iso.put("運費","DTL_TRNPORT_FEE");
    iso.put("交際費","DTL_SOCIAL_FEE");
    iso.put("電話費","DTL_TEL_FEE");
    iso.put("CLAIM","DTL_CLAIM_FEE");
    iso.put(" A/P ","DTL_AP_FEE");
    iso.put(" A/R ","DTL_AR_FEE");

    Hashtable ht=new Hashtable();
    Object rocDateVfy=exgui.verification.CellFormat.getDateStringFormaterAllowNull();
    Object decVfy=exgui.verification.CellFormat.getDoubleFormatAllowNull(10,2);
    Object chr10=exgui.verification.CellFormat.getOrdinaryField(20);
    ht.put("DATE",rocDateVfy);
    ht.put("DR/CR NO",chr10);
    ht.put("佣金支出",decVfy);
    ht.put(" 什 費 ",decVfy);
    ht.put("樣品費",decVfy);
    ht.put("旅費",decVfy);
    ht.put("運費",decVfy);
    ht.put("交際費",decVfy);
    ht.put("電話費",decVfy);
    ht.put("CLAIM",decVfy);
    ht.put(" A/P ",decVfy);
    ht.put(" A/R ",decVfy);
    //780 x 510
    pnlDb=new PnlOfsDtl(
      new XHandler(),
      20,iso,ht);
    pnlDb.setPreferredSize(new Dimension(780,490));
    pnl2PlaceGrid.add(pnlDb,BorderLayout.CENTER);
    pnlDb.firstPage();
  }
  void btnPast_actionPerformed(ActionEvent e) {
    pnlDb.doPast();
  }

  void btnCopy_actionPerformed(ActionEvent e) {
    pnlDb.doCopy();
  }
  void btnUpdate_actionPerformed(ActionEvent e) {
    try{
      pnlDb.getJtable().changeSelection(0,0,false,false);
      for(int i=0;i<pnlDb.getJtable().getRowCount();i++){
        //check if any field have to be add...
        Object objDep=((exgui.ultratable.Wraper4tblCbx)pnlDb.getJtable().getValueAt(i,0)).getValue();
        Object objCnty=((exgui.ultratable.Wraper4tblCbx)pnlDb.getJtable().getValueAt(i,1)).getValue();
       if(objDep==null)continue;
       if(objCnty==null){
         exgui.verification.VerifyLib.showAlert("Please Select A Country","Please Select A Country");
         pnlDb.getJtable().changeSelection(i,1,false,false);
         return;
       }
       if(pnlDb.getJtable().getValueAt(i,2)==null){
         exgui.verification.VerifyLib.showAlert("Please Input Date",
                                                "Please Select  Date");
         pnlDb.getJtable().changeSelection(i,1,false,false);
         return;
       }
       if(pnlDb.getJtable().getValueAt(i,3)==null || pnlDb.getJtable().getValueAt(i,3).toString().trim().length()==0){
         exgui.verification.VerifyLib.showAlert("Please Select DR/CR NO","Please Select  DR/CR NO");
         pnlDb.getJtable().changeSelection(i,3,false,false);
         return;
       }
       boolean hasNoFee=true;
       for(int j=4;j<14;j++){
         Object objFee=pnlDb.getJtable().getValueAt(i,j);
         if(objFee!=null && objFee.toString().trim().length()>0 && Double.parseDouble(objFee.toString())!=0){
           hasNoFee=false;
           break;
         }
       }
       if(hasNoFee){
         exgui.verification.VerifyLib.showAlert("請至少指定一款項",
                                                "請至少指定一款項");
         pnlDb.getJtable().changeSelection(i,4,false,false);
         return;
       }

      }
      pnlDb.doUpdate();
      //pnlDb.reload();
      exgui.verification.VerifyLib.showPlanMsg("新增完成","新增完成");
      btnExit_actionPerformed(null);
    }catch(Exception exp){
      exp.printStackTrace();
    }
  }

  void btnExit_actionPerformed(ActionEvent e) {
    try{
      processhandler.template.Properties.getCenteralControler().
          setDataProcesser(null);
      processhandler.template.Properties.getCenteralControler().goBack();
    }catch(Exception exp){
      exp.printStackTrace();
    }
  }
  class XHandler extends exgui.ultratable.PagedDataFactoryAdapter{
    Record recBlank;

   XHandler(){
     try{
       recBlank = exgui2.CONST.BASIC_MAIN_EJB.getBlankRecord("OFS_DEBIT_NOTE_DTL_tbl");
       recBlank.set("record_create_user",util.PublicVariable.USER_RECORD.get(0));
       recBlank.set("record_modify_user",util.PublicVariable.USER_RECORD.get(0));
       recBlank.set("record_delete_flag","1");
       recBlank.getModifiedFields().clear();
     }catch(Exception exp){
        exp.printStackTrace();
     }
   }
   public void updateRecords(Vector vct2update)throws Exception{
     newtimesejb.bank.OffShoreFacadeHome ejbHome=
         (newtimesejb.bank.OffShoreFacadeHome)
         info_ejb.WeblogicServiceLocator.locateServiceHome(
         util.PublicVariable.SERVER_URL,
         "newtimesejb.bank.OffShoreFacade");
     newtimesejb.bank.OffShoreFacade ejb=ejbHome.create();
     //ejb.updateCountry(vct2update);
     util.MiscFunc.showProcessingMessage();
     for(int i=0;i<vct2update.size();i++){
       Record rec=(Record)vct2update.get(i);
       ejb.insertRecord(rec);
     }
     util.MiscFunc.hideProcessingMessage();
   }
   public java.util.Vector getRecords(int bgn,int rowcount)throws Exception{
     Vector vct=new Vector();
     for(int i=1;i<20;i++){
       Record rec=(Record)util.MiscFunc.deepCopy(recBlank);
       rec.set(0,i*-1);
       vct.add(rec);
     }
     return vct;
   }
 }
 class PnlOfsDtl extends processhandler.template.PnlTableEditor  {
   PnlOfsDtl(PagedDataFactory pagedDataFxy,
     int rowCounts,util.InsertionOrderedHashMap columnMapping,
     java.util.Hashtable object2StringConvertor){
       super(pagedDataFxy,rowCounts,columnMapping,object2StringConvertor);
       getPanelContainsButtons().removeAll();
       getLowerRightPanel().add(btnPast);
       getLowerRightPanel().add(btnCopy);
       getLowerRightPanel().add(btnUpdate);
       getLowerRightPanel().add(btnExit);
       getJtable().setRowHeight(30);
   }

   public void makeTable(Vector vct){
     super.makeTable(vct);
     getJtable().getColumnModel().getColumn(0).setPreferredWidth(44);
     getJtable().getColumnModel().getColumn(1).setPreferredWidth(75);
     getJtable().getColumnModel().getColumn(2).setPreferredWidth(65);
     getJtable().getColumnModel().getColumn(3).setPreferredWidth(77);
     getJtable().getColumnModel().getColumn(4).setPreferredWidth(55);
     getJtable().getColumnModel().getColumn(5).setPreferredWidth(50);
     getJtable().getColumnModel().getColumn(6).setPreferredWidth(50);
     getJtable().getColumnModel().getColumn(7).setPreferredWidth(50);
     getJtable().getColumnModel().getColumn(8).setPreferredWidth(50);
     getJtable().getColumnModel().getColumn(9).setPreferredWidth(50);
     getJtable().getColumnModel().getColumn(10).setPreferredWidth(50);
     getJtable().getColumnModel().getColumn(11).setPreferredWidth(50);
     getJtable().getColumnModel().getColumn(12).setPreferredWidth(50);
     getJtable().getColumnModel().getColumn(13).setPreferredWidth(50);

   }

   protected  void refineEditors(MultiEditorJTable multiEditorJTableInSuper){
     multiEditorJTableInSuper.addJComboBox(0,vctDep,"DEP_CODE","DEP_CODE");
     multiEditorJTableInSuper.addJComboBox(1,vctCountry,"CNTY_NAME","CNTY_PK");
     multiEditorJTableInSuper.setTextEditorVerifiers(getObject2StringConvertor());
   }
   public void doPrint(){}
   protected Record setObject2Record(Record rec,int columnAt,Object value2update){
     try{
       rec.set(storedRecordColumn[columnAt],value2update);
       rec.set("record_create_user",util.PublicVariable.USER_RECORD.get(0));
       rec.set("record_modify_user",util.PublicVariable.USER_RECORD.get(0));
       return rec;
     }catch(Exception exp){
       exp.printStackTrace();
       return null;
     }
   }
   protected PagedDataFactory getPagedDataFactory(){return dbHandler;}
   protected util.InsertionOrderedHashMap getHeadColumnMap(){
      return tblHeadColumn;
   }
   protected java.util.Hashtable getObject2StringConvertor(){
     return klmObjKvtHt;
   }
   protected int getEachPageRowCount(){return 20;}

 }

}
