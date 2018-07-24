package newtimes.preproduction.buyermakerselect;

import javax.swing.*;
import java.awt.*;
import exgui.*;
import java.util.*;
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

public class SelectMtrlDtl4MtrVPreProd extends javax.swing.JPanel implements exgui.chaindialog.Responsible
{
  GridLayout gridLayout1 = new GridLayout();
  exgui.chaindialog.Responsible defaultNext;
  final HashMap hm_SelectedRecords=new HashMap();
  JPanel jPanel1 = new JPanel();
  JScrollPane jScrollPane1 = new JScrollPane();
  JList listSelected = new JList();
  JLabel whiteBkgBlueCharLabel1 = new JLabel();
  JLabel blueBkgWhiteCharLabel1 = new JLabel();
  JPanel jPanel2 = new JPanel();
  JScrollPane jScrollPane2 = new JScrollPane();
  JList listUnSelected = new JList();
  JLabel jLabel1 = new JLabel();
  JLabel jLabel2 = new JLabel();

  public SelectMtrlDtl4MtrVPreProd() {
     hm_SelectedRecords.clear();
    try {
      jbInit();
    }
    catch(Exception e) {
      e.printStackTrace();
    }
  }
  private void jbInit() throws Exception {
    this.setDebugGraphicsOptions(0);
    this.setLayout(gridLayout1);
    gridLayout1.setColumns(1);
    gridLayout1.setRows(2);
    jPanel1.setLayout(null);
    jScrollPane1.setBounds(new Rectangle(11, 36, 492, 107));
    listSelected.setToolTipText("Double click to un-select the meterial item");
    listSelected.addMouseListener(new SelectMtrlDtl4MtrVPreProd_listSelected_mouseAdapter(this));
    listSelected.addMouseListener(new SelectMtrlDtl4MtrVPreProd_listSelected_mouseAdapter(this));
    whiteBkgBlueCharLabel1.setText("Selected Materials");
    whiteBkgBlueCharLabel1.setBounds(new Rectangle(10, 8, 111, 24));
    blueBkgWhiteCharLabel1.setText("Metrail Detail Datas");
    blueBkgWhiteCharLabel1.setBounds(new Rectangle(12, 0, 114, 27));
    jPanel2.setLayout(null);
    jScrollPane2.setBounds(new Rectangle(12, 32, 485, 107));
    listUnSelected.setToolTipText("Double click to select the meterial item");
    listUnSelected.addMouseListener(new SelectMtrlDtl4MtrVPreProd_listUnSelected_mouseAdapter(this));
    listUnSelected.addMouseListener(new SelectMtrlDtl4MtrVPreProd_listUnSelected_mouseAdapter(this));
    listUnSelected.addMouseListener(new SelectMtrlDtl4MtrVPreProd_listUnSelected_mouseAdapter(this));
    jLabel1.setForeground(Color.red);
    jLabel1.setText("Double Click The Material  Item To Select");
    jLabel1.setBounds(new Rectangle(134, 0, 223, 27));
    jLabel2.setForeground(Color.red);
    jLabel2.setText("Double Click The Item To Un-select");
    jLabel2.setBounds(new Rectangle(128, 8, 220, 24));
    this.add(jPanel1, null);
    jPanel1.add(jScrollPane1, null);
    jPanel1.add(whiteBkgBlueCharLabel1, null);
    jPanel1.add(jLabel2, null);
    jScrollPane1.getViewport().add(listSelected, null);
    this.add(jPanel2, null);
    jPanel2.add(blueBkgWhiteCharLabel1, null);
    jPanel2.add(jScrollPane2, null);
    jPanel2.add(jLabel1, null);
    jScrollPane2.getViewport().add(listUnSelected, null);
  }
  protected void display2JList(JList jlist,Vector records,HashMap rec2Map){
    //jlist.removeListSelectionListener(this);
    jlist.clearSelection();
    jlist.removeAll();
    javax.swing.DefaultListModel mdl=new javax.swing.DefaultListModel();
    for(int i=0;i<records.size();i++){
      database.datatype.Record rec=(database.datatype.Record)records.get(i);
      WrapperRecord recWrap=new WrapperRecord(rec);
      mdl.addElement(recWrap);
      if(rec2Map!=null)rec2Map.put(recWrap.toString(),rec);
    }
    jlist.setModel(mdl);
    //jlist.addListSelectionListener(this);
  }
  public boolean isAllowOkNow(){return true;}
  public void  valueChanged(MouseEvent e){
     //to determ how to add data...
     if(e.getSource()==listSelected){
       //call to remove selected record.
      int index=listSelected.getSelectedIndex();
      Object obj=listSelected.getSelectedValue();
      if(obj==null)return;
      System.out.println("click Obj is:"+obj);
      hm_SelectedRecords.remove(obj.toString());
      ((DefaultListModel)listSelected.getModel()).removeElement(obj);
     }else{
       int index=listUnSelected.getSelectedIndex();
       WrapperRecord obj=(WrapperRecord)listUnSelected.getSelectedValue();
       //((DefaultListModel)listUnSelected.getModel()).removeElementAt(index);
      Object objReplaced=hm_SelectedRecords.put(obj.toString(),obj.getOrgRecord());
      //this action is add a new elements..
      if(objReplaced==null){
        ((DefaultListModel)listSelected.getModel()).addElement(obj);
      }
     }
  }
  public void setSelectedMtrlDtl(Vector selectedMtrlDtlRecs2){
    display2JList(listSelected, selectedMtrlDtlRecs2,hm_SelectedRecords);
  }
  protected void makeList4Select(Vector mtrlDtlRecs2Select){
    display2JList(listUnSelected,mtrlDtlRecs2Select,null);
  }
  public javax.swing.JComponent getGUI(){
   //return this;
   //call the ejb to select meterial detail data with an initial charactor.

   javax.swing.JDialog jframe=(javax.swing.JDialog)this.storedMap.get(Kies.KEY_DLG_OBJ);
   java.awt.Cursor ksr=jframe.getContentPane().getCursor();

   try{
     jframe.getContentPane().setCursor(new java.awt.Cursor(java.awt.Cursor.WAIT_CURSOR));
     newtimesejb.preproduction.BuyerMakerHome  ejbHome=
     (newtimesejb.preproduction.BuyerMakerHome)info_ejb.WeblogicServiceLocator.locateServiceHome(
        util.PublicVariable.SERVER_URL,("newtimesejb.preproduction.BuyerMaker")
        );
     newtimesejb.preproduction.BuyerMaker ejb=ejbHome.create();
     //select by the initial character ,target on column
     Vector recs=ejb.getMtrlDtlByChar("MTRDTL_MTR_NO",(String) storedMap.get(Kies.
          KEY_INIT_CHAR_OF_BUYERMAKER));
      makeList4Select(recs);
      storedMap.put(Kies.KESY_HM_SELECTED_MATERIAL_DETAIL_RECORDS,hm_SelectedRecords);
     return this;
   }catch(java.rmi.RemoteException re){
    exgui.verification.VerifyLib.showAlert(
        "Remote Connection fail,please try again latter","Server Connection Fail"
    );
    return null;
   }catch(Exception e){
     e.printStackTrace();
     return null;
   }finally{
     jframe.getContentPane().setCursor(ksr);
   }

 }
 public exgui.chaindialog.Responsible  next() throws exgui.chaindialog.NextResponsibleIsNotReady{
   return defaultNext;
 }
 public void setDefalutNext(exgui.chaindialog.Responsible dftNext){
   defaultNext=dftNext;
 }
protected class WrapperRecord{
   protected database.datatype.Record orgRecord;
   WrapperRecord(database.datatype.Record rec2Rap){
      orgRecord=rec2Rap;
   }
   public Object getPK(){return orgRecord.get(0);}
   public database.datatype.Record getOrgRecord(){return orgRecord;}
   public String toString(){
    return "Material NO:"+orgRecord.get(1)+",Mill NO:"+orgRecord.get(2);
   }
   public boolean equals(Object obj2Cmp){
     if(obj2Cmp==null)return false;
     if(obj2Cmp instanceof WrapperRecord){
       if(((WrapperRecord)obj2Cmp).toString().equals(toString())){
         return true;
       }
     }
     return false;
   }
 }

