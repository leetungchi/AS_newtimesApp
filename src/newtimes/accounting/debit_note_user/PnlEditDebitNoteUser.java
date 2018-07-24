package newtimes.accounting.debit_note_user;

import java.awt.*;
import javax.swing.*;
import exgui.*;
import database.datatype.Record;
/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class PnlEditDebitNoteUser
    extends processhandler.template.PnlFieldsEditor{
    //extends JPanel {
  JTextField txtUsrEngName = new JTextField();
  JTextField txtUsrMdnName = new JTextField();
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel3 = new BlueBkgWhiteCharLabel();
  JScrollPane jScrollPane1 = new JScrollPane();
  JTextField txtUsrCode = new JTextField();
  WhiteBkgBlueCharLabel whiteBkgBlueCharLabel2 = new WhiteBkgBlueCharLabel();
  JTextArea txtRemark = new JTextArea();
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel1 = new BlueBkgWhiteCharLabel();
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel2 = new BlueBkgWhiteCharLabel();

  public PnlEditDebitNoteUser() {
    try {
      jbInit();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }
 public Record recEditingRecord () {return recToMapping;}
 protected void jbInit() throws Exception {
    jScrollPane1.setBounds(new Rectangle(110, 97, 312, 107));
    blueBkgWhiteCharLabel3.setText("REMARK:");
    blueBkgWhiteCharLabel3.setBounds(new Rectangle(7, 97, 103, 107));
    txtUsrMdnName.setBounds(new Rectangle(304, 30, 114, 27));
    txtUsrMdnName.setText("");
    txtUsrEngName.setText("");
    txtUsrEngName.setBounds(new Rectangle(140, 63, 179, 27));
    this.setBackground(new Color(202, 202, 224));
    this.setLayout(null);
    txtUsrCode.setText("");
    txtUsrCode.setBounds(new Rectangle(110, 31, 92, 27));
    whiteBkgBlueCharLabel2.setText("ENGLISH NAME:");
    whiteBkgBlueCharLabel2.setBounds(new Rectangle(8, 63, 132, 27));
    txtRemark.setFont(new java.awt.Font("DialogInput", 0, 12));
    txtRemark.setText("");
    blueBkgWhiteCharLabel1.setText("USER CODE:");
    blueBkgWhiteCharLabel1.setBounds(new Rectangle(7, 31, 103, 27));
    blueBkgWhiteCharLabel2.setBounds(new Rectangle(207, 30, 97, 27));
    blueBkgWhiteCharLabel2.setBackground(Color.white);
    blueBkgWhiteCharLabel2.setForeground(Color.black);
    blueBkgWhiteCharLabel2.setText("中文名稱 :");
    this.add(blueBkgWhiteCharLabel1, null);
    this.add(txtUsrCode, null);
    this.add(blueBkgWhiteCharLabel2, null);
    this.add(txtUsrMdnName, null);
    this.add(whiteBkgBlueCharLabel2, null);
    this.add(txtUsrEngName, null);
    this.add(blueBkgWhiteCharLabel3, null);
    this.add(jScrollPane1, null);
    jScrollPane1.getViewport().add(txtRemark);
  }
  public void doPrint(){}
  public void record2Gui(){
    try{
      dataBoundGUIs.clear();
      Object vftxtUsrMdnName = exgui.verification.CellFormat.getOrdinaryField(20);
      Object vftxtUsrRemark =  exgui.verification.CellFormat.getOrdinaryField(255);
      dataBoundGUIs.add(new exgui.DataBindTextWithChecker(txtUsrMdnName,
          "USR_NAME", recToMapping.get("USR_NAME"), 20,
                        (exgui.Object2String)vftxtUsrMdnName,
                           (exgui.ultratable.CellTxtEditorFormat)
                           vftxtUsrMdnName)
                        );
      dataBoundGUIs.add(new exgui.DataBindTextWithChecker(txtUsrEngName,
          "USR_ENG_NAME", recToMapping.get("USR_ENG_NAME"), 20,
          (exgui.Object2String)vftxtUsrMdnName,
                        (exgui.ultratable.CellTxtEditorFormat)vftxtUsrMdnName)
                        );

      dataBoundGUIs.add(new exgui.DataBindTextWithChecker(txtUsrCode,
          "USR_CODE", recToMapping.get("USR_CODE"), 20,
                        (exgui.Object2String)vftxtUsrMdnName,
                           (exgui.ultratable.CellTxtEditorFormat)vftxtUsrMdnName)
                        );

      dataBoundGUIs.add(new exgui.DataBindTextWithChecker(txtRemark,
          "REMARK_1", recToMapping.get("REMARK_1"), 255,
                        (exgui.Object2String)vftxtUsrRemark,
                           (exgui.ultratable.CellTxtEditorFormat)vftxtUsrRemark)
                        );
      String remark=(String)recToMapping.get(3);
      String usrCode=(String)recToMapping.get(0);
      String mdnName=(String)recToMapping.get(1);
      String engName=(String)recToMapping.get(2);
      txtRemark.setText(remark==null?"":remark);
      txtUsrCode.setText(usrCode==null?"":usrCode);
      txtUsrEngName.setText(engName==null?"":engName);
      txtUsrMdnName.setText(mdnName==null?"":mdnName);


    }catch(Exception exp){
      exp.printStackTrace();
    }
  }
  public boolean gui2Record(){
    if(txtUsrCode.getText().trim().length()==0){
      exgui.verification.VerifyLib.showAlert("User Code Can Not Be Blank","Please Assign User Code");
      return false;
    }
    if(txtUsrMdnName.getText().trim().length()==0){
      exgui.verification.VerifyLib.showAlert("請指定中文名稱","請指定中文名稱");
      return false;
    }

    //incase user english is case sensitive;
    boolean result=super.gui2Record();
    recToMapping.set(2,txtUsrEngName.getText().trim());
    recToMapping.set(3,txtRemark.getText().trim());
    return result;
  }
  public void doUpdateAndCheck()throws ExceptionUserCodeAlreadyExists{
      try{
        if(recToMapping.getInt("record_delete_flag")==-1){
          //add new status.check if code exists or not
          String usrCode=txtUsrCode.getText().trim().toUpperCase();
          java.util.Vector vct=
              exgui2.CONST.BASIC_MAIN_EJB.getDatas(
               util.PublicVariable.USER_RECORD,
               "select * from DEBITNOTE_USER where usr_code='"+usrCode+"' and cen_code='"+util.PublicVariable.OPERATTING_CENTER+"'",1,1);
          if(vct.size()==1){
            exgui.verification.VerifyLib.showAlert("USER CODE:\""+usrCode+"\" ALREADY EXISTS ",
                                                   "USER CODE 已存在");
            throw new ExceptionUserCodeAlreadyExists(usrCode);
          }

        }
        java.util.Vector vct = new java.util.Vector();
        vct.add(recToMapping);
        dbprc.updateRecords(vct);
      }catch(Exception exp){
        exp.printStackTrace();
        exgui.verification.VerifyLib.showAlert("ERROR WHILE UPDATE USER RECORD\nPlease Contact System Manager",
                                               "UPdate Fail");
      }
    }


}

