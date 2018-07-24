package newtimes.production.gui.prodmaintain;

import java.awt.*;
import javax.swing.*;
import exgui.*;
import java.awt.event.*;
import database.datatype.Record;
public class DlgSlkTotalEndRemarks extends JDialog {
  JPanel panel1 = new JPanel();
  BorderLayout borderLayout1 = new BorderLayout();
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel1 = new BlueBkgWhiteCharLabel();
  JPanel pnlDown = new JPanel();
  JButton btnOK = new JButton();
  JButton btnCancel = new JButton();
  JPanel jPanel1 = new JPanel();
  JPanel jPanel2 = new JPanel();
  JScrollPane jScrollPane1 = new JScrollPane();
  JPanel pnl2Contant = new JPanel();
  JTextArea txtArea;
  JCheckBox remarksCheck[]=null;
  java.util.Vector vctRecords=null;
  //GridLayout gridLayout1 = new GridLayout();
  public DlgSlkTotalEndRemarks(Frame frame, String title, boolean modal,JTextArea tArea) {
    super(frame, title, modal);
    try {
      txtArea=tArea;
      jbInit();
      pack();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }

  public DlgSlkTotalEndRemarks() {
    this(null, "", false,null);
  }

  private void jbInit() throws Exception {
    panel1.setLayout(borderLayout1);
    blueBkgWhiteCharLabel1.setText("Please Check Remarks To Append");
    btnOK.setText("OK");
    btnOK.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnOK_actionPerformed(e);
      }
    });
    btnCancel.setText("CANCEL");
    btnCancel.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnCancel_actionPerformed(e);
      }
    });
    //pnl2Contant.setLayout(gridLayout1);
    getContentPane().add(panel1);
    panel1.add(blueBkgWhiteCharLabel1, BorderLayout.NORTH);
    panel1.add(pnlDown, BorderLayout.SOUTH);
    pnlDown.add(btnOK, null);
    pnlDown.add(jPanel1, null);
    pnlDown.add(btnCancel, null);
    pnlDown.add(jPanel2, null);
    panel1.add(jScrollPane1, BorderLayout.CENTER);
    jScrollPane1.getViewport().add(pnl2Contant, null);
    initCheckBoxes();
  }
  protected void initCheckBoxes()throws Exception{
    vctRecords=
        exgui2.CONST.BASIC_MAIN_EJB.getDatas(
        util.PublicVariable.USER_RECORD,
        "select TER_REMARK from TOTAL_ENDPAGE_REMARK where record_delete_flag='1' and TER_REMARK is not null order by TER_REMARK",
        1,999999);
    GridLayout gridLayout=new GridLayout(vctRecords.size(),1);
    remarksCheck=new JCheckBox[vctRecords.size()];
    pnl2Contant.setLayout(gridLayout);
    for(int i=0;i<vctRecords.size();i++){
      database.datatype.Record rec=(database.datatype.Record)vctRecords.get(i);
      String lbl="<html><body>"+ util.MiscFunc.Replace((String)rec.get(0),"\n","<br>")+"</body></html>";
      remarksCheck[i]=new JCheckBox(lbl);
      pnl2Contant.add(remarksCheck[i]);
    }
  }
  void btnOK_actionPerformed(ActionEvent e) {
      for(int i=0;i<remarksCheck.length;i++){
        if(remarksCheck[i].isSelected()){
          if(txtArea.getText().trim().length()>0)txtArea.append("\n");
          Record rec=(Record)vctRecords.get(i);
          txtArea.append((String)rec.get(0));
        }
      }
      dispose();
  }

  void btnCancel_actionPerformed(ActionEvent e) {
    this.dispose();
  }
}
