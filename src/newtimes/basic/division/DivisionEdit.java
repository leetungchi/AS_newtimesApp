package newtimes.basic.division;

import java.awt.*;
import newtimes.*;
import javax.swing.*;
import java.awt.event.*;
import newtimes.preproduction.buyermakerselect.*;
import exgui.*;
import javax.swing.border.*;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author unascribed
 * @version 1.0
 */

public class DivisionEdit extends JPanel  implements newtimes.preproduction.buyermakerselect.BuyerMakerChanged{
  Frame1 frame;
  private JTextField txtWeight = new JTextField();
  private JLabel jTextField4 = new JLabel();
  private JLabel jTextField3 = new JLabel();
  private JLabel jTextField2 = new JLabel();
  private JLabel jTextField1 = new JLabel();
  private JTextField txtDivName = new JTextField();
  private JTextField txtDivCode = new JTextField();
  private JLabel textAreaStatus = new JLabel();
  private JLabel jLabel1 = new JLabel();
  private JButton butnDel = new JButton();
  private JButton butnExit = new JButton();
  private JButton butnModify = new JButton();
  private exgui.DataBindJCombobox dbJCBXBuyer = null;
  private java.util.HashMap hm =
    (java.util.HashMap)util.ApplicationProperites.getProperties("recDetail");
  static boolean isExit = false;
  Object objBuyerMakerSeq;
  SelectBuyerMaker slkChzBuyer = new SelectBuyerMaker();
  JPanel pnlMakerDisct = new JPanel();
  JTextField txtMakerDiscount = new JTextField();
  JTextField txtBuyerCommLumpSum = new JTextField();
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel113 = new BlueBkgWhiteCharLabel();
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel16 = new BlueBkgWhiteCharLabel();
  JTextField txtBuyerCommPC = new JTextField();
  JTextField txtMakerDiscountDZ = new JTextField();
  JTextField txtBuyerComm = new JTextField();
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel2110 = new BlueBkgWhiteCharLabel();
  JTextField txtBuyerCommDz = new JTextField();
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel112 = new BlueBkgWhiteCharLabel();
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel2111 = new BlueBkgWhiteCharLabel();
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel17 = new BlueBkgWhiteCharLabel();
  JTextField txtMkrLumpSum = new JTextField();
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel213 = new BlueBkgWhiteCharLabel();
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel212 = new BlueBkgWhiteCharLabel();
  JTextField txtMakerDiscountPC = new JTextField();
  JPanel pnlBuyerComm = new JPanel();
  Border border1;
  TitledBorder titledBorder1;
  Border border2;
  TitledBorder titledBorder2;
  DataBindTextWithChecker dbBuyerComm,dbBuyerCommPc,dbBuyerCommDz,dbBuyerCommLumpSum;
  DataBindTextWithChecker dbMakerDiscount;
  DataBindTextWithChecker dbMakerDiscountPC;
  DataBindTextWithChecker dbMakerDiscountDZ;
  DataBindTextWithChecker dbMakerLumpSum;
  JTextArea jTextArea1 = new JTextArea();
  JLabel jTextField5 = new JLabel();

