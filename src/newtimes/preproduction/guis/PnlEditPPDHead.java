package newtimes.preproduction.guis;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import database.datatype.*;
import exgui.*;
import exgui.ultratable.*;
import newtimes.preproduction.buyermakerselect.*;
import newtimes.preproduction.process.*;
import processhandler.template.*;
/**
 * <p>Title: </p>
 * <p>Description: </p>brac
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class PnlEditPPDHead
  extends processhandler.template.PnlFieldsEditor
  //extends JPanel
  implements MouseMotionListener ,
  newtimes.preproduction.buyermakerselect.BuyerMakerChanged{
  DB_Preprod myDbHander;
  BorderLayout borderLayout1 = new BorderLayout();
  GridLayout gridLayout=new GridLayout(1,1);
  JPanel jPanel1 = new JPanel();
  JLabel blueBkgWhiteCharLabel3 = new JLabel();
  //JLabel whiteBkgBlueCharLabel6 = new JLabel();
  exgui.BlueBkgWhiteCharLabel whiteBkgBlueCharLabel6 = new exgui.BlueBkgWhiteCharLabel();
  Border border1;
  JPanel subPnlProto = new JPanel();
  TitledBorder titledBorder1;
  JTextField txtPrtPriceRmk = new JTextField();
  JTextField txtPrtGauge = new JTextField();
  JLabel whiteBkgBlueCharLabel14 = new JLabel();
  JLabel blueBkgWhiteCharLabel11 = new JLabel();
  JComboBox cbxPrtQtaCtg = new JComboBox();
  JLabel whiteBkgBlueCharLabel12 = new JLabel();
  JTextField txtPrtSpcRcv = new JTextField();
  JLabel blueBkgWhiteCharLabel10 = new JLabel();
  JTextField txtPrtGnlRmk = new JTextField();
  JLabel blueBkgWhiteCharLabel12 = new JLabel();
  JLabel whiteBkgBlueCharLabel11 = new JLabel();
  JLabel blueBkgWhiteCharLabel14 = new JLabel();
  JTextField txtPrtEstmSnd = new JTextField();
  JTextField txtPrtQltyDesc = new JTextField();
  JLabel blueBkgWhiteCharLabel15 = new JLabel();
  JTextField txtPrtLayoutRcv = new JTextField();
  JTextField txtPrtWstg = new JTextField();
  JLabel blueBkgWhiteCharLabel13 = new JLabel();
  JLabel whiteBkgBlueCharLabel13 = new JLabel();
  JTextField txtPrtAvgWt = new JTextField();
  JPanel subPnlLockIn = new JPanel();

  TitledBorder titledBorder2;
  JLabel whiteBkgBlueCharLabel15 = new JLabel();
  JLabel blueBkgWhiteCharLabel17 = new JLabel();
  JLabel blueBkgWhiteCharLabel19 = new JLabel();
  JTextField txtLkinDlvyDate = new JTextField();

  JTextField txtLkinRmk = new JTextField();
  JLabel blueBkgWhiteCharLabel16 = new JLabel();
  JTextField txtLkinDvn = new JTextField();
  JLabel whiteBkgBlueCharLabel16 = new JLabel();
  JLabel blueBkgWhiteCharLabel18 = new JLabel();
  JPanel subPnlLapDip = new JPanel();

  Border border2;
  TitledBorder titledBorder3;
  JLabel whiteBkgBlueCharLabel8 = new JLabel();
  JTextField txtBulkTgtDate = new JTextField();
  JLabel blueBkgWhiteCharLabel8 = new JLabel();
  JLabel blueBkgWhiteCharLabel7 = new JLabel();
  JTextField txtLapDipFxyDate = new JTextField();
  JTextField txtLapDipRcvDate = new JTextField();
  SelectBuyerMaker slkLknMaker = new SelectBuyerMaker();
  SelectBuyerMaker slkLknSupp  = new SelectBuyerMaker();
  SelectBuyerMaker slkLknBuyer = new SelectBuyerMaker();
  boolean isProcessingPast=false;
  boolean isInitializingCountriesCbx=false;
  JComboBox cbxLknDep = new JComboBox();
  Vector respondingMTR_V_Records=new Vector();
  JButton btn2SelectMtrls = new JButton();
  JLabel lblMtrList = new JLabel();
  JTextField txtProdByrPlnDlvy = new JTextField();
  DataBindTextWithChecker buyerPlanDlvDbCheck=null;
  boolean isGrayied=false;
  //JLabel lblDisplayProdheadPK = new JLabel();
  exgui.BlueBkgWhiteCharLabel   lblDisplayProdheadPK=new exgui.BlueBkgWhiteCharLabel();
  JPanel jPanel2 = new JPanel();
  JLabel whiteBkgBlueCharLabel1 = new JLabel();
  JComboBox cbxCenter = new JComboBox();

  JComboBox cbxDep = new JComboBox();
  JLabel blueBkgWhiteCharLabel1 = new JLabel();
  JLabel blueBkgWhiteCharLabel5 = new JLabel();
  JComboBox cbxManagers = new JComboBox();
  JLabel whiteBkgBlueCharLabel17 = new JLabel();
  JTextField txtYear = new JTextField();
  JComboBox cbxSzn = new JComboBox();
  JLabel blueBkgWhiteCharLabel23 = new JLabel();
  JPanel jPanel3 = new JPanel();
  JLabel blueBkgWhiteCharLabel2 = new JLabel();
  SelectBuyerMaker slkHeadBuyer = new SelectBuyerMaker();
  SelectBuyerMaker slkHeadMaker = new SelectBuyerMaker();
  JLabel blueBkgWhiteCharLabel6 = new JLabel();
  JPanel jPanel4 = new JPanel();
  JComboBox cbxProductionType = new JComboBox();
  JLabel whiteBkgBlueCharLabel9 = new JLabel();
  JPanel jPanel5 = new JPanel();
  JLabel whiteBkgBlueCharLabel18 = new JLabel();
  boolean needtoCheckDiv=false;
  JComboBox cbxDiv = new JComboBox();
  JLabel whiteBkgBlueCharLabel2 = new JLabel();
  JLabel whiteBkgBlueCharLabel20 = new JLabel();
  JComboBox cbxOffShrCntr = new JComboBox();
  exgui.DataBindJCombobox dbCbxdiv=null;
  exgui.DataBindJCombobox DbJcbxcbxQcCountry =null,dbCbxNBFcode=null;
  boolean isProcessingData2Gui=false;
  int dbCbxDepIndex=0;
  int dbCbxDivIndex=0;
  int dbCbxMngIndex=0;
  int dbCbxExchangeShipDocIndex=0;
  DataBindJCombobox dbCBX_Center,dbCBX_Dep,dbCbxSzn,dbCbxProdType,dbCbxCity,dbCbxExchangeDoc,
      DbJcbxjcbxBranches,DbJcbxjcbxCtBranches;
  java.util.Vector recDests,branches;
  PagedDataFactory fabCommDbHandler;
  Vector fabCommRecords=null;
  public String orgBuyerNameString=null;
  public String orgMakerNameString=null;
  boolean isProcessingDelete=false;
  ChangeBuyerHandler buyerChangerHandler=new ChangeBuyerHandler();
  public JButton btnGotoStyles=null;
  java.text.DateFormat df= new java.text.SimpleDateFormat("yyyy/MM/dd");
  String strLblTitle_PortTermDest="";
  String strLblTitle_GoodDest="";
  String strLblTitle_ScNo="";
  boolean isTpeUser=false;
  String alertPort;
  String alertDest;
  String qcCntyTitle="";
  protected boolean isProcessingAddNew=false;
  protected boolean needToChkBuyerDivModified=false;
  protected boolean isProcessingExit=false;
  protected boolean isGotoStyle=false;
  newtimes.preproduction.process.DB_FabComm_N_Reason dbDB_FabComm_N_Reason =null;
      //new newtimes.preproduction.process.DB_FabComm_N_Reason();
  boolean isProcessingCopy=false;

  public PnlEditPPDHead() {
    try {
      //for hk user,need to change caption of title.
      if(util.PublicVariable.OPERATTING_CENTER.equals("001")){
        strLblTitle_PortTermDest="*port";
        strLblTitle_GoodDest="*Destination";
        alertPort="Port";
        alertDest="Destination";
        qcCntyTitle="*QC Country";
        isTpeUser=true;
      }else{
        strLblTitle_PortTermDest="*Term-Dest";
        strLblTitle_GoodDest="<html><body>*Goods <br> Dest.</body></html>";
        alertPort="Term-Dest";
        alertDest="Goods-Dest.";
        qcCntyTitle="<html><body>*Country Of<br>Origin</body></html>";
      }
      jbInit();
      recordColumnsToCopy=null;
       this.addMouseMotionListener(this);
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }
 public boolean isContextModified(){
   if(rdoFabCmm_TypeRefNo.isSelected()&& lblFabCmmRefNo.getText().trim().equals(""))return true;
   if(isProcessingDelete)return false;//processing delete,no need to
   return super.isContextModified();
 }
 public void grayMe(){
   super.grayMe();
   txtFabCmmContract.setBackground(Color.gray);
   btnCopyAllAttrs.setEnabled(false);
   isGrayied=true;
   cbxIsSample.setBackground(Color.gray);
 }
 protected void setPanelEnable(JPanel pnl,boolean enable){
   java.awt.Component cmp[]=pnl.getComponents();
   for(int i=0;i<cmp.length;i++){
     if (cmp[i] instanceof javax.swing.JPanel) {
        setPanelEnable((JPanel)cmp[i],enable);
     }else{
       if(!(cmp[i] instanceof javax.swing.JLabel)) cmp[i].setEnabled(enable);
     }
   }
   cbxIsSample.setEnabled(enable);
 }

 public void setEnabled(boolean enable){
   setPanelEnable(this,enable);
 }
 public void mouseMoved(MouseEvent e){

 }
 public void mouseDragged(MouseEvent e){

 }

 protected  void jbInit() throws Exception {
    border3 = new EtchedBorder(EtchedBorder.RAISED,Color.white,new Color(148, 145, 140));
    titledBorder4 = new TitledBorder(border3,"FABRIC TRIM COMMISION");
    //this.setPreferredSize(new Dimension(930,650));
    border4 = new EtchedBorder(EtchedBorder.RAISED,Color.white,new Color(148, 145, 140));
    titledBorder5 = new TitledBorder(border4,"BATCH NO");
    this.setPreferredSize(new Dimension(930,500));
    setBackground(new Color(204, 204, 225));
    jPanel1.setBackground(new Color(204, 204, 225));
    subPnlProto.setBackground(new Color(204, 204, 225));
    subPnlLockIn.setBackground(new Color(204, 204, 225));
    subPnlLapDip.setBackground(new Color(204, 204, 225));
    border1 = BorderFactory.createBevelBorder(BevelBorder.RAISED,Color.white,Color.white,new Color(124, 124, 124),new Color(178, 178, 178));
    titledBorder1 = new TitledBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED,Color.white,Color.white,new Color(103, 101, 98),new Color(148, 145, 140)),"Proto");
    titledBorder2 = new TitledBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED,Color.white,Color.white,new Color(103, 101, 98),new Color(148, 145, 140)),"Lock In");
    border2 = BorderFactory.createBevelBorder(BevelBorder.LOWERED,Color.white,Color.white,new Color(103, 101, 98),new Color(148, 145, 140));
    titledBorder3 = new TitledBorder(border2,"Lap Dip");
    this.setLayout(borderLayout1);
    //this.setLayout(gridLayout);
    jPanel1.setLayout(null);
    blueBkgWhiteCharLabel3.setBounds(new Rectangle(9, 408, 86, 24));
    blueBkgWhiteCharLabel3.setText("Material No.");
    whiteBkgBlueCharLabel6.setBackground(new Color(143, 143, 188));
    whiteBkgBlueCharLabel6.setForeground(Color.white);
    whiteBkgBlueCharLabel6.setHorizontalAlignment(SwingConstants.LEFT);
    whiteBkgBlueCharLabel6.setText("Pre Prodution");
    whiteBkgBlueCharLabel6.setVerticalAlignment(javax.swing.SwingConstants.CENTER);
    whiteBkgBlueCharLabel6.setVerticalTextPosition(javax.swing.SwingConstants.CENTER);
    whiteBkgBlueCharLabel6.setBounds(new Rectangle(231, 2, 440, 28));
    subPnlProto.setBorder(titledBorder1);
    subPnlProto.setDebugGraphicsOptions(0);
    subPnlProto.setBounds(new Rectangle(5, 532, 737, 194));
    subPnlProto.setLayout(null);
    txtPrtPriceRmk.setBounds(new Rectangle(607, 144, 81, 24));
    txtPrtPriceRmk.setText("");
    txtPrtGauge.setBounds(new Rectangle(609, 35, 80, 24));
    txtPrtGauge.setText("");
    whiteBkgBlueCharLabel14.setBounds(new Rectangle(233, 145, 123, 21));
    whiteBkgBlueCharLabel14.setText("Quota Category");
    blueBkgWhiteCharLabel11.setBounds(new Rectangle(5, 68, 77, 33));
    blueBkgWhiteCharLabel11.setText("<html><body>Specification<br>Received</body></html>");
    cbxPrtQtaCtg.setBounds(new Rectangle(353, 144, 130, 20));
    whiteBkgBlueCharLabel12.setBounds(new Rectangle(233, 70, 123, 21));
    whiteBkgBlueCharLabel12.setText("Layout Received");
    txtPrtSpcRcv.setBounds(new Rectangle(121, 70, 91, 24));
    txtPrtSpcRcv.setText("");
    blueBkgWhiteCharLabel10.setBounds(new Rectangle(507, 35, 102, 24));
    blueBkgWhiteCharLabel10.setText("Proto Guage");
    txtPrtGnlRmk.setText("");
    txtPrtGnlRmk.setBounds(new Rectangle(353, 106, 130, 21));
    blueBkgWhiteCharLabel12.setText("Estimate Send");
    blueBkgWhiteCharLabel12.setBounds(new Rectangle(5, 110, 88, 24));
    whiteBkgBlueCharLabel11.setText("Proto Quality Desc");
    whiteBkgBlueCharLabel11.setBounds(new Rectangle(231, 34, 121, 21));
    blueBkgWhiteCharLabel14.setBounds(new Rectangle(8, 146, 63, 24));
    blueBkgWhiteCharLabel14.setText("Wastage");
    txtPrtEstmSnd.setText("");
    txtPrtEstmSnd.setBounds(new Rectangle(120, 107, 92, 24));
    txtPrtQltyDesc.setText("");
    txtPrtQltyDesc.setBounds(new Rectangle(353, 33, 130, 24));
    blueBkgWhiteCharLabel15.setBounds(new Rectangle(506, 144, 102, 24));
    blueBkgWhiteCharLabel15.setText("Price Remark");
    txtPrtLayoutRcv.setBounds(new Rectangle(353, 69, 130, 21));
    txtPrtLayoutRcv.setText("");
    txtPrtWstg.setBounds(new Rectangle(119, 149, 93, 24));
    txtPrtWstg.setText("");
    blueBkgWhiteCharLabel13.setText("Average Weight");
    blueBkgWhiteCharLabel13.setBounds(new Rectangle(506, 106, 102, 24));
    whiteBkgBlueCharLabel13.setText("General Remark");
    whiteBkgBlueCharLabel13.setBounds(new Rectangle(233, 107, 123, 21));
    txtPrtAvgWt.setText("");
    txtPrtAvgWt.setBounds(new Rectangle(607, 106, 81, 24));
    subPnlLockIn.setBorder(titledBorder2);
    subPnlLockIn.setBounds(new Rectangle(5, 729, 737, 102));
    subPnlLockIn.setLayout(null);
    whiteBkgBlueCharLabel15.setBounds(new Rectangle(261, 67, 108, 21));
    whiteBkgBlueCharLabel15.setText("Lockin Department");
    blueBkgWhiteCharLabel17.setText("Lockin Factory");
    blueBkgWhiteCharLabel17.setBounds(new Rectangle(5, 64, 89, 24));
    blueBkgWhiteCharLabel19.setText("Lockin Remark");
    blueBkgWhiteCharLabel19.setBounds(new Rectangle(514, 64, 94, 24));
    txtLkinDlvyDate.setBounds(new Rectangle(609, 26, 62, 24));
    txtLkinDlvyDate.setText("");
    txtLkinRmk.setText("");
    txtLkinRmk.setBounds(new Rectangle(607, 62, 123, 26));
    blueBkgWhiteCharLabel16.setBounds(new Rectangle(6, 24, 82, 24));
    blueBkgWhiteCharLabel16.setText("Lockin Buyer");
    txtLkinDvn.setText("");
    txtLkinDvn.setBounds(new Rectangle(379, 26, 130, 21));
    whiteBkgBlueCharLabel16.setText("Lockin Division");
    whiteBkgBlueCharLabel16.setBounds(new Rectangle(294, 27, 87, 21));
    blueBkgWhiteCharLabel18.setBounds(new Rectangle(530, 26, 78, 24));
    blueBkgWhiteCharLabel18.setText("Delivery Date");
    subPnlLapDip.setBorder(titledBorder3);
    subPnlLapDip.setBounds(new Rectangle(5, 472, 737, 58));
    subPnlLapDip.setLayout(null);
    whiteBkgBlueCharLabel8.setText("Standard to Factory");
    whiteBkgBlueCharLabel8.setBounds(new Rectangle(233, 18, 117, 24));
    txtBulkTgtDate.setBounds(new Rectangle(608, 19, 61, 24));
    txtBulkTgtDate.setText("");
    blueBkgWhiteCharLabel8.setBounds(new Rectangle(497, 20, 111, 24));
    blueBkgWhiteCharLabel8.setText("Bulk Target Date");
    blueBkgWhiteCharLabel7.setText("Standard Received");
    blueBkgWhiteCharLabel7.setBounds(new Rectangle(6, 19, 118, 24));
    txtLapDipFxyDate.setText("");
    txtLapDipFxyDate.setBounds(new Rectangle(350, 19, 60, 24));
    txtLapDipRcvDate.setBounds(new Rectangle(132, 19, 60, 24));
    txtLapDipRcvDate.setText("");
    slkLknMaker.setBounds(new Rectangle(89, 60, 165, 18));
    slkLknBuyer.setBounds(new Rectangle(85, 23, 167, 24));
    //--
    slkLknSupp.setBounds(new Rectangle(87, 206, 166, 20));
    //--
    cbxLknDep.setBounds(new Rectangle(370, 68, 137, 20));
    btn2SelectMtrls.setBounds(new Rectangle(84, 408, 30, 24));
    btn2SelectMtrls.setFont(new java.awt.Font("Dialog", 1, 12));
    btn2SelectMtrls.setMargin(new Insets(0, 5, 0, 5));
    btn2SelectMtrls.setText("...");
    btn2SelectMtrls.addActionListener(new PnlEditPPDHead_btn2SelectMtrls_actionAdapter(this));
    lblMtrList.setBorder(BorderFactory.createLoweredBevelBorder());
    lblMtrList.setText("");
    lblMtrList.setBounds(new Rectangle(112, 407, 464, 24));
    //this.add(jPanel1);
    txtProdByrPlnDlvy.setText("");
    txtProdByrPlnDlvy.setBounds(new Rectangle(125, 12, 129, 24));
    //txtProdByrPlnDlvy.addFocusListener(new PnlEditPPDHead_txtProdByrPlnDlvy_focusAdapter(this));
    lblDisplayProdheadPK.setForeground(Color.white);
    lblDisplayProdheadPK.setText("");
    lblDisplayProdheadPK.setBounds(new Rectangle(0, 2, 61, 28));
    jPanel2.setBackground(new Color(204, 204, 225));
    jPanel2.setBorder(BorderFactory.createEtchedBorder());
    jPanel2.setBounds(new Rectangle(5, 36, 226, 230));
    jPanel2.setLayout(null);
    whiteBkgBlueCharLabel1.setForeground(Color.red);
    whiteBkgBlueCharLabel1.setRequestFocusEnabled(true);
    whiteBkgBlueCharLabel1.setText("*Depart");
    whiteBkgBlueCharLabel1.setBounds(new Rectangle(5, 86, 67, 23));
    cbxCenter.setBounds(new Rectangle(99, 8, 121, 23));
    cbxCenter.addItemListener(
        new PnlEditPPDHead_cbxCenter_itemAdapter(this)
        );

    cbxDep.setBounds(new Rectangle(65, 85, 155, 23));
    blueBkgWhiteCharLabel1.setForeground(Color.red);
    blueBkgWhiteCharLabel1.setText("*Center");
    blueBkgWhiteCharLabel1.setBounds(new Rectangle(7, 10, 62, 23));
    blueBkgWhiteCharLabel5.setBounds(new Rectangle(4, 123, 60, 23));
    blueBkgWhiteCharLabel5.setForeground(Color.red);
    blueBkgWhiteCharLabel5.setText("*Manager");
    cbxManagers.setBounds(new Rectangle(64, 124, 156, 23));
    whiteBkgBlueCharLabel17.setForeground(Color.red);
    whiteBkgBlueCharLabel17.setText("*Year");
    whiteBkgBlueCharLabel17.setBounds(new Rectangle(6, 164, 38, 23));
    txtYear.setBounds(new Rectangle(99, 164, 121, 23));
    txtYear.setText("");
    cbxSzn.setBounds(new Rectangle(99, 204, 121, 23));
    blueBkgWhiteCharLabel23.setForeground(Color.red);
    blueBkgWhiteCharLabel23.setText("*Season");
    blueBkgWhiteCharLabel23.setBounds(new Rectangle(3, 203, 57, 23));
    jPanel3.setBackground(new Color(204, 204, 225));
    jPanel3.setBorder(BorderFactory.createEtchedBorder());
    jPanel3.setBounds(new Rectangle(233, 34, 259, 229));
    jPanel3.setLayout(null);
    blueBkgWhiteCharLabel2.setForeground(Color.red);
    blueBkgWhiteCharLabel2.setText("*Buyer");
    blueBkgWhiteCharLabel2.setBounds(new Rectangle(9, 4, 57, 24));
    slkHeadBuyer.setBounds(new Rectangle(89, 4, 166, 24));
    slkHeadMaker.setBounds(new Rectangle(89, 62, 166, 24));
    slkHeadBuyer.setModifyNotifyTo(buyerChangerHandler);
    blueBkgWhiteCharLabel6.setBounds(new Rectangle(9, 63, 58, 24));
    blueBkgWhiteCharLabel6.setForeground(Color.black);
    blueBkgWhiteCharLabel6.setText("Maker");
    //cbxCountry.addItemListener(new PnlEditPPDHead_cbxCountry_itemAdapter(this));
    jPanel4.setBackground(new Color(204, 204, 225));
    jPanel4.setBorder(BorderFactory.createEtchedBorder());
    jPanel4.setBounds(new Rectangle(495, 33, 251, 231));
    jPanel4.setLayout(null);
    cbxProductionType.setBounds(new Rectangle(94, 60, 151, 24));
    whiteBkgBlueCharLabel9.setBounds(new Rectangle(10, 64, 44, 20));
    whiteBkgBlueCharLabel9.setBackground(Color.white);
    whiteBkgBlueCharLabel9.setForeground(Color.red);
    whiteBkgBlueCharLabel9.setText("*TYPE");
    jPanel5.setBackground(new Color(204, 204, 225));
    jPanel5.setBorder(BorderFactory.createEtchedBorder());
    jPanel5.setBounds(new Rectangle(8, 278, 737, 124));
    jPanel5.setLayout(null);
    whiteBkgBlueCharLabel18.setText("*Buyer Plan Delivery");
    whiteBkgBlueCharLabel18.setBounds(new Rectangle(7, 12, 116, 24));
    whiteBkgBlueCharLabel18.setBackground(Color.lightGray);
    whiteBkgBlueCharLabel18.setForeground(Color.red);
    cbxDiv.setBounds(new Rectangle(89, 32, 166, 23));
    whiteBkgBlueCharLabel2.setBounds(new Rectangle(9, 32, 61, 23));
    whiteBkgBlueCharLabel2.setForeground(Color.black);
    whiteBkgBlueCharLabel2.setText("Division");
    whiteBkgBlueCharLabel20.setForeground(Color.red);
    whiteBkgBlueCharLabel20.setText("*OffShore Center");
    whiteBkgBlueCharLabel20.setVerticalAlignment(SwingConstants.CENTER);
    whiteBkgBlueCharLabel20.setVerticalTextPosition(SwingConstants.CENTER);
    whiteBkgBlueCharLabel20.setBounds(new Rectangle(2, 44, 96, 26));
    cbxOffShrCntr.setBounds(new Rectangle(99, 48, 121, 20));
    cbxQcQnty.setBounds(new Rectangle(94, 4, 151, 24));
    cbxQcQnty.addItemListener(new PnlEditPPDHead_cbxCountry_itemAdapter(this));
    whiteBkgBlueCharLabel21.setBackground(new Color(143, 143, 188));
    whiteBkgBlueCharLabel21.setForeground(Color.red);
    whiteBkgBlueCharLabel21.setHorizontalAlignment(SwingConstants.LEADING);
    whiteBkgBlueCharLabel21.setHorizontalTextPosition(SwingConstants.CENTER);
    whiteBkgBlueCharLabel21.setText(qcCntyTitle);//"*QC Country");
    whiteBkgBlueCharLabel21.setBounds(new Rectangle(5, 0, 88, 39));
    whiteBkgBlueCharLabel4.setBounds(new Rectangle(40, 46, 74, 24));
    whiteBkgBlueCharLabel4.setForeground(Color.red);
    whiteBkgBlueCharLabel4.setText("*Price Term");
    cbxScPrxTrm.setBounds(new Rectangle(126, 46, 127, 24));
    whiteBkgBlueCharLabel5.setBackground(new Color(143, 143, 188));
    whiteBkgBlueCharLabel5.setForeground(Color.black);
    whiteBkgBlueCharLabel5.setText("Board Range");
    whiteBkgBlueCharLabel5.setBounds(new Rectangle(8, 157, 74, 25));
    txtRange.setText("");
    txtRange.setBounds(new Rectangle(89, 157, 166, 21));
    txtGrpName.setText("");
    txtGrpName.setBounds(new Rectangle(89, 128, 166, 21));
    blueBkgWhiteCharLabel4.setBackground(Color.white);
    blueBkgWhiteCharLabel4.setForeground(Color.black);
    blueBkgWhiteCharLabel4.setText("Group Name");
    blueBkgWhiteCharLabel4.setBounds(new Rectangle(7, 127, 98, 25));
    txtGroup.setBounds(new Rectangle(89, 98, 166, 21));
    txtGroup.setText("");
    whiteBkgBlueCharLabel3.setBounds(new Rectangle(11, 90, 70, 26));
    whiteBkgBlueCharLabel3.setBackground(new Color(143, 143, 188));
    whiteBkgBlueCharLabel3.setForeground(Color.black);
    whiteBkgBlueCharLabel3.setText("Group No");
    whiteBkgBlueCharLabel7.setBounds(new Rectangle(8, 29, 46, 24));
    whiteBkgBlueCharLabel7.setText("CITY");
    cbxCity.setBounds(new Rectangle(94, 31, 151, 24));
    cbxBranches.setBounds(new Rectangle(94, 89, 151, 24));
    cbxBranches.addItemListener(new PnlEditPPDHead_cbxBranches_itemAdapter(this));
    blueBkgWhiteCharLabel21.setBounds(new Rectangle(6, 88, 55, 24));
    blueBkgWhiteCharLabel21.setForeground(Color.red);
    blueBkgWhiteCharLabel21.setText("*Branch");
    txtBuyerSCNO.setBounds(new Rectangle(94, 147, 151, 23));
    txtBuyerSCNO.setText("");
    //
    txtBuyerSCNO.setVisible(false);
    whiteBkgBlueCharLabel23.setBounds(new Rectangle(6, 146, 83, 26));
    whiteBkgBlueCharLabel23.setText((isTpeUser)?"Buyer S/C":"Cust. Po:");
    //
    whiteBkgBlueCharLabel23.setVisible(false);
    cbxSCDest.setBounds(new Rectangle(361, 46, 128, 24));
    //cbxSCDest.setEditable(true);
    //cbxTgtDest.setEditable(true);
    lblPortTermDest.setForeground(Color.red);
    lblPortTermDest.setRequestFocusEnabled(true);
    lblPortTermDest.setHorizontalAlignment(SwingConstants.CENTER);
    //lblPortTermDest.setText("*Port :");
    lblPortTermDest.setText(strLblTitle_PortTermDest);
    lblPortTermDest.setBounds(new Rectangle(259, 46, 101, 24));
    blueBkgWhiteCharLabel20.setRequestFocusEnabled(true);
    blueBkgWhiteCharLabel20.setText("Buyer Label");
    blueBkgWhiteCharLabel20.setBounds(new Rectangle(6, 168, 75, 24));
    txtBuyerLabel.setText("");
    txtBuyerLabel.setBounds(new Rectangle(78, 171, 151, 23));
    BuyerLabelbtn.setText("<");
    BuyerLabelbtn.setBounds(new Rectangle(229, 171, 20, 23));
    BuyerLabelbtn.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        BuyerLabel_actionPerformed(e);
      }
    });


    lblGoodDest.setForeground(Color.red);
    lblGoodDest.setHorizontalAlignment(SwingConstants.LEADING);
    lblGoodDest.setHorizontalTextPosition(SwingConstants.TRAILING);
    //lblGoodDest.setText("Destination:");
    lblGoodDest.setText(strLblTitle_GoodDest);
    lblGoodDest.setVerticalAlignment(javax.swing.SwingConstants.TOP);
    lblGoodDest.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
    lblGoodDest.setBounds(new Rectangle(504, 13, 78, 36));
    cbxTgtDest.setBounds(new Rectangle(576, 12, 154, 21));
    subPnlFabComm.setBackground(new Color(204, 204, 225));
    subPnlFabComm.setBorder(titledBorder4);
    subPnlFabComm.setBounds(new Rectangle(7, 436, 612, 82));
    subPnlFabComm.setLayout(null);
    rdoFabCmm_TypeNone.setBackground(new Color(204, 204, 225));
    rdoFabCmm_TypeNone.setFont(new java.awt.Font("Dialog", 1, 11));
    rdoFabCmm_TypeNone.setText("  NONE");
    rdoFabCmm_TypeNone.setBounds(new Rectangle(5, 19, 74, 21));
    rdoFabCmm_TypeNone.addItemListener(new PnlEditPPDHead_rdoFabCmm_TypeNone_itemAdapter(this));
    rdoFabCmm_TypeContract.setBounds(new Rectangle(78, 17, 105, 25));
    rdoFabCmm_TypeContract.addItemListener(new PnlEditPPDHead_rdoFabCmm_TypeNone_itemAdapter(this));
    rdoFabCmm_TypeContract.setText("Contract No.:");
    rdoFabCmm_TypeContract.setBackground(new Color(204, 204, 225));
    rdoFabCmm_TypeContract.setFont(new java.awt.Font("Dialog", 1, 11));
    txtFabCmmContract.setText("");
    txtFabCmmContract.setBounds(new Rectangle(193, 17, 78, 25));
    rdoFabCmm_TypeRefNo.setFont(new java.awt.Font("Dialog", 1, 11));
    rdoFabCmm_TypeRefNo.setBackground(new Color(204, 204, 225));
    rdoFabCmm_TypeRefNo.setText(" RefNo:");
    rdoFabCmm_TypeRefNo.setBounds(new Rectangle(269, 18, 72, 25));
    rdoFabCmm_TypeRefNo.addItemListener(new PnlEditPPDHead_rdoFabCmm_TypeNone_itemAdapter(this));
    lblFabCmmRefNo.setFont(new java.awt.Font("Dialog", 1, 11));
    lblFabCmmRefNo.setBorder(BorderFactory.createLoweredBevelBorder());
    lblFabCmmRefNo.setBounds(new Rectangle(345, 18, 80, 22));
    btnEditFabCmmList.setBounds(new Rectangle(424, 18, 42, 19));
    btnEditFabCmmList.setFont(new java.awt.Font("Dialog", 1, 11));
    btnEditFabCmmList.setText(" . . .");
    btnEditFabCmmList.addActionListener(new PnlEditPPDHead_btnEditFabCmmList_actionAdapter(this));
    txtProtoNo.setBounds(new Rectangle(357, 13, 130, 21));
    txtProtoNo.setText("");
    blueBkgWhiteCharLabel9.setText("Proto No.");
    blueBkgWhiteCharLabel9.setBounds(new Rectangle(280, 13, 61, 24));
    whiteBkgBlueCharLabel10.setText("*S/C Payment Term");
    whiteBkgBlueCharLabel10.setForeground(Color.red);
    whiteBkgBlueCharLabel10.setBackground(new Color(143, 143, 188));
    whiteBkgBlueCharLabel10.setBounds(new Rectangle(502, 49, 122, 23));
    cbxScPaymentTerm.setBounds(new Rectangle(626, 47, 102, 22));
    blueBkgWhiteCharLabel22.setBounds(new Rectangle(43, 83, 67, 22));
    blueBkgWhiteCharLabel22.setText("*Currency");
    blueBkgWhiteCharLabel22.setForeground(Color.red);
    blueBkgWhiteCharLabel22.setBackground(Color.white);
    cbxCurrency.setBounds(new Rectangle(127, 82, 128, 22));
    whiteBkgBlueCharLabel19.setText("SC Issue Date");
    whiteBkgBlueCharLabel19.setBounds(new Rectangle(277, 82, 83, 23));
    txtBuySC_ISU_Date.setText("");
    txtBuySC_ISU_Date.setBounds(new Rectangle(359, 82, 130, 23));
    cbxCtPaymentTerm.setBounds(new Rectangle(626, 83, 102, 22));
    whiteBkgBlueCharLabel110.setBounds(new Rectangle(501, 84, 122, 23));
    whiteBkgBlueCharLabel110.setBackground(new Color(143, 143, 188));
    whiteBkgBlueCharLabel110.setForeground(Color.red);
    whiteBkgBlueCharLabel110.setText("*C/T Payment Term");
    btnCopyAllAttrs.setBounds(new Rectangle(621, 405, 121, 93));
    btnCopyAllAttrs.setFocusPainted(true);
    btnCopyAllAttrs.setText("<html><body>Copy To Create<br>Production & Colors & Styles</body></html>");
    btnCopyAllAttrs.addActionListener(new PnlEditPPDHead_btnCopyAllAttrs_actionAdapter(this));
    lblTitleUserName.setText("");
    lblTitleUserName.setBounds(new Rectangle(61, 2, 170, 28));
    lbl2ShowCreateDate.setBackground(new Color(143, 143, 188));
    lbl2ShowCreateDate.setFont(new java.awt.Font("Dialog", 1, 11));
    lbl2ShowCreateDate.setOpaque(true);
    lbl2ShowCreateDate.setHorizontalAlignment(SwingConstants.LEFT);
    lbl2ShowCreateDate.setBounds(new Rectangle(670, 2, 127, 28));
    jLabel1.setFont(new java.awt.Font("Dialog", 1, 11));
    jLabel1.setText("NBF");
    jLabel1.setBounds(new Rectangle(491, 17, 36, 21));
    cbx_NBF_code.setBounds(new Rectangle(531, 17, 69, 20));
    btnReasonNoCommInN.setBounds(new Rectangle(7, 46, 265, 27));
    btnReasonNoCommInN.setFont(new java.awt.Font("Dialog", 1, 11));
    btnReasonNoCommInN.setText("REASON WHEN NO COMM IN \"N\"");
    btnReasonNoCommInN.addActionListener(new PnlEditPPDHead_btnReasonNoCommInN_actionAdapter(this));
    btnChkSc.setBounds(new Rectangle(151, 187, 101, 27));
    btnChkSc.setFont(new java.awt.Font("Dialog", 1, 11));
    btnChkSc.setText("Chk S/C#");
    btnChkSc.addActionListener(new PnlEditPPDHead_btnChkSc_actionAdapter(this));
    lblExchageShipDoc.setFont(new java.awt.Font("Dialog", 0, 11));
    lblExchageShipDoc.setForeground(Color.red);
    lblExchageShipDoc.setText("船務文件交換:");
    lblExchageShipDoc.setBounds(new Rectangle(119, 182, 83, 21));
    cbxExchageShipDoc.setBounds(new Rectangle(191, 182, 61, 22));
    lblIsSample.setText("IS SAMPLE");
    lblIsSample.setBounds(new Rectangle(8, 182, 72, 20));
    cbxIsSample.setBounds(new Rectangle(70, 182, 41, 22));
    cbxCtBranches.setBounds(new Rectangle(94, 120, 151, 24));
    blueBkgWhiteCharLabel24.setText("*CT Branch");
    blueBkgWhiteCharLabel24.setForeground(Color.red);
    blueBkgWhiteCharLabel24.setBounds(new Rectangle(6, 119, 83, 24));
    lblBatchNo.setFont(new java.awt.Font("Dialog", 1, 11));
    lblBatchNo.setText("BATCH #:");
    lblBatchNo.setBounds(new Rectangle(288, 48, 64, 23));
    txtBatchNo.setEditable(false);
    txtBatchNo.setText("");
    txtBatchNo.setBounds(new Rectangle(344, 48, 222, 24));
    lblAgent.setText("AGENT");
    lblAgent.setBounds(new Rectangle(5, 202, 55, 21));
    //---
    lblSupplier.setText("SUPPLIER");
    lblSupplier.setBounds(new Rectangle(8, 202, 64, 30));
    //---
    slkAgent.setBounds(new Rectangle(60, 199, 188, 23));
    subPnlLapDip.add(blueBkgWhiteCharLabel7, null);
    subPnlLapDip.add(txtLapDipFxyDate, null);
    subPnlLapDip.add(txtBulkTgtDate, null);
    subPnlLapDip.add(blueBkgWhiteCharLabel8, null);
    subPnlLapDip.add(txtLapDipRcvDate, null);
    subPnlLapDip.add(whiteBkgBlueCharLabel8, null);
    jPanel1.add(subPnlProto, null);
    jPanel1.add(subPnlLapDip, null);
    subPnlProto.add(blueBkgWhiteCharLabel14, null);
    subPnlProto.add(txtPrtSpcRcv, null);
    subPnlProto.add(txtPrtEstmSnd, null);
    subPnlProto.add(whiteBkgBlueCharLabel13, null);
    subPnlProto.add(whiteBkgBlueCharLabel11, null);
    subPnlProto.add(txtPrtQltyDesc, null);
    subPnlProto.add(whiteBkgBlueCharLabel12, null);
    subPnlProto.add(txtPrtLayoutRcv, null);
    subPnlProto.add(txtPrtGnlRmk, null);
    subPnlProto.add(whiteBkgBlueCharLabel14, null);
    subPnlProto.add(cbxPrtQtaCtg, null);
    subPnlProto.add(blueBkgWhiteCharLabel13, null);
    subPnlProto.add(blueBkgWhiteCharLabel10, null);
    subPnlProto.add(txtPrtGauge, null);
    subPnlProto.add(txtPrtAvgWt, null);
    subPnlProto.add(blueBkgWhiteCharLabel15, null);
    subPnlProto.add(txtPrtPriceRmk, null);
    subPnlProto.add(blueBkgWhiteCharLabel11, null);
    subPnlProto.add(blueBkgWhiteCharLabel12, null);
    subPnlProto.add(txtPrtWstg, null);
    jPanel1.add(subPnlLockIn, null);
    subPnlLockIn.add(blueBkgWhiteCharLabel17, null);
    subPnlLockIn.add(blueBkgWhiteCharLabel16, null);
    subPnlLockIn.add(txtLkinDlvyDate, null);
    subPnlLockIn.add(txtLkinRmk, null);
    subPnlLockIn.add(blueBkgWhiteCharLabel19, null);
    subPnlLockIn.add(cbxLknDep, null);
    subPnlLockIn.add(slkLknMaker, null);

    subPnlLockIn.add(blueBkgWhiteCharLabel18, null);
    subPnlLockIn.add(whiteBkgBlueCharLabel16, null);
    subPnlLockIn.add(txtLkinDvn, null);
    subPnlLockIn.add(slkLknBuyer, null);
    subPnlLockIn.add(whiteBkgBlueCharLabel15, null);
    //java.util.List dataBoundGUIs=new java.util.ArrayList();
    this.add(jPanel1, BorderLayout.CENTER);
    jPanel2.add(blueBkgWhiteCharLabel1, null);
    jPanel2.add(whiteBkgBlueCharLabel1, null);
    jPanel2.add(cbxDep, null);
    jPanel2.add(cbxCenter, null);
    jPanel2.add(cbxOffShrCntr, null);
    jPanel2.add(cbxManagers, null);
    jPanel2.add(txtYear, null);
    jPanel2.add(cbxSzn, null);
    jPanel2.add(whiteBkgBlueCharLabel20, null);
    jPanel2.add(whiteBkgBlueCharLabel17, null);
    jPanel2.add(blueBkgWhiteCharLabel23, null);
    jPanel2.add(blueBkgWhiteCharLabel5, null);
    jPanel1.add(jPanel3, null);
    jPanel1.add(jPanel5, null);
    jPanel1.add(lblDisplayProdheadPK, null);
    jPanel3.add(whiteBkgBlueCharLabel2, null);
    jPanel3.add(blueBkgWhiteCharLabel2, null);
    jPanel3.add(slkHeadBuyer, null);
    jPanel3.add(cbxDiv, null);
    jPanel3.add(blueBkgWhiteCharLabel6, null);
    jPanel3.add(slkHeadMaker, null);
    jPanel3.add(whiteBkgBlueCharLabel3, null);
    jPanel3.add(txtGroup, null);
    jPanel3.add(blueBkgWhiteCharLabel4, null);
    jPanel3.add(txtGrpName, null);
    jPanel3.add(whiteBkgBlueCharLabel5, null);
    jPanel3.add(txtRange, null);
    if(util.PublicVariable.OPERATTING_CENTER.equals("NTHK")){
      //only HK user need to see buyer/makers of used S/C No.
      jPanel3.add(btnChkSc, null);
    }

    jPanel5.add(whiteBkgBlueCharLabel18, null);
    jPanel5.add(cbxTgtDest, null);
    jPanel5.add(lblGoodDest, null);
    jPanel5.add(blueBkgWhiteCharLabel9, null);
    jPanel5.add(txtProtoNo, null);
    jPanel5.add(txtProdByrPlnDlvy, null);
    jPanel5.add(whiteBkgBlueCharLabel4, null);
    jPanel5.add(cbxScPrxTrm, null);
    jPanel5.add(lblPortTermDest, null);
    jPanel5.add(cbxSCDest, null);
    jPanel5.add(whiteBkgBlueCharLabel10, null);
    jPanel5.add(cbxCurrency, null);
    jPanel5.add(blueBkgWhiteCharLabel22, null);
    jPanel5.add(whiteBkgBlueCharLabel19, null);
    jPanel5.add(txtBuySC_ISU_Date, null);
    jPanel5.add(whiteBkgBlueCharLabel110, null);
    jPanel5.add(cbxScPaymentTerm, null);
    jPanel5.add(cbxCtPaymentTerm, null);
    jPanel1.add(jPanel4, null);
    jPanel1.add(jPanel2, null);
    jPanel4.add(whiteBkgBlueCharLabel21, null);
    jPanel4.add(blueBkgWhiteCharLabel24, null);
    jPanel4.add(cbxCtBranches, null);
    jPanel4.add(blueBkgWhiteCharLabel21, null);
    jPanel4.add(cbxBranches, null);
    jPanel4.add(whiteBkgBlueCharLabel9, null);
    jPanel4.add(cbxProductionType, null);
    jPanel4.add(whiteBkgBlueCharLabel7, null);
    jPanel4.add(cbxCity, null);
    jPanel4.add(cbxQcQnty, null);
    jPanel4.add(whiteBkgBlueCharLabel23, null);
    jPanel4.add(txtBuyerSCNO, null);
    jPanel4.add(txtBuyerLabel, null);
    jPanel4.add(BuyerLabelbtn);
    jPanel4.add(blueBkgWhiteCharLabel20, null);
    jPanel4.add(lblAgent, null);
    subPnlFabComm.add(rdoFabCmm_TypeNone, null);
    subPnlFabComm.add(rdoFabCmm_TypeContract, null);
    subPnlFabComm.add(txtFabCmmContract, null);
    subPnlFabComm.add(rdoFabCmm_TypeRefNo, null);
    subPnlFabComm.add(lblFabCmmRefNo, null);
    subPnlFabComm.add(btnEditFabCmmList, null);
    subPnlFabComm.add(jLabel1, null);
    subPnlFabComm.add(cbx_NBF_code, null);
    subPnlFabComm.add(btnReasonNoCommInN, null);
    subPnlFabComm.add(lblBatchNo, null);
    jPanel1.add(whiteBkgBlueCharLabel6, null);
    jPanel1.add(lbl2ShowCreateDate, null);
    jPanel1.add(lblTitleUserName, null);
    jPanel1.add(btnCopyAllAttrs, null);
    jPanel1.add(blueBkgWhiteCharLabel3, null);
    jPanel1.add(btn2SelectMtrls, null);
    jPanel1.add(lblMtrList, null);
    jPanel1.add(subPnlFabComm, null);
    cbxDiv.addItemListener(new PnlEditPPDHead_cbxDiv_itemAdapter(this));
    isGrayied=false;
    btnFabCmm.add(rdoFabCmm_TypeContract);
    btnFabCmm.add(rdoFabCmm_TypeNone);
    btnFabCmm.add(rdoFabCmm_TypeRefNo);
    jPanel3.add(cbxExchageShipDoc, null);
    jPanel3.add(lblIsSample, null);
    jPanel3.add(cbxIsSample, null);
    jPanel3.add(lblExchageShipDoc, null);
    jPanel3.add(slkLknSupp,null);
    //--
    jPanel3.add(lblSupplier,null);
    //--
    subPnlFabComm.add(txtBatchNo, null);
    jPanel4.add(slkAgent, null);
    //20040521,hide the un-use column,because hk do not determ what to do with pre-production now
    subPnlLapDip.setVisible(false);
    subPnlLockIn.setVisible(false);
    subPnlProto.setVisible(false);
    btnCopyAllAttrs.setEnabled(true);
    cbxScPaymentTerm.setUI(new exgui.WideComboBoxUI(350));
    cbxCtPaymentTerm.setUI(new exgui.WideComboBoxUI(350));
    cbxSCDest.setUI(new exgui.WideComboBoxUI(300));
    cbxTgtDest.setUI(new exgui.WideComboBoxUI(300));
    if(!util.PublicVariable.OPERATTING_CENTER.equals("001")){
     lblExchageShipDoc.setVisible(false);
     cbxExchageShipDoc.setVisible(false);
    }
  }
  void txtProdByrPlnDlvy_focusLost(FocusEvent e) {
    if(buyerPlanDlvDbCheck.isValidx()){
      Object valueObj=buyerPlanDlvDbCheck.getSelectedValue();
      if(valueObj!=null){
        java.util.Date date=(java.util.Date)valueObj;
        long value2Minus=105L;
        value2Minus*=24;
        value2Minus*=3600;
        value2Minus*=1000;
        java.sql.Date dateGspRq=new java.sql.Date(date.getTime()-value2Minus);
        //exgui.Object2String cnv=(exgui.Object2String)exgui.verification.CellFormat.getDateStringFormaterAllowNull();
        //txtGspReq.setText(cnv.Obj2String(dateGspRq));
      }
    }else{
    }
  }
  public void doExit()throws Exception{
    isProcessingExit=true;
    //list all the chained trggers in command center,trigger the goto list of query or add new page.
   processhandler.CommandTrigger tgr= processhandler.template.Properties.getCenteralControler().getLastExcCmdTgr();
   if(tgr==null){
     processhandler.template.Properties.getCenteralControler().
         doCommandExecute(new newtimes.preproduction.process.TgrToGenQryPreProdGUI());
     return;
   }
   processhandler.CommandTrigger  parent_tgr =tgr.getParentCmdTrigger();
   //System.out.println("command is :"+tgr.getClass().getName());
   //System.out.println("command is :"+parent_tgr.getClass().getName());

   if(parent_tgr==null){
     processhandler.template.Properties.getCenteralControler().
         doCommandExecute(new newtimes.preproduction.process.TgrToGenQryPreProdGUI());
     return;
   }
   while(!((parent_tgr instanceof newtimes.preproduction.process.TgrToGenQryPreProdGUI)||
         (parent_tgr instanceof newtimes.preproduction.process.TriggerPreprodList))
         ){
       parent_tgr=parent_tgr.getParentCmdTrigger();
       if(parent_tgr==null){
         processhandler.template.Properties.getCenteralControler().
             doCommandExecute(new newtimes.preproduction.process.TgrToGenQryPreProdGUI());
         return;
       }
       //System.out.println("command is :"+parent_tgr.getClass().getName());
   }
   processhandler.template.Properties.getCenteralControler().doCommandExecute(parent_tgr);
  }
  public void setDestinationRecords(Vector vctDest){recDests =vctDest;}
  public void setBranchesRecords(Vector vctBranch){branches=vctBranch;}
  //once the maker changed ,set country & city to co-responding country -city
  public class ChangeBuyerHandler
      implements newtimes.preproduction.buyermakerselect.BuyerMakerChanged{
    public void changeBuyerMaker(Record buyerRecord){
      //recompose the division combobox of buyer.
      if(isProcessingData2Gui)return;
      try{
        recToMapping.set("prod_buyer",((buyerRecord==null)?null:(buyerRecord.get(0))));
        //find out the vector to add dbDeps.
        if (buyerRecord==null) {
          //only the all dep is allow to add now.

          dbCbxExchangeDoc=
              new exgui.DataBindJCombobox(cbxExchageShipDoc,
                                          "PRODUCTION_XG_DOC",
                                          tempProperties.tmpYesNoNull,
                                          "YES_NO_NULL",
                                          "YES_NO_NULL",
                                          null,"N/A",null);
          dataBoundGUIs.set(dbCbxExchangeShipDocIndex,dbCbxExchangeDoc);
          lblExchageShipDoc.setVisible(false);
          cbxExchageShipDoc.setVisible(false);

          dbCbxdiv=new exgui.DataBindJCombobox(
              cbxDiv,
              "PROD_BUYER_DIVISION",
              new Vector(),
              "DIV_NAME","DIV_CODE",
              recToMapping.get("PROD_BUYER_DIVISION"),"N/A",null);
          cbxDiv.setUI(new exgui.WideComboBoxUI(160));


          if(dbCbxDivIndex == dataBoundGUIs.size()) {
            dataBoundGUIs.add(dbCbxdiv);
          }else{
            //just replace after display & change;
            dataBoundGUIs.set(dbCbxDivIndex,dbCbxdiv);
          }
        }else {
          String NameBuyer=((javax.swing.text.JTextComponent)slkHeadBuyer.getGUIcomponent()).getText();
          if(util.PublicVariable.OPERATTING_CENTER.equals("001")){
           if((NameBuyer.equals("KOMAR NY")||NameBuyer.equals("KOMAR UK"))){
            dbCbxExchangeDoc=
                new exgui.DataBindJCombobox(cbxExchageShipDoc,
                                            "PRODUCTION_XG_DOC",
                                            tempProperties.tmpYesNoNull,
                                            "YES_NO_NULL",
                                            "YES_NO_NULL",
                                            null,"N/A",null);
            dataBoundGUIs.set(dbCbxExchangeShipDocIndex,dbCbxExchangeDoc);
            lblExchageShipDoc.setVisible(true);
            cbxExchageShipDoc.setVisible(true);
            }else{
              dbCbxExchangeDoc=
                  new exgui.DataBindJCombobox(cbxExchageShipDoc,
                                              "PRODUCTION_XG_DOC",
                                              tempProperties.tmpYesNoNull,
                                              "YES_NO_NULL",
                                              "YES_NO_NULL",
                                              null,"N/A",null);
              dataBoundGUIs.set(dbCbxExchangeShipDocIndex,dbCbxExchangeDoc);
              lblExchageShipDoc.setVisible(false);
              cbxExchageShipDoc.setVisible(false);
            }
          }


          //deps and "ALL"dep allow to add.
          Vector dvsnRecords=
              (Vector)tempProperties.tmpHMap_BuyerDivison.get(
              buyerRecord.get(0).toString());
           dbCbxdiv=null;
          if(dvsnRecords==null){
            dbCbxdiv=new exgui.DataBindJCombobox(
                cbxDiv,
                "PROD_BUYER_DIVISION",
                new Vector(),
                "DIV_NAME",
                "DIV_CODE",
                recToMapping.get("PROD_BUYER_DIVISION"),"N/A",null);
            cbxDiv.setUI(new exgui.WideComboBoxUI(160));
          }else {
            dbCbxdiv=new exgui.DataBindJCombobox(
                cbxDiv,
                "PROD_BUYER_DIVISION",
                dvsnRecords,
                "DIV_NAME",
                "DIV_CODE",
                recToMapping.get("PROD_BUYER_DIVISION"),"N/A",null);
            cbxDiv.setUI(new exgui.WideComboBoxUI(160));
          }

          if (dbCbxDivIndex == dataBoundGUIs.size()) {
            dataBoundGUIs.add(dbCbxdiv);
          }else{
            dataBoundGUIs.set(dbCbxDivIndex,dbCbxdiv);
          }
        }

      }catch(Exception exp){
        exp.printStackTrace();
      }


    }
  }

  public void changeBuyerMaker(Record buyerMkerRecord){
     String mkrCountry=null,mkrCity=null;
     try{
       recToMapping.set("prod_maker",
                        ((buyerMkerRecord == null) ? null :
                         (buyerMkerRecord.get(0))));
     }catch(Exception exp){
       exp.printStackTrace();
     }
    if(buyerMkerRecord!=null){
      /*
      "select bymkr_seq,BYMKR_NAME,bymkr_brief,BYMKR_CNTY_CODE, BYMKR_CITY_NAME,BYMKR_CHECK_DIV,BYMKR_CHINESE_BRIEF,"
      "BUY_COMM,BUY_COMM_PC, BUY_COMM_DZ,"
      "BUY_COMM_LUMP_SUM,MKR_DSCT_PER,MKR_DSCT_PC,MKR_DSCT_DZ,MKR_DSCT_LUMP_SUM,"
      "BYMKR_HK_CODE,"
       "BYMKR_ADDR1, BYMKR_ADDR2, BYMKR_ADDR3, BYMKR_ADDR4 "
       " from buyer_maker where record_delete_flag='1' and BYMKR_MULTI_TYPE like '%,"
       */
       mkrCountry=(String)buyerMkerRecord.get(3);
       mkrCity=(String)buyerMkerRecord.get(4);

    }
    Vector recCountry=newtimes.preproduction.guis.tempProperties.tmpCountries;
    if(mkrCountry!=null){
      for (int i = 0; i < recCountry.size(); i++) {
        Record rectmp = (Record) recCountry.get(i);
        Object cntyCode = rectmp.get(0);
        if (util.MiscFunc.isEqual(mkrCountry, cntyCode)) {
          //cbxCountry.setSelectedIndex(i + 1);
          cbxQcQnty.setSelectedIndex(i + 1);
          //System.out.println("Matched,index is:"+i);
          break;
        }
      }
    }else{
      //cbxCountry.setSelectedIndex(0);
      cbxQcQnty.setSelectedIndex(0);
    }
    try{
     recToMapping.set("PROD_CITY_NAME",mkrCity);
     //if(!isInitializingCountriesCbx){
       //the last object is databinded combobox of city list
       dataBoundGUIs.remove(dataBoundGUIs.size()-1);
       dataBoundGUIs.add(
          getCityComboboxByCountry(
            cbxQcQnty.getSelectedItem(),
            cbxCity,recToMapping
          )
       );
     //}
     //System.out.println("after adjust city");

    }catch(Exception exp){
      exp.printStackTrace();
    }

  }
  protected void updateManagerComboBox(){
    String descCenCode=dbCBX_Center.getSelectedValue().toString();
    Vector destManager=(Vector)
        tempProperties.tmpHm_Managers4AllCenters.get(descCenCode);
    tempProperties.tmpManagerRecs.clear();
    tempProperties.tmpManagerRecs.addAll(destManager);
    try{
      if (recToMapping.get("PROD_MNG_CODE") == null) {
        dataBoundGUIs.set(dbCbxMngIndex,
                          new exgui.DataBindJCombobox(cbxManagers,
            "PROD_MNG_CODE",
            tempProperties.tmpManagerRecs,
            "MNG_ABBR", "MNG_CODE",
            util.PublicVariable.USER_RECORD.get("USR_MNG_CODE_DF"),
            "None Manager", "None Manager"
            )
                          );
      } else {
        dataBoundGUIs.set(dbCbxMngIndex,
                          new exgui.DataBindJCombobox(cbxManagers,
            "PROD_MNG_CODE",
            tempProperties.tmpManagerRecs,
            "MNG_ABBR", "MNG_CODE",
            recToMapping.get("PROD_MNG_CODE"),
            "None Manager", "None Manager")
                          );
      }
    }catch(Exception epx){
      epx.printStackTrace();
      util.ExceptionLog.exp2File(epx,"");
    }
    slkHeadBuyer.setSelectingCenter(descCenCode);
    slkHeadMaker.setSelectingCenter(descCenCode);
  }

  void cbxCenter_itemStateChanged(ItemEvent e) {
    if(isProcessingData2Gui)return;
    try{
      //find out the vector to add dbDeps.
      if (dbCBX_Center.getSelectedValue()==null) {
        //only the all dep is allow to add now.
         dbCBX_Dep =
            new exgui.DataBindJCombobox(
            cbxDep,"PROD_DEPTMENT",
            new Vector(),
            "DEP_NAME", "DEP_CODE",
            (String)recToMapping.get("PROD_DEPTMENT"),
            "ALL", null);
        if(dbCbxDepIndex == super.dataBoundGUIs.size()) {
          super.dataBoundGUIs.add(dbCBX_Dep);
        }else{
          //just replace after display & change;
          dataBoundGUIs.set(dbCbxDepIndex,dbCBX_Dep);
        }
      }else {
        //deps and "ALL"dep allow to add.
        Vector depVects=
            (Vector)tempProperties.tmpH_tbl_CenterDepMap.get(
            dbCBX_Center.getSelectedValue());
         dbCBX_Dep=null;
        if(depVects==null){
          dbCBX_Dep =
             new exgui.DataBindJCombobox(
             cbxDep, "PROD_DEPTMENT",
             new Vector(),
             "DEP_NAME", "DEP_CODE",
             (String)recToMapping.get("PROD_DEPTMENT"),
             "ALL", null);
        }else if(depVects.size()>1){
           dbCBX_Dep =
              new exgui.DataBindJCombobox(
              cbxDep, "PROD_DEPTMENT",
              depVects,
              "DEP_NAME", "DEP_CODE",
              recToMapping.get("PROD_DEPTMENT"),
              "ALL", null);
          //guis.add(DbJcbxcbxDep);
        }else{
          dbCBX_Dep =
              new exgui.DataBindJCombobox(
              cbxDep, "PROD_DEPTMENT",
              depVects,
              "DEP_NAME", "DEP_CODE",
              recToMapping.get("PROD_DEPTMENT"));
          //guis.add(DbJcbxcbxDep);
        }

        if (dbCbxDepIndex == dataBoundGUIs.size()) {
          dataBoundGUIs.add(dbCBX_Dep);
        }else{
          dataBoundGUIs.set(dbCbxDepIndex,dbCBX_Dep);
        }
        String loginCenCode=util.PublicVariable.OPERATTING_CENTER.toString();
        int loginLevel=util.PublicVariable.USER_RECORD.getInt(2);//level code
        //'NTHK','NTFE','NTD','NJ','CG','PW','AE','BW'
        if((loginCenCode.equals("NTHK")||
           loginCenCode.equals("NTFE")||
           loginCenCode.equals("NJ")||
           loginCenCode.equals("NTD")||
           loginCenCode.equals("CG")||
           loginCenCode.equals("PW")||
           loginCenCode.equals("AE")||
           loginCenCode.equals("BW")) &&
           (loginLevel==newtimesejb.preproduction.PreProductionHead.USER_TYPE_CEO||
            loginLevel==newtimesejb.preproduction.PreProductionHead.USER_TYPE_SHIPPING_USERS||
            loginLevel==newtimesejb.preproduction.PreProductionHead.USER_TYPE_ACCOUNTING_USERS)){
            updateManagerComboBox();
        }
      }

    }catch(Exception exp){
      exp.printStackTrace();
    }
  }
  void cbxDiv_itemStateChanged(ItemEvent e){
    //if add new,set to default value of txtBuyerLable as div code.
    if(isProcessingPast)return;
    if(recToMapping.getInt(0) < 1){
      if(dbCbxdiv==null)return;
      Object divObj=dbCbxdiv.getSelectedValue();
      if(divObj!=null){
        txtBuyerLabel.setText(cbxDiv.getSelectedItem().toString());
      }else{
        if(txtBuyerLabel.getText().trim().length()==0){
          txtBuyerLabel.setText((divObj == null) ? "" :
                                cbxDiv.getSelectedItem().toString());
        }
      }
    }
  }
  void cbxCountry_itemStateChanged(ItemEvent e) {
  try{
     if(!isInitializingCountriesCbx){
       //the last object is databinded combobox of city list
       dataBoundGUIs.remove(dataBoundGUIs.size()-1);
       dataBoundGUIs.add(
          getCityComboboxByCountry(
            DbJcbxcbxQcCountry.getSelectedValue(),
            //cbxQcQnty.getSelectedItem(),
            cbxCity,recToMapping
          )
       );
     }
    }catch(Exception exp){
      exp.printStackTrace();
    }

  }

