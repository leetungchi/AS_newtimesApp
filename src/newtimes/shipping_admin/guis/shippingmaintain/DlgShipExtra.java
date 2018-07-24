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

public class DlgShipExtra extends JDialog {
  JPanel panel1 = new JPanel();
  JScrollPane ScrolPnl = new JScrollPane();
  JButton btnAddNew = new JButton();
  JButton btnDelete = new JButton();
  JButton jButton1 = new JButton();
  JPanel jPanel1 = new JPanel();
  BlueBkgWhiteCharLabel lblHeadTtlNetAmt = new BlueBkgWhiteCharLabel();
  JLabel lblTtlNetAmt = new JLabel();
  JLabel lblTtlNegoAmt = new JLabel();
  BlueBkgWhiteCharLabel lblHeadTtlNego = new BlueBkgWhiteCharLabel();
  JcmpPnlShipExtra pnlTarget;
  PnlShipMaster pnlShipMaster;
  static java.text.DecimalFormat df=new java.text.DecimalFormat("##########.00");
  public DlgShipExtra(Frame frame, String title, boolean modal,
                      JcmpPnlShipExtra edit2,
                      PnlShipMaster shipMaster) {
    super(frame, title, modal);
    try {
      pnlTarget=edit2;
      pnlShipMaster =shipMaster;
      jbInit();
      pack();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }

  public DlgShipExtra() {
    this(null, "", false,null,null);
  }

  protected void jbInit() throws Exception {
    btnAddNew.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnAddNew_actionPerformed(e);
      }
    });
    btnDelete.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnDelete_actionPerformed(e);
      }
    });
    jButton1.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        jButton1_actionPerformed(e);
      }
    });
    this.setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
    panel1.add(pnlTarget, null);
    panel1.add(btnDelete, null);
    panel1.add(lblHeadTtlNetAmt, null);
    panel1.add(lblTtlNetAmt, null);
    panel1.add(lblHeadTtlNego, null);
    panel1.add(lblTtlNegoAmt, null);
    panel1.add(btnAddNew, null);
    panel1.add(jButton1, null);
    //ScrolPnl.getViewport().add(pnlTarget, null);
    panel1.setLayout(null);
    pnlTarget.setBounds(new Rectangle(3, 15, 640, 236));
    btnAddNew.setBounds(new Rectangle(17, 302, 84, 26));
    btnAddNew.setFont(new java.awt.Font("Dialog", 1, 11));
    btnAddNew.setText("NEW");
    btnDelete.setBounds(new Rectangle(138, 302, 97, 26));
    btnDelete.setFont(new java.awt.Font("Dialog", 1, 11));
    btnDelete.setText("DELETE");
    jButton1.setBounds(new Rectangle(306, 302, 209, 26));
    jButton1.setFont(new java.awt.Font("Dialog", 1, 11));
    jButton1.setText("CONFIRM EDIT AND EXIT");
    lblHeadTtlNetAmt.setText("TOTAL NET AMOUNT:");
    lblHeadTtlNetAmt.setBounds(new Rectangle(3, 261, 172, 23));
    lblTtlNetAmt.setFont(new java.awt.Font("Dialog", 1, 11));
    lblTtlNetAmt.setText("");
    lblTtlNetAmt.setBounds(new Rectangle(175, 262, 122, 23));
    lblTtlNegoAmt.setBounds(new Rectangle(493, 264, 146, 23));
    lblTtlNegoAmt.setText("");
    lblTtlNegoAmt.setFont(new java.awt.Font("Dialog", 1, 11));
    lblHeadTtlNego.setBounds(new Rectangle(321, 263, 172, 23));
    lblHeadTtlNego.setText("TOTAL NEGO AMOUNT:");
    this.getContentPane().add(panel1, BorderLayout.CENTER);
    setNetNegoLabel();
  }
  protected void setNetNegoLabel()throws Exception{
    newtimes.shipping_admin.process.shiippingmaintain.DB_ShipExtra handler=
      (newtimes.shipping_admin.process.shiippingmaintain.DB_ShipExtra)pnlTarget.getPagedDataFactory();
    database.datatype.Record netRec=handler.getTotalNetAmt();
    database.datatype.Record negoRec=handler.getTotalNegoAmt();
    Object netObj=netRec.get(1);//use GET_TOTAL_NET_DOC_PRX_AMT data,not GET_TOTAL_NET_AMT
    Object negoObj=negoRec.get(0);
    String netStr=(netObj==null)?"0":df.format(netObj);
    String negoStr=(negoObj==null)?"0":df.format(negoObj);
    lblTtlNetAmt.setText(netStr);
    lblTtlNegoAmt.setText(negoStr);
  }
  void btnAddNew_actionPerformed(ActionEvent e) {
     try{
       if(pnlTarget.getJtable().getRowCount()<20){
         pnlTarget.doAddNew();
         setNetNegoLabel();
       }else{
         exgui.verification.VerifyLib.showPlanMsg("Can Not More Than 20 Records",
                                                  "Can Not More Than 20 Records");
         return;
       }
     }catch(Exception exp){
       exp.printStackTrace();
       util.ExceptionLog.exp2File(exp,"");
     }
  }

  void btnDelete_actionPerformed(ActionEvent e) {
    try{
      pnlTarget.doDelete();
      setNetNegoLabel();
    }catch(Exception exp){
      exp.printStackTrace();
      util.ExceptionLog.exp2File(exp,"");
    }
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
        totalExtraDesc="\n\n\n";
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
