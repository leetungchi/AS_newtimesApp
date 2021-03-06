package newtimes.shipping.shippingmaintain;

import processhandler.template.PnlTableEditor;
import exgui.ultratable.*;
import database.datatype.*;
import util.InsertionOrderedHashMap;
import processhandler.*;
import java.util.Hashtable;
import java.util.HashMap;
import java.util.Vector;
import java.awt.*;
import javax.swing.*;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class QtyTableEditorFromSC extends PnlTableEditor {
  boolean init = false;
  boolean isOnlyOneEditingCell = false;
  int priceColumnAt = 0;
  String testUnit = null;
  boolean initializing = false;
  protected HashMap backupedSizeQty = new HashMap();

  public QtyTableEditorFromSC() {
    super.firstPage();
    super.jbtn1st.setVisible(false);
    super.jbtnLast.setVisible(false);
    super.jbtnNext.setVisible(false);
    super.jbtnPrev.setVisible(false);
    getJtable().setRowHeight(20);
    System.out.println("Actiave QtyTableEditorFromSC()");
  }
  public boolean isIniOK(){
    return ((QtyDataFactoryAdapterFromSC)dbHandler).isDBHandlerInitOK();
  }
  protected Record setObject2Record(Record rec, int columnAt, Object value2update) {
    return null;
  }
  protected InsertionOrderedHashMap getHeadColumnMap() {
    try {
      Vector importHeadColumn = new Vector();
      Vector vecSize = ((QtyDataFactoryAdapterFromSC)dbHandler).sizeType;
      if (!vecSize.isEmpty()) {
        importHeadColumn_label:
        for (int i = 0; i < vecSize.size(); i++) {
          database.datatype.Record recSize = (database.datatype.Record)vecSize.get(i);
          if (recSize.get("QTY_SIZE_SIZE") != null) {
            importHeadColumn.add(recSize.get("QTY_SIZE_SIZE"));
          } else {
            importHeadColumn = new Vector();
            isOnlyOneEditingCell = true;
            break importHeadColumn_label;
          }
        }
      }

      InsertionOrderedHashMap iso = new InsertionOrderedHashMap();
      byte sty_qty_type_num =
          Byte.parseByte(QtyDataFactoryAdapterFromSC.rec.get("STY_QTY_TYPE").toString());
      if ((sty_qty_type_num & 0x01) == 1) {
        iso.put("Licensee", "QTY_LICENSEE_NAME");
      }
      if ((sty_qty_type_num & 0x4) == 4) {
        iso.put("Color", "PROD_COLOR_PK");
      }

      iso.put("Price", "SHIP_PRICE_PK");
      if (importHeadColumn.size() > 0) {
        //there are some column of size type to mapping
        for (int i = 0; i < importHeadColumn.size(); i++) {
          iso.put(importHeadColumn.get(i), "##" + importHeadColumn.get(i));
        }
      }
      iso.put("Total", "_TOTAL_VALUE");
      return iso;
    } catch (Exception e) {
      e.printStackTrace();
      return null;
    }
  }

  public void doPrint() throws java.lang.Exception {
    /**@todo Implement this processhandler.DataProcesser abstract method*/
  }
  protected void refineEditors(MultiEditorJTable multiEditorJTableInSuper) {
    Vector priceVct = ((QtyDataFactoryAdapterFromSC)dbHandler).shipPrices;
    Vector licenseeVct = ((QtyDataFactoryAdapterFromSC)dbHandler).licensees;
    Vector colorVct = ((QtyDataFactoryAdapterFromSC)dbHandler).colors;
    try {
      byte sty_qty_type_num = Byte.parseByte(QtyDataFactoryAdapterFromSC.rec.get("STY_QTY_TYPE").toString());
      switch (sty_qty_type_num) {
        case 1:
          //only licensee
          multiEditorJTableInSuper.addJComboBox(0, licenseeVct, "BYMKR_BRIEF", "BYMKR_SEQ");
          priceColumnAt = 1;
          break;
        case 2:
          //only size.
          priceColumnAt = 0;
          break;
        case 3:
          //licensee. & size
          multiEditorJTableInSuper.addJComboBox(0, licenseeVct, "BYMKR_BRIEF", "BYMKR_SEQ");
          priceColumnAt = 1;
          break;
        case 4:
          //only Color
          multiEditorJTableInSuper.addJComboBox(0, colorVct, "PROD_COLOR_NAME", "PROD_COLOR_PK");
          priceColumnAt = 1;
          break;
        case 5:
          //color & licensee
          multiEditorJTableInSuper.addJComboBox(0, licenseeVct, "BYMKR_BRIEF", "BYMKR_SEQ");
          multiEditorJTableInSuper.addJComboBox(1, colorVct, "PROD_COLOR_NAME", "PROD_COLOR_PK");
          priceColumnAt = 2;
          break;
        case 6:
          //size & color
          multiEditorJTableInSuper.addJComboBox(0, colorVct, "PROD_COLOR_NAME", "PROD_COLOR_PK");
          priceColumnAt = 1;
          break;
        case 7:
          //color & licensee
          multiEditorJTableInSuper.addJComboBox(0, licenseeVct, "BYMKR_BRIEF", "BYMKR_SEQ");
          multiEditorJTableInSuper.addJComboBox(1, colorVct, "PROD_COLOR_NAME", "PROD_COLOR_PK");
          priceColumnAt = 2;
          break;
        case 8:
          priceColumnAt = 0;
      }

      multiEditorJTableInSuper.addJComboBox(priceColumnAt, priceVct, "PRI_BYR_DOC_PRX", "SHIP_PRICE_PK");
      multiEditorJTableInSuper.setTextEditorVerifiers(getObject2StringConvertor());
      if(getJtable().getRowCount()>1){
        ((exgui.MultiClassTableModel)multiEditorJTableInSuper.getJTable().getModel()).setCellEditablePolicy(
             new myCellEditablePolicy()
            );
      }

    } catch (Exception e) {
      e.printStackTrace();
      util.ExceptionLog.exp2File(e, "error at attempt to put JComboBox in JTable."+
                                 "\nlicensees:"+licenseeVct.toString()+
                                 "\ncolors:"+colorVct.toString()+
                                 "\nprices:"+priceVct.toString());
    }
    initializing = false;
  }
  protected int getEachPageRowCount() {
    return 99999;
  }
  protected Hashtable getObject2StringConvertor() {
    Hashtable ht = new Hashtable();
    try{
      Vector importHeadColumn = new Vector();
      Vector vecSize = ((QtyDataFactoryAdapterFromSC)dbHandler).sizeType;
      if (!vecSize.isEmpty()) {
        importHeadColumn_label:
        for (int i = 0; i < vecSize.size(); i++) {
          database.datatype.Record recSize = (database.datatype.Record)vecSize.get(i);
          if (recSize.get("QTY_SIZE_SIZE") != null) {
            importHeadColumn.add(recSize.get("QTY_SIZE_SIZE"));
          } else {
            importHeadColumn = new Vector();
            isOnlyOneEditingCell = true;
            break importHeadColumn_label;
          }
        }
      }

      //to test if with sizes column or not.
      Object fltVfy = exgui.verification.CellFormat.getDoubleFormatAllowNull(7, 2);
      Object myDzVfy = new myfldVfyObj(7, 2);
      if (importHeadColumn.size() == 0) {
         ht.put("Total", myDzVfy);
         isOnlyOneEditingCell = true;
      } else {
        isOnlyOneEditingCell = false;
        for (int i = 0; i < importHeadColumn.size(); i++) {
          ht.put(importHeadColumn.get(i), myDzVfy);
        }
      }
      return ht;
    } catch(Exception e) {
      e.printStackTrace();
      return null;
    }
  }

  protected PagedDataFactory getPagedDataFactory() {
    dbHandler = new QtyDataFactoryAdapterFromSC();
    return dbHandler;
  }

  public void doAddNew()throws Exception{
    try {
      util.MiscFunc.showProcessingMessage();
      if (getJtable().getRowCount() > 0) {
        Vector vct = getData2Update();
        if (vct.size() == 0)
          return; //no data to update,mabe cell is wrong..
        ((QtyDataFactoryAdapterFromSC)dbHandler).updateRecords(vct);
      }

      ((QtyDataFactoryAdapterFromSC)dbHandler).addRecord(null);
      this.goPage(1, 99999, false);
      ((QtyDataFactoryAdapterFromSC)dbHandler).udpateQtyTbl2Text(
          newtimes.production.ProdMaintain_Properties.table2Text(getJtable()));
      //exgui.verification.VerifyLib.showPlanMsg("Add New Record OK", "Add New OK");
    } catch(Exception e) {
      e.printStackTrace();
    }finally{
      util.MiscFunc.hideProcessingMessage();
    }
  }

  public void doUpdate() throws Exception{
    try {

      Vector vct = getData2Update();
      if (vct.size() == 0)
        return; //no data to update, maybe cell is wrong..
      //if QTY is zero,can not update.
      JTable tbl = getJtable();
      Object totalValueObj = tbl.getValueAt(tbl.getRowCount() - 1,
                                            tbl.getColumnCount() - 1);
      if (totalValueObj == null ||
          Float.parseFloat(totalValueObj.toString().trim()) == 0) {
        exgui.verification.VerifyLib.showAlert(
            "Quantity should be greater than Zero"
            , "Quantity should be greater than Zero");
        return;
      }
      if (((QtyDataFactoryAdapterFromSC)dbHandler).hm.get("from").equals("AddDetailList")) {
        float totalValue = Float.parseFloat(totalValueObj.toString());
        float shipQty = Float.parseFloat(ShipDetailEditFromSC.SHIP_QTY);
        float styleOrdQty = Float.parseFloat(ShipDetailEditFromSC.STYLE_ORDER_QTY);
        if ((totalValue + shipQty) > (styleOrdQty * 1.05)) {
          int result = exgui2.InfoMessage.Yes_No_Option(new JFrame(),
              "Over 105 %. If you insist on saving that press Y or vice versa.");
          util.MiscFunc.showProcessingMessage();
          if (result == 0) {
            ((QtyDataFactoryAdapterFromSC)dbHandler).updateRecords(vct);
            this.goPage(1, 99999, false);
            ((QtyDataFactoryAdapterFromSC)dbHandler).udpateQtyTbl2Text(
                newtimes.production.ProdMaintain_Properties.table2Text(
                getJtable()));
            //exgui.verification.VerifyLib.showPlanMsg("Update OK", "Update OK");
          }
        } else {
          ((QtyDataFactoryAdapterFromSC)dbHandler).updateRecords(vct);
          this.goPage(1, 99999, false);
          ((QtyDataFactoryAdapterFromSC)dbHandler).udpateQtyTbl2Text(
              newtimes.production.ProdMaintain_Properties.table2Text(
              getJtable()));
          //exgui.verification.VerifyLib.showPlanMsg("Update OK", "Update OK");
        }
      } else {
        ((QtyDataFactoryAdapterFromSC)dbHandler).updateRecords(vct);
        this.goPage(1, 99999, false);
        ((QtyDataFactoryAdapterFromSC)dbHandler).udpateQtyTbl2Text(
            newtimes.production.ProdMaintain_Properties.table2Text(
            getJtable()));
        //exgui.verification.VerifyLib.showPlanMsg("Update OK", "Update OK");
      }
    } catch(Exception e) {
      e.printStackTrace();
    }finally{
      util.MiscFunc.hideProcessingMessage();
    }
  }

  public void doDelete()throws Exception{
    try {
      int selectRow = getJtable().getSelectedRow();
      if (selectRow < 0 || (selectRow == getJtable().getRowCount() - 1)) {
        exgui.verification.VerifyLib.showPlanMsg(
            "Please Select A Row To Delete", "Please Select A Row");
        return;
      }
      if (!exgui.verification.VerifyLib.showConfirm(
          "Are You Sure To Delete This Record?", "Are You Sure ?")) {
        return;
      }
      util.MiscFunc.showProcessingMessage();
      if (getJtable().getRowCount() > 0) {
        Vector vct = getData2Update();
        if (vct.size() == 0)
          return; //no data to update,mabe cell is wrong..
        ((QtyDataFactoryAdapterFromSC)dbHandler).updateRecords(vct);
      }
      int recordColumnAtCount =
          (isOnlyOneEditingCell) ?
          ((getJtable().getColumnCount()) - priceColumnAt) :
          (((getJtable().getColumnCount()) - priceColumnAt - 1));

      HashMap recMap = ((QtyDataFactoryAdapterFromSC)dbHandler).getMappedRec2TblCell();
      Vector vct2Delete = new Vector();
      String modiUser = (String)util.PublicVariable.USER_RECORD.get("usr_code");
      for (int j = 0; j < recordColumnAtCount - 1; j++) {
        Record rec = (Record)recMap.get(String.valueOf(selectRow) + "_" +
                                        String.valueOf(j));
        rec.set("record_delete_user", modiUser);
        vct2Delete.add(rec);
      }
      ((QtyDataFactoryAdapterFromSC)dbHandler).deleteRecords(vct2Delete);
      //exgui.verification.VerifyLib.showPlanMsg("Delete OK", "Delete OK");
      this.goPage(1, 99999, false);
      ((QtyDataFactoryAdapterFromSC)dbHandler).udpateQtyTbl2Text(
          newtimes.production.ProdMaintain_Properties.table2Text(getJtable()));
      //find out the data to delete...
    }  catch(Exception e) {
      e.printStackTrace();
    }finally{
      util.MiscFunc.hideProcessingMessage();
    }
  }

  boolean isDzUnit() {
   try{
     if (testUnit == null) {
       testUnit = QtyDataFactoryAdapterFromSC.rec.get("STY_UNIT")==null?"":QtyDataFactoryAdapterFromSC.rec.get("STY_UNIT").toString();
     }
     return  testUnit.toLowerCase().trim().startsWith("dz");
   }catch(Exception e){
     e.printStackTrace();
     return false;
   }
 }

 synchronized boolean modifiedYYvalue(String str, int row, int column ) {
   if (initializing) return true;
   if (!getJtable().isCellEditable(row,column)) return true;
   //find out the last sumned row & column of YY1,
   try{
     float newQty = Float.parseFloat(str);
     Object ObjectTotal =
        getJtable().getValueAt(getJtable().getRowCount()-1, getJtable().getColumnCount()-1);
     float totalFloat = (ObjectTotal == null) ? 0 : Float.parseFloat(ObjectTotal.toString());
     Object objOrgQty =
       backupedSizeQty.get(String.valueOf(row) + "_" + String.valueOf(column));
       backupedSizeQty.put(String.valueOf(row) + "_" + String.valueOf(column), str);
     float orgFloat = (objOrgQty == null) ? 0 : Float.parseFloat(objOrgQty.toString());
     if (!isOnlyOneEditingCell) {
       //with size
       Object orgVtotalObj = getJtable().getValueAt(getJtable().getRowCount()-1, column);
       Object orgHtotalObj = getJtable().getValueAt(row, getJtable().getColumnCount()-1);
       float orgVtotal = (orgVtotalObj == null) ? 0 : Float.parseFloat(orgVtotalObj.toString());
       float orgHtotal = (orgHtotalObj == null) ? 0 : Float.parseFloat(orgHtotalObj.toString());
       if (isDzUnit()) {
         orgVtotal = QtyDataFactoryAdapterFromSC.minusDzValue(orgVtotal, orgFloat);
         orgHtotal = QtyDataFactoryAdapterFromSC.minusDzValue(orgHtotal, orgFloat);
         totalFloat = QtyDataFactoryAdapterFromSC.minusDzValue(totalFloat, orgFloat);
         orgVtotal = QtyDataFactoryAdapterFromSC.addDzValue(orgVtotal, newQty);
         orgHtotal = QtyDataFactoryAdapterFromSC.addDzValue(orgHtotal, newQty);
         totalFloat = QtyDataFactoryAdapterFromSC.addDzValue(totalFloat, newQty);
       } else {
         orgVtotal -= orgFloat;
         orgHtotal -= orgFloat;
         totalFloat -= orgFloat;
         orgVtotal += newQty;
         orgHtotal += newQty;
         totalFloat += newQty;
       }
       getJtable().setValueAt(new Float(orgVtotal), getJtable().getRowCount()-1, column);
       getJtable().setValueAt(new Float(orgHtotal), row, getJtable().getColumnCount()-1);
     } else {
        //no size.
        //directly sum all the value of each quentity column .
        totalFloat = 0;
        if (isDzUnit()) {
          int rowcount = getJtable().getRowCount() - 1;
          int colcount = getJtable().getColumnCount() - 1;
          for (int i = 0; i < rowcount; i++) {
            Object orgObjStr = getJtable().getValueAt(i, colcount);
            if (orgObjStr != null) {
              String objStr = orgObjStr.toString();
              float qtyValue = (objStr.trim().length() == 0) ? 0 : Float.parseFloat(objStr);
              totalFloat = QtyDataFactoryAdapterFromSC.addDzValue(totalFloat, qtyValue);
            }
          }
        } else {
          int rowcount = getJtable().getRowCount() - 1;
          int colcount = getJtable().getColumnCount() - 1;
          for (int i = 0; i < rowcount; i++) {
            Object orgObjStr = getJtable().getValueAt(i, colcount);
            if (orgObjStr != null) {
              String objStr = orgObjStr.toString();
              float qtyValue = (objStr.trim().length() == 0) ? 0 : Float.parseFloat(objStr);
              totalFloat += qtyValue;
            }
          }
        }
     }
     getJtable().setValueAt(str, row, column);
     getJtable().setValueAt(
          new Float(totalFloat), getJtable().getRowCount()-1, getJtable().getColumnCount()-1);
      return true;
   } catch(Exception e) {
     e.printStackTrace();
     return false;
   }
  }

  class myfldVfyObj implements exgui.ultratable.CellTxtEditorFormat,exgui.Object2String{
    java.text.DecimalFormat formatter = null; //new java.text.DecimalFormat("######.###");
    int _maxLength = 0;
    int _intDigitLength = 0, _floatDigitLength = 0;
    String headString, tailString;
    String orgWarnningMsg = "String must be in float format, such as 12345.91";
    String warnningMsg = null;

    public myfldVfyObj(int intDigitLength, int floatDigitLength) {
      _maxLength = intDigitLength + floatDigitLength + 1; //include "." character
      _intDigitLength = intDigitLength;
      _floatDigitLength = floatDigitLength;
      String totalString = "##############################################";
      formatter = new java.text.DecimalFormat("######0.00");
      headString = totalString.substring(0, _intDigitLength);
      tailString = totalString.substring(0, _floatDigitLength);
    }
    public exgui.ultratable.KeyProcess getKeyListener(){
      return ((exgui.ultratable.CellTxtEditorFormat)exgui.verification.CellFormat.getDoubleFormat(
       _intDigitLength,_floatDigitLength)).getKeyListener();
    }
    public int getMaxLength() {
      return _maxLength; }

    public String formatPromptMsg() {
      return warnningMsg; }

    public boolean isFormatValid(String inStr, int row, int column) {
      if (inStr == null)
        return true;
      if (inStr.trim().length() == 0)
        return true;
      if (column <= priceColumnAt)
        return true;
      try {
        warnningMsg = orgWarnningMsg;
        if (inStr.indexOf(".") == -1 && inStr.length() > _intDigitLength)
          return false;
        if (inStr.indexOf(".") == (inStr.length() - 1))
          return false;
        if (inStr.indexOf(".") == 0)
          return false;
        if (inStr != null && inStr.indexOf(".") != -1) {
          String arrDgs[] = util.MiscFunc.SplitByStringTokenizer(inStr, ".");
          if (arrDgs[0].length() > _intDigitLength)
            return false;
          Double d = new Double(((Number)formatter.parse((String)inStr)).
                                doubleValue());
          if (isDzUnit()) {
            //.08->1 .16->2 .25->3 .33->4 .41->5 .50->6 .58->7 .66->8 .75->9 .83->10 .91->11
            Object value = getJtable().getValueAt(row, column);
            if (value != null) {
              Double dx = new Double(value.toString()); //test if throws Exception;
              float xntFloatValue = Float.parseFloat(value.toString());
              String DecPartOfValue = util.MiscFunc.split(formatter.format(
                  xntFloatValue), ".")[1];
              if (!QtyDataFactoryAdapterFromSC.DecToDozeMapping.containsKey(
                  DecPartOfValue)) {
                warnningMsg =
                    "The Number of Size Qty after the Decimal Point should be one of fallowing :\n" +
                    "00,08,16,25,33,41,50.58,66,75,83,91";
                return false;
              }
              return (modifiedYYvalue(inStr, row, column));
            }
            return (modifiedYYvalue(inStr, row, column));
          }
          return (modifiedYYvalue(inStr, row, column));
        } else {
          if (exgui.verification.VerifyLib.isInteger(inStr)) {
            return (modifiedYYvalue(inStr, row, column));
          } else {
            return false;
          }
        }
      } catch (Exception ex) {
        ex.printStackTrace();
        return false;
      }
    }

    public String Obj2String(Object obj2kvt) {
      if (obj2kvt == null)
        return "";
      if (obj2kvt instanceof Double) {
        String value = String.valueOf(((Double)obj2kvt).doubleValue());
        return value;
      } else {
        String value = obj2kvt.toString();
        return value;
      }
    }

    public Object cellStringToObject(String String2kvt) {
      if (String2kvt == null)
        return null;
      if (String2kvt.trim().length() == 0)
        return null;
      try {
        Double d = new Double(
            ((Number)formatter.parse((String)String2kvt)).doubleValue());
        return d;
      } catch (java.text.ParseException ex) {
        return new Double(0.0);
      }
    }
  }

  class myCellEditablePolicy implements exgui.CellEditablePolicy {
    public boolean isCellEditable(int row, int column) {
      if (isOnlyOneEditingCell) {
        if (row == (getJtable().getRowCount() - 1)) {
          return false;
        }
      } else {
        if ((row == (getJtable().getRowCount() - 1)) ||
            (column == (getJtable().getColumnCount() - 1))) {
          return false;
        }
      }
      return true;
    }
  }

  public Vector getData2Update(){
    HashMap mappedRecordInCell = ((QtyDataFactoryAdapterFromSC)dbHandler).getMappedRec2TblCell();
    //depends on Color/Licencee will display or not.
    javax.swing.JTable _jtbl = getJtable();
    Vector ouptVct = new Vector();
    myfldVfyObj tmpVfyObj = new myfldVfyObj(7, 2);
    int rowcount = getJtable().getRowCount() - 1;
    //int endColmn=(getJtable().getColumnCount()-1)-priceColumnAt;

    int endColmn =
        (isOnlyOneEditingCell) ?
        ((getJtable().getColumnCount()) - priceColumnAt) :
        (((getJtable().getColumnCount()) - priceColumnAt - 1));

    //if(endColmn==1)endColmn=0;

    try {
      String modifyUser = (String)util.PublicVariable.USER_RECORD.get("usr_code");
      for (int i = 0; i < rowcount; i++) {
        for (int j = 0; j < endColmn - 1; j++) {
          Record rec = (Record)mappedRecordInCell.get(String.valueOf(i) + "_" +
              String.valueOf(j));
          rec.getFieldName().add("SHIP_PRICE_PK");
          rec.getValueFields().add(null);
          rec.set("record_modify_user", modifyUser);
          for (int k = 0; k < (priceColumnAt + 1); k++) {
            Object valueObj =
                ((exgui.ultratable.Wraper4tblCbx)_jtbl.getValueAt(i, k)).getValue();
            String clm = storedRecordColumn[k];
            rec.set(clm, valueObj);
          }
          Object qtyObj = _jtbl.getValueAt(i, j + priceColumnAt + 1).toString();
          if (qtyObj != null && (!qtyObj.toString().trim().equals(""))) {
            String qtyValue = qtyObj.toString();
            if (!tmpVfyObj.isFormatValid(qtyValue, i, j + priceColumnAt + 1)) {
              exgui.verification.VerifyLib.showAlert(tmpVfyObj.formatPromptMsg()
                  , "Data Format Error");
              _jtbl.editCellAt(i, j + priceColumnAt + 1);
              return new Vector();
            }
            QtyDataFactoryAdapterFromSC.Dz2Record(rec, qtyObj.toString());
          } else {
            QtyDataFactoryAdapterFromSC.Dz2Record(rec, 0);
          }
          ouptVct.add(rec);
        }
      }
    } catch (Exception e) {
      e.printStackTrace();
      return new Vector();
    }
    return ouptVct;
  }

  protected void makeTable(Vector vct){
    initializing = true;
    if (vct != null) {
      super.makeTable(vct);
      sumEveryColumn();
    }
    initializing = false;
  }

  protected synchronized void sumEveryColumn(){
    initializing = true;
    backupedSizeQty.clear();
    if (getDisplayingRecords().size() < 1)
      return;
    try {
      Vector importHeadColumn = new Vector();
      Vector vecSize = ((QtyDataFactoryAdapterFromSC)dbHandler).sizeType;
      if (!vecSize.isEmpty()) {
        importHeadColumn_label:
        for (int i = 0; i < vecSize.size(); i++) {
          database.datatype.Record recSize = (database.datatype.Record)vecSize.get(i);
          if (recSize.get("QTY_SIZE_SIZE") != null) {
            importHeadColumn.add(recSize.get("QTY_SIZE_SIZE"));
          } else {
            importHeadColumn = new Vector();
            isOnlyOneEditingCell = true;
            break importHeadColumn_label;
          }
        }
      }

      if (importHeadColumn.size() == 0) {
        isOnlyOneEditingCell = true;
        float totalQtyValue = 0;
        for (int i = 0; i < (getJtable().getRowCount() - 1); i++) {
          Object qtyObj = getJtable().getValueAt(i, getJtable().getColumnCount() - 1);
          backupedSizeQty.put(
              String.valueOf(i) + "_" + String.valueOf(0), qtyObj);
          float fltValue = (qtyObj == null) ? 0 :
              Float.parseFloat(qtyObj.toString());
          if (isDzUnit()) {
            totalQtyValue = QtyDataFactoryAdapterFromSC.addDzValue(totalQtyValue, fltValue);
          } else {
            totalQtyValue += fltValue;
          }
        }
        exgui.ultratable.Wraper4tblCbx blankFld = new exgui.ultratable.
            Wraper4tblCbx(new Integer( -999), "");
        int blankClmCount = getJtable().getColumnCount() - 2;
        for (int i = 0; i < blankClmCount; i++) {
          getJtable().setValueAt(
              blankFld, getJtable().getRowCount() - 1, i);
        }
        getJtable().setValueAt("Total",
                               getJtable().getRowCount() - 1,
                               getJtable().getColumnCount() - 2);
        getJtable().setValueAt(new Float(totalQtyValue),
                               getJtable().getRowCount() - 1,
                               getJtable().getColumnCount() - 1);
      } else {
        //find out column name of extends column
        isOnlyOneEditingCell = false;
        int extendColumnBgnAt = 0;
        int extendColumnEndAt = getJtable().getColumnCount() - 1;
        for (int i = 0; i < getJtable().getColumnCount() - 1; i++) {
          String headColumnName = getJtable().getColumnName(i);
          if (headColumnName.equals(importHeadColumn.get(0).toString())) {
            extendColumnBgnAt = i;
            break;
          }
        }
        float hzTotal[] = new float[getJtable().getRowCount() - 1];
        float vtTotal[] = new float[importHeadColumn.size()];
        backupedSizeQty.clear();
        float theEndTotal = 0;
        for (int j = 0; j < getJtable().getRowCount() - 1; j++) {
          for (int i = extendColumnBgnAt; i < extendColumnEndAt; i++) {
            Object objValue = getJtable().getValueAt(j, i);
            float qtyValue = (objValue == null) ? 0 :
                Float.parseFloat(objValue.toString());
            if (isDzUnit()) {
              hzTotal[j] =
                  QtyDataFactoryAdapterFromSC.addDzValue(hzTotal[j], qtyValue);
              vtTotal[i - extendColumnBgnAt] =
                  QtyDataFactoryAdapterFromSC.addDzValue(vtTotal[i -
                  extendColumnBgnAt], qtyValue);
            } else {
              hzTotal[j] = hzTotal[j] + qtyValue;
              vtTotal[i - extendColumnBgnAt] =
                  vtTotal[i - extendColumnBgnAt] + qtyValue;
            }
            backupedSizeQty.put(String.valueOf(j) + "_" + String.valueOf(i), objValue);
          }
          if (isDzUnit()) {
            theEndTotal = QtyDataFactoryAdapterFromSC.addDzValue(theEndTotal, hzTotal[j]);
          } else {
            theEndTotal += hzTotal[j];
          }
          getJtable().setValueAt(
              new Float(hzTotal[j]), j, extendColumnEndAt); //set to end of the row.
        }

        for (int i = extendColumnBgnAt; i < extendColumnEndAt; i++) {
          getJtable().setValueAt(
              new Double(String.valueOf(vtTotal[i - extendColumnBgnAt])),
              getJtable().getRowCount() - 1, i);
        }
        exgui.ultratable.Wraper4tblCbx blankFld = new exgui.ultratable.
            Wraper4tblCbx(new Integer(-999), "");
        for (int i = 0; i < extendColumnBgnAt; i++) {
          getJtable().setValueAt(
              blankFld, getJtable().getRowCount() - 1, i);
        }
        Object objTotalString = new exgui.ultratable.Wraper4tblCbx(new Integer(-999), "Total");
        getJtable().setValueAt(objTotalString, getJtable().getRowCount() - 1,
                               extendColumnBgnAt - 1);
        getJtable().setValueAt(new Float(theEndTotal),
                               getJtable().getRowCount() - 1, extendColumnEndAt);
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    initializing = false;
  }
}
