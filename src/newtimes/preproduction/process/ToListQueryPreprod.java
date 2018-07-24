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

public class ToListQueryPreprod implements processhandler.commands.AbleToListQryResult {
  protected HashMap conditions;
  static protected util.InsertionOrderedHashMap columnNameMap=null;
  public java.util.HashMap qryConditions=null;
  boolean isTpeUser=true;
  public ToListQueryPreprod(HashMap qryConditions) {
      conditions=qryConditions;
      //if(columnNameMap==null){
      if(!util.PublicVariable.OPERATTING_CENTER.equals("001")){
         isTpeUser=false;
      }
       if(isTpeUser){
         columnNameMap = new util.InsertionOrderedHashMap();
         columnNameMap.put("DEP\nYEAR\nSEASON       ", "DEP_YEAR_SEASON");
         columnNameMap.put("BUYER", "j_buyer");
         columnNameMap.put("MAKER", "j_maker");
         columnNameMap.put("DIV.", "j_div");
         columnNameMap.put("Board/RANGE    \nS/C", "RANGE_SC_NO");
         columnNameMap.put("GRP-NO\nGRP-NAME", "GroupDatas");
         columnNameMap.put("Prod\nRef No",
                           "PROD_HEAD_PK");
       }else if(util.PublicVariable.OPERATTING_CENTER.equals("NTHK")){
         columnNameMap = new util.InsertionOrderedHashMap();
         columnNameMap.put("DEP\nYEAR\nSEASON       ", "DEP_YEAR_SEASON");
         columnNameMap.put("BUYER", "j_buyer");
         columnNameMap.put("MAKER", "j_maker");
         columnNameMap.put("VENDOR", "nthk_vdr");
         columnNameMap.put("Board/RANGE\nS/C", "RANGE_SC_NO");
         columnNameMap.put("Cust. PO.","cust_no");
         columnNameMap.put("GRP-NO\nGRP-NAME     ", "GroupDatas");
         columnNameMap.put("Prod\nRef No",
                           "PROD_HEAD_PK");
       }else{
         columnNameMap = new util.InsertionOrderedHashMap();
         columnNameMap.put("DEP\nYEAR\nSEASON       ", "DEP_YEAR_SEASON");
         columnNameMap.put("BUYER", "j_buyer");
         columnNameMap.put("MAKER", "j_maker");
         columnNameMap.put("DIV.", "j_div");
         columnNameMap.put("Board/RANGE\nS/C", "RANGE_SC_NO");
         columnNameMap.put("Cust. PO.","cust_no");
         columnNameMap.put("GRP-NO\nGRP-NAME     ", "GroupDatas");
         columnNameMap.put("Prod\nRef No",
                           "PROD_HEAD_PK");
       }
      //}
  }
  public util.InsertionOrderedHashMap getHeadColumns(){
    try{
      return (util.InsertionOrderedHashMap)util.MiscFunc.deepCopy(columnNameMap);
    }catch(Exception e){
      e.printStackTrace();
      return null;
    }
  }
  public void toListQryResult4Bw()throws Exception{
    newtimes.preproduction.Constants.BYMKR_WAREHOUSE_STRING =null;
    //common process to set cursor...
    javax.swing.JFrame jframe=processhandler.template.Properties.getMainFrame();
    java.awt.Cursor ksr=jframe.getContentPane().getCursor();
    try{
      jframe.getContentPane().setCursor(new java.awt.Cursor(java.awt.Cursor.WAIT_CURSOR));
      //specific process of doing this command.
      DB_Preprod dbEngin=DB_Preprod.getInstance();
      dbEngin.conditions=PP_Maintain_CmdSet.qryConditions;
      columnNameMap = new util.InsertionOrderedHashMap();

      columnNameMap.put("DEP\nYEAR\nSEASON       ", "DEP_YEAR_SEASON");//0
      columnNameMap.put("BUYER", "j_buyer");//1
      columnNameMap.put("MAKER", "j_maker");//2
      columnNameMap.put("DIV.", "j_div");//3
      columnNameMap.put("Board/RANGE\nS/C", "RANGE_SC_NO");//4
      columnNameMap.put("Cust. PO.","cust_no");//5
      columnNameMap.put("Prod\nRef No","PROD_HEAD_PK");//6
      columnNameMap.put("Edit\nStyle","EDIT_STYLE");//7
      columnNameMap.put("Edit\nProd Head","EDIT_PROD_HEAD");//8
      columnNameMap.put("Edit\nClaim","EDIT_CLAIM");//9
      columnNameMap.put("S/C Print","SC_PRINT");//10
      columnNameMap.put("Shipping\nData","V_SHIP_DATA");//11
      newtimes.preproduction.guis.PnlListQryPprod4BW pnl=
          new newtimes.preproduction.guis.PnlListQryPprod4BW(dbEngin,13,
          columnNameMap,new java.util.Hashtable()
       );
      Integer RowPos=
          (Integer)util.ApplicationProperites.getProperties(processhandler.template.Constants.XNT_LIST_QRY_RESLUT_BGN_AT);
      if(null==RowPos){
        pnl._rowPosition=1;
      }else{
        pnl._rowPosition=RowPos.intValue();
      }

      pnl.setPreferredSize(new java.awt.Dimension(760,450));
      //the reload process will change course,take care
      jframe.getContentPane().setCursor(ksr);
      pnl.reload();
      jframe.getContentPane().setCursor(new java.awt.Cursor(java.awt.Cursor.WAIT_CURSOR));

      processhandler.template.Properties.getSplitFrame().setUpperPanel(pnl);
      processhandler.template.Properties.getSplitFrame().setLowerPanel(null);
      processhandler.template.Properties.getSplitFrame().setDividerLocation(1);
      processhandler.template.Properties.getSplitFrame().repaint();
      processhandler.template.Properties.getCenteralControler().setDataProcesser(null);

      newtimes.production.process.prodmaintain.ToCheckB4StyleProc.setFunctionButtonStatus(
        false,false,false,false,false,false);
     processhandler.template.Properties.getSplitFrame().butnEdit.setText("CONFIRM EDIT");
      jframe.getContentPane().removeAll();
      jframe.getContentPane().add(processhandler.template.Properties.getSplitFrame());
      jframe.setTitle("PRODUCTION MAINTAIN: QUERY RESULT");
      jframe.validate();
      jframe.repaint();

    }finally{
      jframe.getContentPane().setCursor(ksr);
    }
  }

