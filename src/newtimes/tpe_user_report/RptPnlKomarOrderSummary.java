package newtimes.tpe_user_report;

  import java.awt.*;
  import exgui.*;
  import javax.swing.*;
  import newtimes.production.report.AbsQryPanel;
  import java.util.*;
  import exgui.verification.CellFormat;
  import database.datatype.Record;
  import exgui.ultratable.CellTxtEditorFormat;
  import java.awt.event.*;
  import newtimes.preproduction.buyermakerselect.*;

  /**
   * <p>Title: </p>
   * <p>Description: </p>
   * <p>Copyright: Copyright (c) 2003</p>
   * <p>Company: </p>
   * @author not attributable
   * @version 1.0
   */

  public class RptPnlKomarOrderSummary
      extends AbsQryPanel{
      //extends JPanel {
    BlueBkgWhiteCharLabel blueBkgWhiteCharLabel1 = new BlueBkgWhiteCharLabel();
    JButton btnPrint = new JButton();
  WhiteBkgBlueCharLabel whiteBkgBlueCharLabel1 = new WhiteBkgBlueCharLabel();
  JTextField txtGrpCode = new JTextField();
    public RptPnlKomarOrderSummary() {
      try {
        //jbInit();
      }catch(Exception ex) {
        ex.printStackTrace();
      }
    }

    void jbInit() throws Exception {
      blueBkgWhiteCharLabel1.setText("KOMAR ORDER SUMMARY");
      blueBkgWhiteCharLabel1.setBounds(new Rectangle(-3, 5, 803, 34));
      this.setBackground(new Color(202, 202, 224));
      this.setLayout(null);
      btnPrint.setBounds(new Rectangle(665, 66, 84, 27));
      btnPrint.setFont(new java.awt.Font("Dialog", 1, 11));
      btnPrint.setText("REPORT");
      btnPrint.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(ActionEvent e) {
          btnPrint_actionPerformed(e);
        }
      });
      whiteBkgBlueCharLabel1.setText("GROUP#");
    whiteBkgBlueCharLabel1.setBounds(new Rectangle(36, 50, 137, 25));
    txtGrpCode.setBounds(new Rectangle(172, 50, 66, 25));
    this.add(blueBkgWhiteCharLabel1, null);
    this.add(whiteBkgBlueCharLabel1, null);
    this.add(txtGrpCode, null);
    this.add(btnPrint, null);
      genDataBindObj();

    }

    protected  void genDataBindObj(){
    try{
      dataBindComps.clear();
       super.reportName="KOMAR_CROSS.rpt&firstgroupassheets=false";
     }catch(Exception exp){
        exp.printStackTrace();
     }
    }

    protected java.util.HashMap composeParameters(){
     java.util.HashMap hm=super.composeParameters();//new java.util.HashMap();
     hm.put("P_GROUP",txtGrpCode.getText().trim());
     return hm;
    }
    void btnPrint_actionPerformed(ActionEvent e) {
      if(txtGrpCode.getText().trim().length()==0){
        exgui.verification.VerifyLib.showAlert("Please Input Group Code","Please Input Group Code");
        return ;
      }
      String tempURL= newtimes.production.report.ReportProxyEngine.reportServerURL ;
      newtimes.production.report.ReportProxyEngine.reportServerURL="http://rpt3.nttpe.com.tw:9000/?file:///rpt//";
      super.JButtonQueryButtonAction(null);
      newtimes.production.report.ReportProxyEngine.reportServerURL =tempURL;
    }
  }

