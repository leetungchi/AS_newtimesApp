package newtimes.vsd_upload;

import java.awt.*;
import javax.swing.*;
import database.datatype.Record;
import VsdCsvObject.*;
import javax.swing.border.*;
import exgui.*;
import java.awt.event.*;
/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class DlgCmpPoDtl extends JDialog {
  JPanel panel1 = new JPanel();
  VsdUpload uploadHandler;
  Record recPoDetail;
  JButton btnOverWrite = new JButton();
  JButton btnSkip = new JButton();
  JPanel pnlERP = new JPanel();
  TitledBorder titledBorder1;
  TitledBorder titledBorder2;
  Border border1;
  TitledBorder titledBorder3;
  WhiteBkgBlueCharLabel lblDelDate4ERP = new WhiteBkgBlueCharLabel();
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel1 = new BlueBkgWhiteCharLabel();
  WhiteBkgBlueCharLabel lblMkrDel4ERP = new WhiteBkgBlueCharLabel();
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel2 = new BlueBkgWhiteCharLabel();
  WhiteBkgBlueCharLabel lblShipMode4ERP = new WhiteBkgBlueCharLabel();
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel3 = new BlueBkgWhiteCharLabel();
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel4 = new BlueBkgWhiteCharLabel();
  WhiteBkgBlueCharLabel lblUpRemark4ERP = new WhiteBkgBlueCharLabel();
  JScrollPane jScrollPane1 = new JScrollPane();
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel5 = new BlueBkgWhiteCharLabel();
  JScrollPane jScrollPane2 = new JScrollPane();
  WhiteBkgBlueCharLabel lblDelDate4VSD = new WhiteBkgBlueCharLabel();
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel6 = new BlueBkgWhiteCharLabel();
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel7 = new BlueBkgWhiteCharLabel();
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel8 = new BlueBkgWhiteCharLabel();
  WhiteBkgBlueCharLabel lblShipMode4VSD = new WhiteBkgBlueCharLabel();
  WhiteBkgBlueCharLabel lblUpRemark4VSD = new WhiteBkgBlueCharLabel();
  WhiteBkgBlueCharLabel lblMkrDel4VSD = new WhiteBkgBlueCharLabel();
  JPanel pnlVSD = new JPanel();
  Border border2;
  TitledBorder titledBorder4;
  java.text.DateFormat df=new java.text.SimpleDateFormat("yyyy/MM/dd");
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel9 = new BlueBkgWhiteCharLabel();
  WhiteBkgBlueCharLabel lblScIsu4ERP = new WhiteBkgBlueCharLabel();
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel10 = new BlueBkgWhiteCharLabel();
  WhiteBkgBlueCharLabel lblCtIsu4ERP = new WhiteBkgBlueCharLabel();
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel11 = new BlueBkgWhiteCharLabel();
  WhiteBkgBlueCharLabel lblScIsu4VSD = new WhiteBkgBlueCharLabel();
  WhiteBkgBlueCharLabel lblCtIsu4VSD = new WhiteBkgBlueCharLabel();
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel12 = new BlueBkgWhiteCharLabel();
  public DlgCmpPoDtl(Frame frame, String title, boolean modal,
                     VsdUpload _uploadHandler,
                     Record _recPoDtl) {
    super(frame, title, modal);
    try {
      uploadHandler=_uploadHandler;
      recPoDetail=_recPoDtl;
      jbInit();
      showDiff();
      pack();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }

  public DlgCmpPoDtl() {
    this(null, "", false,null,null);
  }

  void showDiff()throws Exception{
    /*
    sbSql.append("a.sty_seq,a.sty_style ");
    sbSql.append(",a.sty_po,a.sty_orig_del ");
    sbSql.append(",a.sty_mkr_del,a.sty_orig_way ");
    sbSql.append(",(select SHIP_MODE_NAME from ship_modes where ship_mode_code=a.sty_orig_way ) as ship_mode ");
    sbSql.append(",a.STY_SC_UP_RMRK ");
    sbSql.append(",B.PROD_BYR_SC_ISSUE as sc_issue ");
    sbSql.append(",D.PROD_CT_ISSU as ct_issue ");
    sbSql.append(",a.record_create_date ");
    sbSql.append(",(select count(*) from ship_style ss where SS.STY_SEQ=a.sty_seq and ss.record_delete_flag='1' ) as ship_count ");
    sbSql.append("from style a ,production b,prod_head c,prod_ct_infor d  ");
    */
     VsdCsvObject.LineNoObj lineObj=uploadHandler.xntPrcVsdObjLineObj;
      //lineObj.issueDate_25
      //lineObj.shipDate_1
      //lineObj.shipModeName_22
      //lineObj.styUpRemark_10
      //lineObj.issueDate_25
      //==================for ERP current data=================================
      Object eprCtIsu=recPoDetail.get("ct_issue");
      lblCtIsu4ERP.setText((eprCtIsu==null)?"":df.format(eprCtIsu));
      Object eprScIsu=recPoDetail.get("sc_issue");
      lblScIsu4ERP.setText((eprScIsu==null)?"":df.format(eprScIsu));
      Object eprDel=recPoDetail.get("sty_orig_del");
      lblDelDate4ERP.setText((eprDel==null)?"":df.format(eprDel));
      Object eprMkrDel=recPoDetail.get("sty_mkr_del");
      lblMkrDel4ERP.setText((eprMkrDel==null)?"":df.format(eprMkrDel));
      Object eprShipMode=recPoDetail.get("ship_mode");
      lblShipMode4ERP.setText((eprShipMode==null)?"":eprShipMode.toString());
      Object erpUpRemark=recPoDetail.get("STY_SC_UP_RMRK");
      lblUpRemark4ERP.setText((erpUpRemark==null)?"":erpUpRemark.toString());

     //===========================for vsd data==============================
     lblCtIsu4VSD.setText((lineObj.issueDate_25==null)?"":df.format(lineObj.issueDate_25));
     lblScIsu4VSD.setText((lineObj.issueDate_25==null)?"":df.format(lineObj.issueDate_25));
     lblDelDate4VSD.setText((lineObj.shipDate_1==null)?"":df.format(lineObj.shipDate_1));
     lblMkrDel4VSD.setText((lineObj.shipDate_1==null)?"":df.format(lineObj.shipDate_1));
     lblShipMode4VSD.setText((lineObj.shipModeName_22==null)?"":lineObj.shipModeName_22.toUpperCase());
     lblUpRemark4VSD.setText((lineObj.styUpRemark_10==null)?"":lineObj.styUpRemark_10.toUpperCase());






  }
  private void jbInit() throws Exception {
    titledBorder1 = new TitledBorder("");
    titledBorder2 = new TitledBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED,Color.white,Color.white,new Color(103, 101, 98),new Color(148, 145, 140)),"CURRENT DATA IN ERP Create Date:"+df.format(recPoDetail.get("record_create_date")));
    border1 = BorderFactory.createBevelBorder(BevelBorder.LOWERED,Color.white,Color.white,new Color(103, 101, 98),new Color(148, 145, 140));
    titledBorder3 = new TitledBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED,Color.white,Color.white,new Color(103, 101, 98),new Color(148, 145, 140)),"CURRENT DATA IN SVD CSV FILE");
    border2 = BorderFactory.createBevelBorder(BevelBorder.LOWERED,Color.white,Color.white,new Color(103, 101, 98),new Color(148, 145, 140));
    titledBorder4 = new TitledBorder(border2,"CURRENT DATA IN VSD CSV,Create Date:"+df.format(uploadHandler.xntPrcVsdObjLineObj.createDate_24));
    panel1.setLayout(null);
    btnOverWrite.setBounds(new Rectangle(174, 450, 111, 31));
    btnOverWrite.setFont(new java.awt.Font("Dialog", 1, 11));
    btnOverWrite.setText("OVER WRITE");
    btnOverWrite.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnOverWrite_actionPerformed(e);
      }
    });
    btnSkip.setText("SKIP");
    btnSkip.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnSkip_actionPerformed(e);
      }
    });
    btnSkip.setFont(new java.awt.Font("Dialog", 1, 11));
    btnSkip.setForeground(Color.red);
    btnSkip.setBounds(new Rectangle(423, 450, 111, 31));
    pnlERP.setBorder(titledBorder2);
    pnlERP.setBounds(new Rectangle(11, 7, 740, 219));
    pnlERP.setLayout(null);
    lblDelDate4ERP.setText("");
    lblDelDate4ERP.setBounds(new Rectangle(82, 16, 75, 27));
    blueBkgWhiteCharLabel1.setText("DEL DATE");
    blueBkgWhiteCharLabel1.setBounds(new Rectangle(9, 16, 73, 27));
    lblMkrDel4ERP.setBounds(new Rectangle(274, 16, 75, 27));
    lblMkrDel4ERP.setText("whiteBkgBlueCharLabel1");
    lblMkrDel4ERP.setText("");
    blueBkgWhiteCharLabel2.setBounds(new Rectangle(165, 16, 108, 27));
    blueBkgWhiteCharLabel2.setText("MAKER DEL DATE");
    lblShipMode4ERP.setText("");
    lblShipMode4ERP.setText("");
    lblShipMode4ERP.setBounds(new Rectangle(445, 16, 117, 27));
    blueBkgWhiteCharLabel3.setText("SHIP MODE");
    blueBkgWhiteCharLabel3.setBounds(new Rectangle(353, 16, 92, 27));
    blueBkgWhiteCharLabel4.setBounds(new Rectangle(9, 51, 92, 27));
    blueBkgWhiteCharLabel4.setText("UP REMARK");
    lblUpRemark4ERP.setBounds(new Rectangle(102, 51, 463, 27));
    lblUpRemark4ERP.setText("");
    lblUpRemark4ERP.setHorizontalAlignment(SwingConstants.LEFT);
    lblUpRemark4ERP.setText("");
    //jScrollPane1.setBounds(new Rectangle(11, 90, 720, 119));
    blueBkgWhiteCharLabel5.setBounds(new Rectangle(344, 16, 92, 27));
    blueBkgWhiteCharLabel5.setText("SHIP MODE");
    jScrollPane2.setBounds(new Rectangle(11, 90, 715, 119));
    lblDelDate4VSD.setText("2009/12/31");
    lblDelDate4VSD.setBounds(new Rectangle(82, 16, 72, 27));
    blueBkgWhiteCharLabel6.setText("DEL DATE");
    blueBkgWhiteCharLabel6.setBounds(new Rectangle(9, 16, 73, 27));
    blueBkgWhiteCharLabel7.setBounds(new Rectangle(158, 16, 108, 27));
    blueBkgWhiteCharLabel7.setText("MAKER DEL DATE");
    blueBkgWhiteCharLabel8.setBounds(new Rectangle(9, 51, 92, 27));
    blueBkgWhiteCharLabel8.setText("UP REMARK");
    lblShipMode4VSD.setText("");
    lblShipMode4VSD.setText("");
    lblShipMode4VSD.setBounds(new Rectangle(436, 16, 117, 27));
    lblUpRemark4VSD.setBounds(new Rectangle(102, 51, 452, 27));
    lblUpRemark4VSD.setText("");
    lblUpRemark4VSD.setHorizontalAlignment(SwingConstants.LEFT);
    lblUpRemark4VSD.setText("");
    lblMkrDel4VSD.setBounds(new Rectangle(267, 16, 72, 27));
    lblMkrDel4VSD.setText("whiteBkgBlueCharLabel1");
    lblMkrDel4VSD.setText("");
    pnlVSD.setBorder(titledBorder4);
    pnlVSD.setBounds(new Rectangle(13, 228, 737, 219));
    pnlVSD.setLayout(null);
    blueBkgWhiteCharLabel9.setBounds(new Rectangle(568, 16, 75, 27));
    blueBkgWhiteCharLabel9.setText("S/C ISSUE:");
    lblScIsu4ERP.setBounds(new Rectangle(643, 16, 75, 27));
    lblScIsu4ERP.setText("");
    lblScIsu4ERP.setText("");
    blueBkgWhiteCharLabel10.setText("C/T ISSUE:");
    blueBkgWhiteCharLabel10.setBounds(new Rectangle(568, 51, 75, 27));
    lblCtIsu4ERP.setText("");
    lblCtIsu4ERP.setText("");
    lblCtIsu4ERP.setBounds(new Rectangle(643, 51, 75, 27));
    blueBkgWhiteCharLabel11.setText("S/C ISSUE:");
    blueBkgWhiteCharLabel11.setBounds(new Rectangle(570, 15, 75, 27));
    lblScIsu4VSD.setText("");
    lblScIsu4VSD.setText("");
    lblScIsu4VSD.setBounds(new Rectangle(645, 15, 72, 27));
    lblCtIsu4VSD.setBounds(new Rectangle(645, 50, 72, 27));
    lblCtIsu4VSD.setText("");
    lblCtIsu4VSD.setText("");
    blueBkgWhiteCharLabel12.setBounds(new Rectangle(570, 50, 75, 27));
    blueBkgWhiteCharLabel12.setText("C/T ISSUE:");
    getContentPane().add(panel1);
    panel1.add(pnlERP, null);
    pnlERP.add(blueBkgWhiteCharLabel1, null);
    pnlERP.add(lblDelDate4ERP, null);
    pnlERP.add(blueBkgWhiteCharLabel4, null);
    pnlERP.add(lblUpRemark4ERP, null);
    pnlERP.add(blueBkgWhiteCharLabel3, null);
    pnlERP.add(lblShipMode4ERP, null);
    pnlERP.add(blueBkgWhiteCharLabel2, null);
    pnlERP.add(lblMkrDel4ERP, null);
    pnlERP.add(blueBkgWhiteCharLabel9, null);
    pnlERP.add(blueBkgWhiteCharLabel10, null);
    pnlERP.add(lblCtIsu4ERP, null);
    pnlERP.add(lblScIsu4ERP, null);
    pnlVSD.add(blueBkgWhiteCharLabel6, null);
    pnlVSD.add(lblDelDate4VSD, null);
    pnlVSD.add(blueBkgWhiteCharLabel8, null);
    pnlVSD.add(lblUpRemark4VSD, null);
    panel1.add(pnlVSD, null);
    pnlVSD.add(blueBkgWhiteCharLabel7, null);
    pnlVSD.add(lblMkrDel4VSD, null);
    pnlVSD.add(blueBkgWhiteCharLabel5, null);
    pnlVSD.add(lblShipMode4VSD, null);
    pnlVSD.add(blueBkgWhiteCharLabel12, null);
    pnlVSD.add(blueBkgWhiteCharLabel11, null);
    pnlVSD.add(lblScIsu4VSD, null);
    pnlVSD.add(lblCtIsu4VSD, null);
    panel1.add(btnOverWrite, null);
    panel1.add(btnSkip, null);
    getERP_Qty();
    getVSD_Qty();
  }

  void btnOverWrite_actionPerformed(ActionEvent e) {
     uploadHandler.is2OverWrite=true;
     this.dispose();
  }

  void btnSkip_actionPerformed(ActionEvent e) {
    uploadHandler.is2OverWrite=false;
    this.dispose();
  }
  void getVSD_Qty()throws Exception{
    String szClm=(String)uploadHandler.xntPrcVsdObj.sizeCammaString;
    if(szClm==null)szClm="TOTAL";
    String clmArr[]=util.MiscFunc.split(szClm,",,");
    util.InsertionOrderedHashMap iso=new util.InsertionOrderedHashMap();
    iso.put("COLOR\nCODE","COLOR_CODE");
    iso.put("COLOR\nNAME","COLOR_NAME");
    for(int i=0;i<clmArr.length;i++){
      iso.put(clmArr[i],"QTY_"+String.valueOf(i+1));
    }
    PnlListQty pnlQty=
        new PnlListQty(
          new BrfQty4Vsd(),9999,iso,new java.util.Hashtable());
     //jScrollPane2.setBounds(new Rectangle(11, 90, 715, 119));
     pnlQty.setBounds(new Rectangle(11, 90, 715, 119));
     pnlQty.disableAllPageButtons();
     pnlVSD.add(pnlQty,null);
  }


  void getERP_Qty()throws Exception{
    String szClm=(String)recPoDetail.get("sty_size_column");
    if(szClm==null)szClm="TOTAL";
    String clmArr[]=util.MiscFunc.split(szClm,",,");
    util.InsertionOrderedHashMap iso=new util.InsertionOrderedHashMap();
    iso.put("COLOR\nCODE","COLOR_CODE");
    iso.put("COLOR\nNAME","COLOR_NAME");
    for(int i=0;i<clmArr.length;i++){
      iso.put(clmArr[i],"QTY_"+String.valueOf(i+1));
    }
    PnlListQty pnlQty=
        new PnlListQty(
          new BrfQtyDb4Erp(recPoDetail.getInt("sty_seq")),9999,iso,new java.util.Hashtable());
     //jScrollPane1.setBounds(new Rectangle(11, 90, 720, 119));
     pnlQty.setBounds(new Rectangle(11, 90, 720, 119));
     pnlQty.disableAllPageButtons();
     pnlERP.add(pnlQty,null);
  }
  class PnlListQty extends processhandler.template.PnlTableEditor  {
    PnlListQty(exgui.ultratable.PagedDataFactory pagedDataFxy,
      int rowCounts,util.InsertionOrderedHashMap columnMapping,
      java.util.Hashtable object2StringConvertor){
        super(pagedDataFxy,rowCounts,columnMapping,object2StringConvertor);
        getPanelContainsButtons().removeAll();
        firstPage();
    }


    protected  void refineEditors(exgui.ultratable.MultiEditorJTable multiEditorJTableInSuper){
    }
    public void doPrint(){}
    protected Record setObject2Record(Record rec,int columnAt,Object value2update){
        return rec;
    }
    protected exgui.ultratable.PagedDataFactory getPagedDataFactory(){return dbHandler;}
    protected util.InsertionOrderedHashMap getHeadColumnMap(){
       return tblHeadColumn;
    }
    protected java.util.Hashtable getObject2StringConvertor(){
      return klmObjKvtHt;
    }
    protected int getEachPageRowCount(){return 999;}
  }


  /*
  class MyPnl extends exgui.ultratable.PagedTablePanel{
    MyPnl( exgui.ultratable.PagedDataFactory pagedDataFxy,
       int rowlength,util.InsertionOrderedHashMap columnMapping,
       java.util.Hashtable object2StringConvertor
    ){
      super(pagedDataFxy,rowlength,columnMapping,object2StringConvertor);
    }
  }
  */
  class BrfQty4Vsd extends exgui.ultratable.PagedDataFactoryAdapter{
   public java.util.Vector getRecords(int bgn,int rowcount){
     return uploadHandler.xntPrcVsdObj.vctBrfQty;
   }
  }
  class BrfQtyDb4Erp extends exgui.ultratable.PagedDataFactoryAdapter{
    int styseq;
    BrfQtyDb4Erp(int _stySeq){
      styseq=_stySeq;
    }
    public java.util.Vector getRecords(int bgn,int rowcount)throws Exception{
       StringBuffer sb=new StringBuffer();
       sb.append("select * from brief_qty where sty_pk=");
       sb.append(String.valueOf(styseq));
       sb.append(" and record_delete_flag='1' ");
       sb.append(" order by brf_qty_pk");
       return exgui2.CONST.BASIC_MAIN_EJB.getDatas(
         util.PublicVariable.USER_RECORD,
         sb.toString(),1,99999);
    }
  }
}
