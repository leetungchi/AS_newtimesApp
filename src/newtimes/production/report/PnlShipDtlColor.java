package newtimes.production.report;

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

public class PnlShipDtlColor extends PnlRpt4ProdStyle {
  JTextField txtInvDateTo = new JTextField();
  JLabel lblInvDateRange = new JLabel();
  JLabel lblInvDateRangeTo = new JLabel();
  JTextField txtInvDateFrom = new JTextField();
  exgui.DataBindTextWithChecker dbTxtInvDateBgn,dbTxtInvDateEnd;

  public PnlShipDtlColor() {
    super.itemCount=6;
  }
  protected void jbInit()throws Exception{
    super.jbInit();
    lblAgent.setBounds(new Rectangle(484, 63, 70, 22));
    slkAgent.setBounds(new Rectangle(539, 63, 196, 20));

    super.rdoUnshipNo.setVisible(false);
    super.rdoUnshipYes.setVisible(false);
    super.lblToExcludeSC.setVisible(false);
    super.rdoIncludeSCNULL.setVisible(false);
    super.rdoXcldSCNULL.setVisible(false);
    super.rdoXcldSCNULL.setSelected(true);
    super.lblDDFrom.setText("ETD FROM:");
    buyers[5].setBounds(new Rectangle(8, 158, 160, 18));
    makers[5].setBounds(new Rectangle(9, 158, 160, 18));
    cbxDep[5].setBounds(new Rectangle(12, 156, 126, 22));
    pnlDeps.add(cbxDep[5], null);
    pnlBuyers.add(buyers[5], null);
    pnlMakers.add(makers[5], null);
    txtInvDateTo.setText("");
    txtInvDateTo.setBounds(new Rectangle(678, 41, 71, 21));
    lblInvDateRange.setText("INV DAT. FROM:");
    lblInvDateRange.setBounds(new Rectangle(473, 41, 89, 21));
    lblInvDateRangeTo.setText("TO:");
    lblInvDateRangeTo.setBounds(new Rectangle(637, 41, 37, 20));
    txtInvDateFrom.setText("");
    txtInvDateFrom.setBounds(new Rectangle(563, 41, 71, 21));
    this.add(txtInvDateTo, null);
    this.add(lblInvDateRange, null);
    this.add(lblInvDateRangeTo, null);
    this.add(txtInvDateFrom, null);

    genDataBindObj();
    blueBkgWhiteCharLabel1.setText("SHIPPING DETAIL BY COLOR");
    super.lblXldSmpl.setVisible(false);
    super.cbxXldSmpl.setVisible(false);
  }
  public java.util.HashMap composeParameters(){
     java.util.HashMap hm=super.composeParameters();
     Object dateInvBgn=dbTxtInvDateBgn.getSelectedValue();
     Object dateInvEnd=dbTxtInvDateEnd.getSelectedValue();
     if(dateInvBgn==null){
       hm.put("P_INVDD_FM","DATE(2000,01,01)");
     }
     if(dateInvEnd==null){
       hm.put("P_INVDD_TO","DATE(2099,12,31)");
     }


     return hm;
  }

    protected void genDataBindObj() {
      super.genDataBindObj();

      Object dateVfy = exgui.verification.CellFormat.getDateStringFormaterAllowNull();

      dbTxtInvDateBgn =
          new exgui.DataBindTextWithChecker(txtInvDateFrom, "P_INVDD_FM", null,
                                            10, (exgui.Object2String)dateVfy,
                                            (exgui.ultratable.
                                             CellTxtEditorFormat)dateVfy);
      dataBindComps.add(dbTxtInvDateBgn);

     dbTxtInvDateEnd =
          new exgui.DataBindTextWithChecker(txtInvDateTo, "P_INVDD_TO", null,
                                            10, (exgui.Object2String)dateVfy,
                                            (exgui.ultratable.
                                             CellTxtEditorFormat)dateVfy);
      dataBindComps.add(dbTxtInvDateEnd);



      if("NTHK".equals(util.PublicVariable.OPERATTING_CENTER)){
        if ((util.PublicVariable.USER_RECORD.getInt(2) ==
             newtimesejb.preproduction.PreProductionHead.
             USER_TYPE_ACCOUNTING_USERS ||
             util.PublicVariable.USER_RECORD.getInt(2) ==
             newtimesejb.preproduction.PreProductionHead.
             USER_TYPE_SUPERVIOSER_MIS)
            ) {
          reportName = "ship_lst_col.rpt";
        } else {
          reportName = "SHIP_LST_COL_XPR.rpt";
        }
      }else{
        reportName = "ship_lst_col.rpt";
      }
    }

}

