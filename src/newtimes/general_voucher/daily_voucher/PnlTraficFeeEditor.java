package newtimes.general_voucher.daily_voucher;
import java.awt.*;
import javax.swing.*;
import exgui.*;
import javax.swing.border.*;
import java.awt.event.*;
import processhandler.template.PnlFieldsEditor;
import exgui.ultratable.*;
/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class PnlTraficFeeEditor
     extends PnlFieldsEditor{
     //extends JPanel {
 BlueBkgWhiteCharLabel blueBkgWhiteCharLabel1 = new BlueBkgWhiteCharLabel();
 WhiteBkgBlueCharLabel whiteBkgBlueCharLabel1 = new WhiteBkgBlueCharLabel();
 JComboBox cbxCountry = new JComboBox();
 BlueBkgWhiteCharLabel blueBkgWhiteCharLabel2 = new BlueBkgWhiteCharLabel();
 JTextField txtFrom = new JTextField();
 JTextField txtTo = new JTextField();
 BlueBkgWhiteCharLabel blueBkgWhiteCharLabel3 = new BlueBkgWhiteCharLabel();
 BlueBkgWhiteCharLabel blueBkgWhiteCharLabel4 = new BlueBkgWhiteCharLabel();
 JTextField txtDays = new JTextField();
 JPanel jPanel1 = new JPanel();
 TitledBorder titledBorder1;
 WhiteBkgBlueCharLabel whiteBkgBlueCharLabel2 = new WhiteBkgBlueCharLabel();
 JComboBox cbxPprs = new JComboBox(new String[]{"長駐驗貨","支援驗貨","跟催大貨","跟催樣品",
                                                 "開發工廠","開發布種","DUPS會議","海外公司營運",
                                                 "陪客人參觀"});
 BlueBkgWhiteCharLabel blueBkgWhiteCharLabel5 = new BlueBkgWhiteCharLabel();
 JTextField txtAirTkt = new JTextField();
 BlueBkgWhiteCharLabel blueBkgWhiteCharLabel6 = new BlueBkgWhiteCharLabel();
 JTextField txtTraficFee = new JTextField();
 BlueBkgWhiteCharLabel blueBkgWhiteCharLabel7 = new BlueBkgWhiteCharLabel();
 BlueBkgWhiteCharLabel blueBkgWhiteCharLabel8 = new BlueBkgWhiteCharLabel();
 JTextField txtTax = new JTextField();
 JTextField txtHotel = new JTextField();
 BlueBkgWhiteCharLabel blueBkgWhiteCharLabel9 = new BlueBkgWhiteCharLabel();
 BlueBkgWhiteCharLabel blueBkgWhiteCharLabel10 = new BlueBkgWhiteCharLabel();
 JTextField txtOverTime = new JTextField();
 JTextField txtFood = new JTextField();
 BlueBkgWhiteCharLabel lblOverTime = new BlueBkgWhiteCharLabel();
 JTextField txtVISA = new JTextField();
 JTextField txtDaily = new JTextField();
 BlueBkgWhiteCharLabel blueBkgWhiteCharLabel12 = new BlueBkgWhiteCharLabel();
 BlueBkgWhiteCharLabel blueBkgWhiteCharLabel13 = new BlueBkgWhiteCharLabel();
 BlueBkgWhiteCharLabel lblLndry = new BlueBkgWhiteCharLabel();
 JTextField txtOverWt = new JTextField();
 JTextField txtTEL = new JTextField();
 BlueBkgWhiteCharLabel blueBkgWhiteCharLabel15 = new BlueBkgWhiteCharLabel();
 JTextField txtLndry = new JTextField();
 JTextField txtOther = new JTextField();
 BlueBkgWhiteCharLabel blueBkgWhiteCharLabel16 = new BlueBkgWhiteCharLabel();
 JLabel jLabel1 = new JLabel();
 JTextField txtDesc = new JTextField();
 JButton btnOk = new JButton();
 JButton btnExit = new JButton();
  DlgTraficFeeEditor dlgContainer;
  exgui.ultratable.DataBindComboboxTable dbCbxStaff = new exgui.ultratable.DataBindComboboxTable();
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel17 = new BlueBkgWhiteCharLabel();
  JTextField txtDbAmt = new JTextField();
  String orgTravelPopurs="";
  AmtTextUpdateNotify amtTxtModify=new AmtTextUpdateNotify();
  boolean isInitGui=false;
  JTextField txtArray[]=new JTextField[12];
  Object lastStaffId=null;
  String lastStaffName=null;
  java.text.NumberFormat nf=new java.text.DecimalFormat("##########.##");
 public PnlTraficFeeEditor() {
   try {
     jbInit();
   }
   catch(Exception ex) {
     ex.printStackTrace();
   }
 }

 public void jbInit() throws Exception {
   titledBorder1 = new TitledBorder(BorderFactory.createEtchedBorder(Color.white,new Color(148, 145, 140)),"支出項目");
   blueBkgWhiteCharLabel1.setBackground(new Color(100, 100, 167));
    blueBkgWhiteCharLabel1.setFont(new java.awt.Font("Dialog", 0, 12));
   blueBkgWhiteCharLabel1.setText("人員編號:");
   blueBkgWhiteCharLabel1.setBounds(new Rectangle(20, 17, 79, 26));
   this.setLayout(null);
   dbCbxStaff.setBounds(new Rectangle(98, 17, 218, 26));
   whiteBkgBlueCharLabel1.setForeground(new Color(100, 100, 167));
    whiteBkgBlueCharLabel1.setText("國別:");
   whiteBkgBlueCharLabel1.setBounds(new Rectangle(384, 17, 48, 26));
   cbxCountry.setBounds(new Rectangle(431, 17, 221, 26));
   blueBkgWhiteCharLabel2.setBounds(new Rectangle(20, 46, 79, 26));
   blueBkgWhiteCharLabel2.setText("出差日期 自");
   blueBkgWhiteCharLabel2.setBackground(new Color(100, 100, 167));
    blueBkgWhiteCharLabel2.setFont(new java.awt.Font("Dialog", 0, 12));
   txtFrom.setText("");
   txtFrom.setBounds(new Rectangle(98, 46, 71, 26));
   txtTo.setText("");
   txtTo.setBounds(new Rectangle(201, 46, 71, 26));
   blueBkgWhiteCharLabel3.setBackground(new Color(100, 100, 167));
    blueBkgWhiteCharLabel3.setFont(new java.awt.Font("Dialog", 0, 12));
   blueBkgWhiteCharLabel3.setText("至");
   blueBkgWhiteCharLabel3.setBounds(new Rectangle(168, 46, 34, 26));
   blueBkgWhiteCharLabel4.setBounds(new Rectangle(278, 46, 42, 26));
   blueBkgWhiteCharLabel4.setText("天數:");
   blueBkgWhiteCharLabel4.setBackground(new Color(100, 100, 167));
    blueBkgWhiteCharLabel4.setFont(new java.awt.Font("Dialog", 0, 12));
   txtDays.setBounds(new Rectangle(319, 46, 57, 26));
   txtDays.setText("");
   jPanel1.setBorder(titledBorder1);
   jPanel1.setBounds(new Rectangle(11, 80, 672, 123));
   jPanel1.setLayout(null);
   whiteBkgBlueCharLabel2.setBounds(new Rectangle(384, 46, 48, 26));
   whiteBkgBlueCharLabel2.setForeground(new Color(100, 100, 167));
    whiteBkgBlueCharLabel2.setRequestFocusEnabled(true);
   whiteBkgBlueCharLabel2.setText("目的:");
   cbxPprs.setBounds(new Rectangle(431, 46, 221, 26));
   blueBkgWhiteCharLabel5.setBackground(new Color(100, 100, 167));
    blueBkgWhiteCharLabel5.setFont(new java.awt.Font("Dialog", 0, 12));
   blueBkgWhiteCharLabel5.setText("機票");
   blueBkgWhiteCharLabel5.setBounds(new Rectangle(6, 21, 65, 26));
   txtAirTkt.setBounds(new Rectangle(71, 21, 92, 26));
   txtAirTkt.setText("");
   blueBkgWhiteCharLabel6.setBounds(new Rectangle(172, 21, 65, 26));
   blueBkgWhiteCharLabel6.setText("交通費");
   blueBkgWhiteCharLabel6.setBackground(new Color(110, 110, 167));
    blueBkgWhiteCharLabel6.setFont(new java.awt.Font("Dialog", 0, 14));
    blueBkgWhiteCharLabel6.setForeground(Color.white);
   txtTraficFee.setText("");
   txtTraficFee.setBounds(new Rectangle(236, 21, 92, 26));
   blueBkgWhiteCharLabel7.setFont(new java.awt.Font("Dialog", 0, 14));
    blueBkgWhiteCharLabel7.setForeground(Color.white);
   blueBkgWhiteCharLabel7.setBackground(new Color(110, 110, 167));
   blueBkgWhiteCharLabel7.setText("住宿費");
   blueBkgWhiteCharLabel7.setBounds(new Rectangle(503, 20, 65, 26));
   blueBkgWhiteCharLabel8.setBounds(new Rectangle(337, 20, 65, 26));
   blueBkgWhiteCharLabel8.setText("TAX");
   blueBkgWhiteCharLabel8.setBackground(new Color(100, 100, 167));
    blueBkgWhiteCharLabel8.setFont(new java.awt.Font("Dialog", 0, 12));
   txtTax.setText("");
   txtTax.setBounds(new Rectangle(402, 20, 92, 26));
   txtHotel.setBounds(new Rectangle(567, 20, 92, 26));
   txtHotel.setText("");
   blueBkgWhiteCharLabel9.setRequestFocusEnabled(true);
   blueBkgWhiteCharLabel9.setFont(new java.awt.Font("Dialog", 0, 14));
    blueBkgWhiteCharLabel9.setForeground(Color.white);
   blueBkgWhiteCharLabel9.setBackground(new Color(110, 110, 167));
   blueBkgWhiteCharLabel9.setText("VISA");
   blueBkgWhiteCharLabel9.setBounds(new Rectangle(172, 52, 65, 26));
   blueBkgWhiteCharLabel10.setBounds(new Rectangle(6, 52, 65, 26));
   blueBkgWhiteCharLabel10.setText("膳食費");
   blueBkgWhiteCharLabel10.setBackground(new Color(100, 100, 167));
    blueBkgWhiteCharLabel10.setFont(new java.awt.Font("Dialog", 0, 12));
   txtOverTime.setText("");
   txtOverTime.setBounds(new Rectangle(567, 51, 92, 26));
   txtFood.setText("");
   txtFood.setBounds(new Rectangle(71, 52, 92, 26));
   lblOverTime.setBounds(new Rectangle(503, 51, 65, 26));
   lblOverTime.setText("加班費");
   lblOverTime.setBackground(new Color(110, 110, 167));
   lblOverTime.setFont(new java.awt.Font("Dialog", 0, 14));
    lblOverTime.setForeground(Color.white);
   txtVISA.setBounds(new Rectangle(236, 52, 92, 26));
   txtVISA.setText("");
   txtDaily.setBounds(new Rectangle(402, 51, 92, 26));
   txtDaily.setText("");
   blueBkgWhiteCharLabel12.setBackground(new Color(100, 100, 167));
    blueBkgWhiteCharLabel12.setFont(new java.awt.Font("Dialog", 0, 12));
   blueBkgWhiteCharLabel12.setText("日支費");
   blueBkgWhiteCharLabel12.setBounds(new Rectangle(337, 51, 65, 26));
   blueBkgWhiteCharLabel13.setBounds(new Rectangle(337, 84, 65, 26));
   blueBkgWhiteCharLabel13.setText("TEL");
   blueBkgWhiteCharLabel13.setBackground(new Color(100, 100, 167));
    blueBkgWhiteCharLabel13.setFont(new java.awt.Font("Dialog", 0, 12));
   lblLndry.setBounds(new Rectangle(172, 84, 65, 26));
   lblLndry.setText("洗衣費");
   lblLndry.setBackground(new Color(110, 110, 167));
   lblLndry.setFont(new java.awt.Font("Dialog", 0, 14));
    lblLndry.setForeground(Color.white);
   lblLndry.setRequestFocusEnabled(true);
   txtOverWt.setBounds(new Rectangle(71, 84, 92, 26));
   txtOverWt.setText("");
   txtTEL.setText("");
   txtTEL.setBounds(new Rectangle(402, 84, 92, 26));
   blueBkgWhiteCharLabel15.setFont(new java.awt.Font("Dialog", 0, 14));
   blueBkgWhiteCharLabel15.setBackground(new Color(110, 110, 167));
   blueBkgWhiteCharLabel15.setText("其他");
   blueBkgWhiteCharLabel15.setBounds(new Rectangle(503, 84, 65, 26));
   txtLndry.setText("");
   txtLndry.setBounds(new Rectangle(236, 84, 92, 26));
   txtOther.setBounds(new Rectangle(567, 84, 92, 26));
   txtOther.setText("");
   blueBkgWhiteCharLabel16.setBackground(new Color(100, 100, 167));
    blueBkgWhiteCharLabel16.setFont(new java.awt.Font("Dialog", 0, 12));
   blueBkgWhiteCharLabel16.setText("超重費");
   blueBkgWhiteCharLabel16.setBounds(new Rectangle(6, 84, 65, 26));
   jLabel1.setFont(new java.awt.Font("Dialog", 1, 11));
   jLabel1.setText("DESCRIPTION:");
   jLabel1.setBounds(new Rectangle(13, 207, 87, 28));
   txtDesc.setText("");
   txtDesc.setBounds(new Rectangle(11, 235, 671, 29));
   btnOk.setBounds(new Rectangle(182, 277, 98, 26));
   btnOk.setFont(new java.awt.Font("Dialog", 1, 11));
   btnOk.setText("OK");
    btnOk.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnOk_actionPerformed(e);
      }
    });
   btnExit.setText("EXIT");
    btnExit.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnExit_actionPerformed(e);
      }
    });
   btnExit.setFont(new java.awt.Font("Dialog", 1, 11));
   btnExit.setBounds(new Rectangle(376, 277, 98, 26));
    blueBkgWhiteCharLabel17.setBackground(new Color(100, 100, 167));
    blueBkgWhiteCharLabel17.setFont(new java.awt.Font("Dialog", 0, 12));
    blueBkgWhiteCharLabel17.setText("總金額");
    blueBkgWhiteCharLabel17.setBounds(new Rectangle(497, 204, 75, 25));
    txtDbAmt.setText("");
    txtDbAmt.setBounds(new Rectangle(572, 205, 109, 24));
    jPanel1.add(blueBkgWhiteCharLabel5, null);
   jPanel1.add(txtAirTkt, null);
   jPanel1.add(blueBkgWhiteCharLabel6, null);
   jPanel1.add(txtTraficFee, null);
   jPanel1.add(blueBkgWhiteCharLabel8, null);
   jPanel1.add(txtTax, null);
   jPanel1.add(blueBkgWhiteCharLabel7, null);
   jPanel1.add(txtHotel, null);
   jPanel1.add(blueBkgWhiteCharLabel9, null);
   jPanel1.add(blueBkgWhiteCharLabel10, null);
   jPanel1.add(txtOverTime, null);
   jPanel1.add(txtFood, null);
   jPanel1.add(lblOverTime, null);
   jPanel1.add(txtVISA, null);
   jPanel1.add(txtDaily, null);
   jPanel1.add(blueBkgWhiteCharLabel12, null);
   jPanel1.add(blueBkgWhiteCharLabel13, null);
   jPanel1.add(lblLndry, null);
   jPanel1.add(txtOverWt, null);
   jPanel1.add(txtTEL, null);
   jPanel1.add(blueBkgWhiteCharLabel15, null);
   jPanel1.add(txtLndry, null);
   jPanel1.add(txtOther, null);
   jPanel1.add(blueBkgWhiteCharLabel16, null);
    this.add(txtDesc, null);
    this.add(jLabel1, null);
    this.add(btnExit, null);
    this.add(btnOk, null);
    this.add(blueBkgWhiteCharLabel17, null);
    this.add(txtDbAmt, null);
    this.add(blueBkgWhiteCharLabel1, null);
    this.add(dbCbxStaff, null);
    this.add(whiteBkgBlueCharLabel2, null);
    this.add(blueBkgWhiteCharLabel2, null);
    this.add(txtFrom, null);
    this.add(blueBkgWhiteCharLabel3, null);
    this.add(txtTo, null);
    this.add(blueBkgWhiteCharLabel4, null);
    this.add(txtDays, null);
    this.add(cbxPprs, null);
    this.add(jPanel1, null);
    this.add(whiteBkgBlueCharLabel1, null);
    this.add(cbxCountry, null);
    txtLndry.setEditable(false);
    txtOverTime.setEditable(false);
    txtDesc.grabFocus();
    //AMT,DESCRIPTION are generated by other fields key action.
    dbCbxStaff.getGUIcomponent().addKeyListener(new java.awt.event.KeyAdapter() {
          public void keyReleased(KeyEvent e) {
            updateDescriptionTextField();
          }
      });
      dbCbxStaff.getGUIcomponent().addFocusListener(
       new java.awt.event.FocusAdapter(){
          public void focusLost(java.awt.event.FocusEvent fe){
            updateDescriptionTextField();
          }
       }
      );
      txtFrom.addKeyListener(new java.awt.event.KeyAdapter() {
          public void keyReleased(KeyEvent e) {
            updateDescriptionTextField();
          }
      });

      txtTo.addKeyListener(new java.awt.event.KeyAdapter() {
          public void keyReleased(KeyEvent e) {
            updateDescriptionTextField();
          }
      });



      txtAirTkt.addKeyListener(amtTxtModify);
      txtArray[0]=txtAirTkt;

      txtDaily.addKeyListener(amtTxtModify);
      txtArray[1]=txtDaily;

      txtFood.addKeyListener(amtTxtModify);
      txtArray[2]=txtFood;

      txtHotel.addKeyListener(amtTxtModify);
      txtArray[3]=txtHotel;

      txtLndry.addKeyListener(amtTxtModify);
      txtArray[4]=txtLndry;

      txtOther.addKeyListener(amtTxtModify);
      txtArray[5]=txtOther;

      txtOverTime.addKeyListener(amtTxtModify);
      txtArray[6]=txtOverTime;

      txtOverWt.addKeyListener(amtTxtModify);
      txtArray[7]=txtOverWt;

      txtTax.addKeyListener(amtTxtModify);
      txtArray[8]=txtTax;

      txtTEL.addKeyListener(amtTxtModify);
      txtArray[9]=txtTEL;

      txtTraficFee.addKeyListener(amtTxtModify);
      txtArray[10]=txtTraficFee;

      txtVISA.addKeyListener(amtTxtModify);
      txtArray[11]=txtVISA;

      cbxCountry.addItemListener(new java.awt.event.ItemListener() {
        public void itemStateChanged(ItemEvent e) {
          if(!isInitGui){
            updateDescriptionTextField();
          }
        }
      });
      txtDbAmt.setEditable(false);

 }
  class AmtTextUpdateNotify extends java.awt.event.KeyAdapter {
     public void keyReleased(KeyEvent e){
       updateAmtTextField();
     }
  }


 void updateAmtTextField(){
   double total=0;
   for(int i=0;i<txtArray.length;i++){
     String amt=txtArray[i].getText().trim();
     if(amt.trim().length()==1 && "0123456789".indexOf(amt.trim())==-1)continue;
     if(amt.length()>0){
       total+=Double.parseDouble(amt);
     }
   }
   txtDbAmt.setText(nf.format(total));
 }
 void updateDescriptionTextField(){
     if(isInitGui)return;
     String staffName=lastStaffName;
     Object selectedStaffId=dbCbxStaff.getSelectedValue();
     if(null!=selectedStaffId){
       database.datatype.Record recStaff =
           (database.datatype.Record)Constants.HT_STAFF_ID_REC.get(
           selectedStaffId);
       staffName = (String)recStaff.get(1);
     }

     /*
     if(!util.MiscFunc.isEqual( lastStaffId,selectedStaffId)){
       if(null!=selectedStaffId){
         database.datatype.Record recStaff =
             (database.datatype.Record)Constants.HT_STAFF_ID_REC.get(
             selectedStaffId);
         staffName = (String)recStaff.get(1);
         lastStaffId = selectedStaffId;
         lastStaffName = (String)recStaff.get(1);
       }else{
         staffName="";
         lastStaffId = selectedStaffId;
         lastStaffName="";
       }
     }
     */
     String fromDateStr=(txtFrom.getText().length()==10)?
             txtFrom.getText().substring(5,10):"";
     String toDateStr=(txtTo.getText().length()==10)?
                 txtTo.getText().substring(5,10):"";
     String cnty=(String)cbxCountry.getSelectedItem();
     if("NONE".equals(cnty))cnty="";
     StringBuffer sb=new StringBuffer();
     sb.append(staffName);
     sb.append(" ");
     sb.append(fromDateStr);
     sb.append("-");
     sb.append(toDateStr);
     sb.append(" ");
     sb.append(cnty);
     sb.append(" 差旅費");
     txtDesc.setText(sb.toString());
 }

 public void record2Gui(){
   try{
     isInitGui=true;
     dataBoundGUIs.clear();

     util.InsertionOrderedHashMap iso=new util.InsertionOrderedHashMap();
     iso.put("CODE","USR_CODE");
     iso.put("姓名","USR_NAME");
     iso.put("NAME","USR_ENG_NAME");
     dbCbxStaff.init("STAFF_CODE", Constants.VCT_STAFF, iso, 250, 250, "USR_CODE", "USR_CODE", recToMapping.get("STAFF_CODE"));
     dataBoundGUIs.add(dbCbxStaff);
     lastStaffId= recToMapping.get("STAFF_CODE");
     lastStaffName=((JTextField)dbCbxStaff.getGUIcomponent()).getText();

     Object vftxtFrom=exgui.verification.CellFormat.getDateStringFormaterAllowNull();
      dataBoundGUIs.add(  new exgui.DataBindTextWithChecker(txtFrom,"TVL_FROM", recToMapping.get("TVL_FROM"),10,(exgui.Object2String)vftxtFrom,(exgui.ultratable.CellTxtEditorFormat)vftxtFrom)
     );
     //Object vftxtTo=exgui.verification.CellFormat.getDateStringFormater();
      dataBoundGUIs.add(  new exgui.DataBindTextWithChecker(txtTo,"TVL_TO",recToMapping.get("TVL_TO"),10,(exgui.Object2String)vftxtFrom,(exgui.ultratable.CellTxtEditorFormat)vftxtFrom)
     );
     Object vftxtDays=exgui.verification.CellFormat.getIntVerifierAllowNull(10);
      dataBoundGUIs.add(  new exgui.DataBindTextWithChecker(txtDays,"TVL_DAY",recToMapping.get("TVL_DAY"),10,(exgui.Object2String)vftxtDays,(exgui.ultratable.CellTxtEditorFormat)vftxtDays)
     );
     Object vftxtAirTkt=exgui.verification.CellFormat.getDoubleFormatAllowNull(10,2);
      dataBoundGUIs.add(  new exgui.DataBindTextWithChecker(txtAirTkt,"TVL_FEE_FLY_TKT",recToMapping.get("TVL_FEE_FLY_TKT"),12,(exgui.Object2String)vftxtAirTkt,(exgui.ultratable.CellTxtEditorFormat)vftxtAirTkt)
     );
     Object vftxtTraficFee=vftxtAirTkt;//exgui.verification.CellFormat.getIntVerifierAllowNull(38);
      dataBoundGUIs.add(  new exgui.DataBindTextWithChecker(txtTraficFee,"TVL_FEE_TRFIC",recToMapping.get("TVL_FEE_TRFIC"),12,(exgui.Object2String)vftxtTraficFee,(exgui.ultratable.CellTxtEditorFormat)vftxtTraficFee)
     );
     Object vftxtTax=vftxtAirTkt;//exgui.verification.CellFormat.getIntVerifierAllowNull(38);
      dataBoundGUIs.add(  new exgui.DataBindTextWithChecker(txtTax,"TVL_FEE_TAX",recToMapping.get("TVL_FEE_TAX"),12,(exgui.Object2String)vftxtTax,(exgui.ultratable.CellTxtEditorFormat)vftxtTax)
     );
     Object vftxtHotel=vftxtAirTkt;//exgui.verification.CellFormat.getIntVerifierAllowNull(38);
      dataBoundGUIs.add(  new exgui.DataBindTextWithChecker(txtHotel,"TVL_FEE_HOTEL",recToMapping.get("TVL_FEE_HOTEL"),12,(exgui.Object2String)vftxtHotel,(exgui.ultratable.CellTxtEditorFormat)vftxtHotel)
     );
     Object vftxtOverTime=vftxtAirTkt;//exgui.verification.CellFormat.getIntVerifierAllowNull(38);
      dataBoundGUIs.add(  new exgui.DataBindTextWithChecker(txtOverTime,"TVL_FEE_OVERTIME",recToMapping.get("TVL_FEE_OVERTIME"),12,(exgui.Object2String)vftxtOverTime,(exgui.ultratable.CellTxtEditorFormat)vftxtOverTime)
     );
     Object vftxtFood=vftxtAirTkt;//exgui.verification.CellFormat.getIntVerifierAllowNull(38);
      dataBoundGUIs.add(  new exgui.DataBindTextWithChecker(txtFood,"TVL_FEE_FOOD",recToMapping.get("TVL_FEE_FOOD"),12,(exgui.Object2String)vftxtFood,(exgui.ultratable.CellTxtEditorFormat)vftxtFood)
     );
     Object vftxtVISA=vftxtAirTkt;//exgui.verification.CellFormat.getIntVerifierAllowNull(38);
      dataBoundGUIs.add(  new exgui.DataBindTextWithChecker(txtVISA,"TVL_FEE_VISA",recToMapping.get("TVL_FEE_VISA"),12,(exgui.Object2String)vftxtVISA,(exgui.ultratable.CellTxtEditorFormat)vftxtVISA)
     );
     Object vftxtDaily=vftxtAirTkt;//exgui.verification.CellFormat.getIntVerifierAllowNull(38);
      dataBoundGUIs.add(  new exgui.DataBindTextWithChecker(txtDaily,"TVL_FEE_DAILY",recToMapping.get("TVL_FEE_DAILY"),12,(exgui.Object2String)vftxtDaily,(exgui.ultratable.CellTxtEditorFormat)vftxtDaily)
     );
     Object vftxtOverWt=vftxtAirTkt;//exgui.verification.CellFormat.getIntVerifierAllowNull(38);
      dataBoundGUIs.add(  new exgui.DataBindTextWithChecker(txtOverWt,"TVL_FEE_OVERWT",recToMapping.get("TVL_FEE_OVERWT"),12,(exgui.Object2String)vftxtOverWt,(exgui.ultratable.CellTxtEditorFormat)vftxtOverWt)
     );
     Object vftxtTEL=vftxtAirTkt;//exgui.verification.CellFormat.getIntVerifierAllowNull(38);
      dataBoundGUIs.add(  new exgui.DataBindTextWithChecker(txtTEL,"TVL_FEE_TEL",recToMapping.get("TVL_FEE_TEL"),12,(exgui.Object2String)vftxtTEL,(exgui.ultratable.CellTxtEditorFormat)vftxtTEL)
     );
     Object vftxtLndry=vftxtAirTkt;//exgui.verification.CellFormat.getIntVerifierAllowNull(38);
      dataBoundGUIs.add(  new exgui.DataBindTextWithChecker(txtLndry,"TVL_FEE_LDRY",recToMapping.get("TVL_FEE_LDRY"),12,(exgui.Object2String)vftxtLndry,(exgui.ultratable.CellTxtEditorFormat)vftxtLndry)
     );
     Object vftxtOther=vftxtAirTkt;//exgui.verification.CellFormat.getIntVerifierAllowNull(38);
      dataBoundGUIs.add(  new exgui.DataBindTextWithChecker(txtOther,"TVL_FEE_OTHER",recToMapping.get("TVL_FEE_OTHER"),12,(exgui.Object2String)vftxtOther,(exgui.ultratable.CellTxtEditorFormat)vftxtOther)
     );

     //decription is from current editing voucher record
     Object vftxtDesc=exgui.verification.CellFormat.getOrdinaryFieldNotAllowNull(4000);
      dataBoundGUIs.add(
      new exgui.DataBindTextWithChecker(txtDesc,"VH_DESC",recToMapping.get("VH_DESC"),4000,(exgui.Object2String)vftxtDesc,(exgui.ultratable.CellTxtEditorFormat)vftxtDesc)
                                        );


    dataBoundGUIs.add(
     new exgui.DataBindTextWithChecker(txtDbAmt,"DB_AMT",
                                       recToMapping.get("DB_AMT"),12,
                                       (exgui.Object2String)vftxtLndry,
                                       (exgui.ultratable.CellTxtEditorFormat)vftxtLndry)
     );

      exgui.DataBindJCombobox DbJcbxcbxQcCountry =
          new exgui.DataBindJCombobox(cbxCountry,
                                      "CNTY",
                                     newtimes.preproduction.guis.tempProperties.tmpCountries,
                                      "CNTY_NAME","CNTY_NAME",
                                      recToMapping.get("CNTY"),"NONE",null);
      dataBoundGUIs.add(DbJcbxcbxQcCountry);
      String poprusStr=(String)recToMapping.get("TVL_PURPOSE");
      cbxPprs.setEditable(true);
      cbxPprs.setSelectedItem((poprusStr==null)?"":poprusStr);
      orgTravelPopurs=poprusStr;
      isInitGui=false;
      Constants.adjFloat(txtDbAmt);
      btnExit.grabFocus();
   }catch(Exception exp){
     exp.printStackTrace();
   }
 }
  public void doPrint(){

  }
  public boolean isContextModified(){
    if(orgTravelPopurs==null)orgTravelPopurs="";
    Object objPprs=cbxPprs.getSelectedItem();
    if(objPprs==null)objPprs="";
    if(!orgTravelPopurs.equals(objPprs))return true;
    return super.isContextModified();
  }
  public boolean  gui2Record(){
     if(!super.gui2Record())return false;
     if(txtFrom.getText().trim().length()==0){
       exgui.verification.VerifyLib.showAlert("請輸入出差起始日","請輸入出差起始日");
       return false;
     }
     if(txtTo.getText().trim().length()==0){
       exgui.verification.VerifyLib.showAlert("請輸入出差終止日","請輸入出差終止日");
       return false;
     }

     if(txtDays.getText().trim().length()==0){
       exgui.verification.VerifyLib.showAlert("請輸入天數","請輸入天數");
       return false;
     }


     if(null==cbxPprs.getSelectedItem()||"".equals(cbxPprs.getSelectedItem().toString().trim())){
       exgui.verification.VerifyLib.showAlert("請選填出差目的","請選填出差目的");
       return false;
     }
     if(null==dbCbxStaff.getSelectedValue()){
       exgui.verification.VerifyLib.showAlert("請取人員代號","請取人員代號");
       return false;
     }
     if(txtDbAmt.getText().trim().length()==0){
       exgui.verification.VerifyLib.showAlert("請填寫總金額","請填寫總金額");
       return false;
     }
     if(txtDesc.getText().trim().length()==0){
       exgui.verification.VerifyLib.showAlert("請填寫說明(Description)欄位","請填寫說明(Description)");
       return false;
     }
     try{
       recToMapping.set("TVL_PURPOSE", cbxPprs.getSelectedItem());
       //set to editing jtable.

       return true;
     }catch(Exception exp){
       exp.printStackTrace();
       util.ExceptionLog.exp2File(exp,"");

       return false;
     }
  }
  void btnOk_actionPerformed(ActionEvent e) {
    //do update processs..
    //updateDescriptionTextField();//skip it.cause sometime,user have to input extra infor before update
    if(!gui2Record()){
      return;
    }else{
      try{
        //write back to parnet's GUI
        int row=Constants.Pnl_Tbl2EditDailyVoucher.getJtable().getSelectedRow();
        Object dc_AMT=recToMapping.get("DB_AMT");
        String strAmt;
        if(null==dc_AMT || dc_AMT.toString().trim().length()==0){
          exgui.verification.VerifyLib.showAlert("請輸入總金額","請輸入總金額");
          return;

        }
        strAmt=dc_AMT.toString();
        if(strAmt.startsWith("-")){
          String intValueAmt=strAmt.substring(1,strAmt.length());
          Constants.Pnl_Tbl2EditDailyVoucher.getJtable().setValueAt(intValueAmt,
              row,Constants.Pnl_Tbl2EditDailyVoucher.CREDIT_AMT_COLUMN_AT);

          Constants.Pnl_Tbl2EditDailyVoucher.getJtable().setValueAt(null,row,
              Constants.Pnl_Tbl2EditDailyVoucher.DEBIT_AMT_COLUMN_AT);

        }else{
          Constants.Pnl_Tbl2EditDailyVoucher.getJtable().setValueAt(strAmt,row,
              Constants.Pnl_Tbl2EditDailyVoucher.DEBIT_AMT_COLUMN_AT);

          Constants.Pnl_Tbl2EditDailyVoucher.getJtable().setValueAt(null,
              row,Constants.Pnl_Tbl2EditDailyVoucher.CREDIT_AMT_COLUMN_AT);

        }
        Constants.Pnl_Tbl2EditDailyVoucher.getJtable().setValueAt(recToMapping.get("VH_DESC"),
            row,Constants.Pnl_Tbl2EditDailyVoucher.DESCRIPTION_COLUMN_AT);
         Constants.Pnl_Tbl2EditDailyVoucher.isContextModified=true;
        //set to database for auditing....
        recToMapping.set("record_modify_user",util.PublicVariable.USER_RECORD.get(0));
        recToMapping.set("record_modify_date",new java.sql.Date(System.currentTimeMillis()));

        //force ejb to handle all columns,cause server side used "delete & insert" to replace the "update" statement
        database.datatype.Record recTest=(database.datatype.Record)util.MiscFunc.deepCopy(recToMapping);
        for(int i=0;i<recToMapping.getFieldName().size();i++){
          recToMapping.set(i,recTest.get(i));
        }
        java.util.Vector vec = new java.util.Vector();
        vec.add(recToMapping);
        dbprc.updateRecords(vec);
        Constants.Pnl_EditDaily_Voucher.update2TotalLabel();
      }catch(Exception exp){
        exp.printStackTrace();
        util.ExceptionLog.exp2File(exp,"");
        exgui.verification.VerifyLib.showAlert("update failed!\nPlease Contact System Manager","update Failed");
      }
      dlgContainer.dispose();
    }
  }

  void btnExit_actionPerformed(ActionEvent e) {
    if(isContextModified()){
      if(!exgui.verification.VerifyLib.showConfirm("Context Modified\nDo You Want To Exit ?","Context Modified",false)) return;
    }
   dlgContainer.dispose();
  }

}

