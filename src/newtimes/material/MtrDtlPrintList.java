package newtimes.material;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import newtimes.*;
import database.datatype.Record;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class MtrDtlPrintList extends JPanel {
  private static java.util.HashSet  mtrDtlPK_Set = new java.util.HashSet();
  private final newtimes.material.CONST.MTR.APP.SEARCH MTR_SEARCH = null;
  private newtimes.material.CONST.MTRDTL.EJB MTRDTL = null;

  private PrintListAbsPanel StickerPanel = new PrintListAbsPanel(this);
  private JTable StickerTable = StickerPanel.getJtable();
  private JLabel jLabel1 = new JLabel();

  Frame1 frame;
  JPanel statusPanel = new JPanel();
  JButton btnPrint = new JButton();
  JButton jButton1 = new JButton();
  JButton btnCheckAll=new JButton("Choose All Items Of This Page");
  JButton btnAddOtherMtrNo=new JButton("Add Other Mtr No.");
  private JCheckBox[] printCheckGroup = new JCheckBox[20];
  JButton butnFabric = new JButton();
  public MtrDtlPrintList(Frame1 _frame) {
    frame = _frame;
    try {
      jbInit();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }
  void jbInit() throws Exception {
    this.setLayout(null);
    this.setBackground(new Color(204, 204, 225));
    this.setSize(new Dimension(800, 576));
    btnCheckAll.setBackground(Color.lightGray);
    btnAddOtherMtrNo.setBackground(Color.lightGray);
    jLabel1.setBounds(new Rectangle(117, 15, 566, 24));
    jLabel1.setHorizontalAlignment(SwingConstants.CENTER);
    jLabel1.setBorder(BorderFactory.createEtchedBorder());
    jLabel1.setForeground(new Color(10,36,106));
    jLabel1.setFont(new java.awt.Font("Dialog", 1, 13));
    jLabel1.setText("      ============  Matrial Detail  ============      ");
    StickerPanel.setBounds(new Rectangle(50, 80, 720, 420));
    statusPanel.setBackground(new Color(143, 143, 188));
    statusPanel.setBounds(new Rectangle(0, 540, 800, 30));
    btnPrint.setBackground(Color.lightGray);
    btnPrint.setBounds(new Rectangle(206, 510, 108, 24));
    btnPrint.setFont(new java.awt.Font("Dialog", 1, 12));
    btnPrint.setForeground(Color.darkGray);
    btnPrint.setBorder(BorderFactory.createEtchedBorder());
    btnPrint.setText("Print Sticker");
    btnPrint.addActionListener(new MtrDtlPrintList_btnPrint_actionAdapter(this));
    jButton1.setBackground(Color.lightGray);
    jButton1.setBounds(new Rectangle(512, 510, 82, 24));
    jButton1.setFont(new java.awt.Font("Dialog", 1, 12));
    jButton1.setForeground(Color.darkGray);
    jButton1.setBorder(BorderFactory.createEtchedBorder());
    jButton1.setText("Exit");

    jButton1.addActionListener(new MtrDtlPrintList_jButton1_actionAdapter(this));
    for(int i=0; i<printCheckGroup.length; i++){
      final int rowNum = i;
      printCheckGroup[i] = new JCheckBox();
      printCheckGroup[i].setText("");
      printCheckGroup[i].setBounds(new Rectangle(25, 125+i*16, 25, 16));
      printCheckGroup[i].setBackground(new Color(204, 204, 225));
      printCheckGroup[i].addActionListener(new java.awt.event.ActionListener(){
          public void actionPerformed(ActionEvent e) {
            printCheck_actionPerformed(e,rowNum);
          }
        }
      );
      this.add(printCheckGroup[i], null);
    }
    if(printCheckGroup.length>0){
      btnCheckAll.addActionListener(
         new CheckAllBox_butnFabric_actionAdapter(this));
      StickerPanel.getLowerRightPanel().add(btnCheckAll,null);
      StickerPanel.getLowerRightPanel().add(btnAddOtherMtrNo,null);
    }
    btnAddOtherMtrNo.addMouseListener(new ClickAddOtherMtrNo());
    butnFabric.setBackground(Color.lightGray);
    butnFabric.setBounds(new Rectangle(325, 510, 175, 24));
    butnFabric.setFont(new java.awt.Font("Dialog", 1, 12));
    butnFabric.setForeground(Color.darkGray);
    butnFabric.setBorder(BorderFactory.createEtchedBorder());
    butnFabric.setText("Fabric Development Report");
    butnFabric.addActionListener(new MtrDtlPrintList_butnFabric_actionAdapter(this));
    this.add(jLabel1, null);
    this.add(StickerPanel, null);
    this.add(statusPanel, null);
    this.add(jButton1, null);
    this.add(btnPrint, null);
    this.add(butnFabric, null);
    this.refreshCheck();
  }

  void jButton1_actionPerformed(ActionEvent e) {
    setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
    mtrDtlPK_Set.clear();
    frame.showPanel(new MaterialSearch(frame, MTR_SEARCH.EXISTING));
    setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
  }

  void btnPrint_actionPerformed(ActionEvent e) {
    setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
    frame.showPanel(new PrintSticker(frame,mtrDtlPK_Set));
    setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));

  }
  class ClickAddOtherMtrNo extends java.awt.event.MouseAdapter{
     public void mouseClicked(java.awt.event.MouseEvent me){
       java.util.HashMap hm= (java.util.HashMap)util.ApplicationProperites.getProperties(MTR_SEARCH.CONDITIONS);
       if(hm!=null){
        String otherMtrNoList=(String)hm.get("attachedInMtrNoList");
        JTextField  pf = new JTextField((otherMtrNoList==null?"":otherMtrNoList));
        Object[] message = new Object[] {"Please Input Other Mtr No. To This List,Separated With \",\"", pf};
        Object[] options = new String[] {"OK", "Cancel"};
        JOptionPane op = new JOptionPane(
               message, JOptionPane.PLAIN_MESSAGE,
               JOptionPane.OK_CANCEL_OPTION, null, options);
        JDialog dialog = op.createDialog(null, "Please Input Other Mtr No. To This List,Separated with camma");

        dialog.show();
        String chars=pf.getText();

        if(chars==null){
          ((java.util.HashMap)util.ApplicationProperites.getProperties(MTR_SEARCH.CONDITIONS)).put(
           "attachedInMtrNoList",null);
            StickerPanel.reload();
        }else{
          ((java.util.HashMap)util.ApplicationProperites.getProperties(MTR_SEARCH.CONDITIONS)).put(
           "attachedInMtrNoList",chars);
           StickerPanel.reload();
        }

       }
     }
  }
 void btnCheckAllBox_actionPerformed(ActionEvent e) {
   for(int i=0;i<printCheckGroup.length;i++){
     printCheckGroup[i].setSelected(true);
     printCheck_actionPerformed(null,i);
   }
 }

  void printCheck_actionPerformed(ActionEvent e,final int rowNum) {
    try{
      java.util.Vector recList = StickerPanel.getDisplayingRecords();
      if (rowNum < recList.size() && rowNum >= 0) {
        Record rec = (Record) recList.get(rowNum);
        Object pk = rec.get(MTRDTL.PK);
        if(printCheckGroup[rowNum].isSelected()){
          mtrDtlPK_Set.add(pk);
        }
        else{
          mtrDtlPK_Set.remove(pk);
        }
      }
    }
    catch(Exception ex){
      ex.printStackTrace();
    }
  }

  void refreshCheck(){
    try{
      java.util.Vector recList = StickerPanel.getDisplayingRecords();
      for(int i=0; i<printCheckGroup.length; i++){
        if(i<recList.size()){
          printCheckGroup[i].setVisible(true);
          Record rec = (Record) recList.get(i);
          if(mtrDtlPK_Set.contains(rec.get(MTRDTL.PK))){
            printCheckGroup[i].setSelected(true);
          }
          else{
            printCheckGroup[i].setSelected(false);
          }
        }
        else{
          printCheckGroup[i].setVisible(false);
          printCheckGroup[i].setSelected(false);
        }
      }
    }
    catch(Exception e){
      e.printStackTrace();
    }
  }

  void butnFabric_actionPerformed(ActionEvent e) {
    setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
    frame.showPanel(new newtimes.material.FabricReport(frame, mtrDtlPK_Set));
    setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
  }
}

class MtrDtlPrintList_jButton1_actionAdapter implements java.awt.event.ActionListener {
  MtrDtlPrintList adaptee;

  MtrDtlPrintList_jButton1_actionAdapter(MtrDtlPrintList adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.jButton1_actionPerformed(e);
  }
}

class MtrDtlPrintList_btnPrint_actionAdapter implements java.awt.event.ActionListener {
  MtrDtlPrintList adaptee;

  MtrDtlPrintList_btnPrint_actionAdapter(MtrDtlPrintList adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.btnPrint_actionPerformed(e);
  }
}

class MtrDtlPrintList_butnFabric_actionAdapter implements java.awt.event.ActionListener {
  MtrDtlPrintList adaptee;

  MtrDtlPrintList_butnFabric_actionAdapter(MtrDtlPrintList adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.butnFabric_actionPerformed(e);
  }
}
class CheckAllBox_butnFabric_actionAdapter implements java.awt.event.ActionListener {
  MtrDtlPrintList adaptee;
  CheckAllBox_butnFabric_actionAdapter(MtrDtlPrintList adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.btnCheckAllBox_actionPerformed(e);
  }
}
