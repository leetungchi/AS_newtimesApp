package newtimes.material;

import java.awt.*;
import newtimes.*;
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
 * @author unascribed
 * @version 1.0
 */

public class MaterialList extends JPanel {
  Frame1 frame;
  JSplitPane jSplitPane1 = new JSplitPane();
  private JScrollPane jScrollPane1 = new JScrollPane();
  private JScrollPane jScrollPane2 = new JScrollPane();
  private JPanel jPanel1 = null;
  private JPanel jPanel2 = null;
  private JButton btnExit = new JButton();
  private JPanel jPanel3 = new JPanel();
  private JButton btnDel = new JButton();
  private JButton btnPaste = new JButton();
  private JButton btnCopy = new JButton();
  private JButton btnConfirm = new JButton();
  private JButton btnNew = new JButton();

  private final newtimes.material.CONST.MTR.APP.SEARCH MTR_SEARCH = null;
  private newtimes.material.CONST.MTRDTL.APP.LIST MTRDTL_COND=null;
  private int ListType= MTR_SEARCH.UNKNOWN;
  private CommonFunc funcObj = null;

  public MaterialList(Frame1 _frame, int Type) {
    frame = _frame;
    ListUIAdjust(Type);
    try {
      jbInit();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }
  public MaterialList() {
  }
  void jbInit() throws Exception {
    //System setting
    this.setLayout(null);
    this.setSize(800,600);
    this.setBackground(new Color(204, 204, 225));
    jSplitPane1.setOrientation(JSplitPane.VERTICAL_SPLIT);
    jSplitPane1.setContinuousLayout(true);
    jSplitPane1.setOneTouchExpandable(true);
    jSplitPane1.setBounds(new Rectangle(0, 0, 793, 544));
    jSplitPane1.setDividerSize(10);
    jSplitPane1.setDividerLocation(0.999);
    btnExit.setBackground(Color.lightGray);
    btnExit.setBounds(new Rectangle(506, 5, 60, 20));
    btnExit.setFont(new java.awt.Font("Dialog", 1, 11));
    btnExit.setBorder(BorderFactory.createEtchedBorder());
    btnExit.setText("EXIT");
    btnExit.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnExit_actionPerformed(e);
      }
    });
    jPanel3.setBackground(new Color(143, 143, 188));
    jPanel3.setBounds(new Rectangle(0, 544, 800, 30));
    jPanel3.setLayout(null);
    btnDel.setBackground(Color.lightGray);
    btnDel.setBounds(new Rectangle(342, 5, 60, 20));
    btnDel.setFont(new java.awt.Font("Dialog", 1, 11));
    btnDel.setBorder(BorderFactory.createEtchedBorder());
    btnDel.setText("DELETE");
    btnDel.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnDel_actionPerformed(e);
      }
    });
    btnPaste.setBackground(Color.lightGray);
    btnPaste.setBounds(new Rectangle(276, 5, 60, 20));
    btnPaste.setFont(new java.awt.Font("Dialog", 1, 11));
    btnPaste.setBorder(BorderFactory.createEtchedBorder());
    btnPaste.setText("PASTE");
    btnPaste.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnPaste_actionPerformed(e);
      }
    });

    btnCopy.setBackground(Color.lightGray);
    btnCopy.setBounds(new Rectangle(210, 5, 60, 20));
    btnCopy.setFont(new java.awt.Font("Dialog", 1, 11));
    btnCopy.setBorder(BorderFactory.createEtchedBorder());
    btnCopy.setText("COPY");
    btnCopy.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnCopy_actionPerformed(e);
      }
    });

    btnConfirm.setBackground(Color.lightGray);
    btnConfirm.setBounds(new Rectangle(108, 5, 96, 20));
    btnConfirm.setFont(new java.awt.Font("Dialog", 1, 11));
    btnConfirm.setBorder(BorderFactory.createEtchedBorder());
    btnConfirm.setText("CONFIRM EDIT");
    btnConfirm.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnConfirm_actionPerformed(e);
      }
    });
    btnNew.setBackground(Color.lightGray);
    btnNew.setBounds(new Rectangle(6, 5, 96, 20));
    btnNew.setFont(new java.awt.Font("Dialog", 1, 11));
    btnNew.setBorder(BorderFactory.createEtchedBorder());
    btnNew.setText("NEW RECORD");
    btnNew.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnNew_actionPerformed(e);
      }
    });
    jScrollPane1.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
    jScrollPane1.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
    jScrollPane2.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
    jScrollPane2.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
    jSplitPane1.add(jScrollPane1, JSplitPane.TOP);
    jSplitPane1.add(jScrollPane2, JSplitPane.BOTTOM);
    this.add(jSplitPane1, null);
    this.add(jPanel3, null);
    jPanel3.add(btnNew, null);
    jPanel3.add(btnConfirm, null);
    jPanel3.add(btnCopy, null);
    jPanel3.add(btnPaste, null);
    jPanel3.add(btnDel, null);
    jPanel3.add(btnExit, null);
  }
  void btnExit_actionPerformed(ActionEvent e) {
    java.awt.Cursor tCur = this.getCursor();
    CONST.isExit = true;
    //add by Chloe
    if (!CONST.pageFlag && !CONST.detailPageFlag) {
      CONST.pageFlag = false;
      util.ApplicationProperites.removeProperites("_rowCounts");
      util.ApplicationProperites.removeProperites("_rowPosition");
    }
    this.setCursor(new java.awt.Cursor(java.awt.Cursor.WAIT_CURSOR));
    if(jPanel2 instanceof MaterialDtlHistList){
      if(((MaterialDtlHistList)jPanel2).currTabIndex()==1){
        ((MaterialDtlHistList)jPanel2).jTabbedPane1.setSelectedIndex(0);
        ((MaterialDtlHistList)jPanel2).jTabbedPane1_stateChanged(null);
      }else{
        CONST.HIST.prevState();
      }
    }else{
      CONST.HIST.prevState();
    }
    this.setCursor(tCur);
  }

  void btnNew_actionPerformed(ActionEvent e) {
    jSplitPane1.setDividerLocation(0.1);
    showMaterialDetailLongOrMtrhList();
  }

