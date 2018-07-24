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

public class TgrListQryResult extends CommandTrigger {
  String caption2ShowQry;
  public  boolean isToReload=false;
  PnlListQryResult pnlContainTable=null;
  exgui.ultratable.AbstractUltraTablePanel pnl4AppvCancel=null;
  public TgrListQryResult(String caption2Show) {
   caption2ShowQry=caption2Show;
   isToReload=true;
  }
  protected void processForTpe()throws processhandler.commands.CommandException{
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
        iso.put("YEAR", "PROD_YEAR");
        iso.put("Season", "j_sea");
        iso.put("     Department    ", "j_dep");
        iso.put(" BUYER    ", "J_BUYER");
        iso.put(" Vendor   ", "J_MAKER");
        //iso.put("Cust PO#  ", "cust_po");
        iso.put("PO# \nSTYLE          ", "PO_AND_STYLE");
        iso.put("     S/C#      ","sc_no");
        iso.put(" Status ","prod_audit_status");
        //iso.put(" Status ","testCheck");
        //iso.put(" modify at ","record_modify_at");
        iso.put(" modify at ","final_modify_date");
        iso.put(" modify by ","record_modify_user");
        if(isToReload){
          EnqDataEngin dbShipMaster = new EnqDataEngin();
          pnlContainTable =
              new PnlListQryResult(
              dbShipMaster, 10, iso,
              new java.util.Hashtable(),
              "Detail" ,
               " ... ");
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
  protected void processForNoneTpe()throws processhandler.commands.CommandException{
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
        iso.put("YEAR", "PROD_YEAR");
        iso.put("Season", "j_sea");
        iso.put("     Department    ", "j_dep");
        iso.put("                BUYER              ", "buyer_name");
        iso.put("              BUYER ADD.             ", "buyer_address");
        if(util.PublicVariable.OPERATTING_CENTER.equals("NTHK")){
          iso.put("                 Maker                          ", "maker_name");
          iso.put("              Maker ADD                     ", "maker_address");
        }else{
          iso.put("                 VENDOR                          ", "maker_name");
          iso.put("              Vendor ADD                     ", "maker_address");
        }

        //iso.put("Cust PO#  ", "cust_po");
        iso.put("PO# \nSTYLE          ", "PO_AND_STYLE");
        iso.put("  S/C#  ","sc_no");
        iso.put("PRX TERM\nGoodsDest.  ","PRX_TERM_AND_DEST");
        //iso.put("status","prod_audit_status");
        iso.put(" create at ","record_create_at");
        iso.put(" create by ","record_create_user");
        if("NTHK".equals( util.PublicVariable.OPERATTING_CENTER)){
          iso.put("C/T Create At", "ct_create_date");
        }

        iso.put(" modify at ","final_modify_date");
        iso.put(" modify by ","record_modify_user");
        if(isToReload){
          EnqDataEngin dbShipMaster = new EnqDataEngin();
          pnlContainTable =
              new PnlListQryResult(
              dbShipMaster, 6, iso,
              new java.util.Hashtable(),
              "Report\nPrint"+processhandler.template.PagedListTable4Qry.DELIMITER2CHAIN4BUTTON_COLUMN+
              "MODIFY\nLog"+processhandler.template.PagedListTable4Qry.DELIMITER2CHAIN4BUTTON_COLUMN+"Detail" ,
               "... "+processhandler.template.PagedListTable4Qry.DELIMITER2CHAIN4BUTTON_COLUMN+
               "... "+processhandler.template.PagedListTable4Qry.DELIMITER2CHAIN4BUTTON_COLUMN+" ...");
            isToReload=false;
          pnlContainTable.pgTblList.getJtable().setRowHeight(50);
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
    if(util.PublicVariable.OPERATTING_CENTER.equals("001")){
      processForTpe();
    }else{
      processForNoneTpe();
    }
 }


}
