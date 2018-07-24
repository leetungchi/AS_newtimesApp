package newtimes.shipping_admin.guis.shippingmaintain;
import java.awt.*;
import exgui.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.border.*;
import newtimes.preproduction.buyermakerselect.*;
import java.util.*;
import newtimes.preproduction.guis.*;
import newtimes.shipping_admin.guis.shippingmaintain.PnlShipMaster;
/**
 * <p>Title: </p>
 * <p>Description: </p>F
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */


public class PnlQryShippingMaster extends JPanel {

  protected JLabel textAreaStatus = new JLabel();
  protected JButton butnAdd = new JButton();
  protected JLabel jLabel1 = new JLabel();
  protected JButton butnExit = new JButton();
  protected String usrCenCode = null;
  protected String usrType = null;
  JTextField txtSC_no = new JTextField();
  JLabel jTextField4 = new JLabel();
  JPanel jPanel1 = new JPanel();
  TitledBorder titledBorder1;
  JTextField txtSrnNo = new JTextField();
  JLabel jTextField3 = new JLabel();
  JButton butnModify = new JButton();
  SelectBuyerMaker slkBuyer = new SelectBuyerMaker();
  JLabel jTextField5 = new JLabel();
  JLabel jTextField6 = new JLabel();
  SelectBuyerMaker slkMaker = new SelectBuyerMaker();
  JLabel jTextField7 = new JLabel();
  JLabel jTextField8 = new JLabel();
  JComboBox cbxCenter = new JComboBox();
  JComboBox cbxDep = new JComboBox();
  exgui.DataBindJCombobox DbJcbxcbxCntr;
  exgui.DataBindJCombobox DbJcbxcbxDep;
  static exgui.DataBindJCombobox dbCbxDepWithScWithPk;
   exgui.DataBindJCombobox dbCbxdiv;
  exgui.DataBindTextWithChecker dbTxtSRN,dbTxtEtdFrom,dbTxtEtdTo,dbTxtCustPo,dbTxtStyleStyle;

