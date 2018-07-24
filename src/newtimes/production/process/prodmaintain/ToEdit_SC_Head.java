package newtimes.production.process.prodmaintain;
import newtimes.preproduction.process.*;
public class ToEdit_SC_Head  extends ToInitUperAndDownPnl  implements AbleToEdit_SC_Head{
  public ToEdit_SC_Head() {

  }
  public void toEdit_SC_Head()throws Exception{
    javax.swing.JFrame jframe=processhandler.template.Properties.getMainFrame();
    java.awt.Cursor ksr=jframe.getContentPane().getCursor();
    try{
      jframe.getContentPane().setCursor(new java.awt.Cursor(java.awt.Cursor.WAIT_CURSOR));
      //specific process of doing this command.
      newtimes.production.gui.prodmaintain.PnlSC_Head   pnl=
          new newtimes.production.gui.prodmaintain.PnlSC_Head();
      pnl.setPreferredSize(
         new java.awt.Dimension(780,385)
       );
      newtimes.production.process.prodmaintain.DB_ProdSC handler=
       newtimes.production.process.prodmaintain.DB_ProdSC.getInstanceOfProdSCHandler();
      pnl.setPagedDataFactory(handler);
      /*
       the object "newtimes.production.ProdMaintain_Properties.EDITIONG_PRODUCTION_RECORD  "
       should be assigned with editing detail of proeuction data.
      */
     newtimes.production.ProdMaintain_Properties.EDITIONG_PRODUCTION_RECORD=
         handler.getRecordByPk(newtimes.preproduction.Constants.CURRENT_PREPROD_HEAD_PK);
      pnl.setRecord(
           newtimes.production.ProdMaintain_Properties.EDITIONG_PRODUCTION_RECORD
          );
      processhandler.template.Properties.getCenteralControler().setDataProcesser(pnl);
      pnl.record2Gui();
      toSetPanelUnderButtons(pnl);
      //processhandler.template.Properties.getSplitFrame().setDividerLocation(0.4);
      processhandler.template.Properties.getSplitFrame().setDividerLocation(0.18);
      processhandler.template.Properties.getSplitFrame().repaint();

      if(newtimes.production.ProdMaintain_Properties.isAbleToEdit()){
        newtimes.production.process.prodmaintain.ToCheckB4StyleProc.setFunctionButtonStatus(
          false,true,true,true,false,false);//allow mis user to modify record
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
             false,true,true,true,false,false);//allow mis user to modify record
         }
      }else{
          newtimes.production.process.prodmaintain.ToCheckB4StyleProc.setFunctionButtonStatus(
             false,true,true,true,false,false);
      }*/

      /*
      newtimes.production.process.prodmaintain.ToCheckB4StyleProc.
          setFunctionButtonStatus(
          false, true, true, true,false,false);*/
      /*
      processhandler.template.Properties.getSplitFrame().butnCopy.setEnabled(true);
      processhandler.template.Properties.getSplitFrame().butnNew.setEnabled(false);
      processhandler.template.Properties.getSplitFrame().butnPaste.setEnabled(true);
      processhandler.template.Properties.getSplitFrame().butnDelete.setEnabled(false);
      processhandler.template.Properties.getSplitFrame().butnEdit.setEnabled(true);
      processhandler.template.Properties.getSplitFrame().butnPrint.setEnabled(false);
      */
      jframe.validate();jframe.repaint();
    }finally{
      jframe.getContentPane().setCursor(ksr);
    }
  }
}
