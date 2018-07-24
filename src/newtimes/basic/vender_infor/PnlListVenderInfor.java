package newtimes.basic.vender_infor;

import java.awt.*;
import javax.swing.*;
import exgui.*;
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

public class PnlListVenderInfor extends JPanel {
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel1 = new BlueBkgWhiteCharLabel();
  Panel2List pnl2list;
  boolean isChecking4Update;
  MyVendorSelector slkVender= new MyVendorSelector();

  public PnlListVenderInfor() {
    try {
      jbInit();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }

  void jbInit() throws Exception {
    blueBkgWhiteCharLabel1.setText("VENDOR BANK LIST");
    blueBkgWhiteCharLabel1.setBounds(new Rectangle(-2, 10, 802, 35));
    this.setLayout(null);
    util.InsertionOrderedHashMap iso=new util.InsertionOrderedHashMap();
    iso.put("  CODE  ","BYMKR_HK_CODE");
    iso.put("    ","DOTS");
    iso.put("   NAME    ","COLLECT_BANK");
    iso.put("   LINE1    ","BANK_ADD1");
    iso.put("   LINE2    ","BANK_ADD2");
    iso.put("   SWIFT    ","SWIFT");
    iso.put("  RECIPIENT  ","COLLECT_BY");
    iso.put("  ACCOUNT#   ","ACC_NO");

    java.util.Hashtable ht=new Hashtable();
    Object chk10= exgui.verification.CellFormat.getOrdinaryField(100);
    Object chk120= exgui.verification.CellFormat.getOrdinaryField(120);
    //Object chk80= exgui.verification.CellFormat.getOrdinaryField(80);
    Object chk200= exgui.verification.CellFormat.getOrdinaryField(200);

    ht.put("  CODE  ",chk10);
    ht.put("   NAME    ",chk120);
    ht.put("   LINE1    ",chk200);
    ht.put("   LINE2    ",chk200);
    ht.put("   SWIFT    ",chk120);
    ht.put("  RECIPIENT  ",chk120);
    ht.put("  ACCOUNT#   ",chk120);

    pnl2list=new Panel2List(new TempDb(),9999999,iso,ht);
    pnl2list.setBounds(new Rectangle(2, 48, 793, 530));
    this.add(blueBkgWhiteCharLabel1, null);
    this.add(pnl2list, null);
    slkVender.init("",null,slkVender.TYPE_VENDOR,true);
    slkVender.setModifyNotifyTo(new VendorChanged());
    pnl2list.getJtable().addMouseListener(new MouseClickAdp());
  }
  class MouseClickAdp extends java.awt.event.MouseAdapter{
    public void mouseClicked(java.awt.event.MouseEvent me){
      if(pnl2list.getJtable().getSelectedColumn()==1){
        slkVender.btnDots_actionPerformed(null);
        return;
      }
    }
  }
  public class MyVendorSelector extends newtimes.preproduction.buyermakerselect.SelectBuyerMaker{
   public  void btnDots_actionPerformed(java.awt.event.ActionEvent e) {
     super.btnDots_actionPerformed(e);
   }
 }

  class TblEditPlicy implements exgui.CellEditablePolicy{
    public boolean isCellEditable(int row,int column){
      if(isChecking4Update && column==1)return true;
      if(isChecking4Update)return true;
      if(column<2)return false;
      return true;
    }
  }
  class CellRender extends JLabel
      implements javax.swing.table.TableCellRenderer{
      public CellRender(){
      super();
     setBorder(javax.swing.BorderFactory.createRaisedBevelBorder());
     setOpaque(true); /* it\u00B4s essential */
     setHorizontalAlignment(JLabel.CENTER);
  }
   public Component getTableCellRendererComponent(
         javax.swing.JTable table, Object value,
         boolean isSelected, boolean hasFocus,
         int row, int column){
        String text = (value==null)?"":value.toString();
        if(text.trim().equals("")){
          setBackground(new java.awt.Color(0xFF, 0xFF, 0xFF)); // Decides the color
        }else{
            setBackground(new java.awt.Color(0xE0, 0xE0, 0xE0)); // Decides the color
        }
        setText(text);
     return this;
    }
  }

  class Panel2List extends exgui.ultratable.FuncAbstractUltraTablePanel
    implements processhandler.DataProcesser {
    String table_snapshot=null;
    public Panel2List(exgui.ultratable.PagedDataFactory pagedDataFxy,
                      int rowCounts,util.InsertionOrderedHashMap columnMapping,
                     java.util.Hashtable object2StringConvertor){
        super(pagedDataFxy, rowCounts, columnMapping, object2StringConvertor);
        super.getLowerRightPanel().removeAll();
        //add 3 buttons,--ADD,DEL,UPDATE,EXIT;
        JButton btnAdd = new JButton("ADD");
        JButton btnDel=new JButton("DEL");
        JButton btnUpdate=new JButton("UPDATE");
        JButton btnExit=new JButton("EXIT");

        btnExit.addActionListener(new java.awt.event.ActionListener() {
          public void actionPerformed(ActionEvent e) {
           if(pnl2list.isContextModified()){
             if(!exgui.verification.VerifyLib.showConfirm("Context Modified\nDo You Really Want To Exit",
                                                      "Context Modified",false) ){
                return;
              }
           }
           ToAXN.ShowQryGUI();
          }
        });

        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
          public void actionPerformed(ActionEvent e) {
           btnUpdate_actionPerformed(null);
          }
        });

        btnDel.addActionListener(new java.awt.event.ActionListener() {
          public void actionPerformed(ActionEvent e) {
            btnDelete_actionPerformed(null);
          }
        });


        btnAdd.addActionListener(new java.awt.event.ActionListener() {
          public void actionPerformed(ActionEvent e) {
            btnUpdate_actionPerformed(null);
            Vector vct=new Vector();
            try{
              Record rec = dbHandler.getBlankRecord();
              rec.set(0,System.currentTimeMillis());
              vct.add(rec);
              dbHandler.updateRecords(vct);
              reload();
            }catch(Exception exp){
              exgui.verification.VerifyLib.showAlert("Error While Add New Record","Error While Add New Record");
              exp.printStackTrace();
              util.ExceptionLog.exp2File(exp,"");
            }
          }
        });

        if(ToAXN.vender_seq!=-1){
          getLowerRightPanel().add(btnAdd);
        }
        getLowerRightPanel().add(btnDel);
        getLowerRightPanel().add(btnUpdate);
        getLowerRightPanel().add(btnExit);
        firstPage();
    }
    public void doAddNew(){}
    public void doDelete(){}
    public void doPrint(){}
    public void doExit(){}
    public void doPaste(){}
    public void exitCurrentGui(){}
    protected void makeTable(Vector vct){
      super.makeTable(vct);
      table_snapshot=util.MiscFunc.table2Text(getJtable());
    }

