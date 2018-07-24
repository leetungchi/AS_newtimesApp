package newtimes.preproduction.buyermakerselect;
import javax.swing.*;
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

public class PnlListMtrlDtl extends PnlListBuyerMaker {
  protected int buyermakerSeq=0;
  public PnlListMtrlDtl(newtimesejb.preproduction.BuyerMaker ejb2Run,int iniBuyerMakerSeq) {
     super(ejb2Run);
     buyermakerSeq=iniBuyerMakerSeq;
  }
  public javax.swing.JComponent getGUI(){
    //refresh all the jlist data...
    //common process to set cursor...
    javax.swing.JDialog  jframe=(javax.swing.JDialog)super.storedMap.get(Kies.KEY_DLG_OBJ);
    java.awt.Cursor ksr=jframe.getContentPane().getCursor();
    try{
      jframe.getContentPane().setCursor(new java.awt.Cursor(java.awt.Cursor.WAIT_CURSOR));
      isInitNow = true;
      jList1.removeAll();
      java.util.Set set = storedMap.keySet();
      java.util.Iterator itr = set.iterator();
      java.util.Vector vct = ejb.getMaterialDetails(buyermakerSeq);
      records.removeAllElements();
      DefaultListModel listMdl = new DefaultListModel();
      listMdl.clear();
      for (int i = 0; i < vct.size(); i++) {
        Record rec = (Record) vct.get(i);
        String title="Material NO:"+(String) rec.get("MTRDTL_MTR_NO")+"  Mill NO:"+(String) rec.get("MTRDTL_MILL_NO");
        listMdl.add(i,title);
        records.add(rec);
      }
      jList1.setModel(listMdl);
      isInitNow = false;
      if(records.size()>0) jList1.setSelectedIndex(0);
      return this;
    }catch(Exception e){
       e.printStackTrace();
       return null;
     }finally{
       jframe.getContentPane().setCursor(ksr);
     }
  }
  public void  valueChanged(ListSelectionEvent e){
        if(!isInitNow){
          storedMap.put(Kies.KEY_SELECTED_MATERIAL_DETAIL_RECORD,(Record)records.get(jList1.getSelectedIndex()));
        }
  }

}