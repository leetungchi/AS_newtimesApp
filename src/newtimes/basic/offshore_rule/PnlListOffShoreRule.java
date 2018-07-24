package newtimes.basic.offshore_rule;

import java.awt.*;
import exgui.*;
import javax.swing.*;
import java.awt.event.*;
import database.datatype.*;
import java.util.*;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class PnlListOffShoreRule extends JPanel {
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel1 = new BlueBkgWhiteCharLabel();
  //JPanel jPanel1 = new JPanel();
  JButton btnExit = new JButton();
  exgui.ultratable.PagedTablePanel pnl=null;
  public PnlListOffShoreRule() {
    try {
      jbInit();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }

  void jbInit() throws Exception {
    blueBkgWhiteCharLabel1.setText("Query Result Of Offshore Reult (Double Click To Edit)");
    blueBkgWhiteCharLabel1.setBounds(new Rectangle(-2, 20, 803, 32));
    this.setLayout(null);
    //jPanel1.setBounds(new Rectangle(4, 70, 782, 457));
    btnExit.setBounds(new Rectangle(350, 544, 100, 30));
    btnExit.setFont(new java.awt.Font("Dialog", 1, 11));
    btnExit.setText("BACK");
    btnExit.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnExit_actionPerformed(e);
      }
    });
    this.add(blueBkgWhiteCharLabel1, null);
    //this.add(jPanel1, null);
    this.add(btnExit, null);
    util.InsertionOrderedHashMap iso=new util.InsertionOrderedHashMap();
    iso.put("CENTER","CEN_NAME");
    iso.put("COUNTRY","COUNTRY");
    iso.put("BUYER\nHK CODE","BYR_HK");
    iso.put("BUYER\nBRIEF","BYR_BRF");
    iso.put("BUYER\nNAME    ","BYR_NAME");

    iso.put("MAKER\nHK CODE","MKR_HK");
    iso.put("MAKER\nBRIEF","MKR_BRF");
    iso.put("MAKER\nNAME    ","MKR_NAME");


    pnl=new
        exgui.ultratable.PagedTablePanel(new TmpDb(),23,iso,new Hashtable());
    pnl.setBounds(new Rectangle(4, 70, 782, 450));
    this.add(pnl, null);
    pnl.getJtable().addMouseListener(new MouseEventAdpt());
  }
  class MouseEventAdpt extends java.awt.event.MouseAdapter{
    public void mouseClicked(java.awt.event.MouseEvent me){
       if(me.getClickCount()==2){
         try{
           Record rec = (Record)util.MiscFunc.deepCopy(pnl.getDisplayingRecords().
               get(pnl.getJtable().getSelectedRow()));
           DlgEditRule dlg = new DlgEditRule(util.PublicVariable.APP_FRAME,
                                             "EDIT RULE", true, rec);
           dlg.setSize(550, 290);
           exgui.UIHelper.setToScreenCenter(dlg);
           dlg.pnl2Reload = pnl;
           dlg.show();
         }catch(Exception exp){
           exp.printStackTrace();
           util.ExceptionLog.exp2File(exp,"");
           exgui.verification.VerifyLib.showAlert("Error While Entering Edit Rule Diaglobox",
                                                  "Error While Entering Edit Rule Diaglobox");
         }

       }
    }
  }

  void btnExit_actionPerformed(ActionEvent e) {
     ToDoAxn.ShowQryGUI();
  }
  class TmpDb extends exgui.ultratable.PagedDataFactoryAdapter{
    public Vector getRecords(int bgn,int rowcount)throws Exception{
      StringBuffer sb=new StringBuffer();
      sb.append("select  ");
      sb.append("a.* ");
      sb.append(",CTR.CEN_NAME ");
      sb.append(",B.BYMKR_BRIEF as BYR_BRF ");
      sb.append(",B.BYMKR_HK_CODE as BYR_HK ");
      sb.append(",B.BYMKR_NAME as BYR_NAME ");
      sb.append(",C.BYMKR_BRIEF as MKR_BRF ");
      sb.append(",C.BYMKR_HK_CODE as MKR_HK ");
      sb.append(",C.BYMKR_NAME as MKR_NAME ");
      sb.append("from offshore_rule a,buyer_maker b,buyer_maker c,center ctr ");
      sb.append("where  ");
      sb.append("A.BUYER_ID=B.BYMKR_SEQ ");
      sb.append("and  ");
      sb.append("A.MAKER_ID=C.BYMKR_SEQ ");
      sb.append("and a.center=CTR.CEN_CODE ");
      Object buyer=ToDoAxn.pnlQry.slkBuyer.getSelectedValue();
      Object maker=ToDoAxn.pnlQry.slkMaker.getSelectedValue();
      Object center=ToDoAxn.pnlQry.dbCBX_Center.getSelectedValue();
      Object cnty=ToDoAxn.pnlQry.DbJcbxcbxQcCountry.getSelectedValue();
      if(buyer!=null){
        sb.append(" and a.BUYER_ID=");sb.append(buyer.toString());
      }

      if(buyer!=null){
        sb.append(" and a.BUYER_ID=");sb.append(buyer.toString());
      }
      if(center!=null){
        sb.append(" and a.CENTER='");sb.append(util.MiscFunc.Replace(center.toString(),"'","''"));sb.append("'");
      }

      if(cnty!=null){
        sb.append(" and a.COUNTRY='");sb.append(util.MiscFunc.Replace(cnty.toString(),"'","''"));sb.append("'");
      }
       //System.out.println(sb.toString());

      return exgui2.CONST.BASIC_MAIN_EJB.getDatas(
       util.PublicVariable.USER_RECORD,
       sb.toString(),bgn,rowcount);
    }
  }
}
