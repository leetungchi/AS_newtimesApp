package newtimes.preproduction.buyermakerselect;
import java.awt.*;
import javax.swing.*;
import java.util.Vector;
import database.datatype.Record;
import javax.swing.event.*;
/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class PnlMtrlSingleSelection extends JPanel implements
     exgui.chaindialog.Responsible,javax.swing.event.ListSelectionListener

{
  JScrollPane jScrollPane1 = new JScrollPane();
  JList listMtrlDtl = new JList();
  exgui.chaindialog.Responsible defaultNext=null;
  java.util.Vector storedRecords=new java.util.Vector();
  boolean isInitNow=false;
  public PnlMtrlSingleSelection() {
    try {
      jbInit();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }
  void jbInit() throws Exception {
    this.setLayout(null);
    jScrollPane1.setBounds(new Rectangle(27, 18, 336, 153));
    this.add(jScrollPane1, null);
    jScrollPane1.getViewport().add(listMtrlDtl, null);
    listMtrlDtl.addListSelectionListener(this);
  }
  public void  valueChanged(ListSelectionEvent e){
        if(!isInitNow){
          storedMap.put(Kies.KEY_SELECTED_MATERIAL_DETAIL_RECORD,
                        ((Record)storedRecords.get(listMtrlDtl.getSelectedIndex())));
        }
  }

  protected void initList(Vector vct)throws Exception{
    isInitNow=true;
    storedRecords.removeAllElements();
    DefaultListModel listMdl = new DefaultListModel();
    listMdl.clear();
    for (int i = 0; i < vct.size(); i++) {
      Record rec = (Record) vct.get(i);
      String title="Material NO:"+(String) rec.get("MTRDTL_MTR_NO")+"  Mill NO:"+(String) rec.get("MTRDTL_MILL_NO");
      listMdl.add(i,title);
      storedRecords.add(rec);
    }
    listMtrlDtl.setModel(listMdl);
    isInitNow = false;
    if(storedRecords.size()>0) listMtrlDtl.setSelectedIndex(0);

  }
  public javax.swing.JComponent getGUI(){
    //return this;
    //if this gui can not get any data from ejb,return null;
    javax.swing.JDialog jframe=(javax.swing.JDialog)storedMap.get(Kies.KEY_DLG_OBJ);
    java.awt.Cursor ksr=jframe.getContentPane().getCursor();
    try{
      jframe.getContentPane().setCursor(new java.awt.Cursor(java.awt.Cursor.WAIT_CURSOR));
      newtimesejb.preproduction.BuyerMakerHome ejbhome=
        (newtimesejb.preproduction.BuyerMakerHome)
         info_ejb.WeblogicServiceLocator.locateServiceHome(util.PublicVariable.SERVER_URL,
         "newtimesejb.preproduction.BuyerMaker");
      newtimesejb.preproduction.BuyerMaker ejb=ejbhome.create();
      Vector records=ejb.getMtrlDtlByChar("MTRDTL_MTR_NO",(String) storedMap.get(Kies.
          KEY_INIT_CHAR_OF_BUYERMAKER));
      initList(records);
      return this;
    }catch(Exception e){
      exgui.verification.VerifyLib.showAlert(
          "Server Side Connection Fail", "Server Side Connection Fail"
      );
      e.printStackTrace();
      return null;
    }finally{
      jframe.getContentPane().setCursor(ksr);
    }
  }
  public boolean isAllowOkNow(){return true;}
  public exgui.chaindialog.Responsible  next() throws exgui.chaindialog.NextResponsibleIsNotReady{
    return defaultNext;
  }

 public void setDefalutNext(exgui.chaindialog.Responsible dftNext) {
  defaultNext = dftNext;
 }

}