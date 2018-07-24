package newtimes.production.process.prodmaintain;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class ProdMaintain_CmdSet
   implements
   AbleToListFbkPoNoProdHead,
   AbleToListFbkPOColorQty,
   AbleToListFbkCutYldSummary,
   AbleToListStyles,
   AbleToListStylesNoProdHead,
   AbleToListStyColorPrice,AbleToListStyHangTag,AbleToListStyle_PS_List,
   AbleToListStyTrim,AbleToListStyWash,AbleToListStySewingShop,AbleToListStyDlvDate,
   AbleToListStyJagDate,AbleToEditStyScDesc,AbleToEditStyCtDesc,AbleToListStyHdlCharge,
   AbleToListStyQty,AbleToEditSty_SC_SndCfm,
   AbleToListStyOther,
   AbleToListPlanQuota,AbleToEdit_SC_Head,AbleToListProdColors,
   AbleToListStyleConsumption,AbleToListFabricCutSummaryDtl,
   AbleToListPlanQuotaWithProdHead,AbleToListYY1234,
   AbleToListUploadFiles,AbleToGotoOderPrint
   //AbleToEditSty_CT_SndCfm,
  {
  static  public java.awt.Color color_GRP_PLAN2ORD_PRINT=
      new java.awt.Color(50,255,255);
  static  public java.awt.Color color_GRP_MTR2FAB=
      new java.awt.Color(255,255,50);
  ToListYY1234 cmdYY1234=new ToListYY1234();
  ToListUploadFiles cmdToListUploadFiles=null;
  ToListFbkPoNoProdHead cmdToListFbkPoNoProdHead=null;
  ToListPlanQuotaWithProdHead cmdToListPlanQuotaWithProdHead=null;
  ToListFbkPOColorQty cmdToListFbkPOColorQty=null;
  ToListFbkCutYldSummary cmdToListFbkCutYldSummary=null;
  ToListStyles cmdToListStyles=null;
  ToListStylesNoProdHead cmdStyNoProdHead= null;
  ToListStyHangTag cmdStyHangTag=null;
  ToListStyle_PS_List cmdStyPs=null;
  ToListStyTrim cmdStyTrim=null;
  ToListStyWash cmdStyWash=null;
   ToListStySewingShop cmdStySwShp=null;
  ToListStyDlvDate cmdStyDlvDate=null;
  ToListStyJagDate cmdStyJagDate=null;
  ToEditStyScDesc cmdStyScDesc=null;
   ToEditStyCtDesc cmdStyCtDesc=null;
   ToListStyHdlCharge cmdStyHdlChg=null;
   ToListStyQty cmdStyQty=null;
   ToEditSty_SC_SndCfm cmdStyScSndCfm=null;
   ToListStyOther cmdStyOther=null;
   ToListPlanQuota cmdLstPlnQta=null;
   ToListProdColors cmdListProdColor=null;
   ToEdit_SC_Head cmdEdtScHd=null;
   ToListStyleConsumption cmdLstcxm=null;
   ToListFabricCutSummaryDtl cmdtoListFabricCutSummaryDtl=null;
   ToGotoOderPrint cmdToGotoOderPrint=new ToGotoOderPrint();
  public ProdMaintain_CmdSet() {
  }
 public void setCommandButtons(){
   //initialize each trigger button panel for further need.
    //String tgrString[]={"Fabric PO","Style","Order Printer"};

    String tgrString[]={"Fabric PO","Style"};
    java.util.List tgrList=new java.util.ArrayList();
    tgrList.add(new TgrToListFbkPoNoProdHead());
    tgrList.add(new TgrToListStyles());
    //tgrList.add(new TgrToDoOrderPrint());
     newtimes.production.ProdMaintain_Properties.PROD_MAIN_TGR_PANEL.setButtonActions(
       tgrString,tgrList);
       String tgrFbkString[]={"Fabric PO","COLOR QTY",
                              "Cut Yield Summary List",
                              "Cut Yield Summary List Detail" };
       java.util.List tgrFbkList=new java.util.ArrayList();
       tgrFbkList.add(new TgrToListFbkPoNoProdHead());
       tgrFbkList.add(new TgrToListFbkPOColorQty());
       tgrFbkList.add(new TgrToListFbkCutYldSummary());
       tgrFbkList.add(new TgrToListFabricCutSummaryDtl());
      newtimes.production.ProdMaintain_Properties.FABRIC_TGR_PANEL.setButtonActions(
          tgrFbkString,tgrFbkList);

    //Sty  YY   Price  HTag   PS  Trim   Wash   Sewing   Image   Del   Jag-Del   SC Desc   CT Desc  Qty  SC Cnfm  Other
             String tgrStyString[]={"Sty/PO",
                 //----
                //                    "C/T HEAD",
                //----
                                    //"Qty",
                                    "Price",
                                    "Del",
                                    "PS",
                                    "S/C Desc",
                                    "C/T Desc",
                                    "C/T Terms",
                                    "Other",
                                    "YIELD",
                                    "YY",
                     //               "Other",
                                    "HTag",
                                    "Sewing",
                                    "Wash",
                                    "Image"
                                     };
                               //"Handling Charge" removed at 0925,depends on production change form
     java.util.List tgrStyList=new java.util.ArrayList();
     tgrStyList.add(new TgrToListStylesNoProdHead());//sty
     //tgrStyList.add(new TgrToListStyQty());//qty
     //---
    // tgrStyList.add(new TgrToListNthkCtInfor());
     //---
     tgrStyList.add(new TgrToListStyColorPrice());//price
     tgrStyList.add(new TgrToListStyDlvDate());//Del
     tgrStyList.add(new TgrToListStyle_PS_List());//ps
     tgrStyList.add(new TgrToEditStyScDesc());//SCdesc
     tgrStyList.add(new TgrToEditStyCtDesc());//CTdesc
     tgrStyList.add(new TgrToListStyOther());//other
     tgrStyList.add(new TgrToListStyTrim());
     tgrStyList.add(new TgrToListStyleConsumption());//yield
     tgrStyList.add(new TgrToListYY1234());//yy
//     tgrStyList.add(new TgrToListStyTrim());//trim
     tgrStyList.add(new TgrToListStyHangTag());//hang tag

     tgrStyList.add(new TgrToListStySewingShop());//sewing
     tgrStyList.add(new TgrToListStyWash());//wash
     //tgrStyList.add(new TgrToToUploadIMG4Sty());//img
     tgrStyList.add(new TgrToListUploadFiles());//img
     //tgrStyList.add(new TgrToListStyJagDate());//Jagdate


     newtimes.production.ProdMaintain_Properties.STYLE_TGR_PANEL.setButtonActions(
                tgrStyString,tgrStyList);
     //set upper buttons to list all material buttons

//---------------------------------------------------------------------------------------
     java.util.List colorList=new java.util.ArrayList();
     int usr_type_id = 0;
     try{
         usr_type_id = util.PublicVariable.USER_RECORD.getInt("USR_TYPE");
     }catch(Exception exp){
       exp.printStackTrace();
     }
     String captions4Mtrl[]=null;
     if (usr_type_id ==
         newtimesejb.preproduction.PreProductionHead.USER_TYPE_SHIPPING_USERS ||
         usr_type_id ==
         newtimesejb.preproduction.PreProductionHead.USER_TYPE_ACCOUNTING_USERS||
         usr_type_id ==
         newtimesejb.preproduction.PreProductionHead.USER_TYPE_OTHERS) {
       captions4Mtrl=new String[]{
                                       "Sty",
                                       //"Plan",
                                       "Prod Clr",
                                       "Fab",
                                       "Extra"
                                       };

     }else{
       captions4Mtrl=new String[]{
                                       "Sty",
                                       //"Plan",
                                       "Prod Clr",
                                       "Fab",
                                       "Extra",
                                       "Print Draft",
                                       "OD Print"
                                       };

     }

                                     //"<html><body>Cost Sheet</body></html>"
     java.util.Vector  list=new java.util.Vector();
     list.add(new newtimes.production.process.prodmaintain.TgrToListStylesNoProdHead());
     colorList.add(this.color_GRP_PLAN2ORD_PRINT);
     //list.add(new newtimes.production.process.prodmaintain.TgrToListPlanQuota());
     //colorList.add(this.color_GRP_PLAN2ORD_PRINT);
     list.add(new newtimes.production.process.prodmaintain.TgrToListProdColors());
     colorList.add(this.color_GRP_PLAN2ORD_PRINT);
     list.add(new newtimes.production.process.prodmaintain.TgrToListFbkPoNoProdHead());
     colorList.add(this.color_GRP_PLAN2ORD_PRINT);
     list.add(new newtimes.production.process.prodmaintain.TgrToEdit_SC_Head());
     colorList.add(this.color_GRP_PLAN2ORD_PRINT);
     if (usr_type_id ==
         newtimesejb.preproduction.PreProductionHead.USER_TYPE_SHIPPING_USERS ||
         usr_type_id ==
         newtimesejb.preproduction.PreProductionHead.USER_TYPE_ACCOUNTING_USERS ||
         usr_type_id ==
         newtimesejb.preproduction.PreProductionHead.USER_TYPE_OTHERS) {
     }else{
       list.add(new newtimes.production.process.prodmaintain.
                TgrToEditSty_SC_SndCfm());
       colorList.add(this.color_GRP_PLAN2ORD_PRINT);
       list.add(new newtimes.preproduction.process.TgrToDoOrderPrint());
       colorList.add(this.color_GRP_PLAN2ORD_PRINT);
     }
     newtimes.production.ProdMaintain_Properties.STYLE_TGR_PANEL.appendButtonActions(
         captions4Mtrl,list,colorList);

 }
 public void toListYY1234()throws Exception{
   cmdYY1234.toListYY1234();
 }
 /*
 public void toListFbk_PO(){
   ToListFbk_PO cmd=new ToListFbk_PO();
   cmd.toListFbk_PO();
 }
 */
 public void toListUploadFiles()throws Exception{
   if(cmdToListUploadFiles==null) cmdToListUploadFiles=new ToListUploadFiles();
   cmdToListUploadFiles.toListUploadFiles();
 }
 public void toListFbkPoNoProdHead()throws Exception{
   if(cmdToListFbkPoNoProdHead==null)cmdToListFbkPoNoProdHead= new ToListFbkPoNoProdHead();
   cmdToListFbkPoNoProdHead.toListFbkPoNoProdHead();
 }
 public void toListPlanQuotaWithProdHead()throws Exception{
   if(cmdToListPlanQuotaWithProdHead==null) cmdToListPlanQuotaWithProdHead=new ToListPlanQuotaWithProdHead();
   cmdToListPlanQuotaWithProdHead.toListPlanQuotaWithProdHead();
 }
 public void toListFbkPOColorQty()throws processhandler.commands.CommandException,
                                         processhandler.commands.CommandIncompleteException{
   if(cmdToListFbkPOColorQty==null) cmdToListFbkPOColorQty=new ToListFbkPOColorQty();
   cmdToListFbkPOColorQty.toListFbkPOColorQty();
 }
 public void toListFbkCutYldSummary()throws Exception{
   if(cmdToListFbkCutYldSummary==null) cmdToListFbkCutYldSummary=new ToListFbkCutYldSummary();
   cmdToListFbkCutYldSummary.toListFbkCutYldSummary();
 }
 public void toListStyles()throws Exception{
   if(cmdToListStyles==null) cmdToListStyles=new ToListStyles();
   cmdToListStyles.toListStyles();
 }
 public void toGotoOderPrint()throws processhandler.commands.CommandException{
   cmdToGotoOderPrint.toGotoOderPrint();
 }
 public void toListStylesNoProdHead()throws Exception{
   if(cmdStyNoProdHead==null)cmdStyNoProdHead= new ToListStylesNoProdHead();
   cmdStyNoProdHead.toListStylesNoProdHead();
 }
 public void toListStyColorPrice()throws Exception{
   ToListStyColorPrice cmdStyClrPrx=new ToListStyColorPrice();
   cmdStyClrPrx.toListStyColorPrice();
 }
 public void toListStyHangTag()throws Exception{
   if(cmdStyHangTag==null)cmdStyHangTag=new ToListStyHangTag();
   cmdStyHangTag.toListStyHangTag();
 }
 public void toListStyle_PS_List()throws Exception{
   if(cmdStyPs==null)cmdStyPs=new ToListStyle_PS_List();
   cmdStyPs.toListStyle_PS_List();
 }
 public void toListStyTrim()throws Exception{
   if(cmdStyTrim==null)cmdStyTrim=new ToListStyTrim();
   cmdStyTrim.toListStyTrim();
 }
 public void toListStyWash()throws Exception{
    if(cmdStyWash==null)cmdStyWash=new ToListStyWash();
    cmdStyWash.toListStyWash();
 }
 public void toListStySewingShop()throws Exception{
   if(cmdStySwShp==null)cmdStySwShp=new ToListStySewingShop();
   cmdStySwShp.toListStySewingShop();
 }
 public void toListStyDlvDate()throws Exception{
   if(cmdStyDlvDate==null)cmdStyDlvDate=new ToListStyDlvDate();
   cmdStyDlvDate.toListStyDlvDate();
 }
 public void toListStyJagDate()throws Exception{
   if(cmdStyJagDate==null)cmdStyJagDate=new ToListStyJagDate();
   cmdStyJagDate.toListStyJagDate();
 }
 public void toEditStyScDesc()throws Exception{
   if(cmdStyScDesc==null)cmdStyScDesc=new ToEditStyScDesc();
   cmdStyScDesc.toEditStyScDesc();
 }
 public void toEditStyCtDesc()throws Exception{
   if(cmdStyCtDesc==null)cmdStyCtDesc=new ToEditStyCtDesc();
   cmdStyCtDesc.toEditStyCtDesc();
 }
 public void toListStyHdlCharge()throws Exception{
   if(cmdStyHdlChg==null)cmdStyHdlChg=new ToListStyHdlCharge();
   cmdStyHdlChg.toListStyHdlCharge();
 }
 public void toListStyQty()throws Exception{
   /*
   if(util.PublicVariable.USER_RECORD.getInt(2)==newtimesejb.preproduction.PreProductionHead.USER_TYPE_SUPERVIOSER_MIS
      && util.PublicVariable.OPERATTING_CENTER.equals("001")){
     ToListNthkStyQty toRun=new ToListNthkStyQty();
     toRun.toListStyQty();
   }else{
     if (cmdStyQty == null)cmdStyQty = new ToListStyQty();
     cmdStyQty.toListStyQty();
   }
   */
  if (cmdStyQty == null)cmdStyQty = new ToListStyQty();
  cmdStyQty.toListStyQty();

 }
 public void toEditSty_SC_SndCfm()throws processhandler.commands.CommandException,
                                         processhandler.commands.CommandIncompleteException{
   if(cmdStyScSndCfm==null)cmdStyScSndCfm=new ToEditSty_SC_SndCfm();
   cmdStyScSndCfm.toEditSty_SC_SndCfm();
 }
 /*
 public void toEditSty_CT_SndCfm()throws Exception{
   ToEditSty_CT_SndCfm cmdStyCtSndCfm=new ToEditSty_CT_SndCfm();
   cmdStyCtSndCfm.toEditSty_CT_SndCfm();
 }
 */

 public void toListStyOther()throws Exception{
   if(cmdStyOther==null)cmdStyOther=new ToListStyOther();
   cmdStyOther.toListStyOther();
 }
 /*
 public void toEditSty_SC_CT_Audit()throws Exception{
   ToEditSty_SC_CT_Audit cmdStyScCtAdt=new ToEditSty_SC_CT_Audit();
   cmdStyScCtAdt.toEditSty_SC_CT_Audit();
 }
 */
 public void toListPlanQuota()throws Exception{
   if(cmdLstPlnQta==null)cmdLstPlnQta=new ToListPlanQuota();
   cmdLstPlnQta.toListPlanQuota();
 }
 public void toListProdColors()throws Exception{
   if(cmdListProdColor==null)cmdListProdColor=new ToListProdColors();
   cmdListProdColor.toListProdColors();
 }
 public void toEdit_SC_Head()throws Exception{
    if(cmdEdtScHd==null)cmdEdtScHd=new ToEdit_SC_Head();
    cmdEdtScHd.toEdit_SC_Head();
 }
 public void toListStyleConsumption()throws Exception{
   if(cmdLstcxm==null)cmdLstcxm=new ToListStyleConsumption();
   cmdLstcxm.toListStyleConsumption();
 }
 public void toListFabricCutSummaryDtl()throws Exception{
   if(cmdtoListFabricCutSummaryDtl==null)cmdtoListFabricCutSummaryDtl=new ToListFabricCutSummaryDtl();
   cmdtoListFabricCutSummaryDtl.toListFabricCutSummaryDtl();
 }

}
