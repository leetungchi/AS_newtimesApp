package newtimes;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author unascribed
 * @version 1.0
 */

public class Frame1 extends JFrame {
  public JPanel contentPane;
  newtimes.Login login = new newtimes.Login(this);
  static public String FRAME_TITLE_NAME = " Newtimes System Version "+ NewtimesApp.VERSION+NewtimesApp.BUILD_VER;
//static public String FRAME_TITLE_NAME=NewtimesApp.BUILD_VER;
  //Construct the frame
  public Frame1() {
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
    this.setSize(new Dimension(800, 599));
    this.setTitle(FRAME_TITLE_NAME);
    this.setIconImage(exgui.UIHelper.getIcon("logo.jpg").getImage());
    contentPane = (JPanel) this.getContentPane();
    contentPane.setLayout(null);
    contentPane.setBackground(new Color(204, 204, 225));
    login.setBounds(0,0, 800, 600);
    login.repaint();
    contentPane.add(login, null);
  }

  //Overridden so we can exit when window is closed
  protected void processWindowEvent(WindowEvent e) {
    super.processWindowEvent(e);
    if (e.getID() == WindowEvent.WINDOW_CLOSING) {
      if(newtimes.preproduction.process.AttributeFactory.isAllAccsAttribReady()){
        if(newtimes.production.report.ReportCmdSet.myReportEngin!=null){
          try{
            if(processhandler.template.Properties.getCenteralControler()!=null){
              processhandler.DataProcesser dp=
                  processhandler.template.Properties.getCenteralControler().getDataProcesser();
              if(dp!=null)dp.exitCurrentGui();
            }
            newtimes.production.report.ReportCmdSet.myReportEngin.ejb.remove();
            System.out.println("ejb remove called");
          }catch(Exception exp){
            exp.printStackTrace();
          }
        }
      }
      System.exit(0);
    }
  }

  /**
   * Defined show panel.
   */
  public void showPanel(JPanel panel){
    //System.out.println("show " + panel);
    contentPane.removeAll();
    contentPane.add(panel, null);
    panel.setBounds(0, 0, 800, 600);
    panel.repaint();
    panel.validate();
  }
}
