package newtimes.production.report;
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

public class PnlScColorBalanceQtyListRpt
    extends AbsQryPanel  {
    //extends JPanel  {
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel1 = new BlueBkgWhiteCharLabel();
  JButton btnPrint = new JButton();
  JComboBox cbxCenter = new JComboBox();
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel2 = new BlueBkgWhiteCharLabel();
  exgui.DataBindJCombobox dbcbxCenter;
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel3 = new BlueBkgWhiteCharLabel();
  JTextField txtSC = new JTextField();
  public PnlScColorBalanceQtyListRpt() {
    try {
      jbInit();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }

 protected void jbInit() throws Exception {
    blueBkgWhiteCharLabel1.setText("S/C COLOR BALANCE QTY LIST");
    blueBkgWhiteCharLabel1.setBounds(new Rectangle(0, 23, 801, 37));
    this.setLayout(null);
    btnPrint.setBounds(new Rectangle(537, 139, 127, 27));
    btnPrint.setFont(new java.awt.Font("Dialog", 1, 11));
    btnPrint.setText("PRINT");
    btnPrint.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnPrint_actionPerformed(e);
      }
    });
    cbxCenter.setBounds(new Rectangle(192, 87, 147, 20));
    blueBkgWhiteCharLabel2.setBounds(new Rectangle(66, 87, 126, 21));
    blueBkgWhiteCharLabel2.setText("CENTER:");
    blueBkgWhiteCharLabel3.setText("S/C NO.");
    blueBkgWhiteCharLabel3.setBounds(new Rectangle(68, 134, 126, 21));
    txtSC.setBounds(new Rectangle(194, 133, 148, 23));
    this.add(blueBkgWhiteCharLabel1, null);
    this.add(btnPrint, null);
    this.add(blueBkgWhiteCharLabel2, null);
    this.add(cbxCenter, null);
    this.add(blueBkgWhiteCharLabel3, null);
    this.add(txtSC, null);
    genDataBindObj();
  }
  public void genDataBindObj(){
    try{
      java.util.Vector vctCenters =
          exgui2.CONST.BASIC_MAIN_EJB.getDatas(
          util.PublicVariable.USER_RECORD,
          "select cen_code,cen_name,cen_prefix from center where record_delete_flag=1",
          1, 999);
      dbcbxCenter = new exgui.DataBindJCombobox(
          cbxCenter, "", vctCenters, "cen_name", "cen_code",
          util.PublicVariable.OPERATTING_CENTER
          );
          cbxCenter.setVisible(false);
          blueBkgWhiteCharLabel2.setVisible(false);

    }catch(Exception exp){
      exp.printStackTrace();
    }

    reportName="SC_COLOR_BALANCE.RPT";
  }
  public java.util.HashMap composeParameters(){
    java.util.HashMap hm= new java.util.HashMap();
    hm.put("P_CENTER_CODE",dbcbxCenter.getSelectedValue());
    hm.put("P_SC_NO",txtSC.getText().trim());
    return hm;
  }
  void btnPrint_actionPerformed(ActionEvent e) {
    if(txtSC.getText().trim().length()<7){
      exgui.verification.VerifyLib.showAlert("Pleaase Input S/C NO","Please Input S/C NO");
      return;
    }
     super.JButtonQueryButtonAction(e);
  }
}
