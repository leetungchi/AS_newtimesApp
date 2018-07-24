package newtimes.production.process.prodmaintain;
import newtimes.production.gui.prodmaintain.*;
import util.InsertionOrderedHashMap;
import database.datatype.Record;
import exgui.chaindialog.*;
import newtimes.production.gui.prodmaintain.*;
public class ToListNthkStyQty extends ToCheckB4StyleProc implements AbleToListStyQty{
  private InsertionOrderedHashMap clmHead=null;

  public ToListNthkStyQty() {
    clmHead=new InsertionOrderedHashMap();
    clmHead.put("STYLE","STY_STYLE");
    clmHead.put("PO","STY_PO");
    clmHead.put("QTY","total_qty");
  }
  public  void showQty4Reload(DbBriefQtyHandler dbBriefQtyHandler)throws Exception{
      int shipped_count=
          newtimes.production.ProdMaintain_Properties.EDITING_STYLE_RECORD.getInt("shipped_count");
      boolean isToHandleShipped=false;
      if(newtimes.production.ProdMaintain_Properties.isAbleToEdit()){
        isToHandleShipped=false;
      }else{
        if(shipped_count>0)isToHandleShipped=true;
      }

      final PnlNthkBriefQty pnl=new PnlNthkBriefQty(dbBriefQtyHandler,true,isToHandleShipped);
      StringBuffer sb=new StringBuffer();
      sb.append("=========STY QTY EDIT===============<br>");
      sb.append("STYLE:");
       Object styObj=newtimes.production.ProdMaintain_Properties.EDITING_STYLE_RECORD.get(2);
      sb.append((styObj==null)?"":styObj.toString());
       Object poObj=newtimes.production.ProdMaintain_Properties.EDITING_STYLE_RECORD.get(3);
      sb.append("  P.O:");
      sb.append((poObj==null)?"":poObj.toString());
      super.addLowerPanel(sb.toString(),pnl);
      //setFunctionButtonStatus(false,true,true,true,true,false);
      boolean isNotNtfeUser=true;
      if(newtimes.production.ProdMaintain_Properties.isAbleToEdit()){
        setFunctionButtonStatus(false,true,true,true,true,false);
      }else{
        if(util.PublicVariable.OPERATTING_CENTER.equalsIgnoreCase("NTFE")){
          setFunctionButtonStatus(false,false,true,false,false,false);
          isNotNtfeUser=false;
        }else{
          setFunctionButtonStatus(false,true,true,true,true,false);
        }
      }

      processhandler.template.Properties.getCenteralControler().setDataProcesser(pnl);
      //setFunctionButtonStatus(false,true,true,true,true,false);
      if((!isToHandleShipped)  && (isNotNtfeUser)){
        setFunctionButtonStatus(false, true, true, true, true, false);
      }else{
        setFunctionButtonStatus(false, false, false, false, false, false);
      }

      /*
      if(newtimes.production.ProdMaintain_Properties.isAbleToEdit()){
        setFunctionButtonStatus(false,true,true,true,true,false);
      }else{
        setFunctionButtonStatus(false,false,true,false,false,false);
      }*/
      processhandler.template.Properties.getCenteralControler().setDataProcesser(pnl);
      javax.swing.SwingUtilities.invokeLater(
       new Runnable(){
        public void run() {
          int rowBeginAt=0;
          for(int i=0;i<pnl.getJtable().getRowCount();i++){
            if (pnl.getJtable().isCellEditable(i,0)){
              rowBeginAt=i;
              break;
            }
          }
          pnl.getJtable().changeSelection(rowBeginAt, 0, false, false);
          pnl.getJtable().editCellAt(rowBeginAt, 0);
         ((javax.swing.text.JTextComponent)pnl.getJtable().
          getEditorComponent()).grabFocus();
         ((javax.swing.text.JTextComponent)pnl.getJtable().
         getEditorComponent()).selectAll();
       }});


      //pnl.getJtable().changeSelection(0,0,false,false);

  }
  public void toListStyQty()throws Exception{
    try{
      newtimes.production.ProdMaintain_Properties.setWaitCursor();
       if(!super.isStyleRecordSelected())
         throw new processhandler.commands.CommandIncompleteException();
       //test if color-size-licence is selected.
       database.datatype.Record styRec=
        newtimes.production.ProdMaintain_Properties.EDITING_STYLE_RECORD;
      //specific process of doing this command.
      //DB_StyleListHandler db=new DB_StyleListHandler();
      //PnlStyleColorQtyList pnl=new PnlStyleColorQtyList();
      //test if current style record have "shipped_count" column
      if("001".equals(util.PublicVariable.OPERATTING_CENTER)){
        java.util.List columns=newtimes.production.ProdMaintain_Properties.EDITING_STYLE_RECORD.getFieldName();
        int i=columns.size()-1;
        for(;i!=0;i--){
          if("shipped_count".equals((String)columns.get(i)) ){
            break;
          }
        }
        if(i==0){
          //means have no such column,add it.
          newtimes.production.ProdMaintain_Properties.EDITING_STYLE_RECORD.getFieldName().add("SHIPPED_COUNT");
          newtimes.production.ProdMaintain_Properties.EDITING_STYLE_RECORD.getValueFields().add(new Integer(0));
        }
      }
      int shipped_count=
          newtimes.production.ProdMaintain_Properties.EDITING_STYLE_RECORD.getInt("shipped_count");

      boolean isToHandleShipped=false;
      if(newtimes.production.ProdMaintain_Properties.isAbleToEdit()){
        isToHandleShipped=false;
      }else{
        if(shipped_count>0)isToHandleShipped=true;
      }
      PnlNthkBriefQty pnl=new PnlNthkBriefQty(new DbBriefQtyHandler(styRec.getInt(0),styRec),isToHandleShipped);

      StringBuffer sb=new StringBuffer();
      sb.append("=========STY QTY EDIT===============<br>");
      sb.append("STYLE:");
       Object styObj=newtimes.production.ProdMaintain_Properties.EDITING_STYLE_RECORD.get(2);
      sb.append((styObj==null)?"":styObj.toString());
       Object poObj=newtimes.production.ProdMaintain_Properties.EDITING_STYLE_RECORD.get(3);
      sb.append("  P.O:");
      sb.append((poObj==null)?"":poObj.toString());
      super.addLowerPanel(sb.toString(),pnl);
      //setFunctionButtonStatus(false,true,true,true,true,false);

      boolean isNotNtfeUser=true;
      if(newtimes.production.ProdMaintain_Properties.isAbleToEdit()){
        setFunctionButtonStatus(false,true,true,true,true,false);
      }else{
        if(util.PublicVariable.OPERATTING_CENTER.equalsIgnoreCase("NTFE")){
          setFunctionButtonStatus(false,false,true,false,false,false);
          isNotNtfeUser=false;
        }else{
          setFunctionButtonStatus(false,true,true,true,true,false);
        }
      }


      if((!isToHandleShipped) && isNotNtfeUser){
        setFunctionButtonStatus(false, true, true, true, true, false);
      }else{
        setFunctionButtonStatus(false, false, false, false, false, false);
      }

      /*
      if(newtimes.production.ProdMaintain_Properties.isAbleToEdit()){
        setFunctionButtonStatus(false,true,true,true,true,false);
      }else{
        setFunctionButtonStatus(false,false,true,false,false,false);
      }*/
      processhandler.template.Properties.getCenteralControler().setDataProcesser(pnl);
      //pnl.firstPage();
    }finally{
       newtimes.production.ProdMaintain_Properties.setNormalCursor();
    }
  }
}
