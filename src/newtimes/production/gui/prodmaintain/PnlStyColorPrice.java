package newtimes.production.gui.prodmaintain;
import processhandler.template.PnlTableEditor;
import exgui.ultratable.*;
import database.datatype.*;
import util.InsertionOrderedHashMap;
import processhandler.*;
import java.util.Hashtable;
import newtimes.production.process.prodmaintain.*;
import java.util.Vector;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class PnlStyColorPrice extends PnlTableEditor
    implements
    java.awt.event.ItemListener,
    java.awt.event.ActionListener,
    javax.swing.event.TableModelListener{
    //java.awt.event.FocusListener{
  static String DISP_KLM_STYL=   "Style▼    ";
  static String DISP_KLM_STYL_PO="PO         ";
  static String DISP_KLM_LISNCE="Licensee▼";
  static String DISP_KLM_FOBPRX="Buyer Doc.\nPRICE";
  static String DISP_KLM_BUYER_ACTPRX="Buyer Act\nPRICE";
  static String DISP_KLM_MKR_ACTPRX="Maker Act\nPrice";
  static String DISP_KLM_MKR_DOCPRX="Maker Doc\nPrice";
  static String DISP_KLM_UNIT="UNIT";
  static String DISP_KLM_COLOR="  COLOR▼  ";
  static String DISP_KLM_QTY_OF_PRICE="QTY";
  //PRI_STY_SEQ, PRI_BYR_ACT_PRX, PRI_BYR_DOC_PRX, PRI_MKR_ACT_PRX, // PRI_MKR_DOC_PRX, PRI_UNIT, PROD_COLOR_PK, PRI_LICENSEE_NAME
  static String KLM_STYL="PRI_STY_SEQ";
  static String KLM_STYL_PO="STY_PO";
  static String KLM_LISNCE="PRI_LICENSEE_NAME";
  static String KLM_BUYER_ACTPRX="PRI_BYR_ACT_PRX";
  static String KLM_BUYER_DOCPRX="PRI_BYR_DOC_PRX";
  static String KLM_MKR_ACTPRX="PRI_MKR_ACT_PRX";
  static String KLM_MKR_DOCPRX="PRI_MKR_DOC_PRX";
  static String KLM_UNIT="STY_UNIT";
  static String KLM_COLOR="PROD_COLOR_PK";
  static String KLM_QTY_OF_PRICE="pri_total_qty";
  boolean isRefinding=false;
  Vector styleRecords=null;
  Vector colorRecords=null;
  Vector unitsRecords=null;
  Vector buyerLicensee=null;
  javax.swing.JComboBox styCbx=null;
  boolean  isComposed=false;
  boolean grabingFocus=false;
  java.util.HashMap stylePoMapping=new java.util.HashMap();
  java.util.Hashtable styleUnitMapping=new java.util.Hashtable();
  int xntEdtingRow;
  String prodCurrency;
  java.util.HashMap styleCtCurrency=new java.util.HashMap();
  static int sc_curr_at=-1;
  static int ct_curr_at=-1;

  public PnlStyColorPrice() {
    super();
    javax.swing.JButton xltDftFobPrx=new javax.swing.JButton("Re-calculate All Buyer Doc. Price by System");
    Record rec=newtimes.preproduction.Constants.SYSTEM_DEFAULT_RECORD;

    try{
      prodCurrency=
          (String)newtimes.preproduction.Constants.CURRENT_PREPROD_HEAD_RECORD.get("production_sc_currency");
      if(prodCurrency==null){
        exgui.verification.VerifyLib.showAlert("Please Assigne S/C currency in production head edting function",
                                               "Missing Production S/C currency");
      }
      if (rec.getFloat("FHA") == 0) {
        xltDftFobPrx.setEnabled(false);
      }
      database.datatype.Record recProd=
          newtimes.preproduction.Constants.CURRENT_PREPROD_HEAD_RECORD;
      int adtStatus=recProd.getInt("PRODUCTION_AUDIT_STATUS");
      if(adtStatus==newtimesejb.preproduction.PreProductionHead.AUDIT_STATUS_CONFIRMED||
         adtStatus==newtimesejb.preproduction.PreProductionHead.AUDIT_STATUS_PRINTED||
         adtStatus==newtimesejb.preproduction.PreProductionHead.AUDIT_STATUS_WAIT_CONFIRM){
        xltDftFobPrx.setEnabled(false);
      }
      java.util.Vector vctStyleCtCurrency=
          exgui2.CONST.BASIC_MAIN_EJB.getDatas(
          util.PublicVariable.USER_RECORD,
          "select sty_seq,STY_CT_CURRENCY from style where record_delete_flag='1' and PROD_HEAD_PK="+
          newtimes.preproduction.Constants.CURRENT_PREPROD_HEAD_RECORD.getInt(0)
          ,1,999999);
      for(int i=0;i<vctStyleCtCurrency.size();i++){
        Record recStyleCtCurrency=(Record)vctStyleCtCurrency.get(i);
         styleCtCurrency.put(recStyleCtCurrency.get(0).toString(),
                             recStyleCtCurrency.get(1).toString());
      }

    }catch(Exception e){
      e.printStackTrace();
    }
    xltDftFobPrx.addActionListener(this);
    super.getPanelContainsButtons().removeAll();
    super.getLowerRightPanel().add(xltDftFobPrx);
    getJtable().addMouseMotionListener(
      newtimes.production.ProdMaintain_Properties.getJTableToolTipGenerator(getJtable(),1));

  }
  /*
  protected boolean checkBuyerAct2MakerAct(int row_at,String buyerPrx){
    exgui.ultratable.Wraper4tblCbx rpwObj=(exgui.ultratable.Wraper4tblCbx )getJtable().getValueAt(row_at,0);
    String styCurr=(String)styleCtCurrency.get(rpwObj.getValue().toString());
      if(!prodCurrency.equalsIgnoreCase(styCurr))return true;
      float buyerActPrx=0;
      if(buyerPrx!=null&&(!buyerPrx.trim().equals(""))){
       buyerActPrx=Float.parseFloat(buyerPrx);
      }
      Object objMkrAct=getJtable().getValueAt(row_at,7);
      float mkrActPrx=0;
      if(objMkrAct!=null && objMkrAct.toString().trim().length()>0){
        mkrActPrx=Float.parseFloat(objMkrAct.toString());
      }
      if(mkrActPrx>buyerActPrx){
        boolean ask=
            exgui.verification.VerifyLib.showConfirm("Maker Actual Price Is Greater Than Buyer Actual Price\nDo You Sure",
                                                     "Maker Act. Price Greater Then Buyer Act. Price");
        return ask;
      }else{
        return true;
      }
  }
  protected boolean checkMakerAct2BuyerAct(int row_at,String makererPrx){
    exgui.ultratable.Wraper4tblCbx rpwObj=(exgui.ultratable.Wraper4tblCbx )getJtable().getValueAt(row_at,0);
    String styCurr=(String)styleCtCurrency.get(rpwObj.getValue().toString());
    if(!prodCurrency.equalsIgnoreCase(styCurr))return true;
    float makererActPrx=0;
    if(makererPrx!=null&&(!makererPrx.trim().equals(""))){
     makererActPrx=Float.parseFloat(makererPrx);
    }
    Object objBuyAct=getJtable().getValueAt(row_at,5);
    float buyActPrx=0;
    if(objBuyAct!=null && objBuyAct.toString().trim().length()>0){
      buyActPrx=Float.parseFloat(objBuyAct.toString());
    }
    if(makererActPrx>buyActPrx){
      boolean ask=
          exgui.verification.VerifyLib.showConfirm("Maker Actual Price Is Greater Than Buyer Actual Price\nDo You Sure",
                                                   "Maker Act. Price Greater Then Buyer Act. Price");
      return ask;
    }else{
      return true;
    }

  }*/

  protected Record setObject2Record(Record rec, int columnAt, Object value2update) {
    /**@todo Implement this exgui.ultratable.AbstractUltraTablePanel abstract method*/
    //throw new java.lang.UnsupportedOperationException("Method setObject2Record() not yet implemented.");
    try{
      String columnName=storedRecordColumn[columnAt];
      if(columnName.equalsIgnoreCase("STY_PO")) return null;//this column is no need to update,just for display
      if(columnName.equalsIgnoreCase("STY_UNIT")) return null;//this column is no need to update,just for display
      rec.set(columnName,value2update);
      return rec;
    }catch(Exception e){
      e.printStackTrace();
      return null;
    }
  }

  public void actionPerformed(java.awt.event.ActionEvent  event){
    if(!exgui.verification.VerifyLib.showConfirm(
        "This will re-set all Price fields to default FOB price\nAre You Sure ?",
        "Using Default FOB Price"))return;
    try{
       java.util.HashMap dftFobPrxMap=((DB_StyleColorPrice)dbHandler).getDefaultFobPrx();
       javax.swing.JTable xTbl=getJtable();
       for(int i=0;i<xTbl.getRowCount();i++){
         String stySeqStr=((exgui.ultratable.Wraper4tblCbx)xTbl.getModel().getValueAt(i,0)).getValue().toString();
         String dftPrxStr=dftFobPrxMap.get(stySeqStr).toString();
         xTbl.setValueAt(dftPrxStr,i,4);xTbl.setValueAt(dftPrxStr,i,5);
         xTbl.setValueAt(dftPrxStr,i,6);xTbl.setValueAt(dftPrxStr,i,7);
       }
       exgui.verification.VerifyLib.showPlanMsg("Default Buyer Doc Price Caculate OK","Buyer Doc Price OK");
    }catch(newtimesejb.production.FirstFbkPrxIsZero firsFbxzero){
      exgui.verification.VerifyLib.showAlert("Fabric Price Of 1st PO Can Not Be Zero",
                                             "Fabric Price Of 1st PO Can Not Be Zero");
      return;
    }catch(Exception exp){
       exp.printStackTrace();
       exgui.verification.VerifyLib.showAlert(
          "Server Side Error Or Connection Error\nPlease Notify System Manager",
          "Error While Generating Default FOB Price");
    }
  }
  protected InsertionOrderedHashMap getHeadColumnMap() {
    /**@todo Implement this exgui.ultratable.AbstractUltraTablePanel abstract method*/
    //throw new java.lang.UnsupportedOperationException("Method getHeadColumnMap() not yet implemented.");
    InsertionOrderedHashMap iso=new InsertionOrderedHashMap();
    iso.put(DISP_KLM_STYL,KLM_STYL);
    iso.put(DISP_KLM_STYL_PO,KLM_STYL_PO);
    //iso.put(DISP_KLM_LISNCE,KLM_LISNCE);
    iso.put(DISP_KLM_COLOR,KLM_COLOR);
    iso.put("CUSTOMER\nPO","PCIX");
    iso.put("CUST\nSTYLE","CUST_STY");
    /*
    iso.put(DISP_KLM_FOBPRX,KLM_FOBPRX);
    iso.put(DISP_KLM_BUYER_DOCPRX,KLM_BUYER_DOCPRX);
    */
    iso.put(DISP_KLM_FOBPRX,KLM_BUYER_DOCPRX);
    iso.put(DISP_KLM_BUYER_ACTPRX,KLM_BUYER_ACTPRX);

    iso.put(DISP_KLM_MKR_DOCPRX,KLM_MKR_DOCPRX);
    iso.put(DISP_KLM_MKR_ACTPRX,KLM_MKR_ACTPRX);
    iso.put(DISP_KLM_UNIT,KLM_UNIT);
    iso.put(DISP_KLM_QTY_OF_PRICE,KLM_QTY_OF_PRICE);
    return iso;
  }
  public void doUpdate() throws Exception{
    if(isMakerActPrxGreaterBuyerActPrx())return;
    super.doUpdate();
    this.reload();
    table_snapshot=util.MiscFunc.table2Text(getJtable());
  }
  public void doPrint() throws java.lang.Exception {
    /**@todo Implement this processhandler.DataProcesser abstract method*/
  }
  protected boolean isMakerActPrxGreaterBuyerActPrx()throws Exception{
    int buyerActPrxAt=6;
    int makerActPrxAt=8;
    getJtable().editCellAt(-1,0);//force editor to lose focus
    for( int i=0;i<getJtable().getRowCount();i++){
      float byrActPrx=0;
      Record recPrice=(Record)getDisplayingRecords().get(i);
      if(sc_curr_at==-1){
        sc_curr_at=util.MiscFunc.getFieldIndexAtRecord(recPrice,"SC_CURRENCY");

      }
      if(ct_curr_at==-1){
        ct_curr_at=util.MiscFunc.getFieldIndexAtRecord(recPrice,"CT_CURRENCY");
      }
      String SC_CURR=(String)recPrice.get(sc_curr_at);
      String CT_CURR=(String)recPrice.get(ct_curr_at);
      if(!SC_CURR.equals(CT_CURR)){
        return false;
      }

      Object objByrAct=getJtable().getValueAt(i,buyerActPrxAt);
      if(objByrAct!=null && objByrAct.toString().trim().length()>0){
        byrActPrx=Float.parseFloat(objByrAct.toString());
      }

      float mkrActPrx=0;
      Object objMkrAct=getJtable().getValueAt(i,makerActPrxAt);
      if(objMkrAct!=null && objMkrAct.toString().trim().length()>0){
        mkrActPrx=Float.parseFloat(objMkrAct.toString());
      }

      Object objMkrDocPrx=getJtable().getValueAt(i,makerActPrxAt-1);
      float mkrDocPrx=Float.parseFloat((objMkrDocPrx==null||objMkrDocPrx.toString().trim().equals(""))?"0":objMkrDocPrx.toString());
      Object objByrDocPrx=getJtable().getValueAt(i,buyerActPrxAt-1);
      float byrDocPrx=Float.parseFloat((objByrDocPrx==null||objByrDocPrx.toString().trim().equals(""))?"0":objByrDocPrx.toString());
/*
      if(mkrDocPrx>(mkrActPrx*3) || mkrActPrx>(mkrDocPrx*3)){
        exgui.verification.VerifyLib.showAlert("Price Difference Too Much","Price Difference Too Much");
        getJtable().changeSelection(i,makerActPrxAt,false,false);
        return true;
      }

      if(byrDocPrx>(byrActPrx*3) || byrActPrx>(byrDocPrx*3)){
        exgui.verification.VerifyLib.showAlert("Price Difference Too Much","Price Difference Too Much");
        getJtable().changeSelection(i,buyerActPrxAt,false,false);
        return true;
      }


      if(mkrActPrx>byrActPrx){
        boolean alwaysConfirm=
            exgui.verification.VerifyLib.showConfirm("Maker Actual Price Is Greater Than Buyer Actual Price\nDo You Sure ?",
                                                     "Maker Act. Price Greater Then Buyer Act. Price");
       if(alwaysConfirm){
         return false;
       }else{
         return true;
       }
      }
*/
    }
    return false;
  }
  protected void refineEditors(MultiEditorJTable multiEditorJTableInSuper) {
    // /**@todo Implement this exgui.ultratable.AbstractUltraTablePanel abstract method*/
    DB_StyleColorPrice mydbHandler=(DB_StyleColorPrice)dbHandler;
    //unitsRecords=mydbHandler.UnitsData;
    styleRecords=mydbHandler.SytlesAndPo;
    colorRecords=mydbHandler.ProdColors;
    buyerLicensee=mydbHandler.LicenseeData;

    isRefinding=true;
    multiEditorJTableInSuper.addJComboBox(0,styleRecords,"STY_STYLE","STY_SEQ");
    //multiEditorJTableInSuper.addJComboBox(2,buyerLicensee,"BYMKR_BRIEF","BYMKR_SEQ");
    multiEditorJTableInSuper.addJComboBox(2,colorRecords,"PROD_COLOR_NAME","PROD_COLOR_PK");
    //multiEditorJTableInSuper.addJComboBox(8,unitsRecords,"UNIT","UNIT");
    isRefinding=false;
    multiEditorJTableInSuper.setTextEditorVerifiers(getObject2StringConvertor());
    //if(!isComposed){
      javax.swing.DefaultCellEditor tce = (javax.swing.DefaultCellEditor)
          multiEditorJTableInSuper.getJTable().getColumnModel().getColumn(0).
          getCellEditor();
       styCbx = (javax.swing.JComboBox) tce.getComponent();
       //styCbx.addItemListener(this);
       //styCbx.addFocusListener(this);
       try{
       for(int i=0;i<styleRecords.size();i++){
          Integer intObj=new Integer(((database.datatype.Record)styleRecords.get(i)).getInt("STY_SEQ"));
          stylePoMapping.put(intObj,
                             ((database.datatype.Record)styleRecords.get(i)).get(2));
          styleUnitMapping.put(intObj,
                             ((database.datatype.Record)styleRecords.get(i)).get(3));


         }
       }catch (Exception e) {
          e.printStackTrace();
       }

       getJtable().getModel().addTableModelListener(this);
    //}
      try{
        //if (newtimes.production.ProdMaintain_Properties.isProductionAuditConfirmedOrPrinted()) {
        if (!newtimes.production.ProdMaintain_Properties.isAbleToEdit()) {
          /*
          if (util.PublicVariable.USER_RECORD.getInt("USR_TYPE") !=newtimesejb.preproduction.PreProductionHead.  USER_TYPE_SUPERVIOSER_MIS
              && util.PublicVariable.OPERATTING_CENTER.equals("001")) {*/

            //remove editable if confirmed/printed.
            //PRI_BYR_ACT_PRX, PRI_BYR_DOC_PRX, PRI_MKR_ACT_PRX, PRI_MKR_DOC_PRX
            exgui.MultiClassTableModel mdl =
                (exgui.MultiClassTableModel)multiEditorJTableInSuper.getJTable().
                getModel();
            mdl.removeEditableColumn(DISP_KLM_BUYER_ACTPRX);
            mdl.removeEditableColumn(DISP_KLM_FOBPRX);
            mdl.removeEditableColumn(DISP_KLM_MKR_ACTPRX);
            mdl.removeEditableColumn(DISP_KLM_MKR_DOCPRX);
          //}


        }
      }catch(Exception exp){
         exp.printStackTrace();
      }
     isComposed=true;
   }
   public void doCopy(){
     if(getJtable().getSelectedRow()<0){
       exgui.verification.VerifyLib.showPlanMsg(
       "Please Select A Row To Copy","Please Select A Row");
       return;
     }
     int selectedRow=getJtable().getSelectedRow();
     copiedColumns=new Object[5];//new Object[4];
     //for(int i=4;i<copiedColumns.length+4;i++){
     for(int i=3;i<copiedColumns.length+3;i++){
       //copiedColumns[i-4]=
       copiedColumns[i-3]=
         getJtable().getValueAt(
         selectedRow,i
        );
     }
     try{
       util.ApplicationProperites.setProperties(
         id4ApplicationProperties,
         util.MiscFunc.deepCopy(copiedColumns)
       );
     }catch(Exception e){
        e.printStackTrace();
     }
   }

   public void doPaste() {
     Object storedObj = util.ApplicationProperites.getProperties(
         id4ApplicationProperties
         );
     if (storedObj == null) {
       exgui.verification.VerifyLib.showPlanMsg(
           "No Copied Data To Paste", "No Copied Data To Paste");
       return;
     }
     if (getJtable().getSelectedRow() < 0) {
       exgui.verification.VerifyLib.showPlanMsg(
           "Please Select A Row To Paste Copied Data", "Please Select A Row");
       return;
     }
     int selectedRow[] = getJtable().getSelectedRows();
     if (super.getJtable().getCellEditor() != null)
       super.getJtable().getCellEditor().cancelCellEditing();
     copiedColumns = (Object[]) storedObj;
     for (int i = 0; i < copiedColumns.length; i++) {
       for(int j=0;j<selectedRow.length;j++){
         if(getJtable().getModel().isCellEditable(selectedRow[j], i+3)){
           getJtable().setValueAt(
               copiedColumns[i],
               selectedRow[j], i + 3
               );
         }
       }
     }

     /*
     for (int i = 0; i < copiedColumns.length; i++) {
       for(int j=0;j<selectedRow.length;j++){
         if(getJtable().getModel().isCellEditable(selectedRow[j], i+4)){
           getJtable().setValueAt(
               copiedColumns[i],
               selectedRow[j], i + 4
               );
         }
       }
     }
     */
   }

   public void doDelete() throws Exception{
     try{
       int rows[] = getJtable().getSelectedRows();
       if (rows.length == 0) {
         exgui.verification.VerifyLib.showPlanMsg(
             "Please Select Row(s) To Delete", "Please Select Row(s) To Delete");
         return;
       }
       if(!exgui.verification.VerifyLib.showConfirm("Are You Sure To Delete These Rows?","Are You Sure ?"))return;
       newtimes.production.ProdMaintain_Properties.setWaitCursor();
       Vector recrods = new Vector();
       for (int i = 0; i < rows.length; i++) {
         database.datatype.Record rec =
             (database.datatype.Record) _displayingRecords.get(rows[i]);
         recrods.add(rec);
       }
       ( (DB_StyleColorPrice) dbHandler).doDeleteRows(recrods);
       this.reload();
       exgui.verification.VerifyLib.showPlanMsg("Delete OK","Delete OK");
     }catch(Exception e){
       exgui.verification.VerifyLib.showAlert("Delete Fail!!\nPlease Contact System Manager","Delete Fail!!");
       throw e;
     }finally{
       newtimes.production.ProdMaintain_Properties.setNormalCursor();
     }
   }
   public void tableChanged(javax.swing.event.TableModelEvent te){
     super.tableChanged(te);
     if(te.getColumn()!=0)return;
     int row=te.getFirstRow();
     int col=te.getColumn();
     System.out.println(" event in style Color Price "+"obj in row,col is "+getJtable().getValueAt(row,col).getClass().getName());

     if(getJtable().getValueAt(row,col) instanceof exgui.ultratable.Wraper4tblCbx){
     exgui.ultratable.Wraper4tblCbx valueObj=
         (exgui.ultratable.Wraper4tblCbx)getJtable().getValueAt(row,col);
     Integer intObj=new Integer(valueObj.getValue().toString());
     getJtable().setValueAt(stylePoMapping.get(intObj),row,1);
     getJtable().setValueAt(styleUnitMapping.get(intObj),row,8);
     }
   }
   /*
   public void focusGained(java.awt.event.FocusEvent e){
      grabingFocus=true;
      xntEdtingRow=getJtable().getSelectedRow();
   }
   public void focusLost(java.awt.event.FocusEvent e){

   }
   */
   public void itemStateChanged(java.awt.event.ItemEvent e){
     //if(!isRefinding){
     /*
     if(grabingFocus){
        grabingFocus=false;
        return;
     }*/
     if(isComposed){
      int slkAt=styCbx.getSelectedIndex();
      if(slkAt<0) slkAt=0;
        //style record is contains style seq,style no,style po. and sty unit.
      database.datatype.Record rec=(database.datatype.Record)styleRecords.get(slkAt);
      int editingRow=getJtable().getSelectedRow();
      System.out.println("editing row is:"+editingRow);
      getJtable().setValueAt(rec.get(2),editingRow,1);
      getJtable().setValueAt(rec.get(3),editingRow,8);
     }
   }
  protected int getEachPageRowCount() {
    /**@todo Implement this exgui.ultratable.AbstractUltraTablePanel abstract method*/
    //throw new java.lang.UnsupportedOperationException("Method getEachPageRowCount() not yet implemented.");
    return 99999;
  }
  protected Hashtable getObject2StringConvertor() {
    /**@todo Implement this exgui.ultratable.AbstractUltraTablePanel abstract method*/
    //throw new java.lang.UnsupportedOperationException("Method getObject2StringConvertor() not yet implemented.");
    Object flt33cnv=new FormaterPrx();//exgui.verification.CellFormat.getDoubleFormat(3,3);
     Hashtable ht=new Hashtable();
     ht.put(DISP_KLM_FOBPRX,new VfyFOBPrx());
     ht.put(DISP_KLM_BUYER_ACTPRX,new BuyActPrxVfy());
     ht.put(DISP_KLM_MKR_ACTPRX,flt33cnv);
     ht.put(DISP_KLM_MKR_DOCPRX,flt33cnv);
     Object objVfyCustPo= exgui.verification.CellFormat.getOrdinaryField(15);
     Object objVfyCustSty = exgui.verification.CellFormat.getOrdinaryField(25);

      ht.put("CUSTOMER\nPO",objVfyCustPo);
      ht.put("CUST\nSTYLE",objVfyCustSty);
    return ht;
  }
  protected PagedDataFactory getPagedDataFactory() {
    /**@todo Implement this exgui.ultratable.AbstractUltraTablePanel abstract method*/
    //throw new java.lang.UnsupportedOperationException("Method getPagedDataFactory() not yet implemented.");
    DB_StyleColorPrice dbObj=new DB_StyleColorPrice();
    dbHandler =dbObj;
    return dbObj;
  }
 class FormaterPrx implements exgui.ultratable.CellTxtEditorFormat,exgui.Object2String{
   Object orgFvyObj=null;
   public FormaterPrx(){
     orgFvyObj=exgui.verification.CellFormat.getDoubleFormat(7,2);
   }
   public exgui.ultratable.KeyProcess getKeyListener(){
     return ((exgui.ultratable.CellTxtEditorFormat)orgFvyObj).getKeyListener();
   }

   public int getMaxLength(){
     return ((exgui.ultratable.CellTxtEditorFormat)orgFvyObj).getMaxLength();
   }
   public String formatPromptMsg(){return ((exgui.ultratable.CellTxtEditorFormat)orgFvyObj).formatPromptMsg();}
   public boolean isFormatValid(String inStr,int row,int column){
     if(inStr==null||inStr.trim().length()==0)return true;
     if(!((exgui.ultratable.CellTxtEditorFormat)orgFvyObj).isFormatValid(inStr,row,column))return false;
     if(column!=7)return true;//7th col is maker actual price
     //return checkMakerAct2BuyerAct(row,inStr);
     return true;
     //if currency of production and C/T terms's currency are same,alert user if maker act. price>buyer act.price
   }
   public String Obj2String(Object obj2kvt){
     if(obj2kvt==null)return "";
     if(Float.parseFloat(obj2kvt.toString())==0)return "";
     return ((exgui.Object2String)orgFvyObj).Obj2String(obj2kvt);
   }
    public Object cellStringToObject(String String2kvt){
      if(String2kvt==null)return new Float(0);
      if(String2kvt.trim().equals(""))return new Float(0);
      return ((exgui.ultratable.CellTxtEditorFormat)orgFvyObj).cellStringToObject(String2kvt);
    }
 }

  public boolean isInitOk(){return ((DB_StyleColorPrice)dbHandler).isInitOk();}
  /*
   連動jtable column:
   User 輸入FOB Price 之後，若是後面三個Price都沒有輸入任何值， 則自動帶出與FOB同樣的Price值。
   如果Buyer Act Price 有更改，則觸發另一個事件，讓Maker Act Price 的值也改成 與Buyer Act Price相同 。
  */

 class VfyFOBPrx implements exgui.ultratable.CellTxtEditorFormat,exgui.Object2String{
  Object orgFvyObj=null;
  public VfyFOBPrx(){
    orgFvyObj=new FormaterPrx();
  }
  public int getMaxLength(){
    return ((exgui.ultratable.CellTxtEditorFormat)orgFvyObj).getMaxLength();
  }
  public exgui.ultratable.KeyProcess getKeyListener(){
    return ((exgui.ultratable.CellTxtEditorFormat)orgFvyObj).getKeyListener();
  }

  public String formatPromptMsg(){return ((exgui.ultratable.CellTxtEditorFormat)orgFvyObj).formatPromptMsg();}
  public boolean isFormatValid(String inStr,int row,int column){
    boolean isVld= ((exgui.ultratable.CellTxtEditorFormat)orgFvyObj).isFormatValid(inStr,row,column);
    if(!isVld)return isVld;
    //test if have to modify the remain 3 column.
    for(int i=5;i<8;i++){
      Object value=getJtable().getValueAt(row,i);
      if(value==null||
         value.toString().trim().length()==0||
         value.toString().trim().equals("0")){
        getJtable().setValueAt(inStr,row,i);
      }
    }
    return isVld;
  }
  public String Obj2String(Object obj2kvt){
    return ((exgui.Object2String)orgFvyObj).Obj2String(obj2kvt);
  }
   public Object cellStringToObject(String String2kvt){
     return ((exgui.ultratable.CellTxtEditorFormat)orgFvyObj).cellStringToObject(String2kvt);
   }

 }
 class BuyActPrxVfy extends VfyFOBPrx{
   public boolean isFormatValid(String inStr,int row,int column){
     boolean isVld= ((exgui.ultratable.CellTxtEditorFormat)orgFvyObj).isFormatValid(inStr,row,column);
     if(!isVld)return isVld;
     //if(!checkBuyerAct2MakerAct(row,inStr))return false;
     //test if have to modify the remain 3 column.
       Object value=getJtable().getValueAt(row,7);
       if(value==null||
          value.toString().trim().length()==0||
          value.toString().trim().equals("0")){
         getJtable().setValueAt(inStr,row,7);
       }
     return isVld;
   }
 }
}
