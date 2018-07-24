package newtimes.preproduction.guis;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.event.*;
import java.util.Vector;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class DlgShowByrMkrOfHkSc extends JDialog {
  JPanel panel1 = new JPanel();
  BorderLayout borderLayout1 = new BorderLayout();
  JPanel jPanel1 = new JPanel();
  JLabel jLabel1 = new JLabel();
  BorderLayout borderLayout2 = new BorderLayout();
  JTextField txtScNo = new JTextField();
  JButton btnQry = new JButton();
  Border border1;
  JPanel jPanel2 = new JPanel();
  JButton btnClose = new JButton();
  JPanel pnl2PutTbl = new JPanel();
  Border border2;
  JScrollPane jScrollPanetoSetTbl = new JScrollPane();
  BorderLayout borderLayout3 = new BorderLayout();

  public DlgShowByrMkrOfHkSc(Frame frame, String title, boolean modal) {
    super(frame, title, modal);
    try {
      jbInit();
      pack();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }

  public DlgShowByrMkrOfHkSc() {
    this(null, "", false);
  }

  protected void jbInit() throws Exception {
    border1 = new EtchedBorder(EtchedBorder.RAISED,Color.white,new Color(148, 145, 140));
    border2 = BorderFactory.createBevelBorder(BevelBorder.LOWERED,Color.white,Color.white,new Color(103, 101, 98),new Color(148, 145, 140));
    panel1.setLayout(borderLayout1);
    jLabel1.setFont(new java.awt.Font("Dialog", 1, 11));
    jLabel1.setText("Please Input  S/C#");
    jPanel1.setLayout(borderLayout2);
    txtScNo.setText("");
    btnQry.setFont(new java.awt.Font("Dialog", 1, 11));
    btnQry.setText("Query");
    btnQry.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnQry_actionPerformed(e);
      }
    });
    jPanel1.setBorder(border1);
    btnClose.setFont(new java.awt.Font("Dialog", 1, 11));
    btnClose.setActionCommand("CLOSE");
    btnClose.setText("CLOSE");
    btnClose.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnClose_actionPerformed(e);
      }
    });
    pnl2PutTbl.setBorder(border2);
    pnl2PutTbl.setLayout(borderLayout3);
    getContentPane().add(panel1);
    panel1.add(jPanel1, BorderLayout.NORTH);
    jPanel1.add(jLabel1,  BorderLayout.WEST);
    jPanel1.add(txtScNo, BorderLayout.CENTER);
    jPanel1.add(btnQry, BorderLayout.EAST);
    panel1.add(jPanel2, BorderLayout.SOUTH);
    jPanel2.add(btnClose, null);
    panel1.add(pnl2PutTbl, BorderLayout.CENTER);
    pnl2PutTbl.add(jScrollPanetoSetTbl,  BorderLayout.CENTER);
  }

  void btnClose_actionPerformed(ActionEvent e) {
    this.dispose();
  }
  class tempScTbl extends exgui.ultratable.AbstractUltraTablePanel {
    tempScTbl(exgui.ultratable.PagedDataFactory pagedDataFxy,
        int rowlength,util.InsertionOrderedHashMap columnMapping,
        java.util.Hashtable object2StringConvertor
        ){
       super(pagedDataFxy,rowlength,columnMapping,object2StringConvertor);
    }
   public int getEachPageRowCount() {return 100;}

   public void refineEditors(exgui.ultratable.MultiEditorJTable  xMctm){
     xMctm.setTableColumn2Grp("Buyer",1);
     xMctm.setTableColumn2Grp("Buyer",2);
     xMctm.setTableColumn2Grp("Maker",3);
     xMctm.setTableColumn2Grp("Maker",4);
   }
   public java.util.Hashtable getObject2StringConvertor(){return new java.util.Hashtable();}
   public util.InsertionOrderedHashMap getHeadColumnMap(){return tblHeadColumn;}
   public exgui.ultratable.PagedDataFactory getPagedDataFactory(){
      return dbHandler;
   }
   public database.datatype.Record  setObject2Record(database.datatype.Record rec,int _col,Object obj){
     return null;}
  }
  class tmpDataEnging extends exgui.ultratable.PagedDataFactoryAdapter{
     public Vector getRecords(int bgn,int rowcount)throws Exception{
       StringBuffer sb=new StringBuffer();
       sb.append("select b.prod_sc_no,");
       sb.append("c.bymkr_hk_code as buyer_hk_code, ");
       sb.append("c.BYMKR_NAME as buyer_name,");
       sb.append("d.bymkr_hk_code as maker_hk_code,");
       sb.append("d.BYMKR_NAME as maker_name ");
       sb.append("from  prod_head a,production b, ");
       sb.append("buyer_maker c,buyer_maker d ");
       sb.append("where   a.prod_head_pk=b.prod_head_pk ");
       sb.append("and a.PROD_BUYER=c.bymkr_seq(+) ");
       sb.append("and a.PROD_MAKER=d.bymkr_seq(+) ");
       sb.append("and a.PROD_CEN_CODE='");
       sb.append((String)util.PublicVariable.OPERATTING_CENTER);
       sb.append("' ");
       sb.append("and a.record_delete_flag='1'" );
       sb.append("and b.prod_sc_no like '");
       sb.append(util.MiscFunc.Replace(txtScNo.getText().trim().toUpperCase(),"'","''"));
       sb.append("%'");

       java.util.Vector vct=exgui2.CONST.BASIC_MAIN_EJB.getDatas(util.PublicVariable.USER_RECORD,
                                                       sb.toString(),bgn,rowcount);

       return vct;
     }
  }

  void btnQry_actionPerformed(ActionEvent e) {
    if(txtScNo.getText().trim().length()<2){
      exgui.verification.VerifyLib.showAlert("Please Input Initial S/C String To Search\n At least 2 charaters",
                                             "String too short");
      txtScNo.grabFocus();
      txtScNo.selectAll();
      return;
    }
    util.InsertionOrderedHashMap iso=new util.InsertionOrderedHashMap();
    iso.put("S/C","prod_sc_no");
    iso.put("CODE","buyer_hk_code");
    iso.put("  NAME                     ","buyer_name");
    iso.put("CODE ","maker_hk_code");
    iso.put("   NAME                          ","maker_name");
    tempScTbl tbl=new tempScTbl(new tmpDataEnging(),100,
                                iso,null);
    jScrollPanetoSetTbl.getViewport().removeAll();
    tbl.firstPage();
    tbl.setPreferredSize(new Dimension(700,280));
    jScrollPanetoSetTbl.getViewport().add(tbl);
  }

}
