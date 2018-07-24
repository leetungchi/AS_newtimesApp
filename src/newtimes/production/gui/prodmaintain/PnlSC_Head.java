package newtimes.production.gui.prodmaintain;

import java.awt.*;
import exgui.*;
import javax.swing.*;
import javax.swing.border.*;
import newtimes.preproduction.buyermakerselect.*;

public class PnlSC_Head
    extends processhandler.template.PnlFieldsEditor

    implements newtimes.preproduction.buyermakerselect.BuyerMakerChanged{
    //JPanel {
  BorderLayout borderLayout1 = new BorderLayout();
  JPanel jPanel1 = new JPanel();
  //JLabel blueBkgWhiteCharLabel1 = new JLabel();
  exgui.BlueBkgWhiteCharLabel  blueBkgWhiteCharLabel1 = new exgui.BlueBkgWhiteCharLabel();
  JPanel jPanel2 = new JPanel();
  TitledBorder titledBorder1;
  Border border1;
  TitledBorder titledBorder2;
  JLabel whiteBkgBlueCharLabel6 = new JLabel();
  JLabel whiteBkgBlueCharLabel7 = new JLabel();
  JTextField txtXtaChgRmk_1 = new JTextField();
  JTextField txtXtaChgRmk_2 = new JTextField();
  JTextField txtXtaChgRmk_3 = new JTextField();
  JLabel whiteBkgBlueCharLabel8 = new JLabel();
  JLabel blueBkgWhiteCharLabel7 = new JLabel();
  JLabel blueBkgWhiteCharLabel8 = new JLabel();
  JTextField txtXtaChgFee2 = new JTextField();
  JTextField txtXtaChgFee3 = new JTextField();
  JLabel blueBkgWhiteCharLabel9 = new JLabel();
  JTextField txtXtaChgFee1 = new JTextField();
  JLabel whiteBkgBlueCharLabel9 = new JLabel();
  JLabel blueBkgWhiteCharLabel11 = new JLabel();
  JTextField txtSmpleQty = new JTextField();
  JTextField txtSmplShipQty = new JTextField();
  JLabel blueBkgWhiteCharLabel12 = new JLabel();
  JLabel whiteBkgBlueCharLabel11 = new JLabel();
  SelectBuyerMaker txtSlkGMTbuyer = new SelectBuyerMaker();
  TitledBorder titledBorder3;
  Border border2;
  TitledBorder titledBorder4;
  JLabel blueBkgWhiteCharLabel15 = new JLabel();
  JLabel blueBkgWhiteCharLabel16 = new JLabel();
  JLabel blueBkgWhiteCharLabel17 = new JLabel();
  JComboBox jcbxQcCnty = new JComboBox();
  JLabel txtBuyXontDate1 = new JLabel();
  JTextField txtXorntDate = new JTextField();
  SelectBuyerMaker slkByMkr4Establish = new SelectBuyerMaker();
  TitledBorder titledBorder5;
  Border border3;
  //JTextField txtScDest = new JTextField();
  //JTextField txtScEndRmk = new JTextField();

  TitledBorder titledBorder6;
  Border border4;
  TitledBorder titledBorder7;
  JLabel whiteBkgBlueCharLabel12 = new JLabel();
  //JTextField txtCT_Dest = new JTextField();
  JLabel blueBkgWhiteCharLabel18 = new JLabel();
  Object SCCT_IncludeExclude_Value[]={null,"I","E"};
  String SCCT_IncludeExclude_String[]={"N/A","Include","Exclude"};
  //JComboBox cbxScIncXld = new JComboBox(SCCT_IncludeExclude_String);
  JScrollPane jScrollPane1 = new JScrollPane();
  JScrollPane jSpnl = new JScrollPane();
  JTextArea txtSpxInstruc = new JTextArea();
  SelectBuyerMaker slkByMkr4Supplier = new SelectBuyerMaker();
  JComboBox cbxSpplierCountry = new JComboBox();
  //JComboBox cbxCT_IncXld = new JComboBox(SCCT_IncludeExclude_String);
  JLabel blueBkgWhiteCharLabel5 = new JLabel();
  JLabel blueBkgWhiteCharLabel13 = new JLabel();
  JTextField txtCorspdnt = new JTextField();
  JTextField txtCT_Corspdnt = new JTextField();
  JTextField txtCtXtaChgFee1 = new JTextField();
  JLabel blueBkgWhiteCharLabel10 = new JLabel();
  JLabel whiteBkgBlueCharLabel10 = new JLabel();
  JTextField txtCtXtaChgRmk_1 = new JTextField();
  JLabel blueBkgWhiteCharLabel14 = new JLabel();
  JLabel blueBkgWhiteCharLabel19 = new JLabel();
  JLabel whiteBkgBlueCharLabel13 = new JLabel();
  JTextField txtCtXtaChgFee2 = new JTextField();
  JTextField txtCtXtaChgRmk_3 = new JTextField();
  JPanel jPanel3 = new JPanel();
  JLabel whiteBkgBlueCharLabel14 = new JLabel();
  JTextField txtCtXtaChgFee3 = new JTextField();
  JTextField txtCtXtaChgRmk_2 = new JTextField();
  JLabel chargeLbl1 = new JLabel();
  JLabel chargeLbl2 = new JLabel();
  JTextArea chargeTa = new JTextArea();
  JTextField chargeTx = new JTextField();
  Border border5;
  TitledBorder titledBorder8;
  public PnlSC_Head() {
    try {
      jbInit();
      recordColumnsToCopy=null;
      id4ApplicationProperties=this.getClass().getName();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }

 protected void jbInit() throws Exception {
    //this.setPreferredSize(new Dimension(780,470));
    titledBorder1 = new TitledBorder("");
    border1 = BorderFactory.createBevelBorder(BevelBorder.LOWERED,Color.white,Color.white,new Color(103, 101, 98),new Color(148, 145, 140));
    titledBorder2 = new TitledBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED,Color.white,Color.white,new Color(103, 101, 98),new Color(148, 145, 140)),"S/C Extra Charge");
    titledBorder3 = new TitledBorder("");
    border2 = BorderFactory.createBevelBorder(BevelBorder.LOWERED,Color.white,Color.white,new Color(103, 101, 98),new Color(148, 145, 140));
    titledBorder4 = new TitledBorder(border2,"Buyer Data");
    titledBorder5 = new TitledBorder("");
    border3 = new TitledBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED,Color.white,Color.white,new Color(103, 101, 98),new Color(148, 145, 140)),"");
    titledBorder6 = new TitledBorder("");
    border4 = BorderFactory.createBevelBorder(BevelBorder.LOWERED,Color.white,Color.white,new Color(103, 101, 98),new Color(148, 145, 140));
    titledBorder7 = new TitledBorder(border4,"C/T Attributes");
    border5 = BorderFactory.createBevelBorder(BevelBorder.LOWERED,Color.white,Color.white,new Color(103, 101, 98),new Color(148, 145, 140));
    titledBorder8 = new TitledBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED,Color.white,Color.white,new Color(103, 101, 98),new Color(148, 145, 140)),"C/T Extra Charge");
    this.setLayout(borderLayout1);
    jPanel1.setLayout(null);
    blueBkgWhiteCharLabel1.setText("EXTRA");
    blueBkgWhiteCharLabel1.setBounds(new Rectangle(0, 1, 780, 27));
    //blueBkgWhiteCharLabel6.setBackground(Color.white);
    //blueBkgWhiteCharLabel6.setForeground(new Color(143, 143, 188));
    jPanel2.setFont(new java.awt.Font("SansSerif", 1, 12));
    jPanel2.setBorder(titledBorder2);
    jPanel2.setBounds(new Rectangle(4, 32, 749, 98));
    jPanel2.setLayout(null);
    whiteBkgBlueCharLabel6.setBounds(new Rectangle(284, 25, 78, 23));
    whiteBkgBlueCharLabel6.setText("Remark 2");
    whiteBkgBlueCharLabel7.setText("Remark 3");
    whiteBkgBlueCharLabel7.setBounds(new Rectangle(499, 25, 64, 23));
    txtXtaChgRmk_1.setBounds(new Rectangle(101, 25, 156, 23));
    txtXtaChgRmk_1.setText("");
    txtXtaChgRmk_2.setBounds(new Rectangle(361, 25, 117, 23));
    txtXtaChgRmk_2.setText("");
    txtXtaChgRmk_3.setText("");
    txtXtaChgRmk_3.setBounds(new Rectangle(563, 25, 164, 23));
    whiteBkgBlueCharLabel8.setBounds(new Rectangle(10, 25, 91, 23));
    whiteBkgBlueCharLabel8.setText("Remark 1");
    blueBkgWhiteCharLabel7.setText("Fee 3");
    blueBkgWhiteCharLabel7.setBounds(new Rectangle(499, 61, 34, 22));
    blueBkgWhiteCharLabel8.setText("Fee 2");
    blueBkgWhiteCharLabel8.setBounds(new Rectangle(284, 61, 36, 22));
    txtXtaChgFee2.setText("");
    txtXtaChgFee2.setBounds(new Rectangle(362, 61, 116, 22));
    txtXtaChgFee3.setText("");
    txtXtaChgFee3.setBounds(new Rectangle(563, 61, 164, 22));
    blueBkgWhiteCharLabel9.setBounds(new Rectangle(8, 61, 41, 22));
    blueBkgWhiteCharLabel9.setText("Fee 1");
    txtXtaChgFee1.setBounds(new Rectangle(101, 61, 155, 22));
    txtXtaChgFee1.setText("");
    whiteBkgBlueCharLabel9.setBounds(new Rectangle(260, 554, 77, 32));
    whiteBkgBlueCharLabel9.setText("<html><body>Sample Ship<br>Qty</body></html>");
    blueBkgWhiteCharLabel11.setText("Supplier");
    blueBkgWhiteCharLabel11.setBounds(new Rectangle(259, 595, 82, 18));
    txtSmpleQty.setBounds(new Rectangle(93, 560, 156, 23));
    txtSmpleQty.setText("");
    txtSmplShipQty.setBounds(new Rectangle(342, 556, 158, 23));
    txtSmplShipQty.setText("");
    blueBkgWhiteCharLabel12.setBounds(new Rectangle(7, 372, 85, 22));
    blueBkgWhiteCharLabel12.setText("Garment Buyer");
    whiteBkgBlueCharLabel11.setBounds(new Rectangle(5, 564, 75, 23));
    whiteBkgBlueCharLabel11.setText("Sample Qty");
    txtSlkGMTbuyer.setBounds(new Rectangle(107, 372, 153, 23)); //////
    blueBkgWhiteCharLabel15.setText("QC Country");
    blueBkgWhiteCharLabel15.setBounds(new Rectangle(504, 459, 93, 22));
    blueBkgWhiteCharLabel16.setText("<html><body>Special<br>Instruction</body></html>");
    blueBkgWhiteCharLabel16.setBounds(new Rectangle(6, 304, 78, 63));
    blueBkgWhiteCharLabel17.setBounds(new Rectangle(508, 557, 57, 22));
    blueBkgWhiteCharLabel17.setBackground(Color.white);
    blueBkgWhiteCharLabel17.setForeground(Color.black);
    blueBkgWhiteCharLabel17.setText("Establish");
    jcbxQcCnty.setBounds(new Rectangle(593, 459, 172, 22));
    txtBuyXontDate1.setBounds(new Rectangle(276, 372, 82, 23));
    txtBuyXontDate1.setText("Ex-orient Date");
    txtXorntDate.setBounds(new Rectangle(367, 372, 114, 23));
    txtXorntDate.setText("");
    slkByMkr4Establish.setBounds(new Rectangle(568, 557, 182, 22));
    //cbxSCDest.setText("");
    //txtScEndRmk.setText("");
    //txtScEndRmk.setBounds(new Rectangle(119, 123, 348, 22));
    jPanel1.setFont(new java.awt.Font("Dialog", 1, 11));
    //cbxScIncXld.setBounds(new Rectangle(356, 165, 178, 23));
    whiteBkgBlueCharLabel12.setBounds(new Rectangle(14, 22, 97, 23));
    whiteBkgBlueCharLabel12.setText("Destination");
    //txtCT_Dest.setBounds(new Rectangle(110, 22, 117, 23));
    //txtCT_Dest.setText("");
    blueBkgWhiteCharLabel18.setBounds(new Rectangle(508, 584, 57, 37));
    blueBkgWhiteCharLabel18.setText("<html><body>Supplier<br>Country</body></html>");
    jScrollPane1.setBounds(new Rectangle(95, 304, 669, 63));
    txtSpxInstruc.setText("");
    slkByMkr4Supplier.setBounds(new Rectangle(342, 591, 158, 23));
    cbxSpplierCountry.setBounds(new Rectangle(568, 586, 183, 23));
    //cbxCT_IncXld.setBounds(new Rectangle(98, 167, 153, 23));
    blueBkgWhiteCharLabel5.setBounds(new Rectangle(3, 500, 119, 22));
    blueBkgWhiteCharLabel5.setBackground(Color.white);
    blueBkgWhiteCharLabel5.setForeground(Color.black);
    blueBkgWhiteCharLabel5.setText("S/C Correspondent");
    blueBkgWhiteCharLabel13.setForeground(Color.black);
    blueBkgWhiteCharLabel13.setText("C/T Correspondent");
    blueBkgWhiteCharLabel13.setBounds(new Rectangle(455, 499, 117, 23));
    txtCorspdnt.setBounds(new Rectangle(144, 500, 147, 22));
    txtCorspdnt.setText("");
    txtCT_Corspdnt.setText("");
    txtCT_Corspdnt.setBounds(new Rectangle(580, 500, 160, 22));
    txtCtXtaChgFee1.setText("");
    txtCtXtaChgFee1.setBounds(new Rectangle(101, 61, 155, 22));
    blueBkgWhiteCharLabel10.setText("Fee 1");
    blueBkgWhiteCharLabel10.setBounds(new Rectangle(8, 61, 41, 22));
    whiteBkgBlueCharLabel10.setText("Remark 1");
    whiteBkgBlueCharLabel10.setBounds(new Rectangle(10, 25, 91, 23));
    txtCtXtaChgRmk_1.setText("");
    txtCtXtaChgRmk_1.setBounds(new Rectangle(101, 25, 156, 23));
    blueBkgWhiteCharLabel14.setBounds(new Rectangle(499, 61, 34, 22));
    blueBkgWhiteCharLabel14.setText("Fee 3");
    blueBkgWhiteCharLabel19.setBounds(new Rectangle(284, 61, 36, 22));
    blueBkgWhiteCharLabel19.setText("Fee 2");
    whiteBkgBlueCharLabel13.setBounds(new Rectangle(499, 25, 64, 23));
    whiteBkgBlueCharLabel13.setText("Remark 3");
    txtCtXtaChgFee2.setBounds(new Rectangle(362, 61, 116, 22));
    txtCtXtaChgFee2.setText("");
    txtCtXtaChgRmk_3.setBounds(new Rectangle(563, 25, 164, 23));
    txtCtXtaChgRmk_3.setText("");
    jPanel3.setLayout(null);
    jPanel3.setBounds(new Rectangle(4, 142, 749, 98));
    jPanel3.setBorder(titledBorder8);
    jPanel3.setFont(new java.awt.Font("SansSerif", 1, 12));
    whiteBkgBlueCharLabel14.setBounds(new Rectangle(284, 25, 78, 23));
    whiteBkgBlueCharLabel14.setText("Remark 2");
    txtCtXtaChgFee3.setText("");
    txtCtXtaChgFee3.setBounds(new Rectangle(563, 61, 164, 22));
    txtCtXtaChgRmk_2.setBounds(new Rectangle(361, 25, 117, 23));
    txtCtXtaChgRmk_2.setText("");
    chargeLbl1.setText("<html><body>Buyer<BR>Surcharge :</body></html>") ;
    chargeLbl1.setBounds(new Rectangle(6, 225, 78, 63));
    chargeLbl2 = new JLabel("<html><body>Surcharge<br>Amount :</body></html>");
    chargeLbl2.setBounds(new Rectangle(570, 225, 78, 63));
 //   chargeTa.setColumns(50);
 //   chargeTa.setRows(6);
 //   chargeTa.setBounds(new Rectangle(70, 243, 490, 52));
    jSpnl.getViewport().add(chargeTa);
    jSpnl.setBounds(new Rectangle(72, 243, 492, 52));
    chargeTx.setBounds(new Rectangle(643, 243, 86, 21));

    this.add(jPanel1,  BorderLayout.CENTER);
    jPanel2.add(whiteBkgBlueCharLabel8, null);
    jPanel2.add(txtXtaChgRmk_1, null);
    jPanel2.add(txtXtaChgRmk_2, null);
    jPanel2.add(txtXtaChgFee2, null);
    jPanel2.add(blueBkgWhiteCharLabel9, null);
    jPanel2.add(txtXtaChgFee1, null);
    jPanel2.add(txtXtaChgRmk_3, null);
    jPanel2.add(txtXtaChgFee3, null);
    jPanel2.add(blueBkgWhiteCharLabel7, null);
    jPanel2.add(whiteBkgBlueCharLabel7, null);
    jPanel2.add(whiteBkgBlueCharLabel6, null);
    jPanel2.add(blueBkgWhiteCharLabel8, null);
    jPanel1.add(jPanel2, null);
    jPanel1.add(blueBkgWhiteCharLabel1, null);
    jPanel1.add(blueBkgWhiteCharLabel5, null);
    jPanel1.add(txtCorspdnt, null);
    jPanel1.add(blueBkgWhiteCharLabel13, null);
    jPanel1.add(txtCT_Corspdnt, null);
    jPanel1.add(whiteBkgBlueCharLabel11, null);
    jPanel1.add(txtSmpleQty, null);
    jPanel1.add(whiteBkgBlueCharLabel9, null);
    jPanel1.add(txtSmplShipQty, null);
    jPanel1.add(blueBkgWhiteCharLabel11, null);
    jPanel1.add(slkByMkr4Supplier, null);
    jPanel1.add(blueBkgWhiteCharLabel17, null);
    jPanel1.add(slkByMkr4Establish, null);
    jPanel1.add(blueBkgWhiteCharLabel18, null);
    jPanel1.add(cbxSpplierCountry, null);
    jPanel3.add(whiteBkgBlueCharLabel10, null);
    jPanel3.add(txtCtXtaChgRmk_1, null);
    jPanel3.add(txtCtXtaChgRmk_2, null);
    jPanel3.add(txtCtXtaChgFee2, null);
    jPanel3.add(blueBkgWhiteCharLabel10, null);
    jPanel3.add(txtCtXtaChgFee1, null);
    jPanel3.add(txtCtXtaChgRmk_3, null);
    jPanel3.add(txtCtXtaChgFee3, null);
    jPanel3.add(blueBkgWhiteCharLabel14, null);
    jPanel3.add(whiteBkgBlueCharLabel13, null);
    jPanel3.add(whiteBkgBlueCharLabel14, null);
    jPanel3.add(blueBkgWhiteCharLabel19, null);

    jPanel1.add(chargeLbl1,null);
    jPanel1.add(chargeLbl2,null );
     jPanel1.add(chargeTx,null);
      jPanel1.add(jSpnl,null);
    jPanel1.add(blueBkgWhiteCharLabel12, null);
    jPanel1.add(txtSlkGMTbuyer, null);
    jPanel1.add(txtBuyXontDate1, null);
    jPanel1.add(txtXorntDate, null);
    jPanel1.add(blueBkgWhiteCharLabel16, null);
    jPanel1.add(jScrollPane1, null);
    jPanel1.add(jPanel3, null);
    jScrollPane1.getViewport().add(txtSpxInstruc, null);
    //jPanel4.add(whiteBkgBlueCharLabel12, null);
    //jPanel4.add(txtCT_Dest, null);
    //jPanel1.add(blueBkgWhiteCharLabel15, null);
    //jPanel1.add(jcbxQcCnty, null);
    //jPanel3.add(cbxCT_IncXld, null);
    //jPanel3.add(cbxScIncXld, null);
    //jPanel3.add(txtScEndRmk, null);
    slkByMkr4Supplier.setModifyNotifyTo(this);
  }

  public void changeBuyerMaker(database.datatype.Record buyerMkerRecord){
    String mkrCountry=null;
    if(buyerMkerRecord!=null){
       mkrCountry=(String)buyerMkerRecord.get(2);
    }
    //System.out.println("buyer reocrd:"+buyerMkerRecord);
    //mapping to maker country
    java.util.Vector recCountry=newtimes.preproduction.guis.tempProperties.tmpCountries;
    if(mkrCountry!=null){
      for (int i = 0; i < recCountry.size(); i++) {
        database.datatype.Record rectmp = (database.datatype.Record) recCountry.get(i);
        Object cntyCode = rectmp.get(0);
        if (util.MiscFunc.isEqual(mkrCountry, cntyCode)) {
          cbxSpplierCountry.setSelectedIndex(i + 1);
          //System.out.println("Matched,index is:"+i);
          break;
        }
      }
    }else{
      cbxSpplierCountry.setSelectedIndex(0);
    }

  }
  public void record2Gui(){
    try {
      dataBoundGUIs.clear();

      txtSlkGMTbuyer.init(
          "PROD_GMT_BYR",
          recToMapping.get("PROD_GMT_BYR"),
          txtSlkGMTbuyer.TYPE_BUYER,true);
      dataBoundGUIs.add(txtSlkGMTbuyer);
      /*
      slkByMkr4Establish.init(
          "PROD_ESTABLISH",
          recToMapping.get("PROD_ESTABLISH"),
          slkByMkr4Establish.TYPE_BUYER,true);
      dataBoundGUIs.add(slkByMkr4Establish);
      */
      /*
      Object vftxtSC_NO = exgui.verification.CellFormat.getOrdinaryField(20);
      dataBoundGUIs.add(new exgui.DataBindTextWithChecker(txtSC_NO,
          "PROD_SC_NO", recToMapping.get("PROD_SC_NO"), 20,
          (exgui.Object2String) vftxtSC_NO,
                        (exgui.ultratable.CellTxtEditorFormat) vftxtSC_NO)
                        );*/
      /*
      Object vftxtSCHeadRmk = exgui.verification.CellFormat.getOrdinaryField(
          15);
      dataBoundGUIs.add(new exgui.DataBindTextWithChecker(txtBuyerSCNO,
          "PROD_BYR_SC_NO", recToMapping.get("PROD_BYR_SC_NO"), 15,
          (exgui.Object2String) vftxtSCHeadRmk,
                        (exgui.ultratable.CellTxtEditorFormat) vftxtSCHeadRmk)
                        );

     java.util.Vector branches=
         ((newtimes.production.process.prodmaintain.DB_ProdSC)dbprc).BRANCHES;
     exgui.DataBindJCombobox DbJcbxjcbxBranches= new exgui.DataBindJCombobox(
         cbxBranches, "PROD_BRNCH_BRIEF", branches, "BRNCH_BRIEF",
         "BRNCH_BRIEF", recToMapping.get("PROD_BRNCH_BRIEF"),"",null);
     dataBoundGUIs.add(DbJcbxjcbxBranches);
       */
      //System.out.println(" production record is:"+recToMapping);
      /*
      java.util.Vector recPaymentTerm=
          newtimes.preproduction.guis.tempProperties.tmpPaymentTerms;


      exgui.DataBindJCombobox DbJcbxjcbxPaymentTerm=
          new exgui.DataBindJCombobox(
          cbxScPaymentTerm, "PROD_PYT_TRM", recPaymentTerm, "PYT_TRM",
          "PYT_TRM", recToMapping.get("PROD_PYT_TRM"),"",null);
      dataBoundGUIs.add(DbJcbxjcbxPaymentTerm);
      */

      //Object vftxtScDest = exgui.verification.CellFormat.getOrdinaryField(20);
      //S/C Dest
      /*
      java.util.Vector recDests=((newtimes.production.process.prodmaintain.DB_ProdSC)
               dbprc).getDestinations();

              new exgui.DataBindJCombobox(
              cbxSCDest, "PROD_SC_DEST", recDests, "Dest_name",
              "dest_name", recToMapping.get("PROD_SC_DEST"),"",null);
    //limit the length;
    exgui.DataBindText txtDestLen=
          new exgui.DataBindText
          ((javax.swing.text.JTextComponent)cbxSCDest.getEditor().getEditorComponent(),"",
          recToMapping.get("PROD_SC_DEST"),20);
      */

      /*
      Object vftxtCorspdnt = exgui.verification.CellFormat.getOrdinaryField(50);

      //sc correspondent
      dataBoundGUIs.add(new exgui.DataBindTextWithChecker(txtCorspdnt,
          "PROD_CRRSPNDNT", recToMapping.get("PROD_CRRSPNDNT"), 50,
          (exgui.Object2String) vftxtCorspdnt,
                        (exgui.ultratable.CellTxtEditorFormat) vftxtCorspdnt)
                        );
     //C/T Correspondent
     dataBoundGUIs.add(new exgui.DataBindTextWithChecker(txtCT_Corspdnt,
         "PROD_CT_CRRSPNDNT", recToMapping.get("PROD_CT_CRRSPNDNT"), 50,
         (exgui.Object2String) vftxtCorspdnt,
                       (exgui.ultratable.CellTxtEditorFormat) vftxtCorspdnt)
                       );
      */
      /*
      Object vftxtBuyerLabel = exgui.verification.CellFormat.getOrdinaryField(
          50);
      dataBoundGUIs.add(new exgui.DataBindTextWithChecker(txtBuyerLabel,
          "PROD_LABEL", recToMapping.get("PROD_LABEL"), 50,
          (exgui.Object2String) vftxtBuyerLabel,
                        (exgui.ultratable.CellTxtEditorFormat) vftxtBuyerLabel)
                        );
      */
      Object vftxtXtaChgRmk_1 = exgui.verification.CellFormat.getOrdinaryField(
          70);
      dataBoundGUIs.add(new exgui.DataBindTextWithChecker(txtXtaChgRmk_1,
          "PROD_BUY_EXTRA1_REMK", recToMapping.get("PROD_BUY_EXTRA1_REMK"), 70,
          (exgui.Object2String) vftxtXtaChgRmk_1,
                        (exgui.ultratable.CellTxtEditorFormat) vftxtXtaChgRmk_1)
                        );
      dataBoundGUIs.add(new exgui.DataBindTextWithChecker(txtCtXtaChgRmk_1,
        "PROD_MKR_EXTRA1_REMK", recToMapping.get("PROD_MKR_EXTRA1_REMK"), 70,
        (exgui.Object2String) vftxtXtaChgRmk_1,
                      (exgui.ultratable.CellTxtEditorFormat) vftxtXtaChgRmk_1)
                      );
    dataBoundGUIs.add(new exgui.DataBindTextWithChecker(txtCtXtaChgRmk_2,
        "PROD_MKR_EXTRA2_REMK", recToMapping.get("PROD_MKR_EXTRA2_REMK"), 70,
        (exgui.Object2String)vftxtXtaChgRmk_1,
        (exgui.ultratable.CellTxtEditorFormat)vftxtXtaChgRmk_1)
                      );
    dataBoundGUIs.add(new exgui.DataBindTextWithChecker(txtCtXtaChgRmk_3,
        "PROD_MKR_EXTRA3_REMK", recToMapping.get("PROD_MKR_EXTRA3_REMK"), 70,
        (exgui.Object2String)vftxtXtaChgRmk_1,
        (exgui.ultratable.CellTxtEditorFormat)vftxtXtaChgRmk_1)
                      );


      Object vftxtXtaChgRmk_2 = exgui.verification.CellFormat.getOrdinaryField(
          70);
      dataBoundGUIs.add(new exgui.DataBindTextWithChecker(txtXtaChgRmk_2,
          "PROD_BUY_EXTRA2_REMK", recToMapping.get("PROD_BUY_EXTRA2_REMK"), 70,
          (exgui.Object2String) vftxtXtaChgRmk_2,
                        (exgui.ultratable.CellTxtEditorFormat) vftxtXtaChgRmk_2)
                        );
      Object vftxtXtaChgRmk_3 = exgui.verification.CellFormat.getOrdinaryField(
          70);
      dataBoundGUIs.add(new exgui.DataBindTextWithChecker(txtXtaChgRmk_3,
          "PROD_BUY_EXTRA3_REMK", recToMapping.get("PROD_BUY_EXTRA3_REMK"), 70,
          (exgui.Object2String) vftxtXtaChgRmk_3,
                        (exgui.ultratable.CellTxtEditorFormat) vftxtXtaChgRmk_3)
                        );
      Object vftxtXtaChgFee2 = exgui.verification.CellFormat.
          getDoubleFormatAllowNull(7, 3);
      dataBoundGUIs.add(new exgui.DataBindTextWithChecker(txtXtaChgFee2,
          "PROD_BUY_EXTRA2_CHG", recToMapping.get("PROD_BUY_EXTRA2_CHG"), 11,
          (exgui.Object2String) vftxtXtaChgFee2,
                        (exgui.ultratable.CellTxtEditorFormat) vftxtXtaChgFee2)
                        );
      dataBoundGUIs.add(new exgui.DataBindTextWithChecker(txtCtXtaChgFee1,
          "PROD_MKR_EXTRA1_CHG", recToMapping.get("PROD_MKR_EXTRA1_CHG"), 11,
          (exgui.Object2String) vftxtXtaChgFee2,
                        (exgui.ultratable.CellTxtEditorFormat) vftxtXtaChgFee2)
                        );

      dataBoundGUIs.add(new exgui.DataBindTextWithChecker(txtCtXtaChgFee2,
          "PROD_MKR_EXTRA2_CHG", recToMapping.get("PROD_MKR_EXTRA2_CHG"), 11,
          (exgui.Object2String) vftxtXtaChgFee2,
                        (exgui.ultratable.CellTxtEditorFormat) vftxtXtaChgFee2)
                        );
      dataBoundGUIs.add(new exgui.DataBindTextWithChecker(txtCtXtaChgFee3,
          "PROD_MKR_EXTRA3_CHG", recToMapping.get("PROD_MKR_EXTRA3_CHG"), 11,
          (exgui.Object2String) vftxtXtaChgFee2,
                        (exgui.ultratable.CellTxtEditorFormat) vftxtXtaChgFee2)
                        );
      dataBoundGUIs.add(new exgui.DataBindTextWithChecker(chargeTx,
         "PROD_ESTABLISH", recToMapping.get("PROD_ESTABLISH"), 11,
         (exgui.Object2String) vftxtXtaChgFee2,
                       (exgui.ultratable.CellTxtEditorFormat) vftxtXtaChgFee2)
                       );


      Object vftxtXtaChgFee3 = exgui.verification.CellFormat.
          getDoubleFormatAllowNull(7, 3);
      dataBoundGUIs.add(new exgui.DataBindTextWithChecker(txtXtaChgFee3,
          "PROD_BUY_EXTRA3_CHG", recToMapping.get("PROD_BUY_EXTRA3_CHG"), 11,
          (exgui.Object2String) vftxtXtaChgFee3,
                        (exgui.ultratable.CellTxtEditorFormat) vftxtXtaChgFee3)
                        );
      Object vftxtXtaChgFee1 = exgui.verification.CellFormat.
          getDoubleFormatAllowNull(7, 3);
      dataBoundGUIs.add(new exgui.DataBindTextWithChecker(txtXtaChgFee1,
          "PROD_BUY_EXTRA1_CHG", recToMapping.get("PROD_BUY_EXTRA1_CHG"), 11,
          (exgui.Object2String) vftxtXtaChgFee1,
                        (exgui.ultratable.CellTxtEditorFormat) vftxtXtaChgFee1)
                        );
      /*
      Object vftxtSmpleQty =
          exgui.verification.CellFormat.getIntVerifierAllowNull(2);
      dataBoundGUIs.add(new exgui.DataBindTextWithChecker(txtSmpleQty,
          "PROD_PROD_SMPL", recToMapping.get("PROD_PROD_SMPL"), 2,
          (exgui.Object2String) vftxtSmpleQty,
                        (exgui.ultratable.CellTxtEditorFormat) vftxtSmpleQty)
                        );
      */
      /*
      slkByMkr4Supplier.init(
          "PROD_SUPPLR",
          recToMapping.get("PROD_SUPPLR"),
          slkByMkr4Establish.TYPE_FABRIC_MILL,true);
      dataBoundGUIs.add(slkByMkr4Supplier);
      */

      /*
      exgui.DataBindJCombobox DbJcbxcbxSupplierCountry =
          new exgui.DataBindJCombobox(cbxSpplierCountry,
                                      "PROD_SUPPLR_CNTY_CODE",
                                      newtimes.preproduction.guis.tempProperties.tmpCountries,
                                      "CNTY_NAME","CNTY_NAME",
                                      recToMapping.get("PROD_SUPPLR_CNTY_CODE"),"NONE",null);
      dataBoundGUIs.add(DbJcbxcbxSupplierCountry);
      */

     /*
      Object vftxtSmplShipQty =
          exgui.verification.CellFormat.getIntVerifier(2);
      dataBoundGUIs.add(new exgui.DataBindTextWithChecker(txtSmplShipQty,
          "PROD_SHIP_SMPL", recToMapping.get("PROD_SHIP_SMPL"), 2,
          (exgui.Object2String) vftxtSmplShipQty,
                        (exgui.ultratable.CellTxtEditorFormat) vftxtSmplShipQty)
                         );
       */
      Object vftxtSpxInstruc = exgui.verification.CellFormat.getOrdinaryField(
          200);

      dataBoundGUIs.add(new exgui.DataBindTextWithChecker(txtSpxInstruc,
          "PROD_SPECIAL_INSTURCTION",
                        recToMapping.get("PROD_SPECIAL_INSTURCTION"), 200,
                                            (exgui.Object2String)
                                            vftxtSpxInstruc,
                                            (exgui.ultratable.CellTxtEditorFormat)
                                            vftxtSpxInstruc)
                        );
      Object vftxtChrInstruc = exgui.verification.CellFormat.getOrdinaryField(
          800);
      dataBoundGUIs.add(new exgui.DataBindTextWithChecker(chargeTa,
         "PROD_FAB_CONTENT",
                       recToMapping.get("PROD_FAB_CONTENT"), 800,
                                           (exgui.Object2String)
                                           vftxtChrInstruc,
                                           (exgui.ultratable.CellTxtEditorFormat)
                                           vftxtChrInstruc)
                       );



     /*
      Object vftxtBuySC_ISU_Date = exgui.verification.CellFormat.
          getDateStringFormaterAllowNull(); ;
      dataBoundGUIs.add(new exgui.DataBindTextWithChecker(txtBuySC_ISU_Date,
          "PROD_BYR_SC_ISSUE", recToMapping.get("PROD_BYR_SC_ISSUE"), 10,
          (exgui.Object2String) vftxtBuySC_ISU_Date,
                        (exgui.ultratable.CellTxtEditorFormat)
                             vftxtBuySC_ISU_Date)
                        );
      */
      Object vftxtXorntDate = exgui.verification.CellFormat.
          getDateStringFormaterAllowNull(); ;
      dataBoundGUIs.add(new exgui.DataBindTextWithChecker(txtXorntDate,
          "PROD_BYR_EX_ORIENT", recToMapping.get("PROD_BYR_EX_ORIENT"), 10,
          (exgui.Object2String) vftxtXorntDate,
                        (exgui.ultratable.CellTxtEditorFormat) vftxtXorntDate)
                        );
      /*
      exgui.DataBindJCombobox DbJcbxjcbxCurrency = new exgui.DataBindJCombobox(
          cbxCurrency, "PROD_SC_CURRENCY", currencyRecords, "CRNCY_NAME",
          "CRNCY_NAME", recToMapping.get("PROD_SC_CURRENCY"),"",null);
      dataBoundGUIs.add(DbJcbxjcbxCurrency);
      */

      //String SC_IncXldValue=(String)recToMapping.get("PROD_SC_INCL_EXCL_QTA");
      //String CT_IncXldValue=(String)recToMapping.get("PROD_CT_INCL_EXCL_QTA");
      //cbxScIncXld.setSelectedIndex(getIncXldIndex(SC_IncXldValue));
      //cbxCT_IncXld.setSelectedIndex(getIncXldIndex(CT_IncXldValue));
      //============================================
      /*
      Object prodStatusObj=
          newtimes.preproduction.Constants.CURRENT_PREPROD_HEAD_RECORD.get("PRODUCTION_AUDIT_STATUS");
      if(prodStatusObj!=null){
        int auditStatusCode=
            newtimes.preproduction.Constants.CURRENT_PREPROD_HEAD_RECORD.getInt("PRODUCTION_AUDIT_STATUS");
        if(auditStatusCode==
          newtimesejb.preproduction.PreProductionHead.AUDIT_STATUS_CONFIRMED||
          auditStatusCode==
          newtimesejb.preproduction.PreProductionHead.AUDIT_STATUS_PRINTED){
          cbxCurrency.setEnabled(false);
          cbxCurrency.setEditable(false);
          cbxCurrency.setFocusable(false);
        }
      }
     */


      if (recordColumnsToCopy == null) {
        recordColumnsToCopy = new String[dataBoundGUIs.size()];
        for (int i = 0; i < dataBoundGUIs.size(); i++) {
          recordColumnsToCopy[i] = ((exgui.DataBindGUIObject) dataBoundGUIs.
                                    get(i)).getOrgRecField();


        }
      }
    }catch (Exception e) {
      e.printStackTrace();
    }
  }
  public void doPaste(){
    try{
      database.datatype.Record tmprec =
          (database.datatype.Record) util.ApplicationProperites.getProperties(
        id4ApplicationProperties);
      if(tmprec==null){
        exgui.verification.VerifyLib.showAlert("There Is No Copied Data To Past",
                                               "No Data To Past");
        return;
      }
    recToMapping.set("PROD_SC_INCL_EXCL_QTA",
                     util.ApplicationProperites.getProperties(
        "newtimes.production.gui.prodmaintain.PnlScHead_SC_IncludeExclueCopyValue"));
    recToMapping.set("PROD_CT_INCL_EXCL_QTA",
                     util.ApplicationProperites.getProperties(
        "newtimes.production.gui.prodmaintain.PnlScHead_CT_IncludeExclueCopyValue"));
   //set to application properties
   util.ApplicationProperites.setProperties(id4ApplicationProperties,tmprec);
    //super.doPaste();
    for(int i=0;i<recordColumnsToCopy.length;i++){
      if(recordColumnsToCopy[i].trim().toUpperCase().equals("PROD_SC_NO")){
        continue;
      }
      recToMapping.set(
         recordColumnsToCopy[i],
         tmprec.get(recordColumnsToCopy[i])
      );
    }
    recToMapping.set(
       "prod_sc_dest",
       util.ApplicationProperites.getProperties(id4ApplicationProperties+"_copy_sc_dest"));
    //System.out.println("restore from past:"+util.ApplicationProperites.getProperties(id4ApplicationProperties+"_copy_sc_dest"));
    record2Gui();
    }catch(Exception e){
      e.printStackTrace();
    }
  }
  int getIncXldIndex(String str)throws Exception{
    if(str==null) return 0;
    for(int i=1;i<SCCT_IncludeExclude_Value.length;i++){
      if(str.equalsIgnoreCase(SCCT_IncludeExclude_Value[i].toString())) return i;
    }
    throw new Exception("value :"+str+" for PROD_CT_INCL_EXCL_QTA OR PROD_ST_INCL_EXCL_QTA not found");
  }
  public void doUpdate()throws Exception{
    try{
      newtimes.production.ProdMaintain_Properties.setWaitCursor();
      util.MiscFunc.showProcessingMessage();
      /*
      recToMapping.set("PROD_SC_INCL_EXCL_QTA",SCCT_IncludeExclude_Value[cbxScIncXld.getSelectedIndex()]);
      recToMapping.set("PROD_CT_INCL_EXCL_QTA",SCCT_IncludeExclude_Value[cbxCT_IncXld.getSelectedIndex()]);
      */
      super.doUpdate();
      //exgui.verification.VerifyLib.showPlanMsg("Update OK","Update OK");
      //PROD_SC_PRC_TRM, PROD_SC_CURRENCY
      newtimes.preproduction.Constants.CURRENT_PREPROD_HEAD_RECORD.set(
          "PRODUCTION_SC_PRC_TRM",recToMapping.get("PROD_SC_PRC_TRM"));
      newtimes.preproduction.Constants.CURRENT_PREPROD_HEAD_RECORD.set(
          "PRODUCTION_SC_CURRENCY",recToMapping.get("PROD_SC_CURRENCY"));
    }catch(Exception e){
      e.printStackTrace();
      util.MiscFunc.hideProcessingMessage();
      exgui.verification.VerifyLib.showAlert("Update Fail!!","Update Fail!!");
      throw e;
    }finally{
      util.MiscFunc.hideProcessingMessage();
            newtimes.production.ProdMaintain_Properties.setNormalCursor();
    }

  }
  public void doPrint(){
  }
}