/*
  columns are from the sql:
  select a.PROD_CEN_CODE,a.PROD_SEASON,a.PROD_DEPTMENT,a.PROD_YEAR,a.PROD_BUYER,
  a.PROD_BUYER_DIVISION,a.PROD_MAKER,a.PROD_GROUP,a.PROD_GROUP_NAME,a.PROD_RANGE
  ,b.*,c.MTR_V_PREPROD_MTRDTL_PK,d.MTRDTL_MTR_NO
  from prod_head a,preprod b,mtr_v_preprod c,material_detail d
  where  a.PROD_HEAD_PK=b.PREPROD_PROD_PK and c.MTR_V_PREPROD_PK =b.PREPROD_PROD_PK and c.MTR_V_PREPROD_MTRDTL_PK=d.MTRDTL_BYMKR_SEQ
 */
 /*
  protected void printOutRecords(Vector vct){
    for(int i=0;i<vct.size();i++){
      Record rec2show=(Record)vct.get(i);
      System.out.println("record is:"+rec2show.toString());
    }
  }
  */
  public void record2Gui(){
    try{
      java.util.Vector centRecords=tempProperties.tmpCenters;
      java.util.Vector dptRecords=tempProperties.tmpDepartment;
      java.util.Vector dvsnRecords=tempProperties.tmpDivision;
      java.util.Vector sznRecords=tempProperties.tmpSeason;
      java.util.Vector qtaRecords=tempProperties.tmpQtaCtg;
      java.util.Vector tmepRecordsOfProdType=tempProperties.tmpProdType;
      /*
      if (recToMapping.getInt(0) < 1) {
         dbDB_FabComm_N_Reason = new newtimes.preproduction.process.DB_FabComm_N_Reason(true);
      }else{
         dbDB_FabComm_N_Reason = new newtimes.preproduction.process.DB_FabComm_N_Reason();
      }
      */
      if(!isProcessingPast){
        if (recToMapping.getInt(0) < 1) {
          respondingMTR_V_Records = new Vector();
          whiteBkgBlueCharLabel6.setText("PRODUCTION HEAD ADD");
          slkHeadMaker.setModifyNotifyTo(this);
          //btnReasonNoCommInN.setEnabled(false);
           dbDB_FabComm_N_Reason = new newtimes.preproduction.process.DB_FabComm_N_Reason(true);
          btnCopyAllAttrs.setVisible(false);
          if(btnGotoStyles!=null){
            btnGotoStyles.setEnabled(false);
          }
        }
        else {
          dbDB_FabComm_N_Reason = new newtimes.preproduction.process.DB_FabComm_N_Reason();
          String createUsrCode=(String)recToMapping.get("record_create_user");
          lblTitleUserName.setText(createUsrCode);
          //btnReasonNoCommInN.setEnabled(true);
          String titleText="PRODUCTION HEAD EDIT ,AUDIT STATUS:";
          String recCreateDate=df.format(recToMapping.get("record_create_date"));
          titleText+=newtimes.preproduction.Constants.getAuditStatusName(
                 recToMapping.getInt("PRODUCTION_AUDIT_STATUS"));
          String cnfmManager=(String)recToMapping.get("prod_cnfm_mgr_name");
          if(cnfmManager!=null){
            titleText+="  MANAGER:";
            titleText+=cnfmManager;
          }
          String PROD_SC_NO=(String)recToMapping.get("PROD_SC_NO");
          if(PROD_SC_NO!=null){
            titleText += " S/C No.:";
            titleText+=PROD_SC_NO;
          }


          respondingMTR_V_Records =
              myDbHander.getCorespondingMtrlDtlRecords(recToMapping.getInt(0));
          newtimes.preproduction.Constants.PREPROD_USING_MTRL_DTLS =
                            respondingMTR_V_Records;
           whiteBkgBlueCharLabel6.setText(titleText);
           lblDisplayProdheadPK.setText(recToMapping.get(0).toString());
           lbl2ShowCreateDate.setText(" "+recCreateDate);
        }
      }
      isProcessingData2Gui=true;
      mappingListMtrlNo();
      dataBoundGUIs.clear();

      dbCbxNBFcode=
          new exgui.DataBindJCombobox(cbx_NBF_code,
                                      "PRODUCTION_NBF_CODE",
                                      tempProperties.tmpNBFcode,
                                      "NBF",
                                      "NBF",
                                      recToMapping.get("PRODUCTION_NBF_CODE"),"",null);
      dataBoundGUIs.add(dbCbxNBFcode);


      Object objIsSample=recToMapping.get("PROD_IS_SAMPLE");
      if(null==objIsSample||"N".equals(objIsSample)){
         cbxIsSample.setSelectedItem("N");
      }else if("Y".equals(objIsSample)){
        cbxIsSample.setSelectedItem("Y");
      } else if("A".equals(objIsSample)){
        cbxIsSample.setSelectedItem("A");
      } else {
        cbxIsSample.setSelectedItem("B");
      }



      //--
               Object initSupplierSeq=recToMapping.get("PRODUCTION_SUPPLR");
               slkLknSupp.init("PRODUCTION_SUPPLR",(initSupplierSeq==null || initSupplierSeq.toString().trim().length()==0)?null:initSupplierSeq , slkLknSupp.TYPE_MAKER, false);
               dataBoundGUIs.add(slkLknSupp);
          //--

    Object xntCurrency= recToMapping.get("PRODUCTION_SC_CURRENCY");
    exgui.DataBindJCombobox DbJcbxjcbxCurrency = new exgui.DataBindJCombobox(
       cbxCurrency, "PRODUCTION_SC_CURRENCY",newtimes.preproduction.guis.tempProperties.tmpCurrency, "CRNCY_NAME",
       "CRNCY_NAME", (xntCurrency==null)?"USD":xntCurrency);
      dataBoundGUIs.add(DbJcbxjcbxCurrency);

      Object vftxtBuySC_ISU_Date = exgui.verification.CellFormat.
          getDateStringFormaterAllowNull(); ;
      dataBoundGUIs.add(new exgui.DataBindTextWithChecker(txtBuySC_ISU_Date,
          "PRODUCTION_BYR_SC_ISSUE", recToMapping.get("PRODUCTION_BYR_SC_ISSUE"), 10,
          (exgui.Object2String) vftxtBuySC_ISU_Date,
                        (exgui.ultratable.CellTxtEditorFormat)
                             vftxtBuySC_ISU_Date)
                        );
      java.util.Vector recPaymentTerm=
          newtimes.preproduction.guis.tempProperties.tmpPaymentTerms;

      exgui.DataBindJCombobox DbJcbxjcbxPaymentTerm=
          new exgui.DataBindJCombobox(
          cbxScPaymentTerm, "PRODUCTION_PYT_TRM", recPaymentTerm, "PYT_TRM",
          "PYT_TRM", recToMapping.get("PRODUCTION_PYT_TRM"));//,"",null);
      dataBoundGUIs.add(DbJcbxjcbxPaymentTerm);

      exgui.DataBindJCombobox DbJcbxjcbxCTPaymentTerm=
          new exgui.DataBindJCombobox(
          cbxCtPaymentTerm, "PRODUCTION_CT_PYT_TRM", recPaymentTerm, "PYT_TRM",
          "PYT_TRM", recToMapping.get("PRODUCTION_CT_PYT_TRM"));//,"",null);
      dataBoundGUIs.add(DbJcbxjcbxCTPaymentTerm);

    dbCBX_Center= new exgui.DataBindJCombobox(
          cbxCenter,"PROD_CEN_CODE",
          centRecords,"CEN_NAME",
          "CEN_CODE",
          recToMapping.get("PROD_CEN_CODE"));
    dataBoundGUIs.add(dbCBX_Center);
    dbCbxDepIndex=dataBoundGUIs.size();
    dbCBX_Dep = new exgui.DataBindJCombobox(
          cbxDep,
          "PROD_DEPTMENT",
          dptRecords,
          "DEP_NAME",
          "DEP_CODE",
          recToMapping.get("PROD_DEPTMENT"));
     dataBoundGUIs.add(dbCBX_Dep);
     dataBoundGUIs.add(
        new exgui.DataBindJCombobox(cbxLknDep, "PREPROD_LOCKIN_DEPARTMENT", dptRecords,
                                "DEP_NAME", "DEP_CODE",
                                recToMapping.get("PREPROD_LOCKIN_DEPARTMENT"))
      );



     dbCbxDivIndex=dataBoundGUIs.size();
     //design buyerMaker Division
     Object buyerSeq=recToMapping.get("PROD_BUYER");
     if(buyerSeq==null){
       dvsnRecords=new Vector();
     }else{
       dvsnRecords=
           (Vector)tempProperties.tmpHMap_BuyerDivison.get(buyerSeq.toString());
       if(dvsnRecords==null) dvsnRecords=new Vector();
     }

     dbCbxdiv=new exgui.DataBindJCombobox(
          cbxDiv,
          "PROD_BUYER_DIVISION",
          dvsnRecords,
          "DIV_NAME",
          "DIV_CODE",
          recToMapping.get("PROD_BUYER_DIVISION"),"N/A",null);
     cbxDiv.setUI(new exgui.WideComboBoxUI(160));
     dataBoundGUIs.add(dbCbxdiv);

      java.util.Vector recPrxTerm=newtimes.preproduction.guis.tempProperties.tmpPriceTerm;
      exgui.DataBindJCombobox DbJcbxjcbxScPrxTerm= new exgui.DataBindJCombobox(
          cbxScPrxTrm, "PROduction_SC_PRC_TRM", recPrxTerm, "PRC_TRM",
          "PRC_TRM", recToMapping.get("PRODuction_SC_PRC_TRM"));//,"",null);
      dataBoundGUIs.add(DbJcbxjcbxScPrxTerm);

      dbCbxSzn= new exgui.DataBindJCombobox(cbxSzn,
                    "PROD_SEASON",
                    sznRecords,
                    "SEA_NAME","SEA_NAME",
                    recToMapping.get("PROD_SEASON"));

     dataBoundGUIs.add(dbCbxSzn);

     dataBoundGUIs.add(
        new exgui.DataBindJCombobox(
          cbxPrtQtaCtg,"PREPROD_PROTO_QUOTA_CAT",
          qtaRecords,"QTA_CAT","QTA_CAT",
          recToMapping.get("PREPROD_PROTO_QUOTA_CAT"))
     );

     if(recToMapping.get("PROD_MNG_CODE")==null){
       dbCbxMngIndex=dataBoundGUIs.size();
       dataBoundGUIs.add(
         new exgui.DataBindJCombobox(cbxManagers,
                                    "PROD_MNG_CODE",
                                    tempProperties.tmpManagerRecs,
                                    "MNG_ABBR", "MNG_CODE",
                                    util.PublicVariable.USER_RECORD.get("USR_MNG_CODE_DF"),
                                    "None Manager","None Manager"
                                    )
       );
     }else{
       dbCbxMngIndex=dataBoundGUIs.size();
         dataBoundGUIs.add(
             new exgui.DataBindJCombobox(cbxManagers,
                                         "PROD_MNG_CODE",
                                         tempProperties.tmpManagerRecs,
                                         "MNG_ABBR", "MNG_CODE",
                                         recToMapping.get("PROD_MNG_CODE"),
                                         "None Manager","None Manager")
             );
     }
      dataBoundGUIs.add(
        new exgui.DataBindJCombobox(cbxOffShrCntr,
                                    "PROD_OFFSHORE_CENTER",
                                    tempProperties.tmpOffShores,
                                    "CEN_NAME","CEN_CODE",
                                    recToMapping.get("PROD_OFFSHORE_CENTER"))
      );

    //buyer maker selection objects
      if(orgBuyerNameString==null){
        slkHeadBuyer.init("PROD_BUYER", recToMapping.get("PROD_BUYER"),
                          slkHeadBuyer.TYPE_BUYER, false);

      }else{
        slkHeadBuyer.init("PROD_BUYER", recToMapping.get("PROD_BUYER"),orgBuyerNameString,
                          slkHeadBuyer.TYPE_BUYER, false);
      }

      dataBoundGUIs.add(slkHeadBuyer);

      Object initMkrSeq=recToMapping.get("PROD_MAKER");
      if(orgMakerNameString==null){
        slkHeadMaker.init("PROD_MAKER", initMkrSeq, slkHeadBuyer.TYPE_MAKER, false);
      }else{
        slkHeadMaker.init("PROD_MAKER", initMkrSeq, orgMakerNameString,slkHeadBuyer.TYPE_MAKER, false);
      }
      dataBoundGUIs.add(slkHeadMaker);

      Object initAgentSeq=recToMapping.get("PROD_AGENT");
      slkAgent.init("PROD_AGENT",(initAgentSeq==null || initAgentSeq.toString().trim().length()==0)?null:initAgentSeq , slkHeadBuyer.TYPE_BUYER, false);
      dataBoundGUIs.add(slkAgent);




    //text areas.
  Object vftxtGroup = exgui.verification.CellFormat.getOrdinaryField(40);
  dataBoundGUIs.add(new exgui.DataBindTextWithChecker(txtGroup,
      "PROD_GROUP", recToMapping.get("PROD_GROUP"), 40,
      (exgui.Object2String) vftxtGroup,
                    (exgui.ultratable.CellTxtEditorFormat) vftxtGroup)
                    );
  Object vftxtYear = exgui.verification.CellFormat.getOrdinaryFieldNotAllowNull(4);
  dataBoundGUIs.add(new exgui.DataBindTextWithChecker(txtYear, "PROD_YEAR",
      recToMapping.get("PROD_YEAR"), 4, (exgui.Object2String) vftxtYear,
      (exgui.ultratable.CellTxtEditorFormat) vftxtYear)
                    );
  Object vftxtGrpName = exgui.verification.CellFormat.getOrdinaryField(60);
  dataBoundGUIs.add(new exgui.DataBindTextWithChecker(txtGrpName,
      "PROD_GROUP_NAME", recToMapping.get("PROD_GROUP_NAME"), 60,
      (exgui.Object2String) vftxtGrpName,
                    (exgui.ultratable.CellTxtEditorFormat) vftxtGrpName)
                    );

  Object vftxtRange = exgui.verification.CellFormat.getOrdinaryField(40);
dataBoundGUIs.add(new exgui.DataBindTextWithChecker(txtRange,
    "PROD_RANGE", recToMapping.get("PROD_RANGE"), 40,
    (exgui.Object2String) vftxtRange,
                  (exgui.ultratable.CellTxtEditorFormat) vftxtRange)
                  );



  Object vftxtProtoNo = exgui.verification.CellFormat.getOrdinaryField(30);
  dataBoundGUIs.add(new exgui.DataBindTextWithChecker(txtProtoNo,
      "PREPROD_PROTO_NO", recToMapping.get("PREPROD_PROTO_NO"), 30,
      (exgui.Object2String) vftxtProtoNo,
                    (exgui.ultratable.CellTxtEditorFormat) vftxtProtoNo)
                    );
      Object vftxtBuyerLabel = exgui.verification.CellFormat.getOrdinaryField(
        100);
    dataBoundGUIs.add(new exgui.DataBindTextWithChecker(txtBuyerLabel,
        "PRODUCTION_LABEL", recToMapping.get("PRODUCTION_LABEL"), 100,
        (exgui.Object2String) vftxtBuyerLabel,
                      (exgui.ultratable.CellTxtEditorFormat) vftxtBuyerLabel)
                      );
     dataBoundGUIs.add(//new exgui.DataBindEditableJCombobox(
           new exgui.DataBindJCombobox(
            cbxSCDest, "PRODUCTION_SC_DEST", recDests, "Dest_name",
            "dest_name", recToMapping.get("PRODUCTION_SC_DEST")));//,20));

  dataBoundGUIs.add(//new exgui.DataBindEditableJCombobox(
              new exgui.DataBindJCombobox(
              cbxTgtDest, "PRODUCTION_TGT_DEST", recDests, "Dest_name",
              "dest_name", recToMapping.get("PRODUCTION_TGT_DEST")));//,20));



    DbJcbxjcbxBranches= new exgui.DataBindJCombobox(
       cbxBranches, "PRODUCTION_BRNCH_BRIEF", branches, "BRNCH_BRIEF",
       "BRNCH_BRIEF", recToMapping.get("PRODUCTION_BRNCH_BRIEF"));
   dataBoundGUIs.add(DbJcbxjcbxBranches);

    DbJcbxjcbxCtBranches= new exgui.DataBindJCombobox(
       cbxCtBranches, "PRODXN_CT_BRANCH", branches, "BRNCH_BRIEF",
       "BRNCH_BRIEF", recToMapping.get("PRODXN_CT_BRANCH"));
   dataBoundGUIs.add(DbJcbxjcbxCtBranches);


   Object vftxtSCHeadRmk = exgui.verification.CellFormat.getOrdinaryField(
       30);
   dataBoundGUIs.add(new exgui.DataBindTextWithChecker(txtBuyerSCNO,
       "PRODUCTION_BYR_SC_NO", recToMapping.get("PRODUCTION_BYR_SC_NO"), 30,
       (exgui.Object2String) vftxtSCHeadRmk,
                     (exgui.ultratable.CellTxtEditorFormat) vftxtSCHeadRmk)
                     );



   //note!! GsReq field is automatically  caculated as txtProdByrPlnDlvy-150 days.
   Object vftxtProdByrPlnDlvy=new BuyerPlanDelvChk();//exgui.verification.CellFormat.getDateStringFormater();
   buyerPlanDlvDbCheck= new exgui.DataBindTextWithChecker(txtProdByrPlnDlvy,
       "PRODUCTION_BYR_PLAN_DEL",
       recToMapping.get("PRODUCTION_BYR_PLAN_DEL"),
       10,(exgui.Object2String)vftxtProdByrPlnDlvy,
       (exgui.ultratable.CellTxtEditorFormat)vftxtProdByrPlnDlvy);
   dataBoundGUIs.add(buyerPlanDlvDbCheck);

     dbCbxProdType=
         new exgui.DataBindJCombobox(cbxProductionType,
                                     "PRODUCTION_TYPE",
                                     tmepRecordsOfProdType,
                                     "TYPE_NAME",
                                     "TYPE_CODE",
                                     recToMapping.get("PRODUCTION_TYPE"));
     dataBoundGUIs.add(dbCbxProdType);

     dbCbxExchangeShipDocIndex =dataBoundGUIs.size();
     dbCbxExchangeDoc=
         new exgui.DataBindJCombobox(cbxExchageShipDoc,
                                     "PRODUCTION_XG_DOC",
                                     tempProperties.tmpYesNoNull,
                                     "YES_NO_NULL",
                                     "YES_NO_NULL",
                                     recToMapping.get("PRODUCTION_XG_DOC"),"N/A",null);
     dataBoundGUIs.add(dbCbxExchangeDoc);


   //make the countries and cities related combobox.
      isInitializingCountriesCbx=true;
       DbJcbxcbxQcCountry =
           new exgui.DataBindJCombobox(cbxQcQnty,
                                       "PRODUCTION_QC_CNTY",
                                       tempProperties.tmpCountries,
                                       "CNTY_NAME","CNTY_NAME",
                                       recToMapping.get("PRODUCTION_QC_CNTY"),"NONE",null);
       dataBoundGUIs.add(DbJcbxcbxQcCountry);


       isInitializingCountriesCbx=false;
       dataBoundGUIs.add(
           getCityComboboxByCountry(
             DbJcbxcbxQcCountry.getSelectedValue(),
             cbxCity,recToMapping
            )
          );

    //begin to collect the columns allow to future copy...
    if(recordColumnsToCopy==null){
      recordColumnsToCopy=new String[dataBoundGUIs.size()+1];//add the "is sample field
      int i=0;
      for (i = 0; i < dataBoundGUIs.size(); i++) {
       recordColumnsToCopy[i]=((exgui.DataBindGUIObject)dataBoundGUIs.get(i)).getOrgRecField();
      }
      recordColumnsToCopy[i]="PROD_IS_SAMPLE";
    }



    Object prodStatusObj=
        recToMapping.get("PRODUCTION_AUDIT_STATUS");
    if(prodStatusObj!=null){
      int auditStatusCode=recToMapping.getInt("PRODUCTION_AUDIT_STATUS");
      if(auditStatusCode==
        newtimesejb.preproduction.PreProductionHead.AUDIT_STATUS_CONFIRMED||
        auditStatusCode==
        newtimesejb.preproduction.PreProductionHead.AUDIT_STATUS_PRINTED){

       if(util.PublicVariable.USER_RECORD.getInt("USR_TYPE")==
          newtimesejb.preproduction.PreProductionHead.USER_TYPE_SUPERVIOSER_MIS
          && util.PublicVariable.OPERATTING_CENTER.equals("001")){
       }else{
         if(util.PublicVariable.OPERATTING_CENTER.equals("001")){
           slkHeadBuyer.setEnabled(false);
           slkHeadMaker.setEnabled(false);
         }
       }

       /*
       cbxScPrxTrm.setEnabled(false);
       cbxScPrxTrm.setEditable(false);
       cbxScPrxTrm.setFocusable(false);
       cbxCurrency.setEnabled(false);
       cbxCurrency.setEditable(false);
       cbxCurrency.setFocusable(false);
        */
     }
    }
     if(!isProcessingPast){
       //for fabric commision No,we don't have to support it.
       //shows fabric commision columns to radio box.
       //key fields are PROD_FABCOMM_CONTRACT, PROD_FABCOMM_REFNO
       if (recToMapping.getInt(0) < 1) {
         //make sure all data is cleared
          rdoFabCmm_TypeContract.setSelected(false);
          rdoFabCmm_TypeRefNo.setSelected(false);
          rdoFabCmm_TypeNone.setSelected(false);
          txtFabCmmContract.setText("");
          txtFabCmmContract.setEnabled(false);
          btnEditFabCmmList.setEnabled(false);
          lblFabCmmRefNo.setText("");

       } else {
         Object objFabCmmCtxNo = recToMapping.get(
             "PRODUCTION_FABCOMM_CONTRACT");
         Object objFabCmmRefNo = recToMapping.get("PRODUCTION_FABCOMM_REFNO");
         if (objFabCmmCtxNo != null) {
           rdoFabCmm_TypeContract.setSelected(true);
           txtFabCmmContract.setText(objFabCmmCtxNo.toString());
           lblFabCmmRefNo.setText("");
           btnEditFabCmmList.setEnabled(false);
           txtFabCmmContract.setEnabled(true);
         } else if (objFabCmmRefNo != null) {
           rdoFabCmm_TypeRefNo.setSelected(true);
           lblFabCmmRefNo.setText(objFabCmmRefNo.toString());
           btnEditFabCmmList.setEnabled(true);
           txtFabCmmContract.setText("");
           txtFabCmmContract.setEnabled(false);
         } else {
           rdoFabCmm_TypeNone.setSelected(true);
           txtFabCmmContract.setText("");
           lblFabCmmRefNo.setText("");
           btnEditFabCmmList.setEnabled(false);
           txtFabCmmContract.setEnabled(false);
         }
       }
     }
     int usr_type_id=util.PublicVariable.USER_RECORD.getInt("USR_TYPE");
     if(usr_type_id==
        newtimesejb.preproduction.PreProductionHead.USER_TYPE_SHIPPING_USERS||
        usr_type_id==
        newtimesejb.preproduction.PreProductionHead.USER_TYPE_ACCOUNTING_USERS||
        usr_type_id==
        newtimesejb.preproduction.PreProductionHead.USER_TYPE_OTHERS){
        btnCopyAllAttrs.setEnabled(false);
        java.awt.Component cmp[]=subPnlFabComm.getComponents();
        for(int i=0;i<cmp.length;i++){
          cmp[i].setEnabled(false);
        }
     }

              if(util.PublicVariable.OPERATTING_CENTER.equals("001")){
                String NameBuyer=((javax.swing.text.JTextComponent)slkHeadBuyer.getGUIcomponent()).getText();
                if((NameBuyer.equals("KOMAR NY")||NameBuyer.equals("KOMAR UK"))){
                  lblExchageShipDoc.setVisible(true);
                  cbxExchageShipDoc.setVisible(true);
                }else{
                  lblExchageShipDoc.setVisible(false);
                  cbxExchageShipDoc.setVisible(false);
                }
              }
//////
              /*
      if(lblFabCmmRefNo.getText().length()>0 && rdoFabCmm_TypeRefNo.isSelected()){
        //to keep fabcommpo mapping for buyer 82,unleass fab-comm-po record cleared
        if(util.PublicVariable.USER_RECORD.getInt("USR_TYPE")==
          newtimesejb.preproduction.PreProductionHead.USER_TYPE_SUPERVIOSER_MIS
          && util.PublicVariable.OPERATTING_CENTER.equals("001")
          ){

         } else{
          slkHeadBuyer.setEnabled(false);
         }
      }
*/
      if(util.PublicVariable.USER_RECORD.getInt("USR_TYPE")==
        newtimesejb.preproduction.PreProductionHead.USER_TYPE_SUPERVIOSER_MIS
        && util.PublicVariable.OPERATTING_CENTER.equals("001")
        && recToMapping.getInt(0)>1
        ){
         //test if this record have batch or not
         Vector vctTestBh=exgui2.CONST.BASIC_MAIN_EJB.getDatas(
          util.PublicVariable.USER_RECORD,
            "select * from TPE_NB_BATCH_NO where prod_head_pk="+String.valueOf(recToMapping.getInt(0))
            ,1,99999);
         if(vctTestBh.size()>0){
           Record recTest=(Record)vctTestBh.get(0);
           txtBatchNo.setText((String)recTest.get(1));
         }
         lblBatchNo.setVisible(true);
         txtBatchNo.setVisible(true);
      }else{
        lblBatchNo.setVisible(false);
        txtBatchNo.setVisible(false);
      }
  }catch(Exception e){
      e.printStackTrace();
  }
    isGrayied=false;
    isProcessingData2Gui=false;
    cbxCenter.getItemListeners()[0].itemStateChanged(null);
    //cbxCountry_itemStateChanged(null);
  }

  public class BuyerPlanDelvChk
     implements exgui.ultratable.CellTxtEditorFormat,exgui.Object2String{
     Object dateVfy=exgui.verification.CellFormat.getDateStringFormater();
     Object buyPlanBgn=newtimes.preproduction.Constants.SYSTEM_DEFAULT_RECORD.get(18);//delivery of system default value
         //newtimes.preproduction.Constants.SYSTEM_DEFAULT_RECORD.get(16);//delivery of system default value
     Object buyPlanEnd=newtimes.preproduction.Constants.SYSTEM_DEFAULT_RECORD.get(19);//delivery of system default value
         //newtimes.preproduction.Constants.SYSTEM_DEFAULT_RECORD.get(17);//delivery of system default value
    String prompt4Invailid;
    public BuyerPlanDelvChk(){
      //System.out.println("buyPlanBgn class is "+buyPlanBgn.getClass().getName());
      df.setLenient(false);
      if(buyPlanBgn!=null && buyPlanEnd==null){
        prompt4Invailid="String format is yyyy/mm/dd and after "+
            df.format((java.sql.Timestamp)buyPlanBgn);
        return;
      }
      if(buyPlanBgn==null && buyPlanEnd!=null){
        prompt4Invailid="String format is yyyy/mm/dd and before "+
            df.format((java.sql.Timestamp)buyPlanEnd);
        return;
      }
      if(buyPlanBgn!=null && buyPlanEnd!=null){
        prompt4Invailid="String format is yyyy/mm/dd and between "+
            df.format((java.sql.Timestamp)buyPlanBgn)+"~"+df.format((java.sql.Timestamp)buyPlanEnd);
        return;
      }
      prompt4Invailid="String format is yyyy/mm/dd";
    }
    public exgui.ultratable.KeyProcess getKeyListener(){
      return ((exgui.ultratable.CellTxtEditorFormat)dateVfy).getKeyListener();
    }
    public String Obj2String(Object vluObj){return ((exgui.Object2String)dateVfy).Obj2String(vluObj);}
    public Object cellStringToObject(String str){
      return ((exgui.ultratable.CellTxtEditorFormat)dateVfy).cellStringToObject(str);
    }
    public String formatPromptMsg(){
      return prompt4Invailid;
    }
    public boolean isValidx(){
      return isFormatValid(txtProdByrPlnDlvy.getText(),0,0);
    }
    public boolean isFormatValid(String dataStr,int i,int j){
      //if have S/C No.skip it.
        if (util.MiscFunc.getFieldIndexAtRecord(recToMapping, "prod_sc_no") !=
            -1) {
          try{
          String sc_no = (String)recToMapping.get("PROD_SC_NO");

          java.util.Date orgBuyerPlanDelObj = (java.util.Date)recToMapping.get(
              "PRODUCTION_BYR_PLAN_DEL");
          if (sc_no != null &&
              df.format(orgBuyerPlanDelObj).equals(txtProdByrPlnDlvy.getText().
              trim())) {
            return true;
          }
        } catch (Exception exp) {
          exp.printStackTrace();
          util.ExceptionLog.exp2File(exp, "");
        }
      }


      if(dataStr==null||dataStr.trim().length()==0)return false;
      if(!((exgui.ultratable.CellTxtEditorFormat)dateVfy).isFormatValid(dataStr,i,j))
        return false;
      //test if between the system-default-value of plan delivery date need to check or not
      if(buyPlanBgn==null&&buyPlanEnd==null){
        return true;
      }
      if(isProcessingExit)return true;
      long miscSecBgn=(buyPlanBgn==null)?0:((java.sql.Timestamp)buyPlanBgn).getTime();
      long miscSecEnd=(buyPlanEnd==null)?0:((java.sql.Timestamp)buyPlanEnd).getTime();
      long miscPlanDel=
          ((java.util.Date)cellStringToObject(txtProdByrPlnDlvy.getText())).getTime();
      if(miscSecBgn!=0){
        if(miscPlanDel<miscSecBgn)return false;
      }
      if(miscSecEnd!=0){
        if(miscPlanDel>miscSecEnd)return false;
      }
      return true;
    }
    public int getMaxLength(){return 10;}
  }

  protected exgui.DataBindJCombobox getCityComboboxByCountry(Object cntyName,
      JComboBox cbx,Record rec2map)throws Exception{
      Vector citiesVct=null;;
      if(cntyName!=null){
         citiesVct=(Vector)tempProperties.tmpH_tbl_CntyCityMap.get(cntyName);
      }
      if(citiesVct==null)citiesVct=new Vector();

      cbxCity.removeAllItems();
      if(citiesVct!=null && citiesVct.size()>1){
      exgui.DataBindJCombobox DbJcbxcbxCity =
          new exgui.DataBindJCombobox(cbxCity,
                                      "PROD_CITY_NAME",
                                      citiesVct,
                                      "CITY_NAME","CITY_NAME",
                                      rec2map.get("PROD_CITY_NAME"),"NONE",null);
        DbJcbxcbxCity.toMustModify();
        dbCbxCity= DbJcbxcbxCity;
        return  DbJcbxcbxCity;
      }else{
        exgui.DataBindJCombobox DbJcbxcbxCity =
            new exgui.DataBindJCombobox(cbxCity,
                                        "PROD_CITY_NAME",
                                        citiesVct,
                                        "CITY_NAME","CITY_NAME",
                                        rec2map.get("PROD_CITY_NAME"),"NONE",null);
        DbJcbxcbxCity.toMustModify();
        dbCbxCity= DbJcbxcbxCity;
        return DbJcbxcbxCity;
      }

  }
  public void doUpdate() throws Exception{
    if(isProcessingAddNew)return;
    isGui2RecordOk=gui2Record();
    if(!isGui2RecordOk) return;
    Cursor ksr=null;
    if(util.PublicVariable.APP_FRAME!=null){
     ksr=util.PublicVariable.APP_FRAME.getCursor();
     util.PublicVariable.APP_FRAME.setCursor(new Cursor(Cursor.WAIT_CURSOR));
    }
      try{
        isProcessingAddNew=true;
        util.MiscFunc.showProcessingMessage();
        boolean need2InsertFabComm=false;
          if(rdoFabCmm_TypeRefNo.isSelected() &&
             fabCommRecords!=null &&
             fabCommRecords.size()>0&&
             //lblFabCmmRefNo.getText().trim().equals("")&&
             recToMapping.get("PRODUCTION_FABCOMM_REFNO")==null){
            //the fabric commision ref-no is not generated,force to generate it.
            //use "-" to trigger ejb to get fabric comm no.
            recToMapping.set("PRODUCTION_FABCOMM_REFNO","-asfdasx");
            need2InsertFabComm=true;
          }
        Record updatedRecord= myDbHander.addRecord(recToMapping);
        if(dbCbxNBFcode.getSelectedValue()!=null && dbCbxNBFcode.getSelectedValue().equals("N") &&
                      rdoFabCmm_TypeNone.isSelected()   && isTpeUser){
          if(dbDB_FabComm_N_Reason.isDummy()){
            dbDB_FabComm_N_Reason.insertRecord(updatedRecord.getInt(0));
          }
        }
        if(need2InsertFabComm){
              String fabRefNo=(String)updatedRecord.get("PRODUCTION_FABCOMM_REFNO");
              myDbHander.setFabricCommisions(fabCommRecords,
              updatedRecord.getInt(0),
              fabRefNo);
              recToMapping.set("PRODUCTION_FABCOMM_REFNO",fabRefNo);
             lblFabCmmRefNo.setText(fabRefNo);
             rdoFabCmm_TypeRefNo.setSelected(true);
        }
        processhandler.template.Properties.getCenteralControler().setCurrentEditingMasterRecord(
          updatedRecord
        );
        newtimes.production.ProdMaintain_Properties.PRODUCTION_AUDIT_STATUS_COLUMN_NAME="PRODUCTION_AUDIT_STATUS";
        newtimes.preproduction.Constants.CURRENT_PREPROD_HEAD_PK=updatedRecord.getInt(0);
        newtimes.preproduction.Constants.CURRENT_PREPROD_HEAD_RECORD=updatedRecord;
        newtimes.preproduction.Constants.PREPROD_USING_MTRL_DTLS =
                  respondingMTR_V_Records;
         //swith to detail page..,color lib edit page...
        util.MiscFunc.hideProcessingMessage();
        //preper fo next page,skip re-init byer maker selection process
        newtimes.preproduction.guis.tempProperties.orgProdHeadBuyerString.setLength(0);
        newtimes.preproduction.guis.tempProperties.orgProdHeadMakerString.setLength(0);
        String orgBuyer=((javax.swing.text.JTextComponent)slkHeadBuyer.getGUIcomponent()).getText();
        String orgMaker=((javax.swing.text.JTextComponent)slkHeadMaker.getGUIcomponent()).getText();
        newtimes.preproduction.guis.tempProperties.orgProdHeadBuyerString.append(orgBuyer);
        newtimes.preproduction.guis.tempProperties.orgProdHeadMakerString.append(orgMaker);
        if(needToChkBuyerDivModified){
          newtimes.production.process.prodmaintain.DB_StyleListHandler styHndl=
              new newtimes.production.process.prodmaintain.DB_StyleListHandler();
          styHndl.reSetBuyerCommision(recToMapping.getInt(0));
        }
        if(btnGotoStyles!=null && (!btnGotoStyles.isEnabled())){
          btnGotoStyles.setEnabled(true);
          if(whiteBkgBlueCharLabel6.getText().trim().equalsIgnoreCase("PRODUCTION HEAD ADD")){
            this.setRecord(updatedRecord);
            this.record2Gui();
            if(!util.PublicVariable.OPERATTING_CENTER.equals("001")){
              exgui.verification.VerifyLib.showPlanMsg("RECORD CREATE OK,PK NO IS:"+String.valueOf(newtimes.preproduction.Constants.CURRENT_PREPROD_HEAD_PK),
                                                       "PO HEADER CREATE OK");
            }
            lblDisplayProdheadPK.setText(String.valueOf(newtimes.preproduction.Constants.CURRENT_PREPROD_HEAD_PK));
            whiteBkgBlueCharLabel6.setText("PRODUCTION HEAD EDIT ,AUDIT STATUS:EDITING");
          }
        }
        recClonedForCheck= (Record)util.MiscFunc.deepCopy(updatedRecord);//(Record)util.MiscFunc.deepCopy(recToMapping);
        /*
        processhandler.template.Properties.getCenteralControler().doCommandExecute(
         new newtimes.production.process.prodmaintain.TgrToListStyles()
         );
         */
        newtimes.preproduction.Constants.BYMKR_WAREHOUSE_STRING=null;
      }catch(Exception e){
        //e.printStackTrace();
        throw e;
      }finally{
        isProcessingAddNew=false;
        util.MiscFunc.hideProcessingMessage();
        if(ksr!=null){
         //setCursor(ksr);
          util.PublicVariable.APP_FRAME.setCursor(ksr);
        }
      }
  }
  public void doAddNew() throws Exception{
       if(isProcessingAddNew)return;
      isGui2RecordOk=gui2Record();
      Cursor ksr=null;
      if(!isGui2RecordOk) return;
      if(util.PublicVariable.APP_FRAME!=null){
       ksr=util.PublicVariable.APP_FRAME.getCursor();
       util.PublicVariable.APP_FRAME.setCursor(new Cursor(Cursor.WAIT_CURSOR));
      }
      try{
        isProcessingAddNew=true;
        util.MiscFunc.showProcessingMessage();
        //test if fabric commision exists.
        boolean need2InsertFabComm=false;
        if(rdoFabCmm_TypeRefNo.isSelected() && fabCommRecords!=null && fabCommRecords.size()>0){
          //use "-" to trigger ejb to get fabric comm no.
          recToMapping.set("PRODUCTION_FABCOMM_REFNO","-asfdasx");
          need2InsertFabComm=true;
        }
        Record rec=myDbHander.addRecord(recToMapping);
        //switch to color lib detail page..
        rec=myDbHander.findbyPk(rec.getInt(0));
        if(need2InsertFabComm)myDbHander.setFabricCommisions(fabCommRecords,rec.getInt(0),(String)rec.get("PRODUCTION_FABCOMM_REFNO"));
        recClonedForCheck=(Record)util.MiscFunc.deepCopy(recToMapping);
        newtimes.preproduction.Constants.CURRENT_PREPROD_HEAD_PK=rec.getInt(0);
        processhandler.template.Properties.getCenteralControler().setCurrentEditingMasterRecord(
          rec
        );

       newtimes.preproduction.Constants.CURRENT_PREPROD_HEAD_RECORD=rec;
        newtimes.preproduction.Constants.PREPROD_USING_MTRL_DTLS =
                          respondingMTR_V_Records;

     //preper fo next page,skip re-init byer maker selection process
     newtimes.preproduction.guis.tempProperties.orgProdHeadBuyerString.setLength(0);
     newtimes.preproduction.guis.tempProperties.orgProdHeadMakerString.setLength(0);
     String orgBuyer=((javax.swing.text.JTextComponent)slkHeadBuyer.getGUIcomponent()).getText();
     String orgMaker=((javax.swing.text.JTextComponent)slkHeadMaker.getGUIcomponent()).getText();
     newtimes.preproduction.guis.tempProperties.orgProdHeadBuyerString.append(orgBuyer);
     newtimes.preproduction.guis.tempProperties.orgProdHeadMakerString.append(orgMaker);
     newtimes.preproduction.Constants.BYMKR_WAREHOUSE_STRING=null;
        processhandler.template.Properties.getCenteralControler().doCommandExecute(
         new newtimes.production.process.prodmaintain.TgrToListPlanQuotaWithProdHead());

      }catch(Exception e){
         throw e;
      }finally{
        isProcessingAddNew=false;
        util.MiscFunc.hideProcessingMessage();
        if(ksr!=null){
         //setCursor(ksr);
          util.PublicVariable.APP_FRAME.setCursor(ksr);
        }
      }
    //if this is a "master data,we can call "AbleToShowDetial" of current command object.
  }
  public void setGotoStyle(){
    isGotoStyle=true;
  }
  public void doDelete() {
    try{
      if(recToMapping.get("PROD_SC_NO")!=null){
         exgui.verification.VerifyLib.showPlanMsg("Please Cancel S/C No Before Delete This Production Head",
                                                  "Please Cancel S/C No Firstly");
         return ;
      }
      if(!exgui.verification.VerifyLib.showConfirm(
          "Are You Sure To Delete This Production?","Are You Sure?")) return;
      util.MiscFunc.showProcessingMessage();
      super.doDelete();
      util.MiscFunc.hideProcessingMessage();

      isProcessingDelete=true;//avoid "isContextModifed()" checking.
      processhandler.template.Properties.getCenteralControler().goBack();
    }catch(Exception e){
      e.printStackTrace();
    }
  }
  public void doCopy() {
     //call gui2Record,mapping data fields to record column.
     try{
       isProcessingCopy=true;
       gui2Record();
       Record tmprec = (Record) util.MiscFunc.deepCopy(recToMapping);
       util.ApplicationProperites.setProperties(
           id4ApplicationProperties,
           tmprec
           );
       //also,we need to copy the co-responding MTR_V_PREPROD records..
       Vector vct2Copy=(Vector)util.MiscFunc.deepCopy(respondingMTR_V_Records);
       util.ApplicationProperites.setProperties(
           id4ApplicationProperties+"_MTR_V_Records",
           vct2Copy
           );

     }catch(Exception e){
        e.printStackTrace();
     }finally{
       isProcessingCopy=false;
     }
  }
  public boolean gui2Record(){
    //when super class call myDbHander to update record,also,update co-responding MTR_V_Records
    myDbHander.setMTR_V_Records(respondingMTR_V_Records);
    if(!super.gui2Record())return false;
    if(DbJcbxjcbxBranches.getSelectedValue()==null){
       exgui.verification.VerifyLib.showAlert("Please Select S/C Branch","Please Select S/C  Branch");
       return false;
    }
    if(DbJcbxjcbxCtBranches.getSelectedValue()==null){
       exgui.verification.VerifyLib.showAlert("Please Select C/T Branch","Please Select C/T Branch");
       return false;
    }


    if(dbCbxNBFcode.getSelectedValue()==null){
      //tpe user have to select NBF code
      if(isTpeUser){
        exgui.verification.VerifyLib.showAlert(
        "Please Assigne N/B/F code",
        "Please Assigne N/B/F");
        cbx_NBF_code.grabFocus();
        return false;
      }
    }
    if(dbCbxNBFcode.getSelectedValue()!=null && dbCbxNBFcode.getSelectedValue().equals("N") &&
      rdoFabCmm_TypeNone.isSelected() && isTpeUser){
      try{
        Record recFabCommNReason = dbDB_FabComm_N_Reason.getRecordByPk(
            recToMapping.getInt(0));
        Object objReason= recFabCommNReason.get(1);
        if(objReason==null || objReason.toString().trim().length()==0){
            exgui.verification.VerifyLib.showAlert("Pleaes Input Fab Commission Type \"N\" Reason ",
                                                   "Pleaes Input Fab Commission Type \"N\" Reason ");
            return false;
        }
      }catch(Exception exp){
        exp.printStackTrace();
      }
    }
    //verify the fabric commision data
    try{
      recToMapping.set("PROD_IS_SAMPLE",cbxIsSample.getSelectedItem());

      if(recToMapping.get("PRODUCTION_TGT_DEST")==null || recToMapping.get("PRODUCTION_TGT_DEST").toString().trim().length()==0){
        exgui.verification.VerifyLib.showAlert(
        "Please Assigne "+alertDest,
        "Please Assigne "+alertDest);
        return false;
      }
      if(recToMapping.get("PRODUCTION_SC_DEST")==null|| recToMapping.get("PRODUCTION_SC_DEST").toString().trim().length()==0){
        exgui.verification.VerifyLib.showAlert(
        "Please Assigne "+alertPort,
        "Please Assigne "+alertPort);
        return false;
      }
      if ((!rdoFabCmm_TypeContract.isSelected()) &&
          (!rdoFabCmm_TypeNone.isSelected()) &&
          (!rdoFabCmm_TypeRefNo.isSelected())) {
        exgui.verification.VerifyLib.showAlert(
            "Please Select A Fabric Commision Type",
            "Please Select A Fabric Commision Type");
        return false;
      }
      if (rdoFabCmm_TypeContract.isSelected()) {
        if (txtFabCmmContract.getText().trim().length() == 0) {
          exgui.verification.VerifyLib.showAlert(
              "Please Assigne Fabric Commision Contract No.",
              "Please Assigne Fabric Commision Contract No.");
          txtFabCmmContract.grabFocus();
          return false;
        } else {
          recToMapping.set("PRODUCTION_FABCOMM_CONTRACT",
                           txtFabCmmContract.getText().trim().toUpperCase());
          recToMapping.set("PRODUCTION_FABCOMM_REFNO",null);
        }
      }
      if(rdoFabCmm_TypeNone.isSelected()){
        recToMapping.set("PRODUCTION_FABCOMM_CONTRACT",null);
        recToMapping.set("PRODUCTION_FABCOMM_REFNO",null);
      }
      //if buyer or division changed,need to update the styles commmisions co-responding to this buyer/division

    }catch(Exception e){
         e.printStackTrace();
    }
    //test :buyuer,buyer_div ,center,department can not be null.
    if(!buyerPlanDlvDbCheck.isValidx()){
      exgui.verification.VerifyLib.showAlert("Please Assign Buyer Plan Delivery Date",
                                             "Please Assign Buyer Plan Delivery");
      buyerPlanDlvDbCheck.getGUIcomponent().grabFocus();

      return false;
    }
    if(this.slkHeadBuyer.getSelectedValue()==null){
      exgui.verification.VerifyLib.showAlert("Please Assign A Buyer Of This Product",
                                             "Please Select A Buyer");
      slkHeadBuyer.grabFocus();
      return false;
    }
    //but for HK user ,skip this requirement of checking maker and qc country.
    if(util.PublicVariable.OPERATTING_CENTER.equals("001")){
      if(this.slkHeadMaker.getSelectedValue()==null){
        exgui.verification.VerifyLib.showAlert("Please Assign A Maker Of This Product",
                                               "Please Select A Maker");
        slkHeadMaker.grabFocus();
        return false;
      }

      if (DbJcbxcbxQcCountry.getSelectedValue() == null) {
        exgui.verification.VerifyLib.showAlert(
            "Please Assign A QC Country Of This Product",
            "Please Select A QC Country");
        cbxQcQnty.grabFocus();
        return false;
      }
      if (DbJcbxcbxQcCountry.getSelectedValue().toString().equalsIgnoreCase(
          "china")) {
        if (dbCbxCity.getSelectedValue() == null) {
          exgui.verification.VerifyLib.showAlert("Please Select City",
                                                 "Please Select City");
          cbxCity.grabFocus();
          return false;
        }
      }
    }
    //detect if have to select division.
    //if production type is wozen,knit,sweater,have to check if year is 4 digit and season can not be null
    try{
      if(isProcessingCopy){
      }else{
        int cnvYearData =
            Integer.parseInt(txtYear.getText().trim());
        Object objBgnYear =
            newtimes.preproduction.Constants.SYSTEM_DEFAULT_RECORD.get(
            "year_rng_bgn");
        Object objEndYear =
            newtimes.preproduction.Constants.SYSTEM_DEFAULT_RECORD.get(
            "year_rng_end");
        if (objBgnYear != null) {
          int bgnYear = Integer.parseInt(objBgnYear.toString());
      //    System.out.println(cbxDep.getSelectedItem().toString());
          if (cnvYearData < bgnYear && (!isProcessingExit) && (!isGotoStyle) && (!cbxDep.getSelectedItem().toString().equals("MM - LYDIA"))) {
            //>>
            exgui.verification.VerifyLib.showAlert(
                "Year Can not less than " + bgnYear,
                "Year Can not less than " + bgnYear);
            txtYear.grabFocus();
            return false;
          }
        }
        if (objEndYear != null) {
          int endYear = Integer.parseInt(objEndYear.toString());
          if (cnvYearData > endYear && (!isProcessingExit) && (!isGotoStyle)) {
            exgui.verification.VerifyLib.showAlert(
                "\"Year\" Can not more than " + endYear,
                "\"Year\" Can not more than " + endYear);
            txtYear.grabFocus();
            return false;
          }
        }
      }
      if(slkHeadBuyer.getSelectedValue()!=null){
       /*
        Record buyermakerRecordTestDiv =
            (Record)
            exgui2.CONST.BASIC_MAIN_EJB.getDatas(util.PublicVariable.USER_RECORD,
                                                 "select BYMKR_CHECK_DIV from buyer_maker where BYMKR_SEQ="+
                                                 slkHeadBuyer.getSelectedValue().toString(),1,999).get(0);*/
          //buyerChangerHandler.changeBuyerMaker(buyermakerRecord);//force to check if buyer have to check division
          Record buyermakerRecord=slkHeadBuyer.currentRecord();
          if(buyermakerRecord!=null){
            String checkDivFlag = (String)buyermakerRecord.get("BYMKR_CHECK_DIV");
            needtoCheckDiv = false;
            if (checkDivFlag != null) {
              if (checkDivFlag.trim().equalsIgnoreCase("Y")) {
                needtoCheckDiv = true;
              }
            }
          }

      }
      //for KOMAR BUYER,have to check "EXCHANGE SHIP-DOC" field
      if(cbxExchageShipDoc.isVisible()){
        if(cbxExchageShipDoc.getSelectedItem().equals("N/A")){
          exgui.verification.VerifyLib.showAlert("請選擇是否允許交換船務文件",
                                                 "請選擇是否允許交換船務文件");
          return false;
        }
      }
    }catch(Exception e){
      exgui.verification.VerifyLib.showAlert("\"Year\" Column Should Be 4 digits",
                                             "\"Year\" Column Should Be 4 digits");
      txtYear.grabFocus();
      return false;
    }
    if(needtoCheckDiv){
      if(dbCbxdiv.getSelectedValue()==null){
        exgui.verification.VerifyLib.showAlert("Please Assign A Division Of This Product Buyer",
                                               "Please Select A Division");
        dbCbxdiv.grabFocus();
        return false;
      }
    }
    try{
      java.util.Vector centRecords=tempProperties.tmpCenters;
      java.util.Vector dptRecords=tempProperties.tmpDepartment;
      //java.util.Vector dvsnRecords=tempProperties.tmpDivision;
      /*
      if (recToMapping.get("PROD_BUYER_DIVISION") == null) {
          Record firstDivRec=(Record)dvsnRecords.get(0);
          recToMapping.set("PROD_BUYER_DIVISION",firstDivRec.get("DIV_CODE"));
      }
      */
      if (recToMapping.get("PROD_CEN_CODE") == null) {
          Record firstCenRec=(Record)centRecords.get(0);
          recToMapping.set("PROD_CEN_CODE",firstCenRec.get("CEN_CODE"));
      }
      if (recToMapping.get("PROD_DEPTMENT") == null) {
          Record firstDptRec=(Record)dptRecords.get(0);
          recToMapping.set("PROD_DEPTMENT",firstDptRec.get("DEP_CODE"));
      }
      //copy the string from "production destination combobox"
      //System.out.println("destString is :"+recToMapping.get("production_sc_dest"));
      Object objDest=recToMapping.get("production_sc_dest");

      String deststring=(objDest==null)?"":objDest.toString().trim().toUpperCase();
      if(deststring.getBytes().length>30){
        exgui.verification.VerifyLib.showAlert("Destination Can Not Over 30 Characters",
                                               "Field:Destination Is Too Long");
        return false;
      }else{
        recToMapping.set("production_sc_dest",deststring);
      }
    }catch(Exception e){
      e.printStackTrace();
      return false;
    }
    //need to check if buyer /division changed
    //PROD_BUYER, PROD_BUYER_DIVISION
    needToChkBuyerDivModified=false;
    try{
    if(recToMapping.getInt(0) > 1 && util.PublicVariable.OPERATTING_CENTER.equals("001")){
      java.util.List mdfyFields = recToMapping.getFieldName();
      for(int i=0;i<mdfyFields.size();i++){
        String strField=(String)mdfyFields.get(i);
        if(strField.equalsIgnoreCase("PROD_BUYER")||strField.equalsIgnoreCase("PROD_BUYER_DIVISION")){
          if(!util.MiscFunc.isEqual(recToMapping.get(strField),
                                   recClonedForCheck.get(strField))){
           needToChkBuyerDivModified=true;
           break;
         }
        }
      }
    }
    }catch(Exception exp){
      exp.printStackTrace();
    }
    //
    return true;
  }
  public void doPaste() {
    try{
      Record tmprec = (Record) util.ApplicationProperites.getProperties(
        id4ApplicationProperties);
      if(tmprec==null){
        exgui.verification.VerifyLib.showAlert("No Copied Data!!",
        "No Copied Data!!");
        return;
      }
      for(int i=0;i<recordColumnsToCopy.length;i++){
        recToMapping.set(
           recordColumnsToCopy[i],
           tmprec.get(recordColumnsToCopy[i])
        );
      }
      respondingMTR_V_Records =(Vector)
          util.ApplicationProperites.getProperties(id4ApplicationProperties+"_MTR_V_Records");
      orgBuyerNameString=null;
      orgMakerNameString=null;
      isProcessingPast=true;
      record2Gui();
      isProcessingPast=false;
    }catch(Exception e){
       e.printStackTrace();
    }
  }
  public void setPagedDataFactory(DB_Preprod preproductionHandler){
     super.setPagedDataFactory(preproductionHandler);
     myDbHander=preproductionHandler;

  }

  public void doPrint()throws Exception{
    throw new processhandler.commands.CommandException("the print method of Production head is not implemented yet");
  }
  private void mappingListMtrlNo(){
    StringBuffer sb=new StringBuffer();
    for(int i=0;i<respondingMTR_V_Records.size();i++){
      database.datatype.Record rec=(database.datatype.Record)
             respondingMTR_V_Records.get(i);
       sb.append((String)rec.get(1));
       if(i<respondingMTR_V_Records.size()-1)sb.append(",");
    }
    lblMtrList.setText(sb.toString());
    newtimes.preproduction.Constants.PREPROD_USING_MTRL_DTLS_STRING=sb.toString();
  }
  void btn2SelectMtrls_actionPerformed(ActionEvent e) throws Exception{

      //pop ut the multi-material select box and modify the vector --respondingMTR_V_Records
      PnlKeyWordSlkMtrDtl pnlInit=new PnlKeyWordSlkMtrDtl();
      SelectMtrlDtl4MtrVPreProd pnlMtrlDtl=new  SelectMtrlDtl4MtrVPreProd();
      pnlMtrlDtl.setSelectedMtrlDtl((Vector)util.MiscFunc.deepCopy(respondingMTR_V_Records));
      pnlInit.setDefalutNext(pnlMtrlDtl);
      DlgSelectBuyerMaker dlg=new DlgSelectBuyerMaker(
          util.PublicVariable.APP_FRAME
          ,"select Matrial Data",true,pnlInit);
      dlg.setSize(500,400);
      exgui.UIHelper.setToScreenCenter(dlg);
      pnlInit.storedMap.put(Kies.KEY_INIT_SELEC_BUYERMAKER_TYPE_NAME,"Material No.");//select buyer maker type is 2---maker.
      //pnlInit.storedMap.put(Kies.KEY_DLG_OBJ,dlg);
      dlg.show();
      if(dlg.getDialogStatus()==dlg.DIALOG_OK){
        //System.out.println("reslut is:"+dlg.getDialogResult());
        java.util.HashMap hm=
        (java.util.HashMap)((java.util.HashMap)dlg.getDialogResult()).get(Kies.KESY_HM_SELECTED_MATERIAL_DETAIL_RECORDS);
        respondingMTR_V_Records.clear();
        respondingMTR_V_Records.addAll(hm.values());
        mappingListMtrlNo();
      }else{
        //System.out.println("conversation is over");
      }
  }
  JComboBox cbxQcQnty = new JComboBox();
  JLabel whiteBkgBlueCharLabel21 = new JLabel();
  JLabel whiteBkgBlueCharLabel4 = new JLabel();
  JComboBox cbxScPrxTrm = new JComboBox();
  JLabel whiteBkgBlueCharLabel5 = new JLabel();
  JTextField txtRange = new JTextField();
  JTextField txtGrpName = new JTextField();
  JLabel blueBkgWhiteCharLabel4 = new JLabel();
  JTextField txtGroup = new JTextField();
  JLabel whiteBkgBlueCharLabel3 = new JLabel();
  JLabel whiteBkgBlueCharLabel7 = new JLabel();
  JComboBox cbxCity = new JComboBox();
  JComboBox cbxBranches = new JComboBox();
  JLabel blueBkgWhiteCharLabel21 = new JLabel();
  JTextField txtBuyerSCNO = new JTextField();
  JLabel whiteBkgBlueCharLabel23 = new JLabel();
  public JComboBox cbxSCDest = new JComboBox();
  JLabel lblPortTermDest = new JLabel();
  JLabel blueBkgWhiteCharLabel20 = new JLabel();
  JTextField txtBuyerLabel = new JTextField();
  JButton BuyerLabelbtn = new JButton();


  JLabel lblGoodDest = new JLabel();
  public JComboBox cbxTgtDest = new JComboBox();
  JPanel subPnlFabComm = new JPanel();
  Border border3;
  TitledBorder titledBorder4;
  ButtonGroup btnFabCmm = new ButtonGroup();
  JRadioButton rdoFabCmm_TypeNone = new JRadioButton();
  JRadioButton rdoFabCmm_TypeContract = new JRadioButton();
  JTextField txtFabCmmContract = new JTextField();
  JRadioButton rdoFabCmm_TypeRefNo = new JRadioButton();
  JLabel lblFabCmmRefNo = new JLabel();
  JButton btnEditFabCmmList = new JButton();
  JTextField txtProtoNo = new JTextField();
  JLabel blueBkgWhiteCharLabel9 = new JLabel();
  JLabel whiteBkgBlueCharLabel10 = new JLabel();
  JComboBox cbxScPaymentTerm = new JComboBox();
  JLabel blueBkgWhiteCharLabel22 = new JLabel();
  JComboBox cbxCurrency = new JComboBox();
  JLabel whiteBkgBlueCharLabel19 = new JLabel();
  JTextField txtBuySC_ISU_Date = new JTextField();
  JComboBox cbxCtPaymentTerm = new JComboBox();
  JLabel whiteBkgBlueCharLabel110 = new JLabel();
  JButton btnCopyAllAttrs = new JButton();
  BlueBkgWhiteCharLabel lblTitleUserName = new BlueBkgWhiteCharLabel();
  JLabel lbl2ShowCreateDate = new JLabel();
  JLabel jLabel1 = new JLabel();
  JComboBox cbx_NBF_code = new JComboBox();
  JButton btnReasonNoCommInN = new JButton();
  JButton btnChkSc = new JButton();
  JLabel lblExchageShipDoc = new JLabel();
  JComboBox cbxExchageShipDoc = new JComboBox();
  JLabel lblIsSample = new JLabel();
  JComboBox cbxIsSample = new JComboBox(new String[]{"N","Y","A","B"});
  JComboBox cbxCtBranches = new JComboBox();
  JLabel blueBkgWhiteCharLabel24 = new JLabel();
  Border border4;
  TitledBorder titledBorder5;
  JLabel lblBatchNo = new JLabel();
  JTextField txtBatchNo = new JTextField();
  JLabel lblAgent = new JLabel();
  //---
  JLabel lblSupplier = new JLabel();
  //---
  SelectBuyerMaker slkAgent = new SelectBuyerMaker();
  void showAshWorthFabCommDlg(){
    try{
      if (recToMapping.getInt(0) < 1) {
        fabCommDbHandler = new newtimes.preproduction.process.DummyFabCommPoXHandler();
        if (fabCommRecords != null && fabCommRecords.size() > 0) {
          ((newtimes.preproduction.process.DummyFabCommPoXHandler)fabCommDbHandler).
              InitByOrgData(fabCommRecords);
        }
      } else {
        fabCommDbHandler = new newtimes.preproduction.process.DB_FabCommPoX(
            recToMapping.getInt(0));
      }
      DlgFbCommPoXList dlg = new DlgFbCommPoXList(
          util.PublicVariable.APP_FRAME, "EDIT FABRIC PO & COMMISION", true,
          fabCommDbHandler);
      dlg.setSize(800, 300);
      dlg.show();
      fabCommRecords = fabCommDbHandler.getRecords(1, 99999); //see what's fabric commision data defined
      //since ashworth buyer have different commission type,the commmission dialog box is termed by buyer,
      //so ,once the buyer is determed,and fab-comm contains data,buyer selection dialog can not be activated
      if(fabCommRecords.size()>0){
        slkHeadBuyer.setEnabled(false);
      }else{
        slkHeadBuyer.setEnabled(true);
      }
     }catch(Exception exp){
       exp.printStackTrace();
       util.ExceptionLog.exp2File(exp,"");
     }

  }
  boolean showFabCommListDlg(){
    Object objBuyer=slkHeadBuyer.getSelectedValue();
    Object depValue=dbCBX_Dep.getSelectedValue();
    if(depValue==null||"TPG01".equals(depValue)||
       "TPG02".equals(depValue)||"TPG03".equals(depValue)||
       "TPE01".equals(depValue)||"TPC01".equals(depValue)
       ){
      exgui.verification.VerifyLib.showAlert("Please Select Proper Department",
                                             "Please Select Department");
      return false;
    }
    if(objBuyer==null){
      exgui.verification.VerifyLib.showAlert("Please Select Buyer Before You Define Fabric Commission",
                                             "Please Select Buyer");
      return false;
    }

    try{

      newtimesejb.preproduction.BuyerMakerHome bymkrHome=
          (newtimesejb.preproduction.BuyerMakerHome)
          info_ejb.WeblogicServiceLocator.locateServiceHome(util.PublicVariable.SERVER_URL,
          "newtimesejb.preproduction.BuyerMaker");
             showAshWorthFabCommDlg();
              return true;

     /*
        newtimesejb.preproduction.BuyerMaker ejbBUyer=bymkrHome.create();
        Record recBuyer=ejbBUyer.getByrMkrBySeq(Integer.parseInt(objBuyer.toString()));

        String wareHouseData=(String)recBuyer.get("bymkr_warehouse");
     if(wareHouseData!=null && wareHouseData.toUpperCase().indexOf("F")!=-1){
       showAshWorthFabCommDlg();
       return true;
     }


      if (recToMapping.getInt(0) < 1) {
        fabCommDbHandler = new newtimes.preproduction.process.DummyFabCommHandler();
        if (fabCommRecords != null && fabCommRecords.size() > 0) {
          ((newtimes.preproduction.process.DummyFabCommHandler)fabCommDbHandler).
              InitByOrgData(fabCommRecords);
        }
      } else {
        fabCommDbHandler = new newtimes.preproduction.process.DB_FabComm(
            recToMapping.getInt(0));
      }
      DlgFabCommList dlg = new DlgFabCommList(
          util.PublicVariable.APP_FRAME, "EDIT FABRIC COMMISION", true,
          fabCommDbHandler);
      dlg.setSize(800, 300);
      dlg.show();
      fabCommRecords = fabCommDbHandler.getRecords(1, 99999); //see what's fabric commision data defined
      //since ashworth buyer have different commission type,the commmission dialog box is termed by buyer,
      //so ,once the buyer is determed,and fab-comm contains data,buyer selection dialog can not be activated
      if(fabCommRecords.size()>0){
        slkHeadBuyer.setEnabled(false);
      }else{
        slkHeadBuyer.setEnabled(true);
      }
      return true;
      */
     }catch(Exception exp){
       exp.printStackTrace();
       util.ExceptionLog.exp2File(exp,"");
       return false;
     }
  }
  void rdoFabCmm_TypeNone_itemStateChanged(ItemEvent e){
     //gether all the fabric commision radio box option hanlding.
    try{
      if (isProcessingData2Gui)return;
      if (rdoFabCmm_TypeNone.isSelected()) {
        txtFabCmmContract.setText("");
        txtFabCmmContract.setEnabled(false);
        btnEditFabCmmList.setEnabled(false);
        recToMapping.set("PRODUCTION_FABCOMM_CONTRACT", null);
        recToMapping.set("PRODUCTION_FABCOMM_REFNO", null);
        return;
      }
      if (rdoFabCmm_TypeContract.isSelected()) {
        btnEditFabCmmList.setEnabled(false);
        txtFabCmmContract.setEnabled(true);
      }
      if (rdoFabCmm_TypeRefNo.isSelected()) {
        if(!showFabCommListDlg()){
          return;
        }
        Vector vct = fabCommDbHandler.getRecords(1, 9999);
        //pop out fabric commision detail dialog.
        if(vct.size()>0){
          //assign FAB comm ref no for current no.
          btnEditFabCmmList.setEnabled(true);
          recToMapping.set("PRODUCTION_FABCOMM_CONTRACT", null);
        }
      }
    }catch(Exception exp){
      exp.printStackTrace();
      util.ExceptionLog.exp2File(exp,"");
    }
  }

  void btnEditFabCmmList_actionPerformed(ActionEvent e) {
     showFabCommListDlg();
  }

  void BuyerLabel_actionPerformed(ActionEvent e) {
       new PopLabel(util.PublicVariable.APP_FRAME,txtBuyerLabel);
  }


  void btnCopyAllAttrs_actionPerformed(ActionEvent e) {
    try{
      if ("Y".equals(cbxIsSample.getSelectedItem())) {
        if (slkHeadBuyer.currentRecord() != null) {
          Record recBuyer = slkHeadBuyer.currentRecord();
          String warehouseStr = (String)recBuyer.get("bymkr_warehouse");
          if (null == warehouseStr || warehouseStr.indexOf("S") == -1) {
            exgui.verification.VerifyLib.showAlert(
                "Can Not Copy A \"Sample\" Order",
                "Can Not Copy A \"Sample\" Order");
            return;
          }
        }
      }

    }catch(Exception exp){
      exp.printStackTrace();
    }
    if(!exgui.verification.VerifyLib.showConfirm("Are You Sure To Duplicate Whole Data Of This Production ?",
                                                 "Are You Sure ?"))return;
    int refNo=-1;
    try{
      util.MiscFunc.showProcessingMessage();
      //checking if any color code is bank--not use in TPE center.
     if(!util.PublicVariable.OPERATTING_CENTER.equals("001")){
      Vector vctProdColor=exgui2.CONST.BASIC_MAIN_EJB.getDatas(
         util.PublicVariable.USER_RECORD,
          "select prod_color_name,prod_color_code from prod_color where record_delete_flag='1' and prod_head_pk="+
          newtimes.preproduction.Constants.CURRENT_PREPROD_HEAD_PK,
         1,99999);
       for(int i=0;i<vctProdColor.size();i++){
         Record recTmpColor=(Record)vctProdColor.get(i);
         Object objName=recTmpColor.get(0);
         Object objCode=recTmpColor.get(1);
         if(objName==null||objName.toString().trim().length()==0 ||
            objCode==null||objCode.toString().trim().length()==0 ){
           exgui.verification.VerifyLib.showAlert(
           "Color Code Or Color Name is Blank\nPlease Define Color Code/Name in Prod Color Unit",
           "Color Code Or Color Name is Blank");
           return;
         }
       }
      }
      /*
      newtimes.preproduction.process.ProdDuplicationHandler copyRobot =
          new newtimes.preproduction.process.ProdDuplicationHandler(
          newtimes.preproduction.Constants.CURRENT_PREPROD_HEAD_PK,
          (String)util.PublicVariable.USER_RECORD.get("usr_code"));
       refNo= copyRobot.doCopyAllNow();
       */
      newtimesejb.production.MessDuplicatorHome  ejbHome=
          (newtimesejb.production.MessDuplicatorHome)
          info_ejb.WeblogicServiceLocator.locateServiceHome(util.PublicVariable.SERVER_URL,
          "newtimesejb.production.MessDuplicator");
      newtimesejb.production.MessDuplicator ejb=ejbHome.create();
      refNo=ejb.duplicate(newtimes.preproduction.Constants.CURRENT_PREPROD_HEAD_PK,
          (String)util.PublicVariable.USER_RECORD.get("usr_code"));
       util.MiscFunc.hideProcessingMessage();
       exgui.verification.VerifyLib.showPlanMsg("Duplicate OK\nRef No. Of New Production is:"+refNo,
                                                "Duplicate OK");
    }catch(Exception exp){
      /*
      if(refNo!=-1){
        try{
          ((newtimes.preproduction.process.DB_Preprod)dbprc).
              deleteForFailureProductionDuplication(refNo);
        }catch(Exception epxii){
          util.ExceptionLog.exp2File(epxii,"");
          exp.printStackTrace();
          exgui.verification.VerifyLib.showAlert("Process Fail,Please Contatct System Manager",
                                                 "Error while copy all data");
        }
      }*/
      util.ExceptionLog.exp2File(exp,"");
      exp.printStackTrace();
      exgui.verification.VerifyLib.showAlert("Process Fail,Please Contatct System Manager",
                                             "Error while copy all data");
    }
  }

  void btnReasonNoCommInN_actionPerformed(ActionEvent e) {
    try{
      util.MiscFunc.showProcessingMessage();
      Record recFabReasonN = dbDB_FabComm_N_Reason.getRecordByPk(recToMapping.getInt(0));
      util.MiscFunc.hideProcessingMessage();
      String str=(String)recFabReasonN.get(1);
      DlgFabComm_N_Reason dlg = new DlgFabComm_N_Reason(
          util.PublicVariable.APP_FRAME,"Fab Commission \"N\" Reason", true, str);
      dlg.setSize(490,260);
      exgui.UIHelper.setToScreenCenter(dlg);
      dlg.show();
      if(dlg.getDialogStatus()==dlg.STATUS_CLOSE_NORMALLY){
        String lastReason=dlg.txtReason.getText().trim();
        if(!lastReason.equalsIgnoreCase(str)){
          recFabReasonN.set(1,lastReason);
          recFabReasonN.set("record_modify_user",util.PublicVariable.USER_RECORD.get(0));
          recFabReasonN.set("record_modify_date",new java.sql.Date(System.currentTimeMillis()));
          Vector vct=new Vector();
          vct.add(recFabReasonN);
          util.MiscFunc.showProcessingMessage();
          dbDB_FabComm_N_Reason.updateRecords(vct);
          util.MiscFunc.hideProcessingMessage();
        }
      }
    }catch(Exception exp){
      exp.printStackTrace();
      util.ExceptionLog.exp2File(exp,"");
      exgui.verification.VerifyLib.showAlert("Error While Modifing Comm\"N\" REASON",
                                             "UPDATE FAIL");

    }

  }

  void btnChkSc_actionPerformed(ActionEvent e) {
   DlgShowByrMkrOfHkSc dlg=new DlgShowByrMkrOfHkSc(
      util.PublicVariable.APP_FRAME,
      "S/C and Buyer and Maker",true);
    dlg.setSize(535,400);
    exgui.UIHelper.setToScreenCenter(dlg);
    dlg.show();
  }

  void cbxBranches_itemStateChanged(ItemEvent e) {
     if(!isProcessingData2Gui) cbxCtBranches.setSelectedItem(cbxBranches.getSelectedItem());
  }
}

