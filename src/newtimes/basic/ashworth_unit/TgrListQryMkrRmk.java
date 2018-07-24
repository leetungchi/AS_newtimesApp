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

public class TgrListQryMkrRmk extends CommandTrigger{
  static int rowStartPosition=0;
  public TgrListQryMkrRmk() {

  }
  protected void activateThisProcess() throws processhandler.commands.CommandException{
    try{
       newtimes.production.ProdMaintain_Properties.setWaitCursor();
       javax.swing.JFrame jframe=processhandler.template.Properties.getMainFrame();
       util.InsertionOrderedHashMap iso=new util.InsertionOrderedHashMap();
       iso.put("YEAR","YEAR");
       iso.put("SEASON","SEASON");
       iso.put("  DIV  ","DIV_NAME");
       iso.put("  USER   ","USR");
       iso.put("              MAKER            ","MAKER_NAME");
       iso.put("                   REMARK               ","REMARK_HTML_CONTEXT");

       PageListAshMakerRemark pnl=new
          PageListAshMakerRemark(new DbAshHandler(),10,iso,
            new java.util.Hashtable());

       //processhandler.template.Properties.getSplitFrame().validate();
       //processhandler.template.Properties.getSplitFrame().repaint();
       pnl.setPreferredSize(new java.awt.Dimension(780,500));
       pnl.setBounds(0,0,780,500);
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
