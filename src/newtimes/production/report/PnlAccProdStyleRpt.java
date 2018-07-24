package newtimes.production.report;
/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class PnlAccProdStyleRpt extends PnlRpt4ProdStyle{
  protected void jbInit() throws Exception {
    super.jbInit();
    super.blueBkgWhiteCharLabel1.setText("ORDER / UNSHIPPED DETAIL BY STYLE");
    super.lblXldSmpl.setVisible(false);
    super.cbxXldSmpl.setVisible(false);
    super.lblAgent.setVisible(true);
    super.slkAgent.setVisible(true);
  }
  public java.util.HashMap composeParameters(){
    java.util.HashMap hm=super.composeParameters();
    Object objAgnet=slkAgent.getSelectedValue();
    hm.put("P_AGENT",((objAgnet==null)?"0":objAgnet.toString()));
    return hm;
  }
  protected void genDataBindObj(){
    super.genDataBindObj();
    slkAgent.init("P_AGENT",null,slkAgent.TYPE_BUYER,true);
    super.lblAgent.setVisible(true);
    super.slkAgent.setVisible(true);
    super.reportName = "ACC_PROD_STYLE.rpt";
  }
}
