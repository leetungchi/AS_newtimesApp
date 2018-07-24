package exgui2;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

/**
 * <p>Title: SplitFrame</p>
 * <p>Description: Defines GUI use of JSplit and inclued function bar to JSplit
 *                 bottom. The function bar include of New Record,Confirm,Copy,
 *                 Paste,Delete and Exit buttons. This components are makes up
 *                 of SplitFrame that look like the master-detail relationship
 *                 skeletons.</p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author Chloe.H
 * @version 1.0
 */

public class SplitFrame extends JPanel {
  public JSplitPane jSplitPane = new JSplitPane();
  public JScrollPane jScrollPane_Bottom = new JScrollPane();
  public JScrollPane jScrollPane_Top = new JScrollPane();
  public JTabbedPane jTabbedPane1 = new JTabbedPane();
  public JPanel tabUnderPanel = new JPanel();
  public java.util.Vector setTabName = new java.util.Vector();
  public GridBagLayout gridBagLayout1 = new GridBagLayout();
  public JPanel funcationPanel = new JPanel();
  public JButton butnEdit = new JButton();
  public JButton butnPaste = new JButton();
  public JButton butnExit = new JButton();
  public JButton butnNew = new JButton();
  public JButton butnDelete = new JButton();
  public JButton butnPrint = new JButton();
  public JButton butnCopy = new JButton();
  public boolean enableStateChangeFlag = true;
  FlowLayout flowLayout1 = new FlowLayout();
  public JPanel pnl4ExtraButton = new JPanel();//this button is for futuer need,such as flip production&sytle in production edit.

