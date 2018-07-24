package newtimes.bank;

import java.awt.*;
import exgui.*;
import javax.swing.*;
import java.awt.event.*;
import database.datatype.Record;
import java.util.*;
import javax.swing.table.*;
//import com.borland.jbcl.layout.*;
import java.text.SimpleDateFormat;
import java.text.DateFormat;
import com.inet.viewer.ReportViewerBean;


/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class PnlBankDeposit extends JPanel {
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel1 = new BlueBkgWhiteCharLabel();
  JButton btnUpdate = new JButton();
  JButton btnExit = new JButton();

  newtimesejb.bank.BankDepositFacade bankejb;
  DefaultTableModel model = new DefaultTableModel();  ;

  JTable jTable1 ;
  JButton btnAdd = new JButton();
  JButton btnDel = new JButton();
  String[] column_head = {"公司別","定存帳號","計息起","迄","期數(月)","利率(%)","TWD","CNY","USD","REMARK"};
  String[] field_ = {"COMPANY","ACC_NO","BE_DATE","EN_DATE","MONTHS","RATE","TWD","CNY","USD","REMARK_"};
  JButton btnPrt = new JButton();
  JDialog dialog;
  JScrollPane jScrollPane1 = new JScrollPane();

  JPanel rptPnl = new JPanel();
  ReportViewerBean rptview = new ReportViewerBean();

  JPanel formPnl = new JPanel();
  JLabel jLabel1 = new JLabel();
  JComboBox compCbx = new JComboBox();
  JLabel jLabel2 = new JLabel();
  JTextField accnoTxf = new JTextField();
  JLabel jLabel3 = new JLabel();
  Object vftxtChkDD=RocDateFormator.getRocDateFormat();

  JTextField beTxf = new JTextField();
  JLabel jLabel4 = new JLabel();
  JTextField enTxf = new JTextField();
  JLabel jLabel5 = new JLabel();
  JTextField monthTxf = new JTextField();
  JLabel jLabel6 = new JLabel();
  JTextField rateTxf = new JTextField();
  JLabel jLabel7 = new JLabel();
  JTextField twdTxf = new JTextField();
  JLabel jLabel8 = new JLabel();
  JTextField cntTxf = new JTextField();
  JLabel jLabel9 = new JLabel();
  JTextField usdTxf = new JTextField();
  JLabel jLabel10 = new JLabel();
  JTextArea rmkTxf = new JTextArea();
  JButton saveBtn = new JButton();
  Vector vct;
  String status = "";
  Vector table_row;
  Vector table_head;
  public PnlBankDeposit() {
    try {

      newtimesejb.bank.BankDepositFacadeHome  bankHome=
          (newtimesejb.bank.BankDepositFacadeHome)
          info_ejb.WeblogicServiceLocator.locateServiceHome(util.PublicVariable.SERVER_URL,
          "newtimesejb.bank.BankDepositFacade");
     bankejb=bankHome.create();
     table_head = new Vector();
     for (int i=0;i<column_head.length;i++) {
           table_head.addElement(column_head[i]);
     }
    model.setColumnIdentifiers(table_head);
    loaddata();

    jTable1= new JTable(model);
    DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
    centerRenderer.setHorizontalAlignment( JLabel.CENTER );
    jTable1.getColumnModel().getColumn(0).setCellRenderer( centerRenderer );
    jTable1.getColumnModel().getColumn(1).setCellRenderer( centerRenderer );
    jTable1.getColumnModel().getColumn(2).setCellRenderer( centerRenderer );
    jTable1.getColumnModel().getColumn(3).setCellRenderer( centerRenderer );
    jTable1.getColumnModel().getColumn(4).setCellRenderer( centerRenderer );
    jTable1.getColumnModel().getColumn(5).setCellRenderer( centerRenderer );
    DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
    rightRenderer.setHorizontalAlignment( JLabel.RIGHT );
    jTable1.getColumnModel().getColumn(6).setCellRenderer( rightRenderer );
    jTable1.getColumnModel().getColumn(7).setCellRenderer( rightRenderer );
    jTable1.getColumnModel().getColumn(8).setCellRenderer( rightRenderer );

    dialog = new JDialog(processhandler.template.Properties.getMainFrame(), true);
    dialog.setModal(false);
    dialog.setBounds(200,200,700,550);
    dialog.setLocationRelativeTo(processhandler.template.Properties.getMainFrame());
    dialog.setVisible(false);
    dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
 //   dialog.setContentPane(formPnl);
    new exgui.DataBindTextWithChecker(beTxf,
                           "BE_DATE", null, 9,
                            (exgui.Object2String)vftxtChkDD,
                            (exgui.ultratable.CellTxtEditorFormat)vftxtChkDD);
     new exgui.DataBindTextWithChecker(enTxf,
                            "EN_DATE", null, 9,
                             (exgui.Object2String)vftxtChkDD,
                             (exgui.ultratable.CellTxtEditorFormat)vftxtChkDD);
      rptPnl.setLayout(new BorderLayout());
      rptPnl.add(rptview);
      rptview.setReportName("http://rpt.nttpe.com.tw:9000/?file:////d://rpt//BANKDEPOSIT.RPT");
   //   rptview.setAutoscrolls(true);

      rptview.setHasGroupTree(false);
      jbInit();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }

  void jbInit() throws Exception {


    blueBkgWhiteCharLabel1.setFont(new java.awt.Font("Dialog", 0, 16));
    blueBkgWhiteCharLabel1.setText("銀行定存資料維護");
    blueBkgWhiteCharLabel1.setBounds(new Rectangle(0, 13, 801, 30));
    this.setBackground(new Color(202, 202, 224));
    this.setLayout(null);
    btnUpdate.setBounds(new Rectangle(165, 527, 115, 28));
    btnUpdate.setFont(new java.awt.Font("Dialog", 1, 11));
    btnUpdate.setText("Modify");
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
    btnExit.setFont(new java.awt.Font("Dialog", 1, 11));
    btnExit.setBounds(new Rectangle(659, 529, 115, 28));

    btnAdd.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnAdd_actionPerformed(e);
      }
    });
    btnAdd.setText("New");
    btnAdd.setFont(new java.awt.Font("Dialog", 1, 11));
    btnAdd.setBounds(new Rectangle(29, 527, 115, 28));
    btnDel.setBounds(new Rectangle(300, 527, 115, 28));
    btnDel.setFont(new java.awt.Font("Dialog", 1, 11));
    btnDel.setToolTipText("");
    btnDel.setText("Delate");
    btnDel.setVerticalAlignment(javax.swing.SwingConstants.CENTER);
    btnDel.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnDel_actionPerformed(e);
      }
    });
    btnPrt.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnPrt_actionPerformed(e);
      }
    });
    btnPrt.setVerticalAlignment(javax.swing.SwingConstants.CENTER);
    btnPrt.setText("Print");
    btnPrt.setToolTipText("");
    btnPrt.setFont(new java.awt.Font("Dialog", 1, 11));
    btnPrt.setBounds(new Rectangle(438, 527, 115, 28));
    jScrollPane1.setBounds(new Rectangle(4, 45, 798, 472));
 //   formPnl.setMaximumSize(new Dimension(32767, 32767));
 //   formPnl.setBounds(new Rectangle(123, 179, 582, 379));
    formPnl.setLayout(null);
    jLabel1.setText("公司別 :");
    jLabel1.setBounds(new Rectangle(86, 16, 50, 27));
    compCbx.setBounds(new Rectangle(149, 19, 96, 22));
    compCbx.addItem("");
    compCbx.addItem("吉吉聯");
    compCbx.addItem("新麟");
    compCbx.addItem("建聯");
    compCbx.addItem("福聯");
    compCbx.addItem("新紀元");
    jLabel2.setToolTipText("");
    jLabel2.setText("定存帳號 :");
    jLabel2.setBounds(new Rectangle(303, 19, 61, 25));
    accnoTxf.setText("");
    accnoTxf.setBounds(new Rectangle(364, 22, 144, 24));
    jLabel3.setText("計息期間 :");
    jLabel3.setBounds(new Rectangle(75, 51, 60, 28));
    beTxf.setText("");
    beTxf.setBounds(new Rectangle(149, 55, 97, 24));
    jLabel4.setText("至");
    jLabel4.setBounds(new Rectangle(327, 58, 21, 25));
    enTxf.setText("");
    enTxf.setBounds(new Rectangle(364, 57, 97, 24));
    jLabel5.setToolTipText("");
    jLabel5.setText("期數 :");
    jLabel5.setBounds(new Rectangle(94, 90, 38, 27));
    monthTxf.setText("");
    monthTxf.setBounds(new Rectangle(148, 93, 98, 27));
    jLabel6.setText("利率(%) :");
    jLabel6.setBounds(new Rectangle(302, 93, 58, 28));
    rateTxf.setText("");
    rateTxf.setBounds(new Rectangle(364, 96, 94, 26));
    jLabel7.setFont(new java.awt.Font("Dialog", 1, 11));
    jLabel7.setForeground(Color.black);
    jLabel7.setText("TWD :");
    jLabel7.setBounds(new Rectangle(88, 149, 40, 24));
    twdTxf.setText("");
    twdTxf.setBounds(new Rectangle(148, 148, 99, 25));
    jLabel8.setFont(new java.awt.Font("Dialog", 1, 11));
    jLabel8.setText("CNY :");
    jLabel8.setBounds(new Rectangle(309, 145, 45, 26));
    cntTxf.setText("");
    cntTxf.setBounds(new Rectangle(364, 144, 96, 24));
    jLabel9.setFont(new java.awt.Font("Dialog", 1, 11));
    jLabel9.setText("USD :");
    jLabel9.setBounds(new Rectangle(89, 196, 40, 25));
    usdTxf.setText("");
    usdTxf.setBounds(new Rectangle(147, 197, 100, 25));
    jLabel10.setText("Remark :");
    jLabel10.setBounds(new Rectangle(299, 195, 52, 21));
    rmkTxf.setToolTipText("");
    rmkTxf.setText("");
    rmkTxf.setBounds(new Rectangle(361, 195, 203, 134));
    saveBtn.setBounds(new Rectangle(88, 296, 113, 33));
    saveBtn.setFont(new java.awt.Font("Dialog", 1, 12));
    saveBtn.setFocusPainted(true);
    saveBtn.setText("OK");
    saveBtn.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        saveBtn_actionPerformed(e);
      }
    });
  //   exgui.verification.VerifyLib.showAlert("Please Assigne PAY Date","Please Assigne Pay Date");

    formPnl.add(jLabel10, null);
    formPnl.add(cntTxf, null);
    formPnl.add(jLabel8, null);
    formPnl.add(rateTxf, null);
    formPnl.add(jLabel6, null);
    formPnl.add(enTxf, null);
    formPnl.add(jLabel4, null);
    formPnl.add(accnoTxf, null);
    formPnl.add(jLabel2, null);
    formPnl.add(compCbx, null);
    formPnl.add(jLabel1, null);
    formPnl.add(beTxf, null);
    formPnl.add(jLabel3, null);
    formPnl.add(monthTxf, null);
    formPnl.add(jLabel5, null);
    formPnl.add(twdTxf, null);
    formPnl.add(jLabel7, null);
    formPnl.add(usdTxf, null);
    formPnl.add(jLabel9, null);
    formPnl.add(rmkTxf, null);
    formPnl.add(saveBtn, null);
    this.add(blueBkgWhiteCharLabel1, null);
    this.add(btnAdd, null);

    this.add(btnUpdate, null);
    this.add(btnDel, null);
    this.add(btnPrt, null);
    this.add(btnExit, null);
    this.add(jScrollPane1, null);
