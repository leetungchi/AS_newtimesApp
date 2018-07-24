package newtimes;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class FrameOffShore extends JFrame {
  JPanel contentPane;
  JLabel jLabel1 = new JLabel();
  String centers[]=new String[]{"PACIFICWAY","NTFE","INDIA","BEIJING"};
  JComboBox cbxCenter = new JComboBox(centers);
  JComboBox cbxCenterOffshore = new JComboBox(centers);
  JLabel jLabel2 = new JLabel();
  JRadioButton rdoInpec = new JRadioButton();
  JRadioButton rdoCoOperation = new JRadioButton();

  //Construct the frame
  public FrameOffShore() {
    enableEvents(AWTEvent.WINDOW_EVENT_MASK);
    try {
      jbInit();
    }
    catch(Exception e) {
      e.printStackTrace();
    }
  }

  //Component initialization
  private void jbInit() throws Exception  {
    contentPane = (JPanel) this.getContentPane();
    rdoInpec.setFont(new java.awt.Font("Dialog", 1, 11));
    rdoInpec.setSelected(true);
    rdoInpec.setText("Inspection");
    rdoInpec.setBounds(new Rectangle(26, 114, 108, 28));
    jLabel1.setForeground(Color.red);
    jLabel1.setText("Center");
    jLabel1.setBounds(new Rectangle(32, 50, 68, 24));
    contentPane.setLayout(null);
    this.setSize(new Dimension(400, 300));
    this.setTitle("Frame Title");
    cbxCenter.setBounds(new Rectangle(111, 50, 146, 21));
    cbxCenterOffshore.setBounds(new Rectangle(113, 83, 146, 21));
    cbxCenterOffshore.addItemListener(new java.awt.event.ItemListener() {
      public void itemStateChanged(ItemEvent e) {
        cbxCenterOffshore_itemStateChanged(e);
      }
    });
    jLabel2.setBounds(new Rectangle(18, 82, 90, 26));
    jLabel2.setText("Offshore Center");
    jLabel2.setForeground(Color.red);
    rdoCoOperation.setBounds(new Rectangle(26, 144, 108, 28));
    rdoCoOperation.setFont(new java.awt.Font("Dialog", 1, 11));
    rdoCoOperation.setText("CO-Operate");
    contentPane.add(cbxCenter, null);
    contentPane.add(jLabel2, null);
    contentPane.add(jLabel1, null);
    contentPane.add(rdoInpec, null);
    contentPane.add(rdoCoOperation, null);
    contentPane.add(cbxCenterOffshore, null);
  }

  //Overridden so we can exit when window is closed
  protected void processWindowEvent(WindowEvent e) {
    super.processWindowEvent(e);
    if (e.getID() == WindowEvent.WINDOW_CLOSING) {
      System.exit(0);
    }
  }

  void cbxCenterOffshore_itemStateChanged(ItemEvent e) {
     if(cbxCenter.getSelectedItem().equals(cbxCenterOffshore.getSelectedItem()) ){
       rdoCoOperation.setEnabled(false);
       rdoInpec.setEnabled(false);
     }else{
       rdoCoOperation.setEnabled(true);
       rdoInpec.setEnabled(true);
     }
  }
}
