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

public class DlgBchAddDestination extends DlgEditDestination {
  JTextField txtDest[];
  exgui.DataBindText txtchk;
  public DlgBchAddDestination(Frame frame, String title, boolean modal) {
    super(frame, title, modal);
    try {
      //jbInit();
      pack();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }

  public DlgBchAddDestination() {
    this(null, "", false);
  }

  protected void jbInit() throws Exception {
    //if(panel1==null)panel1=new JPanel();
    super.jbInit();
    panel1.removeAll();
    panel1.setLayout(null);
    blueBkgWhiteCharLabel1.setText("Add Destinations");
    blueBkgWhiteCharLabel1.setBounds(new Rectangle(-1, 10, 440, 25));
    Object txtChkObj=exgui.verification.CellFormat.getOrdinaryField(30);
    txtDest = new JTextField[3];
    txtDest[0]=new JTextField();
    txtDest[1]=new JTextField();
    txtDest[2]=new JTextField();

    txtDest[0].setText("");
    txtDest[0].setText("");
    txtDest[0].setBounds(new Rectangle(48, 50, 354, 28));
    txtDest[1].setBounds(new Rectangle(48, 100, 354, 28));
    txtDest[1].setText("");
    txtDest[2].setText("");
    txtDest[2].setBounds(new Rectangle(48, 150, 354, 28));
    txtDest[2].setText("");
    txtDest[2].setText("");
    //to do for length control
    txtchk=  new exgui.DataBindText(txtDest[0],null,"",30);
    txtchk=  new exgui.DataBindText(txtDest[1],null,"",30);
    txtchk=  new exgui.DataBindText(txtDest[2],null,"",30);

    btnOK.setBounds(new Rectangle(118, 232, 128, 26));
    btnOK.setFont(new java.awt.Font("Dialog", 1, 11));
    btnOK.setText("CONFIRM EDIT");
    btnOK.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnOK_actionPerformed(e);
      }
    });
    btnCancel.setBounds(new Rectangle(280, 232, 134, 25));
    btnCancel.setFont(new java.awt.Font("Dialog", 1, 11));
    btnCancel.setText("CANCEL");
    btnCancel.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnCancel_actionPerformed(e);
      }
    });
    this.getContentPane().add(panel1);

    panel1.add(blueBkgWhiteCharLabel1, null);
    panel1.add(txtDest[0], null);
    panel1.add(txtDest[1], null);
    panel1.add(txtDest[2], null);
    panel1.add(btnOK, null);
    panel1.add(btnCancel, null);
  }
  public String[] getDestStrings(){
    String str[]=new String[3];
    str[0]=txtDest[0].getText().trim().toUpperCase();
    str[1]=txtDest[1].getText().trim().toUpperCase();
    str[2]=txtDest[2].getText().trim().toUpperCase();
    return str;
  }
  protected void btnOK_actionPerformed(ActionEvent e) {
    this.myOperationStatus=STATUS_CLOSE_NORMALLY;
    this.dispose();
  }
}
