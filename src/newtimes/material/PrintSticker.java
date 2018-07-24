package newtimes.material;

import java.awt.*;
import newtimes.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.HashSet;
import javax.swing.filechooser.*;
import java.net.*;
import java.io.*;
/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author unascribed
 * @version 1.0
 */

public class PrintSticker extends JPanel {
  Frame1 frame;
  private JLabel textAreaStatus = new JLabel();
  private JLabel jLabel1 = new JLabel();
  private JLabel jTextField3 = new JLabel();
  private JLabel jTextField2 = new JLabel();
  private JLabel jTextField1 = new JLabel();
  private JLabel jTextField4 = new JLabel();
  private JLabel jTextField6 = new JLabel();
  private JRadioButton rbtMillYes = new JRadioButton();
  private JRadioButton rbtMillNo = new JRadioButton();
  private JRadioButton rbtFinishYes = new JRadioButton();
  private JRadioButton rbtFinishNo = new JRadioButton();
  private JRadioButton rbtPriceUSD = new JRadioButton();
  private JRadioButton rbtPriceLocal = new JRadioButton();
  private JRadioButton rbtPriceNO = new JRadioButton();
  private JRadioButton rbtPrintLocal = new JRadioButton();
  private JRadioButton rbtPrintDL = new JRadioButton();
  private JRadioButton rbtNameChinese = new JRadioButton();
  private JRadioButton rbtNameNone = new JRadioButton();
  private JRadioButton rbtNameAbbr = new JRadioButton();
  private ButtonGroup buttonGroup1 = new ButtonGroup();
  private ButtonGroup buttonGroup2 = new ButtonGroup();
  private ButtonGroup buttonGroup3 = new ButtonGroup();
  private ButtonGroup buttonGroup4 = new ButtonGroup();
  private ButtonGroup buttonGroup5 = new ButtonGroup();
  private ButtonGroup buttonGroup6 = new ButtonGroup();
  private ButtonGroup buttonGroup7 = new ButtonGroup();
  private JButton butnExit = new JButton();
  private JButton jButton2 = new JButton();
  JRadioButton rbtNewtimes = new JRadioButton();
  JRadioButton rbtL_Heavy = new JRadioButton();

  String MtrDtl_pkList = "";
  JRadioButton rbtFloor12 = new JRadioButton();
  JLabel jTextField7 = new JLabel();
  JRadioButton rbtFloor10 = new JRadioButton();
  ButtonGroup buttonGroup8 = new ButtonGroup();

  JRadioButton rbtRemarkNO = new JRadioButton();
  JLabel jTextField5 = new JLabel();
  JRadioButton rbtRemarkYes = new JRadioButton();
  JRadioButton rbtNoHeader = new JRadioButton();
  JRadioButton rbtNameFull = new JRadioButton();
  JRadioButton rdoNoPrintConstruct = new JRadioButton();
  JLabel jTextField8 = new JLabel();
  JRadioButton rdoPrintConstruct = new JRadioButton();
  ButtonGroup btnGroupPrintConstruct = new ButtonGroup();

