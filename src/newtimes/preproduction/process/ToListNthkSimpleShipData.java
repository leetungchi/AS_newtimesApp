package newtimes.preproduction.process;
import java.util.*;
/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class ToListNthkSimpleShipData extends ToListSimpleShipData {
  public ToListNthkSimpleShipData() {
  }
  public void toListShipmentData4Ntfe() throws processhandler.commands.CommandException{
      columns=new util.InsertionOrderedHashMap();
      columns.put("      SRN     ","ship_no");
      columns.put("ETD-DATE","SHIP_ETD_DATE");
      columns.put("   STYLE   ","sty_style");
      columns.put("      PO   ","sty_PO");
      columns.put("COLOR\nNAME","prod_color_name");
      columns.put("SHIP\nQTY", "ship_qty");
      columns.put("SHIP Buyer\nAct Prx.", "pri_byr_act_prx");
      columns.put("SHIP Buyer\nDoc Prx.", "pri_byr_doc_prx");
      columns.put("SHIP Maker\nAct Prx.", "pri_mkr_act_prx");
      columns.put("SHIP Maker\nDoc Prx.", "pri_mkr_doc_prx");
      columns.put("Ship Detail\nCreate Date", "ship_dtl_create_date");
      columns.put("Ship Detail\nCreate User    ", "record_create_user");


      javax.swing.JFrame jframe=processhandler.template.Properties.getMainFrame();
      java.awt.Cursor ksr=jframe.getContentPane().getCursor();
      String sc=null;
      try{
        sc=(String)newtimes.preproduction.Constants.CURRENT_PREPROD_HEAD_RECORD.get("prod_sc_no");
      }catch(Exception exp){
        exp.printStackTrace();
      }
      try{

    StringBuffer sb=new StringBuffer();
    sb.append("select a.ship_no, ");
    sb.append("d.SHIP_ETD_DATE,");
    sb.append("c.sty_style,c.sty_po,");
    sb.append("f.prod_color_name,");
    sb.append("e.PRI_BYR_ACT_PRX,");
    sb.append("e.PRI_BYR_DOC_PRX,");
    sb.append("e.PRI_MKR_ACT_PRX,");
    sb.append("e.PRI_MKR_DOC_PRX,");
    sb.append("g.ship_qty,");
    sb.append("c.sty_seq,a.SHIP_SC_PK, ");
    sb.append("to_char(b.record_create_date,'YYYY/MM/DD') as ship_dtl_create_date, ");
    sb.append("b.record_create_user ");
    sb.append("from ship_sc a,ship_style b,style c,shipping d,ship_price e,prod_color f,ship_qty g ");
    sb.append("where c.sty_sc_no='");sb.append(sc);sb.append("' ");
    sb.append("and b.SHIP_SC_PK=a.SHIP_SC_PK ");
    sb.append("and b.record_delete_flag='1' ");
    sb.append("and b.STY_SEQ=c.STY_SEQ ");
    sb.append("and a.SHIP_NO=d.SHIP_NO ");
    sb.append("and b.SHIP_STYLE_PK=e.SHIP_STYLE_PK ");
    sb.append("and e.PROD_COLOR_PK=f.PROD_COLOR_PK ");
    sb.append("and e.SHIP_PRICE_PK=g.ship_price_pk ");
    sb.append("and e.record_delete_flag='1' ");
    sb.append("order by substr(a.ship_no,7,6) , c.sty_seq,e.SHIP_PRICE_PK ");
    listshiphandler handler = new listshiphandler(sb.toString());
    exgui.ultratable.PagedTablePanel pnl =
        new exgui.ultratable.PagedTablePanel(handler, 20,
                                             columns,
                                             new java.util.Hashtable());

    pnl.setPreferredSize(new java.awt.Dimension(1050, 450));
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
  public void toListSimpleShipData() throws processhandler.commands.CommandException{
    if(util.PublicVariable.OPERATTING_CENTER.equals("NTHK")){
      toListSimpleShipDataNTHK();
    }else{
      toListShipmentData4Ntfe();
    }
  }
  public void toListSimpleShipDataNTHK() throws processhandler.commands.CommandException{
    columns=new util.InsertionOrderedHashMap();
    columns.put("      SRN     ","ship_no");
    columns.put("ETD-DATE","SHIP_ETD_DATE");
    columns.put("  STYLE  ","sty_style");
    //columns.put("PO","sty_PO");
      columns.put("SHIP\nQTY", "ship_qty_data");
      columns.put("SHIP Buyer\nAct Prx.", "ship_byr_act_prx");
      columns.put("SHIP Buyer\nDoc Prx.", "ship_byr_doc_prx");
      columns.put("SHIP Maker\nAct Prx.", "ship_mkr_act_prx");
      columns.put("SHIP Maker\nDoc Prx.", "ship_mkr_doc_prx");
      columns.put("Ship Detail\nCreate Date", "ship_dtl_create_date");
      columns.put("Ship Detail\nCreate User    ", "record_create_user");

      javax.swing.JFrame jframe=processhandler.template.Properties.getMainFrame();
      java.awt.Cursor ksr=jframe.getContentPane().getCursor();
      String sc=null;
      try{
        sc=(String)newtimes.preproduction.Constants.CURRENT_PREPROD_HEAD_RECORD.get("prod_sc_no");
      }catch(Exception exp){
        exp.printStackTrace();
      }
      try{

        StringBuffer sb=new StringBuffer();
        sb.append("select unique(a.ship_no),d.SHIP_ETD_DATE,c.sty_style,c.sty_po,c.sty_seq,a.SHIP_SC_PK, ");
        sb.append("GET_EH_SHIPPING_EH_STYLE_QTY(c.sty_seq,a.SHIP_SC_PK) as ship_qty_data ");
        sb.append(",(select e.PRI_BYR_ACT_PRX from ship_price e where b.SHIP_STYLE_PK=e.SHIP_STYLE_PK and e.record_delete_flag='1' and rownum=1) as ship_byr_act_prx");
        sb.append(",(select e.PRI_BYR_DOC_PRX from ship_price e where b.SHIP_STYLE_PK=e.SHIP_STYLE_PK and e.record_delete_flag='1' and rownum=1) as ship_byr_Doc_prx");
        sb.append(",(select e.PRI_MKR_ACT_PRX from ship_price e where b.SHIP_STYLE_PK=e.SHIP_STYLE_PK and e.record_delete_flag='1' and rownum=1) as ship_mkr_act_prx");
        sb.append(",(select e.PRI_MKR_DOC_PRX from ship_price e where b.SHIP_STYLE_PK=e.SHIP_STYLE_PK and e.record_delete_flag='1' and rownum=1) as ship_mkr_doc_prx");
        sb.append(",to_char(b.record_create_date,'YYYY/MM/DD') as ship_dtl_create_date");
        sb.append(",b.record_create_user ");
        sb.append("from ship_sc a,ship_style b,style c,shipping d  ");
        sb.append("where c.sty_sc_no='"); sb.append(sc); sb.append("' ");
        sb.append("and b.SHIP_SC_PK=a.SHIP_SC_PK ");
        sb.append("and b.record_delete_flag='1' ");
        sb.append("and b.STY_SEQ=c.STY_SEQ ");
        sb.append("and a.SHIP_NO=d.SHIP_NO ");

        listshiphandler handler = new listshiphandler(sb.toString());
        exgui.ultratable.PagedTablePanel pnl =
            new exgui.ultratable.PagedTablePanel(handler, 20,
                                                 columns,
                                                 new java.util.Hashtable());

        pnl.setPreferredSize(new java.awt.Dimension(760, 450));
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
    String sql;
    listshiphandler(String _sql){
      sql=_sql;
    }

    public Vector getRecords(int bgn,int rowcount)throws Exception{
      /*
      StringBuffer sb=new StringBuffer();
      sb.append("select unique(a.ship_no),d.SHIP_ETD_DATE,c.sty_style,c.sty_po,c.sty_seq,a.SHIP_SC_PK, ");
      sb.append("GET_EH_SHIPPING_EH_STYLE_QTY(c.sty_seq,a.SHIP_SC_PK) as ship_qty_data ");
      if(util.PublicVariable.OPERATTING_CENTER.equals("NTHK")){
        sb.append(",(select e.PRI_BYR_ACT_PRX from ship_price e where b.SHIP_STYLE_PK=e.SHIP_STYLE_PK and e.record_delete_flag='1' and rownum=1) as ship_byr_act_prx");
        sb.append(",(select e.PRI_BYR_DOC_PRX from ship_price e where b.SHIP_STYLE_PK=e.SHIP_STYLE_PK and e.record_delete_flag='1' and rownum=1) as ship_byr_Doc_prx");
        sb.append(",(select e.PRI_MKR_ACT_PRX from ship_price e where b.SHIP_STYLE_PK=e.SHIP_STYLE_PK and e.record_delete_flag='1' and rownum=1) as ship_mkr_act_prx");
        sb.append(",(select e.PRI_MKR_DOC_PRX from ship_price e where b.SHIP_STYLE_PK=e.SHIP_STYLE_PK and e.record_delete_flag='1' and rownum=1) as ship_mkr_doc_prx");
        sb.append(",to_char(b.record_create_date,'YYYY/MM/DD') as ship_dtl_create_date");
        sb.append(",b.record_create_user ");
      }
      sb.append("from ship_sc a,ship_style b,style c,shipping d  ");
      sb.append("where c.sty_sc_no='"); sb.append(_sc); sb.append("' ");
      sb.append("and b.SHIP_SC_PK=a.SHIP_SC_PK ");
      sb.append("and b.record_delete_flag='1' ");
      sb.append("and b.STY_SEQ=c.STY_SEQ ");
      sb.append("and a.SHIP_NO=d.SHIP_NO ");*/
      Vector vct=exgui2.CONST.BASIC_MAIN_EJB.getDatas(util.PublicVariable.USER_RECORD,sql,bgn,rowcount);
      return vct;
    }

  }

}
