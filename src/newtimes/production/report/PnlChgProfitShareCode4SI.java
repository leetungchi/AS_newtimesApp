package newtimes.production.report;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import newtimes.preproduction.buyermakerselect.*;
import exgui.*;
import java.util.HashMap;
import java.util.Vector;
import exgui.ultratable.PagedDataFactory;
import database.datatype.Record;
import exgui.ultratable.MultiEditorJTable;
import java.awt.event.*;
/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class PnlChgProfitShareCode4SI extends JPanel {
  Component component1;
  Component component2;
  JLabel lblSplit = new JLabel();
  Border border1;
  JLabel lblDep = new JLabel();
  JComboBox cbxDep = new JComboBox();
  SelectBuyerMaker slkMaker = new SelectBuyerMaker();
  JLabel jLabel1 = new JLabel();
  JLabel lblProfitShareCode = new JLabel();
  JTextField txtPftShrCode = new JTextField();
  JButton btnQry = new JButton();
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel1 = new BlueBkgWhiteCharLabel();
  JPanel PnlCtnSI = new JPanel();
  BorderLayout borderLayout1 = new BorderLayout();
  JButton btnExit=null;
  JButton btnUpdate=null;
  JLabel lblShipETD = new JLabel();
  JTextField txtEtdFrom = new JTextField();
  JTextField txtEtdTo = new JTextField();
  JLabel lblShipETD2 = new JLabel();
  exgui.DataBindJCombobox dbCbxDep,dbCbxCen;
  exgui.DataBindTextWithChecker dbTxtShipEtdFrom,dbTxtShipEtdTo;
  exgui.DataBindTextWithChecker dbTxtProfitShareCode;
  boolean isInit=true;
  PnlList4SI pnlList4Qry=null;
  JLabel lblDep1 = new JLabel();
  JComboBox cbxCenter = new JComboBox();
  public PnlChgProfitShareCode4SI() {
    try {
      jbInit();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }

  void jbInit() throws Exception {
    component1 = Box.createHorizontalStrut(8);
    component2 = Box.createHorizontalStrut(8);
    border1 = new EtchedBorder(EtchedBorder.RAISED,Color.white,new Color(148, 145, 140));
    lblSplit.setBorder(border1);
    lblSplit.setText("");
    lblSplit.setBounds(new Rectangle(0, 135, 799, 11));
    this.setLayout(null);
    lblDep.setText("DEP.");
    lblDep.setBounds(new Rectangle(7, 55, 78, 22));
    cbxDep.setBounds(new Rectangle(43, 55, 151, 21));
    slkMaker.setBounds(new Rectangle(265, 55, 162, 21));
    jLabel1.setText("Maker:");
    jLabel1.setBounds(new Rectangle(215, 55, 77, 20));
    lblProfitShareCode.setText("Profit Share Code :");
    lblProfitShareCode.setBounds(new Rectangle(10, 93, 106, 22));
    txtPftShrCode.setText("");
    txtPftShrCode.setBounds(new Rectangle(130, 95, 96, 20));
    btnQry.setBounds(new Rectangle(629, 102, 119, 27));
    btnQry.setFont(new java.awt.Font("Dialog", 1, 11));
    btnQry.setText("Query");
    btnQry.addActionListener(new PnlChgProfitShareCode4SI_btnQry_actionAdapter(this));
    blueBkgWhiteCharLabel1.setText("Query & Modify Profit Share Code For S / I");
    blueBkgWhiteCharLabel1.setBounds(new Rectangle(-1, 10, 800, 25));
    PnlCtnSI.setBounds(new Rectangle(7, 165, 775, 390));
    PnlCtnSI.setLayout(borderLayout1);
    lblShipETD.setText("ETD FROM :");
    lblShipETD.setBounds(new Rectangle(245, 96, 73, 21));
    txtEtdFrom.setText("");
    txtEtdFrom.setBounds(new Rectangle(310, 96, 79, 22));
    txtEtdTo.setBounds(new Rectangle(464, 96, 79, 22));
    txtEtdTo.setText("");
    lblShipETD2.setBounds(new Rectangle(411, 97, 58, 21));
    lblShipETD2.setText("ETD TO :");
    lblDep1.setBounds(new Rectangle(437, 55, 99, 22));
    lblDep1.setText("Offshore Center");
    cbxCenter.setBounds(new Rectangle(527, 55, 151, 21));
    this.add(lblSplit, null);
    this.add(lblProfitShareCode, null);
    this.add(txtPftShrCode, null);
    this.add(blueBkgWhiteCharLabel1, null);
    this.add(PnlCtnSI, null);
    this.add(btnQry, null);
    this.add(txtEtdFrom, null);
    this.add(txtEtdTo, null);
    this.add(lblShipETD, null);
    this.add(lblShipETD2, null);
    this.add(lblDep, null);
    this.add(cbxDep, null);
    this.add(jLabel1, null);
    this.add(slkMaker, null);
    this.add(cbxCenter, null);
    this.add(lblDep1, null);
    btnExit=new JButton("EXIT");
    btnUpdate=new JButton("Confirm Update");
    btnAdpt ActListen=new btnAdpt();
    btnExit.addMouseListener(ActListen);
    btnUpdate.addMouseListener(ActListen);
    initFieldObj();
    isInit=true;
    btnQry_actionPerformed(null);
    isInit=false;
  }
  protected void initFieldObj()throws Exception{
    slkMaker.init("",null,slkMaker.TYPE_MAKER,true);
    dbCbxDep= new exgui.DataBindJCombobox(
              cbxDep,
              "DEP",
              newtimes.preproduction.guis.tempProperties.tmpDepartment,
              "DEP_NAME", "DEP_CODE",
              null,
              "ALL", null);

          dbCbxCen= new exgui.DataBindJCombobox(
                    cbxCenter,
                    "CEN",
                    newtimes.preproduction.guis.tempProperties.tmpOffShores,
                    "CEN_NAME", "CEN_CODE",
                    null,
                    "ALL", null);

    Object dateVfy = exgui.verification.CellFormat.getDateStringFormaterAllowNull();
    dbTxtShipEtdFrom  =
        new exgui.DataBindTextWithChecker(txtEtdFrom , "DEL_BE", null,
                                          10, (exgui.Object2String)dateVfy,
                                          (exgui.ultratable.
                                           CellTxtEditorFormat)dateVfy);

    dbTxtShipEtdTo =
        new exgui.DataBindTextWithChecker(txtEtdTo, "DEL_EN", null,
                                          10, (exgui.Object2String)dateVfy,
                                          (exgui.ultratable.
                                           CellTxtEditorFormat)dateVfy);

    Object prefitShareCodeVfy = exgui.verification.CellFormat.getOrdinaryField(1);
    dbTxtProfitShareCode =
        new exgui.DataBindTextWithChecker(txtPftShrCode, "DEL_EN", null,1,
                                          (exgui.Object2String)prefitShareCodeVfy,
                                          (exgui.ultratable.CellTxtEditorFormat)prefitShareCodeVfy);


  }
  class btnAdpt extends java.awt.event.MouseAdapter{
    public void mouseClicked(java.awt.event.MouseEvent me){
      if(me.getSource()==btnExit){
        try{
          processhandler.template.Properties.getCenteralControler().goBack();
        }catch(Exception exp){
          exp.printStackTrace();
        }
      }
      if(me.getSource()==btnUpdate){
        if(pnlList4Qry!=null){
          try{
            pnlList4Qry.confirmUpdate();
            exgui.verification.VerifyLib.showPlanMsg("Update OK","UPdate OK");
          }catch(Exception exp){
            exp.printStackTrace();
          }
        }
      }
    }
  }
  class PnlList4SI extends exgui.ultratable.AbstractUltraTablePanel{
    PnlList4SI(PagedDataFactory pagedDataFxy,
        int rowlength,util.InsertionOrderedHashMap columnMapping,
        java.util.Hashtable object2StringConvertor
    ){
      super(pagedDataFxy,99999,columnMapping,object2StringConvertor);
      getLowerRightPanel().removeAll();
      jbtn1st.setVisible(false);
      jbtnLast.setVisible(false);
      jbtnPrev.setVisible(false);
      jbtnNext.setVisible(false);
      getLowerRightPanel().add(btnExit);
      getLowerRightPanel().add(btnUpdate);
    }
    protected  void refineEditors(MultiEditorJTable multiEditorJTableInSuper){
      multiEditorJTableInSuper.setTextEditorVerifiers(getObject2StringConvertor());
    }
    protected Record setObject2Record(Record rec,int columnAt,Object value2update){
      try{
        rec.set(storedRecordColumn[columnAt],value2update);
        return rec;
      }catch(Exception exp){
        exp.printStackTrace();
        return null;
      }
    }
    protected PagedDataFactory getPagedDataFactory(){
      return dbHandler;
    }
    protected util.InsertionOrderedHashMap getHeadColumnMap(){
      return tblHeadColumn;
    }
    protected java.util.Hashtable getObject2StringConvertor(){
         return klmObjKvtHt;
    }
    protected int getEachPageRowCount(){return 99999;}

  }
  class DbHanlderForChgPftShareCode extends exgui.ultratable.PagedDataFactoryAdapter {
    public void updateRecords(Vector vct2update)throws Exception{

      newtimesejb.TPE_MIS.TpeMisFuncHome ejbHome=
         (newtimesejb.TPE_MIS.TpeMisFuncHome)
         info_ejb.WeblogicServiceLocator.locateServiceHome(util.PublicVariable.SERVER_URL,
                                                           "newtimesejb.TPE_MIS.TpeMisFunc");
      newtimesejb.TPE_MIS.TpeMisFunc ejb=ejbHome.create();
      ejb.updateShipSiProfitShareCode(vct2update,
                                      (String)util.PublicVariable.USER_RECORD.get(0));
    }
    public Vector getRecords(int bgn,int rowncount)throws Exception{
      if(isInit)return new Vector();
     try{
       util.MiscFunc.showProcessingMessage();
       StringBuffer sb = new StringBuffer();
       sb.append("select a.ship_sc_pk,a.SHIP_NO,a.PROFIT_SHARE,b.PROD_HEAD_PK,c.prod_sc_no,to_char(d.ship_etd_date,'YYYY/MM/DD') as etd_date ");
       sb.append(",ct.cen_name as off_share_center_name ");
       sb.append("from ship_sc a,prod_head b,production c,shipping d ,center ct ");
       sb.append("where 1=1  ");
       sb.append("and b.prod_cen_code='001' ");
       sb.append("and ct.cen_code=b.PROD_OFFSHORE_CENTER ");
       sb.append("and a.PROD_HEAD_PK=b.prod_head_pk ");
       sb.append("and b.prod_head_pk=c.prod_head_pk ");
       sb.append("and d.ship_no=a.ship_no ");
       sb.append("and d.ship_status='Y' ");
       if (txtPftShrCode.getText().trim().length() > 0) {
         sb.append("and a.PROFIT_SHARE='");
         sb.append(util.MiscFunc.Replace(txtPftShrCode.getText().trim(), "'",
                                         "''"));
         sb.append("' ");
       }

       if (txtEtdFrom.getText().length() == 10) {
         sb.append("and d.ship_etd_date >= to_date('");
         sb.append(txtEtdFrom.getText().trim());
         sb.append("','YYYY/MM/DD') ");
       }
       if (txtEtdTo.getText().length() == 10) {
         sb.append("and d.ship_etd_date <= to_date('");
         sb.append(txtEtdTo.getText().trim());
         sb.append("','YYYY/MM/DD') ");
       }
       if (slkMaker.getSelectedValue() != null) {
         sb.append("and b.PROD_MAKER=");
         sb.append(slkMaker.getSelectedValue().toString());
         sb.append(" ");
       }
       if (dbCbxDep.getSelectedValue() != null) {
         sb.append("and b.PROD_DEPTMENT='");
         sb.append(dbCbxDep.getSelectedValue());
         sb.append("' ");
       }
       if(dbCbxCen.getSelectedValue()!=null){
         sb.append("and b.PROD_OFFSHORE_CENTER='");
         sb.append(dbCbxCen.getSelectedValue());
         sb.append("'");
       }
       sb.append("and a.record_delete_flag='1' ");
       sb.append("and c.record_delete_flag='1' ");
       sb.append("and a.ship_no like 'ZATW%' ");
       sb.append("order by substr(a.ship_no ,7,6) ");
       Vector vct =
           exgui2.CONST.BASIC_MAIN_EJB.getDatas(
           util.PublicVariable.USER_RECORD,
           sb.toString(), 1, 99999);
       return vct;
     }catch(Exception exp){
        throw exp;
     }finally{
       util.MiscFunc.hideProcessingMessage();
     }
    }
  }

  void btnQry_actionPerformed(ActionEvent e) {
    util.InsertionOrderedHashMap iso=new util.InsertionOrderedHashMap();
    iso.put("profit\nShare","PROFIT_SHARE");
    iso.put("       SRN       ","SHIP_NO");
    iso.put("       S/C      ","PROD_SC_NO");
    iso.put("       ETD      ","etd_date");
    iso.put("Offshore \nCenter ","off_share_center_name");
    java.util.Hashtable ht=new java.util.Hashtable();
    Object objPrfShar=exgui.verification.CellFormat.getOrdinaryField(1);
    ht.put("profit\nShare",objPrfShar);
    pnlList4Qry=
        new PnlList4SI(new DbHanlderForChgPftShareCode(),999,iso,ht);
    pnlList4Qry.setPreferredSize(new java.awt.Dimension(775,390));
    PnlCtnSI.removeAll();
    PnlCtnSI.add(java.awt.BorderLayout.CENTER,pnlList4Qry);
    pnlList4Qry.firstPage();
    PnlCtnSI.validate();
    PnlCtnSI.repaint();
  }
}

class PnlChgProfitShareCode4SI_btnQry_actionAdapter implements java.awt.event.ActionListener {
  PnlChgProfitShareCode4SI adaptee;

  PnlChgProfitShareCode4SI_btnQry_actionAdapter(PnlChgProfitShareCode4SI adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.btnQry_actionPerformed(e);
  }
}
