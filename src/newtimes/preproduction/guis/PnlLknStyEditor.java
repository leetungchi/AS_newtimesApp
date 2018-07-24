package newtimes.preproduction.guis;

import java.awt.*;
import javax.swing.*;
import exgui.*;
import javax.swing.border.*;
import newtimes.preproduction.buyermakerselect.*;
import java.awt.Cursor.*;
/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class PnlLknStyEditor
  //extends JPanel {
  extends processhandler.template.PnlFieldsEditor {
  BorderLayout borderLayout1 = new BorderLayout();
  JPanel jPanel1 = new JPanel();
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel1 = new BlueBkgWhiteCharLabel();
  JLabel blueBkgWhiteCharLabel2 = new JLabel();
  JTextField txtStyNo = new JTextField();
  JTextField txtPoNo = new JTextField();
  JLabel blueBkgWhiteCharLabel3 = new JLabel();
  JTextField txtPrjQty = new JTextField();
  JLabel blueBkgWhiteCharLabel4 = new JLabel();
  JTextField txtPrjDlvy = new JTextField();
  JLabel whiteBkgBlueCharLabel1 = new JLabel();
  JTextField txtCfmQty = new JTextField();
  JLabel whiteBkgBlueCharLabel2 = new JLabel();
  JLabel whiteBkgBlueCharLabel3 = new JLabel();
  JTextField txtCfmDlvy = new JTextField();
  JTextField txtPreDupsRmk = new JTextField();
  JLabel blueBkgWhiteCharLabel5 = new JLabel();
  JPanel subPnlDups = new JPanel();

  TitledBorder titledBorder1;
  JLabel blueBkgWhiteCharLabel6 = new JLabel();
  JLabel blueBkgWhiteCharLabel7 = new JLabel();
  JTextField txtDupMillMtlNo = new JTextField();
  JTextField txtDupsChrgFee = new JTextField();
  JLabel blueBkgWhiteCharLabel8 = new JLabel();
  JTextField txtDupMinQty = new JTextField();
  JLabel blueBkgWhiteCharLabel9 = new JLabel();
  JLabel whiteBkgBlueCharLabel4 = new JLabel();
  JTextField txtDupFnlClrApv = new JTextField();
  JTextField txtDupFnlClrAsst = new JTextField();
  JLabel whiteBkgBlueCharLabel5 = new JLabel();
  JLabel blueBkgWhiteCharLabel10 = new JLabel();
  JTextField txtDupFabPrjQty = new JTextField();
  JLabel blueBkgWhiteCharLabel11 = new JLabel();
  JTextField txtDupFabDlvy = new JTextField();
  JLabel blueBkgWhiteCharLabel12 = new JLabel();
  JTextField txtDupGmtGspDue = new JTextField();
  JTextField txtDupGmtDlvy = new JTextField();
  JLabel blueBkgWhiteCharLabel13 = new JLabel();
  JLabel whiteBkgBlueCharLabel6 = new JLabel();
  JTextField txtDupGmtQty = new JTextField();
  JTextField txtDupPkgNo = new JTextField();
  JLabel whiteBkgBlueCharLabel7 = new JLabel();
  JTextField txtDupLeadTime = new JTextField();
  JLabel whiteBkgBlueCharLabel8 = new JLabel();

  JPanel subPnlPPS = new JPanel();

  TitledBorder titledBorder2;
  JLabel blueBkgWhiteCharLabel111 = new JLabel();
  JTextField txtPpsSpecRcv = new JTextField();
  JLabel blueBkgWhiteCharLabel112 = new JLabel();
  JTextField txtPpsTgtDate = new JTextField();
  JLabel blueBkgWhiteCharLabel113 = new JLabel();
  JTextField txtPpsOrgDlv = new JTextField();
  JTextField txtPpsRvsDlvy = new JTextField();
  JLabel whiteBkgBlueCharLabel14 = new JLabel();
  JLabel whiteBkgBlueCharLabel15 = new JLabel();
  JTextField txtPpsAppvDlvy = new JTextField();
  SelectBuyerMaker slkDupMill = new SelectBuyerMaker();
  Border border1;
  TitledBorder titledBorder3;
  JLabel blueBkgWhiteCharLabel115 = new JLabel();
  JComboBox cbxUnitDups = new JComboBox();
  JTextField txtBulkGmtQty = new JTextField();
  JTextField txtBulkGmtDlvy = new JTextField();
  JComboBox cbxUnitBulk = new JComboBox();
  JTextField txtBulkFnlClrApv = new JTextField();
  JLabel whiteBkgBlueCharLabel12 = new JLabel();
  JLabel whiteBkgBlueCharLabel9 = new JLabel();
  JLabel blueBkgWhiteCharLabel110 = new JLabel();
  JTextField txtBulkFnlClrAsst = new JTextField();
  JLabel blueBkgWhiteCharLabel17 = new JLabel();
  JLabel blueBkgWhiteCharLabel20 = new JLabel();
  JLabel whiteBkgBlueCharLabel11 = new JLabel();
  JTextField txtBulkFabPrjQty = new JTextField();
  JLabel blueBkgWhiteCharLabel19 = new JLabel();
  JLabel blueBkgWhiteCharLabel14 = new JLabel();
  JTextField txtBulkPkgNo = new JTextField();
  JTextField txtBulkFabDlvy = new JTextField();
  JLabel blueBkgWhiteCharLabel114 = new JLabel();
  JLabel blueBkgWhiteCharLabel15 = new JLabel();
  SelectBuyerMaker slkBulkMill = new SelectBuyerMaker();
  JTextField txtBulkGmtGspDue = new JTextField();
  JLabel blueBkgWhiteCharLabel16 = new JLabel();
  JTextField txtBulkMinQty = new JTextField();
  JTextField txtBulkLeadTime = new JTextField();
  JTextField txtBulkMillMtlNo = new JTextField();
  JTextField txtBulkChrgFee = new JTextField();
  JPanel subPnlBulk = new JPanel();
  JLabel whiteBkgBlueCharLabel13 = new JLabel();
  JLabel blueBkgWhiteCharLabel18 = new JLabel();
  JLabel whiteBkgBlueCharLabel10 = new JLabel();

  public PnlLknStyEditor() {
    try {
      jbInit();
      recordColumnsToCopy=null;
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }
  protected  void jbInit() throws Exception {
    titledBorder1 = new TitledBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED,Color.white,Color.white,new Color(103, 101, 98),new Color(148, 145, 140)),"Bulk");
    titledBorder2 = new TitledBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED,Color.white,Color.white,new Color(103, 101, 98),new Color(148, 145, 140)),"PPS");
    border1 = BorderFactory.createBevelBorder(BevelBorder.LOWERED,Color.white,Color.white,new Color(103, 101, 98),new Color(148, 145, 140));
    titledBorder3 = new TitledBorder(border1,"Dups");
    this.setLayout(borderLayout1);
    jPanel1.setBackground(new Color(204, 204, 225));
    subPnlDups.setBackground(new Color(204, 204, 225));
    subPnlPPS.setBackground(new Color(204, 204, 225));

    jPanel1.setLayout(null);
    blueBkgWhiteCharLabel1.setText("Lock In Style");
    blueBkgWhiteCharLabel1.setBounds(new Rectangle(-1, 14, 795, 31));
    blueBkgWhiteCharLabel2.setText("Style No");
    blueBkgWhiteCharLabel2.setBounds(new Rectangle(36, 72, 103, 22));
    txtStyNo.setText("");
    txtStyNo.setBounds(new Rectangle(138, 72, 97, 22));
    txtPoNo.setBounds(new Rectangle(368, 74, 97, 22));
    txtPoNo.setText("");
    blueBkgWhiteCharLabel3.setBounds(new Rectangle(261, 74, 108, 22));
    blueBkgWhiteCharLabel3.setText("PO No");
    txtPrjQty.setText("");
    txtPrjQty.setBounds(new Rectangle(608, 73, 97, 22));
    blueBkgWhiteCharLabel4.setText("Project Qty");
    blueBkgWhiteCharLabel4.setBounds(new Rectangle(501, 73, 108, 22));
    txtPrjDlvy.setBounds(new Rectangle(137, 110, 97, 22));
    txtPrjDlvy.setText("");
    whiteBkgBlueCharLabel1.setText("Project Delivery");
    whiteBkgBlueCharLabel1.setBounds(new Rectangle(35, 110, 106, 20));
    txtCfmQty.setText("");
    txtCfmQty.setBounds(new Rectangle(366, 110, 97, 22));
    whiteBkgBlueCharLabel2.setBounds(new Rectangle(260, 110, 106, 20));
    whiteBkgBlueCharLabel2.setText("Confirm Qty");
    whiteBkgBlueCharLabel3.setText("Confirm Delivery");
    whiteBkgBlueCharLabel3.setBounds(new Rectangle(503, 112, 106, 20));
    txtCfmDlvy.setBounds(new Rectangle(609, 112, 97, 22));
    txtCfmDlvy.setText("");
    txtPreDupsRmk.setBounds(new Rectangle(136, 143, 327, 22));
    txtPreDupsRmk.setText("");
    blueBkgWhiteCharLabel5.setBounds(new Rectangle(34, 145, 159, 22));
    blueBkgWhiteCharLabel5.setText("Pre-Dups Remark");
    subPnlDups.setBorder(titledBorder3);
    subPnlDups.setBounds(new Rectangle(27, 181, 714, 174));
    subPnlDups.setLayout(null);
    blueBkgWhiteCharLabel6.setBounds(new Rectangle(7, 19, 53, 22));
    blueBkgWhiteCharLabel6.setText("Mill");
    blueBkgWhiteCharLabel7.setText("Mill Material No");
    blueBkgWhiteCharLabel7.setBounds(new Rectangle(238, 19, 108, 22));
    txtDupMillMtlNo.setText("");
    txtDupMillMtlNo.setBounds(new Rectangle(364, 18, 118, 22));
    txtDupsChrgFee.setText("");
    txtDupsChrgFee.setBounds(new Rectangle(590, 16, 97, 22));
    blueBkgWhiteCharLabel8.setText("Dups Charge Fee");
    blueBkgWhiteCharLabel8.setBounds(new Rectangle(493, 17, 102, 22));
    txtDupMinQty.setText("");
    txtDupMinQty.setBounds(new Rectangle(590, 118, 97, 22));
    blueBkgWhiteCharLabel9.setBackground(Color.white);
    blueBkgWhiteCharLabel9.setForeground(Color.black);
    blueBkgWhiteCharLabel9.setText("Min Qty");
    blueBkgWhiteCharLabel9.setBounds(new Rectangle(493, 118, 74, 22));
    whiteBkgBlueCharLabel4.setBounds(new Rectangle(7, 51, 119, 20));
    whiteBkgBlueCharLabel4.setText("Final Color Approval");
    txtDupFnlClrApv.setText("");
    txtDupFnlClrApv.setBounds(new Rectangle(134, 50, 97, 22));
    txtDupFnlClrAsst.setBounds(new Rectangle(364, 50, 118, 22));
    txtDupFnlClrAsst.setText("");
    whiteBkgBlueCharLabel5.setText("Final Color Assorted");
    whiteBkgBlueCharLabel5.setBounds(new Rectangle(238, 47, 119, 31));
    blueBkgWhiteCharLabel10.setBounds(new Rectangle(6, 89, 108, 22));
    blueBkgWhiteCharLabel10.setText("FAB Project Qty");
    txtDupFabPrjQty.setBounds(new Rectangle(134, 89, 97, 22));
    txtDupFabPrjQty.setText("");
    blueBkgWhiteCharLabel11.setText("FAB Delivery");
    blueBkgWhiteCharLabel11.setBounds(new Rectangle(238, 90, 79, 22));
    txtDupFabDlvy.setText("");
    txtDupFabDlvy.setBounds(new Rectangle(364, 89, 118, 22));
    blueBkgWhiteCharLabel12.setBounds(new Rectangle(493, 89, 82, 22));
    blueBkgWhiteCharLabel12.setText("GMT GSP Due");
    txtDupGmtGspDue.setBounds(new Rectangle(590, 89, 97, 22));
    txtDupGmtGspDue.setText("");
    txtDupGmtDlvy.setText("");
    txtDupGmtDlvy.setBounds(new Rectangle(113, 144, 118, 22));
    blueBkgWhiteCharLabel13.setText("GMT Delivery");
    blueBkgWhiteCharLabel13.setBounds(new Rectangle(5, 144, 79, 22));
    whiteBkgBlueCharLabel6.setText("GMT Qty");
    whiteBkgBlueCharLabel6.setBounds(new Rectangle(6, 116, 106, 20));
    txtDupGmtQty.setBounds(new Rectangle(134, 117, 97, 22));
    txtDupGmtQty.setText("");
    txtDupPkgNo.setText("");
    txtDupPkgNo.setBounds(new Rectangle(364, 116, 118, 22));
    whiteBkgBlueCharLabel7.setBounds(new Rectangle(238, 118, 51, 20));
    whiteBkgBlueCharLabel7.setText("PKG No");
    txtDupLeadTime.setText("");
    txtDupLeadTime.setBounds(new Rectangle(590, 50, 97, 22));
    whiteBkgBlueCharLabel8.setBounds(new Rectangle(493, 50, 67, 20));
    whiteBkgBlueCharLabel8.setText("Lead Time");
    subPnlPPS.setBorder(titledBorder2);
    subPnlPPS.setBounds(new Rectangle(27, 543, 714, 82));
    subPnlPPS.setLayout(null);
    blueBkgWhiteCharLabel111.setText("Spec Recieved");
    blueBkgWhiteCharLabel111.setBounds(new Rectangle(10, 22, 108, 22));
    txtPpsSpecRcv.setText("");
    txtPpsSpecRcv.setBounds(new Rectangle(115, 22, 97, 22));
    blueBkgWhiteCharLabel112.setText("Target Date");
    blueBkgWhiteCharLabel112.setBounds(new Rectangle(228, 22, 69, 22));
    txtPpsTgtDate.setText("");
    txtPpsTgtDate.setBounds(new Rectangle(333, 22, 97, 22));
    blueBkgWhiteCharLabel113.setBounds(new Rectangle(448, 22, 96, 22));
    blueBkgWhiteCharLabel113.setText("Original Delivery");
    txtPpsOrgDlv.setBounds(new Rectangle(546, 22, 97, 22));
    txtPpsOrgDlv.setText("");
    txtPpsRvsDlvy.setBounds(new Rectangle(114, 51, 97, 22));
    txtPpsRvsDlvy.setText("");
    whiteBkgBlueCharLabel14.setText("ReVised Delivery");
    whiteBkgBlueCharLabel14.setBounds(new Rectangle(10, 51, 103, 20));
    whiteBkgBlueCharLabel15.setBounds(new Rectangle(227, 49, 103, 20));
    whiteBkgBlueCharLabel15.setText("Approval Delivery");
    txtPpsAppvDlvy.setText("");
    txtPpsAppvDlvy.setBounds(new Rectangle(332, 49, 95, 21));
    slkDupMill.setBounds(new Rectangle(70, 19, 161, 21));
    blueBkgWhiteCharLabel115.setBounds(new Rectangle(238, 144, 76, 22));
    blueBkgWhiteCharLabel115.setBackground(Color.white);
    blueBkgWhiteCharLabel115.setForeground(Color.black);
    blueBkgWhiteCharLabel115.setText("UNIT");
    cbxUnitDups.setBounds(new Rectangle(364, 144, 118, 21));
    txtBulkGmtQty.setText("");
    txtBulkGmtQty.setBounds(new Rectangle(123, 123, 97, 22));
    txtBulkGmtDlvy.setBounds(new Rectangle(104, 152, 116, 22));
    txtBulkGmtDlvy.setText("");
    cbxUnitBulk.setBounds(new Rectangle(364, 152, 114, 22));
    txtBulkFnlClrApv.setBounds(new Rectangle(123, 55, 97, 22));
    txtBulkFnlClrApv.setText("");
    whiteBkgBlueCharLabel12.setText("PKG No");
    whiteBkgBlueCharLabel12.setBounds(new Rectangle(238, 123, 51, 20));
    whiteBkgBlueCharLabel9.setBounds(new Rectangle(238, 52, 115, 24));
    whiteBkgBlueCharLabel9.setText("Final Color Assorted");
    blueBkgWhiteCharLabel110.setBounds(new Rectangle(5, 152, 80, 22));
    blueBkgWhiteCharLabel110.setText("GMT Delivery");
    txtBulkFnlClrAsst.setText("");
    txtBulkFnlClrAsst.setBounds(new Rectangle(364, 52, 117, 22));
    blueBkgWhiteCharLabel17.setText("GMT GSP Due");
    blueBkgWhiteCharLabel17.setBounds(new Rectangle(492, 93, 79, 22));
    blueBkgWhiteCharLabel20.setBounds(new Rectangle(238, 19, 88, 17));
    blueBkgWhiteCharLabel20.setText("Mill Material No");
    whiteBkgBlueCharLabel11.setText("Final Color Approval");
    whiteBkgBlueCharLabel11.setBounds(new Rectangle(7, 51, 115, 20));
    txtBulkFabPrjQty.setText("");
    txtBulkFabPrjQty.setBounds(new Rectangle(123, 92, 97, 22));
    blueBkgWhiteCharLabel19.setBounds(new Rectangle(492, 123, 74, 22));
    blueBkgWhiteCharLabel19.setBackground(Color.white);
    blueBkgWhiteCharLabel19.setForeground(Color.black);
    blueBkgWhiteCharLabel19.setText("Min Qty");
    blueBkgWhiteCharLabel14.setBounds(new Rectangle(238, 92, 73, 22));
    blueBkgWhiteCharLabel14.setText("FAB Delivery");
    txtBulkPkgNo.setBounds(new Rectangle(364, 123, 117, 22));
    txtBulkPkgNo.setText("");
    txtBulkFabDlvy.setBounds(new Rectangle(364, 92, 117, 22));
    txtBulkFabDlvy.setText("");
    blueBkgWhiteCharLabel114.setText("UNIT");
    blueBkgWhiteCharLabel114.setBackground(Color.white);
    blueBkgWhiteCharLabel114.setForeground(Color.black);
    blueBkgWhiteCharLabel114.setBounds(new Rectangle(238, 152, 60, 22));
    blueBkgWhiteCharLabel15.setBounds(new Rectangle(492, 21, 95, 22));
    blueBkgWhiteCharLabel15.setText("Bulk Charge Fee");
    slkBulkMill.setBounds(new Rectangle(54, 19, 166, 21));
    txtBulkGmtGspDue.setText("");
    txtBulkGmtGspDue.setBounds(new Rectangle(589, 93, 97, 22));
    blueBkgWhiteCharLabel16.setText("FAB Project Qty");
    blueBkgWhiteCharLabel16.setBounds(new Rectangle(5, 92, 108, 22));
    txtBulkMinQty.setBounds(new Rectangle(589, 123, 97, 22));
    txtBulkMinQty.setText("");
    txtBulkLeadTime.setBounds(new Rectangle(589, 52, 97, 22));
    txtBulkLeadTime.setText("");
    txtBulkMillMtlNo.setBounds(new Rectangle(364, 19, 117, 22));
    txtBulkMillMtlNo.setText("");
    txtBulkChrgFee.setBounds(new Rectangle(589, 20, 97, 22));
    txtBulkChrgFee.setText("");
    subPnlBulk.setBackground(new Color(204, 204, 225));
    subPnlBulk.setLayout(null);
    subPnlBulk.setBounds(new Rectangle(27, 355, 714, 189));
    subPnlBulk.setBorder(titledBorder1);
    whiteBkgBlueCharLabel13.setBounds(new Rectangle(5, 123, 106, 20));
    whiteBkgBlueCharLabel13.setText("GMT Qty");
    blueBkgWhiteCharLabel18.setText("Mill");
    blueBkgWhiteCharLabel18.setBounds(new Rectangle(7, 19, 46, 22));
    whiteBkgBlueCharLabel10.setText("Lead Time");
    whiteBkgBlueCharLabel10.setBounds(new Rectangle(492, 53, 63, 20));
    this.add(jPanel1, BorderLayout.CENTER);
    subPnlDups.add(blueBkgWhiteCharLabel6, null);
    subPnlDups.add(whiteBkgBlueCharLabel6, null);
    subPnlDups.add(txtDupPkgNo, null);
    subPnlDups.add(whiteBkgBlueCharLabel4, null);
    subPnlDups.add(blueBkgWhiteCharLabel7, null);
    subPnlDups.add(slkDupMill, null);
    subPnlDups.add(blueBkgWhiteCharLabel9, null);
    subPnlDups.add(txtDupMinQty, null);
    subPnlDups.add(txtDupMillMtlNo, null);
    subPnlDups.add(blueBkgWhiteCharLabel8, null);
    subPnlDups.add(txtDupsChrgFee, null);
    subPnlDups.add(blueBkgWhiteCharLabel10, null);
    subPnlDups.add(txtDupFabDlvy, null);
    subPnlDups.add(blueBkgWhiteCharLabel12, null);
    subPnlDups.add(txtDupGmtGspDue, null);
    subPnlDups.add(blueBkgWhiteCharLabel13, null);
    subPnlDups.add(txtDupGmtDlvy, null);
    subPnlDups.add(cbxUnitDups, null);
    subPnlDups.add(blueBkgWhiteCharLabel115, null);
    subPnlDups.add(blueBkgWhiteCharLabel11, null);
    subPnlDups.add(whiteBkgBlueCharLabel7, null);
    subPnlDups.add(txtDupFabPrjQty, null);
    subPnlDups.add(txtDupGmtQty, null);
    subPnlDups.add(txtDupFnlClrApv, null);
    subPnlDups.add(whiteBkgBlueCharLabel5, null);
    subPnlDups.add(txtDupFnlClrAsst, null);
    subPnlDups.add(whiteBkgBlueCharLabel8, null);
    subPnlDups.add(txtDupLeadTime, null);
    jPanel1.add(blueBkgWhiteCharLabel2, null);
    jPanel1.add(txtStyNo, null);
    jPanel1.add(blueBkgWhiteCharLabel3, null);
    jPanel1.add(txtPoNo, null);
    jPanel1.add(blueBkgWhiteCharLabel4, null);
    jPanel1.add(whiteBkgBlueCharLabel1, null);
    jPanel1.add(txtPrjDlvy, null);
    jPanel1.add(whiteBkgBlueCharLabel2, null);
    jPanel1.add(txtCfmQty, null);
    jPanel1.add(whiteBkgBlueCharLabel3, null);
    jPanel1.add(blueBkgWhiteCharLabel5, null);
    jPanel1.add(txtPreDupsRmk, null);
    jPanel1.add(txtPrjQty, null);
    jPanel1.add(txtCfmDlvy, null);
    jPanel1.add(subPnlBulk, null);
    subPnlPPS.add(txtPpsSpecRcv, null);
    subPnlPPS.add(blueBkgWhiteCharLabel111, null);
    subPnlPPS.add(blueBkgWhiteCharLabel112, null);
    subPnlPPS.add(txtPpsTgtDate, null);
    subPnlPPS.add(blueBkgWhiteCharLabel113, null);
    subPnlPPS.add(txtPpsOrgDlv, null);
    subPnlPPS.add(whiteBkgBlueCharLabel14, null);
    subPnlPPS.add(txtPpsRvsDlvy, null);
    subPnlPPS.add(whiteBkgBlueCharLabel15, null);
    subPnlPPS.add(txtPpsAppvDlvy, null);
    jPanel1.add(blueBkgWhiteCharLabel1, null);
    jPanel1.add(subPnlDups, null);
    subPnlBulk.add(blueBkgWhiteCharLabel18, null);
    subPnlBulk.add(whiteBkgBlueCharLabel11, null);
    subPnlBulk.add(slkBulkMill, null);
    subPnlBulk.add(txtBulkChrgFee, null);
    subPnlBulk.add(blueBkgWhiteCharLabel15, null);
    subPnlBulk.add(txtBulkFnlClrAsst, null);
    subPnlBulk.add(blueBkgWhiteCharLabel16, null);
    subPnlBulk.add(blueBkgWhiteCharLabel14, null);
    subPnlBulk.add(txtBulkFabDlvy, null);
    subPnlBulk.add(whiteBkgBlueCharLabel13, null);
    subPnlBulk.add(whiteBkgBlueCharLabel12, null);
    subPnlBulk.add(txtBulkPkgNo, null);
    subPnlBulk.add(blueBkgWhiteCharLabel17, null);
    subPnlBulk.add(txtBulkGmtGspDue, null);
    subPnlBulk.add(blueBkgWhiteCharLabel19, null);
    subPnlBulk.add(txtBulkMinQty, null);
    subPnlBulk.add(blueBkgWhiteCharLabel110, null);
    subPnlBulk.add(txtBulkGmtDlvy, null);
    subPnlBulk.add(blueBkgWhiteCharLabel114, null);
    subPnlBulk.add(cbxUnitBulk, null);
    subPnlBulk.add(txtBulkFnlClrApv, null);
    subPnlBulk.add(txtBulkFabPrjQty, null);
    subPnlBulk.add(txtBulkGmtQty, null);
    subPnlBulk.add(whiteBkgBlueCharLabel9, null);
    subPnlBulk.add(txtBulkLeadTime, null);
    subPnlBulk.add(whiteBkgBlueCharLabel10, null);
    subPnlBulk.add(txtBulkMillMtlNo, null);
    subPnlBulk.add(blueBkgWhiteCharLabel20, null);
    jPanel1.add(subPnlPPS, null);
    subPnlBulk.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
    subPnlDups.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
  }

  public void record2Gui(){

   try{

     if(recToMapping.get(0)==null){
       blueBkgWhiteCharLabel1.setText("Add A Lock In Style");
     }else{
       blueBkgWhiteCharLabel1.setText("Lock In Style Edit");
     }
     dataBoundGUIs.clear();

     slkBulkMill.init("LOCKIN_STYLE_BULK_MILL",recToMapping.get("LOCKIN_STYLE_BULK_MILL"),
                      slkBulkMill.TYPE_MAKER,true);
     dataBoundGUIs.add(slkBulkMill);

     slkDupMill.init("LOCKIN_STYLE_DUPS_MILL",recToMapping.get("LOCKIN_STYLE_DUPS_MILL"),
                      slkBulkMill.TYPE_MAKER,true);
      dataBoundGUIs.add(slkDupMill);

     Object vftxtDupMillMtlNo=exgui.verification.CellFormat.getOrdinaryField(40);
      dataBoundGUIs.add(  new exgui.DataBindTextWithChecker(txtDupMillMtlNo,"LOCKIN_STYLE_DUPS_MILL_MTR",recToMapping.get("LOCKIN_STYLE_DUPS_MILL_MTR"),40,(exgui.Object2String)vftxtDupMillMtlNo,(exgui.ultratable.CellTxtEditorFormat)vftxtDupMillMtlNo)
     );

     Object vftxtBulkMillMtlNo=exgui.verification.CellFormat.getOrdinaryField(40);
      dataBoundGUIs.add(  new exgui.DataBindTextWithChecker(txtBulkMillMtlNo,"LOCKIN_STYLE_BULK_MTR",recToMapping.get("LOCKIN_STYLE_BULK_MTR"),40,(exgui.Object2String)vftxtBulkMillMtlNo,(exgui.ultratable.CellTxtEditorFormat)vftxtBulkMillMtlNo)
     );

     Object vftxtStyNo=exgui.verification.CellFormat.getOrdinaryField(25);
      dataBoundGUIs.add(  new exgui.DataBindTextWithChecker(txtStyNo,"LOCKIN_STYLE_NO",recToMapping.get("LOCKIN_STYLE_NO"),25,(exgui.Object2String)vftxtStyNo,(exgui.ultratable.CellTxtEditorFormat)vftxtStyNo)
     );
     Object vftxtPoNo=exgui.verification.CellFormat.getOrdinaryField(20);
      dataBoundGUIs.add(  new exgui.DataBindTextWithChecker(txtPoNo,"LOCKIN_STYLE_PO",recToMapping.get("LOCKIN_STYLE_PO"),20,(exgui.Object2String)vftxtPoNo,(exgui.ultratable.CellTxtEditorFormat)vftxtPoNo)
     );
     Object vftxtPrjQty=exgui.verification.CellFormat.getDoubleFormatAllowNull(7,2);
      dataBoundGUIs.add(  new exgui.DataBindTextWithChecker(txtPrjQty,"LOCKIN_STYLE_PROJECT_QTY",recToMapping.get("LOCKIN_STYLE_PROJECT_QTY"),10,(exgui.Object2String)vftxtPrjQty,(exgui.ultratable.CellTxtEditorFormat)vftxtPrjQty)
     );
     Object vftxtPrjDlvy=exgui.verification.CellFormat.getDateStringFormaterAllowNull();
      dataBoundGUIs.add(  new exgui.DataBindTextWithChecker(txtPrjDlvy,"LOCKIN_STYLE_PROJECT_DEL",recToMapping.get("LOCKIN_STYLE_PROJECT_DEL"),10,(exgui.Object2String)vftxtPrjDlvy,(exgui.ultratable.CellTxtEditorFormat)vftxtPrjDlvy)
     );
     Object vftxtCfmQty=exgui.verification.CellFormat.getDoubleFormatAllowNull(7,2);
      dataBoundGUIs.add(  new exgui.DataBindTextWithChecker(txtCfmQty,"LOCKIN_STYLE_CONFIRM_QTY",recToMapping.get("LOCKIN_STYLE_CONFIRM_QTY"),10,(exgui.Object2String)vftxtCfmQty,(exgui.ultratable.CellTxtEditorFormat)vftxtCfmQty)
     );
     Object vftxtCfmDlvy=exgui.verification.CellFormat.getDateStringFormaterAllowNull();
      dataBoundGUIs.add(  new exgui.DataBindTextWithChecker(txtCfmDlvy,"LOCKIN_STYLE_CONFIRM_DEL",recToMapping.get("LOCKIN_STYLE_CONFIRM_DEL"),10,(exgui.Object2String)vftxtCfmDlvy,(exgui.ultratable.CellTxtEditorFormat)vftxtCfmDlvy)
     );
     Object vftxtPreDupsRmk=exgui.verification.CellFormat.getOrdinaryField(200);
      dataBoundGUIs.add(  new exgui.DataBindTextWithChecker(txtPreDupsRmk,"LOCKIN_STYLE_PRE_DUPS_REMARK",recToMapping.get("LOCKIN_STYLE_PRE_DUPS_REMARK"),200,(exgui.Object2String)vftxtPreDupsRmk,(exgui.ultratable.CellTxtEditorFormat)vftxtPreDupsRmk)
     );
     Object vftxtDupsChrgFee=exgui.verification.CellFormat.getIntVerifierAllowNull(5);
      dataBoundGUIs.add(  new exgui.DataBindTextWithChecker(txtDupsChrgFee,"LOCKIN_STYLE_DUPS_SUR_CHRG",recToMapping.get("LOCKIN_STYLE_DUPS_SUR_CHRG"),5,(exgui.Object2String)vftxtDupsChrgFee,(exgui.ultratable.CellTxtEditorFormat)vftxtDupsChrgFee)
     );
     Object vftxtDupMinQty=exgui.verification.CellFormat.getIntVerifierAllowNull(6);
      dataBoundGUIs.add(  new exgui.DataBindTextWithChecker(txtDupMinQty,"LOCKIN_STYLE_DUPS_MIN_QTY",recToMapping.get("LOCKIN_STYLE_DUPS_MIN_QTY"),6,(exgui.Object2String)vftxtDupMinQty,(exgui.ultratable.CellTxtEditorFormat)vftxtDupMinQty)
     );
     Object vftxtDupLeadTime=exgui.verification.CellFormat.getIntVerifierAllowNull(4);
      dataBoundGUIs.add(  new exgui.DataBindTextWithChecker(txtDupLeadTime,"LOCKIN_STYLE_DUPS_LEAD_TIME",recToMapping.get("LOCKIN_STYLE_DUPS_LEAD_TIME"),4,(exgui.Object2String)vftxtDupLeadTime,(exgui.ultratable.CellTxtEditorFormat)vftxtDupLeadTime)
     );
     Object vftxtDupFnlClrApv=exgui.verification.CellFormat.getDateStringFormaterAllowNull();
      dataBoundGUIs.add(  new exgui.DataBindTextWithChecker(txtDupFnlClrApv,"LOCKIN_STYLE_DUPS_FNL_CLR_APRV",recToMapping.get("LOCKIN_STYLE_DUPS_FNL_CLR_APRV"),10,(exgui.Object2String)vftxtDupFnlClrApv,(exgui.ultratable.CellTxtEditorFormat)vftxtDupFnlClrApv)
     );
     Object vftxtDupFnlClrAsst=exgui.verification.CellFormat.getDateStringFormaterAllowNull();
      dataBoundGUIs.add(  new exgui.DataBindTextWithChecker(txtDupFnlClrAsst,"LOCKIN_STYLE_DUPS_FNL_CLR_ASST",recToMapping.get("LOCKIN_STYLE_DUPS_FNL_CLR_ASST"),10,(exgui.Object2String)vftxtDupFnlClrAsst,(exgui.ultratable.CellTxtEditorFormat)vftxtDupFnlClrAsst)
     );
     Object vftxtDupFabPrjQty=exgui.verification.CellFormat.getIntVerifierAllowNull(6);
      dataBoundGUIs.add(  new exgui.DataBindTextWithChecker(txtDupFabPrjQty,"LOCKIN_STYLE_DUPS_FAB_PROJ",recToMapping.get("LOCKIN_STYLE_DUPS_FAB_PROJ"),6,(exgui.Object2String)vftxtDupFabPrjQty,(exgui.ultratable.CellTxtEditorFormat)vftxtDupFabPrjQty)
     );
     Object vftxtDupFabDlvy=exgui.verification.CellFormat.getDateStringFormaterAllowNull();
      dataBoundGUIs.add(  new exgui.DataBindTextWithChecker(txtDupFabDlvy,"LOCKIN_STYLE_DUPS_FAB_DEL",recToMapping.get("LOCKIN_STYLE_DUPS_FAB_DEL"),10,(exgui.Object2String)vftxtDupFabDlvy,(exgui.ultratable.CellTxtEditorFormat)vftxtDupFabDlvy)
     );
     Object vftxtDupGmtGspDue=exgui.verification.CellFormat.getDateStringFormaterAllowNull();
      dataBoundGUIs.add(  new exgui.DataBindTextWithChecker(txtDupGmtGspDue,"LOCKIN_STYLE_DUPS_GSP_DUE",recToMapping.get("LOCKIN_STYLE_DUPS_GSP_DUE"),10,(exgui.Object2String)vftxtDupGmtGspDue,(exgui.ultratable.CellTxtEditorFormat)vftxtDupGmtGspDue)
     );
     Object vftxtDupGmtDlvy=exgui.verification.CellFormat.getDateStringFormaterAllowNull();
      dataBoundGUIs.add(  new exgui.DataBindTextWithChecker(txtDupGmtDlvy,"LOCKIN_STYLE_DUPS_GMT_DEL",recToMapping.get("LOCKIN_STYLE_DUPS_GMT_DEL"),10,(exgui.Object2String)vftxtDupGmtDlvy,(exgui.ultratable.CellTxtEditorFormat)vftxtDupGmtDlvy)
     );
     Object vftxtDupGmtQty=exgui.verification.CellFormat.getIntVerifierAllowNull(6);
      dataBoundGUIs.add(  new exgui.DataBindTextWithChecker(txtDupGmtQty,"LOCKIN_STYLE_DUPS_GMT_QTY",recToMapping.get("LOCKIN_STYLE_DUPS_GMT_QTY"),6,(exgui.Object2String)vftxtDupGmtQty,(exgui.ultratable.CellTxtEditorFormat)vftxtDupGmtQty)
     );
     Object vftxtDupPkgNo=exgui.verification.CellFormat.getOrdinaryField(20);
      dataBoundGUIs.add(  new exgui.DataBindTextWithChecker(txtDupPkgNo,"LOCKIN_STYLE_DUPS_PKG_AWB",recToMapping.get("LOCKIN_STYLE_DUPS_PKG_AWB"),20,(exgui.Object2String)vftxtDupPkgNo,(exgui.ultratable.CellTxtEditorFormat)vftxtDupPkgNo)
     );
     Object vftxtBulkChrgFee=exgui.verification.CellFormat.getIntVerifierAllowNull(5);
      dataBoundGUIs.add(  new exgui.DataBindTextWithChecker(txtBulkChrgFee,"LOCKIN_STYLE_BULK_SUR_CHRG",recToMapping.get("LOCKIN_STYLE_BULK_SUR_CHRG"),5,(exgui.Object2String)vftxtBulkChrgFee,(exgui.ultratable.CellTxtEditorFormat)vftxtBulkChrgFee)
     );
     Object vftxtBulkMinQty=exgui.verification.CellFormat.getIntVerifierAllowNull(6);
      dataBoundGUIs.add(  new exgui.DataBindTextWithChecker(txtBulkMinQty,"LOCKIN_STYLE_BULK_MIN_QTY",recToMapping.get("LOCKIN_STYLE_BULK_MIN_QTY"),6,(exgui.Object2String)vftxtBulkMinQty,(exgui.ultratable.CellTxtEditorFormat)vftxtBulkMinQty)
     );
     Object vftxtBulkLeadTime=exgui.verification.CellFormat.getIntVerifierAllowNull(4);
      dataBoundGUIs.add(  new exgui.DataBindTextWithChecker(txtBulkLeadTime,"LOCKIN_STYLE_BULK_LEAD_TIME",recToMapping.get("LOCKIN_STYLE_BULK_LEAD_TIME"),4,(exgui.Object2String)vftxtBulkLeadTime,(exgui.ultratable.CellTxtEditorFormat)vftxtBulkLeadTime)
     );
     Object vftxtBulkFnlClrApv=exgui.verification.CellFormat.getDateStringFormaterAllowNull();
      dataBoundGUIs.add(  new exgui.DataBindTextWithChecker(txtBulkFnlClrApv,"LOCKIN_STYLE_BULK_FNL_CLR_APRV",recToMapping.get("LOCKIN_STYLE_BULK_FNL_CLR_APRV"),10,(exgui.Object2String)vftxtBulkFnlClrApv,(exgui.ultratable.CellTxtEditorFormat)vftxtBulkFnlClrApv)
     );
     Object vftxtBulkFnlClrAsst=exgui.verification.CellFormat.getDateStringFormaterAllowNull();
      dataBoundGUIs.add(  new exgui.DataBindTextWithChecker(txtBulkFnlClrAsst,"LOCKIN_STYLE_BULK_FNL_CLR_ASST",recToMapping.get("LOCKIN_STYLE_BULK_FNL_CLR_ASST"),10,(exgui.Object2String)vftxtBulkFnlClrAsst,(exgui.ultratable.CellTxtEditorFormat)vftxtBulkFnlClrAsst)
     );
     Object vftxtBulkFabPrjQty=exgui.verification.CellFormat.getIntVerifierAllowNull(6);
      dataBoundGUIs.add(  new exgui.DataBindTextWithChecker(txtBulkFabPrjQty,"LOCKIN_STYLE_BULK_FAB_PROJ",recToMapping.get("LOCKIN_STYLE_BULK_FAB_PROJ"),6,(exgui.Object2String)vftxtBulkFabPrjQty,(exgui.ultratable.CellTxtEditorFormat)vftxtBulkFabPrjQty)
     );
     Object vftxtBulkFabDlvy=exgui.verification.CellFormat.getDateStringFormaterAllowNull();
      dataBoundGUIs.add(  new exgui.DataBindTextWithChecker(txtBulkFabDlvy,"LOCKIN_STYLE_BULK_FAB_DEL",recToMapping.get("LOCKIN_STYLE_BULK_FAB_DEL"),10,(exgui.Object2String)vftxtBulkFabDlvy,(exgui.ultratable.CellTxtEditorFormat)vftxtBulkFabDlvy)
     );
     Object vftxtBulkGmtGspDue=exgui.verification.CellFormat.getDateStringFormaterAllowNull();
      dataBoundGUIs.add(  new exgui.DataBindTextWithChecker(txtBulkGmtGspDue,"LOCKIN_STYLE_BULK_GSP_DUE",recToMapping.get("LOCKIN_STYLE_BULK_GSP_DUE"),10,(exgui.Object2String)vftxtBulkGmtGspDue,(exgui.ultratable.CellTxtEditorFormat)vftxtBulkGmtGspDue)
     );
     Object vftxtBulkGmtDlvy=exgui.verification.CellFormat.getDateStringFormaterAllowNull();
      dataBoundGUIs.add(  new exgui.DataBindTextWithChecker(txtBulkGmtDlvy,"LOCKIN_STYLE_BULK_GMT_DEL",recToMapping.get("LOCKIN_STYLE_BULK_GMT_DEL"),10,(exgui.Object2String)vftxtBulkGmtDlvy,(exgui.ultratable.CellTxtEditorFormat)vftxtBulkGmtDlvy)
     );
     Object vftxtBulkGmtQty=exgui.verification.CellFormat.getIntVerifierAllowNull(6);
      dataBoundGUIs.add(  new exgui.DataBindTextWithChecker(txtBulkGmtQty,"LOCKIN_STYLE_BULK_GMT_QTY",recToMapping.get("LOCKIN_STYLE_BULK_GMT_QTY"),6,(exgui.Object2String)vftxtBulkGmtQty,(exgui.ultratable.CellTxtEditorFormat)vftxtBulkGmtQty)
     );
     Object vftxtPpsSpecRcv=exgui.verification.CellFormat.getDateStringFormaterAllowNull();
      dataBoundGUIs.add(  new exgui.DataBindTextWithChecker(txtPpsSpecRcv,"LOCKIN_STYLE_PPS_SPEC_DATE",recToMapping.get("LOCKIN_STYLE_PPS_SPEC_DATE"),10,(exgui.Object2String)vftxtPpsSpecRcv,(exgui.ultratable.CellTxtEditorFormat)vftxtPpsSpecRcv)
     );
     Object vftxtPpsTgtDate=exgui.verification.CellFormat.getDateStringFormaterAllowNull();
      dataBoundGUIs.add(  new exgui.DataBindTextWithChecker(txtPpsTgtDate,"LOCKIN_STYLE_PPS_TARGET_DATE",recToMapping.get("LOCKIN_STYLE_PPS_TARGET_DATE"),10,(exgui.Object2String)vftxtPpsTgtDate,(exgui.ultratable.CellTxtEditorFormat)vftxtPpsTgtDate)
     );
     Object vftxtPpsOrgDlv=exgui.verification.CellFormat.getDateStringFormaterAllowNull();
      dataBoundGUIs.add(  new exgui.DataBindTextWithChecker(txtPpsOrgDlv,"LOCKIN_STYLE_PPS_ORIGIN_DEL",recToMapping.get("LOCKIN_STYLE_PPS_ORIGIN_DEL"),10,(exgui.Object2String)vftxtPpsOrgDlv,(exgui.ultratable.CellTxtEditorFormat)vftxtPpsOrgDlv)
     );
     Object vftxtPpsRvsDlvy=exgui.verification.CellFormat.getDateStringFormaterAllowNull();
      dataBoundGUIs.add(  new exgui.DataBindTextWithChecker(txtPpsRvsDlvy,"LOCKIN_STYLE_PPS_REVISED_DEL",recToMapping.get("LOCKIN_STYLE_PPS_REVISED_DEL"),10,(exgui.Object2String)vftxtPpsRvsDlvy,(exgui.ultratable.CellTxtEditorFormat)vftxtPpsRvsDlvy)
     );
     Object vftxtPpsAppvDlvy=exgui.verification.CellFormat.getDateStringFormaterAllowNull();
      dataBoundGUIs.add(  new exgui.DataBindTextWithChecker(txtPpsAppvDlvy,"LOCKIN_STYLE_PPS_APPROVAL_DEL",recToMapping.get("LOCKIN_STYLE_PPS_APPROVAL_DEL"),10,(exgui.Object2String)vftxtPpsAppvDlvy,(exgui.ultratable.CellTxtEditorFormat)vftxtPpsAppvDlvy)
     );
     java.util.Vector tmepRecords=
       newtimes.preproduction.guis.tempProperties.tmpUnits;
         //newtimes.preproduction.process.DB_LockinStyle.getInstanceOfLckSty().getUNITS();
      exgui.DataBindJCombobox DbJcbxcbxUnitDups =
          new exgui.DataBindJCombobox(cbxUnitDups,
                                      "LOCKIN_STYLE_DUPS_UNIT",
                                      tmepRecords,"UNIT","UNIT",
                                      recToMapping.get("LOCKIN_STYLE_DUPS_UNIT"));
      dataBoundGUIs.add(DbJcbxcbxUnitDups);
      exgui.DataBindJCombobox DbJcbxcbxUnitBulk =
          new exgui.DataBindJCombobox(cbxUnitBulk,
                                      "LOCKIN_STYLE_BULK_UNIT",
                                      tmepRecords,"UNIT","UNIT",
                                      recToMapping.get("LOCKIN_STYLE_BULK_UNIT"));
      dataBoundGUIs.add(DbJcbxcbxUnitBulk);

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
  public void doAddNew()throws Exception{
    super.doAddNew();
    //processhandler.template.Properties.getCenteralControler().goBack();
    processhandler.template.Properties.getCenteralControler().doCommandExecute(
       new newtimes.preproduction.process.TgrListLockInStyles());

  }
  public void doDelete(){
    try{
      super.doDelete();
      //processhandler.template.Properties.getCenteralControler().goBack();
      processhandler.template.Properties.getCenteralControler().doCommandExecute(
         new newtimes.preproduction.process.TgrListLockInStyles());
    }catch(Exception e){
      e.printStackTrace();
    }
  }
  public void doUpdate()throws Exception{
     super.doUpdate();
     if(!super.isGui2RecordOk)return;
    //processhandler.template.Properties.getCenteralControler().goBack();
    processhandler.template.Properties.getCenteralControler().doCommandExecute(
       new newtimes.preproduction.process.TgrListLockInStyles());

  }
  public void doPrint(){
  }

}
