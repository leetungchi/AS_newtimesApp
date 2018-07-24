package newtimes.basic.destination;
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

public class DlgEditDestination extends JDialog {
  protected JPanel panel1 = new JPanel();
  protected JButton btnOK = new JButton();
  protected JButton btnCancel = new JButton();
  protected BlueBkgWhiteCharLabel blueBkgWhiteCharLabel1 = new BlueBkgWhiteCharLabel();
  protected JTextField txtNewDestString = new JTextField();
  protected JLabel jLabel1 = new JLabel();
  protected JLabel lblOrgDestString = new JLabel();
  protected JLabel jLabel2 = new JLabel();
  protected int myOperationStatus=0;
  public static int STATUS_OPERATING=0;
  public static int STATUS_CLOSE_NORMALLY=1;
  public static int STATUS_CLOSE_CANCEL=2;
  exgui.DataBindText txtchk;
  public DlgEditDestination(Frame frame, String title, boolean modal) {
    super(frame, title, modal);
    try {
      jbInit();
      pack();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }
  public int getDialogStatus(){return myOperationStatus;}
  public void show(){
    this.myOperationStatus=STATUS_OPERATING;
    super.show();
  }

  public DlgEditDestination() {
    this(null, "", false);
  }

  protected void jbInit() throws Exception {
    panel1.setLayout(null);
    btnOK.setBounds(new Rectangle(133, 252, 128, 26));
    btnOK.setFont(new java.awt.Font("Dialog", 1, 11));
    btnOK.setText("CONFIRM EDIT");
    btnOK.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnOK_actionPerformed(e);
      }
    });
    btnCancel.setBounds(new Rectangle(295, 252, 134, 25));
    btnCancel.setFont(new java.awt.Font("Dialog", 1, 11));
    btnCancel.setText("CANCEL");
    btnCancel.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnCancel_actionPerformed(e);
      }
    });
    blueBkgWhiteCharLabel1.setText("Modify Destination Name");
    blueBkgWhiteCharLabel1.setBounds(new Rectangle(0, 21, 436, 30));
    txtNewDestString.setText("");
    txtNewDestString.setBounds(new Rectangle(135, 145, 232, 31));
    jLabel1.setFont(new java.awt.Font("Dialog", 1, 11));
    jLabel1.setText("Original :");
    jLabel1.setBounds(new Rectangle(49, 90, 83, 28));
    lblOrgDestString.setFont(new java.awt.Font("Dialog", 1, 11));
    lblOrgDestString.setText("");
    lblOrgDestString.setBounds(new Rectangle(139, 92, 243, 26));
    jLabel2.setFont(new java.awt.Font("Dialog", 1, 11));
    jLabel2.setText("New:");
    jLabel2.setBounds(new Rectangle(49, 146, 79, 25));
    getContentPane().add(panel1);
    panel1.add(blueBkgWhiteCharLabel1, null);
    panel1.add(btnOK, null);
    panel1.add(btnCancel, null);
    panel1.add(txtNewDestString, null);
    panel1.add(jLabel1, null);
    panel1.add(lblOrgDestString, null);
    panel1.add(jLabel2, null);
    txtchk=  new exgui.DataBindText(txtNewDestString,null,"",30);
  }

 protected void btnOK_actionPerformed(ActionEvent e) {
     if(txtNewDestString.getText().trim().length()==0){
       exgui.verification.VerifyLib.showAlert("Destination Can Not Be Blank",
                                              "Destination Can Not Be Blank");
       return;
     }
     myOperationStatus=STATUS_CLOSE_NORMALLY;
     this.dispose();
  }

 protected  void btnCancel_actionPerformed(ActionEvent e) {
     myOperationStatus=STATUS_CLOSE_CANCEL;
     this.dispose();
  }

}
