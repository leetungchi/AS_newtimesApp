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

public class PnlInvoiceDeductMaintain extends JPanel {
  JLabel jLabel2 = new JLabel();
  JTextField txtEtdFrom = new JTextField();
  JLabel jLabel3 = new JLabel();
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel1 = new BlueBkgWhiteCharLabel();
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel2 = new BlueBkgWhiteCharLabel();
  JTextField txtEtdTo = new JTextField();
  JComboBox cbxDep = new JComboBox();
  JComboBox cbxDate = new JComboBox();
  SelectBuyerMaker slkBuyer = new SelectBuyerMaker();
  JButton btnQry = new JButton();
  JLabel jLabel1 = new JLabel();
  JButton btnUpdate = new JButton();
  //JPanel pnlListInvDdk = new JPanel();
  Panel2List pnlListInvDdk = null;
  JButton btnExit = new JButton();
  boolean isInit=true;
 exgui.DataBindTextWithChecker dbTxtDdk;
 exgui.DataBindTextWithChecker dbTxtNego;
  exgui.DataBindTextWithChecker dbTxtRcv;
  public PnlInvoiceDeductMaintain() {
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
       recBlank.getFieldName().add("SHIP_NO");recBlank.getFieldName().add("USED");
       recBlank.getValueFields().add(null);recBlank.getValueFields().add(null);
       recBlank.getFieldName().add("DDK_DATE");recBlank.getValueFields().add(null);
       recBlank.getFieldName().add("NEGO_DATE");recBlank.getValueFields().add(null);
       recBlank.getFieldName().add("RCV_DATE");recBlank.getValueFields().add(null);
       Vector vctToEjb=new Vector();
       for(int i=0;i<vct2update.size();i++){
         Record rec=(Record)vct2update.get(i);
         Record rec2Proc=(Record)util.MiscFunc.deepCopy(recBlank);
         rec2Proc.set(0,rec.get("ship_no"));
         rec2Proc.set(1,rec.get("used"));
         rec2Proc.set(2,rec.get("DDK_DATE"));
         rec2Proc.set(3,rec.get("NEGO_DATE"));
         rec2Proc.set(4,rec.get("RCV_DATE"));
         vctToEjb.add(rec2Proc);
       }
       newtimesejb.TPE_MIS.TpeMisFuncHome ejbHome=
           (newtimesejb.TPE_MIS.TpeMisFuncHome)
           info_ejb.WeblogicServiceLocator.locateServiceHome(util.PublicVariable.SERVER_URL,
           "newtimesejb.TPE_MIS.TpeMisFunc");
       newtimesejb.TPE_MIS.TpeMisFunc ejb=ejbHome.create();
       java.util.HashMap hm=new java.util.HashMap();
       hm.put("TPEMISCFUNC_ACTION_CODE","UPDATE_INVOICE_DEDUCT_MAINTAIN");
       hm.put("VCT4UPDATE_INVOICE_DEDUCT_MAINTAIN",vctToEjb);
       ejb.tpeMisFunc(hm);
     }
     public java.util.Vector getRecords(int bgn,int rowcount)throws Exception{
       StringBuffer sql=new StringBuffer();
       sql.append("select  distinct ");
       sql.append("a.ship_no, ");
       sql.append("get_srn_byr_doc_amt(a.ship_no) as INV_ANT, ");
       sql.append("A.SHIP_ETD_DATE , ");
       sql.append("to_char((select count(*) from invoice_deduct b where B.SHIP_NO=a.ship_no )) as USED ,");
       sql.append(" GET_SHIP_DEST(a.SHIP_NO) as distributor ");
       sql.append(",SHIP_FTY_INV ");
       sql.append(",(select b.ddk_date from invoice_deduct b  where B.SHIP_NO=a.ship_no ) as DDK_DATE ");
       sql.append(",(select b.nego_date from invoice_deduct b  where B.SHIP_NO=a.ship_no ) as NEGO_DATE ");
       sql.append(",(select b.rcv_date from invoice_deduct b  where B.SHIP_NO=a.ship_no ) as RCV_DATE ");
       sql.append("from shipping a,ship_sc b,prod_head d ");
       if(isInit){
         sql.append(" where 1<>1");
         isInit=false;
         Vector vct=exgui2.CONST.BASIC_MAIN_EJB.getDatas(
           util.PublicVariable.USER_RECORD,sql.toString(),1,999999);
          return vct;
       }else{
         sql.append(" where a.ship_no like 'ZATW%' ");
         sql.append("and  a.ship_no=b.ship_no ");
         sql.append("and b.record_delete_flag='1' ");
         sql.append("and a.record_delete_flag='1' ");
         sql.append("and b.prod_head_pk=d.prod_head_pk ");
         // sql.append("and NOT SHIP_FTY_INV IS NULL ");
         //sql.append("and GET_SHIP_DEST(a.SHIP_NO) = 'DISTRIBUTORS' ");
       }
       if(txtEtdFrom.getText().trim().length()==10){
         sql.append(" and a.ship_etd_date >=to_date('");
         sql.append(txtEtdFrom.getText().trim());
         sql.append("','yyyy/mm/dd')");
       }
       if(txtEtdTo.getText().trim().length()==10){
         sql.append(" and a.ship_etd_date <=to_date('");
         sql.append(txtEtdTo.getText().trim());
         sql.append("','yyyy/mm/dd')");
       }
       if(null!=dbCbxDep.getSelectedValue() && (!"ALL".equals(dbCbxDep.getSelectedValue()))){
         sql.append(" and d.prod_deptment ='");
         sql.append(dbCbxDep.getSelectedValue());
         sql.append("' ");
       }
       if (byr_grp_box.getSelectedItem().equals("") ) {
          if(null!=slkBuyer.getSelectedValue() || null!=slkBuyer2.getSelectedValue() || null!=slkBuyer1.getSelectedValue()){
             sql.append(" and (");
             boolean haveBuyerCondition=false;
             if(null!=slkBuyer.getSelectedValue()){
                sql.append(" d.prod_buyer =");
                sql.append(slkBuyer.getSelectedValue());
                sql.append(" ");
                haveBuyerCondition=true;
             }
            if(null!=slkBuyer1.getSelectedValue()){
               if(haveBuyerCondition)sql.append(" or ");
                  sql.append(" d.prod_buyer =");
                  sql.append(slkBuyer1.getSelectedValue());
                  sql.append(" ");
                  haveBuyerCondition=true;
               }
            if(null!=slkBuyer2.getSelectedValue()){
               if(haveBuyerCondition)sql.append(" or ");
                  sql.append(" d.prod_buyer =");
                  sql.append(slkBuyer2.getSelectedValue());
                  sql.append(" ");
               }
               sql.append(") ");
            }
       }
       else {
          sql.append(" and (d.prod_buyer in (12284,12285,12286,12287,12288,12289,12294,12141) ) ");
       }

       if(null!=slkMaker.getSelectedValue() || null!=slkMaker1.getSelectedValue() || null!=slkMaker2.getSelectedValue()){
         sql.append(" and (");
         boolean haveMakerCondition=false;
         if(null!=slkMaker.getSelectedValue()){
           sql.append(" d.prod_maker =");
           sql.append(slkMaker.getSelectedValue());
           sql.append(" ");
           haveMakerCondition=true;
         }
         if(null!=slkMaker1.getSelectedValue()){
           if(haveMakerCondition)sql.append(" or ");
           sql.append(" d.prod_maker =");
           sql.append(slkMaker1.getSelectedValue());
           sql.append(" ");
           haveMakerCondition=true;
         }
         if(null!=slkMaker2.getSelectedValue()){
           if(haveMakerCondition)sql.append(" or ");
           sql.append(" d.prod_maker =");
           sql.append(slkMaker2.getSelectedValue());
           sql.append(" ");
         }
         sql.append(") ");
       }


       sql.append(" order by  SHIP_ETD_DATE,ship_no ");

      util.MiscFunc.showProcessingMessage();
      Vector vct=exgui2.CONST.BASIC_MAIN_EJB.getDatas(
        util.PublicVariable.USER_RECORD,sql.toString(),1,999999);
      util.MiscFunc.hideProcessingMessage();
       return vct;
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
        me.addCheckbox(0,"1");
        CellRenderor4Amount cell4amt=new CellRenderor4Amount();
         getJtable().getColumnModel().getColumn(3).setCellRenderer(cell4amt);
         CellRenderor4Date rdr4Date=new CellRenderor4Date();
         getJtable().getColumnModel().getColumn(4).setCellRenderer(rdr4Date);
         CellRenderorOtherField rdrOther=new CellRenderorOtherField();
         //getJtable().getColumnModel().getColumn(0).setCellRenderer(rdrOther);
         getJtable().getColumnModel().getColumn(1).setCellRenderer(rdrOther);
         //getJtable().getColumnModel().getColumn(3).setCellRenderer(rdrOther);
         getJtable().getColumnModel().getColumn(2).setCellRenderer(rdrOther);
         ((exgui.MultiClassTableModel)me.getJTable().getModel()).setCellEditablePolicy(new DdkEditPolicy());
      }
    }

    public class CellRenderor4Amount extends javax.swing.JLabel
        implements javax.swing.table.TableCellRenderer {
      java.text.NumberFormat nf = new java.text.DecimalFormat("##########0.00");
      public CellRenderor4Amount() {
        super();
        //setBorder(javax.swing.BorderFactory.createRaisedBevelBorder());
        setOpaque(true); /* it\u00B4s essential */
        setHorizontalAlignment(super.RIGHT);
      }

      public java.awt.Component getTableCellRendererComponent(
          javax.swing.JTable table, Object value,
          boolean isSelected, boolean hasFocus,
          int row, int column) {

        String text = (value == null) ? "" : value.toString().trim();
        if (!text.equals(""))text = nf.format(Double.parseDouble(text));
        Record rec = (Record)pnlListInvDdk.getDisplayingRecords().get(row);

        if ("DISTRIBUTORS".equalsIgnoreCase((String)rec.get(4))|| "TAIWAN".equalsIgnoreCase((String)rec.get(4))) {
          //if(null!=chkBoxValue && (chkBoxValue.toString().equalsIgnoreCase("true")||chkBoxValue.toString().equalsIgnoreCase("1"))){
          setBackground(new java.awt.Color(0xEC, 0xC8, 0xEC)); // Decides the color
          this.repaint();
        } else {
          setBackground(new java.awt.Color(0xFF, 0xFF, 0xFF)); // Decides the color
          this.repaint();
        }
        if (isSelected)setBackground(new java.awt.Color(0xFF, 0xE3, 0x8C));
        setText(text);
        return this;
      }
  }

  class DdkEditPolicy implements exgui.CellEditablePolicy{
    public boolean isCellEditable(int row, int col) {
      if(col==0)return true;
       //Record rec=(Record)pnlListInvDdk.getDisplayingRecords().get(row);
       Object objTF=pnlListInvDdk.getJtable().getValueAt(row,0);
       //System.out.println("objTF is "+((objTF==null)?"null":objTF.toString()));
       if(objTF!=null && (objTF.toString().equals("1") || objTF.toString().equalsIgnoreCase("true"))) return true;
       return false;
    }
  }
    public class CellRenderorOtherField extends javax.swing.JLabel
      implements javax.swing.table.TableCellRenderer{
      public CellRenderorOtherField(){
      super();
      setOpaque(true);
    }
    public java.awt.Component getTableCellRendererComponent(
         javax.swing.JTable table, Object value,
         boolean isSelected, boolean hasFocus,
         int row, int column){
           String text="";
         text = (value==null)?"":value.toString().trim();
        Object chkBoxValue=pnlListInvDdk.getJtable().getValueAt(row,0);
        Record rec=(Record)pnlListInvDdk.getDisplayingRecords().get(row);

        if("DISTRIBUTORS".equalsIgnoreCase((String)rec.get(4))){
        //if(null!=chkBoxValue && (chkBoxValue.toString().equalsIgnoreCase("true")||chkBoxValue.toString().equalsIgnoreCase("1"))){
          setBackground(new java.awt.Color(0xEC, 0xC8, 0xEC)); // Decides the color
          this.repaint();
        }else{
           setBackground(new java.awt.Color(0xFF, 0xFF, 0xFF)); // Decides the color
           this.repaint();
        }
        if(isSelected)setBackground(new java.awt.Color(0xFF, 0xE3, 0x8C));
        setText(text);
     return this;
    }
    }



    public class CellRenderor4Date extends javax.swing.JLabel
      implements javax.swing.table.TableCellRenderer{
       java.text.DateFormat df=new java.text.SimpleDateFormat("yyyy/MM/dd");
      public CellRenderor4Date(){
      super();
     //setBorder(javax.swing.BorderFactory.createRaisedBevelBorder());
     setOpaque(true); /* it\u00B4s essential */
     setHorizontalAlignment(super.CENTER);
    }
    public java.awt.Component getTableCellRendererComponent(
         javax.swing.JTable table, Object value,
         boolean isSelected, boolean hasFocus,
         int row, int column){
           String text="";
         if(null!=value){
           text=df.format(value);
         }
        //String text = (value==null)?"":value.toString().trim();
        //if(!text.equals("")) text=nf.format(Double.parseDouble(text));
        Object chkBoxValue=pnlListInvDdk.getJtable().getValueAt(row,0);
        //if(null!=chkBoxValue && (chkBoxValue.toString().equalsIgnoreCase("true")||chkBoxValue.toString().equalsIgnoreCase("1"))){
        Record rec=(Record)pnlListInvDdk.getDisplayingRecords().get(row);
        if("DISTRIBUTORS".equalsIgnoreCase((String)rec.get(4))){

          setBackground(new java.awt.Color(0xEC, 0xC8, 0xEC)); // Decides the color
          this.repaint();
        }else{
           setBackground(new java.awt.Color(0xFF, 0xFF, 0xFF)); // Decides the color
           this.repaint();
        }
        if(isSelected)setBackground(new java.awt.Color(0xFF, 0xE3, 0x8C));
        if(isSelected)setBackground(new java.awt.Color(0xFF, 0xE3, 0x8C));
        setText(text);
     return this;
    }
    }

  void jbInit() throws Exception {
    titledBorder1 = new TitledBorder(BorderFactory.createEtchedBorder(Color.white,new Color(148, 145, 140)),"Buyers");
    border1 = BorderFactory.createEtchedBorder(Color.white,new Color(148, 145, 140));
    titledBorder2 = new TitledBorder(border1,"Makers");
    border2 = new EtchedBorder(EtchedBorder.RAISED,Color.white,new Color(148, 145, 140));
    txtEtdTo.setBounds(new Rectangle(698, 63, 76, 24));
    txtEtdTo.setText("");
    blueBkgWhiteCharLabel2.setBounds(new Rectangle(519, 33, 67, 24));
    blueBkgWhiteCharLabel2.setText("DEPT.");
    blueBkgWhiteCharLabel1.setBounds(new Rectangle(-2, 0, 801, 26));
    blueBkgWhiteCharLabel1.setText("INVOICE DEDUCT MAINTAIN");
    jLabel3.setHorizontalAlignment(SwingConstants.CENTER);
    jLabel3.setOpaque(true);
    jLabel3.setFont(new java.awt.Font("Dialog", 1, 11));
    jLabel3.setBackground(Color.white);
    jLabel3.setText("TO");
    jLabel3.setBounds(new Rectangle(660, 63, 39, 24));
    txtEtdFrom.setBounds(new Rectangle(585, 63, 76, 24));
    txtEtdFrom.setText("");
    jLabel2.setBounds(new Rectangle(520, 63, 66, 24));
    jLabel2.setText("ETD FROM");
    jLabel2.setHorizontalAlignment(SwingConstants.CENTER);
    jLabel2.setOpaque(true);
    jLabel2.setFont(new java.awt.Font("Dialog", 1, 11));
    jLabel2.setBackground(Color.white);
    this.setLayout(null);
    cbxDep.setBounds(new Rectangle(586, 34, 133, 24));
    slkBuyer.setBounds(new Rectangle(12, 14, 158, 23));
    btnQry.setBounds(new Rectangle(686, 95, 87, 24));
    btnQry.setFont(new java.awt.Font("Dialog", 1, 11));
    btnQry.setText("QUERY");
    btnQry.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnQry_actionPerformed(e);
      }
    });
    jLabel1.setBorder(BorderFactory.createRaisedBevelBorder());
    jLabel1.setBounds(new Rectangle(-2, 125, 798, 10));
    btnUpdate.setBounds(new Rectangle(497, 544, 154, 27));
    btnUpdate.setFont(new java.awt.Font("Dialog", 1, 11));
    btnUpdate.setText("Confirm Update");
    btnUpdate.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnUpdate_actionPerformed(e);
      }
    });
    util.InsertionOrderedHashMap iso=new util.InsertionOrderedHashMap();
    Hashtable ht=new Hashtable();
    iso.put("X","USED");
    iso.put("     INVOICE  ","SHIP_NO");
    iso.put("     FTY INV#     ","SHIP_FTY_INV");
    iso.put("     INV-AMT       ","INV_ANT");
    iso.put("   ETD    ","SHIP_ETD_DATE");
    iso.put("  DEDUCT DATE  ","DDK_DATE");
    iso.put("    NEGO DATE  ","NEGO_DATE");
    iso.put("  PAID TO FTY  ","RCV_DATE");
     ht.put("  DEDUCT DATE  ",exgui.verification.CellFormat.getDateStringFormaterAllowNull());
     ht.put("    NEGO DATE  ",exgui.verification.CellFormat.getDateStringFormaterAllowNull());
     ht.put("  PAID TO FTY  ",exgui.verification.CellFormat.getDateStringFormaterAllowNull());
     Object dateVfy=exgui.verification.CellFormat.getDateStringFormaterAllowNull();
     dbTxtDdk=
         new exgui.DataBindTextWithChecker(txtDdkDate,   "",null,10,
                                           (exgui.Object2String)dateVfy,
                                           (exgui.ultratable.CellTxtEditorFormat)dateVfy);




    pnlListInvDdk=new Panel2List(new TempDb(),99999,iso,ht);
    pnlListInvDdk.setBounds(new Rectangle(2, 145, 789, 392));
    btnExit.setBounds(new Rectangle(660, 544, 71, 28));
    btnExit.setFont(new java.awt.Font("Dialog", 1, 11));
    btnExit.setText("EXIT");
    btnExit.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnExit_actionPerformed(e);
      }
    });
    pnlBuyers.setBorder(titledBorder1);
    pnlBuyers.setBounds(new Rectangle(1, 27, 513, 45));
    pnlBuyers.setLayout(null);
    slkBuyer1.setBounds(new Rectangle(176, 14, 158, 23));
    slkBuyer2.setBounds(new Rectangle(343, 13, 158, 23));
    slkMaker2.setBounds(new Rectangle(343, 13, 158, 23));
    slkMaker1.setBounds(new Rectangle(176, 14, 158, 23));
    slkMaker.setBounds(new Rectangle(12, 14, 158, 23));
    pnlBuyers1.setLayout(null);
    pnlBuyers1.setBounds(new Rectangle(1, 65, 513, 45));
    pnlBuyers1.setBorder(titledBorder2);
    jPanel1.setBorder(border2);
    jPanel1.setToolTipText("");
    jPanel1.setBounds(new Rectangle(10, 540, 404, 35));
    jPanel1.setLayout(null);
    cbxDate.addItem("DEDUCT DATE");
    cbxDate.addItem("NEGO DATE");
     cbxDate.addItem("RCV DATE");
    cbxDate.setSelectedItem("DEDUCT DATE");
    cbxDate.setBounds(new Rectangle(20, 6, 126, 21));
    txtDdkDate.setText("");
    txtDdkDate.setBounds(new Rectangle(150, 6, 74, 21));

    btnBatchUpdateDDK.setBounds(new Rectangle(233, 5, 162, 24));
    btnBatchUpdateDDK.setFont(new java.awt.Font("Dialog", 1, 11));
    btnBatchUpdateDDK.setText("Fill To Selected Rows");
    btnBatchUpdateDDK.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnBatchUpdateDDK_actionPerformed(e);
      }
    });
    byr_grp_box.setBounds(new Rectangle(587, 95, 87, 22));
    byr_grp_box.addItem("");
    byr_grp_box.addItem("QS GROUP");
    byr_grp_box.setSelectedItem("");
    jLabel5.setBackground(new Color(143, 143, 188));
    jLabel5.setFont(new java.awt.Font("Dialog", 1, 11));
    jLabel5.setRequestFocusEnabled(true);
    jLabel5.setToolTipText("");
    jLabel5.setText("BUYER GRP");
    jLabel5.setBounds(new Rectangle(522, 93, 64, 24));
    pnlBuyers1.add(slkMaker, null);
    pnlBuyers1.add(slkMaker1, null);
    pnlBuyers1.add(slkMaker2, null);
    this.add(cbxDep, null);
    this.add(blueBkgWhiteCharLabel2, null);
    this.add(jLabel3, null);
    this.add(jLabel2, null);
    this.add(txtEtdFrom, null);
    this.add(txtEtdTo, null);
    this.add(btnQry, null);
    this.add(jLabel1, null);
    this.add(pnlBuyers, null);
    this.add(pnlListInvDdk, null);
    pnlBuyers.add(slkBuyer, null);
    pnlBuyers.add(slkBuyer1, null);
    pnlBuyers.add(slkBuyer2, null);
    this.add(pnlBuyers1, null);
    this.add(blueBkgWhiteCharLabel1, null);
    jPanel1.add(cbxDate, null);
    jPanel1.add(btnBatchUpdateDDK, null);
    jPanel1.add(txtDdkDate, null);
    this.add(byr_grp_box, null);
    this.add(jLabel5, null);
    this.add(btnExit, null);
    this.add(btnUpdate, null);
    this.add(jPanel1, null);
    pnlListInvDdk.firstPage();

    Object vftxtDate = exgui.verification.CellFormat.getDateStringFormaterAllowNull();

    exgui.DataBindTextWithChecker dbTxtFrom=new exgui.DataBindTextWithChecker(txtEtdFrom, "",
                                        null, 10,
                                        (exgui.Object2String)vftxtDate,
                                        (exgui.ultratable.CellTxtEditorFormat)
                                        vftxtDate);

    exgui.DataBindTextWithChecker dbTxtTo=new exgui.DataBindTextWithChecker(txtEtdTo, "",
                                        null, 10,
                                        (exgui.Object2String)vftxtDate,
                                        (exgui.ultratable.CellTxtEditorFormat)
                                        vftxtDate);
   Vector vctDep=exgui2.CONST.BASIC_MAIN_EJB.getDatas(
      util.PublicVariable.USER_RECORD,
      "select * from department where dep_cen_code='001' and record_delete_flag='1' order by dep_name",
      1,9999);
    dbCbxDep=new exgui.DataBindJCombobox(cbxDep,"",vctDep,"dep_name","dep_code",null,"ALL","ALL");

    slkBuyer.init("",null,slkBuyer.TYPE_BUYER,true);
    slkBuyer1.init("", null, slkBuyer1.TYPE_BUYER, true);
    slkBuyer2.init("", null, slkBuyer2.TYPE_BUYER, true);

    slkMaker.init("", null, slkMaker.TYPE_MAKER, true);
    slkMaker1.init("", null, slkMaker1.TYPE_MAKER, true);
    slkMaker2.init("", null, slkMaker2.TYPE_MAKER, true);

  }
  exgui.DataBindJCombobox dbCbxDep;
  JPanel pnlBuyers = new JPanel();
  TitledBorder titledBorder1;
  SelectBuyerMaker slkBuyer1 = new SelectBuyerMaker();
  SelectBuyerMaker slkBuyer2 = new SelectBuyerMaker();
  SelectBuyerMaker slkMaker2 = new SelectBuyerMaker();
  SelectBuyerMaker slkMaker1 = new SelectBuyerMaker();
  SelectBuyerMaker slkMaker = new SelectBuyerMaker();
  JPanel pnlBuyers1 = new JPanel();
  Border border1;
  TitledBorder titledBorder2;
  JPanel jPanel1 = new JPanel();
  Border border2;
  JTextField txtDdkDate = new JTextField();

  JButton btnBatchUpdateDDK = new JButton();
  JComboBox byr_grp_box = new JComboBox();
  JLabel jLabel5 = new JLabel();
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
     if(txtEtdFrom.getText().trim().length()<10){
       exgui.verification.VerifyLib.showAlert("Please Input Begin ETD DATE","Please Input Begin ETD DATE");
       return;
     }
     if(txtEtdTo.getText().trim().length()<10){
       exgui.verification.VerifyLib.showAlert("Please Input End ETD DATE","Please Input End ETD DATE");
       return;
     }

     pnlListInvDdk.reload();
  }

  void btnBatchUpdateDDK_actionPerformed(ActionEvent e) {
    if(pnlListInvDdk.getJtable().getSelectedRowCount()==0){
      exgui.verification.VerifyLib.showAlert("Please Select Checked Row(s) to Fill Deduct date",
                                             "Please Select Checked Row(s)");
      return;
    }
    int rows[]=pnlListInvDdk.getJtable().getSelectedRows();
    //Object objDate=dbTxtDdk.getSelectedValue();
    String textDate=txtDdkDate.getText().trim();
    for(int i=0;i<rows.length;i++){
      int rowAt=rows[i];
      if (cbxDate.getSelectedItem().equals("DEDUCT DATE")) {
        pnlListInvDdk.getJtable().setValueAt(textDate, rowAt, 5);
      } else {
        pnlListInvDdk.getJtable().setValueAt(textDate, rowAt, 6);
      }
    }
  }
}
