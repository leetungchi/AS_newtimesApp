package newtimes.general_voucher.daily_voucher;

import java.awt.*;
import exgui.*;
import javax.swing.*;
import java.awt.*;
import exgui.*;
import javax.swing.*;
import newtimes.preproduction.buyermakerselect.*;
import java.awt.event.*;
import newtimes.production.report.*;
import java.util.*;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class PnlRpt_OpExp
    //extends JPanel {
     extends AbsQryPanel{
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel1 = new BlueBkgWhiteCharLabel();
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel2 = new BlueBkgWhiteCharLabel();
  JComboBox cbxCompany = new JComboBox();
  WhiteBkgBlueCharLabel whiteBkgBlueCharLabel1 = new WhiteBkgBlueCharLabel();
  JTextField txtDateFrom = new JTextField();
  WhiteBkgBlueCharLabel whiteBkgBlueCharLabel2 = new WhiteBkgBlueCharLabel();
  JTextField txtDateTo = new JTextField();
  WhiteBkgBlueCharLabel whiteBkgBlueCharLabel3 = new WhiteBkgBlueCharLabel();
  JTextField txtAccFrom = new JTextField();
  WhiteBkgBlueCharLabel whiteBkgBlueCharLabel4 = new WhiteBkgBlueCharLabel();
  JTextField txtAccTo = new JTextField();
  JButton btnQry = new JButton();

  public PnlRpt_OpExp() {
    try {
      //jbInit();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }

  void jbInit() throws Exception {
    blueBkgWhiteCharLabel1.setFont(new java.awt.Font("Dialog", 1, 14));
    blueBkgWhiteCharLabel1.setText("收入/費用明細表");
    blueBkgWhiteCharLabel1.setBounds(new Rectangle(-2, 9, 806, 25));
    this.setLayout(null);
    blueBkgWhiteCharLabel2.setText("公司:");
    blueBkgWhiteCharLabel2.setBounds(new Rectangle(13, 42, 52, 25));
    cbxCompany.setBounds(new Rectangle(65, 42, 140, 25));
    whiteBkgBlueCharLabel1.setFont(new java.awt.Font("Dialog", 0, 14));
    whiteBkgBlueCharLabel1.setText("傳票日期:");
    whiteBkgBlueCharLabel1.setBounds(new Rectangle(212, 42, 82, 25));
    txtDateFrom.setText("");
    txtDateFrom.setBounds(new Rectangle(293, 42, 70, 25));
    whiteBkgBlueCharLabel2.setBounds(new Rectangle(363, 42, 28, 25));
    whiteBkgBlueCharLabel2.setText("~");
    whiteBkgBlueCharLabel2.setFont(new java.awt.Font("Dialog", 0, 14));
    txtDateTo.setText("");
    txtDateTo.setBounds(new Rectangle(392, 42, 70, 25));
    whiteBkgBlueCharLabel3.setBackground(new Color(143, 143, 188));
    whiteBkgBlueCharLabel3.setFont(new java.awt.Font("Dialog", 0, 14));
    whiteBkgBlueCharLabel3.setForeground(Color.white);
    whiteBkgBlueCharLabel3.setText("~");
    whiteBkgBlueCharLabel3.setBounds(new Rectangle(620, 42, 30, 25));
    txtAccFrom.setBounds(new Rectangle(551, 42, 70, 25));
    txtAccFrom.setText("");
    whiteBkgBlueCharLabel4.setBounds(new Rectangle(470, 42, 82, 25));
    whiteBkgBlueCharLabel4.setText("科目起迄:");
    whiteBkgBlueCharLabel4.setBackground(new Color(143, 143, 188));
    whiteBkgBlueCharLabel4.setFont(new java.awt.Font("Dialog", 0, 14));
    whiteBkgBlueCharLabel4.setForeground(Color.white);
    txtAccTo.setBounds(new Rectangle(650, 42, 70, 25));
    txtAccTo.setText("");
    btnQry.setBounds(new Rectangle(643, 76, 106, 27));
    btnQry.setFont(new java.awt.Font("Dialog", 1, 12));
    btnQry.setText("REPORT");
    btnQry.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnQry_actionPerformed(e);
      }
    });
    this.setBackground(new Color(202, 202, 224));
    this.add(blueBkgWhiteCharLabel1, null);
    this.add(blueBkgWhiteCharLabel2, null);
    this.add(cbxCompany, null);
    this.add(whiteBkgBlueCharLabel2, null);
    this.add(whiteBkgBlueCharLabel1, null);
    this.add(txtDateFrom, null);
    this.add(txtDateTo, null);
    this.add(whiteBkgBlueCharLabel3, null);
    this.add(whiteBkgBlueCharLabel4, null);
    this.add(txtAccFrom, null);
    this.add(txtAccTo, null);
    this.add(btnQry, null);
    genDataBindObj();
  }
  public void genDataBindObj(){
    try{
      StringBuffer sb=new StringBuffer();
      sb.append("select substr(field_name,length(field_name),1) as cmp_code, ");
      sb.append("field_desc as cmp_name,");
      sb.append("substr(field_name,length(field_name),1)||'--'||field_desc  as comp_code_and_name ");
      sb.append(" from TPE_DATE_RANGE  ");
      sb.append("where record_delete_flag='1'  ");
      sb.append("and CEN_CODE='");sb.append(util.PublicVariable.OPERATTING_CENTER);sb.append("' ");
      sb.append("and FIELD_NAME LIKE 'GV_COMP_%' ");
       Vector vctCmp =exgui2.CONST.BASIC_MAIN_EJB.getDatas(
        util.PublicVariable.USER_RECORD,
        sb.toString(),1,9999);
    exgui.DataBindJCombobox  dbCbxCompany =
         new exgui.DataBindJCombobox(cbxCompany, "P_COMP",
                                     vctCmp,
                                     "comp_code_and_name", "cmp_code",null);

    dataBindComps.add(dbCbxCompany);
     Object vftxtChkDD=exgui.verification.CellFormat.getDateStringFormater();
     java.util.Calendar gc=java.util.GregorianCalendar.getInstance();
     gc.set(gc.MONTH,gc.get(gc.MONTH)-1);
     gc.set(gc.DATE,1);
     java.util.Date dateFrom=new java.util.Date(gc.getTimeInMillis());

    exgui.DataBindTextWithChecker dbTxtPayDateFrom= new exgui.DataBindTextWithChecker(txtDateFrom,
                             "P_DATE_FM",
                             dateFrom, 10,
                             (exgui.Object2String)vftxtChkDD,
                             (exgui.ultratable.CellTxtEditorFormat)vftxtChkDD);
     dataBindComps.add(dbTxtPayDateFrom);

     gc.set(gc.DATE,gc.getActualMaximum(gc.DATE));
          java.util.Date dateTo=new java.util.Date(gc.getTimeInMillis());
     exgui.DataBindTextWithChecker dbTxtPayDateTo= new exgui.DataBindTextWithChecker(txtDateTo,
                        "P_DATE_TO", dateTo, 10,
                        (exgui.Object2String)vftxtChkDD,
                        (exgui.ultratable.CellTxtEditorFormat)vftxtChkDD);
      dataBindComps.add(dbTxtPayDateTo);

      Object vftxtAccNO = exgui.verification.CellFormat.getOrdinaryField(10);
       dataBindComps.add(
        new exgui.DataBindTextWithChecker(txtAccFrom, "P_ITEM_FM",
            "5101", 10,
            (exgui.Object2String)vftxtAccNO,
                          (exgui.ultratable.CellTxtEditorFormat)vftxtAccNO)
        );

     dataBindComps.add(
      new exgui.DataBindTextWithChecker(txtAccTo, "P_ITEM_TO",
          "5ZZZ", 10,
          (exgui.Object2String)vftxtAccNO,
                        (exgui.ultratable.CellTxtEditorFormat)vftxtAccNO)
      );


     super.reportName="ACC_OP_EXP.rpt";
    }catch(Exception exp){
      exp.printStackTrace();
    }

  }
  public  HashMap composeParameters(){
    HashMap hm=super.composeParameters();

    return hm;
  }
  void btnQry_actionPerformed(ActionEvent e) {
    if(txtDateFrom.getText().trim().length()==0){
     exgui.verification.VerifyLib.showAlert("Please Input From date of Voucher","Date From is blank");
     return;
    }
    if(txtDateTo.getText().trim().length()==0){
     exgui.verification.VerifyLib.showAlert("Please Input End date of Voucher","End From is blank");
     return;
    }

    if(txtAccFrom.getText().trim().length()==0){
     exgui.verification.VerifyLib.showAlert("Please Input Begin Acc# Of Voucher","Begin Acc# is blank");
     return;
    }
    if(txtAccTo.getText().trim().length()==0){
     exgui.verification.VerifyLib.showAlert("Please Input End Acc# Of Voucher","End Acc# is blank");
     return;
    }

    newtimes.production.report.ReportCmdSet.myReportEngin.reportServerURL=
 "http://rpt2.nttpe.com.tw:9000/?file:///cc53//rpt//";
 super.JButtonQueryButtonAction(null);
  newtimes.production.report.ReportCmdSet.myReportEngin.reportServerURL=
    "http://rpt.nttpe.com.tw:9000/?file:///d://rpt//";

  }
}
