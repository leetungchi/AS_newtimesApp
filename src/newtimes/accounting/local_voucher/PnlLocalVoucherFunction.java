package newtimes.accounting.local_voucher;

import java.awt.*;
import exgui.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;
import database.datatype.Record;
/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class PnlLocalVoucherFunction extends JPanel {
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel1 = new BlueBkgWhiteCharLabel();
  JButton btnExit = new JButton();
  JButton btnMakerInfor = new JButton();
  JButton btnCnvSrn2LocalVoucher = new JButton();
  JButton btnListLocalVoucher = new JButton();
  JButton btnCnv2F107 = new JButton();
  JButton btnSrnHeadBasicMtn = new JButton();
  JButton btnDeductMaintain = new JButton();
  JButton btnLvBalance = new JButton();
  JButton btnLDbntDdtList = new JButton();

  public PnlLocalVoucherFunction() {
    try {
      jbInit();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }

  void jbInit() throws Exception {
    blueBkgWhiteCharLabel1.setText("LOCAL VOUCHER FUNCTION");
    blueBkgWhiteCharLabel1.setBounds(new Rectangle(0, 21, 816, 33));
    this.setBackground(new Color(202, 202, 224));
    this.setFont(new java.awt.Font("Dialog", 1, 11));
    this.setLayout(null);
    btnExit.setBackground(Color.white);
    btnExit.setBounds(new Rectangle(338, 528, 124, 29));
    btnExit.setFont(new java.awt.Font("Dialog", 1, 11));
    btnExit.setText("EXIT");
    btnExit.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnExit_actionPerformed(e);
      }
    });
    btnMakerInfor.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnMakerInfor_actionPerformed(e);
      }
    });
    btnMakerInfor.setText("MAKER INFORMATION MAINTAIN");
    btnMakerInfor.setFont(new java.awt.Font("Dialog", 1, 11));
    btnMakerInfor.setBounds(new Rectangle(273, 94, 255, 31));
    btnMakerInfor.setBackground(Color.white);
    btnCnvSrn2LocalVoucher.setBackground(Color.white);
    btnCnvSrn2LocalVoucher.setBounds(new Rectangle(273, 144, 255, 31));
    btnCnvSrn2LocalVoucher.setFont(new java.awt.Font("Dialog", 1, 11));
    btnCnvSrn2LocalVoucher.setText("Convert SRN To Local Voucher");
    btnCnvSrn2LocalVoucher.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnCnvSrn2LocalVoucher_actionPerformed(e);
      }
    });
    btnListLocalVoucher.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnListLocalVoucher_actionPerformed(e);
      }
    });
    btnListLocalVoucher.setText("QUERY LOCAL VOUCHER");
    btnListLocalVoucher.setFont(new java.awt.Font("Dialog", 1, 11));
    btnListLocalVoucher.setBounds(new Rectangle(273, 195, 255, 31));
    btnListLocalVoucher.setBackground(Color.white);
    btnCnv2F107.setBackground(Color.white);
    btnCnv2F107.setBounds(new Rectangle(273, 425, 255, 31));
    btnCnv2F107.setFont(new java.awt.Font("Dialog", 1, 11));
    btnCnv2F107.setText("SRN CONVERT TO NetTerm F107");
    btnCnv2F107.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnCnv2F107_actionPerformed(e);
      }
    });
    btnSrnHeadBasicMtn.setBackground(Color.white);
    btnSrnHeadBasicMtn.setBounds(new Rectangle(273, 246, 255, 31));
    btnSrnHeadBasicMtn.setFont(new java.awt.Font("Dialog", 1, 11));
    btnSrnHeadBasicMtn.setText("SRN HEAD BASIC FIELD");
    btnSrnHeadBasicMtn.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnSrnHeadBasicMtn_actionPerformed(e);
      }
    });
    btnDeductMaintain.setBackground(Color.white);
    btnDeductMaintain.setBounds(new Rectangle(273, 245, 255, 31));
    btnDeductMaintain.setFont(new java.awt.Font("Dialog", 1, 11));
    btnDeductMaintain.setText("DEDUCT MAINTENANCE");
    btnDeductMaintain.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnDeductMaintain_actionPerformed(e);
      }
    });
    btnLvBalance.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnLvBalance_actionPerformed(e);
      }
    });
    btnLvBalance.setText("LOCAL VOUCHER BALANCE LIST");
    btnLvBalance.setFont(new java.awt.Font("Dialog", 1, 11));
    btnLvBalance.setBounds(new Rectangle(273, 295, 255, 31));
    btnLvBalance.setBackground(Color.white);
    btnLDbntDdtList.setBackground(Color.white);
    btnLDbntDdtList.setBounds(new Rectangle(273, 350, 255, 31));
    btnLDbntDdtList.setFont(new java.awt.Font("Dialog", 1, 11));
    btnLDbntDdtList.setText("DEBIT NOTE DEDUCT LIST");
    btnLDbntDdtList.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnLDbntDdtList_actionPerformed(e);
      }
    });
    this.add(blueBkgWhiteCharLabel1, null);
    this.add(btnExit, null);
    this.add(btnCnvSrn2LocalVoucher, null);
    this.add(btnMakerInfor, null);
    this.add(btnListLocalVoucher, null);
    this.add(btnCnv2F107, null);
    this.add(btnDeductMaintain, null);
    this.add(btnLvBalance, null);
    this.add(btnLDbntDdtList, null);
    //this.add(btnSrnHeadBasicMtn, null);
  }

  void btnExit_actionPerformed(ActionEvent e) {
    try{
      processhandler.template.Properties.getCenteralControler().goBack();
    }catch(Exception exp){
      exp.printStackTrace();
    }

  }

  void btnMakerInfor_actionPerformed(ActionEvent e) {
    try{
      processhandler.template.Properties.getCenteralControler().doCommandExecute(
       new TgrMkrInforMaintain()
      );
    }catch(Exception exp){
      exp.printStackTrace();
    }

  }

  void btnCnvSrn2LocalVoucher_actionPerformed(ActionEvent e) {
    try{
      processhandler.template.Properties.getCenteralControler().doCommandExecute(
       new TgrCnvSrn2LocalVoucher()
      );
    }catch(Exception exp){
      exp.printStackTrace();
    }

  }
  void btnListLocalVoucher_actionPerformed(ActionEvent e) {
    try{
      TgrListLocalVoucher.pnl=null;
      processhandler.template.Properties.getCenteralControler().doCommandExecute(
       new TgrListLocalVoucher()
      );
    }catch(Exception exp){
      exp.printStackTrace();
    }

  }


  public class JDlgTmp extends JDialog {
    JPanel panel1 = new JPanel();
    String  yyyymm;
    JButton btnGo = new JButton();
    JButton btnExit = new JButton();
    WhiteBkgBlueCharLabel whiteBkgBlueCharLabel1 = new WhiteBkgBlueCharLabel();
    JTextField txtYYYYMM = new JTextField();
    java.text.DateFormat df=new java.text.SimpleDateFormat("yyyyMM");
    int y_off=-20;
    public JDlgTmp(Frame frame, String title, boolean modal) {
      super(frame, title, modal);
      try {
        jbInit();
        pack();
      }
      catch(Exception ex) {
        ex.printStackTrace();
      }
    }

    public JDlgTmp() {
      this(null, "", false);
    }

    private void jbInit() throws Exception {
      panel1.setLayout(null);
      btnGo.setBounds(new Rectangle(84, 117+y_off, 118, 30));
      btnGo.setFont(new java.awt.Font("Dialog", 1, 11));
      btnGo.setText("GET FILE");
      btnGo.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(ActionEvent e) {
          btnGo_actionPerformed(e);
        }
      });
      btnExit.setBounds(new Rectangle(266, 117+y_off, 85, 30));
      btnExit.setFont(new java.awt.Font("Dialog", 1, 11));
      btnExit.setText("EXIT");
      btnExit.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(ActionEvent e) {
          btnExit_actionPerformed(e);
        }
      });
      whiteBkgBlueCharLabel1.setText("INPUT ETD DATE(YYYYMM):");
      whiteBkgBlueCharLabel1.setBounds(new Rectangle(29, 62+y_off, 187, 25));
      txtYYYYMM.setText("");
      txtYYYYMM.setBounds(new Rectangle(219, 62+y_off, 144, 25));
      this.setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
      getContentPane().add(panel1);
      panel1.add(btnGo, null);
      panel1.add(btnExit, null);
      panel1.add(whiteBkgBlueCharLabel1, null);
      panel1.add(txtYYYYMM, null);
    }

    void btnGo_actionPerformed(ActionEvent e) {
     if(txtYYYYMM.getText().trim().length()!=6){
       exgui.verification.VerifyLib.showAlert("Date Format Should be YYYYMM",
                                              "Date Format Should be YYYYMM");
       return;
     }

     try{
         Object obj=df.parse(txtYYYYMM.getText().trim());
         yyyymm=txtYYYYMM.getText().trim();
         dispose();
     }catch(Exception exp){
       exp.printStackTrace();
       exgui.verification.VerifyLib.showAlert("Date Format Should be YYYYMM",
                                              "Date Format Should be YYYYMM");
       return;

     }
    }

    void btnExit_actionPerformed(ActionEvent e) {
       yyyymm=null;
       dispose();
    }
  }


  void btnCnv2F107_actionPerformed(ActionEvent e) {
    JDlgTmp dlg=new JDlgTmp(util.PublicVariable.APP_FRAME,
                         "INPUT ETD YYYYMM TO GENERATE 107 FORM",
                         true);
    dlg.setSize(400,160);
    exgui.UIHelper.setToScreenCenter(dlg);
    dlg.show();
    if(dlg.yyyymm==null)return;

    try{
      util.MiscFunc.showProcessingMessage();
      newtimesejb.debitNote.DebitNoteFacdeHome ejbHome=
          (newtimesejb.debitNote.DebitNoteFacdeHome)
          info_ejb.WeblogicServiceLocator.locateServiceHome(util.PublicVariable.SERVER_URL,
          "newtimesejb.debitNote.DebitNoteFacde");
      newtimesejb.debitNote.DebitNoteFacde ejb=ejbHome.create();
      byte data2file[]=ejb.conv2NetTermF107(dlg.yyyymm);
      java.io.File f=new java.io.File("c:\\f107.txt");
      if(f.exists())f.delete();
      f.createNewFile();
      java.io.FileOutputStream fo=new java.io.FileOutputStream(f);
      fo.write(data2file);
      fo.flush();
      fo.close();
      exgui.verification.VerifyLib.showPlanMsg("FILE : C:\\F107.txt Generated",
                                               "FILE : C:\\F107.txt Generated");
    }catch(Exception exp){
      exp.printStackTrace();
      util.ExceptionLog.exp2File(exp,"");
      exgui.verification.VerifyLib.showAlert("Server Side Error,Please Contact System Manager",
                                             "Server Side Error");
    }finally{
      util.MiscFunc.hideProcessingMessage();
    }
  }
  void btnSrnHeadBasicMtn_actionPerformed(ActionEvent e) {
    try{
      processhandler.template.Properties.getCenteralControler().doCommandExecute(
       new newtimes.accounting.local_voucher.TgrSrnHeadBasicFields()
      );
    }catch(Exception exp){
      exp.printStackTrace();
    }

  }
  void btnDeductMaintain_actionPerformed(ActionEvent e) {
    try{
      processhandler.template.Properties.getCenteralControler().doCommandExecute(
       new newtimes.accounting.local_voucher.TgrQryLvDDK()
      );
    }catch(Exception exp){
      exp.printStackTrace();
    }

  }
  void btnLvBalance_actionPerformed(ActionEvent e) {
    try{
      processhandler.template.Properties.getCenteralControler().doCommandExecute(
       new newtimes.accounting.local_voucher.TgrRptLvBalanaceList()
      );
    }catch(Exception exp){
      exp.printStackTrace();
    }

  }
  void btnLDbntDdtList_actionPerformed(ActionEvent e) {
    try{
      processhandler.template.Properties.getCenteralControler().doCommandExecute(
       new newtimes.accounting.local_voucher.TgrRptDbntDdtList()
      );
    }catch(Exception exp){
      exp.printStackTrace();
    }

  }
}
