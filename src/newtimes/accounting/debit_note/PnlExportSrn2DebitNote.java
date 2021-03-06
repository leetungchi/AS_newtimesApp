package newtimes.accounting.debit_note;

import java.awt.*;
import exgui.*;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.event.*;
import java.util.*;
import database.datatype.Record;


/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */
public class PnlExportSrn2DebitNote extends JPanel {
  WhiteBkgBlueCharLabel whiteBkgBlueCharLabel1 = new WhiteBkgBlueCharLabel();
  JPanel jPanel1 = new JPanel();
  Border border1;
  TitledBorder titledBorder1;
  JButton btnExport = new JButton();
  JButton btnExit = new JButton();
  JTextField txts[]=new JTextField[30];
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel1 = new BlueBkgWhiteCharLabel();
  JTextField txtNortonDescTitle = new JTextField();
   static final int BUYER_TYPE_OTHERS=0;
   static final int BUYER_TYPE_NORTON=1;
   static final int BUYER_TYPE_ASHWORTH=2;
   static final int BUYER_TYPE_OAKLEY=3;
   int current_buyer_type=0;
   java.text.NumberFormat df=new java.text.DecimalFormat("###########.00");
   java.text.NumberFormat df1000=new java.text.DecimalFormat("###,###,###,###.00");
   TempDb dbObj=null;
  JRadioButton rdoWithDivision = new JRadioButton();
  JRadioButton rdoNoDivision = new JRadioButton();
  ButtonGroup buttonGroup1 = new ButtonGroup();
  JRadioButton rdoDefualtBuyerName = new JRadioButton();
  JRadioButton rdoSelectBuyerName = new JRadioButton();
  ButtonGroup buttonGroup2 = new ButtonGroup();
  WhiteBkgBlueCharLabel whiteBkgBlueCharLabel2 = new WhiteBkgBlueCharLabel();
  JComboBox cbxBranch = new JComboBox();
  exgui.DataBindJCombobox DbJcbxcbxBranch =null;
  JLabel jLabel1 = new JLabel();
  JTextField txtDbCr2Follow = new JTextField();
  boolean is2Append=false;
  JLabel jLabel2 = new JLabel();
  JRadioButton rdoClrBankDataY = new JRadioButton();
  JRadioButton rdoClrBankDataN = new JRadioButton();
  ButtonGroup buttonGroup3 = new ButtonGroup();
  int ship_no_length=12;
  public String dfFormat(Object obj2form){
    if(obj2form==null) return df.format(0);
    return df.format(obj2form);
  }
  public String dfFormat(double obj2form){
    return df.format(obj2form);
  }

  public String df1000Format(Object obj2form){
    if(obj2form==null) return df1000.format(0);
    return df1000.format(obj2form);
  }
  public String df1000Format(double obj2form){
    return df1000.format(obj2form);
  }

