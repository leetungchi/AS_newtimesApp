package newtimes.accounting.debit_note;

import java.awt.*;
import javax.swing.*;
import exgui.*;
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

public class DlgDrCrKindMaintain extends JDialog {
  JPanel panel1 = new JPanel();
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel1 = new BlueBkgWhiteCharLabel();
  JButton btnAdd = new JButton();
  JButton btnDelete = new JButton();
  JButton btnExit = new JButton();

  JTextField txtKindName = new JTextField();
  JButton btnUpdate = new JButton();
  DbDebitNoteKindHandler dbHanlder=new DbDebitNoteKindHandler();
  exgui.ultratable.PagedTablePanel Pnl2ListKind =null;
  JTextField txtUpdate = new JTextField();
  public DlgDrCrKindMaintain(Frame frame, String title, boolean modal) {
    super(frame, title, modal);
    try {
      util.InsertionOrderedHashMap iso=new util.InsertionOrderedHashMap();
      iso.put("NAME                       ","DBNT_KIND_DESC");
      Pnl2ListKind=new exgui.ultratable.PagedTablePanel(dbHanlder,
      99999,iso,new java.util.Hashtable());
      Pnl2ListKind.getJtable().addMouseListener(new MouseListen());
      jbInit();
      pack();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }
  class MouseListen extends java.awt.event.MouseAdapter{
    public void mouseClicked(java.awt.event.MouseEvent me){
      int row=Pnl2ListKind.getJtable().getSelectedRow();
      txtUpdate.setText((String) Pnl2ListKind.getJtable().getValueAt(row,0));
      btnDelete.setEnabled(true);
      btnUpdate.setEnabled(true);
      btnAdd.setEnabled(false);
      txtKindName.setText("");
    }
  }
  public DlgDrCrKindMaintain() {
    this(null, "", false);
  }

  private void jbInit() throws Exception {
    panel1.setLayout(null);
    blueBkgWhiteCharLabel1.setText("DEBIT NOTE KIND MAINTAIN");
    blueBkgWhiteCharLabel1.setBounds(new Rectangle(-1, 25, 400, 31));
    btnAdd.setBounds(new Rectangle(9, 263, 84, 27));
    btnAdd.setFont(new java.awt.Font("Dialog", 1, 11));
    btnAdd.setText("ADD");
    btnAdd.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnAdd_actionPerformed(e);
      }
    });
    btnDelete.setBounds(new Rectangle(317, 295, 75, 27));
    btnDelete.setFont(new java.awt.Font("Dialog", 1, 11));
    btnDelete.setText("DELETE");
    btnDelete.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnDelete_actionPerformed(e);
      }
    });
    btnExit.setBounds(new Rectangle(302, 263, 91, 27));
    btnExit.setFont(new java.awt.Font("Dialog", 1, 11));
    btnExit.setText("EXIT");
    btnExit.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnExit_actionPerformed(e);
      }
    });
    Pnl2ListKind.setBounds(new Rectangle(6, 69, 379, 187));
    txtKindName.setText("");
    txtKindName.setBounds(new Rectangle(93, 263, 202, 27));
    btnUpdate.setBounds(new Rectangle(9, 295, 84, 27));
    btnUpdate.setFont(new java.awt.Font("Dialog", 1, 11));
    btnUpdate.setText("UPDATE");
    btnUpdate.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnUpdate_actionPerformed(e);
      }
    });
    this.setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
    this.setResizable(true);
    txtUpdate.setBounds(new Rectangle(93, 295, 202, 27));
    getContentPane().add(panel1);
    panel1.add(blueBkgWhiteCharLabel1, null);
    panel1.add(Pnl2ListKind, null);
    panel1.add(btnAdd, null);
    panel1.add(txtKindName, null);
    panel1.add(btnUpdate, null);
    panel1.add(txtUpdate, null);
    panel1.add(btnExit, null);
    panel1.add(btnDelete, null);
    btnUpdate.setEnabled(false);
    btnDelete.setEnabled(false);
    btnAdd.setEnabled(false);
    txtKindName.addKeyListener(new keyListen());
    Object vftxtCollectionRemark = exgui.verification.CellFormat.getOrdinaryField(20);
        new exgui.DataBindTextWithChecker(txtKindName,
                                          "DBNT_COLLECT_DESC",
                                          null, 20,
                                          (exgui.Object2String)vftxtCollectionRemark,
                                          (exgui.ultratable.CellTxtEditorFormat)vftxtCollectionRemark);

        new exgui.DataBindTextWithChecker(txtUpdate,
                                          "DBNT_COLLECT_DESC",
                                          null, 20,
                                          (exgui.Object2String)vftxtCollectionRemark,
                                          (exgui.ultratable.CellTxtEditorFormat)vftxtCollectionRemark);

  }

  class keyListen extends java.awt.event.KeyAdapter{
    public void keyPressed(java.awt.event.KeyEvent ke){
       if(txtKindName.getText().trim().length()>0){
         btnAdd.setEnabled(true);
         btnDelete.setEnabled(false);
         btnUpdate.setEnabled(false);
         txtUpdate.setText("");
       }
       if(txtKindName.getText().trim().length()==0) btnAdd.setEnabled(false);
    }
  }

  void btnAdd_actionPerformed(ActionEvent e) {
     String value2add=txtKindName.getText().trim().toUpperCase();
     for(int i=0;i<Pnl2ListKind.getJtable().getRowCount();i++){
       String txt=(String)Pnl2ListKind.getJtable().getValueAt(i,0);
       if(txt.equals(value2add)){
         exgui.verification.VerifyLib.showAlert("Kind Duplicated!!",
                                                "Kind Duplicated!!");
         return;
       }
     }
     try{
       Record recNewRec = dbHanlder.getBlankRecord();
       recNewRec.set(0,0);
       recNewRec.set(1,value2add);
       recNewRec.set("Record_create_user",util.PublicVariable.USER_RECORD.get(0));
       dbHanlder.addRecord(recNewRec);
       Pnl2ListKind.reload();
       txtKindName.setText("");
       btnAdd.setEnabled(false);
       btnUpdate.setEnabled(false);
       btnDelete.setEnabled(false);
     }catch(Exception exp){
       exp.printStackTrace();
     }
  }

  void btnDelete_actionPerformed(ActionEvent e) {
    int row=Pnl2ListKind.getJtable().getSelectedRow();
    if(row==-1){
      exgui.verification.VerifyLib.showAlert("Please Assign Row To Delete",
                                             "Please Assign Row To Delete");
      return ;
    }
   if(!exgui.verification.VerifyLib.showConfirm("Are You Sure To Delete ?","Are You Sure ?",false) ) return;
    Record rec=(Record)Pnl2ListKind.getDisplayingRecords().get(row);
    try{
      if (rec.getInt("used_count") > 0) {
        exgui.verification.VerifyLib.showAlert("KIND NAME USED,Can Not Delete","Record Referenced");
        return;
      }
      rec.set("record_delete_user",util.PublicVariable.USER_RECORD.get(0));
      rec.set("record_delete_flag","0");
      rec.set("record_modify_user",util.PublicVariable.USER_RECORD.get(0));
      java.util.Vector vct=new java.util.Vector();
      vct.add(rec);
      dbHanlder.updateRecords(vct);
      Pnl2ListKind.reload();
      txtUpdate.setText("");
      btnAdd.setEnabled(false);
      btnUpdate.setEnabled(false);
      btnDelete.setEnabled(false);

    }catch(Exception exp){
      exp.printStackTrace();
    }
  }

  void btnExit_actionPerformed(ActionEvent e) {
    try{
      newtimes.accounting.debit_note.Constans.VCT_DEBITNOTE_KIND =
          exgui2.CONST.BASIC_MAIN_EJB.getDatas(
          util.PublicVariable.USER_RECORD,
          "select a.*,to_char(a.dbnt_kind_seq) as seq_str from DEBITNOTE_KIND a where a.record_delete_flag='1'",
          1, 9999999);
    }catch(Exception exp){
      exp.printStackTrace();
    }

    this.dispose();
  }

  void btnUpdate_actionPerformed(ActionEvent e) {
    int row=Pnl2ListKind.getJtable().getSelectedRow();
    String value2add=txtUpdate.getText().trim();
    if(value2add.length()==0){
      exgui.verification.VerifyLib.showAlert("Please Assigned Kind Name","Please Assigned Kind Name");
      return ;
    }
    for(int i=0;i<Pnl2ListKind.getJtable().getRowCount();i++){
      if(i==row)continue;
      String txt=(String)Pnl2ListKind.getJtable().getValueAt(i,0);
      if(txt.equals(value2add)){
        exgui.verification.VerifyLib.showAlert("Kind Duplicated!!",
                                               "Kind Duplicated!!");
        return;
      }
    }
    Record rec=(Record)Pnl2ListKind.getDisplayingRecords().get(row);
    rec.set(1,value2add);
    //set "record_modify_user"
    rec.set(2,util.PublicVariable.USER_RECORD.get(0));
    java.util.Vector vct=new java.util.Vector();
    vct.add(rec);
    try{
      dbHanlder.updateRecords(vct);
      Pnl2ListKind.reload();
      return;
    }catch(Exception exp){
      exp.printStackTrace();
    }
  }
}
