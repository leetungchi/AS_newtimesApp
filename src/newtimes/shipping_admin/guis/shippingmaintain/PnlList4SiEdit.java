package newtimes.shipping_admin.guis.shippingmaintain;

import java.awt.*;
import javax.swing.JPanel;
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

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */
import  newtimes.shipping_admin.process.shiippingmaintain.DB_ShipMaster;
public class PnlList4SiEdit extends PnlListQryRslt {
  protected DB_ShipMaster myHander;
  public static int PAGE_BEGIN;
  public static boolean listWithBuyerMaker=false;
  public PnlList4SiEdit(DB_ShipMaster pagedDataFxy,
        int rowCount,util.InsertionOrderedHashMap columnMapping,
        java.util.Hashtable object2StringConvertor
    ){
     super(pagedDataFxy,rowCount,columnMapping,object2StringConvertor);
     myHander=pagedDataFxy;
     this.removeAll();
     this.add(new JLabel("Please click the rows"),BorderLayout.NORTH);
     this.add(this.pgTblList,BorderLayout.CENTER);
     //this.pgTblList.firstPage();
  }
  public PnlList4SiEdit(DB_ShipMaster pagedDataFxy,
        int rowCount,util.InsertionOrderedHashMap columnMapping,
        java.util.Hashtable object2StringConvertor,
        String titleStr1,String btnStr1){
     super(pagedDataFxy,
           rowCount,
           columnMapping,
           object2StringConvertor,
           titleStr1,
           btnStr1);
     myHander=pagedDataFxy;
     this.removeAll();
     this.add(new JLabel("Please click the rows"),BorderLayout.NORTH);
     this.add(this.pgTblList,BorderLayout.CENTER);
     //this.pgTblList.reload();

  }


  public void gridTableMouseEventHandler(MouseEvent e) {
    newtimes.shipping_admin.process.shiippingmaintain.ToListAddedStyles.PAGE_BEGIN=0;
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
     getInsideJtable().clearSelection();
     //see if to enter to edit master Record or just display showing detail of clicked record.
      java.awt.Container  myContaner=null;
      myContaner=processhandler.template.Properties.getMainFrame().getContentPane();
     try{
       //util.PublicVariable.APP_FRAME.setCursor(new Cursor(Cursor.WAIT_CURSOR));
        if (columnAt == (getInsideJtable().getColumnCount() - 1)) {
          Record clickedRecord=(Record)pgTblList.getDisplayingRecords().get(recAt);
          int si_pk=clickedRecord.getInt("ship_sc_pk");
          //Record rec= myHander.getSiRecord(si_pk);
          newtimes.shipping_admin.ShippingAdmin_Const.EDITING_SHIPPING_SI_RECORD =clickedRecord;
          newtimes.shipping_admin.ShippingAdmin_Const.EDIT_SHIP_SI_PK_INT=si_pk;
          //find out the sc & ct amount of SI record.
          StringBuffer sb=new StringBuffer();
          sb.append("select GET_SHIP_SC_AMT(");sb.append(si_pk);sb.append(") as SC_AMT,");
          sb.append("GET_SHIP_SC_COMM(");sb.append(si_pk);sb.append(") as SC_COMM,");
          sb.append("GET_SHIP_CT_AMT(");sb.append(si_pk);sb.append(") as CT_AMT,");
          sb.append("GET_SHIP_CT_DISC(");sb.append(si_pk);sb.append(") as CT_DISC");
          sb.append(" from dual");
          Object objScAmt=null,objScComm=null,objCtAmt=null,objCtDisc=null;
          Vector vcttmp=exgui2.CONST.BASIC_MAIN_EJB.getDatas(
              util.PublicVariable.USER_RECORD,
              sb.toString(),1,1);
          if(vcttmp.size()>0){
            Record recSiXtraData=(Record)vcttmp.get(0);
            objScAmt=recSiXtraData.get(0);
            objScComm=recSiXtraData.get(1);
            objCtAmt=recSiXtraData.get(2);
            objCtDisc=recSiXtraData.get(3);
          }
          newtimes.shipping_admin.ShippingAdmin_Const.EDITING_SHIPPING_SI_RECORD.getFieldName().add("SC_AMT");
          newtimes.shipping_admin.ShippingAdmin_Const.EDITING_SHIPPING_SI_RECORD.getValueFields().add(objScAmt);
          newtimes.shipping_admin.ShippingAdmin_Const.EDITING_SHIPPING_SI_RECORD.getFieldName().add("SC_COMM");
          newtimes.shipping_admin.ShippingAdmin_Const.EDITING_SHIPPING_SI_RECORD.getValueFields().add(objScComm);
          newtimes.shipping_admin.ShippingAdmin_Const.EDITING_SHIPPING_SI_RECORD.getFieldName().add("CT_AMT");
          newtimes.shipping_admin.ShippingAdmin_Const.EDITING_SHIPPING_SI_RECORD.getValueFields().add(objCtAmt);
          newtimes.shipping_admin.ShippingAdmin_Const.EDITING_SHIPPING_SI_RECORD.getFieldName().add("CT_DISC");
          newtimes.shipping_admin.ShippingAdmin_Const.EDITING_SHIPPING_SI_RECORD.getValueFields().add(objCtDisc);


          newtimes.shipping_admin.ShippingAdmin_Const.EDIT_SHIP_SI_PK_INT =si_pk;

           //to edit ship head...
           PAGE_BEGIN=super.pgTblList._rowPosition;
           processhandler.template.Properties.getCenteralControler().doCommandExecute(
           new newtimes.shipping_admin.process.shiippingmaintain.TgrToEdit_SI());
       }else {

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
