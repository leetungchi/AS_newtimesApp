package newtimes.accounting.debit_note;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.Vector ;
/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class DlgSelectBuyerName extends JDialog {
  JPanel panel1 = new JPanel();
  JComboBox cbxBuyerName = new JComboBox();
  JButton btnOK = new JButton();
  Vector vct;
  exgui.DataBindJCombobox DbJcbxcbxBuyerName=null;
  public DlgSelectBuyerName(Frame frame, String title, boolean modal,Vector vct2select) {
    super(frame, title, modal);
    try {
      vct=vct2select;
      jbInit();
      pack();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }

  public DlgSelectBuyerName() {
    this(null, "", false,null);
  }

  private void jbInit() throws Exception {
    panel1.setLayout(null);
    cbxBuyerName.setBounds(new Rectangle(23, 19, 267, 26));
    btnOK.setBounds(new Rectangle(94, 59, 106, 28));
    btnOK.setFont(new java.awt.Font("Dialog", 1, 11));
    btnOK.setText("OK");
    btnOK.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnOK_actionPerformed(e);
      }
    });
    this.setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
    getContentPane().add(panel1);
    panel1.add(cbxBuyerName, null);
    panel1.add(btnOK, null);
     DbJcbxcbxBuyerName = new exgui.DataBindJCombobox(
                               cbxBuyerName,
                               "DBNT_BYMKR_NAME",
                               vct,
                               "DBNT_BYMKR_NAME",
                               "DBNT_BYMKR_NAME",
                                null,
                               "NONE","");

  }

  void btnOK_actionPerformed(ActionEvent e) {
    this.hide();
  }
}
