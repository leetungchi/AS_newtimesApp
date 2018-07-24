package newtimes.material;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
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

public class DelMaterialShort extends JPanel {
  JPanel jPanel1= new JPanel();
  JPanel parent=null;
  private JLabel jLabel11 = new JLabel();
  private DelMtrListAbsPanel DelMtrTablePanel = null;
  private JTable delMtrListTable = null;

  private newtimes.material.CONST.MTR.APP.SEARCH MTR_COND=null;
  private newtimes.material.CONST.MTRDTL.APP.LIST MTRDTL_COND=null;
  BorderLayout borderLayout1 = new BorderLayout();

  public DelMaterialShort(JPanel _parent) {
    try {
      parent = _parent;
      jbInit();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }
  void jbInit() throws Exception {
    this.setLayout(borderLayout1);
    this.setBackground(new Color(204, 204, 225));
    this.setSize(new Dimension(710, 450));
    jPanel1.setLayout(null);
    jPanel1.setBackground(new Color(204, 204, 225));
    jLabel11.setBounds(new Rectangle(117, 15, 566, 24));
    jLabel11.setHorizontalAlignment(SwingConstants.CENTER);
    jLabel11.setBorder(BorderFactory.createEtchedBorder());
    jLabel11.setForeground(new Color(10,36,106));
    jLabel11.setFont(new java.awt.Font("Dialog", 1, 13));
    jLabel11.setText("      ============  Deleted Material List  ============      ");
    //delMtrListTable
    jPanel1.add(jLabel11, null);
    initMtrListTable();
    this.add(jPanel1, BorderLayout.CENTER);
  }

  void initMtrListTable(){
    DelMtrTablePanel = new DelMtrListAbsPanel();
    delMtrListTable = DelMtrTablePanel.getJtable();
    DelMtrTablePanel.setBounds(new Rectangle(12, 65, 750, 455));
    delMtrListTable.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseReleased(MouseEvent e) {
         delMtrListTable_mouseReleased(e);
      }
    });
    jPanel1.add(DelMtrTablePanel, null);
  }

  void delMtrListTable_mouseReleased(MouseEvent e) {
    int Row = delMtrListTable.getSelectedRow();
    String mtrNO  = ((String)delMtrListTable.getValueAt(Row,0)).trim();
    String mtrDelFlag = null;
    boolean isMtrDelelted = ((Boolean)delMtrListTable.getValueAt(Row,3)).booleanValue();
    if(isMtrDelelted)
      mtrDelFlag = "0";
    else
      mtrDelFlag = "1";

    HashMap delMtrDtlConds = new HashMap();
    delMtrDtlConds.put(MTR_COND.MTR_NO, mtrNO);
    delMtrDtlConds.put(MTR_COND.DELETE_FLAG, "0");
    delMtrDtlConds.put("mtrDelFlag", mtrDelFlag);
    util.ApplicationProperites.setProperties(MTRDTL_COND.DELELTED_CONDS, delMtrDtlConds);
    if(parent instanceof MaterialList){
      if(Row>-1){
        java.util.Vector recs = DelMtrTablePanel.getDisplayingRecords();
        ((MaterialList)parent).showDelMtrDtlList((Record)recs.get(Row));
      }
    }
  }

}
