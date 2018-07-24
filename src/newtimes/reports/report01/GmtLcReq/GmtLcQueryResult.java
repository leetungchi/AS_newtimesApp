package newtimes.reports.report01.GmtLcReq;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.HashMap;
import java.util.Vector;
import java.text.DecimalFormat;
import database.datatype.Record;
import newtimes.*;


/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class GmtLcQueryResult extends JPanel {
  Frame1 frame;
  GmtLcQuery parent=null;
  JCheckBox[] cboxGroup = new JCheckBox[10];
  JButton btnPrint = new JButton();
  GmtLcListAbsPanel resultQueryPanel = null;
  JTable            resultQueryTable = null;
  Vector            currDisplayRecords = null;
  GmtLcQuery.RecordsPool outputRecs = null;
  JLabel jLabel1 = new JLabel();
  JLabel labAmount = new JLabel();
  double currTotalAmount = 0;
  private ReportEJBs.RepGMTLC.GMTLc gmtLcEJB=
      (ReportEJBs.RepGMTLC.GMTLc)util.ApplicationProperites.getProperties("gmtLcEJB");

  JTextField tfListNO = new JTextField();
  JTextField tfLcNO = new JTextField();
  JLabel jLabel2 = new JLabel();
  JLabel jLabel3 = new JLabel();
  //JLabel labListNO = new JLabel();
  String ListNO = null;
  String LcNO = null;
  static String listNo = null; //Add by Chloe

  //Modify by Chloe
  public GmtLcQueryResult(GmtLcQuery _parent, Frame1 _frame) {
    this(_parent, "", "", _frame);
  }

  //Modify by Chloe
  public GmtLcQueryResult(GmtLcQuery _parent, String listNO, String lcNO, Frame1 _frame) {
    frame = _frame;
    parent = _parent;
    ListNO = listNO;
    LcNO = lcNO;
    outputRecs = new GmtLcQuery.RecordsPool();
    try {
      jbInit();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }
  void jbInit() throws Exception {
    jLabel1.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel1.setForeground(new Color(10,36,106));
    jLabel1.setText("TOTAL AMOUNT:");
    jLabel1.setBounds(new Rectangle(500, 290, 100, 23));
    this.setBackground(new Color(204, 204, 225));
    //this.setBorder(BorderFactory.createEtchedBorder());
    //this.setMinimumSize(new Dimension(4, 21));
    this.setOpaque(true);
    this.setLayout(null);
    this.setSize(800,300);
    btnPrint.setBackground(Color.lightGray);
    btnPrint.setBounds(new Rectangle(320, 290, 172, 22));
    btnPrint.setFont(new java.awt.Font("Dialog", 1, 13));
    btnPrint.setForeground(Color.darkGray);
    btnPrint.setBorder(BorderFactory.createEtchedBorder());
    btnPrint.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnPrint_actionPerformed(e);
      }
    });
    btnPrint.setText("Print/Update");

    initCheckBoxGroup();
    labAmount.setBounds(new Rectangle(600, 290, 70, 23));
    labAmount.setFont(new java.awt.Font("Dialog", 1, 13));
    labAmount.setForeground(Color.black);
    labAmount.setDoubleBuffered(false);
    labAmount.setHorizontalAlignment(SwingConstants.TRAILING);
    labAmount.setHorizontalTextPosition(SwingConstants.TRAILING);
    labAmount.setText("");
    tfLcNO.setBounds(new Rectangle(275, 15, 101, 22));
    tfLcNO.setText("");
    tfLcNO.setFont(new java.awt.Font("Dialog", 1, 12));
    tfLcNO.setBorder(BorderFactory.createEtchedBorder());
    tfLcNO.setMinimumSize(new Dimension(4, 21));
    jLabel2.setFont(new java.awt.Font("Dialog", 1, 13));
    jLabel2.setForeground(new Color(10,36,106));
    jLabel2.setDoubleBuffered(false);
    jLabel2.setMinimumSize(new Dimension(4, 21));
    jLabel2.setText("List NO:");
    jLabel2.setBounds(new Rectangle(35, 15, 60, 22));
    jLabel3.setBounds(new Rectangle(218, 15, 55, 22));
    jLabel3.setText("LC NO:");
    jLabel3.setMinimumSize(new Dimension(4, 21));
    jLabel3.setFont(new java.awt.Font("Dialog", 1, 13));
    jLabel3.setForeground(new Color(10,36,106));
    tfListNO.setBounds(new Rectangle(98, 15, 101, 22));
    tfListNO.setText("");
    tfListNO.setFont(new java.awt.Font("Dialog", 1, 12));
    tfListNO.setBorder(BorderFactory.createEtchedBorder());
    tfListNO.setMinimumSize(new Dimension(4, 21));

    //this.add(jLabel2, null);
    //this.add(labListNO, null);
    //this.add(tfLcNO, null);
    //this.add(jLabel3, null);
  }

  void initDataTable(HashMap hm){
    resultQueryPanel = new GmtLcListAbsPanel(this, hm);
    resultQueryTable = resultQueryPanel.getJtable();
    resultQueryPanel.setBackground(new Color(204, 204, 225));
    resultQueryPanel.setBounds(new Rectangle(35, 40, 730, 250));
    resultQueryPanel.firstPage();
    try{
      if (LcNO != null && !LcNO.equals("")) {
        Vector vec = resultQueryPanel.getDisplayingRecords();
        if (vec.size() > 0) {
          Record rec = (Record) vec.get(0);
          ListNO = (String) rec.get("LIST_NO");
        }
        else {
          ListNO = "";
        }
      }
      else if (ListNO != null && !ListNO.equals("")) {
        LcNO = "";
      }
      else {
        String depCode = (String) util.PublicVariable.USER_RECORD.get(
            "USR_DEP_CODE");
        ListNO = gmtLcEJB.listNO(depCode);
        LcNO = "";
      }
    }
    catch(Exception exp){
      ListNO="";
      LcNO = "";
      exp.printStackTrace();
    }
    finally{
      tfListNO.setText(ListNO);
      tfLcNO.setText(LcNO);
    }

    this.add(resultQueryPanel, null);
    this.add(btnPrint, null);
    this.add(jLabel1, null);
    this.add(labAmount, null);
    this.add(jLabel2, null);
    this.add(tfListNO, null);
    this.add(tfLcNO, null);
    this.add(jLabel3, null);
  }

  void btnPrint_actionPerformed(ActionEvent e){
    //java.awt.Cursor tCur = parent.parent.getCursor();
    //parent.parent.setCursor(new java.awt.Cursor(java.awt.Cursor.WAIT_CURSOR));

    if(outputRecs!=null && outputRecs.getAllKeys().size()>0){
      Vector keyLists = new Vector(outputRecs.getAllKeys());
      String user = null;
      try{
        user = (String)util.PublicVariable.USER_RECORD.get("USR_CODE");
        gmtLcEJB.updateSTY(keyLists,tfListNO.getText().trim(), tfLcNO.getText().trim(),user);
        //todo:print facility. Add by Chloe
        this.listNo = tfListNO.getText().trim();
        frame.showPanel(new newtimes.reports.report01.GmtLcReq.GmtLcQueryReport(frame));
      }
      catch(Exception exp){
        exp.printStackTrace();
      }
      resultQueryPanel.reload();
      this.repaint();
    }
    //parent.parent.setCursor(tCur);
  }

  void refreshDataTable(){
    GmtLcQuery.RecordsPool addonRecs = parent.getCurrRecords();
    //System.out.println("New Add Records:"+addonRecs);
    if(addonRecs!=null)
      outputRecs.addAll(addonRecs.getAllKeys());

    GmtLcQuery.RecordsPool availRecs = parent.getAvailRecords();
    //System.out.println("Available Records:"+availRecs);
    if(availRecs!=null && availRecs.keyLists().size()>0){
      Vector keyLists = availRecs.keyLists();
      HashMap hm = new HashMap();
      hm.put("STY_SEQ_LIST", keyLists.get(0));
      //System.out.println("Query Conditions:"+hm);
      if (resultQueryPanel == null) {
        initDataTable(hm);
      }
      else {
        resultQueryPanel.resetDataSoure(hm);
      }
      resultQueryPanel.reload();
      adjustCheckBoxGroup();
      currTotalAmount = totalAmount();
      labAmount.setText(this.formattedTotal());
      resultQueryPanel.repaint();
    }
  }

  void adjustCheckBoxGroup(){
    for(int i=0; i<cboxGroup.length; i++){
      this.remove(cboxGroup[i]);
    }
    currDisplayRecords = resultQueryPanel.getDisplayingRecords();
    int dispRecCount = currDisplayRecords.size();
    for(int i=0; i<dispRecCount; i++){
      this.add(cboxGroup[i], null);
      String key=null;
      try{
        Record rec = (Record)currDisplayRecords.get(i);
        key = rec.get("STY_SEQ").toString();
      }
      catch(Exception exp){
        exp.printStackTrace();
      }

      if(outputRecs.contains(key)){
        cboxGroup[i].setSelected(true);
      }
      else{
        cboxGroup[i].setSelected(false);
      }
    }
  }

  void initCheckBoxGroup(){
    for(int i=0; i<cboxGroup.length; i++){
      cboxGroup[i] = new JCheckBox();
      cboxGroup[i].setBackground(new Color(204, 204, 225));
      cboxGroup[i].setBorder(BorderFactory.createEtchedBorder());
      cboxGroup[i].setText("");
      cboxGroup[i].setBounds(new Rectangle(14, 64+(i*16), 21, 19));
      final int index = i;
      //cboxGroup[i].addItemListener(new java.awt.event.ItemListener() {
      //  public void itemStateChanged(ItemEvent e) {
      //     CheckboxClicked(e,index);
      //  }
      //});
      cboxGroup[i].addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(ActionEvent e) {
           CheckboxClicked(e,index);
        }
      });

    }
  }

  void CheckboxClicked(ActionEvent e, final int index) {
    Record rec = null;
    String key=null;
    double amt = 0.0;
    try{
      rec = (Record)currDisplayRecords.get(index);
      key = rec.get("STY_SEQ").toString();
      amt = rec.getDouble("AMOUNT_C");
    }
    catch(Exception exp){
      exp.printStackTrace();
    }
    if(cboxGroup[index].isSelected()){
      outputRecs.add(key);
      currTotalAmount += amt;
    }
    else{
      outputRecs.remove(key);
      currTotalAmount -= amt;
    }
    System.out.println("amt:"+amt+", total:"+this.formattedTotal());
    labAmount.setText(this.formattedTotal());

    System.out.println("outputRecs:"+outputRecs);
    Vector testVec = outputRecs.keyLists();
    if(testVec.size()>0){
      System.out.println("STY_SEQ:" + testVec.get(0));
      //System.out.println("QTY_SEQ:" + testVec.get(1));
    }
  }

  double totalAmount(){
    Vector keyLists = outputRecs.keyLists();
    HashMap hm = new HashMap();
    if(keyLists.size()>0){
      hm.put("STY_SEQ_LIST", keyLists.get(0));
    }
    else{
      hm.put("STY_SEQ_LIST", "");
    }

    double total = 0;
    try{
      total = gmtLcEJB.totalAmount(hm);
    }
    catch(Exception exp){
      exp.printStackTrace();
    }
    finally{
      return total;
    }
  }

  String formattedTotal(){
    return new DecimalFormat("###,###,##0.##").format(currTotalAmount);
  }

}