//Following Methods are for Material [Search] & [Add New]  functions
  void showDtlHistPanel(Record rec){
    try{
      java.awt.Cursor tCur = this.getCursor();
      this.setCursor(new java.awt.Cursor(java.awt.Cursor.WAIT_CURSOR));
      CONST.HIST.insertState(CONST.HIST.HEAD_LIST, frame);
      if(jPanel1 instanceof MaterialShort){
        jPanel1 = new MaterialLong(rec,false);
        jScrollPane1.getViewport().add(jPanel1, null);
      }
      if(jPanel2 instanceof MaterialDtlHistList){
        ((MaterialDtlHistList)jPanel2).initDataTable();
        jSplitPane1.setDividerLocation(150);
      }
      setFuncObj(null);
      AdjustButtton(true, false, false, false, false, true, false);
      this.setCursor(tCur);
    }
    catch(Exception ex){
      ex.printStackTrace();
    }
  }

  void showMaterialLong(Record rec){
    try{
      java.awt.Cursor tCur = this.getCursor();
      this.setCursor(new java.awt.Cursor(java.awt.Cursor.WAIT_CURSOR));
      CONST.HIST.insertState(CONST.HIST.HEAD_LIST, frame);
      MaterialLong mtrLong = new MaterialLong(rec,true);
      jPanel1 = mtrLong;
      setFuncObj(mtrLong);
      jScrollPane1.getViewport().add(jPanel1, null);
      AdjustButtton(false, true, true, true, true, true, false);
      this.setCursor(tCur);
    }
    catch(Exception ex){
      ex.printStackTrace();
    }
  }

  void showMaterialLong(){
    try{
      java.awt.Cursor tCur = this.getCursor();
      this.setCursor(new java.awt.Cursor(java.awt.Cursor.WAIT_CURSOR));
      MaterialLong mtrLong = new MaterialLong();
      jPanel1 = mtrLong;
      setFuncObj(mtrLong);
      jScrollPane1.getViewport().add(jPanel1, null);
      AdjustButtton(false, true, true, true, true, true, false);
      this.setCursor(tCur);
    }
    catch(Exception ex){
      ex.printStackTrace();
    }
  }

  void showMaterialShort(){
    java.awt.Cursor tCur = this.getCursor();
    this.setCursor(new java.awt.Cursor(java.awt.Cursor.WAIT_CURSOR));
    jPanel1 = new MaterialShort(this);
    setFuncObj(null);
    jScrollPane1.getViewport().add(jPanel1, null);
    AdjustButtton(false, false, false, false, false, true, false);
    this.setCursor(tCur);
  }

  void showMaterialDtlHistList(){
    java.awt.Cursor tCur = this.getCursor();
    this.setCursor(new java.awt.Cursor(java.awt.Cursor.WAIT_CURSOR));
    initMaterialDtlHistList();
    ((MaterialDtlHistList)jPanel2).initDataTable();
    setFuncObj(null);
    AdjustButtton(true, false, false, false, false, true, false);
    this.setCursor(tCur);
  }

  void initMaterialDtlHistList(){
    jPanel2 = new MaterialDtlHistList(this);
    jScrollPane2.getViewport().add(jPanel2, null);
    setFuncObj(null);
  }
  void showMaterialHistory(int mtrDtlSeq){
    try{
      java.awt.Cursor tCur = this.getCursor();
                                                                                                               this.setCursor(new java.awt.Cursor(java.awt.Cursor.WAIT_CURSOR));
      CONST.HIST.insertState(CONST.HIST.DTL_LIST, this);
      //MaterialDetailLong mtrdtlLong  = new MaterialDetailLong(frame, rec);
      //jPanel2 = mtrdtlLong;
      //setFuncObj(mtrdtlLong);
      jScrollPane2.getViewport().add(jPanel2);
      //modified by Chloe
      AdjustButtton(false, true, true, true, true, true, false);
      this.setCursor(tCur);
    }
    catch(Exception ex){
      ex.printStackTrace();
    }
  }


  void showMaterialDetailLong(Record rec){
    try{
      java.awt.Cursor tCur = this.getCursor();
                                                                                                               this.setCursor(new java.awt.Cursor(java.awt.Cursor.WAIT_CURSOR));
      CONST.HIST.insertState(CONST.HIST.DTL_LIST, this);
      MaterialDetailLong mtrdtlLong  = new MaterialDetailLong(frame, rec);
      jPanel2 = mtrdtlLong;
      setFuncObj(mtrdtlLong);
      jScrollPane2.getViewport().add(jPanel2);
      //modified by Chloe
      AdjustButtton(false, true, true, true, true, true, false);
      this.setCursor(tCur);
    }
    catch(Exception ex){
      ex.printStackTrace();
    }
  }

  void showMaterialDetailLong(){
    try{
      java.awt.Cursor tCur = this.getCursor();
      this.setCursor(new java.awt.Cursor(java.awt.Cursor.WAIT_CURSOR));
      if(ListType==MTR_SEARCH.MTR_HEAD_LIST){
        CONST.HIST.insertState(CONST.HIST.DTL_LIST, this);
      }
      MaterialDetailLong mtrdtlLong = new MaterialDetailLong();
      if(jPanel1 instanceof MaterialLong){
        MaterialLong upperPane = (MaterialLong)jPanel1;
        upperPane.editable(false);
      }
      jPanel2 = mtrdtlLong;
      setFuncObj(mtrdtlLong);
      jScrollPane2.getViewport().add(jPanel2);
      //modified by Chloe
      AdjustButtton(false, true, true, true, true, true, false);
      this.setCursor(tCur);
    }
    catch(Exception ex){
      ex.printStackTrace();
    }
  }

  void showMaterialDetailLongOrMtrhList(){
    if(jPanel2 instanceof MaterialDtlHistList){
      MaterialDtlHistList currPane = (MaterialDtlHistList)jPanel2;
      int tabIndex = currPane.currTabIndex();
      switch(tabIndex){
        case 0:
          if (MtrDtlListAbsPanel.hmNull == 2) {
            util.ApplicationProperites.setProperties("_rowCounts2",
                new Integer(new MtrDtlListAbsPanel()._rowCounts));
            util.ApplicationProperites.setProperties("_rowPosition2",
                new Integer(new MtrDtlListAbsPanel()._rowPosition));
          }
          showMaterialDetailLong();
          break;
        case 1:
          currPane.newRecord();
          break;
        default:
      }
    }
    else{
      showMaterialDetailLong();
    }
  }

  void ListUIAdjust(int Type){
    ListType=Type;
    if(ListType==MTR_SEARCH.MTR_HEAD_LIST){//Current Material Head List
      showMaterialShort();
      initMaterialDtlHistList();
    }
    else if(ListType==MTR_SEARCH.MTR_NEW_REC){//new Material record
      showMaterialLong();
    }
    else if(ListType==MTR_SEARCH.DEL_MTR_HEAD_LIST){//Deleted Material Head List
      //modified by Chloe
      CONST.pageFlag = false;
      showDelMaterialShort();
    }
  }
