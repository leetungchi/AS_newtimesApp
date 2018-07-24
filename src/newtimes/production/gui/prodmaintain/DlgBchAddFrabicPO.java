package newtimes.production.gui.prodmaintain ;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import java.util.Vector;
import newtimes.production.process.prodmaintain.*;
import database.datatype.Record;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class DlgBchAddFrabicPO extends JDialog {
  JPanel panel1 = new JPanel();
  JButton btnOK = new JButton();
  JButton btnCancel = new JButton();
  JScrollPane jScrollPane1 = new JScrollPane();
  JPanel pnlItems = new JPanel();
  GridLayout gridLayout1 =new GridLayout(20,1);
  BorderLayout borderLayout2 = new BorderLayout();
  JLabel jLabel1 = new JLabel();
  public static int STATUS_OPERATING=0;
  public static int STATUS_CLOSE_NORMALLY=1;
  public static int STATUS_CLOSE_CANCEL=2;
  protected int myOperationStatus;
  DB_FrabricPO  myHanlder;
  JTextField txtStyles[]=new JTextField[20];
  public DlgBchAddFrabicPO(Frame frame, String title, boolean modal,
                            DB_FrabricPO   handler
                            ) {
    super(frame, title, modal);
    try {
      myHanlder=handler;
      jbInit();
      pack();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }

  public DlgBchAddFrabicPO() {
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
    gridLayout1.setVgap(10);
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
    jLabel1.setText("Please Fill Fabric PO. No. In Columns Below.");
    jLabel1.setBounds(new Rectangle(19, 12, 359, 23));
    getContentPane().add(panel1,  BorderLayout.CENTER);
    panel1.add(btnOK, null);
    panel1.add(btnCancel, null);
    panel1.add(jLabel1, null);
    panel1.add(jScrollPane1, null);
    pnlItems.setLayout(gridLayout1);
    for(int i=0;i<20;i++){
      txtStyles[i]=new JTextField();
      pnlItems.add(txtStyles[i]);
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
        int FABRIC_PO_CLM_AT=
            util.MiscFunc.getFieldIndexAtRecord(myHanlder.getBlankRecord(),"FAB_PO");
        for(int i=0;i<20;i++){
           if(txtStyles[i].getText().trim().length()>0){
             if(txtStyles[i].getText().trim().length()>20){
               exgui.verification.VerifyLib.showPlanMsg("Fabric PO Can Not Over Than 20 Characters",
                                                        "Fabric PO Can Not Over Than 20 Characters");
               txtStyles[i].selectAll();
               txtStyles[i].grabFocus();
               return;
             }
             database.datatype.Record rec = myHanlder.getBlankRecord();
             rec.set(FABRIC_PO_CLM_AT,txtStyles[i].getText());//set string to Fabric PO column
             //rec.set(3," ");
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
