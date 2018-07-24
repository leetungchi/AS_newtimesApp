package newtimes.shipping.accountdepuse;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import exgui.*;
import database.datatype.Record;
/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class DailyRec4AccountDepUseGUI extends JPanel {
  JPanel jPanel2 = new JPanel();
  ButtonGroup buttonGroup1 = new ButtonGroup();
  JTextField txt6 = new JTextField();
  JTextField txt5 = new JTextField();
  JTextField txt10 = new JTextField();
  JTextField txt2 = new JTextField();
  JTextField txt4 = new JTextField();
  JTextField txt8 = new JTextField();
  JTextField txt1 = new JTextField();
  JLabel jLabel117 = new JLabel();
  JTextField txt9 = new JTextField();
  JTextField txt7 = new JTextField();
  JTextField txt3 = new JTextField();
  JTextField txt17 = new JTextField();
  JTextField txt14 = new JTextField();
  JTextField txt12 = new JTextField();
  JTextField txt19 = new JTextField();
  JTextField txt13 = new JTextField();
  JTextField txt16 = new JTextField();
  JTextField txt11 = new JTextField();
  JTextField txt15 = new JTextField();
  JTextField txt20 = new JTextField();
  JTextField txt18 = new JTextField();

  JButton do_Print4NotFinal = new JButton();
  JTextField[] txtField = {txt1, txt2, txt3, txt4, txt5, txt6, txt7, txt8, txt9, txt10,
                           txt11, txt12, txt13, txt14, txt15, txt16, txt17, txt18, txt19, txt20};
  JLabel jLabel1 = new JLabel();
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel1 = new BlueBkgWhiteCharLabel();
  JComboBox cbxCenter = new JComboBox();
  exgui.DataBindJCombobox dbcbxCenter;
  java.util.HashMap cen_code_prefix=null;
  JButton btnQryShipByDate = new JButton();
  java.util.Vector vctCenters;
  JButton btnClearAllSrn = new JButton();
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel2 = new BlueBkgWhiteCharLabel();
  JComboBox cbxPrintLastPage = new JComboBox(new String[]{"YES","NO"});
  ButtonGroup btnGrpOnlySrnTtl = new ButtonGroup();
  WhiteBkgBlueCharLabel whiteBkgBlueCharLabel1 = new WhiteBkgBlueCharLabel();
  JRadioButton rdoOnlySrnTtl_Y = new JRadioButton();
  JRadioButton rdoOnlySrnTtl_N = new JRadioButton();
  public DailyRec4AccountDepUseGUI() {
    try {
      jbInit();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }
  void jbInit() throws Exception {
    jLabel1.setBounds(new Rectangle(117, 12, 566, 24));
    jLabel1.setHorizontalAlignment(SwingConstants.CENTER);
    jLabel1.setBorder(BorderFactory.createEtchedBorder());
    jLabel1.setForeground(new Color(10,36,106));
    jLabel1.setFont(new java.awt.Font("Dialog", 1, 13));
    jLabel1.setText("      ==========  Daily Shipment Record for Account Department Use  ==========      ");
    this.setLayout(null);
    this.setSize(new Dimension(800, 201));
    this.setBackground(new Color(204, 204, 225));
    jPanel2.setBounds(new Rectangle(2, 69, 662, 118));
    jPanel2.setLayout(null);
    jPanel2.setBackground(new Color(204, 204, 225));
    jPanel2.setBorder(BorderFactory.createTitledBorder(" Ext-Print "));
    txt6.setForeground(new Color(10,36,106));
    txt6.setBounds(new Rectangle(63, 39, 116, 20));
    txt5.setForeground(new Color(10,36,106));
    txt5.setBounds(new Rectangle(538, 14, 116, 20));
    txt10.setBounds(new Rectangle(538, 39, 116, 20));
    txt10.setForeground(new Color(10,36,106));
    txt2.setBounds(new Rectangle(182, 14, 116, 20));
    txt2.setForeground(new Color(10,36,106));
    txt4.setBounds(new Rectangle(419, 14, 116, 20));
    txt4.setForeground(new Color(10,36,106));
    txt8.setForeground(new Color(10,36,106));
    txt8.setBounds(new Rectangle(301, 39, 116, 20));
    txt1.setBounds(new Rectangle(63, 14, 116, 20));
    txt1.setForeground(new Color(10,36,106));
    jLabel117.setBackground(new Color(143, 143, 188));
    jLabel117.setFont(new java.awt.Font("Dialog", 1, 11));
    jLabel117.setForeground(new Color(10,36,106));
    jLabel117.setOpaque(true);
    jLabel117.setHorizontalAlignment(SwingConstants.LEFT);
    jLabel117.setText(" SRN No. :");
    jLabel117.setBounds(new Rectangle(5, 16, 55, 89));
    txt9.setForeground(new Color(10,36,106));
    txt9.setBounds(new Rectangle(419, 39, 116, 20));
    txt7.setBounds(new Rectangle(182, 39, 116, 20));
    txt7.setForeground(new Color(10,36,106));
    txt3.setBounds(new Rectangle(301, 14, 116, 20));
    txt3.setForeground(new Color(10,36,106));
    do_Print4NotFinal.setForeground(Color.darkGray);
    do_Print4NotFinal.setFont(new java.awt.Font("Dialog", 1, 12));
    do_Print4NotFinal.setBounds(new Rectangle(306, 438, 80, 25));
    do_Print4NotFinal.setText("Print");
    do_Print4NotFinal.setMargin(new Insets(0, 0, 0, 0));
    do_Print4NotFinal.setBounds(new Rectangle(667, 154, 93, 25));
    do_Print4NotFinal.setBackground(Color.lightGray);
    blueBkgWhiteCharLabel1.setText("CENTER:");
    blueBkgWhiteCharLabel1.setBounds(new Rectangle(15, 47, 126, 21));
    cbxCenter.setBounds(new Rectangle(141, 47, 147, 20));
    btnQryShipByDate.setBounds(new Rectangle(571, 37, 202, 29));
    btnQryShipByDate.setFont(new java.awt.Font("Dialog", 1, 11));
    btnQryShipByDate.setText("Query By Create Date");
    btnQryShipByDate.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnQryShipByDate_actionPerformed(e);
      }
    });
    txt17.setForeground(new Color(10,36,106));
    txt17.setBounds(new Rectangle(183, 87, 116, 20));
    txt14.setForeground(new Color(10,36,106));
    txt14.setBounds(new Rectangle(420, 62, 116, 20));
    txt12.setForeground(new Color(10,36,106));
    txt12.setBounds(new Rectangle(183, 62, 116, 20));
    txt19.setBounds(new Rectangle(420, 87, 116, 20));
    txt19.setForeground(new Color(10,36,106));
    txt13.setForeground(new Color(10,36,106));
    txt13.setBounds(new Rectangle(302, 62, 116, 20));
    txt16.setBounds(new Rectangle(64, 87, 116, 20));
    txt16.setForeground(new Color(10,36,106));
    txt11.setForeground(new Color(10,36,106));
    txt11.setBounds(new Rectangle(64, 62, 116, 20));
    txt15.setBounds(new Rectangle(539, 62, 116, 20));
    txt15.setForeground(new Color(10,36,106));
    txt20.setForeground(new Color(10,36,106));
    txt20.setBounds(new Rectangle(539, 87, 116, 20));
    txt18.setBounds(new Rectangle(302, 87, 116, 20));
    txt18.setForeground(new Color(10,36,106));
    btnClearAllSrn.setBounds(new Rectangle(670, 71, 92, 27));
    btnClearAllSrn.setFont(new java.awt.Font("Dialog", 1, 11));
    btnClearAllSrn.setText("Clear ALL");
    btnClearAllSrn.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnClearAllSrn_actionPerformed(e);
      }
    });
    blueBkgWhiteCharLabel2.setBounds(new Rectangle(298, 47, 136, 21));
    blueBkgWhiteCharLabel2.setText("PRINT LAST PAGE");
    cbxPrintLastPage.setBounds(new Rectangle(434, 47, 94, 21));
    whiteBkgBlueCharLabel1.setText("Only SRN Total");
    whiteBkgBlueCharLabel1.setBounds(new Rectangle(665, 103, 125, 21));
    rdoOnlySrnTtl_Y.setBackground(Color.white);
    rdoOnlySrnTtl_Y.setFont(new java.awt.Font("Dialog", 1, 11));
    rdoOnlySrnTtl_Y.setForeground(new Color(143, 143, 188));
    rdoOnlySrnTtl_Y.setSelected(true);
    rdoOnlySrnTtl_Y.setText("YES");
    rdoOnlySrnTtl_Y.setBounds(new Rectangle(665, 124, 74, 24));
    rdoOnlySrnTtl_N.setBounds(new Rectangle(739, 124, 51, 24));
    rdoOnlySrnTtl_N.setText("NO");
    rdoOnlySrnTtl_N.setForeground(new Color(143, 143, 188));
    rdoOnlySrnTtl_N.setFont(new java.awt.Font("Dialog", 1, 11));
    rdoOnlySrnTtl_N.setBackground(Color.white);
    rdoOnlySrnTtl_N.setSelected(true);
    this.add(jLabel1, null);
    jPanel2.add(jLabel117, null);
    jPanel2.add(txt6, null);
    jPanel2.add(txt1, null);
    jPanel2.add(txt11, null);
    jPanel2.add(txt16, null);
    jPanel2.add(txt17, null);
    jPanel2.add(txt12, null);
    jPanel2.add(txt7, null);
    jPanel2.add(txt2, null);
    jPanel2.add(txt3, null);
    jPanel2.add(txt8, null);
    jPanel2.add(txt13, null);
    jPanel2.add(txt18, null);
    jPanel2.add(txt19, null);
    jPanel2.add(txt14, null);
    jPanel2.add(txt9, null);
    jPanel2.add(txt4, null);
    jPanel2.add(txt5, null);
    jPanel2.add(txt10, null);
    jPanel2.add(txt15, null);
    jPanel2.add(txt20, null);
    this.add(btnClearAllSrn, null);
    this.add(do_Print4NotFinal, null);
    this.add(blueBkgWhiteCharLabel2, null);
    this.add(cbxPrintLastPage, null);
    this.add(btnQryShipByDate, null);
    this.add(blueBkgWhiteCharLabel1, null);
    this.add(cbxCenter, null);
    this.add(jPanel2, null);
    this.add(whiteBkgBlueCharLabel1, null);
    this.add(rdoOnlySrnTtl_Y, null);
    if(util.PublicVariable.USER_RECORD.getInt("USR_TYPE")==
       newtimesejb.preproduction.PreProductionHead.USER_TYPE_ACCOUNTING_USERS){
       cbxPrintLastPage.setSelectedIndex(1);
    }

    vctCenters=
        exgui2.CONST.BASIC_MAIN_EJB.getDatas(
        util.PublicVariable.USER_RECORD,
        "select cen_code,cen_name,cen_prefix,CEN_NUMCODE from center where record_delete_flag=1",1,999);
    if(cen_code_prefix==null){
      cen_code_prefix=new java.util.HashMap();
      for(int i=0;i<vctCenters.size();i++){
        Record rec=(Record)vctCenters.get(i);
        cen_code_prefix.put(rec.get(0),rec.get(2));
      }
    }
    dbcbxCenter=new exgui.DataBindJCombobox(
        cbxCenter,"",vctCenters,"cen_name","cen_code",
        util.PublicVariable.OPERATTING_CENTER
     );
    btnGrpOnlySrnTtl.add(rdoOnlySrnTtl_Y);
    this.add(rdoOnlySrnTtl_N, null);
    btnGrpOnlySrnTtl.add(rdoOnlySrnTtl_N);
  }

  java.util.Vector getFieldsData() {
    StringBuffer errorSz=new StringBuffer();
    String prefix_code=(String)cen_code_prefix.get(dbcbxCenter.getSelectedValue());
    try {

      java.util.Vector vec = new java.util.Vector();
      for (int i = 0; i < this.txtField.length; i++) {
        String curTxt = txtField[i].getText().trim();
        if (curTxt.length()>0){
          if (curTxt.length() > 4) {
            if(curTxt.length()==12){
              if (!curTxt.substring(2, 4).equals(prefix_code)) {
                 if (errorSz.length() > 0)errorSz.append(",");
                errorSz.append(curTxt);
              }
           }else{
             //13 leth srn,is below to other centes
             if (!curTxt.substring(3, 5).equals(prefix_code)) {
                if (errorSz.length() > 0)errorSz.append(",");
               errorSz.append(curTxt);
             }
           }
          }
          vec.add(curTxt);
        }
      }
      if(errorSz.length()>0){
        exgui.verification.VerifyLib.showAlert("SRN :"+errorSz.toString()+" Not Belong To This Center",
                                               "SRN missmatch center");
        return null;
      }
      return vec;
    } catch(Exception eFD) {
      eFD.printStackTrace();
      util.ExceptionLog.exp2File(eFD, "error at get SRN NO");
      return null;
    }
  }

  void btnQryShipByDate_actionPerformed(ActionEvent e) {
    String orgOpCenter=util.PublicVariable.OPERATTING_CENTER;
    String cenCode=(String)dbcbxCenter.getSelectedValue();
    String centerPrix=null;
    for(int i=0;i<vctCenters.size();i++){
      Record recCenter=(Record)vctCenters.get(i);
      if(recCenter.get(0).equals(cenCode)){
         centerPrix=(String)(String)recCenter.get(3)+(String)recCenter.get(2);
         util.PublicVariable.OPERATTING_CENTER=(String)recCenter.get(0);
         break;
      }
    }
    DlgQrySrnByDate dlg=new DlgQrySrnByDate(util.PublicVariable.APP_FRAME,"Query By Create Date",
                                            true,centerPrix);
    dlg.setSize(400,400);
    exgui.UIHelper.setToScreenCenter(dlg);
    dlg.show();
    int txtFieldCount=0;
    for(int i=0;i<dlg.selectedSrn.length;i++){
      if(dlg.selectedSrn[i]!=null && dlg.selectedSrn[i].trim().length()>0){
        //txtField[i].setText(dlg.selectedSrn[i]);
        while(txtField[txtFieldCount].getText().trim().length()>0){
          txtFieldCount++;
        }
        if(txtFieldCount<txtField.length){
          txtField[txtFieldCount].setText(dlg.selectedSrn[i]);
        }
      }
    }
    util.PublicVariable.OPERATTING_CENTER=orgOpCenter;
  }

  void btnClearAllSrn_actionPerformed(ActionEvent e) {
    if(!exgui.verification.VerifyLib.showConfirm("Do You Sure To Clear All Text Fileds ?",
                                                 "Do You Sure To Clear All Text Fileds ?",false))return;
    for(int i=0;i<txtField.length;i++){
      txtField[i].setText("");
    }
  }
}
