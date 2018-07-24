package newtimes.accounting.debit_note;

import java.awt.*;
import exgui.*;
import javax.swing.*;
import java.awt.event.*;
import database.datatype.Record;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class PnlEditDebitNoteDetail
    //extends JPanel {
    extends processhandler.template.PnlFieldsEditor{
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel1 = new BlueBkgWhiteCharLabel();
  JButton btnOK = new JButton();
  JButton btnExit = new JButton();
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel2 = new BlueBkgWhiteCharLabel();
  JTextField txtSeqItem = new JTextField();
  WhiteBkgBlueCharLabel whiteBkgBlueCharLabel1 = new WhiteBkgBlueCharLabel();
  JComboBox cbxKind = new JComboBox();
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel3 = new BlueBkgWhiteCharLabel();
  JTextField txtAmount = new JTextField();
  BlueBkgWhiteCharLabel lblCurrency = new BlueBkgWhiteCharLabel();
  JScrollPane jScrollPane1 = new JScrollPane();
  JTextArea txtDesc = new JTextArea();
  javax.swing.JDialog dlg2Show;
  JButton btnDelete = new JButton();
  static String InitKindString;
  JButton btnCopy = new JButton();
  JButton btnPast = new JButton();
  JButton btnChangeDbntHeadStyRmk = new JButton();
  BlueBkgWhiteCharLabel lblDebitNoteHeadStyRemarkCol1 = new BlueBkgWhiteCharLabel();
  JButton btnCopyFromDbCr = new JButton();
  JTextField txtXchgRate = new JTextField();
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel4 = new BlueBkgWhiteCharLabel();
  public PnlEditDebitNoteDetail(exgui.ultratable.PagedDataFactory _dbHanler,Record rec,javax.swing.JDialog _dlg) {
    super(rec,_dbHanler);
    dlg2Show=_dlg;
    try {
      jbInit();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }

 protected void jbInit() throws Exception {
    blueBkgWhiteCharLabel1.setText("Edit Detail ");
    blueBkgWhiteCharLabel1.setBounds(new Rectangle(0, 37, 653, 31));
    this.setBackground(new Color(202, 202, 244));
    this.setLayout(null);
    btnOK.setBounds(new Rectangle(21, 315, 110, 31));
    btnOK.setFont(new java.awt.Font("Dialog", 1, 11));
    btnOK.setText("OK");
    btnOK.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnOK_actionPerformed(e);
      }
    });
    btnExit.setText("EXIT");
    btnExit.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnExit_actionPerformed(e);
      }
    });
    btnExit.setBounds(new Rectangle(513, 315, 110, 31));
    btnExit.setFont(new java.awt.Font("Dialog", 1, 11));
    blueBkgWhiteCharLabel2.setText("ITEM  NO. :");
    blueBkgWhiteCharLabel2.setBounds(new Rectangle(7, 78, 125, 23));
    txtSeqItem.setText("");
    txtSeqItem.setBounds(new Rectangle(131, 78, 145, 23));
    whiteBkgBlueCharLabel1.setText("KIND");
    whiteBkgBlueCharLabel1.setBounds(new Rectangle(395, 78, 73, 23));
    cbxKind.setBounds(new Rectangle(469, 78, 165, 23));
    blueBkgWhiteCharLabel3.setBounds(new Rectangle(488, 119, 68, 23));
    blueBkgWhiteCharLabel3.setBackground(new Color(202, 202, 244));
    blueBkgWhiteCharLabel3.setForeground(Color.black);
    blueBkgWhiteCharLabel3.setOpaque(true);
    blueBkgWhiteCharLabel3.setText("AMT");
    txtAmount.setBounds(new Rectangle(483, 143, 136, 23));
    txtAmount.setText("");
    lblCurrency.setBackground(new Color(202, 202, 244));
    lblCurrency.setFont(new java.awt.Font("Dialog", 1, 12));
    lblCurrency.setForeground(Color.black);
    lblCurrency.setText("");
    lblCurrency.setBounds(new Rectangle(556, 119, 68, 23));
    jScrollPane1.setBounds(new Rectangle(13, 143, 453, 135));
    txtDesc.setFont(new java.awt.Font("DialogInput", 0, 12));
    btnDelete.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnDelete_actionPerformed(e);
      }
    });
    btnDelete.setText("DELETE");
    btnDelete.setFont(new java.awt.Font("Dialog", 1, 11));
    btnDelete.setForeground(Color.red);
    btnDelete.setBounds(new Rectangle(422, 315, 79, 31));
    btnCopy.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnCopy_actionPerformed(e);
      }
    });
    btnCopy.setText("COPY");
    btnCopy.setFont(new java.awt.Font("Dialog", 1, 11));
    btnCopy.setBounds(new Rectangle(156, 315, 110, 31));
    btnPast.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnPast_actionPerformed(e);
      }
    });
    btnPast.setText("PASTE");
    btnPast.setFont(new java.awt.Font("Dialog", 1, 11));
    btnPast.setSelected(false);
    btnPast.setBounds(new Rectangle(272, 315, 110, 31));
    btnChangeDbntHeadStyRmk.setBounds(new Rectangle(492, 241, 150, 25));
    btnChangeDbntHeadStyRmk.setFont(new java.awt.Font("Dialog", 1, 11));
    btnChangeDbntHeadStyRmk.setText("Chage Colum Title");
    btnChangeDbntHeadStyRmk.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnChangeDbntHeadStyRmk_actionPerformed(e);
      }
    });
    lblDebitNoteHeadStyRemarkCol1.setText("REF NO.               DESCRIPTION");
    lblDebitNoteHeadStyRemarkCol1.setForeground(Color.black);
    lblDebitNoteHeadStyRemarkCol1.setHorizontalAlignment(SwingConstants.LEADING);
    lblDebitNoteHeadStyRemarkCol1.setBackground(new Color(202, 202, 244));
    lblDebitNoteHeadStyRemarkCol1.setFont(new java.awt.Font("DialogInput", 1, 12));
    lblDebitNoteHeadStyRemarkCol1.setBounds(new Rectangle(15, 116, 467, 23));
    btnCopyFromDbCr.setBounds(new Rectangle(156, 349, 224, 31));
    btnCopyFromDbCr.setFont(new java.awt.Font("Dialog", 1, 11));
    btnCopyFromDbCr.setText("COPY From Other DB/CR");
    btnCopyFromDbCr.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnCopyFromDbCr_actionPerformed(e);
      }
    });
    txtXchgRate.setHorizontalAlignment(txtXchgRate.RIGHT);
    txtXchgRate.setText("");
    txtXchgRate.setBounds(new Rectangle(483, 190, 136, 23));
    blueBkgWhiteCharLabel4.setText("EXCHANGE RATE");
    blueBkgWhiteCharLabel4.setOpaque(true);
    blueBkgWhiteCharLabel4.setForeground(Color.black);
    blueBkgWhiteCharLabel4.setBackground(new Color(202, 202, 244));
    blueBkgWhiteCharLabel4.setBounds(new Rectangle(488, 166, 111, 23));
    this.add(blueBkgWhiteCharLabel1, null);
    this.add(blueBkgWhiteCharLabel2, null);
    this.add(jScrollPane1, null);
    this.add(blueBkgWhiteCharLabel3, null);
    this.add(lblCurrency, null);
    this.add(whiteBkgBlueCharLabel1, null);
    this.add(cbxKind, null);
    this.add(txtAmount, null);
    this.add(btnExit, null);
    this.add(btnOK, null);
    this.add(btnDelete, null);
    this.add(btnCopy, null);
    this.add(btnPast, null);
    this.add(txtSeqItem, null);
    this.add(btnChangeDbntHeadStyRmk, null);
    this.add(lblDebitNoteHeadStyRemarkCol1, null);
    this.add(btnCopyFromDbCr, null);
    this.add(txtXchgRate, null);
    this.add(blueBkgWhiteCharLabel4, null);
    txtAmount.setHorizontalAlignment(txtAmount.RIGHT);
    jScrollPane1.getViewport().add(txtDesc, null);
  }
  public void doPrint(){}
  public boolean isContextModified(){return false ;}
  public void record2Gui(){
    dataBoundGUIs.clear();
    try{
   Object objLbl1=Constans.EDITING_DEBITNOTE_HEAD_ECORD.get("DBNT_STY_RMK_COL1") ;
   if(null!=objLbl1 && objLbl1.toString().trim().length()>0){
     lblDebitNoteHeadStyRemarkCol1.setText(objLbl1.toString().trim());
   }
   /*
   Object objLbl2=Constans.EDITING_DEBITNOTE_HEAD_ECORD.get("DBNT_STY_RMK_COL2") ;
   if(null!=objLbl2 && objLbl2.toString().trim().length()>0){
     lblDebitNoteHeadStyRemarkCol2.setText(objLbl2.toString().trim());
   }*/


     exgui.DataBindJCombobox DbJcbxcbxKind =
         new exgui.DataBindJCombobox(
                   cbxKind,"DBNT_DTL_KIND",
                   Constans.VCT_DEBITNOTE_KIND,
                   "DBNT_KIND_DESC",
                   "SEQ_STR",
                   recToMapping.get("DBNT_DTL_KIND"));
     dataBoundGUIs.add(DbJcbxcbxKind);
      /*
      exgui.DataBindJCombobox DbJcbxcbxKind =
          new exgui.DataBindJCombobox(cbxKind,"DBNT_DTL_KIND",
                                      Constans.VCT_DEBITNOTE_KIND,
                                      "DBNT_KIND_DESC","DBNT_KIND_SEQ",
                                      (String)recToMapping.get("DBNT_DTL_KIND"),
                                      "",""
                                      );
      dataBoundGUIs.add(DbJcbxcbxKind);
      */

      Object vftxtSeqItem = exgui.verification.CellFormat.getOrdinaryField(20);

      dataBoundGUIs.add(new exgui.DataBindTextWithChecker(txtSeqItem,
          "DBNT_DTL_ITEM_SEQ",
          recToMapping.get("DBNT_DTL_ITEM_SEQ"), 20,
          (exgui.Object2String)vftxtSeqItem,
          (exgui.ultratable.CellTxtEditorFormat)vftxtSeqItem));

      Object vftxtDesc = exgui.verification.CellFormat.getOrdinaryField(7500);
      dataBoundGUIs.add(new exgui.DataBindTextWithChecker(txtDesc,
          "DBNT_DTL_DESC",
          recToMapping.get("DBNT_DTL_DESC"), 7500,
          (exgui.Object2String)vftxtDesc,(exgui.ultratable.CellTxtEditorFormat)vftxtDesc));

      //txtDesc.setCaretPosition(0);

      Object vftxtAmount = exgui.verification.CellFormat.getDoubleFormatDot00RiteAligne(8,2);
          //getDoubleFormatAllowNull(8, 2);
      dataBoundGUIs.add(new exgui.DataBindTextWithChecker(txtAmount,
          "DBNT_DTL_AMT",
          recToMapping.get("DBNT_DTL_AMT"), 10,
          (exgui.Object2String)vftxtAmount,
                        (exgui.ultratable.CellTxtEditorFormat)vftxtAmount)
                        );


      Object vftxtXChgRate = exgui.verification.CellFormat.getDoubleFormatDot00RiteAligne(2,4);
          //getDoubleFormatAllowNull(8, 2);
      dataBoundGUIs.add(new exgui.DataBindTextWithChecker(txtXchgRate,
          "DBNT_DTL_XCHG_RATE",
          recToMapping.get("DBNT_DTL_XCHG_RATE"), 7,
          (exgui.Object2String)vftxtXChgRate,
                        (exgui.ultratable.CellTxtEditorFormat)vftxtXChgRate)
                        );


      lblCurrency.setText("("+Constans.EDITING_DEBITNOTE_HEAD_ECORD.get("DBNT_CURRENCY")+")");

      if(recToMapping.getInt(0)<1){
        btnDelete.setVisible(false);
        txtSeqItem.setEditable(true);
      }else{
        //in the editting mode,item-seq can not be edtable.
        txtSeqItem.setEditable(false);
      }
      if(recordColumnsToCopy==null){
        recordColumnsToCopy=new String[dataBoundGUIs.size()];
        for (int i = 0; i < dataBoundGUIs.size(); i++) {
         recordColumnsToCopy[i]=((exgui.DataBindGUIObject)dataBoundGUIs.get(i)).getOrgRecField();
        }
      }
      Object flag=Constans.EDITING_DEBITNOTE_HEAD_ECORD.get("editable_flag");
      if(null!=flag && "0".equals(flag.toString())){
        btnOK.setEnabled(false);
        btnDelete.setEnabled(false);
        btnPast.setEnabled(false);
        btnCopyFromDbCr.setEnabled(false);
      }
    }catch(Exception exp){
      exp.printStackTrace();
    }

  }
  public boolean gui2Record(){
    boolean result=super.gui2Record();
    if(!result) return result;
    if((String)cbxKind.getSelectedItem()==null ||((String)cbxKind.getSelectedItem()).trim().length()==0){
      exgui.verification.VerifyLib.showAlert("Please Assigne \"KIND\"",
                                             "Please Assigne \"KIND\"");
      return false;
    }
    if(txtAmount.getText().trim().length()==0){
      exgui.verification.VerifyLib.showAlert("Please Assigne \"AMT\"",
                                             "Please Assigne \"AMT\"");
      return false;
    }
    return true;
  }
  void btnExit_actionPerformed(ActionEvent e) {
    if(btnDelete.isVisible() && isContextModified()){
      if(!exgui.verification.VerifyLib.showConfirm("Context Modified\nDo You Sure To Exit","Do You Sure To Exit",
                                                   false)){

        return ;
      }
    }
    dlg2Show.dispose();
    /*
    try{
       processhandler.template.Properties.getCenteralControler().goBack();
    }catch(Exception exp){
      exp.printStackTrace();
     }
     */
  }

  void btnOK_actionPerformed(ActionEvent e) {
     if(txtSeqItem.getText().trim().length()==0){
       exgui.verification.VerifyLib.showAlert("Please Assigne SEQ","Please Assigne SEQ");
       return ;
     }
     if(txtDesc.getText().trim().length()==0){
       exgui.verification.VerifyLib.showAlert("Please Input Description","Please Input Description");
       return ;

     }

     if(!gui2Record()) return;
     java.util.Vector vct=new java.util.Vector();
     try{
       recToMapping.set("record_modify_user",util.PublicVariable.USER_RECORD.get(0));
       vct.add(recToMapping);
       dbprc.updateRecords(vct);
     }catch(Exception exp){
       exp.printStackTrace();
       exgui.verification.VerifyLib.showAlert("Update Fail !!\nPlease Contact System Manager","Update Fail");
     }
     dlg2Show.dispose();
  }
  void btnDelete_actionPerformed(ActionEvent e) {
    if(!exgui.verification.VerifyLib.showConfirm("Do You Sure To Delete?","Do You Sure To Delete ?",
                                                 false)){

      return ;
    }
    java.util.Vector vct=new java.util.Vector();
    try{
      recToMapping.set("record_delete_flag","0");
      recToMapping.set("record_delete_user",util.PublicVariable.USER_RECORD.get(0));
      vct.add(recToMapping);
      dbprc.updateRecords(vct);
    }catch(Exception exp){
      exp.printStackTrace();
      exgui.verification.VerifyLib.showAlert("Update Fail !!\nPlease Contact System Manager","Update Fail");
    }
    dlg2Show.dispose();

  }
  void btnCopy_actionPerformed(ActionEvent e) {
    doCopy();
  }
  void btnPast_actionPerformed(ActionEvent e) {
   doPaste();
  }

  void btnChangeDbntHeadStyRmk_actionPerformed(ActionEvent e) {
    DlgChangeDbHeadRmkSty dlg=new DlgChangeDbHeadRmkSty(util.PublicVariable.APP_FRAME,
                      "Change DB Style Remark",true,this);
                  dlg.setSize(610,285);
                  exgui.UIHelper.setToScreenCenter(dlg);
                  dlg.show();
  }
  void btnCopyFromDbCr_actionPerformed(ActionEvent e) {
    String result=JOptionPane.showInputDialog(
     util.PublicVariable.APP_FRAME,
      "From DB#:","請輸入DebitNote#",
      JOptionPane.QUESTION_MESSAGE);
    if(result==null)return;
    if(result.trim().length()==0){
      return;
    }
    int dbNtLength=(util.PublicVariable.OPERATTING_CENTER.endsWith("001"))?10:12;
    if(result.trim().length()!=dbNtLength){
      exgui.verification.VerifyLib.showAlert("Length of DB# is "+dbNtLength+" Characters ","Length of DB# is "+dbNtLength+" Characters");
      return;
    }
    //check if s/c exists
    try{
      StringBuffer sb=new StringBuffer();
      sb.append("select a.*, ");
      sb.append("(select DBNT_STY_RMK_COL1 from debitnote_head where dbnt_no='");sb.append(result);sb.append("') as title  ");
      sb.append("from debitnote_detail a  ");
      sb.append("where a.dbnt_no='");sb.append(result);sb.append("' order by dbnt_dtl_seq  ");

      util.MiscFunc.showProcessingMessage();
      java.util.Vector vct=exgui2.CONST.BASIC_MAIN_EJB.getDatas(
        util.PublicVariable.USER_RECORD,
        sb.toString(),1,999999);
      if(0==vct.size()){
        exgui.verification.VerifyLib.showAlert("無此DB/CR DETAIL 描述","No Description");
        return;
      }
      Record recDesc=(Record)vct.get(0);
      String txtDescStr=(String)recDesc.get("DBNT_DTL_DESC");//DBNT_DTL_DESC
      txtDesc.setText((null==txtDescStr)?"":txtDescStr);
      String title=(String)recDesc.get("title");
      lblDebitNoteHeadStyRemarkCol1.setText((title==null)?"":title);
      lblDebitNoteHeadStyRemarkCol1.validate();
      Object objAmt=recDesc.get("DBNT_DTL_AMT");
      txtAmount.setText((objAmt==null)?"":objAmt.toString());
      //NOTE !! DBNT_STY_RMK_COL1 沒有寫入 debitnote_head,請查一下為什麼!!
      Constans.EDITING_DEBITNOTE_HEAD_ECORD.set("DBNT_STY_RMK_COL1",title);
      Constans.EDITING_DEBITNOTE_HEAD_ECORD.set("DBNT_STY_RMK_COL2",null);
      Constans.EDITING_DEBITNOTE_HEAD_ECORD.getModifiedFields().clear();
      newtimesejb.TPE_MIS.TpeMisFuncHome ejbHome=
          (newtimesejb.TPE_MIS.TpeMisFuncHome)
          info_ejb.WeblogicServiceLocator.locateServiceHome(util.PublicVariable.SERVER_URL,
          "newtimesejb.TPE_MIS.TpeMisFunc");
      newtimesejb.TPE_MIS.TpeMisFunc ejb=ejbHome.create();
      java.util.HashMap hm=new java.util.HashMap();
      hm.put("TPEMISCFUNC_ACTION_CODE","UPDATE_DEBITNOTE_HEAD_STY_REMARK_FIELDS");
      hm.put("user_code",util.PublicVariable.USER_RECORD.get(0));
      hm.put("DBNT_NO",Constans.EDITING_DEBITNOTE_HEAD_ECORD.get(0));
      hm.put("DBNT_STY_RMK_COL1",title);
      hm.put("DBNT_STY_RMK_COL2",null);
      ejb.tpeMisFunc(hm);


      util.MiscFunc.hideProcessingMessage();
    }catch(Exception exp){
      exp.printStackTrace();
      util.ExceptionLog.exp2File(exp,"");
      exgui.verification.VerifyLib.showAlert("Connection Error\nPlease Notify System Manager",
                                             "Connection Error");
    }

  }
}
