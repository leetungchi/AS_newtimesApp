package newtimes.accounting.debit_note;

import java.awt.*;
import exgui.*;
import javax.swing.*;
import java.awt.event.*;
import newtimes.preproduction.buyermakerselect.*;
import newtimes.accounting.debit_note.PnlQryDebitNote;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class PnlQryDDK extends JPanel implements
   newtimes.preproduction.buyermakerselect.BuyerMakerChanged  {
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel1 = new BlueBkgWhiteCharLabel();
  JComboBox cbxBuyerMakerType = new JComboBox(new String[]{"BUYER","MAKER","OTHER"});
  BlueBkgWhiteCharLabel lblDBNO1 = new BlueBkgWhiteCharLabel();
  WhiteBkgBlueCharLabel lblCenter1 = new WhiteBkgBlueCharLabel();
  WhiteBkgBlueCharLabel lblCenter4 = new WhiteBkgBlueCharLabel();
  JTextField txtDateFrom = new JTextField();
  WhiteBkgBlueCharLabel lblCenter = new WhiteBkgBlueCharLabel();
  SelectBuyerMaker selectBuyerMaker = new SelectBuyerMaker();
  WhiteBkgBlueCharLabel lblCenterContext = new WhiteBkgBlueCharLabel();
  JComboBox cbxDep = new JComboBox();
  JTextField txtDateTo = new JTextField();
  WhiteBkgBlueCharLabel lblCenter2 = new WhiteBkgBlueCharLabel();
  JButton btnQry = new JButton();
  JButton btnExit = new JButton();
  exgui.DataBindJCombobox dbCbxDep,DbJcbxBuyerName;
  String centerCode=null,centerName=null;
  public PnlQryDDK() {
    try {
      database.datatype.Record recCen=newtimes.accounting.debit_note.Constans.recGetCenterRec(util.PublicVariable.OPERATTING_CENTER);
      centerCode=util.PublicVariable.OPERATTING_CENTER;
      centerCode=(String)recCen.get(1);
      jbInit();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }

  void jbInit() throws Exception {
    blueBkgWhiteCharLabel1.setToolTipText("");
    blueBkgWhiteCharLabel1.setText("DEDUCT MAINTENANCE");
    blueBkgWhiteCharLabel1.setBounds(new Rectangle(-2, 30, 801, 31));
    this.setBackground(new Color(202, 202, 224));
    this.setLayout(null);
    cbxBuyerMakerType.setBounds(new Rectangle(347, 201, 103, 26));
    cbxBuyerMakerType.addItemListener(new java.awt.event.ItemListener() {
      public void itemStateChanged(ItemEvent e) {
        cbxBuyerMakerType_itemStateChanged(e);
      }
    });
    lblDBNO1.setBounds(new Rectangle(223, 316, 123, 26));
    lblDBNO1.setText("DEP. :");
    lblCenter1.setBounds(new Rectangle(223, 279, 123, 25));
    lblCenter1.setText("YYYYMM From:");
    lblCenter4.setText("BUYER / MAKER");
    lblCenter4.setBounds(new Rectangle(223, 203, 123, 25));
    txtDateFrom.setText("");
    txtDateFrom.setBounds(new Rectangle(348, 278, 98, 25));
    lblCenter.setText("CENTER:");
    lblCenter.setBounds(new Rectangle(223, 127, 123, 25));
    selectBuyerMaker.setBounds(new Rectangle(453, 201, 161, 26));
    lblCenterContext.setBounds(new Rectangle(345, 127, 269, 25));
    lblCenterContext.setText("TAIPEI");
    cbxDep.setBounds(new Rectangle(348, 316, 268, 26));
    txtDateTo.setBounds(new Rectangle(492, 278, 122, 25));
    txtDateTo.setText("");
    lblCenter2.setText("TO");
    lblCenter2.setBounds(new Rectangle(445, 278, 46, 25));
    btnQry.setBounds(new Rectangle(205, 412, 103, 29));
    btnQry.setFont(new java.awt.Font("Dialog", 1, 11));
    btnQry.setText("QUERY");
    btnQry.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnQry_actionPerformed(e);
      }
    });
    btnExit.setText("EXIT");
    btnExit.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnExit_actionPerformed(e);
      }
    });
    btnExit.setBounds(new Rectangle(555, 412, 103, 29));
    btnExit.setFont(new java.awt.Font("Dialog", 1, 11));
    lblDBNO2.setText("TYPE :");
    lblDBNO2.setBounds(new Rectangle(223, 164, 123, 26));
    cbxType.setBounds(new Rectangle(345, 164, 268, 26));
    cbxBuyerName.setBounds(new Rectangle(345, 240, 268, 26));
    lblDBNO3.setBounds(new Rectangle(223, 240, 123, 26));
    lblDBNO3.setText("BUYER NAME:");
    this.add(blueBkgWhiteCharLabel1, null);
    this.add(cbxBuyerMakerType, null);
    this.add(lblCenter4, null);
    this.add(lblCenter, null);
    this.add(selectBuyerMaker, null);
    this.add(lblCenterContext, null);
    this.add(btnQry, null);
    this.add(btnExit, null);
    this.add(lblDBNO2, null);
    this.add(cbxType, null);
    this.add(lblDBNO1, null);
    this.add(lblCenter1, null);
    this.add(txtDateFrom, null);
    this.add(lblCenter2, null);
    this.add(txtDateTo, null);
    this.add(cbxDep, null);
    this.add(cbxBuyerName, null);
    this.add(lblDBNO3, null);
    selectBuyerMaker.init("", null, selectBuyerMaker.TYPE_BUYER, true);
    selectBuyerMaker.setModifyNotifyTo(this);
    String centerName=
    (String)((database.datatype.Record)Constans.recGetCenterRec(util.PublicVariable.OPERATTING_CENTER)).get(1);
    lblCenterContext.setText(centerName);
    cbxBuyerName.setEditable(true);

    dbCbxDep=
       new exgui.DataBindJCombobox(
            cbxDep,"",newtimes.preproduction.guis.tempProperties.tmpDepartment,
            "DEP_NAME", "DEP_PREFIX",null,"ALL",null);



        Object vftxtYearMonth = exgui.verification.CellFormat.getIntVerifierAllowNull(6);
        //java.util.Calendar cldr=java.util.Calendar.getInstance();
        new exgui.DataBindTextWithChecker(txtDateFrom, "_YEAR",
                                          "", 6,
                                          (exgui.Object2String)vftxtYearMonth,
                                          (exgui.ultratable.CellTxtEditorFormat)
                                          vftxtYearMonth);
        new exgui.DataBindTextWithChecker(txtDateTo, "_YEAR",
                                          "", 6,
                                          (exgui.Object2String)vftxtYearMonth,
                                          (exgui.ultratable.CellTxtEditorFormat)
                                          vftxtYearMonth);
        initBuyerNameCbx("",-1,true);

  }
  public void changeBuyerMaker(database.datatype.Record recBuyer){

    initBuyerNameCbx("",(recBuyer==null)?-1:recBuyer.getInt(0),recBuyer==null);
  }
  private void initBuyerNameCbx(String valueInit,int bymkrseq,boolean isNull){
    try{
    java.util.Vector vct=
        (isNull)?new java.util.Vector():
         exgui2.CONST.BASIC_MAIN_EJB.getDatas(
         util.PublicVariable.USER_RECORD,
         "select dbnt_bymkr_name from debitnote_bymkr_name where record_delete_flag='1' and dbnt_bymkr_seq="+
           String.valueOf(bymkrseq),
          1,9999);

    DbJcbxBuyerName=
        new exgui.DataBindEditableJCombobox(
                          cbxBuyerName,"DBNT_BYMKR_NAME",
                          vct,
                          "DBNT_BYMKR_NAME","DBNT_BYMKR_NAME",
                          valueInit,60);
      //dataBoundGUIs.add(buyerNameInputIndex,DbJcbxBuyerName);
    }catch(Exception exp){
      exp.printStackTrace();
    }

  }

  protected boolean ComposeCondition(){
    if(txtDateFrom.getText().trim().length()==0){
      exgui.verification.VerifyLib.showAlert("Please Input ETD FROM DATE",
                                             "Please Input ETD FROM DATE");
      return false;
    }
    if(txtDateTo.getText().trim().length()==0){
      exgui.verification.VerifyLib.showAlert("Please Input ETD END DATE",
                                             "Please Input ETD END DATE");
      return false;
    }

    newtimes.accounting.debit_note.Constans.DRCR_QRY_HEAD_CONDITION.clear();
    //if false,means have formate error.
    if(txtDateFrom.getText().trim().length()>0){
      if(txtDateFrom.getText().trim().length()<6){
        exgui.verification.VerifyLib.showAlert("DATE FORMATE IS YYYYMM","DATE FORMATE IS YYYYMM");
        txtDateFrom.grabFocus();
        txtDateFrom.selectAll();
        return false;
      }
      if(Integer.parseInt(txtDateFrom.getText().trim().substring(0,4))<2005){
        exgui.verification.VerifyLib.showAlert("YEAR CAN NOT LESS THAN 2005","YEAR CAN NOT LESS THAN 2005");
        txtDateFrom.grabFocus();
        txtDateFrom.selectAll();
        return false;
      }
      if(Integer.parseInt(txtDateFrom.getText().trim().substring(4,6))<1||
         Integer.parseInt(txtDateFrom.getText().trim().substring(4,6))>12){
        exgui.verification.VerifyLib.showAlert("MONTH RANGE 01~12 ","MONTH RANGE ERROR");
        txtDateFrom.grabFocus();
        txtDateFrom.selectAll();
        return false;
      }
    }

      if(txtDateFrom.getText().trim().length()>0){
        newtimes.accounting.debit_note.Constans.DRCR_QRY_HEAD_CONDITION.put(PnlQryDebitNote.CONDITION_DATE_FROM,txtDateFrom.getText().trim());
      }
     if(txtDateTo.getText().trim().length()>0){
       if (txtDateTo.getText().trim().length() < 6) {
         exgui.verification.VerifyLib.showAlert("DATE FORMATE IS YYYYMM",
                                                "DATE FORMATE IS YYYYMM");
         txtDateTo.grabFocus();
         txtDateTo.selectAll();
         return false;
       }
       if (Integer.parseInt(txtDateTo.getText().trim().substring(0, 4)) < 2005) {
         exgui.verification.VerifyLib.showAlert("YEAR CAN NOT LESS THAN 2005",
                                                "YEAR CAN NOT LESS THAN 2005");
         txtDateTo.grabFocus();
         txtDateTo.selectAll();
         return false;
       }
       if (Integer.parseInt(txtDateTo.getText().trim().substring(4, 6)) < 1 ||
           Integer.parseInt(txtDateTo.getText().trim().substring(4, 6)) > 12) {
         exgui.verification.VerifyLib.showAlert("MONTH RANGE 01~12 ",
                                                "MONTH RANGE ERROR");
         txtDateTo.grabFocus();
         txtDateTo.selectAll();
         return false;
       }
     }
      if(txtDateFrom.getText().trim().length()>0 &&
         txtDateTo.getText().trim().length()>0 ){
         if(Integer.parseInt(txtDateFrom.getText().trim())>
            Integer.parseInt(txtDateTo.getText().trim())){
           exgui.verification.VerifyLib.showAlert("\"From\" Date Can Not After \"To\" Date","Date Compare Error");
           return false;
         }
      }
      if(txtDateTo.getText().trim().length()>0){
        newtimes.accounting.debit_note.Constans.DRCR_QRY_HEAD_CONDITION.put(PnlQryDebitNote.CONDITION_DATE_TO,txtDateTo.getText().trim());
      }
      if(dbCbxDep.getSelectedValue()!=null){
        newtimes.accounting.debit_note.Constans.DRCR_QRY_HEAD_CONDITION.put(
          PnlQryDebitNote.CONDITION_DEPT,
          dbCbxDep.getSelectedValue());
      }
      if(selectBuyerMaker.getSelectedValue()!=null){
        newtimes.accounting.debit_note.Constans.DRCR_QRY_HEAD_CONDITION.put(
          PnlQryDebitNote.CONDITION_BUYER_MAKER ,
          selectBuyerMaker.getSelectedValue().toString());
      }
      newtimes.accounting.debit_note.Constans.DRCR_QRY_HEAD_CONDITION.put(
        PnlQryDebitNote.CONDITION_TYPE,
        cbxType.getSelectedItem().equals("MAKER")?"M":"B");
     if(null!=DbJcbxBuyerName.getSelectedValue() &&
        DbJcbxBuyerName.getSelectedValue().toString().trim().length()>0){
       newtimes.accounting.debit_note.Constans.DRCR_QRY_HEAD_CONDITION.put(
         PnlQryDebitNote.CONDITION_BUYER_MAKER_NAME,
         DbJcbxBuyerName.getSelectedValue().toString().trim());
     }

    return true;
  }

  void cbxBuyerMakerType_itemStateChanged(ItemEvent e) {

    selectBuyerMaker.init("",null,
                          Integer.parseInt(
                           (String)
                           newtimes.accounting.debit_note.Constans.hmBuyerMakerType.get(cbxBuyerMakerType.getSelectedItem())
                           ),true);
    initBuyerNameCbx("",-1,true);

  }

  void btnExit_actionPerformed(ActionEvent e) {
    try{
      processhandler.template.Properties.getCenteralControler().goBack();
    }catch(Exception exp){
      exp.printStackTrace();
    }
  }

  void btnQry_actionPerformed(ActionEvent e) {
     if(!ComposeCondition())return;
     try{
       processhandler.template.Properties.getCenteralControler().doCommandExecute(
       new TgrListQryDDK());
     }catch(Exception exp){
       exp.printStackTrace();
     }

  }
  BlueBkgWhiteCharLabel lblDBNO2 = new BlueBkgWhiteCharLabel();
  JComboBox cbxType = new JComboBox(new String[]{"BUYER","MAKER"});
  JComboBox cbxBuyerName = new JComboBox();
  BlueBkgWhiteCharLabel lblDBNO3 = new BlueBkgWhiteCharLabel();
}
