package newtimes.preproduction.process;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class ToListLockinStyles extends ToInitUperAndDownPnl implements AbleToShowLknStyleList {
  static util.InsertionOrderedHashMap iso=null;
  static java.util.Hashtable obj2string=new java.util.Hashtable();
  public ToListLockinStyles() {
    if(iso==null){
      iso=new util.InsertionOrderedHashMap();
              iso.put("Style No","LOCKIN_STYLE_NO");
              iso.put("Style Po No","LOCKIN_STYLE_PO");
              iso.put("Project Qty","LOCKIN_STYLE_PROJECT_QTY");
              iso.put("Confirm Qty","LOCKIN_STYLE_CONFIRM_QTY");
              iso.put("Create Date","record_create_date");
       obj2string.put("Create Date",
                      exgui.verification.CellFormat.getDateStringFormater());
    }
  }
  public void toListLockInStyles()throws Exception{
    //common process to set cursor...
    javax.swing.JFrame jframe=processhandler.template.Properties.getMainFrame();
    java.awt.Cursor ksr=jframe.getContentPane().getCursor();
    try{
      jframe.getContentPane().setCursor(new java.awt.Cursor(java.awt.Cursor.WAIT_CURSOR));
      //specific process of doing this command.
      //setPreProdDisplayer();//set display preproduction head data to uper pannel.
      DB_LockinStyle dbLkS=DB_LockinStyle.getInstanceOfLckSty();
      dbLkS.CURRENT_EDITING_PRODHEAD_SEQ=
            newtimes.preproduction.Constants.CURRENT_PREPROD_HEAD_PK;
      newtimes.preproduction.guis.PnlLknStyList pnl=
          new newtimes.preproduction.guis.PnlLknStyList(dbLkS,5,
          (util.InsertionOrderedHashMap)util.MiscFunc.deepCopy(iso),
          obj2string);
      pnl.setPreferredSize(new java.awt.Dimension(800,150));
      toSetPanelUnderButtons(pnl,"Click A Row To Edit Lockin Style or Cost Sheet");
      processhandler.template.Properties.getCenteralControler().setDataProcesser(
          pnl
      );
      processhandler.template.Properties.getSplitFrame().setDividerLocation(0.5);
      processhandler.template.Properties.getSplitFrame().repaint();
      //disable some buttons...
      newtimes.production.process.prodmaintain.ToCheckB4StyleProc.setFunctionButtonStatus(
       true,false,false,false,false,true);
     /*
      processhandler.template.Properties.getSplitFrame().butnCopy.setEnabled(false);
      processhandler.template.Properties.getSplitFrame().butnNew.setEnabled(true);
      processhandler.template.Properties.getSplitFrame().butnPaste.setEnabled(false);
      processhandler.template.Properties.getSplitFrame().butnDelete.setEnabled(false);
      processhandler.template.Properties.getSplitFrame().butnEdit.setEnabled(false);
      processhandler.template.Properties.getSplitFrame().butnPrint.setEnabled(true);
      */
    }finally{
      jframe.getContentPane().setCursor(ksr);
    }
  }
}
