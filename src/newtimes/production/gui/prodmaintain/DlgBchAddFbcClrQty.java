package newtimes.production.gui.prodmaintain;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import java.util.Vector;
import newtimes.production.process.prodmaintain.*;
import newtimes.production.gui.prodmaintain.*;
import database.datatype.Record;
/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class DlgBchAddFbcClrQty extends JDialog {
  JPanel panel1 = new JPanel();
  JButton btnOK = new JButton();
  JButton btnCancel = new JButton();
  JScrollPane jScrollPane1 = new JScrollPane();
  JPanel pnlItems = new JPanel();
  GridLayout gridLayout1 = null;
  BorderLayout borderLayout2 = new BorderLayout();
  JLabel jLabel1 = new JLabel();
  public static int STATUS_OPERATING=0;
  public static int STATUS_CLOSE_NORMALLY=1;
  public static int STATUS_CLOSE_CANCEL=2;
  protected int myOperationStatus;
  DB_FabricColorQtyYieldCul myHanlder;
  Vector prodColors;
  JCheckBox  chkboxColors[];

  public DlgBchAddFbcClrQty(Frame frame, String title, boolean modal,
                            DB_FabricColorQtyYieldCul  handler
                            ) {
    super(frame, title, modal);
    try {
      myHanlder=handler;
      if(handler!=null){
        prodColors=handler.getColors();
      }
      jbInit();
      pack();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }

  public DlgBchAddFbcClrQty() {
    this(null, "", false,null);
  }
  public int getOperationStatus(){
    return myOperationStatus;
  }
  public void show(){
    this.myOperationStatus=STATUS_OPERATING;
    super.show();
  }
  private void jbInit() throws Exception {
    panel1.setLayout(null);
    this.getContentPane().setLayout(borderLayout2);
    btnOK.setBounds(new Rectangle(16, 285, 138, 27));
    btnOK.setFont(new java.awt.Font("Dialog", 1, 11));
    btnOK.setText("ADD RECORDS");
    btnOK.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnOK_actionPerformed(e);
      }
    });
    btnCancel.setBounds(new Rectangle(226, 284, 157, 27));
    btnCancel.setFont(new java.awt.Font("Dialog", 1, 11));
    btnCancel.setText("CANCEL");
    btnCancel.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnCancel_actionPerformed(e);
      }
    });

    jScrollPane1.setBounds(new Rectangle(14, 40, 371, 228));
    jLabel1.setFont(new java.awt.Font("Dialog", 1, 11));
    jLabel1.setText("Please Chose Colors To Add");
    jLabel1.setBounds(new Rectangle(19, 12, 359, 23));
    getContentPane().add(panel1,  BorderLayout.CENTER);
    panel1.add(btnOK, null);
    panel1.add(btnCancel, null);
    panel1.add(jLabel1, null);
    panel1.add(jScrollPane1, null);
    if(prodColors!=null){
          gridLayout1=new GridLayout(prodColors.size(),1);
          chkboxColors=new JCheckBox[prodColors.size()];
          for(int i=0;i<prodColors.size();i++){
             Record rec=(Record)prodColors.get(i);
             chkboxColors[i]=new JCheckBox((String)rec.get(1),false);//get Color Name
             pnlItems.add(chkboxColors[i]);
          }
          pnlItems.setLayout(gridLayout1);
    }
    jScrollPane1.getViewport().add(pnlItems, null);
  }

  void btnCancel_actionPerformed(ActionEvent e) {
     myOperationStatus=STATUS_CLOSE_CANCEL;
     this.dispose();
  }

  void btnOK_actionPerformed(ActionEvent e) {
      //check if all the fileds ready
      newtimes.production.ProdMaintain_Properties.setWaitCursor();
      this.setCursor(new Cursor(Cursor.WAIT_CURSOR));
      try{
        Vector vctRec=new Vector();
        for(int i=0;i<chkboxColors.length;i++){
           if(chkboxColors[i].isSelected()){
             database.datatype.Record rec = myHanlder.getBlankRecord();
             rec.set("prod_color_pk",
                     ((Record)prodColors.get(i)).get(0));
             vctRec.add(rec);
           }
        }
        if(vctRec.size()==0)return;
        myHanlder.addRecords(vctRec);
        myOperationStatus=STATUS_CLOSE_NORMALLY;
        this.dispose();
      }catch(Exception exp){
        exp.printStackTrace();
        util.ExceptionLog.exp2File(exp,"add records problem occures");
        exgui.verification.VerifyLib.showAlert("Server Side Error\nPlease Contact System Manager",
                                               "Exception while Add Production Records");
      }finally{
         newtimes.production.ProdMaintain_Properties.setNormalCursor();
         this.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
      }
  }
}
