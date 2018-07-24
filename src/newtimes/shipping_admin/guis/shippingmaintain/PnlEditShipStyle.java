package newtimes.shipping_admin.guis.shippingmaintain;

import java.awt.*;
import exgui.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.border.*;
import database.datatype.Record;
/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class PnlEditShipStyle extends
  processhandler.template.PnlFieldsEditor  {
//  JPanel{
  BlueBkgWhiteCharLabel lblTitleBar = new BlueBkgWhiteCharLabel();
  JLabel jLabel21 = new JLabel();
  JLabel jLabel1112 = new JLabel();
  JLabel lblBuyerDiscPc = new JLabel();
  JTextField txtDiv = new JTextField();
  JLabel lblMkrDiscPer = new JLabel();
  JLabel lblBuyerDiscLumpSum = new JLabel();
  JLabel lblBuyerComm = new JLabel();
  JLabel jLabel3 = new JLabel();
  JTextField txtFTY = new JTextField();
  JPanel jPanel3 = new JPanel();
  JTextField txtPO = new JTextField();
  JLabel jLabel2 = new JLabel();
  JTextField txtSea = new JTextField();
  JPanel jPanel2 = new JPanel();
  JTextField txtYear = new JTextField();
  JLabel jLabel23 = new JLabel();
  JLabel jLabel9 = new JLabel();
  JLabel jLabel19 = new JLabel();
  JLabel lblBuyerDiscDz = new JLabel();
  JTextField txtUnit = new JTextField();
  JLabel jLabel7 = new JLabel();
  JTextField txtStyle = new JTextField();
  JLabel jLabel120 = new JLabel();
  JTextField txtScNo = new JTextField();
  JTextField txtRange = new JTextField();
  JLabel jLabel15 = new JLabel();
  JLabel jLabel10 = new JLabel();
  JTextField txtBuyComm = new JTextField();
  JTextField txtBuyDsctPc = new JTextField();
  JTextField txtBuyDsctLumpSum = new JTextField();
  JTextField txtMkrDsctPer = new JTextField();
  JTextField txtBuyDsctDz = new JTextField();
  JPanel jPanel1 = new JPanel();
  Border border1;
  TitledBorder titledBorder1;
  JPanel jPanel4 = new JPanel();
  Border border2;
  TitledBorder titledBorder2;
  BorderLayout borderLayout1 = new BorderLayout();
  JScrollPane jScrollPane1 = new JScrollPane();
  JTextArea txtAreaOdrQty = new JTextArea();
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel1 = new BlueBkgWhiteCharLabel();
  BlueBkgWhiteCharLabel lblOrgTtlQty = new BlueBkgWhiteCharLabel();
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel2 = new BlueBkgWhiteCharLabel();
  BlueBkgWhiteCharLabel lblShippedQty = new BlueBkgWhiteCharLabel();
  JScrollPane jScrollPane2 = new JScrollPane();
  JTextArea txtShipQtyDesc = new JTextArea();
  JButton btnEditPrxQty = new JButton();
  boolean isProcessingDelete=false;
  JLabel lblMkrDiscPc = new JLabel();
  JLabel lblMkrDiscDz = new JLabel();
  JLabel lblMkrDiscLumpSum = new JLabel();
  JTextField txtMkrDsctPc = new JTextField();
  JTextField txtMkrDsctDz = new JTextField();
  JTextField txtMkrDsctLumpSum = new JTextField();
  exgui.DataBindTextWithChecker dbBuyerComm;
 static String sqlHead2checkShipComm=null;
  public static boolean isEditingShipQty=true;
  JLabel lblCat = new JLabel();
  JTextField txtCatData = new JTextField();
  BlueBkgWhiteCharLabel lblShipStyleRemark = new BlueBkgWhiteCharLabel();
  JScrollPane jScrollPaneShipStyleRemark = new JScrollPane();
  JTextArea txtShipStyleRemark = new JTextArea();
  public PnlEditShipStyle(){
    try{
      if(sqlHead2checkShipComm==null){
        StringBuffer tmpSb=new StringBuffer();
       tmpSb.append(" select a.SHIP_BUY_COMM from buyer_maker a where ");
       tmpSb.append(" a.BYMKR_SEQ in (select b.PROD_BUYER from prod_head b where b.prod_head_pk ");
       tmpSb.append(" in (select c.PROD_HEAD_PK from style c where c.sty_seq=");
       sqlHead2checkShipComm=tmpSb.toString();
      }
      jbInit();
      btnEditPrxQty.setEnabled(true);

      if(!isEditingShipQty){
        //btnEditPrxQty.setEnabled(false);
        btnEditPrxQty.setText("EDIT PRICE");
      }else{
        //btnEditPrxQty.setEnabled(true);
        btnEditPrxQty.setText("EDIT QTY");
      }

    }catch(Exception e){
      e.printStackTrace();
    }
  }
  protected void jbInit() throws Exception {
    setPreferredSize(new java.awt.Dimension(750,600) );
    border1 = new EtchedBorder(EtchedBorder.RAISED,Color.white,new Color(148, 145, 140));
    titledBorder1 = new TitledBorder(border1,"SHIP STYLE QTY & PRICE");
    border2 = new EtchedBorder(EtchedBorder.RAISED,Color.white,new Color(148, 145, 140));
    titledBorder2 = new TitledBorder(border2,"Order QTY");
    lblTitleBar.setText("Add Style To Shipping Data");
    lblTitleBar.setBounds(new Rectangle(0, 3, 789, 26));
    this.setLayout(null);
    jLabel21.setBounds(new Rectangle(461, 52, 76, 20));
    jLabel21.setText(" Range :");
    jLabel21.setHorizontalAlignment(SwingConstants.LEFT);
    jLabel21.setOpaque(true);
    jLabel21.setForeground(Color.white);
    jLabel21.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel21.setBackground(new Color(143, 143, 188));
    jLabel1112.setBounds(new Rectangle(183, 21, 40, 20));
    jLabel1112.setText(" PO :");
    jLabel1112.setHorizontalAlignment(SwingConstants.LEFT);
    jLabel1112.setOpaque(true);
    jLabel1112.setForeground(new Color(10,36,106));
    jLabel1112.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel1112.setBackground(new Color(143, 143, 188));
    lblBuyerDiscPc.setBackground(new Color(143, 143, 188));
    lblBuyerDiscPc.setFont(new java.awt.Font("Dialog", 1, 12));
    lblBuyerDiscPc.setForeground(Color.white);
    lblBuyerDiscPc.setOpaque(true);
    lblBuyerDiscPc.setHorizontalAlignment(SwingConstants.LEFT);
    lblBuyerDiscPc.setText(" BUYER DSCT UNIT :");
    lblBuyerDiscPc.setBounds(new Rectangle(224, 51, 118, 20));
    txtDiv.setEnabled(false);
    txtDiv.setFont(new java.awt.Font("Dialog", 1, 11));
    txtDiv.setEditable(false);
    txtDiv.setBounds(new Rectangle(542, 24, 132, 21));
    lblMkrDiscPer.setBackground(new Color(143, 143, 188));
    lblMkrDiscPer.setFont(new java.awt.Font("Dialog", 1, 12));
    lblMkrDiscPer.setForeground(new Color(10,36,106));
    lblMkrDiscPer.setOpaque(true);
    lblMkrDiscPer.setHorizontalAlignment(SwingConstants.LEFT);
    lblMkrDiscPer.setText(" MKR DSCT Per :");
    lblMkrDiscPer.setBounds(new Rectangle(7, 100, 102, 20));
    lblBuyerDiscLumpSum.setBounds(new Rectangle(330, 74, 187, 20));
    lblBuyerDiscLumpSum.setText(" BUYER DSCT Lump SUM :");
    lblBuyerDiscLumpSum.setHorizontalAlignment(SwingConstants.LEFT);
    lblBuyerDiscLumpSum.setOpaque(true);
    lblBuyerDiscLumpSum.setForeground(new Color(10,36,106));
    lblBuyerDiscLumpSum.setFont(new java.awt.Font("Dialog", 1, 12));
    lblBuyerDiscLumpSum.setBackground(new Color(143, 143, 188));
    lblBuyerComm.setBackground(new Color(143, 143, 188));
    lblBuyerComm.setFont(new java.awt.Font("Dialog", 1, 12));
    lblBuyerComm.setForeground(new Color(10,36,106));
    lblBuyerComm.setOpaque(true);
    lblBuyerComm.setHorizontalAlignment(SwingConstants.LEFT);
    lblBuyerComm.setText(" Buy COMM :");
    lblBuyerComm.setBounds(new Rectangle(6, 48, 77, 20));
    jLabel3.setBounds(new Rectangle(631, 53, 52, 20));
    jLabel3.setBounds(new Rectangle(685, 21, 52, 20));
    jLabel3.setText("( PCS )");
    jLabel3.setForeground(new Color(143, 143, 188));
    jLabel3.setFont(new java.awt.Font("Dialog", 1, 12));
    txtFTY.setEnabled(false);
    txtFTY.setFont(new java.awt.Font("Dialog", 1, 11));
    txtFTY.setEditable(false);
    txtFTY.setBounds(new Rectangle(76, 24, 106, 21));
    jPanel3.setBounds(new Rectangle(2, 115, 744, 156));
    jPanel3.setLayout(null);
    jPanel3.setBackground(new Color(204, 204, 225));
    jPanel3.setBorder(BorderFactory.createTitledBorder(" Ship Style Data "));
    txtPO.setBounds(new Rectangle(583, 10, 180, 20));
    txtPO.setEnabled(false);
    txtPO.setFont(new java.awt.Font("Dialog", 1, 11));
    txtPO.setEditable(false);
    txtPO.setBounds(new Rectangle(223, 21, 136, 20));
    jLabel2.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel2.setForeground(new Color(143, 143, 188));
    jLabel2.setText("( Year )");
    jLabel2.setBounds(new Rectangle(681, 109, 77, 20));
    jLabel2.setBounds(new Rectangle(191, 52, 52, 20));
    txtSea.setEnabled(false);
    txtSea.setFont(new java.awt.Font("Dialog", 1, 11));
    txtSea.setEditable(false);
    txtSea.setBounds(new Rectangle(316, 52, 128, 21));
    jPanel2.setBounds(new Rectangle(1, 30, 744, 83));
    jPanel2.setLayout(null);
    jPanel2.setBackground(new Color(204, 204, 225));
    jPanel2.setBorder(BorderFactory.createTitledBorder(" Production Data "));
    txtYear.setEnabled(false);
    txtYear.setFont(new java.awt.Font("Dialog", 1, 11));
    txtYear.setEditable(false);
    txtYear.setBounds(new Rectangle(80, 52, 98, 20));
    jLabel23.setBounds(new Rectangle(561, 21, 37, 20));
    jLabel23.setText(" Unit :");
    jLabel23.setHorizontalAlignment(SwingConstants.LEFT);
    jLabel23.setOpaque(true);
    jLabel23.setForeground(new Color(10,36,106));
    jLabel23.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel23.setBackground(new Color(143, 143, 188));
    jLabel9.setBackground(new Color(143, 143, 188));
    jLabel9.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel9.setForeground(new Color(10,36,106));
    jLabel9.setOpaque(true);
    jLabel9.setHorizontalAlignment(SwingConstants.LEFT);
    jLabel9.setText(" S / C No. :");
    jLabel9.setBounds(new Rectangle(233, 22, 62, 20));
    jLabel19.setBackground(new Color(143, 143, 188));
    jLabel19.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel19.setForeground(new Color(10,36,106));
    jLabel19.setOpaque(true);
    jLabel19.setHorizontalAlignment(SwingConstants.LEFT);
    jLabel19.setText(" Division :");
    jLabel19.setBounds(new Rectangle(463, 24, 79, 20));
    lblBuyerDiscDz.setBounds(new Rectangle(7, 73, 141, 23));
    lblBuyerDiscDz.setText(" BUYER DSCT DZ :");
    lblBuyerDiscDz.setHorizontalAlignment(SwingConstants.LEFT);
    lblBuyerDiscDz.setOpaque(true);
    lblBuyerDiscDz.setForeground(Color.white);
    lblBuyerDiscDz.setFont(new java.awt.Font("Dialog", 1, 12));
    lblBuyerDiscDz.setBackground(new Color(143, 143, 188));
    txtUnit.setEnabled(false);
    txtUnit.setFont(new java.awt.Font("Dialog", 1, 11));
    txtUnit.setEditable(false);
    txtUnit.setBounds(new Rectangle(597, 21, 88, 20));
    jLabel7.setBounds(new Rectangle(243, 52, 74, 20));
    jLabel7.setText(" Season :");
    jLabel7.setHorizontalAlignment(SwingConstants.LEFT);
    jLabel7.setOpaque(true);
    jLabel7.setForeground(Color.white);
    jLabel7.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel7.setBackground(new Color(143, 143, 188));
    txtStyle.setBounds(new Rectangle(583, 102, 180, 20));
    txtStyle.setEnabled(false);
    txtStyle.setFont(new java.awt.Font("Dialog", 1, 11));
    txtStyle.setEditable(false);
    txtStyle.setBounds(new Rectangle(55, 21, 120, 20));
    jLabel120.setBounds(new Rectangle(6, 21, 49, 20));
    jLabel120.setText(" Style :");
    jLabel120.setHorizontalAlignment(SwingConstants.LEFT);
    jLabel120.setOpaque(true);
    jLabel120.setForeground(new Color(10,36,106));
    jLabel120.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel120.setBackground(new Color(143, 143, 188));
    txtScNo.setBounds(new Rectangle(583, 148, 180, 20));
    txtScNo.setEnabled(false);
    txtScNo.setFont(new java.awt.Font("Dialog", 1, 11));
    txtScNo.setEditable(false);
    txtScNo.setBounds(new Rectangle(295, 22, 150, 20));
    txtRange.setBounds(new Rectangle(583, 79, 180, 20));
    txtRange.setEnabled(false);
    txtRange.setFont(new java.awt.Font("Dialog", 1, 11));
    txtRange.setEditable(false);
    txtRange.setBounds(new Rectangle(537, 52, 134, 20));
    jLabel15.setBounds(new Rectangle(15, 24, 61, 20));
    jLabel15.setText(" FTY :");
    jLabel15.setHorizontalAlignment(SwingConstants.LEFT);
    jLabel15.setOpaque(true);
    jLabel15.setForeground(new Color(10,36,106));
    jLabel15.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel15.setBackground(new Color(143, 143, 188));
    jLabel10.setBackground(new Color(143, 143, 188));
    jLabel10.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel10.setForeground(Color.white);
    jLabel10.setOpaque(true);
    jLabel10.setHorizontalAlignment(SwingConstants.LEFT);
    jLabel10.setText(" Year :");
    jLabel10.setBounds(new Rectangle(15, 52, 66, 20));
    txtBuyComm.setText("");
    txtBuyComm.setBounds(new Rectangle(83, 49, 93, 20));
    txtBuyDsctPc.setText("");
    txtBuyDsctPc.setBounds(new Rectangle(340, 51, 73, 22));
    txtBuyDsctLumpSum.setText("");
    txtBuyDsctLumpSum.setBounds(new Rectangle(517, 74, 125, 20));
    txtMkrDsctPer.setText("");
    txtMkrDsctPer.setBounds(new Rectangle(109, 100, 105, 20));
    txtBuyDsctDz.setText("");
    txtBuyDsctDz.setBounds(new Rectangle(147, 73, 170, 23));
    this.setBackground(new Color(204, 204, 225));
    jPanel1.setBackground(new Color(204, 204, 225));
    jPanel1.setBorder(titledBorder1);
    jPanel1.setBounds(new Rectangle(5, 273, 739, 560));
    jPanel1.setLayout(null);
    jPanel4.setBorder(titledBorder2);
    jPanel4.setBounds(new Rectangle(8, 319, 712, 238));
    jPanel4.setLayout(borderLayout1);
    txtAreaOdrQty.setEditable(false);
    txtAreaOdrQty.setText("");
    blueBkgWhiteCharLabel1.setForeground(new Color(10,36,106));
    blueBkgWhiteCharLabel1.setText("Style QTY:");
    blueBkgWhiteCharLabel1.setBounds(new Rectangle(11, 300, 94, 22));
    lblOrgTtlQty.setText("");
    lblOrgTtlQty.setBounds(new Rectangle(104, 300, 186, 22));
    blueBkgWhiteCharLabel2.setBounds(new Rectangle(11, 31, 94, 22));
    blueBkgWhiteCharLabel2.setText("Shipped QTY:");
    blueBkgWhiteCharLabel2.setForeground(new Color(10,36,106));
    lblShippedQty.setText("");
    lblShippedQty.setBounds(new Rectangle(103, 31, 186, 22));
    jScrollPane2.setBounds(new Rectangle(7, 58, 702, 230));
    txtShipQtyDesc.setText("");
    btnEditPrxQty.setBounds(new Rectangle(302, 25, 158, 31));
    btnEditPrxQty.setFont(new java.awt.Font("Dialog", 1, 11));
    btnEditPrxQty.setText("Edit Qty");
    btnEditPrxQty.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnEditPrxQty_actionPerformed(e);
      }
    });
    lblMkrDiscPc.setBounds(new Rectangle(230, 99, 97, 20));
    lblMkrDiscPc.setText("MKR DSCT UNIT :");
    lblMkrDiscPc.setHorizontalAlignment(SwingConstants.LEFT);
    lblMkrDiscPc.setOpaque(true);
    lblMkrDiscPc.setForeground(Color.white);
    lblMkrDiscPc.setFont(new java.awt.Font("Dialog", 1, 12));
    lblMkrDiscPc.setBackground(new Color(143, 143, 188));
    lblMkrDiscDz.setBackground(new Color(143, 143, 188));
    lblMkrDiscDz.setFont(new java.awt.Font("Dialog", 1, 12));
    lblMkrDiscDz.setForeground(Color.white);
    lblMkrDiscDz.setOpaque(true);
    lblMkrDiscDz.setHorizontalAlignment(SwingConstants.LEFT);
    lblMkrDiscDz.setText(" MKR DSCT DZ :");
    lblMkrDiscDz.setBounds(new Rectangle(7, 125, 141, 23));
    lblMkrDiscLumpSum.setBackground(new Color(143, 143, 188));
    lblMkrDiscLumpSum.setFont(new java.awt.Font("Dialog", 1, 12));
    lblMkrDiscLumpSum.setForeground(new Color(10,36,106));
    lblMkrDiscLumpSum.setOpaque(true);
    lblMkrDiscLumpSum.setHorizontalAlignment(SwingConstants.LEFT);
    lblMkrDiscLumpSum.setText(" MKR DSCT Lump SUM :");
    lblMkrDiscLumpSum.setBounds(new Rectangle(331, 130, 187, 20));
    txtMkrDsctPc.setBounds(new Rectangle(326, 99, 73, 22));
    txtMkrDsctPc.setText("");
    txtMkrDsctDz.setBounds(new Rectangle(147, 125, 170, 23));
    txtMkrDsctDz.setText("");
    txtMkrDsctLumpSum.setBounds(new Rectangle(518, 130, 125, 20));
    txtMkrDsctLumpSum.setText("");
    lblCat.setBackground(new Color(143, 143, 188));
    lblCat.setFont(new java.awt.Font("Dialog", 1, 12));
    lblCat.setForeground(new Color(10,36,106));
    lblCat.setOpaque(true);
    lblCat.setHorizontalAlignment(SwingConstants.LEFT);
    lblCat.setText("QTA:");
    lblCat.setBounds(new Rectangle(375, 21, 40, 20));
    txtCatData.setBounds(new Rectangle(223, 21, 136, 20));
    txtCatData.setEditable(false);
    txtCatData.setFont(new java.awt.Font("Dialog", 1, 11));
    txtCatData.setEnabled(false);
    txtCatData.setBounds(new Rectangle(415, 21, 136, 20));


    jPanel2.add(jLabel15, null);
    jPanel2.add(jLabel19, null);
    jPanel2.add(txtDiv, null);
    jPanel2.add(jLabel10, null);
    jPanel2.add(txtYear, null);
    jPanel2.add(jLabel2, null);
    jPanel2.add(jLabel7, null);
    jPanel2.add(txtSea, null);
    jPanel2.add(jLabel21, null);
    jPanel2.add(txtRange, null);
    jPanel2.add(jLabel9, null);
    jPanel2.add(txtScNo, null);
    jPanel2.add(txtFTY, null);
    this.add(jPanel1, null);
    this.add(jPanel3, null);
    jPanel3.add(jLabel120, null);
    jPanel3.add(txtStyle, null);

    if(!util.PublicVariable.OPERATTING_CENTER.equals("NTFE")){
     jPanel3.add(lblBuyerComm, null);
     jPanel3.add(txtBuyComm, null);
     jPanel3.add(lblMkrDiscPer, null);
     jPanel3.add(txtMkrDsctPer, null);
     jPanel3.add(lblBuyerDiscDz, null);
     jPanel3.add(txtBuyDsctDz, null);
     jPanel3.add(lblBuyerDiscLumpSum, null);
     jPanel3.add(txtBuyDsctLumpSum, null);
     jPanel3.add(lblBuyerDiscPc, null);
     jPanel3.add(txtBuyDsctPc, null);
     jPanel3.add(lblMkrDiscDz, null);
     jPanel3.add(txtMkrDsctDz, null);
     jPanel3.add(lblMkrDiscLumpSum, null);
     jPanel3.add(txtMkrDsctLumpSum, null);
     jPanel3.add(lblMkrDiscPc, null);
     jPanel3.add(txtMkrDsctPc, null);
    }
    jPanel3.add(jLabel1112, null);
    jPanel3.add(txtPO, null);
    this.add(lblTitleBar, null);
    this.add(jPanel2, null);
    jPanel1.add(btnEditPrxQty, null);
    jPanel1.add(blueBkgWhiteCharLabel2, null);
    jPanel1.add(jScrollPane2, null);
    jPanel1.add(lblShippedQty, null);
    jPanel1.add(blueBkgWhiteCharLabel1, null);
    jPanel1.add(lblOrgTtlQty, null);
    jPanel1.add(jPanel4, null);
    jPanel4.add(jScrollPane1, BorderLayout.CENTER);
    jScrollPane1.getViewport().add(txtAreaOdrQty, null);
    jScrollPane2.getViewport().add(txtShipQtyDesc, null);
    jPanel3.add(lblCat, null);
    jPanel3.add(txtCatData, null);
    jPanel3.add(jLabel23, null);
    jPanel3.add(txtUnit, null);
    jPanel3.add(jLabel3, null);
    if(util.PublicVariable.OPERATTING_CENTER.equals("NTFE")){

      lblShipStyleRemark.setText("REMARK");
      lblShipStyleRemark.setBounds(new Rectangle(5, 47, 172, 89));
      jScrollPaneShipStyleRemark.setBounds(new Rectangle(181, 48, 371, 89));

      jPanel3.add(lblShipStyleRemark, null);
      jPanel3.add(jScrollPaneShipStyleRemark, null);
      jScrollPaneShipStyleRemark.getViewport().add(txtShipStyleRemark, null);
    }
    txtAreaOdrQty.setFont(new java.awt.Font("DialogInput", 0, 12));
    txtShipQtyDesc.setFont(new java.awt.Font("DialogInput", 0, 12));
  }
  public void record2Gui(){
    //filled all the columns,take easy,just buyer maker discount and percentage and lumpsun....
    try{
      if(recToMapping.getInt(0)>0){
        lblTitleBar.setText("* EDIT Shipping Style *");
      }else{
        lblTitleBar.setText("ADD Style to Shipping");
      }
      txtFTY.setText((String)recToMapping.get("_$MAKER_NAME")); txtFTY.setEditable(false);//maker name
      txtScNo.setText((String)recToMapping.get("_$PROD_SC_NO"));txtScNo.setEditable(false);
      txtDiv.setText((String)recToMapping.get("_$DIV_NAME"));txtDiv.setEditable(false);
      txtYear.setText((String)recToMapping.get("_$PROD_YEAR"));txtYear.setEditable(false);
      txtSea.setText((String)recToMapping.get("_$PROD_SEASON"));txtSea.setEditable(false);
      txtRange.setText((String)recToMapping.get("_$PROD_RANGE"));txtRange.setEditable(false);
      txtStyle.setText((String)recToMapping.get("_$ORG_STYLE_NAME"));txtStyle.setEditable(false);
      txtPO.setText((String)recToMapping.get("_$ORG_STYLE_PO"));txtPO.setEditable(false);
      txtUnit.setText((String)recToMapping.get("_$ORG_STYLE_UNIT"));txtUnit.setEditable(false);
      Object objSummedOdrQty=recToMapping.get("_$SUMMED_ORDER_QTY");
      lblOrgTtlQty.setText((objSummedOdrQty==null)?"":objSummedOdrQty.toString());

      Object catData=recToMapping.get("_$STY_QTA");
      txtCatData.setText((catData==null)?"":catData.toString());

      Object objSummedshippedQty=recToMapping.get("_$SUMMED_SHIPPED_QTY");
      lblShippedQty.setText((objSummedshippedQty==null)?"":objSummedshippedQty.toString());
      Object objOrgOrderQty=recToMapping.get("_$ORG_QTY_DESC");
      txtAreaOdrQty.setText((objOrgOrderQty==null)?"":objOrgOrderQty.toString());txtAreaOdrQty.setEditable(false);
      Object objShipQtyDesc=recToMapping.get("SHIP_QTY_DESC");
      txtShipQtyDesc.setText((objShipQtyDesc==null)?"":objShipQtyDesc.toString());
      txtShipQtyDesc.setEditable(false);
      dataBoundGUIs.clear();
      Object vftxtBuyComm=exgui.verification.CellFormat.getDoubleFormatAllowNull(3,2);
      dbBuyerComm= new exgui.DataBindTextWithChecker(
         txtBuyComm,"BUY_COMM",recToMapping.get("BUY_COMM"),6,(
        exgui.Object2String)vftxtBuyComm,(exgui.ultratable.CellTxtEditorFormat)vftxtBuyComm);
       dataBoundGUIs.add( dbBuyerComm );
     Object vftxtMkrDsctPer = vftxtBuyComm;//exgui.verification.CellFormat.getDoubleFormatAllowNull(3, 2);
     dataBoundGUIs.add(
           new exgui.DataBindTextWithChecker(
           txtMkrDsctPer,
           "MKR_DSCT_PER",
           recToMapping.get("MKR_DSCT_PER"), 6,
           (exgui.Object2String)vftxtMkrDsctPer,
           (exgui.ultratable.CellTxtEditorFormat)vftxtMkrDsctPer)
      );

      Object vftxtMkrDsctPc=exgui.verification.CellFormat.getDoubleFormatAllowNull(4,3);
       dataBoundGUIs.add(
         new exgui.DataBindTextWithChecker(
           txtMkrDsctPc,"MKR_DSCT_PC",recToMapping.get("MKR_DSCT_PC"),8,
          (exgui.Object2String)vftxtMkrDsctPc,(exgui.ultratable.CellTxtEditorFormat)vftxtMkrDsctPc
          )
      );

     dataBoundGUIs.add(
        new exgui.DataBindTextWithChecker(
       txtBuyDsctPc,"BUY_DSCT_PC",recToMapping.get("BUY_DSCT_PC"),8,
        (exgui.Object2String)vftxtMkrDsctPc,(exgui.ultratable.CellTxtEditorFormat)vftxtMkrDsctPc
        )
      );


      Object vftxtMkrDsctLumpSum=exgui.verification.CellFormat.getDoubleFormatAllowNull(8,3);
       dataBoundGUIs.add(
                        new exgui.DataBindTextWithChecker(
                        txtMkrDsctLumpSum,"MKR_DSCT_LUMP_SUM",
                        recToMapping.get("MKR_DSCT_LUMP_SUM"),12,
                        (exgui.Object2String)vftxtMkrDsctLumpSum,
                        (exgui.ultratable.CellTxtEditorFormat)vftxtMkrDsctLumpSum)
      );
      dataBoundGUIs.add(
                    new exgui.DataBindTextWithChecker(
                    txtBuyDsctLumpSum,"BUY_DSCT_LUMP_SUM",
                    recToMapping.get("BUY_DSCT_LUMP_SUM"),12,
                    (exgui.Object2String)vftxtMkrDsctLumpSum,
                    (exgui.ultratable.CellTxtEditorFormat)vftxtMkrDsctLumpSum)
      );

      Object vftxtMkrDsctDz=exgui.verification.CellFormat.getDoubleFormatAllowNull(4,4);
       dataBoundGUIs.add(
           new exgui.DataBindTextWithChecker(
              txtMkrDsctDz,"MKR_DSCT_DZ",recToMapping.get("MKR_DSCT_DZ"),9,
                 (exgui.Object2String)vftxtMkrDsctDz,
               (exgui.ultratable.CellTxtEditorFormat)vftxtMkrDsctDz)
      );
      dataBoundGUIs.add(
          new exgui.DataBindTextWithChecker(
             txtBuyDsctDz,"BUY_DSCT_DZ",recToMapping.get("BUY_DSCT_DZ"),9,
                (exgui.Object2String)vftxtMkrDsctDz,
              (exgui.ultratable.CellTxtEditorFormat)vftxtMkrDsctDz)
      );

     if(util.PublicVariable.OPERATTING_CENTER.equals("NTFE")){
       Object vftxtShipStyleRemark=exgui.verification.CellFormat.getOrdinaryField(255);
        dataBoundGUIs.add(
          new exgui.DataBindTextWithChecker(
            txtShipStyleRemark,"SHIP_STYLE_PACKING_RMRK",
            recToMapping.get("SHIP_STYLE_PACKING_RMRK"),255,
           (exgui.Object2String)vftxtShipStyleRemark,
           (exgui.ultratable.CellTxtEditorFormat)vftxtShipStyleRemark
           )
       );

     }

    }catch(Exception exp){
      exp.printStackTrace();
    }
  }
  public boolean isContextModified(){
    if(isProcessingDelete)return false;
    return super.isContextModified();
  }
  public void doDelete(){
    if(!exgui.verification.VerifyLib.showConfirm("Are You Sure To Delete This Shipping Style Data ?","Are You Sure?"))return;
    try{
      newtimes.production.ProdMaintain_Properties.setWaitCursor();
      util.MiscFunc.showProcessingMessage();
      dbprc.deleteRecord(recToMapping);
      isProcessingDelete=true;
      doExit();//after delete ,go to listing page.
    }catch(Exception exp){
      exp.printStackTrace();
      util.MiscFunc.hideProcessingMessage();
      util.ExceptionLog.exp2File(exp,"error while delete record:"+recToMapping.toString());
      exgui.verification.VerifyLib.showAlert("Server Side Error While Deleting Shipping Style","Error while Deleting");
    }finally{
      util.MiscFunc.hideProcessingMessage();
      newtimes.production.ProdMaintain_Properties.setNormalCursor();
    }
  }
  public void doPrint(){}
  protected boolean checkShipCommision()throws Exception{
    //newtimes.shipping_admin.ShippingAdmin_Const.EDIT_SHIP_STYLE_STYLE_INT_SEQ
    StringBuffer sb=new StringBuffer(sqlHead2checkShipComm);
    sb.append(newtimes.shipping_admin.ShippingAdmin_Const.EDIT_SHIP_STYLE_STYLE_INT_SEQ);
    sb.append("))");
    java.util.Vector vct=exgui2.CONST.BASIC_MAIN_EJB.getDatas(
      util.PublicVariable.USER_RECORD,
      sb.toString(),1,1);
    if(vct==null)throw new Exception("Error While To Compare Ship Buyer Commission");
    Record rec=(Record)vct.get(0);
    Object shipBuyCommObj=rec.get(0);
    if(shipBuyCommObj==null)return true;//no user assigned
    float shipBuyerComm=Float.parseFloat(shipBuyCommObj.toString());
    Object styleBuyerCommObj=dbBuyerComm.getSelectedValue();
    float styleBuyerComm=Float.parseFloat((styleBuyerCommObj==null)?"0":styleBuyerCommObj.toString());
    System.out.println(""+styleBuyerComm+" <-> "+ shipBuyerComm);
    if(styleBuyerComm!=shipBuyerComm){
        exgui.verification.VerifyLib.showAlert(
        "Buyer Commission is "+styleBuyerComm+",Not Equal to Buyer's Ship Commission:"+shipBuyerComm,
        "Buyer Commssion Error");
        return false;
    }
    return true;
  }
  public void doUpdate()throws Exception{
    isGui2RecordOk=gui2Record();
    int orgPK=recToMapping.getInt(0);
    Cursor ksr=null;
    if(!isGui2RecordOk) return;
    if(!checkShipCommision())return;
      newtimes.production.ProdMaintain_Properties.setWaitCursor();
      util.MiscFunc.showProcessingMessage();
      try{
        //test if to update...
        if(orgPK>0){
          recToMapping.set("record_modify_user",util.PublicVariable.USER_RECORD.get("usr_code"));
          recToMapping.set("SHIP_QTY_DESC",txtShipQtyDesc.getText());
        }
        recToMapping=((newtimes.shipping_admin.process.shiippingmaintain.DB_ShipStyle)dbprc).updateRecord(recToMapping);
        record2Gui();
        recClonedForCheck=(Record)util.MiscFunc.deepCopy(recToMapping);
        /*
        if(orgPK<0){
          exgui.verification.VerifyLib.showPlanMsg("Insert OK","Insert OK");
        }else{
          exgui.verification.VerifyLib.showPlanMsg("Update OK","Update OK");
        }
        */
        newtimes.shipping_admin.ShippingAdmin_Const.EDIT_SHIP_STYLE_SEQ_INT=recToMapping.getInt(0);

        String sizeColumn=newtimes.shipping_admin.ShippingAdmin_Const.recnvDblCamaString(
         (String)recToMapping.get("_$org_sty_size_column"));
        recToMapping.set("_$org_sty_size_column",sizeColumn);

        newtimes.shipping_admin.ShippingAdmin_Const.EDITING_SHIPPING_STYLE_RECORD=recToMapping;
      }catch(Exception e){
        //e.printStackTrace();
        throw e;
      }finally{
        util.MiscFunc.hideProcessingMessage();
         newtimes.production.ProdMaintain_Properties.setNormalCursor();
      }
  }
  public void doExit()throws Exception{
       if(txtShipQtyDesc.getText().trim().length()==0 &&
          recToMapping.getInt(0)>0 &&
          isEditingShipQty){
         try{
           newtimes.production.ProdMaintain_Properties.setWaitCursor();
           util.MiscFunc.showProcessingMessage();
           dbprc.deleteRecord(recToMapping);
           isProcessingDelete=true;
           super.doExit();//after delete ,go to listing page.
         }catch(Exception exp){
           exp.printStackTrace();
           util.MiscFunc.hideProcessingMessage();
           util.ExceptionLog.exp2File(exp,"error while delete record:"+recToMapping.toString());
           exgui.verification.VerifyLib.showAlert("Server Side Error While Deleting Shipping Style","Error while Deleting");
         }finally{
           util.MiscFunc.hideProcessingMessage();
           newtimes.production.ProdMaintain_Properties.setNormalCursor();
         }
       }else{
         super.doExit();
       }
  }
  void btnEditPrxQty_actionPerformed(ActionEvent e) {
     //show alert if current record is new record.
     boolean have2IniByBalance=false;
     if(txtShipQtyDesc.getText().trim().length()==0)have2IniByBalance=true;
     if(recToMapping.getInt(0)<0){
      /*
       exgui.verification.VerifyLib.showAlert(
        "Before Editing Shipping Qty & Price\nPlease Click \"Confirm\" To Save This Shipping Style",
        "Shipping Style Not Saved Yet");
         return;
      */
       try{
          doUpdate();
       }catch(Exception exp){
         exp.printStackTrace();
         util.ExceptionLog.exp2File(exp,"");
         exgui.verification.VerifyLib.showAlert("Error While Update Data\nPlease Contact System Manager",
                                                "Error In update");
       }
     }
     if(util.PublicVariable.OPERATTING_CENTER.equals("NTFE")){
       //NTFE's SHIP QTY is only LUMP sum mode
       try{
         newtimes.shipping_admin.ShippingAdmin_Const.
             EDITING_SHIPPING_STYLE_RECORD.set(
             "_$ORG_STY_SIZE_COLUMN", "");
       }catch(Exception exp2){
         exp2.printStackTrace();
       }
     }

     DlgEditShipStyleQtyPrx dlg=
         new DlgEditShipStyleQtyPrx(util.PublicVariable.APP_FRAME,
                                    "Edit Shipping Style QTY. & PRICE",true,txtShipQtyDesc);

     if(!isEditingShipQty){
       //if NTHK user,udpate ship-style's price(buyer act,maker act/doc) by po-style's price.
       if(util.PublicVariable.OPERATTING_CENTER.equals("NTHK")){
         try{
           newtimesejb.packing.PackingDirectQtyFacadeHome ejbHome=
               (newtimesejb.packing.PackingDirectQtyFacadeHome)
               info_ejb.WeblogicServiceLocator.locateServiceHome(
               util.PublicVariable.SERVER_URL, "newtimesejb.packing.PackingDirectQtyFacade");
           newtimesejb.packing.PackingDirectQtyFacade ejb=
               ejbHome.create();
           ejb.updateShipPriceByPoPriceOfShipStyle(recToMapping.getInt(0),
                                                   (String)util.PublicVariable.USER_RECORD.get(0));
         }catch(Exception expShipStyle){
           expShipStyle.printStackTrace();
           util.ExceptionLog.exp2File(expShipStyle,"");
           exgui.verification.VerifyLib.showAlert("Error In updating shp-style price by PO\nPlease Contact System Manager",
                                                  "Error In Connection");
         }
       }

       dlg.btnPrx_actionPerformed(null);
       dlg.btnQty.setEnabled(false);
     }else{

     }
     dlg.setSize(600,300);
     /*
      //don't need to generate balance,unless user click it.
      //TPE center prefer to fill all balance at first size of each color
     if(have2IniByBalance){
       //System.out.println("calls to get balance of shipping");
       dlg.qtyEditer.initQtyByBalance(); //the new ship style qyt record should be init by balance.
     }
     */
     dlg.show();

  }

}
