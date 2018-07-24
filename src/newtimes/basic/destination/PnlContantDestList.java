package newtimes.basic.destination;

import java.awt.*;
import javax.swing.*;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class PnlContantDestList extends JPanel {
  JPanel pnl2setDetList = new JPanel();
  BorderLayout borderLayout1 = new BorderLayout();
  JLabel jLabel1 = new JLabel();
  JLabel jLabel2 = new JLabel();
  JScrollPane jScrollPane1 = new JScrollPane();

  public PnlContantDestList() {
    try {
      jbInit();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }

  void jbInit() throws Exception {
    this.setLayout(null);
    pnl2setDetList.setBounds(new Rectangle(10, 75, 772, 449));
    pnl2setDetList.setLayout(borderLayout1);
    jLabel1.setFont(new java.awt.Font("Dialog", 1, 13));
    jLabel1.setForeground(new Color(10,36,106));
    jLabel1.setBorder(BorderFactory.createEtchedBorder());
    jLabel1.setHorizontalAlignment(SwingConstants.CENTER);
    jLabel1.setText("      ============  Destination List,Click Row To Edit  ============      ");
    jLabel1.setBounds(new Rectangle(70, 17, 566, 24));
    jLabel2.setBackground(new Color(143, 143, 188));
    jLabel2.setOpaque(true);
    jLabel2.setText("");
    jLabel2.setBounds(new Rectangle(0, 539, 799, 29));
    this.setBackground(new Color(204, 204, 225));
    pnl2setDetList.add(jScrollPane1, BorderLayout.CENTER);
    PnlListDest pnl=new PnlListDest();
    /*
    util.InsertionOrderedHashMap iso=new util.InsertionOrderedHashMap();
    iso.put("destination Name","dest_name");
    PnlListDestsWithButton  pnl=
       new PnlListDestsWithButton(DB_Destinations.getInstance(),10,iso,
                                   new java.util.Hashtable(),"Click To Edit History",". . .");
    */
    pnl.setPreferredSize(new java.awt.Dimension(700,400));
    pnl.setBounds(0,0,700,400);
    jScrollPane1.getViewport().add(pnl,BorderLayout.CENTER);
    //pnl2setDetList.add(pnl,BorderLayout.CENTER);
    this.add(jLabel1, null);
    this.add(jLabel2, null);
    this.add(pnl2setDetList, null);
    pnl.firstPage();
    pnl2setDetList.validate();
  }
}
