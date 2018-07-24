package newtimes.general_voucher.rush;

import java.awt.*;
import exgui.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;
import database.datatype.*;
/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class PnlEditRush extends JPanel {
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel1 = new BlueBkgWhiteCharLabel();
  Panel2List pnlList = null;
  //JPanel pnlList = null;
  JButton btnUpdate = new JButton();
  JButton btnExit = new JButton();
  HashMap hmAccAndName=null;
 static int ACC_CODE_COLUMN_AT=-1;
  JPanel pnl2Add = new JPanel();
  JLabel jLabel1 = new JLabel();
  JTextField txtVhFrom = new JTextField();
  JButton btnGetVhDtl = new JButton();
  TmpDb db2proce=new TmpDb();

  public PnlEditRush() {
    try {
      jbInit();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }
  void getListPanel()throws Exception{
    StringBuffer sb=new StringBuffer();
    sb.append(" select ACC_CODE,REC_DESC ");
    sb.append(" from GV_ACC_DATA  ");
    sb.append(" where  ");
    sb.append(" substr(ACC_CODE,1,4) in (select ACC_CODE  from VH_RX_ACC_ITEM ) ");
    sb.append(" and substr(acc_code,5,1)='");sb.append(Constants.pnlQry.dbCbxCompany.getSelectedValue());sb.append("'");
    sb.append(" and yyyymm='999999' ");
    sb.append(" order by acc_code ");
     Vector vctAccCode=exgui2.CONST.BASIC_MAIN_EJB.getDatas(
      util.PublicVariable.USER_RECORD,
      sb.toString(),1,99999);
     if(vctAccCode.size()>0)hmAccAndName=new HashMap();
     for(int i=0;i<vctAccCode.size();i++){
       Record rec=(Record)vctAccCode.get(i);
       hmAccAndName.put(rec.get(0),rec.get(1));
     }
  //   System.out.println(sb);
     util.InsertionOrderedHashMap iso=new util.InsertionOrderedHashMap();
     iso.put("VH# ","VH_NO");
     iso.put("SEQ","VH_SEQ");
     iso.put(" ACC# ","VH_ACCOUNT");
     ACC_CODE_COLUMN_AT=iso.entrySet().size()-1;
     iso.put("會計科目","acc_tw_name");
     iso.put("DATE","VH_DATE");
     iso.put("YYYYMM","RUSH_YYYYMM");
     iso.put("D/C","VH_DC");
     iso.put("AMT","BAL_AMT");
     iso.put("    DESCRIPTION    ","VH_DESCRIPTION");
     Hashtable ht=new Hashtable();
     ht.put(" ACC# ",new AccCodeVfy());
     ht.put("DATE",exgui.verification.CellFormat.getDateStringFormater());
     ht.put("YYYYMM",exgui.verification.CellFormat.getIntVerifier(6));
     ht.put("D/C",new DCcodeVfy());
     ht.put("AMT",exgui.verification.CellFormat.getDoubleFormatAllowNull(12,2));
     ht.put("    DESCRIPTION    ",exgui.verification.CellFormat.getOrdinaryField(500));
     pnlList=new Panel2List(db2proce,999999,iso,ht);

  }
  void jbInit() throws Exception {
    StringBuffer sb=new StringBuffer();
    sb.append("Edit Rush,Company Code:");
    sb.append(Constants.pnlQry.dbCbxCompany.getSelectedValue());
    sb.append(" ,Clear ACC# TO Delete That Row");
    blueBkgWhiteCharLabel1.setText(sb.toString());

    blueBkgWhiteCharLabel1.setBounds(new Rectangle(-3, 17, 805, 29));
    this.setBackground(new Color(202, 202, 224));
    this.setLayout(null);
    getListPanel();
    pnlList.setBounds(new Rectangle(14, 50, 750, 462));
    btnUpdate.setBounds(new Rectangle(499, 542, 139, 27));
    btnUpdate.setFont(new java.awt.Font("Dialog", 1, 11));
    btnUpdate.setText("Confirm Update");
    btnUpdate.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnUpdate_actionPerformed(e);
      }
    });
    btnExit.setText("EXIT");
    btnExit.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnExit_actionPerformed(e);
      }
    });
    btnExit.setFont(new java.awt.Font("Dialog", 1, 11));
    btnExit.setForeground(Color.red);
    btnExit.setBounds(new Rectangle(648, 542, 102, 27));
    pnl2Add.setBorder(BorderFactory.createLoweredBevelBorder());
    pnl2Add.setBounds(new Rectangle(22, 536, 468, 39));
    pnl2Add.setLayout(null);
    jLabel1.setFont(new java.awt.Font("Dialog", 1, 14));
    jLabel1.setText("ADD FROM VH#:");
    jLabel1.setBounds(new Rectangle(5, 4, 122, 29));
    txtVhFrom.setText("");
    txtVhFrom.setBounds(new Rectangle(129, 7, 141, 24));
    btnGetVhDtl.setBounds(new Rectangle(272, 10, 110, 24));
    btnGetVhDtl.setFont(new java.awt.Font("Dialog", 1, 12));
    btnGetVhDtl.setText("Query");
    btnGetVhDtl.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnGetVhDtl_actionPerformed(e);
      }
    });
    this.add(blueBkgWhiteCharLabel1, null);


    this.add(pnlList, null);
    this.add(btnExit, null);
    this.add(btnUpdate, null);
    this.add(pnl2Add, null);
    pnl2Add.add(jLabel1, null);
    pnl2Add.add(txtVhFrom, null);
    pnl2Add.add(btnGetVhDtl, null);
    pnlList.firstPage();
  }
  boolean isAccNoReady(){
    //check if yyyymm is blank
    for (int i = 0; i < pnlList.getJtable().getRowCount(); i++) {
      String accNo=(String)pnlList.getJtable().getValueAt(i,2);
      Object yyyymm=pnlList.getJtable().getValueAt(i,5);
      Object date=pnlList.getJtable().getValueAt(i,4);
      if(accNo!=null){
        if(yyyymm==null||yyyymm.toString().trim().length()==0){
          exgui.verification.VerifyLib.showAlert("Please Input YYYYMM","Please Input YYYYMM");
          return false;
        }
        if(date==null||date.toString().trim().length()==0){
          exgui.verification.VerifyLib.showAlert("Please Input Date","Please Input Date");
          return false;
        }

      }
    }
    return true;
  }

  void btnExit_actionPerformed(ActionEvent e) {
    try{
      if(pnlList.isContextModified()){
        if(!exgui.verification.VerifyLib.showConfirm("Context Modified,\nAre You Sure To Exit?","Context Modified",false)){
          return;
        }
      }
      processhandler.template.Properties.getCenteralControler().goBack();
    }catch(Exception exp){
      exp.printStackTrace();
    }
  }
  class TmpDb extends exgui.ultratable.PagedDataFactoryAdapter{
    Record myblankRecord =null;
    public Record getBlankRecord()throws Exception{
      if(myblankRecord==null){
        myblankRecord=exgui2.CONST.BASIC_MAIN_EJB.getBlankRecord("VH_DETAIL_RUSH_tbl");
        myblankRecord.getFieldName().add("VH_SEQ");
        myblankRecord.getValueFields().add(null);
        myblankRecord.getFieldName().add("ACC_TW_NAME");
        myblankRecord.getValueFields().add(null);
        myblankRecord.set("record_delete_flag","-1");
        myblankRecord.set("record_create_user",util.PublicVariable.USER_RECORD.get(0));
      }
      return (Record)util.MiscFunc.deepCopy(myblankRecord);
    }

    public void updateRecords(Vector vct)throws Exception{
      util.MiscFunc.showProcessingMessage();
      newtimesejb.dailyVoucher.RushFacadeHome rushEjbHome=
          (newtimesejb.dailyVoucher.RushFacadeHome)
          info_ejb.WeblogicServiceLocator.locateServiceHome(util.PublicVariable.SERVER_URL,
          "newtimesejb.dailyVoucher.RushFacade");
      newtimesejb.dailyVoucher.RushFacade ejb=rushEjbHome.create();
      ejb.updateRush(vct,util.PublicVariable.USER_RECORD.get(0).toString());
      //pnlList.reload();
      util.MiscFunc.hideProcessingMessage();
    }
    public Vector getRecords(int bgn,int rowcount)throws Exception{
      return Constants.pnlQry.getRecord(bgn,rowcount);
    }
  }
  class CellRender4Seq extends JLabel
     implements javax.swing.table.TableCellRenderer{
     public CellRender4Seq(){
     super();
    //setBorder(javax.swing.BorderFactory.createRaisedBevelBorder());
    setOpaque(true); /* it\u00B4s essential */
    setHorizontalAlignment(super.RIGHT);
 }
  public Component getTableCellRendererComponent(
        javax.swing.JTable table, Object value,
        boolean isSelected, boolean hasFocus,
        int row, int column){

        String text = (value==null)?"0":value.toString();
        if(value.toString().length()==1)text="0"+text;

       setBackground(new java.awt.Color(0xFF, 0xFF, 0xFF)); // Decides the color
       if(isSelected)setBackground(new java.awt.Color(0xFF, 0xE3, 0x8C));
       setText(text);
    return this;
   }
 }


  class Panel2List extends processhandler.template.PnlTableEditor {
    public Panel2List(exgui.ultratable.PagedDataFactory pagedDataFxy,
                      int rowCounts,util.InsertionOrderedHashMap columnMapping,
                     java.util.Hashtable object2StringConvertor){
        super(pagedDataFxy, rowCounts, columnMapping, object2StringConvertor);
        jbtnPrev.setVisible(false);
        jbtnNext.setVisible(false);
        jbtnLast.setVisible(false);
        jbtn1st.setVisible(false);
    }
    public void makeTable(Vector vct){
      super.makeTable(vct);
      getJtable().getColumnModel().getColumn(0).setPreferredWidth(75);
      getJtable().getColumnModel().getColumn(1).setPreferredWidth(34);
      getJtable().getColumnModel().getColumn(2).setPreferredWidth(75);
      getJtable().getColumnModel().getColumn(3).setPreferredWidth(160);
      getJtable().getColumnModel().getColumn(4).setPreferredWidth(85);
      getJtable().getColumnModel().getColumn(5).setPreferredWidth(63);
      getJtable().getColumnModel().getColumn(6).setPreferredWidth(28);
      getJtable().getColumnModel().getColumn(7).setPreferredWidth(80);
      getJtable().getColumnModel().getColumn(8).setPreferredWidth(300);
      getJtable().setRowHeight(20);
      getJtable().setFont(new java.awt.Font("Dialog",java.awt.Font.PLAIN, 14));
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
      CellRender4Seq cellRdn=new CellRender4Seq();
      getJtable().getColumnModel().getColumn(1).setCellRenderer(cellRdn);
    }
  }

  public class DCcodeVfy implements exgui.ultratable.CellTxtEditorFormat,exgui.Object2String{
    Object orgFvyObj=null;
    public DCcodeVfy(){
      orgFvyObj=exgui.verification.CellFormat.getOrdinaryField(1);
    }
    public int getMaxLength(){
      return ((exgui.ultratable.CellTxtEditorFormat)orgFvyObj).getMaxLength();
    }

    public exgui.ultratable.KeyProcess getKeyListener(){
      return ((exgui.ultratable.CellTxtEditorFormat)orgFvyObj).getKeyListener();
    }

    public String formatPromptMsg(){
       //return  (exgui.ultratable.CellTxtEditorFormat)orgFvyObj).formatPromptMsg();
       return  "Should be \"D\" or \"C\" ";
    }
    public boolean isFormatValid(String inStr,int row,int column){
      if(inStr==null)return false;
      if("D".equals(inStr)||"C".equals(inStr))return true;
      return false;
    }
    public String Obj2String(Object obj2kvt){
      return ((exgui.Object2String)orgFvyObj).Obj2String(obj2kvt);
    }
     public Object cellStringToObject(String String2kvt){
       return ((exgui.ultratable.CellTxtEditorFormat)orgFvyObj).cellStringToObject(String2kvt);
     }

   }


  public class AccCodeVfy implements exgui.ultratable.CellTxtEditorFormat,exgui.Object2String{
    Object orgFvyObj=null;
    public AccCodeVfy(){
      orgFvyObj=exgui.verification.CellFormat.getOrdinaryField(20);
    }
    public int getMaxLength(){
      return ((exgui.ultratable.CellTxtEditorFormat)orgFvyObj).getMaxLength();
    }

    public exgui.ultratable.KeyProcess getKeyListener(){
      return ((exgui.ultratable.CellTxtEditorFormat)orgFvyObj).getKeyListener();
    }

    public String formatPromptMsg(){
       //return  (exgui.ultratable.CellTxtEditorFormat)orgFvyObj).formatPromptMsg();
       return  "ACC Code Not Found";
    }
    public boolean isFormatValid(String inStr,int row,int column){

      if(column==ACC_CODE_COLUMN_AT){
        String newAccCoder=inStr;
        if(newAccCoder==null)newAccCoder="";
      }
      if(null==inStr||"".equals(inStr.trim())){
        pnlList.getJtable().setValueAt("",row,2);
        pnlList.getJtable().setValueAt("",row,3);
        return true;
      }
          //(HashMap)newtimes.general_voucher.daily_voucher.Constants.hmCompanyAndAccCodeTwName.get("xxx");

      if(null==hmAccAndName){
        pnlList.getJtable().setValueAt("此公司尚無設定會計科目",row,3);
        return false;
      }
      String accZhTwName=(String)hmAccAndName.get(inStr);
      if(accZhTwName==null){
        pnlList.getJtable().setValueAt(newtimes.general_voucher.daily_voucher.Constants.NO_SUCH_ACCOUNT_CODE,
                               row,3);
        return false;
      }else{
        pnlList.getJtable().setValueAt(inStr,row,2);
        pnlList.getJtable().setValueAt(accZhTwName,row,3);
        pnlList.getJtable().repaint();
        pnlList.getJtable().validate();
        return true;
      }
    }
    public String Obj2String(Object obj2kvt){
      return ((exgui.Object2String)orgFvyObj).Obj2String(obj2kvt);
    }
     public Object cellStringToObject(String String2kvt){
       return ((exgui.ultratable.CellTxtEditorFormat)orgFvyObj).cellStringToObject(String2kvt);
     }

   }

  void btnUpdate_actionPerformed(ActionEvent e) {
    try{
      if(!isAccNoReady())return;
      //change selection to other column,incase clear the acc code
      pnlList.getJtable().changeSelection(pnlList.getJtable().getSelectedRow(),0,false,false);
      pnlList.doUpdate();
      pnlList.firstPage();


    }catch(Exception exp){
      exp.printStackTrace();
      util.ExceptionLog.exp2File(exp,"");
      exgui.verification.VerifyLib.showAlert("Update Failed!!\nPlease Contact System Manager",
                                             "Update Failed");
    }
  }

  void btnGetVhDtl_actionPerformed(ActionEvent e) {
    //heck if have detail of that VH#
    if(!isAccNoReady())return;
    if(txtVhFrom.getText().trim().length()<8){
      exgui.verification.VerifyLib.showAlert("Incorrect VH# Format","Incorrect VH# Format");
      return ;
    }
    try{
      pnlList.doUpdate();
      StringBuffer sb=new StringBuffer();
      sb.append("select a.* ");
      sb.append(",trim(a.VH_INVOICE||' '||a.VH_DESCRIPTION) as  INV_DESC ");
      sb.append(",(select C.rec_desc from  GV_ACC_DATA c where C.acc_CODE=a.vh_account and  yyyymm='999999') as acc_tw_name ");
      sb.append(" from vh_detail a ");
      sb.append(" where a.vh_no='");
      sb.append(txtVhFrom.getText().trim());
      sb.append("' order by a.vh_seq ");
      System.out.print(sb);
      Vector vct =exgui2.CONST.BASIC_MAIN_EJB.getDatas(
      util.PublicVariable.USER_RECORD,
      sb.toString(),1,9999999);
      if(vct.size()==0){
        exgui.verification.VerifyLib.showAlert("No Such VH#","No Such VH#");
        return;
      }
      DlgSlkVhDtl2Add dlg=new
          DlgSlkVhDtl2Add(util.PublicVariable.APP_FRAME,"Select To Add To Rush",true,vct);
      dlg.setSize(700,445);
      exgui.UIHelper.setToScreenCenter(dlg);
      dlg.show();
      if(dlg.vct2add==null){
        return;
      }
      insertIntoRushFromVhDtl(dlg.vct2add);
    }catch(Exception exp){
      exp.printStackTrace();
      util.ExceptionLog.exp2File(exp,"");
    }finally{
      pnlList.reload();
      util.MiscFunc.hideProcessingMessage();
    }
  }
  void insertIntoRushFromVhDtl(Vector vctVhDtl)throws Exception{
    //System.out.println("vector to add ......");
    Vector _vct2add=vctVhDtl;
    Vector vct2add=new Vector();
    for(int i=0;i<_vct2add.size();i++){
      Record rec=(Record)_vct2add.get(i);
      Record rec2add=db2proce.getBlankRecord();
      rec2add.set(1, rec.get(0)); //glb_seq
      rec2add.set(2, rec.get(1)); //vh_no
      rec2add.set(3, "999999");        //rush_yyyymm
      rec2add.set(4, rec.get(3)); //vh_date
      rec2add.set(5, rec.get(4)); //vh_account
      rec2add.set(6, rec.get(5)); //C/D
      String invNo=(String)rec.get(13);
      String desc=(String)rec.get(7);
      if(invNo!=null && invNo.trim().length()>0){
        rec2add.set(7, invNo+" "+desc); //description
      }else{
        rec2add.set(7,desc); //description
      }
      rec2add.set(8, rec.get(6)); //balance
      vct2add.add(rec2add);
    }
    util.MiscFunc.showProcessingMessage();
    newtimesejb.dailyVoucher.RushFacadeHome rushEjbHome=
        (newtimesejb.dailyVoucher.RushFacadeHome)
        info_ejb.WeblogicServiceLocator.locateServiceHome(util.PublicVariable.SERVER_URL,
        "newtimesejb.dailyVoucher.RushFacade");
    newtimesejb.dailyVoucher.RushFacade ejb=rushEjbHome.create();
     ejb.updateRush(vct2add,util.PublicVariable.USER_RECORD.get(0).toString());


  }

}
