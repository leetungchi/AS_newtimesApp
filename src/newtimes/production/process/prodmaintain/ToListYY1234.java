package newtimes.production.process.prodmaintain;
public class ToListYY1234 extends ToCheckB4StyleProc implements AbleToListYY1234{
  public ToListYY1234() {

  }
  public void toListYY1234()throws Exception{
    try{
     newtimes.production.ProdMaintain_Properties.setWaitCursor();
       newtimes.production.gui.prodmaintain.PnlStyYY1234  pnl =
           new newtimes.production.gui.prodmaintain.PnlStyYY1234 ();
       if (!pnl.isInitOK()){
         throw new processhandler.commands.CommandIncompleteException();
       }
       addLowerPanel("=====STYLE YY EDIT=======",pnl);
       processhandler.template.Properties.getCenteralControler().setDataProcesser(pnl);
       setFunctionButtonStatus(false, true, true, true, false, false);
      /*
       if(newtimes.production.ProdMaintain_Properties.isAbleToEdit()){
         setFunctionButtonStatus(false, true, true, true, false, false);
       }else{
         setFunctionButtonStatus(false, false, false, false, false, false);
       }*/



       //super.setFunctionButtonStatus(false,true,true,true,false,false);
       pnl.firstPage();
    }finally{
      newtimes.production.ProdMaintain_Properties.setNormalCursor();
    }
  }
}
