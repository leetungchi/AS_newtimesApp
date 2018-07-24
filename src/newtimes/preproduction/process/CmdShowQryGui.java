package newtimes.preproduction.process;
import newtimes.preproduction.guis.*;
/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class CmdShowQryGui implements processhandler.commands.AbleToGenQryGUI{
  protected PnlQryPPrd pnl2Qry=null;
  public CmdShowQryGui() {
  }
  public void toGenQryGUI() throws processhandler.commands.CommandException{
    javax.swing.JFrame jframe=util.PublicVariable.APP_FRAME;
    java.awt.Cursor ksr=jframe.getContentPane().getCursor();
    try{
      jframe.getContentPane().setCursor(new java.awt.Cursor(java.awt.Cursor.WAIT_CURSOR));
      if (pnl2Qry == null) {
        //first is to get object from remote interface..
        pnl2Qry = new PnlQryPPrd();
        pnl2Qry.activate();
      }
      else {
        pnl2Qry.activate();
      }
      jframe.getContentPane().removeAll();
      pnl2Qry.setSize(800,600);
      jframe.getContentPane().add(pnl2Qry);
      jframe.repaint();
      jframe.show();
    }catch(Exception e){
      e.printStackTrace();
      throw new processhandler.commands.CommandException("Exception whiie Generating Query Interface");
    }finally{
      jframe.getContentPane().setCursor(ksr);
    }
  }
}