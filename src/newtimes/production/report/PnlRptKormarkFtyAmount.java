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

public class PnlRptKormarkFtyAmount
    extends AbsQryPanel{
    //extends JPanel {
  //BorderLayout borderLayout1 = new BorderLayout();

  public PnlRptKormarkFtyAmount() {
    try {
      //jbInit();

    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }
  protected void genDataBindObj(){}
  public java.util.HashMap composeParameters(){
    return new java.util.HashMap();
  }
  protected void jbInit() throws Exception {
    reportName="komar_fty.rpt";
    //JButtonQueryButtonAction(null);
  }
}
