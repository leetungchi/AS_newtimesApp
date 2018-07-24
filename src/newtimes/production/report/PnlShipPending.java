package newtimes.production.report;

import java.awt.*;
import exgui.*;
import javax.swing.*;
import javax.swing.border.*;
import newtimes.preproduction.buyermakerselect.*;
import java.awt.event.*;
import exgui.*;
import java.util.*;
/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class PnlShipPending
    extends AbsQryPanel{
    //extends JPanel {
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel1 = new BlueBkgWhiteCharLabel();
  JPanel pnlDeps = new JPanel();
  TitledBorder titledBorder1;
  JComboBox cbxDep[] = new JComboBox[6];
  //JComboBox cbxDep1 = new JComboBox();
  //JComboBox cbxDep2 = new JComboBox();
  //JComboBox cbxDep3 = new JComboBox();
  //JComboBox cbxDep4 = new JComboBox();
  //JComboBox cbxDep5 = new JComboBox();
  String centerCode;
  JLabel jLabel1 = new JLabel();
  SelectBuyerMaker slkBuyer = new SelectBuyerMaker();
  JLabel jLabel2 = new JLabel();
  SelectBuyerMaker slkMaker = new SelectBuyerMaker();
  JLabel jLabel3 = new JLabel();
  JLabel jLabel4 = new JLabel();
  JTextField txtDelFrom = new JTextField();
  JLabel jLabel5 = new JLabel();
  JTextField txtDelTo = new JTextField();
  JButton btnQry = new JButton();
  protected   DataBindJCombobox  dbCbxDep[];
  protected   DataBindTextWithChecker dbTxtDateBgn,dbTxtDateEnd;
  protected  int itemCount=6;

  public PnlShipPending() {
    try {
      //jbInit();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }
  protected void jbInit() throws Exception {
    setBackground(new Color(204, 204, 225));
    centerCode=(String)util.PublicVariable.USER_RECORD.get("USR_CEN_CODE");
    dbCbxDep=new exgui.DataBindJCombobox[itemCount];
    for(int i=0;i<itemCount;i++){
      cbxDep[i]=new JComboBox();
    }

    titledBorder1 = new TitledBorder(new EtchedBorder(EtchedBorder.RAISED,Color.white,new Color(148, 145, 140)),"DEPARTMENTS");
    blueBkgWhiteCharLabel1.setBounds(new Rectangle(0, 6, 797, 23));
    blueBkgWhiteCharLabel1.setText("15 DAYS PENDING REPORT");
    this.setLayout(null);
    pnlDeps.setBorder(titledBorder1);
    pnlDeps.setBounds(new Rectangle(7, 48, 339, 131));
    pnlDeps.setLayout(null);
    cbxDep[0].setBounds(new Rectangle(7, 29, 153, 22));
    cbxDep[1].setBounds(new Rectangle(176, 29, 153, 22));
    cbxDep[2].setBounds(new Rectangle(7, 59, 153, 22));
    cbxDep[3].setBounds(new Rectangle(176, 59, 153, 22));
    cbxDep[4].setBounds(new Rectangle(7, 90, 153, 22));
    cbxDep[5].setBounds(new Rectangle(176, 90, 153, 22));
    jLabel1.setText("BUYER:");
    jLabel1.setBounds(new Rectangle(353, 45, 64, 25));
    slkBuyer.setBounds(new Rectangle(438, 45, 183, 23));
    jLabel2.setBounds(new Rectangle(353, 82, 64, 25));
    jLabel2.setText("MAKER:");
    jLabel2.setVerticalAlignment(javax.swing.SwingConstants.CENTER);
    slkMaker.setBounds(new Rectangle(438, 82, 183, 23));
    jLabel3.setText("BUYER DELIVERY DATE:");
    jLabel3.setBounds(new Rectangle(353, 118, 170, 25));
    jLabel4.setText("FROM:");
    jLabel4.setBounds(new Rectangle(353, 150, 45, 22));
    txtDelFrom.setText("");
    txtDelFrom.setBounds(new Rectangle(402, 150, 78, 21));
    jLabel5.setText("TO:");
    jLabel5.setBounds(new Rectangle(483, 150, 42, 24));
    txtDelTo.setText("");
    txtDelTo.setBounds(new Rectangle(522, 150, 84, 24));
    btnQry.setBounds(new Rectangle(626, 146, 79, 28));
    btnQry.setFont(new java.awt.Font("Dialog", 1, 11));
    btnQry.setText("REPORT");
    btnQry.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnQry_actionPerformed(e);
      }
    });
    this.add(blueBkgWhiteCharLabel1, null);
    pnlDeps.add(cbxDep[0], null);
    pnlDeps.add(cbxDep[1], null);
    pnlDeps.add(cbxDep[2], null);
    pnlDeps.add(cbxDep[3], null);
    pnlDeps.add(cbxDep[4], null);
    pnlDeps.add(cbxDep[5], null);
    this.add(pnlDeps, null);
    this.add(jLabel1, null);
    this.add(jLabel2, null);
    this.add(slkMaker, null);
    this.add(slkBuyer, null);
    this.add(jLabel4, null);
    this.add(jLabel3, null);
    this.add(jLabel5, null);
    this.add(txtDelFrom, null);
    this.add(txtDelTo, null);
    this.add(btnQry, null);
    genDataBindObj();
  }
  protected void genDataBindObj(){
    try{
       dataBindComps.clear();
       Object dateVfy = exgui.verification.CellFormat.getDateStringFormaterAllowNull();
       dbTxtDateBgn =
           new exgui.DataBindTextWithChecker(txtDelFrom, "P_DEL_FM", null,
                                             10, (exgui.Object2String)dateVfy,
                                             (exgui.ultratable.
                                              CellTxtEditorFormat)dateVfy);
       dataBindComps.add(dbTxtDateBgn);
       dbTxtDateEnd =
           new exgui.DataBindTextWithChecker(txtDelTo, "P_DEL_TO", null,
                                             10, (exgui.Object2String)dateVfy,
                                             (exgui.ultratable.
                                              CellTxtEditorFormat)dateVfy);
       dataBindComps.add(dbTxtDateEnd);
       Vector depVects=
           (Vector)newtimes.preproduction.guis.tempProperties.tmpH_tbl_CenterDepMap.get(
           centerCode);
       slkBuyer.init("P_BUYER",null,slkBuyer.TYPE_BUYER,true);
       slkMaker.init("P_MAKER",null,slkBuyer.TYPE_MAKER,true);
       for(int i=0;i<itemCount;i++){
          dbCbxDep[i] =
             new exgui.DataBindJCombobox(
             cbxDep[i], "P_DEP",
             depVects,
             "DEP_NAME", "DEP_NAME",
             null,
             " ", null);
       }
       super.reportName="SHIP_PENDING.RPT";

    }catch(Exception exp){
       exp.printStackTrace();
    }
  }
  protected HashMap composeParameters(){
    HashMap hm=super.composeParameters();
    StringBuffer sbDEP=new StringBuffer();
    if(slkBuyer.getSelectedValue()==null){
      hm.put("P_BUYER","['ALL']");
    }else{
      hm.put("P_BUYER","['"+
             util.MiscFunc.Replace(
             ((JTextField)slkBuyer.getGUIcomponent()).getText(),"'","''''") +"']");
    }
    if(slkMaker.getSelectedValue()==null){
      hm.put("P_Maker","['ALL']");
    }else{
      hm.put("P_Maker","['"+
             util.MiscFunc.Replace(
             ((JTextField)slkMaker.getGUIcomponent()).getText(),"'","''''") +"']");
    }

    for(int i=0;i<itemCount;i++){
      Object depObj=dbCbxDep[i].getSelectedValue();
      if(depObj!=null){
        if(sbDEP.length()>0)sbDEP.append(",");
        sbDEP.append("'");
        sbDEP.append(depObj);
        sbDEP.append("'");
      }
    }
    if(sbDEP.length()>0){
      hm.put("P_DEP","["+sbDEP.toString()+"]");
    }else{
      hm.put("P_DEP","['ALL']");
    }
    Object dateBgn=dbTxtDateBgn.getSelectedValue();
    Object dateEnd=dbTxtDateEnd.getSelectedValue();
    if(dateBgn==null){
      hm.put("P_DEL_FM","DATE(2000,01,01)");
    }
    if(dateEnd==null){
      hm.put("P_DEL_TO","DATE(2099,12,31)");
    }
    hm.put("P_CENTER",centerCode);
   return hm;
  }
  void btnQry_actionPerformed(ActionEvent e) {
    super.JButtonQueryButtonAction(e);
  }
}
