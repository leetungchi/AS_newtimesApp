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

public class PnlPendingAndShipping extends PnlQryCrossSummaryQtyAmtPrt {
  BorderLayout borderLayout1 = new BorderLayout();

  public PnlPendingAndShipping() {
    super();
    try {
      whiteBkgBlueCharLabel2.setVisible(false);
      rdoTypeOdr.setVisible(false);
      rdoTypeShip.setVisible(false);
      rdoTypePending.setVisible(false);
        rdoRowByDest.setVisible(true);
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }
   protected void jbInit() throws Exception {
     super.jbInit();
     //rdoClmByMonth.setVisible(true);
     blueBkgWhiteCharLabel1.setText("Pending And Shipping Report");
   }
  public java.util.HashMap composeParameters(){
    java.util.HashMap hm=super.composeParameters();
    String pFont=(String)cbxFontSize.getSelectedItem();
    if(pFont==null)pFont="10";
    reportName="CROSS_PS"+pFont+".rpt";
    return hm;
  }

}
