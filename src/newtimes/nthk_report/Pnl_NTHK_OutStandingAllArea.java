package newtimes.nthk_report;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class Pnl_NTHK_OutStandingAllArea extends Pnl_NTHK_OutStandingByArea{
  public Pnl_NTHK_OutStandingAllArea() {
    super();
  }
  public void jbInit() throws Exception {
    super.jbInit();
    super.blueBkgWhiteCharLabel1.setText("NTHK OUTSTANDING ALL AREA");
  }
  public java.util.HashMap composeParameters(){
    super.reportName="NTHK_OUTST_AREA_ALL.rpt";
    return super.composeParameters();
  }
}
