package newtimes.basic.city;

import java.awt.*;
import newtimes.*;
import javax.swing.*;
import java.awt.event.*;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author unascribed
 * @version 1.0
 */

public class CityList extends JPanel {
  Frame1 frame;
  private JLabel textAreaStatus = new JLabel();
  private JButton butnExit = new JButton();
  private JLabel jLabel1 = new JLabel();
  private CityAbsTable cityAbsTable = new CityAbsTable();
  private JTable jTable = cityAbsTable.getJtable();

  public CityList(Frame1 _frame) {
    frame = _frame;
    try {
      jbInit();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }
  void jbInit() throws Exception {
    if (CityEdit.isExit) {
      int _rowCounts = Integer.parseInt(util.ApplicationProperites.getProperties("_rowCounts").toString());
      int _rowPosition = Integer.parseInt(util.ApplicationProperites.getProperties("_rowPosition").toString());
      cityAbsTable.goPage(_rowPosition,_rowCounts,true);
      /*
      int skip = Math.abs(_rowPosition/_rowCounts);
      for (int i = 0; i < skip; i++) {
        cityAbsTable.nextPage();
      }*/
    }

    textAreaStatus.setBackground(new Color(143, 143, 188));
    textAreaStatus.setBorder(null);
    textAreaStatus.setOpaque(true);
    textAreaStatus.setBounds(new Rectangle(0, 540, 800, 30));
    this.setLayout(null);
    this.setSize(800,600);
    this.setBackground(new Color(204, 204, 225));
    butnExit.setBackground(Color.lightGray);
    butnExit.setBounds(new Rectangle(360, 503, 80, 25));
    butnExit.setFont(new java.awt.Font("Dialog", 1, 13));
    butnExit.setForeground(Color.darkGray);
    butnExit.setText("Exit");
    butnExit.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        butnExit_actionPerformed(e);
      }
    });
    jTable.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseReleased(MouseEvent e) {
        jTable_mouseReleased(e);
      }
    });
    jLabel1.setFont(new java.awt.Font("Dialog", 1, 13));
    jLabel1.setForeground(new Color(10,36,106));
    jLabel1.setBorder(BorderFactory.createEtchedBorder());
    jLabel1.setHorizontalAlignment(SwingConstants.CENTER);
    jLabel1.setText("      ============  City List  ============      ");
    jLabel1.setBounds(new Rectangle(117, 26, 566, 24));
    cityAbsTable.setBounds(new Rectangle(16, 82, 760, 406));
    this.add(textAreaStatus, null);
    this.add(jLabel1, null);
    this.add(butnExit, null);
    this.add(cityAbsTable, null);
  }

  void butnExit_actionPerformed(ActionEvent e) {
    setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
    CityEdit.isExit = false;
    util.ApplicationProperites.removeProperites("_rowCounts");
    util.ApplicationProperites.removeProperites("_rowPosition");

    util.ApplicationProperites.removeProperites("recDetail");
    frame.showPanel(new newtimes.basic.city.CitySearch(frame));
    setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
  }

  void jTable_mouseReleased(MouseEvent e) {
    java.util.HashMap hm = new java.util.HashMap();
    try{
      cityAbsTable.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
      util.ApplicationProperites.setProperties("_rowCounts", new Integer(cityAbsTable._rowCounts));
      util.ApplicationProperites.setProperties("_rowPosition", new Integer(cityAbsTable._rowPosition));
      int getRow = jTable.getSelectedRow();
      java.util.Vector vDetail = cityAbsTable.getDisplayingRecords();
      database.datatype.Record recDetail = (database.datatype.Record)vDetail.get(getRow);
      hm.put("recDetail",recDetail);
      util.ApplicationProperites.setProperties("recDetail",hm);
      newtimes.basic.city.CityEdit editPanel=new newtimes.basic.city.CityEdit(frame);
      editPanel.orgCityValue=recDetail.get("CITY_NAME");
      editPanel.orgCountryValue=recDetail.get("CITY_CNTY_NAME");
      editPanel.orgAreaValue=recDetail.get("CITY_AREA_PK");
      frame.showPanel(editPanel);
    }catch(Exception eRow){
      eRow.printStackTrace();
      util.ExceptionLog.exp2File(eRow,"error at get record."+hm.toString());
    } finally {
      cityAbsTable.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
    }
  }
}
