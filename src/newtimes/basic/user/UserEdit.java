package newtimes.basic.user;

import java.awt.*;
import newtimes.*;
import javax.swing.*;
import java.awt.event.*;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author unascribed
 * @version 1.0
 */

public class UserEdit extends JPanel {
  Frame1 frame;
  private JTextField textAreaStatus = new JTextField();
  private JButton butnDel = new JButton();
  private JButton butnExit = new JButton();
  private JButton butnModify = new JButton();
  private JLabel jLabel1 = new JLabel();
  java.util.HashMap hm =
    (java.util.HashMap)util.ApplicationProperites.getProperties("recDetail");
  database.datatype.Record recDetail = (database.datatype.Record) hm.get("recDetail");
  private newtimes.basic.user.UserFieldsPanel userFieldsPanel =
      new newtimes.basic.user.UserFieldsPanel(frame, "EDIT");
  private java.util.Vector _oldListMag = new java.util.Vector();
  static boolean isExit = false;
  JScrollPane jScrollPane1 = new JScrollPane();
  public UserEdit(Frame1 _frame) {
    frame = _frame;
    try {
      jbInit();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }
  void jbInit() throws Exception {
    userFieldsPanel.setMaxLength();
    jLabel1.setBounds(new Rectangle(117, 26, 566, 24));
    jLabel1.setText("      ============  User Edit  ============      ");
    jLabel1.setHorizontalAlignment(SwingConstants.CENTER);
    jLabel1.setBorder(BorderFactory.createEtchedBorder());
    jLabel1.setForeground(new Color(10,36,106));
    jLabel1.setFont(new java.awt.Font("Dialog", 1, 13));
    butnModify.setText("Confirm Modify");
    butnModify.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        butnModify_actionPerformed(e);
      }
    });
    butnModify.setBorder(BorderFactory.createEtchedBorder());
    butnModify.setForeground(Color.darkGray);
    butnModify.setFont(new java.awt.Font("Dialog", 1, 13));
    butnModify.setBounds(new Rectangle(230, 509, 123, 25));
    butnModify.setBackground(Color.lightGray);
    butnExit.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        butnExit_actionPerformed(e);
      }
    });
    butnExit.setText("Exit");
    butnExit.setBorder(BorderFactory.createEtchedBorder());
    butnExit.setForeground(Color.darkGray);
    butnExit.setFont(new java.awt.Font("Dialog", 1, 13));
    butnExit.setBounds(new Rectangle(466, 509, 80, 25));
    butnExit.setBackground(Color.lightGray);
    butnDel.setText("Delete");
    butnDel.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        butnDel_actionPerformed(e);
      }
    });
    butnDel.setBorder(BorderFactory.createEtchedBorder());
    butnDel.setForeground(Color.darkGray);
    butnDel.setFont(new java.awt.Font("Dialog", 1, 13));
    butnDel.setBounds(new Rectangle(370, 509, 80, 25));
    butnDel.setBackground(Color.lightGray);
    textAreaStatus.setBounds(new Rectangle(0, 540, 800, 30));
    textAreaStatus.setEditable(false);
    textAreaStatus.setBorder(null);
    textAreaStatus.setBackground(new Color(143, 143, 188));
    this.setLayout(null);
    this.setSize(800,600);
    this.setBackground(new Color(204, 204, 225));
    userFieldsPanel.setBounds(new Rectangle(7, 65, 777, 431));
    jScrollPane1.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
    jScrollPane1.getViewport().setBackground(new Color(204, 204, 225));
    jScrollPane1.setAutoscrolls(true);
    jScrollPane1.setBorder(BorderFactory.createEtchedBorder());
    jScrollPane1.setMinimumSize(new Dimension(24, 24));
    jScrollPane1.setBounds(new Rectangle(0, 66, 793, 435));
    this.add(jScrollPane1, null);
    jScrollPane1.getViewport().add(userFieldsPanel, null);
    this.add(textAreaStatus, null);
    this.add(jLabel1, null);
    this.add(butnExit, null);
    this.add(butnDel, null);
    this.add(butnModify, null);
    userFieldsPanel.setComboData();
    this.setData2Fields();
    userFieldsPanel.txtUsrCode.setEditable(false);
    userFieldsPanel.txtUsrCode.setEnabled(false);
  }

  void butnExit_actionPerformed(ActionEvent e) {
    setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
    isExit = true;
    frame.showPanel(new newtimes.basic.user.UserList(frame));
    setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
  }

  void butnDel_actionPerformed(ActionEvent e) {
    int result = exgui2.InfoMessage.Yes_No_Option(frame,"Delete ?");
    if(result == 0){
      setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
      try {
        isExit = true;
        hm.clear();
        hm = userFieldsPanel.setData2HashMap();
        hm.put("old_mng", this._oldListMag);
        hm.put("delete_user", util.PublicVariable.USER_RECORD.get("USR_CODE"));
        boolean isOk = exgui2.CONST.BASIC_BASE_EJB.deleteUserfile(hm);
        if (isOk) {
          exgui2.InfoMessage.infoMessage(frame, "Delete Succeed.");
          frame.showPanel(new newtimes.basic.user.UserList(frame));
        } else {
          exgui2.InfoMessage.warningMessage(frame, "Delete Failed.");
        }
      }catch(BasicMdlEJBs.ExcpDltReferedByProdution edProdUsed){
       exgui.verification.VerifyLib.showPlanMsg("User Is Referenced In Some Production(s)\nPleae Delete The Production(s) Created By This User",
                                                "Record Referenced");
        return;
      }catch(java.rmi.RemoteException rexp){
        util.ExceptionLog.exp2File(rexp,"error,while attemp to insert user file");
        Throwable expCoz=rexp.getCause();
        if(expCoz instanceof javax.ejb.EJBException){
          expCoz=((javax.ejb.EJBException)expCoz).getCausedByException();
        }
        System.out.println(expCoz.getLocalizedMessage());
        if(expCoz instanceof java.sql.SQLException ){
          String string=expCoz.getLocalizedMessage();
            exgui.verification.VerifyLib.showAlert(
              "Server Side Database Error\nPlease Contact System Manager\nError:"+string,
              "SQL Error");
        }else{
          exgui.verification.VerifyLib.showAlert(
           "I/O Connection Error\nPlease Contact System Manager",
           "Connection Error");
        }
      } catch (Exception eIn) {
        util.ExceptionLog.exp2File(eIn,"error,while attemp to insert user file");
        eIn.printStackTrace();
        util.ExceptionLog.exp2File(eIn, "HashMap:" + hm.toString());
        exgui.verification.VerifyLib.showAlert(
         "Unkwon Error,Please Contact System Manager",
         "Unkown Error");
      }finally{
        setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
      }
    }
  }

  void butnModify_actionPerformed(ActionEvent e) {
    setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
    if (userFieldsPanel.checkFieldsData()) {
      int result = exgui2.InfoMessage.Yes_No_Option(frame, "Modify ?");
      if (result == 0) {
        try {
          isExit = true;
          hm.clear();
          hm = userFieldsPanel.setData2HashMap();
          hm.put("old_mng", this._oldListMag);
          hm.put("update_user", util.PublicVariable.USER_RECORD.get("USR_CODE"));
          boolean isOk = exgui2.CONST.BASIC_BASE_EJB.updateUserfile(hm);
          if (isOk) {
            exgui2.InfoMessage.infoMessage(frame, "Modify Succeed.");
            frame.showPanel(new newtimes.basic.user.UserList(frame));
          } else {
            exgui2.InfoMessage.warningMessage(frame, "Modify Failed.");
          }
        }catch(java.rmi.RemoteException rexp){
          util.ExceptionLog.exp2File(rexp,"error,while attemp to insert user file");
          Throwable expCoz=rexp.getCause();
          if(expCoz instanceof javax.ejb.EJBException){
            expCoz=((javax.ejb.EJBException)expCoz).getCausedByException();
          }
          System.out.println(expCoz.getLocalizedMessage());
          if(expCoz instanceof java.sql.SQLException ){
            String string=expCoz.getLocalizedMessage();
              exgui.verification.VerifyLib.showAlert(
                "Server Side Database Error\nPlease Contact System Manager\nError:"+string,
                "SQL Error");
          }else{
            exgui.verification.VerifyLib.showAlert(
             "I/O Connection Error\nPlease Contact System Manager",
             "Connection Error");
          }
        } catch (Exception eIn) {
          util.ExceptionLog.exp2File(eIn,"error,while attemp to insert user file");
          eIn.printStackTrace();
          util.ExceptionLog.exp2File(eIn, "HashMap:" + hm.toString());
          exgui.verification.VerifyLib.showAlert(
           "Unkwon Error,Please Contact System Manager",
           "Unkown Error");
        }
      }
    }
    setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
  }

  void setData2Fields() {
    //Object orgDepCen=null;
    try {
      userFieldsPanel.txtUsrCode.setText(recDetail.get("usr_code") == null ? "" : recDetail.get("usr_code").toString());
      userFieldsPanel.txtUsrName.setText(recDetail.get("usr_name") == null ? "" : recDetail.get("usr_name").toString());
      userFieldsPanel.txtUsrPwd.setText(recDetail.get("usr_pwd") == null ? "" : recDetail.get("usr_pwd").toString());
      userFieldsPanel.cmboUsrType.setSelectedIndex(Integer.parseInt(recDetail.get("usr_type").toString())-1);
      userFieldsPanel.cmboCen.setSelectedItem(recDetail.get("cen_name") == null ? "" : recDetail.get("cen_name").toString());
      userFieldsPanel.cmboDep.setSelectedItem(recDetail.get("dep_name") == null ? "" : recDetail.get("dep_name").toString());


      userFieldsPanel.cmboCenDF.setSelectedItem(recDetail.get("cen_df") == null ? "" : recDetail.get("cen_df").toString());
      userFieldsPanel.cmboDepDF.setSelectedItem(recDetail.get("dep_df") == null ? "" : recDetail.get("dep_df").toString());
      //orgDepCen=recDetail.get("usr_cen_code");

      userFieldsPanel.cmboMagDF.setSelectedItem(recDetail.get("mag_df") == null ? "" : recDetail.get("mag_df").toString());
      //userFieldsPanel.popBuyer.setText(recDetail.get("bymkr_brief") == null ? "" : recDetail.get("bymkr_brief").toString());
      userFieldsPanel.slkBuyer.init("USR_BUY_DF",recDetail.get("USR_BUY_DF"),userFieldsPanel.slkBuyer.TYPE_BUYER,true);
      exgui2.Stuff.getRadioButtonYesOrNo(userFieldsPanel.rbMill_Y, userFieldsPanel.rbMill_N, recDetail.get("usr_mod_mill").toString());
      exgui2.Stuff.getRadioButtonYesOrNo(userFieldsPanel.rbProd_Y, userFieldsPanel.rbProd_N, recDetail.get("usr_mod_prod").toString());
      exgui2.Stuff.getRadioButtonYesOrNo(userFieldsPanel.rbAmt_Y, userFieldsPanel.rbAmt_N, recDetail.get("usr_print_amt").toString());
      exgui2.Stuff.getRadioButtonYesOrNo(userFieldsPanel.rbProf_Y, userFieldsPanel.rbProf_N, recDetail.get("usr_print_profit").toString());
      exgui2.Stuff.getRadioButtonYesOrNo(userFieldsPanel.rbMag_Y, userFieldsPanel.rbMag_N, recDetail.get("usr_mng_mod").toString());
      exgui2.Stuff.getRadioButtonYesOrNo(userFieldsPanel.rbDep_Y, userFieldsPanel.rbDep_N, recDetail.get("usr_dep_mod").toString());
      exgui2.Stuff.getRadioButtonYesOrNo(userFieldsPanel.rbCen_Y, userFieldsPanel.rbCen_N, recDetail.get("usr_cen_mod").toString());
      exgui2.Stuff.getRadioButtonYesOrNo(userFieldsPanel.rbBuy_Y, userFieldsPanel.rbBuy_N, recDetail.get("usr_buy_mod").toString());
      Object auth_Bymkr_comm_discount=recDetail.get("edit_bymkr_comm_discount");
      if(auth_Bymkr_comm_discount!=null){
        String authString=auth_Bymkr_comm_discount.toString();
        if(authString.indexOf("MR")!=-1){
          userFieldsPanel.cbxAxzMkrDisc.setSelectedIndex(1);
        }
        if(authString.indexOf("BR")!=-1){
          userFieldsPanel.cbxAxzByCm.setSelectedIndex(1);
        }
        if(authString.indexOf("MW")!=-1){
          userFieldsPanel.cbxAxzMkrDisc.setSelectedIndex(2);
        }
        if(authString.indexOf("BW")!=-1){
          userFieldsPanel.cbxAxzByCm.setSelectedIndex(2);
        }
      }
      Object cancel_gen_sc=recDetail.get("allow_cancel_sc");
      if(cancel_gen_sc!=null){
         String  cancel_gen_sc_string=cancel_gen_sc.toString().toUpperCase();
         if(cancel_gen_sc_string.indexOf("G")>-1)
             userFieldsPanel.chkboxGenSC.setSelected(true);
         if(cancel_gen_sc_string.indexOf("C")>-1)
           userFieldsPanel.chkboxCancelSC.setSelected(true);
      }


      java.util.Vector vData = exgui2.CONST.BASIC_BASE_EJB.getUsrMgrFromUserCode(recDetail.get("usr_code").toString());
      for (int i = 0; i < vData.size(); i++) {
        database.datatype.Record rec = (database.datatype.Record)vData.get(i);
        this._oldListMag.add(rec.get("mng_code"));
        userFieldsPanel.vMagCode.add(rec.get("mng_code"));
        userFieldsPanel.vItems.add(rec.get("mng_abbr"));
      }
      userFieldsPanel.list_selected.setListData(userFieldsPanel.vItems);
      userFieldsPanel.init_dbJCBXMagDF();
      userFieldsPanel.beginCheckCenter=false;
      if(userFieldsPanel.dbJCBXCen!=null) userFieldsPanel.cmboCen_itemStateChanged(null);
      userFieldsPanel.cmboCenDF_itemStateChanged(null);
      userFieldsPanel.cmboDep_itemStateChanged(null);
      //userFieldsPanel.setDepItem("DEP_CEN_CODE = '"+orgDepCen+"'",false);
      userFieldsPanel.cmboDep.setSelectedItem(recDetail.get("dep_name"));
      userFieldsPanel.cmboDepDF.setSelectedItem(recDetail.get("dep_df") == null ? "" : recDetail.get("dep_df").toString());
      //if(userFieldsPanel.dbJCBXCen!=null) userFieldsPanel.cmboCen_itemStateChanged(null);
      userFieldsPanel.beginCheckCenter=true;
    }
    catch (Exception e) {
      e.printStackTrace();
      util.ExceptionLog.exp2File(e, "error at set datas to fields." +
                                 recDetail.toString());
    }
  }
}

