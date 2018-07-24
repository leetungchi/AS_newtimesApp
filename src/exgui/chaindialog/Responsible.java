package exgui.chaindialog;
import javax.swing.JComponent;
/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public interface Responsible {
  /**
   * the information for next responisible object to depends on
   * @param attributes,hashmap from PnlChained
   */
  public java.util.HashMap storedMap=new java.util.HashMap();
  /**
   * return the jcomponent to show on ChainedDialog.client class(caller) may do some process of generateing GUI in this process
   * @return the Jcomponent to display on PnlChained panel's show panel
   */
  public JComponent getGUI();
  /**
   * for commonly usage,allow current Responsible object to generate next Responsible object by input the default next responsible object
   * @param dfltRsp the DefaultNext Responsible objct.
   */
  public void setDefalutNext(Responsible dfltRsp);
  /**
   * return the next Responsible object ,wait for trigger.
   * default next Responsible object can be assign by "setDefalutNext"
   * but,if some conditions,user class may generate defferent Responsible object depends on the conditions shown on the gui.
   * if the return Responsible is null,the dialog can not be continued.
   * @return the next  Responsible
   */
  public Responsible next()throws NextResponsibleIsNotReady;
  /**
   * return if user can click ok or not at current stage.
   * if not,clicking "ok" button will transfer to "next" button action
   * @return is current responsible allowing to be finish or not.
   */
  public boolean isAllowOkNow();
}