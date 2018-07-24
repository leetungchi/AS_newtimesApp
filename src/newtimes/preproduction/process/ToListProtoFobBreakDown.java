package newtimes.preproduction.process;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class ToListProtoFobBreakDown extends ToInitUperAndDownPnl implements AbleToListProtoFobBreakDown {
  public ToListProtoFobBreakDown() {
  }
  public void toListProtoFobBreakDown()throws Exception{
    javax.swing.JFrame jframe=processhandler.template.Properties.getMainFrame();
    try{
      jframe.getContentPane().setCursor(new java.awt.Cursor(java.awt.Cursor.WAIT_CURSOR));
      util.PublicVariable.APP_FRAME.setCursor(new java.awt.Cursor(java.awt.Cursor.WAIT_CURSOR));
      //specific process of doing this command.
      //setPreProdDisplayer();//set display preproduction head data to uper pannel.
      //before goto the lab disp status ,we have to check the preprod color lib are avaialbe or not..
      DB_PrxBrkDn db=DB_PrxBrkDn.getInstanceOfPrxBrkdn();
      java.util.Vector pclibs=db.getAvailableColorLibs(
          newtimes.preproduction.Constants.CURRENT_PREPROD_HEAD_PK
      );
      if(pclibs.size()==0){
        exgui.verification.VerifyLib.showPlanMsg(
            "Please Define Color Libraries Before Editing Price Break Down",
            "Please Define Color Libraries Before Editing Price Break Down"
        );
        throw new processhandler.commands.CommandIncompleteException();
      }
      newtimes.preproduction.guis.PnlPrxBrkDnList  pnl=
          new newtimes.preproduction.guis.PnlPrxBrkDnList();
      pnl.setPreferredSize(new java.awt.Dimension(400,150));

      //processhandler.template.Properties.getSplitFrame().setLowerPanel(pnl);
      toSetPanelUnderButtons(pnl,"Price Break Down");

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
      util.PublicVariable.APP_FRAME.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
      jframe.getContentPane().setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
    }
  }
}
