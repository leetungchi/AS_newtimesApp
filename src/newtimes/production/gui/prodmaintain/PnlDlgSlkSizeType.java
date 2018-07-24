package newtimes.production.gui.prodmaintain;

import java.awt.*;
import javax.swing.*;
import exgui.chaindialog.*;
import java.awt.event.*;
/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class PnlDlgSlkSizeType extends JPanel implements Responsible {
  BorderLayout borderLayout1 = new BorderLayout();
  JLabel lblTitle = new JLabel();
  JScrollPane jScrollPane1 = new JScrollPane();
  JPanel pnlListSize2Slk = new JPanel();
  GridLayout gridLayout1 = new GridLayout();
  Responsible dftNextHandler=null;
  JLabel jLabel1 = new JLabel();
  JLabel jLabel2 = new JLabel();
  JLabel jLabel3 = new JLabel();

  String xntSelectedSizeItem=null;
  JComponent currentSelectedJlabel=null;
  public static String SELECTED_SIZE_TYPE_STRING=
        "newtimes.production.gui.prodmaintain.PnlDlgSlkSizeType.SELECTED_SIZE_TYPE";
  public PnlDlgSlkSizeType() {
    storedMap.clear();
  }
  void jbInit() throws Exception {
    lblTitle.setText("Please Select A Size Type,and Press Next");
    this.setLayout(borderLayout1);
    pnlListSize2Slk.setLayout(gridLayout1);
    gridLayout1.setHgap(2);
    gridLayout1.setRows(3);
    gridLayout1.setVgap(3);
    this.add(lblTitle, BorderLayout.NORTH);
    this.add(jScrollPane1, BorderLayout.CENTER);
    jScrollPane1.getViewport().add(pnlListSize2Slk, null);
  }
 public void addSizeItem(String itemString){
   JLabel lbl=new JLabel(itemString);
   lbl.setOpaque(true);
   lbl.addMouseListener(new PnlDlgSlkSizeType_jLabel1_mouseAdapter(this,lbl));
   pnlListSize2Slk.add(lbl,null);
 }
 public Responsible  next()throws exgui.chaindialog.NextResponsibleIsNotReady{
   if(xntSelectedSizeItem==null){
     exgui.verification.VerifyLib.showAlert("Please Select A Size Type","Please Select A Size Type");
    throw new NextResponsibleIsNotReady();
   }
   storedMap.put(SELECTED_SIZE_TYPE_STRING,xntSelectedSizeItem);
   return dftNextHandler;
 }
 public void setDefalutNext(Responsible dftRspbl){
   dftNextHandler=dftRspbl;
 }
 public JComponent getGUI(){
   //initialize the ejb.and filling the panel with label.
   util.PublicVariable.APP_FRAME.setCursor(new Cursor(Cursor.WAIT_CURSOR));
   try {
     DataSourceOfSizeTable mydb=new DataSourceOfSizeTable();
     jbInit();
     if(!mydb.iniOk) return null;
     java.util.List sizeItems=mydb.getSizeListString();
     gridLayout1.setRows(sizeItems.size());
     for(int i=0;i<sizeItems.size();i++){
       String itemString=(String)sizeItems.get(i);
       addSizeItem(itemString);
     }
   }
   catch(Exception ex) {
     ex.printStackTrace();
   }finally{
     util.PublicVariable.APP_FRAME.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
   }

   return this;

 }
 public boolean isAllowOkNow(){return false;}
 void jLabel1_mouseClicked(MouseEvent e) {
    if(currentSelectedJlabel!=null)
      currentSelectedJlabel.setBackground(Color.white);
    JLabel selectedLabel=(JLabel)e.getSource();
    currentSelectedJlabel=selectedLabel;
    xntSelectedSizeItem=selectedLabel.getText();
 }
}
class DataSourceOfSizeTable {
  boolean iniOk=false;
  newtimesejb.production.ColorSizeQtyFacade ejb=null;
  DataSourceOfSizeTable(){
    try{
      newtimesejb.production.ColorSizeQtyFacadeHome ejbhome=
          (newtimesejb.production.ColorSizeQtyFacadeHome)
          info_ejb.WeblogicServiceLocator.locateServiceHome(
          util.PublicVariable.SERVER_URL,"newtimesejb.production.ColorSizeQtyFacade");
      ejb=ejbhome.create();
      iniOk=true;
    }catch(Exception e){
      exgui.verification.VerifyLib.showAlert(
          "Connection Fail,Please notify System manager","EJB creaton Failure");
      iniOk=false;
    }
  }
  public java.util.List getSizeListString() throws Exception{
     java.util.Vector vct=ejb.getSizeTypes();
     java.util.ArrayList arrlist=new java.util.ArrayList();
     arrlist.add("");
     for(int i=0;i<vct.size();i++){
       database.datatype.Record rec=
           (database.datatype.Record)vct.get(i);
       StringBuffer sb=new StringBuffer();
        for(int j=0;j<rec.getFieldName().size();j++){
           Object obj=rec.get(j);
           if(obj!=null && (obj.toString().trim().length()>0)){
              if(sb.toString().trim().length()>0)sb.append(",");
              sb.append((String)obj);
           }
        }
       arrlist.add(sb.toString());
     }
     return arrlist;
  }
}
class PnlDlgSlkSizeType_jLabel1_mouseAdapter extends java.awt.event.MouseAdapter {
  PnlDlgSlkSizeType adaptee;
  JLabel xlabel;
  Color  defautlCmpBGDcolor=new Color(50,200,50);
  PnlDlgSlkSizeType_jLabel1_mouseAdapter(PnlDlgSlkSizeType adaptee,JLabel _lbl) {
    xlabel=_lbl;
    this.adaptee = adaptee;
    java.util.LinkedList lk=null;
  }
  public void mouseClicked(MouseEvent e) {
    adaptee.jLabel1_mouseClicked(e);
    xlabel.setBackground(defautlCmpBGDcolor);
  }
}
