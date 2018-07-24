package newtimes.shipping.shippingmaintain;

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

public class AddDetailListGUI extends JPanel {
  AddDetailListDataTableEditor listTableEditor = new AddDetailListDataTableEditor();

  public AddDetailListGUI() {
    try {
      listTableEditor.reload();
      jbInit();
    } catch(Exception ex) {
      ex.printStackTrace();
    }
  }
  void jbInit() throws Exception {
    listTableEditor.setBounds(new Rectangle(10, 10, 750, 470));
    this.setLayout(null);
    this.setSize(800,600);
    this.setBackground(new Color(204, 204, 225));
    this.add(listTableEditor, null);
  }
}