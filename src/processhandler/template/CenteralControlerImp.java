package processhandler.template;
import processhandler.*;
import processhandler.commands.*;
import javax.swing.*;
import exgui2.*;
import java.util.*;
/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class CenteralControlerImp implements CenteralControler {
  Object cmdExe=null;
  DataProcesser dp=null;
  JFrame containerFrame=null;
  SplitFrame splFrm=null;
  CommandFactory cmFx=null;
  static List cmdTriigerList=null;
  CommandGoBack cmdGoBack=null;
  TriggerGoBack BACK_TO_LAST_GUI=new TriggerGoBack();
  java.awt.Component cmptAtTab=null;
  int dtlTabIndex=0;
  java.awt.Component dtlTabComponent=null;
  database.datatype.Record tgtRec=null;
  protected CommandTrigger lastRecordTrigger=null;
  CommandTrigger lastExecutedTrigger=null;
  protected CenteralControlerImp() {
     if(cmdTriigerList==null){
       cmdTriigerList=new ArrayList();
     }
     cmdGoBack=new CommandGoBack(this);
  }

  public void setCommandFactory(CommandFactory commandFactory){
     cmFx=commandFactory;
  }
  public void setDataProcesser(DataProcesser db){
    dp=db;
  }
  public void setMainFrame(JFrame jframe){
     containerFrame=jframe;
  }
  public void setBasicFrameWork(SplitFrame  bxFrame){
     splFrm=bxFrame;
  }
  public void setSystemCommander(Object obj)throws CommandException {
    if(obj==null)throw new CommandException("command can not be null");
    cmdExe=obj;
  }
  public Object setSystemCommander(String lookupCmdName)throws CommandException{
    Object obj=cmFx.lookupCommand(lookupCmdName);
    if(obj==null)throw new CommandException("there is no command \""+lookupCmdName+"\",please register it into system's command factory");
    cmdExe=obj;
    return obj;
  }
  public DataProcesser getDataProcesser(){
    return dp;
  }
  public void goBack()throws CommandException {
    java.awt.Cursor ksr=null;
    try{
       if(util.PublicVariable.APP_FRAME!=null){
         ksr=util.PublicVariable.APP_FRAME.getCursor();
         util.PublicVariable.APP_FRAME.setCursor(
           new java.awt.Cursor(java.awt.Cursor.WAIT_CURSOR)
         );
       }
       BACK_TO_LAST_GUI.toRunCommand(cmdGoBack);
    }catch(CommandIncompleteException exp){
    }catch(CommandException e){
       throw e;
    }finally{
      if(ksr!=null){
        util.PublicVariable.APP_FRAME.setCursor(ksr);
      }
    }
  }
  public void doCommandExecute(CommandTrigger cmdTrigger) throws CommandException{
    CommandTrigger tempLastTrigger=lastExecutedTrigger;
    try{
      //recording the last situations.
      lastExecutedTrigger=cmdTrigger;
      cmdTrigger.setCenteralControler(this);
      //no need to cover current or pre-existed parent command trigger object.
      if(lastRecordTrigger!=null){
        //even the same class,we need to prevent the over-lap problem
        if (cmdTrigger!=lastRecordTrigger) {
          if (cmdTrigger.getParentCmdTrigger() == null) {
            cmdTrigger.setParentCmdTrigger(lastRecordTrigger);
          }
        }
      }
      //be aware of that,the trigger object may contains other command set.
      if(cmdTrigger.commander!=null)
           cmdExe=cmdTrigger.commander;
      //System.out.println("current command trrigger object is:"+cmdTrigger);
      cmdTrigger.toRunCommand(cmdExe);
    }catch(CommandIncompleteException cie){
      lastExecutedTrigger=tempLastTrigger;
      if(lastExecutedTrigger.commander!=null)cmdExe=lastExecutedTrigger.commander;
      return;
    }catch(CommandException e){
      lastExecutedTrigger=tempLastTrigger;
      throw e;
    }
  }
  public List getTriggerHistory(){
    return cmdTriigerList;
  }
  public void recordProcess(CommandTrigger cmdTrigger){
    //cmdTriigerList.add(cmdTrigger);
    lastRecordTrigger=cmdTrigger;
  }
  public Object getCurrentSystemCommand(){
     return cmdExe;
  }
  public void setCurrentEditingMasterRecord(database.datatype.Record rec2Edit){
     tgtRec=rec2Edit;
     /*
     if(tgtRec==null){
       tgtRec=rec2Edit;
       return ;
     }

     tgtRec.getFieldName().clear();
     tgtRec.getValueFields().clear();
     for(int i=0;i<rec2Edit.getFieldName().size();i++){
       tgtRec.getFieldName().add(rec2Edit.getFieldName().get(i));
       tgtRec.getValueFields().add(rec2Edit.getValueFields().get(i));
     }
     tgtRec.getModifiedFields().clear();*/
  }
  public void setTargetTab(int tabIndex,java.awt.Component component){
     dtlTabIndex= tabIndex;
     dtlTabComponent=component;
  }

  public database.datatype.Record getCurrentEditingMasterRecord(){
     return tgtRec;
  }
  public int getSelectedTabIndex(){
     return dtlTabIndex;
  }
  public java.awt.Component getSelectedTabComponent(){
     return dtlTabComponent;
  }
  public CommandTrigger getLastExcCmdTgr(){
    return lastExecutedTrigger;
  }

}
