package newtimes.general_voucher.stock;
import java.awt.*;
import exgui.*;
import javax.swing.*;
import java.awt.event.*;
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

public class PnlRptAccStockOffset
      extends AbsQryPanel{
      //extends JPanel {
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel1 = new BlueBkgWhiteCharLabel();
  WhiteBkgBlueCharLabel whiteBkgBlueCharLabel1 = new WhiteBkgBlueCharLabel();
  JComboBox cbxCompany = new JComboBox();
  WhiteBkgBlueCharLabel whiteBkgBlueCharLabel2 = new WhiteBkgBlueCharLabel();
  JTextField txtYYYYMM = new JTextField();
  JButton btnQry = new JButton();
  WhiteBkgBlueCharLabel whiteBkgBlueCharLabel3 = new WhiteBkgBlueCharLabel();
  JTextField txtTitleYYYYMM = new JTextField();
  JButton btnUpdate = new JButton();
  JFrame frame ;
  boolean isUpdatting=false;
  exgui.DataBindJCombobox dbCbxCompany;
  public PnlRptAccStockOffset(JFrame frame) {
    try {
      //jbInit();
      this.frame=frame;
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }

  void jbInit() throws Exception {
    blueBkgWhiteCharLabel1.setFont(new java.awt.Font("Dialog", 1, 16));
    blueBkgWhiteCharLabel1.setText("存貨分類帳");
    blueBkgWhiteCharLabel1.setBounds(new Rectangle(-4, 8, 809, 34));
    this.setLayout(null);
    this.setBackground(new Color(202, 202, 224));
    whiteBkgBlueCharLabel1.setForeground(Color.blue);
    whiteBkgBlueCharLabel1.setHorizontalAlignment(SwingConstants.CENTER);
    whiteBkgBlueCharLabel1.setText("公司");
    whiteBkgBlueCharLabel1.setBounds(new Rectangle(12, 47, 49, 22));
    cbxCompany.setBounds(new Rectangle(62, 47, 202, 22));
    whiteBkgBlueCharLabel2.setBounds(new Rectangle(287, 47, 108, 22));
    whiteBkgBlueCharLabel2.setText("沖帳檔 YYYYMM");
    whiteBkgBlueCharLabel2.setHorizontalAlignment(SwingConstants.CENTER);
    whiteBkgBlueCharLabel2.setForeground(Color.blue);
    txtYYYYMM.setText("");
    txtYYYYMM.setBounds(new Rectangle(394, 47, 70, 22));
    btnQry.setBounds(new Rectangle(669, 46, 112, 27));
    btnQry.setFont(new java.awt.Font("Dialog", 1, 11));
    btnQry.setText("REPORT");
    btnQry.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnQry_actionPerformed(e);
      }
    });
    whiteBkgBlueCharLabel3.setForeground(Color.blue);
    whiteBkgBlueCharLabel3.setHorizontalAlignment(SwingConstants.CENTER);
    whiteBkgBlueCharLabel3.setText("表頭 YYYYMM");
    whiteBkgBlueCharLabel3.setBounds(new Rectangle(484, 47, 97, 22));
    txtTitleYYYYMM.setBounds(new Rectangle(580, 47, 70, 22));
    txtTitleYYYYMM.setText("");
    btnUpdate.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        int res = exgui2.InfoMessage.Yes_No_Option(frame,"Are You Sure ?");
        if ( res == 0 )
        {
          btnUpdate_actionPerformed(e);
        }
      }
    });
    btnUpdate.setText("UPDATE");
    btnUpdate.setFont(new java.awt.Font("Dialog", 1, 11));
    btnUpdate.setForeground(Color.red);
    btnUpdate.setBounds(new Rectangle(669, 84, 112, 27));
    this.add(blueBkgWhiteCharLabel1, null);
    this.add(whiteBkgBlueCharLabel1, null);
    this.add(cbxCompany, null);
    this.add(whiteBkgBlueCharLabel2, null);
    this.add(txtYYYYMM, null);
    this.add(btnQry, null);
    this.add(whiteBkgBlueCharLabel3, null);
    this.add(txtTitleYYYYMM, null);
    this.add(btnUpdate, null);
    genDataBindObj();
  }
  public void genDataBindObj(){
     dbCbxCompany =
      new exgui.DataBindJCombobox(cbxCompany, "P_COMP",
                                  newtimes.general_voucher.daily_voucher.
                                  Constants.VCT_GV_ACC_COMPANY,
                                  "comp_code_and_name", "cmp_code",null,"ALL","ALL");
  dataBindComps.add(dbCbxCompany);
  Object objyyyymmVfy=exgui.verification.CellFormat.getIntVerifierAllowNull(6);
  exgui.DataBindTextWithChecker dbTxtYYYYMM= new exgui.DataBindTextWithChecker(txtYYYYMM,
                           "P_YYYYMM",
                           "999999", 6,
                           (exgui.Object2String)objyyyymmVfy,
                           (exgui.ultratable.CellTxtEditorFormat)objyyyymmVfy);
   dataBindComps.add(dbTxtYYYYMM);
   exgui.DataBindTextWithChecker dbTxtTitleYYYYMM= new exgui.DataBindTextWithChecker(txtTitleYYYYMM,
                            "P_TITLE_YM",
                            "999999", 6,
                            (exgui.Object2String)objyyyymmVfy,
                            (exgui.ultratable.CellTxtEditorFormat)objyyyymmVfy);
    dataBindComps.add(dbTxtTitleYYYYMM);



      super.reportName="ACC_STOCK_OFFSET.rpt";
  }

  void btnQry_actionPerformed(ActionEvent e) {
    if(dbCbxCompany.getSelectedValue()==null || dbCbxCompany.getSelectedValue().toString().equals("ALL")){
      exgui.verification.VerifyLib.showAlert("Please Select Company","Please Select Company") ;
      return;
    }

    String tmpURL=newtimes.production.report.ReportCmdSet.myReportEngin.reportServerURL;
    newtimes.production.report.ReportCmdSet.myReportEngin.reportServerURL=
 "http://rpt2.nttpe.com.tw:9000/?file:///cc53//rpt//";
 super.JButtonQueryButtonAction(null);
  newtimes.production.report.ReportCmdSet.myReportEngin.reportServerURL=tmpURL;

  }
  void btnUpdate_actionPerformed(ActionEvent e) {
    if(isUpdatting)return;
    if(txtYYYYMM.getText().trim().length()!=6){
      exgui.verification.VerifyLib.showAlert("Please Check YYYYMM","Please Check YYYYMM");
      return;
    }
    if(txtTitleYYYYMM.getText().trim().length()!=6){
      exgui.verification.VerifyLib.showAlert("Please Check TITLE YYYYMM","Please Check TITLE YYYYMM");
      return;
    }
    if(dbCbxCompany.getSelectedValue()==null || dbCbxCompany.getSelectedValue().toString().equals("ALL")){
      exgui.verification.VerifyLib.showAlert("Please Select Company","Please Select Company") ;
    }

    try{
      isUpdatting=true;
      util.MiscFunc.showProcessingMessage();
      newtimesejb.dailyVoucher.StockFacadeHome stockEjbHome=
          (newtimesejb.dailyVoucher.StockFacadeHome)
          info_ejb.WeblogicServiceLocator.locateServiceHome(util.PublicVariable.SERVER_URL,
          "newtimesejb.dailyVoucher.StockFacade");
          newtimesejb.dailyVoucher.StockFacade ejb=stockEjbHome.create();

           ejb.update_1108_6101(dbCbxCompany.getSelectedValue().toString(),txtYYYYMM.getText().trim(),
                                txtTitleYYYYMM.getText().trim(),
                                  util.PublicVariable.USER_RECORD.get(0).toString());
             exgui.verification.VerifyLib.showPlanMsg("Update Ok","Create Ok");

           }catch(Exception exp){
             exp.printStackTrace();
             util.ExceptionLog.exp2File(exp,"");
             exgui.verification.VerifyLib.showAlert("Error While Update\nPlease Contact System Manager",
                                                    "Error While Update");
           }finally{
             isUpdatting=false;
             util.MiscFunc.hideProcessingMessage();
           }

  }
}
