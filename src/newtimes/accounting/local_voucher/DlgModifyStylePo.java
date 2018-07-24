package newtimes.accounting.local_voucher;

import java.awt.*;
import javax.swing.*;
import database.datatype.Record;
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

public class DlgModifyStylePo extends JDialog {
  JPanel panel1 = new JPanel();
  JButton btnExit = new JButton();
  JButton btnUpdate = new JButton();
  PnlListStyle pnlListStyle = null;
  String srn;
  String sql;
  public DlgModifyStylePo(Frame frame, String title, boolean modal,String _srn) {
    super(frame, title, modal);
    try {
      srn=_srn;
      jbInit();
      pack();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }

  public DlgModifyStylePo() {
    this(null, "", false,null);
  }

  private void jbInit() throws Exception {
    util.InsertionOrderedHashMap iso=new util.InsertionOrderedHashMap();
    iso.put("STYLE","sty_style");
    iso.put("   PO   ","sty_po");
    iso.put("SC NO","sty_sc_no");
    iso.put("COMM","Comm");
    Hashtable ht=new Hashtable();
    Object char30=exgui.verification.CellFormat.getOrdinaryField(30);

    ht.put("STYLE",char30);
    ht.put("   PO   ",char30);

    pnlListStyle= new PnlListStyle(new TempDb(),13,iso,ht);


    panel1.setLayout(null);
    btnExit.setBounds(new Rectangle(100, 307, 114, 33));
    btnExit.setFont(new java.awt.Font("Dialog", 1, 11));
    btnExit.setForeground(Color.red);
    btnExit.setText("EXIT");
    btnExit.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnExit_actionPerformed(e);
      }
    });
    btnUpdate.setText("UPDATE");
    btnUpdate.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnUpdate_actionPerformed(e);
      }
    });
    btnUpdate.setFont(new java.awt.Font("Dialog", 1, 11));
    btnUpdate.setForeground(Color.black);
    btnUpdate.setBounds(new Rectangle(306, 307, 114, 33));
    pnlListStyle.setBounds(new Rectangle(2, 6, 516, 294));
    this.setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
    getContentPane().add(panel1);
    panel1.add(btnExit, null);
    panel1.add(btnUpdate, null);
    panel1.add(pnlListStyle, null);
    pnlListStyle.firstPage();
  }
  class PnlListStyle extends processhandler.template.PnlTableEditor{
    public PnlListStyle(exgui.ultratable.PagedDataFactory pagedDataFxy,
                      int rowCounts,util.InsertionOrderedHashMap columnMapping,
                     java.util.Hashtable object2StringConvertor){
        super(pagedDataFxy, rowCounts, columnMapping, object2StringConvertor);
    }
    public void doPrint(){}
    public int getEachPageRowCount(){return _rowCounts;}
    public void refineEditors(exgui.ultratable.MultiEditorJTable mt){
      mt.setTextEditorVerifiers(klmObjKvtHt);
    }
    public Hashtable getObject2StringConvertor() {return klmObjKvtHt;}
    public util.InsertionOrderedHashMap getHeadColumnMap(){return tblHeadColumn;}
    public exgui.ultratable.PagedDataFactory getPagedDataFactory(){return dbHandler;}
    public void makeTable(Vector vct){
      super.makeTable(vct);
      getJtable().getColumnModel().getColumn(0).setPreferredWidth(153);
      getJtable().getColumnModel().getColumn(1).setPreferredWidth(160);
      getJtable().getColumnModel().getColumn(2).setPreferredWidth(107);
      getJtable().getColumnModel().getColumn(3).setPreferredWidth(75);
    }
    public void doUpdate(){
      try{
       super.doUpdate();
      }catch(Exception exp){
        exp.printStackTrace();
        util.ExceptionLog.exp2File(exp,"");
        exgui.verification.VerifyLib.showAlert("Error While Updatting Style Data\nPlease Contatct System Manager",
                                               "Update Fail!!!");
      }

    }
    public Record setObject2Record(Record rec,int col,Object obj){
      try{
        rec.set(storedRecordColumn[col], obj);
        return rec;
      }catch(Exception exp){
        exp.printStackTrace();
        util.ExceptionLog.exp2File(exp,"");
        return null;
      }
    }
  }
  class TempDb extends exgui.ultratable.PagedDataFactoryAdapter{
    TempDb(){
      StringBuffer sb=new StringBuffer();
      sb.append("select a.sty_seq,a.sty_style,a.sty_po,");
      sb.append("(select prod_sc_no from production c where  ");
      sb.append("c.prod_head_pk=a.prod_head_pk) as sty_sc_no,");
      sb.append("GET_SRN_SHIP_STY_COMMISION(b.ship_style_pk) as comm, ");
      sb.append("'");
      sb.append((String)util.PublicVariable.USER_RECORD.get(0));
      sb.append("' as RECORD_MODIFY_USER, ");
      sb.append(" sysdate as record_modify_date ");
      sb.append("from style a ,ship_style b,ship_sc d ");
      sb.append("where 1=1 ");
      sb.append("and a.sty_seq=b.STY_SEQ ");
      sb.append("and b.SHIP_SC_PK=d.SHIP_SC_PK ");
      sb.append("and d.ship_no='");
      sb.append(srn);sb.append("'");
      sql=sb.toString();
    }
    public void updateRecords(Vector vct2update)throws Exception{
      newtimesejb.production.StyleListFacadeHome ejbHome=
          (newtimesejb.production.StyleListFacadeHome)
          info_ejb.WeblogicServiceLocator.locateServiceHome(util.PublicVariable.SERVER_URL,
          "newtimesejb.production.StyleListFacade");
      newtimesejb.production.StyleListFacade ejb=ejbHome.create();
      ejb.updateRecords(vct2update);
    }

    public Vector getRecords(int bgn,int rowcount)throws Exception{
       Vector vct=exgui2.CONST.BASIC_MAIN_EJB.getDatas(
          util.PublicVariable.USER_RECORD,
          sql,bgn,rowcount
       );
        Vector vct2list=new Vector();
        java.sql.Date now=new java.sql.Date(System.currentTimeMillis());
        for(int i=0;i<vct.size();i++){
          Record rec=(Record)vct.get(i);
          rec.set("record_modify_user",util.PublicVariable.USER_RECORD.get(0));
          rec.set("record_modify_date",now);
          vct2list.add(rec);
        }
        return vct2list;
    }
  }

  void btnExit_actionPerformed(ActionEvent e) {
    if(pnlListStyle.isContextModified()){
      if(!exgui.verification.VerifyLib.showConfirm("Context Modified\nDo You Sure To Exit ?",
                                                   "Context Modified",false) ){
        return;
      }
    }
    this.hide();
  }

  void btnUpdate_actionPerformed(ActionEvent e) {
    if(!pnlListStyle.isContextModified()){

    }else{

      pnlListStyle.doUpdate();
      exgui.verification.VerifyLib.showPlanMsg("UPDATE OK","UPDATE OK");

    }
    this.hide();

  }
}
