package newtimes.production.gui.prodmaintain;
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

public class DldBchAddStyles extends JDialog {
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
  DB_StyleListHandler myHanlder;
  JTextField txtStyles[]=new JTextField[20];
  String _styNo2Follow=null;
  public DldBchAddStyles(Frame frame, String title, boolean modal,
                            DB_StyleListHandler   handler
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

  public DldBchAddStyles() {
    this(null, "", false,null);
  }
  public int getOperationStatus(){
    return myOperationStatus;
  }
  public void show(){
    this.myOperationStatus=STATUS_OPERATING;
    super.show();
  }
  protected void jbInit() throws Exception {
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
    jLabel1.setText("Please Fill Style No In Columns Below.");
    jLabel1.setBounds(new Rectangle(19, 12, 359, 23));
    getContentPane().add(panel1,  BorderLayout.CENTER);
    panel1.add(btnOK, null);
    panel1.add(btnCancel, null);
    panel1.add(jLabel1, null);
    panel1.add(jScrollPane1, null);
    pnlItems.setLayout(gridLayout1);
    for(int i=0;i<20;i++){
      txtStyles[i]=new JTextField();
      //to limit length
      exgui.DataBindText dbtxt=
          new exgui.DataBindText(txtStyles[i],"",null,30);
      Object objIntVfy=exgui.verification.CellFormat.getDoubleFormat(7,2);

      pnlItems.add(txtStyles[i]);
    }
    jScrollPane1.getViewport().add(pnlItems, null);
  }

  void btnCancel_actionPerformed(ActionEvent e) {
     myOperationStatus=STATUS_CLOSE_CANCEL;
     this.dispose();
  }
  public void setStyNo2Follow(String styNo2Follow){
    _styNo2Follow=styNo2Follow;
  }
  void btnOK_actionPerformed(ActionEvent e) {
      //check if all the fileds ready
      newtimes.production.ProdMaintain_Properties.setWaitCursor();
      this.setCursor(new Cursor(Cursor.WAIT_CURSOR));
      try{
        int STY_VENDER_ISSUE_AT=0;
        java.sql.Date nowDate=new java.sql.Date(System.currentTimeMillis());



        Vector vctRec=new Vector();
        String userId=
            (String)util.PublicVariable.USER_RECORD.get("USR_CODE");
        String ct_dest_Default=(String)newtimes.preproduction.Constants.CURRENT_PREPROD_HEAD_RECORD.get("PRODUCTION_SC_DEST");
        String ct_prx_trm_Default=(String)newtimes.preproduction.Constants.CURRENT_PREPROD_HEAD_RECORD.get("PROduction_SC_PRC_TRM");
        String ct_currency_Default=(String)newtimes.preproduction.Constants.CURRENT_PREPROD_HEAD_RECORD.get("PRODUCTION_SC_CURRENCY");
        String curr_sc_no=null;

         try{
          curr_sc_no= (String)newtimes.preproduction.Constants.CURRENT_PREPROD_HEAD_RECORD.
               get("PRODUCTION_SC_NO");
         }catch(Exception exp1){

         }
         try{
          curr_sc_no= (String)newtimes.preproduction.Constants.CURRENT_PREPROD_HEAD_RECORD.
               get("PROD_SC_NO");
         }catch(Exception exp2){

         }


        for(int i=0;i<20;i++){
           if(txtStyles[i].getText().trim().length()>0){
             if(txtStyles[i].getText().trim().length()>30){
               exgui.verification.VerifyLib.showPlanMsg("Style No Can Not Over Than 30 Characters",
                                                        "Style No Can Not Over Than 30 Characters");
               txtStyles[i].selectAll();
               txtStyles[i].grabFocus();
               return;
             }
             database.datatype.Record rec = myHanlder.getBlankRecord();
             if(STY_VENDER_ISSUE_AT==0){
               STY_VENDER_ISSUE_AT=
                   util.MiscFunc.getFieldIndexAtRecord(rec,"STY_VENDER_ISSUE");
             }
             //note if production type is Sample,Buyer Commision is 0
             rec.set(STY_VENDER_ISSUE_AT,nowDate);
             rec.set("record_create_user",userId);
             rec.set(2,txtStyles[i].getText().trim().toUpperCase());//set string to STYLE.STY_STYLE column
             //rec.set(3," ");
             //rec.set("sty_ct_currency","USD");
             rec.set("sty_ct_currency",ct_currency_Default);
             rec.set("sty_ct_dest",ct_dest_Default);//".");
             rec.set("sty_ct_prc_trm",ct_prx_trm_Default);//"FOB");
             if(curr_sc_no!=null)rec.set("sty_sc_no",curr_sc_no);
             vctRec.add(rec);
           }
        }
        if(vctRec.size()==0)return;
        myHanlder.addRecords(vctRec,_styNo2Follow);
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
