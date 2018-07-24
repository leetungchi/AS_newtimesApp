package newtimes.shipping_admin.guis.shippingmaintain;

import java.awt.*;
import javax.swing.*;
import exgui.*;
import java.awt.event.*;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class DlgShipExtraTPE extends DlgShipExtra {
  public DlgShipExtraTPE(Frame frame, String title, boolean modal,
                      JcmpPnlShipExtra edit2,
                      PnlShipMaster shipMaster){
    super(frame,title,modal,edit2,shipMaster);
 }
  protected void jButton1_actionPerformed(ActionEvent e) {
    try{
      /*
      if(pnlTarget.getDisplayingRecords().size()==0){
        dispose();
        return;
      }*/
      if(!pnlTarget.confirmUpdate())return;
      pnlTarget.doUpdate();
      javax.swing.JTable tbl=pnlTarget.getJtable();
      String totalExtraDesc="";
      newtimes.shipping_admin.process.shiippingmaintain.DB_ShipExtra handler=
        (newtimes.shipping_admin.process.shiippingmaintain.DB_ShipExtra)pnlTarget.getPagedDataFactory();
      if(tbl.getRowCount()==0){
        handler.setExtraDesc2ShipRec("");
        setNetNegoLabel();
        handler.setExtraDesc2ShipRec("");
        pnlShipMaster.txtAreaShipExtra.setText("");
        newtimes.shipping_admin.ShippingAdmin_Const.SHIPPING_EDITING_HEAD_RECORD.set(
                "ship_extra_desc",
                "");
        pnlShipMaster.PnlShipExtra.repaint();
        pnlShipMaster.PnlShipExtra.validate();
        dispose();
      }else{
        setNetNegoLabel();
        totalExtraDesc=
            newtimes.production.ProdMaintain_Properties.table2Text(tbl);
        StringBuffer sb=new StringBuffer(totalExtraDesc);
        sb.append("\n");
        sb.append("TOTAL NET AMOUNT:");sb.append(lblTtlNetAmt.getText());
        sb.append("  ");
        sb.append("TOTAL NEGO AMOUNT:");sb.append(lblTtlNegoAmt.getText());
        handler.setExtraDesc2ShipRec(sb.toString());
        pnlShipMaster.txtAreaShipExtra.setText(sb.toString());
        newtimes.shipping_admin.ShippingAdmin_Const.SHIPPING_EDITING_HEAD_RECORD.set(
                "ship_extra_desc",
                sb.toString());
        pnlShipMaster.PnlShipExtra.repaint();
        pnlShipMaster.PnlShipExtra.validate();
        dispose();
      }
    }catch(Exception exp){
       exp.printStackTrace();
       util.ExceptionLog.exp2File(exp,"error while update ship_extra_desc");
    }


  }
}
