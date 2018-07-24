package newtimes.production.gui.prodmaintain;

import processhandler.template.PnlTableEditor;
import exgui.ultratable.*;
import database.datatype.*;
import util.InsertionOrderedHashMap;
import processhandler.*;
import java.util.Hashtable;
import java.awt.Component;
import javax.swing.table.TableCellRenderer;
import javax.swing.JLabel;
/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class PnlStyleList extends PnlTableEditor
    implements java.awt.event.MouseListener {
 //STY_STYLE, STY_PO, STY_NO, STY_SC_NO,
 // STY_ORIG_DEL, STY_ORIG_WAY, STY_RECFM_DEL, STY_RECFM_SHIP,
 //STY_UPDT, STY_UPDT_SHIP, STY_OFF_SHORE, STY_OFF_SHORE_SHIP,
  static String DISP_STY_STYLE="STYLE  \nNO";
  static String DB_STY_STYLE="STY_STYLE";
  static String DB_STY_NO="STY_NO";
  static String DISP_STY_NO="Print\nSEQ.";
  static String DISP_STY_PO="PO  ";
  static String DB_STY_PO="STY_PO";
  static String DISP_STY_QTA="QTA¡¿  ";
  static String DB_STY_QTA="STY_QTA";

  static String DISP_STY_QTY="   ";
  static String DISP_STY_QTY_REC_COUNT_BUTTON="  ";
  static String DB_STY_QTY="total_Qty";//joined and summed from qty of specified style seqence
  static String DB_STY_QTY_REC_COUNT="qty_rec_count";//joined and summed from qty of specified style seqence
  //STY_BUY_COMM, STY_MKR_DSCT_PER, STY_MKR_DSCT_PC,
  //STY_MKR_DSCT_DZ, STY_CMT_PRICE, , STY_YY4, STY_QTA_CAT
  static String DISP_STY_BUY_COMM="BUY\nCOMM%";
  static String DB_STY_BUY_COMM="STY_BUY_COMM";
  static String DISP_STY_MKR_DISC="MAKER\nDISCOUNT%";
  static String DB_STY_MKR_DISC="STY_MKR_DSCT_PER";
  static String DISP_STY_MKR_DSCT_PC="MAKER\nDISCOUNT\nUNIT";
  static String DB_STY_MKR_DSCT_PC="STY_MKR_DSCT_PC";
  static String DISP_STY_MKR_DSCT_DZ="MAKER\nDISCOUNT\nDZ";
  static String DB_STY_MKR_DSCT_DZ="STY_MKR_DSCT_DZ";

  static String DISP_STY_MKR_DSCT_LUMP_SUM="MAKER\nDISTCOUNT\nLUMP SUM";
  static String DB_STY_MKR_DSCT_LUMP_SUM="STY_MKR_DSCT_LUMP_SUM";


  static String DISP_STY_BUY_DSCT_PC="BUYER\nCOMMISION\nUNIT";
  static String DB_STY_BUY_DSCT_PC="STY_BUY_DSCT_PC";
  static String DISP_STY_BUY_DSCT_DZ="BUYER\nCOMMISION\nDZ";
  static String DB_STY_BUY_DSCT_DZ="STY_BUY_DSCT_DZ";

  static String DISP_STY_BUY_DSCT_LUMP_SUM="BUYER\nCOMMISION\nLUMP SUM";
  static String DB_STY_BUY_DSCT_LUMP_SUM="STY_BUY_DSCT_LUMP_SUM";


  static String DISP_STY_CMT_RPX="CMT";
  static String DB_STY_CMT_PRX="STY_CMT_PRICE";

  static String DISP_STY_FOB_RPX="Buyer\nDoc\nPRICE";
  static String DB_STY_FOB_PRX="FOB_PRICE";//joined from price table,only for the first row of current style sequence

  //STY_YY1, STY_YY2, STY_YY3

  static String DB_STY_UNIT="STY_UNIT";
  static String DISP_STY_UNIT="UNIT¡¿";//"UNIT¡¿";

  static String DB_STY_BARCODE="STY_BARCODE";
  static String DISP_STY_BARCODE="    BARCODE    ";
  static int BARCODE_COLUMN_AT=-1;

  static String DB_STY_BUYER_LABEL="STY_BUYER_LABEL";
  static String DISP_STY_BUYER_LABEL="      BUYER LABEL      ";
  static int BUYER_LABEL_COLUMN_AT=-1;

  static String DB_BYR_ACT_PRX="byr_act_prx";
  static String DISP_BYR_ACT_PRX="ACT.";
  static String DB_BYR_DOC_PRX="byr_doc_prx";
  static String DISP_BYR_DOC_PRX="DOC.";

  static String DB_MKR_ACT_PRX="mkr_act_prx";
  static String DISP_MKR_ACT_PRX="ACT. ";

  static String DB_MKR_DOC_PRX="mkr_doc_prx";
  static String DISP_MKR_DOC_PRX="DOC. ";

  static String DISP_STY_YY1="YY1";
  static String DB_STY_YY1="STY_YY1";

  static String DISP_STY_STORE="STORE";
  static String DB_STY_STORE="STY_ITEM";

  static String DISP_STY_ORG_STYLE="ORIGNAL\nSTYLE";
  static String DB_STY_ORG_STYLE="STY_ITEM_NAME";



  static public int UNIT_COLUMN_AT=5;
   static public int STORE_COLUMN_AT=25;
  static public int CAT_DATA_COLUMN_AT=2;
  static public int QTY_COLUMN_AT=3;
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
  static int STY_YY1_AT=-1;
  static int DB_STY_QTY_TYPE_AT=26;
  static String DB_STY_FABPO_SEQ_0="sty_fabpo_seq_0";//sty_fabpo_seq
  static String DB_STY_FABPO_SEQ_1="sty_fabpo_seq_1";//sty_fabpo_seq
  static String DB_STY_FABPO_SEQ_2="sty_fabpo_seq_2";//sty_fabpo_seq
  static String DB_STY_FABPO_SEQ_3="sty_fabpo_seq_3";//sty_fabpo_seq
  static String DB_STY_FABPO_SEQ_4="sty_fabpo_seq_4";//sty_fabpo_seq
  static String DB_STY_FABPO_SEQ_5="sty_fabpo_seq_5";//sty_fabpo_seq
  static String DISP_STY_FABPO_SEQ_0="Fabric 1\nPO¡¿";//sty_fabpo_seq
  static String DISP_STY_FABPO_SEQ_1="Fabric 2\nPO¡¿";//sty_fabpo_seq
  static String DISP_STY_FABPO_SEQ_2="Fabric 3\nPO¡¿";//sty_fabpo_seq
  static String DISP_STY_FABPO_SEQ_3="Fabric 4\nPO¡¿";//sty_fabpo_seq
  static String DISP_STY_FABPO_SEQ_4="Fabric 5\nPO¡¿";//sty_fabpo_seq
  static String DISP_STY_FABPO_SEQ_5="Fabric 6\nPO¡¿";//sty_fabpo_seq
  static int DB_STY_FABPO_SEQ_AT_0=-1;
  static int DB_STY_FABPO_SEQ_AT_1=-1;
  static int DB_STY_FABPO_SEQ_AT_2=-1;
  static int DB_STY_FABPO_SEQ_AT_3=-1;
  static int DB_STY_FABPO_SEQ_AT_4=-1;
  static int DB_STY_FABPO_SEQ_AT_5=-1;
  boolean addSlkListenered=false;
  myListSelectionListener myRowSelectionHandler=null;
  javax.swing.JButton btnSequenceStyles=new javax.swing.JButton("Style Default Setting");
  javax.swing.JButton btnMdfStylesSettings=new javax.swing.JButton("Update Prod. Info");
  javax.swing.JButton btnMoveStyles2OtherProd=new javax.swing.JButton("Move To Other PO.");
  javax.swing.JButton btnCopyPastePrice=new javax.swing.JButton("Copy & Paste Price");
  javax.swing.JButton btnCopy2OtherPo=new javax.swing.JButton("Copy To Other Po");

  java.util.HashMap hmQTY_STYLE_SEQ_KEY_VALUE=new java.util.HashMap();
  java.util.HashMap hmPrxRec_STYLE_SEQ_KEY_VALUE=new java.util.HashMap();
  java.util.HashMap hmRowAndRecMapping=new java.util.HashMap();
  java.util.HashMap hmStySeqMapFabPo=new java.util.HashMap();

  static Record blankPriceRec=null;
  boolean qtyIsOk=true;
  boolean isProcessingTlbOkChk=false;
  boolean isGoPageAfterUpdate=false;
  boolean isAlwaysAllowToEditBuyerComm=false;
  public PnlStyleList() {
    //super object make the jtable.we need to show current page.
    //super();


    int rowBeginAt=0;
    if(util.ApplicationProperites.getProperties("PnlStyleList_beginRow_at")!=null){
        rowBeginAt=((Integer)util.ApplicationProperites.getProperties("PnlStyleList_beginRow_at")).intValue();
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
    this.getJtable().addMouseListener(this);
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

    btnCopy2OtherPo.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent e) {
          copyStyle2OtherPo();
      }
    });


    btnCopyPastePrice.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent e) {
          CopyPastePriceBetweenColumns();
      }
    });

    if(util.PublicVariable.OPERATTING_CENTER.equals("NTHK")){
     getPanelContainsButtons().removeAll();
     super.getLowerRightPanel().add(btnCopyPastePrice);
    }
   try{
     getPanelContainsButtons().removeAll();
      if (newtimes.production.ProdMaintain_Properties.isAbleToEdit()) {
        getLowerRightPanel().add(btnSequenceStyles);
        getLowerRightPanel().add(btnMdfStylesSettings);
        getLowerRightPanel().add(btnMoveStyles2OtherProd);
     }
     if(util.PublicVariable.USER_RECORD.getInt(2)==newtimesejb.preproduction.PreProductionHead.USER_TYPE_SUPERVIOSER_MIS){
       getLowerRightPanel().add(btnCopy2OtherPo);
     }

   }catch(Exception exp){
     exp.printStackTrace();
     util.ExceptionLog.exp2File(exp,"");
   }


  }

  protected void makeTable(java.util.Vector vct){
    hmRowAndRecMapping.clear();
    for(int i=0;i<vct.size();i++){
      Record rec=(Record)vct.get(i);
      hmRowAndRecMapping.put(String.valueOf(rec.getInt(0)),String.valueOf(i));
    }
    super.makeTable(vct);

     //adjust the table column of size
       getJtable().getColumnModel().getColumn(0).setPreferredWidth(70); //style name
       getJtable().getColumnModel().getColumn(1).setPreferredWidth(70); //sty no
       if(STY_NO_CLUMN_AT!=-1){
         getJtable().getColumnModel().getColumn(STY_NO_CLUMN_AT).setPreferredWidth(
             40); //sty no seq field
       }
       getJtable().getColumnModel().getColumn(QTY_COLUMN_AT-1).setPreferredWidth(70); //QTA_COUMN
       getJtable().getColumnModel().getColumn(QTY_COLUMN_AT).setPreferredWidth(70); //QTY colum
       getJtable().getColumnModel().getColumn(QTY_COLUMN_AT+1).setPreferredWidth(40); //"..." button
       getJtable().getColumnModel().getColumn(BYR_DOC_PRX_AT-1).setPreferredWidth(70); //unit
       getJtable().getColumnModel().getColumn(BYR_DOC_PRX_AT).setPreferredWidth(45); //buyr doc prx
       getJtable().getColumnModel().getColumn(BYR_ACT_PRX_AT).setPreferredWidth(45); //buyr doc prx
       getJtable().getColumnModel().getColumn(MKR_DOC_PRX_AT).setPreferredWidth(45); //buyr doc prx
       getJtable().getColumnModel().getColumn(MKR_ACT_PRX_AT).setPreferredWidth(45); //buyr doc prx
       //getJtable().getColumnModel().getColumn(MKR_ACT_PRX_AT+1).setPreferredWidth(45); //CMT
       if(BYR_COMM_PER_AT!=-1) getJtable().getColumnModel().getColumn(BYR_COMM_PER_AT).setPreferredWidth(60); //buyr comm %
       if(MKR_DISCT_PER_AT!=-1)getJtable().getColumnModel().getColumn(MKR_DISCT_PER_AT).setPreferredWidth(85); //maker discount %
       if(BYR_DISCT_PC_AT!=-1)getJtable().getColumnModel().getColumn(BYR_DISCT_PC_AT).setPreferredWidth(80); //buyr comm pc
       if(MKR_DISCT_PC_AT!=-1)getJtable().getColumnModel().getColumn(MKR_DISCT_PC_AT).setPreferredWidth(70); //maker discount pc
       if(BYR_DISCT_DZ_AT!=-1)getJtable().getColumnModel().getColumn(BYR_DISCT_DZ_AT).setPreferredWidth(75); //buyr comm %
       if(MKR_DISCT_DZ_AT!=-1)getJtable().getColumnModel().getColumn(MKR_DISCT_DZ_AT).setPreferredWidth(70); //buyr comm %
       if(getJtable().getRowCount()>0){
         getJtable().changeSelection(0,0,false,false);
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
        ((newtimes.production.process.prodmaintain.DB_StyleListHandler)getPagedDataFactory()).copyStylesTo(
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
        StringBuffer sb=new StringBuffer();
        int orgProdHeadPk=0;
        for(int i=0;i<selectedRows.length;i++){
          Record rec=(Record)getDisplayingRecords().get(selectedRows[i]);
          if(i==0)orgProdHeadPk=rec.getInt(1);
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
        ((newtimes.production.process.prodmaintain.DB_StyleListHandler)getPagedDataFactory()).moveStyles(sb.toString(),
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
    DlgSequencialAddStyles dlg=new  DlgSequencialAddStyles(
       util.PublicVariable.APP_FRAME,
       "Modify All Styles Attributs",true,
       (newtimes.production.process.prodmaintain.DB_StyleListHandler)getPagedDataFactory(),true);
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
    DlgSequencialAddStyles dlg=new  DlgSequencialAddStyles(
       util.PublicVariable.APP_FRAME,
       "Batch Add Styles",true,
       (newtimes.production.process.prodmaintain.DB_StyleListHandler)getPagedDataFactory());
     dlg.setStyNo2Follow(styNo2Follow);
     dlg.setSize(555,470);
     dlg.show();
     if(dlg.myOperationStatus==dlg.STATUS_CLOSE_NORMALLY){
       //something add to database.
       this.reload();
     }
  }
  public void mouseClicked(java.awt.event.MouseEvent e){
    //System.out.println("get select row and column in CLICK=="+getJtable().getSelectedRow()+"," +getJtable().getSelectedColumn());
    if(this.getJtable().getSelectedRow()<0)return;
    if(getJtable().getSelectedColumn()==QTY_COLUMN_AT || getJtable().getSelectedColumn()==(QTY_COLUMN_AT+1)){
      //goto edit qty process
      this.setCursor(new java.awt.Cursor(java.awt.Cursor.WAIT_CURSOR));
      try{
        processhandler.template.Properties.getCenteralControler().doCommandExecute(
        new newtimes.production.process.prodmaintain.TgrToListStyQty());
      }catch(Exception exp){
        exp.printStackTrace();
        util.ExceptionLog.exp2File(exp,"exp while swith to qty");
      }finally{
      this.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
      }
    }
  }
  public void mouseEntered(java.awt.event.MouseEvent e){

  }
  public void mouseExited(java.awt.event.MouseEvent e){

  }
  public void mousePressed(java.awt.event.MouseEvent e){

  }
  public void mouseReleased(java.awt.event.MouseEvent e){

  }

  protected Record setObject2Record(Record rec, int columnAt, Object value2update) {
    /**@todo Implement this exgui.ultratable.AbstractUltraTablePanel abstract method*/
    //throw new java.lang.UnsupportedOperationException("Method setObject2Record() not yet implemented.");
    if(!qtyIsOk)return null;
    if(isGoPageAfterUpdate) return null;
    try{
      int rowat=Integer.parseInt((String)hmRowAndRecMapping.get(String.valueOf(rec.getInt(0))));
      if(columnAt==DB_STY_FABPO_SEQ_AT_0||
         columnAt==DB_STY_FABPO_SEQ_AT_1||
         columnAt==DB_STY_FABPO_SEQ_AT_2||
         columnAt==DB_STY_FABPO_SEQ_AT_3){
         /*
         columnAt==DB_STY_FABPO_SEQ_AT_4||
         columnAt==DB_STY_FABPO_SEQ_AT_5){*/
        String fabPoSeq[]=null;
        if(hmStySeqMapFabPo.get(rec.get(0).toString())!=null){
          fabPoSeq=(String[])hmStySeqMapFabPo.get(rec.get(0).toString());
          //fabPoSeq[columnAt-DB_STY_FABPO_SEQ_AT_0]=(value2update==null)?"SET TO NULL":value2update.toString();
        }else{
          fabPoSeq=new String[]{"","","","","",""};
          //fabPoSeq[columnAt-DB_STY_FABPO_SEQ_AT_0]=(value2update==null)?"SET TO NULL":value2update.toString();
        }
        fabPoSeq[columnAt-DB_STY_FABPO_SEQ_AT_0]=(value2update==null)?"SET TO NULL":value2update.toString();
        hmStySeqMapFabPo.put(rec.get(0).toString(),fabPoSeq);
        //hmStySeqMapFabPo.put(rec.get(0).toString(),(value2update==null)?null:value2update.toString());
      }
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
      String orgKlmName=storedRecordColumn[columnAt];
      String unitStr=((Wraper4tblCbx)getJtable().getValueAt(rowat,UNIT_COLUMN_AT)).toString();
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
 /*     if(unitStr.startsWith("H.")||unitStr.startsWith("T.")||unitStr.startsWith("TH")){
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
*/

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
     DB_STY_FABPO_SEQ_AT_0=-1;
     DB_STY_FABPO_SEQ_AT_1=-1;
     DB_STY_FABPO_SEQ_AT_2=-1;
     DB_STY_FABPO_SEQ_AT_3=-1;
     DB_STY_FABPO_SEQ_AT_4=-1;
     DB_STY_FABPO_SEQ_AT_5=-1;

     try{
       //for tpe user,have to check if buyer-ware-house with code 'C',mease allow to edit buyer-commision
       isAlwaysAllowToEditBuyerComm=false;
       if(newtimes.preproduction.Constants.BYMKR_WAREHOUSE_STRING ==null){
         java.util.Vector vctBuyerWareHousse=
             exgui2.CONST.BASIC_MAIN_EJB.getDatas(
                util.PublicVariable.USER_RECORD,
                "select BYMKR_WAREHOUSE from buyer_maker where bymkr_seq="+
                newtimes.preproduction.Constants.CURRENT_PREPROD_HEAD_RECORD.getInt("PROD_BUYER"),
               1,9999999);
         Record rec=(Record) vctBuyerWareHousse.get(0);
         String buyerWareHouseCode=(String)rec.get(0);
         newtimes.preproduction.Constants.BYMKR_WAREHOUSE_STRING=(buyerWareHouseCode==null)?"":buyerWareHouseCode.toUpperCase();
        }
        if(newtimes.preproduction.Constants.BYMKR_WAREHOUSE_STRING.indexOf("C")!=-1){
           isAlwaysAllowToEditBuyerComm=true;
        }else {
           isAlwaysAllowToEditBuyerComm=false;
        }


     }catch(Exception exp){
       exp.printStackTrace();
     }


     MKR_DISCT_PER_AT=-1; BARCODE_COLUMN_AT=-1;BUYER_LABEL_COLUMN_AT=-1;

     newtimes.production.gui.prodmaintain.PnlStyleList.UNIT_COLUMN_AT=6;
     newtimes.production.gui.prodmaintain.PnlStyleList.CAT_DATA_COLUMN_AT=3;
     newtimes.production.gui.prodmaintain.PnlStyleList.QTY_COLUMN_AT=4;
     newtimes.production.gui.prodmaintain.PnlStyleList.STY_NO_CLUMN_AT=2;

    /*
    if(util.PublicVariable.OPERATTING_CENTER.equals("NTHK")){
      newtimes.production.gui.prodmaintain.PnlStyleList.UNIT_COLUMN_AT=6;
      newtimes.production.gui.prodmaintain.PnlStyleList.CAT_DATA_COLUMN_AT=3;
      newtimes.production.gui.prodmaintain.PnlStyleList.QTY_COLUMN_AT=4;
      newtimes.production.gui.prodmaintain.PnlStyleList.STY_NO_CLUMN_AT=2;
    }else{
       newtimes.production.gui.prodmaintain.PnlStyleList.UNIT_COLUMN_AT=5;
       newtimes.production.gui.prodmaintain.PnlStyleList.CAT_DATA_COLUMN_AT=2;
       newtimes.production.gui.prodmaintain.PnlStyleList.QTY_COLUMN_AT=3;
       newtimes.production.gui.prodmaintain.PnlStyleList.STY_NO_CLUMN_AT=-1;
    }*/

    util.InsertionOrderedHashMap iso=new util.InsertionOrderedHashMap();
    iso.put(DISP_STY_STYLE,DB_STY_STYLE);//0
    iso.put(DISP_STY_PO,DB_STY_PO);//1
    if(STY_NO_CLUMN_AT!=-1){
      iso.put(DISP_STY_NO,DB_STY_NO);
    }
    iso.put(DISP_STY_QTA,DB_STY_QTA);//2

    iso.put(DISP_STY_QTY,DB_STY_QTY);//3
    iso.put(DISP_STY_QTY_REC_COUNT_BUTTON,DB_STY_QTY_REC_COUNT);//4

    iso.put(DISP_STY_UNIT,DB_STY_UNIT);//5
    //iso.put(DISP_STY_FOB_RPX,DB_STY_FOB_PRX);//6
    iso.put(DISP_BYR_DOC_PRX,DB_BYR_DOC_PRX);
    BYR_DOC_PRX_AT =iso.entrySet().size()-1;
    iso.put(DISP_BYR_ACT_PRX,DB_BYR_ACT_PRX);
    BYR_ACT_PRX_AT =iso.entrySet().size()-1;

    iso.put(DISP_MKR_DOC_PRX,DB_MKR_DOC_PRX);
    MKR_DOC_PRX_AT =iso.entrySet().size()-1;
    iso.put(DISP_MKR_ACT_PRX,DB_MKR_ACT_PRX);
    MKR_ACT_PRX_AT =iso.entrySet().size()-1;

    //iso.put(DISP_STY_CMT_RPX,DB_STY_CMT_PRX);//7
    //test if user is authorized to view buyer commision ,maker discount .
    try{
      String authKeyWord=(String)util.PublicVariable.USER_RECORD.get("edit_bymkr_comm_discount");
      if (authKeyWord!=null){
        //allow to show maker discount
        //allow to show buyer maker.
        boolean isWithBuyComm=(authKeyWord.indexOf("B")!=-1);
        boolean isWithMkrDisct=(authKeyWord.indexOf("M")!=-1);
        if(isAlwaysAllowToEditBuyerComm || isWithBuyComm){
          iso.put(DISP_STY_BUY_COMM, DB_STY_BUY_COMM); //8
          BYR_COMM_PER_AT =iso.entrySet().size()-1;
        }
        if(isWithMkrDisct){
          iso.put(DISP_STY_MKR_DISC, DB_STY_MKR_DISC); //9
          MKR_DISCT_PER_AT =iso.entrySet().size()-1;
        }
        if(isAlwaysAllowToEditBuyerComm || isWithBuyComm){
          iso.put(DISP_STY_BUY_DSCT_PC, DB_STY_BUY_DSCT_PC); //10
          BYR_DISCT_PC_AT =iso.entrySet().size()-1;
        }
        if(isWithMkrDisct){
          iso.put(DISP_STY_MKR_DSCT_PC, DB_STY_MKR_DSCT_PC); //11
          MKR_DISCT_PC_AT =iso.entrySet().size()-1;
          //System.out.println("MKR_DISCT_PC_AT:"+MKR_DISCT_PC_AT);
        }

        if(isAlwaysAllowToEditBuyerComm || isWithBuyComm){
          iso.put(DISP_STY_BUY_DSCT_DZ, DB_STY_BUY_DSCT_DZ); //12
          BYR_DISCT_DZ_AT =iso.entrySet().size()-1;
        }
        if(isWithMkrDisct){
          iso.put(DISP_STY_MKR_DSCT_DZ, DB_STY_MKR_DSCT_DZ); //13
          MKR_DISCT_DZ_AT =iso.entrySet().size()-1;
        }
        if(isAlwaysAllowToEditBuyerComm || isWithBuyComm){
          iso.put(DISP_STY_BUY_DSCT_LUMP_SUM, DB_STY_BUY_DSCT_LUMP_SUM); //14
          BYR_DISCT_LUMPSUM_AT =iso.entrySet().size()-1;
          //System.out.println("BYR_DISCT_LUMPSUM_AT:"+BYR_DISCT_LUMPSUM_AT);
        }
        if(isWithMkrDisct){
          iso.put(DISP_STY_MKR_DSCT_LUMP_SUM, DB_STY_MKR_DSCT_LUMP_SUM); //15
          MKR_DISCT_LUMPSUM_AT =iso.entrySet().size()-1;
        }
      }
      iso.put(DISP_STY_YY1, DB_STY_YY1);STY_YY1_AT=iso.entrySet().size()-1;
      iso.put(DISP_STY_BUYER_LABEL, DB_STY_BUYER_LABEL);BUYER_LABEL_COLUMN_AT=iso.entrySet().size()-1;
      iso.put(DISP_STY_FABPO_SEQ_0,DB_STY_FABPO_SEQ_0);DB_STY_FABPO_SEQ_AT_0=iso.entrySet().size()-1;
      iso.put(DISP_STY_FABPO_SEQ_1,DB_STY_FABPO_SEQ_1);DB_STY_FABPO_SEQ_AT_1=iso.entrySet().size()-1;
      iso.put(DISP_STY_FABPO_SEQ_2,DB_STY_FABPO_SEQ_2);DB_STY_FABPO_SEQ_AT_2=iso.entrySet().size()-1;
      iso.put(DISP_STY_FABPO_SEQ_3,DB_STY_FABPO_SEQ_3);DB_STY_FABPO_SEQ_AT_3=iso.entrySet().size()-1;
      iso.put(DISP_STY_STORE,DB_STY_STORE);
      iso.put(DISP_STY_ORG_STYLE,DB_STY_ORG_STYLE);
      /*
      iso.put(DISP_STY_FABPO_SEQ_3,DB_STY_FABPO_SEQ_3);DB_STY_FABPO_SEQ_AT_3=iso.entrySet().size()-1;
      iso.put(DISP_STY_FABPO_SEQ_4,DB_STY_FABPO_SEQ_4);DB_STY_FABPO_SEQ_AT_4=iso.entrySet().size()-1;
      iso.put(DISP_STY_FABPO_SEQ_5,DB_STY_FABPO_SEQ_5);DB_STY_FABPO_SEQ_AT_5=iso.entrySet().size()-1;
      */
      /*
      iso.put(DISP_STY_BARCODE, DB_STY_BARCODE);BARCODE_COLUMN_AT=iso.entrySet().size()-1;
      */
    }catch(Exception e){
      e.printStackTrace();
      util.ExceptionLog.exp2File(e,"exp while mapping column with data in sytle list jtable");
    }
    return iso;
  }
  protected boolean isMakerDiscPerPcReady(){
    try{
      //for TPE,check buyer : Ashworth & maker: ForestGrow  PO
      //if style sty like 'AM5111,and Size : S~ XL,maker discount should be 0.71
      //if style sty like 'AM5111,and Size : "3XL" ,maker discount should be 0.74
      //if style sty like 'WM50096' ,and Size : S~ XL,maker discount should be 0.74

      if ("001".equals((String)newtimes.preproduction.Constants.
                       CURRENT_PREPROD_HEAD_RECORD.get("PROD_CEN_CODE")) &&
          82 ==
          newtimes.preproduction.Constants.CURRENT_PREPROD_HEAD_RECORD.
          getInt("PROD_BUYER") &&
          153 ==
          newtimes.preproduction.Constants.CURRENT_PREPROD_HEAD_RECORD.
          getInt("PROD_MAKER")) {
        for (int i = 0; i < getDisplayingRecords().size(); i++) {
           String strStyle=(String)getJtable().getValueAt(i,0);
           Record recStyle=(Record)getDisplayingRecords().get(i);
            Object objMkrDiscPerPc=getJtable().getValueAt(i,MKR_DISCT_PC_AT);
           double mkrDiscPerPc=(objMkrDiscPerPc==null||objMkrDiscPerPc.toString().equals(""))?0:Double.parseDouble(objMkrDiscPerPc.toString());
           String strSize=null;
           if("AM5111".equals(strStyle)||"WM50096".equals(strStyle)||"AY5111".equals(strStyle)){
             if("AY5111".equals(strStyle)){
               if(0.7!=mkrDiscPerPc){
                 exgui.verification.VerifyLib.showAlert("Maker Discout Of AY5111 Should be 0.7/pc",
                                                        "Maker Disouct Incorrect");
                 getJtable().editCellAt(i,MKR_DISCT_PC_AT);
                 return false;
               }
               continue;
             }
             strSize=(String)recStyle.get("STY_SiZE_COLUMN");
             strSize=(strSize==null)?"":strSize;
             if("3XL".equals(strSize)&&"AM5111".equals(strStyle)){
               if(0.74!=mkrDiscPerPc){
                 exgui.verification.VerifyLib.showAlert("Maker Discout Of AM5111 Should be 0.74/pc",
                                                        "Maker Disouct Incorrect");
                 getJtable().editCellAt(i,MKR_DISCT_PC_AT);
                 return false;
               }
               continue;
             }
             String strSizeArr[]=util.MiscFunc.split(strSize,",,");
             boolean isSizeS=false;
             boolean isSizeXL=false;
             for(int j=0;j<strSizeArr.length;j++){
               if(strSizeArr[j].equals("S"))isSizeS=true;
               if(strSizeArr[j].equals("XL"))isSizeXL=true;
             }
             if(isSizeXL&& isSizeS &&"AM5111".equals(strStyle)){
               if(0.71!=mkrDiscPerPc){
                 exgui.verification.VerifyLib.showAlert("Maker Discout Of AM5111 Should be 0.71/pc",
                                                        "Maker Disouct Incorrect");
                 getJtable().editCellAt(i,MKR_DISCT_PC_AT);
                 return false;
               }
               continue;
             }
             if(isSizeXL&& isSizeS &&"WM50096".equals(strStyle)){
               if(0.74!=mkrDiscPerPc){
                 exgui.verification.VerifyLib.showAlert("Maker Discout Of WM50096 Should be 0.74/pc",
                                                        "Maker Disouct Incorrect");
                 getJtable().editCellAt(i,MKR_DISCT_PC_AT);
                 return false;
               }
               continue;
             }

           }
        }
      }
      return true;
    }catch(Exception exp){
       exp.printStackTrace();
       return false;
    }
  }
  protected boolean isFtyPrxGreaterThanBuyerPrxChkOk(){
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
          (newtimes.production.process.prodmaintain.DB_StyleListHandler)
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
    try{
      String styNo2Follow = getStyNo2Follow();
      //super.addRecord();
      //pop out the sub panel.allow user to add 20 record by bacth
      DldBchAddStyles4NTHK dlg2add = new DldBchAddStyles4NTHK(
          processhandler.template.Properties.getMainFrame(),
          "Add Styles", true,
          (newtimes.production.process.prodmaintain.DB_StyleListHandler)
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
      isProcessingTlbOkChk=false;
      isProcessingTlbOkChk=false;
    }
  }
  public void doAddNew() throws Exception{
    if(util.PublicVariable.OPERATTING_CENTER.equals("NTHK")){
      NTHKAddNewProcess();
    }else{
      orgAddNewProcess();
    }
 }

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
       setBackground(new java.awt.Color(0x90,0xFF,0x90)); // Decides the color
       setText(text); /* Put the current text in the JLabel */
    return this;
   }
 }

  public void doUpdate(){
    try{
      if(!isFtyPrxGreaterThanBuyerPrxChkOk())return;
      if(!isMakerDiscPerPcReady())return;
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

       ((newtimes.production.process.prodmaintain.DB_StyleListHandler)dbHandler).updateStylesAndQtyPriceWithFabPo(
        _records2Update,hmQTY_STYLE_SEQ_KEY_VALUE,hmPrxRec_STYLE_SEQ_KEY_VALUE,
        hmStySeqMapFabPo);
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
      hmStySeqMapFabPo.clear();
     //exgui.verification.VerifyLib.showPlanMsg("Update OK","Update Ok");*/
    }catch(Exception exp){
      exp.printStackTrace();
      util.ExceptionLog.exp2File(exp,"");
      exgui.verification.VerifyLib.showAlert("Update Fail Please Contatc System Manager",
                                             "Update Fail Please Contatc System Manager");
    }finally{
      isProcessingTlbOkChk=false;
      isGoPageAfterUpdate=false;
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
    if(isUsedByShipping())return;
    if(!isMakerDiscPerPcReady())return;
    //if(!isFtyPrxGreaterThanBuyerPrxChkOk())return;
     super.doDelete();
  }
  protected void refineEditors(MultiEditorJTable multiEditorJTableInSuper) {
    /**@todo Implement this exgui.ultratable.AbstractUltraTablePanel abstract method*/

    multiEditorJTableInSuper.addJComboBox(UNIT_COLUMN_AT,((newtimes.production.process.prodmaintain.DB_StyleListHandler)
                                          dbHandler).UnitsData,"UNIT","UNIT");

    multiEditorJTableInSuper.addJComboBox(CAT_DATA_COLUMN_AT,
      ((newtimes.production.process.prodmaintain.DB_StyleListHandler)
      dbHandler).getPlanQuota2Selsct(),"cat_data","cat_data");
    try{
      java.util.Vector vctDestFabPo=new java.util.Vector();
      Record zeroRec=
          (Record)util.MiscFunc.deepCopy(newtimes.preproduction.guis.tempProperties.tmpUnits.get(0));
      zeroRec.getFieldName().clear();
      zeroRec.getValueFields().clear();
      zeroRec.getFieldName().add("fab_seq");
      zeroRec.getValueFields().add(null);
      zeroRec.getFieldName().add("fab_po");
      zeroRec.getValueFields().add("");
      vctDestFabPo.add(zeroRec);
      java.util.Vector vctFabPo = exgui2.CONST.BASIC_MAIN_EJB.getDatas(
          util.PublicVariable.USER_RECORD,
          "select fab_seq,fab_po from fabric_po where record_delete_flag='1' and fab_prod_head_pk=" +
          newtimes.preproduction.Constants.CURRENT_PREPROD_HEAD_PK,
          1, 999999);
        vctDestFabPo.addAll(vctFabPo);

        /*
          exgui.ultratable.Wraper4tblCbx item0=
              new exgui.ultratable.Wraper4tblCbx();
          item0.setString("");
          item0.setValue(null);
          java.util.Vector vctTemp=new java.util.Vector();
          vctTemp.add(item0);
          for(int i=0;i<vctFabPo.size();i++){
            Record rec=(Record)vctFabPo.get(i);
            exgui.ultratable.Wraper4tblCbx item=
                new exgui.ultratable.Wraper4tblCbx();
            item.setString((String)rec.get(1));
            item.setValue(rec.get(0).toString());
            vctTemp.add(item);
          }
          exgui.ultratable.Wraper4tblCbx items[]=
              (exgui.ultratable.Wraper4tblCbx[])
               vctTemp.toArray(new exgui.ultratable.Wraper4tblCbx[0]);
      multiEditorJTableInSuper.addJComboBox(DB_STY_FABPO_SEQ_AT,items,false);
      */
      multiEditorJTableInSuper.addJComboBox(DB_STY_FABPO_SEQ_AT_0,vctDestFabPo,"fab_po","fab_seq");
      multiEditorJTableInSuper.addJComboBox(DB_STY_FABPO_SEQ_AT_1,vctDestFabPo,"fab_po","fab_seq");
      multiEditorJTableInSuper.addJComboBox(DB_STY_FABPO_SEQ_AT_2,vctDestFabPo,"fab_po","fab_seq");
      multiEditorJTableInSuper.addJComboBox(DB_STY_FABPO_SEQ_AT_3,vctDestFabPo,"fab_po","fab_seq");
       /*
      multiEditorJTableInSuper.addJComboBox(DB_STY_FABPO_SEQ_AT_4,vctDestFabPo,"fab_po","fab_seq");
      multiEditorJTableInSuper.addJComboBox(DB_STY_FABPO_SEQ_AT_5,vctDestFabPo,"fab_po","fab_seq");
      */
     java.util.Vector vctStore = exgui2.CONST.BASIC_MAIN_EJB.getDatas(
        util.PublicVariable.USER_RECORD,"select store from komar_store order by store",1, 999999);
 //      System.out.println("===>>"+multiEditorJTableInSuper.getComponentCount());
      if (util.PublicVariable.USER_RECORD.getInt(2)!=newtimesejb.preproduction.PreProductionHead.USER_TYPE_SUPERVIOSER_MIS) {
        multiEditorJTableInSuper.addJComboBox(STORE_COLUMN_AT-4, vctStore,"store", "store");
      } else {
        multiEditorJTableInSuper.addJComboBox(STORE_COLUMN_AT, vctStore,"store", "store");
      }
    }catch(Exception exp){
      exp.printStackTrace();
    }

   multiEditorJTableInSuper.setTableColumn2Grp(" QTY ",QTY_COLUMN_AT);
   multiEditorJTableInSuper.setTableColumn2Grp(" QTY ",QTY_COLUMN_AT+1);
   multiEditorJTableInSuper.addButtons(QTY_COLUMN_AT+1);

   multiEditorJTableInSuper.setTableColumn2Grp("Buyer\nPrice",BYR_DOC_PRX_AT);
   multiEditorJTableInSuper.setTableColumn2Grp("Buyer\nPrice",BYR_ACT_PRX_AT);

   multiEditorJTableInSuper.setTableColumn2Grp("Maker\nPrice",MKR_DOC_PRX_AT);
   multiEditorJTableInSuper.setTableColumn2Grp("Maker\nPrice",MKR_ACT_PRX_AT);


    multiEditorJTableInSuper.setTextEditorVerifiers(getObject2StringConvertor());
    ((exgui.MultiClassTableModel)multiEditorJTableInSuper.getJTable().getModel()).removeEditableColumn(
      DISP_STY_QTY_REC_COUNT_BUTTON);

    if(!addSlkListenered){
     newtimes.production.ProdMaintain_Properties.CURRENT_SELECTED_STYLE_SEQ_IN_STYLE_LIST=-1;//clear selection
     myRowSelectionHandler= new myListSelectionListener(multiEditorJTableInSuper.getJTable());
     multiEditorJTableInSuper.getJTable().getSelectionModel().addListSelectionListener(
           myRowSelectionHandler);
           myRowSelectionHandler.setUltraTable(this);
      addSlkListenered=true;
    }
    ((exgui.MultiClassTableModel)multiEditorJTableInSuper.getJTable().getModel()).setCellEditablePolicy(new myUnitEditablePolicy());
    MyRenderer myder=new MyRenderer();
    //no need to limit the editable policy if qty is defined.
    try{
      String authKeyWord=(String)util.PublicVariable.USER_RECORD.get("edit_bymkr_comm_discount");
       //test if user have th authorization of Read/Write buyer commision /maker discount
       if(authKeyWord==null){
      }else{
        exgui.MultiClassTableModel mdl = (exgui.MultiClassTableModel)multiEditorJTableInSuper.getJTable().getModel();
        if(authKeyWord.trim().indexOf("MR")!=-1){
          mdl.removeEditableColumn(DISP_STY_MKR_DISC);
          mdl.removeEditableColumn(DISP_STY_MKR_DSCT_PC);
          mdl.removeEditableColumn(DISP_STY_MKR_DSCT_DZ);
          mdl.removeEditableColumn(DISP_STY_MKR_DSCT_LUMP_SUM);
        }
        if(authKeyWord.trim().indexOf("BR")!=-1){
          mdl.removeEditableColumn(DISP_STY_BUY_COMM);
          mdl.removeEditableColumn(DISP_STY_BUY_DSCT_PC);
          mdl.removeEditableColumn(DISP_STY_BUY_DSCT_DZ);
          mdl.removeEditableColumn(DISP_STY_BUY_DSCT_LUMP_SUM);
        }
      }

     this.getJtable().getColumnModel().getColumn(QTY_COLUMN_AT).setCellRenderer(myder);
     //if(!util.PublicVariable.OPERATTING_CENTER.equals("NTHK")){
       this.getJtable().getColumnModel().getColumn(BYR_ACT_PRX_AT).
           setCellRenderer(myder);
       this.getJtable().getColumnModel().getColumn(BYR_DOC_PRX_AT).
           setCellRenderer(myder);

       this.getJtable().getColumnModel().getColumn(MKR_ACT_PRX_AT).
           setCellRenderer(myder);
       this.getJtable().getColumnModel().getColumn(MKR_DOC_PRX_AT).
           setCellRenderer(myder);
     //}

     //this.getJtable().getColumnModel().getColumn(QTY_COLUMN_AT+1).setCellRenderer(new MyRendererASButton());
     multiEditorJTableInSuper.addButtons(QTY_COLUMN_AT+1);
     this.getJtable().getModel().addTableModelListener(this);
    }catch(Exception e){
      e.printStackTrace();
    }
  }

  class myUnitEditablePolicy implements exgui.CellEditablePolicy{
    //to avoid chage unit after editting qty.
    public boolean isCellEditable(int row,int column){
      //all column can be editable,exception unit.
      try{
        if (column == BYR_ACT_PRX_AT || column == BYR_DOC_PRX_AT ||
            column == MKR_ACT_PRX_AT || column == MKR_DOC_PRX_AT) {
          Record rec = (Record)getDisplayingRecords().get(row);
          Object obj = //rec.get(rec.getFieldName().size()-1);
              rec.get(DB_STY_QTY_REC_COUNT);
          if (obj == null)return false;
          int qtyRecCount = Integer.parseInt(obj.toString());
          if (qtyRecCount == 1)return true; //even on record qty,style check if one-size object
          //if(qtyRecCount==1 && ((rec.getInt(105) & 0x02) == 0)) return true; //even on record STY_QTY_TYPE,style check if one-size object
          return false;
        }
        if (column == QTY_COLUMN_AT) {

          Record rec = (Record)getDisplayingRecords().get(row);
          Object obj = //rec.get(rec.getFieldName().size()-1);
              rec.get(DB_STY_QTY_REC_COUNT);
          if (obj == null)return false;
          int qtyRecCount = Integer.parseInt(obj.toString());
          if (qtyRecCount == 1 && ((rec.getInt(DB_STY_QTY_TYPE_AT) & 0x02) == 0))return true; //even on record qty,style check if one-size object
          //if(qtyRecCount==1 && ((rec.getInt(105) & 0x02) == 0)) return true; //even on record STY_QTY_TYPE,style check if one-size object
          return false;
        }
      }catch(Exception exp){
          exp.printStackTrace();
          util.ExceptionLog.exp2File(exp,"") ;
      }
      /*
      if(column!=UNIT_COLUMN_AT)return true;
      //if qyt is not null,unit can not be editable
      Object obj=getJtable().getValueAt(row,QTY_COLUMN_AT);
      if(obj==null)return true;
      float totalQty=Float.parseFloat(obj.toString());
      if(totalQty==0)return true;
      return false;*/
      return true;
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

    //Object char25=exgui.verification.CellFormat.getOrdinaryField(25);
    //Object char5=exgui.verification.CellFormat.getOrdinaryField(5);
    Hashtable iso=new Hashtable();
    iso.put(DISP_STY_STYLE,char30);
    iso.put(DISP_STY_PO,char30);
    iso.put(DISP_STY_BARCODE,char50);
    iso.put(DISP_STY_BUYER_LABEL,char100);
    iso.put(DISP_STY_NO,exgui.verification.CellFormat.getIntVerifierAllowNull(3));
    //iso.put(DISP_STY_QTY,DB_STY_QTY);
    //Object dateCnv=exgui.verification.CellFormat.getDateStringFormaterAllowNull();
    //Object char1=exgui.verification.CellFormat.getOrdinaryField(1);
    Object DInt7F3=exgui.verification.CellFormat.getDoubleFormatAllowNull(7,3);
    iso.put(DISP_STY_QTY,qtyVfy);
    iso.put(DISP_BYR_ACT_PRX,floatVfy);iso.put(DISP_BYR_DOC_PRX,floatVfy);
    iso.put(DISP_MKR_ACT_PRX,floatVfy);iso.put(DISP_MKR_DOC_PRX,floatVfy);
    iso.put(DISP_STY_CMT_RPX,DInt7F3);
    //iso.put(DISP_STY_FOB_RPX,DB_STY_FOB_PRX);

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
        iso.put(DISP_STY_QTY_REC_COUNT_BUTTON,new qtyreccont_to_string());
        Object obj52= exgui.verification.CellFormat.getDoubleFormatAllowNull(2, 3);
        iso.put(DISP_STY_YY1,obj52);
        Object char20=exgui.verification.CellFormat.getOrdinaryField(20);
        Object char10=exgui.verification.CellFormat.getOrdinaryField(10);

//        iso.put(DISP_STY_STORE,char20);
        iso.put(DISP_STY_ORG_STYLE,char10);
    return iso;
  }

  protected PagedDataFactory getPagedDataFactory() {
    /**@todo Implement this exgui.ultratable.AbstractUltraTablePanel abstract method*/
    //throw new java.lang.UnsupportedOperationException("Method getPagedDataFactory() not yet implemented.");
    dbHandler=new newtimes.production.process.prodmaintain.DB_StyleListHandler(false);
    return dbHandler;
  }

  public void doPaste(){
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
       if (getJtable().isCellEditable(selectedRow[j], i)) {
         if(i==BUYER_LABEL_COLUMN_AT||i==BARCODE_COLUMN_AT){
           continue;
         }
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
        //System.out.println("select style at PnlStyleList is:"+rec);
      }
      util.ApplicationProperites.setProperties("PnlStyleList_beginRow_at",
                                               new Integer(parentPnl._rowPosition));
    }
  }
}
