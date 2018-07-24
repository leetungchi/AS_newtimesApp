package newtimes.shipping_admin.guis.shippingmaintain;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import database.datatype.Record;
import exgui.*;
/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class PnlEditSi
    extends processhandler.template.PnlFieldsEditor
    //extends JPanel
 {
  JLabel jLabel21 = new JLabel();
  JLabel jLabel1112 = new JLabel();
  JLabel jLabel12 = new JLabel();
  JLabel jLabel116 = new JLabel();
  JTextField txtDiv = new JTextField();
  JLabel jLabel20 = new JLabel();
  JLabel jLabel13 = new JLabel();
  JLabel jLabel115 = new JLabel();
  JTextField txtScOth = new JTextField();
  JLabel jLabel1110 = new JLabel();
  JTextField txtFTY = new JTextField();
  JTextField txtCtFrt = new JTextField();
  JLabel jLabel2 = new JLabel();
  JTextField txtSea = new JTextField();
  JLabel jLabel14 = new JLabel();
  JTextField txtCtOth = new JTextField();
  JLabel jLabel114 = new JLabel();
  JTextField txtYear = new JTextField();
  JTextField txtScFrt = new JTextField();
  JLabel jLabel9 = new JLabel();
  JTextField txtCen = new JTextField();
  JLabel jLabel111 = new JLabel();
  JLabel jLabel19 = new JLabel();
  JTextField txtScIns = new JTextField();
  JTextField txtSCAmt = new JTextField();
  JTextField txtCTAmt = new JTextField();
  JLabel jLabel18 = new JLabel();
  JTextField txtCtIns = new JTextField();
  JLabel jLabel112 = new JLabel();
  JLabel jLabel7 = new JLabel();
  JLabel jLabel17 = new JLabel();
  JTextField txtMag = new JTextField();
  JTextField txtDep = new JTextField();
  JTextField txtSCComm = new JTextField();
  JTextField txtCTPrice = new JTextField();
  JTextField txtBuyer = new JTextField();
  JLabel jLabel120 = new JLabel();
  JTextField txtSrnNo = new JTextField();
  JLabel jLabel118 = new JLabel();
  JTextField txtScNo = new JTextField();
  JLabel jLabel22 = new JLabel();
  JTextField txtCnty = new JTextField();
  JLabel jLabel15 = new JLabel();
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel1 = new BlueBkgWhiteCharLabel();
  BlueBkgWhiteCharLabel lbl_formula_INCOME = new BlueBkgWhiteCharLabel();
  JTextField txt_INCOME = new JTextField();
  BlueBkgWhiteCharLabel lbl_formula_COST = new BlueBkgWhiteCharLabel();
  JTextField txt_COST = new JTextField();
  BlueBkgWhiteCharLabel lbl_formula_INCOME1 = new BlueBkgWhiteCharLabel();
  JTextField txt_PROFIT = new JTextField();
  reCount objCount=new reCount();
  JTextField txtPftShare = new JTextField();
  JLabel jLabel16 = new JLabel();
  public PnlEditSi() {
    try {
      jbInit();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }
  public void record2Gui(){
    try{
    dataBoundGUIs.clear();

    Object vftxtScFrt=exgui.verification.CellFormat.getDoubleFormatAllowNull(8,2);
     dataBoundGUIs.add(  new exgui.DataBindTextWithChecker(txtScFrt,"SC_FRT",recToMapping.get("SC_FRT"),10,(exgui.Object2String)vftxtScFrt,(exgui.ultratable.CellTxtEditorFormat)vftxtScFrt)
    );
    Object vftxtCtFrt=exgui.verification.CellFormat.getDoubleFormatAllowNull(8,2);
     dataBoundGUIs.add(  new exgui.DataBindTextWithChecker(txtCtFrt,"CT_FRT",recToMapping.get("CT_FRT"),10,(exgui.Object2String)vftxtCtFrt,(exgui.ultratable.CellTxtEditorFormat)vftxtCtFrt)
    );
    Object vftxtScIns=exgui.verification.CellFormat.getDoubleFormatAllowNull(8,2);
     dataBoundGUIs.add(  new exgui.DataBindTextWithChecker(txtScIns,"SC_INS",recToMapping.get("SC_INS"),10,(exgui.Object2String)vftxtScIns,(exgui.ultratable.CellTxtEditorFormat)vftxtScIns)
    );
    Object vftxtCtIns=exgui.verification.CellFormat.getDoubleFormatAllowNull(8,2);
     dataBoundGUIs.add(  new exgui.DataBindTextWithChecker(txtCtIns,"CT_INS",recToMapping.get("CT_INS"),10,(exgui.Object2String)vftxtCtIns,(exgui.ultratable.CellTxtEditorFormat)vftxtCtIns)
    );
    Object vftxtScOth=exgui.verification.CellFormat.getDoubleFormatAllowNull(8,2);
     dataBoundGUIs.add(  new exgui.DataBindTextWithChecker(txtScOth,"SC_OTHER",recToMapping.get("SC_OTHER"),10,(exgui.Object2String)vftxtScOth,(exgui.ultratable.CellTxtEditorFormat)vftxtScOth)
    );
    Object vftxtCtOth=exgui.verification.CellFormat.getDoubleFormatAllowNull(8,2);
     dataBoundGUIs.add(  new exgui.DataBindTextWithChecker(txtCtOth,"CT_OTHER",recToMapping.get("CT_OTHER"),10,(exgui.Object2String)vftxtCtOth,(exgui.ultratable.CellTxtEditorFormat)vftxtCtOth)
    );
    Object vftxtProfitShareCode=exgui.verification.CellFormat.getOrdinaryField(5);
       dataBoundGUIs.add(  new exgui.DataBindTextWithChecker(txtPftShare,
                                       "PROFIT_SHARE",
                                       recToMapping.get("PROFIT_SHARE"),5,
                                       (exgui.Object2String)vftxtProfitShareCode,
                                       (exgui.ultratable.CellTxtEditorFormat)
                                       vftxtProfitShareCode)
    );

     //show the income and cost and profit

     txtCtFrt.addKeyListener(objCount);
     txtCtIns.addKeyListener(objCount);
     txtCtOth.addKeyListener(objCount);
     txtScFrt.addKeyListener(objCount);
     txtScIns.addKeyListener(objCount);
     txtScOth.addKeyListener(objCount);

     objCount.keyReleased(null);

    }catch(Exception exp){
      exp.printStackTrace();
    }
  }
  protected  void jbInit() throws Exception {
    jLabel15.setBounds(new Rectangle(9, 214, 155, 20));
    jLabel15.setBounds(new Rectangle(29, 242, 131, 20));
    jLabel15.setText(" SC Commission :");
    jLabel15.setHorizontalAlignment(SwingConstants.LEFT);
    jLabel15.setOpaque(true);
    jLabel15.setForeground(Color.white);
    jLabel15.setFont(new java.awt.Font("Dialog", 1, 13));
    jLabel15.setBackground(new Color(143, 143, 188));

    txtCnty.setBounds(new Rectangle(533, 151, 209, 20));

    jLabel22.setBounds(new Rectangle(388, 65, 155, 20));
    jLabel22.setBackground(new Color(143, 143, 188));
    jLabel22.setFont(new java.awt.Font("Dialog", 1, 13));
    jLabel22.setForeground(new Color(10,36,106));
    jLabel22.setOpaque(true);
    jLabel22.setHorizontalAlignment(SwingConstants.LEFT);
    jLabel22.setText(" Division :");
    jLabel22.setBounds(new Rectangle(30, 184, 131, 20));

    txtScNo.setBounds(new Rectangle(533, 50, 209, 20));
    jLabel118.setBounds(new Rectangle(388, 265, 155, 20));
    jLabel118.setBounds(new Rectangle(401, 293, 131, 20));
    jLabel118.setText(" CT FRT :");
    jLabel118.setHorizontalAlignment(SwingConstants.LEFT);
    jLabel118.setOpaque(true);
    jLabel118.setForeground(new Color(10,36,106));
    jLabel118.setFont(new java.awt.Font("Dialog", 1, 13));
    jLabel118.setBackground(new Color(143, 143, 188));

    txtSrnNo.setBounds(new Rectangle(161, 52, 209, 20));
    jLabel120.setBounds(new Rectangle(388, 115, 155, 20));
    jLabel120.setBounds(new Rectangle(402, 152, 131, 20));
    jLabel120.setText(" Country :");
    jLabel120.setHorizontalAlignment(SwingConstants.LEFT);
    jLabel120.setOpaque(true);
    jLabel120.setForeground(new Color(10,36,106));
    jLabel120.setFont(new java.awt.Font("Dialog", 1, 13));
    jLabel120.setBackground(new Color(143, 143, 188));

    txtBuyer.setBounds(new Rectangle(161, 155, 209, 20));

    txtCTPrice.setBounds(new Rectangle(530, 243, 209, 20));

    txtSCComm.setBounds(new Rectangle(160, 242, 209, 20));

    txtDep.setBounds(new Rectangle(533, 75, 209, 20));

    txtMag.setBounds(new Rectangle(161, 103, 209, 20));
    jLabel17.setBounds(new Rectangle(9, 314, 155, 20));
    jLabel17.setBounds(new Rectangle(29, 341, 131, 20));
    jLabel17.setText(" SC Other :");
    jLabel17.setHorizontalAlignment(SwingConstants.LEFT);
    jLabel17.setOpaque(true);
    jLabel17.setForeground(new Color(10,36,106));
    jLabel17.setFont(new java.awt.Font("Dialog", 1, 13));
    jLabel17.setBackground(new Color(143, 143, 188));
    jLabel7.setBounds(new Rectangle(9, 65, 155, 20));
    jLabel7.setBounds(new Rectangle(30, 103, 131, 20));
    jLabel7.setText(" Manager :");
    jLabel7.setHorizontalAlignment(SwingConstants.LEFT);
    jLabel7.setOpaque(true);
    jLabel7.setForeground(new Color(10,36,106));
    jLabel7.setFont(new java.awt.Font("Dialog", 1, 13));
    jLabel7.setBackground(new Color(143, 143, 188));
    jLabel112.setBounds(new Rectangle(388, 189, 155, 20));
    jLabel112.setBounds(new Rectangle(401, 219, 131, 20));
    jLabel112.setText(" CT Amount :");
    jLabel112.setHorizontalAlignment(SwingConstants.LEFT);
    jLabel112.setOpaque(true);
    jLabel112.setForeground(new Color(10,36,106));
    jLabel112.setFont(new java.awt.Font("Dialog", 1, 13));
    jLabel112.setBackground(new Color(143, 143, 188));
    txtCtIns.setBounds(new Rectangle(532, 317, 144, 20));
    //txtCtIns.setHorizontalAlignment(SwingConstants.RIGHT);
    jLabel18.setBounds(new Rectangle(388, 314, 155, 20));
    jLabel18.setBackground(new Color(143, 143, 188));
    jLabel18.setFont(new java.awt.Font("Dialog", 1, 13));
    jLabel18.setForeground(new Color(10,36,106));
    jLabel18.setOpaque(true);
    jLabel18.setHorizontalAlignment(SwingConstants.LEFT);
    jLabel18.setText(" CT OTHER :");
    jLabel18.setBounds(new Rectangle(401, 342, 131, 20));

    txtCTAmt.setBounds(new Rectangle(530, 218, 209, 20));

    txtSCAmt.setBounds(new Rectangle(160, 217, 209, 20));
    txtScIns.setBounds(new Rectangle(160, 317, 144, 20));
    //txtScIns.setHorizontalAlignment(SwingConstants.RIGHT);
    jLabel19.setBounds(new Rectangle(9, 39, 155, 20));
    jLabel19.setBackground(new Color(143, 143, 188));
    jLabel19.setFont(new java.awt.Font("Dialog", 1, 13));
    jLabel19.setForeground(Color.white);
    jLabel19.setOpaque(true);
    jLabel19.setHorizontalAlignment(SwingConstants.LEFT);
    jLabel19.setText(" Center :");
    jLabel19.setBounds(new Rectangle(30, 77, 131, 20));
    jLabel111.setBounds(new Rectangle(388, 39, 155, 20));
    jLabel111.setBounds(new Rectangle(402, 76, 131, 20));
    jLabel111.setText(" Department :");
    jLabel111.setHorizontalAlignment(SwingConstants.LEFT);
    jLabel111.setOpaque(true);
    jLabel111.setForeground(Color.white);
    jLabel111.setFont(new java.awt.Font("Dialog", 1, 13));
    jLabel111.setBackground(new Color(143, 143, 188));

    txtCen.setBounds(new Rectangle(161, 77, 209, 20));
    jLabel9.setBounds(new Rectangle(388, 140, 155, 20));
    jLabel9.setBounds(new Rectangle(30, 155, 131, 20));
    jLabel9.setText(" Buyer :");
    jLabel9.setHorizontalAlignment(SwingConstants.LEFT);
    jLabel9.setOpaque(true);
    jLabel9.setForeground(Color.white);
    jLabel9.setFont(new java.awt.Font("Dialog", 1, 13));
    jLabel9.setBackground(new Color(143, 143, 188));
    txtScFrt.setBounds(new Rectangle(160, 292, 144, 20));
    //txtScFrt.setHorizontalAlignment(SwingConstants.RIGHT);

    txtYear.setBounds(new Rectangle(533, 127, 98, 20));
    jLabel114.setBounds(new Rectangle(388, 289, 155, 20));
    jLabel114.setBounds(new Rectangle(401, 317, 131, 20));
    jLabel114.setText(" CT INS :");
    jLabel114.setHorizontalAlignment(SwingConstants.LEFT);
    jLabel114.setOpaque(true);
    jLabel114.setForeground(Color.white);
    jLabel114.setFont(new java.awt.Font("Dialog", 1, 13));
    jLabel114.setBackground(new Color(143, 143, 188));
    txtCtOth.setBounds(new Rectangle(532, 342, 144, 20));
    //txtCtOth.setHorizontalAlignment(SwingConstants.RIGHT);
    jLabel14.setBounds(new Rectangle(9, 289, 155, 20));
    jLabel14.setBackground(new Color(143, 143, 188));
    jLabel14.setFont(new java.awt.Font("Dialog", 1, 13));
    jLabel14.setForeground(Color.white);
    jLabel14.setOpaque(true);
    jLabel14.setHorizontalAlignment(SwingConstants.LEFT);
    jLabel14.setText(" SC INS :");
    jLabel14.setBounds(new Rectangle(29, 316, 131, 20));

    txtSea.setBounds(new Rectangle(161, 129, 209, 20));
    jLabel2.setBounds(new Rectangle(649, 91, 52, 20));
    jLabel2.setBounds(new Rectangle(636, 127, 77, 20));
    jLabel2.setText("( Year )");
    jLabel2.setForeground(new Color(143, 143, 188));
    jLabel2.setFont(new java.awt.Font("Dialog", 1, 12));
    txtCtFrt.setBounds(new Rectangle(532, 292, 144, 20));
    //txtCtFrt.setHorizontalAlignment(SwingConstants.RIGHT);

    txtFTY.setBounds(new Rectangle(533, 177, 209, 20));
    jLabel1110.setBounds(new Rectangle(388, 214, 155, 20));
    jLabel1110.setBackground(new Color(143, 143, 188));
    jLabel1110.setFont(new java.awt.Font("Dialog", 1, 13));
    jLabel1110.setForeground(Color.white);
    jLabel1110.setOpaque(true);
    jLabel1110.setHorizontalAlignment(SwingConstants.LEFT);
    jLabel1110.setText(" CT Discount :");
    jLabel1110.setBounds(new Rectangle(401, 243, 131, 20));
    txtScOth.setBounds(new Rectangle(160, 342, 144, 20));
    //txtScOth.setHorizontalAlignment(SwingConstants.RIGHT);
    jLabel115.setBounds(new Rectangle(9, 14, 155, 20));
    jLabel115.setBounds(new Rectangle(30, 52, 131, 20));
    jLabel115.setText(" SRN No. :");
    jLabel115.setHorizontalAlignment(SwingConstants.LEFT);
    jLabel115.setOpaque(true);
    jLabel115.setForeground(new Color(10,36,106));
    jLabel115.setFont(new java.awt.Font("Dialog", 1, 13));
    jLabel115.setBackground(new Color(143, 143, 188));
    jLabel13.setBounds(new Rectangle(9, 189, 155, 20));
    jLabel13.setBounds(new Rectangle(29, 216, 131, 20));
    jLabel13.setText(" SC Amount :");
    jLabel13.setHorizontalAlignment(SwingConstants.LEFT);
    jLabel13.setOpaque(true);
    jLabel13.setForeground(new Color(10,36,106));
    jLabel13.setFont(new java.awt.Font("Dialog", 1, 13));
    jLabel13.setBackground(new Color(143, 143, 188));
    jLabel20.setBounds(new Rectangle(9, 140, 155, 20));
    jLabel20.setBackground(new Color(143, 143, 188));
    jLabel20.setFont(new java.awt.Font("Dialog", 1, 13));
    jLabel20.setForeground(Color.white);
    jLabel20.setOpaque(true);
    jLabel20.setHorizontalAlignment(SwingConstants.LEFT);
    jLabel20.setText(" FTY :");
    jLabel20.setBounds(new Rectangle(402, 177, 131, 20));

    txtDiv.setBounds(new Rectangle(161, 183, 209, 20));
    jLabel116.setBounds(new Rectangle(9, 91, 155, 20));
    jLabel116.setBounds(new Rectangle(30, 129, 131, 20));
    jLabel116.setText(" Season :");
    jLabel116.setHorizontalAlignment(SwingConstants.LEFT);
    jLabel116.setOpaque(true);
    jLabel116.setForeground(Color.white);
    jLabel116.setFont(new java.awt.Font("Dialog", 1, 13));
    jLabel116.setBackground(new Color(143, 143, 188));
    jLabel12.setBounds(new Rectangle(9, 265, 155, 20));
    jLabel12.setBackground(new Color(143, 143, 188));
    jLabel12.setFont(new java.awt.Font("Dialog", 1, 13));
    jLabel12.setForeground(new Color(10,36,106));
    jLabel12.setOpaque(true);
    jLabel12.setHorizontalAlignment(SwingConstants.LEFT);
    jLabel12.setText(" SC FRT :");
    jLabel12.setBounds(new Rectangle(29, 292, 131, 20));
    jLabel1112.setBounds(new Rectangle(388, 14, 155, 20));
    jLabel1112.setBackground(new Color(143, 143, 188));
    jLabel1112.setFont(new java.awt.Font("Dialog", 1, 13));
    jLabel1112.setForeground(new Color(10,36,106));
    jLabel1112.setOpaque(true);
    jLabel1112.setHorizontalAlignment(SwingConstants.LEFT);
    jLabel1112.setText(" SC No. :");
    jLabel1112.setBounds(new Rectangle(402, 51, 131, 20));
    jLabel21.setBounds(new Rectangle(388, 91, 155, 20));
    jLabel21.setBounds(new Rectangle(402, 128, 131, 20));
    jLabel21.setText(" Year :");
    jLabel21.setHorizontalAlignment(SwingConstants.LEFT);
    jLabel21.setOpaque(true);
    jLabel21.setForeground(Color.white);
    jLabel21.setFont(new java.awt.Font("Dialog", 1, 13));
    jLabel21.setBackground(new Color(143, 143, 188));
    this.setLayout(null);
    this.setBackground(new Color(202, 202, 224));
    blueBkgWhiteCharLabel1.setText("EDIT S / I DATA");
    blueBkgWhiteCharLabel1.setBounds(new Rectangle(0, 14, 848, 31));
    lbl_formula_INCOME.setText("INCOME=S/C AMOUNT +S/C COMMISSION - S/C FREIGHT - S/C INSURANCE - " +
    "S/C OTHER");
    lbl_formula_INCOME.setBounds(new Rectangle(28, 401, 569, 24));
    txt_INCOME.setText("");
    txt_INCOME.setBounds(new Rectangle(597, 401, 141, 25));
    lbl_formula_COST.setBounds(new Rectangle(28, 430, 569, 24));
    lbl_formula_COST.setForeground(new Color(10, 36, 106));
    lbl_formula_COST.setText("COST= C/T AMOUNT - C/T DISCOUNT + C/T FREIGHT+ C/T INSURANCE + C/T " +
    "OTHER");
    txt_COST.setBounds(new Rectangle(597, 430, 141, 25));
    txt_COST.setText("");
    lbl_formula_INCOME1.setBounds(new Rectangle(28, 459, 569, 24));
    lbl_formula_INCOME1.setText("PROFIT = INCOME- COST");
    txt_PROFIT.setText("");
    txt_PROFIT.setBounds(new Rectangle(597, 459, 141, 25));
    txtPftShare.setBounds(new Rectangle(184, 369, 120, 21));
    jLabel16.setBounds(new Rectangle(29, 316, 131, 20));
    jLabel16.setText("Profit Share Code :");
    jLabel16.setHorizontalAlignment(SwingConstants.LEFT);
    jLabel16.setOpaque(true);
    jLabel16.setForeground(Color.white);
    jLabel16.setFont(new java.awt.Font("Dialog", 1, 13));
    jLabel16.setBackground(new Color(143, 143, 188));
    jLabel16.setBounds(new Rectangle(29, 369, 156, 20));
    this.add(blueBkgWhiteCharLabel1, null);
    this.add(jLabel115, null);
    this.add(txtSrnNo, null);
    this.add(jLabel19, null);
    this.add(txtCen, null);
    this.add(jLabel7, null);
    this.add(txtMag, null);
    this.add(jLabel116, null);
    this.add(txtSea, null);
    this.add(jLabel9, null);
    this.add(txtBuyer, null);
    this.add(jLabel22, null);
    this.add(txtDiv, null);
    this.add(jLabel20, null);
    this.add(txtFTY, null);
    this.add(txtCnty, null);
    this.add(jLabel120, null);
    this.add(jLabel21, null);
    this.add(txtYear, null);
    this.add(jLabel2, null);
    this.add(jLabel111, null);
    this.add(txtDep, null);
    this.add(txtScNo, null);
    this.add(jLabel1112, null);
    this.add(jLabel13, null);
    this.add(jLabel15, null);
    this.add(txtSCAmt, null);
    this.add(txtSCComm, null);
    this.add(jLabel112, null);
    this.add(txtCTAmt, null);
    this.add(jLabel1110, null);
    this.add(txtCTPrice, null);
    this.add(jLabel12, null);
    this.add(txtScFrt, null);
    this.add(jLabel14, null);
    this.add(txtScIns, null);
    this.add(jLabel17, null);
    this.add(txtScOth, null);
    this.add(jLabel118, null);
    this.add(txtCtFrt, null);
    this.add(jLabel114, null);
    this.add(txtCtIns, null);
    this.add(jLabel18, null);
    this.add(txtCtOth, null);
    this.add(lbl_formula_INCOME, null);
    this.add(lbl_formula_COST, null);
    this.add(txt_INCOME, null);
    this.add(txt_COST, null);
    this.add(lbl_formula_INCOME1, null);
    this.add(txt_PROFIT, null);
    this.add(jLabel16, null);
    this.add(txtPftShare, null);
    txt_INCOME.setEditable(false);
    txt_COST.setEditable(false);
    txt_PROFIT.setEditable(false);

  }
  public class reCount extends java.awt.event.KeyAdapter{
   synchronized    public void keyReleased(java.awt.event.KeyEvent ke){
      //System.out.print("calls recount INCOME/COST/PROFIT");
       String scAmt=txtSCAmt.getText().trim();
       if(scAmt.equals("-"))scAmt="0";
       String scComm=txtSCComm.getText().trim();
       if(scComm.equals("-"))scComm="0";
       String scFrt=txtScFrt.getText().trim();
       if(scFrt.equals("-"))scFrt="0";
       String scIns=txtScIns.getText().trim();
       if(scIns.equals("-"))scIns="0";
       String scOther=txtScOth.getText().trim();
       if(scOther.equals("-"))scOther="0";

       String ctAmt=txtCTAmt.getText().trim();
       if(ctAmt.equals("-"))ctAmt="0";
       String ctDisc=txtCTPrice.getText().trim();
       if(ctDisc.equals("-"))ctDisc="0";
       String ctFrt=txtCtFrt.getText().trim();
       if(ctFrt.equals("-"))ctFrt="0";
       String ctIns=txtCtIns.getText().trim();
       if(ctIns.equals("-"))ctIns="0";
       String ctOther=txtCtOth.getText().trim();
       if(ctOther.equals("-"))ctOther="0";

       float income=Float.parseFloat((scAmt.length()==0)?"0":scAmt)+
                    Float.parseFloat((scComm.length()==0)?"0":scComm)-
                    Float.parseFloat((scFrt.length()==0)?"0":scFrt)-
                    Float.parseFloat((scIns.length()==0)?"0":scIns)-
                    Float.parseFloat((scOther.length()==0)?"0":scOther);
      float cost=Float.parseFloat((ctAmt.length()==0)?"0":ctAmt)-
                    Float.parseFloat((ctDisc.length()==0)?"0":ctDisc)+
                    Float.parseFloat((ctFrt.length()==0)?"0":ctFrt)+
                    Float.parseFloat((ctIns.length()==0)?"0":ctIns)+
                    Float.parseFloat((ctOther.length()==0)?"0":ctOther);
       float profit=income-cost;
       txt_INCOME.setText(String.valueOf(income));
       txt_COST.setText(String.valueOf(cost));
       txt_PROFIT.setText(String.valueOf(profit));
    }
  }
  public void doPrint(){

  }
  public void doUpdate(){
    if(!super.gui2Record())return;
    try{
      util.MiscFunc.showProcessingMessage();
      ((newtimes.shipping_admin.process.shiippingmaintain.DB_ShipMaster)dbprc).
          updateSiRecord(recToMapping);
      recClonedForCheck=(Record)util.MiscFunc.deepCopy(recToMapping);
    }catch(Exception exp){
      exp.printStackTrace();
      util.ExceptionLog.exp2File(exp,"") ;
      exgui.verification.VerifyLib.showAlert("Update Fail!!\nPlease Contact System Manager","Update Fail!!");
    }finally{
      util.MiscFunc.hideProcessingMessage();
    }
  }
 public void iniReadOnlyValue(Record rec2Mapping){
   try{
   Object vftxtDiv=exgui.verification.CellFormat.getOrdinaryField(35);
     new exgui.DataBindTextWithChecker(txtDiv,"DIVISION_NAME",rec2Mapping.get("DIVISION_NAME"),35,(exgui.Object2String)vftxtDiv,(exgui.ultratable.CellTxtEditorFormat)vftxtDiv);
     txtDiv.setEditable(false);

   Object vftxtFTY=exgui.verification.CellFormat.getOrdinaryField(15);
      new exgui.DataBindTextWithChecker(txtFTY,"MAKER",rec2Mapping.get("MAKER"),15,(exgui.Object2String)vftxtFTY,(exgui.ultratable.CellTxtEditorFormat)vftxtFTY);
      txtFTY.setEditable(false);

   Object vftxtSea=exgui.verification.CellFormat.getOrdinaryField(60);
     new exgui.DataBindTextWithChecker(txtSea,"PROD_SEASON",rec2Mapping.get("PROD_SEASON"),60,(exgui.Object2String)vftxtSea,(exgui.ultratable.CellTxtEditorFormat)vftxtSea);
      txtSea.setEditable(false);

   Object vftxtYear=exgui.verification.CellFormat.getOrdinaryField(4);
      new exgui.DataBindTextWithChecker(txtYear,"PROD_YEAR",rec2Mapping.get("PROD_YEAR"),4,(exgui.Object2String)vftxtYear,(exgui.ultratable.CellTxtEditorFormat)vftxtYear);
      txtYear.setEditable(false);


   Object vftxtCen=exgui.verification.CellFormat.getOrdinaryField(12);
     new exgui.DataBindTextWithChecker(txtCen,"CEN_NAME",rec2Mapping.get("CEN_NAME"),12,(exgui.Object2String)vftxtCen,(exgui.ultratable.CellTxtEditorFormat)vftxtCen);
     txtCen.setEditable(false);

   Object vftxtMag=exgui.verification.CellFormat.getOrdinaryField(20);
      new exgui.DataBindTextWithChecker(txtMag,"MAMANGER",rec2Mapping.get("MAMANGER"),20,(exgui.Object2String)vftxtMag,(exgui.ultratable.CellTxtEditorFormat)vftxtMag);
      txtMag.setEditable(false);

   Object vftxtDep=exgui.verification.CellFormat.getOrdinaryField(60);
     new exgui.DataBindTextWithChecker(txtDep,"DEP_NAME",rec2Mapping.get("DEP_NAME"),60,(exgui.Object2String)vftxtDep,(exgui.ultratable.CellTxtEditorFormat)vftxtDep);
     txtDep.setEditable(false);

   Object vftxtBuyer=exgui.verification.CellFormat.getOrdinaryField(15);
     new exgui.DataBindTextWithChecker(txtBuyer,"BUYER",rec2Mapping.get("BUYER"),15,(exgui.Object2String)vftxtBuyer,(exgui.ultratable.CellTxtEditorFormat)vftxtBuyer);
     txtBuyer.setEditable(false);

   Object vftxtSrnNo=exgui.verification.CellFormat.getOrdinaryFieldNotAllowNull(15);
     new exgui.DataBindTextWithChecker(txtSrnNo,"SHIP_NO",rec2Mapping.get("SHIP_NO"),15,(exgui.Object2String)vftxtSrnNo,(exgui.ultratable.CellTxtEditorFormat)vftxtSrnNo);
     txtSrnNo.setEditable(false);

   Object vftxtScNo=exgui.verification.CellFormat.getOrdinaryField(20);
      new exgui.DataBindTextWithChecker(txtScNo,"PROD_SC_NO",rec2Mapping.get("PROD_SC_NO"),20,(exgui.Object2String)vftxtScNo,(exgui.ultratable.CellTxtEditorFormat)vftxtScNo);
      txtScNo.setEditable(false);

   Object vftxtCnty=exgui.verification.CellFormat.getOrdinaryField(60);
    new exgui.DataBindTextWithChecker(
      txtCnty,"PROD_QC_CNTY",
      rec2Mapping.get("PROD_QC_CNTY"),60,(exgui.Object2String)vftxtCnty,(exgui.ultratable.CellTxtEditorFormat)vftxtCnty);
    txtCnty.setEditable(false);
    Object  sc_amt=rec2Mapping.get("sc_amt"),
            sc_comm=rec2Mapping.get("sc_comm"),
            ct_amt=rec2Mapping.get("ct_amt"),
            ct_disc=rec2Mapping.get("ct_disc");

    txtSCAmt.setText((sc_amt==null)?"":sc_amt.toString());txtSCAmt.setEditable(false);
    txtSCComm.setText((sc_comm==null)?"":sc_comm.toString());txtSCComm.setEditable(false);
    txtCTAmt.setText((ct_amt==null)?"":ct_amt.toString());txtCTAmt.setEditable(false);
    txtCTPrice.setText((ct_disc==null)?"":ct_disc.toString());txtCTPrice.setEditable(false);


   }catch(Exception exp){
     exp.printStackTrace();
   }

 }
}
