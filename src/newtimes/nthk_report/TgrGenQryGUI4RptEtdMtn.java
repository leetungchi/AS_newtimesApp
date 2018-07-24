package newtimes.nthk_report;

import processhandler.commands.*;
import processhandler.*;


public class TgrGenQryGUI4RptEtdMtn extends CommandTrigger {
  static javax.swing.JPanel pnlQry;
  public TgrGenQryGUI4RptEtdMtn() {
  }
  protected void activateThisProcess() throws processhandler.commands.CommandException {
    try{
    newtimes.production.ProdMaintain_Properties.setWaitCursor();
    javax.swing.JFrame jframe=processhandler.template.Properties.getMainFrame();
       if(pnlQry!=null){
       }else{
         pnlQry=new PnlQry4CreateRptDate();
       }
       pnlQry.setPreferredSize(new java.awt.Dimension(800,600));
       pnlQry.setBounds(0,0,800,600);
       jframe.getContentPane().removeAll();
       jframe.getContentPane().add(pnlQry,null);
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