    public boolean isContextModified(){
      if(getJtable().isEditing()){
       Object obj= getJtable().getCellEditor().getCellEditorValue();
       int col=getJtable().getEditingColumn();
       int row=getJtable().getEditingRow();
       getJtable().setValueAt(obj,row,col);
       getJtable().getCellEditor().cancelCellEditing();
      }
      return !(util.MiscFunc.table2Text(getJtable()).equals(table_snapshot));

    }
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
       //
       me.setTableColumn2Grp(" VENDOR ",0);
       me.setTableColumn2Grp(" VENDOR ",1);
       String titleBank="VENDOR'S BANK";
       me.setTableColumn2Grp(titleBank,2);
       me.setTableColumn2Grp(titleBank,3);
       me.setTableColumn2Grp(titleBank,4);

       CellRender cdr=new CellRender();
       this.getJtable().getColumnModel().getColumn(1).setCellRenderer(cdr);
       ((exgui.MultiClassTableModel)me.getJTable().getModel()).setCellEditablePolicy(new TblEditPlicy());
       me.setTextEditorVerifiers(getObject2StringConvertor());
    }
    public void doUpdate()throws Exception{
      try{
        isChecking4Update = true;
        super.updateModifiedRecord();
        table_snapshot=util.MiscFunc.table2Text(getJtable());
      }finally{
        isChecking4Update=false;
      }
    }
  }

  class VendorChanged implements newtimes.preproduction.buyermakerselect.BuyerMakerChanged{
    public void changeBuyerMaker(Record rec) {
      try {
        isChecking4Update=true;
        if (rec == null) {
          pnl2list.getJtable().setValueAt("", pnl2list.getJtable().getSelectedRow(), 0);
          Record recData = (Record)pnl2list.getDisplayingRecords().get(pnl2list.getJtable().getSelectedRow());
          recData.set("VENDER_SEQ", null);
          recData.set("BYMKR_HK_CODE", null);
        } else {
          String hk_code = (String)rec.get("Bymkr_hk_code");
          if (hk_code == null) hk_code = (String)rec.get("BYMKR_BRIEF");
          pnl2list.getJtable().setValueAt(hk_code, pnl2list.getJtable().getSelectedRow(), 0);
          Record recData = (Record)pnl2list.getDisplayingRecords().get(pnl2list.getJtable().getSelectedRow());
          recData.set("BYMKR_HK_CODE", hk_code);
          recData.set("VENDER_SEQ", rec.get(0));
        }
        pnl2list.repaint();
        pnl2list.validate();
      } catch (Exception exp) {
        exp.printStackTrace();
        util.ExceptionLog.exp2File(exp, "");
      }finally{
        isChecking4Update=false;
      }
    }
  }


 class TempDb extends exgui.ultratable.PagedDataFactoryAdapter{
   newtimesejb.TPE_MIS.TpeMisFunc ejb2update;
   public TempDb(){
     try{
       Record recBlank=exgui2.CONST.BASIC_MAIN_EJB.getBlankRecord("VENDER_INFOR_tbl");
       recBlank.getFieldName().add("BYMKR_HK_CODE");
       recBlank.getValueFields().add(null);
       recBlank.getFieldName().add("BYMKR_BRIEF");
       recBlank.getValueFields().add(null);
       recBlank.getFieldName().add("DOTS");
       recBlank.set("record_delete_flag",-1);
       recBlank.set("record_create_user",util.PublicVariable.USER_RECORD.get(0));
       recBlank.getValueFields().add(null);
       recBlank.set(1,(ToAXN.vender_seq==-1)?null:String.valueOf(ToAXN.vender_seq));
       super.blankRecord=recBlank;
       newtimesejb.TPE_MIS.TpeMisFuncHome ejbHome=
           (newtimesejb.TPE_MIS.TpeMisFuncHome)
           info_ejb.WeblogicServiceLocator.locateServiceHome(util.PublicVariable.SERVER_URL,"newtimesejb.TPE_MIS.TpeMisFunc");
       ejb2update=ejbHome.create();
     }catch(Exception exp){
       exp.printStackTrace();
       util.ExceptionLog.exp2File(exp,"");
     }
   }
   public Vector getRecords(int bgn,int rowcount)throws Exception{
     StringBuffer sb=new StringBuffer();
     sb.append("select a.*,");
     sb.append("(select b.BYMKR_HK_CODE from buyer_maker b where a.vender_seq=b.bymkr_seq ) as BYMKR_HK_CODE,");
     sb.append("(select c.BYMKR_BRIEF from buyer_maker c where a.vender_seq=c.bymkr_seq ) as BYMKR_BRIEF,");
     sb.append("'...' as dots ");
     //b.BYMKR_HK_CODE,b.BYMKR_BRIEF ,'...' as dots from VENDER_INFOR a,buyer_maker b ");
     sb.append(" from VENDER_INFOR a  ,buyer_maker b");
     sb.append(" where a.VENDER_SEQ=b.bymkr_seq ");
     sb.append(" and b.selectable_center like '%,");
     sb.append(util.PublicVariable.OPERATTING_CENTER);
     sb.append(",%' ");

     if(-1!=ToAXN.vender_seq){
       sb.append(" and a.VENDER_SEQ=");
       sb.append(String.valueOf(ToAXN.vender_seq));
     }
     Vector vct=exgui2.CONST.BASIC_MAIN_EJB.getDatas(
        util.PublicVariable.USER_RECORD,
        sb.toString(),1,20
      );
     return vct;
    }
   public void updateRecords(Vector vct2update)throws Exception{
      java.util.HashMap hm=new java.util.HashMap();
      hm.put("TPEMISCFUNC_ACTION_CODE","UPDATE_VENDER_INFOR");
      hm.put("VCT_VENDER_INFOR",vct2update);
      try{
        util.MiscFunc.showProcessingMessage();
        ejb2update.tpeMisFunc(hm);
      }finally{
        util.MiscFunc.hideProcessingMessage();
      }
   }
 }
  void btnUpdate_actionPerformed(ActionEvent e) {
    try{
      pnl2list.doUpdate();
      pnl2list.reload();
    }catch(Exception exp){
      exp.printStackTrace();
      util.ExceptionLog.exp2File(exp,"");
    }
  }
  void btnDelete_actionPerformed(ActionEvent e) {
     int rows[]=pnl2list.getJtable().getSelectedRows();
     if(rows.length==0){
       exgui.verification.VerifyLib.showAlert("Please Seelect Row(s) To Delete",
                                              "Please Seelect Row(s)");
       return;
     }
     if(!exgui.verification.VerifyLib.showConfirm("Do You Sure To Delete Select Rows ?","Do You Sure",false) ){
       return;
     }
     Vector vct2del=new Vector();
     try{
       for(int i=0;i<rows.length;i++){
         database.datatype.Record rec=(database.datatype.Record)pnl2list.getDisplayingRecords().get(rows[i]);
         rec.set("record_delete_flag","0");
         rec.set("record_modify_user",util.PublicVariable.USER_RECORD.get(0));
         System.out.println("rec to delete "+rec.toString() );
         vct2del.add(rec);
       }
       util.MiscFunc.showProcessingMessage();
       pnl2list.getPagedDataFactory().updateRecords(vct2del);
       pnl2list.reload();

     }catch(Exception exp){
       exp.printStackTrace();
     }finally{
       util.MiscFunc.hideProcessingMessage();
     }

  }

}
