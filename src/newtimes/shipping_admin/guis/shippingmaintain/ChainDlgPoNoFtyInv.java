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

public class ChainDlgPoNoFtyInv extends JPanel
  implements exgui.chaindialog.Responsible
{
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel1 = new BlueBkgWhiteCharLabel();
  JTextField txtCustNo = new JTextField();
  exgui.chaindialog.Responsible nextResonsibale;
  JLabel jLabel1 = new JLabel();
  JLabel jLabel2 = new JLabel();
  JTextField txtFtyInv = new JTextField();
  public ChainDlgPoNoFtyInv() {
    try {
      jbInit();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }

  void jbInit() throws Exception {
    blueBkgWhiteCharLabel1.setText("Please Input Cust No. or Factory Inv#");
    blueBkgWhiteCharLabel1.setBounds(new Rectangle(-1, 10, 800, 30));
    this.setLayout(null);
    txtCustNo.setText("");
    txtCustNo.setBounds(new Rectangle(98, 85, 258, 27));
    jLabel1.setFont(new java.awt.Font("Dialog", 1, 11));
    jLabel1.setText("PO");
    jLabel1.setBounds(new Rectangle(62, 84, 35, 27));
    jLabel2.setBounds(new Rectangle(19, 124, 78, 27));
    jLabel2.setText("Factory Inv#");
    jLabel2.setFont(new java.awt.Font("Dialog", 1, 11));
    txtFtyInv.setBounds(new Rectangle(98, 125, 258, 27));
    txtFtyInv.setText("");
    this.add(blueBkgWhiteCharLabel1, null);
    this.add(txtCustNo, null);
    this.add(jLabel1, null);
    this.add(jLabel2, null);
    this.add(txtFtyInv, null);
  }
  public JComponent getGUI(){
    return this;
  }
  public void setDefalutNext(Responsible dfltRsp){
    nextResonsibale=dfltRsp;
  }
  public Responsible next()throws NextResponsibleIsNotReady{
    if(txtCustNo.getText().trim().length()>0 && txtCustNo.getText().trim().length()<2){
      exgui.verification.VerifyLib.showAlert("Cust No Should Longer Than 2 characters",
                                             "Cust No Should Longer Than 2 characters");
      throw new NextResponsibleIsNotReady();
    }

    if(txtFtyInv.getText().trim().length()>0 && txtFtyInv.getText().trim().length()<2){
      exgui.verification.VerifyLib.showAlert("Factory Inv No Should Longer Than 2 characters",
                                             "Factory Inv No Should Longer Than 2 characters");
      throw new NextResponsibleIsNotReady();
    }
    if(txtFtyInv.getText().trim().length()==0 && txtCustNo.getText().trim().length()==0){
      exgui.verification.VerifyLib.showAlert("Please Input PO# or Factory Inv#",
                                             "Please Input PO# or Factory Inv#");
      throw new NextResponsibleIsNotReady();

    }
    storedMap.put("IS_EDI_SHIPPING_MODE","YES");
    storedMap.put("CUST_PO",txtCustNo.getText());
    storedMap.put("FTY_INV_PO",txtFtyInv.getText());
    return nextResonsibale;
  }
  public boolean isAllowOkNow(){
    return false;
  }

}
