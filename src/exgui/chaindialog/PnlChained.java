package exgui.chaindialog;

import java.awt.*;
import java.util.*;
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

public class PnlChained extends JPanel {
  BorderLayout borderLayout1 = new BorderLayout();
  public java.util.HashMap dialogInfos=new java.util.HashMap();
  private Responsible nextCmd=null;
  private Responsible currentCmd=null;
  protected java.util.List executedCommands=new ArrayList();
  JPanel pnl2LayOut = new JPanel();
  JPanel pnlCmds = new JPanel();
  BorderLayout borderLayout2 = new BorderLayout();
  JButton btnPrevStep = new JButton();
  JButton btnNext = new JButton();
  JButton btnCansel = new JButton();
  JButton btnFinish = new JButton();
  GridLayout gridLayout1 = new GridLayout();//allow to "go back"
  ChainedDialogNotify resultNotifyTo;
  public PnlChained() {
    try {
      jbInit();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }
  protected void jbInit() throws Exception {
    this.setLayout(borderLayout1);
    pnl2LayOut.setLayout(borderLayout2);
    pnlCmds.setLayout(gridLayout1);
    btnPrevStep.setText("Back");
    btnPrevStep.addMouseListener(new PnlChained_btnPrevStep_mouseAdapter(this));
    btnNext.setText("Next");
    btnNext.addMouseListener(new PnlChained_btnNext_mouseAdapter(this));
    btnCansel.setText("Cancel");
    btnCansel.addMouseListener(new PnlChained_btnCansel_mouseAdapter(this));
    btnFinish.setText("OK");
    btnFinish.setVisible(false);
    btnFinish.addMouseListener(new PnlChained_btnFinish_mouseAdapter(this));
    gridLayout1.setColumns(4);
    gridLayout1.setHgap(25);
    gridLayout1.setVgap(5);
    this.add(pnl2LayOut,  BorderLayout.CENTER);
    this.add(pnlCmds,  BorderLayout.SOUTH);
    pnlCmds.add(btnCansel, gridLayout1);
    pnlCmds.add(btnPrevStep, gridLayout1);
    pnlCmds.add(btnNext, gridLayout1);
    pnlCmds.add(btnFinish, gridLayout1);
  }
  public void setNofityTo(ChainedDialogNotify notifyTo){
    resultNotifyTo=notifyTo;
  }
  public boolean Init(Responsible respObj){
    pnl2LayOut.removeAll();
    JComponent jbx=respObj.getGUI();
    if(jbx==null)return false;
    pnl2LayOut.add(jbx);
    jbx.repaint();
    pnl2LayOut.validate();
    currentCmd=respObj;
    return true;
  }
  public void clickOK(){
    if(!currentCmd.isAllowOkNow()){
      clickNext();
      return;
    }
    dialogInfos.putAll(currentCmd.storedMap);
    resultNotifyTo.notifyOK();
  }
  public void clickCancel(){
    resultNotifyTo.notifyCancel();
  }
  public void clickNext(){
   //we need to handing the informations for current responsible object
   //for lookup(or create/build) next responisible object.
   try{
    nextCmd=currentCmd.next();
    //handin all the stoed data to next executer.
    if(nextCmd!=null){
      nextCmd.storedMap.putAll(currentCmd.storedMap);
      executedCommands.add(currentCmd);
      //if initail next GUI fail,we need to back to current GUI.
      if(!Init(nextCmd)){
        clickBack();
        return;
      }
      btnPrevStep.setEnabled(true);
    }else{
      //there is no further conversation to continue.close this dialog. now.
      if(!currentCmd.isAllowOkNow()){
        exgui.verification.VerifyLib.showAlert("Ambigious OK or Next step of Current Dialgo status\nPlease Notify System mamger",
                                               "Chained Dialog Responsible Object Configer Error");
        return ;
      }
      clickOK();
    }
   }catch(NextResponsibleIsNotReady nre){
     return;
   }
  }
  public void clickBack(){
    if(executedCommands.size()==0) return;
    Responsible respReturn=(Responsible)executedCommands.remove(executedCommands.size()-1);
    if(executedCommands.size()==0) btnPrevStep.setEnabled(false);
    Init(respReturn);
  }
  void btnFinish_mouseClicked(MouseEvent e) {
    clickOK();
  }

  void btnCansel_mouseClicked(MouseEvent e) {
     clickCancel();
  }

  void btnNext_mouseClicked(MouseEvent e) {
     clickNext();
  }

  void btnPrevStep_mouseClicked(MouseEvent e) {
    clickBack();
  }

}

class PnlChained_btnFinish_mouseAdapter extends java.awt.event.MouseAdapter {
  PnlChained adaptee;

  PnlChained_btnFinish_mouseAdapter(PnlChained adaptee) {
    this.adaptee = adaptee;
  }
  public void mouseClicked(MouseEvent e) {
    adaptee.btnFinish_mouseClicked(e);
  }
}

class PnlChained_btnCansel_mouseAdapter extends java.awt.event.MouseAdapter {
  PnlChained adaptee;

  PnlChained_btnCansel_mouseAdapter(PnlChained adaptee) {
    this.adaptee = adaptee;
  }
  public void mouseClicked(MouseEvent e) {
    adaptee.btnCansel_mouseClicked(e);
  }
}

class PnlChained_btnNext_mouseAdapter extends java.awt.event.MouseAdapter {
  PnlChained adaptee;

  PnlChained_btnNext_mouseAdapter(PnlChained adaptee) {
    this.adaptee = adaptee;
  }
  public void mouseClicked(MouseEvent e) {
    adaptee.btnNext_mouseClicked(e);
  }
}

class PnlChained_btnPrevStep_mouseAdapter extends java.awt.event.MouseAdapter {
  PnlChained adaptee;

  PnlChained_btnPrevStep_mouseAdapter(PnlChained adaptee) {
    this.adaptee = adaptee;
  }
  public void mouseClicked(MouseEvent e) {
    adaptee.btnPrevStep_mouseClicked(e);
  }
}
