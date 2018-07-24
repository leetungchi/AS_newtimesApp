package newtimes.accounting.debit_note;

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

public class DlgChangeDbHeadRmkSty extends JDialog {
  JPanel panel1 = new JPanel();
  JLabel jLabel1 = new JLabel();
  JTextField txtCol1 = new JTextField();
  JButton btnUpdate = new JButton();
  JButton btnExit = new JButton();
  PnlEditDebitNoteDetail pnlParent;
  JComboBox cbxColumnStored = new JComboBox(
                                   new String[]{
                                     "Select Column Title ,Please",
                                     "NAME         PAYROLL   PENSION  INSURANCE   TTL-NTD   TTL-USD",
                                     "NAME     PAYROLL PENSION  INSURANCE  TRAVEL  TTL-NTD  TTL-USD",
                                     "PO NO.          DESCRIPTION",
                                     "REF NO.            DESCRIPTION",
                                     "REF NO.        P.O.#       STYLE#    Q'TY         @/PC"
                                   }
                                );
  public DlgChangeDbHeadRmkSty(Frame frame, String title, boolean modal,PnlEditDebitNoteDetail _parent) {
    super(frame, title, modal);
    try {
      jbInit();
      pack();
      pnlParent=_parent;

      Object vftxtSeqItem = exgui.verification.CellFormat.getOrdinaryField(500);
      new exgui.DataBindTextWithChecker(txtCol1,
                "",
                pnlParent.lblDebitNoteHeadStyRemarkCol1.getText(), 500,
                (exgui.Object2String)vftxtSeqItem,
                (exgui.ultratable.CellTxtEditorFormat)vftxtSeqItem);


    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }

  public DlgChangeDbHeadRmkSty() {
    this(null, "", false,null);
  }

  private void jbInit() throws Exception {
    panel1.setLayout(null);
    jLabel1.setFont(new java.awt.Font("Dialog", 1, 11));
    jLabel1.setText("COLUM:");
    jLabel1.setBounds(new Rectangle(35, 68, 73, 27));
    txtCol1.setFont(new java.awt.Font("DialogInput", 0, 11));
    txtCol1.setText("");
    txtCol1.setBounds(new Rectangle(117, 68, 450, 28));
    btnUpdate.setBounds(new Rectangle(318, 174, 123, 28));
    btnUpdate.setFont(new java.awt.Font("Dialog", 1, 11));
    btnUpdate.setText("UPDATE");
    btnUpdate.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnUpdate_actionPerformed(e);
      }
    });
    btnExit.setText("EXIT");
    btnExit.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnExit_actionPerformed(e);
      }
    });
    btnExit.setBounds(new Rectangle(153, 174, 123, 28));
    btnExit.setFont(new java.awt.Font("Dialog", 1, 11));
    btnExit.setForeground(Color.red);
    this.setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
    cbxColumnStored.setBounds(new Rectangle(117, 117, 450, 27));
    cbxColumnStored.addItemListener(new java.awt.event.ItemListener() {
      public void itemStateChanged(ItemEvent e) {
        cbxColumnStored_itemStateChanged(e);
      }
    });
    getContentPane().add(panel1);
    panel1.add(jLabel1, null);
    panel1.add(txtCol1, null);
    panel1.add(btnExit, null);
    panel1.add(btnUpdate, null);
    panel1.add(cbxColumnStored, null);
  }

  void btnUpdate_actionPerformed(ActionEvent e) {
    try{
      util.MiscFunc.showProcessingMessage();
      newtimesejb.TPE_MIS.TpeMisFuncHome ejbHome=
          (newtimesejb.TPE_MIS.TpeMisFuncHome)
          info_ejb.WeblogicServiceLocator.locateServiceHome(util.PublicVariable.SERVER_URL,
          "newtimesejb.TPE_MIS.TpeMisFunc");
      newtimesejb.TPE_MIS.TpeMisFunc ejb=ejbHome.create();
      java.util.HashMap hm=new java.util.HashMap();
      hm.put("TPEMISCFUNC_ACTION_CODE","UPDATE_DEBITNOTE_HEAD_STY_REMARK_FIELDS");
      hm.put("user_code",util.PublicVariable.USER_RECORD.get(0));
      hm.put("DBNT_NO",Constans.EDITING_DEBITNOTE_HEAD_ECORD.get(0));
      hm.put("DBNT_STY_RMK_COL1",txtCol1.getText());
      hm.put("DBNT_STY_RMK_COL2",null);
      ejb.tpeMisFunc(hm);

      Constans.EDITING_DEBITNOTE_HEAD_ECORD.set("DBNT_STY_RMK_COL1",txtCol1.getText());
      Constans.EDITING_DEBITNOTE_HEAD_ECORD.set("DBNT_STY_RMK_COL2",null);
      Constans.EDITING_DEBITNOTE_HEAD_ECORD.getModifiedFields().clear();
      pnlParent.lblDebitNoteHeadStyRemarkCol1.setText(txtCol1.getText());
      pnlParent.lblDebitNoteHeadStyRemarkCol1.validate();
      this.hide();
    }catch(Exception exp){
      exp.printStackTrace();
      util.ExceptionLog.exp2File(exp,"");
      exgui.verification.VerifyLib.showAlert("Server Side Error!!\nPlease Contact System Manager",
                                             "Error While Update Style Remark Col.");

    }finally{
      util.MiscFunc.hideProcessingMessage();
    }

  }

  void btnExit_actionPerformed(ActionEvent e) {
     this.hide();
  }

  void cbxColumnStored_itemStateChanged(ItemEvent e) {
      if(e.getID()==e.ITEM_STATE_CHANGED){
          if(cbxColumnStored.getSelectedIndex()!=0){
            txtCol1.setText(cbxColumnStored.getSelectedItem().toString());
          }
      }
  }
}
