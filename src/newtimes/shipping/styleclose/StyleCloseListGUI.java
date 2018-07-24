package newtimes.shipping.styleclose;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import database.datatype.Record;
/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class StyleCloseListGUI extends JPanel {
  JButton butnStyleClose = new JButton();
  JButton butnStyleUnclose = new JButton();
  JButton btn2UpdateClose=new JButton();
  JButton btn2SelectAll=new JButton();
  BorderLayout borderLayout1 = new BorderLayout();
  static StyleCloseTableEditor tableEditor = null;
  static java.util.Vector vStySeq = new java.util.Vector();
  static java.util.Vector vPool = new java.util.Vector();
  static java.util.Vector vec = new java.util.Vector();
  static String USR_NAME = null;
  static int rowStartAt = 0;

  public StyleCloseListGUI(StyleCloseTableEditor _tableEditor) {
    try {
      USR_NAME = util.PublicVariable.USER_RECORD.get("USR_CODE").toString();
      this.tableEditor = _tableEditor;
      jbInit();
    } catch(Exception ex) {
      ex.printStackTrace();
    }
  }

  public StyleCloseListGUI() {
    try {
      USR_NAME = util.PublicVariable.USER_RECORD.get("USR_CODE").toString();
      jbInit();
    } catch(Exception ex) {
      ex.printStackTrace();
    }
  }

  void jbInit() throws Exception {
    btn2UpdateClose.setBackground(Color.lightGray);
    btn2UpdateClose.setFont(new java.awt.Font("Dialog", 1, 12));
    btn2UpdateClose.setForeground(Color.black);
    btn2UpdateClose.setText("UPDATE");
    this.setLayout(borderLayout1);
    this.setSize(800,600);
    this.setBackground(new Color(204, 204, 225));
    btn2UpdateClose.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        butnUpdateStyleClose_actionPerformed(e);
      }
    });
    butnStyleClose.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        butnStyleClose_actionPerformed(e);
      }
    });
    butnStyleUnclose.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        butnStyleUnclose_actionPerformed(e);
      }
    });
  }
  void butnUpdateStyleClose_actionPerformed(ActionEvent e) {
    vStySeq.add(0, "N");
    this.updateStyleClose();
  }

  void butnStyleUnclose_actionPerformed(ActionEvent e) {
    vStySeq.add(0, "N");
    this.updateStyleClose();
  }

  void butnStyleClose_actionPerformed(ActionEvent e) {
    vStySeq.add(0, "Y");
    this.updateStyleClose();
  }
  void updateStyleClose() {
    try{
      util.MiscFunc.showProcessingMessage();
      ((StyleCloseDataFactoryAdapter)tableEditor.getPagedDataFactory()).
          updateCloseStatus();
      tableEditor.firstPage();
      util.MiscFunc.hideProcessingMessage();
    }catch(Exception exp){
      exp.printStackTrace();
      util.ExceptionLog.exp2File(exp,"");
      //util.MiscFunc.hideProcessingMessage();
      exgui.verification.VerifyLib.showAlert("Update Fail\nPleaes Constact System Manager",
                                             "Update Close Status Fail");
    }
  }
  /*
  void updateStyleCloseDetail() {
    try {
      int result = exgui2.InfoMessage.Yes_No_Option(new JFrame(),"Modify ?");
      if(result == 0){
        setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        vStySeq.add(1, USR_NAME);
        if (vStySeq.size() > 1) {
          boolean isOk = exgui2.CONST.STYLE_CLOSE_EJB.updateStyleClose(vStySeq);
          if (isOk) {
            exgui2.InfoMessage.infoMessage(new JFrame(), "Modify Succeed.");
          } else {
            exgui2.InfoMessage.warningMessage(new JFrame(), "Modify Failed.");
          }
        } else {
          exgui2.InfoMessage.infoMessage(new JFrame(), "No any records by selected.");
        }
        vStySeq.removeAllElements();
        vPool.removeAllElements();
        vec.removeAllElements();
        tableEditor.reload();
      }
    } catch (Exception eUd) {
      eUd.printStackTrace();
      util.ExceptionLog.exp2File(eUd, "error at attempt update style close.");
    } finally {
      setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
    }
  }*/


}
