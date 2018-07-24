package newtimes.preproduction;
import javax.swing.UIManager;
import java.awt.*;
import processhandler.template.*;
import processhandler.*;
import newtimes.preproduction.process.*;
import exgui2.*;
/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class PreProductionApp {
  boolean packFrame = false;
  SplitFrame spframe=new SplitFrame();
  CommandFactoryImp cmxFxy=new newtimes.preproduction.process.CmdFtyImp();
  CenteralControlerImp ctnCtl=new newtimes.preproduction.process.CtnCtlImp();
  Constants xtnts=new newtimes.preproduction.Constants();
  static newtimesejb.preproduction.PreProductionHead prdHead;
  //Construct the application
  public PreProductionApp() {
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
    //set centercontroler to system properties.
    Properties.ctnCtl=ctnCtl;
    Properties.getCommandFactory().registerCommand(
      newtimes.preproduction.Constants.CMDSET_PREPRODUCTION_MAINTAIN,
      new PP_Maintain_CmdSet()
    );
    //regist commandset of productions.
    Properties.getCommandFactory().registerCommand(
       newtimes.production.ProdMaintain_Properties.CMDS_PROD_MAINTAIN,
       new newtimes.production.process.prodmaintain.ProdMaintain_CmdSet()
    );
    //regist command of production confirm list
    Properties.getCommandFactory().registerCommand(
         newtimes.production.ProdMaintain_Properties.CMD_SET_PROD_CNFM_LIST,
         new newtimes.production.process.audit_sc_ct.SCCT_CmdSets());
    //regist command of order change functions
    Properties.getCommandFactory().registerCommand(
         newtimes.production.ProdMaintain_Properties.CMD_SET_ORDER_CHAGNE_COMMANDS,
         new newtimes.production.process.order_change.CmdSets4OdrChg());


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
       //Properties.getCenteralControler().setSystemCommander(Constants.CMD_INIT_APP_GUI);
       Properties.getCenteralControler().setSystemCommander(Constants.CMDSET_PREPRODUCTION_MAINTAIN);
       Properties.getCenteralControler().doCommandExecute(new TgrShowFuncList());
    }catch(Exception e){
      e.printStackTrace();
    }
  }
  //Main method
  public static void main(String[] args) {
    Dlg_Login dlg=new Dlg_Login(null,"login please",true);
    util.PublicVariable.SERVER_URL="p.nttpe.com.tw";
    util.PublicVariable.REPORT_SERVER_AT="p.nttpe.com.tw";
    try {
      util.ExceptionLog.setLogPathToImageFolder();
      //UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
      UIManager.setLookAndFeel("com.incors.plaf.alloy.AlloyLookAndFeel");
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
    new PreProductionApp();
  }
}
