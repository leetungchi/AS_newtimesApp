package newtimes.preproduction.guis;

import java.awt.*;
import javax.swing.*;
import exgui.*;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class PnlCostSheet
  extends processhandler.template.PnlFieldsEditor {
  //extends JPanel {
  BorderLayout borderLayout1 = new BorderLayout();
  JPanel jPanel1 = new JPanel();
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel1 = new BlueBkgWhiteCharLabel();
  JLabel blueBkgWhiteCharLabel2 = new JLabel();
  JLabel whiteBkgBlueCharLabel1 = new JLabel();
  JLabel blueBkgWhiteCharLabel3 = new JLabel();
  JLabel whiteBkgBlueCharLabel2 = new JLabel();
  JLabel blueBkgWhiteCharLabel4 = new JLabel();
  JLabel whiteBkgBlueCharLabel3 = new JLabel();
  JLabel blueBkgWhiteCharLabel5 = new JLabel();
  JLabel whiteBkgBlueCharLabel4 = new JLabel();
  JLabel blueBkgWhiteCharLabel6 = new JLabel();
  JLabel blueBkgWhiteCharLabel7 = new JLabel();
  JLabel whiteBkgBlueCharLabel6 = new JLabel();
  JLabel blueBkgWhiteCharLabel8 = new JLabel();
  JLabel blueBkgWhiteCharLabel9 = new JLabel();
  JLabel whiteBkgBlueCharLabel7 = new JLabel();
  JLabel whiteBkgBlueCharLabel8 = new JLabel();
  JTextField txtQtaPrice = new JTextField();
  JLabel blueBkgWhiteCharLabel10 = new JLabel();
  JTextField txtGgStchRmk = new JTextField();
  JTextField txtGgStch = new JTextField();
  JTextField FbcYanYldUnit = new JTextField();
  JTextField txtFbcYnYld = new JTextField();
  JTextField txtWtDozUnit = new JTextField();
  JTextField txtWtDoz = new JTextField();
  JTextField txtFbcYanCostUnit = new JTextField();
  JTextField txtFbcYanCost = new JTextField();
  JTextField txtLogo = new JTextField();
  JTextField txtTrimDate = new JTextField();
  JTextField txtTrimNo = new JTextField();
  JTextField txtTrimDesc = new JTextField();
  JTextField txtWashMethod = new JTextField();
  JTextField txtZipper = new JTextField();
  JLabel whiteBkgBlueCharLabel12 = new JLabel();
  JLabel blueBkgWhiteCharLabel15 = new JLabel();
  JTextField txtConsumptionUnit = new JTextField();
  JTextField txtTrimPrice = new JTextField();
  JTextField txtConsumption = new JTextField();
  JTextField txtLogoCostDesc = new JTextField();
  JTextField txtZiperDesc = new JTextField();
  JTextField txtWashCost = new JTextField();
  JTextField txtCMT_RMK = new JTextField();
  JTextField txtFOB = new JTextField();
  JTextField txtCMT = new JTextField();
  JTextField txtBtnDesc = new JTextField();
  JTextField txtButton = new JTextField();
  JLabel blueBkgWhiteCharLabel17 = new JLabel();
  JLabel blueBkgWhiteCharLabel18 = new JLabel();
  JLabel blueBkgWhiteCharLabel19 = new JLabel();
  JTextField txtFobRMK = new JTextField();
  JComboBox cbxCountry = new JComboBox();
  JComboBox cbxCurrency = new JComboBox();
  JComboBox cbxQtaCat = new JComboBox();
  JLabel lblMtrlVRecords = new JLabel();
  JScrollPane jScrollPane1 = new JScrollPane();
  JTextArea txtRMK = new JTextArea();

  public PnlCostSheet() {
    try {
      jbInit();
      recordColumnsToCopy=null;
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }
 protected void jbInit() throws Exception {
    this.setLayout(borderLayout1);
    jPanel1.setLayout(null);
    blueBkgWhiteCharLabel1.setText("Cost Sheet");
    blueBkgWhiteCharLabel1.setBounds(new Rectangle(-1, 5, 685, 27));
    blueBkgWhiteCharLabel2.setText("Quota Category");
    blueBkgWhiteCharLabel2.setBounds(new Rectangle(70, 89, 105, 24));
    whiteBkgBlueCharLabel1.setText("Material");
    whiteBkgBlueCharLabel1.setBounds(new Rectangle(70, 117, 105, 24));
    blueBkgWhiteCharLabel3.setBounds(new Rectangle(70, 144, 105, 24));
    blueBkgWhiteCharLabel3.setText("Guage/Stitch");
    whiteBkgBlueCharLabel2.setBounds(new Rectangle(70, 172, 105, 24));
    whiteBkgBlueCharLabel2.setText("Fabric/Yan Yeid");
    blueBkgWhiteCharLabel4.setBounds(new Rectangle(70, 199, 105, 24));
    blueBkgWhiteCharLabel4.setText("GMT Wt / Doz");
    whiteBkgBlueCharLabel3.setBounds(new Rectangle(70, 227, 105, 24));
    whiteBkgBlueCharLabel3.setText("Fabric/Yan Cost");
    blueBkgWhiteCharLabel5.setBounds(new Rectangle(70, 255, 105, 24));
    blueBkgWhiteCharLabel5.setText("Consumption");
    whiteBkgBlueCharLabel4.setBounds(new Rectangle(70, 282, 105, 24));
    whiteBkgBlueCharLabel4.setText("Wash Cost");
    blueBkgWhiteCharLabel6.setText("Price2");
    blueBkgWhiteCharLabel6.setBounds(new Rectangle(70, 475, 105, 24));
    blueBkgWhiteCharLabel7.setRequestFocusEnabled(true);
    blueBkgWhiteCharLabel7.setText("Trim Number");
    blueBkgWhiteCharLabel7.setBounds(new Rectangle(70, 365, 105, 24));
    whiteBkgBlueCharLabel6.setText("Zipper Cost");
    whiteBkgBlueCharLabel6.setBounds(new Rectangle(70, 393, 105, 24));
    blueBkgWhiteCharLabel8.setBounds(new Rectangle(70, 310, 105, 24));
    blueBkgWhiteCharLabel8.setText("Logo Cost");
    blueBkgWhiteCharLabel9.setText("Button Cost");
    blueBkgWhiteCharLabel9.setBounds(new Rectangle(70, 420, 105, 24));
    whiteBkgBlueCharLabel7.setBounds(new Rectangle(70, 337, 105, 24));
    whiteBkgBlueCharLabel7.setText("Trim Cost");
    whiteBkgBlueCharLabel8.setText("Price1");
    whiteBkgBlueCharLabel8.setBounds(new Rectangle(70, 448, 105, 24));
    txtQtaPrice.setText("");
    txtQtaPrice.setBounds(new Rectangle(437, 89, 157, 24));
    blueBkgWhiteCharLabel10.setBounds(new Rectangle(333, 89, 105, 24));
    blueBkgWhiteCharLabel10.setText("Quota Price");
    txtGgStchRmk.setText("");
    txtGgStchRmk.setBounds(new Rectangle(332, 144, 262, 24));
    txtGgStch.setText("");
    txtGgStch.setBounds(new Rectangle(175, 144, 157, 24));
    FbcYanYldUnit.setText("");
    FbcYanYldUnit.setBounds(new Rectangle(332, 172, 262, 24));
    txtFbcYnYld.setText("");
    txtFbcYnYld.setBounds(new Rectangle(175, 172, 157, 24));
    txtWtDozUnit.setText("");
    txtWtDozUnit.setBounds(new Rectangle(332, 199, 261, 24));
    txtWtDoz.setText("");
    txtWtDoz.setBounds(new Rectangle(175, 199, 157, 24));
    txtFbcYanCostUnit.setText("");
    txtFbcYanCostUnit.setBounds(new Rectangle(332, 227, 262, 24));
    txtFbcYanCost.setText("");
    txtFbcYanCost.setBounds(new Rectangle(175, 227, 157, 24));
    txtLogo.setText("");
    txtLogo.setBounds(new Rectangle(175, 311, 157, 24));
    txtTrimDate.setText("");
    txtTrimDate.setBounds(new Rectangle(437, 366, 156, 24));
    txtTrimNo.setText("");
    txtTrimNo.setBounds(new Rectangle(175, 366, 157, 24));
    txtTrimDesc.setText("");
    txtTrimDesc.setBounds(new Rectangle(332, 339, 261, 24));
    txtWashMethod.setText("");
    txtWashMethod.setBounds(new Rectangle(437, 284, 157, 24));
    txtZipper.setText("");
    txtZipper.setBounds(new Rectangle(175, 394, 157, 24));
    whiteBkgBlueCharLabel12.setText("Wash Method");
    whiteBkgBlueCharLabel12.setBounds(new Rectangle(332, 284, 105, 24));
    blueBkgWhiteCharLabel15.setBounds(new Rectangle(332, 366, 105, 24));
    blueBkgWhiteCharLabel15.setText("Trim Date");
    txtConsumptionUnit.setText("");
    txtConsumptionUnit.setBounds(new Rectangle(332, 256, 261, 24));
    txtTrimPrice.setText("");
    txtTrimPrice.setBounds(new Rectangle(175, 339, 157, 24));
    txtConsumption.setText("");
    txtConsumption.setBounds(new Rectangle(175, 256, 157, 24));
    txtLogoCostDesc.setText("");
    txtLogoCostDesc.setBounds(new Rectangle(332, 311, 261, 24));
    txtZiperDesc.setText("");
    txtZiperDesc.setBounds(new Rectangle(332, 394, 261, 24));
    txtWashCost.setText("");
    txtWashCost.setBounds(new Rectangle(175, 284, 157, 24));
    txtCMT_RMK.setText("");
    txtCMT_RMK.setBounds(new Rectangle(332, 448, 260, 24));
    txtFOB.setText("");
    txtFOB.setBounds(new Rectangle(175, 475, 157, 24));
    txtCMT.setText("");
    txtCMT.setBounds(new Rectangle(175, 447, 157, 24));
    txtBtnDesc.setText("");
    txtBtnDesc.setBounds(new Rectangle(332, 420, 261, 24));
    txtButton.setText("");
    txtButton.setBounds(new Rectangle(175, 420, 157, 24));
    blueBkgWhiteCharLabel17.setText("Currency");
    blueBkgWhiteCharLabel17.setBounds(new Rectangle(334, 47, 105, 24));
    blueBkgWhiteCharLabel18.setBounds(new Rectangle(71, 47, 105, 24));
    blueBkgWhiteCharLabel18.setText("Country Of Origin");
    blueBkgWhiteCharLabel19.setText("Remark");
    blueBkgWhiteCharLabel19.setBounds(new Rectangle(70, 514, 105, 72));
    txtFobRMK.setText("");
    txtFobRMK.setBounds(new Rectangle(332, 475, 259, 24));
    cbxCountry.setBounds(new Rectangle(176, 49, 140, 20));
    cbxCurrency.setBounds(new Rectangle(438, 49, 153, 20));
    cbxQtaCat.setBounds(new Rectangle(174, 90, 143, 20));
    lblMtrlVRecords.setBorder(BorderFactory.createLoweredBevelBorder());
    lblMtrlVRecords.setBounds(new Rectangle(177, 117, 417, 25));
    jScrollPane1.setBounds(new Rectangle(174, 513, 418, 74));
    //txtRMK.setText("jTextArea1");
    this.add(jPanel1, BorderLayout.CENTER);
    jPanel1.setBackground(new Color(204, 204, 225));
    jPanel1.add(blueBkgWhiteCharLabel2, null);
    jPanel1.add(whiteBkgBlueCharLabel1, null);
    jPanel1.add(blueBkgWhiteCharLabel3, null);
    jPanel1.add(whiteBkgBlueCharLabel2, null);
    jPanel1.add(blueBkgWhiteCharLabel4, null);
    jPanel1.add(whiteBkgBlueCharLabel3, null);
    jPanel1.add(blueBkgWhiteCharLabel5, null);
    jPanel1.add(whiteBkgBlueCharLabel4, null);
    jPanel1.add(blueBkgWhiteCharLabel8, null);
    jPanel1.add(whiteBkgBlueCharLabel7, null);
    jPanel1.add(blueBkgWhiteCharLabel7, null);
    jPanel1.add(whiteBkgBlueCharLabel6, null);
    jPanel1.add(blueBkgWhiteCharLabel9, null);
    jPanel1.add(whiteBkgBlueCharLabel8, null);
    jPanel1.add(blueBkgWhiteCharLabel6, null);
    jPanel1.add(txtQtaPrice, null);
    jPanel1.add(blueBkgWhiteCharLabel10, null);
    jPanel1.add(txtGgStchRmk, null);
    jPanel1.add(txtGgStch, null);
    jPanel1.add(FbcYanYldUnit, null);
    jPanel1.add(txtFbcYnYld, null);
    jPanel1.add(txtWtDozUnit, null);
    jPanel1.add(txtWtDoz, null);
    jPanel1.add(txtFbcYanCostUnit, null);
    jPanel1.add(txtFbcYanCost, null);
    jPanel1.add(txtLogo, null);
    jPanel1.add(txtTrimDate, null);
    jPanel1.add(txtTrimNo, null);
    jPanel1.add(txtTrimDesc, null);
    jPanel1.add(txtWashMethod, null);
    jPanel1.add(txtZipper, null);
    jPanel1.add(whiteBkgBlueCharLabel12, null);
    jPanel1.add(blueBkgWhiteCharLabel15, null);
    jPanel1.add(txtConsumptionUnit, null);
    jPanel1.add(txtTrimPrice, null);
    jPanel1.add(txtConsumption, null);
    jPanel1.add(txtLogoCostDesc, null);
    jPanel1.add(txtZiperDesc, null);
    jPanel1.add(txtWashCost, null);
    jPanel1.add(txtFOB, null);
    jPanel1.add(txtCMT, null);
    jPanel1.add(txtButton, null);
    jPanel1.add(blueBkgWhiteCharLabel1, null);
    jPanel1.add(blueBkgWhiteCharLabel17, null);
    jPanel1.add(blueBkgWhiteCharLabel18, null);
    jPanel1.add(blueBkgWhiteCharLabel19, null);
    jPanel1.add(txtCMT_RMK, null);
    jPanel1.add(txtBtnDesc, null);
    jPanel1.add(txtFobRMK, null);
    jPanel1.add(cbxCountry, null);
    jPanel1.add(cbxCurrency, null);
    jPanel1.add(cbxQtaCat, null);
    jPanel1.add(lblMtrlVRecords, null);
    jPanel1.add(jScrollPane1, null);
    jScrollPane1.getViewport().add(txtRMK, null);
  }

  public void record2Gui(){
   try{
    java.util.Vector countriesRec=tempProperties.tmpCountries ;
    java.util.Vector currencyRec=tempProperties.tmpCurrency;
    java.util.Vector qtaRec=tempProperties.tmpQtaCtg;
    lblMtrlVRecords.setText(newtimes.preproduction.Constants.PREPROD_USING_MTRL_DTLS_STRING);
    dataBoundGUIs.clear();
    cbxCountry.removeAllItems();
    cbxCurrency.removeAllItems();
    cbxQtaCat.removeAllItems();
    dataBoundGUIs.add(
        new exgui.DataBindJCombobox(cbxCountry,
                                    "COST_COUNTRY",
                                    countriesRec,
                                    "CNTY_NAME",
                                    "CNTY_NAME",
                                    recToMapping.get("COST_COUNTRY"),
                                    "NONE",null)
    );
    dataBoundGUIs.add(
        new exgui.DataBindJCombobox(cbxCurrency,
                                    "COST_CURRENCY",
                                    currencyRec,
                                    "CRNCY_NAME",
                                    "CRNCY_NAME",
                                    recToMapping.get("COST_CURRENCY"),
                                    "NONE",null)
    );
    dataBoundGUIs.add(
        new exgui.DataBindJCombobox(
          cbxQtaCat,"COST_QUOTA",
          qtaRec,
          "QTA_CAT","QTA_CAT",
          recToMapping.get("COST_QUOTA"),
          "NONE",null)
    );
      Object vftxtQtaPrice=exgui.verification.CellFormat.getDoubleFormatAllowNull(5,2);
       dataBoundGUIs.add(  new exgui.DataBindTextWithChecker(txtQtaPrice,"COST_QUOTA_UNIT_PRX",recToMapping.get("COST_QUOTA_UNIT_PRX"),8,(exgui.Object2String)vftxtQtaPrice,(exgui.ultratable.CellTxtEditorFormat)vftxtQtaPrice)
      );

      Object vftxtGgStch=exgui.verification.CellFormat.getOrdinaryField(20);
       dataBoundGUIs.add(  new exgui.DataBindTextWithChecker(txtGgStch,"COST_GAUGE_STITCH",recToMapping.get("COST_GAUGE_STITCH"),20,(exgui.Object2String)vftxtGgStch,(exgui.ultratable.CellTxtEditorFormat)vftxtGgStch)
      );
      Object vftxtGgStchRmk=exgui.verification.CellFormat.getOrdinaryField(40);
       dataBoundGUIs.add(  new exgui.DataBindTextWithChecker(txtGgStchRmk,"COST_GAUGE_STITCH_REMARK",recToMapping.get("COST_GAUGE_STITCH_REMARK"),40,(exgui.Object2String)vftxtGgStchRmk,(exgui.ultratable.CellTxtEditorFormat)vftxtGgStchRmk)
      );
      Object vftxtFbcYnYld=exgui.verification.CellFormat.getDoubleFormatAllowNull(5,2);
       dataBoundGUIs.add(  new exgui.DataBindTextWithChecker(txtFbcYnYld,"COST_FABRIC_YARN_PRICE",recToMapping.get("COST_FABRIC_YARN_PRICE"),8,(exgui.Object2String)vftxtFbcYnYld,(exgui.ultratable.CellTxtEditorFormat)vftxtFbcYnYld)
      );
      Object vfFbcYanYldUnit=exgui.verification.CellFormat.getOrdinaryField(5);
       dataBoundGUIs.add(  new exgui.DataBindTextWithChecker(FbcYanYldUnit,"COST_FABRIC_YARN_UNIT",recToMapping.get("COST_FABRIC_YARN_UNIT"),5,(exgui.Object2String)vfFbcYanYldUnit,(exgui.ultratable.CellTxtEditorFormat)vfFbcYanYldUnit)
      );
      Object vftxtWtDoz=exgui.verification.CellFormat.getDoubleFormatAllowNull(5,2);
       dataBoundGUIs.add(  new exgui.DataBindTextWithChecker(txtWtDoz,"COST_FABRIC_WEIGHT_DOZEN",recToMapping.get("COST_FABRIC_WEIGHT_DOZEN"),8,(exgui.Object2String)vftxtWtDoz,(exgui.ultratable.CellTxtEditorFormat)vftxtWtDoz)
      );
      Object vftxtWtDozUnit=exgui.verification.CellFormat.getOrdinaryField(5);
       dataBoundGUIs.add(  new exgui.DataBindTextWithChecker(txtWtDozUnit,"COST_FABRIC_WEIGHT_UNIT",recToMapping.get("COST_FABRIC_WEIGHT_UNIT"),5,(exgui.Object2String)vftxtWtDozUnit,(exgui.ultratable.CellTxtEditorFormat)vftxtWtDozUnit)
      );
      Object vftxtFbcYanCost=exgui.verification.CellFormat.getDoubleFormatAllowNull(5,2);
       dataBoundGUIs.add(  new exgui.DataBindTextWithChecker(txtFbcYanCost,"COST_FABRIC_YARN_COST",recToMapping.get("COST_FABRIC_YARN_COST"),8,(exgui.Object2String)vftxtFbcYanCost,(exgui.ultratable.CellTxtEditorFormat)vftxtFbcYanCost)
      );
      Object vftxtFbcYanCostUnit=exgui.verification.CellFormat.getOrdinaryField(5);
       dataBoundGUIs.add(  new exgui.DataBindTextWithChecker(txtFbcYanCostUnit,"COST_FABRIC_YARN_COST_UNIT",recToMapping.get("COST_FABRIC_YARN_COST_UNIT"),5,(exgui.Object2String)vftxtFbcYanCostUnit,(exgui.ultratable.CellTxtEditorFormat)vftxtFbcYanCostUnit)
      );
      Object vftxtConsumption=exgui.verification.CellFormat.getDoubleFormatAllowNull(5,2);
       dataBoundGUIs.add(  new exgui.DataBindTextWithChecker(txtConsumption,"COST_FABRIC_CONSUMPTION",recToMapping.get("COST_FABRIC_CONSUMPTION"),8,(exgui.Object2String)vftxtConsumption,(exgui.ultratable.CellTxtEditorFormat)vftxtConsumption)
      );
      Object vftxtConsumptionUnit=exgui.verification.CellFormat.getOrdinaryField(5);
       dataBoundGUIs.add(  new exgui.DataBindTextWithChecker(txtConsumptionUnit,"COST_FABRIC_CONSUMPTION_UNIT",recToMapping.get("COST_FABRIC_CONSUMPTION_UNIT"),5,(exgui.Object2String)vftxtConsumptionUnit,(exgui.ultratable.CellTxtEditorFormat)vftxtConsumptionUnit)
      );
      Object vftxtWashCost=exgui.verification.CellFormat.getDoubleFormatAllowNull(5,2);
       dataBoundGUIs.add(  new exgui.DataBindTextWithChecker(txtWashCost,"COST_WASH_COST",recToMapping.get("COST_WASH_COST"),8,(exgui.Object2String)vftxtWashCost,(exgui.ultratable.CellTxtEditorFormat)vftxtWashCost)
      );
      Object vftxtWashMethod=exgui.verification.CellFormat.getOrdinaryField(40);
       dataBoundGUIs.add(  new exgui.DataBindTextWithChecker(txtWashMethod,"COST_WASH_METHOD",recToMapping.get("COST_WASH_METHOD"),40,(exgui.Object2String)vftxtWashMethod,(exgui.ultratable.CellTxtEditorFormat)vftxtWashMethod)
      );
      Object vftxtLogo=exgui.verification.CellFormat.getDoubleFormatAllowNull(5,2);
       dataBoundGUIs.add(  new exgui.DataBindTextWithChecker(txtLogo,"COST_LOGO",recToMapping.get("COST_LOGO"),8,(exgui.Object2String)vftxtLogo,(exgui.ultratable.CellTxtEditorFormat)vftxtLogo)
      );
      Object vftxtLogoCostDesc=exgui.verification.CellFormat.getOrdinaryField(40);
       dataBoundGUIs.add(  new exgui.DataBindTextWithChecker(txtLogoCostDesc,"COST_LOGO_DESC",recToMapping.get("COST_LOGO_DESC"),40,(exgui.Object2String)vftxtLogoCostDesc,(exgui.ultratable.CellTxtEditorFormat)vftxtLogoCostDesc)
      );
      Object vftxtTrimPrice=exgui.verification.CellFormat.getDoubleFormatAllowNull(3,3);
       dataBoundGUIs.add(  new exgui.DataBindTextWithChecker(txtTrimPrice,"COST_TRIM_PRICE",recToMapping.get("COST_TRIM_PRICE"),7,(exgui.Object2String)vftxtTrimPrice,(exgui.ultratable.CellTxtEditorFormat)vftxtTrimPrice)
      );
      Object vftxtTrimDesc=exgui.verification.CellFormat.getOrdinaryField(40);
       dataBoundGUIs.add(  new exgui.DataBindTextWithChecker(txtTrimDesc,"COST_TRIM_DESC",recToMapping.get("COST_TRIM_DESC"),40,(exgui.Object2String)vftxtTrimDesc,(exgui.ultratable.CellTxtEditorFormat)vftxtTrimDesc)
      );
      Object vftxtTrimNo=exgui.verification.CellFormat.getOrdinaryField(15);
       dataBoundGUIs.add(  new exgui.DataBindTextWithChecker(txtTrimNo,"COST_TRIM_NO",recToMapping.get("COST_TRIM_NO"),15,(exgui.Object2String)vftxtTrimNo,(exgui.ultratable.CellTxtEditorFormat)vftxtTrimNo)
      );
      Object vftxtTrimDate=exgui.verification.CellFormat.getDateStringFormaterAllowNull();
       dataBoundGUIs.add(  new exgui.DataBindTextWithChecker(txtTrimDate,"COST_TRIM_DATE",recToMapping.get("COST_TRIM_DATE"),10,(exgui.Object2String)vftxtTrimDate,(exgui.ultratable.CellTxtEditorFormat)vftxtTrimDate)
      );
      Object vftxtZipper=exgui.verification.CellFormat.getDoubleFormatAllowNull(4,3);
       dataBoundGUIs.add(  new exgui.DataBindTextWithChecker(txtZipper,"COST_ZIPPER",recToMapping.get("COST_ZIPPER"),8,(exgui.Object2String)vftxtZipper,(exgui.ultratable.CellTxtEditorFormat)vftxtZipper)
      );
      Object vftxtZiperDesc=exgui.verification.CellFormat.getOrdinaryField(40);
       dataBoundGUIs.add(  new exgui.DataBindTextWithChecker(txtZiperDesc,"COST_ZIPPER_DESC",recToMapping.get("COST_ZIPPER_DESC"),40,(exgui.Object2String)vftxtZiperDesc,(exgui.ultratable.CellTxtEditorFormat)vftxtZiperDesc)
      );
      Object vftxtButton=exgui.verification.CellFormat.getDoubleFormatAllowNull(3,4);
       dataBoundGUIs.add(  new exgui.DataBindTextWithChecker(txtButton,"COST_BUTTON",recToMapping.get("COST_BUTTON"),8,(exgui.Object2String)vftxtButton,(exgui.ultratable.CellTxtEditorFormat)vftxtButton)
      );
      Object vftxtBtnDesc=exgui.verification.CellFormat.getOrdinaryField(40);
       dataBoundGUIs.add(  new exgui.DataBindTextWithChecker(txtBtnDesc,"COST_BUTTON_DESC",recToMapping.get("COST_BUTTON_DESC"),40,(exgui.Object2String)vftxtBtnDesc,(exgui.ultratable.CellTxtEditorFormat)vftxtBtnDesc)
      );
      Object vftxtCMT=exgui.verification.CellFormat.getDoubleFormatAllowNull(5,2);
       dataBoundGUIs.add(  new exgui.DataBindTextWithChecker(txtCMT,"COST_CMT",recToMapping.get("COST_CMT"),8,(exgui.Object2String)vftxtCMT,(exgui.ultratable.CellTxtEditorFormat)vftxtCMT)
      );
      Object vftxtCMT_RMK=exgui.verification.CellFormat.getOrdinaryField(40);
       dataBoundGUIs.add(
          new exgui.DataBindTextWithChecker(
          txtCMT_RMK,"COST_CMT_REMARK",
          recToMapping.get("COST_CMT_REMARK"),40,
          (exgui.Object2String)vftxtCMT_RMK,
          (exgui.ultratable.CellTxtEditorFormat)vftxtCMT_RMK)
      );
      if(recToMapping.get("COST_CMT_REMARK")==null)txtCMT_RMK.setText("CMT");
      Object vftxtFOB=exgui.verification.CellFormat.getDoubleFormatAllowNull(5,2);
       dataBoundGUIs.add(
          new exgui.DataBindTextWithChecker(
             txtFOB,"COST_FOB",
             recToMapping.get("COST_FOB"),8,
             (exgui.Object2String)vftxtFOB,
             (exgui.ultratable.CellTxtEditorFormat)vftxtFOB)
      );

      Object vftxtFobRMK=exgui.verification.CellFormat.getOrdinaryField(40);
       dataBoundGUIs.add(
          new exgui.DataBindTextWithChecker(
          txtFobRMK,"COST_FOB_REMARK",
          recToMapping.get("COST_FOB_REMARK"),40,
          (exgui.Object2String)vftxtFobRMK,
          (exgui.ultratable.CellTxtEditorFormat)vftxtFobRMK)
      );
      if(recToMapping.get("COST_FOB_REMARK")==null)txtFobRMK.setText("FOB");
      Object vftxtGnlRmk=exgui.verification.CellFormat.getOrdinaryField(200);
       dataBoundGUIs.add(
          new exgui.DataBindTextWithChecker(
             txtRMK,
             "COST_GENERAL_REMARK",
             recToMapping.get("COST_GENERAL_REMARK"),200,
             (exgui.Object2String)vftxtGnlRmk,
             (exgui.ultratable.CellTxtEditorFormat)vftxtGnlRmk)
      );
      //begin to collect the columns allow to future copy...
      if(recordColumnsToCopy==null){
        recordColumnsToCopy=new String[dataBoundGUIs.size()];
        for (int i = 0; i < dataBoundGUIs.size(); i++) {
         recordColumnsToCopy[i]=((exgui.DataBindGUIObject)dataBoundGUIs.get(i)).getOrgRecField();
        }
      }

   }catch(Exception e){
      e.printStackTrace();
   }
  }
  public void doUpdate()throws Exception{
    super.doUpdate();
    if(!super.isGui2RecordOk) return;
    //processhandler.template.Properties.getCenteralControler().goBack();
    processhandler.template.Properties.getCenteralControler().doCommandExecute(
       new newtimes.preproduction.process.TgrListLockInStyles());

  }
  public void doPrint(){

  }
}
