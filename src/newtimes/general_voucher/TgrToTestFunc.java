package newtimes.general_voucher;

import processhandler.commands.*;
public class TgrToTestFunc extends processhandler.CommandTrigger {
  public TgrToTestFunc() {
  }
  public void activateThisProcess() throws processhandler.commands.CommandException{
    newtimes.production.ProdMaintain_Properties.setWaitCursor();
    /*
    while (!newtimes.preproduction.process.AttributeFactory.
           isAllAccsAttribReady()) {
      try {
        Thread.currentThread().sleep(100);
      } catch (java.lang.InterruptedException ie) {
      }
    }
    */
   /*
   System.out.println("Current ClassLoader is :"+getClass().getClassLoader().getClass().getName());
    java.net.URLClassLoader orgClassLoader=
        (java.net.URLClassLoader)getClass().getClassLoader();
    java.net.URLClassLoader tempLoader=new
        java.net.URLClassLoader(orgClassLoader.getURLs(),orgClassLoader);
    java.net.URL[] urls=tempLoader.getURLs();
    for(int i=0;i<urls.length;i++){
      System.out.println("URL iS : "+urls[i].toString());
    }*/
    javax.swing.JFrame jframe=processhandler.template.Properties.getMainFrame();
    jframe.getContentPane().removeAll();
    javax.swing.JPanel pnl=null;
    pnl=new PnlGnvVoucherTest();
    jframe.getContentPane().add(pnl, null);
    pnl.setBounds(0, 0, 800, 600);
    pnl.repaint();
    pnl.validate();
    newtimes.production.ProdMaintain_Properties.setNormalCursor();
    //jframe.validate();
    //jframe.repaint();
  }
}
