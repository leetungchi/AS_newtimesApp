package newtimes.production.gui.prodmaintain;

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

public class DlgMovStylesToOtherProd extends JDialog {
  JPanel panel1 = new JPanel();
  BorderLayout borderLayout1 = new BorderLayout();
  JPanel jPanel1 = new JPanel();
  JPanel jPanel2 = new JPanel();
  JButton btnOK = new JButton();
  JButton btnCancel = new JButton();
  JPanel jPanel3 = new JPanel();
  BorderLayout borderLayout2 = new BorderLayout();
  JScrollPane jScrollPane1 = new JScrollPane();
  String center_code,dep_code;
  int buyerSeq=-1;
  exgui.ultratable.PagedTablePanel  dbTbl;
  protected int myOperationStatus=0;
  final public static int STATUS_OPERATING=0;
  final public static int STATUS_CLOSE_NORMALLY=1;
  final public static int STATUS_CLOSE_CANCEL=2;
  String prodHeadPk=null;
  int orgPordHadPk=0;
  public DlgMovStylesToOtherProd(Frame frame, String title, boolean modal,
                                 String cenCode,String depCode,int byrSeq,int orgProdpk) {
    super(frame, title, modal);
    try {
      orgPordHadPk=orgProdpk;
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

  public DlgMovStylesToOtherProd() {
    this(null, "", false,"001","TPH01",78,-1);
  }
  void tableClicked(){
    if(dbTbl.getJtable().getSelectedColumn()!=-1 && dbTbl.getJtable().getSelectedRow() !=-1){
      prodHeadPk=dbTbl.getJtable().getValueAt(dbTbl.getJtable().getSelectedRow(),0).toString();
    }else{
      prodHeadPk=null;
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
   iso.put("PO.\nRef Code","prod_head_pk");
   iso.put(" S/C# ","prod_sc_no");
   iso.put("MAKER  \nCODE","maker_code");
   iso.put("CREATE \nUSER","record_create_user");
   iso.put("CREATE \nDATE","record_create_date");
   java.util.Hashtable ht=new java.util.Hashtable();
   Object objDateCnv=exgui.verification.CellFormat.getDateStringFormaterAllowNull();
   ht.put("CREATE \nDATE",objDateCnv);
   dbTbl=new exgui.ultratable.PagedTablePanel(new tmpDataEnging(),100,iso,ht);
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
       util.MiscFunc.showProcessingMessage();
       StringBuffer sb=new StringBuffer();
       sb.append("select a.prod_head_pk, ");
       sb.append("a.prod_sc_no, ");
       sb.append("(select nvl(c.BYMKR_HK_CODE,c.BYMKR_BRIEF) from buyer_maker c where b.prod_maker=c.BYMKR_SEQ ) as maker_code ");
       sb.append(",b.record_create_user,b.record_create_date,");
       sb.append("d.prod_ct_seq ");
       sb.append("from production a,prod_head b ,prod_ct_infor d where ");
       sb.append("a.prod_head_pk=b.prod_head_pk ");
       sb.append("and b.prod_head_pk=d.prod_head_pk(+) ");
       sb.append("and b.PROD_CEN_CODE='");sb.append(center_code);sb.append("' ");

       sb.append(" and b.PROD_DEPTMENT='");sb.append(dep_code);sb.append("'");
       sb.append(" and b.PROD_BUYER=");sb.append(String.valueOf(buyerSeq));
       sb.append(" and b.record_delete_flag='1' ");
       //for TPE center,allo to copy to it's self.as append mode.
       if(util.PublicVariable.OPERATTING_CENTER.equals("001")
          && util.PublicVariable.USER_RECORD.getInt(2)==newtimesejb.preproduction.PreProductionHead.USER_TYPE_SUPERVIOSER_MIS){
       }else{
         sb.append("  and a.prod_head_pk <>");
         sb.append(String.valueOf(orgPordHadPk));
       }
       sb.append(" and ((d.prod_ct_seq is null) or (d.prod_ct_seq=1))");

       //sb.append(" and a.prod_sc_no in('VM-644936') ");
       sb.append(" order by prod_head_pk desc ");

       java.util.Vector vct=exgui2.CONST.BASIC_MAIN_EJB.getDatas(util.PublicVariable.USER_RECORD,
                                                       sb.toString(),bgn,rowcount);

       util.MiscFunc.hideProcessingMessage();
       return vct;

     }
  }
  public String getSelectedProdHeadPK(){return prodHeadPk;}
  void btnOK_actionPerformed(ActionEvent e) {
    if(prodHeadPk==null){
       exgui.verification.VerifyLib.showAlert("Please Select PO To Move To",
                                              "Please Select PO To Move To");
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
