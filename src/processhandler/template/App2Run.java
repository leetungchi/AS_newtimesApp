package processhandler.template;
import processhandler.*;
import processhandler.commands.*;
import javax.swing.UIManager;
import java.awt.*;
import exgui2.*;
/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class App2Run {
  boolean packFrame = false;
  SplitFrame spframe=new SplitFrame();
  CommandFactoryImp cmxFxy=new CommandFactoryImp();
  CenteralControlerImp ctnCtl=new CenteralControlerImp();
  Constants xtnts=new Constants();
  //Construct the application
  public App2Run() {
    FrameMain frame = new FrameMain();
    //set system properties for future needs
    //set command factory,and binding the firt command object.
    Properties.jframe=frame;
    util.PublicVariable.APP_FRAME=frame;
    Properties.spFrame=spframe;
    util.PublicVariable.APP_SPLIT_FRAME=spframe;
    cmxFxy.registerCommand(Constants.CMD_INIT_APP_GUI,new CmdInit());
    //set to system properties
    Properties.cmdFxy=cmxFxy;
    ctnCtl.setBasicFrameWork(spframe);
    ctnCtl.setCommandFactory(cmxFxy);
    ctnCtl.setMainFrame(frame);
    //set centercontroler to system properties.
    Properties.ctnCtl=ctnCtl;
    Properties.getCommandFactory().registerCommand(Constants.CMD_PROC_TEMP1,new CommandSets());
    //Validate frames that have preset sizes
    //Pack frames that have useful preferred size info, e.g. from their layout
    if (packFrame) {
      frame.pack();
    }
    else {
      frame.validate();
    }
    //Center the window
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    Dimension frameSize = frame.getSize();
    if (frameSize.height > screenSize.height) {
      frameSize.height = screenSize.height;
    }
    if (frameSize.width > screenSize.width) {
      frameSize.width = screenSize.width;
    }
    frame.getContentPane().add(spframe);
    frame.setLocation((screenSize.width - frameSize.width) / 2, (screenSize.height - frameSize.height) / 2);
    frame.setVisible(true);
    //trigger the 1st command,kick off this system now.

    try{
       Properties.getCenteralControler().setSystemCommander(Constants.CMD_INIT_APP_GUI);
       Properties.getCenteralControler().doCommandExecute(new TgrGreetting());
    }catch(Exception e){
      e.printStackTrace();
    }

  }
  //Main method
  public static void main(String[] args) {
    try {
      util.ExceptionLog.setLogPath("J:\\newtimesPHII.log");
      util.SqlLog.setLogDirectory("T://");
      UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
      //util.PublicVariable.USER_ID="asd3";
    }
    catch(Exception e) {
      e.printStackTrace();
    }
    new App2Run();
  }
}