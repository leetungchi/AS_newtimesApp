package newtimes.production.process.prodmaintain;
import processhandler.commands.CommandException;
import processhandler.*;


public class TgrToListStylesNoProdHead extends CommandTrigger {
  public TgrToListStylesNoProdHead() {
  }
  protected void activateThisProcess() throws processhandler.commands.CommandException {
    /**@todo Implement this processhandler.CommandTrigger abstract method*/
    //switch to production mantain command set if current command set is preproduction command set.
  processhandler.template.Properties.getCenteralControler().setSystemCommander(
         newtimes.production.ProdMaintain_Properties.CMDS_PROD_MAINTAIN
        );
  commander=processhandler.template.Properties.getCenteralControler().getCurrentSystemCommand();

    if(commander==null)
      throw new CommandException("commander is null");
    if(commander instanceof AbleToListStylesNoProdHead){
       try{

         String sc_no=(String)newtimes.preproduction.Constants.CURRENT_PREPROD_HEAD_RECORD.get("prod_sc_no");
         if(sc_no!=null){
           util.PublicVariable.APP_FRAME.setTitle("Newtimes ERP PRODUCTION MAINTAIN  :  "+sc_no);
         }else{
           util.PublicVariable.APP_FRAME.setTitle("Newtimes ERP PRODUCTION MAINTAIN REF : "+newtimes.preproduction.Constants.CURRENT_PREPROD_HEAD_RECORD.getInt(0) );
         }
         ((AbleToListStylesNoProdHead)commander).toListStylesNoProdHead();
         ctnCtl.recordProcess(this);
       }catch(processhandler.commands.CommandIncompleteException cie){

       }catch(Exception e){
          e.printStackTrace();
          throw new CommandException(e.getMessage());
       }
    }else{
      throw new CommandException("commander is not able to ListStylesNoProdHead");
    }

  }

}
