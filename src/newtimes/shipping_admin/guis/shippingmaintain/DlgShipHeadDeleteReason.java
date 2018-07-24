package newtimes.shipping_admin.guis.shippingmaintain;

import java.awt.*;
import javax.swing.*;
import exgui.*;
import java.awt.event.*;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class DlgShipHeadDeleteReason extends JDialog {
  JPanel panel1 = new JPanel();
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel1 = new BlueBkgWhiteCharLabel();
  JScrollPane jScrollPane1 = new JScrollPane();
  JTextArea txtReason = new JTextArea();
  JButton btnCancel = new JButton();
  JButton btnOK = new JButton();
  public static int STATUS_OPERATING=0;
  public static int STATUS_CLOSE_NORMALLY=1;
  public static int STATUS_CLOSE_CANCEL=2;
  int  myOperationStatus=0;
  String orgTextContext="";

  public DlgShipHeadDeleteReason(Frame frame, String title, boolean modal,String str2show) {
    super(frame, title, modal);
    try {
      if(str2show!=null){
        orgTextContext = str2show;
      }
      setDefaultCloseOperation( JDialog.DO_NOTHING_ON_CLOSE );
      jbInit();
      pack();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }

  public DlgShipHeadDeleteReason() {
    this(null, "", false,"");
  }
  public void show(){
    this.myOperationStatus=STATUS_OPERATING;
    super.show();
  }
  public int getDialogStatus(){return myOperationStatus;}
  protected void jbInit() throws Exception {
    panel1.setLayout(null);
    this.getContentPane().setLayout(null);
    panel1.setBounds(new Rectangle(0, 0, 489, 250));
    blueBkgWhiteCharLabel1.setText("Please Input Reason Of Deleting This SRN");
    blueBkgWhiteCharLabel1.setBounds(new Rectangle(0, 32, 495, 25));
    jScrollPane1.setBounds(new Rectangle(8, 70, 464, 92));
    txtReason.setText(orgTextContext);
    btnCancel.setBounds(new Rectangle(38, 192, 102, 32));
    btnCancel.setFont(new java.awt.Font("Dialog", 1, 11));
    btnCancel.setText("Cancel");
    btnCancel.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnCancel_actionPerformed(e);
      }
    });
    btnOK.setText("OK");
    btnOK.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnOK_actionPerformed(e);
      }
    });
    btnOK.setFont(new java.awt.Font("Dialog", 1, 11));
    btnOK.setSelected(true);
    btnOK.setBounds(new Rectangle(343, 192, 102, 32));
    getContentPane().add(panel1, null);
    panel1.add(blueBkgWhiteCharLabel1, null);
    panel1.add(jScrollPane1, null);
    jScrollPane1.getViewport().add(txtReason, null);
    panel1.add(btnCancel, null);
    panel1.add(btnOK, null);
    exgui.DataBindText  dbTxtBindText=
        new exgui.DataBindText(txtReason, null, orgTextContext, 200);

  }

  void btnCancel_actionPerformed(ActionEvent e) {
    if(!orgTextContext.equalsIgnoreCase(txtReason.getText().trim())){
      boolean result=exgui.verification.VerifyLib.showConfirm("Reason Changed,Do you really Want To Exit?",
                                               "Reason Changed,Do you really Want To Exit?");
      if(!result)return;
    }
    this.myOperationStatus=STATUS_CLOSE_CANCEL;
    this.dispose();
  }

  void btnOK_actionPerformed(ActionEvent e) {
    if(txtReason.getText().trim().length()==0){
      exgui.verification.VerifyLib.showAlert("To Delete Ship Head,You Have To Input Reason",
                                             "Must Input Delete Reason");
      return;
    }
    this.myOperationStatus=STATUS_CLOSE_NORMALLY;
    this.dispose();
  }
}
