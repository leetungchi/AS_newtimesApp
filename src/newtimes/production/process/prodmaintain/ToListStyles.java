package newtimes.production.process.prodmaintain;
public class ToListStyles  extends ToListStylesNoProdHead implements AbleToListStyles
  {
  public ToListStyles() {

  }
  public void toListStyles()throws Exception{
    javax.swing.JFrame jframe=processhandler.template.Properties.getMainFrame();
    java.awt.Cursor ksr=jframe.getContentPane().getCursor();
    try{
      jframe.getContentPane().setCursor(new java.awt.Cursor(java.awt.Cursor.WAIT_CURSOR));
      //specific process of doing this command.
      //prepare the upper panel of production head.
      newtimes.preproduction.process.ToInitUperAndDownPnl.setPreProdDisplayer();
      newtimes.production.gui.prodmaintain.PnlStyleList  pnl=
          new newtimes.production.gui.prodmaintain.PnlStyleList();
      pnl.setPreferredSize(
         new java.awt.Dimension(300,200)
       );
      super.addLowerPanel("STYLE LIST",pnl);
      //processhandler.template.Properties.getSplitFrame().setDividerLocation(0.4);
      processhandler.template.Properties.getSplitFrame().setDividerLocation(0.18);

      if(newtimes.production.ProdMaintain_Properties.isAbleToEdit()){
        setFunctionButtonStatus(true,true,true,true,true,false);
      }else{
        //ashwort and TREGER SPORTS is allow to modify YY data
        if(newtimes.preproduction.Constants.CURRENT_PREPROD_HEAD_RECORD.getInt("prod_buyer")==82||
           newtimes.preproduction.Constants.CURRENT_PREPROD_HEAD_RECORD.getInt("prod_buyer")==9408
           ){
          pnl=new newtimes.production.gui.prodmaintain.PnlStyleList4AshWorth();
          pnl.setPreferredSize(
             new java.awt.Dimension(300,200)
           );
          super.addLowerPanel("STYLE LIST",pnl);
          setFunctionButtonStatus(false,true,true,false,false,false);
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
            setFunctionButtonStatus(true,true,true,true,true,false);//allow mis user to modify record
         }
      }else{
          setFunctionButtonStatus(true,true,true,true,true,false);
      }
      */

      processhandler.template.Properties.getSplitFrame().addExtraTriggerButton("To Head",
        new newtimes.preproduction.process.TrggerEditAPreprod());
      processhandler.template.Properties.getCenteralControler().setDataProcesser(pnl);
    }finally{
      jframe.getContentPane().setCursor(ksr);
    }
  }
}
