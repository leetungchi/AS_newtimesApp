package newtimes.production.report;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import exgui.*;
import java.util.*;
import javax.swing.border.*;
import newtimes.preproduction.guis.*;

import java.awt.*;
import javax.swing.JPanel;
import newtimes.preproduction.buyermakerselect.*;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class PnlNthkInvList
    //extends JPanel {
    extends AbsQryPanel{
  JLabel blueBkgWhiteCharLabel3 = new JLabel();
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel1 = new BlueBkgWhiteCharLabel();
  JComboBox cbxCntr = new JComboBox();
  JButton btnQry = new JButton();
  exgui.DataBindJCombobox DbJcbxcbxCntr;
   protected   DataBindTextWithChecker dbTxtDateBgn,dbTxtDateEnd,dbTxtCreateDateFrom,dbTxtCreateDateTo;
   boolean doingDB2Gui=false;
   int indexCbxDep=0;
   int indexCbxMng=0;
  public PnlNthkInvList() {
    try {
      //jbInit();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }

 protected void jbInit() throws Exception {
    titledBorder1 = new TitledBorder(BorderFactory.createEtchedBorder(Color.white,new Color(141, 141, 156)),"ETD DATE");
    this.setLayout(null);
    blueBkgWhiteCharLabel3.setBounds(new Rectangle(4, 54, 60, 19));
    blueBkgWhiteCharLabel3.setText("Center");
    blueBkgWhiteCharLabel1.setText(" NTHK INV LISTING ");
    blueBkgWhiteCharLabel1.setBounds(new Rectangle(0, 10, 803, 28));
    cbxCntr.setBounds(new Rectangle(42, 56, 147, 22));
    btnQry.setBounds(new Rectangle(712, 51, 80, 27));
    btnQry.setFont(new java.awt.Font("Dialog", 1, 11));
    btnQry.setText("REPORT");
    btnQry.addActionListener(new PnlNthkInvList_btnQry_actionAdapter(this));
    this.setBackground(new Color(202, 202, 224));
    pnlDELDate.setBackground(new Color(202, 202, 224));
    pnlDELDate.setBorder(titledBorder1);
    pnlDELDate.setDebugGraphicsOptions(0);
    pnlDELDate.setBounds(new Rectangle(190, 42, 259, 47));
    pnlDELDate.setLayout(null);
    jLabel2.setText("TO");
    jLabel2.setBounds(new Rectangle(139, 14, 27, 20));
    txtDelDDTo.setText("");
    txtDelDDTo.setBounds(new Rectangle(163, 14, 71, 23));
    txtDelDateFrom.setText("");
    txtDelDateFrom.setBounds(new Rectangle(66, 15, 71, 23));
    jLabel3.setText("FROM");
    jLabel3.setBounds(new Rectangle(11, 15, 54, 18));
    jLabel5.setBounds(new Rectangle(611, 54, 27, 20));
    jLabel5.setText("TO");
    jLabel6.setBounds(new Rectangle(452, 42, 90, 26));
    jLabel6.setHorizontalAlignment(SwingConstants.LEADING);
    jLabel6.setText("CREATE DATE");
    txtCreateDDTo.setBounds(new Rectangle(635, 54, 71, 23));
    txtCreateDDTo.setText("");
    txtCreateDateFrom.setBounds(new Rectangle(538, 54, 71, 23));
    txtCreateDateFrom.setText("");
    jLabel7.setText("FROM");
    jLabel7.setBounds(new Rectangle(489, 62, 47, 23));
    this.add(blueBkgWhiteCharLabel1, null);
    pnlDELDate.add(txtDelDateFrom, null);
    pnlDELDate.add(jLabel3, null);
    pnlDELDate.add(jLabel2, null);
    pnlDELDate.add(txtDelDDTo, null);
    this.add(txtCreateDDTo, null);
    this.add(jLabel6, null);
    this.add(jLabel7, null);
    this.add(txtCreateDateFrom, null);
    this.add(jLabel5, null);
    this.add(btnQry, null);
    this.add(cbxCntr, null);
    this.add(blueBkgWhiteCharLabel3, null);
    this.add(pnlDELDate, null);
    genDataBindObj();
    reportName="SHIP_SC_CT_AMT.rpt";
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
          (String)util.PublicVariable.USER_RECORD.get("usr_cen_code"));
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
    java.sql.Date now=null;//new java.sql.Date(System.currentTimeMillis());
    Object dateVfy = exgui.verification.CellFormat.getDateStringFormaterAllowNull();
    dbTxtDateEnd =
        new exgui.DataBindTextWithChecker(txtDelDDTo, "P_DEL_TO", now,
                                          10, (exgui.Object2String)dateVfy,
                                          (exgui.ultratable.
                                           CellTxtEditorFormat)dateVfy);
    dataBindComps.add(dbTxtDateEnd);

    dbTxtDateBgn =
        new exgui.DataBindTextWithChecker(txtDelDateFrom, "P_DEL_FM", now,
                                          10, (exgui.Object2String)dateVfy,
                                          (exgui.ultratable.
                                           CellTxtEditorFormat)dateVfy);
    dataBindComps.add(dbTxtDateBgn);

    dbTxtCreateDateTo  =
        new exgui.DataBindTextWithChecker(txtCreateDDTo, "P_CRT_TO", now,
                                          10, (exgui.Object2String)dateVfy,
                                          (exgui.ultratable.
                                           CellTxtEditorFormat)dateVfy);
    dataBindComps.add(dbTxtCreateDateTo);

    dbTxtCreateDateFrom =
        new exgui.DataBindTextWithChecker(txtCreateDateFrom, "P_CRT_FM", now,
                                          10, (exgui.Object2String)dateVfy,
                                          (exgui.ultratable.
                                           CellTxtEditorFormat)dateVfy);
    dataBindComps.add(dbTxtCreateDateFrom);

    Object chkDcm32 = exgui.verification.CellFormat.getDoubleFormatAllowNull(5, 4);
    Vector vct = exgui2.CONST.BASIC_MAIN_EJB.getDatas(
      util.PublicVariable.USER_RECORD,
      "select * from system_default_value where CENTER='" + (String)util.PublicVariable.USER_RECORD.get("USR_CEN_CODE") + "' and record_delete_flag=1",
      1, 1);
    database.datatype.Record recSystem = (database.datatype.Record)vct.get(0);
   exgui.DataBindTextWithChecker dbTwdChg = new DataBindTextWithChecker(txtTwdUsd, "TWD_USD", recSystem.get("TWD_XCHG_RATE"), 10, (Object2String)chkDcm32, (exgui.ultratable.CellTxtEditorFormat)chkDcm32);
    dataBindComps.add(dbTwdChg);
   exgui.DataBindTextWithChecker dbRmbChg = new DataBindTextWithChecker(txtRmbUsd, "RMB_USD", recSystem.get("RMB_XCHG_RATE"), 10, (Object2String)chkDcm32, (exgui.ultratable.CellTxtEditorFormat)chkDcm32);
    dataBindComps.add(dbRmbChg);
   exgui.DataBindTextWithChecker dbHkdChg = new DataBindTextWithChecker(txtHkdUsd, "HKD_USD", recSystem.get("HKD_XCHG_RATE"), 10, (Object2String)chkDcm32, (exgui.ultratable.CellTxtEditorFormat)chkDcm32);
    dataBindComps.add(dbHkdChg);
   //dataBindComps.add(slkBuyer);
    doingDB2Gui=false;


  }catch(Exception exp){
    exp.printStackTrace();
  }
}
JTextField txtTwdUsd=new JTextField(),txtRmbUsd=new JTextField(),txtHkdUsd=new JTextField();

public HashMap composeParameters() {
  HashMap hm = super.composeParameters();
  //hm.put(dbCbxDep.getOrgRecField(), "'"+dbCbxDep.getSelectedValue()+"'");
  Object dateBgn = dbTxtDateBgn.getSelectedValue();
  Object dateTo = dbTxtDateEnd.getSelectedValue();
  Object creatFrom=dbTxtCreateDateFrom.getSelectedValue();
  Object creatTo=dbTxtCreateDateTo.getSelectedValue();
  if(null==creatFrom){hm.put(dbTxtCreateDateFrom.getOrgRecField(),"DATE(2000,01,01)");}
  if(null==creatTo){hm.put(dbTxtCreateDateTo.getOrgRecField(),"DATE(2099,12,31)");}

  if (dateTo == null) {
    hm.put("P_DEL_TO", "DATE(2099,12,31)");
  }
  if(dateBgn==null){
    hm.put("P_DEL_FM", "DATE(2004,07,01)");
  }


  return hm;
}

void btnQry_actionPerformed(ActionEvent e) {
  JButtonQueryButtonAction(e);
}

JLabel jLabel4 = new JLabel();
JTextField txtPointDate = new JTextField();
TitledBorder titledBorder1;
  JPanel pnlDELDate = new JPanel();
  JLabel jLabel2 = new JLabel();
  JTextField txtDelDDTo = new JTextField();
  JTextField txtDelDateFrom = new JTextField();
  JLabel jLabel3 = new JLabel();
  JLabel jLabel5 = new JLabel();
  JLabel jLabel6 = new JLabel();
  JTextField txtCreateDDTo = new JTextField();
  JTextField txtCreateDateFrom = new JTextField();
  JLabel jLabel7 = new JLabel();

}

class PnlNthkInvList_btnQry_actionAdapter implements java.awt.event.
  ActionListener {
PnlNthkInvList adaptee;

 PnlNthkInvList_btnQry_actionAdapter(PnlNthkInvList adaptee) {
  this.adaptee = adaptee;
}

 public void actionPerformed(ActionEvent e) {
   adaptee.btnQry_actionPerformed(e);
 }

}
