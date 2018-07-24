package newtimes.fty_exam;

import java.awt.*;
import javax.swing.*;
import database.datatype.Record;
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

public class DlgEditFtyExamEvent extends JDialog {
  PnlBinding pnlcontain= new PnlBinding();
  //JPanel pnlcontain = new JPanel();
  processhandler.template.PnlTableEditor pnlParent;
  Record rec2update;
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel1 = new BlueBkgWhiteCharLabel();
  WhiteBkgBlueCharLabel whiteBkgBlueCharLabel1 = new WhiteBkgBlueCharLabel();
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel2 = new BlueBkgWhiteCharLabel();
  WhiteBkgBlueCharLabel lblEmailDate = new WhiteBkgBlueCharLabel();
  JTextField txtLastExamDate = new JTextField();
  JTextField txtEmailDate = new JTextField();
  JTextField txtReplyDate = new JTextField();
  JButton btnOK = new JButton();
  JButton btnDelete = new JButton();
  JButton btnEXIT = new JButton();
  java.text.DateFormat df=new java.text.SimpleDateFormat("yyyy/MM/dd");
  JTextField txtNextExamDate = new JTextField();
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel3 = new BlueBkgWhiteCharLabel();
  JScrollPane jScrollPane1 = new JScrollPane();
  JTextArea txtRemark = new JTextArea();
  WhiteBkgBlueCharLabel whiteBkgBlueCharLabel2 = new WhiteBkgBlueCharLabel();
  JComboBox cbxBuyer = new JComboBox();
  WhiteBkgBlueCharLabel whiteBkgBlueCharLabel3 = new WhiteBkgBlueCharLabel();
  JTextField txtMaker = new JTextField();
  exgui.DataBindJCombobox dbcbx  ;
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel4 = new BlueBkgWhiteCharLabel();
  JTextField txtValiDay = new JTextField();
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel5 = new BlueBkgWhiteCharLabel();
  JTextField txtStatus = new JTextField();
  public DlgEditFtyExamEvent(Frame frame, String title, boolean modal,
                           processhandler.template.PnlTableEditor  _pnlParent,
                           Record rec2Edit) {
     super(frame, title, modal);
     try {
       rec2update = rec2Edit;
       pnlcontain.setRecord(rec2update);
       pnlParent = _pnlParent;
       jbInit();
       pack();

     } catch (Exception ex) {
       ex.printStackTrace();
    }

  }

  public DlgEditFtyExamEvent() {
    this(null, "", false,null,null);
  }

