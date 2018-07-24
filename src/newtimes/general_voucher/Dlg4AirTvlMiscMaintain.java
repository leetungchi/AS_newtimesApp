package newtimes.general_voucher;

import java.awt.*;
import javax.swing.*;
import exgui.*;
import javax.swing.border.*;
import java.awt.event.*;
import database.datatype.*;
import java.util.*;
/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class Dlg4AirTvlMiscMaintain extends JDialog {
  JPanel pnl2Edit = new JPanel();
  BlueBkgWhiteCharLabel lblTitle = new BlueBkgWhiteCharLabel();
  //JPanel pnlList = new JPanel();
  Border border1;
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel2 = new BlueBkgWhiteCharLabel();
  JTextField txtKey = new JTextField();
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel3 = new BlueBkgWhiteCharLabel();
  JTextField txtValue = new JTextField();
  JButton btnUpdate = new JButton();
  JButton btnCancel = new JButton();
  JButton btnClose = new JButton();
  JButton btnDelete = new JButton();
  static String tableName;
  static int KEY_FIELD_LENGTH,VALUE_FIELD_LENGTH;
  static String KeyColumnNameInDb,ValueColumnNameInDb;
  static String REF_COLUMN=null;
  exgui.ultratable.PagedTablePanel pnlList;
  boolean isRecordInUsed=false;
  public Dlg4AirTvlMiscMaintain(Frame frame, String title, boolean modal) {
    super(frame, title, modal);
    try {
      jbInit();
      pack();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }


  class TempDb extends exgui.ultratable.PagedDataFactoryAdapter{
    Record recOrgBlank=null;
    public Record getBlankRecord(){
      try{
        if(null==recOrgBlank){
          recOrgBlank = (Record)newtimes.preproduction.guis.tempProperties.tmpUnits.get(0);
          recOrgBlank.getFieldName().clear();
          recOrgBlank.getValueFields().clear();
          recOrgBlank.getFieldName().add(KeyColumnNameInDb);
          recOrgBlank.getFieldName().add(ValueColumnNameInDb);
          recOrgBlank.getValueFields().add(null);
          recOrgBlank.getValueFields().add(null);
        }
        return (Record)util.MiscFunc.deepCopy(recOrgBlank);
      }catch(Exception exp){
        return null;
      }
    }
   public Vector getRecords(int bgn,int rwocount)throws Exception{
     Vector vctOrg=exgui2.CONST.BASIC_MAIN_EJB.getDatas(
        util.PublicVariable.USER_RECORD,
        "select a.* ,(select count(*) from VH_DTL_TKT where "+REF_COLUMN+"=a."+KeyColumnNameInDb+") as used from "+tableName+" a",1,99999
      );
     Vector vct=new Vector();
     for(int i=0;i<vctOrg.size();i++){
       Record rec=(Record)vctOrg.get(i);
       int usedCount=rec.getInt("used");
       if(usedCount>0){
         rec.set("used","V");
       }else{
         rec.set("used","");
       }
       vct.add(rec);
     }
     return vct;
   }
  }


  public Dlg4AirTvlMiscMaintain() {
    this(null, "", false);
  }


  private void jbInit() throws Exception {
    //border1 = new EtchedBorder(EtchedBorder.RAISED,Color.white,new Color(148, 145, 140));
    util.InsertionOrderedHashMap iso=new util.InsertionOrderedHashMap();
    java.util.Hashtable ht=new java.util.Hashtable();
    iso.put("KEY",KeyColumnNameInDb);
    iso.put("      VALUE    ",ValueColumnNameInDb);
    iso.put("USE ","USED");
    pnlList=new exgui.ultratable.PagedTablePanel(new TempDb(),99999,iso,ht);
    pnl2Edit.setLayout(null);
    lblTitle.setFont(new java.awt.Font("Dialog", 0, 16));
    lblTitle.setText("xx ºûÅ@³æ¤¸");
    lblTitle.setBounds(new Rectangle(-1, 11, 549, 35));
    //pnlList.setBorder(border1);
    pnlList.setBounds(new Rectangle(20, 55, 475, 245));
    blueBkgWhiteCharLabel2.setText("KEY :");
    blueBkgWhiteCharLabel2.setBounds(new Rectangle(8, 309, 56, 25));
    txtKey.setText("");
    txtKey.setBounds(new Rectangle(65, 309, 44, 26));
    blueBkgWhiteCharLabel3.setBounds(new Rectangle(114, 309, 70, 25));
    blueBkgWhiteCharLabel3.setText("VALUE :");
    txtValue.setBounds(new Rectangle(183, 309, 137, 26));
    txtValue.setText("");
    btnUpdate.setBounds(new Rectangle(323, 307, 60, 29));
    btnUpdate.setFont(new java.awt.Font("Dialog", 1, 11));
    btnUpdate.setMargin(new Insets(0, 0, 0, 0));
    btnUpdate.setText("UPDATE");
    btnUpdate.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnUpdate_actionPerformed(e);
      }
    });
    btnCancel.setText("CANCEL");
    btnCancel.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnCancel_actionPerformed(e);
      }
    });
    btnCancel.setMargin(new Insets(0, 0, 0, 0));
    btnCancel.setBounds(new Rectangle(390, 307, 60, 29));
    btnCancel.setFont(new java.awt.Font("Dialog", 1, 11));
    btnCancel.setForeground(Color.black);
    btnClose.setBounds(new Rectangle(166, 344, 141, 28));
    btnClose.setFont(new java.awt.Font("Dialog", 1, 11));
    btnClose.setText("CLOSE");
    btnClose.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnClose_actionPerformed(e);
      }
    });
    btnDelete.setText("DELETE");
    btnDelete.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnDelete_actionPerformed(e);
      }
    });
    btnDelete.setMargin(new Insets(0, 0, 0, 0));
    btnDelete.setFont(new java.awt.Font("Dialog", 1, 11));
    btnDelete.setForeground(Color.red);
    btnDelete.setBounds(new Rectangle(458, 307, 60, 29));
    getContentPane().add(pnl2Edit);
    pnl2Edit.add(lblTitle, null);
    pnl2Edit.add(pnlList, null);
    pnl2Edit.add(blueBkgWhiteCharLabel2, null);
    pnl2Edit.add(txtKey, null);
    pnl2Edit.add(btnClose, null);
    pnl2Edit.add(blueBkgWhiteCharLabel3, null);
    pnl2Edit.add(txtValue, null);
    pnl2Edit.add(btnUpdate, null);
    pnl2Edit.add(btnCancel, null);
    pnl2Edit.add(btnDelete, null);
    pnlList.getJtable().addMouseListener(
        new java.awt.event.MouseAdapter(){
         public void mouseClicked(java.awt.event.MouseEvent me){
           int slkRow=pnlList.getJtable().getSelectedRow();
           if(slkRow!=-1){
             Record rec = (Record)pnlList.getDisplayingRecords().get(slkRow);
             txtKey.setText(rec.get(0).toString());
             txtValue.setText((String)rec.get(1));
             isRecordInUsed=(((String)rec.get(2)).length()>0);//the value of "used" column is "V" or blank.
             txtKey.setEditable(false);
             btnUpdate.setText("UPDATE");
             btnDelete.setEnabled(true);
           }
        }
       }
      );
      //bind control of text length
      Object vctItemRange=exgui.verification.CellFormat.getOrdinaryField(KEY_FIELD_LENGTH);
      DataBindTextWithChecker dbTxtKeyFiled = new exgui.
          DataBindTextWithChecker(txtKey,
                                  "",
                                  null, KEY_FIELD_LENGTH,
                                  (exgui.Object2String)vctItemRange,
                                  (exgui.ultratable.CellTxtEditorFormat)
                                  vctItemRange);

      Object vfyValue=exgui.verification.CellFormat.getOrdinaryField(VALUE_FIELD_LENGTH);
      DataBindTextWithChecker dbTxtValeFiled = new exgui.
          DataBindTextWithChecker(txtValue,
                                  "",
                                  null, VALUE_FIELD_LENGTH,
                                  (exgui.Object2String)vfyValue,
                                  (exgui.ultratable.CellTxtEditorFormat)
                                  vfyValue);
      btnDelete.setEnabled(false);
      btnUpdate.setText("ADD NEW");
      isRecordInUsed=false;
  }

  void btnUpdate_actionPerformed(ActionEvent e) {
     //if is add new check if key duplicated.
      String btnText=btnUpdate.getText().toUpperCase();
      String valueString=txtValue.getText().trim().toUpperCase();
      if(valueString.length()==0){
        exgui.verification.VerifyLib.showAlert("Please Input Value","Please Input Value");
        return;
      }
      String key=txtKey.getText().trim().toUpperCase();
      if("UPDATE".equalsIgnoreCase(btnText)){
          callEjb2Proc(key,valueString,false);
      }else{
        if(key.length()==0){
          exgui.verification.VerifyLib.showAlert("KEY CAN NOT BE BLANK","KEY CAN NOT BE BLANK");
          return;
        }
        //test if key is duplicated.
        for(int i=0;i<pnlList.getDisplayingRecords().size();i++){
          String keyInTable=(String)pnlList.getJtable().getValueAt(i,0);
          if(keyInTable.equalsIgnoreCase(key)){
            exgui.verification.VerifyLib.showAlert("KEY DUPLICATED!!","KEY DUPLICATED!!");
            return;
          }
        }
        callEjb2Proc(key,valueString,true);
        btnCancel_actionPerformed(null);
      }
  }
  void callEjb2Proc(String key,String value,boolean isAddNew){
    //System.out.println("procee "+((isAddNew)?"ADD NEW":"UPDATE"));
    /*
     if(actionCode.equals("HANDLE_VHDTL_AIR_TKT_MISC")){
      String axn=(String)param.get("ACTION");
      String tableName=(String)param.get("TABLE_NAME");
      String key=(String)param.get("KEY");
      String value=(String)param.get("VALUE");
      String keyColumnName=(String)param.get("KEY_COLUMN_NAME");
      String valueColumnName=(String)param.get("VALUE_COLUMN_NAME");
     */
     java.util.HashMap hm=new java.util.HashMap();
     hm.put("TPEMISCFUNC_ACTION_CODE","HANDLE_VHDTL_AIR_TKT_MISC");
     hm.put("ACTION",(isAddNew)?"ADD":"UPDATE");
     hm.put("TABLE_NAME",tableName);
     hm.put("KEY",key);
     hm.put("VALUE",value);
     hm.put("KEY_COLUMN_NAME",KeyColumnNameInDb);
     hm.put("VALUE_COLUMN_NAME",ValueColumnNameInDb);
     try{
       util.MiscFunc.showProcessingMessage();;
       newtimesejb.TPE_MIS.TpeMisFuncHome ejbHome=
           (newtimesejb.TPE_MIS.TpeMisFuncHome)
           info_ejb.WeblogicServiceLocator.locateServiceHome(
           util.PublicVariable.SERVER_URL,
           "newtimesejb.TPE_MIS.TpeMisFunc");

       newtimesejb.TPE_MIS.TpeMisFunc ejb2update=ejbHome.create();
       ejb2update.tpeMisFunc(hm);
       pnlList.reload();
       util.MiscFunc.hideProcessingMessage();
     }catch(Exception exp){
       exgui.verification.VerifyLib.showAlert("Upate Failed!!","Upate Failed!!");
     }


  }
  void callEjb2ProcDelete(String key){
   java.util.HashMap hm=new java.util.HashMap();
   hm.put("TPEMISCFUNC_ACTION_CODE","HANDLE_VHDTL_AIR_TKT_MISC");
   hm.put("ACTION","DELETE");
   hm.put("TABLE_NAME",tableName);
   hm.put("KEY",key);
   //hm.put("VALUE",value);
   hm.put("KEY_COLUMN_NAME",KeyColumnNameInDb);
   hm.put("VALUE_COLUMN_NAME",ValueColumnNameInDb);
   try{
     util.MiscFunc.showProcessingMessage();
     newtimesejb.TPE_MIS.TpeMisFuncHome ejbHome=
         (newtimesejb.TPE_MIS.TpeMisFuncHome)
         info_ejb.WeblogicServiceLocator.locateServiceHome(
         util.PublicVariable.SERVER_URL,
         "newtimesejb.TPE_MIS.TpeMisFunc");

     newtimesejb.TPE_MIS.TpeMisFunc ejb2update=ejbHome.create();
     ejb2update.tpeMisFunc(hm);
     pnlList.reload();
     util.MiscFunc.hideProcessingMessage();
   }catch(Exception exp){
     exgui.verification.VerifyLib.showAlert("Upate Failed!!","Upate Failed!!");
   }

  }
  void btnCancel_actionPerformed(ActionEvent e) {
     //change to "ADD NEW" button
     btnUpdate.setText("ADD NEW");
     txtKey.setEditable(true);
     txtKey.setText("");txtValue.setText("");
     isRecordInUsed=false;
     btnDelete.setEnabled(false);
  }

  void btnDelete_actionPerformed(ActionEvent e) {
     //if is used ,show alert,not allow to delete
     if(isRecordInUsed){
       exgui.verification.VerifyLib.showAlert("Can Not Delete Referenced Record","In Used");
       return;
     }
     System.out.println("procee delete");
     callEjb2ProcDelete(txtKey.getText());
     btnCancel_actionPerformed(null);
  }

  void btnClose_actionPerformed(ActionEvent e) {
   this.dispose();

  }

}
