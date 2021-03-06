package newtimes.preproduction.process;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class ToEditProtoStatuses extends ToInitUperAndDownPnl implements AbleToEditProtoStatuses {
  public ToEditProtoStatuses() {
  }
  public void toEditProtoStatuses()throws Exception{
    //common process to set cursor...
    try{
      //specific process of doing this command.
      //setPreProdDisplayer();//set display preproduction head data to uper pannel.
      //before goto the lab disp status ,we have to check the preprod color lib are avaialbe or not..
      DB_Proto db=DB_Proto.getProtoInstance();
      java.util.Vector pclibs=db.getAvailableColorLibs(
          newtimes.preproduction.Constants.CURRENT_PREPROD_HEAD_PK
      );
      if(pclibs.size()==0){
        exgui.verification.VerifyLib.showPlanMsg(
            "Please Define Color Libraries Before Editing Proto Status",
            "Please Define Color Libraries Before Editing Proto Status"
        );
        throw new processhandler.commands.CommandIncompleteException();
      }
      newtimes.preproduction.guis.PnlProtoSttsList  pnl=
          new newtimes.preproduction.guis.PnlProtoSttsList();
      pnl.setPreferredSize(new java.awt.Dimension(400,150));

      //processhandler.template.Properties.getSplitFrame().setLowerPanel(pnl);
      toSetPanelUnderButtons(pnl,"Proto Status");

      processhandler.template.Properties.getCenteralControler().setDataProcesser(pnl);
      processhandler.template.Properties.getSplitFrame().repaint();
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
      pnl.firstPage();
    }finally{
      //jframe.getContentPane().setCursor(ksr);
    }

  }
}
