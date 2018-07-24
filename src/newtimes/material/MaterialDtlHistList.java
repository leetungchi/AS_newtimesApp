package newtimes.material;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.event.*;
import java.util.HashMap;
import database.datatype.Record;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class MaterialDtlHistList extends JPanel implements CommonFunc {
   final newtimes.material.CONST.MTRHIST.EJB MTRH_EJB=null;
   final newtimes.material.CONST.MTRHIST.APP.LIST MTRHIST_COND=null;
   final newtimes.material.CONST.MTR.APP.SEARCH MTR_SEARCH = null;
   final newtimes.material.CONST.COMMON COMMON = null;
   String title_millName=null;
   String title_millMtrNo=null;
  Record CurrUser = util.PublicVariable.USER_RECORD;
  CommonFunc prevFuncObj = null;

  JPanel parent=null;
  JTabbedPane jTabbedPane1 = new JTabbedPane();
  JPanel jPanel1 = new JPanel();
  JPanel jPanel2 = new JPanel();

  //MtrDtlListAbsPanel MtrDtlTablePanel = null;
  PnlMtlDtlListWithButton MtrDtlTablePanel = null;
  JTable mtrDtlListTable = null;

  MtrHistListAbsPanel MtrHistTablePanel = null;
  JTable mtrHistListTable = null;
  BorderLayout borderLayout1 = new BorderLayout();
  BorderLayout borderLayout2 = new BorderLayout();
  BorderLayout borderLayout3 = new BorderLayout();
  int current_target_mtrdtl_seq;
  int psudoTabeIndex;
  public MaterialDtlHistList(JPanel parent) {
    try {
      this.parent = parent;
      jbInit();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }

  void jbInit() throws Exception {
    this.setLayout(borderLayout2);
    //this.setSize(new Dimension(760, 500));
    this.setPreferredSize(new java.awt.Dimension(300,270));

    jPanel1.setLayout(borderLayout1);
    jTabbedPane1.addChangeListener(new MaterialDtlHistList_jTabbedPane1_changeAdapter(this));

    jPanel2.setBackground(new Color(204, 204, 225));
    jPanel2.setLayout(borderLayout3);


    jTabbedPane1.setTabPlacement(JTabbedPane.BOTTOM);
    jTabbedPane1.setFont(new java.awt.Font("Dialog", 1, 13));
    jTabbedPane1.setForeground(new Color(10,36,106));
    //jTabbedPane1.add(jPanel1, "Price / Detail / Mill");
    //jTabbedPane1.add(jPanel2, "History");
    jTabbedPane1.add(jPanel1, "                                                                                                                                                                                                                                                                                                                            ");
    jTabbedPane1.add(jPanel2, "                                                                                                                                                                                                                                                                                                                            ");
    //jTabbedPane1.setEnabled(false);
    jTabbedPane1.setSize(new Dimension(750, 600));
    this.add(jTabbedPane1, BorderLayout.CENTER);
    //jTabbedPane1.setTabPlacement(JTabbedPane.BOTTOM);
    jTabbedPane1.setEnabled(false);
  }

  void mtrDtlListTable_mouseReleased(MouseEvent e) {

   if(parent instanceof MaterialList){
      MaterialList parentPane = (MaterialList)parent;
      int recIndex = mtrDtlListTable.getSelectedRow();
      if(recIndex>-1){
         title_millName=(String)mtrDtlListTable.getValueAt(recIndex,0);
         title_millMtrNo=(String)mtrDtlListTable.getValueAt(recIndex,1);

        if(mtrDtlListTable.getSelectedColumn()<(mtrDtlListTable.getColumnCount()-1)){
          setCursor(new Cursor(Cursor.WAIT_CURSOR));
          util.ApplicationProperites.setProperties("_rowCounts2", new Integer(MtrDtlTablePanel.pgTblList._rowCounts));
          util.ApplicationProperites.setProperties("_rowPosition2", new Integer(MtrDtlTablePanel.pgTblList._rowPosition));
          java.util.Vector recs = MtrDtlTablePanel.getDisplayingRecords();
           parentPane.showMaterialDetailLong( (Record) recs.get(recIndex));
           setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
         }else{
           jTabbedPane1.setSelectedIndex(1);
        }
     }
   }
  }
  void jTabbedPane1_stateChanged(ChangeEvent e) {
    /*
    if(parent instanceof MaterialList &&
         MtrDtlTablePanel!=null && MtrHistTablePanel!=null){
   */
    if(parent instanceof MaterialList ){
      MaterialList parentPane = (MaterialList)parent;
      int index = currTabIndex();
      JDialog message = null;
      switch(index){
        case 0:
          //message = new mtrWarnDialog(null, "Test", "Tab 0(Material Detail)", true);
          parentPane.AdjustButtton(true, false, false, false, false, true, false);
          parentPane.setFuncObj(prevFuncObj);
          break;
        case 1:
          //message = new mtrWarnDialog(null, "Test", "Tab 1(Material History)", true);
          setCursor(new Cursor(Cursor.WAIT_CURSOR));
          jPanel2.removeAll();
          HashMap hm = (HashMap)util.ApplicationProperites.getProperties("MtrHistListConds");
          int mtrDltSeq=((Record)MtrDtlTablePanel.getDisplayingRecords().get(
                      MtrDtlTablePanel.getJtable().getSelectedRow())).getInt(0);
          current_target_mtrdtl_seq=mtrDltSeq;
          hm.put("MTR_DTL_PK",new Integer(mtrDltSeq));
          util.ApplicationProperites.setProperties("MtrHistListConds",hm);
          MtrHistTablePanel = new MtrHistListAbsPanel();
          mtrHistListTable = MtrHistTablePanel.getJtable();
          MtrHistTablePanel.setBackground(new Color(204, 204, 225));
          MtrHistTablePanel.setBounds(22, 55, 725, 250);
          jPanel2.add(
           new exgui.BlueBkgWhiteCharLabel(
            "Mill Name:"+((title_millName==null)?" N/A   ":title_millName)+
           ",Mill MTR-NO:"+((title_millMtrNo==null)?" N/A   ":title_millMtrNo)),
             BorderLayout.NORTH);
          jPanel2.add(MtrHistTablePanel, BorderLayout.CENTER);

          prevFuncObj = parentPane.getCurrFuncObj();
          parentPane.AdjustButtton(true, true, true, true, true, true, false);
          parentPane.setFuncObj(this);
          setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
          break;
        default:
      }

    }
  }


  void initDataTable(){

    jTabbedPane1.setEnabled(false);
    this.setBackground(new Color(204, 204, 225));
    jTabbedPane1.setBackground(new Color(204, 204, 225));
    jPanel1.setBackground(new Color(204, 204, 225));
    //MtrDtlTablePanel = new MtrDtlListAbsPanel();
      MtrDtlTablePanel =new PnlMtlDtlListWithButton();
    //add by Chloe
    //if (CONST.detailPageFlag) {
    if (MtrDtlListAbsPanel.hmNull == 2 && CONST.detailPageFlag && MaterialDetailLong.yes_no == 0) {
      CONST.detailPageFlag = false;
      int _rowCounts = Integer.parseInt(util.ApplicationProperites.getProperties("_rowCounts2").toString());
      int _rowPosition = Integer.parseInt(util.ApplicationProperites.getProperties("_rowPosition2").toString());
      MtrDtlTablePanel.goPage(_rowPosition,_rowCounts,true);
      /*
      int skip = Math.abs(_rowPosition/_rowCounts);
      for (int i = 0; i < skip; i++) {
        MtrDtlTablePanel.nextPage();
      }*/

    }

    mtrDtlListTable = MtrDtlTablePanel.getJtable();
    MtrDtlTablePanel.setBackground(new Color(204, 204, 225));
    MtrDtlTablePanel.setBounds(new Rectangle(22, 55, 716, 250));
    mtrDtlListTable.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseReleased(MouseEvent e) {
        mtrDtlListTable_mouseReleased(e);
      }
    });
    jPanel1.add(MtrDtlTablePanel, null);
   /*
    MtrHistTablePanel = new MtrHistListAbsPanel();
    mtrHistListTable = MtrHistTablePanel.getJtable();
    MtrHistTablePanel.setBackground(new Color(204, 204, 225));
    MtrHistTablePanel.setBounds(22, 55, 725, 250);
    jPanel2.add(MtrHistTablePanel, null);
    */

  }
  int currTabIndex(){
    return jTabbedPane1.getSelectedIndex();
  }
  void newRecord(){
    Object entry = null;
    String mtrNo = null;
    String cenCode = null;
    try{
      HashMap mtrhCond = (HashMap) util.ApplicationProperites.getProperties(
          MTRHIST_COND.CONDITIONS);
      entry = mtrhCond.get(MTR_SEARCH.MTR_NO);
      mtrNo=(entry == null)?(""):( (String) entry);
      entry = mtrhCond.get(MTR_SEARCH.CEN_CODE);
      cenCode=(entry == null)?(""):( (String) entry);
      if(mtrNo!=null && !mtrNo.equals("") && cenCode!=null && !cenCode.equals("")){
        util.MiscFunc.showProcessingMessage();
        Record newRec = exgui2.CONST.Material_Hist_EJB.getBlankRecord();
        newRec.set("MTR_DTL_PK",current_target_mtrdtl_seq);
        newRec.set(MTRH_EJB.MTR_NO, mtrNo);
        newRec.set(MTRH_EJB.CEN_CODE, cenCode);
        newRec.set(COMMON.CREATE_USER, CurrUser.get("USR_CODE"));
        newRec.set(COMMON.DELETE_FLAG, "1");
        newRec.set(COMMON.MODIFY_USER, CurrUser.get("USR_CODE"));
        MtrHistTablePanel.confirmUpdate();//add at 20040614
        exgui2.CONST.Material_Hist_EJB.insertRecord(newRec);
        MtrHistTablePanel.reload();
        MtrHistTablePanel.lastPage();
        ((MaterialList)parent).jSplitPane1.setDividerLocation(150);
        util.MiscFunc.hideProcessingMessage();
      }
    }
    catch(Exception e){
      util.MiscFunc.hideProcessingMessage();
      e.printStackTrace();
    }
    finally{
      util.MiscFunc.hideProcessingMessage();
    }

  }
  //Functions of CommonFunc interface
  public void RecSave(){
    JDialog message = null;
    try{
      util.MiscFunc.showProcessingMessage();
      if(MtrHistTablePanel.confirmUpdate()){
        //message = new mtrWarnDialog(null, "Save", "Record(s) Saved!", true);
      }else{
        util.MiscFunc.hideProcessingMessage();
        message = new mtrWarnDialog(null, "Save", "Record(s) saving failed!", true);
      }
    }
    catch(Exception e){
      e.printStackTrace();
      message = new mtrWarnDialog(null, "Save", "Exception occured!", true);
    }finally{
      util.MiscFunc.hideProcessingMessage();
    }
  }

  public void PrevStep(){
  }

  public void RecDelete(){
    int rowIndex = mtrHistListTable.getSelectedRow();
    if(rowIndex>-1){
      java.util.Vector recList = MtrHistTablePanel.getDisplayingRecords();
      Record currRec = (Record)recList.get(rowIndex);
      MtrHistTablePanel.deleteRow(currRec);
      MtrHistTablePanel.reload();
    }
  }

  public void RecCopy(){
    try{
      int rowIndex = mtrHistListTable.getSelectedRow();
      if (rowIndex > -1) {
        HashMap hm = new HashMap();
        for(int i=2; i<13; i++){
          String id = "field"+i;
          Object value = mtrHistListTable.getValueAt(rowIndex, i);
          hm.put(id, value);
        }
        util.ApplicationProperites.setProperties("copyMaterialHist", hm);
      }
    }
    catch(Exception exp){
      exp.printStackTrace();
    }

  }
  public void RecPaste(){
    try{
      int rowIndex = mtrHistListTable.getSelectedRow();
      Object entry = util.ApplicationProperites.getProperties("copyMaterialHist");
      if(entry!=null && rowIndex>-1){
        HashMap hm = (HashMap)entry;
        for(int i=2; i<13; i++){
          String id = "field"+i;
          mtrHistListTable.setValueAt(hm.get(id), rowIndex, i);
        }
        mtrHistListTable.validate();
      }
    }
    catch(Exception exp){
      exp.printStackTrace();
    }
  }

}

class MaterialDtlHistList_jTabbedPane1_changeAdapter implements javax.swing.event.ChangeListener {
  MaterialDtlHistList adaptee;

  MaterialDtlHistList_jTabbedPane1_changeAdapter(MaterialDtlHistList adaptee) {
    this.adaptee = adaptee;
  }
  public void stateChanged(ChangeEvent e) {
    adaptee.jTabbedPane1_stateChanged(e);
  }
}
