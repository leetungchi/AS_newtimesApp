package newtimes.production.gui.prodmaintain;
import database.datatype.Record;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
public class JCompPnlProdTotalEndPageRemark extends JCompPnlProdHeadRemark{
  JButton btnGetEndRemark=null;
  public JCompPnlProdTotalEndPageRemark(String _title,
                                Record rec,
                                String _columnFrom,
                                String _columnCopyFrom,
                                String dftHdRmk) {
    super();
    try{
      title=_title;
      columnFrom=_columnFrom;
      columnCopyFrom=_columnCopyFrom;
      prod_rec=rec;
      defaultHeadRemark=dftHdRmk;
      txtProdHeadRMK.setFont(new java.awt.Font("DialogInput", 0, 12));
      jbInit();
    }catch(Exception exp){
      exp.printStackTrace();
    }
  }
  protected void jbInit() throws Exception {
     jScrollPane1.setBounds(new Rectangle(2, 38, 623, 80));
     //btnCpProdHdRmk.addActionListener(new PnlCT_Desc_btnCpProdHdRmk_actionAdapter(this));
     this.setLayout(null);
     btnGetEndRemark=new JButton();
     whiteBkgBlueCharLabel1.setText(title);
     whiteBkgBlueCharLabel1.setBounds(new Rectangle(2, 1, 600, 21));
     Object prodRmk=prod_rec.get(columnFrom);
     jLabel1.setFont(new java.awt.Font("DialogInput", 0, 12));
     jLabel1.setForeground(Color.red);
     if(util.PublicVariable.OPERATTING_CENTER.equals("NTHK")){
       jLabel1.setText("                                                                                V");
     }else{
       jLabel1.setText("                                   V");
     }

     jLabel1.setBounds(new Rectangle(2, 18, 600, 21));
     btnGetEndRemark.setBounds(new Rectangle(378, 2, 69, 22));
    btnGetEndRemark.setText("  ...  ");
    btnGetEndRemark.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnGetEndRemark_actionPerformed(e);
      }
    });
    this.add(jLabel1, null);
     txtProdHeadRMK.setText((prodRmk==null)?"":prodRmk.toString());
     jScrollPane1.getViewport().add(txtProdHeadRMK, null);
     this.add(jScrollPane1, null);
     this.add(whiteBkgBlueCharLabel1, null);
    this.add(btnGetEndRemark, null);
     jScrollPane1.getVerticalScrollBar().setValue(0);
   }

  void btnGetEndRemark_actionPerformed(ActionEvent e) {
    DlgSlkTotalEndRemarks dlg=new DlgSlkTotalEndRemarks(
      util.PublicVariable.APP_FRAME,
      "Select Total End Remarks",true,
      txtProdHeadRMK);
    dlg.setSize(new Dimension(560,460));
    exgui.UIHelper.setToScreenCenter(dlg);
    dlg.show();
  }

}
