package newtimes.preproduction.guis;
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

public class ScrollButtons extends JPanel {
  BorderLayout borderLayout1 = new BorderLayout();
  JPanel ArrowPnl = new JPanel();
  JPanel btnPnl = new JPanel();
  GridLayout gridLayout1 = new GridLayout();
  JButton arrorLeft = new JButton();
  JButton arrorRight = new JButton();
  BorderLayout borderLayout2 = new BorderLayout();
  JScrollPane scroolPane = new JScrollPane();
  JPanel pnlPlsBtns = new JPanel();
  GridLayout gridLayout2 = new GridLayout();
  Point currentViewPoint=null;
  int BUTTON_SIZE=0;
  int MAX_BUTTON_SIZE=0;
  boolean IS_LEFTWORD=false;
  boolean IS_TO_SCROOL=false;
  boolean IS_TIMMER_RUNNING=false;
  public ScrollButtons() {
    try {
      jbInit();
      MyTimer timer=new MyTimer();
      new Thread(timer).start();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }
  void jbInit() throws Exception {
    this.setLayout(borderLayout1);
    ArrowPnl.setLayout(gridLayout1);
    gridLayout1.setColumns(2);
    gridLayout1.setHgap(1);
    gridLayout1.setRows(1);
    gridLayout1.setVgap(3);
    arrorRight.setMargin(new Insets(0, 0, 0, 0));
    arrorRight.setIcon(exgui.UIHelper.getIcon("next.gif"));
    arrorRight.addMouseMotionListener(new ScrollButtons_arrorRight_mouseMotionAdapter(this));
    arrorRight.addMouseListener(new ScrollButtons_arrorRight_mouseAdapter(this));
    arrorLeft.setMargin(new Insets(0, 0, 0, 0));
    arrorLeft.setIcon(exgui.UIHelper.getIcon("prev.gif"));
    arrorLeft.addMouseMotionListener(new ScrollButtons_arrorLeft_mouseMotionAdapter(this));
    arrorLeft.addMouseListener(new ScrollButtons_arrorLeft_mouseAdapter(this));
    btnPnl.setLayout(borderLayout2);
    scroolPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
    scroolPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
    pnlPlsBtns.setLayout(gridLayout2);
    gridLayout2.setHgap(3);
    ArrowPnl.addMouseMotionListener(new ScrollButtons_ArrowPnl_mouseMotionAdapter(this));
    ArrowPnl.addMouseListener(new ScrollButtons_ArrowPnl_mouseAdapter(this));
    this.addMouseListener(new ScrollButtons_this_mouseAdapter(this));
    btnPnl.addMouseListener(new ScrollButtons_btnPnl_mouseAdapter(this));
    this.addMouseMotionListener(new ScrollButtons_this_mouseMotionAdapter(this));
    borderLayout1.setHgap(3);
    borderLayout1.setVgap(3);
    this.add(ArrowPnl, BorderLayout.WEST);
    ArrowPnl.add(arrorLeft, null);
    ArrowPnl.add(arrorRight, null);
    this.add(btnPnl, BorderLayout.CENTER);
    btnPnl.add(scroolPane, BorderLayout.CENTER);
    //pnlPlsBtns.setPreferredSize(this.getPreferredSize());
    scroolPane.getViewport().add(pnlPlsBtns, null);
    currentViewPoint=new Point(0,0);
  }
  public final GridLayout  getButtonsGridLayOut(){return gridLayout2;}
  public void addButtons(JButton butts[]){
    pnlPlsBtns.removeAll();
    gridLayout2.setColumns(butts.length);
    for(int i=0;i<butts.length;i++)pnlPlsBtns.add(butts[i]);
    pnlPlsBtns.validate();
    pnlPlsBtns.updateUI();
    BUTTON_SIZE=(int)butts[0].getPreferredSize().getWidth();
    MAX_BUTTON_SIZE=BUTTON_SIZE*butts.length;
    scroolPane.validate();
    scroolPane.updateUI();
  }
 synchronized void TestToRun(){
    if(IS_TO_SCROOL){
      if(IS_LEFTWORD){
        doScrollLeft();
      }else{
        doScrollRight();
      }
    }
  }
  public void forceToStopScroll(){
    IS_TO_SCROOL=false;
    IS_TIMMER_RUNNING=false;
  }
  public void doScrollLeft(){
    if(scroolPane.getHorizontalScrollBar().getValue()<0){
    }else{
       int addedValue=scroolPane.getHorizontalScrollBar().getValue()
           -scroolPane.getHorizontalScrollBar().getBlockIncrement();
            scroolPane.getHorizontalScrollBar().setValue(addedValue);
    }
  }
  public void doScrollRight(){
    int addedValue=scroolPane.getHorizontalScrollBar().getValue()+
        scroolPane.getHorizontalScrollBar().getBlockIncrement();
    if(addedValue>= scroolPane.getHorizontalScrollBar().getMaximum()){
    }else{
      scroolPane.getHorizontalScrollBar().setValue(addedValue);
    }
  }

  void arrorRight_mousePressed(MouseEvent e) {
      IS_TO_SCROOL=true;
      IS_TIMMER_RUNNING=true;
      IS_LEFTWORD=false;
  }

  void arrorLeft_mousePressed(MouseEvent e) {
     IS_TO_SCROOL=true;
     IS_TIMMER_RUNNING=true;
     IS_LEFTWORD=true;
  }

  void arrorRight_mouseDragged(MouseEvent e) {
      IS_TO_SCROOL=true;
  }

  void arrorLeft_mouseDragged(MouseEvent e) {
      IS_TO_SCROOL=true;
  }

  void arrorRight_mouseReleased(MouseEvent e) {
      IS_TO_SCROOL=false;
      IS_TIMMER_RUNNING=false;
  }

  void arrorRight_mouseMoved(MouseEvent e) {
     IS_TO_SCROOL=IS_TIMMER_RUNNING;
  }

  void arrorRight_mouseExited(MouseEvent e) {
     IS_TO_SCROOL=false;
     IS_TIMMER_RUNNING=false;
  }

  void arrorLeft_mouseExited(MouseEvent e) {
    IS_TO_SCROOL=false;
    IS_TIMMER_RUNNING=false;
  }

  void arrorLeft_mouseMoved(MouseEvent e) {
    IS_TO_SCROOL=IS_TIMMER_RUNNING;
  }

  void arrorLeft_mouseReleased(MouseEvent e) {
     IS_TO_SCROOL=false;
     IS_TIMMER_RUNNING=false;
  }

  class MyTimer implements Runnable{
     public void run(){
       while(true){
         try {
           //TestToRun();
           if(IS_TO_SCROOL&&IS_TIMMER_RUNNING){
             if(IS_LEFTWORD){
               doScrollLeft();
             }else{
               doScrollRight();
             }
           }
           Thread.currentThread().sleep(10);
         }catch (java.lang.InterruptedException e) {

         }
       }
     }
   }

  void ArrowPnl_mouseDragged(MouseEvent e) {
     IS_TO_SCROOL=false;
     IS_TIMMER_RUNNING=false;
  }

  void ArrowPnl_mouseEntered(MouseEvent e) {
    IS_TO_SCROOL=false;
    IS_TIMMER_RUNNING=false;
  }

  void this_mouseEntered(MouseEvent e) {
    IS_TO_SCROOL=false;
    IS_TIMMER_RUNNING=false;
  }

  void btnPnl_mouseEntered(MouseEvent e) {
    IS_TO_SCROOL=false;
    IS_TIMMER_RUNNING=false;
  }

  void this_mouseMoved(MouseEvent e) {
    IS_TO_SCROOL=false;
    IS_TIMMER_RUNNING=false;
    //System.out.println("this mouse over");
  }

  void this_mouseDragged(MouseEvent e) {
    IS_TO_SCROOL=false;
    IS_TIMMER_RUNNING=false;
    //System.out.println("this mouse draged");
  }
}


class ScrollButtons_arrorRight_mouseAdapter extends java.awt.event.MouseAdapter {
  ScrollButtons adaptee;

