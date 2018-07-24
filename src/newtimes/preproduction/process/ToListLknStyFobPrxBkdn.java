package newtimes.preproduction.process;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class ToListLknStyFobPrxBkdn extends ToInitUperAndDownPnl implements AbleToListLknStyFobPrxBkdn {
  public ToListLknStyFobPrxBkdn() {
  }
  public void toListLknStyFobPrxBkdn()throws Exception{
    //common process to set cursor...
    javax.swing.JFrame jframe=processhandler.template.Properties.getMainFrame();
    java.awt.Cursor ksr=jframe.getContentPane().getCursor();
    try{
      jframe.getContentPane().setCursor(new java.awt.Cursor(java.awt.Cursor.WAIT_CURSOR));
      //specific process of doing this command.
      //setPreProdDisplayer();//set display preproduction head data to uper pannel.
      /*
      newtimes.preproduction.guis.PnlPseudoLknStyleBrkDwn      pnl=
          new newtimes.preproduction.guis.PnlPseudoLknStyleBrkDwn();
      pnl.setSize(800,300);
      toSetPanelUnderButtons(pnl);
      */

      //processhandler.template.Properties.getSplitFrame().setLowerPanel(pnl);
      processhandler.template.Properties.getSplitFrame().repaint();
      exgui.verification.VerifyLib.showAlert("ToListLknStyFobPrxBkdn is not implemented","ToListLknStyFobPrxBkdn is not implemented");
      throw new Exception(" this function is no mare be used.");
    }finally{
      jframe.getContentPane().setCursor(ksr);
    }


  }
}
