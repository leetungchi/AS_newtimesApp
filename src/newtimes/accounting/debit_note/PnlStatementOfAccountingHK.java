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

  public class PnlStatementOfAccountingHK
      //extends JPanel
      extends AbsQryPanel
      implements   newtimes.preproduction.buyermakerselect.BuyerMakerChanged {
    BlueBkgWhiteCharLabel blueBkgWhiteCharLabel1 = new BlueBkgWhiteCharLabel();
    JLabel jLabel1 = new JLabel();
    JComboBox cbxDep = new JComboBox();
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
    JLabel jLabel5 = new JLabel();
    JComboBox cbxBuyerName = new JComboBox();
    exgui.DataBindJCombobox DbJcbxBuyerName;
    JLabel jLabel6 = new JLabel();
    JComboBox cbxRowGap = new JComboBox(new String[]{"SMALL","MIDDLE","LARGE"});
  JLabel jLabel2 = new JLabel();
  int byrmkSeq[]={
      8544,//0
      9480,//1
      9479,//2
      9482,
      9484,

      9756,//NT DEV BJ
      9757,//NT DEV SRI
      9758,//NT DEV INDO
      9753,//NT DEV PHIL
      -1,  // NTD GROUP
      10826,
      9481,
      9457
   };
  JComboBox cbxBuyer = new JComboBox(new String[]{
                                     "ASIA UNITED",  //0
                                     "ASIA ONE (ACC)",//1
                                     "NT DEV - HK",//2
                                     "NT DEV - SH",//3
                                     "NT DEV - THAI",//4

                                     "NT DEV - BJ",//5
                                     "NT DEV - SRI",//6
                                     "NT DEV - INDO.",//7
                                     "NT DEV - PHIL",//8
                                     "NTD GROUP",//9

                                     "NT FAR EAST",
                                     "NT HK",
                                     "NT OVERSEAS"
                                     });

  JTextField txtDbcrYYYYMMTo = new JTextField();
  JLabel jLabel7 = new JLabel();
    public PnlStatementOfAccountingHK() {
      try {
        jbInit();
      }
      catch(Exception ex) {
        ex.printStackTrace();
      }
    }

   public void jbInit() throws Exception {
       cbxRowGap.setSelectedIndex(1);
       /*
       if(isMakerStatmentRpt){
         cbxBuyerMakerType=new JComboBox(new String[]{"MAKER"});
       }else{
         cbxBuyerMakerType=new JComboBox(new String[]{"BUYER","OTHER"});
       }
      */
      titledBorder1 = new TitledBorder(BorderFactory.createEtchedBorder(Color.white,new Color(148, 145, 140)),"LESS");
      blueBkgWhiteCharLabel1.setText("NT STATEMENT");
      blueBkgWhiteCharLabel1.setBounds(new Rectangle(-1, 1, 801, 25));
      this.setLayout(null);
      jLabel1.setFont(new java.awt.Font("Dialog", 1, 11));
      jLabel1.setText("DEP.");
      jLabel1.setBounds(new Rectangle(3, 30, 36, 25));
      cbxDep.setBounds(new Rectangle(36, 30, 181, 25));
      jLabel3.setFont(new java.awt.Font("Dialog", 1, 11));
      jLabel3.setText("DB/CR# (YYMM) FROM:");
      jLabel3.setBounds(new Rectangle(468, 57, 130, 25));
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
      txtAsOf.setBounds(new Rectangle(565, 86, 54, 24));
      jLabel4.setBounds(new Rectangle(467, 82, 96, 25));
      jLabel4.setText("As Of (YYMMDD)");
      jLabel4.setFont(new java.awt.Font("Dialog", 1, 11));
      txtDbcrYYYYMM.setText("");
      txtDbcrYYYYMM.setBounds(new Rectangle(594, 57, 55, 24));
      jLabel5.setFont(new java.awt.Font("Dialog", 1, 11));
      jLabel5.setText("NAME");
      jLabel5.setBounds(new Rectangle(471, 30, 50, 25));
      cbxBuyerName.setBounds(new Rectangle(522, 30, 170, 25));
      jLabel6.setFont(new java.awt.Font("Dialog", 1, 11));
      jLabel6.setText("Row Gap");
      jLabel6.setBounds(new Rectangle(635, 82, 55, 25));
      cbxRowGap.setBounds(new Rectangle(691, 86, 98, 20));
    jLabel2.setBounds(new Rectangle(220, 29, 48, 25));
    jLabel2.setText("BUYER:");
    jLabel2.setFont(new java.awt.Font("Dialog", 1, 11));
    cbxBuyer.setBounds(new Rectangle(262, 31, 204, 24));
    cbxBuyer.addItemListener(new java.awt.event.ItemListener() {
      public void itemStateChanged(ItemEvent e) {
        cbxBuyer_itemStateChanged(e);
      }
    });
    txtDbcrYYYYMMTo.setBounds(new Rectangle(695, 57, 55, 24));
    txtDbcrYYYYMMTo.setText("");
    jLabel7.setBounds(new Rectangle(658, 57, 32, 25));
    jLabel7.setText("TO");
    jLabel7.setFont(new java.awt.Font("Dialog", 1, 11));
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

      this.add(jScrollPane1, null);
      this.add(jLabel3, null);
      this.add(jLabel4, null);
      this.add(txtAsOf, null);
      this.add(txtDbcrYYYYMM, null);
      this.add(txtDbcrYYYYMMTo, null);
      this.add(jLabel7,null);

      this.add(btnQry, null);
      this.add(cbxBuyerName, null);
      this.add(cbxBuyer, null);
      this.add(jLabel5, null);
      jScrollPane1.getViewport().add(pnlLess, null);
           this.add(jLabel2,null);
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
      reportName="DB_BYR_STMT_HK.rpt";
      this.add(jLabel3, null);
      this.add(txtDbcrYYYYMM, null);
      this.add(jLabel6, null);
      this.add(cbxRowGap, null);
      try{
        database.datatype.Record recBymkr=(database.datatype.Record)exgui2.CONST.BASIC_MAIN_EJB.getDatas(
           util.PublicVariable.USER_RECORD,
          "select * from buyer_maker where  bymkr_seq="+
            String.valueOf(byrmkSeq[0]),
           1,9999).get(0);
          changeBuyerMaker(recBymkr);

      }catch(Exception exp){
        exp.printStackTrace();
      }


    }
    public java.util.HashMap composeParameters(){
      java.util.HashMap hm=super.composeParameters();
      String valueOfMaker=String.valueOf(byrmkSeq[cbxBuyer.getSelectedIndex()]);
      if("-1".equals(valueOfMaker)){
        //from element 2 to ele8
        valueOfMaker="[9479,9482,9484,9756,9757,9758,9753]";
      }
      hm.put("P_MAKER",valueOfMaker);

      String yymm=txtDbcrYYYYMM.getText().trim();
      hm.put("P_YMC",yymm);

      String yymm2=txtDbcrYYYYMMTo.getText().trim();
      hm.put("P_YMC_TO",yymm2);

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
         /*
         if(slkMaker.getSelectedValue()==null){
           exgui.verification.VerifyLib.showAlert("Please Select Maker",
                                                  "Select Maker Please");
           return ;
         }
         */
         if(txtDbcrYYYYMM.getText().trim().length()!=4){
           exgui.verification.VerifyLib.showAlert("DB/CR# is 4 digits ,iS \"YYMM\"",
                                                  "DB/CR# Format ERROR");
           txtDbcrYYYYMM.selectAll();
           txtDbcrYYYYMM.grabFocus();
           return;
         }
         if(txtDbcrYYYYMMTo.getText().trim().length()!=4){
           exgui.verification.VerifyLib.showAlert("DB/CR# is 4 digits ,iS \"YYMM\"",
                                                  "DB/CR# Format ERROR");
           txtDbcrYYYYMMTo.selectAll();
           txtDbcrYYYYMMTo.grabFocus();
           return;
         }

         if(txtAsOf.getText().trim().length()!=6){
           exgui.verification.VerifyLib.showAlert("\"As Of\" is 6 digits ,iS \"YYMMDD\"",
                                                  "\"As Of\" Format ERROR");
           txtAsOf.selectAll();
           txtAsOf.grabFocus();
           return;
         }


         String tempURL= newtimes.production.report.ReportProxyEngine.reportServerURL ;
         newtimes.production.report.ReportProxyEngine.reportServerURL="http://rpt2.nttpe.com.tw:9000/?file:///rpt//";
         JButtonQueryButtonAction(e);
         newtimes.production.report.ReportProxyEngine.reportServerURL=tempURL;
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

  void cbxBuyer_itemStateChanged(ItemEvent e) {
          int bymkrSeqAt=byrmkSeq[cbxBuyer.getSelectedIndex()];
          if(bymkrSeqAt==-1)return;
          try{
           database.datatype.Record recBymkr=(database.datatype.Record)exgui2.CONST.BASIC_MAIN_EJB.getDatas(
              util.PublicVariable.USER_RECORD,
             "select * from buyer_maker where bymkr_seq="+
               String.valueOf(bymkrSeqAt),
              1,9999).get(0);
             changeBuyerMaker(recBymkr);
          }catch(Exception exp){
            exp.printStackTrace();
          }

  }
    /*
    void cbxBuyerMakerType_itemStateChanged(ItemEvent e) {
      slkMaker.init("",null,
                            Integer.parseInt(
                             (String)
                             newtimes.accounting.debit_note.Constans.hmBuyerMakerType.get(cbxBuyerMakerType.getSelectedItem())
                             ),true);
      initBuyerNameCbx("",-1,true);
    }
    */
  }

