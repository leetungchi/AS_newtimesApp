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

public class PnlListOffshoreDebitNote extends JPanel {
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel1 = new BlueBkgWhiteCharLabel();
  JButton btnExit = new JButton("EXIT");
  WhiteBkgBlueCharLabel whiteBkgBlueCharLabel1 = new WhiteBkgBlueCharLabel();
  JPanel jPanel1 = new JPanel();
  BorderLayout borderLayout1 = new BorderLayout();
  PnlOfsDtl pnl=null;
  public PnlListOffshoreDebitNote() {
    try {
      jbInit();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }
  void btnExit_actionPerformed(ActionEvent e) {
    try{
      processhandler.template.Properties.getCenteralControler().
          setDataProcesser(null);
      processhandler.template.Properties.getCenteralControler().goBack();
    }catch(Exception exp){
      exp.printStackTrace();
    }
  }

  void jbInit() throws Exception {
    blueBkgWhiteCharLabel1.setText("Offshore Debit Note List,Click To Edit");
    blueBkgWhiteCharLabel1.setBounds(new Rectangle(0, 31, 790, 32));
    this.setLayout(null);
    jPanel1.setBounds(new Rectangle(6, 73, 770, 492));
    jPanel1.setLayout(borderLayout1);
    this.add(blueBkgWhiteCharLabel1, null);
    this.add(jPanel1, null);
    btnExit.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnExit_actionPerformed(e);
      }
    });
    util.InsertionOrderedHashMap iso=new util.InsertionOrderedHashMap();
    iso.put("DEP.▼","DTL_DEP_CODE");
    iso.put("COUNTRY▼","DTL_CNTY_PK");
    iso.put("DATE","DTL_DATE");
    iso.put("DR/CR NO","DTL_DRCR_NO");
    iso.put("佣金支出","DTL_COMM_FEE");
    iso.put(" 什 費 ","DTL_MISC_FEE");
    iso.put("樣品費","DTL_SMPL_FEE");
    iso.put("旅費","DTL_TRVL_FEE");
    iso.put("運費","DTL_TRNPORT_FEE");
    iso.put("交際費","DTL_SOCIAL_FEE");
    iso.put("電話費","DTL_TEL_FEE");
    iso.put("CLAIM","DTL_CLAIM_FEE");
    iso.put(" A/P ","DTL_AP_FEE");
    iso.put(" A/R ","DTL_AR_FEE");

    Hashtable ht=new Hashtable();
    Object rocDateVfy=exgui.verification.CellFormat.getDateStringFormaterAllowNull();
    Object decVfy=newtimes.bank.PnlEditBankHead.getConvDecimalFormat();
    Object chr10=exgui.verification.CellFormat.getOrdinaryField(20);
    ht.put("DATE",rocDateVfy);
    ht.put("DR/CR NO",chr10);
    ht.put("佣金支出",decVfy);
    ht.put(" 什 費 ",decVfy);
    ht.put("樣品費",decVfy);
    ht.put("旅費",decVfy);
    ht.put("運費",decVfy);
    ht.put("交際費",decVfy);
    ht.put("電話費",decVfy);
    ht.put("CLAIM",decVfy);
    ht.put(" A/P ",decVfy);
    ht.put(" A/R ",decVfy);

    pnl=new PnlOfsDtl(Constants.dbOffshoreHandler,
                                9999,iso,ht);

                      //770x490

    pnl.setPreferredSize(new Dimension(770,490));
    pnl.firstPage();
    pnl.getJtable().addMouseListener(
         new MouseListen()
      );
    jPanel1.removeAll();
    jPanel1.add(pnl,BorderLayout.CENTER);
  }
  class MouseListen extends java.awt.event.MouseAdapter{
    public void mouseClicked(java.awt.event.MouseEvent me){
      Constants.EDITING_OFS_DTL_RECORD =(Record)pnl.getDisplayingRecords().get(pnl.getJtable().getSelectedRow());
      try{
        processhandler.template.Properties.getCenteralControler().
            setDataProcesser(null);
        processhandler.template.Properties.getCenteralControler().doCommandExecute(
           new TgrEditOffshoreDebitDtl()
        );
      }catch(Exception exp){
        exp.printStackTrace();
      }

    }
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
       setBackground(new java.awt.Color(0xFF,0xFF,0xFF)); // Decides the color
       setText(text+"    ");
       setHorizontalAlignment(RIGHT);
   return this;
  }
}

  class PnlOfsDtl extends processhandler.template.PnlTableEditor  {
    PnlOfsDtl(PagedDataFactory pagedDataFxy,
      int rowCounts,util.InsertionOrderedHashMap columnMapping,
      java.util.Hashtable object2StringConvertor){
        super(pagedDataFxy,rowCounts,columnMapping,object2StringConvertor);
        getPanelContainsButtons().removeAll();
        getLowerRightPanel().add(btnExit);
    }

    public void makeTable(Vector vct){
      super.makeTable(vct);
      getJtable().getColumnModel().getColumn(0).setPreferredWidth(44);
      getJtable().getColumnModel().getColumn(1).setPreferredWidth(75);
      getJtable().getColumnModel().getColumn(2).setPreferredWidth(60);
      getJtable().getColumnModel().getColumn(3).setPreferredWidth(77);
      getJtable().getColumnModel().getColumn(4).setPreferredWidth(55);
      getJtable().getColumnModel().getColumn(5).setPreferredWidth(50);
      getJtable().getColumnModel().getColumn(6).setPreferredWidth(50);
      getJtable().getColumnModel().getColumn(7).setPreferredWidth(50);
      getJtable().getColumnModel().getColumn(8).setPreferredWidth(50);
      getJtable().getColumnModel().getColumn(9).setPreferredWidth(50);
      getJtable().getColumnModel().getColumn(10).setPreferredWidth(50);
      getJtable().getColumnModel().getColumn(11).setPreferredWidth(50);
      getJtable().getColumnModel().getColumn(12).setPreferredWidth(50);
      getJtable().getColumnModel().getColumn(13).setPreferredWidth(50);

    }

    protected  void refineEditors(MultiEditorJTable multiEditorJTableInSuper){
      multiEditorJTableInSuper.addJComboBox(0,PnlQryOffshoreDebitNote.vctDep,"DEP_CODE","DEP_CODE");
      multiEditorJTableInSuper.addJComboBox(1,PnlQryOffshoreDebitNote.vctCountry,"CNTY_NAME","CNTY_PK");
      multiEditorJTableInSuper.setTextEditorVerifiers(getObject2StringConvertor());
      ((exgui.MultiClassTableModel)multiEditorJTableInSuper.getJTable().getModel()).removeAllEditableColumn();
      MyRenderer monyeRdr=new MyRenderer();
      for(int i=4;i<14;i++){
        getJtable().getColumnModel().getColumn(i).setCellRenderer(monyeRdr);
      }
    }
    public void doPrint(){}
    protected Record setObject2Record(Record rec,int columnAt,Object value2update){
      try{
        rec.set(storedRecordColumn[columnAt],value2update);
        rec.set("record_create_user",util.PublicVariable.USER_RECORD.get(0));
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
    protected int getEachPageRowCount(){return 20;}

  }

}
