package newtimes.basic.offshore_rule;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class ToDoAxn {
  static public PnlQryOffShoreRule pnlQry=null;
  public ToDoAxn() {
  }

  static public void Exit2BasiIIFunc(){
    ((newtimes.Frame1)util.PublicVariable.APP_FRAME).showPanel(new newtimes.basic.MiscMenu(
      ((newtimes.Frame1)util.PublicVariable.APP_FRAME))
        );
  }
  static public void ShowQryGUI(){
    ((newtimes.Frame1)util.PublicVariable.APP_FRAME).setCursor(java.awt.Cursor.WAIT_CURSOR);
    while(!newtimes.preproduction.process.AttributeFactory.isAllAccsAttribReady()){
      try{
        Thread.currentThread().sleep(100);
      }catch(java.lang.InterruptedException ie){
      }
    }
    ((newtimes.Frame1)util.PublicVariable.APP_FRAME).setCursor(java.awt.Cursor.getDefaultCursor());
       if(pnlQry==null)pnlQry=new PnlQryOffShoreRule();
       pnlQry.setBounds(0,0,800,600);
       ((newtimes.Frame1)util.PublicVariable.APP_FRAME).showPanel(pnlQry);
  }
  static public void ShowListGUI(){
     PnlListOffShoreRule pnl=new PnlListOffShoreRule();
      ((newtimes.Frame1)util.PublicVariable.APP_FRAME).showPanel(pnl);
  }

}
