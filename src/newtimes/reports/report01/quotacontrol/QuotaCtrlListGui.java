package newtimes.reports.report01.quotacontrol;

import java.awt.*;
import javax.swing.JPanel;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class QuotaCtrlListGui extends JPanel {
  static QuotaTableEditor quotaTbl = new QuotaTableEditor();
  BorderLayout borderLayout = new BorderLayout();

  public QuotaCtrlListGui() {
    try {
      jbInit();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }
  void jbInit() throws Exception {
    this.setLayout(borderLayout);
    this.setPreferredSize(new java.awt.Dimension(300,270));
    this.add(quotaTbl, null);
  }

  static void do_Update() {
    try {
      quotaTbl.doUpdate();
    } catch(Exception ex) {
      ex.printStackTrace();
      util.ExceptionLog.exp2File(ex, "error at attempt pressed Confirm Edit button.");
    }
  }

  static void do_Delete() {
    try {
      quotaTbl.doDelete();
    } catch(Exception ex) {
      ex.printStackTrace();
      util.ExceptionLog.exp2File(ex, "error at attempt pressed Delete button.");
    }
  }
}