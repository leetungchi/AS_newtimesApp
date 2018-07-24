package newtimes.offshoredebitnote;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import exgui.*;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class PnlFuncList extends JPanel {
  JButton btnDep = new JButton();
  JButton btnEditCountry = new JButton();
  JButton btnQryDbtDtl = new JButton();
  JButton btnExit = new JButton();
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel1 = new BlueBkgWhiteCharLabel();
  JButton btnRptDbtDtl = new JButton();

  public PnlFuncList() {
    try {
      jbInit();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }

  void jbInit() throws Exception {
    btnDep.setBackground(Color.white);
    btnDep.setBounds(new Rectangle(191, 88, 408, 34));
    btnDep.setFont(new java.awt.Font("Dialog", 1, 11));
    btnDep.setText("EDIT DEPARTMENT");
    btnDep.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnDep_actionPerformed(e);
      }
    });
    this.setBackground(new Color(202, 202, 224));
    this.setLayout(null);
    btnEditCountry.setText("EDIT COUNTRY");
    btnEditCountry.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnEditCountry_actionPerformed(e);
      }
    });
    btnEditCountry.setBounds(new Rectangle(191, 152, 408, 34));
    btnEditCountry.setBackground(Color.white);
    btnEditCountry.setFont(new java.awt.Font("Dialog", 1, 11));
    btnQryDbtDtl.setText("OFFSHORE DEBIT NOTE");
    btnQryDbtDtl.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnQryDbtDtl_actionPerformed(e);
      }
    });
    btnQryDbtDtl.setBounds(new Rectangle(191, 215, 408, 34));
    btnQryDbtDtl.setBackground(Color.white);
    btnQryDbtDtl.setFont(new java.awt.Font("Dialog", 1, 11));
    btnExit.setBounds(new Rectangle(357, 461, 87, 26));
    btnExit.setFont(new java.awt.Font("Dialog", 1, 11));
    btnExit.setText("EXIT");
    btnExit.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnExit_actionPerformed(e);
      }
    });
    blueBkgWhiteCharLabel1.setText("TAIPE OFFICE OFFSHORE DEBIT NOTE FUNCTION");
    blueBkgWhiteCharLabel1.setBounds(new Rectangle(-1, 22, 797, 26));
    btnRptDbtDtl.setFont(new java.awt.Font("Dialog", 1, 11));
    btnRptDbtDtl.setBackground(Color.white);
    btnRptDbtDtl.setBounds(new Rectangle(191, 279, 408, 34));
    btnRptDbtDtl.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnRptDbtDtl_actionPerformed(e);
      }
    });
    btnRptDbtDtl.setText("OFFSHORE DEBIT NOTE DETAIL REPORT");
    this.add(btnExit, null);
    this.add(blueBkgWhiteCharLabel1, null);
    this.add(btnDep, null);
    this.add(btnQryDbtDtl, null);
    this.add(btnEditCountry, null);
    this.add(btnRptDbtDtl, null);
  }

  void btnExit_actionPerformed(ActionEvent e) {
    try{
      processhandler.template.Properties.getCenteralControler().
          setDataProcesser(null);
      processhandler.template.Properties.getCenteralControler().goBack();
    }catch(Exception exp){
      exp.printStackTrace();
    }

  }

  void btnDep_actionPerformed(ActionEvent e) {
     DlgBatchDepPnl dlg=new DlgBatchDepPnl(
         util.PublicVariable.APP_FRAME,
        "EDIT DEPARTMENTS",true);
       dlg.setSize(275,360);
       exgui.UIHelper.setToScreenCenter(dlg);
       dlg.show();

  }

  void btnEditCountry_actionPerformed(ActionEvent e) {
    try{
      processhandler.template.Properties.getCenteralControler().
          setDataProcesser(null);
      processhandler.template.Properties.getCenteralControler().doCommandExecute(
      new TgrEditCountries());
    }catch(Exception exp){
      exp.printStackTrace();
    }


  }

  void btnQryDbtDtl_actionPerformed(ActionEvent e) {
    try{
      processhandler.template.Properties.getCenteralControler().
          setDataProcesser(null);
      processhandler.template.Properties.getCenteralControler().doCommandExecute(
      new TgrQryOffshoreDebitNote());
    }catch(Exception exp){
      exp.printStackTrace();
    }


  }
  void btnRptDbtDtl_actionPerformed(ActionEvent e) {
    try{
      processhandler.template.Properties.getCenteralControler().
          setDataProcesser(null);
      processhandler.template.Properties.getCenteralControler().doCommandExecute(
      new TgrRptOffShoreDrCrDtl());
    }catch(Exception exp){
      exp.printStackTrace();
    }

  }
}
