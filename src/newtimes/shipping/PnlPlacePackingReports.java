package newtimes.shipping;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class PnlPlacePackingReports extends JPanel {
  BorderLayout borderLayout1 = new BorderLayout();
  JSplitPane jSplitPane1 = new JSplitPane();
  JScrollPane jScrollTopPan = new JScrollPane();
  JScrollPane jScrollButtomPan = new JScrollPane();
  JPanel PnlFuncs = new JPanel();
  public JButton jButton1 = new JButton();
  public JButton jButtonToQueryGUI = new JButton();
  JPanel jPanel1 = new JPanel();
  public   boolean exitByTrigger=false;
  public PnlPlacePackingReports() {
    try {
      jbInit();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }

  protected void jbInit() throws Exception {
    this.setLayout(borderLayout1);
    jSplitPane1.setOrientation(JSplitPane.VERTICAL_SPLIT);
    jSplitPane1.setDividerSize(10);
    jSplitPane1.setRightComponent(null);
    jButton1.setFont(new java.awt.Font("Dialog", 1, 11));
    jButton1.setText("EXIT");
    jButton1.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        jButton1_actionPerformed(e);
      }
    });

    jScrollTopPan.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
    jScrollTopPan.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
    jButtonToQueryGUI.setFont(new java.awt.Font("Dialog", 1, 11));
    jButtonToQueryGUI.setText("To Shipment Entry");
    jButtonToQueryGUI.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        jButtonToQueryGUI_actionPerformed(e);
      }
    });
    this.add(jSplitPane1, BorderLayout.CENTER);
    jSplitPane1.add(jScrollTopPan, JSplitPane.TOP);
    jSplitPane1.add(jScrollButtomPan, JSplitPane.BOTTOM);
    this.add(PnlFuncs,  BorderLayout.SOUTH);
    PnlFuncs.add(jButtonToQueryGUI, null);
    PnlFuncs.add(jPanel1, null);
    PnlFuncs.add(jButton1, null);
  }
  public void setDivision(double ratio){
    jSplitPane1.setDividerLocation(ratio);
  }
  public void setPanel(JPanel pnl1,JPanel pnl2){
    jScrollTopPan.getViewport().removeAll();
    jScrollTopPan.getViewport().add(pnl1,null);

    jScrollButtomPan.getViewport().removeAll();
    jScrollButtomPan.getViewport().add(pnl2,null);
    this.validate();
    this.repaint();
  }

  void jButton1_actionPerformed(ActionEvent e) {
    try{
     if(exitByTrigger){
       processhandler.template.Properties.getCenteralControler().goBack();
      }else{
        newtimes.Frame1 frame=(newtimes.Frame1)util.PublicVariable.APP_FRAME ;
        setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        frame.showPanel(new newtimes.shipping.ShippingMenu(frame));
        setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
      }
    }catch(Exception exp){
       exp.printStackTrace();
    }
  }

  void jButtonToQueryGUI_actionPerformed(ActionEvent e) {
    try{
        //Properties.getCenteralControler().setSystemCommander(Constants.CMD_INIT_APP_GUI);
        newtimes.production.ProdMaintain_Properties.setWaitCursor();
        newtimes.shipping_admin.ShippingAdmin_Const.DESTINATIONS=
               newtimes.production.process.prodmaintain.DB_ProdSC.getDestinations();
         processhandler.template.Properties.getCenteralControler().setSystemCommander(
            newtimes.shipping_admin.ShippingAdmin_Const.SHIPPING_ADMIN_COMMAND);

         processhandler.template.Properties.getCenteralControler().setDataProcesser(null);

         processhandler.template.Properties.getCenteralControler().doCommandExecute(
                new newtimes.shipping_admin.process.shiippingmaintain.TgrToQryShipMaster());

      }catch(Exception eP){
        eP.printStackTrace();
      }finally{
        newtimes.production.ProdMaintain_Properties.setNormalCursor();
      }
  }
}
