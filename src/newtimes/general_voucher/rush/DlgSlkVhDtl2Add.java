package newtimes.general_voucher.rush;

import java.awt.*;
import javax.swing.*;
import exgui.*;
import java.awt.event.*;
import java.util.*;
import database.datatype.Record;
/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class DlgSlkVhDtl2Add extends JDialog {
  JPanel panel1 = new JPanel();
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel1 = new BlueBkgWhiteCharLabel();
  JButton btnOK = new JButton();
  JButton btnExit = new JButton();
  Panel2List pnlList = null;
  public Vector vct2add=null;
  Vector vct2List=null;
  java.text.DateFormat df=new java.text.SimpleDateFormat("yyyy/MM/dd");
  public DlgSlkVhDtl2Add(Frame frame, String title, boolean modal,Vector _vct2List) {
    super(frame, title, modal);
    try {
      vct2List=_vct2List;
      jbInit();
      pack();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }

  }
  class DbTmp extends exgui.ultratable.PagedDataFactoryAdapter{
    public Vector getRecords(int bgn,int rowcount)throws Exception{
      return vct2List;
    }
  }
  public DlgSlkVhDtl2Add() {
    this(null, "", false,null);
  }

  private void jbInit() throws Exception {
    panel1.setLayout(null);
    StringBuffer sb=new StringBuffer();
    database.datatype.Record rec2test=(database.datatype.Record)vct2List.get(0);
    sb.append("VH#:");
    sb.append(rec2test.get(1).toString());
    sb.append(" DATE:");sb.append(df.format(rec2test.get(3)));
    sb.append(" ,Please Select Rows To Add To Rush");
    blueBkgWhiteCharLabel1.setText(sb.toString() );
    blueBkgWhiteCharLabel1.setBounds(new Rectangle(0, 15, 700, 25));
    btnOK.setBounds(new Rectangle(138, 391, 146, 26));
    btnOK.setFont(new java.awt.Font("Dialog", 1, 12));
    btnOK.setText("OK,ADD TO RUSH");
    btnOK.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnOK_actionPerformed(e);
      }
    });
    btnExit.setText("EXIT");
    btnExit.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnExit_actionPerformed(e);
      }
    });
    btnExit.setBounds(new Rectangle(435, 391, 98, 26));
    btnExit.setFont(new java.awt.Font("Dialog", 1, 12));
    btnExit.setForeground(Color.red);
    util.InsertionOrderedHashMap iso=new util.InsertionOrderedHashMap();
    iso.put(" ","VH_SEQ");
    iso.put("ACC#","VH_ACCOUNT");
    iso.put("  ¬ì¥Ø¦WºÙ  ","ACC_TW_NAME");
    iso.put("D/C","VH_DC");
    iso.put("AMT","VH_AMT");
    iso.put("  EXPLAN      ","INV_DESC");

    pnlList =new Panel2List( new DbTmp(),999999,iso,new Hashtable());
    pnlList.setBounds(new Rectangle(17, 50, 664, 315));
    getContentPane().add(panel1);
    panel1.add(blueBkgWhiteCharLabel1, null);
    panel1.add(btnOK, null);
    panel1.add(btnExit, null);
    panel1.add(pnlList, null);
    pnlList.firstPage();
  }

  class Panel2List extends processhandler.template.PnlTableEditor{
    public Panel2List(exgui.ultratable.PagedDataFactory pagedDataFxy,
                      int rowCounts,util.InsertionOrderedHashMap columnMapping,
                     java.util.Hashtable object2StringConvertor){
        super(pagedDataFxy, rowCounts, columnMapping, object2StringConvertor);
        getLowerRightPanel().removeAll();
        jbtn1st.setVisible(false);
        jbtnNext.setVisible(false);
        jbtnPrev.setVisible(false);
        jbtnLast.setVisible(false);
    }
    public void doPrint(){}
    public void makeTable(Vector vct){
      super.makeTable(vct);
      getJtable().getColumnModel().getColumn(0).setPreferredWidth(20);
      getJtable().getColumnModel().getColumn(1).setPreferredWidth(90);
      getJtable().getColumnModel().getColumn(2).setPreferredWidth(130);
      getJtable().getColumnModel().getColumn(3).setPreferredWidth(25);
      getJtable().getColumnModel().getColumn(4).setPreferredWidth(100);
      getJtable().getColumnModel().getColumn(5).setPreferredWidth(230);
    }
    public int getEachPageRowCount(){return _rowCounts;}
    public Hashtable getObject2StringConvertor() {return klmObjKvtHt;}
    public util.InsertionOrderedHashMap getHeadColumnMap(){return tblHeadColumn;}
    public exgui.ultratable.PagedDataFactory getPagedDataFactory(){return dbHandler;}
    public Record setObject2Record(Record rec,int col,Object obj){return null;}
    public void refineEditors(exgui.ultratable.MultiEditorJTable me ){
    }
  }

  void btnOK_actionPerformed(ActionEvent e) {
    int rows[]=pnlList.getJtable().getSelectedRows();
    if(rows.length==0){
      exgui.verification.VerifyLib.showAlert("Please Select Row(s) To Add To Rush",
                                             "Please Select Row(s)");
      return;
    }
    vct2add=new Vector();
    for(int i=0;i<rows.length;i++){
      int rowpos=rows[i];
      database.datatype.Record rec2add=(database.datatype.Record)pnlList.getDisplayingRecords().get(rowpos);
      vct2add.add(rec2add);
    }
    this.dispose();
  }

  void btnExit_actionPerformed(ActionEvent e) {
    vct2add=null;
    this.dispose();
  }

  public Vector getVct2add()
  {
     return vct2add;
  }
}
