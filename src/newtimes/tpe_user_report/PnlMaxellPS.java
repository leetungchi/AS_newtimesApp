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
import newtimes.production.report.QryPanel;
/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class PnlMaxellPS
    extends AbsQryPanel{
    //extends JPanel {
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel1 = new BlueBkgWhiteCharLabel();
  JButton btnPrint = new JButton();
  int year=java.util.Calendar.getInstance().get(java.util.Calendar.getInstance().YEAR);
  exgui.DataBindJCombobox dbCbxSzn;
  JLabel lblDelDDBy = new JLabel();
  JComboBox cbxDelDDBy = new JComboBox();
  int indexOfDivision;

  public PnlMaxellPS() {
    try {
      //jbInit();
    }catch(Exception ex) {
      ex.printStackTrace();
    }
  }

  void jbInit() throws Exception {
    blueBkgWhiteCharLabel1.setText("MAXELL PENDING /SHIPMENT LIST");
    blueBkgWhiteCharLabel1.setBounds(new Rectangle(-2, 5, 803, 34));
    this.setBackground(new Color(202, 202, 224));
    this.setLayout(null);
    btnPrint.setBounds(new Rectangle(260, 58, 93, 27));
    btnPrint.setFont(new java.awt.Font("Dialog", 1, 11));
    btnPrint.setText("REPORT");
    btnPrint.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnPrint_actionPerformed(e);
      }
    });
    lblDelDDBy.setBounds(new Rectangle(22, 61, 124, 20));
    lblDelDDBy.setText("LIST BY PEND/SHIP :");
    lblDelDDBy.setFont(new java.awt.Font("Dialog", 1, 11));
    lblDelDDBy.setPreferredSize(new Dimension(104, 17));
    lblDelDDBy.setVerifyInputWhenFocusTarget(true);
    cbxDelDDBy.setBounds(new Rectangle(145, 60, 105, 21));
    cbxDelDDBy.addItem("PENDING");
    cbxDelDDBy.addItem("SHIPMENT");
    this.add(blueBkgWhiteCharLabel1, null);
    this.add(lblDelDDBy, null);
    this.add(cbxDelDDBy, null);
    this.add(btnPrint, null);
//    exgui.ultratable.Wraper4tblCbx itemWrapBuyer=new exgui.ultratable.Wraper4tblCbx();
//    itemWrapBuyer.setString("BUYER");
//    itemWrapBuyer.setValue("'LABEL'");

//    exgui.ultratable.Wraper4tblCbx itemWrapDiv=new exgui.ultratable.Wraper4tblCbx();
//    itemWrapDiv.setString("DIVISION");
//    itemWrapDiv.setValue("'DIVISION'");

//    genDataBindObj();

  }

  protected java.util.HashMap composeParameters(){
   java.util.HashMap hm=super.composeParameters();//new java.util.HashMap();
   if (cbxDelDDBy.getSelectedItem().toString().equals("PENDING")) {
       hm.put("p_by_pend","Y");
   } else {
       hm.put("p_by_pend","N");
   }

   return hm;
  }
  void btnPrint_actionPerformed(ActionEvent e) {

    String tempURL= newtimes.production.report.ReportProxyEngine.reportServerURL ;
    newtimes.production.report.ReportProxyEngine.reportServerURL="http://rpt2.nttpe.com.tw:9000/?file:///rpt//QQ_SHIP_PEND.rpt";
    super.JButtonQueryButtonAction(null);
    newtimes.production.report.ReportProxyEngine.reportServerURL =tempURL;
  }

  /**
   * genDataBindObj
   */
  protected void genDataBindObj() {

  }
}
