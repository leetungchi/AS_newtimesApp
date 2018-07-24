package newtimes.accounting;

import java.awt.*;
import exgui.*;
import javax.swing.*;
import java.awt.event.*;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class PnlQryFabComm extends JPanel {
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel1 = new BlueBkgWhiteCharLabel();
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel2 = new BlueBkgWhiteCharLabel();
  JButton btnExit = new JButton();
  JButton btnToListFabricComm = new JButton();
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel3 = new BlueBkgWhiteCharLabel();
  WhiteBkgBlueCharLabel whiteBkgBlueCharLabel1 = new WhiteBkgBlueCharLabel();
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel4 = new BlueBkgWhiteCharLabel();
  WhiteBkgBlueCharLabel whiteBkgBlueCharLabel2 = new WhiteBkgBlueCharLabel();
  WhiteBkgBlueCharLabel whiteBkgBlueCharLabel3 = new WhiteBkgBlueCharLabel();
  JTextField txtProdPk = new JTextField();
  JTextField txtPiNo = new JTextField();
  JTextField txtDelFrom = new JTextField();
  WhiteBkgBlueCharLabel whiteBkgBlueCharLabel4 = new WhiteBkgBlueCharLabel();
  JTextField txtDelTo = new JTextField();
  ButtonGroup buttonGrpPiRcvBlnk = new ButtonGroup();
  JRadioButton rdoPiRcvNullAble = new JRadioButton();
  JRadioButton rdoPiRcvNotNullAble = new JRadioButton();
  JRadioButton rdoPiRcvSelectAll = new JRadioButton();
  JRadioButton rdoDiscBlank = new JRadioButton();
  ButtonGroup buttonGrpDiscRcvBlank = new ButtonGroup();
  JRadioButton rdoDiscNotBlank = new JRadioButton();
  JRadioButton rdoDiscRcvAll = new JRadioButton();
  exgui.DataBindTextWithChecker dbTxtProdHeadPK,dbTxtFabCommPI,dbTxtDateBgn,dbTxtDateEnd;
  public PnlQryFabComm() {
    try {
      jbInit();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }

  void jbInit() throws Exception {
    setPreferredSize(new Dimension(800,600));
    blueBkgWhiteCharLabel1.setText("CONDITION TO QUERY FABRIC COMMISION");
    blueBkgWhiteCharLabel1.setBounds(new Rectangle(0, 14, 798, 32));
    this.setBackground(new Color(204, 204, 225));
    this.setLayout(null);
    blueBkgWhiteCharLabel2.setText("");
    blueBkgWhiteCharLabel2.setBounds(new Rectangle(-1, 533, 581, 30));
    btnExit.setBounds(new Rectangle(580, 533, 87, 30));
    btnExit.setFont(new java.awt.Font("Dialog", 1, 11));
    btnExit.setText("EXIT");
    btnExit.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnExit_actionPerformed(e);
      }
    });
    btnToListFabricComm.setText("QUERY");
    btnToListFabricComm.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnToListFabricComm_actionPerformed(e);
      }
    });
    btnToListFabricComm.setBounds(new Rectangle(318, 490, 87, 29));
    btnToListFabricComm.setFont(new java.awt.Font("Dialog", 1, 11));
    blueBkgWhiteCharLabel3.setText("PI No.:");
    blueBkgWhiteCharLabel3.setBounds(new Rectangle(89, 184, 147, 25));
    whiteBkgBlueCharLabel1.setText(" Ref No.");
    whiteBkgBlueCharLabel1.setBounds(new Rectangle(90, 83, 144, 21));
    blueBkgWhiteCharLabel4.setBounds(new Rectangle(90, 381, 281, 23));
    blueBkgWhiteCharLabel4.setText("PI RECEIVE DATE IS BLANK");
    whiteBkgBlueCharLabel2.setBounds(new Rectangle(89, 240, 144, 24));
    whiteBkgBlueCharLabel2.setText("DEL FROM");
    whiteBkgBlueCharLabel3.setText("DISCOUNT RECEIVE DATE IS BLANK");
    whiteBkgBlueCharLabel3.setBounds(new Rectangle(90, 430, 281, 24));
    txtProdPk.setText("");
    txtProdPk.setBounds(new Rectangle(233, 83, 219, 22));
    txtPiNo.setText("");
    txtPiNo.setBounds(new Rectangle(236, 183, 214, 25));
    txtDelFrom.setText("");
    txtDelFrom.setBounds(new Rectangle(232, 240, 79, 24));
    whiteBkgBlueCharLabel4.setText("TO");
    whiteBkgBlueCharLabel4.setBounds(new Rectangle(311, 240, 57, 24));
    txtDelTo.setText("");
    txtDelTo.setBounds(new Rectangle(367, 240, 85, 24));
    rdoPiRcvNullAble.setBackground(new Color(143, 143, 188));
    rdoPiRcvNullAble.setFont(new java.awt.Font("Dialog", 1, 11));
    rdoPiRcvNullAble.setAlignmentY((float) 0.5);
    rdoPiRcvNullAble.setSelected(true);
    rdoPiRcvNullAble.setText("YES");
    rdoPiRcvNullAble.setBounds(new Rectangle(371, 381, 61, 23));
    rdoPiRcvNotNullAble.setBounds(new Rectangle(431, 381, 61, 23));
    rdoPiRcvNotNullAble.setText("NO");
    rdoPiRcvNotNullAble.setAlignmentY((float) 0.5);
    rdoPiRcvNotNullAble.setSelected(true);
    rdoPiRcvNotNullAble.setBackground(new Color(143, 143, 188));
    rdoPiRcvNotNullAble.setFont(new java.awt.Font("Dialog", 1, 11));
    rdoPiRcvSelectAll.setBounds(new Rectangle(492, 381, 61, 23));
    rdoPiRcvSelectAll.setText("ALL");
    rdoPiRcvSelectAll.setAlignmentY((float) 0.5);
    rdoPiRcvSelectAll.setBackground(new Color(143, 143, 188));
    rdoPiRcvSelectAll.setFont(new java.awt.Font("Dialog", 1, 11));
    rdoDiscBlank.setBackground(Color.white);
    rdoDiscBlank.setFont(new java.awt.Font("Dialog", 1, 11));
    rdoDiscBlank.setForeground(new Color(143, 143, 188));
    rdoDiscBlank.setSelected(true);
    rdoDiscBlank.setText("YES");
    rdoDiscBlank.setBounds(new Rectangle(371, 430, 61, 24));
    rdoDiscNotBlank.setBounds(new Rectangle(431, 430, 61, 24));
    rdoDiscNotBlank.setText("NO");
    rdoDiscNotBlank.setForeground(new Color(143, 143, 188));
    rdoDiscNotBlank.setFont(new java.awt.Font("Dialog", 1, 11));
    rdoDiscNotBlank.setBackground(Color.white);
    rdoDiscRcvAll.setBounds(new Rectangle(492, 430, 61, 24));
    rdoDiscRcvAll.setText("ALL");
    rdoDiscRcvAll.setForeground(new Color(143, 143, 188));
    rdoDiscRcvAll.setSelected(false);
    rdoDiscRcvAll.setFont(new java.awt.Font("Dialog", 1, 11));
    rdoDiscRcvAll.setBackground(Color.white);
    blueBkgWhiteCharLabel5.setText("");
    blueBkgWhiteCharLabel5.setBounds(new Rectangle(666, 533, 136, 30));
    txtProdScNo.setBounds(new Rectangle(233, 284, 219, 22));
    txtProdScNo.setText("");
    blueBkgWhiteCharLabel6.setBounds(new Rectangle(90, 336, 147, 25));
    blueBkgWhiteCharLabel6.setText("SRN No.:");
    txtShipNo.setBounds(new Rectangle(237, 335, 214, 25));
    txtShipNo.setText("");
    whiteBkgBlueCharLabel5.setBounds(new Rectangle(90, 284, 144, 21));
    whiteBkgBlueCharLabel5.setText(" S/C No.");
    txtsupply.setBounds(new Rectangle(233, 129, 219, 22));
    txtsupply.setText("");
    whiteBkgBlueCharLabel6.setBounds(new Rectangle(90, 129, 144, 21));
    whiteBkgBlueCharLabel6.setText("SUPPLIER");
    this.add(blueBkgWhiteCharLabel1, null);
    this.add(blueBkgWhiteCharLabel2, null);
    this.add(whiteBkgBlueCharLabel1, null);
    this.add(txtProdPk, null);
    buttonGrpPiRcvBlnk.add(rdoPiRcvNullAble);
    buttonGrpPiRcvBlnk.add(rdoPiRcvNotNullAble);
    buttonGrpPiRcvBlnk.add(rdoPiRcvSelectAll);
    buttonGrpDiscRcvBlank.add(rdoDiscBlank);
    buttonGrpDiscRcvBlank.add(rdoDiscRcvAll);
    buttonGrpDiscRcvBlank.add(rdoDiscNotBlank);
    this.add(btnToListFabricComm, null);
    this.add(btnExit, null);
    this.add(blueBkgWhiteCharLabel5, null);
    this.add(blueBkgWhiteCharLabel3, null);
    this.add(whiteBkgBlueCharLabel3, null);
    this.add(rdoDiscBlank, null);
    this.add(rdoDiscNotBlank, null);
    this.add(rdoDiscRcvAll, null);
    this.add(blueBkgWhiteCharLabel4, null);
    this.add(rdoPiRcvNullAble, null);
    this.add(rdoPiRcvNotNullAble, null);
    this.add(rdoPiRcvSelectAll, null);
    this.add(blueBkgWhiteCharLabel6, null);
    this.add(txtShipNo, null);
    this.add(whiteBkgBlueCharLabel5, null);
    this.add(txtProdScNo, null);
    this.add(whiteBkgBlueCharLabel2, null);
    this.add(txtDelFrom, null);
    this.add(whiteBkgBlueCharLabel4, null);
    this.add(txtDelTo, null);
    this.add(txtPiNo, null);
    this.add(txtsupply, null);
    this.add(whiteBkgBlueCharLabel6, null);
    Object objPRODHEADPK=exgui.verification.CellFormat.getOrdinaryField(20);
  /*
     dbTxtProdHeadPK=new  exgui.DataBindTextWithChecker(
              txtProdPk,
              "a.prod_head_pk=",
              null,10,
              (exgui.Object2String)objPRODHEADPK,
              (exgui.ultratable.CellTxtEditorFormat)objPRODHEADPK);
    */
    dbTxtProdHeadPK=new  exgui.DataBindTextWithChecker(
            txtProdPk,
            "a.prod_fabcomm_refno like ",
            null,7,
            (exgui.Object2String)objPRODHEADPK,
            (exgui.ultratable.CellTxtEditorFormat)objPRODHEADPK);

     Object objPIVfy=exgui.verification.CellFormat.getOrdinaryField(10);
      dbTxtFabCommPI=new  exgui.DataBindTextWithChecker(
                    txtPiNo,
                    "b.FAB_COMM_PI=",
                    null,10,
                    (exgui.Object2String)objPIVfy,
                    (exgui.ultratable.CellTxtEditorFormat)objPIVfy);


   Object dateVfy = exgui.verification.CellFormat.getDateStringFormaterAllowNull();
          dbTxtDateBgn =
              new exgui.DataBindTextWithChecker(txtDelFrom, "b.FAB_COMM_DEL>=", null,
                                                10, (exgui.Object2String)dateVfy,
                                                (exgui.ultratable.
                                                 CellTxtEditorFormat)dateVfy);

          dbTxtDateEnd =
              new exgui.DataBindTextWithChecker(txtDelTo, "b.FAB_COMM_DEL<=", null,
                                                10, (exgui.Object2String)dateVfy,
                                                (exgui.ultratable.
                                                 CellTxtEditorFormat)dateVfy);


  }

  void btnToListFabricComm_actionPerformed(ActionEvent e) {
    try{
    AcctFunsConsts.CONDITIONS_QRY_FAB_COMM.clear();

    if(txtsupply.getText().trim().length()>0){
      AcctFunsConsts.CONDITIONS_QRY_FAB_COMM.put(
       "b.FAB_COMM_SUPPLIER=",
       txtsupply.getText().trim()
      );
    }

    if(dbTxtProdHeadPK.getSelectedValue()!=null){
      Object refString=dbTxtProdHeadPK.getSelectedValue();

      AcctFunsConsts.CONDITIONS_QRY_FAB_COMM.put(
           dbTxtProdHeadPK.getOrgRecField()
           ,refString.toString().toUpperCase()+"%");

    }
    if(dbTxtFabCommPI.getSelectedValue()!=null){
      AcctFunsConsts.CONDITIONS_QRY_FAB_COMM.put(
        dbTxtFabCommPI.getOrgRecField()
        ,dbTxtFabCommPI.getSelectedValue());
    }
    if(dbTxtDateBgn.getSelectedValue()!=null){
      String dgts[]=util.MiscFunc.split(txtDelFrom.getText(),"/");
      java.util.Date dateBgn=util.MiscFunc.toDate000000(Integer.parseInt(dgts[0]),
                                                       Integer.parseInt(dgts[1]),
                                                       Integer.parseInt(dgts[2]));
     AcctFunsConsts.CONDITIONS_QRY_FAB_COMM.put(dbTxtDateBgn.getOrgRecField(),
                                                new java.sql.Date(dateBgn.getTime()));

    }

    if(dbTxtDateEnd.getSelectedValue()!=null){
      String dgts[]=util.MiscFunc.split(txtDelTo.getText(),"/");
      java.util.Date dateTo=util.MiscFunc.toDate235959(Integer.parseInt(dgts[0]),
                                                       Integer.parseInt(dgts[1]),
                                                       Integer.parseInt(dgts[2]));
     AcctFunsConsts.CONDITIONS_QRY_FAB_COMM.put(dbTxtDateEnd.getOrgRecField(),
                                                new java.sql.Date(dateTo.getTime()));

    }
    if(rdoDiscBlank.isSelected()){
      AcctFunsConsts.CONDITIONS_QRY_FAB_COMM.put("b.FAB_COMM_DISCOUNT_RCV"," is null ");
    }else if(rdoDiscNotBlank.isSelected()){
      AcctFunsConsts.CONDITIONS_QRY_FAB_COMM.put("b.FAB_COMM_DISCOUNT_RCV"," is not null ");
    }else if(rdoDiscRcvAll.isSelected()){

    }
    if(rdoPiRcvNullAble.isSelected()){
      AcctFunsConsts.CONDITIONS_QRY_FAB_COMM.put("b.FAB_COMM_PI_RCV"," is null ");
    }else if(rdoPiRcvNotNullAble.isSelected()){
      AcctFunsConsts.CONDITIONS_QRY_FAB_COMM.put("b.FAB_COMM_PI_RCV"," is not null ");
    }else if(rdoPiRcvSelectAll.isSelected()){

    }
    if(txtProdScNo.getText().trim().length()>0){
      AcctFunsConsts.CONDITIONS_QRY_FAB_COMM.put("a.PROD_SC_NO=",
                                                 txtProdScNo.getText().trim());
    }

    if(txtShipNo.getText().trim().length()>0){
      AcctFunsConsts.CONDITIONS_QRY_FAB_COMM.put("CONDITION_WITH_SRN",
                                                 txtShipNo.getText().trim());
    }

    processhandler.template.Properties.getCenteralControler().doCommandExecute(
        new newtimes.accounting.TgrToListFabricComm());
    }catch(Exception exp){
      exp.printStackTrace();
    }

  }

  void btnExit_actionPerformed(ActionEvent e) {
    try{
       processhandler.template.Properties.getCenteralControler().goBack();
    }catch(Exception exp){
      exp.printStackTrace();
    }

  }
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel5 = new BlueBkgWhiteCharLabel();
  JTextField txtProdScNo = new JTextField();
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel6 = new BlueBkgWhiteCharLabel();
  JTextField txtShipNo = new JTextField();
  WhiteBkgBlueCharLabel whiteBkgBlueCharLabel5 = new WhiteBkgBlueCharLabel();
  JTextField txtsupply = new JTextField();
  WhiteBkgBlueCharLabel whiteBkgBlueCharLabel6 = new WhiteBkgBlueCharLabel();
}
