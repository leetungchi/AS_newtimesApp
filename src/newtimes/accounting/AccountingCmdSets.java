package newtimes.accounting;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class AccountingCmdSets implements
    AbleToGenAcctFuncsList ,
    AbleToQryFabricComm,
    AbleToListFabricComm,AbleToFabNonePI_rpt,
    AbleTogenProfitDtlListRpt,AbleTogenInvoice2Signe,
    AbleTogenStatementOfTotalCommission,AbleToGenInvoiceListRpt,
    AbleToGenProfitShareListRpt
    {
    ToGenAcctFuncsList cmdToGenAcctFuncsList=new ToGenAcctFuncsList();
    ToQryFabricComm cmdToQryFabricComm=new ToQryFabricComm();
    ToListFabricComm cmdToListFabricComm=new ToListFabricComm();
    ToFabNonePI_rpt cmdToFabNonePI_rpt=new ToFabNonePI_rpt();
    TogenInvoice2Signe cmdTogenInvoice2Signe=new TogenInvoice2Signe();
    TogenStatementOfTotalCommission cmdTogenStatementOfTotalCommission=new TogenStatementOfTotalCommission();
    TogenProfitDtlListRpt cmdTogenProfitDtlListRpt=new TogenProfitDtlListRpt();
    ToGenInvoiceListRpt   cmndToGenInvoiceListRpt=new ToGenInvoiceListRpt();
    ToGenProfitShareListRpt  cmdToGenProfitShareListRpt=new ToGenProfitShareListRpt();
  public AccountingCmdSets() {

  }
  public void toGenInvoiceListRpt() throws processhandler.commands.CommandException{
    cmndToGenInvoiceListRpt.toGenInvoiceListRpt();
  }

  public void togenInvoice2Signe() throws processhandler.commands.CommandException{
    cmdTogenInvoice2Signe.togenInvoice2Signe();
  }
  public void togenProfitDtlListRpt()  throws processhandler.commands.CommandException{
     cmdTogenProfitDtlListRpt.togenProfitDtlListRpt();
  }
  public void toGenProfitShareListRpt()  throws processhandler.commands.CommandException{
     cmdToGenProfitShareListRpt.toGenProfitShareListRpt();
  }

  public void togenStatementOfTotalCommission() throws processhandler.commands.CommandException{
    cmdTogenStatementOfTotalCommission.togenStatementOfTotalCommission();
  }

  public void toFabNonePI_rpt() throws processhandler.commands.CommandException{
    cmdToFabNonePI_rpt.toFabNonePI_rpt();
  }
  public void    toGenAcctFuncsList() throws processhandler.commands.CommandException{
       cmdToGenAcctFuncsList.toGenAcctFuncsList();
  }
  public void    toListFabricComm() throws processhandler.commands.CommandException{
       cmdToListFabricComm.toListFabricComm();
  }
  public void    toQryFabricComm() throws processhandler.commands.CommandException{
      cmdToQryFabricComm.toQryFabricComm();
  }

}
