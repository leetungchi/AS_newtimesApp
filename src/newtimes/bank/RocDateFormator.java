package newtimes.bank;
import java.awt.event.*;
import javax.swing.ActionMap;
import javax.swing.Action;
/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class RocDateFormator  {
  static DateFormatKeyListener dfk=null;
  static ROC_YEAR_date dateFormat=null;
  public RocDateFormator() {
  }
  public static ROC_YEAR_date getRocDateFormat(){
    if(dateFormat==null) dateFormat=new ROC_YEAR_date();
    return dateFormat;
  }
  public static DateFormatKeyListener getKeyListener(){
    if(dfk==null)dfk=new DateFormatKeyListener();
    return dfk;
  }
}
 class IntFormatKeyListener extends KeyAdapter
   implements exgui.ultratable.KeyProcess{
  protected javax.swing.text.JTextComponent myTextComponent=null;
  protected String tomask="0123456789-";
  protected void updateToMonitor(){
      java.awt.Container parentCon=myTextComponent.getParent();
      while(parentCon!=null){
        if(parentCon instanceof exgui.ultratable.MultiEditorJTable){
          myTextComponent.validate();
           ((exgui.ultratable.MultiEditorJTable)parentCon).mt.m_Text=
               myTextComponent.getText();
           //System.out.println(" update to ((exgui.ultratable.MultiEditorJTable)parentCon).mt.m_Text :"+myTextComponent.getText());
           break;
        }
        //System.out.println("keep lookup parent ,current parent is "+parentCon.getClass().getName());
        parentCon=parentCon.getParent();
      }
  }
  public void keyReleased(java.awt.event.KeyEvent e){
    updateToMonitor();
  }
  public void keyPressed(java.awt.event.KeyEvent e){
    //System.out.println("Press get key Code:"+e.getKeyCode());
    if(e.isActionKey()){
       //System.out.println("now  is action key presse");
       return;
    }
    if(e.getKeyCode()==e.VK_BACK_SPACE){
         ActionMap map =  myTextComponent.getActionMap();
         Action action = (Action)map.get(
           javax.swing.text.DefaultEditorKit.deletePrevCharAction);
         action.actionPerformed( null );
       e.consume();
    }
  }

  public void keyTyped(java.awt.event.KeyEvent e){
    //System.out.println("Type get key char:"+e.getKeyChar());
    if(e.isActionKey())return;
    if(e.getKeyCode()==e.VK_BACK_SPACE)return;
    if(e.getKeyCode()==e.VK_DELETE)return;

    if(e.getKeyChar()=='-'&&
       myTextComponent.getCaretPosition()!=0){
      // "-" is only allow to be showen at first character
      e.consume();
      return;
    }
    String myCharStr=String.valueOf(e.getKeyChar());
    if(tomask.indexOf(myCharStr)==-1){
      java.awt.Toolkit.getDefaultToolkit().beep();
      e.consume();
    }
  }
  public void bind2TextComponent(javax.swing.text.JTextComponent txtcmp){
    myTextComponent=txtcmp;
    myTextComponent.addKeyListener(this);
  }
 }
 class ROC_YEAR_date implements exgui.ultratable.CellTxtEditorFormat,exgui.Object2String{
     java.text.SimpleDateFormat sdf=new java.text.SimpleDateFormat("yyyy/MM/dd");//new java.text.SimpleDateFormat("yyyyMMdd");
     public int getMaxLength(){return 9;}
     public String formatPromptMsg(){return "日期格式為:民國 年年年/月月/日日";}
     public boolean isFormatValid(String inStr,int row,int column){
       sdf.setLenient(false);
       if(inStr==null) return true;
       if(inStr.trim().length()==0) return true;
       try{

         String strs[]=util.MiscFunc.split(inStr,"/");
         int year=Integer.parseInt(strs[0]);
         year+=1911;//convert fomr R.O.C 's year to A.D. YEAR
         String finalStr=String.valueOf(year)+"/"+strs[1]+"/"+strs[2];
         //sdf.parse(inStr);
         sdf.parse(finalStr);
         return true;
       }catch(Exception e){
         return false;
       }
       //return exgui.verification.VerifyLib.is8DgtDate(inStr);
     }
     public exgui.ultratable.KeyProcess getKeyListener(){
       return new DateFormatKeyListener();
     }
     public Object cellStringToObject(String str){
       if(str==null||str.trim().length()==0)return null;
       try{
         String strs[]=util.MiscFunc.split(str,"/");
         int year=Integer.parseInt(strs[0]);
         year+=1911;//convert fomr R.O.C 's year to A.D. YEAR
         String finalStr=String.valueOf(year)+"/"+strs[1]+"/"+strs[2];
         return sdf.parse(finalStr);
       }catch(Exception exp){
         exp.printStackTrace();
         return null;
       }
     }
     public String Obj2String(Object obj2kvt){
        if(obj2kvt==null) return "";
        try{
          String[] dateStr= util.MiscFunc.split(sdf.format((java.util.Date)obj2kvt),"/");
          int year=Integer.parseInt(dateStr[0]);
          year-=1911;
          String finalStr=String.valueOf(year)+"/"+dateStr[1]+"/"+dateStr[2];
          return finalStr;
        }catch(Exception e){
          e.printStackTrace();
          return "";
        }
     }

 }

  class DateFormatKeyListener extends IntFormatKeyListener{
    protected String tomask="0123456789";
    protected  char DateDlmt='/';
    public void keyTyped(java.awt.event.KeyEvent e){
      //System.out.println("Type get key char:"+e.getKeyChar());
      if(e.isActionKey())return;
      if(e.getKeyCode()==e.VK_BACK_SPACE)return;
      if(e.getKeyCode()==e.VK_DELETE)return;
      String myCharStr=String.valueOf(e.getKeyChar());
      if(tomask.indexOf(myCharStr)==-1){
        if(e.getKeyCode()!=e.VK_BACK_SPACE)
            java.awt.Toolkit.getDefaultToolkit().beep();
        e.consume();
      }else{
        //System.out.println("caret position:"+mytxt.getCaretPosition() );
        // auto complet the "/" if at 4,6 position
        int cursorPos=myTextComponent.getCaretPosition();
        int Pos2WithSlash=1;//2 or 1,depend on begin char of year,0~5 is "2",6~9 is "1"
        if(myTextComponent.getText().length()>0){
          int YearBgnDigit = Integer.parseInt(myTextComponent.getText().substring(
              0, 1));
          if (YearBgnDigit < 6) {
            Pos2WithSlash = 2;
          } else {
            Pos2WithSlash = 1;
          }
        }
        if(cursorPos==Pos2WithSlash||cursorPos==Pos2WithSlash+3){
          //auto complete the "/" caharacter.
          if((myTextComponent.getText().length()-1)<cursorPos){
            String orgString=myTextComponent.getText()+e.getKeyChar()+DateDlmt;
            myTextComponent.setText(orgString);
             ++cursorPos;
             ++cursorPos;
            myTextComponent.setCaretPosition(cursorPos);
            e.consume();
          }else{
              //set to replace mod.
          }
        }
      }
     }

  }

