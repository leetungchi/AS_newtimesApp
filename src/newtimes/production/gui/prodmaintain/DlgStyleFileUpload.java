package newtimes.production.gui.prodmaintain;

import java.awt.*;
import javax.swing.*;
import exgui.*;
import java.io.*;
import java.awt.event.*;
/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class DlgStyleFileUpload extends JDialog {
  JPanel panel1 = new JPanel();
  BorderLayout borderLayout1 = new BorderLayout();
  protected int myOperationStatus=0;
  public static int STATUS_OPERATING=0;
  public static int STATUS_CLOSE_NORMALLY=1;
  public static int STATUS_CLOSE_CANCEL=2;
  JPanel pnlTItle = new JPanel();
  BlueBkgWhiteCharLabel lblTitle = new BlueBkgWhiteCharLabel();
  BorderLayout borderLayout2 = new BorderLayout();
  JPanel pnl2Contain = new JPanel();
  BorderLayout borderLayout3 = new BorderLayout();
  JPanel jPanel1 = new JPanel();
  JLabel jLabel1 = new JLabel();
  JPanel jPanel2 = new JPanel();
  JPanel jPanel3 = new JPanel();
  GridLayout gridLayout1 = new GridLayout();
  BorderLayout borderLayout4 = new BorderLayout();
  JScrollPane jScrollPane1 = new JScrollPane();
  JTextArea txtRmk = new JTextArea();
  GridLayout gridLayout2 = new GridLayout();
  JButton btnCnfm = new JButton();
  JButton btnCancel = new JButton();
  JButton btnDownload = new JButton();
  JButton btnOpenFile = new JButton();
  byte[] data2upload;
  String dataRemark;
  String save_file_ext_name;
  String save_file_ext_desc;
  String currentFileName=null;
  public DlgStyleFileUpload(Frame frame, String title, boolean modal) {
    super(frame, title, modal);
    try {
      jbInit();
      pack();
      util.MiscFunc.hideProcessingMessage();
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
  public DlgStyleFileUpload() {
    this(null, "", false);
  }

  private void jbInit() throws Exception {
    panel1.setLayout(borderLayout1);
    lblTitle.setText("   FILE CONTEXT  ");
    pnlTItle.setLayout(borderLayout2);
    pnl2Contain.setLayout(borderLayout3);
    jLabel1.setFont(new java.awt.Font("Dialog", 1, 11));
    jLabel1.setHorizontalAlignment(SwingConstants.LEADING);
    jLabel1.setHorizontalTextPosition(SwingConstants.TRAILING);
    jLabel1.setText("   REMARK:       ");
    jLabel1.setVerticalAlignment(javax.swing.SwingConstants.TOP);
    jPanel1.setLayout(gridLayout1);
    gridLayout1.setColumns(2);
    gridLayout1.setHgap(10);
    jPanel2.setLayout(borderLayout4);
    txtRmk.setMinimumSize(new Dimension(60, 50));
    txtRmk.setText("");
    jScrollPane1.setPreferredSize(new Dimension(120, 70));
    jPanel3.setLayout(gridLayout2);
    gridLayout2.setColumns(2);
    gridLayout2.setHgap(10);
    gridLayout2.setRows(2);
    gridLayout2.setVgap(5);
    btnCnfm.setFont(new java.awt.Font("Dialog", 1, 11));
    btnCnfm.setText("Confirm Update");
    btnCnfm.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnCnfm_actionPerformed(e);
      }
    });
    btnCancel.setFont(new java.awt.Font("Dialog", 1, 11));
    btnCancel.setText("CLOSE");
    btnCancel.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnCancel_actionPerformed(e);
      }
    });
    btnDownload.setFont(new java.awt.Font("Dialog", 1, 11));
    btnDownload.setActionCommand("Save To My PC.");
    btnDownload.setText("Save To My PC.");
    btnDownload.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnDownload_actionPerformed(e);
      }
    });
    btnOpenFile.setFont(new java.awt.Font("Dialog", 1, 11));
    btnOpenFile.setText("Select To Upload");
    btnOpenFile.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnOpenFile_actionPerformed(e);
      }
    });
    getContentPane().add(panel1);
    panel1.add(pnlTItle,  BorderLayout.NORTH);
    pnlTItle.add(lblTitle, BorderLayout.CENTER);
    panel1.add(pnl2Contain, BorderLayout.CENTER);


    panel1.add(jPanel1, BorderLayout.SOUTH);
    jPanel1.add(jPanel2, null);
    jPanel2.add(jLabel1,  BorderLayout.WEST);
    jPanel1.add(jPanel3, null);
    jPanel2.add(jScrollPane1, BorderLayout.CENTER);
    jScrollPane1.getViewport().add(txtRmk, null);
    jPanel3.add(btnOpenFile, null);
    jPanel3.add(btnDownload, null);
    jPanel3.add(btnCnfm, null);
    jPanel3.add(btnCancel, null);
    exgui.DataBindText tmpdbtxt= new exgui.DataBindText(
                                  txtRmk,"",null,200);
  }
  public void setRemarkText(String string){txtRmk.setText(string);}
  public String getRemarkText(){return txtRmk.getText();}
  public String getCurrentFileName(){return currentFileName;}
  public byte[] getCurrentFileData(){return  data2upload;}
  protected void setFile2View(java.awt.Image img){
    pnl2Contain.removeAll();
    javax.swing.JLabel lbl=new javax.swing.JLabel();
    lbl.setIcon(new ImageIcon(img));
    JScrollPane jScrollPane = new JScrollPane();
    jScrollPane.getViewport().add(lbl, null);
    pnl2Contain.add(jScrollPane, BorderLayout.CENTER);
    pnl2Contain.repaint();
    pnl2Contain.validate();
  }
  public void setPDFdata2View(String fileName,byte[] data)throws Exception{
    data2upload=data;
    com.adobe.acrobat.Viewer tmpViewer=new
        com.adobe.acrobat.Viewer();
    currentFileName=fileName;
    tmpViewer.setDocumentByteArray(data);
    setFile2View(tmpViewer);
  }
  public void setImagData2View(String fileName,byte[] imgData)throws Exception{
    data2upload=imgData;
    currentFileName=fileName;
    javax.swing.ImageIcon img=new javax.swing.ImageIcon(imgData);
    setFile2View(img.getImage());
  }
  protected void setFile2View(com.adobe.acrobat.Viewer viewer){
    pnl2Contain.removeAll();
    pnl2Contain.add(viewer,BorderLayout.CENTER);
    try{
      String[] disAbleCommand={"Open","OpenURL"};
      com.adobe.acrobat.gui.CommandRegistry.setDisallowedCommands(disAbleCommand);
      viewer.activate();
      pnl2Contain.repaint();
      pnl2Contain.validate();
    }catch(Exception e){
      e.printStackTrace();
      util.ExceptionLog.exp2File(e,"exception while activate com.adobe.acrobat.Viewer");
      exgui.verification.VerifyLib.showAlert(
      "Acrobat Viewer Eorr In Activation\nPlease Contact System Manager",
      "Acrobat Veiwer Error");
    }
  }
  void btnOpenFile_actionPerformed(ActionEvent e) {
     setCursor(new Cursor(Cursor.WAIT_CURSOR));
     JFileChooser fc = new JFileChooser();
     fc.setDialogType(fc.OPEN_DIALOG);
     fc.setAcceptAllFileFilterUsed(false);
     fc.addChoosableFileFilter(new myFilter("pdf","acrobat pdf file"));
     fc.addChoosableFileFilter(new exgui.ImageFilter());
     fc.setFileView(new ImageFileView());
     fc.setAccessory(new ImagePreview(fc));
     setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
     int returnVal = fc.showDialog(this,
                                   "SELECT FILE");

     if (returnVal == JFileChooser.APPROVE_OPTION) {
         File srcFile = fc.getSelectedFile();
         try{
           java.io.BufferedInputStream   bis=new
               java.io.BufferedInputStream(new java.io.FileInputStream(srcFile));
           currentFileName=srcFile.getName();
           data2upload =new byte[bis.available()];
           bis.read(data2upload);
           bis.close();
           String tmpStr[]=util.MiscFunc.split(srcFile.getName().toLowerCase(),".");
           save_file_ext_name=tmpStr[tmpStr.length-1];
           save_file_ext_desc=fc.getFileFilter().getDescription();
           //test if is a pdf file
           if (srcFile.getName().toLowerCase().endsWith(".pdf")) {
             com.adobe.acrobat.Viewer aViewer=new com.adobe.acrobat.Viewer();
             aViewer.setDocumentByteArray(data2upload);
             setFile2View(aViewer);
           }else{
             java.awt.Image img=new javax.swing.ImageIcon(data2upload).getImage();
             setFile2View(img);
           }
         }catch(Exception exp){
           exp.printStackTrace();
           util.ExceptionLog.exp2File(exp,"attemp to save file");
           exgui.verification.VerifyLib.showAlert(
           "File I/O Error,Please Contact System Manager",
           "I/O Error");
         }
     } else {
        return;
     }


  }

  private class MyFileChooser extends JFileChooser{
          public MyFileChooser(){
              super();
          }

          public MyFileChooser(String baseDir){
              super(baseDir);
          }

          public void approveSelection(){
              if(!validateFile(this.getSelectedFile()))
              {
                  //show some error message
                  return;//the FileChooser wont close until and unless u call  super.approveSelection()
              }
              super.approveSelection();
          }
          private boolean validateFile(File file){
              //do your validation here
              if(file.exists()){
                  if (JOptionPane.showConfirmDialog(
                    null, "File exists,overwrite?",
                    "Overwrite File?",
                    JOptionPane.YES_NO_OPTION) ==JOptionPane.YES_OPTION)
                    return true;
                  return false;
              }else return true;
          }
      }
  void btnDownload_actionPerformed(ActionEvent e) {
    setCursor(new Cursor(Cursor.WAIT_CURSOR));
    MyFileChooser chooser = new MyFileChooser();
    chooser.setDialogType(JFileChooser.SAVE_DIALOG);
    chooser.setAcceptAllFileFilterUsed(false);
    chooser.addChoosableFileFilter(new myFilter("pdf","acrobat pdf file"));
    chooser.addChoosableFileFilter(new exgui.ImageFilter());
    chooser.setFileView(new ImageFileView());
    chooser.setAccessory(new ImagePreview(chooser));
    setCursor(new Cursor(Cursor.DEFAULT_CURSOR));

    int returnVal = chooser.showDialog(this,"SAVE");
        File file=chooser.getSelectedFile();
        if(returnVal == JFileChooser.APPROVE_OPTION) {
            //String outfile=new String(chooser.getSelectedFile().getPath());
            //if(returnVal==JOptionPane.YES_OPTION){
              try {
                java.io.BufferedOutputStream  bo=new
                 java.io.BufferedOutputStream(new java.io.FileOutputStream(file));
                 currentFileName=file.getName();
                bo.write(data2upload);
                bo.flush();
                bo.close();
                exgui.verification.VerifyLib.showPlanMsg("File Download And Save OK",
                                                         "File Saved");
              } catch (Exception exp) {
                 exp.printStackTrace();
                 util.ExceptionLog.exp2File(exp,"attemp to save file");
                 exgui.verification.VerifyLib.showAlert(
                 "File I/O Error,Please Contact System Manager",
                 "I/O Error");
              }
            //}
        }

  }

  void btnCnfm_actionPerformed(ActionEvent e) {
    //test if file is null or remark is null
    if(txtRmk.getText().trim().length()==0){
      exgui.verification.VerifyLib.showPlanMsg("Please Input Remark Of This File",
                                               "Please Input Remark Of This File");
      txtRmk.grabFocus();
      return;
    }
    if(txtRmk.getText().trim().getBytes().length>200){
      exgui.verification.VerifyLib.showPlanMsg("Remark of this file can not exceed 200 characters",
                                               "Data Too Long");
      txtRmk.grabFocus();
      return;
    }
    if(data2upload==null||data2upload.length==0){
      exgui.verification.VerifyLib.showPlanMsg("Please Select A Image Or PDF File To Upload",
                                               "Please Select A File");
      return;
    }
    myOperationStatus=STATUS_CLOSE_NORMALLY;
    this.dispose();
  }

  void btnCancel_actionPerformed(ActionEvent e) {
    myOperationStatus=STATUS_CLOSE_CANCEL;
    this.dispose();
  }

}
 class myFilter extends javax.swing.filechooser.FileFilter{
    public String ext;
    public String des;

    public boolean accept(File file){
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


