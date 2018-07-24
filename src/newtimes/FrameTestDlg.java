package newtimes;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class FrameTestDlg extends JFrame {
  JPanel contentPane;
  JButton jButton1 = new JButton();

  //Construct the frame
  public FrameTestDlg() {
    enableEvents(AWTEvent.WINDOW_EVENT_MASK);
    try {
      jbInit();
    }
    catch(Exception e) {
      e.printStackTrace();
    }
  }

  //Component initialization
  private void jbInit() throws Exception  {
    contentPane = (JPanel) this.getContentPane();
    jButton1.setBounds(new Rectangle(201, 222, 105, 25));
    jButton1.setText("jButton1");
    jButton1.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        jButton1_actionPerformed(e);
      }
    });
    contentPane.setLayout(null);
    this.setSize(new Dimension(400, 300));
    this.setTitle("Frame Title");
    contentPane.add(jButton1, null);
  }

  //Overridden so we can exit when window is closed
  protected void processWindowEvent(WindowEvent e) {
    super.processWindowEvent(e);
    if (e.getID() == WindowEvent.WINDOW_CLOSING) {
      System.exit(0);
    }
  }

  void jButton1_actionPerformed(ActionEvent e) {
     String headStr="<html><body>";
     String endStr="</body></html>";
     StringBuffer sb=new StringBuffer();
     exgui.DlgPhasesProcesses dlg=new
         exgui.DlgPhasesProcesses(this,"Processing Test",false);
     dlg.setSize(400,300);
     dlg.setMessage("Phases As Below:");
     dlg.show();
     for(int i=0;i<3;i++){
       if(sb.length()!=0)sb.append("<br>");
       sb.append("V.Phase:"+i+" OK.");
       dlg.setMessage(headStr+"Phases As Below:<br>"+sb.toString()+endStr);
       long lastTime=System.currentTimeMillis();
       while(System.currentTimeMillis()-lastTime < 5000)
       {
               try{
                 Thread.currentThread().sleep(10);
               }catch(Exception exp){

               }

       }

       //delay for 5 minute;
     }
     dlg.stopProcessing("Finish Processing,OK!!");
  }
}
