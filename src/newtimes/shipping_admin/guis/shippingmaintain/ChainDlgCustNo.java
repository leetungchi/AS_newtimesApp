package newtimes.shipping_admin.guis.shippingmaintain;

import java.awt.*;
import exgui.*;
import javax.swing.*;
import exgui.chaindialog.*;
/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class ChainDlgCustNo extends JPanel
  implements exgui.chaindialog.Responsible
{
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel1 = new BlueBkgWhiteCharLabel();
  JTextField txtCustNo = new JTextField();
  exgui.chaindialog.Responsible nextResonsibale;
  public ChainDlgCustNo() {
    try {
      jbInit();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }

  void jbInit() throws Exception {
    blueBkgWhiteCharLabel1.setText("Please Input Cust No.");
    blueBkgWhiteCharLabel1.setBounds(new Rectangle(-1, 10, 501, 30));
    this.setLayout(null);
    txtCustNo.setText("");
    txtCustNo.setBounds(new Rectangle(56, 85, 258, 27));
    this.add(blueBkgWhiteCharLabel1, null);
    this.add(txtCustNo, null);
  }
  public JComponent getGUI(){
    return this;
  }
  public void setDefalutNext(Responsible dfltRsp){
    nextResonsibale=dfltRsp;
  }
  public Responsible next()throws NextResponsibleIsNotReady{
    if(txtCustNo.getText().trim().length()<2){
      exgui.verification.VerifyLib.showAlert("Cust No Should Longer Than 2 characters",
                                             "Cust No Should Longer Than 2 characters");
      throw new NextResponsibleIsNotReady();
    }
    storedMap.put("CUST_PO",txtCustNo.getText());
    return nextResonsibale;
  }
  public boolean isAllowOkNow(){
    return false;
  }

}
