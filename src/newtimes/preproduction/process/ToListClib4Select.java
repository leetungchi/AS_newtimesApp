package newtimes.preproduction.process;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class ToListClib4Select implements AbleToListClib4Select{
  util.InsertionOrderedHashMap iso=null;
  public ToListClib4Select() {
    if(iso==null){
      iso=new util.InsertionOrderedHashMap();
              iso.put("Dyer","j_dyer");
              iso.put("Color Code","CLIB_COLOR_CODE");
              iso.put("Color Name","CLIB_COLOR_NAME");
              iso.put("Material No.","j_mtr_no");
              iso.put("Mill Material No","j_mill_no");
    }
  }
  public void toListClib4Select()throws Exception{
    //processhandler.template.Properties.getMainFrame().getContentPane().setCursor(new java.awt.Cursor(java.awt.Cursor.WAIT_CURSOR));
    processhandler.template.Properties.getSplitFrame().setLowerPanel(null);
    DB_ColorLib db=  DB_ColorLib.getInstance();
    db.setTargetMtrlDtls(newtimes.preproduction.Constants.PREPROD_USING_MTRL_DTLS);
    newtimes.preproduction.guis.PnlListOrgClib pnl=
        new newtimes.preproduction.guis.PnlListOrgClib(
         db,10,iso);
    processhandler.template.Properties.getSplitFrame().setUpperPanel(pnl);
    processhandler.template.Properties.getSplitFrame().setDividerLocation(1);
    processhandler.template.Properties.getSplitFrame().repaint();
    //disable some buttons...
    newtimes.production.process.prodmaintain.ToCheckB4StyleProc.
        setFunctionButtonStatus(
        false, false, false, false, false,false);
    /*
    processhandler.template.Properties.getSplitFrame().butnCopy.setEnabled(false);
    processhandler.template.Properties.getSplitFrame().butnNew.setEnabled(false);
    processhandler.template.Properties.getSplitFrame().butnPaste.setEnabled(false);
    processhandler.template.Properties.getSplitFrame().butnDelete.setEnabled(false);
    processhandler.template.Properties.getSplitFrame().butnEdit.setEnabled(false);
    processhandler.template.Properties.getSplitFrame().butnPrint.setEnabled(false);
    */
    }
}