  JTextField txtETDfrom = new JTextField();
  JLabel jTextField9 = new JLabel();
  JTextField txtEDTto = new JTextField();
  JLabel jTextField10 = new JLabel();
  java.util.List guis=new java.util.ArrayList();
  int depCbxDBGUI_index=0;
  boolean doingDB2Gui=false;
  JTextField txtSCno = new JTextField();
  JLabel jTextField11 = new JLabel();
  JRadioButton rdoListBySRN = new JRadioButton();
  ButtonGroup buttonGroup1 = new ButtonGroup();
  JRadioButton rdoListBySC = new JRadioButton();
  JRadioButton rdoListBySI = new JRadioButton();
  JButton btnAddDummySRN = new JButton();
  static Vector vct2dummySRN_SC=null;
  static Pnl2ListDepForDummySRN pnl2QryDepSc4Dummy;
  JTextField txtCustPo = new JTextField();
  JTextField txtStyleStyle = new JTextField();
  JLabel jTextField12 = new JLabel();
  JLabel jTextField13 = new JLabel();
  JLabel lblDiv = new JLabel();
  JComboBox cbxDiv = new JComboBox();
  BuyerChanged buyerChangeListener=new BuyerChanged();
  int indexDiv=0;
  public PnlQryShippingMaster() {
    try {
        newtimes.shipping_admin.ShippingAdmin_Const.OFFSHORE_CENTER = util.PublicVariable.USER_RECORD.get(4).toString();
      newtimes.shipping_admin.guis.shippingmaintain.PnlShipMaster.branches = newtimes.production.process.prodmaintain.DB_ProdSC.getBranches();
      usrType = util.PublicVariable.USER_RECORD.get("USR_TYPE").toString();
      jbInit();
      if(util.PublicVariable.OPERATTING_CENTER.equals("001")||
         util.PublicVariable.OPERATTING_CENTER.equals("NTHK")){
        //no need to query the SHIP_NTD_SIG_TTL data.since ship head gui does not contain these 2 field
        return;
      }
      if(newtimes.shipping_admin.ShippingAdmin_Const.vctSignatuers==null){
        newtimes.shipping_admin.ShippingAdmin_Const.vctSignatuers=exgui2.CONST.BASIC_MAIN_EJB.getDatas(
         util.PublicVariable.USER_RECORD,
         "select * from SHIP_NTD_SIG_TTL where signatuer is not null",1,999999);
         newtimes.shipping_admin.ShippingAdmin_Const.hmSignatureTitle=new
             java.util.HashMap();
        for(int i=0;i<newtimes.shipping_admin.ShippingAdmin_Const.vctSignatuers.size();i++){
          database.datatype.Record rec=
              (database.datatype.Record)newtimes.shipping_admin.ShippingAdmin_Const.vctSignatuers.get(i);
          newtimes.shipping_admin.ShippingAdmin_Const.hmSignatureTitle.put(rec.get(0),rec.get(1));
        }
      }
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }

  void jbInit() throws Exception {
    titledBorder1 = new TitledBorder(new EtchedBorder(EtchedBorder.RAISED,Color.white,new Color(142, 142, 157)),"Search SRN Records By Conditions");
    cbxCenter.setBounds(new Rectangle(91, 15, 151, 22));
    this.setAuth();
    butnExit.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnExit_actionPerformed(e);
      }
    });
    butnExit.setText("Exit");
    butnExit.setForeground(Color.darkGray);
    butnExit.setFont(new java.awt.Font("Dialog", 1, 13));
    butnExit.setBounds(new Rectangle(594, 506, 80, 25));
    butnExit.setBackground(Color.lightGray);
    jLabel1.setBounds(new Rectangle(117, 26, 566, 24));
    jLabel1.setText("      ============  Shipping Maintain  ============      ");
    jLabel1.setHorizontalAlignment(SwingConstants.CENTER);
    jLabel1.setBorder(BorderFactory.createEtchedBorder());
    jLabel1.setForeground(new Color(10,36,106));
    jLabel1.setFont(new java.awt.Font("Dialog", 1, 13));
    butnAdd.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        butnAdd_actionPerformed(e);
      }
    });
    butnAdd.setText("Add New SRN");
    butnAdd.setForeground(Color.darkGray);
    butnAdd.setFont(new java.awt.Font("Dialog", 1, 13));
    butnAdd.setBounds(new Rectangle(428, 451, 127, 25));
    butnAdd.setBackground(Color.lightGray);
    textAreaStatus.setBounds(new Rectangle(0, 540, 800, 30));
    //textAreaStatus.setEditable(false);
    textAreaStatus.setBorder(null);
    textAreaStatus.setOpaque(true);
    textAreaStatus.setBackground(new Color(143, 143, 188));
    this.setLayout(null);
    this.setSize(800,600);
    this.setBackground(new Color(204, 204, 225));
    txtSC_no.setText("");
    txtSC_no.setBounds(new Rectangle(210, 451, 213, 25));
    jTextField4.setEnabled(true);
    jTextField4.setBackground(new Color(143, 143, 188));
    jTextField4.setFont(new java.awt.Font("Dialog", 1, 12));
    jTextField4.setForeground(Color.white);
    //jTextField4.setEditable(false);
    jTextField4.setBorder(null);
    jTextField4.setOpaque(true);
    jTextField4.setText("S/C No.");
    jTextField4.setBounds(new Rectangle(122, 452, 88, 23));
    jPanel1.setBackground(new Color(204, 204, 225));
    jPanel1.setBorder(titledBorder1);
    jPanel1.setBounds(new Rectangle(120, 68, 564, 296));
    jPanel1.setLayout(null);
    txtSrnNo.setBounds(new Rectangle(92, 226, 151, 23));
    jTextField3.setBounds(new Rectangle(11, 226, 81, 23));
    jTextField3.setText("SRN No. :");
    jTextField3.setBorder(null);
    jTextField3.setOpaque(true);
    jTextField3.setHorizontalAlignment(SwingConstants.CENTER);
    //jTextField3.setEditable(false);
    jTextField3.setForeground(Color.blue);
    jTextField3.setFont(new java.awt.Font("Dialog", 1, 12));
    jTextField3.setBackground(new Color(143, 143, 188));
    jTextField3.setEnabled(true);
    butnModify.setBounds(new Rectangle(354, 263, 156, 25));
    butnModify.setEnabled(true);
    butnModify.setFont(new java.awt.Font("Dialog", 1, 11));
    butnModify.setText("SEARCH");
    butnModify.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        butnModify_actionPerformed(e);
      }
    });
    slkBuyer.setBounds(new Rectangle(91, 68, 151, 19));
    jTextField5.setEnabled(true);
    jTextField5.setBackground(new Color(143, 143, 188));
    jTextField5.setFont(new java.awt.Font("Dialog", 1, 12));
    jTextField5.setForeground(Color.blue);
    //jTextField5.setEditable(false);
    jTextField5.setBorder(null);
    jTextField5.setOpaque(true);
    jTextField5.setHorizontalAlignment(SwingConstants.CENTER);
    jTextField5.setText("BUYER  :");
    jTextField5.setBounds(new Rectangle(11, 68, 81, 20));
    jTextField6.setBounds(new Rectangle(304, 68, 81, 21));
    jTextField6.setText("MAKER  :");
    jTextField6.setBorder(null);
    jTextField6.setOpaque(true);
    jTextField6.setHorizontalAlignment(SwingConstants.CENTER);
    //jTextField6.setEditable(false);
    jTextField6.setForeground(Color.blue);
    jTextField6.setFont(new java.awt.Font("Dialog", 1, 12));
    jTextField6.setBackground(new Color(143, 143, 188));
    jTextField6.setEnabled(true);
    slkMaker.setBounds(new Rectangle(385, 68, 131, 21));
    jTextField7.setEnabled(true);
    jTextField7.setBackground(new Color(143, 143, 188));
    jTextField7.setFont(new java.awt.Font("Dialog", 1, 12));
    jTextField7.setForeground(Color.white);
    //jTextField7.setEditable(false);
    jTextField7.setBorder(null);
    jTextField7.setOpaque(true);
    jTextField7.setHorizontalAlignment(SwingConstants.CENTER);
    jTextField7.setText("CENTER");
    jTextField7.setBounds(new Rectangle(11, 15, 81, 23));
    jTextField8.setEnabled(true);
    jTextField8.setBackground(new Color(143, 143, 188));
    jTextField8.setFont(new java.awt.Font("Dialog", 1, 12));
    jTextField8.setForeground(Color.white);
    //jTextField8.setEditable(false);
    jTextField8.setBorder(null);
    jTextField8.setOpaque(true);
    jTextField8.setHorizontalAlignment(SwingConstants.CENTER);
    jTextField8.setText("DEP.");
    jTextField8.setBounds(new Rectangle(304, 15, 81, 23));
    cbxDep.setBounds(new Rectangle(385, 15, 131, 22));
    txtETDfrom.setBounds(new Rectangle(91, 120, 151, 23));
    jTextField9.setEnabled(true);
    jTextField9.setBackground(new Color(143, 143, 188));
    jTextField9.setFont(new java.awt.Font("Dialog", 1, 12));
    jTextField9.setForeground(Color.white);
    jTextField9.setOpaque(true);
    jTextField9.setHorizontalAlignment(SwingConstants.CENTER);
    jTextField9.setBorder(null);
    jTextField9.setText("ETD FROM:");
    jTextField9.setBounds(new Rectangle(10, 120, 81, 23));
    txtEDTto.setBounds(new Rectangle(384, 120, 130, 23));
    jTextField10.setEnabled(true);
    jTextField10.setBackground(new Color(143, 143, 188));
    jTextField10.setFont(new java.awt.Font("Dialog", 1, 12));
    jTextField10.setForeground(Color.white);
    jTextField10.setOpaque(true);
    jTextField10.setHorizontalAlignment(SwingConstants.CENTER);
    jTextField10.setBorder(null);
    jTextField10.setText("ETD TO:");
    jTextField10.setBounds(new Rectangle(303, 120, 81, 23));
    txtSCno.setBounds(new Rectangle(385, 226, 127, 23));
    jTextField11.setEnabled(true);
    jTextField11.setBackground(new Color(143, 143, 188));
    jTextField11.setFont(new java.awt.Font("Dialog", 1, 12));
    jTextField11.setForeground(Color.blue);
    jTextField11.setHorizontalAlignment(SwingConstants.CENTER);
    jTextField11.setOpaque(true);
    jTextField11.setBorder(null);
    jTextField11.setText("S/C No. :");
    jTextField11.setBounds(new Rectangle(304, 226, 81, 23));
    rdoListBySRN.setBackground(Color.white);
    rdoListBySRN.setFont(new java.awt.Font("Dialog", 1, 11));
    rdoListBySRN.setSelected(true);
    rdoListBySRN.setText("Search By SRN");
    rdoListBySRN.setBounds(new Rectangle(13, 252, 138, 19));
    rdoListBySC.setBounds(new Rectangle(150, 252, 121, 19));
    rdoListBySC.setText("Search By S/C");
    rdoListBySC.setFont(new java.awt.Font("Dialog", 1, 11));
    rdoListBySC.setBackground(Color.white);
    rdoListBySI.setBackground(Color.white);
    rdoListBySI.setFont(new java.awt.Font("Dialog", 1, 11));
    rdoListBySI.setActionCommand("jRadioButton1");
    rdoListBySI.setText("Search By S/I");
    rdoListBySI.setBounds(new Rectangle(13, 271, 258, 17));
    btnAddDummySRN.setBounds(new Rectangle(564, 451, 173, 25));
    btnAddDummySRN.setFont(new java.awt.Font("Dialog", 1, 11));
    if(util.PublicVariable.OPERATTING_CENTER.equals("001")){
       btnAddDummySRN.setText("ADD W/O S/C");
    }else{
      btnAddDummySRN.setText("GET SC# by PO#");//"GET PO BY CUST PO");
      if(newtimes.shipping_admin.ShippingAdmin_Const.IS_LORAN_MODE){
        btnAddDummySRN.setBounds(new Rectangle(564, 451, 193, 25));
        btnAddDummySRN.setText("GET SC# by PO# or Fty INV#");
      }
    }
    btnAddDummySRN.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnAddDummySRN_actionPerformed(e);
      }
    });
    txtCustPo.setBounds(new Rectangle(384, 173, 127, 23));
    txtStyleStyle.setBounds(new Rectangle(91, 173, 151, 23));
    jTextField12.setEnabled(true);
    jTextField12.setBackground(new Color(143, 143, 188));
    jTextField12.setFont(new java.awt.Font("Dialog", 1, 12));
    jTextField12.setForeground(Color.blue);
    jTextField12.setHorizontalAlignment(SwingConstants.CENTER);
    jTextField12.setOpaque(true);
    jTextField12.setBorder(null);
    jTextField12.setText("STYLE :");
    jTextField12.setBounds(new Rectangle(10, 173, 81, 23));
    jTextField13.setBounds(new Rectangle(303, 173, 81, 23));
    jTextField13.setText("PO. :");
    jTextField13.setBorder(null);
    jTextField13.setOpaque(true);
    jTextField13.setHorizontalAlignment(SwingConstants.CENTER);
    jTextField13.setForeground(Color.blue);
    jTextField13.setFont(new java.awt.Font("Dialog", 1, 12));
    jTextField13.setBackground(new Color(143, 143, 188));
    jTextField13.setEnabled(true);
    lblDiv.setBounds(new Rectangle(11, 89, 81, 21));
    lblDiv.setText("DIVISION  :");
    lblDiv.setHorizontalAlignment(SwingConstants.CENTER);
    lblDiv.setOpaque(true);
    lblDiv.setBorder(null);
    lblDiv.setForeground(Color.blue);
    lblDiv.setFont(new java.awt.Font("Dialog", 1, 12));
    lblDiv.setBackground(new Color(143, 143, 188));
    lblDiv.setEnabled(true);
    cbxDiv.setBounds(new Rectangle(91, 89, 151, 23));
    this.add(textAreaStatus, null);
    this.add(jLabel1, null);
    this.add(jTextField4, null);
    this.add(jPanel1, null);
    this.add(butnExit, null);
    this.add(txtSC_no, null);
    this.add(butnAdd, null);
    //this.add(btnAddDummySRN, null);

    if(!util.PublicVariable.OPERATTING_CENTER.equals("NTHK")){
      this.add(btnAddDummySRN, null);
    }

    jPanel1.add(butnModify, null);
    jPanel1.add(rdoListBySRN, null);
    jPanel1.add(rdoListBySC, null);
    jPanel1.add(rdoListBySI, null);
    jPanel1.add(jTextField6, null);
    jPanel1.add(slkMaker, null);
    jPanel1.add(jTextField9, null);
    jPanel1.add(txtETDfrom, null);
    jPanel1.add(jTextField10, null);
    jPanel1.add(txtEDTto, null);
    cbxCenter.addItemListener(new cbxCenterItemChanged());
    slkBuyer.init("b.PROD_BUYER",null,slkBuyer.TYPE_BUYER,true);
    slkMaker.init("b.PROD_MAKER",null,slkBuyer.TYPE_MAKER,true);
    guis.clear();
    buttonGroup1.add(rdoListBySRN);
    buttonGroup1.add(rdoListBySC);
    buttonGroup1.add(rdoListBySI);
    jPanel1.add(jTextField12, null);
    jPanel1.add(txtStyleStyle, null);
    jPanel1.add(jTextField13, null);
    jPanel1.add(txtCustPo, null);
    jPanel1.add(jTextField7, null);
    jPanel1.add(cbxCenter, null);
    jPanel1.add(jTextField5, null);
    jPanel1.add(slkBuyer, null);
    jPanel1.add(jTextField8, null);
    jPanel1.add(cbxDep, null);
    jPanel1.add(jTextField11, null);
    jPanel1.add(txtSCno, null);
    jPanel1.add(jTextField3, null);
    jPanel1.add(txtSrnNo, null);
    if(util.PublicVariable.OPERATTING_CENTER.equals("001")){
      jPanel1.add(lblDiv, null);
      jPanel1.add(cbxDiv, null);
    }

    cbxDep.setUI(new exgui.WideComboBoxUI(200));
    cbxDiv.setUI(new exgui.WideComboBoxUI(260));

  }
  class BuyerChanged implements newtimes.preproduction.buyermakerselect.BuyerMakerChanged{
    public void changeBuyerMaker(database.datatype.Record rec){
       if(rec==null){
         dbCbxdiv=new exgui.DataBindJCombobox(
             cbxDiv,
             "b.PROD_BUYER_DIVISION",
             new Vector(),
             "DIV_NAME","DIV_CODE",
             null,"N/A",null);
         guis.set(indexDiv,dbCbxdiv);
       }else{
         int buyerSeq=rec.getInt(0);
         try{
           java.util.Vector vctDiv = exgui2.CONST.BASIC_MAIN_EJB.getDatas(
               util.PublicVariable.USER_RECORD,
               "select * from division where DIV_BYMKR_SEQ=" +
               String.valueOf(buyerSeq) + " order by DIV_NAME"
               , 1, 9999);

            dbCbxdiv=new exgui.DataBindJCombobox(
                cbxDiv,
                "b.PROD_BUYER_DIVISION",
                vctDiv,
                "DIV_NAME","DIV_CODE",
                null,"N/A",null);

             guis.set(indexDiv,dbCbxdiv);

         }catch(Exception exp){
           exp.printStackTrace();
           util.ExceptionLog.exp2File(exp,"");
         }
       }
    }
  }
  class cbxCenterItemChanged implements java.awt.event.ItemListener{
    public void itemStateChanged(ItemEvent e){
      if(doingDB2Gui)return;
      util.PublicVariable.OPERATTING_CENTER=(String)DbJcbxcbxCntr.getSelectedValue();
      try{
        //and d.cen_code='001'
        //and e.dep_code='TPJ05'
        //find out the vector to add dbDeps.
        if (DbJcbxcbxCntr.getSelectedValue()==null) {
          slkBuyer.setSelectingCenter((String)DbJcbxcbxCntr.getSelectedValue());
          slkMaker.setSelectingCenter((String)DbJcbxcbxCntr.getSelectedValue());
          slkBuyer.init("b.PROD_BUYER",null,slkBuyer.TYPE_BUYER,true);
          slkMaker.init("b.PROD_MAKER",null,slkBuyer.TYPE_MAKER,true);
          //only the all dep is allow to add now.
          exgui.DataBindJCombobox DbJcbxcbxDep =
              new exgui.DataBindJCombobox(
              cbxDep,"e.dep_code" ,
              new Vector(),
              "DEP_NAME", "DEP_CODE",
              null,
              "ALL", null);
          if(depCbxDBGUI_index == guis.size()) {
            guis.add(DbJcbxcbxDep);
          }else{
            //just replace after display & change;
            guis.set(depCbxDBGUI_index,DbJcbxcbxDep);
          }
        }else {
          //deps and "ALL"dep allow to add.
          Vector depVects=
              (Vector)tempProperties.tmpH_tbl_CenterDepMap.get(
              DbJcbxcbxCntr.getSelectedValue());
          exgui.DataBindJCombobox DbJcbxcbxDep=null;
          if(depVects==null){
            DbJcbxcbxDep =
               new exgui.DataBindJCombobox(
               cbxDep,"e.dep_code",
               new Vector(),
               "DEP_NAME", "DEP_CODE",
               null,
               "ALL", null);
          }else if(depVects.size()>1){
             DbJcbxcbxDep =
                new exgui.DataBindJCombobox(
                cbxDep,"e.dep_code",
                depVects,
                "DEP_NAME", "DEP_CODE",
                null,
                "ALL", null);
            //guis.add(DbJcbxcbxDep);
          }else{
            DbJcbxcbxDep =
                new exgui.DataBindJCombobox(
                cbxDep, "e.dep_code",
                depVects,
                "DEP_NAME", "DEP_CODE",
                null);
            //guis.add(DbJcbxcbxDep);
          }

          if (depCbxDBGUI_index == guis.size()) {
             guis.add(DbJcbxcbxDep);
          }else{
            guis.set(depCbxDBGUI_index,DbJcbxcbxDep);
          }
          String centerCode=DbJcbxcbxCntr.getSelectedValue().toString();
          slkBuyer.setSelectingCenter(centerCode);
          slkMaker.setSelectingCenter(centerCode);
          buyerChangeListener.changeBuyerMaker(null);
          newtimes.shipping_admin.ShippingAdmin_Const.CurrentWorkingCenterCode=centerCode;

        }
      }catch(Exception exp){
        exp.printStackTrace();
      }
    }
  }
  public void activate()throws Exception{
    doingDB2Gui=true;
    //use the ejb interface to generate the combobox for query.
    javax.swing.JFrame jframe=processhandler.template.Properties.getMainFrame();
    java.awt.Cursor ksr=jframe.getContentPane().getCursor();
    //and d.cen_code='001'
    //and e.dep_code='TPJ05'


    try{
      jframe.getContentPane().setCursor(new java.awt.Cursor(java.awt.Cursor.WAIT_CURSOR));
    guis.clear();
    if(tempProperties.tmpCenters.size()>1){
      DbJcbxcbxCntr =
          new exgui.DataBindJCombobox(
          cbxCenter,"d.CEN_CODE",
          tempProperties.tmpCenters,
          "CEN_NAME", "CEN_CODE",
          util.PublicVariable.USER_RECORD.get("usr_cen_code"));
      guis.add(DbJcbxcbxCntr);
    }else{
      DbJcbxcbxCntr =
          new exgui.DataBindJCombobox(
          cbxCenter, "d.CEN_CODE",
          tempProperties.tmpCenters,
          "CEN_NAME", "CEN_CODE",
          util.PublicVariable.USER_RECORD.get("usr_cen_code"));
      guis.add(DbJcbxcbxCntr);
    }
    depCbxDBGUI_index=guis.size();
    //occupy a position for cmobobox dep
    guis.add(new Vector());
    guis.add(slkBuyer);
    guis.add(slkMaker);
    Object objDate=exgui.verification.CellFormat.getDateStringFormaterAllowNull();
    //default year is from system_default_value.
    //System.out.println("system default value is:"+recSysValue.toString());
    dbTxtEtdFrom=new  exgui.DataBindTextWithChecker(
              txtETDfrom,"a.SHIP_ETD_DATE>",
              null,10,
              (exgui.Object2String)objDate,
              (exgui.ultratable.CellTxtEditorFormat)objDate);
    guis.add(dbTxtEtdFrom);
    dbTxtEtdTo=new  exgui.DataBindTextWithChecker(
              txtEDTto,"a.SHIP_ETD_DATE<",
              null,10,
              (exgui.Object2String)objDate,
              (exgui.ultratable.CellTxtEditorFormat)objDate);
    guis.add(dbTxtEtdTo);
    Object objCnv12=exgui.verification.CellFormat.getOrdinaryField(12);
    dbTxtSRN=new  exgui.DataBindTextWithChecker(
              txtSrnNo,"a.SHIP_NO",
              null,13,
              (exgui.Object2String)objCnv12,
              (exgui.ultratable.CellTxtEditorFormat)objCnv12);
    guis.add(dbTxtSRN);

    Object obj50CharVarify=exgui.verification.CellFormat.getOrdinaryField(50);
    dbTxtCustPo=new  exgui.DataBindTextWithChecker(
              txtCustPo,"CUST_PO",
              null,50,
              (exgui.Object2String)obj50CharVarify,
              (exgui.ultratable.CellTxtEditorFormat)obj50CharVarify);
    guis.add(dbTxtCustPo);

    dbTxtStyleStyle=new  exgui.DataBindTextWithChecker(
              txtStyleStyle,"STYLE_STYLE",
              null,50,
              (exgui.Object2String)obj50CharVarify,
              (exgui.ultratable.CellTxtEditorFormat)obj50CharVarify);
    guis.add(dbTxtStyleStyle);
    indexDiv=guis.size();
    dbCbxdiv=new exgui.DataBindJCombobox(
        cbxDiv,
        "PROD_BUYER_DIVISION",
        new Vector(),
        "DIV_NAME","DIV_CODE",
        null,"N/A",null);
    slkBuyer.setModifyNotifyTo(buyerChangeListener);
    guis.add(dbCbxdiv);

    doingDB2Gui=false;
    cbxCenter.getItemListeners()[0].itemStateChanged(null);

  }catch(Exception e){
    //e.printStackTrace();
    throw e;
  }finally{
    jframe.getContentPane().setCursor(ksr);
  }
 }


  void setAuth() {
    try {
      if (usrType.equals("3") || usrType.equals("4") || usrType.equals("5")) {
        butnAdd.setEnabled(false);
      } else {
//        butnModify.setEnabled(false);
      }
    } catch (Exception eBsc) {
      eBsc.printStackTrace();
      util.ExceptionLog.exp2File(eBsc,"error at check authorization.\nuser type:"+usrType);
    }
  }

  void btnExit_actionPerformed(ActionEvent e) {
    newtimes.Frame1 frame=
        (newtimes.Frame1)processhandler.template.Properties.getMainFrame();
    setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
    //frame.showPanel(new newtimes.shipping_admin.PnlShippingFunctions(frame));
    frame.showPanel(new newtimes.shipping.ShippingMenu(frame));
    setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
  }

  void butnModify_actionPerformed(ActionEvent e) {
    newtimes.shipping_admin.guis.shippingmaintain.PnlListShipMasters.PAGE_BEGIN=0;
    newtimes.shipping_admin.guis.shippingmaintain.PnlList4SiEdit.PAGE_BEGIN=0;
    newtimes.shipping_admin.process.shiippingmaintain.ToDirectListShipStyles.PAGE_BEGIN=0;
    newtimes.shipping_admin.process.shiippingmaintain.ToListAddedStyles.PAGE_BEGIN=0;
    util.ApplicationProperites.setProperties(
      "newtimes.shipping_admin.process.shiippingmaintain.ToListAddedStyles$InnerPnlListAddedStyles_TOP_RECORD_AT",
     new Integer(1));

   util.ApplicationProperites.setProperties(
     "newtimes.shipping_admin.guis.shippingmaintain.PnlListShipMasters_TOP_RECORD_AT",
    new Integer(1));

    //compose to query hashmap.
    //test if s/c column is valid if inputed
    boolean withBuyerMaker=false;
    java.util.HashMap hm=new java.util.HashMap();
    if(txtSCno.getText().trim().length()>0){
      String inputSc=txtSCno.getText().trim().toUpperCase();
      /* none-tpe center 's S/C is not match is rule
      if(inputSc.length()<12||(!inputSc.startsWith("S"))){
        exgui.verification.VerifyLib.showAlert("S/C No Format Error","S/C No Format Error");
        txtSCno.grabFocus();
        return;
      }*/
      if(!(util.PublicVariable.OPERATTING_CENTER.equals("001")||util.PublicVariable.OPERATTING_CENTER.equals("NTHK"))
         && inputSc.length()==7){
        //for other center's PO,have to complelte with center prifix code in sc head
        String centerPrefix=newtimes.shipping_admin.ShippingAdmin_Const.getCenterPrefix(util.PublicVariable.OPERATTING_CENTER);
        inputSc=centerPrefix+inputSc;
      }
      hm.put("prod_sc_no",inputSc);
    }
    for(int i=0;i<guis.size();i++){
      Object  dbswing=guis.get(i);
      if(((exgui.SwingSingleSelection)dbswing).getSelectedValue()!=null){
        //if date,have to convert to date object base on 24:59:59 0:0:0
        String keyField=((exgui.DataBindGUIObject)dbswing).getOrgRecField();
        if(keyField.equalsIgnoreCase("a.SHIP_ETD_DATE>")){
          String dateDgt[]=util.MiscFunc.split(txtETDfrom.getText(),"/");
          java.util.Date bgnDate=
              util.MiscFunc.toDate000000(
            Integer.parseInt(dateDgt[0]),Integer.parseInt(dateDgt[1]),Integer.parseInt(dateDgt[2]));
          hm.put(keyField,new java.sql.Date(bgnDate.getTime()));
          continue;
        }
        if(keyField.equalsIgnoreCase("a.SHIP_ETD_DATE<")){
          String dateDgt[]=util.MiscFunc.split(txtEDTto.getText(),"/");
          java.util.Date endDate=
              util.MiscFunc.toDate235959(
            Integer.parseInt(dateDgt[0]),Integer.parseInt(dateDgt[1]),Integer.parseInt(dateDgt[2]));
          hm.put(keyField,new java.sql.Date(endDate.getTime()));
          continue;
        }
        //if(keyField.toLowerCase().indexOf("prod_buyer")!=-1) withBuyerMaker=true;
        //if(keyField.toLowerCase().indexOf("prod_maker")!=-1) withBuyerMaker=true;
        hm.put(keyField,((exgui.SwingSingleSelection)dbswing).getSelectedValue());
      }
    }
    if(rdoListBySC.isSelected()){
      hm.put("LIST_BY_SC",new Boolean(true));
      PnlListQryAddedStyles.START_ROW_POSITION=0;
      newtimes.shipping_admin.ShippingAdmin_Const.CURRENT_EDITING_SHIP_SRN=null;
    }else{
      hm.put("LIST_BY_SC",new Boolean(false));
    }
    hm.put("LIST_BY_BUYER_MAKER",new Boolean(true));
    withBuyerMaker=true;
    if(rdoListBySRN.isSelected()){
       hm.put("LIST_BY_SRN",new Boolean(true));
    }else{
       hm.put("LIST_BY_SRN",new Boolean(false));
    }




    PnlListShipMasters.listWithBuyerMaker=withBuyerMaker;
    if("NTD".equals(util.PublicVariable.OPERATTING_CENTER)){
      if(newtimes.shipping_admin.ShippingAdmin_Const.IS_LORAN_MODE){
        hm.put("IS_LAUREN_MODE","IS_LAUREN_MODE");
      }else{
        hm.put("IS_NOT_LAUREN_MODE","IS_NOT_LAUREN_MODE");
      }
    }
    newtimes.shipping_admin.ShippingAdmin_Const.SHIP_MASTER_QRY_CONDITION=hm;
    try {
      if(rdoListBySC.isSelected()){

        processhandler.template.Properties.getCenteralControler().
            doCommandExecute(
            new newtimes.shipping_admin.process.shiippingmaintain.TgrToDirectListShipStyles());

      }else if(rdoListBySRN.isSelected()){
        processhandler.template.Properties.getCenteralControler().
            doCommandExecute(
            new newtimes.shipping_admin.process.shiippingmaintain.
            TgrToListShippingMaster());

      }else{
        processhandler.template.Properties.getCenteralControler().
            doCommandExecute(
            new newtimes.shipping_admin.process.shiippingmaintain.TgrToListToEditSI());

      }
    } catch (Exception exp) {
      exp.printStackTrace();
      util.ExceptionLog.exp2File(exp, "error while query SRN");
      exgui.verification.VerifyLib.showAlert(
          "Server Side Connection Fail\nPlease Contact System Manager",
          "REMOTE METHOD ERROR");
    }
  }
  void butnAdd_actionPerformed_NTFE(ActionEvent e) {
    newtimes.shipping_admin.process.shiippingmaintain.DB_ShipMaster dbHandler=
        newtimes.shipping_admin.ShippingAdmin_Const.DB_SHIP_SRN_HEAD_HANDLER;

    try{
      //util.PublicVariable.APP_FRAME.setCursor(new java.awt.Cursor(java.awt.Cursor.WAIT_CURSOR));
      newtimes.production.ProdMaintain_Properties.setWaitCursor();
      String xntSCNO=txtSC_no.getText().trim();
      if(xntSCNO.length()<4){
        exgui.verification.VerifyLib.showPlanMsg(
           "S/C No. Format Error",
           "S/C No. Format Error");
         return;
      }
    int orgProdHeadPk=dbHandler.hasSuchSC(xntSCNO);
     boolean isHasThisSc=(orgProdHeadPk!=0);
     if(!isHasThisSc){
       exgui.verification.VerifyLib.showPlanMsg(
          "No Such S/C No.",
          "No Such S/C No.");
        return;
     }else{
       database.datatype.Record prod_rec= newtimes.preproduction.process.DB_Preprod.getInstance().findbyPk(orgProdHeadPk);
       //for offshore user,need to compare offshore center match or not.
       if(util.PublicVariable.USER_RECORD.getInt(2)==newtimesejb.preproduction.PreProductionHead.USER_TYPE_ABROAD_USERS){
         String xntOffShoreCenterCode = newtimes.shipping_admin.ShippingAdmin_Const.OFFSHORE_CENTER;
         String offShore = (String)prod_rec.get("PROD_OFFSHORE_CENTER");
         if (!xntOffShoreCenterCode.equals(offShore)) {
           exgui.verification.VerifyLib.showAlert(
               "Offshore Center Miss-Match!!", "Offshore Miss-Match");
           return;
         }
       }


       xntSCNO=(String)prod_rec.get("prod_sc_no");
       /*
       //for NONE-TPE & NONE-NTHK center,if po is cont confirmed/shipped,not allow to add to shipping
       String centerCode=(String)util.PublicVariable.OPERATTING_CENTER;


       if(!(centerCode.equals("NTHK")||centerCode.equals("001")||centerCode.equals("NTFE"))){
         String prod_status_code=
             (String)prod_rec.get("PRODUCTION_AUDIT_STATUS");
         if(!(prod_status_code.equals("3")||prod_status_code.equals("7"))){
           exgui.verification.VerifyLib.showAlert("Production Is not Approved!!",
                                                  "Production Is not Approved");
           return;
         }
       }*/
         //prepare maker data.
         StringBuffer sb=new StringBuffer();
         sb.append("select BYMKR_BRIEF, BYMKR_NAME, BYMKR_ADDR1, BYMKR_ADDR2, BYMKR_ADDR3, BYMKR_ADDR4, BYMKR_TEL1, BYMKR_TEL2, BYMKR_HK_CODE ");
         sb.append(" from buyer_maker where BYMKR_SEQ in ");
         sb.append("(select prod_maker from prod_head where prod_head_pk in");
         sb.append(" (select prod_head_pk from production where prod_sc_no='");
         sb.append(xntSCNO);
         sb.append("' or prod_sc_no='");
         String centerPrefix=newtimes.shipping_admin.ShippingAdmin_Const.getCenterPrefix((String)DbJcbxcbxCntr.getSelectedValue());
         sb.append(centerPrefix+xntSCNO);
         sb.append("') and record_delete_flag='1' ) and rownum=1");
         Vector vctTest=exgui2.CONST.BASIC_MAIN_EJB.getDatas(
          util.PublicVariable.USER_RECORD,
          sb.toString(),1,9999);
            boolean hasMaker=false;
         StringBuffer sbMakerStr=new StringBuffer();
         if(vctTest.size()>0){
           hasMaker=true;
           database.datatype.Record makerDataRec=(database.datatype.Record)vctTest.get(0);
           sbMakerStr.append((String)makerDataRec.get(1));sbMakerStr.append("\n");
           /*
           String tel1=((makerDataRec.get(6)==null || makerDataRec.get(6).toString().equals("null"))?"":(String)makerDataRec.get(6));
           String tel2=((makerDataRec.get(7)==null || makerDataRec.get(7).toString().equals("null"))?"":(String)makerDataRec.get(7));
           sbMakerStr.append("TEL:"+tel1);
               if(tel1.trim().length()>0 && tel2.trim().length()>0){
                 sbMakerStr.append(",");
                 sbMakerStr.append(tel2);
               }
               sbMakerStr.append("\n");
           */
          StringBuffer sbAddress=new StringBuffer();
          for(int i=2;i<6;i++){
            if(sbAddress.length()>0)sbAddress.append("\n");
            String addTemp=((makerDataRec.get(i)==null || makerDataRec.get(i).toString().equals("null"))?"":(String)makerDataRec.get(i));
            sbAddress.append(addTemp);
          }
          //sbMakerStr.append("ADD:");
          sbMakerStr.append(sbAddress.toString());
         }

         /*
         for(int i=0;i<vctTest.size();i++){
           database.datatype.Record rec=(database.datatype.Record)vctTest.get(i);
           if(rec.get(0)!=null)hasMaker=true;
         }*/

         if(!hasMaker){
           exgui.verification.VerifyLib.showAlert("No Maker Assigned For This PO\nPlease Assign Maker Before Shipping",
                                                  "Please Assign Maker Before Shipping");
           return;
         }


       database.datatype.Record rec= dbHandler.getBlankRecord();


       rec.set("SHIP_NO",xntSCNO);//user the sc no temprarily.after ejb insert,the "Ship_no" will be replaced by SRN No.
       //set default value by co-responding production head data.
       //Agent is production's branch
       //Priceter is from production's price term
       //Destination is from S/C 's *port
       //Port is S/C's Destination
       java.sql.Date nowDate=new java.sql.Date(System.currentTimeMillis());
       rec.set("SHIP_DATE",nowDate);
       rec.set("SHIP_ic_date",nowDate);
       rec.set("ship_agent",prod_rec.get("production_brnch_brief"));
       rec.set("ship_prc_trm",prod_rec.get("production_sc_prc_trm"));
       rec.set("ship_dest",prod_rec.get("production_sc_dest"));
       rec.set("ship_prx_term_dest",prod_rec.get("production_sc_dest"));
       rec.set("ship_ntfe_dest",prod_rec.get("production_tgt_dest"));
       rec.set("ship_USA_port",prod_rec.get("production_tgt_dest"));
       rec.set("ship_ic_div",prod_rec.get("prod_buyer_division"));
       rec.set("ship_ic_sea",prod_rec.get("prod_season"));
       rec.set("ship_ic_year",prod_rec.get("prod_year"));
       //<<---20070111,for some salse have transfer department,ship head have to preserver dep to change in future
       rec.set("ship_dep",prod_rec.get("prod_deptment"));
       //-------------------------------------------------------
       rec.set("SHIP_PAYMENT_TERM",prod_rec.get("PRODUCTION_PYT_TRM"));

       //---------shipping mark is composed by production 's sc-head-remark & end-remark--------
       StringBuffer strGetRemarks=new StringBuffer();
       int prodHeadPk=prod_rec.getInt(0);
       strGetRemarks.append("select ");
       strGetRemarks.append("prod_sc_head_rmrk,prod_sc_end_rmrk, ");
       strGetRemarks.append("(select PROD_CT_INFOR.PROD_CT_PYT_TRM from prod_ct_infor  ");
       strGetRemarks.append("where prod_ct_infor.prod_head_pk=production.prod_head_pk) as  CT_PAYMENT_TERm  ");
       strGetRemarks.append("from production where prod_head_pk= ");
       strGetRemarks.append(String.valueOf(prodHeadPk));

       database.datatype.Record recProduction=
           (database.datatype.Record)exgui2.CONST.BASIC_MAIN_EJB.getDatas(
               util.PublicVariable.USER_RECORD,strGetRemarks.toString(),1,1).get(0);
       Object objProdHeadRemark=recProduction.get("prod_sc_head_rmrk");
       String poHeadRemark=(objProdHeadRemark==null?"":objProdHeadRemark.toString().trim());
       Object objProdEndRemark=recProduction.get("prod_sc_end_rmrk");
       String poEndRemark=(objProdEndRemark==null?"":objProdEndRemark.toString().trim());
       String shipRemark=poHeadRemark+"\n"+poEndRemark;
       rec.set("SHIP_SHIPPING_RMK",shipRemark.substring(0,
               (shipRemark.length()>4000?4000:shipRemark.length())) );
       //------------------------------------------------------------------------------------------

       //rec.set("ship_bill_to",prod_rec.get("prod_buyer"));
       //rec.set("ship_ship_to",prod_rec.get("prod_buyer"));
       System.out.println("manufacture data is "+sbMakerStr.toString());
       rec.set("SHIP_MANUFACTURE",sbMakerStr.toString().substring(0,
           (sbMakerStr.toString().length()>1000)?1000:sbMakerStr.toString().length()));
       rec.set("PRICE_TYPE",recProduction.get(2));
       //if there is ASN data,have to bring it from database too.
       if(newtimes.shipping_admin.ShippingAdmin_Const.IS_LORAN_MODE &&
          newtimes.shipping_admin.ShippingAdmin_Const.INIT_ASN_CODE!=null){
         rec.set("SHIP_DATE",null);
         rec.set("ship_prx_term_dest",null);//20090220,null by ERIC-lauren user
         database.datatype.Record recAsn=(database.datatype.Record)exgui2.CONST.BASIC_MAIN_EJB.getDatas(
           util.PublicVariable.USER_RECORD,
          "select * from ASN_UPLOAD where ASN_NO='"+newtimes.shipping_admin.ShippingAdmin_Const.INIT_ASN_CODE+"'"
          ,1,99999).get(0);
         rec.set("SHIP_FTY_INV",recAsn.get("VENDORINV_NO"));
         /*
          20090220,null by ERIC-lauren user
         Object objBolNo=recAsn.get("BOL_NO");
         if(objBolNo!=null && objBolNo.toString().trim().length()>0){
           rec.set("SHIP_HAWB",recAsn.get("BOL_NO"));
         }else{
           rec.set("SHIP_HAWB",recAsn.get("AWB_NO"));
         }
         rec.set("SHIP_MAWB",recAsn.get("MBL_NO"));
         */
         rec.set("SHIP_OCEAN_AIR",recAsn.get("SHIPMODE_CD"));
         /*
         //20090220,null by ERIC-lauren user
         rec.set("SHIP_ETD_DATE",recAsn.get("ETD_DATE"));
         rec.set("SHIP_ETA_DATE",recAsn.get("ETA_DATE"));
         rec.set("SHIP_VESSEL",recAsn.get("VESSELNAME"));
         rec.set("SHIP_FLT_NO",recAsn.get("VOYAGENO"));
         */
         rec.set("SHIP_NTFE_DEST",null);//"destination" gui field
         rec.set("SHIP_USA_PORT",recAsn.get("DISCHARGE_PORT"));//port of discharge
         rec.set("SHIP_DEST",recAsn.get("ENTRY_PORT"));//loading port


         rec.set("SHIP_CNTY_ORIG",prod_rec.get("PRODUCTION_QC_CNTY"));
         rec.set("PRICE_TYPE",".");
         rec.set("SHIP_DIM_CUFT","ASN:"+newtimes.shipping_admin.ShippingAdmin_Const.INIT_ASN_CODE);
         rec.set("SHIP_SHIPPING_RMK","");//clear shipping mark
       }
       newtimes.shipping_admin.ShippingAdmin_Const.SHIPPING_EDITING_HEAD_RECORD=rec;
       try{
         processhandler.template.Properties.getCenteralControler().doCommandExecute(
         new newtimes.shipping_admin.process.shiippingmaintain.TgrToAddShipMaster());
       }catch(Exception ie){
         ie.printStackTrace();
         return;
       }
     }
    }catch(Exception exp){
      exp.printStackTrace();
      util.ExceptionLog.exp2File(exp,"error while query SRN");
      exgui.verification.VerifyLib.showAlert("Server Side Connection Fail\nPlease Contact System Manager",
                                             "REMOTE METHOD ERROR");
    }finally{
      //util.PublicVariable.APP_FRAME.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
      newtimes.production.ProdMaintain_Properties.setNormalCursor();
    }

  }
  void butnAdd_actionPerformed(ActionEvent e) {
    if(!(util.PublicVariable.OPERATTING_CENTER.equals("001")||
         util.PublicVariable.OPERATTING_CENTER.equals("NTHK"))){
      butnAdd_actionPerformed_NTFE(e);
      return;
    }
    newtimes.shipping_admin.process.shiippingmaintain.DB_ShipMaster dbHandler=
        newtimes.shipping_admin.ShippingAdmin_Const.DB_SHIP_SRN_HEAD_HANDLER;
    try{
      //util.PublicVariable.APP_FRAME.setCursor(new java.awt.Cursor(java.awt.Cursor.WAIT_CURSOR));
      newtimes.production.ProdMaintain_Properties.setWaitCursor();
      String xntSCNO=txtSC_no.getText().trim();
      if(xntSCNO.length()<4){
        exgui.verification.VerifyLib.showPlanMsg(
           "S/C No. Format Error",
           "S/C No. Format Error");
         return;
      }
    int orgProdHeadPk=dbHandler.hasSuchSC(xntSCNO);
     boolean isHasThisSc=(orgProdHeadPk!=0);
     if(!isHasThisSc){
       exgui.verification.VerifyLib.showPlanMsg(
          "No Such S/C No.",
          "No Such S/C No.");
        return;
     }else{
       //for NONE-TPE & NONE-NTHK center,if po is cont confirmed/shipped,not allow to add to shipping
       database.datatype.Record prod_rec= newtimes.preproduction.process.DB_Preprod.getInstance().findbyPk(orgProdHeadPk);
       if(util.PublicVariable.USER_RECORD.getInt(2)==newtimesejb.preproduction.PreProductionHead.USER_TYPE_ABROAD_USERS){
         String xntOffShoreCenterCode = newtimes.shipping_admin.ShippingAdmin_Const.OFFSHORE_CENTER;
         String offShore = (String)prod_rec.get("PROD_OFFSHORE_CENTER");
         if (!xntOffShoreCenterCode.equals(offShore)) {
           exgui.verification.VerifyLib.showAlert(
               "Offshore Center Miss-Match!!", "Offshore Miss-Match");
           return;
         }
       }

      /*
       if(!(centerCode.equals("NTHK")||centerCode.equals("001")||centerCode.equals("NTFE"))){
         String prod_status_code=
             (String)prod_rec.get("PRODUCTION_AUDIT_STATUS");
         if(!(prod_status_code.equals("3")||prod_status_code.equals("7"))){
           exgui.verification.VerifyLib.showAlert("Production Is not Approved!!",
                                                  "Production Is not Approved");
           return;
         }
       }*/

       //for NTHK center,check if no maker for this production,stop it.
       if(util.PublicVariable.OPERATTING_CENTER.equals("NTHK")){
         StringBuffer sb=new StringBuffer();
         sb.append("select prod_maker from prod_head where prod_head_pk in");
         sb.append(" (select prod_head_pk from production where prod_sc_no='");
         sb.append(xntSCNO);
         sb.append("') and record_delete_flag='1'  order by prod_maker");
         Vector vctTest=exgui2.CONST.BASIC_MAIN_EJB.getDatas(
          util.PublicVariable.USER_RECORD,
          sb.toString(),1,9999);
            boolean hasMaker=false;
         for(int i=0;i<vctTest.size();i++){
           database.datatype.Record rec=(database.datatype.Record)vctTest.get(i);
           if(rec.get(0)!=null)hasMaker=true;
         }
         if(!hasMaker){
           exgui.verification.VerifyLib.showAlert("No Maker Assigned For This PO\nPlease Assign Maker Before Shipping",
                                                  "Please Assign Maker Before Shipping");
           return;
         }
       }


       database.datatype.Record rec= dbHandler.getBlankRecord();


       rec.set("SHIP_NO",xntSCNO);//user the sc no temprarily.after ejb insert,the "Ship_no" will be replaced by SRN No.
       //set default value by co-responding production head data.
       //Agent is production's branch
       //Priceter is from production's price term
       //Destination is from S/C 's *port
       //Port is S/C's Destination
       java.sql.Date nowDate=new java.sql.Date(System.currentTimeMillis());
       rec.set("SHIP_DATE",nowDate);
       rec.set("SHIP_ic_date",nowDate);
       rec.set("ship_agent",prod_rec.get("production_brnch_brief"));
       rec.set("ship_prc_trm",prod_rec.get("production_sc_prc_trm"));
       rec.set("ship_dest",prod_rec.get("production_sc_dest"));
       rec.set("ship_USA_port",prod_rec.get("production_tgt_dest"));
       rec.set("ship_ic_div",prod_rec.get("prod_buyer_division"));
       rec.set("ship_ic_sea",prod_rec.get("prod_season"));
       rec.set("ship_bill_to",prod_rec.get("prod_buyer"));
       rec.set("ship_ship_to",prod_rec.get("prod_buyer"));
       //<<---20070111,for some salse have transfer department,ship head have to preserver dep to change in future
       rec.set("ship_dep",prod_rec.get("prod_deptment"));
       //-------------------------------------------------------

       if("001".equals(util.PublicVariable.OPERATTING_CENTER)){
         rec.set(PnlShipMaster.COLUMN_INDEX_SHIP_PAYMENT_TERM,
                 prod_rec.get("PRODuction_PYT_TRM"));
       }

       newtimes.shipping_admin.ShippingAdmin_Const.SHIPPING_EDITING_HEAD_RECORD=rec;
       try{
         processhandler.template.Properties.getCenteralControler().doCommandExecute(
         new newtimes.shipping_admin.process.shiippingmaintain.TgrToAddShipMaster());
       }catch(Exception ie){
         ie.printStackTrace();
         return;
       }
     }
    }catch(Exception exp){
      exp.printStackTrace();
      util.ExceptionLog.exp2File(exp,"error while query SRN");
      exgui.verification.VerifyLib.showAlert("Server Side Connection Fail\nPlease Contact System Manager",
                                             "REMOTE METHOD ERROR");
    }finally{
      //util.PublicVariable.APP_FRAME.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
      newtimes.production.ProdMaintain_Properties.setNormalCursor();
    }
  }
  class ChainedDialogBoxChuzPo extends exgui.chaindialog.ChainedDialogBox{
    ChainedDialogBoxChuzPo(exgui.chaindialog.Responsible next){
      super(util.PublicVariable.APP_FRAME,
         "Select PO By Cust-PO",true,
         next);

    }
    public Object getDialogResult(){
      if(resultHashMap==null)return null;
      return resultHashMap.get("SC_NO");
    }
  }
  void findEdiPoByCustPO(){
    newtimes.shipping_admin.ShippingAdmin_Const.INIT_ASN_CODE=null;
    ChainDlgPoNoFtyInv chCustNo=new ChainDlgPoNoFtyInv();
    ChainDlgPoNoFtyInvListPo chCustList=new ChainDlgPoNoFtyInvListPo();
    chCustNo.setDefalutNext(chCustList);
    ChainedDialogBoxChuzPo dlg=
        new ChainedDialogBoxChuzPo(chCustNo);
    dlg.setSize(800,275);
    exgui.UIHelper.setToScreenCenter(dlg);
    dlg.show();
    if(dlg.getDialogResult()!=null){
      txtSC_no.setText(dlg.getDialogResult().toString());
      butnAdd_actionPerformed_NTFE(null);
    }
  }


  void findPoByCustPO(){
    ChainDlgCustNo chCustNo=new ChainDlgCustNo();
    ChainDlgCustNoListPo chCustList=new ChainDlgCustNoListPo();
    chCustNo.setDefalutNext(chCustList);
    ChainedDialogBoxChuzPo dlg=
        new ChainedDialogBoxChuzPo(chCustNo);
    dlg.setSize(500,275);
    exgui.UIHelper.setToScreenCenter(dlg);
    dlg.show();
    if(dlg.getDialogResult()!=null){
      txtSC_no.setText(dlg.getDialogResult().toString());
    }
  }
  void btnAddDummySRN_actionPerformed(ActionEvent e) {
    try{
      if(!util.PublicVariable.OPERATTING_CENTER.equals("001")){
        if(newtimes.shipping_admin.ShippingAdmin_Const.IS_LORAN_MODE){
          findEdiPoByCustPO();
          return;
        }
        findPoByCustPO();
        return;
      }
      /*
      newtimes.production.ProdMaintain_Properties.setWaitCursor();
      if (vct2dummySRN_SC == null) {
        StringBuffer sb = new StringBuffer();
        sb.append(
            "select to_char(prod_head_pk) as prod_key,dep.dep_prefix,dep.dep_name,pdxn.prod_sc_no ");
        sb.append("from department dep,production pdxn  ");
        sb.append("where dep_cen_code='001' ");
        sb.append("and pdxn.prod_sc_no = ( select prod_sc_no from production where substr(prod_sc_no,5,2)=dep.dep_prefix and rownum=1) ");
        sb.append("and substr(pdxn.prod_sc_no,5,2)=dep.dep_prefix  ");
        sb.append("and pdxn.prod_sc_no is not null ");
        sb.append("and pdxn.record_delete_flag='1' ");
        sb.append("order by dep_name ");
        vct2dummySRN_SC = exgui2.CONST.BASIC_MAIN_EJB.getDatas(
            util.PublicVariable.USER_RECORD, sb.toString(), 1, 99999);

       pnl2QryDepSc4Dummy=new   Pnl2ListDepForDummySRN();
        Object firstStr=((database.datatype.Record)vct2dummySRN_SC.get(0)).get(0);
        dbCbxDepWithScWithPk  =
            new exgui.DataBindJCombobox(
            pnl2QryDepSc4Dummy.cbxDep,
            "",vct2dummySRN_SC,"dep_name", "prod_key",firstStr);

      }
      //show the panel to request initial pk and sc.
      int result=JOptionPane.showOptionDialog(
          util.PublicVariable.APP_FRAME,
          pnl2QryDepSc4Dummy,
          "Please Department",
          JOptionPane.OK_CANCEL_OPTION,
          JOptionPane.INFORMATION_MESSAGE,
          null,
          new String[] {"OK","CANCEL"},"OK");

     if(result==JOptionPane.OK_OPTION){
       database.datatype.Record recOrgSc=
           (database.datatype.Record)vct2dummySRN_SC.get(pnl2QryDepSc4Dummy.cbxDep.getSelectedIndex());
       */
       //System.out.println("OK CLICKED,value is:"+recOrgSc.toString());
       DlgQryScByDepBuyerMaker dlg=new DlgQryScByDepBuyerMaker(util.PublicVariable.APP_FRAME,"QUERY S/C By Buer/Maker/Dep.",true);
       dlg.setSize(500,350);
       exgui.UIHelper.setToScreenCenter(dlg);
       dlg.show();
       if(dlg.finalSc!=null){
       newtimes.shipping_admin.process.shiippingmaintain.DB_ShipMaster dbHandler=
           newtimes.shipping_admin.ShippingAdmin_Const.DB_SHIP_SRN_HEAD_HANDLER;



       database.datatype.Record rec= dbHandler.getBlankRecord();
       /*
       database.datatype.Record prod_rec=
           newtimes.preproduction.process.DB_Preprod.getInstance().findbyPk(
            Integer.parseInt(dbCbxDepWithScWithPk.getSelectedValue().toString())
           );*/

       database.datatype.Record prod_rec=
           newtimes.preproduction.process.DB_Preprod.getInstance().findbyPk(dlg.finalProdHeadPk);

       if(util.PublicVariable.USER_RECORD.getInt(2)==newtimesejb.preproduction.PreProductionHead.USER_TYPE_ABROAD_USERS){
         String xntOffShoreCenterCode = newtimes.shipping_admin.ShippingAdmin_Const.OFFSHORE_CENTER;
         String offShore = (String)prod_rec.get("PROD_OFFSHORE_CENTER");
         if (!xntOffShoreCenterCode.equals(offShore)) {
           exgui.verification.VerifyLib.showAlert(
               "Offshore Center Miss-Match!!", "Offshore Miss-Match");
           return;
         }
       }


       //rec.set("SHIP_NO",recOrgSc.get("prod_sc_no"));//user the sc no temprarily.after ejb insert,the "Ship_no" will be replaced by SRN No.
       rec.set("SHIP_NO",dlg.finalSc);//user the sc no temprarily.after ejb insert,the "Ship_no" will be replaced by SRN No.
       //set default value by co-responding production head data.
       //Agent is production's branch
       //Priceter is from production's price term
       //Destination is from S/C 's *port
       //Port is S/C's Destination
       java.sql.Date nowDate=new java.sql.Date(System.currentTimeMillis());
       rec.set("SHIP_DATE",nowDate);
       rec.set("SHIP_ic_date",nowDate);
       //---20070111,preserver ship dep for sales shift dep,but inv devide
       rec.set("ship_dep",prod_rec.get("prod_deptment"));
       //----------------------------------------------------------
       rec.set(PnlShipMaster.COLUMN_INDEX_ship_agent,null);
       rec.set(PnlShipMaster.COLUMN_INDEX_ship_prc_trm,null);
       rec.set(PnlShipMaster.COLUMN_INDEX_ship_prx_term_dest,null);
       if("001".equals(util.PublicVariable.OPERATTING_CENTER)){
         rec.set(PnlShipMaster.COLUMN_INDEX_SHIP_PAYMENT_TERM,
                 prod_rec.get("PRODUCTION_PYT_TRM"));
       }else{
         rec.set(PnlShipMaster.COLUMN_INDEX_SHIP_PAYMENT_TERM, "-1");
       }

       rec.set(PnlShipMaster.COLUMN_INDEX_ship_dest,null);
       rec.set(PnlShipMaster.COLUMN_INDEX_ship_USA_port,null);
       rec.set(PnlShipMaster.COLUMN_INDEX_ship_ic_div,null);
       rec.set(PnlShipMaster.COLUMN_INDEX_ship_ic_sea,null);
       rec.set(PnlShipMaster.COLUMN_INDEX_ship_bill_to,null);
       rec.set(PnlShipMaster.COLUMN_INDEX_ship_ship_to,null);
       /*
       rec.set("ship_agent",prod_rec.get("production_brnch_brief"));
       rec.set("ship_prc_trm",prod_rec.get("production_sc_prc_trm"));
       rec.set("ship_dest",prod_rec.get("production_sc_dest"));
       rec.set("ship_USA_port",prod_rec.get("production_tgt_dest"));
       rec.set("ship_ic_div",prod_rec.get("prod_buyer_division"));
       rec.set("ship_ic_sea",prod_rec.get("prod_season"));
       rec.set("ship_bill_to",prod_rec.get("prod_buyer"));
       rec.set("ship_ship_to",prod_rec.get("prod_buyer"));*/

       newtimes.shipping_admin.ShippingAdmin_Const.SHIPPING_EDITING_HEAD_RECORD=rec;

       processhandler.template.Properties.getCenteralControler().doCommandExecute(
       new newtimes.shipping_admin.process.shiippingmaintain.TgrToAddShipMaster());

     }else{
       return;
     }





    }catch(Exception exp){
      exp.printStackTrace();
      util.ExceptionLog.exp2File(exp,"");
      exgui.verification.VerifyLib.showAlert("Server Size Error\nPlease Contact System Manager",
                                             "Connection Or Server Side Error");
    }finally{
      //util.PublicVariable.APP_FRAME.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR ));
      newtimes.production.ProdMaintain_Properties.setNormalCursor();
    }

  }
 static class Pnl2ListDepForDummySRN extends JPanel {
    JComboBox cbxDep=new JComboBox();
     public Pnl2ListDepForDummySRN() {
         super( new BorderLayout(0, 5) );
         add( new JLabel("Please Select Department"), BorderLayout.NORTH );
         JPanel subPanel = new JPanel();
         subPanel.add( cbxDep );
         add( subPanel, BorderLayout.CENTER );
     }

 }
}
