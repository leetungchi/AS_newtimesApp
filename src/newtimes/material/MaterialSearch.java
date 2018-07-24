package newtimes.material;

import java.awt.*;
import newtimes.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.Vector;
import java.util.HashMap;
//import java.util.*;
import java.util.regex.Pattern;
import database.datatype.Record;
import util.PublicVariable;
import exgui2.*;
import newtimes.preproduction.buyermakerselect.*;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author unascribed
 * @version 1.0
 */

public class MaterialSearch extends JPanel {
  static Object defCen = null;
  //Constants String
  private final newtimes.material.CONST.MTR.EJB MTR_EJB = null;
  private final newtimes.material.CONST.DIV.EJB DIV_EJB = null;
  private final newtimes.material.CONST.CEN.EJB CEN_EJB = null;
  private final newtimes.material.CONST.CNTY.EJB CNTY_EJB = null;
  private final newtimes.material.CONST.BYMK.EJB BYMK_EJB = null;
  private final newtimes.material.CONST.MTR.APP.SEARCH MTR_SEARCH = null;
  private static final String USR_CEN_CODE = "USR_CEN_CODE";
  private int SearchType=MTR_SEARCH.UNKNOWN;

  //Object variables
  Frame1 frame;
  private JLabel textAreaStatus = new JLabel();
  private JButton butnExit = new JButton();
  private JButton btnAddNew = new JButton();
  private JButton btnPrint = new JButton();
  private JButton butExtract = new JButton();
  private JLabel jLabel1 = new JLabel();
  private JLabel jTextField1 = new JLabel();
  private JLabel jTextField3 = new JLabel();
  private JTextField txtMTR_NO = new JTextField();
  private JLabel jTextField5 = new JLabel();
  private JTextField txtMill_MTR_NO = new JTextField();
  private JLabel jTextField7 = new JLabel();
  private JTextField txtDATE_YY = new JTextField();
  private JLabel jTextField9 = new JLabel();
  private JTextField txtDATE_MM = new JTextField();
  private JLabel jTextField11 = new JLabel();
  private JLabel jTextField13 = new JLabel();
  private JComboBox cboCenter = new JComboBox();
  private JComboBox cboCnty = new JComboBox();
  private JLabel jLabel2 = new JLabel();
  private JLabel jLabel3 = new JLabel();
  private JTextField txtUser = new JTextField();//vector of Records of teable division

  //User defined variables
  private Vector CenterList  = null;
  private Vector CntyList    = null;//vector of Records of table country
  private Vector DivList     = null;

  private Record CurrUser = PublicVariable.USER_RECORD;
  private GetBuyerMaker dlgMill = new GetBuyerMaker(23);
  private GetBuyerMaker dlgBuyer = new GetBuyerMaker(1);
  JLabel jTextField14 = new JLabel();
  JTextField txtPeople = new JTextField();
  JTextField txtPattern = new JTextField();
  JLabel jTextField15 = new JLabel();
  JLabel jTextField12 = new JLabel();
  JComboBox cboMtlType = new JComboBox();
  JLabel jTextField2 = new JLabel();
  JRadioButton rdoOrgBuyer = new JRadioButton();
  JRadioButton rdoLknBuyer = new JRadioButton();
  ButtonGroup buttonGroup1 = new ButtonGroup();
  SelectBuyerMaker slkMill = new SelectBuyerMaker();
  SelectBuyerMaker slkHistoryBuyer = new SelectBuyerMaker();

