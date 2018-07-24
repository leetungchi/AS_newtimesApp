package newtimes.production;
import java.awt.Cursor;
import javax.swing.JTable;
import java.util.Vector;
import database.datatype.*;
/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class ProdMaintain_Properties {
  static public String IS_PO_SHIPPED=null;
  public ProdMaintain_Properties() {
  }
  static public String CMDS_PROD_MAINTAIN=
      "newtimes.production.CMD_PROD_MAINTAIN";
  static public String CMDS_SC_CT_MAINTAIN=
      "newtimes.production.CMDS_SC_CT_MAINTAIN";
  static public String CMDS_INIT4PRODMTN=
      "newtimes.production.CMDS_INIT4PRODMTN";
  public static String CMD_SET_PROD_CNFM_LIST=
       "newtimes.production.PROD_CONFIRM_LIST";
  public static String CMD_SET_ORDER_CHAGNE_COMMANDS=
       "newtimes.production.process.order_change_commands";
  static public database.datatype.Record EDITIONG_PRODUCTION_RECORD=null;
  static public newtimes.preproduction.guis.PnlTabbedButtons PROD_MAIN_TGR_PANEL=
      new newtimes.preproduction.guis.PnlTabbedButtons();
  static public newtimes.preproduction.guis.PnlTabbedButtons STYLE_TGR_PANEL=
      new newtimes.preproduction.guis.PnlTabbedButtons();
  static public newtimes.preproduction.guis.PnlTabbedButtons FABRIC_TGR_PANEL=
      new newtimes.preproduction.guis.PnlTabbedButtons();
  static public int CURRENT_SELECTED_STYLE_SEQ_IN_STYLE_LIST=0;
  static public int CURRENT_SELECTED_FABRIC_PO_SEQ_IN_FABRIC_PO_LIST=0;
  static public database.datatype.Record EDITING_STYLE_RECORD=null;
  static public database.datatype.Record EDITING_FABRIC_PO_RECORD=null;
  static public String PRODUCTION_AUDIT_STATUS_COLUMN_NAME=null;
 static public void setWaitCursor(){
    if(util.PublicVariable.APP_FRAME!=null){
     util.PublicVariable.APP_FRAME.setCursor(new Cursor(Cursor.WAIT_CURSOR));
     javax.swing.JFrame jframe=processhandler.template.Properties.getMainFrame();
     jframe.getContentPane().setCursor(new Cursor(Cursor.WAIT_CURSOR));
    }
  }
 static class MyMouseListener extends java.awt.event.MouseMotionAdapter{
    JTable _tbl;
    int endCol;
   MyMouseListener(JTable tbl,int endColumnCount){
     _tbl=tbl;endCol=endColumnCount+1;
   }
   public void mouseMoved(java.awt.event.MouseEvent e){
     int rowAt=_tbl.rowAtPoint(e.getPoint());
     //int columnAt=_tbl.columnAtPoint(e.getPoint());
     //if(columnAt<5)return;//too near the from column,no need.
     if(rowAt!=-1){
       StringBuffer _sb=new StringBuffer();
       _sb.append("<html><body>");
       StringBuffer sb=new StringBuffer();
       for(int i=0;i<endCol;i++){
         if(sb.length()>0)sb.append("<br>");//if this is not first item,add <br> tag
         String orgHeadColumn=_tbl.getColumnName(i);
         sb.append(util.MiscFunc.Replace(orgHeadColumn,"¡¿",""));
         sb.append(":");
         Object tmpObj=_tbl.getValueAt(rowAt,i);
         sb.append((tmpObj==null)?"":tmpObj.toString());
       }
       _sb.append(sb.toString());
       _sb.append("</body></html>");
       _tbl.setToolTipText(_sb.toString());
     }

   }
 }

 static public java.awt.event.MouseMotionListener getJTableToolTipGenerator(
      javax.swing.JTable jtable,int endColumn){
      return new MyMouseListener(jtable,endColumn);
   }
 static public void setNormalCursor(){
     util.PublicVariable.APP_FRAME.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
     javax.swing.JFrame jframe=processhandler.template.Properties.getMainFrame();
     jframe.getContentPane().setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
  }
 static public boolean isAbleToEdit(){
   //for   center TPE,MIS user is always to edit
   //for   center NONE-TPE center,only user NTERIC,DENNIS,FEANTHONYLIU 2-12"

   if(util.PublicVariable.OPERATTING_CENTER.equals("001")){
     if((util.PublicVariable.USER_RECORD.getInt(2)==
        newtimesejb.preproduction.PreProductionHead.USER_TYPE_SUPERVIOSER_MIS) ||
       (util.PublicVariable.USER_RECORD.get(3).toString().equals("MELISA WANG KS") )){
       return true;
     }else{
       return !isProductionAuditConfirmedOrPrinted();
     }
   }else{

     String userId=util.PublicVariable.USER_RECORD.get(0).toString();
     IS_PO_SHIPPED=null;
     if(userId.equals("NTERIC")||
        userId.equals("DENNIS")||
        userId.equals("CG")||
        (userId.length()>=10 &&
         userId.substring(userId.length()-10,userId.length()).equals("ANTHONYLIU"))){
       IS_PO_SHIPPED="FALSE";
       return true;
     }

     if(util.PublicVariable.OPERATTING_CENTER.equals("NTFE")){
       if((util.PublicVariable.USER_RECORD.getInt(2)==
          newtimesejb.preproduction.PreProductionHead.USER_TYPE_USERS)
          ){
         if(!util.PublicVariable.USER_RECORD.get(0).equals("WIRENEYU")){
           IS_PO_SHIPPED="TRUE";
            return false;
         }
       }
     }

      //if NTFE,NTJ,NTD,PW,BW,CG.... shipped,can not modify.
      //if(!util.PublicVariable.OPERATTING_CENTER.equals("NTHK")){
        if (IS_PO_SHIPPED == null) {
           try {
            if (newtimes.preproduction.Constants.CURRENT_PREPROD_HEAD_RECORD.
                get("production_audit_status").equals("7")) {
              IS_PO_SHIPPED="TRUE";
              return false;
            }
            IS_PO_SHIPPED="FALSE";
            return true;

          } catch (Exception exp) {
            exp.printStackTrace();
          }
        }else{
          return !(new Boolean(IS_PO_SHIPPED.toString()).booleanValue());
        }
    }
     return !(new Boolean(IS_PO_SHIPPED.toString()).booleanValue());
 }
 static public boolean isProductionAuditConfirmedOrPrinted(){
   try {
     if(newtimes.preproduction.Constants.CURRENT_PREPROD_HEAD_RECORD==null)return false;
     if(PRODUCTION_AUDIT_STATUS_COLUMN_NAME==null){
       PRODUCTION_AUDIT_STATUS_COLUMN_NAME="PRODUCTION_AUDIT_STATUS";
     }
     Object prodStatusObj =
         newtimes.preproduction.Constants.CURRENT_PREPROD_HEAD_RECORD.get(
         PRODUCTION_AUDIT_STATUS_COLUMN_NAME);
     if (prodStatusObj != null) {
       int auditStatusCode =
           newtimes.preproduction.Constants.CURRENT_PREPROD_HEAD_RECORD.getInt(
           PRODUCTION_AUDIT_STATUS_COLUMN_NAME);
       if (auditStatusCode ==
           newtimesejb.preproduction.PreProductionHead.AUDIT_STATUS_CONFIRMED ||
           auditStatusCode ==
           newtimesejb.preproduction.PreProductionHead.AUDIT_STATUS_PRINTED||
           auditStatusCode ==newtimesejb.preproduction.PreProductionHead.AUDIT_STATUS_SHIPPED ) {
         return true;
       }
     }
     return false;
   }catch(Exception e){
     e.printStackTrace();
     return false;
   }
 }
 static public String stylPriceSizeQtyTable2Text(javax.swing.JTable tbl,int priceColumnAt,String unit){
   boolean isTenPeice=false;
   java.text.NumberFormat nf=new java.text.DecimalFormat("##############.##");
   if(null!=unit){
     if(unit.startsWith("T."))isTenPeice=true;
   }
   String dashes="-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------";
   //to remove the price column
   StringBuffer totalSB=new StringBuffer();
   int  maxLength[]=new int[tbl.getColumnCount()];
   String modelData[][]=
       new String[tbl.getRowCount()+1][tbl.getColumnCount()];
   String blanks="                                        ";
   //fisrt is to trevorse all the cell,and determ the max char of each column
   //copy "TOTAL:" to column before price column of last row.
   //tbl.setValueAt("TOTAL:",tbl.getRowCount()-1,priceColumnAt-1);
   int colBegin=0;
   for(int j=colBegin;j<tbl.getColumnCount();j++){
     maxLength[j]=0;
     for (int i = -1; i < tbl.getRowCount(); i++) {
       //if(j==priceColumnAt){
       if(tbl.getColumnName(j).endsWith("Price")){
         if(j==priceColumnAt){
           modelData[i + 1][j] = " "; ;
           maxLength[j] = 1;
         }else{
           modelData[i + 1][j] = "";
           maxLength[j] = 0;
         }
         if (i == (tbl.getRowCount() - 1) && priceColumnAt==3) {
           if (j == (priceColumnAt - 3)) {
             modelData[i + 1][j] = "TOTAL:";
             maxLength[j]="TOTAL:".length();
           }
         }
       }else{
         Object cellData = null;
         if (i == -1){
           cellData = tbl.getColumnName(j);
           if(cellData!=null){
            cellData= util.MiscFunc.Replace(cellData.toString(),"¡¿"," ");
           }
         }else{
           cellData = tbl.getValueAt(i, j);
         }
         String cellDataString =
             (cellData == null) ? "" : cellData.toString();
         if(j>priceColumnAt && cellDataString.length()==0)cellDataString="0";
         if( i!=-1 && j>priceColumnAt && isTenPeice){
           cellDataString=nf.format(Double.parseDouble(cellDataString)*10);
         }

         if (cellDataString.length() > maxLength[j]) {
           maxLength[j] = (cellDataString.length())+ 1; //at least,leading a space.
         }
         modelData[i + 1][j] = cellDataString;
         if (i == (tbl.getRowCount() - 1)) {
           if (j == (priceColumnAt - 4)) {
             modelData[i + 1][j] = "TOTAL:";
           }
         }
       }

     }
   }
   int maxDshLength=0;
   for(int i=0;i<tbl.getRowCount()+1;i++){
     if(i==tbl.getRowCount()){
       totalSB.append(dashes.substring(0,maxDshLength));
       totalSB.append("\n");
     }

     for(int j=0;j<tbl.getColumnCount();j++ ){

        String destString="";
        if(maxLength[j]>0){
          destString=
              blanks.substring(0, maxLength[j] - modelData[i][j].length() + 1) + modelData[i][j];
              //util.MiscFunc.complementStringAlignRight(' ',modelData[i][j],maxLength[j] - modelData[i][j].length() + 1);
        }
        totalSB.append(destString);
        //if(j<tbl.getColumnCount()-1)totalSB.append("||");
     }
     //at each row,append the return character.
     totalSB.append("\n");
     if(i==0){
        maxDshLength=totalSB.toString().length();
       totalSB.append(dashes.substring(0,maxDshLength));
       totalSB.append("\n");
     }
   }
  return totalSB.toString();

 }
 static public String stylPriceSizeQtyTable2Text(javax.swing.JTable tbl,int priceColumnAt,String unit,Vector col_vt){
   boolean isTenPeice=false;
   java.text.NumberFormat nf=new java.text.DecimalFormat("##############.##");
   if(null!=unit){
     if(unit.startsWith("T."))isTenPeice=true;
   }
   String dashes="-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------";
   //to remove the price column
   StringBuffer totalSB=new StringBuffer();
   int  maxLength[]=new int[tbl.getColumnCount()];
   String modelData[][]=
       new String[tbl.getRowCount()+1][tbl.getColumnCount()];
   String blanks="                                        ";
   //fisrt is to trevorse all the cell,and determ the max char of each column
   //copy "TOTAL:" to column before price column of last row.
   //tbl.setValueAt("TOTAL:",tbl.getRowCount()-1,priceColumnAt-1);
   int colBegin=0;
   for(int j=colBegin;j<tbl.getColumnCount();j++){
     maxLength[j]=0;
     for (int i = -1; i < tbl.getRowCount(); i++) {
       //if(j==priceColumnAt){
       if(tbl.getColumnName(j).endsWith("Price")){
         if(j==priceColumnAt){
           modelData[i + 1][j] = " "; ;
           maxLength[j] = 1;
         }else{
           modelData[i + 1][j] = "";
           maxLength[j] = 0;
         }
         if (i == (tbl.getRowCount() - 1) && priceColumnAt==3) {
           if (j == (priceColumnAt - 3)) {
             modelData[i + 1][j] = "TOTAL:";
             maxLength[j]="TOTAL:".length();
           }
         }
       }else{
         Object cellData = null;
         if (i == -1){
           cellData = tbl.getColumnName(j);
           if(cellData!=null){
            cellData= util.MiscFunc.Replace(cellData.toString(),"¡¿"," ");
           }
         }else{
           cellData = tbl.getValueAt(i, j);
         }
         String cellDataString =
             (cellData == null) ? "" : cellData.toString();

         for (int z=0; z <col_vt.size();z++)
         {
            Record color_hm = (Record)col_vt.get(z);
            try {
              if (color_hm.get("PROD_COLOR_NAME").toString().equals(cellDataString)) {
                if (color_hm.get("PROD_COLOR_CODE") != null ) {
                  cellDataString = "(" + color_hm.get("PROD_COLOR_CODE") + ")" + cellDataString;
                }
                break;
              }
            }
            catch (Exception eee)
            {
            }
          }


         if(j>priceColumnAt && cellDataString.length()==0)cellDataString="0";
         if( i!=-1 && j>priceColumnAt && isTenPeice){
           cellDataString=nf.format(Double.parseDouble(cellDataString)*10);
         }

         if (cellDataString.length() > maxLength[j]) {
           maxLength[j] = (cellDataString.length())+ 1; //at least,leading a space.
         }
         modelData[i + 1][j] = cellDataString;
         if (i == (tbl.getRowCount() - 1)) {
           if (j == (priceColumnAt - 4)) {
             modelData[i + 1][j] = "TOTAL:";
           }
         }
       }

     }
   }
   int maxDshLength=0;
   for(int i=0;i<tbl.getRowCount()+1;i++){
     if(i==tbl.getRowCount()){
       totalSB.append(dashes.substring(0,maxDshLength));
       totalSB.append("\n");
     }

     for(int j=0;j<tbl.getColumnCount();j++ ){

        String destString="";
        if(maxLength[j]>0){
          destString=
              blanks.substring(0, maxLength[j] - modelData[i][j].length() + 1) + modelData[i][j];
              //util.MiscFunc.complementStringAlignRight(' ',modelData[i][j],maxLength[j] - modelData[i][j].length() + 1);
        }
        totalSB.append(destString);
        //if(j<tbl.getColumnCount()-1)totalSB.append("||");
     }
     //at each row,append the return character.
     totalSB.append("\n");
     if(i==0){
        maxDshLength=totalSB.toString().length();
       totalSB.append(dashes.substring(0,maxDshLength));
       totalSB.append("\n");
     }
   }
  return totalSB.toString();

 }


 static public String stylPriceSizeQtyTable2Text(javax.swing.JTable tbl,int priceColumnAt){
   return stylPriceSizeQtyTable2Text( tbl,priceColumnAt,null);
 }

 static public String stylQtyTable2Text(javax.swing.JTable tbl,int priceColumnAt){
   String dashes="-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------";
   //to remove the price column
   StringBuffer totalSB=new StringBuffer();
   int  maxLength[]=new int[tbl.getColumnCount()];
   String modelData[][]=
       new String[tbl.getRowCount()+1][tbl.getColumnCount()];
   String blanks="                                                                                                         ";
   //fisrt is to trevorse all the cell,and determ the max char of each column
   //copy "TOTAL:" to column before price column of last row.
   //tbl.setValueAt("TOTAL:",tbl.getRowCount()-1,priceColumnAt-1);
   for(int j=0;j<tbl.getColumnCount();j++){
     maxLength[j]=0;
     boolean hadPriceBlank=false;
     for (int i = -1; i < tbl.getRowCount(); i++) {
        if(j==priceColumnAt){
           modelData[i + 1][j] = "";
           maxLength[j] = 0;
       }else{
         Object cellData = null;
         if (i == -1){
           cellData = tbl.getColumnName(j);
           if(cellData!=null){
            cellData= util.MiscFunc.Replace(cellData.toString(),"¡¿"," ");
           }
         }else{
           cellData = tbl.getValueAt(i, j);
         }
         String cellDataString =
             (cellData == null) ? "" : cellData.toString();
         if(j>priceColumnAt && cellDataString.length()==0)cellDataString="0";

         if (cellDataString.length() > maxLength[j]) {
           maxLength[j] = (cellDataString.length()) + 1; //at least,leading a space.
         }
         modelData[i + 1][j] = cellDataString;
         if (i == (tbl.getRowCount() - 1)) {
           if (j == (priceColumnAt - 1)) {
             modelData[i + 1][j] = "TOTAL:";
           }
         }
       }

     }
   }
   int maxDshLength=0;
   for(int i=0;i<tbl.getRowCount()+1;i++){
     if(i==tbl.getRowCount()){
       totalSB.append(dashes.substring(0,maxDshLength));
       totalSB.append("\n");
     }

     for(int j=0;j<tbl.getColumnCount();j++ ){
        String destString=
            blanks.substring(0,maxLength[j]-modelData[i][j].length()+1) +modelData[i][j];
        //util.MiscFunc.complementStringAlignRight(' ',modelData[i][j],maxLength[j] - modelData[i][j].length() + 1);
        totalSB.append(destString);
        //if(j<tbl.getColumnCount()-1)totalSB.append("||");
     }
     //at each row,append the return character.
     totalSB.append("\n");
     if(i==0){
        maxDshLength=totalSB.toString().length();
       totalSB.append(dashes.substring(0,maxDshLength));
       totalSB.append("\n");
     }
   }
  return totalSB.toString();
 }

 static public String table2Text(javax.swing.JTable tbl){
   StringBuffer totalSB=new StringBuffer();
   int  maxLength[]=new int[tbl.getColumnCount()];
   String modelData[][]=
       new String[tbl.getRowCount()+1][tbl.getColumnCount()];
   String blanks="                                                                                                                                                                                       ";
   //fisrt is to trevorse all the cell,and determ the max char of each column
   for(int j=0;j<tbl.getColumnCount();j++){
     maxLength[j]=0;
     for (int i = -1; i < tbl.getRowCount(); i++) {
       Object cellData=null;
       if (i==-1){
          cellData=tbl.getColumnName(j);
          if(cellData!=null){
           cellData= util.MiscFunc.Replace(cellData.toString(),"¡¿"," ");
          }
       }else{
         cellData = tbl.getValueAt(i, j);
       }
       String cellDataString=
         (cellData==null)?"":cellData.toString();

       if(cellDataString.length()>maxLength[j]){
         maxLength[j]=(cellDataString.length())+1;//at least,leading a space.
       }
       modelData[i+1][j]=cellDataString;
     }
   }
   for(int i=0;i<tbl.getRowCount()+1;i++){
     for(int j=0;j<tbl.getColumnCount();j++ ){
        String destString=
            blanks.substring(0,maxLength[j]-modelData[i][j].length()+1) +modelData[i][j];
            //util.MiscFunc.complementStringAlignRight(' ',modelData[i][j],maxLength[j]-modelData[i][j].length()+1);
        totalSB.append(destString);
     }
     //at each row,append the return character.
     totalSB.append("\n");
   }
  return totalSB.toString();
 }
}
