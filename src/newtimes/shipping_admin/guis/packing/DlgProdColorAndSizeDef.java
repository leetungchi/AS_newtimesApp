package newtimes.shipping_admin.guis.packing;

import java.awt.*;
import javax.swing.*;
import exgui.*;
import javax.swing.border.*;
import java.awt.event.*;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class DlgProdColorAndSizeDef extends JDialog {
  JPanel panel1 = new JPanel();
  public static int STATUS_OPERATING=0;
  public static int STATUS_CLOSE_NORMALLY=1;
  public static int STATUS_CLOSE_CANCEL=2;
  protected int myOperationStatus;
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel1 = new BlueBkgWhiteCharLabel();
  TitledBorder titledBorder1;
  Border border1;
  TitledBorder titledBorder2;
  JButton btnClose = new JButton();
  JButton btnOK = new JButton();
  JLabel lblSizeList = new JLabel();
  WhiteBkgBlueCharLabel whiteBkgBlueCharLabel1 = new WhiteBkgBlueCharLabel();
  JButton btnRdfSize = new JButton();
  public String finalSizeListString=null;
  protected int orgProdHeadPk=-1;

  static String strcode[]=new String[]{"","","","",""};
  static String strname[]=new String[]{"","","","",""};
  javax.swing.JTable tblOfCartons=null;
  boolean isColorChanged;
  public DlgProdColorAndSizeDef(Frame frame, String title, boolean modal,String orgSize,int prodHeadPk,
                                javax.swing.JTable tbl2OfPackingCarton) {
    super(frame, title, modal);
    try {
      finalSizeListString=orgSize;
      orgProdHeadPk=prodHeadPk;
      if(orgProdHeadPk!=-1)
      jbInit();
      pack();
      tblOfCartons=tbl2OfPackingCarton;
      if(finalSizeListString==null)finalSizeListString="";
      lblSizeList.setText(util.MiscFunc.Replace(finalSizeListString,",,",","));
      isColorChanged=false;
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }

  public DlgProdColorAndSizeDef() {
    this(null, "", false,null,-1,null);
  }
  public int getOperationStatus(){
    return myOperationStatus;
  }
  public void show(){
    this.myOperationStatus=STATUS_OPERATING;
    super.show();
  }

  protected void jbInit() throws Exception {
    titledBorder1 = new TitledBorder(BorderFactory.createEtchedBorder(Color.white,new Color(148, 145, 140)),"COLOR");
    border1 = BorderFactory.createBevelBorder(BevelBorder.LOWERED,Color.white,Color.white,new Color(103, 101, 98),new Color(148, 145, 140));
    titledBorder2 = new TitledBorder(border1,"COLOR");
    panel1.setLayout(null);
    blueBkgWhiteCharLabel1.setText("CHANGE DEFINED SIZE COLUMNS OF CURRENT PACKING");
    blueBkgWhiteCharLabel1.setBounds(new Rectangle(0, 14, 669, 28));
    btnClose.setBounds(new Rectangle(44, 327, 82, 35));
    btnClose.setFont(new java.awt.Font("Dialog", 1, 11));
    btnClose.setText("CANCEL");
    btnClose.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnClose_actionPerformed(e);
      }
    });
    btnOK.setBounds(new Rectangle(389, 327, 184, 35));
    btnOK.setFont(new java.awt.Font("Dialog", 1, 11));
    btnOK.setText("OK,CONTINUE");
    btnOK.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnOK_actionPerformed(e);
      }
    });
    lblSizeList.setBorder(BorderFactory.createLoweredBevelBorder());
    lblSizeList.setText("");
    lblSizeList.setBounds(new Rectangle(24, 124, 487, 29));
    whiteBkgBlueCharLabel1.setText("DEFINED SIZE COLUMNS FOR CURRENT PACKING :");
    whiteBkgBlueCharLabel1.setBounds(new Rectangle(23, 94, 487, 28));
    btnRdfSize.setBounds(new Rectangle(512, 124, 56, 28));
    btnRdfSize.setFont(new java.awt.Font("Dialog", 1, 11));
    btnRdfSize.setToolTipText("REDEFINE SIZE LIST FOR PACKING");
    btnRdfSize.setText("...");
    btnRdfSize.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnRdfSize_actionPerformed(e);
      }
    });
    getContentPane().add(panel1);
    panel1.add(blueBkgWhiteCharLabel1, null);
    panel1.add(btnOK, null);
    panel1.add(btnClose, null);
    panel1.add(whiteBkgBlueCharLabel1, null);
    panel1.add(lblSizeList, null);
    panel1.add(btnRdfSize, null);
  }

  void btnClose_actionPerformed(ActionEvent e) {
    myOperationStatus=STATUS_CLOSE_CANCEL;
    dispose();
  }

  void btnOK_actionPerformed(ActionEvent e) {
    myOperationStatus=STATUS_CLOSE_NORMALLY;
    this.dispose();
  }


  void btnRdfSize_actionPerformed(ActionEvent e) {
    if(tblOfCartons.getRowCount()>0){
      if(!exgui.verification.VerifyLib.showConfirm(
      "Redefine the Size  Will Clear All The Defined Cartons Of Current Style\nAre You Sure ?",
      "May Clear All Defined Cartons")) return;
    }
    exgui.chaindialog.Responsible slkSizeColumns=new newtimes.production.gui.prodmaintain.PnlDlgSlkSizeType();
    newtimes.production.gui.prodmaintain.PnlDlgShiftSizes slkShiftSizeSeq=new newtimes.production.gui.prodmaintain.PnlDlgShiftSizes();
    exgui.chaindialog.ChainedDialogBox  DlgSelectSizeQty=new ChaiedProcSlkSizeType(
       util.PublicVariable.APP_FRAME,"Please Select Size Type",true,slkSizeColumns);
   slkSizeColumns.setDefalutNext(slkShiftSizeSeq);
   DlgSelectSizeQty.setSize(500,400);
   exgui.UIHelper.setToScreenCenter(DlgSelectSizeQty);
   DlgSelectSizeQty.show();
   if((DlgSelectSizeQty.getDialogStatus()==DlgSelectSizeQty.DIALOG_CANCEL)
      ||(DlgSelectSizeQty.getDialogStatus()==DlgSelectSizeQty.DIALOG_ERROR)
      ||(DlgSelectSizeQty.getDialogResult()==null)){
      return ;
   }else{
     java.util.HashMap dialogContext=
          (java.util.HashMap)DlgSelectSizeQty.getDialogResult();
     String commaSizeList=
         (String)dialogContext.get(slkShiftSizeSeq.STRING_KEY_SHFT_SIZE_DBL_CMA_LIST);
     lblSizeList.setText(util.MiscFunc.Replace(commaSizeList,",,",","));
     finalSizeListString=commaSizeList;
   }
  }
  class ChaiedProcSlkSizeType extends exgui.chaindialog.ChainedDialogBox{
   ChaiedProcSlkSizeType(javax.swing.JFrame frame,String title,boolean model,
                         exgui.chaindialog.Responsible rsp){
     super(frame,title,model,rsp);
   }
   public Object getDialogResult(){
     return super.resultHashMap;
   }
 }

}
