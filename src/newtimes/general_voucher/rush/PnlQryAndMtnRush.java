package newtimes.general_voucher.rush;

import java.awt.*;
import exgui.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;
import database.datatype.*;
/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */
/*
 allow uswer to  query and modify RUSH's records
 RUSH yyyymm can be 999999 or specified year & month
 all column are able to be mofied.

 */
public class PnlQryAndMtnRush extends JPanel {
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel1 = new BlueBkgWhiteCharLabel();
  WhiteBkgBlueCharLabel whiteBkgBlueCharLabel1 = new WhiteBkgBlueCharLabel();
  JTextField txtYYYYMM = new JTextField();
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel2 = new BlueBkgWhiteCharLabel();
  JComboBox cbxCompany = new JComboBox();
  WhiteBkgBlueCharLabel whiteBkgBlueCharLabel2 = new WhiteBkgBlueCharLabel();
  JTextField txtDC = new JTextField();
  WhiteBkgBlueCharLabel whiteBkgBlueCharLabel3 = new WhiteBkgBlueCharLabel();
  JComboBox cbxAcc = new JComboBox();
  JButton btnQry = new JButton();
  JButton btnExit = new JButton();
  exgui.DataBindJCombobox    dbCbxCompany=null,dbCbxAccItem=null;

