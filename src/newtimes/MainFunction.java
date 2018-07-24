package newtimes;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.border.*;
import processhandler.template.*;
import processhandler.*;
import newtimes.preproduction.process.*;
import exgui2.*;
import  newtimes.shipping_admin.process.packing.*;
import  newtimes.shipping_admin.guis.packing.*;
/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author unascribed
 * @version 1.0
 */

public class MainFunction extends JPanel {
  Frame1 frame;
  private JLabel labelTitle = new JLabel();
  private JLabel jLabel1 = new JLabel();
  private JTextField textAreaStatus = new JTextField();
  private JButton butnExit = new JButton();
  private JButton butnLogout = new JButton();
  private JButton butn_Basic = new JButton();
  private JButton butn_Material = new JButton();
  private JButton butn_Preporduction = new JButton();
  private JButton butn_Shipping = new JButton();
  private String usrType = null;
  private String usrDep = null;
  private JButton butn_Report1 = new JButton();
  private JButton butn_Report2 = new JButton();
  private JButton butn_Misc = new JButton();
  static boolean isCommandSetLoad = false;

//from PreProductionApp.java by john============================================
  SplitFrame spframe = new SplitFrame();
  CommandFactoryImp cmxFxy = new newtimes.preproduction.process.CmdFtyImp();
  CenteralControlerImp ctnCtl = new newtimes.preproduction.process.CtnCtlImp();
  Constants xtnts = new newtimes.preproduction.Constants();
  static newtimesejb.preproduction.PreProductionHead prdHead;
  JButton butn_Report3 = new JButton();
  JButton btnShippingAdmin = new JButton();
  JButton btn_AccountingFunctions = new JButton();
  JButton btn_Summary = new JButton();
  JButton butn_MisUtil = new JButton();
  JButton btn_ShippingDepReport = new JButton();
  JButton btnNTHK_report = new JButton();
  JButton btnNTFE_report1 = new JButton();
  JButton btnTpeUserReport = new JButton();
  JButton btnOther = new JButton();
//==============================================================================

  public MainFunction(Frame1 _frame) {
    frame = _frame;
    util.PublicVariable.OPERATTING_CENTER=(String)util.PublicVariable.USER_RECORD.get(4);
    try {
      jbInit();
      usrType = util.PublicVariable.USER_RECORD.get("USR_TYPE").toString();
      usrDep = util.PublicVariable.USER_RECORD.get("USR_DEP_CODE").toString();
      newtimes.Per.user_Dep=usrDep;
      newtimes.Per.user_Type=usrType;
      setOption();
    } catch (Exception ex) {
      ex.printStackTrace();
    }
  }

