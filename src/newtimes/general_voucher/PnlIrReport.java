package newtimes.general_voucher;

import java.awt.*;
import exgui.*;
import javax.swing.*;
import newtimes.preproduction.buyermakerselect.*;
import javax.swing.border.*;
import java.awt.event.*;
import java.util.*;
/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class PnlIrReport extends JPanel {
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel1 = new BlueBkgWhiteCharLabel();
  //JPanel jPanel1 = new JPanel();
  Panel2List pnlList;
  WhiteBkgBlueCharLabel whiteBkgBlueCharLabel1 = new WhiteBkgBlueCharLabel();
  SelectBuyerMaker slkBuyer = new SelectBuyerMaker();
  SelectBuyerMaker slkMaker = new SelectBuyerMaker();
  WhiteBkgBlueCharLabel whiteBkgBlueCharLabel2 = new WhiteBkgBlueCharLabel();
  Border border1;
  TitledBorder titledBorder1;
  WhiteBkgBlueCharLabel whiteBkgBlueCharLabel3 = new WhiteBkgBlueCharLabel();
  JTextField txtEtdFrom = new JTextField();
  JTextField txtEtdTo = new JTextField();
  WhiteBkgBlueCharLabel whiteBkgBlueCharLabel4 = new WhiteBkgBlueCharLabel();
  JButton btnExit = new JButton();
  JButton btnQry = new JButton();
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel2 = new BlueBkgWhiteCharLabel();
  JComboBox cbxIrStatus = new JComboBox(new String[]{"ALL","YES","NO"});
  JComboBox cbxPrinted = new JComboBox(new String[]{"ALL","YES","NO"});
  JTextField inv_txt[]=new JTextField[7];
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel3 = new BlueBkgWhiteCharLabel();
   static int IR_CODE_COLUMN=9;
  static int PRINT_COUMN=10;
  static boolean isInit=true;

  JLabel inv_lbl = new JLabel();

  public PnlIrReport() {
    try {
      isInit=true;
      jbInit();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }

  void jbInit() throws Exception {
    border1 = BorderFactory.createEmptyBorder();
    titledBorder1 = new TitledBorder(new EtchedBorder(EtchedBorder.RAISED,Color.white,new Color(141, 141, 156)),"ETD DATE");
    blueBkgWhiteCharLabel1.setFont(new java.awt.Font("細明體", 0, 24));
    blueBkgWhiteCharLabel1.setText("驗貨追蹤表");
    blueBkgWhiteCharLabel1.setBounds(new Rectangle(-1, 9, 801, 31));
    this.setBackground(new Color(202, 202, 224));
    this.setLayout(null);
    //jPanel1.setBounds(new Rectangle(12, 133, 777, 446));
    whiteBkgBlueCharLabel1.setText("Buyer:");
    whiteBkgBlueCharLabel1.setBounds(new Rectangle(10, 44, 68, 23));
    slkBuyer.setBounds(new Rectangle(79, 44, 161, 23));
    slkMaker.setBounds(new Rectangle(322, 44, 161, 23));
    whiteBkgBlueCharLabel2.setBounds(new Rectangle(253, 44, 68, 23));
    whiteBkgBlueCharLabel2.setText("FTY:");
    whiteBkgBlueCharLabel3.setText("ETD FROM:");
    whiteBkgBlueCharLabel3.setBounds(new Rectangle(497, 44, 82, 23));
    txtEtdFrom.setText("");
    txtEtdFrom.setBounds(new Rectangle(581, 44, 69, 23));
    txtEtdTo.setBounds(new Rectangle(692, 44, 74, 23));
    txtEtdTo.setText("2011/12/31");
    txtEtdTo.setText("");
    whiteBkgBlueCharLabel4.setBounds(new Rectangle(650, 44, 40, 23));
    whiteBkgBlueCharLabel4.setText("TO:");
    btnExit.setBounds(new Rectangle(694, 73, 88, 27));
    btnExit.setFont(new java.awt.Font("Dialog", 1, 14));
    btnExit.setForeground(Color.red);
    btnExit.setText("EXIT");
    btnExit.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnExit_actionPerformed(e);
      }
    });
    btnQry.setText("Query");
    btnQry.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnQry_actionPerformed(e);
      }
    });


    btnQry.setFont(new java.awt.Font("Dialog", 1, 14));
    btnQry.setForeground(Color.black);
    btnQry.setBounds(new Rectangle(596, 73, 88, 27));
    blueBkgWhiteCharLabel2.setText("I / R");
    blueBkgWhiteCharLabel2.setBounds(new Rectangle(10, 78, 68, 23));
    cbxIrStatus.setBounds(new Rectangle(77, 78, 158, 23));
    cbxPrinted.setBounds(new Rectangle(322, 78, 161, 23));
    blueBkgWhiteCharLabel3.setBounds(new Rectangle(253, 78, 68, 23));
    blueBkgWhiteCharLabel3.setText("Printed");

    inv_lbl.setBackground(Color.white);
    inv_lbl.setFont(new java.awt.Font("Dialog", 1, 12));
    inv_lbl.setForeground(new Color(143, 143, 188));
    inv_lbl.setDebugGraphicsOptions(0);
    inv_lbl.setOpaque(true);
    inv_lbl.setHorizontalAlignment(SwingConstants.CENTER);
    inv_lbl.setHorizontalTextPosition(SwingConstants.TRAILING);
    inv_lbl.setText("INVOICE :");
    inv_lbl.setBounds(new Rectangle(11, 110, 66, 22));
    for (int i=0;i<7;i++) {
         inv_txt[i]=new JTextField();
    }
    inv_txt[0].setBounds(new Rectangle(79, 110, 97, 22));
    inv_txt[1].setBounds(new Rectangle(179, 110, 97, 22));
    inv_txt[2].setBounds(new Rectangle(279, 110, 97, 22));
    inv_txt[3].setBounds(new Rectangle(379, 110, 97, 22));
    inv_txt[4].setBounds(new Rectangle(479, 110, 97, 22));
    inv_txt[5].setBounds(new Rectangle(579, 110, 97, 22));
    inv_txt[6].setBounds(new Rectangle(679, 110, 97, 22));

    this.add(blueBkgWhiteCharLabel1, null);
    //this.add(jPanel1, null);
    this.add(whiteBkgBlueCharLabel1, null);
    this.add(slkBuyer, null);
    this.add(slkMaker, null);
    this.add(whiteBkgBlueCharLabel2, null);
    this.add(whiteBkgBlueCharLabel3, null);
    this.add(txtEtdFrom, null);
    this.add(whiteBkgBlueCharLabel4, null);
    this.add(txtEtdTo, null);
    this.add(btnExit, null);
    this.add(btnQry, null);
    this.add(blueBkgWhiteCharLabel2, null);
    this.add(cbxIrStatus, null);
    this.add(cbxPrinted, null);
    this.add(blueBkgWhiteCharLabel3, null);

    this.add(inv_lbl, null);
    for (int i=0;i<7;i++){
         this.add(inv_txt[i], null);
    }
    slkBuyer.init("",null,slkBuyer.TYPE_BUYER,true);
    slkMaker.init("",null,slkMaker.TYPE_MAKER,true);
    Object vftxtDate = exgui.verification.CellFormat.getDateStringFormaterAllowNull();

    exgui.DataBindTextWithChecker dbTxtFrom=new exgui.DataBindTextWithChecker(txtEtdFrom, "",
                                        null, 10,
                                        (exgui.Object2String)vftxtDate,
                                        (exgui.ultratable.CellTxtEditorFormat)
                                        vftxtDate);

    exgui.DataBindTextWithChecker dbTxtTo=new exgui.DataBindTextWithChecker(txtEtdTo, "",
                                        null, 10,
                                        (exgui.Object2String)vftxtDate,
                                        (exgui.ultratable.CellTxtEditorFormat)
                                        vftxtDate);
            Db2handle db=new Db2handle();
            util.InsertionOrderedHashMap iso=new util.InsertionOrderedHashMap();
            iso.put(" BUYER ","BUYER");
            iso.put(" FTY   ","MAKER");
            iso.put(" INV # ","SHIP_NO");
            iso.put("O.B.D.","SHIP_ETD_DATE");
            iso.put(" S/C#    ","STY_SC_NO");
            iso.put(" STYLE ","sty_style");
            iso.put(" PO#   ","sty_po");
            iso.put("SH QTY","SHIP_STY_TOTAL_QTY");
            iso.put("UNIT","STY_UNIT");
            iso.put("IR","IR_CODE");
            iso.put("PRNT","IR_PRINTED");
             pnlList=new Panel2List(db,99999,iso,new Hashtable());
            pnlList.setBounds(new Rectangle(5, 133, 777, 446));
            this.add(pnlList,null);
            pnlList.firstPage();
   isInit=false;
  }

  void btnExit_actionPerformed(ActionEvent e) {
    //have to test if list tabel editor is context modified
    try{
       if(pnlList.isContextModified()){
         if(!exgui.verification.VerifyLib.showConfirm("內容有修改但未儲存\n確定要離開嗎?","確定要離開嗎?",false))return;
       }
       processhandler.template.Properties.getCenteralControler().goBack();
    }catch(Exception exp){
      exp.printStackTrace();
     }

  }

  class Db2handle extends exgui.ultratable.PagedDataFactoryAdapter{
      public void updateRecords(Vector vct)throws Exception{
          //filter records.
          /*
          Vector vct2Proc=new Vector();
          for(int i=0;i<vct.size();i++){
            database.datatype.Record rec=(database.datatype.Record)vct.get(i);
          }
          */
         if(isInit)return;
         Vector vct2proc=new Vector();
         for(int i=0;i<pnlList.getJtable().getRowCount();i++){
            database.datatype.Record rec=
                (database.datatype.Record)pnlList.getDisplayingRecords().get(i);

            if(rec.getModifiedFields().size()>0 || pnlList.hmProccedRec.containsKey(rec.get(0).toString())){
               database.datatype.Record rec2proc=
                   (database.datatype.Record)util.MiscFunc.deepCopy(rec);
               rec2proc.set(0,rec.get(0));//pk
               Object objOrgIcCode=pnlList.getJtable().getValueAt(i,IR_CODE_COLUMN);
               if(objOrgIcCode!=null && objOrgIcCode.toString().equalsIgnoreCase("false")){
                 rec2proc.set("ir_code",null);
               }
               if(objOrgIcCode!=null && objOrgIcCode.toString().equalsIgnoreCase("true")){
                 rec2proc.set("ir_code","1");
               }

               objOrgIcCode=pnlList.getJtable().getValueAt(i,PRINT_COUMN);
               if(objOrgIcCode!=null && objOrgIcCode.toString().equalsIgnoreCase("false")){
                 rec2proc.set("ir_printed",null);
               }
               if(objOrgIcCode!=null && objOrgIcCode.toString().equalsIgnoreCase("true")){
                 rec2proc.set("ir_printed","1");
               }

               rec2proc.getFieldName().add("RECORD_CREATE_USER");
               rec2proc.getFieldName().add("RECORD_CREATE_DATE");
               rec2proc.getFieldName().add("RECORD_MODIFY_USER");
               rec2proc.getFieldName().add("RECORD_MODIFY_DATE");
               rec2proc.getFieldName().add("RECORD_DELETE_FLAG");
               rec2proc.getValueFields().add(null);
               rec2proc.getValueFields().add(null);
               rec2proc.getValueFields().add(null);
               rec2proc.getValueFields().add(null);
               rec2proc.getValueFields().add(null);
               rec2proc.set("record_create_user",util.PublicVariable.USER_RECORD.get(0));
               rec2proc.set("record_create_date",new java.sql.Date(System.currentTimeMillis()));
               rec2proc.set("record_delete_flag","1");

               //System.out.println(rec2proc.toString());
               vct2proc.add(rec2proc);
            }
         }

            if(vct2proc.size()==0){
              exgui.verification.VerifyLib.showAlert("No Records Modified","No Modified to update");
              return;
            }


          newtimesejb.TPE_MIS.TpeMisFuncHome ejbHome=
              (newtimesejb.TPE_MIS.TpeMisFuncHome)
              info_ejb.WeblogicServiceLocator.locateServiceHome(util.PublicVariable.SERVER_URL,
              "newtimesejb.TPE_MIS.TpeMisFunc");
          newtimesejb.TPE_MIS.TpeMisFunc ejb=ejbHome.create();
          java.util.HashMap hm=new java.util.HashMap();
          hm.put("TPEMISCFUNC_ACTION_CODE","HANDLE_INSPECTION_REPORT");
          hm.put("INSPECTION_REPORT_VECTOR",vct2proc);
          ejb.tpeMisFunc(hm);


      }
      public Vector getRecords(int rows,int count)throws Exception{
        StringBuffer sb = new StringBuffer();
        sb.append("select ");
        sb.append("a.ship_style_pk, ");
        sb.append("nvl(BUYER.BYMKR_CHINESE_BRIEF,BUYER.BYMKR_BRIEF) buyer, ");
        sb.append("nvl(maker.BYMKR_CHINESE_BRIEF,MAKER.BYMKR_BRIEF) maker, ");
        sb.append("c.ship_no,c.ship_etd_date, ");
        sb.append("e.sty_sc_no, ");
        sb.append("e.sty_style, ");
        sb.append("e.sty_po, ");
        sb.append("A.SHIP_STY_TOTAL_QTY, ");
        sb.append("E.STY_UNIT, ");
        sb.append("(select  ir.ir_code from INSPECTION_REPORT ir where ir.ship_style_pk=a.ship_style_pk) as ir_code, ");
        sb.append("(select  ir.ir_printed from INSPECTION_REPORT ir where ir.ship_style_pk=a.ship_style_pk) as ir_printed ");
        sb.append("from ");
        sb.append("ship_style a,ship_sc b,shipping c,prod_head d,style e,buyer_maker buyer,buyer_maker maker ");
        sb.append("where ");
        if (isInit) {
          sb.append(" 1<>1 ");
        } else {
          sb.append("A.STY_SEQ =E.STY_SEQ ");
          sb.append("and E.PROD_HEAD_PK=D.PROD_HEAD_PK ");
          sb.append("and D.PROD_HEAD_PK=B.PROD_HEAD_PK ");
          sb.append("and A.SHIP_SC_PK=B.SHIP_SC_PK ");
          sb.append("and B.SHIP_NO=C.SHIP_NO ");
          sb.append("and d.prod_buyer=buyer.bymkr_seq ");
          sb.append("and d.prod_maker=maker.bymkr_seq ");
          sb.append("and b.ship_no like 'ZATW%' ");
          Object qryBuyer = slkBuyer.getSelectedValue();
          if (qryBuyer != null) {
            sb.append(" and d.prod_buyer=");
            sb.append(qryBuyer.toString());
            sb.append("  ");
          }
          Object qryMaker = slkMaker.getSelectedValue();
          if (qryMaker != null) {
            sb.append(" and d.prod_maker=");
            sb.append(qryMaker.toString());
            sb.append("  ");
          }
          if (txtEtdFrom.getText().trim().length() == 10) {
            sb.append(" and c.ship_etd_date>=to_date('");
            sb.append(txtEtdFrom.getText().trim());
            sb.append("','yyyy/mm/dd') ");
          }
          if (txtEtdTo.getText().trim().length() == 10) {
            sb.append(" and c.ship_etd_date<=to_date('");
            sb.append(txtEtdTo.getText().trim());
            sb.append("','yyyy/mm/dd') ");
          }
          String irCode = cbxIrStatus.getSelectedItem().toString();
          if ("YES".equalsIgnoreCase(irCode)) {
            sb.append(" and (select  ir.ir_code from INSPECTION_REPORT ir where ir.ship_style_pk=a.ship_style_pk) ='1' ");
          }
          if ("NO".equalsIgnoreCase(irCode)) {
            sb.append(" and (select  ir.ir_code from INSPECTION_REPORT ir where ir.ship_style_pk=a.ship_style_pk) is null ");
          }

          String printcode = cbxPrinted.getSelectedItem().toString();
          if ("YES".equalsIgnoreCase(printcode)) {
            sb.append(" and (select  ir.ir_printed from INSPECTION_REPORT ir where ir.ship_style_pk=a.ship_style_pk) ='1' ");
          }
          if ("NO".equalsIgnoreCase(printcode)) {
            sb.append(" and (select  ir.ir_printed from INSPECTION_REPORT ir where ir.ship_style_pk=a.ship_style_pk) is null ");
          }
          boolean inv_is_null = true;
          String filter_by_inv="";
          for (int i=0;i<7;i++) {
               if (inv_txt[i].getText().length()>0){
                   inv_is_null=false;
                   filter_by_inv=filter_by_inv+",'"+inv_txt[i].getText()+"'";
               }
          }
          if (!inv_is_null) {
              filter_by_inv=" and c.ship_no in ("+filter_by_inv.replaceFirst(",","")+")";
              sb.append(filter_by_inv);
          }

          sb.append(" order by nvl(maker.BYMKR_CHINESE_BRIEF,MAKER.BYMKR_BRIEF),c.ship_etd_date ");

        }
        util.MiscFunc.showProcessingMessage();
       //sb.append("and b.record_create_date >=to_date('2011/07/01','yyyy/mm/dd') ");
       Vector vct=exgui2.CONST.BASIC_MAIN_EJB.getDatas(
          util.PublicVariable.USER_RECORD,sb.toString(),1,9999999
          );
       util.MiscFunc.hideProcessingMessage();
      return vct;
    }
  }

  class Panel2List extends processhandler.template.PnlTableEditor

      {
      HashMap hmProccedRec=null;
      public Panel2List(exgui.ultratable.PagedDataFactory pagedDataFxy,
                        int rowCounts,util.InsertionOrderedHashMap columnMapping,
                       java.util.Hashtable object2StringConvertor){
          super(pagedDataFxy, rowCounts, columnMapping, object2StringConvertor);
          JButton btnChkUnChkIR=new JButton("CHECK/UNCHK IR");
          //JButton btnChkUnChkPrint=new JButton("CHECK/UNCHK PRINT");
          JButton btnPrint=new JButton("Print High-Lighted Row(s)");
          JButton btnUpdate=new JButton("UPDATE");
          getLowerRightPanel().removeAll();
          getPanelContainsButtons().removeAll();
          getPanelContainsButtons().add(btnChkUnChkIR);
          //getPanelContainsButtons().add(btnChkUnChkPrint);
          getPanelContainsButtons().add(btnPrint);
          getPanelContainsButtons().add(btnUpdate);
          btnChkUnChkIR.addMouseListener(new java.awt.event.MouseAdapter(){
             public void mouseClicked(java.awt.event.MouseEvent me){
               if(getJtable().getSelectedRowCount()==0){
                 exgui.verification.VerifyLib.showAlert("Please Select Rows to Process","Please Select Rows to Process");
                 return;
               }
               int rows[]=getJtable().getSelectedRows();
               for(int i=0;i<rows.length;i++){
                  Object objIRvalue=getJtable().getValueAt(rows[i],IR_CODE_COLUMN);
                  Object orgValue=new Boolean(false);
                  if(objIRvalue!=null ){
                     if(objIRvalue.toString().equalsIgnoreCase("1"))orgValue=new Boolean(true);
                     if(objIRvalue.toString().equalsIgnoreCase("true"))orgValue=new Boolean(true);
                  }
                  orgValue=new Boolean(!((Boolean)orgValue).booleanValue());
                  getJtable().setValueAt(orgValue,rows[i],IR_CODE_COLUMN);
               }
             }
          });

          //check & uncheck print is based on the high-lighted row,if prressed,and print.save to database.
          btnPrint.addMouseListener(new java.awt.event.MouseAdapter(){
        public void mouseClicked(java.awt.event.MouseEvent me){
          if (getJtable().getSelectedRowCount() == 0) {
            exgui.verification.VerifyLib.showAlert(
                "Please Select Rows to Process",
                "Please Select Rows to Process");
            return;
          }
          StringBuffer sbShipStylePk=new StringBuffer();
          int rows[] = getJtable().getSelectedRows();
          sbShipStylePk.append("[");
          for (int i = 0; i < rows.length; i++) {
            Object objPrintvalue = getJtable().getValueAt(rows[i], PRINT_COUMN);
            Object orgValue = new Boolean(false);
            if (objPrintvalue != null) {
              if (objPrintvalue.toString().equalsIgnoreCase("1"))orgValue = new  Boolean(true);
              if (objPrintvalue.toString().equalsIgnoreCase("true"))orgValue = new  Boolean(true);
            }

            if(!orgValue.toString().equalsIgnoreCase("TRUE")){
              getJtable().setValueAt(new Boolean(true), rows[i], PRINT_COUMN);
            }
            database.datatype.Record rec=(database.datatype.Record)getDisplayingRecords().get(rows[i]);
            if(i>0)sbShipStylePk.append(",");
            sbShipStylePk.append(String.valueOf(rec.getLong(0)));
          }
          sbShipStylePk.append("]");
            try{
               pnlList.getMultiEditorJTable().setColumnEditable("PRNT");
               hmProccedRec=new HashMap();
               doUpdate();
               pnlList.getMultiEditorJTable().setColumnUnEditable("PRNT");
               doPrint(sbShipStylePk.toString());
            }catch(Exception exp){
              exp.printStackTrace();
              exgui.verification.VerifyLib.showAlert("Update Failed!!\nPlease Contact System Manager","Update Failed");
            }
            //send to report viewer...

        }



          });

          /*
          btnChkUnChkPrint.addMouseListener(new java.awt.event.MouseAdapter(){
          public void mouseClicked(java.awt.event.MouseEvent me){
            if(getJtable().getSelectedRowCount()==0){
              exgui.verification.VerifyLib.showAlert("Please Select Rows to Process","Please Select Rows to Process");
              return;
            }
            int rows[]=getJtable().getSelectedRows();
            for(int i=0;i<rows.length;i++){
               Object objPrintvalue=getJtable().getValueAt(rows[i],9);
               Object orgValue=new Boolean(false);
               if(objPrintvalue!=null ){
                  if(objPrintvalue.toString().equalsIgnoreCase("1"))orgValue=new Boolean(true);
                  if(objPrintvalue.toString().equalsIgnoreCase("true"))orgValue=new Boolean(true);
               }
               orgValue=new Boolean(!((Boolean)orgValue).booleanValue());
               getJtable().setValueAt(orgValue,rows[i],9);
            }


          }
       });
       */
       btnUpdate.addMouseListener(new java.awt.event.MouseAdapter(){
          public void mouseClicked(java.awt.event.MouseEvent me){
            try{
               hmProccedRec=new HashMap();
                doUpdate();
                pnlList.reload();
            }catch(Exception exp){
                   exp.printStackTrace();
                   util.ExceptionLog.exp2File(exp,"");
                   exgui.verification.VerifyLib.showAlert("Update Failed!!\nPlease Contact System Manager",
                                                          "Update Failed");
                   return;
            }

          }
        });


      }
      public void makeTable(Vector vct){
        super.makeTable(vct);
         getJtable().getColumnModel().getColumn(0).setPreferredWidth(72);
         getJtable().getColumnModel().getColumn(1).setPreferredWidth(82);
         getJtable().getColumnModel().getColumn(2).setPreferredWidth(100);
         //3 ,OBD
         getJtable().getColumnModel().getColumn(3).setPreferredWidth(66);
         getJtable().getColumnModel().getColumn(4).setPreferredWidth(100);
         getJtable().getColumnModel().getColumn(5).setPreferredWidth(120);
         getJtable().getColumnModel().getColumn(6).setPreferredWidth(85);
         getJtable().getColumnModel().getColumn(7).setPreferredWidth(48);
         getJtable().getColumnModel().getColumn(8).setPreferredWidth(35);
         getJtable().getColumnModel().getColumn(9).setPreferredWidth(17);
         getJtable().getColumnModel().getColumn(10).setPreferredWidth(38);
      }
      void doPrint(String shipStylepk){

        try{
          //show debit note report,
          String tempURL= newtimes.production.report.ReportProxyEngine.reportServerURL ;
          newtimes.production.report.ReportProxyEngine.reportServerURL="http://rpt2.nttpe.com.tw:9000/?file:///rpt//";
          com.inet.viewer.ReportViewerBean viewer = util.PublicVariable.inet_report_viewer;
          String rpt_name ="ACC_IR.rpt";
          java.util.HashMap hm = new java.util.HashMap();
          hm.put("P_SHIP_STY_PK",shipStylepk);
          newtimes.production.report.ReportCmdSet.myReportEngin.
              setReportNameAndParas(viewer, rpt_name, hm);
          viewer.setHasGroupTree(false);
          viewer.start();
          JPanel pnl = new JPanel();
          pnl.setLayout(new java.awt.BorderLayout());
          pnl.add(viewer);
          newtimes.preproduction.guis.DlgViewRpt dlg = new newtimes.preproduction.
              guis.DlgViewRpt(
              processhandler.template.Properties.getMainFrame(),
              "IR REPORT",
              pnl, true);
          dlg.setSize(700, 500);
          dlg.show();
          newtimes.production.report.ReportProxyEngine.reportServerURL=tempURL;
        }catch(Exception exp){
          exp.printStackTrace();

        }
      }
      public void doPrint(){}
      public int getEachPageRowCount(){return _rowCounts;}
      public Hashtable getObject2StringConvertor() {return klmObjKvtHt;}
      public util.InsertionOrderedHashMap getHeadColumnMap(){return tblHeadColumn;}
      public exgui.ultratable.PagedDataFactory getPagedDataFactory(){return dbHandler;}
      public database.datatype.Record setObject2Record(database.datatype.Record rec,int col,Object obj){
         try{
           rec.set(storedRecordColumn[col],obj);
           hmProccedRec.put(rec.get(0).toString(),rec.get(0).toString());
           return rec;
         }catch(Exception exp){
           exp.printStackTrace();
           return null;
         }
      }
      public void refineEditors(exgui.ultratable.MultiEditorJTable me ){
        me.setTextEditorVerifiers(getObject2StringConvertor());
        me.addCheckbox(IR_CODE_COLUMN,"1");
        me.addCheckbox(PRINT_COUMN,"1");
        me.setColumnUnEditable("PRNT");
      }
    }

  void btnQry_actionPerformed(ActionEvent e) {
    pnlList.reload();
  }


}