  ScrollButtons_arrorRight_mouseAdapter(ScrollButtons adaptee) {
    this.adaptee = adaptee;
  }
  public void mousePressed(MouseEvent e) {
    adaptee.arrorRight_mousePressed(e);
  }
  public void mouseReleased(MouseEvent e) {
    adaptee.arrorRight_mouseReleased(e);
  }
  public void mouseExited(MouseEvent e) {
    adaptee.arrorRight_mouseExited(e);
  }
}

class ScrollButtons_arrorLeft_mouseAdapter extends java.awt.event.MouseAdapter {
  ScrollButtons adaptee;

  ScrollButtons_arrorLeft_mouseAdapter(ScrollButtons adaptee) {
    this.adaptee = adaptee;
  }
  public void mousePressed(MouseEvent e) {
    adaptee.arrorLeft_mousePressed(e);
  }
  public void mouseExited(MouseEvent e) {
    adaptee.arrorLeft_mouseExited(e);
  }
  public void mouseReleased(MouseEvent e) {
    adaptee.arrorLeft_mouseReleased(e);
  }
}

class ScrollButtons_arrorRight_mouseMotionAdapter extends java.awt.event.MouseMotionAdapter {
  ScrollButtons adaptee;

  ScrollButtons_arrorRight_mouseMotionAdapter(ScrollButtons adaptee) {
    this.adaptee = adaptee;
  }
  public void mouseDragged(MouseEvent e) {
    adaptee.arrorRight_mouseDragged(e);
  }
  public void mouseMoved(MouseEvent e) {
    adaptee.arrorRight_mouseMoved(e);
  }
}

class ScrollButtons_arrorLeft_mouseMotionAdapter extends java.awt.event.MouseMotionAdapter {
  ScrollButtons adaptee;

