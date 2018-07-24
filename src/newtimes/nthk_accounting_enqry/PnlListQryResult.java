package newtimes.nthk_accounting_enqry;
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

import java.awt.*;
import javax.swing.JPanel;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class PnlListQryResult extends PnlListQryRslt
    implements exgui.ultratable.MakeTableNotify{
    protected  EnqDataEngin myHander;
    public static int PAGE_BEGIN;
    boolean hasModifLogButton=false;;
    javax.swing.JButton btnExit=new javax.swing.JButton("EXIT");
  MyMouseActionListener axnListener=new MyMouseActionListener();
    public void MakingTable(java.util.Vector vct){
       //if(vct==null)return;
       getInsideJtable().getColumnModel().getColumn(2).setPreferredWidth(55);
       getInsideJtable().getColumnModel().getColumn(3).setPreferredWidth(50);
       getInsideJtable().getColumnModel().getColumn(4).setPreferredWidth(50);
       getInsideJtable().getColumnModel().getColumn(5).setPreferredWidth(50);
       getInsideJtable().getColumnModel().getColumn(6).setPreferredWidth(50);
       getInsideJtable().getColumnModel().getColumn(7).setPreferredWidth(50);
       getInsideJtable().getColumnModel().getColumn(8).setPreferredWidth(65);
       getInsideJtable().setRowHeight(20);
    }
    class MyMouseActionListener implements java.awt.event.ActionListener {
      public void actionPerformed(ActionEvent e) {
        try{
          processhandler.template.Properties.getCenteralControler().goBack();
        }catch(Exception ie){
          ie.printStackTrace();
        }
      }
    }
    public PnlListQryResult(EnqDataEngin pagedDataFxy,
          int rowCount,util.InsertionOrderedHashMap columnMapping,
          java.util.Hashtable object2StringConvertor
      ){
       super(pagedDataFxy,rowCount,columnMapping,object2StringConvertor);
       myHander=pagedDataFxy;
       this.removeAll();
       this.add(this.pgTblList,BorderLayout.CENTER);
       pgTblList.setMakeTableNotifier(this);
       this.MakingTable(null);
       pgTblList.getLowerRightPanel().add(btnExit);
       btnExit.addActionListener(axnListener);
    }
    public PnlListQryResult(EnqDataEngin pagedDataFxy,
         int rowCount,util.InsertionOrderedHashMap columnMapping,
         java.util.Hashtable object2StringConvertor,
         String titleStr1,String btnStr1
     ){
      super(pagedDataFxy,
            rowCount,
            columnMapping,
            object2StringConvertor,
            titleStr1,
            btnStr1
            );
      if(titleStr1!=null && titleStr1.indexOf(processhandler.template.PagedListTable4Qry.DELIMITER2CHAIN4BUTTON_COLUMN)!=-1)
                   hasModifLogButton=true;

      myHander=pagedDataFxy;
      this.removeAll();
      this.add(this.pgTblList,BorderLayout.CENTER);
      pgTblList.setMakeTableNotifier(this);
      pgTblList.getLowerRightPanel().add(btnExit);
      this.MakingTable(null);
      btnExit.addActionListener(axnListener);
   }
   public void gridTableMouseEventHandler(java.awt.event.MouseEvent me){
     return;
   }
}
