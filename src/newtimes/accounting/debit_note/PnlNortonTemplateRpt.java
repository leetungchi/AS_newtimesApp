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

public class PnlNortonTemplateRpt
    //extends JPanel {
    extends AbsQryPanel{
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel1 = new BlueBkgWhiteCharLabel();
  WhiteBkgBlueCharLabel lblCenter1 = new WhiteBkgBlueCharLabel();
  JTextField txtDateFrom = new JTextField();
  JTextField txtDateTo = new JTextField();
  WhiteBkgBlueCharLabel lblCenter2 = new WhiteBkgBlueCharLabel();
  JButton btnQry = new JButton();
  exgui.DataBindTextWithChecker dbTxtFrom,dbTxtEnd;
  public PnlNortonTemplateRpt() {
    try {
      jbInit();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }

  void jbInit() throws Exception {
    blueBkgWhiteCharLabel1.setText("NORTON TEMPLATE");
    blueBkgWhiteCharLabel1.setBounds(new Rectangle(-2, 2, 804, 31));
    this.setBackground(new Color(202, 202, 224));
    this.setLayout(null);
    lblCenter1.setBounds(new Rectangle(17, 45, 198, 25));
    lblCenter1.setText("D/B Create  From:");
    txtDateFrom.setBounds(new Rectangle(215, 45, 98, 25));
    txtDateTo.setBounds(new Rectangle(359, 45, 122, 25));
    txtDateTo.setText("");
    lblCenter2.setText("TO");
    lblCenter2.setBounds(new Rectangle(312, 45, 46, 25));
    btnQry.setBounds(new Rectangle(659, 45, 105, 28));
    btnQry.setFont(new java.awt.Font("Dialog", 1, 11));
    btnQry.setText("PRINT");
    btnQry.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnQry_actionPerformed(e);
      }
    });
    this.add(blueBkgWhiteCharLabel1, null);
    this.add(lblCenter1, null);
    this.add(txtDateFrom, null);
    this.add(lblCenter2, null);
    this.add(txtDateTo, null);
    this.add(btnQry, null);
    genDataBindObj();

  }
  public void genDataBindObj(){
     dataBindComps.clear();
       Object vftxtYearMonth = exgui.verification.CellFormat.getDateStringFormaterAllowNull();
       //java.util.Calendar cldr=java.util.Calendar.getInstance();
      dbTxtFrom= new exgui.DataBindTextWithChecker(txtDateFrom, "P_CR_FM",
                                         null, 18,
                                         (exgui.Object2String)vftxtYearMonth,
                                         (exgui.ultratable.CellTxtEditorFormat)
                                         vftxtYearMonth);
      dbTxtEnd= new exgui.DataBindTextWithChecker(txtDateTo, "P_CR_TO",
                                         null, 18,
                                         (exgui.Object2String)vftxtYearMonth,
                                         (exgui.ultratable.CellTxtEditorFormat)
                                         vftxtYearMonth);

    dataBindComps.add(dbTxtFrom);
    dataBindComps.add(dbTxtEnd);
    reportName="DB_NORTON_TEMP.rpt";
  }
  public boolean isDateOk(){
      if(dbTxtEnd.getSelectedValue() !=null &&
         dbTxtFrom.getSelectedValue() !=null ){
        if(((java.util.Date)dbTxtEnd.getSelectedValue()).before(
        (java.util.Date)dbTxtFrom.getSelectedValue())){
          exgui.verification.VerifyLib.showAlert("Begin  Date Should Before End Date",
                                                 "Begin  Date Should Before End Date");
          return false;
        }
      }
      return true;
  }

  public java.util.HashMap composeParameters(){
    java.util.HashMap hm=super.composeParameters();//new java.util.HashMap();
    if(dbTxtEnd.getSelectedValue()==null){
          hm.put(dbTxtEnd.getOrgRecField(),
                 super.convertDate2QueryPara(new
                 java.sql.Date(util.MiscFunc.toDate(2099, 12, 31).getTime()
                 )));
    }

    if(dbTxtFrom.getSelectedValue()==null){
          hm.put(dbTxtFrom.getOrgRecField(),
                 super.convertDate2QueryPara(new
                 java.sql.Date(util.MiscFunc.toDate(2000, 1, 1).getTime()
                 )));
    }

    /*
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
    */
    hm.put("P_CENTER",util.PublicVariable.OPERATTING_CENTER);
    return hm;
  }
  void btnQry_actionPerformed(ActionEvent e) {
    if(!isDateOk())return;
    super.JButtonQueryButtonAction(e);
  }
}
