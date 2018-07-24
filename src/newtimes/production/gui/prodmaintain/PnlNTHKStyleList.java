package newtimes.production.gui.prodmaintain;

import processhandler.template.PnlTableEditor;
import exgui.ultratable.*;
import database.datatype.*;
import util.InsertionOrderedHashMap;
import processhandler.*;
import java.util.Hashtable;
import java.util.Vector;
import java.awt.Component;
import javax.swing.table.TableCellRenderer;
import javax.swing.JLabel;
import javax.swing.*;
/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class PnlNTHKStyleList extends PnlTableEditor{
 //STY_STYLE, STY_PO, STY_NO, STY_SC_NO,
 // STY_ORIG_DEL, STY_ORIG_WAY, STY_RECFM_DEL, STY_RECFM_SHIP,
 //STY_UPDT, STY_UPDT_SHIP, STY_OFF_SHORE, STY_OFF_SHORE_SHIP,
  static String DISP_STY_CT_SEQ="C/T\nSEQ";
  static String DB_STY_CT_SEQ="prod_head_pk";
  static String DISP_STY_STYLE="STYLE  \nNO";
  static String DB_STY_STYLE="STY_STYLE";
  static String DB_STY_NO="STY_NO";
  static String DISP_STY_NO="Print\nSEQ.";
  static String DISP_STY_PO="PO  ";
  static String DB_STY_PO="STY_PO";

  static String DISP_STY_QTY=" QTY. ";
  static String DB_STY_QTY="total_Qty";//joined and summed from qty of specified style seqence
  static String DB_STY_QTY_REC_COUNT="qty_rec_count";//joined and summed from qty of specified style seqence
  //STY_BUY_COMM, STY_MKR_DSCT_PER, STY_MKR_DSCT_PC,
  //STY_MKR_DSCT_DZ, STY_CMT_PRICE, , STY_YY4, STY_QTA_CAT
  static String DISP_STY_QTA="QTA¡¿  ";
  static String DB_STY_QTA="STY_QTA";
  static String DISP_STY_BUY_COMM="BUY\nCOMM%";
  static String DB_STY_BUY_COMM="STY_BUY_COMM";
  static String DISP_STY_MKR_DISC="MAKER\nDISCOUNT%";
  static String DB_STY_MKR_DISC="STY_MKR_DSCT_PER";
  static String DISP_STY_MKR_DSCT_PC="MAKER\nDISCOUNT\nPC";
  static String DB_STY_MKR_DSCT_PC="STY_MKR_DSCT_PC";
  static String DISP_STY_MKR_DSCT_DZ="MAKER\nDISCOUNT\nDZ";
  static String DB_STY_MKR_DSCT_DZ="STY_MKR_DSCT_DZ";

  static String DISP_STY_MKR_DSCT_LUMP_SUM="MAKER\nDISTCOUNT\nLUMP SUM";
  static String DB_STY_MKR_DSCT_LUMP_SUM="STY_MKR_DSCT_LUMP_SUM";


  static String DISP_STY_BUY_DSCT_PC="BUYER\nCOMMISION\nPC";
  static String DB_STY_BUY_DSCT_PC="STY_BUY_DSCT_PC";
  static String DISP_STY_BUY_DSCT_DZ="BUYER\nCOMMISION\nDZ";
  static String DB_STY_BUY_DSCT_DZ="STY_BUY_DSCT_DZ";

  static String DISP_STY_BUY_DSCT_LUMP_SUM="BUYER\nCOMMISION\nLUMP SUM";
  static String DB_STY_BUY_DSCT_LUMP_SUM="STY_BUY_DSCT_LUMP_SUM";



  static String DISP_STY_FOB_RPX="Buyer\nDoc\nPRICE";
  static String DB_STY_FOB_PRX="FOB_PRICE";//joined from price table,only for the first row of current style sequence

  //STY_YY1, STY_YY2, STY_YY3

  static String DB_STY_UNIT="STY_UNIT";
  static String DISP_STY_UNIT="UNIT¡¿";//"UNIT¡¿";

  static String DB_STY_BARCODE="STY_BARCODE";
  static String DISP_STY_BARCODE="    BARCODE    ";

  static String DB_STY_BUYER_LABEL="STY_BUYER_LABEL";
  static String DISP_STY_BUYER_LABEL="      BUYER LABEL      ";

  static String DB_BYR_ACT_PRX="byr_act_prx";
  static String DISP_BYR_ACT_PRX="ACT.";
  static String DB_BYR_DOC_PRX="byr_doc_prx";
  static String DISP_BYR_DOC_PRX="DOC.";

  static String DB_MKR_ACT_PRX="mkr_act_prx";
  static String DISP_MKR_ACT_PRX="ACT. ";

  static String DB_MKR_DOC_PRX="mkr_doc_prx";
  static String DISP_MKR_DOC_PRX="DOC. ";

  static String DB_DLV_DATE="STY_ORIG_DEL";
  static String DISP_DLV_DATE="DLVY\nDATE";

  static String DB_RECFM_DATE="STY_RECFM_DEL";
  static String DISP_RECFM_DATE="REVISED\nDATE";


  static String DB_SHIP_MODE="STY_ORIG_WAY";
  static String DISP_SHIP_MODE="SHIP\nMODE¡¿";

  static String DB_RECFM_SHIP_MODE="STY_RECFM_SHIP";
  static String DISP_RECFM_SHIP_MODE="RECF\nSHIP¡¿";


  static String DB_MKR_DLV="STY_MKR_DEL";
  static String DISP_MKR_DLV="MAKER\nDLVY";

  static String DB_STY_DRUP_DEST="STY_LC_LIST_NO";
  static String DISP_STY_DRUP_DEST="DROP SHIPMEMT\nDEST¡¿";


  static public int UNIT_COLUMN_AT=5;
  static public int QTY_COLUMN_AT=4;
  static public int STY_NO_CLUMN_AT=-1;
  static int MKR_DISCT_PC_AT=-1;
  static int BYR_DISCT_PC_AT=-1;
  static int MKR_DISCT_DZ_AT=-1;
  static int BYR_DISCT_DZ_AT=-1;
  static int MKR_DISCT_LUMPSUM_AT=-1;
  static int BYR_DISCT_LUMPSUM_AT=-1;
  static int BYR_COMM_PER_AT=-1;
  static int MKR_DISCT_PER_AT=-1;
  static int BYR_ACT_PRX_AT=-1;
  static int BYR_DOC_PRX_AT=-1;
  static int MKR_ACT_PRX_AT=-1;
  static int MKR_DOC_PRX_AT=-1;
  static int DB_STY_QTY_TYPE_AT=26;
  static int SHIP_MODE_AT=-1;
  static int BARCODE_COLUMN_AT=-1,BUYER_LABEL_COLUMN_AT=-1;
  static public int CAT_DATA_COLUMN_AT=-1;
  static public int RECFM_DATE_AT=-1;
  static public int RECFM_SHIP_AT=-1;
  static public int SHIP_DRUP_DEST_AT=-1;
  static int MKR_DVL_DATE_AT=-1;
  static int ORG_DLV_DATE_AT=-1;
  boolean addSlkListenered=false;
  myListSelectionListener myRowSelectionHandler=null;
  javax.swing.JButton btnSequenceStyles=new javax.swing.JButton("Style Default Setting");
  javax.swing.JButton btnMdfStylesSettings=new javax.swing.JButton("Update Prod. Info");
  javax.swing.JButton btnMoveStyles2OtherProd=new javax.swing.JButton("Move To Other PO.");
  javax.swing.JButton btnCopyStyles2OtherProd=new javax.swing.JButton("Copy To Other PO.");
  javax.swing.JButton btnCopyPastePrice=new javax.swing.JButton("Copy & Paste Price");
  java.util.HashMap hmQTY_STYLE_SEQ_KEY_VALUE=new java.util.HashMap();
  java.util.HashMap hmPrxRec_STYLE_SEQ_KEY_VALUE=new java.util.HashMap();
  java.util.HashMap hmRowAndRecMapping=new java.util.HashMap();
  static java.text.DateFormat df=new java.text.SimpleDateFormat("yyyy/MM/dd");
  static Record blankPriceRec=null;
  boolean qtyIsOk=true;
  boolean isProcessingTlbOkChk=false;
  boolean isGoPageAfterUpdate=false;
  protected java.util.HashMap hmCtMapKeyIsProdPk;
  protected java.util.HashMap hmCtMapKeyIsCtSeq;
  java.util.Vector vctCtSeqList4ShippingCheck=null;
  public static boolean IS_EDIT_AFTER_SHIPPED;
  String copiedStySeq=null;
  public PnlNTHKStyleList() {
    //super object make the jtable.we need to show current page.
    //super();
    int rowBeginAt=0;
    if(util.ApplicationProperites.getProperties("PnlNTHKStyleList_beginRow_at")!=null){
        rowBeginAt=((Integer)util.ApplicationProperites.getProperties("PnlNTHKStyleList_beginRow_at")).intValue();
    }
    if(rowBeginAt==0)
       rowBeginAt=1;
    this._rowPosition=rowBeginAt;
    this.reload();
    //set to default style record of current page,even non-selected
    if(getDisplayingRecords().size()>0){
      database.datatype.Record rec =
          (database.datatype.Record)getDisplayingRecords().get(0);
      newtimes.production.ProdMaintain_Properties.
          CURRENT_SELECTED_STYLE_SEQ_IN_STYLE_LIST =
          rec.getInt(0);
      newtimes.production.ProdMaintain_Properties.EDITING_STYLE_RECORD = rec;
    }

    getJtable().addMouseMotionListener(
          newtimes.production.ProdMaintain_Properties.getJTableToolTipGenerator(getJtable(),1)
          );

      btnSequenceStyles.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent e) {
            openSequencialStyles();
        }
      });



    btnMdfStylesSettings.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent e) {
          openChangeStyleAtts();
      }
    });
    btnMoveStyles2OtherProd.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent e) {
          moveStlyes2OtherPo();
      }
    });

    btnCopyStyles2OtherProd.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent e) {
          copyStyle2OtherPo();
      }
    });

    btnCopyPastePrice.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent e) {
          CopyPastePriceBetweenColumns();
      }
    });

 if(newtimes.production.ProdMaintain_Properties.isAbleToEdit()){
  if(util.PublicVariable.OPERATTING_CENTER.equals("NTHK")){
   getPanelContainsButtons().removeAll();
   super.getLowerRightPanel().add(btnCopyPastePrice);
  }

  super.getLowerRightPanel().add(btnSequenceStyles);
  super.getLowerRightPanel().add(btnMdfStylesSettings);
  try{
    int user_type = util.PublicVariable.USER_RECORD.getInt("USR_TYPE");
    switch (user_type) {
      case newtimesejb.preproduction.PreProductionHead.USER_TYPE_OTHERS:
      case newtimesejb.preproduction.PreProductionHead.
          USER_TYPE_ACCOUNTING_USERS:
      case newtimesejb.preproduction.PreProductionHead.
          USER_TYPE_SHIPPING_USERS:
        btnSequenceStyles.setEnabled(false);
        btnMdfStylesSettings.setEnabled(false);
        btnMoveStyles2OtherProd.setEnabled(false);
        btnCopyStyles2OtherProd.setEnabled(false);
    }
  }catch(Exception exp){}

  //only NTHK require this function.
  if(util.PublicVariable.OPERATTING_CENTER.equals("NTHK")){
    super.getLowerRightPanel().add(btnMoveStyles2OtherProd);
    super.getLowerRightPanel().add(btnCopyStyles2OtherProd);
  }
 }

  newtimes.preproduction.Constants.addPopEditorMenue(this);
  getJtable().addMouseListener(new QtyCellClickClass());
 }
  class QtyCellClickClass extends java.awt.event.MouseAdapter{
    public void mouseClicked(java.awt.event.MouseEvent me){
      int selectedRow=getJtable().getEditingRow();
      if(selectedRow==-1)selectedRow=getJtable().getSelectedRow();
      /*if(me.getClickCount()==2 ){
          setCursor(new java.awt.Cursor(java.awt.Cursor.WAIT_CURSOR));
        try{
          newtimes.production.ProdMaintain_Properties.EDITING_STYLE_RECORD=
              (Record)getDisplayingRecords().get(selectedRow);
          newtimes.production.ProdMaintain_Properties.CURRENT_SELECTED_STYLE_SEQ_IN_STYLE_LIST=
            newtimes.production.ProdMaintain_Properties.EDITING_STYLE_RECORD.getInt(0);
          processhandler.template.Properties.getCenteralControler().doCommandExecute(
          new newtimes.production.process.prodmaintain.TgrToListStyQty());
        }catch(Exception exp){
          exp.printStackTrace();
          util.ExceptionLog.exp2File(exp,"exp while swith to qty");
        }finally{
          setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        }
        return ;
      }*/
      JTable tbl=getJtable();
      if(tbl.getSelectedColumn()==QTY_COLUMN_AT && me.getClickCount()==2){
        newtimes.production.ProdMaintain_Properties.EDITING_STYLE_RECORD=
           (Record)getDisplayingRecords().get(selectedRow);
       newtimes.production.ProdMaintain_Properties.CURRENT_SELECTED_STYLE_SEQ_IN_STYLE_LIST=
         newtimes.production.ProdMaintain_Properties.EDITING_STYLE_RECORD.getInt(0);
         setCursor(new java.awt.Cursor(java.awt.Cursor.WAIT_CURSOR));
        try{
          processhandler.template.Properties.getCenteralControler().doCommandExecute(
          new newtimes.production.process.prodmaintain.TgrToListStyQty());
        }catch(Exception exp){
          exp.printStackTrace();
          util.ExceptionLog.exp2File(exp,"exp while swith to qty");
        }finally{
          setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        }

      }
    }
  }
  protected void makeTable(java.util.Vector vct){
    hmRowAndRecMapping.clear();
    for(int i=0;i<vct.size();i++){
      Record rec=(Record)vct.get(i);
      hmRowAndRecMapping.put(String.valueOf(rec.getInt(0)),String.valueOf(i));
    }
    vctCtSeqList4ShippingCheck=new Vector();
    super.makeTable(vct);

    for(int i=0;i<getJtable().getRowCount();i++){
      vctCtSeqList4ShippingCheck.add(getJtable().getValueAt(i,0).toString());
    }

     //adjust the table column of size
       getJtable().getColumnModel().getColumn(0).setPreferredWidth(40); //C/T SEQ.
       getJtable().getColumnModel().getColumn(1).setPreferredWidth(70); //style name
       getJtable().getColumnModel().getColumn(2).setPreferredWidth(70); //sty no
       if(STY_NO_CLUMN_AT!=-1){
         getJtable().getColumnModel().getColumn(STY_NO_CLUMN_AT).setPreferredWidth(
             40); //sty no seq field
       }
       getJtable().getColumnModel().getColumn(QTY_COLUMN_AT).setPreferredWidth(70); //QTY colum

       getJtable().getColumnModel().getColumn(QTY_COLUMN_AT+1).setPreferredWidth(70); //unit

       if(util.PublicVariable.OPERATTING_CENTER.equals("NTHK")){
         getJtable().getColumnModel().getColumn(BYR_DOC_PRX_AT).setPreferredWidth(
             45); //buyr doc prx
         getJtable().getColumnModel().getColumn(BYR_ACT_PRX_AT).setPreferredWidth(
             45); //buyr doc prx
         getJtable().getColumnModel().getColumn(MKR_DOC_PRX_AT).setPreferredWidth(
             45); //buyr doc prx
         getJtable().getColumnModel().getColumn(MKR_ACT_PRX_AT).setPreferredWidth(
             45); //buyr doc prx
       }

       //getJtable().getColumnModel().getColumn(MKR_ACT_PRX_AT+1).setPreferredWidth(45); //CMT
       if(BYR_COMM_PER_AT!=-1) getJtable().getColumnModel().getColumn(BYR_COMM_PER_AT).setPreferredWidth(60); //buyr comm %
       if(MKR_DISCT_PER_AT!=-1)getJtable().getColumnModel().getColumn(MKR_DISCT_PER_AT).setPreferredWidth(85); //maker discount %
       if(BYR_DISCT_PC_AT!=-1)getJtable().getColumnModel().getColumn(BYR_DISCT_PC_AT).setPreferredWidth(80); //buyr comm pc
       if(MKR_DISCT_PC_AT!=-1)getJtable().getColumnModel().getColumn(MKR_DISCT_PC_AT).setPreferredWidth(70); //maker discount pc
       if(BYR_DISCT_DZ_AT!=-1)getJtable().getColumnModel().getColumn(BYR_DISCT_DZ_AT).setPreferredWidth(75); //buyr comm %
       if(MKR_DISCT_DZ_AT!=-1)getJtable().getColumnModel().getColumn(MKR_DISCT_DZ_AT).setPreferredWidth(70); //buyr comm %
       if(SHIP_MODE_AT!=-1)getJtable().getColumnModel().getColumn(SHIP_MODE_AT).setPreferredWidth(165); //ship mode
       if(RECFM_SHIP_AT!=-1) getJtable().getColumnModel().getColumn(RECFM_SHIP_AT).setPreferredWidth(165); //reconfirm ship mode
       if(SHIP_DRUP_DEST_AT!=-1) getJtable().getColumnModel().getColumn(SHIP_DRUP_DEST_AT).setPreferredWidth(163); //reconfirm ship mode
       if(getJtable().getRowCount()>0){
         //for(int i=0;i<getJtable().getRowCount();i++){
         for(int i=0;i<getDisplayingRecords().size();i++){
           if(getJtable().isCellEditable(i,QTY_COLUMN_AT)){
             getJtable().changeSelection(i,QTY_COLUMN_AT,false,false);
             getJtable().editCellAt(i,QTY_COLUMN_AT);
             ((javax.swing.text.JTextComponent)getJtable().getEditorComponent()).addMouseListener(
              new QtyCellClickClass());
             break;
           }
         }
         //for(int i=0;i<getJtable().getRowCount();i++){
         for(int i=0;i<getDisplayingRecords().size();i++){
           if(getJtable().isCellEditable(i,0)){
             getJtable().changeSelection(i,0,false,false);
             getJtable().editCellAt(i,0);
             ((javax.swing.text.JTextComponent)getJtable().getEditorComponent()).grabFocus();
             ((javax.swing.text.JTextComponent)getJtable().getEditorComponent()).selectAll();
             break;
           }
         }
       }
   }
  protected void CopyPastePriceBetweenColumns(){
    DlgCopyPasteStylePrx dlg=new DlgCopyPasteStylePrx(
     util.PublicVariable.APP_FRAME,
     "Copy & Paste Prices Between Columns",true,
     getJtable(),BYR_DOC_PRX_AT);
    dlg.setSize(666,120);
    exgui.UIHelper.setToScreenCenter(dlg); dlg.show();

  }
  protected void copyStyle2OtherPo(){
    /*
    try{
      if (isUsedByShipping())return;
    }catch(Exception exp){
      exp.printStackTrace();
      util.ExceptionLog.exp2File(exp,"");
    }*/
    if(getJtable().getSelectedRowCount()>0){
      try{
        int selectedRows[]=getJtable().getSelectedRows();
        if(selectedRows.length>99){
          exgui.verification.VerifyLib.showAlert("Selected Items Can not over 99 items",
                                                 "Too Much Item Selected");
          return;
        }
        StringBuffer sb=new StringBuffer();
        int orgProdHeadPk=0;
        for(int i=0;i<selectedRows.length;i++){
          Record rec=(Record)getDisplayingRecords().get(selectedRows[i]);
          if(i==0){
            //orgProdHeadPk = rec.getInt(1);
            orgProdHeadPk = newtimes.preproduction.Constants.CURRENT_PREPROD_HEAD_PK;
          }
          if(sb.length()>0)sb.append(",");
          sb.append(rec.get(0).toString());
        }

      DlgMovStylesToOtherProd  dlgListProdPk=new  DlgMovStylesToOtherProd(
         util.PublicVariable.APP_FRAME,"SELECT Dest. PO ",true,
         (String)newtimes.preproduction.Constants.CURRENT_PREPROD_HEAD_RECORD.get("PROD_CEN_CODE"),
         (String)newtimes.preproduction.Constants.CURRENT_PREPROD_HEAD_RECORD.get("PROD_DEPTMENT"),
         newtimes.preproduction.Constants.CURRENT_PREPROD_HEAD_RECORD.getInt("PROD_BUYER"),orgProdHeadPk);
        dlgListProdPk.setSize(400,350);
        exgui.UIHelper.setToScreenCenter(dlgListProdPk); dlgListProdPk.show();
        if(dlgListProdPk.getSelectedProdHeadPK()==null)return;
        if(dlgListProdPk.getDialogStatus()!=dlgListProdPk.STATUS_CLOSE_NORMALLY )return;
        String pk=dlgListProdPk.getSelectedProdHeadPK();
        //combine the selected styles into comma separated list
        util.MiscFunc.showProcessingMessage();
        ((newtimes.production.process.prodmaintain.DB_NTHKStyleListHandler)getPagedDataFactory()).copyStylesTo(
            sb.toString(),
            orgProdHeadPk,
            Integer.parseInt(pk));
        util.MiscFunc.hideProcessingMessage();
        this.reload();
        exgui.verification.VerifyLib.showPlanMsg("Styles Copy OK","Styles Copy OK");
      }catch(Exception exp){
        exp.printStackTrace();
        util.ExceptionLog.exp2File(exp,"");
        exgui.verification.VerifyLib.showAlert("Error In Duplipcating Styles To Other Po.\nPlease Constact System Manager",
                                               "Error In Duplicating Styles To Other Po.");
      }
    }else{
      exgui.verification.VerifyLib.showAlert("Please Select Row(s) To Copy",
                                             "Please Select Row(s) To Copy");
      return;
    }
  }
  protected void moveStlyes2OtherPo(){
    try{
      if (isUsedByShipping())return;
    }catch(Exception exp){
      exp.printStackTrace();
      util.ExceptionLog.exp2File(exp,"");
    }
    if(getJtable().getSelectedRowCount()>0){
      try{
        int selectedRows[]=getJtable().getSelectedRows();
        if(selectedRows.length>99){
          exgui.verification.VerifyLib.showAlert("Selected Items Can not over 99 items",
                                                 "Too Much Item Selected");
          return;
        }
        StringBuffer sb=new StringBuffer();
        int orgProdHeadPk=0;
        for(int i=0;i<selectedRows.length;i++){
          Record rec=(Record)getDisplayingRecords().get(selectedRows[i]);
          if(i==0){
            //orgProdHeadPk = rec.getInt(1);
            orgProdHeadPk = newtimes.preproduction.Constants.CURRENT_PREPROD_HEAD_PK;
          }
          if(sb.length()>0)sb.append(",");
          sb.append(rec.get(0).toString());
        }

      DlgMovStylesToOtherProd  dlgListProdPk=new  DlgMovStylesToOtherProd(
         util.PublicVariable.APP_FRAME,"SELECT PO. To Move To",true,
         (String)newtimes.preproduction.Constants.CURRENT_PREPROD_HEAD_RECORD.get("PROD_CEN_CODE"),
         (String)newtimes.preproduction.Constants.CURRENT_PREPROD_HEAD_RECORD.get("PROD_DEPTMENT"),
         newtimes.preproduction.Constants.CURRENT_PREPROD_HEAD_RECORD.getInt("PROD_BUYER"),orgProdHeadPk);
        dlgListProdPk.setSize(400,350);
        exgui.UIHelper.setToScreenCenter(dlgListProdPk); dlgListProdPk.show();
        if(dlgListProdPk.getSelectedProdHeadPK()==null)return;
        if(dlgListProdPk.getDialogStatus()!=dlgListProdPk.STATUS_CLOSE_NORMALLY )return;
        String pk=dlgListProdPk.getSelectedProdHeadPK();
        //combine the selected styles into comma separated list
        util.MiscFunc.showProcessingMessage();
        ((newtimes.production.process.prodmaintain.DB_NTHKStyleListHandler)getPagedDataFactory()).moveStyles(sb.toString(),
            Integer.parseInt(pk));
        util.MiscFunc.hideProcessingMessage();
        this.reload();
        exgui.verification.VerifyLib.showPlanMsg("Styles Move OK","Styles Move OK");
      }catch(Exception exp){
        exp.printStackTrace();
        util.ExceptionLog.exp2File(exp,"");
        exgui.verification.VerifyLib.showAlert("Error In Separating Styles To Other Po.\nPlease Constact System Manager",
                                               "Error In Separating Styles To Other Po.");
      }
    }else{
      exgui.verification.VerifyLib.showAlert("Please Select Row(s) To Move",
                                             "Please Select Row(s) To Move");
      return;
    }
  }
  protected void openChangeStyleAtts(){
    util.MiscFunc.showProcessingMessage();
    DlgUpdateAllStylesNthk   dlg=new  DlgUpdateAllStylesNthk(
       util.PublicVariable.APP_FRAME,
       "Modify All Styles Attributs",true,
       (newtimes.production.process.prodmaintain.DB_NTHKStyleListHandler)getPagedDataFactory(),true);
     dlg.setSize(555,470);
     util.MiscFunc.hideProcessingMessage();
     dlg.show();
     if(dlg.myOperationStatus==dlg.STATUS_CLOSE_NORMALLY){
       //something add to database.
       this.reload();
     }
  }
  protected void openSequencialStyles(){
    String styNo2Follow=getStyNo2Follow();
    DlgSequencialAddStylesNthk dlg=new  DlgSequencialAddStylesNthk(
       util.PublicVariable.APP_FRAME,
       "Batch Add Styles",true,
       (newtimes.production.process.prodmaintain.DB_NTHKStyleListHandler)getPagedDataFactory());
     dlg.setStyNo2Follow(styNo2Follow);
     dlg.setSize(555,470);
     dlg.show();
     if(dlg.myOperationStatus==dlg.STATUS_CLOSE_NORMALLY){
       //something add to database.
       this.reload();
     }
  }

  protected Record setObject2Record(Record rec, int columnAt, Object value2update) {
    /**@todo Implement this exgui.ultratable.AbstractUltraTablePanel abstract method*/
    //throw new java.lang.UnsupportedOperationException("Method setObject2Record() not yet implemented.");
    if(!qtyIsOk)return null;
    if(isGoPageAfterUpdate) return null;
    try{
      int rowat=Integer.parseInt((String)hmRowAndRecMapping.get(String.valueOf(rec.getInt(0))));
      if(columnAt==BYR_ACT_PRX_AT || columnAt==BYR_DOC_PRX_AT || columnAt==MKR_ACT_PRX_AT||columnAt==MKR_DOC_PRX_AT){
        if(blankPriceRec==null){
          blankPriceRec=exgui2.CONST.BASIC_MAIN_EJB.getBlankRecord("PRICE_tbl");
        }

        //find out if record stored in hash map to record price.
        Record recPrice=(Record)hmPrxRec_STYLE_SEQ_KEY_VALUE.get(rec.get(0).toString());
        if(recPrice==null){
          recPrice=(Record)util.MiscFunc.deepCopy(blankPriceRec);
          recPrice.set(1,rec.getInt(0));//set to sty_seq field of price record
          recPrice.set(0,rec.get("pri_seq"));//set to price_seq to price record
          recPrice.getModifiedFields().clear();
        }
        recPrice.set(11,util.PublicVariable.USER_RECORD.get(0));//SET TO RECORD MODIFY USER
        if(columnAt==BYR_ACT_PRX_AT){
           recPrice.set(2,value2update);
        }else if(columnAt==BYR_DOC_PRX_AT){
          recPrice.set(3,value2update);
        }else if(columnAt==MKR_ACT_PRX_AT){
          recPrice.set(4,value2update);
        }else{
          recPrice.set(5,value2update);
        }
        //set to hash map
        hmPrxRec_STYLE_SEQ_KEY_VALUE.put(rec.get(0).toString(),recPrice);
        return rec;
      }
      if(columnAt==QTY_COLUMN_AT ){
        //test if style unit is DZ
        Object qtyObj=value2update;
        if(qtyObj==null)qtyObj="0";

        String unit=((exgui.ultratable.Wraper4tblCbx)getJtable().getValueAt(rowat,UNIT_COLUMN_AT)).toString();

        if(unit.toUpperCase().trim().startsWith("DZ") ){
          if(((Double)qtyObj).floatValue() - ((Double)qtyObj).intValue()!=0){
            exgui.verification.VerifyLib.showAlert(
                "\"DZ\" Unit Only Allow Integer QTY ",
                "\"DZ\" Unit Only Allow Integer QTY ");
            qtyIsOk = false;
            return null;
          }
        }
          Record styRecQtyDescObj=
              (Record)exgui2.CONST.BASIC_MAIN_EJB.getDatas(util.PublicVariable.USER_RECORD,
                "select STY_QTY_DESC,STY_QTY_DESC_1,STY_QTY_DESC_2 from style where sty_seq="+rec.getInt(0),1,99999).get(0);
          rec.getFieldName().add("STY_QTY_DESC");
          rec.getValueFields().add(styRecQtyDescObj.get(0));
        String QtyDesc=(String)rec.get("STY_QTY_DESC");
        if(QtyDesc!=null){
          //String lines[]=util.MiscFunc.split(util.MiscFunc.Replace(QtyDesc,"||"," ",false),"\n");
          String lines[]=util.MiscFunc.split(QtyDesc,"\n");
            String titleColor = lines[0].substring(0, lines[0].lastIndexOf(" "));
            String strColorName = lines[2].substring(0,
                lines[2].lastIndexOf(" "));
            QtyDesc = util.MiscFunc.udpateTotalQtyDesc(titleColor.trim(),
                strColorName.trim(), qtyObj.toString().trim());
          rec.set("STY_QTY_DESC",QtyDesc);
          hmQTY_STYLE_SEQ_KEY_VALUE.put(rec.get(0).toString(),qtyObj.toString());
        }
        return rec;
      }
      String orgKlmName=storedRecordColumn[columnAt];
      String unitStr=((Wraper4tblCbx)getJtable().getValueAt(rowat,UNIT_COLUMN_AT)).toString();

      if(columnAt==CAT_DATA_COLUMN_AT){
        if(!value2update.toString().equals("N/A")){
          String qtaValue=(String)value2update;
          String qta_cat=qtaValue.substring(0,qtaValue.length()-1);
          String qta_area=qtaValue.substring(qtaValue.length()-1,qtaValue.length());
          rec.set("sty_qta_cat",qta_cat);
          rec.set("sty_qta_area",qta_area);
          return rec;
        }else{
          rec.set("sty_qta_cat",null);
          rec.set("sty_qta_area",null);
          return rec;
        }
      }


      float floats[]=new float[8];

       Object obj2test1=(BYR_DISCT_DZ_AT==-1)?null:getJtable().getValueAt(rowat,BYR_DISCT_DZ_AT);
       Object obj2test2=(MKR_DISCT_DZ_AT==-1)?null:getJtable().getValueAt(rowat,MKR_DISCT_DZ_AT);
        floats[0]=(obj2test1==null||obj2test1.toString().trim().length()==0)?0:Float.parseFloat(obj2test1.toString());
        floats[1]=(obj2test2==null||obj2test2.toString().trim().length()==0)?0:Float.parseFloat(obj2test2.toString());

       Object obj2test3=(BYR_DISCT_PC_AT==-1)?null:getJtable().getValueAt(rowat,BYR_DISCT_PC_AT);
       Object obj2test4=(MKR_DISCT_PC_AT==-1)?null:getJtable().getValueAt(rowat,MKR_DISCT_PC_AT);
        floats[2]=(obj2test3==null||obj2test3.toString().trim().length()==0)?0:Float.parseFloat(obj2test3.toString());
        floats[3]=(obj2test4==null||obj2test4.toString().trim().length()==0)?0:Float.parseFloat(obj2test4.toString());

        Object obj2test5=(BYR_DISCT_LUMPSUM_AT==-1)?null:getJtable().getValueAt(rowat,BYR_DISCT_LUMPSUM_AT);
        Object obj2test6=(MKR_DISCT_LUMPSUM_AT==-1)?null:getJtable().getValueAt(rowat,MKR_DISCT_LUMPSUM_AT);
         floats[4]=(obj2test5==null||obj2test5.toString().trim().length()==0)?0:Float.parseFloat(obj2test5.toString());
         floats[5]=(obj2test6==null||obj2test6.toString().trim().length()==0)?0:Float.parseFloat(obj2test6.toString());

         Object obj2test7=(BYR_COMM_PER_AT==-1)?null:getJtable().getValueAt(rowat,BYR_COMM_PER_AT);
         Object obj2test8=(MKR_DISCT_PER_AT==-1)?null:getJtable().getValueAt(rowat,MKR_DISCT_PER_AT);
          floats[6]=(obj2test7==null||obj2test7.toString().trim().length()==0)?0:Float.parseFloat(obj2test7.toString());
          floats[7]=(obj2test8==null||obj2test8.toString().trim().length()==0)?0:Float.parseFloat(obj2test8.toString());

       int alreadBuyerData=0;
       int alreadMakerData=0;
       for(int i=0;i<8;i+=2){
         if(floats[i]!=0)++alreadBuyerData;
         if(floats[i+1]!=0)++alreadMakerData;
         if(alreadBuyerData>1 || alreadMakerData>1){
           exgui.verification.VerifyLib.showAlert(
            "Pleaes Assigne Only One Discount/Commision Value ",
            "Pleaes Assigne Only One Discount/Commsion Value");
           qtyIsOk=false;
           return null;
         }
       }

       if(BYR_DISCT_DZ_AT !=-1 || MKR_DISCT_DZ_AT !=-1){
         if(floats[0]!=0.0 || floats[1]!=0){
           if (unitStr.startsWith("PC")) {
             exgui.verification.VerifyLib.showAlert(
                 "DZ DISCOUNT Is Not Suitable for \"PC\" Unit",
                 "UNIT UN-MATCH");
             qtyIsOk = false;
             return null;
           }
         }
       }
       if(BYR_DISCT_PC_AT !=-1 || MKR_DISCT_PC_AT !=-1){
         if(floats[2]!=0 || floats[3]!=0){
           if (unitStr.startsWith("DZ")) {
             exgui.verification.VerifyLib.showAlert(
                 "PC DISCOUNT Is Not Suitable for \"DZ\" Unit",
                 "UNIT UN-MATCH");
             qtyIsOk = false;
             return null;
           }
         }
       }
       if(unitStr.startsWith("H.")||unitStr.startsWith("T.")||unitStr.startsWith("TH")){
           if(BYR_DISCT_PC_AT !=-1 || MKR_DISCT_PC_AT !=-1 || BYR_DISCT_DZ_AT !=-1 || MKR_DISCT_DZ_AT !=-1){
             if (floats[0] != 0 || floats[1] != 0 || floats[2] != 0 || floats[3] != 0) {
               exgui.verification.VerifyLib.showAlert(
                   "UNIT  Is Not Suitable for \"PC\" Or \"DZ\" ",
                   "UNIT DISCOUNT MISS-MATCH");
               qtyIsOk = false;
               return null;
             }
           }
       }


      rec.set(orgKlmName,value2update);
      return rec;
    }catch(Exception e){
      e.printStackTrace();
      return rec;
    }
  }
  protected InsertionOrderedHashMap getHeadColumnMap() {
    /**@todo Implement this exgui.ultratable.AbstractUltraTablePanel abstract method*/
    //throw new java.lang.UnsupportedOperationException("Method getHeadColumnMap() not yet implemented.");
     MKR_DISCT_PC_AT=-1;
     BYR_DISCT_PC_AT=-1;
     MKR_DISCT_DZ_AT=-1;
     BYR_DISCT_DZ_AT=-1;
     MKR_DISCT_LUMPSUM_AT=-1;
     BYR_DISCT_LUMPSUM_AT=-1;
     BYR_COMM_PER_AT=-1;
     MKR_DISCT_PER_AT=-1;
     SHIP_MODE_AT=-1;
     BYR_DOC_PRX_AT=-1;BYR_ACT_PRX_AT=-1;
     MKR_DOC_PRX_AT=-1;MKR_ACT_PRX_AT=-1;
     MKR_DISCT_PER_AT=-1; BARCODE_COLUMN_AT=-1;BUYER_LABEL_COLUMN_AT=-1;
     CAT_DATA_COLUMN_AT=-1; QTY_COLUMN_AT=-1;
     RECFM_DATE_AT=-1;
     RECFM_SHIP_AT=-1;
     MKR_DVL_DATE_AT=-1;
     ORG_DLV_DATE_AT=-1;
      //newtimes.production.gui.prodmaintain.PnlNTHKStyleList.UNIT_COLUMN_AT=5;
      //newtimes.production.gui.prodmaintain.PnlNTHKStyleList.QTY_COLUMN_AT=4;
      newtimes.production.gui.prodmaintain.PnlNTHKStyleList.STY_NO_CLUMN_AT=3;

    util.InsertionOrderedHashMap iso=new util.InsertionOrderedHashMap();

    iso.put(DISP_STY_CT_SEQ,DB_STY_CT_SEQ);
    iso.put(DISP_STY_STYLE,DB_STY_STYLE);//1
    iso.put(DISP_STY_PO,DB_STY_PO);//2
    if(STY_NO_CLUMN_AT!=-1){
      iso.put(DISP_STY_NO,DB_STY_NO);//3
    }
    if(!util.PublicVariable.OPERATTING_CENTER.equals("NTHK")){
      //ship-drup desty.
       iso.put(DISP_STY_DRUP_DEST,DB_STY_DRUP_DEST);
       SHIP_DRUP_DEST_AT=iso.entrySet().size()-1;

      iso.put(DISP_STY_QTA,DB_STY_QTA);//2
      CAT_DATA_COLUMN_AT=iso.entrySet().size() - 1;
    }
    iso.put(DISP_STY_QTY,DB_STY_QTY);//
    QTY_COLUMN_AT=iso.entrySet().size() - 1;

    iso.put(DISP_STY_UNIT,DB_STY_UNIT);//5
    UNIT_COLUMN_AT=iso.entrySet().size() - 1;

    //iso.put(DISP_STY_FOB_RPX,DB_STY_FOB_PRX);//6
    //ONLY NTHK user can view the price directly.
    if(util.PublicVariable.OPERATTING_CENTER.equals("NTHK")){
      iso.put(DISP_BYR_DOC_PRX, DB_BYR_DOC_PRX);
      BYR_DOC_PRX_AT = iso.entrySet().size() - 1;
      iso.put(DISP_BYR_ACT_PRX, DB_BYR_ACT_PRX);
      BYR_ACT_PRX_AT = iso.entrySet().size() - 1;

      iso.put(DISP_MKR_DOC_PRX, DB_MKR_DOC_PRX);
      MKR_DOC_PRX_AT = iso.entrySet().size() - 1;
      iso.put(DISP_MKR_ACT_PRX, DB_MKR_ACT_PRX);
      MKR_ACT_PRX_AT = iso.entrySet().size() - 1;
    }

    //test if user is authorized to view buyer commision ,maker discount .
    try{
      String authKeyWord=(String)util.PublicVariable.USER_RECORD.get("edit_bymkr_comm_discount");
      if (authKeyWord!=null){
        //allow to show maker discount
        //allow to show buyer maker.
        boolean isWithBuyComm=(authKeyWord.indexOf("B")!=-1);
        boolean isWithMkrDisct=(authKeyWord.indexOf("M")!=-1);
          if (isWithBuyComm) {
            iso.put(DISP_STY_BUY_COMM, DB_STY_BUY_COMM); //8
            BYR_COMM_PER_AT = iso.entrySet().size() - 1;
          }
          if (isWithMkrDisct) {
            iso.put(DISP_STY_MKR_DISC, DB_STY_MKR_DISC); //9
            MKR_DISCT_PER_AT = iso.entrySet().size() - 1;
          }
        if(!util.PublicVariable.OPERATTING_CENTER.equals("NTHK")){
          if(isWithBuyComm){
            iso.put(DISP_STY_BUY_DSCT_PC, DB_STY_BUY_DSCT_PC); //10
            BYR_DISCT_PC_AT =iso.entrySet().size()-1;
          }
          if(isWithMkrDisct){
            iso.put(DISP_STY_MKR_DSCT_PC, DB_STY_MKR_DSCT_PC); //11
            MKR_DISCT_PC_AT =iso.entrySet().size()-1;
            //System.out.println("MKR_DISCT_PC_AT:"+MKR_DISCT_PC_AT);
          }

          if(isWithBuyComm){
            iso.put(DISP_STY_BUY_DSCT_DZ, DB_STY_BUY_DSCT_DZ); //12
            BYR_DISCT_DZ_AT =iso.entrySet().size()-1;
          }
          if(isWithMkrDisct){
            iso.put(DISP_STY_MKR_DSCT_DZ, DB_STY_MKR_DSCT_DZ); //13
            MKR_DISCT_DZ_AT =iso.entrySet().size()-1;
          }
          /*
          if(isWithBuyComm){
            iso.put(DISP_STY_BUY_DSCT_LUMP_SUM, DB_STY_BUY_DSCT_LUMP_SUM); //14
            BYR_DISCT_LUMPSUM_AT =iso.entrySet().size()-1;
            //System.out.println("BYR_DISCT_LUMPSUM_AT:"+BYR_DISCT_LUMPSUM_AT);
          }
          if(isWithMkrDisct){
            iso.put(DISP_STY_MKR_DSCT_LUMP_SUM, DB_STY_MKR_DSCT_LUMP_SUM); //15
            MKR_DISCT_LUMPSUM_AT =iso.entrySet().size()-1;
          }*/


        }


      }
    }catch(Exception exp){
      exp.printStackTrace();
    }
    iso.put(DISP_DLV_DATE,DB_DLV_DATE);
    ORG_DLV_DATE_AT=iso.entrySet().size()-1;

    iso.put(DISP_SHIP_MODE,DB_SHIP_MODE);
    SHIP_MODE_AT=iso.entrySet().size()-1;

    iso.put(DISP_MKR_DLV,DB_MKR_DLV);
    MKR_DVL_DATE_AT =iso.entrySet().size()-1;

    if(util.PublicVariable.OPERATTING_CENTER.equals("NTHK")){
      iso.put(DISP_RECFM_DATE,DB_RECFM_DATE);
      RECFM_DATE_AT=iso.entrySet().size()-1;
      iso.put(DISP_RECFM_SHIP_MODE,DB_RECFM_SHIP_MODE);
      RECFM_SHIP_AT=iso.entrySet().size()-1;
    }


    iso.put(DISP_STY_BARCODE, DB_STY_BARCODE);BARCODE_COLUMN_AT=iso.entrySet().size()-1;
    iso.put(DISP_STY_BUYER_LABEL, DB_STY_BUYER_LABEL);BUYER_LABEL_COLUMN_AT=iso.entrySet().size()-1;
    return iso;
  }
  protected String getStyNo2Follow(){
    if(util.PublicVariable.OPERATTING_CENTER.equals("001"))return null;
    //the insert stye function is only alled fo NTHK center
    String styNo2Follow=null;
    if(getJtable().getSelectedRow()!=-1){
      Object objStyNo=((Record)getDisplayingRecords().get(getJtable().getSelectedRow())).get(4);
      if(objStyNo!=null){
        styNo2Follow=String.valueOf(Integer.parseInt(objStyNo.toString())-1);
      }
    }
    return styNo2Follow;
  }
  protected void orgAddNewProcess()throws Exception{
    try{
      String styNo2Follow = getStyNo2Follow();
      //super.addRecord();
      //pop out the sub panel.allow user to add 20 record by bacth
      DldBchAddStyles dlg2add = new DldBchAddStyles(
          processhandler.template.Properties.getMainFrame(),
          "Add Styles", true,
          (newtimes.production.process.prodmaintain.DB_NTHKStyleListHandler)
          dbHandler);
      dlg2add.setStyNo2Follow(styNo2Follow);
      dlg2add.setSize(400, 350);

      dlg2add.show();
      if (dlg2add.getOperationStatus() == dlg2add.STATUS_CLOSE_CANCEL ||
          dlg2add.getOperationStatus() == dlg2add.STATUS_OPERATING)return;
      util.MiscFunc.showProcessingMessage();
      /*
      this.doUpdate();

      isProcessingTlbOkChk = true;
      isGoPageAfterUpdate = true;
      this.goPage(_rowPosition, _rowCounts);
      */
     this.reload();
     util.MiscFunc.hideProcessingMessage();
    }finally{
      isProcessingTlbOkChk=false;
      isProcessingTlbOkChk=false;
    }
  }
  protected void NTHKAddNewProcess()throws Exception{
    int column=getJtable().getSelectedColumn();
    int row=getJtable().getSelectedRow();
    try{
      String styNo2Follow = getStyNo2Follow();
      //super.addRecord();
      //pop out the sub panel.allow user to add 20 record by bacth
      if(getJtable().getRowCount()>0){
        getJtable().changeSelection(0, 0, false, false);
      }
      DldBchAddStyles4NTHK dlg2add = new DldBchAddStyles4NTHK(
          processhandler.template.Properties.getMainFrame(),
          "Add Styles", true,
          (newtimes.production.process.prodmaintain.DB_NTHKStyleListHandler)
          dbHandler);
      dlg2add.setStyNo2Follow(styNo2Follow);
      dlg2add.setSize(400, 350);

      dlg2add.show();
      if (dlg2add.getOperationStatus() == dlg2add.STATUS_CLOSE_CANCEL ||
          dlg2add.getOperationStatus() == dlg2add.STATUS_OPERATING)return;
      util.MiscFunc.showProcessingMessage();
      this.reload();
      /*
      this.doUpdate();

      isProcessingTlbOkChk = true;
      isGoPageAfterUpdate = true;
      this.goPage(_rowPosition, _rowCounts);
      */
     util.MiscFunc.hideProcessingMessage();
    }finally{
      getJtable().changeSelection(row,column,false,false);
      isProcessingTlbOkChk=false;
      isProcessingTlbOkChk=false;
    }
  }
  public void doAddNew() throws Exception{
      NTHKAddNewProcess();
 }

 public class MyQtyRenderer extends JLabel
     implements javax.swing.table.TableCellRenderer{
     public MyQtyRenderer(){
     super();
    setOpaque(true); /* it\u00B4s essential */
 }
  public Component getTableCellRendererComponent(
        javax.swing.JTable table, Object value,
        boolean isSelected, boolean hasFocus,
        int row, int column){
        String text = (value==null)?"":value.toString();
        if(table.getModel().isCellEditable(row,column)){
          setBackground(new java.awt.Color(0xFF,0xFF,0xFF)); // Decides the color
          setText(text);
          return this;
        }
       //if(text.equals("Waiting")) /*
       setBackground(new java.awt.Color(0x90,0xFF,0x90)); // Decides the color
       setText(text); /* Put the current text in the JLabel */
    return this;
   }
 }


 //to render the 1st cell--C/T SEQ cell the indicate if this style is already shipped,
 //not allwo to delete and move to other po and shift C/T SEQ.


 public class MyRenderer extends JLabel
     implements javax.swing.table.TableCellRenderer{
     public MyRenderer(){
     super();
    setOpaque(true); /* it\u00B4s essential */
 }
  public Component getTableCellRendererComponent(
        javax.swing.JTable table, Object value,
        boolean isSelected, boolean hasFocus,
        int row, int column){
        String text = (value==null)?"":value.toString();
        if(table.getModel().isCellEditable(row,column)){
          setBackground(new java.awt.Color(0xFF,0xFF,0xFF)); // Decides the color
          setText(text);
          return this;
        }
       //if(text.equals("Waiting")) /*
       setBackground(new java.awt.Color(0xFF,0x90,0x90)); // Decides the color
       setText(text); /* Put the current text in the JLabel */
    return this;
   }
 }
  class myEditablePolicy implements exgui.CellEditablePolicy{
    public boolean isCellEditable(int row, int colm) {
      if(getDisplayingRecords().size() <= row )return false;
      boolean isRowShipped=false;
      int ship_count=0;
      Record rec = (Record)getDisplayingRecords().get(row);
      try {
        ship_count=rec.getInt("shipped_count");
        isRowShipped= (ship_count> 0) && IS_EDIT_AFTER_SHIPPED ;
        if(isRowShipped && (1==colm||2==colm)){
          //if shipped,STYLE & PO is not allow to edit.
          return false;
        }
        if (colm == SHIP_DRUP_DEST_AT && SHIP_DRUP_DEST_AT!=-1){
          if(isRowShipped)return false;
          return true;
        }
        if (colm == BYR_ACT_PRX_AT || colm == BYR_DOC_PRX_AT ||
            colm == MKR_ACT_PRX_AT || colm == MKR_DOC_PRX_AT) {
          Object obj = //rec.get(rec.getFieldName().size()-1);
              rec.get(DB_STY_QTY_REC_COUNT);
          if (obj == null)return false;
          int qtyRecCount = Integer.parseInt(obj.toString());
          //if (qtyRecCount == 1)return true; //even on record qty,style check if one-size object
          if(qtyRecCount <= 1 && rec.getInt(DB_STY_QTY_TYPE_AT)==12){
            if(isRowShipped)return false;
            return true;
          }
          //if (qtyRecCount == 1 && ((rec.getInt(DB_STY_QTY_TYPE_AT) & 0x02) == 0))return true; //even on record STY_QTY_TYPE,style check if one-size object
          return false;
          //return false;
        }
        if (colm == QTY_COLUMN_AT) {
          Object obj = //rec.get(rec.getFieldName().size()-1);
              rec.get(DB_STY_QTY_REC_COUNT);
          if (obj == null)return false;
          int qtyRecCount = Integer.parseInt(obj.toString());
          if (qtyRecCount <= 1 && rec.getInt(DB_STY_QTY_TYPE_AT)  == 12)return true; //even on record qty,style check if one-size object
          //if(qtyRecCount==1 && ((rec.getInt(105) & 0x02) == 0)) return true; //even on record STY_QTY_TYPE,style check if one-size object
          return false;
        }
      } catch (Exception exp) {
        exp.printStackTrace();
        util.ExceptionLog.exp2File(exp, "");
      }
      try {
        //System.out.println("rec.getInt(\"shipped_count\")="+rec.getInt("shipped_count"));
        if(colm==0){
          if (ship_count>0) {
            return false;
          } else {

            return true;
          }
        }
        if(isRowShipped){
          //other fields are allow to edit after shipped.
          if(colm==STY_NO_CLUMN_AT||
             colm==ORG_DLV_DATE_AT ||
             colm==MKR_DVL_DATE_AT||
             colm==BARCODE_COLUMN_AT||
             colm==BUYER_LABEL_COLUMN_AT){
             return true;
          }
          return false;
        }else{
          return true;
        }
      } catch (Exception exp) {
        exp.printStackTrace();
        util.ExceptionLog.exp2File(exp, "");
        return false;
      }

    }
  }
  public  boolean isDateChckOk()throws Exception {
    boolean isBuyerDateConfirmAfterMakerDate=false;
    for(int i=0;i<getJtable().getRowCount();i++){
      Object objBuyerDlv=getJtable().getValueAt(i,ORG_DLV_DATE_AT);
      Object objMakerDlv=getJtable().getValueAt(i,MKR_DVL_DATE_AT);
      if(null==objBuyerDlv||objBuyerDlv.toString().trim().length()==0){
        exgui.verification.VerifyLib.showAlert("Please Input Buyer Dlv Date","Please Input Buyer Dlv Date");
        getJtable().changeSelection(i,ORG_DLV_DATE_AT,false,false);
        getJtable().editCellAt(i,ORG_DLV_DATE_AT);
        return false;
      }

      if(null==objMakerDlv||objMakerDlv.toString().trim().length()==0){
        exgui.verification.VerifyLib.showAlert("Please Input Maker Dlv Date","Please Input Maker Dlv Date");
        getJtable().changeSelection(i,MKR_DVL_DATE_AT,false,false);
        getJtable().editCellAt(i,MKR_DVL_DATE_AT);
        return false;
      }

      java.util.Date buyerDate=df.parse((String)objBuyerDlv);
      java.util.Date makerDate=df.parse((String)objMakerDlv);

      if((!isBuyerDateConfirmAfterMakerDate) && buyerDate.before(makerDate)){
        boolean confirm =
            exgui.verification.VerifyLib.showConfirm(
            "Maker Dlv Date Should Be earlier Than Buyer Dlv Date,Are You Sure ?",
            "Maker Dlv Date after Buyer Dlv Date!!", false);

        if (confirm) {
          isBuyerDateConfirmAfterMakerDate=true;
        } else {
          getJtable().changeSelection(i,ORG_DLV_DATE_AT,false,false);
          getJtable().editCellAt(i,ORG_DLV_DATE_AT);
          return false;
        }
      }
    }
    return true;
  }
  public boolean isStyleNoLack(){
    if(util.PublicVariable.OPERATTING_CENTER.equals("NTHK")){
      getJtable().editCellAt(-1,-1);
      for(int i=0;i<getJtable().getRowCount();i++){
          Object objPo=getJtable().getValueAt(i,1);
          if(objPo==null || objPo.toString().trim().length()==0){
            exgui.verification.VerifyLib.showAlert("Please Input Style",
                                                   "Please Input Style");
            getJtable().changeSelection(i,1,false,false);
             return true;
          }
      }
      return false;
    }else{
      return false;
    }

  }
  public boolean ifNoStylePo(){
    if(util.PublicVariable.OPERATTING_CENTER.equals("NTHK")){
      return false;
    }
    try{
      if (newtimes.preproduction.Constants.CURRENT_PREPROD_HEAD_RECORD.get(
          "PRODUCTION_BYR_SC_NO") != null) {
        return false;
      }
      if(getJtable().getRowCount()>0){
        getJtable().changeSelection(0,0,false,false);
      }
      for(int i=0;i<getJtable().getRowCount();i++){
        Object objPoValue=getJtable().getValueAt(i,2);
        if(objPoValue==null||objPoValue.toString().trim().length()==0){
          exgui.verification.VerifyLib.showAlert("Please assign PO For Style",
                                                 "Please Assign PO for Style");
          getJtable().changeSelection(i,2,false,false);
          return true;
        }
      }
      return false;
    }catch(Exception exp){
      exp.printStackTrace();
      return false;
    }
  }
  public boolean isPoDuplicated(){
    if(util.PublicVariable.OPERATTING_CENTER.equals("NTHK")){
      getJtable().editCellAt(-1,-1);
      java.util.HashMap hmPo=new java.util.HashMap();
      for(int i=0;i<getJtable().getRowCount();i++){
          Object objPo=getJtable().getValueAt(i,2);
          Object objStyle=getJtable().getValueAt(i,1);
          if(objPo==null || objPo.toString().trim().length()==0) continue;
          //if(hmPo.containsKey(objPo.toString().trim())){
          if(hmPo.containsKey(objStyle.toString().trim()+"_|||_"+objPo.toString().trim())){
            exgui.verification.VerifyLib.showAlert("STYLE:"+objStyle.toString()+"    Po:"+objPo.toString()+" Duplicated",
                                                   "STYLE PO Duplicated");
            return true;
          }
          hmPo.put(objStyle.toString().trim()+"_|||_"+objPo.toString().trim(),
                   objStyle.toString().trim()+"_|||_"+objPo.toString().trim());
          //hmPo.put(objPo.toString().trim(),objPo.toString().trim());
      }
      return false;
    }else{
      return false;
    }
  }
  public void doUpdate(){
    try{
      if("NTHK".equals(util.PublicVariable.OPERATTING_CENTER)){
        if(!isDateChckOk()) return;
      }
      if(isPoDuplicated())return;
      if(isStyleNoLack())return;
      if(ifNoStylePo())return;
      if(!isFtyPrxGreaterThanBuyerPrxChkOk())return;
      qtyIsOk=true;
      isProcessingTlbOkChk=true;
      if(!getMultiEditorJTable().isTableOk()) return ;
        if(_records2Update==null) return ;
          _records2Update=kvtModifiedField2Records(
              getMultiEditorJTable().getModifiedRowAndColumn()
          );
        if(!qtyIsOk)return;
        //check if seq of sty duplicated or blank
        if(STY_NO_CLUMN_AT!=-1){
          java.util.HashMap hmSeq=new java.util.HashMap();
          for(int i=0;i<getJtable().getRowCount();i++){
            Object obj=getJtable().getValueAt(i,STY_NO_CLUMN_AT);
            if(obj==null || obj.toString().trim().length()==0){
              exgui.verification.VerifyLib.showAlert("Pleaes Assign Sequence At Row:"+(i+1),"Pleaes Assign Sequence");

              return;
            }
            String strInt=obj.toString();
            if(hmSeq.containsKey(strInt)){
              exgui.verification.VerifyLib.showAlert("Sequence : "+strInt+" Duplicated","Sequence Duplicate!!");

              return;
            }
            hmSeq.put(strInt,strInt);
          }
        }
       util.MiscFunc.showProcessingMessage();
       //((newtimes.production.process.prodmaintain.DB_StyleListHandler)dbHandler).updateStylesAndQty(_records2Update,hmQTY_STYLE_SEQ_KEY_VALUE);
       ((newtimes.production.process.prodmaintain.DB_NTHKStyleListHandler)dbHandler).updateStylesAndQtyPrice(
        _records2Update,hmQTY_STYLE_SEQ_KEY_VALUE,hmPrxRec_STYLE_SEQ_KEY_VALUE);
       _records2Update.removeAllElements();


      table_snapshot=util.MiscFunc.table2Text(getJtable());
      //remove the last field if "sty_qty_desc exists"
      for(int i=0;i<getDisplayingRecords().size();i++){
        Record rec=(Record)getDisplayingRecords().get(i);
        String clmName=(String)rec.getFieldName().get(rec.getFieldName().size()-1);
        if(clmName.toUpperCase().equals("STY_QTY_DESC")){
          rec.getValueFields().remove(rec.getFieldName().size()-1);
          rec.getFieldName().remove(rec.getFieldName().size()-1);
        }
        rec.getModifiedFields().clear();
        //System.out.println("record after update:"+rec.toString());
      }
      isGoPageAfterUpdate=true;
      this.goPage(_rowPosition,_rowCounts);
      util.MiscFunc.hideProcessingMessage();
      hmPrxRec_STYLE_SEQ_KEY_VALUE.clear();
      hmQTY_STYLE_SEQ_KEY_VALUE.clear();

     //exgui.verification.VerifyLib.showPlanMsg("Update OK","Update Ok");*/
    }catch(Exception exp){
      if(exp.getCause() instanceof newtimesejb.preproduction.AlreadyShippedException  ){
          exgui.verification.VerifyLib.showAlert(
              "Style Shipped,Can not change C/T SEQ",
              "Style Shipped");
          this.goPage(_rowPosition, _rowCounts);
          return;
      }
      /*
      Throwable getthrow=null;
      while((getthrow=exp.getCause())!=null){
        if(getthrow instanceof newtimesejb.preproduction.AlreadyShippedException){
          exgui.verification.VerifyLib.showAlert("Style Shipped,Can not change C/T SEQ",
                                                 "Style Shipped");
          this.goPage(_rowPosition,_rowCounts);
          return;
        }
      }*/

      exp.printStackTrace();
      util.ExceptionLog.exp2File(exp,"");
      exgui.verification.VerifyLib.showAlert("Update Fail Please Contatc System Manager",
                                             "Update Fail Please Contatc System Manager");
    }finally{
      isProcessingTlbOkChk=false;
      isGoPageAfterUpdate=false;
    }
  }
  protected boolean isFtyPrxGreaterThanBuyerPrxChkOk(){
    if(BYR_DOC_PRX_AT==-1||BYR_ACT_PRX_AT==-1||
       MKR_DOC_PRX_AT==-1||MKR_ACT_PRX_AT==-1)return true;
    for(int i=0;i<getDisplayingRecords().size();i++){
      if(!getJtable().isCellEditable(i,BYR_DOC_PRX_AT))continue;
      Object objBuyDocPrx=getJtable().getValueAt(i,BYR_DOC_PRX_AT);
      Object objBuyActPrx=getJtable().getValueAt(i,BYR_ACT_PRX_AT);
      Object objMkrDocPrx=getJtable().getValueAt(i,MKR_DOC_PRX_AT);
      Object objMkrActPrx=getJtable().getValueAt(i,MKR_ACT_PRX_AT);
      float buyDocPrx,buyActPrx,mkrDocPrx,mkrActPrx;
      buyDocPrx=Float.parseFloat((objBuyDocPrx==null||objBuyDocPrx.toString().trim().length()==0)?"0":objBuyDocPrx.toString());
      buyActPrx=Float.parseFloat((objBuyActPrx==null||objBuyActPrx.toString().trim().length()==0)?"0":objBuyActPrx.toString());
      mkrDocPrx=Float.parseFloat((objMkrDocPrx==null||objMkrDocPrx.toString().trim().length()==0)?"0":objMkrDocPrx.toString());
      mkrActPrx=Float.parseFloat((objMkrActPrx==null||objMkrActPrx.toString().trim().length()==0)?"0":objMkrActPrx.toString());

     /*if(buyDocPrx==0||
         buyActPrx==0||
         mkrDocPrx==0||
         mkrActPrx==0){
         exgui.verification.VerifyLib.showAlert(
         "Price Can Not Be Zero","Price Can Not Be Zero");
         if(buyDocPrx==0){
           getJtable().changeSelection(i,BYR_DOC_PRX_AT,false,false);
           getJtable().editCellAt(i, BYR_DOC_PRX_AT);
         }else if(buyActPrx==0){
           getJtable().changeSelection(i,BYR_ACT_PRX_AT,false,false);
           getJtable().editCellAt(i, BYR_ACT_PRX_AT);
         }else if(mkrDocPrx==0){
           getJtable().changeSelection(i,MKR_DOC_PRX_AT,false,false);
           getJtable().editCellAt(i, MKR_DOC_PRX_AT);
         }else if(mkrActPrx==0){
           getJtable().changeSelection(i,MKR_ACT_PRX_AT,false,false);
           getJtable().editCellAt(i, MKR_ACT_PRX_AT);
         }
         final JTextField editor=(JTextField)getJtable().getEditorComponent();
         javax.swing.SwingUtilities.invokeLater(
          new Runnable(){
          public void run() {
           editor.selectAll();
           editor.grabFocus();
           }
          }
         );
         return false;
      }*/
      if(mkrDocPrx>buyDocPrx || mkrActPrx>buyActPrx){
        getJtable().changeSelection(i,BYR_DOC_PRX_AT,false,false);
        getJtable().editCellAt(i,BYR_DOC_PRX_AT);
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

  public void doCopy(){
    if("NTHK".equals(util.PublicVariable.OPERATTING_CENTER)){
      super.doCopy();
    }else{
       //util.ApplicationProperites.setProperties()
       if(getJtable().getSelectedRow()==-1){
         exgui.verification.VerifyLib.showAlert("Please Select A Row","Please Select A Row");
         return;
       }
       Record rec=(Record)getDisplayingRecords().get(getJtable().getSelectedRow());
       copiedStySeq=rec.get(0).toString();
    }
  }

  public void doPrint() throws java.lang.Exception {
    /**@todo Implement this processhandler.DataProcesser abstract method*/
  }
  public boolean isUsedByShipping()throws Exception{
    //before delete style records. we have to check if any style are used in shipping style.

     int[] selectedRows=getJtable().getSelectedRows();
     if(selectedRows.length==0)return false;
     util.MiscFunc.showProcessingMessage();
     StringBuffer sb=new StringBuffer();
     sb.append("select style.sty_seq,style.sty_style,style.sty_po ,ship_style.ship_style_pk,ship_sc.ship_no ");
     sb.append(" from style,ship_style,ship_sc ");
     sb.append("where ship_style.sty_seq=style.sty_seq and ");
     sb.append("ship_sc.ship_sc_pk=ship_style.ship_sc_pk and ");
     sb.append(" ship_style.sty_seq in (");
     for(int i=0;i<selectedRows.length;i++){
      if(i>0)sb.append(",");
      Record rec=(Record)getDisplayingRecords().get(selectedRows[i]);
      sb.append(String.valueOf(rec.getInt(0)));
     }
     sb.append(")");
     java.util.Vector vctChk=exgui2.CONST.BASIC_MAIN_EJB.getDatas(
      util.PublicVariable.USER_RECORD,
      sb.toString(),1,99999);
    if(vctChk.size()>0){
      //any styles are refered by shipping data,can not delete.
      StringBuffer sb2=new StringBuffer();
      for(int i=0;i<vctChk.size();i++){
        Record rec = (Record)vctChk.get(i);
        sb2.append("Style:");
        Object objStyle=rec.get("Sty_style");
        sb2.append((objStyle==null)?"   ":objStyle.toString());
        sb2.append(" PO:");
        Object objPO=rec.get("Sty_po");
        sb2.append((objPO==null)?"   ":objPO.toString());
        sb2.append(" is already used in SRN:");
        Object shipSRN=rec.get("SHIP_NO");
        sb2.append((shipSRN==null)?" ":shipSRN.toString());
        sb2.append("\n");
      }
      exgui.verification.VerifyLib.showAlert(sb2.toString(),"STYLE Shipped!!");
      return true;
    }
    util.MiscFunc.hideProcessingMessage();
    return false;
  }
  public void doDelete() throws Exception{
    //if(!isFtyPrxGreaterThanBuyerPrxChkOk())return;
    if(isUsedByShipping())return;
     super.doDelete();
  }
  protected void refineEditors(MultiEditorJTable multiEditorJTableInSuper) {
    /**@todo Implement this exgui.ultratable.AbstractUltraTablePanel abstract method*/
   if(CAT_DATA_COLUMN_AT!=-1){
     multiEditorJTableInSuper.addJComboBox(CAT_DATA_COLUMN_AT,
                                           ((newtimes.production.process.
                                             prodmaintain.DB_StyleListHandler)
                                            dbHandler).getPlanQuota2Selsct(),
                                           "cat_data", "cat_data");
   }

    multiEditorJTableInSuper.addJComboBox(UNIT_COLUMN_AT,((newtimes.production.process.prodmaintain.DB_NTHKStyleListHandler)
                                          dbHandler).UnitsData,"UNIT","UNIT");
   if(util.PublicVariable.OPERATTING_CENTER.equals("NTHK")){
     multiEditorJTableInSuper.setTableColumn2Grp("Buyer\nPrice",
                                                 BYR_DOC_PRX_AT);
     multiEditorJTableInSuper.setTableColumn2Grp("Buyer\nPrice",
                                                 BYR_ACT_PRX_AT);

     multiEditorJTableInSuper.setTableColumn2Grp("Maker\nPrice",
                                                 MKR_DOC_PRX_AT);
     multiEditorJTableInSuper.setTableColumn2Grp("Maker\nPrice",
                                                 MKR_ACT_PRX_AT);


   }



   try{
     if(SHIP_DRUP_DEST_AT!=-1){
       java.util.Vector dests =
           (java.util.Vector)util.MiscFunc.deepCopy(newtimes.production.process.prodmaintain.DB_ProdSC.getDestinations());
       //test if already have null dest name
       Record recDummpDest=(Record)util.MiscFunc.deepCopy(dests.get(0));
       recDummpDest.set("dest_name",null);
       dests.add(recDummpDest);
       multiEditorJTableInSuper.addJComboBox(SHIP_DRUP_DEST_AT,dests,"dest_name","dest_name");
     }


     Vector vctShipModes =
         (Vector)util.MiscFunc.deepCopy(newtimes.preproduction.guis.tempProperties.tempShipModes);
       Record recBlankShipWay=(Record)util.MiscFunc.deepCopy(vctShipModes.get(0));
       recBlankShipWay.set(0,null);
       recBlankShipWay.set(1,"");
       vctShipModes.add(recBlankShipWay);
     multiEditorJTableInSuper.addJComboBox(SHIP_MODE_AT, vctShipModes,"SHIP_MODE_NAME", "SHIP_MODE_CODE");
     if(RECFM_SHIP_AT!=-1){
       multiEditorJTableInSuper.addJComboBox(RECFM_SHIP_AT, vctShipModes,
                                             "SHIP_MODE_NAME",
                                             "SHIP_MODE_CODE");
     }
   }catch(Exception exp){
     exp.printStackTrace();
   }

    multiEditorJTableInSuper.setTextEditorVerifiers(getObject2StringConvertor());


    if(!addSlkListenered){
     newtimes.production.ProdMaintain_Properties.CURRENT_SELECTED_STYLE_SEQ_IN_STYLE_LIST=-1;//clear selection
     myRowSelectionHandler= new myListSelectionListener(multiEditorJTableInSuper.getJTable());
     multiEditorJTableInSuper.getJTable().getSelectionModel().addListSelectionListener(
           myRowSelectionHandler);
           myRowSelectionHandler.setUltraTable(this);
      addSlkListenered=true;
    }
    ((exgui.MultiClassTableModel)getJtable().getModel()).setCellEditablePolicy(
     new myEditablePolicy());

     MyRenderer myder=new MyRenderer();
    this.getJtable().getColumnModel().getColumn(0).setCellRenderer(myder);
     MyQtyRenderer myQtyrder=new MyQtyRenderer();
     this.getJtable().getColumnModel().getColumn(QTY_COLUMN_AT).setCellRenderer(myQtyrder);

     //((exgui.MultiClassTableModel)getJtable().getModel()).removeEditableColumn(DISP_STY_QTY);





     this.getJtable().getModel().addTableModelListener(this);
  }
  class CT_SEQ_MAPPING implements exgui.ultratable.CellTxtEditorFormat,exgui.Object2String{
    Object objIntVfy;
    public CT_SEQ_MAPPING(){
      objIntVfy=exgui.verification.CellFormat.getIntVerifierAllowNull(3);
    }
    public int getMaxLength(){return ((exgui.ultratable.CellTxtEditorFormat)objIntVfy).getMaxLength();}
    public boolean isFormatValid(String str ,int col,int row){
      boolean firstResult= ((exgui.ultratable.CellTxtEditorFormat)objIntVfy).isFormatValid(str,col,row);
      if(!firstResult) return firstResult;
      if(!hmCtMapKeyIsCtSeq.containsKey(str)){
        return false;
      }
      return true;
    }
    public String formatPromptMsg(){
     // return ((exgui.ultratable.CellTxtEditorFormat)objIntVfy).formatPromptMsg();
     return "Please Input C/T Sequence.";
    }
    public String Obj2String(Object obj){
      if(obj!=null)return (String)hmCtMapKeyIsProdPk.get(obj.toString());
      return (String)hmCtMapKeyIsProdPk.get(obj);
    }
    public Object cellStringToObject(String str){
      return hmCtMapKeyIsCtSeq.get(str);
    }
    public KeyProcess getKeyListener(){
      return ((exgui.ultratable.CellTxtEditorFormat)objIntVfy).getKeyListener();
    }
  }
  protected int getEachPageRowCount() {
    /**@todo Implement this exgui.ultratable.AbstractUltraTablePanel abstract method*/
    return 99999;
  }

  protected class qtyreccont_to_string implements exgui.ultratable.CellTxtEditorFormat,exgui.Object2String {
    public int getMaxLength(){return 3;}
    public  boolean isFormatValid(String string2Varify,int checkingRow,int checkingColumn){return true;}
    public String formatPromptMsg(){return "";}
    public Object cellStringToObject(String string2kvt){return null;}
    public KeyProcess getKeyListener(){return null;}
    public String Obj2String(Object obj){return "...";}
  }

  public class VfyFOBPrx implements exgui.ultratable.CellTxtEditorFormat,exgui.Object2String{
    Object orgFvyObj=null;
    public VfyFOBPrx(){
      orgFvyObj=exgui.verification.CellFormat.getDoubleFormatAllowNull(7,2);
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
      //test if have to modify the remain 3 column.

      if((column==BYR_DOC_PRX_AT || column==MKR_DOC_PRX_AT) && !isProcessingTlbOkChk){
        getJtable().setValueAt(inStr, row, column+1);
      }
      //getJtable().setValueAt(inStr, row, column);
      return isVld;
    }
    public String Obj2String(Object obj2kvt){
      return ((exgui.Object2String)orgFvyObj).Obj2String(obj2kvt);
    }
     public Object cellStringToObject(String String2kvt){
       return ((exgui.ultratable.CellTxtEditorFormat)orgFvyObj).cellStringToObject(String2kvt);
     }

   }



  protected Hashtable getObject2StringConvertor() {
    /**@todo Implement this exgui.ultratable.AbstractUltraTablePanel abstract method*/
    //throw new java.lang.UnsupportedOperationException("Method getObject2StringConvertor() not yet implemented.");
    Object  qtyVfy=exgui.verification.CellFormat.getDoubleFormatAllowNull(7,2);
    Object char30=exgui.verification.CellFormat.getOrdinaryField(30);
    Object char50=exgui.verification.CellFormat.getOrdinaryField(50);
    Object char100=exgui.verification.CellFormat.getOrdinaryField(100);
    Object floatVfy=new VfyFOBPrx();//exgui.verification.CellFormat.getDoubleFormatAllowNull(7,2);
    try{
      hmCtMapKeyIsCtSeq =
          ((newtimes.production.process.prodmaintain.DB_NTHKStyleListHandler)
           dbHandler).getCtMapKeyCtSeq();
      hmCtMapKeyIsProdPk =
          ((newtimes.production.process.prodmaintain.DB_NTHKStyleListHandler)
           dbHandler).getCtMapKeyIsProdPK();
    }catch(Exception exp){
       exp.printStackTrace();
    }

    Object CT_SEQ_CNV=new CT_SEQ_MAPPING();
    //Object char25=exgui.verification.CellFormat.getOrdinaryField(25);
    //Object char5=exgui.verification.CellFormat.getOrdinaryField(5);
    Hashtable iso=new Hashtable();
    iso.put(DISP_STY_CT_SEQ,CT_SEQ_CNV);
    iso.put(DISP_STY_STYLE,char30);
    iso.put(DISP_STY_PO,char30);
    iso.put(DISP_STY_BARCODE,char50);
    iso.put(DISP_STY_BUYER_LABEL,char100);
    iso.put(DISP_STY_NO,exgui.verification.CellFormat.getIntVerifierAllowNull(3));
    //iso.put(DISP_STY_QTY,DB_STY_QTY);
    //Object dateCnv=exgui.verification.CellFormat.getDateStringFormaterAllowNull();
    //Object char1=exgui.verification.CellFormat.getOrdinaryField(1);
    //Object DInt7F3=exgui.verification.CellFormat.getDoubleFormatAllowNull(7,3);
    iso.put(DISP_STY_QTY,qtyVfy);
    iso.put(DISP_BYR_ACT_PRX,floatVfy);iso.put(DISP_BYR_DOC_PRX,floatVfy);
    iso.put(DISP_MKR_ACT_PRX,floatVfy);iso.put(DISP_MKR_DOC_PRX,floatVfy);


    //only allow MIS user to modify the profit data.
//STY_BUY_COMM, STY_MKR_DSCT_PER, STY_MKR_DSCT_PC,
//STY_MKR_DSCT_DZ, STY_CMT_PRICE, , STY_YY4, STY_QTA_CAT
    Object DInt3F2 = exgui.verification.CellFormat.getDoubleFormatAllowNull(
        3, 2);

    Object DInt4F3 = exgui.verification.CellFormat.getDoubleFormatAllowNull(
            4, 3);

    Object DInt5F3 = exgui.verification.CellFormat.getDoubleFormatAllowNull(
                5, 3);

    Object DInt8F3 = exgui.verification.CellFormat.getDoubleFormatAllowNull(
        8, 3);
    iso.put(DISP_STY_BUY_COMM, DInt3F2);
    iso.put(DISP_STY_MKR_DISC, DInt3F2);


    iso.put(DISP_STY_MKR_DSCT_PC, DInt4F3);
    iso.put(DISP_STY_MKR_DSCT_DZ, DInt5F3);
    iso.put(DISP_STY_MKR_DSCT_LUMP_SUM, DInt8F3);

    iso.put(DISP_STY_BUY_DSCT_PC, DInt4F3);
    iso.put(DISP_STY_BUY_DSCT_DZ, DInt5F3);
    iso.put(DISP_STY_BUY_DSCT_LUMP_SUM, DInt8F3);

    Object dateVfy=exgui.verification.CellFormat.getDateStringFormaterAllowNull();
    iso.put(DISP_DLV_DATE,dateVfy);
    iso.put(DISP_MKR_DLV,dateVfy);
    if(RECFM_DATE_AT!=-1){
      iso.put(DISP_RECFM_DATE,dateVfy);
    }

    //iso.put(DISP_STY_FOB_RPX,DB_STY_FOB_PRX);

    //only allow MIS user to modify the profit data.
    //STY_BUY_COMM, STY_MKR_DSCT_PER, STY_MKR_DSCT_PC,
    //STY_MKR_DSCT_DZ, STY_CMT_PRICE, , STY_YY4, STY_QTA_CAT

    return iso;
  }

  protected PagedDataFactory getPagedDataFactory() {
    /**@todo Implement this exgui.ultratable.AbstractUltraTablePanel abstract method*/
    //throw new java.lang.UnsupportedOperationException("Method getPagedDataFactory() not yet implemented.");
    try{
      dbHandler = new newtimes.production.process.prodmaintain.
          DB_NTHKStyleListHandler(
          (String)newtimes.preproduction.Constants.CURRENT_PREPROD_HEAD_RECORD.
          get("prod_sc_no"));
    }catch(Exception exp){
      exp.printStackTrace();
      util.ExceptionLog.exp2File(exp,"");
    }
    return dbHandler;
  }

  public void doPaste(){
    if(!"NTHK".equals(util.PublicVariable.OPERATTING_CENTER)){
      if(null==copiedStySeq){
        exgui.verification.VerifyLib.showAlert("No Copied Record To Paste","No Copied Record To Paste");
        return;
      }
      if(getJtable().getSelectedRow()<0){
        exgui.verification.VerifyLib.showPlanMsg(
        "Please Select A Row To Paste Copied Data","Please Select A Row");
        return;
      }
       Record recdst=(Record)getDisplayingRecords().get(getJtable().getSelectedRow());
       try{
         Object qtyStr = recdst.get("total_Qty");
         double qty=Double.parseDouble((qtyStr==null||qtyStr.toString().trim().equals(""))?"0":qtyStr.toString().trim());
         if(qty!=0){
           exgui.verification.VerifyLib.showAlert("Already Have Color-Price-breakdown\nCan Not Paste To Overwrite Qty",
                                                  "Can Not Paste To Overwrite Qty");
           return;
         }
         util.MiscFunc.showProcessingMessage();
         newtimesejb.TPE_MIS.TpeMisFuncHome ejbHome=
             (newtimesejb.TPE_MIS.TpeMisFuncHome)
             info_ejb.WeblogicServiceLocator.locateServiceHome(util.PublicVariable.SERVER_URL,
             "newtimesejb.TPE_MIS.TpeMisFunc");
         newtimesejb.TPE_MIS.TpeMisFunc asaEjb=ejbHome.create();
         java.util.HashMap hm=new java.util.HashMap();
         hm.put("TPEMISCFUNC_ACTION_CODE","PASTE_STYLE_WITH_COLOR_PRX_QTY");
         hm.put("SRC_STY_SEQ",copiedStySeq);
         hm.put("DST_STY_SEQ",recdst.get(0).toString());
         hm.put("user_code",util.PublicVariable.USER_RECORD.get(0));
         asaEjb.tpeMisFunc(hm);
         reload();
       }catch(Exception exp){
         exp.printStackTrace();
         util.ExceptionLog.exp2File(exp,"");
         exgui.verification.VerifyLib.showAlert("Error While Copy & Paste Style","Error !!");
       }finally{
         util.MiscFunc.hideProcessingMessage();
       }
      //check
      return;
    }
   Object storedObj=util.ApplicationProperites.getProperties(
     id4ApplicationProperties
   );
   if(storedObj==null){
     exgui.verification.VerifyLib.showPlanMsg(
     "No Copied Data To Paste","No Copied Data To Paste");
     return;
   }
   if(getJtable().getSelectedRow()<0){
     exgui.verification.VerifyLib.showPlanMsg(
     "Please Select A Row To Paste Copied Data","Please Select A Row");
     return;
   }
   int selectedRow[]=getJtable().getSelectedRows();
   if(super.getJtable().getCellEditor()!=null)
     super.getJtable().getCellEditor().cancelCellEditing();
   copiedColumns=(Object[])storedObj;
   //style & po no need to copy
   for(int i=((STY_NO_CLUMN_AT==-1)?2:3);i<copiedColumns.length;i++){
     for(int j=0;j<selectedRow.length;j++){
       if(i==BUYER_LABEL_COLUMN_AT||i==BARCODE_COLUMN_AT||
          i==MKR_ACT_PRX_AT|| i==MKR_DOC_PRX_AT||
          i==BYR_ACT_PRX_AT|| i==BYR_DOC_PRX_AT){
         continue;
       }
       if (getJtable().isCellEditable(selectedRow[j], i)) {
         getJtable().setValueAt(
             copiedColumns[i],
             selectedRow[j], i
             );
       }
     }
   }
 }

  public class myListSelectionListener
      implements
      javax.swing.event.ListSelectionListener {
    javax.swing.JTable editingTbl = null;
    exgui.ultratable.AbstractUltraTablePanel parentPnl = null;
    public myListSelectionListener(javax.swing.JTable _jtbl) {
      editingTbl = _jtbl;
    }

    public void setUltraTable(exgui.ultratable.AbstractUltraTablePanel
                              _parentPnl) {
      parentPnl = _parentPnl;
    }

    public void valueChanged(javax.swing.event.ListSelectionEvent e) {
      //System.out.println("selected row No is:"+editingTbl.getSelectedRow());
      //System.out.println("selected column No is:"+editingTbl.getSelectedColumn());
      if(editingTbl.getSelectedRow() == -1&& editingTbl.getRowCount()==1){
        database.datatype.Record rec =
            (database.datatype.Record) parentPnl.getDisplayingRecords().get(0);
        newtimes.production.ProdMaintain_Properties.
            CURRENT_SELECTED_STYLE_SEQ_IN_STYLE_LIST =
            rec.getInt(0);
        newtimes.production.ProdMaintain_Properties.EDITING_STYLE_RECORD =rec;
      }else if (editingTbl.getSelectedRow() == -1) {
        newtimes.production.ProdMaintain_Properties.
            CURRENT_SELECTED_STYLE_SEQ_IN_STYLE_LIST = -1;
      }else {
        database.datatype.Record rec =
            (database.datatype.Record) parentPnl.getDisplayingRecords().get(
            editingTbl.getSelectedRow());
        newtimes.production.ProdMaintain_Properties.
            CURRENT_SELECTED_STYLE_SEQ_IN_STYLE_LIST =
            rec.getInt(0);
        newtimes.production.ProdMaintain_Properties.EDITING_STYLE_RECORD =rec;
        //System.out.println("select style at PnlNTHKStyleList is:"+rec);
      }
      util.ApplicationProperites.setProperties("PnlNTHKStyleList_beginRow_at",
                                               new Integer(parentPnl._rowPosition));
    }
  }
}
