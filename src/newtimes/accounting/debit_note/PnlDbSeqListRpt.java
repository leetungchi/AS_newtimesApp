package newtimes.accounting.debit_note;

import java.awt.*;
import exgui.*;
import javax.swing.*;
import java.awt.event.*;
import newtimes.preproduction.buyermakerselect.*;
import javax.swing.border.*;
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

public class PnlDbSeqListRpt
     //extends JPanel {
     extends AbsQryPanel{

  BlueBkgWhiteCharLabel lblDBNO1 = new BlueBkgWhiteCharLabel();
  WhiteBkgBlueCharLabel lblCenter1 = new WhiteBkgBlueCharLabel();
  JTextField txtDateFrom = new JTextField();
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel1 = new BlueBkgWhiteCharLabel();
  JComboBox cbxDep = new JComboBox();
  JTextField txtDateTo = new JTextField();
  WhiteBkgBlueCharLabel lblCenter2 = new WhiteBkgBlueCharLabel();
  JButton jButton1 = new JButton();
  exgui.DataBindJCombobox dbCbxDep;
  BlueBkgWhiteCharLabel lblDBNO2 = new BlueBkgWhiteCharLabel();
  static String DrCrTypeValue[]={"","D","C","B","M"};
  static String DrCrTypeString[]={"","DEBIT","CREDIT","BUYER COMMISSION","MAKER COMMISSION"};
  exgui.ultratable.Wraper4tblCbx DrCrType[]=new exgui.ultratable.Wraper4tblCbx[5];
  JComboBox cbxType = new JComboBox();
  JComboBox cbxSortBy = new JComboBox(new String[]{"BUYER","D/B NO"});
  BlueBkgWhiteCharLabel lblDBNO3 = new BlueBkgWhiteCharLabel();
  public PnlDbSeqListRpt() {
    try {
      jbInit();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }
  public void genDataBindObj(){
    super.dataBindComps.clear();
    dbCbxDep =
        new exgui.DataBindJCombobox(
        cbxDep, "P_DEP",
        newtimes.preproduction.guis.tempProperties.tmpDepartment,
        "DEP_NAME", "DEP_CODE",
        "ALL", "", "ALL");
    dataBindComps.add(dbCbxDep);



    try {

      Object vftxtYearMonth = exgui.verification.CellFormat.
          getIntVerifierAllowNull(6);
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

    }catch(Exception exp){
       exp.printStackTrace();
    }
  }
  void jbInit() throws Exception {
    for(int i=0;i<5;i++){
         DrCrType[i]=new exgui.ultratable.Wraper4tblCbx();
         DrCrType[i].setValue(DrCrTypeValue[i]);
         DrCrType[i].setString(DrCrTypeString[i]);
      }
    cbxType.setModel(new javax.swing.DefaultComboBoxModel(DrCrType));

    lblCenter2.setText("TO");
    lblCenter2.setBounds(new Rectangle(346, 36, 24, 25));
    txtDateTo.setBounds(new Rectangle(369, 36, 75, 25));
    txtDateTo.setText("");
    cbxDep.setBounds(new Rectangle(60, 36, 113, 26));
    blueBkgWhiteCharLabel1.setBounds(new Rectangle(0, 3, 837, 31));
    blueBkgWhiteCharLabel1.setRequestFocusEnabled(true);
    blueBkgWhiteCharLabel1.setText("DEBITNOTE SEQUENCIAL LIST");
    txtDateFrom.setBounds(new Rectangle(275, 36, 71, 25));
    txtDateFrom.setText("");
    lblCenter1.setBounds(new Rectangle(178, 36, 96, 25));
    lblCenter1.setText(" YYYYMM From:");
    lblCenter1.setHorizontalAlignment(SwingConstants.LEADING);
    lblDBNO1.setBounds(new Rectangle(4, 36, 57, 26));
    lblDBNO1.setText("DEP. :");
    this.setLayout(null);
    jButton1.setBounds(new Rectangle(673, 44, 90, 23));
    jButton1.setFont(new java.awt.Font("Dialog", 1, 11));
    jButton1.setText("REPORT");
    jButton1.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        jButton1_actionPerformed(e);
      }
    });
    lblDBNO2.setText("TYPE :");
    lblDBNO2.setBounds(new Rectangle(463, 36, 57, 26));
    cbxType.setBounds(new Rectangle(519, 36, 141, 26));
    cbxSortBy.setBounds(new Rectangle(75, 72, 126, 26));
    //cbxSortBy.setModel(new javax.swing.DefaultComboBoxModel(DrCrType));
    lblDBNO3.setBounds(new Rectangle(4, 72, 71, 26));
    lblDBNO3.setText("SORT BY:");
    this.add(blueBkgWhiteCharLabel1, null);
    this.add(cbxSortBy, null);
    this.add(lblDBNO1, null);
    this.add(cbxDep, null);
    this.add(lblCenter1, null);
    this.add(txtDateFrom, null);
    this.add(lblCenter2, null);
    this.add(txtDateTo, null);
    this.add(lblDBNO2, null);
    this.add(cbxType, null);
    this.add(jButton1, null);
    this.add(lblDBNO3, null);
    genDataBindObj();
    reportName="db_seq_lst.rpt";
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
    java.util.HashMap hm=super.composeParameters();
    hm.put("P_YM_FM",(txtDateFrom.getText().trim().length()==0)?"200501":txtDateFrom.getText().trim());
    hm.put("P_YM_TO",(txtDateTo.getText().trim().length()==0)?"209912":txtDateTo.getText().trim());
    hm.put("P_CENTER",util.PublicVariable.OPERATTING_CENTER);
    String type=(String)((exgui.ultratable.Wraper4tblCbx)cbxType.getSelectedItem()).getValue();
    hm.put("P_TYPE",(type.trim().length()==0)?"ALL":type);
    hm.put("P_SORT",cbxSortBy.getSelectedItem().toString().substring(0,1));
    return hm;
  }

  void jButton1_actionPerformed(ActionEvent e) {
    if(!isDateOk())return;
    super.JButtonQueryButtonAction(e);
  }

}
