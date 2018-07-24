package newtimes.production.report;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import exgui.*;
import java.util.*;
import javax.swing.border.*;
import newtimes.preproduction.guis.*;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class PnlFabAccNoCommRpt extends PnlFabAccCommRpt {
  public PnlFabAccNoCommRpt() {
     super();
  }
 public void jbInit() throws Exception {
   super.jbInit();
    blueBkgWhiteCharLabel1.setText("FAB & ACCESSORIES NO COMM LIST");
    reportName="FAB_BNF.rpt";
 }
  protected void btnQry_actionPerformed(ActionEvent e) {
    String tempURL= newtimes.production.report.ReportProxyEngine.reportServerURL ;
    newtimes.production.report.ReportProxyEngine.reportServerURL="http://rpt2.nttpe.com.tw:9000/?file:///rpt//";
    super.JButtonQueryButtonAction(null);
    newtimes.production.report.ReportProxyEngine.reportServerURL =tempURL;
  }
}
