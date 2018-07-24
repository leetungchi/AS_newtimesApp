package processhandler.template;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class CommandFactoryImp implements processhandler.commands.CommandFactory {
  protected java.util.HashMap  commandTable=new java.util.HashMap();
  protected CommandFactoryImp() {
  }
  public void registerCommand(String lookupName,Object cmdObj2Reg){
    commandTable.put(lookupName,cmdObj2Reg);
  }
  public Object lookupCommand(String lookUpName){
    return commandTable.get(lookUpName);
  }
}