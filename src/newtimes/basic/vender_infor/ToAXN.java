package newtimes.basic.vender_infor;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class ToAXN {
  static int vender_seq;
  public static PnlQryVenderInfor pnlQry=null;
  public ToAXN() {

  }
  static public void Exit2BasiIIFunc(){
    ((newtimes.Frame1)util.PublicVariable.APP_FRAME).showPanel(new newtimes.basic.MiscMenu(
      ((newtimes.Frame1)util.PublicVariable.APP_FRAME))
        );
  }
  static public void ShowQryGUI(){
       if(pnlQry==null)pnlQry=new PnlQryVenderInfor();
       pnlQry.setBounds(0,0,800,600);
       ((newtimes.Frame1)util.PublicVariable.APP_FRAME).showPanel(pnlQry);
  }
  static public void ShowListGUI(){
     PnlListVenderInfor pnl=new PnlListVenderInfor();
      ((newtimes.Frame1)util.PublicVariable.APP_FRAME).showPanel(pnl);
  }
}
