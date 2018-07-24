package newtimes.general_voucher;

import java.awt.*;
import exgui.*;
import javax.swing.*;
import java.awt.event.*;
import database.datatype.Record;
import java.util.*;
/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class PnlAccDataMaintainList extends JPanel {
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel1 = new BlueBkgWhiteCharLabel();
  /*
  JButton btnDel = new JButton();
  JButton btnExit = new JButton();
  */
  //JPanel pnl2list = new JPanel();
  Panel2List pnl2list=null;
  java.text.NumberFormat nf=new java.text.DecimalFormat("###,###,###,##0.00");
  public PnlAccDataMaintainList() {
    try {
      jbInit();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }

  void jbInit() throws Exception {
    blueBkgWhiteCharLabel1.setText("VOUCHER ACCOUNT LIST");
    util.InsertionOrderedHashMap iso=new util.InsertionOrderedHashMap();
    iso.put("ACC CODE","ACC_CODE");
    iso.put("年月","YYYYMM");
    iso.put("D/C","D_C");
    iso.put("   DESCRIPTION   ","REC_DESC");
    iso.put(" 期初金額 ","INIT_AMT");
    iso.put("本期借方金額","D_AMT");
    iso.put("本期貸方金額","C_AMT");
    iso.put(" 期末餘額 ","BLNC_AMT");
    iso.put("CTL CODE","CNTL_CODE");

    pnl2list=new Panel2List(new TempDb(),25,iso,new Hashtable());
    pnl2list.firstPage();

    blueBkgWhiteCharLabel1.setBounds(new Rectangle(-3, 22, 802, 31));
    this.setLayout(null);
    /*
    btnDel.setBounds(new Rectangle(105, 559, 134, 28));
    btnDel.setFont(new java.awt.Font("Dialog", 1, 11));
    btnDel.setText("DELETE");
    btnExit.setText("EXIT");
    btnExit.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnExit_actionPerformed(e);
      }
    });
    btnExit.setBounds(new Rectangle(543, 559, 134, 28));
    btnExit.setFont(new java.awt.Font("Dialog", 1, 11));
    */
    pnl2list.setBounds(new Rectangle(10, 70, 770, 486));
    this.add(blueBkgWhiteCharLabel1, null);
    this.add(pnl2list, null);
    pnl2list.getJtable().addMouseListener(new MouseListener());
    /*
    this.add(btnExit, null);
    this.add(btnDel, null);
    */
  }
  class MouseListener extends java.awt.event.MouseAdapter{
    public void mouseClicked(java.awt.event.MouseEvent me){
      Record rec=(Record)pnl2list.getDisplayingRecords().get((pnl2list.getJtable().getSelectedRow()));
      if(pnl2list.getJtable().getSelectedColumn()!=0){
        return;
      }
      DlgAccDataEdit dlg=new DlgAccDataEdit(util.PublicVariable.APP_FRAME,"EDIT RECORD",true,
                                            rec,pnl2list);
      dlg.setSize(450,480);
      exgui.UIHelper.setToScreenCenter(dlg);
      dlg.show();
    }
  }

  class CellRenderAmt extends JLabel
     implements javax.swing.table.TableCellRenderer{
     public CellRenderAmt(){
     super();
    //setBorder(javax.swing.BorderFactory.createRaisedBevelBorder());
    setOpaque(true); /* it\u00B4s essential */
    setHorizontalAlignment(super.RIGHT);
 }
  public Component getTableCellRendererComponent(
        javax.swing.JTable table, Object value,
        boolean isSelected, boolean hasFocus,
        int row, int column){
       String text = (value==null)?"":value.toString();
       setBackground(new java.awt.Color(0xFF, 0xFF, 0xFF)); // Decides the color
       if(isSelected)setBackground(new java.awt.Color(0xFF, 0xE3, 0x8C));
       if(!text.equals("")){
         text=nf.format(Double.parseDouble(text));
       }
       setText(text);
    return this;
   }
 }
 class CellRenderRowHead extends JLabel
   implements javax.swing.table.TableCellRenderer{
   public CellRenderRowHead(){
   super();
  //setBorder(javax.swing.BorderFactory.createRaisedBevelBorder());
  setOpaque(true); /* it\u00B4s essential */
  setHorizontalAlignment(super.LEFT);
}
public Component getTableCellRendererComponent(
      javax.swing.JTable table, Object value,
      boolean isSelected, boolean hasFocus,
      int row, int column){
     String text = (value==null)?"":value.toString();
     setBackground(new java.awt.Color(0xD0, 0xD0, 0xD0)); // Decides the color
     if(isSelected)setBackground(new java.awt.Color(0xFF, 0xE3, 0x8C));
     setText(text);
  return this;
 }
}


  class TempDb extends exgui.ultratable.PagedDataFactoryAdapter{
     DbAccData db2handle=new DbAccData();
     TempDb(){
     }
     public void updateRecords(Vector vct)throws Exception{
       db2handle.updateRecords(vct);
     }
     public Vector getRecords(int bgn,int rowcount)throws Exception{
        //PnlAccDataMaintainQry.QUERY_STRING="select * from GV_ACC_DATA ";
        Vector vct=exgui2.CONST.BASIC_MAIN_EJB.getDatas(
          util.PublicVariable.USER_RECORD,
          PnlAccDataMaintainQry.QUERY_STRING,bgn,rowcount
        );
        for(int i=0;i<vct.size();i++){
          Record rec=(Record)vct.get(i);
          double balance=(rec.get(10)==null?0:rec.getDouble(10));//   rec.getDouble(10);
          rec.set(10,(balance==0)?"":String.valueOf(balance));
          rec.getModifiedFields().clear();
        }
        if(vct.size()>0)
          blueBkgWhiteCharLabel1.setText("VOUCHER ACCOUNT LIST(Click 1st Column Of Each Row To Edit)");
         else
          blueBkgWhiteCharLabel1.setText("VOUCHER ACCOUNT LIST");
        return vct;
     }
  }
  class Panel2List extends exgui.ultratable.FuncAbstractUltraTablePanel {
    public Panel2List(exgui.ultratable.PagedDataFactory pagedDataFxy,
                      int rowCounts,util.InsertionOrderedHashMap columnMapping,
                     java.util.Hashtable object2StringConvertor){
        super(pagedDataFxy, rowCounts, columnMapping, object2StringConvertor);
        getLowerRightPanel().removeAll();
        JButton btnExit=new JButton("EXIT");
        JButton btnDelete=new JButton("DELETE");
        btnExit.addActionListener(new java.awt.event.ActionListener() {
           public void actionPerformed(ActionEvent e) {
           btnExit_actionPerformed(e);
          }
        });
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
           public void actionPerformed(ActionEvent e) {
           btnDelete_actionPerformed(e);
          }
        });

        getLowerRightPanel().add(btnDelete);
        getLowerRightPanel().add(btnExit);
    }
    public void makeTable(Vector vct){
      super.makeTable(vct);
    getJtable().getColumnModel().getColumn(0).setPreferredWidth(69);
    getJtable().getColumnModel().getColumn(1).setPreferredWidth(58);
    getJtable().getColumnModel().getColumn(2).setPreferredWidth(24);
    getJtable().getColumnModel().getColumn(4).setPreferredWidth(106);
    getJtable().getColumnModel().getColumn(5).setPreferredWidth(106);
    getJtable().getColumnModel().getColumn(6).setPreferredWidth(106);
    getJtable().getColumnModel().getColumn(7).setPreferredWidth(106);
    getJtable().getColumnModel().getColumn(8).setPreferredWidth(76);
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
      me.setTextEditorVerifiers(getObject2StringConvertor());
      CellRenderAmt rnd=new CellRenderAmt();
      getJtable().getColumnModel().getColumn(0).setCellRenderer(new CellRenderRowHead());
      getJtable().getColumnModel().getColumn(4).setCellRenderer(rnd);
      getJtable().getColumnModel().getColumn(5).setCellRenderer(rnd);
      getJtable().getColumnModel().getColumn(6).setCellRenderer(rnd);
      getJtable().getColumnModel().getColumn(7).setCellRenderer(rnd);

    }
    public void doUpdate()throws Exception{
        super.updateModifiedRecord();
    }
  }
  void btnDelete_actionPerformed(ActionEvent e) {
      if(pnl2list.getJtable().getSelectedRows().length==0){
        exgui.verification.VerifyLib.showAlert("Please Select Row(s) To Delete",
                                               "Please Select Row(s) To Delete");
        return;
      }
      if(!exgui.verification.VerifyLib.showConfirm("Do you Sure To Delete Selected Data ?","Are You Sure ?",false) ){
        return ;
      }
      int rows[]=pnl2list.getJtable().getSelectedRows();
      Vector vct=new Vector();
      try{
        for (int i = 0; i < rows.length; i++) {
          Record rec = (Record)pnl2list.getDisplayingRecords().get(rows[i]);
          rec.set("record_delete_flag", "0");
          rec.set("record_modify_user", util.PublicVariable.USER_RECORD.get(0));
          vct.add(rec);
        }
        pnl2list.getPagedDataFactory().updateRecords(vct);
        pnl2list.reload();
      }catch(Exception exp){
        exp.printStackTrace();
        util.ExceptionLog.exp2File(exp,"");
        exgui.verification.VerifyLib.showAlert("Failed In Deleting Records,\nPlease Contact System Manager",
                                               "Update Failed");
      }

  }
  void btnExit_actionPerformed(ActionEvent e) {
    try{
       processhandler.template.Properties.getCenteralControler().goBack();
    }catch(Exception exp){
      exp.printStackTrace();
     }

  }
}
