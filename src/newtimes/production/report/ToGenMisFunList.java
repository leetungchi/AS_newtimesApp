package newtimes.production.report;
import processhandler.commands.*;
public class ToGenMisFunList implements AbleToGenMisFunList{
  public ToGenMisFunList() {

  }
  public void toGenMisFunList() throws processhandler.commands.CommandException{
    newtimes.production.ProdMaintain_Properties.setWaitCursor();
    System.out.println("wait for additional attribute and Proxy Of Report Engine");
    while(!newtimes.preproduction.process.AttributeFactory.isReportEJBReady()){
      try{
        Thread.currentThread().sleep(100);
      }catch(java.lang.InterruptedException ie){
      }
    }
    System.out.println("Finish Waiting");
   javax.swing.JFrame jframe=processhandler.template.Properties.getMainFrame();
   jframe.getContentPane().removeAll();
   Pnl_MIS_Func_List  pnl =new Pnl_MIS_Func_List();
   pnl.setSize(800,600);
   jframe.getContentPane().add(pnl);
   jframe.repaint();
   jframe.show();
   newtimes.production.ProdMaintain_Properties.setNormalCursor();
  }
}
