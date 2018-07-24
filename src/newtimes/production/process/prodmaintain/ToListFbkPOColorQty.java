package newtimes.production.process.prodmaintain;
public class ToListFbkPOColorQty
    extends ToCheck4FabricProc
    implements AbleToListFbkPOColorQty{
  public ToListFbkPOColorQty() {

  }
  public void toListFbkPOColorQty()throws  processhandler.commands.CommandException,
                                         processhandler.commands.CommandIncompleteException{
    try{
     if(!isFabricRecordSelected()){
        throw new processhandler.commands.CommandIncompleteException();
     }
     newtimes.production.ProdMaintain_Properties.setWaitCursor();
       newtimes.production.gui.prodmaintain.PnlFabricColorQty  pnl =
           new newtimes.production.gui.prodmaintain.PnlFabricColorQty();
       if (!pnl.isInitOK()){
         throw new processhandler.commands.CommandIncompleteException();
       }
       database.datatype.Record recFabPO=
           newtimes.production.ProdMaintain_Properties.EDITING_FABRIC_PO_RECORD;
       StringBuffer sb=new StringBuffer();
       sb.append("=====  Fabric PO Color QTY  ======<br>");
       sb.append("Fabric PO: ");
       sb.append(recFabPO.get("FAB_PO"));
       sb.append("<br>");
       sb.append("Fabric Qty:");
       sb.append(recFabPO.get("FAB_QTY"));
       addLowerPanel(sb.toString(),
                     pnl);
       processhandler.template.Properties.getCenteralControler().setDataProcesser(pnl);
       super.setFunctionButtonStatus(true,true,false,false,true,false);
       //processhandler.template.Properties.getSplitFrame().setDividerLocation(0.4);
       processhandler.template.Properties.getSplitFrame().setDividerLocation(0.18);
       pnl.firstPage();
       if(pnl.getJtable().getRowCount()>0){
          pnl.getJtable().changeSelection(0,0,false,false);
       }
    }catch(Exception e){
      e.printStackTrace();
      throw new processhandler.commands.CommandException("");
    }finally{
      newtimes.production.ProdMaintain_Properties.setNormalCursor();
    }

  }
}
