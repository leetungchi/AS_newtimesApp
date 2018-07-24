package newtimes.production.process.order_change;
public class ToChangeQty implements AbleToChangeQty{
  public ToChangeQty() {

  }
  public void toChangeQty()throws Exception{
    javax.swing.JFrame jframe=processhandler.template.Properties.getMainFrame();
    newtimes.production.ProdMaintain_Properties.setWaitCursor();
    try{
      newtimes.production.gui.order_change.PnlQtyList   pnl=
          new newtimes.production.gui.order_change.PnlQtyList(false);
      newtimes.production.gui.order_change.PnlQtyList   pnl2=
          new newtimes.production.gui.order_change.PnlQtyList(true);
      if(!pnl.isIniOK())
        throw new processhandler.commands.CommandIncompleteException();

      pnl.setPreferredSize(new java.awt.Dimension(480,200));
      pnl.add(new exgui.WhiteBkgBlueCharLabel("CURRENT QTY DATA:"),
              java.awt.BorderLayout.NORTH);
      pnl2.setPreferredSize(new java.awt.Dimension(480,200));
      pnl2.add(new exgui.BlueBkgWhiteCharLabel("PLEASE DEFINE NEW QTY DATA BELOW:"),
              java.awt.BorderLayout.NORTH);

      processhandler.template.Properties.getSplitFrame().setUpperPanel(pnl);

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
      newtimes.production.process.order_change.tempDataCenter.orgQtyTable2Text=
       newtimes.production.ProdMaintain_Properties.table2Text(pnl.getJtable());
      pnl.btnConfirmModify.setVisible(false);
    }finally{
       newtimes.production.ProdMaintain_Properties.setNormalCursor();
    }
  }
}
