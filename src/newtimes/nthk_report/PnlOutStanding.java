package newtimes.nthk_report;

import java.awt.*;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class PnlOutStanding extends PnlShipVrnRpt {

  public PnlOutStanding() {
    try {
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }
  protected void jbInit()throws Exception{

    super.jbInit();
    jLabel1.setText("DEL.(YYYYMM):");
    blueBkgWhiteCharLabel1.setText("OUT STANDING REPORT");
  }
  public void setReportName(){
    if(cbxCenter.getSelectedItem().toString().equals("NTFE")){
       reportName="NTFE_OUTST.rpt";
    }else{
      reportName="HK_OUTST.rpt";
    }
  }
  protected void btnQry_actionPerformed(java.awt.event.ActionEvent e) {
     //check if format error
     if(txtETD.getText().trim().length()>0){
       if(txtETD.getText().trim().length()<6){
        exgui.verification.VerifyLib.showAlert("ETD DATE FORMAT IS :YYYYMM",
                                               "ETD DATE FORMAT IS :YYYYMM");
        return;
       }
       String dateStr=txtETD.getText().trim();
       int month=Integer.parseInt(dateStr.substring(dateStr.length()-2,dateStr.length()));
       if(month>12||month<1){
         exgui.verification.VerifyLib.showAlert("ETD DATE FORMAT IS :YYYYMM",
                                                "ETD DATE FORMAT IS :YYYYMM");
         return;
       }
     }
     setReportName();
     super.JButtonQueryButtonAction(null);


   }

}
