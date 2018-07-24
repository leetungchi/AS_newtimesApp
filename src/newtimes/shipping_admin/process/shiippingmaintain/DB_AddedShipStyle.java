package newtimes.shipping_admin.process.shiippingmaintain;
import java.util.*;
/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class DB_AddedShipStyle extends DB_StyleList4Add {
  public DB_AddedShipStyle() {
    super();
  }
  public  Vector getRecords(int bgn,int rowcount)throws Exception{
    //condition hash map is designed by PnlQryStyles2AddByScPo
    String SRNNO=newtimes.shipping_admin.ShippingAdmin_Const.CURRENT_EDITING_SHIP_SRN;
    Vector vct=((ShippingAdmin.SRN_Style.ShipHeadFacade)ejb).getAddedShipStyle(bgn,rowcount,SRNNO);
    return vct;
  }

}
