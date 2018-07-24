package newtimes.preproduction.process;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class ToGenQryPreprodGUI4Restore implements AbleToGenQryPreprod4Restore {
  protected newtimes.preproduction.guis.PnlQryPprd4Restore  pnl=null;
  public ToGenQryPreprodGUI4Restore() {
  }
  public void toGenQryPreprod4Restore() throws Exception{
    javax.swing.JFrame jframe=processhandler.template.Properties.getMainFrame();
    while(!newtimes.preproduction.process.AttributeFactory.isAllAccsAttribReady()){
      try{
        Thread.currentThread().sleep(100);
      }catch(java.lang.InterruptedException ie){
      }
    }
    jframe.setTitle("PRODUCTION RESTORE");
    jframe.getContentPane().removeAll();
    if(pnl==null){
      pnl=new newtimes.preproduction.guis.PnlQryPprd4Restore();
      pnl.activate();
    }
    util.PublicVariable.APP_FRAME.setTitle("Newtimes Production Maintain -- PRODUCTION QUERY FOR RESTORE");
    processhandler.template.Properties.getCenteralControler().setDataProcesser(null);
    util.ApplicationProperites.removeProperites("newtimes.preproduction.guis.PnlListPprd4Restore"+"_TOP_RECORD_AT");
    util.ApplicationProperites.removeProperites("newtimes.preproduction.guis.PnlListQryPprod"+"_TOP_RECORD_AT");
    jframe.getContentPane().add(pnl);
    jframe.repaint();
    jframe.show();
  }
}
