package newtimes.production.report;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import exgui.*;
import java.util.*;
import javax.swing.border.*;
import newtimes.preproduction.guis.*;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class PnlFabAccCommRpt
    //extends JPanel {
    extends AbsQryPanel{
  JTextField txtDateEnd = new JTextField();
  JLabel jLabel2 = new JLabel();
  JPanel pnlDuriation = new JPanel();
  JLabel blueBkgWhiteCharLabel3 = new JLabel();
  JLabel jLabel1 = new JLabel();
  JLabel jLabel3 = new JLabel();
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel1 = new BlueBkgWhiteCharLabel();
  JComboBox cbxCntr = new JComboBox();
  JButton btnQry = new JButton();
  JComboBox cbxDep = new JComboBox();
  JTextField txtDateBgn = new JTextField();
  exgui.DataBindJCombobox DbJcbxcbxCntr;
   DataBindJCombobox dbCbxDep;
   protected   DataBindTextWithChecker dbTxtDateBgn,dbTxtDateEnd;
   boolean doingDB2Gui=false;

  public PnlFabAccCommRpt() {
    try {
      //jbInit();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }

 public void jbInit() throws Exception {
    titledBorder1 = new TitledBorder(BorderFactory.createEtchedBorder(Color.white,new Color(141, 141, 156)),"ON BOARD DATE");
    pnlDuriation.setLayout(null);
    pnlDuriation.setBounds(new Rectangle(190, 45, 286, 53));
    pnlDuriation.setBackground(new Color(202, 202, 224));
    pnlDuriation.setBorder(titledBorder1);
    jLabel2.setBounds(new Rectangle(8, 19, 56, 21));
    jLabel2.setText("FROM:");
    txtDateEnd.setBounds(new Rectangle(187, 19, 87, 22));
    txtDateEnd.setText("");
    this.setLayout(null);
    blueBkgWhiteCharLabel3.setBounds(new Rectangle(10, 43, 60, 19));
    blueBkgWhiteCharLabel3.setText("Center");
    jLabel1.setText("DEP.");
    jLabel1.setBounds(new Rectangle(10, 74, 47, 21));
    jLabel3.setText("TO:");
    jLabel3.setBounds(new Rectangle(154, 19, 36, 24));
    blueBkgWhiteCharLabel1.setText("FAB & ACCESSORIES COMM LIST");
    blueBkgWhiteCharLabel1.setBounds(new Rectangle(0, 10, 803, 28));
    cbxCntr.addItemListener(new cbxCenterItemChanged());
    cbxCntr.setBounds(new Rectangle(54, 45, 130, 22));
    btnQry.setBounds(new Rectangle(693, 56, 80, 27));
    btnQry.setFont(new java.awt.Font("Dialog", 1, 11));
    btnQry.setText("REPORT");
    btnQry.addActionListener(new PnlFabAccCommRpt_btnQry_actionAdapter(this));
    cbxDep.setBounds(new Rectangle(53, 77, 130, 22));
    txtDateBgn.setText("");
    txtDateBgn.setBounds(new Rectangle(52, 19, 87, 20));
    this.setBackground(new Color(202, 202, 224));
    pnlDuriation.add(jLabel2, null);
    pnlDuriation.add(txtDateBgn, null);
    pnlDuriation.add(txtDateEnd, null);
    pnlDuriation.add(jLabel3, null);
    this.add(blueBkgWhiteCharLabel3, null);
    this.add(jLabel1, null);
    this.add(blueBkgWhiteCharLabel1, null);
    this.add(cbxCntr, null);
    this.add(btnQry, null);
    this.add(cbxDep, null);
    this.add(pnlDuriation, null);
    genDataBindObj();
    reportName="FAB_LIST_MIS.RPT";
}
public void genDataBindObj() {
  doingDB2Gui=true;
  dataBindComps.clear();
  try{
    if (tempProperties.tmpCenters.size() > 1) {
      DbJcbxcbxCntr =
          new exgui.DataBindJCombobox(
          cbxCntr, "P_CENTER",
          tempProperties.tmpCenters,
          "CEN_NAME", "CEN_CODE",
          (String)util.PublicVariable.USER_RECORD.get("usr_cen_code"), "'ALL'", null);
      dataBindComps.add(DbJcbxcbxCntr);
    } else {
      DbJcbxcbxCntr =
          new exgui.DataBindJCombobox(
          cbxCntr, "P_CENTER",
          tempProperties.tmpCenters,
          "CEN_NAME", "CEN_CODE",
          (String)util.PublicVariable.USER_RECORD.get("usr_cen_code"));
      dataBindComps.add(DbJcbxcbxCntr);
    }

    //default begin datae is first day of current mount
    java.util.Calendar cld=java.util.Calendar.getInstance();
    cld.set(cld.DATE,1);
    java.util.Date dFrom=cld.getTime();
    cld.set(cld.DATE,cld.getActualMaximum(cld.DAY_OF_MONTH));
    java.util.Date dEnd=cld.getTime();
    //default end date is end day of currecnt mount

    Object dateVfy = exgui.verification.CellFormat.getDateStringFormaterAllowNull();
    dbTxtDateBgn =
        new exgui.DataBindTextWithChecker(txtDateBgn, "P_DEL_BE", dFrom,
                                          10, (exgui.Object2String)dateVfy,
                                          (exgui.ultratable.
                                           CellTxtEditorFormat)dateVfy);
    dataBindComps.add(dbTxtDateBgn);

    dbTxtDateEnd =
        new exgui.DataBindTextWithChecker(txtDateEnd, "P_DEL_EN", dEnd,
                                          10, (exgui.Object2String)dateVfy,
                                          (exgui.ultratable.
                                           CellTxtEditorFormat)dateVfy);
    dataBindComps.add(dbTxtDateEnd);

    doingDB2Gui=false;
    cbxCntr.getItemListeners()[0].itemStateChanged(null);
  }catch(Exception exp){
    exp.printStackTrace();
  }
}
public HashMap composeParameters() {
  HashMap hm = super.composeParameters();
  hm.put(dbCbxDep.getOrgRecField(), "'"+dbCbxDep.getSelectedValue()+"'");
  Object dateBgn = dbTxtDateBgn.getSelectedValue();
  Object dateEnd = dbTxtDateEnd.getSelectedValue();
  if (dateBgn == null) {
    hm.put("P_DEL_BE", "DATE(2000,01,01)");
  }
  if (dateEnd == null) {
    hm.put("P_DEL_EN", "DATE(2099,12,31)");
  }
  return hm;
}

class cbxCenterItemChanged implements java.awt.event.ItemListener {
  public void itemStateChanged(ItemEvent e) {
    if (doingDB2Gui)return;
    try {
      //find out the vector to add dbDeps.
      if (DbJcbxcbxCntr.getSelectedValue() == null) {
        //only the all dep is allow to add now.
        dbCbxDep =
            new exgui.DataBindJCombobox(
            cbxDep, "P_DEP",
            new Vector(),
            "DEP_NAME", "DEP_CODE",
            null,
            "", "ALL");
      } else {
        //deps and "ALL"dep allow to add.
        Vector depVects =
            (Vector)tempProperties.tmpH_tbl_CenterDepMap.get(
            DbJcbxcbxCntr.getSelectedValue());
        dbCbxDep = null;
        if (depVects == null) {
          dbCbxDep =
              new exgui.DataBindJCombobox(
              cbxDep, "P_DEP",
              new Vector(),
              "DEP_NAME", "DEP_CODE",
              null,
              "", "ALL");
        } else if (depVects.size() > 1) {
          dbCbxDep =
              new exgui.DataBindJCombobox(
              cbxDep, "P_DEP",
              depVects,
              "DEP_NAME", "DEP_CODE",
              null,
              "", "ALL");
          //guis.add(DbJcbxcbxDep);
        } else {
          dbCbxDep =
              new exgui.DataBindJCombobox(
              cbxDep, "P_DEP",
              depVects,
              "DEP_NAME", "DEP_CODE",
              null);
          //guis.add(DbJcbxcbxDep);
        }
      }

    } catch (Exception exp) {
      exp.printStackTrace();
    }
  }
}

protected void btnQry_actionPerformed(ActionEvent e) {
  JButtonQueryButtonAction(e);
}

JLabel jLabel4 = new JLabel();
JTextField txtPointDate = new JTextField();
TitledBorder titledBorder1;

}

class PnlFabAccCommRpt_btnQry_actionAdapter implements java.awt.event.
  ActionListener {
PnlFabAccCommRpt adaptee;

PnlFabAccCommRpt_btnQry_actionAdapter(PnlFabAccCommRpt adaptee) {
  this.adaptee = adaptee;
}

 public void actionPerformed(ActionEvent e) {
   adaptee.btnQry_actionPerformed(e);
 }
}
