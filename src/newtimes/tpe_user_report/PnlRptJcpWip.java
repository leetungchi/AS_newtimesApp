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

public class PnlRptJcpWip
    //extends JPanel {
    extends AbsQryPanel{
 protected int itemCount=9;
 protected BlueBkgWhiteCharLabel blueBkgWhiteCharLabel1 = new BlueBkgWhiteCharLabel();

 protected   JLabel lblSeason = new JLabel();
 protected   JComboBox cbxSeason = new JComboBox();
 protected   DataBindJCombobox dbCbxSzn;
 protected   JLabel lblYear = new JLabel();
  protected  JTextField txtYear = new JTextField();
 protected   JButton btnQry = new JButton();

 protected boolean doingDB2Gui=false;
 newtimesejb.preproduction.PreProductionHead prdHead;
 int divCbxDBGUI_index=0,indexCbxMng;

  public PnlRptJcpWip() {
    try {
      //jbInit();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }




 protected void jbInit() throws Exception {

      //dbCbxDep=new exgui.DataBindJCombobox[itemCount];

    //border2 = BorderFactory.createEmptyBorder();

    setBackground(new Color(204, 204, 225));
    blueBkgWhiteCharLabel1.setText("KOMAR JCP WIP EXPORT");
    blueBkgWhiteCharLabel1.setBounds(new Rectangle(0, 0, 800, 19));
    this.setLayout(null);

    lblSeason.setBounds(new Rectangle(7, 49, 62, 17));
    lblSeason.setText("SEASON");
    cbxSeason.setBounds(new Rectangle(85, 48, 126, 20));






    lblYear.setText("YEAR:");
    lblYear.setBounds(new Rectangle(22, 21, 55, 20));
    txtYear.setText("");
    txtYear.setBounds(new Rectangle(85, 21, 126, 21));
    btnQry.setBounds(new Rectangle(228, 45, 91, 30));
    btnQry.setFont(new java.awt.Font("Dialog", 1, 11));
    btnQry.setText("QUERY");
    btnQry.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnQry_actionPerformed(e);
      }
    });
/*
    pnlProdHeadPk.setBackground(new Color(202, 202, 224));
    pnlProdHeadPk.setBorder(titledBorder4);
    pnlProdHeadPk.setBounds(new Rectangle(224, 24, 470, 70));
    pnlProdHeadPk.setLayout(gridLayout1);
 */
    this.add(lblYear, null);
    this.add(txtYear, null);

    this.add(lblSeason, null);
     this.add(cbxSeason, null);
    this.add(btnQry, null);

    //this.add(lblUnship, null);




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


    Object chkDcm32 = exgui.verification.CellFormat.getIntVerifierAllowNull(20);

    genDataBindObj();
  }
  protected void genDataBindObj(){
    try{
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


       reportName = "MM_JCP_WIP.rpt&firstgroupassheets=true";
     doingDB2Gui=false;

   }catch(Exception exp){
      exp.printStackTrace();
   }
 }




  protected java.util.HashMap composeParameters(){
    HashMap hm = super.composeParameters();
    if(txtYear.getText().trim().length()==0){
      hm.put("P_YEAR","ALL");
    }
    hm.put("P_SEASON",cbxSeason.getSelectedItem().toString());
    return hm;
  }

  void btnQry_actionPerformed(ActionEvent e) {
    //check if any field is empty,End date can not before than Begin date.
    String tempURL= newtimes.production.report.ReportProxyEngine.reportServerURL ;
    newtimes.production.report.ReportProxyEngine.reportServerURL="http://rpt3.nttpe.com.tw:9000/?file:///rpt//";
    JButtonQueryButtonAction(e);
    newtimes.production.report.ReportProxyEngine.reportServerURL=tempURL;
  }
  /*
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
  */
}
