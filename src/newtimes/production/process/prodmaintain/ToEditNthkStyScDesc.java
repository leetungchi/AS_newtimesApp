package newtimes.production.process.prodmaintain;
import database.datatype.Record;
/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class ToEditNthkStyScDesc extends ToEditStyScDesc {
  public ToEditNthkStyScDesc() {
  }
  public void toEditStyScDesc()throws Exception{
    try{
      newtimes.production.ProdMaintain_Properties.setWaitCursor();
      newtimesejb.production.Styles_SC_CT_FacadeHome ejbHome =
          (newtimesejb.production.Styles_SC_CT_FacadeHome)
          info_ejb.WeblogicServiceLocator.locateServiceHome(
          util.PublicVariable.SERVER_URL,"newtimesejb.production.Styles_SC_CT_Facade");
      newtimesejb.production.Styles_SC_CT_Facade ejb=ejbHome.create();
      java.util.HashMap hm=ejb.getAllDatasSc(
       newtimes.preproduction.Constants.CURRENT_PREPROD_HEAD_PK);
      Record prodRec=
          (Record)hm.get(ejb.KEY_RECORD_PROD_RECORD);
      java.util.Vector styles=
          (java.util.Vector)hm.get(ejb.KEY_VECTOR_STYLES);
      final newtimes.production.gui.prodmaintain.PnlStyles_SC_DESC pnl=
          new newtimes.production.gui.prodmaintain.PnlNthkStyles_SC_DESC(prodRec,styles,ejb);
      pnl.setPreferredSize(new java.awt.Dimension(pnl.getLastYPos(),800));

      newtimes.production.ProdMaintain_Properties.STYLE_TGR_PANEL.panelToPlaceEditors().removeAll();
      newtimes.production.ProdMaintain_Properties.STYLE_TGR_PANEL.panelToPlaceEditors().add(
           pnl,java.awt.BorderLayout.CENTER);
      newtimes.production.ProdMaintain_Properties.STYLE_TGR_PANEL.setPreferredSize(
           new java.awt.Dimension(750,pnl.getLastYPos()+140));

      processhandler.template.Properties.getSplitFrame().setLowerPanel(
                 newtimes.production.ProdMaintain_Properties.STYLE_TGR_PANEL
               );
        //sysste will log PO& Detail Descriptions after shipped.
       //setFunctionButtonStatus(false, true, false, false, false, false);
       if(newtimes.production.ProdMaintain_Properties.isAbleToEdit()){
         super.setFunctionButtonStatus(false, true, false, false, false, false);
       }else{
         if(util.PublicVariable.OPERATTING_CENTER.equalsIgnoreCase("NTFE")){
           super.setFunctionButtonStatus(false, false, false, false, false, false);
         }else{
           setFunctionButtonStatus(false, true, false, false, false, false);
         }
       }

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


}
