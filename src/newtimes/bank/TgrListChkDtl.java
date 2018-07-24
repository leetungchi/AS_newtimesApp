package newtimes.bank;
import processhandler.*;
import processhandler.commands.CommandException;
import java.awt.Cursor;
import java.text.DecimalFormat;
import database.datatype.Record;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class TgrListChkDtl extends CommandTrigger{
  static DbBankCheckHandler dbHandler=new DbBankCheckHandler();
  public TgrListChkDtl() {
  }
  public TgrListChkDtl(java.util.HashMap hmCondition){
    dbHandler.setConditions(hmCondition);
  }
  protected void addGui(){

    //COM  BANK    CHK-NO.   PAY-DD  D/C      AMOUNT              PAYEE
    javax.swing.JFrame jframe = processhandler.template.Properties.
        getMainFrame();
    jframe.getContentPane().removeAll();
    jframe.getContentPane().setCursor(new Cursor(
        Cursor.WAIT_CURSOR));
     // COM  BANK    CHK-NO.   PAY-DD  D/C      AMOUNT              PAYEE
    util.InsertionOrderedHashMap iso=new   util.InsertionOrderedHashMap ();
    iso.put("  COMPANY   ","COMP_ID");
    iso.put("  BANK      ","BANK_ID");
    iso.put("  CHK-NO     ","CHK_NO");
    iso.put("  PAY-DD  ","PAY_DD");
    iso.put("D/C","D_C");
    iso.put("   AMOUNT     ","AMOUNT");
    iso.put("   PAYEE       ","PAYEE");
     iso.put("TYPE","TYPE4USD");
     iso.put("EXCHANGE","EXCHANGE");

    java.util.Hashtable ht=new java.util.Hashtable();
    Object vftxtChkDD=new RocDateFormator().getRocDateFormat();
    ht.put("  PAY-DD  ",vftxtChkDD);
    Object objcnv=PnlEditBankHead.getConvDecimalFormat();
    ht.put("   AMOUNT     ",objcnv);

 //   DecimalFormat df = new DecimalFormat("###.##");
 //   ht.put("EXCHANGE",df);

    PnlListChkDtl  pnl=
        new PnlListChkDtl(
          dbHandler,
          12,iso,
          ht);
     pnl.gotoRowPosition(Constants.BEGIN_POSITION_OF_BANK_CHK_DTL_QRY);
    pnl.setPreferredSize(new java.awt.Dimension(780,550));
    pnl.setSize(780, 540);
    pnl.getJtable().setRowHeight(38);
    jframe.getContentPane().add(pnl);
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
