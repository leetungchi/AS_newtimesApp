package newtimes.production.report;

import java.awt.*;
import exgui.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import exgui.*;
import javax.swing.*;
import newtimes.production.report.AbsQryPanel;
import java.util.*;
import exgui.verification.CellFormat;
import database.datatype.Record;
import exgui.ultratable.CellTxtEditorFormat;
import java.awt.event.*;
import newtimes.preproduction.guis.*;
import newtimes.preproduction.buyermakerselect.*;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class PnlListMaker
    extends AbsQryPanel {
    //extends JPanel {
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel1 = new BlueBkgWhiteCharLabel();
  JLabel blueBkgWhiteCharLabel3 = new JLabel();
  JComboBox cbxCntr = new JComboBox();
  JComboBox cbxOfsCenter = new JComboBox();
  JLabel blueBkgWhiteCharLabel4 = new JLabel();
  JButton btnQry = new JButton();
  exgui.DataBindJCombobox DbJcbxcbxCntr;
  public PnlListMaker() {
    try {
      jbInit();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }

public  void jbInit() throws Exception {
    blueBkgWhiteCharLabel1.setText("MAKER LIST");
    blueBkgWhiteCharLabel1.setBounds(new Rectangle(-1, 20, 803, 28));
    this.setMaximumSize(new Dimension(2147483647, 2147483647));
    this.setLayout(null);
    blueBkgWhiteCharLabel3.setBounds(new Rectangle(9, 59, 60, 19));
    blueBkgWhiteCharLabel3.setFont(new java.awt.Font("Dialog", 1, 11));
    blueBkgWhiteCharLabel3.setText("Center");
    cbxCntr.setBounds(new Rectangle(66, 59, 130, 22));
    cbxOfsCenter.setBounds(new Rectangle(325, 59, 130, 22));
    blueBkgWhiteCharLabel4.setText("Off Shore Center");
    blueBkgWhiteCharLabel4.setFont(new java.awt.Font("Dialog", 1, 11));
    blueBkgWhiteCharLabel4.setBounds(new Rectangle(219, 59, 107, 19));
    btnQry.setText("REPORT");
    btnQry.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnQry_actionPerformed(e);
      }
    });
    btnQry.setFocusPainted(true);
    btnQry.setFont(new java.awt.Font("Dialog", 1, 11));
    btnQry.setBounds(new Rectangle(695, 59, 89, 25));
    this.add(blueBkgWhiteCharLabel1, null);
    this.add(blueBkgWhiteCharLabel3, null);
    this.add(cbxCntr, null);
    this.add(cbxOfsCenter, null);
    this.add(blueBkgWhiteCharLabel4, null);
    this.add(btnQry, null);
    super.reportName="LIST_MAKER.rpt";
    genDataBindObj();
  }
  public void genDataBindObj(){
    dataBindComps.clear();
    try {
      if (tempProperties.tmpCenters.size() > 1) {
        DbJcbxcbxCntr =
            new exgui.DataBindJCombobox(
            cbxCntr, "CENTER",
            tempProperties.tmpCenters,
            "CEN_NAME", "CEN_CODE",
            (String)util.PublicVariable.USER_RECORD.get("usr_cen_code"));
        dataBindComps.add(DbJcbxcbxCntr);
      } else {
        DbJcbxcbxCntr =
            new exgui.DataBindJCombobox(
            cbxCntr, "CENTER",
            tempProperties.tmpCenters,
            "CEN_NAME", "CEN_CODE",
            (String)util.PublicVariable.USER_RECORD.get("usr_cen_code"));
        dataBindComps.add(DbJcbxcbxCntr);
      }

      exgui.DataBindJCombobox offshore=new exgui.DataBindJCombobox(
         cbxOfsCenter, "OFF_CENTER",
         tempProperties.tmpOffShores,
         "CEN_NAME", "CEN_CODE",
         "003");

      dataBindComps.add(offshore);
    }catch(Exception exp){
        exp.printStackTrace();
    }
  }

  void btnQry_actionPerformed(ActionEvent e) {
     super.JButtonQueryButtonAction(null);
  }
}
