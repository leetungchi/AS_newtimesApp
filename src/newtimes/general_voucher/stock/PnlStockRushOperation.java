package newtimes.general_voucher.stock;

import java.awt.*;
import exgui.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;
import database.datatype.*;

import newtimes.general_voucher.rush.DlgSlkVhDtl2Add;
/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class PnlStockRushOperation extends JPanel {
  WhiteBkgBlueCharLabel whiteBkgBlueCharLabel4 = new WhiteBkgBlueCharLabel();
  JButton btnList2Rush = new JButton();
  JComboBox cbxCompany = new JComboBox();
  WhiteBkgBlueCharLabel whiteBkgBlueCharLabel1 = new WhiteBkgBlueCharLabel();
  JTextField txtYYYYMM = new JTextField();
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel1 = new BlueBkgWhiteCharLabel();
 exgui.DataBindJCombobox dbCbxCompany;
 String xnt4101RushSeq=null;
 int RUSH_TO_COLUMN_AT=-1;
 int RUSHED_BY_COLUMN_AT=-1;
 int ACCNO_COLUMN_AT,AMT_COLUMN_AT;
  Panel2List pnlList;
  Vector vctRec2Run;
  Vector vct2Delete;
  HashMap hmRushSeq2Record;
  HashMap hmGetMy6101List;
  HashMap hmGetMy4101;
  static int MY_4101_AT=18;
  static int MY_6101_LIST_AT=19;
  JButton btnExit = new JButton();
  StringBuffer sbRushList=null;
  boolean tblRowClicked=false;
  Vector vctTempUpdate4Delete=null;

  public PnlStockRushOperation() {
    try {
      jbInit();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }

  void jbInit() throws Exception {
    txtYYYYMM.setBounds(new Rectangle(299, 35, 74, 22));
    txtYYYYMM.setText("999999");
    whiteBkgBlueCharLabel1.setBounds(new Rectangle(9, 35, 41, 22));
    whiteBkgBlueCharLabel1.setText("公司");
    whiteBkgBlueCharLabel1.setForeground(Color.blue);
    cbxCompany.setBounds(new Rectangle(49, 35, 179, 22));
    btnList2Rush.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnList2Rush_actionPerformed(e);
      }
    });
    btnList2Rush.setText("LIST TO RUSH");
    btnList2Rush.setFont(new java.awt.Font("Dialog", 1, 11));
    btnList2Rush.setBounds(new Rectangle(666, 35, 110, 27));
    whiteBkgBlueCharLabel4.setForeground(Color.blue);
    whiteBkgBlueCharLabel4.setText("YYYYMM");
    whiteBkgBlueCharLabel4.setBounds(new Rectangle(233, 35, 65, 22));
    this.setBackground(new Color(202, 202, 224));
    this.setLayout(null);
    blueBkgWhiteCharLabel1.setFont(new java.awt.Font("Dialog", 0, 16));
    blueBkgWhiteCharLabel1.setText("進銷存勾沖作業");
    blueBkgWhiteCharLabel1.setBounds(new Rectangle(-4, 5, 805, 23));
    btnExit.setBounds(new Rectangle(629, 534, 86, 25));
    btnExit.setFont(new java.awt.Font("Dialog", 1, 12));
    btnExit.setText("EXIT");
    btnExit.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnExit_actionPerformed(e);
      }
    });
    btnDelete.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnDelete_actionPerformed(e);
      }
    });
    btnDelete.setText("DELETE");
    btnDelete.setFont(new java.awt.Font("Dialog", 1, 12));
    btnDelete.setForeground(Color.red);
    btnDelete.setBounds(new Rectangle(400, 534, 86, 25));
    btnUpdate.setBounds(new Rectangle(500, 534, 122, 25));
    btnUpdate.setFont(new java.awt.Font("Dialog", 1, 12));
    btnUpdate.setText("UPDATE");
    btnUpdate.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnUpdate_actionPerformed(e);
      }
    });
    pnl2Add.setBorder(BorderFactory.createLoweredBevelBorder());
    pnl2Add.setBounds(new Rectangle(20, 524, 271, 39));
    pnl2Add.setLayout(null);
    btnGetVhDtl.setBounds(new Rectangle(180, 7, 87, 24));
    btnGetVhDtl.setFont(new java.awt.Font("Dialog", 1, 12));
    btnGetVhDtl.setText("Query");
    btnGetVhDtl.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnGetVhDtl_actionPerformed(e);
      }
    });
    jLabel1.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel1.setText("ADD FROM VH#:");
    jLabel1.setBounds(new Rectangle(5, 4, 97, 29));
    txtVhFrom.setText("");
    txtVhFrom.setBounds(new Rectangle(97, 7, 81, 24));
    this.add(whiteBkgBlueCharLabel4, null);
    this.add(cbxCompany, null);
    this.add(whiteBkgBlueCharLabel1, null);
    this.add(txtYYYYMM, null);
    this.add(blueBkgWhiteCharLabel1, null);
    this.add(btnList2Rush, null);
    this.add(btnExit, null);
    this.add(btnUpdate, null);
    this.add(btnDelete, null);
    this.add(pnl2Add, null);
    pnl2Add.add(jLabel1, null);
    pnl2Add.add(txtVhFrom, null);
    pnl2Add.add(btnGetVhDtl, null);
    dbCbxCompany =
      new exgui.DataBindJCombobox(cbxCompany, "",
                                  newtimes.general_voucher.daily_voucher.
                                  Constants.VCT_GV_ACC_COMPANY,
                                  "comp_code_and_name", "cmp_code",null);
     btnDelete.setVisible(false);
     btnUpdate.setVisible(false);
     pnl2Add.setVisible(false);

  }

  void update4101And6101Column(final Record rec){
   try{
     Vector vct6101List = (Vector)hmGetMy6101List.get(rec.get(0).toString());
     if (vct6101List != null) {
       StringBuffer sb = new StringBuffer();
       for (int i = 0; i < vct6101List.size(); i++) {
         String strRushSeq = (String)vct6101List.get(i);
         if (sb.length() > 0)sb.append(",");
         Record recSrc = (Record)hmRushSeq2Record.get(strRushSeq);
         String vhNo = (String)recSrc.get(2);
         int vhSeq = recSrc.getInt(17);
         sb.append(vhNo);
         sb.append("_");
         sb.append(((vhSeq < 10) ? ("0" + String.valueOf(vhSeq)) :
                    String.valueOf(vhSeq)));
       }
       rec.set("MY_6101_LIST", sb.toString());
     }
     //test if is rusher.
     String seq4101 = (String)hmGetMy4101.get(rec.get(0).toString());
     if (seq4101 == null){
       rec.set("MY_4101", null);
       return;
     }
     Record recSrc = (Record)hmRushSeq2Record.get(seq4101);
     String vhNo = (String)recSrc.get(2);
     int vhSeq = recSrc.getInt(17);
     String vhNo4101 = vhNo +"_"+
         ((vhSeq < 10) ? ("0" + String.valueOf(vhSeq)) : String.valueOf(vhSeq));
     rec.set("MY_4101", vhNo4101);
     //return rec;
   }catch(Exception exp){
     exp.printStackTrace();
     util.ExceptionLog.exp2File(exp,"");
   }
  }
  void btnList2Rush_actionPerformed(ActionEvent e) {
    xnt4101RushSeq=null;
    StringBuffer sb=new StringBuffer();
    sb.append("select a.*,b.VH_SEQ ");
    //sb.append(",(select C.rec_desc from  GV_ACC_DATA c where C.acc_CODE=a.vh_account and  yyyymm='999999') as acc_tw_name ");
    sb.append(" from VH_DETAIL_STOCK a,VH_DETAIL b");
    sb.append(" where  ");
    sb.append(" a.GLB_SEQ=b.GLB_SEQ ");
    String yyyymm=txtYYYYMM.getText().trim();
    if(yyyymm.equals("")){
      sb.append(" and a.RUSH_YYYYMM='999999' ");
    }else{
      sb.append(" and a.RUSH_YYYYMM='");sb.append(util.MiscFunc.Replace(yyyymm,"'","''"));sb.append("' ");
    }
    sb.append(" and substr(a.VH_NO,1,1)='");sb.append(dbCbxCompany.getSelectedValue());sb.append("' ");
    sb.append(" order by a.vh_account,a.VH_DESCRIPTION ");
    hmRushSeq2Record=new HashMap();
    hmGetMy4101=new HashMap();
    hmGetMy6101List=new HashMap();

    try{
      tblRowClicked=false;
       Vector vct= exgui2.CONST.BASIC_MAIN_EJB.getDatas(
          util.PublicVariable.USER_RECORD, sb.toString(), 1, 999999999);
           sb=new StringBuffer();
       sb.append("select ");
       sb.append("b.* ");
       sb.append("from vh_detail_stock a,vh_dtl_stk_rx_map b ");
       sb.append("where A.RUSH_SEQ=B.ITEM_4101_RX_SEQ ");
       sb.append("and A.RUSH_YYYYMM='");;sb.append(util.MiscFunc.Replace(yyyymm,"'","''"));sb.append("' ");
       sb.append("order by B.ITEM_4101_RX_SEQ ");

       Vector vct6101List=exgui2.CONST.BASIC_MAIN_EJB.getDatas(
          util.PublicVariable.USER_RECORD, sb.toString(), 1, 999999999);
           String bgnRushSeq=null;
         Vector vct41012put=null;
       for(int i=0;i<vct6101List.size();i++){
         Record recTest=(Record)vct6101List.get(i);
         if(!recTest.get(0).toString().equals(bgnRushSeq)){
           if(vct41012put!=null && vct41012put.size()>0){
             hmGetMy6101List.put(bgnRushSeq,vct41012put);
           }
           bgnRushSeq=recTest.get(0).toString();
           vct41012put=new Vector();
         }
         vct41012put.add(recTest.get(1).toString());
         hmGetMy4101.put(recTest.get(1).toString(),recTest.get(0).toString());
       }
       hmGetMy6101List.put(bgnRushSeq,vct41012put);

       vctRec2Run=new Vector();
       sbRushList=new StringBuffer();
       java.text.NumberFormat df=new java.text.DecimalFormat("##########.00");
       for(int i=0;i<vct.size();i++){
         Record rec=(Record)vct.get(i);
         //format vh_amt column
         Object vhAmt=rec.get(8);
         rec.set(8,df.format(vhAmt));
         rec.getFieldName().add("MY_4101");//18
         rec.getValueFields().add(null);
         rec.getFieldName().add("MY_6101_LIST");//19
         rec.getValueFields().add(null);
         hmRushSeq2Record.put(rec.get(0).toString(),rec);
         if(sbRushList.length()>0)sbRushList.append(",");
         sbRushList.append(rec.get(0).toString());
         vct.set(i,rec);
       }
       for(int i=0;i<vct.size();i++){
        Record rec=(Record)vct.get(i);
        update4101And6101Column(rec);
        rec.getModifiedFields().clear();
        vctRec2Run.add(rec);
       }
       if(vctRec2Run.size()>0){
         btnDelete.setVisible(true);
         btnUpdate.setVisible(true);
         pnl2Add.setVisible(true);
       }else{
         btnDelete.setVisible(false);
         btnUpdate.setVisible(false);
         pnl2Add.setVisible(false);
       }
       vctTempUpdate4Delete=new Vector();
       vct2Delete=new Vector();
      genRushListPanel();
    }catch(Exception exp){
      exp.printStackTrace();
      util.ExceptionLog.exp2File(exp,"");
    }

  }
  class TblMouseAdpt extends java.awt.event.MouseAdapter {
    public void mouseClicked(java.awt.event.MouseEvent me){
         int row=pnlList.getJtable().getSelectedRow();
         int col=pnlList.getJtable().getSelectedColumn();
         tblRowClicked=true;
         if(row==-1)return;
         if(col!=0)return;
         if(col>5)return;

         Record rec=(Record)pnlList.getDisplayingRecords().get(row);
         String myRushSeq=rec.get(0).toString();
         String accNo=(String)pnlList.getJtable().getValueAt(row,2);
         if(accNo.startsWith("4101")){
           xnt4101RushSeq=myRushSeq;
           return;
         }
         if(accNo.startsWith("6101")){
           if(rec.get(MY_4101_AT)!=null){
             //test if to cancel the rush funcion.
             String rush2Seq=(String)hmGetMy4101.get(myRushSeq);
             if(!rush2Seq.equals(xnt4101RushSeq)){
               exgui.verification.VerifyLib.showAlert("This Item Already Rushed",
                   "This Item Already Rushed");
                 //pnlList.getJtable().changeSelection(row,col,false,false);
                return;

             }else{
               Vector vct6101List=(Vector)hmGetMy6101List.get(xnt4101RushSeq);
               for(int i=0;i<vct6101List.size();i++){
                 String str6101Seq=(String)vct6101List.get(i);
                 if(str6101Seq.equals(myRushSeq)){
                   vct6101List.remove(i);
                   hmGetMy6101List.put(rush2Seq,vct6101List);
                   break;
                 }
               }
               hmGetMy4101.remove(myRushSeq);
               for(int i=0;i<vctRec2Run.size();i++){
                 String seqRush=((Record)vctRec2Run.get(i)).get(0).toString();
                 if(seqRush.equals(myRushSeq)||seqRush.equals(rush2Seq)){
                   update4101And6101Column((Record)vctRec2Run.get(i));
                 }
               }
               pnlList.reload();
               //pnlList.getJtable().changeSelection(row,col,false,false);
             }
           }else{
             Vector vct6101List=(Vector)hmGetMy6101List.get(xnt4101RushSeq);
             if(null==vct6101List)vct6101List=new Vector();
             vct6101List.add(myRushSeq);
             hmGetMy6101List.put(xnt4101RushSeq,vct6101List);
             hmGetMy4101.put(myRushSeq,xnt4101RushSeq);
             for(int i=0;i<vctRec2Run.size();i++){
               String seqRush=((Record)vctRec2Run.get(i)).get(0).toString();
               if(seqRush.equals(myRushSeq)||seqRush.equals(xnt4101RushSeq)){
                 update4101And6101Column((Record)vctRec2Run.get(i));
               }
             }

             pnlList.reload();
             //pnlList.getJtable().changeSelection(row,col,false,false);
           }

         }

    }
  }
  class Compartor implements java.util.Comparator{
    int field2compare=0;
    String strOrg;
    String strDest;
    public int compare(Object rec1,Object rec2){

       Object objOrg=((database.datatype.Record)rec1).get(field2compare);
       strOrg=(objOrg==null)?"":objOrg.toString();
       Object objDest=((database.datatype.Record)rec2).get(field2compare);
       strDest=(objDest==null)?"":objDest.toString();
       return strOrg.compareTo(strDest);

     }
  }

  protected Compartor sorter = new Compartor();
  JButton btnDelete = new JButton();
  JButton btnUpdate = new JButton();
  JPanel pnl2Add = new JPanel();
  JButton btnGetVhDtl = new JButton();
  JLabel jLabel1 = new JLabel();
  JTextField txtVhFrom = new JTextField();
  protected void sortRecords(){
    sorter.field2compare= 7;//vh_descrtion column
    //System.out.println("header clicked");
    try{
      Vector vctdata = (Vector)util.MiscFunc.deepCopy(vctRec2Run);
      java.util.List list = new java.util.ArrayList(vctdata);
      java.util.Collections.sort(list, sorter);
      vctRec2Run.clear();
      vctRec2Run.addAll(list);
      pnlList.reload();
      this.validate();
    }catch(Exception exp){
      exp.printStackTrace();
      util.ExceptionLog.exp2File(exp,"");
    }
  }


  void genRushListPanel(){
    util.InsertionOrderedHashMap iso=new
        util.InsertionOrderedHashMap();
    iso.put("VH# ","VH_NO");
    iso.put("SQ","VH_SEQ");
    iso.put(" ACC# ","VH_ACCOUNT");
    ACCNO_COLUMN_AT=iso.keySet().size()-1;
    iso.put("AMT","VH_AMT");
    AMT_COLUMN_AT=iso.keySet().size()-1;

    iso.put("RUSHED BY","MY_6101_LIST");
    RUSHED_BY_COLUMN_AT=iso.keySet().size()-1;

    iso.put("RUSH TO","MY_4101");
    RUSH_TO_COLUMN_AT=iso.keySet().size()-1;

    iso.put("    DESCRIPTION    ","VH_DESCRIPTION");
    iso.put("REST AMT","REST_AMT");
    Hashtable ht=new Hashtable();

    ht.put("    DESCRIPTION    ",new OrdinaryField4Desc(100,exgui.verification.CellFormat.getOrdinaryField(100)));
    Object amtVfy=new RestAmtVfy();
    ht.put("REST AMT",amtVfy);

    //ht.put("DATE",exgui.verification.CellFormat.getDateStringFormater());
    //ht.put("    DESCRIPTION    ",new DescVfy());
    if(pnlList!=null)this.remove(pnlList);
    pnlList=new Panel2List(new Db2Handle(),9999,iso,ht);
    pnlList.getJtable().addMouseListener(new TblMouseAdpt());
    //if(clickHandler==null)clickHandler=new RowClick();
    //pnlList.getJtable().addMouseListener(clickHandler);
    pnlList.setBounds(new Rectangle(2, 77, 787, 461));
    this.add(pnlList, null);
    pnlList.firstPage();
    this.validate();
    //this.repaint();
  }

  class Db2Handle extends exgui.ultratable.PagedDataFactoryAdapter{
    public Vector getRecords(int bgn,int rowCount)throws Exception{
    return vctRec2Run;
   }

   public void updateRecords(Vector vct2update)throws Exception{

     if(pnlList.isUpdate4Delete){
       for(int i=0;i<vct2update.size();i++){
         Record rec=(Record)util.MiscFunc.deepCopy(vct2update.get(i));
         System.out.println("record to update at delete :"+rec.toString());
         vctTempUpdate4Delete.add(rec);
       }
       return;
     }

     try{
       if(vctTempUpdate4Delete.size()>0){
         for(int i=0;i<vctTempUpdate4Delete.size();i++){
           Record rec=(Record)util.MiscFunc.deepCopy(vctTempUpdate4Delete.get(i));
           vct2update.add(util.MiscFunc.deepCopy(rec));
         }
       }

       if (vct2update.size() > 0 || tblRowClicked) {
         /*
         for(int i=0;i<vct2update.size();i++){
           Record rec=(Record)vct2update.get(i);
           System.out.println("record to update is :"+rec.toString());
         }
         */
         util.MiscFunc.showProcessingMessage();
         newtimesejb.dailyVoucher.StockFacadeHome stockEjbHome =
             (newtimesejb.dailyVoucher.StockFacadeHome)
             info_ejb.WeblogicServiceLocator.locateServiceHome(util.
             PublicVariable.SERVER_URL,
             "newtimesejb.dailyVoucher.StockFacade");
         newtimesejb.dailyVoucher.StockFacade ejb = stockEjbHome.create();
         ejb.updateRushRelation(sbRushList.toString(), hmGetMy6101List,
                                vct2update,
                                util.PublicVariable.USER_RECORD.get(0).
                                toString(),vct2Delete);

         util.MiscFunc.hideProcessingMessage();
       }
     }catch(Exception exp){
       exp.printStackTrace();
       util.ExceptionLog.exp2File(exp,"");
       exgui.verification.VerifyLib.showAlert("Update Failed!!","Update Failed!!");
     }

   }
  }
  class DescColumKeyListener extends KeyAdapter implements exgui.ultratable.KeyProcess{
    protected javax.swing.text.JTextComponent myTextComponent = null;
    public void keyPressed(java.awt.event.KeyEvent e) {
    }

    protected void updateToMonitor() {
      java.awt.Container parentCon = myTextComponent.getParent();
      while (parentCon != null) {
        if (parentCon instanceof exgui.ultratable.MultiEditorJTable) {
          myTextComponent.validate();
          ((exgui.ultratable.MultiEditorJTable)parentCon).mt.m_Text =
              myTextComponent.getText();
          ///System.out.println(" update to ((exgui.ultratable.MultiEditorJTable)parentCon).mt.m_Text :"+myTextComponent.getText());
          break;
        }
        //System.out.println("keep lookup parent ,current parent is "+parentCon.getClass().getName());
        parentCon = parentCon.getParent();
      }
    }

    public void keyReleased(java.awt.event.KeyEvent e) {
      //System.out.println("get Key Code:"+e.getKeyCode());
      updateToMonitor();
    }

    public void keyTyped(java.awt.event.KeyEvent e) {
    }

    public void bind2TextComponent(javax.swing.text.JTextComponent txtcmp) {
      myTextComponent = txtcmp;
      myTextComponent.addKeyListener(this);
      //myTextComponent.addMouseListener(descColumKeyListener);
    }
 }
  class Task2Sort implements Runnable{
    public void run(){
      try{
        Thread.currentThread().sleep(50);
      }catch(Exception exp){
      }
      if(pnlList.getJtable().isEditing())pnlList.getJtable().editCellAt(-1,-1);
      sortRecords();
    }
  }

   class RestAmtVfy implements exgui.ultratable.CellTxtEditorFormat,exgui.Object2String{
     int _maxLength=10;
     String promptMsg=null;
     exgui.ultratable.CellTxtEditorFormat parent;
     RestAmtVfy(){
       parent=exgui.verification.CellFormat.getDoubleFormatAllowNull(10,2);
     }
     public exgui.ultratable.KeyProcess getKeyListener(){
       return parent.getKeyListener();
     }

     public int getMaxLength(){return _maxLength;}
     public String formatPromptMsg(){
       return promptMsg;
     }
     public Object cellStringToObject(String String2kvt){
        return parent.cellStringToObject(String2kvt);
     }
    public String Obj2String(Object obj){
      if(obj==null) return "";
      return obj.toString().toUpperCase();
    }
     public boolean isFormatValid(String inStr,int row,int column){
        if(!parent.isFormatValid(inStr,row,column))return false;
        Object orgRstAmt=((Record)pnlList.getDisplayingRecords().get(row)).get(16);
        if((orgRstAmt==null?"":orgRstAmt.toString().trim()).equalsIgnoreCase((inStr==null)?"":inStr) ){
          return true;
        }
        ((Record)pnlList.getDisplayingRecords().get(row)).set(16,(inStr==null||inStr.trim().length()==0)?null:inStr);
        return true;
     }
   }

  class OrdinaryField4Desc implements exgui.ultratable.CellTxtEditorFormat,exgui.Object2String{
     int _maxLength;
     String promptMsg=null;
     exgui.ultratable.CellTxtEditorFormat parent;
     DescColumKeyListener keyListen2=new DescColumKeyListener();
     OrdinaryField4Desc(int limitSize,exgui.ultratable.CellTxtEditorFormat _parent){
       _maxLength=limitSize;
       parent=_parent;
       promptMsg="String can not exceed "+_maxLength+" bytes ";
     }

     public exgui.ultratable.KeyProcess getKeyListener(){
       //return keyListen2;
       return  parent.getKeyListener();
     }
    public int getMaxLength(){return _maxLength;}
    public String formatPromptMsg(){
      return promptMsg;
    }

    public boolean isFormatValid(String inStr,int row,int column){
      if(row==-1)return true;
      if(!parent.isFormatValid(inStr,row,column))return false;
      String orgDesc=(String)((Record)pnlList.getDisplayingRecords().get(row)).get(7);
      if((orgDesc==null?"":orgDesc.trim()).equalsIgnoreCase((inStr==null)?"":inStr) ){
        return true;
      }
      //Object rstAmt=pnlList.getJtable().getValueAt(row,7);
      //((Record)pnlList.getDisplayingRecords().get(row)).set(16,(rstAmt==null)?null:rstAmt.toString());
      ((Record)pnlList.getDisplayingRecords().get(row)).set(7,inStr);
      //Thread thrd2Sort=new Thread(new Task2Sort());
      //thrd2Sort.start();
      return true;
      //return parent.isFormatValid(inStr,row,column);
    };
     public Object cellStringToObject(String String2kvt){
        return parent.cellStringToObject(String2kvt);
     }
    public String Obj2String(Object obj){
      if(obj==null) return "";
      return obj.toString().toUpperCase();
    }
  }

  public class RdrFor6101 extends JLabel
      implements javax.swing.table.TableCellRenderer{
      public RdrFor6101(){
      super();
      setFont(new java.awt.Font("Dialog",java.awt.Font.PLAIN, 14));
     setOpaque(true); /* it\u00B4s essential */
  }
   public Component getTableCellRendererComponent(
         javax.swing.JTable table, Object value,
         boolean isSelected, boolean hasFocus,
         int row, int column){
         String text = (value==null)?"":value.toString();
         if(text.startsWith("6101")){
           setBackground(new java.awt.Color(0x90, 0xFF, 0x90));
         }else{
          setBackground(new java.awt.Color(0xFF,0xFF,0xFF)); // Decides the color
         }
         setText(text);
         return this;
    }
  }


  class Panel2List extends processhandler.template.PnlTableEditor{
    boolean isUpdate4Delete=false;
    public Panel2List(exgui.ultratable.PagedDataFactory pagedDataFxy,
                      int rowCounts,util.InsertionOrderedHashMap columnMapping,
                     java.util.Hashtable object2StringConvertor){
        super(pagedDataFxy, rowCounts, columnMapping, object2StringConvertor);
        getLowerRightPanel().removeAll();
        jbtn1st.setVisible(false);
        jbtnNext.setVisible(false);
        jbtnPrev.setVisible(false);
        jbtnLast.setVisible(false);
    }
    public void doPrint(){}
    public void makeTable(Vector vct){
      super.makeTable(vct);

      getJtable().getColumnModel().getColumn(0).setPreferredWidth(75);
      getJtable().getColumnModel().getColumn(1).setPreferredWidth(24);
      getJtable().getColumnModel().getColumn(2).setPreferredWidth(75);
      getJtable().getColumnModel().getColumn(3).setPreferredWidth(68);
      getJtable().getColumnModel().getColumn(4).setPreferredWidth(102);
      getJtable().getColumnModel().getColumn(5).setPreferredWidth(90);
      getJtable().getColumnModel().getColumn(6).setPreferredWidth(400);
      getJtable().setRowHeight(20);
      getJtable().setFont(new java.awt.Font("Dialog",java.awt.Font.PLAIN, 14));
    }
    public int getEachPageRowCount(){return _rowCounts;}
    public Hashtable getObject2StringConvertor() {return klmObjKvtHt;}
    public util.InsertionOrderedHashMap getHeadColumnMap(){return tblHeadColumn;}
    public exgui.ultratable.PagedDataFactory getPagedDataFactory(){return dbHandler;}
    public Record setObject2Record(Record rec,int col,Object obj){
      try{
        String columName=storedRecordColumn[col];
        rec.set(columName,obj);
        return rec;
      }catch(Exception exp){
        exp.printStackTrace();
        return null;
      }
    }
    public void refineEditors(exgui.ultratable.MultiEditorJTable me ){
      me.setTextEditorVerifiers(getObject2StringConvertor());
      RdrFor6101 rdr46101=new RdrFor6101();
      this.getJtable().getColumnModel().getColumn(2).setCellRenderer(rdr46101);
    }
  }

  void btnExit_actionPerformed(ActionEvent e) {
    try{
      if(pnlList!=null){
        //pnlList.doUpdate();
        if(pnlList.isContextModified() || tblRowClicked){
          if(!exgui.verification.VerifyLib.showConfirm("Context Modified,Do You Sure To Exit ?","Context Modified",false)){
            return;
          }else{
            processhandler.template.Properties.getCenteralControler().goBack();
            return;
          }
        }
      }
      processhandler.template.Properties.getCenteralControler().goBack();
    }catch(Exception exp){
      exp.printStackTrace();
      util.ExceptionLog.exp2File(exp,"");
    }
    /*
    try{
      //test if have any record modified
      Vector vct2update=new Vector();
      for(int i=0;i<vctRec2Run.size();i++){
        Record rec=(Record)vctRec2Run.get(i);
        if(rec.getModifiedFields().size()>0)vct2update.add(rec);
      }
      if(vct2update.size()>0){
        util.MiscFunc.showProcessingMessage();
        newtimesejb.dailyVoucher.StockFacadeHome stockEjbHome=
            (newtimesejb.dailyVoucher.StockFacadeHome)
            info_ejb.WeblogicServiceLocator.locateServiceHome(util.PublicVariable.SERVER_URL,
            "newtimesejb.dailyVoucher.StockFacade");
        newtimesejb.dailyVoucher.StockFacade ejb=stockEjbHome.create();
         ejb.updateRushRelation(sbRushList.toString(),hmGetMy6101List,
                                vct2update,util.PublicVariable.USER_RECORD.get(0).toString());

        util.MiscFunc.hideProcessingMessage();
      }
      processhandler.template.Properties.getCenteralControler().goBack();
    }catch(Exception exp){
      exp.printStackTrace();
      util.ExceptionLog.exp2File(exp,"");
      exgui.verification.VerifyLib.showAlert("Update Failed!!\nPlease Contact System Manager",
                                             "Update Failed!!");

    }
    */

  }
  void btnDelete_actionPerformed(ActionEvent e) {
    xnt4101RushSeq=null;
     int[] deletRow=pnlList.getJtable().getSelectedRows();
     if(deletRow.length==0){
       exgui.verification.VerifyLib.showAlert("Please Select Row(s) To Delete","Please Select Row(s) To Delete");
       return;
     }
     //test if any select row have rush to /rushed by relationship
     //if so,stop. and notify user.
     for(int i=0;i<deletRow.length;i++){
       int row=deletRow[i];
       Object objRxTo=pnlList.getJtable().getValueAt(row,RUSH_TO_COLUMN_AT);
       if(objRxTo!=null && objRxTo.toString().length()>0){
         exgui.verification.VerifyLib.showAlert("RUSH TO CLUMN IS NOT BLANK\nPlease Remove Relation","Item Referenced");
         return;
       }
       objRxTo=pnlList.getJtable().getValueAt(row,RUSHED_BY_COLUMN_AT);
       if(objRxTo!=null && objRxTo.toString().length()>0){
         exgui.verification.VerifyLib.showAlert("RUSH BY CLUMN IS NOT BLANK\nPlease Remove Relation","Item Referenced");
         return;
       }
     }

     Vector vct2Duplicate=null;

     try{
       vct2Duplicate = (Vector)util.MiscFunc.deepCopy(vctRec2Run);
       for (int i = 0; i < deletRow.length; i++) {
         Record rec = (Record)vct2Duplicate.get(deletRow[i]);
         vct2Delete.add(util.MiscFunc.deepCopy(rec));
       }
       pnlList.doUpdate();
       btnList2Rush_actionPerformed(null);
     }catch(Exception exp){
       exp.printStackTrace();
     }

     /*
     try{
       pnlList.isUpdate4Delete=true;
       pnlList.doUpdate();
       pnlList.isUpdate4Delete=false;
       vct2Duplicate = (Vector)util.MiscFunc.deepCopy(vctRec2Run);
       for (int i = 0; i < deletRow.length; i++) {
         Record rec = (Record)vct2Duplicate.get(deletRow[i]);
         vct2Delete.add(util.MiscFunc.deepCopy(rec));
         String seq = rec.get(0).toString();
         hmGetMy4101.remove(seq);
         hmGetMy6101List.remove(seq);
         hmRushSeq2Record.remove(seq);
         vct2Duplicate.set(deletRow[i], null);
       }
     }catch(Exception exp){
      exp.printStackTrace();
    }
     vctRec2Run=new Vector();
     for(int i=0;i<vct2Duplicate.size();i++){
       Object obj=vct2Duplicate.get(i);
       if(obj!=null)vctRec2Run.add(obj);
     }
     pnlList.reload();
     //pnlList.isUpdate4Delete=false;
     */
  }

  void btnUpdate_actionPerformed(ActionEvent e) {
    try{
      util.MiscFunc.showProcessingMessage();
      pnlList.doUpdate();
      btnList2Rush_actionPerformed(null);
      util.MiscFunc.hideProcessingMessage();
      //processhandler.template.Properties.getCenteralControler().goBack();
    }catch(Exception exp){
      exp.printStackTrace();
      util.ExceptionLog.exp2File(exp,"");
    }

  }
  void btnGetVhDtl_actionPerformed(ActionEvent e) {
    if(txtVhFrom.getText().trim().length()<8){
        exgui.verification.VerifyLib.showAlert("Incorrect VH# Format","Incorrect VH# Format");
        return ;
    }
    try{
        pnlList.doUpdate();
        StringBuffer sb=new StringBuffer();
        sb.append("select a.* ");
        sb.append(",trim(a.VH_INVOICE||' '||a.VH_DESCRIPTION) as  INV_DESC ");
        sb.append(",(select C.rec_desc from  GV_ACC_DATA c where C.acc_CODE=a.vh_account and  yyyymm='999999') as acc_tw_name ");
        sb.append(" from vh_detail a ");
        sb.append(" where a.vh_no='");
        sb.append(txtVhFrom.getText().trim());
        sb.append("' order by a.vh_seq ");
        System.out.print(sb);
        Vector vct =exgui2.CONST.BASIC_MAIN_EJB.getDatas(
        util.PublicVariable.USER_RECORD,
        sb.toString(),1,9999999);
        if(vct.size()==0){
                exgui.verification.VerifyLib.showAlert("No Such VH#","No Such VH#");
                return;
        }
        DlgSlkVhDtl2Add dlg=new  DlgSlkVhDtl2Add(util.PublicVariable.APP_FRAME,"Select To Add To Rush",true,vct);
        dlg.setSize(700,445);
        exgui.UIHelper.setToScreenCenter(dlg);
        dlg.show();
        if(dlg.vct2add==null){
           return;
        }
        insertIntoStockFromVhDtl(dlg.vct2add);
        pnlList.doUpdate();
       btnList2Rush_actionPerformed(null);
    }catch(Exception exp){
           exp.printStackTrace();
           util.ExceptionLog.exp2File(exp,"");
    }finally{
        pnlList.reload();
        util.MiscFunc.hideProcessingMessage();
    }

  }
  void insertIntoStockFromVhDtl(Vector vec) throws Exception{


       Record rec=(Record)vec.get(0);
       newtimesejb.dailyVoucher.StockFacadeHome stockEjbHome=
         (newtimesejb.dailyVoucher.StockFacadeHome)
         info_ejb.WeblogicServiceLocator.locateServiceHome(util.PublicVariable.SERVER_URL,
         "newtimesejb.dailyVoucher.StockFacade");
         newtimesejb.dailyVoucher.StockFacade ejb=stockEjbHome.create();
         ejb.add2Stockfmseq(rec.get(0).toString(),util.PublicVariable.USER_RECORD.get(0).toString());

  }
}
