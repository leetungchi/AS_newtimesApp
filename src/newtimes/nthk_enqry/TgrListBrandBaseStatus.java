package newtimes.nthk_enqry;
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

public class TgrListBrandBaseStatus extends TgrListQryResult {
  public TgrListBrandBaseStatus(String p0) {
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
        PnlBrandBaseStatusEditor pnlEditor=null;
        util.InsertionOrderedHashMap iso=new util.InsertionOrderedHashMap();
        iso.put("BB PO#","Sty_po");
        iso.put("  S/C#  ","sc_no");
        iso.put("    STYLE    ", "STY_STYLE");
        iso.put("COLOR\nCODE", "COLOR_CODE");
        iso.put("COLOR\nNAME", "COLOR");
        iso.put("COST", "COST");
        iso.put("PO\nQTY", "PRX_QTY");
        iso.put("COUNTRY\nDESTINATION","cnty_dest");
        iso.put("Estimated\nDelivery\n(ETD)","etd_date");
        iso.put("Approval\nRequest\nDate","APRVL_REQ_DATE");
        iso.put("Buyer\nApproval\nDate","BUYER_APRVL_DATE");
        java.util.Hashtable ht=new java.util.Hashtable();
        Object objdateVfy=exgui.verification.CellFormat.getDateStringFormaterAllowNull();
        ht.put("Approval\nRequest\nDate",objdateVfy);
        ht.put("Buyer\nApproval\nDate",objdateVfy);



          Db4BrandBaseStatus db = new Db4BrandBaseStatus();
          pnlEditor =
              new PnlBrandBaseStatusEditor(
              db, 99999, iso,
              ht);

        pnlEditor.setBounds(0,0,780,550);
        pnlEditor.setSize(new java.awt.Dimension(780,550));

    //pnl.setPreferredSize(new java.awt.Dimension(800,600));
    //pnl.setSize(800,600);
    pnlEditor.repaint();
    pnlEditor.validate();
    jframe.getContentPane().add(pnlEditor);
    jframe.repaint();
    jframe.show();
    pnlEditor.firstPage();
    util.PublicVariable.APP_FRAME.getContentPane().setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
  }
  protected void activateThisProcess() throws processhandler.commands.CommandException {
    //PnlList4Appv.checkedProdScNo=null;
    processForApprovalCancellation();
 }

}
