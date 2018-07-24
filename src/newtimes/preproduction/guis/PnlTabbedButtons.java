package newtimes.preproduction.guis;
import java.awt.*;
import javax.swing.*;
import processhandler.template.Properties;
import processhandler.*;
import java.awt.event.*;
import newtimes.preproduction.*;
/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class PnlTabbedButtons extends JPanel{
  BorderLayout borderLayout1 = new BorderLayout();
  JButton jButton1 = new JButton();
  BorderLayout borderLayout3 = new BorderLayout();
  GridLayout glayout=new GridLayout(1,7,0,0);
  FlowLayout flowLayout=new FlowLayout();
  JPanel jPanel1 = new JPanel();
  BorderLayout borderLayout2 = new BorderLayout();
  JPanel jPnlTop = new JPanel();
  ScrollButtons pnlBttns = new ScrollButtons();
  BorderLayout borderLayout6 = new BorderLayout();
  BorderLayout borderLayout5 = new BorderLayout();
  JPanel pnlToShow = new JPanel();
  public PnlTabbedButtons(){
    try {
      jbInit();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }
  protected void jbInit() throws Exception {
    this.setLayout(borderLayout1);
    //pnlToShow.setLayout(borderLayout2);
    //pnlBttns.setLayout(new BorderLayout());
    //pnlBttns.setLayout(flowLayout);
    //pnlBttns.setLayout(glayout);
    setBackground(new java.awt.Color(204, 204, 225));
    jPanel1.setLayout(borderLayout2);
    pnlBttns.setBackground(new Color(204, 204, 225));
    jPnlTop.setLayout(borderLayout6);
    pnlToShow.setLayout(borderLayout5);
    this.add(jPanel1, BorderLayout.CENTER);
    jPanel1.add(jPnlTop, BorderLayout.NORTH);
    jPnlTop.add(pnlBttns, BorderLayout.CENTER);
    jPanel1.add(pnlToShow,  BorderLayout.CENTER);
  }
  private int getMaxLen(String string){
    String strArr[]=util.MiscFunc.split(string,"<br>");
    int maxLen=0;
    for(int i=0;i<strArr.length;i++){
      if(maxLen<strArr[i].length()){
        maxLen=strArr[i].length();
      }
    }
    return maxLen;
  }
  public void setButtonActions(String labelArray[],
                               java.util.List  cmdTriggers,
                               java.util.List  colorList){
    JButton buttons[]=new JButton[labelArray.length];
    boolean withColor=false;
    if(colorList!=null)withColor=true;
    for(int i=0;i<labelArray.length;i++){
      JButton btn=new JButton(labelArray[i]);
      btn.addActionListener(new clickListener((CommandTrigger)cmdTriggers.get(i)));
      if(withColor)btn.setBackground((Color)colorList.get(i));
      buttons[i]=btn;
    }
    pnlBttns.addButtons(buttons);
    jPnlTop.removeAll();
    jPnlTop.add(pnlBttns);
  }

  public void setButtonActions(String labelArray[],java.util.List  cmdTriggers){
    setButtonActions(labelArray,cmdTriggers,null);
  }
  public void appendButtonActions(String labelArray[],
                                  java.util.List  cmdTriggers,
                                  java.util.List  colorList){
    JButton buttons[]=new JButton[labelArray.length];
    boolean withColor=false;
    if(colorList!=null)withColor=true;
    for(int i=0;i<labelArray.length;i++){
      JButton btn=new JButton(labelArray[i]);
      btn.addActionListener(new clickListener((CommandTrigger)cmdTriggers.get(i)));
      if(withColor)btn.setBackground((Color)colorList.get(i));
      buttons[i]=btn;
    }
    ScrollButtons tmpPnlTBttns=new ScrollButtons();
    tmpPnlTBttns.addButtons(buttons);
    jPnlTop.removeAll();
    jPnlTop.add(pnlBttns,BorderLayout.SOUTH);
    jPnlTop.add(tmpPnlTBttns, BorderLayout.NORTH);
  }
  public void appendButtonActions(String labelArray[],java.util.List  cmdTriggers){
    appendButtonActions(labelArray,cmdTriggers,null);
  }

  public JPanel panelToPlaceEditors(){
    return pnlToShow;
  }
  class clickListener
    implements java.awt.event.ActionListener {
    CommandTrigger myTgr=null;
    clickListener(CommandTrigger _tgr) {
       myTgr=_tgr;
    }

    public void actionPerformed(ActionEvent e) {
      //adaptee.jButton1_actionPerformed(e);
      try{
        Properties.ctnCtl.doCommandExecute(myTgr);
      }catch(Exception eii){
         eii.printStackTrace();
      }
    }
  }

}


