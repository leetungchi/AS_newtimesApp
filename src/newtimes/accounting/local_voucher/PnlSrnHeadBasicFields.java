package newtimes.accounting.local_voucher;

import java.awt.*;
import javax.swing.*;
import exgui.*;
import database.datatype.Record;
import java.util.*;
import java.awt.event.*;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class PnlSrnHeadBasicFields
    //extends JPanel {
    extends processhandler.template.PnlFieldsEditor{
  JLabel jLabel8 = new JLabel();
  JLabel jLabel4 = new JLabel();
  JComboBox cbxShipStatus = new JComboBox();
  JLabel jLabelA = new JLabel();
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel1 = new BlueBkgWhiteCharLabel();
  JLabel jLabelB = new JLabel();
  JLabel jLabelF = new JLabel();
  JTextField txtShipFtyInvNo = new JTextField();
  JLabel jLabelC = new JLabel();
  JComboBox cbxShipAccPrintByMaker = new JComboBox();
  WhiteBkgBlueCharLabel lblMakerDbCr = new WhiteBkgBlueCharLabel();
  JComboBox cbxNetTermCode = new JComboBox();
  JLabel jLabelE = new JLabel();
  JComboBox cbxShipAccPrintByBuyer = new JComboBox();
  WhiteBkgBlueCharLabel lblBuyerDbCr = new WhiteBkgBlueCharLabel();
  JLabel jLabelD = new JLabel();
  static Vector vctPN=null;
  static Vector vctYN=null;
  static Vector vct1N=null;
  exgui.DataBindJCombobox dbCbxLocalVoucher,dbCbxNetTermCode,dbCbxShipAccPrintByBuyer,dbCbxShipAccPrintByMaker;
  exgui.DataBindJCombobox dbCbxShipStatus;
  WhiteBkgBlueCharLabel lblCnv2LocalVoucher = new WhiteBkgBlueCharLabel();
  JLabel jLabelD1 = new JLabel();
  JButton btnStylePo = new JButton();
  public PnlSrnHeadBasicFields() {
    try {
      jbInit();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }

 protected void jbInit() throws Exception {

   if(vct1N==null){
     vct1N=new Vector();
     Record recUnit=(Record)newtimes.preproduction.guis.tempProperties.tmpUnits.get(0);
     recUnit.getFieldName().clear();
     recUnit.getValueFields().clear();

     recUnit.getFieldName().add("FIELD");
     recUnit.getValueFields().add("1");

     vct1N.add(util.MiscFunc.deepCopy(recUnit));
     recUnit.set(0,null);
     vct1N.add(util.MiscFunc.deepCopy(recUnit));
   }


    if(vctPN==null){
      vctPN=new Vector();
      Record recUnit=(Record)newtimes.preproduction.guis.tempProperties.tmpUnits.get(0);
      recUnit.getFieldName().clear();
      recUnit.getValueFields().clear();

      recUnit.getFieldName().add("FIELD");
      recUnit.getValueFields().add("P");

      vctPN.add(util.MiscFunc.deepCopy(recUnit));
      recUnit.set(0,null);
      vctPN.add(util.MiscFunc.deepCopy(recUnit));
    }

    if(vctYN==null){
      vctYN=new Vector();
      Record recUnit=(Record)newtimes.preproduction.guis.tempProperties.tmpUnits.get(0);
      recUnit.getFieldName().clear();
      recUnit.getValueFields().clear();

      recUnit.getFieldName().add("FIELD");
      recUnit.getValueFields().add("Y");

      vctYN.add(util.MiscFunc.deepCopy(recUnit));

      recUnit.set(0,"N");
      vctYN.add(util.MiscFunc.deepCopy(recUnit));


    }


    jLabelD.setBounds(new Rectangle(66, 264, 206, 22));
    jLabelD.setText("Convert To NetTerm Code");
    jLabelD.setFont(new java.awt.Font("Dialog", 1, 11));
    lblBuyerDbCr.setBounds(new Rectangle(302, 151, 122, 24));
    lblBuyerDbCr.setText("");
    lblBuyerDbCr.setForeground(Color.black);
    cbxShipAccPrintByBuyer.setBounds(new Rectangle(302, 310, 128, 22));
    jLabelE.setBounds(new Rectangle(66, 310, 229, 22));
    jLabelE.setText("Print Inv Receive List Of Buyer Code");
    jLabelE.setFont(new java.awt.Font("Dialog", 1, 11));
    cbxNetTermCode.setBounds(new Rectangle(302, 264, 128, 22));
    lblMakerDbCr.setText("");
    lblMakerDbCr.setForeground(Color.black);
    lblMakerDbCr.setBounds(new Rectangle(302, 183, 122, 24));
    cbxShipAccPrintByMaker.setBounds(new Rectangle(302, 348, 128, 22));
    jLabelC.setFont(new java.awt.Font("Dialog", 1, 11));
    jLabelC.setText("Export To Local Voucher");
    jLabelC.setBounds(new Rectangle(66, 226, 206, 22));
    txtShipFtyInvNo.setBounds(new Rectangle(302, 79, 124, 22));
    txtShipFtyInvNo.setText("");
    jLabelF.setFont(new java.awt.Font("Dialog", 1, 11));
    jLabelF.setText("Print Inv Receive List Of Maker Code");
    jLabelF.setBounds(new Rectangle(66, 348, 224, 22));
    jLabelB.setFont(new java.awt.Font("Dialog", 1, 11));
    jLabelB.setText("Exported Buyer Comm. To D/B Code:");
    jLabelB.setBounds(new Rectangle(66, 151, 222, 22));
    blueBkgWhiteCharLabel1.setBounds(new Rectangle(-4, 34, 496, 33));
    blueBkgWhiteCharLabel1.setText("SRN HEAD FIELDS");
    jLabelA.setBounds(new Rectangle(66, 117, 223, 22));
    jLabelA.setText("Print Daily Shipment Report Code");
    jLabelA.setFont(new java.awt.Font("Dialog", 1, 11));
    cbxShipStatus.setBounds(new Rectangle(302, 117, 124, 22));
    jLabel4.setBounds(new Rectangle(66, 183, 229, 22));
    jLabel4.setText("Exported Maker Disc. To D/B Code:");
    jLabel4.setFont(new java.awt.Font("Dialog", 1, 11));
    jLabel8.setFont(new java.awt.Font("Dialog", 1, 11));
    jLabel8.setText("FTY-INV-NO.");
    jLabel8.setBounds(new Rectangle(66, 79, 206, 22));
    this.setLayout(null);
    lblCnv2LocalVoucher.setBounds(new Rectangle(302, 226, 122, 24));
    lblCnv2LocalVoucher.setForeground(Color.black);
    lblCnv2LocalVoucher.setText("");
    jLabelD1.setFont(new java.awt.Font("Dialog", 1, 11));
    jLabelD1.setText("Modify STYLE & PO");
    jLabelD1.setBounds(new Rectangle(65, 378, 116, 22));
    btnStylePo.setBounds(new Rectangle(183, 378, 45, 22));
    btnStylePo.setFont(new java.awt.Font("Dialog", 1, 11));
    btnStylePo.setHorizontalAlignment(SwingConstants.CENTER);
    btnStylePo.setHorizontalTextPosition(SwingConstants.CENTER);
    btnStylePo.setText("...");
    btnStylePo.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnStylePo_actionPerformed(e);
      }
    });
    this.add(blueBkgWhiteCharLabel1, null);
    this.add(jLabel8, null);
    this.add(txtShipFtyInvNo, null);

    if(util.PublicVariable.USER_RECORD.getInt(2)== newtimesejb.preproduction.PreProductionHead.USER_TYPE_SUPERVIOSER_MIS){

      this.add(jLabelA, null);
      this.add(cbxShipStatus, null);
      this.add(jLabelB, null);
      this.add(lblBuyerDbCr, null);
      this.add(jLabel4, null);
      this.add(lblMakerDbCr, null);
      this.add(jLabelC, null);
      this.add(jLabelD, null);
      this.add(cbxNetTermCode, null);
      this.add(jLabelE, null);
      this.add(cbxShipAccPrintByBuyer, null);
      this.add(jLabelF, null);
      this.add(cbxShipAccPrintByMaker, null);
      this.add(lblCnv2LocalVoucher, null);
    }
    this.add(jLabelD1, null);
    this.add(btnStylePo, null);

  }
  public void record2Gui(){
    try{
      dataBoundGUIs.clear();
      Object vftxt_FTY_Inv = exgui.verification.CellFormat.getOrdinaryField(25);
      dataBoundGUIs.add(new exgui.DataBindTextWithChecker(txtShipFtyInvNo,
                        "SHIP_FTY_INV",
                        recToMapping.get("SHIP_FTY_INV"), 25,
                        (exgui.Object2String)vftxt_FTY_Inv,
                        (exgui.ultratable.CellTxtEditorFormat)vftxt_FTY_Inv)
                        );
      if(util.PublicVariable.USER_RECORD.getInt(2)==
          newtimesejb.preproduction.PreProductionHead.USER_TYPE_SUPERVIOSER_MIS){
        if(recToMapping.get("_local_voucher")!=null){
            lblCnv2LocalVoucher.setText((String)recToMapping.get("_local_voucher"));
        }

        dbCbxNetTermCode = new exgui.DataBindJCombobox(cbxNetTermCode,
            "DEBIT_NOTE_PROCESSED",
            vctPN,
            "FIELD", "FIELD",
            recToMapping.get("DEBIT_NOTE_PROCESSED"));
        dataBoundGUIs.add(dbCbxNetTermCode);

        dbCbxShipStatus = new exgui.DataBindJCombobox(cbxShipStatus,
            "SHIP_STATUS",
            vctYN,
            "FIELD", "FIELD",
            recToMapping.get("SHIP_STATUS"));
        dataBoundGUIs.add(dbCbxShipStatus);

        dbCbxShipAccPrintByBuyer = new exgui.DataBindJCombobox(
            cbxShipAccPrintByBuyer,
            "SHIP_ACC_PRINT_BY_BUYER",
            vct1N,
            "FIELD", "FIELD",
            recToMapping.get("SHIP_ACC_PRINT_BY_BUYER"));
        dataBoundGUIs.add(dbCbxShipAccPrintByBuyer);

        dbCbxShipAccPrintByMaker = new exgui.DataBindJCombobox(
            cbxShipAccPrintByMaker,
            "SHIP_ACC_PRINT_BY_MAKER",
            vct1N,
            "FIELD", "FIELD",
            recToMapping.get("SHIP_ACC_PRINT_BY_MAKER"));
        dataBoundGUIs.add(dbCbxShipAccPrintByMaker);
        Object objDbCrBuyer = recToMapping.get("_buyer_comm_dbcr");
        Object objDbCrMaker = recToMapping.get("_maker_disc_dbcr");
        lblBuyerDbCr.setText((objDbCrBuyer == null) ? "" :
                             objDbCrBuyer.toString());
        lblMakerDbCr.setText((objDbCrMaker == null) ? "" :
                             objDbCrMaker.toString());
      }
    }catch(Exception exp){
      exp.printStackTrace();
    }

  }
  protected void update() throws Exception{
    if(!gui2Record())return;
    newtimesejb.debitNote.LocalVoucherFacadeHome ejbHome=
        (newtimesejb.debitNote.LocalVoucherFacadeHome)
        info_ejb.WeblogicServiceLocator.locateServiceHome(util.PublicVariable.SERVER_URL,
        "newtimesejb.debitNote.LocalVoucherFacade");
    newtimesejb.debitNote.LocalVoucherFacade ejb=ejbHome.create();
    recToMapping.set("record_modify_user",util.PublicVariable.USER_RECORD.get(0));
    ejb.updateShipHeadBasicFields(recToMapping);
  }
  public void doPrint(){}

  void btnStylePo_actionPerformed(ActionEvent e) {
      DlgModifyStylePo dlg=new DlgModifyStylePo(util.PublicVariable.APP_FRAME,
                                              "STYLE & PO OF"+(String)recToMapping.get(0)
                                              ,true,(String)recToMapping.get(0));
     dlg.setSize(524,375);
     exgui.UIHelper.setToScreenCenter(dlg);
     dlg.show();



  }
}
