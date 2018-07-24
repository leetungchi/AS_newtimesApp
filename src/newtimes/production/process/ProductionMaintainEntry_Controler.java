package newtimes.production.process;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class ProductionMaintainEntry_Controler implements
   AbleToShowFuncList {
  public ProductionMaintainEntry_Controler() {
  }
  public void toShowFuncList(){
    ToShowFuncList cmd=new ToShowFuncList();
    cmd.toShowFuncList();
  }
}