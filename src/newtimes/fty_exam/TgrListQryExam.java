package newtimes.fty_exam;
import database.datatype.Record;
import java.util.*;
import processhandler.*;
import processhandler.commands.CommandException;
import java.awt.Cursor;
import processhandler.*;
import processhandler.commands.CommandException;
import java.awt.Cursor;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class TgrListQryExam extends CommandTrigger{
  static String QRY_FIELD_BUYERSEQ;
  static java.util.Date  QRY_FIELD_B4EXAMDATE;
  static String QRY_FIELD_MAKER_NAME;
  static database.encoders.OracleEncoder oracleEncoder=new database.encoders.OracleEncoder();
  static int CURRENT_PAGE_INDEX=0;
  Panel2List pnllist;
  public TgrListQryExam() {

  }
  protected void activateThisProcess() throws processhandler.commands.CommandException {
    try{
      processhandler.template.Properties.getCenteralControler().
          setSystemCommander(
          newtimes.preproduction.Constants.CMDSET_PREPRODUCTION_MAINTAIN);
      commander = processhandler.template.Properties.getCenteralControler().
          getCurrentSystemCommand();
      ctnCtl.recordProcess(this); //store this node as "go back" required
      //wait if misc. attributions ready
      javax.swing.JFrame jframe = processhandler.template.Properties.getMainFrame();
      jframe.getContentPane().removeAll();
      jframe.getContentPane().setCursor(new Cursor(Cursor.WAIT_CURSOR));
      DataHandler dbhandl=new DataHandler();
      util.InsertionOrderedHashMap iso=new util.InsertionOrderedHashMap();
      iso.put("BUYER","BUYER_NAME");
      iso.put(" FACTORY ","MAKER_NAME");
      iso.put("LAST\nAUDIT","LAST_EXAM_DATE");
      iso.put("CAP\nPROVIDE","REPLY_DATE");
      iso.put("NEXT\nAUDIT","EXAM_DATE");
      iso.put("LAST AUDIT\nSTATUS","STATUS");
      iso.put("LAST AUDIT\nVALIDAY","VALIDAY");
      iso.put("           REMARK            ","EXAM_REMARK");

      java.util.Hashtable ht=new java.util.Hashtable();

      ht.put("LAST\nAUDIT",exgui.verification.CellFormat.getDateStringFormaterAllowNull());
      ht.put("CAP\nPROVIDE",exgui.verification.CellFormat.getDateStringFormaterAllowNull());
      ht.put("NEXT\nAUDIT",exgui.verification.CellFormat.getDateStringFormaterAllowNull());
      ht.put("LAST AUDIT\nVALIDAY",exgui.verification.CellFormat.getDateStringFormaterAllowNull());
      pnllist=new Panel2List(dbhandl,8,iso,ht);
      pnllist._rowPosition=CURRENT_PAGE_INDEX;
      pnllist.gotoRowPosition(CURRENT_PAGE_INDEX);
      //jframe.getContentPane().add(Constans.PNL2QUERY);
      pnllist.setSize(750, 550);
      jframe.getContentPane().add(pnllist);
      jframe.repaint();
      jframe.show();
    }finally{
      util.PublicVariable.APP_FRAME.getContentPane().setCursor(new Cursor(
          Cursor.DEFAULT_CURSOR));
    }

  }

  class DataHandler extends exgui.ultratable.PagedDataFactoryAdapter{
    public Vector getRecords(int bgn,int rowcount)throws Exception{
      StringBuffer sb=new StringBuffer();
      sb.append("select ");
      sb.append("c.BUYER_NAME, ");
      sb.append("a.* ");
      /*
      sb.append("(select b.EXAM_DATE from FTY_EXAM_HISTORY b where b.NEXT_FTY_EXAM_SEQ=a.FTY_EXAM_SEQ) as last_exam_date, ");
      sb.append("(select b.REPLY_DATE from FTY_EXAM_HISTORY b where b.NEXT_FTY_EXAM_SEQ=a.FTY_EXAM_SEQ) as last_reply_date, ");
      sb.append("(select b.EXAM_REMARK from FTY_EXAM_HISTORY b where b.NEXT_FTY_EXAM_SEQ=a.FTY_EXAM_SEQ) as last_exam_remark ");
      */
      sb.append("from FTY_EXAM_HISTORY a ,FTY_EXAM_EMAIL c ");
      sb.append("where a.record_delete_flag='1' ");
      sb.append(" and c.seq=a.FTY_EXAM_EMAIL_SEQ ");
      if(null!=QRY_FIELD_MAKER_NAME){
       sb.append(" and a.MAKER_NAME like '");
       sb.append(util.MiscFunc.Replace(QRY_FIELD_MAKER_NAME,"'","''"));
       sb.append(QRY_FIELD_MAKER_NAME);
       sb.append("%' ");
      }
      if(null!=QRY_FIELD_BUYERSEQ){
        sb.append(" and a.FTY_EXAM_EMAIL_SEQ=");
        sb.append(QRY_FIELD_BUYERSEQ);
        sb.append(" ");
      }
      if(null!=QRY_FIELD_B4EXAMDATE){
        sb.append(" and a.EXAM_DATE<=");
        sb.append(oracleEncoder.encode(QRY_FIELD_B4EXAMDATE));
      }

      Vector vct=exgui2.CONST.BASIC_MAIN_EJB.getDatas(
         util.PublicVariable.USER_RECORD,
         sb.toString(),
         bgn,rowcount
      );
      return vct;
    }
  }

}
class Panel2List extends processhandler.template.PnlTableEditor{
  public javax.swing.JButton btnExit=new javax.swing.JButton("EXIT");
  public javax.swing.JButton btnADD=new javax.swing.JButton("ADD");
  Panel2List pnllistThis;
  public Panel2List(exgui.ultratable.PagedDataFactory pagedDataFxy,
                    int rowCounts,util.InsertionOrderedHashMap columnMapping,
                   java.util.Hashtable object2StringConvertor){

      super(pagedDataFxy, rowCounts, columnMapping, object2StringConvertor);

      btnADD.addActionListener(
        new AddBtnAction()
      );

      btnExit.addActionListener(
        new ExitBtnAction()
      );

      getLowerRightPanel().removeAll();
      getLowerRightPanel().add(btnADD);
      getLowerRightPanel().add(btnExit);
      getJtable().addMouseListener(new MouseListen());
      add(new javax.swing.JLabel("Click Any To Edit Detail "),java.awt.BorderLayout.NORTH);
      pnllistThis=this;
  }
  public class MyRenderer extends javax.swing.JLabel    implements javax.swing.table.TableCellRenderer{
    public MyRenderer(){
    super();
    setOpaque(true); /* it\u00B4s essential */
   }

