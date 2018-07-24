package newtimes.tpe_user_report;

import java.awt.*;
import exgui.*;
import javax.swing.*;
import java.awt.event.*;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class PnlTpeUsrRptFun extends JPanel {
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel1 = new BlueBkgWhiteCharLabel();
  JButton btnExit = new JButton();
  JButton btnAshCallSummary = new JButton();
  JButton btnOrderAllcChart4Ashworth = new JButton();
  JButton btnAshworthMkrRmk = new JButton();
  JButton btnAshworthFabricChart = new JButton();
  JButton btnKomarOSR = new JButton();
  JButton btnRptMmExp = new JButton();
  JButton btnRptWss44KomarChdg = new JButton();
  JButton btnRptKomarOrdeerSummary = new JButton();
  String dep;
  String u_type;
  JButton btnRptMaxell = new JButton();
  JButton btnRptJcpWip = new JButton();
  public PnlTpeUsrRptFun(String dep,String u_type) {
    this.dep=dep;
    this.u_type=u_type;
    try {
      jbInit();
      setOption();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }

  void jbInit() throws Exception {
    blueBkgWhiteCharLabel1.setText("TAIPEI USER REPORTS");
    blueBkgWhiteCharLabel1.setBounds(new Rectangle(0, 30, 800, 29));
    this.setBackground(new Color(202, 202, 224));
    this.setLayout(null);
    btnExit.setBounds(new Rectangle(350, 529, 102, 26));
    btnExit.setFont(new java.awt.Font("Dialog", 1, 11));
    btnExit.setText("EXIT");
    btnExit.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnExit_actionPerformed(e);
      }
    });
    btnAshCallSummary.setBackground(Color.white);
    btnAshCallSummary.setBounds(new Rectangle(175, 64, 449, 29));
    btnAshCallSummary.setFont(new java.awt.Font("Dialog", 1, 11));
    btnAshCallSummary.setText("ASHWORTH & CALLAWAY ORDER SUMMARY");
    btnAshCallSummary.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnAshCallSummary_actionPerformed(e);
      }
    });
    btnOrderAllcChart4Ashworth.setText("ORDER ALLOCATE CHART FOR ASHWORTH");
    btnOrderAllcChart4Ashworth.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnOrderAllcChart4Ashworth_actionPerformed(e);
      }
    });
    btnOrderAllcChart4Ashworth.setFont(new java.awt.Font("Dialog", 1, 11));
    btnOrderAllcChart4Ashworth.setBounds(new Rectangle(175, 105, 449, 29));
    btnOrderAllcChart4Ashworth.setBackground(Color.white);
    btnAshworthMkrRmk.setBackground(Color.white);
    btnAshworthMkrRmk.setBounds(new Rectangle(175, 187, 449, 29));
    btnAshworthMkrRmk.setFont(new java.awt.Font("Dialog", 1, 11));
    btnAshworthMkrRmk.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnAshworthMkrRmk_actionPerformed(e);
      }
    });
    btnAshworthMkrRmk.setText("ASHWORTH MAKER REMARK MAINTENANCE");
    btnAshworthFabricChart.setBackground(Color.white);
    btnAshworthFabricChart.setBounds(new Rectangle(175, 146, 449, 29));
    btnAshworthFabricChart.setFont(new java.awt.Font("Dialog", 1, 11));
    btnAshworthFabricChart.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnAshworthFabricChart_actionPerformed(e);
      }
    });
    btnAshworthFabricChart.setText("ASHWORTH FABRIC CHART");
    btnKomarOSR.setText("KOMAR O.S.R");
    btnKomarOSR.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnKomarOSR_actionPerformed(e);
      }
    });
    btnKomarOSR.setFont(new java.awt.Font("Dialog", 1, 11));
    btnKomarOSR.setBounds(new Rectangle(175, 228, 449, 29));
    btnKomarOSR.setBackground(Color.white);
    btnRptMmExp.setBackground(Color.white);
    btnRptMmExp.setBounds(new Rectangle(175, 269, 449, 29));
    btnRptMmExp.setFont(new java.awt.Font("Dialog", 1, 11));
    btnRptMmExp.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnRptMmExp_actionPerformed(e);
      }
    });
    btnRptMmExp.setText("COLOR SIZE DETAIL");
    btnRptWss44KomarChdg.setText("WSS FOR KOMAR / CHDG");
    btnRptWss44KomarChdg.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnRptWss44KomarChdg_actionPerformed(e);
      }
    });
    btnRptWss44KomarChdg.setFont(new java.awt.Font("Dialog", 1, 11));
    btnRptWss44KomarChdg.setBounds(new Rectangle(175, 310, 449, 29));
    btnRptWss44KomarChdg.setBackground(Color.white);
    btnRptKomarOrdeerSummary.setBackground(Color.white);
    btnRptKomarOrdeerSummary.setBounds(new Rectangle(175, 351, 449, 29));
    btnRptKomarOrdeerSummary.setFont(new java.awt.Font("Dialog", 1, 11));
    btnRptKomarOrdeerSummary.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnRptKomarOrdeerSummary_actionPerformed(e);
      }
    });
    btnRptKomarOrdeerSummary.setText("KOMAR ORDER SUMMARY");
    btnRptMaxell.setText("MAXELL PENDING/SHIPMENT LIST");
    btnRptMaxell.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnRptMaxell_actionPerformed(e);
      }
    });
    btnRptMaxell.setFont(new java.awt.Font("Dialog", 1, 11));
    btnRptMaxell.setToolTipText("");
    btnRptMaxell.setActionCommand("KOMAR ORDER SUMMARY");
    btnRptMaxell.setBounds(new Rectangle(176, 394, 449, 29));
    btnRptMaxell.setBackground(Color.white);
    btnRptJcpWip.setText("KOMAR JCP WIP");
    btnRptJcpWip.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnRptJcpWip_actionPerformed(e);
      }
    });
    btnRptJcpWip.setFont(new java.awt.Font("Dialog", 1, 11));
    btnRptJcpWip.setToolTipText("");
    btnRptJcpWip.setBounds(new Rectangle(180, 443, 449, 29));
    btnRptJcpWip.setBackground(Color.white);
    this.add(blueBkgWhiteCharLabel1, null);
    this.add(btnExit, null);
    this.add(btnKomarOSR, null);
    this.add(btnAshCallSummary, null);
    this.add(btnOrderAllcChart4Ashworth, null);
    this.add(btnAshworthFabricChart, null);
    this.add(btnAshworthMkrRmk, null);
    this.add(btnRptMmExp, null);
    this.add(btnRptWss44KomarChdg, null);
    this.add(btnRptKomarOrdeerSummary, null);
    this.add(btnRptMaxell, null);
    this.add(btnRptJcpWip, null);
  }

  void btnExit_actionPerformed(ActionEvent e) {
    JPanel panel = new newtimes.MainFunction((newtimes.Frame1)util.PublicVariable.APP_FRAME);
    this.removeAll();
    this.add(panel, null);
    panel.setBounds(0, 0, 800, 600);
    panel.repaint();
    panel.validate();
  }

  void btnAshCallSummary_actionPerformed(ActionEvent e) {
    try {
      processhandler.template.Properties.getCenteralControler().doCommandExecute(
          new newtimes.tpe_user_report.TgrAshCallSummary()
          );
    } catch (Exception eP) {
      eP.printStackTrace();
    }

  }

  void btnOrderAllcChart4Ashworth_actionPerformed(ActionEvent e) {
    try {
      processhandler.template.Properties.getCenteralControler().doCommandExecute(
          new newtimes.tpe_user_report.TgrOdrAllocChart4Ashworth()
          );
    } catch (Exception eP) {
      eP.printStackTrace();
    }
  }
  void btnAshworthMkrRmk_actionPerformed(ActionEvent e) {
    try {
      newtimes.basic.ashworth_unit.TgrAshMkrFunc.pnl=null;
      processhandler.template.Properties.getCenteralControler().doCommandExecute(
          new newtimes.basic.ashworth_unit.TgrAshMkrFunc());
    } catch (Exception eP) {
      eP.printStackTrace();
    }
  }
  void btnAshworthFabricChart_actionPerformed(ActionEvent e) {
    try {
      processhandler.template.Properties.getCenteralControler().doCommandExecute(
          new newtimes.tpe_user_report.TgrAshwothFabricChart()
          );
    } catch (Exception eP) {
      eP.printStackTrace();
    }

  }
  void btnKomarOSR_actionPerformed(ActionEvent e) {
    try {
      processhandler.template.Properties.getCenteralControler().doCommandExecute(
          new newtimes.tpe_user_report.TgrKomarOSR()
          );
    } catch (Exception eP) {
      eP.printStackTrace();
    }

  }
  void btnRptMmExp_actionPerformed(ActionEvent e) {
    try {
      processhandler.template.Properties.getCenteralControler().doCommandExecute(
          new newtimes.tpe_user_report.TgrPnlRptMmExp()
          );
    } catch (Exception eP) {
      eP.printStackTrace();
    }

  }
  void btnRptWss44KomarChdg_actionPerformed(ActionEvent e) {
    try {
      processhandler.template.Properties.getCenteralControler().doCommandExecute(
          new newtimes.tpe_user_report.TgrRptWss4KomarChdg()
          );
    } catch (Exception eP) {
      eP.printStackTrace();
    }

  }
  void btnRptKomarOrdeerSummary_actionPerformed(ActionEvent e) {
    try {
      processhandler.template.Properties.getCenteralControler().doCommandExecute(
          new newtimes.tpe_user_report.TgrKormarOrderSummary()
          );
    } catch (Exception eP) {
      eP.printStackTrace();
    }

  }
  void setOption()
  {
    if ( u_type.equals("5"))
    {
        if (!dep.equals("TPM01"))
        {
            btnKomarOSR.setEnabled(false);
            btnRptMmExp.setEnabled(false);
            btnRptWss44KomarChdg.setEnabled(false);
            btnRptKomarOrdeerSummary.setEnabled(false);
        }
        if (!dep.equals("TPQ01"))
      {
          btnRptMaxell.setEnabled(false);

      }

    }
  }
  void btnRptMaxell_actionPerformed(ActionEvent e) {
    try {
         processhandler.template.Properties.getCenteralControler().doCommandExecute(
             new newtimes.tpe_user_report.TgrMaxellPS()
         );
    } catch (Exception eP) {
     eP.printStackTrace();
      }

  }
  void btnRptJcpWip_actionPerformed(ActionEvent e) {
    try {
        processhandler.template.Properties.getCenteralControler().doCommandExecute(
        new newtimes.tpe_user_report.TgrPnlRptJcpWip()
        );
        } catch (Exception eP) {
           eP.printStackTrace();
         }

           }
}
