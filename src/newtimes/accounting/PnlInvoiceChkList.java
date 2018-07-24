package newtimes.accounting;

import java.awt.*;
import javax.swing.*;
import exgui.*;
import javax.swing.border.*;
import java.util.*;
import newtimes.production.report.AbsQryPanel;
import java.awt.event.*;
/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class PnlInvoiceChkList
    //extends JPanel {
    extends AbsQryPanel{
  JTextField txtDateEnd = new JTextField();
  JPanel pnlDeps = new JPanel();
  JLabel lblDateBgn = new JLabel();
  JTextField txtDateFrom = new JTextField();
  JComboBox cbxCenter = new JComboBox();
  JLabel lblCenter = new JLabel();
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel1 = new BlueBkgWhiteCharLabel();
  JPanel pnlFTYDEL = new JPanel();
  JLabel lblDateEnd = new JLabel();
  Border border1;
  TitledBorder titledBorder1;
  Border border2;
  TitledBorder titledBorder2;
  JButton btnQry = new JButton();
  JComboBox cbxDep[] = new JComboBox[6];
  exgui.DataBindJCombobox dbCbxDep[]=new exgui.DataBindJCombobox[6];
  exgui.DataBindJCombobox dbCbxCenter;
  exgui.DataBindTextWithChecker dbTxtDateBgn,dbTxtDateEnd;

  public PnlInvoiceChkList() {
    try {
      //jbInit();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }

protected  void jbInit() throws Exception {
    for(int i=0;i<6;i++){
        cbxDep[i] = new JComboBox();
    }

    border1 = new EtchedBorder(EtchedBorder.RAISED,Color.white,new Color(141, 141, 157));
    titledBorder1 = new TitledBorder(border1,"O.B.D");
    border2 = new EtchedBorder(EtchedBorder.RAISED,Color.white,new Color(142, 142, 157));
    titledBorder2 = new TitledBorder(border2,"DEPARTMENTS");
    //pnlDeps.setLayout(null);
    pnlDeps.setLayout(new java.awt.GridLayout(3,2));
    pnlDeps.setBounds(new Rectangle(9, 87, 392, 121));
    pnlDeps.setBackground(new Color(204, 204, 225));
    pnlDeps.setBorder(titledBorder2);
    txtDateEnd.setBounds(new Rectangle(207, 11, 96, 22));
    txtDateEnd.setText("");
    this.setLayout(null);
    lblDateBgn.setBounds(new Rectangle(9, 10, 57, 22));
    lblDateBgn.setText("FROM");
    lblDateBgn.setToolTipText("");
    txtDateFrom.setBounds(new Rectangle(49, 11, 100, 22));
    txtDateFrom.setText("");
    cbxCenter.setBounds(new Rectangle(72, 51, 107, 21));
    lblCenter.setBounds(new Rectangle(12, 51, 82, 21));
    lblCenter.setText("CENTER");
    blueBkgWhiteCharLabel1.setText("INVOICE CHECK LIST");
    blueBkgWhiteCharLabel1.setBounds(new Rectangle(0, 5, 800, 31));
    pnlFTYDEL.setBackground(new Color(202, 202, 225));
    pnlFTYDEL.setBorder(titledBorder1);
    pnlFTYDEL.setBounds(new Rectangle(185, 45, 319, 41));
    pnlFTYDEL.setLayout(null);
    lblDateEnd.setText("TO");
    lblDateEnd.setBounds(new Rectangle(166, 12, 47, 22));
    this.setBackground(new Color(204, 204, 225));
    btnQry.setBounds(new Rectangle(655, 186, 83, 24));
    btnQry.setFont(new java.awt.Font("Dialog", 1, 11));
    btnQry.setText("REPORT");
    btnQry.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnQry_actionPerformed(e);
      }
    });
    /*
    cbxDep[0].setBounds(new Rectangle(18, 29, 124, 21));
    cbxDep[1].setBounds(new Rectangle(18, 68, 124, 21));
    cbxDep[2].setBounds(new Rectangle(18, 106, 124, 21));
    cbxDep[3].setBounds(new Rectangle(213, 29, 124, 21));
    cbxDep[4].setBounds(new Rectangle(213, 68, 124, 21));
    cbxDep[5].setBounds(new Rectangle(213, 106, 124, 21));
    */
    jLabel1.setText("DESTINATION :");
    jLabel1.setBounds(new Rectangle(405, 92, 102, 26));
    cbxDest.setBounds(new Rectangle(503, 92, 289, 25));
    jLabel2.setText("SAMPLE / BULK :");
    jLabel2.setBounds(new Rectangle(510, 53, 96, 26));
    cbxSmpBlk.setBounds(new Rectangle(617, 55, 145, 25));
    pnlDeps.add(cbxDep[0], null);
    pnlDeps.add(cbxDep[1], null);
    pnlDeps.add(cbxDep[2], null);
    pnlDeps.add(cbxDep[3], null);
    pnlDeps.add(cbxDep[4], null);
    pnlDeps.add(cbxDep[5], null);
    pnlFTYDEL.add(lblDateEnd, null);
    pnlFTYDEL.add(lblDateBgn, null);
    pnlFTYDEL.add(txtDateFrom, null);
    pnlFTYDEL.add(txtDateEnd, null);
    this.add(pnlDeps, null);
    this.add(lblCenter, null);
    this.add(cbxCenter, null);
    this.add(btnQry, null);
    this.add(pnlFTYDEL, null);
    this.add(blueBkgWhiteCharLabel1, null);
    this.add(jLabel1, null);
    this.add(cbxDest, null);
    this.add(jLabel2, null);
    this.add(cbxSmpBlk, null);
    genDataBindObj();
  }
  protected void genDataBindObj(){
    try{
      dataBindComps.clear();

      Vector vctDest=exgui2.CONST.BASIC_MAIN_EJB.getDatas(
        util.PublicVariable.USER_RECORD,
        "select dest_name from destination where record_delete_flag='1' order by dest_name "
        ,1,99999
      );


     exgui.DataBindJCombobox dbCbxDest= new exgui.DataBindJCombobox(
       cbxDest, "P_DEST",
       vctDest,
       "DEST_NAME", "DEST_NAME",
       "ALL"," ", "ALL");
      dataBindComps.add(dbCbxDest);

      dbCbxCenter =
           new exgui.DataBindJCombobox(
           cbxCenter, "CENTER_CODE",
          newtimes.preproduction.guis.tempProperties.tmpCenters,
           "CEN_NAME", "CEN_CODE",
           (String)util.PublicVariable.USER_RECORD.get("usr_cen_code"));
      dataBindComps.add(dbCbxCenter);

      Object dateVfy = exgui.verification.CellFormat.
          getDateStringFormaterAllowNull();
      dbTxtDateBgn =
          new exgui.DataBindTextWithChecker(txtDateFrom, "OBD_FM", null,
                                            10, (exgui.Object2String)dateVfy,
                                            (exgui.ultratable.
                                             CellTxtEditorFormat)dateVfy);
      dataBindComps.add(dbTxtDateBgn);

      dbTxtDateEnd =
          new exgui.DataBindTextWithChecker(txtDateEnd, "OBD_TO", null,
                                            10, (exgui.Object2String)dateVfy,
                                            (exgui.ultratable.
                                             CellTxtEditorFormat)dateVfy);
      dataBindComps.add(dbTxtDateEnd);
      this.add(pnlFTYDEL, null);
      this.add(jLabel1, null);
      this.add(cbxDest, null);
      this.add(blueBkgWhiteCharLabel1, null);
      this.add(jLabel1, null);
      /*
      Vector depVects=
          (Vector)newtimes.preproduction.guis.tempProperties.tmpH_tbl_CenterDepMap.get(
          dbCbxCenter.getSelectedValue());
      for(int i=0;i<6;i++){
        dbCbxDep[i] =
            new exgui.DataBindJCombobox(
            cbxDep[i], "DEP",
            depVects,
            "DEP_NAME", "DEP_NAME",
            null,
            "ALL", null);
        //dataBindComps.add(dbCbxDep[i]);
      }*/

      super.reportName="INV_LST_ACC.RPT";
      cbxCenter.addItemListener(new cbxCenterItemChanged());
      cbxCenter.getItemListeners()[0].itemStateChanged(null);
    }catch(Exception exp){
       exp.printStackTrace();
    }
  }
  class cbxCenterItemChanged implements java.awt.event.ItemListener {
    public void itemStateChanged(ItemEvent e) {
       udpateDepComboBox();
    }
  }

  protected void udpateDepComboBox(){
    Vector depVects=
        (Vector)newtimes.preproduction.guis.tempProperties.tmpH_tbl_CenterDepMap.get(
        dbCbxCenter.getSelectedValue());
    for(int i=0;i<6;i++){
      dbCbxDep[i] =
          new exgui.DataBindJCombobox(
          cbxDep[i], "DEP",
          depVects,
          "DEP_NAME", "DEP_NAME",
          null,
          "ALL", null);
      //dataBindComps.add(dbCbxDep[i]);
    }
  }
  protected java.util.HashMap composeParameters(){
    java.util.HashMap hm=super.composeParameters();
    Object dateBgn=dbTxtDateBgn.getSelectedValue();
    Object dateEnd = dbTxtDateEnd.getSelectedValue();

    if (dateBgn == null) {
      hm.put("OBD_FM", "DATE(2000,01,01)");
    }
    if (dateEnd == null) {
      hm.put("OBD_TO", "DATE(2099,12,31)");
    }
    StringBuffer sb=new StringBuffer();
    for(int i=0;i<6;i++){
      Object obj=dbCbxDep[i].getSelectedValue();
      if(obj!=null){
        if(sb.length()>0)sb.append(",");
        sb.append("'");sb.append(obj);sb.append("'");
      }
    }
    if(sb.length()>0){
      hm.put("DEPT","["+sb.toString()+"]");
    }else{
      hm.put("DEPT","['ALL']");
    }
    hm.put("P_SMPL",cbxSmpBlk.getSelectedItem().toString().substring(0,1));
    return hm;
  }

  void btnQry_actionPerformed(ActionEvent e) {
    JButtonQueryButtonAction(e);
  }
  JLabel jLabel1 = new JLabel();
  JComboBox cbxDest = new JComboBox();
  JLabel jLabel2 = new JLabel();
  JComboBox cbxSmpBlk = new JComboBox(new String[]{"ALL","SAMPLE","BULK"});

}
