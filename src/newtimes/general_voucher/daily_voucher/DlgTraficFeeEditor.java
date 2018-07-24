package newtimes.general_voucher.daily_voucher;

import java.awt.*;
import javax.swing.*;
import exgui.*;
import javax.swing.border.*;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class DlgTraficFeeEditor extends JDialog {
  JPanel panel1 = new JPanel();
  JButton jButton1 = new JButton();
  PnlTraficFeeEditor pnlTfkFeeEditor=new PnlTraficFeeEditor();
  DlgTraficFeeEditor thisObj;
  public DlgTraficFeeEditor(Frame frame, String title, boolean modal) {
    super(frame, title, modal);
    try {
      thisObj=this;
      jbInit();
      pack();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }

  public DlgTraficFeeEditor() {
    this(null, "", false);
  }

  private void jbInit() throws Exception {
    panel1.setLayout(null);
    pnlTfkFeeEditor.setBounds(0,0,690,330);
    this.setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
    panel1.add(pnlTfkFeeEditor, null);
    getContentPane().add(panel1);
    pnlTfkFeeEditor.dlgContainer=this;
    pnlTfkFeeEditor.btnOk.grabFocus();
  }
}
