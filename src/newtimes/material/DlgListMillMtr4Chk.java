package newtimes.material;

import java.awt.*;
import javax.swing.*;
import java.util.*;
import java.awt.event.*;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class DlgListMillMtr4Chk extends JDialog {
  exgui.ultratable.PagedTablePanel  dbTbl;
  String millMtrNoList;
  JPanel panel1 = new JPanel();
 BorderLayout borderLayout1 = new BorderLayout();
  JButton btnOK = new JButton();
  BorderLayout borderLayout3 = new BorderLayout();

  public DlgListMillMtr4Chk(Frame frame, String title, boolean modal,String _millMtrNoList) {
    super(frame, title, modal);
    try {
      millMtrNoList=_millMtrNoList;
      jbInit();
      pack();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }

  public DlgListMillMtr4Chk() {
    this(null, "", false,null);
  }

  protected void jbInit() throws Exception {
    this.getContentPane().setLayout(borderLayout3);
    panel1.setBackground(new Color(204, 204, 225));
    btnOK.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnOK_actionPerformed(e);
      }
    });
    this.getContentPane().add(panel1, BorderLayout.SOUTH);
    panel1.add(btnOK, null);
    util.MiscFunc.showProcessingMessage();
    util.InsertionOrderedHashMap iso=new util.InsertionOrderedHashMap();
    iso.put("MTR No.","MTRDTL_MTR_NO");
    iso.put("MILL\nName","mill_name");
    iso.put("MILL NO","MTRDTL_MILL_NO");
    dbTbl=new exgui.ultratable.PagedTablePanel(new tmpDataEnging(),100,iso,new Hashtable());
    dbTbl.firstPage();
    util.MiscFunc.hideProcessingMessage();
    if(dbTbl.getDisplayingRecords().size()==0){
      exgui.verification.VerifyLib.showPlanMsg("No Mtr or Mill Using This Mill\'s Mtr No",
                                               "No Mtr or Mill Using This Mill\'s Mtr No") ;
    }
    btnOK.setFont(new java.awt.Font("Dialog", 1, 11));
    btnOK.setText("CLOSE");
    this.getContentPane().add(dbTbl,  BorderLayout.CENTER);
  }
  class tmpDataEnging extends exgui.ultratable.PagedDataFactoryAdapter{
     public Vector getRecords(int bgn,int rowcount)throws Exception{
       StringBuffer sb=new StringBuffer();
       sb.append("select MTRDTL_MTR_NO,");
       sb.append("(select nvl(BYMKR_HK_CODE,BYMKR_BRIEF) from buyer_maker  where BYMKR_SEQ=MTRDTL_BYMKR_SEQ) as mill_name,");
       sb.append("MTRDTL_MILL_NO ");
       sb.append(" from MATERIAL_DETAIL where MTRDTL_MILL_NO in (");
       String millMtrList[]=util.MiscFunc.split(millMtrNoList.toUpperCase(),",");
       for(int i=0;i<millMtrList.length;i++){
         if(i>0)sb.append(",");
         sb.append("'");
         sb.append(util.MiscFunc.Replace(millMtrList[i],"'","''").trim());
         sb.append("'");
       }
       sb.append(") and record_delete_flag='1'");
       java.util.Vector vct=exgui2.CONST.BASIC_MAIN_EJB.getDatas(util.PublicVariable.USER_RECORD,
                                                       sb.toString(),bgn,rowcount);
       return vct;
     }
  }

  void btnOK_actionPerformed(ActionEvent e) {
    this.dispose();
  }

}
