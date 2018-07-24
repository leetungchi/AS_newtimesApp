package newtimes.preproduction.guis;

import java.awt.*;
import javax.swing.*;
import java.util.*;
import java.awt.event.*;
/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class DlgListSC4Combine extends JDialog {
  JPanel panel1 = new JPanel();
  BorderLayout borderLayout1 = new BorderLayout();
  JPanel jPanel1 = new JPanel();
  JPanel jPanel2 = new JPanel();
  JButton btnOK = new JButton();
  JButton btnCancel = new JButton();
  JPanel jPanel3 = new JPanel();
  BorderLayout borderLayout2 = new BorderLayout();
  JScrollPane jScrollPane1 = new JScrollPane();
  String strSc=null;
  String center_code,dep_code;
  int buyerSeq=-1;
  exgui.ultratable.PagedTablePanel  dbTbl;
  protected int myOperationStatus=0;
  final public static int STATUS_OPERATING=0;
  final public static int STATUS_CLOSE_NORMALLY=1;
  final public static int STATUS_CLOSE_CANCEL=2;

  public DlgListSC4Combine(Frame frame, String title, boolean modal,String cenCode,String depCode,int byrSeq) {
    super(frame, title, modal);
    try {
      center_code=cenCode;
      dep_code=depCode;
      buyerSeq=byrSeq;
      jbInit();
      pack();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }
  public int getDialogStatus(){return myOperationStatus;}
  public void show(){
    this.myOperationStatus=STATUS_OPERATING;
    super.show();
  }

  public DlgListSC4Combine() {
    this(null, "", false,"001","TPH01",78);
  }
  void tableClicked(){
    if(dbTbl.getJtable().getSelectedColumn()!=-1 && dbTbl.getJtable().getSelectedRow() !=-1){
      strSc=(String)dbTbl.getJtable().getValueAt(dbTbl.getJtable().getSelectedRow(),dbTbl.getJtable().getSelectedColumn());
    }else{
      strSc=null;
    }
  }
  void jbInit() throws Exception {
    panel1.setLayout(borderLayout1);
    jPanel1.setDebugGraphicsOptions(0);
    jPanel1.setLayout(borderLayout2);
    btnOK.setFont(new java.awt.Font("Dialog", 1, 11));
    btnOK.setText("OK");
    btnOK.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnOK_actionPerformed(e);
      }
    });
    btnCancel.setFont(new java.awt.Font("Dialog", 1, 11));
    btnCancel.setText("CANCEL");
    btnCancel.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnCancel_actionPerformed(e);
      }
    });
    getContentPane().add(panel1);
    panel1.add(jPanel1,  BorderLayout.CENTER);
    panel1.add(jPanel2, BorderLayout.SOUTH);
    jPanel2.add(btnCancel, null);
    jPanel2.add(jPanel3, null);
    jPanel2.add(btnOK, null);
    //jPanel1.add(jScrollPane1, BorderLayout.CENTER);

    //jScrollPane1.getViewport().add(jtbl_SC_list, null);
   util.InsertionOrderedHashMap iso=new util.InsertionOrderedHashMap();
   iso.put("S/C NO.","prod_sc_no");
   dbTbl=new exgui.ultratable.PagedTablePanel(new tmpDataEnging(),100,iso,new Hashtable());
   dbTbl.getJtable().addMouseListener( new java.awt.event.MouseAdapter(){
       public void mouseClicked( java.awt.event.MouseEvent me){
         tableClicked();
       }
   }) ;
   dbTbl.firstPage();
   jPanel1.add(dbTbl, BorderLayout.CENTER);
   //jScrollPane1.getViewport().add(dbTbl, null);
  }

  class tmpDataEnging extends exgui.ultratable.PagedDataFactoryAdapter{
     public Vector getRecords(int bgn,int rowcount)throws Exception{
       StringBuffer sb=new StringBuffer();
       sb.append("select prod_head_pk, prod_sc_no from production where prod_head_pk in(");
       sb.append("select prod_head_pk from PROD_HEAD where ");
       sb.append("PROD_CEN_CODE='");sb.append(center_code);sb.append("'");
       sb.append(" and PROD_DEPTMENT='");sb.append(dep_code);sb.append("'");
       sb.append(" and PROD_BUYER=");sb.append(String.valueOf(buyerSeq));
       sb.append(" and record_delete_flag='1')  ");
       sb.append(" and PROD_COMBIN_PARENT_PK is null and prod_sc_no is not null  order by prod_head_pk desc");
       java.util.Vector vct=exgui2.CONST.BASIC_MAIN_EJB.getDatas(util.PublicVariable.USER_RECORD,
                                                       sb.toString(),bgn,rowcount);

       return vct;
     }
  }
  public String getSelectedSC(){return strSc;}
  void btnOK_actionPerformed(ActionEvent e) {
    if(strSc==null){
       exgui.verification.VerifyLib.showAlert("Please Select S/C to Combine",
                                              "Please Select S/C to Combine");
       return;
    }
     myOperationStatus=STATUS_CLOSE_NORMALLY;
     this.dispose();
  }

  void btnCancel_actionPerformed(ActionEvent e) {
    myOperationStatus=STATUS_CLOSE_CANCEL;
    this.dispose();
  }
}
