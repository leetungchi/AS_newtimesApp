package newtimes.preproduction.buyermakerselect;

import java.awt.*;
import javax.swing.*;
import exgui.*;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class PnlKeyWordSlkMtrDtl extends JPanel implements exgui.chaindialog.Responsible {
  exgui.chaindialog.Responsible defaultNext;
  JLabel blueBkgWhiteCharLabel1 = new JLabel();
  JTextField jTextField1 = new JTextField();
  public PnlKeyWordSlkMtrDtl() {
    try {
      jbInit();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }
  void jbInit() throws Exception {
    blueBkgWhiteCharLabel1.setText("Search Material No Begin With:");
    blueBkgWhiteCharLabel1.setBounds(new Rectangle(17, 102, 176, 24));
    this.setDebugGraphicsOptions(0);
    this.setLayout(null);
    jTextField1.setFont(new java.awt.Font("Dialog", 0, 11));
    jTextField1.setText("");
    jTextField1.setBounds(new Rectangle(193, 103, 149, 23));
    this.add(jTextField1, null);
    this.add(blueBkgWhiteCharLabel1, null);
    database.datatype.Record rec=
        (database.datatype.Record)newtimes.preproduction.guis.tempProperties.tmpCenters.get(0);
    jTextField1.setText("M"+rec.get("cen_prefix"));

  }
  public JComponent getGUI(){
    return this;
  }
  public boolean isAllowOkNow(){return false;}
  public exgui.chaindialog.Responsible  next() throws exgui.chaindialog.NextResponsibleIsNotReady{
    //storedMap.put(Kies.KEY_INIT_CHAR_OF_BUYERMAKER,charAt);
    if(jTextField1.getText().trim().length()==0){
      exgui.verification.VerifyLib.showAlert(
          "KeyWord can not be blank","KeyWord can not be blank"
      );
      jTextField1.grabFocus();
      throw new exgui.chaindialog.NextResponsibleIsNotReady();
    }
    if(jTextField1.getText().trim().length()<2){
      exgui.verification.VerifyLib.showAlert(
          "At least 2 characters","At least 2 characters"
      );
      jTextField1.grabFocus();
      throw new exgui.chaindialog.NextResponsibleIsNotReady();
    }
    storedMap.put(Kies.KEY_INIT_CHAR_OF_BUYERMAKER,util.MiscFunc.Replace(jTextField1.getText().trim(),"'","''"));
    return defaultNext;
  }
  public void setDefalutNext(exgui.chaindialog.Responsible dftNext){
    defaultNext=dftNext;
  }
}
