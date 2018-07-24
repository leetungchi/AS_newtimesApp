package newtimes.preproduction.process;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Cursor;
/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class ToInitUperAndDownPnl {
  static boolean isNTHKTYPE=false;
  public ToInitUperAndDownPnl() {
  }
  protected static void setNthkPreprodDisplayer(){
    while (!SynchRequestor.isAllProcessFinished()) {
      //do nothing....
      try {
        Thread.currentThread().sleep(100);
      }
      catch (Exception e) {

      }
    }

    newtimes.preproduction.guis.PnlNTHKEditPPHead  pnl =
        new newtimes.preproduction.guis.PnlNTHKEditPPHead();
    pnl.orgBuyerNameString=(newtimes.preproduction.guis.tempProperties.orgProdHeadBuyerString.length()==0)?null:
       newtimes.preproduction.guis.tempProperties.orgProdHeadBuyerString.toString();
    pnl.orgMakerNameString=
        (newtimes.preproduction.guis.tempProperties.orgProdHeadMakerString.length()==0)?null:
        newtimes.preproduction.guis.tempProperties.orgProdHeadMakerString.toString();
    DB_Preprod db = DB_NthkPreProd.getInstance();
    pnl.setPagedDataFactory(db);
    database.datatype.Record orgMasterRec=
        processhandler.template.Properties.getCenteralControler().getCurrentEditingMasterRecord();
    pnl.setRecord(orgMasterRec);
    processhandler.template.Properties.getCenteralControler().
        setDataProcesser(
        pnl
        );

    processhandler.template.Properties.getSplitFrame().butnNew.setEnabled(false);
    //pnl.setPreferredSize(new java.awt.Dimension(775,600));
    //pnl.setPreferredSize(new java.awt.Dimension(750,670));
    pnl.setPreferredSize(new java.awt.Dimension(750,500));//some sub-panel hided ,Co'z HK do not determ what to do with preproduction yet
    //pnl.setSize(800, 300);
    //make fake records of destinations and branches.
    try{
      database.datatype.Record tmpRecDest =
          (database.datatype.Record)util.MiscFunc.deepCopy(
          orgMasterRec);
      tmpRecDest.getFieldName().clear();
      tmpRecDest.getValueFields().clear();
      tmpRecDest.getFieldName().add("dest_name");
      tmpRecDest.getPk().set(0,"dest_name");
      tmpRecDest.getValueFields().add(orgMasterRec.get("production_sc_dest"));
      database.datatype.Record tmpRecDestTgt =
          (database.datatype.Record)util.MiscFunc.deepCopy(
          orgMasterRec);
      tmpRecDestTgt.getFieldName().clear();
      tmpRecDestTgt.getValueFields().clear();
      tmpRecDestTgt.getFieldName().add("dest_name");
      tmpRecDestTgt.getPk().set(0,"dest_name");
      tmpRecDestTgt.getValueFields().add(orgMasterRec.get("production_tgt_dest"));
      java.util.Vector tmpVctDests = new java.util.Vector();
      tmpVctDests.add(tmpRecDest);
      tmpVctDests.add(tmpRecDestTgt);

      database.datatype.Record tmpRecBranch =
          (database.datatype.Record)util.MiscFunc.deepCopy(
          orgMasterRec);
      tmpRecBranch.getFieldName().clear();
      tmpRecBranch.getValueFields().clear();
      tmpRecBranch.getFieldName().add("brnch_brief");
      tmpRecBranch.getPk().set(0,"brnch_brief");
      tmpRecBranch.getValueFields().add(orgMasterRec.get(
          "production_brnch_brief"));
      java.util.Vector tmpVctBrnch = new java.util.Vector();
      tmpVctBrnch.add(tmpRecBranch);
      pnl.setBranchesRecords(tmpVctBrnch);
      pnl.setDestinationRecords(tmpVctDests);
    }catch(Exception exp){
       exp.printStackTrace();
       util.ExceptionLog.exp2File(exp,"error in To Init Upper And Down Panel for Preproduction Units");
    }
    pnl.record2Gui();
    pnl.cbxSCDest.getEditor().getEditorComponent().setBackground(java.awt.Color.GRAY);
    pnl.cbxTgtDest.getEditor().getEditorComponent().setBackground(java.awt.Color.GRAY);
    pnl.grayMe();
    //pnl.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
    //processhandler.template.Properties.getMainFrame().getContentPane().setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
    processhandler.template.Properties.getSplitFrame().setUpperPanel(pnl);
  }
  public static void setToNthkMode(boolean toNthk){
    isNTHKTYPE=toNthk;
  }
  public static void setPreProdDisplayer(){
    if(isNTHKTYPE){
      setNthkPreprodDisplayer();
      return;
    }
    while (!SynchRequestor.isAllProcessFinished()) {
      //do nothing....
      try {
        Thread.currentThread().sleep(100);
      }
      catch (Exception e) {

      }
    }

    newtimes.preproduction.guis.PnlEditPPDHead pnl =
        new newtimes.preproduction.guis.PnlEditPPDHead();
    pnl.orgBuyerNameString=(newtimes.preproduction.guis.tempProperties.orgProdHeadBuyerString.length()==0)?null:
       newtimes.preproduction.guis.tempProperties.orgProdHeadBuyerString.toString();
    pnl.orgMakerNameString=
        (newtimes.preproduction.guis.tempProperties.orgProdHeadMakerString.length()==0)?null:
        newtimes.preproduction.guis.tempProperties.orgProdHeadMakerString.toString();
    DB_Preprod db = DB_Preprod.getInstance();
    pnl.setPagedDataFactory(db);
    database.datatype.Record orgMasterRec=
        processhandler.template.Properties.getCenteralControler().getCurrentEditingMasterRecord();

    pnl.setRecord(orgMasterRec);

    processhandler.template.Properties.getCenteralControler().
        setDataProcesser(
        pnl
        );

    processhandler.template.Properties.getSplitFrame().butnNew.setEnabled(false);
    //pnl.setPreferredSize(new java.awt.Dimension(775,600));
    //pnl.setPreferredSize(new java.awt.Dimension(750,670));
    pnl.setPreferredSize(new java.awt.Dimension(750,500));//some sub-panel hided ,Co'z HK do not determ what to do with preproduction yet
    //pnl.setSize(800, 300);
    //make fake records of destinations and branches.
    try{
      database.datatype.Record tmpRecDest =
          (database.datatype.Record)util.MiscFunc.deepCopy(
          orgMasterRec);
      tmpRecDest.getFieldName().clear();
      tmpRecDest.getValueFields().clear();
      tmpRecDest.getFieldName().add("dest_name");
      tmpRecDest.getPk().set(0,"dest_name");
      tmpRecDest.getValueFields().add(orgMasterRec.get("production_sc_dest"));
      database.datatype.Record tmpRecDestTgt =
          (database.datatype.Record)util.MiscFunc.deepCopy(
          orgMasterRec);
      tmpRecDestTgt.getFieldName().clear();
      tmpRecDestTgt.getValueFields().clear();
      tmpRecDestTgt.getFieldName().add("dest_name");
      tmpRecDestTgt.getPk().set(0,"dest_name");
      tmpRecDestTgt.getValueFields().add(orgMasterRec.get("production_tgt_dest"));
      java.util.Vector tmpVctDests = new java.util.Vector();
      tmpVctDests.add(tmpRecDest);
      tmpVctDests.add(tmpRecDestTgt);

      database.datatype.Record tmpRecBranch =
          (database.datatype.Record)util.MiscFunc.deepCopy(
          orgMasterRec);
      tmpRecBranch.getFieldName().clear();
      tmpRecBranch.getValueFields().clear();
      tmpRecBranch.getFieldName().add("brnch_brief");
      tmpRecBranch.getPk().set(0,"brnch_brief");
      tmpRecBranch.getValueFields().add(orgMasterRec.get(
          "production_brnch_brief"));
      java.util.Vector tmpVctBrnch = new java.util.Vector();
      tmpVctBrnch.add(tmpRecBranch);
      pnl.setBranchesRecords(tmpVctBrnch);
      pnl.setDestinationRecords(tmpVctDests);
    }catch(Exception exp){
       exp.printStackTrace();
       util.ExceptionLog.exp2File(exp,"error in To Init Upper And Down Panel for Preproduction Units");
    }
    pnl.record2Gui();
    pnl.cbxSCDest.getEditor().getEditorComponent().setBackground(java.awt.Color.GRAY);
    pnl.cbxTgtDest.getEditor().getEditorComponent().setBackground(java.awt.Color.GRAY);
    pnl.grayMe();
    //pnl.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
    //processhandler.template.Properties.getMainFrame().getContentPane().setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
    processhandler.template.Properties.getSplitFrame().setUpperPanel(pnl);
  }
  static protected void toSetPanelUnderButtons(javax.swing.JPanel pnl,String caption){
    newtimes.preproduction.guis.PnlTabbedButtons triggerBtnPln= newtimes.preproduction.Constants.ButtonsWithTriggers;
    //pnl.setSize(800,300);
    newtimes.preproduction.Constants.ButtonsWithTriggers.setPreferredSize(
        new java.awt.Dimension((int)pnl.getPreferredSize().getWidth(),
                               (int)pnl.getPreferredSize().getHeight()+50)
    );
    triggerBtnPln.panelToPlaceEditors().removeAll();
    triggerBtnPln.panelToPlaceEditors().add(new JLabel(caption),BorderLayout.NORTH);
    triggerBtnPln.panelToPlaceEditors().add(pnl,BorderLayout.CENTER);
    processhandler.template.Properties.getSplitFrame().setLowerPanel(
      triggerBtnPln
    );
  }
 static protected void toSetPanelUnderButtons(javax.swing.JPanel pnl){
    newtimes.preproduction.guis.PnlTabbedButtons triggerBtnPln= newtimes.preproduction.Constants.ButtonsWithTriggers;
    //pnl.setSize(800,300);
    newtimes.preproduction.Constants.ButtonsWithTriggers.setPreferredSize(
        new java.awt.Dimension((int)pnl.getPreferredSize().getWidth(),
                               (int)pnl.getPreferredSize().getHeight()+50)
    );
    triggerBtnPln.panelToPlaceEditors().removeAll();
    triggerBtnPln.panelToPlaceEditors().add(pnl);
    processhandler.template.Properties.getSplitFrame().setLowerPanel(
      triggerBtnPln
    );
  }

}
