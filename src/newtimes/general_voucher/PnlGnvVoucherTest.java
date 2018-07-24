package newtimes.general_voucher;
import java.awt.*;
import exgui.*;
import javax.swing.*;
import newtimes.preproduction.buyermakerselect.*;
import java.awt.event.*;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class PnlGnvVoucherTest extends JPanel {
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel1 = new BlueBkgWhiteCharLabel();
  JButton btnExit = new JButton();
  JLabel jLabel1 = new JLabel();
  SelectBuyerMaker slkBuyer = null;
  JButton jButton1 = new JButton();
  JComboBox cbxCenter = new JComboBox();

  public PnlGnvVoucherTest() {
    try {
      jbInit();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
    slkBuyer.init("",null,slkBuyer.TYPE_BUYER,true);
  }

  void jbInit() throws Exception {

    blueBkgWhiteCharLabel1.setText("Local Voucher Function");
    blueBkgWhiteCharLabel1.setBounds(new Rectangle(0, 27, 800, 33));
    this.setLayout(null);
    btnExit.setBackground(Color.white);
    btnExit.setBounds(new Rectangle(346, 538, 108, 30));
    btnExit.setFont(new java.awt.Font("Dialog", 1, 11));
    btnExit.setText("EXIT");
    btnExit.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnExit_actionPerformed(e);
      }
    });
    jLabel1.setText("BUYER");
    jLabel1.setBounds(new Rectangle(200, 128, 93, 27));
    slkBuyer=new SelectBuyerMaker();
    slkBuyer.setBounds(new Rectangle(263, 130, 238, 26));
    jButton1.setBounds(new Rectangle(262, 176, 223, 25));
    jButton1.setText("test");
    jButton1.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        jButton1_actionPerformed(e);
      }
    });
    cbxCenter.setBounds(new Rectangle(264, 224, 220, 25));
    this.add(blueBkgWhiteCharLabel1, null);
    this.add(btnExit, null);
    this.add(jLabel1, null);
    this.add(slkBuyer, null);
    this.add(jButton1, null);
    //this.add(cbxCenter, null);
    new exgui.DataBindJCombobox(
          cbxCenter, "P_OFF_CEN",
           newtimes.preproduction.guis.tempProperties.tmpOffShores,
           "CEN_NAME", "CEN_CODE",
           null,"ALL","ALL");

  }

  void btnExit_actionPerformed(ActionEvent e) {
    try{
       processhandler.template.Properties.getCenteralControler().goBack();
    }catch(Exception exp){
      exp.printStackTrace();
     }

  }

  void jButton1_actionPerformed(ActionEvent e) {
    try{
      newtimesejb.GnVoucher.GnVoucherFacadeHome fc=
          (newtimesejb.GnVoucher.GnVoucherFacadeHome)
          info_ejb.WeblogicServiceLocator.locateServiceHome(util.PublicVariable.SERVER_URL,
          "newtimesejb.GnVoucher.GnVoucherFacade");

      //System.out.println("newtimesejb.GnVoucher.GnVoucherFacade ECHO "+testEjb.echo(" john "));



      java.util.Vector vcttest=
          exgui2.CONST.BASIC_MAIN_EJB.getDatas(
          util.PublicVariable.USER_RECORD,
          "select * from center",1,999);
       for(int i=0;i<vcttest.size();i++){
         database.datatype.Record rec=(database.datatype.Record)vcttest.get(i);
         System.out.println("----- center data ---"+rec.toString());
       }
    }catch(Exception exp){
      exp.printStackTrace();
    }
  }
}
