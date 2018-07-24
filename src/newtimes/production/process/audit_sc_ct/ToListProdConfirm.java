package newtimes.production.process.audit_sc_ct;
public class ToListProdConfirm implements AbleToListProdConfirm{
  public ToListProdConfirm() {
    //test for svc
  }
  public void toListProdConfirm()throws Exception{
    javax.swing.JFrame jframe=processhandler.template.Properties.getMainFrame();
    newtimes.production.ProdMaintain_Properties.setWaitCursor();
    try{
      newtimes.production.gui.audit_sc_ct.PnlListPrdCnfm  pnl=
          new newtimes.production.gui.audit_sc_ct.PnlListPrdCnfm();
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
      jframe.getContentPane().removeAll();
      jframe.getContentPane().add(processhandler.template.Properties.getSplitFrame());
      jframe.validate();
      jframe.repaint();
      if(util.ApplicationProperites.getProperties(
          "newtimes.production.gui.audit_sc_ct.PnlListPrdCnfm.PagePageRowAt")==null){
         util.ApplicationProperites.setProperties("newtimes.production.gui.audit_sc_ct.PnlListPrdCnfm.PagePageRowAt"
                                                  ,new Integer(0));
      }
      pnl.gotoRowPosition(((Integer)util.ApplicationProperites.getProperties(
          "newtimes.production.gui.audit_sc_ct.PnlListPrdCnfm.PagePageRowAt")).intValue());
      processhandler.template.Properties.getCenteralControler().setDataProcesser(null);

    }finally{
       newtimes.production.ProdMaintain_Properties.setNormalCursor();
    }
  }
}