//end of Methods for Existing records functions

//Following Methods are for RESTORE functions
  void showDelMaterialShort(){
    java.awt.Cursor tCur = this.getCursor();
    this.setCursor(new java.awt.Cursor(java.awt.Cursor.WAIT_CURSOR));
    jPanel1 = new DelMaterialShort(this);
    // Denist test 2003/10/07
    jSplitPane1.setDividerLocation(450);
    jScrollPane1.getViewport().add(jPanel1, null);
    setFuncObj(null);
    AdjustButtton(false, false, false, false, false, true, false);
    this.setCursor(tCur);
  }

  void showDelMtrDtlList(Record rec){
    try{
      java.awt.Cursor tCur = this.getCursor();
      this.setCursor(new java.awt.Cursor(java.awt.Cursor.WAIT_CURSOR));
      CONST.HIST.insertState(CONST.HIST.RE_HEAD_LIST, frame);
      jPanel1 = new MaterialLong(rec,false, true);
      // Denist test 2003/10/07
      HashMap hm=(HashMap)util.ApplicationProperites.getProperties(MTRDTL_COND.DELELTED_CONDS);
      String mtrDelFlag=(String)hm.get("mtrDelFlag");
      if(mtrDelFlag.equals("0")){
        jSplitPane1.setDividerLocation(300);
      }else{
        jSplitPane1.setDividerLocation(150);
      }
      jScrollPane1.getViewport().add(jPanel1, null);
      jPanel2 = new DelMatDetailList();
      jScrollPane2.getViewport().add(jPanel2, null);
      setFuncObj(null);
      AdjustButtton(false, false, false, false, false, true, false);
      this.setCursor(tCur);
    }
    catch(Exception ex){
      ex.printStackTrace();
    }
  }