//    this.add(formPnl, null);
    jScrollPane1.getViewport().add(jTable1, null);

  }

  void btnExit_actionPerformed(ActionEvent e) {
    try{

      processhandler.template.Properties.getCenteralControler().goBack();
    }catch(Exception exp){
      exp.printStackTrace();
    }

  }

  void btnUpdate_actionPerformed(ActionEvent e) {
    dialog.setContentPane(formPnl);
      status="MOD";
    try{
         if (jTable1.getSelectedRowCount()==0) {
             return;
         }
         data2form((Record)vct.get(jTable1.getSelectedRow()));

         dialog.show();
    }catch(Exception exp){
      exp.printStackTrace();
      util.ExceptionLog.exp2File(exp,"");
      exgui.verification.VerifyLib.showAlert("Update Failed\nPlease Contact System Manager",
                                             "Update Failed");
    }
  }


  void btnAdd_actionPerformed(ActionEvent e) {
    dialog.setContentPane(formPnl);
    status="ADD";
      data2form(null);
      dialog.show();
  }

  void btnDel_actionPerformed(ActionEvent e) {
    int dialogButton = JOptionPane.YES_NO_OPTION;
    int dialogResult = JOptionPane.showConfirmDialog(this, "確定刪除 ?", "刪除",dialogButton);
    try {
      if (dialogResult == 0) {
        bankejb.delRecord((Record)vct.get(jTable1.getSelectedRow()));
        model = new DefaultTableModel();
        model.setColumnIdentifiers(table_head);
        jTable1.setModel(model);
        loaddata();
      }
    }catch (Exception ee) {

    }

  }
  void btnPrt_actionPerformed(ActionEvent e) {
        dialog.setContentPane(rptPnl);
        dialog.show();
        rptview.start();
        rptview.refreshReport();

  }
  String tw_date (Object obj) {
        int yy = Integer.parseInt(obj.toString().split("-")[0]);
        yy = yy - 1911;
        return Integer.toString(yy)+"/"+obj.toString().split("-")[1]+"/"+(obj.toString().split("-")[2]).replaceAll(" 00:00:00.0","");
  }
  String twdate2date (String yymmdd) {
          int yy = Integer.parseInt(yymmdd.split("/")[0]);
          yy = yy + 1911;

          return Integer.toString(yy)+"-"+yymmdd.substring(4,6)+"-"+yymmdd.substring(7,9);
  }

  void loaddata() {

    try {
    vct = bankejb.getRecords();
    for ( int i=0;i< vct.size();i++) {
      Record rec = (Record)vct.get(i);
      table_row = new Vector();
      data2table(rec, table_row);
      model.addRow(table_row);
    }

    } catch (Exception ee) {

    }
}


  void data2table (Record rec,Vector table_row) {
    try {
      for (int j = 0; j < field_.length; j++) {
        if (j >= 2 && j <= 3) {
          table_row.add(tw_date(rec.get(field_[j])));
        } else {
          table_row.add(rec.get(field_[j]));
        }
      }
    } catch (Exception ee) {
      ee.printStackTrace();
    }
  }
  void saveBtn_actionPerformed(ActionEvent e) {
    if ( compCbx.getSelectedItem().toString().length() < 1 ||
         accnoTxf.getText().toString().length() < 1  ||
         beTxf.getText().toString().length() < 1 ||
         enTxf.getText().toString().length() < 1 ||
         monthTxf.getText().toString().length() < 1 ||
         rateTxf.getText().toString().length() < 1 ) {
       exgui.verification.VerifyLib.showAllert("Please Assigne COMPANY ,ACC NO, BEGIN DATE , END DATE, MONTHS , RATE");
       return;
    }
    try {

      if (status.endsWith("MOD")) {
        int selectid= jTable1.getSelectedRow();
        Record rec = (Record)vct.get(selectid);
        form2rec(rec);
        bankejb.updRecord(rec);
        model.setValueAt(compCbx.getSelectedItem().toString(),selectid,0);
        model.setValueAt(accnoTxf.getText(),selectid,1);
        model.setValueAt(beTxf.getText(),selectid,2);
        model.setValueAt(enTxf.getText(),selectid,3);
        model.setValueAt(monthTxf.getText(),selectid,4);
        model.setValueAt(rateTxf.getText(),selectid,5);
        model.setValueAt(twdTxf.getText(),selectid,6);
        model.setValueAt(cntTxf.getText(),selectid,7);
        model.setValueAt(usdTxf.getText(),selectid,8);
        model.setValueAt(rmkTxf.getText(),selectid,9);
      } else {
    //    Record blankrec = (Record)util.MiscFunc.deepCopy((Record)vct.get(0));
        Record blankrec = bankejb.get_Blank_Rec();
        form2rec(blankrec);
        bankejb.addRecord(blankrec);
        model = new DefaultTableModel();
        model.setColumnIdentifiers(table_head);
        jTable1.setModel(model);
        loaddata();
      }
      dialog.dispose();
    } catch (Exception ee) {
      ee.printStackTrace();
    }
  }
  void form2rec(Record rec) {
    try {
      rec.set("COMPANY", compCbx.getSelectedItem().toString());
      rec.set("ACC_NO", accnoTxf.getText());
      rec.set("BE_DATE", new SimpleDateFormat("yyyy-MM-dd").parse(twdate2date(beTxf.getText())));
      rec.set("EN_DATE", new SimpleDateFormat("yyyy-MM-dd").parse(twdate2date(enTxf.getText())));
      rec.set("MONTHS", monthTxf.getText());
      rec.set("RATE", rateTxf.getText());
      rec.set("TWD", twdTxf.getText());
      rec.set("CNY", cntTxf.getText());
      rec.set("USD", usdTxf.getText());
      rec.set("REMARK_", rmkTxf.getText());
    //  System.out.println("====> "+ new SimpleDateFormat("yyyy-MM-dd").parse(twdate2date(beTxf.getText())));
    } catch (Exception ee) {

    }
  }
  void data2form(Record rec){
       try {
         if (rec == null) {
           compCbx.setSelectedItem("");
           accnoTxf.setText("");
           beTxf.setText("");
           enTxf.setText("");
           monthTxf.setText("");
           rateTxf.setText("");
           twdTxf.setText("");
           cntTxf.setText("");
           usdTxf.setText("");
           rmkTxf.setText("");
         } else {
           compCbx.setSelectedItem(rec.get("COMPANY"));
           accnoTxf.setText(rec.get("ACC_NO").toString());
           beTxf.setText(tw_date(rec.get("BE_DATE")));
           enTxf.setText(tw_date(rec.get("EN_DATE")));
           monthTxf.setText(rec.get("MONTHS").toString());
           rateTxf.setText(rec.get("RATE").toString());
           if (rec.get("TWD") == null) {
             twdTxf.setText("");
           }else {
             twdTxf.setText(rec.get("TWD").toString());
           }
            if (rec.get("CNY") == null) {
              cntTxf.setText("");
            } else {
              cntTxf.setText(rec.get("CNY").toString());
            }
             if (rec.get("USD") == null) {
                usdTxf.setText("");
              } else {
                usdTxf.setText(rec.get("USD").toString());
             }
             if (rec.get("REMARK_") == null) {
                rmkTxf.setText("");
              } else {
                rmkTxf.setText(rec.get("REMARK_").toString());
             }

         }
       } catch (Exception ee) {

     }
  }
}

