package newtimes.preproduction.process;
import newtimes.preproduction.guis.*;
/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class ToSingleAddClib implements AbleToSingleAddClib {
  public ToSingleAddClib() {
  }
  public void toSingleAddClib()throws Exception{
    //get data from db interface...
    try{
      processhandler.template.Properties.getMainFrame().getContentPane().removeAll();
      PnlColorEditor pnl = new PnlColorEditor();
      DB_ColorLib db = DB_ColorLib.getInstance();
      pnl.setPagedDataFactory(db);
      pnl.setRecord(db.getBlankRecord());
      pnl.record2Gui();
      pnl.setSize(800, 600);
      processhandler.template.Properties.getMainFrame().getContentPane().add(pnl);
      processhandler.template.Properties.getMainFrame().validate();
      processhandler.template.Properties.getMainFrame().repaint();
    }finally{}
  }
}
