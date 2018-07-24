package newtimes.preproduction.process;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class NTHK_PreprodMaintain_CmdSet extends PP_Maintain_CmdSet {
  ToEditNthkProdHead cmd2EdtNthkPrpd=null;//new ToEditAPreprodHEad();
  ToDoNthkOrderPrint cmdToDoNthkOrderPrint=null;
  ToListNthkSimpleShipData cmdToListNthkSimpleShipData=null;
  ToListNthkStyle2Restore cmdToListNthkStyle2Restore=null;
  newtimes.production.process.prodmaintain.ToNtfePrintDraft cmdToNtfePrintDraft=null;
  public NTHK_PreprodMaintain_CmdSet() {
    super();

  }
  public void toEditSty_SC_SndCfm()
    throws processhandler.commands.CommandException,
    processhandler.commands.CommandIncompleteException{
       if(cmdToNtfePrintDraft==null)
         cmdToNtfePrintDraft=new newtimes.production.process.prodmaintain.ToNtfePrintDraft();

       cmdToNtfePrintDraft.toEditSty_SC_SndCfm();
  }

  public void toEditPreprodHead()throws Exception{
    if(cmd2EdtNthkPrpd==null)cmd2EdtNthkPrpd=new ToEditNthkProdHead();
    cmd2EdtNthkPrpd.toEditPreprodHead();
  }
  public void toDoOrderPrint()throws Exception{
   if(cmdToDoNthkOrderPrint==null)cmdToDoNthkOrderPrint=new ToDoNthkOrderPrint();
     cmdToDoNthkOrderPrint.toDoOrderPrint();
  }
  public void toListStyle2Restore()throws Exception{
     if(cmdToListNthkStyle2Restore==null)cmdToListNthkStyle2Restore=new ToListNthkStyle2Restore();
     cmdToListNthkStyle2Restore.toListStyle2Restore();
  }


  public void toListSimpleShipData()throws processhandler.commands.CommandException {
    if(cmdToListNthkSimpleShipData==null)cmdToListNthkSimpleShipData=new ToListNthkSimpleShipData();
    cmdToListNthkSimpleShipData.toListSimpleShipData();
  }
}
