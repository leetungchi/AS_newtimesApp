package processhandler.template;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import database.datatype.Record;
import exgui.ultratable.*;
import java.util.Vector;
import exgui.MultiClassTableModel;
import java.io.*;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class PnlListQryRslt extends JPanel
    implements java.awt.event.MouseListener,GoPageNotify{
  protected JScrollPane jScrollPane1 = new JScrollPane();
  protected JTable tblList4Qry = new JTable();
  public PagedListTable4Qry  pgTblList=null;
  public static final String EDITABLE_COLUMN_NAME_SPLITER=
            PagedListTable4Qry.DELIMITER2CHAIN4BUTTON_COLUMN;
  public PnlListQryRslt() {
    try {
      jbInit();
      setPagedTable();
      //pgTblList.setGotopageNotifyer(this);
    }catch(Exception ex) {
      ex.printStackTrace();
    }
  }
  protected PnlListQryRslt(
       PagedDataFactory pagedDataFxy,
       int rowCount,util.InsertionOrderedHashMap columnMapping,
       java.util.Hashtable object2StringConvertor
  ) {
     pgTblList=
         new PagedListTable4Qry(pagedDataFxy,rowCount,columnMapping,object2StringConvertor);
     try{
       jbInit();
       setPagedTable();
       pgTblList.setGotopageNotifyer(this);
     }catch(Exception e ){
       e.printStackTrace();
     }
  }

   protected PnlListQryRslt(
        PagedDataFactory pagedDataFxy,
        int rowCount,util.InsertionOrderedHashMap columnMapping,
        java.util.Hashtable object2StringConvertor,
        String titleColum1,String btnText1){
      pgTblList=
          new PagedListTable4Qry(
            pagedDataFxy,
            rowCount,
            columnMapping,
            object2StringConvertor,
            titleColum1,btnText1);
      try{
        jbInit();
        setPagedTable();
        pgTblList.setGotopageNotifyer(this);
      }catch(Exception e ){
        e.printStackTrace();
      }
  }

 protected void jbInit() throws Exception {
    this.setLayout(new BorderLayout());
    this.setBackground(new Color(204,204,225));
  }

  /**
   * system should keep this value before flipping to other commands.
   * @return the int value of record start position of query.
   */
  protected int getCurrentPageBeginPosition(){
    return pgTblList._rowPosition;
  }
  public JTable getInsideJtable(){
    return pgTblList.getJtable();
  }
   public void mouseClicked(MouseEvent e){
     //gridTableMouseEventHandler(e);
   }
   public void mouseEntered(MouseEvent e){}
   public void mouseExited(MouseEvent e){}
   public void mousePressed(MouseEvent e){
      //System.out.println("-----mouse released---");
      gridTableMouseEventHandler(e);
   }
   public void mouseReleased(MouseEvent e){}

   protected void setPagedTable(){
    //flip page to system properties.--Constants.XNT_LIST_QRY_RESLUT_BGN_AT;
   // System.out.println("current properties name or top_record_at"+this.getClass().getName()+"_TOP_RECORD_AT");
    int topRecAt=1;
    if(util.ApplicationProperites.getProperties(
        this.getClass().getName()+"_TOP_RECORD_AT")!=null){
      topRecAt = (
          (Integer) util.ApplicationProperites.getProperties(
          this.getClass().getName()+"_TOP_RECORD_AT")).intValue();
     // System.out.println("pgTblList._rowPosition restored ,valuse is:" + topRecAt);
    }
    //jScrollPane1.getViewport().add(pgTblList, null);
    if(pgTblList!=null){
      pgTblList.getJtable().setRowHeight(30);
      pgTblList.getJtable().addMouseListener(this);
      //pgTblList.setPreferredSize(new Dimension(200, 200));
      this.add(pgTblList);
      if(pgTblList._rowPosition!=topRecAt){
          pgTblList._rowPosition = topRecAt;
          pgTblList.reload();
      }
    }
   // System.out.println("set page for class:"+getClass().getName());

  }

  /**
   * this action should be over write at each child class,
   * indicating the process to proceed while clicking each row.
   * @param e the triggered mouse event
   */
  public void gridTableMouseEventHandler(MouseEvent e){
    Cursor ksr=null;
    int recAt=pgTblList.getJtable().getSelectedRow();
    if(recAt<0) return;
    //System.out.println("qry list table click at row:"+recAt);
    int columnAt=pgTblList.getJtable().getSelectedColumn();
    //clear all the selection..
    pgTblList.getJtable().clearSelection();
    //System.out.println("qry list table click at colmn:"+columnAt);
    Record rec=(Record)pgTblList.getDisplayingRecords().get(recAt);
    Properties.getCenteralControler().setCurrentEditingMasterRecord(rec);
    //see if to enter to edit master Record or just display showing detail of clicked record.
    if(util.PublicVariable.APP_FRAME!=null){
      ksr=util.PublicVariable.APP_FRAME.getCursor();
      util.PublicVariable.APP_FRAME.setCursor(new Cursor(Cursor.WAIT_CURSOR));
    }
    try{
      if (columnAt == (pgTblList.getJtable().getColumnCount() - 1)) {
        //set current ultratable's 1st record position to system properties.
        //for going back to display.
        util.ApplicationProperites.setProperties(Constants.XNT_LIST_QRY_RESLUT_BGN_AT,
         new Integer(pgTblList._rowPosition));
         //System.out.println("store pgTblList._rowPosition ="+pgTblList._rowPosition);
        //let's edit the master data.
        //coresponding to the clicked record.
        Properties.getCenteralControler().doCommandExecute(
            Properties.getCenteralControler().GOTO_EDITMASTER
        );
      }
      else {
        /*
        before adding detial data to tabbed pane of current,turn off the
        enable Flag of "stateChage" of split frame.
        and turn it on after adding 1st detial pane of detail data.
        */
       Properties.getCenteralControler().doCommandExecute(Properties.
            getCenteralControler().SHOW_DETAIL_OF_THIS_RECORD
          );
      }
    }catch(Exception cmdE){
       cmdE.printStackTrace();
       util.ExceptionLog.exp2File(cmdE,"exp while dispatching action from query result list page");
    }finally{
      if(ksr!=null){
        util.PublicVariable.APP_FRAME.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
      }
    }
  }
  public void goPageNotify(int pagedTableBgnRowNo){
   util.ApplicationProperites.setProperties(
    this.getClass().getName()+"_TOP_RECORD_AT",
    new Integer(pagedTableBgnRowNo));
  }
}