  public PnlQryAndMtnRush() {
    try {
      jbInit();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }

  void jbInit() throws Exception {
    blueBkgWhiteCharLabel1.setText("RUSH MAINTAIN");
    blueBkgWhiteCharLabel1.setBounds(new Rectangle(0, 13, 801, 30));
    this.setBackground(new Color(202, 202, 224));
    this.setLayout(null);
    whiteBkgBlueCharLabel1.setBackground(new Color(143, 143, 188));
    whiteBkgBlueCharLabel1.setFont(new java.awt.Font("Dialog", 0, 14));
    whiteBkgBlueCharLabel1.setForeground(Color.white);
    whiteBkgBlueCharLabel1.setText("¨R±bÀÉYYYYMM");
    whiteBkgBlueCharLabel1.setBounds(new Rectangle(191, 118, 186, 28));
    txtYYYYMM.setText("999999");
    txtYYYYMM.setBounds(new Rectangle(376, 118, 120, 28));
    blueBkgWhiteCharLabel2.setBackground(Color.white);
    blueBkgWhiteCharLabel2.setForeground(new Color(143, 143, 188));
    blueBkgWhiteCharLabel2.setText("COMPANY");
    blueBkgWhiteCharLabel2.setBounds(new Rectangle(191, 83, 186, 28));
    cbxCompany.setBounds(new Rectangle(377, 83, 239, 28));
    whiteBkgBlueCharLabel2.setBounds(new Rectangle(545, 118, 32, 28));
    whiteBkgBlueCharLabel2.setBackground(new Color(143, 143, 188));
    whiteBkgBlueCharLabel2.setForeground(Color.white);
    whiteBkgBlueCharLabel2.setText("D/C");
    txtDC.setText("");
    txtDC.setBounds(new Rectangle(578, 118, 37, 28));
    whiteBkgBlueCharLabel3.setBounds(new Rectangle(191, 154, 186, 28));
    whiteBkgBlueCharLabel3.setText("ACC# ");
    cbxAcc.setBounds(new Rectangle(378, 154, 239, 28));
    btnQry.setBounds(new Rectangle(530, 201, 87, 28));
    btnQry.setFont(new java.awt.Font("Dialog", 1, 11));
    btnQry.setText("EXTRACT");
    btnQry.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnQry_actionPerformed(e);
      }
    });
    btnExit.setText("EXIT");
    btnExit.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnExit_actionPerformed(e);
      }
    });
    btnExit.setBounds(new Rectangle(357, 527, 87, 28));
    btnExit.setFont(new java.awt.Font("Dialog", 1, 11));
    this.add(blueBkgWhiteCharLabel1, null);
    this.add(whiteBkgBlueCharLabel3, null);
    this.add(blueBkgWhiteCharLabel2, null);
    this.add(whiteBkgBlueCharLabel2, null);
    this.add(whiteBkgBlueCharLabel1, null);
    this.add(cbxCompany, null);
    this.add(txtYYYYMM, null);
    this.add(txtDC, null);
    this.add(cbxAcc, null);
    this.add(btnQry, null);
    this.add(btnExit, null);

    dbCbxCompany =
      new exgui.DataBindJCombobox(cbxCompany, "",
                                  newtimes.general_voucher.daily_voucher.
                                  Constants.VCT_GV_ACC_COMPANY,
                                  "comp_code_and_name", "cmp_code",null);
   StringBuffer sb=new StringBuffer();
   sb.append("select a.*,b.ITEM_NAME,a.acc_code||'--'||b.item_name as code_and_name from VH_RX_ACC_ITEM a ,GV_ACC_ITEM b ");
   sb.append(" where a.acc_code=b.ITEM_CODE order by a.acc_code");

    Vector vctAcc4Rx=exgui2.CONST.BASIC_MAIN_EJB.getDatas(
      util.PublicVariable.USER_RECORD,sb.toString(),1,9999);

   dbCbxAccItem =
     new exgui.DataBindJCombobox(cbxAcc, "",
                                vctAcc4Rx,
                                "code_and_name", "acc_code",null,"ALL",null);


  }

  void btnExit_actionPerformed(ActionEvent e) {
    try{
      processhandler.template.Properties.getCenteralControler().goBack();
    }catch(Exception exp){
      exp.printStackTrace();
    }

  }
   java.util.Vector getRecord(int bgn,int rowcount)throws Exception{
    StringBuffer sb=new StringBuffer();
    Vector vct2Return=null;//new Vector();
    sb.append("select a.*,");
    sb.append("(select b.vH_SEQ from vh_detail b where B.GLB_SEQ=A.GLB_SEQ ) as vh_seq,");
    sb.append("(select C.rec_desc from  GV_ACC_DATA c where C.acc_CODE=a.vh_account and  yyyymm='999999') as acc_tw_name ");
    sb.append(" from VH_DETAIL_RUSH a ");
    sb.append(" where  ");
    //sb.append(" a.GLB_SEQ=b.GLB_SEQ and ");
    sb.append("   a.record_delete_flag='1' ");
    if(txtYYYYMM.getText().trim().length()>0){
       sb.append(" and  a.RUSH_YYYYMM='");
       sb.append(util.MiscFunc.Replace(txtYYYYMM.getText().trim(),"'","''"));
       sb.append("' ");
    }else{
      sb.append(" and  a.RUSH_YYYYMM='999999'");
    }
    if(txtDC.getText().trim().length()>0){
      sb.append(" and a.VH_DC ='");
      sb.append(txtDC.getText().trim().toUpperCase());
      sb.append("' ");
    }
    sb.append(" and substr(a.VH_NO,1,1)='");sb.append(dbCbxCompany.getSelectedValue());sb.append("' ");
    String accType=(String)dbCbxAccItem.getSelectedValue();
    if(accType!=null){
      sb.append(" and substr(a.VH_ACCOUNT,1,4)='");
      sb.append(accType);
      sb.append("' ");
    }
    sb.append("order by a.vh_no,(select b.vH_SEQ from vh_detail b where B.GLB_SEQ=A.GLB_SEQ ) ");
     vct2Return=exgui2.CONST.BASIC_MAIN_EJB.getDatas(
      util.PublicVariable.USER_RECORD,sb.toString(),bgn,rowcount);
     System.out.print(sb);
    return vct2Return;
  }
  void btnQry_actionPerformed(ActionEvent e) {
     if(txtDC.getText().length()>0){
       String dcValue=txtDC.getText().trim();
       if(!(dcValue.equalsIgnoreCase("D")||dcValue.equalsIgnoreCase("C"))){
         exgui.verification.VerifyLib.showAlert("D/C code only allow \"D\" or \"C\" ","D/C code out of Range");
         return;
       }
     }
     try{
       TgrRxListEdit tgr = new TgrRxListEdit();
       processhandler.template.Properties.getCenteralControler().
           doCommandExecute(tgr);
     }catch(Exception exp){
       exp.printStackTrace();
     }

  }
}
