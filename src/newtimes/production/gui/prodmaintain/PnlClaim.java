package newtimes.production.gui.prodmaintain;
import exgui.ultratable.*;
import java.util.*;
import database.datatype.*;
import java.awt.*;
import javax.swing.*;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class PnlClaim extends processhandler.template.PnlTableEditor
   implements processhandler.DataProcesser{
   static String TITLE_CASE_NO="CASE#";
   static String TITLE_STY_STYLE="STYLE#";
   static String TITLE_STYLE_PO="   PO#   ";
   static String TITLE_STYLE_SHIP_MODE="SHIP\nMODE";
   static String TITLE_STYLE_DEL_DATE="DELIVERY\nDATE";
   static String TITLE_REF_ML_DATE="Reference\nMail\nDate";
   static String TITLE_CLAIM_NO="CLAIM#";
   static String TITLE_PARTICULARS_CLAIM_POINTS="Particulars /\nClaimpoints";
   static String TITLE_RETURNED_SAMPLE_FROM_BUYER="Returned Sample\nFrom Buyer";
   static String TITLE_BUYER_ACTION_CHAGE_BACK="Buyer Action /\nChargback";
   static String TITLE_CLAIM_AMT="Claim Amount\n(USD)";
   static String TITLE_VENDOR_FEEBACK="Vendor\nFeedBack";
   static String TITLE_STATUS="Status      ";
   static String TITLE_VOUCHER_NO="Voucher#";
   static String TITLE_SETTLEMEMT_STATUS="Settlement\nStatus";
   static javax.swing.JComboBox cbxStyleRecords=null;
   static Hashtable htStySeq2StyleRec=null;
   static Vector vctStyles2select=null;
   Vector vct2Delete=null;
   boolean isChangingStyle=false;
   exgui.ultratable.PagedTablePanel pnlListStyle2Select=null;
   ScrollMenu4Styles menueSelectStyle=null;
   msOpenMenu tblClick=null;
   int editingCol=0;
   int editingRow=0;
  /*
  public PnlClaim(exgui.ultratable.PagedDataFactory pagedDataFxy,
                    int rowCounts,util.InsertionOrderedHashMap columnMapping,
                   java.util.Hashtable object2StringConvertor){
      super(pagedDataFxy, rowCounts, columnMapping, object2StringConvertor);
  }
  */
 public PnlClaim(){
   super();
   getPanelContainsButtons().removeAll();
 }
  public void doPrint(){}
  public int getEachPageRowCount(){return 9999;}
  public Hashtable getObject2StringConvertor() {
    Object dateCnvNormal= exgui.verification.CellFormat.getDateStringFormaterAllowNull();
    Object chk1000= exgui.verification.CellFormat.getOrdinaryField(1000);
    Object chk100= exgui.verification.CellFormat.getOrdinaryField(100);
    Object chk20= exgui.verification.CellFormat.getOrdinaryField(20);
    Object floatChk=exgui.verification.CellFormat.getDoubleFormatAllowNull(10,2);

     Hashtable ht=new Hashtable();
     ht.put(TITLE_CASE_NO,chk20);
     //ht.put(TITLE_STY_STYLE ,"STY_STYLE");
     //ht.put(TITLE_STYLE_PO,"STY_PO");
     //ht.put(TITLE_STYLE_SHIP_MODE,"SHIP_MODE");
     //ht.put(TITLE_STYLE_DEL_DATE,dateCnvNormal);
     ht.put(TITLE_REF_ML_DATE ,dateCnvNormal);
     ht.put(TITLE_CLAIM_NO,chk20);
     ht.put(TITLE_PARTICULARS_CLAIM_POINTS,chk1000);//chk20);
     ht.put(TITLE_RETURNED_SAMPLE_FROM_BUYER,chk1000);
     ht.put(TITLE_BUYER_ACTION_CHAGE_BACK,chk1000);
     ht.put(TITLE_CLAIM_AMT,floatChk);
     ht.put(TITLE_VENDOR_FEEBACK,chk1000);
     ht.put(TITLE_STATUS,chk1000);
     ht.put(TITLE_VOUCHER_NO,chk100);
     ht.put(TITLE_SETTLEMEMT_STATUS,chk1000);
     return ht;

  }
  public util.InsertionOrderedHashMap getHeadColumnMap(){
    util.InsertionOrderedHashMap iso=new util.InsertionOrderedHashMap();
    iso.put(TITLE_CASE_NO,"CASE_NO");
    iso.put(TITLE_STY_STYLE ,"STY_STYLE");
    iso.put(TITLE_STYLE_PO,"STY_PO");
    iso.put(TITLE_STYLE_SHIP_MODE,"SHIP_MODE");
    iso.put(TITLE_STYLE_DEL_DATE,"STY_ORIG_DEL");
    iso.put(TITLE_REF_ML_DATE ,"REF_ML_DATE");
    iso.put(TITLE_CLAIM_NO,"CLAIM_NO");
    iso.put(TITLE_PARTICULARS_CLAIM_POINTS,"PTQLR_CLM_POINT");
    iso.put(TITLE_RETURNED_SAMPLE_FROM_BUYER,"RTN_SMPL_BUYER");
    iso.put(TITLE_BUYER_ACTION_CHAGE_BACK,"BYR_AXN_CHGBK");
    iso.put(TITLE_CLAIM_AMT,"CLM_AMT");
    iso.put(TITLE_VENDOR_FEEBACK,"VNDR_FEEBACK");
    iso.put(TITLE_STATUS,"STATUS");
    iso.put(TITLE_VOUCHER_NO,"VH_NO");
    iso.put(TITLE_SETTLEMEMT_STATUS,"STTL_STATUS");
    return iso;
  }
  public void doAddNew(){}
  public void doDelete(){}
  public void doPaste(){}
  public void doExit(){
    try{
      if(!isContextModified()){
        super.doExit();
        return;
      }
      if(!exgui.verification.VerifyLib.showConfirm("Context Modified,Are You Sure Toe Exit?","Context Modified",false))return;
      super.doExit();
    }catch(Exception exp){
      exp.printStackTrace();
    }
  }
  public exgui.ultratable.PagedDataFactory getPagedDataFactory(){
    //return dbHandler;
    return new Db4Claim();
  }
  public Record setObject2Record(Record rec,int col,Object obj){
     try{
       if(col==1){
         //System.out.println("class is "+obj.getClass().getName()+" value is "+obj.toString() );
         rec.set("sty_seq",obj);
         return rec;
       }
       rec.set(storedRecordColumn[col],obj);
       return rec;
     }catch(Exception exp){
       exp.printStackTrace();
       return null;
     }
  }

  public  class StyleModifyListener implements java.awt.event.ItemListener{
   public void itemStateChanged(java.awt.event.ItemEvent ie){
      if(!isChangingStyle)return;
       int row = getJtable().getSelectedRow();
       if(row==-1)return;
       exgui.ultratable.Wraper4tblCbx objSty=(exgui.ultratable.Wraper4tblCbx)cbxStyleRecords.getSelectedItem();  //getJtable().getValueAt(row,1);
       if(objSty==null || objSty.toString().trim().equals("")){
         /*
              iso.put(TITLE_STY_STYLE ,"STY_STYLE");1
              iso.put(TITLE_STYLE_PO,"STY_PO");2
              iso.put(TITLE_STYLE_SHIP_MODE,"SHIP_MODE");3
              iso.put(TITLE_STYLE_DEL_DATE,"STY_ORIG_DEL");4
          */
         //getJtable().setValueAt(objSty,row,1);
         getJtable().setValueAt("",row,2);
         getJtable().setValueAt("",row,3);
         getJtable().setValueAt("",row,4);
         try{
           ((Record)getDisplayingRecords().get(row)).set(1, null);
           ((Record)getDisplayingRecords().get(row)).set("STY_STYLE", null);
         }catch(Exception exp){
           exp.printStackTrace();
         }
         //getJtable().repaint();
         //getJtable().validate();
       }else{
         Record recStyle=(Record)htStySeq2StyleRec.get(objSty.getValue());
         try{
           //getJtable().setValueAt(objSty,row,1);
           getJtable().setValueAt(recStyle.get("STY_PO"), row, 2);
           getJtable().setValueAt(recStyle.get("SHIP_MODE"), row, 3);
           getJtable().setValueAt(recStyle.get("STY_ORIG_DEL"), row, 4);
           getJtable().setValueAt(recStyle.get("STY_ORIG_DEL"), row, 4);
           ((Record)getDisplayingRecords().get(row)).set(1,objSty.getValue());
           getJtable().repaint();
           getJtable().validate();
         }catch(Exception exp){
           exp.printStackTrace();
         }
       }

   }
}


 public class DfxEditor4Style extends DefaultCellEditor{
   public DfxEditor4Style(JComboBox cbx){
     super(cbx);
   }
   public synchronized Component getTableCellEditorComponent(JTable table,
         Object value, boolean isSelected, int row, int column) {
     isChangingStyle=false;
     Component cmp2Return= super.getTableCellEditorComponent(table,value,isSelected,row,column);

     exgui.ultratable.Wraper4tblCbx itm2select=new exgui.ultratable.Wraper4tblCbx();
     Record rec=(Record)getDisplayingRecords().get(row);
     Object value2select=rec.get(1);
     itm2select.setValue((value2select==null)?null:value2select.toString());
     itm2select.setString((value==null)?"":value.toString());
     ((javax.swing.JComboBox)cmp2Return).setSelectedItem(itm2select);
     isChangingStyle=true;
     return cmp2Return;
   }

 }


  protected void setStyleCombox(){
    cbxStyleRecords=new JComboBox();
    cbxStyleRecords.addItemListener(new StyleModifyListener());
    //cbxStyleRecords.addPopupMenuListener(
    //);

    exgui.MultiClassTableModel dtm=(exgui.MultiClassTableModel)getJtable().getModel();
    dtm.registEditableColumn(getJtable().getColumnName(1));
    try{
      String sc_no = (String)newtimes.preproduction.Constants.
          CURRENT_PREPROD_HEAD_RECORD.get("prod_sc_no");

      StringBuffer sb=new StringBuffer();
      sb.append(" select ");
      sb.append("b.sty_seq,");
      sb.append("b.sty_style, ");
      sb.append("b.sty_po, ");
      sb.append("B.STY_TOTAL_QTY, ");
      sb.append("(select SHIP_MODE_NAME from ship_modes where SHIP_MODE_CODE=B.STY_ORIG_WAY) as ship_mode, ");
      sb.append("to_char(B.STY_ORIG_DEL,'yyyy/mm/dd') as STY_ORIG_DEL  ");
      sb.append("from style b ");
      sb.append("where ");
      sb.append(" b.sty_sc_no='");sb.append(sc_no);sb.append("'");
      Vector vct=exgui2.CONST.BASIC_MAIN_EJB.getDatas(util.PublicVariable.USER_RECORD,sb.toString(),1,99999);
      exgui.ultratable.Wraper4tblCbx styItems[]=new exgui.ultratable.Wraper4tblCbx[vct.size()+1];
      Hashtable ht=new Hashtable();
      styItems[0]=new exgui.ultratable.Wraper4tblCbx(null,"");
      for(int i=0;i<vct.size();i++){
        Record recSty=(Record)vct.get(i);
        styItems[i+1]=new exgui.ultratable.Wraper4tblCbx(recSty.get(0).toString(),(String)recSty.get(1));
        ht.put(recSty.get(0).toString(),recSty);
      }
      vctStyles2select=vct;
      if(vctStyles2select.size()>0){
        Record recBlank=(Record)util.MiscFunc.deepCopy(vctStyles2select.get(0));
        for(int i=0;i<recBlank.getFieldName().size();i++){
          recBlank.set(i,null);
        }
        vctStyles2select.add(0,recBlank);
      }
      class tempDb extends exgui.ultratable.PagedDataFactoryAdapter{
        public Vector getRecords(int gbn,int row){
          return vctStyles2select;
        }
      }
      util.InsertionOrderedHashMap iso=new util.InsertionOrderedHashMap();
      iso.put("STYLE","STY_STYLE");
      iso.put(" PO# ","STY_PO");
      iso.put("SHIP MODE","ship_mode");
      iso.put("DLV DATE","STY_ORIG_DEL");
      iso.put("QTY","STY_TOTAL_QTY");
      Hashtable ht2=new Hashtable();
      pnlListStyle2Select=
          new  exgui.ultratable.PagedTablePanel(new tempDb(),999,iso,ht2);
      htStySeq2StyleRec=ht;
      menueSelectStyle=new ScrollMenu4Styles();
      //since we use PagedPanel as selection menu,do need to add comobox.
      /*
      javax.swing.DefaultComboBoxModel mdl=new javax.swing.DefaultComboBoxModel(styItems);
      cbxStyleRecords.removeAllItems();
      cbxStyleRecords.setModel(mdl)  ;
      javax.swing.DefaultCellEditor dce=new DfxEditor4Style(cbxStyleRecords);
      dce.setClickCountToStart(0);
      getJtable().getColumnModel().getColumn(1).setCellEditor(dce);
      */
    }catch(Exception exp){
       exp.printStackTrace();
    }
  }

  public void refineEditors(exgui.ultratable.MultiEditorJTable me ){
    setStyleCombox();
    me.setTextEditorVerifiers(getObject2StringConvertor());
    if(tblClick==null){
      tblClick=new msOpenMenu();
      me.getJTable().addMouseListener(tblClick);
    }
    ((exgui.MultiClassTableModel)me.getJTable().getModel()).removeEditableColumn(TITLE_STY_STYLE);
  }
  class msOpenMenu extends java.awt.event.MouseAdapter{
    public void mouseClicked(java.awt.event.MouseEvent me){
      final int row = getJtable().rowAtPoint(me.getPoint());
      final int col  = getJtable().columnAtPoint(me.getPoint());
      //stored for future needs
      editingCol=col;
      editingRow=row;
      if ((me.getModifiers() & java.awt.event.InputEvent.BUTTON1_MASK) == java.awt.event.InputEvent.BUTTON1_MASK) {
        if(col==1){
          java.awt.Rectangle rt = getJtable().getCellRect(row, col, true);
          double posY = rt.getY() + rt.getHeight();
          menueSelectStyle.show(getJtable(), ((int)rt.getX()+15), (int)posY);
          //point to the row value co-responding the selecte style
        }
      }
      javax.swing.SwingUtilities.invokeLater(
        new Runnable() {
           public void run() {
             getJtable().changeSelection(row,col,false,false);
             Object objStySeq=((Record)getDisplayingRecords().get(editingRow)).get(1);
             //System.out.println(" sty_seq in jtable is "+objStySeq);
             if(null==objStySeq){
               //System.out.println("Matched!! set to 0th row ");
               pnlListStyle2Select.getJtable().changeSelection(0, 1, false, false);
             }else{
               for (int i = 1; i < pnlListStyle2Select.getDisplayingRecords().size(); i++) {
                 Record recTest = (Record)pnlListStyle2Select.getDisplayingRecords().get(i);
                 if (recTest.get(0).toString().equals(objStySeq.toString())) {
                   //System.out.println("Matched!! sty_seq in menu is "+recTest.get(0).toString());
                   pnlListStyle2Select.getJtable().changeSelection(i, 0, false, false);
                   break;
                 }
               }
             }

           }
        }
      );


    }
  }
  boolean chkClaimRowReady()throws Exception{
    //test if necessary column ready
     vct2Delete=new Vector();
      for(int i=0;i<getJtable().getRowCount();i++){
        //for each row,if have style# && case# && claim#,is vailid
        String caseNo=(String)getJtable().getValueAt(i,0);
        caseNo=((caseNo==null)?"":caseNo.trim());
        Object styleObj=getJtable().getValueAt(i,1);
        String styleStr=(styleObj==null)?"":styleObj.toString().trim();
        String claimNo=(String)getJtable().getValueAt(i,6);
        claimNo=((claimNo==null)?"":claimNo.trim());
        if(caseNo.equals("") && claimNo.equals("")){
          Record rec=(Record)getDisplayingRecords().get(i);
          if(rec.getInt("record_delete_flag")==1){
            //delete it.
            rec.set("record_delete_flag","0");
            rec.set("record_modify_user",util.PublicVariable.USER_RECORD.get(0));
            vct2Delete.add(rec);
            continue;
          }
          continue;
        }
        if((!caseNo.equals("")) && (!claimNo.equals(""))){
          if(styleStr.equals("")){
            exgui.verification.VerifyLib.showAlert("Pleaese Select Style  Row:"+(i+1),
                                                   "Please Select Style");
               return false;

          }
        }else{
          exgui.verification.VerifyLib.showAlert("Case#  & Claim# can not be blank \nAt Row:"+(i+1),
                                                 "Please Fill in Case#  & Claim");
             return false;
        }
      }
     return true;
  }
  public void doUpdate()throws Exception{
      if(!chkClaimRowReady())return;
      super.updateModifiedRecord();
  }
  class Db4Claim extends exgui.ultratable.PagedDataFactoryAdapter{
     Record recBlank=null;
     public Db4Claim(){
       try{
         recBlank =exgui2.CONST.BASIC_MAIN_EJB.getBlankRecord("CLAIM_tbl");
         recBlank.getFieldName().add("STY_STYLE");//add the style's related data..
         recBlank.getValueFields().add(null);
         recBlank.getFieldName().add("STY_PO");
         recBlank.getValueFields().add(null);
         recBlank.getFieldName().add("STY_TOTAL_QTY");
         recBlank.getValueFields().add(null);
         recBlank.getFieldName().add("SHIP_MODE");
         recBlank.getValueFields().add(null);
         recBlank.getFieldName().add("STY_ORIG_DEL");
         recBlank.getValueFields().add(null);
         recBlank.set("record_delete_flag","-1");//as insert flag
         recBlank.set("record_create_user",util.PublicVariable.USER_RECORD.get(0));
       }catch(Exception exp){
         exp.printStackTrace();
       }
     }
     public void updateRecords(Vector vct2upate)throws Exception{
       //add the record to delete.
       util.MiscFunc.showProcessingMessage();
       if(vct2Delete!=null){
         for(int i=0;i<vct2Delete.size();i++){
           vct2upate.add(vct2Delete.get(i));
         }
       }
       newtimesejb.TPE_MIS.TpeMisFuncHome ejbHome=
           (newtimesejb.TPE_MIS.TpeMisFuncHome)
           info_ejb.WeblogicServiceLocator.locateServiceHome(util.PublicVariable.SERVER_URL,
           "newtimesejb.TPE_MIS.TpeMisFunc");
       newtimesejb.TPE_MIS.TpeMisFunc ejbTpeMis=ejbHome.create();
       HashMap hmParam=new HashMap();
       hmParam.put("TPEMISCFUNC_ACTION_CODE","PROCESS_UPDATE_CLAIM_DATA");
       hmParam.put("VCT_UPDATE_CLAIM_DATA",vct2upate);
       hmParam.put("user_code",util.PublicVariable.USER_RECORD.get(0));
       ejbTpeMis.tpeMisFunc(hmParam);
       reload();
       getPanelContainsButtons().removeAll();
       util.MiscFunc.hideProcessingMessage();
     }
     public Vector getRecords(int gbn,int rowcount)throws Exception{
       String sc_no = (String)newtimes.preproduction.Constants.
           CURRENT_PREPROD_HEAD_RECORD.get("prod_sc_no");
        StringBuffer sb=new StringBuffer();
        sb.append(" select ");
        sb.append(" a.*, ");
        sb.append("b.sty_style, ");
        sb.append("b.sty_po, ");
        sb.append("B.STY_TOTAL_QTY, ");
        sb.append("(select SHIP_MODE_NAME from ship_modes where SHIP_MODE_CODE=B.STY_ORIG_WAY) as ship_mode, ");
        sb.append("to_char(B.STY_ORIG_DEL,'yyyy/mm/dd') as STY_ORIG_DEL  ");
        sb.append("from claim a,style b ");
        sb.append("where A.STY_SEQ=B.STY_SEQ ");
        sb.append("and b.sty_sc_no='");sb.append(sc_no);sb.append("'");
        sb.append(" and a.record_delete_flag='1' ");
        Vector vct=exgui2.CONST.BASIC_MAIN_EJB.getDatas(
         util.PublicVariable.USER_RECORD,sb.toString(),1,99999999);
        //append 20 rows
        for(int i=0;i<20;i++){
              Record recNew=(Record)util.MiscFunc.deepCopy(recBlank);
              recNew.set(0,-1*i);
              vct.add(recNew);
        }
        return vct;
     }
  }
  public class ScrollMenu4Styles extends JPopupMenu  {
    JScrollPane jScrollPane2Contain = new JScrollPane();
    //JPanel pnl2List = new JPanel();
    public ScrollMenu4Styles() {
      try {
        jbInit();
      }
      catch(Exception ex) {
        ex.printStackTrace();
      }
    }

    void jbInit() throws Exception {
      //this.getContentPane().setLayout(null);
      this.setVisible(false);
      this.setLayout(null);
      //pnl2List.setLayout(new BorderLayout());
      jScrollPane2Contain.setBounds(new Rectangle(6, 7, 479, 370));
      //this.getContentPane().add(jScrollPane2Contain, null);
      this.add(jScrollPane2Contain, null);
      pnlListStyle2Select.getJtable().addMouseListener(
         new ClickTblMenu()
      );
      jScrollPane2Contain.getViewport().add(pnlListStyle2Select.getJtable(), null);
      this.setPreferredSize(new Dimension(350, (vctStyles2select.size()+2)*20));
    }
    class ClickTblMenu extends java.awt.event.MouseAdapter{
       public void mouseClicked(java.awt.event.MouseEvent me){
          int row =pnlListStyle2Select.getJtable().rowAtPoint(me.getPoint());
          //int col  =pnlListStyle2Select.getJtable().columnAtPoint(me.getPoint());
          Record recStyle=(Record)pnlListStyle2Select.getDisplayingRecords().get(row);
          ((Record)getDisplayingRecords().get(editingRow)).set(1,recStyle.get(0));
          //System.out.println("set stye seq to row -->"+editingRow+" ,sty_seq-->"+recStyle.get(0));
          getJtable().setValueAt(recStyle.get(1), editingRow, 1);
          getJtable().setValueAt(recStyle.get(2), editingRow, 2);
          getJtable().setValueAt(recStyle.get(4), editingRow, 3);
          getJtable().setValueAt(recStyle.get(5), editingRow, 4);
          //getJtable().setValueAt(recStyle.get(3), editingRow, 6);
          menueSelectStyle.setVisible(false);
       }
    }

  }

}
