package newtimes.general_voucher.rush;

import java.awt.*;
import exgui.*;
import javax.swing.*;
import java.awt.event.*;
import database.datatype.Record;
import java.util.*;
/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class PnlRxChkBalanace extends JPanel {
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel1 = new BlueBkgWhiteCharLabel();
  WhiteBkgBlueCharLabel whiteBkgBlueCharLabel1 = new WhiteBkgBlueCharLabel();
  JComboBox cbxCompany = new JComboBox();
  WhiteBkgBlueCharLabel whiteBkgBlueCharLabel2 = new WhiteBkgBlueCharLabel();
  JTextField txtAccYYYYMM = new JTextField();
  WhiteBkgBlueCharLabel whiteBkgBlueCharLabel3 = new WhiteBkgBlueCharLabel();
  JTextField txtRushYYYYMM = new JTextField();
  JButton btnQry = new JButton();
  JButton btnExit = new JButton();
  //JPanel pnlList = new JPanel();
  Panel2List pnlList=null;
  DataBindJCombobox dbCbxCompany;
  public PnlRxChkBalanace() {
    try {
      jbInit();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }

  void jbInit() throws Exception {
    blueBkgWhiteCharLabel1.setText("CHECK BALANCE");
    blueBkgWhiteCharLabel1.setBounds(new Rectangle(-1, 5, 804, 25));
    this.setBackground(new Color(202, 202, 224));
    this.setLayout(null);
    whiteBkgBlueCharLabel1.setFont(new java.awt.Font("Dialog", 0, 16));
    whiteBkgBlueCharLabel1.setText("公司");
    whiteBkgBlueCharLabel1.setBounds(new Rectangle(2, 38, 51, 24));
    cbxCompany.setBounds(new Rectangle(54, 38, 179, 24));
    whiteBkgBlueCharLabel2.setBounds(new Rectangle(241, 38, 153, 24));
    whiteBkgBlueCharLabel2.setText("科目主檔(YYYYMM)");
    whiteBkgBlueCharLabel2.setFont(new java.awt.Font("Dialog", 0, 16));
    txtAccYYYYMM.setText("");
    txtAccYYYYMM.setBounds(new Rectangle(395, 38, 57, 24));
    whiteBkgBlueCharLabel3.setFont(new java.awt.Font("Dialog", 0, 16));
    whiteBkgBlueCharLabel3.setText("沖漲檔(YYYYMM)");
    whiteBkgBlueCharLabel3.setBounds(new Rectangle(470, 38, 160, 24));
    txtRushYYYYMM.setBounds(new Rectangle(629, 38, 57, 24));
    txtRushYYYYMM.setText("");
    btnQry.setBounds(new Rectangle(711, 37, 84, 29));
    btnQry.setFont(new java.awt.Font("Dialog", 1, 11));
    btnQry.setText("QUERY");
    btnQry.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnQry_actionPerformed(e);
      }
    });
    btnExit.setBounds(new Rectangle(340, 533, 87, 27));
    btnExit.setFont(new java.awt.Font("Dialog", 1, 11));
    btnExit.setText("EXIT");
    btnExit.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnExit_actionPerformed(e);
      }
    });
    //pnlList.setBounds(new Rectangle(5, 70, 778, 463));
    this.add(blueBkgWhiteCharLabel1, null);
    this.add(whiteBkgBlueCharLabel1, null);
    this.add(cbxCompany, null);
    this.add(whiteBkgBlueCharLabel2, null);
    this.add(txtAccYYYYMM, null);
    this.add(whiteBkgBlueCharLabel3, null);
    this.add(btnQry, null);
    this.add(txtRushYYYYMM, null);
    //this.add(pnlList, null);
    this.add(btnExit, null);
    dbCbxCompany =
      new exgui.DataBindJCombobox(cbxCompany, "",
                                  newtimes.general_voucher.daily_voucher.
                                  Constants.VCT_GV_ACC_COMPANY,
                                  "comp_code_and_name", "cmp_code",null);
  Object objyyyymmVfy=exgui.verification.CellFormat.getIntVerifierAllowNull(6);
  exgui.DataBindTextWithChecker dbTxtRxYYYYMM= new exgui.DataBindTextWithChecker(txtRushYYYYMM,
                           "P_YYYYMM",
                           "999999", 6,
                           (exgui.Object2String)objyyyymmVfy,
                           (exgui.ultratable.CellTxtEditorFormat)objyyyymmVfy);

   exgui.DataBindTextWithChecker dbTxtAccYYYYMM= new exgui.DataBindTextWithChecker(txtAccYYYYMM,
                            "P_YYYYMM",
                            "999999", 6,
                            (exgui.Object2String)objyyyymmVfy,
                            (exgui.ultratable.CellTxtEditorFormat)objyyyymmVfy);


  }
  class TempDb extends exgui.ultratable.PagedDataFactoryAdapter{
   public java.util.Vector getRecords(int bgn,int rowcount) throws Exception{
     util.MiscFunc.showProcessingMessage();
     java.text.NumberFormat nf=new java.text.DecimalFormat("###############.00");
     String cmpCode=(String)dbCbxCompany.getSelectedValue();
     String rxYYYYMM=txtRushYYYYMM.getText().trim();
     String accYYYYMM=txtAccYYYYMM.getText().trim();
     StringBuffer sb=new StringBuffer();
     sb.append("select ");
     sb.append("A.ACC_CODE , ");
     sb.append("(select  ITEM_NAME from gv_acc_item where item_code=a.acc_code ) as acc_zh_tw_name, ");
     sb.append("GET_RUSH_BLNC('");sb.append(cmpCode);sb.append("','");sb.append(rxYYYYMM);sb.append("',A.ACC_CODE) as blc_rush_amt, ");
     sb.append("GET_ACC_CODE_BLNC('");sb.append(cmpCode);sb.append("','");sb.append(accYYYYMM);sb.append("',A.ACC_CODE) as blc_acc_item_amt ");
     sb.append("from VH_RX_ACC_ITEM a ");
     java.util.Vector vctReturn=new java.util.Vector();

     java.util.Vector vct= exgui2.CONST.BASIC_MAIN_EJB.getDatas(
      util.PublicVariable.USER_RECORD,sb.toString(),1,999999);
     for(int i=0;i<vct.size();i++){
       Record rec=(Record)vct.get(i);
       rec.getFieldName().add("IS_DIFF");
       double dblRxBlance=((rec.get(2)==null)?0:rec.getDouble(2));
       double dblAccBlance=((rec.get(3)==null)?0:rec.getDouble(3));
       if(dblRxBlance!=dblAccBlance){
         rec.getValueFields().add("X");
       }else{
         rec.getValueFields().add(null);
       }

       rec.set(2,(dblRxBlance==0)?"":nf.format(dblRxBlance));
       rec.set(3,(dblAccBlance==0)?"":nf.format(dblAccBlance));
       vctReturn.add(rec);
     }
     util.MiscFunc.hideProcessingMessage();
     return vctReturn;
   }
  }
  class Panel2List extends processhandler.template.PnlTableEditor{
    public Panel2List(exgui.ultratable.PagedDataFactory pagedDataFxy,
                      int rowCounts,util.InsertionOrderedHashMap columnMapping,
                     java.util.Hashtable object2StringConvertor){
        super(pagedDataFxy, rowCounts, columnMapping, object2StringConvertor);
        getLowerRightPanel().removeAll();
        jbtn1st.setVisible(false);
        jbtnNext.setVisible(false);
        jbtnPrev.setVisible(false);
        jbtnLast.setVisible(false);
    }
    public void doPrint(){}
    public void makeTable(Vector vct){
      super.makeTable(vct);
    }
    public int getEachPageRowCount(){return _rowCounts;}
    public Hashtable getObject2StringConvertor() {return klmObjKvtHt;}
    public util.InsertionOrderedHashMap getHeadColumnMap(){return tblHeadColumn;}
    public exgui.ultratable.PagedDataFactory getPagedDataFactory(){return dbHandler;}
    public Record setObject2Record(Record rec,int col,Object obj){
      return null;
    }
    public void refineEditors(exgui.ultratable.MultiEditorJTable me ){
      me.setTextEditorVerifiers(getObject2StringConvertor());
    }
  }


  void genList(){
    if(pnlList!=null){
      this.remove(pnlList);
    }
    util.InsertionOrderedHashMap iso=new util.InsertionOrderedHashMap();
    iso.put("CODE","ACC_CODE");
    iso.put("  NAME  ","ACC_ZH_TW_NAME");
    iso.put("     RUSH BALANCE    ","BLC_RUSH_AMT");
    iso.put("X","IS_DIFF");
    iso.put("     ACC BALANCE         ","BLC_ACC_ITEM_AMT");
    pnlList=new Panel2List(new TempDb(),9999,iso,new java.util.Hashtable());
    pnlList.setBounds(new Rectangle(5, 70, 778, 463));
    this.add(pnlList,null);
    pnlList.firstPage();
    this.validate();
  }
  void btnQry_actionPerformed(ActionEvent e) {
    if(txtAccYYYYMM.getText().trim().length()!=6){
      exgui.verification.VerifyLib.showAlert("請檢查科目之YYYYMM","請檢查科目之YYYYMM");
    }
    if(txtRushYYYYMM.getText().trim().length()!=6){
      exgui.verification.VerifyLib.showAlert("請檢查沖帳檔之YYYYMM","請檢查沖帳檔之YYYYMM");
    }
    genList();
  }

  void btnExit_actionPerformed(ActionEvent e) {
    try{
      processhandler.template.Properties.getCenteralControler().goBack();
    }catch(Exception exp){
      exp.printStackTrace();
    }

  }
}
