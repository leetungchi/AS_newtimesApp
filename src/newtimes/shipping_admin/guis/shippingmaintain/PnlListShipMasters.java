package newtimes.shipping_admin.guis.shippingmaintain;
import processhandler.template.PnlListQryRslt;
import exgui.ultratable.*;
import newtimes.preproduction.process.DB_Preprod;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import database.datatype.Record;
import exgui.ultratable.*;
import java.util.Vector;
import exgui.MultiClassTableModel;
import java.io.*;
import  newtimes.shipping_admin.process.shiippingmaintain.DB_ShipMaster;
public class PnlListShipMasters extends PnlListQryRslt
    implements exgui.ultratable.MakeTableNotify{
    //java.awt.event.MouseMotionListener {
  protected DB_ShipMaster myHander;
  public static int PAGE_BEGIN;
  public static boolean listWithBuyerMaker=false;
  public PnlListShipMasters(DB_ShipMaster pagedDataFxy,
        int rowCount,util.InsertionOrderedHashMap columnMapping,
        java.util.Hashtable object2StringConvertor
    ){
     super(pagedDataFxy,rowCount,columnMapping,object2StringConvertor);
     myHander=pagedDataFxy;
     this.removeAll();
     this.add(new JLabel("Please click the rows"),BorderLayout.NORTH);
     this.add(this.pgTblList,BorderLayout.CENTER);
     pgTblList.setMakeTableNotifier(this);
     //this.MakingTable(null);
     this.MakingTable(pgTblList.getDisplayingRecords());
  }
  public PnlListShipMasters(DB_ShipMaster pagedDataFxy,
        int rowCount,util.InsertionOrderedHashMap columnMapping,
        java.util.Hashtable object2StringConvertor,
        String titleStr1,String btnStr1,
        String titleStr2,String btnStr2
    ){
     super(pagedDataFxy,
           rowCount,
           columnMapping,
           object2StringConvertor,
           titleStr1+PnlListQryRslt.EDITABLE_COLUMN_NAME_SPLITER+titleStr2,
           btnStr1+PnlListQryRslt.EDITABLE_COLUMN_NAME_SPLITER+btnStr2
           );
     myHander=pagedDataFxy;
     this.removeAll();
     this.add(new JLabel("Please click the rows"),BorderLayout.NORTH);
     this.add(this.pgTblList,BorderLayout.CENTER);
     //this.pgTblList.reload();
     pgTblList.setMakeTableNotifier(this);
     //pgTblList.getJtable().addMouseMotionListener(this);
     //this.MakingTable(null);
     this.MakingTable(pgTblList.getDisplayingRecords());
  }
  /*
  public void mouseDragged(java.awt.event.MouseEvent me){
  }
  public void mouseMoved(java.awt.event.MouseEvent me){
    //show fab-comm N type reason if necessary.

  } */
  public void MakingTable(java.util.Vector vct){
     if(vct==null||vct.size()==0)return;

        //System.out.println("makeing table,rendering now");
        //test if prod is sample.
        if(util.PublicVariable.OPERATTING_CENTER.equals("001") &&
           (util.PublicVariable.USER_RECORD.getInt(2)==newtimesejb.preproduction.PreProductionHead.USER_TYPE_ACCOUNTING_USERS||
            util.PublicVariable.USER_RECORD.getInt(2)==newtimesejb.preproduction.PreProductionHead.USER_TYPE_SUPERVIOSER_MIS)){
           StringBuffer sb=new StringBuffer();
           java.util.HashMap hmTestIsSmpl_Key_SRN=new java.util.HashMap();
           for(int i=0;i<vct.size();i++){
             Record rec=(Record)vct.get(i);
             if(sb.length()>0)sb.append(",");
             sb.append("'");
             sb.append(rec.get(1));//get SRN
             sb.append("'");
           }
           StringBuffer sql=new StringBuffer();

           sql.append("select ");
           sql.append("a.ship_no, ");
           sql.append("(select count(*) from prod_head c, ship_sc b ");
           sql.append("where b.prod_head_pk=c.PROD_HEAD_PK and b.record_delete_flag=1  ");
           sql.append("and c.PROD_IS_SAMPLE ='Y' and a.ship_no=b.ship_no ) as is_SMPL_COUNT  ");
           sql.append("from shipping a ");
           sql.append("where a.ship_no in ");
           sql.append("(");sql.append(sb.toString());sql.append(")");
           try{
             Vector vctTestSmpl =
                 exgui2.CONST.BASIC_MAIN_EJB.getDatas(util.PublicVariable.USER_RECORD,
                                                      sql.toString(), 1, 999999);
             for(int i=0;i<vctTestSmpl.size();i++){
               Record rec=(Record)vctTestSmpl.get(i);
               hmTestIsSmpl_Key_SRN.put(rec.get(0),rec.get(1).toString());
             }

             Vector vctNew=(Vector)util.MiscFunc.deepCopy(vct);
             vct.clear();
             for(int i=0;i<vctNew.size();i++){
               Record rec=(Record)util.MiscFunc.deepCopy(vctNew.get(i));
               rec.getFieldName().add("HAVE_SMPLE_PROD");
               String srn=(String)rec.get(1);
               String smplCount=(String)hmTestIsSmpl_Key_SRN.get(srn);
               rec.getValueFields().add(smplCount);
               vct.add(rec);
             }

           }catch(Exception exp){
             exp.printStackTrace();
           }

        }

        //only tpe cetner need the fab comm n type reason check and display in tool tip.
        if(util.PublicVariable.OPERATTING_CENTER.equals("001") &&
           (util.PublicVariable.USER_RECORD.getInt(2)==newtimesejb.preproduction.PreProductionHead.USER_TYPE_ACCOUNTING_USERS||
            util.PublicVariable.USER_RECORD.getInt(2)==newtimesejb.preproduction.PreProductionHead.USER_TYPE_SUPERVIOSER_MIS)){
          MyRenderer myder = new MyRenderer();
          Renderer4TestSmpl rnd4Smpl=new Renderer4TestSmpl();
          pgTblList.getJtable().getColumnModel().getColumn(2).setCellRenderer(myder);
          pgTblList.getJtable().getColumnModel().getColumn(0).setCellRenderer(rnd4Smpl);
        }
  }

  public class Renderer4TestSmpl extends JLabel
    implements javax.swing.table.TableCellRenderer{
    public Renderer4TestSmpl(){
    super();
   setOpaque(true); /* it\u00B4s essential */
}
 public Component getTableCellRendererComponent(
       javax.swing.JTable table, Object value,
       boolean isSelected, boolean hasFocus,
       int row, int column){
        String text = (value==null)?"":value.toString();
       //testing if fab comm n reason is "N" and "fab_comm is count is zero
     try{
       Record rec = (Record)pgTblList.getDisplayingRecords().get(row);
       String smplCount=(String)rec.get("HAVE_SMPLE_PROD");
       if (!"0".equals(smplCount)) {
         setBackground(new java.awt.Color(160, 160, 255)); // Decides the color
         StringBuffer sb=new StringBuffer();
           sb.append("<html><body>");
           sb.append("This SRN Contains Sample PO");
           sb.append("</body></html>");
         setToolTipText(sb.toString());
       } else {
         setBackground(new java.awt.Color(0xFF, 0xFF, 0xFF)); // Decides the color
         setToolTipText("");
       }
     }catch(Exception epxp){
       epxp.printStackTrace();

     }

      setText(text); /* Put the current text in the JLabel */
   return this;
  }
}





  public class MyRenderer extends JLabel
      implements javax.swing.table.TableCellRenderer{
      public MyRenderer(){
      super();
     setOpaque(true); /* it\u00B4s essential */
  }
   public Component getTableCellRendererComponent(
         javax.swing.JTable table, Object value,
         boolean isSelected, boolean hasFocus,
         int row, int column){
          String text = (value==null)?"":value.toString();
         //testing if fab comm n reason is "N" and "fab_comm is count is zero

       try{
         Record rec = (Record)pgTblList.getDisplayingRecords().get(row);
         Object obj_nbf_code = rec.get("prod_nbf_code");
         Object obj_fab_comm_count = rec.get("fab_comm_count");
         boolean isFabCommReasonN = false;
         if (obj_nbf_code != null &&
             obj_nbf_code.toString().toUpperCase().trim().equals("N")) {
           if (obj_fab_comm_count != null &&
               Integer.parseInt(obj_fab_comm_count.toString()) == 0) {
             isFabCommReasonN = true;

           }
         }
         if (isFabCommReasonN) {
           setBackground(new java.awt.Color(160, 160, 255)); // Decides the color
           String prod_comm_n_reason=(String)rec.get("PROD_COMM_N_REASON");
           StringBuffer sb=new StringBuffer();
           if(prod_comm_n_reason!=null){
             String tmpStr=util.MiscFunc.Replace(prod_comm_n_reason,"\n","<br>");
             sb.append("<html><body>");
             sb.append(tmpStr);
             sb.append("</body></html>");
           }
           setToolTipText(sb.toString());
         } else {
           setBackground(new java.awt.Color(0xFF, 0xFF, 0xFF)); // Decides the color
           setToolTipText("");
         }
       }catch(Exception epxp){
//         epxp.printStackTrace();

       }

        setText(text); /* Put the current text in the JLabel */
     return this;
    }
  }

  public void gridTableMouseEventHandler(MouseEvent e) {
    newtimes.shipping_admin.ShippingAdmin_Const.strIsShipClosed=null;
    if(getInsideJtable().getSelectedColumn() < (getInsideJtable().getColumnCount() - 2)){
      return;
    }
    //System.out.println(this.getClass().getName()+"_TOP_RECORD_AT");
    newtimes.shipping_admin.process.shiippingmaintain.ToListAddedStyles.PAGE_BEGIN=0;
    processhandler.template.Properties.getMainFrame().setCursor(new Cursor(Cursor.WAIT_CURSOR));
    this.setCursor(new Cursor(Cursor.WAIT_CURSOR));
    this.pgTblList.getJtable().setCursor(new Cursor(Cursor.WAIT_CURSOR));
    util.ApplicationProperites.setProperties(
        this.getClass().getName()+"_TOP_RECORD_AT",new Integer(pgTblList._rowPosition));
     int recAt=getInsideJtable().getSelectedRow();
     if(recAt<0) return;
     //System.out.println("qry list table click at row:"+recAt);
     int columnAt=getInsideJtable().getSelectedColumn();
     //clear all the selection..
     getInsideJtable().clearSelection();
     //see if to enter to edit master Record or just display showing detail of clicked record.
     java.awt.Container  myContaner=null;
      myContaner=processhandler.template.Properties.getMainFrame().getContentPane();
     try{
       //util.PublicVariable.APP_FRAME.setCursor(new Cursor(Cursor.WAIT_CURSOR));
       Record clickedRecord=(Record)pgTblList.getDisplayingRecords().get(recAt);
       String srn_No=clickedRecord.get(1).toString();
       Record rec= myHander.getRecordByPk(srn_No);
       newtimes.shipping_admin.ShippingAdmin_Const.SHIPPING_EDITING_HEAD_RECORD=(Record)
           util.MiscFunc.deepCopy(rec);
       for(int i=0;i<rec.getFieldName().size();i++){
         newtimes.shipping_admin.ShippingAdmin_Const.SHIPPING_EDITING_HEAD_RECORD.set(i,rec.get(i));
       }
       newtimes.shipping_admin.ShippingAdmin_Const.SHIPPING_EDITING_HEAD_RECORD.getModifiedFields().clear();
       newtimes.shipping_admin.ShippingAdmin_Const.CURRENT_EDITING_SHIP_SRN=srn_No;
        if (columnAt == (getInsideJtable().getColumnCount() - 1)) {
           //to edit ship head...
           PAGE_BEGIN=super.pgTblList._rowPosition;
           processhandler.template.Properties.getCenteralControler().doCommandExecute(
           new newtimes.shipping_admin.process.shiippingmaintain.TgrToEditShipMaster());
       }else if (columnAt == (getInsideJtable().getColumnCount() - 2)) {
         PAGE_BEGIN=super.pgTblList._rowPosition;
          processhandler.template.Properties.getCenteralControler().doCommandExecute(
             new newtimes.shipping_admin.process.shiippingmaintain.TgrToListAddedStyles()
           );
       }else {

       }
     }catch(Exception cmdE){
        cmdE.printStackTrace();
        util.ExceptionLog.exp2File(cmdE,"exp while dispatching action from query result list page");
     }finally{
        this.pgTblList.getJtable().setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
        processhandler.template.Properties.getMainFrame().setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
        this.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
     }
   }

}
