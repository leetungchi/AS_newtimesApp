package newtimes.accounting.debit_note;

import java.awt.*;
import exgui.*;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.event.*;
import java.util.*;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class PnlQryReport4UnExportedBuyerComm extends JPanel {
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel1 = new BlueBkgWhiteCharLabel();
  JLabel jLabel1 = new JLabel();
  JComboBox cbxDep = new JComboBox();
  JLabel jLabel2 = new JLabel();
  JTextField txtEtdFrom = new JTextField();
  JLabel jLabel3 = new JLabel();
  JTextField txtEtdTo = new JTextField();
  JButton btnQry = new JButton();
  JButton btnExit = new JButton();
  Border border1;
  exgui.DataBindJCombobox dbCbxDep;
  exgui.DataBindTextWithChecker dbTxtEtdFrom,dbTxtEtdTo;
  database.encoders.OracleEncoder oracleEncode=new database.encoders.OracleEncoder();
  Object vftxtShipETDdate=exgui.verification.CellFormat.getDateStringFormaterAllowNull();
  MyListPanel pnl=null;
  JLabel jLabel4 = new JLabel();
  JComboBox cbxType = new JComboBox(new String[]{"BUYER","MAKER"});
  int shippingSRNLength=12;
  public PnlQryReport4UnExportedBuyerComm() {
    try {
      if(!(util.PublicVariable.OPERATTING_CENTER.equals("NTHK")||util.PublicVariable.OPERATTING_CENTER.equals("001"))){
        shippingSRNLength=13;
       }

      jbInit();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }

  void jbInit() throws Exception {
    border1 = new EtchedBorder(EtchedBorder.RAISED,Color.white,new Color(148, 145, 140));
    blueBkgWhiteCharLabel1.setText("BUYER COMM. & MAKER DISC. NOT YET EXPORT");
    blueBkgWhiteCharLabel1.setBounds(new Rectangle(-1, 16, 801, 30));
    this.setLayout(null);
    jLabel1.setFont(new java.awt.Font("Dialog", 1, 11));
    jLabel1.setText("DEP.");
    jLabel1.setBounds(new Rectangle(197, 60, 40, 23));
    cbxDep.setBounds(new Rectangle(236, 60, 179, 24));
    jLabel2.setBounds(new Rectangle(435, 60, 89, 23));
    jLabel2.setText("ETD FROM:");
    jLabel2.setFont(new java.awt.Font("Dialog", 1, 11));
    txtEtdFrom.setText("");
    txtEtdFrom.setBounds(new Rectangle(506, 60, 72, 24));
    jLabel3.setFont(new java.awt.Font("Dialog", 1, 11));
    jLabel3.setText("TO");
    jLabel3.setBounds(new Rectangle(580, 60, 35, 23));
    txtEtdTo.setBounds(new Rectangle(599, 60, 72, 24));
    txtEtdTo.setText("");
    btnQry.setBounds(new Rectangle(688, 57, 99, 27));
    btnQry.setFont(new java.awt.Font("Dialog", 1, 11));
    btnQry.setText("QUERY");
    btnQry.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnQry_actionPerformed(e);
      }
    });
    btnExit.setFont(new java.awt.Font("Dialog", 1, 11));
    btnExit.setText("EXIT");
    btnExit.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnExit_actionPerformed(e);
      }
    });
    jLabel4.setBounds(new Rectangle(4, 60, 40, 23));
    jLabel4.setText("TYPE");
    jLabel4.setFont(new java.awt.Font("Dialog", 1, 11));
    cbxType.setBounds(new Rectangle(55, 60, 125, 24));
    this.add(blueBkgWhiteCharLabel1, null);
    this.add(txtEtdFrom, null);
    this.add(jLabel1, null);
    this.add(cbxDep, null);
    this.add(jLabel2, null);
    this.add(jLabel3, null);
    this.add(txtEtdTo, null);
    this.add(btnQry, null);
    this.add(jLabel4, null);
    this.add(cbxType, null);
    //this.add(btnExit, null);
    dbCbxDep=
       new exgui.DataBindJCombobox(
            cbxDep,"",
            newtimes.preproduction.guis.tempProperties.tmpDepartment,
            "DEP_NAME", "DEP_PREFIX",
            null,"",null);



       dbTxtEtdFrom= new exgui.DataBindTextWithChecker(txtEtdFrom,
                                          "SHIP_ETD_DATE",
                                           null,10,
                                          (exgui.Object2String)vftxtShipETDdate,
                                          (exgui.ultratable.CellTxtEditorFormat)vftxtShipETDdate);
       dbTxtEtdTo=new exgui.DataBindTextWithChecker(txtEtdTo,
                                          "SHIP_ETD_DATE",
                                           null,10,
                                          (exgui.Object2String)vftxtShipETDdate,
                                          (exgui.ultratable.CellTxtEditorFormat)vftxtShipETDdate);

   //--------------------------init for blank list---------------------------------
    util.InsertionOrderedHashMap iso=new
        util.InsertionOrderedHashMap();
    iso.put("        SHIP NO          ","SHIP_NO");
    iso.put("        ETD DATE         ","ship_etd_date");
    iso.put("        BUYER                       ","buyer_name");
    Hashtable ht=new Hashtable();
    ht.put("        ETD DATE         ",vftxtShipETDdate);
    DbList tmp=new DbList();
    tmp.isDummy=true;
    pnl=new MyListPanel( tmp,25,iso,ht);
    JPanel pnl2setButton=pnl.getLowerRightPanel();
    pnl2setButton.setLayout(null);
    btnExit.setBounds(new Rectangle(100, 0, 99, 27));
    btnExit.setPreferredSize(new java.awt.Dimension(99,27));

    pnl2setButton.add(btnExit,null);
    pnl.setBounds(new Rectangle(12, 97, 772, 470));
    this.add(pnl, null);
    pnl.firstPage();
    this.repaint();
    this.validate();


  }

  void btnQry_actionPerformed(ActionEvent e) {
    if(pnl!=null) this.remove(pnl);
    util.InsertionOrderedHashMap iso=new
        util.InsertionOrderedHashMap();

    iso.put("        SHIP NO          ","SHIP_NO");
    iso.put("        ETD DATE         ","ship_etd_date");

    if(cbxType.getSelectedItem().equals("BUYER")){
      iso.put("        BUYER                       ", "buyer_name");
    }else if(cbxType.getSelectedItem().equals("MAKER")) {
      iso.put("        MAKER                       ", "maker_name");
    }else{
      iso.put("        OTHER                       ", "maker_name");
    }



    Hashtable ht=new Hashtable();
    ht.put("        ETD DATE         ",vftxtShipETDdate);
    if(cbxType.getSelectedItem().equals("BUYER")){
      pnl = new MyListPanel(new DbList(), 25, iso, ht);
    }else if(cbxType.getSelectedItem().equals("MAKER")){
      pnl = new MyListPanel(new DbListMaker(), 25, iso, ht);
    }else{
      pnl = new MyListPanel(new DbListOther(), 25, iso, ht);
    }

    JPanel pnl2setButton=pnl.getLowerRightPanel();
    pnl2setButton.setLayout(null);
    btnExit.setBounds(new Rectangle(100, 0, 99, 27));
    btnExit.setPreferredSize(new java.awt.Dimension(99,27));

    pnl2setButton.add(btnExit,null);
    pnl.setBounds(new Rectangle(12, 97, 772, 470));
    this.add(pnl, null);
    pnl.firstPage();
    this.repaint();
    this.validate();
  }
  class MyListPanel extends processhandler.template.PnlTableEditor{
    public MyListPanel(exgui.ultratable.PagedDataFactory pagedDataFxy,
                      int rowCounts,util.InsertionOrderedHashMap columnMapping,
                     java.util.Hashtable object2StringConvertor){
        super(pagedDataFxy, rowCounts, columnMapping, object2StringConvertor);
    }
    public void doPrint(){}
    public void makeTable(Vector vct){
      super.makeTable(vct);
      getJtable().getColumnModel().getColumn(2).setPreferredWidth(400);
    }
    public int getEachPageRowCount(){return _rowCounts;}
    public Hashtable getObject2StringConvertor() {return klmObjKvtHt;}
    public util.InsertionOrderedHashMap getHeadColumnMap(){return tblHeadColumn;}
    public exgui.ultratable.PagedDataFactory getPagedDataFactory(){return dbHandler;}
    public database.datatype.Record setObject2Record(database.datatype.Record rec,int col,Object obj){return null;}
    public void refineEditors(exgui.ultratable.MultiEditorJTable me ){
      return;
    }
  }

  void btnExit_actionPerformed(ActionEvent e) {
    /*
    if(!exgui.verification.VerifyLib.showConfirm("Do You Sure To Exit ?","Do You Sure To Exit?",false) ){
      return;
    }*/
    try{
      processhandler.template.Properties.getCenteralControler().goBack();
    }catch(Exception exp){
      exp.printStackTrace();
    }

  }
  class DbListOther extends DbList {
    //test
   DbListOther(){
    String headding="ZATW";
    if(util.PublicVariable.OPERATTING_CENTER.equals("NTHK")) headding="ZNNT";
    if(shippingSRNLength ==13){
         String prefix=newtimes.accounting.debit_note.Constans.getCenterPrefix((String)util.PublicVariable.OPERATTING_CENTER);
         headding="Z__"+prefix;
    }
    if(dbCbxDep.getSelectedValue()!=null){
      headding+=dbCbxDep.getSelectedValue();
    }
    StringBuffer sb=new StringBuffer();
    sb.append("select ship_no,ship_etd_date,");
    sb.append("(select BYMKR_NAME from buyer_maker ");
    sb.append("where bymkr_seq=");
    sb.append("(select prod_maker from prod_head where prod_head_pk=");
    sb.append("(select prod_head_pk from ship_sc where ship_sc.ship_no=shipping.ship_no ");
    sb.append("and record_delete_flag='1' and rownum=1))) as maker_name ");
    sb.append(" from shipping where record_delete_flag='1' ");
    sb.append(" and ship_status='Y' ");
    Object objEtdFrom=dbTxtEtdFrom.getSelectedValue();
    Object objEtdTo=dbTxtEtdTo.getSelectedValue();
    if(objEtdFrom!=null){
      sb.append(" and  ship_etd_date >= ");
      sb.append(oracleEncode.encode(objEtdFrom));
    }
    if(objEtdTo!=null){
      sb.append(" and  ship_etd_date <= ");
      sb.append(oracleEncode.encode(objEtdTo));
    }
    sb.append(" and length(ship_no)=");
    sb.append(String.valueOf(shippingSRNLength));
    sb.append(" and ship_no like '");
    sb.append(headding);
    sb.append("%' ");
    sb.append(" and ship_no not in (");
    sb.append("select a.ship_no from ship_sc a,prod_head b  ");
    sb.append("where a.prod_head_pk=b.prod_head_pk ");

    sb.append(" and length(a.ship_no)=");
    sb.append(String.valueOf(shippingSRNLength));

    sb.append(" and a.ship_no like '");
    sb.append(headding);
    sb.append("%' ");
    sb.append("and  b.prod_maker  in  ");
    sb.append("(select bymkr_seq from buyer_maker where  ");
    sb.append("BYMKR_WAREHOUSE like '%Z%' and BYMKR_WAREHOUSE is not null)  ");
    sb.append(")");
    sb.append(" and ship_no not in (");
    sb.append(" select ship_no from DEBITNOTE_MKR_FROM_SRN where ship_no like '");
    sb.append(headding);
    sb.append("%') ");
    sb.append("and (");
    sb.append("select count(*) from ship_style where ship_sc_pk in ");
    sb.append("(select ship_sc_pk from ship_sc where ship_sc.ship_no=shipping.ship_no) ");
    sb.append("and not (");
    sb.append("(ship_style.MKR_DSCT_DZ=0       or ship_style.MKR_DSCT_DZ is null)");
    sb.append("and (ship_style.MKR_DSCT_PER=0          or ship_style.MKR_DSCT_PER is null)");
    sb.append("and (ship_style.MKR_DSCT_LUMP_SUM=0 or ship_style.MKR_DSCT_LUMP_SUM is null)");
    sb.append("and (ship_style.MKR_DSCT_PC=0       or ship_style.MKR_DSCT_PC is null))");
    sb.append(") >0 ");
    if(shippingSRNLength ==12){
      sb.append(" order by to_number(substr(ship_no,7,6))");
    }else{
      sb.append(" order by to_number(substr(ship_no,8,6))");
    }
    sql=sb.toString();
   }
  }


   class DbListMaker extends DbList {
     //test
    DbListMaker(){
     String headding="ZATW";
     if(util.PublicVariable.OPERATTING_CENTER.equals("NTHK")) headding="ZNNT";
     if(shippingSRNLength ==13){
          String prefix=newtimes.accounting.debit_note.Constans.getCenterPrefix((String)util.PublicVariable.OPERATTING_CENTER);
          headding="Z__"+prefix;
     }
     if(dbCbxDep.getSelectedValue()!=null){
       headding+=dbCbxDep.getSelectedValue();
     }
     StringBuffer sb=new StringBuffer();
     sb.append("select ship_no,ship_etd_date,");
     sb.append("(select BYMKR_NAME from buyer_maker ");
     sb.append("where bymkr_seq=");
     sb.append("(select prod_maker from prod_head where prod_head_pk=");
     sb.append("(select prod_head_pk from ship_sc where ship_sc.ship_no=shipping.ship_no ");
     sb.append("and record_delete_flag='1' and rownum=1))) as maker_name ");
     sb.append(" from shipping where record_delete_flag='1' ");
     sb.append(" and ship_status='Y' ");
     Object objEtdFrom=dbTxtEtdFrom.getSelectedValue();
     Object objEtdTo=dbTxtEtdTo.getSelectedValue();
     if(objEtdFrom!=null){
       sb.append(" and  ship_etd_date >= ");
       sb.append(oracleEncode.encode(objEtdFrom));
     }
     if(objEtdTo!=null){
       sb.append(" and  ship_etd_date <= ");
       sb.append(oracleEncode.encode(objEtdTo));
     }
     //sb.append(" and length(ship_no)=12 ");
     sb.append(" and length(ship_no)=");
     sb.append(String.valueOf(shippingSRNLength));
     sb.append(" and ship_no like '");
     sb.append(headding);
     sb.append("%' ");
     sb.append(" and ship_no not in (");
     sb.append("select a.ship_no from ship_sc a,prod_head b  ");
     sb.append("where a.prod_head_pk=b.prod_head_pk ");
     sb.append(" and length(a.ship_no)=");
     sb.append(String.valueOf(shippingSRNLength));
     sb.append(" and a.ship_no like '");
     sb.append(headding);
     sb.append("%' ");
     sb.append("and  b.prod_maker  in  ");
     sb.append("(select bymkr_seq from buyer_maker where  ");
     sb.append("BYMKR_WAREHOUSE like '%Z%' and BYMKR_WAREHOUSE is not null)  ");
     sb.append(")");
     sb.append(" and ship_no not in (");
     sb.append(" select ship_no from DEBITNOTE_MKR_FROM_SRN where ship_no like '");
     sb.append(headding);
     sb.append("%') ");
     sb.append("and (");
     sb.append("select count(*) from ship_style where ship_sc_pk in ");
     sb.append("(select ship_sc_pk from ship_sc where ship_sc.ship_no=shipping.ship_no) ");
     sb.append("and not (");
     sb.append("(ship_style.MKR_DSCT_DZ=0       or ship_style.MKR_DSCT_DZ is null)");
     sb.append("and (ship_style.MKR_DSCT_PER=0          or ship_style.MKR_DSCT_PER is null)");
     sb.append("and (ship_style.MKR_DSCT_LUMP_SUM=0 or ship_style.MKR_DSCT_LUMP_SUM is null)");
     sb.append("and (ship_style.MKR_DSCT_PC=0       or ship_style.MKR_DSCT_PC is null))");
     sb.append(") >0 ");
     //ZMFEEK702371
     if(shippingSRNLength ==12){
       sb.append(" order by to_number(substr(ship_no,7,6))");
     }else{
       sb.append(" order by to_number(substr(ship_no,8,6))");
     }
     sql=sb.toString();
    }
   }
  class DbList extends exgui.ultratable.PagedDataFactoryAdapter {
    String sql=null;
    boolean isDummy=false;
    DbList(){
      //test
      String headding="ZATW";
      if(util.PublicVariable.OPERATTING_CENTER.equals("NTHK")) headding="ZNNT";
      if(shippingSRNLength ==13){
           String prefix=newtimes.accounting.debit_note.Constans.getCenterPrefix((String)util.PublicVariable.OPERATTING_CENTER);
           headding="Z__"+prefix;
      }

      if(dbCbxDep.getSelectedValue()!=null){
        headding+=dbCbxDep.getSelectedValue();
      }
      StringBuffer sb=new StringBuffer();
      sb.append("select ship_no,ship_etd_date,");
      sb.append("(select BYMKR_NAME from buyer_maker ");
      sb.append("where bymkr_seq=");
      sb.append("(select prod_buyer from prod_head where prod_head_pk=");
      sb.append("(select prod_head_pk from ship_sc where ship_sc.ship_no=shipping.ship_no ");
      sb.append("and record_delete_flag='1' and rownum=1))) as buyer_name ");
      sb.append(" from shipping where record_delete_flag='1' ");
      Object objEtdFrom=dbTxtEtdFrom.getSelectedValue();
      Object objEtdTo=dbTxtEtdTo.getSelectedValue();
      if(objEtdFrom!=null){
        sb.append(" and  ship_etd_date >= ");
        sb.append(oracleEncode.encode(objEtdFrom));
      }
      if(objEtdTo!=null){
        sb.append(" and  ship_etd_date <= ");
        sb.append(oracleEncode.encode(objEtdTo));
      }
      sb.append(" and length(ship_no)=");
      sb.append(String.valueOf(shippingSRNLength));
      sb.append(" and ship_no like '");
      sb.append(headding);
      sb.append("%' ");
      sb.append(" and ship_no not in (");
      sb.append(" select ship_no from debitnote_from_srn where ship_no like '");
      sb.append(headding);
      sb.append("%') ");
      sb.append("and (");
      sb.append("select count(*) from ship_style where ship_sc_pk in ");
      sb.append("(select ship_sc_pk from ship_sc where ship_sc.ship_no=shipping.ship_no) ");
      sb.append("and not (");
      sb.append("(ship_style.BUY_DSCT_DZ=0       or ship_style.BUY_DSCT_DZ is null)");
      sb.append("and (ship_style.BUY_COMM=0          or ship_style.BUY_COMM is null)");
      sb.append("and (ship_style.BUY_DSCT_LUMP_SUM=0 or ship_style.BUY_DSCT_LUMP_SUM is null)");
      sb.append("and (ship_style.BUY_DSCT_PC=0       or ship_style.BUY_DSCT_PC is null))");
      sb.append(") >0 ");
      if(shippingSRNLength ==12){
        sb.append(" order by to_number(substr(ship_no,7,6))");
      }else{
        sb.append(" order by to_number(substr(ship_no,8,6))");
      }
      sql=sb.toString();
    }
    public Vector getRecords(int rowpos,int rowcount)throws Exception{
      if(isDummy)return new Vector();
      try{
            util.MiscFunc.showProcessingMessage();
            return exgui2.CONST.BASIC_MAIN_EJB.getDatas(
            util.PublicVariable.USER_RECORD,
            sql, rowpos, rowcount);
      }finally{
           util.MiscFunc.hideProcessingMessage();
      }
    }
  }

}