  void listUnSelected_mouseClicked(MouseEvent e) {
   if(e.getClickCount()==2){
     valueChanged(e);
   }
  }

  void listSelected_mouseClicked(MouseEvent e) {
    if(e.getClickCount()==2){
       valueChanged(e);
    }

  }
}

class SelectMtrlDtl4MtrVPreProd_listSelected_mouseAdapter extends java.awt.event.MouseAdapter {
  SelectMtrlDtl4MtrVPreProd adaptee;

  SelectMtrlDtl4MtrVPreProd_listSelected_mouseAdapter(SelectMtrlDtl4MtrVPreProd adaptee) {
    this.adaptee = adaptee;
  }
  public void mouseClicked(MouseEvent e) {
    adaptee.listSelected_mouseClicked(e);
  }
}

class SelectMtrlDtl4MtrVPreProd_listUnSelected_mouseAdapter extends java.awt.event.MouseAdapter {
  SelectMtrlDtl4MtrVPreProd adaptee;

  SelectMtrlDtl4MtrVPreProd_listUnSelected_mouseAdapter(SelectMtrlDtl4MtrVPreProd adaptee) {
    this.adaptee = adaptee;
  }
  public void mouseClicked(MouseEvent e) {
    adaptee.listUnSelected_mouseClicked(e);
  }
}
