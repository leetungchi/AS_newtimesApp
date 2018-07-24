package newtimes.preproduction.guis;

import java.awt.*;
import javax.swing.*;
import exgui.*;
import javax.swing.border.*;
import newtimes.preproduction.buyermakerselect.*;
import java.awt.event.*;
import java.awt.Color;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class PnlColorEditor extends  processhandler.template.PnlFieldsEditor{
 //JPanel {
  BorderLayout borderLayout1 = new BorderLayout();
  JPanel jPanel1 = new JPanel();
  JPanel jPanel2 = new JPanel();
  JLabel whiteBkgBlueCharLabel1 = new JLabel();
  BorderLayout borderLayout2 = new BorderLayout();
  JLabel blueBkgWhiteCharLabel1 = new JLabel();
  JLabel whiteBkgBlueCharLabel2 = new JLabel();
  JLabel blueBkgWhiteCharLabel2 = new JLabel();
  JTextField txtColorCode = new JTextField();
  JLabel blueBkgWhiteCharLabel3 = new JLabel();
  JTextField txtColorName = new JTextField();
  JTextField txtClrGnlRmk = new JTextField();
  JLabel whiteBkgBlueCharLabel3 = new JLabel();
  Border border1;
  JPanel subPnlWoven = new JPanel();

  JTextField txtBulkFABQTY = new JTextField();
  JLabel blueBkgWhiteCharLabel18 = new JLabel();
  JTextField txtPIQty = new JTextField();
  JLabel blueBkgWhiteCharLabel19 = new JLabel();
  JLabel blueBkgWhiteCharLabel110 = new JLabel();
  JTextField txtShipYld = new JTextField();
  JTextField txtDupsFABQty = new JTextField();
  JLabel blueBkgWhiteCharLabel111 = new JLabel();
  JPanel subPnlDups = new JPanel();

  TitledBorder titledBorder1;
  JLabel jLabel4 = new JLabel();
  JTextField txtLDAxlSnd = new JTextField();
  JLabel whiteBkgBlueCharLabel5 = new JLabel();
  JLabel blueBkgWhiteCharLabel5 = new JLabel();
  JLabel whiteBkgBlueCharLabel8 = new JLabel();
  JTextField txtBulkLDAxlApprv = new JTextField();
  JLabel blueBkgWhiteCharLabel11 = new JLabel();
  JTextField txtDupsLotAxlSnd = new JTextField();
  JTextField txtDupsPrice = new JTextField();
  JLabel blueBkgWhiteCharLabel8 = new JLabel();
  JLabel blueBkgWhiteCharLabel10 = new JLabel();
  JLabel whiteBkgBlueCharLabel9 = new JLabel();
  JLabel blueBkgWhiteCharLabel12 = new JLabel();
  JLabel blueBkgWhiteCharLabel6 = new JLabel();
  JLabel blueBkgWhiteCharLabel17 = new JLabel();
  JTextField txtNyQty1 = new JTextField();
  JTextField txtCDAQty2 = new JTextField();
  JTextField txtBulkLotAxlApprv = new JTextField();
  JTextField txtBulkClrApprv = new JTextField();
  JLabel blueBkgWhiteCharLabel14 = new JLabel();
  JTextField txtCDAQty1 = new JTextField();
  JTextField txtNyDlvy2 = new JTextField();
  JLabel whiteBkgBlueCharLabel4 = new JLabel();
  JLabel blueBkgWhiteCharLabel15 = new JLabel();
  JTextField txtBulkLotAxlSnd = new JTextField();
  JLabel blueBkgWhiteCharLabel9 = new JLabel();
  JTextField txtBulkPrice = new JTextField();
  JTextField txtNyQty2 = new JTextField();
  JTextField txtDupsLDAxlApprv = new JTextField();
  JLabel blueBkgWhiteCharLabel7 = new JLabel();
  JLabel blueBkgWhiteCharLabel16 = new JLabel();
  JTextField txtDupsLotAxlApprv = new JTextField();
  JLabel whiteBkgBlueCharLabel7 = new JLabel();
  JTextField txtBristolDlvy = new JTextField();
  JLabel blueBkgWhiteCharLabel13 = new JLabel();
  JTextField txtNyDlvy1 = new JTextField();
  JLabel whiteBkgBlueCharLabel6 = new JLabel();
  JTextField txtDupsClrApprv = new JTextField();
  JTextField txtBristolQty = new JTextField();
  JLabel jLabel5 = new JLabel();
  TitledBorder titledBorder2;
  JPanel subPnlLabDip = new JPanel();

  TitledBorder titledBorder3;
  JTextField txtLabRefNo = new JTextField();
  JLabel blueBkgWhiteCharLabel4 = new JLabel();
  SelectBuyerMaker slkClibDyer = new SelectBuyerMaker();
  JLabel whiteBkgBlueCharLabel10 = new JLabel();
  String lockInSelect[]={"NO","YES"};
  JComboBox cbxLockIn = new JComboBox(lockInSelect);
  SelectSingleMaterialDetail selectSingleMaterialDetail1 = new SelectSingleMaterialDetail();
  JButton btnInsert = new JButton();


  public PnlColorEditor() {
    try {
      jbInit();
      recordColumnsToCopy=null;
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }
  protected void jbInit() throws Exception {
    subPnlWoven.setBackground(new Color(204, 204, 225));
    subPnlDups.setBackground(new Color(204, 204, 225));
    subPnlLabDip.setBackground(new Color(204, 204, 225));
    border1 = BorderFactory.createBevelBorder(BevelBorder.RAISED,Color.white,Color.white,new Color(103, 101, 98),new Color(148, 145, 140));
    titledBorder1 = new TitledBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED,Color.white,Color.white,new Color(103, 101, 98),new Color(148, 145, 140)),"Dups");
    titledBorder2 = new TitledBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED,Color.white,Color.white,new Color(103, 101, 98),new Color(148, 145, 140)),"Woven");
    titledBorder3 = new TitledBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED,Color.white,Color.white,new Color(103, 101, 98),new Color(148, 145, 140)),"Lab Dip");
    this.setPreferredSize(new Dimension(700, 400));
    this.setSize(new Dimension(800, 645));
    this.setRequestFocusEnabled(true);
    this.setLayout(borderLayout1);
    jPanel1.setLayout(borderLayout2);
    jPanel1.setBackground(new Color(204, 204, 225));
    whiteBkgBlueCharLabel1.setText("COLOR");
    whiteBkgBlueCharLabel1.setBounds(new Rectangle(0, 18, 802, 26));
    jPanel2.setLayout(null);
    blueBkgWhiteCharLabel1.setText("Dyer");
    blueBkgWhiteCharLabel1.setBounds(new Rectangle(2, 53, 104, 20));
    whiteBkgBlueCharLabel2.setText("Color Name");
    whiteBkgBlueCharLabel2.setBounds(new Rectangle(3, 85, 100, 21));
    blueBkgWhiteCharLabel2.setBounds(new Rectangle(270, 55, 95, 20));
    blueBkgWhiteCharLabel2.setText("Material Mill No.");
    txtColorCode.setBounds(new Rectangle(636, 56, 97, 21));
    blueBkgWhiteCharLabel3.setBounds(new Rectangle(532, 56, 104, 20));
    blueBkgWhiteCharLabel3.setText("Color Code");
    txtColorName.setBounds(new Rectangle(105, 85, 123, 21));
    txtColorName.setText("jTextField1");
    txtColorName.setText("");
    txtClrGnlRmk.setText("");
    txtClrGnlRmk.setText("");
    txtClrGnlRmk.setBounds(new Rectangle(362, 87, 123, 21));
    whiteBkgBlueCharLabel3.setBounds(new Rectangle(260, 87, 100, 21));
    whiteBkgBlueCharLabel3.setText("General Remark");
    subPnlWoven.setBorder(titledBorder2);
    subPnlWoven.setBounds(new Rectangle(3, 534, 789, 56));
    subPnlWoven.setLayout(null);
    txtBulkFABQTY.setBounds(new Rectangle(705, 24, 68, 21));
    txtBulkFABQTY.setText("");
    blueBkgWhiteCharLabel18.setText("Ship Yeild");
    blueBkgWhiteCharLabel18.setBounds(new Rectangle(223, 24, 88, 20));
    txtPIQty.setBounds(new Rectangle(102, 24, 105, 21));
    txtPIQty.setText("");
    blueBkgWhiteCharLabel19.setText("Dups FAB  Qty");
    blueBkgWhiteCharLabel19.setBounds(new Rectangle(401, 24, 90, 20));
    blueBkgWhiteCharLabel110.setBounds(new Rectangle(12, 24, 90, 20));
    blueBkgWhiteCharLabel110.setText("PI Qty");
    txtShipYld.setText("");
    txtShipYld.setBounds(new Rectangle(309, 24, 81, 21));
    txtDupsFABQty.setText("");
    txtDupsFABQty.setBounds(new Rectangle(491, 24, 88, 21));
    blueBkgWhiteCharLabel111.setBounds(new Rectangle(608, 24, 97, 20));
    blueBkgWhiteCharLabel111.setText("Bulk FAB QTY");
    subPnlDups.setFont(new java.awt.Font("Serif", 1, 11));
    subPnlDups.setBorder(titledBorder1);
    subPnlDups.setBounds(new Rectangle(3, 196, 787, 333));
    subPnlDups.setLayout(null);
    jLabel4.setBounds(new Rectangle(233, 59, 47, 20));
    jLabel4.setText("(USD)");
    jLabel4.setForeground(Color.black);
    jLabel4.setFont(new java.awt.Font("Serif", 1, 12));
    txtLDAxlSnd.setText("");
    txtLDAxlSnd.setText("");
    txtLDAxlSnd.setBounds(new Rectangle(109, 137, 123, 21));
    whiteBkgBlueCharLabel5.setText("Bulk Price");
    whiteBkgBlueCharLabel5.setBounds(new Rectangle(363, 64, 100, 21));
    blueBkgWhiteCharLabel5.setBounds(new Rectangle(6, 25, 133, 20));
    blueBkgWhiteCharLabel5.setText("Dups Color Approval");
    whiteBkgBlueCharLabel8.setBounds(new Rectangle(8, 286, 93, 21));
    whiteBkgBlueCharLabel8.setText("Brstol Qty");
    txtBulkLDAxlApprv.setBounds(new Rectangle(523, 102, 123, 21));
    txtBulkLDAxlApprv.setText("");
    blueBkgWhiteCharLabel11.setBackground(Color.white);
    blueBkgWhiteCharLabel11.setForeground(new Color(143, 143, 188));
    blueBkgWhiteCharLabel11.setText("Bulk Lot Actual Approval");
    blueBkgWhiteCharLabel11.setBounds(new Rectangle(362, 199, 162, 20));
    txtDupsLotAxlSnd.setText("");
    txtDupsLotAxlSnd.setBounds(new Rectangle(140, 168, 123, 21));
    txtDupsPrice.setText("");
    txtDupsPrice.setText("");
    txtDupsPrice.setBounds(new Rectangle(108, 61, 123, 21));
    blueBkgWhiteCharLabel8.setBounds(new Rectangle(365, 102, 160, 20));
    blueBkgWhiteCharLabel8.setText("Bulk LD Actual Approval");
    blueBkgWhiteCharLabel10.setText("Dups Lot Actual Send");
    blueBkgWhiteCharLabel10.setBounds(new Rectangle(7, 168, 133, 20));
    whiteBkgBlueCharLabel9.setText("CDAl Qty1");
    whiteBkgBlueCharLabel9.setBounds(new Rectangle(407, 287, 93, 21));
    blueBkgWhiteCharLabel12.setBounds(new Rectangle(220, 254, 88, 20));
    blueBkgWhiteCharLabel12.setText("NY Delivery");
    blueBkgWhiteCharLabel6.setText("Bulk Color Approval");
    blueBkgWhiteCharLabel6.setBounds(new Rectangle(362, 25, 133, 20));
    blueBkgWhiteCharLabel17.setBackground(Color.white);
    blueBkgWhiteCharLabel17.setForeground(new Color(143, 143, 188));
    blueBkgWhiteCharLabel17.setText("CDA Qty2");
    blueBkgWhiteCharLabel17.setBounds(new Rectangle(577, 287, 88, 20));
    txtNyQty1.setText("");
    txtNyQty1.setBounds(new Rectangle(99, 254, 105, 21));
    txtCDAQty2.setText("");
    txtCDAQty2.setBounds(new Rectangle(664, 286, 78, 21));
    txtBulkLotAxlApprv.setText("");
    txtBulkLotAxlApprv.setBounds(new Rectangle(524, 199, 121, 21));
    txtBulkClrApprv.setText("");
    txtBulkClrApprv.setBounds(new Rectangle(495, 25, 123, 21));
    blueBkgWhiteCharLabel14.setText("NY Delivery2");
    blueBkgWhiteCharLabel14.setBounds(new Rectangle(575, 254, 97, 20));
    txtCDAQty1.setBounds(new Rectangle(499, 287, 74, 21));
    txtCDAQty1.setText("");
    txtCDAQty1.setText("");
    txtNyDlvy2.setText("");
    txtNyDlvy2.setBounds(new Rectangle(671, 254, 68, 21));
    whiteBkgBlueCharLabel4.setBounds(new Rectangle(6, 61, 100, 21));
    whiteBkgBlueCharLabel4.setText("Dups Price");
    blueBkgWhiteCharLabel15.setBounds(new Rectangle(408, 254, 90, 20));
    blueBkgWhiteCharLabel15.setText("NY Qty2");
    txtBulkLotAxlSnd.setBounds(new Rectangle(145, 198, 123, 21));
    txtBulkLotAxlSnd.setText("");
    txtBulkLotAxlSnd.setText("");
    blueBkgWhiteCharLabel9.setBounds(new Rectangle(363, 168, 162, 20));
    blueBkgWhiteCharLabel9.setText("Dups Lot Actual Approval");
    txtBulkPrice.setBounds(new Rectangle(465, 64, 123, 21));
    txtBulkPrice.setText("");
    txtBulkPrice.setText("");
    txtNyQty2.setBounds(new Rectangle(498, 254, 72, 21));
    txtNyQty2.setText("");
    txtDupsLDAxlApprv.setText("");
    txtDupsLDAxlApprv.setBounds(new Rectangle(168, 99, 112, 21));
    blueBkgWhiteCharLabel7.setText("Dups LD Actual Approval");
    blueBkgWhiteCharLabel7.setBounds(new Rectangle(7, 100, 162, 20));
    blueBkgWhiteCharLabel16.setBounds(new Rectangle(221, 287, 99, 20));
    blueBkgWhiteCharLabel16.setText("Bristol Delivery");
    blueBkgWhiteCharLabel16.setForeground(new Color(143, 143, 188));
    blueBkgWhiteCharLabel16.setBackground(Color.white);
    txtDupsLotAxlApprv.setBounds(new Rectangle(523, 168, 123, 21));
    txtDupsLotAxlApprv.setText("");
    whiteBkgBlueCharLabel7.setText("Bulk Lot Actual Send");
    whiteBkgBlueCharLabel7.setBounds(new Rectangle(8, 198, 135, 21));
    txtBristolDlvy.setBounds(new Rectangle(319, 286, 77, 21));
    txtBristolDlvy.setText("");
    blueBkgWhiteCharLabel13.setText("NY Qty1");
    blueBkgWhiteCharLabel13.setBounds(new Rectangle(9, 254, 90, 20));
    txtNyDlvy1.setBounds(new Rectangle(306, 254, 81, 21));
    txtNyDlvy1.setText("");
    whiteBkgBlueCharLabel6.setBounds(new Rectangle(7, 137, 100, 21));
    whiteBkgBlueCharLabel6.setText("LD Actual Sent");
    txtDupsClrApprv.setBounds(new Rectangle(139, 25, 123, 21));
    txtDupsClrApprv.setText("");
    txtBristolQty.setText("");
    txtBristolQty.setText("");
    txtBristolQty.setBounds(new Rectangle(100, 286, 105, 21));
    jLabel5.setFont(new java.awt.Font("Serif", 1, 12));
    jLabel5.setForeground(Color.black);
    jLabel5.setText("(Local)");
    jLabel5.setBounds(new Rectangle(590, 62, 47, 20));
    subPnlLabDip.setBorder(titledBorder3);
    subPnlLabDip.setBounds(new Rectangle(3, 129, 787, 62));
    subPnlLabDip.setLayout(null);
    txtLabRefNo.setBounds(new Rectangle(112, 28, 123, 21));
    txtLabRefNo.setText("");
    blueBkgWhiteCharLabel4.setBounds(new Rectangle(9, 28, 104, 20));
    blueBkgWhiteCharLabel4.setText("Lab Ref. No.");
    slkClibDyer.setBounds(new Rectangle(105, 54, 156, 20));
    whiteBkgBlueCharLabel10.setText("LOCK IN");
    whiteBkgBlueCharLabel10.setBounds(new Rectangle(502, 87, 103, 19));
    cbxLockIn.setBounds(new Rectangle(605, 87, 126, 19));
    selectSingleMaterialDetail1.setBounds(new Rectangle(364, 55, 163, 21));
    btnInsert.setBounds(new Rectangle(217, 606, 222, 27));
    btnInsert.setText("Insert");
    btnInsert.addActionListener(new PnlColorEditor_btnInsert_actionAdapter(this));
    jPanel2.setBackground(new Color(204, 204, 225));
    this.add(jPanel1,  BorderLayout.CENTER);
    jPanel1.add(jPanel2, BorderLayout.CENTER);
    jPanel2.add(whiteBkgBlueCharLabel1, null);
    jPanel2.add(blueBkgWhiteCharLabel1, null);
    jPanel2.add(whiteBkgBlueCharLabel2, null);
    jPanel2.add(blueBkgWhiteCharLabel2, null);
    jPanel2.add(txtColorName, null);
    jPanel2.add(whiteBkgBlueCharLabel3, null);
    jPanel2.add(txtClrGnlRmk, null);
    subPnlWoven.add(blueBkgWhiteCharLabel19, null);
    subPnlWoven.add(txtDupsFABQty, null);
    subPnlWoven.add(blueBkgWhiteCharLabel111, null);
    subPnlWoven.add(txtBulkFABQTY, null);
    subPnlWoven.add(txtPIQty, null);
    subPnlWoven.add(blueBkgWhiteCharLabel110, null);
    subPnlWoven.add(blueBkgWhiteCharLabel18, null);
    subPnlWoven.add(txtShipYld, null);
    jPanel2.add(subPnlDups, null);
    subPnlDups.add(jLabel4, null);
    subPnlDups.add(txtLDAxlSnd, null);
    subPnlDups.add(whiteBkgBlueCharLabel5, null);
    subPnlDups.add(blueBkgWhiteCharLabel5, null);
    subPnlDups.add(whiteBkgBlueCharLabel8, null);
    subPnlDups.add(txtBulkLDAxlApprv, null);
    subPnlDups.add(blueBkgWhiteCharLabel11, null);
    subPnlDups.add(txtDupsLotAxlSnd, null);
    subPnlDups.add(txtDupsPrice, null);
    subPnlDups.add(blueBkgWhiteCharLabel8, null);
    subPnlDups.add(blueBkgWhiteCharLabel10, null);
    subPnlDups.add(whiteBkgBlueCharLabel9, null);
    subPnlDups.add(blueBkgWhiteCharLabel12, null);
    subPnlDups.add(blueBkgWhiteCharLabel6, null);
    subPnlDups.add(blueBkgWhiteCharLabel17, null);
    subPnlDups.add(txtNyQty1, null);
    subPnlDups.add(txtCDAQty2, null);
    subPnlDups.add(txtBulkLotAxlApprv, null);
    subPnlDups.add(txtBulkClrApprv, null);
    subPnlDups.add(blueBkgWhiteCharLabel14, null);
    subPnlDups.add(txtCDAQty1, null);
    subPnlDups.add(txtNyDlvy2, null);
    subPnlDups.add(whiteBkgBlueCharLabel4, null);
    subPnlDups.add(blueBkgWhiteCharLabel15, null);
    subPnlDups.add(txtBulkLotAxlSnd, null);
    subPnlDups.add(blueBkgWhiteCharLabel9, null);
    subPnlDups.add(txtBulkPrice, null);
    subPnlDups.add(txtNyQty2, null);
    subPnlDups.add(txtDupsLDAxlApprv, null);
    subPnlDups.add(blueBkgWhiteCharLabel7, null);
    subPnlDups.add(blueBkgWhiteCharLabel16, null);
    subPnlDups.add(txtDupsLotAxlApprv, null);
    subPnlDups.add(whiteBkgBlueCharLabel7, null);
    subPnlDups.add(txtBristolDlvy, null);
    subPnlDups.add(blueBkgWhiteCharLabel13, null);
    subPnlDups.add(txtNyDlvy1, null);
    subPnlDups.add(whiteBkgBlueCharLabel6, null);
    subPnlDups.add(txtDupsClrApprv, null);
    subPnlDups.add(txtBristolQty, null);
    subPnlDups.add(jLabel5, null);
    jPanel2.add(subPnlWoven, null);
    jPanel2.add(subPnlLabDip, null);
    subPnlLabDip.add(blueBkgWhiteCharLabel4, null);
    subPnlLabDip.add(txtLabRefNo, null);
    jPanel2.add(slkClibDyer, null);
    jPanel2.add(whiteBkgBlueCharLabel10, null);
    jPanel2.add(cbxLockIn, null);
    jPanel2.add(selectSingleMaterialDetail1, null);
    jPanel2.add(blueBkgWhiteCharLabel3, null);
    jPanel2.add(txtColorCode, null);
    jPanel2.add(btnInsert, null);
    //cbxLockIn.removeAllItems();
  }

  public void record2Gui(){
    try{
      if(recToMapping.get(0)==null){
        whiteBkgBlueCharLabel1.setText("COLOR ADD");
      }else{
        whiteBkgBlueCharLabel1.setText("COLOR EDIT");
      }

      dataBoundGUIs.clear();

   Object mkrValue= recToMapping.get("CLIB_DYER");
   slkClibDyer.init("CLIB_DYER",mkrValue,slkClibDyer.TYPE_MAKER,true);
   dataBoundGUIs.add(slkClibDyer);
   selectSingleMaterialDetail1.setIniValue("CLIB_MTRDTL_PK",recToMapping.get("CLIB_MTRDTL_PK"));
   dataBoundGUIs.add(selectSingleMaterialDetail1);
  //slkClibMill.init("CLIB_MTRDTL_PK",recToMapping.get("CLIB_MTRDTL_PK"),mkrValue,true,slkClibMill.MAPING_COLUMN_MILL_NO);
  //slkClibDyer.setModifyNotifyTo(slkClibMill);
  //java.util.Vector mtrlRecords=newtimes.preproduction.process.DB_ColorLib.allowedSelectMtrlVRecords; //new java.util.Vector();
  //cbxMillMtrl.removeAllItems();

  //exgui.DataBindJCombobox DbJcbxcbxMillMtrl = new exgui.DataBindJCombobox(cbxMillMtrl,"CLIB_MTRDTL_PK",mtrlRecords,"MTRDTL_MILL_NO","MTRDTL_PK",recToMapping.get("CLIB_MTRDTL_PK"),"NONE",null);

  //dataBoundGUIs.add(DbJcbxcbxMillMtrl);

  if(recToMapping.get("CLIB_LOCK")!=null){
    cbxLockIn.setSelectedIndex(1);
  }else{
    cbxLockIn.setSelectedIndex(0);
  }

  Object vftxtColorCode = exgui.verification.CellFormat.getOrdinaryField(3);
  dataBoundGUIs.add(new exgui.DataBindTextWithChecker(txtColorCode,
      "CLIB_COLOR_CODE", recToMapping.get("CLIB_COLOR_CODE"), 3,
      (exgui.Object2String) vftxtColorCode,
                    (exgui.ultratable.CellTxtEditorFormat) vftxtColorCode)
                    );
  Object vftxtColorName = exgui.verification.CellFormat.getOrdinaryField(12);
  dataBoundGUIs.add(new exgui.DataBindTextWithChecker(txtColorName,
      "CLIB_COLOR_NAME", recToMapping.get("CLIB_COLOR_NAME"), 12,
      (exgui.Object2String) vftxtColorName,
                    (exgui.ultratable.CellTxtEditorFormat) vftxtColorName)
                    );
  Object vftxtClrGnlRmk = exgui.verification.CellFormat.getOrdinaryField(
      100);
  dataBoundGUIs.add(new exgui.DataBindTextWithChecker(txtClrGnlRmk,
      "CLIB_REMARK", recToMapping.get("CLIB_REMARK"), 100,
      (exgui.Object2String) vftxtClrGnlRmk,
                    (exgui.ultratable.CellTxtEditorFormat) vftxtClrGnlRmk)
                    );
  Object vftxtLabRefNo = exgui.verification.CellFormat.getOrdinaryField(20);
  dataBoundGUIs.add(new exgui.DataBindTextWithChecker(txtLabRefNo,
      "CLIB_LABDIP_LAB_REF", recToMapping.get("CLIB_LABDIP_LAB_REF"), 20,
      (exgui.Object2String) vftxtLabRefNo,
                    (exgui.ultratable.CellTxtEditorFormat) vftxtLabRefNo)
                    );
  Object vftxtDupsClrApprv = exgui.verification.CellFormat.
      getDateStringFormaterAllowNull();
  dataBoundGUIs.add(new exgui.DataBindTextWithChecker(txtDupsClrApprv,
      "CLIB_LABDIP_DUPS_CLR_APVL",
                    recToMapping.get("CLIB_LABDIP_DUPS_CLR_APVL"), 10,
                                       (exgui.Object2String)
                                       vftxtDupsClrApprv,
                                       (exgui.ultratable.CellTxtEditorFormat)
                                       vftxtDupsClrApprv)
                    );
  Object vftxtBulkClrApprv = exgui.verification.CellFormat.
      getDateStringFormaterAllowNull();
  dataBoundGUIs.add(new exgui.DataBindTextWithChecker(txtBulkClrApprv,
      "CLIB_LABDIP_BULK_CLR_APVL",
                    recToMapping.get("CLIB_LABDIP_BULK_CLR_APVL"), 10,
                                       (exgui.Object2String)
                                       vftxtBulkClrApprv,
                                       (exgui.ultratable.CellTxtEditorFormat)
                                       vftxtBulkClrApprv)
                    );
  Object vftxtDupsPrice = exgui.verification.CellFormat.
      getDoubleFormatAllowNull(4, 3);
  dataBoundGUIs.add(new exgui.DataBindTextWithChecker(txtDupsPrice,
      "CLIB_DUPS_USD_PRX", recToMapping.get("CLIB_DUPS_USD_PRX"), 8,
      (exgui.Object2String) vftxtDupsPrice,
                    (exgui.ultratable.CellTxtEditorFormat) vftxtDupsPrice)
                    );
  Object vftxtBulkPrice = exgui.verification.CellFormat.
      getDoubleFormatAllowNull(4, 3);
  dataBoundGUIs.add(new exgui.DataBindTextWithChecker(txtBulkPrice,
      "CLIB_BULK_LOCAL_PRX", recToMapping.get("CLIB_BULK_LOCAL_PRX"), 8,
      (exgui.Object2String) vftxtBulkPrice,
                    (exgui.ultratable.CellTxtEditorFormat) vftxtBulkPrice)
                    );
  Object vftxtDupsLDAxlApprv = exgui.verification.CellFormat.
      getDateStringFormaterAllowNull();
  dataBoundGUIs.add(new exgui.DataBindTextWithChecker(txtDupsLDAxlApprv,
      "CLIB_DUPS_LD_ACT_APRV", recToMapping.get("CLIB_DUPS_LD_ACT_APRV"), 10,
      (exgui.Object2String) vftxtDupsLDAxlApprv,
                    (exgui.ultratable.CellTxtEditorFormat)
                         vftxtDupsLDAxlApprv)
                    );
  Object vftxtBulkLDAxlApprv = exgui.verification.CellFormat.
      getDateStringFormaterAllowNull();
  dataBoundGUIs.add(new exgui.DataBindTextWithChecker(txtBulkLDAxlApprv,
      "CLIB_BULK_LD_ACT_APRV", recToMapping.get("CLIB_BULK_LD_ACT_APRV"), 10,
      (exgui.Object2String) vftxtBulkLDAxlApprv,
                    (exgui.ultratable.CellTxtEditorFormat)
                         vftxtBulkLDAxlApprv)
                    );
  Object vftxtLDAxlSnd = exgui.verification.CellFormat.
      getDateStringFormaterAllowNull();
  dataBoundGUIs.add(new exgui.DataBindTextWithChecker(txtLDAxlSnd,
      "CLIB_LD_ACT_SEND", recToMapping.get("CLIB_LD_ACT_SEND"), 10,
      (exgui.Object2String) vftxtLDAxlSnd,
                    (exgui.ultratable.CellTxtEditorFormat) vftxtLDAxlSnd)
                    );
  Object vftxtDupsLotAxlSnd = exgui.verification.CellFormat.
      getDateStringFormaterAllowNull();
  dataBoundGUIs.add(new exgui.DataBindTextWithChecker(txtDupsLotAxlSnd,
      "CLIB_DUPS_LOT_ACT_SEND", recToMapping.get("CLIB_DUPS_LOT_ACT_SEND"),
      10, (exgui.Object2String) vftxtDupsLotAxlSnd,
                    (exgui.ultratable.CellTxtEditorFormat)
                       vftxtDupsLotAxlSnd)
                    );
  Object vftxtDupsLotAxlApprv = exgui.verification.CellFormat.
      getDateStringFormaterAllowNull();
  dataBoundGUIs.add(new exgui.DataBindTextWithChecker(txtDupsLotAxlApprv,
      "CLIB_DUPS_LOT_ACT_APRV", recToMapping.get("CLIB_DUPS_LOT_ACT_APRV"),
      10, (exgui.Object2String) vftxtDupsLotAxlApprv,
                    (exgui.ultratable.CellTxtEditorFormat)
                     vftxtDupsLotAxlApprv)
                    );
  Object vftxtBulkLotAxlSnd = exgui.verification.CellFormat.
      getDateStringFormaterAllowNull();
  dataBoundGUIs.add(new exgui.DataBindTextWithChecker(txtBulkLotAxlSnd,
      "CLIB_BULK_LOT_ACT_SEND", recToMapping.get("CLIB_BULK_LOT_ACT_SEND"),
      10, (exgui.Object2String) vftxtBulkLotAxlSnd,
                    (exgui.ultratable.CellTxtEditorFormat)
                       vftxtBulkLotAxlSnd)
                    );
  Object vftxtBulkLotAxlApprv = exgui.verification.CellFormat.
      getDateStringFormaterAllowNull();
  dataBoundGUIs.add(new exgui.DataBindTextWithChecker(txtBulkLotAxlApprv,
      "CLIB_BULK_LOT_ACT_APRV", recToMapping.get("CLIB_BULK_LOT_ACT_APRV"),
      10, (exgui.Object2String) vftxtBulkLotAxlApprv,
                    (exgui.ultratable.CellTxtEditorFormat)
                     vftxtBulkLotAxlApprv)
                    );
  Object vftxtNyQty1 = exgui.verification.CellFormat.
      getIntVerifierAllowNull(1);
  dataBoundGUIs.add(new exgui.DataBindTextWithChecker(txtNyQty1,
      "CLIB_QNTY_NY1", recToMapping.get("CLIB_QNTY_NY1"), 1,
      (exgui.Object2String) vftxtNyQty1,
                    (exgui.ultratable.CellTxtEditorFormat) vftxtNyQty1)
                    );
  Object vftxtNyDlvy1 = exgui.verification.CellFormat.
      getDateStringFormaterAllowNull();
  dataBoundGUIs.add(new exgui.DataBindTextWithChecker(txtNyDlvy1,
      "CLIB_DEL_NY1", recToMapping.get("CLIB_DEL_NY1"), 10,
      (exgui.Object2String) vftxtNyDlvy1,
                    (exgui.ultratable.CellTxtEditorFormat) vftxtNyDlvy1)
                    );
  Object vftxtNyQty2 = exgui.verification.CellFormat.
      getIntVerifierAllowNull(2);
  dataBoundGUIs.add(new exgui.DataBindTextWithChecker(txtNyQty2,
      "CLIB_QNTY_NY2", recToMapping.get("CLIB_QNTY_NY2"), 2,
      (exgui.Object2String) vftxtNyQty2,
                    (exgui.ultratable.CellTxtEditorFormat) vftxtNyQty2)
                    );
  Object vftxtNyDlvy2 = exgui.verification.CellFormat.
      getDateStringFormaterAllowNull();
  dataBoundGUIs.add(new exgui.DataBindTextWithChecker(txtNyDlvy2,
      "CLIB_DEL_NY2", recToMapping.get("CLIB_DEL_NY2"), 10,
      (exgui.Object2String) vftxtNyDlvy2,
                    (exgui.ultratable.CellTxtEditorFormat) vftxtNyDlvy2)
                    );
  Object vftxtBristolQty = exgui.verification.CellFormat.
      getIntVerifierAllowNull(2);
  dataBoundGUIs.add(new exgui.DataBindTextWithChecker(txtBristolQty,
      "CLIB_QNTY_BTL", recToMapping.get("CLIB_QNTY_BTL"), 2,
      (exgui.Object2String) vftxtBristolQty,
                    (exgui.ultratable.CellTxtEditorFormat) vftxtBristolQty)
                    );
  Object vftxtBristolDlvy = exgui.verification.CellFormat.
      getDateStringFormaterAllowNull();
  dataBoundGUIs.add(new exgui.DataBindTextWithChecker(txtBristolDlvy,
      "CLIB_DEL_BTL", recToMapping.get("CLIB_DEL_BTL"), 10,
      (exgui.Object2String) vftxtBristolDlvy,
                    (exgui.ultratable.CellTxtEditorFormat) vftxtBristolDlvy)
                    );
  Object vftxtCDAQty1 = exgui.verification.CellFormat.
      getIntVerifierAllowNull(1);
  dataBoundGUIs.add(new exgui.DataBindTextWithChecker(txtCDAQty1,
      "CLIB_QNTY_CDA1", recToMapping.get("CLIB_QNTY_CDA1"), 1,
      (exgui.Object2String) vftxtCDAQty1,
                    (exgui.ultratable.CellTxtEditorFormat) vftxtCDAQty1)
                    );
  Object vftxtCDAQty2 = exgui.verification.CellFormat.
      getIntVerifierAllowNull(2);
  dataBoundGUIs.add(new exgui.DataBindTextWithChecker(txtCDAQty2,
      "CLIB_QNTY_CDA2", recToMapping.get("CLIB_QNTY_CDA2"), 2,
      (exgui.Object2String) vftxtCDAQty2,
                    (exgui.ultratable.CellTxtEditorFormat) vftxtCDAQty2)
                    );
  Object vftxtPIQty = exgui.verification.CellFormat.getIntVerifierAllowNull(
      7);
  dataBoundGUIs.add(new exgui.DataBindTextWithChecker(txtPIQty,
      "CLIB_PI_QTY", recToMapping.get("CLIB_PI_QTY"), 7,
      (exgui.Object2String) vftxtPIQty,
                    (exgui.ultratable.CellTxtEditorFormat) vftxtPIQty)
                    );
  Object vftxtShipYld = exgui.verification.CellFormat.
      getIntVerifierAllowNull(7);
  dataBoundGUIs.add(new exgui.DataBindTextWithChecker(txtShipYld,
      "CLIB_SHIP_YIELD", recToMapping.get("CLIB_SHIP_YIELD"), 7,
      (exgui.Object2String) vftxtShipYld,
                    (exgui.ultratable.CellTxtEditorFormat) vftxtShipYld)
                    );
  Object vftxtDupsFABQty = exgui.verification.CellFormat.
      getIntVerifierAllowNull(6);
  dataBoundGUIs.add(new exgui.DataBindTextWithChecker(txtDupsFABQty,
      "CLIB_DUPS_FAB_QTY", recToMapping.get("CLIB_DUPS_FAB_QTY"), 6,
      (exgui.Object2String) vftxtDupsFABQty,
                    (exgui.ultratable.CellTxtEditorFormat) vftxtDupsFABQty)
                    );
  Object vftxtBulkFABQTY = exgui.verification.CellFormat.
      getIntVerifierAllowNull(6);
  dataBoundGUIs.add(new exgui.DataBindTextWithChecker(txtBulkFABQTY,
      "CLIB_BULK_FAB_QTY", recToMapping.get("CLIB_BULK_FAB_QTY"), 6,
      (exgui.Object2String) vftxtBulkFABQTY,
                    (exgui.ultratable.CellTxtEditorFormat) vftxtBulkFABQTY)
                    );
  //begin to collect the columns allow to future copy...
  if (recordColumnsToCopy == null) {
    recordColumnsToCopy = new String[dataBoundGUIs.size()+1];
    for (int i = 0; i < dataBoundGUIs.size(); i++) {
      recordColumnsToCopy[i] = ( (exgui.DataBindGUIObject) dataBoundGUIs.
                                get(i)).getOrgRecField();
    }
    recordColumnsToCopy[recordColumnsToCopy.length-1]="CLIB_LOCK";
  }

    }catch(Exception e){
      e.printStackTrace();
    }
  }
  public void doUpdate() throws Exception{
    //isGui2RecordOk is determed while gui2record is called.
    super.doUpdate();
    if(!super.isGui2RecordOk)return;
    //back to last page...color lib listing page...
    processhandler.template.Properties.getCenteralControler().goBack();
  }
  public boolean gui2Record(){
    try{
      if (cbxLockIn.getSelectedIndex() > 0) {
        recToMapping.set("CLIB_LOCK", "Y");
      }else{
        recToMapping.set("CLIB_LOCK",null);
      }
    }catch(Exception e){
      e.printStackTrace();
      return false;
    }
    return super.gui2Record();
  }

  public void doPrint(){

  }

  void btnInsert_actionPerformed(ActionEvent e) {
    try{
       this.doUpdate();
    }catch(Exception eii){
      eii.printStackTrace();
    }
  }
}

class PnlColorEditor_btnInsert_actionAdapter implements java.awt.event.ActionListener {
  PnlColorEditor adaptee;

  PnlColorEditor_btnInsert_actionAdapter(PnlColorEditor adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.btnInsert_actionPerformed(e);
  }

}
