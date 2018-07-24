package newtimes.accounting.debit_note;

import java.awt.*;
import javax.swing.*;
import exgui.*;
import java.awt.event.*;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class DlgAddDebitNoteNo extends JDialog {
  JPanel panel1 = new JPanel();
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel1 = new BlueBkgWhiteCharLabel();
  JLabel jLabel1 = new JLabel();
  JComboBox cbxDep = new JComboBox();
  JLabel jLabel2 = new JLabel();
  JTextField txtYear = new JTextField();
  JLabel jLabel3 = new JLabel();
  JTextField txtMonth = new JTextField();
  JLabel jLabel4 = new JLabel();
  JComboBox cbxType = new JComboBox();
  JButton btnOK = new JButton();
  JButton btnEXIT = new JButton();
  BorderLayout borderLayout1 = new BorderLayout();
  exgui.ultratable.Wraper4tblCbx DrCrType[]=null;
  static String DrCrTypeValue[]={"D","C","B","M"};
  static String DrCrTypeString[]={"DEBIT","CREDIT","BUYER COMMISSION","MAKER COMMISSION"};
  exgui.DataBindJCombobox dbCbxDep;
  java.text.NumberFormat nf=new java.text.DecimalFormat("000");
  JButton btnTempDbCr = new JButton();
  String finalDbCrNo=null;
  String cloneFromDbNo=null;
  public DlgAddDebitNoteNo(Frame frame, String title, String _cloneFromDbNo,boolean modal){
    this(frame,title,modal);
    cloneFromDbNo=_cloneFromDbNo;
  }
  public DlgAddDebitNoteNo(Frame frame, String title, boolean modal) {
    super(frame, title, modal);
    DrCrType=new exgui.ultratable.Wraper4tblCbx[DrCrTypeValue.length];
    finalDbCrNo=null;
    try {
      jbInit();
      pack();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }

  public DlgAddDebitNoteNo() {
    this(null, "", false);
  }

  private void jbInit() throws Exception {
    panel1.setLayout(null);
    this.getContentPane().setLayout(borderLayout1);
    blueBkgWhiteCharLabel1.setText("PLEASE INPUT INIT-VALUE OF DB/CR NO.");
    blueBkgWhiteCharLabel1.setBounds(new Rectangle(0, 35, 400, 31));
    jLabel1.setFont(new java.awt.Font("Dialog", 1, 11));
    jLabel1.setText("DEPARTMENT:");
    jLabel1.setBounds(new Rectangle(41, 127, 99, 23));
    cbxDep.setBounds(new Rectangle(125, 127, 191, 24));
    jLabel2.setFont(new java.awt.Font("Dialog", 1, 11));
    jLabel2.setText("YEAR");
    jLabel2.setBounds(new Rectangle(41, 159, 72, 16));
    txtYear.setText("");
    txtYear.setBounds(new Rectangle(125, 159, 69, 23));
    jLabel3.setBounds(new Rectangle(41, 186, 72, 16));
    jLabel3.setText("MONTH");
    jLabel3.setFont(new java.awt.Font("Dialog", 1, 11));
    txtMonth.setBounds(new Rectangle(125, 186, 69, 23));
    txtMonth.setText("");
    jLabel4.setFont(new java.awt.Font("Dialog", 1, 11));
    jLabel4.setText("TYTPE");
    jLabel4.setBounds(new Rectangle(41, 214, 72, 16));
    cbxType.setBounds(new Rectangle(125, 214, 135, 24));
    btnOK.setBounds(new Rectangle(72, 251, 95, 27));
    btnOK.setFont(new java.awt.Font("Dialog", 1, 11));
    btnOK.setText("OK");
    btnOK.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnOK_actionPerformed(e);
      }
    });
    btnEXIT.setText("EXIT");
    btnEXIT.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnEXIT_actionPerformed(e);
      }
    });
    btnEXIT.setBounds(new Rectangle(233, 251, 95, 27));
    btnEXIT.setFont(new java.awt.Font("Dialog", 1, 11));
    btnTempDbCr.setBounds(new Rectangle(46, 76, 272, 29));
    btnTempDbCr.setFont(new java.awt.Font("DialogInput", 1, 16));
    btnTempDbCr.setForeground(Color.blue);
    btnTempDbCr.setText("±¾±b");
    btnTempDbCr.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnTempDbCr_actionPerformed(e);
      }
    });
    getContentPane().add(panel1, BorderLayout.CENTER);
    panel1.add(blueBkgWhiteCharLabel1, null);
    panel1.add(btnOK, null);
    panel1.add(btnEXIT, null);
    panel1.add(jLabel1, null);
    panel1.add(cbxDep, null);
    panel1.add(jLabel2, null);
    panel1.add(txtYear, null);
    panel1.add(jLabel3, null);
    panel1.add(txtMonth, null);
    panel1.add(jLabel4, null);
    panel1.add(cbxType, null);
    panel1.add(btnTempDbCr, null);

    dbCbxDep=
       new exgui.DataBindJCombobox(
            cbxDep,"",
            newtimes.preproduction.guis.tempProperties.tmpDepartment,
            "DEP_NAME", "DEP_PREFIX",
           util.PublicVariable.USER_RECORD.get(5));
      for(int i=0;i<DrCrTypeValue.length;i++){
           DrCrType[i]=new exgui.ultratable.Wraper4tblCbx();
           DrCrType[i].setValue(DrCrTypeValue[i]);
           DrCrType[i].setString(DrCrTypeString[i]);
        }

      if(util.PublicVariable.USER_RECORD.getInt(2)==
         newtimesejb.preproduction.PreProductionHead.USER_TYPE_SUPERVIOSER_MIS){
        cbxType.setModel(new javax.swing.DefaultComboBoxModel(DrCrType));
      }else{
        exgui.ultratable.Wraper4tblCbx DrCrTypeAccounting[]=new exgui.ultratable.Wraper4tblCbx[DrCrTypeValue.length];
        for(int ik=0;ik<DrCrTypeValue.length;ik++){
          DrCrTypeAccounting[ik]=new exgui.ultratable.Wraper4tblCbx();
          DrCrTypeAccounting[ik].setValue(DrCrTypeValue[ik]);
          DrCrTypeAccounting[ik].setString(DrCrTypeString[ik]);
        }
        /*
        DrCrTypeAccounting[0]=new exgui.ultratable.Wraper4tblCbx();
        DrCrTypeAccounting[0].setValue(DrCrTypeValue[0]);
        DrCrTypeAccounting[0].setString(DrCrTypeString[0]);

        DrCrTypeAccounting[1]=new exgui.ultratable.Wraper4tblCbx();
        DrCrTypeAccounting[1].setValue(DrCrTypeValue[1]);
        DrCrTypeAccounting[1].setString(DrCrTypeString[1]);
        */
        cbxType.setModel(new javax.swing.DefaultComboBoxModel(DrCrTypeAccounting));
      }


      Object vftxtYear = exgui.verification.CellFormat.getOrdinaryFieldNotAllowNull(4);
      Object vftxtMonth = exgui.verification.CellFormat.getOrdinaryFieldNotAllowNull(2);
      java.util.Calendar cldr=java.util.Calendar.getInstance();
      new exgui.DataBindTextWithChecker(txtYear, "_YEAR",
          new Integer(cldr.get(java.util.Calendar.YEAR)), 4,
          (exgui.Object2String) vftxtYear,
          (exgui.ultratable.CellTxtEditorFormat) vftxtYear);

    new exgui.DataBindTextWithChecker(txtMonth, "_MONTH",
        new Integer(cldr.get(java.util.Calendar.MONTH)+1), 2,
        (exgui.Object2String) vftxtMonth,
        (exgui.ultratable.CellTxtEditorFormat) vftxtMonth);



  }
  protected String getDepCode(String depPrefix)throws Exception{
    for(int i=0;i<newtimes.preproduction.guis.tempProperties.tmpDepartment.size();i++){
      database.datatype.Record rec = (database.datatype.Record)newtimes.preproduction.guis.tempProperties.tmpDepartment.get(i);
      if(((String)rec.get("dep_prefix")).equals(depPrefix)){
        return (String)rec.get("dep_code");
      }
    }
    return null;
  }
  void toGotoAddNewProcess(StringBuffer sb)throws Exception{
    database.datatype.Record recHead=newtimes.accounting.debit_note.Constans.DEBIT_NOTE_HEAD_DBHANDLER.getBlankRecord();    //exgui2.CONST.BASIC_MAIN_EJB.getBlankRecord("DEBITNOTE_HEAD_tbl");
    recHead.set(0,sb.toString());
    //2007-01-09,for speed up the query of report ,have to save dep code & yyyymm to head
    recHead.set("yyyymm","20" +sb.toString().substring(2,6));
    recHead.set("dep_code",getDepCode(sb.toString().substring(0,2)));
    if(null!=cloneFromDbNo){
      try{
        util.MiscFunc.showProcessingMessage();
        newtimesejb.debitNote.DebitNoteFacdeHome ejbHome=
            (newtimesejb.debitNote.DebitNoteFacdeHome)
            info_ejb.WeblogicServiceLocator.locateServiceHome(util.PublicVariable.SERVER_URL,
            "newtimesejb.debitNote.DebitNoteFacde");
        newtimesejb.debitNote.DebitNoteFacde ejb=ejbHome.create();

        database.datatype.Record recNew=
            ejb.cloneDbRec(cloneFromDbNo,recHead,util.PublicVariable.USER_RECORD.get(0).toString());

        util.MiscFunc.hideProcessingMessage();
        newtimes.accounting.debit_note.Constans.EDITING_DEBITNOTE_HEAD_ECORD=recNew;
        processhandler.template.Properties.getCenteralControler().doCommandExecute(
        new newtimes.accounting.debit_note.TgrEditDebitNoteHead());

        return;

      }catch(Exception exp){
         exp.printStackTrace();
         exgui.verification.VerifyLib.showAlert("Error While Export D/B ",
                                                "Error While Export D/B ");
         util.ExceptionLog.exp2File(exp,"");
      }
    }else{
      recHead.set("record_delete_flag",-1);
      recHead.set("DBNT_BYMKR_TYPE","BUYER");
      recHead.set("record_create_user",util.PublicVariable.USER_RECORD.get(0));
      recHead.set("record_create_date",new java.sql.Date(System.currentTimeMillis()));
      recHead.set("dbnt_print_date",new java.sql.Date(System.currentTimeMillis()));
    }
    newtimes.accounting.debit_note.Constans.EDITING_DEBITNOTE_HEAD_ECORD=recHead;
    processhandler.template.Properties.getCenteralControler().doCommandExecute(
    new newtimes.accounting.debit_note.TgrEditDebitNoteHead());
  }
  void toAssignDbCrNo(StringBuffer sb)throws Exception{
    finalDbCrNo=sb.toString();
    Constans.EDITING_DEBITNOTE_HEAD_ECORD.set("yyyymm","20" +sb.toString().substring(2,6));
    Constans.EDITING_DEBITNOTE_HEAD_ECORD.set("dep_code",getDepCode(sb.toString().substring(0,2)));
  }
  void btnOK_actionPerformed(ActionEvent e) {

    if(txtYear.getText().trim().length()==0||Integer.parseInt(txtYear.getText())<2006){
      exgui.verification.VerifyLib.showAlert("YEAR CAN NOT LESS THAN 2006",
                                             "YEAR CAN NOT LESS THAN 2006");
      return;
    }
    if(txtMonth.getText().trim().length()==0||
       Integer.parseInt(txtMonth.getText())<1||
       Integer.parseInt(txtMonth.getText())>12){
      exgui.verification.VerifyLib.showAlert("MONTH SHOULD BETWEEN 1~12",
                                             "MONTH SHOULD BETWEEN 1~12");
      return;

    }

    try{
      boolean isAllowToGoOne;

      java.util.Vector vct = exgui2.CONST.BASIC_MAIN_EJB.getDatas(
          util.PublicVariable.USER_RECORD,
          "select * from tpe_date_range where FIELD_NAME='DB' and record_delete_flag='1' and cen_code='"+util.PublicVariable.OPERATTING_CENTER+"'",
          1, 999);
      if (0 == vct.size()) {
         isAllowToGoOne = true;
      } else {
        database.datatype.Record rec = (database.datatype.Record)vct.get(0);
        int bgn = 200601;
        int end = 209912;
        String yearCode=txtYear.getText() ;
        String monthCode=(Integer.parseInt(txtMonth.getText().trim())<10)?
              ("0"+txtMonth.getText().trim()):(txtMonth.getText().trim());


        if (null != rec.get(1)) {
          bgn = Integer.parseInt(rec.get(1).toString());
        }
        if (null != rec.get(2)) {
          end = Integer.parseInt(rec.get(2).toString());
        }

        int now = Integer.parseInt(yearCode+monthCode);
        if (bgn <= now && now <= end) {
          isAllowToGoOne = true;
        } else {
          isAllowToGoOne = false;
        }
        if(!isAllowToGoOne){
          exgui.verification.VerifyLib.showAlert("Year Month Range:"+String.valueOf(bgn)+"~"+String.valueOf(end)
                                                 ,"Out Of Date Range");
          return;
        }
      }
    }catch(Exception exp){
      exp.printStackTrace();
    }


    try{
      String depCode=(String)dbCbxDep.getSelectedValue();
      if(depCode.length()>2){
        depCode=depCode.substring(depCode.length()-2,depCode.length());
      }
      String yearCode=txtYear.getText().substring(2,4) ;
      String monthCode=(Integer.parseInt(txtMonth.getText().trim())<10)?("0"+txtMonth.getText().trim()):(txtMonth.getText().trim());
      String type=(String)((exgui.ultratable.Wraper4tblCbx)cbxType.getSelectedItem()).getValue();
      newtimesejb.debitNote.DebitNoteFacdeHome ejbHome=
          (newtimesejb.debitNote.DebitNoteFacdeHome)
          info_ejb.WeblogicServiceLocator.locateServiceHome(util.PublicVariable.SERVER_URL,
         "newtimesejb.debitNote.DebitNoteFacde");
     newtimesejb.debitNote.DebitNoteFacde ejb=ejbHome.create();
     //getDbntSeq(String depCode,String yearMonthCode,String typeCode) ;
      String centerPrefix=newtimes.accounting.debit_note.Constans.getCenterPrefix((String)util.PublicVariable.OPERATTING_CENTER);
     int seq=ejb.getDbntSeq(centerPrefix,depCode,yearCode+monthCode,type);
     StringBuffer sb=new StringBuffer();
     sb.append(depCode);
     sb.append(yearCode);
     sb.append(monthCode);
     sb.append(type);
     sb.append(nf.format(seq));
     if(!"001".equals(util.PublicVariable.OPERATTING_CENTER)){
       sb.append(Constans.getCenterPrefix(util.PublicVariable.OPERATTING_CENTER));
     }
     if(!btnTempDbCr.isVisible()&&(null==cloneFromDbNo)){
       toAssignDbCrNo(sb);
     }else{
       toGotoAddNewProcess(sb);
     }
     dispose();
    }catch(Exception exp){
      exp.printStackTrace();
      util.ExceptionLog.exp2File(exp,"");
      exgui.verification.VerifyLib.showAlert("Error While Generating DB/CR NO\nPlease Constact System Manager",
                                             "Error While Generating DB/CR NO");

      return;
    }
  }
  void btnEXIT_actionPerformed(ActionEvent e) {
    this.dispose();
  }

  void btnTempDbCr_actionPerformed(ActionEvent e) {
    try{
      newtimesejb.debitNote.DebitNoteFacdeHome ejbHome =
          (newtimesejb.debitNote.DebitNoteFacdeHome)
          info_ejb.WeblogicServiceLocator.locateServiceHome(util.PublicVariable.
          SERVER_URL,
          "newtimesejb.debitNote.DebitNoteFacde");
      newtimesejb.debitNote.DebitNoteFacde ejb = ejbHome.create();
      //getDbntSeq(String depCode,String yearMonthCode,String typeCode) ;
      String centerPrefix=newtimes.accounting.debit_note.Constans.getCenterPrefix((String)util.PublicVariable.OPERATTING_CENTER);
      int seq = ejb.getDbntSeq(centerPrefix,null,null,null);
      database.datatype.Record recHead = newtimes.accounting.debit_note.
          Constans.DEBIT_NOTE_HEAD_DBHANDLER.getBlankRecord(); //exgui2.CONST.BASIC_MAIN_EJB.getBlankRecord("DEBITNOTE_HEAD_tbl");
      java.text.NumberFormat nfTemp=new java.text.DecimalFormat("00000000000000");
      recHead.set(0, nfTemp.format(seq));
      recHead.set("record_delete_flag", -1);
      recHead.set("DBNT_BYMKR_TYPE", "BUYER");
      recHead.set("record_create_user", util.PublicVariable.USER_RECORD.get(0));
      recHead.set("record_create_date",new java.sql.Date(System.currentTimeMillis()));
      recHead.set("dbnt_print_date",new java.sql.Date(System.currentTimeMillis()));

      newtimes.accounting.debit_note.Constans.EDITING_DEBITNOTE_HEAD_ECORD =
          recHead;

      processhandler.template.Properties.getCenteralControler().
          doCommandExecute(
          new newtimes.accounting.debit_note.TgrEditDebitNoteHead());

      dispose();
    }catch(Exception exp){
      exp.printStackTrace();
    }

  }
}
