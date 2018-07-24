package newtimes.accounting;

import java.awt.*;
import exgui.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.border.*;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class PnlListFabComm extends JPanel {
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel1 = new BlueBkgWhiteCharLabel();
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel2 = new BlueBkgWhiteCharLabel();
  JButton btnExit = new JButton();
  JButton btnUpdate = new JButton();
  JPanel jPanel1 = new JPanel();
  BorderLayout borderLayout1 = new BorderLayout();
  JPanel jPanel2 = new JPanel();
  TitledBorder titledBorder1;
  JLabel jLabel1 = new JLabel();
  JTextField txtPI_Rcv = new JTextField();
  JLabel jLabel2 = new JLabel();
  JTextField txtDisc_Rcv = new JTextField();
  JButton btnCopy2Select = new JButton();
  exgui.DataBindTextWithChecker dbTxtPI_Rcv,dbTxtDisc_Rcv;
  PnlListFabCommInter  intpnl;
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel3 = new BlueBkgWhiteCharLabel();
  public PnlListFabComm() {
    try {
      jbInit();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }

  void jbInit() throws Exception {
    titledBorder1 = new TitledBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED,Color.white,Color.white,new Color(103, 101, 98),new Color(148, 145, 140)),"");
    blueBkgWhiteCharLabel1.setText("FABRIC COMMISION LIST");
    blueBkgWhiteCharLabel1.setBounds(new Rectangle(-1, 18, 802, 32));
    this.setBackground(new Color(202, 202, 225));
    this.setLayout(null);
    blueBkgWhiteCharLabel2.setText("");
    blueBkgWhiteCharLabel2.setBounds(new Rectangle(0, 534, 689, 29));
    btnExit.setBounds(new Rectangle(688, 534, 98, 29));
    btnExit.setFont(new java.awt.Font("Dialog", 1, 11));
    btnExit.setText("EXIT");
    btnExit.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnExit_actionPerformed(e);
      }
    });
    btnUpdate.setBounds(new Rectangle(688, 498, 98, 29));
    btnUpdate.setFont(new java.awt.Font("Dialog", 1, 11));
    btnUpdate.setText("UPDATE");
    btnUpdate.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnUpdate_actionPerformed(e);
      }
    });
    jPanel1.setBounds(new Rectangle(7, 56, 785, 439));
    jPanel1.setLayout(borderLayout1);
    jPanel2.setBackground(new Color(202, 202, 225));
    jPanel2.setBorder(titledBorder1);
    jPanel2.setBounds(new Rectangle(1, 499, 642, 32));
    jPanel2.setLayout(null);
    jLabel1.setFont(new java.awt.Font("Dialog", 1, 11));
    jLabel1.setText("PI Rcv Date:");
    jLabel1.setBounds(new Rectangle(11, 4, 74, 20));
    txtPI_Rcv.setText("");
    txtPI_Rcv.setBounds(new Rectangle(83, 4, 93, 20));
    jLabel2.setBounds(new Rectangle(198, 4, 115, 20));
    jLabel2.setText("Discount Rcv Date:");
    jLabel2.setFont(new java.awt.Font("Dialog", 1, 11));
    txtDisc_Rcv.setBounds(new Rectangle(314, 4, 93, 20));
    txtDisc_Rcv.setText("");
    btnCopy2Select.setBounds(new Rectangle(460-15, 6-2, 160+25, 23));
    btnCopy2Select.setFont(new java.awt.Font("Dialog", 1, 11));
    btnCopy2Select.setText("COPY To \"Checked\" Row(s)");
    btnCopy2Select.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnCopy2Select_actionPerformed(e);
      }
    });
    blueBkgWhiteCharLabel3.setBounds(new Rectangle(785, 534, 21, 29));
    blueBkgWhiteCharLabel3.setText("");
    jPanel2.add(jLabel1, null);
    jPanel2.add(txtPI_Rcv, null);
    jPanel2.add(jLabel2, null);
    jPanel2.add(txtDisc_Rcv, null);
    jPanel2.add(btnCopy2Select, null);
    this.add(btnExit, null);
    this.add(blueBkgWhiteCharLabel3, null);
    this.add(blueBkgWhiteCharLabel1, null);
    this.add(jPanel1, null);
    this.add(blueBkgWhiteCharLabel2, null);
    intpnl=new PnlListFabCommInter();
    jPanel1.add(intpnl,borderLayout1.CENTER);
    this.add(btnUpdate, null);
    this.add(jPanel2, null);
    Object dateVfy = exgui.verification.CellFormat.getDateStringFormaterAllowNull();
    dbTxtPI_Rcv =
        new exgui.DataBindTextWithChecker(txtPI_Rcv, "DEL_BE", null,
                                          10, (exgui.Object2String)dateVfy,
                                          (exgui.ultratable.
                                           CellTxtEditorFormat)dateVfy);

    dbTxtDisc_Rcv =
        new exgui.DataBindTextWithChecker(txtDisc_Rcv, "DEL_EN", null,
                                          10, (exgui.Object2String)dateVfy,
                                          (exgui.ultratable.
                                           CellTxtEditorFormat)dateVfy);

    intpnl.firstPage();
  }

  void btnExit_actionPerformed(ActionEvent e) {
    try{
       processhandler.template.Properties.getCenteralControler().goBack();
    }catch(Exception exp){
      exp.printStackTrace();
    }

  }

  void btnCopy2Select_actionPerformed(ActionEvent e) {
     if(dbTxtDisc_Rcv.isValidx() && dbTxtPI_Rcv.isValidx()){
       String objPiRcv=txtPI_Rcv.getText().trim();
       String objDiscRcv=txtDisc_Rcv.getText().trim();
       for(int i=0;i<intpnl.getJtable().getRowCount();i++){
         Object objSelect=intpnl.getJtable().getValueAt(i,0);
         if(((Boolean)objSelect).booleanValue()){
           if(objPiRcv.trim().length()>0){
             intpnl.getJtable().setValueAt(objPiRcv, i,
                                           intpnl.getJtable().getColumnCount()
                                           -2-1);
           }
           if(objDiscRcv.trim().length()>0){
             intpnl.getJtable().setValueAt(objDiscRcv, i,
                                           intpnl.getJtable().getColumnCount()
                                           -1-1);
           }
         }
       }
     }
  }

  void btnUpdate_actionPerformed(ActionEvent e) {
    try{
      util.MiscFunc.showProcessingMessage();
      intpnl.confirmUpdate();
      intpnl.reload();
    }catch(Exception exp){
      exp.printStackTrace();
      util.ExceptionLog.exp2File(exp,"");
      exgui.verification.VerifyLib.showAlert("Update Fail,Please Constact System Manager",
                                             "Update Fail");
    }finally{
      util.MiscFunc.hideProcessingMessage();
    }
  }
}
