package newtimes.preproduction.guis;

import java.awt.*;
import javax.swing.*;
import exgui.*;
import java.awt.event.*;
import javax.swing.border.*;
import newtimes.production.report.TgrRptCheckCoo;
/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class PnlFuncList extends JPanel {
  JButton jbtnLogout = new JButton();
  JButton jbtn = new JButton();
  JButton btnMtnPreprod = new JButton();
  JButton btnToRestore = new JButton();
  JLabel jLabel1 = new JLabel();
  JLabel jLabel2 = new JLabel();
  Border border1;
  JButton btnOrderChangeCmds = new JButton();
  JButton btnApprovePo = new JButton();
  JButton btnEnquiry = new JButton();
  JButton btnModifyCreateUserCode = new JButton();
//  JButton btnCheckCoo = new JButton();
  JButton btnUploadDetermedVSD = new JButton();
  JButton btnBrandBaseStatusRpt = new JButton();

  public PnlFuncList() {
    try {
      jbInit();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }
  void jbInit() throws Exception {
    border1 = BorderFactory.createLineBorder(Color.white,1);
    setBackground(new Color(204, 204, 225));
    jbtnLogout.setBounds(new Rectangle(213, 514, 90, 28));
    jbtnLogout.setFont(new java.awt.Font("Serif", 1, 12));
    jbtnLogout.setText("Logout");
    jbtnLogout.addActionListener(new PnlFuncList_jbtnLogout_actionAdapter(this));
    jbtnLogout.addMouseListener(new PnlFuncList_jbtnLogout_mouseAdapter(this));
    this.setDebugGraphicsOptions(0);
    this.setMinimumSize(new Dimension(1, 1));
    this.setPreferredSize(new Dimension(800, 600));
    this.setLayout(null);
    jbtn.setBounds(new Rectangle(550, 514, 90, 28));
    jbtn.setFont(new java.awt.Font("Serif", 1, 12));
    jbtn.setText("EXIT");
    jbtn.addActionListener(new PnlFuncList_jbtn_actionAdapter(this));
    jbtn.addMouseListener(new PnlFuncList_jbtn_mouseAdapter(this));
    btnMtnPreprod.setBackground(Color.white);
    btnMtnPreprod.setBounds(new Rectangle(204, 97, 407, 31));
    btnMtnPreprod.setFont(new java.awt.Font("SansSerif", 1, 12));
    btnMtnPreprod.setForeground(new Color(10,36,106));
    btnMtnPreprod.setBorder(border1);
    btnMtnPreprod.setHorizontalAlignment(SwingConstants.LEADING);
    btnMtnPreprod.setText(" Production Maintain");
    btnMtnPreprod.addActionListener(new PnlFuncList_btnMtnPreprod_actionAdapter(this));
    btnToRestore.setBackground(Color.white);
    btnToRestore.setBounds(new Rectangle(204, 153, 407, 31));
    btnToRestore.setFont(new java.awt.Font("SansSerif", 1, 12));
    btnToRestore.setForeground(new Color(10,36,106));
    btnToRestore.setBorder(BorderFactory.createEtchedBorder());
    btnToRestore.setHorizontalAlignment(SwingConstants.LEADING);
    btnToRestore.setText(" Restore Deleted Productions");
    btnToRestore.addActionListener(new PnlFuncList_btnToRestore_actionAdapter(this));
    jLabel1.setBounds(new Rectangle(-1, 0, 800, 50));
    jLabel2.setFont(new java.awt.Font("Dialog", 1, 13));
    jLabel2.setForeground(new Color(10,36,106));
    jLabel2.setBorder(BorderFactory.createEtchedBorder());
    jLabel2.setHorizontalAlignment(SwingConstants.CENTER);
    jLabel2.setText("      ============  Production Maintain  ============      ");
    jLabel2.setBounds(new Rectangle(167, 55, 466, 34));
    btnOrderChangeCmds.setBackground(Color.white);
    btnOrderChangeCmds.setBounds(new Rectangle(204, 209, 407, 31));
    btnOrderChangeCmds.setFont(new java.awt.Font("SansSerif", 1, 12));
    btnOrderChangeCmds.setForeground(new Color(10,36,106));
    btnOrderChangeCmds.setBorder(border1);
    btnOrderChangeCmds.setHorizontalAlignment(SwingConstants.LEADING);
    btnOrderChangeCmds.addActionListener(new PnlFuncList_btnOrderChangeCmds_actionAdapter(this));
    btnOrderChangeCmds.setText("  Order Change");
    btnOrderChangeCmds.addActionListener(new PnlFuncList_btnOrderChangeCmds_actionAdapter(this));
 //   btnOrderChangeCmds.addActionListener(new PnlFuncList_btnOrderChangeCmds_actionAdapter(this));
    btnApprovePo.addActionListener(new PnlFuncList_btnApprovePo_actionAdapter(this));
    btnApprovePo.setText(" Approve PO.");
    btnApprovePo.addActionListener(new PnlFuncList_btnApprovePo_actionAdapter(this));
    btnApprovePo.setHorizontalAlignment(SwingConstants.LEADING);
    btnApprovePo.setBorder(BorderFactory.createEtchedBorder());
    btnApprovePo.setForeground(new Color(10,36,106));
    btnApprovePo.setFont(new java.awt.Font("SansSerif", 1, 12));
    btnApprovePo.setBounds(new Rectangle(203, 405, 407, 31));
    btnApprovePo.setBackground(Color.white);
    btnEnquiry.setBackground(Color.white);
    btnEnquiry.setBounds(new Rectangle(205, 265, 407, 31));
    btnEnquiry.setFont(new java.awt.Font("SansSerif", 1, 12));
    btnEnquiry.setForeground(new Color(10,36,106));
    btnEnquiry.setBorder(BorderFactory.createEtchedBorder());
    btnEnquiry.setHorizontalAlignment(SwingConstants.LEADING);
    btnEnquiry.addActionListener(new PnlFuncList_btnEnquiry_actionAdapter(this));
    btnEnquiry.setText(" Production Enquiry");
    btnEnquiry.addActionListener(new PnlFuncList_btnEnquiry_actionAdapter(this));
    btnEnquiry.addActionListener(new PnlFuncList_btnEnquiry_actionAdapter(this));

    btnModifyCreateUserCode.setBounds(new Rectangle(204, 327, 407, 31));
    btnModifyCreateUserCode.setFont(new java.awt.Font("Dialog", 1, 11));
    btnModifyCreateUserCode.setText("Change PO Create User Code");
    btnModifyCreateUserCode.addActionListener(new PnlFuncList_btnModifyCreateUserCode_actionAdapter(this));




    btnUploadDetermedVSD.addActionListener(new PnlFuncList_btnUploadDetermedVSD_actionAdapter(this));
    btnUploadDetermedVSD.setText("  VSD UPLOAD");
    btnUploadDetermedVSD.setHorizontalAlignment(SwingConstants.LEADING);
    btnUploadDetermedVSD.setBorder(BorderFactory.createEtchedBorder());
    btnUploadDetermedVSD.setForeground(new Color(10,36,106));
    btnUploadDetermedVSD.setFont(new java.awt.Font("SansSerif", 1, 12));
    btnUploadDetermedVSD.setBounds(new Rectangle(204, 384, 407, 31));
    btnUploadDetermedVSD.setBackground(Color.white);
    btnBrandBaseStatusRpt.setText("  BrandBase Status Report");
    btnBrandBaseStatusRpt.addActionListener(new PnlFuncList_btnBrandBaseStatusRpt_actionAdapter(this));
    btnBrandBaseStatusRpt.setHorizontalAlignment(SwingConstants.LEADING);
    btnBrandBaseStatusRpt.setBorder(BorderFactory.createEtchedBorder());
    btnBrandBaseStatusRpt.setForeground(new Color(10,36,106));
    btnBrandBaseStatusRpt.setFont(new java.awt.Font("SansSerif", 1, 12));
    btnBrandBaseStatusRpt.setBounds(new Rectangle(205, 321, 407, 31));
    btnBrandBaseStatusRpt.setBackground(Color.white);
    this.add(jLabel1, null);
    //only MIS OR SUPERVISOR are allow to chage order.
    int usr_type=util.PublicVariable.USER_RECORD.getInt("USR_TYPE");
    this.add(btnApprovePo, null);
    this.add(jbtn, null);
    this.add(jbtnLogout, null);

    if(usr_type==newtimesejb.preproduction.PreProductionHead.USER_TYPE_CEO||
      usr_type==newtimesejb.preproduction.PreProductionHead.USER_TYPE_SUPERVIOSER_MIS){
      //btnProdConfirmList.setVisible(true);
      btnOrderChangeCmds.setVisible(true);
    }else{
      //btnProdConfirmList.setVisible(false);
      btnOrderChangeCmds.setVisible(false);
    }

    //lbl_PrintReport.setVisible(false);
    //btnAddClib.setVisible(false);
    //btnOrderChangeCmds.setVisible(false);
    jLabel1.setIcon(exgui.UIHelper.getIcon("title04.jpg"));
    this.setCursor(new Cursor(Cursor.WAIT_CURSOR));
    newtimes.preproduction.buyermakerselect.SelectBuyerMaker.clearFoundBuyerMaker();
    newtimes.production.process.prodmaintain.DB_ProdSC.reloadDestAndBranch();
    this.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
    btnApprovePo.setVisible(false);//
    //only KS department allow to modify record create user
    this.add(jLabel2, null);
    this.add(btnMtnPreprod, null);
    this.add(btnToRestore, null);
    this.add(btnOrderChangeCmds, null);
    this.add(btnEnquiry, null);
    //this.add(btnBrandBaseStatusRpt, null);

    System.out.println("center is "+util.PublicVariable.USER_RECORD.get(4));
    System.out.println("user is "+util.PublicVariable.USER_RECORD.get(0));
    if(util.PublicVariable.USER_RECORD.get(4).equals("NTFE")){
      if("NTFE".equals(util.PublicVariable.USER_RECORD.get(0)) ||
         "DENNIS".equals(util.PublicVariable.USER_RECORD.get(0))||
         "KANGIECHAN".equals(util.PublicVariable.USER_RECORD.get(0))||
         "WANGIECHAN".equals(util.PublicVariable.USER_RECORD.get(0))||
         "KCHIPANWONG".equals(util.PublicVariable.USER_RECORD.get(0))||
         "WCHIPANWONG".equals(util.PublicVariable.USER_RECORD.get(0))||
         "KPATCHIAING".equals(util.PublicVariable.USER_RECORD.get(0))||
         "WPATCHIANG".equals(util.PublicVariable.USER_RECORD.get(0))||
         "KWINNIEAU".equals(util.PublicVariable.USER_RECORD.get(0))||
         "WWINNIEAU".equals(util.PublicVariable.USER_RECORD.get(0))||
         "SF".equals(util.PublicVariable.USER_RECORD.get(5))||
         "AE".equals(util.PublicVariable.USER_RECORD.get(5))
         ){


        this.add(btnBrandBaseStatusRpt, null);
       }
    }



    //this.add(btnModifyCreateUserCode, null);
    //tempraryly, it only allow the PWANTHONYLIU user to test it.

    //util.PublicVariable.USER_RECORD.get(4).equals("PW")
    //&& newtimes.shipping_admin.ShippingAdmin_Const.isUserEric()
    if("PWANTHONYLIU".equals(util.PublicVariable.USER_RECORD.get(0))||
       "PRVICKITANG".equals(util.PublicVariable.USER_RECORD.get(0))
       ){
      this.add(btnUploadDetermedVSD, null);
    }
    if(util.PublicVariable.USER_RECORD.get(4).equals("001")){
       this.add(btnModifyCreateUserCode, null);
 //      this.add(btnCheckCoo, null);
    }
    if(util.PublicVariable.USER_RECORD.getInt(2)==newtimesejb.preproduction.PreProductionHead.USER_TYPE_ABROAD_USERS){
      //offshore user only allow to see "enquirey function
      this.remove(btnMtnPreprod);
      this.remove(btnToRestore);
    }

  }




  void jbtnLogout_mouseClicked(MouseEvent e) {

  }

  void jbtnEXIT_mouseClicked(MouseEvent e) {

  }

  void lbl_PPD_Mtn_mouseClicked(MouseEvent e) {
    try{
     processhandler.template.Properties.getCenteralControler().doCommandExecute(
      new newtimes.preproduction.process.TgrToGenQryPreProdGUI());
    }catch(Exception ie){
      ie.printStackTrace();
    }

  }

  void btnMtnPreprod_actionPerformed(ActionEvent e) {
    newtimes.production.ProdMaintain_Properties.setWaitCursor();
    try{
      if("NTFE".equals(util.PublicVariable.OPERATTING_CENTER)||
         "NTD".equals(util.PublicVariable.OPERATTING_CENTER)||
         "CG".equals(util.PublicVariable.OPERATTING_CENTER)||
         "PW".equals(util.PublicVariable.OPERATTING_CENTER)||
         "BW".equals(util.PublicVariable.OPERATTING_CENTER)){
        newtimes.preproduction.guis.tempProperties.tmpInspecOffice.clear();
        java.util.Vector vctInsp = exgui2.CONST.BASIC_MAIN_EJB.getDatas(
            util.PublicVariable.USER_RECORD,
            "select * from INSPEC_OFFICE order by cen_name", 1, 99999);
        newtimes.preproduction.guis.tempProperties.tmpInspecOffice.addAll(
            vctInsp);
      }
     processhandler.template.Properties.getCenteralControler().setSystemCommander(
       newtimes.preproduction.Constants.CMDSET_PREPRODUCTION_MAINTAIN
     );
     processhandler.template.Properties.getCenteralControler().doCommandExecute(
      new newtimes.preproduction.process.TgrToGenQryPreProdGUI());
    }catch(Exception ie){
      ie.printStackTrace();
    }finally{
      newtimes.production.ProdMaintain_Properties.setNormalCursor();
    }
  }

  void btnAddClib_actionPerformed(ActionEvent e) {
    try{
     processhandler.template.Properties.getCenteralControler().doCommandExecute(
      new newtimes.preproduction.process.TgrToSingleAddClib());
    }catch(Exception ie){
      ie.printStackTrace();
    }

  }

  void btnToRestore_actionPerformed(ActionEvent e) {
    try{
      newtimes.production.ProdMaintain_Properties.setWaitCursor();

      if("NTFE".equals(util.PublicVariable.OPERATTING_CENTER)||
         "NTD".equals(util.PublicVariable.OPERATTING_CENTER)||
         "CG".equals(util.PublicVariable.OPERATTING_CENTER)||
         "PW".equals(util.PublicVariable.OPERATTING_CENTER)||
         "BW".equals(util.PublicVariable.OPERATTING_CENTER)){
        newtimes.preproduction.guis.tempProperties.tmpInspecOffice.clear();
        java.util.Vector vctInsp = exgui2.CONST.BASIC_MAIN_EJB.getDatas(
            util.PublicVariable.USER_RECORD,
            "select * from INSPEC_OFFICE order by cen_name", 1, 99999);
        newtimes.preproduction.guis.tempProperties.tmpInspecOffice.addAll(
            vctInsp);
      }


      processhandler.template.Properties.getCenteralControler().doCommandExecute(
      new newtimes.preproduction.process.TgrToGenQryGui4Restore());
    }catch(Exception ie){
      ie.printStackTrace();
    }finally{
      newtimes.production.ProdMaintain_Properties.setNormalCursor();
    }

  }
  void btnProdConfirmList_actionPerformed(ActionEvent e) {
    try{
      newtimes.production.ProdMaintain_Properties.setWaitCursor();
     processhandler.template.Properties.getCenteralControler().setSystemCommander(
       newtimes.production.ProdMaintain_Properties.CMD_SET_PROD_CNFM_LIST
     );
    util.ApplicationProperites.removeProperites(
           "newtimes.production.gui.audit_sc_ct.PnlListPrdCnfm.PagePageRowAt");
     processhandler.template.Properties.getCenteralControler().doCommandExecute(
      new newtimes.production.process.audit_sc_ct.TgrToListProdConfirm());
    }catch(Exception ie){
      ie.printStackTrace();
    }finally{
      newtimes.production.ProdMaintain_Properties.setNormalCursor();
    }
  }

  void btnOrderChangeCmds_actionPerformed(ActionEvent e) {
    try{
      newtimes.production.ProdMaintain_Properties.setWaitCursor();
     processhandler.template.Properties.getCenteralControler().setSystemCommander(
       newtimes.production.ProdMaintain_Properties.CMD_SET_ORDER_CHAGNE_COMMANDS
     );
     processhandler.template.Properties.getCenteralControler().doCommandExecute(
      new newtimes.production.process.order_change.TgrToInputSCNO());
    }catch(Exception ie){
      ie.printStackTrace();
    }finally{
      newtimes.production.ProdMaintain_Properties.setNormalCursor();
    }
  }

  void jbtnLogout_actionPerformed(ActionEvent e) {
    JPanel panel = new newtimes.Login((newtimes.Frame1)util.PublicVariable.APP_FRAME);
    this.removeAll();
    this.add(panel, null);
    panel.setBounds(0, 0, 800, 600);
    panel.repaint();
    panel.validate();
  }

  void jbtn_actionPerformed(ActionEvent e) {
    JPanel panel = new newtimes.MainFunction((newtimes.Frame1)util.PublicVariable.APP_FRAME);
    this.removeAll();
    this.add(panel, null);
    panel.setBounds(0, 0, 800, 600);
    panel.repaint();
    panel.validate();
  }

  void btnApprovePo_actionPerformed(ActionEvent e) {
    newtimes.production.ProdMaintain_Properties.setWaitCursor();
    try{
     processhandler.template.Properties.getCenteralControler().setSystemCommander(
       newtimes.preproduction.Constants.CMDSET_PREPRODUCTION_MAINTAIN
     );
     processhandler.template.Properties.getCenteralControler().doCommandExecute(
      new newtimes.preproduction.process.TgrGenQry4NthkAppvQry());
    }catch(Exception ie){
      ie.printStackTrace();
    }finally{
      newtimes.production.ProdMaintain_Properties.setNormalCursor();
    }

  }

  void btnEnquiry_actionPerformed(ActionEvent e) {
    newtimes.production.ProdMaintain_Properties.setWaitCursor();
    try{
     newtimes.nthk_enqry.EnqryConstants.STORED_PNL_4_QRY=null;
     processhandler.template.Properties.getCenteralControler().setSystemCommander(
       newtimes.preproduction.Constants.CMDSET_PREPRODUCTION_MAINTAIN
     );
     processhandler.template.Properties.getCenteralControler().doCommandExecute(
      new newtimes.nthk_enqry.TgrShowQryGui());
    }catch(Exception ie){
      ie.printStackTrace();
    }finally{
      newtimes.production.ProdMaintain_Properties.setNormalCursor();
    }
  }
  void btnCheckCoo_actionPerformed(ActionEvent e) {

      try{
        processhandler.template.Properties.getCenteralControler().doCommandExecute(
       new TgrRptCheckCoo());

      }catch(Exception ie){

      }finally{
       newtimes.production.ProdMaintain_Properties.setNormalCursor();
      }
    }


  void btnModifyCreateUserCode_actionPerformed(ActionEvent e) {
    try{

      java.util.Vector vct =null;
      if(util.PublicVariable.USER_RECORD.getInt("USR_TYPE")==newtimesejb.preproduction.PreProductionHead.USER_TYPE_SUPERVIOSER_MIS){
        String cenCode=util.PublicVariable.OPERATTING_CENTER;
        vct=
        exgui2.CONST.BASIC_MAIN_EJB.getDatas(
            util.PublicVariable.USER_RECORD,
            "select usr_code from userfile where usr_cen_code='" +cenCode + "' and record_delete_flag='1' order by usr_code",
            1, 9999);
      }else{

        vct=
        exgui2.CONST.BASIC_MAIN_EJB.getDatas(
            util.PublicVariable.USER_RECORD,
            "select usr_code from userfile where usr_dep_code='" +
            util.PublicVariable.USER_RECORD.get(5) + "' and record_delete_flag='1' order by usr_code",
            1, 9999);
      }

      java.util.List listUsrName=new java.util.ArrayList();
      for(int i=0;i<vct.size();i++){
        database.datatype.Record rec=(database.datatype.Record)vct.get(i);
        exgui.ultratable.Wraper4tblCbx wtr=new exgui.ultratable.Wraper4tblCbx();
        wtr.setValue(rec.get(0));
        wtr.setString((String)rec.get(0));
        listUsrName.add(wtr);
      }
       exgui.ultratable.Wraper4tblCbx[] depUsers=
           (exgui.ultratable.Wraper4tblCbx[]) listUsrName.toArray(new exgui.ultratable.Wraper4tblCbx[0]);

       newtimes.preproduction.guis.DlgModifyPoCreateUser dlg=new
           newtimes.preproduction.guis.DlgModifyPoCreateUser(util.PublicVariable.APP_FRAME,
           "Change Record Create User",true,depUsers);
       dlg.setSize(553,510);
       exgui.UIHelper.setToScreenCenter(dlg);
       dlg.show();
    }catch(Exception exp){
      exp.printStackTrace();

    }

  }
  class ChainedDialogBoxSlkVsdUpload extends exgui.chaindialog.ChainedDialogBox{
    ChainedDialogBoxSlkVsdUpload(exgui.chaindialog.Responsible next){
      super(util.PublicVariable.APP_FRAME,
         "SELECT VSD To upload",true,
         next);

    }
    public Object getDialogResult(){
      if(resultHashMap==null)return null;
      return resultHashMap.get("SC_NO");
    }
  }


  void btnUploadDetermedVSD_actionPerformed(ActionEvent e) {
    newtimes.vsd_upload.ChainDlgInputTimeStmp step1=new newtimes.vsd_upload.ChainDlgInputTimeStmp();
    ChainedDialogBoxSlkVsdUpload dlg=new ChainedDialogBoxSlkVsdUpload(step1);
    dlg.setSize(720,450);
    exgui.UIHelper.setToScreenCenter(dlg);
    dlg.show();
  }

  void btnBrandBaseStatusRpt_actionPerformed(ActionEvent e) {
    newtimes.production.ProdMaintain_Properties.setWaitCursor();
    try{
     processhandler.template.Properties.getCenteralControler().setSystemCommander(
       newtimes.preproduction.Constants.CMDSET_PREPRODUCTION_MAINTAIN
     );
      processhandler.template.Properties.getCenteralControler().recordProcess(
       new newtimes.preproduction.process.TgrShowFuncList()
      );
     processhandler.template.Properties.getCenteralControler().doCommandExecute(
      new newtimes.nthk_report.TgrRptBrandBaseStatus ());
    }catch(Exception ie){
      ie.printStackTrace();
    }finally{
      newtimes.production.ProdMaintain_Properties.setNormalCursor();
    }


  }
}

class PnlFuncList_jbtnLogout_mouseAdapter extends java.awt.event.MouseAdapter {
  PnlFuncList adaptee;

  PnlFuncList_jbtnLogout_mouseAdapter(PnlFuncList adaptee) {
    this.adaptee = adaptee;
  }
  public void mouseClicked(MouseEvent e) {
    adaptee.jbtnLogout_mouseClicked(e);
  }
}

class PnlFuncList_jbtn_mouseAdapter extends java.awt.event.MouseAdapter {
  PnlFuncList adaptee;

  PnlFuncList_jbtn_mouseAdapter(PnlFuncList adaptee) {
    this.adaptee = adaptee;
  }
  public void mouseClicked(MouseEvent e) {
    adaptee.jbtnEXIT_mouseClicked(e);
  }
}

class PnlFuncList_btnMtnPreprod_actionAdapter implements java.awt.event.ActionListener {
  PnlFuncList adaptee;

  PnlFuncList_btnMtnPreprod_actionAdapter(PnlFuncList adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.btnMtnPreprod_actionPerformed(e);
  }
}

class PnlFuncList_btnToRestore_actionAdapter implements java.awt.event.ActionListener {
  PnlFuncList adaptee;

  PnlFuncList_btnToRestore_actionAdapter(PnlFuncList adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.btnToRestore_actionPerformed(e);
  }
}

class PnlFuncList_btnOrderChangeCmds_actionAdapter implements java.awt.event.ActionListener {
  PnlFuncList adaptee;

  PnlFuncList_btnOrderChangeCmds_actionAdapter(PnlFuncList adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.btnOrderChangeCmds_actionPerformed(e);
  }
}

class PnlFuncList_jbtnLogout_actionAdapter implements java.awt.event.ActionListener {
  PnlFuncList adaptee;

  PnlFuncList_jbtnLogout_actionAdapter(PnlFuncList adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.jbtnLogout_actionPerformed(e);
  }
}

class PnlFuncList_jbtn_actionAdapter implements java.awt.event.ActionListener {
  PnlFuncList adaptee;

  PnlFuncList_jbtn_actionAdapter(PnlFuncList adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.jbtn_actionPerformed(e);
  }
}

class PnlFuncList_btnApprovePo_actionAdapter implements java.awt.event.ActionListener {
  PnlFuncList adaptee;

  PnlFuncList_btnApprovePo_actionAdapter(PnlFuncList adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.btnApprovePo_actionPerformed(e);
  }
}

class PnlFuncList_btnEnquiry_actionAdapter implements java.awt.event.ActionListener {
  PnlFuncList adaptee;

  PnlFuncList_btnEnquiry_actionAdapter(PnlFuncList adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.btnEnquiry_actionPerformed(e);
  }
}

class PnlFuncList_btnModifyCreateUserCode_actionAdapter implements java.awt.event.ActionListener {
  PnlFuncList adaptee;

  PnlFuncList_btnModifyCreateUserCode_actionAdapter(PnlFuncList adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.btnModifyCreateUserCode_actionPerformed(e);
  }
}
class PnlFuncList_btnCheckCoo_actionAdapter implements java.awt.event.ActionListener {
  PnlFuncList adaptee;

  PnlFuncList_btnCheckCoo_actionAdapter(PnlFuncList adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.btnCheckCoo_actionPerformed(e);
  }
}


class PnlFuncList_btnUploadDetermedVSD_actionAdapter implements java.awt.event.ActionListener {
  PnlFuncList adaptee;

  PnlFuncList_btnUploadDetermedVSD_actionAdapter(PnlFuncList adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.btnUploadDetermedVSD_actionPerformed(e);
  }
}

class PnlFuncList_btnBrandBaseStatusRpt_actionAdapter implements java.awt.event.ActionListener {
  PnlFuncList adaptee;

  PnlFuncList_btnBrandBaseStatusRpt_actionAdapter(PnlFuncList adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.btnBrandBaseStatusRpt_actionPerformed(e);
  }
}