  public MaterialSearch(Frame1 _frame,int Type) {
    frame = _frame;
    try {
      jbInit();
      SearchAjustment(Type);
      cboMtlType.addItem("");
      cboMtlType.addItem("fabric");
      cboMtlType.addItem("yarn");
      cboMtlType.addItem("accessories");
      cboMtlType.addItem("home furnished");
      cboMtlType.addItem("ready made product");
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }
  void jbInit() throws Exception {
    this.setMaxLength();
    initAllComboBox();

    jLabel1.setBounds(new Rectangle(117, 15, 566, 24));
    jLabel1.setHorizontalAlignment(SwingConstants.CENTER);
    jLabel1.setBorder(BorderFactory.createEtchedBorder());
    jLabel1.setForeground(new Color(10,36,106));
    jLabel1.setFont(new java.awt.Font("Dialog", 1, 13));

    butExtract.setText("Extract");
    butExtract.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        butExtract_actionPerformed(e);
      }
    });
    butExtract.setForeground(Color.darkGray);
    butExtract.setFont(new java.awt.Font("Dialog", 1, 13));
    butExtract.setBounds(new Rectangle(307, 467, 94, 25));
    butExtract.setBackground(Color.lightGray);

    btnAddNew.setText("Add New");
    btnAddNew.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnAddNew_actionPerformed(e);
      }
    });
    btnAddNew.setContentAreaFilled(true);
    btnAddNew.setForeground(Color.darkGray);
    btnAddNew.setFont(new java.awt.Font("Dialog", 1, 13));
    btnAddNew.setBounds(new Rectangle(440, 467, 94, 25));
    btnAddNew.setEnabled(false);
    btnAddNew.setBackground(Color.lightGray);

    btnPrint.setText("Sticker");
    btnPrint.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnPrint_actionPerformed(e);
      }
    });
    btnPrint.setContentAreaFilled(true);
    btnPrint.setForeground(Color.darkGray);
    btnPrint.setFont(new java.awt.Font("Dialog", 1, 13));
    btnPrint.setBounds(new Rectangle(174, 467, 94, 25));
    btnPrint.setEnabled(false);
    btnPrint.setBackground(Color.lightGray);

    butnExit.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        butnExit_actionPerformed(e);
      }
    });
    butnExit.setText("Exit");
    butnExit.setForeground(Color.darkGray);
    butnExit.setFont(new java.awt.Font("Dialog", 1, 13));
    butnExit.setBounds(new Rectangle(573, 467, 94, 25));
    butnExit.setBackground(Color.lightGray);
    textAreaStatus.setBounds(new Rectangle(0, 540, 800, 30));
    textAreaStatus.setOpaque(true);
    textAreaStatus.setBorder(null);
    textAreaStatus.setBackground(new Color(143, 143, 188));
    this.setLayout(null);
    this.setSize(800,600);
    this.setBackground(new Color(204, 204, 225));
    this.setEnabled(true);
    this.setDoubleBuffered(true);
    jTextField1.setBackground(new Color(143, 143, 188));
    jTextField1.setFont(new java.awt.Font("Dialog", 1, 12));
    jTextField1.setForeground(new Color(10,36,106));
    jTextField1.setBorder(null);
    jTextField1.setOpaque(true);
    jTextField1.setText(" Center :");
    jTextField1.setBounds(new Rectangle(186, 45, 194, 22));
    jTextField3.setBackground(new Color(143, 143, 188));
    jTextField3.setFont(new java.awt.Font("Dialog", 1, 12));
    jTextField3.setForeground(Color.white);
    jTextField3.setBorder(null);
    jTextField3.setOpaque(true);
    jTextField3.setText(" Material No. :");
    jTextField3.setBounds(new Rectangle(186, 81, 194, 22));
    txtMTR_NO.setBounds(new Rectangle(382, 81, 229, 22));
    jTextField5.setBackground(new Color(143, 143, 188));
    jTextField5.setFont(new java.awt.Font("Dialog", 1, 12));
    jTextField5.setForeground(new Color(10,36,106));
    jTextField5.setBorder(null);
    jTextField5.setOpaque(true);
    jTextField5.setText(" Mill\'s Material No. :");
    jTextField5.setBounds(new Rectangle(186, 117, 194, 22));
    txtMill_MTR_NO.setBounds(new Rectangle(382, 117, 229, 22));
    jTextField7.setBackground(new Color(143, 143, 188));
    jTextField7.setFont(new java.awt.Font("Dialog", 1, 12));
    jTextField7.setForeground(Color.white);
    jTextField7.setBorder(null);
    jTextField7.setOpaque(true);
    jTextField7.setText(" Create Date :");
    jTextField7.setBounds(new Rectangle(186, 153, 194, 22));
    txtDATE_YY.setText("");
    txtDATE_YY.setBounds(new Rectangle(382, 153, 48, 22));
    jTextField9.setBackground(new Color(143, 143, 188));
    jTextField9.setFont(new java.awt.Font("Dialog", 1, 12));
    jTextField9.setForeground(new Color(10,36,106));
    jTextField9.setBorder(null);
    jTextField9.setOpaque(true);
    jTextField9.setText(" Create User :");
    jTextField9.setBounds(new Rectangle(186, 188, 194, 22));
    txtDATE_MM.setText("");
    txtDATE_MM.setBounds(new Rectangle(444, 153, 33, 22));
    jTextField11.setBackground(new Color(143, 143, 188));
    jTextField11.setFont(new java.awt.Font("Dialog", 1, 12));
    jTextField11.setForeground(Color.white);
    jTextField11.setBorder(null);
    jTextField11.setOpaque(true);
    jTextField11.setText(" Mill :");
    jTextField11.setBounds(new Rectangle(186, 224, 194, 22));
    jTextField13.setBackground(new Color(143, 143, 188));
    jTextField13.setFont(new java.awt.Font("Dialog", 1, 12));
    jTextField13.setForeground(new Color(10,36,106));
    jTextField13.setBorder(null);
    jTextField13.setOpaque(true);
    jTextField13.setText(" Mill Country :");
    jTextField13.setBounds(new Rectangle(186, 260, 194, 22));
    cboCenter.setEditable(false);
    cboCenter.setBounds(new Rectangle(382, 45, 229, 22));
    cboCnty.setBounds(new Rectangle(382, 260, 229, 22));
    jLabel2.setFont(new java.awt.Font("Dialog", 1, 18));
    jLabel2.setForeground(new Color(10,36,106));
    jLabel2.setText("/");
    jLabel2.setBounds(new Rectangle(434, 153, 10, 22));
    jLabel3.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel3.setForeground(new Color(143, 143, 188));
    jLabel3.setText("(YYYY/MM)");
    jLabel3.setBounds(new Rectangle(483, 153, 70, 22));
    txtUser.setBounds(new Rectangle(382, 188, 229, 22));
    jTextField14.setBounds(new Rectangle(186, 296, 194, 22));
    jTextField14.setText(" Confirm Person :");
    jTextField14.setOpaque(true);
    jTextField14.setBorder(null);
    jTextField14.setForeground(Color.white);
    jTextField14.setFont(new java.awt.Font("Dialog", 1, 12));
    jTextField14.setBackground(new Color(143, 143, 188));
    txtPeople.setBounds(new Rectangle(382, 296, 229, 22));
    txtPattern.setBounds(new Rectangle(382, 331, 229, 22));
    jTextField15.setBackground(new Color(143, 143, 188));
    jTextField15.setFont(new java.awt.Font("Dialog", 1, 12));
    jTextField15.setForeground(new Color(10,36,106));
    jTextField15.setBorder(null);
    jTextField15.setOpaque(true);
    //jTextField15.setSelectedTextColor(Color.white);
    jTextField15.setText(" Pattern Name :");
    jTextField15.setBounds(new Rectangle(186, 331, 194, 22));
    jTextField12.setBounds(new Rectangle(186, 366, 194, 46));
    jTextField12.setText(" BUYER :");
    jTextField12.setOpaque(true);
    jTextField12.setBorder(null);
    jTextField12.setForeground(Color.white);
    jTextField12.setFont(new java.awt.Font("Dialog", 1, 12));
    jTextField12.setBackground(new Color(143, 143, 188));
    cboMtlType.setBounds(new Rectangle(381, 421, 229, 22));
    cboMtlType.setEditable(false);
    jTextField2.setBounds(new Rectangle(186, 421, 194, 22));
    jTextField2.setText(" TYPE :");
    jTextField2.setOpaque(true);
    jTextField2.setBorder(null);
    jTextField2.setForeground(new Color(10,36,106));
    jTextField2.setFont(new java.awt.Font("Dialog", 1, 12));
    jTextField2.setBackground(new Color(143, 143, 188));
    rdoOrgBuyer.setBackground(new Color(204, 204, 225));
    rdoOrgBuyer.setSelected(true);
    rdoOrgBuyer.setText("Offer Buyer");
    rdoOrgBuyer.setBounds(new Rectangle(384, 366, 102, 20));
    rdoLknBuyer.setBounds(new Rectangle(500, 367, 102, 20));
    rdoLknBuyer.setText("Lock In Buyer");
    rdoLknBuyer.setBackground(new Color(204, 204, 225));
    rdoLknBuyer.setSelected(true);
    slkMill.setBounds(new Rectangle(383, 224, 229, 23));
    slkHistoryBuyer.setBounds(new Rectangle(382, 388, 226, 22));
    this.add(textAreaStatus, null);
    this.add(jLabel1, null);
    this.add(btnPrint, null);
    this.add(butExtract, null);
    this.add(btnAddNew, null);
    this.add(butnExit, null);
    this.add(jTextField9, null);
    this.add(jTextField1, null);
    this.add(cboCenter, null);
    this.add(jTextField3, null);
    this.add(txtMTR_NO, null);
    this.add(jTextField5, null);
    this.add(txtMill_MTR_NO, null);
    this.add(jTextField7, null);
    this.add(txtDATE_YY, null);
    this.add(jLabel2, null);
    this.add(txtDATE_MM, null);
    this.add(jLabel3, null);
    this.add(txtUser, null);
    this.add(jTextField11, null);
    this.add(jTextField13, null);
    this.add(cboCnty, null);
    this.add(jTextField14, null);
    this.add(txtPeople, null);
    this.add(jTextField15, null);
    this.add(txtPattern, null);
    this.add(jTextField12, null);
    this.add(jTextField2, null);
    this.add(cboMtlType, null);
    this.add(rdoOrgBuyer, null);
    this.add(rdoLknBuyer, null);
    this.add(slkMill, null);
    this.add(slkHistoryBuyer, null);
    if(util.ApplicationProperites.getProperties(MTR_SEARCH.CONDITIONS)!=null){
      this.ResetOrigValue((java.util.HashMap) util.ApplicationProperites.getProperties(MTR_SEARCH.CONDITIONS));
    }
    buttonGroup1.add(rdoOrgBuyer);
    buttonGroup1.add(rdoLknBuyer);
    slkHistoryBuyer.init("",null,slkHistoryBuyer.TYPE_BUYER,true);
    slkMill.init("",null,slkHistoryBuyer.TYPE_FABRIC_MILL,true);
  }
  void butnExit_actionPerformed(ActionEvent e) {
    //frame.showPanel(new newtimes.material.MaterialMenu(frame));
    CONST.isExit = false;
    util.ApplicationProperites.removeProperites(MTR_SEARCH.CONDITIONS);
    CONST.HIST.prevState();
  }

  void btnAddNew_actionPerformed(ActionEvent e) {
    setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
    this.defCen = cboCenter.getSelectedItem();
    HashMap conds = SetConditions();
    util.ApplicationProperites.setProperties(MTR_SEARCH.CONDITIONS, conds);
    CONST.HIST.insertState(CONST.HIST.SEARCH,frame);
    //Show new Material record panel
    frame.showPanel(new newtimes.material.MaterialList(frame,MTR_SEARCH.MTR_NEW_REC));
    setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
  }

  void btnPrint_actionPerformed(ActionEvent e) {
    if(check_Month() && check_Year()){
      setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
      this.defCen = cboCenter.getSelectedItem();
      HashMap conds = SetConditions();
      util.ApplicationProperites.setProperties(MTR_SEARCH.CONDITIONS, conds);
      frame.showPanel(new newtimes.material.MtrDtlPrintList(frame));
      setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
    }
  }

  void butExtract_actionPerformed(ActionEvent e) {
    if(check_Month() && check_Year()){
      setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
      this.defCen = cboCenter.getSelectedItem();
      CONST.pageFlag = false;
      HashMap conds = SetConditions();
      util.ApplicationProperites.setProperties(MTR_SEARCH.CONDITIONS, conds);
      if(SearchType==MTR_SEARCH.EXISTING){
        //Show Material Head List panel according to the conditions
        CONST.HIST.insertState(CONST.HIST.SEARCH,frame);
        frame.showPanel(new newtimes.material.MaterialList(frame,MTR_SEARCH.MTR_HEAD_LIST));
      }
      else if(SearchType==MTR_SEARCH.DELETED){
        //Show Material Head List panel according to the conditions
        CONST.HIST.insertState(CONST.HIST.RESTORE,frame);
        frame.showPanel(new newtimes.material.MaterialList(frame,MTR_SEARCH.DEL_MTR_HEAD_LIST));
      }
      setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
    }
  }

  //Private Methods
  private void SearchAjustment(int Type){
    SearchType=Type;
    if(SearchType==1){
      btnAddNew.setEnabled(true);
      btnPrint.setEnabled(true);
      jLabel1.setText("      ============  Material Search  ============      ");
    }
    else if(SearchType==2){
      btnAddNew.setEnabled(false);
      btnPrint.setEnabled(false);
      jLabel1.setText("      ============  Deleted Material Search  ============      ");
    }

  }
  private void initAllComboBox(){
    try{
      HashMap hm=null;
      if(util.ApplicationProperites.getProperties("allData")==null){
        hm = exgui2.CONST.Material_EJB.getAllSelctData();
        util.ApplicationProperites.setProperties("allData", hm);
      }else{
        hm=(HashMap)util.ApplicationProperites.getProperties("allData");
      }
      CenterList = (Vector)hm.get(MTR_EJB.CENTER);
      CntyList   = (Vector)hm.get(MTR_EJB.COUNTRY);
      DivList    = (Vector)hm.get(MTR_EJB.DIVISION);

      Util.setComboValues(cboCenter, CenterList, CEN_EJB.NAME, false);
      Util.setComboValues(cboCnty, CntyList, CNTY_EJB.NAME,true);


      if (CONST.isExit) {
        cboCenter.setSelectedItem(this.defCen);
      } else {
        Object usrCenNameDf = util.PublicVariable.USER_RECORD.get("CEN_NAME_DF");
        cboCenter.setSelectedItem(usrCenNameDf);
      }

      String usertype = (String)CurrUser.get("USR_TYPE");
      if(Integer.parseInt(usertype)>2){
        cboCenter.setEnabled(false);
      }
    }
    catch(Exception e){
      e.printStackTrace();
      util.ExceptionLog.exp2File(e, "error at MaterialSearch.initAllComboBox()");
    }
  }

  private HashMap SetConditions(){
    HashMap hm = new HashMap();
    int index=0;
    Record rec=null;
    try{
      index = cboCenter.getSelectedIndex();
      if(index<0){
        hm.put(MTR_SEARCH.CEN_CODE, "");
      }
      else{
        rec = (Record) CenterList.get(index);
        hm.put(MTR_SEARCH.CEN_CODE, rec.get(CEN_EJB.CODE));
      }

      hm.put(MTR_SEARCH.DIV_CODE,"");
      hm.put("DIV_NAME","");
      //hm.put(MTR_SEARCH.MILL_NAME, popMill.getText()==null?"":popMill.getText());
      Object millObj=slkMill.getSelectedValue();
      hm.put(MTR_SEARCH.MILL_NAME,(millObj==null)?"":millObj.toString());
      hm.put(MTR_SEARCH.CNTY_CODE, cboCnty.getSelectedItem());
      hm.put("PERSON_NAME",txtPeople.getText());
      hm.put("PATTERN_NAME",txtPattern.getText().toUpperCase());
      hm.put(MTR_SEARCH.MTR_NO,txtMTR_NO.getText().trim());
      hm.put(MTR_SEARCH.MILL_NO, txtMill_MTR_NO.getText().trim());
      hm.put(MTR_SEARCH.CREATE_DATE, getDate());
      hm.put("txtDATE_YY",txtDATE_YY.getText());
      hm.put("txtDATE_MM",txtDATE_MM.getText());
      if(cboMtlType.getSelectedIndex()!=0){
        hm.put(MaterialMdlEJBs.MaterialEJB.MtrEJB.QRY_KEY_MTRL_TYPE,
               cboMtlType.getSelectedItem());

      }
      Object qryBuyerObj=slkHistoryBuyer.getSelectedValue();  //popBuyer.getSelectedBuyerValue();
      if(qryBuyerObj!=null){
        if(rdoLknBuyer.isSelected()){
                 hm.put(
                 MaterialMdlEJBs.MaterialEJB.MtrEJB.QRY_KEY_MTRL_HISTORY_LOKIN_BUYER,
                 qryBuyerObj.toString());
        }else{
                 hm.put(
                 MaterialMdlEJBs.MaterialEJB.MtrEJB.QRY_KEY_MTRL_HISTORY_BUYER,
                 qryBuyerObj.toString());
        }
      }
      hm.put(MTR_SEARCH.CREATE_USER, txtUser.getText().trim());
      if(SearchType==MTR_SEARCH.EXISTING){
        hm.put(MTR_SEARCH.DELETE_FLAG, "1");
      }
      else if(SearchType==MTR_SEARCH.DELETED){
        hm.put(MTR_SEARCH.DELETE_FLAG, "0");
      }
    }
    catch(Exception e){
      e.printStackTrace();
    }
    finally{
      return hm;
    }
  }

  private String getDate(){
    return (txtDATE_YY.getText()+txtDATE_MM.getText()).trim();
  }

  void ResetOrigValue(java.util.HashMap hm){
    cboCenter.setSelectedItem(hm.get(MTR_SEARCH.CEN_CODE));
    cboCnty.setSelectedItem(hm.get(MTR_SEARCH.CNTY_CODE));
    this.txtMTR_NO.setText((String)hm.get(MTR_SEARCH.MTR_NO));
    this.txtMill_MTR_NO.setText((String)hm.get(MTR_SEARCH.MILL_NO));
    this.txtPeople.setText(hm.get("PERSON_NAME").toString());
    this.txtPattern.setText(hm.get("PATTERN_NAME").toString());
    this.txtDATE_YY.setText((String)hm.get("txtDATE_YY"));
    this.txtDATE_MM.setText((String)hm.get("txtDATE_MM"));
    this.txtUser.setText((String)hm.get(MTR_SEARCH.CREATE_USER));
  }

  void setMaxLength(){
    exgui.DataBindText tx = null;
    exgui.DataBindText tx1 = null;
    tx = new exgui.DataBindText(txtDATE_YY,null,"",4);
    tx1 = new exgui.DataBindText(txtDATE_MM,null,"",2);
  }
  private boolean check_Year(){
    if (!txtDATE_YY.getText().trim().equals("")) {
      if (exgui.verification.VerifyLib.isInteger(txtDATE_YY,
          "The Year field must be integer!") == true) {
        return true;
      } else {
        txtDATE_YY.grabFocus();
        return false;
      }
    } else {
      return true;
    }
  }
  private boolean check_Month(){
    if (!txtDATE_MM.getText().trim().equals("")) {
      if (exgui.verification.VerifyLib.isInteger(txtDATE_MM,
          "The Month field must be integer!") == true) {
        return true;
      } else {
        txtDATE_MM.grabFocus();
        return false;
      }
    } else {
      return true;
    }
  }

}
