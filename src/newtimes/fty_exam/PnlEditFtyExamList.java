package newtimes.fty_exam;

import java.awt.*;
import exgui.*;
import javax.swing.*;
import javax.swing.border.*;
import database.datatype.Record;
import java.util.*;
import java.awt.event.*;
/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class PnlEditFtyExamList extends JPanel {
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel1 = new BlueBkgWhiteCharLabel();
  WhiteBkgBlueCharLabel whiteBkgBlueCharLabel1 = new WhiteBkgBlueCharLabel();
  WhiteBkgBlueCharLabel whiteBkgBlueCharLabel2 = new WhiteBkgBlueCharLabel();
  JLabel lblBuyerName = new JLabel();
  Border border1;
  JLabel lblMakerName = new JLabel();
  processhandler.template.PnlTableEditor pnlList ;
  JButton btnAdd = new JButton();
  JButton btnExit = new JButton();
  JLabel lblClick2Edit = new JLabel();
  int current_buyer_seq;
  String current_MakerName;
  String current_BuyerName;
  PnlEditFtyExamList pnlEditFtyExamListThis;
  public PnlEditFtyExamList(int buyerSeq,String buyerName,String makerName) {
    try {
      current_buyer_seq =buyerSeq;
      current_BuyerName=buyerName;
      current_MakerName=makerName;
      jbInit();
      setListPanel();
      pnlEditFtyExamListThis=this;
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }

  void jbInit() throws Exception {
    border1 = BorderFactory.createBevelBorder(BevelBorder.LOWERED,Color.white,Color.white,new Color(103, 101, 98),new Color(148, 145, 140));
    blueBkgWhiteCharLabel1.setText("EDIT FACTORY AUDIT LIST");
    blueBkgWhiteCharLabel1.setBounds(new Rectangle(-1, 15, 801, 27));
    this.setLayout(null);
    whiteBkgBlueCharLabel1.setText("FACTORY");
    whiteBkgBlueCharLabel1.setBounds(new Rectangle(362, 54, 97, 28));
    whiteBkgBlueCharLabel2.setBounds(new Rectangle(12, 54, 76, 28));
    whiteBkgBlueCharLabel2.setText("BUYER");
    lblBuyerName.setBorder(border1);
    lblBuyerName.setText(current_BuyerName);
    lblBuyerName.setBounds(new Rectangle(89, 54, 247, 30));
    lblMakerName.setBounds(new Rectangle(461, 54, 309, 30));
    lblMakerName.setText(current_MakerName);
    lblMakerName.setBorder(border1);
    btnAdd.setBounds(new Rectangle(532, 98, 99, 30));
    btnAdd.setFont(new java.awt.Font("Dialog", 1, 12));
    btnAdd.setText("ADD");
    btnAdd.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnAdd_actionPerformed(e);
      }
    });
    btnExit.setText("EXIT");
    btnExit.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnExit_actionPerformed(e);
      }
    });
    btnExit.setFont(new java.awt.Font("Dialog", 1, 12));
    btnExit.setForeground(Color.red);
    btnExit.setBounds(new Rectangle(661, 98, 99, 30));
    lblClick2Edit.setText("CLICK ANY ROW TO EDIT");
    lblClick2Edit.setBounds(new Rectangle(18, 107, 454, 22));
    this.add(blueBkgWhiteCharLabel1, null);
    this.add(whiteBkgBlueCharLabel2, null);
    this.add(lblBuyerName, null);
    this.add(whiteBkgBlueCharLabel1, null);
    this.add(lblMakerName, null);
    this.add(btnAdd, null);
    this.add(btnExit, null);
    this.add(lblClick2Edit, null);
  }
  public void setListPanel(){
      DbHandler dbHandle= new DbHandler();
      util.InsertionOrderedHashMap iso=new util.InsertionOrderedHashMap();
      iso.put("AUDIT\nDATE","EXAM_DATE");
      iso.put("CAP\nPROVIDE","REPLY_DATE");
      iso.put("                    REMARK             ","EXAM_REMARK");
      iso.put("EMAIL\nDATE","EMAIL_DATE");
      java.util.Hashtable ht=new java.util.Hashtable();
      Object objDateVfy=exgui.verification.CellFormat.getDateStringFormaterAllowNull();
      ht.put("AUDIT\nDATE",objDateVfy);
      ht.put("CAP\nPROVIDE",objDateVfy);
      ht.put("EMAIL\nDATE",objDateVfy);
      pnlList=new Panel2List(dbHandle,9999,iso,ht);
      pnlList.firstPage();
      pnlList.setBorder(BorderFactory.createEtchedBorder());
      pnlList.setBounds(new Rectangle(0, 130, 790, 440));
      this.add(pnlList, null);
      if(pnlList.getDisplayingRecords().size()==0){
        lblClick2Edit.setText("");
      }else{
        lblClick2Edit.setText("CLICK ANY ROW TO EDIT");
      }
  }
  class DbHandler extends exgui.ultratable.PagedDataFactoryAdapter{
     public Vector getRecords(int bgn,int rowcount)throws Exception{
       StringBuffer sb=new StringBuffer();
       sb.append("select * from FTY_EXAM_HISTORY where FTY_EXAM_EMAIL_SEQ=");
       sb.append(current_buyer_seq);
       sb.append(" and MAKER_NAME='");
       sb.append(util.MiscFunc.Replace(current_MakerName,"'","''"));
       sb.append("'");
       sb.append(" and record_delete_flag='1'");
       sb.append(" order by FTY_EXAM_SEQ desc");
       Vector vct=exgui2.CONST.BASIC_MAIN_EJB.getDatas(
         util.PublicVariable.USER_RECORD,
        sb.toString(),bgn,rowcount);
       return vct;
     }
  }
  class Panel2List extends processhandler.template.PnlTableEditor{
    public Panel2List(exgui.ultratable.PagedDataFactory pagedDataFxy,
                      int rowCounts,util.InsertionOrderedHashMap columnMapping,
                     java.util.Hashtable object2StringConvertor){
        super(pagedDataFxy, rowCounts, columnMapping, object2StringConvertor);
        getJtable().addMouseListener(new MouseListen());
    }
    class MouseListen extends java.awt.event.MouseAdapter{
      public void mouseClicked(java.awt.event.MouseEvent me){
        if(getJtable().getSelectedRow()==-1)return;
        Record rec2edit=(Record)getDisplayingRecords().get(getJtable().getSelectedRow());
        Record recPrev=null;
        //if this is not top record,find out the next audit date,ie. the audite date of "upper" rown
        java.util.Date nextAuditDate=null;
        if(0!=getJtable().getSelectedRow()){
          Record recNext=(Record)getDisplayingRecords().get(getJtable().getSelectedRow()-1);
          try{
            nextAuditDate = (java.util.Date)recNext.get("EXAM_DATE");
          }catch(Exception exp){
            exp.printStackTrace();
          }
        }
        DlgEditFtyExamEvent dlg=new DlgEditFtyExamEvent(util.PublicVariable.APP_FRAME,
                                                        "Edit Audit Event",true,
                                                        pnlEditFtyExamListThis.pnlList,rec2edit
                                                        );
        dlg.setSize(570,300);
        exgui.UIHelper.setToScreenCenter(dlg);
        dlg.show();
      }
    }
    public void doPrint(){}
    public int getEachPageRowCount(){return _rowCounts;}
    public Hashtable getObject2StringConvertor() {return klmObjKvtHt;}
    public util.InsertionOrderedHashMap getHeadColumnMap(){return tblHeadColumn;}
    public exgui.ultratable.PagedDataFactory getPagedDataFactory(){return dbHandler;}
    public Record setObject2Record(Record rec,int col,Object obj){
         return null;
    }
    public void refineEditors(exgui.ultratable.MultiEditorJTable me ){
        getJtable().getColumnModel().getColumn(2).setCellRenderer(new MyRenderer());
       ((exgui.MultiClassTableModel)me.getJTable().getModel()).removeAllEditableColumn();
        getJtable().setRowHeight(50);

    }
    public class MyRenderer extends JLabel    implements javax.swing.table.TableCellRenderer{
      public MyRenderer(){
      super();
      setOpaque(true); /* it\u00B4s essential */
     }

    public Component getTableCellRendererComponent(
         javax.swing.JTable table, Object value,
         boolean isSelected, boolean hasFocus,
         int row, int column){
         String text = (value==null)?"":value.toString();
         if(text.trim().length()>0){
           text="<html><body>"+util.MiscFunc.Replace(text,"\n","<br>")+"</body></html>";
         }
         if(isSelected){
           setBackground(new java.awt.Color(0xFF, 0xE3, 0x8C)); // Decides the color
         }else{
           setBackground(new java.awt.Color(0xFF, 0xFF, 0xFF)); // Decides the color
         }
        setText(text); /* Put the current text in the JLabel */
       return this;
     }
  }

  }

  void btnExit_actionPerformed(ActionEvent e) {
    try{
      processhandler.template.Properties.getCenteralControler().goBack();
    }catch(Exception exp){
      exp.printStackTrace();
    }

  }

  void btnAdd_actionPerformed(ActionEvent e) {
    try{
          Record rec2edit =exgui2.CONST.BASIC_MAIN_EJB.getBlankRecord("FTY_EXAM_HISTORY_tbl");
          rec2edit.set("record_delete_flag",-1);
          rec2edit.set("record_create_user",util.PublicVariable.USER_RECORD.get(0));
          rec2edit.set("record_modify_user",util.PublicVariable.USER_RECORD.get(0));
          rec2edit.set("FTY_EXAM_EMAIL_SEQ",current_buyer_seq);
          rec2edit.set("MAKER_NAME",current_MakerName);
          Record recPrev = (pnlList.getDisplayingRecords().size()==0)?null:((Record)pnlList.getDisplayingRecords().get(0));
         DlgEditFtyExamEvent dlg = new DlgEditFtyExamEvent(util.PublicVariable.
          APP_FRAME,
          "Add Audit Event", true,
          pnlEditFtyExamListThis.pnlList, rec2edit
          );
      dlg.setSize(570, 300);
      exgui.UIHelper.setToScreenCenter(dlg);
      dlg.show();
    }catch(Exception exp){
       exp.printStackTrace();
    }

  }

}

