package newtimes.production.process.prodmaintain;
import processhandler.commands.*;
public class ToListNthkCtInfor extends ToCheckB4StyleProc implements AbleToListNthkCtInfor{
  public ToListNthkCtInfor() {

  }
  public void toListCt4Nthk()throws processhandler.commands.CommandException{
    try{
     newtimes.production.ProdMaintain_Properties.setWaitCursor();


       newtimes.production.gui.prodmaintain.PnlNthkCtList  pnl =
           new newtimes.production.gui.prodmaintain.PnlNthkCtList();

       addLowerPanel("=====C/T HEAD DEFINITION=======",pnl);
       processhandler.template.Properties.getCenteralControler().setDataProcesser(pnl);

       if(newtimes.production.ProdMaintain_Properties.isAbleToEdit()){
         pnl.IS_SHIPPED=false;
         setFunctionButtonStatus(true,true,true,true,true,false);
       }else{
         pnl.IS_SHIPPED=true;
         if(util.PublicVariable.OPERATTING_CENTER.equalsIgnoreCase("NTFE")){
           setFunctionButtonStatus(false,false,true,false,false,false);
         }else{
           setFunctionButtonStatus(true,true,true,true,true,false);
         }
         //setFunctionButtonStatus(false,false,true,false,false,false);
       }
       //super.setFunctionButtonStatus(true,true,true,true,true,false);
       processhandler.template.Properties.getSplitFrame().addExtraTriggerButton("To Head",
         new newtimes.preproduction.process.TrggerEditAPreprod());
       pnl.firstPage();
       final newtimes.production.gui.prodmaintain.PnlNthkCtList tmpPnl=pnl;

       javax.swing.SwingUtilities.invokeLater(
        new Runnable(){
         public void run() {
           tmpPnl.getJtable().changeSelection(0, 0, false, false);
           tmpPnl.getJtable().editCellAt(0, 0);
           tmpPnl.getJtable().grabFocus();
           /*
           final javax.swing.JComboBox jbcx=((javax.swing.JComboBox)tmpPnl.getJtable().getEditorComponent());
           jbcx.setLightWeightPopupEnabled(false);
           jbcx.putClientProperty("JComboBox.lightweightKeyboardNavigation","Lightweight");
           jbcx.getEditor().selectAll();*/
        }
        }
       );

    }finally{
      newtimes.production.ProdMaintain_Properties.setNormalCursor();
    }

  }
  public void toListNthkCtInfor() throws processhandler.commands.CommandException{
    try{
      String cen_Str=(String)newtimes.preproduction.Constants.CURRENT_PREPROD_HEAD_RECORD.get("prod_cen_code");
      if(cen_Str.equals("NTHK")){
        toListCt4Nthk();
        return;
      }
    }catch(Exception exp){
      exp.printStackTrace();
    }
    try{
     newtimes.production.ProdMaintain_Properties.setWaitCursor();


       newtimes.production.gui.prodmaintain.PnlXcenterCtList  pnl =
           new newtimes.production.gui.prodmaintain.PnlXcenterCtList();

       addLowerPanel("=====C/T HEAD DEFINITION=======",pnl);
       processhandler.template.Properties.getCenteralControler().setDataProcesser(pnl);

       if(newtimes.production.ProdMaintain_Properties.isAbleToEdit()){
         pnl.IS_SHIPPED=false;
         setFunctionButtonStatus(true,true,true,true,true,false);
       }else{
         pnl.IS_SHIPPED=true;
         if(util.PublicVariable.OPERATTING_CENTER.equalsIgnoreCase("NTFE")){
           setFunctionButtonStatus(false,false,true,false,false,false);
         }else{
           setFunctionButtonStatus(true,true,true,true,true,false);
         }

         //setFunctionButtonStatus(false,false,true,false,false,false);
       }
       //super.setFunctionButtonStatus(true,true,true,true,true,false);
       processhandler.template.Properties.getSplitFrame().addExtraTriggerButton("To Head",
         new newtimes.preproduction.process.TrggerEditAPreprod());
       pnl.firstPage();
       final newtimes.production.gui.prodmaintain.PnlXcenterCtList tmpPnl=pnl;

       javax.swing.SwingUtilities.invokeLater(
        new Runnable(){
         public void run() {
           tmpPnl.getJtable().changeSelection(0, 0, false, false);
           tmpPnl.getJtable().editCellAt(0, 0);
           tmpPnl.getJtable().grabFocus();
           /*
           final javax.swing.JComboBox jbcx=((javax.swing.JComboBox)tmpPnl.getJtable().getEditorComponent());
           jbcx.setLightWeightPopupEnabled(false);
           jbcx.putClientProperty("JComboBox.lightweightKeyboardNavigation","Lightweight");
           jbcx.getEditor().selectAll();*/
        }
        }
       );

    }finally{
      newtimes.production.ProdMaintain_Properties.setNormalCursor();
    }

  }
}
