package newtimes.tpe_user_report;

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

public class PnlRptMmExp
    //extends JPanel {
    extends AbsQryPanel{
 protected int itemCount=9;
 protected BlueBkgWhiteCharLabel blueBkgWhiteCharLabel1 = new BlueBkgWhiteCharLabel();
 protected   JComboBox cbxCenter = new JComboBox();
 protected   JLabel lblSeason = new JLabel();
 protected   JComboBox cbxSeason = new JComboBox();
 protected   TitledBorder titledBorder1;
  protected   JComboBox cbxDep=null;
 protected   TitledBorder titledBorder2;
 protected   Border border1;
 protected   TitledBorder titledBorder3;
 protected   JLabel lblYear = new JLabel();
  protected  JTextField txtYear = new JTextField();
 protected   JButton btnQry = new JButton();
 protected   JTextField txtTwdUsd=new JTextField();
 protected   JTextField txtHkdUsd=new JTextField();
 protected   JTextField txtRmbUsd=new JTextField();
 protected   DataBindJCombobox dbCbxCenter,dbCbxCountry,dbCbxDep,dbCbxSzn,dbCbxProdType,dbCbxManager ;
 protected   DataBindJCombobox dbCbxDivision;
 protected boolean doingDB2Gui=false;
 newtimesejb.preproduction.PreProductionHead prdHead;
 int divCbxDBGUI_index=0,indexCbxMng;
 MyTextField txtProdHeadPk[]=new MyTextField[16];
  public PnlRptMmExp() {
    try {
      //jbInit();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }

  class MyTextField
      extends JTextField
     implements java.awt.event.FocusListener
     {
    int indexInArr;
    MyTextField(){
       super();
       this.addFocusListener(this);
    }
    public void focusGained(java.awt.event.FocusEvent fe){
      //if current cell is blank ,find out the "next" prod-ref-pk
      if(indexInArr!=0 && this.getText().trim().length()==0){
        //search last text field's prod head pk
        for(int i=indexInArr-1;i>-1;i--){
          String prodHeadPkStr=txtProdHeadPk[i].getText().trim();
          if(prodHeadPkStr.length()>0){
            int prodheadpk=Integer.parseInt(prodHeadPkStr);
            this.setText(String.valueOf(prodheadpk+1));
            break;
          }
        }
      }
    }
    public void focusLost(java.awt.event.FocusEvent fe){

    }
  }


 protected void jbInit() throws Exception {

      //dbCbxDep=new exgui.DataBindJCombobox[itemCount];
      cbxDep=new JComboBox();

    titledBorder1 = new TitledBorder(BorderFactory.createEtchedBorder(Color.white,new Color(142, 142, 157)),"DEPARTMENTS");
    titledBorder2 = new TitledBorder(BorderFactory.createEtchedBorder(Color.white,new Color(148, 145, 140)),"MAKERS");
    border1 = BorderFactory.createEtchedBorder(Color.white,new Color(142, 142, 157));
    titledBorder3 = new TitledBorder(border1,"BUYERS");
    border2 = BorderFactory.createEmptyBorder();
    titledBorder4 = new TitledBorder(border2,"PROD REF#");
    setBackground(new Color(204, 204, 225));
    blueBkgWhiteCharLabel1.setText("COLOR SIZE DETAIL");
    blueBkgWhiteCharLabel1.setBounds(new Rectangle(0, 0, 800, 18));
    this.setLayout(null);
    cbxCenter.setBounds(new Rectangle(568, 51, 126, 22));
    lblSeason.setBounds(new Rectangle(7, 49, 62, 17));
    lblSeason.setText("SEASON");
    cbxSeason.setBounds(new Rectangle(85, 48, 126, 20));

    cbxDep.setBounds(new Rectangle(85, 73, 126, 22));




    lblYear.setText("YEAR:");
    lblYear.setBounds(new Rectangle(22, 21, 55, 20));
    txtYear.setText("");
    txtYear.setBounds(new Rectangle(85, 21, 126, 21));
    btnQry.setBounds(new Rectangle(702, 48, 91, 30));
    btnQry.setFont(new java.awt.Font("Dialog", 1, 11));
    btnQry.setText("QUERY");
    btnQry.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnQry_actionPerformed(e);
      }
    });
    lblUnship.setBounds(new Rectangle(536, 109, 224, 28));
    lblUnship.setText("UNSHIP:");
    lblDivision.setText("DIVISION");
    lblDivision.setBounds(new Rectangle(5, 97, 60, 22));
    cbxDivision.setBounds(new Rectangle(57, 97, 154, 21));
    lblDep.setText("DEPARTMENT");
    lblDep.setBounds(new Rectangle(7, 73, 80, 21));
    jLabel1.setText("GROUP NAME");
    jLabel1.setBounds(new Rectangle(4, 124, 84, 24));
    txtGroup.setText("");
    txtGroup.setBounds(new Rectangle(92, 125, 119, 23));
    pnlProdHeadPk.setBackground(new Color(202, 202, 224));
    pnlProdHeadPk.setBorder(titledBorder4);
    pnlProdHeadPk.setBounds(new Rectangle(224, 24, 470, 123));
    pnlProdHeadPk.setLayout(gridLayout1);
    jLabel2.setBounds(new Rectangle(3, 147, 77, 24));
    jLabel2.setText("GROUP NO");
    txtGroupNo.setBounds(new Rectangle(92, 150, 119, 23));
    txtGroupNo.setText("");
    this.add(blueBkgWhiteCharLabel1, null);
    this.add(cbxCenter, null);



    this.add(cbxSeason, null);
    this.add(lblSeason, null);
    this.add(lblDivision, null);
    this.add(btnQry, null);
    this.add(lblYear, null);
    this.add(txtYear, null);
    //this.add(lblUnship, null);

    this.add(lblDivision, null);
    this.add(cbxDivision, null);
    this.add(cbxDivision, null);
    this.add(pnlProdHeadPk, null);
    this.add(txtGroup, null);
    this.add(cbxDivision, null);
    this.add(cbxDep, null);
    this.add(lblSeason, null);
    this.add(lblYear, null);
    this.add(txtYear, null);
    this.add(cbxSeason, null);
    this.add(jLabel1, null);
    this.add(lblDivision, null);
    this.add(lblDep, null);

    /*
    this.add(lblDep, null);
    this.add(cbxDep, null);
    this.add(cbxDivision, null);
    this.add(lblYear, null);
    this.add(txtYear, null);
    this.add(cbxSeason, null);
    this.add(btnQry, null);
    this.add(lblDivision, null);
    this.add(lblSeason, null);
    this.add(cbxCenter, null);
    this.add(lblDivision, null);
    this.add(cbxDivision, null);
    this.add(lblYear, null);
    this.add(txtYear, null);
    this.add(lblSeason, null);
    this.add(cbxSeason, null);
    this.add(jLabel1, null);
    this.add(txtGroup, null);
    */

    cbxCenter.setVisible(false);
    Object chkDcm32 = exgui.verification.CellFormat.getIntVerifierAllowNull(20);
    for(int i=0;i<16;i++){
      txtProdHeadPk[i]=new MyTextField();
      txtProdHeadPk[i].indexInArr=i;
      exgui.DataBindTextWithChecker xfvytxt =
        new exgui.DataBindTextWithChecker(txtProdHeadPk[i],null,null,10,
                                         (exgui.Object2String)chkDcm32,
                                         (exgui.ultratable.CellTxtEditorFormat)chkDcm32);
      pnlProdHeadPk.add(txtProdHeadPk[i]);
    }
    genDataBindObj();
  }
  protected void genDataBindObj(){
    try{
      doingDB2Gui=true;
      dataBindComps.clear();

      StringBuffer sb=new StringBuffer();
      sb.append("select a.Div_code,a.div_name from division a,buyer_maker b ");
      sb.append("where A.DIV_BYMKR_SEQ=B.BYMKR_SEQ ");
      sb.append("and B.SELECTABLE_CENTER like '%,001,%' ");
      sb.append("and B.BYMKR_NAME like '%KOMAR%' ");
      Vector vctDivs
          =exgui2.CONST.BASIC_MAIN_EJB.getDatas(
          util.PublicVariable.USER_RECORD,
          sb.toString(),1,99999);
      divCbxDBGUI_index=  dataBindComps.size();
      dbCbxDivision =
          new exgui.DataBindJCombobox(
          cbxDivision, "P_DIV",
          vctDivs,
          "DIV_NAME", "DIV_CODE", "ALL", "ALL", null);
      dataBindComps.add(dbCbxDivision);



      dbCbxCenter =
           new exgui.DataBindJCombobox(
           cbxCenter, "P_CENTER",
          newtimes.preproduction.guis.tempProperties.tmpCenters,
           "CEN_NAME", "CEN_CODE",
           (String)util.PublicVariable.USER_RECORD.get("usr_cen_code"));
      //dataBindComps.add(dbCbxCenter);

      Vector seasons=newtimes.preproduction.guis.tempProperties.tmpSeason;
      dbCbxSzn= new exgui.DataBindJCombobox(
          cbxSeason,"P_SEASON",
          seasons,"SEA_NAME","SEA_NAME","ALL","ALL",null);
      dataBindComps.add(dbCbxSzn);

        Object objCnv=exgui.verification.CellFormat.getOrdinaryField(4);
      exgui.DataBindTextWithChecker  dbTxtYear=new  exgui.DataBindTextWithChecker(
                txtYear,"P_YEAR",
                null,4,
                (exgui.Object2String)objCnv,
                (exgui.ultratable.CellTxtEditorFormat)objCnv);
     dataBindComps.add(dbTxtYear);
      this.add(jLabel1, null);
      this.add(jLabel2, null);
      this.add(txtGroupNo, null);

       reportName = "MM_EXP.rpt";
     doingDB2Gui=false;
     cbxCenter.addItemListener(new cbxCenterItemChanged());
     cbxCenter.getItemListeners()[0].itemStateChanged(null);
   }catch(Exception exp){
      exp.printStackTrace();
   }
 }
 class cbxCenterItemChanged implements java.awt.event.ItemListener {
   public void itemStateChanged(ItemEvent e) {
     if(doingDB2Gui)return;
      udpateDepComboBox();
   }
 }

 protected void udpateDepComboBox(){
   boolean haveAllDep=true;
   if(util.PublicVariable.USER_RECORD.getInt(2)==newtimesejb.preproduction.PreProductionHead.USER_TYPE_MANAGER ||
    util.PublicVariable.USER_RECORD.getInt(2)==newtimesejb.preproduction.PreProductionHead.USER_TYPE_USERS){
    haveAllDep=false;
   }
   if(!haveAllDep){
     Vector depVects=
         (Vector)newtimes.preproduction.guis.tempProperties.tmpH_tbl_CenterDepMap.get(
         dbCbxCenter.getSelectedValue());
       dbCbxDep =
           new exgui.DataBindJCombobox(
           cbxDep, "P_DEP",
           depVects,
           "DEP_NAME", "DEP_CODE",
           "ALL");
     return;
   }

   Vector depVects=
       (Vector)newtimes.preproduction.guis.tempProperties.tmpH_tbl_CenterDepMap.get(
       dbCbxCenter.getSelectedValue());
     try{
       dbCbxDep =
           new exgui.DataBindJCombobox(
           cbxDep, "P_DEP",
           depVects,
           "DEP_NAME", "DEP_CODE",
           (String)util.PublicVariable.USER_RECORD.get("USR_DEP_CODE"),
           "ALL",null );
     }catch(Exception exp){
       exp.printStackTrace();
     }
     //dataBindComps.add(dbCbxDep[i]);

   String usingCenterCode=(String)dbCbxCenter.getSelectedValue();
    if(usingCenterCode==null || usingCenterCode.trim().length()==0)usingCenterCode=(String)util.PublicVariable.OPERATTING_CENTER;


 }

  protected java.util.HashMap composeParameters(){
    HashMap hm = super.composeParameters();
    if(txtYear.getText().trim().length()==0){
      hm.put("P_YEAR","ALL");
    }
    hm.put("P_DEP",(dbCbxDep.getSelectedValue()==null)?"ALL":(String)dbCbxDep.getSelectedValue());
    hm.put("P_GROUP",txtGroup.getText().trim().length()==0?"ALL":txtGroup.getText().trim());
    hm.put("P_GROUP_NO",txtGroupNo.getText().trim().length()==0?"ALL":txtGroupNo.getText().trim());
    StringBuffer sb=new StringBuffer();
    for(int i=0;i<txtProdHeadPk.length;i++){
      String prodHeadPk=txtProdHeadPk[i].getText().trim();
      if(prodHeadPk.length()>0){
        if(sb.length()>0)sb.append(",");
        sb.append(String.valueOf(prodHeadPk));
      }
    }
    if(sb.length()==0){
      hm.put("P_PROD_PK","[0]");
    }else{
      hm.put("P_PROD_PK","["+sb.toString()+"]");
    }
    return hm;
  }

  void btnQry_actionPerformed(ActionEvent e) {
    //check if any field is empty,End date can not before than Begin date.
    String tempURL= newtimes.production.report.ReportProxyEngine.reportServerURL ;
    newtimes.production.report.ReportProxyEngine.reportServerURL="http://rpt2.nttpe.com.tw:9000/?file:///rpt//";
    JButtonQueryButtonAction(e);
    newtimes.production.report.ReportProxyEngine.reportServerURL=tempURL;
  }
  ButtonGroup buttonGroup1 = new ButtonGroup();
    ButtonGroup buttonGroup2 = new ButtonGroup();
  JLabel lblUnship = new JLabel();
  JLabel lblDivision = new JLabel();
  JComboBox cbxDivision = new JComboBox();
  JLabel lblDep = new JLabel();
  JLabel jLabel1 = new JLabel();
  JTextField txtGroup = new JTextField();
  JPanel pnlProdHeadPk = new JPanel();
  GridLayout gridLayout1 = new GridLayout(4,4);

  Border border2;
  TitledBorder titledBorder4;
  JLabel jLabel2 = new JLabel();
  JTextField txtGroupNo = new JTextField();
}
