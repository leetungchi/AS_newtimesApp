package newtimes.nthk_report;
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

public class TgrNthkMisReports extends CommandTrigger{
  static final int CONST_REPORT_NTHK_OUTSTANDING_BY_AREA=1;
  static final int CONST_REPORT_NTHK_OUTSTANDING=2;
  static final int CONST_REPORT_NTHK_SHIPPING_AMOUNT_BY_MONTH=4;
  static final int CONST_REPORT_NTHK_SHIPPING_AMOUNT_BY_MONTH_SUBGRP=6;
  static final int CONST_REPORT_MANAGEMENT_REPORT=7;
  static final int CONST_REPORT_DELTED_PO_LIST=8;
  static final int CONST_REPORT_DEIFFERENCE_LIST=9;
  static final int CONST_REPORT_TOP_MANANGEMENT_OUTSTANDING=10;
  public static final int CONST_REPORT_OUTSTANDING_MONTH_BUYER=11;
  static final int CONST_REPORT_LIST_NTHK_EXPORTED_DATA=12;
  public static final int CONST_NTFE_REPORT_FOR_BUYER_SUMMARY_BY_CREATE_DATE=13;
  public static final int CONST_NTFE_REPORT_FOR_DELIVERY_SCHEDULE_REPORT=14;
  public static final int CONST_REPORT_NTHK_OUTSTANDING_ALL_AREA=15;
  public static final int CONST_REPORT_NTHK_QC_ORDER_SUMMARY=16;
  public static final int CONST_REPORT_NTHK_STATUS_REPORT=17;
  public static int CURRENT_REPORT_SET_TO=0;
  public TgrNthkMisReports() {
  }
  static public void setExchangeRate(final java.util.HashMap hm,String centerCode){
    try{
      util.MiscFunc.showProcessingMessage();
      java.util.Vector vct = exgui2.CONST.BASIC_MAIN_EJB.getDatas(util.PublicVariable.
          USER_RECORD,
          "select * from system_default_value where CENTER='" +
          centerCode +
          "' and record_delete_flag=1", 1, 1);
      database.datatype.Record recSystem = (database.datatype.Record)vct.get(0);
      Object objTwdXcgRate=recSystem.get("TWD_XCHG_RATE");
      Object objRmbXcgRate=recSystem.get("RMB_XCHG_RATE");
      Object objHkdXcgRate=recSystem.get("HKD_XCHG_RATE");

      hm.put("TWD_USD",objTwdXcgRate==null?"0":objTwdXcgRate.toString() );
      hm.put("RMB_USD",objRmbXcgRate==null?"0":objRmbXcgRate.toString() );
      hm.put("HKD_USD",objHkdXcgRate==null?"0":objHkdXcgRate.toString() );
    }catch(Exception exp){
      exp.printStackTrace();
      exgui.verification.VerifyLib.showAlert("Error While Get Exchange Rate\nPlease Constact System Manager",
                                             "Error While Get Exchange Rate");
    }finally{
      util.MiscFunc.hideProcessingMessage();
    }
  }

  protected void activateThisProcess() throws processhandler.commands.CommandException {
    try{
    newtimes.production.ProdMaintain_Properties.setWaitCursor();

      while(!newtimes.preproduction.process.AttributeFactory.isAllAccsAttribReady()){
        try{
          Thread.currentThread().sleep(100);
        }catch(java.lang.InterruptedException ie){
        }
      }

    javax.swing.JFrame jframe=processhandler.template.Properties.getMainFrame();
       javax.swing.JPanel tempDownPnl=new javax.swing.JPanel();
       tempDownPnl.setLayout(new java.awt.BorderLayout());
       tempDownPnl.add(new com.inet.viewer.ReportViewerBean());
       Int_PNL_JINIT pnl=null;
       double split_ratio=0.25;
       switch(CURRENT_REPORT_SET_TO){
         case CONST_REPORT_NTHK_OUTSTANDING_BY_AREA:
           pnl=new Pnl_NTHK_OutStandingByArea();
           break;
         case CONST_REPORT_NTHK_OUTSTANDING:
           pnl=new Pnl_NTHK_OutStanding();
           break;
         case CONST_REPORT_NTHK_SHIPPING_AMOUNT_BY_MONTH:
           pnl=new Pnl_NTHK_SHIPPINGByMonth();
           break;
         case CONST_REPORT_NTHK_SHIPPING_AMOUNT_BY_MONTH_SUBGRP:
           pnl=new Pnl_NTHK_ShpSubGrpByMonth();
          break;
        case CONST_REPORT_MANAGEMENT_REPORT:
          pnl=new PnlTopMngReport();
         break;
         case CONST_REPORT_DELTED_PO_LIST :
           pnl=new PnlDeletePoSum();
          break;
        case CONST_REPORT_DEIFFERENCE_LIST  :
          split_ratio=0.15;
          pnl=new PnlDiffReport();
         break;
        case CONST_REPORT_TOP_MANANGEMENT_OUTSTANDING :
          pnl=new PnlTopMngOutStandingRpt();
         break;
        //CONST_REPORT_OUTSTANDING_MONTH_BUYER
        case CONST_REPORT_OUTSTANDING_MONTH_BUYER :
          pnl=new PnlOutStandingByMonthBuyer();
          break;
        case CONST_REPORT_LIST_NTHK_EXPORTED_DATA :
          split_ratio=0.15;
          pnl=new PnlListExpData();
           break;
        case CONST_NTFE_REPORT_FOR_BUYER_SUMMARY_BY_CREATE_DATE:
          split_ratio=0.20;
          pnl=new PnlBuyerSummaryByCreateDate();
           break;
         case CONST_NTFE_REPORT_FOR_DELIVERY_SCHEDULE_REPORT:
           split_ratio=0.48;
           pnl=new PnlDelSchedualRpt();
            break;
         case CONST_REPORT_NTHK_OUTSTANDING_ALL_AREA:
           pnl=new Pnl_NTHK_OutStandingAllArea();
           break;
         case CONST_REPORT_NTHK_QC_ORDER_SUMMARY:
           pnl=new PnlQcOrderSummary();
           break;
         case CONST_REPORT_NTHK_STATUS_REPORT:
           pnl=new PnlStatusReport();
           break;
         default:
           exgui.verification.VerifyLib.showAlert("","");
           throw new Exception("REport not defined");
       }

       /*PnlOutStanding   pnl=new PnlOutStanding();*/
       pnl.jbInit();

       processhandler.template.Properties.getSplitFrame().setPanel(
          (javax.swing.JPanel)pnl,
          tempDownPnl
        );
       processhandler.template.Properties.getSplitFrame().setDividerLocation(split_ratio);
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
