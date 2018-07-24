package newtimes.nthk_accounting_enqry;
import processhandler.*;
import processhandler.commands.CommandException;
import java.awt.Cursor;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class TgrListQryResult4Status extends TgrListQryResult {
  public TgrListQryResult4Status(String p0) {
    super(p0);
  }
  protected void processForApprovalCancellation() throws processhandler.commands.CommandException{
    processhandler.template.Properties.getCenteralControler().setSystemCommander(
    newtimes.preproduction.Constants.CMDSET_PREPRODUCTION_MAINTAIN);
    commander=processhandler.template.Properties.getCenteralControler().getCurrentSystemCommand();
    ctnCtl.recordProcess(this);//store this node as "go back" required

    util.PublicVariable.APP_FRAME.getContentPane().setCursor(new Cursor(Cursor.WAIT_CURSOR));
    newtimes.preproduction.guis.tempProperties.tmpCATData.clear();
    javax.swing.JFrame jframe=processhandler.template.Properties.getMainFrame();
    jframe.getContentPane().removeAll();
        PnlListQryResultOuterPnl pnlOuter=new PnlListQryResultOuterPnl ();
        pnlOuter.setBounds(0,0,800,600);
        pnlOuter.setSize(new java.awt.Dimension(800,600));
        PnlUpperListQryResult pnlUpper=new PnlUpperListQryResult();
        pnlUpper.setPreferredSize(new java.awt.Dimension(800,175));
        pnlUpper.setSize(new java.awt.Dimension(800,175));
        pnlUpper.setBounds(0,0,800,175);
        util.InsertionOrderedHashMap iso=new util.InsertionOrderedHashMap();
        iso.put("     S/C#      ","sc_no");
        iso.put("   BUYER  ", "J_BUYER");
        iso.put("   Vendor  ", "J_MAKER");
        iso.put("Cust PO#  ", "cust_po");
        iso.put("YEAR", "PROD_YEAR");
        iso.put("Season", "j_sea");
        iso.put("  ","xbutton");
        iso.put("STATUS","prod_audit_status");
        iso.put(" modify at ","record_modify_at");
        iso.put(" modify by ","record_modify_user");
        /*
        iso.put("     Department    ", "j_dep");
        iso.put("              BUYER ADD.             ", "buyer_address");
        iso.put("              Vendor ADD                     ", "maker_address");
        */

        if(isToReload){
          EnqDataEngin dbShipMaster = new EnqDataEngin4Status();
          pnl4AppvCancel =
              new PnlList4Status(
              dbShipMaster, 15, iso,
              new java.util.Hashtable());
            isToReload=false;
            pnl4AppvCancel.getJtable().setRowHeight(20);
        }
    //pnl.setPreferredSize(new java.awt.Dimension(800,600));
    //pnl.setSize(800,600);
    pnlOuter.add(pnlUpper,null);
    pnl4AppvCancel.setPreferredSize(new java.awt.Dimension(780,385));
    pnl4AppvCancel.setSize(new java.awt.Dimension(780,385));
    pnl4AppvCancel.setBounds(0,180,780,385);
    pnlOuter.add(pnl4AppvCancel,null);
    pnlUpper.lblShowQryString.setText(caption2ShowQry);
    pnlUpper.repaint();
    pnlUpper.validate();
    jframe.getContentPane().add(pnlOuter);
    jframe.repaint();
    jframe.show();
    util.PublicVariable.APP_FRAME.getContentPane().setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
  }
  protected void activateThisProcess() throws processhandler.commands.CommandException {
    //PnlList4Appv.checkedProdScNo=null;
    processForApprovalCancellation();
 }

}
