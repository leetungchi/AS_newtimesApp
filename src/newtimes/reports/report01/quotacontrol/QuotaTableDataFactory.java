package newtimes.reports.report01.quotacontrol;

import exgui.ultratable.PagedDataFactoryAdapter;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class QuotaTableDataFactory extends PagedDataFactoryAdapter {
  private static QuotaTableDataFactory instanceOfMe = null;

  public QuotaTableDataFactory() {
    try {
      super.ejb = exgui2.CONST.QTA_EMBARGO_EJB;
    } catch (Exception e) {
      e.printStackTrace();
      exgui2.CONST.QTA_EMBARGO_EJB = null;
      exgui.verification.VerifyLib.showAlert(
          "Server side Connection Failed", "Server side Connection Failed");
    }
  }

  public static QuotaTableDataFactory getInstance(){
    if(instanceOfMe == null){
      instanceOfMe = new QuotaTableDataFactory();
    }
    return instanceOfMe;
  }

  public java.util.Vector getRecords(int bgn, int rowcount)throws Exception {
    java.util.Vector vRec = new java.util.Vector();
    try {
      if (!QuotaCtrl_SF.hm.isEmpty()) {
        vRec = exgui2.CONST.QTA_EMBARGO_EJB.getRecords(bgn, rowcount,
            QuotaCtrl_SF.hm);
      }
    } catch (Exception e) {
      e.printStackTrace();
      util.ExceptionLog.exp2File(
          e, "error at get record source.\n"+"vector: "+vRec.toString());
    }
    return vRec;
  }
}