  ScrollButtons_arrorLeft_mouseMotionAdapter(ScrollButtons adaptee) {
    this.adaptee = adaptee;
  }
  public void mouseDragged(MouseEvent e) {
    adaptee.arrorLeft_mouseDragged(e);
  }
  public void mouseMoved(MouseEvent e) {
    adaptee.arrorLeft_mouseMoved(e);
  }
}

class ScrollButtons_ArrowPnl_mouseMotionAdapter extends java.awt.event.MouseMotionAdapter {
  ScrollButtons adaptee;

  ScrollButtons_ArrowPnl_mouseMotionAdapter(ScrollButtons adaptee) {
    this.adaptee = adaptee;
  }
  public void mouseDragged(MouseEvent e) {
    adaptee.ArrowPnl_mouseDragged(e);
  }
}

class ScrollButtons_ArrowPnl_mouseAdapter extends java.awt.event.MouseAdapter {
  ScrollButtons adaptee;

  ScrollButtons_ArrowPnl_mouseAdapter(ScrollButtons adaptee) {
    this.adaptee = adaptee;
  }
  public void mouseEntered(MouseEvent e) {
    adaptee.ArrowPnl_mouseEntered(e);
  }
}

class ScrollButtons_this_mouseAdapter extends java.awt.event.MouseAdapter {
  ScrollButtons adaptee;

  ScrollButtons_this_mouseAdapter(ScrollButtons adaptee) {
    this.adaptee = adaptee;
  }
  public void mouseEntered(MouseEvent e) {
    adaptee.this_mouseEntered(e);
  }
}

class ScrollButtons_btnPnl_mouseAdapter extends java.awt.event.MouseAdapter {
  ScrollButtons adaptee;

  ScrollButtons_btnPnl_mouseAdapter(ScrollButtons adaptee) {
    this.adaptee = adaptee;
  }
  public void mouseEntered(MouseEvent e) {
    adaptee.btnPnl_mouseEntered(e);
  }
}

class ScrollButtons_this_mouseMotionAdapter extends java.awt.event.MouseMotionAdapter {
  ScrollButtons adaptee;

  ScrollButtons_this_mouseMotionAdapter(ScrollButtons adaptee) {
    this.adaptee = adaptee;
  }
  public void mouseMoved(MouseEvent e) {
    adaptee.this_mouseMoved(e);
  }
  public void mouseDragged(MouseEvent e) {
    adaptee.this_mouseDragged(e);
  }
}
