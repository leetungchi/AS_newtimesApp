package newtimes.production.gui.prodmaintain;
import database.datatype.Record;
import java.util.*;
import javax.swing.*;
import java.awt.*;
/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class PnlNthkStyles_CT_DESC extends PnlStyles_CT_DESC {
  JComboBox cbxCtSeq=null;
  JLabel lblGotoCTNo =null;
  static Vector vctCtSeq;
  static exgui.DataBindJCombobox dbxGotoProdHead=null;
  static gotoCtSeqCTDESC cbxListener=null;
  static boolean isToRanderNow=false;
  static int currentCtSeq=0;
  static boolean isConfirmedChanged=false;
  public PnlNthkStyles_CT_DESC(Record _prodRec,Vector styles,
                          newtimesejb.production.Styles_SC_CT_Facade _ejb,int prod_pk_to_show) {
     super(_prodRec,styles,_ejb);
     isToRanderNow=true;
     if(lblGotoCTNo==null) lblGotoCTNo= new JLabel();
     if(cbxListener==null)cbxListener=new gotoCtSeqCTDESC();
     if(cbxCtSeq==null){
       cbxCtSeq = new JComboBox();
     }
     myInit();
     cbxCtSeq.removeItemListener(cbxListener);
     cbxCtSeq.addItemListener(cbxListener);
     dbxGotoProdHead=new exgui.DataBindJCombobox(
                     cbxCtSeq,
                     "",
                     vctCtSeq,
                     "PROD_CT_SEQ",
                     "PROD_HEAD_PK",String.valueOf(prod_pk_to_show));


    currentCtSeq=cbxCtSeq.getSelectedIndex();
    isToRanderNow=false;
    isConfirmedChanged=false;
  }

  public PnlNthkStyles_CT_DESC(Record _prodRec,Vector styles,
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
       cbxCtSeq.removeItemListener(cbxListener);
       cbxCtSeq.addItemListener(cbxListener);
     dbxGotoProdHead=new exgui.DataBindJCombobox(
                     cbxCtSeq,
                     "",
                     vctCtSeq,
                     "PROD_CT_SEQ",
                     "PROD_HEAD_PK","1");
    isToRanderNow=false;
    isConfirmedChanged=false;

  }
  public PnlNthkStyles_CT_DESC() {
    super();
  }
  public boolean isContextModified(){
    if(isConfirmedChanged)return false;
    return super.isContextModified();
  }
   class gotoCtSeqCTDESC implements  java.awt.event.ItemListener{
    public void itemStateChanged(java.awt.event.ItemEvent ie){
       if(ie.getStateChange()==ie.DESELECTED)return;
      if(isToRanderNow)return;
      try{
        if(isContextModified()){
          if(! exgui.verification.VerifyLib.showConfirm("This page had been modified\nBut not confirmed\nDo You Want To Exit Without Confirm ?",
                                                   "Page Modified")){

             isToRanderNow=true;
             cbxCtSeq.setSelectedIndex(currentCtSeq);
             isToRanderNow=false;
             isConfirmedChanged=false;
             return;
          }else{
            isConfirmedChanged=true;
          }
        }
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
