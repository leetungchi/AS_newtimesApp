package newtimes.bank;

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

public class PnlRptChkDtl
    //extends JPanel {
      extends AbsQryPanel{
  JTextField txtPayDateTo = new JTextField();
  JTextField txtPayDateFrom = new JTextField();
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel7 = new BlueBkgWhiteCharLabel();
  JComboBox cbxPayeeItem = new JComboBox();
  JComboBox cbxSort = new JComboBox();
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel4 = new BlueBkgWhiteCharLabel();
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel8 = new BlueBkgWhiteCharLabel();
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel10 = new BlueBkgWhiteCharLabel();
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel6 = new BlueBkgWhiteCharLabel();
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel3 = new BlueBkgWhiteCharLabel();
  JLabel lbl = new JLabel();
  JTextField txtCheckNO = new JTextField();
  JComboBox cbxBank = new JComboBox();
  JTextField txtDC = new JTextField();
  JComboBox cbxCompany = new JComboBox();
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel2 = new BlueBkgWhiteCharLabel();
  WhiteBkgBlueCharLabel whiteBkgBlueCharLabel1 = new WhiteBkgBlueCharLabel();
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel11 = new BlueBkgWhiteCharLabel();
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel12 = new BlueBkgWhiteCharLabel();
  JTextField txtCreateDateTo = new JTextField();
  JTextField txtCreateDateFrom = new JTextField();
  JButton btnPrint = new JButton();
   exgui.DataBindEditableJCombobox dbCbxPayee;
    exgui.DataBindEditableJCombobox dbCbxSort;
   exgui.DataBindJCombobox DbJcbxcbxCompany,DbJcbxcbxBank;
   exgui.DataBindTextWithChecker dbTxtPayDateFrom,dbTxtPayDateTo,dbTxtCreateDateFrom,dbTxtCreateDateTo;

  public PnlRptChkDtl() {
    try {
      //jbInit();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }

  void jbInit() throws Exception {
    blueBkgWhiteCharLabel2.setBounds(new Rectangle(4, 48, 113, 23));
    blueBkgWhiteCharLabel2.setText("COMPANY:");
    cbxCompany.addItemListener(new java.awt.event.ItemListener() {
      public void itemStateChanged(ItemEvent e) {
        cbxCompany_itemStateChanged(e);
      }
    });
    cbxCompany.setBounds(new Rectangle(117, 48, 123, 22));
    txtDC.setText("");
    txtDC.setBounds(new Rectangle(728, 48, 51, 23));
    cbxBank.setBounds(new Rectangle(317, 48, 132, 22));
    txtCheckNO.setBounds(new Rectangle(547, 48, 129, 23));
    txtCheckNO.setText("");
    blueBkgWhiteCharLabel3.setText("BANK:");
    blueBkgWhiteCharLabel3.setBounds(new Rectangle(243, 48, 73, 23));
    blueBkgWhiteCharLabel6.setBounds(new Rectangle(133, 74, 33, 23));
    blueBkgWhiteCharLabel6.setText("~");
    blueBkgWhiteCharLabel10.setText("PAYEE");
    blueBkgWhiteCharLabel10.setBounds(new Rectangle(455, 74, 74, 23));
    blueBkgWhiteCharLabel8.setText("D / C");
    blueBkgWhiteCharLabel8.setBounds(new Rectangle(682, 48, 47, 23));
    blueBkgWhiteCharLabel4.setBounds(new Rectangle(456, 48, 90, 23));
    blueBkgWhiteCharLabel4.setText("CHECK NO . ");
    cbxPayeeItem.setBounds(new Rectangle(528, 74, 202, 22));
    cbxSort.setBounds(new Rectangle(528,102,100,23));
    lbl.setText("Sort By :");
    lbl.setBounds(new Rectangle(480,105,100,17));
    cbxPayeeItem.setEditable(true);
    cbxPayeeItem.setBounds(new Rectangle(529, 74, 251, 22));
    cbxPayeeItem.addItemListener(new java.awt.event.ItemListener() {
      public void itemStateChanged(ItemEvent e) {
        cbxPayeeItem_itemStateChanged(e);
      }
    });
    blueBkgWhiteCharLabel7.setBounds(new Rectangle(4, 74, 72, 23));
    blueBkgWhiteCharLabel7.setText("PAY-DD");
    txtPayDateFrom.setBounds(new Rectangle(76, 74, 58, 23));
    txtPayDateFrom.setText("");
    txtPayDateTo.setText("");
    txtPayDateTo.setBounds(new Rectangle(166, 74, 58, 23));
    this.setLayout(null);
    this.setBackground(new Color(202, 202, 224));
    whiteBkgBlueCharLabel1.setText("CHECK DETAIL REPORT");
    whiteBkgBlueCharLabel1.setBounds(new Rectangle(-2, 10, 804, 28));
    blueBkgWhiteCharLabel11.setBounds(new Rectangle(4, 101, 225, 23));
    blueBkgWhiteCharLabel11.setText("CREATE DATE   (YYYY/MM/DD)");
    blueBkgWhiteCharLabel12.setBounds(new Rectangle(306, 101, 29, 23));
    blueBkgWhiteCharLabel12.setText("~");
    txtCreateDateTo.setText("");
    txtCreateDateTo.setBounds(new Rectangle(335, 101, 76, 23));
    txtCreateDateFrom.setText("");
    txtCreateDateFrom.setBounds(new Rectangle(230, 101, 76, 23));
    btnPrint.setBounds(new Rectangle(627, 101, 149, 27));
    btnPrint.setFont(new java.awt.Font("Dialog", 1, 11));
    btnPrint.setText("PRINT");
    btnPrint.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnPrint_actionPerformed(e);
      }
    });
    this.add(cbxBank, null);
    this.add(blueBkgWhiteCharLabel2, null);
    this.add(cbxCompany, null);
    this.add(blueBkgWhiteCharLabel3, null);
    this.add(whiteBkgBlueCharLabel1, null);
    this.add(blueBkgWhiteCharLabel4, null);
    this.add(txtCheckNO, null);
    this.add(blueBkgWhiteCharLabel8, null);
    this.add(txtDC, null);
    this.add(blueBkgWhiteCharLabel10, null);
    this.add(cbxPayeeItem, null);
    this.add(cbxSort);
    this.add(lbl);
    this.add(blueBkgWhiteCharLabel11, null);
    this.add(blueBkgWhiteCharLabel12, null);
    this.add(txtCreateDateFrom, null);
    this.add(txtCreateDateTo, null);
    this.add(btnPrint, null);
    this.add(blueBkgWhiteCharLabel7, null);
    this.add(blueBkgWhiteCharLabel6, null);
    this.add(txtPayDateFrom, null);
    this.add(txtPayDateTo, null);
    genDataBindObj();
    super.reportName="check_detail.rpt";
  }
  public void genDataBindObj(){
    try{
      super.dataBindComps.clear();
      java.util.Vector vctCompany = Constants.vctCompany;
      Object vftxtChkDD=RocDateFormator.getRocDateFormat();
      DbJcbxcbxCompany =
          new exgui.DataBindJCombobox(cbxCompany,"P_COMP",
                                      vctCompany,
                                      "COMPANY_NAME",
                                      "COMPANY_CODE", "ALL", "ALL", "ALL");
     dataBindComps.add(DbJcbxcbxCompany);

      java.util.Vector vctBanks = Constants.vctBank;
      DbJcbxcbxBank =
          new exgui.DataBindJCombobox(cbxBank, "P_BANK",
                                      vctBanks, "BANK_NAME", "BANK_CODE", "ALL",
                                      "ALL", "ALL");
     dataBindComps.add(DbJcbxcbxBank);

    Object vftxtCheckNO = exgui.verification.CellFormat.getOrdinaryField(10);
     dataBindComps.add(
      new exgui.DataBindTextWithChecker(txtCheckNO, "P_CHK_NO",
          null, 10,
          (exgui.Object2String)vftxtCheckNO,
                        (exgui.ultratable.CellTxtEditorFormat)vftxtCheckNO)
      );


     Object dateVfy=exgui.verification.CellFormat.getDateStringFormaterAllowNull();

     java.sql.Date now=new java.sql.Date(System.currentTimeMillis());
     dbTxtCreateDateFrom= new exgui.DataBindTextWithChecker(txtCreateDateFrom,
          "P_CR_FM",
          now, 10,
          (exgui.Object2String)dateVfy,
                        (exgui.ultratable.CellTxtEditorFormat)dateVfy);

     dataBindComps.add(dbTxtCreateDateFrom);

    dbTxtCreateDateTo= new exgui.DataBindTextWithChecker(txtCreateDateTo,
                         "P_CR_TO", now, 10,
                          (exgui.Object2String)dateVfy,
                          (exgui.ultratable.CellTxtEditorFormat)dateVfy);

     dataBindComps.add(dbTxtCreateDateTo);



    dbTxtPayDateFrom= new exgui.DataBindTextWithChecker(txtPayDateFrom,
                            "P_PAY_DD_FM",
                            null, 9,
                            (exgui.Object2String)vftxtChkDD,
                            (exgui.ultratable.CellTxtEditorFormat)vftxtChkDD);
    dataBindComps.add(dbTxtPayDateFrom);

    dbTxtPayDateTo= new exgui.DataBindTextWithChecker(txtPayDateTo,
                       "P_PAY_DD_TO", null, 9,
                       (exgui.Object2String)vftxtChkDD,
                       (exgui.ultratable.CellTxtEditorFormat)vftxtChkDD);
     dataBindComps.add(dbTxtPayDateTo);

     dbCbxPayee  = new exgui.DataBindEditableJCombobox(cbxPayeeItem,"P_PAYEE",Constants.VCT_PAYEE_ITEMS,
                                                             "ITEM_NAME","ITEM_NAME",null,25);

     dataBindComps.add(dbCbxPayee);



     cbxSort.addItem("PAY_DD");
     cbxSort.addItem("PAYEE");
     cbxSort.addItem("CHK_NO");
     cbxSort.setSelectedIndex(0);





      //Object vftxtDC = exgui.verification.CellFormat.getOrdinaryFieldNotAllowNull(1);
      Object vftxtDC = exgui.verification.CellFormat.getOrdinaryField(1);
          new exgui.DataBindTextWithChecker(
          txtDC, "D_C",
          null, 1,
          (exgui.Object2String)vftxtDC,
          (exgui.ultratable.CellTxtEditorFormat)vftxtDC);


    }catch(Exception exp){
      exp.printStackTrace();
    }

  }

  void cbxPayeeItem_itemStateChanged(ItemEvent e) {

  }
  void cbxCompany_itemStateChanged(ItemEvent e) {

  }

  public java.util.HashMap composeParameters(){
    java.util.HashMap hm=super.composeParameters();
    if(dbTxtCreateDateFrom.getSelectedValue()==null)hm.put(dbTxtCreateDateFrom.getOrgRecField(),"DATE(2001,01,01)");
    if(dbTxtCreateDateTo.getSelectedValue()==null)hm.put(dbTxtCreateDateTo.getOrgRecField(),"DATE(2099,12,31)");


    if(dbTxtPayDateFrom.getSelectedValue()==null)hm.put(dbTxtPayDateFrom.getOrgRecField(),"DATE(2001,01,01)");
    if(dbTxtPayDateTo.getSelectedValue()==null)hm.put(dbTxtPayDateTo.getOrgRecField(),"DATE(2099,12,31)");


    if(txtDC.getText().trim().length()==0){
      hm.put("P_DB_CR","ALL");
    }else{
      hm.put("P_DB_CR",txtDC.getText().trim());
    }
    if(dbCbxPayee.getSelectedValue()==null || dbCbxPayee.getSelectedValue().toString().trim().length()==0){
      hm.put("P_PAYEE","ALL");
    }else{
      hm.put("P_PAYEE",dbCbxPayee.getSelectedValue().toString());
    }
    hm.put("P_SORT",cbxSort.getSelectedItem().toString());
    return hm;
    /*
    //filter out the none used para
    java.util.Iterator itr=hm.keySet().iterator();
    java.util.HashMap hm2return=new java.util.HashMap();
    while(itr.hasNext()){
       String key=(String)itr.next();
       if(hm.get(key).toString().toUpperCase().equals("ALL")){

       }else{
         hm2return.put(key,hm.get(key));
       }
    }
    return hm2return;*/
  }
  void btnPrint_actionPerformed(ActionEvent e) {
     super.JButtonQueryButtonAction(e);
  }
}
