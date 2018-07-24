package newtimes.accounting.debit_note_user;

import java.awt.*;
import exgui.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;
import database.datatype.Record;
/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class PnlLisDebitNoteUser extends JPanel {
  WhiteBkgBlueCharLabel whiteBkgBlueCharLabel1 = new WhiteBkgBlueCharLabel();
  JButton btnAddNew = new JButton();
  JButton btnExit = new JButton();
  Panel2List Pnl2Contain ;
  //JPanel Pnl2Contain=new JPanel() ;
  static int CURRENT_ROW_POSITION=1;
  PnlLisDebitNoteUser justThis;
  public PnlLisDebitNoteUser() {
    try {
      util.InsertionOrderedHashMap iso=new util.InsertionOrderedHashMap();
      iso.put("USER CODE","USR_CODE");
      iso.put("姓       名","USR_NAME");
      iso.put("英文名稱","USR_ENG_NAME");
      iso.put("          REMARK         ","REMARK_1");

      Pnl2Contain=new Panel2List(Constants.USR_HANDLER_DB ,25,iso,new Hashtable());

      jbInit();
      justThis=this;
    } catch(Exception ex) {
      ex.printStackTrace();
    }
  }

  void jbInit() throws Exception {
    whiteBkgBlueCharLabel1.setText("DEBIT NOTE USER MAINTAIN -- LIST");
    whiteBkgBlueCharLabel1.setBounds(new Rectangle(-1, 15, 802, 30));
    this.setBackground(new Color(202, 202, 224));
    this.setForeground(Color.black);
    this.setLayout(null);
    btnAddNew.setBounds(new Rectangle(90, 537, 112, 31));
    btnAddNew.setFont(new java.awt.Font("Dialog", 1, 11));
    btnAddNew.setText("ADD NEW");
    btnAddNew.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnAddNew_actionPerformed(e);
      }
    });
    btnExit.setBounds(new Rectangle(529, 537, 112, 31));
    btnExit.setFont(new java.awt.Font("Dialog", 1, 11));
    btnExit.setText("EXIT");
    btnExit.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnExit_actionPerformed(e);
      }
    });
    Pnl2Contain.setBounds(new Rectangle(14, 48, 772, 477));
    this.add(btnExit, null);
    this.add(btnAddNew, null);
    this.add(Pnl2Contain, null);
    this.add(whiteBkgBlueCharLabel1, null);
    Pnl2Contain.reload();
    Pnl2Contain.getJtable().addMouseListener(new Act2Listen());
  }
  class Act2Listen extends java.awt.event.MouseAdapter{
    public void mouseClicked(java.awt.event.MouseEvent me){
      Record rec=
          (Record)Pnl2Contain.getDisplayingRecords().get(
           Pnl2Contain.getJtable().getSelectedRow());
       try{
         DlgDbCrUsr dlg = new
             DlgDbCrUsr(util.PublicVariable.APP_FRAME, "Edit DEBIT NOTE USER", true, justThis, Constants.USR_HANDLER_DB,rec);
         dlg.setSize(460,360);
         //user code can not be edit.
         dlg.pnlEditDebitNoteUser.txtUsrCode.setEditable(false);
         exgui.UIHelper.setToScreenCenter(dlg);
         dlg.show();
       }catch(Exception exp){
         exp.printStackTrace();
       }

    }
  }
  public void RefreshList(){
    Pnl2Contain.reload();
  }
  void btnExit_actionPerformed(ActionEvent e) {
    try{
      processhandler.template.Properties.getCenteralControler().goBack();
    }catch(Exception exp){
      exp.printStackTrace();
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
    public void refineEditors(exgui.ultratable.MultiEditorJTable me ){}


  }

  void btnAddNew_actionPerformed(ActionEvent e) {
    try{
      DlgDbCrUsr dlg = new
          DlgDbCrUsr(util.PublicVariable.APP_FRAME, "Add DEBIT NOTE USER", true, this,
                     Constants.USR_HANDLER_DB,
                     Constants.USR_HANDLER_DB.getBlankRecord());
      dlg.setSize(460,360);
      exgui.UIHelper.setToScreenCenter(dlg);
      dlg.show();
    }catch(Exception exp){
      exp.printStackTrace();
    }

  }

}
