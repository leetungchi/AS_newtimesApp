package newtimes.production.report;
import processhandler.commands.CommandException;
import processhandler.*;


public class TgrToQry4CulpProd extends CommandTrigger {
  public TgrToQry4CulpProd() {
  }
  protected void activateThisProcess() throws processhandler.commands.CommandException {
    /**@todo Implement this processhandler.CommandTrigger abstract method*/
    if(commander==null)
      throw new CommandException("commander is null");
    if(commander instanceof AbleToQry4CulpProd){
       try{
         ((AbleToQry4CulpProd)commander).toQry4CulpProd();
         //ctnCtl.recordProcess(this);
       }catch(processhandler.commands.CommandIncompleteException cie){
       }catch(Exception e){
          e.printStackTrace();
          throw new CommandException(e.getMessage());
       }
    }else{
      throw new CommandException("commander is not able to Qry4CulpProd");
    }

  }

}