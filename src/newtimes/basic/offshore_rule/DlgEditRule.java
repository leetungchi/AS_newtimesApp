package newtimes.basic.offshore_rule;

import java.awt.*;
import javax.swing.*;
import exgui.*;
import newtimes.preproduction.buyermakerselect.*;
import java.awt.event.*;
import database.datatype.Record;
/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class DlgEditRule extends JDialog {
  //JPanel pnlEditor = new JPanel();
  Pnl2Edit pnlEditor=new Pnl2Edit();
  Record rec2Edit;
  JComboBox cbxCenterMaker = new JComboBox();
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel3 = new BlueBkgWhiteCharLabel();
  SelectBuyerMaker slkBuyer = new SelectBuyerMaker();
  JComboBox cbxCenter = new JComboBox();
  WhiteBkgBlueCharLabel whiteBkgBlueCharLabel2 = new WhiteBkgBlueCharLabel();
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel2 = new BlueBkgWhiteCharLabel();
  JComboBox cbxCenterBuyer = new JComboBox();
  WhiteBkgBlueCharLabel whiteBkgBlueCharLabel1 = new WhiteBkgBlueCharLabel();
  JComboBox cbxCountry = new JComboBox();
  SelectBuyerMaker slkMaker = new SelectBuyerMaker();
  JButton btnOk = new JButton();
  JButton btnDelete = new JButton();
  JButton btnExit = new JButton();
  exgui.DataBindJCombobox dbCBX_BuyerCenter,dbCBX_MakerCenter;
  exgui.ultratable.PagedTablePanel pnl2Reload;
  DlgEditRule thisObj=null;
  public DlgEditRule(Frame frame, String title, boolean modal,Record _rec2Edit) {
    super(frame, title, modal);
    rec2Edit=_rec2Edit;
    try {
      jbInit();
      thisObj=this;
      pack();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }

  public DlgEditRule() {
    this(null, "", false,null);
  }

  private void jbInit() throws Exception {
    pnlEditor.setLayout(null);
    pnlEditor.setBackground(new Color(204, 204, 225));
    cbxCenterMaker.setBounds(new Rectangle(117, 90, 167, 26));
    blueBkgWhiteCharLabel3.setBounds(new Rectangle(287, 147, 85, 25));
    blueBkgWhiteCharLabel3.setText("CENTER");
    slkBuyer.setBounds(new Rectangle(284, 42, 250, 25));
    cbxCenter.setBounds(new Rectangle(372, 147, 167, 26));
    whiteBkgBlueCharLabel2.setBounds(new Rectangle(32, 147, 85, 25));
    whiteBkgBlueCharLabel2.setText("COUNTRY");
    blueBkgWhiteCharLabel2.setText("MAKER");
    blueBkgWhiteCharLabel2.setBounds(new Rectangle(32, 91, 85, 25));
    cbxCenterBuyer.setBounds(new Rectangle(117, 42, 167, 25));
    whiteBkgBlueCharLabel1.setText("BUYER");
    whiteBkgBlueCharLabel1.setBounds(new Rectangle(32, 44, 85, 25));
    cbxCountry.setBounds(new Rectangle(117, 147, 167, 25));
    slkMaker.setBounds(new Rectangle(284, 90, 250, 25));
    btnOk.setBounds(new Rectangle(49, 215, 86, 30));
    btnOk.setFont(new java.awt.Font("Dialog", 1, 11));
    btnOk.setText("OK");
    btnOk.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnOk_actionPerformed(e);
      }
    });
    btnDelete.setText("DELETE");
    btnDelete.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnDelete_actionPerformed(e);
      }
    });
    btnDelete.setBounds(new Rectangle(218, 215, 86, 30));
    btnDelete.setFont(new java.awt.Font("Dialog", 1, 11));
    btnDelete.setForeground(Color.red);
    btnExit.setText("EXIT");
    btnExit.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnExit_actionPerformed(e);
      }
    });
    btnExit.setBounds(new Rectangle(386, 215, 86, 30));
    btnExit.setFont(new java.awt.Font("Dialog", 1, 11));
    getContentPane().add(pnlEditor);
    pnlEditor.add(blueBkgWhiteCharLabel3, null);
    pnlEditor.add(whiteBkgBlueCharLabel1, null);
    pnlEditor.add(cbxCenterBuyer, null);
    pnlEditor.add(slkBuyer, null);
    pnlEditor.add(blueBkgWhiteCharLabel2, null);
    pnlEditor.add(cbxCenterMaker, null);
    pnlEditor.add(slkMaker, null);
    pnlEditor.add(whiteBkgBlueCharLabel2, null);
    pnlEditor.add(cbxCountry, null);
    pnlEditor.add(cbxCenter, null);
    pnlEditor.add(btnDelete, null);
    pnlEditor.add(btnOk, null);
    pnlEditor.add(btnExit, null);
    if(rec2Edit.getInt("record_delete_flag")==-1){
      btnDelete.setEnabled(false);
    }
    pnlEditor.setRecord(rec2Edit);
    pnlEditor.record2Gui();
    cbxCenterMaker.addItemListener(new java.awt.event.ItemListener() {
      public void itemStateChanged(ItemEvent e) {
        cbxCenterMaker_itemStateChanged(e);
      }
    });
    cbxCenterBuyer.addItemListener(new java.awt.event.ItemListener() {
      public void itemStateChanged(ItemEvent e) {
        cbxCenterBuyer_itemStateChanged(e);
      }
    });


  }
   class Pnl2Edit extends processhandler.template.PnlFieldsEditor{
    public void jbInit(){

    }
    protected  void handleRec()throws Exception{
      try {
        newtimesejb.TPE_MIS.TpeMisFuncHome ejbHome=
            (newtimesejb.TPE_MIS.TpeMisFuncHome)
            info_ejb.WeblogicServiceLocator.locateServiceHome(
            util.PublicVariable.SERVER_URL,
            "newtimesejb.TPE_MIS.TpeMisFunc");

        newtimesejb.TPE_MIS.TpeMisFunc ejb2update=ejbHome.create();
        java.util.HashMap hmParam=new java.util.HashMap();
        hmParam.put("TPEMISCFUNC_ACTION_CODE","PROCESS_OFFSHORE_RULE");
        recToMapping.set("record_modify_user",util.PublicVariable.USER_RECORD.get(0));
        hmParam.put("OFFSHORE_RECORD_TO_PROCESS",recToMapping);
        ejb2update.tpeMisFunc(hmParam);
      }catch(Exception exp){
        exp.printStackTrace();
      }

    }
    public void doDelete(){
      try{
        recToMapping.set("record_delete_flag", "0");
        handleRec();
        pnl2Reload.reload();
        thisObj.dispose();
      }catch(Exception exp){
        exp.printStackTrace();
        util.ExceptionLog.exp2File(exp,"");
        exgui.verification.VerifyLib.showAlert("Delete Failed!!\nPlease Contact System Manager",
                                               "Delete Failed");
      }
    }
    public void doUpdate()throws Exception{
      //key of RULE is  BUyER + MAKER + COUNTRY
      //if is new record,test if already have such rule
      //if is old rec,test if OTHER records constins cuch rule
      if(!gui2Record())return;
      Object objBuyer=slkBuyer.getSelectedValue();
      Object objMaker=slkMaker.getSelectedValue();
      Object objCnty=cbxCountry.getSelectedItem();
      StringBuffer sb=new StringBuffer();
      sb.append(" select count(*) from offshore_rule where BUYER_ID=");
      sb.append(objBuyer);sb.append(" and Maker_ID=");sb.append(objMaker);
      sb.append(" and COUNTRY='");sb.append(util.MiscFunc.Replace(objCnty.toString(),"'","''"));
      sb.append("' ");
      boolean isNew=true;
      if(recToMapping.getInt("record_delete_flag")!=-1){
        sb.append(" and RULE_SEQ <> ");sb.append(recToMapping.get("RULE_SEQ"));
        isNew=false;
      }
      java.util.Vector vctChk=exgui2.CONST.BASIC_MAIN_EJB.getDatas(
      util.PublicVariable.USER_RECORD,sb.toString(),1,9999);
      Record rec2test=(Record)vctChk.get(0);
      if(rec2test.getInt(0)>0){
        exgui.verification.VerifyLib.showAlert("RULE Already Exists","Rule Already Exists");
        return;
      }
      handleRec();
      if(!isNew) pnl2Reload.reload();
      thisObj.dispose();
    }
    public void record2Gui(){

      try{
        slkBuyer.init("BUYER_ID",recToMapping.get("BUYER_ID"),slkBuyer.TYPE_BUYER,true);
        slkMaker.init("MAKER_ID",recToMapping.get("MAKER_ID"),slkBuyer.TYPE_MAKER,true);

        dataBoundGUIs.clear();
        java.util.Vector centRecords=
            exgui2.CONST.BASIC_MAIN_EJB.getDatas(
            util.PublicVariable.USER_RECORD,
            "select * from center ",1,9999);

        exgui.DataBindJCombobox dbCBX_Center= new exgui.DataBindJCombobox(
              cbxCenter,"CENTER",
              centRecords,"CEN_NAME",
              "CEN_CODE",
              recToMapping.get("CENTER"));
        dataBoundGUIs.add(dbCBX_Center);

        dbCBX_BuyerCenter= new exgui.DataBindJCombobox(
              cbxCenterBuyer,"CENTER",
              centRecords,"CEN_NAME",
              "CEN_CODE",null
              );


        dbCBX_MakerCenter= new exgui.DataBindJCombobox(
                cbxCenterMaker,"CENTER",
                centRecords,"CEN_NAME",
                "CEN_CODE",null
                );


       exgui.DataBindJCombobox DbJcbxcbxQcCountry =
           new exgui.DataBindJCombobox(cbxCountry,
                                       "COUNTRY",
                                       newtimes.preproduction.guis.tempProperties.tmpCountries,
                                       "CNTY_NAME", "CNTY_NAME",
                                       recToMapping.get("COUNTRY")
                                       );

       dataBoundGUIs.add(DbJcbxcbxQcCountry);

      }catch(Exception exp){
        exp.printStackTrace();
      }
    }

    public void doPrint(){}
    public boolean gui2Record(){
      boolean result= super.gui2Record();
      if(!result)return result;
      if(slkBuyer.getSelectedValue()==null){
       exgui.verification.VerifyLib.showAlert("Please Assigne Buyer","Please Assigne Buyer");
       return false;
      }
      if(slkMaker.getSelectedValue()==null){
       exgui.verification.VerifyLib.showAlert("Please Assigne Maker","Please Assigne Maker");
       return false;
      }
      try{
        recToMapping.set("BUYER_ID", slkBuyer.getSelectedValue());
        recToMapping.set("MAKER_ID", slkMaker.getSelectedValue());
      }catch(Exception exp){
        exp.printStackTrace();
        util.ExceptionLog.exp2File(exp,"");
        exgui.verification.VerifyLib.showAlert("Error !! Please Contact System Manager","Error");
      }
      return true;
    }
   }

  void cbxCenterBuyer_itemStateChanged(ItemEvent e) {
     slkBuyer.setSelectingCenter((String)dbCBX_BuyerCenter.getSelectedValue());
     slkBuyer.init("BUYER_ID",null,slkBuyer.TYPE_BUYER,true);
  }

  void cbxCenterMaker_itemStateChanged(ItemEvent e) {
    slkMaker.setSelectingCenter((String)dbCBX_MakerCenter.getSelectedValue());
    slkMaker.init("MAKER_ID",null,slkBuyer.TYPE_MAKER,true);
  }

  void btnExit_actionPerformed(ActionEvent e) {
    if(!pnlEditor.isContextModified()){
      this.dispose();
    }else{
      if(exgui.verification.VerifyLib.showConfirm("Context Modified\nAre You Sure To Exit ?","Context Modified",false)){
        this.dispose();
      }
    }
  }

  void btnDelete_actionPerformed(ActionEvent e) {
    if(!exgui.verification.VerifyLib.showConfirm("Are You Sure To Delete ?","Are You Sure ?",false)){
      return;
    }
    pnlEditor.doDelete();

  }

  void btnOk_actionPerformed(ActionEvent e) {
    try{
      pnlEditor.doUpdate();
    }catch(Exception exp){
       exp.printStackTrace();
       util.ExceptionLog.exp2File(exp,"");
       exgui.verification.VerifyLib.showAlert("Update Failed\nPlease Contact System Manager",
                                              "Update Failed");
    }
  }

}
