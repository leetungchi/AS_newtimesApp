package newtimes.basic.ashworth_unit;
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

public class TgrAshMkrRmkAdd extends CommandTrigger{
  public TgrAshMkrRmkAdd() {

  }
  protected void activateThisProcess() throws processhandler.commands.CommandException{
    try{
       newtimes.production.ProdMaintain_Properties.setWaitCursor();
       javax.swing.JFrame jframe=processhandler.template.Properties.getMainFrame();
       javax.swing.JPanel tempDownPnl=new javax.swing.JPanel();
       tempDownPnl.setLayout(new java.awt.BorderLayout());
       tempDownPnl.add(new com.inet.viewer.ReportViewerBean());
       PnlAshMkrRmkMtn   pnl=new PnlAshMkrRmkMtn();
       newtimes.basic.ashworth_unit.DbAshHandler dbHandler=new
           newtimes.basic.ashworth_unit.DbAshHandler();
       database.datatype.Record rec=dbHandler.getBlankRecord();
       pnl.setPagedDataFactory(dbHandler);
       pnl.setRecord(rec);
       pnl.record2Gui();
       //processhandler.template.Properties.getSplitFrame().validate();
       //processhandler.template.Properties.getSplitFrame().repaint();


       jframe.getContentPane().removeAll();
       jframe.getContentPane().add(pnl);
       //jframe.getContentPane().add(processhandler.template.Properties.getSplitFrame());

       jframe.validate();
       jframe.repaint();
       jframe.show();
       super.ctnCtl.recordProcess(this);
    }catch(Exception exp){
      exp.printStackTrace();
      throw new processhandler.commands.CommandException("Error For report engin");
    }finally{
       newtimes.production.ProdMaintain_Properties.setNormalCursor();
    }

  }
}
