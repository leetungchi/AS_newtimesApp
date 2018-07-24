package newtimes.production.gui.prodmaintain;

import java.awt.*;
import javax.swing.*;
import newtimes.preproduction.buyermakerselect.*;
import exgui.*;
import java.util.*;
import database.datatype.*;
import java.awt.event.*;
/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class DlgSlkVenderInfor extends JDialog {
  JPanel panel1 = new JPanel();
  JButton btnOk = new JButton();
  JButton btnEXIT = new JButton();
  SelectBuyerMaker slkVender = new SelectBuyerMaker();
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel1 = new BlueBkgWhiteCharLabel();
  //JPanel jPanel1 = new JPanel();
  Panel2List pnl2list=null;
  PnlNthkCtList _pnlCtList;
  Record rec2turn;
  public DlgSlkVenderInfor(Frame frame, String title, boolean modal,int venderseq,PnlNthkCtList pnlCtList) {
    super(frame, title, modal);
    _pnlCtList=pnlCtList;
    try {
       util.InsertionOrderedHashMap iso=new util.InsertionOrderedHashMap();
       iso.put("      NAME      ","COLLECT_BANK");
       iso.put("      ADDR-LINE1     ","BANK_ADD1");
       iso.put("      ADDR-LINE2     ","BANK_ADD2");
       iso.put("    SWIFT    ","SWIFT");
       iso.put("    RECIPIENT   ","COLLECT_BY");
       iso.put("    ACCOUNT#   ","ACC_NO");
       slkVender.init("",(venderseq==-1)?null:String.valueOf(venderseq),slkVender.TYPE_VENDOR,true);
       rec2turn=slkVender.currentRecord();
       pnl2list=new Panel2List(new tempdb(),9999,iso,new java.util.Hashtable());
       slkVender.setModifyNotifyTo(new VenderChanged());
       jbInit();
       pnl2list.firstPage();
      pack();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }

  class Panel2List extends exgui.ultratable.FuncAbstractUltraTablePanel {
    public Panel2List(exgui.ultratable.PagedDataFactory pagedDataFxy,
                      int rowCounts,util.InsertionOrderedHashMap columnMapping,
                     java.util.Hashtable object2StringConvertor){
        super(pagedDataFxy, rowCounts, columnMapping, object2StringConvertor);
    }
    public void doPrint(){}
    public int getEachPageRowCount(){return _rowCounts;}
    public Hashtable getObject2StringConvertor() {return klmObjKvtHt;}
    public util.InsertionOrderedHashMap getHeadColumnMap(){return tblHeadColumn;}
    public exgui.ultratable.PagedDataFactory getPagedDataFactory(){return dbHandler;}
    public Record setObject2Record(Record rec,int col,Object obj){
       try{
         rec.set(storedRecordColumn[col],obj);
         return rec;
       }catch(Exception exp){
         exp.printStackTrace();
         return null;
       }
    }
    public void refineEditors(exgui.ultratable.MultiEditorJTable me ){
    }
    public void doUpdate()throws Exception{
        super.updateModifiedRecord();
    }
  }

  class tempdb extends exgui.ultratable.PagedDataFactoryAdapter{
    public java.util.Vector getRecords(int bgn,int rowcount)throws Exception{
      if(slkVender.getSelectedValue()==null)return new Vector();
      Vector vct= exgui2.CONST.BASIC_MAIN_EJB.getDatas(
        util.PublicVariable.USER_RECORD,
        "select * from vender_infor where record_delete_flag='1' and vender_seq="+slkVender.getSelectedValue().toString(),
        1,9999
      );
      return vct;
    }
  }
  public DlgSlkVenderInfor() {
    this(null, "", false,-1,null);
  }
  class VenderChanged implements newtimes.preproduction.buyermakerselect.BuyerMakerChanged{
    public void changeBuyerMaker(Record rec) {
      try {
        rec2turn=rec;
        pnl2list.reload();
      } catch (Exception exp) {
        exp.printStackTrace();
        util.ExceptionLog.exp2File(exp, "");
      }
    }
  }


  private void jbInit() throws Exception {
    panel1.setLayout(null);
    btnOk.setBounds(new Rectangle(134, 269, 98, 37));
    btnOk.setFont(new java.awt.Font("Dialog", 1, 11));
    btnOk.setText("OK");
    btnOk.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnOk_actionPerformed(e);
      }
    });
    btnEXIT.setText("EXIT");
    btnEXIT.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnEXIT_actionPerformed(e);
      }
    });
    btnEXIT.setBounds(new Rectangle(357, 269, 98, 37));
    btnEXIT.setFont(new java.awt.Font("Dialog", 1, 11));
    slkVender.setBounds(new Rectangle(229, 31, 264, 31));
    blueBkgWhiteCharLabel1.setText("Vendor");
    blueBkgWhiteCharLabel1.setBounds(new Rectangle(61, 31, 168, 31));
    pnl2list.setBounds(new Rectangle(18, 63, 554, 202));
    getContentPane().add(panel1);
    panel1.add(btnOk, null);
    panel1.add(btnEXIT, null);
    panel1.add(pnl2list, null);
    panel1.add(blueBkgWhiteCharLabel1, null);
    panel1.add(slkVender, null);

  }
  void btnEXIT_actionPerformed(ActionEvent e) {
      this.dispose();
  }
  public Record getVenderRec(){
    return rec2turn;
  }
  public Record getVenderInforRec(){
    if(pnl2list.getDisplayingRecords().size()==0)return null;
    int rowselected=pnl2list.getJtable().getSelectedRow();
    return (Record)pnl2list.getDisplayingRecords().get(rowselected==-1?0:rowselected);
  }
  void btnOk_actionPerformed(ActionEvent e) {
     _pnlCtList.venderChanged(getVenderRec());
     try{
       _pnlCtList.venderInforChanged(getVenderInforRec());
     }catch(Exception exp){
       exp.printStackTrace();
     }
     this.dispose();
  }
}
