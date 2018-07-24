package newtimes.accounting.debit_note;

import java.awt.*;
import exgui.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;
import database.datatype.Record;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class PnlListQryPayDtl extends JPanel {
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel1 = new BlueBkgWhiteCharLabel();
  JButton btnExit = new JButton();
  static java.util.HashMap HASHMAP_PAYDTL_CHECKLIST=new java.util.HashMap();
  Panel2List pnl2list = null;
  JButton btnPrint = new JButton();
  DbDebitNotePayDtl dbHanlderPayDtl;
  JButton btnSelectAll = new JButton();
  JButton btnSelectCurrentPage = new JButton();

  public PnlListQryPayDtl() {
    try {
      jbInit();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }

  void jbInit() throws Exception {
    blueBkgWhiteCharLabel1.setFont(new java.awt.Font("Dialog", 1, 16));
    blueBkgWhiteCharLabel1.setText("     細項查詢明細列,點選任一列進行編輯    ");
    blueBkgWhiteCharLabel1.setBounds(new Rectangle(-1, 32, 802, 32));
    this.setLayout(null);
    btnExit.setBounds(new Rectangle(673, 534+3, 82, 34));
    btnExit.setFont(new java.awt.Font("Dialog", 1, 11));
    btnExit.setText("EXIT");
    btnExit.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnExit_actionPerformed(e);
      }
    });
    util.InsertionOrderedHashMap iso=new util.InsertionOrderedHashMap();
    iso.put("x","is2Print");
    iso.put("       D/N      ","DBNT_NO");
    iso.put(" MERCH ","DBNT_PAYDTL_MERCH_name");//"DBNT_PAYDTL_MERCHID");
    iso.put(" M-REF ","DBNT_PAYDTL_MERCHREF");
    iso.put("    FTY    ","DBNT_PAYDTL_FTY");
    iso.put("  F-INV    ","DBNT_PAYDTL_FTY_INV");
    iso.put("  VH-NO  ","DBNT_PAYDTL_CV");
    iso.put("CUR","DBNT_PAYDTL_CURRENCY");
    iso.put("FULL   \nAMT ","DBNT_PAYDTL_FULLAMT");//PayStatus
    iso.put("BALANCE\nAMT","PayStatus");

    pnl2list=new Panel2List( new DbTempQryPayDtl(),
                             15,iso,new java.util.Hashtable());

    pnl2list.setBounds(new Rectangle(7, 70, 789, 465));
    btnPrint.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnPrint_actionPerformed(e);
      }
    });
    btnPrint.setText("Print Selected");
    btnPrint.setFont(new java.awt.Font("Dialog", 1, 11));
    btnPrint.setBounds(new Rectangle(334, 537, 131, 34));
    btnSelectAll.setBounds(new Rectangle(211, 534+3, 110, 34));
    btnSelectAll.setFont(new java.awt.Font("Dialog", 1, 11));
    btnSelectAll.setText("Print All");
    btnSelectAll.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnSelectAll_actionPerformed(e);
      }
    });
    btnSelectCurrentPage.setBounds(new Rectangle(478, 537, 183, 34));
    btnSelectCurrentPage.setFont(new java.awt.Font("Dialog", 1, 11));
    btnSelectCurrentPage.setHorizontalTextPosition(SwingConstants.TRAILING);
    btnSelectCurrentPage.setText("Select All Of Current Page");
    btnSelectCurrentPage.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnSelectCurrentPage_actionPerformed(e);
      }
    });
    this.add(blueBkgWhiteCharLabel1, null);
    this.add(btnExit, null);
    this.add(btnSelectAll, null);
    this.add(btnSelectCurrentPage, null);
    this.add(btnPrint, null);

    this.add(pnl2list, null);
    pnl2list.reload();
    pnl2list.getJtable().addMouseListener(new TblListener());
  }

  void btnExit_actionPerformed(ActionEvent e) {
    try{
      processhandler.template.Properties.getCenteralControler().goBack();
    }catch(Exception exp){
      exp.printStackTrace();
    }
  }
  class Panel2List extends processhandler.template.PnlTableEditor{
    public Panel2List(exgui.ultratable.PagedDataFactory pagedDataFxy,
                      int rowCounts,util.InsertionOrderedHashMap columnMapping,
                     java.util.Hashtable object2StringConvertor){
        super(pagedDataFxy, rowCounts, columnMapping, object2StringConvertor);
    }
    public void doPrint(){}
    public int getEachPageRowCount(){return _rowCounts;}
    public Hashtable getObject2StringConvertor() {return klmObjKvtHt;}
    public util.InsertionOrderedHashMap getHeadColumnMap(){return tblHeadColumn;}
    public void makeTable(Vector vct){
      super.makeTable(vct);
      //adject column size;
      getJtable().getColumnModel().getColumn(0).setPreferredWidth(5);
      getJtable().setRowHeight(25);
    }
    public exgui.ultratable.PagedDataFactory getPagedDataFactory(){return dbHandler;}
    public void doUpdateCurrentPage(){
      for(int i=0;i<getDisplayingRecords().size();i++){
        Record rec=(Record)getDisplayingRecords().get(i);
        Record recx=setObject2Record(rec,0,getJtable().getValueAt(i,0));
      }
    }
    public Record setObject2Record(Record rec,int col,Object obj){
         if(col==0){
           Boolean blValue=(Boolean)obj;
           String payDtlSeq=rec.get(0).toString();
           if(blValue.booleanValue()){
             HASHMAP_PAYDTL_CHECKLIST.put(payDtlSeq,"1");
           }else{
             HASHMAP_PAYDTL_CHECKLIST.remove(payDtlSeq);
           }
         }
         return null;
    }
    public void refineEditors(exgui.ultratable.MultiEditorJTable me ){
      me.addCheckbox(0,"1");
    }
  }
  class DbTempQryPayDtl extends exgui.ultratable.PagedDataFactoryAdapter {
    String orgSql=null;
    java.text.NumberFormat nf=new java.text.DecimalFormat("####,###,###.00");
    public Vector getRecords(int bgn,int rowcount)throws Exception{
      Vector vct=null;
      if(orgSql==null){
        StringBuffer sb = new StringBuffer();
        sb.append("select b.*,'' as is2Print,'' as PayStatus, ");
        sb.append("b.DBNT_PAYDTL_MERCHID,");
        sb.append("(select c.usr_name from debitnote_user c where c.usr_code=b.DBNT_PAYDTL_MERCHID) as DBNT_PAYDTL_MERCH_name ");
        sb.append("from debitnote_head a,debitnote_pay_detail b where a.dbnt_no=b.dbnt_no ");
        sb.append(" and a.cen_code='");
        sb.append(util.MiscFunc.Replace(util.PublicVariable.OPERATTING_CENTER,"'","''"));
        sb.append("' ");
        if (newtimes.accounting.debit_note.Constans.DRCR_QRY_HEAD_CONDITION.get(
            PnlQryDebitNotePayDtl.PAYDTL_QTY_CONDITION_TEMP_DBCRNO) != null) {
          String tmpDbCrNo = (String)
              newtimes.accounting.debit_note.Constans.DRCR_QRY_HEAD_CONDITION.
              get(PnlQryDebitNotePayDtl.PAYDTL_QTY_CONDITION_TEMP_DBCRNO);
          sb.append(" and length(a.dbnt_no)=14");
          sb.append(" and a.dbnt_no like '%");
          sb.append(tmpDbCrNo);
          sb.append("'");
          newtimes.accounting.debit_note.Constans.DRCR_QRY_HEAD_CONDITION.
              remove(PnlQryDebitNotePayDtl.PAYDTL_QTY_CONDITION_TEMP_DBCRNO);
        }

        if (newtimes.accounting.debit_note.Constans.DRCR_QRY_HEAD_CONDITION.get(
            PnlQryDebitNotePayDtl.PAYDTL_QTY_CONDITION_BGN_DBCRNO) != null) {
          String bgnDbCrNo = (String)
              newtimes.accounting.debit_note.Constans.DRCR_QRY_HEAD_CONDITION.
              get(PnlQryDebitNotePayDtl.PAYDTL_QTY_CONDITION_BGN_DBCRNO);
                    //for TPE center, DBNO have no center prefix tailed
          if("001".equals(util.PublicVariable.OPERATTING_CENTER)){
            sb.append(" and length(a.dbnt_no)=10");
          }else{
            sb.append(" and length(a.dbnt_no)=12");
          }

          sb.append(" and a.dbnt_no like '");
          sb.append(bgnDbCrNo);
          sb.append("%'");
          newtimes.accounting.debit_note.Constans.DRCR_QRY_HEAD_CONDITION.
              remove(PnlQryDebitNotePayDtl.PAYDTL_QTY_CONDITION_BGN_DBCRNO);
        }

        if (newtimes.accounting.debit_note.Constans.DRCR_QRY_HEAD_CONDITION.get(
            PnlQryDebitNote.CONDITION_DATE_FROM) != null) {
          String dataFrom = (String)newtimes.accounting.debit_note.Constans.
              DRCR_QRY_HEAD_CONDITION.get(PnlQryDebitNote.CONDITION_DATE_FROM);
          sb.append(" and length(a.dbnt_no)<>14 and '20'||substr(a.dbnt_no,3,4)||'01'>='");
          sb.append(dataFrom);
          sb.append("01");
          sb.append("' ");
          newtimes.accounting.debit_note.Constans.DRCR_QRY_HEAD_CONDITION.
              remove(PnlQryDebitNote.CONDITION_DATE_FROM);
        }

        if (newtimes.accounting.debit_note.Constans.DRCR_QRY_HEAD_CONDITION.get(
            PnlQryDebitNote.CONDITION_DATE_TO) != null) {
          String dataTO = (String)newtimes.accounting.debit_note.Constans.
              DRCR_QRY_HEAD_CONDITION.get(PnlQryDebitNote.CONDITION_DATE_TO);
          sb.append(" and length(a.dbnt_no)<>14 and '20'||substr(a.dbnt_no,3,4)||'01'<='");
          sb.append(dataTO);
          sb.append("01");
          sb.append("' ");
          newtimes.accounting.debit_note.Constans.DRCR_QRY_HEAD_CONDITION.
              remove(PnlQryDebitNote.CONDITION_DATE_TO);
        }
        if (newtimes.accounting.debit_note.Constans.DRCR_QRY_HEAD_CONDITION.get(
            PnlQryDebitNote.CONDITION_DEPT) != null) {
          sb.append(" and substr(a.dbnt_no,1,2)='");
          String depBrief =
              (String)newtimes.accounting.debit_note.Constans.
              DRCR_QRY_HEAD_CONDITION.get(PnlQryDebitNote.CONDITION_DEPT);
          sb.append(depBrief);
          sb.append("' ");
          newtimes.accounting.debit_note.Constans.DRCR_QRY_HEAD_CONDITION.
              remove(PnlQryDebitNote.CONDITION_DEPT);
        }
        if (newtimes.accounting.debit_note.Constans.DRCR_QRY_HEAD_CONDITION.get(
            PnlQryDebitNote.CONDITION_BUYER_MAKER) != null) {
          String buymaker_seq =
              (String)newtimes.accounting.debit_note.Constans.
              DRCR_QRY_HEAD_CONDITION.get(PnlQryDebitNote.CONDITION_BUYER_MAKER);
          sb.append(" and a.DBNT_BYMKR_SEQ=");
          sb.append(buymaker_seq);
          newtimes.accounting.debit_note.Constans.DRCR_QRY_HEAD_CONDITION.
              remove(PnlQryDebitNote.CONDITION_BUYER_MAKER);
        }
        //and substr(a.dbnt_no,7,1)='D' type
        if (newtimes.accounting.debit_note.Constans.DRCR_QRY_HEAD_CONDITION.get(
            PnlQryDebitNote.CONDITION_TYPE) != null) {
          String typeChar =
              (String)newtimes.accounting.debit_note.Constans.
              DRCR_QRY_HEAD_CONDITION.get(PnlQryDebitNote.CONDITION_TYPE);
          sb.append(" and substr(a.dbnt_no,7,1)='");
          sb.append(typeChar);
          sb.append("' ");
          newtimes.accounting.debit_note.Constans.DRCR_QRY_HEAD_CONDITION.
              remove(PnlQryDebitNote.CONDITION_TYPE);
        }
        //other conditions is for pay detail,just enumerate them

        java.util.Iterator itr = newtimes.accounting.debit_note.Constans.
            DRCR_QRY_HEAD_CONDITION.keySet().iterator();
        while (itr.hasNext()) {
          String key = (String)itr.next();
          Object value = newtimes.accounting.debit_note.Constans.
              DRCR_QRY_HEAD_CONDITION.get(key);
          //System.out.println(" key is "+key);
          //System.out.println(" value is "+value);

          if (value != null) {
            if (key.equals("DBNT_PAYDTL_MERCHID")) {
              sb.append(" and b.DBNT_PAYDTL_MERCHID like '");
              sb.append(util.MiscFunc.Replace((String)value,"'","''"));
              sb.append("' ");
            } else {

              sb.append(" and b.");
              sb.append(key);
              sb.append(" like '%");
              sb.append(util.MiscFunc.Replace(value.toString(), "'", "''"));
              sb.append("%' ");
            }
          }
        }
        sb.append(" order by a.dbnt_no");
        orgSql=sb.toString();
      }

//      System.out.println(orgSql);
      util.MiscFunc.showProcessingMessage();
        vct= exgui2.CONST.BASIC_MAIN_EJB.getDatas(
           util.PublicVariable.USER_RECORD,
           orgSql,
           bgn, rowcount);

      util.MiscFunc.hideProcessingMessage();
      for(int i=0;i<vct.size();i++){
        Record rec=(Record)vct.get(i);
        String payDtlSeq=rec.get(0).toString();
        if(HASHMAP_PAYDTL_CHECKLIST.containsKey(payDtlSeq)){
          rec.set("is2Print","1");
        }else{
          rec.set("is2Print","0");
        }
        Object full_1=rec.get("DBNT_PAYDTL_OFFAMT1");
        Object full_2=rec.get("DBNT_PAYDTL_OFFAMT2");
        Object full_amt=rec.get("DBNT_PAYDTL_FULLAMT");

        double dblFull_1=(full_1==null)?0:Double.parseDouble(full_1.toString());
        double dblFull_2=(full_2==null)?0:Double.parseDouble(full_2.toString());
        double blance=((full_amt==null)?0:Double.parseDouble(full_amt.toString()))- dblFull_1-dblFull_2;
        //System.out.println("full amt is "+full_amt);
        rec.set("DBNT_PAYDTL_FULLAMT",nf.format((full_amt==null)?0:Double.parseDouble(full_amt.toString())));
        if(blance==0){
          rec.set("PayStatus","PAID");
        }else{
          rec.set("PayStatus",nf.format(blance));
        }

        vct.set(i,rec);
      }
       return vct;

    }
  }
  class TblListener extends java.awt.event.MouseAdapter{
    public void mouseClicked(java.awt.event.MouseEvent me){
      try{
        if(pnl2list.getJtable().getSelectedColumn()==0)return;
        if(((Boolean)pnl2list.getJtable().getValueAt(pnl2list.getJtable().getSelectedRow(),
                                           0)).booleanValue()){
             exgui.verification.VerifyLib.showAlert("細項已核選請勿修改\n如欲修改,請取消核選",
                                                    "細項已核選");
             return;
       }
        pnl2list.doUpdateCurrentPage();
        pnl2list.confirmUpdate();

       if(dbHanlderPayDtl==null) dbHanlderPayDtl=new DbDebitNotePayDtl();
       Record rec2Edit = dbHanlderPayDtl.getRecordByPk(
            ((Record)pnl2list.getDisplayingRecords().get(pnl2list.getJtable().
            getSelectedRow())).getInt(0));
        Constans.EDITING_DEBITNOTE_HEAD_ECORD = Constans.DEBIT_NOTE_HEAD_DBHANDLER.getRecordByPk((String)rec2Edit.get(1));
        Constans.QRY_DEBITNOTE_NO =(String)Constans.EDITING_DEBITNOTE_HEAD_ECORD.get(0);

        //(Record)pnl2list.getDisplayingRecords().get(pnl2list.getJtable().getSelectedRow());
        DlgEditDebitNotePayDtl dlg=
            new DlgEditDebitNotePayDtl (util.PublicVariable.APP_FRAME,"細項編輯",
                                         true,dbHanlderPayDtl ,rec2Edit);
        dlg.setSize(600,480);
        exgui.UIHelper.setToScreenCenter(dlg);
        dlg.show();
        pnl2list.reload();

      }catch(Exception epx){
        epx.printStackTrace();
      }
    }
  }
  void showReportOptionDlg(){
    java.util.Iterator itr=HASHMAP_PAYDTL_CHECKLIST.keySet().iterator();
    System.out.println("===============================");
    java.util.List seqList=new java.util.ArrayList();
    while(itr.hasNext()){
      String key=(String)itr.next();
      System.out.println(" key of select is "+key);
      seqList.add(key);
    }
    String seq[]=(String[])seqList.toArray(new String[0]);
    DlgPrint4ListQryPayDtl dlg2print=new  DlgPrint4ListQryPayDtl(util.PublicVariable.APP_FRAME,
                                             "報表選項",true,seq);
      dlg2print.setSize(570,305);
      exgui.UIHelper.setToScreenCenter(dlg2print);
      dlg2print.show();
  }
  void btnPrint_actionPerformed(ActionEvent e) {
    try{
      //force to list check box
      pnl2list.doUpdateCurrentPage();
      pnl2list.confirmUpdate();
      /*
      java.util.Iterator itr=HASHMAP_PAYDTL_CHECKLIST.keySet().iterator();
      System.out.println("===============================");
      while(itr.hasNext()){
        String key=(String)itr.next();
        System.out.println(" key of select is "+key);

      }*/
      //show the dlg of report
      showReportOptionDlg();
    }catch(Exception exp){
      exp.printStackTrace();
    }

  }
  void btnSelectAll_actionPerformed(ActionEvent e) {
    try{
      util.MiscFunc.showProcessingMessage();
      String sql = ((DbTempQryPayDtl)pnl2list.getPagedDataFactory()).orgSql;
      //find out all the record ,make them selected.
      Vector vct =
          exgui2.CONST.BASIC_MAIN_EJB.getDatas(
          util.PublicVariable.USER_RECORD,
          sql, 1, 999999);
      for(int i=0;i<vct.size();i++){
        Record rec=(Record)vct.get(i);
        HASHMAP_PAYDTL_CHECKLIST.put(rec.get(0).toString(),"1");
      }
      pnl2list.reload();
      //show dlg of option of report
      showReportOptionDlg();
    }catch(Exception exp){
      exp.printStackTrace();
    }finally{
      util.MiscFunc.hideProcessingMessage();
    }

  }

  void btnSelectCurrentPage_actionPerformed(ActionEvent e) {
    Vector vct =pnl2list.getDisplayingRecords();
    for(int i=0;i<vct.size();i++){
      Record rec=(Record)vct.get(i);
      HASHMAP_PAYDTL_CHECKLIST.put(rec.get(0).toString(),"1");
    }
    pnl2list.reload();
  }
}