class PnlEditPPDHead_btn2SelectMtrls_actionAdapter implements java.awt.event.ActionListener {
  PnlEditPPDHead adaptee;

  PnlEditPPDHead_btn2SelectMtrls_actionAdapter(PnlEditPPDHead adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    try{
      adaptee.btn2SelectMtrls_actionPerformed(e);
    }catch(Exception eii){
       eii.printStackTrace();
    }
  }
}

class PnlEditPPDHead_txtProdByrPlnDlvy_focusAdapter extends java.awt.event.FocusAdapter {
  PnlEditPPDHead adaptee;

  PnlEditPPDHead_txtProdByrPlnDlvy_focusAdapter(PnlEditPPDHead adaptee) {
    this.adaptee = adaptee;
  }
  public void focusLost(FocusEvent e) {
    adaptee.txtProdByrPlnDlvy_focusLost(e);
  }
}
class PnlEditPPDHead_cbxCountry_itemAdapter implements java.awt.event.ItemListener {
  PnlEditPPDHead adaptee;

  PnlEditPPDHead_cbxCountry_itemAdapter(PnlEditPPDHead adaptee) {
    this.adaptee = adaptee;
  }
  public void itemStateChanged(ItemEvent e) {
    adaptee.cbxCountry_itemStateChanged(e);
  }
}
class PnlEditPPDHead_cbxDiv_itemAdapter implements java.awt.event.ItemListener {
  PnlEditPPDHead adaptee;

