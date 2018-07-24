package newtimes.production.process.prodmaintain;
import processhandler.commands.CommandException;
import processhandler.*;
import database.datatype.*;
/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class TgrToEditNthkStyeXCtDesc extends TgrToEditStyCtDesc {
  int prod_head_pk;
  public TgrToEditNthkStyeXCtDesc(int _prod_pk) {
    prod_head_pk=_prod_pk;
  }
  public void showCtDesc()throws Exception{
    try{
      newtimes.production.ProdMaintain_Properties.setWaitCursor();
     newtimesejb.production.Styles_SC_CT_FacadeHome ejbHome =
         (newtimesejb.production.Styles_SC_CT_FacadeHome)
         info_ejb.WeblogicServiceLocator.locateServiceHome(
         util.PublicVariable.SERVER_URL,"newtimesejb.production.Styles_SC_CT_Facade");
     newtimesejb.production.Styles_SC_CT_Facade ejb=ejbHome.create();
     java.util.HashMap hm=ejb.getAllDatas(prod_head_pk);
     Record prodRec=
         (Record)hm.get(ejb.KEY_RECORD_PROD_RECORD);
     java.util.Vector styles=
         (java.util.Vector)hm.get(ejb.KEY_VECTOR_STYLES);

    final newtimes.production.gui.prodmaintain.PnlNthkStyles_CT_DESC pnl=
         new newtimes.production.gui.prodmaintain.PnlNthkStyles_CT_DESC(prodRec,styles,ejb,
         prod_head_pk);
     pnl.setPreferredSize(new java.awt.Dimension(pnl.getLastYPos(),800));
     newtimes.production.ProdMaintain_Properties.STYLE_TGR_PANEL.panelToPlaceEditors().removeAll();
     newtimes.production.ProdMaintain_Properties.STYLE_TGR_PANEL.panelToPlaceEditors().add(
          pnl,java.awt.BorderLayout.CENTER);
     newtimes.production.ProdMaintain_Properties.STYLE_TGR_PANEL.setPreferredSize(
          new java.awt.Dimension(750,pnl.getLastYPos()+140));
     processhandler.template.Properties.getSplitFrame().setLowerPanel(
                newtimes.production.ProdMaintain_Properties.STYLE_TGR_PANEL
              );
     ToCheckB4StyleProc.setFunctionButtonStatus(false,true,false,false,false,false);
     processhandler.template.Properties.getSplitFrame().addExtraTriggerButton("To Head",
       new newtimes.preproduction.process.TrggerEditAPreprod());

     processhandler.template.Properties.getSplitFrame().setDividerLocation(0.0);
     processhandler.template.Properties.getCenteralControler().setDataProcesser(pnl);

     javax.swing.SwingUtilities.invokeLater(
      new Runnable(){
       public void run() {
          pnl.prodHeadScRemark.txtProdHeadRMK.grabFocus();
       }
       }
     );


    }finally{
      newtimes.production.ProdMaintain_Properties.setNormalCursor();
    }

  }
  protected void activateThisProcess() throws processhandler.commands.CommandException {
    /**@todo Implement this processhandler.CommandTrigger abstract method*/
    processhandler.template.Properties.getCenteralControler().setSystemCommander(
           newtimes.production.ProdMaintain_Properties.CMDS_PROD_MAINTAIN
          );
    commander=processhandler.template.Properties.getCenteralControler().getCurrentSystemCommand();

    if(commander==null)
      throw new CommandException("commander is null");
       try{
         showCtDesc();
         //((AbleToEditStyCtDesc)commander).toEditStyCtDesc();
         //ctnCtl.recordProcess(this);
       }catch(processhandler.commands.CommandIncompleteException cie){

       }catch(Exception e){
          e.printStackTrace();
          throw new CommandException(e.getMessage());
       }
  }
}
