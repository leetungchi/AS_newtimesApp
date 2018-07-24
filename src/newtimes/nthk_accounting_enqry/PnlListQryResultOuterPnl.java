package newtimes.nthk_accounting_enqry;

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

public class PnlListQryResultOuterPnl extends JPanel {

  public PnlListQryResultOuterPnl() {
    try {
      jbInit();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }

  void jbInit() throws Exception {
    setBackground(new Color(202,202,224));
    this.setLayout(null);
  }

}
