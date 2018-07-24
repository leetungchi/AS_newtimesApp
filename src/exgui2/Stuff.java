package exgui2;

import javax.swing.*;
import java.util.Vector;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class Stuff {
  public static Object System_Year = new java.sql.Date(System.currentTimeMillis()).toString().substring(0,4);
  public static Object System_Month = new java.sql.Date(System.currentTimeMillis()).toString().substring(5,7);
  public static Object System_Day = new java.sql.Date(System.currentTimeMillis()).toString().substring(8,10);
  private static String[] authType = {"CEO","Supervisor","Director","Manager",
                                      "User","Other","Abroad User","Shipping","Accounting"};
  private static String[] buyMkType = {"Buyer","Maker","Fabric Mill","Wash Mill",
                                       "Sewing Shop","Licensee","Shipping","Others",
                                       ////MESSERS, SUPPLIER, MANUFACTURER & CONSIGNEE
                                       "MESSERS", "SUPPLIER", "MANUFACTURER","CONSIGNEE","VENDOR"};
  private static String[] downloadType = {"Excel (*.xls)","PDF (*.pdf)","Text (*.txt)","RTF (*.rtf)"};
  public static String[] QUOTA_AREA = {"U","C","E","I"};

  public Stuff() {
  }

  public static Object dateProcessor(JTextField TxFidY, JTextField TxFidM, JTextField TxFidD){
    /* date process */
    String JTFy = TxFidY.getText().trim();
    String JTFm = TxFidM.getText().trim();
    String JTFd = TxFidD.getText().trim();
    if (JTFy.equals("") || JTFm.equals("") || JTFd.equals("")) {
      return new java.sql.Date(System.currentTimeMillis());
    } else {
      java.sql.Date sqld = null;
      try {
        java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy/MM/dd");
        java.util.Date date = sdf.parse(JTFy+"/"+JTFm+"/"+JTFd);
        sqld = new java.sql.Date(date.getTime());
      } catch (Exception e) {
        e.printStackTrace();
      }
      return sqld;
    }
  }

  public static boolean checkInteger(JFrame frame, String getValue, String msg) {
    String chkValue = "0123456789";
    getValue = getValue.trim();
    for(int i=0; i<getValue.length(); i++) {
      int v = chkValue.indexOf(getValue.charAt(i));
      if(v == -1) {
        exgui2.InfoMessage.warningMessage(frame, msg);
        return false;
      }
    }
    return true;
  }

  public static boolean checkNull(JFrame frame, String value, String msg) {
    value = value.trim();
    if(value.length() <= 0) {
      exgui2.InfoMessage.warningMessage(frame, msg);
      return false;
    }
    return true;
  }

  /**
   * Definition values for every user type.
   *
   *  Values    User Type
   * ====================================================
   *     1      CEO
   *     2      Supervisor(MIS)
   *     3      Director
   *     4      Manager
   *     5      User
   *     6      Other (船務,會計)
   *     7      Abroad User (海外人員,包括船務,會計)
   * ====================================================
   */
  public static String getUserTypeValue4JComboBox(JComboBox authComboBox){
    String usrType = null;
    usrType=String.valueOf(authComboBox.getSelectedIndex()+1);
    /*
    switch (authComboBox.getSelectedIndex()) {
      case 0: usrType = "1"; break;  //1.CEO
      case 1: usrType = "2"; break;  //2.Supervisor(MIS)
      case 2: usrType = "3"; break;  //3.Director
      case 3: usrType = "4"; break;  //4.Manager
      case 4: usrType = "5"; break;  //5.User
      case 5: usrType = "6"; break;  //6.Other
      case 6: usrType = "7"; break;  //7.Abroad User
    }
    */
    return usrType;
  }
  /**
   * Show user type for JComboBox.
   */
  public static JComboBox getUserType4JComboBox(JComboBox authComboBox) {
    for (int i = 0; i < authType.length; i++) {
      authComboBox.addItem(authType[i]);
    }
    return authComboBox;
  }


  /**
   * Definition values for buyer maker type.
   *
   *  Values    Buyer Maker Type
   * ===========================
   *     1      Buyer
   *     2      Maker
   *     3      Fabric Mill
   *     4      Wash Mill
   *     5      Sewing Shop
   *     6      Licensee
   *     7      Shipping
   *     8      Others
   *   ////MESSERS, SUPPLIER, MANUFACTURER & CONSIGNEE
   *       9        10        11             12
   * ===========================
   */
  public static String getBuyMkTypeValue4JComboBox(JComboBox buyMkComboBox,
                                                   boolean isFirstItemBlank){
    String buyMkType = "";
    int i = buyMkComboBox.getSelectedIndex();
    if (isFirstItemBlank) i = i-1;
    else i = i;
    switch(i){
      case 0: buyMkType = "1"; break; //Buyer
      case 1: buyMkType = "2"; break; //Maker
      case 2: buyMkType = "3"; break; //Fabric Mill
      case 3: buyMkType = "4"; break; //Wash Mill
      case 4: buyMkType = "5"; break; //Sewing Shop
      case 5: buyMkType = "6"; break; //Licensee
      case 6: buyMkType = "7"; break; //Shipping
      case 7: buyMkType = "8"; break; //Others
        //MESSERS, SUPPLIER, MANUFACTURER & CONSIGNEE
      case 8: buyMkType = "9"; break; //MESSERS
      case 9: buyMkType = "10"; break; //SUPPLIER
      case 10: buyMkType = "11"; break; //MANUFACTURER
      case 11: buyMkType = "12"; break; //CONSIGNEE
      case 12:buyMkType = "13"; break; //vendor
    }
    return buyMkType;
  }
  /**
   * Show buyer maker type for JComboBox.
   */
  public static JComboBox getBuyMkType4JComboBox(JComboBox buyMkComboBox){
    for(int i=0; i<buyMkType.length; i++){
      buyMkComboBox.addItem(buyMkType[i]);
    }
    return buyMkComboBox;
  }

  /**
   * Definition values for quota area code.
   *
   *  Values    Quota Area Code
   * ===========================
   *     U      U
   *     C      C
   *     E      E
   *     I      I
   * ===========================
   */
  public static String getQuotaAreaCodeValue4JComboBox(JComboBox qtaAreaComboBox){
     String areaCode = null;
     switch (qtaAreaComboBox.getSelectedIndex()) {
       case 0: areaCode = "U"; break;  //U
       case 1: areaCode = "C"; break;  //C
       case 2: areaCode = "E"; break;  //E
       case 3: areaCode = "I"; break;  //I
     }
     return areaCode;
  }
  /**
   * Show quota area code to JComboBox.
   */
  public static JComboBox getQuotaAreaCode4JComboBox(JComboBox qtaAreaComboBox){
    for(int i=0; i<QUOTA_AREA.length; i++){
      qtaAreaComboBox.addItem(QUOTA_AREA[i]);
    }
    return qtaAreaComboBox;
  }

  public static String setRadioButtonYesOrNo(JRadioButton radioButton_Yes, JRadioButton radioButton_No) {
    String yes_no = null;
    if (radioButton_Yes.isSelected()) {
      yes_no = "Y";
    } else if (radioButton_No.isSelected()) {
      yes_no = "N";
    }
    return yes_no;
  }

  public static String setRadioButtonValues(Object[][] radioButnAndExportString) {
    String rbValues = null;
    JRadioButton rb = null;
    try {
      for (int i=0; i < radioButnAndExportString.length; i++) {
        rb = (JRadioButton)radioButnAndExportString[i][0];
        if (rb.isSelected()) {
          rbValues = radioButnAndExportString[i][1].toString();
        }
      }
    } catch (Exception eRB) {
      eRB.printStackTrace();
      util.ExceptionLog.exp2File(eRB, "error at set radio button values.");
    } finally {
      return rbValues;
    }
  }

  public static void getRadioButtonYesOrNo(JRadioButton radioButton_Yes, JRadioButton radioButton_No, String getYes_No) {
    if(getYes_No.trim().equalsIgnoreCase("y")) {
      radioButton_Yes.setSelected(true);
    } else {
      radioButton_No.setSelected(true);
    }
  }

  public static void getRadioButtonValues(Object[][] radioButnAndValues, Object[] initValues) {
    try {
      for (int i=0; i < radioButnAndValues.length; i++) {
        if (radioButnAndValues[i][1].toString().equalsIgnoreCase(initValues[i].toString())) {
          ((JRadioButton)radioButnAndValues[i][0]).setSelected(true);
        } else {
          ((JRadioButton)radioButnAndValues[i][0]).setSelected(false);
        }
      }
    } catch (Exception eRB) {
      eRB.printStackTrace();
      util.ExceptionLog.exp2File(eRB,"error at get RadioButton values.");
    }
  }

  public static boolean insertMessage(JFrame frame, int insertInt) {
    boolean isOk = false;
    switch (insertInt) {
      case 0: exgui2.InfoMessage.infoMessage(frame, "Insert Succeed.");
              isOk = true; break;
      case 1: exgui2.InfoMessage.warningMessage(frame, "Insert Failed.");
              isOk = false; break;
      case 2: exgui2.InfoMessage.warningMessage(frame, "Insert a Record with a Duplicate (Unique) Key.");
              isOk = false; break;
      case 3: exgui2.InfoMessage.warningMessage(frame,
                "Insert Failed.\nSequence number had out of range. Seqence number > 999999");
              isOk = false; break;
    }
    return isOk;
  }

  public static boolean insertMessage(JFrame frame, int insertInt, String msg) {
    boolean isOk = false;
    switch (insertInt) {
      case -2: exgui2.InfoMessage.warningMessage(frame, "Insert a Record with a Duplicate (Unique) Key.");
              isOk = false; break;
      case -1: exgui2.InfoMessage.warningMessage(frame, msg);
              isOk = false; break;
      case 0: exgui2.InfoMessage.infoMessage(frame, "Insert Succeed.");
              isOk = true; break;
      case 1: exgui2.InfoMessage.warningMessage(frame, "Insert Failed.");
              isOk = false; break;
      case 2: exgui2.InfoMessage.warningMessage(frame, "Insert a Record with a Duplicate (Unique) Key.");
              isOk = false; break;
      case 3: exgui2.InfoMessage.warningMessage(frame,
                "Insert Failed.\nSequence number had out of range. Seqence number > 999999");
              isOk = false; break;
    }
    return isOk;
  }

  public static boolean updateMessage(JFrame frame, int updateInt) {
    boolean isOk = false;
    switch (updateInt) {
      case 0: exgui2.InfoMessage.infoMessage(frame, "Modify Succeed.");
              isOk = true; break;
      case 1: exgui2.InfoMessage.warningMessage(frame, "Modify Failed.");
              isOk = false; break;
      case 2: exgui2.InfoMessage.warningMessage(frame, "Modify a Record with a Duplicate (Unique) Key.");
              isOk = false; break;
    }
    return isOk;
  }

  public static java.util.Vector splitString(String str, String split){
    java.util.StringTokenizer st = new java.util.StringTokenizer(str,split);
    java.util.Vector vSt = new java.util.Vector();
    try {
      while (st.hasMoreTokens()) {
        vSt.add(st.nextToken());
      }
    } catch (Exception eS) {
      eS.printStackTrace();
      util.ExceptionLog.exp2File(eS,"error at splitString()."+vSt.toString());
    }
    return vSt;
  }

  /**
   * Show Download type for JComboBox.
   */
  public static JComboBox getDownloadType(JComboBox downloadComboBox){
    for(int i=0; i<downloadType.length; i++){
      downloadComboBox.addItem(downloadType[i]);
    }
    return downloadComboBox;
  }
  /**
   * Defined values for Download type.
   *
   *  Values    Download Type
   * ===========================
   *  xls       Excel (*.xls)
   *  pdf       PDF (*.pdf)
   *  tet       Text (*.txt)
   *  rtf       RTF (*.rtf)
   * ===========================
   */
  public static String getDownloadTypeValue(JComboBox downloadComboBox){
    int i = downloadComboBox.getSelectedIndex();
    String downloadType = "";
    switch(i){
      case 0: downloadType = "xls"; break;  //Excel (*.xls)
      case 1: downloadType = "pdf"; break;  //PDF (*.pdf)
      case 2: downloadType = "txt"; break;  //TEXT (*.txt)
      case 3: downloadType = "rtf"; break;  //RTF (*.rtf)
    }
    return downloadType;
  }

  public static void setNo2Txt(JTextField[] txtField, java.util.Vector vec) {
    txtField[0].setText(vec.get(0).toString());
    if (vec.size() == 2) {
      txtField[1].setText(vec.get(1).toString());
    } else {
      txtField[1].setText("00");
    }
  }

  public static boolean checkDate(JTextField year, JTextField month, JTextField day) {
    String date = year.getText().trim()+"-"+month.getText().trim()+"-"+day.getText().trim();
    return checkDateProcess(date);
  }

  public static boolean checkDate(Vector year, Vector month, Vector day) {
    boolean chkDate = true;
    label:
    for (int i = 0; i < year.size(); i++) {
      if (!(year.get(i).equals("") && month.get(i).equals("") && month.get(i).equals(""))) {
        if (!(year.get(i).equals("") || month.get(i).equals("") || month.get(i).equals(""))) {
          String date = year.get(i).toString() + "-" +
              (month.get(i).toString().length() == 1 ? "0"+month.get(i).toString() : month.get(i).toString()) + "-" +
              (day.get(i).toString().length() == 1 ? "0"+day.get(i).toString() : day.get(i).toString());
          if (!checkDateProcess(date)) {
            chkDate = false;
            break label;
          }
        } else {
          InfoMessage.infoMessage(new JFrame(),
                                "Date Format Error. Must be \"YYYY/MM/DD\"");
          chkDate = false;
          break label;
        }
      }
    }
    return chkDate;
  }

  private static boolean checkDateProcess(String date) {
    try {
      java.sql.Timestamp time = java.sql.Timestamp.valueOf(date + " 00:00:00");
      String t = new java.text.SimpleDateFormat("yyyy-MM-dd").format(time);
      if (t.equalsIgnoreCase(date)) {
        return true;
      } else {
        InfoMessage.infoMessage(new JFrame(),
                                "Date Format Error. Must be \"YYYY/MM/DD\"");
        return false;
      }
    } catch (Exception e) {
      e.printStackTrace();
      return false;
    }
  }
}
