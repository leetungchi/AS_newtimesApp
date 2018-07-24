package newtimes.general_voucher.daily_voucher;

import java.awt.*;
import exgui.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;
import database.datatype.*;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class PnlListDailyVoucher extends JPanel {
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel1 = new BlueBkgWhiteCharLabel();
  Panel2List Pnl2List = null;
  JButton btnExit = new JButton();
  JComboBox paper = new JComboBox(new String[] {"A5","A4"});
  static int INIT_ROW_POS=0;
  public PnlListDailyVoucher() {
    try {
      jbInit();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }

  void jbInit() throws Exception {
    this.setLayout(null);
    blueBkgWhiteCharLabel1.setText("DAILY VOUCHER LIST  (Click To Edit)");
    blueBkgWhiteCharLabel1.setBounds(new Rectangle(-4, 12, 807, 36));
    this.setBackground(new Color(202, 202, 224));
    paper.setBounds(new Rectangle(500, 544, 120, 27));
    btnExit.setBounds(new Rectangle(635, 544, 120, 27));
    btnExit.setFont(new java.awt.Font("Dialog", 1, 11));
    btnExit.setText("EXIT");
    btnExit.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnExit_actionPerformed(e);
      }
    });
    if(Pnl2List==null)generatePnl2List();
    this.add(blueBkgWhiteCharLabel1, null);
    //this.add(btnExit, null);

    this.add(Pnl2List, null);

  }

  void btnExit_actionPerformed(ActionEvent e) {
    try{
       processhandler.template.Properties.getCenteralControler().goBack();
    }catch(Exception exp){
      exp.printStackTrace();
     }
  }
  void generatePnl2List(){
    Object objDateConv=exgui.verification.CellFormat.getDateStringFormaterAllowNull();
    java.util.Hashtable ht=new java.util.Hashtable();
     ht.put("   VOUCHER DATE  ",objDateConv);
    util.InsertionOrderedHashMap iso=new util.InsertionOrderedHashMap();
    iso.put("   VOUCHER NO    ","VH_NO");
    iso.put("   VOUCHER DATE  ","VH_DATE");
    iso.put("    »s³æ¤H     ","vh_create_user");
    iso.put("DETAIL","dots");
    iso.put("  PRINT VH   ","PRINT_VH");
    iso.put("  PRINT TRAVEL  ","PRINT_TVL");
    Pnl2List=new Panel2List(
      new Db2List(),16,iso,ht);
    Pnl2List.setBounds(new Rectangle(14, 61, 760, 487));
    Pnl2List.getJtable().addMouseListener(new MyMouseListener());
    Pnl2List._rowPosition=INIT_ROW_POS;
    Pnl2List.reload();
    Pnl2List.getJtable().setRowHeight(25);
    Pnl2List.getLowerRightPanel().removeAll();
    Pnl2List.getLowerRightPanel().add(btnExit);
    Pnl2List.getLowerRightPanel().add(new JLabel("            "));
    Pnl2List.getLowerRightPanel().add(new JLabel("Paper Form :"));
    Pnl2List.getLowerRightPanel().add(paper);

  }
  class Db2List extends exgui.ultratable.PagedDataFactoryAdapter{

    public Vector getRecords(int bgn,int rowcount)throws Exception{
      StringBuffer sb=new StringBuffer();
      sb.append("select a.*,");
      sb.append("get_vh_create_date(a.vh_no) as vh_create_date,");
      sb.append("get_vh_create_user(a.vh_no) as vh_create_user,");
      sb.append(" '...' as dots  ");
      sb.append(", '...' as print_vh  ");
      sb.append(",(select count(*) from vh_detail x,vh_dtl_tvl b where x.vh_no=a.vh_no and x.GLB_SEQ=b.GLB_SEQ ) as PRINT_TVL ");
      //sb.append(", '...' as print_tvl  ");
      sb.append("from (select  ");
      sb.append(" vh_no,vh_date  ");
      sb.append("from  ");
      sb.append("vh_detail where 1=1 ");
      sb.append(PnlQryDailyVoucher.SB_CONDITOIN_STR.toString());
      sb.append(" group by vh_no,vh_date) a order by a.vh_no");
      System.out.println(sb.toString());
      util.MiscFunc.showProcessingMessage();
       Vector vct=exgui2.CONST.BASIC_MAIN_EJB.getDatas(
        util.PublicVariable.USER_RECORD,
        sb.toString(),bgn,rowcount
        );
       util.MiscFunc.hideProcessingMessage();
        return vct;
    }
  }

 static public void ShowVhReport(String vhNo,boolean isTravel,String form) {
    try {
      //show debit note report,
      com.inet.viewer.ReportViewerBean viewer = util.PublicVariable.
          inet_report_viewer;
      String rpt_name;
      if ( form == "A5") {
         rpt_name = (!isTravel) ? "ACC_DB_CR.rpt" : "ACC_TRV.rpt";
      }
      else
      {
           rpt_name = (!isTravel) ? "ACC_DB_CR_A4.rpt" : "ACC_TRV_A4.rpt";
      }
      java.util.HashMap hm = new java.util.HashMap();
      hm.put("P_VH_NO",vhNo );
      String tempURL= newtimes.production.report.ReportProxyEngine.reportServerURL ;
      newtimes.production.report.ReportProxyEngine.reportServerURL="http://rpt2.nttpe.com.tw:9000/?file:///rpt//";
      newtimes.production.report.ReportCmdSet.myReportEngin.
          setReportNameAndParas(viewer, rpt_name, hm);
      viewer.setHasGroupTree(false);
      //viewer.setReportData(newtimes.production.report.ReportCmdSet.myReportEngin);
      viewer.start();
      JPanel pnl = new JPanel();
      pnl.setLayout(new java.awt.BorderLayout());
      pnl.add(viewer);
      String rptTitle=((!isTravel)?"Geneneral Voucher":"Travel Detail");
      newtimes.preproduction.guis.DlgViewRpt dlg = new newtimes.preproduction.
          guis.DlgViewRpt(
          processhandler.template.Properties.getMainFrame(),
          rptTitle,
          pnl, true);
      dlg.setSize(700, 500);
      dlg.show();
      newtimes.production.report.ReportProxyEngine.reportServerURL=tempURL;

    } catch (Exception exp) {
      exp.printStackTrace();

    }

  }

  class MyMouseListener extends java.awt.event.MouseAdapter{
    public void mouseClicked(java.awt.event.MouseEvent me){
      INIT_ROW_POS=Pnl2List._rowPosition;
      int col=Pnl2List.getJtable().getSelectedColumn();
      Record rec=(Record)Pnl2List.getDisplayingRecords().get(Pnl2List.getJtable().getSelectedRow());
      String vhNo=(String)rec.get(0);

      if(col==4){ShowVhReport(vhNo,false,paper.getSelectedItem().toString()); return;}
      if(col==5){
        try{
          if (rec.getInt("PRINT_TVL") > 0) {
            ShowVhReport(vhNo, true,paper.getSelectedItem().toString());
            return;
          }
        }catch(Exception exp){
          exp.printStackTrace();
        }
      }
      if(col!=3)return;
      java.util.Date vhDate=(java.util.Date)rec.get(1);
      TgrEditDailyVoucher.INIT_DATE=vhDate;
      TgrEditDailyVoucher.INIT_VH_NO=vhNo;
      TgrEditDailyVoucher tgr=new TgrEditDailyVoucher();
      try{
         if(Constants.VCT_STAFF==null)Constants.initStaffVector();
         processhandler.template.Properties.getCenteralControler().doCommandExecute(tgr);
      }catch(Exception exp){
        exp.printStackTrace();
       }
    }
  }

  class Panel2List extends processhandler.template.PnlTableEditor{
    public Panel2List(exgui.ultratable.PagedDataFactory pagedDataFxy,
                      int rowCounts,util.InsertionOrderedHashMap columnMapping,
                     java.util.Hashtable object2StringConvertor){
        super(pagedDataFxy, rowCounts, columnMapping, object2StringConvertor);
    }
    public void doPrint(){}
    public int getEachPageRowCount(){return _rowCounts;}
    public Hashtable getObject2StringConvertor() {return klmObjKvtHt;}
    public util.InsertionOrderedHashMap getHeadColumnMap(){return tblHeadColumn;}
    public exgui.ultratable.PagedDataFactory getPagedDataFactory(){return dbHandler;}
    public Record setObject2Record(Record rec,int col,Object obj){return null;}
    public void refineEditors(exgui.ultratable.MultiEditorJTable me ){
      CellRender cellrdr=new CellRender();
      CellRender4Tvl cellrdr4Tvl=new CellRender4Tvl();
      this.getJtable().getColumnModel().getColumn(3).setCellRenderer(cellrdr);
      this.getJtable().getColumnModel().getColumn(4).setCellRenderer(cellrdr);
      this.getJtable().getColumnModel().getColumn(5).setCellRenderer(cellrdr4Tvl);
    }
  }
  class CellRender4Tvl extends JLabel
      implements javax.swing.table.TableCellRenderer{
      public CellRender4Tvl(){
      super();
     setBorder(javax.swing.BorderFactory.createRaisedBevelBorder());
     setOpaque(true); /* it\u00B4s essential */
     setHorizontalAlignment(JLabel.CENTER);
  }
   public Component getTableCellRendererComponent(
         javax.swing.JTable table, Object value,
         boolean isSelected, boolean hasFocus,
         int row, int column){
        String text = (value.toString().equals("0"))?"":"...";
        if(text.trim().equals("")){
          setBackground(new java.awt.Color(0xFF, 0xFF, 0xFF)); // Decides the color
        }else{
            setBackground(new java.awt.Color(0xE0, 0xE0, 0xE0)); // Decides the color
        }
        setText(text);
     return this;
    }
  }

  class CellRender extends JLabel
      implements javax.swing.table.TableCellRenderer{
      public CellRender(){
      super();
     setBorder(javax.swing.BorderFactory.createRaisedBevelBorder());
     setOpaque(true); /* it\u00B4s essential */
     setHorizontalAlignment(JLabel.CENTER);
  }
   public Component getTableCellRendererComponent(
         javax.swing.JTable table, Object value,
         boolean isSelected, boolean hasFocus,
         int row, int column){
        String text = (value==null)?"":value.toString();
        if(text.trim().equals("")){
          setBackground(new java.awt.Color(0xFF, 0xFF, 0xFF)); // Decides the color
        }else{
            setBackground(new java.awt.Color(0xE0, 0xE0, 0xE0)); // Decides the color
        }
        setText(text);
     return this;
    }
  }
}
