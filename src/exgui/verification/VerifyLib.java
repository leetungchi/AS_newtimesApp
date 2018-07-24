package exgui.verification;
import javax.swing.*;
/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2002</p>
 * <p>Company: </p>
 * @author unascribed
 * @version 1.0
 */

public class VerifyLib {
  public VerifyLib() {
  }
  static public boolean isFloat(String inputString){
      String valueObj=inputString;
      if((valueObj==null) || (valueObj.length()==0)){
        return false;
      };
       try{
         float i=Float.parseFloat(valueObj);
       }catch(java.lang.NumberFormatException nfrx){
         return false;
       }
    return true;
  }

  static public boolean isFloat(javax.swing.text.JTextComponent jtx,String message){
      String valueObj=jtx.getText();
       if(!isFloat(valueObj)){
         jtx.grabFocus();
         showAllert(message);
         return false;
       }
      return true;
  }
  static public boolean isInteger(String inputString){
      String valueObj=inputString;
      if((valueObj==null) || (valueObj.length()==0)){
        return false;
      };
       try{
         float i=Integer.parseInt(valueObj);
       }catch(java.lang.NumberFormatException nfrx){
         return false;
       }
    return true;
  }

  static public boolean isInteger(javax.swing.text.JTextComponent jtx,String message){
      String valueObj=jtx.getText();
       if(!isInteger(valueObj)){
         jtx.grabFocus();
         showAllert(message);
         return false;
       }
      return true;
  }

  static public boolean isFloat(exgui.DataBindGUIObject dbObj,String message){
    if(dbObj instanceof exgui.SwingSingleSelection ){
     Object valueObj=((exgui.SwingSingleSelection)dbObj).getSelectedValue();
     if(!isFloat(valueObj.toString())){
       dbObj.getGUIcomponent().grabFocus();
       showAllert(message);
       return false;
     }
    }
    return true;
  }
  static public boolean isInteger(exgui.DataBindGUIObject dbObj,String message){
    if(dbObj instanceof exgui.SwingSingleSelection ){
     Object valueObj=((exgui.SwingSingleSelection)dbObj).getSelectedValue();
     if(!isInteger(valueObj.toString())){
       dbObj.getGUIcomponent().grabFocus();
       showAllert(message);
       return false;
     }
    }
    return true;
  }
  static public boolean is8DgtDate(String value){
    java.text.SimpleDateFormat sdf=new java.text.SimpleDateFormat("yyyy/MM/dd");
    sdf.setLenient(false);
    try{
      if(value==null)return false;
      java.util.Date date1=sdf.parse(value);
       //if(value==null || value.length()!=8) return false;
       //if(!isInteger(value)) return false;
       //if(Integer.parseInt(value)<0)return false;
       return true;
    }catch(java.text.ParseException pe){
       //pe.printStackTrace();
       return false;
    }

  }


  static public void showAllert(String msg){
    util.MiscFunc.hideProcessingMessage();
    JOptionPane.showMessageDialog(
      util.PublicVariable.APP_FRAME ,msg,"column format invalid",JOptionPane.WARNING_MESSAGE
    );
  }

  static public void showAlert(String msg,String title){
    util.MiscFunc.hideProcessingMessage();
      JOptionPane.showMessageDialog(
        util.PublicVariable.APP_FRAME ,msg,title,JOptionPane.WARNING_MESSAGE
      );
    }

  static public void showPlanMsg(String msg,String title){
    util.MiscFunc.hideProcessingMessage();
    JOptionPane.showMessageDialog(
      util.PublicVariable.APP_FRAME ,msg,title,JOptionPane.PLAIN_MESSAGE
    );
  }
 static public boolean showConfirm(String cfmMsg,String title){
   util.MiscFunc.hideProcessingMessage();
   return   showConfirm(cfmMsg,title,false);
 }
 static public boolean showConfirm(String cfmMsg,String title,boolean isDefalutAtYes){
   util.MiscFunc.hideProcessingMessage();
       Object[] buttons = { "Yes", "No" };
           int returnValue = JOptionPane.showOptionDialog(
                                 util.PublicVariable.APP_FRAME ,
                                 cfmMsg,
                                 title,
                                 JOptionPane.YES_NO_OPTION,
                                 JOptionPane.QUESTION_MESSAGE,
                                 null,
                                 buttons,
                                 (isDefalutAtYes)?buttons[0]:buttons[1]
                             );

           return returnValue == JOptionPane.YES_OPTION;
 }
}
