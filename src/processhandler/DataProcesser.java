package processhandler;

/**
 * <p>Title:DataProcesser Interface. </p>
 * <p>Description:the Target Object allowing gui to call for database operation </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: metak.com.tw</p>
 * @author Crazy John
 * @version 1.0
 * this interface is ready for update/add/delete buttons in gui to call.<br>
 */

public interface DataProcesser {
  /**
   * @throws Exception the remote exception or other(ex:SQL Exception)
   */
  public void doUpdate() throws Exception;

  /**
   * @throws Exception the remote exception or other(ex:SQL Exception)
   */
  public void doAddNew() throws Exception;

  /**
   * @throws Exception the remote exception or other(ex:SQL Exception)
   */
  public void doDelete() throws Exception;
  /**
   * allow gui to copy a record into system variables for past in future
   */
  public void doCopy();
  /**
   * past current stored record into coresponding GUI
   */
  public void doPaste();
  /**
   * call for print function.
   * @throws Exception server side exception or comminucation excepiton.
   */
  public void doPrint()throws Exception ;
  /**
   * call to do last command trigger in command history list;
   * @throws Exception
   */
  public void doExit()throws Exception;
  /**
   * test if Databind guis had modified.
   * Before trigger other command.show alert message if modified
   * @return boolean
   */
  public boolean isContextModified();
  /**
   * while switch to next gui(triggger),
   * commander will call it.
   */
  public void exitCurrentGui();
}