  private void jbInit() throws Exception {
    pnlcontain.setLayout(null);
    blueBkgWhiteCharLabel1.setText("LAST AUDIT DATE:");
    blueBkgWhiteCharLabel1.setBounds(new Rectangle(6, 50, 127, 29));
    whiteBkgBlueCharLabel1.setBackground(new Color(143, 143, 188));
    whiteBkgBlueCharLabel1.setForeground(Color.white);
    whiteBkgBlueCharLabel1.setText("CAP PROViDE");
    whiteBkgBlueCharLabel1.setBounds(new Rectangle(6, 114, 128, 29));
    blueBkgWhiteCharLabel2.setBounds(new Rectangle(6, 146, 127, 68));
    blueBkgWhiteCharLabel2.setBackground(Color.white);
    blueBkgWhiteCharLabel2.setForeground(new Color(143, 143, 188));
    blueBkgWhiteCharLabel2.setText("REMARK:");
    lblEmailDate.setText("EMAIL DATE:");
    lblEmailDate.setBounds(new Rectangle(206, 264, 128, 29));
    txtLastExamDate.setText("2007/10/15");
    txtLastExamDate.setBounds(new Rectangle(133, 50, 73, 29));
    txtEmailDate.setBounds(new Rectangle(333, 264, 120, 29));
    txtEmailDate.setText("jTextField1");
    txtEmailDate.setText("");
    txtReplyDate.setText("");
    txtReplyDate.setText("");
    txtReplyDate.setBounds(new Rectangle(134, 114, 73, 29));
    btnOK.setBounds(new Rectangle(68, 223, 131, 36));
    btnOK.setFont(new java.awt.Font("Dialog", 1, 11));
    btnOK.setText("OK");
    btnOK.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnOK_actionPerformed(e);
      }
    });
    btnDelete.setText("DELETE");
    btnDelete.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnDelete_actionPerformed(e);
      }
    });
    btnDelete.setFont(new java.awt.Font("Dialog", 1, 11));
    btnDelete.setForeground(Color.red);
    btnDelete.setSelected(false);
    btnDelete.setBounds(new Rectangle(231, 223, 131, 36));
    btnEXIT.setText("EXIT");
    btnEXIT.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnEXIT_actionPerformed(e);
      }
    });
    btnEXIT.setFont(new java.awt.Font("Dialog", 1, 11));
    btnEXIT.setBounds(new Rectangle(386, 223, 131, 36));
    txtNextExamDate.addFocusListener(new FocusChange());
    txtNextExamDate.setBounds(new Rectangle(357, 114, 73, 29));
    txtNextExamDate.setText("");
    blueBkgWhiteCharLabel3.setBounds(new Rectangle(208, 114, 149, 29));
    blueBkgWhiteCharLabel3.setText("NEXT AUDIT DATE:");
    jScrollPane1.setBounds(new Rectangle(134, 146, 390, 68));
    whiteBkgBlueCharLabel2.setText("Buyer");
    whiteBkgBlueCharLabel2.setBounds(new Rectangle(6, 19, 127, 28));
    cbxBuyer.setBounds(new Rectangle(133, 19, 149, 28));
    whiteBkgBlueCharLabel3.setBounds(new Rectangle(289, 19, 108, 28));
    whiteBkgBlueCharLabel3.setText("MAKER");
    txtMaker.setText("");
    txtMaker.setBounds(new Rectangle(399, 19, 116, 28));
    blueBkgWhiteCharLabel4.setText("LAST AUDIT VALIDAY:");
    blueBkgWhiteCharLabel4.setBounds(new Rectangle(6, 82, 128, 29));
    txtValiDay.setText("");
    txtValiDay.setBounds(new Rectangle(134, 82, 73, 29));
    txtValiDay.addFocusListener(new FocusChange());
    blueBkgWhiteCharLabel5.setText("LAST AUDIT STATUS:");
    blueBkgWhiteCharLabel5.setBounds(new Rectangle(208, 50, 149, 29));
    txtStatus.setText("");
    txtStatus.setBounds(new Rectangle(357, 50, 87, 29));
    txtStatus.addFocusListener(new FocusChange());
    this.getContentPane().add(pnlcontain, BorderLayout.CENTER);
    pnlcontain.add(lblEmailDate, null);
    pnlcontain.add(txtEmailDate, null);
    pnlcontain.add(whiteBkgBlueCharLabel2, null);
    pnlcontain.add(btnOK, null);
    pnlcontain.add(btnDelete, null);
    pnlcontain.add(btnEXIT, null);
    pnlcontain.add(blueBkgWhiteCharLabel2, null);
    pnlcontain.add(jScrollPane1, null);
    pnlcontain.add(whiteBkgBlueCharLabel1, null);
    pnlcontain.add(txtReplyDate, null);
    pnlcontain.add(blueBkgWhiteCharLabel3, null);
    pnlcontain.add(txtNextExamDate, null);
    pnlcontain.add(blueBkgWhiteCharLabel4, null);
    pnlcontain.add(txtValiDay, null);
    pnlcontain.add(blueBkgWhiteCharLabel1, null);
    pnlcontain.add(txtLastExamDate, null);
    pnlcontain.add(blueBkgWhiteCharLabel5, null);
    pnlcontain.add(txtStatus, null);
    pnlcontain.add(txtMaker, null);
    pnlcontain.add(whiteBkgBlueCharLabel3, null);
    pnlcontain.add(cbxBuyer, null);
    jScrollPane1.getViewport().add(txtRemark, null);
    lblEmailDate.setVisible(false);
    txtEmailDate.setVisible(false);
    pnlcontain.record2Gui();
    txtLastExamDate.addFocusListener(new FocusChange());
  }
  class FocusChange extends java.awt.event.FocusAdapter{
    public void focusLost(java.awt.event.FocusEvent fe){
        if(txtNextExamDate.getText().trim().length() ==10 ){
          //email date default is before one month of audit date
          try{
            java.util.Calendar cld=java.util.Calendar.getInstance();
            cld.setTime(df.parse(txtNextExamDate.getText()));
            cld.add(cld.MONTH,-1);
            txtEmailDate.setText(df.format(cld.getTime()));
          }catch(Exception exp){
            exp.printStackTrace();
          }
        }else{
          txtEmailDate.setText("");
        }
    }
  }

  void btnEXIT_actionPerformed(ActionEvent e) {
     if(pnlcontain.isContextModified()){
       if(!exgui.verification.VerifyLib.showConfirm("Context Modified,Do You Sure To Exit ?","Context Modified",false)){
         return ;
       }
     }
     this.dispose();
  }

  void btnDelete_actionPerformed(ActionEvent e) {
    if(!exgui.verification.VerifyLib.showConfirm("Do You Sure To Delete ?","Are You Sure ?",false)){
      return ;
    }
    try{
        rec2update.set("record_delete_flag", "0");
        java.util.HashMap hm=new java.util.HashMap();
        hm.put("RECORD",rec2update);
        hm.put("TPEMISCFUNC_ACTION_CODE","HANDLE_FTY_EXAM_HISTORY");
        newtimesejb.TPE_MIS.TpeMisFuncHome ejbhome=
            (newtimesejb.TPE_MIS.TpeMisFuncHome)
            info_ejb.WeblogicServiceLocator.locateServiceHome(util.PublicVariable.SERVER_URL,"newtimesejb.TPE_MIS.TpeMisFunc");
        newtimesejb.TPE_MIS.TpeMisFunc ejb=ejbhome.create();
        java.util.HashMap hmReturn=ejb.tpeMisFunc(hm);
        pnlParent.reload();
        dispose();
      }catch(Exception exp){
        exp.printStackTrace();
      }
  }
  void btnOK_actionPerformed(ActionEvent e) {
     if(!pnlcontain.gui2Record()){
       return;
     }
     if(txtMaker.getText().trim().length()==0 ){
       exgui.verification.VerifyLib.showAlert("Please Input MAKER","Please Input MAKER");
       return;
     }

     /*
     if(txtEmailDate.getText().trim().length()==0 ){
       exgui.verification.VerifyLib.showAlert("Please Input Email Date","Please Input Email Date");
       return;
     }

     if(txtLastExamDate.getText().trim().length()==0 ){
       exgui.verification.VerifyLib.showAlert("Please Input Audit Date","Please Input Audit Date");
       return;
     }*/
     //test if current record is add new record
     try{
       Record rec2process=pnlcontain.getEdtingRecord();
       rec2process.set(dbcbx.getOrgRecField(),dbcbx.getSelectedValue());
       int flag = rec2process.getInt("record_delete_flag");
       java.util.HashMap hm=new java.util.HashMap();
       hm.put("RECORD",rec2process);
       hm.put("TPEMISCFUNC_ACTION_CODE","HANDLE_FTY_EXAM_HISTORY");
       newtimesejb.TPE_MIS.TpeMisFuncHome ejbhome=
           (newtimesejb.TPE_MIS.TpeMisFuncHome)
           info_ejb.WeblogicServiceLocator.locateServiceHome(util.PublicVariable.SERVER_URL,"newtimesejb.TPE_MIS.TpeMisFunc");
       newtimesejb.TPE_MIS.TpeMisFunc ejb=ejbhome.create();
       java.util.HashMap hmReturn=ejb.tpeMisFunc(hm);
       Record recReturn=(Record)hmReturn.get("RECORD");
       /*
       if(flag==-1 && recPrevExamEvent!=null){
         //add new process.
         //have to set prv rec's "Next SEQ" to current record.
         recPrevExamEvent.set(1,recReturn.getInt(0));
         hm.put("RECORD",recPrevExamEvent);
         ejb.tpeMisFunc(hm);
       }*/
       pnlParent.reload();
       dispose();
     }catch(Exception exp){
       exp.printStackTrace();

     }

  }
  class PnlBinding
    //extends JPanel{
    extends processhandler.template.PnlFieldsEditor{
    public PnlBinding(){

    }

    public Record getEdtingRecord(){return recToMapping;}
    public void record2Gui(){
      dataBoundGUIs.clear();
      try{

      Object vftxtRemark=exgui.verification.CellFormat.getOrdinaryField(4000);
       dataBoundGUIs.add(  new exgui.DataBindTextWithChecker(txtRemark,"EXAM_REMARK",recToMapping.get("EXAM_REMARK"),4000,(exgui.Object2String)vftxtRemark,(exgui.ultratable.CellTxtEditorFormat)vftxtRemark)
      );
      Object objBuyerSeq=recToMapping.get("FTY_EXAM_EMAIL_SEQ");
      //System.out.println("objBuyerSeq="+objBuyerSeq.toString());
      dbcbx=new exgui.DataBindJCombobox(
                                     cbxBuyer,
                                     "FTY_EXAM_EMAIL_SEQ",
                                    Constants.vctBuyer,"BUYER_NAME",
                                    "seq",(objBuyerSeq==null)?null:(objBuyerSeq.toString())
                                    );
     //dataBoundGUIs.add(dbcbx);

      Object vftxtMaker=exgui.verification.CellFormat.getOrdinaryField(100);
      dataBoundGUIs.add(  new exgui.DataBindTextWithChecker(txtMaker,"MAKER_NAME",
                  recToMapping.get("MAKER_NAME"),100,
                  (exgui.Object2String)vftxtMaker,(exgui.ultratable.CellTxtEditorFormat)vftxtMaker)
      );

        dataBoundGUIs.add(  new exgui.DataBindTextWithChecker(txtStatus,"STATUS",
                    recToMapping.get("STATUS"),100,
                    (exgui.Object2String)vftxtMaker,(exgui.ultratable.CellTxtEditorFormat)vftxtMaker)
        );


      Object vftxtExamDate=exgui.verification.CellFormat.getDateStringFormaterAllowNull();
       dataBoundGUIs.add(  new exgui.DataBindTextWithChecker(txtLastExamDate,"LAST_EXAM_DATE",
               recToMapping.get("LAST_EXAM_DATE"),10,
               (exgui.Object2String)vftxtExamDate,(exgui.ultratable.CellTxtEditorFormat)vftxtExamDate)
      );

      Object vftxtEmailDate=vftxtExamDate;  //exgui.verification.CellFormat.getDateStringFormater();
       dataBoundGUIs.add(  new exgui.DataBindTextWithChecker(txtEmailDate,"EMAIL_DATE",recToMapping.get("EMAIL_DATE"),10,(exgui.Object2String)vftxtEmailDate,(exgui.ultratable.CellTxtEditorFormat)vftxtEmailDate)
      );

      Object vftxtReplyDate=vftxtExamDate;//exgui.verification.CellFormat.getDateStringFormater();
       dataBoundGUIs.add(  new exgui.DataBindTextWithChecker(txtReplyDate,"REPLY_DATE",recToMapping.get("REPLY_DATE"),10,(exgui.Object2String)vftxtReplyDate,(exgui.ultratable.CellTxtEditorFormat)vftxtReplyDate)
      );
      dataBoundGUIs.add(
            new exgui.DataBindTextWithChecker(txtNextExamDate,
                                              "EXAM_DATE",
                                              recToMapping.get("EXAM_DATE"),
                                              10,
                                              (exgui.Object2String)
                                              vftxtReplyDate,
                                              (exgui.ultratable.
                                               CellTxtEditorFormat)
                                              vftxtReplyDate)
      );

     dataBoundGUIs.add(
        new exgui.DataBindTextWithChecker(txtValiDay,
                                      "VALIDAY",
                                      recToMapping.get("VALIDAY"),
                                      10,
                                      (exgui.Object2String)
                                      vftxtReplyDate,
                                      (exgui.ultratable.
                                       CellTxtEditorFormat)
                                      vftxtReplyDate)
      );



       if(-1==recToMapping.getInt("record_delete_flag")){
         btnDelete.setVisible(false);
       }else{
         //since it's modifying,have to show next audit date
       }
      }catch(Exception exp){
        exp.printStackTrace();
      }

    }
    public void jbInit()throws Exception{
    }
    public void doPrint(){}

  }
}
