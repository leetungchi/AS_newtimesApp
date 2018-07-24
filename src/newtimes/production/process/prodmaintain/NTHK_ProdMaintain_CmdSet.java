package newtimes.production.process.prodmaintain;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class NTHK_ProdMaintain_CmdSet extends ProdMaintain_CmdSet implements
    AbleToListNthkCtInfor{
    ToListNthkCtInfor cmdToListNthkCtInfor=null;
    ToListNthkStyles cmdToNthkListStyles=null;
    ToEditNthkStyScDesc cmdToEditNthkStyScDesc=null;
    ToListNthkStylesNoProdHead cmdToListNthkStylesNoProdHead=null;
    ToEditNthkStyCtDesc cmdToEditNthkStyCtDesc=null;
    ToGotoNthkOrderPrint cmdToGotoNthkOrderPrint=null;
    ToEditNthkScExtraCharge cmdToEditNthkScExtraCharge=null;
    ToListNthkStyQty cmdToListNthkStyQty=null;
    ToNtfePrintDraft cmdToNtfePrintDraft=null;
  public NTHK_ProdMaintain_CmdSet() {
    super();

   setCommandButtons();
  }
  void setNthkCmdButtons(){
    newtimes.production.ProdMaintain_Properties.STYLE_TGR_PANEL=new
        newtimes.preproduction.guis.PnlTabbedButtons();
    String tgrStyString[] = {
        "Sty/PO",
        "C/T HEAD",
        "Extra",
        "S/C Desc",
        "C/T Desc",
        "ORDER PRINT"
    };
    //"Handling Charge" removed at 0925,depends on production change form
    java.util.List tgrStyList = new java.util.ArrayList();
    tgrStyList.add(new TgrToListStylesNoProdHead()); //sty
    tgrStyList.add(new TgrToListNthkCtInfor()); //C/T Head
    tgrStyList.add(new TgrToEdit_SC_Head()); //Extra

    tgrStyList.add(new TgrToEditStyScDesc()); //SCdesc
    tgrStyList.add(new TgrToEditStyCtDesc()); //CTdesc
    tgrStyList.add(new newtimes.production.process.prodmaintain.TgrToGotoOderPrint()); //other

    newtimes.production.ProdMaintain_Properties.STYLE_TGR_PANEL.
        setButtonActions(tgrStyString,tgrStyList);
  }
  void setXCenterCmdButtons(){
    newtimes.production.ProdMaintain_Properties.STYLE_TGR_PANEL=new
        newtimes.preproduction.guis.PnlTabbedButtons();
    String tgrStyStringNtfe[] = {
        "Sty/PO",
        "C/T HEAD",
        "Extra",
        "PS",
        "Print Draf",
        "S/C Desc",
        "C/T Desc",
        "ORDER PRINT"
    };
    //"Handling Charge" removed at 0925,depends on production change form
    java.util.List tgrStyList = new java.util.ArrayList();
    tgrStyList.add(new TgrToListStylesNoProdHead()); //sty
    tgrStyList.add(new TgrToListNthkCtInfor()); //C/T Head
    tgrStyList.add(new TgrToEdit_SC_Head()); //Extra
    tgrStyList.add(new TgrToListStyle_PS_List()); //ps
    tgrStyList.add(new TgrToEditSty_SC_SndCfm()); //print draft

    tgrStyList.add(new TgrToEditStyScDesc()); //SCdesc
    tgrStyList.add(new TgrToEditStyCtDesc()); //CTdesc
    tgrStyList.add(new newtimes.production.process.prodmaintain.TgrToGotoOderPrint()); //other

    newtimes.production.ProdMaintain_Properties.STYLE_TGR_PANEL.
        setButtonActions(tgrStyStringNtfe,tgrStyList);
  }
  void setClaimCmdButton(){
    String tgrStyStringNtfe[] = {
        "Sty/PO",
        "C/T HEAD",
        "CLAIM",
        "Extra",
        "PS",
        "Print Draf",
        "S/C Desc",
        "C/T Desc",
        "ORDER PRINT"
    };

    java.util.List tgrStyList = new java.util.ArrayList();
    tgrStyList.add(new TgrToListStylesNoProdHead()); //sty
    tgrStyList.add(new TgrToListNthkCtInfor()); //C/T Head
    tgrStyList.add(new TgrListClaim()); //Claim
    tgrStyList.add(new TgrToEdit_SC_Head()); //Extra
    tgrStyList.add(new TgrToListStyle_PS_List()); //ps
    tgrStyList.add(new TgrToEditSty_SC_SndCfm()); //print draft

    tgrStyList.add(new TgrToEditStyScDesc()); //SCdesc
    tgrStyList.add(new TgrToEditStyCtDesc()); //CTdesc
    tgrStyList.add(new TgrToGotoOderPrint()); //other
    newtimes.production.ProdMaintain_Properties.STYLE_TGR_PANEL.setButtonActions(tgrStyStringNtfe,tgrStyList);
  }
  public void setCommandButtons(){
     //test ,if buyer is '511' & center is BW--bymkr_seq=10142
     //switch add "Claim" button
     try{
       Object obuBuyer = newtimes.preproduction.Constants.
           CURRENT_PREPROD_HEAD_RECORD.get("prod_buyer");
       if("10142".equals(obuBuyer.toString()) && newtimes.shipping_admin.ShippingAdmin_Const.isUserEric() ){
         setClaimCmdButton();
       }else{
         if(util.PublicVariable.OPERATTING_CENTER.equals("NTHK")){
           setNthkCmdButtons();
         }else{
           setXCenterCmdButtons();
         }
       }
     }catch(Exception exp){

     }
  }
  public void toEditSty_SC_SndCfm()
    throws processhandler.commands.CommandException,
    processhandler.commands.CommandIncompleteException{
       if(cmdToNtfePrintDraft==null)cmdToNtfePrintDraft=new ToNtfePrintDraft();
       cmdToNtfePrintDraft.toEditSty_SC_SndCfm();
  }
  public void toListStyQty()throws Exception{
    if(cmdToListNthkStyQty==null) cmdToListNthkStyQty=new ToListNthkStyQty();
    cmdToListNthkStyQty.toListStyQty();

  }
  public void toListStyles()throws Exception{
    if(cmdToNthkListStyles==null) cmdToNthkListStyles=new ToListNthkStyles();
    cmdToNthkListStyles.toListStyles();
  }
  public void toEditStyScDesc()throws Exception{
    if(cmdToEditNthkStyScDesc==null)cmdToEditNthkStyScDesc=new ToEditNthkStyScDesc();
    cmdToEditNthkStyScDesc.toEditStyScDesc();
  }
  public void toListNthkCtInfor()throws processhandler.commands.CommandException{
    if(cmdToListNthkCtInfor==null) cmdToListNthkCtInfor=new ToListNthkCtInfor();
    cmdToListNthkCtInfor.toListNthkCtInfor();
  }
  public void toEdit_SC_Head() throws Exception{
    if(cmdToEditNthkScExtraCharge==null) cmdToEditNthkScExtraCharge=new ToEditNthkScExtraCharge();
    cmdToEditNthkScExtraCharge.toEdit_SC_Head();
  }
  public void toEditStyCtDesc()throws Exception{
    if(cmdToEditNthkStyCtDesc==null)cmdToEditNthkStyCtDesc=new ToEditNthkStyCtDesc();
    cmdToEditNthkStyCtDesc.toEditStyCtDesc();
  }
  public void toGotoOderPrint()throws processhandler.commands.CommandException{
   if(cmdToGotoNthkOrderPrint==null)cmdToGotoNthkOrderPrint=new ToGotoNthkOrderPrint();
   cmdToGotoNthkOrderPrint.toGotoOderPrint();
 }

  public void toListStylesNoProdHead()throws Exception{
    if(cmdToListNthkStylesNoProdHead==null)cmdToListNthkStylesNoProdHead= new ToListNthkStylesNoProdHead();
    cmdToListNthkStylesNoProdHead.toListStylesNoProdHead();
  }

}
