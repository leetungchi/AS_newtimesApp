package newtimes.accounting.local_voucher;

import java.awt.*;
import exgui.*;
import javax.swing.*;
import javax.swing.border.*;
import database.datatype.Record;
import java.awt.event.*;
/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class PlnEditLocalVoucher
  //extends JPanel {
  extends processhandler.template.PnlFieldsEditor{
  BlueBkgWhiteCharLabel lbiTitle = new BlueBkgWhiteCharLabel();
  WhiteBkgBlueCharLabel whiteBkgBlueCharLabel1 = new WhiteBkgBlueCharLabel();
  WhiteBkgBlueCharLabel lblMakerName = new WhiteBkgBlueCharLabel();
  WhiteBkgBlueCharLabel lblMakerNameChn = new WhiteBkgBlueCharLabel();
  WhiteBkgBlueCharLabel whiteBkgBlueCharLabel2 = new WhiteBkgBlueCharLabel();
  WhiteBkgBlueCharLabel whiteBkgBlueCharLabel3 = new WhiteBkgBlueCharLabel();
  JTextField txtXRate = new JTextField();
  WhiteBkgBlueCharLabel whiteBkgBlueCharLabel4 = new WhiteBkgBlueCharLabel();
  JTextField txtPrintForm = new JTextField();
  JTextField txtPrintLatter = new JTextField();
  WhiteBkgBlueCharLabel whiteBkgBlueCharLabel5 = new WhiteBkgBlueCharLabel();
  WhiteBkgBlueCharLabel whiteBkgBlueCharLabel6 = new WhiteBkgBlueCharLabel();
  WhiteBkgBlueCharLabel whiteBkgBlueCharLabel7 = new WhiteBkgBlueCharLabel();
  WhiteBkgBlueCharLabel whiteBkgBlueCharLabel8 = new WhiteBkgBlueCharLabel();
  JScrollPane jScrollPane1 = new JScrollPane();
  Border border1;
  TitledBorder titledBorder1;
  JTextArea txtDiscDesc = new JTextArea();
  java.text.NumberFormat nf=new java.text.DecimalFormat("##########0.00");
  JTextField txtDiffTll = new JTextField();
  JTextField txtDiscAmtUsd = new JTextField();
  JTextField txtSrnTtlAmt = new JTextField();
  JTextField txtShipFtyInv = new JTextField();
  WhiteBkgBlueCharLabel whiteBkgBlueCharLabel9 = new WhiteBkgBlueCharLabel();
  WhiteBkgBlueCharLabel whiteBkgBlueCharLabel10 = new WhiteBkgBlueCharLabel();
  JTextField txtShipEtd = new JTextField();
  WhiteBkgBlueCharLabel whiteBkgBlueCharLabel11 = new WhiteBkgBlueCharLabel();
  JTextField txtCreateDate = new JTextField();
  JTextField txtDiscAmt = new JTextField();
  WhiteBkgBlueCharLabel whiteBkgBlueCharLabel12 = new WhiteBkgBlueCharLabel();
  JTextField txtDkAmt = new JTextField();
  WhiteBkgBlueCharLabel whiteBkgBlueCharLabel13 = new WhiteBkgBlueCharLabel();

  public PlnEditLocalVoucher() {
    try {
      jbInit();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }

  public void doPrint(){}
  /*
  String obj2str(Object obj){
    return (obj==null)?"":obj.toString();
  }*/
  public Record editRec(){
    return recToMapping;
  }
  public boolean gui2Record(){
    updateDiscountTWD();
    return super.gui2Record();
  }
  public void record2Gui(){
    try{
      dataBoundGUIs.clear();
      Object vftxtPrintDate = exgui.verification.CellFormat.getDateStringFormaterAllowNull();
      dataBoundGUIs.add(new exgui.DataBindTextWithChecker(txtPrintForm, "PRINT_FORM",
          recToMapping.get("PRINT_FORM"), 10,
          (exgui.Object2String)vftxtPrintDate,
          (exgui.ultratable.CellTxtEditorFormat)vftxtPrintDate));

      dataBoundGUIs.add(new exgui.DataBindTextWithChecker(txtPrintLatter, "PRINT_LATTER",
          recToMapping.get("PRINT_LATTER"), 10,
          (exgui.Object2String)vftxtPrintDate,
          (exgui.ultratable.CellTxtEditorFormat)vftxtPrintDate));

      dataBoundGUIs.add(new exgui.DataBindTextWithChecker(txtCreateDate, "RECORD_CREATE_DATE",
          recToMapping.get("RECORD_CREATE_DATE"), 10,
          (exgui.Object2String)vftxtPrintDate,
          (exgui.ultratable.CellTxtEditorFormat)vftxtPrintDate));


      Object vftxtFullAmt=exgui.verification.CellFormat.getDoubleFormatDot00RiteAligne(3,4);
      Object vftxtDouble=exgui.verification.CellFormat.getDoubleFormatDot00RiteAligne(8,2);
      Object ch25Vfy=exgui.verification.CellFormat.getOrdinaryField(25);
       dataBoundGUIs.add(  new exgui.DataBindTextWithChecker(txtXRate,"EXCHANGE_RATE",
           recToMapping.get("exchange_rate"),8,
           (exgui.Object2String)vftxtFullAmt,(exgui.ultratable.CellTxtEditorFormat)vftxtFullAmt)
      );

      dataBoundGUIs.add(  new exgui.DataBindTextWithChecker(txtDiffTll,"DIFF_TTL",
          recToMapping.get("DIFF_TTL"),10,
          (exgui.Object2String)vftxtDouble,(exgui.ultratable.CellTxtEditorFormat)vftxtDouble)
      );

      dataBoundGUIs.add(  new exgui.DataBindTextWithChecker(txtSrnTtlAmt,"SRN_TTL_AMT",
          recToMapping.get("SRN_TTL_AMT"),10,
          (exgui.Object2String)vftxtDouble,(exgui.ultratable.CellTxtEditorFormat)vftxtDouble)
      );

      dataBoundGUIs.add(  new exgui.DataBindTextWithChecker(txtShipEtd,"SHIP_ETD_DATE",
          recToMapping.get("SHIP_ETD_DATE"),10,
          (exgui.Object2String)vftxtPrintDate,(exgui.ultratable.CellTxtEditorFormat)vftxtPrintDate)
      );

      dataBoundGUIs.add(  new exgui.DataBindTextWithChecker(txtDiscAmtUsd,"DISC_AMT_USD",
          recToMapping.get("DISC_AMT_USD"),10,
          (exgui.Object2String)vftxtDouble,(exgui.ultratable.CellTxtEditorFormat)vftxtDouble)
      );


      dataBoundGUIs.add(  new exgui.DataBindTextWithChecker(txtDiscAmt,"DISC_AMT",
          recToMapping.get("DISC_AMT"),10,
          (exgui.Object2String)vftxtDouble,(exgui.ultratable.CellTxtEditorFormat)vftxtDouble)
      );


      dataBoundGUIs.add(  new exgui.DataBindTextWithChecker(txtShipFtyInv,"SHIP_FTY_INV",
          recToMapping.get("SHIP_FTY_INV"),25,
          (exgui.Object2String)ch25Vfy,(exgui.ultratable.CellTxtEditorFormat)ch25Vfy)
      );

      Object ch200Vfy=exgui.verification.CellFormat.getOrdinaryField(2000);
      dataBoundGUIs.add(  new exgui.DataBindTextWithChecker(txtDiscDesc,"DISC_DESC",
          recToMapping.get("DISC_DESC"),2000,
          (exgui.Object2String)ch200Vfy,(exgui.ultratable.CellTxtEditorFormat)ch200Vfy)
      );

      //txtDiscDesc.setText((String)recToMapping.get("DISC_DESC"));
      txtDiscDesc.setCaretPosition(0);
      //txtDiscDesc.setEditable(false);//only for displaying.
      lbiTitle.setText(lbiTitle.getText()+(String)recToMapping.get(0));


      //lblDifTtl.setText(nf.format(recToMapping.get("DIFF_TTL")));
      //lblDiscTotal.setText(nf.format(recToMapping.get("DISC_AMT")));
      lblMakerName.setText((String)recToMapping.get("fty_brief"));
      lblMakerNameChn.setText((String)recToMapping.get("fty_chn_name"));

      new exgui.DataBindTextWithChecker(txtDkAmt,"DISC_AMT",
                recToMapping.get("local_voucher_ddk_sum"),10,
                (exgui.Object2String)vftxtDouble,(exgui.ultratable.CellTxtEditorFormat)vftxtDouble);
       //updateDiscountTWD();
       txtDkAmt.setEditable(false);
    }catch(Exception exp){
      exp.printStackTrace();
    }
  }

 protected void jbInit() throws Exception {
    border1 = new EtchedBorder(EtchedBorder.RAISED,Color.white,new Color(148, 145, 140));
    titledBorder1 = new TitledBorder(border1,"Discount Description");
    lbiTitle.setText("LOCAL VOUCHER DATA OF :");
    lbiTitle.setBounds(new Rectangle(0, 4, 522, 29));
    this.setLayout(null);
    whiteBkgBlueCharLabel1.setText("MAKER NAME:");
    whiteBkgBlueCharLabel1.setBounds(new Rectangle(21, 44, 95, 25));
    lblMakerName.setText("");
    lblMakerName.setBounds(new Rectangle(114, 44, 285, 25));
    lblMakerNameChn.setBounds(new Rectangle(114, 78, 157, 25));
    lblMakerNameChn.setText("whiteBkgBlueCharLabel2");
    lblMakerNameChn.setBackground(new Color(143, 143, 188));
    lblMakerNameChn.setFont(new java.awt.Font("Dialog", 0, 16));
    lblMakerNameChn.setForeground(Color.white);
    lblMakerNameChn.setText("");
    whiteBkgBlueCharLabel2.setBounds(new Rectangle(21, 78, 95, 25));
    whiteBkgBlueCharLabel2.setBackground(new Color(143, 143, 188));
    whiteBkgBlueCharLabel2.setFont(new java.awt.Font("Dialog", 0, 16));
    whiteBkgBlueCharLabel2.setForeground(Color.white);
    whiteBkgBlueCharLabel2.setText("¼t°Ó¦WºÙ:");
    whiteBkgBlueCharLabel3.setBounds(new Rectangle(21, 112, 126, 25));
    whiteBkgBlueCharLabel3.setText("EXCHANGE RATE:");
    txtXRate.setText("");
    txtXRate.setBounds(new Rectangle(147, 112, 131, 25));
    txtXRate.addKeyListener(new java.awt.event.KeyAdapter() {
      public void keyReleased(KeyEvent e) {
        txtXRate_keyReleased(e);
      }
    });
    whiteBkgBlueCharLabel4.setText("PRINT SHORT FORM :");
    whiteBkgBlueCharLabel4.setForeground(Color.white);
    whiteBkgBlueCharLabel4.setFont(new java.awt.Font("Dialog", 1, 11));
    whiteBkgBlueCharLabel4.setBackground(new Color(143, 143, 188));
    whiteBkgBlueCharLabel4.setBounds(new Rectangle(21, 146, 126, 25));
    txtPrintForm.setText("");
    txtPrintForm.setBounds(new Rectangle(147, 146, 92, 25));
    txtPrintLatter.setBounds(new Rectangle(386, 146, 92, 25));
    txtPrintLatter.setText("");
    txtPrintLatter.setText("");
    whiteBkgBlueCharLabel5.setBounds(new Rectangle(280, 146, 106, 25));
    whiteBkgBlueCharLabel5.setBackground(new Color(143, 143, 188));
    whiteBkgBlueCharLabel5.setFont(new java.awt.Font("Dialog", 1, 11));
    whiteBkgBlueCharLabel5.setForeground(Color.white);
    whiteBkgBlueCharLabel5.setText("PRINT LETTER :");
    whiteBkgBlueCharLabel6.setText("SRN TTL AMT:");
    whiteBkgBlueCharLabel6.setBounds(new Rectangle(21, 180, 126, 25));
    whiteBkgBlueCharLabel7.setBounds(new Rectangle(21, 214, 127, 25));
    whiteBkgBlueCharLabel7.setBackground(new Color(143, 143, 188));
    whiteBkgBlueCharLabel7.setForeground(Color.white);
    whiteBkgBlueCharLabel7.setText("DIFF TTL:");
    whiteBkgBlueCharLabel8.setText("DISC USD :");
    whiteBkgBlueCharLabel8.setForeground(Color.white);
    whiteBkgBlueCharLabel8.setBackground(new Color(143, 143, 188));
    whiteBkgBlueCharLabel8.setBounds(new Rectangle(280, 214, 106, 25));
    jScrollPane1.setBorder(titledBorder1);
    jScrollPane1.setBounds(new Rectangle(24, 280, 464, 171));
    txtDiscDesc.setText("");
    txtDiffTll.setText("");
    txtDiffTll.setBounds(new Rectangle(147, 214, 129, 25));
    txtDiscAmtUsd.setBounds(new Rectangle(386, 214, 112, 25));
    txtDiscAmtUsd.addKeyListener(new java.awt.event.KeyAdapter() {
      public void keyReleased(KeyEvent e) {
        txtDiscAmtUsd_keyReleased(e);
      }
    });
    txtDiscAmtUsd.setText("");
    txtDiscAmtUsd.setText("");
    txtSrnTtlAmt.setBounds(new Rectangle(147, 180, 129, 25));
    txtSrnTtlAmt.setText("");
    txtShipFtyInv.setBounds(new Rectangle(386, 112, 131, 25));
    txtShipFtyInv.setText("");
    whiteBkgBlueCharLabel9.setText("FTY-INV :");
    whiteBkgBlueCharLabel9.setBounds(new Rectangle(280, 112, 106, 25));
    whiteBkgBlueCharLabel10.setBounds(new Rectangle(280, 180, 106, 25));
    whiteBkgBlueCharLabel10.setText("ETD  :");
    txtShipEtd.setText("");
    txtShipEtd.setBounds(new Rectangle(386, 180, 131, 25));
    whiteBkgBlueCharLabel11.setText("CREATE DATE :");
    whiteBkgBlueCharLabel11.setForeground(Color.white);
    whiteBkgBlueCharLabel11.setFont(new java.awt.Font("Dialog", 1, 11));
    whiteBkgBlueCharLabel11.setBackground(new Color(143, 143, 188));
    whiteBkgBlueCharLabel11.setBounds(new Rectangle(280, 78, 106, 25));
    txtCreateDate.setText("");
    txtCreateDate.setText("");
    txtCreateDate.setBounds(new Rectangle(386, 78, 92, 25));
    txtDiscAmt.setText("");
    txtDiscAmt.setBounds(new Rectangle(147, 247, 129, 25));
    whiteBkgBlueCharLabel12.setBounds(new Rectangle(19, 247, 128, 25));
    whiteBkgBlueCharLabel12.setText("DISC LOCAL");
    txtDkAmt.setBounds(new Rectangle(386, 247, 129, 25));
    txtDkAmt.setText("");
    whiteBkgBlueCharLabel13.setText("DEDUCT AMT  :");
    whiteBkgBlueCharLabel13.setBounds(new Rectangle(278, 247, 109, 25));
    this.add(lbiTitle, null);
    this.add(whiteBkgBlueCharLabel1, null);
    this.add(lblMakerName, null);
    this.add(whiteBkgBlueCharLabel2, null);
    this.add(lblMakerNameChn, null);
    this.add(whiteBkgBlueCharLabel11, null);
    this.add(txtCreateDate, null);
    this.add(whiteBkgBlueCharLabel3, null);
    this.add(txtXRate, null);
    this.add(whiteBkgBlueCharLabel9, null);
    this.add(txtShipFtyInv, null);
    this.add(whiteBkgBlueCharLabel4, null);
    this.add(txtPrintForm, null);
    this.add(whiteBkgBlueCharLabel5, null);
    this.add(txtPrintLatter, null);
    this.add(whiteBkgBlueCharLabel6, null);
    this.add(txtSrnTtlAmt, null);
    this.add(whiteBkgBlueCharLabel10, null);
    this.add(txtShipEtd, null);
    this.add(whiteBkgBlueCharLabel7, null);
    this.add(txtDiffTll, null);
    this.add(whiteBkgBlueCharLabel8, null);
    this.add(txtDiscAmtUsd, null);
    this.add(whiteBkgBlueCharLabel12, null);
    this.add(txtDiscAmt, null);
    this.add(whiteBkgBlueCharLabel13, null);
    this.add(txtDkAmt, null);
    this.add(jScrollPane1, null);
    jScrollPane1.getViewport().add(txtDiscDesc, null);
    txtDiscDesc.setFont(new java.awt.Font("DialogInput", 0, 12));
  }
  void updateDiscountTWD(){
    double xrate=Double.parseDouble((txtXRate.getText().trim().length()==0)?"1": txtXRate.getText().trim());
    if(xrate==0)xrate=1;
    if(xrate==0||xrate==1){
      txtDiscAmt.setText(txtDiscAmtUsd.getText().trim());
      return;
    }
    double discountUSD=Double.parseDouble((txtDiscAmtUsd.getText().trim().length()==0)?"0": txtDiscAmtUsd.getText().trim());
    double twdDisccount=Math.round(xrate*discountUSD);
     txtDiscAmt.setText(nf.format(twdDisccount));

  }
  void txtXRate_keyReleased(KeyEvent e) {
    updateDiscountTWD();
  }

  void txtDiscAmtUsd_keyReleased(KeyEvent e) {
   updateDiscountTWD();
  }

}
