package newtimes.accounting;
import java.awt.*;
import javax.swing.*;
import exgui.*;
import newtimes.preproduction.buyermakerselect.*;
import  database.datatype.*;
import java.util.*;
import java.awt.event.*;
import javax.swing.border.*;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class PnlPaidStudioMaintain extends JPanel {
  JLabel jLabel2 = new JLabel();
  JTextField txtCreateDateFrom = new JTextField();
  JLabel jLabel3 = new JLabel();
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel1 = new BlueBkgWhiteCharLabel();
  JTextField txtCreateDateTo = new JTextField();
  JButton btnQry = new JButton();
  JLabel jLabel1 = new JLabel();
  JButton btnUpdate = new JButton();
  //JPanel pnlListInvDdk = new JPanel();
  Panel2List pnlListInvDdk = null;
  JButton btnExit = new JButton();
  boolean isInit=true;

  public PnlPaidStudioMaintain() {
    try {
      jbInit();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }

  class TempDb extends exgui.ultratable.PagedDataFactoryAdapter{
     public void updateRecords(Vector vct2update)throws Exception{
       if(vct2update==null||vct2update.size()==0)return;
       Record recBlank=(Record) util.MiscFunc.deepCopy(util.PublicVariable.USER_RECORD);
       recBlank.getValueFields().clear();recBlank.getFieldName().clear();
       recBlank.getFieldName().add("PRICE_PK");recBlank.getFieldName().add("C3_PAID_DATE");
       recBlank.getFieldName().add("BLNC_PAID_DATE");recBlank.getFieldName().add("RECORD_CREATE_USER");

       recBlank.getFieldName().add("INV_NO");
       recBlank.getFieldName().add("INV_NO_2");recBlank.getFieldName().add("BLNC_PAID_DATE_2");
       recBlank.getFieldName().add("INV_NO_3");recBlank.getFieldName().add("BLNC_PAID_DATE_3");
       recBlank.getFieldName().add("INV_NO_4");recBlank.getFieldName().add("BLNC_PAID_DATE_4");

       recBlank.getValueFields().add(null);recBlank.getValueFields().add(null);
       recBlank.getValueFields().add(null);recBlank.getValueFields().add(null);
       recBlank.getValueFields().add(null);
       recBlank.getValueFields().add(null);recBlank.getValueFields().add(null);
       recBlank.getValueFields().add(null);recBlank.getValueFields().add(null);
       recBlank.getValueFields().add(null);recBlank.getValueFields().add(null);

       Vector vctToEjb=new Vector();
       for(int i=0;i<vct2update.size();i++){
         Record rec=(Record)vct2update.get(i);
         Record rec2Proc=(Record)util.MiscFunc.deepCopy(recBlank);
         rec2Proc.set(0,rec.get("PRI_SEQ"));
         rec2Proc.set(1,rec.get("C3_PAID_DATE"));
         rec2Proc.set(2,rec.get("BLNC_PAID_DATE"));
         rec2Proc.set(3,util.PublicVariable.USER_RECORD.get(0));

         rec2Proc.set("INV_NO",rec.get("INV_NO"));
         rec2Proc.set("INV_NO_2",rec.get("INV_NO_2"));
         rec2Proc.set("BLNC_PAID_DATE_2",rec.get("BLNC_PAID_DATE_2"));

         rec2Proc.set("INV_NO_3",rec.get("INV_NO_3"));
         rec2Proc.set("BLNC_PAID_DATE_3",rec.get("BLNC_PAID_DATE_3"));

         rec2Proc.set("INV_NO_4",rec.get("INV_NO_4"));
         rec2Proc.set("BLNC_PAID_DATE_4",rec.get("BLNC_PAID_DATE_4"));

         vctToEjb.add(rec2Proc);
       }
       newtimesejb.TPE_MIS.TpeMisFuncHome ejbHome=
           (newtimesejb.TPE_MIS.TpeMisFuncHome)
           info_ejb.WeblogicServiceLocator.locateServiceHome(util.PublicVariable.SERVER_URL,
           "newtimesejb.TPE_MIS.TpeMisFunc");
       newtimesejb.TPE_MIS.TpeMisFunc ejb=ejbHome.create();
       java.util.HashMap hm=new java.util.HashMap();
       hm.put("TPEMISCFUNC_ACTION_CODE","UPDATE_PAID_STUIO");
       hm.put("VCT4UPDATE_PAID_STUIO_MAINTAIN",vctToEjb);
       ejb.tpeMisFunc(hm);
     }
     public java.util.Vector getRecords(int bgn,int rowcount)throws Exception{
       /*
       StringBuffer sql=new StringBuffer();
      sql.append("select ");
      sql.append(" A.PRI_SEQ, ");
      sql.append("   (select BUYER_MAKER.BYMKR_NAME from buyer_maker where BUYER_MAKER.BYMKR_SEQ=c.PROD_BUYER ) as buyer,  ");
      sql.append(" b.sty_style, ");
      sql.append(" b.sty_po, ");
      sql.append("(select PROD_COLOR.PROD_COLOR_CODE from prod_color where prod_color_pk=a.prod_color_pk ) as color_code, ");
      sql.append(" (select PROD_COLOR.PROD_COLOR_name from prod_color  where prod_color_pk=a.prod_color_pk ) as color_name, ");
      sql.append(" GET_COLOR_QTY(a.PRI_SEQ) as qty, ");
      sql.append(" a.PRI_BYR_DOC_PRX, ");
      sql.append(" a.PRI_BYR_ACT_PRX, ");
      sql.append(" (select PS.C3_PAID_DATE from paid_studio ps where PS.PRICE_PK=A.PRI_SEQ ) as c3_paid_date, ");
      sql.append(" (select PS.BLNC_PAID_DATE from paid_studio ps where PS.PRICE_PK=A.PRI_SEQ ) as BLNC_PAID_DATE ");
      sql.append(" ,a.b.sty_seq ");
      sql.append(" from price a ,style b,prod_head c ");
       if(isInit){
         sql.append(" where 1<>1");
         isInit=false;
         Vector vct=exgui2.CONST.BASIC_MAIN_EJB.getDatas(
           util.PublicVariable.USER_RECORD,sql.toString(),1,999999);
          return vct;
       }else{
         sql.append(" where ");
         sql.append(" A.PRI_STY_SEQ=B.STY_SEQ ");
         sql.append(" and c.prod_head_pk=b.prod_head_pk ");
         sql.append(" and c.PROD_DEPTMENT='TPS01' ");
         sql.append(" and C.PROD_AGENT=11612 ");

       }
       if(txtCreateDateFrom.getText().trim().length()==10){
         sql.append(" and a.record_create_date >=to_date('");
         sql.append(txtCreateDateFrom.getText().trim());
         sql.append("','yyyy/mm/dd')");
       }
       if(txtCreateDateTo.getText().trim().length()==10){
         sql.append(" and a.record_create_date <=to_date('");
         sql.append(txtCreateDateTo.getText().trim());
         sql.append("','yyyy/mm/dd')");
       }
      Vector vct=exgui2.CONST.BASIC_MAIN_EJB.getDatas(
        util.PublicVariable.USER_RECORD,sql.toString(),1,999999);

       */
      util.MiscFunc.showProcessingMessage();
      newtimesejb.TPE_MIS.TpeMisFuncHome ejbHome=
          (newtimesejb.TPE_MIS.TpeMisFuncHome)
          info_ejb.WeblogicServiceLocator.locateServiceHome(util.PublicVariable.SERVER_URL,
          "newtimesejb.TPE_MIS.TpeMisFunc");
      newtimesejb.TPE_MIS.TpeMisFunc ejb=ejbHome.create();

      java.util.HashMap hm=new java.util.HashMap();
      /*
        String isInit=(String)param.get("ISINIT");
        String bgndate=(String)param.get("BGN_DATE");
        String enddate=(String)param.get("END_DATE");
      */
      hm.put("TPEMISCFUNC_ACTION_CODE","GET_PAID_STUIO");
      hm.put("ISINIT",((isInit)?"TRUE":"FALSE"));
      if(isInit)isInit=false;
      hm.put("BGN_DATE",txtCreateDateFrom.getText().trim());
      hm.put("END_DATE",txtCreateDateTo.getText().trim());
      hm.put("C3_BLANK_YN",cbxIsC3Blank.getSelectedItem().toString().toUpperCase());
      hm.put("BUYER",slkBuyer.getSelectedValue());
      hm.put("STYLE",txtStyle.getText().trim());
      java.util.HashMap hmReturn= ejb.tpeMisFunc(hm);
      util.MiscFunc.hideProcessingMessage();
       return (Vector)hmReturn.get("VCT_RETURN");
     }
  }
  class Panel2List extends processhandler.template.PnlTableEditor

      {
      public Panel2List(exgui.ultratable.PagedDataFactory pagedDataFxy,
                        int rowCounts,util.InsertionOrderedHashMap columnMapping,
                       java.util.Hashtable object2StringConvertor){
          super(pagedDataFxy, rowCounts, columnMapping, object2StringConvertor);
          getLowerRightPanel().removeAll();
          getPanelContainsButtons().removeAll();
      }
      public void makeTable(Vector vct){
          super.makeTable(vct);
         getJtable().getColumnModel().getColumn(0).setPreferredWidth(16);
         getJtable().getColumnModel().getColumn(8).setPreferredWidth(100);
         getJtable().getColumnModel().getColumn(10).setPreferredWidth(100);
         getJtable().getColumnModel().getColumn(12).setPreferredWidth(100);
         getJtable().getColumnModel().getColumn(14).setPreferredWidth(100);
      }
      public void doPrint(){}
      public int getEachPageRowCount(){return _rowCounts;}
      public Hashtable getObject2StringConvertor() {return klmObjKvtHt;}
      public util.InsertionOrderedHashMap getHeadColumnMap(){return tblHeadColumn;}
      public exgui.ultratable.PagedDataFactory getPagedDataFactory(){return dbHandler;}
      public database.datatype.Record setObject2Record(database.datatype.Record rec,int col,Object obj){
         try{
           rec.set(storedRecordColumn[col],obj);
           return rec;
         }catch(Exception exp){
           exp.printStackTrace();
           return null;
         }
      }
      public void refineEditors(exgui.ultratable.MultiEditorJTable me ){
        me.setTextEditorVerifiers(getObject2StringConvertor());
      }
    }

  void jbInit() throws Exception {
    titledBorder1 = new TitledBorder(BorderFactory.createEtchedBorder(Color.white,new Color(148, 145, 140)),"Buyers");
    border1 = BorderFactory.createEtchedBorder(Color.white,new Color(148, 145, 140));
    titledBorder2 = new TitledBorder(border1,"Makers");
    txtCreateDateTo.setBounds(new Rectangle(198, 35, 76, 24));
    txtCreateDateTo.setText("");
    blueBkgWhiteCharLabel1.setBounds(new Rectangle(-2, 0, 801, 26));
    blueBkgWhiteCharLabel1.setText("PAID STUDIO MAINTAIN");
    jLabel3.setHorizontalAlignment(SwingConstants.CENTER);
    jLabel3.setOpaque(true);
    jLabel3.setFont(new java.awt.Font("Dialog", 1, 14));
    jLabel3.setBackground(Color.white);
    jLabel3.setText("~");
    jLabel3.setBounds(new Rectangle(169, 35, 25, 24));
    txtCreateDateFrom.setBounds(new Rectangle(91, 35, 76, 24));
    txtCreateDateFrom.setText("");
    jLabel2.setBounds(new Rectangle(5, 35, 83, 24));
    jLabel2.setText("Create Date");
    jLabel2.setHorizontalAlignment(SwingConstants.CENTER);
    jLabel2.setOpaque(true);
    jLabel2.setFont(new java.awt.Font("Dialog", 1, 11));
    jLabel2.setBackground(Color.white);
    this.setLayout(null);
    btnQry.setBounds(new Rectangle(738, 32, 52, 24));
    btnQry.setFont(new java.awt.Font("Dialog", 1, 11));
    btnQry.setMargin(new Insets(0, 0, 0, 0));
    btnQry.setText("QUERY");
    btnQry.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnQry_actionPerformed(e);
      }
    });
    jLabel1.setBorder(BorderFactory.createRaisedBevelBorder());
    jLabel1.setBounds(new Rectangle(0, 65, 798, 10));
    btnUpdate.setBounds(new Rectangle(294, 546, 154, 27));
    btnUpdate.setFont(new java.awt.Font("Dialog", 1, 11));
    btnUpdate.setText("Confirm Update");
    btnUpdate.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnUpdate_actionPerformed(e);
      }
    });
    util.InsertionOrderedHashMap iso=new util.InsertionOrderedHashMap();
    Hashtable ht=new Hashtable();
    iso.put("  BUYER  ","BUYER");//0
    iso.put("  STYLE  ","sty_style");//1
    iso.put("  PO     ","sty_PO");//2
    iso.put(" COLOR  NAME  ","COLOR_NAME");//3
    iso.put("   QTY     ","QTY");//4
    iso.put(" DOC PRX ","PRI_BYR_DOC_PRX");//5
    iso.put(" ACT PRX ","PRI_BYR_ACT_PRX");//6
    iso.put("C3\nPAID DATE","C3_PAID_DATE");//7

    iso.put("INV NO ","INV_NO");//8
    iso.put("BALANCE\nPAID DATE","BLNC_PAID_DATE");//9


    iso.put(" INV NO ","INV_NO_2");//10
    iso.put("BALANCE\nPAID DATE ","BLNC_PAID_DATE_2");//11
    iso.put("  INV NO","INV_NO_3");//12
    iso.put("BALANCE\n PAID DATE","BLNC_PAID_DATE_3");//13
    iso.put(" INV NO  ","INV_NO_4");//14
    iso.put("BALANCE \nPAID DATE","BLNC_PAID_DATE_4");//15


    Object vftxtDate = exgui.verification.CellFormat.getDateStringFormaterAllowNull();
    ht.put("C3\nPAID DATE",vftxtDate);

    ht.put("BALANCE\nPAID DATE",vftxtDate);
    ht.put("BALANCE\nPAID DATE ",vftxtDate);
    ht.put("BALANCE\n PAID DATE",vftxtDate);
    ht.put("BALANCE \nPAID DATE",vftxtDate);

    pnlListInvDdk=new Panel2List(new TempDb(),99999,iso,ht);
    pnlListInvDdk.setBounds(new Rectangle(2, 78, 789, 459));
    btnExit.setBounds(new Rectangle(598, 546, 71, 28));
    btnExit.setFont(new java.awt.Font("Dialog", 1, 11));
    btnExit.setText("EXIT");
    btnExit.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnExit_actionPerformed(e);
      }
    });
    jLabel4.setBackground(Color.white);
    jLabel4.setFont(new java.awt.Font("Dialog", 1, 11));
    jLabel4.setOpaque(true);
    jLabel4.setHorizontalAlignment(SwingConstants.CENTER);
    jLabel4.setText("STYLE");
    jLabel4.setBounds(new Rectangle(281, 35, 51, 24));
    txtStyle.setText("");
    txtStyle.setBounds(new Rectangle(333, 35, 94, 24));
    jLabel5.setBounds(new Rectangle(432, 35, 56, 24));
    jLabel5.setText("BUYER");
    jLabel5.setHorizontalAlignment(SwingConstants.CENTER);
    jLabel5.setOpaque(true);
    jLabel5.setFont(new java.awt.Font("Dialog", 1, 11));
    jLabel5.setBackground(Color.white);
    slkBuyer.setBounds(new Rectangle(490, 35, 131, 24));
    cbxIsC3Blank.setBounds(new Rectangle(627, 35, 103, 22));
    this.add(pnlListInvDdk, null);
    this.add(btnUpdate, null);
    this.add(btnExit, null);
    this.add(blueBkgWhiteCharLabel1, null);
    this.add(jLabel1, null);
    this.add(jLabel2, null);
    this.add(txtCreateDateFrom, null);
    this.add(jLabel3, null);
    this.add(txtCreateDateTo, null);
    this.add(jLabel4, null);
    this.add(txtStyle, null);
    this.add(jLabel5, null);
    this.add(slkBuyer, null);
    this.add(cbxIsC3Blank, null);
    this.add(btnQry, null);
    pnlListInvDdk.firstPage();

    //Object vftxtDate = exgui.verification.CellFormat.getDateStringFormaterAllowNull();

    exgui.DataBindTextWithChecker dbTxtFrom=new exgui.DataBindTextWithChecker(txtCreateDateFrom, "",
                                        null, 10,
                                        (exgui.Object2String)vftxtDate,
                                        (exgui.ultratable.CellTxtEditorFormat)
                                        vftxtDate);

    exgui.DataBindTextWithChecker dbTxtTo=new exgui.DataBindTextWithChecker(txtCreateDateTo, "",
                                        null, 10,
                                        (exgui.Object2String)vftxtDate,
                                        (exgui.ultratable.CellTxtEditorFormat)
                                        vftxtDate);

   slkBuyer.init("",null,slkBuyer.TYPE_BUYER,true);
  }
  exgui.DataBindJCombobox dbCbxDep;
  TitledBorder titledBorder1;
  Border border1;
  TitledBorder titledBorder2;
  JLabel jLabel4 = new JLabel();
  JTextField txtStyle = new JTextField();
  JLabel jLabel5 = new JLabel();
  SelectBuyerMaker slkBuyer = new SelectBuyerMaker();
  JComboBox cbxIsC3Blank = new JComboBox(new String[]{"ALL","C3 Blank","C3 Not Blank"});
  void btnExit_actionPerformed(ActionEvent e) {
    try{
      if(pnlListInvDdk.isContextModified()){
        if(!exgui.verification.VerifyLib.showConfirm("Context Modified But Not Confirmed\nAre You Sure Want To Exit?",
                                                     "Context Modified ",false))return;
      }


      processhandler.template.Properties.getCenteralControler().goBack();
    }catch(Exception exp){
      exp.printStackTrace();
    }
  }

  void btnUpdate_actionPerformed(ActionEvent e) {
    try{
      pnlListInvDdk.doUpdate();
    }catch(Exception exp){
      exp.printStackTrace();
      exgui.verification.VerifyLib.showAlert("Update failed!!\nPlease Contact System Manager",
                                             "Update failed!!");

    }
      pnlListInvDdk.reload();
  }

  void btnQry_actionPerformed(ActionEvent e) {
     if(pnlListInvDdk.isContextModified()){
       if(!exgui.verification.VerifyLib.showConfirm("Context Modified But Not Confirmed\nAre You Sure Want To Query?",
                                                    "Context Modified ",false))return;
     }
     if(txtCreateDateFrom.getText().trim().length()<10){
       exgui.verification.VerifyLib.showAlert("Please Input Begin CREATE DATE","Please Input Begin ETD DATE");
       return;
     }
     if(txtCreateDateTo.getText().trim().length()<10){
       exgui.verification.VerifyLib.showAlert("Please Input End CREATE DATE","Please Input End ETD DATE");
       return;
     }

     pnlListInvDdk.reload();
  }
}
