package newtimes.shipping.prealertdailyreport;

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

public class OrderBy extends JDialog {
  JPanel panel1 = new JPanel();
  GridBagLayout gridBagLayout2 = new GridBagLayout();

  public OrderBy(Frame frame, String title, boolean modal) {
    super(frame, title, modal);
    try {
      jbInit();
      pack();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }

  public OrderBy() {
    this(null, "", false);
  }
  private void jbInit() throws Exception {
    this.setLocation(300, 250);
    panel1.setLayout(null);
    this.getContentPane().setLayout(gridBagLayout2);
    this.getContentPane().add(new newtimes.shipping.prealertdailyreport.DialogGUI(),
                              new GridBagConstraints(0, 0, 1, 1, 1.0, 1.0,
        GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 373, 306));
  }
}