package newtimes.reports.report01.pps;

import exgui.ultratable.PagedDataFactoryAdapter;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class PpsTableDataFactory extends PagedDataFactoryAdapter {
  private static PpsTableDataFactory instanceOfMe = null;

  public PpsTableDataFactory() {
    try{
      super.ejb = exgui2.CONST.PPS_EJB;
    }catch(Exception e){
      e.printStackTrace();
      exgui2.CONST.PPS_EJB = null;
      exgui.verification.VerifyLib.showAlert(
          "Server side Connection Failed", "Server side Connection Failed");
    }
  }

  public static PpsTableDataFactory getInstance(){
    if(instanceOfMe == null){
      instanceOfMe = new PpsTableDataFactory();
    }
    return instanceOfMe;
  }

  public java.util.Vector getRecords(int bgn, int rowcount)throws Exception {
    java.util.Vector vRec = new java.util.Vector();
    try {
      if (PpsQuery.hmFields != null) {
        vRec = exgui2.CONST.PPS_EJB.getRecords(bgn, rowcount, PpsQuery.hmFields);
      }
    } catch (Exception e) {
      e.printStackTrace();
      util.ExceptionLog.exp2File(
          e, "error at get record source.\n"+"vector: "+vRec.toString());
    }
    return vRec;
  }
}