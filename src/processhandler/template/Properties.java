package processhandler.template;
import processhandler.*;
import processhandler.commands.*;
import exgui2.*;
/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class Properties extends util.ApplicationProperites {
public  static CenteralControler ctnCtl=null;
public  static CommandFactory cmdFxy=null;
public  static javax.swing.JFrame jframe=null;
public  static exgui2.SplitFrame spFrame=null;
  protected Properties() {
  }
  public static CenteralControler getCenteralControler(){return ctnCtl;}
  public static CommandFactory getCommandFactory(){return cmdFxy;}
  public static javax.swing.JFrame getMainFrame(){return jframe;}
  public static exgui2.SplitFrame getSplitFrame(){return spFrame;}
}