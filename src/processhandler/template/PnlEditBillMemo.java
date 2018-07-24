package processhandler.template;
import javax.swing.*;
import processhandler.*;
import processhandler.*;
import database.datatype.Record;
import exgui.ultratable.PagedDataFactory;
import javax.swing.*;
import java.awt.*;
import exgui.DataBindTextWithChecker;
import java.util.Vector;

/**
 * <p>Title:an Instance of "PnlFieldsEditor"--Panel of Editing Memo field of a bill table.</p>
 * <p>Description: an example of detail editor under 1(bill_master):1(bill_memo) relation.</p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company:metak.com.tw </p>
 * @author:Crazy john
 * @version 1.0
 */

public class PnlEditBillMemo extends PnlFieldsEditor {
  JLabel jLabel1 = new JLabel();
  JTextField txtMemo = new JTextField();
  public PnlEditBillMemo(DB_BillMEMO  pgdb) {
    super(null,pgdb);
    recordColumnsToCopy=new String[]{
      "txn_memo"
    };
    try{
     ((DB_BillMEMO)pgdb).setKeyWord(
      (String)Properties.getCenteralControler().
         getCurrentEditingMasterRecord().get("txn_date")
     );
      Vector vct = dbprc.getRecords(1, 1);
      if (vct.size() > 0) {
         recToMapping=(Record)vct.get(0);
      }else{
         recToMapping=dbprc.getBlankRecord();
         recToMapping.set("txn_date",((DB_BillMEMO)pgdb).keywordFromQryGUI);
      }
     jbInit();
     record2Gui();
    }catch(Exception e){
       e.printStackTrace();
    }
  }
  protected void jbInit() throws java.lang.Exception {
    /**@todo Implement this processhandler.template.PnlFieldsEditor abstract method*/
    setLayout(null);
    jLabel1.setBackground(Color.white);
    jLabel1.setFont(new java.awt.Font("Dialog", 1, 11));
    jLabel1.setForeground(Color.blue);
    jLabel1.setAlignmentX((float) 0.0);
    jLabel1.setOpaque(true);
    jLabel1.setRequestFocusEnabled(true);
    jLabel1.setHorizontalAlignment(SwingConstants.CENTER);
    jLabel1.setText("MEMO");
    jLabel1.setVerticalAlignment(SwingConstants.CENTER);
    jLabel1.setVerticalTextPosition(SwingConstants.CENTER);
    jLabel1.setBounds(new Rectangle(19, 59, 87, 26));
    this.setLayout(null);
    txtMemo.setText("");
    txtMemo.setBounds(new Rectangle(107, 60, 236, 27));
    this.add(jLabel1, null);
    this.add(txtMemo, null);
  }
  public void doPrint() throws java.lang.Exception {
    /**@todo Implement this processhandler.DataProcesser abstract method*/
    throw new Exception(" printing function not supported");
  }
  public void record2Gui() {
    /**@todo Implement this processhandler.template.PnlFieldsEditor abstract method*/
    try{
      String value = (String) recToMapping.get("txn_memo");
      if (value == null)
        value = "";
      txtMemo.setText(value);
    }catch(Exception e){
       e.printStackTrace();
    }
  }
  public boolean gui2Record() {
    /**@todo Implement this processhandler.template.PnlFieldsEditor abstract method*/
    try{
      String value=txtMemo.getText();
      recToMapping.set("txn_memo",value);
      return true;
    }catch(Exception e){
       e.printStackTrace();
       return true;
    }

  }
}