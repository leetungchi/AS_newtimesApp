package newtimes.general_voucher.daily_voucher;

import java.awt.*;
import javax.swing.*;
import exgui.*;
import javax.swing.border.*;
import java.awt.event.*;
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

public class DlgTktFeeEditor extends JDialog {
  //JPanel panel1 = new JPanel();
  static Vector VCT_TRAVEL_AGENCY,VCT_AIRE_CO,VCT_SEAT_CLASS,VCT_TICKET_TYPE;

  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel1 = new BlueBkgWhiteCharLabel();
  //JTextField txtStaffId = new JTextField();
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel2 = new BlueBkgWhiteCharLabel();
  JTextField txtBillDate = new JTextField();
  WhiteBkgBlueCharLabel whiteBkgBlueCharLabel1 = new WhiteBkgBlueCharLabel();
  JComboBox cbxTvlAgc = new JComboBox();
  JComboBox cbxAirCo = new JComboBox();
  WhiteBkgBlueCharLabel whiteBkgBlueCharLabel2 = new WhiteBkgBlueCharLabel();
  JComboBox cbxSeatClass = new JComboBox();
  WhiteBkgBlueCharLabel whiteBkgBlueCharLabel3 = new WhiteBkgBlueCharLabel();
  JComboBox cbxTktType = new JComboBox();
  WhiteBkgBlueCharLabel whiteBkgBlueCharLabel4 = new WhiteBkgBlueCharLabel();
  JPanel pnlCountries = new JPanel();
  Border border1;
  TitledBorder titledBorder1;
  JTextField txtDbAmt = new JTextField();
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel3 = new BlueBkgWhiteCharLabel();
  JComboBox cbxCnty1 = new JComboBox();
  JComboBox cbxCnty2 = new JComboBox();
  JComboBox cbxCnty3 = new JComboBox();
  JComboBox cbxCnty4 = new JComboBox();
  JButton btnOK = new JButton();
  JButton btnExit = new JButton();
  JTextField txtVhDesc = new JTextField();
  JLabel jLabel1 = new JLabel();
  exgui.DataBindJCombobox DbJcbxcbxCnty1,DbJcbxcbxCnty2,DbJcbxcbxCnty3,DbJcbxcbxCnty4;
  exgui.ultratable.DataBindComboboxTable dbCbxStaff = new exgui.ultratable.DataBindComboboxTable();
  Pnl2Eidt pnl22Eidt=new Pnl2Eidt();
   DlgTktFeeEditor pThis;
   java.text.NumberFormat nf=new java.text.DecimalFormat("##########.##");
  public DlgTktFeeEditor(Frame frame, String title, boolean modal) {
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

  public DlgTktFeeEditor() {
    this(null, "", false);
  }

  private void jbInit() throws Exception {
     this.setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
    getContentPane().add(pnl22Eidt);
  }
  class Pnl2Eidt extends PnlFieldsEditor{
    Pnl2Eidt(){
      jbInit();
    }
    public void jbInit(){
      border1 = BorderFactory.createEtchedBorder(Color.white,new Color(148, 145, 140));
      titledBorder1 = new TitledBorder(border1,"出差國家");
      setLayout(null);
      blueBkgWhiteCharLabel1.setFont(new java.awt.Font("Dialog", 0, 12));
      blueBkgWhiteCharLabel1.setText("員工姓名/編號:");
      blueBkgWhiteCharLabel1.setBounds(new Rectangle(10, 16, 98, 25));
      //dbCbxStaff.setText("");
      dbCbxStaff.setBounds(new Rectangle(107, 16, 202, 25));
      blueBkgWhiteCharLabel2.setBounds(new Rectangle(356, 16, 70, 25));
      blueBkgWhiteCharLabel2.setText("開票日:");
      blueBkgWhiteCharLabel2.setFont(new java.awt.Font("Dialog", 0, 12));
      txtBillDate.setText("");
      txtBillDate.setBounds(new Rectangle(425, 16, 72, 25));
      whiteBkgBlueCharLabel1.setFont(new java.awt.Font("Dialog", 0, 12));
      whiteBkgBlueCharLabel1.setText("旅行社");
      whiteBkgBlueCharLabel1.setBounds(new Rectangle(10, 51, 98, 25));
      cbxTvlAgc.setBounds(new Rectangle(107, 51, 202, 25));
      cbxAirCo.setBounds(new Rectangle(454, 51, 208, 25));
      whiteBkgBlueCharLabel2.setBounds(new Rectangle(356, 51, 98, 25));
      whiteBkgBlueCharLabel2.setText("航空公司");
      whiteBkgBlueCharLabel2.setFont(new java.awt.Font("Dialog", 0, 12));
      cbxSeatClass.setBounds(new Rectangle(107, 86, 202, 25));
      whiteBkgBlueCharLabel3.setBounds(new Rectangle(10, 86, 98, 25));
      whiteBkgBlueCharLabel3.setText("艙 等");
      whiteBkgBlueCharLabel3.setBackground(new Color(143, 143, 188));
      whiteBkgBlueCharLabel3.setFont(new java.awt.Font("Dialog", 0, 14));
      whiteBkgBlueCharLabel3.setForeground(Color.white);
      cbxTktType.setBounds(new Rectangle(454, 86, 208, 25));
      whiteBkgBlueCharLabel4.setForeground(Color.white);
      whiteBkgBlueCharLabel4.setFont(new java.awt.Font("Dialog", 0, 14));
      whiteBkgBlueCharLabel4.setBackground(new Color(143, 143, 188));
      whiteBkgBlueCharLabel4.setText("機票型態");
      whiteBkgBlueCharLabel4.setBounds(new Rectangle(356, 86, 98, 25));
      pnlCountries.setBorder(titledBorder1);
      pnlCountries.setBounds(new Rectangle(12, 121, 668, 86));
      pnlCountries.setLayout(null);
      txtDbAmt.setBounds(new Rectangle(558, 16, 106, 25));
      txtDbAmt.setText("");
      blueBkgWhiteCharLabel3.setFont(new java.awt.Font("Dialog", 0, 12));
      blueBkgWhiteCharLabel3.setText("金額:");
      blueBkgWhiteCharLabel3.setBounds(new Rectangle(507, 16, 51, 25));
      cbxCnty1.setBounds(new Rectangle(15, 20, 279, 25));
      cbxCnty2.setBounds(new Rectangle(362, 20, 279, 25));
      cbxCnty3.setBounds(new Rectangle(362, 51, 279, 25));
      cbxCnty4.setBounds(new Rectangle(15, 51, 279, 25));
      btnOK.setBounds(new Rectangle(164, 259, 98, 28));
      btnOK.setFont(new java.awt.Font("Dialog", 1, 12));
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
      btnExit.setBounds(new Rectangle(430, 259, 98, 28));
      btnExit.setFont(new java.awt.Font("Dialog", 1, 12));
      btnExit.setForeground(Color.red);
      txtVhDesc.setText("");
      txtVhDesc.setBounds(new Rectangle(124, 212, 553, 29));
      jLabel1.setFont(new java.awt.Font("Dialog", 1, 12));
      jLabel1.setText("DESCRIPTION:");
      jLabel1.setBounds(new Rectangle(19, 214, 97, 25));
      //getContentPane().add(panel1);
      add(blueBkgWhiteCharLabel1, null);
      add(dbCbxStaff, null);
      add(blueBkgWhiteCharLabel2, null);
      add(txtBillDate, null);
      add(whiteBkgBlueCharLabel1, null);
      add(cbxTvlAgc, null);
      add(cbxAirCo, null);
      add(whiteBkgBlueCharLabel2, null);
      add(cbxSeatClass, null);
      add(whiteBkgBlueCharLabel3, null);
      add(cbxTktType, null);
      add(whiteBkgBlueCharLabel4, null);
      add(pnlCountries, null);
      add(blueBkgWhiteCharLabel3, null);
      add(txtDbAmt, null);
      pnlCountries.add(cbxCnty1, null);
      pnlCountries.add(cbxCnty2, null);
      pnlCountries.add(cbxCnty3, null);
      pnlCountries.add(cbxCnty4, null);
      add(btnExit, null);
      add(btnOK, null);
      add(txtVhDesc, null);
      add(jLabel1, null);
    }
    void initAttrVectors()throws Exception{
      VCT_TRAVEL_AGENCY=exgui2.CONST.BASIC_MAIN_EJB.getDatas(
        util.PublicVariable.USER_RECORD,
        "select * from VH_DTL_TKT_TRL_AGC",1,9999);

    VCT_AIRE_CO=exgui2.CONST.BASIC_MAIN_EJB.getDatas(
      util.PublicVariable.USER_RECORD,
      "select * from VH_DTL_TKT_AIR_CO",1,9999);

   VCT_SEAT_CLASS=exgui2.CONST.BASIC_MAIN_EJB.getDatas(
     util.PublicVariable.USER_RECORD,
      "select * from VH_DTL_TKT_SEAT_CLASS",1,9999);

      VCT_TICKET_TYPE=exgui2.CONST.BASIC_MAIN_EJB.getDatas(
        util.PublicVariable.USER_RECORD,
        "select * from VH_DTL_TKT_TYPE",1,9999);
    }
    public  void record2Gui(){
      try{
         dataBoundGUIs.clear();
         if(VCT_TRAVEL_AGENCY==null)initAttrVectors();
         util.InsertionOrderedHashMap iso=new util.InsertionOrderedHashMap();
         iso.put("CODE","USR_CODE");
         iso.put("姓名","USR_NAME");
         iso.put("NAME","USR_ENG_NAME");
         dbCbxStaff.init("STAFF_CODE", Constants.VCT_STAFF, iso, 250, 250, "USR_CODE", "USR_CODE", recToMapping.get("STAFF_CODE"));
         dataBoundGUIs.add(dbCbxStaff);
         dbCbxStaff.getGUIcomponent().addKeyListener(new java.awt.event.KeyAdapter() {
          public void keyReleased(KeyEvent e) {
            updateDescriptionTextField();
              }
          });

             exgui.DataBindJCombobox dbCbxTravelAgency = new exgui.DataBindJCombobox(
               cbxTvlAgc,"TVL_AGNT",VCT_TRAVEL_AGENCY,"AGC_NAME","AGC_CODE",
                recToMapping.get("TVL_AGNT"));
          dataBoundGUIs.add(dbCbxTravelAgency);

         exgui.DataBindJCombobox dbAirCo =
             new exgui.DataBindJCombobox(cbxAirCo,"AIR_CO",
                                         VCT_AIRE_CO,"CO_NAME","CO_CODE",
                                         recToMapping.get("AIR_CO"));
        dataBoundGUIs.add(dbAirCo);

            exgui.DataBindJCombobox DbJcbxcbxSeatClass =
                new exgui.DataBindJCombobox(cbxSeatClass,"SEAT_CLASS",
                                            VCT_SEAT_CLASS,"CLASS_NAME","CLASS_CODE",
                                            recToMapping.get("SEAT_CLASS"));
            dataBoundGUIs.add(DbJcbxcbxSeatClass);


           exgui.DataBindJCombobox DbJcbxcbxTktType =
               new exgui.DataBindJCombobox(cbxTktType,"TKT_TYPE",
                                           VCT_TICKET_TYPE,"TYPE_NAME","TYPE_CODE",
                                           recToMapping.get("TKT_TYPE"));
           dataBoundGUIs.add(DbJcbxcbxTktType);


           DbJcbxcbxCnty1 =
              new exgui.DataBindJCombobox(cbxCnty1,"CNTY_1",
                                          newtimes.preproduction.guis.tempProperties.tmpCountries,"CNTY_NAME","CNTY_NAME",
                                          recToMapping.get("CNTY_1"),"",null);
         dataBoundGUIs.add(DbJcbxcbxCnty1);

          DbJcbxcbxCnty2 =
             new exgui.DataBindJCombobox(cbxCnty2,"CNTY_2",
                                         newtimes.preproduction.guis.tempProperties.tmpCountries,"CNTY_NAME","CNTY_NAME",
                                         recToMapping.get("CNTY_2"),"",null);
         dataBoundGUIs.add(DbJcbxcbxCnty2);

         DbJcbxcbxCnty3 =
            new exgui.DataBindJCombobox(cbxCnty3,"CNTY_3",
                                        newtimes.preproduction.guis.tempProperties.tmpCountries,"CNTY_NAME","CNTY_NAME",
                                        recToMapping.get("CNTY_3"),"",null);
        dataBoundGUIs.add(DbJcbxcbxCnty3);

        DbJcbxcbxCnty4 =
           new exgui.DataBindJCombobox(cbxCnty4,"CNTY_4",
                                       newtimes.preproduction.guis.tempProperties.tmpCountries,"CNTY_NAME","CNTY_NAME",
                                       recToMapping.get("CNTY_4"),"",null);
            dataBoundGUIs.add(DbJcbxcbxCnty4);

            Object vftxtDesc = exgui.verification.CellFormat.
                getOrdinaryFieldNotAllowNull(4000);
            dataBoundGUIs.add(
                new exgui.DataBindTextWithChecker(txtVhDesc, "VH_DESC",
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

                Object vfyDate  =exgui.verification.CellFormat.getDateStringFormaterAllowNull();
                dataBoundGUIs.add(
                    new exgui.DataBindTextWithChecker(txtBillDate, "BILL_DATE",
                                                      recToMapping.get("BILL_DATE"), 10,
                                                      (exgui.Object2String)vfyDate,
                                                      (exgui.ultratable.
                                                       CellTxtEditorFormat)vfyDate)

                    );

                        cbxCnty1.addItemListener(new java.awt.event.ItemListener() {
                          public void itemStateChanged(ItemEvent e) {
                            updateDescriptionTextField();
                          }
                        });

                        cbxCnty2.addItemListener(new java.awt.event.ItemListener() {
                          public void itemStateChanged(ItemEvent e) {
                            updateDescriptionTextField();
                          }
                        });
                        cbxCnty3.addItemListener(new java.awt.event.ItemListener() {
                          public void itemStateChanged(ItemEvent e) {
                            updateDescriptionTextField();
                          }
                        });
                        cbxCnty4.addItemListener(new java.awt.event.ItemListener() {
                          public void itemStateChanged(ItemEvent e) {
                            updateDescriptionTextField();
                          }
                        });


         Constants.adjFloat(txtDbAmt);
         btnExit.grabFocus();
      }catch(Exception exp){
        exp.printStackTrace();
        util.ExceptionLog.exp2File(exp,"");
        exgui.verification.VerifyLib.showAlert("Error In initializing Editig GUI\nPlease Contact System Manager",
                                               "Error In initializing Editig GUI");
      }
    }
    public void doPrint(){}
    void updateDescriptionTextField(){
      String staffName=null;
      StringBuffer sb=new StringBuffer();
      Object selectedStaffId=dbCbxStaff.getSelectedValue();
      if(null!=selectedStaffId){
        database.datatype.Record recStaff =
            (database.datatype.Record)Constants.HT_STAFF_ID_REC.get(
            selectedStaffId);
        staffName = (String)recStaff.get(1);
        //sb.append(staffName);
      }
      if(staffName!=null){
        if(DbJcbxcbxCnty1.getSelectedValue()!=null){
          sb.append(" ");
          sb.append(DbJcbxcbxCnty1.getSelectedValue());
        }
        if(DbJcbxcbxCnty2.getSelectedValue()!=null){
          sb.append(" ");
          sb.append(DbJcbxcbxCnty2.getSelectedValue());
        }
        if(DbJcbxcbxCnty3.getSelectedValue()!=null){
          sb.append(" ");
          sb.append(DbJcbxcbxCnty3.getSelectedValue());
        }
        if(DbJcbxcbxCnty4.getSelectedValue()!=null){
          sb.append(" ");
          sb.append(DbJcbxcbxCnty4.getSelectedValue());
        }
      }
      String finalDesc=staffName;
      if(sb.length()>0){
        finalDesc+=("至"+sb.toString()+"機票");
      }
      txtVhDesc.setText(finalDesc);
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
            Constants.Pnl_Tbl2EditDailyVoucher.getJtable().setValueAt(strAmt.toString(),row,
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
      if(dbCbxStaff.getSelectedValue()==null){
        exgui.verification.VerifyLib.showAlert("Please Select Staff","Please Select Staff");
        return false;
      }
      if(txtDbAmt.getText().trim().length()==0){
        exgui.verification.VerifyLib.showAlert("Please Input Amount","Please Input Amount");
        return false;
      }

      if(txtBillDate.getText().trim().length()==0){
        exgui.verification.VerifyLib.showAlert("請輸入開票日","請輸入開票日");
        return false;
      }

      if(DbJcbxcbxCnty1.getSelectedValue()==null &&
         DbJcbxcbxCnty2.getSelectedValue()==null &&
         DbJcbxcbxCnty3.getSelectedValue()==null &&
         DbJcbxcbxCnty4.getSelectedValue()==null){
         exgui.verification.VerifyLib.showAlert("請至少選一個出差國","請至少選一個出差國");
         return false;
      }

      if(txtVhDesc.getText().trim().length()==0){
        exgui.verification.VerifyLib.showAlert("Please Input Description","Please Input Description");
        return false;
      }


      return true;
    }
  }

  void btnOK_actionPerformed(ActionEvent e) {
     pnl22Eidt.OkPressed();
  }

  void btnExit_actionPerformed(ActionEvent e) {
     if(pnl22Eidt.isContextModified()){
       if(!exgui.verification.VerifyLib.showConfirm("Context Modified But Not Confirmed Yet\nAre You Sure to Exit ?",
                                                    "Modified but not confirmed",false))return;
     }
     pThis.dispose();
  }
}
