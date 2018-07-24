package newtimes.accounting.local_voucher;
import javax.swing.*;
import java.awt.*;
import javax.swing.*;
import database.datatype.Record;
/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class DlgMkrInfor4LocalVoucherPrint extends DlgMkrInfor {
  JCheckBox chkCommAmt = new JCheckBox();
  JCheckBox chkExRate = new JCheckBox();
  JCheckBox chkDiffAmt = new JCheckBox();
  JCheckBox chkNtAmt = new JCheckBox();

  public DlgMkrInfor4LocalVoucherPrint(Frame frame, String title, boolean modal,Record _rec) {
    super(frame, title, modal,_rec);
    try {
      jbInit();
      afterInit();
      pack();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }

  public DlgMkrInfor4LocalVoucherPrint() {
    this(null, "", false,null);
  }
  protected void jbInit()throws Exception{
    super.jbInit();
  }
  protected void afterInit(){
    /*panel1.remove(btnExit);
    panel1.remove(btnDelete);
    panel1.remove(btnUpdate);*/

  btnUpdate.setBounds(new Rectangle(27, 345, 108, 32));
  btnDelete.setBounds(new Rectangle(173, 345, 81, 32));
  btnExit.setBounds(new Rectangle(303, 345, 81, 32));

    chkCommAmt.setFont(new java.awt.Font("Dialog", 1, 11));
    chkCommAmt.setSelected(true);
    chkCommAmt.setText("COMM AMT.");
    chkCommAmt.setBounds(new Rectangle(27, 280, 108, 24));
    chkExRate.setBounds(new Rectangle(183, 280, 108, 24));
    chkExRate.setText("EX RATE");
    chkExRate.setFont(new java.awt.Font("Dialog", 1, 11));
    chkExRate.setSelected(false);
    chkDiffAmt.setFont(new java.awt.Font("Dialog", 1, 11));
    chkDiffAmt.setSelected(false);
    chkDiffAmt.setText("DIFF-AMT");
    chkDiffAmt.setBounds(new Rectangle(183, 306, 108, 24));
    chkNtAmt.setBounds(new Rectangle(27, 306, 108, 24));
    chkNtAmt.setText("NT-AMT");
    chkNtAmt.setFont(new java.awt.Font("Dialog", 1, 11));
    chkNtAmt.setSelected(false);

    panel1.add(chkCommAmt, null);
    panel1.add(chkExRate, null);
    panel1.add(chkDiffAmt, null);
    panel1.add(chkNtAmt, null);


    /*panel1.add(btnExit);
    panel1.add(btnDelete);
    panel1.add(btnUpdate);*/

  }
}
