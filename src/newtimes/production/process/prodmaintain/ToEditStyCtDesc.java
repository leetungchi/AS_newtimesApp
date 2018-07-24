package newtimes.production.process.prodmaintain;
import database.datatype.Record;
public class ToEditStyCtDesc extends ToCheckB4StyleProc implements AbleToEditStyCtDesc{
  public ToEditStyCtDesc() {

  }
  public void toEditStyCtDesc()throws Exception{
    try{
      newtimes.production.ProdMaintain_Properties.setWaitCursor();
     newtimesejb.production.Styles_SC_CT_FacadeHome ejbHome =
         (newtimesejb.production.Styles_SC_CT_FacadeHome)
         info_ejb.WeblogicServiceLocator.locateServiceHome(
         util.PublicVariable.SERVER_URL,"newtimesejb.production.Styles_SC_CT_Facade");
     newtimesejb.production.Styles_SC_CT_Facade ejb=ejbHome.create();
     java.util.HashMap hm=ejb.getAllDatas(
      newtimes.preproduction.Constants.CURRENT_PREPROD_HEAD_PK);
     Record prodRec=
         (Record)hm.get(ejb.KEY_RECORD_PROD_RECORD);
     java.util.Vector styles=
         (java.util.Vector)hm.get(ejb.KEY_VECTOR_STYLES);

     newtimes.production.gui.prodmaintain.PnlStyles_CT_DESC pnl=
         new newtimes.production.gui.prodmaintain.PnlStyles_CT_DESC(prodRec,styles,ejb);
     pnl.setPreferredSize(new java.awt.Dimension(pnl.getLastYPos(),800));
     newtimes.production.ProdMaintain_Properties.STYLE_TGR_PANEL.panelToPlaceEditors().removeAll();
     newtimes.production.ProdMaintain_Properties.STYLE_TGR_PANEL.panelToPlaceEditors().add(
          pnl,java.awt.BorderLayout.CENTER);
     newtimes.production.ProdMaintain_Properties.STYLE_TGR_PANEL.setPreferredSize(
          new java.awt.Dimension(750,pnl.getLastYPos()+140));
     processhandler.template.Properties.getSplitFrame().setLowerPanel(
                newtimes.production.ProdMaintain_Properties.STYLE_TGR_PANEL
              );
       if(newtimes.production.ProdMaintain_Properties.isAbleToEdit()){
         setFunctionButtonStatus(false,true,false,false,false,false);
       }else{
         setFunctionButtonStatus(false,false,false,false,false,false);
       }
         /*
         if(newtimes.production.ProdMaintain_Properties.
            isProductionAuditConfirmedOrPrinted()){
            if(util.PublicVariable.USER_RECORD.getInt("USR_TYPE")!=
               newtimesejb.preproduction.PreProductionHead.USER_TYPE_SUPERVIOSER_MIS
               && util.PublicVariable.OPERATTING_CENTER.equals("001")){
               setFunctionButtonStatus(false,false,false,false,false,false);
            }else{
               setFunctionButtonStatus(false,true,false,false,false,false);//allow mis user to modify record
            }
         }else{
             setFunctionButtonStatus(false,true,false,false,false,false);
         }*/


     //super.setFunctionButtonStatus(false,true,false,false,false,false);
     processhandler.template.Properties.getSplitFrame().setDividerLocation(0.0);
     processhandler.template.Properties.getCenteralControler().setDataProcesser(pnl);
    }finally{
      newtimes.production.ProdMaintain_Properties.setNormalCursor();
    }
  }
}
