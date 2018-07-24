package newtimes.basic.vender_infor;

import java.awt.*;
import javax.swing.*;
import exgui.*;
import newtimes.preproduction.buyermakerselect.*;
import database.datatype.Record;
import java.awt.event.*;
/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class DlgNewVender extends JDialog {

  SelectBuyerMaker slkVender = new SelectBuyerMaker();
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel2 = new BlueBkgWhiteCharLabel();
  WhiteBkgBlueCharLabel whiteBkgBlueCharLabel1 = new WhiteBkgBlueCharLabel();
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel1 = new BlueBkgWhiteCharLabel();
  WhiteBkgBlueCharLabel whiteBkgBlueCharLabel2 = new WhiteBkgBlueCharLabel();
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel3 = new BlueBkgWhiteCharLabel();
  WhiteBkgBlueCharLabel whiteBkgBlueCharLabel3 = new WhiteBkgBlueCharLabel();
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel4 = new BlueBkgWhiteCharLabel();
  WhiteBkgBlueCharLabel whiteBkgBlueCharLabel4 = new WhiteBkgBlueCharLabel();
  JTextField txtBankName = new JTextField();
  JTextField txtAddLine1 = new JTextField();
  JTextField txtAddLine2 = new JTextField();
  JTextField txtSwift = new JTextField();
  JTextField txtRcv = new JTextField();
  JTextField txtAccNo = new JTextField();
   //JPanel pnl=new JPanel();
  JButton btnAdd = new JButton();
  JButton btnExit = new JButton();
  TempPnl pnl = new TempPnl();

  public DlgNewVender(Frame frame, String title, boolean modal) {
    super(frame, title, modal);
    try {
      TempDb dbHandler=new TempDb();

      pnl.setPagedDataFactory(dbHandler);
      pnl.setRecord(dbHandler.getBlankRecord());
      pnl.record2Gui();

      jbInit();
      pack();
      pnl.validate();
      pnl.repaint();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }

  public DlgNewVender() {
    this(null, "", false);
  }

  private void jbInit() throws Exception {
    getContentPane().add(pnl);


  }
  class TempDb
      extends exgui.ultratable.PagedDataFactoryAdapter{

    newtimesejb.TPE_MIS.TpeMisFunc ejb2update;
    TempDb(){
      try {
        newtimesejb.TPE_MIS.TpeMisFuncHome ejbHome=
            (newtimesejb.TPE_MIS.TpeMisFuncHome)
            info_ejb.WeblogicServiceLocator.locateServiceHome(
            util.PublicVariable.SERVER_URL,
            "newtimesejb.TPE_MIS.TpeMisFunc");

        ejb2update=ejbHome.create();
      }catch(Exception exp){
        exp.printStackTrace();
      }
    }
    public Record getBlankRecord(){
      try{
        Record rec= exgui2.CONST.BASIC_MAIN_EJB.getBlankRecord("VENDER_INFOR_tbl");
        rec.set("record_create_user",util.PublicVariable.USER_RECORD.get(0));
        rec.set("record_delete_flag",-1);
        return rec;
      }catch(Exception exp){
        exp.printStackTrace();
      }
      return null;
    }
    public void updateRecords(java.util.Vector vct)throws Exception{
      java.util.HashMap hm=new java.util.HashMap();
      hm.put("TPEMISCFUNC_ACTION_CODE","UPDATE_VENDER_INFOR");
      hm.put("VCT_VENDER_INFOR",vct);
      try{
        util.MiscFunc.showProcessingMessage();
        ejb2update.tpeMisFunc(hm);
      }finally{
        util.MiscFunc.hideProcessingMessage();
      }

    }
  }
  class TempPnl
    extends processhandler.template.PnlFieldsEditor{
    //extends JPanel{
    TempPnl(){
      jbInit();
    }
     public boolean gui2Record(){
       boolean orgResult=super.gui2Record();
       if(!orgResult)return orgResult;
       if(slkVender.getSelectedValue()==null)return false;
       recToMapping.set(1,slkVender.getSelectedValue());
       return true;
     }
     public void  record2Gui(){
        try{
          dataBoundGUIs.clear();

          Object vftxtBankName = exgui.verification.CellFormat.getOrdinaryField(
              240);
          dataBoundGUIs.add(new exgui.DataBindTextWithChecker(txtBankName,
              "COLLECT_BANK", recToMapping.get("COLLECT_BANK"), 240,
              (exgui.Object2String)vftxtBankName,
                            (exgui.ultratable.CellTxtEditorFormat)vftxtBankName)
                            );
          Object vftxtAddLine1 = exgui.verification.CellFormat.getOrdinaryField(
              400);
          dataBoundGUIs.add(new exgui.DataBindTextWithChecker(txtAddLine1,
              "BANK_ADD1", recToMapping.get("BANK_ADD1"), 400,
              (exgui.Object2String)vftxtAddLine1,
                            (exgui.ultratable.CellTxtEditorFormat)vftxtAddLine1)
                            );
          Object vftxtAddLine2 = exgui.verification.CellFormat.getOrdinaryField(
              400);
          dataBoundGUIs.add(new exgui.DataBindTextWithChecker(txtAddLine2,
              "BANK_ADD2", recToMapping.get("BANK_ADD2"), 400,
              (exgui.Object2String)vftxtAddLine2,
                            (exgui.ultratable.CellTxtEditorFormat)vftxtAddLine2)
                            );
          Object vftxtSwift = exgui.verification.CellFormat.getOrdinaryField(240);
          dataBoundGUIs.add(new exgui.DataBindTextWithChecker(txtSwift, "SWIFT",
              recToMapping.get("SWIFT"), 240, (exgui.Object2String)vftxtSwift,
              (exgui.ultratable.CellTxtEditorFormat)vftxtSwift)
                            );
          Object vftxtRcv = exgui.verification.CellFormat.getOrdinaryField(240);
          dataBoundGUIs.add(new exgui.DataBindTextWithChecker(txtRcv,
              "COLLECT_BY", recToMapping.get("COLLECT_BY"), 240,
              (exgui.Object2String)vftxtRcv,
                            (exgui.ultratable.CellTxtEditorFormat)vftxtRcv)
                            );
          Object vftxtAccNo = exgui.verification.CellFormat.getOrdinaryField(240);
          dataBoundGUIs.add(new exgui.DataBindTextWithChecker(txtAccNo, "ACC_NO",
              recToMapping.get("ACC_NO"), 240, (exgui.Object2String)vftxtAccNo,
              (exgui.ultratable.CellTxtEditorFormat)vftxtAccNo)
                            );
        }catch(Exception exp){
          exp.printStackTrace();
        }
    }
     public void doPrint(){}
     public void doUpdate()throws Exception{
       java.util.Vector vct=new java.util.Vector();
       vct.add(recToMapping);
       dbprc.updateRecords(vct);
     }
     public void jbInit(){

       slkVender.init(null,null,slkVender.TYPE_VENDOR,true);
       //pnl.setLayout(null);
       setLayout(null);
       slkVender.setBounds(new Rectangle(208, 53, 242, 28));
       blueBkgWhiteCharLabel2.setText("ADD NEW VENDOR BANK");
       blueBkgWhiteCharLabel2.setBounds(new Rectangle(-1, 13, 514, 24));
       whiteBkgBlueCharLabel1.setText("VENDOR");
       whiteBkgBlueCharLabel1.setBounds(new Rectangle(79, 53, 128, 28));
       blueBkgWhiteCharLabel1.setText("BANK NAME");
       blueBkgWhiteCharLabel1.setBounds(new Rectangle(79, 96, 128, 28));
       whiteBkgBlueCharLabel2.setBounds(new Rectangle(79, 139, 128, 28));
       whiteBkgBlueCharLabel2.setText("ADDRESS LINE 1");
       blueBkgWhiteCharLabel3.setBounds(new Rectangle(79, 183, 128, 28));
       blueBkgWhiteCharLabel3.setText("ADDRESS LINE 2");
       whiteBkgBlueCharLabel3.setText("SWIFT");
       whiteBkgBlueCharLabel3.setBounds(new Rectangle(79, 226, 128, 28));
       blueBkgWhiteCharLabel4.setText("RECIPIENT");
       blueBkgWhiteCharLabel4.setBounds(new Rectangle(79, 269, 128, 28));
       whiteBkgBlueCharLabel4.setBounds(new Rectangle(79, 312, 128, 28));
       whiteBkgBlueCharLabel4.setText("ACCOUNT#");
       txtBankName.setText("");
       txtBankName.setBounds(new Rectangle(208, 96, 242, 28));
       txtAddLine1.setBounds(new Rectangle(208, 139, 242, 28));
       txtAddLine1.setText("jTextField1");
       txtAddLine1.setText("");
       txtAddLine2.setBounds(new Rectangle(208, 183, 242, 28));
       txtAddLine2.setText("jTextField1");
       txtAddLine2.setText("");
       txtSwift.setBounds(new Rectangle(208, 226, 242, 28));
       txtSwift.setText("jTextField1");
       txtSwift.setText("");
       txtRcv.setBounds(new Rectangle(208, 269, 242, 28));
       txtRcv.setText("jTextField1");
       txtRcv.setText("");
       txtAccNo.setBounds(new Rectangle(208, 312, 242, 28));
       txtAccNo.setText("jTextField1");
       txtAccNo.setText("");
       /*
       pnl.add(slkVender, null);
       pnl.add(blueBkgWhiteCharLabel2, null);
       pnl.add(whiteBkgBlueCharLabel1, null);
       pnl.add(blueBkgWhiteCharLabel1, null);
       pnl.add(whiteBkgBlueCharLabel2, null);
       pnl.add(blueBkgWhiteCharLabel3, null);
       pnl.add(whiteBkgBlueCharLabel3, null);
       pnl.add(blueBkgWhiteCharLabel4, null);
       pnl.add(whiteBkgBlueCharLabel4, null);
       pnl.add(txtBankName, null);
       pnl.add(txtAddLine1, null);
       pnl.add(txtAddLine2, null);
       pnl.add(txtSwift, null);
       pnl.add(txtRcv, null);
       pnl.add(txtAccNo, null);
       pnl.add(btnAdd, null);
       pnl.add(btnExit, null);
       */
      add(slkVender, null);
      add(blueBkgWhiteCharLabel2, null);
      add(whiteBkgBlueCharLabel1, null);
      add(blueBkgWhiteCharLabel1, null);
      add(whiteBkgBlueCharLabel2, null);
      add(blueBkgWhiteCharLabel3, null);
      add(whiteBkgBlueCharLabel3, null);
      add(blueBkgWhiteCharLabel4, null);
      add(whiteBkgBlueCharLabel4, null);
      add(txtBankName, null);
      add(txtAddLine1, null);
      add(txtAddLine2, null);
      add(txtSwift, null);
      add(txtRcv, null);
      add(txtAccNo, null);
      add(btnAdd, null);
      add(btnExit, null);

       btnAdd.setBounds(new Rectangle(91, 386, 99, 31));
       btnAdd.setFont(new java.awt.Font("Dialog", 1, 11));
       btnAdd.setText("ADD");
       btnAdd.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(ActionEvent e) {
           btnAdd_actionPerformed(e);
         }
       });
       btnExit.setText("EXIT");
       btnExit.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(ActionEvent e) {
           btnExit_actionPerformed(e);
         }
       });
       btnExit.setBounds(new Rectangle(332, 386, 99, 31));
       btnExit.setFont(new java.awt.Font("Dialog", 1, 11));
       btnExit.setForeground(Color.red);

     }
  }

  void btnAdd_actionPerformed(ActionEvent e) {
     pnl.gui2Record();
     if(slkVender.getSelectedValue()==null){
       exgui.verification.VerifyLib.showAlert("Please Assigne Vendor",
                                              "Please Assigne Vendor");
       return;
     }
     try{
       pnl.doUpdate();
     }catch(Exception exp){
       exp.printStackTrace();
       util.ExceptionLog.exp2File(exp,"");
       exgui.verification.VerifyLib.showAlert("Update Failed,Please Contact System Manager",
                                              "Update Faile");
     }
     this.dispose();
  }

  void btnExit_actionPerformed(ActionEvent e) {
   this.dispose();
  }
}
