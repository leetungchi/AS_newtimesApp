package newtimes.accounting.debit_note;

import java.awt.*;
import exgui.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;
import database.datatype.Record;
import javax.swing.border.*;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class PnlExportSrnMkr2DebitNote extends JPanel {
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel1 = new BlueBkgWhiteCharLabel();
  WhiteBkgBlueCharLabel whiteBkgBlueCharLabel2 = new WhiteBkgBlueCharLabel();
  JTextField txtEtdFrom = new JTextField();
  WhiteBkgBlueCharLabel whiteBkgBlueCharLabel3 = new WhiteBkgBlueCharLabel();
  JTextField txtEtdTo = new JTextField();
  JButton btnExport = new JButton();
  JButton btnExit = new JButton();
  exgui.DataBindTextWithChecker dbTxtFrom,dbTxtTo;
  exgui.DataBindJCombobox dbCbxDep;
  java.text.DateFormat df=null;
  String BlankTail="                         ";
  JPanel jPanel1 = new JPanel();
  Border border1;
  TitledBorder titledBorder1;
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel2 = new BlueBkgWhiteCharLabel();
  JTextField txtSRN = new JTextField();
  JButton btnExportSingle = new JButton();
  JButton bntStateMemtReport = new JButton();
  JComboBox cbxDep = new JComboBox();
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel3 = new BlueBkgWhiteCharLabel();
  public PnlExportSrnMkr2DebitNote() {
    try {
      jbInit();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }

  void jbInit() throws Exception {
    border1 = new EtchedBorder(EtchedBorder.RAISED,Color.white,new Color(148, 145, 140));
    titledBorder1 = new TitledBorder(new EtchedBorder(EtchedBorder.RAISED,Color.white,new Color(148, 145, 140)),"SINGLE SRN EXPORT");
    blueBkgWhiteCharLabel1.setText("EXPORT MAKER DISCOUNT TO DEBITNOTE SYSTEM");
    blueBkgWhiteCharLabel1.setBounds(new Rectangle(-2, 19, 804, 38));
    this.setBackground(new Color(202, 202, 224));
    this.setLayout(null);
    whiteBkgBlueCharLabel2.setText("ETD FROM:");
    whiteBkgBlueCharLabel2.setBounds(new Rectangle(41, 93, 89, 23));
    txtEtdFrom.setText("");
    txtEtdFrom.setBounds(new Rectangle(130, 93, 66, 23));
    whiteBkgBlueCharLabel3.setBounds(new Rectangle(195, 93, 43, 23));
    whiteBkgBlueCharLabel3.setText("TO");
    txtEtdTo.setBounds(new Rectangle(239, 93, 66, 23));
    txtEtdTo.setText("");
    btnExport.setBounds(new Rectangle(626, 93, 124, 26));
    btnExport.setFont(new java.awt.Font("Dialog", 1, 11));
    btnExport.setText("EXPORT");
    btnExport.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnExport_actionPerformed(e);
      }
    });
    btnExit.setText("EXIT");
    btnExit.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnExit_actionPerformed(e);
      }
    });
    btnExit.setBounds(new Rectangle(556, 417, 124, 26));
    btnExit.setFont(new java.awt.Font("Dialog", 1, 11));
    jPanel1.setBackground(new Color(202, 202, 224));
    jPanel1.setAlignmentY((float) 0.5);
    jPanel1.setBorder(titledBorder1);
    jPanel1.setBounds(new Rectangle(22, 157, 734, 98));
    jPanel1.setLayout(null);
    blueBkgWhiteCharLabel2.setText("SRN:");
    blueBkgWhiteCharLabel2.setBounds(new Rectangle(10, 35, 135, 26));
    txtSRN.setText("");
    txtSRN.setBounds(new Rectangle(145, 35, 135, 26));
    btnExportSingle.setBounds(new Rectangle(298, 35, 178, 26));
    btnExportSingle.setFont(new java.awt.Font("Dialog", 1, 11));
    btnExportSingle.setText("SINGLE SRN EXPORT");
    btnExportSingle.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnExportSingle_actionPerformed(e);
      }
    });
    bntStateMemtReport.setBackground(Color.white);
    bntStateMemtReport.setBounds(new Rectangle(22, 278, 322, 32));
    bntStateMemtReport.setFont(new java.awt.Font("Dialog", 1, 11));
    bntStateMemtReport.setText("Print Statement Report");
    bntStateMemtReport.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        bntStateMemtReport_actionPerformed(e);
      }
    });
    cbxDep.setBounds(new Rectangle(375, 93, 228, 23));
    blueBkgWhiteCharLabel3.setBounds(new Rectangle(325, 93, 51, 23));
    blueBkgWhiteCharLabel3.setText("DEP:");
    this.add(blueBkgWhiteCharLabel1, null);
    this.add(btnExit, null);
    this.add(jPanel1, null);
    jPanel1.add(blueBkgWhiteCharLabel2, null);
    jPanel1.add(txtSRN, null);
    jPanel1.add(btnExportSingle, null);
    this.add(whiteBkgBlueCharLabel2, null);
    this.add(txtEtdFrom, null);
    this.add(whiteBkgBlueCharLabel3, null);
    this.add(txtEtdTo, null);
    this.add(bntStateMemtReport, null);
    this.add(btnExport, null);
    this.add(blueBkgWhiteCharLabel3, null);
    this.add(cbxDep, null);

       Object vftxtDate = exgui.verification.CellFormat.getDateStringFormaterAllowNull();
       java.sql.Date now=new java.sql.Date(System.currentTimeMillis());


     dbTxtFrom=new exgui.DataBindTextWithChecker(txtEtdFrom, "",
                                         now, 10,
                                         (exgui.Object2String)vftxtDate,
                                         (exgui.ultratable.CellTxtEditorFormat)
                                         vftxtDate);

     dbTxtTo=new exgui.DataBindTextWithChecker(txtEtdTo, "",
                                         now, 10,
                                         (exgui.Object2String)vftxtDate,
                                         (exgui.ultratable.CellTxtEditorFormat)
                                         vftxtDate);
     String strDateFrom=txtEtdFrom.getText().substring(0,8)+"01";
     txtEtdFrom.setText(strDateFrom);

    dbCbxDep=
       new exgui.DataBindJCombobox(
            cbxDep,"",
            newtimes.preproduction.guis.tempProperties.tmpDepartment,
            "DEP_NAME", "DEP_PREFIX",null,"",null);

  }

  void btnExit_actionPerformed(ActionEvent e) {
    try{
      processhandler.template.Properties.getCenteralControler().goBack();
    }catch(Exception exp){
      exp.printStackTrace();
    }
  }
  boolean isFieldReady(){
    if(dbTxtFrom.getSelectedValue()==null){
      exgui.verification.VerifyLib.showAlert("Please Input ETD START DATE",
                                             "Please Input ETD START DATE");
      return false;
    }
    if(dbTxtTo.getSelectedValue()==null){
      exgui.verification.VerifyLib.showAlert("Please Input ETD END DATE",
                                             "Please Input ETD END DATE");

      return false;
    }
    if(df==null){
      df=new java.text.SimpleDateFormat("yyyy/MM/dd");
    }
    try{
      java.util.Date dateFrom = df.parse(txtEtdFrom.getText());
      java.util.Date dateTo   = df.parse(txtEtdTo.getText());
      if(dateFrom.after(dateTo)){
        exgui.verification.VerifyLib.showAlert("START DATE SHOULD BEFORE END DATE",
                                               "START DATE SHOULD BEFORE END DATE");
        return false;
      }
      //test if between same mounth
      if(!txtEtdTo.getText().substring(0,7).equals(txtEtdFrom.getText().substring(0,7))){
        exgui.verification.VerifyLib.showAlert("ETD DATE SHOULD IN SAME MONTH",
                                               "ETD DATE SHOULD IN SAME MONTH");
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
  public void ShowReport(String batchNo){
    DlgPrintBatchReport dlg=new DlgPrintBatchReport(
        util.PublicVariable.APP_FRAME,
        "Statement of Batch No",true);
      dlg.setSize(320,215);
      exgui.UIHelper.setToScreenCenter(dlg);
      dlg.txtBatchNo.setText(batchNo);
      dlg.show();
  }
  void btnExport_actionPerformed(ActionEvent e) {
     if(!isFieldReady())return;
     if(dbCbxDep.getSelectedValue()==null){
       exgui.verification.VerifyLib.showAlert("Please Select Department",
                                              "Please Select Department");
       return;
     }
     util.MiscFunc.showProcessingMessage();
     StringBuffer sb=new StringBuffer();
     sb.append("select ");
     sb.append("aa.ship_no,");
     sb.append("(select dep_prefix from department where dep_code=");
     sb.append("(select b.PROD_DEPTMENT from prod_head b where b.prod_head_pk=");
     sb.append("(select a.prod_head_pk from ship_sc a where a.ship_no=aa.ship_no and a.record_delete_flag='1' and rownum=1))) as dep_abbr, ");
     sb.append("to_char(ship_etd_date,'YYMM')  as yymm,");
     sb.append("(select prod_maker from prod_head where prod_head_pk=(select a.prod_head_pk from ship_sc a where a.ship_no=aa.ship_no and a.record_delete_flag='1' and rownum=1)) ");
     sb.append("as dbnt_bymkr_seq,");

     sb.append("(select nvl(bymkr_name2,bymkr_name) from buyer_maker where bymkr_seq=");
     sb.append("(select prod_maker from prod_head where prod_head_pk=(select a.prod_head_pk from ship_sc a where a.ship_no=aa.ship_no and a.record_delete_flag='1' and rownum=1)))");
     sb.append("as dbnt_bymkr_name, ");

     sb.append("(select bymkr_contact_person from buyer_maker where bymkr_seq=");
     sb.append("(select prod_maker from prod_head where prod_head_pk=(select a.prod_head_pk from ship_sc a where a.ship_no=aa.ship_no and a.record_delete_flag='1' and rownum=1)))");
     sb.append("as dbnt_attn,");
     sb.append("(select bymkr_warehouse from buyer_maker where bymkr_seq=");
     sb.append("(select prod_maker from prod_head where prod_head_pk=(select a.prod_head_pk from ship_sc a where a.ship_no=aa.ship_no and a.record_delete_flag='1' and rownum=1)))");
     sb.append("as buyer_wharehouse,");
     sb.append("(select pdxn.PROD_BRNCH_BRIEF from production pdxn where pdxn.prod_head_pk=(select a.prod_head_pk from ship_sc a where a.ship_no=aa.ship_no and a.record_delete_flag='1' and rownum=1))");
     sb.append("as dbnt_branch_brf,");
     sb.append("'' as dbnt_bymkr_div_code,");
     sb.append("'' as bank_desc,");
     sb.append("'' as dbbt_addr,");
     sb.append("(select b.PROD_DEPTMENT from prod_head b where b.prod_head_pk=(select a.prod_head_pk from ship_sc a where a.ship_no=aa.ship_no and a.record_delete_flag='1' and rownum=1))");
     sb.append("as dep_code,");
     sb.append("(select pdxn.PROD_SC_CURRENCY from production pdxn where pdxn.prod_head_pk=(select a.prod_head_pk from ship_sc a where a.ship_no=aa.ship_no and a.record_delete_flag='1' and rownum=1))");
     sb.append("as dbnt_currency,");
     sb.append("'' as dbnt_collect_desc,");
     sb.append("'1' as dbnt_dtl_kind,");
     sb.append("0 as dbnt_dtl_amt ,");//15
     sb.append("to_char(ship_etd_date,'YYYYMM')  as yyyymm,");//16
     sb.append("'' as dbntl_dtl_desc,");//17

     sb.append("aa.SHIP_FTY_INV,");//18
     sb.append("(select style.sty_po from style where style.prod_head_pk=(select a.prod_head_pk from ship_sc a where a.ship_no=aa.ship_no and a.record_delete_flag='1' and rownum=1) ");
     sb.append("and style.record_delete_flag='1' and rownum=1 ");
     sb.append(") as FIRST_PO ");//19
     sb.append(",get_srn_mkr_discount(aa.ship_no)+nvl(get_srn_diff_amt(aa.ship_no),0) as srn_mkr_discount ");//20
     sb.append("from shipping  aa ");
     if(util.PublicVariable.OPERATTING_CENTER.equals("001")||util.PublicVariable.OPERATTING_CENTER.equals("NTHK")){
        if(util.PublicVariable.OPERATTING_CENTER.equals("001")){
          sb.append("where aa.record_delete_flag='1' and aa.ship_no like 'ZATW");
        }else{
          sb.append("where aa.record_delete_flag='1' and aa.ship_no like 'ZNNT");
        }
        sb.append(dbCbxDep.getSelectedValue());
        sb.append("%' ");
        sb.append("and length(aa.ship_no)=12 ");
     }else{
       //ZMOFEEK702371
       sb.append("where aa.record_delete_flag='1' and substr(aa.ship_no,4,2) = '");
       sb.append(newtimes.accounting.debit_note.Constans.getCenterPrefix((String)util.PublicVariable.OPERATTING_CENTER));
       sb.append("'");
       sb.append(" and substr(aa.ship_no,6,2) = '");
       sb.append(dbCbxDep.getSelectedValue());
       sb.append("' ");
       sb.append(" and length(aa.ship_no)=13 ");
     }

     //make sure shipping have processed by " Daily Shipment Record for Account Department Use" by ALEX CHANG
     sb.append("and  aa.ship_status='Y' ");
     //=======================================================================================================//
     sb.append("and  aa.ship_etd_date >= to_date('");sb.append(txtEtdFrom.getText());sb.append("','yyyy/mm/dd') ");
     sb.append("and  aa.ship_etd_date <= to_date('");sb.append(txtEtdTo.getText());  sb.append("','yyyy/mm/dd') ");
     sb.append("and  aa.ship_no not in ( select ship_no from DEBITNOTE_MKR_FROM_SRN )");
     System.out.println(sb.toString());
     try{
       Vector vctShipDetails = exgui2.CONST.BASIC_MAIN_EJB.getDatas(
           util.PublicVariable.USER_RECORD,
           sb.toString(), 1, 99999);
        //if WareHouse field contains "Z" character,should skip it.
        newtimesejb.debitNote.DebitNoteFacdeHome dbHome =
            (newtimesejb.debitNote.DebitNoteFacdeHome)
            info_ejb.WeblogicServiceLocator.locateServiceHome(util.PublicVariable.
            SERVER_URL,
            "newtimesejb.debitNote.DebitNoteFacde");
        newtimesejb.debitNote.DebitNoteFacde ejb = dbHome.create();

      Vector vctOrgShipRec=new Vector();
      for(int i=0;i<vctShipDetails.size();i++){
            Record rec=(Record)vctShipDetails.get(i);
            //filter out the "Z"-warehoused
            String wareHouseData=(String)rec.get(6);
            if(wareHouseData==null)wareHouseData="";
            if(wareHouseData.indexOf("Z")!=-1||wareHouseData.indexOf("X")!=-1){
               continue;
            }

             Object makerDiscountAmt =rec.get(20);
             //if maker discount amount is not Zore,add to list to handle.
             if((null!=makerDiscountAmt) && (Double.parseDouble(makerDiscountAmt.toString())!=0)){
               rec.set(15, makerDiscountAmt);
               //init description field,
               String fty_inv_no=(String)rec.get(18);
               String first_po=(String)rec.get(19);

               if(fty_inv_no==null)fty_inv_no="";
               if(first_po==null)first_po="";
               String dbnt_dtl_desc="";//(fty_inv_no+BlankTail).substring(0,25)+first_po; let report generate contain,report will also generate some contain
               rec.set(17,dbnt_dtl_desc);
               vctOrgShipRec.add(rec);
             }
      }
      Vector vctToGenerateHead=new Vector();
      for(int i=0;i<vctOrgShipRec.size();i++){
        Record recTempShipRec = (Record)vctOrgShipRec.get(i);
        Record recDebitNoteHead = Constans.DEBIT_NOTE_HEAD_DBHANDLER.
            getBlankRecord();
        //debitnote No init by dep-brief and yymm,rest code will be generated by server component
        recDebitNoteHead.set(0,
                             ((String)recTempShipRec.get(1)) +
                             ((String)recTempShipRec.get(2)));
        recDebitNoteHead.set(1,"NEWTIMES INT''L");// recTempShipRec.get(7)); //branch brief,always NEWTIMES INT'L
        recDebitNoteHead.set(2, "MAKER"); //dbnt_bymkr_type--->always  maker
        recDebitNoteHead.set(3, recTempShipRec.get(3)); //maker seq
        recDebitNoteHead.set(4, recTempShipRec.get(4)); //maker name
        recDebitNoteHead.set(5, recTempShipRec.get(8)); //maker div code,should be blnak
        String addr = "";
        recDebitNoteHead.set(6, addr); //addr
        //recDebitNoteHead.set(7, recTempShipRec.get(5)); //attn //20071009,attn keep blank
        recDebitNoteHead.set(8, recTempShipRec.get(12)); //currency
        recDebitNoteHead.set(9, recTempShipRec.get(15)); //amt
        recDebitNoteHead.set(10, recTempShipRec.get(14)); //kind (moved to detail)
        recDebitNoteHead.set(11, recTempShipRec.get(13)); //collect desc
        recDebitNoteHead.set(12, new java.sql.Date(System.currentTimeMillis())); //print date
        recDebitNoteHead.set(13, util.PublicVariable.USER_RECORD.get(0)); //user name
        recDebitNoteHead.set(15, "1"); //record delete flag,set to "1",original is "-1"
        recDebitNoteHead.set(20,"");
        recDebitNoteHead.set(21, recTempShipRec.get(11)); //dep code
        recDebitNoteHead.set(22, recTempShipRec.get(16)); //yyyymm
        vctToGenerateHead.add(recDebitNoteHead);
     }
     if(vctToGenerateHead.size()==0){
       exgui.verification.VerifyLib.showAlert("No Maker Discount To Export",
                                              "No Maker Discount To Export");
       return;
     }


      HashMap hmPara=new HashMap();
      hmPara.put("DEBITNOTE_HEAD_RECORDS",vctToGenerateHead);
      hmPara.put("CEN_PREFIX",newtimes.accounting.debit_note.Constans.getCenterPrefix((String)util.PublicVariable.OPERATTING_CENTER));
      //hmPara.put("DBNT_DTL_DESC",getShipDetailDescBlock((String)recTempShipRec.get(0)));//<<-------------wait for final conculsion
      String destDbNo=ejb.exportSRN_MKR_2DebitNote(util.PublicVariable.USER_RECORD.get(0).toString(),
                             vctOrgShipRec,hmPara);
       if(exgui.verification.VerifyLib.showConfirm("Export Result BATCH #"+destDbNo+"\nDo You Want To Show Batch Report?",
                                                   "Export Result BATCH #"+destDbNo,false)){
         ShowReport(destDbNo);
       }
       /*
       exgui.verification.VerifyLib.showPlanMsg("Export Result BATCH #"+destDbNo,
                                                "Export Result BATCH #"+destDbNo);*/
       return;


    }catch(Exception exp){
      exp.printStackTrace();
    }finally{
      util.MiscFunc.hideProcessingMessage();
    }


  }

  void btnExportSingle_actionPerformed(ActionEvent e) {
    util.MiscFunc.showProcessingMessage();
    try{
      String srn = txtSRN.getText().trim();
      String orgDebitDtlSeq=null;
      if(srn.length()<12){
        exgui.verification.VerifyLib.showAlert("SRN Too Short","SRN Too Short");
        return;
      }
      StringBuffer sb = new StringBuffer();
      sb.append("select ");
      sb.append("aa.ship_no,");
      sb.append("(select dep_prefix from department where dep_code=");
      sb.append("(select b.PROD_DEPTMENT from prod_head b where b.prod_head_pk=");
      sb.append("(select a.prod_head_pk from ship_sc a where a.ship_no=aa.ship_no and a.record_delete_flag='1' and rownum=1))) as dep_abbr, ");
      sb.append("to_char(ship_etd_date,'YYMM')  as yymm,");
      sb.append("(select prod_maker from prod_head where prod_head_pk=(select a.prod_head_pk from ship_sc a where a.ship_no=aa.ship_no and a.record_delete_flag='1' and rownum=1)) ");
      sb.append("as dbnt_bymkr_seq,");

      sb.append("(select nvl(bymkr_name2,bymkr_name) from buyer_maker where bymkr_seq=");
      sb.append("(select prod_maker from prod_head where prod_head_pk=(select a.prod_head_pk from ship_sc a where a.ship_no=aa.ship_no and a.record_delete_flag='1' and rownum=1)))");
      sb.append("as dbnt_bymkr_name, ");

      sb.append("(select bymkr_contact_person from buyer_maker where bymkr_seq=");
      sb.append("(select prod_maker from prod_head where prod_head_pk=(select a.prod_head_pk from ship_sc a where a.ship_no=aa.ship_no and a.record_delete_flag='1' and rownum=1)))");
      sb.append("as dbnt_attn,");
      sb.append("(select bymkr_warehouse from buyer_maker where bymkr_seq=");
      sb.append("(select prod_maker from prod_head where prod_head_pk=(select a.prod_head_pk from ship_sc a where a.ship_no=aa.ship_no and a.record_delete_flag='1' and rownum=1)))");
      sb.append("as buyer_wharehouse,");
      sb.append("(select pdxn.PROD_BRNCH_BRIEF from production pdxn where pdxn.prod_head_pk=(select a.prod_head_pk from ship_sc a where a.ship_no=aa.ship_no and a.record_delete_flag='1' and rownum=1))");
      sb.append("as dbnt_branch_brf,");
      sb.append("'' as dbnt_bymkr_div_code,");
      sb.append("'' as bank_desc,");
      sb.append("'' as dbbt_addr,");
      sb.append("(select b.PROD_DEPTMENT from prod_head b where b.prod_head_pk=(select a.prod_head_pk from ship_sc a where a.ship_no=aa.ship_no and a.record_delete_flag='1' and rownum=1))");
      sb.append("as dep_code,");
      sb.append("(select pdxn.PROD_SC_CURRENCY from production pdxn where pdxn.prod_head_pk=(select a.prod_head_pk from ship_sc a where a.ship_no=aa.ship_no and a.record_delete_flag='1' and rownum=1))");
      sb.append("as dbnt_currency,");
      sb.append("'' as dbnt_collect_desc,");
      sb.append("'1' as dbnt_dtl_kind,");
      sb.append("0 as dbnt_dtl_amt ,"); //15
      sb.append("to_char(ship_etd_date,'YYYYMM')  as yyyymm,"); //16
      sb.append("'' as dbntl_dtl_desc,"); //17
      sb.append("aa.SHIP_FTY_INV,"); //18
      sb.append("(select style.sty_po from style where style.prod_head_pk=(select a.prod_head_pk from ship_sc a where a.ship_no=aa.ship_no and a.record_delete_flag='1' and rownum=1) ");
      sb.append("and style.record_delete_flag='1' and rownum=1 ");
      sb.append(") as FIRST_PO "); //19
      sb.append(",(select b.DBNT_DTL_SEQ from DEBITNOTE_MKR_FROM_SRN a,DEBITNOTE_DETAIL b where a.dbnt_no=b.dbnt_no and a.ship_no='");
      sb.append(srn);
      sb.append("' and rownum=1 ) as DBNT_DTL_SEQ ");//20
      sb.append(",(select count(*) from DEBITNOTE_MKR_FROM_SRN where DEBITNOTE_MKR_FROM_SRN.ship_no=aa.ship_no) as conv_count ");//21
      sb.append("from shipping  aa ");
      sb.append("where aa.record_delete_flag='1' and aa.ship_no ='");
      sb.append(srn);
      sb.append("' ");
      sb.append("and  aa.ship_status='Y' ");
      Vector vctORG=exgui2.CONST.BASIC_MAIN_EJB.getDatas(util.PublicVariable.USER_RECORD,sb.toString(), 1, 9999);
      if(vctORG.size()==0){
        exgui.verification.VerifyLib.showAlert("SRN Not Exist\nOr Not Exported To Shipment Report",
                                               "SRN Not Exist,Or Not Exported To Shipment Report");
        return ;
      }
      Record rec=(Record)vctORG.get(0);
      String wareHouse=(String)rec.get(6);
      if(wareHouse==null)wareHouse="";
      if(wareHouse.indexOf("Z")!=-1||wareHouse.indexOf("X")!=-1){
        exgui.verification.VerifyLib.showAlert("Maker WareHouse Type is \"Z\" or \"X\"\nCan Not Export ","Maker WareHouse Type is \"Z\" or \"X\"");
        return;
      }
      if(rec.getInt(21)>0){
        Object ObjOrgDbDtlSeq=rec.get(20);;
        orgDebitDtlSeq=(ObjOrgDbDtlSeq==null)?null:ObjOrgDbDtlSeq.toString();
        if(!exgui.verification.VerifyLib.showConfirm("SRN Already Exported\nDo You Want to Re-Export Again ?","SRN EXPORTED",false))return;
      }
      String srnArrDest[]=new String[1];
      srnArrDest[0]=srn;
      newtimesejb.debitNote.DebitNoteFacdeHome dbHome =
          (newtimesejb.debitNote.DebitNoteFacdeHome)
          info_ejb.WeblogicServiceLocator.locateServiceHome(util.PublicVariable.
          SERVER_URL,
          "newtimesejb.debitNote.DebitNoteFacde");
      newtimesejb.debitNote.DebitNoteFacde ejb = dbHome.create();
      java.util.HashMap param = new java.util.HashMap();
      param.put("SRN_ARR", srnArrDest);
      java.util.HashMap hm = ejb.getShipMkrDiscount(param);
      String shipMakerAmt=(String)hm.get(srn);
      if(Double.parseDouble(shipMakerAmt)==0){
        exgui.verification.VerifyLib.showAlert("Maker Discount Amount Is Zero.\nNo Need To Export",
                                               "Maker Discount Amount Is Zero");
        return;
      }
      String fty_inv_no=(String)rec.get(18);
      String first_po=(String)rec.get(19);
      if(fty_inv_no==null)fty_inv_no="";
      if(first_po==null)first_po="";
      String dbnt_dtl_desc="";//(fty_inv_no+BlankTail).substring(0,25)+first_po; user determ & report generate

      if(orgDebitDtlSeq!=null){
        //rec.set(17,dbnt_dtl_desc);
        DbDebitNoteDetail dbTempDtl=new DbDebitNoteDetail();
        Record recDbDtl=dbTempDtl.getRecordByPk(Integer.parseInt(orgDebitDtlSeq));
        recDbDtl.set(5,dbnt_dtl_desc);//DBNT_DTL_DESC
        recDbDtl.set(4,shipMakerAmt);
        recDbDtl.set(12,util.PublicVariable.USER_RECORD.get(0));
        Vector vct2update=new Vector();
        vct2update.add(recDbDtl);
        dbTempDtl.updateRecords(vct2update);
        exgui.verification.VerifyLib.showPlanMsg("RE-EXPORT OK","RE-EXPORT OK");
        return;
      }else{

        Record recOrgInVct=(Record)vctORG.get(0);
        recOrgInVct.set(17,dbnt_dtl_desc);
        recOrgInVct.set(15,shipMakerAmt);
        vctORG.set(0,recOrgInVct);
        Vector vctToGenerateHead=new Vector();
          Record recTempShipRec = (Record)vctORG.get(0);
          Record recDebitNoteHead = Constans.DEBIT_NOTE_HEAD_DBHANDLER.
              getBlankRecord();
          //debitnote No init by dep-brief and yymm,rest code will be generated by server component
          recDebitNoteHead.set(0,
                               ((String)recTempShipRec.get(1)) +
                               ((String)recTempShipRec.get(2)));

          recDebitNoteHead.set(1,"NEWTIMES INT''L");// recTempShipRec.get(7)); //branch brief,always NEWTIMES INT'L
          recDebitNoteHead.set(2, "MAKER"); //dbnt_bymkr_type--->always  maker
          recDebitNoteHead.set(3, recTempShipRec.get(3)); //maker seq
          recDebitNoteHead.set(4, recTempShipRec.get(4)); //maker name
          recDebitNoteHead.set(5, recTempShipRec.get(8)); //maker div code,should be blnak
          String addr = "";
          recDebitNoteHead.set(6, addr); //addr
          //recDebitNoteHead.set(7, recTempShipRec.get(5)); //attn //20071009 attn keep blank
          recDebitNoteHead.set(8, recTempShipRec.get(12)); //currency
          recDebitNoteHead.set(9, recTempShipRec.get(15)); //amt
          recDebitNoteHead.set(10, recTempShipRec.get(14)); //kind (moved to detail)
          recDebitNoteHead.set(11, recTempShipRec.get(13)); //collect desc
          recDebitNoteHead.set(12, new java.sql.Date(System.currentTimeMillis())); //print date
          recDebitNoteHead.set(13, util.PublicVariable.USER_RECORD.get(0)); //user name
          recDebitNoteHead.set(15, "1"); //record delete flag,set to "1",original is "-1"
          recDebitNoteHead.set(20,"");
          recDebitNoteHead.set(21, recTempShipRec.get(11)); //dep code
          recDebitNoteHead.set(22, recTempShipRec.get(16)); //yyyymm
          vctToGenerateHead.add(recDebitNoteHead);

       if(vctToGenerateHead.size()==0){
         exgui.verification.VerifyLib.showAlert("No Maker Discount To Export",
                                                "No Maker Discount To Export");
         return;
       }


        HashMap hmPara=new HashMap();
        hmPara.put("DEBITNOTE_HEAD_RECORDS",vctToGenerateHead);
        hmPara.put("CEN_PREFIX",newtimes.accounting.debit_note.Constans.getCenterPrefix((String)util.PublicVariable.OPERATTING_CENTER));
        String destDbNo=ejb.exportSRN_MKR_2DebitNote(util.PublicVariable.USER_RECORD.get(0).toString(),
                               vctORG,hmPara);
         exgui.verification.VerifyLib.showPlanMsg("Export Result BATCH #"+destDbNo,
                                                  "Export Result BATCH #"+destDbNo);
         return;




      }

    }catch(Exception exp){
      exp.printStackTrace();
    }finally{
      util.MiscFunc.hideProcessingMessage();
    }

  }
  void bntStateMemtReport_actionPerformed(ActionEvent e) {
    ShowReport(null);
  }
}