  void jbInit() throws Exception {
    labelTitle.setText("title");
    labelTitle.setBounds(new Rectangle(0, 0, 800, 50));
    labelTitle.setIcon(exgui.UIHelper.getIcon("title04.jpg"));
    this.setLayout(null);
    this.setSize(800, 600);
    this.setBackground(new Color(204, 204, 225));
    labelTitle.setBounds(new Rectangle(0, 0, 800, 50));
    jLabel1.setFont(new java.awt.Font("Dialog", 1, 13));
    jLabel1.setForeground(new Color(10, 36, 106));
    jLabel1.setBorder(BorderFactory.createEtchedBorder());
    jLabel1.setHorizontalAlignment(SwingConstants.CENTER);
    jLabel1.setText("      ============  Main Function  ============      ");
    jLabel1.setBounds(new Rectangle(116, 59, 566, 24));
    textAreaStatus.setBackground(new Color(143, 143, 188));
    textAreaStatus.setBorder(null);
    textAreaStatus.setEditable(false);
    textAreaStatus.setBounds(new Rectangle(-2, 548, 805, 30));
    butnExit.setBackground(Color.lightGray);
    butnExit.setBounds(new Rectangle(426, 522, 80, 25));
    butnExit.setFont(new java.awt.Font("Dialog", 1, 13));
    butnExit.setForeground(Color.darkGray);
    butnExit.setText("Exit");
    butnExit.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        butnExit_actionPerformed(e);
      }
    });
    butnLogout.setBackground(Color.lightGray);
    butnLogout.setBounds(new Rectangle(284, 522, 80, 25));
    butnLogout.setFont(new java.awt.Font("Dialog", 1, 13));
    butnLogout.setForeground(Color.darkGray);
    butnLogout.setText("Logout");
    butnLogout.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        butnLogout_actionPerformed(e);
      }
    });
    butn_Basic.setBackground(Color.white);
    butn_Basic.setBounds(new Rectangle(209, 106, 378, 23));
    butn_Basic.setFont(new java.awt.Font("Dialog", 0, 12));
    butn_Basic.setBorder(BorderFactory.createRaisedBevelBorder());
    butn_Basic.setHorizontalAlignment(SwingConstants.LEFT);
    butn_Basic.setText("   Basic - I");
    butn_Basic.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        butn_Basic_actionPerformed(e);
      }
    });

    butn_Material.setBackground(Color.white);
    butn_Material.setBounds(new Rectangle(209, 174, 378, 23));
    butn_Material.setFont(new java.awt.Font("Dialog", 0, 12));
    butn_Material.setBorder(BorderFactory.createRaisedBevelBorder());
    butn_Material.setHorizontalAlignment(SwingConstants.LEFT);
    butn_Material.setText("   Material");
    butn_Material.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        butn_Material_actionPerformed(e);
      }
    });



    butn_Preporduction.setBackground(Color.white);
    butn_Preporduction.setBounds(new Rectangle(209, 209, 378, 23));
    butn_Preporduction.setFont(new java.awt.Font("Dialog", 0, 12));
    butn_Preporduction.setBorder(BorderFactory.createRaisedBevelBorder());
    butn_Preporduction.setHorizontalAlignment(SwingConstants.LEFT);
    butn_Preporduction.setText("   Production");
    butn_Preporduction.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        butn_Preporduction_actionPerformed(e);
      }
    });


    butn_Shipping.setBackground(Color.white);
    butn_Shipping.setBounds(new Rectangle(209, 243, 378, 23));
    butn_Shipping.setFont(new java.awt.Font("Dialog", 0, 12));
    butn_Shipping.setBorder(BorderFactory.createRaisedBevelBorder());
    butn_Shipping.setHorizontalAlignment(SwingConstants.LEFT);
    butn_Shipping.setText("   Shipping");
    butn_Shipping.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        butn_Shipping_actionPerformed(e);
      }
    });


    butn_Report1.setText(" 6.  Report - I");
    butn_Report1.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        butn_Report1_actionPerformed(e);
      }
    });



    butn_Report1.setHorizontalAlignment(SwingConstants.LEFT);
    butn_Report1.setBorder(BorderFactory.createRaisedBevelBorder());
    butn_Report1.setFont(new java.awt.Font("Dialog", 0, 12));
    butn_Report1.setBounds(new Rectangle(211, 366, 378, 23));
    butn_Report1.setBackground(Color.white);
    butn_Report2.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        butn_Report2_actionPerformed(e);
      }
    });
    butn_Report2.setText(" 7.  Report - II");
    butn_Report2.setHorizontalAlignment(SwingConstants.LEFT);
    butn_Report2.setBorder(BorderFactory.createRaisedBevelBorder());
    butn_Report2.setFont(new java.awt.Font("Dialog", 0, 12));
    butn_Report2.setBounds(new Rectangle(211, 397, 378, 23));
    butn_Report2.setBackground(Color.white);
    butn_Misc.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        butn_Misc_actionPerformed(e);
      }
    });


    butn_Misc.setText("   Basic - II");
    butn_Misc.setHorizontalAlignment(SwingConstants.LEFT);
    butn_Misc.setBorder(BorderFactory.createRaisedBevelBorder());
    butn_Misc.setFont(new java.awt.Font("Dialog", 0, 12));
    butn_Misc.setBounds(new Rectangle(209, 140, 378, 23));
    butn_Misc.setBackground(Color.white);



    butn_Report3.setBackground(Color.white);
    butn_Report3.setBounds(new Rectangle(209, 277, 378, 23));
    butn_Report3.setFont(new java.awt.Font("Dialog", 0, 12));
    butn_Report3.setBorder(BorderFactory.createRaisedBevelBorder());
    butn_Report3.setHorizontalAlignment(SwingConstants.LEFT);
    butn_Report3.setText("   Detail Report");
    butn_Report3.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        butn_Report3_actionPerformed(e);
      }
    });

    btnShippingAdmin.setBackground(Color.white);
    btnShippingAdmin.setBounds(new Rectangle(212, 424, 378, 23));
    btnShippingAdmin.setText("Shipping Admin");
    btnShippingAdmin.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnShippingAdmin_actionPerformed(e);
      }
    });

    btn_AccountingFunctions.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btn_AccountingFunctions_actionPerformed(e);
      }
    });
    btn_AccountingFunctions.setText("   Accounting Department Report");
    btn_AccountingFunctions.setHorizontalAlignment(SwingConstants.LEFT);
    btn_AccountingFunctions.setBorder(BorderFactory.createRaisedBevelBorder());
    btn_AccountingFunctions.setFont(new java.awt.Font("Dialog", 0, 12));
    btn_AccountingFunctions.setBounds(new Rectangle(209, 380, 378, 23));
    btn_AccountingFunctions.setBackground(Color.white);

    btn_Summary.setBackground(Color.white);
    btn_Summary.setBounds(new Rectangle(209, 311, 378, 23));
    btn_Summary.setFont(new java.awt.Font("Dialog", 0, 12));
    btn_Summary.setBorder(BorderFactory.createRaisedBevelBorder());
    btn_Summary.setHorizontalAlignment(SwingConstants.LEFT);
    btn_Summary.setText("   Summary Report");
    btn_Summary.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btn_Summary_actionPerformed(e);
      }
    });


    butn_MisUtil.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        butn_MisUtil_actionPerformed(e);
      }
    });
    butn_MisUtil.setText("   MIS Utility");
    butn_MisUtil.setHorizontalAlignment(SwingConstants.LEFT);
    butn_MisUtil.setBorder(BorderFactory.createRaisedBevelBorder());
    butn_MisUtil.setFont(new java.awt.Font("Dialog", 0, 12));
    butn_MisUtil.setBounds(new Rectangle(210, 414, 378, 23));
    butn_MisUtil.setBackground(Color.white);


    btn_ShippingDepReport.setBackground(Color.white);
    btn_ShippingDepReport.setBounds(new Rectangle(209, 346, 378, 23));
    btn_ShippingDepReport.setFont(new java.awt.Font("Dialog", 0, 12));
    btn_ShippingDepReport.setBorder(BorderFactory.createRaisedBevelBorder());
    btn_ShippingDepReport.setHorizontalAlignment(SwingConstants.LEFT);
    btn_ShippingDepReport.setText("   Shipping Department Report");
    btn_ShippingDepReport.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btn_ShippingDepReport_actionPerformed(e);
      }
    });


    btnNTHK_report.setBackground(Color.white);
    btnNTHK_report.setBounds(new Rectangle(209, 447, 171, 23));
    btnNTHK_report.setFont(new java.awt.Font("Dialog", 1, 11));
    btnNTHK_report.setHorizontalAlignment(SwingConstants.LEFT);
    btnNTHK_report.setText("NTHK REPORTS");
    btnNTHK_report.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnNTHK_report_actionPerformed(e);
      }
    });
    btnNTFE_report1.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnNTFE_report1_actionPerformed(e);
      }
    });
    btnNTFE_report1.setText("NTFE REPORTS");
    btnNTFE_report1.setHorizontalAlignment(SwingConstants.LEFT);
    btnNTFE_report1.setBounds(new Rectangle(416, 447, 171, 23));
    btnNTFE_report1.setFont(new java.awt.Font("Dialog", 1, 11));
    btnNTFE_report1.setBackground(Color.white);
    btnTpeUserReport.setBackground(Color.white);
    // with MIS btnTpeUserReport.setBounds(new Rectangle(210, 447, 378, 27));
    btnTpeUserReport.setBounds(new Rectangle(209, 384, 378, 27));

    btnTpeUserReport.setText("Taipei User Reports");
    btnTpeUserReport.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnTpeUserReport_actionPerformed(e);
      }
    });
    btnOther.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnOther_actionPerformed(e);
      }
    });
    btnOther.setText("      OTHER");
    btnOther.setHorizontalAlignment(SwingConstants.LEFT);
    btnOther.setBorder(BorderFactory.createRaisedBevelBorder());
    btnOther.setFont(new java.awt.Font("Dialog", 0, 12));
    btnOther.setBounds(new Rectangle(209, 495, 378, 23));
    btnOther.setBackground(Color.white);


    this.add(labelTitle, null);
    this.add(btnShippingAdmin, null);

    //for accounting unit,only accounting & mis user allow to use it
    if(util.PublicVariable.OPERATTING_CENTER.equals("001")){
      int userType=util.PublicVariable.USER_RECORD.getInt("USR_TYPE");
      if(userType==newtimesejb.preproduction.PreProductionHead.USER_TYPE_SUPERVIOSER_MIS ||
         userType==newtimesejb.preproduction.PreProductionHead.USER_TYPE_ACCOUNTING_USERS){
         this.add(btn_AccountingFunctions, null);
      }
    }else{
       this.add(btn_AccountingFunctions, null);
    }
    this.add(jLabel1, null);
    this.add(butn_Basic, null);
    this.add(butn_Misc, null);
    this.add(butn_Material, null);
    this.add(butn_Preporduction, null);
    this.add(butn_Shipping, null);
    this.add(butn_Report3, null);
    this.add(btn_Summary, null);
    this.add(btn_ShippingDepReport, null);


    //this.add(butn_MisUtil, null);
    String userId=util.PublicVariable.USER_RECORD.get(0).toString();


    if(userId.equals("NTERIC")||
       userId.equals("DENNIS")||
       (userId.length()>=10 &&
        userId.substring(userId.length()-10,userId.length()).equals("ANTHONYLIU"))){
      this.add(btnNTHK_report, null);
      this.add(btnNTFE_report1, null);
    }

    //this.add(btnNTHK_report, null);


    if(util.PublicVariable.USER_RECORD.getInt("USR_TYPE")==newtimesejb.preproduction.PreProductionHead.USER_TYPE_SUPERVIOSER_MIS||
      util.PublicVariable.USER_RECORD.getInt("USR_TYPE")==newtimesejb.preproduction.PreProductionHead.USER_TYPE_ACCOUNTING_USERS)
    {
      btnTpeUserReport.setBounds(new Rectangle(210, 447, 378, 27));
       //only MIS user are able to use broad casting function
       if(util.PublicVariable.USER_RECORD.getInt("USR_TYPE")==
          newtimesejb.preproduction.PreProductionHead.USER_TYPE_SUPERVIOSER_MIS){
           this.add(butn_MisUtil, null);
       }
       this.add(btn_AccountingFunctions, null);
    }

    if(util.PublicVariable.OPERATTING_CENTER.equals("001")){
       this.add(btnTpeUserReport, null);
    }
    if((util.PublicVariable.OPERATTING_CENTER.equals("001") &&
        util.PublicVariable.USER_RECORD.getInt("USR_TYPE")==newtimesejb.preproduction.PreProductionHead.USER_TYPE_SUPERVIOSER_MIS)||
        "ARTHUR LIN".equals(util.PublicVariable.USER_RECORD.get("USR_CODE")))
    {

      this.add(btnOther, null);
    }
    this.add(butnLogout, null);
    this.add(butnExit, null);

    this.add(textAreaStatus, null);

    //this.add(butn_Report1, null);
    //this.add(butn_Report2, null);
    //modified by john
    btnShippingAdmin.setVisible(false); //this function need futher fix
    if(util.PublicVariable.USER_RECORD.getInt(2)==newtimesejb.preproduction.PreProductionHead.USER_TYPE_USERS
       &&"NTHK".equals(util.PublicVariable.OPERATTING_CENTER)){
      this.removeAll();
      this.add(labelTitle,null);
      this.add(jLabel1, null);
      //for NTHKs' Basic user,only allow to use production & detail reprot unit
      this.add(butn_Preporduction);
      //for Dep J0,only jerrie is allow to see detail report
      if("J0".equals(util.PublicVariable.USER_RECORD.get("USR_DEP_CODE"))){
        if("JERRIENG".equals(util.PublicVariable.USER_RECORD.get(0))){
          this.add(butn_Report3);
        }
      }else{
        this.add(butn_Report3);
      }
      this.add(butnLogout);
      this.add(butnExit);
    }
    if(util.PublicVariable.USER_RECORD.getInt(2)==newtimesejb.preproduction.PreProductionHead.USER_TYPE_ABROAD_USERS){
      this.removeAll();
      this.add(labelTitle,null);
      this.add(jLabel1, null);
      this.add(butn_Preporduction);
      this.add(butn_Shipping);
      this.add(butnLogout);
      this.add(butnExit);

    }
    setCommandSet();
  }

  void butnExit_actionPerformed(ActionEvent e) {
    int isExit = exgui2.InfoMessage.Yes_No_Option(frame,
        "Do you want to exit this system ?");
    if (isExit == 0) {
      if (newtimes.preproduction.process.AttributeFactory.isAllAccsAttribReady()) {
        if (newtimes.production.report.ReportCmdSet.myReportEngin != null) {
          try {
            newtimes.production.report.ReportCmdSet.myReportEngin.ejb.remove();
            System.out.println("ejb remove called");
          } catch (Exception exp) {
            exp.printStackTrace();
          }
        }
      }
      System.exit(0);
    }
  }

  void butnLogout_actionPerformed(ActionEvent e) {
    setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
    frame.showPanel(new Login(frame));
    setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
  }

  void butn_Basic_actionPerformed(ActionEvent e) {
    try {
      setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
 //     usrType = util.PublicVariable.USER_RECORD.get("USR_TYPE").toString();
      if (usrType.equals("2")) {
        frame.showPanel(new newtimes.basic.BasicMenu(frame));
      } else {
        exgui2.InfoMessage.warningMessage(frame, "You Have No Authorizations.");
      }
    } catch (Exception eBsc) {
      eBsc.printStackTrace();
      util.ExceptionLog.exp2File(eBsc,
                                 "error at check authorization.\nuser type:" +
                                 usrType);
    } finally {
      setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
    }
  }

  public void setCommandSet() {
    if (isCommandSetLoad)return;
    System.out.println("Load Commandsets");
    ClassLoader loader = this.getClass().getClassLoader();
    java.lang.Thread.currentThread().setContextClassLoader(loader);

    Properties.jframe = frame;
    processhandler.template.Properties.jframe = frame;
    util.PublicVariable.APP_FRAME = frame;
    Properties.spFrame = spframe;
    util.PublicVariable.APP_SPLIT_FRAME = spframe;
    //set to system properties
    Properties.cmdFxy = cmxFxy;
    ctnCtl.setBasicFrameWork(spframe);
    ctnCtl.setCommandFactory(cmxFxy);
    ctnCtl.setMainFrame(frame);
    //set centercontroler to system properties.
    Properties.ctnCtl = ctnCtl;

    Properties.getCommandFactory().registerCommand(
        newtimes.preproduction.Constants.CMDSET_PREPRODUCTION_MAINTAIN,
        newtimes.preproduction.Constants.Org_PREPROD_COMMAND_SET
        );

    //regist commandset of productions.
    Properties.getCommandFactory().registerCommand(
        newtimes.production.ProdMaintain_Properties.CMDS_PROD_MAINTAIN,
        newtimes.preproduction.Constants.Org_PRODUCTION_COMMAND_SET
        );
    //regist command of production confirm list
    Properties.getCommandFactory().registerCommand(
        newtimes.production.ProdMaintain_Properties.CMD_SET_PROD_CNFM_LIST,
        new newtimes.production.process.audit_sc_ct.SCCT_CmdSets());
    //regist command of order change functions
    Properties.getCommandFactory().registerCommand(
        newtimes.production.ProdMaintain_Properties.
        CMD_SET_ORDER_CHAGNE_COMMANDS,
        new newtimes.production.process.order_change.CmdSets4OdrChg());

    Properties.getCommandFactory().registerCommand(
        newtimes.shipping_admin.ShippingAdmin_Const.SHIPPING_ADMIN_COMMAND,
        new newtimes.shipping_admin.process.shiippingmaintain.ShippingAdmCmdSet());

    Properties.getCommandFactory().registerCommand(
        newtimes.shipping_admin.ShippingAdmin_Const.SHIPPING_PACKING_COMMAND,
        new newtimes.shipping_admin.process.packing.PackingCommands());


    Properties.getCommandFactory().registerCommand(
        newtimes.accounting.AcctFunsConsts.COMMAND_SET_ID,
        new newtimes.accounting.AccountingCmdSets());

    Properties.getCommandFactory().registerCommand(
        newtimes.production.report.ReportCmdSet.CMMANDSET_CLASS_NAME ,
        new newtimes.production.report.ReportCmdSet());

    isCommandSetLoad = true;
  }

  void butn_Material_actionPerformed(ActionEvent e) {
    setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
    frame.showPanel(new newtimes.material.MaterialMenu(frame));
    setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
  }

  void butn_Preporduction_actionPerformed(ActionEvent e) {
    setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
//code from PreProduction.java by john======================================
    try {
      //Properties.getCenteralControler().setSystemCommander(Constants.CMD_INIT_APP_GUI);
      Properties.getCenteralControler().setSystemCommander(
          newtimes.preproduction.Constants.CMDSET_PREPRODUCTION_MAINTAIN);
      processhandler.template.Properties.getCenteralControler().
          setDataProcesser(null);
      Properties.getCenteralControler().doCommandExecute(new TgrShowFuncList());
    } catch (Exception eP) {
      eP.printStackTrace();
    }
//==========================================================================
    setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
  }

  void butn_Shipping_actionPerformed(ActionEvent e) {
    setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
    frame.showPanel(new newtimes.shipping.ShippingMenu(frame));
    setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
  }

  void butn_Report2_actionPerformed(ActionEvent e) {
    setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
    frame.showPanel(new newtimes.reports.report_2.ReportMenu2(frame));
    setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
  }

  void butn_Report1_actionPerformed(ActionEvent e) {
    setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
    frame.showPanel(new newtimes.reports.ReportMenu1(frame));
    setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
  }

  void butn_Misc_actionPerformed(ActionEvent e) {
    setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
    frame.showPanel(new newtimes.basic.MiscMenu(frame));
    setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
  }

  void butn_Report3_actionPerformed(ActionEvent e) {
    try {
      //Properties.getCenteralControler().setSystemCommander(Constants.CMD_INIT_APP_GUI);
      processhandler.template.Properties.getCenteralControler().setSystemCommander(
             newtimes.production.report.ReportCmdSet.CMMANDSET_CLASS_NAME
            );
      processhandler.template.Properties.getCenteralControler().
          setDataProcesser(null);
      Properties.getCenteralControler().doCommandExecute(
      new newtimes.production.report.TgrToShowReport3FuncList());
    } catch (Exception eP) {
      eP.printStackTrace();
    }
//==========================================================================
    setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
  }

  void btnShippingAdmin_actionPerformed(ActionEvent e) {
      setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
      frame.showPanel(new newtimes.shipping_admin.PnlShippingFunctions(frame));
      setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
  }

  void btn_AccountingFunctions_actionPerformed(ActionEvent e) {
    try {
      //Properties.getCenteralControler().setSystemCommander(Constants.CMD_INIT_APP_GUI);
      processhandler.template.Properties.getCenteralControler().setSystemCommander(
             newtimes.accounting.AcctFunsConsts.COMMAND_SET_ID
            );
      processhandler.template.Properties.getCenteralControler().
          setDataProcesser(null);
      Properties.getCenteralControler().doCommandExecute(
          new newtimes.accounting.TgrToGenAcctFuncsList());

    } catch (Exception eP) {
      eP.printStackTrace();
    }
//==========================================================================
    setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
  }
  void btn_Summary_actionPerformed(ActionEvent e) {
    try {
      //Properties.getCenteralControler().setSystemCommander(Constants.CMD_INIT_APP_GUI);
      processhandler.template.Properties.getCenteralControler().setSystemCommander(
             newtimes.production.report.ReportCmdSet.CMMANDSET_CLASS_NAME
            );
      processhandler.template.Properties.getCenteralControler().
          setDataProcesser(null);
      Properties.getCenteralControler().doCommandExecute(
          new newtimes.production.report.TgrToShowSummaryReportFunList());
    } catch (Exception eP) {
      eP.printStackTrace();
    }
//==========================================================================
    setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
  }
  void butn_MisUtil_actionPerformed(ActionEvent e) {
    try {
      //Properties.getCenteralControler().setSystemCommander(Constants.CMD_INIT_APP_GUI);
      processhandler.template.Properties.getCenteralControler().setSystemCommander(
             newtimes.production.report.ReportCmdSet.CMMANDSET_CLASS_NAME
            );
      processhandler.template.Properties.getCenteralControler().
          setDataProcesser(null);
      Properties.getCenteralControler().doCommandExecute(
          new newtimes.production.report.TgrToGenMisFunList());
    } catch (Exception eP) {
      eP.printStackTrace();
    }
//==========================================================================
    setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
  }
  void btn_ShippingDepReport_actionPerformed(ActionEvent e) {
    try {
      //Properties.getCenteralControler().setSystemCommander(Constants.CMD_INIT_APP_GUI);
      processhandler.template.Properties.getCenteralControler().setSystemCommander(
             newtimes.production.report.ReportCmdSet.CMMANDSET_CLASS_NAME
            );
      processhandler.template.Properties.getCenteralControler().
          setDataProcesser(null);
      Properties.getCenteralControler().doCommandExecute(
          new newtimes.production.report.TgrToShowShipReportFunList());
    } catch (Exception eP) {
      eP.printStackTrace();
    }
//==========================================================================
    setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));

  }


  void btnNTHK_report_actionPerformed(ActionEvent e) {
    try {
      Properties.getCenteralControler().doCommandExecute(
          new newtimes.nthk_report.TgrFuncList());
    } catch (Exception eP) {
      eP.printStackTrace();
    }
//==========================================================================
    setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));

  }
  void btnNTFE_report1_actionPerformed(ActionEvent e) {
    try {
      Properties.getCenteralControler().doCommandExecute(
          new newtimes.nthk_report.TgrNtfeFuncList());
    } catch (Exception eP) {
      eP.printStackTrace();
    }
//==========================================================================
    setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));

  }

  void btnTpeUserReport_actionPerformed(ActionEvent e) {
    try {
      processhandler.template.Properties.getCenteralControler().setSystemCommander(
             newtimes.accounting.AcctFunsConsts.COMMAND_SET_ID
            );
      processhandler.template.Properties.getCenteralControler().
          setDataProcesser(null);
      Properties.getCenteralControler().doCommandExecute(
          new newtimes.tpe_user_report.TgrTpeUsrReportFunc(usrDep,usrType));
    } catch (Exception eP) {
      eP.printStackTrace();
    }
//==========================================================================
    setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));

  }
  void btnOther_actionPerformed(ActionEvent e) {
    try {
      processhandler.template.Properties.getCenteralControler().setSystemCommander(
             newtimes.accounting.AcctFunsConsts.COMMAND_SET_ID
            );
      processhandler.template.Properties.getCenteralControler().
          setDataProcesser(null);
      Properties.getCenteralControler().doCommandExecute(
          new newtimes.fty_exam.TgrOtherFuncList());
    } catch (Exception eP) {
      eP.printStackTrace();
    }
//==========================================================================
    setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));

  }
  void setOption()
  {
    if ( !usrType.equals("2") ) {  butn_Basic.setEnabled(false); }
   if ( !usrType.equals("2") ) {  butn_Material.setEnabled(false);}
//   if ( !usrType.equals("2") && !usrType.equals("9") && !usrType.equals("5") && !usrType.equals("8")) { butn_Preporduction.setEnabled(false); }
   if ( !usrType.equals("2") && !usrType.equals("8") && !usrType.equals("9") ) { butn_Shipping.setEnabled(false);}
   if ( !usrType.equals("2") && !usrType.equals("9")) { butn_Report1.setEnabled(false);}
   if ( !usrType.equals("2") && !usrType.equals("9")) { butn_Report2.setEnabled(false);}
   if ( !usrType.equals("2") ) { butn_Misc.setEnabled(false);}
   if ( !usrType.equals("2") && !usrType.equals("9") && !usrDep.equals("TPJ09")) { butn_Report3.setEnabled(false);}
   if ( !usrType.equals("2") && !usrType.equals("8") ) { btnShippingAdmin.setEnabled(false);}

   if ( !usrType.equals("2") && !usrType.equals("9") ) { btn_AccountingFunctions.setEnabled(false);}
   if ( usrDep.equals("TPC01")  ) { btn_AccountingFunctions.setEnabled(false);}

   if ( !usrType.equals("2") && !usrType.equals("9") ) { btn_Summary.setEnabled(false);}
   if ( !usrType.equals("2") && !usrType.equals("9") ) { butn_MisUtil.setEnabled(false);}
   if ( !usrType.equals("2") && !usrType.equals("8") && !usrType.equals("9") ) {btn_ShippingDepReport.setEnabled(false);}
   if ( !usrType.equals("2") && !usrType.equals("9") && !usrType.equals("5") ) {btnTpeUserReport.setEnabled(false);}
   if ( !usrType.equals("2") && !usrType.equals("9") ) { btnOther.setEnabled(false);}

  }

}
