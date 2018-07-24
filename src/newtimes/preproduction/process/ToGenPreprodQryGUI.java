package newtimes.preproduction.process;
import java.awt.Cursor;
/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class ToGenPreprodQryGUI implements AbleToGenQryPreProdGUI  {
  protected newtimes.preproduction.guis.PnlQryPPrd pnl=null;
  public ToGenPreprodQryGUI() {
     pnl=null;
  }
  public void toGenQryPreProdGUI()throws Exception{
    //showing the first panel to main frame.
    //wait for other attribe is ready
    javax.swing.JFrame jframe = processhandler.template.Properties.
        getMainFrame();
    jframe.getContentPane().removeAll();
    jframe.getContentPane().setCursor(new Cursor(
        Cursor.WAIT_CURSOR));

    while(!newtimes.preproduction.process.AttributeFactory.isAllAccsAttribReady()){
      try{
        Thread.currentThread().sleep(100);
      }catch(java.lang.InterruptedException ie){
      }
    }

   jframe.setTitle("PRODUCTION MAINTAIN");
   jframe.getContentPane().removeAll();
   if(pnl==null){
     pnl=new newtimes.preproduction.guis.PnlQryPPrd();
     pnl.activate();

   }
   util.PublicVariable.APP_FRAME.setTitle("Newtimes Production Maintain -- QUERY");
   util.ApplicationProperites.removeProperites("newtimes.preproduction.guis.PnlListPprd4Restore"+"_TOP_RECORD_AT");
   util.ApplicationProperites.removeProperites("newtimes.preproduction.guis.PnlListQryPprod"+"_TOP_RECORD_AT");
   jframe.getContentPane().add(pnl);
   processhandler.template.Properties.getCenteralControler().setDataProcesser(null);
   jframe.repaint();
   jframe.show();
   jframe.getContentPane().setCursor(new Cursor(
       Cursor.DEFAULT_CURSOR));

  }
}
