package newtimes.nthk_report;
import java.awt.*;
import exgui.*;
import javax.swing.*;
import newtimes.production.report.AbsQryPanel;
import java.util.*;
import exgui.verification.CellFormat;
import database.datatype.Record;
import exgui.ultratable.CellTxtEditorFormat;
import java.awt.event.*;

import java.awt.*;
import exgui.*;
import javax.swing.*;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class PnlDiffReport
    extends AbsQryPanel  implements Int_PNL_JINIT{
    //extends JPanel {
  BlueBkgWhiteCharLabel lblTITLE = new BlueBkgWhiteCharLabel();
  JLabel jLabel1 = new JLabel();
  JTextField txtYYMM = new JTextField();
  JButton btnQry = new JButton();

  public PnlDiffReport() {
    try {
      //jbInit();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }

 public void jbInit() throws Exception {
    this.setLayout(null);
    lblTITLE.setText("DIFFERENCE RECORD LIST");
    lblTITLE.setBounds(new Rectangle(-1, 7, 801, 29));
    jLabel1.setText("YYYYMM");
    jLabel1.setBounds(new Rectangle(10, 42, 81, 24));
    txtYYMM.setText("");
    txtYYMM.setBounds(new Rectangle(75, 42, 110, 21));
    btnQry.setBounds(new Rectangle(248, 39, 99, 25));
    btnQry.setFont(new java.awt.Font("Dialog", 1, 11));
    btnQry.setText("REPORT");
    btnQry.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnQry_actionPerformed(e);
      }
    });
    this.add(lblTITLE, null);
    this.add(jLabel1, null);
    this.add(txtYYMM, null);
    this.add(btnQry, null);
    genDataBindObj();
  }
 public HashMap composeParameters(){
   java.util.HashMap hm=new java.util.HashMap();
   if(txtYYMM.getText().trim().length()==0){
     java.util.Calendar cld=java.util.Calendar.getInstance();
     int year=cld.get(cld.YEAR);
     int month=cld.get(cld.MONTH)+1;
     String dateStr=String.valueOf(year)+((month<10)?"0":"")+String.valueOf(month);
     hm.put("P_YM_TO",dateStr);
     hm.put("P_YM",String.valueOf(year)+"01");
   }else{
     String txtString=txtYYMM.getText().trim();
     int year=Integer.parseInt(txtString.substring(0,4));
     int month=Integer.parseInt(txtString.substring(4,6));
     String dateStr=String.valueOf(year)+((month<10)?"0":"")+String.valueOf(month);
     hm.put("P_YM_TO",dateStr);
     hm.put("P_YM",String.valueOf(year)+"01");
   }
   return hm;
 }
 public void genDataBindObj(){
   dataBindComps.clear();
   Object chkYearMon=CellFormat.getIntVerifierAllowNull(6);
   DataBindTextWithChecker etdDate = new DataBindTextWithChecker(txtYYMM, "",
                                       null, 6,
                                       (Object2String)chkYearMon,
                                       (CellTxtEditorFormat)chkYearMon);
    txtYYMM.setText("");
 }

  void btnQry_actionPerformed(ActionEvent e) {
      //check if format error
      if(txtYYMM.getText().trim().length()>0){
        if(txtYYMM.getText().trim().length()<6){
         exgui.verification.VerifyLib.showAlert("REPORT DATE FORMAT IS :YYYYMM",
                                                "REPORT DATE FORMAT IS :YYYYMM");
         return;
        }
      }
      if(util.PublicVariable.OPERATTING_CENTER.equals("NTFE")){
        reportName="NTFE_DIFF.rpt";
      }else{
        reportName="HK_DIFF.rpt";
      }

     super.JButtonQueryButtonAction(e);
  }
}
