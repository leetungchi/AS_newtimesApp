package newtimes.general_voucher.daily_voucher;

import java.awt.*;
import exgui.*;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.event.*;
import java.util.HashMap;
import java.util.Vector;
import database.datatype.Record;
/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class Pnl1102X0I3RxTableEditor extends JPanel {
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel1 = new BlueBkgWhiteCharLabel();
  //JPanel pnlListRush = new JPanel();
  JButton btnUndo = new JButton();
  JButton btnUpdateTable = new JButton();
  JButton btnDelete = new JButton();
  //JPanel pnlAddNew = new JPanel();
  PnlEditRush pnlAddNew=null;
  Border border1;
  WhiteBkgBlueCharLabel whiteBkgBlueCharLabel1 = new WhiteBkgBlueCharLabel();
  JTextField txtVhDate = new JTextField();
  JTextField txtPayDate = new JTextField();
  WhiteBkgBlueCharLabel whiteBkgBlueCharLabel2 = new WhiteBkgBlueCharLabel();
  WhiteBkgBlueCharLabel whiteBkgBlueCharLabel3 = new WhiteBkgBlueCharLabel();
  JComboBox cbxType = new JComboBox();
  JTextField txtVhNo = new JTextField();
  WhiteBkgBlueCharLabel whiteBkgBlueCharLabel4 = new WhiteBkgBlueCharLabel();
  WhiteBkgBlueCharLabel whiteBkgBlueCharLabel5 = new WhiteBkgBlueCharLabel();
  JTextField txtVhAccCode = new JTextField();
  JTextField txtVhSeq = new JTextField();
  WhiteBkgBlueCharLabel whiteBkgBlueCharLabel6 = new WhiteBkgBlueCharLabel();
  JTextField txtVhCD = new JTextField();
  WhiteBkgBlueCharLabel whiteBkgBlueCharLabel7 = new WhiteBkgBlueCharLabel();
  WhiteBkgBlueCharLabel whiteBkgBlueCharLabel8 = new WhiteBkgBlueCharLabel();
  JTextField txtBuyer = new JTextField();
  WhiteBkgBlueCharLabel whiteBkgBlueCharLabel9 = new WhiteBkgBlueCharLabel();
  JTextField txtAmt = new JTextField();
  WhiteBkgBlueCharLabel whiteBkgBlueCharLabel10 = new WhiteBkgBlueCharLabel();
  JTextField txtMaker = new JTextField();
  JButton btnAddNewSingleRow = new JButton();
  JButton btnCancelEditSingleRow = new JButton();
  JButton btnExit = new JButton();
  PnlListRush pnlListRush;
  TempDb db2Handle=new TempDb();
  int selectedDebitRow=-1;
  Vector vctType=null;
  java.util.Stack stkUndoList=new java.util.Stack();
  int AMT_COLUMN_AT;
  int CD_COLUMN_AT;
  JLabel lblTotal = new JLabel();
  public Pnl1102X0I3RxTableEditor() {
    try {
      //jbInit();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }

  void jbInit() throws Exception {
    border1 = new EtchedBorder(EtchedBorder.RAISED,Color.white,new Color(148, 145, 140));
    blueBkgWhiteCharLabel1.setFont(new java.awt.Font("Dialog", 1, 16));
    blueBkgWhiteCharLabel1.setText("兆豐美乙 勾沖作業");
    blueBkgWhiteCharLabel1.setBounds(new Rectangle(-1, 14, 802, 28));
    this.setBackground(new Color(202, 202, 224));
    this.setLayout(null);
    btnUndo.setBounds(new Rectangle(394, 463, 131, 29));
    btnUndo.setFont(new java.awt.Font("Dialog", 1, 14));
    btnUndo.setForeground(Color.red);
    btnUndo.setText("恢復上一狀態");
    btnUndo.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnUndo_actionPerformed(e);
      }
    });
    btnUpdateTable.setText("UPDATE");
    btnUpdateTable.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnUpdateTable_actionPerformed(e);
      }
    });
    btnUpdateTable.setFont(new java.awt.Font("Dialog", 1, 14));
    btnUpdateTable.setForeground(Color.black);
    btnUpdateTable.setBounds(new Rectangle(529, 463, 101, 29));
    btnDelete.setText("刪除選取列");
    btnDelete.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnDelete_actionPerformed(e);
      }
    });
    btnDelete.setForeground(Color.red);
    btnDelete.setFont(new java.awt.Font("Dialog", 0, 16));
    btnDelete.setBounds(new Rectangle(249, 463, 120, 29));
    //pnlAddNew.setLayout(null);
    btnExit.setBounds(new Rectangle(666, 463, 101, 29));
    btnExit.setForeground(Color.black);
    btnExit.setFont(new java.awt.Font("Dialog", 1, 14));
    btnExit.setText("EXIT");
    btnExit.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnExit_actionPerformed(e);
      }
    });
    lblTotal.setFont(new java.awt.Font("Dialog", 1, 14));
    lblTotal.setText("TOTAL:");
    lblTotal.setBounds(new Rectangle(41, 463, 191, 26));
    this.add(blueBkgWhiteCharLabel1, null);
    //pnlAddNew=new PnlEditRush();
    //======edit of single rush record
    //==end of edit of single rush record

    /*
         btnCancelEditSingleRow.addActionListener(new java.awt.event.ActionListener() {
           public void actionPerformed(ActionEvent e) {
             btnCancelEditSingleRow_actionPerformed(e);
           }
         });
         btnAddNewSingleRow.addActionListener(new java.awt.event.ActionListener() {
           public void actionPerformed(ActionEvent e) {
             btnAddNewSingleRow_actionPerformed(e);
           }
         });

    pnlAddNew.setBackground(new Color(202, 202, 224));

    pnlAddNew.setBounds(new Rectangle(10, 494, 781, 88));

    pnlAddNew.add(whiteBkgBlueCharLabel1, null);
    pnlAddNew.add(whiteBkgBlueCharLabel3, null);
    pnlAddNew.add(whiteBkgBlueCharLabel4, null);
    pnlAddNew.add(txtVhNo, null);
    pnlAddNew.add(whiteBkgBlueCharLabel5, null);
    pnlAddNew.add(txtVhAccCode, null);
    pnlAddNew.add(whiteBkgBlueCharLabel6, null);
    pnlAddNew.add(txtVhSeq, null);
    pnlAddNew.add(whiteBkgBlueCharLabel7, null);
    pnlAddNew.add(txtVhCD, null);
    pnlAddNew.add(cbxType, null);
    pnlAddNew.add(txtPayDate, null);
    pnlAddNew.add(whiteBkgBlueCharLabel2, null);
    pnlAddNew.add(whiteBkgBlueCharLabel8, null);
    pnlAddNew.add(txtBuyer, null);
    pnlAddNew.add(whiteBkgBlueCharLabel9, null);
    pnlAddNew.add(txtAmt, null);
    pnlAddNew.add(whiteBkgBlueCharLabel10, null);
    pnlAddNew.add(txtMaker, null);
    pnlAddNew.add(btnAddNewSingleRow, null);
    pnlAddNew.add(btnCancelEditSingleRow, null);
    pnlAddNew.add(txtVhDate, null);
   */

    this.add(btnUpdateTable, null);
    this.add(btnDelete, null);
    this.add(btnUndo, null);
    this.add(btnExit, null);
    this.add(lblTotal, null);
    util.InsertionOrderedHashMap iso=new util.InsertionOrderedHashMap();
    iso.put("DATE","VH_DATE");
    iso.put("  VH#  ","VH_NO");
    iso.put("SEQ","VH_SEQ");
    iso.put("ACC#   ","VH_ACCOUNT");
    iso.put("C/D","C_D");
    CD_COLUMN_AT=iso.entrySet().size()-1;
    iso.put(" TYPE ","TYPE");
    iso.put("匯款日","PAY_DATE");
    iso.put("BUYER","BUYER");
    iso.put("AMT","AMT");
    AMT_COLUMN_AT=iso.entrySet().size()-1;
    iso.put("MAKER","MAKER");
    Object vfyDate=exgui.verification.CellFormat.getDateStringFormaterAllowNull();
    java.util.Hashtable ht=new java.util.Hashtable();
    ht.put("DATE",vfyDate);
    ht.put("匯款日",vfyDate);
    pnlListRush=new PnlListRush(db2Handle,99999,iso,ht);
    pnlListRush.setBounds(new Rectangle(8, 48, 782, 409));
    this.add(pnlListRush, null);
    pnlAddNew=new PnlEditRush();
    pnlAddNew.setBorder(border1);
    pnlAddNew.setBounds(new Rectangle(10, 494, 781, 88));
    this.add(pnlAddNew, null);
    //pnlAddNew.jbInit();
    pnlListRush.getJtable().addMouseListener(
       new java.awt.event.MouseAdapter(){
         public void mouseClicked(java.awt.event.MouseEvent me){
            rowClicked();
         }
       }

    );

  }
  void updateTotal(){
     java.text.NumberFormat nf=new java.text.DecimalFormat("##################.00");
     double cTotal=0;
     double totalValue=0;
     for(int i=0;i<pnlListRush.getJtable().getRowCount();i++){
       if("D".equals(pnlListRush.getJtable().getValueAt(i,CD_COLUMN_AT))){
         totalValue+=cell2Double(pnlListRush.getJtable().getValueAt(i,AMT_COLUMN_AT));
       }else{
         totalValue-=cell2Double(pnlListRush.getJtable().getValueAt(i,AMT_COLUMN_AT));
       }
     }
     lblTotal.setText("TOTAL:"+  nf.format (totalValue));
  }
  double cell2Double(Object obj){
    if(obj!=null && obj.toString().trim().length()>0){
      return Double.parseDouble(obj.toString());
    }
    return 0;
  }
  void rowClicked(){
    if(pnlListRush.getJtable().getSelectedRow()!=-1){
      int slkRow=pnlListRush.getJtable().getSelectedRow();
      Record rec=(Record)pnlListRush.getDisplayingRecords().get(slkRow);
      pnlAddNew.setRecord(rec);
      btnAddNewSingleRow.setText("UPDATE");
      pnlAddNew.record2Gui();
      try{
        if(pnlListRush.getJtable().getSelectedColumn()==0)return;
        String cd= (String)pnlListRush.getJtable().getValueAt(slkRow,CD_COLUMN_AT);  //rec.get("C_D").toString();
        if("D".equalsIgnoreCase(cd)){
          selectedDebitRow=slkRow;
          ///back up current status
         HistoryNode node=new HistoryNode();
         node.vct2Del=(Vector) util.MiscFunc.deepCopy(db2Handle.vctDelete);
         node.vct2List=(Vector) util.MiscFunc.deepCopy(db2Handle.orgVector);
         stkUndoList.push(node);
        }else{
          if(selectedDebitRow==-1)return;
          //minus the C's valueto row D
          double dValue=cell2Double(pnlListRush.getJtable().getValueAt(selectedDebitRow,AMT_COLUMN_AT));
          double cValue=cell2Double(pnlListRush.getJtable().getValueAt(slkRow,AMT_COLUMN_AT));
          dValue-=cValue;
          cValue=0;
          Record recD=(Record)db2Handle.orgVector.get(selectedDebitRow);
          Record recC=(Record)db2Handle.orgVector.get(slkRow);
          recD.set("AMT",dValue);
          recC.set("AMT",0);
          db2Handle.orgVector.set(selectedDebitRow,recD);
          db2Handle.orgVector.set(slkRow,recC);
          pnlListRush.reload();
        }
      }catch(Exception exp){
        exp.printStackTrace();
      }

    }
  }
  class PnlEditRush
      //extends JPanel{
      extends processhandler.template.PnlFieldsEditor{
    PnlEditRush(){
      super();
      try{
        jbInit();
      }catch(Exception exp){
        exp.printStackTrace();
      }
    }
    public void jbInit()throws Exception{
      this.setLayout(null);
      setBackground(new Color(202, 202, 224));
      whiteBkgBlueCharLabel1.setFont(new java.awt.Font("Dialog", 0, 14));
      whiteBkgBlueCharLabel1.setText("傳票日期");
      whiteBkgBlueCharLabel1.setBounds(new Rectangle(4, 8, 68, 23));
      txtVhDate.setText("");
      txtVhDate.setBounds(new Rectangle(72, 8, 76, 23));
      txtPayDate.setBounds(new Rectangle(238, 46, 76, 23));
      txtPayDate.setText("");
      whiteBkgBlueCharLabel2.setBounds(new Rectangle(169, 46, 68, 23));
      whiteBkgBlueCharLabel2.setText("匯入日期");
      whiteBkgBlueCharLabel2.setFont(new java.awt.Font("Dialog", 0, 14));
      whiteBkgBlueCharLabel3.setFont(new java.awt.Font("Dialog", 0, 14));
      whiteBkgBlueCharLabel3.setText("款項");
      whiteBkgBlueCharLabel3.setBounds(new Rectangle(4, 47, 48, 23));
      cbxType.setBounds(new Rectangle(53, 47, 115, 23));
      txtVhNo.setBounds(new Rectangle(234, 8, 102, 23));
      txtVhNo.setText("");
      whiteBkgBlueCharLabel4.setBounds(new Rectangle(158, 8, 75, 23));
      whiteBkgBlueCharLabel4.setText("傳票號碼");
      whiteBkgBlueCharLabel4.setFont(new java.awt.Font("Dialog", 0, 14));
      whiteBkgBlueCharLabel5.setFont(new java.awt.Font("Dialog", 0, 14));
      whiteBkgBlueCharLabel5.setText("科目代號");
      whiteBkgBlueCharLabel5.setBounds(new Rectangle(344, 8, 75, 23));
      txtVhAccCode.setText("");
      txtVhAccCode.setBounds(new Rectangle(420, 8, 102, 23));
      txtVhSeq.setBounds(new Rectangle(577, 8, 55, 23));
      txtVhSeq.setText("");
      whiteBkgBlueCharLabel6.setBounds(new Rectangle(538, 8, 39, 23));
      whiteBkgBlueCharLabel6.setText("SEQ:");
      whiteBkgBlueCharLabel6.setFont(new java.awt.Font("Dialog", 0, 14));
      txtVhCD.setText("");
      txtVhCD.setBounds(new Rectangle(702, 8, 55, 23));
      whiteBkgBlueCharLabel7.setFont(new java.awt.Font("Dialog", 0, 14));
      whiteBkgBlueCharLabel7.setText("C/D");
      whiteBkgBlueCharLabel7.setBounds(new Rectangle(663, 8, 39, 23));
      whiteBkgBlueCharLabel8.setFont(new java.awt.Font("Dialog", 0, 14));
      whiteBkgBlueCharLabel8.setText("Buyer");
      whiteBkgBlueCharLabel8.setBounds(new Rectangle(317, 47, 46, 23));
      txtBuyer.setText("");
      txtBuyer.setBounds(new Rectangle(364, 47, 51, 23));
      whiteBkgBlueCharLabel9.setBounds(new Rectangle(419, 47, 42, 23));
      whiteBkgBlueCharLabel9.setText("Amt");
      whiteBkgBlueCharLabel9.setFont(new java.awt.Font("Dialog", 0, 14));
      txtAmt.setBounds(new Rectangle(462, 47, 51, 23));
      txtAmt.setText("");
      whiteBkgBlueCharLabel10.setBounds(new Rectangle(514, 47, 49, 23));
      whiteBkgBlueCharLabel10.setText("Maker");
      whiteBkgBlueCharLabel10.setFont(new java.awt.Font("Dialog", 0, 14));
      txtMaker.setBounds(new Rectangle(564, 47, 51, 23));
      txtMaker.setText("");
      btnAddNewSingleRow.setBounds(new Rectangle(620, 46, 81, 25));
      btnAddNewSingleRow.setFont(new java.awt.Font("Dialog", 1, 11));
      btnAddNewSingleRow.setMargin(new Insets(1, 1, 1, 1));
      btnAddNewSingleRow.setText("Add New");
      btnCancelEditSingleRow.setText("Cancel");
      btnCancelEditSingleRow.setBounds(new Rectangle(705, 46, 71, 25));
      btnCancelEditSingleRow.setFont(new java.awt.Font("Dialog", 1, 12));
      btnCancelEditSingleRow.setMargin(new Insets(1, 1, 1, 1));


      this.add(whiteBkgBlueCharLabel1, null);
      this.add(whiteBkgBlueCharLabel3, null);
      this.add(whiteBkgBlueCharLabel4, null);
      this.add(txtVhNo, null);
      this.add(whiteBkgBlueCharLabel5, null);
      this.add(txtVhAccCode, null);
      this.add(whiteBkgBlueCharLabel6, null);
      this.add(txtVhSeq, null);
      this.add(whiteBkgBlueCharLabel7, null);
      this.add(txtVhCD, null);
      this.add(cbxType, null);
      this.add(txtPayDate, null);
      this.add(whiteBkgBlueCharLabel2, null);
      this.add(whiteBkgBlueCharLabel8, null);
      this.add(txtBuyer, null);
      this.add(whiteBkgBlueCharLabel9, null);
      this.add(txtAmt, null);
      this.add(whiteBkgBlueCharLabel10, null);
      this.add(txtMaker, null);
      this.add(btnAddNewSingleRow, null);
      this.add(btnCancelEditSingleRow, null);
      this.add(txtVhDate, null);
      btnCancelEditSingleRow.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(ActionEvent e) {
          btnCancelEditSingleRow_actionPerformed(e);
        }
      });
      btnAddNewSingleRow.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(ActionEvent e) {
          btnAddNewSingleRow_actionPerformed(e);
        }
      });

    }
    public boolean gui2Record(){
         if(!super.gui2Record())return false;
         if(txtVhNo.getText().trim().length()==0){
           exgui.verification.VerifyLib.showAlert("請輸入傳票號碼","請輸入傳票號碼");
           return false;
         }
         if(txtVhDate.getText().trim().length()!=10){
           exgui.verification.VerifyLib.showAlert("請輸入傳票日期","請輸入傳票日期");
           return false;
         }

         if(txtVhCD.getText().trim().length()==0){
           exgui.verification.VerifyLib.showAlert("請輸入傳票C/D","請輸入傳票C/D");
           return false;
         }
         String cd= txtVhCD.getText().trim();
         if(!("C".equalsIgnoreCase(cd)||"D".equalsIgnoreCase(cd))){
           exgui.verification.VerifyLib.showAlert("請輸入傳票C/D","請輸入傳票C/D");
           return false;
         }

         if(txtVhSeq.getText().trim().length()==0){
           exgui.verification.VerifyLib.showAlert("請輸入傳票序號","請輸入傳票序號");
           return false;
         }


         if(txtVhAccCode.getText().trim().length()==0){
           exgui.verification.VerifyLib.showAlert("請輸入科目代號","請輸入科目代號");
           return false;
         }

         if(cbxType.getSelectedItem()==null||cbxType.getSelectedItem().toString().trim().length()==0){
           exgui.verification.VerifyLib.showAlert("請選擇款項","請選擇款項");
           return false;
         }
         return true;

    }

    public void record2Gui(){
       try{
         dataBoundGUIs.clear();

         Object vftxtVhDate=exgui.verification.CellFormat.getDateStringFormaterAllowNull();;
          dataBoundGUIs.add(  new exgui.DataBindTextWithChecker(txtVhDate,"VH_DATE",recToMapping.get("VH_DATE"),10,(exgui.Object2String)vftxtVhDate,(exgui.ultratable.CellTxtEditorFormat)vftxtVhDate)
         );
         Object vftxtPayDate=exgui.verification.CellFormat.getDateStringFormaterAllowNull();;
          dataBoundGUIs.add(  new exgui.DataBindTextWithChecker(txtPayDate,"PAY_DATE",recToMapping.get("PAY_DATE"),10,(exgui.Object2String)vftxtPayDate,(exgui.ultratable.CellTxtEditorFormat)vftxtPayDate)
         );
         Object vftxtVhNo=exgui.verification.CellFormat.getOrdinaryField(10);
          dataBoundGUIs.add(  new exgui.DataBindTextWithChecker(txtVhNo,"VH_NO",recToMapping.get("VH_NO"),10,(exgui.Object2String)vftxtVhNo,(exgui.ultratable.CellTxtEditorFormat)vftxtVhNo)
         );
         Object vftxtVhAccCode=exgui.verification.CellFormat.getOrdinaryField(20);
          dataBoundGUIs.add(  new exgui.DataBindTextWithChecker(txtVhAccCode,"VH_ACCOUNT",recToMapping.get("VH_ACCOUNT"),20,(exgui.Object2String)vftxtVhAccCode,(exgui.ultratable.CellTxtEditorFormat)vftxtVhAccCode)
         );
         Object vftxtVhSeq=exgui.verification.CellFormat.getIntVerifierAllowNull(3);
          dataBoundGUIs.add(  new exgui.DataBindTextWithChecker(txtVhSeq,"VH_SEQ",recToMapping.get("VH_SEQ"),38,(exgui.Object2String)vftxtVhSeq,(exgui.ultratable.CellTxtEditorFormat)vftxtVhSeq)
         );
         Object vftxtVhCD=exgui.verification.CellFormat.getOrdinaryField(1);
          dataBoundGUIs.add(  new exgui.DataBindTextWithChecker(txtVhCD,"C_D",recToMapping.get("C_D"),1,(exgui.Object2String)vftxtVhCD,(exgui.ultratable.CellTxtEditorFormat)vftxtVhCD)
         );
         Object vftxtBuyer=exgui.verification.CellFormat.getOrdinaryField(100);
          dataBoundGUIs.add(  new exgui.DataBindTextWithChecker(txtBuyer,"BUYER",recToMapping.get("BUYER"),100,(exgui.Object2String)vftxtBuyer,(exgui.ultratable.CellTxtEditorFormat)vftxtBuyer)
         );
         Object vftxtAmt=exgui.verification.CellFormat.getDoubleFormatAllowNull(10,2);
          dataBoundGUIs.add(  new exgui.DataBindTextWithChecker(txtAmt,"AMT",recToMapping.get("AMT"),12,(exgui.Object2String)vftxtAmt,(exgui.ultratable.CellTxtEditorFormat)vftxtAmt)
         );
         Object vftxtMaker=exgui.verification.CellFormat.getOrdinaryField(100);
          dataBoundGUIs.add(  new exgui.DataBindTextWithChecker(txtMaker,"MAKER",recToMapping.get("MAKER"),100,(exgui.Object2String)vftxtMaker,(exgui.ultratable.CellTxtEditorFormat)vftxtMaker)
         );
       if(null==vctType){
         Record recType=(Record)util.MiscFunc.deepCopy(util.PublicVariable.USER_RECORD);
         recType.getFieldName().clear();recType.getValueFields().clear();
         recType.getFieldName().add("TYPE");recType.getValueFields().add(null);
         String[] typeArr=new String[]{"工廠未付","自有資金","墊款","暫收款","DN"};
          vctType=new Vector();
         for(int i=0;i<typeArr.length;i++){
           Record recXType=(Record)util.MiscFunc.deepCopy(recType);
              recXType.set(0,typeArr[i]);
             vctType.add(recXType);
         }

       }
        exgui.DataBindJCombobox dbCbxType=new  exgui.DataBindJCombobox(cbxType,"TYPE",vctType,
                       "TYPE","TYPE",recToMapping.get("TYPE"),"",null
                      );
       dataBoundGUIs.add(dbCbxType);
       }catch(Exception exp){
         exp.printStackTrace();

       }
    }
    public void doPrint(){
    }

  }

  class PnlListRush extends processhandler.template.PnlTableEditor{
    public  PnlListRush(exgui.ultratable.PagedDataFactory pagedDataFxy,
                      int rowCounts,util.InsertionOrderedHashMap columnMapping,
                     java.util.Hashtable object2StringConvertor){
        super(pagedDataFxy, rowCounts, columnMapping, object2StringConvertor);
        super.getPanelContainsButtons().removeAll();
    }
    public void doPrint(){}
    public int getEachPageRowCount(){return _rowCounts;}
    public java.util.Hashtable getObject2StringConvertor() {return klmObjKvtHt;}
    public util.InsertionOrderedHashMap getHeadColumnMap(){return tblHeadColumn;}
    public exgui.ultratable.PagedDataFactory getPagedDataFactory(){return dbHandler;}
    public void refineEditors(exgui.ultratable.MultiEditorJTable mt ){
      CellRenderIfRowSelected cdr=new CellRenderIfRowSelected();
      for(int i=0;i<getJtable().getColumnCount();i++){
        this.getJtable().getColumnModel().getColumn(i).setCellRenderer(cdr);
      }
      mt.setAllColumnUnEdtiable();
    }
    public Record setObject2Record(Record rec,int col,Object obj){
        try{
          String colName=super.storedRecordColumn[col];
          rec.set(colName,obj);
          return rec;
        }catch(Exception exp){
          exp.printStackTrace();
          return null;
        }
    }
  }

  class CellRenderIfRowSelected extends JLabel
     implements javax.swing.table.TableCellRenderer{
     public CellRenderIfRowSelected(){
     super();
    //setBorder(javax.swing.BorderFactory.createRaisedBevelBorder());
    setOpaque(true); /* it\u00B4s essential */
 }
  public Component getTableCellRendererComponent(
        javax.swing.JTable table, Object value,
        boolean isSelected, boolean hasFocus,
        int row, int column){
        String text = (value==null)?"":value.toString();
       if(row==selectedDebitRow && column>0){
           setBackground(new java.awt.Color(0X66,0XFF,0X66)); // Decides the color
       }else{
         setBackground(new java.awt.Color(0xFF, 0xFF, 0xFF)); // Decides the color
         if(isSelected)setBackground(new java.awt.Color(0xFF, 0xE3, 0x8C));
       }
       setText(text);
    return this;
   }
 }
  class HistoryNode{
    Vector vct2Del;
    Vector vct2List;
  }

  class TempDb extends exgui.ultratable.PagedDataFactoryAdapter{
    Vector vctDelete=new Vector();
    Vector orgVector=null;
    public Record addRecord(Record recNew){
      orgVector.add(recNew);
      updateTotal();
      return null;
    }
    public void updateRecords(Vector vct)throws Exception{
      for(int i=0;i<vct.size();i++){
        Record rec=(Record)vct.get(i);
        int delFlag=rec.getInt("record_delete_flag");
        if(0==delFlag){
          vctDelete.add(rec);
          continue;
        }
        //find out target row in table
        boolean foundRecord=false;
        for(int j=0;j<orgVector.size();j++){
          Record rec2InTable=(Record)orgVector.get(j);
          if(rec2InTable.getLong(0)==rec.getLong(0)){
            orgVector.set(j,rec);
            foundRecord=true;
            break;
          }
        }
        if(foundRecord)continue;
        if(-1==delFlag){
          orgVector.add(rec);
          continue;
        }
      }
      updateTotal();
    }
    public java.util.Vector getRecords(int bgn,int rowcount)throws Exception{
      if(orgVector==null){
        orgVector = exgui2.CONST.BASIC_MAIN_EJB.getDatas(
            util.PublicVariable.USER_RECORD, Pnl1102X0I3RxFucList.SQL, 1,
            9999999);
      }
       return orgVector;
    }
    public database.datatype.Record getBlankRecord(){
      try{
        Record recNew=exgui2.CONST.BASIC_MAIN_EJB.getBlankRecord("VH_1102X0I3_RUSH_tbl");
        recNew.set("record_delete_flag","-1");
        recNew.set("record_create_date",util.PublicVariable.USER_RECORD.get(0));
        recNew.set(0,-1 * System.currentTimeMillis());
        return recNew;
      }catch(Exception exp){
        return null;
      }
    }
  }

  void btnExit_actionPerformed(ActionEvent e) {
    try{
      //test if have modified.
      boolean isModified=false;
       for(int i=0;i<db2Handle.orgVector.size();i++){
         Record rec=(Record)db2Handle.orgVector.get(i);
         if(rec.getModifiedFields().size()>0){
           isModified=true;
           break;
         }
       }
       if(isModified || db2Handle.vctDelete.size()>0){
         if(!exgui.verification.VerifyLib.showConfirm("內容更動但尚未儲存,你確認要離開嗎?",
                                                      "Context Modifie,but not saved yet",false)){
           return;
         }
       }
       processhandler.template.Properties.getCenteralControler().goBack();
    }catch(Exception exp){
      exp.printStackTrace();
     }

  }

  void btnUpdateTable_actionPerformed(ActionEvent e) {
    //findo out if any record to update.
    try{
      Vector vct2Update=new Vector();
      for(int i=0;i<db2Handle.orgVector.size();i++){
        Record  rec=(Record)db2Handle.orgVector.get(i);
        if(rec.getModifiedFields().size()!=0){
              vct2Update.add(util.MiscFunc.deepCopy(rec));
        }
      }
      if(vct2Update.size()==0 &&  db2Handle.vctDelete.size()==0){
        exgui.verification.VerifyLib.showPlanMsg("No Data To Update","No Data To Update");
        return;
      }
      util.MiscFunc.showProcessingMessage();
      newtimesejb.Vh1102x0I3Rush.Vh1102x0I3RushFacadeHome ejbHome =
          (newtimesejb.Vh1102x0I3Rush.Vh1102x0I3RushFacadeHome)
          info_ejb.WeblogicServiceLocator.locateServiceHome(
          util.PublicVariable.SERVER_URL,
          "newtimesejb.Vh1102x0I3Rush.Vh1102x0I3RushFacade");
      newtimesejb.Vh1102x0I3Rush.Vh1102x0I3RushFacade ejb = ejbHome.create();
      ejb.updateRecords(vct2Update,db2Handle.vctDelete,util.PublicVariable.USER_RECORD.get(0).toString());
      //after update,clear unto stack
      stkUndoList.clear();
      db2Handle.orgVector=null;//force to load from database
      db2Handle.vctDelete=new Vector();
      pnlListRush.reload();
      exgui.verification.VerifyLib.showAlert("儲存完成","Update OK");

    }catch(Exception exp){
      exp.printStackTrace();
      util.ExceptionLog.exp2File(exp,"");
      exgui.verification.VerifyLib.showAlert("儲存失敗,請況系統管理員","Update Fail!!");
    }
  }

  void btnUndo_actionPerformed(ActionEvent e) {
    if(stkUndoList.empty()){
      exgui.verification.VerifyLib.showAlert("No Backup Status","No Backup Status");
      return;
    }
    HistoryNode node=(HistoryNode)stkUndoList.pop();
    if(node!=null){
      db2Handle.vctDelete=node.vct2Del;
      db2Handle.orgVector=node.vct2List;
      pnlListRush.reload();
      exgui.verification.VerifyLib.showAlert("Status Restored","Status Restored");
    }
  }

  void btnDelete_actionPerformed(ActionEvent e) {
    int rows[]=pnlListRush.getJtable().getSelectedRows();
   if(rows.length==0){
     exgui.verification.VerifyLib.showPlanMsg("Please Select Row(s) To Delete",
                                              "Please Select Row(s) To Delete");
   }
   try{
     Vector vct2Remove=new Vector();
     for(int i=0;i<rows.length;i++){
       //Record rec=(Record)pnlListRush.getDisplayingRecords().get(rows[i]);
       if(rows[i]==selectedDebitRow)selectedDebitRow=-1;//clear the selected decuct row .
       Record rec=(Record)pnlListRush.getDisplayingRecords().remove(rows[i]);
       rec.set("record_delete_flag",0);
       vct2Remove.add(rec);
       db2Handle.updateRecords(vct2Remove);
       pnlListRush.reload();
     }
   }catch(Exception exp){


   }
  }

  void btnCancelEditSingleRow_actionPerformed(ActionEvent e) {
    pnlAddNew.setPagedDataFactory(db2Handle);
    pnlAddNew.setRecord(db2Handle.getBlankRecord());
    pnlAddNew.record2Gui();
    btnAddNewSingleRow.setText("Add New");
  }

  void btnAddNewSingleRow_actionPerformed(ActionEvent e) {
    if(!pnlAddNew.gui2Record()) return;
    try{
      pnlAddNew.doUpdate();
      pnlListRush.reload();
    }catch(Exception exp){
      exp.printStackTrace();
    }
  }
}
