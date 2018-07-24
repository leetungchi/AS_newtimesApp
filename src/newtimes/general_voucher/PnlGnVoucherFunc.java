package newtimes.general_voucher ;

import java.awt.*;
import exgui.*;
import javax.swing.*;
import newtimes.preproduction.buyermakerselect.*;
import java.awt.event.*;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class PnlGnVoucherFunc extends JPanel {
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel1 = new BlueBkgWhiteCharLabel();
  JButton btnExit = new JButton();
  JButton btnTestFunction = new JButton();

  public PnlGnVoucherFunc() {
    try {
      jbInit();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
    /*
    try{
     EventQueue eq = Toolkit.getDefaultToolkit().getSystemEventQueue();
     eq.invokeAndWait(new Runnable()
     {
      public void run(){
         Thread.currentThread().setContextClassLoader(weblogic.jndi.WLInitialContextFactory.class.getClassLoader());

      }
    });
    }catch(Exception e){
      e.printStackTrace();
    }
   */


  }

  void jbInit() throws Exception {

    blueBkgWhiteCharLabel1.setText("Local Voucher Function");
    blueBkgWhiteCharLabel1.setBounds(new Rectangle(0, 27, 800, 33));
    this.setLayout(null);
    btnExit.setBackground(Color.white);
    btnExit.setBounds(new Rectangle(346, 538, 108, 30));
    btnExit.setFont(new java.awt.Font("Dialog", 1, 11));
    btnExit.setText("EXIT");
    btnExit.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnExit_actionPerformed(e);
      }
    });
    btnTestFunction.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnTestFunction_actionPerformed(e);
      }
    });
    btnTestFunction.setText("TEST FUNCTION");
    btnTestFunction.setFont(new java.awt.Font("Dialog", 1, 11));
    btnTestFunction.setBounds(new Rectangle(233, 103, 334, 30));
    btnTestFunction.setBackground(Color.white);
    this.add(blueBkgWhiteCharLabel1, null);
    this.add(btnExit, null);
    this.add(btnTestFunction, null);
  }

  void btnExit_actionPerformed(ActionEvent e) {
    newtimes.Frame1 frame=(newtimes.Frame1)util.PublicVariable.APP_FRAME;
    frame.showPanel(new newtimes.MainFunction(frame));

  }
  void btnTestFunction_actionPerformed(ActionEvent e) {
    try{
      processhandler.CommandTrigger actionTriger = new TgrToTestFunc();
      //thank God,We have the abstract Class--CommandTriger.
      processhandler.template.Properties.getCenteralControler().
          doCommandExecute(
          actionTriger
          );
    }catch(Exception exp){
      exp.printStackTrace();
    }

  }
}
