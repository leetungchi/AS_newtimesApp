package newtimes.general_voucher;

import java.awt.*;
import javax.swing.*;
import exgui.*;
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

public class DlgAccDataEdit extends JDialog {
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel1 = new BlueBkgWhiteCharLabel();
  //WhiteBkgBlueCharLabel whiteBkgBlueCharLabel1 = new WhiteBkgBlueCharLabel();
  JLabel lblCenter = new JLabel();
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel2 = new BlueBkgWhiteCharLabel();
  //JTextField txtAccCode = new JTextField();
  WhiteBkgBlueCharLabel whiteBkgBlueCharLabel2 = new WhiteBkgBlueCharLabel();
  JTextField txtDC = new JTextField();
  WhiteBkgBlueCharLabel whiteBkgBlueCharLabel3 = new WhiteBkgBlueCharLabel();
  JTextField txtCtlCode = new JTextField();
  JTextField txtMM = new JTextField();
  WhiteBkgBlueCharLabel whiteBkgBlueCharLabel4 = new WhiteBkgBlueCharLabel();
  JTextField txtYYYY = new JTextField();
  WhiteBkgBlueCharLabel whiteBkgBlueCharLabel5 = new WhiteBkgBlueCharLabel();
  WhiteBkgBlueCharLabel whiteBkgBlueCharLabel6 = new WhiteBkgBlueCharLabel();
  JTextField txtDesc = new JTextField();
  JTextField txtInitAmt = new JTextField();
  WhiteBkgBlueCharLabel whiteBkgBlueCharLabel7 = new WhiteBkgBlueCharLabel();
  WhiteBkgBlueCharLabel whiteBkgBlueCharLabel8 = new WhiteBkgBlueCharLabel();
  JTextField txt_D_AMT = new JTextField();
  WhiteBkgBlueCharLabel whiteBkgBlueCharLabel9 = new WhiteBkgBlueCharLabel();
  JTextField txtBlncAmt = new JTextField();
  JTextField txt_C_AMT = new JTextField();
  WhiteBkgBlueCharLabel whiteBkgBlueCharLabel10 = new WhiteBkgBlueCharLabel();
  JButton btnOK = new JButton();
  JButton txtExit = new JButton();
  DbAccCodeEditor dbCbxTblAccItem = new DbAccCodeEditor();
   //JPanel pnlLayout = new JPanel();
   TempPnl pnlLayout=new TempPnl();
   exgui.ultratable.FuncAbstractUltraTablePanel pnl2list;
   java.text.NumberFormat df=new java.text.DecimalFormat("###0.00");
   processhandler.template.PnlTableEditor pnlListAccITem;
   DocChangeListener txtChgNtf=new DocChangeListener();
  public DlgAccDataEdit(Frame frame, String title, boolean modal,Record rec2Edit,
                        exgui.ultratable.FuncAbstractUltraTablePanel _pnl2list) {
    super(frame, title, modal);
    try {
      pnl2list=_pnl2list;
      pnlLayout.setPagedDataFactory(new DbAccData());
      pnlLayout.setRecord(rec2Edit);
      pnlLayout.record2Gui();
      jbInit();
      pack();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }

  public DlgAccDataEdit() {
    this(null, "", false,null,null);
  }
  void updateDcAndDesc(){
    if(pnlListAccITem.getJtable().getSelectedRow()==-1)return;
    Record rec=(Record)pnlListAccITem.getDisplayingRecords().get(pnlListAccITem.getJtable().getSelectedRow());
    //System.out.println(rec.toString());
    txtDesc.setText((String)rec.get(3));
    txtDC.setText((String)rec.get(2));

  }
  class DocChangeListener implements javax.swing.event.DocumentListener{
      public void  changedUpdate(javax.swing.event.DocumentEvent e){
        updateDcAndDesc();
      }
      public void insertUpdate(javax.swing.event.DocumentEvent e){
        updateDcAndDesc();
      }
      public void removeUpdate(javax.swing.event.DocumentEvent e){
        updateDcAndDesc();
      }
  }

  private void jbInit() throws Exception {
    getContentPane().add(pnlLayout);
    /*
    pnlLayout.setLayout(null);
    blueBkgWhiteCharLabel1.setText("EDIT VOUCHER ACCOUNT DATA");
    blueBkgWhiteCharLabel1.setBounds(new Rectangle(-1, 18, 481, 27));


    blueBkgWhiteCharLabel2.setText("ACC CODE");
    blueBkgWhiteCharLabel2.setBounds(new Rectangle(52, 92, 144, 24));
    //txtAccCode.setText("");
    //txtAccCode.setBounds(new Rectangle(196, 92, 195, 24));
    //====================================
    whiteBkgBlueCharLabel2.setBounds(new Rectangle(252, 329, 112, 24));
    whiteBkgBlueCharLabel2.setText("D/C");
    txtDC.setText("");
    txtDC.setBounds(new Rectangle(363, 329, 33, 24));
    //===================================
    whiteBkgBlueCharLabel3.setBackground(new Color(143, 143, 188));
    whiteBkgBlueCharLabel3.setForeground(Color.white);
    whiteBkgBlueCharLabel3.setText("CONTROL CODE");
    whiteBkgBlueCharLabel3.setBounds(new Rectangle(52, 329, 113, 24));
    txtCtlCode.setBounds(new Rectangle(164, 329, 83, 24));
    txtCtlCode.setText("");
    txtMM.setText("");
    txtMM.setBounds(new Rectangle(309, 121, 83, 24));
    whiteBkgBlueCharLabel4.setBackground(new Color(143, 143, 188));
    whiteBkgBlueCharLabel4.setFont(new java.awt.Font("新細明體", 0, 16));
    whiteBkgBlueCharLabel4.setForeground(Color.white);
    whiteBkgBlueCharLabel4.setText("年(民國)");
    whiteBkgBlueCharLabel4.setBounds(new Rectangle(52, 121, 112, 24));
    txtYYYY.setBounds(new Rectangle(164, 121, 75, 24));
    txtYYYY.setText("");
    whiteBkgBlueCharLabel5.setBounds(new Rectangle(236, 121, 74, 24));
    whiteBkgBlueCharLabel5.setBackground(new Color(143, 143, 188));
    whiteBkgBlueCharLabel5.setForeground(Color.white);
    whiteBkgBlueCharLabel5.setText("月");
    whiteBkgBlueCharLabel6.setText("DESCRIPTION");
    whiteBkgBlueCharLabel6.setBounds(new Rectangle(52, 156, 112, 24));
    txtDesc.setBounds(new Rectangle(164, 156, 230, 24));
    txtDesc.setText("");
    txtInitAmt.setText("");
    txtInitAmt.setBounds(new Rectangle(164, 190, 232, 24));
    whiteBkgBlueCharLabel7.setBounds(new Rectangle(52, 190, 113, 24));
    whiteBkgBlueCharLabel7.setText("期初金額");
    whiteBkgBlueCharLabel7.setForeground(Color.white);
    whiteBkgBlueCharLabel7.setFont(new java.awt.Font("新細明體", 0, 16));
    whiteBkgBlueCharLabel7.setBackground(new Color(143, 143, 188));
    whiteBkgBlueCharLabel8.setFont(new java.awt.Font("新細明體", 0, 16));
    whiteBkgBlueCharLabel8.setText("借方金額");
    whiteBkgBlueCharLabel8.setBounds(new Rectangle(52, 225, 112, 24));
    txt_D_AMT.setBounds(new Rectangle(164, 225, 232, 24));
    txt_D_AMT.setText("");
    whiteBkgBlueCharLabel9.setBackground(new Color(143, 143, 188));
    whiteBkgBlueCharLabel9.setFont(new java.awt.Font("新細明體", 0, 16));
    whiteBkgBlueCharLabel9.setForeground(Color.white);
    whiteBkgBlueCharLabel9.setText("貸方金額");
    whiteBkgBlueCharLabel9.setBounds(new Rectangle(52, 260, 113, 24));
    txtBlncAmt.setText("");
    txtBlncAmt.setBounds(new Rectangle(164, 295, 232, 24));
    txt_C_AMT.setBounds(new Rectangle(164, 260, 232, 24));
    txt_C_AMT.setText("");
    whiteBkgBlueCharLabel10.setBounds(new Rectangle(52, 295, 112, 24));
    whiteBkgBlueCharLabel10.setText("科目餘額");
    whiteBkgBlueCharLabel10.setFont(new java.awt.Font("新細明體", 0, 16));
    btnOK.setBounds(new Rectangle(102, 387, 96, 29));
    btnOK.setFont(new java.awt.Font("Dialog", 1, 11));
    btnOK.setText("OK");
    btnOK.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnOK_actionPerformed(e);
      }
    });
    txtExit.setText("EXIT");
    txtExit.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        txtExit_actionPerformed(e);
      }
    });
    txtExit.setBounds(new Rectangle(289, 388, 96, 29));
    txtExit.setFont(new java.awt.Font("Dialog", 1, 11));
    txtExit.setForeground(Color.red);

    pnlLayout.add(blueBkgWhiteCharLabel1, null);
    //pnlLayout.add(whiteBkgBlueCharLabel1, null);
    pnlLayout.add(lblCenter, null);
    pnlLayout.add(blueBkgWhiteCharLabel2, null);
    //pnlLayout.add(txtAccCode, null);
    pnlLayout.add(btnOK, null);
    pnlLayout.add(txtExit, null);
    pnlLayout.add(whiteBkgBlueCharLabel4, null);
    pnlLayout.add(txtYYYY, null);
    pnlLayout.add(whiteBkgBlueCharLabel5, null);
    pnlLayout.add(txtMM, null);
    pnlLayout.add(whiteBkgBlueCharLabel6, null);
    pnlLayout.add(txtDesc, null);
    pnlLayout.add(whiteBkgBlueCharLabel7, null);
    pnlLayout.add(txtInitAmt, null);
    pnlLayout.add(whiteBkgBlueCharLabel8, null);
    pnlLayout.add(txt_D_AMT, null);
    pnlLayout.add(whiteBkgBlueCharLabel9, null);
    pnlLayout.add(txt_C_AMT, null);
    pnlLayout.add(whiteBkgBlueCharLabel10, null);
    pnlLayout.add(txtBlncAmt, null);
    pnlLayout.add(whiteBkgBlueCharLabel2, null);
    pnlLayout.add(whiteBkgBlueCharLabel3, null);
    pnlLayout.add(txtCtlCode, null);
    pnlLayout.add(txtDC, null);
    */
  }

  void btnOK_actionPerformed(ActionEvent e) {
    try{
      //check 0~3 digits are legal
      if(!pnlLayout.checkAccCode())return;
       if(!pnlLayout.gui2Record())return;
      /*
      if(txtAccCode.getText().trim().length()<4){
        exgui.verification.VerifyLib.showAlert("PLEASE INPUT ACC CODE","PLEASE INPUT ACC CODE");
        return;
      }*/
      if(txtMM.getText().trim().length()>0){
        if((Integer.parseInt(txtMM.getText().trim())>12 && Integer.parseInt(txtMM.getText().trim())!=99)||
           Integer.parseInt(txtMM.getText().trim())<1){
          exgui.verification.VerifyLib.showAlert("MONTH RANGE SHOULD BETWEEN 1~12","MONTH OUT OF RANGE");
          return;
        }
        if(txtYYYY.getText().trim().length()==0){
          exgui.verification.VerifyLib.showAlert("Please Input Year","Input Year");
          return;
        }
      }
      if(txtYYYY.getText().trim().length()>0 &&txtMM.getText().trim().length()==0){
        exgui.verification.VerifyLib.showAlert("Please Input Month","Input Month");
        return;
      }

      pnlLayout.doUpdate();
      if(pnl2list!=null)pnl2list.reload();
      dispose();
    }catch(Exception exp){
      exp.printStackTrace();
      util.ExceptionLog.exp2File(exp,"");
    }

  }

  void txtExit_actionPerformed(ActionEvent e) {
    dispose();
  }
  class TempPnl extends processhandler.template.PnlFieldsEditor{
    TempPnl(){
       jbInit();
    }
    public void jbInit(){


      blueBkgWhiteCharLabel1.setText("EDIT VOUCHER ACCOUNT DATA");
      blueBkgWhiteCharLabel1.setBounds(new Rectangle(-1, 18, 481, 27));


      blueBkgWhiteCharLabel2.setText("ACC CODE");
      blueBkgWhiteCharLabel2.setBounds(new Rectangle(52, 92, 144, 24));
      //txtAccCode.setText("");
      //txtAccCode.setBounds(new Rectangle(196, 92, 195, 24));
      //====================================
      dbCbxTblAccItem.setBounds(new Rectangle(196, 92, 195, 24));
      whiteBkgBlueCharLabel2.setBounds(new Rectangle(252, 329, 112, 24));
      whiteBkgBlueCharLabel2.setText("D/C");
      txtDC.setText("");
      txtDC.setBounds(new Rectangle(363, 329, 33, 24));
      //===================================
      whiteBkgBlueCharLabel3.setBackground(new Color(143, 143, 188));
      whiteBkgBlueCharLabel3.setForeground(Color.white);
      whiteBkgBlueCharLabel3.setText("CONTROL CODE");
      whiteBkgBlueCharLabel3.setBounds(new Rectangle(52, 329, 113, 24));
      txtCtlCode.setBounds(new Rectangle(164, 329, 83, 24));
      txtCtlCode.setText("");
      txtMM.setText("");
      txtMM.setBounds(new Rectangle(309, 121, 83, 24));
      whiteBkgBlueCharLabel4.setBackground(new Color(143, 143, 188));
      whiteBkgBlueCharLabel4.setFont(new java.awt.Font("新細明體", 0, 16));
      whiteBkgBlueCharLabel4.setForeground(Color.white);
      whiteBkgBlueCharLabel4.setText("年(西元)");
      whiteBkgBlueCharLabel4.setBounds(new Rectangle(52, 121, 112, 24));
      txtYYYY.setBounds(new Rectangle(164, 121, 75, 24));
      txtYYYY.setText("");
      whiteBkgBlueCharLabel5.setBounds(new Rectangle(236, 121, 74, 24));
      whiteBkgBlueCharLabel5.setBackground(new Color(143, 143, 188));
      whiteBkgBlueCharLabel5.setForeground(Color.white);
      whiteBkgBlueCharLabel5.setText("月");
      whiteBkgBlueCharLabel6.setText("DESCRIPTION");
      whiteBkgBlueCharLabel6.setBounds(new Rectangle(52, 156, 112, 24));
      txtDesc.setBounds(new Rectangle(164, 156, 230, 24));
      txtDesc.setText("");
      txtInitAmt.setText("");
      txtInitAmt.setBounds(new Rectangle(164, 190, 232, 24));
      whiteBkgBlueCharLabel7.setBounds(new Rectangle(52, 190, 113, 24));
      whiteBkgBlueCharLabel7.setText("期初金額");
      whiteBkgBlueCharLabel7.setForeground(Color.white);
      whiteBkgBlueCharLabel7.setFont(new java.awt.Font("新細明體", 0, 16));
      whiteBkgBlueCharLabel7.setBackground(new Color(143, 143, 188));
      whiteBkgBlueCharLabel8.setFont(new java.awt.Font("新細明體", 0, 16));
      whiteBkgBlueCharLabel8.setText("本期借方金額");
      whiteBkgBlueCharLabel8.setBounds(new Rectangle(52, 225, 112, 24));
      txt_D_AMT.setBounds(new Rectangle(164, 225, 232, 24));
      txt_D_AMT.setText("");
      whiteBkgBlueCharLabel9.setBackground(new Color(143, 143, 188));
      whiteBkgBlueCharLabel9.setFont(new java.awt.Font("新細明體", 0, 16));
      whiteBkgBlueCharLabel9.setForeground(Color.white);
      whiteBkgBlueCharLabel9.setText("本期貸方金額");
      whiteBkgBlueCharLabel9.setBounds(new Rectangle(52, 260, 113, 24));
      txtBlncAmt.setText("");
      txtBlncAmt.setBounds(new Rectangle(164, 295, 232, 24));
      txt_C_AMT.setBounds(new Rectangle(164, 260, 232, 24));
      txt_C_AMT.setText("");
      whiteBkgBlueCharLabel10.setBounds(new Rectangle(52, 295, 112, 24));
      whiteBkgBlueCharLabel10.setText("期末餘額");
      whiteBkgBlueCharLabel10.setFont(new java.awt.Font("新細明體", 0, 16));
      btnOK.setBounds(new Rectangle(102, 387, 96, 29));
      btnOK.setFont(new java.awt.Font("Dialog", 1, 11));
      btnOK.setText("OK");
      txtExit.setBounds(new Rectangle(289, 388, 96, 29));
      txtExit.setFont(new java.awt.Font("Dialog", 1, 11));
      txtExit.setForeground(Color.red);


     //=============================================================================
      setLayout(null);
      btnOK.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(ActionEvent e) {
          btnOK_actionPerformed(e);
        }
      });
      txtExit.setText("EXIT");
      txtExit.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(ActionEvent e) {
          txtExit_actionPerformed(e);
        }
      });

      add(blueBkgWhiteCharLabel1, null);
      //add(whiteBkgBlueCharLabel1, null);
      add(lblCenter, null);
      add(blueBkgWhiteCharLabel2, null);
      //add(txtAccCode, null);
      add(dbCbxTblAccItem);
      add(whiteBkgBlueCharLabel2, null);
      add(txtDC, null);
      txtDC.setEditable(false);
      add(whiteBkgBlueCharLabel3, null);
      add(txtMM, null);
      add(whiteBkgBlueCharLabel4, null);
      add(txtYYYY, null);
      add(whiteBkgBlueCharLabel5, null);
      add(txtDesc, null);
      add(whiteBkgBlueCharLabel6, null);
      add(txtInitAmt, null);
      add(whiteBkgBlueCharLabel7, null);
      add(whiteBkgBlueCharLabel8, null);
      add(txt_D_AMT, null);
      add(whiteBkgBlueCharLabel9, null);
      add(txt_C_AMT, null);
      add(txtBlncAmt, null);
      add(txtCtlCode, null);
      add(whiteBkgBlueCharLabel10, null);
      add(btnOK, null);
      add(txtExit, null);
      //txtAccCode.addFocusListener(new AccCodeFocusListen());
    }
    /*
    class AccCodeFocusListen extends java.awt.event.FocusAdapter{
      public void focusLost(java.awt.event.FocusEvent fe){
        checkAccCode();
      }
    }
    */

    class CountBalanceListen extends java.awt.event.KeyAdapter{
      public void keyReleased(java.awt.event.KeyEvent ke){
        if(ke.getKeyChar()=='-'){
          if(ke.getSource()==(txt_C_AMT)||ke.getSource()==(txt_C_AMT))
            ke.consume() ;
            return;
        }
        javax.swing.text.JTextComponent txtAccCode=((javax.swing.text.JTextComponent)dbCbxTblAccItem.getGUIcomponent());
        String accCode=txtAccCode.getText().trim();
        if(txtAccCode.getText().trim().length()<4){
          exgui.verification.VerifyLib.showAlert("請先指定好會計項目才可以運算","無此會計項目");
          txtAccCode.grabFocus();
          ke.consume();
          return;
        }
        String accItemCode=accCode.substring(0,4);
        Record recAccItem=(Record)Constants.HT_ACC_ITEM.get(accItemCode);
        if(null==recAccItem){
          exgui.verification.VerifyLib.showAlert("  無此會計項目 : "+accItemCode+"\n請先指定好會計項目才可以運算"
                                                 ,"無此會計項目");
          txtAccCode.grabFocus();
          txtAccCode.setSelectionStart(0);
          txtAccCode.setSelectionEnd(4);
          ke.consume();
          return;
        }
        String dcCode=(String)recAccItem.get(2);

        double initAmt=(txtInitAmt.getText().trim().equals("-"))?(0):((txtInitAmt.getText().trim().length()==0)?0:Double.parseDouble(util.MiscFunc.Replace(txtInitAmt.getText().trim(),",","")));
        double cAmt=(txt_C_AMT.getText().trim().equals("-"))?(0):((txt_C_AMT.getText().trim().length()==0)?0:Double.parseDouble(util.MiscFunc.Replace(txt_C_AMT.getText().trim(),",","")));
        double dAmt=(txt_D_AMT.getText().trim().equals("-"))?(0):((txt_D_AMT.getText().trim().length()==0)?0:Double.parseDouble(util.MiscFunc.Replace(txt_D_AMT.getText().trim(),",","")));
        double balanceAmt;
        if(dcCode.equals("C"))
            balanceAmt=initAmt+cAmt-dAmt;
        else
            balanceAmt=initAmt-cAmt+dAmt;
        txtBlncAmt.setText(df.format(balanceAmt));
      }
    }
    public boolean checkAccCode(){
      javax.swing.text.JTextComponent txtAccCode=((javax.swing.text.JTextComponent)dbCbxTblAccItem.getGUIcomponent());
      if(!txtAccCode.isEditable())return true;
      if(txtAccCode.getText().trim().length()<5){
          exgui.verification.VerifyLib.showAlert("ACC CODE CAN NOT LESS TO 5 CHARACTERS","ACC CODE TOO SHORT");
          return false;
      }
      String accCode=txtAccCode.getText().trim();
      String accItemCode=accCode.substring(0,4);
      Record recAccItem=(Record)Constants.HT_ACC_ITEM.get(accItemCode);
      if(null==recAccItem){
        exgui.verification.VerifyLib.showAlert("  無此會計項目 : "+accItemCode,"無此會計項目");
        txtAccCode.grabFocus();
        txtAccCode.setSelectionStart(0);
        txtAccCode.setSelectionEnd(4);
        return false;
      }
      txtDC.setText((String)recAccItem.get(2));
      String companyCode=accCode.substring(4,5).toUpperCase();
      if(!Constants.HT_ACC_COMPANY.containsKey("GV_COMP_"+companyCode)){
        exgui.verification.VerifyLib.showAlert("  無此公司代號 : "+companyCode,"無此公司代號");
        txtAccCode.grabFocus();
        txtAccCode.setSelectionStart(4);
        txtAccCode.setSelectionEnd(5);
        return false;
      }
      recToMapping.set(2,companyCode);

      return true;
    }
    public void record2Gui(){
      dataBoundGUIs.clear();

       try{


      /*
      Object vftxtAccCode=exgui.verification.CellFormat.getOrdinaryFieldNotAllowNull(10);
       dataBoundGUIs.add(  new exgui.DataBindTextWithChecker(txtAccCode,"ACC_CODE",recToMapping.get("ACC_CODE"),10,(exgui.Object2String)vftxtAccCode,(exgui.ultratable.CellTxtEditorFormat)vftxtAccCode)
      );*/

      util.InsertionOrderedHashMap iso=new util.InsertionOrderedHashMap();
      iso.put("CODE","ITEM_CODE");
      iso.put("D/C","D_C");
      iso.put("     NAME    ","ITEM_NAME");

      dbCbxTblAccItem.init("ACC_CODE",
                           Constants.VCT_ACC_ITEM, iso, 250, 150,
                           "ITEM_CODE", "ITEM_CODE",
                           recToMapping.get("ACC_CODE"));

      pnlListAccITem=dbCbxTblAccItem.getPnlList();
      //pnlListAccITem.getJtable().addMouseListener(mosueClickNtf);
      //pnlListAccITem.getJtable().addKeyListener(keyReleaseNtf);
      ((javax.swing.text.JTextComponent)dbCbxTblAccItem.getGUIcomponent()).getDocument().addDocumentListener(
        txtChgNtf
      );

      if(recToMapping.getInt("RECORD_DELETE_FLAG")>0){
        //txtAccCode.setEnabled(false);
        ((javax.swing.text.JTextComponent)dbCbxTblAccItem.getGUIcomponent()).setEditable(false);
        ((javax.swing.text.JTextComponent)dbCbxTblAccItem.getGUIcomponent()).setText((String)recToMapping.get("ACC_CODE"));
        txtYYYY.setEditable(false);
        txtMM.setEditable(false);
      }
      Object vftxtDC=exgui.verification.CellFormat.getOrdinaryFieldNotAllowNull(1);
       dataBoundGUIs.add(  new exgui.DataBindTextWithChecker(txtDC,"D_C",recToMapping.get("D_C"),1,(exgui.Object2String)vftxtDC,(exgui.ultratable.CellTxtEditorFormat)vftxtDC)
      );
      Object vftxtCtlCode=exgui.verification.CellFormat.getOrdinaryField(10);
       dataBoundGUIs.add(  new exgui.DataBindTextWithChecker(txtCtlCode,"CNTL_CODE",recToMapping.get("CNTL_CODE"),10,(exgui.Object2String)vftxtCtlCode,(exgui.ultratable.CellTxtEditorFormat)vftxtCtlCode)
      );

      Object vftxtMM=exgui.verification.CellFormat.getIntVerifierAllowNull(2);
       dataBoundGUIs.add(  new exgui.DataBindTextWithChecker(txtMM,"YYYYMM",
           recToMapping.get("YYYYMM"),2,
           (exgui.Object2String)vftxtMM,
           (exgui.ultratable.CellTxtEditorFormat)vftxtMM)
      );

      Object vftxtYYYY=exgui.verification.CellFormat.getOrdinaryField(4);
       dataBoundGUIs.add(  new exgui.DataBindTextWithChecker(txtYYYY,"YYYYMM",
           recToMapping.get("YYYYMM"),4,
           (exgui.Object2String)vftxtYYYY,
           (exgui.ultratable.CellTxtEditorFormat)vftxtYYYY)
      );
      Object yyyymmData=recToMapping.get("YYYYMM");
      if(yyyymmData!=null){
        txtYYYY.setText(yyyymmData.toString().substring(0,yyyymmData.toString().length()-2));
        txtMM.setText(yyyymmData.toString().substring(yyyymmData.toString().length()-2,yyyymmData.toString().length()));
      }

      Object vftxtDesc=exgui.verification.CellFormat.getOrdinaryField(200);
       dataBoundGUIs.add(  new exgui.DataBindTextWithChecker(txtDesc,"REC_DESC",recToMapping.get("REC_DESC"),200,(exgui.Object2String)vftxtDesc,(exgui.ultratable.CellTxtEditorFormat)vftxtDesc)
      );
      Object vftxtInitAmt=exgui.verification.CellFormat.getDoubleFormatAllowNull(10,3);
       dataBoundGUIs.add(  new exgui.DataBindTextWithChecker(txtInitAmt,"INIT_AMT",recToMapping.get("INIT_AMT"),13,(exgui.Object2String)vftxtInitAmt,(exgui.ultratable.CellTxtEditorFormat)vftxtInitAmt)
      );
      Object vftxt_D_AMT=exgui.verification.CellFormat.getDoubleFormatAllowNull(10,3);
       dataBoundGUIs.add(  new exgui.DataBindTextWithChecker(txt_D_AMT,"D_AMT",recToMapping.get("D_AMT"),13,(exgui.Object2String)vftxt_D_AMT,(exgui.ultratable.CellTxtEditorFormat)vftxt_D_AMT)
      );
      /*
      Object vftxtBlncAmt=exgui.verification.CellFormat.getDoubleFormatAllowNull(8,3);
       dataBoundGUIs.add(  new exgui.DataBindTextWithChecker(txtBlncAmt,"BLNC_AMT",recToMapping.get("BLNC_AMT"),11,(exgui.Object2String)vftxtBlncAmt,(exgui.ultratable.CellTxtEditorFormat)vftxtBlncAmt)
      );*/

      Object vftxt_C_AMT=exgui.verification.CellFormat.getDoubleFormatAllowNull(10,3);
       dataBoundGUIs.add(  new exgui.DataBindTextWithChecker(txt_C_AMT,"C_AMT",recToMapping.get("C_AMT"),13,(exgui.Object2String)vftxt_C_AMT,(exgui.ultratable.CellTxtEditorFormat)vftxt_C_AMT)
      );
      if(recToMapping.getInt("record_delete_flag")<0){
          blueBkgWhiteCharLabel1.setText("ADD VOUCHER ACCOUNT DATA");
      }else{
          blueBkgWhiteCharLabel1.setText("EDIT VOUCHER ACCOUNT DATA");
      }
       txtBlncAmt.setEditable(false);
        CountBalanceListen countBalanace=new CountBalanceListen();
        txtInitAmt.addKeyListener(countBalanace);
        txt_C_AMT.addKeyListener(countBalanace);
        txt_D_AMT.addKeyListener(countBalanace);
        Object objInitAmt=recToMapping.get("INIT_AMT");
        Object obj_C_Amt=recToMapping.get("C_AMT");
        Object obj_D_Amt=recToMapping.get("D_AMT");
        Object objBLCAmt=recToMapping.get("GET_BLNC_AMT"); //recToMapping.get("BLNC_AMT");

        txtInitAmt.setText(df.format(Double.parseDouble(objInitAmt==null?"0":((objInitAmt.toString().trim().length()==0)?"0":objInitAmt.toString()))));
        txt_C_AMT.setText(df.format(Double.parseDouble(obj_C_Amt==null?"0":((obj_C_Amt.toString().trim().length()==0)?"0":obj_C_Amt.toString()))));
        txt_D_AMT.setText(df.format(Double.parseDouble(obj_D_Amt==null?"0":((obj_D_Amt.toString().trim().length()==0)?"0":obj_D_Amt.toString()))));
        txtBlncAmt.setText(df.format(Double.parseDouble(objBLCAmt==null?"0":((objBLCAmt.toString().trim().length()==0)?"0":objBLCAmt.toString()))));

     }catch(Exception exp){
       exp.printStackTrace();
     }
    }
    public boolean gui2Record(){
      boolean result=super.gui2Record();
      if(!result)return result;
      String yyyyStr = txtYYYY.getText().trim();
     String mmStr = txtMM.getText().trim();
      try{
      if(recToMapping.getInt("record_delete_flag")<0){
        if (yyyyStr.length() == 0) {
          exgui.verification.VerifyLib.showAlert("PLEASE INPUT YEAR",
              "PLEASE INPUT YEAR");
          txtYYYY.grabFocus();
          return false;
        }

        if (mmStr.length() == 0) {
          exgui.verification.VerifyLib.showAlert("PLEASE INPUT MONTH",
              "PLEASE INPUT MONTH");
          txtMM.grabFocus();
          return false;
        }
       }
      }catch(Exception exp){
        exp.printStackTrace();
      }
      if(mmStr.length()==1)mmStr='0'+mmStr;
      try{
        if(((javax.swing.text.JTextComponent)dbCbxTblAccItem.getGUIcomponent()).isEditable()){
          recToMapping.set("ACC_CODE",((javax.swing.text.JTextComponent)dbCbxTblAccItem.getGUIcomponent()).getText());
        }

        recToMapping.set("YYYYMM", yyyyStr + mmStr);
      }catch(Exception exp){
        util.ExceptionLog.exp2File(exp,"");
        exp.printStackTrace();
      }

      if(Double.parseDouble((txt_D_AMT.getText().trim().length()==0)?"0": txt_D_AMT.getText().trim())<0){
        exgui.verification.VerifyLib.showAlert("Debit Amt. Can not less than zero","Debit Amt. Can not less than zero");
        return false;
      }
      if(Double.parseDouble((txt_C_AMT.getText().trim().length()==0)?"0": txt_C_AMT.getText().trim())<0){
        exgui.verification.VerifyLib.showAlert("Credit Amt. Can not less than zero","Credit Amt. Can not less than zero");
        return false;
      }
      try{
        recToMapping.set("BLNC_AMT",txtBlncAmt.getText());
      }catch(Exception exp){
        exp.printStackTrace();
      }
      return true;
    }
    public void doPrint(){}

  }

}
