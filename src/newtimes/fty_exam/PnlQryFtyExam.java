package newtimes.fty_exam;

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

public class PnlQryFtyExam extends JPanel {
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel1 = new BlueBkgWhiteCharLabel();
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel2 = new BlueBkgWhiteCharLabel();
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel3 = new BlueBkgWhiteCharLabel();
  JComboBox cbxBuyerName = new JComboBox();
  JTextField txtExamDate = new JTextField();
  JButton btnQry = new JButton();
  JButton btnExit = new JButton();
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel4 = new BlueBkgWhiteCharLabel();
  JTextField txtMaker = new JTextField();
  exgui.DataBindJCombobox dbcbx=null;
  exgui.DataBindTextWithChecker dbExamDateB4;
  public PnlQryFtyExam() {
    try {
      jbInit();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }

  void jbInit() throws Exception {
    blueBkgWhiteCharLabel1.setFont(new java.awt.Font("Dialog", 0, 16));
    blueBkgWhiteCharLabel1.setText("驗廠事件查詢");
    blueBkgWhiteCharLabel1.setBounds(new Rectangle(-1, 16, 804, 42));
    this.setLayout(null);
    this.setFont(new java.awt.Font("Dialog", 0, 16));
    blueBkgWhiteCharLabel2.setText("BUYER NAME");
    blueBkgWhiteCharLabel2.setBounds(new Rectangle(214, 101, 117, 28));
    blueBkgWhiteCharLabel3.setBounds(new Rectangle(214, 187, 179, 28));
    blueBkgWhiteCharLabel3.setText("Next Exam Date Before");
    cbxBuyerName.setBounds(new Rectangle(331, 101, 241, 27));
    txtExamDate.setText("");
    txtExamDate.setBounds(new Rectangle(394, 188, 76, 26));
    btnQry.setText("QUERY");
    btnQry.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnQry_actionPerformed(e);
      }
    });
    btnQry.setFont(new java.awt.Font("Dialog", 1, 12));
    btnQry.setBounds(new Rectangle(336, 479, 99, 30));
    btnExit.setBounds(new Rectangle(635, 479, 99, 30));
    btnExit.setFont(new java.awt.Font("Dialog", 1, 12));
    btnExit.setForeground(Color.red);
    btnExit.setText("EXIT");
    btnExit.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnExit_actionPerformed(e);
      }
    });
    blueBkgWhiteCharLabel4.setText("MAKER NAME");
    blueBkgWhiteCharLabel4.setBounds(new Rectangle(214, 140, 146, 28));
    txtMaker.setBounds(new Rectangle(360, 140, 211, 28));
    txtMaker.setText("");
    this.add(blueBkgWhiteCharLabel1, null);
    this.add(cbxBuyerName, null);
    this.add(blueBkgWhiteCharLabel2, null);
    this.add(btnExit, null);
    this.add(btnQry, null);
    this.add(blueBkgWhiteCharLabel3, null);
    this.add(txtExamDate, null);
    this.add(blueBkgWhiteCharLabel4, null);
    this.add(txtMaker, null);
    dbcbx=new exgui.DataBindJCombobox(cbxBuyerName,
                                Constants.vctBuyer,"BUYER_NAME",
                                "seq",null,"ALL",null
                                );
   Object dateVfy=exgui.verification.CellFormat.getDateStringFormaterAllowNull();
    dbExamDateB4=new exgui.DataBindTextWithChecker(txtExamDate,
                                  "",
                                  null,
                                  10,
                                  (exgui.Object2String)dateVfy,
                                  (exgui.ultratable.CellTxtEditorFormat) dateVfy
                                  );

  }

  void btnExit_actionPerformed(ActionEvent e) {
    try{
      processhandler.template.Properties.getCenteralControler().goBack();
    }catch(Exception exp){
      exp.printStackTrace();
    }

  }

  void btnQry_actionPerformed(ActionEvent e) {
    TgrListQryExam.CURRENT_PAGE_INDEX=0;
    TgrListQryExam.QRY_FIELD_B4EXAMDATE=(java.util.Date)dbExamDateB4.getSelectedValue();
    TgrListQryExam.QRY_FIELD_BUYERSEQ=(String)dbcbx.getSelectedValue();
    TgrListQryExam.QRY_FIELD_MAKER_NAME=(txtMaker.getText().trim().length()==0)?null:txtMaker.getText().trim();
    try{
      processhandler.template.Properties.getCenteralControler().doCommandExecute(new TgrListQryExam());
    }catch(Exception exp){
      exp.printStackTrace();
    }

  }

  void btnAdd_actionPerformed(ActionEvent e) {
   DlgSelectBuyerMaker dlg=new DlgSelectBuyerMaker(util.PublicVariable.APP_FRAME,
                                                   "Select Buyer & Maker",true);
   dlg.setSize(335,220);
   exgui.UIHelper.setToScreenCenter(dlg);
   dlg.show();
  }
}
