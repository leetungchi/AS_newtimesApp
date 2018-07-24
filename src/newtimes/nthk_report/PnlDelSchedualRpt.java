package newtimes.nthk_report;

import java.awt.*;
import exgui.*;
import javax.swing.*;
import javax.swing.border.*;
import newtimes.preproduction.buyermakerselect.*;
import java.util.*;
import java.awt.event.*;
import BasicMdlEJBs.BasicMaintainEJB.BasicMaintainEJB;
import database.datatype.Record;
import exgui.BlueBkgWhiteCharLabel;
import exgui.DataBindTextWithChecker;
import exgui.Object2String;
import exgui.ultratable.CellTxtEditorFormat;
import exgui.verification.CellFormat;
import exgui2.CONST;
import newtimes.preproduction.guis.tempProperties;
import newtimes.production.report.AbsQryPanel;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class PnlDelSchedualRpt
    //extends JPanel {
    extends AbsQryPanel implements Int_PNL_JINIT{
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel1 = new BlueBkgWhiteCharLabel();
  JTextField txtDelTo = new JTextField();
  JLabel lblDDFrom = new JLabel();
  JLabel lblCountry = new JLabel();
  JComboBox cbxCenter = new JComboBox();
  JLabel lblCenter = new JLabel();
  JLabel lblYear2 = new JLabel();
  JComboBox cbxCountry = new JComboBox();
  JTextField txtDelFrom = new JTextField();
  JPanel pnlMakers = new JPanel();
  JPanel pnlBuyers = new JPanel();
  Border border1;
  TitledBorder titledBorder1;
  Border border2;
  TitledBorder titledBorder2;
  JLabel jLabel1 = new JLabel();
  JComboBox cbxDep = new JComboBox();
  JTextField txtCreateTo = new JTextField();
  JLabel lblDDFrom1 = new JLabel();
  JLabel lblYear3 = new JLabel();
  JTextField txtCreateFrom = new JTextField();
  JLabel jLabel2 = new JLabel();
  JTextField txtBuyerLabel = new JTextField();
  JLabel jLabel3 = new JLabel();
  JTextField txtStyle = new JTextField();
  JLabel jLabel4 = new JLabel();
  JTextField txtPo = new JTextField();
  JButton btnQry = new JButton();
  protected   SelectBuyerMaker buyers[]=null;
  protected   SelectBuyerMaker makers[]=null;
  protected int itemCount=6;
  boolean doingDB2Gui=false;
  protected   DataBindJCombobox dbCbxCenter,dbCbxCountry,dbCbxDep;
  protected   DataBindTextWithChecker dbTxtDateBgn,dbTxtDateEnd,dbTxtCreateTo,dbTxtCreateFrom,dbTxtStyle,dbTxtPo,dbTxtBuyerLabel;
  public PnlDelSchedualRpt() {
    try {
      //jbInit();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }

  public  void jbInit() throws Exception {
    buyers=new SelectBuyerMaker[itemCount];
    makers=new SelectBuyerMaker[itemCount];

  for(int i=0;i<itemCount;i++){
    buyers[i]=new SelectBuyerMaker();
    buyers[i].init("",null,buyers[0].TYPE_BUYER,true);
    makers[i]=new SelectBuyerMaker();
    makers[i].init("",null,makers[0].TYPE_MAKER,true);
  }

    border1 = new EtchedBorder(EtchedBorder.RAISED,Color.white,new Color(142, 142, 157));
    titledBorder1 = new TitledBorder(border1,"Buyers");
    border2 = new EtchedBorder(EtchedBorder.RAISED,Color.white,new Color(142, 142, 157));
    titledBorder2 = new TitledBorder(border2,"Makers");
    blueBkgWhiteCharLabel1.setBounds(new Rectangle(0, 7, 800, 18));
    blueBkgWhiteCharLabel1.setText("DELIVERY SCHEDULE REPORT");
    this.setLayout(null);
    txtDelTo.setBounds(new Rectangle(580, 69, 71, 21));
    txtDelTo.setText("");
    lblDDFrom.setBounds(new Rectangle(366, 69, 80, 21));
    lblDDFrom.setText("DEL. FROM:");
    lblCountry.setText("COUNTRY");
    lblCountry.setBounds(new Rectangle(195, 34, 74, 19));
    lblCenter.setText("CENTER");
    lblCenter.setBounds(new Rectangle(1, 34, 82, 19));
    lblYear2.setBounds(new Rectangle(527, 69, 37, 20));
    lblYear2.setText("TO:");
    cbxCountry.setBounds(new Rectangle(256, 34, 124, 19));
    txtDelFrom.setBounds(new Rectangle(446, 69, 71, 21));
    txtDelFrom.setText("");
    cbxCenter.setBounds(new Rectangle(47, 34, 126, 19));
    pnlMakers.setLayout(null);
    pnlMakers.setBounds(new Rectangle(187, 62, 175, 193));
    pnlMakers.setBackground(new Color(204, 204, 225));
    pnlMakers.setBorder(titledBorder2);
    pnlBuyers.setBackground(new Color(204, 204, 225));
    pnlBuyers.setBorder(titledBorder1);
    pnlBuyers.setBounds(new Rectangle(6, 62, 175, 193));
    pnlBuyers.setLayout(null);
    this.setBackground(new Color(202, 202, 224));
    jLabel1.setText("DEP.");
    jLabel1.setBounds(new Rectangle(404, 34, 60, 19));
    cbxDep.setBounds(new Rectangle(444, 34, 136, 19));
    txtCreateTo.setText("");
    txtCreateTo.setBounds(new Rectangle(581, 97, 71, 21));
    lblDDFrom1.setText("Create FROM:");
    lblDDFrom1.setBounds(new Rectangle(367, 97, 80, 21));
    lblYear3.setText("TO:");
    lblYear3.setBounds(new Rectangle(528, 97, 37, 20));
    txtCreateFrom.setText("");
    txtCreateFrom.setBounds(new Rectangle(447, 97, 71, 21));
    jLabel2.setText("Buyer Label");
    jLabel2.setBounds(new Rectangle(367, 164, 75, 19));
    txtBuyerLabel.setText("");
    txtBuyerLabel.setBounds(new Rectangle(432, 164, 136, 19));
    jLabel3.setBounds(new Rectangle(368, 197, 75, 19));
    jLabel3.setText("STYLE:");
    txtStyle.setBounds(new Rectangle(432, 197, 136, 19));
    txtStyle.setText("");
    jLabel4.setBounds(new Rectangle(368, 230, 75, 19));
    jLabel4.setText("P.O.:");
    txtPo.setBounds(new Rectangle(432, 230, 136, 19));
    txtPo.setText("");
    btnQry.setBounds(new Rectangle(619, 214, 122, 30));
    btnQry.setFont(new java.awt.Font("Dialog", 1, 11));
    btnQry.setText("REPORT");
    btnQry.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnQry_actionPerformed(e);
      }
    });
    this.add(blueBkgWhiteCharLabel1, null);
    this.add(lblCenter, null);
    this.add(lblDDFrom, null);
    this.add(txtDelFrom, null);
    this.add(txtDelTo, null);

    buyers[0].setBounds(new Rectangle(8, 24, 160, 18));
    buyers[1].setBounds(new Rectangle(8, 51, 160, 18));
    buyers[3].setBounds(new Rectangle(8, 104, 160, 18));
    buyers[4].setBounds(new Rectangle(8, 131, 160, 18));
    buyers[2].setBounds(new Rectangle(8, 78, 160, 18));

    makers[2].setBounds(new Rectangle(9, 78, 160, 18));
    makers[4].setBounds(new Rectangle(9, 133, 160, 18));
    makers[1].setBounds(new Rectangle(9, 51, 160, 18));
    makers[0].setBounds(new Rectangle(9, 23, 160, 18));
    makers[3].setBounds(new Rectangle(9, 106, 160, 18));


    buyers[5].setBounds(new Rectangle(8, 158, 160, 18));
    makers[5].setBounds(new Rectangle(9, 158, 160, 18));

    pnlMakers.add(makers[0], null);
    pnlMakers.add(makers[5], null);
    pnlMakers.add(makers[4], null);
    pnlMakers.add(makers[3], null);
    pnlMakers.add(makers[2], null);
    pnlMakers.add(makers[1], null);
    pnlBuyers.add(buyers[5], null);
    pnlBuyers.add(buyers[4], null);
    pnlBuyers.add(buyers[3], null);
    pnlBuyers.add(buyers[2], null);
    pnlBuyers.add(buyers[1], null);
    pnlBuyers.add(buyers[0], null);
    this.add(pnlMakers, null);
    this.add(pnlBuyers, null);
    this.add(txtCreateTo, null);
    this.add(lblDDFrom1, null);
    this.add(lblYear3, null);
    this.add(txtCreateFrom, null);
    this.add(cbxCenter, null);
    this.add(lblCountry, null);
    this.add(jLabel1, null);
    this.add(cbxDep, null);
    this.add(cbxCountry, null);
    this.add(btnQry, null);
    this.add(jLabel3, null);
    this.add(jLabel4, null);
    this.add(txtPo, null);
    this.add(txtStyle, null);
    this.add(jLabel2, null);
    this.add(txtBuyerLabel, null);
    genDataBindObj();
  }
  protected void genDataBindObj(){
    try{
      doingDB2Gui = true;
      dataBindComps.clear();
      boolean isAllDep=true;
      if(util.PublicVariable.USER_RECORD.getInt(2)==newtimesejb.preproduction.PreProductionHead.USER_TYPE_MANAGER ||
           util.PublicVariable.USER_RECORD.getInt(2)==newtimesejb.preproduction.PreProductionHead.USER_TYPE_USERS){
          isAllDep=false;
        }

      java.util.Vector depVects=
          newtimes.preproduction.guis.tempProperties.tmpDepartment;
         dbCbxDep =
            (isAllDep)?
            new exgui.DataBindJCombobox(
            cbxDep, "P_DEP",
            depVects,
            "DEP_NAME", "DEP_CODE",
            null,
            "ALL", "ALL"):
          new exgui.DataBindJCombobox(
              cbxDep, "P_DEP",
              depVects,
              "DEP_NAME", "DEP_CODE",
              null);
      dataBindComps.add(dbCbxDep);


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


      dbTxtCreateFrom =
          new exgui.DataBindTextWithChecker(txtCreateFrom, "P_C_FM", null,
                                            10, (exgui.Object2String)dateVfy,
                                            (exgui.ultratable.
                                             CellTxtEditorFormat)dateVfy);
      dataBindComps.add(dbTxtCreateFrom);

      dbTxtCreateTo =
          new exgui.DataBindTextWithChecker(txtCreateTo, "P_C_TO", null,
                                            10, (exgui.Object2String)dateVfy,
                                            (exgui.ultratable.
                                             CellTxtEditorFormat)dateVfy);
      dataBindComps.add(dbTxtCreateTo);


      dbCbxCountry =
          new exgui.DataBindJCombobox(
          cbxCountry, "P_CO",
          newtimes.preproduction.guis.tempProperties.tmpCountries,
          "CNTY_NAME", "CNTY_NAME", "ALL", "ALL", null);
      dataBindComps.add(dbCbxCountry);


      dbCbxCenter =
           new exgui.DataBindJCombobox(
           cbxCenter, "P_CENTER",
          newtimes.preproduction.guis.tempProperties.tmpCenters,
           "CEN_NAME", "CEN_CODE",
           (String)util.PublicVariable.USER_RECORD.get("usr_cen_code"));
      dataBindComps.add(dbCbxCenter);
      /*
        Object objCnv=exgui.verification.CellFormat.getOrdinaryField(4);
      exgui.DataBindTextWithChecker  dbTxtYear=new  exgui.DataBindTextWithChecker(
                txtYear,"P_YEAR",
                null,4,
                (exgui.Object2String)objCnv,
                (exgui.ultratable.CellTxtEditorFormat)objCnv);
     dataBindComps.add(dbTxtYear);*/

      Object styleVfy = exgui.verification.CellFormat.getOrdinaryField(30);
      dbTxtStyle  =
          new exgui.DataBindTextWithChecker(txtStyle, "P_STYLE", null,
                                            30, (exgui.Object2String)styleVfy,
                                            (exgui.ultratable.
                                             CellTxtEditorFormat)styleVfy);
      dataBindComps.add(dbTxtStyle);

      dbTxtPo =
          new exgui.DataBindTextWithChecker(txtPo, "P_PO", null,
                                            30, (exgui.Object2String)styleVfy,
                                            (exgui.ultratable.
                                             CellTxtEditorFormat)styleVfy);
      dataBindComps.add(dbTxtPo);


      Object BuyerLabelVfy = exgui.verification.CellFormat.getOrdinaryField(50);
      dbTxtBuyerLabel  =
          new exgui.DataBindTextWithChecker(txtBuyerLabel, "P_LABEL", null,
                                            50, (exgui.Object2String)BuyerLabelVfy,
                                            (exgui.ultratable.
                                             CellTxtEditorFormat)BuyerLabelVfy);
      dataBindComps.add(dbTxtBuyerLabel);
      super.reportName="HK_SCH.rpt";
     doingDB2Gui=false;
    }catch(Exception exp){
      exp.printStackTrace();

    }
  }
  protected java.util.HashMap composeParameters(){
    HashMap hm = super.composeParameters();
    StringBuffer sb=new StringBuffer();
    for(int i=0;i<itemCount;i++){
      Object buyObj=buyers[i].getSelectedValue();
      if(buyObj!=null){
        if(sb.length()>0)sb.append(",");
        sb.append(buyObj.toString());
        /*
        sb.append("'");
        sb.append(util.MiscFunc.Replace(((javax.swing.JTextField)buyers[i].getGUIcomponent()).getText(),"'","''''") );
        sb.append("'");
        */
      }
    }
    if(sb.length()>0){
      hm.put("P_BUYER","["+sb.toString()+"]");
    }else{
      hm.put("P_BUYER","[0]");
    }

    StringBuffer sb2=new StringBuffer();
    for(int i=0;i<itemCount;i++){
      Object makObj=makers[i].getSelectedValue();
      if(makObj!=null){
        if(sb2.length()>0)sb2.append(",");
        sb2.append(makObj.toString());
        /*
        sb2.append("'");
        sb2.append(util.MiscFunc.Replace(((javax.swing.JTextField)makers[i].getGUIcomponent()).getText(),"'","''''") );
        sb2.append("'");*/
      }
    }
    if(sb2.length()>0){
      hm.put("P_MAKER","["+sb2.toString()+"]");
    }else{
      hm.put("P_MAKER","[0]");
    }

    if(txtCreateFrom.getText().trim().length()==0){
      hm.put("P_C_FM","DATE(2000,01,01)");
    }
    if(txtCreateTo.getText().trim().length()==0){
      hm.put("P_C_TO","DATE(2099,12,31)");
    }

    Object dateBgn=dbTxtDateBgn.getSelectedValue();
    Object dateEnd=dbTxtDateEnd.getSelectedValue();
    if(dateBgn==null){
      hm.put("P_DEL_FM","DATE(2000,01,01)");
    }
    if(dateEnd==null){
      hm.put("P_DEL_TO","DATE(2099,12,31)");
    }
    if(txtStyle.getText().trim().length()==0){
      hm.put("P_STYLE","ALL");
    }
    if(txtPo.getText().trim().length()==0){
      hm.put("P_PO","ALL");
    }
    if(txtBuyerLabel.getText().trim().length()==0){
      hm.put("P_LABEL","ALL");
    }

    return hm;
  }

  void btnQry_actionPerformed(ActionEvent e) {
     super.JButtonQueryButtonAction(e);
  }
}
