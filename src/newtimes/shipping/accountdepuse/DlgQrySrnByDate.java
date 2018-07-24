package newtimes.shipping.accountdepuse;

import java.awt.*;
import javax.swing.*;
import exgui.*;
import java.awt.event.*;
import java.util.*;
import exgui.ultratable.*;
/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class DlgQrySrnByDate extends JDialog {
  JPanel panel1 = new JPanel();
  BlueBkgWhiteCharLabel lblTtile = new BlueBkgWhiteCharLabel();
  JLabel lblDate = new JLabel();
  JTextField txtDate = new JTextField();
  JButton btnExit = new JButton();
  JButton btnQry = new JButton();
  Pnl2List pnl2list;
  Hashtable htConv=new Hashtable();
  util.InsertionOrderedHashMap iso=new util.InsertionOrderedHashMap();
  String centerPrefixCode;
  JButton btnBringSrnBack = new JButton();
  String selectedSrn[]=new String[20];
  JLabel lblDateTo = new JLabel();
  JTextField txtDateTo = new JTextField();
  public DlgQrySrnByDate(Frame frame, String title, boolean modal,String cenPrefxCode) {
    super(frame, title, modal);
    try {
      centerPrefixCode=cenPrefxCode;
      jbInit();
      pack();
      iso.put("   SRN   ","SHIP_NO");
      iso.put("Created By","RECORD_CREATE_USER");

    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }

  public DlgQrySrnByDate() {
    this(null, "", false,null);
  }

  private void jbInit() throws Exception {
    panel1.setLayout(null);
    this.getContentPane().setLayout(null);
    panel1.setBounds(new Rectangle(-5, 0, 406, 405));
    lblTtile.setText("Query SRN By Detail Create Date");
    lblTtile.setBounds(new Rectangle(-1, 23, 406, 28));
    lblDate.setFont(new java.awt.Font("Dialog", 1, 11));
    lblDate.setText("Create Date:");
    lblDate.setBounds(new Rectangle(6, 66, 87, 20));
    txtDate.setText("");
    txtDate.setBounds(new Rectangle(88, 66, 82, 22));
    btnExit.setBounds(new Rectangle(36, 335, 110, 26));
    btnExit.setFont(new java.awt.Font("Dialog", 1, 11));
    btnExit.setActionCommand("jButton1");
    btnExit.setText("EXIT");
    btnExit.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnExit_actionPerformed(e);
      }
    });
    btnQry.setBounds(new Rectangle(319, 65, 74, 25));
    btnQry.setFont(new java.awt.Font("Dialog", 1, 11));
    btnQry.setText("QUERY");
    btnQry.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnQry_actionPerformed(e);
      }
    });
    btnBringSrnBack.setBounds(new Rectangle(213, 335, 148, 29));
    btnBringSrnBack.setFont(new java.awt.Font("Dialog", 1, 11));
    btnBringSrnBack.setText("Get Selected SRN#");
    btnBringSrnBack.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnBringSrnBack_actionPerformed(e);
      }
    });
    lblDateTo.setBounds(new Rectangle(171, 66, 36, 20));
    lblDateTo.setText("TO");
    lblDateTo.setFont(new java.awt.Font("Dialog", 1, 11));
    txtDateTo.setBounds(new Rectangle(208, 66, 82, 22));
    txtDateTo.setText("");
    getContentPane().add(panel1, null);
    panel1.add(lblTtile, null);
    panel1.add(btnExit, null);
    panel1.add(btnBringSrnBack, null);
    panel1.add(txtDate, null);
    panel1.add(lblDate, null);
    panel1.add(lblDateTo, null);
    panel1.add(btnQry, null);
    panel1.add(txtDateTo, null);
    Object dateVfy = exgui.verification.CellFormat.getDateStringFormaterAllowNull();

        new exgui.DataBindTextWithChecker(txtDateTo, "DEL_TO", new java.sql.Date(System.currentTimeMillis()),
                                          10, (exgui.Object2String)dateVfy,
                                          (exgui.ultratable.
                                           CellTxtEditorFormat)dateVfy);
    java.util.Calendar cld=java.util.Calendar.getInstance();
    cld.add(cld.DATE,-7);
            new exgui.DataBindTextWithChecker(txtDate, "DEL_BE", new java.sql.Date(cld.getTimeInMillis()),
                                              10, (exgui.Object2String)dateVfy,
                                              (exgui.ultratable.
                                               CellTxtEditorFormat)dateVfy);


  }

  void btnExit_actionPerformed(ActionEvent e) {
    this.dispose();
  }
  protected void getPanel2List(){
    if(pnl2list!=null)panel1.remove(pnl2list);
    TempDb tdb=new TempDb();
    pnl2list=new Pnl2List(tdb,999999,iso,htConv);
    pnl2list.setBounds(10,100,375,230);
    panel1.add(pnl2list);
    panel1.repaint();
    panel1.validate();
  }
  class Pnl2List extends exgui.ultratable.PagedTablePanel{
    Pnl2List(
        PagedDataFactory pagedDataFxy,
        int rowlength,util.InsertionOrderedHashMap columnMapping,
        java.util.Hashtable object2StringConvertor
    ){
      super(pagedDataFxy,rowlength,columnMapping,object2StringConvertor);
      //while contruction, Pnl2List already goto 1st page.
    }
  }
  class TempDb extends exgui.ultratable.PagedDataFactoryAdapter{
    public java.util.Vector getRecords(int bgn, int rowcount) throws Exception {
      util.MiscFunc.showProcessingMessage();
      try {
        StringBuffer sb = new StringBuffer();
        /*
             select distinct a.ship_no ,b.record_create_user
              from ship_sc a,ship_style b
              where b.ship_sc_pk=a.ship_sc_pk
              and to_char(b.record_create_date,'YYYY/MM/DD')>='2006/09/05'
              and to_char(b.record_create_date,'YYYY/MM/DD')<='2006/09/06'
              and a.SHIP_NO like 'ZATW%'
              order by ship_no

         */

        //sb.append("select ship_no,record_create_user from shipping where to_char(record_create_date,'YYYY/MM/DD')='");
        sb.append("select distinct a.ship_no ,b.record_create_user ");
        sb.append(
            "from ship_sc a,ship_style b where b.ship_sc_pk=a.ship_sc_pk ");
        sb.append("and b.record_delete_flag='1' ");
        sb.append("and to_char(b.record_create_date,'YYYY/MM/DD')>='");
        sb.append(txtDate.getText().trim());
        sb.append("' ");
        sb.append("and to_char(b.record_create_date,'YYYY/MM/DD')<='");
        sb.append(txtDateTo.getText().trim());
        sb.append("' ");
        boolean isXCenter;
        if (util.PublicVariable.OPERATTING_CENTER.equals("001") ||
            util.PublicVariable.OPERATTING_CENTER.equals("NTHK")) {
          isXCenter = false;
        } else {
          isXCenter = true;
        }
        String headingStr = "Z" + centerPrefixCode;
        //select * from shipping where (ship_no like 'ZNNT%' and ship_no like '%520254')
        if (!isXCenter) {
          sb.append(" and a.ship_no like '");
          sb.append(headingStr);
          sb.append("%'");
        } else {
          sb.append(" and a.ship_no like 'Z%'");
          sb.append(" and substr(a.ship_no,4,2)='");
          sb.append(centerPrefixCode.substring(1, 3));
          sb.append("'");
          sb.append(" and a.record_delete_flag='1' and length(a.ship_no)=13 ");
        }
        sb.append(" order by ship_no");
        Vector vct =
            exgui2.CONST.BASIC_MAIN_EJB.getDatas(
            util.PublicVariable.USER_RECORD,
            sb.toString(), bgn, rowcount);
        return vct;

      } catch (Exception exp) {
        throw exp;
      } finally {
        util.MiscFunc.hideProcessingMessage();
      }
    }
  }
  void btnQry_actionPerformed(ActionEvent e) {
     if(txtDate.getText().trim().length()<10){
       exgui.verification.VerifyLib.showAlert("Please Input Begin Date Of Detail Create Date To Query",
                                              "Please Input Begin Date Of Detail Create Date To Query");
       return;
     }
     if(txtDateTo.getText().trim().length()<10){
       exgui.verification.VerifyLib.showAlert("Please Input End Date Of Detail Create Date To Query",
                                              "Please Input End Date Of Detail Create Date To Query");
       return;
     }

     getPanel2List();
  }

  void btnBringSrnBack_actionPerformed(ActionEvent e) {
     if(pnl2list==null){
       exgui.verification.VerifyLib.showAlert("Please Query Shipping SRN By Detail Create Date",
                                              "Please Query Shipping SRN By Detail Create Date");
       return;
     }
     if(pnl2list.getJtable().getSelectedRowCount()==0){
       exgui.verification.VerifyLib.showAlert("Please Select Row(s)",
                                              "Please Select Row(s)");
       return;
     }
     if(pnl2list.getJtable().getSelectedRowCount()>20){
       exgui.verification.VerifyLib.showAlert("Can Not Over 20 Rows",
                                              "Can Not Over 20 Rows");
       return;
     }
     int rows[]=pnl2list.getJtable().getSelectedRows();
     for(int i=0;i<rows.length ;i++){
       selectedSrn[i]=
           (String)((database.datatype.Record)pnl2list.getDisplayingRecords().get(rows[i])).get(0);

     }
     dispose();
  }
}
