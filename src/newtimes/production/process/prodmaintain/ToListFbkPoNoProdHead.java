package newtimes.production.process.prodmaintain;
public class ToListFbkPoNoProdHead  implements AbleToListFbkPoNoProdHead{
  public ToListFbkPoNoProdHead() {

  }
  public void toListFbkPoNoProdHead()throws Exception{
    javax.swing.JFrame jframe=processhandler.template.Properties.getMainFrame();
    java.awt.Cursor ksr=jframe.getContentPane().getCursor();
      try{
        jframe.getContentPane().setCursor(new java.awt.Cursor(java.awt.Cursor.WAIT_CURSOR));
        //specific process of doing this command.
        newtimes.production.gui.prodmaintain.PnlFbkPOList     pnl=
            new newtimes.production.gui.prodmaintain.PnlFbkPOList();
        pnl.setPreferredSize(
           new java.awt.Dimension(900,250)
         );
          newtimes.production.ProdMaintain_Properties.FABRIC_TGR_PANEL.panelToPlaceEditors().removeAll();
          newtimes.production.ProdMaintain_Properties.FABRIC_TGR_PANEL.panelToPlaceEditors().add(new javax.swing.JLabel("FABRIC PO EDIT"),java.awt.BorderLayout.NORTH);
          newtimes.production.ProdMaintain_Properties.FABRIC_TGR_PANEL.panelToPlaceEditors().add(pnl,java.awt.BorderLayout.SOUTH);
          processhandler.template.Properties.getSplitFrame().setLowerPanel(
            newtimes.production.ProdMaintain_Properties.FABRIC_TGR_PANEL
          );
         processhandler.template.Properties.getCenteralControler().setDataProcesser(pnl);
         //processhandler.template.Properties.getSplitFrame().setDividerLocation(0.4);
         processhandler.template.Properties.getSplitFrame().setDividerLocation(0.18);
         processhandler.template.Properties.getSplitFrame().repaint();
         if(newtimes.preproduction.Constants.CURRENT_PREPROD_HEAD_RECORD.getInt("PROD_BUYER")!=82){
           newtimes.production.process.prodmaintain.ToCheckB4StyleProc.
               setFunctionButtonStatus(
               true, true, true, true, true, false);
         }else{
           newtimes.production.process.prodmaintain.ToCheckB4StyleProc.
               setFunctionButtonStatus(
               false, true, true, true, false, false);
         }

         /*
         processhandler.template.Properties.getSplitFrame().butnCopy.setEnabled(true);
         processhandler.template.Properties.getSplitFrame().butnNew.setEnabled(true);
         processhandler.template.Properties.getSplitFrame().butnPaste.setEnabled(true);
         processhandler.template.Properties.getSplitFrame().butnDelete.setEnabled(true);
         processhandler.template.Properties.getSplitFrame().butnEdit.setEnabled(true);
         processhandler.template.Properties.getSplitFrame().butnPrint.setEnabled(false);
         */
      pnl.firstPage();
        //jframe.validate();jframe.repaint();
        //pnl.repaint();pnl.validate();
    }finally{
      jframe.getContentPane().setCursor(ksr);
    }
  }
}
