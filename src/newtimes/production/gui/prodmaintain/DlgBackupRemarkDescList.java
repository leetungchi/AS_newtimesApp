package newtimes.production.gui.prodmaintain;

import java.awt.*;
import javax.swing.*;
import java.util.*;
import java.awt.event.*;
import exgui.*;
/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class DlgBackupRemarkDescList extends JDialog {
  JPanel panel1 = new JPanel();
  JButton btnClose = new JButton();
  JScrollPane jScrollPane1 = new JScrollPane();
  JTable tblListHostory = null;
  Vector vctHistory=null;
  PnlStyles_SC_DESC pnl2Recover;
  WhiteBkgBlueCharLabel whiteBkgBlueCharLabel1 = new WhiteBkgBlueCharLabel();

  public DlgBackupRemarkDescList(Frame frame, String title,
                                 boolean modal,Vector vctBackup,
                                 PnlStyles_SC_DESC pnl) {
    super(frame, title, modal);
    try {
      vctHistory=vctBackup;
      pnl2Recover=pnl;
      jbInit();
      pack();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }

  public DlgBackupRemarkDescList() {
    this(null, "", false,null,null);
  }

  private void jbInit() throws Exception {
    panel1.setLayout(null);
    btnClose.setBounds(new Rectangle(107, 207, 85, 25));
    btnClose.setFont(new java.awt.Font("Dialog", 1, 11));
    btnClose.setText("CLOSE");
    btnClose.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnClose_actionPerformed(e);
      }
    });
    jScrollPane1.setBounds(new Rectangle(23, 41, 248, 142));
    whiteBkgBlueCharLabel1.setText("Click To Recover");
    whiteBkgBlueCharLabel1.setBounds(new Rectangle(23, 11, 250, 28));
    getContentPane().add(panel1);
    panel1.add(btnClose, null);
    panel1.add(jScrollPane1, null);
    panel1.add(whiteBkgBlueCharLabel1, null);
    tblListHostory=new JTable(vctHistory.size(),1);
    for(int i=0;i<vctHistory.size();i++){
      HashMap hm=(HashMap)vctHistory.get(i);
      String timeStemp=(String)hm.get("GENERATED_TIME");
      tblListHostory.setValueAt(timeStemp,i,0);
    }
    tblListHostory.getColumnModel().getColumn(0).setHeaderValue("BACKUP TIME");
    jScrollPane1.getViewport().add(tblListHostory, null);
    tblListHostory.addMouseListener(
         new java.awt.event.MouseAdapter(){
             public void mouseClicked(java.awt.event.MouseEvent me){
               int row=tblListHostory.getSelectedRow();
               if(row==-1)return;
                HashMap hm=(HashMap)vctHistory.get(row);
                /*
                   kyes:
                 VCT_STYLE_DOWN_REMARK
                 VCT_STYLE_UP_REMARK
                 PROD_FINAL_REMARK
                 PROD_END_REMARK
                 PROD_UP_REMARK
                 */
                pnl2Recover.prodHeadScRemark.txtProdHeadRMK.setText((String)hm.get("PROD_UP_REMARK"));
                pnl2Recover.prodEndScRemark.txtProdHeadRMK.setText((String)hm.get("PROD_END_REMARK"));
                pnl2Recover.prodTotalEndPageRemark.txtProdHeadRMK.setText((String)hm.get("PROD_FINAL_REMARK"));
                Vector vctStyUpRemark=(Vector)hm.get("VCT_STYLE_UP_REMARK");
                Vector vctStyDownRemark=(Vector)hm.get("VCT_STYLE_DOWN_REMARK");
                for(int i=0;i<vctStyDownRemark.size();i++){
                  String styUpRmrk=(String)vctStyUpRemark.get(i);
                  String styDownRmrk=(String)vctStyDownRemark.get(i);
                  if(i<pnl2Recover.styleUpAndDownRemarkGUIS.length){
                    pnl2Recover.styleUpAndDownRemarkGUIS[i].txtStyUpRMK.setText(styUpRmrk);
                    pnl2Recover.styleUpAndDownRemarkGUIS[i].txtStyDownRMK.setText(styDownRmrk);
                  }

                }
             }
         }
      );
  }

  void btnClose_actionPerformed(ActionEvent e) {
     this.dispose();
  }
}
