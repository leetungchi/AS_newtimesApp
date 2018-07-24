package newtimes.shipping_admin.process.shiippingmaintain;
import javax.swing.JLabel;
import database.datatype.Record;
import java.awt.event.*;
import exgui.ultratable.PagedDataFactory;
import processhandler.template.*;
import java.awt.*;
import database.datatype.Record;
import java.util.*;
import javax.swing.table.*;

public class ToListAddedStyles implements AbleToListAddedStyles{
  protected HashMap conditions;
  static protected util.InsertionOrderedHashMap columnNameMap=null;
  static final String BUYER="   Buyer"  ;
  static final String FTY = "  Maker  ";
  static  String SC_NO = "    S/C NO.    ";
  static final String SC_NO_NTFE="S/C NO.";
  static final String STYLE = "   Style  ";
  static final String PO = "  PO   ";
  static final String UNIT = "Unit";
  static final String O_QTY = "Order\nQty";
  static final String S_QTY = "Ship\nQty";
  static public int PAGE_BEGIN=0;
  DummyEditor dummyEditor=null;
  InnerPnlListAddedStyles pnl;
  public ToListAddedStyles() {
    columnNameMap=new util.InsertionOrderedHashMap();
    columnNameMap.put(BUYER,"BUYER");
    columnNameMap.put(FTY, "maker");


    if(!util.PublicVariable.OPERATTING_CENTER.equals("001")){
     SC_NO="S/C NO.";
    }else{
     SC_NO = "    S/C NO.    ";
    }
    columnNameMap.put(SC_NO, "SC_NO");
    columnNameMap.put(STYLE, "sty_STYLE");
    columnNameMap.put(PO, "sty_PO");
    columnNameMap.put(UNIT, "sty_UNIT");
    //columnNameMap.put(O_QTY, "order_qty");
    //columnNameMap.put(S_QTY, "shipped_qty");
    columnNameMap.put("BUYER\nCOMMISION","buy_comm_str");
    columnNameMap.put("MAKER\nDISCOUNT","maker_disc_str");
  }
  public util.InsertionOrderedHashMap getHeadColumns(){
    try{
      return (util.InsertionOrderedHashMap)util.MiscFunc.deepCopy(columnNameMap);
    }catch(Exception e){
      e.printStackTrace();
      return null;
    }
  }
   class DummyEditor extends newtimes.shipping_admin.guis.shippingmaintain.PnlListStyles2Edit  {

