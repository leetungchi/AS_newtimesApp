package newtimes.reports.report01.GmtLcReq;

import java.awt.*;
import javax.swing.*;
import util.MiscFunc;
import newtimes.*;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class GmtLcQuery extends JPanel {
  Frame1 frame;
  GmtLcList parent=null;
  JTabbedPane jTabbedPane1 = new JTabbedPane();
  private GmtLcQueryCurrent jPanel1 = null;
  private GmtLcQueryResult  jPanel2 = null;
  RecordsPool availRecsPool = null;

  // Modify by Chloe
  public GmtLcQuery(GmtLcList _parent, Frame1 _frame) {
    frame = _frame;
    parent = _parent;
    availRecsPool = new RecordsPool();
    try {
      jbInit();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }
  void jbInit() throws Exception {
    jPanel1 = new GmtLcQueryCurrent(this);
    jPanel2 = new GmtLcQueryResult(this, frame);
    this.setBackground(new Color(204, 204, 225));
    this.setOpaque(true);
    this.setLayout(new GridBagLayout());
    this.setSize(800,400);
    jTabbedPane1.setTabPlacement(JTabbedPane.TOP);
    jTabbedPane1.setFont(new java.awt.Font("Dialog", 1, 13));
    jTabbedPane1.add(jPanel1, "Current Query");
    jTabbedPane1.add(jPanel2, "Result List");
    this.add(jTabbedPane1, new GridBagConstraints(0, 0, 1, 1, 1.0, 1.0
            ,GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 799, 399));
  }

  void refreshCurrQuery(){
    jTabbedPane1.setSelectedIndex(0);
    jPanel1.refreshDataTable();
  }

  void refreshResultQuery(){
    java.awt.Cursor tCur = parent.getCursor();
    parent.setCursor(new java.awt.Cursor(java.awt.Cursor.WAIT_CURSOR));
    jTabbedPane1.setSelectedIndex(1);
    jPanel2.refreshDataTable();
    parent.repaint();
    parent.setCursor(tCur);
  }
  void addCurrQueryRecs(RecordsPool currRecs){
    availRecsPool.addAll(currRecs.getAllKeys());
  }

  RecordsPool getAvailRecords(){
    return availRecsPool;
  }

  RecordsPool getCurrRecords(){
    if(jPanel1!=null)
      return jPanel1.getCurrRecords();
    else
      return null;
  }

  public static class RecordsPool{
    public RecordsPool(){
      keySet = new java.util.HashSet();
    }
    public void add(String key){
      keySet.add(key);
    }
    public void addAll(java.util.Collection keys){
      keySet.addAll(keys);
    }
    public void remove(String key){
      keySet.remove(key);
    }
    public java.util.Collection getAllKeys(){
      return keySet;
    }

    public boolean contains(String key){
      return keySet.contains(key);
    }

    public java.util.Vector keyLists(){
      Object[] keyArray = keySet.toArray();
      java.util.Vector vec = new java.util.Vector();
      if(keyArray.length>0){
        StringBuffer keyList = new StringBuffer();
        keyList.append( (String) keyArray[0]);
        for (int i = 1; i < keyArray.length; i++) {
          keyList.append(",");
          keyList.append( (String) keyArray[i]);
        }
        vec.add(keyList);
      }
      return  vec;
    }

    public String toString(){
      return keySet.toString();
    }

    private java.util.HashSet keySet;
  }
}