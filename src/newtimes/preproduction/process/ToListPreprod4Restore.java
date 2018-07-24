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

public class ToListPreprod4Restore implements AbleToListPreprod4Restore{
  protected HashMap conditions;
  static protected util.InsertionOrderedHashMap columnNameMap=null;
  public java.util.HashMap qryConditions=null;
  static protected Hashtable obj2strCnv;
  public ToListPreprod4Restore() {
    conditions=qryConditions;
      columnNameMap=new util.InsertionOrderedHashMap();
      columnNameMap.put("DEP\nYEAR\nSEASON","DEP_YEAR_SEASON");
      columnNameMap.put("BUYER","j_buyer");
      columnNameMap.put("MAKER","j_maker");
      if(util.PublicVariable.OPERATTING_CENTER.equals("NTHK")){
        columnNameMap.put("VENDOR", "nthk_vdr");
      }else{
        columnNameMap.put("DIV.", "j_div");
      }

      columnNameMap.put("Board/RNG\nS/C","RANGE_SC_NO");
      columnNameMap.put("GRP-NO\nGRP-NAME","GroupDatas");
      columnNameMap.put("Prod\nRef No",
                        "PROD_HEAD_PK");
      //---------org--------------------------
      /*
      columnNameMap.put("CENTER","j_cen");
      columnNameMap.put("DEP","j_dep");
      columnNameMap.put("YEAR","PROD_YEAR");
      columnNameMap.put("SEASON","j_SEA");
      columnNameMap.put("DIVISION","j_div");
      columnNameMap.put("BUYER","j_buyer");
      columnNameMap.put("MAKER","j_maker");
      */
      columnNameMap.put("Ref No.",
                        "PROD_HEAD_PK");
      columnNameMap.put("Deleted","record_delete_flag");
      columnNameMap.put("Deleted\nColor Libs","Delete_Color_count");
      columnNameMap.put("Deleted\nStyles","Delete_STYLE_count");

    if(obj2strCnv==null){
      obj2strCnv=new Hashtable();
      obj2strCnv.put("Deleted",new DltFlagToShow());
    }
  }
  class DltFlagToShow implements exgui.Object2String{
    public String Obj2String(Object obj){
      //return null;
      if(obj.toString().equals("0")) return "Y";
      if(obj.toString().equals("1")) return "N";
      return "N/A";

    }
  }
  public void toListPreprod4Restore()throws Exception{
    //common process to set cursor...
    javax.swing.JFrame jframe=processhandler.template.Properties.getMainFrame();
    java.awt.Cursor ksr=jframe.getContentPane().getCursor();
    try{
      jframe.getContentPane().setCursor(new java.awt.Cursor(java.awt.Cursor.WAIT_CURSOR));
      //specific process of doing this command.
      DB_PreprodHandler4Restore  dbEngin=DB_PreprodHandler4Restore.getInstance4Restore();
      dbEngin.conditions=PP_Maintain_CmdSet.qryConditions;
      newtimes.preproduction.guis.PnlListPprd4Restore  pnl=
          new newtimes.preproduction.guis.PnlListPprd4Restore(dbEngin,
          24,columnNameMap,obj2strCnv);
      pnl.setPreferredSize(new java.awt.Dimension(900,250));
      processhandler.template.Properties.getSplitFrame().setUpperPanel(pnl);
      processhandler.template.Properties.getSplitFrame().setLowerPanel(null);
      processhandler.template.Properties.getSplitFrame().setDividerLocation(1);
      processhandler.template.Properties.getSplitFrame().repaint();
      jframe.getContentPane().removeAll();
      jframe.getContentPane().add(processhandler.template.Properties.getSplitFrame());
      newtimes.production.process.prodmaintain.ToCheckB4StyleProc.setFunctionButtonStatus(
        false,false,false,false,false,false);
      processhandler.template.Properties.getSplitFrame().butnEdit.setText("RESTORE");
      /*
      processhandler.template.Properties.getSplitFrame().butnCopy.setEnabled(false);
      processhandler.template.Properties.getSplitFrame().butnNew.setEnabled(false);
      processhandler.template.Properties.getSplitFrame().butnPaste.setEnabled(false);
      processhandler.template.Properties.getSplitFrame().butnDelete.setEnabled(false);
      processhandler.template.Properties.getSplitFrame().butnEdit.setEnabled(false);
      processhandler.template.Properties.getSplitFrame().butnPrint.setEnabled(false);
      processhandler.template.Properties.getSplitFrame().butnEdit.setText("RESTORE");
      */
      jframe.validate();
      jframe.repaint();
    }finally{
      jframe.getContentPane().setCursor(ksr);
    }
  }
}
