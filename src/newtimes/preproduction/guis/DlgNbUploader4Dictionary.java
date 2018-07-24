package newtimes.preproduction.guis;

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

public class DlgNbUploader4Dictionary extends JDialog {
  JPanel panel1 = new JPanel();
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel1 = new BlueBkgWhiteCharLabel();
  WhiteBkgBlueCharLabel lblExlClmName = new WhiteBkgBlueCharLabel();
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel2 = new BlueBkgWhiteCharLabel();
  JTextField txtExlValue = new JTextField();
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel3 = new BlueBkgWhiteCharLabel();
  JComboBox cbxErpValue = null;
  JButton btnOK = new JButton();
  JButton btnStopChk = new JButton();
  DlgNbUploader dlgNbUploader;
  java.util.HashMap hmProce;
  public DlgNbUploader4Dictionary(Frame frame, String title, boolean modal,
                                  String columnName,String columvalue,
                                  DlgNbUploader _dlgNbUploader,java.util.HashMap _hmProce) {
    super(frame, title, modal);
    try {
      dlgNbUploader=_dlgNbUploader;
      hmProce=_hmProce;
      String[] cbxStrArr=(String[])hmProce.get(dlgNbUploader.STRING_ARRAY_AS_);
      cbxErpValue = new JComboBox(cbxStrArr);
      jbInit();
      lblExlClmName.setText(columnName);
      txtExlValue.setText(columvalue);
      txtExlValue.setEditable(false);
      pack();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }

  public DlgNbUploader4Dictionary() {
    this(null, "", false,null,null,null,null);
  }

  private void jbInit() throws Exception {
    blueBkgWhiteCharLabel2.setBounds(new Rectangle(10, 51, 118, 25));
    blueBkgWhiteCharLabel2.setText("COLUMN VALUE:");
    txtExlValue.setText("");
    txtExlValue.setBounds(new Rectangle(127, 51, 310, 25));
    blueBkgWhiteCharLabel3.setText("ERP VALUE:");
    blueBkgWhiteCharLabel3.setBounds(new Rectangle(10, 86, 118, 25));
    cbxErpValue.setBounds(new Rectangle(128, 86, 466, 25));
    btnOK.setBounds(new Rectangle(458, 121, 106, 25));
    btnOK.setFont(new java.awt.Font("Dialog", 1, 11));
    btnOK.setText("OK");
    btnOK.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnOK_actionPerformed(e);
      }
    });
    btnStopChk.setText("STOP UPLOAD PROCESS");
    btnStopChk.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnStopChk_actionPerformed(e);
      }
    });
    btnStopChk.setFont(new java.awt.Font("Dialog", 1, 11));
    btnStopChk.setForeground(Color.red);
    btnStopChk.setBounds(new Rectangle(132, 121, 256, 25));
    panel1.add(blueBkgWhiteCharLabel1, null);
    panel1.add(lblExlClmName, null);
    panel1.add(blueBkgWhiteCharLabel2, null);
    panel1.add(txtExlValue, null);
    panel1.setLayout(null);
    blueBkgWhiteCharLabel1.setText("COLUMN NAME:");
    blueBkgWhiteCharLabel1.setBounds(new Rectangle(10, 15, 118, 25));
    lblExlClmName.setText("");
    lblExlClmName.setBounds(new Rectangle(127, 15, 310, 25));
    this.getContentPane().add(panel1, BorderLayout.CENTER);
    panel1.add(blueBkgWhiteCharLabel3, null);
    panel1.add(cbxErpValue, null);
    panel1.add(btnStopChk, null);
    panel1.add(btnOK, null);

  }

  void btnOK_actionPerformed(ActionEvent e) {
    try {
      newtimesejb.TPE_MIS.TpeMisFuncHome ejbHome=
          (newtimesejb.TPE_MIS.TpeMisFuncHome)
          info_ejb.WeblogicServiceLocator.locateServiceHome(
          util.PublicVariable.SERVER_URL,
          "newtimesejb.TPE_MIS.TpeMisFunc");

      newtimesejb.TPE_MIS.TpeMisFunc ejb2update=ejbHome.create();
      java.util.HashMap hmParam=new java.util.HashMap();
      hmParam.put("TPEMISCFUNC_ACTION_CODE","UPDATE_NB_UPLOAD_DICTIONARY");
      hmParam.put("EXL_CLM_NAME",lblExlClmName.getText());
      hmParam.put("EXL_VALUE",txtExlValue.getText().trim());
      hmParam.put("ERP_VALUE",cbxErpValue.getSelectedItem());
      hmParam.put("USER_CODE",util.PublicVariable.USER_RECORD.get(0));
      ejb2update.tpeMisFunc(hmParam);
      hmProce.put(txtExlValue.getText().trim(),cbxErpValue.getSelectedItem());
      this.dispose();
    }catch(Exception exp){
      exp.printStackTrace();
      exgui.verification.VerifyLib.showAlert("Error While Updating Dictionary,Upload terminated","Error while update Dictionary");
      dlgNbUploader.uploadStop();
      this.dispose();
    }


  }

  void btnStopChk_actionPerformed(ActionEvent e) {
    if(!exgui.verification.VerifyLib.showConfirm("Are You Sure to Stop And Exit Upload Process ?","Are You Sure?",false)){
      return;
    }
     dlgNbUploader.uploadStop();
     this.dispose();
  }
}
