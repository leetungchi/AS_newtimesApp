package processhandler.template;
import processhandler.*;
import database.datatype.Record;
import exgui.ultratable.PagedDataFactory;
import javax.swing.*;
import java.awt.*;
import exgui.DataBindTextWithChecker;
import processhandler.commands.*;
/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class PnlEditBillMaster extends PnlFieldsEditor {
  JLabel jLabel1 = new JLabel();
  JTextField txtName = new JTextField();
  JComboBox jbxPaid = new JComboBox();
  JLabel jLabel2 = new JLabel();
  DataBindTextWithChecker txChk=null;
  Object obj2stv=exgui.verification.CellFormat.getOrdinaryFieldNotAllowNull(255);
  public PnlEditBillMaster(Record rec,PagedDataFactory pgfx) {
     super(rec,pgfx);
     try{
       jbInit();
     }catch(Exception e){
       e.printStackTrace();
     }
  }
  public PnlEditBillMaster() {
   super(null,null);
   try{
     jbInit();
   }catch(Exception e){
     e.printStackTrace();
   }
  }
  protected void jbInit()throws Exception{
    this.setLayout(null);
    jLabel1.setBackground(Color.white);
    jLabel1.setFont(new java.awt.Font("Dialog", 1, 11));
    jLabel1.setForeground(Color.blue);
    jLabel1.setAlignmentX((float) 0.0);
    jLabel1.setOpaque(true);
    jLabel1.setRequestFocusEnabled(true);
    jLabel1.setHorizontalAlignment(SwingConstants.CENTER);
    jLabel1.setText("NAME");
    jLabel1.setVerticalAlignment(SwingConstants.CENTER);
    jLabel1.setVerticalTextPosition(SwingConstants.CENTER);
    jLabel1.setBounds(new Rectangle(61, 60, 87, 26));
    txtName.setText("");
    txtName.setBounds(new Rectangle(149, 60, 97, 28));
    jbxPaid.setBounds(new Rectangle(149, 127, 97, 25));
    jLabel2.setBackground(UIManager.getColor("Desktop.background"));
    jLabel2.setFont(new java.awt.Font("Dialog", 1, 11));
    jLabel2.setForeground(Color.white);
    jLabel2.setOpaque(true);
    jLabel2.setHorizontalAlignment(SwingConstants.CENTER);
    jLabel2.setText("payment");
    jLabel2.setBounds(new Rectangle(63, 124, 87, 27));
    this.add(jLabel1, null);
    this.add(txtName, null);
    this.add(jbxPaid, null);
    this.add(jLabel2, null);
    jbxPaid.removeAllItems();
    jbxPaid.addItem("unpaid");
    jbxPaid.addItem("paid");
    /*
    if(recToMapping !=null){
       record2Gui();
    }
    */
    recordColumnsToCopy=new String[]{
      "paid","txn_user"
    };

  }

  public void doPrint() throws java.lang.Exception {
    /**@todo Implement this processhandler.DataProcesser abstract method*/
    throw new Exception("printing process is not implemented.");
  }
  public void record2Gui() {
    /**@todo Implement this processhandler.template.PnlFieldsEditor abstract method*/
    System.out.println("record to edit is"+recToMapping);
    try{
       txChk=new DataBindTextWithChecker(txtName,"txn_user",recToMapping.get("txn_user"),
       255,(exgui.Object2String)obj2stv,(exgui.ultratable.CellTxtEditorFormat)obj2stv);
       //txChk.getGUIcomponent().setEnabled(false);
       if(recToMapping.getInt("paid")>0){
          jbxPaid.setSelectedIndex(1);
       }
    }catch(Exception e){
       e.printStackTrace();
    }
  }
  public boolean gui2Record() {
    /**@todo Implement this processhandler.template.PnlFieldsEditor abstract method*/
    //if(txChk.getSelectedValue()==null){
    if(!txChk.isValidx()){
       return false;
    }else{
       //readyToUpdate=true;
    }
    try{
     recToMapping.set("txn_user",(String)txChk.getSelectedValue());
     recToMapping.set("paid",jbxPaid.getSelectedIndex());
     return true;
    }catch(Exception e){
      e.printStackTrace();
      return false;
    }
  }
  public void doAddNew(){
    try {
      super.doAddNew();
      //isGui2RecordOk is modified by the function "gui2Record" called by addNew/update function of super class
      if(!isGui2RecordOk) return;
      System.out.println("editing record is:"+recToMapping);
      Properties.getCenteralControler().setCurrentEditingMasterRecord(
          this.recToMapping
          );
       grayMe();//to set the gui field color to be gray,for user to identify as un-editable
      //let's proceed the process of editing detail.
      Properties.getCenteralControler().doCommandExecute(
          Properties.getCenteralControler().SHOW_DETAIL_OF_THIS_RECORD
          );
    }
    catch (Exception ex) {
      ex.printStackTrace();
    }
  }
  public void doUpdate(){
    try {
      super.doUpdate();
      //isGui2RecordOk is modified by the function "gui2Record" called by addNew/update function of super class
      if (!isGui2RecordOk) {
        return;
      }
      Properties.getCenteralControler().goBack();
    }
    catch (Exception ex) {
       ex.printStackTrace();
    }
  }
  public void doDelete(){
     super.doDelete();
    try {
      Properties.getCenteralControler().goBack();
    }
    catch (CommandException ex) {
      ex.printStackTrace();
    }
  }

}