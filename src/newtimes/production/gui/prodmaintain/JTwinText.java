package newtimes.production.gui.prodmaintain;

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

public class JTwinText extends JComponent {
  JTextField txtName = new JTextField();
  JTextField txtCode = new JTextField();
  JTextField txtRemark = new JTextField();
  GridLayout gridLayout1 = new GridLayout();
  public JTwinText() {
    try {
      jbInit();
    }
    catch(Exception e) {
      e.printStackTrace();
    }
  }
  private void jbInit() throws Exception {
    this.setLayout(gridLayout1);
    txtName.setText("");
    gridLayout1.setColumns(3);
    gridLayout1.setHgap(5);
    gridLayout1.setVgap(5);
    this.add(txtName, null);
    this.add(txtCode, null);
    this.add(txtRemark, null);
  }

}
