package newtimes.basic.buyermaker;

import java.awt.*;
import newtimes.*;
import javax.swing.*;
import java.awt.event.*;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author unascribed
 * @version 1.0
 */

public class BuyerMakerEdit extends JPanel {
  Frame1 frame;
  private JTextField textAreaStatus = new JTextField();
  private JLabel jLabel1 = new JLabel();
  private JButton butnDel = new JButton();
  private JButton butnModify = new JButton();
  private JButton butnExit = new JButton();
  private JScrollPane jScrollPane1 = new JScrollPane();
  private newtimes.basic.buyermaker.FieldsGuiPanel fieldsGuiPanel =
      new newtimes.basic.buyermaker.FieldsGuiPanel(frame);
  private java.util.HashMap hm =
    (java.util.HashMap)util.ApplicationProperites.getProperties("recDetail");
  private String _bymkrSEQ = null;
  static boolean isExit = false;

  public BuyerMakerEdit(Frame1 _frame) {
    frame = _frame;
    try {
      jbInit();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }
  void jbInit() throws Exception {
    jLabel1.setFont(new java.awt.Font("Dialog", 1, 13));
    jLabel1.setForeground(new Color(10,36,106));
    jLabel1.setBorder(BorderFactory.createEtchedBorder());
    jLabel1.setHorizontalAlignment(SwingConstants.CENTER);
    jLabel1.setText("      ============  Buyer - Maker Edit  ============      ");
    jLabel1.setBounds(new Rectangle(117, 26, 566, 24));
    textAreaStatus.setBackground(new Color(143, 143, 188));
    textAreaStatus.setBorder(null);
    textAreaStatus.setEditable(false);
    textAreaStatus.setBounds(new Rectangle(0, 540, 800, 30));
    this.setLayout(null);
    this.setSize(800,600);
    this.setBackground(new Color(204, 204, 225));
    butnDel.setBackground(Color.lightGray);
    butnDel.setBounds(new Rectangle(369, 508, 80, 25));
    butnDel.setFont(new java.awt.Font("Dialog", 1, 13));
    butnDel.setForeground(Color.darkGray);
    butnDel.setText("Delete");
    butnDel.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        butnDel_actionPerformed(e);
      }
    });
    butnModify.setBackground(Color.lightGray);
    butnModify.setBounds(new Rectangle(222, 508, 132, 25));
    butnModify.setFont(new java.awt.Font("Dialog", 1, 13));
    butnModify.setForeground(Color.darkGray);
    butnModify.setText("Confirm Modify");
    butnModify.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        butnModify_actionPerformed(e);
      }
    });
    butnExit.setBackground(Color.lightGray);
    butnExit.setBounds(new Rectangle(463, 508, 80, 25));
    butnExit.setFont(new java.awt.Font("Dialog", 1, 13));
    butnExit.setForeground(Color.darkGray);
    butnExit.setText("Exit");
    butnExit.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        butnExit_actionPerformed(e);
      }
    });
    jScrollPane1.setBorder(BorderFactory.createEtchedBorder());
    jScrollPane1.setBounds(new Rectangle(0, 66, 793, 435));
    this.add(jLabel1, null);
    this.add(textAreaStatus, null);
    this.add(butnExit, null);
    this.add(butnModify, null);
    this.add(butnDel, null);
    this.add(jScrollPane1, null);
    //fieldsGuiPanel.setPreferredSize(new Dimension(770,980));
    fieldsGuiPanel.setPreferredSize(new Dimension(770,1065));
    jScrollPane1.getViewport().add(fieldsGuiPanel, null);
    this.setData2Fields();
  }

  void butnExit_actionPerformed(ActionEvent e) {
    setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
    isExit = true;
    frame.showPanel(new newtimes.basic.buyermaker.BuyerMakerList(frame));
    setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
  }

  void butnDel_actionPerformed(ActionEvent e) {
    int result = exgui2.InfoMessage.Yes_No_Option(frame,"Delete ?");
    if(result == 0){
      setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
      try {
        isExit = true;
        hm.clear();
        hm.put("BYMKR_SEQ", this._bymkrSEQ);
        hm.put("delete_user", util.PublicVariable.USER_RECORD.get("USR_CODE"));
        boolean isOk = exgui2.CONST.BASIC_MAIN_EJB.deleteBuyerMaker(hm);
        if (isOk) {
          exgui2.InfoMessage.infoMessage(frame, "Delete Succeed.");
          frame.showPanel(new newtimes.basic.buyermaker.BuyerMakerList(frame));
        } else {
          exgui2.InfoMessage.warningMessage(frame, "Delete Failed.");
        }
      }catch(BasicMdlEJBs.ExcpDltReferedByProdution edProdUsed){
        exgui.verification.VerifyLib.showPlanMsg("Sorry,This Buyer/Makser Is Referenced In Some Production(s)",
                                                 "Buyer/Maker Referenced");
      }catch(java.rmi.RemoteException re){
        re.printStackTrace();
        util.ExceptionLog.exp2File(re,"");
        exgui.verification.VerifyLib.showAlert("Connection Or Server Side Error\nPlease Contact System Manager",
                                               "Remote Exception");
      } catch (Exception eDel) {
        eDel.printStackTrace();
        util.ExceptionLog.exp2File(eDel, "error at delete data." + hm.toString());
      }finally{
        setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
      }
    }
  }

  void butnModify_actionPerformed(ActionEvent e) {
    int result = exgui2.InfoMessage.Yes_No_Option(frame,"Modify ?");
    if (!fieldsGuiPanel.checkFieldsData())return;
    if(result == 0){
      setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
      try {
        isExit = true;
        hm.clear();
        hm = fieldsGuiPanel.setData2HashMap();
        hm.put("update_user", util.PublicVariable.USER_RECORD.get("USR_CODE"));
        hm.put("BYMKR_SEQ", this._bymkrSEQ);
        boolean isOk = exgui2.CONST.BASIC_MAIN_EJB.updateBuyerMaker(hm);
        if (isOk) {
          exgui2.InfoMessage.infoMessage(frame, "Modify Succeed.");
          frame.showPanel(new newtimes.basic.buyermaker.BuyerMakerList(frame));
        } else {
          exgui2.InfoMessage.warningMessage(frame, "Modify Failed.");
        }
      } catch (Exception eDel) {
        eDel.printStackTrace();
        util.ExceptionLog.exp2File(eDel, "error at modify data." + hm.toString());
      }
      setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
    }
  }

  void setData2Fields() {
    database.datatype.Record recDetail = null;
    try {
      recDetail = (database.datatype.Record)hm.get("recDetail");
      this._bymkrSEQ = recDetail.get("BYMKR_SEQ").toString();

      Object trading_cat = recDetail.get("BYMKR_TRADING_CAT");
      Object cnty_code = recDetail.get("BYMKR_CNTY_CODE");
      Object cnty_name = recDetail.get("BYMKR_CITY_NAME");
      Object type = recDetail.get("BYMKR_TYPE");
      Object addr1 = recDetail.get("BYMKR_ADDR1");
      Object addr2 = recDetail.get("BYMKR_ADDR2");
      Object addr3 = recDetail.get("BYMKR_ADDR3");
      Object addr4 = recDetail.get("BYMKR_ADDR4");
      Object sec_addr1 = recDetail.get("BYMKR_SEC_ADDR1");
      Object sec_addr2 = recDetail.get("BYMKR_SEC_ADDR2");
      Object sec_addr3 = recDetail.get("BYMKR_SEC_ADDR3");
      Object sec_addr4 = recDetail.get("BYMKR_SEC_ADDR4");
      Object benef = recDetail.get("BYMKR_BENEFICIARY");
      Object boss = recDetail.get("BYMKR_BOSS");
      Object brief = recDetail.get("BYMKR_BRIEF");
      Object ch_brief = recDetail.get("BYMKR_CHINESE_BRIEF");
      Object priceterm_dest = recDetail.get("BYMKR_PRICETERM_DEST");
      Object email = recDetail.get("BYMKR_EMAIL");
      Object fax1 = recDetail.get("BYMKR_FAX1");
      Object fax2 = recDetail.get("BYMKR_FAX2");
      Object name = recDetail.get("BYMKR_NAME");
      Object name2 = recDetail.get("BYMKR_NAME2");
      Object old = recDetail.get("BYMKR_OLD");
      Object payterm = recDetail.get("BYMKR_PAYTERM");
      Object contact_person = recDetail.get("BYMKR_CONTACT_PERSON");
      Object pricerterm = recDetail.get("BYMKR_PRICETERM");
      Object sewing_shop_code = recDetail.get("BYMKR_SEWING_SHOP_CODE");
      Object tel1 = recDetail.get("BYMKR_TEL1");
      Object tel2 = recDetail.get("BYMKR_TEL2");
      Object warehouse = recDetail.get("BYMKR_WAREHOUSE");
      Object website = recDetail.get("BYMKR_WEBSITE");
      Object check_div = recDetail.get("BYMKR_CHECK_DIV");
      Object compliance_audit = recDetail.get("BYMKR_COMPLIANCE_AUDIT");
      Object master_co = recDetail.get("MASTER_CO");

       Object buyerComm=recDetail.get("BUY_COMM");
       Object shipBuyerComm=recDetail.get("SHIP_BUY_COMM");
       Object buyerCommPc=recDetail.get("BUY_COMM_PC");
       Object buyerCommDz=recDetail.get("BUY_COMM_DZ");
       Object buyerCommLumpSum=recDetail.get("BUY_COMM_LUMP_SUM");

      Object makerDiscount=recDetail.get("MKR_DSCT_PER");
      Object makerDiscountPC=recDetail.get("MKR_DSCT_PC");
      Object makerDiscountDZ=recDetail.get("MKR_DSCT_DZ");
      Object makerLumpSum=recDetail.get("MKR_DSCT_LUMP_SUM");
      Object buyermaker_multi_type=recDetail.get("BYMKR_MULTI_TYPE");
      Object shipStaffUsrCode=recDetail.get("SHIP_RESPONSIBLE_BY");
      Object hkCode=recDetail.get("BYMKR_HK_CODE");
      if(buyermaker_multi_type!=null){
        String buyermaker_multi_type_string=(String)buyermaker_multi_type;
        if(buyermaker_multi_type_string.indexOf(fieldsGuiPanel.BYMKR_BUYER_TYPE)!=-1){
          fieldsGuiPanel.chkBoxBymrkType_Buyer.setSelected(true);
        }else{
          fieldsGuiPanel.chkBoxBymrkType_Buyer.setSelected(false);
        }
        if(buyermaker_multi_type_string.indexOf(fieldsGuiPanel.BYMKR_MAKER_TYPE)!=-1){
          fieldsGuiPanel.chkBoxBymrkType_Maker.setSelected(true);
        }else{
          fieldsGuiPanel.chkBoxBymrkType_Maker.setSelected(false);
        }
        if(buyermaker_multi_type_string.indexOf(fieldsGuiPanel.BYMKR_FABRIC_MILL_TYPE)!=-1){
          fieldsGuiPanel.chkBoxBymrkType_FabricMill.setSelected(true);
        }else{
          fieldsGuiPanel.chkBoxBymrkType_FabricMill.setSelected(false);
        }
        if(buyermaker_multi_type_string.indexOf(fieldsGuiPanel.BYMKR_WASH_MILL_TYPE)!=-1){
          fieldsGuiPanel.chkBoxBymrkType_WashMill.setSelected(true);
        }else{
          fieldsGuiPanel.chkBoxBymrkType_WashMill.setSelected(false);
        }
        if(buyermaker_multi_type_string.indexOf(fieldsGuiPanel.BYMKR_SWEING_SHOP_TYPE)!=-1){
          fieldsGuiPanel.chkBoxBymrkType_SewingShop.setSelected(true);
        }else{
          fieldsGuiPanel.chkBoxBymrkType_SewingShop.setSelected(false);
        }
        if(buyermaker_multi_type_string.indexOf(fieldsGuiPanel.BYMKR_SHIPPING_TYPE)!=-1){
          fieldsGuiPanel.chkBoxBymrkType_Shipping.setSelected(true);
        }else{
          fieldsGuiPanel.chkBoxBymrkType_Shipping.setSelected(false);
        }
        if(buyermaker_multi_type_string.indexOf(fieldsGuiPanel.BYMKR_LICENSEE_TYPE)!=-1){
          fieldsGuiPanel.chkBoxBymrkType_Licensee.setSelected(true);
        }else{
          fieldsGuiPanel.chkBoxBymrkType_Licensee.setSelected(false);
        }
        if(buyermaker_multi_type_string.indexOf(fieldsGuiPanel.BYMKR_OTHER_TYPE)!=-1){
          fieldsGuiPanel.chkBoxBymrkType_Others.setSelected(true);
        }else{
          fieldsGuiPanel.chkBoxBymrkType_Others.setSelected(false);
        }
       //MESSERS, SUPPLIER, MANUFACTURER & CONSIGNEE
        if(buyermaker_multi_type_string.indexOf(fieldsGuiPanel.BYMKR_MESSERS_TYPE)!=-1){
          fieldsGuiPanel.chkBoxBymrkType_MESSERS.setSelected(true);
        }else{
          fieldsGuiPanel.chkBoxBymrkType_MESSERS.setSelected(false);
        }

        if(buyermaker_multi_type_string.indexOf(fieldsGuiPanel.BYMKR_SUPPLIER_TYPE)!=-1){
          fieldsGuiPanel.chkBoxBymrkType_SUPPLIER.setSelected(true);
        }else{
          fieldsGuiPanel.chkBoxBymrkType_SUPPLIER.setSelected(false);
        }

        if(buyermaker_multi_type_string.indexOf(fieldsGuiPanel.BYMKR_MANUFACTURER_TYPE)!=-1){
          fieldsGuiPanel.chkBoxBymrkType_MANUFACTURER.setSelected(true);
        }else{
          fieldsGuiPanel.chkBoxBymrkType_MANUFACTURER.setSelected(false);
        }

        if(buyermaker_multi_type_string.indexOf(fieldsGuiPanel.BYMKR_CONSIGNEE_TYPE)!=-1){
          fieldsGuiPanel.chkBoxBymrkType_CONSIGNEE.setSelected(true);
        }else{
          fieldsGuiPanel.chkBoxBymrkType_CONSIGNEE.setSelected(false);
        }
        if(buyermaker_multi_type_string.indexOf(fieldsGuiPanel.BYMKR_VENDOR_TYPE)!=-1){
          fieldsGuiPanel.chkBoxBymrkType_Vendor.setSelected(true);
        }else{
          fieldsGuiPanel.chkBoxBymrkType_Vendor.setSelected(false);
        }


      }
      fieldsGuiPanel.txtBuyerComm.setText((buyerComm==null)?"":buyerComm.toString());
      fieldsGuiPanel.txtShipBuyerComm.setText((shipBuyerComm==null)?"":shipBuyerComm.toString());
      fieldsGuiPanel.txtMakerDiscount.setText((makerDiscount==null)?"":makerDiscount.toString());
      fieldsGuiPanel.txtMakerDiscountPC.setText((makerDiscountPC==null)?"":makerDiscountPC.toString());
      fieldsGuiPanel.txtMakerDiscountDZ.setText((makerDiscountDZ==null)?"":makerDiscountDZ.toString());
      fieldsGuiPanel.txtMkrLumpSum.setText((makerLumpSum==null)?"":makerLumpSum.toString());

      fieldsGuiPanel.txtBuyerCommPC.setText((buyerCommPc==null)?"":buyerCommPc.toString());
      fieldsGuiPanel.txtBuyerCommDz.setText((buyerCommDz==null)?"":buyerCommDz.toString());
      fieldsGuiPanel.txtBuyerCommLumpSum.setText((buyerCommLumpSum==null)?"":buyerCommLumpSum.toString());

      fieldsGuiPanel.cmboCat.setSelectedItem(trading_cat==null?"":trading_cat.toString());
      fieldsGuiPanel.cmboCnty.setSelectedItem(cnty_code==null?"":cnty_code.toString());
      fieldsGuiPanel.cmboCity.setSelectedItem(cnty_name==null?"":cnty_name.toString());
      //fieldsGuiPanel.cmboType.setSelectedIndex(Integer.parseInt(type.toString())-1);

      fieldsGuiPanel.txtAddr1.setText(addr1==null?"":addr1.toString());
      fieldsGuiPanel.txtAddr2.setText(addr2==null?"":addr2.toString());
      fieldsGuiPanel.txtAddr3.setText(addr3==null?"":addr3.toString());
      fieldsGuiPanel.txtAddr4.setText(addr4==null?"":addr4.toString());
      fieldsGuiPanel.txt2ndAddr1.setText(sec_addr1==null?"":sec_addr1.toString());
      fieldsGuiPanel.txt2ndAddr2.setText(sec_addr2==null?"":sec_addr2.toString());
      fieldsGuiPanel.txt2ndAddr3.setText(sec_addr3==null?"":sec_addr3.toString());
      fieldsGuiPanel.txt2ndAddr4.setText(sec_addr4==null?"":sec_addr4.toString());
      fieldsGuiPanel.txtBenef.setText(benef==null?"":benef.toString());
      fieldsGuiPanel.txtBoss.setText(boss==null?"":boss.toString());
      fieldsGuiPanel.txtBrief.setText(brief==null?"":brief.toString());
      fieldsGuiPanel.txtChBrief.setText(ch_brief==null?"":ch_brief.toString());
      //fieldsGuiPanel.txtDes.setText(priceterm_dest==null?"":priceterm_dest.toString());
      fieldsGuiPanel.cmboDest.setSelectedItem(priceterm_dest==null?"":priceterm_dest.toString());
      fieldsGuiPanel.txtEmail.setText(email==null?"":email.toString());
      fieldsGuiPanel.txtFax1.setText(fax1==null?"":fax1.toString());
      fieldsGuiPanel.txtFax2.setText(fax2==null?"":fax2.toString());
      fieldsGuiPanel.txtName.setText(name==null?"":name.toString());
      fieldsGuiPanel.txtNameFullName2.setText(name2==null?"":name2.toString());
      fieldsGuiPanel.txtOld.setText(old==null?"":old.toString());
      fieldsGuiPanel.cmboPay.setSelectedItem(payterm==null?"":payterm.toString());
      fieldsGuiPanel.txtPerson.setText(contact_person==null?"":contact_person.toString());
      fieldsGuiPanel.cmboPrice.setSelectedItem(pricerterm==null?"":pricerterm.toString());
      fieldsGuiPanel.txtSewingCode.setText(sewing_shop_code==null?"":sewing_shop_code.toString());
      fieldsGuiPanel.txtTel1.setText(tel1==null?"":tel1.toString());
      fieldsGuiPanel.txtTel2.setText(tel2==null?"":tel2.toString());
      fieldsGuiPanel.txtWarehouse.setText(warehouse==null?"":warehouse.toString());
      fieldsGuiPanel.txtWeb.setText(website==null?"":website.toString());
      fieldsGuiPanel.txtShipStaffUsrCode.setText((shipStaffUsrCode==null)?"":shipStaffUsrCode.toString());
      exgui2.Stuff.getRadioButtonYesOrNo(
          fieldsGuiPanel.rb_Y,fieldsGuiPanel.rb_N,check_div==null?"":check_div.toString());
      fieldsGuiPanel.txtAreaAudit.setText(compliance_audit==null?"":compliance_audit.toString());
      //fieldsGuiPanel.cmboMasCo.setSelectedItem(master_co==null?"":master_co.toString());
      fieldsGuiPanel.slkChzBuyer.init("",recDetail.get("BYMKR_MASTER_COMPANY"),
                                      fieldsGuiPanel.slkChzBuyer.TYPE_BUYER,true);
                                  String forBlf=
                                      (String)recDetail.get("FOR_BEHALF");
      fieldsGuiPanel.txt4Behalf.setText((forBlf==null)?"":forBlf);
      fieldsGuiPanel.makeCenterSelections((String)recDetail.get("SELECTABLE_CENTER"));
      fieldsGuiPanel.txtBYMKR_HK_CODE.setText((hkCode==null)?"":hkCode.toString());
    } catch (Exception e) {
      e.printStackTrace();
      util.ExceptionLog.exp2File(e, "error at set datas to fields."+recDetail.toString());
    }
  }
}
