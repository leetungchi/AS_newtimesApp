package newtimes.production.process.prodmaintain;
public class ToListStyColorPrice extends ToCheckB4StyleProc implements AbleToListStyColorPrice{
  public ToListStyColorPrice() {

  }
  public void toListStyColorPrice()throws Exception{
    javax.swing.JFrame jframe=processhandler.template.Properties.getMainFrame();
    java.awt.Cursor ksr=jframe.getContentPane().getCursor();
    try{
      jframe.getContentPane().setCursor(new java.awt.Cursor(java.awt.Cursor.WAIT_CURSOR));
      //specific process of doing this command.
      newtimes.production.gui.prodmaintain.PnlStyColorPrice   pnl=
          new newtimes.production.gui.prodmaintain.PnlStyColorPrice();
      if(!pnl.isInitOk()){
        //processhandler.template.Properties.getCenteralControler().goBack();
       throw new processhandler.commands.CommandIncompleteException();
      }
      pnl.setPreferredSize(
         new java.awt.Dimension(300,300)
       );
      super.addLowerPanel("============Style Color Price Edit============",pnl);

      if(newtimes.production.ProdMaintain_Properties.isAbleToEdit()){
        setFunctionButtonStatus(false,true,true,true,false,false);
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
             newtimes.production.process.prodmaintain.ToCheckB4StyleProc.setFunctionButtonStatus(
              false,true,true,true,true,false);//allow mis user to modify record
         }
      }else{
          setFunctionButtonStatus(false,true,true,true,false,false);
      }*/
      /*
      processhandler.template.Properties.getSplitFrame().addExtraTriggerButton("To Main Menu",
          new newtimes.preproduction.process.TgrShowFuncList());*/

      processhandler.template.Properties.getCenteralControler().setDataProcesser(pnl);
      pnl.firstPage();
      jframe.validate();jframe.repaint();
    }finally{
      jframe.getContentPane().setCursor(ksr);
    }
  }
}
