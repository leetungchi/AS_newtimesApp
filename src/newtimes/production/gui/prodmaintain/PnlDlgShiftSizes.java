package newtimes.production.gui.prodmaintain;

import java.awt.*;
import javax.swing.*;
import java.util.*;
import java.awt.event.*;
import exgui.chaindialog.*;
/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class PnlDlgShiftSizes extends JPanel implements Responsible{
  BorderLayout borderLayout1 = new BorderLayout();
  JPanel jPanel1 = new JPanel();
  JLabel jLabel1 = new JLabel();
  BorderLayout borderLayout2 = new BorderLayout();
  JPanel jPanel2 = new JPanel();
  JPanel jPanel3 = new JPanel();
  BorderLayout borderLayout3 = new BorderLayout();
  JPanel jPanel4 = new JPanel();
  BorderLayout borderLayout4 = new BorderLayout();
  JScrollPane jScrollPane1 = new JScrollPane();
  Vector columnVct=new Vector();
  JTable jTable1 = null;
  JPanel jPanel5 = new JPanel();
  BorderLayout borderLayout5 = new BorderLayout();
  JPanel jPanel6 = new JPanel();
  JButton btnShiftUp = new JButton();
  JButton btnShiftDown = new JButton();
  BorderLayout borderLayout6 = new BorderLayout();
  JTextField txtNewItem = new JTextField();
  JButton btn2Add = new JButton();
  Vector elements2Show=new Vector();
  HashMap names=new HashMap();
  Responsible nextRspOBj=null;
  public static String STRING_KEY_SHFT_SIZE_DBL_CMA_LIST;
  JButton btnDeleteSize = new JButton();
  public PnlDlgShiftSizes() {
    try {
      storedMap.clear();
      columnVct.removeAllElements();
      columnVct.add("Size Types");
      jTable1 = new JTable(new Vector(),columnVct);
      jbInit();
      reBuildTable();
    }

    catch(Exception ex) {
      ex.printStackTrace();
    }
  }
  public PnlDlgShiftSizes(String sizes){
    this();

    //initialize jtable.
  }
  public JComponent getGUI(){
    //return null;
    if(storedMap.get(PnlDlgSlkSizeType.SELECTED_SIZE_TYPE_STRING)==null){
      return null;
    }else{
      elements2Show.clear();
      String chznSizeType=(String)storedMap.get(PnlDlgSlkSizeType.SELECTED_SIZE_TYPE_STRING);
      if(chznSizeType==null||chznSizeType.trim().length()==0){
        reBuildTable();
        return this;
      }
      String[] sizes=util.MiscFunc.split(chznSizeType,",");
      for(int i=0;i<sizes.length;i++){
        Vector xvct=new Vector();
        xvct.add(sizes[i]);
        elements2Show.add(xvct);
      }
      reBuildTable();
      return this;
    }
  }
  public boolean isAllowOkNow(){return true;}
  public void setDefalutNext(Responsible dfltRsp){
    nextRspOBj=dfltRsp;
  }
  public Responsible next()throws NextResponsibleIsNotReady{
    //store displaying data to dialog context
    //store displaying columns to the column of current style record.
    StringBuffer sb=new StringBuffer();
    boolean isSizeS=false;
    boolean isSizeXL=false;
    for(int i=0;i<jTable1.getRowCount();i++){
      String str=jTable1.getValueAt(i,0).toString();
      if("S".equals(str.trim()))isSizeS=true;
      if("XL".equals(str.trim()))isSizeXL=true;
      sb.append(str.trim());
      if(i<(jTable1.getRowCount()-1))sb.append(",,");
    }
    storedMap.put(STRING_KEY_SHFT_SIZE_DBL_CMA_LIST,sb.toString());
    //for TPE,check buyer : Ashworth & maker: ForestGrow  PO
    //if style sty like 'AM5111,and Size : S~ XL,maker discount should be 0.71
    //if style sty like 'AM5111,and Size : "3XL" ,maker discount should be 0.74
    //if style sty like 'WM50096' ,and Size : S~ XL,maker discount should be 0.74
    try{
      if("001".equals((String)newtimes.preproduction.Constants.CURRENT_PREPROD_HEAD_RECORD.get("PROD_CEN_CODE"))&&
         82==newtimes.preproduction.Constants.CURRENT_PREPROD_HEAD_RECORD.getInt("PROD_BUYER")&&
         153==newtimes.preproduction.Constants.CURRENT_PREPROD_HEAD_RECORD.getInt("PROD_MAKER")){
        String strStyStyle =
            (String)newtimes.production.ProdMaintain_Properties.
            EDITING_STYLE_RECORD.get("sty_style");
        Object objDiscPc=
            newtimes.production.ProdMaintain_Properties.EDITING_STYLE_RECORD.get("sty_mkr_dsct_pc");
        double mkrDiscPerPc=
            (objDiscPc==null)?0:Double.parseDouble(objDiscPc.toString());

         if("AM5111".equals(strStyStyle) &&(isSizeS)&&(isSizeXL)&& mkrDiscPerPc!=0.71){
             exgui.verification.VerifyLib.showAlert(
                 "Please Adjust Maker Discount To 0.71/pc ",
                 "Please Adjust Maker Discount");
             throw new NextResponsibleIsNotReady("Maker Discount Not Correct");
         }

         if("AM5111".equals(strStyStyle) &&
            (sb.toString().equals("3XL"))&&
             mkrDiscPerPc!=0.74){
             exgui.verification.VerifyLib.showAlert(
                 "Please Adjust Maker Discount To 0.74/pc ",
                 "Please Adjust Maker Discount");
             throw new NextResponsibleIsNotReady("Maker Discount Not Correct");
         }

         if("WM50096".equals(strStyStyle)&&(isSizeS)&&(isSizeXL)&& mkrDiscPerPc!=0.74){
             exgui.verification.VerifyLib.showAlert(
                 "Please Adjust Maker Discount To 0.74/pc ",
                 "Please Adjust Maker Discount");
             throw new NextResponsibleIsNotReady("Maker Discount Not Correct");
         }


      }
    }catch(NextResponsibleIsNotReady expNotReady){
      throw expNotReady;
    }catch(Exception exp){
      exp.printStackTrace();
    }


    //switch to list of color size qty.let the show begin!!
    return nextRspOBj;
  }

  void jbInit() throws Exception {
    this.setLayout(borderLayout1);
    jLabel1.setText("Highlight The Size Item To Shift The Order");
    jPanel1.setLayout(borderLayout2);
    jPanel2.setLayout(borderLayout3);
    jPanel3.setLayout(borderLayout4);
    jPanel4.setLayout(borderLayout5);
    jPanel5.setLayout(borderLayout6);
    txtNewItem.setText("");
    btn2Add.setText("ADD Size");
    btn2Add.addActionListener(new PnlDlgShiftSizes_btn2Add_actionAdapter(this));
    btnShiftUp.addActionListener(new PnlDlgShiftSizes_btnShiftUp_actionAdapter(this));
    btnShiftDown.addActionListener(new PnlDlgShiftSizes_btnShiftDown_actionAdapter(this));
    btnDeleteSize.setFont(new java.awt.Font("Dialog", 0, 11));
    btnDeleteSize.setIcon(null);
    btnDeleteSize.setText("Delete");
    btnDeleteSize.addActionListener(new PnlDlgShiftSizes_btnDeleteSize_actionAdapter(this));
    this.add(jPanel1, BorderLayout.NORTH);
    jPanel1.add(jLabel1, BorderLayout.CENTER);
    this.add(jPanel2, BorderLayout.CENTER);
    jPanel2.add(jPanel3,  BorderLayout.CENTER);
    jPanel3.add(jScrollPane1, BorderLayout.CENTER);
    jScrollPane1.getViewport().add(jTable1, null);
    jPanel2.add(jPanel4,  BorderLayout.SOUTH);
    jPanel4.add(jPanel5, BorderLayout.CENTER);
    jPanel4.add(jPanel6, BorderLayout.WEST);
    jPanel6.add(btnDeleteSize, null);
    jPanel6.add(btnShiftUp, null);
    jPanel6.add(btnShiftDown, null);
    jPanel5.add(txtNewItem, BorderLayout.CENTER);
    jPanel5.add(btn2Add,  BorderLayout.EAST);
    btnShiftDown.setIcon(exgui.UIHelper.getIcon("down.gif"));
    btnShiftUp.setIcon(exgui.UIHelper.getIcon("up.gif"));
    jTable1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    jScrollPane1.setColumnHeader(null);
  }
  void reBuildTable(){
    jTable1=new JTable(new myTblMdl(elements2Show,columnVct));
    //jTable1.repaint();
    jScrollPane1.getViewport().add(jTable1,null);
    jTable1.setSelectionForeground(Color.CYAN);
    jScrollPane1.setColumnHeader(null);
  }
  void btn2Add_actionPerformed(ActionEvent e) {
    if(txtNewItem.getText().trim().length()>10){
      exgui.verification.VerifyLib.showPlanMsg("The Length Of Size Type is Only 10-characters",
                                               "Text Too Long");
      txtNewItem.grabFocus();
      return;
    }
   if(names.isEmpty()){
     for (int i = 0; i < elements2Show.size(); i++) {
       names.put((String)jTable1.getValueAt(i,0)  , null);
     }
   }

     if(txtNewItem.getText().trim().length()==0){
       exgui.verification.VerifyLib.showPlanMsg("Please Input Size Type","Input Please");
       txtNewItem.grabFocus();
       return;
     }else{
       String newItem=txtNewItem.getText().trim();
       if(names.containsKey(newItem)){
         exgui.verification.VerifyLib.showPlanMsg("\""+newItem+"\" Already Existed","Item Already Existed");
         return;
       }else{
         Vector tempVector=new Vector();
         tempVector.add(newItem);
         elements2Show.add(tempVector);
         names.put(newItem,null);
         reBuildTable();
         jTable1.setRowSelectionInterval(jTable1.getRowCount()-1,jTable1.getRowCount()-1);
       }
     }
  }
  class myTblMdl extends javax.swing.table.DefaultTableModel{
    myTblMdl(Vector vdata,Vector vclm){
      super(vdata,vclm);
    }
   public   boolean isCellEditable(int row,int column){
      return false;
    }
  }
  void shiftElement(int xntIndex,int nextIndex){
    if(xntIndex==-1)return;
    if(nextIndex>(elements2Show.size()-1))return;
    Object obj=this.elements2Show.remove(xntIndex);
    elements2Show.add(nextIndex,obj);
    reBuildTable();
    jTable1.setRowSelectionInterval(nextIndex,nextIndex);
  }
  void btnShiftUp_actionPerformed(ActionEvent e) {
    int xntRow=jTable1.getSelectedRow();
    int nextRow=xntRow-1;
    if(nextRow<1) nextRow=0;
    if(nextRow!=xntRow){
      shiftElement(xntRow,nextRow);
    }
  }

  void btnShiftDown_actionPerformed(ActionEvent e) {
    int xntRow=jTable1.getSelectedRow();
    int nextRow=xntRow+1;
    if(nextRow!=xntRow){
      shiftElement(xntRow,nextRow);
    }
  }

  void btnDeleteSize_actionPerformed(ActionEvent e) {
    if(jTable1.getSelectedRowCount()==0 || jTable1.getSelectedRow() ==-1){
      exgui.verification.VerifyLib.showAlert("Please Select Size To Delete",
                                             "Please Select Size To Delete");
      return;
    }
    int itemToRemove=jTable1.getSelectedRow();
        String newItem=(String)jTable1.getValueAt(itemToRemove,0);
        //tempVector.add(newItem);
        //elements2Show.add(tempVector);
        elements2Show.removeElementAt(itemToRemove);
        //names.put(newItem,null);
         names.remove(newItem);
        reBuildTable();

  }
}

