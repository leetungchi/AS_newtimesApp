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

public class DlgContainDebitNoteDetail extends JDialog {
  JPanel panel1 = new JPanel();
  BorderLayout borderLayout1 = new BorderLayout();
  PnlEditDebitNoteDetail pnl2edtDtl;
  public DlgContainDebitNoteDetail(Frame frame, String title, boolean modal,exgui.ultratable.PagedDataFactory db2handle,
                                  database.datatype.Record rec2handle) {
    super(frame, title, modal);
    try {
      pnl2edtDtl=new PnlEditDebitNoteDetail(db2handle,rec2handle,this);
      jbInit();
      pack();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }

  public DlgContainDebitNoteDetail() {
    this(null, "", false,null,null);
  }

  private void jbInit() throws Exception {
    panel1.setLayout(borderLayout1);
    getContentPane().add(panel1);
    pnl2edtDtl.setPreferredSize(new java.awt.Dimension(653,380));
    pnl2edtDtl.record2Gui();
    panel1.add(pnl2edtDtl,borderLayout1.CENTER);
  }
}