  PnlEditPPDHead_cbxDiv_itemAdapter(PnlEditPPDHead adaptee) {
    this.adaptee = adaptee;
  }
  public void itemStateChanged(ItemEvent e) {
    adaptee.cbxDiv_itemStateChanged(e);
  }

}

class PnlEditPPDHead_cbxCenter_itemAdapter implements java.awt.event.ItemListener {
  PnlEditPPDHead adaptee;

  PnlEditPPDHead_cbxCenter_itemAdapter(PnlEditPPDHead adaptee) {
    this.adaptee = adaptee;
  }
  public void itemStateChanged(ItemEvent e) {
    adaptee.cbxCenter_itemStateChanged(e);
  }

}

class PnlEditPPDHead_rdoFabCmm_TypeNone_itemAdapter implements java.awt.event.ItemListener {
  PnlEditPPDHead adaptee;

  PnlEditPPDHead_rdoFabCmm_TypeNone_itemAdapter(PnlEditPPDHead adaptee) {
    this.adaptee = adaptee;
  }
  public void itemStateChanged(ItemEvent e) {
    adaptee.rdoFabCmm_TypeNone_itemStateChanged(e);
  }
}

class PnlEditPPDHead_btnEditFabCmmList_actionAdapter implements java.awt.event.ActionListener {
  PnlEditPPDHead adaptee;

