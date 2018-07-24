package processhandler;
import processhandler.commands.*;
/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class Cmd2ShowDtl4QryRecord extends CommandTrigger {
  public Cmd2ShowDtl4QryRecord(){}
  public void activateThisProcess() throws CommandException {
   if(commander==null)
     throw new CommandException("commander is null");
   if(commander instanceof Able2ShowDtl4QryRecord){
      try{
        ((Able2ShowDtl4QryRecord)commander).toShowDtl4QryRecord();
      }catch(Exception e){
         e.printStackTrace();
         throw new CommandException(e.getMessage());
      }
   }else{
     throw new CommandException("commander is not able to generate detail data GUI for co-responding record");
   }
  }
}