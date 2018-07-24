package newtimes.accounting.debit_note;

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

public class DlgListDebitNoteBuyerName extends JDialog {
  JPanel panel1 = new JPanel();
  BorderLayout borderLayout1 = new BorderLayout();
  PnlListDebitNoteBuyerName pnlListDebitNoteBuyerName1 = new PnlListDebitNoteBuyerName();

  public DlgListDebitNoteBuyerName(Frame frame, String title, boolean modal) {
    super(frame, title, modal);
    try {
      jbInit();
      pack();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }

  public DlgListDebitNoteBuyerName() {
    this(null, "", false);
  }

  private void jbInit() throws Exception {
    panel1.setLayout(borderLayout1);
    getContentPane().add(panel1);
    panel1.add(pnlListDebitNoteBuyerName1, BorderLayout.CENTER);
    pnlListDebitNoteBuyerName1.parentDlg=this;
  }
}
