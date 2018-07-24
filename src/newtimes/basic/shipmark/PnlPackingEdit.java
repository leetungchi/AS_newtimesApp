package newtimes.basic.shipmark;

import java.awt.*;
import exgui.*;
import javax.swing.*;
import newtimes.preproduction.buyermakerselect.*;
import javax.swing.border.*;
import java.awt.event.*;
import database.datatype.Record;
import exgui.ultratable.PagedDataFactory;
public class PnlPackingEdit extends JPanel {
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel1 = new BlueBkgWhiteCharLabel();
  JLabel jLabel1 = new JLabel();
  SelectBuyerMaker slkBuyerMaker = new SelectBuyerMaker();
  JPanel jPanel1 = new JPanel();
  JScrollPane jScrollPane1 = new JScrollPane();
  BorderLayout borderLayout1 = new BorderLayout();
  JTextArea txtPackingMark = new JTextArea();
  TitledBorder titledBorder1;
  JButton btnOK = new JButton();
  JButton btnEXIT = new JButton();
  JButton btnDelete = new JButton();
  PagedDataFactory db_handler=null;;
  Record rec=null;
  public PnlPackingEdit() {
    try {
      jbInit();
    }
    catch(Exception e) {
      e.printStackTrace();
    }
  }
  protected void setHandlerAndRecord(PagedDataFactory handler,Record rec2process){
    db_handler=handler;
    rec=rec2process;
    slkBuyerMaker.init("PACKING_BYMKR_SEQ",rec.get(1),slkBuyerMaker.TYPE_BUYER,true);
    txtPackingMark.setText((String)rec.get(2));//packing text context
  }
  protected void genData(){
    rec.set(1,slkBuyerMaker.getSelectedValue());
    rec.set(2,txtPackingMark.getText());
  }
  protected void jbInit() throws Exception {
    this.setBackground(new Color(204, 204, 225));
    titledBorder1 = new TitledBorder(BorderFactory.createLineBorder(new Color(153, 153, 153),2),"Content of Packing");
    blueBkgWhiteCharLabel1.setText("EDITING PACKING MARK");
    blueBkgWhiteCharLabel1.setBounds(new Rectangle(0, 18, 800, 27));
    this.setLayout(null);
    jLabel1.setText("Buyer/Maker");
    jLabel1.setBounds(new Rectangle(29, 59, 107, 20));
    slkBuyerMaker.setBounds(new Rectangle(152, 58, 479, 26));
    jPanel1.setBorder(titledBorder1);
    jPanel1.setBounds(new Rectangle(8, 101, 615, 273));
    jPanel1.setLayout(borderLayout1);
    txtPackingMark.setFont(new java.awt.Font("DialogInput", 0, 12));
    txtPackingMark.setText("");
    btnOK.setBounds(new Rectangle(264, 376, 119, 27));
    btnOK.setText("OK");
    btnOK.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnOK_actionPerformed(e);
      }
    });
    btnEXIT.setBounds(new Rectangle(543, 376, 78, 29));
    btnEXIT.setText("EXIT");
    btnEXIT.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnEXIT_actionPerformed(e);
      }
    });
    btnDelete.setBounds(new Rectangle(401, 375, 111, 29));
    btnDelete.setText("DELETE");
    btnDelete.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnDelete_actionPerformed(e);
      }
    });
    this.add(blueBkgWhiteCharLabel1, null);
    this.add(jLabel1, null);
    this.add(slkBuyerMaker, null);
    this.add(jPanel1, null);
    jPanel1.add(jScrollPane1,  BorderLayout.CENTER);
    jScrollPane1.getViewport().add(txtPackingMark, null);
    this.add(btnOK, null);
    this.add(btnEXIT, null);
    this.add(btnDelete, null);
  }

  void btnOK_actionPerformed(ActionEvent e) {
    try{
      genData();
      java.util.Vector vct=new java.util.Vector();
      vct.add(rec);
      db_handler.updateRecords(vct);
      btnEXIT_actionPerformed(null);
    }catch(Exception exp){
      exp.printStackTrace();
      util.ExceptionLog.exp2File(exp,"");
      exgui.verification.VerifyLib.showAlert("Update Fail!!\nPlease Contact System Manager",
                                             "Update Fail");
    }

  }

  void btnDelete_actionPerformed(ActionEvent e) {
    if(!exgui.verification.VerifyLib.showConfirm("Do You Sure To Delete ?","Are You Sure ?"))return;
    try{
      db_handler.deleteRecord(rec);
      btnEXIT_actionPerformed(null);
    }catch(Exception exp){
      exp.printStackTrace();
      util.ExceptionLog.exp2File(exp,"");
      exgui.verification.VerifyLib.showAlert("Delete Fail!!\nPlease Contact System Manager",
                                             "Delete Fail");
    }
  }

  void btnEXIT_actionPerformed(ActionEvent e) {
    //back to query interface.
    this.removeAll();
    PnlListPacking pnl=new PnlListPacking();
    newtimes.Frame1 frame=(newtimes.Frame1)util.PublicVariable.APP_FRAME;
    frame.contentPane.removeAll();
    frame.contentPane.add(pnl, null);
     pnl.setBounds(16, 82, 760, 406);
     pnl.repaint();
     pnl.validate();
     frame.repaint();
     frame.validate();
     //pnl.firstPage();

  }

}
