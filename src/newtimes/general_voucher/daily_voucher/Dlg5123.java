package newtimes.general_voucher.daily_voucher;

import java.awt.*;
import javax.swing.*;
import exgui.*;
import newtimes.preproduction.buyermakerselect.*;
import java.awt.event.*;
import exgui.*;
import javax.swing.border.*;
import java.awt.event.*;
import processhandler.template.PnlFieldsEditor;
import exgui.ultratable.*;
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

public class Dlg5123 extends JDialog {
  //JPanel panel1 = new JPanel();
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel1 = new BlueBkgWhiteCharLabel();
  JTextField txtSRN = new JTextField();
  //SelectBuyerMaker slkBuyer = new SelectBuyerMaker();
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel2 = new BlueBkgWhiteCharLabel();
  WhiteBkgBlueCharLabel whiteBkgBlueCharLabel1 = new WhiteBkgBlueCharLabel();
  JTextField txtInvAmt = new JTextField();
  JTextField txtBuyerName = new JTextField();
  WhiteBkgBlueCharLabel whiteBkgBlueCharLabel2 = new WhiteBkgBlueCharLabel();
  JTextField txtOrgCurr = new JTextField();
  JTextField txtDesc = new JTextField();
  WhiteBkgBlueCharLabel whiteBkgBlueCharLabel3 = new WhiteBkgBlueCharLabel();
  JTextField txtVhAmt = new JTextField();
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel3 = new BlueBkgWhiteCharLabel();

