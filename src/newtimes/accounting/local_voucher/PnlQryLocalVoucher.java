package newtimes.accounting.local_voucher;

import java.awt.*;
import exgui.*;
import newtimes.preproduction.buyermakerselect.*;
import javax.swing.*;
import javax.swing.border.*;
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

public class PnlQryLocalVoucher extends JPanel {
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel1 = new BlueBkgWhiteCharLabel();
  JButton btnQry = new JButton();
  JLabel jLabel1 = new JLabel();
  Border border1;
  Panel2List pnl2list = null;
  String makrSeq=null;
  JButton btnExit=new JButton("EXIT");
  boolean isDummy=true;
  Record blankRecLVMKI=null;
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel2 = new BlueBkgWhiteCharLabel();
  JTextField txtSRN = new JTextField();
  JLabel jLabel2 = new JLabel();
  JTextField txtEtdFrom = new JTextField();
  JLabel jLabel3 = new JLabel();
  JTextField txtEtdTo = new JTextField();
  java.text.DateFormat df=null;
  exgui.DataBindTextWithChecker dbTxtFrom,dbTxtTo,dbTxtPrintFormDate,dbTxtPrintLetterDate,dbTxtCreateDate;
  PnlQryLocalVoucher stand=null;
  JLabel jLabel4 = new JLabel();
  //JButton btnSelectAll = new JButton();
  JButton btnSelectCurrentPage = new JButton();
  JButton btnPrint = new JButton();
  newtimesejb.debitNote.LocalVoucherFacade lvFacade=null;
   static java.util.HashMap HASHMAP_SRN_CHECKLIST=new java.util.HashMap();
   static java.util.HashMap HASHMAP_SRN_CHECKLIST_RECORDS=new java.util.HashMap();
   static String[] FORM_REPORT_NAME={"DB_COMM.rpt","DB_LONG.rpt","DB_LETTER.rpt"};
   static String[] FORM_VIEWER_TITLE={"SHORT FORM","LONG FORM","LETTER FORM"};
   static int FORM_TYPE_LONGFORM=1;
   static int FORM_TYPE_SHORTFORM=0;
   static int FORM_TYPE_LETTER=2;
   PrintMenus printMenus=new PrintMenus();
  JTextField txtPrintFormDate = new JTextField();
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel3 = new BlueBkgWhiteCharLabel();
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel4 = new BlueBkgWhiteCharLabel();
  JTextField txtPrintLetterDate = new JTextField();
  JLabel jLabel5 = new JLabel();
  JTextField txtCreateDate = new JTextField();
  JTextField txtMkrZhtwName = new JTextField();
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel5 = new BlueBkgWhiteCharLabel();
  static JComboBox cbxPrintDiff = new JComboBox(new String[]{"YES","NO"});
  JLabel jLabel6 = new JLabel();
  public PnlQryLocalVoucher() {
    try {
      jbInit();
      stand=this;
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }
  public void updatePrintDate(String printFieldName,int formtype,java.util.HashMap hmpara){

      newtimesejb.debitNote.LocalVoucherFacade ejb=null;
   try{
     util.MiscFunc.showProcessingMessage();
     newtimesejb.debitNote.LocalVoucherFacadeHome ejbHome =
         (newtimesejb.debitNote.LocalVoucherFacadeHome)
         info_ejb.WeblogicServiceLocator.locateServiceHome(util.PublicVariable.
         SERVER_URL,
         "newtimesejb.debitNote.LocalVoucherFacade");
     ejb = ejbHome.create();
   }catch(Exception exp){
     exp.printStackTrace();

   }
   if(ejb==null){
     try{
       util.MiscFunc.showProcessingMessage();
       newtimesejb.debitNote.LocalVoucherFacadeHome ejbHome =
           (newtimesejb.debitNote.LocalVoucherFacadeHome)
           info_ejb.WeblogicServiceLocator.locateServiceHome(util.PublicVariable.
           SERVER_URL,
           "newtimesejb.debitNote.LocalVoucherFacade");
       ejb = ejbHome.create();
     }catch(Exception exp){
       exp.printStackTrace();

     }
   }


    try{
      if(null==ejb){
        util.MiscFunc.showProcessingMessage();
        newtimesejb.debitNote.LocalVoucherFacadeHome ejbHome =
            (newtimesejb.debitNote.LocalVoucherFacadeHome)
            info_ejb.WeblogicServiceLocator.locateServiceHome(util.
            PublicVariable.
            SERVER_URL,
            "newtimesejb.debitNote.LocalVoucherFacade");
        ejb = ejbHome.create();
      }

      java.util.Vector vct=new java.util.Vector();
      java.util.Iterator itr=HASHMAP_SRN_CHECKLIST_RECORDS.keySet().iterator() ;
      java.sql.Date now=new java.sql.Date(System.currentTimeMillis());
      int PRINT_AT=(printFieldName.toUpperCase().equals("PRINT_FORM"))?3:4;

      StringBuffer sb=new StringBuffer();
      while(itr.hasNext()){
        Record rec=(Record)util.MiscFunc.deepCopy(HASHMAP_SRN_CHECKLIST_RECORDS.get((String)itr.next()));

        //rec.set("record_modify_user",util.PublicVariable.USER_RECORD.get(0));
        //long form is not used
        if(formtype!=FORM_TYPE_LONGFORM){
          rec.set(PRINT_AT, now);
        }
        rec.set(15,now);//modify date
        rec.set(16,util.PublicVariable.USER_RECORD.get(0));
        vct.add(rec);
        if(sb.length()>0){
          sb.append(",");
        }
        sb.append("'");
        sb.append((String)rec.get("ship_no"));
        sb.append("'");
      }
      ejb.updateLocalVoucher(vct);
      util.MiscFunc.hideProcessingMessage();
      if(FORM_REPORT_NAME[formtype]==null||FORM_REPORT_NAME[formtype].trim().length()==0){
        exgui.verification.VerifyLib.showAlert("REPROT NOT IMPLEMENTED YET",
                                               "REPORT under construction");
        return;
      }

      com.inet.viewer.ReportViewerBean viewer = util.PublicVariable.
          inet_report_viewer;
      java.util.HashMap hm =(hmpara==null)? new java.util.HashMap():hmpara;
      hm.put("P_SRN", "["+sb.toString()+"]");
      hm.put("P_CENTER",util.PublicVariable.OPERATTING_CENTER);
      if(formtype==FORM_TYPE_LONGFORM){
        hm.put("P_DIFF",cbxPrintDiff.getSelectedItem().toString().substring(0,1));
      }

      newtimes.production.report.ReportCmdSet.myReportEngin.
          setReportNameAndParas(viewer, FORM_REPORT_NAME[formtype], hm);
      viewer.setHasGroupTree(false);
      //viewer.setReportData(newtimes.production.report.ReportCmdSet.myReportEngin);
      viewer.start();
      JPanel pnl = new JPanel();
      pnl.setLayout(new java.awt.BorderLayout());
      pnl.add(viewer);

      newtimes.preproduction.guis.DlgViewRpt dlg = new newtimes.preproduction.
          guis.DlgViewRpt(
          processhandler.template.Properties.getMainFrame(),
          FORM_VIEWER_TITLE[formtype] ,
          pnl, true);
      dlg.setSize(700, 500);
      dlg.show();


    }catch(Exception exp){
      exp.printStackTrace();
      util.ExceptionLog.exp2File(exp,"");
      exgui.verification.VerifyLib.showAlert("UPDATE FAIL!!\nPlease Contact System Manager",
                                             "Update Fail!!");
      return;
    }

  }

  void btnPrint_actionPerformed(ActionEvent e) {
    try{
     pnl2list.doUpdateCurrentPage();
     pnl2list.confirmUpdate();
     if(HASHMAP_SRN_CHECKLIST_RECORDS.isEmpty()){
       exgui.verification.VerifyLib.showAlert("Pleas Query And Select Record To Print",
                                             "Pleas Query And Select Record To Print");
       return;
     }
    }catch(Exception exp){

    }
    printMenus.show(this,(int)btnPrint.getLocation().getX() ,((int)btnPrint.getLocation().getY())-70);


  }
  String  getInitMakerInfor(String makerBrief){
    StringBuffer sb=new StringBuffer();
    sb.append(makerBrief);sb.append("\n");
    sb.append("FAX:                    TEL:               \n");
    sb.append("統一編號:                                   \n");
    sb.append("地址:                                       \n");
    sb.append("                                           \n");
    sb.append("TO : #           小姐                       \n");
    sb.append("FM:   新麟 #823 楊康屏     (FAX: 2715-3336)  \n");
    sb.append("                                            \n");
    sb.append("請儘速回覆, 謝謝 !!!                           ");

    return sb.toString();
  }
  public java.util.HashMap  showAndUpdateMakerInfor(int buyer_maker_seq,String makerBrief){
    util.MiscFunc.showProcessingMessage();
     Record recBlankMakerInfor=null;
    try{
      String sql="select * from LOCAL_VOUCHER_MKR_INFOR where LV_MKR_SEQ="+buyer_maker_seq;
      Vector vct=exgui2.CONST.BASIC_MAIN_EJB.getDatas(
          util.PublicVariable.USER_RECORD,
          sql,1,999999);
      if(vct.size()==0){
          recBlankMakerInfor=(Record)util.MiscFunc.deepCopy(blankRecLVMKI);
          recBlankMakerInfor.set(0,buyer_maker_seq);
          recBlankMakerInfor.set("record_create_user",util.PublicVariable.USER_RECORD.get(0));
          recBlankMakerInfor.set(1,getInitMakerInfor(makerBrief));
      }else{
        recBlankMakerInfor=(Record)vct.get(0);
        recBlankMakerInfor.set("record_modify_user",util.PublicVariable.USER_RECORD.get(0));
      }


      util.MiscFunc.hideProcessingMessage();
      DlgMkrInfor4LocalVoucherPrint dlg=
          new DlgMkrInfor4LocalVoucherPrint(util.PublicVariable.APP_FRAME,"EDIT MAKER INFOR",true,recBlankMakerInfor);
             dlg.setSize(400,430);
             exgui.UIHelper.setToScreenCenter(dlg);
             dlg.slkMkrSeq.setEnabled(false);
             dlg.btnUpdate.setText("PRINT");
             dlg.btnDelete.setEnabled(false);
             dlg.panel1.remove(dlg.btnDelete);
             dlg.chkCommAmt.setEnabled(false);
             dlg.show();
       //System.out.println("dlg chk for comm. AMT is :"+dlg.chkCommAmt.isSelected());
       //System.out.println("dlg chk for EX-RATE is :"+dlg.chkExRate.isSelected());
       if(dlg.recEditing==null){
         return null;
       }
       lvFacade.ProcessMkrInfor(dlg.recEditing);
       java.util.HashMap hmParam=new java.util.HashMap();
       hmParam.put("P_DIFF",dlg.chkDiffAmt.isSelected()?"Y":"N");
       hmParam.put("P_EXCHANGE",dlg.chkExRate.isSelected()?"Y":"N");
       hmParam.put("P_NTD",dlg.chkNtAmt.isSelected()?"Y":"N");
       hmParam.put("P_INFO",dlg.txtInfor.getText().trim());
       hmParam.put("P_CENTER",util.PublicVariable.OPERATTING_CENTER);
       return hmParam;

    }catch(Exception exp){
      exp.printStackTrace();
      return null;
    }finally{
      util.MiscFunc.hideProcessingMessage();
    }

  }

  void btnSelectCurrentPage_actionPerformed(ActionEvent e) {
    //Vector vct =pnl2list.getDisplayingRecords();
    try{
      util.MiscFunc.showProcessingMessage();
      String sql = ((TempDb)pnl2list.getPagedDataFactory()).orgSql;
      //find out all the record ,make them selected.
      Vector vct =
          exgui2.CONST.BASIC_MAIN_EJB.getDatas(
          util.PublicVariable.USER_RECORD,
          sql, 1, 999999);

      for (int i = 0; i < vct.size(); i++) {
        Record rec = (Record)vct.get(i);
        HASHMAP_SRN_CHECKLIST.put(rec.get(0).toString(), "1");
        HASHMAP_SRN_CHECKLIST_RECORDS.put(rec.get(0), rec);
      }
      pnl2list.reload();
    }catch(Exception exp){
      exp.printStackTrace();
      exgui.verification.VerifyLib.showAlert("Server Side Connection Fail\nPlease Contact System Manager",
                                             "Connection Error");
    }finally{
      util.MiscFunc.hideProcessingMessage();
    }

  }

  void jbInit() throws Exception {
    this.setLayout(null);
    btnExit.setFont(new java.awt.Font("Dialog", 1, 11));
    btnExit.setText("EXIT");
    btnExit.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnExit_actionPerformed(e);
      }
    });

    border1 = BorderFactory.createBevelBorder(BevelBorder.RAISED,Color.white,Color.white,new Color(103, 101, 98),new Color(148, 145, 140));
    blueBkgWhiteCharLabel1.setText("QUERY LOCAL VOUCHER");
    blueBkgWhiteCharLabel1.setBounds(new Rectangle(-1, 1, 801, 26));
    this.setLayout(null);
    btnQry.setBounds(new Rectangle(699, 30, 89, 25));
    btnQry.setFont(new java.awt.Font("Dialog", 1, 11));
    btnQry.setText("QUERY");
    btnQry.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnQry_actionPerformed(e);
      }
    });
    jLabel1.setBorder(border1);
    jLabel1.setBounds(new Rectangle(0, 88, 801, 10));

    blueBkgWhiteCharLabel2.setText("SRN");
    blueBkgWhiteCharLabel2.setBounds(new Rectangle(1, 30, 71, 24));
    txtSRN.setText("");
    txtSRN.setBounds(new Rectangle(71, 30, 162, 23));
    jLabel2.setBackground(Color.white);
    jLabel2.setFont(new java.awt.Font("Dialog", 1, 11));
    jLabel2.setOpaque(true);
    jLabel2.setHorizontalAlignment(SwingConstants.CENTER);
    jLabel2.setText("ETD FROM");
    jLabel2.setBounds(new Rectangle(245, 30, 66, 24));
    txtEtdFrom.setText("");
    txtEtdFrom.setBounds(new Rectangle(310, 30, 76, 24));
    jLabel3.setBounds(new Rectangle(385, 30, 39, 24));
    jLabel3.setText("TO");
    jLabel3.setBackground(Color.white);
    jLabel3.setFont(new java.awt.Font("Dialog", 1, 11));
    jLabel3.setOpaque(true);
    jLabel3.setHorizontalAlignment(SwingConstants.CENTER);
    txtEtdTo.setText("");
    txtEtdTo.setBounds(new Rectangle(423, 30, 76, 24));
    jLabel4.setText("CLICK ANY ROW TO EDIT LOCAL VOUCHER CONTAINT");
    jLabel4.setBounds(new Rectangle(5, 99, 349, 22));

    btnPrint.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnPrint_actionPerformed(e);
      }
    });
    btnPrint.setText("Print Selected ▲");
    btnPrint.setFont(new java.awt.Font("Dialog", 1, 11));
    btnPrint.setBounds(new Rectangle(450, 534-7, 131, 34-5));
    /*
    btnSelectAll.setBounds(new Rectangle(211+25, 534-7, 110, 34-5));
    btnSelectAll.setFont(new java.awt.Font("Dialog", 1, 11));
    btnSelectAll.setText("Print All");
    btnSelectAll.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnSelectAll_actionPerformed(e);
      }
    });*/
    btnSelectCurrentPage.setBounds(new Rectangle(240, 534-7, 183, 34-5));
    btnSelectCurrentPage.setFont(new java.awt.Font("Dialog", 1, 11));
    btnSelectCurrentPage.setHorizontalTextPosition(SwingConstants.TRAILING);
    btnSelectCurrentPage.setText("Select All");
    btnSelectCurrentPage.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnSelectCurrentPage_actionPerformed(e);
      }
    });

    txtPrintFormDate.setText("");
    txtPrintFormDate.setBounds(new Rectangle(164, 59, 66, 24));
    blueBkgWhiteCharLabel3.setBounds(new Rectangle(1, 59, 163, 24));
    blueBkgWhiteCharLabel3.setText("PRINT SHORT FORM DATE");
    blueBkgWhiteCharLabel4.setText("PRINT LETTER DATE");
    blueBkgWhiteCharLabel4.setBounds(new Rectangle(234, 59, 152, 24));
    txtPrintLetterDate.setBounds(new Rectangle(386, 59, 66, 24));
    jLabel5.setBounds(new Rectangle(507, 30, 98, 24));
    jLabel5.setText("CREATE DATE");
    jLabel5.setHorizontalAlignment(SwingConstants.CENTER);
    jLabel5.setOpaque(true);
    jLabel5.setFont(new java.awt.Font("Dialog", 1, 11));
    jLabel5.setBackground(Color.white);
    txtCreateDate.setBounds(new Rectangle(605, 30, 78, 24));
    txtCreateDate.setText("");
    txtMkrZhtwName.setBounds(new Rectangle(557, 59, 78, 24));
    blueBkgWhiteCharLabel5.setBounds(new Rectangle(457, 59, 100, 24));
    blueBkgWhiteCharLabel5.setFont(new java.awt.Font("Dialog", 0, 12));
    blueBkgWhiteCharLabel5.setText("廠商名稱關鍵字");
    cbxPrintDiff.setBounds(new Rectangle(748, 60, 50, 22));
    jLabel6.setFont(new java.awt.Font("Dialog", 1, 11));
    jLabel6.setText("Print Diff");
    jLabel6.setBounds(new Rectangle(695, 60, 53, 23));
    this.add(blueBkgWhiteCharLabel1, null);
    this.add(btnQry, null);
    this.add(jLabel1, null);
    this.add(jLabel2, null);
    this.add(txtEtdFrom, null);
    this.add(jLabel3, null);
    this.add(txtEtdTo, null);
    Object vftxtDate = exgui.verification.CellFormat.getDateStringFormaterAllowNull();

    dbTxtFrom=new exgui.DataBindTextWithChecker(txtEtdFrom, "",
                                        null, 10,
                                        (exgui.Object2String)vftxtDate,
                                        (exgui.ultratable.CellTxtEditorFormat)
                                        vftxtDate);

    dbTxtTo=new exgui.DataBindTextWithChecker(txtEtdTo, "",
                                        null, 10,
                                        (exgui.Object2String)vftxtDate,
                                        (exgui.ultratable.CellTxtEditorFormat)
                                        vftxtDate);


    dbTxtPrintFormDate=new exgui.DataBindTextWithChecker(txtPrintFormDate, "",
                                        null, 10,
                                        (exgui.Object2String)vftxtDate,
                                        (exgui.ultratable.CellTxtEditorFormat)
                                        vftxtDate);


    dbTxtPrintLetterDate=new exgui.DataBindTextWithChecker(txtPrintLetterDate, "",
                                   null, 10,
                                  (exgui.Object2String)vftxtDate,
                                  (exgui.ultratable.CellTxtEditorFormat)
                                  vftxtDate);

    dbTxtCreateDate=new exgui.DataBindTextWithChecker(txtCreateDate, "",
                                   null, 10,
                                  (exgui.Object2String)vftxtDate,
                                  (exgui.ultratable.CellTxtEditorFormat)
                                  vftxtDate);

    //this.add(btnSelectAll, null);
    this.add(btnSelectCurrentPage, null);
    this.add(btnPrint, null);
    btnExit.setBounds(new Rectangle(673+25, 534-7, 82, 34-5));
    btnExit.setFont(new java.awt.Font("Dialog", 1, 11));
    this.add(btnExit, null);
    initPanel();
    this.add(pnl2list, null);
    this.add(blueBkgWhiteCharLabel4, null);
    this.add(txtPrintLetterDate, null);
    this.add(jLabel2, null);
    this.add(txtEtdFrom, null);
    this.add(txtEtdTo, null);
    this.add(jLabel3, null);
    isDummy=false;

  }
  boolean isFieldReady(){
    if(df==null){
      df=new java.text.SimpleDateFormat("yyyy/MM/dd");
    }
    try{
      if(!(dbTxtFrom.getSelectedValue()!=null && dbTxtTo.getSelectedValue()!=null ))return true;
      java.util.Date dateFrom = df.parse(txtEtdFrom.getText());
      java.util.Date dateTo   = df.parse(txtEtdTo.getText());
      if(dateFrom.after(dateTo)){
        exgui.verification.VerifyLib.showAlert("START DATE SHOULD BEFORE END DATE",
                                               "START DATE SHOULD BEFORE END DATE");
        return false;
      }
    }catch(Exception exp){
      exp.printStackTrace();
      exgui.verification.VerifyLib.showAlert("Convert Error",
                                             "Convert Error");
      return false;
    }

    return true;
  }

 public void btnExit_actionPerformed(ActionEvent me){
   try{
     processhandler.template.Properties.getCenteralControler().goBack();
   }catch(Exception exp){
     exp.printStackTrace();
   }
 }
  protected void initPanel(){
        if(pnl2list!=null) this.remove(pnl2list);
        util.InsertionOrderedHashMap iso=new util.InsertionOrderedHashMap();
        iso.put("x","is2Print");//0
        iso.put("SRN","SHIP_NO");//1
        iso.put("ETD","SHIP_ETD_DATE");//2
        iso.put("      FTY-INV       ","SHIP_FTY_INV");//3
        iso.put("X RATE","EXCHANGE_RATE");//4
        iso.put("    FTY-NAME   ","fty_brief");//5
        iso.put("廠商名稱","fty_chn_name");//6
        iso.put("CreateDate","RECORD_CREATE_DATE");//7
        iso.put("DiscTotal","DISC_AMT");//8
        iso.put("BLNC-AMT","DDK_BALANCE");//9

        java.util.Hashtable ht=new java.util.Hashtable();
        ht.put("  ETD  ",exgui.verification.CellFormat.getDateStringFormaterAllowNull());
        pnl2list=new Panel2List(new TempDb(),23,iso,ht);
        JPanel pnl2setButton=pnl2list.getLowerRightPanel();
        pnl2setButton.removeAll();
        pnl2setButton.setLayout(null);

        pnl2list.setBounds(new Rectangle(9, 118, 775, 440));

        this.add(pnl2list, null);
        this.add(btnQry, null);
        this.add(blueBkgWhiteCharLabel1, null);
        this.add(btnQry, null);
        this.add(jLabel4, null);
    this.add(jLabel3, null);
    this.add(jLabel2, null);
    this.add(txtEtdFrom, null);
    this.add(txtEtdTo, null);
    this.add(btnQry, null);
    this.add(btnQry, null);
    this.add(cbxPrintDiff, null);
    this.add(blueBkgWhiteCharLabel3, null);
    this.add(blueBkgWhiteCharLabel2, null);
    this.add(txtSRN, null);
    this.add(blueBkgWhiteCharLabel4, null);
    this.add(txtPrintLetterDate, null);
    this.add(jLabel2, null);
    this.add(txtEtdFrom, null);
    this.add(jLabel3, null);
    this.add(txtEtdTo, null);
    this.add(jLabel5, null);
    this.add(txtCreateDate, null);
    this.add(txtPrintFormDate, null);
    this.add(blueBkgWhiteCharLabel4, null);
    this.add(txtPrintLetterDate, null);
    this.add(blueBkgWhiteCharLabel5, null);
    this.add(txtMkrZhtwName, null);
    this.add(jLabel6, null);
    this.add(btnQry, null);
    this.add(jLabel2, null);
    this.add(txtEtdFrom, null);
    this.add(jLabel3, null);
    this.add(txtEtdTo, null);
    this.add(txtPrintLetterDate, null);
    this.add(txtEtdTo, null);
    this.add(txtPrintLetterDate, null);
        this.add(btnQry, null);
        pnl2list.firstPage();
        this.repaint();
        this.validate();


  }
  class MouseListen extends java.awt.event.MouseAdapter{
    public void mouseClicked(java.awt.event.MouseEvent me){

        if(pnl2list.getJtable().getSelectedColumn()==0)return;
        if(((Boolean)pnl2list.getJtable().getValueAt(pnl2list.getJtable().getSelectedRow(),
                                           0)).booleanValue()){
             exgui.verification.VerifyLib.showAlert("細項已核選請勿修改\n如欲修改,請取消核選",
                                                    "細項已核選");
             return;
       }
       Record rec=null;
       try{
         rec = (Record)util.MiscFunc.deepCopy(
               pnl2list.getDisplayingRecords().get(pnl2list.getJtable().getSelectedRow())
               );
       }catch(Exception exp){
         exp.printStackTrace();
       }
       //if have deduct record,and click at last column,goto show deduct record gui.
       if(pnl2list.getJtable().getSelectedColumn()==
          pnl2list.getJtable().getColumnCount()-1 &&
          rec.getInt(23)>0){
         try{
           processhandler.template.Properties.getCenteralControler().doCommandExecute(
            new TgrListDDK4XLV((String)rec.get(0),stand)
           );
             return;
         }catch(Exception exp){
           exp.printStackTrace();
         }
       }




      DlgEditLocalVoucher  dlg=
          new DlgEditLocalVoucher(util.PublicVariable.APP_FRAME,"EDIT LOCAL VOUCHER ",true,rec,stand);
             dlg.setSize(525,520);
             exgui.UIHelper.setToScreenCenter(dlg);
             dlg.show();


    }
  }
  /*
  class MenueListener extends java.awt.event.MouseAdapter{
    public void mouseExited(java.awt.event.MouseEvent me){
      printMenus.setVisible(false);
    }
  }*/
  class PrintMenus extends javax.swing.JPopupMenu  implements java.awt.event.ActionListener{
     JMenuItem itemPrintShort;
     JMenuItem itemPrintLong;
     JMenuItem itemPrintLetter;
        public PrintMenus(){
          super();
          itemPrintShort=new JMenuItem(" SHORT");
          itemPrintShort.addActionListener(this);
          itemPrintLong=new JMenuItem(" LONG");
          itemPrintLong.addActionListener(this);
          itemPrintLetter=new JMenuItem(" LETTER ");
          itemPrintLetter.addActionListener(this);
          add(itemPrintShort);
          add(itemPrintLong);
          add(itemPrintLetter);
        }
        public void actionPerformed(java.awt.event.ActionEvent ae){
          if(ae.getSource()==itemPrintShort){
            //doCopy();
            //processhandler.template.Properties.getCenteralControler().getDataProcesser().doCopy();
            updatePrintDate("PRINT_FORM",FORM_TYPE_SHORTFORM,null);
            return;
          }
          if(ae.getSource()==itemPrintLong){
            try{
              //doDelete();
              //processhandler.template.Properties.getCenteralControler().getDataProcesser().doDelete();
              updatePrintDate("PRINT_FORM",FORM_TYPE_LONGFORM,null);
              return;
            }catch(Exception exp){
              exp.printStackTrace();
            }
          }
          if(ae.getSource()==itemPrintLetter){
            //doPaste();
            java.util.Iterator itrkey=HASHMAP_SRN_CHECKLIST_RECORDS.keySet().iterator();
            Record initRec=null;
            int test_maker_seq=-1;
            String test_maker_name=null;
            //check if maker different
            while(itrkey.hasNext()){
              String key = (String)itrkey.next();
              initRec = (Record)HASHMAP_SRN_CHECKLIST_RECORDS.get(key);
              if(test_maker_seq==-1)test_maker_seq=initRec.getInt(21);
              if(initRec.getInt(21)!=test_maker_seq){
                exgui.verification.VerifyLib.showAlert("Maker Different!!\nPlease Check Selected Rows",
                                                       "Maker Different!!");
                return;
              }
              if(test_maker_name==null){
                test_maker_name=(String)initRec.get(19);
              }
            }

            java.util.HashMap  is2PrintParam= showAndUpdateMakerInfor(test_maker_seq ,test_maker_name);

            if(is2PrintParam==null) return;
            updatePrintDate("PRINT_LETTER",FORM_TYPE_LETTER,is2PrintParam);

            //processhandler.template.Properties.getCenteralControler().getDataProcesser().doPaste();
            return;
          }
        }

  }
  class CellRender4ListingDDK extends JLabel
      implements javax.swing.table.TableCellRenderer{
      java.text.NumberFormat nf=new java.text.DecimalFormat("##########0.00");
     public CellRender4ListingDDK(){
        super();
       setBorder(null);
       setOpaque(true); /* it\u00B4s essential */
       setHorizontalAlignment(JLabel.RIGHT);
    }
   public Component getTableCellRendererComponent(
         javax.swing.JTable table, Object value,
         boolean isSelected, boolean hasFocus,
         int row, int column){
        Record rec=(Record)pnl2list.getDisplayingRecords().get(row);
         boolean hasDDK=(rec.getInt(23)>0);//if have deduct record count
        if(!hasDDK){
          setBackground(new java.awt.Color(0xFF, 0xFF, 0xFF)); // Decides the color
        }else{
          if(rec.getInt(25)>0){
            //if have bad debit,show pink
            setBackground(new java.awt.Color(0xEC, 0xC8, 0xEC)); // Decides the color
          }else{
            setBackground(new java.awt.Color(0xD0, 0xD0, 0xD0)); // Decides the color
          }
        }
        String text = (value==null)?"0":value.toString();
        text=text.equals("PAID")?"PAID":nf.format(Double.parseDouble(text));
        setText(text);
     return this;
    }
  }


  class CellRenderAmt extends JLabel
    implements javax.swing.table.TableCellRenderer{
   java.text.NumberFormat nf=new java.text.DecimalFormat("##########0.00");
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
      String text = (value==null)?"0":value.toString();
      text=text.equals("PAID")?"PAID":nf.format(Double.parseDouble(text));
      setBackground(new java.awt.Color(0xFF, 0xFF, 0xFF)); // Decides the color
      if(isSelected)setBackground(new java.awt.Color(0xFF, 0xE3, 0x8C));
      setText(text);
   return this;
  }
}


  class Panel2List extends processhandler.template.PnlTableEditor{
    public Panel2List(exgui.ultratable.PagedDataFactory pagedDataFxy,
                      int rowCounts,util.InsertionOrderedHashMap columnMapping,
                     java.util.Hashtable object2StringConvertor){
        super(pagedDataFxy, rowCounts, columnMapping, object2StringConvertor);
        getJtable().addMouseListener(new MouseListen());
    }
    public void doPrint(){}
    public int getEachPageRowCount(){return _rowCounts;}
    public Hashtable getObject2StringConvertor() {return klmObjKvtHt;}
    public util.InsertionOrderedHashMap getHeadColumnMap(){return tblHeadColumn;}
    public exgui.ultratable.PagedDataFactory getPagedDataFactory(){return dbHandler;}
    //public Record setObject2Record(Record rec,int col,Object obj){return null;}
    public void makeTable(Vector vct){
      super.makeTable(vct);
      //adject column size;
      getJtable().getColumnModel().getColumn(0).setPreferredWidth(5);
      getJtable().getColumnModel().getColumn(1).setPreferredWidth(101);
      getJtable().getColumnModel().getColumn(2).setPreferredWidth(68);
      getJtable().getColumnModel().getColumn(4).setPreferredWidth(55);
      getJtable().getColumnModel().getColumn(6).setPreferredWidth(55);
      getJtable().getColumnModel().getColumn(7).setPreferredWidth(70);
      getJtable().getColumnModel().getColumn(8).setPreferredWidth(70);
    }

    public void doUpdateCurrentPage(){
      for(int i=0;i<getDisplayingRecords().size();i++){
        Record rec=(Record)getDisplayingRecords().get(i);
        Record recx=setObject2Record(rec,0,getJtable().getValueAt(i,0));
      }
    }
    public Record setObject2Record(Record rec,int col,Object obj){
         if(col==0){
           Boolean blValue=(Boolean)obj;
           String srn=rec.get(0).toString();
           if(blValue.booleanValue()){
             HASHMAP_SRN_CHECKLIST.put(srn,"1");
             HASHMAP_SRN_CHECKLIST_RECORDS.put(srn,rec);
           }else{
             HASHMAP_SRN_CHECKLIST.remove(srn);
             HASHMAP_SRN_CHECKLIST_RECORDS.remove(srn);
           }
         }
         return null;
    }
    public void refineEditors(exgui.ultratable.MultiEditorJTable me ){
      ((exgui.MultiClassTableModel)me.getJTable().getModel()).removeAllEditableColumn();
      getJtable().getColumnModel().getColumn(8).setCellRenderer(new CellRenderAmt());
      getJtable().getColumnModel().getColumn(9).setCellRenderer(new CellRender4ListingDDK());
      me.addCheckbox(0,"1");
    }

    /*
    public void refineEditors(exgui.ultratable.MultiEditorJTable me ){
      ((exgui.MultiClassTableModel)me.getJTable().getModel()).removeAllEditableColumn();
      getJtable().getColumnModel().getColumn(6).setCellRenderer(new CellRenderAmt());
    }*/
  }

  class TempDb extends exgui.ultratable.PagedDataFactoryAdapter {
    String orgSql=null;
    TempDb(){
      try{
      if(lvFacade==null){
        newtimesejb.debitNote.LocalVoucherFacadeHome ejbHome=
            (newtimesejb.debitNote.LocalVoucherFacadeHome)
            info_ejb.WeblogicServiceLocator.locateServiceHome(util.PublicVariable.SERVER_URL,
            "newtimesejb.debitNote.LocalVoucherFacade");
        lvFacade=ejbHome.create();
        blankRecord=lvFacade.getBlankRecordOfMkrInfor();
        blankRecord.set("record_create_user",util.PublicVariable.USER_RECORD.get(0));
        blankRecord.set("record_delete_flag",-1);
        blankRecLVMKI=(Record)util.MiscFunc.deepCopy(blankRecord);
       }
      }catch(Exception exp){
        exp.printStackTrace();
        exgui.verification.VerifyLib.showAlert("ERROR WHILE ATTEMP TO CREATE SERVER-SIDE COMPONENT\nPleas Contact System Manager",
                                               "Connection Error");

      }

    }
    public Vector getRecords(int bgn,int rowcount)throws Exception{
      try{
        if(isDummy)return new Vector();
      if(orgSql==null){
        StringBuffer sb=new StringBuffer();
        sb.append("select  distinct a.*,");
        sb.append("(select BYMKR_CHINESE_BRIEF from buyer_maker where bymkr_seq=");
        sb.append("(select prod_maker from prod_head where prod_head_pk=");
        sb.append("(select cc.prod_head_pk from ship_sc cc where cc.ship_no=b.ship_no");
        sb.append(" and cc.record_delete_flag='1' and rownum=1)))");
        sb.append("as fty_chn_name,");


        sb.append("(select BYMKR_brief from buyer_maker where bymkr_seq=");
        sb.append("(select prod_maker from prod_head where prod_head_pk=");
        sb.append("(select cc.prod_head_pk from ship_sc cc where cc.ship_no=b.ship_no");
        sb.append(" and cc.record_delete_flag='1' and rownum=1)))");
        sb.append(" as fty_brief,");

        sb.append("(select prod_maker from prod_head ");
        sb.append("where prod_head_pk=(select cc.prod_head_pk ");
        sb.append("from ship_sc cc where cc.ship_no=b.ship_no and cc.record_delete_flag='1' and rownum=1)) as fty_seq ");
        sb.append(", round(disc_amt  +");
        sb.append(" ( decode(nvl(exchange_rate,0),0,1,exchange_rate) *  nvl(diff_ttl,0)) ");
        sb.append(" -nvl((select sum(LVD.ddk_amt) from local_voucher_deduct  LVD where ");
        sb.append(" LVD.record_delete_flag='1' and LVD.ship_no=a.ship_no),0) ");

        sb.append("-nvl((select sum(LVD.other_amt) from local_voucher_deduct  LVD where ");
        sb.append(" LVD.record_delete_flag='1' and LVD.ship_no=a.ship_no),0)  ");

//        sb.append(",2) as DDK_BALANCE ");
        sb.append(",DECODE(exchange_rate,NULL,2,0)) as DDK_BALANCE ");
        //field 22 (don't forget we add field "discount  amt usd" in local voucher table.
        sb.append(",(select count(*) from local_voucher_deduct cc where cc.ship_no=a.ship_no and cc.record_delete_flag='1') as ddk_count ");

        sb.append(",nvl((select sum(lvdk.DDK_AMT)  ");
        sb.append("        from LOCAL_VOUCHER_DEDUCT lvdk ");
        sb.append("        where lvdk.SHIP_NO=a.ship_no and lvdk.record_delete_flag='1'),0) ");

        sb.append("+nvl((select sum(lvdk.OTHER_AMT)  ");
        sb.append("        from LOCAL_VOUCHER_DEDUCT lvdk ");
        sb.append("        where lvdk.SHIP_NO=a.ship_no and lvdk.record_delete_flag='1'),0) ");

        sb.append(" as local_voucher_ddk_sum ");
        sb.append(",(select  count(*) from  local_voucher_deduct where LOCAL_VOUCHER_DEDUCT.SHIP_NO=b.ship_no and LOCAL_VOUCHER_DEDUCT.CHK_NO ='呆帳' ) as bad_debit_count ");

        sb.append("from local_voucher a,shipping b ");
        sb.append("where a.ship_no=b.ship_no ");
        int ship_no_length=12;
        if(txtSRN.getText().trim().length()>0){
          if(txtSRN.getText().trim().length()<12){
             sb.append(" and a.ship_no like '");
             sb.append(txtSRN.getText().trim().toUpperCase());
             sb.append("%'");
          }else{
            sb.append(" and a.ship_no = '");
            sb.append(txtSRN.getText().trim().toUpperCase());
            sb.append("'");
          }
        }else{
          if("001".equals(util.PublicVariable.OPERATTING_CENTER)){
            sb.append(" and a.ship_no like 'ZATW%' ");
          }else if("001".equals(util.PublicVariable.OPERATTING_CENTER)){
            sb.append(" and a.ship_no like 'ZNNT%' ");
          }else{
            ship_no_length=13;
            String prefix=newtimes.accounting.debit_note.Constans.getCenterPrefix(util.PublicVariable.OPERATTING_CENTER);
            sb.append(" and a.ship_no like 'Z__");
            sb.append(prefix);
            sb.append("%' ");

          }
          sb.append(" and length(a.ship_no)=");
          sb.append(String.valueOf(ship_no_length));
          sb.append(" ");
        }
        if(txtEtdFrom.getText().length()>0)
             {sb.append(" and  a.ship_etd_date >= to_date('");sb.append(txtEtdFrom.getText());sb.append("','yyyy/mm/dd') ");}
        if(txtEtdTo.getText().length()>0)
             {sb.append(" and  a.ship_etd_date <= to_date('");sb.append(txtEtdTo.getText());  sb.append("','yyyy/mm/dd') ");}


       if(txtPrintFormDate.getText().length()>0)
            {sb.append(" and  a.PRINT_FORM = to_date('");sb.append(txtPrintFormDate.getText());  sb.append("','yyyy/mm/dd') ");}

       if(txtPrintLetterDate.getText().length()>0)
            {sb.append(" and  a.PRINT_LATTER = to_date('");sb.append(txtPrintLetterDate.getText());  sb.append("','yyyy/mm/dd') ");}

       if(txtCreateDate.getText().length()>0)
            {sb.append(" and  a.record_create_date = to_date('");sb.append(txtCreateDate.getText());  sb.append("','yyyy/mm/dd') ");}

       if(txtMkrZhtwName.getText().trim().length()>0){
         sb.append(" and ");
         sb.append("(select BYMKR_CHINESE_BRIEF from buyer_maker where bymkr_seq=");
         sb.append("(select prod_maker from prod_head where prod_head_pk=");
         sb.append("(select cc.prod_head_pk from ship_sc cc where cc.ship_no=b.ship_no");
         sb.append(" and cc.record_delete_flag='1' and rownum=1))) like '");
         sb.append(util.MiscFunc.Replace(txtMkrZhtwName.getText().trim(),"'","''"));
         sb.append("%' ");

       }

        orgSql=sb.toString();
       }
       System.out.println(orgSql.toString());
        util.MiscFunc.showProcessingMessage();
        System.gc();
        Vector vct = exgui2.CONST.BASIC_MAIN_EJB.getDatas(
            util.PublicVariable.USER_RECORD,
            orgSql,
            bgn, rowcount);
        //return vct;
        Vector vct2return=new Vector();
        for(int i=0;i<vct.size();i++){
          Record rec=(Record)vct.get(i);
          //20 th is balance of deduct
          Object objDeductBalance=rec.get(22);
          if(objDeductBalance!=null){
             double ddkBalance=rec.getDouble(22);
             if(0==ddkBalance)rec.set(22,"PAID");
          }
          String srn=(String)rec.get(0);
          rec.getFieldName().add("is2Print");
          if(HASHMAP_SRN_CHECKLIST.containsKey(srn)){
            //rec.set("is2Print","1");
            rec.getValueFields().add("1");
          }else{
            //rec.set("is2Print","0");
            rec.getValueFields().add("0");
          }
          vct2return.add(rec);
        }
        return vct2return;
      }finally{
        util.MiscFunc.hideProcessingMessage();
      }
    }
  }

  void btnQry_actionPerformed(ActionEvent e) {
    if(!isFieldReady()) return;
    HASHMAP_SRN_CHECKLIST.clear();
    HASHMAP_SRN_CHECKLIST_RECORDS.clear();
    System.gc();
    initPanel();
  }
}
