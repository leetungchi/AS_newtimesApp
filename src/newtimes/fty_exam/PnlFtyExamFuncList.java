package newtimes.fty_exam;

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

public class PnlFtyExamFuncList extends JPanel {
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel1 = new BlueBkgWhiteCharLabel();
  JButton btnEmailMaintain = new JButton();
  JButton btnFtyExamHistory = new JButton();
  JButton btnExit = new JButton();

  public PnlFtyExamFuncList() {
    try {
      jbInit();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }

  void jbInit() throws Exception {
    blueBkgWhiteCharLabel1.setFont(new java.awt.Font("Dialog", 0, 16));
    blueBkgWhiteCharLabel1.setText("Åç¼tºûÅ@³æ¤¸");
    blueBkgWhiteCharLabel1.setBounds(new Rectangle(0, 12, 799, 37));
    this.setLayout(null);
    btnEmailMaintain.setBounds(new Rectangle(172, 79, 455, 37));
    btnEmailMaintain.setFont(new java.awt.Font("Dialog", 1, 12));
    btnEmailMaintain.setText("EMAIL MAINTAIN");
    btnEmailMaintain.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnEmailMaintain_actionPerformed(e);
      }
    });
    this.setBackground(new Color(202, 202, 224));
    this.setFont(new java.awt.Font("Dialog", 1, 12));
    btnFtyExamHistory.setText("FTY-EXAM HISTORY");
    btnFtyExamHistory.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnFtyExamHistory_actionPerformed(e);
      }
    });
    btnFtyExamHistory.setFont(new java.awt.Font("Dialog", 1, 12));
    btnFtyExamHistory.setBounds(new Rectangle(172, 141, 455, 37));
    btnExit.setText("EXIT");
    btnExit.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnExit_actionPerformed(e);
      }
    });
    btnExit.setFont(new java.awt.Font("Dialog", 1, 12));
    btnExit.setBounds(new Rectangle(322, 513, 155, 37));
    this.add(blueBkgWhiteCharLabel1, null);
    this.add(btnEmailMaintain, null);
    this.add(btnFtyExamHistory, null);
    this.add(btnExit, null);
  }

  void btnExit_actionPerformed(ActionEvent e) {
    try{
      processhandler.template.Properties.getCenteralControler().goBack();
    }catch(Exception exp){
      exp.printStackTrace();
    }

  }

  void btnEmailMaintain_actionPerformed(ActionEvent e) {
    DlgListFtyExamEmail dlg=new DlgListFtyExamEmail(util.PublicVariable.APP_FRAME,"BUYER NAME & Address",true);
    dlg.setSize(860,485);
    exgui.UIHelper.setToScreenCenter(dlg);
    dlg.show();

  }

  void btnFtyExamHistory_actionPerformed(ActionEvent e) {
     try{
           java.util.Vector vctBuyerlist=
              exgui2.CONST.BASIC_MAIN_EJB.getDatas(
                    util.PublicVariable.USER_RECORD,
                    "select trim(to_char(seq,'99999')) as seq,BUYER_NAME from FTY_EXAM_EMAIL where record_delete_flag='1'",
                    1,9999
              );
            if(vctBuyerlist.size()==0){
              exgui.verification.VerifyLib.showAlert("Please Define Buyer & Email List Firstly",
                                                     "Please Define Buyer & Email List Firstly");
              return;
            }
            Constants.vctBuyer=vctBuyerlist;
            processhandler.template.Properties.getCenteralControler().doCommandExecute(
            new TgrQryExamHistory());

     }catch(Exception exp){
       exp.printStackTrace();
     }
  }
}
