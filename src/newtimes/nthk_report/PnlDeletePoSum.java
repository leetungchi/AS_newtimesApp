package newtimes.nthk_report;

import java.awt.*;
import exgui.*;
import javax.swing.*;
import java.awt.event.*;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class PnlDeletePoSum
   // extends JPanel {
  extends newtimes.production.report.AbsQryPanel
  implements newtimes.nthk_report.Int_PNL_JINIT {
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel1 = new BlueBkgWhiteCharLabel();
  JLabel jLabel1 = new JLabel();
  JComboBox cbxDep = new JComboBox();
  JLabel jLabel2 = new JLabel();
  JTextField txtProdYear = new JTextField();
  JButton btnQry = new JButton();
  JCheckBox chkBoxDepGrp = new JCheckBox();
  exgui.DataBindJCombobox dbCbxDep=null;
  public PnlDeletePoSum() {
    try {
      //jbInit();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }
 public void genDataBindObj(){
   java.util.Vector depVects=
       newtimes.preproduction.guis.tempProperties.tmpDepartment;
      dbCbxDep =
         new exgui.DataBindJCombobox(
         cbxDep, "DEP_CODE",
         depVects,
         "DEP_NAME", "DEP_CODE",
         null,
         "ALL", "ALL");
       Object objYear=exgui.verification.CellFormat.getIntVerifierAllowNull(4);
       exgui.DataBindTextWithChecker dbTxtProdYear =
          new exgui.DataBindTextWithChecker(txtProdYear, "RTN_DATE",
                                            "",
                                            4, (exgui.Object2String)objYear,
                                            (exgui.ultratable.
                                             CellTxtEditorFormat)objYear);

       java.util.Calendar cld=java.util.Calendar.getInstance();
       int year=cld.get(cld.YEAR);
       txtProdYear.setText(String.valueOf(year));

 }
 public void jbInit() throws Exception {
    blueBkgWhiteCharLabel1.setText("Sum Of Cancelled PO");
    blueBkgWhiteCharLabel1.setBounds(new Rectangle(-1, 10, 801, 27));
    this.setLayout(null);
    jLabel1.setFont(new java.awt.Font("Dialog", 1, 11));
    jLabel1.setText("Department");
    jLabel1.setBounds(new Rectangle(3, 49, 86, 27));
    cbxDep.setBounds(new Rectangle(82, 49, 134, 20));
    jLabel2.setFont(new java.awt.Font("Dialog", 1, 11));
    jLabel2.setText("PROD YEAR");
    jLabel2.setBounds(new Rectangle(252, 49, 94, 20));
    txtProdYear.setText("");
    txtProdYear.setBounds(new Rectangle(337, 49, 109, 24));
    btnQry.setBounds(new Rectangle(680, 51, 97, 24));
    btnQry.setFont(new java.awt.Font("Dialog", 1, 11));
    btnQry.setText("REPORT");
    btnQry.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnQry_actionPerformed(e);
      }
    });
    chkBoxDepGrp.setFont(new java.awt.Font("Dialog", 1, 11));
    chkBoxDepGrp.setText("Group By Dep.");
    chkBoxDepGrp.setBounds(new Rectangle(467, 51, 150, 20));
    this.add(blueBkgWhiteCharLabel1, null);
    this.add(jLabel1, null);
    this.add(cbxDep, null);
    this.add(jLabel2, null);
    this.add(txtProdYear, null);
    this.add(btnQry, null);
    this.add(chkBoxDepGrp, null);
    genDataBindObj();
  }

  public java.util.HashMap composeParameters(){
    java.util.HashMap hm=new java.util.HashMap();
    hm.put("P_CENTER","NTHK");
    if(dbCbxDep.getSelectedValue()==null){
      hm.put("P_DEP","ALL");
    }else{
      hm.put("P_DEP",dbCbxDep.getSelectedValue());
    }
    if(!chkBoxDepGrp.isSelected()){
      reportName="DET_CANCEL.rpt";
    }else{
      reportName="SUM_CANCEL.rpt";
    }
    hm.put("P_PROD_YEAR",txtProdYear.getText());
    return hm;
  }

  void btnQry_actionPerformed(ActionEvent e) {
     if(txtProdYear.getText().trim().length()<4){
       exgui.verification.VerifyLib.showAlert("Please Input Prod Year","Please Input Prod Year");
       return;
     }
     super.JButtonQueryButtonAction(e);
  }
}
