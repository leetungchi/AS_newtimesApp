package newtimes.material;

import java.awt.*;
import javax.swing.*;
import exgui.*;
import java.awt.event.*;

public class DlgAddMill extends JDialog {
  JPanel panel1 = new JPanel();
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel1 = new BlueBkgWhiteCharLabel();
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel2 = new BlueBkgWhiteCharLabel();
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel3 = new BlueBkgWhiteCharLabel();
  JTextField txtFullName = new JTextField();
  JTextField txtBrfName = new JTextField();
  JTextField txtChnName = new JTextField();
  JButton tbnAdd = new JButton();
  JButton btnClose = new JButton();
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel4 = new BlueBkgWhiteCharLabel();
  JComboBox cbxCountry = new JComboBox();
  exgui.DataBindJCombobox dbCBX_cnty=null;

  public DlgAddMill(Frame frame, String title, boolean modal) {
    super(frame, title, modal);
    try {
      jbInit();
      pack();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }

  public DlgAddMill() {
    this(null, "", false);
  }

  private void jbInit() throws Exception {
    panel1.setLayout(null);
    blueBkgWhiteCharLabel1.setText("FULL NAME");
    blueBkgWhiteCharLabel1.setBounds(new Rectangle(22, 61, 195, 24));
    blueBkgWhiteCharLabel2.setBounds(new Rectangle(22, 105, 195, 24));
    blueBkgWhiteCharLabel2.setText("BRIFE NAME");
    blueBkgWhiteCharLabel3.setBounds(new Rectangle(22, 147, 195, 26));
    blueBkgWhiteCharLabel3.setText("CHINESE NAME ( if available)");
    txtFullName.setText("");
    txtFullName.setBounds(new Rectangle(219, 61, 171, 25));
    txtBrfName.setText("");
    txtBrfName.setBounds(new Rectangle(219, 104, 171, 26));
    txtChnName.setText("");
    txtChnName.setBounds(new Rectangle(220, 148, 170, 24));
    tbnAdd.setBounds(new Rectangle(71, 263, 109, 29));
    tbnAdd.setFont(new java.awt.Font("Dialog", 1, 11));
    tbnAdd.setText("ADD");
    tbnAdd.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        tbnAdd_actionPerformed(e);
      }
    });
    btnClose.setBounds(new Rectangle(206, 263, 110, 27));
    btnClose.setFont(new java.awt.Font("Dialog", 1, 11));
    btnClose.setText("CANCEL");
    btnClose.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnClose_actionPerformed(e);
      }
    });
    blueBkgWhiteCharLabel4.setText("COUNTRY");
    blueBkgWhiteCharLabel4.setBounds(new Rectangle(23, 186, 195, 26));
    cbxCountry.setBounds(new Rectangle(220, 187, 169, 26));
    getContentPane().add(panel1);
    panel1.add(blueBkgWhiteCharLabel1, null);
    panel1.add(blueBkgWhiteCharLabel2, null);
    panel1.add(blueBkgWhiteCharLabel3, null);
    panel1.add(txtFullName, null);
    panel1.add(txtBrfName, null);
    panel1.add(txtChnName, null);
    panel1.add(tbnAdd, null);
    panel1.add(btnClose, null);
    panel1.add(blueBkgWhiteCharLabel4, null);
    panel1.add(cbxCountry, null);
    exgui.DataBindText tx = null;//just to set max length of text field.
    tx = new exgui.DataBindText(txtFullName, null, "", 60);
    tx = new exgui.DataBindText(txtBrfName, null, "", 15);
    tx = new exgui.DataBindText(txtChnName, null, "", 8);
    dbCBX_cnty=new exgui.DataBindJCombobox(
          cbxCountry,
          newtimes.preproduction.guis.tempProperties.tmpCountries,
          "CNTY_NAME",
          "CNTY_NAME",null);
  }

  void btnClose_actionPerformed(ActionEvent e) {
   this.dispose();
  }

  void tbnAdd_actionPerformed(ActionEvent e) {
    if(dbCBX_cnty.getSelectedValue()==null){
      exgui.verification.VerifyLib.showAlert("Please Assign Country ","Pleaes Assigne Country");
      return;
    }
    if(txtFullName.getText().trim().length()==0){
      exgui.verification.VerifyLib.showAlert("Please Give A Full Name Of Mill","Full Name Is Blank");
      return;
    }
    if(txtBrfName.getText().trim().length()<7){
      exgui.verification.VerifyLib.showAlert("Please Give A Brief Name Of Mill,At Least 7 Charaters",
                                             "Brief Name Is Blank Or Too Short");
      return;
    }
    if(txtChnName.getText().trim().getBytes().length>8){
      exgui.verification.VerifyLib.showAlert("Chinese Name is too Long,can not over 8 bytes","Data Too Long");
      return;
    }

    try{
      util.MiscFunc.showProcessingMessage();
      //BYMKR_BRIEF, BYMKR_TYPE, BYMKR_NAME, BYMKR_CHINESE_BRIEF,
      //BYMKR_CHECK_DIV, RECORD_CREATE_USER, RECORD_CREATE_DATE, RECORD_DELETE_FLAG
      database.datatype.Record rec=exgui2.CONST.BASIC_MAIN_EJB.getBlankRecord("buyer_maker_tbl");
      rec.set("BYMKR_BRIEF",txtBrfName.getText().trim().toUpperCase());
      rec.set("BYMKR_NAME",txtFullName.getText().trim().toUpperCase());
      rec.set("BYMKR_CHINESE_BRIEF",txtChnName.getText().trim().toUpperCase());
      rec.set("record_delete_flag","1");
      rec.set("bymkr_cnty_code",dbCBX_cnty.getSelectedValue());
      rec.set("record_create_user",util.PublicVariable.USER_RECORD.get("usr_code"));
      rec.set("record_create_date",new java.sql.Date(System.currentTimeMillis()));
      rec.set("BYMKR_CHECK_DIV","N");
      rec.set("BYMKR_TYPE",newtimes.preproduction.buyermakerselect.SelectBuyerMaker.TYPE_FABRIC_MILL);
      rec.set("BYMKR_MULTI_TYPE",","+
              newtimes.preproduction.buyermakerselect.SelectBuyerMaker.TYPE_FABRIC_MILL+
              ",");
      rec.set("SELECTABLE_CENTER",","+util.PublicVariable.USER_RECORD.get("usr_cen_code").toString()+",");
      exgui2.CONST.BASIC_MAIN_EJB.insertRecord("buyer_maker_tbl",rec);
      util.MiscFunc.hideProcessingMessage();
      this.dispose();
      //rec.set("");
    }catch(Exception exp){
      util.MiscFunc.hideProcessingMessage();
      util.ExceptionLog.exp2File(exp,"Erro in brief mill insert process of material detail editor dialog");
      exgui.verification.VerifyLib.showAlert("Insert Fail,Please Contact System Manager","Insert Fail");
    }finally{
      util.MiscFunc.hideProcessingMessage();
      this.dispose();
    }
  }
}
