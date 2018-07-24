package newtimes.preproduction.process;
import processhandler.commands.*;
import java.util.Vector;
public class ToListSimpleShipData implements AbleToListSimpleShipData{
  util.InsertionOrderedHashMap columns=new util.InsertionOrderedHashMap();
  public ToListSimpleShipData() {
  }
  public void toListSimpleShipData() throws processhandler.commands.CommandException{
    columns=new util.InsertionOrderedHashMap();
    columns.put("       SRN      ","ship_no");
    columns.put("ETD-DATE","SHIP_ETD_DATE");
    columns.put("STYLE","sty_style");
    columns.put("PO","sty_PO");
    if(util.PublicVariable.OPERATTING_CENTER.equals("NTHK")){
      columns.put("SHIP QTY", "ship_qty_data");
      columns.put("SHIP Buyer\nAct Prx.", "ship_byr_act_prx");
      columns.put("SHIP Buyer\nDoc Prx.", "ship_byr_doc_prx");
      columns.put("SHIP Maker\nAct Prx.", "ship_mkr_act_prx");
      columns.put("SHIP Maker\nDoc Prx.", "ship_mkr_doc_prx");
      columns.put("Ship Detail\nCreate Date", "ship_dtl_create_date");
      columns.put("Ship Detail\nCreate User", "record_create_user");
    }else{
      columns.put("QTY IN THIS SHIPPING", "ship_qty_data");
    }

      javax.swing.JFrame jframe=processhandler.template.Properties.getMainFrame();
      java.awt.Cursor ksr=jframe.getContentPane().getCursor();
      try{
        listshiphandler handler = new listshiphandler();
        exgui.ultratable.PagedTablePanel pnl =
            new exgui.ultratable.PagedTablePanel(handler, 20,
                                                 columns,
                                                 new java.util.Hashtable());

        pnl.setPreferredSize(new java.awt.Dimension(760, 450));
        String sc=null;
        try{
          sc=(String)newtimes.preproduction.Constants.CURRENT_PREPROD_HEAD_RECORD.get("prod_sc_no");
        }catch(Exception exp){
          exp.printStackTrace();
        }
        if(sc!=null){
          pnl.add(new javax.swing.JLabel("Shipment Data Of S/C:" + sc),
                  java.awt.BorderLayout.NORTH);
        }else{
          pnl.add(new javax.swing.JLabel("Shipment Data Of REF NO:" + newtimes.preproduction.Constants.CURRENT_PREPROD_HEAD_PK),
                  java.awt.BorderLayout.NORTH);
        }
        processhandler.template.Properties.getSplitFrame().setUpperPanel(pnl);
        processhandler.template.Properties.getSplitFrame().setLowerPanel(null);
        processhandler.template.Properties.getSplitFrame().setDividerLocation(1);
        processhandler.template.Properties.getSplitFrame().repaint();
        processhandler.template.Properties.getCenteralControler().
            setDataProcesser(null);
        newtimes.production.process.prodmaintain.ToCheckB4StyleProc.
            setFunctionButtonStatus(
            false, false, false, false, false, false);
        jframe.getContentPane().removeAll();
        jframe.getContentPane().add(processhandler.template.Properties.
                                    getSplitFrame());
        jframe.validate();
        jframe.repaint();
      }finally{
         jframe.getContentPane().setCursor(ksr);
      }
  }
  class listshiphandler extends exgui.ultratable.PagedDataFactoryAdapter {
    newtimes.preproduction.process.DB_Preprod myhandler=
         newtimes.preproduction.process.DB_Preprod.getInstance();
    public Vector getRecords(int bgn,int rowcount)throws Exception{
      return myhandler.listSimpleShippingData(bgn,rowcount);
    }

  }
}
