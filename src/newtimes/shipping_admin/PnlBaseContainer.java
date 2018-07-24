package newtimes.shipping_admin;

import java.awt.*;
import javax.swing.*;
import processhandler.template.Properties;
import processhandler.*;
import java.awt.event.*;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class PnlBaseContainer extends JPanel {
  BorderLayout borderLayout1 = new BorderLayout();
  processhandler.DataProcesser  current_handler=null;
  JPanel jPanel1 = new JPanel();
  JPanel pnlFuncButton = new JPanel();
  BorderLayout borderLayout2 = new BorderLayout();
  public JPanel PnlExtraFunctions = new JPanel();
  FlowLayout flowLayout1 = new FlowLayout();
  public  JButton btnAdd = new JButton();
  public JButton btnConfirm = new JButton();
  public JButton btnCopy = new JButton();
  public JButton btnPast = new JButton();
  public JButton btnDelete = new JButton();
  public JButton btnAddDtl = new JButton();
  public JButton btnExit = new JButton();
  public JScrollPane ScrollPnl = new JScrollPane();
  JPanel jPanel2 = new JPanel();
  JPanel PnlTopPnl = new JPanel();
  FlowLayout flowLayout2 = new FlowLayout();
  public PnlBaseContainer(String title) {
    try {
      jbInit();
      JLabel lbl=new JLabel(title);
      lbl.setFont(new java.awt.Font("Dialog", Font.BOLD, 11));
      lbl.setForeground(new Color(255, 143, 188));
      PnlTopPnl.add(new JLabel(title),null);
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }

  public PnlBaseContainer() {
    try {
      jbInit();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }
 public void removalAddExtralButtons(){
   PnlExtraFunctions.removeAll();
 }
 public JPanel getExtraButtonPanel(){
   return PnlExtraFunctions;
 }

 public void addTriggerButton(String btnTitle,final processhandler.CommandTrigger tgr){
  JButton btn2Add=new JButton(btnTitle);
  btn2Add.setFont(new java.awt.Font("Dialog", 1, 11));
  btn2Add.addMouseListener(
     new java.awt.event.MouseAdapter(){
       public void mouseClicked(java.awt.event.MouseEvent e){
         try{
          Properties.ctnCtl.doCommandExecute(tgr);
         }catch(Exception exp){
           exp.printStackTrace();
         }
       }
     }
  );
  PnlExtraFunctions.add(btn2Add,null);
}

 public void setEditPanel(javax.swing.JPanel  processBy){
    ScrollPnl.getViewport().add((JPanel)processBy);
  if(processBy instanceof DataProcesser){
    current_handler =(DataProcesser) processBy;
    processhandler.template.Properties.getCenteralControler().
        setDataProcesser((DataProcesser) processBy);
  }


 }
 protected void jbInit() throws Exception {
    //this.setPreferredSize(new Dimension(800,600));
    this.setLayout(borderLayout1);
    jPanel1.setLayout(borderLayout2);
    pnlFuncButton.setLayout(flowLayout1);
    btnAdd.setFont(new java.awt.Font("Dialog", 1, 11));
    btnAdd.setText("ADD");
    btnAdd.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnAdd_actionPerformed(e);
      }
    });
    btnConfirm.setFont(new java.awt.Font("Dialog", 1, 11));
    btnConfirm.setText("CNFM EDIT");
    btnConfirm.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnConfirm_actionPerformed(e);
      }
    });
    btnCopy.setFont(new java.awt.Font("Dialog", 1, 11));
    btnCopy.setText("COPY");
    btnCopy.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnCopy_actionPerformed(e);
      }
    });
    btnPast.setFont(new java.awt.Font("Dialog", 1, 11));
    btnPast.setText("PASTE");
    btnPast.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnPast_actionPerformed(e);
      }
    });
    btnDelete.setFont(new java.awt.Font("Dialog", 1, 11));
    btnDelete.setText("DELETE");
    btnDelete.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnDelete_actionPerformed(e);
      }
    });
    btnAddDtl.setFont(new java.awt.Font("Dialog", 1, 11));
    btnAddDtl.setToolTipText("");
    btnAddDtl.setText("ADD DTL");
    btnExit.setFont(new java.awt.Font("Dialog", 1, 11));
    btnExit.setText("EXIT");
    btnExit.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnExit_actionPerformed(e);
      }
    });
    pnlFuncButton.setBackground(new Color(143, 143, 188));
    PnlExtraFunctions.setBackground(new Color(143, 143, 188));
    PnlTopPnl.setLayout(flowLayout2);
    PnlTopPnl.setAlignmentX((float) 0.5);
    PnlTopPnl.setAlignmentY((float) 0.5);
    PnlTopPnl.setMinimumSize(new Dimension(0, 0));
    this.add(jPanel1, BorderLayout.SOUTH);
    jPanel1.add(pnlFuncButton, BorderLayout.CENTER);
    pnlFuncButton.add(btnAdd, null);
    pnlFuncButton.add(btnConfirm, null);
    pnlFuncButton.add(btnCopy, null);
    pnlFuncButton.add(btnPast, null);
    pnlFuncButton.add(btnDelete, null);
    pnlFuncButton.add(btnExit, null);
    jPanel1.add(PnlExtraFunctions,  BorderLayout.EAST);
    PnlExtraFunctions.add(btnAddDtl, null);
    this.add(ScrollPnl, BorderLayout.CENTER);
    this.add(PnlTopPnl, BorderLayout.NORTH);

  }
  /**
   * turn on/off the enable of panel buttons.
   * @param add boolean
   * @param cnfmEdt boolean
   * @param copy boolean
   * @param past boolean
   * @param delete boolean
   */
  public void setButtons(boolean add,boolean cnfmEdt,boolean copy,boolean past,boolean delete){
    btnAdd.setEnabled(add);
    btnConfirm.setEnabled(cnfmEdt);
    btnCopy.setEnabled(copy);
    btnPast.setEnabled(past);
    btnDelete.setEnabled(delete);
  }

  void btnAdd_actionPerformed(ActionEvent e) {
    try{
      processhandler.template.Properties.getCenteralControler().getDataProcesser().doAddNew();
    }catch(Exception iie){
       iie.printStackTrace();
       util.ExceptionLog.exp2File(iie,"exception while attemp to insert record.");
       exgui.verification.VerifyLib.showAllert("Insert Fail!!");
    }

  }

  void btnConfirm_actionPerformed(ActionEvent e) {
    /**@todo butnEdit_actionPerformed(ActionEvent e) to edit recent record.*/
    try{
      processhandler.template.Properties.getCenteralControler().getDataProcesser().doUpdate();
    }catch(Exception iie){
       iie.printStackTrace();
       util.ExceptionLog.exp2File(iie,"exception while attemp to update record.");
       exgui.verification.VerifyLib.showAllert("Update Fail!!");
    }
  }

  void btnCopy_actionPerformed(ActionEvent e) {
    /**@todo butnCopy_actionPerformed(ActionEvent e) to copy recent record.*/
    try{
      processhandler.template.Properties.getCenteralControler().getDataProcesser().doCopy();
    }catch(Exception iie){
       iie.printStackTrace();
    }
  }

  void btnPast_actionPerformed(ActionEvent e) {
    /**@todo butnPaste_actionPerformed(ActionEvent e) to paste record form copy.*/
    try{
      processhandler.template.Properties.getCenteralControler().getDataProcesser().doPaste();
    }catch(Exception iie){
       iie.printStackTrace();
    }
  }

  void btnDelete_actionPerformed(ActionEvent e) {
    /**@todo butnPaste_actionPerformed(ActionEvent e) to paste record form copy.*/
    try{
      processhandler.template.Properties.getCenteralControler().getDataProcesser().doDelete();
    }catch(Exception iie){
       iie.printStackTrace();
    }
  }

  void btnExit_actionPerformed(ActionEvent e) {
    /**@todo butnPaste_actionPerformed(ActionEvent e) to paste record form copy.*/
    try{
      //nice gui does not implement "doExit" function.
      //force to use proceesshanlder to use default "goBack" command..

      if(current_handler!=null)
        current_handler.doExit();
      else
       processhandler.template.Properties.getCenteralControler().goBack();
    }catch(Exception iie){
       iie.printStackTrace();
    }
  }

}
