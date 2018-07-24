package newtimes.preproduction.process;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class ToListDupStatuses extends ToInitUperAndDownPnl implements AbleToListDupStatuses  {
  public ToListDupStatuses() {
  }
  public void toListDupStatuses()throws Exception{
    //common process to set cursor...
    //javax.swing.JFrame jframe=processhandler.template.Properties.getMainFrame();
    //java.awt.Cursor ksr=jframe.getContentPane().getCursor();
    try{
      //jframe.getContentPane().setCursor(new java.awt.Cursor(java.awt.Cursor.WAIT_CURSOR));
      //specific process of doing this command.
      //setPreProdDisplayer();//set display preproduction head data to uper pannel.
       DB_DupsStatus db=DB_DupsStatus.getInstanceOfDupsStatus();
       db.setProdHeadKP(newtimes.preproduction.Constants.CURRENT_PREPROD_HEAD_PK);
       if(db.lockinstyleRecords.size()==0){
         exgui.verification.VerifyLib.showPlanMsg(
            "Please Define Lock In Styles Before editing Dups"
            ,"Please Define Lockin Styles"
         );
         throw new processhandler.commands.CommandIncompleteException();
       }
       if(db.pclibRecords.size()==0){
         exgui.verification.VerifyLib.showPlanMsg(
            "Please Define Color Libraries Before editing Dups"
            ,"Please  Define Color Libraries"
         );
         throw new processhandler.commands.CommandIncompleteException();
       }
      newtimes.preproduction.guis.PnlDupsStatusList pnl=new
          newtimes.preproduction.guis.PnlDupsStatusList();
      pnl.setPreferredSize(new java.awt.Dimension(400,150));
      toSetPanelUnderButtons(pnl);
      processhandler.template.Properties.getCenteralControler().setDataProcesser(pnl);
      //processhandler.template.Properties.getSplitFrame().setLowerPanel(pnl);
      toSetPanelUnderButtons(pnl,"Dups Status List");
      processhandler.template.Properties.getSplitFrame().setDividerLocation(0.5);
      processhandler.template.Properties.getSplitFrame().repaint();
      pnl.firstPage();
      //disable some buttons...
      newtimes.production.process.prodmaintain.ToCheckB4StyleProc.setFunctionButtonStatus(
        true,true,true,true,true,true);
      /*
      processhandler.template.Properties.getSplitFrame().butnCopy.setEnabled(true);
      processhandler.template.Properties.getSplitFrame().butnNew.setEnabled(true);
      processhandler.template.Properties.getSplitFrame().butnPaste.setEnabled(true);
      processhandler.template.Properties.getSplitFrame().butnDelete.setEnabled(true);
      processhandler.template.Properties.getSplitFrame().butnEdit.setEnabled(true);
      processhandler.template.Properties.getSplitFrame().butnPrint.setEnabled(true);
      */
    }finally{
     // jframe.getContentPane().setCursor(ksr);
    }

  }

}
