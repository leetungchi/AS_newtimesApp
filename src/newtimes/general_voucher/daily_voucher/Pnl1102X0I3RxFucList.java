package newtimes.general_voucher.daily_voucher;

import java.awt.*;
import exgui.*;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.event.*;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class Pnl1102X0I3RxFucList extends JPanel {
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel1 = new BlueBkgWhiteCharLabel();
  JPanel pnlMove2Rush = new JPanel();
  Border border1;
  TitledBorder titledBorder1;
  Border border2;
  TitledBorder titledBorder2;
  JPanel pnlMove2Rush1 = new JPanel();
  Border border3;
  TitledBorder titledBorder3;
  JButton btnExit = new JButton();
  WhiteBkgBlueCharLabel whiteBkgBlueCharLabel1 = new WhiteBkgBlueCharLabel();
  JComboBox cbxCompany = new JComboBox();
  WhiteBkgBlueCharLabel whiteBkgBlueCharLabel2 = new WhiteBkgBlueCharLabel();
  JTextField txtVhDateFrom = new JTextField();
  JTextField txtVhDateTo = new JTextField();
  WhiteBkgBlueCharLabel whiteBkgBlueCharLabel3 = new WhiteBkgBlueCharLabel();
  JButton btnCopy2Rush = new JButton();
      exgui.DataBindTextWithChecker dbTxtDateFrom;
      exgui.DataBindTextWithChecker dbTxtDateTo;
      exgui.DataBindTextWithChecker dbTxtDateTo4Rush,dbTxtDateFrom4Rush,dbTxtDateFrom4Pay,dbTxtDateTo4Pay;

      exgui.DataBindJCombobox dbCbxCompany,dbCbxCompany4Rush;
  JTextField txtVhDateFrom4Rush = new JTextField();
  JTextField txtVhDateTo4Rush = new JTextField();
  WhiteBkgBlueCharLabel whiteBkgBlueCharLabel4 = new WhiteBkgBlueCharLabel();
  JComboBox cbxCmp4Rush = new JComboBox();
  WhiteBkgBlueCharLabel whiteBkgBlueCharLabel5 = new WhiteBkgBlueCharLabel();
  WhiteBkgBlueCharLabel whiteBkgBlueCharLabel6 = new WhiteBkgBlueCharLabel();
  WhiteBkgBlueCharLabel whiteBkgBlueCharLabel7 = new WhiteBkgBlueCharLabel();
  JComboBox cbxType = new JComboBox(new String[]{"","工廠未付","自有資金","墊款","暫收款"});
  WhiteBkgBlueCharLabel whiteBkgBlueCharLabel8 = new WhiteBkgBlueCharLabel();
  WhiteBkgBlueCharLabel whiteBkgBlueCharLabel9 = new WhiteBkgBlueCharLabel();
  JTextField txtPayDateTo = new JTextField();
  JTextField txtPayDateFrom = new JTextField();
  JButton btnProcessRush = new JButton();
  static  String SQL=null;
  public Pnl1102X0I3RxFucList() {
    try {
      jbInit();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }

  void jbInit() throws Exception {
    border1 = BorderFactory.createEmptyBorder();
    titledBorder1 = new TitledBorder(new EtchedBorder(EtchedBorder.RAISED,Color.white,new Color(141, 141, 156)),"由傳票複製到沖帳區");
    border2 = new EtchedBorder(EtchedBorder.RAISED,Color.white,new Color(141, 141, 156));
    titledBorder2 = new TitledBorder(border2,"由傳票複製到沖帳區");
    titledBorder2.setTitleFont(new java.awt.Font("Dialog", 1, 16));
    border3 = new EtchedBorder(EtchedBorder.RAISED,Color.white,new Color(141, 141, 156));
    titledBorder3 = new TitledBorder(border3,"沖帳作業");
    titledBorder3.setTitleFont(new java.awt.Font("Dialog", 1, 16));
    blueBkgWhiteCharLabel1.setFont(new java.awt.Font("Dialog", 0, 16));
    blueBkgWhiteCharLabel1.setText("兆豐美乙 勾沖作業");

    blueBkgWhiteCharLabel1.setBounds(new Rectangle(0, 12, 801, 31));
    this.setBackground(new Color(202, 202, 224));
    this.setLayout(null);
    pnlMove2Rush.setBackground(new Color(202, 202, 224));
    pnlMove2Rush.setFont(new java.awt.Font("Dialog", 0, 12));
    pnlMove2Rush.setBorder(titledBorder2);
    pnlMove2Rush.setBounds(new Rectangle(12, 80, 764, 127));
    pnlMove2Rush.setLayout(null);
    pnlMove2Rush1.setBounds(new Rectangle(12, 232, 764, 181));
    pnlMove2Rush1.setLayout(null);
    pnlMove2Rush1.setBorder(titledBorder3);
    pnlMove2Rush1.setBackground(new Color(202, 202, 224));
    pnlMove2Rush1.setFont(new java.awt.Font("Dialog", 0, 12));
    btnExit.setBounds(new Rectangle(345, 480, 109, 29));
    btnExit.setFont(new java.awt.Font("Dialog", 1, 12));
    btnExit.setText("EXIT");
    btnExit.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnExit_actionPerformed(e);
      }
    });
    whiteBkgBlueCharLabel1.setFont(new java.awt.Font("Dialog", 1, 16));
    whiteBkgBlueCharLabel1.setText("公司別:");
    whiteBkgBlueCharLabel1.setBounds(new Rectangle(14, 35, 86, 26));
    cbxCompany.setBounds(new Rectangle(99, 35, 206, 26));
    whiteBkgBlueCharLabel2.setBounds(new Rectangle(332, 35, 131, 26));
    whiteBkgBlueCharLabel2.setText("傳票日期:");
    whiteBkgBlueCharLabel2.setFont(new java.awt.Font("Dialog", 1, 16));
    txtVhDateFrom.setText("");
    txtVhDateFrom.setBounds(new Rectangle(464, 35, 88, 26));
    txtVhDateTo.setBounds(new Rectangle(593, 35, 88, 26));
    txtVhDateTo.setText("2011/12/31");
    txtVhDateTo.setText("");
    whiteBkgBlueCharLabel3.setFont(new java.awt.Font("Dialog", 1, 16));
    whiteBkgBlueCharLabel3.setText("~");
    whiteBkgBlueCharLabel3.setBounds(new Rectangle(552, 35, 40, 26));
    btnCopy2Rush.setBounds(new Rectangle(328, 79, 108, 27));
    btnCopy2Rush.setFont(new java.awt.Font("Dialog", 1, 14));
    btnCopy2Rush.setText("Go!!");
    btnCopy2Rush.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnCopy2Rush_actionPerformed(e);
      }
    });
    txtVhDateFrom4Rush.setBounds(new Rectangle(463, 30, 88, 26));
    txtVhDateFrom4Rush.setText("");
    txtVhDateTo4Rush.setText("");
    txtVhDateTo4Rush.setText("");
    txtVhDateTo4Rush.setBounds(new Rectangle(592, 30, 88, 26));
    whiteBkgBlueCharLabel4.setFont(new java.awt.Font("Dialog", 1, 16));
    whiteBkgBlueCharLabel4.setText("傳票日期:");
    whiteBkgBlueCharLabel4.setBounds(new Rectangle(331, 30, 131, 26));
    cbxCmp4Rush.setBounds(new Rectangle(98, 30, 206, 26));
    whiteBkgBlueCharLabel5.setBounds(new Rectangle(13, 30, 86, 26));
    whiteBkgBlueCharLabel5.setText("公司別:");
    whiteBkgBlueCharLabel5.setFont(new java.awt.Font("Dialog", 1, 16));
    whiteBkgBlueCharLabel6.setBounds(new Rectangle(551, 30, 40, 26));
    whiteBkgBlueCharLabel6.setText("~");
    whiteBkgBlueCharLabel6.setFont(new java.awt.Font("Dialog", 1, 16));
    whiteBkgBlueCharLabel7.setFont(new java.awt.Font("Dialog", 1, 16));
    whiteBkgBlueCharLabel7.setText("款項類別:");
    whiteBkgBlueCharLabel7.setBounds(new Rectangle(13, 69, 86, 26));
    cbxType.setBounds(new Rectangle(98, 69, 206, 26));
    whiteBkgBlueCharLabel8.setBounds(new Rectangle(331, 66, 131, 26));
    whiteBkgBlueCharLabel8.setText("匯款日期:");
    whiteBkgBlueCharLabel8.setFont(new java.awt.Font("Dialog", 1, 16));
    whiteBkgBlueCharLabel9.setFont(new java.awt.Font("Dialog", 1, 16));
    whiteBkgBlueCharLabel9.setText("~");
    whiteBkgBlueCharLabel9.setBounds(new Rectangle(551, 66, 40, 26));
    txtPayDateTo.setBounds(new Rectangle(592, 66, 88, 26));
    txtPayDateTo.setText("");
    txtPayDateTo.setText("");
    txtPayDateFrom.setText("");
    txtPayDateFrom.setBounds(new Rectangle(463, 66, 88, 26));
    btnProcessRush.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnProcessRush_actionPerformed(e);
      }
    });
    btnProcessRush.setText("查詢");
    btnProcessRush.setFont(new java.awt.Font("Dialog", 1, 14));
    btnProcessRush.setBounds(new Rectangle(328, 138, 108, 27));
    this.add(blueBkgWhiteCharLabel1, null);
    this.add(pnlMove2Rush, null);
    pnlMove2Rush.add(whiteBkgBlueCharLabel1, null);
    pnlMove2Rush.add(cbxCompany, null);
    pnlMove2Rush.add(whiteBkgBlueCharLabel2, null);
    pnlMove2Rush.add(txtVhDateFrom, null);
    this.add(pnlMove2Rush1, null);
    pnlMove2Rush1.add(whiteBkgBlueCharLabel6, null);
    pnlMove2Rush1.add(whiteBkgBlueCharLabel5, null);
    pnlMove2Rush1.add(cbxCmp4Rush, null);
    pnlMove2Rush1.add(whiteBkgBlueCharLabel4, null);
    pnlMove2Rush1.add(txtVhDateFrom4Rush, null);
    pnlMove2Rush1.add(txtVhDateTo4Rush, null);
    this.add(btnExit, null);
    pnlMove2Rush.add(whiteBkgBlueCharLabel3, null);
    pnlMove2Rush.add(txtVhDateTo, null);
    pnlMove2Rush.add(btnCopy2Rush, null);
    pnlMove2Rush1.add(whiteBkgBlueCharLabel7, null);
    pnlMove2Rush1.add(cbxType, null);
    pnlMove2Rush1.add(whiteBkgBlueCharLabel8, null);
    pnlMove2Rush1.add(whiteBkgBlueCharLabel9, null);
    pnlMove2Rush1.add(txtPayDateTo, null);
    pnlMove2Rush1.add(txtPayDateFrom, null);
    pnlMove2Rush1.add(btnProcessRush, null);
    genGui();


  }
  void genGui(){
    //
    Object dateVfy=exgui.verification.CellFormat.getDateStringFormaterAllowNull();
    dbTxtDateFrom=
        new exgui.DataBindTextWithChecker(txtVhDateFrom,"",null,10,
                                          (exgui.Object2String)dateVfy,
                                          (exgui.ultratable.CellTxtEditorFormat)dateVfy);
    dbTxtDateTo=
        new exgui.DataBindTextWithChecker(txtVhDateTo,"",null,10,
                                          (exgui.Object2String)dateVfy,
                                          (exgui.ultratable.CellTxtEditorFormat)dateVfy);

    dbTxtDateFrom4Rush=
        new exgui.DataBindTextWithChecker(txtVhDateFrom4Rush,"",null,10,
                                          (exgui.Object2String)dateVfy,
                                          (exgui.ultratable.CellTxtEditorFormat)dateVfy);
    dbTxtDateTo4Rush=
        new exgui.DataBindTextWithChecker(txtVhDateTo4Rush,"",null,10,
                                          (exgui.Object2String)dateVfy,
                                          (exgui.ultratable.CellTxtEditorFormat)dateVfy);


    dbTxtDateFrom4Pay=
        new exgui.DataBindTextWithChecker(txtPayDateFrom,"",null,10,
                                          (exgui.Object2String)dateVfy,
                                          (exgui.ultratable.CellTxtEditorFormat)dateVfy);
    dbTxtDateTo4Pay=
        new exgui.DataBindTextWithChecker(txtPayDateTo,"",null,10,
                                          (exgui.Object2String)dateVfy,
                                          (exgui.ultratable.CellTxtEditorFormat)dateVfy);




    dbCbxCompany =
        new exgui.DataBindJCombobox(cbxCompany, "",
                                    newtimes.general_voucher.daily_voucher.
                                    Constants.VCT_GV_ACC_COMPANY,
                                    "comp_code_and_name", "cmp_code",null,"ALL",null);
    dbCbxCompany4Rush=
         new exgui.DataBindJCombobox(cbxCmp4Rush, "",
                                     newtimes.general_voucher.daily_voucher.
                                     Constants.VCT_GV_ACC_COMPANY,
                                     "comp_code_and_name", "cmp_code",null,"ALL",null);

  }
  void btnExit_actionPerformed(ActionEvent e) {
    try{
       processhandler.template.Properties.getCenteralControler().goBack();
    }catch(Exception exp){
      exp.printStackTrace();
     }


  }

  void btnCopy2Rush_actionPerformed(ActionEvent e) {
     if(txtVhDateFrom.getText().trim().length()!=10){
       exgui.verification.VerifyLib.showAlert("請輸入傳票起始日","請輸入傳票起始日");
       return;
     }
     if(txtVhDateTo.getText().trim().length()!=10){
       exgui.verification.VerifyLib.showAlert("請輸入傳票截止日","請輸入傳票截止日");
       return;
     }
     if(dbCbxCompany.getSelectedValue()==null||dbCbxCompany.getSelectedValue().toString().trim().length()==0){
       exgui.verification.VerifyLib.showAlert("請選擇公司別","請選擇公司別");
       return;
     }
     try{
       util.MiscFunc.showProcessingMessage();
       newtimesejb.Vh1102x0I3Rush.Vh1102x0I3RushFacadeHome ejbHome =
           (newtimesejb.Vh1102x0I3Rush.Vh1102x0I3RushFacadeHome)
           info_ejb.WeblogicServiceLocator.locateServiceHome(
           util.PublicVariable.SERVER_URL,
           "newtimesejb.Vh1102x0I3Rush.Vh1102x0I3RushFacade");
       newtimesejb.Vh1102x0I3Rush.Vh1102x0I3RushFacade ejb = ejbHome.create();
      String msg=  ejb.copyFromVhDtl2Rush((String)dbCbxCompany.getSelectedValue(),txtVhDateFrom.getText().trim()
                             ,txtVhDateTo.getText().trim(),util.PublicVariable.USER_RECORD.get(0).toString());
       exgui.verification.VerifyLib.showPlanMsg("Converted ok\n"+msg+" record converted","Convert OK");

     }catch(Exception exp){
       exp.printStackTrace();
       util.ExceptionLog.exp2File(exp,"");
       exgui.verification.VerifyLib.showAlert("COPY FROM VOUCHER TO RUSH FAILED!!\nPlease Contact System Manager",
                                              "Copy Voucher To Rush Failed");

     }

  }

  void btnProcessRush_actionPerformed(ActionEvent e) {
      //gether all condition of query.
      if(dbCbxCompany4Rush.getSelectedValue()==null||dbCbxCompany4Rush.getSelectedValue().toString().trim().length()==0){
        exgui.verification.VerifyLib.showAlert("請選擇公司別","請選擇公司別");
        cbxCmp4Rush.grabFocus();
        return;
      }
      Object objType=cbxType.getSelectedItem();
      /*
      if(objType==null||objType.toString().trim().length()==0){
        exgui.verification.VerifyLib.showAlert("請選款項類類別","請選擇款項類別");
        cbxType.grabFocus();
        return;
      }
      */
      StringBuffer sql=new StringBuffer();
      sql.append("select * from VH_1102X0I3_RUSH ");
      sql.append("where vh_no like '");
      sql.append(dbCbxCompany4Rush.getSelectedValue());
      sql.append("%' ");
      if(objType!=null && objType.toString().trim().length()>0){
        sql.append(" and TYPE='");
        sql.append(objType.toString());
        sql.append("' ");
      }
      if(txtPayDateFrom.getText().trim().length()==10){
        sql.append(" and pay_date>=to_date('");
        sql.append(txtPayDateFrom.getText().trim());
        sql.append("','yyyy/mm/dd') ") ;
      }
      if(txtPayDateTo.getText().trim().length()==10){
        sql.append(" and pay_date<=to_date('");
        sql.append(txtPayDateTo.getText().trim());
        sql.append("','yyyy/mm/dd') ") ;
      }

      if(txtVhDateFrom4Rush.getText().trim().length()==10){
        sql.append(" and vh_date>=to_date('");
        sql.append(txtVhDateFrom4Rush.getText().trim());
        sql.append("','yyyy/mm/dd') ") ;
      }

      if(txtVhDateTo4Rush.getText().trim().length()==10){
        sql.append(" and vh_date<=to_date('");
        sql.append(txtVhDateTo4Rush.getText().trim());
        sql.append("','yyyy/mm/dd') ") ;
      }
      sql.append(" order by vh_no,type ");
      SQL=sql.toString();
      try{
         processhandler.template.Properties.getCenteralControler().doCommandExecute(
         new TgrEdit1102X0I3Rush() );
      }catch(Exception exp){
        exp.printStackTrace();
       }

  }
}