  public DivisionEdit(Frame1 _frame) {
    frame = _frame;
    try {
      jbInit();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }
  void jbInit() throws Exception {
    border1 = new EtchedBorder(EtchedBorder.RAISED,Color.white,new Color(141, 141, 157));
    titledBorder1 = new TitledBorder(border1,"Buyer Commision");
    border2 = new EtchedBorder(EtchedBorder.RAISED,Color.white,new Color(141, 141, 157));
    titledBorder2 = new TitledBorder(border2,"Maker Discount");
    this.setMaxLength();
    jLabel1.setBounds(new Rectangle(117, 26, 566, 24));
    jLabel1.setText("      ============  Division Edit  ============      ");
    jLabel1.setHorizontalAlignment(SwingConstants.CENTER);
    jLabel1.setBorder(BorderFactory.createEtchedBorder());
    jLabel1.setForeground(new Color(10,36,106));
    jLabel1.setFont(new java.awt.Font("Dialog", 1, 13));
    textAreaStatus.setBounds(new Rectangle(0, 540, 800, 30));
    //textAreaStatus.setEditable(false);
    textAreaStatus.setBorder(null);
    textAreaStatus.setOpaque(true);
    textAreaStatus.setBackground(new Color(143, 143, 188));
    txtDivCode.setEnabled(false);
    txtDivCode.setEditable(false);
    txtDivCode.setBounds(new Rectangle(335, 107, 271, 23));
    txtDivName.setBounds(new Rectangle(335, 139, 271, 23));
    jTextField1.setBounds(new Rectangle(178, 107, 155, 23));
    jTextField1.setText(" * Division Code :");
    //jTextField1.setScrollOffset(0);
    jTextField1.setBorder(null);
    jTextField1.setOpaque(true);
    //jTextField1.setEditable(false);
    jTextField1.setForeground(new Color(10,36,106));
    jTextField1.setFont(new java.awt.Font("Dialog", 1, 12));
    jTextField1.setBackground(new Color(143, 143, 188));
    jTextField2.setBounds(new Rectangle(178, 139, 155, 23));
    jTextField2.setText(" Division Name :");
    jTextField2.setBorder(null);
    jTextField2.setOpaque(true);
    //jTextField2.setEditable(false);
    jTextField2.setForeground(Color.white);
    jTextField2.setFont(new java.awt.Font("Dialog", 1, 12));
    jTextField2.setBackground(new Color(143, 143, 188));
    jTextField3.setBounds(new Rectangle(178, 171, 155, 23));
    jTextField3.setText(" Buyer :");
    jTextField3.setBorder(null);
    jTextField3.setOpaque(true);
    //jTextField3.setEditable(false);
    jTextField3.setForeground(new Color(10,36,106));
    jTextField3.setFont(new java.awt.Font("Dialog", 1, 12));
    jTextField3.setBackground(new Color(143, 143, 188));
    jTextField4.setBackground(new Color(143, 143, 188));
    jTextField4.setFont(new java.awt.Font("Dialog", 1, 12));
    jTextField4.setForeground(Color.white);
    jTextField4.setBorder(null);
    jTextField4.setOpaque(true);
    jTextField4.setToolTipText("");
    //jTextField4.setEditable(false);
    jTextField4.setText(" Address :");
    jTextField4.setBounds(new Rectangle(177, 339, 155, 23));
    txtWeight.setBounds(new Rectangle(335, 203, 271, 23));
    this.setLayout(null);
    this.setSize(800,600);
    this.setBackground(new Color(204, 204, 225));
    butnDel.setText("Delete");
    butnDel.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        butnDel_actionPerformed(e);
      }
    });
    butnDel.setForeground(Color.darkGray);
    butnDel.setFont(new java.awt.Font("Dialog", 1, 13));
    butnDel.setBounds(new Rectangle(375, 480, 80, 25));
    butnDel.setBackground(Color.lightGray);
    butnExit.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        butnExit_actionPerformed(e);
      }
    });
    butnExit.setText("Exit");
    butnExit.setForeground(Color.darkGray);
    butnExit.setFont(new java.awt.Font("Dialog", 1, 13));
    butnExit.setBounds(new Rectangle(468, 480, 80, 25));
    butnExit.setBackground(Color.lightGray);
    butnModify.setText("Confirm Modify");
    butnModify.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        butnModify_actionPerformed(e);
      }
    });
    butnModify.setForeground(Color.darkGray);
    butnModify.setFont(new java.awt.Font("Dialog", 1, 13));
    butnModify.setBounds(new Rectangle(228, 480, 134, 25));
    butnModify.setBackground(Color.lightGray);
    slkChzBuyer.setBounds(new Rectangle(335, 171, 269, 23));
    pnlMakerDisct.setBackground(new Color(202, 202, 225));
    pnlMakerDisct.setBorder(titledBorder2);
    pnlMakerDisct.setBounds(new Rectangle(407, 244, 304, 131));
    pnlMakerDisct.setLayout(null);
    txtMakerDiscount.setBounds(new Rectangle(45, 21, 68, 23));
    txtBuyerCommLumpSum.setBounds(new Rectangle(117, 51, 168, 23));
    blueBkgWhiteCharLabel113.setForeground(new Color(10,36,106));
    blueBkgWhiteCharLabel113.setText(" PC:");
    blueBkgWhiteCharLabel113.setBounds(new Rectangle(148, 21, 52, 23));
    blueBkgWhiteCharLabel16.setForeground(new Color(10,36,106));
    blueBkgWhiteCharLabel16.setText(" PC:");
    blueBkgWhiteCharLabel16.setBounds(new Rectangle(127, 21, 73, 23));
    txtBuyerCommPC.setBounds(new Rectangle(201, 21, 92, 23));
    txtMakerDiscountDZ.setBounds(new Rectangle(69, 58, 68, 23));
    txtBuyerComm.setBounds(new Rectangle(45, 21, 90, 23));
    blueBkgWhiteCharLabel2110.setBounds(new Rectangle(13, 21, 32, 23));
    blueBkgWhiteCharLabel2110.setForeground(new Color(10, 36, 106));
    blueBkgWhiteCharLabel2110.setText(" % :");
    txtBuyerCommDz.setBounds(new Rectangle(359, 18, 68, 23));
    blueBkgWhiteCharLabel112.setForeground(new Color(10,36,106));
    blueBkgWhiteCharLabel112.setText(" DZ:");
    blueBkgWhiteCharLabel112.setBounds(new Rectangle(303, 18, 56, 23));
    blueBkgWhiteCharLabel2111.setBounds(new Rectangle(14, 51, 104, 23));
    blueBkgWhiteCharLabel2111.setForeground(new Color(10, 36, 106));
    blueBkgWhiteCharLabel2111.setText(" Lump Sum:");
    blueBkgWhiteCharLabel17.setForeground(new Color(10,36,106));
    blueBkgWhiteCharLabel17.setText(" DZ:");
    blueBkgWhiteCharLabel17.setBounds(new Rectangle(13, 58, 56, 23));
    txtMkrLumpSum.setBounds(new Rectangle(117, 92, 168, 23));
    blueBkgWhiteCharLabel213.setBounds(new Rectangle(13, 21, 32, 23));
    blueBkgWhiteCharLabel213.setForeground(new Color(10, 36, 106));
    blueBkgWhiteCharLabel213.setText(" % :");
    blueBkgWhiteCharLabel212.setBounds(new Rectangle(14, 92, 104, 23));
    blueBkgWhiteCharLabel212.setForeground(new Color(10, 36, 106));
    blueBkgWhiteCharLabel212.setText(" Lump Sum:");
    txtMakerDiscountPC.setBounds(new Rectangle(201, 21, 92, 23));
    pnlBuyerComm.setLayout(null);
    pnlBuyerComm.setBounds(new Rectangle(177, 234, 436, 96));
    pnlBuyerComm.setBackground(new Color(202, 202, 225));
    pnlBuyerComm.setBorder(titledBorder1);
    jTextArea1.setBounds(new Rectangle(336, 339, 276, 83));
    jTextField5.setBounds(new Rectangle(231, 214, 155, 23));
    jTextField5.setText(" Weight :");
    jTextField5.setOpaque(true);
    jTextField5.setBorder(null);
    jTextField5.setForeground(Color.white);
    jTextField5.setFont(new java.awt.Font("Dialog", 1, 12));
    jTextField5.setBackground(new Color(143, 143, 188));
    this.add(jLabel1, null);
    this.add(jTextField3, null);
    this.add(jTextField2, null);
    this.add(jTextField1, null);
    this.add(textAreaStatus, null);
    this.add(txtWeight, null);
    this.add(txtDivCode, null);
    this.add(txtDivName, null);
    this.add(butnExit, null);
    this.add(butnDel, null);
    this.add(butnModify, null);
    this.add(slkChzBuyer, null);
    this.add(pnlBuyerComm, null);
    pnlMakerDisct.add(txtMakerDiscount, null);
    pnlMakerDisct.add(blueBkgWhiteCharLabel213, null);
    pnlMakerDisct.add(blueBkgWhiteCharLabel16, null);
    pnlMakerDisct.add(txtMakerDiscountPC, null);
    pnlMakerDisct.add(blueBkgWhiteCharLabel17, null);
    pnlMakerDisct.add(txtMakerDiscountDZ, null);
    pnlMakerDisct.add(blueBkgWhiteCharLabel212, null);
    pnlMakerDisct.add(txtMkrLumpSum, null);
    pnlBuyerComm.add(blueBkgWhiteCharLabel2110, null);
    pnlBuyerComm.add(blueBkgWhiteCharLabel113, null);
    pnlBuyerComm.add(txtBuyerCommPC, null);
    pnlBuyerComm.add(txtBuyerComm, null);
    pnlBuyerComm.add(blueBkgWhiteCharLabel112, null);
    pnlBuyerComm.add(txtBuyerCommDz, null);
    pnlBuyerComm.add(blueBkgWhiteCharLabel2111, null);
    pnlBuyerComm.add(txtBuyerCommLumpSum, null);
    this.add(jTextArea1, null);
    this.add(jTextField5, null);
    this.add(jTextField4, null);
    //this.add(pnlMakerDisct, null);
    pnlMakerDisct.add(txtMakerDiscount, null);
    pnlMakerDisct.add(blueBkgWhiteCharLabel213, null);
    pnlMakerDisct.add(blueBkgWhiteCharLabel16, null);
    pnlMakerDisct.add(txtMakerDiscountPC, null);
    pnlMakerDisct.add(blueBkgWhiteCharLabel212, null);
    pnlMakerDisct.add(txtMkrLumpSum, null);
    pnlMakerDisct.add(blueBkgWhiteCharLabel17, null);
    pnlMakerDisct.add(txtMakerDiscountDZ, null);
    pnlBuyerComm.add(blueBkgWhiteCharLabel2110, null);
    pnlBuyerComm.add(blueBkgWhiteCharLabel113, null);
    pnlBuyerComm.add(txtBuyerCommPC, null);
    pnlBuyerComm.add(blueBkgWhiteCharLabel2111, null);
    pnlBuyerComm.add(txtBuyerCommLumpSum, null);
    pnlBuyerComm.add(blueBkgWhiteCharLabel112, null);
    pnlBuyerComm.add(txtBuyerCommDz, null);
    pnlBuyerComm.add(txtBuyerComm, null);
    Object n52vfy=exgui.verification.CellFormat.getDoubleFormatAllowNull(3,2);
    Object n43vfy=exgui.verification.CellFormat.getDoubleFormatAllowNull(4,3);
    Object n53vfy=exgui.verification.CellFormat.getDoubleFormatAllowNull(5,3);
    Object n83vfy=exgui.verification.CellFormat.getDoubleFormatAllowNull(8,3);
    dbBuyerComm=
        new  DataBindTextWithChecker(txtBuyerComm,"",null,6,
                                (exgui.Object2String)n52vfy,
                                (exgui.ultratable.CellTxtEditorFormat)n52vfy);

    dbBuyerCommPc=
        new  DataBindTextWithChecker(txtBuyerCommPC,"",null,8,
                                (exgui.Object2String)n43vfy,
                                (exgui.ultratable.CellTxtEditorFormat)n43vfy);
    dbBuyerCommDz=
        new  DataBindTextWithChecker(txtBuyerCommDz,"",null,9,
                                (exgui.Object2String)n53vfy,
                                (exgui.ultratable.CellTxtEditorFormat)n53vfy);
    dbBuyerCommLumpSum=
        new  DataBindTextWithChecker(txtBuyerCommLumpSum,"",null,12,
                                (exgui.Object2String)n83vfy,
                                (exgui.ultratable.CellTxtEditorFormat)n83vfy);


    dbMakerDiscount=
        new  DataBindTextWithChecker(txtMakerDiscount,"",null,6,
                                (exgui.Object2String)n52vfy,
                                (exgui.ultratable.CellTxtEditorFormat)n52vfy);

    dbMakerDiscountPC=
        new  DataBindTextWithChecker(txtMakerDiscountPC,"",null,8,
                                (exgui.Object2String)n43vfy,
                                (exgui.ultratable.CellTxtEditorFormat)n43vfy);
    dbMakerDiscountDZ=
        new  DataBindTextWithChecker(txtMakerDiscountDZ,"",null,9,
                                (exgui.Object2String)n53vfy,
                                (exgui.ultratable.CellTxtEditorFormat)n53vfy);
    dbMakerLumpSum=
        new  DataBindTextWithChecker(txtMkrLumpSum,"",null,12,
                                (exgui.Object2String)n83vfy,
                                (exgui.ultratable.CellTxtEditorFormat)n83vfy);
    this.setData2Fields();
    this.setCmboDiv();

  }
  void butnExit_actionPerformed(ActionEvent e) {
    setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
    isExit = true;
    frame.showPanel(new newtimes.basic.division.DivisionList(frame));
    setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
  }

  void butnDel_actionPerformed(ActionEvent e) {
    int result = exgui2.InfoMessage.Yes_No_Option(frame,"Delete ?");
    if(result == 0){
      setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
      try {
        isExit = true;
        hm.clear();
        hm.put("DIV_CODE", txtDivCode.getText().trim().toUpperCase());
        hm.put("delete_user", util.PublicVariable.USER_RECORD.get("USR_CODE"));
        boolean isOk = exgui2.CONST.BASIC_MAIN_EJB.deleteDivsion(hm);
        if (isOk) {
          exgui2.InfoMessage.infoMessage(frame, "Delete Succeed.");
          frame.showPanel(new newtimes.basic.division.DivisionList(frame));
        } else {
          exgui2.InfoMessage.warningMessage(frame, "Delete Failed.");
        }
      } catch (Exception eDel) {
        eDel.printStackTrace();
        util.ExceptionLog.exp2File(eDel, "error at delete data." + hm.toString());
      }
      setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
    }
  }

  void butnModify_actionPerformed(ActionEvent e) {
    int result = exgui2.InfoMessage.Yes_No_Option(frame,"Modify ?");
    if(result == 0){
      setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
      try {
        isExit = true;
        hm.clear();
        hm.put("update_user", util.PublicVariable.USER_RECORD.get("USR_CODE"));
        hm.put("DIV_CODE", txtDivCode.getText().trim().toUpperCase());
        hm.put("DIV_NAME", txtDivName.getText().trim().toUpperCase());
        //hm.put("DIV_BYMKR_SEQ", dbJCBXBuyer.getSelectedValue().toString());
        hm.put("DIV_BYMKR_SEQ", slkChzBuyer.getSelectedValue());
        hm.put("DIV_WEIGHT", txtWeight.getText().trim().toUpperCase());
        hm.put("BUY_COMM", txtBuyerComm.getText().trim());
        hm.put("BUY_COMM_PC", txtBuyerCommPC.getText().trim());
        hm.put("BUY_COMM_DZ", txtBuyerCommDz.getText().trim());
        hm.put("BUY_COMM_LUMP_SUM", txtBuyerCommLumpSum.getText().trim());

        hm.put("MKR_DSCT_PER", txtMakerDiscount.getText().trim());
        hm.put("MKR_DSCT_PC", txtMakerDiscountPC.getText().trim());
        hm.put("MKR_DSCT_DZ", txtMakerDiscountDZ.getText().trim());
        hm.put("MKR_DSCT_LUMP_SUM", txtMkrLumpSum.getText().trim());
        hm.put("DIV_ADDR", jTextArea1.getText().trim());
        boolean isOk = exgui2.CONST.BASIC_MAIN_EJB.updateDivsion(hm);
        if (isOk) {
          exgui2.InfoMessage.infoMessage(frame, "Modify Succeed.");
          frame.showPanel(new newtimes.basic.division.DivisionList(frame));
        } else {
          exgui2.InfoMessage.warningMessage(frame, "Modify Failed.");
        }
      } catch (Exception eDel) {
        eDel.printStackTrace();
        util.ExceptionLog.exp2File(eDel, "error at modify data." + hm.toString());
      }
      setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
    }
  }

  void setData2Fields() {
      database.datatype.Record recDetail = null;
      try {
        recDetail = (database.datatype.Record)hm.get("recDetail");
        txtDivCode.setText(recDetail.get("div_code")==null?"":recDetail.get("div_code").toString());
        txtDivName.setText(recDetail.get("div_name")==null?"":recDetail.get("div_name").toString());
        //cmboBuyer.setSelectedItem(recDetail.get("BYMKR_BRIEF")==null?"":recDetail.get("BYMKR_BRIEF").toString());
        txtWeight.setText(recDetail.get("div_weight")==null?"":recDetail.get("div_weight").toString());
        // jTextArea1
         jTextArea1.setText(recDetail.get("DIV_ADDR")==null?"":recDetail.get("DIV_ADDR").toString());

        Object buyerComm=recDetail.get("BUY_COMM");
        Object buyerCommPc=recDetail.get("BUY_COMM_PC");
        Object buyerCommDz=recDetail.get("BUY_COMM_DZ");
        Object buyerCommLumpSum=recDetail.get("BUY_COMM_LUMP_SUM");

        Object makerDiscount=recDetail.get("MKR_DSCT_PER");
        Object makerDiscountPC=recDetail.get("MKR_DSCT_PC");
        Object makerDiscountDZ=recDetail.get("MKR_DSCT_DZ");
        Object makerLumpSum=recDetail.get("MKR_DSCT_LUMP_SUM");
        txtBuyerComm.setText((buyerComm==null)?"":buyerComm.toString());
        txtMakerDiscount.setText((makerDiscount==null)?"":makerDiscount.toString());
        txtMakerDiscountPC.setText((makerDiscountPC==null)?"":makerDiscountPC.toString());
        txtMakerDiscountDZ.setText((makerDiscountDZ==null)?"":makerDiscountDZ.toString());
        txtMkrLumpSum.setText((makerLumpSum==null)?"":makerLumpSum.toString());

        txtBuyerCommPC.setText((buyerCommPc==null)?"":buyerCommPc.toString());
        txtBuyerCommDz.setText((buyerCommDz==null)?"":buyerCommDz.toString());
        txtBuyerCommLumpSum.setText((buyerCommLumpSum==null)?"":buyerCommLumpSum.toString());


        objBuyerMakerSeq=recDetail.get("DIV_BYMKR_SEQ");
      } catch (Exception e) {
        e.printStackTrace();
        util.ExceptionLog.exp2File(e, "error at set datas to fields."+recDetail.toString());
      }
    }
    public void changeBuyerMaker(database.datatype.Record newBuyerMakerRecord){
      try{
        if(newBuyerMakerRecord==null){
          txtBuyerComm.setText("");
          txtMakerDiscount.setText("");

          txtMakerDiscountPC.setText("");

          txtMakerDiscountDZ.setText("");

          txtMkrLumpSum.setText("");

          txtBuyerCommPC.setText("");
          txtBuyerCommDz.setText("");
          txtBuyerCommLumpSum.setText("");
          return;
        }

        Object buyerComm = newBuyerMakerRecord.get("BUY_COMM");
        Object buyerCommPc = newBuyerMakerRecord.get("BUY_COMM_PC");
        Object buyerCommDz = newBuyerMakerRecord.get("BUY_COMM_DZ");
        Object buyerCommLumpSum = newBuyerMakerRecord.get("BUY_COMM_LUMP_SUM");

        Object makerDiscount = newBuyerMakerRecord.get("MKR_DSCT_PER");
        Object makerDiscountPC = newBuyerMakerRecord.get("MKR_DSCT_PC");
        Object makerDiscountDZ = newBuyerMakerRecord.get("MKR_DSCT_DZ");
        Object makerLumpSum = newBuyerMakerRecord.get("MKR_DSCT_LUMP_SUM");
        txtBuyerComm.setText((buyerComm == null) ? "" : buyerComm.toString());
        txtMakerDiscount.setText((makerDiscount == null) ? "" :
                                 makerDiscount.toString());
        txtMakerDiscountPC.setText((makerDiscountPC == null) ? "" :
                                   makerDiscountPC.toString());
        txtMakerDiscountDZ.setText((makerDiscountDZ == null) ? "" :
                                   makerDiscountDZ.toString());
        txtMkrLumpSum.setText((makerLumpSum == null) ? "" : makerLumpSum.toString());

        txtBuyerCommPC.setText((buyerCommPc == null) ? "" : buyerCommPc.toString());
        txtBuyerCommDz.setText((buyerCommDz == null) ? "" : buyerCommDz.toString());
        txtBuyerCommLumpSum.setText((buyerCommLumpSum == null) ? "" :
                                    buyerCommLumpSum.toString());
      }catch(Exception exp){
        exp.printStackTrace();
      }
    }

  boolean checkFieldsData() {
    if(!dbBuyerComm.isValidx()){
      exgui.verification.VerifyLib.showAllert(
       "Buyer Commision Foramt Error"
      );
      txtBuyerComm.grabFocus();
      return false;
    }
    if(!dbBuyerCommPc.isValidx()){
      exgui.verification.VerifyLib.showAllert(
       "Buyer Commision PC Foramt Error"
      );
      txtBuyerCommPC.grabFocus();
      return false;
    }
    if(!dbBuyerCommDz.isValidx()){
      exgui.verification.VerifyLib.showAllert(
       "Buyer Commision DZ Foramt Error"
      );
      txtBuyerCommDz.grabFocus();
      return false;
    }
    if(!dbBuyerCommLumpSum.isValidx()){
      exgui.verification.VerifyLib.showAllert(
       "Buyer Commision LumpSum Foramt Error"
      );
      txtBuyerCommLumpSum.grabFocus();
      return false;
    }




    if(!dbMakerDiscount.isValidx()){
      exgui.verification.VerifyLib.showAllert(
       "Maker Discount Commision Foramt Error"
      );
      txtMakerDiscount.grabFocus();
      return false;
    }
    if(!dbMakerDiscountPC.isValidx()){
      exgui.verification.VerifyLib.showAllert(
       "Maker Dsicount PC  Foramt Error"
      );
      txtMakerDiscountPC.grabFocus();
      return false;
    }
    if(!dbMakerDiscountDZ.isValidx()){
      exgui.verification.VerifyLib.showAllert(
       "Maker Discount DZ Foramt Error"
      );
      txtMakerDiscountDZ.grabFocus();
      return false;
    }
    if(!dbMakerLumpSum.isValidx()){
      exgui.verification.VerifyLib.showAllert(
       "Maker LumpSum Foramt Error"
      );
      txtMkrLumpSum.grabFocus();
      return false;
    }

    boolean chkInt = exgui2.Stuff.checkInteger(frame, txtWeight.getText(),"Division Weight must be less than 999");
    if (chkInt) { return true; }
    else { return false; }
  }

  void setCmboDiv() {
    java.util.Vector vDataBuyer = null;
    try {
      /*
      vDataBuyer = exgui2.CONST.BASIC_MAIN_EJB.getBuyerMakerAllByType("BYMKR_SEQ,BYMKR_BRIEF", "BYMKR_BRIEF",1);
      database.datatype.Record rec = (database.datatype.Record) vDataBuyer.get(0);
      dbJCBXBuyer = new exgui.DataBindJCombobox(cmboBuyer, vDataBuyer, "BYMKR_BRIEF",
                                           "BYMKR_SEQ", objBuyerMakerSeq,"","");
      */
     slkChzBuyer.init("",objBuyerMakerSeq,slkChzBuyer.TYPE_BUYER,true);
     slkChzBuyer.setModifyNotifyTo(this);
      //cmboBuyer.setSelectedIndex(0);
    } catch (Exception e) {
      e.printStackTrace();
      util.ExceptionLog.exp2File(e, "buyer data:"+vDataBuyer.toString());
    }
  }

  void setMaxLength(){
    exgui.DataBindText tx = null;
    tx = new exgui.DataBindText(txtDivName,null,"",55);
    tx = new exgui.DataBindText(txtWeight,null,"",3);
  }
}
