package newtimes.basic.totoal_endpage_remark;

import java.awt.*;
import javax.swing.*;
import exgui.*;
import java.awt.event.*;
import database.datatype.Record;
public class DlgEditRemark extends JDialog {
  BorderLayout borderLayout1 = new BorderLayout();
  JTextArea txtTE_rmk = new JTextArea();
  JScrollPane jScrollPane1 = new JScrollPane();
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel1 = new BlueBkgWhiteCharLabel();
  JPanel panel1 = new JPanel();
  JButton btnOK = new JButton();
  JButton btnCancel = new JButton();
  DB_TotalEndPage db;
  PnlListTotalEndPageRemarks pnl;
  Record rec;
  public DlgEditRemark(Frame frame, String title, boolean modal,DB_TotalEndPage _db,
                       PnlListTotalEndPageRemarks _pnl,
                       Record _rec) {
    super(frame, title, modal);
    try {
      db=_db;pnl=_pnl;rec=_rec;
      jbInit();
      pack();

    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }

  public DlgEditRemark() {
    this(null, "", false,null,null,null);
  }

  private void jbInit() throws Exception {
    panel1.setLayout(null);
    blueBkgWhiteCharLabel1.setBounds(new Rectangle(-2, 5, 404, 29));
    blueBkgWhiteCharLabel1.setText("REMARK OF TOTAL END PAGE");
    jScrollPane1.setBounds(new Rectangle(9, 48, 382, 165));
    txtTE_rmk.setText("");
    this.getContentPane().setLayout(borderLayout1);
    btnOK.setBounds(new Rectangle(15, 232, 91, 27));
    btnOK.setText("OK");
    btnOK.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnOK_actionPerformed(e);
      }
    });
    btnCancel.setBounds(new Rectangle(297, 231, 98, 28));
    btnCancel.setText("CANCEL");
    btnCancel.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnCancel_actionPerformed(e);
      }
    });
    this.getContentPane().add(panel1, BorderLayout.CENTER);
    panel1.add(blueBkgWhiteCharLabel1, null);
    panel1.add(jScrollPane1, null);
    panel1.add(btnOK, null);
    jScrollPane1.getViewport().add(txtTE_rmk, null);
    panel1.add(btnCancel, null);
    Object objRemark=rec.get("TER_remark");
    txtTE_rmk.setText((objRemark==null)?"":objRemark.toString());
  }

  void btnOK_actionPerformed(ActionEvent e) {
    try{
      if (txtTE_rmk.getText().trim().length() == 0) {
        exgui.verification.VerifyLib.showAlert("Please Input Remark Context",
                                               "Please Input Remark Context");
        return;
      }
      if (txtTE_rmk.getText().trim().getBytes().length>500) {
        exgui.verification.VerifyLib.showAlert("Can Not Over Than 500 Characters",
                                               "Context Too Long!!");
        return;
      }

      rec.set("TER_remark", txtTE_rmk.getText());
      util.MiscFunc.showProcessingMessage();
      if (rec.get(0) == null) {
        db.addRecord(rec);
      } else {
        java.util.Vector vect = new java.util.Vector();
        vect.add(rec);
        db.updateRecords(vect);
      }
      pnl.reload();
      util.MiscFunc.hideProcessingMessage();
      this.dispose();
    }catch(Exception exp){
      exp.printStackTrace();
      exgui.verification.VerifyLib.showAlert("Error In DB Processing\nPlease Contact System Manager",
                                             "Error In DB Processing");
    }
  }

  void btnCancel_actionPerformed(ActionEvent e) {
    this.dispose();
  }
}
