package newtimes.preproduction.guis;
import java.awt.*;
import processhandler.template.PnlFieldsEditor;
import exgui.*;
import javax.swing.*;
import exgui2.*;
import javax.swing.border.*;
import newtimes.preproduction.buyermakerselect.*;
import newtimes.preproduction.process.DB_Preprod;
import java.util.Vector;
import database.datatype.Record;
import java.awt.event.*;
import exgui.ultratable.PagedDataFactory;
/**
 * <p>Title: </p>
 * <p>Description: </p>brac
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class PnlNTHKEditPPHead
  extends processhandler.template.PnlFieldsEditor
  //extends JPanel
 implements MouseMotionListener ,
  newtimes.preproduction.buyermakerselect.BuyerMakerChanged{
  DB_Preprod myDbHander;
  BorderLayout borderLayout1 = new BorderLayout();
  GridLayout gridLayout=new GridLayout(1,1);
  JPanel jPanel1 = new JPanel();
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
  SelectBuyerMaker slkLknBuyer = new SelectBuyerMaker();
  boolean isProcessingPast=false;
  boolean isInitializingCountriesCbx=false;
  JComboBox cbxLknDep = new JComboBox();
  //Vector respondingMTR_V_Records=new Vector();
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
  JLabel lblSeason = new JLabel();
  JPanel jPanel3 = new JPanel();
  JLabel blueBkgWhiteCharLabel2 = new JLabel();
  SelectBuyerMaker slkHeadBuyer = new SelectBuyerMaker();
  SelectBuyerMaker slkHeadMaker = new SelectBuyerMaker();
  JLabel lblProdMaker = new JLabel();
  JPanel jPanel4 = new JPanel();
  JComboBox cbxProductionType = new JComboBox();
  JLabel whiteBkgBlueCharLabel9 = new JLabel();
  JPanel jPanel5 = new JPanel();
  JLabel whiteBkgBlueCharLabel18 = new JLabel();
  boolean needtoCheckDiv=false;
  JComboBox cbxDiv = new JComboBox();
  JLabel lblDivision = new JLabel();
  JLabel whiteBkgBlueCharLabel20 = new JLabel();
  JComboBox cbxOffShrCntr = new JComboBox();
  exgui.DataBindJCombobox dbCbxdiv=null;
  exgui.DataBindJCombobox DbJcbxcbxQcCountry =null;
  boolean isProcessingData2Gui=false;
  int dbCbxDepIndex=0;
  int dbCbxDivIndex=0;
  int dbCbxMngIndex=0;
  DataBindJCombobox dbCBX_Center,dbCBX_Dep,dbCbxSzn,dbCbxProdType,dbCbxCity,dbCbxHKSubGrp,dbCbxInspOffice;
  java.util.Vector recDests,branches;
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
  protected boolean isProcessingUpdteProcess=false;
  Object initbuyerSeq=null;
  Object initMkrSeq=null;
      //new newtimes.preproduction.process.DB_FabComm_N_Reason();
  boolean isProcessingCopy=false;
  public PnlNTHKEditPPHead() {
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
   if(isProcessingDelete)return false;//processing delete,no need to
   return super.isContextModified();
 }
 public void grayMe(){
   super.grayMe();
   isGrayied=true;
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

 }

 public void setEnabled(boolean enable){
   setPanelEnable(this,enable);
   if(!enable && newtimes.production.ProdMaintain_Properties.IS_PO_SHIPPED.equalsIgnoreCase("true")){
     cbxScPaymentTerm.setEnabled(true);
     txtBuySC_ISU_Date.setEnabled(true);
     txtBuyerLabel.setEnabled(true);
     int user_type=util.PublicVariable.USER_RECORD.getInt(2);
     switch(user_type){
       case newtimesejb.preproduction.PreProductionHead.USER_TYPE_OTHERS:
       case newtimesejb.preproduction.PreProductionHead.USER_TYPE_ACCOUNTING_USERS:
       case newtimesejb.preproduction.PreProductionHead.USER_TYPE_SHIPPING_USERS:
       {

         btnCopyWholePO.setEnabled(false);
         return;
       }
       default:{
         if(util.PublicVariable.OPERATTING_CENTER.equals("NTFE")){
           if(util.PublicVariable.USER_RECORD.get(0).equals("WIRENEYU")){
             btnCopyWholePO.setEnabled(true);
           }else{
             btnCopyWholePO.setEnabled(false);
           }
         } else {
           btnCopyWholePO.setEnabled(true);
         }
       }

     }

   }
 }
 public void mouseMoved(MouseEvent e){

 }
 public void mouseDragged(MouseEvent e){

 }

 protected  void jbInit() throws Exception {
    border3 = new EtchedBorder(EtchedBorder.RAISED,Color.white,new Color(148, 145, 140));
    titledBorder4 = new TitledBorder(border3,"FABRIC TRIM COMMISION");
    //this.setPreferredSize(new Dimension(930,650));
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
    slkLknMaker.setBounds(new Rectangle(89, 65, 165, 23));
    slkLknBuyer.setBounds(new Rectangle(85, 23, 167, 24));
    cbxLknDep.setBounds(new Rectangle(370, 68, 137, 20));
    //this.add(jPanel1);
    txtProdByrPlnDlvy.setText("");
    txtProdByrPlnDlvy.setBounds(new Rectangle(125, 12, 129, 24));
    //txtProdByrPlnDlvy.addFocusListener(new PnlNTHKEditPPHead_txtProdByrPlnDlvy_focusAdapter(this));
    lblDisplayProdheadPK.setForeground(Color.red);
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
        new PnlNTHKEditPPHead_cbxCenter_itemAdapter(this)
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
    lblSeason.setForeground(Color.red);
    lblSeason.setText("*Season");
    lblSeason.setBounds(new Rectangle(3, 203, 57, 23));
    jPanel3.setBackground(new Color(204, 204, 225));
    jPanel3.setBorder(BorderFactory.createEtchedBorder());
    jPanel3.setBounds(new Rectangle(233, 34, 259, 229));
    jPanel3.setLayout(null);
    blueBkgWhiteCharLabel2.setForeground(Color.red);
    blueBkgWhiteCharLabel2.setText("*Buyer"+
                                   ((util.PublicVariable.OPERATTING_CENTER.equalsIgnoreCase("NTHK"))?" Code":"")
                                   );
    blueBkgWhiteCharLabel2.setBounds(new Rectangle(9, 4, 78, 24));
    slkHeadBuyer.setBounds(new Rectangle(89, 4, 166, 24));
    slkHeadMaker.setBounds(new Rectangle(575, 82, 146, 24));
    slkHeadMaker.setModifyNotifyTo(this);
    slkHeadBuyer.setModifyNotifyTo(buyerChangerHandler);
    lblProdMaker.setBounds(new Rectangle(495, 83, 58, 24));
    lblProdMaker.setForeground(Color.black);
    lblProdMaker.setText("Maker");
    //cbxCountry.addItemListener(new PnlNTHKEditPPHead_cbxCountry_itemAdapter(this));
    jPanel4.setBackground(new Color(204, 204, 225));
    jPanel4.setBorder(BorderFactory.createEtchedBorder());
    jPanel4.setBounds(new Rectangle(495, 33, 251, 231));
    jPanel4.setLayout(null);
    cbxProductionType.setBounds(new Rectangle(95, 3, 151, 24));
    whiteBkgBlueCharLabel9.setBounds(new Rectangle(10, 7, 44, 20));
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
    lblDivision.setBounds(new Rectangle(9, 32, 61, 23));
    lblDivision.setForeground(Color.black);
    lblDivision.setText("Division");
    whiteBkgBlueCharLabel20.setForeground(Color.red);
    whiteBkgBlueCharLabel20.setText("*OffShore Center");
    whiteBkgBlueCharLabel20.setVerticalAlignment(SwingConstants.CENTER);
    whiteBkgBlueCharLabel20.setVerticalTextPosition(SwingConstants.CENTER);
    whiteBkgBlueCharLabel20.setBounds(new Rectangle(2, 44, 96, 26));
    cbxOffShrCntr.setBounds(new Rectangle(99, 48, 121, 20));
    cbxQcQnty.setBounds(new Rectangle(93, 171, 151, 24));
    cbxQcQnty.addItemListener(new PnlNTHKEditPPHead_cbxCountry_itemAdapter(this));
    lblQcCountry.setBackground(new Color(143, 143, 188));
    lblQcCountry.setForeground(Color.red);
    lblQcCountry.setHorizontalAlignment(SwingConstants.LEADING);
    lblQcCountry.setHorizontalTextPosition(SwingConstants.CENTER);
    lblQcCountry.setText(qcCntyTitle);//"*QC Country");
    lblQcCountry.setBounds(new Rectangle(2, 165, 88, 39));
    whiteBkgBlueCharLabel4.setBounds(new Rectangle(40, 46, 74, 24));
    whiteBkgBlueCharLabel4.setForeground(Color.red);
    whiteBkgBlueCharLabel4.setText("*Price Term");
    cbxScPrxTrm.setBounds(new Rectangle(126, 46, 127, 24));
    lblBoardRng.setBackground(new Color(143, 143, 188));
    lblBoardRng.setForeground(Color.black);
    lblBoardRng.setText("Board Range");
    lblBoardRng.setBounds(new Rectangle(4, 196, 74, 25));
    txtRange.setText("");
    txtRange.setBounds(new Rectangle(85, 196, 166, 21));
    txtGrpName.setText("");
    txtGrpName.setBounds(new Rectangle(85, 167, 166, 21));
    lblGrpName.setBackground(Color.white);
    lblGrpName.setForeground(Color.black);
    lblGrpName.setText("Group Name");
    lblGrpName.setBounds(new Rectangle(3, 166, 98, 25));
    txtGroup.setBounds(new Rectangle(85, 137, 166, 21));
    txtGroup.setText("");
    lblGrpNo.setBounds(new Rectangle(4, 132, 70, 26));
    lblGrpNo.setBackground(new Color(143, 143, 188));
    lblGrpNo.setForeground(Color.black);
    lblGrpNo.setText("Group No");
    lblQcCity.setBounds(new Rectangle(6, 198, 46, 24));
    lblQcCity.setText("CITY");
    cbxCity.setBounds(new Rectangle(92, 200, 151, 24));
    cbxBranches.setBounds(new Rectangle(95, 105, 151, 24));
    lblBranch.setBounds(new Rectangle(5, 105, 78, 24));
    lblBranch.setForeground(Color.red);
    lblBranch.setText("*Branch");
    txtBuyerSCNO.setBounds(new Rectangle(95, 38, 151, 23));
    txtBuyerSCNO.setText("");
    whiteBkgBlueCharLabel23.setBounds(new Rectangle(5, 37, 83, 26));
    whiteBkgBlueCharLabel23.setText((isTpeUser)?"Buyer S/C":"Cust. Po:");
    cbxSCDest.setBounds(new Rectangle(364, 10, 128, 24));
    //cbxSCDest.setEditable(true);
    //cbxTgtDest.setEditable(true);
    lblPortTermDest.setForeground(Color.red);
    lblPortTermDest.setRequestFocusEnabled(true);
    lblPortTermDest.setHorizontalAlignment(SwingConstants.CENTER);
    //lblPortTermDest.setText("*Port :");
    lblPortTermDest.setText(strLblTitle_PortTermDest);
    lblPortTermDest.setBounds(new Rectangle(262, 10, 101, 24));
    blueBkgWhiteCharLabel20.setRequestFocusEnabled(true);
    blueBkgWhiteCharLabel20.setText("Buyer Label");
    blueBkgWhiteCharLabel20.setBounds(new Rectangle(4, 78, 75, 24));
    txtBuyerLabel.setText("");
    txtBuyerLabel.setBounds(new Rectangle(95, 80, 151, 23));
    lblGoodDest.setForeground(Color.red);
    lblGoodDest.setHorizontalAlignment(SwingConstants.LEADING);
    lblGoodDest.setHorizontalTextPosition(SwingConstants.TRAILING);
    //lblGoodDest.setText("Destination:");
    lblGoodDest.setText(strLblTitle_GoodDest);
    lblGoodDest.setVerticalAlignment(javax.swing.SwingConstants.TOP);
    lblGoodDest.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
    lblGoodDest.setBounds(new Rectangle(504, 13, 78, 36));
    cbxTgtDest.setBounds(new Rectangle(576, 12, 154, 21));
    txtProtoNo.setBounds(new Rectangle(363, 85, 130, 21));
    txtProtoNo.setText("");
    lblProtoNo.setText("Proto No.");
    lblProtoNo.setBounds(new Rectangle(286, 85, 61, 24));
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
    whiteBkgBlueCharLabel19.setBounds(new Rectangle(280, 46, 83, 23));
    txtBuySC_ISU_Date.setText("");
    txtBuySC_ISU_Date.setBounds(new Rectangle(362, 46, 130, 23));
    lblTitleUserName.setText("");
    lblTitleUserName.setBounds(new Rectangle(61, 2, 170, 28));
    lbl2ShowCreateDate.setBackground(new Color(143, 143, 188));
    lbl2ShowCreateDate.setFont(new java.awt.Font("Dialog", 1, 11));
    lbl2ShowCreateDate.setOpaque(true);
    lbl2ShowCreateDate.setHorizontalAlignment(SwingConstants.LEFT);
    lbl2ShowCreateDate.setBounds(new Rectangle(670, 2, 127, 28));
    lblBuyerPrefix.setForeground(Color.red);
    lblBuyerPrefix.setText("Buyer Prefix:");
    lblBuyerPrefix.setBounds(new Rectangle(6, 60, 81, 23));
    txtBuyerPrefix.setText("");
    txtBuyerPrefix.setBounds(new Rectangle(88, 59, 57, 22));
    //btnChkSc.setBounds(new Rectangle(151, 187, 101, 27));
    btnChkSc.setBounds(new Rectangle(151, 59, 101, 27));
    btnChkSc.setFont(new java.awt.Font("Dialog", 1, 11));
    btnChkSc.setText("Chk S/C#");
    btnChkSc.addActionListener(new PnlNTHKEditPPHead_btnChkSc_actionAdapter(this));
    btnCopyWholePO.setBounds(new Rectangle(573, 410, 167, 85));
    btnCopyWholePO.setFont(new java.awt.Font("Dialog", 1, 11));
    btnCopyWholePO.setText("<html><body>COPY PO & COLOR<br>STYLE & QTY </body></html>");
    btnCopyWholePO.addActionListener(new PnlNTHKEditPPHead_btnCopyWholePO_actionAdapter(this));
    lblHKSubGrp.setForeground(Color.red);
    lblHKSubGrp.setText("SUB GROUP");
    lblHKSubGrp.setBounds(new Rectangle(4, 87, 83, 21));
    cbxHkSubGrp.setBounds(new Rectangle(88, 88, 168, 22));
    pnlInspOffice.setBackground(new Color(204, 204, 225));
    pnlInspOffice.setBorder(BorderFactory.createEtchedBorder());
    pnlInspOffice.setBounds(new Rectangle(8, 410, 374, 104));
    pnlInspOffice.setLayout(null);
    lblInspOffice.setBounds(new Rectangle(12, 16, 177, 26));
    lblInspOffice.setVerticalTextPosition(SwingConstants.CENTER);
    lblInspOffice.setVerticalAlignment(SwingConstants.CENTER);
    lblInspOffice.setText("Inspection Handling Office");
    lblInspOffice.setForeground(Color.red);
    cbxInspOffice.setBounds(new Rectangle(161, 16, 206, 25));
    rdoInspOffice_Insp.setBackground(new Color(204, 204, 225));
    rdoInspOffice_Insp.setFont(new java.awt.Font("Dialog", 1, 11));
    rdoInspOffice_Insp.setText("Inspection Only");
    rdoInspOffice_Insp.setBounds(new Rectangle(12, 50, 132, 25));
    rdoInspOffice_Coop.setBounds(new Rectangle(186, 50, 166, 25));
    rdoInspOffice_Coop.setText("CO-OPERATION");
    rdoInspOffice_Coop.setBackground(new Color(204, 204, 225));
    rdoInspOffice_Coop.setFont(new java.awt.Font("Dialog", 1, 11));
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
    jPanel2.add(lblSeason, null);
    jPanel2.add(blueBkgWhiteCharLabel5, null);
    jPanel1.add(jPanel3, null);
    jPanel1.add(jPanel5, null);
    jPanel1.add(lblDisplayProdheadPK, null);
    jPanel3.add(lblDivision, null);
    jPanel3.add(blueBkgWhiteCharLabel2, null);
    jPanel3.add(slkHeadBuyer, null);
    jPanel3.add(cbxDiv, null);
    jPanel3.add(lblBoardRng, null);
    jPanel3.add(txtGroup, null);
    jPanel3.add(lblGrpName, null);
    jPanel3.add(txtGrpName, null);
    jPanel3.add(txtRange, null);
    jPanel3.add(lblBuyerPrefix, null);
    jPanel3.add(txtBuyerPrefix, null);
    jPanel3.add(lblGrpNo, null);
    jPanel3.add(lblHKSubGrp, null);
    jPanel3.add(cbxHkSubGrp, null);
    if(util.PublicVariable.OPERATTING_CENTER.equals("NTHK")){
      //only HK user need to see buyer/makers of used S/C No.
      jPanel3.add(btnChkSc, null);
    }

    jPanel5.add(whiteBkgBlueCharLabel18, null);
    jPanel5.add(cbxTgtDest, null);
    jPanel5.add(lblGoodDest, null);
    jPanel5.add(txtProdByrPlnDlvy, null);
    jPanel5.add(whiteBkgBlueCharLabel4, null);
    jPanel5.add(cbxScPrxTrm, null);
    jPanel5.add(whiteBkgBlueCharLabel10, null);
    jPanel5.add(cbxCurrency, null);
    jPanel5.add(blueBkgWhiteCharLabel22, null);
    jPanel5.add(cbxScPaymentTerm, null);
    jPanel5.add(lblProdMaker, null);
    jPanel5.add(slkHeadMaker, null);
    jPanel5.add(lblPortTermDest, null);
    jPanel5.add(whiteBkgBlueCharLabel19, null);
    jPanel5.add(txtBuySC_ISU_Date, null);
    jPanel5.add(cbxSCDest, null);
    jPanel5.add(lblProtoNo, null);
    jPanel5.add(txtProtoNo, null);
    jPanel1.add(jPanel4, null);
    jPanel1.add(jPanel2, null);


    jPanel4.add(whiteBkgBlueCharLabel9, null);
    jPanel4.add(cbxProductionType, null);
    jPanel4.add(cbxBranches, null);
    jPanel4.add(lblBranch, null);
      //cbxBranches.setVisible(false);
      //lblBranch.setVisible(false) ;
    if(util.PublicVariable.OPERATTING_CENTER.equals("NTHK")){
      cbxBranches.setVisible(false);
      lblBranch.setVisible(false) ;
    }


    jPanel4.add(whiteBkgBlueCharLabel23, null);
    jPanel4.add(blueBkgWhiteCharLabel20, null);
    jPanel4.add(txtBuyerLabel, null);
    jPanel4.add(txtBuyerSCNO, null);
    if(!util.PublicVariable.OPERATTING_CENTER.equals("NTHK")){
     jPanel4.add(lblQcCity, null);
     jPanel4.add(cbxCity, null);
     jPanel4.add(lblQcCountry, null);
     jPanel4.add(cbxQcQnty, null);
    }
    jPanel1.add(whiteBkgBlueCharLabel6, null);
    jPanel1.add(lbl2ShowCreateDate, null);
    jPanel1.add(lblTitleUserName, null);

    pnlInspOffice.add(lblInspOffice, null);
    pnlInspOffice.add(cbxInspOffice, null);
    pnlInspOffice.add(rdoInspOffice_Insp, null);
    pnlInspOffice.add(rdoInspOffice_Coop, null);
    if(!util.PublicVariable.OPERATTING_CENTER.equals("NTHK")){
      jPanel1.add(btnCopyWholePO, null);
    }

    int user_type=util.PublicVariable.USER_RECORD.getInt("USR_TYPE");
    switch(user_type){
      case newtimesejb.preproduction.PreProductionHead.USER_TYPE_OTHERS:
      case newtimesejb.preproduction.PreProductionHead.USER_TYPE_ACCOUNTING_USERS:
      case newtimesejb.preproduction.PreProductionHead.USER_TYPE_SHIPPING_USERS:
      btnCopyWholePO.setEnabled(false);
    }
    if(util.PublicVariable.OPERATTING_CENTER.equals("NTFE")){
      if(util.PublicVariable.USER_RECORD.get(0).equals("WIRENEYU")){
        btnCopyWholePO.setEnabled(true);
      }else{
        btnCopyWholePO.setEnabled(false);
      }
    } else {
      btnCopyWholePO.setEnabled(true);
    }



    cbxDiv.addItemListener(new PnlNTHKEditPPHead_cbxDiv_itemAdapter(this));
    isGrayied=false;
    //20040521,hide the un-use column,because hk do not determ what to do with pre-production now
    subPnlLapDip.setVisible(false);
    subPnlLockIn.setVisible(false);
    subPnlProto.setVisible(false);
    if(util.PublicVariable.OPERATTING_CENTER.equals("NTHK")){
      lblBuyerPrefix.setVisible(true);
      txtBuyerPrefix.setVisible(true);
      lblHKSubGrp.setVisible(true);
      //txtHkSubGrp.setVisible(true);
      cbxHkSubGrp.setVisible(true);
    }else{
      lblBuyerPrefix.setVisible(false);
      txtBuyerPrefix.setVisible(false);
      lblHKSubGrp.setVisible(false);
      //txtHkSubGrp.setVisible(false);
      cbxHkSubGrp.setVisible(false);
    }
    //Maker is assigned in C/T UNIT.
    lblProdMaker.setVisible(false);
    slkHeadMaker.setVisible(false);
    //---------------------request by NTHK Eric-----------------------------
    lblProtoNo.setVisible(false);txtProtoNo.setVisible(false);

    if(util.PublicVariable.OPERATTING_CENTER.equals("NTHK")){
      lblGrpName.setVisible(false);lblGrpNo.setVisible(false);
      lblBoardRng.setVisible(false);

      lblDivision.setVisible(false);
      lblSeason.setVisible(false);

      txtGroup.setVisible(false);txtGrpName.setVisible(false);
      txtRange.setVisible(false);

      cbxDiv.setVisible(false);
      cbxSzn.setVisible(false);
    }else{
      lblGrpName.setVisible(true);

      lblGrpNo.setVisible(false);
      lblBoardRng.setVisible(false);
      txtGroup.setVisible(false);
      txtGrpName.setVisible(true);

      txtRange.setVisible(false);
      lblDivision.setVisible(true);
      lblSeason.setVisible(true);
      cbxDiv.setVisible(true);
      cbxSzn.setVisible(true);
    }
    //----------------------------------------------------------------------
    cbxScPaymentTerm.setUI(new exgui.WideComboBoxUI(350));
    cbxSCDest.setUI(new exgui.WideComboBoxUI(300));
    cbxTgtDest.setUI(new exgui.WideComboBoxUI(300));
    buttonGroupInspOffice.add(rdoInspOffice_Coop);
    buttonGroupInspOffice.add(rdoInspOffice_Insp);
    //only NTFE,NTD,CG,PW,BW,allow to select inpsection
    if("NTFE".equals(util.PublicVariable.OPERATTING_CENTER)||
       "NTD".equals(util.PublicVariable.OPERATTING_CENTER)||
       "CG".equals(util.PublicVariable.OPERATTING_CENTER)||
       "PW".equals(util.PublicVariable.OPERATTING_CENTER)||
       "BW".equals(util.PublicVariable.OPERATTING_CENTER)){
       jPanel1.add(pnlInspOffice, null);
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
          if(util.PublicVariable.OPERATTING_CENTER.equals("NTHK")){
            lblBranch.setVisible(false);
            cbxBranches.setVisible(false);
            cbxBranches.setSelectedItem("NTHK");
          }
          //only the all dep is allow to add now.
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
          //deps and "ALL"dep allow to add.

          if(util.PublicVariable.OPERATTING_CENTER.equals("NTHK")){
            String buyerHkCode=(String)buyerRecord.get("BYMKR_HK_CODE");
            if("CP240".equals(buyerHkCode)){
              lblBranch.setVisible(true);
              cbxBranches.setVisible(true);
            }else{
              lblBranch.setVisible(false);
              cbxBranches.setVisible(false);
              cbxBranches.setSelectedItem("NTHK");
            }
          }

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
      boolean isUploadData=false;
      String strGrp=(String)recToMapping.get("PROD_GROUP");
      String strGrpName=(String)recToMapping.get("PROD_GROUP_NAME");
      if(strGrp!=null && strGrpName!=null && strGrpName.trim().length()>0 && strGrp.trim().length()>0 &&
         strGrpName.equals(strGrp) &&
         util.PublicVariable.OPERATTING_CENTER.equals("NTD")){
        isUploadData=true;
      }
      /*
      if (recToMapping.getInt(0) < 1) {
         dbDB_FabComm_N_Reason = new newtimes.preproduction.process.DB_FabComm_N_Reason(true);
      }else{
         dbDB_FabComm_N_Reason = new newtimes.preproduction.process.DB_FabComm_N_Reason();
      }
      */
      //txtBuyerPrefix.setEditable(false);
      //txtHkSubGrp.setEditable(false);
      //cbxHkSubGrp.setEnabled(false);
      if(!isProcessingPast){
        if (recToMapping.getInt(0) < 1) {
          //respondingMTR_V_Records = new Vector();
          whiteBkgBlueCharLabel6.setText("PRODUCTION HEAD ADD");
          btnCopyWholePO.setVisible(false);
          //btnReasonNoCommInN.setEnabled(false);
          if(btnGotoStyles!=null){
            btnGotoStyles.setEnabled(false);
          }
        }
        else {
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

          //respondingMTR_V_Records = myDbHander.getCorespondingMtrlDtlRecords(recToMapping.getInt(0));
          //newtimes.preproduction.Constants.PREPROD_USING_MTRL_DTLS = respondingMTR_V_Records;
           whiteBkgBlueCharLabel6.setText(titleText);
           lblDisplayProdheadPK.setText(recToMapping.get(0).toString());
           lbl2ShowCreateDate.setText(" "+recCreateDate);
        }
      }
      isProcessingData2Gui=true;
      mappingListMtrlNo();
      dataBoundGUIs.clear();
      //only NTFE,NTD,CG,PW,BW,allow to select inpsection
      if("NTFE".equals(util.PublicVariable.OPERATTING_CENTER)||
         "NTD".equals(util.PublicVariable.OPERATTING_CENTER)||
         "CG".equals(util.PublicVariable.OPERATTING_CENTER)||
         "PW".equals(util.PublicVariable.OPERATTING_CENTER)||
         "BW".equals(util.PublicVariable.OPERATTING_CENTER)){

         dbCbxInspOffice=new exgui.DataBindJCombobox(cbxInspOffice,
                                        "PRODXINSP_INSPEC_CODE",
                                        tempProperties.tmpInspecOffice,
                                        "CEN_NAME","CEN_CODE",
                                        recToMapping.get("PRODXINSP_INSPEC_CODE"),"",null);
        dataBoundGUIs.add(dbCbxInspOffice);
        Object objInspCoop=recToMapping.get("PRODXINSP_INSPEC_COOP");
         if(null!=objInspCoop){
            if(objInspCoop.toString().equals("I"))rdoInspOffice_Insp.setSelected(true);
            if(objInspCoop.toString().equals("C"))rdoInspOffice_Coop.setSelected(true);
         }
      }


      if(whiteBkgBlueCharLabel6.getText().trim().equalsIgnoreCase("PRODUCTION HEAD ADD")){
        txtBuyerPrefix.setEditable(true);
        cbxHkSubGrp.setEnabled(true);
      }else{
        txtBuyerPrefix.setEditable(false);
        cbxHkSubGrp.setEnabled(false);
      }
      if(util.PublicVariable.USER_RECORD.get(0).equals("NTERIC")){
        txtBuyerPrefix.setEditable(true);
        cbxHkSubGrp.setEnabled(true);
      }


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
     if(!isUploadData){
       exgui.DataBindJCombobox DbJcbxjcbxPaymentTerm =
           new exgui.DataBindJCombobox(
           cbxScPaymentTerm, "PRODUCTION_PYT_TRM", recPaymentTerm, "PYT_TRM",
           "PYT_TRM", recToMapping.get("PRODUCTION_PYT_TRM")); //,"",null);
       dataBoundGUIs.add(DbJcbxjcbxPaymentTerm);
     }else{
       cbxScPaymentTerm.setEditable(true);
       exgui.DataBindJCombobox DbJcbxjcbxPaymentTerm =
           new exgui.DataBindEditableJCombobox(
           cbxScPaymentTerm, "PRODUCTION_PYT_TRM", recPaymentTerm, "PYT_TRM",
           "PYT_TRM", recToMapping.get("PRODUCTION_PYT_TRM"),60); //,"",null);
       dataBoundGUIs.add(DbJcbxjcbxPaymentTerm);
     }


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
     initbuyerSeq=recToMapping.get("PROD_BUYER");
     if(initbuyerSeq==null){
       dvsnRecords=new Vector();
     }else{
       dvsnRecords=
           (Vector)tempProperties.tmpHMap_BuyerDivison.get(initbuyerSeq.toString());
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

      if(isUploadData){
        cbxSzn.setEditable(true);
        dbCbxSzn= new exgui.DataBindEditableJCombobox(cbxSzn,
                      "PROD_SEASON",
                      sznRecords,
                      "SEA_NAME","SEA_NAME",
                      recToMapping.get("PROD_SEASON"),20);
      }else{
      dbCbxSzn= new exgui.DataBindJCombobox(cbxSzn,
                    "PROD_SEASON",
                    sznRecords,
                    "SEA_NAME","SEA_NAME",
                    recToMapping.get("PROD_SEASON"));
      }
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
     if("NTHK".equals(util.PublicVariable.OPERATTING_CENTER)){
       slkHeadBuyer.init("PROD_BUYER", recToMapping.get("PROD_BUYER"),
                            slkHeadBuyer.TYPE_BUYER, false);
       if (slkHeadBuyer.currentRecord() != null) {
         String buyerHkCode = (String)slkHeadBuyer.currentRecord().get(
             "BYMKR_HK_CODE");
         ((javax.swing.JTextField)(slkHeadBuyer.getGUIcomponent())).setText(
             buyerHkCode);
         slkHeadBuyer.orgShowenString = buyerHkCode;
         if("CP240".equalsIgnoreCase(buyerHkCode)){
           lblBranch.setVisible(true);
           cbxBranches.setVisible(true);
         }else{
           lblBranch.setVisible(false);
           cbxBranches.setVisible(false);
         }


       }
     }else{
       if(orgBuyerNameString==null){
         slkHeadBuyer.init("PROD_BUYER", recToMapping.get("PROD_BUYER"),
                           slkHeadBuyer.TYPE_BUYER, false);

       }else{
         slkHeadBuyer.init("PROD_BUYER", recToMapping.get("PROD_BUYER"),orgBuyerNameString,
                           slkHeadBuyer.TYPE_BUYER, false);
       }
     }

      dataBoundGUIs.add(slkHeadBuyer);

      initMkrSeq=recToMapping.get("PROD_MAKER");
      if(orgMakerNameString==null){
        slkHeadMaker.init("PROD_MAKER", initMkrSeq, slkHeadBuyer.TYPE_MAKER, false);
      }else{
        slkHeadMaker.init("PROD_MAKER", initMkrSeq, orgMakerNameString,slkHeadBuyer.TYPE_MAKER, false);
      }

      //dataBoundGUIs.add(slkHeadMaker);
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
  if(!isTpeUser){
    Object vftxtBuyerPrefix = exgui.verification.CellFormat.
        getOrdinaryField(1);
    Object vftxtSubGrp = exgui.verification.CellFormat.
        getOrdinaryField(2);

    dataBoundGUIs.add(new exgui.DataBindTextWithChecker(txtBuyerPrefix,
        "PRODUCTION_BUYER_PREFIX4SC",
                      recToMapping.get("PRODUCTION_BUYER_PREFIX4SC"), 1,
                                        (exgui.Object2String)
                                        vftxtBuyerPrefix,
                                        (exgui.ultratable.
                                         CellTxtEditorFormat)
                                        vftxtBuyerPrefix)
                      );

    dbCbxHKSubGrp=new exgui.DataBindJCombobox(cbxHkSubGrp,
                                  "PRODUCTION_HK_SUBGRP",
                                  (whiteBkgBlueCharLabel6.getText().trim().equalsIgnoreCase("PRODUCTION HEAD ADD"))?
                                  tempProperties.tmpHkSubGrp:tempProperties.tmpHkSubGrp4Update,
                                  "GRP_MNG","GRP_CODE",
                                  recToMapping.get("PRODUCTION_HK_SUBGRP"),"",null);

    dataBoundGUIs.add( dbCbxHKSubGrp );



   /*
    dataBoundGUIs.add(new exgui.DataBindTextWithChecker(txtHkSubGrp,
        "PRODUCTION_HK_SUBGRP",
                      recToMapping.get("PRODUCTION_HK_SUBGRP"), 2,
                                        (exgui.Object2String)
                                        vftxtSubGrp,
                                        (exgui.ultratable.
                                         CellTxtEditorFormat)
                                        vftxtSubGrp)
                      );*/

  }
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
     if(isUploadData){
       cbxSCDest.setEditable(true);
       dataBoundGUIs.add(//new exgui.DataBindEditableJCombobox(
             new exgui.DataBindEditableJCombobox(
              cbxSCDest, "PRODUCTION_SC_DEST", recDests, "Dest_name",
              "dest_name", recToMapping.get("PRODUCTION_SC_DEST"),30));//,20));
      cbxTgtDest.setEditable(true);
      dataBoundGUIs.add(//new exgui.DataBindEditableJCombobox(
                new exgui.DataBindEditableJCombobox(
                cbxTgtDest, "PRODUCTION_TGT_DEST", recDests, "Dest_name",
                "dest_name", recToMapping.get("PRODUCTION_TGT_DEST"),30));//,20));
     }else{
       dataBoundGUIs.add(//new exgui.DataBindEditableJCombobox(
             new exgui.DataBindJCombobox(
              cbxSCDest, "PRODUCTION_SC_DEST", recDests, "Dest_name",
              "dest_name", recToMapping.get("PRODUCTION_SC_DEST")));//,20));
      dataBoundGUIs.add(//new exgui.DataBindEditableJCombobox(
                new exgui.DataBindJCombobox(
                cbxTgtDest, "PRODUCTION_TGT_DEST", recDests, "Dest_name",
                "dest_name", recToMapping.get("PRODUCTION_TGT_DEST")));//,20));
     }



   exgui.DataBindJCombobox DbJcbxjcbxBranches= new exgui.DataBindJCombobox(
       cbxBranches, "PRODUCTION_BRNCH_BRIEF", branches, "BRNCH_BRIEF",
       "BRNCH_BRIEF", recToMapping.get("PRODUCTION_BRNCH_BRIEF"));
   dataBoundGUIs.add(DbJcbxjcbxBranches);

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

   //make the countries and cities related combobox.
      isInitializingCountriesCbx=true;
      if(isUploadData){
        cbxQcQnty.setEditable(true);
        DbJcbxcbxQcCountry =
            new exgui.DataBindEditableJCombobox(cbxQcQnty,
                                        "PRODUCTION_QC_CNTY",
                                        tempProperties.tmpCountries,
                                        "CNTY_NAME", "CNTY_NAME",
                                        recToMapping.get("PRODUCTION_QC_CNTY"),
                                        "NONE", null,20);
      }else{
        DbJcbxcbxQcCountry =
            new exgui.DataBindJCombobox(cbxQcQnty,
                                        "PRODUCTION_QC_CNTY",
                                        tempProperties.tmpCountries,
                                        "CNTY_NAME", "CNTY_NAME",
                                        recToMapping.get("PRODUCTION_QC_CNTY"),
                                        "NONE", null);
      }
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
       boolean isWithInspecOffice=false;
       if("NTFE".equals(util.PublicVariable.OPERATTING_CENTER)||
          "NTD".equals(util.PublicVariable.OPERATTING_CENTER)||
          "CG".equals(util.PublicVariable.OPERATTING_CENTER)||
          "PW".equals(util.PublicVariable.OPERATTING_CENTER)||
          "BW".equals(util.PublicVariable.OPERATTING_CENTER)){
         isWithInspecOffice=true;
       }

      recordColumnsToCopy=new String[(isWithInspecOffice)?(dataBoundGUIs.size()+1):(dataBoundGUIs.size())];
      int i=0;
      for (i = 0; i < dataBoundGUIs.size(); i++) {
       recordColumnsToCopy[i]=((exgui.DataBindGUIObject)dataBoundGUIs.get(i)).getOrgRecField();
      }
      //add field -- inspec office
      if(isWithInspecOffice){
       recordColumnsToCopy[i]="PRODXINSP_INSPEC_COOP";
      }
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
    public boolean isValid(){
      if(isProcessingExit)return true;
      if(!isProcessingUpdteProcess)return true;
      return isFormatValid(txtProdByrPlnDlvy.getText(),0,0);
    }
    public boolean isFormatValid(String dataStr,int i,int j){
      //if have S/C No.skip it.
       if(isProcessingExit)return true;
       if(!isProcessingUpdteProcess)return true;
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
  protected void updateStatusApp2Pendding(Record updatedRec)throws Exception{
    return;
    /*
    if(recToMapping.getInt(0)>0){
      //is to update,if buyer is changed,have to update approval to pendding mode
      int statusCode=0;
      Object objStatus=
          updatedRec.get("PRODUCTION_AUDIT_STATUS");
      if(objStatus!=null)statusCode=Integer.parseInt(objStatus.toString());
      if(statusCode==1||statusCode==2)return;//no need to update po status.
      Object objCurrentBuyer=
          updatedRec.get("prod_buyer");
      Object objCurrentMaker=
          updatedRec.get("prod_maker");
      if(objCurrentMaker==null)objCurrentMaker="";
      if(objCurrentBuyer==null)objCurrentBuyer="";
      String sc_no=(String)updatedRec.get("prod_sc_no");
      if((!objCurrentBuyer.toString().equals((initbuyerSeq==null)?"":initbuyerSeq.toString())) ||
         (!objCurrentMaker.toString().equals((initMkrSeq==null)?"":initMkrSeq.toString()))){
       newtimes.nthk_enqry.EnqDataEngin4Status.updatePoStatus(
        sc_no,
        "1","Buyer Changed");
        whiteBkgBlueCharLabel6.setText("PRODUCTION HEAD EDIT ,AUDIT STATUS:PENDING S/C No.:"+sc_no);
        newtimes.preproduction.Constants.CURRENT_PREPROD_HEAD_RECORD.set("PRODUCTION_AUDIT_STATUS","1");
        newtimes.preproduction.Constants.CURRENT_PREPROD_HEAD_RECORD.getModifiedFields().clear();
      }
    }*/
  }
  public void doUpdate() throws Exception{
    isProcessingUpdteProcess=true;
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
        Record updatedRecord= myDbHander.addRecord(recToMapping);
        updateStatusApp2Pendding(updatedRecord);
        processhandler.template.Properties.getCenteralControler().setCurrentEditingMasterRecord(
          updatedRecord
        );

        newtimes.production.ProdMaintain_Properties.PRODUCTION_AUDIT_STATUS_COLUMN_NAME="PRODUCTION_AUDIT_STATUS";
        newtimes.preproduction.Constants.CURRENT_PREPROD_HEAD_PK=updatedRecord.getInt(0);
        newtimes.preproduction.Constants.CURRENT_PREPROD_HEAD_RECORD=(Record)util.MiscFunc.deepCopy(updatedRecord);
        if(!whiteBkgBlueCharLabel6.getText().trim().equalsIgnoreCase("PRODUCTION HEAD ADD")){
          this.setRecord(updatedRecord);
          this.record2Gui();
        }

        //newtimes.preproduction.Constants.PREPROD_USING_MTRL_DTLS =respondingMTR_V_Records;
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
            lblDisplayProdheadPK.setText(String.valueOf(newtimes.preproduction.Constants.CURRENT_PREPROD_HEAD_PK));
            //whiteBkgBlueCharLabel6.setText("PRODUCTION HEAD EDIT ,AUDIT STATUS:EDITING");
          }
        }
        recClonedForCheck= (Record)util.MiscFunc.deepCopy(updatedRecord);//(Record)util.MiscFunc.deepCopy(recToMapping);
        /*
        processhandler.template.Properties.getCenteralControler().doCommandExecute(
         new newtimes.production.process.prodmaintain.TgrToListStyles()
         );
         */

      }catch(Exception e){
        //e.printStackTrace();
        throw e;
      }finally{
        isProcessingAddNew=false;
        isProcessingUpdteProcess=false;
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
        Record rec=myDbHander.addRecord(recToMapping);
        //switch to color lib detail page..
        rec=myDbHander.findbyPk(rec.getInt(0));
        recClonedForCheck=(Record)util.MiscFunc.deepCopy(recToMapping);
        newtimes.preproduction.Constants.CURRENT_PREPROD_HEAD_PK=rec.getInt(0);
        processhandler.template.Properties.getCenteralControler().setCurrentEditingMasterRecord(
          rec
        );

       newtimes.preproduction.Constants.CURRENT_PREPROD_HEAD_RECORD=rec;
        //newtimes.preproduction.Constants.PREPROD_USING_MTRL_DTLS = respondingMTR_V_Records;

     //preper fo next page,skip re-init byer maker selection process
     newtimes.preproduction.guis.tempProperties.orgProdHeadBuyerString.setLength(0);
     newtimes.preproduction.guis.tempProperties.orgProdHeadMakerString.setLength(0);
     String orgBuyer=((javax.swing.text.JTextComponent)slkHeadBuyer.getGUIcomponent()).getText();
     String orgMaker=((javax.swing.text.JTextComponent)slkHeadMaker.getGUIcomponent()).getText();
     newtimes.preproduction.guis.tempProperties.orgProdHeadBuyerString.append(orgBuyer);
     newtimes.preproduction.guis.tempProperties.orgProdHeadMakerString.append(orgMaker);

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


       //check if any style shipped.
       Vector vct=exgui2.CONST.BASIC_MAIN_EJB.getDatas(
        util.PublicVariable.USER_RECORD,
        "select count(*) from ship_style where  ship_style.STY_SEQ in (select sty_seq from style where sty_sc_no='"+
        (String)newtimes.preproduction.Constants.CURRENT_PREPROD_HEAD_RECORD.get("prod_sc_no") +"')",
        1,1
        );
       Record recTestShipmemt=(Record)vct.get(0);
       if(recTestShipmemt.getInt(0)>0){
         exgui.verification.VerifyLib.showAlert("Styles  Of this Production are shipped\nCan Not Delete",
                                                "PO Shipped,Can not delete");
         return;
       }

      if(!exgui.verification.VerifyLib.showConfirm(
          "Are You Sure To Delete This Production?","Are You Sure?")) return;
      util.MiscFunc.showProcessingMessage();
      recToMapping.set("record_modify_user",util.PublicVariable.USER_RECORD.get(0));
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
       /*
       Vector vct2Copy=(Vector)util.MiscFunc.deepCopy(respondingMTR_V_Records);
       util.ApplicationProperites.setProperties(
           id4ApplicationProperties+"_MTR_V_Records",
           vct2Copy
           );*/

     }catch(Exception e){
        e.printStackTrace();
     }finally{
       isProcessingCopy=false;
     }
  }
  public boolean gui2Record(){
    //when super class call myDbHander to update record,also,update co-responding MTR_V_Records
    if(isProcessingExit)return true;
    if(!isProcessingUpdteProcess)return true;//mabe processing exit.
    //myDbHander.setMTR_V_Records(respondingMTR_V_Records);
    if(!super.gui2Record())return false;
    //verify the fabric commision data
    try{
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
      //if buyer or division changed,need to update the styles commmisions co-responding to this buyer/division

    }catch(Exception e){
         e.printStackTrace();
    }
    //test :buyuer,buyer_div ,center,department can not be null.
    if(!buyerPlanDlvDbCheck.isValid()){
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
    if(util.PublicVariable.OPERATTING_CENTER.equals("NTHK")){
      if(txtBuyerPrefix.getText().trim().length()==0){
        exgui.verification.VerifyLib.showAlert("Please Assign A Buyer Prefix Code ",
                                               "Please Select A Buyer Prefix Code");
        txtBuyerPrefix.grabFocus();
        return false;
      }
      txtBuyerPrefix.setText(txtBuyerPrefix.getText().trim().toUpperCase());
    }
    // the DAMMMMMMMMMED NTHK ,2006 have to input Sub Group
    Object recCreateDate=null;
    try{
      recCreateDate=recToMapping.get("record_create_date");
    }catch(Exception exp){

    }
    if(util.PublicVariable.OPERATTING_CENTER.equals("NTHK")){
      if(recCreateDate==null && dbCbxHKSubGrp.getSelectedValue()==null){
        exgui.verification.VerifyLib.showAlert("Please Assign SUB GROUP ",
                                               "Please Assign SUB GROUP ");
        dbCbxHKSubGrp.grabFocus();
        return false;
      }
      /*
      if(txtHkSubGrp.getText().trim().length()==0&&
         //Integer.parseInt(txtYear.getText())>2005 ||
         recCreateDate==null){
        exgui.verification.VerifyLib.showAlert("Please Assign SUB GROUP CODE",
                                               "Please Assign SUB GROUP CODE");
        txtHkSubGrp.grabFocus();
        return false;
      }
      txtHkSubGrp.setText(txtHkSubGrp.getText().trim().toUpperCase());
      //check if sub group code is vailid:*/

    }

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
          if (cnvYearData < bgnYear && (!isProcessingExit) && (!isGotoStyle)) {
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

      if("NTFE".equals(util.PublicVariable.OPERATTING_CENTER)||
         "NTD".equals(util.PublicVariable.OPERATTING_CENTER)||
         "CG".equals(util.PublicVariable.OPERATTING_CENTER)||
         "PW".equals(util.PublicVariable.OPERATTING_CENTER)||
         "BW".equals(util.PublicVariable.OPERATTING_CENTER)){
        recToMapping.set("PRODXINSP_INSPEC_CODE",dbCbxInspOffice.getSelectedValue());
         if((!rdoInspOffice_Coop.isSelected()) && (!rdoInspOffice_Insp.isSelected())){
           recToMapping.set("PRODXINSP_INSPEC_COOP",null);
         }else{
           if(rdoInspOffice_Coop.isSelected()) recToMapping.set("PRODXINSP_INSPEC_COOP","C");
           if(rdoInspOffice_Insp.isSelected()) recToMapping.set("PRODXINSP_INSPEC_COOP","I");
         }
      }


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
        if(recordColumnsToCopy[i].toUpperCase().startsWith("PROD_MAKER"))continue;
        if(recordColumnsToCopy[i].toUpperCase().startsWith("PRODUCTION_BYR_SC_ISSUE") &&
           ("NTFE".equals(util.PublicVariable.OPERATTING_CENTER)||
           "NTD".equals(util.PublicVariable.OPERATTING_CENTER)||
           "CG".equals(util.PublicVariable.OPERATTING_CENTER)||
           "PW".equals(util.PublicVariable.OPERATTING_CENTER)||
           "BW".equals(util.PublicVariable.OPERATTING_CENTER))){
           continue;
        }
        recToMapping.set(
           recordColumnsToCopy[i],
           tmprec.get(recordColumnsToCopy[i])
        );
      }
      //respondingMTR_V_Records =(Vector) util.ApplicationProperites.getProperties(id4ApplicationProperties+"_MTR_V_Records");
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
    /*
    processhandler.template.Properties.getCenteralControler().setSystemCommander(
      newtimes.preproduction.Constants.CMDSET_PREPRODUCTION_MAINTAIN
    );*/

   processhandler.template.Properties.getCenteralControler().doCommandExecute(
      new newtimes.preproduction.process.TgrToDoOrderPrint());
    //throw new processhandler.commands.CommandException("the print method of Production head is not implemented yet");
  }
  private void mappingListMtrlNo(){
    return;
    /*
    StringBuffer sb=new StringBuffer();
    for(int i=0;i<respondingMTR_V_Records.size();i++){
      database.datatype.Record rec=(database.datatype.Record)
             respondingMTR_V_Records.get(i);
       sb.append((String)rec.get(1));
       if(i<respondingMTR_V_Records.size()-1)sb.append(",");
    }
    newtimes.preproduction.Constants.PREPROD_USING_MTRL_DTLS_STRING=sb.toString();*/
  }
  JComboBox cbxQcQnty = new JComboBox();
  JLabel lblQcCountry = new JLabel();
  JLabel whiteBkgBlueCharLabel4 = new JLabel();
  JComboBox cbxScPrxTrm = new JComboBox();
  JLabel lblBoardRng = new JLabel();
  JTextField txtRange = new JTextField();
  JTextField txtGrpName = new JTextField();
  JLabel lblGrpName = new JLabel();
  JTextField txtGroup = new JTextField();
  JLabel lblGrpNo = new JLabel();
  JLabel lblQcCity = new JLabel();
  JComboBox cbxCity = new JComboBox();
  JComboBox cbxBranches = new JComboBox();
  JLabel lblBranch = new JLabel();
  JTextField txtBuyerSCNO = new JTextField();
  JLabel whiteBkgBlueCharLabel23 = new JLabel();
  public JComboBox cbxSCDest = new JComboBox();
  JLabel lblPortTermDest = new JLabel();
  JLabel blueBkgWhiteCharLabel20 = new JLabel();
  JTextField txtBuyerLabel = new JTextField();
  JLabel lblGoodDest = new JLabel();
  public JComboBox cbxTgtDest = new JComboBox();
  Border border3;
  TitledBorder titledBorder4;
  ButtonGroup btnFabCmm = new ButtonGroup();
  JTextField txtProtoNo = new JTextField();
  JLabel lblProtoNo = new JLabel();
  JLabel whiteBkgBlueCharLabel10 = new JLabel();
  JComboBox cbxScPaymentTerm = new JComboBox();
  JLabel blueBkgWhiteCharLabel22 = new JLabel();
  JComboBox cbxCurrency = new JComboBox();
  JLabel whiteBkgBlueCharLabel19 = new JLabel();
  JTextField txtBuySC_ISU_Date = new JTextField();
  BlueBkgWhiteCharLabel lblTitleUserName = new BlueBkgWhiteCharLabel();
  JLabel lbl2ShowCreateDate = new JLabel();
  JLabel lblBuyerPrefix = new JLabel();
  JTextField txtBuyerPrefix = new JTextField();
  JButton btnChkSc = new JButton();
  public JButton btnCopyWholePO = new JButton();
  JLabel lblHKSubGrp = new JLabel();
  JComboBox cbxHkSubGrp = new JComboBox();
  JPanel pnlInspOffice = new JPanel();
  JLabel lblInspOffice = new JLabel();
  JComboBox cbxInspOffice = new JComboBox();
  JRadioButton rdoInspOffice_Insp = new JRadioButton();
  JRadioButton rdoInspOffice_Coop = new JRadioButton();
  ButtonGroup buttonGroupInspOffice = new ButtonGroup();

  void btnChkSc_actionPerformed(ActionEvent e) {
   //if(!txtBuyerPrefix.isEditable()) return;
   DlgShowByrMkrOfHkSc dlg=new DlgShowByrMkrOfHkSc(
      util.PublicVariable.APP_FRAME,
      "S/C and Buyer and Maker",true);
    dlg.setSize(535,400);
    exgui.UIHelper.setToScreenCenter(dlg);
    dlg.show();
  }

  void btnCopyWholePO_actionPerformed(ActionEvent e) {
    if(!exgui.verification.VerifyLib.showConfirm("Are You Sure To Duplicate Whole Data Of This Production ?",
                                                 "Are You Sure ?"))return;

    try {

      util.MiscFunc.showProcessingMessage();
      newtimesejb.production.MessDuplicatorHome  ejbHome =
          (newtimesejb.production.MessDuplicatorHome)
          info_ejb.WeblogicServiceLocator.locateServiceHome(util.PublicVariable.
          SERVER_URL,
          "newtimesejb.production.MessDuplicator");
      newtimesejb.production.MessDuplicator ejb = ejbHome.create();
     String refNo = ejb.duplicateForXCenter(newtimes.preproduction.Constants.
                                  CURRENT_PREPROD_HEAD_PK,
                                 (String)util.PublicVariable.USER_RECORD.get(
                                  "usr_code"));
      util.MiscFunc.hideProcessingMessage();
      exgui.verification.VerifyLib.showPlanMsg(
          "Duplicate OK\n S/C. Of New Production is:" + refNo,
          "Duplicate OK");
      util.MiscFunc.showProcessingMessage();
      StringBuffer sb=new StringBuffer();
      sb.append("select a.prod_head_pk,b.BYMKR_BRIEF as buyer_name,c.BYMKR_BRIEF as maker_name ");
      sb.append(" from production a,buyer_maker b,buyer_maker c,prod_head d ");
      sb.append(" where a.prod_head_pk=d.prod_head_pk ");
      sb.append(" and b.bymkr_seq=d.prod_buyer ");
      sb.append(" and c.bymkr_seq=d.prod_maker ");
      sb.append(" and a.prod_sc_no='");sb.append(refNo);
      sb.append("' ");
        Record recORg=
            (Record)
            exgui2.CONST.BASIC_MAIN_EJB.getDatas(
          util.PublicVariable.USER_RECORD,
          sb.toString(),
          1,99999).get(0);
         int pk=recORg.getInt(0);
       Record rec2Edit=myDbHander.findbyPk(pk);
       processhandler.template.Properties.getCenteralControler().setCurrentEditingMasterRecord(rec2Edit);
       newtimes.production.ProdMaintain_Properties.PRODUCTION_AUDIT_STATUS_COLUMN_NAME="PRODUCTION_AUDIT_STATUS";
       newtimes.preproduction.Constants.CURRENT_PREPROD_HEAD_PK=rec2Edit.getInt(0);
       newtimes.preproduction.Constants.CURRENT_PREPROD_HEAD_RECORD=rec2Edit;
       newtimes.preproduction.guis.tempProperties.orgProdHeadBuyerString.setLength(0);
       newtimes.preproduction.guis.tempProperties.orgProdHeadMakerString.setLength(0);

       String orgBuyer=recORg.get(1).toString();
       String orgMaker=recORg.get(2).toString();
       newtimes.preproduction.guis.tempProperties.orgProdHeadBuyerString.append(orgBuyer);
       newtimes.preproduction.guis.tempProperties.orgProdHeadMakerString.append(orgMaker);
       processhandler.template.Properties.getCenteralControler().doCommandExecute(
          new newtimes.preproduction.process.TrggerEditAPreprod());


      util.MiscFunc.hideProcessingMessage();

    } catch (Exception exp) {
        exp.printStackTrace();
        util.ExceptionLog.exp2File(exp,"");
        exgui.verification.VerifyLib.showAlert("Error While Duplicating Whole PO\nPlease Contact System Manager",
                                               "Error While Duplicating Whole PO");
    }
  }
}


