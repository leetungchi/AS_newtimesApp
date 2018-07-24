package newtimes.accounting.debit_note;

import java.awt.*;
import exgui.*;
import javax.swing.*;
import newtimes.preproduction.buyermakerselect.*;
import javax.swing.border.*;
import newtimes.preproduction.buyermakerselect.*;
import java.awt.event.*;
import newtimes.production.report.*;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class PnlStatementOfAccounting
    //extends JPanel
    extends AbsQryPanel
    implements   newtimes.preproduction.buyermakerselect.BuyerMakerChanged {
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel1 = new BlueBkgWhiteCharLabel();
  JLabel jLabel1 = new JLabel();
  JComboBox cbxDep = new JComboBox();
  SelectBuyerMaker slkMaker = new SelectBuyerMaker();
  JLabel jLabel3 = new JLabel();
  JPanel pnlLess = new JPanel();
  TitledBorder titledBorder1;
  BlueBkgWhiteCharLabel lblDescTitle = new BlueBkgWhiteCharLabel();
  BlueBkgWhiteCharLabel lblDescAmtTitle = new BlueBkgWhiteCharLabel();

  JTextField txtDesc[]=new JTextField[15];
  JTextField txtAmt[]=new JTextField[15];

  /*
  //---------preserve for layout------
  JTextField txtDesc0 = new JTextField();
  JTextField txtAmt0 = new JTextField();
  JTextField txtDesc1 = new JTextField();
  JTextField txtAmt1 = new JTextField();
  JTextField txtDesc3 = new JTextField();
  JTextField txtDesc2 = new JTextField();
  JTextField txtAmt3 = new JTextField();
  JTextField txtAmt2 = new JTextField();
  //-----------------------------------------
  */
  JButton btnQry = new JButton();
  GridLayout gridLayout1 = new GridLayout(16,1);
  JScrollPane jScrollPane1 = new JScrollPane();
  java.awt.BorderLayout borderlayout=new java.awt.BorderLayout();
  JTextField txtAsOf = new JTextField();
  JLabel jLabel4 = new JLabel();
  JTextField txtDbcrYYYYMM = new JTextField();
  static public boolean isMakerStatmentRpt=true;
  JLabel jLabel5 = new JLabel();
  JComboBox cbxBuyerName = new JComboBox();
  JComboBox cbxBuyerMakerType =null;
  exgui.DataBindJCombobox DbJcbxBuyerName;
  JLabel jLabel6 = new JLabel();
  JComboBox cbxRowGap = new JComboBox(new String[]{"SMALL","MIDDLE","LARGE"});
  public PnlStatementOfAccounting() {
    try {
      jbInit();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }

 public void jbInit() throws Exception {
     cbxRowGap.setSelectedIndex(1);
     if(isMakerStatmentRpt){
       cbxBuyerMakerType=new JComboBox(new String[]{"MAKER"});
     }else{
       cbxBuyerMakerType=new JComboBox(new String[]{"BUYER","OTHER"});
     }

    titledBorder1 = new TitledBorder(BorderFactory.createEtchedBorder(Color.white,new Color(148, 145, 140)),"LESS");
    blueBkgWhiteCharLabel1.setText(((isMakerStatmentRpt)?"MAKER":"BUYER")+" STATEMENT OF ACCOUNT");
    blueBkgWhiteCharLabel1.setBounds(new Rectangle(-1, 1, 801, 25));
    this.setLayout(null);
    jLabel1.setFont(new java.awt.Font("Dialog", 1, 11));
    jLabel1.setText("DEP.");
    jLabel1.setBounds(new Rectangle(6, 30, 39, 25));
    cbxDep.setBounds(new Rectangle(56, 30, 181, 25));
    slkMaker.setBounds(new Rectangle(363, 30, 181, 25));
    jLabel3.setFont(new java.awt.Font("Dialog", 1, 11));
    jLabel3.setText("DB/CR# (YYMM)");
    jLabel3.setBounds(new Rectangle(629, 58, 96, 25));
    pnlLess.setLayout(gridLayout1);
    lblDescTitle.setBackground(Color.white);
    lblDescTitle.setForeground(new Color(143, 143, 188));
    lblDescTitle.setText("LESS                       DESCRIPTION");
    lblDescAmtTitle.setText("AMT");
    lblDescAmtTitle.setForeground(new Color(143, 143, 188));
    lblDescAmtTitle.setBackground(Color.white);

   /*
    //----preserve for layout-----
    txtDesc0.setText("");
    txtDesc0.setBounds(new Rectangle(9, 38, 148, 22));
    txtAmt0.setText("");
    txtAmt0.setBounds(new Rectangle(162, 38, 61, 22));


    txtDesc1.setBounds(new Rectangle(9, 63, 148, 22));
    txtDesc1.setText("");
    txtAmt1.setBounds(new Rectangle(162, 63, 61, 22));
    txtAmt1.setText("");

    txtDesc3.setText("");
    txtDesc3.setBounds(new Rectangle(229, 63, 148, 22));
    txtDesc2.setBounds(new Rectangle(229, 38, 148, 22));
    txtDesc2.setText("");
    txtAmt3.setText("");
    txtAmt3.setBounds(new Rectangle(382, 63, 61, 22));
    txtAmt2.setBounds(new Rectangle(382, 38, 61, 22));
    txtAmt2.setText("");

    //---------------------------
    */
    btnQry.setBounds(new Rectangle(574, 118, 86, 25));
    btnQry.setFont(new java.awt.Font("Dialog", 1, 11));
    btnQry.setText("REPORT");
    btnQry.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnQry_actionPerformed(e);
      }
    });
    jScrollPane1.setBorder(null);
    jScrollPane1.setBounds(new Rectangle(7, 57, 456, 89));
    pnlLess.setBorder(null);
    JPanel pnl=new JPanel();
    //pnl.setBounds(0,0,60,22);
    pnl.setLayout(borderlayout);
    lblDescTitle.setPreferredSize(new java.awt.Dimension(148, 22));
    lblDescAmtTitle.setPreferredSize(new java.awt.Dimension(61, 22));

    txtAsOf.setText("");
    txtAsOf.setBounds(new Rectangle(569, 58, 54, 24));
    jLabel4.setBounds(new Rectangle(471, 58, 96, 25));
    jLabel4.setText("As Of (YYMMDD)");
    jLabel4.setFont(new java.awt.Font("Dialog", 1, 11));
    txtDbcrYYYYMM.setText("");
    txtDbcrYYYYMM.setBounds(new Rectangle(727, 58, 55, 24));
    jLabel5.setFont(new java.awt.Font("Dialog", 1, 11));
    jLabel5.setText("NAME");
    jLabel5.setBounds(new Rectangle(562, 29, 50, 25));
    cbxBuyerName.setBounds(new Rectangle(613, 29, 170, 25));
    cbxBuyerMakerType.setBounds(new Rectangle(245, 30, 110, 25));
    cbxBuyerMakerType.addItemListener(new java.awt.event.ItemListener() {
      public void itemStateChanged(ItemEvent e) {
        cbxBuyerMakerType_itemStateChanged(e);
      }
    });
    jLabel6.setFont(new java.awt.Font("Dialog", 1, 11));
    jLabel6.setText("Row Gap");
    jLabel6.setBounds(new Rectangle(475, 80, 62, 25));
    cbxRowGap.setBounds(new Rectangle(530, 84, 127, 20));
    pnl.add(lblDescTitle,  BorderLayout.CENTER);
    pnl.add(lblDescAmtTitle,  BorderLayout.EAST);
    pnl.setPreferredSize(new java.awt.Dimension(60,22));
    pnlLess.add(pnl);
    JPanel pnltemp[]=new JPanel[15];
    for(int i=0;i<15;i++){
      txtDesc[i]=new JTextField();
      txtDesc[i].setText("");

      txtAmt[i]=new JTextField();
      txtAmt[i].setText("");

      pnltemp[i]=new JPanel();
      pnltemp[i].setLayout(new java.awt.BorderLayout());
      txtDesc[i].setPreferredSize(new java.awt.Dimension(148, 22));
      txtAmt[i].setPreferredSize(new java.awt.Dimension(61, 22));
      pnltemp[i].add(txtDesc[i],BorderLayout.CENTER);
      pnltemp[i].add(txtAmt[i],BorderLayout.EAST);
      pnltemp[i].setPreferredSize(new java.awt.Dimension(60,22));
      pnlLess.add(pnltemp[i]);

    }


   /*
   //------------preserve for layout----------
   pnlLess.add(txtDesc0, null);
   pnlLess.add(txtAmt0, null);
   pnlLess.add(txtDesc1, null);
   pnlLess.add(txtAmt1, null);
   pnlLess.add(txtDesc3, null);
   pnlLess.add(txtDesc2, null);
   pnlLess.add(txtAmt3, null);
   pnlLess.add(txtAmt2, null);
   //-----------------------------------------
   */





    this.add(blueBkgWhiteCharLabel1, null);
    this.add(jLabel1, null);
    this.add(cbxDep, null);

    this.add(cbxBuyerMakerType, null);
    this.add(jScrollPane1, null);
    this.add(jLabel3, null);
    this.add(jLabel4, null);
    this.add(txtAsOf, null);
    this.add(txtDbcrYYYYMM, null);
    this.add(btnQry, null);
    this.add(cbxBuyerName, null);
    this.add(jLabel5, null);
    this.add(slkMaker, null);
    jScrollPane1.getViewport().add(pnlLess, null);

    genDataBindObj();
    cbxBuyerName.setEditable(true);
  }
  public void genDataBindObj(){
    dataBindComps.clear();

    exgui.DataBindJCombobox dbCbxDep=
       new exgui.DataBindJCombobox(
            cbxDep,"P_DEP",newtimes.preproduction.guis.tempProperties.tmpDepartment,
            "DEP_NAME","DEP_CODE","ALL","ALL","ALL");

    dataBindComps.add(dbCbxDep);
    this.add(jLabel3, null);
    this.add(txtDbcrYYYYMM, null);
    this.add(jLabel6, null);
    this.add(cbxRowGap, null);
    slkMaker.init("P_MAKER",null,(isMakerStatmentRpt)?slkMaker.TYPE_MAKER:slkMaker.TYPE_BUYER,true);
    slkMaker.setModifyNotifyTo(this);
    initBuyerNameCbx("",-1,true);

    if(isMakerStatmentRpt)
      reportName="DB_STMT_LIST.rpt";
    else
      reportName="DB_BYR_STMT.rpt";


  }
  public java.util.HashMap composeParameters(){
    java.util.HashMap hm=super.composeParameters();
    hm.put("P_MAKER",(slkMaker.getSelectedValue()==null)?"0":slkMaker.getSelectedValue().toString());
    String yymm=txtDbcrYYYYMM.getText().trim();
    hm.put("P_YMC",yymm);
    String asOfDate=txtAsOf.getText().trim();
    hm.put("P_YM","date(20"+asOfDate.substring(0,2)+","+asOfDate.substring(2,4)+","+asOfDate.substring(4,6)+")");

    for(int i=0;i<txtDesc.length;i++){
      if(txtDesc[i].getText().trim().length()>0){
        hm.put("P_DESC"+String.valueOf(i+1),txtDesc[i].getText().trim());
      }else{
        hm.put("P_DESC"+String.valueOf(i+1),"");
      }
      if(txtAmt[i].getText().trim().length()>0){
        hm.put("P_AMT"+String.valueOf(i+1),txtAmt[i].getText().trim());
      }else{
        hm.put("P_AMT"+String.valueOf(i+1),"");
      }

    }
    hm.put("P_CENTER",util.PublicVariable.OPERATTING_CENTER);
    Object objBuyerName=DbJcbxBuyerName.getSelectedValue();
    if(null!=objBuyerName && objBuyerName.toString().trim().length()>0){
      hm.put("P_NAME",objBuyerName.toString().trim());
    }else{
      hm.put("P_NAME","ALL");
    }
    String grpStr=cbxRowGap.getSelectedItem().toString();
    hm.put("P_GAP",grpStr.substring(0,1));
    return hm;
  }

  void btnQry_actionPerformed(ActionEvent e) {
       if(slkMaker.getSelectedValue()==null){
         exgui.verification.VerifyLib.showAlert("Please Select Maker",
                                                "Select Maker Please");
         return ;
       }
       if(txtDbcrYYYYMM.getText().trim().length()!=4){
         exgui.verification.VerifyLib.showAlert("DB/CR# is 4 digits ,iS \"YYMM\"",
                                                "DB/CR# Format ERROR");
         txtDbcrYYYYMM.selectAll();
         txtDbcrYYYYMM.grabFocus();
         return;
       }
       if(txtAsOf.getText().trim().length()!=6){
         exgui.verification.VerifyLib.showAlert("\"As Of\" is 6 digits ,iS \"YYMMDD\"",
                                                "\"As Of\" Format ERROR");
         txtAsOf.selectAll();
         txtAsOf.grabFocus();
         return;
       }


       super.JButtonQueryButtonAction(e);
  }
  public void changeBuyerMaker(database.datatype.Record recBuyer){
  initBuyerNameCbx("",(recBuyer==null)?-1:recBuyer.getInt(0),recBuyer==null);
 }

  private void initBuyerNameCbx(String valueInit,int bymkrseq,boolean isNull){
    try{
    java.util.Vector vct=
        (isNull)?new java.util.Vector():
         exgui2.CONST.BASIC_MAIN_EJB.getDatas(
         util.PublicVariable.USER_RECORD,
         "select dbnt_bymkr_name from debitnote_bymkr_name where record_delete_flag='1' and dbnt_bymkr_seq="+
           String.valueOf(bymkrseq),
          1,9999);

    DbJcbxBuyerName=
        new exgui.DataBindEditableJCombobox(
                          cbxBuyerName,"DBNT_BYMKR_NAME",
                          vct,
                          "DBNT_BYMKR_NAME","DBNT_BYMKR_NAME",
                          valueInit,60);
      //dataBoundGUIs.add(buyerNameInputIndex,DbJcbxBuyerName);
    }catch(Exception exp){
      exp.printStackTrace();
    }

  }

  void cbxBuyerMakerType_itemStateChanged(ItemEvent e) {
    slkMaker.init("",null,
                          Integer.parseInt(
                           (String)
                           newtimes.accounting.debit_note.Constans.hmBuyerMakerType.get(cbxBuyerMakerType.getSelectedItem())
                           ),true);
    initBuyerNameCbx("",-1,true);
  }

}
