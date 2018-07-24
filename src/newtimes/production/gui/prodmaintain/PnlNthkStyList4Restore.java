package newtimes.production.gui.prodmaintain;
import exgui.ultratable.*;
/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class PnlNthkStyList4Restore extends PnlStyList4Restore {
  public PnlNthkStyList4Restore() {
    super();
  }
  protected PagedDataFactory getPagedDataFactory() {
    /**@todo Implement this exgui.ultratable.AbstractUltraTablePanel abstract method*/
    //throw new java.lang.UnsupportedOperationException("Method getPagedDataFactory() not yet implemented.");
    try{
      dbHandler = new newtimes.production.process.prodmaintain.
          DB_NTHKStyleListHandler(
          (String)newtimes.preproduction.Constants.CURRENT_PREPROD_HEAD_RECORD.
          get("prod_sc_no"),true);

    }catch(Exception exp){
      exp.printStackTrace();
    }
    return dbHandler;
  }

}
