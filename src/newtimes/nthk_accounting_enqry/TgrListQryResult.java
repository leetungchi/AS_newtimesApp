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

public class TgrListQryResult extends CommandTrigger {
  String caption2ShowQry;
  public  boolean isToReload=false;
  PnlListQryResult pnlContainTable=null;
  exgui.ultratable.AbstractUltraTablePanel pnl4AppvCancel=null;
  public TgrListQryResult(String caption2Show) {
   caption2ShowQry=caption2Show;
   isToReload=true;
  }
  protected void processForNTHK()throws processhandler.commands.CommandException{
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
        iso.put("S/C   ","PROD_SC_NO");
        iso.put("STYLE   ","STY_STYLE");
        iso.put("PO      ","STY_PO");
        iso.put("BUYER\nAct Prx","BUYER_ACT_PRX");
        iso.put("BUYER\nDoc Prx","BUYER_DOC_PRX");
        iso.put("MAKER\nAct Prx","MAKER_ACT_PRX");
        iso.put("MAKER\nDoc Prx","MAKER_DOC_PRX");
        iso.put("ORDER\nQTY","STY_TOTAL_QTY");
        iso.put("Total\nShip QTY","SHIP_QTY");
        iso.put("                  SHIP SRN LIST               ","SRN_LIST");
        /*iso.put("YEAR", "PROD_YEAR");
        iso.put("Season", "j_sea");
        iso.put("     Department    ", "j_dep");
        iso.put(" BUYER    ", "J_BUYER");
        iso.put(" Vendor   ", "J_MAKER");
        iso.put("PO# \nSTYLE          ", "PO_AND_STYLE");
        iso.put("     S/C#      ","sc_no");
        iso.put(" Status ","prod_audit_status");
        iso.put(" modify at ","record_modify_at");
        iso.put(" modify by ","record_modify_user");*/
        if(isToReload){
          EnqDataEngin dbShipMaster = new EnqDataEngin();
          pnlContainTable =
              new PnlListQryResult(
              dbShipMaster, 14, iso,
              new java.util.Hashtable(),null,null);
            isToReload=false;
        }
    //pnl.setPreferredSize(new java.awt.Dimension(800,600));
    //pnl.setSize(800,600);
    pnlOuter.add(pnlUpper,null);
    pnlContainTable.setPreferredSize(new java.awt.Dimension(780,385));
    pnlContainTable.setSize(new java.awt.Dimension(780,385));
    pnlContainTable.setBounds(0,180,780,385);
    pnlOuter.add(pnlContainTable,null);
    pnlUpper.lblShowQryString.setText(caption2ShowQry);
    pnlUpper.repaint();
    pnlUpper.validate();
    jframe.getContentPane().add(pnlOuter);
    jframe.repaint();
    jframe.show();
    util.PublicVariable.APP_FRAME.getContentPane().setCursor(new Cursor(Cursor.DEFAULT_CURSOR));

  }
  protected void processForXCenter()throws processhandler.commands.CommandException{
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
        iso.put("S/C   ","PROD_SC_NO");
        iso.put("STYLE   ","STY_STYLE");
        iso.put("PO      ","STY_PO");
        iso.put("BUYER\nAct Prx","BUYER_ACT_PRX");
        iso.put("BUYER\nDoc Prx","BUYER_DOC_PRX");
        iso.put("MAKER\nAct Prx","MAKER_ACT_PRX");
        iso.put("MAKER\nDoc Prx","MAKER_DOC_PRX");
        iso.put("COLOR\nCode","prod_color_code");
        iso.put("COLOR\nName","prod_color_name");
        iso.put("ORDER\nQTY","color_qty");
        iso.put("Total\nShip QTY","shipped_qty");
        iso.put("                  SHIP SRN LIST               ","SRN_LIST");
        if(isToReload){
          EnqDataEnginXCenter dbShipMaster = new EnqDataEnginXCenter();
          pnlContainTable =
              new PnlListQryResultXCenter(
              dbShipMaster, 14, iso,
              new java.util.Hashtable(),null,null);
            isToReload=false;
        }
    //pnl.setPreferredSize(new java.awt.Dimension(800,600));
    //pnl.setSize(800,600);
    pnlOuter.add(pnlUpper,null);
    pnlContainTable.setPreferredSize(new java.awt.Dimension(780,385));
    pnlContainTable.setSize(new java.awt.Dimension(780,385));
    pnlContainTable.setBounds(0,180,780,385);
    pnlOuter.add(pnlContainTable,null);
    pnlUpper.lblShowQryString.setText(caption2ShowQry);
    pnlUpper.repaint();
    pnlUpper.validate();
    jframe.getContentPane().add(pnlOuter);
    jframe.repaint();
    jframe.show();
    util.PublicVariable.APP_FRAME.getContentPane().setCursor(new Cursor(Cursor.DEFAULT_CURSOR));

  }
  protected void activateThisProcess() throws processhandler.commands.CommandException {
    if(util.PublicVariable.OPERATTING_CENTER.equals("NTHK")){
      processForNTHK();
    }else{
      processForXCenter();
    }
 }


}
