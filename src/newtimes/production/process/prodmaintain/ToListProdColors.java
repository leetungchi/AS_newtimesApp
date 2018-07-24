package newtimes.production.process.prodmaintain;
import newtimes.preproduction.process.*;
public class ToListProdColors extends ToInitUperAndDownPnl implements AbleToListProdColors{
  public ToListProdColors() {

  }
  public void toListProdColors()throws Exception{
    javax.swing.JFrame jframe=processhandler.template.Properties.getMainFrame();
    java.awt.Cursor ksr=jframe.getContentPane().getCursor();
    try{
      jframe.getContentPane().setCursor(new java.awt.Cursor(java.awt.Cursor.WAIT_CURSOR));
      //specific process of doing this command.
      newtimes.production.gui.prodmaintain.PnlListProdColors pnl=
          new newtimes.production.gui.prodmaintain.PnlListProdColors();
      pnl.setPreferredSize(
         new java.awt.Dimension(750,270)
       );
      toSetPanelUnderButtons(pnl,"PRODUCTION COLORS");
      processhandler.template.Properties.getCenteralControler().setDataProcesser(pnl);
      //processhandler.template.Properties.getSplitFrame().setDividerLocation(0.4);
      processhandler.template.Properties.getSplitFrame().setDividerLocation(0.18);
      processhandler.template.Properties.getSplitFrame().repaint();
      if(newtimes.production.ProdMaintain_Properties.isAbleToEdit()){
        newtimes.production.process.prodmaintain.ToCheckB4StyleProc.setFunctionButtonStatus(
          true,true,true,true,true,false);
      }else{
        newtimes.production.process.prodmaintain.ToCheckB4StyleProc.setFunctionButtonStatus(
              false,false,true,false,false,false);
      }
      /*
      if(newtimes.production.ProdMaintain_Properties.
         isProductionAuditConfirmedOrPrinted()){
         if(util.PublicVariable.USER_RECORD.getInt("USR_TYPE")!=
            newtimesejb.preproduction.PreProductionHead.USER_TYPE_SUPERVIOSER_MIS
            && util.PublicVariable.OPERATTING_CENTER.equals("001")){
            newtimes.production.process.prodmaintain.ToCheckB4StyleProc.setFunctionButtonStatus(
                  false,false,true,false,false,false);
         }else{
            newtimes.production.process.prodmaintain.ToCheckB4StyleProc.setFunctionButtonStatus(
                  true,true,true,true,true,false);//allow mis user to modify record
         }
      }else{
          newtimes.production.process.prodmaintain.ToCheckB4StyleProc.setFunctionButtonStatus(
            true,true,true,true,true,false);
      }*/


      //newtimes.production.process.prodmaintain.ToCheckB4StyleProc.setFunctionButtonStatus(true,true,true,true,true,true);


      jframe.validate();jframe.repaint();
      pnl.firstPage();
    }finally{
      jframe.getContentPane().setCursor(ksr);
    }
  }
}
