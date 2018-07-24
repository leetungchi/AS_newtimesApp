package newtimes.accounting.debit_note;

import java.awt.*;
import exgui.*;
import javax.swing.*;
import newtimes.preproduction.buyermakerselect.*;
import java.awt.event.*;
import newtimes.production.report.*;
/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class PnlDdkChkBatchList
    //extends JPanel {
    extends AbsQryPanel{
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel1 = new BlueBkgWhiteCharLabel();
  WhiteBkgBlueCharLabel lblCenter1 = new WhiteBkgBlueCharLabel();
  JTextField txtDateFrom = new JTextField();

  JTextField txtDateTo = new JTextField();
  WhiteBkgBlueCharLabel lblCenter2 = new WhiteBkgBlueCharLabel();
  BlueBkgWhiteCharLabel lblDBNO2 = new BlueBkgWhiteCharLabel();
  SelectBuyerMaker slkMaker = new SelectBuyerMaker();
  JButton btnQry = new JButton();
  exgui.DataBindJCombobox dbCbxDep[]=new exgui.DataBindJCombobox[10];
  JComboBox cbxDep[] = new JComboBox[10];
  JComboBox cbxCode = new JComboBox(new String[]{"MAKER DISCOUNT","BUYER COMMISSION"});
  WhiteBkgBlueCharLabel lblCenter3 = new WhiteBkgBlueCharLabel();
  JComboBox cbxBuyerMakerType = new JComboBox(new String[]{"MAKER","BUYER","OTHER"});
  /*
  JComboBox cbxDep = new JComboBox();
  JComboBox cbxDep1 = new JComboBox();
  JComboBox cbxDep2 = new JComboBox();
  JComboBox cbxDep3 = new JComboBox();
  JComboBox cbxDep4 = new JComboBox();
  JComboBox cbxDep5 = new JComboBox();
  JComboBox cbxDep6 = new JComboBox();
  JComboBox cbxDep7 = new JComboBox();
  JComboBox cbxDep8 = new JComboBox();
  JComboBox cbxDep9 = new JComboBox();
  */
  public PnlDdkChkBatchList() {
    try {
      //jbInit();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }

  void jbInit() throws Exception {
    for(int i=0;i<10;i++){
      cbxDep[i] = new JComboBox();
    }
    blueBkgWhiteCharLabel1.setText("DEDUCT CHECK BATCH LIST");
    blueBkgWhiteCharLabel1.setBounds(new Rectangle(-2, 1, 804, 33));
    this.setBackground(new Color(202, 202, 224));
    this.setLayout(null);
    lblCenter1.setBounds(new Rectangle(394, 58, 123, 25));
    lblCenter1.setText("YYYYMM From:");
    txtDateFrom.setText("");
    txtDateFrom.setBounds(new Rectangle(518, 58, 98, 25));
    cbxDep[0].setBounds(new Rectangle(9, 37, 147, 22));
    txtDateTo.setBounds(new Rectangle(662, 58, 122, 25));
    txtDateTo.setText("");
    lblCenter2.setText("TO");
    lblCenter2.setBounds(new Rectangle(615, 58, 46, 25));
    lblDBNO2.setText("BUYER/MAKER");
    lblDBNO2.setBounds(new Rectangle(395, 91, 108, 26));
    slkMaker.setBounds(new Rectangle(614, 91, 176, 23));
    btnQry.setBounds(new Rectangle(684, 125, 105, 28));
    btnQry.setFont(new java.awt.Font("Dialog", 1, 11));
    btnQry.setText("QUERY");
    btnQry.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnQry_actionPerformed(e);
      }
    });
    cbxDep[1].setBounds(new Rectangle(167, 37, 147, 22));
    cbxDep[2].setBounds(new Rectangle(167, 63, 147, 22));
    cbxDep[3].setBounds(new Rectangle(9, 63, 147, 22));
    cbxDep[4].setBounds(new Rectangle(167, 89, 147, 22));
    cbxDep[5].setBounds(new Rectangle(9, 89, 147, 22));
    cbxDep[6].setBounds(new Rectangle(167, 114, 147, 22));
    cbxDep[7].setBounds(new Rectangle(9, 114, 147, 22));
    cbxDep[8].setBounds(new Rectangle(167, 140, 147, 22));
    cbxDep[9].setBounds(new Rectangle(9, 140, 147, 22));
    cbxCode.setBounds(new Rectangle(457, 125, 211, 25));
    lblCenter3.setBounds(new Rectangle(395, 125, 60, 22));
    lblCenter3.setText("TYPE");
    cbxBuyerMakerType.setBounds(new Rectangle(502, 91, 108, 23));
    cbxBuyerMakerType.addItemListener(new java.awt.event.ItemListener() {
      public void itemStateChanged(ItemEvent e) {
        cbxBuyerMakerType_itemStateChanged(e);
      }
    });
    this.add(lblCenter1, null);
    this.add(txtDateFrom, null);
    this.add(lblCenter2, null);
    this.add(txtDateTo, null);
    this.add(lblDBNO2, null);
    this.add(blueBkgWhiteCharLabel1, null);
    this.add(cbxCode, null);
    this.add(lblCenter3, null);
    this.add(btnQry, null);
    this.add(slkMaker, null);
    this.add(cbxBuyerMakerType, null);
    this.add(cbxDep[0], null);
    this.add(cbxDep[1], null);
    this.add(cbxDep[2], null);
    this.add(cbxDep[3], null);
    this.add(cbxDep[4], null);
    this.add(cbxDep[5], null);
    this.add(cbxDep[6], null);
    this.add(cbxDep[7], null);
    this.add(cbxDep[8], null);
    this.add(cbxDep[9], null);
    slkMaker.init("MAKER",null,slkMaker.TYPE_MAKER,true);
    genDataBindObj();

  }
  public void genDataBindObj(){
    for(int i=0;i<10;i++){
      dbCbxDep[i] =
          new exgui.DataBindJCombobox(
          cbxDep[i], "",
          newtimes.preproduction.guis.tempProperties.tmpDepartment,
          "DEP_NAME", "DEP_CODE",
          null, "", null);
    }

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


    reportName="DBNO_DEDUCT.rpt";
  }
  public boolean isDateOk(){
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
      return true;
  }

  public java.util.HashMap composeParameters(){
    java.util.HashMap hm=new java.util.HashMap();
    StringBuffer sbDep=new StringBuffer();
    System.out.println("dbCbxDep[0].getSelectedValue()"+dbCbxDep[0].getSelectedValue());
    for(int i=0;i<10;i++){
      String depValue=(String)dbCbxDep[i].getSelectedValue();
      if(depValue!=null){
        if (sbDep.length() > 0)sbDep.append(",");
        sbDep.append("'");
        sbDep.append(depValue);
        sbDep.append("'");
      }
    }
    System.out.println("["+sbDep.toString()+"]");
    if(sbDep.length()>0){
      hm.put("P_DEP","["+sbDep.toString()+"]");
    }else{
      hm.put("P_DEP","['ALL']");
    }
    //hm.put("P_DEP",(dbcbxDep.getSelectedValue()==null)?"ALL":dbcbxDep.getSelectedValue());

    hm.put("P_FTY",(slkMaker.getSelectedValue()==null)?"0":slkMaker.getSelectedValue().toString());
    if(txtDateFrom.getText().trim().length()>0) {hm.put("P_FM_DD",txtDateFrom.getText().trim());
    }else{
      hm.put("P_FM_DD", "200501");
    }
    if(txtDateTo.getText().trim().length()>0) {
      hm.put("P_TO_DD",txtDateTo.getText().trim());
    }else{
      java.util.Calendar cld=java.util.Calendar.getInstance();
      int year=cld.get(cld.YEAR);
      hm.put("P_TO_DD", String.valueOf(year)+"12");
    }
    hm.put("P_CENTER",util.PublicVariable.OPERATTING_CENTER);
    hm.put("P_CODE",cbxCode.getSelectedItem().equals("MAKER DISCOUNT")?"M":"B");
    return hm;
  }
  void btnQry_actionPerformed(ActionEvent e) {
    if(!isDateOk())return;
    super.JButtonQueryButtonAction(e);
  }

  void cbxBuyerMakerType_itemStateChanged(ItemEvent e) {
    slkMaker.init("",null,
                          Integer.parseInt(
                           (String)
                           newtimes.accounting.debit_note.Constans.hmBuyerMakerType.get(cbxBuyerMakerType.getSelectedItem())
                           ),true);

  }
}
