package newtimes.fty_exam;

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

public class DlgSelectBuyerMaker extends JDialog {
  JPanel panel1 = new JPanel();
  BorderLayout borderLayout1 = new BorderLayout();
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel1 = new BlueBkgWhiteCharLabel();
  JComboBox cbxBuyer = new JComboBox();
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel2 = new BlueBkgWhiteCharLabel();
  JTextField txtMakerName = new JTextField();
  JButton btnNext = new JButton();
  JButton btnCancel = new JButton();
   exgui.DataBindJCombobox dbcbx;
  public DlgSelectBuyerMaker(Frame frame, String title, boolean modal) {
    super(frame, title, modal);
    try {
      jbInit();
      pack();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }

  public DlgSelectBuyerMaker() {
    this(null, "", false);
  }

  private void jbInit() throws Exception {
    panel1.setLayout(null);
    this.getContentPane().setLayout(borderLayout1);
    blueBkgWhiteCharLabel1.setText("BUYER");
    blueBkgWhiteCharLabel1.setBounds(new Rectangle(32, 54, 109, 27));
    cbxBuyer.setBounds(new Rectangle(140, 54, 172, 24));
    blueBkgWhiteCharLabel2.setBounds(new Rectangle(32, 91, 109, 27));
    blueBkgWhiteCharLabel2.setText("MAKER");
    txtMakerName.setText("");
    txtMakerName.setScrollOffset(0);
    txtMakerName.setBounds(new Rectangle(141, 91, 165, 26));
    btnNext.setBounds(new Rectangle(94, 143, 76, 25));
    btnNext.setFont(new java.awt.Font("Dialog", 1, 12));
    btnNext.setText("NEXT");
    btnNext.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnNext_actionPerformed(e);
      }
    });
    btnCancel.setText("CANCEL");
    btnCancel.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnCancel_actionPerformed(e);
      }
    });
    btnCancel.setBounds(new Rectangle(207, 143, 101, 25));
    btnCancel.setFont(new java.awt.Font("Dialog", 1, 12));
    btnCancel.setForeground(Color.red);
    getContentPane().add(panel1, BorderLayout.CENTER);
    panel1.add(blueBkgWhiteCharLabel1, null);
    panel1.add(cbxBuyer, null);
    panel1.add(blueBkgWhiteCharLabel2, null);
    panel1.add(txtMakerName, null);
    panel1.add(btnCancel, null);
    panel1.add(btnNext, null);
    dbcbx=new exgui.DataBindJCombobox(
                                 cbxBuyer,
                                Constants.vctBuyer,"BUYER_NAME",
                                "seq",null
                                );

  }

  void btnCancel_actionPerformed(ActionEvent e) {
    this.dispose();
  }

  void btnNext_actionPerformed(ActionEvent e) {
     if(txtMakerName.getText().trim().length()==0){
       exgui.verification.VerifyLib.showAlert("Please Input Maker Name","Please Input Maker Name");
       return;
     }
     TgrEditFtyExamHistory tgr=new TgrEditFtyExamHistory(Integer.parseInt((String)dbcbx.getSelectedValue()),
                                                         cbxBuyer.getSelectedItem().toString(),
                                                         txtMakerName.getText());
     try{
         processhandler.template.Properties.getCenteralControler().doCommandExecute(tgr);
         this.dispose();
    }catch(Exception exp){
    exp.printStackTrace();
    }

  }
}
