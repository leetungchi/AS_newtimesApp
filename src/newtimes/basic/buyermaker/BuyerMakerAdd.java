package newtimes.basic.buyermaker;

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

public class BuyerMakerAdd extends JPanel {
  Frame1 frame;
  private JTextField textAreaStatus = new JTextField();
  private JLabel jLabel1 = new JLabel();
  private ButtonGroup buttonGroup1 = new ButtonGroup();
  private JButton butnExit = new JButton();
  private JButton butnAdd = new JButton();
  private JScrollPane jScrollPane1 = new JScrollPane();
  private newtimes.basic.buyermaker.FieldsGuiPanel fieldsGuiPanel =
      new newtimes.basic.buyermaker.FieldsGuiPanel(frame);

  public BuyerMakerAdd(Frame1 _frame) {
    frame = _frame;
    try {
      jbInit();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }
  void jbInit() throws Exception {
    jLabel1.setBounds(new Rectangle(117, 26, 566, 24));
    jLabel1.setText("      ============  Buyer - Maker Add  ============      ");
    jLabel1.setHorizontalAlignment(SwingConstants.CENTER);
    jLabel1.setBorder(BorderFactory.createEtchedBorder());
    jLabel1.setForeground(new Color(10,36,106));
    jLabel1.setFont(new java.awt.Font("Dialog", 1, 13));
    textAreaStatus.setBounds(new Rectangle(0, 540, 800, 30));
    textAreaStatus.setEditable(false);
    textAreaStatus.setBorder(null);
    textAreaStatus.setBackground(new Color(143, 143, 188));
    this.setLayout(null);
    this.setSize(new Dimension(800, 600));
    this.setBackground(new Color(204, 204, 225));
    butnExit.setBackground(Color.lightGray);
    butnExit.setBounds(new Rectangle(400, 508, 80, 25));
    butnExit.setFont(new java.awt.Font("Dialog", 1, 13));
    butnExit.setForeground(Color.darkGray);
    butnExit.setText("Exit");
    butnExit.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        butnExit_actionPerformed(e);
      }
    });
    butnAdd.setBackground(Color.lightGray);
    butnAdd.setBounds(new Rectangle(306, 508, 80, 25));
    butnAdd.setFont(new java.awt.Font("Dialog", 1, 13));
    butnAdd.setForeground(Color.darkGray);
    butnAdd.setText("Add");
    butnAdd.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        butnAdd_actionPerformed(e);
      }
    });
    jScrollPane1.setAutoscrolls(true);
    jScrollPane1.setBorder(BorderFactory.createEtchedBorder());
    jScrollPane1.setMinimumSize(new Dimension(24, 24));
    jScrollPane1.setBounds(new Rectangle(0, 66, 793, 435));
    this.add(jLabel1, null);
    this.add(jScrollPane1, null);
    //fieldsGuiPanel.setPreferredSize(new Dimension(770,980));
    fieldsGuiPanel.setPreferredSize(new Dimension(770,1065));
    fieldsGuiPanel.makeCenterSelections(null);
    jScrollPane1.getViewport().add(fieldsGuiPanel, null);
    this.add(textAreaStatus, null);
    this.add(butnExit, null);
    this.add(butnAdd, null);
    fieldsGuiPanel.slkChzBuyer.init("",null,
                                fieldsGuiPanel.slkChzBuyer.TYPE_BUYER,true);

  }

  void butnExit_actionPerformed(ActionEvent e) {
    setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
    frame.showPanel(new newtimes.basic.buyermaker.BuyerMakerSearch(frame));
    setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
  }

  void butnAdd_actionPerformed(ActionEvent e) {
    if(!fieldsGuiPanel.checkFieldsData()) return;
      try {
        setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        java.util.HashMap hm = fieldsGuiPanel.setData2HashMap();
        hm.put("create_user", util.PublicVariable.USER_RECORD.get("USR_CODE"));
       /*
        BasicMdlEJBs.BasicMaintainEJB.BasicMaintainEJBHome  ejbHome=
            (BasicMdlEJBs.BasicMaintainEJB.BasicMaintainEJBHome)
            info_ejb.WeblogicServiceLocator.locateServiceHome(
             util.PublicVariable.SERVER_URL,"BasicMdlEJBs.BasicMaintainEJB.BasicMaintainEJB");
         BasicMdlEJBs.BasicMaintainEJB.BasicMaintainEJB ejb=ejbHome.create();
         int isOk=ejb.insertBuyerMaker(hm);
        */
         int isOk = exgui2.CONST.BASIC_MAIN_EJB.insertBuyerMaker(hm);
        if (exgui2.Stuff.insertMessage(frame, isOk))
          frame.showPanel(new newtimes.basic.buyermaker.BuyerMakerSearch(frame));
      } catch (Exception eAdd) {
        eAdd.printStackTrace();
        util.ExceptionLog.exp2File(eAdd, "error at insert data.");
      }finally{
       setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
      }
  }
}