    public boolean isContextModified(){return false;}
    public void doAddNew(){
      try{
        newtimes.shipping_admin.ShippingAdmin_Const.pnlQryStylesByScPo=null;
        if(pnl.pgTblList.getDisplayingRecords()==null || pnl.pgTblList.getDisplayingRecords().size()==0){
          //find out the inital s/c of current SRN
          String srn=newtimes.shipping_admin.ShippingAdmin_Const.CURRENT_EDITING_SHIP_SRN;
          StringBuffer sb=new StringBuffer();
          sb.append("select prod_sc_no,");
          sb.append("(select sty_style from style where style.prod_head_pk=production.prod_head_pk and record_delete_flag='1' and rownum='1' ) as def_style,");
          sb.append("(select sty_po from style where style.prod_head_pk=production.prod_head_pk and record_delete_flag='1' and rownum='1' ) as def_po,");
          sb.append(" prod_byr_sc_no ");
          sb.append(" from production where prod_head_pk=");
          sb.append("(select prod_head_pk from ship_sc where ");
          sb.append("SHIP_NO='");
          sb.append(srn);
          sb.append("' and record_delete_flag='1' and rownum=1)");
          java.util.Vector vct=exgui2.CONST.BASIC_MAIN_EJB.getDatas(
           util.PublicVariable.USER_RECORD,
           sb.toString(),1,99999);
           if(vct.size()>0){
             Record recSCno=(Record)vct.get(0);
             newtimes.shipping_admin.guis.shippingmaintain.PnlQryStyles2AddByScPo.defaultScNo =(String)recSCno.get(0);
             newtimes.shipping_admin.guis.shippingmaintain.PnlQryStyles2AddByScPo.defaultStyleName =(String)recSCno.get(1);
             newtimes.shipping_admin.guis.shippingmaintain.PnlQryStyles2AddByScPo.defaultStylePo =
                 (String)((recSCno.get(2)==null)?recSCno.get(3):recSCno.get(2));
           }
        }else{
          newtimes.shipping_admin.guis.shippingmaintain.PnlQryStyles2AddByScPo.defaultScNo=null;
          newtimes.shipping_admin.guis.shippingmaintain.PnlQryStyles2AddByScPo.defaultStyleName =null;
          newtimes.shipping_admin.guis.shippingmaintain.PnlQryStyles2AddByScPo.defaultStylePo =null;

        }
        super.doAddNew();
      }catch(Exception exp){
        exp.printStackTrace();
        util.ExceptionLog.exp2File(exp,"");
      }
    }
  }
  public void toListAddedStyles(){
    try{
      newtimes.shipping_admin.ShippingAdmin_Const.hmPoStyleMap2ShipStyle=null;

      newtimes.shipping_admin.ShipPrxQty.PnlCplxShipStylePW.memory_inv_desc_context="";
      newtimes.production.ProdMaintain_Properties.setWaitCursor();
      javax.swing.JFrame jframe = processhandler.template.Properties.
          getMainFrame();
     if(dummyEditor==null)dummyEditor=new DummyEditor();
      pnl=new InnerPnlListAddedStyles(
           new newtimes.shipping_admin.process.shiippingmaintain.DB_AddedShipStyle(),
           13,getHeadColumns(),new java.util.Hashtable(),
           "View\nShipping","   ...   ",
           "View\nPacking","   ...   ");
      jframe.getContentPane().removeAll();
      pnl.setBounds(0,0,775,680);
      newtimes.shipping_admin.PnlBaseContainer pnlFunc =
          new newtimes.shipping_admin.PnlBaseContainer("Shipp Styles Of Shipping :"+newtimes.shipping_admin.ShippingAdmin_Const.CURRENT_EDITING_SHIP_SRN+" Click To Edit");
      newtimes.shipping_admin.ShippingAdmin_Const.SHIPPING_EDIT_PANEL=pnlFunc;
      if(!newtimes.shipping_admin.ShippingAdmin_Const.isShipClosed()){
        pnlFunc.setButtons(true, false, false, false, false);
      }else{
        pnlFunc.setButtons(false, false, false, false, false);
      }
      pnlFunc.removalAddExtralButtons();
      //if have any shipped row,have to provide the function to report unitl
      if(pnl.getDisplayingRecords().size()>0){
        if (!util.PublicVariable.OPERATTING_CENTER.equals("NTHK") &&
            !util.PublicVariable.OPERATTING_CENTER.equals("001")) {

          pnlFunc.addTriggerButton("To Enquiry",
                                   new newtimes.shipping_admin.process.
                                   shiippingmaintain.TgrToQryShipMaster());

          pnlFunc.addTriggerButton("PRINT SRN",
                                   new newtimes.shipping_admin.process.
                                   shiippingmaintain.TgrToReportUnit()
                                   );
        }
      }


      //pnlFunc.setPreferredSize(new java.awt.Dimension(800,590));
      jframe.getContentPane().add(pnlFunc,null);
      pnlFunc.setEditPanel(dummyEditor);
      pnlFunc.setEditPanel(pnl);
      //pnlFunc.validate();
      //pnlFunc.repaint();
      pnl.setPreferredSize(new java.awt.Dimension(775, 400));
      pnl.repaint();
      pnl.validate();
      pnlFunc.setBounds(0, 0, 790, 580);
      pnlFunc.repaint();
      pnlFunc.validate();
      jframe.repaint();
      jframe.validate();
    }catch(Exception e){
       e.printStackTrace();
    }finally{
      newtimes.production.ProdMaintain_Properties.setNormalCursor();
    }

  }
  public class InnerPnlListAddedStyles extends processhandler.template.PnlListQryRslt
   implements  exgui.ultratable.MakeTableNotify  {
   PagedDataFactory    myHandler;
   String orgTitleString=null;
   String orgButtonString=null;
   int orgRowCount=0;
   util.InsertionOrderedHashMap orgInsColumns=null;
   boolean isShowingSummed=false;
   int curr_top_row_at=0;
   JLabel lblNetAmount = new JLabel();
   boolean isShowingQtys=false;

  public InnerPnlListAddedStyles(PagedDataFactory pagedDataFxy,
        int rowCount,util.InsertionOrderedHashMap columnMapping,
        java.util.Hashtable object2StringConvertor
    ){
     super(pagedDataFxy,rowCount,columnMapping,object2StringConvertor);
     this.removeAll();
     this.add(this.pgTblList,BorderLayout.CENTER);
     this.pgTblList.setMakeTableNotifier(this);
     myHandler=pagedDataFxy;
  }

  public InnerPnlListAddedStyles(PagedDataFactory pagedDataFxy,
        int rowCount,util.InsertionOrderedHashMap columnMapping,
        java.util.Hashtable object2StringConvertor,
        String titleStr1,String btnStr1,
        String titleStr2,String btnStr2
    ){
     super(pagedDataFxy,
           rowCount,
           columnMapping,
           object2StringConvertor,
           titleStr1+PnlListQryRslt.EDITABLE_COLUMN_NAME_SPLITER+titleStr2,
           btnStr1+PnlListQryRslt.EDITABLE_COLUMN_NAME_SPLITER+btnStr2
           );
     myHandler=pagedDataFxy;
     orgTitleString=titleStr1+PnlListQryRslt.EDITABLE_COLUMN_NAME_SPLITER+titleStr2;
     orgButtonString=btnStr1+PnlListQryRslt.EDITABLE_COLUMN_NAME_SPLITER+btnStr2;
     orgRowCount=rowCount;
     orgInsColumns=columnMapping;
     this.removeAll();
     //this.add(new JLabel("Please click the rows"),BorderLayout.NORTH);
     add(this.pgTblList,BorderLayout.CENTER);
     this.pgTblList.setMakeTableNotifier(this);
     //initWithTotalAmount();
     lblNetAmount.setVisible(false);
     pgTblList.getLowerRightPanel().add(lblNetAmount);
     addQtyColumns();

     /*
     javax.swing.JButton btn=new javax.swing.JButton("show QTY");
     pgTblList.getLowerRightPanel().add(btn);
     btn.addMouseListener(
        new java.awt.event.MouseAdapter(){
           public void mouseClicked(java.awt.event.MouseEvent me){
             addQtyColumns();
          }
        }
      );*/
   }
    public Vector getDisplayingRecords(){
      return pgTblList.getDisplayingRecords();
    }
    protected void showQtys(){
      try{
        Vector vct = pgTblList.getDisplayingRecords();
        int vctSize = vct.size();
        StringBuffer getQtydataSqlSb = new StringBuffer();
        for (int i = 0; i < vctSize; i++) {
          Record rec = (Record)vct.get(i);
          if (i == 0) {
            getQtydataSqlSb.append("select ");
          }
          getQtydataSqlSb.append("GET_SHIPPED_STYLE_QTY(");
          getQtydataSqlSb.append(rec.get(0).toString());
          getQtydataSqlSb.append("),GET_ORDER_ALLSTATUS_QTY(");
          getQtydataSqlSb.append(rec.get(2).toString());
          getQtydataSqlSb.append("),");
        }
        getQtydataSqlSb.append("1 from dual");
        Record qtyData = (Record)exgui2.CONST.BASIC_MAIN_EJB.getDatas(
            util.PublicVariable.USER_RECORD,
            getQtydataSqlSb.toString(), 1, 99999).get(0);
        for (int i = 0; i < vctSize; i++) {
          Object objGET_SHIPPED_STYLE_QTY = qtyData.get(i * 2);
          Object objGET_ORDER_ALLSTATUS_QTY = qtyData.get((i * 2) + 1);
          pgTblList.getJtable().setValueAt(objGET_SHIPPED_STYLE_QTY, i, 7);
          pgTblList.getJtable().setValueAt(objGET_ORDER_ALLSTATUS_QTY, i, 6);
        }
      }catch(Exception exp){
        exp.printStackTrace();
        util.ExceptionLog.exp2File(exp,"");
        exgui.verification.VerifyLib.showAlert("Error While Get Details Of Shipping/Order Qty ",
                                               "Error While Get Details Of Shipping/Order Qty ");
      }

    }
    public void addQtyColumns(){
      if(pgTblList.getDisplayingRecords()==null || pgTblList.getDisplayingRecords().size()==0)return;
      util.InsertionOrderedHashMap iso=new util.InsertionOrderedHashMap();
      iso.put(BUYER,"BUYER");
      iso.put(FTY, "maker");
      iso.put(SC_NO, "SC_NO");
      iso.put(STYLE, "sty_STYLE");
      iso.put(PO, "sty_PO");
      iso.put(UNIT, "sty_UNIT");
      iso.put(O_QTY, "order_qty");//6
      iso.put(S_QTY, "shipped_qty");//7
      iso.put("BUYER\nCOMMISION","buy_comm_str");
      iso.put("MAKER\nDISCOUNT","maker_disc_str");
      isShowingQtys=true;
      pgTblList.setHeadColumnMap(iso);
      pgTblList.toAddButtonFiled(orgTitleString,orgButtonString);
      pgTblList.gotoRowPosition(pgTblList._rowPosition);
      util.MiscFunc.showProcessingMessage();
      showQtys();
      initWithTotalAmount();
      util.MiscFunc.hideProcessingMessage();

      util.InsertionOrderedHashMap isos=new util.InsertionOrderedHashMap();
      isos.put(BUYER,"BUYER");
      isos.put(FTY, "maker");
      isos.put(SC_NO, "SC_NO");
      isos.put(STYLE, "sty_STYLE");
      isos.put(PO, "sty_PO");
      isos.put(UNIT, "sty_UNIT");
      isos.put("BUYER\nCOMMISION","buy_comm_str");
      isos.put("MAKER\nDISCOUNT","maker_disc_str");
      pgTblList.setHeadColumnMap(isos);
      pgTblList.toAddButtonFiled(orgTitleString,orgButtonString);
      isShowingQtys=false;
      //isShowingSummed=false;
    }


  public void makeTable001(java.util.Vector vct){
  if(vct==null||vct.size()==0)return;
  if(util.PublicVariable.OPERATTING_CENTER.equals("001") &&
     (util.PublicVariable.USER_RECORD.getInt(2)==newtimesejb.preproduction.PreProductionHead.USER_TYPE_ACCOUNTING_USERS||
      util.PublicVariable.USER_RECORD.getInt(2)==newtimesejb.preproduction.PreProductionHead.USER_TYPE_SUPERVIOSER_MIS)){
    try{
      StringBuffer sb=new StringBuffer();
      java.util.HashMap hmHaveKey=new java.util.HashMap();
      for(int i=0;i<vct.size();i++){
        Record rec=(Record)vct.get(i);
        String scNo=(String)rec.get("sc_no");
        if(!hmHaveKey.containsKey(scNo)){
          hmHaveKey.put(scNo,scNo);
          if(sb.length()>0)sb.append(",");
          sb.append("'");
          sb.append(scNo);
          sb.append("'");
        }
      }
      StringBuffer sql=new StringBuffer();
      sql.append("select ");
      sql.append("a.prod_sc_no, ");
      sql.append("b.prod_is_sample ");
      sql.append("from production a,prod_head b ");
      sql.append("where a.prod_head_pk=b.prod_head_pk ");
      sql.append("and a.prod_sc_no in (");
      sql.append(sb.toString());sql.append(")");

      java.util.Vector vctTest=exgui2.CONST.BASIC_MAIN_EJB.getDatas(
         util.PublicVariable.USER_RECORD,
         sql.toString(),1,999999);
       hmHaveKey.clear();
       for(int i=0;i<vctTest.size();i++){
         Record rec=(Record)vctTest.get(i);
         hmHaveKey.put(rec.get(0),rec.get(1).toString());
       }
       java.util.Vector vctBackUp=(java.util.Vector)util.MiscFunc.deepCopy(vct);
       vct.clear();
       for(int i=0;i<vctBackUp.size();i++){
         Record rec=(Record)util.MiscFunc.deepCopy(vctBackUp.get(i));
         rec.getFieldName().add("PROD_IS_SAMPLE");
         rec.getValueFields().add(hmHaveKey.get(rec.get("sc_no")));
         vct.add(rec);
       }


    }catch(Exception exp){
      exp.printStackTrace();
    }



    Renderer4TestSmpl rnd4Smpl=new Renderer4TestSmpl();
    pgTblList.getJtable().getColumnModel().getColumn(2).setCellRenderer(rnd4Smpl);
  }
}
public class Renderer4TestSmpl extends javax.swing.JLabel
  implements javax.swing.table.TableCellRenderer{
  public Renderer4TestSmpl(){
  super();
 setOpaque(true); /* it\u00B4s essential */
}

public java.awt.Component getTableCellRendererComponent(
     javax.swing.JTable table, Object value,
     boolean isSelected, boolean hasFocus,
     int row, int column){
      String text = (value==null)?"":value.toString();
     //testing if fab comm n reason is "N" and "fab_comm is count is zero
   try{
     Record rec = (Record)getDisplayingRecords().get(row);
     String smplCount=(String)rec.get("prod_is_sample");
     if ("Y".equals(smplCount)) {
       setBackground(new java.awt.Color(160, 160, 255)); // Decides the color
       StringBuffer sb=new StringBuffer();
         sb.append("<html><body>");
         sb.append("This SC is Sample PO");
         sb.append("</body></html>");
       setToolTipText(sb.toString());
     } else {
       setBackground(new java.awt.Color(0xFF, 0xFF, 0xFF)); // Decides the color
       setToolTipText("");
     }
   }catch(Exception epxp){
     epxp.printStackTrace();

   }

    setText(text); /* Put the current text in the JLabel */
 return this;
}
}


    public void MakingTable(Vector vct){
      if(!isShowingQtys){
        addQtyColumns();
        isShowingQtys=true;
        setColumnWidth();
        isShowingQtys=false;
        return;
      }
      setColumnWidth();
      //have to hi-lite row if edited

       //newtimes.shipping_admin.ShippingAdmin_Const.EDIT_SHIP_STYLE_SEQ_INT
       for(int i=0;i<vct.size();i++){
         Record recTmp=(Record)vct.get(i);
         if(recTmp.getInt(0)==newtimes.shipping_admin.ShippingAdmin_Const.EDIT_SHIP_STYLE_SEQ_INT){
           //System.out.print("row selected at:"+i);
           getInsideJtable().changeSelection(i,0,false,false);
           break;
         }
       }
       makeTable001(vct);
    }

    protected void setColumnWidth(){
      //always show qty.
      if(!isShowingQtys){
        getInsideJtable().getColumnModel().getColumn(4).setPreferredWidth(93); //PO
        getInsideJtable().getColumnModel().getColumn(5).setPreferredWidth(30); //unit
        //getInsideJtable().getColumnModel().getColumn(6).setPreferredWidth(40); //order qty
        //getInsideJtable().getColumnModel().getColumn(7).setPreferredWidth(40); //ship qty
        getInsideJtable().getColumnModel().getColumn(6).setPreferredWidth(64); //buyer comm
        getInsideJtable().getColumnModel().getColumn(7).setPreferredWidth(56); //maker dicount
        getInsideJtable().getColumnModel().getColumn(8).setPreferredWidth(55); //view ship data "..." button
        getInsideJtable().getColumnModel().getColumn(9).setPreferredWidth(55); //view packing data "..." button
      }else{
        if(util.PublicVariable.OPERATTING_CENTER.equals("001")){
          getInsideJtable().getColumnModel().getColumn(4).setPreferredWidth(93); //PO
          getInsideJtable().getColumnModel().getColumn(5).setPreferredWidth(30); //unit
          getInsideJtable().getColumnModel().getColumn(6).setPreferredWidth(40); //order qty
          getInsideJtable().getColumnModel().getColumn(7).setPreferredWidth(40); //ship qty
          getInsideJtable().getColumnModel().getColumn(8).setPreferredWidth(64); //buyer comm
          getInsideJtable().getColumnModel().getColumn(9).setPreferredWidth(56); //maker dicount
          getInsideJtable().getColumnModel().getColumn(10).setPreferredWidth(55); //view ship data "..." button
          getInsideJtable().getColumnModel().getColumn(11).setPreferredWidth(55); //view packing data "..." button
        }else{
          getInsideJtable().getColumnModel().getColumn(0).setPreferredWidth(55); //BUYER
          getInsideJtable().getColumnModel().getColumn(1).setPreferredWidth(55); //MAKER
          getInsideJtable().getColumnModel().getColumn(2).setPreferredWidth(60); //S/C
          getInsideJtable().getColumnModel().getColumn(3).setPreferredWidth(160); //STYLE
          getInsideJtable().getColumnModel().getColumn(4).setPreferredWidth(85); //PO
          getInsideJtable().getColumnModel().getColumn(5).setPreferredWidth(30); //unit
          getInsideJtable().getColumnModel().getColumn(6).setPreferredWidth(40); //order qty
          getInsideJtable().getColumnModel().getColumn(7).setPreferredWidth(40); //ship qty
          getInsideJtable().getColumnModel().getColumn(8).setPreferredWidth(64); //buyer comm
          getInsideJtable().getColumnModel().getColumn(9).setPreferredWidth(56); //maker dicount
          getInsideJtable().getColumnModel().getColumn(10).setPreferredWidth(55); //view ship data "..." button
          getInsideJtable().getColumnModel().getColumn(11).setPreferredWidth(55); //view packing data "..." button

        }
      }
    }
  protected void setPagedTable(){
   //flip page to system properties.--Constants.XNT_LIST_QRY_RESLUT_BGN_AT;
   //System.out.println("current properties name or top_record_at"+this.getClass().getName()+"_TOP_RECORD_AT");
   int topRecAt=1;
   if(util.ApplicationProperites.getProperties(
       this.getClass().getName()+"_TOP_RECORD_AT")!=null){
     topRecAt = (
         (Integer) util.ApplicationProperites.getProperties(
         this.getClass().getName()+"_TOP_RECORD_AT")).intValue();
    //  System.out.println("pgTblList._rowPosition restored ,valuse is:" + topRecAt);
     }else{
      util.ApplicationProperites.setProperties(this.getClass().getName()+"_TOP_RECORD_AT",new Integer(1));
      topRecAt=1;
    }
    if(PAGE_BEGIN==0){
      topRecAt=1;
    }

    super.setPagedTable();
    setColumnWidth();

  }
  protected void initWithTotalAmount(){
    try{
      if(isShowingSummed)return;
      isShowingSummed=true;
      ShippingAdmin.SRN_Style.ShipExtraFacadeHome shipXtrFacadeHome =
          (ShippingAdmin.SRN_Style.ShipExtraFacadeHome)
          info_ejb.WeblogicServiceLocator.locateServiceHome(
          util.PublicVariable.SERVER_URL,
          "ShippingAdmin.SRN_Style.ShipExtraFacade");
      ShippingAdmin.SRN_Style.ShipExtraFacade shipXtrFacade =
          shipXtrFacadeHome.create();

      Record recTmpAmt = shipXtrFacade.Total_Net_Amt(
          newtimes.shipping_admin.ShippingAdmin_Const.
          CURRENT_EDITING_SHIP_SRN);

      Object objTotalAmt = recTmpAmt.get(0);
      Object objTotalAmtDocPrx = recTmpAmt.get(1);
      StringBuffer sb = new StringBuffer();
      sb.append("TOTAL NET AMOUNT ");
      sb.append("BYR ACT:");

      if (objTotalAmt == null)
        sb.append("0");
      else
        sb.append(objTotalAmt.toString());
      sb.append(" DOC:");
      if (objTotalAmtDocPrx == null)
        sb.append("0");
      else
        sb.append(objTotalAmtDocPrx.toString());
      String srn =  newtimes.shipping_admin.ShippingAdmin_Const.CURRENT_EDITING_SHIP_SRN;

      Record mkramt =(Record)exgui2.CONST.BASIC_MAIN_EJB.getDatas(
           util.PublicVariable.USER_RECORD,
           "select get_srn_mkr_act_amt('"+srn+"'),get_srn_mkr_doc_amt('"+srn+"') from dual",1,1).get(0);
     sb.append(" / MKR ACT:");
     if (mkramt.get(0) == null)
       sb.append("0");
     else
       sb.append(mkramt.get(0).toString());
      sb.append(" DOC:");
      if (mkramt.get(1) == null)
       sb.append("0");
     else
       sb.append(mkramt.get(1).toString());

      lblNetAmount.setText(sb.toString());
      lblNetAmount.setVisible(true);
    }catch(Exception exp){
      exp.printStackTrace();
      util.ExceptionLog.exp2File(exp,"");
    }

  }
  protected void ini4NextPage(Record rec)throws Exception{
    util.ApplicationProperites.setProperties(
        this.getClass().getName()+"_TOP_RECORD_AT",new Integer(pgTblList._rowPosition));
       PAGE_BEGIN=pgTblList._rowPosition;
      newtimes.shipping_admin.ShippingAdmin_Const.EDIT_SHIP_STYLE_SEQ_INT = rec.getInt("ship_style_pk");//editing function
        newtimes.shipping_admin.ShippingAdmin_Const.EDIT_SHIP_STYLE_STYLE_INT_SEQ =rec.getInt("sty_seq");
  }
  public void gridTableMouseEventHandler(MouseEvent e) {
    //find out the click row,and activate the edit new ship style record command.
   if(pgTblList.getJtable().getSelectedRow()==-1)return;
   Record rec=(Record)pgTblList.getDisplayingRecords().get(pgTblList.getJtable().getSelectedRow());
   int columnAt=pgTblList.getJtable().getSelectedColumn();
    try {
      /*
      if(columnAt==pgTblList.getJtable().getColumnCount()-2||columnAt==pgTblList.getJtable().getColumnCount()-1){
        if (newtimes.shipping_admin.ShippingAdmin_Const.isShipClosed()) {
          exgui.verification.VerifyLib.showAlert(
              "Sorry,SRN CLOSED,Can Not Edit ANY MORE",
              "SRN CLOSED");
          return;
        }
      }
      */
     if(columnAt==pgTblList.getJtable().getColumnCount()-2){
       String ship_packing_mode=(String)rec.get("ship_packing_mode");
       if(ship_packing_mode!=null && ship_packing_mode.equals("S")){
         newtimes.shipping_admin.guis.shippingmaintain.PnlEditShipStyle.isEditingShipQty=true;
       }else{
         newtimes.shipping_admin.guis.shippingmaintain.PnlEditShipStyle.isEditingShipQty=false;
       }
       newtimes.production.ProdMaintain_Properties.setWaitCursor();
           ini4NextPage(rec);


           //newtimes.shipping_admin.ShipPrxQty.PnlCplxShipStylePW.CUST_PO=(String)rec.get("STY_PO");
           processhandler.template.Properties.getCenteralControler().doCommandExecute(
              new newtimes.shipping_admin.process.shiippingmaintain.TgrToEditAddedStyle(rec));
     }else  if(columnAt==pgTblList.getJtable().getColumnCount()-1){
        //if this ship record is
        String ship_packing_mode=(String)rec.get("ship_packing_mode");
       if(ship_packing_mode!=null && ship_packing_mode.equals("S")){
         exgui.verification.VerifyLib.showAlert("Sorry,This Record is Shipping Style,No Packing Data",
                                                "Sorry,No Packing Data For This Ship Style");
         return;
       }
       util.MiscFunc.showProcessingMessage();
       newtimes.production.ProdMaintain_Properties.setWaitCursor();
         ini4NextPage(rec);
         processhandler.template.Properties.getCenteralControler().setSystemCommander(
            newtimes.shipping_admin.ShippingAdmin_Const.SHIPPING_PACKING_COMMAND
         );
         Record recShipStyle=(Record)exgui2.CONST.BASIC_MAIN_EJB.getDatas(
          util.PublicVariable.USER_RECORD,
          "select * from ship_style where ship_style_pk="+rec.getInt("ship_style_pk"),1,1).get(0);
          newtimes.shipping_admin.process.packing.TgrToEditPackingStyle tgr=
                  new newtimes.shipping_admin.process.packing.TgrToEditPackingStyle(rec);
          tgr.setPackingRecord(recShipStyle);
          processhandler.template.Properties.getCenteralControler().doCommandExecute(tgr);
     }
    } catch (Exception exp) {
        exp.printStackTrace();
    }finally{
      util.MiscFunc.hideProcessingMessage();
      newtimes.production.ProdMaintain_Properties.setNormalCursor();

    }

   }

}

}
