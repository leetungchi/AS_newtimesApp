package newtimes.production.process.prodmaintain;
import newtimes.preproduction.process.*;
public class ToEditNthkScExtraCharge   extends ToCheckB4StyleProc  implements AbleToEdit_SC_Head{
  public ToEditNthkScExtraCharge() {

  }
  public void toEdit_SC_Head()throws Exception{
    javax.swing.JFrame jframe=processhandler.template.Properties.getMainFrame();
    java.awt.Cursor ksr=jframe.getContentPane().getCursor();
    try{
      jframe.getContentPane().setCursor(new java.awt.Cursor(java.awt.Cursor.WAIT_CURSOR));
      //specific process of doing this command.
      newtimes.production.gui.prodmaintain.PnlNthkScExtraCharge   pnl=
          new newtimes.production.gui.prodmaintain.PnlNthkScExtraCharge();
      final newtimes.production.gui.prodmaintain.PnlNthkScExtraCharge tmpPnl2Fks=pnl;
      newtimes.production.process.prodmaintain.DB_ProdSC handler=
       newtimes.production.process.prodmaintain.DB_ProdSC.getInstanceOfProdSCHandler();
      pnl.setPagedDataFactory(handler);
     newtimes.production.ProdMaintain_Properties.EDITIONG_PRODUCTION_RECORD=
         handler.getRecordByPk(newtimes.preproduction.Constants.CURRENT_PREPROD_HEAD_PK);
      pnl.setRecord(newtimes.production.ProdMaintain_Properties.EDITIONG_PRODUCTION_RECORD);

      processhandler.template.Properties.getCenteralControler().setDataProcesser(pnl);
      pnl.record2Gui();



      pnl.setPreferredSize(
         //new java.awt.Dimension(780,385)
         new java.awt.Dimension(780,pnl.getFinaCtPosition())
       );

   newtimes.production.ProdMaintain_Properties.STYLE_TGR_PANEL.panelToPlaceEditors().removeAll();
   newtimes.production.ProdMaintain_Properties.STYLE_TGR_PANEL.panelToPlaceEditors().add(
        pnl,java.awt.BorderLayout.CENTER);
   newtimes.production.ProdMaintain_Properties.STYLE_TGR_PANEL.setPreferredSize(
        new java.awt.Dimension(780,pnl.getFinaCtPosition()+50));

   processhandler.template.Properties.getSplitFrame().setLowerPanel(
              newtimes.production.ProdMaintain_Properties.STYLE_TGR_PANEL
            );

    if(newtimes.production.ProdMaintain_Properties.isAbleToEdit()){
      newtimes.production.process.prodmaintain.ToCheckB4StyleProc.setFunctionButtonStatus(
         false,true,false,false,false,false);
    }else{
      newtimes.production.process.prodmaintain.ToCheckB4StyleProc.setFunctionButtonStatus(
           false,false,false,false,false,false);
    }
     /*
      if(newtimes.production.ProdMaintain_Properties.
         isProductionAuditConfirmedOrPrinted()){
         if(util.PublicVariable.USER_RECORD.getInt("USR_TYPE")!=
            newtimesejb.preproduction.PreProductionHead.USER_TYPE_SUPERVIOSER_MIS
            && util.PublicVariable.OPERATTING_CENTER.equals("001")){
            newtimes.production.process.prodmaintain.ToCheckB4StyleProc.setFunctionButtonStatus(
                 false,false,false,false,false,false);
         }else{
           newtimes.production.process.prodmaintain.ToCheckB4StyleProc.setFunctionButtonStatus(
             false,true,false,false,false,false);//allow mis user to modify record
         }
      }else{
          newtimes.production.process.prodmaintain.ToCheckB4StyleProc.setFunctionButtonStatus(
             false,true,false,false,false,false);
      }*/

      /*
      newtimes.production.process.prodmaintain.ToCheckB4StyleProc.
          setFunctionButtonStatus(
          false, true, false, false,false,false);*/
      jframe.validate();jframe.repaint();
      //txtXtaChgRmk_1
      javax.swing.SwingUtilities.invokeLater(
       new Runnable(){
        public void run() {
           tmpPnl2Fks.txtXtaChgRmk_1.grabFocus();
        }
        }
      );


    }finally{
      jframe.getContentPane().setCursor(ksr);
    }
  }
}
