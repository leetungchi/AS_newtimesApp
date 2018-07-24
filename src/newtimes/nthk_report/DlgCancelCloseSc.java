package newtimes.nthk_report;

import java.awt.*;
import javax.swing.*;
import exgui.*;
import java.awt.event.*;
import java.util.*;
import database.datatype.Record;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class DlgCancelCloseSc extends JDialog {
  JPanel panel1 = new JPanel();
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel1 = new BlueBkgWhiteCharLabel();
  JButton btnCancel = new JButton();
  JButton btnExit = new JButton();
  JButton btnClose = new JButton();
  JScrollPane jScrollPane1 = new JScrollPane();
  JTextArea txtScList = new JTextArea();

  public DlgCancelCloseSc(Frame frame, String title, boolean modal) {
    super(frame, title, modal);
    try {
      jbInit();
      pack();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }

  public DlgCancelCloseSc() {
    this(null, "", false);
  }

  private void jbInit() throws Exception {
    panel1.setLayout(null);
    blueBkgWhiteCharLabel1.setText("Cancel/Close S/C Function");
    blueBkgWhiteCharLabel1.setBounds(new Rectangle(0, 7, 611, 33));
    btnCancel.setBounds(new Rectangle(373, 65, 106, 28));
    btnCancel.setFont(new java.awt.Font("Dialog", 1, 11));
    btnCancel.setText("CANCEL S/C#");
    btnCancel.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnCancel_actionPerformed(e);
      }
    });
    btnExit.setBounds(new Rectangle(373, 302, 158, 29));
    btnExit.setFont(new java.awt.Font("Dialog", 1, 11));
    btnExit.setText("EXIT");
    btnExit.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnExit_actionPerformed(e);
      }
    });
    btnClose.setBounds(new Rectangle(373, 170, 146, 26));
    btnClose.setFont(new java.awt.Font("Dialog", 1, 11));
    btnClose.setText("Close S/C Styles");
    btnClose.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnClose_actionPerformed(e);
      }
    });
    jScrollPane1.setBounds(new Rectangle(45, 59, 269, 272));
    txtScList.setText("");
    txtScList.setWrapStyleWord(true);
    getContentPane().add(panel1);
    panel1.add(btnCancel, null);
    panel1.add(blueBkgWhiteCharLabel1, null);
    panel1.add(jScrollPane1, null);
    panel1.add(btnExit, null);
    panel1.add(btnClose, null);
    jScrollPane1.getViewport().add(txtScList, null);
  }

  void btnExit_actionPerformed(ActionEvent e) {
    this.dispose();
  }
  public String getScList(){
    if(txtScList.getText().trim().length()==0){
      exgui.verification.VerifyLib.showAlert("Please input S/C Rows","Please Input S/C Rows");
      return null;
    }
    String[] listSc=util.MiscFunc.split(txtScList.getText().trim(),"\n");
    StringBuffer sb=new StringBuffer();
    StringBuffer sbexm=new StringBuffer();
    sbexm.append("select '1' as Col_1");
    int realLineCount=0;
    for(int i=0;i<listSc.length;i++){
      if(realLineCount>99){
        exgui.verification.VerifyLib.showAlert("Over 100 Rows,can not proceed Operation",
                                               "Can not Over 100 rows");
        return null;
      }
      if(listSc[i].trim().length()==0)continue;
      realLineCount++;
      if(i>0)sb.append(",");
      sb.append("'");
      sb.append(listSc[i]);
      sb.append("'");
       sbexm.append(" ,(select count(prod_sc_no) from production where prod_sc_no =");
       sbexm.append("'");
       sbexm.append(listSc[i]);
       sbexm.append("')");
       sbexm.append(" as \"");
       sbexm.append(util.MiscFunc.Replace(listSc[i],"-","_"));
       sbexm.append("\"");
    }
    sbexm.append(" from dual");
    try{
      Vector vctExm=exgui2.CONST.BASIC_MAIN_EJB.getDatas(
      util.PublicVariable.USER_RECORD,
      sbexm.toString(),1,9999999);
      Record rec=(Record)vctExm.get(0);
      sbexm=new StringBuffer();
      for(int i=0;i<rec.getFieldName().size();i++){
       if(rec.getInt(i)==0){
          String _sc=(String)rec.getFieldName().get(i);
           _sc=util.MiscFunc.Replace(_sc,"_","-");
           if(sbexm.length()>0)sbexm.append(",");
           sbexm.append(_sc);
       }
      }
      if(sbexm.length()>0){
        exgui.verification.VerifyLib.showAlert("SC:"+sbexm.toString()+" Not Found,Please Check","S/C# Not Found");
        return null;
      }
    }catch(Exception exp){
      exp.printStackTrace();
      util.ExceptionLog.exp2File(exp,"");
      exgui.verification.VerifyLib.showAlert("Error While Checking is S/C Shipped\nPlase Contact System Manager",
                                             "Error In Checking Shipped");
      return null;
    }
    return  sb.toString();
  }
  void btnCancel_actionPerformed(ActionEvent e) {
    if(!exgui.verification.VerifyLib.showConfirm("Do You Sure? To Proceed Cancel Po Process ?",
                                                 "Do you sure",false))
      return;
    //check if any sc shipped
    String scList=getScList();
    if(scList==null)return;
    //test if s/c in ship_sc
    StringBuffer sb=new StringBuffer();
    sb.append("select ship_no,");
    sb.append("(select pxn.prod_sc_no from production pxn where pxn.prod_head_pk=ship_sc.prod_head_pk) as PO_SCNO ");
    sb.append(" from ship_sc where prod_head_pk in ");
    sb.append("(select prod_head_pk from production where prod_sc_no in (");
    sb.append(scList);sb.append("))");
    try{
      java.util.Vector  vctShipSc = exgui2.CONST.BASIC_MAIN_EJB.getDatas(
          util.PublicVariable.USER_RECORD,
          sb.toString(), 1, 999999);
      if(vctShipSc.size()>0){
        sb=new StringBuffer();
        sb.append("Warnning,PO shipped:\n");
        for(int i=0;i<vctShipSc.size();i++){
          Record recShipSc=(Record)vctShipSc.get(i);
          sb.append((String)recShipSc.get(1));
          sb.append(" in ");
          sb.append((String)recShipSc.get(0));
          sb.append("\n");
        }
        sb.append("in cancelation process,");
        sb.append((vctShipSc.size()>1)?"these":"this");
        sb.append(" S/C will be ignored,\nDo you sure to conitnue?");
        if(!exgui.verification.VerifyLib.showConfirm(sb.toString(),"Shipped found",false)){
          return;
        }
      }
    }catch(Exception exp){
      exp.printStackTrace();
      util.ExceptionLog.exp2File(exp,"");
      exgui.verification.VerifyLib.showAlert("Error While Checking is S/C Shipped\nPlase Contact System Manager",
                                             "Error In Checking Shipped");
      return;
    }
    //proceed the cancelation process

    java.util.HashMap hm = new java.util.HashMap();
    hm.put("TPEMISCFUNC_ACTION_CODE", "NTHK_CANCEL_FUNCTION_SC_LIST");
    hm.put("user_code",util.PublicVariable.USER_RECORD.get(0));
    hm.put("NTHK_SCLIST",scList);
    //String scList=(String)param.get("NTHK_SCLIST");
    try{
      util.MiscFunc.showProcessingMessage();
      newtimesejb.TPE_MIS.TpeMisFuncHome ejbFuncHome=
          (newtimesejb.TPE_MIS.TpeMisFuncHome)
          info_ejb.WeblogicServiceLocator.locateServiceHome(util.PublicVariable.SERVER_URL,
          "newtimesejb.TPE_MIS.TpeMisFunc");
      newtimesejb.TPE_MIS.TpeMisFunc funEjb=ejbFuncHome.create();
      funEjb.tpeMisFunc(hm);
      exgui.verification.VerifyLib.showPlanMsg("Operate OK","Operate OK");
      //this.dispose();
    }catch(Exception exp){
      exp.printStackTrace();
      exgui.verification.VerifyLib.showAlert("Update Fail,Please Contact System Manager,\nOr Check S/C# Rows",
                                             "Update Faile");
    }finally{
      util.MiscFunc.hideProcessingMessage();
    }
  }

  void btnClose_actionPerformed(ActionEvent e) {
    if(!exgui.verification.VerifyLib.showConfirm("Do You Sure To Proceed Close Styles Process ?",
                                                 "Do you sure",false))
      return;
    String scList=getScList();
    if(scList==null)return;
    java.util.HashMap hm = new java.util.HashMap();
    hm.put("TPEMISCFUNC_ACTION_CODE", "NTHK_CLOSE_FUNCTION_SC_LIST");
    hm.put("user_code",util.PublicVariable.USER_RECORD.get(0));
    hm.put("NTHK_SCLIST",scList);
    try{
      util.MiscFunc.showProcessingMessage();
      newtimesejb.TPE_MIS.TpeMisFuncHome ejbFuncHome=
          (newtimesejb.TPE_MIS.TpeMisFuncHome)
          info_ejb.WeblogicServiceLocator.locateServiceHome(util.PublicVariable.SERVER_URL,
          "newtimesejb.TPE_MIS.TpeMisFunc");
      newtimesejb.TPE_MIS.TpeMisFunc funEjb=ejbFuncHome.create();
      funEjb.tpeMisFunc(hm);
      exgui.verification.VerifyLib.showPlanMsg("Operate OK","Operate OK");
      //this.dispose();
    }catch(Exception exp){
      exp.printStackTrace();
      exgui.verification.VerifyLib.showAlert("Update Fail,Please Contact System Manager,\nOr Check S/C# Rows",
                                             "Update Faile");
    }finally{
      util.MiscFunc.hideProcessingMessage();
    }

  }
}
