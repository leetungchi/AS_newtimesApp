package newtimes.basic.systemvalue;

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

public class DlgOtherDateRange extends JDialog {
  BorderLayout borderLayout1 = new BorderLayout();
  PnlOtherDateRange pnl2add;
  public DlgOtherDateRange(Frame frame, String title, boolean modal,PnlOtherDateRange _pnl2add) {
    super(frame, title, modal);
    try {
      pnl2add=_pnl2add;
      pnl2add.setContainDialog(this);
      jbInit();
      pack();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }

  public DlgOtherDateRange() {
    this(null, "", false,null);
  }

  private void jbInit() throws Exception {
    getContentPane().add(pnl2add);
  }
}
