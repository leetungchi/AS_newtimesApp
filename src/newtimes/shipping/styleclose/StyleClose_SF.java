package newtimes.shipping.styleclose;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import newtimes.shipping.ScrollPaneGUI;
import newtimes.*;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class StyleClose_SF extends ScrollPaneGUI {
  Frame1 frame;
  private StyleCloseGUI extractGUI = new StyleCloseGUI();

  public StyleClose_SF(Frame1 _frame) {
    frame = _frame;
    try {
      jbInit();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }

  public StyleClose_SF() {
    try {
      jbInit();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }

  void jbInit() throws Exception {
    this.setPanel(extractGUI, new JPanel());
    this.setDividerLocation(0.45);
    extractGUI.butnExtract.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        butnExtract_actionPerformed(e);
      }
    });
    this.butnCopy.setEnabled(false);
    this.butnPrint.setEnabled(false);
    this.butnNew.setEnabled(false);
    this.butnPaste.setEnabled(false);
    this.butnEdit.setEnabled(false);
    this.butnDelete.setEnabled(false);
  }

  void setJTableDatas() {
    try {
      util.MiscFunc.showProcessingMessage();
      if(StyleCloseDataFactoryAdapter.hmUpdateDelDate!=null){
        StyleCloseDataFactoryAdapter.hmUpdateDelDate.clear();
      }
      if(StyleCloseDataFactoryAdapter.hmUpdatedStatus!=null){
        StyleCloseDataFactoryAdapter.hmUpdatedStatus.clear();
      }

      setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
      StyleCloseListGUI.vStySeq.removeAllElements();
      StyleCloseListGUI.vPool.removeAllElements();
      StyleCloseListGUI.vec.removeAllElements();
      extractGUI.getQueryDatas();
      StyleCloseTableEditor listTableEditor = new StyleCloseTableEditor();
      StyleCloseListGUI listGUI = new StyleCloseListGUI(listTableEditor);
      listGUI.setPreferredSize(new java.awt.Dimension(300,270));
      listTableEditor.getLowerRightPanel().setLayout(new FlowLayout(FlowLayout.RIGHT));
      //listTableEditor.getLowerRightPanel().add(listGUI.butnStyleClose, null);
      //listTableEditor.getLowerRightPanel().add(listGUI.butnStyleUnclose, null);
      listTableEditor.getLowerRightPanel().add(listGUI.btn2UpdateClose, null);
      listGUI.add(listTableEditor, null);
      switch (extractGUI.checkNo) {
        /*
        case 0:
          //listGUI.butnStyleClose.setEnabled(false);
          //listGUI.butnStyleUnclose.setEnabled(true);
          listTableEditor.btn2SelectAll.setEnabled(false);
          listGUI.btn2UpdateClose.setEnabled(true);
          break;
        case 1:
          //listGUI.butnStyleClose.setEnabled(true);
          //listGUI.butnStyleUnclose.setEnabled(false);
          listTableEditor.btn2SelectAll.setEnabled(true);
          listGUI.btn2UpdateClose.setEnabled(true);
          break;
         */
        case 3:
          //listGUI.butnStyleClose.setEnabled(true);
          //listGUI.butnStyleUnclose.setEnabled(true);
          listTableEditor.btn2SelectAll.setEnabled(false);
          listGUI.btn2UpdateClose.setEnabled(false);
          listGUI.tableEditor.CLOSE_EDITABLE=false;
          break;
        default :
          //listGUI.butnStyleClose.setEnabled(true);
          //listGUI.butnStyleUnclose.setEnabled(false);
          listTableEditor.btn2SelectAll.setEnabled(true);
          listGUI.btn2UpdateClose.setEnabled(true);
          listGUI.tableEditor.CLOSE_EDITABLE=true;
          break;
      }

      this.setLowerPanel(listGUI);
    } catch (Exception iie) {
      iie.printStackTrace();
      util.ExceptionLog.exp2File(iie,"exception while attempt to Edit.");
    } finally {
      util.MiscFunc.hideProcessingMessage();
      setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
    }
  }

  void butnExtract_actionPerformed(ActionEvent e) {
    this.setJTableDatas();

  }

  public void do_Copy() {
  }

  public void do_Delete() {
  }

  public void do_Edit() {
  }

  public void do_Exit() {
    util.ApplicationProperites.removeProperites("getData");
    /*frame.showPanel(new newtimes.shipping.ShippingMenu(frame));*/
    try{
      processhandler.template.Properties.getCenteralControler().doCommandExecute(
        new newtimes.production.report.TgrToGenMisFunList()
      );

    }catch(Exception exp){
      exp.printStackTrace();
    }
  }

  public void do_New() {
  }

  public void do_Paste() {
  }

  public void do_Print() {
  }
}
