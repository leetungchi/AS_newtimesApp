package newtimes.shipping_admin.guis.shippingmaintain;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import exgui.*;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class DlgShowPoQtyDlt extends JDialog {
  JPanel panel1 = new JPanel();
  JButton btnExit = new JButton();
  JPanel pnl2PlacePOQty = new JPanel();
  BorderLayout borderLayout1 = new BorderLayout();
  public newtimes.shipping_admin.ShipPrxQty.PnlListQtyForPO pnlPoQty=null;
  BlueBkgWhiteCharLabel lblTitle = new BlueBkgWhiteCharLabel();
  String strTitle;
  public DlgShowPoQtyDlt(Frame frame, String title, boolean modal) {
    super(frame, title, modal);
    strTitle=title;
    try {
      jbInit();
      pack();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }

  public DlgShowPoQtyDlt() {
    this(null, "", false);
  }

  private void jbInit() throws Exception {
    database.datatype.Record orgRecord=
        newtimes.shipping_admin.ShippingAdmin_Const.EDITING_SHIPPING_STYLE_RECORD;

    util.MiscFunc.showProcessingMessage();

    newtimes.shipping_admin.process.shiippingmaintain.DB_ShipStyle handler=
        new newtimes.shipping_admin.process.shiippingmaintain.DB_ShipStyle(
       newtimes.shipping_admin.ShippingAdmin_Const.EDIT_SHIP_STYLE_STYLE_INT_SEQ);

    database.datatype.Record initRec=
        handler.getRecordByPk(newtimes.shipping_admin.ShippingAdmin_Const.EDIT_SHIP_STYLE_SEQ_INT);
    if(!util.PublicVariable.OPERATTING_CENTER.equals("001")){
      initRec.set("ship_sty_size_column","");
    }
    newtimes.shipping_admin.ShippingAdmin_Const.EDITING_SHIPPING_STYLE_RECORD=initRec;
    newtimes.shipping_admin.ShipPrxQty.PnlPoDetailForLauren pnl2LaurenDetail=null;
    if(!newtimes.shipping_admin.ShippingAdmin_Const.IS_LORAN_MODE){
      pnlPoQty= new newtimes.shipping_admin.ShipPrxQty.PnlListQtyForPO();
      pnlPoQty.setPreferredSize(new Dimension(745,200));
    }else{
      pnl2LaurenDetail.sty_seq=initRec.getInt("sty_seq");
      pnl2LaurenDetail.sizeString=(String)initRec.get("_$org_sty_size_column");
      pnl2LaurenDetail=new newtimes.shipping_admin.ShipPrxQty.PnlPoDetailForLauren(
       );
      pnl2LaurenDetail.setPreferredSize(new Dimension(745,200));
    }
    pnl2PlacePOQty.removeAll();
    pnl2PlacePOQty.setBounds(new Rectangle(0, 0, 10, 10));

    panel1.setLayout(null);
    btnExit.setBounds(new Rectangle(297, 267, 131, 28));
    btnExit.setFont(new java.awt.Font("Dialog", 1, 11));
    btnExit.setText("EXIT");
    btnExit.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnExit_actionPerformed(e);
      }
    });
    lblTitle.setText(strTitle);
    lblTitle.setBounds(new Rectangle(-2, 25, 776, 30));
    getContentPane().add(panel1);

    panel1.add(btnExit, null);
    if(pnlPoQty!=null){
      pnlPoQty.firstPage();
    }else{
      pnl2LaurenDetail.firstPage();
    }
    util.MiscFunc.hideProcessingMessage();
    pnl2PlacePOQty.setLayout(borderLayout1);
    pnl2PlacePOQty.setBounds(new Rectangle(15, 60, 745, 200));
    if(pnlPoQty!=null){
      pnl2PlacePOQty.add(pnlPoQty, borderLayout1.CENTER);
    }else{
      pnl2PlacePOQty.add(pnl2LaurenDetail, borderLayout1.CENTER);
    }

    panel1.add(pnl2PlacePOQty, null);
    panel1.add(lblTitle, null);
    panel1.add(pnl2PlacePOQty, null);
    this.validate();
    pnl2PlacePOQty.updateUI();
    pnl2PlacePOQty.validate();
     newtimes.shipping_admin.ShippingAdmin_Const.EDITING_SHIPPING_STYLE_RECORD=orgRecord;
  }

  void btnExit_actionPerformed(ActionEvent e) {
    this.dispose();
  }
}