class PnlNTHKEditPPHead_cbxCountry_itemAdapter implements java.awt.event.ItemListener {
  PnlNTHKEditPPHead adaptee;

  PnlNTHKEditPPHead_cbxCountry_itemAdapter(PnlNTHKEditPPHead adaptee) {
    this.adaptee = adaptee;
  }
  public void itemStateChanged(ItemEvent e) {
    adaptee.cbxCountry_itemStateChanged(e);
  }
}
class PnlNTHKEditPPHead_cbxDiv_itemAdapter implements java.awt.event.ItemListener {
  PnlNTHKEditPPHead adaptee;

  PnlNTHKEditPPHead_cbxDiv_itemAdapter(PnlNTHKEditPPHead adaptee) {
    this.adaptee = adaptee;
  }
  public void itemStateChanged(ItemEvent e) {
    adaptee.cbxDiv_itemStateChanged(e);
  }

}

class PnlNTHKEditPPHead_cbxCenter_itemAdapter implements java.awt.event.ItemListener {
  PnlNTHKEditPPHead adaptee;

  PnlNTHKEditPPHead_cbxCenter_itemAdapter(PnlNTHKEditPPHead adaptee) {
    this.adaptee = adaptee;
  }
  public void itemStateChanged(ItemEvent e) {
    adaptee.cbxCenter_itemStateChanged(e);
  }

}

class PnlNTHKEditPPHead_btnChkSc_actionAdapter implements java.awt.event.ActionListener {
  PnlNTHKEditPPHead adaptee;

  PnlNTHKEditPPHead_btnChkSc_actionAdapter(PnlNTHKEditPPHead adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.btnChkSc_actionPerformed(e);
  }
}

class PnlNTHKEditPPHead_btnCopyWholePO_actionAdapter implements java.awt.event.ActionListener {
  PnlNTHKEditPPHead adaptee;

  PnlNTHKEditPPHead_btnCopyWholePO_actionAdapter(PnlNTHKEditPPHead adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.btnCopyWholePO_actionPerformed(e);
  }
}


