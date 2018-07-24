package newtimes.basic;

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

public class MiscMenu extends JPanel {
  Frame1 frame;
  JTextField textAreaStatus = new JTextField();
  JLabel labelTitle = new JLabel();
  JButton butn_BuyerMaker = new JButton();
  JLabel jLabel1 = new JLabel();
  JButton butnExit = new JButton();
  JButton butn_Div = new JButton();
  JButton butnLogout = new JButton();
  JButton butn_Shapmark = new JButton();
  private String usrType = null;
  JButton butn_SystemValue = new JButton();
  JButton butn_Packing = new JButton();
  JButton btn2BroadCast = new JButton();
  JButton btn_ChineseAreaEdit = new JButton();
  JButton btnFinalEndRemark = new JButton();
  JButton btnVenderInfor = new JButton();
  JButton btnOffshoreRule = new JButton();

  public MiscMenu(Frame1 _frame) {
    frame = _frame;
    try {
      jbInit();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }
  void jbInit() throws Exception {
    butn_Shapmark.setText(" 3.  Shipping Mark");
    butn_Shapmark.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        butn_Shapmark_actionPerformed(e);
      }
    });
    butn_Shapmark.setHorizontalAlignment(SwingConstants.LEFT);
    butn_Shapmark.setFont(new java.awt.Font("Dialog", 0, 12));
    butn_Shapmark.setBorder(BorderFactory.createRaisedBevelBorder());
    butn_Shapmark.setBounds(new Rectangle(154, 248, 187, 23));
    butn_Shapmark.setBackground(Color.white);
    butnLogout.setText("Logout");
    butnLogout.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        butnLogout_actionPerformed(e);
      }
    });
    butnLogout.setForeground(Color.darkGray);
    butnLogout.setFont(new java.awt.Font("Dialog", 1, 13));
    butnLogout.setBounds(new Rectangle(284, 481, 80, 25));
    butnLogout.setBackground(Color.lightGray);
    butn_Div.setText(" 1.  Division");
    butn_Div.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        butn_Div_actionPerformed(e);
      }
    });
    butn_Div.setHorizontalAlignment(SwingConstants.LEFT);
    butn_Div.setBorder(BorderFactory.createRaisedBevelBorder());
    butn_Div.setFont(new java.awt.Font("Dialog", 0, 12));
    butn_Div.setBounds(new Rectangle(154, 171, 187, 23));
    butn_Div.setBackground(Color.white);
    butnExit.setText("Exit");
    butnExit.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        butnExit_actionPerformed(e);
      }
    });
    butnExit.setForeground(Color.darkGray);
    butnExit.setFont(new java.awt.Font("Dialog", 1, 13));
    butnExit.setBounds(new Rectangle(426, 481, 80, 25));
    butnExit.setBackground(Color.lightGray);
    jLabel1.setBounds(new Rectangle(117, 93, 566, 24));
    jLabel1.setText("      ============  Basic II Maintain  ============      ");
    jLabel1.setHorizontalAlignment(SwingConstants.CENTER);
    jLabel1.setBorder(BorderFactory.createEtchedBorder());
    jLabel1.setForeground(new Color(10,36,106));
    jLabel1.setFont(new java.awt.Font("Dialog", 1, 13));
    butn_BuyerMaker.setText(" 2.  Buyer - Maker");
    butn_BuyerMaker.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        butn_BuyerMaker_actionPerformed(e);
      }
    });
    butn_BuyerMaker.setHorizontalAlignment(SwingConstants.LEFT);
    butn_BuyerMaker.setBorder(BorderFactory.createRaisedBevelBorder());
    butn_BuyerMaker.setFont(new java.awt.Font("Dialog", 0, 12));
    butn_BuyerMaker.setBounds(new Rectangle(154, 210, 187, 23));
    butn_BuyerMaker.setBackground(Color.white);
    labelTitle.setBounds(new Rectangle(0, 0, 800, 50));
    labelTitle.setIcon(exgui.UIHelper.getIcon("title04.jpg"));
    labelTitle.setBounds(new Rectangle(0, 0, 800, 50));
    labelTitle.setText("title");
    textAreaStatus.setBounds(new Rectangle(0, 540, 800, 30));
    textAreaStatus.setEditable(false);
    textAreaStatus.setBorder(null);
    textAreaStatus.setBackground(new Color(143, 143, 188));
    this.setLayout(null);
    this.setSize(800,600);
    this.setBackground(new Color(204, 204, 225));
    butn_SystemValue.setBackground(Color.white);
    butn_SystemValue.setBounds(new Rectangle(154, 325, 187, 23));
    butn_SystemValue.setFont(new java.awt.Font("Dialog", 0, 12));
    butn_SystemValue.setBorder(BorderFactory.createRaisedBevelBorder());
    butn_SystemValue.setHorizontalAlignment(SwingConstants.LEFT);
    butn_SystemValue.setText(" 5.  System Value");
    butn_SystemValue.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        butn_SystemValue_actionPerformed(e);
      }
    });
    butn_Packing.setBackground(Color.white);
    butn_Packing.setBounds(new Rectangle(154, 287, 187, 23));
    butn_Packing.setBorder(BorderFactory.createRaisedBevelBorder());
    butn_Packing.setFont(new java.awt.Font("Dialog", 0, 12));
    butn_Packing.setHorizontalAlignment(SwingConstants.LEFT);
    butn_Packing.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        butn_Packing_actionPerformed(e);
      }
    });
    butn_Packing.setText(" 4. Packing");
    btn2BroadCast.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btn2BroadCast_actionPerformed(e);
      }
    });
    btn2BroadCast.setText("  MIS Message BroadCast");
    btn2BroadCast.setHorizontalAlignment(SwingConstants.LEFT);
    btn2BroadCast.setBorder(BorderFactory.createRaisedBevelBorder());
    btn2BroadCast.setBounds(new Rectangle(154, 399, 187, 23));
    btn2BroadCast.setForeground(Color.red);
    btn2BroadCast.setBackground(Color.white);
    btn_ChineseAreaEdit.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btn_ChineseAreaEdit_actionPerformed(e);
      }
    });
    btn_ChineseAreaEdit.setText(" 6.  Areas Maintain");
    btn_ChineseAreaEdit.setHorizontalAlignment(SwingConstants.LEFT);
    btn_ChineseAreaEdit.setBorder(BorderFactory.createRaisedBevelBorder());
    btn_ChineseAreaEdit.setFont(new java.awt.Font("Dialog", 0, 12));
    btn_ChineseAreaEdit.setBounds(new Rectangle(154, 362, 187, 23));
    btn_ChineseAreaEdit.setBackground(Color.white);
    btnFinalEndRemark.setBackground(Color.white);
    btnFinalEndRemark.setBounds(new Rectangle(411, 171, 187, 23));
    btnFinalEndRemark.setFont(new java.awt.Font("Dialog", 0, 12));
    btnFinalEndRemark.setBorder(BorderFactory.createRaisedBevelBorder());
    btnFinalEndRemark.setHorizontalAlignment(SwingConstants.LEFT);
    btnFinalEndRemark.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnFinalEndRemark_actionPerformed(e);
      }
    });
    btnFinalEndRemark.setText(" 7. Final Page Remark");
    btnVenderInfor.setText(" 8. Vendor Bank Maintain");
    btnVenderInfor.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnVenderInfor_actionPerformed(e);
      }
    });
    btnVenderInfor.setHorizontalAlignment(SwingConstants.LEFT);
    btnVenderInfor.setBorder(BorderFactory.createRaisedBevelBorder());
    btnVenderInfor.setFont(new java.awt.Font("Dialog", 0, 12));
    btnVenderInfor.setBounds(new Rectangle(411, 210, 187, 23));
    btnVenderInfor.setBackground(Color.white);
    btnOffshoreRule.setBackground(Color.white);
    btnOffshoreRule.setBounds(new Rectangle(411, 248, 187, 23));
    btnOffshoreRule.setFont(new java.awt.Font("Dialog", 0, 12));
    btnOffshoreRule.setBorder(BorderFactory.createRaisedBevelBorder());
    btnOffshoreRule.setHorizontalAlignment(SwingConstants.LEFT);
    btnOffshoreRule.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnOffshoreRule_actionPerformed(e);
      }
    });
    btnOffshoreRule.setText("9. OffShore Rule Minatain");
    this.add(textAreaStatus, null);
    this.add(labelTitle, null);
    this.add(jLabel1, null);
    this.add(butnExit, null);
    this.add(butnLogout, null);
    this.add(butn_Div, null);
    this.add(butn_BuyerMaker, null);
    this.add(butn_Shapmark, null);
    this.add(butn_Packing, null);
    this.add(butn_SystemValue, null);
    this.add(btn_ChineseAreaEdit, null);

    //this.add(btn2BroadCast, null);

    this.add(btnFinalEndRemark, null);
    this.add(btnVenderInfor, null);

    if((util.PublicVariable.USER_RECORD.get(4).equals("001") &&
      util.PublicVariable.USER_RECORD.getInt(2)==2)||
      newtimes.shipping_admin.ShippingAdmin_Const.isUserEric()){
     this.add(btnOffshoreRule, null);
   }

    if(util.PublicVariable.USER_RECORD.getInt("USR_TYPE")==
      newtimesejb.preproduction.PreProductionHead.USER_TYPE_SUPERVIOSER_MIS&&
      util.PublicVariable.USER_RECORD.get(0).equals("JOHN")){
       this.add(btn2BroadCast, null);
    }

  }

  void butnExit_actionPerformed(ActionEvent e) {
    setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
    frame.showPanel(new MainFunction(frame));
    setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
  }

  void butnLogout_actionPerformed(ActionEvent e) {
    setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
    frame.showPanel(new Login(frame));
    setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
  }

  void butn_Div_actionPerformed(ActionEvent e) {
    try {
      setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
      usrType = util.PublicVariable.USER_RECORD.get("USR_TYPE").toString();
      if (usrType.equals("1") || usrType.equals("2") ||
          usrType.equals("3") || usrType.equals("4")) {
        frame.showPanel(new newtimes.basic.division.DivisionList(frame));
      } else {
        exgui2.InfoMessage.warningMessage(frame,"You Have No Authorizations.");
      }
    } catch (Exception eBsc) {
      eBsc.printStackTrace();
      util.ExceptionLog.exp2File(eBsc,"error at check authorization.\nuser type:"+usrType);
    } finally {
      setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
    }
  }

  void butn_BuyerMaker_actionPerformed(ActionEvent e) {
    try {
      setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
      usrType = util.PublicVariable.USER_RECORD.get("USR_TYPE").toString();
      if (usrType.equals("1") || usrType.equals("2") ||
          usrType.equals("3") || usrType.equals("4")) {
        newtimes.basic.buyermaker.FieldsGuiPanel.hmSelectableCenter=null;
        newtimes.basic.buyermaker.FieldsGuiPanel.pnlCenters=null;
        newtimes.basic.buyermaker.FieldsGuiPanel.chkCbxCenters=null;
        newtimes.basic.buyermaker.BuyerMakerSearch.vSelectCenters=null;
        frame.showPanel(new newtimes.basic.buyermaker.BuyerMakerSearch(frame));
      } else {
        exgui2.InfoMessage.warningMessage(frame,"You Have No Authorizations.");
      }
    } catch (Exception eBsc) {
      eBsc.printStackTrace();
      util.ExceptionLog.exp2File(eBsc,"error at check authorization.\nuser type:"+usrType);
    } finally {
      setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
    }
  }

  void butn_Shapmark_actionPerformed(ActionEvent e) {
    try {
      setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
      usrType = util.PublicVariable.USER_RECORD.get("USR_TYPE").toString();
      if (usrType.equals("1") || usrType.equals("2") ||
          usrType.equals("3") || usrType.equals("4")) {
        frame.showPanel(new newtimes.basic.shipmark.ShipmarkSearch(frame));
      } else {
        exgui2.InfoMessage.warningMessage(frame,"You Have No Authorizations.");
      }
    } catch (Exception eBsc) {
      eBsc.printStackTrace();
      util.ExceptionLog.exp2File(eBsc,"error at check authorization.\nuser type:"+usrType);
    } finally {
      setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
    }
  }

  void butn_SystemValue_actionPerformed(ActionEvent e) {
    try {
      setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
      usrType = util.PublicVariable.USER_RECORD.get("USR_TYPE").toString();
      if (usrType.equals("2")) {
        frame.showPanel(new newtimes.basic.systemvalue.SysValueQuery(frame));
      } else {
        exgui2.InfoMessage.warningMessage(frame,"You Have No Authorizations.");
      }
    } catch (Exception eBsc) {
      eBsc.printStackTrace();
      util.ExceptionLog.exp2File(eBsc,"error at check authorization.\nuser type:"+usrType);
    } finally {
      setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
    }

  }
  void butn_Packing_actionPerformed(ActionEvent e) {
    try {
      setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
      usrType = util.PublicVariable.USER_RECORD.get("USR_TYPE").toString();
      if (usrType.equals("1") || usrType.equals("2") ||
          usrType.equals("3") || usrType.equals("4")) {
        newtimes.basic.shipmark.PnlQryPacking.me =null;
        frame.showPanel(new newtimes.basic.shipmark.PnlQryPacking());
      } else {
        exgui2.InfoMessage.warningMessage(frame,"You Have No Authorizations.");
      }
    } catch (Exception eBsc) {
      eBsc.printStackTrace();
      util.ExceptionLog.exp2File(eBsc,"error at check authorization.\nuser type:"+usrType);
    } finally {
      setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
    }

  }
  protected  String getMessageToSend(){
    JLabel lblRev=new JLabel("Please Input Message To Send:");
    JTextField txtRev=new JTextField();
    Object[] ob={lblRev,txtRev};
    txtRev.selectAll();
    String value=null;
    int result = JOptionPane.showConfirmDialog(
      util.PublicVariable.APP_FRAME ,
      ob,
      "Please Input Message",
      JOptionPane.OK_CANCEL_OPTION);

    if (result == JOptionPane.OK_OPTION) {
      value=txtRev.getText();
    }
   return value;

 }

  void btn2BroadCast_actionPerformed(ActionEvent e) {
     DlgMessage2Send dlg=new DlgMessage2Send(util.PublicVariable.APP_FRAME,
                                             "Input Message To Broad Cast",true);
     dlg.setSize(new Dimension(400,300));
     exgui.UIHelper.setToScreenCenter(dlg);
     dlg.show();
  }
  void btn_ChineseAreaEdit_actionPerformed(ActionEvent e) {
     setCursor(new Cursor(Cursor.WAIT_CURSOR));
     newtimes.basic.area_maintain.PnlListAreas  pnl=new newtimes.basic.area_maintain.PnlListAreas();
     pnl.setPreferredSize(new java.awt.Dimension(700,500));
     javax.swing.JPanel pnl2contain=new javax.swing.JPanel();
     pnl2contain.setLayout(null);
     pnl2contain.add(pnl,null);
     pnl2contain.setBackground(pnl.getBackground());
     frame.showPanel(pnl2contain);
     pnl.firstPage();
     setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
  }
  void btnFinalEndRemark_actionPerformed(ActionEvent e) {
    setCursor(new Cursor(Cursor.WAIT_CURSOR));
    newtimes.basic.totoal_endpage_remark.PnlListTotalEndPageRemarks  pnl=
        new newtimes.basic.totoal_endpage_remark.PnlListTotalEndPageRemarks();
    pnl.setPreferredSize(new java.awt.Dimension(700,500));
    javax.swing.JPanel pnl2contain=new javax.swing.JPanel();
    pnl2contain.setLayout(null);
    pnl2contain.add(pnl,null);
    pnl2contain.setBackground(pnl.getBackground());
    frame.showPanel(pnl2contain);
    pnl.firstPage();
    setCursor(new Cursor(Cursor.DEFAULT_CURSOR));

  }
  void btnVenderInfor_actionPerformed(ActionEvent e) {
     newtimes.basic.vender_infor.ToAXN.pnlQry=null;
     newtimes.basic.vender_infor.ToAXN.ShowQryGUI();
  }
  void btnOffshoreRule_actionPerformed(ActionEvent e) {
       newtimes.basic.offshore_rule.ToDoAxn.pnlQry=null;
        newtimes.basic.offshore_rule.ToDoAxn.ShowQryGUI();
  }
}
