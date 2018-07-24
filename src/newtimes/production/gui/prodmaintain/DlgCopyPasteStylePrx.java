package newtimes.production.gui.prodmaintain;

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

public class DlgCopyPasteStylePrx extends JDialog {
  JPanel panel1 = new JPanel();
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel1 = new BlueBkgWhiteCharLabel();
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel2 = new BlueBkgWhiteCharLabel();
  JButton cbxExecute = new JButton();
  JButton cbxExit = new JButton();
  String items[]=new String[]{"Buyer Doc Price","Buyer Act Price","Maker Doc Price","Maker Act Price"};
  JComboBox cbxColumnFrom = new JComboBox(items);
  JComboBox cbxColumnTo = new JComboBox(items);
  javax.swing.JTable tblStyleList=null;
  int buyer_doc_prx_column_base;
  public DlgCopyPasteStylePrx(Frame frame, String title, boolean modal,javax.swing.JTable tbl,int _buyer_doc_prx_baes) {
    super(frame, title, modal);
    tblStyleList=tbl;
    buyer_doc_prx_column_base=_buyer_doc_prx_baes;
    try {
      jbInit();
      pack();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }

  public DlgCopyPasteStylePrx() {
    this(null, "", false,null,-1);
  }

  private void jbInit() throws Exception {
    panel1.setLayout(null);
    blueBkgWhiteCharLabel1.setText("COPY FROM:");
    blueBkgWhiteCharLabel1.setBounds(new Rectangle(11, 31, 124, 21));
    cbxColumnFrom.setBounds(new Rectangle(137, 31, 123, 21));
    cbxColumnTo.setBounds(new Rectangle(415, 31, 123, 21));
    blueBkgWhiteCharLabel2.setBounds(new Rectangle(261, 31, 152, 21));
    blueBkgWhiteCharLabel2.setText("PASTE TO:");
    cbxExecute.setBounds(new Rectangle(553, 31, 94, 26));
    cbxExecute.setFont(new java.awt.Font("Dialog", 1, 11));
    cbxExecute.setText("GO!!");
    cbxExecute.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        cbxExecute_actionPerformed(e);
      }
    });
    cbxExit.setBounds(new Rectangle(242, 65, 111, 27));
    cbxExit.setFont(new java.awt.Font("Dialog", 1, 11));
    cbxExit.setText("EXIT");
    cbxExit.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        cbxExit_actionPerformed(e);
      }
    });
    getContentPane().add(panel1);
    panel1.add(blueBkgWhiteCharLabel1, null);
    panel1.add(cbxColumnFrom, null);
    panel1.add(blueBkgWhiteCharLabel2, null);
    panel1.add(cbxColumnTo, null);
    panel1.add(cbxExecute, null);
    panel1.add(cbxExit, null);
  }

  void cbxExit_actionPerformed(ActionEvent e) {
     this.dispose();
  }

  void cbxExecute_actionPerformed(ActionEvent e) {
     if(cbxColumnFrom.getSelectedIndex()==cbxColumnTo.getSelectedIndex()){
       exgui.verification.VerifyLib.showAlert("Source and destination Column should be different",
                                              "Source and destination Column should be different");
       return;
     }
     for(int i=0;i<tblStyleList.getRowCount();i++){
       if(tblStyleList.isCellEditable(i,buyer_doc_prx_column_base) ){
         tblStyleList.setValueAt(
          tblStyleList.getValueAt(i,buyer_doc_prx_column_base+cbxColumnFrom.getSelectedIndex()),i,
         buyer_doc_prx_column_base+cbxColumnTo.getSelectedIndex());
       }
     }
  }
}
