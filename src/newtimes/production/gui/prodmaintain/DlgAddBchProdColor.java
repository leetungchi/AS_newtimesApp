package newtimes.production.gui.prodmaintain;
import newtimes.production.process.prodmaintain.DB_ProdColorHandler;
import java.awt.*;
import javax.swing.*;
import java.util.Vector;
import java.awt.event.*;
/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class DlgAddBchProdColor extends JDialog {
  JPanel panel1 = new JPanel();
  Vector orgProdColorName=null;
  Vector orgProdColorCode=null;

  JButton btnOK = new JButton();
  JButton btnCancel = new JButton();
  JScrollPane jScrollPane1 = new JScrollPane();
  JPanel pnlItems = new JPanel();
  GridLayout gridLayout1 = new GridLayout(20,2);
  JTwinText jcbxgroup[]=new JTwinText[20];
  String colorCodes[];
  String colorNames[];
  String colorRemarks[];
  BorderLayout borderLayout2 = new BorderLayout();
  JLabel jLabel1 = new JLabel();
  JLabel jLabel2 = new JLabel();
  JLabel jLabel3 = new JLabel();
  public static int STATUS_OPERATING=0;
  public static int STATUS_CLOSE_NORMALLY=1;
  public static int STATUS_CLOSE_CANCEL=2;
  protected int myOperationStatus;
  DB_ProdColorHandler myHanlder;
  public DlgAddBchProdColor(Frame frame, String title, boolean modal,
                            DB_ProdColorHandler handler,
                            String[] prodColorName,
                            String[] prodColorCode,
                            String[] prodColorRemark) {
    super(frame, title, modal);
    try {
      colorCodes=prodColorCode;
      colorNames=prodColorName;
      colorRemarks=prodColorRemark;
      myHanlder=handler;
      jbInit();
      pack();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }

  public DlgAddBchProdColor() {
    this(null, "", false,null,null,null,null);
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
    pnlItems.setLayout(gridLayout1);
    jScrollPane1.setBounds(new Rectangle(14, 40, 450, 228));

    jLabel1.setFont(new java.awt.Font("Dialog", 1, 11));
    jLabel1.setText("Color Name");
    jLabel1.setBounds(new Rectangle(56, 12, 74, 23));

    jLabel2.setBounds(new Rectangle(200, 13, 89, 23));
    jLabel2.setFont(new java.awt.Font("Dialog", 1, 11));
    jLabel2.setText("Color Code");

    jLabel3.setBounds(new Rectangle(360, 14, 104, 23));
    jLabel3.setFont(new java.awt.Font("Dialog", 1, 11));
    jLabel3.setText("Remark");

    getContentPane().add(panel1,  BorderLayout.CENTER)
        ;
    panel1.add(btnOK, null);
    panel1.add(btnCancel, null);
    panel1.add(jLabel2, null);
    panel1.add(jLabel1, null);
    panel1.add(jLabel3, null);
    panel1.add(jScrollPane1, null);
    if(colorCodes!=null){
      for(int i=0;i<20;i++){
        jcbxgroup[i]=new JTwinText();
        exgui.DataBindText dbtxt=
            new exgui.DataBindText(jcbxgroup[i].txtCode,"",null,5);
        exgui.DataBindText dbtxt2=
            new exgui.DataBindText(jcbxgroup[i].txtName,"",null,80);
        exgui.DataBindText dbtxt3=
            new exgui.DataBindText(jcbxgroup[i].txtRemark,"",null,30);
        pnlItems.add(jcbxgroup[i]);
        if(i<colorNames.length){
          jcbxgroup[i].txtName.setText(colorNames[i]);
          jcbxgroup[i].txtCode.setText(colorCodes[i]);
          jcbxgroup[i].txtCode.setText(colorRemarks[i]);
        }
      }

    }else{
      for(int i=0;i<20;i++){
        jcbxgroup[i]=new JTwinText();
        //limit the length
        exgui.DataBindText dbtxt=
            new exgui.DataBindText(jcbxgroup[i].txtCode,"",null,5);
        exgui.DataBindText dbtxt2=
            new exgui.DataBindText(jcbxgroup[i].txtName,"",null,80);
        exgui.DataBindText dbtxt3=
            new exgui.DataBindText(jcbxgroup[i].txtRemark,"",null,30);
        pnlItems.add(jcbxgroup[i]);
      }
    }
    jScrollPane1.getViewport().add(pnlItems, null);
  }

  void btnCancel_actionPerformed(ActionEvent e) {
     myOperationStatus=STATUS_CLOSE_CANCEL;
     this.dispose();
  }

  void btnOK_actionPerformed(ActionEvent e) {
      //check if all the fileds ready
      java.util.HashMap hm=new java.util.HashMap();
      newtimes.production.ProdMaintain_Properties.setWaitCursor();
      this.setCursor(new Cursor(Cursor.WAIT_CURSOR));
       boolean isNeed2ChkColorCode=(!(util.PublicVariable.OPERATTING_CENTER.equals("NTHK")||util.PublicVariable.OPERATTING_CENTER.equals("001")));
      try{
        database.datatype.Record rec = myHanlder.getBlankRecord();
        Vector vctRec=new Vector();
        for (int i = 0; i < 20; i++) {
           if(jcbxgroup[i].txtName.getText().trim().length()>0){
             String colorName=jcbxgroup[i].txtName.getText().trim().toUpperCase();
             String colorCode=jcbxgroup[i].txtCode.getText().trim().toUpperCase();
             String colorRemark=jcbxgroup[i].txtRemark.getText().trim().toUpperCase();
             if(colorName.getBytes().length>80){
               exgui.verification.VerifyLib.showPlanMsg("Color Name Not Over 80 bytes",
                                                        "Color Name Not Over 80 bytes");
               jcbxgroup[i].txtName.selectAll();
               return;
             }
             if(colorCode.getBytes().length>5){
               exgui.verification.VerifyLib.showPlanMsg("Color Code Not Over 5 Characters",
                                                        "Color Code Not Over 5 Characters");
               jcbxgroup[i].txtCode.selectAll();
               return;
             }
             if(isNeed2ChkColorCode){
               if (colorCode.length() == 0) {
                 exgui.verification.VerifyLib.showPlanMsg(
                     "Please Input Color Code",
                     "Please Input Color Code");
                 jcbxgroup[i].txtCode.selectAll();
                 return;
               }
             }


             database.datatype.Record rec2add=
                 (database.datatype.Record)util.MiscFunc.deepCopy(rec);
             rec2add.set(2,colorName);//PROD_COLOR_NAME
             rec2add.set(3,colorCode);//PROD_COLOR_CODE
             rec2add.set(12,colorRemark);//PROD_COLOR_REMARK
             if((colorName==null || colorName.trim().length()==0) &&
                (colorCode==null || colorCode.trim().length()==0)
                )continue;

             vctRec.add(rec2add);

           }
        }

        if(vctRec.size()==0)return;
        util.MiscFunc.showProcessingMessage();
        myHanlder.addRecords(vctRec);
        myOperationStatus=STATUS_CLOSE_NORMALLY;
        /*
        exgui.verification.VerifyLib.showPlanMsg(
        "ADD DATA OK","ADD DATA OK");
        */
        this.dispose();
      }catch(Exception exp){
        util.MiscFunc.hideProcessingMessage();
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
