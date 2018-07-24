package newtimes.production.process.order_change;
public class ToFieldsModify implements AbleToFieldsModify{
  public ToFieldsModify() {

  }
  public void toFieldsModify()throws Exception{
    javax.swing.JFrame jframe=processhandler.template.Properties.getMainFrame();
    newtimes.production.ProdMaintain_Properties.setWaitCursor();
    try{
      newtimes.production.gui.order_change.PnlFieldsModify      pnl=
          new newtimes.production.gui.order_change.PnlFieldsModify();
      pnl.setRecord(
           newtimes.production.process.order_change.tempDataCenter.tempStoredChangeStyleData);

      pnl.setPreferredSize(new java.awt.Dimension(780,500));
      processhandler.template.Properties.getSplitFrame().setUpperPanel(pnl);
      processhandler.template.Properties.getSplitFrame().setLowerPanel(null);
      processhandler.template.Properties.getSplitFrame().setDividerLocation(1);
      processhandler.template.Properties.getSplitFrame().repaint();
      newtimes.production.process.prodmaintain.ToCheckB4StyleProc.
          setFunctionButtonStatus(
          false, false,false,false,false,false);

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
      pnl.record2Gui();
    }finally{
       newtimes.production.ProdMaintain_Properties.setNormalCursor();
    }
  }
}
