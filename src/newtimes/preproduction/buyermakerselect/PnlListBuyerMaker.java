package newtimes.preproduction.buyermakerselect;

import java.awt.*;
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

public class PnlListBuyerMaker extends JPanel
    implements exgui.chaindialog.Responsible,ListSelectionListener{
  BorderLayout borderLayout1 = new BorderLayout();
  exgui.chaindialog.Responsible nextExecuter;
  database.datatype.Record recSelected;
  JList jList1 = new myList();
  newtimesejb.preproduction.BuyerMaker ejb;
  boolean isInitNow=false;
  java.util.Vector records=new java.util.Vector();
  JScrollPane jScrollPane1 = new JScrollPane();
  int lastRecIndex=-1;
  String lastToolTipsText="";
  java.util.HashMap hmFullNameAndAddRess=new java.util.HashMap();
  public PnlListBuyerMaker(newtimesejb.preproduction.BuyerMaker ejb2Run) {
    try {
       ejb=ejb2Run;
       jbInit();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }
  void jbInit() throws Exception {
    this.setLayout(borderLayout1);
    jList1.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
    //jList1.setCellRenderer(new MyCellRdr());
    this.add(jScrollPane1, BorderLayout.CENTER);
    jScrollPane1.getViewport().add(jList1,null);
    jList1.addListSelectionListener(this);

  }
  public void  valueChanged(ListSelectionEvent e){
        if(!isInitNow){
          //System.out.println("get record:"+((Record)records.get(jList1.getSelectedIndex())).toString());
          storedMap.put(Kies.KEY_SELECTED_BUYER_MAKER_RECORD,(Record)records.get(jList1.getSelectedIndex()));
          storedMap.put(Kies.KEY_SELECTED_BUYER_MAKER_SEQ,((Record)records.get(jList1.getSelectedIndex())).get(0));
        }
  }
  public void setEJB(newtimesejb.preproduction.BuyerMaker buyermakerEJB){
     ejb=buyermakerEJB;
  }
  public boolean isAllowOkNow(){return true;}

  public void setDefalutNext(exgui.chaindialog.Responsible theNext){
    nextExecuter=theNext;
  }
  public javax.swing.JComponent getGUI(){
    //refresh all the jlist data...
    //javax.swing.JFrame jframe=util.PublicVariable.APP_FRAME;
    javax.swing.JDialog dlg=(javax.swing.JDialog)storedMap.get(Kies.KEY_DLG_OBJ);
    java.awt.Cursor ksr=dlg.getContentPane().getCursor();

    try{
      dlg.getContentPane().setCursor(new java.awt.Cursor(java.awt.Cursor.WAIT_CURSOR));
      isInitNow = true;
      jList1.removeAll();
      java.util.Set set = storedMap.keySet();
      //java.util.Iterator itr = set.iterator();
      java.util.Vector vct = ejb.getByrMkr(
          (String) storedMap.get(Kies.KEY_INIT_SELEC_BUYERMAKER_TYPE),
          ((String) storedMap.get(Kies.KEY_INIT_CHAR_OF_BUYERMAKER)).charAt(0),
          (String) storedMap.get(Kies.KESY_HM_SELECTING_CENTER_CODE));
      records.removeAllElements();
      DefaultListModel listMdl = new DefaultListModel();
      listMdl.clear();
      boolean isTpeUser=util.PublicVariable.OPERATTING_CENTER.equals("001");
      for (int i = 0; i < vct.size(); i++) {
        Record rec = (Record) vct.get(i);
        if(!isTpeUser){
          String key2PreventDuplicate = ((String)rec.get(1)).trim().toUpperCase();
          for (int j = 15; j < 19; j++) if (rec.get(j) != null)key2PreventDuplicate += rec.get(j).toString().trim().toUpperCase();
            //for none tpe center,check if duplicate full name & address
          if (hmFullNameAndAddRess.containsKey(key2PreventDuplicate))continue;
          hmFullNameAndAddRess.put(key2PreventDuplicate,key2PreventDuplicate);
        }

        String bymkrChnName=(String)rec.get("BYMKR_CHINESE_BRIEF");
        StringBuffer sb=new StringBuffer();
        if(isTpeUser){
          sb.append((String)rec.get("bymkr_brief"));
          if (bymkrChnName != null) {
            sb.append("  ");
            sb.append(bymkrChnName);
          }
        }else{
          sb.append(bymkrChnName);
          sb.append("    ");
          sb.append((String)rec.get("bymkr_brief"));
        }

        listMdl.add(i,sb.toString());
        records.add(rec);
      }
      jList1.setModel(listMdl);
      isInitNow = false;
      if(records.size()>0) jList1.setSelectedIndex(0);
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
       dlg.getContentPane().setCursor(ksr);
     }
  }
  protected class MyCellRdr extends JPanel implements javax.swing.ListCellRenderer{
    MyCellRdr(){
      this.setLayout(new java.awt.BorderLayout());
    }
    public Component getListCellRendererComponent(
             JList list,
             Object value,
             int index,
             boolean isSelected,
             boolean cellHasFocus)
         {
            String[] strOfValue=util.MiscFunc.split(value.toString(),"  ");
            System.out.println("value is:"+value.toString());
             JLabel lbl1=new JLabel(strOfValue[0]);
             lbl1.setForeground(Color.CYAN);
             this.add(lbl1,java.awt.BorderLayout.WEST);
             if(strOfValue.length>1){
               lbl1.setForeground(Color.BLUE);
               JLabel lbl2 = new JLabel(strOfValue[1]);
               this.add(lbl2,java.awt.BorderLayout.EAST);
             }
             if (isSelected) {
                         setBackground(list.getSelectionBackground());
                         setForeground(list.getSelectionForeground());
                     } else {
                         setBackground(list.getBackground());
                         setForeground(list.getForeground());
              }
              setBorder(UIManager.getBorder("List.focusCellHightlightBorder"));
             //setBackground(isSelected ? Color.red : Color.white);
             //setForeground(isSelected ? Color.white : Color.black);
             return this;
         }

  }
  public exgui.chaindialog.Responsible  next() throws exgui.chaindialog.NextResponsibleIsNotReady{
      return nextExecuter;//this is an end nod of responsibility.
  }
  class myList extends JList{
    public myList(){super();}
    public String getToolTipText(java.awt.event.MouseEvent me){
     int index= super.locationToIndex(me.getPoint());
     if(index>super.getModel().getSize()) return "";
     if(index==lastRecIndex)return lastToolTipsText;
     Record rec=(Record)records.get(index);
     StringBuffer sb=new StringBuffer();
     String fullName=(String) rec.get(1);
     String hkCode=(String) rec.get(14);

     sb.append("<html><body>");
     sb.append(fullName);
     if(hkCode!=null && (!hkCode.toUpperCase().trim().equals("NULL"))){
       sb.append("<br>");
       sb.append("HK CODE:");sb.append(hkCode);
     }
     sb.append("<br>");
     for (int i = 15; i < 19; i++) {
       String tmpstr = (String)rec.get(i);
       if (tmpstr != null && (!tmpstr.toUpperCase().trim().equals("NULL"))){
          sb.append(tmpstr);
          if(i!=18)sb.append("<br>");
       }
     }
     sb.append("</body></html>");
     lastToolTipsText=sb.toString();
     return lastToolTipsText;
   }
  }
}
