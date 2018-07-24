package newtimes.nthk_report;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class TgrNtfeFuncList extends TgrFuncList{
  public TgrNtfeFuncList() {
  }
  protected void activateThisProcess() throws processhandler.commands.CommandException {
    try{
    newtimes.production.ProdMaintain_Properties.setWaitCursor();
    javax.swing.JFrame jframe=processhandler.template.Properties.getMainFrame();
       Pnl_NTFE_ReportFunc pnl=new Pnl_NTFE_ReportFunc();
       pnl.setPreferredSize(new java.awt.Dimension(800,600));
       pnl.setBounds(0,0,800,600);
       jframe.getContentPane().removeAll();
       jframe.getContentPane().add(pnl,null);
       jframe.validate();
       jframe.repaint();
       ctnCtl.recordProcess(this);
    }catch(Exception exp){
      exp.printStackTrace();
      throw new processhandler.commands.CommandException("Error For report engin");
    }finally{
       newtimes.production.ProdMaintain_Properties.setNormalCursor();
    }


  }

}
