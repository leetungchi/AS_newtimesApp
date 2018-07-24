package newtimes.production.process.prodmaintain;
import newtimes.production.gui.prodmaintain.*;
import util.InsertionOrderedHashMap;
import database.datatype.Record;
import exgui.chaindialog.*;
import newtimes.production.gui.prodmaintain.*;
public class ToListStyQty extends ToCheckB4StyleProc implements AbleToListStyQty{
  private InsertionOrderedHashMap clmHead=null;

  public ToListStyQty() {
    clmHead=new InsertionOrderedHashMap();
    clmHead.put("STYLE","STY_STYLE");
    clmHead.put("PO","STY_PO");
    clmHead.put("QTY","total_qty");
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
      Pnl_Trinity_PriceSizeQtyList pnl=new Pnl_Trinity_PriceSizeQtyList();
      if(!pnl.isIniOK()){
        throw new processhandler.commands.CommandIncompleteException();
      }
      StringBuffer sb=new StringBuffer();
      sb.append("=========STY QTY EDIT===============<br>");
      sb.append("STYLE:");
       Object styObj=newtimes.production.ProdMaintain_Properties.EDITING_STYLE_RECORD.get(2);
      sb.append((styObj==null)?"":styObj.toString());
       Object poObj=newtimes.production.ProdMaintain_Properties.EDITING_STYLE_RECORD.get(3);
      sb.append("  P.O:");
      sb.append((poObj==null)?"":poObj.toString());
      super.addLowerPanel(sb.toString(),pnl);
      if(newtimes.production.ProdMaintain_Properties.isAbleToEdit()){
        setFunctionButtonStatus(true,true,true,true,true,false);
      }else{
        setFunctionButtonStatus(false,false,true,false,false,false);
      }
      /*
      if(newtimes.production.ProdMaintain_Properties.
         isProductionAuditConfirmedOrPrinted()){
         if(util.PublicVariable.USER_RECORD.getInt("USR_TYPE")!=
            newtimesejb.preproduction.PreProductionHead.USER_TYPE_SUPERVIOSER_MIS
            && util.PublicVariable.OPERATTING_CENTER.equals("001")){
            setFunctionButtonStatus(false,false,true,false,false,false);
         }else{
            setFunctionButtonStatus(true,true,true,true,true,false);//allow mis user to modify record
         }
      }else{
          setFunctionButtonStatus(true,true,true,true,true,false);
      }*/

      processhandler.template.Properties.getCenteralControler().setDataProcesser(pnl);
      //pnl.storedHasMap2HeadColumn=pnl.getHeadColumnMap();
      pnl.firstPage();
    }finally{
       newtimes.production.ProdMaintain_Properties.setNormalCursor();
    }
  }
}
