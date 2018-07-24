package exgui;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class DlgPhasesProcesses extends JDialog implements Runnable{
  JPanel panel1 = new JPanel();
  BorderLayout borderLayout1 = new BorderLayout();
  JPanel jPanel1 = new JPanel();
  JPanel jPanel2 = new JPanel();
  JLabel lbl2PutImg = new JLabel();
  JLabel lblMsgLable = new JLabel();
  BorderLayout borderLayout2 = new BorderLayout();
  JLabel jLabel1 = new JLabel();
  JLabel jLabel2 = new JLabel();
  boolean activating=false;
  boolean toRunnable=true;
  JButton btnOK = new JButton();
  JPanel jPanel3 = new JPanel();
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel1 = new BlueBkgWhiteCharLabel();
  BorderLayout borderLayout3 = new BorderLayout();
  JLabel jLabel3 = new JLabel();
  public DlgPhasesProcesses(Frame frame, String title, boolean modal) {
    super(frame, title, modal);
    try {
      jbInit();
      pack();
      callThread();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }
  protected void callThread(){
    Thread myThread=new Thread(this);
    myThread.setPriority(Thread.MAX_PRIORITY);
    myThread.start();
  }
  public DlgPhasesProcesses() {
    this(null, "", false);
  }
  public void run(){
    while(toRunnable){
      if(activating){
       validate();
       this.paintComponents(this.getGraphics());
      }
      try{
        Thread.currentThread().sleep(10);
      }catch(Exception e){

      }
    }
  }
  public void dispose(){
    activating=false;
    toRunnable=false;
    super.dispose();
  }
  public void show(){
    activating=true;
    toRunnable=true;
    super.show();
  }
  public void setVisible(boolean isvisiable){
    super.setVisible(isvisiable);
    activating=isvisiable;
    //toRunnable=isvisiable;
  }
  public void setMessage(String msg){
    lblMsgLable.setText(msg);
  }
  public void setMessage(String msg,boolean atvAnimation){
    lblMsgLable.setText(msg);
    activating=atvAnimation;
  }
  public void stopProcessing(String msg){
    lblMsgLable.setText(msg);
    activating=false;
    toRunnable=false;
    btnOK.setEnabled(true);
    lbl2PutImg.setVisible(false);
  }

  private void jbInit() throws Exception {
    panel1.setLayout(borderLayout1);
    lbl2PutImg.setDoubleBuffered(true);
    lbl2PutImg.setText("");
    jPanel2.setLayout(borderLayout2);
    jLabel1.setText("                ");
    lblMsgLable.setDoubleBuffered(true);
    lblMsgLable.setFont(new Font("Dialog",1,12));
    lblMsgLable.setHorizontalAlignment(SwingConstants.LEADING);
    lblMsgLable.setHorizontalTextPosition(SwingConstants.TRAILING);
    lblMsgLable.setText("Processing");
    lblMsgLable.setVerticalAlignment(javax.swing.SwingConstants.TOP);
    lblMsgLable.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
    jLabel2.setText("                       ");
    btnOK.setDoubleBuffered(true);
    btnOK.setText("OK");
    btnOK.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnOK_actionPerformed(e);
      }
    });
    blueBkgWhiteCharLabel1.setDoubleBuffered(true);
    blueBkgWhiteCharLabel1.setHorizontalAlignment(SwingConstants.LEADING);
    blueBkgWhiteCharLabel1.setText("Process To DataBase");
    jPanel3.setLayout(borderLayout3);
    getContentPane().add(panel1,  BorderLayout.CENTER);
    panel1.add(jPanel1,  BorderLayout.SOUTH);
    jPanel1.add(lbl2PutImg, null);
    jPanel1.add(btnOK, null);
    panel1.add(jPanel2, BorderLayout.CENTER);
    jPanel2.add(lblMsgLable, BorderLayout.CENTER);
    jPanel2.add(jLabel1, BorderLayout.EAST);
    jPanel2.add(jLabel2,  BorderLayout.WEST);
    jPanel2.add(jLabel3, BorderLayout.NORTH);
    jPanel3.add(blueBkgWhiteCharLabel1, BorderLayout.CENTER);
    panel1.add(jPanel3, BorderLayout.NORTH);
    lbl2PutImg.setIcon(exgui.UIHelper.getIcon("processing.gif"));
    btnOK.setEnabled(false);
  }

  void btnOK_actionPerformed(ActionEvent e) {
     this.dispose();
  }
}
