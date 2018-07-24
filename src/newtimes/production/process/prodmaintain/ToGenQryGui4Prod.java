package newtimes.production.process.prodmaintain;
public class ToGenQryGui4Prod implements AbleToGenQryGui4Prod{
  public ToGenQryGui4Prod() {

  }
  public void toGenQryGui4Prod()throws Exception{
    //showing the first panel to main frame.
   javax.swing.JFrame jframe=processhandler.template.Properties.getMainFrame();
   jframe.getContentPane().removeAll();
   newtimes.production.gui.prodmaintain.PnlQryGUI4Prod pnl=
       new newtimes.production.gui.prodmaintain.PnlQryGUI4Prod();
   processhandler.template.Properties.getCenteralControler().setDataProcesser(null);
   jframe.getContentPane().add(pnl);
   jframe.repaint();
   jframe.show();
  }
}
