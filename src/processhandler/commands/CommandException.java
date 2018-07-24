package processhandler.commands;

/**
 * <p>Title: Command Exception</p>
 * <p>Description: Exception class to descript the exceptions while invoking execution of command</p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: metak.com.tw</p>
 * @author Crazy John.
 * @version 1.0
 */

public class CommandException
    extends Exception {
  public CommandException() {
  }

  public CommandException(String expMsg) {
    super(expMsg);
  }
}