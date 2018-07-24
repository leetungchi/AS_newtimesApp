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

public class DlgOutstandingExport extends JDialog {
  JPanel panel1 = new JPanel();
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel1 = new BlueBkgWhiteCharLabel();
  JLabel lblFrom = new JLabel();
  JTextField txtFrom = new JTextField();
  JButton btnExport = new JButton();
  JButton btnExit = new JButton();
  boolean isprocessing=false;
  String centerCode;
  public DlgOutstandingExport(Frame frame, String title, boolean modal,String _centerCode) {
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

  public DlgOutstandingExport() {
    this(null, "", false,null);
  }

  private void jbInit() throws Exception {
    panel1.setLayout(null);
    blueBkgWhiteCharLabel1.setText("Range of Outstanding Export");
    blueBkgWhiteCharLabel1.setBounds(new Rectangle(-1, 9, 604, 31));
    this.getContentPane().setLayout(null);
    panel1.setBounds(new Rectangle(0, 0, 604, 157));
    lblFrom.setFont(new java.awt.Font("Dialog", 1, 11));
    lblFrom.setText("DEL. :");
    lblFrom.setBounds(new Rectangle(221, 60, 60, 24));
    txtFrom.setText("");
    txtFrom.setToolTipText("String must be in date format:yyyy/mm/dd");
    txtFrom.setBounds(new Rectangle(287, 60, 92, 24));
    btnExport.setBounds(new Rectangle(447, 60, 108, 24));
    btnExport.setFont(new java.awt.Font("Dialog", 1, 11));
    btnExport.setText("EXPORT");
    btnExport.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnExport_actionPerformed(e);
      }
    });
    btnExit.setBounds(new Rectangle(447, 116, 108, 24));
    btnExit.setFont(new java.awt.Font("Dialog", 1, 11));
    btnExit.setText("EXIT");
    btnExit.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnExit_actionPerformed(e);
      }
    });
    getContentPane().add(panel1, null);
    panel1.add(blueBkgWhiteCharLabel1, null);
    panel1.add(btnExport, null);
    panel1.add(btnExit, null);
    panel1.add(lblFrom, null);
    panel1.add(txtFrom, null);
    Object chkYearMon=exgui.verification.CellFormat.getIntVerifierAllowNull(6);
    DataBindTextWithChecker etdDate = new DataBindTextWithChecker(txtFrom, "",
                                           null, 6,
                                           (Object2String)chkYearMon,
                                           (exgui.ultratable.CellTxtEditorFormat)chkYearMon);

    txtFrom.setToolTipText("YYYYMM");
    java.text.SimpleDateFormat sd=new java.text.SimpleDateFormat("yyyyMM");
    txtFrom.setText(sd.format(new java.util.Date(System.currentTimeMillis())));

  }

  void btnExit_actionPerformed(ActionEvent e) {
    this.dispose();
  }

  void btnExport_actionPerformed(ActionEvent e) {
      //check text feld
      if(txtFrom.getText().trim().length()<6){
       exgui.verification.VerifyLib.showAlert("REPORT DATE FORMAT IS :YYYYMM",
                                              "REPORT DATE FORMAT IS :YYYYMM");

       return;
      }
      java.text.SimpleDateFormat sd=new java.text.SimpleDateFormat("yyyyMM");
      sd.setLenient(false);
      if(txtFrom.getText().trim().length()==0){
        txtFrom.setText(sd.format(new java.util.Date(System.currentTimeMillis())));
      }
      try{
        sd=new java.text.SimpleDateFormat("yyyyMMdd");
        sd.setLenient(false);
        sd.parse(txtFrom.getText()+"01");
      }catch(Exception exp){
        exp.printStackTrace();
        exgui.verification.VerifyLib.showAlert("Date Format Error","Date Formate Error");
        txtFrom.grabFocus();
        return;
      }

      try{
        if(isprocessing)return;
        isprocessing=true;
        String bgn=txtFrom.getText()+"01";
        String end=txtFrom.getText().substring(0,4)+"1231";
        util.MiscFunc.showProcessingMessage();
        newtimesejb.TPE_MIS.HK_EXPORT_FacadeHome  ejbHome =
            (newtimesejb.TPE_MIS.HK_EXPORT_FacadeHome)
            info_ejb.WeblogicServiceLocator.locateServiceHome(util.PublicVariable.
            SERVER_URL,
            "newtimesejb.TPE_MIS.HK_EXPORT_Facade");
        newtimesejb.TPE_MIS.HK_EXPORT_Facade  ejb = ejbHome.create();

        /*
        newtimesejb.TPE_MIS.TpeMisFuncHome ejbHome=
            (newtimesejb.TPE_MIS.TpeMisFuncHome)
            info_ejb.WeblogicServiceLocator.locateServiceHome(util.PublicVariable.SERVER_URL,
            "newtimesejb.TPE_MIS.TpeMisFunc");
        newtimesejb.TPE_MIS.TpeMisFunc ejb=ejbHome.create();
        java.util.HashMap hm=new java.util.HashMap();
        hm.put("TPEMISCFUNC_ACTION_CODE","NTHK_OUTSTANDING_EXPORT");
        hm.put("NTHK_OUTSTANDING_EXPORT_START_DATE",bgn);
        hm.put("NTHK_OUTSTANDING_EXPORT_END_DATE",end);
        ejb.tpeMisFunc(hm);*/
       if("NTHK".equals(centerCode)){
         ejb.NTHK_insertIntoOutstandingExport(bgn, end);
       }else{
         ejb.NTFE_insertIntoOutstandingExport(bgn, end);
       }
        exgui.verification.VerifyLib.showPlanMsg("EXPORT OK","EXPORT OK");
        this.dispose();
      }catch(Exception exp){
        exgui.verification.VerifyLib.showAlert("Export Failed!!\nPlease Contact System Manager","Export Failed");
        exp.printStackTrace();
        util.ExceptionLog.exp2File(exp,"");
      }finally{
        isprocessing=false;
        util.MiscFunc.hideProcessingMessage();
      }


  }
}
