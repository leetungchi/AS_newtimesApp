package newtimes.accounting.local_voucher;

import java.awt.*;
import exgui.*;
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

public class PnlSrnBasicFieldQry extends JPanel {
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel1 = new BlueBkgWhiteCharLabel();
  JLabel jLabel1 = new JLabel();
  JTextField txtSRN = new JTextField();
  JButton btnQry = new JButton();
  JButton btnExit = new JButton();

  public PnlSrnBasicFieldQry() {
    try {
      jbInit();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }

  void jbInit() throws Exception {
    blueBkgWhiteCharLabel1.setText("SRN HEAD BASIC FIELD");
    blueBkgWhiteCharLabel1.setBounds(new Rectangle(-1, 111, 801, 33));
    this.setBackground(new Color(202, 202, 224));
    this.setLayout(null);
    jLabel1.setFont(new java.awt.Font("Dialog", 1, 11));
    jLabel1.setText("SRN:");
    jLabel1.setBounds(new Rectangle(219, 209, 52, 32));
    txtSRN.setText("");
    txtSRN.setBounds(new Rectangle(276, 209, 227, 25));
    btnQry.setBounds(new Rectangle(520, 209, 90, 25));
    btnQry.setFont(new java.awt.Font("Dialog", 1, 11));
    btnQry.setText("QUERY");
    btnQry.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnQry_actionPerformed(e);
      }
    });
    btnExit.setBounds(new Rectangle(326, 511, 149, 34));
    btnExit.setFont(new java.awt.Font("Dialog", 1, 11));
    btnExit.setText("EXIT");
    btnExit.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnExit_actionPerformed(e);
      }
    });
    this.add(blueBkgWhiteCharLabel1, null);
    this.add(jLabel1, null);
    this.add(txtSRN, null);
    this.add(btnQry, null);
    this.add(btnExit, null);
  }

  void btnExit_actionPerformed(ActionEvent e) {
    try{
      processhandler.template.Properties.getCenteralControler().goBack();
    }catch(Exception exp){
      exp.printStackTrace();
    }

  }

  void btnQry_actionPerformed(ActionEvent e) {
     String srn=txtSRN.getText().trim();
     if(srn.equals(""))return;
     database.datatype.Record recShipHead=null;
     try{
       util.MiscFunc.showProcessingMessage();
       newtimesejb.debitNote.LocalVoucherFacadeHome ejbHome=
           (newtimesejb.debitNote.LocalVoucherFacadeHome)
           info_ejb.WeblogicServiceLocator.locateServiceHome(util.PublicVariable.SERVER_URL,
           "newtimesejb.debitNote.LocalVoucherFacade");
       newtimesejb.debitNote.LocalVoucherFacade ejb=ejbHome.create();
       recShipHead=ejb.getShipHead4BasicFields(srn);
       if(recShipHead==null){
         exgui.verification.VerifyLib.showAlert("SRN NOT EXISTS","SRN NOT EXISTS");
         return ;
       }

     }catch(Exception exp){
       exp.printStackTrace();
       util.ExceptionLog.exp2File(exp,"");
       exgui.verification.VerifyLib.showAlert("ERR WHILE GET SHIPMENT DATA\nPlease Contact System Manager",
                                              "SERVER CONNECTION ERROR");

     }finally{
       util.MiscFunc.hideProcessingMessage();
     }
     DlgSrnHeadBasicFields dlg=new DlgSrnHeadBasicFields(util.PublicVariable.APP_FRAME,"SRN HEAD FIELDS",true,recShipHead);
     dlg.setSize(526,495);
     dlg.show();
  }
}
