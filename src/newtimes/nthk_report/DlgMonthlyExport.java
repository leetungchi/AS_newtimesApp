package newtimes.nthk_report;

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

public class DlgMonthlyExport extends JDialog {
  JPanel panel1 = new JPanel();
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel1 = new BlueBkgWhiteCharLabel();
  JButton btnExit = new JButton();
  JButton btnOK = new JButton();
  JTextField txtYYYYMM = new JTextField();
  JLabel jLabel1 = new JLabel();
  JRadioButton rdlToBackup = new JRadioButton();
  JRadioButton rdoExportOrverWrite = new JRadioButton();
  ButtonGroup buttonGroup1 = new ButtonGroup();
  boolean isprocessing=false;
  java.text.SimpleDateFormat sd=new java.text.SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
  String centerCode;
  public DlgMonthlyExport(Frame frame, String title, boolean modal,String _centerCode) {
    super(frame, title, modal);
    centerCode=_centerCode;
    try {
      jbInit();
      pack();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }

  public DlgMonthlyExport() {
    this(null, "", false,null);
  }

  private void jbInit() throws Exception {
    panel1.setLayout(null);
    blueBkgWhiteCharLabel1.setText("EXPORT DATA");
    blueBkgWhiteCharLabel1.setBounds(new Rectangle(0, 24, 400, 35));
    btnExit.setBounds(new Rectangle(25, 248, 142, 32));
    btnExit.setFont(new java.awt.Font("Dialog", 1, 11));
    btnExit.setText("EXIT");
    btnExit.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnExit_actionPerformed(e);
      }
    });
    btnOK.setBounds(new Rectangle(210, 247, 115, 33));
    btnOK.setFont(new java.awt.Font("Dialog", 1, 11));
    btnOK.setText("OK");
    btnOK.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnOK_actionPerformed(e);
      }
    });
    txtYYYYMM.setText("");
    txtYYYYMM.setBounds(new Rectangle(180, 82, 160, 24));
    jLabel1.setFont(new java.awt.Font("Dialog", 1, 11));
    jLabel1.setText("YYYYMM :");
    jLabel1.setBounds(new Rectangle(106, 82, 72, 25));
    rdlToBackup.setFont(new java.awt.Font("Dialog", 1, 11));
    rdlToBackup.setSelected(true);
    rdlToBackup.setText("Backup Last Exported Data");
    rdlToBackup.setBounds(new Rectangle(60, 123, 274, 19));
    rdoExportOrverWrite.setFont(new java.awt.Font("Dialog", 1, 11));
    rdoExportOrverWrite.setSelected(false);
    rdoExportOrverWrite.setText("Direct OverWrite Current Exported Data");
    rdoExportOrverWrite.setBounds(new Rectangle(60, 148, 267, 23));
    getContentPane().add(panel1);
    panel1.add(blueBkgWhiteCharLabel1, null);
    panel1.add(btnExit, null);
    panel1.add(btnOK, null);
    panel1.add(txtYYYYMM, null);
    panel1.add(jLabel1, null);
    panel1.add(rdlToBackup, null);
    panel1.add(rdoExportOrverWrite, null);
    buttonGroup1.add(rdlToBackup);
    buttonGroup1.add(rdoExportOrverWrite);

    Object chkYearMon=exgui.verification.CellFormat.getIntVerifierAllowNull(6);
    DataBindTextWithChecker etdDate = new DataBindTextWithChecker(txtYYYYMM, "",
                                           null, 6,
                                           (Object2String)chkYearMon,
                                           (exgui.ultratable.CellTxtEditorFormat)chkYearMon);

    txtYYYYMM.setToolTipText("YYYYMM");
    java.text.SimpleDateFormat sd=new java.text.SimpleDateFormat("yyyyMM");
    txtYYYYMM.setText(sd.format(new java.util.Date(System.currentTimeMillis())));
  }

  void btnExit_actionPerformed(ActionEvent e) {
     this.dispose();
  }

  void btnOK_actionPerformed(ActionEvent e) {
      if(isprocessing)return;
      isprocessing=true;
      if(txtYYYYMM.getText().trim().length()<6){
       exgui.verification.VerifyLib.showAlert("REPORT DATE FORMAT IS :YYYYMM",
                                              "REPORT DATE FORMAT IS :YYYYMM");

       return;
      }
      try{
        util.MiscFunc.showProcessingMessage();
        newtimesejb.TPE_MIS.HK_EXPORT_FacadeHome  ejbHome =
            (newtimesejb.TPE_MIS.HK_EXPORT_FacadeHome)
            info_ejb.WeblogicServiceLocator.locateServiceHome(
             util.PublicVariable.SERVER_URL,
            "newtimesejb.TPE_MIS.HK_EXPORT_Facade");
        newtimesejb.TPE_MIS.HK_EXPORT_Facade  ejb = ejbHome.create();
        /*
        newtimesejb.TPE_MIS.TpeMisFuncHome ejbHome=
            (newtimesejb.TPE_MIS.TpeMisFuncHome)
            info_ejb.WeblogicServiceLocator.locateServiceHome(util.PublicVariable.SERVER_URL,
            "newtimesejb.TPE_MIS.TpeMisFunc");

        newtimesejb.TPE_MIS.TpeMisFunc ejb = ejbHome.create();
        java.util.HashMap hm = new java.util.HashMap();
        hm.put("TPEMISCFUNC_ACTION_CODE", "TOP_MANAGEMENT_REPORT_SAVE_TO_FILE");
        hm.put("center_code","NTHK");hm.put("yyyymm",txtYYYYMM.getText().trim());
        if(rdoExportOrverWrite.isSelected()){
          hm.put("HAVE_TO_BACKUP","FALSE");
        }else{
          hm.put("HAVE_TO_BACKUP","TRUE");
        }
        util.MiscFunc.showProcessingMessage();
        ejb.tpeMisFunc(hm);*/
        System.out.println("begin to process:"+sd.format(new java.sql.Date(System.currentTimeMillis())));
        if("NTHK".equals(centerCode)){
          ejb.NTHK_saveTopManagmentReport(centerCode, txtYYYYMM.getText().trim(),
                                          (rdlToBackup.isSelected()) ? true : false);
        }else{
          ejb.NTFE_saveTopManagmentReport(centerCode, txtYYYYMM.getText().trim(),
                                          (rdlToBackup.isSelected()) ? true : false);
        }
        System.out.println("end of process:"+sd.format(new java.sql.Date(System.currentTimeMillis())));
        exgui.verification.VerifyLib.showPlanMsg("Export OK!!","Export OK");
        this.dispose();
      }catch(Exception exp){
        System.out.println("Exception time at :"+sd.format(new java.sql.Date(System.currentTimeMillis())));
        exp.printStackTrace();
        exgui.verification.VerifyLib.showAlert("Export Failed!!\nPlease Contact System Manager",
                                               "Export Failed!!");
      }finally{
        util.MiscFunc.hideProcessingMessage();
        isprocessing=false;
      }

  }
}
