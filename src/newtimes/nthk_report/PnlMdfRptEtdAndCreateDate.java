package newtimes.nthk_report;

import java.awt.*;
import exgui.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.border.*;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class PnlMdfRptEtdAndCreateDate extends JPanel {
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel1 = new BlueBkgWhiteCharLabel();
  JButton btnExit = new JButton();
  JPanel pnlContainListPnl = new JPanel();
  Border border1;
  JTextField txtDate = new JTextField();
  JButton btnSet2RptEDT = new JButton();
  JButton btnSetCreateDate = new JButton();
  JLabel jLabel1 = new JLabel();
  PnlData2List pnl2Work;
  static String CAPTION_SHIP_NO=        "    SHIP   NO        ";
  static String CAPTION_SHIP_ETD=       "    ETD DATE         ";
  static String CAPTION_SHIP_CREATE=    "    CREATE DATE      ";
  static String CAPTION_SHIP_RPT_ETD=   "   REPORT ETD DATE   ";
  static String CAPTION_SHIP_RPT_CREATE="   REPORT CREATE DATE   ";
  exgui.DataBindTextWithChecker dbDate;
  JButton btnUpdate = new JButton();
  public PnlMdfRptEtdAndCreateDate() {
    try {
      util.InsertionOrderedHashMap iso=new util.InsertionOrderedHashMap();
      iso.put(CAPTION_SHIP_NO,"SHIP_NO");
      iso.put(CAPTION_SHIP_ETD,"SHIP_ETD_DATE");
      iso.put(CAPTION_SHIP_CREATE,"RECORD_CREATE_DATE");
      iso.put(CAPTION_SHIP_RPT_ETD,"SHIP_RPT_ETD");
      iso.put(CAPTION_SHIP_RPT_CREATE,"SHIP_RPT_CREATE");

      Object dateCnv=exgui.verification.CellFormat.getDateStringFormaterAllowNull();
      java.util.Hashtable ht=new java.util.Hashtable();
      ht.put(CAPTION_SHIP_ETD,dateCnv);
      //ht.put(CAPTION_SHIP_CREATE,dateCnv);
      ht.put(CAPTION_SHIP_RPT_ETD,dateCnv);
      ht.put(CAPTION_SHIP_RPT_CREATE,dateCnv);
      pnl2Work=
          new PnlData2List( new TempDbObj(),9999,iso,ht);
      jbInit();

    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }

  void jbInit() throws Exception {
    border1 = new EtchedBorder(EtchedBorder.RAISED,Color.white,new Color(134, 134, 134));
    blueBkgWhiteCharLabel1.setText("REPORT ETD & Report Create DATE MAINTAIN");
    blueBkgWhiteCharLabel1.setBounds(new Rectangle(0, 24, 801, 34));
    this.setLayout(null);
    btnExit.setBounds(new Rectangle(613, 533, 143, 31));
    btnExit.setFont(new java.awt.Font("Dialog", 1, 11));
    btnExit.setText("EXIT");
    btnExit.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnExit_actionPerformed(e);
      }
    });
    pnlContainListPnl.setBorder(border1);
    pnlContainListPnl.setBounds(new Rectangle(19, 80, 765, 420));
    pnlContainListPnl.setLayout(null);
    txtDate.setText("");
    txtDate.setBounds(new Rectangle(119, 503, 87, 22));
    btnSet2RptEDT.setBounds(new Rectangle(208, 503, 203, 25));
    btnSet2RptEDT.setFont(new java.awt.Font("Dialog", 1, 11));
    btnSet2RptEDT.setText("Set To Report ETD");
    btnSet2RptEDT.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnSet2RptEDT_actionPerformed(e);
      }
    });
    btnSetCreateDate.setText("Set To Report Create Date");
    btnSetCreateDate.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnSetCreateDate_actionPerformed(e);
      }
    });
    btnSetCreateDate.setBounds(new Rectangle(208, 534, 205, 25));
    btnSetCreateDate.setFont(new java.awt.Font("Dialog", 1, 11));
    jLabel1.setFont(new java.awt.Font("Dialog", 1, 11));
    jLabel1.setHorizontalAlignment(SwingConstants.CENTER);
    jLabel1.setText("DATE:");
    jLabel1.setBounds(new Rectangle(60, 503, 58, 21));
    btnUpdate.setBounds(new Rectangle(440, 503, 152, 25));
    btnUpdate.setFont(new java.awt.Font("Dialog", 1, 11));
    btnUpdate.setText("Confirm Update");
    btnUpdate.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnUpdate_actionPerformed(e);
      }
    });
    this.add(blueBkgWhiteCharLabel1, null);
    this.add(pnlContainListPnl, null);
    this.add(jLabel1, null);
    this.add(txtDate, null);
    this.add(btnSet2RptEDT, null);
    this.add(btnSetCreateDate, null);
    this.add(btnUpdate, null);
    this.add(btnExit, null);
    //pnlContainListPnl.removeAll();
    pnl2Work.setPreferredSize(new java.awt.Dimension(765,420));
    pnl2Work.setBounds(0,0,765,420);
    pnlContainListPnl.add(pnl2Work,null);
    pnl2Work.firstPage();
    Object dateVfy=exgui.verification.CellFormat.getDateStringFormaterAllowNull();
    dbDate=new exgui.DataBindTextWithChecker(txtDate,
                                "",
                                null,
                                10,
                                (exgui.Object2String) dateVfy,
                                (exgui.ultratable.CellTxtEditorFormat) dateVfy);

  }

  void btnExit_actionPerformed(ActionEvent e) {
    try{
      if(pnl2Work.isContextModified()){
        boolean result=exgui.verification.VerifyLib.showConfirm(
                                                 "Context Modified,But Not Confirmed Yet\nDo you really Want to exit ?",
                                                 "Context Modified",false);
        if(!result)return;
      }
      processhandler.template.Properties.getCenteralControler().goBack();
    }catch(Exception exp){
      exp.printStackTrace();
    }
   }
   class PnlData2List extends processhandler.template.PnlTableEditor{
     PnlData2List(exgui.ultratable.PagedDataFactory pagedDataFxy,
         int rowCounts, util.InsertionOrderedHashMap columnMapping,
         java.util.Hashtable object2StringConvertor
         ) {
       super(pagedDataFxy, rowCounts, columnMapping, object2StringConvertor);
     }
     public int getEachPageRowCount(){return 99999;}
     public java.util.Hashtable getObject2StringConvertor() {return klmObjKvtHt;}
     public util.InsertionOrderedHashMap getHeadColumnMap() {return tblHeadColumn;}
     public exgui.ultratable.PagedDataFactory getPagedDataFactory(){return dbHandler;}
     public void doPrint(){}
     public database.datatype.Record setObject2Record(database.datatype.Record rec,int column,Object obj ){
       try{
         rec.set(storedRecordColumn[column], obj);
         rec.set("record_modify_user",util.PublicVariable.USER_RECORD.get(0));
         rec.set("record_modify_date",new java.sql.Date(System.currentTimeMillis()));
         return rec;
       }catch(Exception exp){
         exp.printStackTrace();
         return null;
       }
     }
     public void refineEditors(exgui.ultratable.MultiEditorJTable mjtAtSuper){
       mjtAtSuper.setTextEditorVerifiers(getObject2StringConvertor());
       ((exgui.MultiClassTableModel)mjtAtSuper.getJTable().getModel()).removeEditableColumn(CAPTION_SHIP_ETD);
       ((exgui.MultiClassTableModel)mjtAtSuper.getJTable().getModel()).removeEditableColumn(CAPTION_SHIP_CREATE);
     }
   }
   class TempDbObj extends exgui.ultratable.PagedDataFactoryAdapter{
     public void updateRecords(java.util.Vector vct2update)throws Exception{
       try{
         util.MiscFunc.showProcessingMessage();
         newtimesejb.TPE_MIS.TpeMisFuncHome ejbHome=
             (newtimesejb.TPE_MIS.TpeMisFuncHome)
              info_ejb.WeblogicServiceLocator.locateServiceHome(util.PublicVariable.SERVER_URL,
              "newtimesejb.TPE_MIS.TpeMisFunc");
         newtimesejb.TPE_MIS.TpeMisFunc ejb=ejbHome.create();
         ejb.updateNthkRptEtdAndCreateDate(vct2update);
       }catch(Exception exp){
         exp.printStackTrace();
       }finally{
         util.MiscFunc.hideProcessingMessage();
       }
     }
     public java.util.Vector getRecords(int bgn,int rowcount)throws Exception{
       return exgui2.CONST.BASIC_MAIN_EJB.getDatas(
        util.PublicVariable.USER_RECORD,
        PnlQry4CreateRptDate.sql,bgn,rowcount);
     }
   }
  void setValueToTable(int column){
    if(txtDate.getText().length()==0){
      exgui.verification.VerifyLib.showAlert("Please Input Date",
                                             "Please Input Date");
      txtDate.grabFocus();
      return;
    }
    Object objDateValue=txtDate.getText();//dbDate.getSelectedValue();
    if(pnl2Work.getJtable().getSelectedRowCount()==0){
       exgui.verification.VerifyLib.showAlert("Please Select Rows","Please Select Rows");
       return;
    }else{
       int rowselected[]=pnl2Work.getJtable().getSelectedRows();
       for(int i=0;i<rowselected.length;i++){
         pnl2Work.getJtable().setValueAt(objDateValue,rowselected[i],column);
       }
    }
  }
  void btnSet2RptEDT_actionPerformed(ActionEvent e) {
    setValueToTable(3);
  }

  void btnSetCreateDate_actionPerformed(ActionEvent e) {
    setValueToTable(4);
  }

  void btnUpdate_actionPerformed(ActionEvent e) {
    try{
      pnl2Work.doUpdate();
      exgui.verification.VerifyLib.showPlanMsg("Update OK","UPDATE OK");
      pnl2Work.firstPage();
    }catch(Exception exp){

    }
  }
}
