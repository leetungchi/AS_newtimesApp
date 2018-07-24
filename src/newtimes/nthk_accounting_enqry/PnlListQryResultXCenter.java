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

public class PnlListQryResultXCenter extends PnlListQryResult
    implements exgui.ultratable.MakeTableNotify{
    public void MakingTable(java.util.Vector vct){
       //if(vct==null)return;
       getInsideJtable().getColumnModel().getColumn(2).setPreferredWidth(55);
       getInsideJtable().getColumnModel().getColumn(3).setPreferredWidth(50);
       getInsideJtable().getColumnModel().getColumn(4).setPreferredWidth(50);
       getInsideJtable().getColumnModel().getColumn(5).setPreferredWidth(50);
       getInsideJtable().getColumnModel().getColumn(6).setPreferredWidth(50);
       getInsideJtable().getColumnModel().getColumn(7).setPreferredWidth(50);
       getInsideJtable().getColumnModel().getColumn(8).setPreferredWidth(65);
       getInsideJtable().getColumnModel().getColumn(9).setPreferredWidth(55);
       getInsideJtable().getColumnModel().getColumn(10).setPreferredWidth(60);
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
    public PnlListQryResultXCenter(EnqDataEngin pagedDataFxy,
          int rowCount,util.InsertionOrderedHashMap columnMapping,
          java.util.Hashtable object2StringConvertor
      ){
       super(pagedDataFxy,rowCount,columnMapping,object2StringConvertor);
    }
    public PnlListQryResultXCenter(EnqDataEngin pagedDataFxy,
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
   }

}
