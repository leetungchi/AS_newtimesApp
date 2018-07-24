package newtimes.shipping_admin.guis.shippingmaintain;

import processhandler.*;
import processhandler.template.*;
import javax.swing.*;
import java.awt.*;
import exgui.*;
import java.awt.event.*;
import javax.swing.border.*;
import exgui.*;
import newtimes.preproduction.buyermakerselect.*;
import database.datatype.Record;
public class PnlShipMasterPWBW
      extends PnlShipMaster{
      //extends JPanel{
   //-----------ORG SHIP HEAD GUI------------------
   /*
   BlueBkgWhiteCharLabel blueBkgWhiteCharLabel1 = new BlueBkgWhiteCharLabel();
   JLabel jLabel23 = new JLabel();
   JPanel jPanel3 = new JPanel();
   JLabel jLabel25 = new JLabel();
   JLabel jLabel121 = new JLabel();
   JLabel jLabel110 = new JLabel();
   JPanel jPanel1 = new JPanel();
   Border border1;
   JLabel jLabel26 = new JLabel();
   JLabel jLabel19 = new JLabel();
   JLabel jLabel27 = new JLabel();
   JLabel jLabel125 = new JLabel();
   //JTextField txtShipDest = new JTextField();
   JComboBox cbxShipPrcTerm = new JComboBox();
   public JTextField txtShipDate = new JTextField();
   JPanel jPanel2 = new JPanel();
   JLabel jLabel126 = new JLabel();
   JLabel jLabel117 = new JLabel();
   JLabel jLabel9 = new JLabel();
   JLabel jLabel127 = new JLabel();
   JTextField txtMAWB = new JTextField();
   JLabel jLabel20 = new JLabel();
   JLabel jLabel115 = new JLabel();
   JTextField txtFLT = new JTextField();
   JLabel jLabel10 = new JLabel();
   JTextField txtHAWB = new JTextField();
   JLabel jLabel1110 = new JLabel();
   JLabel jLabel1111 = new JLabel();
   JLabel jLabel112 = new JLabel();
   JTextField txtShipLC = new JTextField();
   JComboBox cbxShipOcieanAir = new JComboBox();
   ButtonGroup buttonGroup1 = new ButtonGroup();
   JPanel jPanel4 = new JPanel();
   JComboBox cbxShipEtaTo = new JComboBox();
   JComboBox cbxShipEtdEx = new JComboBox();
   JLabel jLabel113 = new JLabel();
   JLabel jLabel11 = new JLabel();
   public JTextField txtShipETDdate = new JTextField();
   JLabel jLabel17 = new JLabel();
   JLabel jLabel15 = new JLabel();
   public JTextField txtShipETAdate = new JTextField();
   public JComboBox cbxShipOrgCnty = new JComboBox();
   JLabel jLabel119 = new JLabel();
   JLabel jLabel12 = new JLabel();
   JLabel jLabel14 = new JLabel();
   JLabel jLabel1116 = new JLabel();
   JTextField txtCuft = new JTextField();
   JTextField txtDimnetWT = new JTextField();
   JTextField txtDimentCTN = new JTextField();
   JTextField txtDimUnit = new JTextField();
   JLabel jLabel1113 = new JLabel();
   JLabel jLabel128 = new JLabel();
   JTextField txtNetNet = new JTextField();
   JLabel jLabel118 = new JLabel();
   JLabel jLabel1117 = new JLabel();
   JTextField txtGrossWT = new JTextField();
   JLabel jLabel114 = new JLabel();
   JTextField txtNetWT = new JTextField();
   JLabel jLabel129 = new JLabel();
   JTextField txtNetNetUnit = new JTextField();
   JLabel jLabel1210 = new JLabel();
   JLabel jLabel1114 = new JLabel();
   JTextField txtNetUnit = new JTextField();
   JTextField txtGrossUnit = new JTextField();
   JLabel jLabel1211 = new JLabel();
   JLabel jLabel1118 = new JLabel();
   JLabel jLabel1115 = new JLabel();
   Border border2;
   TitledBorder titledBorder1;
   JComboBox cbx_IC_Szn = new JComboBox();
   JTextField txt_FTY_Inv = new JTextField();
   JComboBox cbx_IC_Div = new JComboBox();
   public JTextField txtShip_IC_date = new JTextField();
   public JPanel PnlShipExtra = new JPanel();
   JButton btnEditShipExtra = new JButton();
   JScrollPane jScrollPane1 = new JScrollPane();
   JTextArea txtAreaShipExtra = new JTextArea();
   Border border3;
   TitledBorder titledBorder2;
   SelectBuyerMaker slkByrMkrXprFwd = new SelectBuyerMaker();
   SelectBuyerMaker slkByrMkr_Bill2 = new SelectBuyerMaker();
   SelectBuyerMaker slkByrMkrShip2 = new SelectBuyerMaker();
   JScrollPane jScrollPane2 = new JScrollPane();
   JTextArea txtAreaVessel = new JTextArea();
   SelectBuyerMaker slkByrMkrXprAgnt = new SelectBuyerMaker();
   boolean isProcessingExit=false;
   public  BlueBkgWhiteCharLabel lblTItleBar = new BlueBkgWhiteCharLabel();
   JComboBox cbxPort = new JComboBox();
   JComboBox cbxShipAgent = new JComboBox();
   String CenterCode=null;
   public static java.util.Vector branches;
   static java.text.DateFormat dateformat=new java.text.SimpleDateFormat("yyyy/MM/dd");
   public JLabel lblShipStaff = new JLabel();
   public JTextField txtShipStaffCode = new JTextField();
   JPanel jPanel5 = new JPanel();
   TitledBorder titledBorder3;
   Border border4;
   TitledBorder titledBorder4;
   Border border5;
   TitledBorder titledBorder5;
   JLabel jLabel1119 = new JLabel();
   public JTextField txtShip_Ic_Year = new JTextField();
   JLabel jLabel210 = new JLabel();
   JTextField txtShipVia = new JTextField();
   JPanel jPanel7 = new JPanel();
   JPanel PnlSpecInstruc = new JPanel();
   TitledBorder titledBorder6;
   Border border6;
   TitledBorder titledBorder7;
   BorderLayout borderLayout3 = new BorderLayout();
   JScrollPane jScrollPane5 = new JScrollPane();
   JTextArea txtSpecInstruc = new JTextArea();
   Border border7;
   TitledBorder titledBorder8;
   JLabel jLabel111 = new JLabel();
   JComboBox cbxPriceTermDest = new JComboBox();
   JLabel jLabel1112 = new JLabel();
   JComboBox cbxShipDest = new JComboBox();
   JLabel jLabel116 = new JLabel();
   JComboBox cbxPaymentTerm = new JComboBox();
   public final static String JBUTTON_CAPTION_INI_BY_LATTER_PRODUCTION="Get Default Value";
   public final static int COLUMN_INDEX_ship_agent=7;
   public final static int COLUMN_INDEX_ship_prc_trm=39;
   public final static int COLUMN_INDEX_ship_prx_term_dest=61;
   public final static int COLUMN_INDEX_SHIP_PAYMENT_TERM=62;
   public final static int COLUMN_INDEX_ship_dest=40;
   public final static int COLUMN_INDEX_ship_USA_port=15;
   public final static int COLUMN_INDEX_ship_ic_div=28;
   public final static int COLUMN_INDEX_ship_ic_sea=27;
   public final static int COLUMN_INDEX_ship_bill_to=37;
   public final static int COLUMN_INDEX_ship_ship_to=38;
   JPanel PnlRiskOf = new JPanel();
   JPanel Pnl_manufacture = new JPanel();
   TitledBorder titledBorder9;
   Border border8;
   TitledBorder titledBorder10;
   JScrollPane jScrollPane7 = new JScrollPane();
   JTextArea txtShipManufacture = new JTextArea();
   static int index_of_division;
   static int index_of_bill2;
   static int index_of_ship2;
   JPanel pnl2PlaceShipRmk = new JPanel();
   BorderLayout borderLayout1 = new BorderLayout();
   JTextArea txtareaShippingMark = new JTextArea();
   JScrollPane jScrollPane3 = new JScrollPane();
   JButton btnCpyShipRmkFromOtherSRN = new JButton();
   JButton btnCpySpecialInstructionFromOtherSRN = new JButton();
   JPanel jPanel8 = new JPanel();
   JScrollPane jScrollPane4 = new JScrollPane();
   JTextArea txtShipSRNremark = new JTextArea();
   JButton btnCopySRNDescFromOtherSRN = new JButton();
   exgui.DataBindJCombobox dbCbxShipOrg=null;
   JButton btnGenDefaultSrnDesc = new JButton();
   */
    //----------END ORG SHIP HEAD GUI-------------


  //------------guis for NTFE's Ship head-----------------
  JComboBox cbxShipFinalDest = new JComboBox();
  JTextField txtFowarderName = new JTextField();
  JLabel jLabel11110 = new JLabel();
  //JTextField txtAuthoriseSignaturePerson = new JTextField();
  JTextField txtAuthoriseSignaturePersonTitle=new JTextField();
  JComboBox cbxAuthoriseSignaturePerson = new JComboBox();

  //JTextField txtConsignEE = new JTextField(),
  JTextField txtShipFtyLC=new JTextField();
  JLabel lblAxSgPerson = new JLabel();

  JLabel lblAxSgPersonTitle = new JLabel();
  TitledBorder titledBorder11;
  JLabel jLabel11113 = new JLabel();

  JLabel jLabeMID = new JLabel();

  JTextField txtNtfeMid=new JTextField();


  JScrollPane jScrollPnl4IcDesc = new JScrollPane();
  JTextArea txtAreaICDesc = new JTextArea();
  JLabel jLabel16=new JLabel();
  JLabel lblStartSign = new JLabel();
  JLabel lblIcInvType = new JLabel();
  boolean isDoingGuiBinding=false;
  JLabel lblFretTerm = new JLabel();
  //JTextField txtFrtTrm = new JTextField();
  JComboBox cbxFrtTrm = new JComboBox();
  JLabel lblBankDtl = new JLabel();
  JTextField txtBankDtl = new JTextField();
  static java.util.Vector vctFreightTerm;
  static java.util.Vector vctPW_ManufactureDetail;
  static JComboBox cbxMfxBy=null;
  JButton btnGetShippingMark = new JButton();
  int po_buyer_seq;
  SelectBuyerMaker slkConsignee = new SelectBuyerMaker();
  JLabel lblConsignEE = new JLabel();
  JLabel lblSupplier = new JLabel();
  SelectBuyerMaker slkSupplier = new SelectBuyerMaker();
  JButton btnSlkMESSERS = new JButton();
  JButton btnSlkMANUFACTURER = new JButton();
  MyBuyerSelector slkMessers = new MyBuyerSelector();
  MyBuyerSelector slkManufacturor = new MyBuyerSelector();
  JTextField txtTotalCarton = new JTextField();
  JLabel lblTotalCarton = new JLabel();
  JLabel jLabel1120 = new JLabel();
  JComboBox cbxOtherPaymentTerm = new JComboBox();
  public PnlShipMasterPWBW() {
    //super();
    try{
    jbInit();
    afterJbinit();
    CenterCode=util.MiscFunc.Replace((String)util.PublicVariable.USER_RECORD.get("usr_cen_code"),"'","''");
    recordColumnsToCopy=null;
    }catch(Exception e){
      e.printStackTrace();
    }
  }
  protected void afterJbinit(){


    jLabel1120.setBackground(new Color(143, 143, 188));
    jLabel1120.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel1120.setForeground(Color.white);
    jLabel1120.setOpaque(true);
    jLabel1120.setHorizontalAlignment(SwingConstants.CENTER);
    jLabel1120.setText("OTHER PAYMENT TERM:");
    jLabel1120.setBounds(new Rectangle(523, 242, 144, 20));
    this.add(jLabel1120, null);

    txtTotalCarton.setBounds(new Rectangle(603, 26, 121, 20));
    txtTotalCarton.setText("");
    lblTotalCarton.setBounds(new Rectangle(487, 26, 116, 20));
    lblTotalCarton.setText(" TOTAL CARTON #:");
    lblTotalCarton.setHorizontalAlignment(SwingConstants.LEFT);
    lblTotalCarton.setOpaque(true);
    lblTotalCarton.setForeground(new Color(10,36,106));
    lblTotalCarton.setFont(new java.awt.Font("Dialog", 1, 12));
    lblTotalCarton.setBackground(new Color(143, 143, 188));

    jPanel3.add(txtTotalCarton, null);
    jPanel3.add(lblTotalCarton, null);

    btnSlkMANUFACTURER.setText("...");
    btnSlkMANUFACTURER.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnSlkMANUFACTURER_actionPerformed(e);
      }
    });
    btnSlkMANUFACTURER.setFont(new java.awt.Font("Dialog", 1, 11));
    btnSlkMANUFACTURER.setBounds(new Rectangle(311, 13, 71, 20));

    btnSlkMESSERS.setBounds(new Rectangle(305, 12, 71, 20));
    btnSlkMESSERS.setFont(new java.awt.Font("Dialog", 1, 11));
    btnSlkMESSERS.setText("...");
    btnSlkMESSERS.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnSlkMESSERS_actionPerformed(e);
      }
    });


    jLabel1113.setBounds(new Rectangle(498, 56, 96, 22));
    jLabel1113.setText(" DESTINATION :");
    jLabel1113.setHorizontalAlignment(SwingConstants.LEFT);
    jLabel1113.setOpaque(true);
    jLabel1113.setForeground(new Color(10,36,106));
    jLabel1113.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel1113.setBackground(new Color(143, 143, 188));
    cbxShipFinalDest.setBounds(new Rectangle(593, 56, 164, 22));
    txtFowarderName.setBounds(new Rectangle(120, 342, 241, 20));
    txtFowarderName.setText("");
    jLabel11110.setBounds(new Rectangle(3, 342, 118, 20));
    jLabel11110.setText(" Forwarder Name :");
    jLabel11110.setHorizontalAlignment(SwingConstants.LEFT);
    jLabel11110.setOpaque(true);
    jLabel11110.setForeground(new Color(10,36,106));
    jLabel11110.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel11110.setBackground(new Color(143, 143, 188));


    lblAxSgPerson.setBackground(new Color(143, 143, 188));
    lblAxSgPerson.setFont(new java.awt.Font("Dialog", 1, 12));
    lblAxSgPerson.setForeground(new Color(10,36,106));
    lblAxSgPerson.setOpaque(true);
    lblAxSgPerson.setHorizontalAlignment(SwingConstants.LEFT);
    lblAxSgPerson.setText(" AuthoriseSignature Person :");
    //lblAxSgPerson.setBounds(new Rectangle(1, 342, 181, 20));
    lblAxSgPerson.setBounds(new Rectangle(363, 364, 201, 20));
    //txtAuthoriseSignaturePerson.setText("");
    //txtAuthoriseSignaturePerson.setBounds(new Rectangle(182, 342, 178, 20));
    cbxAuthoriseSignaturePerson.setBounds(new Rectangle(564, 364, 201, 20));


    //lblAxSgPersonTitle.setBounds(new Rectangle(363, 342, 201, 20));
    lblAxSgPersonTitle.setBounds(new Rectangle(363, 388, 201, 20));
    lblAxSgPersonTitle.setText(" AuthoriseSignature Person Title:");
    lblAxSgPersonTitle.setHorizontalAlignment(SwingConstants.LEFT);
    lblAxSgPersonTitle.setOpaque(true);
    lblAxSgPersonTitle.setForeground(new Color(10,36,106));
    lblAxSgPersonTitle.setFont(new java.awt.Font("Dialog", 1, 12));
    lblAxSgPersonTitle.setBackground(new Color(143, 143, 188));

    txtAuthoriseSignaturePersonTitle.setBounds(new Rectangle(564, 388, 201, 20));
    txtAuthoriseSignaturePersonTitle.setText("");

    //jLabeMID.setBounds(new Rectangle(363, 366, 201, 20));
    jLabeMID.setBounds(new Rectangle(363, 412, 201, 20));
    jLabeMID.setText(" MANUFACTURER ID:");
    jLabeMID.setHorizontalAlignment(SwingConstants.LEFT);
    jLabeMID.setOpaque(true);
    jLabeMID.setForeground(new Color(10,36,106));
    jLabeMID.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabeMID.setBackground(new Color(143, 143, 188));

    //lblConsignEE.setBounds(new Rectangle(363, 390, 201, 20));


    //txtNtfeMid.setBounds(new Rectangle(564, 366, 201, 20));
    txtNtfeMid.setBounds(new Rectangle(564, 412, 201, 20));
    txtNtfeMid.setText("");



    //jLabel11113.setBounds(new Rectangle(3, 366, 105, 64));
    jLabel11113.setBounds(new Rectangle(3, 366, 88, 64));
    jLabel11113.setText("<html><body> I.C.<br>Description</body<</html>");
    jLabel11113.setHorizontalAlignment(SwingConstants.CENTER);
    jLabel11113.setHorizontalTextPosition(SwingConstants.CENTER);
    jLabel11113.setOpaque(true);
    jLabel11113.setForeground(new Color(10,36,106));
    jLabel11113.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel11113.setBackground(new Color(143, 143, 188));


    //jScrollPnl4IcDesc.setBounds(new Rectangle(108, 366, 252, 63));
    jScrollPnl4IcDesc.setBounds(new Rectangle(92, 366, 270, 64));
    txtAreaICDesc.setText("");
    jPanel2.add(jLabel1113, null);
    jPanel2.add(cbxShipFinalDest, null);


    this.add(jLabel11113, null);
    this.add(jScrollPnl4IcDesc, null);
    jScrollPnl4IcDesc.getViewport().add(txtAreaICDesc, null);
    txtShipFtyLC.setBounds(new Rectangle(326, 7, 170, 20));
    jLabel16.setBounds(new Rectangle(249, 7, 77, 20));
    jLabel16.setText("FTY L/C#:");
    jLabel16.setHorizontalAlignment(SwingConstants.LEFT);
    jLabel16.setOpaque(true);
    jLabel16.setForeground(Color.white);
    jLabel16.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel16.setBackground(new Color(143, 143, 188));
    jPanel2.add(jLabel16, null);
    jPanel2.add(txtShipFtyLC, null);
    lblShipStaff.setVisible(false);
    txtShipStaffCode.setVisible(false);

    lblStartSign.setBackground(new Color(143, 143, 188));
    lblStartSign.setFont(new java.awt.Font("Dialog", 1, 14));
    lblStartSign.setForeground(Color.red);
    lblStartSign.setOpaque(true);
    lblStartSign.setHorizontalAlignment(SwingConstants.RIGHT);
    lblStartSign.setHorizontalTextPosition(SwingConstants.RIGHT);
    lblStartSign.setText("* ");
    lblStartSign.setBounds(new Rectangle(277-20, 242, 18, 20));

    //20060705--add field ship_FRET_TERM,ship_BNK_DTL
    lblFretTerm.setBounds(new Rectangle(3, 320, 118, 20));
    lblFretTerm.setText("Freight Term:");
    lblFretTerm.setHorizontalAlignment(SwingConstants.CENTER);
    lblFretTerm.setOpaque(true);
    lblFretTerm.setForeground(Color.white);
    lblFretTerm.setFont(new java.awt.Font("Dialog", 1, 12));
    lblFretTerm.setBackground(new Color(143, 143, 188));
    //cbxFrtTrm.setText("");
    cbxFrtTrm.setBounds(new Rectangle(120, 320, 147, 20));
    lblBankDtl.setBackground(new Color(143, 143, 188));
    lblBankDtl.setFont(new java.awt.Font("Dialog", 1, 12));
    lblBankDtl.setForeground(Color.white);
    lblBankDtl.setOpaque(true);
    lblBankDtl.setHorizontalAlignment(SwingConstants.CENTER);
    lblBankDtl.setText("Bank Details:");
    lblBankDtl.setBounds(new Rectangle(363, 342, 89, 20));
    txtBankDtl.setText("");
    txtBankDtl.setBounds(new Rectangle(452, 342, 312, 20));

    slkMessers.setBounds(new Rectangle(259, 13, 37, 13));
    PnlRiskOf.add(btnSlkMESSERS, null);
    PnlRiskOf.add(slkMessers, null);

    Pnl_manufacture.add(btnSlkMANUFACTURER, null);

    this.add(lblStartSign, null);
    this.add(jLabel11110, null);
    this.add(txtFowarderName, null);
    this.add(lblFretTerm, null);
    this.add(cbxFrtTrm, null);
    this.add(lblAxSgPerson, null);
    this.add(lblAxSgPersonTitle, null);
    this.add(jLabeMID, null);
    this.add(txtNtfeMid, null);
    this.add(txtAuthoriseSignaturePersonTitle, null);
    this.add(cbxAuthoriseSignaturePerson, null);
    this.add(lblBankDtl, null);
    this.add(txtBankDtl, null);
    this.add(lblConsignEE, null);
    slkConsignee.init(null,null,slkConsignee.TYPE_CONSIGNEE,true);
    slkConsignee.setBounds(new Rectangle(363, 321, 140, 20));

    lblConsignEE.setBounds(new Rectangle(271, 321, 92, 19));
    lblConsignEE.setText(" CONSIGNEE :");
    lblConsignEE.setHorizontalAlignment(SwingConstants.LEFT);
    lblConsignEE.setOpaque(true);
    lblConsignEE.setForeground(new Color(10,36,106));
    lblConsignEE.setFont(new java.awt.Font("Dialog", 1, 12));
    lblConsignEE.setBackground(new Color(143, 143, 188));
    lblSupplier.setBackground(new Color(143, 143, 188));
    lblSupplier.setFont(new java.awt.Font("Dialog", 1, 12));
    lblSupplier.setForeground(Color.white);
    lblSupplier.setOpaque(true);
    lblSupplier.setHorizontalAlignment(SwingConstants.LEFT);
    lblSupplier.setText(" SUPPLIER:");
    lblSupplier.setBounds(new Rectangle(505, 321, 71, 19));

    this.add(slkConsignee, null);
    this.add(lblSupplier, null);
    slkSupplier.setBounds(new Rectangle(578, 321, 187, 20));
    this.add(slkSupplier, null);
    this.add(PnlShipExtra, null);
    lblIcInvType.setBackground(new Color(142, 142, 188));
    lblIcInvType.setFont(new java.awt.Font("Dialog", 1, 11));
    lblIcInvType.setForeground(Color.white);
    lblIcInvType.setOpaque(true);
    lblIcInvType.setText(" TYPE:");
    lblIcInvType.setBounds(new Rectangle(566, 26, 194, 20));
    jPanel1.add(lblIcInvType, null);

    btnGetShippingMark.setBounds(new Rectangle(238, 12, 133, 22));
    btnGetShippingMark.setText("Get Shipping Mark");
    btnGetShippingMark.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnGetShippingMark_actionPerformed(e);
      }
    });
    jPanel5.add(btnGetShippingMark, null);
    this.add(jPanel7, null);
    this.add(Pnl_manufacture, null);

    slkManufacturor.setBounds(new Rectangle(256, 16, 44, 13));
    slkManufacturor.init(null,null,slkManufacturor.TYPE_MANUFACTURER,true);
    Pnl_manufacture.add(slkManufacturor, null);
    cbxAuthoriseSignaturePerson.addItemListener(new AuthSigModified());
    slkMessers.setVisible(false);
    slkMessers.setModifyNotifyTo(new Notify_MesserSelect());
    slkMessers.init(null,null,slkMessers.TYPE_MESSERS,true);
    slkManufacturor.setVisible(false);
    slkManufacturor.setModifyNotifyTo(new Notify_ManuFactureSelect());
    cbxOtherPaymentTerm.setBounds(new Rectangle(667, 242, 102, 20));
    this.add(cbxOtherPaymentTerm, null);
    cbxOtherPaymentTerm.setEditable(true);
  }
  class Notify_MesserSelect implements newtimes.preproduction.buyermakerselect.BuyerMakerChanged{
    public void changeBuyerMaker(database.datatype.Record messerRecord){
      makeTextContext(txtRiskOf ,messerRecord);
    }
  }
  class Notify_ManuFactureSelect implements newtimes.preproduction.buyermakerselect.BuyerMakerChanged{
    public void changeBuyerMaker(database.datatype.Record mfxRecord){
      makeTextContext(txtShipManufacture,mfxRecord);
      if(mfxRecord!=null){
        try{
          Record rec =
              (Record)
              exgui2.CONST.BASIC_MAIN_EJB.getDatas(
              util.PublicVariable.USER_RECORD,
              "select BYMKR_OLD from buyer_maker where BYMKR_SEQ=" +
              mfxRecord.getInt(0), 1, 1).get(0);
          String manufacturerId=(String)rec.get(0);
          txtNtfeMid.setText((manufacturerId==null)?"":manufacturerId);
        }catch(Exception exp){
          exp.printStackTrace();
        }
      }else{
        txtNtfeMid.setText("");
      }
    }
  }

  class MfxBy_Popoutlistener implements javax.swing.event.PopupMenuListener{
      public void popupMenuCanceled(javax.swing.event.PopupMenuEvent e) {

      }

      public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent e){

      }
      public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent e){

      }
  }
  class AuthSigModified  implements java.awt.event.ItemListener {
    public void itemStateChanged(java.awt.event.ItemEvent ie){
      if(isDoingGuiBinding)return;
      String sigTitleString=
          (String)newtimes.shipping_admin.ShippingAdmin_Const.hmSignatureTitle.get(
          cbxAuthoriseSignaturePerson.getSelectedItem());

      txtAuthoriseSignaturePersonTitle.setText((sigTitleString==null)?"":sigTitleString);
    }
  }
  protected void cbxMfxBy_itemStateChanged(ItemEvent e) {
     cbxMfxBy.setToolTipText(cbxMfxBy.getSelectedItem().toString());
     txtShipManufacture.setText(cbxMfxBy.getSelectedItem().toString());
   }

  protected void jbInit(){

    btnCpyShipRmkFromOtherSRN = new JButton();
    btnCopySRNDescFromOtherSRN= new JButton();
    btnCpySpecialInstructionFromOtherSRN = new JButton();

    border1 = BorderFactory.createEtchedBorder(Color.white,new Color(148, 145, 140));
    border2 = BorderFactory.createBevelBorder(BevelBorder.RAISED,Color.white,Color.white,new Color(103, 101, 98),new Color(148, 145, 140));
    titledBorder1 = new TitledBorder(new EtchedBorder(EtchedBorder.RAISED,Color.white,new Color(148, 145, 140)),"EXTRA");
    border3 = new EtchedBorder(EtchedBorder.RAISED,Color.white,new Color(148, 145, 140));
    titledBorder2 = new TitledBorder(border3,"EXTRA");
    //lblTitleBar.setText("Shipping SRN ADD");
    //lblTitleBar.setBounds(new Rectangle(0, 4, 801, 25));
    titledBorder3 = new TitledBorder("");
    border4 = BorderFactory.createBevelBorder(BevelBorder.LOWERED,Color.white,Color.white,new Color(98, 98, 109),new Color(141, 141, 156));
    titledBorder4 = new TitledBorder(new EtchedBorder(EtchedBorder.RAISED,Color.white,new Color(141, 141, 156)),"SHIPPING MARK");
    border5 = new EtchedBorder(EtchedBorder.RAISED,Color.white,new Color(141, 141, 156));
    titledBorder5 = new TitledBorder(border5,"SRN DESCRIPTION");
    titledBorder6 = new TitledBorder("");
    border6 = BorderFactory.createBevelBorder(BevelBorder.LOWERED,Color.white,Color.white,new Color(103, 101, 98),new Color(148, 145, 140));
    titledBorder7 = new TitledBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED,Color.white,Color.white,new Color(103, 101, 98),new Color(148, 145, 140)),"L/C Buyer");
    border7 = BorderFactory.createBevelBorder(BevelBorder.LOWERED,Color.white,Color.white,new Color(103, 101, 98),new Color(148, 145, 140));
    titledBorder8 = new TitledBorder(border7,"SPECIAL INSTRUCTION");
    titledBorder9 = new TitledBorder("");
    border8 = BorderFactory.createEtchedBorder(Color.white,new Color(148, 145, 140));
    titledBorder10 = new TitledBorder(border8,"MANUFACTURE BY");
    titledBorder11 = new TitledBorder("");
    this.setLayout(null);
    /**@todo Implement this processhandler.template.PnlFieldsEditor abstract method*/
    jLabel23.setBounds(new Rectangle(4, 26, 89, 20));
    jLabel23.setText(" Season :");
    jLabel23.setHorizontalAlignment(SwingConstants.LEFT);
    jLabel23.setOpaque(true);
    jLabel23.setForeground(new Color(10, 36, 106));
    jLabel23.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel23.setBackground(new Color(143, 143, 188));
    jPanel3.setBounds(new Rectangle(1, 266, 766, 54));
    jPanel3.setLayout(null);
    jPanel3.setBackground(new Color(204, 204, 225));
    jLabel25.setBounds(new Rectangle(247, 3, 101, 20));
    jLabel25.setText(" Invoice Date :");
    jLabel25.setHorizontalAlignment(SwingConstants.LEFT);
    jLabel25.setOpaque(true);
    jLabel25.setForeground(Color.white);
    jLabel25.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel25.setBackground(new Color(143, 143, 188));
    //txtDes.setBounds(new Rectangle(167, 240, 209, 20));
    //txtTo.setBounds(new Rectangle(583, 33, 180, 20));
    //txtVia.setBounds(new Rectangle(583, 79, 180, 20));
    jLabel121.setBackground(new Color(143, 143, 188));
    jLabel121.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel121.setForeground(Color.white);
    jLabel121.setOpaque(true);
    jLabel121.setHorizontalAlignment(SwingConstants.LEFT);
    jLabel121.setText(" Division :");
    jLabel121.setBounds(new Rectangle(487, 1, 63, 20));
    jLabel110.setBackground(new Color(143, 143, 188));
    jLabel110.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel110.setForeground(Color.white);
    jLabel110.setOpaque(true);
    jLabel110.setHorizontalAlignment(SwingConstants.LEFT);
    jLabel110.setText(" Factory INV #  :");
    jLabel110.setBounds(new Rectangle(4, 4, 89, 20));
    jPanel1.setBackground(new Color(202, 202, 225));
    jPanel1.setBorder(border1);
    //jPanel1.setBounds(new Rectangle(1, 35, 766, 64));
      jPanel1.setBounds(new Rectangle(1, 30, 766, 69));

    jPanel1.setLayout(null);
    jLabel26.setBackground(new Color(143, 143, 188));
    jLabel26.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel26.setForeground(new Color(10,36,106));
    jLabel26.setOpaque(true);
    jLabel26.setHorizontalAlignment(SwingConstants.LEFT);
    jLabel26.setText(" Ship to :");
    jLabel26.setBounds(new Rectangle(474, 4, 76, 20));
    jLabel19.setBackground(new Color(143, 143, 188));
    jLabel19.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel19.setForeground(new Color(10,36,106));
    jLabel19.setOpaque(true);
    jLabel19.setRequestFocusEnabled(true);
    jLabel19.setHorizontalAlignment(SwingConstants.LEFT);
    jLabel19.setText(" Issue Date :");
    jLabel19.setBounds(new Rectangle(3, 5, 93, 20));
    //jLabel27.setBounds(new Rectangle(2, 34, 92, 20));
    //jLabel27.setBounds(new Rectangle(4, 27, 127, 17));
    jLabel27.setBounds(new Rectangle(2, 26, 126, 20));
    jLabel27.setText(" Price Term :");
    jLabel27.setHorizontalAlignment(SwingConstants.LEFT);
    jLabel27.setOpaque(true);
    jLabel27.setForeground(Color.white);
    jLabel27.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel27.setBackground(new Color(143, 143, 188));
    jLabel125.setBounds(new Rectangle(189, 4, 88, 20));
    jLabel125.setText(" Bill to :");
    jLabel125.setHorizontalAlignment(SwingConstants.LEFT);
    jLabel125.setOpaque(true);
    jLabel125.setForeground(new Color(10,36,106));
    jLabel125.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel125.setBackground(new Color(143, 143, 188));
    //cbxShipPrcTerm.setBounds(new Rectangle(94, 34, 124, 20));
    //cbxShipPrcTerm.setBounds(new Rectangle(130, 27, 153, 19));
    cbxShipPrcTerm.setBounds(new Rectangle(128, 26, 154, 20));
    cbxShipPrcTerm.setBackground(Color.white);
    txtShipDate.setText("");
    txtShipDate.setBounds(new Rectangle(94, 5, 85, 20));
    jPanel2.setBackground(new Color(204, 204, 225));
    jPanel2.setBorder(BorderFactory.createEtchedBorder());
    jPanel2.setBounds(new Rectangle(1, 98, 766, 142));
    jPanel2.setLayout(null);
    //cmboExpFowr.setBounds(new Rectangle(322, 36, 117, 20));
    //cmboExpFowr.setBackground(Color.white);
    jLabel117.setBounds(new Rectangle(3, 55, 58, 75));
    jLabel117.setText(" Vessel :");
    jLabel117.setHorizontalAlignment(SwingConstants.LEFT);
    jLabel117.setOpaque(true);
    jLabel117.setForeground(new Color(10,36,106));
    jLabel117.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel117.setBackground(new Color(143, 143, 188));
    jLabel9.setBounds(new Rectangle(527, 83, 56, 20));
    jLabel9.setText(" Agent :");
    jLabel9.setHorizontalAlignment(SwingConstants.LEFT);
    jLabel9.setOpaque(true);
    jLabel9.setForeground(Color.white);
    jLabel9.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel9.setBackground(new Color(143, 143, 188));
    txtMAWB.setBounds(new Rectangle(583, 171, 180, 20));
    txtMAWB.setBounds(new Rectangle(282, 30, 171, 20));
    jLabel20.setBackground(new Color(143, 143, 188));
    jLabel20.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel20.setForeground(Color.white);
    jLabel20.setOpaque(true);
    jLabel20.setHorizontalAlignment(SwingConstants.LEFT);
    jLabel20.setText("Ship Mode:");
    jLabel20.setBounds(new Rectangle(2, 30, 81, 20));
    jLabel115.setBackground(new Color(143, 143, 188));
    jLabel115.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel115.setForeground(Color.white);
    jLabel115.setOpaque(true);
    jLabel115.setHorizontalAlignment(SwingConstants.LEFT);
    jLabel115.setText(" HAWB / HBL# :");
    jLabel115.setBounds(new Rectangle(493, 30, 103, 20));
    txtFLT.setBounds(new Rectangle(583, 194, 180, 20));
    txtFLT.setBounds(new Rectangle(312, 58, 164, 20));
    jLabel10.setBackground(new Color(143, 143, 188));
    jLabel10.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel10.setForeground(Color.white);
    jLabel10.setOpaque(true);
    jLabel10.setHorizontalAlignment(SwingConstants.LEFT);
    jLabel10.setText("Buyer L/C#:");
    jLabel10.setBounds(new Rectangle(3, 7, 88, 20));
    //txtAgent.setBounds(new Rectangle(214, 125, 180, 20));
    //txtAgent.setBounds(new Rectangle(552, 4, 209, 20));
    txtHAWB.setBounds(new Rectangle(583, 148, 180, 20));
    txtHAWB.setBounds(new Rectangle(595, 30, 170, 20));
    //cmboExpAgent.setBounds(new Rectangle(88, 36, 97, 20));
    //cmboExpAgent.setBackground(Color.white);
    jLabel1110.setBackground(new Color(143, 143, 188));
    jLabel1110.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel1110.setForeground(new Color(10,36,106));
    jLabel1110.setOpaque(true);
    jLabel1110.setHorizontalAlignment(SwingConstants.LEFT);
    jLabel1110.setText(" FLT# :");
    jLabel1110.setBounds(new Rectangle(266, 58, 46, 20));
    //cmboOceanAir.setBounds(new Rectangle(356, 4, 109, 20));
    //cmboOceanAir.setBackground(Color.white);
    jLabel1111.setBounds(new Rectangle(188, 30, 94, 20));
    jLabel1111.setText(" MAWB / CBL# :");
    jLabel1111.setHorizontalAlignment(SwingConstants.LEFT);
    jLabel1111.setOpaque(true);
    jLabel1111.setForeground(Color.white);
    jLabel1111.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel1111.setBackground(new Color(143, 143, 188));
    jLabel112.setBounds(new Rectangle(264, 110, 129, 20));
    jLabel112.setText(" Port Of Discharge :");
    jLabel112.setHorizontalAlignment(SwingConstants.LEFT);
    jLabel112.setOpaque(true);
    jLabel112.setForeground(new Color(10,36,106));
    jLabel112.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel112.setBackground(new Color(143, 143, 188));
    //txtLC.setBounds(new Rectangle(214, 102, 180, 20));
    //txtLC.setBounds(new Rectangle(61, 4, 209, 20));
    txtShipLC.setBounds(new Rectangle(91, 7, 141, 20));
    cbxShipOcieanAir.setBounds(new Rectangle(83, 30, 96, 20));
    jLabel11.setBounds(new Rectangle(119, 242, 33, 20));
    jLabel11.setText("ETA");
    jLabel11.setHorizontalAlignment(SwingConstants.CENTER);
    jLabel11.setHorizontalTextPosition(SwingConstants.CENTER);
    jLabel11.setOpaque(true);
    jLabel11.setForeground(new Color(10,36,106));
    jLabel11.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel11.setBackground(new Color(143, 143, 188));
    txtShipETDdate.setText("");
    txtShipETDdate.setBounds(new Rectangle(45, 242, 73, 20));
    jLabel17.setBounds(new Rectangle(274, 242, 113, 20));
    jLabel17.setText("Country Of Origin:");
    jLabel17.setHorizontalAlignment(SwingConstants.CENTER);
    jLabel17.setOpaque(true);
    jLabel17.setForeground(new Color(10,36,106));
    jLabel17.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel17.setBackground(new Color(143, 143, 188));
    jLabel15.setBounds(new Rectangle(2, 242, 43, 20));
    jLabel15.setText(" * ETD:");
    jLabel15.setHorizontalAlignment(SwingConstants.LEFT);
    jLabel15.setOpaque(true);
    jLabel15.setForeground(new Color(10,36,106));
    jLabel15.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel15.setBackground(new Color(143, 143, 188));
    txtShipETAdate.setText("");
    txtShipETAdate.setBounds(new Rectangle(152, 242, 73, 20));
    cbxShipOrgCnty.setBounds(new Rectangle(387, 242, 135, 20));

    //jButton1.setBounds(new Rectangle(38, 601, 153, 24));
    //jButton1.setText("Edit Ship Extra");
    //jPanel5.setBounds(new Rectangle(14, 488, 771, 95));
    //jPanel5.setLayout(null);

    cbx_IC_Szn.setBackground(Color.white);
    cbx_IC_Szn.setBounds(new Rectangle(92, 26, 146, 20));
    txt_FTY_Inv.setBounds(new Rectangle(168, 42, 589, 20));
    txt_FTY_Inv.setBounds(new Rectangle(92, 4, 147, 20));
    cbx_IC_Div.setBackground(Color.white);
    cbx_IC_Div.setBounds(new Rectangle(547, 1, 122, 20));
    txtShip_IC_date.setBounds(new Rectangle(168, 71, 54, 20));
    txtShip_IC_date.setText("");
    txtShip_IC_date.setBounds(new Rectangle(347, 3, 85, 20));
    PnlShipExtra.setBackground(new Color(202, 202, 224));
    PnlShipExtra.setBorder(titledBorder1);
    PnlShipExtra.setBounds(new Rectangle(0, 809, 768, 147));
    PnlShipExtra.setLayout(null);
    btnEditShipExtra.setBounds(new Rectangle(13, 19, 114, 45));
    btnEditShipExtra.setFont(new java.awt.Font("Dialog", 1, 11));
    btnEditShipExtra.setHorizontalAlignment(SwingConstants.CENTER);
    btnEditShipExtra.setText("<html><body>EDIT<br> EXTRA Data</body></html>");

    java.awt.event.ActionListener toListen[]= btnEditShipExtra.getActionListeners();
    for(int i=0;i<toListen.length;i++){
      System.out.println("toListen["+i+"] is "+toListen[i].toString());
      btnEditShipExtra.removeActionListener(toListen[i]);
    }

    btnEditShipExtra.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnEditShipExtra_actionPerformed(e);
      }
    });
    jScrollPane1.setBounds(new Rectangle(137, 16, 599, 118));
    txtAreaShipExtra.setText("");
    slkByrMkr_Bill2.setBounds(new Rectangle(278, 4, 189, 20));
    slkByrMkrShip2.setBounds(new Rectangle(551, 4, 173, 21));
    jScrollPane2.setBounds(new Rectangle(60, 55, 205, 74));
    txtAreaVessel.setLineWrap(true);
    lblTItleBar.setText("SRN DATA");
    lblTItleBar.setBounds(new Rectangle(1, 4, 771, 25));
    cbxPort.setBounds(new Rectangle(392, 110, 166, 21));
    cbxShipAgent.setBounds(new Rectangle(583, 83, 174, 21));
    lblShipStaff.setBounds(new Rectangle(264, 84, 128, 20));
    lblShipStaff.setText(" Shipp Staff Code :");
    lblShipStaff.setHorizontalAlignment(SwingConstants.LEFT);
    lblShipStaff.setOpaque(true);
    lblShipStaff.setForeground(new Color(10,36,106));
    lblShipStaff.setFont(new java.awt.Font("Dialog", 1, 12));
    lblShipStaff.setBackground(new Color(143, 143, 188));
    txtShipStaffCode.setText("");
    txtShipStaffCode.setBounds(new Rectangle(392, 84, 134, 20));

    jPanel5.setBackground(new Color(202, 202, 224));
    jPanel5.setBorder(titledBorder4);
    jPanel5.setDebugGraphicsOptions(0);
    jPanel5.setBounds(new Rectangle(0, 435, 380, 169));
    jPanel5.setLayout(null);

    /*
    jPanel5.setBackground(new Color(202, 202, 224));
    jPanel5.setBorder(titledBorder4);
    jPanel5.setDebugGraphicsOptions(0);
    jPanel5.setBounds(new Rectangle(0, 435, 380, 137));
    jPanel5.setLayout(borderLayout1);
    */
    txtareaShippingMark.setText("");
    /*
    jPanel6.setBackground(new Color(202, 202, 224));
    jPanel6.setBorder(titledBorder5);
    jPanel6.setBounds(new Rectangle(385, 435, 389, 111));
    jPanel6.setLayout(borderLayout2);
    */

    txtShipSRNremark.setText("");
    //jPanel3.add(txtInv, null);
    //jPanel3.add(txtIC_Y, null);
    //jPanel3.add(cmboDiv, null);
    //jPanel3.add(cmboSeason, null);
    jLabel1119.setBackground(new Color(143, 143, 188));
    jLabel1119.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel1119.setForeground(new Color(10,36,106));
    jLabel1119.setOpaque(true);
    jLabel1119.setHorizontalAlignment(SwingConstants.LEFT);
    jLabel1119.setText(" YEAR :");
    jLabel1119.setBounds(new Rectangle(246, 26, 101, 20));
    txtShip_Ic_Year.setText("");
    txtShip_Ic_Year.setBounds(new Rectangle(346, 26, 135, 20));
    jLabel210.setBounds(new Rectangle(562, 108, 49, 20));
    jLabel210.setText("VIA :");
    jLabel210.setHorizontalAlignment(SwingConstants.CENTER);
    jLabel210.setHorizontalTextPosition(SwingConstants.CENTER);
    jLabel210.setOpaque(true);
    jLabel210.setForeground(Color.white);
    jLabel210.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel210.setBackground(new Color(143, 143, 188));
    txtShipVia.setText("");
    txtShipVia.setBounds(new Rectangle(611, 108, 118, 20));
    jPanel7.setBackground(new Color(204, 204, 225));
    jPanel7.setBounds(new Rectangle(1, 571, 379, 189));
    jPanel7.setLayout(null);
    /*
    PnlSpecInstruc.setBackground(new Color(204, 204, 225));
    PnlSpecInstruc.setBorder(titledBorder8);
    PnlSpecInstruc.setBounds(new Rectangle(4, 0, 374, 185));
    PnlSpecInstruc.setLayout(borderLayout3);
    */
    PnlSpecInstruc.setBackground(new Color(204, 204, 225));
    PnlSpecInstruc.setBorder(null);
    PnlSpecInstruc.setBounds(new Rectangle(4, 39, 374, 146));
    PnlSpecInstruc.setLayout(borderLayout3);

    txtSpecInstruc.setText("");
    //jLabel111.setBounds(new Rectangle(224, 31, 126, 20));
    //jLabel111.setBounds(new Rectangle(4, 45, 126, 20));
    jLabel111.setBounds(new Rectangle(284, 26, 126, 20));
    jLabel111.setText(" PRICE TERM DEST.");
    jLabel111.setHorizontalAlignment(SwingConstants.LEFT);
    jLabel111.setOpaque(true);
    jLabel111.setForeground(new Color(10, 36, 106));
    jLabel111.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel111.setBackground(new Color(143, 143, 188));
    //cbxPriceTermDest.setBounds(new Rectangle(350, 31, 154, 20));
    //cbxPriceTermDest.setBounds(new Rectangle(129, 45, 154, 20));
    cbxPriceTermDest.setBounds(new Rectangle(410, 26, 154, 20));
    jLabel1112.setBounds(new Rectangle(493, 7, 103, 20));
    jLabel1112.setText(" Loading Port :");
    jLabel1112.setHorizontalAlignment(SwingConstants.LEFT);
    jLabel1112.setOpaque(true);
    jLabel1112.setForeground(Color.white);
    jLabel1112.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel1112.setBackground(new Color(143, 143, 188));
    cbxShipDest.setBounds(new Rectangle(596, 7, 152, 20));
    //jLabel116.setBounds(new Rectangle(508, 32, 109, 20));
    //jLabel116.setBounds(new Rectangle(284, 27, 109, 20));
    jLabel116.setBounds(new Rectangle(3, 48, 109, 20));
    jLabel116.setText(" PAYMENT TERM:");
    jLabel116.setHorizontalAlignment(SwingConstants.LEFT);
    jLabel116.setOpaque(true);
    jLabel116.setForeground(Color.white);
    jLabel116.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel116.setBackground(new Color(143, 143, 188));
    //cbxPaymentTerm.setBounds(new Rectangle(617, 32, 145, 20));
    //cbxPaymentTerm.setBounds(new Rectangle(393, 27, 368, 20));
    cbxPaymentTerm.setBounds(new Rectangle(114, 48, 647, 20));
    PnlRiskOf.setBackground(new Color(204, 204, 225));
    PnlRiskOf.setBorder(titledBorder7);
    PnlRiskOf.setBounds(new Rectangle(385, 536, 389, 125));
    PnlRiskOf.setLayout(null);
    Pnl_manufacture.setBackground(new Color(202, 202, 224));
    Pnl_manufacture.setBorder(titledBorder10);
    Pnl_manufacture.setBounds(new Rectangle(382, 662, 389, 135));
    Pnl_manufacture.setLayout(null);
    txtShipManufacture.setText("");


    txtRiskOf.setText("");
    jScrollPane6.setBounds(new Rectangle(5, 32, 377, 84));
    jScrollPane7.setBounds(new Rectangle(6, 33, 377, 96));

    jScrollPane4.setBounds(new Rectangle(5, 31, 377, 65));




    jPanel3.add(jLabel110, null);
    jPanel3.add(txt_FTY_Inv, null);
    jPanel3.add(jLabel23, null);
    jPanel3.add(cbx_IC_Szn, null);
    jPanel3.add(jLabel25, null);
    jPanel3.add(jLabel1119, null);
    jPanel3.add(txtShip_Ic_Year, null);
    jPanel3.add(txtShip_IC_date, null);
    jPanel3.add(jLabel121, null);
    jPanel3.add(cbx_IC_Div, null);


    this.add(txtShipETDdate, null);
    this.add(jLabel15, null);
    this.add(jPanel3, null);
    //this.add(lblTitleBar, null);
    //cbxShipDest.setEditable(true);
    //cbxPort.setEditable(true);
    jPanel1.add(jLabel19, null);
    jPanel1.add(txtShipDate, null);
    jPanel1.add(jLabel116, null);
    jPanel1.add(cbxPaymentTerm, null);
    jPanel1.add(jLabel125, null);
    jPanel1.add(slkByrMkr_Bill2, null);
    jPanel1.add(jLabel26, null);
    jPanel1.add(slkByrMkrShip2, null);
    jPanel1.add(jLabel27, null);
    jPanel1.add(cbxShipPrcTerm, null);
    jPanel1.add(jLabel111, null);
    jPanel1.add(cbxPriceTermDest, null);
    this.add(jPanel2, null);
    this.add(lblTItleBar, null);
    //jPanel2.add(txtLC, null);
    //jPanel2.add(cmboOceanAir, null);
    //jPanel2.add(txtAgent, null);
    //jPanel2.add(cmboExpAgent, null);
    //jPanel2.add(cmboExpFowr, null);
    jPanel2.add(txtShipLC, null);
    jPanel2.add(jLabel10, null);

    //this.add(jPanel5, null);
    //this.add(jButton1, null);
    PnlShipExtra.add(jScrollPane1, null);
    PnlShipExtra.add(btnEditShipExtra, null);
    jScrollPane1.getViewport().add(txtAreaShipExtra, null);
    this.add(jPanel5, null);

    //jPanel5.add(jScrollPane3, BorderLayout.CENTER);
    //this.add(jPanel6, null);
    //jPanel6.add(jScrollPane4, BorderLayout.CENTER);
    jScrollPane3.getViewport().add(txtareaShippingMark, null);
    this.add(jPanel7, null);
    this.add(jPanel1, null);
    this.add(PnlShipExtra, null);
    jPanel2.add(jLabel20, null);
    jPanel2.add(cbxShipOcieanAir, null);
    jPanel2.add(jLabel117, null);
    jPanel2.add(jScrollPane2, null);
    jPanel2.add(jLabel1110, null);
    jPanel2.add(txtFLT, null);
    jPanel2.add(lblShipStaff, null);
    jPanel2.add(txtShipStaffCode, null);
    jPanel2.add(jLabel112, null);
    jPanel2.add(cbxPort, null);
    jPanel2.add(jLabel210, null);
    jPanel2.add(txtShipVia, null);
    jPanel2.add(jLabel1112, null);
    jPanel2.add(cbxShipDest, null);
    jPanel2.add(cbxShipAgent, null);
    jPanel2.add(jLabel9, null);
    jPanel2.add(jLabel1111, null);
    jPanel2.add(txtMAWB, null);
    jPanel2.add(jLabel115, null);
    jPanel2.add(txtHAWB, null);
    jScrollPane2.getViewport().add(txtAreaVessel, null);
    this.add(Pnl_manufacture, null);
    jScrollPane6.getViewport().add(txtRiskOf, null);
    PnlRiskOf.add(jScrollPane6, null);
    this.add(PnlRiskOf, null);


    btnCpyShipRmkFromOtherSRN.setBounds(new Rectangle(110, 12, 119, 21));
    btnCpyShipRmkFromOtherSRN.setFont(new java.awt.Font("Dialog", 1, 11));
    btnCpyShipRmkFromOtherSRN.setText("Copy From");

    txtAreaShipExtra.setFont(new java.awt.Font("DialogInput", 0, 12));
    txtAreaShipExtra.setEditable(false);
    txtareaShippingMark.setFont(new java.awt.Font("DialogInput", 0, 12));
    txtShipSRNremark.setFont(new java.awt.Font("DialogInput", 0, 12));

    jPanel5.add(pnl2PlaceShipRmk, null);
    pnl2PlaceShipRmk.setBounds(new Rectangle(4, 36, 370, 127));
    pnl2PlaceShipRmk.setLayout(borderLayout1);

    pnl2PlaceShipRmk.add(jScrollPane3, BorderLayout.CENTER);
    jPanel5.add(btnCpyShipRmkFromOtherSRN, null);
    jScrollPane3.getViewport().add(txtareaShippingMark, null);

    jPanel8.setBackground(new Color(202, 202, 224));
    jPanel8.setBorder(titledBorder5);
    jPanel8.setBounds(new Rectangle(384, 436, 387, 103));
    jPanel8.setLayout(null);
    this.add(jPanel8, null);
    jPanel8.add(btnCopySRNDescFromOtherSRN, null);
    jPanel8.add(jScrollPane4, null);
    this.add(jLabel11, null);
    this.add(jLabel17, null);
    this.add(cbxShipOrgCnty, null);
    this.add(txtShipETAdate, null);

    jScrollPane4.getViewport().add(txtShipSRNremark, null);
    jPanel7.setBackground(new Color(204, 204, 225));
    jPanel7.setBorder(titledBorder8);
    jPanel7.setBounds(new Rectangle(0, 611, 379, 189));
    jPanel7.setLayout(null);
    this.add(jPanel7, null);
    btnCpySpecialInstructionFromOtherSRN.setText("Copy From Other SRN");
    btnCpySpecialInstructionFromOtherSRN.setBounds(new Rectangle(209, 12, 160, 24));
    btnCpySpecialInstructionFromOtherSRN.setFont(new java.awt.Font("Dialog", 1, 11));
    jPanel7.add(PnlSpecInstruc, null);
    PnlSpecInstruc.add(jScrollPane5, BorderLayout.CENTER);
    jPanel7.add(btnCpySpecialInstructionFromOtherSRN, null);
    jScrollPane5.getViewport().add(txtSpecInstruc, null);
    btnCopySRNDescFromOtherSRN.setBounds(new Rectangle(196, 11, 181, 20));
    btnCopySRNDescFromOtherSRN.setFont(new java.awt.Font("Dialog", 1, 11));
    btnCopySRNDescFromOtherSRN.setText("Copy From Other SRN");
    jPanel8.add(btnCopySRNDescFromOtherSRN, null);
    Pnl_manufacture.add(jScrollPane7, null);
    jScrollPane7.getViewport().add(txtShipManufacture, null);
    btnCpySpecialInstructionFromOtherSRN.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnCpySpecialInstructionFromOtherSRN_actionPerformed(e);
      }
    });
    btnCopySRNDescFromOtherSRN.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnCopySRNDescFromOtherSRN_actionPerformed(e);
      }
    });
    btnCpyShipRmkFromOtherSRN.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnCpyShipRmkFromOtherSRN_actionPerformed(e);
      }
    });
    cbxPriceTermDest.setUI(new exgui.WideComboBoxUI(300));
    cbxShipDest.setUI(new exgui.WideComboBoxUI(300));

    //afterJbinit();
  }

  public void doAddNew(){
    //check if ship_org is null
    if(dbCbxShipOrg.getSelectedValue()==null){
      exgui.verification.VerifyLib.showAlert("Please Select \"Country Of Origin\"",
                                             "Please Select \"Country Of Origin\"");
      return;
    }
    super.doAddNew();
    try{
      if (newtimes.shipping_admin.ShippingAdmin_Const.IS_LORAN_MODE) {
        processhandler.template.Properties.getCenteralControler().
            doCommandExecute(
            new newtimes.shipping_admin.process.shiippingmaintain.
            TgrToQryScStyPo4Style());
      }
    }catch(Exception exp){
      exp.printStackTrace();
    }
  }
  public boolean gui2Record(){
    boolean result=super.gui2Record();
    if(!result)return result;
    try{
      recToMapping.set("SHIP_NTFE_MID", txtNtfeMid.getText());
    }catch(Exception exp){
      exp.printStackTrace();
      util.ExceptionLog.exp2File(exp,"");
    }
    return true;
  }

  public void record2Gui() {
    isDoingGuiBinding=true;
    super.record2Gui();
    int inv_remark_row_count;
    try{

      java.util.Vector recPaymentTerm=
          newtimes.preproduction.guis.tempProperties.tmpPaymentTerms;
      /*
      exgui.DataBindJCombobox DbJcbxjcbxPaymentTerm=
          new exgui.DataBindJCombobox(
          cbxPaymentTerm, "SHIP_PAYMENT_TERM", recPaymentTerm, "PYT_TRM",
          "PYT_TRM", recToMapping.get("SHIP_PAYMENT_TERM"),"N/A",null);*/
      //cbxPaymentTerm.setEditable(true);
      exgui.DataBindEditableJCombobox  DbJcbxjcbxOtherPaymentTerm=
        new exgui.DataBindEditableJCombobox(
        cbxOtherPaymentTerm, "PRICE_TYPE", recPaymentTerm, "PYT_TRM",
        "PYT_TRM", recToMapping.get("PRICE_TYPE"),"",null,200);
      cbxOtherPaymentTerm.setUI(new exgui.WideComboBoxUI(400));
      dataBoundGUIs.add(DbJcbxjcbxOtherPaymentTerm);

      //title bar have to show buyer maker breif name
      String textTitle=
          lblTItleBar.getText();
      if(textTitle.startsWith("ADD ")){
        String sc=(String)recToMapping.get("SHIP_NO");
        StringBuffer sb=new StringBuffer();
        sb.append("select  ");
        sb.append("'BUYER : '||(select bymkr_brief from buyer_maker where bymkr_seq=prod_buyer) as buyer_name,");
        sb.append("'MAKER : '||(select bymkr_brief from buyer_maker where bymkr_seq=prod_maker) as maker_name,");
        sb.append("prod_buyer ");
        sb.append("from prod_head ");
        sb.append("where prod_head_pk in ");
        sb.append("(select prod_head_pk from production where record_delete_flag='1' ");
        sb.append("and prod_sc_no='");sb.append(sc);sb.append("')");
        sb.append("and rownum=1 ");
        java.util.Vector vctTest=exgui2.CONST.BASIC_MAIN_EJB.getDatas(
         util.PublicVariable.USER_RECORD,
         sb.toString(),1,1);
        Record rec=(Record)vctTest.get(0);
        textTitle+=(" "+rec.get(0)+" "+rec.get(1));
        lblTItleBar.setText(textTitle);
        inv_remark_row_count=0;
        po_buyer_seq=rec.getInt(2);
      }else{
        String shipNo=(String)recToMapping.get("SHIP_NO");
        StringBuffer sb=new StringBuffer();
        sb.append("select  ");
        sb.append("'BUYER : '||(select bymkr_brief from buyer_maker where bymkr_seq=prod_buyer) as buyer_name, ");
        sb.append("'MAKER : '||(select bymkr_brief from buyer_maker where bymkr_seq=prod_maker) as maker_name,");
        sb.append("(select count(*) from ship_style where record_delete_flag='1' and ship_sc_pk ");
        sb.append("in (select ship_sc_pk from ship_sc where ship_no='");sb.append(shipNo);sb.append("'");
        sb.append(" and record_delete_flag='1') ");
        sb.append("and ship_style.SHIP_STYLE_PACKING_RMRK is not null) as  IC_REMARK_COUNT,prod_buyer ");
        sb.append("from prod_head ");
        sb.append("where prod_head_pk in ");
        sb.append("(select prod_head_pk from ship_sc where record_delete_flag='1' ");
        sb.append("and ship_no='");sb.append(shipNo);sb.append("')");
        sb.append("and rownum=1 ");
        /*
        sb.append("select  ");
        sb.append("'BUYER : '||(select bymkr_brief from buyer_maker where bymkr_seq=prod_buyer) as buyer_name,");
        sb.append("'MAKER : '||(select bymkr_brief from buyer_maker where bymkr_seq=prod_maker) as maker_name ");
        sb.append("from prod_head ");
        sb.append("where prod_head_pk in ");
        sb.append("(select prod_head_pk from ship_sc where record_delete_flag='1' ");
        sb.append("and ship_no='");sb.append(shipNo);sb.append("')");
        sb.append("and rownum=1 ");
        */
        java.util.Vector vctTest=exgui2.CONST.BASIC_MAIN_EJB.getDatas(
         util.PublicVariable.USER_RECORD,
         sb.toString(),1,1);
        Record rec=(Record)vctTest.get(0);
        textTitle+=(" "+rec.get(0)+" "+rec.get(1)+" Created By:"+(String)recToMapping.get("record_create_user"));
        inv_remark_row_count=rec.getInt(2);
        lblTItleBar.setText(textTitle);
        po_buyer_seq=rec.getInt(3);
      }
      //add ntfe fields
      cbxShipFinalDest.setEditable(true);
      dataBoundGUIs.add(
          new exgui.DataBindEditableJCombobox(
          cbxShipFinalDest,
          "SHIP_NTFE_DEST",
          newtimes.shipping_admin.ShippingAdmin_Const.DESTINATIONS,
          "DEST_NAME", "DEST_NAME",
          recToMapping.get("SHIP_NTFE_DEST"), "", null, 50));

      Object vftxtFowarderName=exgui.verification.CellFormat.getOrdinaryField(60);
       dataBoundGUIs.add(  new exgui.DataBindTextWithChecker(
         txtFowarderName,"SHIP_NTFE_FWD_NAME",
         recToMapping.get("SHIP_NTFE_FWD_NAME"),60,
         (exgui.Object2String)vftxtFowarderName,(exgui.ultratable.CellTxtEditorFormat)vftxtFowarderName)
      );




      Object vftxtBankDtl=exgui.verification.CellFormat.getOrdinaryField(200);
       dataBoundGUIs.add(  new exgui.DataBindTextWithChecker(
         txtBankDtl,"SHIP_BNK_DTL",
         recToMapping.get("SHIP_BNK_DTL"),200,
         (exgui.Object2String)vftxtBankDtl,(exgui.ultratable.CellTxtEditorFormat)vftxtBankDtl)
      );


      cbxAuthoriseSignaturePerson.setEditable(true);
      dataBoundGUIs.add(
          new exgui.DataBindEditableJCombobox(
          cbxAuthoriseSignaturePerson,
          "SHIP_NTFE_AUXSIG_PERSON",
          newtimes.shipping_admin.ShippingAdmin_Const.vctSignatuers,
          "SIGNATUER", "SIGNATUER",
          recToMapping.get("SHIP_NTFE_AUXSIG_PERSON"), "", null, 30));

      /*
      Object vftxtAuthoriseSignaturePerson=exgui.verification.CtxellFormat.getOrdinaryField(30);
       dataBoundGUIs.add(
         new exgui.DataBindTextWithChecker(txtAuthoriseSignaturePerson,
                                           "SHIP_NTFE_AUXSIG_PERSON",
                                           recToMapping.get("SHIP_NTFE_AUXSIG_PERSON"),30,
                                           (exgui.Object2String)vftxtAuthoriseSignaturePerson,
                                           (exgui.ultratable.CellTxtEditorFormat)vftxtAuthoriseSignaturePerson)
      );*/


   Object vftxtIcDescVfy=
        exgui.verification.CellFormat.getOrdinaryField(5000);
     /*
     dataBoundGUIs.add(
       new exgui.DataBindTextWithChecker(txtConsignEE,
                                       "SHIP_NTFE_CONSIGNEE",
                                       recToMapping.get("SHIP_NTFE_CONSIGNEE"),1000,
                                       (exgui.Object2String)vftxtIcDescVfy,
                                       (exgui.ultratable.CellTxtEditorFormat)vftxtIcDescVfy)
      );*/
     slkConsignee.init("SHIP_NTFE_CONSIGNEE",
                       recToMapping.get("SHIP_NTFE_CONSIGNEE"),slkConsignee.TYPE_CONSIGNEE,true);
     dataBoundGUIs.add(slkConsignee);

     slkSupplier.init("SHIP_NTFE_SUPPLIER",
                       recToMapping.get("SHIP_NTFE_SUPPLIER"),slkConsignee.TYPE_SUPPLIER,true);
     dataBoundGUIs.add(slkSupplier);


      Object vftxtAuthoriseSignaturePerson=exgui.verification.CellFormat.getOrdinaryField(30);
       dataBoundGUIs.add(
         new exgui.DataBindTextWithChecker(
         txtAuthoriseSignaturePersonTitle,
        "SHIP_NTFE_AUXSIG_TITLE",
         recToMapping.get("SHIP_NTFE_AUXSIG_TITLE"),30,
         (exgui.Object2String)vftxtAuthoriseSignaturePerson,
         (exgui.ultratable.CellTxtEditorFormat)vftxtAuthoriseSignaturePerson)
       );
      if(vctFreightTerm==null){
        java.util.Vector vctFrtTrm=new java.util.Vector();
        Record recFtTrm=(Record)util.MiscFunc.deepCopy(util.PublicVariable.USER_RECORD);
        recFtTrm.getValueFields().clear();
        recFtTrm.getFieldName().clear();
        recFtTrm.getFieldName().add("FREIGHT_TERM");
        recFtTrm.getValueFields().add(null);

        Record recT0=(Record)util.MiscFunc.deepCopy(recFtTrm);
        recT0.set(0,"COLLECT");
        vctFrtTrm.add(recT0);
        Record recT1=(Record)util.MiscFunc.deepCopy(recFtTrm);
        recT1.set(0,"PREPAID");
        vctFrtTrm.add(recT1);
        Record recT2=(Record)util.MiscFunc.deepCopy(recFtTrm);
        recT2.set(0,"AIR/SEA DIFF");
        vctFrtTrm.add(recT2);
        /*
        Record recT3=(Record)util.MiscFunc.deepCopy(recFtTrm);
        recT3.set(0,"DIFF");
        vctFrtTrm.add(recT3);
        */
        vctFreightTerm=vctFrtTrm;
      }
       dataBoundGUIs.add(
        new exgui.DataBindJCombobox(
        cbxFrtTrm,
        "SHIP_FRET_TERM",
        vctFreightTerm,
        "FREIGHT_TERM", "FREIGHT_TERM",
        recToMapping.get("SHIP_FRET_TERM"), "N/A", null));

     /*
      dataBoundGUIs.add(
        new exgui.DataBindTextWithChecker(
        cbxFrtTrm,
        "SHIP_FRET_TERM",
        recToMapping.get("SHIP_FRET_TERM"),30,
        (exgui.Object2String)vftxtAuthoriseSignaturePerson,
        (exgui.ultratable.CellTxtEditorFormat)vftxtAuthoriseSignaturePerson)
      );*/


        dataBoundGUIs.add(
           new exgui.DataBindTextWithChecker(txtAreaICDesc,
                                        "SHIP_NTFE_IC_DES",
                                        recToMapping.get("SHIP_NTFE_IC_DES"),5000,
                                        (exgui.Object2String)vftxtIcDescVfy,
                                        (exgui.ultratable.CellTxtEditorFormat)vftxtIcDescVfy)
     );

   Object vftxtMidVfy=
        exgui.verification.CellFormat.getOrdinaryField(20);
        dataBoundGUIs.add(
           new exgui.DataBindTextWithChecker(txtNtfeMid,
                                        "SHIP_NTFE_MID",
                                        recToMapping.get("SHIP_NTFE_MID"),20,
                                        (exgui.Object2String)vftxtMidVfy,
                                        (exgui.ultratable.CellTxtEditorFormat)vftxtMidVfy)
     );

   Object vftxtTotalCarton=
        exgui.verification.CellFormat.getIntVerifierAllowNull(10);
        dataBoundGUIs.add(
           new exgui.DataBindTextWithChecker(txtTotalCarton,
                                        "SHIP_PW_TTL_CTN",
                                        recToMapping.get("SHIP_PW_TTL_CTN"),10,
                                        (exgui.Object2String)vftxtTotalCarton,
                                        (exgui.ultratable.CellTxtEditorFormat)vftxtTotalCarton)
     );


     java.util.Vector vctDivs=newtimes.preproduction.guis.tempProperties.tmpDivision;
     cbx_IC_Div.setEditable(true);
     exgui.DataBindEditableJCombobox DbJcbxcbx_IC_Div =
        new exgui.DataBindEditableJCombobox(
        cbx_IC_Div,"SHIP_IC_DIV",
        vctDivs,"DIV_NAME",
        "DIV_CODE",
        recToMapping.get("SHIP_IC_DIV"),
        "",null,30);
       dataBoundGUIs.set(index_of_division,DbJcbxcbx_IC_Div);

       slkByrMkr_Bill2.init(
         "SHIP_BILL_TO",recToMapping.get("SHIP_BILL_TO"),slkByrMkr_Bill2.TYPE_SHIPPING,false);
       slkByrMkr_Bill2.setSelectingCenter(newtimes.shipping_admin.ShippingAdmin_Const.CurrentWorkingCenterCode);
       dataBoundGUIs.set(index_of_bill2,slkByrMkr_Bill2);

       slkByrMkrShip2.init(
         "SHIP_SHIP_TO",recToMapping.get("SHIP_SHIP_TO"),slkByrMkrShip2.TYPE_SHIPPING,false);
       slkByrMkrShip2.setSelectingCenter(newtimes.shipping_admin.ShippingAdmin_Const.CurrentWorkingCenterCode);
       dataBoundGUIs.set(index_of_ship2,slkByrMkrShip2);

       Object vftxtShipFTYLC=exgui.verification.CellFormat.getOrdinaryField(50);
        dataBoundGUIs.add(
          new exgui.DataBindTextWithChecker(txtShipFtyLC,"SHIP_FTY_LC_NO",
                                            recToMapping.get("SHIP_FTY_LC_NO"),50,
                                            (exgui.Object2String)vftxtShipFTYLC,
                                            (exgui.ultratable.CellTxtEditorFormat)vftxtShipFTYLC)
       );
       java.util.ArrayList columns=new java.util.ArrayList();
       for(int i=0;i<dataBoundGUIs.size();i++){
         if(dataBoundGUIs.get(i) instanceof exgui.DataBindGUIObject){
            String flx=((exgui.DataBindGUIObject)dataBoundGUIs.get(i)).getOrgRecField();
            columns.add(flx);
         }

       }
      //2006/06/14,column --ship type added
      java.util.Vector vctShipType=new java.util.Vector();
      Record recType0=(Record)util.MiscFunc.deepCopy(util.PublicVariable.USER_RECORD);
      recType0.getFieldName().clear();
      recType0.getValueFields().clear();
      recType0.getFieldName().add("TYPE_CODE");
      recType0.getValueFields().add(null);
      recType0.getFieldName().add("TYPE_NAME");
      recType0.getValueFields().add(null);
      //vctShipType.add(recType0);

      Record recType1=(Record)util.MiscFunc.deepCopy(recType0);
      recType1.set(0,"1");recType1.set(1,"I.C.");
      vctShipType.add(recType1);
      Record recType2=(Record)util.MiscFunc.deepCopy(recType0);
      recType2.set(0,"2");recType2.set(1,"INVOICE");
      vctShipType.add(recType2);
      Record recType3=(Record)util.MiscFunc.deepCopy(recType0);
      recType3.set(0,"3");recType3.set(1,"BOTH");
      vctShipType.add(recType3);
       recordColumnsToCopy=(String[])columns.toArray(new String[0]);
       isDoingGuiBinding=false;
       int inv_ic_type=0;
       inv_ic_type|=((inv_remark_row_count>0)?1:0);
       inv_ic_type|=((txtAreaICDesc.getText().trim().length()>0)?2:0);
       lblIcInvType.setText(lblIcInvType.getText()+
                            ((inv_ic_type==3)?" IC & INVOICE":
                            ((inv_ic_type==1)?" INVOICE":
                            ((inv_ic_type==2)?" IC":" "))));
        if(newtimes.shipping_admin.ShippingAdmin_Const.IS_LORAN_MODE){
          lblIcInvType.setText("TYPE:IC");
        }
    }catch(Exception exp){
      exp.printStackTrace();
    }
  }
  protected void btnEditShipExtra_actionPerformed(ActionEvent e) {
   Object objSRN=recToMapping.get(0);
   if(objSRN==null || objSRN.toString().toUpperCase().startsWith("S")){
     exgui.verification.VerifyLib.showAlert(
     "Before Editing Shipping Extra Data\nPlease Click \"ADD\" Button To Add Shipping Head Data",
     "Pleaes Add Shipp Head Before Editing Extra Data");
     return;
   }
   util.MiscFunc.showProcessingMessage();
   DlgShipExtraBWPW dlgXtr=new DlgShipExtraBWPW(
     processhandler.template.Properties.getMainFrame(),
     "EDIT SHIP EXTRA DATA",true,
     new JcmpPnlShipExtra(),this);
   dlgXtr.setSize(new Dimension(650,355));
   util.MiscFunc.hideProcessingMessage();
   dlgXtr.show();

   try{
     //avoid exit checking.
     recClonedForCheck.set("SHIP_EXTRA_DESC",
                           recToMapping.get("SHIP_EXTRA_DESC"));
   }catch(Exception exp){
     exp.printStackTrace();
   }finally{

   }
 }

  public void doPaste(){
    try{
      Record recCopied=(Record)util.ApplicationProperites.getProperties(id4ApplicationProperties);
      if(recCopied==null){
        exgui.verification.VerifyLib.showAlert("No Copied Data!!",
        "No Copied Data!!");
        return;
      }
      Record recCopiedDup=(Record)util.MiscFunc.deepCopy(recCopied);
      Object objCountry = dbCbxShipOrg.getSelectedValue();
      Object objScNo = recToMapping.get("SHIP_NO");
       if(cbxShipOrgCnty.isEnabled()){
         //allow to country of origin init by past data
       }else{
         recCopiedDup.set("SHIP_CNTY_ORIG", objCountry);
       }
       recCopiedDup.set("SHIP_NO",objScNo);
       for(int i=0;i<recordColumnsToCopy.length;i++){
         recToMapping.set(
            recordColumnsToCopy[i],
            recCopiedDup.get(recordColumnsToCopy[i])
         );
       }
       //lblTItleBar.setText("SRN DATA");
       if(lblTItleBar.getText().startsWith("ADD SHIP MASTER BY S/C:")){
         lblTItleBar.setText("ADD SHIP MASTER BY S/C:"+
          newtimes.shipping_admin.ShippingAdmin_Const.SHIPPING_EDITING_HEAD_RECORD.get("SHIP_NO"));
       }else{
         String shipShipPanelTitle="SRN DATA EDIT,SRN:"+newtimes.shipping_admin.ShippingAdmin_Const.SHIPPING_EDITING_HEAD_RECORD.get("SHIP_NO");
         lblTItleBar.setText(shipShipPanelTitle);
         if(util.PublicVariable.OPERATTING_CENTER.equals("NTHK")){
           shipShipPanelTitle+=" CREATE BY:"+
               newtimes.shipping_admin.ShippingAdmin_Const.SHIPPING_EDITING_HEAD_RECORD.get("record_create_user");
           lblTItleBar.setText(shipShipPanelTitle);
         }

       }
       record2Gui();
       //force to update ship payment term,seem the combobox have some problem.
           cbxPaymentTerm.setSelectedItem(recCopiedDup.get("SHIP_PAYMENT_TERM"));
       //cbxPaymentTerm.setSelectedItem(recCopiedDup.get(recordColumnsToCopy[42]));
    }catch(Exception exp){
      exp.printStackTrace();
    }
  }
  public void doCopy(){
    String result=JOptionPane.showInputDialog(
     util.PublicVariable.APP_FRAME,
      "Please Input Numeric part of SRN No:","Copy From Other Ship Head",
      JOptionPane.QUESTION_MESSAGE);
    if(result==null)return;
    if(result.trim().length()==0){
      return;
    }
    if(result.trim().length()!=6){
      exgui.verification.VerifyLib.showAlert("Numberic Of SRN is 6 digits","Numberic Of SRN is 6 digits");
      return;
    }

    //check if s/c exists
    try{
      String resultSearch=
          newtimes.shipping_admin.ShippingAdmin_Const.completeSrnByNum(result);
      if(resultSearch==null){
        exgui.verification.VerifyLib.showAlert("NO Such SRN Number","NO Such SRN Number");
        return;
      }

      util.MiscFunc.showProcessingMessage();
      java.util.Vector vct=exgui2.CONST.BASIC_MAIN_EJB.getDatas(
      util.PublicVariable.USER_RECORD,
      "select * from SHIPPING where SHIP_no='"+
       util.MiscFunc.Replace(resultSearch.toUpperCase().trim(),"'","''")+"' and record_delete_flag='1'",
       1,1
      );
      util.MiscFunc.hideProcessingMessage();
      if(vct.size()==0){
        exgui.verification.VerifyLib.showPlanMsg("Sorry,No Such Ship Head","SRN#"+resultSearch+" Not Found");
        return;
      }
      Record tmprec = (Record)vct.get(0);
      util.ApplicationProperites.setProperties(
          id4ApplicationProperties,
          tmprec
          );
       Object orgCuft=recToMapping.get("SHIP_DIM_CUFT");
      doPaste();
       txtCuft.setText((orgCuft==null)?"":orgCuft.toString());

      //txtArea.append((recShipRemark.get(0)==null)?"":recShipRemark.get(0).toString());
    }catch(Exception exp){
      exp.printStackTrace();
      util.ExceptionLog.exp2File(exp,"");
      exgui.verification.VerifyLib.showAlert("Connection Error\nPlease Notify System Manager",
                                             "Connection Error");
    }

  }
  class ChaiedProcChzShipPackingMark extends exgui.chaindialog.ChainedDialogBox{
    ChaiedProcChzShipPackingMark(javax.swing.JFrame frame,String title,boolean model,
                          exgui.chaindialog.Responsible rsp){
      super(frame,title,model,rsp);
    }
    public Object getDialogResult(){
      return super.resultHashMap;
    }
  }
  protected String replaceTAB(String str){
    if(str==null)return "";
    return util.MiscFunc.Replace(str,"\t","       ",false);
  }

  void btnGetShippingMark_actionPerformed(ActionEvent e) {
    exgui.chaindialog.ChainedDialogBox chgDlg=null;
     newtimes.production.gui.prodmaintain.PnlRspInit4ShipPackMark pnl=
          new newtimes.production.gui.prodmaintain.PnlRspInit4ShipPackMark("Shipping Mark",
          newtimes.production.gui.prodmaintain.PnlRspInit4ShipPackMark.SEARCH_SHIPPIMG_MARK);
      // if(util.PublicVariable.OPERATTING_CENTER.equals("NTHK")){
      try {
        int buyerSeq = po_buyer_seq;
        java.util.Vector vctShipMark = exgui2.CONST.BASIC_MAIN_EJB.getDatas(
            util.PublicVariable.USER_RECORD,
            "select * from SHIPMARK where record_delete_flag='1' and SHIPMARK_BYMKR_SEQ=" +
            buyerSeq, 1, 99999);

        if(vctShipMark.size()==1){
          Record rec = (Record)vctShipMark.get(0);
          newtimes.production.gui.prodmaintain.PnlRspShowMark nextRsp =
              new newtimes.production.gui.prodmaintain.PnlRspShowMark((String)rec.get(2),
              (String)rec.get(3));
          chgDlg = new  ChaiedProcChzShipPackingMark(util.PublicVariable.
              APP_FRAME,"Select Shipping Mark", true, nextRsp);
        }else if(vctShipMark.size()>1){
          newtimes.production.gui.prodmaintain.PnlRspNthkShowShipMaks nextRsp =
              new newtimes.production.gui.prodmaintain.PnlRspNthkShowShipMaks(vctShipMark);
          chgDlg = new ChaiedProcChzShipPackingMark(util.PublicVariable.
              APP_FRAME,"Select Shipping Mark", true, nextRsp);

        }else{
          chgDlg = new ChaiedProcChzShipPackingMark(util.PublicVariable.
              APP_FRAME, "Select Shipping Mark", true, pnl);
        }

      } catch (Exception exp) {
        exp.printStackTrace();
        util.ExceptionLog.exp2File(exp,"");
        chgDlg = new ChaiedProcChzShipPackingMark(util.PublicVariable.
            APP_FRAME, "Select Shipping Mark", true, pnl);
      }
    /*
    }else{
      chgDlg = new ChaiedProcChzShipPackingMark(util.PublicVariable.
          APP_FRAME, "Select Shipping Mark", true, pnl);
    }*/

   chgDlg.setSize(new Dimension(500,400));
   exgui.UIHelper.setToScreenCenter(chgDlg);
   chgDlg.show();
   if(chgDlg.getDialogResult()!=null){
     String remarkString=(String)((java.util.HashMap)chgDlg.getDialogResult()).get(
      newtimes.production.gui.prodmaintain.PnlRspShowMark.KEY_TEXT_AREA_DATA);
     if(remarkString!=null){
       String orgText= replaceTAB(txtareaShippingMark.getText());
       if(orgText.trim().length()>0){
         txtareaShippingMark.setText(orgText+"\n"+remarkString);
       }else{
         txtareaShippingMark.setText(remarkString);
       }
     }
   }
 }
  protected void makeTextContext(javax.swing.text.JTextComponent txt2set,
                                 Record recBuyerMaker){

    if(recBuyerMaker==null){
      txt2set.setText("");
      return;
    }
    /*
     field (0) :BYMKR_SEQ value is :687
     field (1) :BYMKR_NAME value is :ANSH ASCHAFFENBURGER NUTZFAHRZEUGE,
     field (2) :BYMKR_BRIEF value is :ANSHA
     field (3) :BYMKR_CNTY_CODE value is :GERMANY
     field (4) :BYMKR_CITY_NAME value is :null
     field (5) :BYMKR_CHECK_DIV value is :N
     field (6) :BYMKR_CHINESE_BRIEF value is :ANSH ASCHAFFENBURGER NUTZFAHRZEUGE,
     field (7) :BUY_COMM value is :null
     field (8) :BUY_COMM_PC value is :null
     field (9) :BUY_COMM_DZ value is :null
     field (10) :BUY_COMM_LUMP_SUM value is :null
     field (11) :MKR_DSCT_PER value is :null
     field (12) :MKR_DSCT_PC value is :null
     field (13) :MKR_DSCT_DZ value is :null
     field (14) :MKR_DSCT_LUMP_SUM value is :null
     field (15) :BYMKR_HK_CODE value is :ANSHA
     field (16) :BYMKR_ADDR1 value is :SERVICE UND HANDELS GMBH,
     field (17) :BYMKR_ADDR2 value is :WEICHERSTRASSE 8,
     field (18) :BYMKR_ADDR3 value is :63741 ASHAFFENBURG,
     field (19) :BYMKR_ADDR4 value is :GERMANY
     field (20) :BYMKR_NAME2 value is :null

     */

    StringBuffer sb=new StringBuffer();
    String fullName=(String) recBuyerMaker.get(1);
    //String hkCode=(String) recBuyerMaker.get(56);
    //sb.append("<html><body>");
    if(fullName!=null){
      sb.append(fullName);
      sb.append("\n");
    }
    String name2=(String) recBuyerMaker.get(20);
    if(name2!=null){
      sb.append(name2);
      sb.append("\n");
    }
    //sb.append("<br>");//conbine with 4 address.
    for (int i = 16; i < 20; i++) {
      String tmpstr = (String)recBuyerMaker.get(i);
      if (tmpstr != null && (!tmpstr.toUpperCase().trim().equals("NULL"))){
         sb.append(tmpstr);
         sb.append("\n");
      }
    }
     txt2set.setText(sb.toString());
  }
  void btnSlkMESSERS_actionPerformed(ActionEvent e) {
    slkMessers.btnDots_actionPerformed(e);
  }

  void btnSlkMANUFACTURER_actionPerformed(ActionEvent e) {
    slkManufacturor.btnDots_actionPerformed(e);
  }
  class MyBuyerSelector extends newtimes.preproduction.buyermakerselect.SelectBuyerMaker{
     public  void btnDots_actionPerformed(java.awt.event.ActionEvent e) {
       super.btnDots_actionPerformed(e);
     }
   }



}
