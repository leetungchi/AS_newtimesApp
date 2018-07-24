package newtimes.shipping;

import java.awt.*;
import exgui.*;
import javax.swing.*;
import javax.swing.border.*;
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

public class PnlBatchUpdateDel extends JPanel {
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel1 = new BlueBkgWhiteCharLabel();
  JPanel jPanel1 = new JPanel();
  TitledBorder titledBorder1;
  JTextField txtSc[] = new JTextField[20];
  JLabel jLabel1 = new JLabel();
  JTextField txtDelDate = new JTextField();
  JButton btnUpdate = new JButton();
  newtimes.production.process.prodmaintain.DB_StyleMisc dbStyle;
  exgui.DataBindTextWithChecker dbTxtDateDel;
  String userCode;
  JButton btnExit = new JButton();
  public PnlBatchUpdateDel() {
    try {
      newtimes.production.ProdMaintain_Properties.setWaitCursor();
      dbStyle=new  newtimes.production.process.prodmaintain.DB_StyleMisc();
      userCode=(String)util.PublicVariable.USER_RECORD.get("usr_code");
      jbInit();

    }
    catch(Exception ex) {
      ex.printStackTrace();
    }finally{
      newtimes.production.ProdMaintain_Properties.setNormalCursor();
    }
  }

  void jbInit() throws Exception {
    for(int i=0;i<20;i++){
      txtSc[i]= new JTextField();
    }
    titledBorder1 = new TitledBorder(new EtchedBorder(EtchedBorder.RAISED,Color.white,new Color(142, 142, 157)),"Please Input S/C No. Below");
    txtSc[8].setText("");
    txtSc[8].setBounds(new Rectangle(174, 167, 136, 26));
    txtSc[7].setText("");
    txtSc[7].setBounds(new Rectangle(174, 121, 136, 26));
    txtSc[6].setText("");
    txtSc[6].setBounds(new Rectangle(174, 75, 136, 26));
    txtSc[5].setText("");
    txtSc[5].setBounds(new Rectangle(174, 29, 136, 26));
    blueBkgWhiteCharLabel1.setText("BACTCH UPDATE DELIVERY");
    blueBkgWhiteCharLabel1.setBounds(new Rectangle(-2, 4, 797, 31));
    this.setLayout(null);
    this.setBackground(new Color(204, 204, 225));
    jPanel1.setBackground(new Color(204, 204, 225));
    jPanel1.setFont(new java.awt.Font("Dialog", 1, 11));
    jPanel1.setBorder(titledBorder1);
    jPanel1.setBounds(new Rectangle(77, 45, 639, 271));
    jPanel1.setLayout(null);
    txtSc[0].setText("");
    txtSc[0].setBounds(new Rectangle(19, 29, 136, 26));
    txtSc[1].setBounds(new Rectangle(19, 75, 136, 26));
    txtSc[1].setText("");
    txtSc[2].setBounds(new Rectangle(19, 121, 136, 26));
    txtSc[2].setText("");
    txtSc[3].setBounds(new Rectangle(19, 167, 136, 26));
    txtSc[3].setText("");
    txtSc[4].setBounds(new Rectangle(19, 213, 136, 26));
    txtSc[4].setText("");
    txtSc[9].setBounds(new Rectangle(174, 213, 136, 26));
    txtSc[9].setText("");
    txtSc[10].setBounds(new Rectangle(484, 29, 136, 26));
    txtSc[10].setText("");
    txtSc[11].setBounds(new Rectangle(330, 29, 136, 26));
    txtSc[11].setText("");
    txtSc[12].setBounds(new Rectangle(484, 121, 136, 26));
    txtSc[12].setText("");
    txtSc[13].setText("");
    txtSc[13].setBounds(new Rectangle(330, 167, 136, 26));
    txtSc[14].setText("");
    txtSc[14].setBounds(new Rectangle(330, 75, 136, 26));
    txtSc[15].setText("");
    txtSc[15].setBounds(new Rectangle(330, 213, 136, 26));
    txtSc[16].setText("");
    txtSc[16].setBounds(new Rectangle(484, 213, 136, 26));
    txtSc[17].setBounds(new Rectangle(484, 167, 136, 26));
    txtSc[17].setText("");
    txtSc[18].setBounds(new Rectangle(484, 75, 136, 26));
    txtSc[18].setText("");
    txtSc[19].setText("");
    txtSc[19].setBounds(new Rectangle(330, 121, 136, 26));
    jLabel1.setFont(new java.awt.Font("Dialog", 1, 11));
    jLabel1.setText("DELIVERY DATE:");
    jLabel1.setBounds(new Rectangle(80, 324, 108, 24));
    txtDelDate.setText("");
    txtDelDate.setBounds(new Rectangle(185, 324, 117, 24));
    btnUpdate.setBounds(new Rectangle(348, 369, 99, 29));
    btnUpdate.setFont(new java.awt.Font("Dialog", 1, 11));
    btnUpdate.setText("UPDATE");
    btnUpdate.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnUpdate_actionPerformed(e);
      }
    });
    btnExit.setBounds(new Rectangle(618, 369, 89, 30));
    btnExit.setFont(new java.awt.Font("Dialog", 1, 11));
    btnExit.setText("EXIT");
    btnExit.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnExit_actionPerformed(e);
      }
    });
    jPanel1.add(txtSc[0], null);
    jPanel1.add(txtSc[1], null);
    jPanel1.add(txtSc[2], null);
    jPanel1.add(txtSc[3], null);
    jPanel1.add(txtSc[4], null);
    jPanel1.add(txtSc[5], null);
    jPanel1.add(txtSc[9], null);
    jPanel1.add(txtSc[8], null);
    jPanel1.add(txtSc[7], null);
    jPanel1.add(txtSc[6], null);
    jPanel1.add(txtSc[11], null);
    jPanel1.add(txtSc[14], null);
    jPanel1.add(txtSc[19], null);
    jPanel1.add(txtSc[13], null);
    jPanel1.add(txtSc[15], null);
    jPanel1.add(txtSc[10], null);
    jPanel1.add(txtSc[18], null);
    jPanel1.add(txtSc[12], null);
    jPanel1.add(txtSc[17], null);
    jPanel1.add(txtSc[16], null);
    this.add(blueBkgWhiteCharLabel1, null);
    this.add(jPanel1, null);
    this.add(btnUpdate, null);
    this.add(jLabel1, null);
    this.add(txtDelDate, null);
    this.add(btnExit, null);
    Object dateVfy=exgui.verification.CellFormat.getDateStringFormaterAllowNull();
    dbTxtDateDel=
        new exgui.DataBindTextWithChecker(txtDelDate, "P_DEL_TO", null,
                                          10, (exgui.Object2String)dateVfy,
                                          (exgui.ultratable.
                                           CellTxtEditorFormat)dateVfy);

  }

  void btnUpdate_actionPerformed(ActionEvent e) {
     //find out the records mathces s/c no.
     util.MiscFunc.showProcessingMessage();
     if(!dbTxtDateDel.isValidx()){
       exgui.verification.VerifyLib.showAlert("Please Date Format Error",
                                              "Please Date Format Error");
        txtDelDate.grabFocus();
       return;
     }
     if(dbTxtDateDel.getSelectedValue()==null){
       exgui.verification.VerifyLib.showAlert("Please Input Delivery Date",
                                              "Please Input Delivery Date");
        txtDelDate.grabFocus();
       return;
     }
     try{
       StringBuffer sb = new StringBuffer();
       for (int i = 0; i < txtSc.length; i++) {
         if (txtSc[i].getText().trim().length() == 0)continue;
         if (sb.length() > 0)sb.append(",");
         sb.append("'");
         sb.append(util.MiscFunc.Replace(txtSc[i].getText(), "'", "''"));
         sb.append("'");
       }
       StringBuffer sb2 = new StringBuffer(
           "select sty_seq from style where STY_SC_NO in (");
       sb2.append(sb.toString());
       sb2.append(") and record_delete_flag=1");
       Vector vct = exgui2.CONST.BASIC_MAIN_EJB.getDatas(
           util.PublicVariable.USER_RECORD, sb2.toString(), 1, 99999999);
       if(vct.size()==0){
         exgui.verification.VerifyLib.showAlert("No Styles Matches These S/C No",
                                                "No Records Found");
         return;
       }
       Object newDelDate=dbTxtDateDel.getSelectedValue();
       Vector vctRec2Update=new Vector();
       for(int i=0;i<vct.size();i++){
         Record styleRec= dbStyle.getRecordByPk(((Record)vct.get(i)).getInt(0));
         //Object orgDelDate=styleRec.get(6);
         Object orgDelShipWay=styleRec.get(7);
         //Object recnfmDelDate=styleRec.get(8);
         Object recnfmDelShipWay=styleRec.get(9);
         //Object makerDelDate=styleRec.get(77);
         if(recnfmDelShipWay==null)styleRec.set(9,orgDelShipWay);
         styleRec.set(8,newDelDate);
         styleRec.set(77,newDelDate);
         styleRec.set(103,userCode);//record modify user
         vctRec2Update.add(styleRec);
       }
       dbStyle.updateRecords(vctRec2Update);
     }catch(Exception exp){
       exgui.verification.VerifyLib.showAlert("Error While Update Delivery Date Of Styles\nPlease Contact System Manager",
                                              "Error In Update Process");
       util.ExceptionLog.exp2File(exp,"");
       exp.printStackTrace();
     }finally{
       util.MiscFunc.hideProcessingMessage();
     }
  }

  void btnExit_actionPerformed(ActionEvent e) {
    /*
    newtimes.Frame1 frame=(newtimes.Frame1)util.PublicVariable.APP_FRAME;
    frame.showPanel(new newtimes.shipping.ShippingMenu(frame));
    */
   try{
     processhandler.template.Properties.getCenteralControler().doCommandExecute(
        new newtimes.production.report.TgrToGenMisFunList()
     );

   }catch(Exception exp){
     exp.printStackTrace();
   }
  }
}
