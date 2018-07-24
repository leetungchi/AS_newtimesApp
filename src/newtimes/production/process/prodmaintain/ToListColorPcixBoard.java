package newtimes.production.process.prodmaintain;

import newtimes.preproduction.process.*;
public class ToListColorPcixBoard extends ToCheckB4StyleProc implements AbleToListColorPcixAndBoard{
  public ToListColorPcixBoard() {

  }
  public void toListColorPcixAndBoard()throws Exception{
    javax.swing.JFrame jframe=processhandler.template.Properties.getMainFrame();
    java.awt.Cursor ksr=jframe.getContentPane().getCursor();
    try{
      jframe.getContentPane().setCursor(new java.awt.Cursor(java.awt.Cursor.WAIT_CURSOR));
      //specific process of doing this command.
      newtimes.production.gui.prodmaintain.PnlListColorPcixBoard pnl=
          new newtimes.production.gui.prodmaintain.PnlListColorPcixBoard();
      pnl.setPreferredSize(
         new java.awt.Dimension(750,270)
       );
      addLowerPanel("EDIT PCIX & BOARD",pnl);
      processhandler.template.Properties.getCenteralControler().setDataProcesser(pnl);
      //processhandler.template.Properties.getSplitFrame().setDividerLocation(0.4);
      processhandler.template.Properties.getSplitFrame().setDividerLocation(0);
      processhandler.template.Properties.getSplitFrame().repaint();
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
