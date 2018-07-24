package newtimes.production.process.order_change;
import javax.swing.JLabel;
public class ToChangePrice implements AbleToChangePrice{
  public ToChangePrice() {

  }
  public void toChangePrice()throws Exception{
    javax.swing.JFrame jframe=processhandler.template.Properties.getMainFrame();
    newtimes.production.ProdMaintain_Properties.setWaitCursor();
    newtimes.production.process.order_change.tempDataCenter.STORED_CHG_PRX_RECORDS=
      new java.util.Vector();
    try{
      newtimes.production.gui.order_change.PnlPrxList pnl=
          new newtimes.production.gui.order_change.PnlPrxList(false);
      if(!pnl.isInitOK()){
        //processhandler.template.Properties.getCenteralControler().goBack();
        throw new processhandler.commands.CommandIncompleteException();
      }
      newtimes.production.gui.order_change.PnlPrxList pnl2=
          new newtimes.production.gui.order_change.PnlPrxList(true);
      pnl.add(new exgui.WhiteBkgBlueCharLabel("CURRENT PRICE DATA:"),
              java.awt.BorderLayout.NORTH);
      pnl.btnContinue.setEnabled(false);
      pnl.btnContinue.setVisible(false);
      pnl.setPreferredSize(new java.awt.Dimension(400,200));
      processhandler.template.Properties.getSplitFrame().setUpperPanel(pnl);
      pnl2.setPreferredSize(new java.awt.Dimension(400,200));
      pnl2.add(new exgui.BlueBkgWhiteCharLabel("PLEASE DEFINE NEW PRICE BELOW:"),
              java.awt.BorderLayout.NORTH);

      processhandler.template.Properties.getSplitFrame().setLowerPanel(pnl2);
      processhandler.template.Properties.getSplitFrame().setDividerLocation(0.5);
      processhandler.template.Properties.getSplitFrame().repaint();
      newtimes.production.process.prodmaintain.ToCheckB4StyleProc.
          setFunctionButtonStatus(
          false, false, false, false,false,false);

     /*
      processhandler.template.Properties.getSplitFrame().butnCopy.setEnabled(false);
      processhandler.template.Properties.getSplitFrame().butnNew.setEnabled(false);
      processhandler.template.Properties.getSplitFrame().butnPaste.setEnabled(false);
      processhandler.template.Properties.getSplitFrame().butnDelete.setEnabled(false);
      processhandler.template.Properties.getSplitFrame().butnEdit.setEnabled(false);
      processhandler.template.Properties.getSplitFrame().butnPrint.setEnabled(false);
      */
      processhandler.template.Properties.getSplitFrame().butnEdit.setText("CONFIRM EDIT");
      processhandler.template.Properties.getCenteralControler().setDataProcesser(null);
      jframe.getContentPane().removeAll();
      jframe.getContentPane().add(processhandler.template.Properties.getSplitFrame());
      jframe.validate();
      jframe.repaint();
      pnl.firstPage();pnl2.firstPage();
    }finally{
       newtimes.production.ProdMaintain_Properties.setNormalCursor();
    }
  }
}
