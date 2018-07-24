package newtimes.accounting;

import java.awt.*;
import javax.swing.*;
import newtimes.preproduction.buyermakerselect.*;
import exgui.*;
import javax.swing.border.*;
import java.awt.event.*;
import database.datatype.Record;
import newtimes.preproduction.buyermakerselect.*;
import java.util.*;
import newtimes.preproduction.guis.*;
/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class PnlStatmentOfTotalCommission
     //extends JPanel {
     extends newtimes.production.report.AbsQryPanel{
  JComboBox cbxDiv = new JComboBox();
  SelectBuyerMaker slkProdBuyer = new SelectBuyerMaker();
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel1 = new BlueBkgWhiteCharLabel();
  JLabel jLabel7 = new JLabel();
  JLabel lblDiv = new JLabel();
  JLabel blueBkgWhiteCharLabel3 = new JLabel();
  JPanel pnlDuriation = new JPanel();
  JComboBox cbxCntr = new JComboBox();
  JTextField txtDateEnd = new JTextField();
  JLabel jLabel2 = new JLabel();
  JLabel jLabel3 = new JLabel();
  JTextField txtDateBgn = new JTextField();
  Border border1;
  TitledBorder titledBorder1;
  JButton btnQuery = new JButton();
  JLabel jLabel1 = new JLabel();
  JComboBox cbxProdType = new JComboBox(new String[]{"BULK","SAMPLE","ALL"});
  exgui.DataBindJCombobox DbJcbxcbxDiv=null,DbJcbxcbxCntr=null;
  ChangeBuyerHandler changeBuyerHandler;
  protected   DataBindTextWithChecker dbTxtDateBgn,dbTxtDateEnd;
  boolean doingDB2Gui=false;
  static int RUSEEL_BUER_SEQ=79;
  public PnlStatmentOfTotalCommission() {
    try {
      //jbInit();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }

 protected void jbInit() throws Exception {
    border1 = new EtchedBorder(EtchedBorder.RAISED,Color.white,new Color(141, 141, 156));
    titledBorder1 = new TitledBorder(border1,"ETD DATE");
    lblDiv.setBounds(new Rectangle(202, 78, 95, 21));
    lblDiv.setText("DIVISION");
    jLabel7.setBounds(new Rectangle(202, 50, 87, 21));
    jLabel7.setText("Buyer");
    blueBkgWhiteCharLabel1.setBounds(new Rectangle(1, 11, 797, 23));
    blueBkgWhiteCharLabel1.setText("STATEMENT OF TOTAL COMMISSION");
    slkProdBuyer.setModifyNotifyTo(changeBuyerHandler);
    slkProdBuyer.setBounds(new Rectangle(287, 50, 199, 21));
    cbxDiv.setBounds(new Rectangle(287, 78, 198, 22));
    this.setLayout(null);
    changeBuyerHandler= new ChangeBuyerHandler();

    blueBkgWhiteCharLabel3.setBounds(new Rectangle(6, 51, 60, 19));
    blueBkgWhiteCharLabel3.setText("Center");
    pnlDuriation.setBackground(new Color(202, 202, 224));
    pnlDuriation.setBorder(titledBorder1);
    pnlDuriation.setBounds(new Rectangle(496, 47, 291, 53));
    pnlDuriation.setLayout(null);
    //cbxCntr.addItemListener(new cbxCenterItemChanged());
    cbxCntr.setBounds(new Rectangle(50, 53, 130, 22));
    this.setBackground(new Color(202, 202, 224));
    txtDateEnd.setText("");
    txtDateEnd.setBounds(new Rectangle(188, 20, 87, 22));
    jLabel2.setText("FROM:");
    jLabel2.setBounds(new Rectangle(9, 20, 56, 21));
    jLabel3.setText("TO:");
    jLabel3.setBounds(new Rectangle(155, 20, 36, 24));
    txtDateBgn.setText("");
    txtDateBgn.setBounds(new Rectangle(53, 20, 87, 20));
    btnQuery.setBounds(new Rectangle(609, 121, 135, 27));
    btnQuery.setFont(new java.awt.Font("Dialog", 1, 11));
    btnQuery.setText("QUERY");
    btnQuery.addActionListener(new PnlStatmentOfTotalCommission_btnQuery_actionAdapter(this));
    jLabel1.setText("TYPE");
    jLabel1.setBounds(new Rectangle(3, 89, 44, 20));
    cbxProdType.setBounds(new Rectangle(48, 87, 133, 20));
    this.add(blueBkgWhiteCharLabel1, null);
    pnlDuriation.add(jLabel2, null);
    pnlDuriation.add(txtDateBgn, null);
    pnlDuriation.add(jLabel3, null);
    pnlDuriation.add(txtDateEnd, null);
    this.add(btnQuery, null);
    this.add(lblDiv, null);
    this.add(jLabel7, null);
    this.add(cbxDiv, null);
    this.add(slkProdBuyer, null);
    this.add(blueBkgWhiteCharLabel3, null);
    this.add(cbxCntr, null);
    this.add(pnlDuriation, null);
    this.add(jLabel1, null);
    this.add(cbxProdType, null);
    genDataBindObj();
  }
  public void genDataBindObj() {
    slkProdBuyer.init("PROD_BUYER",null,slkProdBuyer.TYPE_BUYER,true);
    slkProdBuyer.setModifyNotifyTo(changeBuyerHandler);
    slkProdBuyer.init("PROD_BUYER",new Integer(RUSEEL_BUER_SEQ),slkProdBuyer.TYPE_BUYER,true);
    doingDB2Gui=true;
    dataBindComps.clear();
    try{

      if (tempProperties.tmpCenters.size() > 1) {
        DbJcbxcbxCntr =
            new exgui.DataBindJCombobox(
            cbxCntr, "P_CENTER",
            tempProperties.tmpCenters,
            "CEN_NAME", "CEN_CODE",
            (String)util.PublicVariable.USER_RECORD.get("usr_cen_code"), "ALL", null);
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


      Object dateVfy = exgui.verification.CellFormat.getDateStringFormaterAllowNull();
      dbTxtDateBgn =
          new exgui.DataBindTextWithChecker(txtDateBgn, "P_INV_FM", null,
                                            10, (exgui.Object2String)dateVfy,
                                            (exgui.ultratable.
                                             CellTxtEditorFormat)dateVfy);
      dataBindComps.add(dbTxtDateBgn);

      dbTxtDateEnd =
          new exgui.DataBindTextWithChecker(txtDateEnd, "P_INV_TO", null,
                                            10, (exgui.Object2String)dateVfy,
                                            (exgui.ultratable.
                                             CellTxtEditorFormat)dateVfy);
      dataBindComps.add(dbTxtDateEnd);
      Vector vctDivs=
          exgui2.CONST.BASIC_MAIN_EJB.getDatas(
         util.PublicVariable.USER_RECORD,
         "select * from division where DIV_BYMKR_SEQ="+RUSEEL_BUER_SEQ+" and record_delete_flag='1' order by DIV_NAME",
        1,999);
      DbJcbxcbxDiv = new exgui.DataBindJCombobox(
          cbxDiv,
          "PROD_BUYER_DIVISION",
          vctDivs,
          "DIV_NAME", "DIV_NAME",
          null, "", null);




      reportName="tot_comm_lst.rpt";

    }catch(Exception exp){
      exp.printStackTrace();
    }
  }


  public class ChangeBuyerHandler
      implements newtimes.preproduction.buyermakerselect.BuyerMakerChanged{
    public void changeBuyerMaker(Record buyerRecord) {
      //recompose the division combobox of buyer.
      try {
        //find out the vector to add dbDeps.
        if (buyerRecord == null) {
          //only the all dep is allow to add now.
          DbJcbxcbxDiv = new exgui.DataBindJCombobox(
              cbxDiv,
              "PROD_BUYER_DIVISION",
              new Vector(),
              "DIV_NAME", "DIV_NAME",
              null, "", null);
        } else {
          //deps and "ALL"dep allow to add.
          Vector dvsnRecords =
              (Vector)newtimes.preproduction.guis.tempProperties.tmpHMap_BuyerDivison.get(
              buyerRecord.get(0).toString());
          DbJcbxcbxDiv = null;
          if (dvsnRecords == null) {
            DbJcbxcbxDiv = new exgui.DataBindJCombobox(
                cbxDiv,
                 "PROD_BUYER_DIVISION",
                new Vector(),
                "DIV_NAME",
                "DIV_NAME",
                null, "ALL", null);
            //cbxDiv.setUI(new exgui.WideComboBoxUI(160));
          } else {
            DbJcbxcbxDiv = new exgui.DataBindJCombobox(
                cbxDiv,
                "PROD_BUYER_DIVISION",
                dvsnRecords,
                "DIV_NAME",
                "DIV_NAME",
                null, "ALL", null);
            //cbxDiv.setUI(new exgui.WideComboBoxUI(160));
          }

        }

      } catch (Exception exp) {
        exp.printStackTrace();
      }
    }
  }
  public HashMap composeParameters(){
     HashMap hm = super.composeParameters();
     Object objBuyer=slkProdBuyer.getSelectedValue();
     if(objBuyer==null){
       hm.put("P_BUYER","'ALL'");
     }else{
       hm.put("P_BUYER",
              util.MiscFunc.Replace(
      ((javax.swing.JTextField)slkProdBuyer.getGUIcomponent()).getText(),
       "'","''"));
     }
     hm.put("P_TYPE","'"+String.valueOf(cbxProdType.getSelectedIndex()+1)+"'");
     Object objDiv =DbJcbxcbxDiv.getSelectedValue();
     if(objDiv==null)
       hm.put("P_DIV","'ALL'");
     else
       hm.put("P_DIV","'"+objDiv.toString()+"'");

     Object dateBgn=dbTxtDateBgn.getSelectedValue();
     Object dateEnd=dbTxtDateEnd.getSelectedValue();
     if(dateBgn==null){
       hm.put("P_INV_FM","DATE(2000,01,01)");
     }
     if(dateEnd==null){
       hm.put("P_INV_TO","DATE(2099,12,31)");
     }

     return hm;
  }
  void btnQuery_actionPerformed(ActionEvent e) {
     super.JButtonQueryButtonAction(e);
  }


}


class PnlStatmentOfTotalCommission_btnQuery_actionAdapter implements java.awt.event.ActionListener {
  PnlStatmentOfTotalCommission adaptee;

  PnlStatmentOfTotalCommission_btnQuery_actionAdapter(PnlStatmentOfTotalCommission adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.btnQuery_actionPerformed(e);
  }
}