  /**
   * Creates a JSplitPane that displays its components.
   */
  public SplitFrame() {
    try {
      jbInit();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }

  /**
   * Creates a JSplitPane and shows are JTabbedPanes that displays its components.
   * @param iniTabName shows are tabs titles.
   */
  public SplitFrame(java.util.Vector iniTabName) {
    try {
      this.setTabName = iniTabName;
      jbInit();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }

  private void jbInit() throws Exception {
    this.setLayout(null);
    this.setSize(800,600);
    this.setBackground(new Color(204, 204, 225));
    jSplitPane.setOneTouchExpandable(true);
    jSplitPane.setDividerSize(10);
    jSplitPane.setBounds(new Rectangle(0, 0, 793, 544));
    jSplitPane.setContinuousLayout(true);
    jSplitPane.setOrientation(JSplitPane.VERTICAL_SPLIT);
    jSplitPane.setDividerLocation(0.5);
    jScrollPane_Bottom.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
    jScrollPane_Bottom.getViewport().setBackground(new Color(204, 204, 225));
    jScrollPane_Top.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
    jScrollPane_Top.getViewport().setBackground(new Color(204, 204, 225));
    butnEdit.setBackground(Color.lightGray);
    butnEdit.setBounds(new Rectangle(108, 5, 96, 20));
    butnEdit.setFont(new java.awt.Font("Dialog", 1, 11));
    butnEdit.setBorder(BorderFactory.createEtchedBorder());
    butnEdit.setText("CONFIRM EDIT");
    butnEdit.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        butnEdit_actionPerformed(e);
      }
    });
    butnPaste.setBackground(Color.lightGray);
    butnPaste.setBounds(new Rectangle(276, 5, 60, 20));
    butnPaste.setFont(new java.awt.Font("Dialog", 1, 11));
    butnPaste.setBorder(BorderFactory.createEtchedBorder());
    butnPaste.setText("PASTE");
    butnPaste.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        butnPaste_actionPerformed(e);
      }
    });
    butnExit.setBackground(Color.lightGray);
    butnExit.setBounds(new Rectangle(506, 5, 60, 20));
    butnExit.setFont(new java.awt.Font("Dialog", 1, 11));
    butnExit.setBorder(BorderFactory.createEtchedBorder());
    butnExit.setText("EXIT");
    butnExit.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        butnExit_actionPerformed(e);
      }
    });
    butnNew.setBackground(Color.lightGray);
    butnNew.setBounds(new Rectangle(6, 5, 96, 20));
    butnNew.setFont(new java.awt.Font("Dialog", 1, 11));
    butnNew.setBorder(BorderFactory.createEtchedBorder());
    butnNew.setText("NEW RECORD");
    butnNew.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        butnNew_actionPerformed(e);
      }
    });
    butnDelete.setBackground(Color.lightGray);
    butnDelete.setBounds(new Rectangle(342, 5, 60, 20));
    butnDelete.setFont(new java.awt.Font("Dialog", 1, 11));
    butnDelete.setBorder(BorderFactory.createEtchedBorder());
    butnDelete.setText("DELETE");
    butnDelete.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        butnDelete_actionPerformed(e);
      }
    });
    butnPrint.setBackground(Color.lightGray);
    butnPrint.setBounds(new Rectangle(408, 5, 60, 20));
    butnPrint.setFont(new java.awt.Font("Dialog", 1, 11));
    butnPrint.setBorder(BorderFactory.createEtchedBorder());
    butnPrint.setText("Print");
    butnPrint.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        butnPrint_actionPerformed(e);
      }
    });
    butnCopy.setBackground(Color.lightGray);
    butnCopy.setBounds(new Rectangle(210, 5, 60, 20));
    butnCopy.setFont(new java.awt.Font("Dialog", 1, 11));
    butnCopy.setBorder(BorderFactory.createEtchedBorder());
    butnCopy.setText("COPY");
    butnCopy.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        butnCopy_actionPerformed(e);
      }
    });
    funcationPanel.setBackground(new Color(143, 143, 188));
    funcationPanel.setBounds(new Rectangle(0, 545, 800, 30));
    funcationPanel.setLayout(null);
    pnl4ExtraButton.setBackground(new Color(143, 143, 188));
    pnl4ExtraButton.setBounds(new Rectangle(574, 2, 220, 28));
    pnl4ExtraButton.setLayout(flowLayout1);
    jSplitPane.add(jScrollPane_Top, JSplitPane.TOP);
    jSplitPane.add(jScrollPane_Bottom, JSplitPane.BOTTOM);
    this.add(funcationPanel, null);
    funcationPanel.add(butnNew, null);
    funcationPanel.add(butnEdit, null);
    funcationPanel.add(butnCopy, null);
    funcationPanel.add(butnPaste, null);
    funcationPanel.add(butnDelete, null);
    funcationPanel.add(butnPrint, null);
    funcationPanel.add(butnExit, null);
    funcationPanel.add(pnl4ExtraButton, null);
    this.add(jSplitPane, null);
    jTabbedPane1.addChangeListener(new javax.swing.event.ChangeListener() {
      public void stateChanged(ChangeEvent e) {
        jTabbedPane1_stateChanged(e);
      }
    });
  }
  public JButton addExtraTriggerButton(String btnTitle,final processhandler.CommandTrigger tgr){
    JButton btn2Add=new JButton(btnTitle);
    btn2Add.setFont(new java.awt.Font("Dialog", 1, 11));
    btn2Add.setBackground(Color.lightGray);
    btn2Add.setBorder(BorderFactory.createEtchedBorder());

    btn2Add.addMouseListener(
       new java.awt.event.MouseAdapter(){
         public void mouseClicked(java.awt.event.MouseEvent e){
           if(!((JButton)e.getSource()).isEnabled())return;
           try{
            processhandler.template.Properties.getCenteralControler().doCommandExecute(tgr);
           }catch(Exception exp){
             util.ExceptionLog.exp2File(exp,"");
             exp.printStackTrace();
           }
         }
       }
    );
    pnl4ExtraButton.add(btn2Add,null);
    pnl4ExtraButton.validate();
    pnl4ExtraButton.repaint();
    return btn2Add;
  }

  /**
   * Establish one JPanel to JFrame.
   * @param panelName panelName must be JPanel type.
   */
  public boolean setPanel(JPanel panelName) {
    try {
      this.removeAll();
      this.add(panelName);
      this.repaint();
      this.validate();
      return true;
    } catch (Exception e) {
      e.printStackTrace();
      return false;
    }
  }

  public boolean setPanelWithButtons(JPanel panelName) {
    try {
      this.remove(jSplitPane);
      this.add(panelName);
      this.repaint();
      this.validate();
      return true;
    } catch (Exception e) {
      e.printStackTrace();
      return false;
    }
  }

  /**
   * Establish two JPanels with JSplitPane.
   * @param upperPanel JPanel type, if no panel please set null.
   * @param lowerPanel JPanel type, if no panel please set null.
   * @return boolean
   */
  public boolean setPanel(JPanel upperPanel, JPanel lowerPanel) {
    try {
      jScrollPane_Top.getViewport().add(upperPanel, null);
      jScrollPane_Bottom.getViewport().add(lowerPanel, null);
      this.setTab(this.setTabName, lowerPanel);
      return true;
    } catch (Exception e) {
      e.printStackTrace();
      return false;
    }
  }
  /**
   * enable to set divider location of split pane
   * @param locationRatio,the ratio of divider should located
   */
  public void setDividerLocation(double locationRatio){
    jSplitPane.setDividerLocation(locationRatio);
  }
  /**
   * Establish JPanel to top frame with JSplitPane.
   * @param pnl use JPanel type.
   * @return boolean
   */
  public boolean setUpperPanel(JPanel pnl) {
    try {
       jScrollPane_Top.getViewport().add(pnl,null);
      return true;
    } catch (Exception e) {
      return false;
    }
  }

  /**
   * Establish JPanel to bottom frame with JSplitPane.
   * @param pnl use JPanel type.
   * @return boolean
   */
  public boolean setLowerPanel(JPanel pnl) {
    try {
      jScrollPane_Bottom.getViewport().add(pnl);
      this.setTab(this.setTabName, pnl);
      return true;
    } catch (Exception e) {
      return false;
    }
  }

  /**
   * Establish JTabbedPane on JPanel with JSplitPane.
   * @param setTabName shows tabs name.
   * @param bottomPanel set this JPanel on the JTabbedPane.
   */
  public void setTab(java.util.Vector setTabName, JPanel bottomPanel) {
    try {
      if (setTabName.size() <= 0 || bottomPanel == null) {
        tabUnderPanel.setBackground(new Color(212, 208, 200));
      } else {
        tabUnderPanel.setLayout(gridBagLayout1);
        tabUnderPanel.setBackground(new Color(204, 204, 225));
        jTabbedPane1.setBounds(new Rectangle(0, 0, 771, 504));
        jTabbedPane1.setBackground(new Color(190, 190, 225));
        jTabbedPane1.setFont(new java.awt.Font("Dialog", 1, 13));
        jTabbedPane1.setForeground(new Color(10,36,106));
        tabUnderPanel.add(jTabbedPane1, null);
        jScrollPane_Bottom.getViewport().add(tabUnderPanel, null);
        int i = 0;
        for (i = 0; i < setTabName.size(); i++) {
          JPanel tabPanel = new JPanel();
          tabPanel.setBackground(new Color(190, 190, 225));
          jTabbedPane1.add(tabPanel, setTabName.get(i));
        }
        jTabbedPane1.setComponentAt(i % setTabName.size(), bottomPanel);
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public void jTabbedPane1_stateChanged(ChangeEvent e) {
    //@todo jTabbedPane1_stateChanged(ChangeEvent e) for tab changed*/
    if(enableStateChangeFlag){
      //set target gui object to system
       processhandler.template.Properties.getCenteralControler().setTargetTab(
         jTabbedPane1.getSelectedIndex(),
         jTabbedPane1.getSelectedComponent()
       );
       //activate the command of show gui for editing.
       try{
         processhandler.template.Properties.getCenteralControler().
             doCommandExecute(
               processhandler.template.Properties.getCenteralControler().GOTO_EDIT_DETAIL
             );
       }catch(Exception eii){
          eii.printStackTrace();
       }
    }
  }

  public void butnExit_actionPerformed(ActionEvent e) {
    /**@todo butnExit_actionPerformed(ActionEvent e) to previous screen.*/
    try{
      if(processhandler.template.Properties.getCenteralControler().getDataProcesser()!=null){
        processhandler.template.Properties.getCenteralControler().
            getDataProcesser().doExit();
      }else{
        processhandler.template.Properties.getCenteralControler().goBack();
      }
    }catch(Exception iie){
       iie.printStackTrace();
       util.ExceptionLog.exp2File(iie,"exception while doExit.");
       exgui.verification.VerifyLib.showAllert("Exit Fail");
    }
  }

  public void butnPrint_actionPerformed(ActionEvent e) {
    /**@todo butnPrint_actionPerformed(ActionEvent e) to print screen.*/
    try{
      processhandler.template.Properties.getCenteralControler().getDataProcesser().doPrint();
    }catch(Exception iie){
       iie.printStackTrace();
    }
  }

  public void butnDelete_actionPerformed(ActionEvent e) {
    /**@todo butnDelete_actionPerformed(ActionEvent e) to delete recent record.*/
    try{
      processhandler.template.Properties.getCenteralControler().getDataProcesser().doDelete();
    }catch(Exception iie){
       iie.printStackTrace();
       util.ExceptionLog.exp2File(iie,"exception while attemp to delete record.");
       exgui.verification.VerifyLib.showAllert("Delete Fail!!");
    }
  }

  public void butnPaste_actionPerformed(ActionEvent e) {
    /**@todo butnPaste_actionPerformed(ActionEvent e) to paste record form copy.*/
    try{
      processhandler.template.Properties.getCenteralControler().getDataProcesser().doPaste();
    }catch(Exception iie){
       iie.printStackTrace();
    }
  }

  public void butnCopy_actionPerformed(ActionEvent e) {
    /**@todo butnCopy_actionPerformed(ActionEvent e) to copy recent record.*/
    try{
      processhandler.template.Properties.getCenteralControler().getDataProcesser().doCopy();
    }catch(Exception iie){
       iie.printStackTrace();
    }
  }

  public void butnEdit_actionPerformed(ActionEvent e) {
    /**@todo butnEdit_actionPerformed(ActionEvent e) to edit recent record.*/
    try{
      processhandler.template.Properties.getCenteralControler().getDataProcesser().doUpdate();
    }catch(Exception iie){
       iie.printStackTrace();
       util.ExceptionLog.exp2File(iie,"exception while attemp to update record.");
       exgui.verification.VerifyLib.showAllert("Update Fail!!");
    }
  }

  public void butnNew_actionPerformed(ActionEvent e) {
    /**@todo butnNew_actionPerformed(ActionEvent e) to new record.*/
    try{
      processhandler.template.Properties.getCenteralControler().getDataProcesser().doAddNew();
    }catch(Exception iie){
       iie.printStackTrace();
       util.ExceptionLog.exp2File(iie,"exception while attemp to insert record.");
       exgui.verification.VerifyLib.showAllert("Insert Fail!!");
    }
  }
}
