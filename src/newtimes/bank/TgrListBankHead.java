package newtimes.bank;
import processhandler.*;
import processhandler.commands.CommandException;
import java.awt.Cursor;
import database.datatype.Record;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class TgrListBankHead extends CommandTrigger{
  static DbBankHead bankHandler=new DbBankHead();
  public TgrListBankHead(java.util.HashMap conditions) {
   bankHandler.setConditions(conditions);
 }
  public TgrListBankHead() {
  }
  protected void addGui(){
    javax.swing.JFrame jframe = processhandler.template.Properties.
        getMainFrame();
    jframe.getContentPane().removeAll();
    jframe.getContentPane().setCursor(new Cursor(
        Cursor.WAIT_CURSOR));
    util.InsertionOrderedHashMap iso=new   util.InsertionOrderedHashMap ();
    iso.put("             COMPANY   ","COMP_ID");
    iso.put("             BANK      ","BANK_ID");
    iso.put("             ACC:      ","ACCT_NO");
    iso.put("        INIT AMT       ","INITIAL_AMT");
    iso.put("            CHK-DD     ","CHK_DD");
    java.util.Hashtable ht=new java.util.Hashtable();
    Object objcnv=PnlEditBankHead.getConvDecimalFormat();
    Object vftxtChkDD=new RocDateFormator().getRocDateFormat();
    ht.put("            CHK-DD     ",vftxtChkDD);
    ht.put("        INIT AMT       ",objcnv);
    PnlListBankHead pnl=
        new PnlListBankHead(
          bankHandler,
          9999,iso,
          ht);

    pnl.setPreferredSize(new java.awt.Dimension(800,550));
    pnl.setSize(790, 550);
    pnl.getJtable().setRowHeight(45);
    jframe.getContentPane().add(pnl);
    pnl.gotoRowPosition(Constants.BEGIN_POSITION_OF_BANK_HEAD_QRY);
    jframe.repaint();
    jframe.show();
    jframe.getContentPane().setCursor(new Cursor(
        Cursor.DEFAULT_CURSOR));


  }
  protected void activateThisProcess() throws processhandler.commands.CommandException {

    processhandler.template.Properties.getCenteralControler().
        setSystemCommander(
        newtimes.preproduction.Constants.CMDSET_PREPRODUCTION_MAINTAIN);
       commander = processhandler.template.Properties.getCenteralControler().
        getCurrentSystemCommand();
       ctnCtl.recordProcess(this); //store this node as "go back" required
       addGui();
  }

}
