package newtimes.production.gui.order_change;
import newtimes.production.process.order_change.*;
import java.awt.*;
import exgui.*;
import javax.swing.*;
import java.awt.event.*;
import database.datatype.Record;
import java.awt.image.*;
import java.io.*;
import com.sun.image.codec.jpeg.*;
public class PnlInputSCNO extends JPanel {
  JButton btnXtrat = new JButton();
  JLabel blueBkgWhiteCharLabel1 = new JLabel();
  JTextField txtSCNO = new JTextField();
  JLabel whiteBkgBlueCharLabel1 = new JLabel();
  DB_ProdSC_Qry dbHandler;
  ButtonGroup buttonGroup1 = new ButtonGroup();
  JRadioButton rdo2OdrChgPrint = new JRadioButton();
  JRadioButton rdoBtn2Chg = new JRadioButton();
  public static int CURRENT_PRODCTION_REVICE_NO=0;
  JRadioButton rdoPrintCTorderChange = new JRadioButton();
  JLabel jLabel1 = new JLabel();
  JTextField txtScRvc = new JTextField();
  JLabel jLabel2 = new JLabel();
  JTextField txtCtRvc = new JTextField();
  public PnlInputSCNO(DB_ProdSC_Qry _dbHandler) {
    super();
    try {
      dbHandler=_dbHandler;
      jbInit();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }
  void jbInit() throws Exception {
    this.setLayout(null);
    btnXtrat.setBounds(new Rectangle(25, 273, 123, 30));
    btnXtrat.setFont(new java.awt.Font("Dialog", 1, 11));
    btnXtrat.setText("Extract");
    btnXtrat.addActionListener(new PnlInputSCNO_btnXtrat_actionAdapter(this));
    blueBkgWhiteCharLabel1.setText("=========== ORDER CHANGE ===========");
    blueBkgWhiteCharLabel1.setBounds(new Rectangle(18, 20, 411, 27));
    txtSCNO.setText("");
    txtSCNO.setBounds(new Rectangle(196, 77, 129, 30));
    whiteBkgBlueCharLabel1.setText("S/C NO.");
    whiteBkgBlueCharLabel1.setBounds(new Rectangle(24, 77, 172, 30));
    rdo2OdrChgPrint.setFont(new java.awt.Font("Dialog", 1, 11));
    rdo2OdrChgPrint.setText("To Print S/C Order Change");
    rdo2OdrChgPrint.setBounds(new Rectangle(207, 120, 212, 21));
    rdoBtn2Chg.setFont(new java.awt.Font("Dialog", 1, 11));
    rdoBtn2Chg.setSelected(true);
    rdoBtn2Chg.setText("To Change Order");
    rdoBtn2Chg.setBounds(new Rectangle(24, 120, 141, 21));
    rdoPrintCTorderChange.setFont(new java.awt.Font("Dialog", 1, 11));
    rdoPrintCTorderChange.setText("To Print C/T Order Change");
    rdoPrintCTorderChange.setBounds(new Rectangle(207, 141, 237, 19));
    jLabel1.setText("SC REVICE NO:");
    jLabel1.setBounds(new Rectangle(31, 180, 96, 22));
    txtScRvc.setText("0");
    txtScRvc.setBounds(new Rectangle(130, 181, 108, 22));
    jLabel2.setBounds(new Rectangle(256, 179, 96, 22));
    jLabel2.setText("CT REVICE NO:");
    txtCtRvc.setBounds(new Rectangle(355, 180, 108, 22));
    txtCtRvc.setText("0");
    this.add(blueBkgWhiteCharLabel1, null);
    this.add(txtSCNO, null);
    this.add(whiteBkgBlueCharLabel1, null);
    this.add(rdo2OdrChgPrint, null);
    this.add(rdoBtn2Chg, null);
    buttonGroup1.add(rdo2OdrChgPrint);
    buttonGroup1.add(rdoBtn2Chg);
    buttonGroup1.add(rdoPrintCTorderChange);
    this.add(rdoPrintCTorderChange, null);
    this.add(btnXtrat, null);
    this.add(jLabel1, null);
    this.add(txtScRvc, null);
    this.add(jLabel2, null);
    this.add(txtCtRvc, null);
  }
  protected static String getReviceNo(){
    JLabel lblRev=new JLabel("INPUT REVICE NO:");
    JTextField txtRev=new JTextField();
    Object objIntChk=exgui.verification.CellFormat.getIntVerifier(10);
    exgui.DataBindTextWithChecker dbtxt=
      new exgui.DataBindTextWithChecker(
          txtRev,
          "",
          String.valueOf(CURRENT_PRODCTION_REVICE_NO),
          10,
          (exgui.Object2String)objIntChk,
          (exgui.ultratable.CellTxtEditorFormat)objIntChk
       );
    Object[] ob={lblRev,txtRev};
    txtRev.selectAll();
    String value=null;
    int result = JOptionPane.showConfirmDialog(
      util.PublicVariable.APP_FRAME ,
      ob,
      "REVICE NO.",
      JOptionPane.OK_CANCEL_OPTION);

    if (result == JOptionPane.OK_OPTION) {
      value=txtRev.getText();
    }

   return value;

 }
  void btnXtrat_actionPerformed(ActionEvent e) {
    newtimes.production.ProdMaintain_Properties.setWaitCursor();
    try{


      String inputSc=txtSCNO.getText();
      if(inputSc.trim().length()==0){
        exgui.verification.VerifyLib.showPlanMsg(
            "Please Input SC NO To Query",
            "Please Input SC NO.");
        return;
      }
      //find if SC NO exist.
      java.util.Vector recs=
          dbHandler.getRecord(inputSc);
      if(recs.size()==0){
        exgui.verification.VerifyLib.showPlanMsg(
            "Sorry,No Such SC No.",
            "No Data Found");
        return ;
      }
      if(!rdoBtn2Chg.isSelected()){
         //order change for s/c c/t
        if (txtScRvc.getText().trim().length() == 0 ||
            txtCtRvc.getText().trim().length() == 0) {
          exgui.verification.VerifyLib.showAlert(
              "Please Assigne Revice No. For S/C & C/T",
              "Pleaes Assign Revice Value");
          return;
        }
        int testScRevNo = Integer.parseInt(txtScRvc.getText().trim());
        int testCtRevNo = Integer.parseInt(txtCtRvc.getText().trim());
        if ((testScRevNo < 0) || (testCtRevNo < 0)) {
          exgui.verification.VerifyLib.showAlert(
              "S/C or C/T Revice No. Should Be Greater Than Zero",
              "Revice No. Format Error");
          return;
        }
        newtimes.production.process.audit_sc_ct.DB_ProdAudits handlerRvc=
            new newtimes.production.process.audit_sc_ct.DB_ProdAudits();
        newtimesejb.preproduction.PreProductionHeadHome
            ejbHome =
            (newtimesejb.preproduction.PreProductionHeadHome)
            info_ejb.WeblogicServiceLocator.locateServiceHome(
            util.PublicVariable.SERVER_URL,
            "newtimesejb.preproduction.PreProductionHead"
            );
         int ctRvcNo=-1,scRvcNo=-1;
        if(rdo2OdrChgPrint.isSelected()){
          scRvcNo=Integer.parseInt(txtScRvc.getText().trim());
        }else{
          ctRvcNo=Integer.parseInt(txtCtRvc.getText().trim());
        }
        newtimesejb.preproduction.PreProductionHead  ejb=ejbHome.create();
        ejb.updatePrintStatus(
          ((Record)recs.get(0)).getInt(0),
          (String)util.PublicVariable.USER_RECORD.get("usr_code"),-3,scRvcNo,ctRvcNo);
    }



      Record recProd=(Record)recs.get(0);
      Object rvs_no_obj=recProd.get("PROD_REVICE_NO");
      CURRENT_PRODCTION_REVICE_NO=
          (rvs_no_obj==null)?1:Integer.parseInt(rvs_no_obj.toString());
      int xntProdAudit=recProd.getInt("PROD_AUDIT_STATUS");
      /*
      if(xntProdAudit<3||xntProdAudit==4){
        exgui.verification.VerifyLib.showPlanMsg(
            "Current Product Is Not Confirmed Or Printed Yet",
            "Audit Status Is Not Confirmed Or Printed");
        return ;
      }*/
      newtimes.production.ProdMaintain_Properties.PRODUCTION_AUDIT_STATUS_COLUMN_NAME="PROD_AUDIT_STATUS";

      newtimes.preproduction.Constants.CURRENT_PREPROD_HEAD_RECORD=(Record)util.MiscFunc.deepCopy(recProd);
      newtimes.preproduction.Constants.CURRENT_PREPROD_HEAD_PK=recProd.getInt(0);
      newtimes.preproduction.Constants.CURRENT_PREPROD_HEAD_RECORD.getFieldName().add("PRODUCTION_TYPE");
      newtimes.preproduction.Constants.CURRENT_PREPROD_HEAD_RECORD.getValueFields().add(
      recProd.get("prod_type"));
      if(rdo2OdrChgPrint.isSelected()){
        processhandler.template.Properties.getCenteralControler().
            doCommandExecute(
            new newtimes.production.process.order_change.TgrToGenOdrChgReport());

      }else if (rdoPrintCTorderChange.isSelected()){
        processhandler.template.Properties.getCenteralControler().
              doCommandExecute(
              new newtimes.production.process.order_change.TgrToGenCtOdrChgReport());

      }else{
        processhandler.template.Properties.getCenteralControler().
            doCommandExecute(
            new newtimes.production.process.order_change.TgrToListStyle());
      }
    }catch(Exception exp){
      exp.printStackTrace();
    }finally{
        newtimes.production.ProdMaintain_Properties.setNormalCursor();
    }
  }
}

class PnlInputSCNO_btnXtrat_actionAdapter implements java.awt.event.ActionListener {
  PnlInputSCNO adaptee;

  PnlInputSCNO_btnXtrat_actionAdapter(PnlInputSCNO adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.btnXtrat_actionPerformed(e);
  }
}
