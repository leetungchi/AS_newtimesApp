package newtimes.general_voucher.daily_voucher;

import java.awt.*;
import javax.swing.*;
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

public class DlgTeleComFeeEditor extends JDialog {
  //JPanel panel1 = new JPanel();
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel1 = new BlueBkgWhiteCharLabel();
  JTextField txtStaffName = new JTextField();
  WhiteBkgBlueCharLabel whiteBkgBlueCharLabel1 = new WhiteBkgBlueCharLabel();
  JTextField txtTeleComCode = new JTextField();
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel2 = new BlueBkgWhiteCharLabel();
  JComboBox cbxSrc = new JComboBox();
  JLabel jLabel1 = new JLabel();
  JTextField txtDbDesc = new JTextField();
  JButton btnOk = new JButton();
  JButton btnExit = new JButton();
   DlgTeleComFeeEditor pThis;
  JTextField txtDbAmt = new JTextField();
  WhiteBkgBlueCharLabel whiteBkgBlueCharLabel2 = new WhiteBkgBlueCharLabel();
  java.util.Hashtable htTelComCodeAndRecs;
    exgui.ultratable.DataBindComboboxTable dbCbxStaff = new exgui.ultratable.DataBindComboboxTable();
    exgui.ultratable.DataBindComboboxTable dbCbxTelCom = new exgui.ultratable.DataBindComboboxTable();
    Vector vctTelCom;
   static Vector vctTelComSrc=null;
   Pnl2Edit pnl2edit=new Pnl2Edit();
   java.text.NumberFormat nf=new java.text.DecimalFormat("##########.##");
  public DlgTeleComFeeEditor(Frame frame, String title, boolean modal) {
    super(frame, title, modal);
    try {
      jbInit();
      this.setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
      pack();
      pThis=this;
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }

  public DlgTeleComFeeEditor() {
    this(null, "", false);
  }

  private void jbInit() throws Exception {
      this.setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
     getContentPane().add(pnl2edit);
  }
  class Pnl2Edit extends PnlFieldsEditor{
     Pnl2Edit(){
       try{
         initTeleComeList();
         jbInit();
       }catch(Exception exp){
         exp.printStackTrace();
         util.ExceptionLog.exp2File(exp,"");
       }
     }
     public void jbInit()throws Exception{
       this.setLayout(null);
       blueBkgWhiteCharLabel1.setBackground(Color.white);
      blueBkgWhiteCharLabel1.setFont(new java.awt.Font("Dialog", 0, 12));
      blueBkgWhiteCharLabel1.setForeground(new Color(143, 143, 188));
       blueBkgWhiteCharLabel1.setText("自費請款員工編號");
       blueBkgWhiteCharLabel1.setBounds(new Rectangle(2, 55, 119, 26));

       //txtStaffName.setText("");
       //txtStaffName.setBounds(new Rectangle(120, 22, 188, 26));
       dbCbxStaff.setBounds(new Rectangle(120, 55, 188, 26));

       whiteBkgBlueCharLabel1.setFont(new java.awt.Font("Dialog", 0, 12));
       whiteBkgBlueCharLabel1.setText("電信編號");
       whiteBkgBlueCharLabel1.setBounds(new Rectangle(2, 21, 117, 26));

       //txtTeleComCode.setBounds(new Rectangle(429, 22, 188, 26));
       //txtTeleComCode.setText("");
       dbCbxTelCom.setBounds(new Rectangle(119, 21, 188, 26));

       blueBkgWhiteCharLabel2.setBounds(new Rectangle(311, 21, 119, 26));
       blueBkgWhiteCharLabel2.setText("來源");
       blueBkgWhiteCharLabel2.setFont(new java.awt.Font("Dialog", 0, 12));
       cbxSrc.setBounds(new Rectangle(429, 21, 188, 25));
       jLabel1.setFont(new java.awt.Font("Dialog", 1, 12));
       jLabel1.setText("DESCRIPTION:");
       jLabel1.setBounds(new Rectangle(1, 90, 92, 21));
       txtDbDesc.setText("");
       txtDbDesc.setBounds(new Rectangle(91, 90, 560, 29));
       btnOk.setBounds(new Rectangle(148, 135, 101, 25));
       btnOk.setFont(new java.awt.Font("Dialog", 1, 11));
       btnOk.setText("OK");
      btnOk.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(ActionEvent e) {
          btnOk_actionPerformed(e);
        }
      });
       btnExit.setBounds(new Rectangle(414, 135, 101, 25));
       btnExit.setFont(new java.awt.Font("Dialog", 1, 11));
       btnExit.setForeground(Color.red);
       btnExit.setText("EXIT");
      btnExit.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(ActionEvent e) {
          btnExit_actionPerformed(e);
        }
      });
       txtDbAmt.setText("");
       txtDbAmt.setBounds(new Rectangle(429, 55, 188, 26));
       whiteBkgBlueCharLabel2.setBounds(new Rectangle(312, 55, 117, 26));
       whiteBkgBlueCharLabel2.setText("金額");
       whiteBkgBlueCharLabel2.setBackground(new Color(143, 143, 188));
      whiteBkgBlueCharLabel2.setFont(new java.awt.Font("Dialog", 0, 12));
      whiteBkgBlueCharLabel2.setForeground(Color.white);
       //getContentPane().add(panel1);
       //this.add(txtStaffName, null);
       //this.add(txtTeleComCode, null);
       this.add(txtDbAmt, null);
       this.add(whiteBkgBlueCharLabel2, null);
      this.add(whiteBkgBlueCharLabel1, null);
      this.add(dbCbxTelCom, null);
      this.add(blueBkgWhiteCharLabel2, null);
      this.add(cbxSrc, null);
      this.add(blueBkgWhiteCharLabel1, null);
      this.add(dbCbxStaff, null);
      this.add(btnExit, null);
      this.add(jLabel1, null);
      this.add(txtDbDesc, null);
      this.add(btnOk, null);
      dbCbxTelCom.getGUIcomponent().addKeyListener(new java.awt.event.KeyAdapter() {
       public void keyReleased(KeyEvent e) {
         updateDescriptionTextField();
           }
       });

       dbCbxTelCom.getGUIcomponent().addFocusListener(new java.awt.event.FocusAdapter() {
        public void focusLost(java.awt.event.FocusEvent e) {
          updateDescriptionTextField();
            }
        });

        dbCbxStaff.getGUIcomponent().addKeyListener(new java.awt.event.KeyAdapter() {
         public void keyReleased(KeyEvent e) {
           updateDescriptionTextField();
             }
         });

        dbCbxStaff.getGUIcomponent().addFocusListener(new java.awt.event.FocusAdapter() {
          public void focusLost(java.awt.event.FocusEvent e) {
            updateDescriptionTextField();
              }
          });


     }
     void updateDescriptionTextField(){
       Object selectedCODE=dbCbxTelCom.getSelectedValue();
       if(null!=selectedCODE){
         database.datatype.Record rec =
             (database.datatype.Record)htTelComCodeAndRecs.get(
             selectedCODE);
         String sysCode = (String)rec.get(3);
         String remark = (String)rec.get(4);
         String totalRmk = sysCode + ((remark == null) ? "" : remark);
         System.out.println("totalRmk is  " + totalRmk);
         txtDbDesc.setText(totalRmk);
       }
     }
     void OkPressed(){
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

     public boolean gui2Record(){
       if(!super.gui2Record())return false;
       /*
       if(dbCbxStaff.getSelectedValue()==null){
         exgui.verification.VerifyLib.showAlert("請選取員工",
                                                "請選取員工");
         return false;
       }
       */
       if(dbCbxTelCom.getSelectedValue()==null){
         exgui.verification.VerifyLib.showAlert("請選取電信編號",
                                                "請選取電信編號");
         return false;
       }
       if(txtDbAmt.getText().trim().length()==0){
         exgui.verification.VerifyLib.showAlert("請輸入金額",
                                                "請輸入金額");
         return false;
       }
       if(txtDbDesc.getText().trim().length()==0){
         exgui.verification.VerifyLib.showAlert("Please Input Description",
                                                "Please Input Description");
         return false;
       }


       return true;
     }
     public void record2Gui(){
       try{
         if(vctTelCom.size()==0){
           exgui.verification.VerifyLib.showAlert("無此公司之\"電信編號\"資料\n請治電腦室","無此公司之\"電信編號\"資料");
           return;
         }
         dataBoundGUIs.clear();

         util.InsertionOrderedHashMap iso=new util.InsertionOrderedHashMap();
         iso.put("CODE","USR_CODE");
         iso.put("姓名","USR_NAME");
         iso.put("NAME","USR_ENG_NAME");
         dbCbxStaff.init("STAFF_CODE", Constants.VCT_STAFF, iso, 250, 250, "USR_CODE", "USR_CODE", recToMapping.get("STAFF_CODE"));
         dataBoundGUIs.add(dbCbxStaff);

         util.InsertionOrderedHashMap isoTelCom=new util.InsertionOrderedHashMap();
         isoTelCom.put("代碼","CODE");
         isoTelCom.put(" 電話 ","SYS_CODE");
         isoTelCom.put("          明細         ","REMARK");
         dbCbxTelCom.init("CODE", vctTelCom, isoTelCom, 320, 250, "CODE", "CODE", recToMapping.get("CODE"));
         dataBoundGUIs.add(dbCbxTelCom);
         Object vftxtDesc = exgui.verification.CellFormat.
             getOrdinaryFieldNotAllowNull(4000);
         dataBoundGUIs.add(
             new exgui.DataBindTextWithChecker(txtDbDesc, "VH_DESC",
                                               recToMapping.get("VH_DESC"), 4000,
                                               (exgui.Object2String)vftxtDesc,
                                               (exgui.ultratable.
                                                CellTxtEditorFormat)vftxtDesc)
             );
         Object vfyAmt  =exgui.verification.CellFormat.getDoubleFormat(10,2);
         dataBoundGUIs.add(
             new exgui.DataBindTextWithChecker(txtDbAmt, "DB_AMT",
                                               recToMapping.get("DB_AMT"), 12,
                                               (exgui.Object2String)vfyAmt,
                                               (exgui.ultratable.
                                                CellTxtEditorFormat)vfyAmt)

             );
          dataBoundGUIs.add(
              new exgui.DataBindJCombobox(cbxSrc,"SRC_CODE",vctTelComSrc,"SRC_NAME","SRC_CODE",
                                          recToMapping.get("SRC_CODE")
                                          )
               );
            if(recToMapping.get("DB_AMT")==null)txtDbAmt.setText("");
          Constants.adjFloat(txtDbAmt);
          //if(txtDbDesc.getText().trim().length()>0)txtDbDesc.grabFocus();
          btnExit.grabFocus();
       }catch(Exception exp){
         exp.printStackTrace();
         util.ExceptionLog.exp2File(exp,"");
       }

     }
     public void doPrint(){
     }

  }

  void initTeleComeList()throws Exception{
    htTelComCodeAndRecs=new Hashtable();
    String grpCode="";
    String accCode=
        (String)Constants.Pnl_Tbl2EditDailyVoucher.getJtable().getValueAt(
           Constants.Pnl_Tbl2EditDailyVoucher.getJtable().getSelectedRow(),
           Constants.Pnl_Tbl2EditDailyVoucher.ACC_CODE_COLUMN_AT);
    if(accCode.length()>6){
      grpCode=accCode.substring(5,7);
    }
    String cmpCode=accCode.substring(4,5);
    StringBuffer sb=new StringBuffer();
    sb.append("select * from VH_TEL_CODE ");
    sb.append(" where (COMPANY='");sb.append(cmpCode);sb.append("' ");
    sb.append(" or COMPANY='X' )");
    sb.append(" and ( GRP like '%,XX,%' ");
    if(grpCode.trim().length()>0){
      sb.append(" or GRP like '%,");sb.append(grpCode);
      sb.append(",%'");
    }
    sb.append(" ) ");
    sb.append(" and record_delete_flag='1'");
    System.out.println("sql for telcome resourse is "+sb.toString());
    Vector vct=exgui2.CONST.BASIC_MAIN_EJB.getDatas(
      util.PublicVariable.USER_RECORD,
      sb.toString(),1,999);
     for(int i=0;i<vct.size();i++){
       Record rec=(Record)vct.get(i);
       htTelComCodeAndRecs.put(rec.get(0),rec);
     }
     vctTelCom=vct;
     if(vctTelComSrc==null){
       vctTelComSrc=exgui2.CONST.BASIC_MAIN_EJB.getDatas(
         util.PublicVariable.USER_RECORD,
         "select * from VH_DTL_TELECOM_SRC",1,99999
       );
     }
  }

  void btnOk_actionPerformed(ActionEvent e) {
     pnl2edit.OkPressed();
  }

  void btnExit_actionPerformed(ActionEvent e) {
    if(pnl2edit.isContextModified()){
      if(!exgui.verification.VerifyLib.showConfirm("Context Modified\nAre You Sure To Exit Without Confirmation?",
                                                   "Context Modified",false))return;
    }
    pThis.dispose();

  }
}