  public java.awt.Component getTableCellRendererComponent(
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

  class MouseListen extends java.awt.event.MouseAdapter{
     public void mouseClicked(java.awt.event.MouseEvent me){
       if(getJtable().getSelectedRow()==-1)return;
       Record rec=(Record)getDisplayingRecords().get(getJtable().getSelectedRow());
       DlgEditFtyExamEvent dlg=new DlgEditFtyExamEvent(util.PublicVariable.APP_FRAME,
                                                       "Edit Audit Event",true,
                                                       pnllistThis,rec);
       dlg.setSize(570,300);
       exgui.UIHelper.setToScreenCenter(dlg);
       dlg.show();

       /*
       try{
         String buyerName = (String)rec.get("BUYER_NAME");
         int buyerSeq=rec.getInt("FTY_EXAM_EMAIL_SEQ");
         String makerName=(String)rec.get("MAKER_NAME");
         TgrEditFtyExamHistory tgr=new TgrEditFtyExamHistory(buyerSeq,buyerName,makerName);
         processhandler.template.Properties.getCenteralControler().doCommandExecute(tgr);
       }catch(Exception exp){
         exp.printStackTrace();
       }*/

     }
  }
  public class AddBtnAction implements java.awt.event.ActionListener{
    public void actionPerformed(java.awt.event.ActionEvent ae){
      try{
        Record rec = exgui2.CONST.BASIC_MAIN_EJB.getBlankRecord("FTY_EXAM_HISTORY_tbl");
        rec.set("record_delete_flag",-1);
        rec.set("record_create_user",util.PublicVariable.USER_RECORD.get(0));
        DlgEditFtyExamEvent dlg = new DlgEditFtyExamEvent(util.PublicVariable.
            APP_FRAME,
            "Add FTY-Audit", true,
            pnllistThis, rec);
        dlg.setSize(570, 300);
        exgui.UIHelper.setToScreenCenter(dlg);
        dlg.show();
      }catch(Exception exp){
        exp.printStackTrace();
      }
    }

  }
  public class ExitBtnAction implements java.awt.event.ActionListener{
    public void actionPerformed(java.awt.event.ActionEvent ae){
      try{
        processhandler.template.Properties.getCenteralControler().goBack();
      }catch(Exception exp){
        exp.printStackTrace();
      }
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
      this.getJtable().getColumnModel().getColumn(7).setCellRenderer(new MyRenderer());
     ((exgui.MultiClassTableModel)me.getJTable().getModel()).removeAllEditableColumn();
     getJtable().setRowHeight(52);
  }
}