  public void toListQryResult()throws Exception{
    if(newtimes.shipping_admin.ShippingAdmin_Const.isUserEric() &&
       util.PublicVariable.OPERATTING_CENTER.equals("BW")){
       toListQryResult4Bw();
       return;
    }
     newtimes.preproduction.Constants.BYMKR_WAREHOUSE_STRING =null;
     //common process to set cursor...
     javax.swing.JFrame jframe=processhandler.template.Properties.getMainFrame();
     java.awt.Cursor ksr=jframe.getContentPane().getCursor();
     try{
       jframe.getContentPane().setCursor(new java.awt.Cursor(java.awt.Cursor.WAIT_CURSOR));
       //specific process of doing this command.
       DB_Preprod dbEngin=DB_Preprod.getInstance();
       dbEngin.conditions=PP_Maintain_CmdSet.qryConditions;
       newtimes.preproduction.guis.PnlListQryPprod pnl=
           new newtimes.preproduction.guis.PnlListQryPprod(dbEngin,
           13,getHeadColumns(),new java.util.Hashtable(),
           "Edit\nStyle","   ...   ",
           "Edit\nProd Head","   ...   ",
           "S/C Print"," ...  ",
           "Shipping\nData","   ...   ");
       pnl.setPreferredSize(new java.awt.Dimension(760,450));
       processhandler.template.Properties.getSplitFrame().setUpperPanel(pnl);
       processhandler.template.Properties.getSplitFrame().setLowerPanel(null);
       processhandler.template.Properties.getSplitFrame().setDividerLocation(1);
       processhandler.template.Properties.getSplitFrame().repaint();
       processhandler.template.Properties.getCenteralControler().setDataProcesser(null);

       newtimes.production.process.prodmaintain.ToCheckB4StyleProc.setFunctionButtonStatus(
         false,false,false,false,false,false);
       /*
       processhandler.template.Properties.getSplitFrame().butnCopy.setEnabled(false);
       processhandler.template.Properties.getSplitFrame().butnNew.setEnabled(false);
       processhandler.template.Properties.getSplitFrame().butnPaste.setEnabled(false);
       processhandler.template.Properties.getSplitFrame().butnDelete.setEnabled(false);
       processhandler.template.Properties.getSplitFrame().butnEdit.setEnabled(false);
       processhandler.template.Properties.getSplitFrame().butnPrint.setEnabled(false);
      */
      processhandler.template.Properties.getSplitFrame().butnEdit.setText("CONFIRM EDIT");
       jframe.getContentPane().removeAll();
       jframe.getContentPane().add(processhandler.template.Properties.getSplitFrame());
       jframe.setTitle("PRODUCTION MAINTAIN: QUERY RESULT");
       jframe.validate();
       jframe.repaint();

     }finally{
       jframe.getContentPane().setCursor(ksr);
     }
  }
}
