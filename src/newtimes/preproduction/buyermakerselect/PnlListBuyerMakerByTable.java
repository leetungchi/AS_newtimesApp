package newtimes.preproduction.buyermakerselect;
import java.util.*;
import javax.swing.*;
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

public class PnlListBuyerMakerByTable extends JPanel
    implements exgui.chaindialog.Responsible{
  BorderLayout borderLayout1 = new BorderLayout();
  exgui.chaindialog.Responsible nextExecuter;
  newtimesejb.preproduction.BuyerMaker ejb;
  boolean isInitNow=false;
  BuyerMakerTbl tblList=null;
  //java.util.HashMap hmFullNameAndAddRess=new java.util.HashMap();

  public PnlListBuyerMakerByTable(newtimesejb.preproduction.BuyerMaker ejb2Run) {
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
  }
 public javax.swing.JComponent getGUI(){
   javax.swing.JDialog dlg=(javax.swing.JDialog)storedMap.get(Kies.KEY_DLG_OBJ);
   try{
     dlg.getContentPane().setCursor(new java.awt.Cursor(java.awt.Cursor.
         WAIT_CURSOR));
     isInitNow = true;
     this.removeAll();
     util.InsertionOrderedHashMap ios=new util.InsertionOrderedHashMap();
     ios.put("HK CODE:","BYMKR_HK_CODE");
     ios.put("NAME:                                                                        ",
             "BYMKR_CHINESE_BRIEF");
     Hashtable ht=new Hashtable();
     tblList=new BuyerMakerTbl(
         new BuyerTmpDb(ejb),999999,ios,ht);
     this.add(tblList);
     tblList.getJtable().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
     tblList.getJtable().addMouseMotionListener(new TblMouseMov()) ;
     tblList.getJtable().addMouseListener(new TblMouseClick());
    }catch(Exception exp){
      exp.printStackTrace();
    }finally{
      isInitNow = false;
      dlg.getContentPane().setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
      return this;
    }

 }
public void setEJB(newtimesejb.preproduction.BuyerMaker buyermakerEJB){
   ejb=buyermakerEJB;
}
public boolean isAllowOkNow(){return true;}

public void setDefalutNext(exgui.chaindialog.Responsible theNext){
  nextExecuter=theNext;
}
public exgui.chaindialog.Responsible  next() throws exgui.chaindialog.NextResponsibleIsNotReady{
    return nextExecuter;//this is an end nod of responsibility.
}
 protected class BuyerTmpDb extends exgui.ultratable.PagedDataFactoryAdapter{
   newtimesejb.preproduction.BuyerMaker ejb;
   BuyerTmpDb(newtimesejb.preproduction.BuyerMaker ejb2Run){
     ejb=ejb2Run;
   }
 protected Vector vctByHkCode(String type, String hkCode,String centerWithComma)throws Exception{
   StringBuffer sb=new StringBuffer();
    sb.append("select bymkr_seq,BYMKR_NAME,bymkr_brief,BYMKR_CNTY_CODE, BYMKR_CITY_NAME,BYMKR_CHECK_DIV,BYMKR_CHINESE_BRIEF,");
    sb.append("BUY_COMM,BUY_COMM_PC, BUY_COMM_DZ,");
    sb.append("BUY_COMM_LUMP_SUM,MKR_DSCT_PER,MKR_DSCT_PC,MKR_DSCT_DZ,MKR_DSCT_LUMP_SUM,");
    sb.append("BYMKR_HK_CODE,");
    sb.append("BYMKR_ADDR1, BYMKR_ADDR2, BYMKR_ADDR3, BYMKR_ADDR4,BYMKR_NAME2 ");
    sb.append(" from buyer_maker where record_delete_flag='1' and BYMKR_MULTI_TYPE like '%,");
    sb.append(type);
   if (centerWithComma.equals("001")) {
     sb.append(",%' and bymkr_brief like '");
   } else {
     sb.append(",%' and BYMKR_HK_CODE like '");
   }
   sb.append(util.MiscFunc.Replace(hkCode, "'", "''"));
   /*
   if(util.PublicVariable.OPERATTING_CENTER.equals("NTHK") &&
      ((String)storedMap.get(Kies.KEY_INIT_SELEC_BUYERMAKER_TYPE_NAME)).equalsIgnoreCase("BUYER")){
     sb.append("'");
   }else{
     sb.append("%'");
   }
   */
   sb.append("%'");

    if(centerWithComma!=null){
      sb.append(" and SELECTABLE_CENTER like '%,");
      sb.append(centerWithComma);
      sb.append(",%'");
    }
    if(centerWithComma.equals("001")){
      sb.append(" order by bymkr_brief");
    }else{
      sb.append(" order by BYMKR_HK_CODE,BYMKR_CHINESE_BRIEF,BYMKR_NAME");
    }
   Vector rec2Return = exgui2.CONST.BASIC_MAIN_EJB.getDatas(
      util.PublicVariable.USER_RECORD,
      sb.toString(),1,99999);
   return rec2Return;
 }
 public Vector getRecords (int bgn,int len)throws Exception {
   java.util.Vector vct=null;
   if(storedMap.get(Kies.KEY_INIT_SELECT_HK_CODE)!=null){
     vct=vctByHkCode(
            (String)storedMap.get(Kies.KEY_INIT_SELEC_BUYERMAKER_TYPE),
            ((String)storedMap.get(Kies.KEY_INIT_SELECT_HK_CODE)).toUpperCase(),
            (String)storedMap.get(Kies.KESY_HM_SELECTING_CENTER_CODE));
    }else{
      vct = ejb.getByrMkr(
         (String)storedMap.get(Kies.KEY_INIT_SELEC_BUYERMAKER_TYPE),
         ((String)storedMap.get(Kies.KEY_INIT_CHAR_OF_BUYERMAKER)).charAt(0),
         (String)storedMap.get(Kies.KESY_HM_SELECTING_CENTER_CODE));
    }
    return vct;
   }
 }
 protected class TblMouseClick extends java.awt.event.MouseAdapter{
   public void mouseClicked(java.awt.event.MouseEvent me){
     if(!isInitNow){
        Record rec=
           (Record)tblList.getDisplayingRecords().get(tblList.getJtable().getSelectedRow()) ;
       storedMap.put(Kies.KEY_SELECTED_BUYER_MAKER_RECORD,rec);
       storedMap.put(Kies.KEY_SELECTED_BUYER_MAKER_SEQ,rec.get(0));
     }
   }
 }
  protected class TblMouseMov extends java.awt.event.MouseMotionAdapter{
    public void mouseMoved(java.awt.event.MouseEvent e){
        int rowAt=tblList.getJtable().rowAtPoint(e.getPoint());
        if(rowAt==-1){
         tblList.getJtable().setToolTipText("");
         return;
        }
        Record rec=(Record)tblList.getDisplayingRecords().get(rowAt);
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
        tblList.getJtable().setToolTipText(sb.toString());
    }
  }
  protected class BuyerMakerTbl extends exgui.ultratable.PagedTablePanel{
    public BuyerMakerTbl(
      exgui.ultratable.PagedDataFactory pagedDataFxy,
      int rowlength,util.InsertionOrderedHashMap columnMapping,
      java.util.Hashtable object2StringConvertor
    ){
      super(pagedDataFxy,rowlength,columnMapping,object2StringConvertor);

    }

  }
}
