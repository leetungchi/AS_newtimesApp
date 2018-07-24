package newtimes.offshoredebitnote;

import java.awt.*;
import exgui.*;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.event.*;
import java.awt.event.*;
import newtimes.preproduction.buyermakerselect.*;
import javax.swing.border.*;
import java.awt.*;
import exgui.*;
import javax.swing.*;
import newtimes.preproduction.buyermakerselect.*;
import java.awt.event.*;
import newtimes.production.report.*;
import javax.swing.event.*;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class PnlRptOffshoreDbCrDtl
    //extends JPanel {
    extends AbsQryPanel{
  WhiteBkgBlueCharLabel whiteBkgBlueCharLabel1 = new WhiteBkgBlueCharLabel();
  JPanel jPanel1 = new JPanel();
  TitledBorder titledBorder1;

  JComboBox[] cbxDep = new JComboBox[5];
  /*
  JComboBox cbxDep1 = new JComboBox();
  JComboBox cbxDep2 = new JComboBox();
  JComboBox cbxDep3 = new JComboBox();
  JComboBox cbxDep4 = new JComboBox();
  */
  JPanel jPanel2 = new JPanel();

  JComboBox cbxCnty[] = new JComboBox[5];

  /*
  JComboBox cbxCnty4 = new JComboBox();
  JComboBox cbxCnty2 = new JComboBox();
  JComboBox cbxCnty3 = new JComboBox();
  JComboBox cbxCnty1 = new JComboBox();
  JComboBox cbxCnty0 = new JComboBox();
  */

  Border border1;
  TitledBorder titledBorder2;
  JLabel jLabel1 = new JLabel();
  JTextField txtDateFrom = new JTextField();
  JLabel jLabel2 = new JLabel();
  JTextField txtDateTo = new JTextField();
  JRadioButton rboBySeq = new JRadioButton();
  JRadioButton rboByDepCnty = new JRadioButton();
  ButtonGroup buttonGroup1 = new ButtonGroup();
  JCheckBox chkExlMrLing = new JCheckBox();
  JCheckBox chkExlComOut = new JCheckBox();
  JButton btnReport = new JButton();
  DataBindJCombobox dbCbxCnty[]=new exgui.DataBindJCombobox[5];
  DataBindJCombobox dbCbxDep[]=new exgui.DataBindJCombobox[5];
  DataBindTextWithChecker  dbTxtDateFrom,dbTxtDateTo;
  public PnlRptOffshoreDbCrDtl() {
    try {
      //jbInit();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }

  void jbInit() throws Exception {
    for(int i=0;i<5;i++){
      cbxCnty[i]=new JComboBox();
      cbxDep[i]=new JComboBox();
    }
    titledBorder1 = new TitledBorder(BorderFactory.createEtchedBorder(Color.white,new Color(141, 141, 156)),"DEPARTMENT");
    border1 = BorderFactory.createEtchedBorder(Color.white,new Color(141, 141, 156));
    titledBorder2 = new TitledBorder(border1,"COUNTRY");
    whiteBkgBlueCharLabel1.setBackground(new Color(143, 143, 188));
    whiteBkgBlueCharLabel1.setForeground(Color.white);
    whiteBkgBlueCharLabel1.setText("OFFSHORE DR/CR-NOTE DETAIL REPORT");
    whiteBkgBlueCharLabel1.setBounds(new Rectangle(0, 10, 802, 36));
    this.setBackground(new Color(202, 202, 224));
    this.setLayout(null);
    jPanel1.setBackground(new Color(202, 202, 224));
    jPanel1.setBorder(titledBorder1);
    jPanel1.setBounds(new Rectangle(4, 49, 735, 54));
    jPanel1.setLayout(null);
    cbxDep[0].setBounds(new Rectangle(6, 16, 127, 23));
    cbxDep[1].setBounds(new Rectangle(153, 16, 127, 23));
    cbxDep[2].setBounds(new Rectangle(300, 16, 127, 23));
    cbxDep[3].setBounds(new Rectangle(446, 16, 127, 23));
    cbxDep[4].setBounds(new Rectangle(593, 16, 127, 23));
    jPanel2.setLayout(null);
    jPanel2.setBounds(new Rectangle(4, 103, 732, 51));
    jPanel2.setBorder(titledBorder2);
    jPanel2.setBackground(new Color(202, 202, 224));
    cbxCnty[4].setBounds(new Rectangle(583, 16, 137, 23));
    cbxCnty[0].setBounds(new Rectangle(9, 16, 137, 23));
    cbxCnty[2].setBounds(new Rectangle(296, 16, 137, 23));
    cbxCnty[3].setBounds(new Rectangle(440, 16, 137, 23));
    cbxCnty[1].setBounds(new Rectangle(153, 16, 137, 23));
    jLabel1.setFont(new java.awt.Font("Dialog", 1, 11));
    jLabel1.setText("DATE FROM");
    jLabel1.setBounds(new Rectangle(7, 156, 76, 25));
    txtDateFrom.setText("");
    txtDateFrom.setBounds(new Rectangle(81, 156, 69, 25));
    jLabel2.setBounds(new Rectangle(155, 156, 30, 25));
    jLabel2.setText("TO");
    jLabel2.setFont(new java.awt.Font("Dialog", 1, 11));
    txtDateTo.setText("");
    txtDateTo.setBounds(new Rectangle(174, 156, 70, 25));
    rboBySeq.setBackground(new Color(202, 202, 224));
    rboBySeq.setFont(new java.awt.Font("Dialog", 1, 11));
    rboBySeq.setSelected(false);
    rboBySeq.setText("BY SEQUENCE");
    rboBySeq.setBounds(new Rectangle(561, 156, 105, 27));
    rboByDepCnty.setBounds(new Rectangle(248, 156, 119, 22));
    rboByDepCnty.addChangeListener(new javax.swing.event.ChangeListener() {
      public void stateChanged(ChangeEvent e) {
        rboByDepCnty_stateChanged(e);
      }
    });
    rboByDepCnty.setText("BY DEP/COUNTRY");
    rboByDepCnty.setFont(new java.awt.Font("Dialog", 1, 11));
    rboByDepCnty.setSelected(true);
    rboByDepCnty.setBackground(new Color(202, 202, 224));
    chkExlMrLing.setBackground(new Color(202, 202, 224));
    chkExlMrLing.setFont(new java.awt.Font("Dialog", 1, 11));
    chkExlMrLing.setText("EXCLUDE MR. LING ");
    chkExlMrLing.setBounds(new Rectangle(369, 156, 150, 22));
    chkExlComOut.setBackground(new Color(202, 202, 224));
    chkExlComOut.setFont(new java.awt.Font("Dialog", 1, 11));
    chkExlComOut.setText("EXCLUDE COMMISSION-OUT ");
    chkExlComOut.setBounds(new Rectangle(369, 179, 194, 22));
    btnReport.setBounds(new Rectangle(681, 165, 96, 27));
    btnReport.setFont(new java.awt.Font("Dialog", 1, 11));
    btnReport.setText("REPORT");
    btnReport.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnReport_actionPerformed(e);
      }
    });
    this.add(whiteBkgBlueCharLabel1, null);
    jPanel1.add(cbxDep[1], null);
    jPanel1.add(cbxDep[2], null);
    jPanel1.add(cbxDep[3], null);
    jPanel1.add(cbxDep[0], null);
    jPanel1.add(cbxDep[4], null);
    this.add(jPanel2, null);
    jPanel2.add(cbxCnty[1], null);
    jPanel2.add(cbxCnty[2], null);
    jPanel2.add(cbxCnty[3], null);
    jPanel2.add(cbxCnty[4], null);
    jPanel2.add(cbxCnty[0], null);
    this.add(jLabel2, null);
    this.add(jLabel1, null);
    this.add(txtDateFrom, null);
    this.add(txtDateTo, null);
    this.add(rboByDepCnty, null);
    this.add(chkExlMrLing, null);
    this.add(chkExlComOut, null);
    this.add(rboBySeq, null);
    this.add(jPanel1, null);
    buttonGroup1.add(rboBySeq);
    buttonGroup1.add(rboByDepCnty);
    this.add(btnReport, null);
    genDataBindObj();
  }
  public java.util.HashMap composeParameters(){
    java.util.HashMap hm=super.composeParameters();
    StringBuffer sbCnty=new StringBuffer();
    StringBuffer sbDep=new  StringBuffer();
    for(int i=0;i<5;i++){
      Object objCnty=dbCbxCnty[i].getSelectedValue();
      Object objDept=dbCbxDep[i].getSelectedValue();
      if(null!=objCnty){
        if(sbCnty.length()>0)sbCnty.append(",");
        sbCnty.append(objCnty.toString());
      }
      if(null!=objDept){
        if(sbDep.length()>0)sbDep.append(",");
        sbDep.append("'");
        sbDep.append(objDept.toString());
        sbDep.append("'");
      }
    }
    hm.put("P_COUNTRY",(sbCnty.length()==0)?"[0]":("["+sbCnty.toString()+"]") );
    hm.put("P_DEP",(sbDep.length()==0)?"['ALL']":("["+sbDep.toString()+"]") );

    Object objDateFrom=dbTxtDateFrom.getSelectedValue();
    hm.put("P_DATE_FM",(objDateFrom==null)?"DATE(2000,01,01)":convert2QueryPara(objDateFrom));

    Object objDateTo=dbTxtDateTo.getSelectedValue();
    hm.put("P_DATE_TO",(objDateTo==null)?"DATE(2099,12,31)":convert2QueryPara(objDateTo));
    if(rboBySeq.isSelected()){

    }else{
       hm.put("P_MR_LING",(chkExlMrLing.isSelected())?"Y":"N");
       hm.put("P_COMM",(chkExlComOut.isSelected())?"Y":"N");
    }
    return hm;
  }
  public void genDataBindObj(){
    try{
      util.MiscFunc.showProcessingMessage();
      java.util.Vector vctDep=null,vctCountry=null;

      if(vctDep==null){vctDep=exgui2.CONST.BASIC_MAIN_EJB.getDatas(
        util.PublicVariable.USER_RECORD,
        "select dep_code from OFS_DEBIT_NOTE_DEP order by dep_code",1,9999);}

      if(vctCountry==null){vctCountry=exgui2.CONST.BASIC_MAIN_EJB.getDatas(
        util.PublicVariable.USER_RECORD,
        "select cnty_pk,cnty_name from OFS_DEBIT_NOTE_COUNTRY order by cnty_name",1,9999);}
      util.MiscFunc.hideProcessingMessage();

    for(int i=0;i<5;i++){
      dbCbxDep[i] = new exgui.DataBindJCombobox(cbxDep[i],
                                      "DTL_DEP_CODE ",
                                       vctDep,
                                      "DEP_CODE",
                                      "DEP_CODE", null, "ALL", null);

       dbCbxCnty[i]=
          new exgui.DataBindJCombobox(cbxCnty[i], "DTL_CNTY_PK",
                                      vctCountry, "CNTY_NAME", "CNTY_PK", null,"ALL", null);

    }

    Object vftxtChkDD=exgui.verification.CellFormat.getDateStringFormaterAllowNull();
    dbTxtDateFrom= new exgui.DataBindTextWithChecker(txtDateFrom,
          "P_DATE_FM",
          null, 10,
          (exgui.Object2String)vftxtChkDD,
                        (exgui.ultratable.CellTxtEditorFormat)vftxtChkDD);
    dbTxtDateTo= new exgui.DataBindTextWithChecker(txtDateTo,
                         "P_DATE_TO", null, 10,
                          (exgui.Object2String)vftxtChkDD,
                          (exgui.ultratable.CellTxtEditorFormat)vftxtChkDD);




    }catch(Exception exp){
      exp.printStackTrace();
      exgui.verification.VerifyLib.showAlert("Error While Init-GUI For Report Offshore Detail",
                                             "Error in Init-GUI");

    }

  }
  void btnReport_actionPerformed(ActionEvent e) {
    if(rboByDepCnty.isSelected())
      reportName="ofs_drcr_dep.rpt";
    else
      reportName="ofs_drcr_dtl.rpt";

    super.JButtonQueryButtonAction(e);
  }

  void rboByDepCnty_stateChanged(ChangeEvent e) {
    if(rboByDepCnty.isSelected()){
      chkExlComOut.setEnabled(true);
      chkExlMrLing.setEnabled(true);
    }else{
      chkExlComOut.setEnabled(false);
      chkExlMrLing.setEnabled(false);
    }
  }
}
