package newtimes.preproduction.buyermakerselect;

import exgui.DataBindTextWithChecker;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.*;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class SelectSingleMaterialDetail extends DataBindTextWithChecker {
  Object value2Return=null;
  TitledBorder titledBorder1;
  BorderLayout borderLayout1 = new BorderLayout();
  JTextField jLabel1 = new JTextField();
  JButton jButton1 = new JButton();
  public SelectSingleMaterialDetail() {
    try {
      jbInit();
    }
    catch(Exception e) {
      e.printStackTrace();
    }
  }
  private void jbInit() throws Exception {

    titledBorder1 = new TitledBorder("");
    jLabel1.setBackground(Color.lightGray);
    jLabel1.setBorder(BorderFactory.createLoweredBevelBorder());
    jLabel1.setText("");
    jLabel1.setEditable(false);
    this.setLayout(borderLayout1);
    jButton1.setFont(new java.awt.Font("Dialog", 1, 11));
    jButton1.setMaximumSize(new Dimension(43, 23));
    jButton1.setMargin(new Insets(0, 3, 0, 3));
    jButton1.setText("...");
    jButton1.addActionListener(new SelectSingleMaterialDetail_jButton1_actionAdapter(this));
    this.setBackground(Color.lightGray);
    this.add(jLabel1, BorderLayout.CENTER);
    this.add(jButton1,  BorderLayout.EAST);

  }
  public void setIniValue(String columnName,Object orgValue){
    value2Return=orgValue;
    _match2RecField =columnName;
  }
  public String getOrgRecField(){
           return _match2RecField;
  }
  public JComponent getGUIcomponent(){return this.jLabel1;}
  public boolean isValidx(){
     return true;
  }
  public Object getSelectedValue(){
    return value2Return;
  }
  void jButton1_actionPerformed(ActionEvent e) {
    PnlKeyWordSlkMtrDtl pnlInit=new PnlKeyWordSlkMtrDtl();
    PnlMtrlSingleSelection  pnlMtrlDtl=new  PnlMtrlSingleSelection();
    PnlMtrlSingleSelection pnl=new PnlMtrlSingleSelection();
    pnlInit.setDefalutNext(pnl);
    DlgSelectBuyerMaker dlg=new DlgSelectBuyerMaker(
        util.PublicVariable.APP_FRAME,"select Material Data",true,pnlInit);
    dlg.setSize(500,400);
    exgui.UIHelper.setToScreenCenter(dlg);
    pnlInit.storedMap.put(Kies.KEY_INIT_SELEC_BUYERMAKER_TYPE_NAME,"Material No.");//select buyer maker type is 2---maker.
    dlg.show();
    if(dlg.getDialogStatus()==dlg.DIALOG_OK){
      //System.out.println("reslut is:"+dlg.getDialogResult());
      if(((java.util.HashMap)dlg.getDialogResult()).get(Kies.KEY_SELECTED_MATERIAL_DETAIL_RECORD)!=null){
       database.datatype.Record rec=
        (database.datatype.Record)((java.util.HashMap)dlg.getDialogResult()).get(Kies.KEY_SELECTED_MATERIAL_DETAIL_RECORD);
         jLabel1.setText((String)rec.get(1));
         value2Return=rec.get(0);
      }else{
        jLabel1.setText("");
        value2Return=null;
      }
    }else{
      jLabel1.setText("");
      value2Return=null;
    }

  }

}

class SelectSingleMaterialDetail_jButton1_actionAdapter implements java.awt.event.ActionListener {
  SelectSingleMaterialDetail adaptee;

  SelectSingleMaterialDetail_jButton1_actionAdapter(SelectSingleMaterialDetail adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.jButton1_actionPerformed(e);
  }
}
