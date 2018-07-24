package newtimes.production.gui.prodmaintain;
import processhandler.template.PnlTableEditor;
import exgui.ultratable.*;
import database.datatype.*;
import util.InsertionOrderedHashMap;
import java.util.Hashtable;
import java.util.HashMap;
import newtimes.production.process.prodmaintain.*;
import java.util.Vector;
import javax.swing.JTable;
import java.awt.Cursor;
import exgui.chaindialog.*;
/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class Pnl_Trinity_PriceSizeQtyList extends PnlTableEditor
    implements javax.swing.event.TableModelListener{
  protected HashMap backupedSizeQty=new HashMap();
  protected String testUnit=null;
  protected String getDoubleCammaHeasColumn[]=null;
  protected boolean initializing=false;
  protected boolean _tableProcessingChange=false;
  protected boolean _isTblValid=false;
  protected int priceColumnAt=5;
  protected Cursor ksr=null;
  protected boolean isOnlyOneEditingCell=false;
  protected  javax.swing.JButton btnRedefineSize=new javax.swing.JButton("Re-Define Size");
  protected  javax.swing.JButton btnFillPrx=new javax.swing.JButton("Fill All Price");
  protected javax.swing.JPanel pnlBlank=new javax.swing.JPanel();
  protected Vector priceVct=null;
  protected Vector licenseeVct=null;
  protected Vector colorVct=null;
  boolean isRefinding=false;
  Vector licenseeColorsPrice=null;
  int handler2remove_count=0;
  java.text.DecimalFormat formatter = null;//new java.text.DecimalFormat("######.###");
  java.text.DecimalFormat Dzformatter = null;//new java.text.DecimalFormat("######.###");
  protected int orgSizeType=0;
  protected String orgCammaedColumnsDefString=null;
  protected String importHeadColumn[]=null;

  protected static String DISP_KLM_BUYER_ACTPRX="Buyer\nAct.\nPrice";
  protected static String DISP_KLM_FOBPRX="Buyer\nDoc.\nPrice";
  protected static String DISP_KLM_MKR_ACTPRX="Maker\nAct.\nPrice";
  protected static String DISP_KLM_MKR_DOCPRX="Maker\nDoc.\nPrice";
  protected String prodCurrency;
  protected String styleCtCurrency;
  boolean isScCtCurrencyDiff=true;
  public Pnl_Trinity_PriceSizeQtyList() {
    super.jbtn1st.setVisible(false);
    super.jbtnLast.setVisible(false);
    super.jbtnNext.setVisible(false);
    super.jbtnPrev.setVisible(false);
    pnlBlank.setLayout(null);

    java.awt.FlowLayout flout=new java.awt.FlowLayout();
    super.getLowerRightPanel().setLayout(flout);
    super.getLowerRightPanel().add(btnFillPrx,null);
    btnFillPrx.addMouseListener(new FillPrxMouseListener());
    pnlBlank.setPreferredSize(new java.awt.Dimension(250,(int)btnFillPrx.getSize().getHeight()));
    getLowerRightPanel().add(pnlBlank);
    super.getLowerRightPanel().add(btnRedefineSize,null);
    btnRedefineSize.addMouseListener(new myMouseListener());



    priceVct=((DB_Trinity_PriceSizeQty)dbHandler).Prices;
    licenseeVct=((DB_Trinity_PriceSizeQty)dbHandler).Licensees;
    colorVct=((DB_Trinity_PriceSizeQty)dbHandler).ProdColors;
    formatter=new java.text.DecimalFormat("#######.##");
    Dzformatter=new java.text.DecimalFormat("######0.00");
    try{
      styleCtCurrency = (String)newtimes.production.ProdMaintain_Properties.
          EDITING_STYLE_RECORD.get("sty_ct_currency");
      prodCurrency =
          (String)newtimes.preproduction.Constants.CURRENT_PREPROD_HEAD_RECORD.
          get("production_sc_currency");
      isScCtCurrencyDiff=!styleCtCurrency.equals(prodCurrency);
    }catch(Exception exp){
      exp.printStackTrace();

    }

  }
  protected class FillPrxMouseListener extends java.awt.event.MouseAdapter {
    public void mouseClicked(java.awt.event.MouseEvent me){
      if(!btnFillPrx.isEnabled())return;
      javax.swing.JTextField  pf = new javax.swing.JTextField();
      Object[] message = new Object[] {"Please Input Price to fill\nBlank To Cancel", pf};
      Object[] options = new String[] {"OK"};
      javax.swing.JOptionPane op = new javax.swing.JOptionPane(
             message, javax.swing.JOptionPane.PLAIN_MESSAGE,
             javax.swing.JOptionPane.OK_CANCEL_OPTION, null, options);
      javax.swing.JDialog dialog = op.createDialog(null, "Please Input Price to fill");
      dialog.show();

      String price2filledStr=pf.getText();
      if(price2filledStr.trim().length()==0)return;
      //final row is total qty row,skip it
      try{
        double prx2fill= Double.parseDouble(price2filledStr);
      }catch(java.lang.NumberFormatException ne){
        exgui.verification.VerifyLib.showAlert("Number Format Error","price2filledStr");
        return;
      }
      for(int i=0;i<getJtable().getRowCount()-1;i++){
        for(int j=priceColumnAt;j >= priceColumnAt-3;j--){
          getJtable().setValueAt(price2filledStr,i,j);
        }
      }
    }
  }
 protected class myMouseListener extends java.awt.event.MouseAdapter {
    public void mouseClicked(java.awt.event.MouseEvent e){
      String result=null;
      if(!btnRedefineSize.isEnabled())return;
     try{
       newtimes.production.ProdMaintain_Properties.setWaitCursor();
       if(
         !exgui.verification.VerifyLib.showConfirm(
           "Note!!Re-Define Size Columns Will Delete All Defined QTY Data Of This Style\nAre Your Sure ?"
           ,"Are Your Sure?"))return;
       result=defineStyeColorQtyType();
       if("NO".equals(result)){
              //back to last process.
              //processhandler.template.Properties.getCenteralControler().goBack();
              return;
       }
      }catch(Exception exp){
        exp.printStackTrace();
        return ;
      }finally{
        newtimes.production.ProdMaintain_Properties.setNormalCursor();
      }

      try{
        newtimes.production.process.prodmaintain.ToListStyQty
            toListQTY = new
            newtimes.production.process.prodmaintain.ToListStyQty();
        toListQTY.toListStyQty();
        if("OK_AND_RELOAD".equals(result)){
          try {
            processhandler.template.Properties.getCenteralControler().
                getDataProcesser().doUpdate();
          } catch (Exception iie) {
            iie.printStackTrace();
            util.ExceptionLog.exp2File(iie,
                "exception while attemp to update record.");
            exgui.verification.VerifyLib.showAllert("Update Fail!!");
          }
        }


      }catch(processhandler.commands.CommandIncompleteException cie){

      }catch(Exception exp){
        exp.printStackTrace();
        util.ExceptionLog.exp2File(exp,"");
        exgui.verification.VerifyLib.showAlert("Error in listStyleQty",
                                               "Error in list Style Qty");
      }

    }
  }
  public boolean isIniOK(){
    return ((DB_Trinity_PriceSizeQty)dbHandler).isDBHandlerInitOK();
  }
  protected Record setObject2Record(Record rec, int columnAt, Object value2update) {
   return null;
  }
  protected InsertionOrderedHashMap getHeadColumnMap() {



    String TOTAL_COLUMN_TTILE="TOTAL";
    try{

      InsertionOrderedHashMap iso=new InsertionOrderedHashMap();
      /*
      System.out.println("stored sqty type="+newtimes.production.ProdMaintain_Properties.EDITING_STYLE_RECORD.getInt("STY_QTY_TYPE"));
      if((newtimes.production.ProdMaintain_Properties.EDITING_STYLE_RECORD.getInt("STY_QTY_TYPE")&0x01) == 1){
          System.out.println("set licensee to head column");
          iso.put("LICENSEE ¡¿", "$$PRI_LICENSEE_NAME");
          priceColumnAt=5;
      }else{
         System.out.println("remove  licensee from head column");
          priceColumnAt=4;
      }*/
      int pri_col_begn = 0;
      if ((newtimes.production.ProdMaintain_Properties.EDITING_STYLE_RECORD.
           getInt("STY_QTY_TYPE") & 0x01) !=0) {
         //with licensee column
         iso.put("LICENSEE ¡¿", "$$PRI_LICENSEE_NAME");
         pri_col_begn++;
      }
      if ((newtimes.production.ProdMaintain_Properties.EDITING_STYLE_RECORD.
           getInt("STY_QTY_TYPE") & 0x04) !=0) {
         //with color
         iso.put("COLOR ¡¿","$$PROD_COLOR_PK");
         pri_col_begn++;
      }
      priceColumnAt=pri_col_begn+3;

      iso.put(DISP_KLM_FOBPRX ,"$$PRI_BYR_DOC_PRX");
      iso.put(DISP_KLM_BUYER_ACTPRX ,"$$PRI_BYR_ACT_PRX");
      iso.put(DISP_KLM_MKR_DOCPRX,"$$PRI_MKR_DOC_PRX");
      iso.put(DISP_KLM_MKR_ACTPRX,"$$PRI_MKR_ACT_PRX");

      String sizeColumns=
          (String)newtimes.production.ProdMaintain_Properties.EDITING_STYLE_RECORD.get("STY_SIZE_COLUMN");
       if(sizeColumns==null)sizeColumns="";
       //----------for future to compare----------
       orgCammaedColumnsDefString=sizeColumns;
       //System.out.println("orgCammaedColumnsDefString phase 1 is:"+orgCammaedColumnsDefString);
       //----------for future to compare----------
       importHeadColumn=util.MiscFunc.split(sizeColumns,",,");
       if(importHeadColumn.length==1 && importHeadColumn[0].trim().length()==0){
         importHeadColumn=new String[]{};
         isOnlyOneEditingCell=true;
         TOTAL_COLUMN_TTILE="QTY";
       }


       if(importHeadColumn.length>0){
         //there are some column of size type to mapping
         for(int i=0;i<importHeadColumn.length;i++){
           iso.put(importHeadColumn[i],"##"+importHeadColumn[i]);
         }
       }
       iso.put(TOTAL_COLUMN_TTILE,"_TOTAL_VALUE");
       return iso;
    }catch(Exception e){
      e.printStackTrace();
      return null;
    }

  }
  public void doPrint() throws java.lang.Exception {
  }
  protected void refineEditors(MultiEditorJTable multiEditorJTableInSuper) {
    initializing=true;
   // if(licenseeColorsPrice==null) licenseeColorsPrice=((DB_Trinity_PriceSizeQty)dbHandler).getClrLxyPrxs();
   DB_Trinity_PriceSizeQty mydbHandler=(DB_Trinity_PriceSizeQty)dbHandler;
   //unitsRecords=mydbHandler.UnitsData;
   Vector colorRecords=mydbHandler.ProdColors;
   Vector  buyerLicensee=mydbHandler.Licensees;

    try{
      isRefinding=true;
      determPricColPosition();
      int qtySizeType=newtimes.production.ProdMaintain_Properties.EDITING_STYLE_RECORD.
           getInt("STY_QTY_TYPE");
       exgui.ultratable.Wraper4tblCbx liceseeObj,colorObj;
        switch(qtySizeType){
          case 7:
          case 5:
          case 13:
            //bit 0,and bit 2 on
            multiEditorJTableInSuper.addJComboBox(0,buyerLicensee,"BYMKR_BRIEF","BYMKR_SEQ");
            multiEditorJTableInSuper.addJComboBox(1,colorRecords,"PROD_COLOR_NAME","PROD_COLOR_PK");
            break;
          case 3:
          case 1:
          case 9:
            //only bit zero on
            multiEditorJTableInSuper.addJComboBox(0,buyerLicensee,"BYMKR_BRIEF","BYMKR_SEQ");
             break;
          case 6:
          case 4:
          case 12:
            //only bit 2 on
            multiEditorJTableInSuper.addJComboBox(0,colorRecords,"PROD_COLOR_NAME","PROD_COLOR_PK");
            break;
          case 2:
            //(Size Type)
          case 8:
            //(Qty Only)
        }

      isRefinding=false;

      multiEditorJTableInSuper.setTextEditorVerifiers(getObject2StringConvertor());
      if(getJtable().getRowCount()>1){
        //multiEditorJTableInSuper.setRowUnEditable(getJtable().getRowCount()-1);
        ((exgui.MultiClassTableModel)multiEditorJTableInSuper.getJTable().getModel()).setCellEditablePolicy(
             new myCellEditablePolicy()
            );
      }

      //multiEditorJTableInSuper.getJTable().getModel().addTableModelListener(this);

      //only supervisor can modify if send confirmed,else remove the qyt columns editing function.
      if(!util.PublicVariable.OPERATTING_CENTER.toString().equals("001")){
         initializing=false;
         return;
      }
      //if(newtimes.production.ProdMaintain_Properties.isProductionAuditConfirmedOrPrinted()){
      if(!newtimes.production.ProdMaintain_Properties.isAbleToEdit()){
         //if(util.PublicVariable.USER_RECORD.getInt("USR_TYPE")!=newtimesejb.preproduction.PreProductionHead.USER_TYPE_SUPERVIOSER_MIS){
            btnRedefineSize.setEnabled(false);
            btnRedefineSize.setFocusable(false);
            btnFillPrx.setEnabled(false);
            btnFillPrx.setFocusable(false);
            String sizeColumns=(String)newtimes.production.ProdMaintain_Properties.EDITING_STYLE_RECORD.get("STY_SIZE_COLUMN");
            if(sizeColumns==null)sizeColumns="";
             importHeadColumn=util.MiscFunc.split(sizeColumns,",,");
            exgui.MultiClassTableModel mdl=
                (exgui.MultiClassTableModel)multiEditorJTableInSuper.getJTable().getModel();
            if(importHeadColumn.length==1 && importHeadColumn[0].trim().length()==0){
              mdl.removeEditableColumn("QTY");
            }else{
              for(int i=0;i<importHeadColumn.length;i++){
                mdl.removeEditableColumn(importHeadColumn[i]);
              }
            }
         //}
      }
      //if(newtimes.production.ProdMaintain_Properties.isProductionAuditConfirmedOrPrinted()){
      if(!newtimes.production.ProdMaintain_Properties.isAbleToEdit()){
        //if(util.PublicVariable.USER_RECORD.getInt("USR_TYPE")!= newtimesejb.preproduction.PreProductionHead.USER_TYPE_SUPERVIOSER_MIS){
           exgui.MultiClassTableModel mdl =
               (exgui.MultiClassTableModel)multiEditorJTableInSuper.getJTable().
               getModel();
           mdl.removeEditableColumn(DISP_KLM_BUYER_ACTPRX);
           mdl.removeEditableColumn(DISP_KLM_FOBPRX);
           mdl.removeEditableColumn(DISP_KLM_MKR_ACTPRX);
           mdl.removeEditableColumn(DISP_KLM_MKR_DOCPRX);
         //}
      }

    }catch(Exception e){
      e.printStackTrace();
    }
    initializing=false;
  }
  public void tableChanged(javax.swing.event.TableModelEvent te){
    if(te.getColumn()!=0)return;
    if(initializing)return;
    int row=te.getFirstRow();
    int col=te.getColumn();
    //System.out.println("obj in row,col is "+getJtable().getValueAt(row,col).getClass().getName());
   /*
    if(getJtable().getValueAt(row,col) instanceof exgui.ultratable.Wraper4tblCbx){
    exgui.ultratable.Wraper4tblCbx valueObj=
        (exgui.ultratable.Wraper4tblCbx)getJtable().getValueAt(row,col);
    Integer intObj=new Integer(valueObj.getValue().toString());
    HashMap tempHm=((DB_Trinity_PriceSizeQty)dbHandler).getPriSeqMapPrx();
    getJtable().setValueAt(tempHm.get(intObj.toString()).toString(),row,1);
   }
   */
  }

  protected int getEachPageRowCount() {
    return 99999;
  }
  /*
  protected boolean checkBuyerAct2MakerAct(int row_at,String buyerPrx){
    if(!prodCurrency.equalsIgnoreCase(styleCtCurrency))return true;
      float buyerActPrx=0;
      if(buyerPrx!=null&&(!buyerPrx.trim().equals(""))){
       buyerActPrx=Float.parseFloat(buyerPrx);
      }
      Object objMkrAct=getJtable().getValueAt(row_at,priceColumnAt);
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
    if(!prodCurrency.equalsIgnoreCase(styleCtCurrency))return true;
    float makererActPrx=0;
    if(makererPrx!=null&&(!makererPrx.trim().equals(""))){
     makererActPrx=Float.parseFloat(makererPrx);
    }
    Object objBuyAct=getJtable().getValueAt(row_at,priceColumnAt-2);
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

  protected Hashtable getObject2StringConvertor() {
    Hashtable ht=new Hashtable();
    try{
      exgui.ultratable.CellTxtEditorFormat vfyPrices=new VfyFOBPrx();
      ht.put(DISP_KLM_BUYER_ACTPRX ,vfyPrices);
      ht.put(DISP_KLM_FOBPRX ,vfyPrices);
      ht.put(DISP_KLM_MKR_ACTPRX ,vfyPrices);
      ht.put(DISP_KLM_MKR_DOCPRX,vfyPrices);

       String sizeColumns=
           (String)newtimes.production.ProdMaintain_Properties.EDITING_STYLE_RECORD.get("STY_SIZE_COLUMN");
       if(sizeColumns==null)sizeColumns="";
       importHeadColumn=util.MiscFunc.split(sizeColumns,",,");
      if(importHeadColumn.length==1 && importHeadColumn[0].trim().length()==0){
       importHeadColumn=new String[]{};
       isOnlyOneEditingCell=true;
      }
      //to test if with sizes column or not.
      //Object fltVfy=new MyFormatAllowNull(7,2);
          //exgui.verification.CellFormat.getDoubleFormatAllowNull(7,2);
      Object myDzVfy=new myfldVfyObj(7,2);
      if(importHeadColumn.length==0){
         ht.put("QTY",myDzVfy);
         isOnlyOneEditingCell=true;
         //ht.put("TOTAL",fltVfy);
      }else{
        isOnlyOneEditingCell=false;
        for(int i=0;i<importHeadColumn.length;i++){
          ht.put(importHeadColumn[i],myDzVfy);
        }
      }
      return ht;
    }catch(Exception e){
      e.printStackTrace();
      return null;
    }
  }
  protected PagedDataFactory getPagedDataFactory() {
    dbHandler=new DB_Trinity_PriceSizeQty();
    //licenseeColorsPrice=((DB_Trinity_PriceSizeQty)dbHandler).getClrLxyPrxs();
    return dbHandler;
  }
 public Vector getData2Update(){
   HashMap mappedRecordInCell=((DB_Trinity_PriceSizeQty)dbHandler).getMappedRec2TblCell();
   //depends on Color/Licencee will display or not.
   javax.swing.JTable _jtbl=getJtable();
   Vector ouptVct=new Vector();
   myfldVfyObj tmpVfyObj=new myfldVfyObj(7,2);
   int rowcount=getJtable().getRowCount()-1;
   //int endColmn=(getJtable().getColumnCount()-1)-priceColumnAt;
   try{
     determPricColPosition();
      /*
      if((newtimes.production.ProdMaintain_Properties.EDITING_STYLE_RECORD.getInt("STY_QTY_TYPE")&0x01) == 1){
         priceColumnAt=5;//with licensee
      }else{
        priceColumnAt=4;//without licensee column
      }
      */
   }catch(Exception exp){
     exp.printStackTrace();
   }

   int endColmn=
         (isOnlyOneEditingCell)?
         ((getJtable().getColumnCount())-priceColumnAt):
         (((getJtable().getColumnCount())-priceColumnAt-1));
   //if(endColmn==1)endColmn=0;
   try{
     String modifyUser=(String)util.PublicVariable.USER_RECORD.get("usr_code");
     for (int i = 0; i < rowcount; i++) {
       for (int j = 0; j < endColmn-1; j++) {
         Record rec = (Record) mappedRecordInCell.get(String.valueOf(i) + "_" +
             String.valueOf(j));
         rec.set("record_modify_user",modifyUser);
      Object qtyObj = _jtbl.getValueAt(i, j + priceColumnAt + 1).toString();

         if (qtyObj != null && (!qtyObj.toString().trim().equals(""))) {
           String qtyValue = qtyObj.toString();
           if (!tmpVfyObj.isFormatValid(qtyValue, i, j + priceColumnAt + 1)) {
             exgui.verification.VerifyLib.showAlert(tmpVfyObj.formatPromptMsg()
                 , "Data Format Error");
             _jtbl.editCellAt(i, j + priceColumnAt + 1);
             return new Vector();
           }
           DB_Trinity_PriceSizeQty.Dz2Record(rec, qtyObj.toString());
         }
         else {
           DB_Trinity_PriceSizeQty.Dz2Record(rec, 0);
         }

         ouptVct.add(rec);
       }
     }
   }catch(Exception e){
     e.printStackTrace();
     return new Vector();
   }
   return ouptVct;
 }
 public void doPaste(){
  //System.out.println(" retrieve copy key is:"+id4ApplicationProperties+"_"+newtimes.production.ProdMaintain_Properties.CURRENT_SELECTED_STYLE_SEQ_IN_STYLE_LIST);
  Object storedObj=util.ApplicationProperites.getProperties(
   id4ApplicationProperties+"_"+newtimes.production.ProdMaintain_Properties.CURRENT_SELECTED_STYLE_SEQ_IN_STYLE_LIST
  );
  if(storedObj==null){
    exgui.verification.VerifyLib.showPlanMsg(
    "No Copied Data To Paste\nOr Copied Qty Data Is Only Allowed To Paste In Same Style Record",
    "No Copied Data To Paste,Or Different Style Record");
    return;
  }
  if(getJtable().getSelectedRow()<0 || getJtable().getSelectedRow()== (getJtable().getRowCount()-1)){
    exgui.verification.VerifyLib.showPlanMsg(
    "Please Select A Row To Paste Copied Data","Please Select A Row");
    return;
  }
  int selectedRow[]=getJtable().getSelectedRows();
  if(super.getJtable().getCellEditor()!=null)
    super.getJtable().getCellEditor().cancelCellEditing();
  HashMap hm=(HashMap)storedObj;
  //for(int i=priceColumnAt+1 ;i<copiedColumns.length;i++){
  for(int i=0;i<getJtable().getColumnCount();i++){
    for(int j=0;j<selectedRow.length;j++){
      String colName = getJtable().getColumnName(i);
      if (hm.containsKey(colName)) {
        if(getJtable().getModel().isCellEditable(selectedRow[j], i)){
          getJtable().setValueAt(hm.get(colName), selectedRow[j], i);
        }
      }
    }
  }
  sumEveryColumn();
}
 public void doCopy(){
   if(getJtable().getSelectedRow()<0 || getJtable().getSelectedRow()== (getJtable().getRowCount()-1)){
     exgui.verification.VerifyLib.showPlanMsg(
     "Please Select A Row To Copy","Please Select A Row");
     return;
   }
   int selectedRow=getJtable().getSelectedRow();
   if(getJtable().getCellEditor()!=null)getJtable().getCellEditor().cancelCellEditing();
   //copiedColumns=new Object[getJtable().getColumnCount()];
   HashMap copyStoredMap=new HashMap();
   boolean isBegingToCopy=false;
   for(int i=0;i<getJtable().getColumnCount();i++){
     if(!isBegingToCopy){
       if(getJtable().getColumnName(i).endsWith("Price")){
         isBegingToCopy=true;
       }else{
         continue;
       }
     }
     copyStoredMap.put(getJtable().getColumnName(i),getJtable().getValueAt(selectedRow,i));
   }
   try{
     //System.out.println(" copy key is:"+id4ApplicationProperties+"_"+newtimes.production.ProdMaintain_Properties.CURRENT_SELECTED_STYLE_SEQ_IN_STYLE_LIST);
     util.ApplicationProperites.setProperties(
       id4ApplicationProperties+"_"+newtimes.production.ProdMaintain_Properties.CURRENT_SELECTED_STYLE_SEQ_IN_STYLE_LIST,
       util.MiscFunc.deepCopy(copyStoredMap)
     );
   }catch(Exception e){
      e.printStackTrace();
   }
 }


 public void doDelete()throws Exception{
   try{
    if(isMakerActPrxGreaterBuyerActPrx())return;
    newtimes.production.ProdMaintain_Properties.setWaitCursor();
     int selectRow =
      getJtable().getSelectedRow();
  if (selectRow < 0 || (selectRow == getJtable().getRowCount() - 1)) {
    exgui.verification.VerifyLib.showPlanMsg(
        "Please Select A Row To Delete", "Please Select A Row");
    return;
  }
  if(!exgui.verification.VerifyLib.showConfirm("Are You Sure To Delete This Record?","Are You Sure ?")){
    return;
  }
  util.MiscFunc.showProcessingMessage();
  if (getJtable().getRowCount() > 0) {
    Vector vct = getData2Update();
    //if (vct.size() == 0)  return; //no data to update,mabe cell is wrong..
    setValue2Price();
    ((DB_Trinity_PriceSizeQty)dbHandler).updatePriceQty(vct,((DB_Trinity_PriceSizeQty)dbHandler).Prices);
  }
  int recordColumnAtCount=
       (isOnlyOneEditingCell)?
       ((getJtable().getColumnCount())-priceColumnAt):
       (((getJtable().getColumnCount())-priceColumnAt-1));

  HashMap recMap = ((DB_Trinity_PriceSizeQty) dbHandler).getMappedRec2TblCell();
  Vector vct2Delete = new Vector();
  String modiUser = (String) util.PublicVariable.USER_RECORD.get("usr_code");
  for (int j = 0; j < recordColumnAtCount-1; j++) {
    Record rec = (Record) recMap.get(String.valueOf(selectRow) + "_" +
                                     String.valueOf(j));
    rec.set("record_delete_user", modiUser);
    vct2Delete.add(rec);
  }
  ((DB_Trinity_PriceSizeQty) dbHandler).deleteRecords(vct2Delete);
  //exgui.verification.VerifyLib.showPlanMsg("Delete OK", "Delete OK");
  ((DB_Trinity_PriceSizeQty) dbHandler).force2regetPriceRecords();
  this.goPage(1, 99999, false);
  ((DB_Trinity_PriceSizeQty) dbHandler).udpateQtyTbl2Text(
   newtimes.production.ProdMaintain_Properties.stylPriceSizeQtyTable2Text(
        getJtable(),priceColumnAt)
   );

  /*
  ((DB_Trinity_PriceSizeQty) dbHandler).udpateQtyTbl2Text(
   newtimes.production.ProdMaintain_Properties.table2Text(getJtable()));*/

  //find out the data to delete...
   }finally{
     util.MiscFunc.hideProcessingMessage();
     newtimes.production.ProdMaintain_Properties.setNormalCursor();
   }
 }
 public void setValue2Price(){
   try{
     determPricColPosition();
     int qtySizeType=newtimes.production.ProdMaintain_Properties.EDITING_STYLE_RECORD.
          getInt("STY_QTY_TYPE");
      exgui.ultratable.Wraper4tblCbx liceseeObj,colorObj;
     for(int i=0;i<getJtable().getRowCount()-1;i++){
       Record rec=(Record)getDisplayingRecords().get(i);
       String key = rec.get("PRI_SEQ").toString();
       Record recPrice = (Record)((DB_Trinity_PriceSizeQty)dbHandler).
           PRICE_RECS_MAP.get(key);
       switch(qtySizeType){
         case 7:
         case 5:
         case 13:
           //bit 0,and bit 2 on
           liceseeObj = (exgui.ultratable.Wraper4tblCbx)getJtable().getValueAt(i, 0);
           recPrice.set("PRI_LICENSEE_NAME", liceseeObj.getValue()); //licenseee
            colorObj = (exgui.ultratable.
               Wraper4tblCbx)getJtable().getValueAt(i, 1);
           recPrice.set("PROD_COLOR_PK", colorObj.getValue()); //color
           break;
         case 3:
         case 1:
         case 9:
           //only bit zero on
            liceseeObj = (exgui.ultratable.Wraper4tblCbx)getJtable().getValueAt(i, 0);
            recPrice.set("PRI_LICENSEE_NAME", liceseeObj.getValue()); //licenseee
            break;
         case 6:
         case 4:
         case 12:
           //only bit 2 on
           colorObj = (exgui.ultratable.Wraper4tblCbx)getJtable().getValueAt(i, 0);
           recPrice.set("PROD_COLOR_PK", colorObj.getValue()); //color
           break;
         case 2:
           //(Size Type)
         case 8:
           //(Qty Only)
       }
       /*(includeLicensee){
         exgui.ultratable.Wraper4tblCbx liceseeObj = (exgui.ultratable.
             Wraper4tblCbx)getJtable().getValueAt(i, 0);
         recPrice.set("PRI_LICENSEE_NAME", liceseeObj.getValue()); //licenseee
         exgui.ultratable.Wraper4tblCbx colorObj = (exgui.ultratable.
             Wraper4tblCbx)getJtable().getValueAt(i, 1);
         recPrice.set("PROD_COLOR_PK", colorObj.getValue()); //color
       }else{
         exgui.ultratable.Wraper4tblCbx colorObj = (exgui.ultratable.
             Wraper4tblCbx)getJtable().getValueAt(i, 0);
         recPrice.set("PROD_COLOR_PK", colorObj.getValue()); //color
       }
       */

       //Object objVfy=new VfyFOBPrx();

       Object objPriceByrDocPrpx=getJtable().getValueAt(i,priceColumnAt-3);//2+colAdj);
       Object objPriceByrActPrpx=getJtable().getValueAt(i,priceColumnAt-2);//3+colAdj);

       Object objPriceMkrDocPrpx=getJtable().getValueAt(i,priceColumnAt-1);//4+colAdj);
       Object objPriceMkrActPrpx=getJtable().getValueAt(i,priceColumnAt);//5+colAdj);


       recPrice.set("PRI_BYR_ACT_PRX",objPriceByrActPrpx);
       recPrice.set("PRI_BYR_DOC_PRX",objPriceByrDocPrpx);
       recPrice.set("PRI_MKR_ACT_PRX",objPriceMkrActPrpx);
       recPrice.set("PRI_MKR_DOC_PRX",objPriceMkrDocPrpx);
       recPrice.set("record_modify_user",util.PublicVariable.USER_RECORD.get("usr_code"));
       recPrice.set("record_delete_flag","1");
       //check the summed qty value,of '0',or blank,this price record is also need tobe deelet
       /*
       Object obtotal=getJtable().getValueAt(i,getJtable().getColumnCount()-1);
       if(obtotal!=null){
         if(obtotal.toString().trim().length()==0){
           recPrice.set("record_delete_flag","-1");
         }else{
           int totalIntValue=Integer.parseInt(obtotal.toString());
           if(totalIntValue==0){
             recPrice.set("record_delete_flag","-1");
           }else{
             recPrice.set("record_delete_flag","1");
           }
         }
       }else{
         recPrice.set("record_delete_flag","-1");
       }
       */
       ((DB_Trinity_PriceSizeQty)dbHandler).Prices.set(i,recPrice);

     }
   }catch(Exception exp){
     exp.printStackTrace();
   }

 }
 protected void determPricColPosition(){
   try{
     int pri_col_begn = 0;
     if ((newtimes.production.ProdMaintain_Properties.EDITING_STYLE_RECORD.
          getInt("STY_QTY_TYPE") & 0x01) !=0) {
        //with licensee column
        pri_col_begn++;
     }
     if ((newtimes.production.ProdMaintain_Properties.EDITING_STYLE_RECORD.
          getInt("STY_QTY_TYPE") & 0x04) !=0) {
        //with color
        pri_col_begn++;
     }
     priceColumnAt=pri_col_begn+3;
   }catch(Exception exp){
     exp.printStackTrace();
   }
 }
 public void doAddNew()throws Exception{
   try{
     if(isMakerActPrxGreaterBuyerActPrx())return;
     newtimes.production.ProdMaintain_Properties.setWaitCursor();
     if (getJtable().getRowCount() > 0) {
       Vector vct = getData2Update();
       if (vct.size() == 0)return; //no data to update,mabe cell is wrong..
       setValue2Price();
       util.MiscFunc.showProcessingMessage();
       ((DB_Trinity_PriceSizeQty) dbHandler).updatePriceQty(vct,((DB_Trinity_PriceSizeQty) dbHandler).Prices);
     }
     util.MiscFunc.showProcessingMessage();
     ((DB_Trinity_PriceSizeQty) dbHandler).force2regetPriceRecords();
     setValue2Price();
     ((DB_Trinity_PriceSizeQty) dbHandler).addRecord(null);
     ((DB_Trinity_PriceSizeQty) dbHandler).force2regetPriceRecords();
     setValue2Price();
     this.goPage(1, 99999, false);
     ((DB_Trinity_PriceSizeQty) dbHandler).udpateQtyTbl2Text(
      newtimes.production.ProdMaintain_Properties.stylPriceSizeQtyTable2Text(
           getJtable(),priceColumnAt)
      );
      /*
      exgui.verification.VerifyLib.showPlanMsg("Add New Record OK",
                                               "Add New OK");
      */
   }finally{
     util.MiscFunc.hideProcessingMessage();
     newtimes.production.ProdMaintain_Properties.setNormalCursor();
   }
 }
 protected synchronized void minusHandler2removeCount(){
   --handler2remove_count;
 }
 protected synchronized void addHandler2removeCount(){
   ++handler2remove_count;
 }
 protected synchronized int  getHandler2removeCount(){
   return handler2remove_count;
 }
 public void setToRemoveData(Vector vct,int bgnat,int count,String byUser,
                             int DELETE_USER_AT,int DELETE_FLAG_AT)throws Exception{
    addHandler2removeCount();
    Thread aThread=new Thread(
      new handler2remove(vct,bgnat,count,byUser,DELETE_USER_AT,DELETE_FLAG_AT));
    aThread.start();
 }
 class handler2remove implements Runnable{
   Vector vct;
   int bgnat,count,DELETE_FLAG_AT,DELETE_USER_AT;
   String byUser;
   handler2remove(Vector _vct,int _bgnat,int _count,String _byUser,
                             int _DELETE_USER_AT,int _DELETE_FLAG_AT){
      vct=_vct;
      bgnat=_bgnat;
      count=_count;
      byUser=_byUser;
      DELETE_FLAG_AT=_DELETE_FLAG_AT;
      DELETE_USER_AT=_DELETE_USER_AT;
   }
   public void run(){
     for(int i=bgnat;i<bgnat+count;i++){
       ((Record)vct.get(i)).set(DELETE_FLAG_AT,-1);
       ((Record)vct.get(i)).set(DELETE_USER_AT,byUser);
      }
     minusHandler2removeCount();
   }
 }
 protected boolean isMakerActPrxGreaterBuyerActPrx()throws Exception{
   //test currency of sc & ct
   if(isScCtCurrencyDiff)return false;
  int makerActPrxAt=priceColumnAt;
  int buyerActPrxAt=makerActPrxAt-2;
  getJtable().editCellAt(-1,0);//force editor to lose focus
  for( int i=0;i<getJtable().getRowCount()-1;i++){
    float byrActPrx=0;
    String valueStr=null;
    Object objByrAct=getJtable().getValueAt(i,buyerActPrxAt);
    if(objByrAct!=null && objByrAct.toString().trim().length()>0){
      byrActPrx=Float.parseFloat(objByrAct.toString());
      valueStr=objByrAct.toString();
      if( valueStr.indexOf(".")!=-1 &&
         (valueStr.length()-valueStr.indexOf("."))>3){
        exgui.verification.VerifyLib.showAlert("Decimal Part Is Only 2 Digits",
                                               "Decimal Part Is Only 2 Digits");

        getJtable().editCellAt(i, buyerActPrxAt);
        ((javax.swing.JTextField)getJtable().getEditorComponent()).grabFocus();
        ((javax.swing.JTextField)getJtable().getEditorComponent()).selectAll();
        return true;
      }
    }
    Object objPrice=getJtable().getValueAt(i,priceColumnAt-3);
    valueStr=objPrice.toString();
    if( valueStr.indexOf(".")!=-1 &&
       (valueStr.length()-valueStr.indexOf("."))>3){
      exgui.verification.VerifyLib.showAlert("Decimal Part Is Only 2 Digits",
                                             "Decimal Part Is Only 2 Digits");
      getJtable().editCellAt(i, priceColumnAt-3);
      ((javax.swing.JTextField)getJtable().getEditorComponent()).grabFocus();
      ((javax.swing.JTextField)getJtable().getEditorComponent()).selectAll();

      return true;
    }

    objPrice=getJtable().getValueAt(i,priceColumnAt-1);
    valueStr=objPrice.toString();
    if( valueStr.indexOf(".")!=-1 &&
       (valueStr.length()-valueStr.indexOf("."))>3){
      exgui.verification.VerifyLib.showAlert("Decimal Part Is Only 2 Digits",
                                             "Decimal Part Is Only 2 Digits");
      getJtable().editCellAt(i, priceColumnAt-1);
      ((javax.swing.JTextField)getJtable().getEditorComponent()).grabFocus();
      ((javax.swing.JTextField)getJtable().getEditorComponent()).selectAll();

      return true;
    }


    float mkrActPrx=0;
    Object objMkrAct=getJtable().getValueAt(i,makerActPrxAt);
    if(objMkrAct!=null && objMkrAct.toString().trim().length()>0){
      mkrActPrx=Float.parseFloat(objMkrAct.toString());
      valueStr=objMkrAct.toString();
      if(valueStr.indexOf(".")!=-1 &&
         (valueStr.length()-valueStr.indexOf("."))>3){
        exgui.verification.VerifyLib.showAlert("Decimal Part Is Only 2 Digits",
                                               "Decimal Part Is Only 2 Digits");
        getJtable().editCellAt(i, makerActPrxAt);
        ((javax.swing.JTextField)getJtable().getEditorComponent()).grabFocus();
        ((javax.swing.JTextField)getJtable().getEditorComponent()).selectAll();

        return true;
      }

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

 public void doUpdate() throws Exception{
   try{
     if(isMakerActPrxGreaterBuyerActPrx())return;
     getJtable().editCellAt(-1,0);
    newtimes.production.ProdMaintain_Properties.setWaitCursor();
      Vector vct = getData2Update();
      if (vct.size() == 0)return; //no data to update,mabe cell is wrong..
        //if QTY is zero,can not update.
        JTable tbl=getJtable();
        Object totalValueObj=
            tbl.getValueAt(tbl.getRowCount()-1,tbl.getColumnCount()-1);
        if(totalValueObj==null||
           Float.parseFloat(totalValueObj.toString().trim())==0){
          exgui.verification.VerifyLib.showAlert(
            "Quantity should be greater than Zero"
            ,"Quantity should be greater than Zero"
            );
          return;
        }
        //remove the row if total value is zero.
        util.MiscFunc.showProcessingMessage();
        String modifyUser=(String)util.PublicVariable.USER_RECORD.get("usr_code");
        Record testRec=(Record)vct.get(0);
        int qtyQTYCOLUMNAT=util.MiscFunc.getFieldIndexAtRecord(testRec,"QTY_QTY") ;
        int qtyPCSCOLUMNAT=util.MiscFunc.getFieldIndexAtRecord(testRec,"QTY_PCS") ;
        int DELETE_USER_AT=util.MiscFunc.getFieldIndexAtRecord(testRec,"record_delete_user");
        int DELETE_FLAG_AT=util.MiscFunc.getFieldIndexAtRecord(testRec,"record_delete_flag");
        if(isOnlyOneEditingCell){
          for(int i=0;i<vct.size();i++){
            Record qtyRec=(Record)vct.get(i);
            if(Float.parseFloat((qtyRec.get(qtyQTYCOLUMNAT)==null)?"0":qtyRec.get(qtyQTYCOLUMNAT).toString())==0 &&
               Float.parseFloat((qtyRec.get(qtyPCSCOLUMNAT)==null)?"0":qtyRec.get(qtyPCSCOLUMNAT).toString())==0){
               qtyRec.set(DELETE_FLAG_AT,"-1");
               qtyRec.set(DELETE_USER_AT,
                          modifyUser);
               vct.set(i,qtyRec);
            }
          }
        }else{
          //temp total
          int row_width=tbl.getColumnCount()- priceColumnAt-2;//2 is column price at & total column
          float subTotal=0;
          handler2remove_count=0;
          for(int i=0;i<tbl.getRowCount()-1;i++){
            subTotal=0;
            for(int j=0;j<row_width;j++){
              Record rec= (Record)vct.get(i*row_width+j);
              subTotal+=(Float.parseFloat((rec.get(qtyQTYCOLUMNAT)==null)?"0":rec.get(qtyQTYCOLUMNAT).toString()) +
                        Float.parseFloat((rec.get(qtyPCSCOLUMNAT)==null)?"0":rec.get(qtyPCSCOLUMNAT).toString()));
            }
            if(subTotal==0){setToRemoveData(vct,i*row_width,row_width,modifyUser,
                                           DELETE_USER_AT,DELETE_FLAG_AT);}
          }
          //wait for handler2removes to remove all the data.
          while(getHandler2removeCount()!=0){
            try{
              Thread.currentThread().sleep(100);
            }catch(java.lang.InterruptedException  e){

            }
          }
        }
        setValue2Price();
       ((DB_Trinity_PriceSizeQty) dbHandler).updatePriceQty(vct,((DB_Trinity_PriceSizeQty) dbHandler).Prices);
       ((DB_Trinity_PriceSizeQty) dbHandler).force2regetPriceRecords();
     this.goPage(1, 99999, false);

     String defaultStyleDownDescription=null;

     if(util.PublicVariable.OPERATTING_CENTER.equals("001")){
       Object objBuyer=newtimes.preproduction.Constants.CURRENT_PREPROD_HEAD_RECORD.get("PROD_BUYER");
//       if (objBuyer.toString().equals("12141"))
       if ( objBuyer.toString().equals("12284") ||  objBuyer.toString().equals("12285") ||  objBuyer.toString().equals("12286") ||  objBuyer.toString().equals("12287") || objBuyer.toString().equals("12288") || objBuyer.toString().equals("12289") || objBuyer.toString().equals("12294"))
       {
         defaultStyleDownDescription=
          newtimes.production.ProdMaintain_Properties.stylPriceSizeQtyTable2Text(getJtable(),priceColumnAt,
          (String)newtimes.production.ProdMaintain_Properties.EDITING_STYLE_RECORD.get("STY_UNIT"),colorVct);

       }
       else
       {
       defaultStyleDownDescription=
           newtimes.production.ProdMaintain_Properties.stylPriceSizeQtyTable2Text(getJtable(),priceColumnAt,
           (String)newtimes.production.ProdMaintain_Properties.EDITING_STYLE_RECORD.get("STY_UNIT"));
       }



   }
     else{
       defaultStyleDownDescription=
           newtimes.production.ProdMaintain_Properties.stylPriceSizeQtyTable2Text(getJtable(),priceColumnAt);

     }


       ((DB_Trinity_PriceSizeQty) dbHandler).udpateQtyTbl2Text(
        defaultStyleDownDescription);

        //exgui.verification.VerifyLib.showPlanMsg("Update OK", "Update OK");

   }finally{
     util.MiscFunc.hideProcessingMessage();
     newtimes.production.ProdMaintain_Properties.setNormalCursor();
   }
 }
 protected void makeTable(Vector vct){
   initializing=true;
   super.makeTable(vct,false);
   sumEveryColumn();
   initializing=false;
   table_snapshot=util.MiscFunc.table2Text(getJtable());
 }

 protected synchronized void sumEveryColumn(){
   initializing=true;
   backupedSizeQty.clear();
   if(getDisplayingRecords().size()<1)return;
   try{
     /*
      String sizeColumns=
         (String)newtimes.production.ProdMaintain_Properties.EDITING_STYLE_RECORD.get("STY_SIZE_COLUMN");
     if(sizeColumns==null)sizeColumns="";
      importHeadColumn=util.MiscFunc.split(sizeColumns,",,");
     */
    if(importHeadColumn.length==1 && importHeadColumn[0].trim().length()==0){
     importHeadColumn=new String[]{};
     isOnlyOneEditingCell=true;
    }

       if(importHeadColumn.length==0){
         isOnlyOneEditingCell=true;
         float totalQtyValue=0;
         for(int i=0;i<(getJtable().getRowCount()-1);i++){
          Object qtyObj=getJtable().getValueAt(i,getJtable().getColumnCount()-1);
           backupedSizeQty.put(
              String.valueOf(i)+"_"+String.valueOf(0),
              qtyObj);
           float fltValue=MyFloatPars(qtyObj);
           if(isDzUnit()){
             totalQtyValue=DB_Trinity_PriceSizeQty.addDzValue(totalQtyValue,fltValue);
           }else{
             totalQtyValue+=fltValue;
           }
         }
         exgui.ultratable.Wraper4tblCbx blankFld= new exgui.ultratable.Wraper4tblCbx(new Integer(-999),"");
         int blankClmCount=getJtable().getColumnCount()-2;
         for(int i=0;i<blankClmCount;i++){
           getJtable().setValueAt(
                 blankFld,getJtable().getRowCount()-1,i);
         }
         getJtable().setValueAt("TOTAL",
                                getJtable().getRowCount()-1,
                                getJtable().getColumnCount()-2);
         getJtable().setValueAt(formatter.format(totalQtyValue),
                                getJtable().getRowCount()-1,
                                getJtable().getColumnCount()-1);
       }else{
         //find out column name of extends column
         isOnlyOneEditingCell=false;
         int extendColumnBgnAt=0;
         int extendColumnEndAt=getJtable().getColumnCount()-1;
         /*
         for(int i=0;i<getJtable().getColumnCount()-1;i++){
           String headColumnName=getJtable().getColumnName(i);
           if(headColumnName.equals(importHeadColumn[0])){
             extendColumnBgnAt=i;
             break;
           }
         }*/
         extendColumnBgnAt=priceColumnAt+1;
         float hzTotal[]=new float[getJtable().getRowCount()-1];
         float vtTotal[]=new float[importHeadColumn.length];
         backupedSizeQty.clear();
         float theEndTotal=0;
         for(int j=0;j<getJtable().getRowCount()-1;j++){
           for(int i=extendColumnBgnAt;i<extendColumnEndAt;i++){
                Object objValue=
                    getJtable().getValueAt(j,i);
                float qtyValue=MyFloatPars(objValue);
                if(isDzUnit()){
                  hzTotal[j]=
                      DB_Trinity_PriceSizeQty.addDzValue(hzTotal[j],qtyValue);
                  vtTotal[i-extendColumnBgnAt]=
                      DB_Trinity_PriceSizeQty.addDzValue(vtTotal[i-extendColumnBgnAt],qtyValue);
                }else{
                  hzTotal[j]=hzTotal[j]+qtyValue;
                  vtTotal[i-extendColumnBgnAt]=
                      vtTotal[i-extendColumnBgnAt]+qtyValue;
                }
            backupedSizeQty.put(String.valueOf(j)+"_"+String.valueOf(i),objValue);
           }
           if(isDzUnit()){
             theEndTotal=DB_Trinity_PriceSizeQty.addDzValue(theEndTotal,hzTotal[j]);
           }else{
             theEndTotal+=hzTotal[j];
           }
           getJtable().setValueAt(
              formatter.format(hzTotal[j]),j,extendColumnEndAt);//set to end of the row.
         }

         for(int i=extendColumnBgnAt;i<extendColumnEndAt;i++){
          getJtable().setValueAt(
             formatter.format(vtTotal[i-extendColumnBgnAt]),
             getJtable().getRowCount()-1,i);
         }

         exgui.ultratable.Wraper4tblCbx blankFld= new exgui.ultratable.Wraper4tblCbx(new Integer(-999),"");
         for(int i=0;i<extendColumnBgnAt;i++){
           getJtable().setValueAt(
                 blankFld,getJtable().getRowCount()-1,i);
         }
         Object objTotalString=new exgui.ultratable.Wraper4tblCbx(new Integer(-999),"Total");
         getJtable().setValueAt(objTotalString,getJtable().getRowCount()-1,extendColumnBgnAt-1);
         getJtable().setValueAt(formatter.format(theEndTotal),getJtable().getRowCount()-1,extendColumnEndAt);
       }
   }catch(Exception e){
     e.printStackTrace();
   }

   initializing=false;
 }
 protected boolean isDzUnit(){
   try{
     if(testUnit==null){
       testUnit=(String)
       newtimes.production.ProdMaintain_Properties.EDITING_STYLE_RECORD.get("STY_UNIT");
     }
     return  testUnit.toLowerCase().trim().startsWith("dz");
   }catch(Exception e){
     e.printStackTrace();
     return false;
   }
 }

protected synchronized boolean modifiedYYvalue(String str,int row,int column ){
    if(initializing)return true;
    if(!getJtable().isCellEditable(row,column))return true;
   //find out the last sumned row & column of YY1,
   try{
    float newQty=MyFloatPars(str);
    Object ObjectTotal=
        getJtable().getValueAt(getJtable().getRowCount()-1,getJtable().getColumnCount()-1);
    float totalFloat=MyFloatPars(ObjectTotal);
    Object objOrgQty=
       backupedSizeQty.get(String.valueOf(row)+"_"+String.valueOf(column));
       backupedSizeQty.put(String.valueOf(row)+"_"+String.valueOf(column),str);
    float orgFloat=MyFloatPars(objOrgQty);
     if(!isOnlyOneEditingCell){
       //with size
       Object orgVtotalObj=getJtable().getValueAt(getJtable().getRowCount()-1,column);
       Object orgHtotalObj=getJtable().getValueAt(row,getJtable().getColumnCount()-1);
       float  orgVtotal=MyFloatPars(orgVtotalObj);
       float  orgHtotal=MyFloatPars(orgHtotalObj);
       if(isDzUnit()){
         orgVtotal=DB_Trinity_PriceSizeQty.minusDzValue(orgVtotal,orgFloat);
         orgHtotal=DB_Trinity_PriceSizeQty.minusDzValue(orgHtotal,orgFloat);
         totalFloat=DB_Trinity_PriceSizeQty.minusDzValue(totalFloat,orgFloat);
         orgVtotal=DB_Trinity_PriceSizeQty.addDzValue(orgVtotal,newQty);
         orgHtotal=DB_Trinity_PriceSizeQty.addDzValue(orgHtotal,newQty);
         totalFloat=DB_Trinity_PriceSizeQty.addDzValue(totalFloat,newQty);
       }else{
         orgVtotal-=orgFloat;
         orgHtotal-=orgFloat;
         totalFloat-=orgFloat;
         orgVtotal+=newQty;
         orgHtotal+=newQty;
         totalFloat+=newQty;
       }
       getJtable().setValueAt(
            formatter.format(orgVtotal),
            getJtable().getRowCount()-1,column);
       getJtable().setValueAt(
           formatter.format(orgHtotal),
           row,getJtable().getColumnCount()-1);
     }else{
        //no size.
        //directly sum all the value of each quentity column .
        totalFloat=0;
        if(isDzUnit()){
          int rowcount=getJtable().getRowCount()-1;
          int colcount=getJtable().getColumnCount()-1;
          for(int i=0;i<rowcount;i++){
            Object orgObjStr=getJtable().getValueAt(i,colcount);
            if(orgObjStr!=null){
              String objStr=orgObjStr.toString();
              float qtyValue=
                  (objStr.trim().length()==0)?0:Float.parseFloat(objStr);
              totalFloat=DB_Trinity_PriceSizeQty.addDzValue(totalFloat,qtyValue);
            }
          }
        }else{
          int rowcount=getJtable().getRowCount()-1;
          int colcount=getJtable().getColumnCount()-1;
          for(int i=0;i<rowcount;i++){
            Object orgObjStr=getJtable().getValueAt(i,colcount);
            if(orgObjStr!=null){
              String objStr=orgObjStr.toString();
              float qtyValue=
                  (objStr.trim().length()==0)?0:Float.parseFloat(objStr);
              totalFloat+=qtyValue;
            }
          }
        }
     }
     if(Float.parseFloat(str)==0)
       getJtable().setValueAt("",row,column);
     else
       getJtable().setValueAt(str,row,column);

     getJtable().setValueAt(
          formatter.format(totalFloat),
          getJtable().getRowCount()-1,getJtable().getColumnCount()-1);
      return true;
   }catch(Exception e){
     e.printStackTrace();
     return false;
   }
  }

 protected class myCellEditablePolicy implements exgui.CellEditablePolicy{
   public boolean isCellEditable(int row,int column){
     if(isOnlyOneEditingCell){
       if(row==(getJtable().getRowCount()-1)){
         return false;
       }
     }else{
       if ((row == (getJtable().getRowCount() - 1)) ||
           (column == (getJtable().getColumnCount() - 1))) {
           return false;
       }
     }
     return true;
   }
 }

protected class FormaterPrx implements exgui.ultratable.CellTxtEditorFormat,exgui.Object2String{
  Object orgFvyObj=null;
  public FormaterPrx(){
    orgFvyObj=exgui.verification.CellFormat.getDoubleFormatAllowNull(7,2);
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
    return ((exgui.ultratable.CellTxtEditorFormat)orgFvyObj).isFormatValid(inStr,row,column);
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


public class VfyFOBPrx implements exgui.ultratable.CellTxtEditorFormat,exgui.Object2String{
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
    if(!getJtable().isCellEditable(row,column))return true;
    boolean isVld= ((exgui.ultratable.CellTxtEditorFormat)orgFvyObj).isFormatValid(inStr,row,column);
    if(!isVld)return isVld;
    /*
    if((column==priceColumnAt-2)){
      boolean ask=  checkBuyerAct2MakerAct(row,inStr);
      if(!ask)return false;
    }

    if((column==priceColumnAt)){
      boolean ask=  checkMakerAct2BuyerAct(row,inStr);
      if(!ask)return false;
    }*/



    //test if have to modify the remain 3 column.
    for(int i=priceColumnAt-2;i<priceColumnAt+1;i++){
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

protected class myfldVfyObj implements exgui.ultratable.CellTxtEditorFormat,exgui.Object2String{

   int _maxLength=0;
   int _intDigitLength=0,_floatDigitLength=0;
   String headString,tailString;
   String orgWarnningMsg="String must be in float format,such as 12345.91";
   String warnningMsg=null;
   public myfldVfyObj(int intDigitLength,int floatDigitLength){
     _maxLength=intDigitLength+floatDigitLength+1;//include "." character
     _intDigitLength=intDigitLength;
     _floatDigitLength=floatDigitLength;
     String totalString="##############################################";
     headString=totalString.substring(0,_intDigitLength);
     tailString=totalString.substring(0,_floatDigitLength);
   }
   public exgui.ultratable.KeyProcess getKeyListener(){
     return
         ((exgui.ultratable.CellTxtEditorFormat)exgui.verification.CellFormat.getDoubleFormat(
          _intDigitLength,_floatDigitLength)).getKeyListener();
   }

   public int getMaxLength(){return _maxLength ;}
   public String formatPromptMsg(){return warnningMsg;}
   public boolean isFormatValid(String org_inStr,int row,int column){
          String inStr=org_inStr;
          if(column<=priceColumnAt)return true;
          if(inStr==null){
             inStr="0.0";
          }
          if(inStr.trim().length()==0) inStr="0.0";
            try {
             warnningMsg=orgWarnningMsg;
             if(inStr.indexOf(".")==-1 && inStr.length()>_intDigitLength) return false;
             if(inStr.indexOf(".")==(inStr.length()-1))return false;
             if(inStr.indexOf(".")==0)return false;
             if(inStr!=null && inStr.indexOf(".")!=-1){
               String arrDgs[]=util.MiscFunc.SplitByStringTokenizer(inStr,".");
               if(arrDgs[0].length()>_intDigitLength) return false;
               //Double d = new Double(((Number)formatter.parse((String)inStr)).doubleValue());
                  if(isDzUnit()){
                    //.08->1 .16->2 .25->3 .33->4 .41->5 .50->6 .58->7 .66->8 .75->9 .83->10 .91->11
                    Object value=getJtable().getValueAt(row,column);
                    if(value!=null){
                      //Double dx=new Double(value.toString());//test if throws Exception;
                      float xntFloatValue=MyFloatPars(value);
                      String DecPartOfValue=util.MiscFunc.split(Dzformatter.format(xntFloatValue),".")[1];
                      if(!DB_Trinity_PriceSizeQty.DecToDozeMapping.containsKey(DecPartOfValue)){
                        warnningMsg="The Number of Size Qty after the Decimal Point should be one of fallowing :\n"+
                        "00,08,16,25,33,41,50.58,66,75,83,91";
                        return false;
                      }
                      return( modifiedYYvalue(inStr,row,column));
                      //return true;
                    }
                    return ( modifiedYYvalue(inStr,row,column));
                  }
               return (modifiedYYvalue(inStr,row,column));
             }else{
               if(exgui.verification.VerifyLib.isInteger(inStr)){
                 return(modifiedYYvalue(inStr,row,column));
               }else{
                 return false;
               }
             }
           } catch (Exception ex) {
             //ex.printStackTrace();
             return false;
           }
   }
   public String Obj2String(Object obj2kvt){
      if(obj2kvt==null) return "";
      if(obj2kvt instanceof Float){
          if(((Float)obj2kvt).floatValue()==0)return "";
         String value= formatter.format(obj2kvt);
         return value;
      }
      if(obj2kvt instanceof Double){
          if(((Double)obj2kvt).doubleValue()==0)return "";
         String value= formatter.format(obj2kvt);
         return value;
       }else{
        String value=obj2kvt.toString();
         return value;
      }
   }
    public Object cellStringToObject(String String2kvt){
       if(String2kvt==null) return new Float(0);
       if(String2kvt.trim().length()==0) return new Float(0);
           try {
             Float d = new Float(
               ((Number)formatter.parse((String)String2kvt)).floatValue());
             return d;
           } catch (java.text.ParseException ex) {
             return new Float(0);
           }
    }
   }
   protected String  defineStyeColorQtyType()throws Exception{
      exgui.chaindialog.Responsible   rspSlkFirst=new newtimes.production.gui.prodmaintain.PnlDlgChzStyQtyType();
      Responsible slkSizeColumns=   new PnlDlgSlkSizeType();
      Responsible slkShiftSizeSeq=      new PnlDlgShiftSizes();
      exgui.chaindialog.ChainedDialogBox
      DlgSelectSizeQty=new ChaiedProcSlkSizeType(
         util.PublicVariable.APP_FRAME,"Please Select Size Type",true,rspSlkFirst);
     rspSlkFirst.setDefalutNext(slkSizeColumns);
     slkSizeColumns.setDefalutNext(slkShiftSizeSeq);
     DlgSelectSizeQty.setSize(500,400);
     exgui.UIHelper.setToScreenCenter(DlgSelectSizeQty);
     DlgSelectSizeQty.show();
     if((DlgSelectSizeQty.getDialogStatus()==DlgSelectSizeQty.DIALOG_CANCEL)
        ||(DlgSelectSizeQty.getDialogStatus()==DlgSelectSizeQty.DIALOG_ERROR)
        ||(DlgSelectSizeQty.getDialogResult()==null)){
      return "NO";
     }
     String result="OK";
     java.util.HashMap dialogContext=
          (java.util.HashMap)DlgSelectSizeQty.getDialogResult();
     int new_sizeTyp=
         ((Integer)dialogContext.get(PnlDlgChzStyQtyType.INTEGER_KEY_OF_SELECTED_COLORLICENSEE_SIZE_TYPE)).intValue();
     newtimes.production.ProdMaintain_Properties.EDITING_STYLE_RECORD.set("STY_QTY_TYPE",new_sizeTyp);
     System.out.println("size type to set is:"+new_sizeTyp);
     System.out.println("after set size type :"+newtimes.production.ProdMaintain_Properties.EDITING_STYLE_RECORD.getInt("STY_QTY_TYPE"));

       if((newtimes.production.ProdMaintain_Properties.EDITING_STYLE_RECORD.getInt("STY_QTY_TYPE")&0x01) == 1){
           priceColumnAt=5;
       }else{
           priceColumnAt=4;
       }

     orgCammaedColumnsDefString=
         (String)newtimes.production.ProdMaintain_Properties.EDITING_STYLE_RECORD.get("STY_SIZE_COLUMN");
     String orgCammaedColumnsDefStringDup="";
     if(this.orgCammaedColumnsDefString!=null){
       orgCammaedColumnsDefStringDup=this.orgCammaedColumnsDefString;
     }

     String commaSizeList=
         (String)dialogContext.get(PnlDlgShiftSizes.STRING_KEY_SHFT_SIZE_DBL_CMA_LIST);
     String commaSizeListDup="";
     if(commaSizeList!=null)commaSizeListDup=commaSizeList;


  //System.out.println("org Colum Def is:"+orgCammaedColumnsDefStringDup.trim());
  //System.out.println("new define Column is"+commaSizeListDup.trim());
    //test org size list count,if size list count same as before,no need to delete
     //System.out.println("commaSizeListDup is "+commaSizeListDup.trim());
     //System.out.println("orgCammaedColumnsDefStringDup is "+orgCammaedColumnsDefStringDup.trim());
     String orgColumns[]= util.MiscFunc.split(((orgCammaedColumnsDefStringDup==null)?"":orgCammaedColumnsDefStringDup),",,");
     String newColumns[]=util.MiscFunc.split(((commaSizeListDup==null)?"":commaSizeListDup),",,");
     if(orgColumns.length!=newColumns.length){
             ((DB_Trinity_PriceSizeQty) dbHandler).deleteAllQty(); //delete all the pre-defined record.
             result="OK";
     }else{
       result="OK_AND_RELOAD";
     }

     /*
     if(!commaSizeListDup.trim().equalsIgnoreCase(orgCammaedColumnsDefStringDup.trim())){
             ((DB_Trinity_PriceSizeQty) dbHandler).deleteAllQty(); //delete all the pre-defined record.
     }
     */
     if(commaSizeList!=null){
       newtimes.production.ProdMaintain_Properties.EDITING_STYLE_RECORD.set(
           "STY_SIZE_COLUMN",commaSizeList);
       importHeadColumn= util.MiscFunc.split(commaSizeList,",,");
     }else{
       newtimes.production.ProdMaintain_Properties.EDITING_STYLE_RECORD.set(
           "STY_SIZE_COLUMN"," ");
       commaSizeList=" ";
       importHeadColumn=new String[]{};
     }
     //while everything is ok.update the database.
     newtimesejb.production.ColorSizeQtyFacadeHome ejbHome=
       (newtimesejb.production.ColorSizeQtyFacadeHome)
        info_ejb.WeblogicServiceLocator.locateServiceHome(
         util.PublicVariable.SERVER_URL,
         "newtimesejb.production.ColorSizeQtyFacade");
      newtimesejb.production.ColorSizeQtyFacade ejb=
          ejbHome.create();
     ejb.updateStyleQtyType(
                   newtimes.production.ProdMaintain_Properties.CURRENT_SELECTED_STYLE_SEQ_IN_STYLE_LIST,
                   new_sizeTyp,commaSizeList,
                   (String)util.PublicVariable.USER_RECORD.get("usr_code"));
     orgCammaedColumnsDefString=commaSizeList;
     //Record orgStyleRec=newtimes.production.ProdMaintain_Properties.EDITING_STYLE_RECORD;
     //newtimes.production.ProdMaintain_Properties.EDITING_STYLE_RECORD=orgStyleRec;
     //firstPage();
     newtimes.production.ProdMaintain_Properties.EDITING_STYLE_RECORD.set("STY_QTY_TYPE",new_sizeTyp);
     return result;
   }
  class ChaiedProcSlkSizeType extends exgui.chaindialog.ChainedDialogBox{
     ChaiedProcSlkSizeType(javax.swing.JFrame frame,String title,boolean model,
                           exgui.chaindialog.Responsible rsp){
       super(frame,title,model,rsp);
     }
     public Object getDialogResult(){
       return super.resultHashMap;
     }
   }
  float MyFloatPars(Object obj2parse)throws Exception {
    if(obj2parse==null)return 0;
    if(obj2parse.toString().trim().length()==0)return 0;
    try{
      return Float.parseFloat(obj2parse.toString());
    }catch(Exception e){
      e.printStackTrace();
      return 0;
    }
  }
 }

