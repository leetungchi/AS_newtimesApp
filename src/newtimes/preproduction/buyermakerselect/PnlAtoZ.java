package newtimes.preproduction.buyermakerselect;

import java.awt.*;
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

public class PnlAtoZ extends JPanel implements exgui.chaindialog.Responsible  {
  BorderLayout borderLayout1 = new BorderLayout();
  JScrollPane jScrollPane1 = new JScrollPane();
  String charAt=null;
  JLabel jLabel1 = new JLabel();
  JTable jTable1 = new JTable(6,8);
  exgui.chaindialog.Responsible defaultNext;
  JPanel PNL4HK_CODE = new JPanel();
  BorderLayout borderLayout2 = new BorderLayout();
  JPanel jPanel1 = new JPanel();
  JLabel jLabel2 = new JLabel();
  JTextField txtHkCode = new JTextField();
  public PnlAtoZ() {
    try {
      //jbInit();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }
  void jbInit() throws Exception {
    this.setLayout(borderLayout1);
    jTable1.setShowGrid(false);
    jTable1.getTableHeader().setVisible(false);
    //assign value to cell
  jTable1.setValueAt("0",0,0);jTable1.setValueAt("1",0,1);
  jTable1.setValueAt("2",0,2);jTable1.setValueAt("3",0,3);
  jTable1.setValueAt("4",0,4);jTable1.setValueAt("5",0,5);
  jTable1.setValueAt("6",0,6);jTable1.setValueAt("7",0,7);
  jTable1.setValueAt("8",1,0);jTable1.setValueAt("9",1,1);
   /*
    //nthk user can not allow to select buyer by init character.
    if(util.PublicVariable.OPERATTING_CENTER.equals("NTHK") &&
       ((String)storedMap.get(Kies.KEY_INIT_SELEC_BUYERMAKER_TYPE_NAME)).equalsIgnoreCase("BUYER")){
      jTable1.setValueAt("NONE", 1,2);
    }else{
      int lastRowAt = 2, lastColumnAt = 0;
      for (int i = 'A'; i < ('Z' + 1); i++) {
        int countAt = i - 'A';
        jTable1.setValueAt(new String(new byte[] {(byte)i}), (countAt / 8) + 2,
                           countAt % 8);
        lastRowAt = (countAt / 8) + 2;
        lastColumnAt = countAt % 8;
      }
      jTable1.setValueAt("NONE", lastRowAt, lastColumnAt + 1);

    }
    */
   int lastRowAt = 2, lastColumnAt = 0;
   for (int i = 'A'; i < ('Z' + 1); i++) {
     int countAt = i - 'A';
     jTable1.setValueAt(new String(new byte[] {(byte)i}), (countAt / 8) + 2,
                        countAt % 8);
     lastRowAt = (countAt / 8) + 2;
     lastColumnAt = countAt % 8;
   }
   jTable1.setValueAt("NONE", lastRowAt, lastColumnAt + 1);


    jTable1.addMouseListener(new PnlAtoZ_jTable1_mouseAdapter(this));
    PNL4HK_CODE.setLayout(borderLayout2);
    PNL4HK_CODE.setMinimumSize(new Dimension(100, 100));
    jLabel2.setFont(new java.awt.Font("Dialog", 1, 11));
    jLabel2.setForeground(Color.red);
    jLabel2.setText("Direct Query By HK CODE:");
    jLabel2.setBounds(new Rectangle(7, 7, 166, 22));
    txtHkCode.setText("");
    txtHkCode.setBounds(new Rectangle(174, 8, 119, 23));
    jPanel1.setLayout(null);
    jPanel1.setPreferredSize(new Dimension(69, 33));
    this.add(jScrollPane1,  BorderLayout.CENTER);
    this.add(jLabel1, BorderLayout.NORTH);
    if(!util.PublicVariable.OPERATTING_CENTER.equals("001")){
      this.add(PNL4HK_CODE, BorderLayout.SOUTH);
    }
    PNL4HK_CODE.add(jPanel1,  BorderLayout.CENTER);
    jPanel1.add(jLabel2, null);
    jPanel1.add(txtHkCode, null);
    jScrollPane1.getViewport().add(jTable1, null);

  }
  public javax.swing.JComponent getGUI(){
    jLabel1.setText("Please Select The Initial Character of "+storedMap.get(Kies.KEY_INIT_SELEC_BUYERMAKER_TYPE_NAME));
    return this;
  }
  public boolean isAllowOkNow(){
      if(charAt.equals("NONE")) return true;
      return false;

    }
  public exgui.chaindialog.Responsible  next() throws exgui.chaindialog.NextResponsibleIsNotReady{
    if(charAt==null && txtHkCode.getText().trim().length()==0){
      exgui.verification.VerifyLib.showAlert(
          "please select a charactor",
          "pleaes select a charactor"
      );
      throw new exgui.chaindialog.NextResponsibleIsNotReady();
    }else{
      if(charAt!=null && charAt.equals("NONE")){
         storedMap.put(Kies.KEY_SELECTED_BUYER_MAKER_RECORD,null);
         storedMap.put(Kies.KEY_SELECTED_BUYER_MAKER_SEQ,null);
        return null;
     }
      if(txtHkCode.getText().trim().length()>0){
        storedMap.put(Kies.KEY_INIT_CHAR_OF_BUYERMAKER,null);
        storedMap.put(Kies.KEY_INIT_SELECT_HK_CODE,txtHkCode.getText().trim());
      }else{
        storedMap.put(Kies.KEY_INIT_SELECT_HK_CODE,null);
        storedMap.put(Kies.KEY_INIT_CHAR_OF_BUYERMAKER,charAt);
      }
      return defaultNext;
    }
  }
  public void setDefalutNext(exgui.chaindialog.Responsible dftNext){
    defaultNext=dftNext;
  }
  void jTable1_mouseClicked(MouseEvent e) {
    Object v= jTable1.getValueAt(jTable1.getSelectedRow(),jTable1.getSelectedColumn());
    if(v==null||v.toString().trim().equals("")){
      charAt=null;
    }else{
      charAt=v.toString();
      txtHkCode.setText("");
    }
  }
}

class PnlAtoZ_jTable1_mouseAdapter extends java.awt.event.MouseAdapter {
  PnlAtoZ adaptee;
  PnlAtoZ_jTable1_mouseAdapter(PnlAtoZ adaptee) {
    this.adaptee = adaptee;
  }
  public void mouseClicked(MouseEvent e) {
    adaptee.jTable1_mouseClicked(e);
  }
}