  PnlEditPPDHead_btnEditFabCmmList_actionAdapter(PnlEditPPDHead adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.btnEditFabCmmList_actionPerformed(e);
  }
}

class PnlEditPPDHead_btnCopyAllAttrs_actionAdapter implements java.awt.event.ActionListener {
  PnlEditPPDHead adaptee;

  PnlEditPPDHead_btnCopyAllAttrs_actionAdapter(PnlEditPPDHead adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.btnCopyAllAttrs_actionPerformed(e);
  }
}

class PnlEditPPDHead_btnReasonNoCommInN_actionAdapter implements java.awt.event.ActionListener {
  PnlEditPPDHead adaptee;

  PnlEditPPDHead_btnReasonNoCommInN_actionAdapter(PnlEditPPDHead adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.btnReasonNoCommInN_actionPerformed(e);
  }
}

class PnlEditPPDHead_btnChkSc_actionAdapter implements java.awt.event.ActionListener {
  PnlEditPPDHead adaptee;

  PnlEditPPDHead_btnChkSc_actionAdapter(PnlEditPPDHead adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.btnChkSc_actionPerformed(e);
  }
}

class PnlEditPPDHead_cbxBranches_itemAdapter implements java.awt.event.ItemListener {
  PnlEditPPDHead adaptee;

  PnlEditPPDHead_cbxBranches_itemAdapter(PnlEditPPDHead adaptee) {
    this.adaptee = adaptee;
  }
  public void itemStateChanged(ItemEvent e) {
    adaptee.cbxBranches_itemStateChanged(e);
  }
}


