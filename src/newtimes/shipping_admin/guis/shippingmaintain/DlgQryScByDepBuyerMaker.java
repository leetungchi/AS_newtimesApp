package newtimes.shipping_admin.guis.shippingmaintain;

import java.awt.*;
import javax.swing.*;
import newtimes.preproduction.buyermakerselect.*;
import exgui.*;
import java.awt.event.*;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class DlgQryScByDepBuyerMaker extends JDialog {
  JPanel panel1 = new JPanel();
  JLabel jLabel2 = new JLabel();
  SelectBuyerMaker slkBuyer = new SelectBuyerMaker();
  JComboBox cbxDep = new JComboBox();
  JLabel jLabel1 = new JLabel();
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel1 = new BlueBkgWhiteCharLabel();
  JLabel jLabel3 = new JLabel();
  SelectBuyerMaker slkMaker = new SelectBuyerMaker();
  JButton btnOK = new JButton();
  JButton btnExit = new JButton();
  String finalSc=null;
  int finalProdHeadPk=-1;
  exgui.DataBindJCombobox dbCbxDep=null;
  public DlgQryScByDepBuyerMaker(Frame frame, String title, boolean modal) {
    super(frame, title, modal);
    try {
      jbInit();
      pack();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }

  public DlgQryScByDepBuyerMaker() {
    this(null, "", false);
  }

  private void jbInit() throws Exception {
    panel1.setLayout(null);
    jLabel2.setBounds(new Rectangle(126, 130, 75, 27));
    jLabel2.setText("BUYER");
    jLabel2.setFont(new java.awt.Font("Dialog", 1, 11));
    slkBuyer.setBounds(new Rectangle(216, 131, 198, 26));
    cbxDep.setBounds(new Rectangle(215, 91, 162, 28));
    jLabel1.setFont(new java.awt.Font("Dialog", 1, 11));
    jLabel1.setText(" DEPARTMENT");
    jLabel1.setBounds(new Rectangle(126, 91, 88, 27));
    blueBkgWhiteCharLabel1.setText("INIT SRN BY S/C WITH BUYER & MAKER");
    blueBkgWhiteCharLabel1.setBounds(new Rectangle(-1, 31, 502, 34));
    jLabel3.setFont(new java.awt.Font("Dialog", 1, 11));
    jLabel3.setText("MAKER");
    jLabel3.setBounds(new Rectangle(126, 169, 75, 27));
    slkMaker.setBounds(new Rectangle(216, 169, 198, 26));
    btnOK.setBounds(new Rectangle(89, 248, 113, 29));
    btnOK.setFont(new java.awt.Font("Dialog", 1, 11));
    btnOK.setText("OK");
    btnOK.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnOK_actionPerformed(e);
      }
    });
    btnExit.setText("EXIT");
    btnExit.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnExit_actionPerformed(e);
      }
    });
    btnExit.setBounds(new Rectangle(300, 248, 113, 29));
    btnExit.setFont(new java.awt.Font("Dialog", 1, 11));
    getContentPane().add(panel1);
    panel1.add(jLabel2, null);
    panel1.add(slkBuyer, null);
    panel1.add(cbxDep, null);
    panel1.add(jLabel1, null);
    panel1.add(jLabel3, null);
    panel1.add(slkMaker, null);
    panel1.add(blueBkgWhiteCharLabel1, null);
    panel1.add(btnOK, null);
    panel1.add(btnExit, null);
    dbCbxDep=
       new exgui.DataBindJCombobox(
            cbxDep,"P_DEP",
            newtimes.preproduction.guis.tempProperties.tmpDepartment,
            "DEP_NAME", "DEP_CODE",null);

    slkBuyer.init("buyer",null,slkBuyer.TYPE_BUYER,true);
    slkMaker.init("buyer",null,slkBuyer.TYPE_MAKER,true);

  }

  void btnOK_actionPerformed(ActionEvent e) {
    if(slkBuyer.getSelectedValue()==null){
      exgui.verification.VerifyLib.showAlert("Please Select Buyer","Please Select Buyer");
      return;
    }
    if(slkMaker.getSelectedValue()==null){
      exgui.verification.VerifyLib.showAlert("Please Select Maker","Please Select Maker");
      return;
    }
    util.MiscFunc.showProcessingMessage();
    try{
      StringBuffer sb=new StringBuffer();
      sb.append("select * from (select a.prod_head_pk,a.prod_sc_no from production a ,prod_head b ");
      sb.append("where a.prod_head_pk=b.prod_head_pk ");

      sb.append("and b.PROD_BUYER=");sb.append(slkBuyer.getSelectedValue().toString());sb.append(" ");
      sb.append("and b.PROD_MAKER=");sb.append(slkMaker.getSelectedValue().toString());sb.append(" ");
      sb.append("and b.PROD_DEPTMENT='");sb.append(dbCbxDep.getSelectedValue());sb.append("' ");
      sb.append("and a.prod_sc_no is not null ");
      sb.append("and a.record_delete_flag='1' ");
      sb.append("and b.PROD_CEN_CODE='001' ORDER BY prod_head_pk desc) ");
      sb.append("where rownum=1 ");
      sb.toString();

      java.util.Vector vct=exgui2.CONST.BASIC_MAIN_EJB.getDatas(
       util.PublicVariable.USER_RECORD,
       sb.toString(),
       1,999999
      );

      if(vct.size()==0){
        exgui.verification.VerifyLib.showAlert("Sorry,Not Such S/C Matches Your Condition","No S/C# Found");
        return;
      }
      database.datatype.Record rec=
          (database.datatype.Record)vct.get(0);
      finalSc=(String)rec.get(1);
      finalProdHeadPk=rec.getInt(0);
      this.dispose();
    }catch(Exception exp){
      exp.printStackTrace();

    }finally{
      util.MiscFunc.hideProcessingMessage();
    }
  }

  void btnExit_actionPerformed(ActionEvent e) {
    finalSc=null;
    finalProdHeadPk=-1;
   this.dispose();
  }
}
