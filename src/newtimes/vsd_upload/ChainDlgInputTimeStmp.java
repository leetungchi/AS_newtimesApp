package newtimes.vsd_upload;

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

public class ChainDlgInputTimeStmp extends JPanel
 implements exgui.chaindialog.Responsible{
  exgui.chaindialog.Responsible nextResonsibale;
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel1 = new BlueBkgWhiteCharLabel();
  JLabel jLabel1 = new JLabel();
  JTextField txtProceNo = new JTextField();
  public ChainDlgInputTimeStmp() {
    try {
      jbInit();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }

  void jbInit() throws Exception {
    blueBkgWhiteCharLabel1.setText("Please Input VSD upload PROC#:");
    blueBkgWhiteCharLabel1.setBounds(new Rectangle(-6, 8, 718, 31));
    this.setLayout(null);
    jLabel1.setFont(new java.awt.Font("Dialog", 1, 11));
    jLabel1.setText("PROC#:");
    jLabel1.setBounds(new Rectangle(279, 63, 56, 27));
    txtProceNo.setText("");
    txtProceNo.setBounds(new Rectangle(334, 67, 153, 25));
    this.add(blueBkgWhiteCharLabel1, null);
    this.add(jLabel1, null);
    this.add(txtProceNo, null);
  }
  public JComponent getGUI(){
    return this;
  }
  public void setDefalutNext(Responsible dfltRsp){
    nextResonsibale=dfltRsp;
  }
  public Responsible next()throws NextResponsibleIsNotReady{

    if(txtProceNo.getText().trim().length() != "20009601 2315".length()){
      exgui.verification.VerifyLib.showAlert("PROC# Format Error",
                                             "PROC# Format Error");
      throw new NextResponsibleIsNotReady();
    }
    storedMap.put("PROCNO",txtProceNo.getText().trim());
    newtimes.vsd_upload.ChainDlgSlkStySeq2Upload step2=new newtimes.vsd_upload.ChainDlgSlkStySeq2Upload();
    return step2;
  }
  public boolean isAllowOkNow(){
    return false;
  }

}
