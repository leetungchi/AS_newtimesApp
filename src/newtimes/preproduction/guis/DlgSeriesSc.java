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

public class DlgSeriesSc extends JDialog {
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel1 = new BlueBkgWhiteCharLabel();
  JLabel jLabel1 = new JLabel();
  JTextField txtCount = new JTextField();
  JLabel jLabel2 = new JLabel();
  JButton btnOk = new JButton();
  JButton btnCancel = new JButton();
   exgui.DataBindTextWithChecker dbTxt2chk=null;//,dbTxtSubGrp;
   exgui.DataBindJCombobox dbCbxHKSubGrp=null;
  JLabel lblSubGroup = new JLabel();
  JComboBox cbxHKSubGrp = new JComboBox();
  Object objOrgSubGrpValue=null;
  public DlgSeriesSc(Frame frame, String title, boolean modal,String orgSubGrpCode) {
    super(frame, title, modal);
    objOrgSubGrpValue=orgSubGrpCode;
    try {
      jbInit();
      pack();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }

  public DlgSeriesSc() {
    this(null, "", false,null);
  }

  private void jbInit() throws Exception {
    blueBkgWhiteCharLabel1.setText("Get Series S/C#");
    blueBkgWhiteCharLabel1.setBounds(new Rectangle(-1, 0, 404, 28));
    this.getContentPane().setLayout(null);
    this.setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
    jLabel1.setFont(new java.awt.Font("Dialog", 1, 11));
    jLabel1.setText("Please Input The Counts Of S/C# To Generate");
    jLabel1.setBounds(new Rectangle(42, 59, 251, 27));
    txtCount.setText("1");
    txtCount.setBounds(new Rectangle(42, 110, 126, 24));
    jLabel2.setFont(new java.awt.Font("Dialog", 1, 11));
    jLabel2.setForeground(Color.red);
    jLabel2.setText("MAXIMUM : 20");
    jLabel2.setBounds(new Rectangle(42, 80, 183, 24));
    btnOk.setBounds(new Rectangle(41, 150, 127, 26));
    btnOk.setFont(new java.awt.Font("Dialog", 1, 11));
    btnOk.setText("OK");
    btnOk.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnOk_actionPerformed(e);
      }
    });
    btnCancel.setBounds(new Rectangle(251, 150, 127, 26));
    btnCancel.setFont(new java.awt.Font("Dialog", 1, 11));
    btnCancel.setText("CANCEL");
    btnCancel.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnCancel_actionPerformed(e);
      }
    });
    lblSubGroup.setFont(new java.awt.Font("Dialog", 1, 11));
    lblSubGroup.setText("SUB-GROUP CODE");
    lblSubGroup.setBounds(new Rectangle(201, 82, 125, 20));
    cbxHKSubGrp.setBounds(new Rectangle(201, 110, 183, 24));
    this.getContentPane().add(blueBkgWhiteCharLabel1, null);
    this.getContentPane().add(jLabel1, null);
    this.getContentPane().add(txtCount, null);
    this.getContentPane().add(jLabel2, null);
    this.getContentPane().add(btnOk, null);
    this.getContentPane().add(btnCancel, null);
    this.getContentPane().add(lblSubGroup, null);
    this.getContentPane().add(cbxHKSubGrp, null);
    Object objInt=exgui.verification.CellFormat.getIntVerifierAllowNull(2);
   dbTxt2chk=
      new DataBindTextWithChecker(txtCount,
                                    null,
                                    new Integer(0),
                                    2,
                                    (exgui.Object2String)objInt,
                                    (exgui.ultratable.CellTxtEditorFormat)objInt
                                    );
    //Object obj2txt=exgui.verification.CellFormat.getOrdinaryFieldNotAllowNull(2);

    dbCbxHKSubGrp=new exgui.DataBindJCombobox(cbxHKSubGrp,
                                  "PRODUCTION_HK_SUBGRP",
                                  newtimes.preproduction.guis.tempProperties.tmpHkSubGrp,
                                  "GRP_MNG","GRP_CODE",
                                  objOrgSubGrpValue,"",null);

    /*
   dbTxtSubGrp=
      new DataBindTextWithChecker(txtSubGrpCode,
                                    null,
                                    null,
                                    2,
                                    (exgui.Object2String)obj2txt,
                                    (exgui.ultratable.CellTxtEditorFormat)obj2txt
                                    );*/


  }

  void btnCancel_actionPerformed(ActionEvent e) {
    txtCount.setText("0");
    this.dispose();
  }

  void btnOk_actionPerformed(ActionEvent e) {
    if(dbCbxHKSubGrp.getSelectedValue()==null){
      exgui.verification.VerifyLib.showAlert("Please Assigne Sub-Group",
                                             "Please Assigne Sub-Group");
      dbCbxHKSubGrp.grabFocus();
      return;
    }
    /*
    if(txtSubGrpCode.getText().trim().length() ==0){
      exgui.verification.VerifyLib.showAlert("Please Input Sub-Group Code,At least One Character",
                                             "Please Assigne Sub-Group Code");
      txtSubGrpCode.grabFocus();
      return;
    }*/

    if(dbTxt2chk.getSelectedValue()!=null){
      if(Integer.parseInt(dbTxt2chk.getSelectedValue().toString())>20){
        exgui.verification.VerifyLib.showAlert(
        "Number Can Not Over than \"20\"",
        "Number Can Not Over than \"20\"");
          txtCount.grabFocus();
          txtCount.selectAll();
          return;
      }
      if(Integer.parseInt(dbTxt2chk.getSelectedValue().toString())<0){
        exgui.verification.VerifyLib.showAlert(
        "Number Can Not Be Negtive",
        "Number Can Not Be Negtive");
        txtCount.grabFocus();
        txtCount.selectAll();
          return;
      }
    }
    this.dispose();
  }
}
