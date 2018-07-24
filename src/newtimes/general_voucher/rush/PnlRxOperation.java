package newtimes.general_voucher.rush;

import java.awt.*;
import exgui.*;
import javax.swing.*;
import java.util.*;
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

public class PnlRxOperation extends JPanel {
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel1 = new BlueBkgWhiteCharLabel();
  WhiteBkgBlueCharLabel whiteBkgBlueCharLabel1 = new WhiteBkgBlueCharLabel();
  JComboBox cbxCompany = new JComboBox();
  WhiteBkgBlueCharLabel whiteBkgBlueCharLabel2 = new WhiteBkgBlueCharLabel();
  JTextField txtGrpCode = new JTextField();
  WhiteBkgBlueCharLabel whiteBkgBlueCharLabel3 = new WhiteBkgBlueCharLabel();
  JButton btnList2Rush = new JButton();
  JComboBox cbxAcc = new JComboBox();
  Vector vctRec2Run;
  Vector vct2Delete;
  exgui.DataBindJCombobox dbCbxCompany,dbCbxAccItem;
  HashMap hmAccDc=null;
  public static final int TYPE_RUSHEE=0;
  public static final int  TYPE_RUSHER=1;
  public static final int TYPE_RUSH_NOT_ALLOWED=-1;
  static int ACCNO_COLUMN_AT=-1;
  static int AMT_COLUMN_AT=-1;

