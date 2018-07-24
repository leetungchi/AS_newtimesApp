package newtimes.production;
import javax.swing.UIManager;
import java.awt.*;
import exgui2.*;
import processhandler.template.*;
/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class ProductionApp {
  boolean packFrame = false;
  SplitFrame spframe=new SplitFrame();
  CommandFactoryImp cmxFxy=new newtimes.production.ProdMntCmdFxy();
  CenteralControlerImp ctnCtl=new newtimes.production.ProdMtnCntrCtrl();
  Constants xtnts=new newtimes.preproduction.Constants();

  //Construct the application
  public ProductionApp() {
    AppFrame frame = new AppFrame();
    Properties.jframe=frame;
    processhandler.template.Properties.jframe=frame;
    util.PublicVariable.APP_FRAME=frame;
    Properties.spFrame=spframe;
    util.PublicVariable.APP_SPLIT_FRAME=spframe;
    //set to system properties
    Properties.cmdFxy=cmxFxy;
    ctnCtl.setBasicFrameWork(spframe);
    ctnCtl.setCommandFactory(cmxFxy);
    ctnCtl.setMainFrame(frame);
    //set regist some commands center for latter to chose..
    Properties.ctnCtl=ctnCtl;
    Properties.getCommandFactory().registerCommand(
      newtimes.production.ProdMaintain_Properties.CMDS_INIT4PRODMTN,
      new newtimes.production.process.ProductionMaintainEntry_Controler()
    );

    Properties.getCommandFactory().registerCommand(
       newtimes.production.ProdMaintain_Properties.CMDS_PROD_MAINTAIN,
       new newtimes.production.process.prodmaintain.ProdMaintain_CmdSet()
    );

    Properties.getCommandFactory().registerCommand(
      newtimes.production.ProdMaintain_Properties.CMDS_SC_CT_MAINTAIN,
      new newtimes.production.process.audit_sc_ct.SCCT_CmdSets()
    );


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
    Dimension frameSize = new Dimension(800,599);
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
       Properties.getCenteralControler().setSystemCommander(newtimes.production.ProdMaintain_Properties.CMDS_INIT4PRODMTN);
       Properties.getCenteralControler().doCommandExecute(
          new newtimes.production.process.TgrToShowFuncList()
          );

    }catch(Exception e){
      e.printStackTrace();
    }
  }
  //Main method
  public static void main(String[] args) {
    newtimes.preproduction.Dlg_Login dlg=new newtimes.preproduction.Dlg_Login
        (null,"login please",true);
    util.PublicVariable.SERVER_URL="localhost";
    try {
      util.ExceptionLog.setLogPathToImageFolder();
      UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
      dlg.setSize(400,300);
      exgui.UIHelper.setToScreenCenter(dlg);
      dlg.show();
      if(dlg.getReturnCode()==dlg.STATUS_EXIT){
        System.exit(0);
      }
      if(dlg.getReturnCode()==dlg.STATUS_OK){
        util.PublicVariable.USER_RECORD=dlg.getReturnedRecord();
      }
    }
    catch(Exception e) {
      e.printStackTrace();
      System.exit(-1);
    }
    new ProductionApp();
  }
}
