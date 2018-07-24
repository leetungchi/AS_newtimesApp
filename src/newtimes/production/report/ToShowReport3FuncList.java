package newtimes.production.report;
public class ToShowReport3FuncList {
  public ToShowReport3FuncList() {
  }
  public void toShowReport3FuncList()throws Exception{
    //showing the first panel to main frame.
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
   PnlReport3FunList pnl =new PnlReport3FunList();
   pnl.setSize(800,600);
   jframe.getContentPane().add(pnl);
   jframe.repaint();
   jframe.show();
   newtimes.production.ProdMaintain_Properties.setNormalCursor();
  }
}
