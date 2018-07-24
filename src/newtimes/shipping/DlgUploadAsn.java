package newtimes.shipping;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class DlgUploadAsn extends JDialog {
  JPanel panel1 = new JPanel();
  JLabel jLabel1 = new JLabel();
  JTextField txtAsnFile = new JTextField();
  JButton btnSlkFile = new JButton();
  JButton btnUpLoad = new JButton();
  JButton btnExit = new JButton();

  public DlgUploadAsn(Frame frame, String title, boolean modal) {
    super(frame, title, modal);
    try {
      jbInit();
      pack();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }

  public DlgUploadAsn() {
    this(null, "", false);
  }

  private void jbInit() throws Exception {
    panel1.setLayout(null);
    jLabel1.setFont(new java.awt.Font("Dialog", 1, 11));
    jLabel1.setText("ASN FILE PATH:");
    jLabel1.setBounds(new Rectangle(13, 43, 90, 28));
    txtAsnFile.setText("");
    txtAsnFile.setBounds(new Rectangle(101, 47, 380, 25));
    btnSlkFile.setBounds(new Rectangle(484, 47, 45, 24));
    btnSlkFile.setFont(new java.awt.Font("Dialog", 1, 11));
    btnSlkFile.setText("...");
    btnSlkFile.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnSlkFile_actionPerformed(e);
      }
    });
    btnUpLoad.setBounds(new Rectangle(137, 107, 100, 28));
    btnUpLoad.setFont(new java.awt.Font("Dialog", 1, 11));
    btnUpLoad.setText("UPLOAD");
    btnUpLoad.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnUpLoad_actionPerformed(e);
      }
    });
    btnExit.setText("EXIT");
    btnExit.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnExit_actionPerformed(e);
      }
    });
    btnExit.setBounds(new Rectangle(331, 107, 100, 28));
    btnExit.setFont(new java.awt.Font("Dialog", 1, 11));
    btnExit.setForeground(Color.red);
    getContentPane().add(panel1);
    panel1.add(jLabel1, null);
    panel1.add(txtAsnFile, null);
    panel1.add(btnSlkFile, null);
    panel1.add(btnUpLoad, null);
    panel1.add(btnExit, null);
  }

  void btnUpLoad_actionPerformed(ActionEvent e) {
    try{
      if(txtAsnFile.getText().trim().length()==0){
        exgui.verification.VerifyLib.showAlert("Please Input File Path","Please Input File Path");
        return;
      }
      util.MiscFunc.showProcessingMessage();
      java.io.BufferedInputStream bisASN = new
          java.io.BufferedInputStream(new java.io.FileInputStream(txtAsnFile.getText()));
      byte[] asnByte = new byte[bisASN.available()];
      bisASN.read(asnByte);
      bisASN.close();

      NTD_Upload.AsnUploadFacadeHome ejbHome=
          (NTD_Upload.AsnUploadFacadeHome)
          info_ejb.WeblogicServiceLocator.locateServiceHome(util.PublicVariable.SERVER_URL,"NTD_Upload.AsnUploadFacade");
        NTD_Upload.AsnUploadFacade ejb=ejbHome.create();
        ejb.doUpload(asnByte,util.PublicVariable.USER_RECORD.get(0).toString());
      util.MiscFunc.hideProcessingMessage();
      exgui.verification.VerifyLib.showPlanMsg("Upload OK!!","Upload OK!!");
    }catch(Exception exp){
      exp.printStackTrace();
      util.ExceptionLog.exp2File(exp,"");
      exgui.verification.VerifyLib.showAlert("UPLOAD FAILED!!\nPlease Contact System Manager","UPLOAD FAILED!!");
    }
  }

  void btnExit_actionPerformed(ActionEvent e) {
    this.dispose();
  }

  void btnSlkFile_actionPerformed(ActionEvent e) {
    showFileChooser(btnSlkFile);
  }
  class myFilter extends javax.swing.filechooser.FileFilter{
     public String ext;
     public String des;

     public boolean accept(java.io.File file){
         if(file != null) {
           if(file.isDirectory()) {
              return true;
           }
           String filename=file.getName();
           return filename.endsWith(ext);
         }
         return false;
     }
     public String getDescription(){
        return des;
    }

     public myFilter(String extension, String description) {
       if(extension!=null) ext=extension;
       if(description!=null) des=description;
     }

 }
  public void showFileChooser(Object btn){
    JFileChooser fc = new JFileChooser();
    fc.setDialogType(fc.OPEN_DIALOG);
    fc.setAcceptAllFileFilterUsed(false);
    fc.addChoosableFileFilter(new myFilter("csv","csv,cama columned file"));
    setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
    int returnVal = fc.showDialog(this, "SELECT FILE");
    if (returnVal == JFileChooser.APPROVE_OPTION) {
     java.io.File srcFile = fc.getSelectedFile();
      if(btn==btnSlkFile){
        txtAsnFile.setText(srcFile.getPath());
      }

    }
  }

}
