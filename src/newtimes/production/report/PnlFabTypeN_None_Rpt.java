package newtimes.production.report;

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

public class PnlFabTypeN_None_Rpt
    extends PnlFabAccCommRpt{
    //extends JPanel{
  public void jbInit() throws Exception {
    super.jbInit();
    super.blueBkgWhiteCharLabel1.setText("TYPE N & NONE FAB/ACC COMM");
    reportName="FAB_N_F.rpt";
    cbxDep.setVisible(false);
    jLabel1.setVisible(false);
    super.remove(cbxDep);
  }
  public java.util.HashMap composeParameters() {
    java.util.HashMap hm = super.composeParameters();
    hm.remove("P_DEP");
    return hm;
  }

}
