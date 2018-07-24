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

public class DelMatDetailList extends JPanel {
  private DelMtrDtlListAbsPanel DelMtrDtlPanel = null;
  private JTable delMtrDtlTable = null;

  private newtimes.material.CONST.MTR.APP.SEARCH MTR_COND=null;
  private newtimes.material.CONST.MTRDTL.APP.LIST MTRDTL_COND=null;

  JPanel jPanel1 = new JPanel();
  JLabel jLabel1 = new JLabel();
  JButton jButton1 = new JButton();
  GridBagLayout gridBagLayout1 = new GridBagLayout();

  public DelMatDetailList() {
    try {
      jbInit();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }
  void jbInit() throws Exception {
    this.setLayout(gridBagLayout1);
    this.setSize(new Dimension(710, 450));

    jLabel1.setBounds(new Rectangle(117, 15, 566, 24));
    jLabel1.setHorizontalAlignment(SwingConstants.CENTER);
    jLabel1.setBorder(BorderFactory.createEtchedBorder());
    jLabel1.setForeground(new Color(10,36,106));
    jLabel1.setFont(new java.awt.Font("Dialog", 1, 13));
    jLabel1.setText("      ============  Deleted Material Detail  ============      ");


    jButton1.setBackground(Color.lightGray);
    jButton1.setFont(new java.awt.Font("Dialog", 1, 12));
    jButton1.setBorder(BorderFactory.createEtchedBorder());
    jButton1.setBorderPainted(true);
    jButton1.setContentAreaFilled(true);
    jButton1.setText("Restore");
    jButton1.addActionListener(new DelMatDetailList_jButton1_actionAdapter(this));

    jPanel1.setLayout(null);
    jPanel1.setBackground(new Color(204, 204, 225));
    jPanel1.add(jLabel1, null);
    initMtrDetailTable();
    this.add(jPanel1,  new GridBagConstraints(0, 0, 1, 1, 1.0, 1.0
            ,GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 709, 449));
  }

  void initMtrDetailTable(){
    DelMtrDtlPanel = new DelMtrDtlListAbsPanel();
    DelMtrDtlPanel.setBounds(12, 55, 750, 323);
    delMtrDtlTable = DelMtrDtlPanel.getJtable();
    jPanel1.add(DelMtrDtlPanel, null);
    jPanel1.add(jButton1, null);
    DelMtrDtlPanel.getLowerRightPanel().setLayout(new FlowLayout(FlowLayout.RIGHT));
    DelMtrDtlPanel.getLowerRightPanel().add(jButton1, null);
  }

  public void RecRestore(){
    try{
      //modified by Chloe
      boolean isOk = DelMtrDtlPanel.confirmUpdate();
      if (isOk) {
        exgui2.InfoMessage.infoMessage(new JFrame(), "Restore Succeed.");
        DelMtrDtlPanel.reload();
      } else {
        exgui2.InfoMessage.infoMessage(new JFrame(), "Restore Failed.");
      }
    }
    catch(Exception e){
      e.printStackTrace();
    }
  }

  void jButton1_actionPerformed(ActionEvent e) {
    RecRestore();
  }
}

class DelMatDetailList_jButton1_actionAdapter implements java.awt.event.ActionListener {
  DelMatDetailList adaptee;

  DelMatDetailList_jButton1_actionAdapter(DelMatDetailList adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.jButton1_actionPerformed(e);
  }
}
