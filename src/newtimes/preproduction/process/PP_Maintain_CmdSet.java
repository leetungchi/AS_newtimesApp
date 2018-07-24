package newtimes.preproduction.process;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class PP_Maintain_CmdSet implements
    processhandler.commands.AbleToListQryResult,
    AbleToEditPreprodHead,AbleToShowClibList,
    AbleToEditColorLib,AbleToEditLabDip,AbleToEditProtoStatuses,
    AbleToShowLknStyleList,
    AbleToListProtoFobBreakDown,
    AbleToEditLockinStyle,
    AbleToListLknStyFobPrxBkdn,
    AbleToListPPSstatuses,
    AbleToEditCostSheet,AbleToListDupStatuses,
    AbleToShowFuncList,AbleToGenQryPreProdGUI,AbleToListClibsWhitOutPreprod,
    AbleToSingleAddClib,
    AbleToListClib4Select,AbleToEditPrePrdColorLib,
    AbleToGenQryPreprod4Restore,AbleToListPpClib4Restore,
    AbleToListPreprod4Restore,AbleToDoOrderPrint,AbleToListStyle2Restore,
    newtimes.production.process.prodmaintain.AbleToEditSty_SC_SndCfm,
    AbleToListSimpleShipData
   {
   //extends CommandSets {
  ToListQueryPreprod cmd2ListQryPrpd=null;// new ToListQueryPreprod(null);
  ToEditAPreprodHEad cmd2EdtPrpd=null;//new ToEditAPreprodHEad();
  ToListColorLibs cms2ListClibs=null;//new ToListColorLibs();
  ToEditColorLib cmd2EditColorLib=null;//new ToEditColorLib();
  ToGenPreprodQryGUI cmdGenQryGui=null;//new ToGenPreprodQryGUI();
  ToGenQryPreprodGUI4Restore cmdGenQryGUI4Restore=null;//new ToGenQryPreprodGUI4Restore();
  ToListSimpleShipData cmdListShipData=null;//new ToListSimpleShipData();
  ToListPpClib4Restore cmdToListPpClib4Restore =null;//new ToListPpClib4Restore();
  ToListPreprod4Restore cmdToListPreprod4Restore=null;//new ToListPreprod4Restore();
  ToEditPrePrdColorLib cmdToEditPrePrdColorLib= null;//new ToEditPrePrdColorLib();
  ToListClib4Select cmdToListClib4Select=null;//new ToListClib4Select();
  ToListClibsWhitOutPreprod cmdToListClibsWhitOutPreprod=null;//new ToListClibsWhitOutPreprod ();
  ToShowFuncList cmdToShowFuncList=null;//new ToShowFuncList();
  ToListDupStatuses cmdToListDupStatuses=null;//new ToListDupStatuses();
  ToListLknStyFobPrxBkdn cmdToListLknStyFobPrxBkdn=null;//new ToListLknStyFobPrxBkdn();
  ToListPPSstatuses  cmdToListPPSstatuses=null;//new ToListPPSstatuses();
  ToEditCostSheet cmdToEditCostSheet=null;//new ToEditCostSheet();
  ToEditLockinStyle cmdToEditLockinStyle=null;//new ToEditLockinStyle();
  ToSingleAddClib cmdToSingleAddClib= null;//new ToSingleAddClib();
  ToListProtoFobBreakDown cmdToListProtoFobBreakDown=null;//new ToListProtoFobBreakDown();
  public static java.util.HashMap qryConditions=null;
   ToListLockinStyles cmd2ListLknStys=null;//new ToListLockinStyles();
   ToEditProtoStatuses cmd2EditProto=null;//new ToEditProtoStatuses();
     ToEditLabDips cmd2EditLabDip=null;//new ToEditLabDips();
     ToDoOrderPrint cmd2OdrPrint=null;//new ToDoOrderPrint();
      ToListStyle2Restore cmd2RestoreStyle=null;//new ToListStyle2Restore();
      newtimes.production.process.prodmaintain.ToEditSty_SC_SndCfm
         cmdObjToEditSty_SC_SndCfm=null;//new newtimes.production.process.prodmaintain.ToEditSty_SC_SndCfm ();
  public PP_Maintain_CmdSet() {
     cmdGenQryGui=null;//new ToGenPreprodQryGUI();
  }
  public void toListPpClib4Restore()throws Exception{
    if(cmdToListPpClib4Restore==null)cmdToListPpClib4Restore=new ToListPpClib4Restore();
    cmdToListPpClib4Restore.toListPpClib4Restore();
  }
  public void toListPreprod4Restore()throws Exception{
    if(cmdToListPreprod4Restore==null)cmdToListPreprod4Restore=new ToListPreprod4Restore();
    cmdToListPreprod4Restore.toListPreprod4Restore();
  }
  public void toGenQryPreprod4Restore()throws Exception{
    if(cmdGenQryGUI4Restore==null)cmdGenQryGUI4Restore=new ToGenQryPreprodGUI4Restore();
    cmdGenQryGUI4Restore.toGenQryPreprod4Restore();
  }
  public void toEditPrePrdColorLib()throws Exception{
    if(cmdToEditPrePrdColorLib==null)cmdToEditPrePrdColorLib=new ToEditPrePrdColorLib();
    cmdToEditPrePrdColorLib.toEditPrePrdColorLib();
  }
  public void toListSimpleShipData()throws processhandler.commands.CommandException {
    if(cmdListShipData==null)cmdListShipData=new ToListSimpleShipData();
    cmdListShipData.toListSimpleShipData();
  }
  public void toListClib4Select()throws Exception{
    if(cmdToListClib4Select==null)cmdToListClib4Select=new ToListClib4Select();
    cmdToListClib4Select.toListClib4Select();
  }
  public void toSingleAddClib()throws Exception{
    if(cmdToSingleAddClib==null)cmdToSingleAddClib=new ToSingleAddClib();
    cmdToSingleAddClib.toSingleAddClib();
  }
  public void toListClibsWhitOutPreprod()throws Exception{
    if(cmdToListClibsWhitOutPreprod==null)cmdToListClibsWhitOutPreprod=new ToListClibsWhitOutPreprod();
    cmdToListClibsWhitOutPreprod.toListClibsWhitOutPreprod();
  }
  public void toGenQryPreProdGUI()throws Exception{
    if(cmdGenQryGui==null)cmdGenQryGui=new ToGenPreprodQryGUI();
    cmdGenQryGui.toGenQryPreProdGUI();
  }
  public void toShowFuncList()throws Exception{
     if(cmdToShowFuncList==null)cmdToShowFuncList=new ToShowFuncList();
    cmdToShowFuncList.toShowFuncList();
  }
  public void toListDupStatuses()throws Exception{
    if(cmdToListDupStatuses==null)cmdToListDupStatuses=new ToListDupStatuses();
    cmdToListDupStatuses.toListDupStatuses();
  }
  public void toListLknStyFobPrxBkdn()throws Exception{
    if(cmdToListLknStyFobPrxBkdn==null)cmdToListLknStyFobPrxBkdn=new ToListLknStyFobPrxBkdn();
    cmdToListLknStyFobPrxBkdn.toListLknStyFobPrxBkdn();
  }
  public void toListPPSstatuses()throws Exception{
    if(cmdToListPPSstatuses==null)cmdToListPPSstatuses=new ToListPPSstatuses();
    cmdToListPPSstatuses.toListPPSstatuses();
  }
  public void toEditCostSheet()throws Exception{
    if(cmdToEditCostSheet==null)cmdToEditCostSheet=new ToEditCostSheet();
    cmdToEditCostSheet.toEditCostSheet();
  }
  public void toEditLockinStyle()throws Exception{
    if(cmdToEditLockinStyle==null)cmdToEditLockinStyle=new ToEditLockinStyle();
    cmdToEditLockinStyle.toEditLockinStyle();
  }
  public void toListProtoFobBreakDown()throws Exception{
    if(cmdToListProtoFobBreakDown==null)cmdToListProtoFobBreakDown=new ToListProtoFobBreakDown();
    cmdToListProtoFobBreakDown.toListProtoFobBreakDown();
  }
  public void toListLockInStyles()throws Exception{
    if(cmd2ListLknStys==null)cmd2ListLknStys=new ToListLockinStyles();
    cmd2ListLknStys.toListLockInStyles();
  }
  public void toShowColorLibList()throws Exception{
    if(cms2ListClibs==null)cms2ListClibs=new ToListColorLibs();
    cms2ListClibs.toShowColorLibList();
  }
  public void toEditProtoStatuses()throws Exception{
    if(cmd2EditProto==null)cmd2EditProto=new ToEditProtoStatuses();
    cmd2EditProto.toEditProtoStatuses();
  }
  public void toEditLabDips()throws Exception{
    if(cmd2EditLabDip==null)cmd2EditLabDip=new ToEditLabDips();
    cmd2EditLabDip.toEditLabDips();
  }
  public void toEditAColorLibRecord()throws Exception{
    if(cmd2EditColorLib==null)cmd2EditColorLib=new ToEditColorLib();
    cmd2EditColorLib.toEditAColorLibRecord();
  }
  public void toEditPreprodHead()throws Exception{
    if(cmd2EdtPrpd==null)cmd2EdtPrpd=new ToEditAPreprodHEad();
    cmd2EdtPrpd.toEditPreprodHead();
  }
  public void toDoOrderPrint()throws Exception{
    if(cmd2OdrPrint==null)cmd2OdrPrint=new ToDoOrderPrint();
    cmd2OdrPrint.toDoOrderPrint();
  }
  public void toListStyle2Restore()throws Exception{
    if(cmd2RestoreStyle==null)cmd2RestoreStyle=new ToListStyle2Restore();
    cmd2RestoreStyle.toListStyle2Restore();
  }
  public void toEditSty_SC_SndCfm()throws processhandler.commands.CommandIncompleteException ,processhandler.commands.CommandException{
     if(cmdObjToEditSty_SC_SndCfm==null)
        cmdObjToEditSty_SC_SndCfm=new newtimes.production.process.prodmaintain.ToEditSty_SC_SndCfm();

     cmdObjToEditSty_SC_SndCfm.toEditSty_SC_SndCfm();
  }
  public void toListQryResult()throws Exception{
   try{
    if(cmd2ListQryPrpd==null)cmd2ListQryPrpd= new ToListQueryPreprod(null);
    cmd2ListQryPrpd.toListQryResult();
   }catch(Exception e){
     e.printStackTrace();
     throw e;
   }
  }
}
