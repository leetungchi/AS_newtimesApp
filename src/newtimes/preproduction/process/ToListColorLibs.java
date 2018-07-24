package newtimes.preproduction.process;
import java.awt.Cursor;
/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class ToListColorLibs extends ToInitUperAndDownPnl implements AbleToShowClibList {
  static java.util.HashMap conditionHm;
  static util.InsertionOrderedHashMap iso;
  public ToListColorLibs() {
      conditionHm=new java.util.HashMap();
      iso=new util.InsertionOrderedHashMap();
              iso.put("Dyer","j_dyer");
              iso.put("Color\nCode","PCLIB_COLOR_CODE");
              iso.put("Colon\nName","PCLIB_COLOR_NAME");
              iso.put("Material\nNo.","j_mtr_no");
              iso.put("Mill Mtr.\nNo","j_mill_no");
              iso.put("Lab Ref\nNo.","PCLIB_LABDIP_LAB_REF");
              iso.put("Lock In","PCLIB_LOCK");

  }
  public void toShowColorLibList()throws Exception{
    //common process to set cursor...
    javax.swing.JFrame jframe=processhandler.template.Properties.getMainFrame();
    java.awt.Cursor ksr=jframe.getContentPane().getCursor();
    try{
      util.ApplicationProperites.setProperties("PnlFbkPOList_beginRow_at",new Integer(1));
      util.ApplicationProperites.setProperties("PnlStyleList_beginRow_at",new Integer(1));
       jframe.getContentPane().setCursor(new Cursor(Cursor.WAIT_CURSOR));
      util.PublicVariable.APP_FRAME.setCursor(new Cursor(Cursor.WAIT_CURSOR));
      //specific process of doing this command.
      setPreProdDisplayer();//set display preproduction head data to uper pannel.
      //jframe.getContentPane().setCursor(new java.awt.Cursor(java.awt.Cursor.WAIT_CURSOR));

      DB_PreProdColorLib db=DB_PreProdColorLib.getInstance();
      db.setToRestoreOrNot(db.TO_LIST_FOR_NORMAL);
      db.preprodHeadSeq=newtimes.preproduction.Constants.CURRENT_PREPROD_HEAD_PK;
      newtimes.preproduction.guis.PnlPpClibList pnl=
          new newtimes.preproduction.guis.PnlPpClibList(
          db,5,
          (util.InsertionOrderedHashMap)util.MiscFunc.deepCopy(iso),
          new java.util.Hashtable());
      //pnl.setPreferredSize(new java.awt.Dimension(850,300));
      toSetPanelUnderButtons(pnl);
      processhandler.template.Properties.getCenteralControler().setDataProcesser(pnl);
      processhandler.template.Properties.getSplitFrame().setDividerLocation(0.5);
      processhandler.template.Properties.getSplitFrame().repaint();
      //disable some buttons...
      newtimes.production.process.prodmaintain.ToCheckB4StyleProc.setFunctionButtonStatus(
        true,false,false,false,true,true);
      /*
      processhandler.template.Properties.getSplitFrame().butnCopy.setEnabled(false);
      processhandler.template.Properties.getSplitFrame().butnNew.setEnabled(true);
      processhandler.template.Properties.getSplitFrame().butnPaste.setEnabled(false);
      processhandler.template.Properties.getSplitFrame().butnDelete.setEnabled(true);
      processhandler.template.Properties.getSplitFrame().butnEdit.setEnabled(false);
      processhandler.template.Properties.getSplitFrame().butnPrint.setEnabled(true);
      */
    }finally{
      jframe.getContentPane().setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
      util.PublicVariable.APP_FRAME.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
    }

  }
}
