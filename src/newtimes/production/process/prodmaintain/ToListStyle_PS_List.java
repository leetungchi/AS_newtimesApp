package newtimes.production.process.prodmaintain;
public class ToListStyle_PS_List
    extends ToCheckB4StyleProc
    implements AbleToListStyle_PS_List{
  public ToListStyle_PS_List() {

  }
  public void toListStyle_PS_List()throws Exception{
    try{
      newtimes.production.ProdMaintain_Properties.setWaitCursor();
      newtimes.production.gui.prodmaintain.PnlStyPSList pnl =
          new newtimes.production.gui.prodmaintain.PnlStyPSList();
      if (!pnl.isInitOK()){
          throw new processhandler.commands.CommandIncompleteException();
      }
      addLowerPanel("=====STYLE PS EDIT=======", pnl);
      processhandler.template.Properties.getCenteralControler().
          setDataProcesser(pnl);
      if(newtimes.production.ProdMaintain_Properties.isAbleToEdit()){
        setFunctionButtonStatus(false,true,true,true,false,false);
      }else{
        if((!"001".equals(util.PublicVariable.OPERATTING_CENTER)) &&
           (!"NTFE".equals(util.PublicVariable.OPERATTING_CENTER))){
          setFunctionButtonStatus(false, true, true, true, false, false);
        }else{
          setFunctionButtonStatus(false, false, true, false, false, false);
        }
      }
      /*
      if(newtimes.production.ProdMaintain_Properties.
         isProductionAuditConfirmedOrPrinted()){
         if(util.PublicVariable.USER_RECORD.getInt("USR_TYPE")!=
            newtimesejb.preproduction.PreProductionHead.USER_TYPE_SUPERVIOSER_MIS
            && util.PublicVariable.OPERATTING_CENTER.equals("001")){
            setFunctionButtonStatus(false,false,true,false,false,false);
         }else{
            setFunctionButtonStatus(false,true,true,true,false,false);//allow mis user to modify record
         }
      }else{
          setFunctionButtonStatus(false,true,true,true,false,false);
      }*/

      //super.setFunctionButtonStatus(false,true,true,true,false,false);
      pnl.firstPage();
    }
    finally {
      newtimes.production.ProdMaintain_Properties.setNormalCursor();
    }

  }
}
