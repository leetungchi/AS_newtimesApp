package newtimes.production.report;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class TgrToGenTPE_CHG_PROFIT_SHARE_CODE extends processhandler.CommandTrigger {
  public TgrToGenTPE_CHG_PROFIT_SHARE_CODE() {
  }
  protected void activateThisProcess() throws processhandler.commands.CommandException {
     toGenTPE_CHG_PROFIT_SHARE_CODE();
  }
  protected void toGenTPE_CHG_PROFIT_SHARE_CODE(){
    try{
    newtimes.production.ProdMaintain_Properties.setWaitCursor();

      while(!newtimes.preproduction.process.AttributeFactory.isAllAccsAttribReady()){
        try{
          Thread.currentThread().sleep(100);
        }catch(java.lang.InterruptedException ie){
        }
      }
      javax.swing.JFrame jframe=processhandler.template.Properties.getMainFrame();
      jframe.getContentPane().removeAll();
     PnlChgProfitShareCode4SI    pnl =new PnlChgProfitShareCode4SI();
     pnl.setSize(800,600);
     jframe.getContentPane().add(pnl);
     jframe.repaint();
     jframe.show();
    }finally{
     newtimes.production.ProdMaintain_Properties.setNormalCursor();
    }


  }

}