//end of Methods for RESTORE functions
  void AdjustButtton(boolean BtnNew,
                     boolean BtnConfirm,
                     boolean BtnCopy,
                     boolean BtnDel,
                     boolean BtnPaste,
                     boolean BtnExit,
                     boolean BtnPrint)
  {
    btnNew.setEnabled(BtnNew);
    btnConfirm.setEnabled(BtnConfirm);
    btnCopy.setEnabled(BtnCopy);
    btnPaste.setEnabled(BtnDel);
    btnDel.setEnabled(BtnPaste);
    btnExit.setEnabled(BtnExit);
  }

  void setFuncObj(CommonFunc newFuncObj){
    funcObj = newFuncObj;
  }
  CommonFunc getCurrFuncObj(){
    return funcObj;
  }

  void btnConfirm_actionPerformed(ActionEvent e) {
    if(funcObj!=null){
      funcObj.RecSave();
      if (MaterialDetailLong.yes_no == 1) {
        showMaterialDtlHistList();
      }
      if (MaterialLong.getSwitchNewBtn()) {
        btnNew.setText("NEW DETAIL");
        btnNew.setEnabled(true);
      }
      MaterialDetailLong.yes_no = 0;
      MaterialLong.setSwitchNewBtn(false);
    }
  }

  void btnCopy_actionPerformed(ActionEvent e) {
    if(funcObj!=null){
      funcObj.RecCopy();
    }
  }

  void btnPaste_actionPerformed(ActionEvent e) {
    if(funcObj!=null){
      funcObj.RecPaste();
    }
  }
  //Modify by Chloe 2003.09.25
  void btnDel_actionPerformed(ActionEvent e) {
    int result = exgui2.InfoMessage.Yes_No_Option(frame,"Delete ?");
    if(result == 0){
      try {
        setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        if (funcObj != null) {
//======================================================================
          if(funcObj instanceof MaterialDtlHistList){
            MaterialDtlHistList currPane = (MaterialDtlHistList)funcObj;
            int tabIndex = currPane.currTabIndex();
            switch(tabIndex){
              case 0:
                break;
              case 1:
                funcObj.RecDelete();
                return;
            }
          }
//=========================================================================
          funcObj.RecDelete();
          java.awt.Cursor tCur = this.getCursor();
          CONST.HIST.prevState();
          this.setCursor(tCur);
        }
      } catch (Exception eDel) {
        eDel.printStackTrace();
      } finally {
        setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
      }
    }
  }

  JButton getNewButn() {
    return btnNew;
  }
}
