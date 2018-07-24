package newtimes.shipping_admin.guis.shippingmaintain;

import java.awt.*;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import java.awt.event.*;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class DlgEditShipStyleQtyPrx extends JDialog {
  JPanel panel1 = new JPanel();
  BorderLayout borderLayout1 = new BorderLayout();
  protected int myOperationStatus=0;
  public static int STATUS_OPERATING=0;
  public static int STATUS_CLOSE_NORMALLY=1;
  public static int STATUS_CLOSE_CANCEL=2;
  JPanel ButtonPanels = new JPanel();
  JPanel PnlCenterPanel = new JPanel();
  JButton btnNew = new JButton();
  JButton btnDelete = new JButton();
  JButton btnUpdate = new JButton();
  JButton btnExit = new JButton();
  processhandler.DataProcesser currentProcesser;
  BorderLayout borderLayout2 = new BorderLayout();
  JPanel jPanel1 = new JPanel();
  BorderLayout borderLayout3 = new BorderLayout();
  JPanel jPanel2 = new JPanel();
  JPanel jPanel3 = new JPanel();
  JToggleButton btnPrx = new JToggleButton();
  JToggleButton btnQty = new JToggleButton();
  ButtonGroup buttonGroup1 = new ButtonGroup();
  Jcmp_PrxList priceEditer=null;
  Jcmp_QtyList qtyEditer=null;
  JPanel Pnl2ContanTable = new JPanel();
  BorderLayout borderLayout4 = new BorderLayout();
  public DlgEditShipStyleQtyPrx(Frame frame, String title, boolean modal,javax.swing.text.JTextComponent txt2show) {
    super(frame, title, modal);
    try {
       /*
       newtimes.production.ProdMaintain_Properties.setWaitCursor();
       priceEditer=new Jcmp_PrxList();
       qtyEditer=new Jcmp_QtyList(txt2show);
       jbInit();
       btnQty_actionPerformed(null);
       */
      newtimes.production.ProdMaintain_Properties.setWaitCursor();
      priceEditer=new Jcmp_PrxList();
      if(PnlEditShipStyle.isEditingShipQty){
        qtyEditer=new Jcmp_QtyList(txt2show);
      }
      jbInit();
      if(PnlEditShipStyle.isEditingShipQty){
        btnQty_actionPerformed(null);
      }

      pack();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }finally{
      newtimes.production.ProdMaintain_Properties.setNormalCursor();
    }
  }
  public void show(){
    this.myOperationStatus=STATUS_OPERATING;
    super.show();
  }

  public DlgEditShipStyleQtyPrx() {
    this(null, "",false,null);
  }

  private void jbInit() throws Exception {
    panel1.setLayout(borderLayout1);
    btnNew.setFont(new java.awt.Font("Dialog", 1, 11));
    btnNew.setText("ADD NEW");
    btnNew.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnNew_actionPerformed(e);
      }
    });
    btnDelete.setFont(new java.awt.Font("Dialog", 1, 11));
    btnDelete.setText("DELETE");
    btnDelete.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnDelete_actionPerformed(e);
      }
    });
    btnUpdate.setFont(new java.awt.Font("Dialog", 1, 11));
    btnUpdate.setText("SAVE");
    btnUpdate.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnUpdate_actionPerformed(e);
      }
    });
    btnExit.setFont(new java.awt.Font("Dialog", 1, 11));
    btnExit.setText("EXIT");
    btnExit.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnExit_actionPerformed(e);
      }
    });
    PnlCenterPanel.setLayout(borderLayout2);
    jPanel1.setLayout(borderLayout3);
    btnPrx.setFont(new java.awt.Font("Dialog", 1, 11));
    btnPrx.setText("EDIT PRICE");
    btnPrx.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnPrx_actionPerformed(e);
      }
    });
    btnQty.setFont(new java.awt.Font("Dialog", 1, 11));
    btnQty.setBorderPainted(true);
    btnQty.setSelected(true);
    btnQty.setText("EDIT QTY");
    btnQty.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnQty_actionPerformed(e);
      }
    });
    Pnl2ContanTable.setLayout(borderLayout4);
    getContentPane().add(panel1);
    panel1.add(ButtonPanels, BorderLayout.SOUTH);
    panel1.add(PnlCenterPanel, BorderLayout.CENTER);
    PnlCenterPanel.add(jPanel1, BorderLayout.NORTH);
    jPanel1.add(jPanel2,  BorderLayout.CENTER);
    jPanel1.add(jPanel3,  BorderLayout.WEST);
    jPanel3.add(btnQty, null);
    jPanel3.add(btnPrx, null);
    PnlCenterPanel.add(Pnl2ContanTable, BorderLayout.CENTER);
    ButtonPanels.add(btnNew, null);
    ButtonPanels.add(btnDelete, null);
    ButtonPanels.add(btnUpdate, null);
    ButtonPanels.add(btnExit, null);
    buttonGroup1.add(btnQty);
    buttonGroup1.add(btnPrx);
  }

  void btnPrx_actionPerformed(ActionEvent e) {
    if(currentProcesser==priceEditer)return;
    //test if qty editer is not svaed yet...
    if(currentProcesser!=null && currentProcesser.isContextModified()){
      if(!exgui.verification.VerifyLib.showConfirm("Content Modified,Do you want to leave without confirmation?",
                                             "Content Modified")){
        btnQty.setSelected(true);
        return;
      }
    }
    try{
      this.setCursor(new Cursor(Cursor.WAIT_CURSOR));
      newtimes.production.ProdMaintain_Properties.setWaitCursor();
      priceEditer.reload();
      Pnl2ContanTable.removeAll();
      Pnl2ContanTable.add(priceEditer, null);
      btnNew.setText("ADD NEW");
      btnNew.setEnabled(false);
      btnDelete.setEnabled(false);
      currentProcesser = priceEditer;
      Pnl2ContanTable.validate();
      Pnl2ContanTable.repaint();
      newtimes.production.ProdMaintain_Properties.setNormalCursor();
    }finally{
      this.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
    }
  }

  void btnQty_actionPerformed(ActionEvent e) {
    try{
      if(!newtimes.shipping_admin.guis.shippingmaintain.PnlEditShipStyle.isEditingShipQty){
        exgui.verification.VerifyLib.showAlert(
         "Sorry,This IS Packing Style,Please Edit Qty In Packing Unit",
         "Qty Is Only Allow To Edit In Packing Unit.");
         return;
      }
      if (currentProcesser == qtyEditer)return;
      //test if qty editer is not svaed yet...
      if (currentProcesser != null && currentProcesser.isContextModified()) {
        if (!exgui.verification.VerifyLib.showConfirm(
            "Content Modified,Do you want to leave without confirmation?",
            "Content Modified")) {
          btnPrx.setSelected(true);
          return;
        }
      }
      this.setCursor(new Cursor(Cursor.WAIT_CURSOR));
      newtimes.production.ProdMaintain_Properties.setWaitCursor();
      qtyEditer.reload();
      Pnl2ContanTable.removeAll();
      Pnl2ContanTable.add(qtyEditer, null);
      btnNew.setText("ADD NEW COLOR");
      btnNew.setEnabled(true);
      btnDelete.setEnabled(true);
      currentProcesser = qtyEditer;
      Pnl2ContanTable.validate();
      Pnl2ContanTable.repaint();
      newtimes.production.ProdMaintain_Properties.setNormalCursor();
    }finally{
      this.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
    }

  }

  void btnNew_actionPerformed(ActionEvent e) {
    try{
      newtimes.production.ProdMaintain_Properties.setWaitCursor();
      currentProcesser.doAddNew();
    }catch(Exception exp){
      exp.printStackTrace();
    }finally{
      newtimes.production.ProdMaintain_Properties.setNormalCursor();
    }
  }

  void btnDelete_actionPerformed(ActionEvent e) {
    try{
      newtimes.production.ProdMaintain_Properties.setWaitCursor();
      currentProcesser.doDelete();
    }catch(Exception exp){
      exp.printStackTrace();
    }finally{
      newtimes.production.ProdMaintain_Properties.setNormalCursor();
    }
  }

  void btnUpdate_actionPerformed(ActionEvent e) {
    try{
      newtimes.production.ProdMaintain_Properties.setWaitCursor();
      currentProcesser.doUpdate();
    }catch(Exception exp){
      exp.printStackTrace();
    }finally{
      newtimes.production.ProdMaintain_Properties.setNormalCursor();
    }
  }

  void btnExit_actionPerformed(ActionEvent e) {
    this.dispose();
  }
}
