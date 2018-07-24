package newtimes.shipping.accountdepuse;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import newtimes.shipping.ScrollPaneGUI;
import newtimes.*;
import java.util.*;
import database.datatype.Record;
import exgui.*;
import exgui.verification.*;
import exgui.ultratable.CellTxtEditorFormat;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class DailyRec4AccountDepUse extends ScrollPaneGUI {
  Frame1 frame;
  private DailyRec4AccountDepUseGUI fieldsGUI = new DailyRec4AccountDepUseGUI();
  static String usrType = null;
  static String usrName = null;
  private String butnAction = null;
  JTextField txtTwdUsd=new JTextField();
  JTextField txtRmbUsd=new JTextField();
  JTextField txtHkdUsd=new JTextField();
  static java.util.HashMap paraHm=null;

  public DailyRec4AccountDepUse(Frame1 _frame) {
    frame = _frame;
    try {
      usrType = util.PublicVariable.USER_RECORD.get("USR_TYPE").toString();
      usrName = util.PublicVariable.USER_RECORD.get("USR_CODE").toString();
      jbInit();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }

  public DailyRec4AccountDepUse() {
    try {
      jbInit();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }

  void jbInit() throws Exception {
    this.setPanel(fieldsGUI,  new JPanel());
    this.jScrollPane_Bottom.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
    this.setDividerLocation(0.35);
    fieldsGUI.do_Print4NotFinal.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        do_Print4NotFinal_actionPerformed(e);
      }
    });
    /*
    fieldsGUI.do_ExtPrint.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        do_ExtPrint_actionPerformed(e);
      }
    });
    */
    this.butnCopy.setEnabled(false);
    this.butnPrint.setEnabled(false);
    this.butnNew.setEnabled(false);
    this.butnPaste.setEnabled(false);
    this.butnEdit.setEnabled(false);
    this.butnDelete.setEnabled(false);
    /*
    if (usrType.equals("2")) {
      fieldsGUI.do_ExtPrint.setEnabled(true);
    } else {
      fieldsGUI.do_ExtPrint.setEnabled(false);
    }
    */
   if(paraHm==null){
     paraHm=new java.util.HashMap();
     Vector vct = exgui2.CONST.BASIC_MAIN_EJB.getDatas(util.PublicVariable.
         USER_RECORD,
         "select * from system_default_value where CENTER='" +
                                          (String)util.PublicVariable.
                                          USER_RECORD.get("USR_CEN_CODE") +
                                          "' and record_delete_flag=1", 1, 1);
     Object chkDcm32 = exgui.verification.CellFormat.getDoubleFormatAllowNull(
         5, 4);


     Record recSystem = (Record)vct.get(0);

     DataBindTextWithChecker dbTwdChg = new DataBindTextWithChecker(txtTwdUsd,
         "TWD_USD", recSystem.get("TWD_XCHG_RATE"), 10,
         (Object2String)chkDcm32, (CellTxtEditorFormat)chkDcm32);
    paraHm.put("TWD_USD",dbTwdChg.getSelectedValue());

     DataBindTextWithChecker dbRmbChg = new DataBindTextWithChecker(txtRmbUsd,
         "RMB_USD", recSystem.get("RMB_XCHG_RATE"), 10,
         (Object2String)chkDcm32, (CellTxtEditorFormat)chkDcm32);
    paraHm.put("RMB_USD",dbRmbChg.getSelectedValue());
     DataBindTextWithChecker dbHkdChg = new DataBindTextWithChecker(txtHkdUsd,
         "HKD_USD", recSystem.get("HKD_XCHG_RATE"), 10,
         (Object2String)chkDcm32, (CellTxtEditorFormat)chkDcm32);
     paraHm.put("HKD_USD",dbHkdChg.getSelectedValue());
   }

  }

  public void do_Copy() {
  }

  public void do_Delete() {
  }

  public void do_Edit() {
  }

  public void do_Exit() {
    //frame.showPanel(new newtimes.shipping.ShippingMenu(frame));
    try{
           processhandler.template.Properties.getCenteralControler().doCommandExecute(
           new newtimes.accounting.TgrToGenAcctFuncsList());

    }catch(Exception exp){
      exp.printStackTrace();
     }

  }

  public void do_New() {
  }

  public void do_Paste() {
  }

  public void do_Print() {
  }

  private String setReportAgument() {
    try {
      StringBuffer sbArg = new StringBuffer();
      java.util.Vector vecFields = fieldsGUI.getFieldsData();
      sbArg.append("&promptOnRefresh=0&cmd=rfsh&prompt0="+this.butnAction);
      if (vecFields.size() > 1) {
        sbArg.append("&prompt1='0'");
        for (int i = 0; i < vecFields.size(); i++) {
          sbArg.append(",'");
          sbArg.append(vecFields.get(i));
          sbArg.append("'");
        }
      } else {
        if (vecFields.size() == 1) {
          sbArg.append("&prompt1='"+vecFields.get(0)+"'");
        } else {
          sbArg.append("&prompt1=null");
        }
      }
      return sbArg.toString();
    } catch(Exception e) {
      e.printStackTrace();
      return null;
    }
  }

  void do_Print4NotFinal_actionPerformed(ActionEvent e) {
    try {
      /* 20060919==passoword no more required
      JPasswordField pf = new JPasswordField();
      Object[] message = new Object[] {"Enter Password To Print", pf};
      Object[] options = new String[] {"OK", "Cancel"};
      JOptionPane op = new JOptionPane(
             message, JOptionPane.PLAIN_MESSAGE,
             JOptionPane.OK_CANCEL_OPTION, null, options);
      JDialog dialog = op.createDialog(null, "Enter PassWord Please");
      dialog.show();
      char chars[]=pf.getPassword();

      if(chars==null){
        return;
      }else{

        String result=new String(chars);
        if(result.trim().equals(""))return;
        if(!result.trim().equals("0220")){
          exgui.verification.VerifyLib.showAlert("Password Error",
                                                 "Password Error");
          return;
        }
      }*/

      /*
      String result=JOptionPane.showInputDialog(
       util.PublicVariable.APP_FRAME,
        "Pleae Input Password To Pring:","Please Input Password",
        JOptionPane.QUESTION_MESSAGE);
      if(result==null)return;
      if(!result.trim().equals("0220")){
        exgui.verification.VerifyLib.showAlert("Password Error",
                                               "Password Error");
        return;
      }*/

      Vector vct=fieldsGUI.getFieldsData();
      if(vct==null)return;
      if(vct.size()==0){
        exgui.verification.VerifyLib.showAlert("Please Input At Least One SRN No.",
                                               "Please Input At Least One SRN No.");
        return;
      }
      setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
      this.butnAction = "Print_for_Not_Final";
      //String centerCode=(String)util.PublicVariable.USER_RECORD.get("USR_CEN_CODE");
      //paraHm.put("CEN_CODE",centerCode);
      paraHm.put("CENTER_CODE",fieldsGUI.dbcbxCenter.getSelectedValue());
      if(vct.size()==0){
        paraHm.put("P_SRN_NO","['ALL']");
      }else{
        StringBuffer sb=new StringBuffer();
        for (int i = 0; i < vct.size(); i++) {
              if(sb.length()>0)sb.append(",");
              sb.append("'");
              sb.append((String)vct.get(i));
              sb.append("'");
        }
        paraHm.put("P_SRN_NO","["+sb.toString()+"]");
      }
      paraHm.put("P_LAST",fieldsGUI.cbxPrintLastPage.getSelectedItem().equals("YES")?"Y":"N");
      paraHm.put("P_ONLY_TTL",fieldsGUI.rdoOnlySrnTtl_Y.isSelected()?"Y":"N");
      com.inet.viewer.ReportViewerBean viewer= util.PublicVariable.inet_report_viewer;
      newtimes.production.report.ReportCmdSet.myReportEngin.setReportNameAndParas(viewer,
             "DAIL_SHIP_ACC.RPT",paraHm);
         viewer.setHasGroupTree(false);
         //viewer.setReportData(newtimes.production.report.ReportCmdSet.myReportEngin);
         viewer.start();

         /*
           while(viewer.getBusy()){
            try{
             Thread.currentThread().sleep(500);
            }catch(java.lang.InterruptedException  itExp){

            }
          }
         */

      setLowerPanel(viewer);

       //20070209 ,need to update ship-status,for the requrement of exporting maker discount to debitnote checking
      boolean isOk = exgui2.CONST.SHIP_MAIN_EJB.setShipStatus(
          vct, true, usrName, this.butnAction,fieldsGUI.dbcbxCenter.getSelectedValue().toString());
      if (isOk) {
        exgui2.InfoMessage.infoMessage(frame, "SRN No. status update succeed.");
      } else {
        exgui2.InfoMessage.warningMessage(frame, "SRN No. status update failed.");
      }

    } catch(Exception eNot) {
      eNot.printStackTrace();
      util.ExceptionLog.exp2File(eNot, "error at attempt pressed Print for Not Final button.");
    } finally {
      setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
    }
  }

  void do_ExtPrint_actionPerformed(ActionEvent e) {
    try {
      setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
      this.butnAction = "Ext_Print";
      boolean isOk = exgui2.CONST.SHIP_MAIN_EJB.setShipStatus(
          fieldsGUI.getFieldsData(), true, usrName, this.butnAction,null);
      if (isOk) {
        exgui2.InfoMessage.infoMessage(frame, "SRN No. status update succeed.");
        this.setLowerPanel(new exgui2.ReportGenerate("0604.rpt", this.setReportAgument()));
      } else {
        exgui2.InfoMessage.warningMessage(frame, "SRN No. status update failed.");
      }
    } catch(Exception eNot) {
      eNot.printStackTrace();
      util.ExceptionLog.exp2File(eNot, "error at attempt pressed Ext-Print button.");
    } finally {
      setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
    }
  }
}
