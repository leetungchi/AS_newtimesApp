package newtimes.offshoredebitnote;

import java.awt.*;
import javax.swing.*;
import exgui.*;
import javax.swing.border.*;
import database.datatype.Record;
import exgui.ultratable.MultiEditorJTable;
import exgui.ultratable.PagedDataFactory;
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

public class DlgBatchDepPnl extends JDialog {
  JPanel panel1 = new JPanel();
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel1 = new BlueBkgWhiteCharLabel();
  BorderLayout borderLayout2 = new BorderLayout();
  JPanel pnl2PlaceDbGrid = new JPanel();
  BorderLayout borderLayout1 = new BorderLayout();
  Border border1;
  JButton btnConfirmUpdate = new JButton();
  JButton btnExit = new JButton();
  PnlDepGui pnl2Edit=null;
  public DlgBatchDepPnl(Frame frame, String title, boolean modal) {
    super(frame, title, modal);
    try {
      util.MiscFunc.showProcessingMessage();
      jbInit();
      pack();
      util.MiscFunc.hideProcessingMessage();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }

  public DlgBatchDepPnl() {
    this(null, "", false);
  }

  protected void jbInit() throws Exception {
    border1 = new TitledBorder(new EtchedBorder(EtchedBorder.RAISED,Color.white,new Color(148, 145, 140)),"Departsments");
    panel1.setLayout(null);
    this.getContentPane().setLayout(borderLayout2);
    blueBkgWhiteCharLabel1.setText("DEPARTMENTS (PINK MEANS USED)");
    blueBkgWhiteCharLabel1.setBounds(new Rectangle(0, 20, 274, 27));
    pnl2PlaceDbGrid.setBorder(border1);
    pnl2PlaceDbGrid.setBounds(new Rectangle(11, 54, 236, 224));
    pnl2PlaceDbGrid.setLayout(borderLayout1);
    btnConfirmUpdate.setBounds(new Rectangle(5, 293, 124, 29));
    btnConfirmUpdate.setFont(new java.awt.Font("Dialog", 1, 11));
    btnConfirmUpdate.setText("Confirm Update");
    btnConfirmUpdate.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnConfirmUpdate_actionPerformed(e);
      }
    });
    btnExit.setBounds(new Rectangle(155, 291, 86, 30));
    btnExit.setFont(new java.awt.Font("Dialog", 1, 11));
    btnExit.setText("EXIT");
    btnExit.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnExit_actionPerformed(e);
      }
    });
    this.setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
    getContentPane().add(panel1, BorderLayout.CENTER);
    panel1.add(blueBkgWhiteCharLabel1, null);
    panel1.add(pnl2PlaceDbGrid, null);
    panel1.add(btnConfirmUpdate, null);
    panel1.add(btnExit, null);
    XHandler xhandler=new XHandler();
    util.InsertionOrderedHashMap iso=new
        util.InsertionOrderedHashMap();
    iso.put("DEP CODE","dep_code");
    Object objCellVfy=exgui.verification.CellFormat.getOrdinaryField(2);
    Hashtable ht=new Hashtable();
    ht.put("DEP CODE",objCellVfy);
    pnl2Edit=new PnlDepGui(xhandler,99999,iso,ht);
    pnl2PlaceDbGrid.removeAll();
    pnl2PlaceDbGrid.add(pnl2Edit,borderLayout1.CENTER);
    pnl2Edit.firstPage();
  }
  class XHandler extends exgui.ultratable.PagedDataFactoryAdapter{
    Record recBlank;
   XHandler(){
     try{
       recBlank = exgui2.CONST.BASIC_MAIN_EJB.getBlankRecord("unit_tbl");
       recBlank.getFieldName().clear();
       recBlank.getValueFields().clear();
       recBlank.getFieldName().add("dep_code");
       recBlank.getValueFields().add(null);
       recBlank.getFieldName().add("org_dep_code");
       recBlank.getValueFields().add(null);
       recBlank.getFieldName().add("use_count");
       recBlank.getValueFields().add("0");
     }catch(Exception exp){
        exp.printStackTrace();
     }
   }
   public void updateRecords(Vector vct2update)throws Exception{
     newtimesejb.bank.OffShoreFacadeHome ejbHome=
         (newtimesejb.bank.OffShoreFacadeHome)
         info_ejb.WeblogicServiceLocator.locateServiceHome(
         util.PublicVariable.SERVER_URL,
         "newtimesejb.bank.OffShoreFacade");
     newtimesejb.bank.OffShoreFacade ejb=ejbHome.create();
     ejb.updateDep(vct2update,(String)util.PublicVariable.USER_RECORD.get(0));
   }
   public java.util.Vector getRecords(int bgn,int rowcount)throws Exception{
     StringBuffer sb=new StringBuffer();
     sb.append("select  ");
     sb.append("a.dep_code,");
     sb.append("a.dep_code as org_dep_code,");
     //sb.append("a.record_modify_user,");
     sb.append("(select count(*) from OFS_DEBIT_NOTE_DTL b where a.DEP_CODE=b.DTL_DEP_CODE) as use_count ");
     sb.append("from OFS_DEBIT_NOTE_DEP a  order by a.dep_code");
     Vector vct=exgui2.CONST.BASIC_MAIN_EJB.getDatas(util.PublicVariable.USER_RECORD,
                                                     sb.toString(),1,999999);
     for(int i=vct.size();i<1000;i++){
       Record rec=(Record)util.MiscFunc.deepCopy(recBlank);
       vct.add(rec);
     }
     return vct;
   }
 }
 class PnlDepGui extends processhandler.template.PnlTableEditor  {
   PnlDepGui(PagedDataFactory pagedDataFxy,
     int rowCounts,util.InsertionOrderedHashMap columnMapping,
     java.util.Hashtable object2StringConvertor){
       super(pagedDataFxy,rowCounts,columnMapping,object2StringConvertor);
       getPanelContainsButtons().removeAll();
   }
   public class MyRenderer extends JLabel
       implements javax.swing.table.TableCellRenderer{
       public MyRenderer(){
       super();
      setOpaque(true); /* it\u00B4s essential */
   }
    public Component getTableCellRendererComponent(
          javax.swing.JTable table, Object value,
          boolean isSelected, boolean hasFocus,
          int row, int column){
          String text = (value==null)?"":value.toString();
          if(table.getModel().isCellEditable(row,column)){
            setBackground(new java.awt.Color(0xFF,0xFF,0xFF)); // Decides the color
            setText(text);
            return this;
          }
         //if(text.equals("Waiting")) /*
         setBackground(new java.awt.Color(0xFF,0x90,0x90)); // Decides the color
         setText(text); /* Put the current text in the JLabel */
      return this;
     }
   }


   class EditPolicy implements exgui.CellEditablePolicy{
     public boolean isCellEditable(int row,int column){
       if(((Record)getDisplayingRecords().get(row)).getInt(2)>0){
         //use_count > 0,means this dep code used in detail record.
         return false;
       }
       return true;
     }
   }

   protected  void refineEditors(MultiEditorJTable multiEditorJTableInSuper){
     EditPolicy isEditable=new EditPolicy();
     ((exgui.MultiClassTableModel)getJtable().getModel()).setCellEditablePolicy(isEditable);
     MyRenderer myrdr=new MyRenderer();
     this.getJtable().getColumnModel().getColumn(0).setCellRenderer(myrdr);
     multiEditorJTableInSuper.setTextEditorVerifiers(getObject2StringConvertor());
   }
   public void doPrint(){}
   protected Record setObject2Record(Record rec,int columnAt,Object value2update){
     try{
       rec.set(storedRecordColumn[columnAt],value2update);
       return rec;
     }catch(Exception exp){
       exp.printStackTrace();
       return null;
     }
   }
   protected PagedDataFactory getPagedDataFactory(){return dbHandler;}
   protected util.InsertionOrderedHashMap getHeadColumnMap(){
      return tblHeadColumn;
   }
   protected java.util.Hashtable getObject2StringConvertor(){
     return klmObjKvtHt;
   }
   protected int getEachPageRowCount(){return 99999;}

 }

  void btnExit_actionPerformed(ActionEvent e) {
     if(pnl2Edit.isContextModified()){
       if(exgui.verification.VerifyLib.showConfirm("Data Modified,Do you Want To leave Without Saving ?",
                                                   "Data Modified",false) ){
         this.dispose();
       }else{
         return;
       }
     }else{
       this.dispose();
     }
  }

  void btnConfirmUpdate_actionPerformed(ActionEvent e) {
     //check all talbe's dep if any duplicate
     pnl2Edit.getJtable().changeSelection(0,0,false,false);
     try{
       java.util.HashMap hm2test=new java.util.HashMap();
       for(int i=0;i<pnl2Edit.getJtable().getRowCount();i++){
         if(pnl2Edit.getJtable().getValueAt(i,0)!=null){
           String str=pnl2Edit.getJtable().getValueAt(i,0).toString().toUpperCase().trim();
           if(str.length()==0)continue;
           if(str.length()==1){
             exgui.verification.VerifyLib.showAlert("DEP CODE SHOULD BE 2 CHARACTERS","STRING TOO SHORT");
             pnl2Edit.getJtable().changeSelection(i,0,false,false);
             return;
           }
           if(hm2test.containsKey(str)){
             String lastRowPos=(String)hm2test.get(str);
             exgui.verification.VerifyLib.showAlert("DEP CODE \""+str+"\" DEFINED AT ROW:"+lastRowPos+" & "+(i+1),
                                                    "DEP CODE DUPLICATED");
             return;
           }
           hm2test.put(str,String.valueOf(i+1));
         }
       }
       pnl2Edit.doUpdate();
       exgui.verification.VerifyLib.showPlanMsg("UPDATE OK","UPDATE OK");
       pnl2Edit.reload();
     }catch(Exception exp){
       exp.printStackTrace();

     }

  }

}