  public PnlExportSrn2DebitNote() {
    try {
      if(!("001".equals(util.PublicVariable.OPERATTING_CENTER)||"NTHK".equals(util.PublicVariable.OPERATTING_CENTER))){
        ship_no_length=13;
      }
      jbInit();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }
  public String getTtlPrxAmtXCommStr(String srn)throws Exception{
    StringBuffer sb=new StringBuffer();

    sb.append("select nvl(ship_style.BUY_COMM,0), ");//0
    sb.append("nvl(ship_style.BUY_DSCT_DZ,0), ");//1
    sb.append("nvl(ship_style.BUY_DSCT_LUMP_SUM,0), ");//2
    sb.append("nvl(ship_style.BUY_DSCT_PC,0), ");//3
    sb.append("ship_style.SHIP_STY_BYR_ACT_PRX_AMT, ");//4
    sb.append("ship_sc.ship_no ");//5
    sb.append("from ship_style,style,ship_sc ");
    sb.append("where ");
    sb.append("style.sty_seq=ship_style.STY_SEQ and ");
    sb.append("ship_style.record_delete_flag='1' and ");
    sb.append("ship_sc.ship_sc_pk=ship_style.ship_sc_pk and ");
    sb.append("ship_sc.ship_no='");
    sb.append(srn);sb.append("'");


     Vector vct=exgui2.CONST.BASIC_MAIN_EJB.getDatas(
      util.PublicVariable.USER_RECORD,
      sb.toString(),1,999999);
      String commType=null;
      double totalByrActPrxAmt=0;
      for(int i=0;i<vct.size();i++){
        Record rec=(Record)vct.get(i);
        if(commType==null && rec.getDouble(0)>0) commType= " X "+dfFormat(rec.getDouble(0))+"%";
        if(commType==null && rec.getDouble(1)>0) commType= " X "+dfFormat(rec.getDouble(1))+"DZ";
        if(commType==null && rec.getDouble(2)>0) commType= "   "+dfFormat(rec.getDouble(2))+"�U";
        if(commType==null && rec.getDouble(3)>0) commType= " X "+dfFormat(rec.getDouble(3))+"PC";
        Object objDbl=rec.get(4);
        totalByrActPrxAmt+=((objDbl==null)?0:Double.parseDouble(objDbl.toString()));
      }
      if(commType==null)commType="";
      return util.MiscFunc.complementString(' ',df1000Format(totalByrActPrxAmt),10)+commType;

  }
  public String getTtlPrxAmtXCommStrViaComm(String srn,String comm)throws Exception{
   StringBuffer sb=new StringBuffer();

   sb.append("select nvl(ship_style.BUY_COMM,0), ");//0
   sb.append("nvl(ship_style.BUY_DSCT_DZ,0), ");//1
   sb.append("nvl(ship_style.BUY_DSCT_LUMP_SUM,0), ");//2
   sb.append("nvl(ship_style.BUY_DSCT_PC,0), ");//3
   sb.append("ship_style.SHIP_STY_BYR_ACT_PRX_AMT, ");//4
   sb.append("ship_sc.ship_no ");//5
   sb.append("from ship_style,style,ship_sc ");
   sb.append("where ");
   sb.append("style.sty_seq=ship_style.STY_SEQ and ");
   sb.append("ship_style.record_delete_flag='1' and ");
   sb.append("ship_sc.ship_sc_pk=ship_style.ship_sc_pk and ");
   sb.append("ship_sc.ship_no='");
   sb.append(srn);sb.append("' and nvl(ship_style.BUY_COMM,0)=" );
   sb.append(comm);


    Vector vct=exgui2.CONST.BASIC_MAIN_EJB.getDatas(
     util.PublicVariable.USER_RECORD,
     sb.toString(),1,999999);
     String commType=null;
     double totalByrActPrxAmt=0;
     for(int i=0;i<vct.size();i++){
       Record rec=(Record)vct.get(i);
       if(commType==null && rec.getDouble(0)>0) commType= " X "+dfFormat(rec.getDouble(0))+"%";
       if(commType==null && rec.getDouble(1)>0) commType= " X "+dfFormat(rec.getDouble(1))+"DZ";
       if(commType==null && rec.getDouble(2)>0) commType= "   "+dfFormat(rec.getDouble(2))+"�U";
       if(commType==null && rec.getDouble(3)>0) commType= " X "+dfFormat(rec.getDouble(3))+"PC";
       Object objDbl=rec.get(4);
       totalByrActPrxAmt+=((objDbl==null)?0:Double.parseDouble(objDbl.toString()));
     }
     if(commType==null)commType="";
     return util.MiscFunc.complementString(' ',df1000Format(totalByrActPrxAmt),10)+commType;

 }

  void jbInit() throws Exception {
    for(int i=0;i<30;i++)txts[i]=new JTextField();
    border1 = new EtchedBorder(EtchedBorder.RAISED,Color.white,new Color(148, 145, 140));
    titledBorder1 = new TitledBorder(border1,"PLEASE INPUT SRN NO.");
    whiteBkgBlueCharLabel1.setText("EXPORT BUYER COMM. TO DEBITNOTE SYSTEM");
    whiteBkgBlueCharLabel1.setBounds(new Rectangle(-1, 28, 802, 31));
    this.setBackground(new Color(202, 202, 224));
    this.setLayout(null);
    jPanel1.setBackground(new Color(202, 202, 224));
    jPanel1.setBorder(titledBorder1);
    jPanel1.setBounds(new Rectangle(13, 64, 774, 397));
    jPanel1.setLayout(null);
    txts[0].setText("");
    txts[0].setBounds(new Rectangle(17, 31+26, 112, 26));
    txts[1].setText("");
    txts[1].setBounds(new Rectangle(141, 31+26, 112, 26));
    txts[2].setText("");
    txts[2].setBounds(new Rectangle(266, 31+26, 112, 26));
    txts[3].setText("");
    txts[3].setBounds(new Rectangle(390, 31+26, 112, 26));
    txts[4].setText("");
    txts[4].setBounds(new Rectangle(515, 31+26, 112, 26));
    txts[5].setBounds(new Rectangle(639, 31+26, 112, 26));
    txts[6].setBounds(new Rectangle(639, 66+26, 112, 26));
    txts[7].setBounds(new Rectangle(141, 66+26, 112, 26));
    txts[7].setText("");
    txts[8].setBounds(new Rectangle(17, 66+26, 112, 26));
    txts[8].setText("");
    txts[9].setBounds(new Rectangle(266, 66+26, 112, 26));
    txts[9].setText("");
    txts[10].setBounds(new Rectangle(515, 66+26, 112, 26));
    txts[10].setText("");
    txts[11].setBounds(new Rectangle(390, 66+26, 112, 26));
    txts[11].setText("");
    txts[12].setBounds(new Rectangle(639, 102+26, 112, 26));
    txts[13].setBounds(new Rectangle(141, 102+26, 112, 26));
    txts[13].setText("");
    txts[14].setBounds(new Rectangle(17, 102+26, 112, 26));
    txts[14].setText("");
    txts[15].setBounds(new Rectangle(266, 102+26, 112, 26));
    txts[15].setText("");
    txts[16].setBounds(new Rectangle(515, 102+26, 112, 26));
    txts[16].setText("");
    txts[17].setBounds(new Rectangle(390, 102+26, 112, 26));
    txts[17].setText("");
    txts[18].setBounds(new Rectangle(639, 137+26, 112, 26));
    txts[19].setBounds(new Rectangle(141, 137+26, 112, 26));
    txts[19].setText("");
    txts[20].setBounds(new Rectangle(17, 137+26, 112, 26));
    txts[20].setText("");
    txts[21].setBounds(new Rectangle(266, 137+26, 112, 26));
    txts[21].setText("");
    txts[22].setBounds(new Rectangle(515, 137+26, 112, 26));
    txts[22].setText("");
    txts[23].setBounds(new Rectangle(390, 137+26, 112, 26));
    txts[23].setText("");
    txts[24].setBounds(new Rectangle(639, 172+26, 112, 26));
    txts[25].setBounds(new Rectangle(141, 172+26, 112, 26));
    txts[25].setText("");
    txts[26].setBounds(new Rectangle(17, 172+26, 112, 26));
    txts[26].setText("");
    txts[27].setBounds(new Rectangle(266, 172+26, 112, 26));
    txts[27].setText("");
    txts[28].setBounds(new Rectangle(515, 172+26, 112, 26));
    txts[28].setText("");
    txts[29].setBounds(new Rectangle(390, 172+26, 112, 26));
    txts[29].setText("");
    btnExport.setBounds(new Rectangle(672, 355, 88, 30));
    btnExport.setFont(new java.awt.Font("Dialog", 1, 11));
    btnExport.setText("EXPORT");
    btnExport.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnExport_actionPerformed(e);
      }
    });
    btnExit.setBounds(new Rectangle(553, 517, 139, 32));
    btnExit.setFont(new java.awt.Font("Dialog", 1, 11));
    btnExit.setText("EXIT");
    btnExit.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnExit_actionPerformed(e);
      }
    });
    blueBkgWhiteCharLabel1.setText("NORTON GROUP TITLE:");
    blueBkgWhiteCharLabel1.setVerticalAlignment(javax.swing.SwingConstants.CENTER);
    blueBkgWhiteCharLabel1.setBounds(new Rectangle(141, 286, 165, 30));
    txtNortonDescTitle.setBounds(new Rectangle(310, 286, 301, 30));
    rdoWithDivision.setBackground(new Color(202, 202, 224));
    rdoWithDivision.setFont(new java.awt.Font("Dialog", 1, 11));
    //rdoWithDivision.setSelected(true);
    rdoWithDivision.setText("WITH DIVISION");
    rdoWithDivision.setBounds(new Rectangle(343, 328, 123, 23));
    rdoNoDivision.setBackground(new Color(202, 202, 224));
    rdoNoDivision.setFont(new java.awt.Font("Dialog", 1, 11));
    rdoNoDivision.setText("NO DIVISION");
    rdoNoDivision.setBounds(new Rectangle(479, 327, 108, 25));
    rdoNoDivision.setSelected(true);
    rdoDefualtBuyerName.setSelected(true);
    rdoDefualtBuyerName.setBounds(new Rectangle(479, 350, 168, 25));
    rdoDefualtBuyerName.setText("Use Default Buyer Name");
    rdoDefualtBuyerName.setFont(new java.awt.Font("Dialog", 1, 11));
    rdoDefualtBuyerName.setBackground(new Color(202, 202, 224));
    rdoSelectBuyerName.setBounds(new Rectangle(343, 351, 139, 23));
    rdoSelectBuyerName.setText("Select Buyer Name");
    rdoSelectBuyerName.setFont(new java.awt.Font("Dialog", 1, 11));
    rdoSelectBuyerName.setBackground(new Color(202, 202, 224));
    whiteBkgBlueCharLabel2.setText("BRANCH");
    whiteBkgBlueCharLabel2.setBounds(new Rectangle(13, 335, 109, 23));
    cbxBranch.setBounds(new Rectangle(122, 336, 187, 23));
    jLabel1.setBackground(Color.white);
    jLabel1.setFont(new java.awt.Font("Dialog", 1, 11));
    jLabel1.setForeground(Color.red);
    jLabel1.setOpaque(true);
    jLabel1.setHorizontalAlignment(SwingConstants.CENTER);
    jLabel1.setText("Append To DB/CR#");
    jLabel1.setBounds(new Rectangle(9, 14, 128, 26));
    txtDbCr2Follow.setText("");
    txtDbCr2Follow.setBounds(new Rectangle(138, 14, 119, 27));
    jLabel2.setFont(new java.awt.Font("Dialog", 1, 11));
    jLabel2.setText("Clear Bank Data");
    jLabel2.setBounds(new Rectangle(343, 373, 93, 20));
    rdoClrBankDataY.setBackground(new Color(202, 202, 224));
    rdoClrBankDataY.setFont(new java.awt.Font("Dialog", 1, 11));
    rdoClrBankDataY.setText("Yes");
    rdoClrBankDataY.setBounds(new Rectangle(479, 373, 56, 18));
    rdoClrBankDataN.setBounds(new Rectangle(544, 373, 56, 18));
    rdoClrBankDataN.setText("No");
    rdoClrBankDataN.setBackground(new Color(202, 202, 224));
    rdoClrBankDataN.setFont(new java.awt.Font("Dialog", 1, 11));
    rdoClrBankDataN.setVerifyInputWhenFocusTarget(true);
    rdoClrBankDataN.setSelected(true);
    this.add(whiteBkgBlueCharLabel1, null);
    jPanel1.add(txts[0], null);
    jPanel1.add(txts[1], null);
    jPanel1.add(txts[2], null);
    jPanel1.add(txts[3], null);
    jPanel1.add(txts[4], null);
    jPanel1.add(txts[5], null);
    jPanel1.add(txts[6], null);
    jPanel1.add(txts[7], null);
    jPanel1.add(txts[8], null);
    jPanel1.add(txts[9], null);
    jPanel1.add(txts[10], null);
    jPanel1.add(txts[11], null);
    jPanel1.add(txts[12], null);
    jPanel1.add(txts[13], null);
    jPanel1.add(txts[14], null);
    jPanel1.add(txts[15], null);
    jPanel1.add(txts[16], null);
    jPanel1.add(txts[17], null);
    jPanel1.add(txts[18], null);
    jPanel1.add(txts[19], null);
    jPanel1.add(txts[20], null);
    jPanel1.add(txts[21], null);
    jPanel1.add(txts[22], null);
    jPanel1.add(txts[23], null);
    jPanel1.add(txts[24], null);
    jPanel1.add(txts[25], null);
    jPanel1.add(txts[26], null);
    jPanel1.add(txts[27], null);
    jPanel1.add(txts[28], null);
    jPanel1.add(txts[29], null);
    jPanel1.add(blueBkgWhiteCharLabel1, null);
    jPanel1.add(whiteBkgBlueCharLabel2, null);
    jPanel1.add(cbxBranch, null);
    jPanel1.add(rdoWithDivision, null);
    jPanel1.add(txtNortonDescTitle, null);
    jPanel1.add(jLabel1, null);
    jPanel1.add(txtDbCr2Follow, null);
    jPanel1.add(rdoSelectBuyerName, null);
    jPanel1.add(rdoDefualtBuyerName, null);
    jPanel1.add(rdoNoDivision, null);
    jPanel1.add(jLabel2, null);
    jPanel1.add(rdoClrBankDataY, null);
    jPanel1.add(rdoClrBankDataN, null);
    jPanel1.add(btnExport, null);
    this.add(btnExit, null);
    this.add(jPanel1, null);
    buttonGroup1.add(rdoWithDivision);
    buttonGroup1.add(rdoNoDivision);
    buttonGroup2.add(rdoDefualtBuyerName);
    buttonGroup2.add(rdoSelectBuyerName);
    if(newtimes.accounting.debit_note.Constans.VCT_BRANCH==null){
      newtimes.accounting.debit_note.Constans.VCT_BRANCH=
          exgui2.CONST.BASIC_MAIN_EJB.getDatas(
          util.PublicVariable.USER_RECORD,
          "select * from branch where record_delete_flag='1'",
         1,9999999);
    }
    DbJcbxcbxBranch = new exgui.DataBindJCombobox(cbxBranch,"DBNT_BRNCH_BRF",
                                   newtimes.accounting.debit_note.Constans.VCT_BRANCH,
                                   "BRNCH_NAME","BRNCH_BRIEF",
                                   "NEWTIMES INT''L");
    buttonGroup3.add(rdoClrBankDataN);
    buttonGroup3.add(rdoClrBankDataY);


  }

  void btnExit_actionPerformed(ActionEvent e) {
    try{
      processhandler.template.Properties.getCenteralControler().goBack();
    }catch(Exception exp){

    }

  }
  exgui.ultratable.PagedTablePanel getShipDetailListingGUI(String srn,Record rec){

    util.InsertionOrderedHashMap iso=new util.InsertionOrderedHashMap();
    Hashtable htComv=new Hashtable();
    switch (current_buyer_type){
        case BUYER_TYPE_ASHWORTH:
        {
          return null;
        }
        case BUYER_TYPE_NORTON:
       {
         iso.put("       ","SHIP_NO");
         iso.put("CONF#","STY_SC_NO");
         iso.put("PO#","STY_PO");
         iso.put("STYLE#","STY_STYLE");
         iso.put("QTY","SHIP_STY_TOTAL_QTY");
         iso.put("PRX","prx");
         iso.put("AMT","SHIP_STY_BYR_DOC_PRX_AMT");
         iso.put("%","BUY_COMM");
         break;
       }
       case BUYER_TYPE_OAKLEY:
       {
         iso.put("       ", "SHIP_NO");
         iso.put("CONF#", "STY_SC_NO");
         iso.put("PO#                ", "STY_PO"); //always keep PO fix to 16 chactor-length
         iso.put("STYLE#  ", "STY_STYLE");//style only 8 charaters
         iso.put("                                ","TOTAL_BUYER_AMT_DESC");
         break;
       }
       default:
       {
         //if buyer is new balance,po size is 16,amount size length -1
         if(rec.getInt(3)==11330||rec.getInt(3)==11227||rec.getInt(3)==11226){
           iso.put("       ", "SHIP_NO");
           iso.put("CONF#", "STY_SC_NO");
           iso.put("PO#             ", "STY_PO"); //always keep PO fix to 16 chactor-length
           iso.put("STYLE#     ", "STY_STYLE");
           iso.put("                                ","TOTAL_BUYER_AMT_DESC");
         }else{

             iso.put("       ", "SHIP_NO");
             iso.put("CONF#", "STY_SC_NO");
             iso.put("PO#            ", "STY_PO"); //always keep PO fix to 16 chactor-length
             iso.put("STYLE#      ", "STY_STYLE");
             iso.put("                                ", "TOTAL_BUYER_AMT_DESC");

         }
       }
    }
    exgui.ultratable.PagedTablePanel pnl=new   exgui.ultratable.PagedTablePanel(dbObj,99999,iso,htComv);
    return pnl;
  }
  class TempDb extends exgui.ultratable.PagedDataFactoryAdapter{
    String srn;
    Vector vct2return=null;

    TempDb(String _srn){
      try{
        //isBuyerNorton=false;
        //isBuyerAshWorth=false;
        current_buyer_type=0;
        srn = _srn;
        StringBuffer sb = new StringBuffer();

        if (srn.substring(0,6).equals("ZATWQQ"))
        {

        sb.append("select ");
        if(ship_no_length==12){
          sb.append("substr(c.ship_no,5,8) as ship_no,"); //0
        }else{
          sb.append("substr(c.ship_no,6,8) as ship_no,"); //0
        }
        //sb.append("e.bymkr_name,");//1
        sb.append("e.bymkr_warehouse,");//1
        sb.append("substr(b.sty_sc_no,5,8) as sty_sc_no,");//2
        sb.append("nvl(b.sty_po,' ') as sty_po,");//3
 //       sb.append("b.sty_style as sty_style,");//4
        sb.append("DECODE(GET_BUYER_GROUP_ID(d.prod_buyer),12293,GET_STR_HEAD(b.sty_style,'/'),b.sty_style) as sty_style,");//4
        sb.append("a.SHIP_STY_TOTAL_QTY,");//5
        sb.append("(a.SHIP_STY_BYR_DOC_PRX_AMT/a.SHIP_STY_TOTAL_QTY) as prx,");//6
        sb.append("a.SHIP_STY_BYR_DOC_PRX_AMT,");//7
        sb.append("nvl(a.BUY_COMM,0) as BUY_COMM ");//8
        sb.append(",(select shipping.ship_fty_inv from shipping where shipping.ship_no=c.ship_no) as fty_inv_no ");//9
        sb.append(",(select shipping.ship_HAWB from shipping where shipping.ship_no=c.ship_no) as SHIPMENT_NO ");//10
        sb.append(",c.ship_no as org_ship_no ");//11
        sb.append(",'' as TOTAL_BUYER_AMT_DESC ");//12
        sb.append(",e.bymkr_brief ");
        sb.append("from ship_style a,style b,ship_sc c,prod_head d,buyer_maker e ");
        sb.append("where 1=1 ");
        sb.append("and a.sty_seq=b.sty_seq ");
        sb.append("and a.ship_sc_pk=c.ship_sc_pk ");
        sb.append("and c.prod_head_pk=d.prod_head_pk ");
        sb.append("and d.prod_buyer=e.bymkr_seq ");
        sb.append("and c.ship_no = '");
        sb.append(srn);
        sb.append("'");
        sb.append("order by ship_no,sty_sc_no,nvl(sty_po,' '),sty_style ");
        }
          else {
        sb.append("select ");
        if(ship_no_length==12){
            sb.append("substr(S.ship_no,5,8) as ship_no,"); //0
        }else{
            sb.append("substr(S.ship_no,6,8) as ship_no,"); //0
        }
        sb.append("(SELECT bymkr_warehouse FROM PROD_HEAD P,BUYER_MAKER B WHERE P.PROD_BUYER= B.BYMKR_SEQ AND P.PROD_HEAD_PK=SS.PROD_HEAD_PK) as bymkr_warehouse,");//1
        sb.append("(SELECT SUBSTR(S.STY_SC_NO,5,8) FROM STYLE S WHERE S.STY_SEQ=SE.STY_SEQ) AS STY_SC_NO, ");//2
        sb.append("(SELECT nvl(S.STY_PO,' ') FROM STYLE S WHERE S.STY_SEQ=SE.STY_SEQ) AS STY_PO, ");//3
        sb.append("(SELECT DECODE(GET_BUYER_GROUP_ID(prod_buyer),12293,GET_STR_HEAD(sty_style,'/'),sty_style) FROM STYLE S,PROD_HEAD P WHERE S.STY_SEQ=SE.STY_SEQ AND S.PROD_HEAD_PK=P.PROD_HEAD_PK) AS STY_STYLE,");//4
        sb.append("SE.SHIP_STY_TOTAL_QTY,");//5
        sb.append("(SE.SHIP_STY_BYR_DOC_PRX_AMT/SE.SHIP_STY_TOTAL_QTY) as prx,");//6
        sb.append("SE.SHIP_STY_BYR_DOC_PRX_AMT,");//7
        sb.append("nvl(SE.BUY_COMM,0) as BUY_COMM ");//8
        sb.append(",S.ship_fty_inv as fty_inv_no ");//9
        sb.append(",S.ship_HAWB as SHIPMENT_NO ");//10
        sb.append(",S.ship_no as org_ship_no ");//11
        sb.append(",'' as TOTAL_BUYER_AMT_DESC ");//12
        sb.append(", (SELECT bymkr_brief FROM PROD_HEAD P,BUYER_MAKER B WHERE P.PROD_BUYER=B.BYMKR_SEQ AND P.PROD_HEAD_PK=SS.PROD_HEAD_PK) as bymkr_brief");
        sb.append(" from SHIPPING S,SHIP_SC SS,SHIP_STYLE SE ");
        sb.append("where  SS.SHIP_NO = S.SHIP_NO ");
        sb.append("and SE.SHIP_SC_PK = SS.SHIP_SC_PK ");
        sb.append("and S.ship_no = '");
        sb.append(srn);
        sb.append("'");
        sb.append("order by ship_no,nvl(SE.BUY_COMM,0) DESC,sty_sc_no,nvl(sty_po,' '),sty_style ");
          }
        System.out.println(sb);;

        vct2return = exgui2.CONST.BASIC_MAIN_EJB.getDatas(
            util.PublicVariable.USER_RECORD,
            sb.toString(),
            1, 99999);

/*
         for (int p_row=0;p_row < vct2return.size(); p_row++)
         {
               Record tmp_r = (Record)vct2return.get(p_row);
               if ( tmp_r.getValueFields().get(13).equals("QUIKSILVER") )
               {
                    String[] sty = ((String)tmp_r.getValueFields().get(4)).split("/");
                    tmp_r.getValueFields().set(4,sty[0]);
               }
         }
*/




         Record recTmp=(Record)vct2return.get(0);
         if(null==recTmp.get(1)){
           current_buyer_type = BUYER_TYPE_OTHERS;
         }else if(recTmp.get(1).toString().indexOf("+")!=-1){
           current_buyer_type = BUYER_TYPE_NORTON;
         }else if(recTmp.get(1).toString().indexOf(")")!=-1){
           current_buyer_type = BUYER_TYPE_ASHWORTH;
         }else if(recTmp.get(1).toString().indexOf("(")!=-1){
           current_buyer_type = BUYER_TYPE_OAKLEY;
         }else{
           current_buyer_type = BUYER_TYPE_OTHERS;
         }


         //isBuyerNorton=recTmp.get(1).toString().startsWith("NORTON ");
         //isBuyerAshWorth=recTmp.get(1).toString().startsWith("ASHWORTH");

      }catch(Exception exp){
        exp.printStackTrace();
      }

    }

    public Vector getRecords(int bgn,int rowcount)throws Exception{
      Vector vct=new Vector();
       //if(isBuyerNorton){
       if(current_buyer_type==BUYER_TYPE_NORTON){
         String SRN="";
         for(int i=0;i<vct2return.size();i++){
           Record rec=(Record)vct2return.get(i);

           if((rec.get(0).toString()).equals(SRN)){
             rec.set(0,"");
           }else{
             SRN=(String)rec.get(0);

           }

           //decimal part of prx & amt is always 2 digits
           rec.set(6,dfFormat(rec.get(6)));
           rec.set(7,dfFormat(rec.get(7)).trim());
           rec.set(8,dfFormat(rec.get(8)).trim());
           vct.add(rec);
         }
         return vct;
       }

       //blank the duplicated SRN,S/C,PO,STYLE
       String SRN="";
       String lastSC="";
       String lastPO="                ";
       String lastStyle="";
       int srn_no_at=0;
       //if(isBuyerAshWorth)srn_no_at=9;
       if(current_buyer_type==BUYER_TYPE_ASHWORTH)srn_no_at=9;
       String tmp_comm="99";
       for(int i=0;i<vct2return.size();i++){
         Record rec=(Record)vct2return.get(i);

   // >>>
         rec.set(3,((String)rec.get(3)).replaceAll("\n",""));

         if("BURTON".equals(rec.get("bymkr_brief"))){
           String strStyle=(String)rec.get(4);
           if(strStyle!=null)strStyle=util.MiscFunc.split(strStyle,"/")[0];
           rec.set(4,strStyle);
         }
         if("GUESS?".equals(rec.get("bymkr_brief"))){
           String poString=(String)rec.get(3);
           if(poString!=null)poString=util.MiscFunc.split(poString,"(")[0];
           rec.set(3,poString);
         }
         if("OAKLEY".equals(rec.get("bymkr_brief"))){
           String strStyle=(String)rec.get(4);
           if(strStyle!=null && strStyle.length()>7){
             strStyle=strStyle.substring(0,7);
           }else  if(strStyle!=null && strStyle.length()<7){
             strStyle = (strStyle + "          ").substring(0, 7);
           }
           rec.set(4,strStyle);
         }


         //if(i>0)rec.set(0,"");
         ///////***
         // <<<>>>
         boolean is_qq = rec.get(0).toString().substring(0,2).equals("QQ");

         if((i==0) || (!rec.get(8).toString().equals(tmp_comm) && (!is_qq))) {
 //          rec.set(12,getTtlPrxAmtXCommStr((String)rec.get(11)));

              tmp_comm=rec.get(8).toString();
              rec.set(12,getTtlPrxAmtXCommStrViaComm((String)rec.get(11),tmp_comm));
         }
         if(rec.get(srn_no_at).equals(SRN)){
           rec.set(srn_no_at,"");
         }else{
           SRN=(String)rec.get(srn_no_at);
         }

         if(rec.get(2).equals(lastSC)){
           rec.set(2,"");
         }else{
           lastSC=(String)rec.get(2);
         }
         String styleStr2Test=
             (rec.get("bymkr_brief").toString().toUpperCase().startsWith("NEW BALANCE"))?
             util.MiscFunc.complementString(' ',(String)rec.get(4),11):
             util.MiscFunc.complementString(' ',(String)rec.get(4),12);
         if(lastPO.equals(rec.get(3)) &&
            styleStr2Test.equals(lastStyle)){
            rec.set(3,"              ");
            rec.set(4,"");
         }else{
           // >>>>
           lastPO=(String)rec.get(3);
           if(lastPO==null)lastPO="";
           String orgString=new String(lastPO);
           lastStyle=null;
           if(rec.get("bymkr_brief").toString().toUpperCase().startsWith("NEW BALANCE")){
             orgString=util.MiscFunc.complementStringAlignRight(' ', orgString, 16);
             lastStyle=util.MiscFunc.complementString(' ',(String)rec.get(4),11);
           }else{
             orgString=util.MiscFunc.complementStringAlignRight(' ', orgString, 15);
             lastStyle=util.MiscFunc.complementString(' ',(String)rec.get(4),12);
           }

           rec.set(3,orgString);
           //if OAKLY,style length is only 8 digits.
           if(current_buyer_type==BUYER_TYPE_OAKLEY){
             //System.out.println("TYPE IS OAKLEY");
             String styleName=rec.get(4)==null?"":((String)rec.get(4)).trim();
             lastStyle=util.MiscFunc.complementString(' ',styleName,8);
             rec.set(4,lastStyle);
           }
         }
         /*
         if(lastPO.equals(rec.get(3))){
           rec.set(3,"              ");
         }else{
           lastPO=(String)rec.get(3);
           if(lastPO==null)lastPO="";
           String orgString=new String(lastPO);
           orgString=util.MiscFunc.complementStringAlignRight(' ', orgString, 15);
           rec.set(3,orgString);
         }

         if(util.MiscFunc.complementString(' ',(String)rec.get(4),12).equals(lastStyle)){
           rec.set(4,"");
         }else{
           lastStyle=util.MiscFunc.complementString(' ',(String)rec.get(4),12);
         }*/


         //decimal part of prx & amt is always 2 digits

         if(rec.get(srn_no_at).toString().trim().length()==0&&
            rec.get(2).toString().trim().length()==0&&
            rec.get(3).toString().trim().length()==0&&
            rec.get(4).toString().trim().length()==0){
           continue;
         }
         rec.set(6,dfFormat(rec.get(6)).trim());
         rec.set(7,dfFormat(rec.get(7)).trim());
         //

         vct.add(rec);
       }
       return vct;
    }
  }
  static public String table2Text(javax.swing.JTable tbl,int leftAlignStartColumn,int bgn){
    StringBuffer totalSB=new StringBuffer();
    int  maxLength[]=new int[tbl.getColumnCount()];
    String modelData[][]=
        new String[tbl.getRowCount()+1][tbl.getColumnCount()];
    String blanks="                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                ";
    //fisrt is to trevorse all the cell,and determ the max char of each column
    for(int j=0;j<tbl.getColumnCount();j++){
      maxLength[j]=0;
      for (int i = -1; i < tbl.getRowCount(); i++) {
        Object cellData=null;
        if (i==-1){
           cellData=tbl.getColumnName(j);
           if(cellData!=null){
            cellData= util.MiscFunc.Replace(cellData.toString(),"��"," ");
           }
        }else{
          cellData = tbl.getValueAt(i, j);
        }
        String cellDataString=
          (cellData==null)?"":cellData.toString();

        if(cellDataString.length()>maxLength[j]){
          maxLength[j]=(cellDataString.length());//+1;//at least,leading a space.
        }
        modelData[i+1][j]=cellDataString;
      }
    }
    for(int i=bgn;i<tbl.getRowCount()+1;i++){
      for(int j=0;j<tbl.getColumnCount();j++ ){
        String destString=null;
         if(j>leftAlignStartColumn){
            destString =  blanks.substring(0, maxLength[j] - modelData[i][j].length() + 1)+modelData[i][j] ;
         }else{
             destString = modelData[i][j] + blanks.substring(0, maxLength[j] - modelData[i][j].length() + 1);
         }
             //complementStringAlignRight(' ',modelData[i][j],maxLength[j]-modelData[i][j].length()+1);

         totalSB.append(destString);
      }
      //at each row,append the return character.
      totalSB.append("\n");
    }
   return totalSB.toString();
  }
  public void ShowDbHeadReport(String DbCrNo){
    try{
    //show debit note report,
    com.inet.viewer.ReportViewerBean viewer = util.PublicVariable.
        inet_report_viewer;
    String rpt_name = "dbno.rpt";
    java.util.HashMap hm = new java.util.HashMap();
    hm.put("P_CENTER",util.PublicVariable.OPERATTING_CENTER);
    hm.put("P_DB_NO", DbCrNo);
    newtimes.production.report.ReportCmdSet.myReportEngin.
        setReportNameAndParas(viewer, rpt_name, hm);
    viewer.setHasGroupTree(false);
    //viewer.setReportData(newtimes.production.report.ReportCmdSet.myReportEngin);
    viewer.start();
    JPanel pnl = new JPanel();
    pnl.setLayout(new java.awt.BorderLayout());
    pnl.add(viewer);
    newtimes.preproduction.guis.DlgViewRpt dlg = new newtimes.preproduction.
        guis.DlgViewRpt(
        processhandler.template.Properties.getMainFrame(),
        "DB/CR REPORT",
        pnl, true);
    dlg.setSize(700, 500);
    dlg.show();
  }catch(Exception exp){
    exp.printStackTrace();

  }

}


  public String getShipDetailDescBlock(String srn,String shipmentNo,int txtTblBgnRow,Record recOrg)throws Exception{
    try{
      exgui.ultratable.PagedTablePanel pnllistdtl=getShipDetailListingGUI(srn,recOrg);
/*
      JFrame frame = new JFrame("SubWindow");
      Container contentPane = frame.getContentPane();
      contentPane.add(pnllistdtl);
      frame.setVisible(true);
      frame.setSize(800,600);
      frame.repaint();
*/
      String txtText=null;
      if(current_buyer_type==BUYER_TYPE_NORTON){
        txtText = table2Text(pnllistdtl.getJtable(),2,txtTblBgnRow);
      }else{
        txtText = table2Text(pnllistdtl.getJtable(),9999,txtTblBgnRow);
      }

      String notornGrpTitle=txtNortonDescTitle.getText();
      if(current_buyer_type==BUYER_TYPE_OAKLEY){
        StringBuffer sb=new StringBuffer();
        String shipment_no=(shipmentNo==null)?"":shipmentNo;
        if(notornGrpTitle.trim().length()>0){
          sb.append("         ");
          sb.append(notornGrpTitle);
          sb.append("\n");
        }

        if(shipment_no.trim().length()>0){
          sb.append("SHIPMENT#");
          sb.append(shipment_no);
          sb.append("\n");
        }
        sb.append(txtText);
        return sb.toString();
      }
      //if have norton group title string,have to append to head.
      StringBuffer sb=new StringBuffer();
      if(notornGrpTitle.trim().length()>0){
        sb.append("         ");
        sb.append(notornGrpTitle);
        sb.append("\n");
      }
      sb.append(txtText);
      return sb.toString();
    }catch(Exception exp){
      exp.printStackTrace();
      throw exp;
    }
  }
  void btnExport_actionPerformed(ActionEvent e) {
    Record recDBCR2Append=null;
    String strYYMM=null;
    int lengthOfDbNo=("001".equals(util.PublicVariable.OPERATTING_CENTER))?10:12;
    if(txtDbCr2Follow.getText().trim().length()>0 &&
       txtDbCr2Follow.getText().trim().length()!=lengthOfDbNo){
       exgui.verification.VerifyLib.showAlert("DBCR# Format ERROR",
                                              "DBCR# Format ERROR");

       return;
    }
    if(txtDbCr2Follow.getText().trim().length()==lengthOfDbNo){
      String dbcr2Append=txtDbCr2Follow.getText().trim().toUpperCase();
      try{
        Vector vct=exgui2.CONST.BASIC_MAIN_EJB.getDatas(
         util.PublicVariable.USER_RECORD,
         "select * from DEBITNOTE_HEAD where DBNT_NO='"+
         util.MiscFunc.Replace(dbcr2Append,"'","''")+
         "' and cen_code='"+util.PublicVariable.OPERATTING_CENTER+"'"+
         " and record_delete_flag='1'"
         ,1,9999);
        if(vct.size()==0){
          exgui.verification.VerifyLib.showAlert("DB/CR#:"+dbcr2Append+" Not Found!!","DB/CR# Not Found");
          return;
        }
        recDBCR2Append=(Record)vct.get(0);
        //HH0711D007
        strYYMM=recDBCR2Append.get(0).toString().substring(2,6);
      }catch(Exception exp){
        exp.printStackTrace();
      }
    }

    HashMap hmCheckSRN=new HashMap();//after detail record geneated,remove elements in records,the rest are un-existed in db
    HashMap hmGeneratedSRN=new HashMap();
    //checking if noe text field input
    java.util.List srnArr=new java.util.ArrayList();
    for(int i=0;i<30;i++){
      String txt=txts[i].getText();
      if(txt.trim().length()>0){
          if(txt.trim().length()<12){
            exgui.verification.VerifyLib.showAlert("SRN # �ܤ�12���","SRN# too short");
            txts[i].selectAll();
            txts[i].grabFocus();
            return;
          }
         hmCheckSRN.put(txt.trim(),txt.trim());
         srnArr.add(txt.trim());
      }
    }
    if(srnArr.size()==0){
      exgui.verification.VerifyLib.showAlert("Pleas Input SRN to export ","Please Input SRN");
      return;
    }
    util.MiscFunc.showProcessingMessage();
    String srnArrDest[]=(String[])srnArr.toArray(new String[0]);
    //test if srn already in export list,if user insist,continue;
    StringBuffer sb0=new StringBuffer();
    sb0.append("select ");
    for(int i=0;i<srnArrDest.length;i++){
      sb0.append("(select count(*) from debitnote_from_srn where ship_no='");
      sb0.append(srnArrDest[i]);
      sb0.append("') as ");
      sb0.append(srnArrDest[i]);
      if(i<(srnArrDest.length-1)) sb0.append(",");
    }
    sb0.append(" from dual");
    try{
       java.util.Vector vct=exgui2.CONST.BASIC_MAIN_EJB.getDatas(
       util.PublicVariable.USER_RECORD,
       sb0.toString(),1,1);
       database.datatype.Record rec=(database.datatype.Record)vct.get(0);
       StringBuffer sbSrnExportList=new StringBuffer();
       for(int j=0;j<rec.getFieldName().size();j++){
         if(rec.getInt(j)>0){
           if(sbSrnExportList.length()>0)sbSrnExportList.append(",");
           sbSrnExportList.append((String)rec.getFieldName().get(j));
         }
       }
       if(sbSrnExportList.length()>0){

         exgui.verification.VerifyLib.showAlert("SRN"+sbSrnExportList.toString()+" Already exported",
                                                "SRN ALREADY EXPORTED");
         return;
         /*
         if(!exgui.verification.VerifyLib.showConfirm("SRN"+sbSrnExportList.toString()+" exported\nDo You Want To Re-Export ?",
                                                      "SRN ALREADY EXPORTED",
                                                      false)){
           return ;
         }*/
       }
    }catch(Exception exp){
      exp.printStackTrace();
    }

    StringBuffer sb=new StringBuffer();
    sb.append("select ");
    sb.append("distinct a.ship_no, "); //<<---0
    sb.append("(select dep_prefix from department where dep_code=");
    sb.append("(select b.PROD_DEPTMENT from prod_head b where b.prod_head_pk=a.prod_head_pk)) as dep_abbr, ");//<<---1
    sb.append("(select to_char(shipping.ship_etd_date,'YYMM') from shipping where shipping.ship_no=a.ship_no) as yymm,  ");//<<---2
    sb.append("(select prod_buyer from prod_head where prod_head_pk=a.prod_head_pk) as dbnt_bymkr_seq, ");//<<---3
    sb.append("(select nvl(bymkr_name2,bymkr_name) from buyer_maker where bymkr_seq=");
    sb.append("(select prod_buyer from prod_head where prod_head_pk=a.prod_head_pk))  ");
    sb.append("as dbnt_bymkr_name, ");//<<---4
    sb.append("(select bymkr_contact_person from buyer_maker where bymkr_seq=");
    sb.append("(select prod_buyer from prod_head where prod_head_pk=a.prod_head_pk))  ");
    sb.append("as dbnt_attn, ");//<<---5

    sb.append("(select bymkr_warehouse from buyer_maker where bymkr_seq=");
    sb.append("(select prod_buyer from prod_head where prod_head_pk=a.prod_head_pk))  ");
    sb.append("as buyer_wharehouse, ");//<<---6

    sb.append("(select pdxn.PROD_BRNCH_BRIEF from production pdxn where pdxn.prod_head_pk=a.prod_head_pk) as dbnt_branch_brf, ");//<<---7
    sb.append("(select div_name from division where div_code=(select PROD_BUYER_DIVISION from prod_head where prod_head_pk=a.prod_head_pk)) as dbnt_bymkr_div_code, ");//<<---8
    sb.append("'' as bank_desc, ");//<<---9
    sb.append("'' as dbbt_addr, ");//<<---10
    sb.append("(select b.PROD_DEPTMENT from prod_head b where b.prod_head_pk=a.prod_head_pk) as dep_code, ");//<<---11
    sb.append("(select pdxn.PROD_SC_CURRENCY from production pdxn where pdxn.prod_head_pk=a.prod_head_pk) as dbnt_currency, ");//<<---12
    sb.append("'COLLECTION OF COMMISSION AS PER FOLLOWING SHIPMENT ATTACHED.' as dbnt_collect_desc, ");//<<---13
    sb.append("'1' as dbnt_dtl_kind, ");//<<---14
    //sb.append("get_srn_commision(ship_no) as dbnt_dtl_amt ,");//<<---15
    sb.append(" 0 as dbnt_dtl_amt ,");//<<---15
    sb.append("(select to_char(shipping.ship_etd_date,'YYYYMM') from shipping where shipping.ship_no=a.ship_no) as yyyymm,");//<--16
    sb.append("'' as dbntl_dtl_desc ");//<--17
    sb.append(",(select shipping.ship_HAWB from shipping where shipping.ship_no=a.ship_no) as SHIPMEMTNO ");//<--18,for OAKLEY TYPE
    sb.append(",'COMMISION' as ASHWORTH_COMM ");//<--19
    sb.append(",(select shipping.ship_fty_inv from shipping where shipping.ship_no=a.ship_no) as fty_inv_no ");//<--20
    sb.append(",(select CENTER.CEN_PREFIX from center,prod_head where center.cen_code=prod_head.prod_cen_code and prod_head_pk=a.prod_head_pk  ) as cen_prefix ");//<---21
    sb.append("from ship_sc a ");
    sb.append("where ship_sc_pk in ");
    sb.append("(select ship_sc_pk from ship_sc ");
    sb.append("where ship_no in (");
    for(int i=0;i<srnArrDest.length;i++){
      sb.append("'");
      sb.append(srnArrDest[i]);
      sb.append("'");
      if(i<srnArrDest.length-1)sb.append(",");
    }
    sb.append("))");
    sb.append(" order by a.ship_no ");
 //   System.out.println(sb.toString());
    try{
      Vector vctOrgShipRec=exgui2.CONST.BASIC_MAIN_EJB.getDatas(
          util.PublicVariable.USER_RECORD,
          sb.toString(),1,99999999);
      if(vctOrgShipRec.size()==0){
        exgui.verification.VerifyLib.showAlert("SRN Not Exists","SRN Not Exists");
        return;
      }
      String cen_prefix=null;
      int buyerSeq=(recDBCR2Append==null)?((Record)vctOrgShipRec.get(0)).getInt(3):recDBCR2Append.getInt(3);//DBNT_BYMKR_SEQ
      boolean confirmedBuyerDiff=false;
      for(int i=0;i<vctOrgShipRec.size();i++){
        Record recTest=(Record)vctOrgShipRec.get(i);

        if(cen_prefix==null)cen_prefix=(String)recTest.get("cen_prefix");
        hmCheckSRN.remove(recTest.get(0));//remove the list of query,
        int xntBuyer=recTest.getInt(3);
        if(xntBuyer!=buyerSeq && (!confirmedBuyerDiff)){
          if(!exgui.verification.VerifyLib.showConfirm("Buyers are Different,Do You Want To Continue?","Buyer Diff",false)){
            return;
          }
          confirmedBuyerDiff=true;
        }
      }
      //the rest are un-exist srn no.
      java.util.Iterator itr=hmCheckSRN.keySet().iterator();
      StringBuffer sbCHK=new StringBuffer();
      while(itr.hasNext()){
          String key=(String)itr.next();
          if(sbCHK.length()>0)sbCHK.append(",");
          sbCHK.append(key);
      }
      if(sbCHK.length()>0){
        exgui.verification.VerifyLib.showAlert("SRN :"+sbCHK.toString()+" Not Exist \nPlease Check SRN Before Export",
                                               "SRN NOT EXIST");
        return;
      }
      //after check the exist of srn,get srn's buyer comm amt
      StringBuffer sbAMT=new StringBuffer();
      sbAMT.append("select ");
      for(int i=0;i<srnArrDest.length;i++){
        sbAMT.append("get_srn_commision('");
        sbAMT.append(srnArrDest[i]);
        sbAMT.append("') as ");
        sbAMT.append(srnArrDest[i]);
        if(i<(srnArrDest.length-1)) sbAMT.append(",");
      }
      sbAMT.append(" from dual");

      Vector vctAmtTest=exgui2.CONST.BASIC_MAIN_EJB.getDatas(
       util.PublicVariable.USER_RECORD,
       sbAMT.toString(),1,9999999);
       Record recAmtTest=(Record)vctAmtTest.get(0);

      for(int i=0;i<vctOrgShipRec.size();i++){
        Record rec=(Record)vctOrgShipRec.get(i);
        rec.set(15,recAmtTest.get((String)rec.get(0)));
        String shipmentNo=(String)rec.get(18);
        dbObj=new TempDb((String)rec.get(0));
        if(current_buyer_type==BUYER_TYPE_ASHWORTH){
          String ftyInv=(String)rec.get(20);
          if(null==ftyInv)ftyInv="";
          ftyInv=util.MiscFunc.complementStringAlignRight(' ',ftyInv,13);
          rec.set(17,ftyInv+"   COMMISSION ");
        }else if(current_buyer_type==BUYER_TYPE_OTHERS && i>0){
          String tblText=getShipDetailDescBlock((String)rec.get(0),shipmentNo,1,rec);
          rec.set(17,tblText);
        }else if (current_buyer_type==BUYER_TYPE_OAKLEY){
          String tblText=getShipDetailDescBlock((String)rec.get(0),shipmentNo,1,rec);
          rec.set(17,tblText);
        }else{
          String tblText=getShipDetailDescBlock((String)rec.get(0),shipmentNo,0,rec);
          rec.set(17,tblText);
        }
        vctOrgShipRec.set(i,rec);
      }
     Record recDebitNoteHead = Constans.DEBIT_NOTE_HEAD_DBHANDLER.getBlankRecord();
     if(recDBCR2Append==null){
      Record recTempShipRec = (Record)vctOrgShipRec.get(0);

      Object defaultBranch =
          (DbJcbxcbxBranch.getSelectedValue() == null) ? "NEWTIMES INT''L" :
          DbJcbxcbxBranch.getSelectedValue();


      //debitnote No init by dep-brief and yymm,rest code will be generated by server component
      strYYMM=(String)recTempShipRec.get(2);
      recDebitNoteHead.set(0,
                           ((String)recTempShipRec.get(1)) +
                           ((String)recTempShipRec.get(2)));
      recDebitNoteHead.set(1, defaultBranch); //branch brief
      recDebitNoteHead.set(2, "BUYER"); //dbnt_bymkr_type--->always  buyer
      recDebitNoteHead.set(3, recTempShipRec.get(3)); //buyer seq
      recDebitNoteHead.set(4, recTempShipRec.get(4)); //buyer name
      if (rdoSelectBuyerName.isSelected()) {
        //shows dialog to select
        Vector vct2selectName = exgui2.CONST.BASIC_MAIN_EJB.getDatas(
            util.PublicVariable.USER_RECORD,
            "select DBNT_BYMKR_NAME from DEBITNOTE_BYMKR_NAME where DBNT_BYMKR_SEQ=" +
            recTempShipRec.get(3), 1, 99999);

        DlgSelectBuyerName dlgSlkBuyerName = new DlgSelectBuyerName(util.
            PublicVariable.APP_FRAME, "Select Buyer Name", true,
            vct2selectName);

        dlgSlkBuyerName.setSize(305, 115);
        exgui.UIHelper.setToScreenCenter(dlgSlkBuyerName);
        util.MiscFunc.hideProcessingMessage();
        dlgSlkBuyerName.show();
        String selectBuyerName = (String)dlgSlkBuyerName.DbJcbxcbxBuyerName.
            getSelectedValue();
        //recDebitNoteHead.set(4,recTempShipRec.get(4));//buyer name

        if (selectBuyerName != null && selectBuyerName.trim().length() == 0) {
          recDebitNoteHead.set(4, recTempShipRec.get(4)); //buyer name
        } else {
          recDebitNoteHead.set(4, selectBuyerName);
        }
      }

      if (rdoWithDivision.isSelected()) {
        recDebitNoteHead.set(5, recTempShipRec.get(8)); //buyer div code
      } else {
        recDebitNoteHead.set(5, null); //buyer div code
      }
      util.MiscFunc.showProcessingMessage();
      String addr = "";
      String wareHouseData = (String)recTempShipRec.get(6);
      //ware house field may contain lot other information for accounting deparment.
      if (wareHouseData == null)wareHouseData = "";
      if (wareHouseData.indexOf("Y") != -1) {
        StringBuffer sb1 = new StringBuffer();
        sb1.append("10TH FL.,FORMOSA PLASTIC BLDG., 201,");
        sb1.append("\n");
        sb1.append("TUN HUA NORTH ROAD,TAIPEI, TAIWAN,R.O.C.");
        sb1.append("\n");
        sb1.append("TEL : 886-2-27133333 FAX: 886-2-27153336");
        addr = sb1.toString();
      }
      String DbHeadStyRemarkCol1 = null;
      if (wareHouseData.indexOf("(") != -1) {
        //OAKLEY TYPE,have defferent DBNT_STY_RMK_COL1
        DbHeadStyRemarkCol1 = "REF-NO.    CONF#       PO#             STYLE#";
      }
      recDebitNoteHead.set(6, addr); //addr
      //recDebitNoteHead.set(7, recTempShipRec.get(5)); //attn //2007100,attn keep blank
      recDebitNoteHead.set(8, recTempShipRec.get(12)); //currency
      recDebitNoteHead.set(9, 0); //amt
      recDebitNoteHead.set(10, recTempShipRec.get(14)); //kind (moved to detail)
      if (recDebitNoteHead.get(4).toString().equals("NA PALI S.A.S")) {
        recTempShipRec.set(13,"COLLECTION OF PRODUCTION COMMISSION AS PER FOLLOWING SHIPMENT ATTACHED.");
      }

      //if buyer is maxell latin,the collection desc should be "COLLETION OF SERVICE FEE....."
      if(!recDebitNoteHead.get("dbnt_bymkr_name").equals("MAXELL LATIN AMERICA (MLA)") && !recDebitNoteHead.get("dbnt_bymkr_name").equals("ADVANCE TECHNO PRODUCT INC.") && !recDebitNoteHead.get("dbnt_bymkr_name").equals("MAXELL LATIN AMERICA (M.L.A.)")){
        recDebitNoteHead.set(11, recTempShipRec.get(13)); //collect desc
      }else{
        recDebitNoteHead.set(11, "COLLECTION OF SERVICE FEE AS PER FOLLOWING SHIPMENT ATTACHED."); //collect desc
      }
      //for dbnt_print_date,if month of ETD_DATE is before current month
      //adjust to the max date of the month of the ETD_DATE
      String strETD=(String)recTempShipRec.get(16);
      java.text.DateFormat dfYYYYMM=new java.text.SimpleDateFormat("yyyyMM");
      java.util.Date printDate=new java.util.Date(System.currentTimeMillis());
      String xntYYYYMM=dfYYYYMM.format(printDate);
      if(!strETD.equals(xntYYYYMM)){
        java.util.Date date=util.MiscFunc.toDate000000(Integer.parseInt(strETD.substring(0,4)),
                                                       Integer.parseInt(strETD.substring(4,6)),1);
        java.util.Calendar cld=java.util.Calendar.getInstance();
        cld.setTime(date);
        cld.set(cld.DATE,cld.getActualMaximum(cld.DAY_OF_MONTH));
        printDate =cld.getTime();

      }



      recDebitNoteHead.set(12, printDate); //print date
      recDebitNoteHead.set(13, util.PublicVariable.USER_RECORD.get(0)); //user name
      recDebitNoteHead.set(15, "1"); //record delete flag,set to "1",original is "-1"
      if (Constans.BankDataString == null) {
        TgrShowQryGui.setBankDataString();
      }
      if(rdoClrBankDataN.isSelected()){
        recDebitNoteHead.set(20,(String)Constans.BankDataString.get(defaultBranch)); //bank desc
      }else{
        recDebitNoteHead.set(20,null);
      }
      recDebitNoteHead.set(21, recTempShipRec.get(11)); //dep code
      recDebitNoteHead.set(22, recTempShipRec.get(16)); //yyyymm
      if (null != DbHeadStyRemarkCol1) {
        recDebitNoteHead.set(24, DbHeadStyRemarkCol1);
      }
     }
      //after debitnote head composed,send to server
      HashMap hmPara=new HashMap();
      hmPara.put("CEN_PREFIX",cen_prefix);
      hmPara.put("DEBITNOTE_HEAD_RECORD",recDebitNoteHead);
      //hmPara.put("DBNT_DTL_DESC",getShipDetailDescBlock((String)recTempShipRec.get(0)));//<<-------------wait for final conculsion
      //have to filter out the used SRN
      Vector vctDest2Work=new Vector();
      for(int i=0;i<vctOrgShipRec.size();i++){
        Record rec=(Record)vctOrgShipRec.get(i);
        //System.out.println(">> "+rec);
        //test if etd data matches debitnote_head
        if(!rec.get(2).equals(strYYMM)){
          StringBuffer sbMsg=new StringBuffer();
          sbMsg.append("MONTH MISSMATCH\n");
          sbMsg.append("SRN:");sbMsg.append(rec.get(0).toString()); sbMsg.append(" , ETD YYMM is:");sbMsg.append(rec.get(2).toString());sbMsg.append("\n");
          sbMsg.append("MISSMATCH TO DEBITNOTE YYMM: ");sbMsg.append(strYYMM);
          exgui.verification.VerifyLib.showPlanMsg(sbMsg.toString(),"ETD DATE MISS-MATCH");
          continue;
        }
        if (!hmGeneratedSRN.containsKey(rec.get(0))){
          hmGeneratedSRN.put(rec.get(0),rec);
          vctDest2Work.add(rec);
        }
      }
      if(vctDest2Work.size()==0){
        exgui.verification.VerifyLib.showAlert("No Data To Export",
                                               "No Data To Export");
        return;
      }
      String destDbNo=null;
      newtimesejb.debitNote.DebitNoteFacdeHome ejbHome=
          (newtimesejb.debitNote.DebitNoteFacdeHome)
          info_ejb.WeblogicServiceLocator.locateServiceHome(
          util.PublicVariable.SERVER_URL,"newtimesejb.debitNote.DebitNoteFacde");

      newtimesejb.debitNote.DebitNoteFacde ejb=ejbHome.create();

      if(recDBCR2Append==null){
           destDbNo = ejb.exportSRN2DebitNote(util.PublicVariable.
                                                  USER_RECORD.get(0).toString(),
                                                  vctDest2Work, hmPara);
      }else{
           hmPara.put("DEBITNOTE_HEAD_RECORD",recDBCR2Append);
          destDbNo=(String)recDBCR2Append.get(0);
          ejb.appendSRN2DebitNote(util.PublicVariable.USER_RECORD.get(0).toString(),vctDest2Work, hmPara);


      }
       if(exgui.verification.VerifyLib.showConfirm("Export Result DB/CR#"+destDbNo+"\nDo You Want To Print DB Report?",
                                                   "Export Result DB/CR#"+destDbNo,true)){

         ShowDbHeadReport(destDbNo);
       }
       /*
       exgui.verification.VerifyLib.showPlanMsg("Export Result DB/CR#"+destDbNo,
                                                "Export Result DB/CR#"+destDbNo);
        */
       return;
    }catch(Exception exp){
      exp.printStackTrace();
    }finally{
      util.MiscFunc.hideProcessingMessage();
    }


  }
}
