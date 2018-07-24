package newtimes.production.gui.prodmaintain;
import database.datatype.Record;
import java.awt.event.ActionEvent;
import java.util.*;
/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class ChanedPnlModifyStyleValues extends ChainedPnlDftStyleValue {
  protected exgui.DataBindTextWithChecker dbTxtBuyerDocPrx,dbTxtBuyerActPrx,dbTxtMakerDocPrx,dbTxtMkrActPrx;
  protected boolean isStyleNull=false;
  protected boolean isPriceNull=false;
  protected javax.swing.JComboBox cbxQTA=new javax.swing.JComboBox();
  protected javax.swing.JLabel lblQTA=new javax.swing.JLabel();
  protected exgui.DataBindJCombobox dbCbxQTA;
  public ChanedPnlModifyStyleValues() {
    super();
    afterJbinit();
    txtTtlQty.setText("");
  }
  public void record2Gui(){
    blueBkgWhiteCharLabel1.setText("Change The Same Values For All Columns");
    try{
    dataBoundGUIs.clear();
    Object vftxtOrgDel=exgui.verification.CellFormat.getDateStringFormaterAllowNull();
     dataBoundGUIs.add(
        new exgui.DataBindTextWithChecker(txtOrgDel,
                                          "STY_ORIG_DEL",
                                          null,10,
                                          (exgui.Object2String)vftxtOrgDel,
                                          (exgui.ultratable.CellTxtEditorFormat)vftxtOrgDel)
    );

     dataBoundGUIs.add(
       new exgui.DataBindTextWithChecker(
              txtRcfDel,"STY_RECFM_DEL",
              null,10,
             (exgui.Object2String)vftxtOrgDel,
             (exgui.ultratable.CellTxtEditorFormat)vftxtOrgDel)
    );
       dataBoundGUIs.add(
           new exgui.DataBindTextWithChecker(
           txtMkrDelDate, "STY_MKR_DEL",
           null, 10,
           (exgui.Object2String)vftxtOrgDel,
           (exgui.ultratable.CellTxtEditorFormat)vftxtOrgDel)
           );

     //to avoid over write c/t head's c/t issue date,in current GUI, can not show vender issue date field
      dataBoundGUIs.add(
        new exgui.DataBindTextWithChecker(
        txtMkrIssueDate, "STY_VENDER_ISSUE",
        recToMapping.get("STY_VENDER_ISSUE"), 10,
        (exgui.Object2String)vftxtOrgDel,
        (exgui.ultratable.CellTxtEditorFormat)vftxtOrgDel)
      );
   /*
    Object vftxtShipMod=exgui.verification.CellFormat.getOrdinaryField(1);
     dataBoundGUIs.add(
       new exgui.DataBindTextWithChecker(
         txtShipMod,"STY_ORIG_WAY",
         null,1,
        (exgui.Object2String)vftxtShipMod,
        (exgui.ultratable.CellTxtEditorFormat)vftxtShipMod)
    );*/
   Vector vctShipWays=newtimes.preproduction.guis.tempProperties.tempShipModes;
   dataBoundGUIs.add(
      new exgui.DataBindJCombobox(cbxShipMode,
     "STY_ORIG_WAY",vctShipWays,"SHIP_MODE_NAME","SHIP_MODE_CODE",
      null,"",null));
      cbxShipMode.setToolTipText("<html><body>A:Air,B:Boat,S:Sea,W:West Coast,T:Truck,C:Courier,F:Fedex Collect,<br> O " +
         ":Ocean,V:Vessel</body></html>");


 //-----------------for qty object  -------------
   Object vftxtQty=exgui.verification.CellFormat.getDoubleFormatAllowNull(7,2);
   exgui.DataBindTextWithChecker dbTxtQty=
      new exgui.DataBindTextWithChecker(
       txtTtlQty,"",
      new Integer(0),10,(exgui.Object2String)vftxtQty,
          (exgui.ultratable.CellTxtEditorFormat)vftxtQty);

//--------for qta object-----------------
      Vector vctQtas=newtimes.preproduction.guis.tempProperties.tmpCATData;
     dbCbxQTA=new exgui.DataBindJCombobox(
            cbxQTA,"",
            vctQtas,
            "cat_data","cat_data",
            null,"",null);

  //--for price object----------------

    Object vftxtBuyDocPrx=exgui.verification.CellFormat.getDoubleFormatAllowNull(7,3);
   dbTxtBuyerDocPrx=
        new exgui.DataBindTextWithChecker(
         txtBuyDocPrx,"PRI_BYR_DOC_PRX",
        null,10,(exgui.Object2String)vftxtBuyDocPrx,
             (exgui.ultratable.CellTxtEditorFormat)vftxtBuyDocPrx);

   dbTxtBuyerActPrx=
     new exgui.DataBindTextWithChecker(
    txtBuyActPrx,"PRI_BYR_ACT_PRX",
    null,10,
    (exgui.Object2String)vftxtBuyDocPrx,
    (exgui.ultratable.CellTxtEditorFormat)vftxtBuyDocPrx);

   dbTxtMakerDocPrx=
    new exgui.DataBindTextWithChecker(
      txtMkrDocPrx,"PRI_MKR_DOC_PRX",
      null,10,(exgui.Object2String)vftxtBuyDocPrx,
      (exgui.ultratable.CellTxtEditorFormat)vftxtBuyDocPrx);

   dbTxtMkrActPrx=
    new exgui.DataBindTextWithChecker(
     txtMkrActPrx,"PRI_MKR_ACT_PRX",null,10,
     (exgui.Object2String)vftxtBuyDocPrx,
     (exgui.ultratable.CellTxtEditorFormat)vftxtBuyDocPrx);


   Vector vctPrxTrm=newtimes.preproduction.guis.tempProperties.tmpPriceTerm;
   dataBoundGUIs.add(
      new exgui.DataBindJCombobox(cbxCtPriceTerm,"STY_CT_PRC_TRM",
                                  vctPrxTrm,
                                  "PRC_TRM","PRC_TRM",
                                  null,"",null));//FOB

  Vector vctDestination=newtimes.production.process.prodmaintain.DB_ProdSC.getDestinations();
  dataBoundGUIs.add(
    new exgui.DataBindJCombobox(
        cbxCT_Dest,"STY_CT_DEST",
        vctDestination,
        "DEST_NAME","DEST_NAME",
        null,"",null));//recToMapping.get("STY_CT_DEST")
   Vector vctCurrency=newtimes.preproduction.guis.tempProperties.tmpCurrency;
   dataBoundGUIs.add(
     new exgui.DataBindJCombobox(
         cbxCtCurrency,"STY_CT_CURRENCY",
         vctCurrency,
         "CRNCY_NAME",
         "CRNCY_NAME",
         null,"",null));//recToMapping.get("STY_CT_CURRENCY")
    Vector vctUnit=newtimes.preproduction.guis.tempProperties.tmpUnits;
   dataBoundGUIs.add(
    new exgui.DataBindJCombobox(cbxStyUnit,
    "STY_UNIT",vctUnit,"UNIT","UNIT",
    null,"",null));


    txtBuyDocPrx.addKeyListener(new PriceKeyProc());
  }catch(Exception exp){
     exp.printStackTrace();
  }

     super.jLabel14.setVisible(false);
     super.jLabel15.setVisible(false);
     super.jLabel16.setVisible(false);
     super.jLabel17.setVisible(false);
     super.jLabel18.setVisible(false);
     super.jLabel19.setVisible(false);
     txtSeqFrom.setVisible(false);
     txtSeqTo.setVisible(false);
     txtSeqFrom4BarCode.setVisible(false);
     txtSeqTo4BarCode.setVisible(false);
     txtStylePrefix.setVisible(false);
     txtStyleBarcodePrefix.setVisible(false);
     this.repaint();
     this.validate();
     txtTtlQty.setText("");
     //txtBuyActPrx.setText("");txtBuyDocPrx.setText("");
     //txtMkrActPrx.setText("");txtMkrDocPrx.setText("");
     //txtTtlQty.setVisible(false);
 }
 protected void afterJbinit(){
   cbxQTA=new javax.swing.JComboBox();
   lblQTA.setFont(new java.awt.Font("Dialog", 1, 11));
   lblQTA.setText("QTA:");
   lblQTA.setBounds(new java.awt.Rectangle(291, 154, 185, 28));
   cbxQTA.setBounds(new java.awt.Rectangle(391, 159, 83, 25));
   this.add(lblQTA,null);
   this.add(cbxQTA,null);
   txtTtlQty.setText("");

 }
 public boolean gui2Record(){
   //dataBoundGUIs is composed at the function "record2GUI"
   isStyleNull=true;
   try{
     for (int i = 0; i < dataBoundGUIs.size(); i++) {
       exgui.DataBindGUIObject dbGUIOBJ=(exgui.DataBindGUIObject)dataBoundGUIs.get(i);
       //we just concern the single selection

       if (dbGUIOBJ instanceof exgui.SwingSingleSelection) {
         if(dbGUIOBJ instanceof exgui.DataBindTextWithChecker ){
           //if that's a text field with checker,we have to test for validation.
           exgui.DataBindTextWithChecker chkr = (exgui.DataBindTextWithChecker)
               dbGUIOBJ;
           if (((javax.swing.text.JTextComponent)chkr.getGUIcomponent()).
               getText().trim().equals(""))continue;
           if (!chkr.isValidx()) {
             //System.out.println("invalid at :"+dbGUIOBJ.getOrgRecField());
             exgui.verification.VerifyLib.showAlert(
                 "Format error,Pleae check the column", "Format invalid"
                 );
             dbGUIOBJ.getGUIcomponent().grabFocus();
             return false;
           }
         }
         //only the changed fields have to be update.
         if(dbGUIOBJ instanceof exgui.DataBindJCombobox ){
           exgui.SwingSingleSelection sglSlt = (exgui.SwingSingleSelection)
               dbGUIOBJ;
           if(sglSlt.getSelectedValue()!=null){
             recToMapping.set(dbGUIOBJ.getOrgRecField(),
                              sglSlt.getSelectedValue());
           }else{
             continue;
           }

         }
         recToMapping.set(dbGUIOBJ.getOrgRecField(),
          ((exgui.SwingSingleSelection)dbGUIOBJ).getSelectedValue());
         isStyleNull=false;
       }

     }
     return true;
   }catch(Exception e){
      e.printStackTrace();
      util.ExceptionLog.exp2File(e,"exp while gui2record");
      return false;
   }

 }
 boolean isPriceZero(javax.swing.JTextField txt){
   boolean result=false;
   try{
     if(txt.getText().trim().length() == 0)return false;
     //if (txt.getText().trim().length() == 0)result= true;
     if (Float.parseFloat(txt.getText().trim()) == 0)result= true;
     return false;
   }catch(Exception exp){
     exp.printStackTrace();
      result=true;
   }
   if(result){
     exgui.verification.VerifyLib.showAlert("Price Can Not Be Zero","Price Can Not Be Zero");
     txt.grabFocus();
   }
   return result;
 }
 boolean  btnOK_actionPerformed(ActionEvent e) throws Exception{
   if(!gui2Record())return false;
   if(dbCbxQTA.getSelectedValue()!=null){
     isStyleNull=false;
     if(dbCbxQTA.getSelectedValue().equals("N/A")){
       recToMapping.set("sty_qta_cat", null);
       recToMapping.set("sty_qta_area", null);
     }else{
       String qtaValue = (String)dbCbxQTA.getSelectedValue();
       String qta_cat = qtaValue.substring(0, qtaValue.length() - 1);
       String qta_area = qtaValue.substring(qtaValue.length() - 1,
                                            qtaValue.length());
       recToMapping.set("sty_qta_cat", qta_cat);
       recToMapping.set("sty_qta_area", qta_area);
     }

   }
  //compose style records
    Record priceRec=exgui2.CONST.BASIC_MAIN_EJB.getBlankRecord("PRICE_tbl");
    isPriceNull=true;
    if(isPriceZero(txtBuyActPrx)||isPriceZero(txtBuyDocPrx)||
       isPriceZero(txtMkrActPrx)||isPriceZero(txtMkrDocPrx))return false;
    if(txtBuyDocPrx.getText().trim().length()>0){
      priceRec.set(dbTxtBuyerDocPrx.getOrgRecField(),
                   dbTxtBuyerDocPrx.getSelectedValue());
      isPriceNull=false;
    }
    if(txtBuyActPrx.getText().trim().length()>0){
      priceRec.set(dbTxtBuyerActPrx.getOrgRecField(),
                   dbTxtBuyerActPrx.getSelectedValue());
      isPriceNull=false;
    }
    if(txtMkrDocPrx.getText().trim().length()>0){
      priceRec.set(dbTxtMakerDocPrx.getOrgRecField(),
                   dbTxtMakerDocPrx.getSelectedValue());
      isPriceNull=false;
    }
    if(txtMkrActPrx.getText().trim().length()>0){
      priceRec.set(dbTxtMkrActPrx.getOrgRecField(),
                   dbTxtMkrActPrx.getSelectedValue());
      isPriceNull=false;
    }
     util.MiscFunc.showProcessingMessage();
     ((newtimes.production.process.prodmaintain.DB_StyleListHandler)dbprc).bachUpdateColumns(
      (isStyleNull)?null:recToMapping,
      (isPriceNull)?null:priceRec,
      (txtTtlQty.getText().trim().length()==0)?null:txtTtlQty.getText().trim());
     util.MiscFunc.hideProcessingMessage();
     return true;
 }
}
