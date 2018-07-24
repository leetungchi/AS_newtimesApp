package newtimes.production.gui.prodmaintain;

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

public class DlgUpdateAllStyles extends JDialog {
  JPanel panel1 = new JPanel();
  ChainedPnlDftStyleValue chainedPnlDftStyleValue1 = new ChainedPnlDftStyleValue();
  JButton btnCancel = new JButton();
  JButton btnOK = new JButton();
  protected int myOperationStatus=0;
  public static int STATUS_OPERATING=0;
  public static int STATUS_CLOSE_NORMALLY=1;
  public static int STATUS_CLOSE_CANCEL=2;
 newtimes.production.process.prodmaintain.DB_NTHKStyleListHandler  db_StyleListHandler;
 boolean isToModifyStyles=false;
 public DlgUpdateAllStyles(Frame frame, String title, boolean modal,
                              newtimes.production.process.prodmaintain.DB_NTHKStyleListHandler _db_StyleListHandler,
                              boolean isToModify) {

  super(frame, title, modal);
  if(isToModify)chainedPnlDftStyleValue1 = new ChanedPnlModifyStyleValues();
  try {
    db_StyleListHandler=_db_StyleListHandler;
    jbInit();
    if(db_StyleListHandler!=null){
      chainedPnlDftStyleValue1.setPagedDataFactory(db_StyleListHandler);
      database.datatype.Record blankStyle=exgui2.CONST.BASIC_MAIN_EJB.getBlankRecord("style_tbl");
      //chainedPnlDftStyleValue1.setRecord(db_StyleListHandler.getBlankRecord());
      blankStyle.set("prod_head_pk",newtimes.preproduction.Constants.CURRENT_PREPROD_HEAD_PK);
      chainedPnlDftStyleValue1.setRecord(blankStyle);
      chainedPnlDftStyleValue1.record2Gui();
    }
    pack();
  }
  catch(Exception ex) {
    ex.printStackTrace();
  }
 }
  public DlgUpdateAllStyles(Frame frame, String title, boolean modal,
                                newtimes.production.process.prodmaintain.DB_NTHKStyleListHandler _db_StyleListHandler) {
    super(frame, title, modal);
    try {
      db_StyleListHandler=_db_StyleListHandler;
      jbInit();
      if(db_StyleListHandler!=null){
        chainedPnlDftStyleValue1.setPagedDataFactory(db_StyleListHandler);
        chainedPnlDftStyleValue1.setRecord(db_StyleListHandler.getBlankRecord());
        chainedPnlDftStyleValue1.record2Gui();
      }
      pack();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }

  public DlgUpdateAllStyles() {
    this(null, "", false,null);
  }
  public void show(){
    this.myOperationStatus=STATUS_OPERATING;
    super.show();
  }
  public void setStyNo2Follow(String styNo2Follow){
    chainedPnlDftStyleValue1.setStyNo2Follow(styNo2Follow);
  }
  protected void jbInit() throws Exception {
    panel1.setLayout(null);
    chainedPnlDftStyleValue1.setBounds(new Rectangle(0, 12, 560, 353));
    btnCancel.setBounds(new Rectangle(34, 371, 106, 29));
    btnCancel.setFont(new java.awt.Font("Dialog", 1, 11));
    btnCancel.setText("CANCEL");
    btnCancel.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnCancel_actionPerformed(e);
      }
    });
    btnOK.setText("OK");
    btnOK.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnOK_actionPerformed(e);
      }
    });
    btnOK.setBounds(new Rectangle(402, 371, 106, 29));
    btnOK.setFont(new java.awt.Font("Dialog", 1, 11));
    getContentPane().add(panel1);
    panel1.add(chainedPnlDftStyleValue1, null);
    panel1.add(btnCancel, null);
    panel1.add(btnOK, null);
  }

  void btnOK_actionPerformed(ActionEvent e) {
    try{
      boolean result=chainedPnlDftStyleValue1.btnOK_actionPerformed(null);
      if(!result) return;
      this.myOperationStatus=STATUS_CLOSE_NORMALLY;
      this.dispose();
    }catch(Exception exp){
      exp.printStackTrace();
      util.ExceptionLog.exp2File(exp,"");
      exgui.verification.VerifyLib.showAlert("Error While Insert Styles\nPlease Contact System Manager",
                                             "Error While Insert Style Records");

    }
  }

  void btnCancel_actionPerformed(ActionEvent e) {
    this.myOperationStatus=STATUS_CLOSE_CANCEL;
    this.dispose();
  }
}
