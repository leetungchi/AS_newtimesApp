package newtimes.nthk_accounting_enqry;
import java.util.*;
import database.datatype.Record;
/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class DB_ItemDtl extends exgui.ultratable.PagedDataFactoryAdapter {
  int currentProdPk = 0;
  String sc_no;

  newtimesejb.TPE_MIS.TpeMisFunc workingEJB = null;
  java.util.HashMap hmPoStyleColorRecord;
  public DB_ItemDtl(int prodPk, String _sc_no) {
    currentProdPk = prodPk;
    sc_no = _sc_no;
     try {
       newtimesejb.TPE_MIS.TpeMisFuncHome ejbHome=
           (newtimesejb.TPE_MIS.TpeMisFuncHome)info_ejb.WeblogicServiceLocator.locateServiceHome(
           util.PublicVariable.SERVER_URL,"newtimesejb.TPE_MIS.TpeMisFunc");

       workingEJB=ejbHome.create();
    } catch (Exception exp) {
      exp.printStackTrace();
      util.ExceptionLog.exp2File(exp, "");
    }
  }
  public Vector getRecords(int bgn,int rowcount)throws Exception{
    try{
      util.MiscFunc.showProcessingMessage();
      java.util.HashMap hm = new java.util.HashMap();
      hm.put(workingEJB.KEY_STRING_SC_NO_FOR_NTHK_ENQRY, sc_no);
      hm.put(workingEJB.KEY_STRING_PROD_PK_FOR_NTHK_ENQRY,
             String.valueOf(currentProdPk));
      return workingEJB.getRecords4NthkEnqry(bgn, rowcount, hm);
    }finally{
      util.MiscFunc.hideProcessingMessage();
    }
  }
}
