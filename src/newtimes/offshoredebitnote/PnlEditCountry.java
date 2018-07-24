package newtimes.offshoredebitnote;

import java.awt.*;
import exgui.*;
import javax.swing.*;
import java.awt.event.*;
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

public class PnlEditCountry extends JPanel {
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel1 = new BlueBkgWhiteCharLabel();
  JPanel pnl2PlaceGrid = new JPanel();
  BorderLayout borderLayout1 = new BorderLayout();
  JButton btnExit=new JButton("EXIT");
  JButton btnUpdate=new JButton("UPDATE");
  PnlCountryGrid pnlDb=null;
  public PnlEditCountry() {
    try {
      jbInit();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }

  void jbInit() throws Exception {
    blueBkgWhiteCharLabel1.setText("COUNTRY LIST (PINK MEANS USED)");
    blueBkgWhiteCharLabel1.setBounds(new Rectangle(-1, 30, 797, 27));
    this.setLayout(null);
    pnl2PlaceGrid.setBounds(new Rectangle(8, 74, 770, 500));
    pnl2PlaceGrid.setLayout(borderLayout1);
    this.add(blueBkgWhiteCharLabel1, null);
    this.add(pnl2PlaceGrid, null);
    //500x770

    btnUpdate.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnUpdate_actionPerformed(e);
      }
    });

    btnExit.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnExit_actionPerformed(e);
      }
    });
    util.InsertionOrderedHashMap iso=new util.InsertionOrderedHashMap();
    iso.put("                          COUNTRY NAME  ▼ (可用下拉選擇,或自行登打) ","CNTY_NAME");
    java.util.Hashtable ht=new java.util.Hashtable();
    pnlDb=new PnlCountryGrid (new XHandler(),
                              99999,iso,ht);
    pnlDb.setPreferredSize(new Dimension(500,700));
    pnlDb.firstPage();
    pnl2PlaceGrid.add(pnlDb,BorderLayout.CENTER);

  }
  class XHandler extends exgui.ultratable.PagedDataFactoryAdapter{
    Record recBlank;
   XHandler(){
     try{
       recBlank = exgui2.CONST.BASIC_MAIN_EJB.getBlankRecord("unit_tbl");
       recBlank.getFieldName().clear();
       recBlank.getValueFields().clear();
       recBlank.getFieldName().add("CNTY_PK");
       recBlank.getValueFields().add(null);
       recBlank.getFieldName().add("CNTY_NAME");
       recBlank.getValueFields().add(null);
       recBlank.getFieldName().add("use_count");
       recBlank.getValueFields().add("0");
       recBlank.getFieldName().add("record_create_user");
       recBlank.getValueFields().add(util.PublicVariable.USER_RECORD.get(0));
       recBlank.getFieldName().add("record_modify_user");
       recBlank.getValueFields().add(util.PublicVariable.USER_RECORD.get(0));
       recBlank.getFieldName().add("record_delete_flag");
       recBlank.getValueFields().add("1");
       recBlank.getFieldName().add("record_create_date");
       recBlank.getValueFields().add(null);
       recBlank.getFieldName().add("record_modify_date");
       recBlank.getValueFields().add(null);
       recBlank.getFieldName().add("record_delete_user");
       recBlank.getValueFields().add(null);
       recBlank.getModifiedFields().clear();
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
     ejb.updateCountry(vct2update);
   }
   public java.util.Vector getRecords(int bgn,int rowcount)throws Exception{
     StringBuffer sb=new StringBuffer();

     sb.append("select  ");
     sb.append("a.CNTY_PK, ");
     sb.append("a.CNTY_NAME, ");
     sb.append("(select count(*) from OFS_DEBIT_NOTE_DTL b where a.CNTY_PK=b.DTL_CNTY_PK) as use_count, ");
     sb.append("a.record_create_user,");
     sb.append("a.record_modify_user,");
     sb.append("a.record_delete_flag,");
     sb.append("a.record_create_date,");
     sb.append("a.record_modify_date,");
     sb.append("a.record_delete_user ");
     sb.append("from OFS_DEBIT_NOTE_COUNTRY a  order by a.cnty_name");
     Vector vct=exgui2.CONST.BASIC_MAIN_EJB.getDatas(util.PublicVariable.USER_RECORD,
                                                     sb.toString(),1,999999);
     for(int i=vct.size();i<1000;i++){
       Record rec=(Record)util.MiscFunc.deepCopy(recBlank);
       rec.set(0,i*-1);
       vct.add(rec);
     }
     return vct;
   }
 }
 class PnlCountryGrid extends processhandler.template.PnlTableEditor  {
   PnlCountryGrid(PagedDataFactory pagedDataFxy,
     int rowCounts,util.InsertionOrderedHashMap columnMapping,
     java.util.Hashtable object2StringConvertor){
       super(pagedDataFxy,rowCounts,columnMapping,object2StringConvertor);
       getPanelContainsButtons().removeAll();
       getLowerRightPanel().add(btnUpdate);
       getLowerRightPanel().add(btnExit);

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

     multiEditorJTableInSuper.addJComboBoxEditable(0,newtimes.preproduction.guis.tempProperties.tmpCountries,
                                                  "CNTY_NAME","CNTY_NAME",100);

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
       if(value2update==null ||value2update.toString().trim().length()==0){
         //means to delete.
         rec.set("record_delete_flag","0");
       }
       if(rec.getInt(0)<0){
         rec.set("record_create_user", util.PublicVariable.USER_RECORD.get(0));
       }
       rec.set("record_modify_user",util.PublicVariable.USER_RECORD.get(0));
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
 void btnUpdate_actionPerformed(ActionEvent e) {
   try{

     java.util.HashMap hm2test=new java.util.HashMap();
     for(int i=0;i<pnlDb.getJtable().getRowCount();i++){
       if(pnlDb.getJtable().getValueAt(i,0)!=null){
         String str=pnlDb.getJtable().getValueAt(i,0).toString().toUpperCase().trim();
         if(str.length()==0)continue;
         if(hm2test.containsKey(str)){
           String lastRowPos=(String)hm2test.get(str);
           exgui.verification.VerifyLib.showAlert("Country \""+str+"\" DEFINED AT ROW:"+lastRowPos+" & "+(i+1),
                                                  "Country DUPLICATED");
           return;
         }
         hm2test.put(str,String.valueOf(i+1));
       }
     }

     pnlDb.doUpdate();
     pnlDb.reload();
   }catch(Exception exp){
     exp.printStackTrace();
   }
 }
  void btnExit_actionPerformed(ActionEvent e) {
    try{
      if(pnlDb.isContextModified()){
        if(!exgui.verification.VerifyLib.showConfirm("Data Modified,Do You Want To Leave Without Confirmation?",
                                                     "Data Modified,But Not Save Yet",false)){
          return;
        }
      }
      processhandler.template.Properties.getCenteralControler().
          setDataProcesser(null);
      processhandler.template.Properties.getCenteralControler().goBack();
    }catch(Exception exp){
      exp.printStackTrace();
    }

  }
}
