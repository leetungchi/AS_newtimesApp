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

public class MaterialShort extends JPanel {
  JPanel parent= null;
  JPanel jPanel1= new JPanel();
  private JLabel jLabel11 = new JLabel();
  private JButton[] EditBtnGroup = new JButton[19];
  private MtrListAbsPanel MtrTablePanel = new MtrListAbsPanel(this);
  private JTable mtrListTable = MtrTablePanel.getJtable();
  private newtimes.material.CONST.MTR.APP.SEARCH MTR_COND=null;
  private newtimes.material.CONST.MTR.EJB MTR_EJB=null;
  private newtimes.material.CONST.MTRDTL.APP.LIST MTRDTL_COND=null;
  private newtimes.material.CONST.MTRHIST.APP.LIST MTRHIST_COND=null;
  private String DELETE_FLAG = newtimes.material.CONST.COMMON.DELETE_FLAG;


  public MaterialShort(JPanel parent) {
    try {
      this.parent = parent;
      jbInit();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }
  void jbInit() throws Exception {
    this.setLayout(new GridBagLayout());
    this.setBackground(new Color(204, 204, 225));
    this.setSize(new Dimension(710, 450));
    jPanel1.setLayout(null);
    jPanel1.setBackground(new Color(204, 204, 225));

    jLabel11.setBounds(new Rectangle(117, 15, 566, 24));
    jLabel11.setHorizontalAlignment(SwingConstants.CENTER);
    jLabel11.setBorder(BorderFactory.createEtchedBorder());
    jLabel11.setForeground(new Color(10,36,106));
    jLabel11.setFont(new java.awt.Font("Dialog", 1, 13));
    jLabel11.setText("      ============  Material List  ============      ");


    int startY = 90;
    for(int i=0; i<19 ;i++){
      EditBtnGroup[i] = new JButton();
      EditBtnGroup[i].setText("Edit");
      EditBtnGroup[i].setBounds(new Rectangle(0, startY, 38, 20));
      startY += 20;
      EditBtnGroup[i].setFont(new java.awt.Font("Dialog", 0, 10));
      EditBtnGroup[i].setBorder(BorderFactory.createEtchedBorder());
      final int index = i;
      EditBtnGroup[i].addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseReleased(MouseEvent e) {
          EditClick(e, index);
        }
      });
    }
    MtrTablePanel.setBounds(new Rectangle(40, 65, 700, 455));
    mtrListTable.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseReleased(MouseEvent e) {
        mtrListTable_mouseReleased(e);
      }
    });


    jPanel1.add(jLabel11, null);

    this.add(jPanel1,   new GridBagConstraints(0, 0, 1, 1, 1.0, 1.0
            ,GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(2, 5, 0, 1), 700, 360));

    //add by Chloe
    if (CONST.pageFlag) {
      CONST.pageFlag = false;
      int _rowCounts = Integer.parseInt(util.ApplicationProperites.getProperties("_rowCounts").toString());
      int _rowPosition = Integer.parseInt(util.ApplicationProperites.getProperties("_rowPosition").toString());
      //MtrTablePanel._rowPosition= _rowPosition;
      //MtrTablePanel._rowCounts =_rowCounts;
      MtrTablePanel.goPage(_rowPosition,_rowCounts,false);
      /*
      int skip = Math.abs(_rowPosition/_rowCounts);
      for (int i = 0; i < skip; i++) {
        MtrTablePanel.nextPage();
      }*/
    }else{
      MtrTablePanel.firstPage();
    }
    jPanel1.add(MtrTablePanel, null);
    adjustEditBtn();
  }


  void mtrListTable_mouseReleased(MouseEvent e) {
    //Setup conditions HashMap
    try{
      //add by Chloe
      CONST.detailPageFlag = false;
      util.ApplicationProperites.removeProperites("_rowCounts2");
      util.ApplicationProperites.removeProperites("_rowPosition2");
      util.ApplicationProperites.setProperties("_rowCounts", new Integer(MtrTablePanel._rowCounts));
      util.ApplicationProperites.setProperties("_rowPosition", new Integer(MtrTablePanel._rowPosition));

      if (parent instanceof MaterialList) {
        int recIndex = mtrListTable.getSelectedRow();
        if (recIndex > -1) {
          java.util.Vector recs = MtrTablePanel.getDisplayingRecords();
          Record mtrRec = (Record) recs.get(recIndex);
          String mtrNO = ( (String) mtrListTable.getValueAt(recIndex, 0)).trim();
          HashMap mtrDtlConds = new HashMap();
          mtrDtlConds.put(MTR_COND.MTR_NO, mtrNO);
          mtrDtlConds.put(DELETE_FLAG, "1");
          util.ApplicationProperites.setProperties(MTRDTL_COND.CONDITIONS,
              mtrDtlConds);
          HashMap mtrHistConds = new HashMap();
          mtrHistConds.put(MTR_COND.MTR_NO, mtrNO);
          mtrHistConds.put(MTR_COND.CEN_CODE, mtrRec.get(MTR_EJB.CEN_CODE));
          util.ApplicationProperites.setProperties(MTRHIST_COND.CONDITIONS,
              mtrHistConds);
          ( (MaterialList) parent).showDtlHistPanel(mtrRec);
        }
      }
    }
    catch(Exception ep){
      ep.printStackTrace();
    }
  }

  void EditClick(MouseEvent e, int index) {
    if(parent instanceof MaterialList){
      if(index>-1){
        java.util.Vector recs = MtrTablePanel.getDisplayingRecords();
        if(recs.size()>index){
          util.ApplicationProperites.setProperties("_rowCounts", new Integer(MtrTablePanel._rowCounts));
          util.ApplicationProperites.setProperties("_rowPosition", new Integer(MtrTablePanel._rowPosition));
          ( (MaterialList) parent).showMaterialLong( (Record) recs.get(index));
        }
      }
    }
  }

  void adjustEditBtn(){
    for(int i=0; i<19; i++){
      jPanel1.remove(EditBtnGroup[i]);
    }
    int dispRecCount = MtrTablePanel.getDisplayingRecords().size();
    for(int i=0; i<dispRecCount; i++){
      jPanel1.add(EditBtnGroup[i], null);
    }
    jPanel1.repaint();
    jPanel1.validate();
  }

}
