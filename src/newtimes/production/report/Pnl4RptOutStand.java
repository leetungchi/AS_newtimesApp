package newtimes.production.report;
import java.awt.*;
import exgui.*;
import javax.swing.*;
import javax.swing.border.*;
import newtimes.preproduction.buyermakerselect.*;
import java.util.*;
import java.awt.event.*;
import newtimes.preproduction.guis.*;
import newtimesejb.preproduction.PreProductionHead;
/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class Pnl4RptOutStand
    //extends JPanel {
    extends AbsQryPanel{
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel1 = new BlueBkgWhiteCharLabel();
  TitledBorder titledBorder1;
  JLabel jLabel1 = new JLabel();
  JTextField txtFromDate = new JTextField();
  JButton btnQry = new JButton();
  exgui.DataBindJCombobox dbCbxDep,dbCbxCenter,DbJcbxcbxMgrs;
  JComboBox cbxCenter=new JComboBox();
  exgui.DataBindTextWithChecker  dbTxtFromDate;
  JComboBox cbxDep = new JComboBox();
  JLabel jLabel2 = new JLabel();
  JLabel jLabel3 = new JLabel();
  JLabel jLabel4 = new JLabel();
  JComboBox cbxMgrs = new JComboBox();
  newtimesejb.preproduction.PreProductionHead prdHead;
  JLabel lblToExcludeSC = new JLabel();
  ButtonGroup buttonGroup1 = new ButtonGroup();
  JRadioButton rdoXcldSCNULL = new JRadioButton();
  JRadioButton rdoIncludeSCNULL = new JRadioButton();
public Pnl4RptOutStand(){
  try{
    //jbInit();
  }catch(Exception exp){
  }
}
protected void jbInit()throws Exception{
  setBackground(new Color(204, 204, 225));
    titledBorder1 = new TitledBorder(BorderFactory.createEtchedBorder(Color.white,new Color(148, 145, 140)),"DEPARTMENTS");
    blueBkgWhiteCharLabel1.setText("OUTSTANDING AMOUNT REPORT BY BUYER");
    blueBkgWhiteCharLabel1.setBounds(new Rectangle(0, 4, 799, 30));
    this.setLayout(null);
    /*
    cbxDep[1].setBounds(new Rectangle(294, 21, 182, 22));
    cbxDep[2].setBounds(new Rectangle(294, 53, 182, 22));
    cbxDep[3].setBounds(new Rectangle(12, 85, 182, 22));
    cbxDep[4].setBounds(new Rectangle(12, 53, 182, 22));
    cbxDep[5].setBounds(new Rectangle(294, 85, 182, 22));
    */
    jLabel1.setText("<html><body>DELAY DATE:<br>(MAXIMUM)</body</html>");
    jLabel1.setBounds(new Rectangle(576, 39, 83, 40));
    txtFromDate.setText("");
    txtFromDate.setBounds(new Rectangle(667, 42, 115, 22));
    btnQry.setBounds(new Rectangle(688, 116, 96, 27));
    btnQry.setFont(new java.awt.Font("Dialog", 1, 11));
    btnQry.setText("REPORT");
    btnQry.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnQry_actionPerformed(e);
      }
    });

    cbxDep.setBounds(new Rectangle(156, 83, 181, 22));
    jLabel2.setText("DEPARTMENT");
    jLabel2.setBounds(new Rectangle(27, 83, 104, 24));
    jLabel3.setText("CENTER");
    jLabel3.setBounds(new Rectangle(27, 41, 104, 25));
    cbxCenter.setBounds(new Rectangle(157, 43, 178, 23));
    jLabel4.setText("MANAGER:");
    jLabel4.setBounds(new Rectangle(364, 82, 73, 25));
    cbxMgrs.setBounds(new Rectangle(433, 83, 200, 22));
    lblToExcludeSC.setText("EXCLUDE S/C NO IS SPACE:");
    lblToExcludeSC.setBounds(new Rectangle(27, 118, 213, 29));
    rdoXcldSCNULL.setBackground(new Color(204, 204, 225));
    rdoXcldSCNULL.setText("YES");
    rdoXcldSCNULL.setBounds(new Rectangle(248, 117, 79, 29));
    rdoIncludeSCNULL.setBackground(new Color(204, 204, 225));
    rdoIncludeSCNULL.setSelected(true);
    rdoIncludeSCNULL.setText("NO");
    rdoIncludeSCNULL.setBounds(new Rectangle(346, 117, 101, 29));
    this.add(blueBkgWhiteCharLabel1, null);
    this.add(cbxCenter, null);
    this.add(jLabel1, null);
    this.add(txtFromDate, null);
    this.add(cbxDep, null);
    this.add(jLabel4, null);
    this.add(cbxMgrs, null);
    this.add(btnQry, null);
    this.add(jLabel2, null);
    this.add(jLabel3, null);
    this.add(lblToExcludeSC, null);
    genDataBindObj();
    buttonGroup1.add(rdoXcldSCNULL);
    this.add(rdoXcldSCNULL, null);
    this.add(rdoIncludeSCNULL, null);
    buttonGroup1.add(rdoIncludeSCNULL);
  }
 protected void genDataBindObj(){
   try{
     dataBindComps.clear();
     dbCbxCenter =
         new exgui.DataBindJCombobox(
         cbxCenter, "CENTER_CODE",
         newtimes.preproduction.guis.tempProperties.tmpCenters,
         "CEN_NAME", "CEN_CODE",
         (String)util.PublicVariable.USER_RECORD.get("usr_cen_code"));
     dataBindComps.add(dbCbxCenter);

     Vector depVects =
         (Vector)newtimes.preproduction.guis.tempProperties.
         tmpH_tbl_CenterDepMap.get(
         dbCbxCenter.getSelectedValue());
       dbCbxDep =
           new exgui.DataBindJCombobox(
           cbxDep, "DEP",
           depVects,
           "DEP_NAME", "DEP_CODE",
           (String)util.PublicVariable.USER_RECORD.get("usr_Dep_code"));
     dataBindComps.add(dbCbxDep);

        Object dateVfy = exgui.verification.CellFormat.getDateStringFormaterAllowNull();
      dbTxtFromDate=new  exgui.DataBindTextWithChecker(
               txtFromDate,"ENT_DATE",
               new java.sql.Date(System.currentTimeMillis()),10,
               (exgui.Object2String)dateVfy,
               (exgui.ultratable.CellTxtEditorFormat)dateVfy);


           if(util.PublicVariable.USER_RECORD.getInt("usr_type")==
              prdHead.USER_TYPE_DIRECTOR){
             DbJcbxcbxMgrs =
                 new exgui.DataBindJCombobox(
                   cbxMgrs,prdHead.CONDITION_KEY_WITH_MANAGER,
                   tempProperties.tmpManagerRecs,
                   "MNG_ABBR","MNG_CODE",null,"ALL",null);

           }
           if(util.PublicVariable.USER_RECORD.getInt("usr_type")==
              prdHead.USER_TYPE_MANAGER){
             if(((String)util.PublicVariable.USER_RECORD.get("USR_MNG_MOD")).
                equalsIgnoreCase("y")){
                DbJcbxcbxMgrs =
                   new exgui.DataBindJCombobox(
                     cbxMgrs,prdHead.CONDITION_KEY_WITH_MANAGER,
                     tempProperties.tmpManagerRecs,
                     "MNG_ABBR","MNG_CODE",null,"ALL",null);

             }else{
                DbJcbxcbxMgrs =
                   new exgui.DataBindJCombobox(
                     cbxMgrs,prdHead.CONDITION_KEY_WITH_MANAGER,
                     tempProperties.tmpManagerRecs,
                     "MNG_ABBR","MNG_CODE",
                     util.PublicVariable.USER_RECORD.get("USR_MNG_CODE_DF"));

             }
           }else  if(util.PublicVariable.USER_RECORD.getInt("usr_type")==
              prdHead.USER_TYPE_USERS){
              DbJcbxcbxMgrs =
                 new exgui.DataBindJCombobox(
                   cbxMgrs,prdHead.CONDITION_KEY_WITH_MANAGER,
                   tempProperties.tmpManagerRecs,
                   "MNG_ABBR","MNG_CODE",
                   util.PublicVariable.USER_RECORD.get("USR_MNG_CODE_DF"),
                   "None Manager","None Manager");

           }else{
              DbJcbxcbxMgrs =
                 new exgui.DataBindJCombobox(
                   cbxMgrs,prdHead.CONDITION_KEY_WITH_MANAGER,
                   tempProperties.tmpManagerRecs,
                   "MNG_ABBR","MNG_CODE",null,"ALL",null);

           }
    //dataBindComps.add(dbTxtFromDate);
     reportName="OUTST.RPT";
   }catch(Exception exp){
       exp.printStackTrace();
   }
 }
 protected java.util.HashMap composeParameters(){
   HashMap hm=super.composeParameters();
   Object dateBgn=dbTxtFromDate.getSelectedValue();
   java.util.Calendar dateEntry=java.util.Calendar.getInstance();
   if(dateBgn==null){
     hm.put("ENT_DATE","DATE(2000,01,01)");
     dateEntry.setTimeInMillis(util.MiscFunc.toDate000000(2001,1,1).getTime()+1000);
   }else{
     dateEntry.setTimeInMillis(((java.util.Date)dateBgn).getTime());
     hm.put("ENT_DATE",convertDate2QueryPara(
      new java.sql.Date(
      ((java.util.Date)dateBgn).getTime())));
   }
   dateEntry.add(dateEntry.MONTH,1);
   java.sql.Date time1=new java.sql.Date(dateEntry.getTimeInMillis());
   dateEntry.add(dateEntry.MONTH,1);
   java.sql.Date time2=new java.sql.Date(dateEntry.getTimeInMillis());
   dateEntry.add(dateEntry.MONTH,1);
   java.sql.Date time3=new java.sql.Date(dateEntry.getTimeInMillis());
   hm.put("DATE_1",convertDate2QueryPara(time1));
   hm.put("DATE_2",convertDate2QueryPara(time2));
   hm.put("DATE_3",convertDate2QueryPara(time3));
   Object dbMgrObj=DbJcbxcbxMgrs.getSelectedValue();
   if(dbMgrObj==null){
     hm.put("MNG_CODE","ALL");
   }else{
     hm.put("MNG_CODE",dbMgrObj.toString());
   }
   if(rdoXcldSCNULL.isSelected()){
     hm.put("EXC_SC","Y");
   }else{
     hm.put("EXC_SC","N");
   }
   return hm;
 }

  void btnQry_actionPerformed(ActionEvent e) {
     if(txtFromDate.getText().trim().length()==0){
       exgui.verification.VerifyLib.showAlert("Please Input \"From Date\"","Please Input \"From Date\"");
       txtFromDate.grabFocus();
       return;
     }
     JButtonQueryButtonAction(e);
  }
}
