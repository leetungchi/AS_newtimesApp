package newtimes.general_voucher.F107;

import java.awt.*;
import exgui.*;
import javax.swing.*;
import exgui.ultratable.*;
import java.util.*;
import database.datatype.Record;
import java.awt.event.*;
/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class PnlF107Gen_Mtn extends JPanel {
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel1 = new BlueBkgWhiteCharLabel();
  WhiteBkgBlueCharLabel whiteBkgBlueCharLabel1 = new WhiteBkgBlueCharLabel();
  JTextField txtYYYYMM = new JTextField();
  JButton btnGenerate = new JButton();
  JButton btnQry = new JButton();
  JButton btnExit = new JButton();
  //JPanel pnl2List = new JPanel();
  Vector vct2Process;
  Panel2List pnl2List=null;
  boolean isInitPnl2List=false;
  JButton btnRpt = new JButton();
  JButton btnDel = new JButton();
  public PnlF107Gen_Mtn() {
    try {
      jbInit();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }

  void jbInit() throws Exception {
    blueBkgWhiteCharLabel1.setFont(new java.awt.Font("Dialog", 1, 16));
    blueBkgWhiteCharLabel1.setText("美金台幣毛利維護功能");
    blueBkgWhiteCharLabel1.setBounds(new Rectangle(0, 8, 807, 24));
    this.setLayout(null);
    whiteBkgBlueCharLabel1.setForeground(Color.blue);
    whiteBkgBlueCharLabel1.setText("ETD YYYYMM");
    whiteBkgBlueCharLabel1.setBounds(new Rectangle(3, 38, 88, 24));
    txtYYYYMM.setText("");
    txtYYYYMM.setBounds(new Rectangle(91, 38, 73, 24));
    btnGenerate.setBounds(new Rectangle(327, 38, 202, 24));
    btnGenerate.setFont(new java.awt.Font("Dialog", 1, 12));
    btnGenerate.setForeground(Color.red);
    btnGenerate.setText("GENERATE AND OVER WRITE");
    btnGenerate.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnGenerate_actionPerformed(e);
      }
    });
    btnQry.setBounds(new Rectangle(175, 38, 143, 24));
    btnQry.setFont(new java.awt.Font("Dialog", 1, 12));
    btnQry.setText("Query To Maintain");
    btnQry.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnQry_actionPerformed(e);
      }
    });
    btnExit.setBounds(new Rectangle(708, 38, 87, 24));
    btnExit.setFont(new java.awt.Font("Dialog", 1, 12));
    btnExit.setText("EXIT");
    btnExit.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnExit_actionPerformed(e);
      }
    });
    //pnl2List.setBackground(new Color(202, 202, 224));
    //pnl2List.setBounds(new Rectangle(14, 74, 761, 486));
    this.setBackground(new Color(202, 202, 224));
    btnRpt.setBounds(new Rectangle(619, 38, 82, 24));
    btnRpt.setFont(new java.awt.Font("Dialog", 1, 11));
    btnRpt.setText("REPORT");
    btnRpt.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnRpt_actionPerformed(e);
      }
    });
    btnDel.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnDel_actionPerformed(e);
      }
    });
    btnDel.setText("DELETE");
    btnDel.setFont(new java.awt.Font("Dialog", 1, 11));
    btnDel.setForeground(Color.red);
    btnDel.setBounds(new Rectangle(533, 38, 82, 24));
    this.add(blueBkgWhiteCharLabel1, null);
    this.add(whiteBkgBlueCharLabel1, null);
    this.add(txtYYYYMM, null);
    this.add(btnQry, null);
    this.add(btnGenerate, null);
    this.add(btnExit, null);
    this.add(btnRpt, null);
    this.add(btnDel, null);
    //this.add(pnl2List, null);
    Object objyyyymmVfy=exgui.verification.CellFormat.getIntVerifierAllowNull(6);
    exgui.DataBindTextWithChecker dbTxtYYYYMM4Recover= new exgui.DataBindTextWithChecker(txtYYYYMM,
                             "P_YYYYMM",
                             "", 6,
                             (exgui.Object2String)objyyyymmVfy,
                             (exgui.ultratable.CellTxtEditorFormat)objyyyymmVfy);

  }
  class Panel2List extends processhandler.template.PnlTableEditor {
  public Panel2List(exgui.ultratable.PagedDataFactory pagedDataFxy,
                    int rowCounts,util.InsertionOrderedHashMap columnMapping,
                   java.util.Hashtable object2StringConvertor){
      super(pagedDataFxy, rowCounts, columnMapping, object2StringConvertor);
      jbtnPrev.setVisible(false);
      jbtnNext.setVisible(false);
      jbtnLast.setVisible(false);
      jbtn1st.setVisible(false);
      getLowerRightPanel().removeAll();
      JButton btnUpdate=new JButton("Update");
      getLowerRightPanel().add(btnUpdate);
      isInitPnl2List=true;
      btnUpdate.addMouseListener(new java.awt.event.MouseAdapter() {
         public void mouseClicked(java.awt.event.MouseEvent e) {
           try{
             pnl2List.doUpdate();
            }catch(Exception exp){
               exp.printStackTrace();
               exgui.verification.VerifyLib.showAlert("Update Failed!!\nPlease Contact System Manager","Update Failed!!");
           }
          }
       });
       isInitPnl2List=false;
  }
  public void makeTable(Vector vct){
    super.makeTable(vct);
    getJtable().setRowHeight(20);
   getJtable().setFont(new java.awt.Font("Dialog",java.awt.Font.PLAIN, 14));
   getJtable().getColumnModel().getColumn(2).setPreferredWidth(105);//maker name
   getJtable().getColumnModel().getColumn(3).setPreferredWidth(105);//maker name
   getJtable().getColumnModel().getColumn(4).setPreferredWidth(35);//dep
   getJtable().getColumnModel().getColumn(14).setPreferredWidth(102);//maker-commm
   getJtable().getColumnModel().getColumn(8).setPreferredWidth(80);//out-cost

  }
  public void doPrint(){}
  public int getEachPageRowCount(){return _rowCounts;}
  public Hashtable getObject2StringConvertor() {return klmObjKvtHt;}
  public util.InsertionOrderedHashMap getHeadColumnMap(){return tblHeadColumn;}
  public exgui.ultratable.PagedDataFactory getPagedDataFactory(){return dbHandler;}
  public Record setObject2Record(Record rec,int col,Object obj){
     try{
       rec.set(storedRecordColumn[col],obj);
       return rec;
     }catch(Exception exp){
       exp.printStackTrace();
       return null;
     }
  }
  public void refineEditors(exgui.ultratable.MultiEditorJTable me ){
    CellRenderAmt descColumnRdr=new CellRenderAmt();
    for(int i=5;i<14;i++) this.getJtable().getColumnModel().getColumn(i).setCellRenderer(descColumnRdr);
    this.getJtable().getColumnModel().getColumn(16).setCellRenderer(descColumnRdr);
    this.getJtable().getColumnModel().getColumn(18).setCellRenderer(descColumnRdr);
    this.getJtable().getColumnModel().getColumn(20).setCellRenderer(descColumnRdr);
    me.setTextEditorVerifiers(getObject2StringConvertor());
  }
 }
  class TempDb extends exgui.ultratable.PagedDataFactoryAdapter{
     public void updateRecords(Vector vct2update)throws Exception{
       if(isInitPnl2List)return;
       if(vct2update==null || vct2update.size()==0){
         exgui.verification.VerifyLib.showPlanMsg("nothing to update","nothing to update");
         return;
       }
       util.MiscFunc.showProcessingMessage();
       newtimesejb.dailyVoucher.DailyVoucherFacadeHome ejbHome=
           (newtimesejb.dailyVoucher.DailyVoucherFacadeHome)
           info_ejb.WeblogicServiceLocator.locateServiceHome(util.PublicVariable.SERVER_URL,
           "newtimesejb.dailyVoucher.DailyVoucherFacade");

       newtimesejb.dailyVoucher.DailyVoucherFacade ejb=ejbHome.create();
       ejb.udpateUsdTwdProfit(vct2update,util.PublicVariable.USER_RECORD.get(0).toString());
       pnl2List.reload();
       util.MiscFunc.hideProcessingMessage();

    }
    public Vector getRecords(int row,int count)throws Exception{
      return vct2Process;
    }
  }

  void btnGenerate_actionPerformed(ActionEvent e) {
    try{
      if(!exgui.verification.VerifyLib.showConfirm("This Process will over write existing USD/TWD profit data of that month",
                                                   "Are You Sure?",false)){
        return;
      }
      if(txtYYYYMM.getText().trim().length()!=6){
        exgui.verification.VerifyLib.showAlert("Please Check YYYYMM","Please Check YYYYMM");
        return;
      }
      String yyyymm=txtYYYYMM.getText().trim();
      if(Integer.parseInt(yyyymm.substring(4,6))>12 ||Integer.parseInt(yyyymm.substring(4,6))<1){
        exgui.verification.VerifyLib.showAlert("Please Check YYYYMM","Please Check YYYYMM");
        return;
      }
      util.MiscFunc.showProcessingMessage();
      newtimesejb.dailyVoucher.DailyVoucherFacadeHome ejbHome=
          (newtimesejb.dailyVoucher.DailyVoucherFacadeHome)
          info_ejb.WeblogicServiceLocator.locateServiceHome(util.PublicVariable.SERVER_URL,
          "newtimesejb.dailyVoucher.DailyVoucherFacade");

      newtimesejb.dailyVoucher.DailyVoucherFacade ejb=ejbHome.create();
      ejb.F107ToUsdTwdProfit(txtYYYYMM.getText(),util.PublicVariable.USER_RECORD.get(0).toString());
      exgui.verification.VerifyLib.showPlanMsg("Generate Ok","Generate Ok");
      util.MiscFunc.hideProcessingMessage();

    }catch(Exception exp){
      exgui.verification.VerifyLib.showAlert("Process Failed,Please Contatct System Manager",
                                             "Process Failed");
      exp.printStackTrace();
      util.ExceptionLog.exp2File(exp,"");
    }
  }

  void btnExit_actionPerformed(ActionEvent e) {
    try{
      processhandler.template.Properties.getCenteralControler().goBack();
    }catch(Exception exp){
      exp.printStackTrace();
    }

  }
  class CellRenderAmt extends JLabel implements javax.swing.table.TableCellRenderer{
      java.text.NumberFormat nf=new java.text.DecimalFormat("##########.##");
     public CellRenderAmt(){
     super();
     this.setFont(new java.awt.Font("Dialog",java.awt.Font.PLAIN, 14));
    //setBorder(javax.swing.BorderFactory.createRaisedBevelBorder());
    setOpaque(true); /* it\u00B4s essential */
    setHorizontalAlignment(super.RIGHT);
 }
  public Component getTableCellRendererComponent(
        javax.swing.JTable table, Object value,
        boolean isSelected, boolean hasFocus,
        int row, int column){
        String text = (value==null)?"":value.toString();
       setBackground(new java.awt.Color(0xFF, 0xFF, 0xFF)); // Decides the color
       if(isSelected)setBackground(new java.awt.Color(0xFF, 0xE3, 0x8C));
       if(!text.equals("") && column!=0){
         text=nf.format(Double.parseDouble(text));
       }
       setText(text);
    return this;
   }
 }

  void btnQry_actionPerformed(ActionEvent e) {
    try{
      if(txtYYYYMM.getText().trim().length()!=6){
        exgui.verification.VerifyLib.showAlert("Please Check YYYYMM","Please Check YYYYMM");
        return;
      }
      String yyyymm=txtYYYYMM.getText().trim();
      if(Integer.parseInt(yyyymm.substring(4,6))>12 ||Integer.parseInt(yyyymm.substring(4,6))<1){
        exgui.verification.VerifyLib.showAlert("Please Check YYYYMM","Please Check YYYYMM");
        return;
      }

      util.MiscFunc.showProcessingMessage();
      StringBuffer sb=new StringBuffer();
      sb.append("select a.*,substr(ship_no,5,8) as inv_no,to_char(ship_etd_date,'yyyy/mm/dd') as etd_date  from usdtwd_profit a where to_char(a.ship_etd_date,'yyyymm')='");
      sb.append(yyyymm);
      sb.append("' order by inv_no");
      System.out.println(sb.toString());
      Vector vct=exgui2.CONST.BASIC_MAIN_EJB.getDatas(util.PublicVariable.USER_RECORD ,sb.toString(),1,99999);
      vct2Process=new Vector();
      //have to adjust dbcr$ amt value
      for(int i=0;i<vct.size();i++){
        Record rec=(Record)vct.get(i);
        Object objLastDbcr =rec.get(7);
        for(int j=9;j<14;j+=2){
          System.out.println(" j is "+j);
          Object objNewDbcr=rec.get(j);
          if(util.MiscFunc.isEqual(objLastDbcr,objNewDbcr)){
            rec.set(j,null);
            rec.set(j+1,null);
          }else{
            objLastDbcr=objNewDbcr;
          }
        }
        rec.getModifiedFields().clear();
        vct2Process.add(rec);
      }
      if(pnl2List!=null){
        this.remove(pnl2List);
      }
      util.InsertionOrderedHashMap iso=new util.InsertionOrderedHashMap();
      iso.put("  INV  ","INV_NO");//0
      iso.put("ETD-DATE","ETD_DATE");//1
      iso.put("BUYER\nNAME","BUYER_BRIEF");//2
      iso.put("MAKER\nNAME","MAKER_BRIEF");//3
      iso.put("DEP","DEP_ABBR");//4
      iso.put("IN-SALES","IN_SALES");//5
      iso.put("IN-LABOR","IN_LABOR");//6
      iso.put("IN-COMM","IN_COMM");//7

      iso.put("OUT-COST","OUT_COST");//8
      iso.put("OUT-FRT","OUT_FRT");//9
      iso.put("OUT-INS","OUT_INS");//10

      iso.put("MAKER-COMM","maker_discount_total");//11

      iso.put("DIFF-AMT","total_diff");//12<--
      iso.put("M-LABOR","M_LABOR");//13
      iso.put("M-COMM","M_COMM");//14
      //---------------------------------------
      iso.put("   DB# 1  ","DBCRNO_1");//15
      iso.put("AMT    ","DBCRAMT_1");//16/

      iso.put("   DB# 2  ","DBCRNO_2");//17
      iso.put(" AMT   ","DBCRAMT_2");//18

      iso.put("   DB# 3  ","DBCRNO_3");//19
      iso.put("  AMT  ","DBCRAMT_3");//20


      java.util.Hashtable ht=new java.util.Hashtable();
      Object moneyVfy=exgui.verification.CellFormat.getDoubleFormat(10,2);
      ht.put("DIFF-AMT",moneyVfy);
      ht.put("IN-SALES",moneyVfy);
      ht.put("IN-LABOR",moneyVfy);
      ht.put("OUT-INS",moneyVfy);
      ht.put("IN-COMM",moneyVfy);
      ht.put("MAKER-COMM",moneyVfy);
      ht.put("OUT-COST",moneyVfy);
      ht.put("OUT-FRT",moneyVfy);
      ht.put("M-LABOR",moneyVfy);
      ht.put("M-COMM",moneyVfy);
      //this.add();
      pnl2List=new Panel2List(new TempDb(),99999,iso,ht);
      pnl2List.setBounds(new Rectangle(14, 74, 761, 486));
      this.add(pnl2List,null);
      isInitPnl2List=true;
      pnl2List.firstPage();
      isInitPnl2List=false;
      this.repaint();
      this.validate();
      util.MiscFunc.hideProcessingMessage();
    }catch(Exception exp){
      exgui.verification.VerifyLib.showAlert("Error While Retreiving USD/TWD Profit Data",
                                             "Error While Retreiving USD/TWD Profit Data");
      exp.printStackTrace();

    }
  }
  JPanel getReportPanel(String yyyymm)throws Exception{
    java.util.HashMap mp=new java.util.HashMap();
    mp.put("P_YYYYMM",yyyymm);
     String rpt_name="ACC_USDTWD_PF.rpt";
     String tempURL= newtimes.production.report.ReportProxyEngine.reportServerURL ;
     newtimes.production.report.ReportProxyEngine.reportServerURL="http://rpt2.nttpe.com.tw:9000/?file:///rpt//";
     com.inet.viewer.ReportViewerBean viewer=util.PublicVariable.inet_report_viewer;
      newtimes.production.report.ReportCmdSet.myReportEngin.setReportNameAndParas(viewer,rpt_name,mp);
      viewer.setHasGroupTree(false);
      viewer.start();
      JPanel pnl=new JPanel();
      pnl.setLayout(new java.awt.BorderLayout());
      pnl.add(viewer);
      viewer.setHasExportButton(true);
      newtimes.production.report.ReportProxyEngine.reportServerURL=tempURL;
   return pnl;

  }
  void btnRpt_actionPerformed(ActionEvent e) {
    if(txtYYYYMM.getText().trim().length()!=6){
      exgui.verification.VerifyLib.showAlert("Please Check YYYYMM","Please Check YYYYMM");
      return;
    }
    String yyyymm=txtYYYYMM.getText().trim();
    if(Integer.parseInt(yyyymm.substring(4,6))>12 ||Integer.parseInt(yyyymm.substring(4,6))<1){
      exgui.verification.VerifyLib.showAlert("Please Check YYYYMM","Please Check YYYYMM");
      return;
    }
    try{
      newtimes.preproduction.guis.DlgViewRpt dlg = new newtimes.preproduction.
          guis.DlgViewRpt(
          processhandler.template.Properties.getMainFrame(),
          "USD TWD PROFIT REPORT", getReportPanel(yyyymm), true);
      dlg.setSize(700, 500);
      dlg.show();
    }catch(Exception exp){
      exp.printStackTrace();
    }


  }
  void btnDel_actionPerformed(ActionEvent e) {
    try{
      if(!exgui.verification.VerifyLib.showConfirm("This Process will DELETE USD/TWD profit data of that month",
                                                   "Are You Sure?",false)){
        return;
      }
      if(txtYYYYMM.getText().trim().length()!=6){
        exgui.verification.VerifyLib.showAlert("Please Check YYYYMM","Please Check YYYYMM");
        return;
      }
      String yyyymm=txtYYYYMM.getText().trim();
      if(Integer.parseInt(yyyymm.substring(4,6))>12 ||Integer.parseInt(yyyymm.substring(4,6))<1){
        exgui.verification.VerifyLib.showAlert("Please Check YYYYMM","Please Check YYYYMM");
        return;
      }
      util.MiscFunc.showProcessingMessage();
      newtimesejb.dailyVoucher.DailyVoucherFacadeHome ejbHome=
          (newtimesejb.dailyVoucher.DailyVoucherFacadeHome)
          info_ejb.WeblogicServiceLocator.locateServiceHome(util.PublicVariable.SERVER_URL,
          "newtimesejb.dailyVoucher.DailyVoucherFacade");

      newtimesejb.dailyVoucher.DailyVoucherFacade ejb=ejbHome.create();
      ejb.deleteF107ToUsdTwdProfit(txtYYYYMM.getText());
      exgui.verification.VerifyLib.showPlanMsg("Data Deleted","Data Deleted");
      util.MiscFunc.hideProcessingMessage();
    }catch(Exception exp){
      exp.printStackTrace();
      exgui.verification.VerifyLib.showAlert("Process Failed!!\nPlease Contact System Manager",
                                             "Process Failed");
    }
  }
}
