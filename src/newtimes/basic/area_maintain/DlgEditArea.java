package newtimes.basic.area_maintain;

import java.awt.*;
import javax.swing.*;
import database.datatype.Record;
import java.awt.event.*;
public class DlgEditArea extends JDialog {
  JPanel panel1 = new JPanel();
  JLabel jLabel2 = new JLabel();
  JTextField txtAreaChn = new JTextField();
  JLabel jLabel1 = new JLabel();
  JTextField txtAreaEnglish = new JTextField();
  JScrollPane jScrollPane1 = new JScrollPane();
  JTextArea txtAreaRemark = new JTextArea();
  JLabel jLabel3 = new JLabel();
  JButton btnOK = new JButton();
  JButton btnEXIT = new JButton();
  PnlListAreas _pnl;
  Record rec2Edit;
  boolean isEditing=false;
  public DlgEditArea(Frame frame, String title, boolean modal,Record recEdit,PnlListAreas pnl) {
    super(frame, title, modal);
    try {
      jbInit();
      pack();
      _pnl=pnl;
      rec2Edit=recEdit;
      if(rec2Edit.get(0)!=null && rec2Edit.getInt(0)>0){
        txtAreaChn.setText((rec2Edit.get(2)==null)?"":rec2Edit.get(2).toString());
        txtAreaEnglish.setText((rec2Edit.get(1)==null)?"":rec2Edit.get(1).toString());
        txtAreaRemark.setText((rec2Edit.get(3)==null)?"":rec2Edit.get(3).toString());
        isEditing=true;
      }
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }

  public DlgEditArea() {
    this(null, "", false,null,null);
  }

  private void jbInit() throws Exception {
    panel1.setLayout(null);
    jLabel2.setBounds(new Rectangle(50, 63, 129, 22));
    jLabel2.setText("Chinese Area Name:");
    txtAreaChn.setText("");
    txtAreaChn.setBounds(new Rectangle(182, 63, 161, 24));
    jLabel1.setText("AREA NAME:");
    jLabel1.setBounds(new Rectangle(49, 31, 102, 22));
    txtAreaEnglish.setText("");
    txtAreaEnglish.setBounds(new Rectangle(182, 32, 161, 23));
    jScrollPane1.setBounds(new Rectangle(47, 132, 296, 108));
    txtAreaRemark.setText("");
    jLabel3.setText("REMARK");
    jLabel3.setBounds(new Rectangle(50, 113, 131, 19));
    btnOK.setBounds(new Rectangle(51, 254, 85, 29));
    btnOK.setText("OK");
    btnOK.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnOK_actionPerformed(e);
      }
    });
    btnEXIT.setBounds(new Rectangle(271, 254, 76, 29));
    btnEXIT.setText("EXIT");
    btnEXIT.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnEXIT_actionPerformed(e);
      }
    });
    getContentPane().add(panel1);
    panel1.add(jLabel2, null);
    panel1.add(txtAreaChn, null);
    panel1.add(jLabel1, null);
    panel1.add(txtAreaEnglish, null);
    panel1.add(jScrollPane1, null);
    jScrollPane1.getViewport().add(txtAreaRemark, null);
    panel1.add(jLabel3, null);
    panel1.add(btnOK, null);
    panel1.add(btnEXIT, null);
  }

  void btnOK_actionPerformed(ActionEvent e) {
      if(txtAreaEnglish.getText().trim().length()==0){
        exgui.verification.VerifyLib.showAlert("Please Input Area Name",
                                               "Please Input Area Name");
        return;
      }
      if(txtAreaEnglish.getText().trim().length()>255){
        exgui.verification.VerifyLib.showAlert("Length Of Area Name Can not Over than 255 Characters",
                                               "String Too Long");
        return;
      }
      if(txtAreaChn.getText().trim().length()>255){
        exgui.verification.VerifyLib.showAlert("Length Of Chinese Area Name Can not Over than 255 Characters",
                                               "String Too Long");
        return;
      }
      if(txtAreaRemark.getText().trim().length()>255){
        exgui.verification.VerifyLib.showAlert("Length Of Area Remark Can not Over than 255 Characters",
                                               "String Too Long");
        return;
      }
     rec2Edit.set(1,txtAreaEnglish.getText().trim().toUpperCase());
     rec2Edit.set(2,txtAreaChn.getText().trim());
     rec2Edit.set(3,txtAreaRemark.getText().trim());
     try{
       util.MiscFunc.showProcessingMessage();
       if (isEditing) {
         java.util.Vector vct = new java.util.Vector();
         vct.add(rec2Edit);
         ((DB_AreaHandler)_pnl.getDbHandler()).updateRecords(vct);
       } else {
         ((DB_AreaHandler)_pnl.getDbHandler()).addRecord(rec2Edit);
       }
       util.MiscFunc.hideProcessingMessage();
       dispose();
       _pnl.reload();
     }catch(Exception exp){
       exp.printStackTrace();
       util.ExceptionLog.exp2File(exp,"");
       exgui.verification.VerifyLib.showAlert("Error While Add/Update data\nPlease Contact System Manager",
                                              "Server Side Error");
     }
  }

  void btnEXIT_actionPerformed(ActionEvent e) {
    dispose();
  }
}
