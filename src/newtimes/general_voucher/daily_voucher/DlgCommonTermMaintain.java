package newtimes.general_voucher.daily_voucher;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import database.datatype.Record;
import java.util.*;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class DlgCommonTermMaintain extends JDialog {
  JPanel panel1 = new JPanel();
  PnlListCommonTerms pnl2List = null;
  JButton btnUpdate = new JButton();
  JButton btnClose = new JButton();

  public DlgCommonTermMaintain(Frame frame, String title, boolean modal) {
    super(frame, title, modal);
    try {
      jbInit();
      pack();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }

  public DlgCommonTermMaintain() {
    this(null, "", false);
  }

  private void jbInit() throws Exception {
    util.InsertionOrderedHashMap iso=new util.InsertionOrderedHashMap();
    iso.put("           µü·J        ","TERM");
    Hashtable ht=new Hashtable();
     ht.put("           µü·J        ",exgui.verification.CellFormat.getOrdinaryField(100));
    pnl2List=new PnlListCommonTerms(new Db2GetCommonTerms(),99999, iso,ht);
    panel1.setLayout(null);
    pnl2List.setBounds(new Rectangle(25, 30, 332, 295));
    btnUpdate.setBounds(new Rectangle(78, 361, 87, 27));
    btnUpdate.setFont(new java.awt.Font("Dialog", 1, 11));
    btnUpdate.setText("OK");
    btnUpdate.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnUpdate_actionPerformed(e);
      }
    });
    btnClose.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnClose_actionPerformed(e);
      }
    });
    btnClose.setText("EXIT");
    btnClose.setFont(new java.awt.Font("Dialog", 1, 11));
    btnClose.setForeground(Color.red);
    btnClose.setBounds(new Rectangle(214, 361, 87, 27));
    getContentPane().add(panel1);
    panel1.add(btnUpdate, null);
    panel1.add(btnClose, null);
    panel1.add(pnl2List, null);
    pnl2List.firstPage();
    pnl2List.getJtable().setRowHeight(20);
  }
  class Db2GetCommonTerms extends exgui.ultratable.PagedDataFactoryAdapter{
    Record myBlankRec=null;
    public Record getBlankRecord(){

      try{
        if(myBlankRec==null){
          myBlankRec=(Record)util.MiscFunc.deepCopy(newtimes.preproduction.guis.tempProperties.tmpUnits.get(0));
          myBlankRec.getFieldName().clear();
          myBlankRec.getValueFields().clear();
          myBlankRec.getFieldName().add("TERM");
          myBlankRec.getValueFields().add(null);
          myBlankRec.getModifiedFields().clear();
        }
        return (Record)util.MiscFunc.deepCopy(myBlankRec);
      }catch(Exception exp){
        exp.printStackTrace();

      }
      return null;
    }

    public Vector getRecords(int p1,int p2)throws Exception{
      Vector vct=exgui2.CONST.BASIC_MAIN_EJB.getDatas(
      util.PublicVariable.USER_RECORD,"select * from VH_CMN_TERM  order by term",1,999999);
      for(int i=0;i<20;i++){
        vct.add(getBlankRecord());
      }
      return vct;
    }
  }

  class PnlListCommonTerms extends exgui.ultratable.FuncAbstractUltraTablePanel {
    public PnlListCommonTerms(exgui.ultratable.PagedDataFactory pagedDataFxy,
                      int rowCounts,util.InsertionOrderedHashMap columnMapping,
                     java.util.Hashtable object2StringConvertor){
        super(pagedDataFxy, rowCounts, columnMapping, object2StringConvertor);
        super.getLowerRightPanel().removeAll();
        super.getPanelContainsButtons().removeAll();
    }
    public void doPrint(){}
    public int getEachPageRowCount(){return _rowCounts;}
    public Hashtable getObject2StringConvertor() {return klmObjKvtHt;}
    public util.InsertionOrderedHashMap getHeadColumnMap(){return tblHeadColumn;}
    public exgui.ultratable.PagedDataFactory getPagedDataFactory(){return dbHandler;}
    public Record setObject2Record(Record rec,int col,Object obj){
      try{
        //System.out.println(storedRecordColumn[col] +" modified");
        rec.set(storedRecordColumn[col], obj);
        return rec;
      }catch(Exception exp){
        exp.printStackTrace();
        return null;
      }
    }
    public void refineEditors(exgui.ultratable.MultiEditorJTable me ){
      me.setTextEditorVerifiers(klmObjKvtHt);
    }
    public void doUpdate()throws Exception{

    }
    public boolean updateModifiedRecord() throws Exception{
      return super.updateModifiedRecord();

    }
  }

  void btnUpdate_actionPerformed(ActionEvent e) {
    try{
      util.MiscFunc.showProcessingMessage();
      newtimesejb.dailyVoucher.DailyVoucherFacadeHome ejbHome=
          (newtimesejb.dailyVoucher.DailyVoucherFacadeHome)
          info_ejb.WeblogicServiceLocator.locateServiceHome(
          util.PublicVariable.SERVER_URL,
          "newtimesejb.dailyVoucher.DailyVoucherFacade");
       newtimesejb.dailyVoucher.DailyVoucherFacade ejb=ejbHome.create();
       java.util.List arrList=new ArrayList();
       for(int i=0;i<pnl2List.getJtable().getRowCount();i++){
         String str=(String)pnl2List.getJtable().getValueAt(i,0);
         if(!(str==null||str.trim().length()==0))arrList.add(str);
       }
       ejb.udpateCommonTerms( (String[])arrList.toArray(new String[0]) );
      util.MiscFunc.hideProcessingMessage();
    }catch(Exception exp){
      exp.printStackTrace();
      util.ExceptionLog.exp2File(exp,"");
      exgui.verification.VerifyLib.showAlert("Update Common Terms Failed!!\nPlease Contact System Manager","Update Failed!!");
    }
    this.dispose();
  }
  void btnClose_actionPerformed(ActionEvent e) {
    this.dispose();
  }

}
