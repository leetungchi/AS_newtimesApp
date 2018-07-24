package newtimes.nthk_enqry;

import java.awt.*;
import exgui.*;
import javax.swing.*;
import javax.swing.border.*;
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

public class PnlItemDtl extends JPanel {
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel1 = new BlueBkgWhiteCharLabel();
  JLabel jLabel2 = new JLabel();
  JLabel jLabel1 = new JLabel();
  JLabel jLabel3 = new JLabel();
  JLabel jLabel6 = new JLabel();
  JLabel lblBuyer = new JLabel();
  JLabel jLabel10 = new JLabel();
  JLabel lblScPaymentTerm = new JLabel();
  JLabel lblScPriceTerm = new JLabel();
  JLabel jLabel11 = new JLabel();
  JLabel jLabel12 = new JLabel();
  JLabel lblMaker = new JLabel();
  JLabel lblPoPaymentTerm = new JLabel();
  JPanel PnlPlaceSrnDtl = new JPanel();
  TitledBorder titledBorder1;
  TitledBorder titledBorder2;
  JButton btnExit = new JButton();
  JButton btnMainMenu = new JButton();
  Record recCurrentStyle=null;
  JLabel jLabel14 = new JLabel();
  BorderLayout borderLayout1 = new BorderLayout();
  int ship_no_column_at;
  JLabel jLabel15 = new JLabel();
  JLabel jLabel4 = new JLabel();
  JLabel lblScNo = new JLabel();
  boolean isOnlyForPopOut=false;
  javax.swing.JDialog dlg2Contain;
  JPanel pnlUpdateCheck = new JPanel();
  JLabel lblOffshoreCenter = new JLabel();
  JLabel jLabel7 = new JLabel();
  JLabel jLabel5 = new JLabel();
  Border border1;
  JLabel lblFinalInspectionDate = new JLabel();
  public PnlItemDtl() {
    try {
      jbInit();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }
  void initByRecord(Record rec,javax.swing.JDialog _dlg2contain)throws Exception{
    initByRecord(rec);
    dlg2Contain=_dlg2contain;
    btnMainMenu.setVisible(false);
  }
  void initByRecord(Record rec)throws Exception{
    recCurrentStyle=rec;
    String scNo=(String)rec.get("Sc_no");
    lblScNo.setText((scNo==null)?"":scNo);
    /*
    Object objSty=rec.get("sty_style");
    Object objStyPo=rec.get("sty_po");
    lblStyStyle.setText((objSty==null)?"":objSty.toString());
    lblStyPo.setText((objStyPo==null)?"":objStyPo.toString());
    */
    Object objBuyerName=rec.get("j_buyer");
    lblBuyer.setText((objBuyerName==null)?"":objBuyerName.toString());
    Object objMakerName=rec.get("j_maker");
    lblMaker.setText((objMakerName==null)?"":objMakerName.toString());
    /*
    Object objOrgDlv=rec.get("sty_org_del");
    lblOrgDlv.setText((objOrgDlv==null)?"":objOrgDlv.toString());
    Object objReviceDlv=rec.get("sty_rvc_del");
    lblReconfirmDate.setText((objReviceDlv==null)?"":objReviceDlv.toString());
    Object objShipMode=rec.get("ship_mode");
    lblShipMode.setText((objShipMode==null)?"":objShipMode.toString());
    */
    lblPoPaymentTerm.setText((String)rec.get("PROD_CT_PYT_TRM"));

    lblScPaymentTerm.setText((String)rec.get("PROD_PYT_TRM"));//PRODUCTION_PYT_TRM
    lblScPriceTerm.setText((String)rec.get("PROD_SC_PRC_TRM"));
    //lblPoPriceTerm.setText((String)rec.get("STY_CT_PRC_TRM"));
    DB_ItemDtl dbObj=new DB_ItemDtl(recCurrentStyle.getInt(0),scNo);
    //exgui.ultratable.PagedDataFactory  dbObj=new TestHandler(scNo,recCurrentStyle.getInt(0));
    util.InsertionOrderedHashMap iso=new util.InsertionOrderedHashMap();
      iso=new util.InsertionOrderedHashMap();
      iso.put("   STYLE   ","sty_style"); //0
      iso.put("   PO   ","sty_PO"); //1
      iso.put("Buyer\nComm","final_buyer_comm");//2
      iso.put("Maker\nDiscount","final_maker_disc");//3
      iso.put("   COLOR   ","prod_color_name"); //4
      iso.put("Order\nQty","order_qty"); //5
      //4 price columns
      iso.put("Doc.","pri_byr_doc_prx");//buyer price group //6
      iso.put("Act.","pri_byr_act_prx");//7
      iso.put(" Doc.","pri_mkr_doc_prx");//maker price group//8
      iso.put(" Act.","pri_mkr_act_prx");//9
      //buyer comm and maker discount

      //SRN & etd-date &ship-qty
      ship_no_column_at=iso.entrySet().size();
      iso.put("      SRN      ","ship_no");//shipping group //10
      iso.put("ETD DATE","etd_date");//11
      iso.put("SHIP\nQTY","ship_qty");//12
      if(!"NTHK".equals(util.PublicVariable.OPERATTING_CENTER)){
        iso.put("BALANCE\nQTY","BALANCE_QTY");// none nthk ,needs to show balanace qty
      }
      iso.put("Create\nUser","ship_create_user");//13
      iso.put("Create\nDate","ship_create_date");//14
    PnlListColorDetailOfStyle pnl2ShowDtl=
        new PnlListColorDetailOfStyle(dbObj,99999,iso,null);
     pnl2ShowDtl.setPreferredSize(new Dimension(762,330));
     pnl2ShowDtl.setSize(760,330);
     PnlPlaceSrnDtl.removeAll();
     PnlPlaceSrnDtl.add(pnl2ShowDtl);
     pnl2ShowDtl.firstPage();
     getOffshoreCenter(rec.getInt(0));
  }
  class PnlListColorDetailOfStyle extends exgui.ultratable.AbstractUltraTablePanel{
    MyRenderer myder=new MyRenderer();
    public PnlListColorDetailOfStyle(exgui.ultratable.PagedDataFactory pgdb,
                                     int rowcount,
                                     util.InsertionOrderedHashMap isoMap,
                                     java.util.Hashtable obj2conv
                                     ){
        super(pgdb,rowcount,isoMap,obj2conv);
        try{
        super.doInit();
        }catch(Exception epx){
          epx.printStackTrace();
          util.ExceptionLog.exp2File(epx,"");
        }
        getPanelContainsButtons().removeAll();
    }
    public int getEachPageRowCount(){return 99999;}
    public exgui.ultratable.PagedDataFactory getPagedDataFactory(){return dbHandler;}
    public java.util.Hashtable getObject2StringConvertor() {
      java.util.Hashtable ht=new java.util.Hashtable();
      ht.put("ship_create_date",exgui.verification.CellFormat.getDateStringFormaterAllowNull());
      return ht;
    }
    public util.InsertionOrderedHashMap getHeadColumnMap(){return tblHeadColumn;}
    public database.datatype.Record setObject2Record(database.datatype.Record rec,int col,Object obj){return null;}
    public void refineEditors(exgui.ultratable.MultiEditorJTable  meTBL){
       meTBL.setTableColumn2Grp("Buyer Price",6);
       meTBL.setTableColumn2Grp("Buyer Price",7);
       meTBL.setTableColumn2Grp("Maker Price",8);
       meTBL.setTableColumn2Grp("Maker Price",9);
       ((exgui.MultiClassTableModel)meTBL.getJTable().getModel()).removeAllEditableColumn();
    }
    double getValueFromRec(Record rec,String fieldName)throws Exception{
      Object value=rec.get(fieldName);
      if(value==null)return 0;
      if(value.toString().trim().length()==0)return 0;
      return Double.parseDouble(value.toString());
    }
    public  void makeTable(java.util.Vector vct){
       //if not nthk center,add the balance column

       if(!"NTHK".equals(util.PublicVariable.OPERATTING_CENTER)){
         java.util.Vector vctResult=new java.util.Vector();
         String lastColor="ooYourXX";
         double totalShipQty=0;
         double totalOrderQty=0;
         int i=0;
         try {
           for(;i<vct.size();i++){
             Record recXnt = (Record)util.MiscFunc.deepCopy(vct.get(i));
             //System.out.println("rec data is ==>"+recXnt.toString());
             recXnt.getFieldName().add("BALANCE_QTY");
             recXnt.getValueFields().add(null);
             String xntColor = (String)recXnt.get("prod_color_name");
             if (xntColor == null || xntColor.trim().length() == 0) {
               //xntColor = lastColor;
               totalShipQty += getValueFromRec(recXnt,"ship_qty");//recXnt.getDouble("ship_qty");
             } else {
               //if (i == 0 || (!xntColor.equals(lastColor))) {
                 if (i > 0) {
                   ((Record)vctResult.get(i - 1)).set("BALANCE_QTY",totalOrderQty - totalShipQty);
                 }
                 lastColor = xntColor;
                 totalShipQty =getValueFromRec(recXnt,"ship_qty"); //recXnt.getDouble("ship_qty");
                 totalOrderQty = getValueFromRec(recXnt,"order_qty");//recXnt.getDouble("order_qty");
             }
             vctResult.add(recXnt);
           }
           ((Record)vctResult.get(i - 1)).set("BALANCE_QTY",totalOrderQty - totalShipQty);
         }catch(Exception exp){
            exp.printStackTrace();
         }

         super.makeTable(vctResult);
       }else{
         super.makeTable(vct);
       }


       getJtable().getColumnModel().getColumn(ship_no_column_at).setCellRenderer(myder);
       getJtable().getColumnModel().getColumn(5).setPreferredWidth(65); //order qty
       getJtable().getColumnModel().getColumn(6).setPreferredWidth(45); //buyr doc prx
       getJtable().getColumnModel().getColumn(7).setPreferredWidth(45); //buyr doc prx
       getJtable().getColumnModel().getColumn(8).setPreferredWidth(45); //buyr doc prx
       getJtable().getColumnModel().getColumn(9).setPreferredWidth(45); //buyr doc prx

    }
    public class MyRenderer extends JLabel
        implements javax.swing.table.TableCellRenderer{
        public MyRenderer(){
        super();
       setOpaque(true); /* it\u00B4s essential */
    }
     public Component getTableCellRendererComponent(
           javax.swing.JTable table, Object value,
           boolean isSelected, boolean hasFocus,
           int row, int column){
            String text = (value==null)?"":value.toString();
         try{
           Record rec = (Record)getDisplayingRecords().get(row);
           if (rec.get("IS_PRICE_DIFF") != null) {

             setBackground(new java.awt.Color(255, 160, 160));
           }else{
             if(isSelected){
               setBackground(new java.awt.Color(0xFF, 0xE3, 0x8C));
             }else{
               setBackground(new java.awt.Color(255, 255, 255));
             }
           }
           setText(text); /* Put the current text in the JLabel */
         }catch(Exception exp){
           exp.printStackTrace();
         }
       return this;
      }
    }

  }
  void jbInit() throws Exception {
    titledBorder1 = new TitledBorder("");
    titledBorder2 = new TitledBorder("");
    border1 = new EtchedBorder(EtchedBorder.RAISED,Color.white,new Color(141, 141, 156));
    blueBkgWhiteCharLabel1.setText("Item Details( PO Details Query )");
    blueBkgWhiteCharLabel1.setBounds(new Rectangle(0, 0, 800, 30));
    this.setBackground(new Color(202, 202, 224));
    this.setLayout(null);
    jLabel2.setBounds(new Rectangle(224, 50, 359, 20));
    jLabel2.setText("ERP Systems (General Enquiry)");
    jLabel2.setHorizontalAlignment(SwingConstants.CENTER);
    jLabel1.setHorizontalAlignment(SwingConstants.CENTER);
    jLabel1.setText("Newtimes Group Of Companies");
    jLabel1.setBounds(new Rectangle(224, 34, 359, 20));
    jLabel3.setBounds(new Rectangle(223, 70, 359, 20));
    jLabel3.setText("PO Details Enquiry");
    jLabel3.setHorizontalAlignment(SwingConstants.CENTER);
    jLabel6.setBounds(new Rectangle(26, 114, 82, 20));
    jLabel6.setText("Buyer :");
    lblBuyer.setBounds(new Rectangle(97, 114, 202, 20));
    lblBuyer.setText("");
    jLabel10.setText("S/C Payment Term :");
    jLabel10.setBounds(new Rectangle(309, 113, 109, 20));
    lblScPaymentTerm.setText("");
    lblScPaymentTerm.setBounds(new Rectangle(423, 113, 120, 20));
    lblScPriceTerm.setBounds(new Rectangle(422, 136, 120, 20));
    lblScPriceTerm.setText("");
    jLabel11.setBounds(new Rectangle(309, 136, 109, 20));
    jLabel11.setText("S/C Price Term :");
    jLabel12.setBounds(new Rectangle(548, 111, 82, 20));
    if("NTHK".equals(util.PublicVariable.OPERATTING_CENTER)){
      jLabel12.setText("Maker   :");
    }else{
      jLabel12.setText("Vendor  :");
    }

    lblMaker.setBounds(new Rectangle(631, 111, 154, 20));
    lblMaker.setText("");
    lblPoPaymentTerm.setBounds(new Rectangle(667, 134, 120, 20));
    lblPoPaymentTerm.setText("");
    PnlPlaceSrnDtl.setBackground(new Color(202, 202, 224));
    PnlPlaceSrnDtl.setBorder(titledBorder2);
    PnlPlaceSrnDtl.setBounds(new Rectangle(23, 202, 760, 330));
    PnlPlaceSrnDtl.setLayout(borderLayout1);
    btnExit.setBounds(new Rectangle(550, 533, 80, 30));
    btnExit.setFont(new java.awt.Font("Dialog", 1, 11));
    btnExit.setText("EXIT");
    btnExit.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnExit_actionPerformed(e);
      }
    });
    btnMainMenu.setBounds(new Rectangle(671, 533, 107, 30));
    btnMainMenu.setFont(new java.awt.Font("Dialog", 1, 11));
    btnMainMenu.setText("Main Menu");
    btnMainMenu.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnMainMenu_actionPerformed(e);
      }
    });
    jLabel14.setBounds(new Rectangle(548, 134, 109, 20));
    jLabel14.setText("PO Payment Term :");
    jLabel15.setFont(new java.awt.Font("Dialog", 1, 11));
    jLabel15.setText("<html><body>* If BackGround Color Of SRN Cell Is Pink<br>Means Ship " +
    "Price Is Different From Order Price</body></html>");
    jLabel15.setBounds(new Rectangle(505, 156, 292, 34));
    jLabel4.setFont(new java.awt.Font("Dialog", 1, 11));
    jLabel4.setText("S/C#:");
    jLabel4.setBounds(new Rectangle(25, 84, 44, 23));
    lblScNo.setBounds(new Rectangle(75, 84, 187, 23));
    pnlUpdateCheck.setBackground(new Color(202, 202, 228));
    pnlUpdateCheck.setBounds(new Rectangle(23, 134, 285, 61));
    pnlUpdateCheck.setLayout(null);
    pnlUpdateCheck.setBackground(new Color(202, 202, 224));
    pnlUpdateCheck.setBorder(border1);
    pnlUpdateCheck.setBounds(new Rectangle(27, 134, 264, 61));
    pnlUpdateCheck.setLayout(null);
    lblOffshoreCenter.setFont(new java.awt.Font("Dialog", 0, 11));
    lblOffshoreCenter.setText("ThaiLand");
    lblOffshoreCenter.setBounds(new Rectangle(94, 34, 80, 22));
    jLabel7.setFont(new java.awt.Font("Dialog", 0, 11));
    jLabel7.setRequestFocusEnabled(true);
    jLabel7.setText("Offshore Center:");
    jLabel7.setBounds(new Rectangle(6, 34, 89, 23));
    jLabel5.setToolTipText("");
    jLabel5.setText("Final Inspection Date:");
    jLabel5.setBounds(new Rectangle(9, 5, 130, 23));
    lblOffshoreCenter.setBounds(new Rectangle(98, 37, 80, 22));
    jLabel7.setText("Offshore Center:");
    jLabel7.setBounds(new Rectangle(9, 39, 107, 20));
    jLabel5.setText("Final Inspection Date:");
    jLabel5.setBounds(new Rectangle(9, 5, 130, 20));
    lblFinalInspectionDate.setText("2009/09/21");
    lblFinalInspectionDate.setBounds(new Rectangle(141, 5, 103, 20));
    this.add(blueBkgWhiteCharLabel1, null);
    this.add(jLabel1, null);
    this.add(jLabel3, null);
    this.add(jLabel2, null);
    this.add(lblBuyer, null);
    this.add(PnlPlaceSrnDtl, null);
    this.add(jLabel6, null);
    this.add(jLabel14, null);
    this.add(jLabel12, null);
    this.add(lblMaker, null);
    this.add(lblPoPaymentTerm, null);
    this.add(jLabel11, null);
    this.add(jLabel10, null);
    this.add(lblScPaymentTerm, null);
    this.add(lblScPriceTerm, null);
    this.add(jLabel15, null);
    this.add(jLabel4, null);
    this.add(lblScNo, null);
    this.add(btnExit, null);
    this.add(btnMainMenu, null);
    this.add(pnlUpdateCheck, null);
    pnlUpdateCheck.add(jLabel5, null);
    pnlUpdateCheck.add(jLabel7, null);
    pnlUpdateCheck.add(lblOffshoreCenter, null);
    pnlUpdateCheck.add(lblFinalInspectionDate, null);
  }

  void  getOffshoreCenter(int prodPk){
     try{
       StringBuffer sb=new StringBuffer();
       sb.append("select ");
       sb.append("a.prod_head_pk  ");
       sb.append(",get_offshore_center(a.prod_buyer,a.prod_maker,prodXN.PROD_QC_CNTY,a.PROD_OFFSHORE_CENTER) as offshoreCenter ");
       sb.append(",C.CEN_NAME ");
       sb.append(",(select FINAL_INSPEC_DATE from po_offshore_status where sc_No=prodxn.prod_sc_no) as fnl_inps_date ");
       sb.append(",(select record_create_date from po_offshore_status where sc_No=prodxn.prod_sc_no) as fnl_inps_create_date ");
       sb.append("from prod_head a,production prodxn,center c ");
       sb.append("where a.prod_head_pk=prodxn.prod_head_pk ");
       sb.append("and C.CEN_CODE=get_offshore_center(a.prod_buyer,a.prod_maker,prodXN.PROD_QC_CNTY,a.PROD_OFFSHORE_CENTER) ");
       sb.append("and a.prod_head_pk=");sb.append(String.valueOf(prodPk));
       java.util.Vector vct=exgui2.CONST.BASIC_MAIN_EJB.getDatas(
       util.PublicVariable.USER_RECORD,sb.toString(),1,999999);
       database.datatype.Record rec=(database.datatype.Record)vct.get(0);
       String offshroeCenter=(String)rec.get(2);
       if((rec.get(3)==null)){
         pnlUpdateCheck.setVisible(false);
         return;
       }
       lblOffshoreCenter.setText((offshroeCenter==null)?"":offshroeCenter);
       java.text.DateFormat df=new java.text.SimpleDateFormat ("yyyy/MM/dd");
       lblFinalInspectionDate.setText(((rec.get(3)==null)?"":df.format(rec.get(3))));
       //lblInpxnCreateDate.setText(df.format(rec.get(4)));
       /*
       Object dateVfy=exgui.verification.CellFormat.getDateStringFormaterAllowNull();
       DataBindTextWithChecker dbTxtFinalInsepcDate=new exgui.DataBindTextWithChecker(txtFnlInspDate,
                                   "",
                                   rec.get(3) ,
                                   10,
                                   (exgui.Object2String) dateVfy,
                                   (exgui.ultratable.CellTxtEditorFormat) dateVfy);
        */

     }catch(Exception exp){
       exp.printStackTrace();
       util.ExceptionLog.exp2File(exp,"");
       exgui.verification.VerifyLib.showAlert("Error While Retreiving Offshore Center","Error While Retreiving Offshore Center");

     }
  }

  void btnMainMenu_actionPerformed(ActionEvent e) {
    try{
      processhandler.template.Properties.getCenteralControler().doCommandExecute(
      new newtimes.preproduction.process.TgrShowFuncList());

      //processhandler.template.Properties.getCenteralControler().goBack();
    }catch(Exception ie){
      ie.printStackTrace();
    }

  }

  void btnExit_actionPerformed(ActionEvent e) {
    if(dlg2Contain!=null){
      dlg2Contain.dispose();
      return;
    }

    try{
      processhandler.template.Properties.getCenteralControler().goBack();
      //processhandler.template.Properties.getCenteralControler().goBack();
    }catch(Exception ie){
      ie.printStackTrace();
    }

  }
}
