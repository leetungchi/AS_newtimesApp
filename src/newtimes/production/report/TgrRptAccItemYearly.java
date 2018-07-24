package newtimes.production.report;
import processhandler.commands.*;
import processhandler.*;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class TgrRptAccItemYearly extends CommandTrigger{
  String rptName;
  String title;
  public TgrRptAccItemYearly(String _rptName,String _title) {
    rptName=_rptName;
    title=_title;
  }
  protected void activateThisProcess() throws processhandler.commands.CommandException {
    try{
      while(!newtimes.preproduction.process.AttributeFactory.isAllAccsAttribReady()){
        try{
          Thread.currentThread().sleep(100);
        }catch(java.lang.InterruptedException ie){
        }
      }

    newtimes.production.ProdMaintain_Properties.setWaitCursor();
    javax.swing.JFrame jframe=processhandler.template.Properties.getMainFrame();
       javax.swing.JPanel tempDownPnl=new javax.swing.JPanel();
       tempDownPnl.setLayout(new java.awt.BorderLayout());
       tempDownPnl.add(new com.inet.viewer.ReportViewerBean());
       PnlRptAccItemsYearly  pnl=new PnlRptAccItemsYearly();
       pnl.jbInit();
       pnl.reportName=rptName;
       pnl.titleLabel.setText(title);
       if(rptName.equalsIgnoreCase("ACC_OP_INOUT.rpt")){
         pnl.titleYYYYMM.setVisible(false);
         pnl.txtYYYYMM.setVisible(false);
         pnl.txtAccFrom.setText("4000");
         pnl.txtAccTo.setText("4ZZZ");
       }else if(rptName.equalsIgnoreCase("ACC_1101_1102.rpt")){
         pnl.txtAccFrom.setText("1101");
         pnl.txtAccTo.setText("1102Z");
       }else if(rptName.equalsIgnoreCase("ACC_1103_3ZZZ.rpt")){
         pnl.txtAccFrom.setText("1103");
         pnl.txtAccTo.setText("3ZZZ");
       }

       processhandler.template.Properties.getSplitFrame().setPanel(
          pnl,
          tempDownPnl
        );
       processhandler.template.Properties.getSplitFrame().setDividerLocation(0.20);
       newtimes.production.process.prodmaintain.ToCheckB4StyleProc.
           setFunctionButtonStatus(
           false, false, false, false,false,false,false);
       processhandler.template.Properties.getSplitFrame().validate();
       processhandler.template.Properties.getSplitFrame().repaint();

       jframe.getContentPane().removeAll();
       jframe.getContentPane().add(processhandler.template.Properties.getSplitFrame());

       jframe.validate();
       jframe.repaint();
    }catch(Exception exp){
      exp.printStackTrace();
      throw new processhandler.commands.CommandException("Error For report engin");
    }finally{
       newtimes.production.ProdMaintain_Properties.setNormalCursor();
    }


  }


}
