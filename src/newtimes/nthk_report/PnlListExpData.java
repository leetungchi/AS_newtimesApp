package newtimes.nthk_report;

import java.awt.*;
import exgui.*;
import javax.swing.*;
import newtimes.production.report.AbsQryPanel;
import java.util.*;
import exgui.verification.CellFormat;
import database.datatype.Record;
import exgui.ultratable.CellTxtEditorFormat;
import java.awt.event.*;
import newtimes.preproduction.guis.*;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class PnlListExpData
    //extends JPanel {
    extends AbsQryPanel implements Int_PNL_JINIT{
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel1 = new BlueBkgWhiteCharLabel();
  JButton btnQry = new JButton();

  public PnlListExpData() {
    try {
      //jbInit();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }

 public void jbInit() throws Exception {
    blueBkgWhiteCharLabel1.setText("LIST ALL EXPORT DATA");
    blueBkgWhiteCharLabel1.setBounds(new Rectangle(-1, 6, 807, 31));
    this.setLayout(null);
    btnQry.setBounds(new Rectangle(672, 40, 101, 27));
    btnQry.setFont(new java.awt.Font("Dialog", 1, 11));
    btnQry.setText("REPORT");
    btnQry.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnQry_actionPerformed(e);
      }
    });
    this.add(blueBkgWhiteCharLabel1, null);
    this.add(btnQry, null);
    if(util.PublicVariable.OPERATTING_CENTER.equals("NTFE")){
      reportName="NTFE_EXP_LIST.rpt";
    }else{
      reportName="HK_EXP_LIST.rpt";
    }

  }
  public void genDataBindObj(){

  }
  void btnQry_actionPerformed(ActionEvent e) {
    super.JButtonQueryButtonAction(e);
  }
}