  RUSHEE_OBJ rushee2Obj;
  RowClick clickHandler=null;
  java.text.NumberFormat nf =new java.text.DecimalFormat("############.##");
  public PnlRxOperation() {
    try {
      jbInit();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }

  void jbInit() throws Exception {
    blueBkgWhiteCharLabel1.setFont(new java.awt.Font("Dialog", 0, 16));
    blueBkgWhiteCharLabel1.setText("勾沖作業單元");
    blueBkgWhiteCharLabel1.setBounds(new Rectangle(-2, 6, 807, 30));
    this.setBackground(new Color(202, 202, 224));
    this.setLayout(null);
    whiteBkgBlueCharLabel1.setForeground(Color.blue);
    whiteBkgBlueCharLabel1.setText("公司");
    whiteBkgBlueCharLabel1.setBounds(new Rectangle(6, 41, 41, 22));
    cbxCompany.setBounds(new Rectangle(46, 41, 179, 22));
    whiteBkgBlueCharLabel2.setBounds(new Rectangle(373, 41, 42, 22));
    whiteBkgBlueCharLabel2.setForeground(Color.blue);
    whiteBkgBlueCharLabel2.setText("科目");
    txtGrpCode.setText("");
    txtGrpCode.setBounds(new Rectangle(645, 41, 27, 22));
    whiteBkgBlueCharLabel3.setText("組別");
    whiteBkgBlueCharLabel3.setForeground(Color.blue);
    whiteBkgBlueCharLabel3.setBounds(new Rectangle(604, 41, 42, 22));
    btnList2Rush.setBounds(new Rectangle(685, 41, 110, 27));
    btnList2Rush.setFont(new java.awt.Font("Dialog", 1, 11));
    btnList2Rush.setText("LIST TO RUSH");
    btnList2Rush.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnList2Rush_actionPerformed(e);
      }
    });
    cbxAcc.setBounds(new Rectangle(415, 41, 185, 22));
    btnExit.setBounds(new Rectangle(634, 540, 109, 27));
    btnExit.setFont(new java.awt.Font("Dialog", 1, 12));
    btnExit.setForeground(Color.red);
    btnExit.setText("EXIT");
    btnExit.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnExit_actionPerformed(e);
      }
    });
    whiteBkgBlueCharLabel4.setBounds(new Rectangle(230, 41, 65, 22));
    whiteBkgBlueCharLabel4.setText("YYYYMM");
    whiteBkgBlueCharLabel4.setForeground(Color.blue);
    txtYYYYMM.setText("999999");
    txtYYYYMM.setBounds(new Rectangle(296, 41, 74, 22));
    btnUpdate.setBounds(new Rectangle(295, 543, 109, 27));
    btnUpdate.setFont(new java.awt.Font("Dialog", 1, 11));
    btnUpdate.setActionCommand("jButton1");
    btnUpdate.setText("UPDATE");
    btnUpdate.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnUpdate_actionPerformed(e);
      }
    });
    this.add(blueBkgWhiteCharLabel1, null);
    //this.add(pnlList, null);
    this.add(cbxCompany, null);
    this.add(txtYYYYMM, null);
    this.add(whiteBkgBlueCharLabel1, null);
    this.add(cbxAcc, null);
    this.add(whiteBkgBlueCharLabel4, null);
    this.add(txtGrpCode, null);
    this.add(whiteBkgBlueCharLabel2, null);
    this.add(btnList2Rush, null);
    this.add(whiteBkgBlueCharLabel3, null);
    this.add(btnExit, null);
    this.add(btnUpdate, null);

    dbCbxCompany =
      new exgui.DataBindJCombobox(cbxCompany, "",
                                  newtimes.general_voucher.daily_voucher.
                                  Constants.VCT_GV_ACC_COMPANY,
                                  "comp_code_and_name", "cmp_code",null);
  StringBuffer sb=new StringBuffer();
  sb.append("select a.*,b.ITEM_NAME,a.acc_code||'--'||b.item_name as code_and_name ,B.D_C ");
  sb.append(" from VH_RX_ACC_ITEM a ,GV_ACC_ITEM b ");
  sb.append(" where a.acc_code=b.ITEM_CODE order by a.acc_code");

   Vector vctAcc4Rx=exgui2.CONST.BASIC_MAIN_EJB.getDatas(
     util.PublicVariable.USER_RECORD,sb.toString(),1,9999);
   hmAccDc=new HashMap();
   //keep D/C to test if is RUSHER or RUSHEE.
   for(int i=0;i<vctAcc4Rx.size();i++){
     Record rec=(Record)vctAcc4Rx.get(i);
     hmAccDc.put((String)rec.get(0),(String)rec.get(3));//acc# & D/C code
   }

   dbCbxAccItem =
     new exgui.DataBindJCombobox(cbxAcc, "",
                               vctAcc4Rx,
                               "code_and_name", "acc_code",null,"ALL",null);


  }
  //JPanel pnlList = new JPanel();
  Panel2List pnlList=null;
  JButton btnExit = new JButton();
  WhiteBkgBlueCharLabel whiteBkgBlueCharLabel4 = new WhiteBkgBlueCharLabel();
  JTextField txtYYYYMM = new JTextField();
  JButton btnUpdate = new JButton();

  void btnExit_actionPerformed(ActionEvent e) {
    try{
      if(vct2Delete!=null && vct2Delete.size()>0){
        if(exgui.verification.VerifyLib.showConfirm("Context Modified,But Not Saved Yet\nAre you Soure To Exit ?",
                                                 "Context Modified",false)){
              processhandler.template.Properties.getCenteralControler().goBack();

          }else{
            return;
          }
       }
       processhandler.template.Properties.getCenteralControler().goBack();

    }catch(Exception exp){
      exp.printStackTrace();
    }

  }

  void btnList2Rush_actionPerformed(ActionEvent e) {
    try{
      if(vct2Delete!=null && vct2Delete.size()>0){
        if(!exgui.verification.VerifyLib.showConfirm("Contaxt Modified,but not confirmed yet\nAre You Soure To Reload ?",
                                                    "Context Modified",false) ){
           return;
        }
         // doUpdate();
         // vct2Delete=null;
      }
     vct2Delete=null;
     StringBuffer sb=new StringBuffer();
     sb.append("select a.*");
     sb.append(",(select b.vH_SEQ from vh_detail b where B.GLB_SEQ=A.GLB_SEQ ) as vh_seq ");
     sb.append(",(select C.rec_desc from  GV_ACC_DATA c where C.acc_CODE=a.vh_account and  yyyymm='999999') as acc_tw_name ");
     sb.append(" from VH_DETAIL_RUSH a");
     sb.append(" where  ");
     //sb.append(" a.GLB_SEQ=b.GLB_SEQ ");
     sb.append(" 1=1  ");
     String yyyymm=txtYYYYMM.getText().trim();
     if(yyyymm.equals("")){
       sb.append(" and a.RUSH_YYYYMM='999999' ");
     }else{
       sb.append(" and a.RUSH_YYYYMM='");sb.append(util.MiscFunc.Replace(yyyymm,"'","''"));sb.append("' ");
     }
     sb.append(" and substr(a.VH_NO,1,1)='");sb.append(dbCbxCompany.getSelectedValue());sb.append("' ");
     String accType=(String)dbCbxAccItem.getSelectedValue();
     if(accType!=null){
       sb.append(" and substr(a.VH_ACCOUNT,1,4)='");
       sb.append(accType);
       sb.append("' ");
     }
     String grpCode=txtGrpCode.getText().trim();
    if(grpCode!=null && grpCode.length()>0){
      sb.append(" and  length(a.vh_account)>5 ");
      sb.append(" and  substr(a.vh_account,6,1)='");
      sb.append(util.MiscFunc.Replace(grpCode,"'","''"));
      sb.append("' ");
    }
     sb.append(" order by a.vh_account,a.VH_DESCRIPTION ");
     vctRec2Run=exgui2.CONST.BASIC_MAIN_EJB.getDatas(
      util.PublicVariable.USER_RECORD,sb.toString(),1,999999999);
     vct2Delete=new Vector();
      genRushListPanel();
    }catch(Exception exp){
      exp.printStackTrace();
      util.ExceptionLog.exp2File(exp,"");
      exgui.verification.VerifyLib.showAlert("Error While Generate Records For Rush\nPlease Contact System Manager",
                                             "Error While Generate Records For Rush");
    }

  }
  void genRushListPanel(){
    rushee2Obj=null;
    util.InsertionOrderedHashMap iso=new
        util.InsertionOrderedHashMap();
    iso.put("VH# ","VH_NO");
    iso.put("SQ","VH_SEQ");
    iso.put(" ACC# ","VH_ACCOUNT");
    ACCNO_COLUMN_AT=iso.keySet().size()-1;
    iso.put("會計科目","acc_tw_name");
    //iso.put("DATE","VH_DATE");
    //iso.put("YYYYMM","RUSH_YYYYMM");
    iso.put("D/C","VH_DC");
    iso.put("AMT","BAL_AMT");
    AMT_COLUMN_AT=iso.keySet().size()-1;
    iso.put("    DESCRIPTION    ","VH_DESCRIPTION");
    Hashtable ht=new Hashtable();
    //ht.put("DATE",exgui.verification.CellFormat.getDateStringFormater());
    //ht.put("    DESCRIPTION    ",new DescVfy());
    if(pnlList!=null)this.remove(pnlList);
    pnlList=new Panel2List(new Db2Handle(),9999,iso,ht);
    if(clickHandler==null)clickHandler=new RowClick();
    pnlList.getJtable().addMouseListener(clickHandler);
    pnlList.setBounds(new Rectangle(2, 77, 787, 461));
    this.add(pnlList, null);
    pnlList.firstPage();
    this.validate();
    //this.repaint();
  }
  void doUpdate(){
   //collect all the records to update or delete.
   try{
     util.MiscFunc.showProcessingMessage();
     newtimesejb.dailyVoucher.RushFacadeHome rushEjbHome =
         (newtimesejb.dailyVoucher.RushFacadeHome)
         info_ejb.WeblogicServiceLocator.locateServiceHome(util.PublicVariable.
         SERVER_URL,
         "newtimesejb.dailyVoucher.RushFacade");
     newtimesejb.dailyVoucher.RushFacade ejb = rushEjbHome.create();
     Vector vctOP = new Vector();
     for (int i = 0; i < vctRec2Run.size(); i++) {
       Record rec = (Record)vctRec2Run.get(i);
       if (rec.getModifiedFields().size() > 0)vctOP.add(rec);
     }
     for (int i = 0; i < vct2Delete.size(); i++) {
       Record rec = (Record)vct2Delete.get(i);
       rec.set("record_delete_flag", "0");
       rec.set("record_delete_user", util.PublicVariable.USER_RECORD.get(0));
       vctOP.add(rec);
     }
     ejb.updateRush(vctOP, util.PublicVariable.USER_RECORD.get(0).toString());
     util.MiscFunc.hideProcessingMessage();
   }catch(Exception exp){
     exp.printStackTrace();
     util.ExceptionLog.exp2File(exp,"");
     exgui.verification.VerifyLib.showAlert("Error While Update Rush file \nPlease Contact System Managet",
                                            "Update Rush Error");
   }
  }
  int getRushOperation(int row){
    Record rec=(Record)pnlList.getDisplayingRecords().get(row);
    String accCode=rec.get(5).toString().substring(0,4);
    String rowDcCod=rec.get(6).toString();
    if(!hmAccDc.containsKey(accCode))return TYPE_RUSH_NOT_ALLOWED;
    String srcDcCode=(String)hmAccDc.get(accCode);
    if(rowDcCod.equalsIgnoreCase(srcDcCode))return TYPE_RUSHEE;
    return TYPE_RUSHER;
  }
  class Db2Handle extends exgui.ultratable.PagedDataFactoryAdapter{
    public Vector getRecords(int bgn,int rowCount)throws Exception{
      return vctRec2Run;
    }
  }
  class CellRender4Seq extends JLabel
   implements javax.swing.table.TableCellRenderer{
   public CellRender4Seq(){
   super();
  //setBorder(javax.swing.BorderFactory.createRaisedBevelBorder());
  setOpaque(true); /* it\u00B4s essential */
  setHorizontalAlignment(super.RIGHT);
}
public Component getTableCellRendererComponent(
      javax.swing.JTable table, Object value,
      boolean isSelected, boolean hasFocus,
      int row, int column){

      String text = (value==null)?"0":value.toString();
      if(value.toString().length()==1)text="0"+text;

     setBackground(new java.awt.Color(0xFF, 0xFF, 0xFF)); // Decides the color
     if(isSelected)setBackground(new java.awt.Color(0xFF, 0xE3, 0x8C));
     setText(text);
  return this;
 }
}

  class CellRender4Rx extends JLabel
     implements javax.swing.table.TableCellRenderer{
     public CellRender4Rx(){
     super();
    //setBorder(javax.swing.BorderFactory.createRaisedBevelBorder());
    setOpaque(true); /* it\u00B4s essential */
    //setHorizontalAlignment(super.RIGHT);
 }
  public Component getTableCellRendererComponent(
        javax.swing.JTable table, Object value,
        boolean isSelected, boolean hasFocus,
        int row, int column){
        String text = (value==null)?"":value.toString();
        int rxType=getRushOperation(row);
        switch (rxType){
          case  TYPE_RUSHEE:
            setBackground(new java.awt.Color(0x90,0xFF,0x90)); // light green
            break;
          case  TYPE_RUSHER:
            setBackground(new java.awt.Color(0xFF, 0xFF, 0xFF)); // normal color
            if(isSelected)setBackground(new java.awt.Color(0xFF, 0xE3, 0x8C));
            break;
          case  TYPE_RUSH_NOT_ALLOWED:
            setBackground(new java.awt.Color(0xFF, 0xCC, 0xCC)); // pink
            if(isSelected)setBackground(new java.awt.Color(0xFF, 0xE3, 0x8C));
        }
        if(column==AMT_COLUMN_AT){
          setHorizontalAlignment(super.RIGHT);
          text=nf.format(value);
          text=text+"   ";
        }else{
          setHorizontalAlignment(super.LEFT);
        }
       setText(text);
    return this;
   }
 }

 public class DescVfy implements exgui.ultratable.CellTxtEditorFormat,exgui.Object2String{
   Object orgFvyObj=null;
   public DescVfy(){
     orgFvyObj=exgui.verification.CellFormat.getOrdinaryField(4000);
   }
   public int getMaxLength(){
     return ((exgui.ultratable.CellTxtEditorFormat)orgFvyObj).getMaxLength();
   }

   public exgui.ultratable.KeyProcess getKeyListener(){
     return ((exgui.ultratable.CellTxtEditorFormat)orgFvyObj).getKeyListener();
   }

   public String formatPromptMsg(){
      return  ((exgui.ultratable.CellTxtEditorFormat)orgFvyObj).formatPromptMsg();
     // return  "ACC Code Not Found";
   }
   public boolean isFormatValid(String inStr,int row,int column){
    //return true;
    //write to store data.
    ((Record)vctRec2Run.get(row)).set(7,inStr);
     return true;
   }
   public String Obj2String(Object obj2kvt){
     return ((exgui.Object2String)orgFvyObj).Obj2String(obj2kvt);
   }
    public Object cellStringToObject(String String2kvt){
      return ((exgui.ultratable.CellTxtEditorFormat)orgFvyObj).cellStringToObject(String2kvt);
    }

  }


  class Panel2List extends processhandler.template.PnlTableEditor{
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

      getJtable().getColumnModel().getColumn(0).setPreferredWidth(85);
      getJtable().getColumnModel().getColumn(1).setPreferredWidth(24);
      getJtable().getColumnModel().getColumn(2).setPreferredWidth(75);
      getJtable().getColumnModel().getColumn(3).setPreferredWidth(100);
      getJtable().getColumnModel().getColumn(4).setPreferredWidth(27);
      getJtable().getColumnModel().getColumn(5).setPreferredWidth(68);
      getJtable().getColumnModel().getColumn(6).setPreferredWidth(400);
      getJtable().setRowHeight(20);
      getJtable().setFont(new java.awt.Font("Dialog",java.awt.Font.PLAIN, 14));
    }
    public int getEachPageRowCount(){return _rowCounts;}
    public Hashtable getObject2StringConvertor() {return klmObjKvtHt;}
    public util.InsertionOrderedHashMap getHeadColumnMap(){return tblHeadColumn;}
    public exgui.ultratable.PagedDataFactory getPagedDataFactory(){return dbHandler;}
    public Record setObject2Record(Record rec,int col,Object obj){
      return null;
    }
    public void refineEditors(exgui.ultratable.MultiEditorJTable me ){
      me.setTextEditorVerifiers(getObject2StringConvertor());
      CellRender4Rx rnd=new CellRender4Rx();
      getJtable().getColumnModel().getColumn(1).setCellRenderer(new CellRender4Seq());
       for(int i=3;i<getJtable().getColumnCount();i++) {
         getJtable().getColumnModel().getColumn(i).setCellRenderer(rnd);
       }
       //me.setAllColumnUnEdtiable();
    }
  }
   class RUSHEE_OBJ {
      long RUSH_SEQ;
      Record recRush;
      //Record recRushee;
      String ACC_CODE;
      double AMT;
      int selected_row;
   }
   class RowClick extends java.awt.event.MouseAdapter {
     public void mouseClicked(java.awt.event.MouseEvent me){
          int row=pnlList.getJtable().getSelectedRow();
          int rushType=getRushOperation(row);
          if(rushType==TYPE_RUSHER){
            if(rushee2Obj==null){
              exgui.verification.VerifyLib.showAlert("Please Select A Green Row To Rush",
                                                     "Please Select A Green Row To Rush");
              return;
            }

              //test if acc# allowed
              String accCode=((String)pnlList.getJtable().getValueAt(row,ACCNO_COLUMN_AT)).substring(0,4);
              if(!accCode.equals(rushee2Obj.ACC_CODE)){
                exgui.verification.VerifyLib.showAlert("科目不符","ACC# Miss Match");
                return;
              }
              //test amount.
              double amt2minus=Double.parseDouble(pnlList.getJtable().getValueAt(row,AMT_COLUMN_AT).toString());
              amt2minus=new java.math.BigDecimal(amt2minus).setScale(2,java.math.BigDecimal.ROUND_HALF_UP).doubleValue();
              rushee2Obj.AMT=new java.math.BigDecimal(rushee2Obj.AMT).setScale(2,java.math.BigDecimal.ROUND_HALF_UP).doubleValue();
              if(amt2minus>rushee2Obj.AMT){
                exgui.verification.VerifyLib.showAlert("沖方金額大於被沖方",
                                                       "沖方金額大於被沖方");
                return;
              }
              rushee2Obj.AMT-=amt2minus;
              try{
                ((Record)vctRec2Run.get(rushee2Obj.selected_row)).set(8,rushee2Obj.AMT); //BAL_AMT
                vct2Delete.add(util.MiscFunc.deepCopy(vctRec2Run.get(row)));
                vctRec2Run.remove(row);
                if(rushee2Obj.AMT==0){
                  vct2Delete.add(util.MiscFunc.deepCopy(rushee2Obj.recRush));
                  //vctRec2Run.remove(rushee2Obj.selected_row);
                  vctRec2Run.remove(rushee2Obj.recRush);
                  rushee2Obj=null;
                }

                pnlList.reload();
                //find out the row position
                if(rushee2Obj==null)return;
                for(int i=0;i<vctRec2Run.size();i++){
                    Record rec=(Record)vctRec2Run.get(i);
                    if(rushee2Obj.RUSH_SEQ==rec.getLong(0)){
                      rushee2Obj.selected_row=i;
                      break;
                    }
                }
              }catch(Exception exp){
                exp.printStackTrace();
                util.ExceptionLog.exp2File(exp,"");
              }
          }
          if(rushType==TYPE_RUSHEE){
             rushee2Obj=new RUSHEE_OBJ();
             rushee2Obj.selected_row=row;
             rushee2Obj.ACC_CODE=pnlList.getJtable().getValueAt(row,ACCNO_COLUMN_AT).toString().substring(0,4) ;
             rushee2Obj.recRush=(Record)vctRec2Run.get(row);
             rushee2Obj.RUSH_SEQ=rushee2Obj.recRush.getLong(0);
             rushee2Obj.AMT=Double.parseDouble(pnlList.getJtable().getValueAt(row,AMT_COLUMN_AT).toString());
          }
          return;
     }
   }

  void btnUpdate_actionPerformed(ActionEvent e) {
    if(vct2Delete!=null && vct2Delete.size()>0){
      util.MiscFunc.showProcessingMessage();
      doUpdate();
      vct2Delete=null;
      btnList2Rush_actionPerformed(null);
      util.MiscFunc.hideProcessingMessage();
    }else{
      exgui.verification.VerifyLib.showPlanMsg("Nothing To update","Nothing To Update");
    }
  }

}
