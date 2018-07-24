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

public class DlgUploadEDI extends JDialog {
  JPanel panel1 = new JPanel();
  JLabel jLabel1 = new JLabel();
  JTextField txtScCsvPath = new JTextField();
  JButton btnScCsv = new JButton();
  JTextField txtCtCsvPath = new JTextField();
  JButton btnCtCsv = new JButton();
  JLabel jLabel2 = new JLabel();
  JTextField txtDtlCsvPath = new JTextField();
  JButton btnDtlCsv = new JButton();
  JLabel jLabel3 = new JLabel();
  JButton btnUpload = new JButton();
  JButton btnExit = new JButton();
  boolean isUploading=false;
  public DlgUploadEDI(Frame frame, String title, boolean modal) {
    super(frame, title, modal);
    try {
      jbInit();
      pack();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }

  public DlgUploadEDI() {
    this(null, "", false);
  }

  private void jbInit() throws Exception {
    panel1.setLayout(null);
    jLabel1.setFont(new java.awt.Font("Dialog", 1, 11));
    jLabel1.setText("S/C HEAD CSV FILE:");
    jLabel1.setBounds(new Rectangle(13, 84, 131, 27));
    txtScCsvPath.setText("");
    txtScCsvPath.setBounds(new Rectangle(145, 84, 331, 27));
    btnScCsv.setBounds(new Rectangle(477, 84, 45, 27));
    btnScCsv.setFont(new java.awt.Font("Dialog", 1, 11));
    btnScCsv.setText("...");
    btnScCsv.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnScCsv_actionPerformed(e);
      }
    });
    txtCtCsvPath.setBounds(new Rectangle(145, 146, 331, 27));
    txtCtCsvPath.setText("");
    btnCtCsv.setText("...");
    btnCtCsv.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnCtCsv_actionPerformed(e);
      }
    });
    btnCtCsv.setFont(new java.awt.Font("Dialog", 1, 11));
    btnCtCsv.setBounds(new Rectangle(477, 146, 45, 27));
    jLabel2.setBounds(new Rectangle(13, 146, 131, 27));
    jLabel2.setText("C/T HEAD CSV FILE:");
    jLabel2.setFont(new java.awt.Font("Dialog", 1, 11));
    txtDtlCsvPath.setBounds(new Rectangle(145, 207, 331, 27));
    txtDtlCsvPath.setText("");
    btnDtlCsv.setText("...");
    btnDtlCsv.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnDtlCsv_actionPerformed(e);
      }
    });
    btnDtlCsv.setFont(new java.awt.Font("Dialog", 1, 11));
    btnDtlCsv.setBounds(new Rectangle(477, 207, 45, 27));
    jLabel3.setBounds(new Rectangle(13, 207, 131, 27));
    jLabel3.setText("DETAIL CSV FILE:");
    jLabel3.setFont(new java.awt.Font("Dialog", 1, 11));
    btnUpload.setBounds(new Rectangle(99, 289, 88, 32));
    btnUpload.setFont(new java.awt.Font("Dialog", 1, 11));
    btnUpload.setText("UPLOAD");
    btnUpload.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnUpload_actionPerformed(e);
      }
    });
    btnExit.setBounds(new Rectangle(309, 289, 88, 32));
    btnExit.setFont(new java.awt.Font("Dialog", 1, 11));
    btnExit.setForeground(Color.red);
    btnExit.setText("EXIT");
    btnExit.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnExit_actionPerformed(e);
      }
    });
    getContentPane().add(panel1);
    panel1.add(jLabel1, null);
    panel1.add(txtScCsvPath, null);
    panel1.add(btnScCsv, null);
    panel1.add(txtCtCsvPath, null);
    panel1.add(btnCtCsv, null);
    panel1.add(jLabel2, null);
    panel1.add(txtDtlCsvPath, null);
    panel1.add(btnDtlCsv, null);
    panel1.add(jLabel3, null);
    panel1.add(btnUpload, null);
    panel1.add(btnExit, null);
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
      if(btn==btnCtCsv){
        txtCtCsvPath.setText(srcFile.getPath());
      }
      if(btn==btnScCsv){
        txtScCsvPath.setText(srcFile.getPath());
      }
      if(btn==btnDtlCsv){
        txtDtlCsvPath.setText(srcFile.getPath());
      }

    }
  }

  void btnUpload_actionPerformed(ActionEvent e) {
    if(isUploading)return;
    if(txtScCsvPath.getText().trim().length()==0){
      exgui.verification.VerifyLib.showAlert("Please Input SC CSV file","Please Assigne SC csv file");
      return;
    }

    if(txtCtCsvPath.getText().trim().length()==0){
      exgui.verification.VerifyLib.showAlert("Please Input CT CSV file","Please Assigne CT csv file");
      return;
    }

    if(txtDtlCsvPath.getText().trim().length()==0){
      exgui.verification.VerifyLib.showAlert("Please Input DETAIL CSV file","Please Assigne DETAIL csv file");
      return;
    }

    try{
      String lastTimeProcessing=String.valueOf(System.currentTimeMillis());

      util.MiscFunc.showProcessingMessage();
      java.io.BufferedInputStream bisSC = new
          java.io.BufferedInputStream(new java.io.FileInputStream(txtScCsvPath.getText()));
      byte[] scByte = new byte[bisSC.available()];
      bisSC.read(scByte);
      bisSC.close();

      java.io.BufferedInputStream bisCT = new
          java.io.BufferedInputStream(new java.io.FileInputStream(txtCtCsvPath.getText()));
      byte[] ctByte = new byte[bisCT.available()];
      bisCT.read(ctByte);
      bisCT.close();

      java.io.BufferedInputStream bisDtl = new
          java.io.BufferedInputStream(new java.io.FileInputStream(txtDtlCsvPath.getText()));
      byte[] dtlByte = new byte[bisDtl.available()];
      bisDtl.read(dtlByte);
      bisDtl.close();

      NTD_Upload.EdiUploadFacadeHome ejbHome=
          (NTD_Upload.EdiUploadFacadeHome)
          info_ejb.WeblogicServiceLocator.locateServiceHome(util.PublicVariable.SERVER_URL,"NTD_Upload.EdiUploadFacade");

     /*
     NTD_Upload.EdiUploadFacadeHome ejbHome=
         (NTD_Upload.EdiUploadFacadeHome)
         info_ejb.WeblogicServiceLocator.locateServiceHomeNewContext("172.16.0.27"
         ,7001
         ,"NTD_Upload.EdiUploadFacade");
     */
      NTD_Upload.EdiUploadFacade ejb=ejbHome.create();
      /*
      ejb.doImport(scByte,ctByte,dtlByte,util.PublicVariable.USER_RECORD.get(0).toString());
      exgui.verification.VerifyLib.showPlanMsg("upload OK","upload OK");
      */
      isUploading=true;
      byte[] filedata=ejb.doImportGetResult(scByte,ctByte,dtlByte,util.PublicVariable.USER_RECORD.get(0).toString(),
                                            lastTimeProcessing);
      //write to file
      if(filedata==null)return;
      java.text.DateFormat df=new java.text.SimpleDateFormat("yyyyMMdd");
      String fileName="c:\\"+df.format(new java.sql.Date(System.currentTimeMillis()))+".csv";
      java.io.File file=new java.io.File(fileName);
      if(file.exists())file.delete();
      java.io.FileOutputStream fo=new java.io.FileOutputStream(file);
      fo.write(filedata);
      fo.close();
      exgui.verification.VerifyLib.showPlanMsg("upload OK\nPlease Chek Result File:"+fileName,"upload OK");


    }catch(NTD_Upload.ExpBuyerNotFound expBuyerNotFound){
      expBuyerNotFound.printStackTrace();
      util.ExceptionLog.exp2File(expBuyerNotFound,"");
      String errMsg=expBuyerNotFound.getUploadErrorMessage();
      if(errMsg.indexOf("Buyer Code")!=-1){
        exgui.verification.VerifyLib.showAlert(
          errMsg,
         "Upload EDI Buyer Not Found");
      }
      if(errMsg.indexOf("Dep Code")!=-1){
        exgui.verification.VerifyLib.showAlert(
          errMsg,
         "Upload EDI Department Code Not Found");
      }
      if(errMsg.indexOf("14 Size")!=-1){
        exgui.verification.VerifyLib.showAlert(
          errMsg,
         "size of style is too much");
      }

    }catch(Exception exp){
      if(exp instanceof NTD_Upload.ExpBuyerNotFound){
        exp.printStackTrace();
        util.ExceptionLog.exp2File(exp,"");
        String errMsg=((NTD_Upload.ExpBuyerNotFound)exp).getUploadErrorMessage();
        if(errMsg.indexOf("Buyer Code")!=-1){
          exgui.verification.VerifyLib.showAlert(
            errMsg,
           "Upload EDI Buyer Not Found");
        }
        if(errMsg.indexOf("Dep Code")!=-1){
          exgui.verification.VerifyLib.showAlert(
            errMsg,
           "Upload EDI Department Code Not Found");
        }
        if(errMsg.indexOf("14 Size")!=-1){
          exgui.verification.VerifyLib.showAlert(
            errMsg,
           "size of style is too much");
        }
        return;
      }
      exp.printStackTrace();
      util.ExceptionLog.exp2File(exp,"");
      exgui.verification.VerifyLib.showAlert("Upload EDI failed!!\nPlease Contact System Manager to check Error","Upload EDI failed");
    }finally{
      isUploading=false;
      util.MiscFunc.hideProcessingMessage();
    }
  }

  void btnScCsv_actionPerformed(ActionEvent e) {
    showFileChooser(e.getSource());
  }

  void btnCtCsv_actionPerformed(ActionEvent e) {
    showFileChooser(e.getSource());
  }

  void btnDtlCsv_actionPerformed(ActionEvent e) {
    showFileChooser(e.getSource());
  }

  void btnExit_actionPerformed(ActionEvent e) {
     this.dispose();
  }
}
