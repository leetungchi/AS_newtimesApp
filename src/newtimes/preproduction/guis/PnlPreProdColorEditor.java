package newtimes.preproduction.guis;

import java.awt.*;
import javax.swing.*;
import exgui.*;
import javax.swing.border.*;
import newtimes.preproduction.buyermakerselect.*;
import java.awt.event.*;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class PnlPreProdColorEditor
    extends processhandler.template.PnlFieldsEditor
    //extends JPanel
    implements  java.awt.event.ItemListener{

  BorderLayout borderLayout1 = new BorderLayout();
  JPanel jPanel1 = new JPanel();

  JPanel jPanel2 = new JPanel();

  //JLabel whiteBkgBlueCharLabel1 = new JLabel();
  exgui.BlueBkgWhiteCharLabel  whiteBkgBlueCharLabel1 = new exgui.BlueBkgWhiteCharLabel();
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

  JPanel subPnlDups = new JPanel();

  TitledBorder titledBorder1;
  JLabel jLabel4 = new JLabel();
  JTextField txtLDAxlSnd = new JTextField();
  JLabel whiteBkgBlueCharLabel5 = new JLabel();
  JLabel blueBkgWhiteCharLabel5 = new JLabel();
  JTextField txtBulkLDAxlApprv = new JTextField();
  JLabel blueBkgWhiteCharLabel11 = new JLabel();
  JTextField txtDupsLotAxlSnd = new JTextField();
  JTextField txtDupsPrice = new JTextField();
  JLabel blueBkgWhiteCharLabel8 = new JLabel();
  JLabel blueBkgWhiteCharLabel10 = new JLabel();
  JLabel blueBkgWhiteCharLabel6 = new JLabel();
  JTextField txtBulkLotAxlApprv = new JTextField();
  JTextField txtBulkClrApprv = new JTextField();
  JLabel whiteBkgBlueCharLabel4 = new JLabel();
  JTextField txtBulkLotAxlSnd = new JTextField();
  JLabel blueBkgWhiteCharLabel9 = new JLabel();
  JTextField txtBulkPrice = new JTextField();
  JTextField txtDupsLDAxlApprv = new JTextField();
  JLabel blueBkgWhiteCharLabel7 = new JLabel();
  JTextField txtDupsLotAxlApprv = new JTextField();
  JLabel whiteBkgBlueCharLabel7 = new JLabel();
  JLabel whiteBkgBlueCharLabel6 = new JLabel();
  JTextField txtDupsClrApprv = new JTextField();
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
  JLabel lblMillNo = new JLabel();
  JLabel blueBkgWhiteCharLabel12 = new JLabel();
  JComboBox cbxMtrlNo = new JComboBox();
  boolean isProcessingRec2Gui=false;
  public PnlPreProdColorEditor() {
    try {
      jbInit();
      recordColumnsToCopy=null;
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }
  protected void jbInit() throws Exception {
   jPanel1.setBackground(new Color(204, 204, 225));
   jPanel2.setBackground(new Color(204, 204, 225));
   subPnlDups.setBackground(new Color(204, 204, 225));
   subPnlLabDip.setBackground(new Color(204, 204, 225));
   setBackground(new Color(204, 204, 225));
    border1 = BorderFactory.createBevelBorder(BevelBorder.RAISED,Color.white,Color.white,new Color(103, 101, 98),new Color(148, 145, 140));
    titledBorder1 = new TitledBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED,Color.white,Color.white,new Color(103, 101, 98),new Color(148, 145, 140)),"Dups");
    titledBorder2 = new TitledBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED,Color.white,Color.white,new Color(103, 101, 98),new Color(148, 145, 140)),"Woven");
    titledBorder3 = new TitledBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED,Color.white,Color.white,new Color(103, 101, 98),new Color(148, 145, 140)),"Lab Dip");
    this.setPreferredSize(new Dimension(770, 450));
    this.setSize(new Dimension(800, 446));
    this.setRequestFocusEnabled(true);
    this.setLayout(borderLayout1);
    jPanel1.setLayout(borderLayout2);
    whiteBkgBlueCharLabel1.setText("COLOR");
    whiteBkgBlueCharLabel1.setBounds(new Rectangle(0, 18, 802, 26));
    jPanel2.setLayout(null);
    blueBkgWhiteCharLabel1.setText("*Dyer");
    blueBkgWhiteCharLabel1.setBounds(new Rectangle(2, 53, 72, 20));
    whiteBkgBlueCharLabel2.setText("*Color Name");
    whiteBkgBlueCharLabel2.setBounds(new Rectangle(237, 85, 79, 21));
    blueBkgWhiteCharLabel2.setBounds(new Rectangle(503, 54, 95, 22));
    blueBkgWhiteCharLabel2.setText("Material Mill No.");
    txtColorCode.setBounds(new Rectangle(75, 84, 156, 21));
    blueBkgWhiteCharLabel3.setBounds(new Rectangle(3, 85, 69, 20));
    blueBkgWhiteCharLabel3.setBackground(Color.white);
    blueBkgWhiteCharLabel3.setForeground(Color.black);
    blueBkgWhiteCharLabel3.setText("Color Code");
    txtColorName.setBounds(new Rectangle(314, 85, 145, 21));
    txtColorName.setText("jTextField1");
    txtColorName.setText("");
    txtClrGnlRmk.setText("");
    txtClrGnlRmk.setText("");
    txtClrGnlRmk.setBounds(new Rectangle(605, 84, 123, 21));
    whiteBkgBlueCharLabel3.setBounds(new Rectangle(503, 84, 97, 21));
    whiteBkgBlueCharLabel3.setText("General Remark");
    subPnlDups.setFont(new java.awt.Font("Serif", 1, 11));
    subPnlDups.setBorder(titledBorder1);
    subPnlDups.setBounds(new Rectangle(3, 196, 787, 234));
    subPnlDups.setLayout(null);
    jLabel4.setBounds(new Rectangle(272, 63, 47, 20));
    jLabel4.setText("(USD)");
    jLabel4.setForeground(Color.black);
    jLabel4.setFont(new java.awt.Font("Serif", 1, 12));
    txtLDAxlSnd.setText("");
    txtLDAxlSnd.setText("");
    txtLDAxlSnd.setBounds(new Rectangle(147, 138, 123, 21));
    whiteBkgBlueCharLabel5.setText("Bulk Price");
    whiteBkgBlueCharLabel5.setBounds(new Rectangle(363, 64, 100, 21));
    blueBkgWhiteCharLabel5.setBounds(new Rectangle(6, 25, 133, 20));
    blueBkgWhiteCharLabel5.setText("Dups Color Approval");
    txtBulkLDAxlApprv.setBounds(new Rectangle(506, 102, 123, 21));
    txtBulkLDAxlApprv.setText("");
    blueBkgWhiteCharLabel11.setBackground(Color.white);
    blueBkgWhiteCharLabel11.setForeground(Color.black);
    blueBkgWhiteCharLabel11.setText("Bulk Lot Actual Approval");
    blueBkgWhiteCharLabel11.setBounds(new Rectangle(362, 199, 162, 20));
    txtDupsLotAxlSnd.setText("");
    txtDupsLotAxlSnd.setBounds(new Rectangle(147, 168, 123, 21));
    txtDupsPrice.setText("");
    txtDupsPrice.setText("");
    txtDupsPrice.setBounds(new Rectangle(147, 62, 123, 21));
    blueBkgWhiteCharLabel8.setBounds(new Rectangle(365, 102, 160, 20));
    blueBkgWhiteCharLabel8.setText("Bulk LD Actual Approval");
    blueBkgWhiteCharLabel10.setText("Dups Lot Actual Send");
    blueBkgWhiteCharLabel10.setBounds(new Rectangle(7, 168, 133, 20));
    blueBkgWhiteCharLabel6.setText("Bulk Color Approval");
    blueBkgWhiteCharLabel6.setBounds(new Rectangle(362, 25, 133, 20));
    txtBulkLotAxlApprv.setText("");
    txtBulkLotAxlApprv.setBounds(new Rectangle(506, 199, 121, 21));
    txtBulkClrApprv.setText("");
    txtBulkClrApprv.setBounds(new Rectangle(506, 27, 123, 21));
    whiteBkgBlueCharLabel4.setBounds(new Rectangle(6, 61, 100, 21));
    whiteBkgBlueCharLabel4.setText("Dups Price");
    txtBulkLotAxlSnd.setBounds(new Rectangle(147, 197, 123, 21));
    txtBulkLotAxlSnd.setText("");
    txtBulkLotAxlSnd.setText("");
    blueBkgWhiteCharLabel9.setBounds(new Rectangle(363, 168, 162, 20));
    blueBkgWhiteCharLabel9.setText("Dups Lot Actual Approval");
    txtBulkPrice.setBounds(new Rectangle(506, 65, 123, 21));
    txtBulkPrice.setText("");
    txtBulkPrice.setText("");
    txtDupsLDAxlApprv.setText("");
    txtDupsLDAxlApprv.setBounds(new Rectangle(147, 99, 123, 21));
    blueBkgWhiteCharLabel7.setText("Dups LD Actual Approval");
    blueBkgWhiteCharLabel7.setBounds(new Rectangle(7, 100, 162, 20));
    txtDupsLotAxlApprv.setBounds(new Rectangle(506, 168, 123, 21));
    txtDupsLotAxlApprv.setText("");
    whiteBkgBlueCharLabel7.setText("Bulk Lot Actual Send");
    whiteBkgBlueCharLabel7.setBounds(new Rectangle(8, 198, 135, 21));
    whiteBkgBlueCharLabel6.setBounds(new Rectangle(7, 137, 100, 21));
    whiteBkgBlueCharLabel6.setText("LD Actual Sent");
    txtDupsClrApprv.setBounds(new Rectangle(147, 25, 123, 21));
    txtDupsClrApprv.setText("");
    jLabel5.setFont(new java.awt.Font("Serif", 1, 12));
    jLabel5.setForeground(Color.black);
    jLabel5.setText("(Local)");
    jLabel5.setBounds(new Rectangle(629, 67, 47, 20));
    subPnlLabDip.setBorder(titledBorder3);
    subPnlLabDip.setBounds(new Rectangle(3, 144, 787, 47));
    subPnlLabDip.setLayout(null);
    txtLabRefNo.setBounds(new Rectangle(111, 17, 123, 21));
    txtLabRefNo.setText("");
    blueBkgWhiteCharLabel4.setBounds(new Rectangle(8, 17, 104, 20));
    blueBkgWhiteCharLabel4.setText("Lab Ref. No.");
    slkClibDyer.setBounds(new Rectangle(75, 53, 156, 20));
    whiteBkgBlueCharLabel10.setText("LOCK IN");
    whiteBkgBlueCharLabel10.setBounds(new Rectangle(2, 119, 103, 19));
    cbxLockIn.setBounds(new Rectangle(75, 119, 156, 19));
    lblMillNo.setText("");
    lblMillNo.setBounds(new Rectangle(605, 54, 123, 22));
    blueBkgWhiteCharLabel12.setText("Material No.");
    blueBkgWhiteCharLabel12.setBounds(new Rectangle(247, 53, 68, 22));
    cbxMtrlNo.setBounds(new Rectangle(315, 53, 147, 22));
    this.add(jPanel1,  BorderLayout.CENTER);
    jPanel1.add(jPanel2, BorderLayout.CENTER);
    jPanel2.add(whiteBkgBlueCharLabel1, null);
    jPanel2.add(blueBkgWhiteCharLabel1, null);
    jPanel2.add(subPnlDups, null);
    subPnlDups.add(whiteBkgBlueCharLabel5, null);
    subPnlDups.add(blueBkgWhiteCharLabel5, null);
    subPnlDups.add(blueBkgWhiteCharLabel11, null);
    subPnlDups.add(blueBkgWhiteCharLabel8, null);
    subPnlDups.add(blueBkgWhiteCharLabel10, null);
    subPnlDups.add(blueBkgWhiteCharLabel6, null);
    subPnlDups.add(whiteBkgBlueCharLabel4, null);
    subPnlDups.add(blueBkgWhiteCharLabel9, null);
    subPnlDups.add(blueBkgWhiteCharLabel7, null);
    subPnlDups.add(whiteBkgBlueCharLabel7, null);
    subPnlDups.add(whiteBkgBlueCharLabel6, null);
    subPnlDups.add(txtDupsLotAxlApprv, null);
    subPnlDups.add(txtBulkClrApprv, null);
    subPnlDups.add(txtBulkPrice, null);
    subPnlDups.add(txtBulkLDAxlApprv, null);
    subPnlDups.add(jLabel5, null);
    subPnlDups.add(txtBulkLotAxlApprv, null);
    subPnlDups.add(txtDupsPrice, null);
    subPnlDups.add(txtDupsClrApprv, null);
    subPnlDups.add(jLabel4, null);
    subPnlDups.add(txtDupsLDAxlApprv, null);
    subPnlDups.add(txtLDAxlSnd, null);
    subPnlDups.add(txtDupsLotAxlSnd, null);
    subPnlDups.add(txtBulkLotAxlSnd, null);
    jPanel2.add(subPnlLabDip, null);
    subPnlLabDip.add(blueBkgWhiteCharLabel4, null);
    subPnlLabDip.add(txtLabRefNo, null);
    jPanel2.add(whiteBkgBlueCharLabel10, null);
    jPanel2.add(blueBkgWhiteCharLabel3, null);
    jPanel2.add(blueBkgWhiteCharLabel12, null);
    jPanel2.add(whiteBkgBlueCharLabel2, null);
    jPanel2.add(blueBkgWhiteCharLabel2, null);
    jPanel2.add(lblMillNo, null);
    jPanel2.add(whiteBkgBlueCharLabel3, null);
    jPanel2.add(txtClrGnlRmk, null);
    jPanel2.add(txtColorCode, null);
    jPanel2.add(slkClibDyer, null);
    jPanel2.add(cbxLockIn, null);
    jPanel2.add(txtColorName, null);
    jPanel2.add(cbxMtrlNo, null);
    cbxMtrlNo.addItemListener(this);
    //cbxLockIn.removeAllItems();
  }
  public void itemStateChanged(java.awt.event.ItemEvent e){
    if(!isProcessingRec2Gui){
      int index=cbxMtrlNo.getSelectedIndex();
      database.datatype.Record rec=
          (database.datatype.Record)
          newtimes.preproduction.Constants.PREPROD_USING_MTRL_DTLS.get(index);
      Object millNoObj=rec.get(2);
      if(millNoObj==null)
        lblMillNo.setText("");
      else
        lblMillNo.setText(millNoObj.toString());
    }
  }
  public void record2Gui(){
    java.util.Vector mtrlRecords=newtimes.preproduction.Constants.PREPROD_USING_MTRL_DTLS;
    try{
      if(recToMapping.get(0)==null){
        whiteBkgBlueCharLabel1.setText("COLOR ADD");
      }else{
        whiteBkgBlueCharLabel1.setText("COLOR EDIT");
      }

      dataBoundGUIs.clear();

   Object mkrValue= recToMapping.get("PCLIB_DYER");
   slkClibDyer.init("PCLIB_DYER",mkrValue,slkClibDyer.TYPE_MAKER,false);
   dataBoundGUIs.add(slkClibDyer);
   lblMillNo.setText(newtimes.preproduction.Constants.TEMP_MILL_MTRL_NO);

  if(recToMapping.get("PCLIB_LOCK")!=null){
    cbxLockIn.setSelectedIndex(1);
  }else{
    cbxLockIn.setSelectedIndex(0);
  }


  Object vftxtColorCode = exgui.verification.CellFormat.getOrdinaryField(5);
  dataBoundGUIs.add(new exgui.DataBindTextWithChecker(txtColorCode,
      "PCLIB_COLOR_CODE", recToMapping.get("PCLIB_COLOR_CODE"), 5,
                                           (exgui.Object2String) vftxtColorCode,
                                           (exgui.ultratable.CellTxtEditorFormat)
                                           vftxtColorCode)
                    );
  Object vftxtColorName = exgui.verification.CellFormat.getOrdinaryField(12);
  dataBoundGUIs.add(new exgui.DataBindTextWithChecker(txtColorName,
      "PCLIB_COLOR_NAME", recToMapping.get("PCLIB_COLOR_NAME"), 12,
                    (exgui.Object2String) vftxtColorName,
                    (exgui.ultratable.CellTxtEditorFormat) vftxtColorName)
                    );
  Object vftxtClrGnlRmk = exgui.verification.CellFormat.getOrdinaryField(
      100);
  dataBoundGUIs.add(new exgui.DataBindTextWithChecker(txtClrGnlRmk,
      "PCLIB_REMARK", recToMapping.get("PCLIB_REMARK"), 100,
      (exgui.Object2String) vftxtClrGnlRmk,
                    (exgui.ultratable.CellTxtEditorFormat) vftxtClrGnlRmk)
                    );
  Object vftxtLabRefNo = exgui.verification.CellFormat.getOrdinaryField(20);
  dataBoundGUIs.add(new exgui.DataBindTextWithChecker(txtLabRefNo,
      "PCLIB_LABDIP_LAB_REF", recToMapping.get("PCLIB_LABDIP_LAB_REF"), 20,
      (exgui.Object2String) vftxtLabRefNo,
                    (exgui.ultratable.CellTxtEditorFormat) vftxtLabRefNo)
                    );
  Object vftxtDupsClrApprv = exgui.verification.CellFormat.
      getDateStringFormaterAllowNull();
  dataBoundGUIs.add(new exgui.DataBindTextWithChecker(txtDupsClrApprv,
      "PCLIB_LABDIP_DUPS_CLR_APVL",
                    recToMapping.get("PCLIB_LABDIP_DUPS_CLR_APVL"), 10,
                                       (exgui.Object2String)
                                       vftxtDupsClrApprv,
                                       (exgui.ultratable.CellTxtEditorFormat)
                                       vftxtDupsClrApprv)
                    );
  Object vftxtBulkClrApprv = exgui.verification.CellFormat.
      getDateStringFormaterAllowNull();
  dataBoundGUIs.add(new exgui.DataBindTextWithChecker(txtBulkClrApprv,
      "PCLIB_LABDIP_BULK_CLR_APVL",
                    recToMapping.get("PCLIB_LABDIP_BULK_CLR_APVL"), 10,
                                       (exgui.Object2String)
                                       vftxtBulkClrApprv,
                                       (exgui.ultratable.CellTxtEditorFormat)
                                       vftxtBulkClrApprv)
                    );
  Object vftxtDupsPrice = exgui.verification.CellFormat.
      getDoubleFormatAllowNull(4, 3);
  dataBoundGUIs.add(new exgui.DataBindTextWithChecker(txtDupsPrice,
      "PCLIB_DUPS_USD_PRX", recToMapping.get("PCLIB_DUPS_USD_PRX"), 8,
      (exgui.Object2String) vftxtDupsPrice,
                    (exgui.ultratable.CellTxtEditorFormat) vftxtDupsPrice)
                    );
  Object vftxtBulkPrice = exgui.verification.CellFormat.
      getDoubleFormatAllowNull(4, 3);
  dataBoundGUIs.add(new exgui.DataBindTextWithChecker(txtBulkPrice,
      "PCLIB_BULK_LOCAL_PRX", recToMapping.get("PCLIB_BULK_LOCAL_PRX"), 8,
      (exgui.Object2String) vftxtBulkPrice,
                    (exgui.ultratable.CellTxtEditorFormat) vftxtBulkPrice)
                    );
  Object vftxtDupsLDAxlApprv = exgui.verification.CellFormat.
      getDateStringFormaterAllowNull();
  dataBoundGUIs.add(new exgui.DataBindTextWithChecker(txtDupsLDAxlApprv,
      "PCLIB_DUPS_LD_ACT_APRV", recToMapping.get("PCLIB_DUPS_LD_ACT_APRV"), 10,
      (exgui.Object2String) vftxtDupsLDAxlApprv,
                    (exgui.ultratable.CellTxtEditorFormat)
                         vftxtDupsLDAxlApprv)
                    );
  Object vftxtBulkLDAxlApprv = exgui.verification.CellFormat.
      getDateStringFormaterAllowNull();
  dataBoundGUIs.add(new exgui.DataBindTextWithChecker(txtBulkLDAxlApprv,
      "PCLIB_BULK_LD_ACT_APRV", recToMapping.get("PCLIB_BULK_LD_ACT_APRV"), 10,
      (exgui.Object2String) vftxtBulkLDAxlApprv,
                    (exgui.ultratable.CellTxtEditorFormat)
                         vftxtBulkLDAxlApprv)
                    );
  Object vftxtLDAxlSnd = exgui.verification.CellFormat.
      getDateStringFormaterAllowNull();
  dataBoundGUIs.add(new exgui.DataBindTextWithChecker(txtLDAxlSnd,
      "PCLIB_LD_ACT_SEND", recToMapping.get("PCLIB_LD_ACT_SEND"), 10,
      (exgui.Object2String) vftxtLDAxlSnd,
                    (exgui.ultratable.CellTxtEditorFormat) vftxtLDAxlSnd)
                    );
  Object vftxtDupsLotAxlSnd = exgui.verification.CellFormat.
      getDateStringFormaterAllowNull();
  dataBoundGUIs.add(new exgui.DataBindTextWithChecker(txtDupsLotAxlSnd,
      "PCLIB_DUPS_LOT_ACT_SEND", recToMapping.get("PCLIB_DUPS_LOT_ACT_SEND"),
      10, (exgui.Object2String) vftxtDupsLotAxlSnd,
                    (exgui.ultratable.CellTxtEditorFormat)
                       vftxtDupsLotAxlSnd)
                    );
  Object vftxtDupsLotAxlApprv = exgui.verification.CellFormat.
      getDateStringFormaterAllowNull();
  dataBoundGUIs.add(new exgui.DataBindTextWithChecker(txtDupsLotAxlApprv,
      "PCLIB_DUPS_LOT_ACT_APRV", recToMapping.get("PCLIB_DUPS_LOT_ACT_APRV"),
      10, (exgui.Object2String) vftxtDupsLotAxlApprv,
                    (exgui.ultratable.CellTxtEditorFormat)
                     vftxtDupsLotAxlApprv)
                    );
  Object vftxtBulkLotAxlSnd = exgui.verification.CellFormat.
      getDateStringFormaterAllowNull();
  dataBoundGUIs.add(new exgui.DataBindTextWithChecker(txtBulkLotAxlSnd,
      "PCLIB_BULK_LOT_ACT_SEND", recToMapping.get("PCLIB_BULK_LOT_ACT_SEND"),
      10, (exgui.Object2String) vftxtBulkLotAxlSnd,
                    (exgui.ultratable.CellTxtEditorFormat)
                       vftxtBulkLotAxlSnd)
                    );
  Object vftxtBulkLotAxlApprv = exgui.verification.CellFormat.
      getDateStringFormaterAllowNull();
  dataBoundGUIs.add(new exgui.DataBindTextWithChecker(txtBulkLotAxlApprv,
      "PCLIB_BULK_LOT_ACT_APRV", recToMapping.get("PCLIB_BULK_LOT_ACT_APRV"),
      10, (exgui.Object2String) vftxtBulkLotAxlApprv,
                    (exgui.ultratable.CellTxtEditorFormat)
                     vftxtBulkLotAxlApprv)
                    );
   isProcessingRec2Gui=true;
   exgui.DataBindJCombobox DbJcbxcbxMtrlNo =
       new exgui.DataBindJCombobox(cbxMtrlNo,"PCLIB_MTRDTL_PK",
                                   mtrlRecords,
                                   "MTRDTL_MTR_NO",
                                   "MTRDTL_PK",
                                   recToMapping.get("PCLIB_MTRDTL_PK"));
   isProcessingRec2Gui=false;
   itemStateChanged(null);

   dataBoundGUIs.add(DbJcbxcbxMtrlNo);

  //begin to collect the columns allow to future copy...
  if (recordColumnsToCopy == null) {
    recordColumnsToCopy = new String[dataBoundGUIs.size()+1];
    for (int i = 0; i < dataBoundGUIs.size(); i++) {
      recordColumnsToCopy[i] = ( (exgui.DataBindGUIObject) dataBoundGUIs.
                                get(i)).getOrgRecField();
    }
    recordColumnsToCopy[recordColumnsToCopy.length-1]="PCLIB_LOCK";
  }

    }catch(Exception e){
      e.printStackTrace();
    }
  }
  public void doUpdate() throws Exception{
    super.doUpdate();
    if(!super.isGui2RecordOk)return;
    //back to last page...color lib listing page...
    //processhandler.template.Properties.getCenteralControler().goBack();
    processhandler.template.Properties.getCenteralControler().doCommandExecute(
        new newtimes.preproduction.process.TgrToListClibsWhitOutPreprod()
    );
  }
  public boolean gui2Record(){
    try{
      if (cbxLockIn.getSelectedIndex() > 0) {
        recToMapping.set("PCLIB_LOCK", "Y");
      }else{
        recToMapping.set("PCLIB_LOCK",null);
      }
    }catch(Exception e){
      e.printStackTrace();
      return false;
    }
    /*
    if(txtColorCode.getText().trim().equals("") ){
      exgui.verification.VerifyLib.showAlert("Color Code Can not be Blank",
                                             "Color Code Can not be Blank");
      txtColorCode.grabFocus();
      return false;
    }*/
    if(slkClibDyer.getSelectedValue()==null){
      exgui.verification.VerifyLib.showAlert("Please Select A Dyer",
                                             "Please Select A Dyer");
      slkClibDyer.grabFocus();
      return false;

    }
    if(txtColorName.getText().trim().equals("") ){
      exgui.verification.VerifyLib.showAlert("Color Name Can not be Blank",
                                             "Color Name Can not be Blank");
      txtColorName.grabFocus();
      return false;
    }

    return super.gui2Record();
  }

  public void doPrint(){

  }

}

