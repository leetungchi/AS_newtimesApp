package exgui;

import javax.swing.*;
import java.awt.*;


/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class TxtWithLabel extends DataBindGUIObject {
  BorderLayout borderLayout1 = new BorderLayout();
  JPanel jPanel1 = new JPanel();
  JLabel jLabel1 = new JLabel();
  JTextField jTextField1 = new JTextField();
  BorderLayout borderLayout2 = new BorderLayout();

  public TxtWithLabel() {
    try {
      jbInit();
    }
    catch(Exception e) {
      e.printStackTrace();
    }
  }
  public JComponent getGUIcomponent() {
    /**@todo Implement this exgui.DataBindGUIObject abstract method*/
    return this.jTextField1 ;
    //throw new java.lang.UnsupportedOperationException("Method getGUIcomponent() not yet implemented.");
  }
  public boolean isChanged() {
    /**@todo Implement this exgui.DataBindGUIObject abstract method*/
    return true;
    //throw new java.lang.UnsupportedOperationException("Method isChanged() not yet implemented.");

  }
  private void jbInit() throws Exception {
    this.setLayout(borderLayout1);
    jLabel1.setText("jLabel1");
    jTextField1.setPreferredSize(new Dimension(100, 30));
    jTextField1.setText("jTextField1");
    jPanel1.setLayout(borderLayout2);
    this.add(jPanel1, BorderLayout.CENTER);
    jPanel1.add(jLabel1,  BorderLayout.WEST);
    jPanel1.add(jTextField1, BorderLayout.CENTER);
  }

}