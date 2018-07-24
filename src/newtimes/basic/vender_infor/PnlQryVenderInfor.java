package newtimes.basic.vender_infor;

import java.awt.*;
import exgui.*;
import javax.swing.*;
import newtimes.preproduction.buyermakerselect.*;
import java.awt.event.*;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class PnlQryVenderInfor extends JPanel {
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel1 = new BlueBkgWhiteCharLabel();
  WhiteBkgBlueCharLabel whiteBkgBlueCharLabel1 = new WhiteBkgBlueCharLabel();
  SelectBuyerMaker slkVender = new SelectBuyerMaker();
  JButton btnQuery = new JButton();
  JButton btnExit = new JButton();
  JButton btnAddNew = new JButton();

  public PnlQryVenderInfor() {
    try {
      jbInit();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }

  void jbInit() throws Exception {
    blueBkgWhiteCharLabel1.setText("QUERY VENDOR BANK");
    blueBkgWhiteCharLabel1.setBounds(new Rectangle(-1, 26, 803, 37));
    this.setLayout(null);
    whiteBkgBlueCharLabel1.setText("VENDOR");
    whiteBkgBlueCharLabel1.setBounds(new Rectangle(267, 125, 114, 31));
    slkVender.setBounds(new Rectangle(380, 125, 205, 31));
    btnQuery.setBounds(new Rectangle(207, 480, 106, 33));
    btnQuery.setFont(new java.awt.Font("Dialog", 1, 11));
    btnQuery.setText("EXTRACT");
    btnQuery.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnQuery_actionPerformed(e);
      }
    });
    btnExit.setText("EXIT");
    btnExit.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnExit_actionPerformed(e);
      }
    });
    btnExit.setBounds(new Rectangle(592, 480, 106, 33));
    btnExit.setFont(new java.awt.Font("Dialog", 1, 11));
    this.setBackground(new Color(204, 204, 225));
    btnAddNew.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnAddNew_actionPerformed(e);
      }
    });
    btnAddNew.setText("ADD NEW");
    btnAddNew.setFont(new java.awt.Font("Dialog", 1, 11));
    btnAddNew.setBounds(new Rectangle(400, 480, 106, 33));
    this.add(blueBkgWhiteCharLabel1, null);
    this.add(whiteBkgBlueCharLabel1, null);
    this.add(slkVender, null);
    this.add(btnQuery, null);
    this.add(btnExit, null);
    this.add(btnAddNew, null);
    slkVender.init("",null,slkVender.TYPE_VENDOR,true);
  }

  void btnQuery_actionPerformed(ActionEvent e) {
    if(null==slkVender.getSelectedValue())
       ToAXN.vender_seq=-1;
     else
       ToAXN.vender_seq=Integer.parseInt(slkVender.getSelectedValue().toString());

    ToAXN.ShowListGUI();
  }

  void btnExit_actionPerformed(ActionEvent e) {
    ToAXN.Exit2BasiIIFunc();
  }
  void btnAddNew_actionPerformed(ActionEvent e) {
    DlgNewVender dlg=new DlgNewVender(util.PublicVariable.APP_FRAME,"Add New Vendor Bank",true);
    dlg.setSize(510,490);
    exgui.UIHelper.setToScreenCenter(dlg);
    dlg.show();
  }
}
