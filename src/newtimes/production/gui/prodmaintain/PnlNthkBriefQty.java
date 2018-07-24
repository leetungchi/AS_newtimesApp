package newtimes.production.gui.prodmaintain;

import processhandler.template.PnlTableEditor;
import util.InsertionOrderedHashMap;
import java.util.Hashtable;
import exgui.ultratable.*;
import database.datatype.*;
import processhandler.*;
import newtimes.production.process.prodmaintain.*;
import javax.swing.table.*;
import exgui.*;
import java.util.Vector;
import java.awt.Cursor;
/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class PnlNthkBriefQty extends PnlTableEditor {
  static String  COLUMN_COLOR_CODE=   "COLOR\nCODE";
  static int COLUMN_COLOR_CODE_AT=0;
  static String  COLUMN_COLOR_DESC=   "COLOR\nDESC.  ";
  static int COLUMN_COLOR_NAME_AT=1;

  static String  COLUMN_BUYER_ACT_PRX="BUYER\nAct.Prx";
  static int COLUM_BUYER_ACT_PRX_AT=0;static int COLUM_BUYER_DOC_PRX_AT=0;
  static int COLUM_MAKER_ACT_PRX_AT=0;static int COLUM_MAKER_DOC_PRX_AT=0;
  static String  COLUMN_BUYER_DOC_PRX="BUYER\nDoc.Prx";
  static String  COLUMN_MAKER_ACT_PRX="Maker\nAct.Prx";
  static String  COLUMN_MAKER_DOC_PRX="Maker\nDoc.Prx";
  static int COLUMN_QTY_1_AT=0;


  static String  COLUMN_SIZE_QTY_TOTAL=" TOTAL ";
  java.text.NumberFormat  formatter=new java.text.DecimalFormat("#######.##");
  java.text.NumberFormat  Dzformatter=new java.text.DecimalFormat("#######.00");
  String headClm4Size[]=
      {"_1_","_2_","_3_","_4_","_5_","_6_","_7_",
      "_8_","_9_","_10_","_11_","_12_","_13_","_14_"};
  static String dzDecimal[]={"00","08","16","25","33","41","50","58","66","75","83","91","00"};
  boolean isOnlyTotalQty=false;
  static int TOTAL_COLUMNAT=0;
  boolean _isDzUnit=false;
  FLOAT_QTY_VFY fltVfyTempUse=new FLOAT_QTY_VFY(10);
  Hashtable htEditors=new Hashtable();
  boolean isDataModified;
  int currentStySeq=0;
  boolean isReallyPricessingExit=false;
  javax.swing.JButton btnChgSize=new javax.swing.JButton("Re-Define Size");
  static boolean IS_AFTER_SHIPPED=false;
  //java.util.HashMap hmUnEditableRowId=new java.util.HashMap();
  public PnlNthkBriefQty(newtimes.production.process.prodmaintain.DbBriefQtyHandler dbHandlerBriefQty,
                         boolean isModified,boolean isAfterShipped) {
    this(dbHandlerBriefQty,isAfterShipped);
    isDataModified=isModified;
    IS_AFTER_SHIPPED=isAfterShipped;

  }
  void btnRdfSize_actionPerformed(java.awt.event.ActionEvent e) {
    if(getJtable().getRowCount()>0){
      if(!exgui.verification.VerifyLib.showConfirm(
      "Redefine the Size  Will Clear All The Defined QTY Of Current Style\nAre You Sure ?",
      "May Clear All Defined QTY")) return;
    }
    exgui.chaindialog.Responsible slkSizeColumns=new newtimes.production.gui.prodmaintain.PnlDlgSlkSizeType();
    newtimes.production.gui.prodmaintain.PnlDlgShiftSizes slkShiftSizeSeq=new newtimes.production.gui.prodmaintain.PnlDlgShiftSizes();
    exgui.chaindialog.ChainedDialogBox  DlgSelectSizeQty=new ChaiedProcSlkSizeType(
       util.PublicVariable.APP_FRAME,"Please Select Size Type",true,slkSizeColumns);
   slkSizeColumns.setDefalutNext(slkShiftSizeSeq);
   DlgSelectSizeQty.setSize(500,400);
   exgui.UIHelper.setToScreenCenter(DlgSelectSizeQty);
   DlgSelectSizeQty.show();
   if((DlgSelectSizeQty.getDialogStatus()==DlgSelectSizeQty.DIALOG_CANCEL)
      ||(DlgSelectSizeQty.getDialogStatus()==DlgSelectSizeQty.DIALOG_ERROR)
      ||(DlgSelectSizeQty.getDialogResult()==null)){
      return ;
   }else{


     java.util.HashMap dialogContext=
          (java.util.HashMap)DlgSelectSizeQty.getDialogResult();
     String commaSizeList=
         (String)dialogContext.get(slkShiftSizeSeq.STRING_KEY_SHFT_SIZE_DBL_CMA_LIST);
     String szCol[]=util.MiscFunc.split(commaSizeList,",,");
     htEditors.clear();
     for(int i=0;i<15;i++){
       if(i<szCol.length){
         htEditors.put(szCol[i], fltVfyTempUse);
         getJtable().getColumnModel().getColumn(i + 6).setHeaderValue(szCol[i]);
       }else{
         //still keep the total head column
         if(i!=14){getJtable().getColumnModel().getColumn(i + 6).setHeaderValue("");}
       }
       for(int j=0;j<getJtable().getRowCount();j++){
         getJtable().setValueAt(null,j,i);
       }
     }
     doUpdate();
     //
     //lblSizeList.setText(util.MiscFunc.Replace(commaSizeList,",,",","));
     //finalSizeListString=commaSizeList;*/
   }
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

  public PnlNthkBriefQty(newtimes.production.process.prodmaintain.DbBriefQtyHandler dbHandlerBriefQty,
                         boolean isAferShipped) {
    super(null,0,null,null);
    super.dbHandler=dbHandlerBriefQty;
    //style name and po is set up to container.
    super.jbtn1st.setVisible(false);
    super.jbtnLast.setVisible(false);
    super.jbtnNext.setVisible(false);
    super.jbtnPrev.setVisible(false);
    IS_AFTER_SHIPPED=isAferShipped;
    btnChgSize.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent e) {
        btnRdfSize_actionPerformed(e);
      }
    });
    //if(!IS_AFTER_SHIPPED) super.getLowerRightPanel().add(btnChgSize);
    /*
    if(newtimes.production.ProdMaintain_Properties.isAbleToEdit()){
      super.getLowerRightPanel().add(btnChgSize);
    }*/

    try{
      int shipped_count=
          newtimes.production.ProdMaintain_Properties.EDITING_STYLE_RECORD.getInt("shipped_count");
       if(shipped_count==0) super.getLowerRightPanel().add(btnChgSize);

      int user_type = util.PublicVariable.USER_RECORD.getInt("USR_TYPE");
      switch (user_type) {
        case newtimesejb.preproduction.PreProductionHead.USER_TYPE_OTHERS:
        case newtimesejb.preproduction.PreProductionHead.
            USER_TYPE_ACCOUNTING_USERS:
        case newtimesejb.preproduction.PreProductionHead.
            USER_TYPE_SHIPPING_USERS:
          btnChgSize.setEnabled(false);
      }
    }catch(Exception exp){}


    try{
      currentStySeq=newtimes.production.ProdMaintain_Properties.EDITING_STYLE_RECORD.getInt(0);//((DbBriefQtyHandler)dbHandler).recEditingStyle.getInt(0);
      String unit=(String)((DbBriefQtyHandler)dbHandler).recEditingStyle.get("STY_UNIT");
      if(unit.startsWith("DZ"))_isDzUnit=true;
      super.doInit();
      firstPage();

      /*
      Object objclk=getJtable().getColumnModel().getColumn(8).getHeaderValue();
      System.out.println("column 8 header is :"+((objclk==null)?"":objclk.toString()));
      System.out.println("column 8 column name is :"+getJtable().getColumnName(8));
      getJtable().getTableHeader().getColumnModel().getColumn(8).setHeaderValue("colum8");
      objclk=getJtable().getTableHeader().getColumnModel().getColumn(8).getHeaderValue();
      System.out.println("column 8 header is :"+((objclk==null)?"":objclk.toString()));
      System.out.println("column 8 column name is :"+getJtable().getColumnName(8));*/

      //initialize column name by the style's size column
      reBuilderTableHeader();
      //generateMap4ShippedColorPrx();
    }catch(Exception exp){
        exp.printStackTrace();
    }

  }

  public class CellRenderer extends javax.swing.JLabel
      implements javax.swing.table.TableCellRenderer{
      public CellRenderer(){
      super();
     setOpaque(true); /* it\u00B4s essential */
  }
   public java.awt.Component getTableCellRendererComponent(
         javax.swing.JTable table, Object value,
         boolean isSelected, boolean hasFocus,
         int row, int column){
         String text = (value==null)?"":value.toString();
         Record rec=(Record)getDisplayingRecords().get(row);
         //if shipped,mark the column pink.
         if(rec.getInt(46)>0){
           setBackground(new java.awt.Color(0xFF,0x90,0x90)); // Decides the color
           setText(text);
           return this;
         }
        //if(text.equals("Waiting")) /*
         setBackground(new java.awt.Color(0xFF,0xFF,0xFF)); // Decides the color
        setText(text); /* Put the current text in the JLabel */
     return this;
    }
  }

  public void reBuilderTableHeader()throws Exception{
    String sizeColumn = (String)((DbBriefQtyHandler)dbHandler).
        recEditingStyle.get("STY_SIZE_COLUMN");
     for(int i=0;i<14;i++){
       getJtable().getTableHeader().getColumnModel().getColumn(6+i).setHeaderValue("");
     }
     if(sizeColumn!=null && sizeColumn.trim().length()>0){
       String cls[]=util.MiscFunc.split(sizeColumn,",,");
       for(int i=0;i<cls.length;i++){
         getJtable().getTableHeader().getColumnModel().getColumn(6+i).setHeaderValue(cls[i]);
         htEditors.put(cls[i],fltVfyTempUse);
       }
     }
     //make header editable
     javax.swing.table.TableColumnModel columnModel = getJtable().getColumnModel();
     getJtable().setTableHeader(new BriefQtyTblHeader(columnModel));
     //doUpdate();
  }
  protected boolean isFtyPrxGreaterThanBuyerPrxChkOk(){
    if(COLUM_BUYER_DOC_PRX_AT==0)return true;
    for(int i=0;i<getDisplayingRecords().size();i++){
      //if(!getJtable().isCellEditable(i,COLUM_BUYER_DOC_PRX_AT))continue;
      Object totalQtyObj=getJtable().getValueAt(i,TOTAL_COLUMNAT);
      if(totalQtyObj==null || Float.parseFloat(totalQtyObj.toString())==0)continue;
      Object objBuyDocPrx=getJtable().getValueAt(i,COLUM_BUYER_DOC_PRX_AT);
      Object objBuyActPrx=getJtable().getValueAt(i,COLUM_BUYER_ACT_PRX_AT);
      Object objMkrDocPrx=getJtable().getValueAt(i,COLUM_MAKER_DOC_PRX_AT);
      Object objMkrActPrx=getJtable().getValueAt(i,COLUM_MAKER_ACT_PRX_AT);
      float buyDocPrx,buyActPrx,mkrDocPrx,mkrActPrx;
      buyDocPrx=Float.parseFloat((objBuyDocPrx==null||objBuyDocPrx.toString().length()==0)?"0":objBuyDocPrx.toString());
      buyActPrx=Float.parseFloat((objBuyActPrx==null||objBuyActPrx.toString().length()==0)?"0":objBuyActPrx.toString());
      mkrDocPrx=Float.parseFloat((objMkrDocPrx==null||objMkrDocPrx.toString().length()==0)?"0":objMkrDocPrx.toString());
      mkrActPrx=Float.parseFloat((objMkrActPrx==null||objMkrActPrx.toString().length()==0)?"0":objMkrActPrx.toString());
      if(mkrDocPrx>buyDocPrx || mkrActPrx>buyActPrx){
        getJtable().changeSelection(i,COLUM_BUYER_DOC_PRX_AT,false,false);
        getJtable().editCellAt(i,COLUM_BUYER_DOC_PRX_AT);
        boolean confirm=
            exgui.verification.VerifyLib.showConfirm("Maker Price Greater Than Buyer Price,Are You Sure ?",
                                                     "Maker Price Greater Than Buyer Price,Are You Sure ?",false);
        if(confirm){
          return true;
        }else{
          return false;
        }
      }
    }
    return true;
  }
  public void doDelete()throws Exception{
    Vector vctRec=null;
    if(getJtable().getSelectedRow()<0){
      exgui.verification.VerifyLib.showPlanMsg(
       "Please select a row to delete","Please select a row"
      );
      return;
    }
    if (exgui.verification.VerifyLib.showConfirm(
        "Are you Sure to delete this  record(s) ?",
        "Are You Sure to delete ?")
        ) {
       vctRec=new Vector();
       int rowselected[]=getJtable().getSelectedRows();
       //java.util.List prod_color_pk2delete=new java.util.ArrayList();
       for(int i=0;i<rowselected.length;i++){
         //Record rec2TestShip=(Record)hmUnEditableRowId.get(String.valueOf(rowselected[i]));
          Record rec=(Record)getDisplayingRecords().get(rowselected[i]);
         int shipCount= rec.getInt(46);
         if(shipCount>0){
           exgui.verification.VerifyLib.showAlert("Shipped Color-Prx Qty Could Not Be Deleted",
                                                  "Shipped Color-Prx Qty Could Not Be Deleted");
           return;
         }
         //Record rec = (Record)getDisplayingRecords().get(rowselected[i] );
         //vctRec.add(rec);
         /*
         if(rec2TestShip!=null){
           prod_color_pk2delete.add(rec2TestShip.get(1).toString());
         }
         */
         //clear that row...
         for(int j=COLUMN_QTY_1_AT;j<TOTAL_COLUMNAT+1;j++){
           getJtable().setValueAt(null, rowselected[i],j);
         }
         getJtable().setValueAt(new Integer(0), rowselected[i],TOTAL_COLUMNAT);
       }
       if(rowselected.length==0)return ;
       /*
       if(prod_color_pk2delete.size()>0){
         util.MiscFunc.showProcessingMessage();
           doPreDeleteColorRec((String[])prod_color_pk2delete.toArray(new String[]{}));
         util.MiscFunc.hideProcessingMessage();
       }
       */
      Cursor ksr=null;
      if(util.PublicVariable.APP_FRAME!=null){
       ksr=util.PublicVariable.APP_FRAME.getCursor();
       util.PublicVariable.APP_FRAME.setCursor(new Cursor(Cursor.WAIT_CURSOR));
      }
      util.MiscFunc.showProcessingMessage();
      doUpdate();
     }

  }
  class Hdle2updateQty implements Runnable{
    public void run(){
      try{
      //((DbBriefQtyHandler)dbHandler).update2QtyTable(currentStySeq);
      System.out.println("begin time:" + System.currentTimeMillis());
      DB_Trinity_PriceSizeQty orgQtyHandler= new DB_Trinity_PriceSizeQty();
      PnlNthkQtyTempPnl pnlShowTbl =
          new PnlNthkQtyTempPnl(orgQtyHandler);
      pnlShowTbl.firstPage();
      String tblTxt=newtimes.production.ProdMaintain_Properties.stylPriceSizeQtyTable2Text(
          pnlShowTbl.getJtable(),4);

      System.out.println("Table IS\n" +tblTxt);
      orgQtyHandler.udpateQtyTbl2Text(currentStySeq,tblTxt);
        System.out.println("End time:" + System.currentTimeMillis());
      }catch(Exception exp){
        exp.printStackTrace();
        util.ExceptionLog.exp2File(exp,"");
        exgui.verification.VerifyLib.showAlert("Warnning!! Exporting To Qty Table Fail,Please Notify System Manager",
                                               "Convert To Qty Table Fail");
      }finally{
        util.MiscFunc.hideProcessingMessage();
      }

    }
  }
  protected Vector getData2Update(Record headColRec)throws Exception{
    Vector vct=getDisplayingRecords();
    Vector vct2Return=new Vector();
    for(int i=0;i<vct.size();i++){
      Record rec=(Record)vct.get(i);
      Object totalObj=getJtable().getValueAt(i,TOTAL_COLUMNAT);

      Object colorNameObj=getJtable().getValueAt(i,COLUMN_COLOR_NAME_AT);
      String colorName=
          (colorNameObj==null||colorNameObj.toString().trim().length()==0)?"NONE":colorNameObj.toString().trim();
      Object colorCodeObj=getJtable().getValueAt(i,COLUMN_COLOR_CODE_AT);
      String colorCode=
          (colorCodeObj==null||colorCodeObj.toString().trim().length()==0)?"NONE":colorCodeObj.toString().trim();
      rec.set(2,colorCode);
      rec.set(3,colorName);

      Object objBuyerActPrx=getJtable().getValueAt(i,COLUM_BUYER_ACT_PRX_AT);
      rec.set(4,objBuyerActPrx);

      Object objBuyerDocPrx=getJtable().getValueAt(i,COLUM_BUYER_DOC_PRX_AT);
      rec.set(5,objBuyerDocPrx);

      Object objMakerActPrx=getJtable().getValueAt(i,COLUM_MAKER_ACT_PRX_AT);
      rec.set(6,objMakerActPrx);

      Object objMakerDocPrx=getJtable().getValueAt(i,COLUM_MAKER_DOC_PRX_AT);
      rec.set(7,objMakerDocPrx);

      float total=(totalObj==null||totalObj.toString().trim().length()==0)?0:Float.parseFloat(totalObj.toString());
      for(int j=COLUMN_QTY_1_AT;j<TOTAL_COLUMNAT ;j++) {
        Object columName=headColRec.get(8+(j-COLUMN_QTY_1_AT));
        if(columName==null||columName.toString().trim().length()==0){
          rec.set(8+(j-COLUMN_QTY_1_AT),null);
        }else{
          rec.set(8+(j-COLUMN_QTY_1_AT),getJtable().getValueAt(i,j));
        }
      }
      if(total==0 && rec.getInt(25)==-1){
        //skip it
        continue;
      }
      vct2Return.add(rec);
      /*
      if(total==0){
        if(rec.getInt(0)>0){
          rec.set(25,"0");//record delete flag='0'
          vct2Return.add(rec);
        }
      }else{
        //this is to update,for negtive
        vct2Return.add(rec);
      }
      */

    }
    return vct2Return;
  }
  protected void updateStatusApp2Pendding()throws Exception{
    return;
    /*
    //is to update,if buyer is changed,have to update approval to pendding mode
    int statusCode=0;
    Object objStatus=
        newtimes.preproduction.Constants.CURRENT_PREPROD_HEAD_RECORD.get("PRODUCTION_AUDIT_STATUS");
    if(objStatus!=null)statusCode=Integer.parseInt(objStatus.toString());
    if(statusCode==1||statusCode==2)return;//no need to update po status.
    String sc_no=(String)newtimes.preproduction.Constants.CURRENT_PREPROD_HEAD_RECORD.get("prod_sc_no");
    newtimes.nthk_enqry.EnqDataEngin4Status.updatePoStatus(
     sc_no,
     "1","Price/Color/Qty Changed Changed");
     newtimes.preproduction.Constants.CURRENT_PREPROD_HEAD_RECORD.set("PRODUCTION_AUDIT_STATUS","1");
     newtimes.preproduction.Constants.CURRENT_PREPROD_HEAD_RECORD.getModifiedFields().clear();
     */
 }


  public void doUpdate(){
    try{
      if(!isFtyPrxGreaterThanBuyerPrxChkOk())return;
      util.MiscFunc.showProcessingMessage();
      Record headColumnRec=dbHandler.getBlankRecord();
      StringBuffer sb=new StringBuffer();
      for(int i=0;i<14;i++){
        Object objHeadValue=
            getJtable().getTableHeader().getColumnModel().getColumn(6+i).getHeaderValue();
        if(objHeadValue==null)objHeadValue="";
        headColumnRec.set(8+i,objHeadValue.toString().trim());
        if(i>0)sb.append(",,");
        sb.append(objHeadValue.toString().trim());
      }

      //make sure all the total field head add to toal column
      if(!getMultiEditorJTable().isTableOk()) return ;
      //make sure the shipped-color could not be zero qty
      for(int i=0;i<getJtable().getRowCount();i++){
        Record rec=(Record)getDisplayingRecords().get(i);
        int shipCount=rec.getInt(46);
        if(shipCount>0 ){
          Object totalValue=getJtable().getValueAt(i,TOTAL_COLUMNAT);
          float total=(totalValue==null)?0:Float.parseFloat(totalValue.toString());
          if(total==0){
            exgui.verification.VerifyLib.showAlert("Row:"+String.valueOf(i+1)+" Shipped\nCan Not Set Qty Zero",
                                                   "Row Can not delete");
            return;
          }
        }
      }


      _records2Update=kvtModifiedField2Records(
              getMultiEditorJTable().getModifiedRowAndColumn()
      );

      ((DbBriefQtyHandler)dbHandler).recEditingStyle.set("STY_SIZE_COLUMN",sb.toString());
      ((DbBriefQtyHandler)dbHandler).updateRecords(
         getData2Update(headColumnRec),headColumnRec);

      /*
      ((DbBriefQtyHandler)dbHandler).updateRecords(_records2Update,headColumnRec);
      _records2Update.removeAllElements();
      */
      table_snapshot=util.MiscFunc.table2Text(getJtable());
      newtimes.production.process.prodmaintain.ToListNthkStyQty qtyHandler=
      new newtimes.production.process.prodmaintain.ToListNthkStyQty();
         qtyHandler.showQty4Reload((DbBriefQtyHandler)dbHandler);
      updateStatusApp2Pendding();

      //Thread updateQtyTxtThread=new Thread(new Hdle2updateQty());
      //updateQtyTxtThread.start();

      Hdle2updateQty hdl=new Hdle2updateQty();
      hdl.run();

    }catch(Exception exp){
        exp.printStackTrace();
        exgui.verification.VerifyLib.showAlert("Update Faile,Please Contact System Manager",
                                               "Sever side Error");
    }finally{
      util.MiscFunc.hideProcessingMessage();
    }
  }
  class BriefQtyTblHeader extends exgui.EditableHeader {
    FosucListenser fxListen=new FosucListenser(this);
    BriefQtyTblHeader(javax.swing.table.TableColumnModel clmMdl){
      super(clmMdl);
      //addFocusListener(new FosucListenser(this));

    }
    class FosucListenser extends java.awt.event.FocusAdapter{
      BriefQtyTblHeader objTblHeader;
      FosucListenser(BriefQtyTblHeader hndl){objTblHeader=hndl;}
      public void focusLost(java.awt.event.FocusEvent fe) {
         System.out.println("BriefQtyTblHeader is lost focused ");
         objTblHeader.editingStopped(null);
      }
    }
    public boolean editCellAt(int index, java.util.EventObject e){
      getJtable().editCellAt(-1,index);//force editor to lose focus
      boolean result=super.editCellAt(index,e);
      if(super.editorComp != null){
        super.editorComp.addFocusListener(fxListen);
      }
      return result;
    }

    protected void recreateTableColumn(TableColumnModel columnModel) {
      if(IS_AFTER_SHIPPED)return;
      int n = columnModel.getColumnCount()-6;//qty is between column 6 and (total qty)-1
      EditableHeaderTableColumn[] newCols = new EditableHeaderTableColumn[n];
      TableColumn[] oldCols = new TableColumn[n];
      for (int i=0;i<n;i++) {
        oldCols[i] = columnModel.getColumn(6+i);
        newCols[i] = new EditableHeaderTableColumn();
        newCols[i].copyValues(oldCols[i]);
      }
      for (int i=0;i<n;i++) {
        columnModel.removeColumn(oldCols[i]);
      }
      for (int i=0;i<n;i++) {
        columnModel.addColumn(newCols[i]);
      }
    }
    public boolean isCellEditable(int index) {
      if(index==columnModel.getColumnCount()-1)return false;
      return super.isCellEditable(index);
    }
    public void editingStopped(javax.swing.event.ChangeEvent e) {
      TableCellEditor editor = getCellEditor();
      if (editor != null) {
        int index = getEditingColumn();
        Object orgValue=columnModel.getColumn(index).getHeaderValue();
        Object value = editor.getCellEditorValue();
        if(orgValue.toString().equals(value.toString())){
          removeEditor();
          return;
        }
        if(value!=null && value.toString().trim().length()>0){

          if(value instanceof String){
            value=value.toString().toUpperCase();
            if(value.toString().length()>8){
              value=value.toString().substring(0,8);
            }
            if(value.toString().indexOf(",,")!=-1){
              exgui.verification.VerifyLib.showAlert("\",,\" IS NOT ALLOWED TO BE COLUMN NAME",
                                                     "Column Name Invalid");
               columnModel.getColumn(index).setHeaderValue(orgValue);
               removeEditor();
               return;

            }
            if(htEditors.containsKey(value.toString())){
                exgui.verification.VerifyLib.showAlert("Column "+value+" Already Defined",
                                                       "Column Already Defined");
                 columnModel.getColumn(index).setHeaderValue(orgValue);
                 removeEditor();
                 return;
            }else{
                htEditors.remove(orgValue.toString());
                htEditors.put(value.toString(), fltVfyTempUse);
            }
          }
        }

        columnModel.getColumn(index).setHeaderValue(value);
        removeEditor();
        //System.out.println("Head column edit stopped");
        //clear cell data if header is cleaerd
        if(value==null || value.toString().trim().length()==0){
          htEditors.remove(orgValue.toString());
          for(int i=0;i<40;i++){
            getJtable().setValueAt(null,i,index);
            fltVfyTempUse.sumTheRow(i);
          }
        }
      }
    }
  }
  /*
  public void doPreDeleteColorRec(String prod_color_pk[])throws Exception{
    if(prod_color_pk==null || prod_color_pk.length==0)return;
      newtimesejb.TPE_MIS.TpeMisFuncHome tpeEjbHome=
          (newtimesejb.TPE_MIS.TpeMisFuncHome)
          info_ejb.WeblogicServiceLocator.locateServiceHome(
            util.PublicVariable.SERVER_URL,
            "newtimesejb.TPE_MIS.TpeMisFunc"
          );
      newtimesejb.TPE_MIS.TpeMisFunc ejb=tpeEjbHome.create();
      java.util.HashMap hmPara=new java.util.HashMap();
      hmPara.put("TPEMISCFUNC_ACTION_CODE","DO_PRE_DELETE_PROD_COLOR");
      hmPara.put("PROD_COLOR_PK_LIST",prod_color_pk);
      hmPara.put("user_code",util.PublicVariable.USER_RECORD.get(0));
      ejb.tpeMisFunc(hmPara);
  }
  */
  public class MyCellEditablePolicy implements exgui.CellEditablePolicy {
    public boolean isCellEditable(int row,int col){
      if(col==getJtable().getColumnCount()-1)return false;
     Object objclk=getJtable().getTableHeader().getColumnModel().getColumn(col).getHeaderValue();
      if(objclk==null || objclk.toString().trim().length()==0){
        return false;
      }
      if(IS_AFTER_SHIPPED){
        Record rec=(Record)getDisplayingRecords().get(row);
        if(rec.getInt(46)>0){
        //if is shipped color-prx,only allow to edit qty
         //if(col<6)return false;
          return false;
        }
      }
      return true;
    }
  }

  public boolean isDzUnit(){return _isDzUnit;}
  protected Record setObject2Record(Record rec, int columnAt, Object value2update) {
    /**@todo Implement this exgui.ultratable.AbstractUltraTablePanel abstract method*/
    //throw new java.lang.UnsupportedOperationException("Method setObject2Record() not yet implemented.");
    try{
      rec.set(storedRecordColumn[columnAt],value2update);
      return rec;
    }catch(Exception exp){
      exp.printStackTrace();
      return null;
    }
  }
  protected InsertionOrderedHashMap getHeadColumnMap() {
    /**@todo Implement this exgui.ultratable.AbstractUltraTablePanel abstract method*/
    //throw new java.lang.UnsupportedOperationException("Method getHeadColumnMap() not yet implemented.");
    //color code,name,4 prices ,qty 1 ~14 qty_total
    util.InsertionOrderedHashMap iso=new util.InsertionOrderedHashMap();
    iso.put(COLUMN_COLOR_CODE,"COLOR_CODE");
    iso.put(COLUMN_COLOR_DESC,"COLOR_NAME");

    COLUM_BUYER_DOC_PRX_AT=iso.entrySet().size();
    iso.put(COLUMN_BUYER_DOC_PRX,"BYR_DOC_PRX");

    COLUM_BUYER_ACT_PRX_AT=iso.entrySet().size();
    iso.put(COLUMN_BUYER_ACT_PRX,"BYR_ACT_PRX");

    COLUM_MAKER_DOC_PRX_AT=iso.entrySet().size();
    iso.put(COLUMN_MAKER_DOC_PRX,"MKR_DOC_PRX");

    COLUM_MAKER_ACT_PRX_AT=iso.entrySet().size();
    iso.put(COLUMN_MAKER_ACT_PRX,"MKR_ACT_PRX");

    COLUMN_QTY_1_AT=iso.entrySet().size();
    for(int i=1;i<15;i++){
      iso.put("_"+String.valueOf(i)+"_","QTY_"+i);
    }

    try{
      isOnlyTotalQty = false;
      /*
      String sizeColumn = (String)((DbBriefQtyHandler)dbHandler).
          recEditingStyle.get("STY_SIZE_COLUMN");
      if(sizeColumn==null)sizeColumn="";
      if(sizeColumn.trim().length()==0){
        headClm4Size=null;
        isOnlyTotalQty = true;
        TOTAL_COLUMNAT=iso.entrySet().size();
        iso.put("TOTAL","QTY_TTL");
      }else{
        String szClm[]=util.MiscFunc.split(sizeColumn,",,");
        headClm4Size=util.MiscFunc.split(sizeColumn,",,");
        for(int i=0;i<szClm.length;i++){
          iso.put(szClm[i],"QTY_"+(i+1));
        }
        TOTAL_COLUMNAT=iso.entrySet().size();
        iso.put("TOTAL","QTY_TTL");
      }
      */
     TOTAL_COLUMNAT=iso.entrySet().size();
     iso.put("TOTAL","QTY_TTL");
      return iso;
    }catch(Exception exp){
      exp.printStackTrace();
      util.ExceptionLog.exp2File(exp,"");
    }
    return iso;
    //return null;
  }
  public void doPrint() throws java.lang.Exception {
    /**@todo Implement this processhandler.DataProcesser abstract method*/
  }
  protected int getEachPageRowCount() {
    /**@todo Implement this exgui.ultratable.AbstractUltraTablePanel abstract method*/
    //throw new java.lang.UnsupportedOperationException("Method getEachPageRowCount() not yet implemented.");
    return 99999999;
  }
  protected void refineEditors(MultiEditorJTable multiEditorJTableInSuper) {
    /**@todo Implement this exgui.ultratable.AbstractUltraTablePanel abstract method*/
    multiEditorJTableInSuper.setTextEditorVerifiers(getObject2StringConvertor());
    ((exgui.MultiClassTableModel)getJtable().getModel()).setCellEditablePolicy(
     new MyCellEditablePolicy());

   CellRenderer rdr=new CellRenderer();
  this.getJtable().getColumnModel().getColumn(0).setCellRenderer(rdr);
  this.getJtable().getColumnModel().getColumn(1).setCellRenderer(rdr);
  this.getJtable().getColumnModel().getColumn(2).setCellRenderer(rdr);
  this.getJtable().getColumnModel().getColumn(3).setCellRenderer(rdr);
  this.getJtable().getColumnModel().getColumn(4).setCellRenderer(rdr);
  this.getJtable().getColumnModel().getColumn(5).setCellRenderer(rdr);

  }
  protected Hashtable getObject2StringConvertor() {
    /**@todo Implement this exgui.ultratable.AbstractUltraTablePanel abstract method*/
    //throw new java.lang.UnsupportedOperationException("Method getObject2StringConvertor() not yet implemented.");
    htEditors.clear();
    exgui.ultratable.CellTxtEditorFormat vfyPrices=new VfyFOBPrx();
    Object objCharColorCode=exgui.verification.CellFormat.getOrdinaryField(10);
    Object objCharColorName=exgui.verification.CellFormat.getOrdinaryField(30);

    htEditors.put(COLUMN_COLOR_CODE,objCharColorCode);
    htEditors.put(COLUMN_COLOR_DESC,objCharColorName);
    htEditors.put(COLUMN_BUYER_ACT_PRX ,vfyPrices);
    htEditors.put(COLUMN_BUYER_DOC_PRX ,vfyPrices);
    htEditors.put(COLUMN_MAKER_ACT_PRX ,vfyPrices);
    htEditors.put(COLUMN_MAKER_DOC_PRX,vfyPrices);
    for(int i=1;i<15;i++){
       htEditors.put("_"+i+"_",fltVfyTempUse);
    }
    return htEditors;
  }


  protected class myfldVfyObj implements exgui.ultratable.CellTxtEditorFormat,exgui.Object2String{

   int _maxLength=0;
   int _intDigitLength=0,_floatDigitLength=0;
   String headString,tailString;
   String orgWarnningMsg="String must be in float format,such as 12345.91";
   String warnningMsg=null;
   String decimalPartString=".0.00.08.16.25.33.41.50.58.66.75.83.91.";
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
   public String formatPromptMsg(){
     return warnningMsg;
   }
   public boolean isFormatValid(String org_inStr,int row,int column){
          String inStr=org_inStr;
          //if(column<=6)return true;
          if(inStr==null||inStr.trim().length()==0){
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
                    if(arrDgs[1].length()==1)arrDgs[1]=arrDgs[1]+"0";
                    if(decimalPartString.indexOf(arrDgs[1])==-1){
                      warnningMsg="The Number of Size Qty after the Decimal Point should be one of fallowing :\n"+
                      "00,08,16,25,33,41,50.58,66,75,83,91";
                      return false;
                    }
                  }
               return true;
             }else{
               return true;
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


  public class FLOAT_QTY_VFY implements exgui.ultratable.CellTxtEditorFormat ,exgui.Object2String{
   int _maxLength=0;
   Object myIntVfy=null;
   public  FLOAT_QTY_VFY(int maxLength){
      _maxLength=maxLength;
       myIntVfy=new myfldVfyObj(7,2); //exgui.verification.CellFormat.getDoubleFormat(7,2);
   }
   public int getMaxLength(){return _maxLength;}
   public String formatPromptMsg(){
     //return "String Must be numeric";
     return ((myfldVfyObj)myIntVfy).formatPromptMsg();
   }

   public KeyProcess getKeyListener(){
    return ((exgui.ultratable.CellTxtEditorFormat)myIntVfy).getKeyListener();
   }
   protected synchronized void sumTheRow(int row){
     System.out.println("calles sumTheRow,row at:"+row);
     float total=0;
     for(int i=6;i<TOTAL_COLUMNAT;i++){
       Object obj=getJtable().getValueAt(row,i);
       Object objclk=getJtable().getTableHeader().getColumnModel().getColumn(i).getHeaderValue();
       //System.out.println("obj in cell:"+row+","+i+" is:"+((obj==null)?"0":obj.toString()));

       if(objclk==null|| objclk.toString().trim().length()==0)continue;//this column should not add to total.
       if(obj!=null && obj.toString().trim().length()!=0) total+=Float.parseFloat(obj.toString());
       //00,08,16,25,33,41,50.58,66,75,83,91
     }
     //convert decimal part to Dz-persent degit.
     if(isDzUnit()){
       String floatData[] = util.MiscFunc.split(Dzformatter.format(total), ".");
       int decPart = java.lang.Math.round(Float.parseFloat("0." + floatData[1]) *12);
       //System.out.println("dec part of total in pc:"+decPart);
       float finalFloat = Float.parseFloat(floatData[0] + "." +
                                           dzDecimal[decPart]);
       if(floatData[1].equals("99"))finalFloat+=1;
       getJtable().setValueAt(formatter.format(finalFloat), row,
                              TOTAL_COLUMNAT);
     }else{
       float finalFloat=total;
       getJtable().setValueAt(formatter.format(finalFloat), row,
                              TOTAL_COLUMNAT);

     }
   }
   public boolean isFormatValid(String inStr,int row,int column){
      if(!((exgui.ultratable.CellTxtEditorFormat)myIntVfy).isFormatValid(inStr,row,column))return false;
      getJtable().setValueAt(inStr,row,column);
      sumTheRow(row);
      return true;
   };
    public Object cellStringToObject(String String2kvt){
      return ((exgui.ultratable.CellTxtEditorFormat)myIntVfy).cellStringToObject(String2kvt);
    }
   public String Obj2String(Object obj){
      return ((exgui.Object2String)myIntVfy).Obj2String(obj);
   }
 }


  protected PagedDataFactory getPagedDataFactory() {
    /**@todo Implement this exgui.ultratable.AbstractUltraTablePanel abstract method*/
   // throw new java.lang.UnsupportedOperationException("Method getPagedDataFactory() not yet implemented.");

    return dbHandler;
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
      for(int i=3;i<6;i++){
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

}
