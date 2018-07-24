package processhandler;
import processhandler.commands.*;
/**
 * <p>Title:Trigger Class </p>
 * <p>Description:the Trigger Class to Activate specified action of a Command(Process) Object<br>
 *    The Command(Process) Object is stored in CenterControl Object current application.
 *  </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: meta.com.tw</p>
 * @author Crazy John
 * @version 1.0
 */

abstract public  class CommandTrigger {
  public Object commander=null;
  protected CenteralControler ctnCtl=null;
  protected CommandTrigger parentCmdTgr=null;
  public CommandTrigger() {
  }
  public void toRunCommand(Object inputCmd)throws CommandException,CommandIncompleteException{
    commander=inputCmd;
    //test if DataProcesser is Changed but not nodified.
    DataProcesser pnlDP=
        processhandler.template.Properties.getCenteralControler().getDataProcesser();

    if(pnlDP!=null){
      boolean exitCurrentGuiExecuted=false;
      if(pnlDP.isContextModified()){
        if(exgui.verification.VerifyLib.showConfirm(
           "This page had been modified\nBut not confirmed\nDo You Want To Exit Without Confirm"
           ,"Page Modified!!")){
           pnlDP.exitCurrentGui();
           exitCurrentGuiExecuted=true;
           processhandler.template.Properties.getCenteralControler().setDataProcesser(null);
           activateThisProcess();
           return;
        }else{
          //throws exception to controler,not to record this command.
           throw new CommandIncompleteException();
        }
      }
      if(!exitCurrentGuiExecuted)pnlDP.exitCurrentGui();
      processhandler.template.Properties.getCenteralControler().setDataProcesser(null);
      activateThisProcess();
      return;
    }else{
      processhandler.template.Properties.getCenteralControler().setDataProcesser(null);
      activateThisProcess();
    }
    /*
    if(pnlDP!=null && pnlDP.isContextModified()){

        if(exgui.verification.VerifyLib.showConfirm(
           "This page had been modified\nBut not confirmed\nDo You Want To Exit Without Confirm"
           ,"Page Modified!!")){
           processhandler.template.Properties.getCenteralControler().setDataProcesser(null);
           activateThisProcess();
        }else{
          //throws exception to controler,not to record this command.
           throw new CommandIncompleteException();
        }
    }else{
          processhandler.template.Properties.getCenteralControler().setDataProcesser(null);
          activateThisProcess();
    }*/

  }
  public void setParentCmdTrigger(CommandTrigger _cmdTgr){
    parentCmdTgr=_cmdTgr;
  }
  public CommandTrigger getParentCmdTrigger(){
    return parentCmdTgr;
  }
  /**
   * child class need to detect(by "instanceof" java function) if command object is suitable(have the desired Interface) to run the coresponding functions.
   * @throws CommandException sometimes casued by command object type casting problem,or run time exception of proxy in command
   */
  protected abstract  void activateThisProcess() throws CommandException;
  public  void setCenteralControler(CenteralControler ctl){
     ctnCtl=ctl;
  }
}
