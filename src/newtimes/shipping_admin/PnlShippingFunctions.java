package newtimes.shipping_admin;

import java.awt.*;
//import newtimes.shipping.ShippingMenu;
import javax.swing.*;
import java.awt.event.*;
import newtimes.*;
import processhandler.template.*;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class PnlShippingFunctions
    //extends ShippingMenu {
    extends JPanel{
  JButton btnShippingMtn = new JButton();
  JButton btnExti = new JButton();
  newtimes.Frame1 frame;
  //JFrame frame;
  public PnlShippingFunctions(newtimes.Frame1 frm) {
  //public PnlShippingFunctions(JFrame frm) {
    try {
      frame=frm;
      jbInit();

    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }

  void jbInit() throws Exception {
    btnShippingMtn.setBackground(Color.white);
    btnShippingMtn.setBounds(new Rectangle(276, 53, 238, 27));
    btnShippingMtn.setText("Edit Shipping Head & Detail");
    btnShippingMtn.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnShippingMtn_actionPerformed(e);
      }
    });
    this.setLayout(null);
    btnExti.setBackground(Color.white);
    btnExti.setBounds(new Rectangle(413, 413, 84, 22));
    btnExti.setText("EXIT");
    btnExti.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnExti_actionPerformed(e);
      }
    });
    this.setBackground(new Color(204, 204, 225));
    this.add(btnShippingMtn, null);
    this.add(btnExti, null);
  }

  void btnExti_actionPerformed(ActionEvent e) {
     ShippingAdmin_Const.DB_SHIP_SRN_HEAD_HANDLER=
         new newtimes.shipping_admin.process.shiippingmaintain.DB_ShipMaster();
     frame.showPanel(new MainFunction(frame));
  }

  void btnShippingMtn_actionPerformed(ActionEvent e) {
   try{
     //if( newtimes.shipping_admin.guis.shippingmaintain.PnlShipMaster.branches==null){
     //}

      //Properties.getCenteralControler().setSystemCommander(Constants.CMD_INIT_APP_GUI);
       Properties.getCenteralControler().setSystemCommander(
          newtimes.shipping_admin.ShippingAdmin_Const.SHIPPING_ADMIN_COMMAND);
       processhandler.template.Properties.getCenteralControler().setDataProcesser(null);
       Properties.getCenteralControler().doCommandExecute(
       new newtimes.shipping_admin.process.shiippingmaintain.TgrToQryShipMaster());
    }catch(Exception eP){
      eP.printStackTrace();
    }

  }
}
