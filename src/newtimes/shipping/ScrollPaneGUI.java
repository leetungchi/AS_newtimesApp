package newtimes.shipping;

import java.awt.*;
import java.awt.event.*;
import newtimes.*;
import javax.swing.*;
import exgui2.SplitFrame;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public abstract class ScrollPaneGUI extends SplitFrame {
  Frame1 frame;
  protected JButton butnIC = new JButton();
  protected JButton butnAddDetail = new JButton();
  protected JButton butnSC = new JButton();
  protected JScrollPane jScrollPane1 = new JScrollPane();
  private JPanel jPanel1 = new JPanel();
  private BorderLayout borderLayout1 = new BorderLayout();
  private JLabel jLabel1 = new JLabel();
  private JPanel jPanel2 = new JPanel();

  protected ScrollPaneGUI() {
    this(null);
  }

  protected ScrollPaneGUI(Frame1 _frame) {
    frame = _frame;
    try {
      jbInit();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }
  void jbInit() throws Exception {
    this.setLayout(null);
    this.setSize(800,600);
    this.setBackground(new Color(204, 204, 225));
    jScrollPane1.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
    jScrollPane1.setAutoscrolls(true);
    jScrollPane1.setBorder(BorderFactory.createEtchedBorder());
    jScrollPane1.setBounds(new Rectangle(0, 58, 793, 487));
    jPanel1.setLayout(borderLayout1);
    jLabel1.setBounds(new Rectangle(117, 15, 566, 24));
    jLabel1.setHorizontalAlignment(SwingConstants.CENTER);
    jLabel1.setBorder(BorderFactory.createEtchedBorder());
    jLabel1.setForeground(new Color(10,36,106));
    jLabel1.setFont(new java.awt.Font("Dialog", 1, 13));
    this.add(jLabel1, null);
    this.add(jScrollPane1, null);
  }

  protected void set3Buttons() {
    butnIC.setBackground(Color.lightGray);
    butnIC.setBounds(new Rectangle(601, 549, 44, 21));
    butnIC.setFont(new java.awt.Font("Dialog", 1, 11));
    butnIC.setBorder(BorderFactory.createEtchedBorder());
    butnIC.setText("I / C");
    butnAddDetail.setBackground(Color.lightGray);
    butnAddDetail.setBounds(new Rectangle(652, 549, 72, 21));
    butnAddDetail.setFont(new java.awt.Font("Dialog", 1, 11));
    butnAddDetail.setBorder(BorderFactory.createEtchedBorder());
    butnAddDetail.setText("ADD-DETAIL");
    butnSC.setBackground(Color.lightGray);
    butnSC.setBounds(new Rectangle(731, 549, 44, 21));
    butnSC.setFont(new java.awt.Font("Dialog", 1, 11));
    butnSC.setBorder(BorderFactory.createEtchedBorder());
    butnSC.setText("S / C");
    funcationPanel.setBounds(new Rectangle(0, 545, 575, 30));
    jPanel2.setBounds(new Rectangle(575, 545, 225, 30));
    jPanel2.setBackground(new Color(143, 143, 188));
//    this.add(butnIC, null);
    this.add(butnAddDetail, null);
    this.add(butnSC, null);
    this.add(jPanel2, null);
  }

  protected boolean setPanelWithButtons() {
    try {
      this.remove(jSplitPane);
      this.repaint();
      this.validate();
      return true;
    } catch (Exception e) {
      e.printStackTrace();
      return false;
    }
  }

  protected void setScrollPaneGUI(JPanel pnl) {
    this.jScrollPane1.getViewport().add(pnl);
  }

  protected void setTitleName(String titleName) {
    jLabel1.setText("      ============  "+titleName+"  ============      ");
  }

  public void butnExit_actionPerformed(ActionEvent e) {
    /**@todo butnExit_actionPerformed(ActionEvent e) to previous screen.*/
    setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
    try{
      this.do_Exit();
    }catch(Exception iie){
       iie.printStackTrace();
       util.ExceptionLog.exp2File(iie,"exception while attempt to exit.");
    }
    setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
  }

  public void butnPrint_actionPerformed(ActionEvent e) {
    /**@todo butnPrint_actionPerformed(ActionEvent e) to print screen.*/
    setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
    try{
      this.do_Print();
    }catch(Exception iie){
       iie.printStackTrace();
       util.ExceptionLog.exp2File(iie,"exception while attempt to print.");
    }
    setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
  }

  public void butnDelete_actionPerformed(ActionEvent e) {
    /**@todo butnDelete_actionPerformed(ActionEvent e) to delete recent record.*/
    setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
    try{
      this.do_Delete();
    }catch(Exception iie){
       iie.printStackTrace();
       util.ExceptionLog.exp2File(iie,"exception while attempt to delete record.");
       exgui.verification.VerifyLib.showAllert("Delete Failed!!");
    }
    setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
  }

  public void butnPaste_actionPerformed(ActionEvent e) {
    /**@todo butnPaste_actionPerformed(ActionEvent e) to paste record form copy.*/
    setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
    try{
      this.do_Paste();
    }catch(Exception iie){
       iie.printStackTrace();
       util.ExceptionLog.exp2File(iie,"exception while attempt to paste record.");
    }
    setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
  }

  public void butnCopy_actionPerformed(ActionEvent e) {
    /**@todo butnCopy_actionPerformed(ActionEvent e) to copy recent record.*/
    setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
    try{
      this.do_Copy();
    }catch(Exception iie){
       iie.printStackTrace();
       util.ExceptionLog.exp2File(iie,"exception while attempt to copy record.");
    }
    setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
  }

  public void butnEdit_actionPerformed(ActionEvent e) {
    /**@todo butnEdit_actionPerformed(ActionEvent e) to edit recent record.*/
    setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
    try{
      this.do_Edit();
    }catch(Exception iie){
       iie.printStackTrace();
       util.ExceptionLog.exp2File(iie,"exception while attemp to update record.");
       exgui.verification.VerifyLib.showAllert("Update Failed!!");
    }
    setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
  }

  public void butnNew_actionPerformed(ActionEvent e) {
    /**@todo butnNew_actionPerformed(ActionEvent e) to new record.*/
    setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
    try{
      this.do_New();
    }catch(Exception iie){
       iie.printStackTrace();
       util.ExceptionLog.exp2File(iie,"exception while attempt to insert record.");
       exgui.verification.VerifyLib.showAllert("Insert Failed!!");
    }
    setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
  }

  public abstract void do_Copy();
  public abstract void do_Delete();
  public abstract void do_Edit();
  public abstract void do_Exit();
  public abstract void do_New();
  public abstract void do_Paste();
  public abstract void do_Print();
}
