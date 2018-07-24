package newtimes.production.report;
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

public class PnlPenddingStyleProfitList
    //extends JPanel {
    extends AbsQryPanel {
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel1 = new BlueBkgWhiteCharLabel();
  JButton btnQry = new JButton();
  JLabel blueBkgWhiteCharLabel3 = new JLabel();
  JLabel jLabel2 = new JLabel();
  JComboBox cbxCntr = new JComboBox();
  JComboBox cbxDep = new JComboBox();
  boolean doingDB2Gui=false;
  exgui.DataBindJCombobox DbJcbxcbxCntr;
   DataBindJCombobox dbCbxDep;
  int indexCbxDep;
  SelectBuyerMaker slkBuyer = new SelectBuyerMaker();
  JLabel jLabel4 = new JLabel();
  public PnlPenddingStyleProfitList() {
    try {
      //jbInit();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }

public  void jbInit() throws Exception {
    blueBkgWhiteCharLabel1.setBounds(new Rectangle(-3, 14, 802, 30));
    blueBkgWhiteCharLabel1.setText("PENDING STYLE PROFIT LIST");
    this.setLayout(null);
    btnQry.setBounds(new Rectangle(691, 58, 89, 25));
    btnQry.setFont(new java.awt.Font("Dialog", 1, 11));
    btnQry.setFocusPainted(true);
    btnQry.setText("REPORT");
    btnQry.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnQry_actionPerformed(e);
      }
    });
    blueBkgWhiteCharLabel3.setText("Center");
    blueBkgWhiteCharLabel3.setBounds(new Rectangle(10, 58, 60, 19));
    jLabel2.setBounds(new Rectangle(192, 58, 47, 21));
    jLabel2.setText("DEP.");
    cbxCntr.setBounds(new Rectangle(54, 58, 130, 22));
    cbxCntr.addItemListener(new cbxCenterItemChanged());
    cbxDep.setBounds(new Rectangle(235, 58, 184, 22));
    slkBuyer.setBounds(new Rectangle(470, 57, 204, 20));
    jLabel4.setText("BUYER");
    jLabel4.setBounds(new Rectangle(429, 57, 53, 17));
    this.add(blueBkgWhiteCharLabel1, null);
    this.add(blueBkgWhiteCharLabel3, null);
    this.add(cbxCntr, null);
    this.add(jLabel2, null);
    this.add(cbxDep, null);
    this.add(btnQry, null);
    this.add(jLabel4, null);
    this.add(slkBuyer, null);
    reportName="STY_PROFIT.rpt";

    genDataBindObj();
  }
  class cbxCenterItemChanged implements java.awt.event.ItemListener {
  public void itemStateChanged(ItemEvent e) {
     reGenDepartment();
   }
 }

  public void genDataBindObj(){
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
      slkBuyer.setSelectingCenter((String)util.PublicVariable.USER_RECORD.get("usr_cen_code"));
      slkBuyer.init("P_BUYER",null,null,slkBuyer.TYPE_BUYER,true);

      indexCbxDep =dataBindComps.size();
      dataBindComps.add(null);




      doingDB2Gui=false;

      if(util.PublicVariable.USER_RECORD.getInt(2)==newtimesejb.preproduction.PreProductionHead.USER_TYPE_MANAGER ||
           util.PublicVariable.USER_RECORD.getInt(2)==newtimesejb.preproduction.PreProductionHead.USER_TYPE_USERS){
          Vector depVects =
              (Vector)tempProperties.tmpH_tbl_CenterDepMap.get(
              DbJcbxcbxCntr.getSelectedValue());
          dbCbxDep = null;
            dbCbxDep =
                new exgui.DataBindJCombobox(
                cbxDep, "P_DEP",
                depVects,
                "DEP_NAME", "DEP_CODE",
                "");

          dataBindComps.set(indexCbxDep,dbCbxDep);
        }else{
          cbxCntr.getItemListeners()[0].itemStateChanged(null);
        }

      //cbxCntr.getItemListeners()[0].itemStateChanged(null);

    } catch(Exception exp){
      exp.printStackTrace();
    }
  }
  public java.util.HashMap composeParameters(){
   java.util.HashMap hm=super.composeParameters();
   Object objBuyer=slkBuyer.getSelectedValue();
   hm.put("P_BUYER",(objBuyer==null)?"0":objBuyer.toString());
   return hm;

 }

  protected void reGenDepartment(){
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
            "",
            "ALL", "ALL");
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
              "",
              "ALL", "ALL");
        } else if (depVects.size() > 1) {
          dbCbxDep =
              new exgui.DataBindJCombobox(
              cbxDep, "P_DEP",
              depVects,
              "DEP_NAME", "DEP_CODE",
              "",
              "ALL", "ALL");
          //guis.add(DbJcbxcbxDep);
        } else {
          dbCbxDep =
              new exgui.DataBindJCombobox(
              cbxDep, "P_DEP",
              depVects,
              "DEP_NAME", "DEP_CODE",
              "","ALL","ALL");
          //guis.add(DbJcbxcbxDep);
        }
      }

     dataBindComps.set(indexCbxDep,dbCbxDep);
     String centerCode=(String)DbJcbxcbxCntr.getSelectedValue();
     slkBuyer.setSelectingCenter(centerCode);
     slkBuyer.init("P_BUYER",null,null,slkBuyer.TYPE_BUYER,true);

     if(centerCode==null)centerCode=util.PublicVariable.OPERATTING_CENTER.toString();
    } catch (Exception exp) {
      exp.printStackTrace();
    }
  }

  void btnQry_actionPerformed(ActionEvent e) {

    String tempURL= newtimes.production.report.ReportProxyEngine.reportServerURL ;
    newtimes.production.report.ReportProxyEngine.reportServerURL="http://rpt2.nttpe.com.tw:9000/?file:///rpt//";
    super.JButtonQueryButtonAction(null);
    newtimes.production.report.ReportProxyEngine.reportServerURL =tempURL;

  }
}
