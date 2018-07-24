package newtimes.reports.report01.GmtLcReq;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.HashMap;
import java.util.Vector;
import database.datatype.Record;


/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class GmtLcQueryCurrent extends JPanel {
  GmtLcQuery parent=null;
  JCheckBox[] cboxGroup = new JCheckBox[10];
  JButton btnAdd = new JButton();
  GmtLcListAbsPanel currQueryPanel = null;
  JTable            currQueryTable = null;
  Vector            currDisplayRecords = null;
  GmtLcQuery.RecordsPool recPool = null;
  //JCheckBox jCheckBox1 = new JCheckBox();


  public GmtLcQueryCurrent(GmtLcQuery _parent) {
    parent = _parent;
    recPool = new GmtLcQuery.RecordsPool();
    try {
      jbInit();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }
  void jbInit() throws Exception {
    //jCheckBox1.setText("jCheckBox1");
    //jCheckBox1.setBounds(new Rectangle(29, 252, 18, 14));
    //jCheckBox1.addActionListener(new java.awt.event.ActionListener() {
    //  public void actionPerformed(ActionEvent e) {
    //    jCheckBox1_actionPerformed(e);
    //  }
    //});
    //jCheckBox1.addItemListener(new java.awt.event.ItemListener() {
    // public void itemStateChanged(ItemEvent e) {
    //    jCheckBox1_itemStateChanged(e);
    //  }
    //});
    this.setBackground(new Color(204, 204, 225));
    this.setOpaque(true);
    this.setLayout(null);
    this.setSize(800,300);
    btnAdd.setBackground(Color.lightGray);
    btnAdd.setBounds(new Rectangle(320, 290, 172, 22));
    btnAdd.setFont(new java.awt.Font("Dialog", 1, 13));
    btnAdd.setForeground(Color.darkGray);
    btnAdd.setBorder(BorderFactory.createEtchedBorder());
    btnAdd.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnAdd_actionPerformed(e);
      }
    });
    btnAdd.setText("Add To Result List");
    initCheckBoxGroup();
    //this.add(btnAdd, null);
    //this.add(jCheckBox1, null);

  }

  void btnAdd_actionPerformed(ActionEvent e){
    parent.addCurrQueryRecs(recPool);
    parent.refreshResultQuery();
  }

  void CheckboxClicked(ActionEvent e, final int index) {
    Record rec = null;
    String key=null;
    try{
      rec = (Record)currDisplayRecords.get(index);
      key = rec.get("STY_SEQ").toString();
    }
    catch(Exception exp){
      exp.printStackTrace();
    }
    if(cboxGroup[index].isSelected()){
      recPool.add(key);
      System.out.println("Record" + index + " Checked");
    }
    else{
      recPool.remove(key);
      System.out.println("Record" + index + " Unchecked");
    }
    System.out.println("recPool:"+recPool);
    Vector testVec = recPool.keyLists();
    if(testVec.size()>0){
      System.out.println("STY_SEQ:" + testVec.get(0));
    }
  }

  void initDataTable(){
    this.add(btnAdd, null);
    currQueryPanel = new GmtLcListAbsPanel(this);
    currQueryTable = currQueryPanel.getJtable();
    currQueryPanel.setBackground(new Color(204, 204, 225));
    currQueryPanel.setBounds(new Rectangle(35, 40, 730, 250));
    this.add(currQueryPanel, null);
    currQueryPanel.firstPage();
  }

  void initCheckBoxGroup(){
    for(int i=0; i<cboxGroup.length; i++){
      cboxGroup[i] = new JCheckBox();
      cboxGroup[i].setBackground(new Color(204, 204, 225));
      cboxGroup[i].setBorder(BorderFactory.createEtchedBorder());
      cboxGroup[i].setText("");
      cboxGroup[i].setBounds(new Rectangle(14, 64+(i*16), 21, 19));
      final int index = i;
      cboxGroup[i].addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(ActionEvent e)  {
           CheckboxClicked(e,index);
        }
      });
    }
  }

  void adjustCheckBoxGroup(){
    for(int i=0; i<cboxGroup.length; i++){
      this.remove(cboxGroup[i]);
    }
    currDisplayRecords = currQueryPanel.getDisplayingRecords();
    int dispRecCount = currDisplayRecords.size();
    for(int i=0; i<dispRecCount; i++){
      cboxGroup[i].setSelected(false);
      this.add(cboxGroup[i], null);
    }
  }

  void refreshDataTable(){
    if(currQueryPanel==null){
      initDataTable();
    }
    else{
      HashMap hm = (HashMap)util.ApplicationProperites.getProperties("gmtLcSearchConds");
      currQueryPanel.resetDataSoure(hm);
    }
    currQueryPanel.reload();
    adjustCheckBoxGroup();
    currQueryPanel.repaint();
  }

  GmtLcQuery.RecordsPool getCurrRecords(){
    return recPool;
  }

}