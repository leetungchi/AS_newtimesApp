package newtimes.shipping_admin.ShipPrxQty;

import processhandler.template.PnlTableEditor;
import exgui.ultratable.*;
import database.datatype.*;
import util.InsertionOrderedHashMap;
import processhandler.*;
import java.util.*;
import javax.swing.JTable;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class PnlListQtyForPO extends PnlTableEditor {
  static String  COLUMN_COLOR_CODE=   "COLOR\nCODE";
  static int COLUMN_COLOR_CODE_AT=0;
  static String  COLUMN_COLOR_DESC=   "COLOR\nNAME¡¿";
  static int COLUMN_COLOR_NAME_AT=1;

  static String  COLUMN_CONTAINER=   "CONTAINER#";
  static int COLUMN_CONTAINER_AT = 2;

  static String  COLUMN_BUYER_ACT_PRX=" Act.";
  static int COLUM_BUYER_ACT_PRX_AT=0;static int COLUM_BUYER_DOC_PRX_AT=0;
  static int COLUM_MAKER_ACT_PRX_AT=0;static int COLUM_MAKER_DOC_PRX_AT=0;
  static String  COLUMN_BUYER_DOC_PRX=" Doc.";
  static String  COLUMN_MAKER_ACT_PRX="Act. ";
  static String  COLUMN_MAKER_DOC_PRX="Doc. ";
  static int COLUMN_QTY_1_AT=0;


  static String  COLUMN_SIZE_QTY_TOTAL=" TOTAL ";
  java.text.NumberFormat  formatter=new java.text.DecimalFormat("#######.##");
  java.text.NumberFormat  Dzformatter=new java.text.DecimalFormat("#######.00");
  static String dzDecimal[]={"00","08","16","25","33","41","50","58","66","75","83","91","00"};
  boolean isOnlyTotalQty=false;
  static int TOTAL_COLUMNAT=0;
  boolean _isDzUnit=false;
  FLOAT_QTY_VFY fltVfyTempUse=new FLOAT_QTY_VFY(10);
  Hashtable htEditors=new Hashtable();
  boolean isDataModified;
  String orgUnitString=null;
  String sizeColumn[]=null;
  java.util.Vector vctColorCode=null;
  java.util.HashMap  hmColorName=null;//key is prod_color_pk,value is color name.
  public PnlListQtyForPO() {
    super.jbtn1st.setVisible(false);
    super.jbtnLast.setVisible(false);
    super.jbtnNext.setVisible(false);
    super.jbtnPrev.setVisible(false);
    //MyMousAdpt myMousAdpt=new MyMousAdpt();
  }


  public java.util.Vector getColorVct(){
    try{
      if (vctColorCode == null) {
        StringBuffer sb = new StringBuffer();
        sb.append("select prod_color_pk,prod_color_code,prod_color_name || decode(prod_remark,null,'',' <'||prod_remark||'>') as prod_color_name ");
        sb.append("from prod_color where prod_color_pk in ");
        sb.append("(select prod_color_pk from price where pri_sty_seq=");
        sb.append(newtimes.shipping_admin.ShippingAdmin_Const.EDIT_SHIP_STYLE_STYLE_INT_SEQ);
        sb.append(")");
         Vector vct = exgui2.CONST.BASIC_MAIN_EJB.getDatas(
            util.PublicVariable.USER_RECORD, sb.toString(), 1, 999
          );
        vctColorCode=new Vector();
        hmColorName=new HashMap();
        for(int i=0;i<vct.size();i++){
          Record recTmpColor=(Record)vct.get(i);
          hmColorName.put(recTmpColor.get(0).toString(),(String)recTmpColor.get(2));
         vctColorCode.add(recTmpColor);
        }

      }
    }catch(Exception exp){
      exp.printStackTrace();
    }
    return vctColorCode;
  }

  public String[] getSizeColumn(){
    if(sizeColumn==null){
      try{
        String szClm = (String)newtimes.shipping_admin.ShippingAdmin_Const.
            EDITING_SHIPPING_STYLE_RECORD.get("_$org_sty_size_column");
        szClm=newtimes.shipping_admin.ShippingAdmin_Const.recnvDblCamaString(szClm);
        sizeColumn=util.MiscFunc.split(szClm,",,");
        if(szClm.trim().equals("")){
          sizeColumn=new String[]{};
        }
      }catch(Exception exp){
        exp.printStackTrace();
      }
    }
    return sizeColumn;
  }
  protected void makeTable(java.util.Vector vct){
    super.makeTable(vct);
//    if(!util.PublicVariable.OPERATTING_CENTER.equals("001")){

      getJtable().getColumnModel().getColumn(0).setPreferredWidth(170);
      getJtable().getColumnModel().getColumn(1).setMinWidth(0);
       getJtable().getColumnModel().getColumn(1).setMaxWidth(0);
//    }

      for(int i=2;i<getJtable().getColumnCount()-1;i++){
        getJtable().getColumnModel().getColumn(i).setPreferredWidth(45);

      }
   }


  protected Record setObject2Record(Record rec, int columnAt, Object value2update) {
    /**@todo Implement this exgui.ultratable.AbstractUltraTablePanel abstract method*/
    //throw new java.lang.UnsupportedOperationException("Method setObject2Record() not yet implemented.");
    try{
      rec.set(storedRecordColumn[columnAt], value2update);
      return rec;
    }catch(Exception exp){
      exp.printStackTrace();
      return null;
    }
  }
  protected InsertionOrderedHashMap getHeadColumnMap() {
    util.InsertionOrderedHashMap iso=new util.InsertionOrderedHashMap();

    iso.put(COLUMN_COLOR_DESC,"PROD_COLOR_PK");
    iso.put(COLUMN_CONTAINER,"PRI_CONTAINER");

    COLUM_BUYER_DOC_PRX_AT=iso.entrySet().size();
    iso.put(COLUMN_BUYER_DOC_PRX,"PRI_BYR_DOC_PRX");

    COLUM_BUYER_ACT_PRX_AT=iso.entrySet().size();
    iso.put(COLUMN_BUYER_ACT_PRX,"PRI_BYR_ACT_PRX");

    COLUM_MAKER_DOC_PRX_AT=iso.entrySet().size();
    iso.put(COLUMN_MAKER_DOC_PRX,"PRI_MKR_DOC_PRX");

    COLUM_MAKER_ACT_PRX_AT=iso.entrySet().size();
    iso.put(COLUMN_MAKER_ACT_PRX,"PRI_MKR_ACT_PRX");


    if(getSizeColumn().length==0){
      isOnlyTotalQty=true;
      COLUMN_QTY_1_AT = iso.entrySet().size();
      TOTAL_COLUMNAT=iso.entrySet().size();
      iso.put("TOTAL","QTY_TTL");
      return iso;
    }else{
      COLUMN_QTY_1_AT = iso.entrySet().size() ;
      for (int i = 1; i < getSizeColumn().length+1; i++) {
        iso.put(getSizeColumn()[i-1], "QTY_" + i);
      }
    }

    try{
      isOnlyTotalQty = false;
     TOTAL_COLUMNAT=iso.entrySet().size();
     iso.put("TOTAL","QTY_TTL");
      return iso;
    }catch(Exception exp){
      exp.printStackTrace();
      util.ExceptionLog.exp2File(exp,"");
    }
    return iso;
  }
  public void doPrint() throws java.lang.Exception {
    /**@todo Implement this processhandler.DataProcesser abstract method*/
  }
  protected int getEachPageRowCount() {
    /**@todo Implement this exgui.ultratable.AbstractUltraTablePanel abstract method*/
    //throw new java.lang.UnsupportedOperationException("Method getEachPageRowCount() not yet implemented.");
    return 999;
  }

  protected void refineEditors(MultiEditorJTable multiEditorJTableInSuper) {
    /**@todo Implement this exgui.ultratable.AbstractUltraTablePanel abstract method*/
     multiEditorJTableInSuper.addJComboBox(0,getColorVct(),"PROD_COLOR_NAME","PROD_COLOR_PK");
     multiEditorJTableInSuper.setTableColumn2Grp("BUYER Prx",2);
     multiEditorJTableInSuper.setTableColumn2Grp("BUYER Prx",3);
     multiEditorJTableInSuper.setTableColumn2Grp("MAKER Prx",4);
     multiEditorJTableInSuper.setTableColumn2Grp("MAKER Prx",5);

     multiEditorJTableInSuper.setTextEditorVerifiers(getObject2StringConvertor());
     ((exgui.MultiClassTableModel)multiEditorJTableInSuper.getJTable().getModel()).removeAllEditableColumn();
  }
  protected Hashtable getObject2StringConvertor() {
    Hashtable ht=new Hashtable();
    try{
      exgui.ultratable.CellTxtEditorFormat vfyPrices=new VfyFOBPrx();
      ht.put(COLUMN_BUYER_DOC_PRX  ,vfyPrices);
      ht.put(COLUMN_BUYER_ACT_PRX ,vfyPrices);
      ht.put(COLUMN_MAKER_DOC_PRX ,vfyPrices);
      ht.put(COLUMN_MAKER_ACT_PRX,vfyPrices);
      //Object myDzVfy=new myfldVfyObj(7,2);
      FLOAT_QTY_VFY fltVfyTempUse=new FLOAT_QTY_VFY(10);
      if(getSizeColumn().length==0){
          ht.put("TOTAL",fltVfyTempUse);
          isOnlyTotalQty=true;
      }else{
        for(int i=0;i<getSizeColumn().length;i++){
          ht.put(getSizeColumn()[i],fltVfyTempUse);
        }
        isOnlyTotalQty=false;
      }
      return ht;
    }catch(Exception e){
      e.printStackTrace();
      return null;
    }

  }
  protected PagedDataFactory getPagedDataFactory() {
    /**@todo Implement this exgui.ultratable.AbstractUltraTablePanel abstract method*/
    //throw new java.lang.UnsupportedOperationException("Method getPagedDataFactory() not yet implemented.");
    if(dbHandler==null){
      PrxQtyHandler _dbHandler = new PrxQtyHandler(false);
      dbHandler = _dbHandler;
      return _dbHandler;
    }else{
      return dbHandler;
    }
  }
  public boolean isDzUnit(){
    if(orgUnitString==null){
      try{
        orgUnitString = (String)newtimes.shipping_admin.ShippingAdmin_Const.
            EDITING_SHIPPING_STYLE_RECORD.get("_$ORG_STYLE_UNIT");
      }catch(Exception epxd){
        epxd.printStackTrace();
      }
    }
    return orgUnitString.startsWith("DZ");
    //return _isDzUnit;
  }

  protected class myfldVfyObj implements exgui.ultratable.CellTxtEditorFormat,exgui.Object2String{

  int _maxLength=0;
  int _intDigitLength=0,_floatDigitLength=0;
  String headString,tailString;
  String orgWarnningMsg="String must be in float format,such as 12345.91";
  String warnningMsg=null;
  String decimalPartString=".0.00.08.16.25.33.41.50.58.66.75.83.91.";
  public myfldVfyObj(int intDigitLength,int floatDigitLength){
    _maxLength=intDigitLength+floatDigitLength+1;//include "." character
    _intDigitLength=intDigitLength;
    _floatDigitLength=floatDigitLength;
    String totalString="##############################################";

    headString=totalString.substring(0,_intDigitLength);
    tailString=totalString.substring(0,_floatDigitLength);
  }
  public exgui.ultratable.KeyProcess getKeyListener(){
    return
        ((exgui.ultratable.CellTxtEditorFormat)exgui.verification.CellFormat.getDoubleFormat(
         _intDigitLength,_floatDigitLength)).getKeyListener();
  }

  public int getMaxLength(){return _maxLength ;}
  public String formatPromptMsg(){
    return warnningMsg;
  }
  public boolean isFormatValid(String org_inStr,int row,int column){
         String inStr=org_inStr;
         //if(column<=6)return true;
         if(inStr==null||inStr.trim().length()==0){
            inStr="0.0";
         }
         if(inStr.trim().length()==0) inStr="0.0";
           try {
            warnningMsg=orgWarnningMsg;
            if(inStr.indexOf(".")==-1 && inStr.length()>_intDigitLength) return false;
            if(inStr.indexOf(".")==(inStr.length()-1))return false;
            if(inStr.indexOf(".")==0)return false;
            if(inStr!=null && inStr.indexOf(".")!=-1){
              String arrDgs[]=util.MiscFunc.SplitByStringTokenizer(inStr,".");
              if(arrDgs[0].length()>_intDigitLength) return false;
              //Double d = new Double(((Number)formatter.parse((String)inStr)).doubleValue());
                 if(isDzUnit()){
                   if(arrDgs[1].length()==1)arrDgs[1]=arrDgs[1]+"0";
                   if(decimalPartString.indexOf(arrDgs[1])==-1){
                     warnningMsg="The Number of Size Qty after the Decimal Point should be one of fallowing :\n"+
                     "00,08,16,25,33,41,50.58,66,75,83,91";
                     return false;
                   }
                 }
              return true;
            }else{
              return true;
            }
          } catch (Exception ex) {
            //ex.printStackTrace();
            return false;
          }
  }
  public String Obj2String(Object obj2kvt){
     if(obj2kvt==null) return "";
     if(obj2kvt instanceof Float){
         if(((Float)obj2kvt).floatValue()==0)return "";
        String value= formatter.format(obj2kvt);
        return value;
     }
     if(obj2kvt instanceof Double){
         if(((Double)obj2kvt).doubleValue()==0)return "";
        String value= formatter.format(obj2kvt);
        return value;
      }else{
       String value=obj2kvt.toString();
        return value;
     }
  }
   public Object cellStringToObject(String String2kvt){
      if(String2kvt==null) return new Float(0);
      if(String2kvt.trim().length()==0) return new Float(0);
          try {
            Float d = new Float(
              ((Number)formatter.parse((String)String2kvt)).floatValue());
            return d;
          } catch (java.text.ParseException ex) {
            return new Float(0);
          }
   }
  }

  public class FLOAT_QTY_VFY implements exgui.ultratable.CellTxtEditorFormat ,exgui.Object2String{
   int _maxLength=0;
   Object myIntVfy=null;
   public  FLOAT_QTY_VFY(int maxLength){
      _maxLength=maxLength;
       myIntVfy=new myfldVfyObj(7,2); //exgui.verification.CellFormat.getDoubleFormat(7,2);
   }
   public int getMaxLength(){return _maxLength;}
   public String formatPromptMsg(){
     //return "String Must be numeric";
     return ((myfldVfyObj)myIntVfy).formatPromptMsg();
   }

   public KeyProcess getKeyListener(){
    return ((exgui.ultratable.CellTxtEditorFormat)myIntVfy).getKeyListener();
   }
   protected synchronized void sumTheRow(int row){
     if(isOnlyTotalQty)return;
     System.out.println("calles sumTheRow,row at:"+row);
     float total=0;
     for(int i=COLUMN_QTY_1_AT;i<TOTAL_COLUMNAT;i++){
       Object obj=getJtable().getValueAt(row,i);
       Object objclk=getJtable().getTableHeader().getColumnModel().getColumn(i).getHeaderValue();
       //System.out.println("obj in cell:"+row+","+i+" is:"+((obj==null)?"0":obj.toString()));

       if(objclk==null|| objclk.toString().trim().length()==0)continue;//this column should not add to total.
       if(obj!=null && obj.toString().trim().length()!=0) total+=Float.parseFloat(obj.toString());
       //00,08,16,25,33,41,50.58,66,75,83,91
     }
     //convert decimal part to Dz-persent degit.
     if(isDzUnit()){
       String floatData[] = util.MiscFunc.split(Dzformatter.format(total), ".");
       int decPart = java.lang.Math.round(Float.parseFloat("0." + floatData[1]) *
                                          12);
       //System.out.println("dec part of total in pc:"+decPart);
       float finalFloat = Float.parseFloat(floatData[0] + "." +
                                           dzDecimal[decPart]);
       getJtable().setValueAt(formatter.format(finalFloat), row,
                              TOTAL_COLUMNAT);
     }else{
       float finalFloat=total;
       getJtable().setValueAt(formatter.format(finalFloat), row,
                              TOTAL_COLUMNAT);

     }
   }
   public boolean isFormatValid(String inStr,int row,int column){
      if(!((exgui.ultratable.CellTxtEditorFormat)myIntVfy).isFormatValid(inStr,row,column))return false;
      getJtable().setValueAt(inStr,row,column);
      sumTheRow(row);
      return true;
   };
    public Object cellStringToObject(String String2kvt){
      return ((exgui.ultratable.CellTxtEditorFormat)myIntVfy).cellStringToObject(String2kvt);
    }
   public String Obj2String(Object obj){
      return ((exgui.Object2String)myIntVfy).Obj2String(obj);
   }
 }


  protected class FormaterPrx implements exgui.ultratable.CellTxtEditorFormat,exgui.Object2String{
   Object orgFvyObj=null;
   public FormaterPrx(){
     orgFvyObj=exgui.verification.CellFormat.getDoubleFormatAllowNull(7,2);
   }
   public exgui.ultratable.KeyProcess getKeyListener(){
     return ((exgui.ultratable.CellTxtEditorFormat)orgFvyObj).getKeyListener();
   }

   public int getMaxLength(){
     return ((exgui.ultratable.CellTxtEditorFormat)orgFvyObj).getMaxLength();
   }
   public String formatPromptMsg(){return ((exgui.ultratable.CellTxtEditorFormat)orgFvyObj).formatPromptMsg();}
   public boolean isFormatValid(String inStr,int row,int column){
     if(inStr==null||inStr.trim().length()==0)return true;
     return ((exgui.ultratable.CellTxtEditorFormat)orgFvyObj).isFormatValid(inStr,row,column);
   }
   public String Obj2String(Object obj2kvt){
     if(obj2kvt==null)return "";
     if(Float.parseFloat(obj2kvt.toString())==0)return "";
     return ((exgui.Object2String)orgFvyObj).Obj2String(obj2kvt);
   }
    public Object cellStringToObject(String String2kvt){
      if(String2kvt==null)return new Float(0);
      if(String2kvt.trim().equals(""))return new Float(0);
      return ((exgui.ultratable.CellTxtEditorFormat)orgFvyObj).cellStringToObject(String2kvt);
    }
 }

  public class VfyFOBPrx implements exgui.ultratable.CellTxtEditorFormat,exgui.Object2String{
    Object orgFvyObj=null;
    public VfyFOBPrx(){
      orgFvyObj=new FormaterPrx();
    }
    public int getMaxLength(){
      return ((exgui.ultratable.CellTxtEditorFormat)orgFvyObj).getMaxLength();
    }

    public exgui.ultratable.KeyProcess getKeyListener(){
      return ((exgui.ultratable.CellTxtEditorFormat)orgFvyObj).getKeyListener();
    }

    public String formatPromptMsg(){return ((exgui.ultratable.CellTxtEditorFormat)orgFvyObj).formatPromptMsg();}
    public boolean isFormatValid(String inStr,int row,int column){
      if(!getJtable().isCellEditable(row,column))return true;
      boolean isVld= ((exgui.ultratable.CellTxtEditorFormat)orgFvyObj).isFormatValid(inStr,row,column);
      if(!isVld)return isVld;

      //test if have to modify the remain 3 column.
      for(int i=COLUM_BUYER_DOC_PRX_AT;i<COLUMN_QTY_1_AT;i++){
        Object value=getJtable().getValueAt(row,i);
        if(value==null||
           value.toString().trim().length()==0||
           value.toString().trim().equals("0")){
          getJtable().setValueAt(inStr,row,i);
        }
      }
      return isVld;
    }
    public String Obj2String(Object obj2kvt){
      return ((exgui.Object2String)orgFvyObj).Obj2String(obj2kvt);
    }
     public Object cellStringToObject(String String2kvt){
       return ((exgui.ultratable.CellTxtEditorFormat)orgFvyObj).cellStringToObject(String2kvt);
     }

   }


}
