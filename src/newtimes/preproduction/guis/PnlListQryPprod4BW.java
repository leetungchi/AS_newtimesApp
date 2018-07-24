package newtimes.preproduction.guis;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import database.datatype.*;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

  public class PnlListQryPprod4BW extends processhandler.template.PnlTableEditor{
     protected newtimes.preproduction.process.DB_Preprod myHandler;
     TblMouseClick clickHandler=null;
      public PnlListQryPprod4BW(exgui.ultratable.PagedDataFactory pagedDataFxy,
                        int rowCounts,util.InsertionOrderedHashMap columnMapping,
                       java.util.Hashtable object2StringConvertor){
          super(pagedDataFxy, rowCounts, columnMapping, object2StringConvertor);
          myHandler=(newtimes.preproduction.process.DB_Preprod)pagedDataFxy;
      }

    public void doPrint(){}
    public int getEachPageRowCount(){return _rowCounts;}
    public Hashtable getObject2StringConvertor() {return klmObjKvtHt;}
    public util.InsertionOrderedHashMap getHeadColumnMap(){return tblHeadColumn;}
    public exgui.ultratable.PagedDataFactory getPagedDataFactory(){return dbHandler;}
    public Record setObject2Record(Record rec,int col,Object obj){return null;}
    public void makeTable(Vector vct){
      // add columns.
      Vector vct2Return=new Vector();
      for(int i=0;i<vct.size();i++){
        Record rec=(Record)vct.get(i);
        rec.getFieldName().add("EDIT_STYLE");
        rec.getValueFields().add("...");
        rec.getFieldName().add("EDIT_PROD_HEAD");
        rec.getValueFields().add("...");
        rec.getFieldName().add("EDIT_CLAIM");
        rec.getValueFields().add("...");
        rec.getFieldName().add("SC_PRINT");
        rec.getValueFields().add("...");
        rec.getFieldName().add("V_SHIP_DATA");
        rec.getValueFields().add("...");
        vct2Return.add(i,rec);
      }
      super.makeTable(vct2Return);
      getJtable().getColumnModel().getColumn(0).setPreferredWidth(90);
      getJtable().getColumnModel().getColumn(1).setPreferredWidth(65);
      getJtable().getColumnModel().getColumn(2).setPreferredWidth(60);
      getJtable().getColumnModel().getColumn(3).setPreferredWidth(60);
      getJtable().getColumnModel().getColumn(4).setPreferredWidth(80);
      getJtable().getColumnModel().getColumn(5).setPreferredWidth(80);

      getJtable().getColumnModel().getColumn(6).setPreferredWidth(60);
      getJtable().getColumnModel().getColumn(7).setPreferredWidth(35);//edit style
      getJtable().getColumnModel().getColumn(8).setPreferredWidth(65);//prod head
      getJtable().getColumnModel().getColumn(9).setPreferredWidth(40);//claim
      getJtable().getColumnModel().getColumn(10).setPreferredWidth(60);//print sc
      getJtable().getColumnModel().getColumn(11).setPreferredWidth(80);//ship data
      this.getJtable().setRowHeight(30);
    }
    class TblMouseClick extends java.awt.event.MouseAdapter{
      public void mouseClicked(java.awt.event.MouseEvent me){
         gridTableMouseEventHandler(me);
      }
    }

    java.util.HashMap readyToEditRecord()throws Exception{
      int recAt=getJtable().getSelectedRow();
      Record clickedRecord=(Record)getDisplayingRecords().get(recAt);
      java.util.HashMap hm=new java.util.HashMap();
      hm.put("clickedRecord",clickedRecord);
      int finalPk=-1;
      Object ctInforObj=clickedRecord.get("prod_ct_seq");
      if(ctInforObj!=null && (!ctInforObj.toString().equals("1"))){
        //find out the heading record,switch to head record.
         finalPk=clickedRecord.getInt("prod_heading_pk");
      }else{
        finalPk=clickedRecord.getInt(0);
      }

      Record rec=(Record)myHandler.findbyPk(finalPk);  //pgTblList.getDisplayingRecords().get(recAt);
      processhandler.template.Properties.getCenteralControler().setCurrentEditingMasterRecord(rec);
      newtimes.production.ProdMaintain_Properties.PRODUCTION_AUDIT_STATUS_COLUMN_NAME="PRODUCTION_AUDIT_STATUS";
      newtimes.preproduction.Constants.CURRENT_PREPROD_HEAD_PK=rec.getInt(0);
      newtimes.preproduction.Constants.CURRENT_PREPROD_HEAD_RECORD=rec;
      newtimes.preproduction.guis.tempProperties.orgProdHeadBuyerString.setLength(0);
      newtimes.preproduction.guis.tempProperties.orgProdHeadMakerString.setLength(0);
      String orgBuyer=(String)getJtable().getValueAt(recAt,1);
      String orgMaker=(String)getJtable().getValueAt(recAt,2);
      hm.put("orgBuyer",orgBuyer);
      hm.put("orgMaker",orgMaker);
      {
        if(ctInforObj==null){
          newtimes.preproduction.Constants.swithToGeneralMode();//there is no C/T infor ,it's normal process.
        }else{
          newtimes.preproduction.Constants.swithToNTHKMode();//there is has C/T infor ,it's C/T process.
        }
      }
      newtimes.production.ProdMaintain_Properties.IS_PO_SHIPPED=null;
      return hm;
    }

    public void gridTableMouseEventHandler(final java.awt.event.MouseEvent e) {
      //int selecRow,selecCol;
      if(getJtable().getSelectedColumn() < 7){
        return;
      }
      int recAt=getJtable().getSelectedRow();
      int columnAt=getJtable().getSelectedColumn();
      if(columnAt==9 && (!getJtable().getValueAt(recAt,1).toString().equals("511"))) return;

      if((e.getModifiers() & java.awt.event.InputEvent.BUTTON3_MASK) == java.awt.event.InputEvent.BUTTON3_MASK){
        e.consume();
        return;
      }

      processhandler.template.Properties.getMainFrame().setCursor(new Cursor(Cursor.WAIT_CURSOR));
      this.setCursor(new Cursor(Cursor.WAIT_CURSOR));
      getJtable().setCursor(new Cursor(Cursor.WAIT_CURSOR));
      util.ApplicationProperites.setProperties(
          this.getClass().getName()+"_TOP_RECORD_AT",new Integer(_rowPosition));

       if(recAt<0) return;
       //System.out.println("qry list table click at row:"+recAt);

       //clear all the selection..
      //getJtable().clearSelection();
       //see if to enter to edit master Record or just display showing detail of clicked record.
       try{
         //util.PublicVariable.APP_FRAME.setCursor(new Cursor(Cursor.WAIT_CURSOR));
         java.util.HashMap hm=readyToEditRecord();
         String orgBuyer=(String)hm.get("orgBuyer");
         String orgMaker=(String)hm.get("orgMaker");

        if (columnAt == 10) {
         //set current ultratable's 1st record position to system properties.
         //for going back to display.
         util.ApplicationProperites.setProperties(
            processhandler.template.Constants.XNT_LIST_QRY_RESLUT_BGN_AT,
          new Integer(_rowPosition));
          newtimes.preproduction.guis.tempProperties.orgProdHeadBuyerString.append(orgBuyer);
          newtimes.preproduction.guis.tempProperties.orgProdHeadMakerString.append(orgMaker);

          processhandler.template.Properties.getCenteralControler().doCommandExecute(
            new newtimes.production.process.prodmaintain.TgrToGotoOderPrint());

        }else if (columnAt ==11) {
          util.ApplicationProperites.setProperties(
             processhandler.template.Constants.XNT_LIST_QRY_RESLUT_BGN_AT,
           new Integer(_rowPosition));

             //list shipping data about this production
             processhandler.template.Properties.getCenteralControler().doCommandExecute(
                new newtimes.preproduction.process.TgrToListSimpleShipData());
        }else if (columnAt==9){
           //TgrListClaimWIthProdHead
           //if(!getJtable().getValueAt(recAt,1).toString().equals("511")) return;
           util.ApplicationProperites.setProperties(
              processhandler.template.Constants.XNT_LIST_QRY_RESLUT_BGN_AT,
            new Integer(_rowPosition));
            newtimes.preproduction.guis.tempProperties.orgProdHeadBuyerString.append(orgBuyer);
            newtimes.preproduction.guis.tempProperties.orgProdHeadMakerString.append(orgMaker);
           processhandler.template.Properties.getCenteralControler().doCommandExecute(
              new newtimes.production.process.prodmaintain.TgrListClaimWIthProdHead());

        }else if (columnAt == 8) {
          util.ApplicationProperites.setProperties(
             processhandler.template.Constants.XNT_LIST_QRY_RESLUT_BGN_AT,
           new Integer(_rowPosition));

           newtimes.preproduction.guis.tempProperties.orgProdHeadBuyerString.append(orgBuyer);
           newtimes.preproduction.guis.tempProperties.orgProdHeadMakerString.append(orgMaker);
           processhandler.template.Properties.getCenteralControler().doCommandExecute(
              new newtimes.preproduction.process.TrggerEditAPreprod());

        }else if (columnAt == 7) {
           //set current ultratable's 1st record position to system properties.
           //for going back to display.
           util.ApplicationProperites.setProperties(
              processhandler.template.Constants.XNT_LIST_QRY_RESLUT_BGN_AT,
            new Integer(_rowPosition));
            newtimes.preproduction.guis.tempProperties.orgProdHeadBuyerString.append(orgBuyer);
            newtimes.preproduction.guis.tempProperties.orgProdHeadMakerString.append(orgMaker);
           processhandler.template.Properties.getCenteralControler().doCommandExecute(
              new newtimes.production.process.prodmaintain.TgrToListStyles());
         }else {
         }
       }catch(Exception cmdE){
          cmdE.printStackTrace();
          util.ExceptionLog.exp2File(cmdE,"exp while dispatching action from query result list page");
       }finally{
          this.getJtable().setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
          processhandler.template.Properties.getMainFrame().setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
          this.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
       }
     }


    public void refineEditors(exgui.ultratable.MultiEditorJTable me ){
      //this.getJtable().getColumnModel().getColumn(5).setCellRenderer(cellrdr4Tvl);
      ButtonRenderer btnRdr=new ButtonRenderer();
      this.getJtable().getColumnModel().getColumn(7).setCellRenderer(btnRdr);
      this.getJtable().getColumnModel().getColumn(7).setCellEditor(new exgui.ultratable.ButtonEditor(new JCheckBox()));
      this.getJtable().getColumnModel().getColumn(8).setCellRenderer(btnRdr);
      this.getJtable().getColumnModel().getColumn(8).setCellEditor(new exgui.ultratable.ButtonEditor(new JCheckBox()));
      this.getJtable().getColumnModel().getColumn(10).setCellRenderer(btnRdr);
      this.getJtable().getColumnModel().getColumn(10).setCellEditor(new exgui.ultratable.ButtonEditor(new JCheckBox()));
      this.getJtable().getColumnModel().getColumn(11).setCellRenderer(btnRdr);
      this.getJtable().getColumnModel().getColumn(11).setCellEditor(new exgui.ultratable.ButtonEditor(new JCheckBox()));

      CellRender4Claim btnRdr4Claim=new CellRender4Claim();
      this.getJtable().getColumnModel().getColumn(9).setCellRenderer(btnRdr4Claim);
      this.getJtable().getColumnModel().getColumn(9).setCellEditor(new exgui.ultratable.ButtonEditor(new JCheckBox()));
      if(null==clickHandler){
        clickHandler = new TblMouseClick();
        getJtable().addMouseListener(clickHandler);
      }

    }


    public class ButtonRenderer extends JButton implements javax.swing.table.TableCellRenderer {

      public ButtonRenderer() {
        setOpaque(true);
      }

      public Component getTableCellRendererComponent(JTable table, Object value,
                       boolean isSelected, boolean hasFocus, int row, int column) {
        if (isSelected) {
          setForeground(table.getSelectionForeground());
          setBackground(table.getSelectionBackground());
        } else{
          setForeground(table.getForeground());
          setBackground(UIManager.getColor("Button.background"));
        }
        setText( (value ==null) ? "" : value.toString() );
        return this;
      }
    }



    class CellRender4Claim extends JButton implements javax.swing.table.TableCellRenderer {

        public CellRender4Claim() {
          setOpaque(true);
        }

        public Component getTableCellRendererComponent(JTable table, Object value,
                         boolean isSelected, boolean hasFocus, int row, int column) {
          Object buyer=getJtable().getValueAt(row,1);
          String txt=(("511".equals(buyer.toString()))?"...":"");
          if("".equals(txt)){
             setBackground(new java.awt.Color(0xE0, 0xE0, 0xE0));
          }else{
            if (isSelected) {
              setForeground(table.getSelectionForeground());
              setBackground(table.getSelectionBackground());
            } else {
              setForeground(table.getForeground());
              setBackground(UIManager.getColor("Button.background"));
            }
          }
          setText(txt);
          return this;
        }
      }



}
