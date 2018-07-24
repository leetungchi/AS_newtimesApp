package newtimes.preproduction.guis;

import javax.swing.*;
import java.awt.*;

import java.util.Vector;
import java.awt.event.*;
/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class PopLabel extends JFrame {
  JComboBox LblComboBox = new JComboBox();
  JLabel jLabel1 = new JLabel();
  JLabel jLabel2 = new JLabel();
  JButton okBtn = new JButton();
  JButton exitBtn = new JButton();
  String label_content;
  Vector label_name = new Vector();
  JFrame frame;
  JTextField textfield;
  public PopLabel(JFrame frame,JTextField textfield) {
    try {
         this.frame=frame;
         this.textfield=textfield;
         label_content = "ANNE KLEIN,ANNE KLEIN II,ARIA,BETSEY JOHNSON,BETSEYVILLE,CAROLE HOCHMAN,CAROLE HOCHMAN NEW YORK,CELESTIAL DREAMS,CHAPS,CLIMATE RIGHT,CO. ELLEN TRACY,CROFT & BARROW,CUDDL DUDS,CUDDL DUDS SLEEPWEAR,DKNY,DREAM CAFE,EARTH ANGELS,EILEEN WEST,";
         label_content = label_content+"ELLEN TRACY,ESPRIT,FRANCESCA'S COLLECTIONS,GEORGE,GRAND & ESSEX,HALSTON,KENSIE,LANZ OF SALZBURG,LAYLA,LAZO,LIZ CLAIBORNE,MAIDENFORM,MIDNIGHT CAROLE HOCHMAN,MIX IT,MODERN LUXURY,NICOLE BY NICOLE MILLER,";
         label_content = label_content+"NICOLE MILLER,NO BOUNDARIES,OLSENBOYE,OSCAR DE LA RENTA,PLANET SLEEP,SECRET TREASURES,SIMPLY VERA,ST. EVE,UNBRANDED";
      jbInit();
      setSize(400,300);
      setLocation(frame.getX()+200,frame.getY()+150);
      repaint();
      setVisible(true);
      frame.setEnabled(false);
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }

  void jbInit() throws Exception {
    this.getContentPane().setLayout(null);
    this.setTitle("");
    jLabel1.setFont(new java.awt.Font("Dialog", 1, 11));
    jLabel1.setText("Label :");
    jLabel1.setBounds(new Rectangle(43, 112, 36, 17));
    LblComboBox.setAlignmentY((float) 0.5);
    LblComboBox.setBounds(new Rectangle(88, 106, 260, 29));
    jLabel2.setFont(new java.awt.Font("Dialog", 1, 15));
    jLabel2.setForeground(Color.black);
    jLabel2.setToolTipText("");
    jLabel2.setHorizontalAlignment(SwingConstants.CENTER);
    jLabel2.setText("Select Label Name for MM Dep");
    jLabel2.setBounds(new Rectangle(18, 33, 362, 23));
    okBtn.setBounds(new Rectangle(96, 188, 79, 25));
    okBtn.setToolTipText("");
    okBtn.setSelected(false);
    okBtn.setText("OK");
    okBtn.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        okBtn_actionPerformed(e);
      }
    });
    exitBtn.setBounds(new Rectangle(242, 185, 82, 25));
    exitBtn.setToolTipText("");
    exitBtn.setText("Exit");
    exitBtn.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        exitBtn_actionPerformed(e);
      }
    });
    this.getContentPane().add(exitBtn, null);
    this.getContentPane().add(okBtn, null);
    this.getContentPane().add(jLabel2, null);
    this.getContentPane().add(jLabel1, null);
    this.getContentPane().add(LblComboBox, null);
    LblComboBox.addItem("");
    String[] lbl = label_content.split(",");
    for (int i=0;i<lbl.length;i++) {
         LblComboBox.addItem(lbl[i]);
    }
    LblComboBox.setSelectedItem(textfield.getText());
  }

  void exitBtn_actionPerformed(ActionEvent e) {
       frame.setEnabled(true);
       this.dispose();
  }

  void okBtn_actionPerformed(ActionEvent e) {
       textfield.setText(LblComboBox.getSelectedItem().toString());
       frame.setEnabled(true);
       this.dispose();
  }
}
