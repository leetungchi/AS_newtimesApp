package processhandler;
import processhandler.commands.*;

/**
 * <p>Title:Implementer of AbleToGoBack </p>
 * <p>Description:This Object  only resides at CenterContraler,for recalling the last execute process </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: meta.com.tw</p>
 * @author Crazy John.
 * @version 1.0
 */

public class CommandGoBack implements AbleToGoBack  {
  public static long runCount=0;
  private CenteralControler xtl=null;
  public CommandGoBack(CenteralControler ctrl) {
    xtl=ctrl;
  }
  public void toGoBack() throws Exception{
    runCount++;
    //find out the parent command object to trigger,and null it.
    //and find the last defferent command trigger object in case duplicate trigger.
    CenteralControler cmdCtl=xtl;
    CommandTrigger xtgr = xtl.getLastExcCmdTgr();
   do{
      if (xtgr != null) {
        CommandTrigger tgtCmd2Exe = xtgr.getParentCmdTrigger();
        if (tgtCmd2Exe != null) {
          //find out the last different cmd obj to execute.
          if(!tgtCmd2Exe.getClass().getName().equals(xtgr.getClass().getName())){
            cmdCtl.doCommandExecute(tgtCmd2Exe);
            xtgr.setParentCmdTrigger(null);
            return;
          }else{
            xtgr=tgtCmd2Exe;
            continue;
          }
        }else{
          return;
        }
      }else{
        return;
      }
   }while(true);
  }
}