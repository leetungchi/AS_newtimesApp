package newtimes.production.report;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class DlgListPriceDiff extends JDialog {
  JPanel panel1 = new JPanel();
  JScrollPane jScrollPane1 = new JScrollPane();
  JTextArea txtPrxDiffList = new JTextArea();
  JButton btnYes = new JButton();
  JLabel jLabel1 = new JLabel();
  JButton btnNo = new JButton();
  PnlQryPackingReports pnlMsg2Send;

  public DlgListPriceDiff(Frame frame, String title, boolean modal,PnlQryPackingReports _pnlMsg2Send) {
    super(frame, title, modal);
     pnlMsg2Send=_pnlMsg2Send;
    try {
      jbInit();
      pack();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }

  public DlgListPriceDiff() {
    this(null, "", false,null);
  }

  private void jbInit() throws Exception {
    panel1.setLayout(null);
    jScrollPane1.setBounds(new Rectangle(27, 58, 473, 243));
    txtPrxDiffList.setText("");
    this.setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
    btnYes.setBounds(new Rectangle(63, 332, 168, 34));
    btnYes.setFont(new java.awt.Font("Dialog", 1, 11));
    btnYes.setText("YES,Contiune Import");
    btnYes.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnYes_actionPerformed(e);
      }
    });
    jLabel1.setFont(new java.awt.Font("Dialog", 1, 11));
    jLabel1.setText("Below are Price Diff List:");
    jLabel1.setBounds(new Rectangle(23, 27, 471, 27));
    btnNo.setText("NO,Stop Importing");
    btnNo.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnNo_actionPerformed(e);
      }
    });
    btnNo.setFont(new java.awt.Font("Dialog", 1, 11));
    btnNo.setForeground(Color.red);
    btnNo.setBounds(new Rectangle(305, 332, 146, 34));
    getContentPane().add(panel1);
    panel1.add(jScrollPane1, null);
    jScrollPane1.getViewport().add(txtPrxDiffList, null);
    panel1.add(btnYes, null);
    panel1.add(jLabel1, null);
    panel1.add(btnNo, null);
  }

  void btnYes_actionPerformed(ActionEvent e) {
   pnlMsg2Send.continueImportEvenPrxDiff=true;
   this.dispose();
  }

  void btnNo_actionPerformed(ActionEvent e) {
    pnlMsg2Send.continueImportEvenPrxDiff=false;
    this.dispose();
  }
}
