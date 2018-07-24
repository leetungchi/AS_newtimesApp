package newtimes.production.gui.prodmaintain;
import database.datatype.Record;
import java.util.*;
import javax.swing.*;
import java.awt.*;
import javax.swing.event.*;
/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class PnlNthkStyles_CT_DESC_test extends PnlStyles_CT_DESC {
  JComboBox cbxCtSeq=null;
  JLabel lblGotoCTNo =null;
  static Vector vctCtSeq;
  static exgui.DataBindJCombobox dbxGotoProdHead=null;
  static gotoCtSeqCTDESC cbxListener=null;
  static boolean isToRanderNow=false;
  static int currentCtSeq=0;
  static boolean have2ChkCtxMdf=true;
  static boolean isCtSelectionCanceled=false;
  public PnlNthkStyles_CT_DESC_test(Record _prodRec,Vector styles,
                          newtimesejb.production.Styles_SC_CT_Facade _ejb,int prod_pk_to_show) {
     super(_prodRec,styles,_ejb);
     isToRanderNow=true;
     if(lblGotoCTNo==null) lblGotoCTNo= new JLabel();
     if(cbxListener==null)cbxListener=new gotoCtSeqCTDESC();
     if(cbxCtSeq==null){
       cbxCtSeq = new JComboBox();
     }
     myInit();

     cbxCtSeq.removePopupMenuListener(cbxListener);
     cbxCtSeq.addPopupMenuListener(cbxListener);
     cbxCtSeq.addItemListener(cbxListener);

     dbxGotoProdHead=new exgui.DataBindJCombobox(
                     cbxCtSeq,
                     "",
                     vctCtSeq,
                     "PROD_CT_SEQ",
                     "PROD_HEAD_PK",String.valueOf(prod_pk_to_show));


    currentCtSeq=cbxCtSeq.getSelectedIndex();
    isToRanderNow=false;
    have2ChkCtxMdf=true;
    isCtSelectionCanceled=false;
  }

  public PnlNthkStyles_CT_DESC_test(Record _prodRec,Vector styles,
                          newtimesejb.production.Styles_SC_CT_Facade _ejb,Vector _vctCtSeq) {
     super(_prodRec,styles,_ejb);
     isToRanderNow=true;
     vctCtSeq=_vctCtSeq;
     if(lblGotoCTNo==null) lblGotoCTNo= new JLabel();
     if(cbxListener==null)cbxListener=new gotoCtSeqCTDESC();
     if(cbxCtSeq==null){
       cbxCtSeq = new JComboBox();
     }

       myInit();

       cbxCtSeq.removePopupMenuListener(cbxListener);
       cbxCtSeq.addPopupMenuListener(cbxListener);
       cbxCtSeq.addItemListener(cbxListener);
       dbxGotoProdHead=new exgui.DataBindJCombobox(
                     cbxCtSeq,
                     "",
                     vctCtSeq,
                     "PROD_CT_SEQ",
                     "PROD_HEAD_PK","1");
    isToRanderNow=false;
    have2ChkCtxMdf=true;
    isCtSelectionCanceled=false;

  }
  public PnlNthkStyles_CT_DESC_test() {
    super();
    have2ChkCtxMdf=true;
    isCtSelectionCanceled=false;
  }
  public boolean isContextModified(){
    if(!have2ChkCtxMdf)return false;
    return super.isContextModified();
  }

   class gotoCtSeqCTDESC implements  javax.swing.event.PopupMenuListener ,java.awt.event.ItemListener {
    public void popupMenuWillBecomeVisible(PopupMenuEvent e){
      have2ChkCtxMdf=true;
      if(isContextModified()){
        if(! exgui.verification.VerifyLib.showConfirm("This page had been modified\nBut not confirmed\nDo You Want To Exit Without Confirm ?",
                                                 "Page Modified")){
           //Remain at current page.
           cbxCtSeq.firePopupMenuCanceled();
           have2ChkCtxMdf=true;
           return;
        }else{
          //goto other C/T Page.
          have2ChkCtxMdf=false;
          return;
        }
      }
      have2ChkCtxMdf=false;
    }
    public void popupMenuWillBecomeInvisible(PopupMenuEvent e){

    }
    public void popupMenuCanceled(PopupMenuEvent e){
      System.out.println(" popupMenuCanceled ");

    }
    public void itemStateChanged(java.awt.event.ItemEvent ie){
      if(isToRanderNow)return;

      try{
        /*
        if(isContextModified()){
          if(! exgui.verification.VerifyLib.showConfirm("This page had been modified\nBut not confirmed\nDo You Want To Exit Without Confirm ?",
                                                   "Page Modified")){
             isToRanderNow=true;
             cbxCtSeq.setSelectedIndex(currentCtSeq);
             isToRanderNow=false;
             return;
          }else{
          }
        }
        */
        have2ChkCtxMdf=false;
        int prod_head_pk=Integer.parseInt(dbxGotoProdHead.getSelectedValue().toString());
        processhandler.template.Properties.getCenteralControler().
            doCommandExecute(
            new newtimes.production.process.prodmaintain.
            TgrToEditNthkStyeXCtDesc(prod_head_pk));
      }catch(Exception exp){
        exp.printStackTrace();
        util.ExceptionLog.exp2File(exp, "");
      }finally{

      }
    }
  }
  protected void myInit(){
    cbxCtSeq.setBounds(new Rectangle(500, 3, 152, 19));
    lblGotoCTNo.setText("Goto C/T SEQ:");
    lblGotoCTNo.setBounds(new Rectangle(396, 3, 99, 20));
    this.add(cbxCtSeq, null);
    this.add(lblGotoCTNo, null);
  }
}
