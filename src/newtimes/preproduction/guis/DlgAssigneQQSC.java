package newtimes.preproduction.guis;

import java.awt.*;
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

public class DlgAssigneQQSC extends JDialog {
  JPanel panel1 = new JPanel();
  JLabel jLabel1 = new JLabel();
  JTextField txtSC = new JTextField();
  JButton btnExit = new JButton();
  JButton btnAssigne = new JButton();

  public DlgAssigneQQSC(Frame frame, String title, boolean modal) {
    super(frame, title, modal);
    try {
      jbInit();
      pack();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }

  public DlgAssigneQQSC() {
    this(null, "", false);
  }

  private void jbInit() throws Exception {
    panel1.setLayout(null);
    jLabel1.setFont(new java.awt.Font("Dialog", 1, 11));
    jLabel1.setText("PLEASE ASSIGNE S/C");
    jLabel1.setBounds(new Rectangle(20, 51, 139, 28));
    txtSC.setText("");
    txtSC.setBounds(new Rectangle(160, 54, 184, 26));
    btnExit.setBounds(new Rectangle(35, 125, 96, 26));
    btnExit.setFont(new java.awt.Font("Dialog", 1, 11));
    btnExit.setForeground(Color.red);
    btnExit.setText("EXIT");
    btnExit.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnExit_actionPerformed(e);
      }
    });
    btnAssigne.setBounds(new Rectangle(234, 125, 108, 28));
    btnAssigne.setFont(new java.awt.Font("Dialog", 1, 11));
    btnAssigne.setText("ASSIGNE");
    btnAssigne.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnAssigne_actionPerformed(e);
      }
    });
    this.setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
    getContentPane().add(panel1);
    panel1.add(jLabel1, null);
    panel1.add(txtSC, null);
    panel1.add(btnAssigne, null);
    panel1.add(btnExit, null);
  }

  void btnExit_actionPerformed(ActionEvent e) {
     txtSC.setText("");
     this.dispose();
  }

  void btnAssigne_actionPerformed(ActionEvent e) {
    String destSCNO=txtSC.getText().trim().toUpperCase();
    if(destSCNO.length()==12&&
       destSCNO.startsWith("SATWQQ")){
       //checking if S/C ready exists
       try{
         util.MiscFunc.showProcessingMessage();
         java.util.Vector vctTemp =
             exgui2.CONST.BASIC_MAIN_EJB.getDatas(
             util.PublicVariable.USER_RECORD,
             "select prod_sc_no from production where prod_sc_no='" +
             util.MiscFunc.Replace(destSCNO, "'", "''") + "'",
             1, 999999
             );
         if(vctTemp.size()>0){
           exgui.verification.VerifyLib.showAlert("S/C Already Exists\nPlease Assigne Another S/C",
                                                  "S/C Exists");
           return;
         }
         database.datatype.Record rec2Update=(database.datatype.Record)util.MiscFunc.deepCopy(newtimes.preproduction.Constants.CURRENT_PREPROD_HEAD_RECORD);


         rec2Update.getFieldName().add("PRODUCTION_SC_NO");
         rec2Update.getValueFields().add(destSCNO);
         rec2Update.set("PRODUCTION_SC_NO",destSCNO);
         rec2Update.set("record_modify_user",util.PublicVariable.USER_RECORD.get(0));

         newtimesejb.preproduction.PreProductionHeadHome ejbHome=
             (newtimesejb.preproduction.PreProductionHeadHome)
             info_ejb.WeblogicServiceLocator.locateServiceHome(
             util.PublicVariable.SERVER_URL ,
             "newtimesejb.preproduction.PreProductionHead");
         newtimesejb.preproduction.PreProductionHead ejb=ejbHome.create();
         ejb.handlePreproductionAndHead(rec2Update,null);

         this.dispose();


       }catch(Exception exp){
         exp.printStackTrace();
       }finally{
           util.MiscFunc.hideProcessingMessage();
       }
    }else{
      exgui.verification.VerifyLib.showAlert("S/C Format Error",
                                             "S/C Format Error");


    }

  }
}
