package newtimes.production.report;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class PnlRptProdDtlColor extends PnlRpt4ProdStyle{
  protected void jbInit() throws Exception {
    super.jbInit();
    super.blueBkgWhiteCharLabel1.setText("ORDER / UNSHIPPED DETAIL BY COLOR");
    super.lblXldSmpl.setVisible(false);
    super.cbxXldSmpl.setVisible(false);
  }
  protected void genDataBindObj(){
    super.genDataBindObj();
    if(util.PublicVariable.OPERATTING_CENTER.equals("001")){
      super.reportName="PROD_DETAIL.rpt";
    }else if(util.PublicVariable.OPERATTING_CENTER.equals("NTFE")){
      super.reportName="NTFE_PROD_DETAIL.rpt";
    }else if(util.PublicVariable.OPERATTING_CENTER.equals("CG")){
      super.reportName="NTFE_PROD_DETAIL.rpt";
    }else{
      super.reportName = "HK_PROD_DETAIL.rpt";
    }
  }
}
