package newtimes.production.report;
import processhandler.commands.*;
public class ReportCmdSet
 implements
 AbleToShowReport3FuncList,
 AbleToQry4CulpProd,
 AbleToGenRptProdDetail,
 AbleToGenRptProdStyle,
 AbleToGenRptQCOffShore,
 AbleToGenReport4ProdDetailColors,
 AbleToGenDelayOdrRpt,
 AbleToGenOutStandingRpt,
 AbleToGenRptShippingList,AbleToGenRptSCCnfmList,
 AbleToShippDtlByColor,AbleToGenRptShipPendding,
 AbleToShowShipReportFunList,AbleToShowSummaryReportFunList,AbleToGenMisFunList,
 AbleToGenBuyerCommList4MIS,AbleToGenCorssSummaryQtyAmtRpt,AbleToGenPsFtyListRpt,
 AbleToGenScColorBlcRpt,AbleToGenSalesProfitReport,AbleToGenPackingReport,
 AbleToGenShipInvList,AbleToGenFabAccCommList,AbleToGenFabTypeN_None_RPT
 {
  public static String CMMANDSET_CLASS_NAME="newtimes.production.report.ReportCmdSet";
  static database.encoders.OracleEncoder dbEnc;
  public static ReportProxyEngine myReportEngin=null;
  ToShowReport3FuncList cmdObjReport3FuncList=new ToShowReport3FuncList();
  ToQry4CulpProd cmd2Qry4CulpProd=new ToQry4CulpProd();
  ToGenRptProdDetail cmdGenRptProdDetail=new ToGenRptProdDetail();
  ToGenRptProdStyle cmdGenRptProdStyle=new ToGenRptProdStyle();
  ToGenRptQCOffShore cmdGenRptQCOffShore=new ToGenRptQCOffShore();
  ToGenReport4ProdDetailColors cmdGenReport4ProdDetailColors=new ToGenReport4ProdDetailColors();
  ToGenDelayOdrRpt cmdToGenDelayOdrRpt=new ToGenDelayOdrRpt();
  ToGenOutStandingRpt cmdToGenOutStandingRpt=new ToGenOutStandingRpt();
  ToGenRptShippingList cmdToGenRptShippingList=new ToGenRptShippingList();
  ToGenRptSCCnfmList cmdToGenRptSCCnfmList=new ToGenRptSCCnfmList();
  ToShippDtlByColor cmdToShippDtlByColor=new ToShippDtlByColor();
  ToGenRptShipPendding cmdToGenRptShipPendding=new ToGenRptShipPendding();
  ToShowShipReportFunList cmdToShowShipReportFunList=new ToShowShipReportFunList();
  ToShowSummaryReportFunList cmdToShowSummaryReportFunList=new ToShowSummaryReportFunList();
  ToGenMisFunList cmdToGenMisFunList=new ToGenMisFunList();
  ToGenBuyerCommList4MIS  cmdToGenBuyerCommList4MIS =new ToGenBuyerCommList4MIS ();
  ToGenCorssSummaryQtyAmtRpt cmdToGenCorssSummaryQtyAmtRpt=new ToGenCorssSummaryQtyAmtRpt();
  ToGenPsFtyListRpt cmdToGenPsFtyListRpt=new ToGenPsFtyListRpt();
  ToGenScColorBlcRpt cmdToGenScColorBlcRpt=new ToGenScColorBlcRpt();
  ToGenSalesProfitReport cmdToGenSalesProfitReport=new ToGenSalesProfitReport();
  ToGenPackingReport cmdToGenPackingReport =new ToGenPackingReport();
  ToGenShipInvList cmdToGenShipInvList=new ToGenShipInvList();
  ToGenFabAccCommList cmdToGenFabAccCommList=new ToGenFabAccCommList();
  ToGenFabTypeN_None_RPT cmdToGenFabTypeN_None_RPT=new ToGenFabTypeN_None_RPT();
  public ReportCmdSet() {
    dbEnc=new database.encoders.OracleEncoder();
  }
  public void toGenFabAccCommList() throws CommandException{
    cmdToGenFabAccCommList.toGenFabAccCommList();
  }
  public void toGenFabTypeN_None_RPT() throws CommandException{
    cmdToGenFabTypeN_None_RPT.toGenFabTypeN_None_RPT();
  }

  public void toGenScColorBlcRpt() throws CommandException{
    cmdToGenScColorBlcRpt.toGenScColorBlcRpt();
  }
  public void toGenBuyerCommList4MIS() throws CommandException{
    cmdToGenBuyerCommList4MIS.toGenBuyerCommList4MIS();
  }
  public void toGenPackingReport () throws CommandException{
    cmdToGenPackingReport.toGenPackingReport();
  }
  public void toGenShipInvList() throws CommandException{
    cmdToGenShipInvList.toGenShipInvList();
  }
  public void toShippDtlByColor() throws CommandException{
    cmdToShippDtlByColor.toShippDtlByColor();
  }
  public void toGenSalesProfitReport()throws CommandException{
    cmdToGenSalesProfitReport.toGenSalesProfitReport();
  }
  public void toGenPsFtyListRpt()throws CommandException{
    cmdToGenPsFtyListRpt.toGenPsFtyListRpt();
  }

  public void toShowShipReportFunList()throws CommandException{
    cmdToShowShipReportFunList.toShowShipReportFunList();
  }
  public void toShowSummaryReportFunList()throws CommandException{
    cmdToShowSummaryReportFunList.toShowSummaryReportFunList();
  }
  public void toGenRptShipPendding() throws CommandException{
    cmdToGenRptShipPendding.toGenRptShipPendding();
  }
  public void toGenRptShippingList()throws CommandException{
     cmdToGenRptShippingList.toGenRptShippingList();
  }
  public void toGenRptSCCnfmList()throws CommandException{
     cmdToGenRptSCCnfmList.toGenRptSCCnfmList();
  }
  public void toGenCorssSummaryQtyAmtRpt()throws CommandException{
    cmdToGenCorssSummaryQtyAmtRpt.toGenCorssSummaryQtyAmtRpt();
  }
  public void toGenDelayOdrRpt()throws CommandException{
     cmdToGenDelayOdrRpt.toGenDelayOdrRpt();
  }
  public void toGenOutStandingRpt()throws CommandException{
     cmdToGenOutStandingRpt.toGenOutStandingRpt();
  }
  public void toGenMisFunList()throws CommandException{
    cmdToGenMisFunList.toGenMisFunList();
  }
  public void toGenReport4ProdDetailColors()throws CommandException{
      cmdGenReport4ProdDetailColors.toGenReport4ProdDetailColors();
  }
  public void toGenRptProdDetail()throws CommandException{
    cmdGenRptProdDetail.toGenRptProdDetail();
  }
  public void toGenRptProdStyle()throws CommandException{
    cmdGenRptProdStyle.toGenRptProdStyle();
  }
  public void toGenRptQCOffShore()throws CommandException{
    cmdGenRptQCOffShore.toGenRptQCOffShore();
  }
  public void toShowReport3FuncList()throws Exception{
    cmdObjReport3FuncList.toShowReport3FuncList();
  }
  public void toQry4CulpProd()throws Exception{
      cmd2Qry4CulpProd.toQry4CulpProd();
  }
  public static database.Encoder getDbEncoder(){
    return dbEnc;
  }

}