class PnlDlgShiftSizes_btn2Add_actionAdapter implements java.awt.event.ActionListener {
  PnlDlgShiftSizes adaptee;

  PnlDlgShiftSizes_btn2Add_actionAdapter(PnlDlgShiftSizes adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.btn2Add_actionPerformed(e);
  }
}

class PnlDlgShiftSizes_btnShiftUp_actionAdapter implements java.awt.event.ActionListener {
  PnlDlgShiftSizes adaptee;
  PnlDlgShiftSizes_btnShiftUp_actionAdapter(PnlDlgShiftSizes adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.btnShiftUp_actionPerformed(e);
  }
}

class PnlDlgShiftSizes_btnShiftDown_actionAdapter implements java.awt.event.ActionListener {
  PnlDlgShiftSizes adaptee;

  PnlDlgShiftSizes_btnShiftDown_actionAdapter(PnlDlgShiftSizes adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.btnShiftDown_actionPerformed(e);
  }
}

class PnlDlgShiftSizes_btnDeleteSize_actionAdapter implements java.awt.event.ActionListener {
  PnlDlgShiftSizes adaptee;

  PnlDlgShiftSizes_btnDeleteSize_actionAdapter(PnlDlgShiftSizes adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.btnDeleteSize_actionPerformed(e);
  }
}
