package newtimes.production.gui.prodmaintain;
import exgui.chaindialog.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;
import java.awt.event.*;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class PnlDlgChzStyQtyType extends JPanel
    implements Responsible{
  GridLayout gridLayout1 = new GridLayout();
  JCheckBox chkLicensee = new JCheckBox();
  JCheckBox chkSize = new JCheckBox();
  JCheckBox chkColor = new JCheckBox();
  JCheckBox chkQTY = new JCheckBox();
  protected byte statusOfChecked=0;
  protected byte onLicensee=1;
  //protected byte offLicensee=(byte)(0xfe);
  protected byte onSize=2;
  //protected byte offSize=(byte)0xfd;
  protected byte onColor=4;
  //protected byte offColor=(byte)0xfb;
  protected byte onQtyOnly=8;
  Responsible next2Rsp=null;
  public static String INTEGER_KEY_OF_SELECTED_COLORLICENSEE_SIZE_TYPE="INTEGER_KEY_OF_SELECTED_COLORLICENSEE_SIZE_TYPE";
  public PnlDlgChzStyQtyType() {
    try {
      jbInit();
      storedMap.clear();
    }catch(Exception ex) {
      ex.printStackTrace();
    }
  }
  void jbInit() throws Exception {
    chkColor.setText("COLOR");
    //chkColor.setSelected(true);
    //chkColor.setEnabled(false);
    chkColor.addItemListener(new PnlDlgChzStyQtyType_chkColor_itemAdapter(this));
    chkSize.setText("SIZE");
    chkSize.addItemListener(new PnlDlgChzStyQtyType_chkSize_itemAdapter(this));
    chkLicensee.setText("LICENSEE");
    chkLicensee.addItemListener(new PnlDlgChzStyQtyType_chkLicensee_itemAdapter(this));
    this.setLayout(gridLayout1);
    gridLayout1.setColumns(1);
    gridLayout1.setRows(4);
    chkQTY.setText("QTY Only,No Sizes Selection");
    chkQTY.addItemListener(new PnlDlgChzStyQtyType_chkQTY_itemAdapter(this));
    this.add(chkQTY, null);
    this.add(chkLicensee, null);
    this.add(chkSize, null);
    this.add(chkColor, null);
    chkColor_itemStateChanged(null);
  }

  public JComponent getGUI(){
    return this;
  }
 public void setDefalutNext(Responsible dfltRsp){
   next2Rsp=dfltRsp;
 }
 public Responsible next()throws NextResponsibleIsNotReady{
   if(statusOfChecked==0){
     exgui.verification.VerifyLib.showAlert("Please Select At Least An Item","Please Select An Item");
     throw new NextResponsibleIsNotReady();
   }else{
     try{
       storedMap.put(INTEGER_KEY_OF_SELECTED_COLORLICENSEE_SIZE_TYPE,
                     new Integer(statusOfChecked));
       if ((statusOfChecked & 2) == 0) {
         return null;
       }
       return next2Rsp;
     }catch(Exception e){
       e.printStackTrace();
       return null;
     }
   }
 }


  void chkQTY_itemStateChanged(ItemEvent e) {
    //chkQTY_stateChanged(null);
    if(chkQTY.isSelected()){
      statusOfChecked |=onQtyOnly;
      //chkLicensee.setSelected(false);chkLicensee.setEnabled(false);
      //chkColor.setSelected(false);chkColor.setEnabled(false);
      chkSize.setSelected(false);
      //chkSize.setEnabled(false);
    }else{
      statusOfChecked &=(~onQtyOnly);
      //chkLicensee.setSelected(false);chkLicensee.setEnabled(true);
      //chkColor.setSelected(false);chkColor.setEnabled(true);
      chkSize.setSelected(true);
      //chkSize.setEnabled(true);
    }
  }

  void chkLicensee_itemStateChanged(ItemEvent e) {
    if(chkLicensee.isSelected()){
        statusOfChecked |=onLicensee;
    }else{
       statusOfChecked &=(~onLicensee);
    }
    //System.out.println("status of check is:"+Integer.toBinaryString(statusOfChecked));
  }

  void chkSize_itemStateChanged(ItemEvent e) {
    if(chkSize.isSelected()){
        statusOfChecked |=onSize;
        chkQTY.setSelected(false);
    }else{
       statusOfChecked &=(~onSize);
       chkQTY.setSelected(true);
    }
    //System.out.println("status of check is:"+Integer.toBinaryString(statusOfChecked));
  }

  void chkColor_itemStateChanged(ItemEvent e) {
    if(chkColor.isSelected()){
        statusOfChecked |=onColor;
    }else{
       statusOfChecked &=(~onColor);

    }
    //System.out.println("status of check is:"+Integer.toBinaryString(statusOfChecked));
  }

  public boolean isAllowOkNow(){
   if(statusOfChecked==0) return false; //at least,select on qty size type.
   return (statusOfChecked&2)==0;
  }
}


class PnlDlgChzStyQtyType_chkQTY_itemAdapter implements java.awt.event.ItemListener {
  PnlDlgChzStyQtyType adaptee;

  PnlDlgChzStyQtyType_chkQTY_itemAdapter(PnlDlgChzStyQtyType adaptee) {
    this.adaptee = adaptee;
  }
  public void itemStateChanged(ItemEvent e) {
    adaptee.chkQTY_itemStateChanged(e);
  }
}

class PnlDlgChzStyQtyType_chkLicensee_itemAdapter implements java.awt.event.ItemListener {
  PnlDlgChzStyQtyType adaptee;

  PnlDlgChzStyQtyType_chkLicensee_itemAdapter(PnlDlgChzStyQtyType adaptee) {
    this.adaptee = adaptee;
  }
  public void itemStateChanged(ItemEvent e) {
    adaptee.chkLicensee_itemStateChanged(e);
  }
}

class PnlDlgChzStyQtyType_chkSize_itemAdapter implements java.awt.event.ItemListener {
  PnlDlgChzStyQtyType adaptee;

  PnlDlgChzStyQtyType_chkSize_itemAdapter(PnlDlgChzStyQtyType adaptee) {
    this.adaptee = adaptee;
  }
  public void itemStateChanged(ItemEvent e) {
    adaptee.chkSize_itemStateChanged(e);
  }
}

class PnlDlgChzStyQtyType_chkColor_itemAdapter implements java.awt.event.ItemListener {
  PnlDlgChzStyQtyType adaptee;

  PnlDlgChzStyQtyType_chkColor_itemAdapter(PnlDlgChzStyQtyType adaptee) {
    this.adaptee = adaptee;
  }
  public void itemStateChanged(ItemEvent e) {
    adaptee.chkColor_itemStateChanged(e);
  }
}
