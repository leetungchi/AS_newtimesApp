package newtimes.vsd_upload;

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

public class DlgUpload extends JDialog {
  JPanel panel1 = new JPanel();
  WhiteBkgBlueCharLabel whiteBkgBlueCharLabel1 = new WhiteBkgBlueCharLabel();
  JLabel lblFilePath = new JLabel();
  JButton btnSlkFile = new JButton();
  JButton btnUpload = new JButton();
  JButton btnExit = new JButton();
  JScrollPane jScrollPane1 = new JScrollPane();
  JTextArea txtMsg = new JTextArea();
  JLabel jLabel2 = new JLabel();
  public DlgUpload(Frame frame, String title, boolean modal) {
    super(frame, title, modal);
    try {
      jbInit();
      pack();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }

  public DlgUpload() {
    this(null, "", false);
  }

  private void jbInit() throws Exception {
    panel1.setLayout(null);
    whiteBkgBlueCharLabel1.setText("Select File To Upload");
    whiteBkgBlueCharLabel1.setBounds(new Rectangle(21, 26, 139, 29));
    lblFilePath.setBorder(BorderFactory.createLoweredBevelBorder());
    lblFilePath.setText("");
    lblFilePath.setBounds(new Rectangle(162, 27, 445, 29));
    btnSlkFile.setBounds(new Rectangle(607, 28, 49, 27));
    btnSlkFile.setFont(new java.awt.Font("Dialog", 1, 11));
    btnSlkFile.setText("...");
    btnSlkFile.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnSlkFile_actionPerformed(e);
      }
    });
    btnUpload.setBounds(new Rectangle(531, 73, 120, 28));
    btnUpload.setFont(new java.awt.Font("Dialog", 1, 11));
    btnUpload.setText("UPLOAD");
    btnUpload.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnUpload_actionPerformed(e);
      }
    });
    btnExit.setText("EXIT");
    btnExit.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnExit_actionPerformed(e);
      }
    });
    btnExit.setBounds(new Rectangle(502, 377, 120, 28));
    btnExit.setFont(new java.awt.Font("Dialog", 1, 11));
    btnExit.setForeground(Color.red);
    jScrollPane1.setBounds(new Rectangle(26, 113, 616, 257));
    txtMsg.setText("");
    jLabel2.setFont(new java.awt.Font("Dialog", 1, 11));
    jLabel2.setText("MESSAGE:");
    jLabel2.setBounds(new Rectangle(31, 90, 133, 16));
    getContentPane().add(panel1);
    panel1.add(whiteBkgBlueCharLabel1, null);
    panel1.add(lblFilePath, null);
    panel1.add(btnSlkFile, null);
    panel1.add(jScrollPane1, null);
    jScrollPane1.getViewport().add(txtMsg, null);
    panel1.add(btnUpload, null);
    panel1.add(jLabel2, null);
    panel1.add(btnExit, null);
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
        lblFilePath.setText(srcFile.getPath());
      }

    }
  }

  void btnUpload_actionPerformed(ActionEvent e) {
    if(lblFilePath.getText().trim().length()==0){
      exgui.verification.VerifyLib.showAlert("Please Select VSD-CSV file to upload","Please Select File");
      return;
    }
    VsdUpload vsdupload=new VsdUpload();
    vsdupload.dlgUpload=this;
    //if(vsdupload.ejbUpload==null)return;//error happends
    vsdupload.startCsvUpload(lblFilePath.getText().trim());
    //after all,leave the message dialog ,let user determ to close or not
  }

  void btnExit_actionPerformed(ActionEvent e) {
    this.dispose();
  }

}
