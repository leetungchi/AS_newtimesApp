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

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class PnlListShipLackDetail
    extends PnlListQryRslt
    implements exgui.ultratable.MakeTableNotify{
    protected  PagedDataFactory myHander;
    boolean hasModifLogButton=false;;
    javax.swing.JButton btnExit=new javax.swing.JButton("EXIT");
    MyMouseActionListener axnListener=new MyMouseActionListener();

    public PnlListShipLackDetail(exgui.ultratable.PagedDataFactory  pagedDataFxy,
          int rowCount,util.InsertionOrderedHashMap columnMapping,
          java.util.Hashtable object2StringConvertor
      ){
       super(pagedDataFxy,rowCount,columnMapping,object2StringConvertor,"","");
       myHander=pagedDataFxy;
       this.removeAll();
       this.add(this.pgTblList,BorderLayout.CENTER);
       pgTblList.setMakeTableNotifier(this);
       this.MakingTable(null);
       pgTblList.getLowerRightPanel().add(btnExit);
       btnExit.addActionListener(axnListener);
       hasModifLogButton=false;
    }
    public void MakingTable(java.util.Vector vct){
      getInsideJtable().getColumnModel().getColumn(0).setPreferredWidth(130);
      getInsideJtable().getColumnModel().getColumn(1).setPreferredWidth(100);
      getInsideJtable().getColumnModel().getColumn(2).setPreferredWidth(75);
      getInsideJtable().getColumnModel().getColumn(3).setPreferredWidth(130);
      getInsideJtable().getColumnModel().getColumn(4).setPreferredWidth(230);
      getInsideJtable().getColumnModel().getColumn(5).setPreferredWidth(75);
      getInsideJtable().getColumnModel().getColumn(6).setPreferredWidth(180);

    }
    public void gridTableMouseEventHandler(java.awt.event.MouseEvent me){
      return;
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

}
