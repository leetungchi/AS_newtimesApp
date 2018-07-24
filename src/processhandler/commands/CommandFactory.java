package processhandler.commands;

/**
 * <p>Title: the Command Factory</p>
 * <p>Description:to Generate/register Command Object to excute command context </p>
 * <p><font color=blue>level: System(Singaltone)</font><br>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: metak.com.tw</p>
 * @author Crazy John
 * @version 1.0
 */
public interface CommandFactory {
  /**
   * to lookup a command to excute by command dispatcher<br>
   * @param lookupName coresponding to registerCommand parameter "lookupName"
   * @return Object command object to execute trigger by CommandType class
   */
public Object lookupCommand(String lookupName);
  /**
   * to register a comand object allow lookup while running Application.<br>
   * @param lookupName the naming string for lookup by the method "lookupCommand"
   * @param commandObj2Reg command object,with the interface of running some function.will be called by command type at run time.
   */
  public void registerCommand(String lookupName,Object commandObj2Reg);
}