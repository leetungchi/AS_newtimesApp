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

public class DlgBchAddFabClr4StyConsum extends JDialog {
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
  DB_FbcClrQty myHanlder;
  Vector fabColors;
  JCheckBox  chkboxColors[];
  PnlListStyleConsumption pnl;
  public DlgBchAddFabClr4StyConsum(Frame frame, String title, boolean modal,
                            DB_FbcClrQty  handler,PnlListStyleConsumption _pnl
                            ) {
    super(frame, title, modal);
    pnl=_pnl;
    try {
      myHanlder=handler;
      if(handler!=null){
        fabColors=handler.getFabPo2Select();
      }
      jbInit();
      pack();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }

  public DlgBchAddFabClr4StyConsum() {
    this(null, "", false,null,null);
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
    jLabel1.setText("Please Select Fabric-Colors To Add");
    jLabel1.setBounds(new Rectangle(19, 12, 359, 23));
    getContentPane().add(panel1,  BorderLayout.CENTER);
    panel1.add(btnOK, null);
    panel1.add(btnCancel, null);
    panel1.add(jLabel1, null);
    panel1.add(jScrollPane1, null);
    if(fabColors!=null){
          gridLayout1=new GridLayout(fabColors.size(),1);
          chkboxColors=new JCheckBox[fabColors.size()];
          for(int i=0;i<fabColors.size();i++){
             Record rec=(Record)fabColors.get(i);
             chkboxColors[i]=new JCheckBox((String)rec.get("compose"),false);//get Color Name
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
      util.MiscFunc.showProcessingMessage();
      try{
        Vector vctRec=new Vector();
        for(int i=0;i<chkboxColors.length;i++){
           if(chkboxColors[i].isSelected()){
             database.datatype.Record rec = myHanlder.getBlankRecord();
             Record recFabRec=(Record)fabColors.get(i);
             rec.set(0,-1);//FCQ_PK
             rec.set(1,recFabRec.get(0));//"FCQ_SEQ"
             rec.set(3,recFabRec.get(7));//FCQD_STY_QTY1,default by--DEF_YY1
             vctRec.add(rec);
           }
        }
        if(vctRec.size()==0)return;
        if(pnl!=null)pnl.doUpdate();
        myHanlder.addRecords(vctRec);
        myOperationStatus=STATUS_CLOSE_NORMALLY;
        this.dispose();
        util.MiscFunc.hideProcessingMessage();
      }catch(Exception exp){
        exp.printStackTrace();
        util.ExceptionLog.exp2File(exp,"add records problem occures");
        exgui.verification.VerifyLib.showAlert("Server Side Error\nPlease Contact System Manager",
                                               "Exception while Add Production Records");
      }finally{
        util.MiscFunc.hideProcessingMessage();
         newtimes.production.ProdMaintain_Properties.setNormalCursor();
         this.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
      }
  }
}
