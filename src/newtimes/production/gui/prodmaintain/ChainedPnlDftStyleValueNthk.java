package newtimes.production.gui.prodmaintain;
import java.awt.*;
import exgui.*;
import javax.swing.*;
import javax.swing.border.*;
import java.util.*;
import java.awt.event.*;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class ChainedPnlDftStyleValueNthk
    extends processhandler.template.PnlFieldsEditor
    //extends JPanel
 //implements exgui.chaindialog.Responsible
{
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel1 = new BlueBkgWhiteCharLabel();
  JLabel jLabel1 = new JLabel();
  JTextField txtOrgDel = new JTextField();
  JTextField txtRcfDel = new JTextField();
  JLabel jLabel2 = new JLabel();
  JLabel jLabel3 = new JLabel();
  JLabel lblCtPriceTerm = new JLabel();
  JComboBox cbxCtPriceTerm = new JComboBox();
  JComboBox cbxCT_Dest = new JComboBox();
  JLabel lblCtDestination = new JLabel();
  JLabel lblCtCurrency = new JLabel();
  JComboBox cbxCtCurrency = new JComboBox();
  TitledBorder titledBorder1;
  JLabel lblBuyDocPrx = new JLabel();
  JTextField txtBuyDocPrx = new JTextField();
  JLabel lblBuyActPrx = new JLabel();
  JTextField txtBuyActPrx = new JTextField();
  JLabel lblMkrDocPrx = new JLabel();
  JTextField txtMkrDocPrx = new JTextField();
  JLabel lblMkrActPrx = new JLabel();
  JTextField txtMkrActPrx = new JTextField();
  JLabel lblQty = new JLabel();
  JTextField txtTtlQty = new JTextField();
  JLabel jLabel13 = new JLabel();
  JComboBox cbxStyUnit = new JComboBox();
  JLabel jLabel14 = new JLabel();
  JTextField txtStylePrefix = new JTextField();
  JLabel jLabel15 = new JLabel();
  JTextField txtStyleBarcodePrefix = new JTextField();
  JLabel jLabel16 = new JLabel();
  JTextField txtSeqFrom = new JTextField();
  JButton btnCancel = new JButton();
  JButton btnOK = new JButton();
  JLabel jLabel17 = new JLabel();
  JTextField txtSeqTo = new JTextField();
  JTextField txtSeqFrom4BarCode = new JTextField();
  JLabel jLabel18 = new JLabel();
  JLabel jLabel19 = new JLabel();
  JTextField txtSeqTo4BarCode = new JTextField();
  JLabel jLabel20 = new JLabel();
  JTextField txtMkrDelDate = new JTextField();
  String sc_no=null;
  String _styNo2Follow=null;
  JComboBox cbxShipMode = new JComboBox();
  JLabel lblMakerIssueDate = new JLabel();
  JTextField txtMkrIssueDate = new JTextField();
  java.sql.Date now=new java.sql.Date(System.currentTimeMillis());

  public ChainedPnlDftStyleValueNthk() {
    try {
     //System.out.println("newtimes.preproduction.Constants.CURRENT_PREPROD_HEAD_RECORD is :" +newtimes.preproduction.Constants.CURRENT_PREPROD_HEAD_RECORD.toString());
     //System.out.println("newtimes.production.ProdMaintain_Properties.EDITIONG_PRODUCTION_RECORD is :" +newtimes.production.ProdMaintain_Properties.EDITIONG_PRODUCTION_RECORD.toString());
     try{
      sc_no= (String)newtimes.preproduction.Constants.CURRENT_PREPROD_HEAD_RECORD.
           get("PRODUCTION_SC_NO");
     }catch(Exception exp1){

     }
     try{
      sc_no= (String)newtimes.preproduction.Constants.CURRENT_PREPROD_HEAD_RECORD.
           get("PROD_SC_NO");
     }catch(Exception exp2){

     }

       jbInit();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }
  public void setStyNo2Follow(String styNo2Follow){
    _styNo2Follow=styNo2Follow;
  }
  public void record2Gui(){
    try{
      recToMapping.set(7,"B");//org ship way default vaule is "BOAT'
      //recToMapping.set(106,"PCS");//default unit is PCS
      dataBoundGUIs.clear();
      Object vftxtOrgDel=exgui.verification.CellFormat.getDateStringFormaterAllowNull();
       dataBoundGUIs.add(
          new exgui.DataBindTextWithChecker(txtOrgDel,
                                            "STY_ORIG_DEL",
                                            recToMapping.get("STY_ORIG_DEL"),10,
                                            (exgui.Object2String)vftxtOrgDel,
                                            (exgui.ultratable.CellTxtEditorFormat)vftxtOrgDel)
      );

       dataBoundGUIs.add(
         new exgui.DataBindTextWithChecker(
                txtRcfDel,"STY_RECFM_DEL",
                recToMapping.get("STY_RECFM_DEL"),10,
               (exgui.Object2String)vftxtOrgDel,
               (exgui.ultratable.CellTxtEditorFormat)vftxtOrgDel)
      );

     dataBoundGUIs.add(
        new exgui.DataBindTextWithChecker(
            txtMkrDelDate,"STY_MKR_DEL",
            recToMapping.get("STY_MKR_DEL"),10,
           (exgui.Object2String)vftxtOrgDel,
           (exgui.ultratable.CellTxtEditorFormat)vftxtOrgDel)
      );
     //to avoid over write c/t head's c/t issue date,in current GUI, can not show vender issue date field


     /*
      Object vftxtShipMod=exgui.verification.CellFormat.getOrdinaryField(1);
       dataBoundGUIs.add(
         new exgui.DataBindTextWithChecker(
           txtShipMod,"STY_ORIG_WAY",
           recToMapping.get("STY_ORIG_WAY"),1,
          (exgui.Object2String)vftxtShipMod,
          (exgui.ultratable.CellTxtEditorFormat)vftxtShipMod)
      );*/
     Vector vctShipWays=newtimes.preproduction.guis.tempProperties.tempShipModes;
     dataBoundGUIs.add(
        new exgui.DataBindJCombobox(cbxShipMode,
       "STY_ORIG_WAY",vctShipWays,"SHIP_MODE_NAME","SHIP_MODE_CODE",
        recToMapping.get("STY_ORIG_WAY")));
     cbxShipMode.setToolTipText("<html><body>A:Air,B:Boat,S:Sea,W:West Coast,T:Truck,C:Courier,F:Fedex Collect,<br> O " +
        ":Ocean,V:Vessel</body></html>");
      Object vftxtStylePrefix=exgui.verification.CellFormat.getOrdinaryField(30);
       dataBoundGUIs.add(
         new exgui.DataBindTextWithChecker(
         txtStylePrefix,"STY_STYLE",
         recToMapping.get("STY_STYLE"),30,
         (exgui.Object2String)vftxtStylePrefix,(exgui.ultratable.CellTxtEditorFormat)vftxtStylePrefix)
      );
      Object vftxtStyleBarcodePrefix=exgui.verification.CellFormat.getOrdinaryField(50);
       dataBoundGUIs.add(
        new exgui.DataBindTextWithChecker(
        txtStyleBarcodePrefix,"STY_BARCODE",
        recToMapping.get("STY_BARCODE"),50,
         (exgui.Object2String)vftxtStyleBarcodePrefix,
          (exgui.ultratable.CellTxtEditorFormat)vftxtStyleBarcodePrefix)
      );
   //--------for qty object-----------------
   Object vftxtQty=exgui.verification.CellFormat.getDoubleFormatAllowNull(7,2);
   exgui.DataBindTextWithChecker dbTxtQty=
       new exgui.DataBindTextWithChecker(
        txtTtlQty,"",
        new Integer(0),10,(exgui.Object2String)vftxtQty,
            (exgui.ultratable.CellTxtEditorFormat)vftxtQty);

    //--for price object----------------

      Object vftxtBuyDocPrx=exgui.verification.CellFormat.getDoubleFormatAllowNull(7,3);
      exgui.DataBindTextWithChecker dbTxtBuyerDocPrx=
          new exgui.DataBindTextWithChecker(
           txtBuyDocPrx,"PRI_BYR_DOC_PRX",
           new Integer(0),10,(exgui.Object2String)vftxtBuyDocPrx,
               (exgui.ultratable.CellTxtEditorFormat)vftxtBuyDocPrx);

     exgui.DataBindTextWithChecker dbTxtBuyerActPrx=
       new exgui.DataBindTextWithChecker(
      txtBuyActPrx,"PRI_BYR_ACT_PRX",
      new Integer(0),10,
      (exgui.Object2String)vftxtBuyDocPrx,
      (exgui.ultratable.CellTxtEditorFormat)vftxtBuyDocPrx);

      Object vftxtCount=exgui.verification.CellFormat.getIntVerifierAllowNull(3);
      exgui.DataBindTextWithChecker dbItemCount=
        new exgui.DataBindTextWithChecker(
       txtSeqFrom,"",
       new Integer(1),3,
       (exgui.Object2String)vftxtCount,
       (exgui.ultratable.CellTxtEditorFormat)vftxtCount);

    exgui.DataBindTextWithChecker dbItemCountTo =
        new exgui.DataBindTextWithChecker(
        txtSeqTo, "",
        new Integer(1), 3,
        (exgui.Object2String)vftxtCount,
        (exgui.ultratable.CellTxtEditorFormat)vftxtCount);

    exgui.DataBindTextWithChecker dbBarcodeFrom =
      new exgui.DataBindTextWithChecker(
      txtSeqFrom4BarCode , "",
      new Integer(1), 3,
      (exgui.Object2String)vftxtCount,
      (exgui.ultratable.CellTxtEditorFormat)vftxtCount);

    exgui.DataBindTextWithChecker dbBarcodeTo =
      new exgui.DataBindTextWithChecker(
      txtSeqTo4BarCode, "",
      new Integer(1), 3,
      (exgui.Object2String)vftxtCount,
      (exgui.ultratable.CellTxtEditorFormat)vftxtCount);



     exgui.DataBindTextWithChecker dbTxtMakerDocPrx=
      new exgui.DataBindTextWithChecker(
        txtMkrDocPrx,"PRI_MKR_DOC_PRX",
        new Integer(0),10,(exgui.Object2String)vftxtBuyDocPrx,
        (exgui.ultratable.CellTxtEditorFormat)vftxtBuyDocPrx);

     exgui.DataBindTextWithChecker dbTxtMkrActPrx=
      new exgui.DataBindTextWithChecker(
       txtMkrActPrx,"PRI_MKR_ACT_PRX",new Integer(0),10,
       (exgui.Object2String)vftxtBuyDocPrx,
       (exgui.ultratable.CellTxtEditorFormat)vftxtBuyDocPrx);

    /*
     Vector vctPrxTrm=newtimes.preproduction.guis.tempProperties.tmpPriceTerm;
     dataBoundGUIs.add(
        new exgui.DataBindJCombobox(cbxCtPriceTerm,"STY_CT_PRC_TRM",
                                    vctPrxTrm,
                                    "PRC_TRM","PRC_TRM",
                                    ct_prx_trm_Default));//FOB
    Vector vctDestination=newtimes.production.process.prodmaintain.DB_ProdSC.getDestinations();
    dataBoundGUIs.add(
      new exgui.DataBindJCombobox(
          cbxCT_Dest,"STY_CT_DEST",
          vctDestination,
          "DEST_NAME","DEST_NAME",
          ct_dest_Default));//recToMapping.get("STY_CT_DEST")
     Vector vctCurrency=newtimes.preproduction.guis.tempProperties.tmpCurrency;
     dataBoundGUIs.add(
       new exgui.DataBindJCombobox(
           cbxCtCurrency,"STY_CT_CURRENCY",
           vctCurrency,
           "CRNCY_NAME",
           "CRNCY_NAME",
           ct_currency_Default));//recToMapping.get("STY_CT_CURRENCY")
        */
      Vector vctUnit=newtimes.preproduction.guis.tempProperties.tmpUnits;
     dataBoundGUIs.add(
      new exgui.DataBindJCombobox(cbxStyUnit,
      "STY_UNIT",vctUnit,"UNIT","UNIT",
      recToMapping.get("STY_UNIT")));
      txtBuyDocPrx.addKeyListener(new PriceKeyProc());
    }catch(Exception exp){
       exp.printStackTrace();
    }
  }
  public void doPrint(){}
  protected void jbInit() throws Exception {
    titledBorder1 = new TitledBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED,Color.white,Color.white,new Color(103, 101, 98),new Color(148, 145, 140)),"CT DATA");
    blueBkgWhiteCharLabel1.setText("DEFAULT VALUE OF STYLES");
    blueBkgWhiteCharLabel1.setBounds(new Rectangle(0, 17, 557, 28));
    this.setLayout(null);
    jLabel1.setFont(new java.awt.Font("Dialog", 1, 11));
    jLabel1.setText("Original DEL:");
    jLabel1.setBounds(new Rectangle(16, 60, 75, 24));
    txtOrgDel.setText("");
    txtOrgDel.setBounds(new Rectangle(92, 60, 83, 24));
    txtRcfDel.setBounds(new Rectangle(275, 60, 77, 25));
    txtRcfDel.setText("");
    jLabel2.setBounds(new Rectangle(199, 60, 75, 24));
    jLabel2.setFont(new java.awt.Font("Dialog", 1, 11));
    jLabel2.setText("Revise DEL:");
    jLabel3.setFont(new java.awt.Font("Dialog", 1, 11));
    jLabel3.setText("SHIP MODE:");
    jLabel3.setBounds(new Rectangle(12, 101, 74, 22));
    lblCtPriceTerm.setFont(new java.awt.Font("Dialog", 1, 11));
    lblCtPriceTerm.setText("C/T Price Term:");
    lblCtPriceTerm.setBounds(new Rectangle(11, 134, 95, 22));
    cbxCtPriceTerm.setBounds(new Rectangle(108, 134, 148, 22));
    cbxCT_Dest.setBounds(new Rectangle(391, 133, 126, 22));
    lblCtDestination.setBounds(new Rectangle(290, 133, 101, 22));
    lblCtDestination.setFont(new java.awt.Font("Dialog", 1, 11));
    lblCtDestination.setText("C/T DESTINATION:");
    lblCtCurrency.setFont(new java.awt.Font("Dialog", 1, 11));
    lblCtCurrency.setText("C/T CURRENCY:");
    lblCtCurrency.setBounds(new Rectangle(10, 163, 97, 22));
    cbxCtCurrency.setBounds(new Rectangle(109, 165, 147, 22));
    lblBuyDocPrx.setFont(new java.awt.Font("Dialog", 1, 11));
    lblBuyDocPrx.setText("Buyer Doc. Price");
    lblBuyDocPrx.setBounds(new Rectangle(11, 226, 100, 20));
    txtBuyDocPrx.setText("");
    txtBuyDocPrx.setBounds(new Rectangle(113, 226, 74, 21));
    lblBuyActPrx.setBounds(new Rectangle(219, 225, 97, 20));
    lblBuyActPrx.setFont(new java.awt.Font("Dialog", 1, 11));
    lblBuyActPrx.setText("Buyer Act. Price");
    txtBuyActPrx.setBounds(new Rectangle(317, 226, 74, 21));
    txtBuyActPrx.setText("");
    lblMkrDocPrx.setBounds(new Rectangle(11, 259, 101, 20));
    lblMkrDocPrx.setFont(new java.awt.Font("Dialog", 1, 11));
    lblMkrDocPrx.setText("MakerDoc. Price");
    txtMkrDocPrx.setBounds(new Rectangle(114, 259, 74, 21));
    txtMkrDocPrx.setText("");
    lblMkrActPrx.setBounds(new Rectangle(221, 261, 91, 20));
    lblMkrActPrx.setFont(new java.awt.Font("Dialog", 1, 11));
    lblMkrActPrx.setText("Maker Act. Price");
    txtMkrActPrx.setBounds(new Rectangle(318, 259, 74, 21));
    txtMkrActPrx.setText("");
    lblQty.setFont(new java.awt.Font("Dialog", 1, 11));
    lblQty.setText("None Size,None Color,Total QTY:");
    lblQty.setBounds(new Rectangle(12, 191, 185, 28));
    txtTtlQty.setText("");
    txtTtlQty.setBounds(new Rectangle(194, 191, 83, 25));
    jLabel13.setFont(new java.awt.Font("Dialog", 1, 11));
    jLabel13.setText("UNIT");
    jLabel13.setBounds(new Rectangle(291, 189, 38, 25));
    cbxStyUnit.setBounds(new Rectangle(328, 191, 133, 23));
    jLabel14.setBackground(new Color(143, 143, 188));
    jLabel14.setFont(new java.awt.Font("Dialog", 1, 11));
    jLabel14.setOpaque(true);
    jLabel14.setHorizontalAlignment(SwingConstants.CENTER);
    jLabel14.setText("Prefix Of Styles");
    jLabel14.setBounds(new Rectangle(5, 290, 104, 22));
    txtStylePrefix.setText("");
    txtStylePrefix.setBounds(new Rectangle(106, 290, 124, 22));
    jLabel15.setBounds(new Rectangle(277, 290, 88, 22));
    jLabel15.setBackground(new Color(143, 143, 188));
    jLabel15.setFont(new java.awt.Font("Dialog", 1, 11));
    jLabel15.setOpaque(true);
    jLabel15.setHorizontalAlignment(SwingConstants.CENTER);
    jLabel15.setText("BarCode");
    txtStyleBarcodePrefix.setBounds(new Rectangle(365, 290, 115, 22));
    txtStyleBarcodePrefix.setText("");
    jLabel16.setBackground(new Color(143, 143, 188));
    jLabel16.setFont(new java.awt.Font("Dialog", 1, 11));
    jLabel16.setOpaque(true);
    jLabel16.setHorizontalAlignment(SwingConstants.CENTER);
    jLabel16.setText("Seq. RANGE:");
    jLabel16.setBounds(new Rectangle(5, 312, 104, 22));
    txtSeqFrom.setText("10");
    txtSeqFrom.setBounds(new Rectangle(108, 312, 52, 22));
    btnCancel.setBounds(new Rectangle(81, 377, 96, 26));
    btnCancel.setFont(new java.awt.Font("Dialog", 1, 11));
    btnCancel.setText("CANCEL");
    btnCancel.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnCancel_actionPerformed(e);
      }
    });
    btnOK.setText("OK");
    /*
    btnOK.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnOK_actionPerformed(e);
      }
    });
    */
    btnOK.setBounds(new Rectangle(310, 382, 96, 26));
    btnOK.setFont(new java.awt.Font("Dialog", 1, 11));
    btnOK.setMaximumSize(new Dimension(49, 27));
    jLabel17.setBounds(new Rectangle(158, 312, 29, 22));
    jLabel17.setText("~");
    jLabel17.setBackground(new Color(143, 143, 188));
    jLabel17.setFont(new java.awt.Font("Dialog", 1, 13));
    jLabel17.setOpaque(true);
    jLabel17.setHorizontalAlignment(SwingConstants.CENTER);
    txtSeqTo.setBounds(new Rectangle(186, 312, 43, 22));
    txtSeqTo.setText("10");
    txtSeqFrom4BarCode.setBounds(new Rectangle(366, 312, 46, 22));
    txtSeqFrom4BarCode.setText("10");
    jLabel18.setBounds(new Rectangle(277, 312, 89, 22));
    jLabel18.setText("Seq. RANGE:");
    jLabel18.setHorizontalAlignment(SwingConstants.CENTER);
    jLabel18.setOpaque(true);
    jLabel18.setFont(new java.awt.Font("Dialog", 1, 11));
    jLabel18.setBackground(new Color(143, 143, 188));
    jLabel19.setHorizontalAlignment(SwingConstants.CENTER);
    jLabel19.setOpaque(true);
    jLabel19.setFont(new java.awt.Font("Dialog", 1, 13));
    jLabel19.setBackground(new Color(143, 143, 188));
    jLabel19.setText("~");
    jLabel19.setBounds(new Rectangle(410, 312, 29, 22));
    txtSeqTo4BarCode.setText("10");
    txtSeqTo4BarCode.setBounds(new Rectangle(439, 312, 40, 22));
    jLabel20.setText("Maker DEL:");
    jLabel20.setFont(new java.awt.Font("Dialog", 1, 11));
    jLabel20.setBounds(new Rectangle(382, 60, 75, 24));
    txtMkrDelDate.setText("");
    txtMkrDelDate.setBounds(new Rectangle(458, 60, 77, 25));
    cbxShipMode.setBounds(new Rectangle(90, 102, 155, 22));
    lblMakerIssueDate.setText("Maker Issue:");
    lblMakerIssueDate.setFont(new java.awt.Font("Dialog", 1, 11));
    lblMakerIssueDate.setBounds(new Rectangle(255, 100, 118, 24));
    txtMkrIssueDate.setText("");
    txtMkrIssueDate.setBounds(new Rectangle(373, 101, 77, 25));
    this.add(blueBkgWhiteCharLabel1, null);

    if(util.PublicVariable.OPERATTING_CENTER.equals("NTHK")||
       util.PublicVariable.OPERATTING_CENTER.equals("001")){
     this.add(lblQty, null);
     this.add(txtTtlQty, null);
    }

    this.add(jLabel13, null);
    this.add(cbxStyUnit, null);
    this.add(txtStylePrefix, null);
    this.add(jLabel14, null);
    this.add(jLabel16, null);
    this.add(txtSeqFrom, null);
    this.add(jLabel17, null);
    this.add(txtSeqTo, null);
    this.add(jLabel15, null);
    this.add(txtStyleBarcodePrefix, null);
    this.add(jLabel18, null);
    this.add(txtSeqFrom4BarCode, null);
    this.add(jLabel19, null);
    this.add(txtSeqTo4BarCode, null);
    this.add(jLabel1, null);
    this.add(jLabel2, null);
    this.add(txtRcfDel, null);
    this.add(txtOrgDel, null);
    this.add(jLabel20, null);
    this.add(txtMkrDelDate, null);
    this.add(cbxShipMode, null);
    this.add(jLabel3, null);
    //to avoid over write c/t head's c/t issue date,in current GUI, can not show vender issue date field
     /*if(!newtimes.preproduction.Constants.isNthkModeNow()){
       this.add(lblMakerIssueDate, null);
       this.add(txtMkrIssueDate, null);
     }*/
    //ct attributions are batch modified in C/T head unit.
    /*if(!newtimes.preproduction.Constants.isNthkModeNow()){
      this.add(lblCtCurrency, null);
      this.add(cbxCtCurrency, null);
      this.add(lblCtPriceTerm, null);
      this.add(cbxCtPriceTerm, null);
      this.add(lblCtDestination, null);
      this.add(cbxCT_Dest, null);
    }*/
    //for fast key in mode,NONE-NTHK center can not modify price fields
    if(util.PublicVariable.OPERATTING_CENTER.equals("NTHK")||
       util.PublicVariable.OPERATTING_CENTER.equals("001")){
      this.add(lblBuyDocPrx, null);
      this.add(txtBuyDocPrx, null);
      this.add(lblBuyActPrx, null);
      this.add(txtBuyActPrx, null);
      this.add(lblMkrDocPrx, null);
      this.add(txtMkrDocPrx, null);
      this.add(lblMkrActPrx, null);
      this.add(txtMkrActPrx, null);
    }


    //this.add(btnCancel, null);
    //this.add(btnOK, null);
  }
  public class PriceKeyProc extends java.awt.event.KeyAdapter{
   synchronized  public void keyReleased(java.awt.event.KeyEvent ke){
       txtBuyActPrx.setText(txtBuyDocPrx.getText());
       txtMkrDocPrx.setText(txtBuyDocPrx.getText());
       txtMkrActPrx.setText(txtBuyDocPrx.getText());

   }
  }
  boolean  btnOK_actionPerformed(ActionEvent e) throws Exception{
    if(!gui2Record())return false;
    if(txtSeqFrom.getText().trim().length()==0){
      exgui.verification.VerifyLib.showAlert("Please Input Item Counts","Please Input Item Counts");
      txtSeqFrom.grabFocus();
      return false;
    }
    if(Integer.parseInt(txtSeqFrom.getText().trim())<1){
      exgui.verification.VerifyLib.showAlert("Please Item Counts Should Be Greater Than Zero",
                                             "Please Item Counts Should Be Greater Than Zero");
      txtSeqFrom.grabFocus();
      return false;
    }
    if(txtSeqTo.getText().trim().length()==0){
      exgui.verification.VerifyLib.showAlert("Please Input Item Counts","Please Input Item Counts");
      txtSeqTo.grabFocus();
      return false;
    }
    if(Integer.parseInt(txtSeqTo.getText().trim())<1){
      exgui.verification.VerifyLib.showAlert("Please Item Counts Should Be Greater Than Zero",
                                             "Please Item Counts Should Be Greater Than Zero");
      txtSeqTo.grabFocus();
      return false;
    }
    if(txtSeqTo.getText().trim().length()+txtStylePrefix.getText().trim().length()>30 ||
       txtSeqFrom.getText().trim().length()+txtStylePrefix.getText().trim().length()>30){
      exgui.verification.VerifyLib.showAlert("Prefix + Sequence text can not exceed 30 characters",
                                             "Style text too long");
      return false;
    }
    if (txtStyleBarcodePrefix.getText().trim().length() > 0) {
      if (txtSeqFrom4BarCode.getText().trim().length() == 0) {
        exgui.verification.VerifyLib.showAlert("Please Input Item Counts",
                                               "Please Input Item Counts");
        txtSeqFrom4BarCode.grabFocus();
        return false;
      }
      if (Integer.parseInt(txtSeqFrom4BarCode.getText().trim()) < 1) {
        exgui.verification.VerifyLib.showAlert(
            "Please Item Counts Should Be Greater Than Zero",
            "Please Item Counts Should Be Greater Than Zero");
        txtSeqFrom4BarCode.grabFocus();
        return false;
      }
      if (txtSeqTo4BarCode.getText().trim().length() == 0) {
        exgui.verification.VerifyLib.showAlert("Please Input Item Counts",
                                               "Please Input Item Counts");
        txtSeqTo4BarCode.grabFocus();
        return false;
      }
      if (Integer.parseInt(txtSeqTo4BarCode.getText().trim()) < 1) {
        exgui.verification.VerifyLib.showAlert(
            "Please Item Counts Should Be Greater Than Zero",
            "Please Item Counts Should Be Greater Than Zero");
        txtSeqTo4BarCode.grabFocus();
        return false;
      }
      if (txtSeqTo4BarCode.getText().trim().length() +
          txtStyleBarcodePrefix.getText().trim().length() > 50 ||
          txtSeqFrom4BarCode.getText().trim().length() +
          txtStylePrefix.getText().trim().length() > 50) {
        exgui.verification.VerifyLib.showAlert(
            "Prefix + Sequence text can not exceed 50 characters",
            "Style text too long");
        return false;
      }
    }

    Vector vct=new Vector();
    String strStyle=txtStylePrefix.getText().trim();
    String strBarCode=txtStyleBarcodePrefix.getText().trim();
    int iniSeq=0, maxSeq=0;int iniSeqBarCode=0;int maxSeqBarCode=0;

    String formatStringForStyle="";
    if(Integer.parseInt(txtSeqTo.getText().trim())> Integer.parseInt(txtSeqFrom.getText().trim())){
      maxSeq=Integer.parseInt(txtSeqTo.getText().trim());
      iniSeq=Integer.parseInt(txtSeqFrom.getText().trim());
      char zeroPrefix[]=new char[txtSeqFrom.getText().trim().length()];
      java.util.Arrays.fill(zeroPrefix,'0');
      formatStringForStyle=new String(zeroPrefix);
    }else{
      maxSeq=Integer.parseInt(txtSeqFrom.getText().trim());
      iniSeq=Integer.parseInt(txtSeqTo.getText().trim());
      char zeroPrefix[]=new char[txtSeqTo.getText().trim().length()];
      java.util.Arrays.fill(zeroPrefix,'0');
      formatStringForStyle=new String(zeroPrefix);
    }


    String formatStringForBarCode="";
   if(strBarCode.length()>0){
    if(Integer.parseInt(txtSeqTo4BarCode.getText().trim())> Integer.parseInt(txtSeqFrom4BarCode.getText().trim())){
      maxSeqBarCode=Integer.parseInt(txtSeqTo4BarCode.getText().trim());
      iniSeqBarCode=Integer.parseInt(txtSeqFrom4BarCode.getText().trim());
      char zeroPrefix[]=new char[txtSeqFrom4BarCode.getText().trim().length()];
      java.util.Arrays.fill(zeroPrefix,'0');
      formatStringForBarCode=new String(zeroPrefix);
    }else{
      maxSeqBarCode=Integer.parseInt(txtSeqFrom4BarCode.getText().trim());
      iniSeqBarCode=Integer.parseInt(txtSeqTo4BarCode.getText().trim());
      char zeroPrefix[]=new char[txtSeqTo4BarCode.getText().trim().length()];
      java.util.Arrays.fill(zeroPrefix,'0');
      formatStringForBarCode=new String(zeroPrefix);
    }
    if((maxSeq-iniSeq)!=(maxSeqBarCode-iniSeqBarCode)){
      exgui.verification.VerifyLib.showAlert("Style Counts Not Match To BarCode Counts",
                                             "Items Count Miss Match");
      return false;
    }
   }
    java.text.DecimalFormat df4Style=new java.text.DecimalFormat(formatStringForStyle);
    java.text.DecimalFormat df4BarCode=new java.text.DecimalFormat(formatStringForBarCode);
    if(txtTtlQty.getText().trim().indexOf(".")!=-1 ){
      if(((String)recToMapping.get("sty_unit")).toUpperCase().startsWith("DZ")){
        exgui.verification.VerifyLib.showAlert(
            "For \"DZ\" Unit Style,Quantity Should Be Integer",
            "DZ UNIT ONLY ALLOW INTEGER QTY");
        txtTtlQty.grabFocus();
        return false;
      }
    }

   //compose style records
    //if not showing maker issue date,have to update issuce date base on
    //to avoid over write c/t head's c/t issue date,in current GUI, can not show vender issue date field

    Object objMkrIssueDate=null;
    String ct_dest_Default=null;
    String ct_prx_trm_Default=null;
    String ct_currency_Default=null;

       database.datatype.Record ct=(database.datatype.Record)exgui2.CONST.BASIC_MAIN_EJB.getDatas(
        util.PublicVariable.USER_RECORD,
        "select PROD_CT_ISSU,PROD_CT_CURRENCY,PROD_CT_PORT,PROD_CT_PRX_TRM,PROD_CT_PYT_TRM from prod_ct_infor where prod_head_pk="+recToMapping.getInt(1)
        ,1,9999).get(0);
       objMkrIssueDate=ct.get(0);
       ct_dest_Default=(String)ct.get(2);
       ct_prx_trm_Default=(String)ct.get(3);
       ct_currency_Default=(String)ct.get(1);
       recToMapping.set(46,objMkrIssueDate);
       recToMapping.set("sty_ct_currency",ct_currency_Default);
       recToMapping.set("sty_ct_dest",ct_dest_Default);//".");
       recToMapping.set("sty_ct_prc_trm",ct_prx_trm_Default);//"FOB");


     for(int i=(iniSeq-iniSeq);i<(maxSeq-iniSeq+1);i++){
       database.datatype.Record rec=(database.datatype.Record)util.MiscFunc.deepCopy(recToMapping);
       if(strStyle.length()>0){
         rec.set(2,strStyle+df4Style.format(i+iniSeq));
       }

       if(strBarCode.length()>0){
         rec.set(118,strBarCode+df4BarCode.format(i+iniSeqBarCode));//barcode
       }
       /*
       if(!util.PublicVariable.OPERATTING_CENTER.equals("NTHK")){
         rec.set(46,now);//vender issue date
       }*/
       if(sc_no!=null)rec.set(5,sc_no);
       vct.add(rec);
     }

     //compose hashmap
     HashMap hm=new HashMap();
     hm.put(newtimesejb.production.StyleListFacade.KEY_BUYER_PRICE_ACT,txtBuyActPrx.getText());
     hm.put(newtimesejb.production.StyleListFacade.KEY_BUYER_PRICE_DOC,txtBuyDocPrx.getText());
     hm.put(newtimesejb.production.StyleListFacade.KEY_MAKER_PRICE_ACT,txtMkrActPrx.getText());
     hm.put(newtimesejb.production.StyleListFacade.KEY_MAKER_PRICE_DOC,txtMkrDocPrx.getText());
     hm.put(newtimesejb.production.StyleListFacade.KEY_DEFAULT_QTY,txtTtlQty.getText());
     util.MiscFunc.showProcessingMessage();
      ((newtimes.production.process.prodmaintain.DB_StyleListHandler)dbprc).addSequencialAddStyles(
      vct,hm,_styNo2Follow);
      util.MiscFunc.hideProcessingMessage();
      return true;
   }

  void btnCancel_actionPerformed(ActionEvent e) {

  }
}
