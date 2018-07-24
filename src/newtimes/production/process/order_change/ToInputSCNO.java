package newtimes.production.process.order_change;
import newtimes.production.process.order_change.DB_ProdSC_Qry;
public class ToInputSCNO implements AbleToInputSCNO{
  public ToInputSCNO() {

  }
  public void toInputSCNO()throws Exception{
    javax.swing.JFrame jframe=processhandler.template.Properties.getMainFrame();
    newtimes.production.ProdMaintain_Properties.setWaitCursor();
    try{
      DB_ProdSC_Qry dbHandler=new DB_ProdSC_Qry();
      if(!dbHandler.isInitOk())
        throw new processhandler.commands.CommandIncompleteException();
      newtimes.production.gui.order_change.PnlInputSCNO     pnl=
          new newtimes.production.gui.order_change.PnlInputSCNO(dbHandler);
      pnl.setPreferredSize(new java.awt.Dimension(780,500));
      processhandler.template.Properties.getSplitFrame().setUpperPanel(pnl);
      processhandler.template.Properties.getSplitFrame().setLowerPanel(null);
      processhandler.template.Properties.getSplitFrame().setDividerLocation(1);
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
    }catch(Exception e){
      e.printStackTrace();
    }finally{
       newtimes.production.ProdMaintain_Properties.setNormalCursor();
    }
  }
}
