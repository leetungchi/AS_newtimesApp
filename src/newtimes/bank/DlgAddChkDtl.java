package newtimes.bank;

import java.awt.*;
import javax.swing.JDialog;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class DlgAddChkDtl extends JDialog {
  BorderLayout borderLayout1 = new BorderLayout();

  public DlgAddChkDtl() {
    try {
      jbInit();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }

  void jbInit() throws Exception {
    this.setLayout(borderLayout1);
  }
}
