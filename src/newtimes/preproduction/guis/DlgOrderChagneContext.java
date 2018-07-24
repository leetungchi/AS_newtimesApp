package newtimes.preproduction.guis;

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

public class DlgOrderChagneContext extends JDialog {
  JPanel panel1 = new JPanel();
  JScrollPane jScrollPane1 = new JScrollPane();
  JTextArea txtOrderChagne = new JTextArea();
  JButton btnClose = new JButton();
  GridBagLayout gridBagLayout1 = new GridBagLayout();

  public DlgOrderChagneContext(Frame frame, String title, boolean modal) {
    super(frame, title, modal);
    try {
      jbInit();
      pack();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }

  public DlgOrderChagneContext() {
    this(null, "", false);
  }

  private void jbInit() throws Exception {
    panel1.setLayout(gridBagLayout1);
    txtOrderChagne.setFont(new java.awt.Font("DialogInput", 0, 12));
    txtOrderChagne.setText("");
    btnClose.setFont(new java.awt.Font("Dialog", 1, 11));
    btnClose.setText("CLOSE");
    btnClose.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnClose_actionPerformed(e);
      }
    });
    this.setModal(false);
    this.setResizable(true);
    getContentPane().add(panel1);
    panel1.add(jScrollPane1,  new GridBagConstraints(0, 0, 1, 1, 1.0, 1.0
            ,GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(17, 11, 0, 9), 535, 356));
    jScrollPane1.getViewport().add(txtOrderChagne, null);
    panel1.add(btnClose,  new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(8, 194, 20, 204), 90, 9));
  }

  void btnClose_actionPerformed(ActionEvent e) {
     this.dispose();
  }
}
