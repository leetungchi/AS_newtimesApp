package newtimes.production.process.order_change;
import newtimes.production.gui.prodmaintain.JCompPnlStylRemark;
public class ToEditScRemark implements AbleToEditScRemark{
  public ToEditScRemark() {

  }
  public void toEditScRemark()throws Exception{
    javax.swing.JFrame jframe=processhandler.template.Properties.getMainFrame();
    newtimes.production.ProdMaintain_Properties.setWaitCursor();
    try{
      newtimes.production.gui.order_change.Pnl_Sty_SC_Rmk    pnl=
          new newtimes.production.gui.order_change.Pnl_Sty_SC_Rmk();
      JCompPnlStylRemark pnlStyScRmk=new JCompPnlStylRemark(
        newtimes.production.process.order_change.tempDataCenter.ORIGINAL_STYLE_RECORD,true);
     pnl.setStyleScRemarkPanel(pnlStyScRmk);

    newtimes.production.gui.order_change.Pnl_Sty_SC_Rmk    pnl2=
        new newtimes.production.gui.order_change.Pnl_Sty_SC_Rmk();
    JCompPnlStylRemark pnlStyScRmk2=new JCompPnlStylRemark(
      newtimes.production.process.order_change.tempDataCenter.tempStoredChangeStyleData
      ,true);
      pnl.btnCnfirmNext.setVisible(false);
      pnl.btnGetDefault.setVisible(false);
      pnl2.setStyleScRemarkPanel(pnlStyScRmk2);

      pnl.setPreferredSize(new java.awt.Dimension(650,410));
      pnl.add(new exgui.WhiteBkgBlueCharLabel("CURRENT S/C Remark DATA:"),
              java.awt.BorderLayout.NORTH);
      pnl2.setPreferredSize(new java.awt.Dimension(650,410));
      pnl2.add(new exgui.BlueBkgWhiteCharLabel("PLEASE DEFINE NEW S/C Remark BELOW:"),
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
      //pnl.firstPage();pnl2.firstPage();
      //newtimes.production.process.order_change.tempDataCenter.orgQtyTable2Text=
      // newtimes.production.ProdMaintain_Properties.table2Text(pnl.getJtable());
      //pnl.btnConfirmModify.setVisible(false);
    }finally{
       newtimes.production.ProdMaintain_Properties.setNormalCursor();
    }

  }
}
