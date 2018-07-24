package newtimes.preproduction.guis;
import processhandler.template.PnlListQryRslt;
import exgui.ultratable.*;
import newtimes.preproduction.process.DB_Preprod;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import database.datatype.Record;
import exgui.ultratable.*;
import java.util.Vector;
import exgui.MultiClassTableModel;
import java.io.*;
import processhandler.template.*;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class PnlListQryPprod extends PnlListQryRslt implements exgui.ultratable.MakeTableNotify {
  protected DB_Preprod myHander;
  boolean isTpeUser=true;
  MnuItem_OrderChange mnuItemOrderChange=new MnuItem_OrderChange("Order Change");
  OrderChagnePopupMenu mouseRightMenu=new OrderChagnePopupMenu();
  public PnlListQryPprod(DB_Preprod pagedDataFxy,
        int rowCount,util.InsertionOrderedHashMap columnMapping,
        java.util.Hashtable object2StringConvertor
    ){
     super(pagedDataFxy,rowCount,columnMapping,object2StringConvertor);
     myHander=pagedDataFxy;
     if(!util.PublicVariable.OPERATTING_CENTER.equals("001")){
        isTpeUser=false;
     }

     this.removeAll();
     this.add(new JLabel("Please click the rows"),BorderLayout.NORTH);
     this.add(this.pgTblList,BorderLayout.CENTER);
     this.pgTblList.setMakeTableNotifier(this);
     this.MakingTable(null);
     //this.pgTblList.firstPage();
  }
  public PnlListQryPprod(DB_Preprod pagedDataFxy,
        int rowCount,util.InsertionOrderedHashMap columnMapping,
        java.util.Hashtable object2StringConvertor,
        String titleStr1,String btnStr1,
        String titleStr2,String btnStr2,
        String titleStr3,String btnStr3,
        String titleStr4,String btnStr4
    ){
     super(pagedDataFxy,
           rowCount,
           columnMapping,
           object2StringConvertor,
           titleStr1+PnlListQryRslt.EDITABLE_COLUMN_NAME_SPLITER+titleStr2+
           PnlListQryRslt.EDITABLE_COLUMN_NAME_SPLITER+titleStr3+
           PnlListQryRslt.EDITABLE_COLUMN_NAME_SPLITER+titleStr4,
           btnStr1+PnlListQryRslt.EDITABLE_COLUMN_NAME_SPLITER+btnStr2+
           PnlListQryRslt.EDITABLE_COLUMN_NAME_SPLITER+btnStr3+
           PnlListQryRslt.EDITABLE_COLUMN_NAME_SPLITER+btnStr4
           );
     if(!util.PublicVariable.OPERATTING_CENTER.equals("001")){
       isTpeUser=false;
     }

     myHander=pagedDataFxy;
     this.removeAll();
     this.add(new JLabel("Please click the rows"),BorderLayout.NORTH);
     this.add(this.pgTblList,BorderLayout.CENTER);
     this.pgTblList.setMakeTableNotifier(this);
     this.MakingTable(null);

     //this.pgTblList.reload();
  }
  public void MakingTable(Vector vct){
    //adjust the table column of size
    if(isTpeUser){
      getInsideJtable().getColumnModel().getColumn(3).setPreferredWidth(69); //division
      getInsideJtable().getColumnModel().getColumn(6).setPreferredWidth(53); //prod ref no.
      getInsideJtable().getColumnModel().getColumn(7).setPreferredWidth(52); //edit style
      getInsideJtable().getColumnModel().getColumn(8).setPreferredWidth(59); //edit prod head
      getInsideJtable().getColumnModel().getColumn(9).setPreferredWidth(63); //order print
      getInsideJtable().getColumnModel().getColumn(10).setPreferredWidth(56); //view shipping data
    }else{
      getInsideJtable().getColumnModel().getColumn(1).setPreferredWidth(53); //buyer
      getInsideJtable().getColumnModel().getColumn(2).setPreferredWidth(53); //maker
      getInsideJtable().getColumnModel().getColumn(3).setPreferredWidth(55); //division
      getInsideJtable().getColumnModel().getColumn(4).setPreferredWidth(53); //S/C No.
      // cell 5,group name /group No.keep current width
      getInsideJtable().getColumnModel().getColumn(6).setPreferredWidth(53); //prod ref no.
      getInsideJtable().getColumnModel().getColumn(7).setPreferredWidth(52); //edit style
      getInsideJtable().getColumnModel().getColumn(8).setPreferredWidth(55); //edit prod head
      getInsideJtable().getColumnModel().getColumn(9).setPreferredWidth(59); //order print
      getInsideJtable().getColumnModel().getColumn(10).setPreferredWidth(51); //view shipping data
    }

       //System.out.println("makeing table,rendering now");
       //only tpe cetner need the fab comm n type reason check and display in tool tip.
       if(util.PublicVariable.OPERATTING_CENTER.equals("001") &&
          (util.PublicVariable.USER_RECORD.getInt(2)==newtimesejb.preproduction.PreProductionHead.USER_TYPE_ACCOUNTING_USERS||
           util.PublicVariable.USER_RECORD.getInt(2)==newtimesejb.preproduction.PreProductionHead.USER_TYPE_SUPERVIOSER_MIS)){
         MyRenderer myder = new MyRenderer();
         pgTblList.getJtable().getColumnModel().getColumn(4).setCellRenderer(myder);
       }

    if(vct==null)return;
  }
 class OrderChagnePopupMenu  extends JPopupMenu implements java.awt.event.ActionListener{
    OrderChagnePopupMenu(){
      super();
      mnuItemOrderChange.addActionListener(this);
      add(mnuItemOrderChange);
    }
    public void show(java.awt.Component cmp, int x,int y){
      if(getInsideJtable().getSelectedColumn() > 6){
        return;
      }
      super.show(cmp,x,y);
    }
    public void actionPerformed(java.awt.event.ActionEvent ae){
      System.out.println("");
      mnuItemOrderChange.mouseClicked(null);
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
       //testing if fab comm n reason is "N" and "fab_comm is count is zero
     try{
       Record rec = (Record)pgTblList.getDisplayingRecords().get(row);
       Object objAuditStatus=rec.get("PRODUCTION_AUDIT_STATUS");
       int auditStatus=(objAuditStatus==null)?0:Integer.parseInt(objAuditStatus.toString());

       if (auditStatus==
           newtimesejb.preproduction.PreProductionHead.AUDIT_STATUS_SHIPPED) {
         setBackground(new java.awt.Color(160, 160, 255)); // Decides the color
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
class MnuItem_OrderChange
    extends javax.swing.JMenuItem
    implements java.awt.event.MouseListener {
  MnuItem_OrderChange(String title){
    super(title);
  }
  public void mouseClicked(java.awt.event.MouseEvent me){
    actionPerformed(null);
  }
  public void mousePressed(java.awt.event.MouseEvent me){}
  public void mouseReleased(java.awt.event.MouseEvent me){}
  public void mouseEntered(java.awt.event.MouseEvent me){}
  public void mouseExited(java.awt.event.MouseEvent me){}
  public void actionPerformed(java.awt.event.ActionEvent ae){
    try{
      java.util.HashMap hmBuyerMaker=readyToEditRecord();
      String orgBuyer=(String)hmBuyerMaker.get("orgBuyer");
      String orgMaker=(String)hmBuyerMaker.get("orgMaker");
      newtimes.preproduction.guis.tempProperties.orgProdHeadBuyerString.append(orgBuyer);
      newtimes.preproduction.guis.tempProperties.orgProdHeadMakerString.append(orgMaker);
      String sc_no=(String)newtimes.preproduction.Constants.CURRENT_PREPROD_HEAD_RECORD.get("prod_sc_no");
      util.MiscFunc.showProcessingMessage();
        newtimesejb.TPE_MIS.TpeMisFuncHome tpeMisEjbHome =
            (newtimesejb.TPE_MIS.TpeMisFuncHome)
            info_ejb.WeblogicServiceLocator.locateServiceHome(util.
            PublicVariable.SERVER_URL,
            "newtimesejb.TPE_MIS.TpeMisFunc");
        newtimesejb.TPE_MIS.TpeMisFunc tpeMISejb = tpeMisEjbHome.create();
        java.util.HashMap hm = new java.util.HashMap();
        hm.put("TPEMISCFUNC_ACTION_CODE", "BACKUP_FOR_ORDER_CHAGE");
        hm.put("SC_NO", sc_no);
        java.util.HashMap hmResult = tpeMISejb.tpeMisFunc(hm);
        String verNo = (String)hmResult.get("VER_NO");
        util.ApplicationProperites.setProperties(sc_no+"_order_chage",verNo);
      util.MiscFunc.hideProcessingMessage();

      processhandler.template.Properties.getCenteralControler().
          doCommandExecute(
          new newtimes.preproduction.process.TrggerEditAPreprod()
      );
      System.out.println("");
    }catch(Exception exp){

    }

  }

}
java.util.HashMap readyToEditRecord()throws Exception{
  int recAt=getInsideJtable().getSelectedRow();
  Record clickedRecord=(Record)pgTblList.getDisplayingRecords().get(recAt);
  java.util.HashMap hm=new java.util.HashMap();
  hm.put("clickedRecord",clickedRecord);
  int finalPk=-1;
  Object ctInforObj=clickedRecord.get("prod_ct_seq");
  if(ctInforObj!=null && (!ctInforObj.toString().equals("1"))){
    //find out the heading record,switch to head record.
     finalPk=clickedRecord.getInt("prod_heading_pk");
  }else{
    finalPk=clickedRecord.getInt(0);
  }

  Record rec=(Record)myHander.findbyPk(finalPk);  //pgTblList.getDisplayingRecords().get(recAt);
  processhandler.template.Properties.getCenteralControler().setCurrentEditingMasterRecord(rec);
  newtimes.production.ProdMaintain_Properties.PRODUCTION_AUDIT_STATUS_COLUMN_NAME="PRODUCTION_AUDIT_STATUS";
  newtimes.preproduction.Constants.CURRENT_PREPROD_HEAD_PK=rec.getInt(0);
  newtimes.preproduction.Constants.CURRENT_PREPROD_HEAD_RECORD=rec;
  newtimes.preproduction.guis.tempProperties.orgProdHeadBuyerString.setLength(0);
  newtimes.preproduction.guis.tempProperties.orgProdHeadMakerString.setLength(0);
  String orgBuyer=(String)getInsideJtable().getValueAt(recAt,1);
  String orgMaker=(String)getInsideJtable().getValueAt(recAt,2);
  hm.put("orgBuyer",orgBuyer);
  hm.put("orgMaker",orgMaker);
  {
    if(ctInforObj==null){
      newtimes.preproduction.Constants.swithToGeneralMode();//there is no C/T infor ,it's normal process.
    }else{
      newtimes.preproduction.Constants.swithToNTHKMode();//there is has C/T infor ,it's C/T process.
    }
  }
  newtimes.production.ProdMaintain_Properties.IS_PO_SHIPPED=null;
  return hm;
}


  public void gridTableMouseEventHandler(final MouseEvent e) {
    int selecRow,selecCol;
    if(mouseRightMenu.isVisible())mouseRightMenu.setVisible(false);
    if ((e.getModifiers() & java.awt.event.InputEvent.BUTTON3_MASK) == java.awt.event.InputEvent.BUTTON3_MASK){
         if(getInsideJtable().getSelectedColumn() >6){
           e.consume();
           return;
         }
          if(!(util.PublicVariable.OPERATTING_CENTER.equalsIgnoreCase("001") &&
             util.PublicVariable.USER_RECORD.getInt(2)==newtimesejb.preproduction.PreProductionHead.USER_TYPE_SUPERVIOSER_MIS)){
           return;
          }
          selecRow=getInsideJtable().rowAtPoint(e.getPoint());
          if(selecRow<0)return;
          //if the row do not countain s/C
          String strBordRangeSc=(String)getInsideJtable().getValueAt(selecRow,4);
          if(strBordRangeSc==null || strBordRangeSc.trim().length()==0)return;
          String arrTest[]=util.MiscFunc.split(strBordRangeSc.trim()," ");
          if(!arrTest[arrTest.length-1].startsWith("SATW"))return;//NO S/C NO,can not proceed order change.
          selecCol=getInsideJtable().columnAtPoint(e.getPoint());
          getInsideJtable().changeSelection(selecRow,selecCol,false,false);
          javax.swing.SwingUtilities.invokeLater(
            new Runnable(){
              public void run() {
               mouseRightMenu.show(getInsideJtable(), e.getX(), e.getY());
               return;
               }
             }
          );

    }

    if(getInsideJtable().getSelectedColumn() < (getInsideJtable().getColumnCount() - 4)){
      return;
    }
    if((e.getModifiers() & java.awt.event.InputEvent.BUTTON3_MASK) == java.awt.event.InputEvent.BUTTON3_MASK){
      e.consume();
      return;
    }

    processhandler.template.Properties.getMainFrame().setCursor(new Cursor(Cursor.WAIT_CURSOR));
    this.setCursor(new Cursor(Cursor.WAIT_CURSOR));
    this.pgTblList.getJtable().setCursor(new Cursor(Cursor.WAIT_CURSOR));
    util.ApplicationProperites.setProperties(
        this.getClass().getName()+"_TOP_RECORD_AT",new Integer(pgTblList._rowPosition));
     int recAt=getInsideJtable().getSelectedRow();
     if(recAt<0) return;
     //System.out.println("qry list table click at row:"+recAt);
     int columnAt=getInsideJtable().getSelectedColumn();
     //clear all the selection..
    //getInsideJtable().clearSelection();
     //see if to enter to edit master Record or just display showing detail of clicked record.
     try{
       //util.PublicVariable.APP_FRAME.setCursor(new Cursor(Cursor.WAIT_CURSOR));
       java.util.HashMap hm=readyToEditRecord();
       String orgBuyer=(String)hm.get("orgBuyer");
       String orgMaker=(String)hm.get("orgMaker");

      if (columnAt == (getInsideJtable().getColumnCount() - 2)) {
       //set current ultratable's 1st record position to system properties.
       //for going back to display.
       util.ApplicationProperites.setProperties(
          processhandler.template.Constants.XNT_LIST_QRY_RESLUT_BGN_AT,
        new Integer(getCurrentPageBeginPosition()));
        newtimes.preproduction.guis.tempProperties.orgProdHeadBuyerString.append(orgBuyer);
        newtimes.preproduction.guis.tempProperties.orgProdHeadMakerString.append(orgMaker);

        processhandler.template.Properties.getCenteralControler().doCommandExecute(
          new newtimes.production.process.prodmaintain.TgrToGotoOderPrint());

      }else if (columnAt == (getInsideJtable().getColumnCount() - 1)) {
           //list shipping data about this production
           processhandler.template.Properties.getCenteralControler().doCommandExecute(
              new newtimes.preproduction.process.TgrToListSimpleShipData());
      }else if (columnAt == (getInsideJtable().getColumnCount() - 3)) {
         newtimes.preproduction.guis.tempProperties.orgProdHeadBuyerString.append(orgBuyer);
         newtimes.preproduction.guis.tempProperties.orgProdHeadMakerString.append(orgMaker);
         processhandler.template.Properties.getCenteralControler().doCommandExecute(
            new newtimes.preproduction.process.TrggerEditAPreprod());

      }else if (columnAt == (getInsideJtable().getColumnCount() - 4)) {
         //set current ultratable's 1st record position to system properties.
         //for going back to display.
         util.ApplicationProperites.setProperties(
            processhandler.template.Constants.XNT_LIST_QRY_RESLUT_BGN_AT,
          new Integer(getCurrentPageBeginPosition()));
          newtimes.preproduction.guis.tempProperties.orgProdHeadBuyerString.append(orgBuyer);
          newtimes.preproduction.guis.tempProperties.orgProdHeadMakerString.append(orgMaker);
         processhandler.template.Properties.getCenteralControler().doCommandExecute(
            new newtimes.production.process.prodmaintain.TgrToListStyles());
       }else {
         /*
         before adding detial data to tabbed pane of current,turn off the
         enable Flag of "stateChage" of split frame.
         and turn it on after adding 1st detial pane of detail data.

         processhandler.template.Properties.getCenteralControler().doCommandExecute(
            new newtimes.production.process.prodmaintain.TgrToListPlanQuotaWithProdHead());
         */
       }
     }catch(Exception cmdE){
        cmdE.printStackTrace();
        util.ExceptionLog.exp2File(cmdE,"exp while dispatching action from query result list page");
     }finally{
        this.pgTblList.getJtable().setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
        processhandler.template.Properties.getMainFrame().setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
        this.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
     }
   }

}
