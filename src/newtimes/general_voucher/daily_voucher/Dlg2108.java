package newtimes.general_voucher.daily_voucher;
import java.awt.*;
import javax.swing.*;
import exgui.*;
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

public class Dlg2108 extends JDialog {
  //JPanel panel1 = new JPanel();
  BlueBkgWhiteCharLabel titleLabel = new BlueBkgWhiteCharLabel();
  WhiteBkgBlueCharLabel whiteBkgBlueCharLabel1 = new WhiteBkgBlueCharLabel();
  JTextField txtTaxBase = new JTextField();
  JTextField txtPrevAccName = new JTextField();
  WhiteBkgBlueCharLabel whiteBkgBlueCharLabel2 = new WhiteBkgBlueCharLabel();
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel2 = new BlueBkgWhiteCharLabel();
  JTextField txtRcptNo = new JTextField();
  JTextField txtCustRcptNo = new JTextField();
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel3 = new BlueBkgWhiteCharLabel();
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel4 = new BlueBkgWhiteCharLabel();
  JComboBox cbxRcptType = new JComboBox(new String[]{"三聯式","二聯式","收銀機"});
  JTextField txtAmt = new JTextField();
  JLabel jLabel2 = new JLabel();
  JTextField txtDesc = new JTextField();
  JButton btnOK = new JButton();
  JButton btnExit = new JButton();
  WhiteBkgBlueCharLabel whiteBkgBlueCharLabel3 = new WhiteBkgBlueCharLabel();
  Pnl2Edit pnledit=null;
  Dlg2108 pThis;
  java.text.NumberFormat nf=new java.text.DecimalFormat("############.##");
  public Dlg2108(Frame frame, String title, boolean modal) {
    super(frame, title, modal);
    try {
      jbInit();
      pack();
      pThis=this;
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }

  public Dlg2108() {
    this(null, "", false);
  }
  String formateNumber(Object objValue){
    if(objValue==null||objValue.toString().trim().length()==0) return null;
    return nf.format(Double.parseDouble(objValue.toString()));
  }
  private void jbInit() throws Exception {
     this.setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
    /*
    panel1.setLayout(null);
    titleLabel.setFont(new java.awt.Font("Dialog", 0, 16));
    titleLabel.setText("項稅額編輯");
    titleLabel.setBounds(new Rectangle(-6, 15, 708, 28));
    whiteBkgBlueCharLabel1.setFont(new java.awt.Font("Dialog", 0, 16));
    whiteBkgBlueCharLabel1.setText("稅基");
    whiteBkgBlueCharLabel1.setBounds(new Rectangle(10, 49, 69, 26));
    txtTaxBase.setText("");
    txtTaxBase.setBounds(new Rectangle(81, 49, 111, 26));
    txtPrevAccName.setBounds(new Rectangle(338, 49, 346, 26));
    txtPrevAccName.setText("jTextField1");
    txtPrevAccName.setText("");
    whiteBkgBlueCharLabel2.setBounds(new Rectangle(218, 49, 120, 26));
    whiteBkgBlueCharLabel2.setText("上一科目名稱");
    whiteBkgBlueCharLabel2.setFont(new java.awt.Font("Dialog", 0, 16));
    blueBkgWhiteCharLabel2.setFont(new java.awt.Font("Dialog", 0, 16));
    blueBkgWhiteCharLabel2.setText("發票號碼");
    blueBkgWhiteCharLabel2.setBounds(new Rectangle(11, 90, 71, 29));
    txtRcptNo.setText("");
    txtRcptNo.setBounds(new Rectangle(82, 90, 153, 29));
    txtCustRcptNo.setBounds(new Rectangle(347, 90, 153, 29));
    txtCustRcptNo.setText("");
    blueBkgWhiteCharLabel3.setBounds(new Rectangle(240, 90, 108, 29));
    blueBkgWhiteCharLabel3.setText("客戶發票號碼");
    blueBkgWhiteCharLabel3.setFont(new java.awt.Font("Dialog", 0, 16));
    blueBkgWhiteCharLabel4.setFont(new java.awt.Font("Dialog", 0, 16));
    blueBkgWhiteCharLabel4.setText("型式");
    blueBkgWhiteCharLabel4.setBounds(new Rectangle(506, 90, 56, 29));
    jComboBox1.setBounds(new Rectangle(561, 90, 133, 29));
    txtAmt.setText("");
    txtAmt.setBounds(new Rectangle(81, 129, 115, 29));
    jLabel2.setFont(new java.awt.Font("Dialog", 0, 14));
    jLabel2.setText("DESCRIPTOIN:");
    jLabel2.setBounds(new Rectangle(204, 132, 114, 23));
    txtDesc.setText("");
    txtDesc.setBounds(new Rectangle(316, 129, 377, 29));
    btnOK.setBounds(new Rectangle(190, 179, 106, 31));
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
    btnExit.setBounds(new Rectangle(394, 179, 106, 31));
    btnExit.setFont(new java.awt.Font("Dialog", 1, 11));
    btnExit.setForeground(Color.red);
    whiteBkgBlueCharLabel3.setBounds(new Rectangle(12, 130, 69, 26));
    whiteBkgBlueCharLabel3.setText("總金額");
    whiteBkgBlueCharLabel3.setFont(new java.awt.Font("Dialog", 0, 16));
    getContentPane().add(panel1);
    panel1.add(titleLabel, null);
    panel1.add(whiteBkgBlueCharLabel1, null);
    panel1.add(txtTaxBase, null);
    panel1.add(whiteBkgBlueCharLabel2, null);
    panel1.add(txtPrevAccName, null);
    panel1.add(blueBkgWhiteCharLabel2, null);
    panel1.add(txtRcptNo, null);
    panel1.add(blueBkgWhiteCharLabel3, null);
    panel1.add(txtCustRcptNo, null);
    panel1.add(blueBkgWhiteCharLabel4, null);
    panel1.add(jComboBox1, null);
    panel1.add(txtAmt, null);
    panel1.add(jLabel2, null);
    panel1.add(txtDesc, null);
    panel1.add(btnOK, null);
    panel1.add(btnExit, null);
    panel1.add(whiteBkgBlueCharLabel3, null);
    */
   pnledit=new Pnl2Edit();
    getContentPane().add(pnledit);
  }
  class Pnl2Edit extends  PnlFieldsEditor{
    Pnl2Edit(){
      jbInit();
    }
   public void jbInit(){
      setLayout(null);
      titleLabel.setFont(new java.awt.Font("Dialog", 0, 16));
      titleLabel.setText("項稅額編輯");
      titleLabel.setBounds(new Rectangle(-6, 15, 708, 28));
      whiteBkgBlueCharLabel1.setFont(new java.awt.Font("Dialog", 0, 16));
      whiteBkgBlueCharLabel1.setText("稅基");
      whiteBkgBlueCharLabel1.setBounds(new Rectangle(10, 49, 69, 26));
      txtTaxBase.setText("");
      txtTaxBase.setBounds(new Rectangle(81, 49, 111, 26));
      txtPrevAccName.setBounds(new Rectangle(338, 49, 346, 26));
      txtPrevAccName.setText("");
      whiteBkgBlueCharLabel2.setBounds(new Rectangle(218, 49, 120, 26));
      whiteBkgBlueCharLabel2.setText("科目名稱");
      whiteBkgBlueCharLabel2.setFont(new java.awt.Font("Dialog", 0, 16));
      blueBkgWhiteCharLabel2.setFont(new java.awt.Font("Dialog", 0, 16));
      blueBkgWhiteCharLabel2.setText("發票號碼");
      blueBkgWhiteCharLabel2.setBounds(new Rectangle(11, 90, 71, 29));
      txtRcptNo.setText("");
      txtRcptNo.setBounds(new Rectangle(82, 90, 153, 29));
      txtCustRcptNo.setBounds(new Rectangle(347, 90, 153, 29));
      txtCustRcptNo.setText("");
      blueBkgWhiteCharLabel3.setBounds(new Rectangle(240, 90, 108, 29));
      blueBkgWhiteCharLabel3.setText("客戶統編");
      blueBkgWhiteCharLabel3.setFont(new java.awt.Font("Dialog", 0, 16));
      blueBkgWhiteCharLabel4.setFont(new java.awt.Font("Dialog", 0, 16));
      blueBkgWhiteCharLabel4.setText("型式");
      blueBkgWhiteCharLabel4.setBounds(new Rectangle(506, 90, 56, 29));
      cbxRcptType.setBounds(new Rectangle(561, 90, 133, 29));
      txtAmt.setText("");
      txtAmt.setBounds(new Rectangle(81, 129, 115, 29));
      jLabel2.setFont(new java.awt.Font("Dialog", 0, 14));
      jLabel2.setText("DESCRIPTOIN:");
      jLabel2.setBounds(new Rectangle(204, 132, 114, 23));
      txtDesc.setText("");
      txtDesc.setBounds(new Rectangle(316, 129, 377, 29));
      btnOK.setBounds(new Rectangle(190, 179, 106, 31));
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
      btnExit.setBounds(new Rectangle(394, 179, 106, 31));
      btnExit.setFont(new java.awt.Font("Dialog", 1, 11));
      btnExit.setForeground(Color.red);
      whiteBkgBlueCharLabel3.setBounds(new Rectangle(12, 130, 69, 26));
      whiteBkgBlueCharLabel3.setText("稅額");
      whiteBkgBlueCharLabel3.setFont(new java.awt.Font("Dialog", 0, 16));

      add(titleLabel, null);
      add(whiteBkgBlueCharLabel1, null);
      add(txtTaxBase, null);
      add(whiteBkgBlueCharLabel2, null);
      add(txtPrevAccName, null);
      add(blueBkgWhiteCharLabel2, null);
      add(txtRcptNo, null);
      add(blueBkgWhiteCharLabel3, null);
      add(txtCustRcptNo, null);
      add(blueBkgWhiteCharLabel4, null);
      add(cbxRcptType, null);
      add(txtAmt, null);
      add(jLabel2, null);
      add(txtDesc, null);
      add(btnOK, null);
      add(btnExit, null);
      add(whiteBkgBlueCharLabel3, null);
      txtTaxBase.addKeyListener(new java.awt.event.KeyAdapter() {
                public void keyReleased(KeyEvent e) {
                  genDescString();
                    }
                });
      txtPrevAccName.addKeyListener(new java.awt.event.KeyAdapter() {
                public void keyReleased(KeyEvent e) {
                  genDescString();
                    }
                });
      txtRcptNo.addKeyListener(new java.awt.event.KeyAdapter() {
                          public void keyReleased(KeyEvent e) {
                            genDescString();
                              }
                          });


    }
    void btnExit_actionPerformed(ActionEvent e) {
      if(pnledit.isContextModified()){
        if(!exgui.verification.VerifyLib.showConfirm("Context Modified\nAre You Sure To Exit Without Confirmation?",
                                                     "Context Modified",false))return;
      }
      pThis.dispose();

    }
    public boolean gui2Record(){
      if(!super.gui2Record())return false;
      if(txtAmt.getText().trim().length()==0){
        exgui.verification.VerifyLib.showAlert("請輸入金額",
                                               "請輸入金額");
        return false;
      }
      if(txtDesc.getText().trim().length()==0){
        exgui.verification.VerifyLib.showAlert("Please Input Description",
                                               "Please Input Description");
        return false;
      }

      if(txtTaxBase.getText().trim().length()==0){
        exgui.verification.VerifyLib.showAlert("請輸入稅基",
                                               "請輸入稅基");
        return false;
      }
      if(txtRcptNo.getText().trim().length()==0){
        exgui.verification.VerifyLib.showAlert("請輸入發票號碼",
                                               "請輸入發票號碼");
        return false;
      }
      if(txtCustRcptNo.getText().trim().length()==0){
        exgui.verification.VerifyLib.showAlert("請輸入客戶發票號碼",
                                               "請輸入客戶發票號碼");
        return false;
      }
      return true;

    }
    void genDescString(){
      String rcptNo=txtRcptNo.getText();
      if(rcptNo.trim().length()>0) rcptNo="-"+rcptNo;
      txtDesc.setText(txtTaxBase.getText()+" "+txtPrevAccName.getText()+rcptNo);
    }
    void btnOK_actionPerformed(ActionEvent e) {
      if(!gui2Record()){
        return;
      }else{
        //updateDescriptionTextField();//in case user type some extra infor
        try{
          recToMapping.set("RCPT_TYPE",String.valueOf(cbxRcptType.getSelectedIndex()));
          //write back to parnet's GUI
          int row=Constants.Pnl_Tbl2EditDailyVoucher.getJtable().getSelectedRow();
          Object dc_AMT=recToMapping.get("DB_AMT");
          String strAmt;
          strAmt=dc_AMT.toString();
          if(strAmt.startsWith("-")){
            String intValueAmt=strAmt.substring(1,strAmt.length());
            intValueAmt=formateNumber(intValueAmt);
            Constants.Pnl_Tbl2EditDailyVoucher.getJtable().setValueAt(intValueAmt,row,
                Constants.Pnl_Tbl2EditDailyVoucher.DEBIT_AMT_COLUMN_AT);

            Constants.Pnl_Tbl2EditDailyVoucher.getJtable().setValueAt(null,
                row,Constants.Pnl_Tbl2EditDailyVoucher.CREDIT_AMT_COLUMN_AT);

          }else{
            strAmt=formateNumber(strAmt);
            Constants.Pnl_Tbl2EditDailyVoucher.getJtable().setValueAt(strAmt,
                row,Constants.Pnl_Tbl2EditDailyVoucher.CREDIT_AMT_COLUMN_AT);

            Constants.Pnl_Tbl2EditDailyVoucher.getJtable().setValueAt(null,row,
                Constants.Pnl_Tbl2EditDailyVoucher.DEBIT_AMT_COLUMN_AT);



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

    public void record2Gui(){
      dataBoundGUIs.clear();
      try{
        Object vftxtTaxBase = exgui.verification.CellFormat.getDoubleFormat(10,
            2);
        dataBoundGUIs.add(new exgui.DataBindTextWithChecker(txtTaxBase,
            "TAX_BASE",
            formateNumber(recToMapping.get("TAX_BASE")), 12, (exgui.Object2String)
            vftxtTaxBase, (exgui.ultratable.CellTxtEditorFormat)vftxtTaxBase)
                          );
        Object vftxtPrevAccName = exgui.verification.CellFormat.
            getOrdinaryField(100);
        dataBoundGUIs.add(new exgui.DataBindTextWithChecker(txtPrevAccName,
            "PREV_ACC_NAME",
            recToMapping.get("PREV_ACC_NAME"), 100,
                          (exgui.Object2String)vftxtPrevAccName,
                                  (exgui.ultratable.CellTxtEditorFormat)
                                  vftxtPrevAccName)
                          );
        Object vftxtRcptNo = exgui.verification.CellFormat.getOrdinaryField(20);
        dataBoundGUIs.add(new exgui.DataBindTextWithChecker(txtRcptNo,
            "RCPT_NO",
            recToMapping.get("RCPT_NO"), 20, (exgui.Object2String)vftxtRcptNo,
            (exgui.ultratable.CellTxtEditorFormat)vftxtRcptNo)
                          );
        Object vftxtCustRcptNo = exgui.verification.CellFormat.getOrdinaryField(
            20);
        dataBoundGUIs.add(new exgui.DataBindTextWithChecker(txtCustRcptNo,
            "CUST_ID",
            recToMapping.get("CUST_ID"), 20,
                          (exgui.Object2String)vftxtCustRcptNo,
                                    (exgui.ultratable.CellTxtEditorFormat)
                                    vftxtCustRcptNo)
                          );
        Object vftxtDesc = exgui.verification.CellFormat.
            getOrdinaryFieldNotAllowNull(4000);
        dataBoundGUIs.add(
            new exgui.DataBindTextWithChecker(txtDesc, "VH_DESC",
                                              recToMapping.get("VH_DESC"), 4000,
                                              (exgui.Object2String)vftxtDesc,
                                              (exgui.ultratable.
                                               CellTxtEditorFormat)vftxtDesc)
            );
        Object vfyAmt  =exgui.verification.CellFormat.getDoubleFormat(10,2);
        //for 2108 item,the D/C is reversed.
        Object objAmt=recToMapping.get("DB_AMT");
        String strAmt="0";
        if(objAmt!=null){
          if( objAmt.toString().startsWith("-")){
             strAmt=objAmt.toString().substring(1,objAmt.toString().length());
          }else{
             strAmt="-"+objAmt.toString();
          }
        }

        dataBoundGUIs.add(
            new exgui.DataBindTextWithChecker(txtAmt, "DB_AMT",
                                              formateNumber(strAmt), 12,
                                              (exgui.Object2String)vfyAmt,
                                              (exgui.ultratable.
                                               CellTxtEditorFormat)vfyAmt)

            );
              Object objRcpType=recToMapping.get("RCPT_TYPE");
              if(null==objRcpType){
                cbxRcptType.setSelectedIndex(0);
              }else{
                cbxRcptType.setSelectedIndex(Integer.parseInt(objRcpType.toString()));
              }
         Constants.adjFloat(txtAmt);
         //if(txtDesc.getText().trim().length()>0)txtDesc.grabFocus();
         btnExit.grabFocus();
      }catch(Exception exp){
        exp.printStackTrace();
        util.ExceptionLog.exp2File(exp,"");
      }

    }
    public void doPrint(){}

  }


}