  JButton btnOK = new JButton();
  JButton btnExit = new JButton();
  Pnl2Edit pnledit;
  Dlg5123 pThis;
  boolean isInitGui=false;
  public Dlg5123(Frame frame, String title, boolean modal) {
    super(frame, title, modal);
    try {
      pThis=this;
      pnledit=new Pnl2Edit();
      jbInit();
      pack();
      btnExit.grabFocus();

    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }

  public Dlg5123() {
    this(null, "", false);
  }

  private void jbInit() throws Exception {
     this.setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
    /*
    panel1.setLayout(null);
    blueBkgWhiteCharLabel1.setText("INVOIC#:");
    blueBkgWhiteCharLabel1.setBounds(new Rectangle(10, 17, 72, 25));
    txtSRN.setText("");
    txtSRN.setBounds(new Rectangle(80, 17, 131, 25));
    slkBuyer.setBounds(new Rectangle(320, 17, 247, 25));
    blueBkgWhiteCharLabel2.setBounds(new Rectangle(248, 17, 72, 25));
    blueBkgWhiteCharLabel2.setText("BUYER :");
    whiteBkgBlueCharLabel1.setToolTipText("");
    whiteBkgBlueCharLabel1.setText("INV-AMT USD:");
    whiteBkgBlueCharLabel1.setBounds(new Rectangle(10, 55, 108, 25));
    txtInvAmt.setText("");
    txtInvAmt.setBounds(new Rectangle(118, 55, 145, 25));
    whiteBkgBlueCharLabel2.setBounds(new Rectangle(268, 55, 108, 25));
    whiteBkgBlueCharLabel2.setText("原幣 USD:");
    whiteBkgBlueCharLabel2.setToolTipText("");
    txtOrgCurr.setBounds(new Rectangle(378, 55, 188, 25));
    txtOrgCurr.setText("");
    txtDesc.setText("");
    txtDesc.setBounds(new Rectangle(264, 93, 304, 25));
    whiteBkgBlueCharLabel3.setToolTipText("");
    whiteBkgBlueCharLabel3.setText("DESC:");
    whiteBkgBlueCharLabel3.setBounds(new Rectangle(205, 93, 59, 25));
    txtVhAmt.setBounds(new Rectangle(82, 93, 113, 25));
    txtVhAmt.setText("");
    blueBkgWhiteCharLabel3.setBounds(new Rectangle(10, 93, 72, 25));
    blueBkgWhiteCharLabel3.setFont(new java.awt.Font("Dialog", 0, 14));
    blueBkgWhiteCharLabel3.setText("總金額:");
    btnOK.setBounds(new Rectangle(150, 132, 75, 26));
    btnOK.setFont(new java.awt.Font("Dialog", 1, 11));
    btnOK.setText("OK");
    btnOK.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnOK_actionPerformed(e);
      }
    });
    btnExit.setText("EXIT");
    btnExit.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnExit_actionPerformed(e);
      }
    });
    btnExit.setBounds(new Rectangle(322, 132, 75, 26));
    btnExit.setFont(new java.awt.Font("Dialog", 1, 11));
    btnExit.setForeground(Color.red);
    getContentPane().add(panel1);
    panel1.add(blueBkgWhiteCharLabel1, null);
    panel1.add(txtSRN, null);
    panel1.add(slkBuyer, null);
    panel1.add(blueBkgWhiteCharLabel2, null);
    panel1.add(whiteBkgBlueCharLabel1, null);
    panel1.add(txtInvAmt, null);
    panel1.add(whiteBkgBlueCharLabel2, null);
    panel1.add(txtOrgCurr, null);
    panel1.add(blueBkgWhiteCharLabel3, null);
    panel1.add(txtVhAmt, null);
    panel1.add(whiteBkgBlueCharLabel3, null);
    panel1.add(txtDesc, null);
    panel1.add(btnOK, null);
    panel1.add(btnExit, null);
    */
   getContentPane().add(pnledit);
  }

  class Pnl2Edit extends PnlFieldsEditor{
    Pnl2Edit(){
      jbInit();
    }
    public void jbInit(){
      isInitGui=true;
      this.setLayout(null);
      blueBkgWhiteCharLabel1.setText("INVOIC#:");
      blueBkgWhiteCharLabel1.setBounds(new Rectangle(10, 17, 72, 25));
      txtSRN.setText("");
      txtSRN.setBounds(new Rectangle(80, 17, 131, 25));
      //slkBuyer.setBounds(new Rectangle(320, 17, 247, 25));
      txtBuyerName.setBounds(new Rectangle(320, 17, 247, 25));
      blueBkgWhiteCharLabel2.setBounds(new Rectangle(248, 17, 72, 25));
      blueBkgWhiteCharLabel2.setText("受款人 :");
      whiteBkgBlueCharLabel1.setToolTipText("");
      whiteBkgBlueCharLabel1.setText("INV-AMT USD:");
      whiteBkgBlueCharLabel1.setBounds(new Rectangle(10, 55, 108, 25));
      txtInvAmt.setText("");
      txtInvAmt.setBounds(new Rectangle(118, 55, 145, 25));
      whiteBkgBlueCharLabel2.setBounds(new Rectangle(268, 55, 108, 25));
      whiteBkgBlueCharLabel2.setText("原幣 USD:");
      whiteBkgBlueCharLabel2.setToolTipText("");
      txtOrgCurr.setBounds(new Rectangle(378, 55, 188, 25));
      txtOrgCurr.setText("");
      txtDesc.setText("");
      txtDesc.setBounds(new Rectangle(264, 93, 304, 25));
      whiteBkgBlueCharLabel3.setToolTipText("");
      whiteBkgBlueCharLabel3.setText("DESC:");
      whiteBkgBlueCharLabel3.setBounds(new Rectangle(205, 93, 59, 25));
      txtVhAmt.setBounds(new Rectangle(82, 93, 113, 25));
      txtVhAmt.setText("");
      blueBkgWhiteCharLabel3.setBounds(new Rectangle(10, 93, 72, 25));
      blueBkgWhiteCharLabel3.setFont(new java.awt.Font("Dialog", 0, 14));
      blueBkgWhiteCharLabel3.setText("總金額:");
      btnOK.setBounds(new Rectangle(150, 132, 75, 26));
      btnOK.setFont(new java.awt.Font("Dialog", 1, 11));
      btnOK.setText("OK");
      btnOK.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(ActionEvent e) {
          btnOK_actionPerformed(e);
        }
      });
      btnExit.setText("EXIT");
      btnExit.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(ActionEvent e) {
          btnExit_actionPerformed(e);
        }
      });
      btnExit.setBounds(new Rectangle(322, 132, 75, 26));
      btnExit.setFont(new java.awt.Font("Dialog", 1, 11));
      btnExit.setForeground(Color.red);
      //getContentPane().add(panel1);
      this.add(blueBkgWhiteCharLabel1, null);
      this.add(txtSRN, null);
      //this.add(slkBuyer, null);
      this.add(txtBuyerName);
      this.add(blueBkgWhiteCharLabel2, null);
      this.add(whiteBkgBlueCharLabel1, null);
      this.add(txtInvAmt, null);
      this.add(whiteBkgBlueCharLabel2, null);
      this.add(txtOrgCurr, null);
      this.add(blueBkgWhiteCharLabel3, null);
      this.add(txtVhAmt, null);
      this.add(whiteBkgBlueCharLabel3, null);
      this.add(txtDesc, null);
      this.add(btnOK, null);
      this.add(btnExit, null);
      //btnExit.grabFocus();

      //slkBuyer.setModifyNotifyTo(new ChangeBuyer());
      txtSRN.addFocusListener(
        new java.awt.event.FocusAdapter(){
          public void focusLost(java.awt.event.FocusEvent fe){
            srnChanged();
          }
        }
      );

      txtInvAmt.addFocusListener(
        new java.awt.event.FocusAdapter(){
          public void focusLost(java.awt.event.FocusEvent fe){
           ComposeDescription();
          }
        }
      );

      txtBuyerName.addFocusListener(
        new java.awt.event.FocusAdapter(){
          public void focusLost(java.awt.event.FocusEvent fe){
           ComposeDescription();
          }
        }
      );


      txtOrgCurr.addFocusListener(
        new java.awt.event.FocusAdapter(){
          public void focusLost(java.awt.event.FocusEvent fe){
           ComposeDescription();
          }
        }
      );
     //slkBuyer.setEnabled(false);
     txtInvAmt.setEditable(false);

    }
    void ComposeDescription(){
      if(isInitGui)return;
      StringBuffer sb=new StringBuffer();
      sb.append(txtSRN.getText());
      sb.append(" ");
      try{
        /*
        Record rec=slkBuyer.currentRecord();
        String byrName=(String)rec.get("BYMKR_CHINESE_BRIEF");
        if(byrName==null){
          byrName=(String)rec.get("BYMKR_BRIEF");
        }
        sb.append(byrName);
        */
        sb.append(txtBuyerName.getText().trim());
        //sb.append(" INV-AMT USD:");sb.append(txtInvAmt.getText().trim());
        sb.append(" 原幣 USD:");sb.append(txtOrgCurr.getText().trim());
        txtDesc.setText(sb.toString());
      }catch(Exception exp){

      }
    }
    void srnChanged(){
      if(isInitGui)return;
      if(txtSRN.getText().trim().length()==0){
        exgui.verification.VerifyLib.showAlert("Please Input INVOICE#","Please Input INVOICE#");
        txtSRN.grabFocus();
        return;
      }

      if(txtSRN.getText().trim().length()<"JJ900232".length() ){
        exgui.verification.VerifyLib.showAlert("INVOICE# too short","INVOICE# too short");
        txtSRN.grabFocus();
        return;
      }
      //find out buyer of that invoice.
      util.MiscFunc.showProcessingMessage();
      try{

        StringBuffer sb=new StringBuffer();
        String srn=(txtSRN.getText().trim().startsWith("ZATW"))?
                                                txtSRN.getText().trim():
                                                ("ZATW"+txtSRN.getText().trim()) ;

        sb.append("select  ");
        sb.append(" nvl(c.BYMKR_CHINESE_BRIEF,c.BYMKR_BRIEF) as buyer_name ,");
        sb.append(" GET_TOTAL_NET_DOC_PRX_AMT('");sb.append(srn);sb.append("') as INV_AMT ");
        sb.append("from ship_sc a,prod_head b  ,buyer_maker c ");
        sb.append("where ship_no='");sb.append(srn);sb.append("' ");
        sb.append("and a.prod_head_pk=b.prod_head_pk  ");
        sb.append("and a.record_delete_flag='1'   ");
        sb.append("and b.record_delete_flag='1'  ");
        sb.append("and rownum=1  ");
        Object buyer;
        Vector vctShipSC = exgui2.CONST.BASIC_MAIN_EJB.getDatas(
            util.PublicVariable.USER_RECORD,
            sb.toString(), 1, 9999);
        if(vctShipSC.size()==0){
          exgui.verification.VerifyLib.showAlert("INVOICE# Not Found","INVOICE# Not Found");
          txtSRN.grabFocus();
          return;
        }
        buyer=((Record)vctShipSC.get(0)).get(0);
        Object amtObject=((Record)vctShipSC.get(0)).get(1);
        txtInvAmt.setText(amtObject==null?"":amtObject.toString());
        //cause user always modify the name of buyer,so just leave it
        //txtBuyerName.setText((String)buyer);

        //slkBuyer.init("BUYER_SEQ",buyer,slkBuyer.TYPE_BUYER,true);
        ComposeDescription();
      }catch(Exception exp){
        exp.printStackTrace();
        util.ExceptionLog.exp2File(exp,"");
      }
      util.MiscFunc.hideProcessingMessage();
    }
    class ChangeBuyer implements newtimes.preproduction.buyermakerselect.BuyerMakerChanged{
       public void changeBuyerMaker(Record rec){
         ComposeDescription();
       }
    }
    public void record2Gui(){
       try{
         isInitGui=true;
         dataBoundGUIs.clear();

         Object vftxtSRN=exgui.verification.CellFormat.getOrdinaryFieldNotAllowNull(20);
          dataBoundGUIs.add(  new exgui.DataBindTextWithChecker(txtSRN,"SRN",recToMapping.get("SRN"),20,(exgui.Object2String)vftxtSRN,(exgui.ultratable.CellTxtEditorFormat)vftxtSRN)
         );
        Object vftxtBuyerName=exgui.verification.CellFormat.getOrdinaryField(255);
         dataBoundGUIs.add(  new exgui.DataBindTextWithChecker(txtBuyerName,"BUYER_SEQ",
             recToMapping.get("BUYER_SEQ"),255,
             (exgui.Object2String)vftxtBuyerName,
             (exgui.ultratable.CellTxtEditorFormat)vftxtBuyerName)
        );

         Object vftxtInvAmt=exgui.verification.CellFormat.getDoubleFormatAllowNull(10,2);
          dataBoundGUIs.add(  new exgui.DataBindTextWithChecker(txtInvAmt,"INV_AMT",recToMapping.get("INV_AMT"),12,(exgui.Object2String)vftxtInvAmt,(exgui.ultratable.CellTxtEditorFormat)vftxtInvAmt)
         );
         Object vftxtOrgCurr=exgui.verification.CellFormat.getDoubleFormatAllowNull(10,2);
          dataBoundGUIs.add(  new exgui.DataBindTextWithChecker(txtOrgCurr,"ORG_CURR_USD",recToMapping.get("ORG_CURR_USD"),12,(exgui.Object2String)vftxtOrgCurr,(exgui.ultratable.CellTxtEditorFormat)vftxtOrgCurr)
         );
         //slkBuyer.init("BUYER_SEQ",recToMapping.get("BUYER_SEQ"),slkBuyer.TYPE_BUYER,true);
         Object vftxtDesc = exgui.verification.CellFormat.getOrdinaryField(4000);
         dataBoundGUIs.add(
             new exgui.DataBindTextWithChecker(txtDesc, "VH_DESC",
                                               recToMapping.get("VH_DESC"), 4000,
                                               (exgui.Object2String)vftxtDesc,
                                               (exgui.ultratable.
                                                CellTxtEditorFormat)vftxtDesc)
             );
         Object vfyAmt  =exgui.verification.CellFormat.getDoubleFormatAllowNull(10,2);
         dataBoundGUIs.add(
             new exgui.DataBindTextWithChecker(txtVhAmt, "DB_AMT",
                                               recToMapping.get("DB_AMT"), 12,
                                               (exgui.Object2String)vfyAmt,
                                               (exgui.ultratable.
                                                CellTxtEditorFormat)vfyAmt)

             );

          isInitGui=false;
          Constants.adjFloat(txtInvAmt);
          Constants.adjFloat(txtOrgCurr);
          Constants.adjFloat(txtVhAmt);
          //if(txtDesc.getText().trim().length()>0)txtDesc.grabFocus();
          btnExit.grabFocus();
       }catch(Exception exp){
         exp.printStackTrace();
         util.ExceptionLog.exp2File(exp,"");
       }
    }
    public void doPrint(){

    }
    public boolean gui2Record(){
      if(!super.gui2Record())return false;
      if(txtSRN.getText().trim().length()==0){
        exgui.verification.VerifyLib.showAlert("Please Input Invoice#",
                                               "Please Input Invoice#");
        return false;
      }
      if(txtBuyerName.getText().trim().length()==0){
        exgui.verification.VerifyLib.showAlert("請輸入\"受款人\"",
                                               "請輸入\"受款人\"");
        return false;
      }

      /*
      if(null==slkBuyer.getSelectedValue()){
        exgui.verification.VerifyLib.showAlert("Please Select Buyer",
                                               "Please Select Buyer");
        return false;
      }
      */

      if(txtVhAmt.getText().trim().length()==0){
        exgui.verification.VerifyLib.showAlert("請輸入金額",
                                               "請輸入金額");
        return false;
      }
      if(txtDesc.getText().trim().length()==0){
        exgui.verification.VerifyLib.showAlert("Please Input Description",
                                               "Please Input Description");
        return false;
      }
      if(txtInvAmt.getText().trim().length()==0){
        exgui.verification.VerifyLib.showAlert("Please Input Invoice Amount",
                                               "Please Input Invoice Amount");
        return false;
      }

      if(txtOrgCurr.getText().trim().length()==0){
        exgui.verification.VerifyLib.showAlert("請輸入原幣美金金額",
                                               "請輸入原幣美金金額");
        return false;
      }
      try{
        //recToMapping.set("BUYER_SEQ", slkBuyer.getSelectedValue());
        String invoic=txtSRN.getText().trim();
        if(invoic.startsWith("ZATW")){
          invoic=util.MiscFunc.Replace(invoic,"ZATW","");
          recToMapping.set("SRN",invoic);
        }
      }catch(Exception xp){

      }
      return true;
    }
    void btnOK_actionPerformed(ActionEvent e) {
      if(!gui2Record()){
        return;
      }else{
        //updateDescriptionTextField();//in case user type some extra infor
        try{
          //write back to parnet's GUI
          int row=Constants.Pnl_Tbl2EditDailyVoucher.getJtable().getSelectedRow();
          Object dc_AMT=recToMapping.get("DB_AMT");
          String strAmt;
          strAmt=dc_AMT.toString();

          //write SRN to the cell of parent
          Constants.Pnl_Tbl2EditDailyVoucher.getJtable().setValueAt(txtSRN.getText().trim(),
              row,Constants.Pnl_Tbl2EditDailyVoucher.INVOICE_NO_COLUMN_AT);
          if(strAmt.startsWith("-")){
            String intValueAmt=strAmt.substring(1,strAmt.length());
            Constants.Pnl_Tbl2EditDailyVoucher.getJtable().setValueAt(intValueAmt,
                row,Constants.Pnl_Tbl2EditDailyVoucher.CREDIT_AMT_COLUMN_AT);

            Constants.Pnl_Tbl2EditDailyVoucher.getJtable().setValueAt(null,row,
                Constants.Pnl_Tbl2EditDailyVoucher.DEBIT_AMT_COLUMN_AT);

          }else{
            Constants.Pnl_Tbl2EditDailyVoucher.getJtable().setValueAt(strAmt,row,
                Constants.Pnl_Tbl2EditDailyVoucher.DEBIT_AMT_COLUMN_AT);

            Constants.Pnl_Tbl2EditDailyVoucher.getJtable().setValueAt(null,
                row,Constants.Pnl_Tbl2EditDailyVoucher.CREDIT_AMT_COLUMN_AT);

          }
          Constants.Pnl_Tbl2EditDailyVoucher.getJtable().setValueAt(recToMapping.get("VH_DESC"),
              row,Constants.Pnl_Tbl2EditDailyVoucher.DESCRIPTION_COLUMN_AT);
        Constants.Pnl_Tbl2EditDailyVoucher.isContextModified=true;
          //set to database for auditing....
          recToMapping.set("record_modify_user",util.PublicVariable.USER_RECORD.get(0));
          recToMapping.set("record_modify_date",new java.sql.Date(System.currentTimeMillis()));

          //force ejb to handle all columns,cause server side used "delete & insert" to replace the "update" statement
          database.datatype.Record recTest=(database.datatype.Record)util.MiscFunc.deepCopy(recToMapping);
          for(int i=0;i<recToMapping.getFieldName().size();i++){
            recToMapping.set(i,recTest.get(i));
          }
          java.util.Vector vec = new java.util.Vector();
          vec.add(recToMapping);
          dbprc.updateRecords(vec);
          Constants.Pnl_EditDaily_Voucher.update2TotalLabel();
        }catch(Exception exp){
          exp.printStackTrace();
          util.ExceptionLog.exp2File(exp,"");
          exgui.verification.VerifyLib.showAlert("update failed!\nPlease Contact System Manager","update Failed");
        }
        pThis.dispose();
      }


    }

    void btnExit_actionPerformed(ActionEvent e) {
      if(pnledit.isContextModified()){
      if(!exgui.verification.VerifyLib.showConfirm("Context Modified\nAre You Sure To Exit Without Confirmation?",
                                                   "Context Modified",false))return;
    }
    pThis.dispose();

    }

  }
}
