package newtimes.preproduction.process;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class ToEditAPreprodHEad implements AbleToEditPreprodHead {
  public ToEditAPreprodHEad() {
  }
 public void toEditPreprodHead()throws Exception{
   //common process to set cursor...
   javax.swing.JFrame jframe=processhandler.template.Properties.getMainFrame();
   java.awt.Cursor ksr=jframe.getContentPane().getCursor();
   //before entering this page,we need to know if countries and cities data are read..
   //long b4Call=System.currentTimeMillis();
   while(!SynchRequestor.isAllProcessFinished()){
     //do nothing....
     try{
       Thread.currentThread().sleep(100);
     }catch(Exception e){

     }
   }
   try{
     jframe.getContentPane().setCursor(new java.awt.Cursor(java.awt.Cursor.WAIT_CURSOR));
     jframe.getContentPane().removeAll();
     processhandler.template.Properties.spFrame=new exgui2.SplitFrame();
     jframe.getContentPane().add(processhandler.template.Properties.getSplitFrame());
     //specific process of doing this command.
     newtimes.preproduction.guis.PnlEditPPDHead   pnl=
         new newtimes.preproduction.guis.PnlEditPPDHead();

     pnl.orgBuyerNameString=(newtimes.preproduction.guis.tempProperties.orgProdHeadBuyerString.length()==0)?null:
        newtimes.preproduction.guis.tempProperties.orgProdHeadBuyerString.toString();
     pnl.orgMakerNameString=
         (newtimes.preproduction.guis.tempProperties.orgProdHeadMakerString.length()==0)?null:
         newtimes.preproduction.guis.tempProperties.orgProdHeadMakerString.toString();

     DB_Preprod db=DB_Preprod.getInstance();
     pnl.setPagedDataFactory(db);
     database.datatype.Record rec=processhandler.template.Properties.getCenteralControler().getCurrentEditingMasterRecord();
     pnl.setRecord(rec);
     processhandler.template.Properties.getCenteralControler().setDataProcesser(pnl);
     newtimes.preproduction.Constants.CURRENT_PREPROD_HEAD_RECORD=rec;

     newtimes.production.ProdMaintain_Properties.IS_PO_SHIPPED=null;

     if(newtimes.production.ProdMaintain_Properties.isAbleToEdit()){
       newtimes.production.process.prodmaintain.ToCheckB4StyleProc.setFunctionButtonStatus(
        false,true,true,true,true,false);

     }else{
       newtimes.production.process.prodmaintain.ToCheckB4StyleProc.setFunctionButtonStatus(false,false,true,false,false,false);

     }
     /*
     int usr_type_id=util.PublicVariable.USER_RECORD.getInt("USR_TYPE");
     if(newtimes.production.ProdMaintain_Properties.
        isProductionAuditConfirmedOrPrinted()){
        if(usr_type_id!=newtimesejb.preproduction.PreProductionHead.USER_TYPE_SUPERVIOSER_MIS
           && util.PublicVariable.OPERATTING_CENTER.equals("001")){
          //only TPE user need to check authority.
          newtimes.production.process.prodmaintain.ToCheckB4StyleProc.setFunctionButtonStatus(
            false,false,true,false,false,false);
        }else{
           newtimes.production.process.prodmaintain.ToCheckB4StyleProc.setFunctionButtonStatus(
            false,true,true,true,true,false);//allow mis user to modify record
        }
     }else{
         newtimes.production.process.prodmaintain.ToCheckB4StyleProc.setFunctionButtonStatus(
          false,true,true,true,true,false);//allow mis user to modify record
         //newtimes.production.process.prodmaintain.ToCheckB4StyleProc.setFunctionButtonStatus( false,true,true,true,true,false);
     }
      */

   /*
     newtimes.production.process.prodmaintain.TgrToListStyles tgr=
         new newtimes.production.process.prodmaintain.TgrToListStyles();
    javax.swing.JButton btn2style= processhandler.template.Properties.getSplitFrame().addExtraTriggerButton(
      "Styles",tgr);*/
   newtimes.production.process.prodmaintain.TgrGotoListStyleFromProdHead  tgr=
       new newtimes.production.process.prodmaintain.TgrGotoListStyleFromProdHead(pnl);
     javax.swing.JButton btn2style= processhandler.template.Properties.getSplitFrame().addExtraTriggerButton(
    "Styles",tgr);

     //processhandler.template.Properties.getSplitFrame().butnNew.setEnabled(false);
     pnl.setDestinationRecords(
        newtimes.production.process.prodmaintain.DB_ProdSC.getDestinations());
     pnl.setBranchesRecords(
        newtimes.production.process.prodmaintain.DB_ProdSC.getBranches());
     pnl.btnGotoStyles=btn2style;
     pnl.record2Gui();
     pnl.setBackground(new java.awt.Color(204,204,225));
     pnl.setPreferredSize(new java.awt.Dimension(755,520));
     processhandler.template.Properties.getSplitFrame().setUpperPanel(pnl);
     processhandler.template.Properties.getSplitFrame().setDividerLocation(0.99);
     processhandler.template.Properties.getSplitFrame().repaint();
     jframe.validate();jframe.repaint();
     jframe.setTitle("Newtimes ERP PRODUCTION MAINTAIN");

   }finally{
     jframe.getContentPane().setCursor(ksr);
   }

 }
}