  public PrintSticker(Frame1 _frame, HashSet _MtrDtl_pkList) {
    frame = _frame;
    Object[] entries = _MtrDtl_pkList.toArray();
    for(int i=0; i<entries.length; i++){
      String pkItem = entries[i].toString();
      if(i==(entries.length-1))
        MtrDtl_pkList = MtrDtl_pkList + pkItem;
      else
        MtrDtl_pkList = MtrDtl_pkList + pkItem + ",";
    }
    try {
      jbInit();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }
  void jbInit() throws Exception {
    jLabel1.setBounds(new Rectangle(117, 15, 566, 24));
    jLabel1.setHorizontalAlignment(SwingConstants.CENTER);
    jLabel1.setBorder(BorderFactory.createEtchedBorder());
    jLabel1.setForeground(new Color(10,36,106));
    jLabel1.setFont(new java.awt.Font("Dialog", 1, 13));
    jLabel1.setText("      ============  Print Sticker  ============      ");

    textAreaStatus.setBounds(new Rectangle(0, 540, 800, 30));
    //textAreaStatus.setEditable(false);
    textAreaStatus.setBorder(null);
    textAreaStatus.setBackground(new Color(143, 143, 188));
    this.setLayout(null);
    this.setSize(800,600);
    this.setBackground(new Color(204, 204, 225));
    jTextField3.setBackground(new Color(143, 143, 188));
    jTextField3.setFont(new java.awt.Font("Dialog", 1, 12));
    jTextField3.setForeground(new Color(10,36,106));
    jTextField3.setBorder(null);
    jTextField3.setOpaque(true);
    jTextField3.setRequestFocusEnabled(false);
    //jTextField3.setEditable(false);
    jTextField3.setText(" Print Finish :");
    jTextField3.setBounds(new Rectangle(183, 233, 155, 23));
    jTextField2.setBackground(new Color(143, 143, 188));
    jTextField2.setFont(new java.awt.Font("Dialog", 1, 12));
    jTextField2.setForeground(Color.white);
    jTextField2.setBorder(null);
    jTextField2.setOpaque(true);
    jTextField2.setRequestFocusEnabled(false);
    //jTextField2.setEditable(false);
    jTextField2.setText(" Print Mill Name :");
    jTextField2.setBounds(new Rectangle(183, 174, 155, 46));
    jTextField1.setBackground(new Color(143, 143, 188));
    jTextField1.setFont(new java.awt.Font("Dialog", 1, 12));
    jTextField1.setForeground(new Color(10,36,106));
    jTextField1.setBorder(null);
    jTextField1.setOpaque(true);
    jTextField1.setRequestFocusEnabled(false);
    //jTextField1.setEditable(false);
    jTextField1.setText(" Print Mill No :");
    jTextField1.setBounds(new Rectangle(183, 139, 155, 23));
    jTextField4.setBackground(new Color(143, 143, 188));
    jTextField4.setFont(new java.awt.Font("Dialog", 1, 12));
    jTextField4.setForeground(Color.white);
    jTextField4.setBorder(null);
    jTextField4.setOpaque(true);
    jTextField4.setRequestFocusEnabled(false);
    //jTextField4.setEditable(false);
    jTextField4.setText(" Print Price :");
    jTextField4.setBounds(new Rectangle(183, 268, 155, 46));
    jTextField6.setBackground(new Color(143, 143, 188));
    jTextField6.setFont(new java.awt.Font("Dialog", 1, 12));
    jTextField6.setForeground(Color.white);
    jTextField6.setBorder(null);
    jTextField6.setOpaque(true);
    jTextField6.setRequestFocusEnabled(false);
    //jTextField6.setEditable(false);
    jTextField6.setText(" Print Select :");
    jTextField6.setBounds(new Rectangle(183, 362, 155, 23));
    rbtMillYes.setBackground(Color.white);
    rbtMillYes.setFont(new java.awt.Font("Dialog", 1, 12));
    rbtMillYes.setForeground(Color.darkGray);
    rbtMillYes.setSelected(true);
    rbtMillYes.setText("Yes");
    rbtMillYes.setBounds(new Rectangle(338, 140, 137, 23));
    rbtMillNo.setBackground(Color.white);
    rbtMillNo.setFont(new java.awt.Font("Dialog", 1, 12));
    rbtMillNo.setForeground(Color.darkGray);
    rbtMillNo.setText("No");
    rbtMillNo.setBounds(new Rectangle(474, 140, 137, 23));
    rbtFinishYes.setBackground(Color.white);
    rbtFinishYes.setFont(new java.awt.Font("Dialog", 1, 12));
    rbtFinishYes.setForeground(Color.darkGray);
    rbtFinishYes.setSelected(true);
    rbtFinishYes.setText("Yes");
    rbtFinishYes.setBounds(new Rectangle(337, 233, 140, 23));
    rbtFinishNo.setBackground(Color.white);
    rbtFinishNo.setFont(new java.awt.Font("Dialog", 1, 12));
    rbtFinishNo.setForeground(Color.darkGray);
    rbtFinishNo.setText("No");
    rbtFinishNo.setBounds(new Rectangle(475, 233, 137, 23));
    rbtPriceUSD.setBackground(Color.white);
    rbtPriceUSD.setFont(new java.awt.Font("Dialog", 1, 12));
    rbtPriceUSD.setForeground(Color.darkGray);
    rbtPriceUSD.setSelected(true);
    rbtPriceUSD.setText("USD");
    rbtPriceUSD.setBounds(new Rectangle(336, 268, 137, 23));
    rbtPriceLocal.setBackground(Color.white);
    rbtPriceLocal.setFont(new java.awt.Font("Dialog", 1, 12));
    rbtPriceLocal.setForeground(Color.darkGray);
    rbtPriceLocal.setText("Local");
    rbtPriceLocal.setBounds(new Rectangle(472, 268, 137, 23));
    rbtPriceNO.setBackground(Color.white);
    rbtPriceNO.setFont(new java.awt.Font("Dialog", 1, 12));
    rbtPriceNO.setForeground(Color.darkGray);
    rbtPriceNO.setText("No");
    rbtPriceNO.setBounds(new Rectangle(336, 291, 273, 23));
    rbtPrintLocal.setBackground(Color.white);
    rbtPrintLocal.setFont(new java.awt.Font("Dialog", 1, 12));
    rbtPrintLocal.setForeground(Color.darkGray);
    rbtPrintLocal.setSelected(true);
    rbtPrintLocal.setText("to Print Server");
    rbtPrintLocal.setBounds(new Rectangle(336, 362, 140, 23));
    rbtPrintDL.setBackground(Color.white);
    rbtPrintDL.setFont(new java.awt.Font("Dialog", 1, 12));
    rbtPrintDL.setForeground(Color.darkGray);
    rbtPrintDL.setText("Download (only txt)");
    rbtPrintDL.setBounds(new Rectangle(475, 362, 137, 23));
    rbtNameChinese.setBackground(Color.white);
    rbtNameChinese.setFont(new java.awt.Font("Dialog", 1, 12));
    rbtNameChinese.setForeground(Color.darkGray);
    rbtNameChinese.setText("Chinese Name");
    rbtNameChinese.setBounds(new Rectangle(474, 174, 137, 23));
    rbtNameNone.setBackground(Color.white);
    rbtNameNone.setFont(new java.awt.Font("Dialog", 1, 12));
    rbtNameNone.setForeground(Color.darkGray);
    rbtNameNone.setText("Not Print");
    rbtNameNone.setBounds(new Rectangle(474, 197, 137, 23));
    rbtNameAbbr.setBackground(Color.white);
    rbtNameAbbr.setFont(new java.awt.Font("Dialog", 1, 12));
    rbtNameAbbr.setForeground(Color.darkGray);
    rbtNameAbbr.setActionCommand("ABBR NAME");
    rbtNameAbbr.setSelected(true);
    rbtNameAbbr.setText("Abbr Name");
    rbtNameAbbr.setBounds(new Rectangle(338, 174, 137, 23));
    butnExit.setBackground(Color.lightGray);
    butnExit.setBounds(new Rectangle(436, 473, 80, 25));
    butnExit.setFont(new java.awt.Font("Dialog", 1, 13));
    butnExit.setForeground(Color.darkGray);
    butnExit.setText("Exit");
    butnExit.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        butnExit_actionPerformed(e);
      }
    });
    jButton2.setBackground(Color.lightGray);
    jButton2.setBounds(new Rectangle(287, 473, 132, 25));
    jButton2.setFont(new java.awt.Font("Dialog", 1, 12));
    jButton2.setForeground(Color.darkGray);
    jButton2.setText("Print / Download");
    jButton2.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        jButton2_actionPerformed(e);
      }
    });
    rbtNewtimes.setBackground(new Color(204, 204, 225));
    rbtNewtimes.setFont(new java.awt.Font("Dialog", 1, 12));
    rbtNewtimes.setForeground(Color.darkGray);
    rbtNewtimes.setSelected(true);
    rbtNewtimes.setText("Newtimes Taiwan");
    rbtNewtimes.setBounds(new Rectangle(182, 44, 145, 23));
    rbtL_Heavy.setBackground(new Color(204, 204, 225));
    rbtL_Heavy.setFont(new java.awt.Font("Dialog", 1, 12));
    rbtL_Heavy.setForeground(Color.darkGray);
    rbtL_Heavy.setText("Light & Heavy");
    rbtL_Heavy.setBounds(new Rectangle(332, 44, 127, 23));
    rbtFloor12.setBounds(new Rectangle(338, 103, 274, 23));
    rbtFloor12.setText("Form-B (4.8cm x 9cm)");
    rbtFloor12.setForeground(Color.darkGray);
    rbtFloor12.setFont(new java.awt.Font("Dialog", 1, 12));
    rbtFloor12.setBackground(Color.white);
    jTextField7.setBounds(new Rectangle(183, 80, 155, 46));
    jTextField7.setText(" Sticker Form :");
    //jTextField7.setEditable(false);
    jTextField7.setBorder(null);
    jTextField7.setOpaque(true);
    jTextField7.setRequestFocusEnabled(false);
    jTextField7.setForeground(Color.white);
    jTextField7.setFont(new java.awt.Font("Dialog", 1, 12));
    jTextField7.setBackground(new Color(143, 143, 188));
    rbtFloor10.setBounds(new Rectangle(337, 80, 275, 23));
    rbtFloor10.setText("Form-A (3.6cm x 14cm)");
    rbtFloor10.setSelected(true);
    rbtFloor10.setForeground(Color.darkGray);
    rbtFloor10.setFont(new java.awt.Font("Dialog", 1, 12));
    rbtFloor10.setBackground(Color.white);
    rbtRemarkNO.setBounds(new Rectangle(474, 327, 137, 23));
    rbtRemarkNO.setText("No");
    rbtRemarkNO.setForeground(Color.darkGray);
    rbtRemarkNO.setFont(new java.awt.Font("Dialog", 1, 12));
    rbtRemarkNO.setBackground(Color.white);
    jTextField5.setBounds(new Rectangle(183, 327, 155, 23));
    jTextField5.setText(" Print Head Remark :");
    //jTextField5.setEditable(false);
    //jTextField5.setSelectionStart(15);
    jTextField5.setBorder(null);
    jTextField5.setOpaque(true);
    jTextField5.setRequestFocusEnabled(false);
    jTextField5.setForeground(new Color(10,36,106));
    jTextField5.setFont(new java.awt.Font("Dialog", 1, 12));
    jTextField5.setBackground(new Color(143, 143, 188));
    rbtRemarkYes.setBounds(new Rectangle(337, 327, 137, 23));
    rbtRemarkYes.setText("Yes");
    rbtRemarkYes.setSelected(true);
    rbtRemarkYes.setForeground(Color.darkGray);
    rbtRemarkYes.setFont(new java.awt.Font("Dialog", 1, 12));
    rbtRemarkYes.setBackground(Color.white);
    rbtNoHeader.setBounds(new Rectangle(467, 44, 132, 23));
    rbtNoHeader.setText("No Header");
    rbtNoHeader.setForeground(Color.darkGray);
    rbtNoHeader.setFont(new java.awt.Font("Dialog", 1, 12));
    rbtNoHeader.setBackground(new Color(204, 204, 225));
    rbtNameFull.setBounds(new Rectangle(338, 197, 137, 23));
    rbtNameFull.setText("Full Name");
    rbtNameFull.setForeground(Color.darkGray);
    rbtNameFull.setFont(new java.awt.Font("Dialog", 1, 12));
    rbtNameFull.setBackground(Color.white);
    rdoNoPrintConstruct.setBackground(Color.white);
    rdoNoPrintConstruct.setFont(new java.awt.Font("Dialog", 1, 12));
    rdoNoPrintConstruct.setForeground(Color.darkGray);
    rdoNoPrintConstruct.setText("No");
    rdoNoPrintConstruct.setBounds(new Rectangle(472, 398, 137, 23));
    jTextField8.setBackground(new Color(143, 143, 188));
    jTextField8.setFont(new java.awt.Font("Dialog", 1, 12));
    jTextField8.setForeground(new Color(10,36,106));
    jTextField8.setBorder(null);
    jTextField8.setOpaque(true);
    jTextField8.setRequestFocusEnabled(false);
    //jTextField8.setSelectionStart(15);
    //jTextField8.setEditable(false);
    jTextField8.setText(" Print Construct :");
    jTextField8.setBounds(new Rectangle(183, 398, 155, 23));
    rdoPrintConstruct.setBackground(Color.white);
    rdoPrintConstruct.setFont(new java.awt.Font("Dialog", 1, 12));
    rdoPrintConstruct.setForeground(Color.darkGray);
    rdoPrintConstruct.setSelected(true);
    rdoPrintConstruct.setText("Yes");
    rdoPrintConstruct.setBounds(new Rectangle(335, 398, 137, 23));
    this.add(jLabel1, null);
    this.add(textAreaStatus, null);
    this.add(butnExit, null);
    this.add(jButton2, null);
    buttonGroup1.add(rbtMillYes);
    buttonGroup1.add(rbtMillNo);
    buttonGroup2.add(rbtNameAbbr);
    buttonGroup2.add(rbtNameChinese);
    buttonGroup2.add(rbtNameNone);
    buttonGroup3.add(rbtFinishYes);
    buttonGroup3.add(rbtFinishNo);
    buttonGroup4.add(rbtPriceUSD);
    buttonGroup4.add(rbtPriceLocal);
    buttonGroup6.add(rbtPrintLocal);
    buttonGroup6.add(rbtPrintDL);
    buttonGroup7.add(rbtNewtimes);
    buttonGroup7.add(rbtL_Heavy);
    buttonGroup8.add(rbtFloor10);
    buttonGroup8.add(rbtFloor12);
    buttonGroup4.add(rbtPriceNO);
    buttonGroup5.add(rbtRemarkNO);
    buttonGroup5.add(rbtRemarkYes);
    buttonGroup7.add(rbtNoHeader);
    this.add(rbtNewtimes, null);
    this.add(rbtL_Heavy, null);
    this.add(rbtNoHeader, null);
    this.add(jTextField7, null);
    this.add(rbtFloor10, null);
    this.add(rbtFloor12, null);
    this.add(jTextField1, null);
    this.add(jTextField2, null);
    this.add(jTextField3, null);
    this.add(jTextField4, null);
    this.add(jTextField8, null);
    this.add(jTextField6, null);
    this.add(jTextField5, null);
    this.add(rdoPrintConstruct, null);
    this.add(rdoNoPrintConstruct, null);
    this.add(rbtPrintLocal, null);
    this.add(rbtPrintDL, null);
    this.add(rbtRemarkYes, null);
    this.add(rbtRemarkNO, null);
    this.add(rbtPriceUSD, null);
    this.add(rbtPriceNO, null);
    this.add(rbtPriceLocal, null);
    this.add(rbtFinishYes, null);
    this.add(rbtFinishNo, null);
    this.add(rbtNameAbbr, null);
    this.add(rbtNameChinese, null);
    this.add(rbtNameFull, null);
    this.add(rbtNameNone, null);
    this.add(rbtMillYes, null);
    this.add(rbtMillNo, null);
    buttonGroup2.add(rbtNameFull);
    btnGroupPrintConstruct.add(rdoNoPrintConstruct);
    btnGroupPrintConstruct.add(rdoPrintConstruct);
  }
  void butnExit_actionPerformed(ActionEvent e) {
    setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
    frame.showPanel(new MtrDtlPrintList(frame));
    setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
  }

  void jButton2_actionPerformed(ActionEvent e) {
    setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
    java.util.HashMap hm = setConds();
    try{
      java.util.HashMap status = exgui2.CONST.Sticker_EJB.makeSticker(hm);
      if(status!=null){
        Object entry = status.get("PRINTER");
        if(entry!=null){
          String filname =(String)entry;
          new mtrWarnDialog(frame, "PRINTER SERVER", "FILE: "+filname+" IS IN PRINTING...", true);
        }
        else{
          entry = status.get("DOWNLOAD");
          if(entry!=null){
            String urlStr = (String)entry;
            saveSticker(urlStr);
          }
        }
      }
    }
    catch(Exception exp){
      exp.printStackTrace();
    }
    finally{
      setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
    }
  }


  private java.util.HashMap setConds(){
    java.util.HashMap hm = new java.util.HashMap();
    hm.put("MTRDTL_PK_LIST", MtrDtl_pkList);

    if(rdoPrintConstruct.isSelected())
      hm.put("PRINT_CONSTRUCT","Y");
    else
      hm.put("PRINT_CONSTRUCT","N");

    if(this.rbtNewtimes.isSelected())
      hm.put("NEWTIMES", "NEWTIMES TAIWAN");
    else if(this.rbtL_Heavy.isSelected())
      hm.put("NEWTIMES", "LIGHT&HEAVY");
    else
      hm.put("NEWTIMES", "");

    if(this.rbtFloor10.isSelected())
      hm.put("FLOOR", "10F");
    else
      hm.put("FLOOR", "12F");

    if(this.rbtMillNo.isSelected())
      hm.put("MILLNO", "N");
    else
      hm.put("MILLNO", "Y");

    if(this.rbtNameAbbr.isSelected())
      hm.put("MILLNAME","ABBR");
    if(this.rbtNameChinese.isSelected())
      hm.put("MILLNAME","CHINESE");
    if(this.rbtNameNone.isSelected())
      hm.put("MILLNAME","N");
    if(this.rbtNameFull.isSelected())
      hm.put("MILLNAME","FULLNAME");

    if(this.rbtFinishNo.isSelected())
      hm.put("FINISH","N");
    else
      hm.put("FINISH","Y");

    if(this.rbtPriceUSD.isSelected())
      hm.put("PRICE","USD");
    else if(this.rbtPriceLocal.isSelected())
      hm.put("PRICE","LOCAL");
    else
      hm.put("PRICE","N");

    if(this.rbtRemarkYes.isSelected())
      hm.put("REMARK","Y");
    else
      hm.put("REMARK","N");


    if(this.rbtPrintLocal.isSelected())
      hm.put("PRINT","LOCAL");
    else
      hm.put("PRINT","DOWNLOAD");

    String LogName = System.getProperty("user.name");
    if(!LogName.equals("")){
      if(LogName.length()>3) LogName = LogName.substring(0,3);
    }
    else{
      LogName = "XXX";
    }
    hm.put("LOG_NAME", System.getProperty("user.name"));

    String userCenter = "";
    try{
      userCenter = (String) util.PublicVariable.USER_RECORD.get("USR_CEN_CODE");
    }
    catch(Exception exp){
      exp.printStackTrace();
    }
    finally{
      hm.put("USER_CENTER",userCenter);
    }
    return hm;
  }

  private void saveSticker(String urlStr){
    try{
      JFileChooser fc = new JFileChooser();
      int returnVal = fc.showSaveDialog(this);
      if(returnVal == JFileChooser.APPROVE_OPTION){
        URL url = new URL(urlStr);
        URLConnection connection = url.openConnection();
        connection.connect();
        DataInputStream reader = new DataInputStream(connection.getInputStream());
        byte[] buffer = new byte[connection.getContentLength()];
        reader.readFully(buffer);
        reader.close();
        File file = fc.getSelectedFile();
        String filename = fc.getName(file);
        FileOutputStream writer = new FileOutputStream(file);
        writer.write(buffer);
        writer.flush();
        writer.close();
        new mtrWarnDialog(frame, "DOWNLOAD", "FILE: "+filename+" DOWNLOAD OK!", true);
      }
      else{
        new mtrWarnDialog(frame, "DOWNLOAD", "DOWNLOAD CANCELED!", true);
      }
    }
    catch(Exception exp){
      exp.printStackTrace();
    }

  }


}
