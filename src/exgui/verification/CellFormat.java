package exgui.verification;
import exgui.ultratable.CellTxtEditorFormat;
import java.awt.event.*;
import javax.swing.*;
import exgui.ultratable.KeyProcess;
/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2002</p>
 * <p>Company: </p>
 * @author unascribed
 * @version 1.0
 */

public class CellFormat {
  static DateStringFormaterAllowNull dsfwnu=null;
  static DateStringFormater dsfm=null;

  public CellFormat() {

  }
    static public  IntegerStringVerifier  getIntVerifier(int maxLength){
      return new IntegerStringVerifier(maxLength);
    }
    static public IntegerStringVerifierAllowNull  getIntVerifierAllowNull(int maxLength){
     return new IntegerStringVerifierAllowNull(maxLength);
    }
    static public DoubleFormatAllowNull getDoubleFormatAllowNull(int maxLength){
     return new DoubleFormatAllowNull(maxLength);
    }
    static public DoubleFormat getDoubleFormat(int maxLength){
     return new DoubleFormat(maxLength);
    }
   static public OrdinaryField  getOrdinaryField(int maxLength){
    return new OrdinaryField(maxLength);
   }
   static public OrdinaryFieldNotAllowNull getOrdinaryFieldNotAllowNull(int maxLength){
     return new OrdinaryFieldNotAllowNull(maxLength);
   }
   static public DateStringFormater getDateStringFormater(){
     if(dsfm ==null)
       dsfm =new DateStringFormater();
     return dsfm;
   }
   static public DateStringFormaterAllowNull getDateStringFormaterAllowNull(){
     if(dsfwnu ==null)
       dsfwnu=new DateStringFormaterAllowNull();
     return dsfwnu ;
   }
  static public DetailDoubleFormat getDoubleFormat(int intDigitLength,int floatDigitLength){
    return new DetailDoubleFormat(intDigitLength,floatDigitLength);
  }
  static public DetailDoubleFormatAllowNull getDoubleFormatAllowNull(int intDigitLength,int floatDigitLength){
    return new DetailDoubleFormatAllowNull(intDigitLength,floatDigitLength);
  }
  static public DoubleFormatDot00RiteAligne getDoubleFormatDot00RiteAligne(int intDigitLength,int floatDigitLength){
    return new DoubleFormatDot00RiteAligne(intDigitLength,floatDigitLength);
  }


  static public Text_CaseSensitive getText_CaseSensitive(int maxLen){
    return new Text_CaseSensitive(maxLen);
  }
  static public Text_CaseSensitive getText_CaseSensitiveNotAllowNull(int maxLen){
    return new Text_CaseSensitiveNotAllowNull(maxLen);
  }
  static public exgui.ultratable.KeyProcess
      getDateFormatKeyProcess(){return new DateFormatKeyListener(); }
  static public exgui.ultratable.KeyProcess
      getIntFormatKeyProcess(){return new IntFormatKeyListener(); }
  static public exgui.ultratable.KeyProcess
      getDecFormatKeyProcess(){return new DecFormatKeyListener(); }
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
      if(cursorPos==3||cursorPos==6){
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
    //updateToMonitor();
   }

}
 class DecFormatKeyListener extends IntFormatKeyListener{
  DecFormatKeyListener(){
    super.tomask="0123456789-.";
  }
}
 class NormalKeyListener extends KeyAdapter
     implements exgui.ultratable.KeyProcess{
    protected javax.swing.text.JTextComponent myTextComponent=null;
    public void keyPressed(java.awt.event.KeyEvent e){
    }
    protected void updateToMonitor(){
        java.awt.Container parentCon=myTextComponent.getParent();
        while(parentCon!=null){
          if(parentCon instanceof exgui.ultratable.MultiEditorJTable){
            myTextComponent.validate();
             ((exgui.ultratable.MultiEditorJTable)parentCon).mt.m_Text=
                 myTextComponent.getText();
             ///System.out.println(" update to ((exgui.ultratable.MultiEditorJTable)parentCon).mt.m_Text :"+myTextComponent.getText());
             break;
          }
          //System.out.println("keep lookup parent ,current parent is "+parentCon.getClass().getName());
          parentCon=parentCon.getParent();
        }
    }
    public void keyReleased(java.awt.event.KeyEvent e){
      //System.out.println("get Key Code:"+e.getKeyCode());
      updateToMonitor();
    }
    public void keyTyped(java.awt.event.KeyEvent e){
    }
    public void bind2TextComponent(javax.swing.text.JTextComponent txtcmp){
      myTextComponent=txtcmp;
      myTextComponent.addKeyListener(this);
    }
 }
 class IntFormatKeyListener extends KeyAdapter
    implements exgui.ultratable.KeyProcess{
   protected javax.swing.text.JTextComponent myTextComponent=null;
   protected String tomask="0123456789-";
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
     //updateToMonitor();
   }
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
     //updateToMonitor();
   }
   public void bind2TextComponent(javax.swing.text.JTextComponent txtcmp){
     myTextComponent=txtcmp;
     myTextComponent.addKeyListener(this);
   }
}


  class DateStringFormater extends DateStringFormaterAllowNull{
    public boolean isFormatValid(String inStr,int row,int column){
      sdf.setLenient(false);
      if(inStr==null) return false;
      if(inStr.trim().length()==0) return false;
      try{
        sdf.parse(inStr);
        return true;
      }catch(Exception e){
        return false;
      }
      //return exgui.verification.VerifyLib.is8DgtDate(inStr);
    }
  }
  class DateStringFormaterAllowNull implements exgui.ultratable.CellTxtEditorFormat,exgui.Object2String{
    java.text.SimpleDateFormat sdf=new java.text.SimpleDateFormat("yyyy/MM/dd");//new java.text.SimpleDateFormat("yyyyMMdd");
    public int getMaxLength(){return 10;}
    public String formatPromptMsg(){return "String must be in date format:yyyy/mm/dd";}
    public boolean isFormatValid(String inStr,int row,int column){
      sdf.setLenient(false);
      if(inStr==null) return true;
      if(inStr.trim().length()==0) return true;
      try{
        sdf.parse(inStr);
        return true;
      }catch(Exception e){
        return false;
      }
      //return exgui.verification.VerifyLib.is8DgtDate(inStr);
    }
    public KeyProcess getKeyListener(){
      return new DateFormatKeyListener();
    }
    public String Obj2String(Object obj2kvt){
       if(obj2kvt==null) return "";
       try{
         return sdf.format((java.util.Date)obj2kvt);
       }catch(Exception e){
         e.printStackTrace();
         return "";
       }
    }

   public Object cellStringToObject(String String2kvt){
      if(String2kvt==null) return null;
      if(String2kvt.trim().length()==0) return null;
      try{
         return sdf.parse(String2kvt);
      }catch (Exception e){
        e.printStackTrace();
        return null;
      }
   }
  }


 class IntegerStringVerifierAllowNull implements exgui.ultratable.CellTxtEditorFormat,exgui.Object2String{
    int _maxLength=0;
    public  IntegerStringVerifierAllowNull(int maxLength){
       _maxLength=maxLength;
    }
    public int getMaxLength(){return _maxLength;}
    public String formatPromptMsg(){return "String Must be numeric";}
    public KeyProcess getKeyListener(){
     return new IntFormatKeyListener();
    }
    public boolean isFormatValid(String inStr,int row,int column){
       if(inStr==null || inStr.length()==0) return true;
       return exgui.verification.VerifyLib.isInteger(inStr);
    };
     public Object cellStringToObject(String String2kvt){
       //return Integer.getInteger(String2kvt);
       if(String2kvt==null || String2kvt.length()==0) return null;
       return new Integer(String2kvt);
     }
    public String Obj2String(Object obj){
      if(obj==null) return "";
      return obj.toString();
    }
  }

  class IntegerStringVerifier extends IntegerStringVerifierAllowNull{
     public IntegerStringVerifier(int maxLength){
      super(maxLength);
     }
     public Object cellStringToObject(String String2kvt){
       return new Integer(String2kvt);
     }
    public String Obj2String(Object obj){
      if(obj==null) return "0";
      return obj.toString();
    }
  }
  class OrdinaryFieldNotAllowNull extends OrdinaryField{
    OrdinaryFieldNotAllowNull(int limitSize){
      super(limitSize);
    }

    public boolean isFormatValid(String inStr,int row,int column){
       if(inStr==null){
         promptMsg="String can not be blank";
         return false;
       }
       if(inStr.trim().length()==0){
         promptMsg="String can not be blank";
         return false;
       }
       if(inStr.getBytes().length>_maxLength){
         promptMsg="String can not exceed "+_maxLength+" bytes ";
         return false;
       }
       return true;
    }
  }
  class Text_CaseSensitiveNotAllowNull
      extends Text_CaseSensitive{
     public  Text_CaseSensitiveNotAllowNull(int limitSize){
       super(limitSize);
      }
     public boolean isFormatValid(String inStr,int row,int column){
        if(inStr==null){
          promptMsg="String can not be blank";
          return false;
        }
        if(inStr.trim().length()==0){
          promptMsg="String can not be blank";
          return false;
        }
        if(inStr.getBytes().length>_maxLength){
          promptMsg="String can not exceed "+_maxLength+" bytes ";
          return false;
        }
        return true;
     }
 }

  class Text_CaseSensitive extends OrdinaryField{
        Text_CaseSensitive(int limitSize){
        super(limitSize);}
      public Object cellStringToObject(String String2kvt){
        //return Integer.getInteger(String2kvt);
        if(String2kvt==null || String2kvt.length()==0) return null;
        return String2kvt;
      }
     public String Obj2String(Object obj){
       if(obj==null) return "";
       return obj.toString();
     }
  }
  class OrdinaryField  implements exgui.ultratable.CellTxtEditorFormat,exgui.Object2String{
     int _maxLength;
     String promptMsg=null;
     OrdinaryField(int limitSize){
       _maxLength=limitSize;
       promptMsg="String can not exceed "+_maxLength+" bytes ";
     }
     public KeyProcess getKeyListener(){
       return new NormalKeyListener();
     }
    public int getMaxLength(){return _maxLength;}
    public String formatPromptMsg(){
      return promptMsg;
    }
    public boolean isFormatValid(String inStr,int row,int column){
       if(inStr==null)return true;
       if(inStr.getBytes().length>_maxLength) return false;
       return true;
    };
     public Object cellStringToObject(String String2kvt){
       //return Integer.getInteger(String2kvt);
       if(String2kvt==null || String2kvt.length()==0) return null;
       return String2kvt.toUpperCase();
     }
    public String Obj2String(Object obj){
      if(obj==null) return "";
      return obj.toString().toUpperCase();
    }
  }
  class DoubleFormatAllowNull implements exgui.ultratable.CellTxtEditorFormat,exgui.Object2String{
    java.text.DecimalFormat formatter = new java.text.DecimalFormat("######.###");
    int _maxLength=0;
    DoubleFormatAllowNull(int maxLength){
     _maxLength =maxLength;
    }
    public KeyProcess getKeyListener(){
      return new DecFormatKeyListener();
    }
    public int getMaxLength(){return _maxLength ;}
    public String formatPromptMsg(){return "String must be in decimal format:XXX.XX";}
    public boolean isFormatValid(String inStr,int row,int column){
            if(inStr==null) return true;
            if(inStr.trim().length()==0)return true;
             try {
              if(inStr.indexOf(".")==-1 && inStr.length()>_maxLength-3) return false;
              if(inStr.indexOf(".")==(inStr.length()-1))return false;
              if(inStr.indexOf(".")==0){
                inStr="0"+inStr;
              }
              if(inStr!=null && inStr.indexOf(".")!=-1){
                Double d = new Double(
                  ((Number)formatter.parse((String)inStr)).doubleValue());
                return true;
              }else{
                return exgui.verification.VerifyLib.isInteger(inStr);
              }
            } catch (java.text.ParseException ex) {
              return false;
            }
    }
    public String Obj2String(Object obj2kvt){
       if(obj2kvt==null) return "";
       if(obj2kvt instanceof Double){
          //return String.valueOf(((Double)obj2kvt).doubleValue());
          String value= String.valueOf(((Double)obj2kvt).doubleValue());
         return value;
       }else{
         //return obj2kvt.toString();
         String value=obj2kvt.toString();
          if(value.endsWith("0")&&value.indexOf(".")>0){
            value=value.substring(0,value.length()-1);
          }
          return value;
       }
    }
     public Object cellStringToObject(String String2kvt){
        if(String2kvt==null) return null;
        if(String2kvt.trim().length()==0) return null;
            try {
              Double d = new Double(
                ((Number)formatter.parse((String)String2kvt)).doubleValue());
              return d;
            } catch (java.text.ParseException ex) {
              return new Double(0.0);
            }
     }
  }
  class DoubleFormat extends DoubleFormatAllowNull{
    DoubleFormat(int maxLength){
      super(maxLength);
    }
    public boolean isFormatValid(String inStr,int row,int column){
            if(inStr==null) return false;
            if(inStr.trim().length()==0)return false;
            return super.isFormatValid(inStr,row,column);
    }
    public String Obj2String(Object obj2kvt){
       if(obj2kvt==null) return "0.0";
       if(obj2kvt instanceof Double){
        /*
          return String.valueOf(((Double)obj2kvt).doubleValue());
         */
         String value= String.valueOf(((Double)obj2kvt).doubleValue());
          //trim the last "0"
         return value;
       }else{
         //return obj2kvt.toString();
          String value=obj2kvt.toString();
          if(value.endsWith("0")&&value.indexOf(".")>0){
            value=value.substring(0,value.length()-1);
          }
          return value;

       }
    }
  }
  class DetailDoubleFormat extends DetailDoubleFormatAllowNull{
   public DetailDoubleFormat(int intDgtLen,int fltDtgLen){
    super(intDgtLen,fltDtgLen);
   }
    public boolean isFormatValid(String inStr,int row,int column){
            if(inStr==null) return false;
            if(inStr.trim().length()==0)return false;
            return super.isFormatValid(inStr,row,column);
    }
    public String Obj2String(Object obj2kvt){
       //System.out.println("running DetailDoubleFormat to string function");
       if(obj2kvt==null) return "0";
       if(obj2kvt instanceof Double){
         //return String.valueOf(((Double)obj2kvt).doubleValue());
          String value= String.valueOf(((Double)obj2kvt).doubleValue());
          return value;
       }else{
         String value=obj2kvt.toString();
          if(value.endsWith("0")&&value.indexOf(".")>0){
            value=value.substring(0,value.length()-1);
          }
          return value;
       }
    }

  }
  class DoubleFormatDot00RiteAligne  extends DetailDoubleFormatAllowNull{

     DoubleFormatDot00RiteAligne(int intDigitLength,int floatDigitLength){
       super(intDigitLength,floatDigitLength);
      _maxLength=intDigitLength+floatDigitLength+1;//include "." character
      _intDigitLength=intDigitLength;
      _floatDigitLength=floatDigitLength;

      String totalString="#############################################";
      String endZero="00000000000000000000000";

      StringBuffer sbTotalString=new StringBuffer();
      sbTotalString.append(totalString.substring(0,_intDigitLength-1));
      sbTotalString.append("0");

      headString=new String(sbTotalString.toString());
      tailString=endZero.substring(0,_floatDigitLength);
      sbTotalString.append(".");
      sbTotalString.append(endZero.substring(0,_floatDigitLength));
      formatter=new java.text.DecimalFormat(sbTotalString.toString());

    }
    public String Obj2String(Object obj2kvt){
       if(obj2kvt==null) return "";
       if(obj2kvt.toString().trim().equals(""))return obj2kvt.toString();
       return formatter.format(Double.parseDouble(obj2kvt.toString().trim()));
       /*
       if(obj2kvt instanceof Double){
          String value= formatter.format(((Double)obj2kvt).doubleValue());
          return value;
        }else{
         String value=obj2kvt.toString();
          if(value.endsWith("0")&&value.indexOf(".")>0){
            value=value.substring(0,value.length()-1);
          }
          return value;
       }*/
    }

    public KeyProcess getKeyListener(){
      KeyListenerWithRightAligne keyListener=new KeyListenerWithRightAligne();
      return  keyListener;
    }
  }
  class KeyListenerWithRightAligne extends DecFormatKeyListener{
    KeyListenerWithRightAligne(){
      super();
    }
    public void bind2TextComponent(javax.swing.text.JTextComponent txt){
      super.bind2TextComponent(txt);
      ((javax.swing.JTextField)txt).setHorizontalAlignment(javax.swing.JTextField.RIGHT);
    }
  }
  class DetailDoubleFormatAllowNull implements exgui.ultratable.CellTxtEditorFormat,exgui.Object2String{
    java.text.DecimalFormat formatter = null;//new java.text.DecimalFormat("######.###");
    int _maxLength=0;
    int _intDigitLength=0,_floatDigitLength=0;
    String headString,tailString;
    public DetailDoubleFormatAllowNull(int intDigitLength,int floatDigitLength){
      _maxLength=intDigitLength+floatDigitLength+1;//include "." character
      _intDigitLength=intDigitLength;
      _floatDigitLength=floatDigitLength;
      String totalString="##############################################";
      formatter=new java.text.DecimalFormat(
        totalString.substring(_intDigitLength)+"."+totalString.substring(_floatDigitLength));
      headString=totalString.substring(0,_intDigitLength);
      tailString=totalString.substring(0,_floatDigitLength);
    }

    public int getMaxLength(){return _maxLength ;}
    public KeyProcess getKeyListener(){
      return new DecFormatKeyListener();
    }
    public String formatPromptMsg(){return "String must be in decimal format:"+headString+"."+tailString;}
    public boolean isFormatValid(String inStr,int row,int column){
            if(inStr==null) return true;
            if(inStr.trim().length()==0)return true;
             try {
              if(inStr.indexOf(".")==-1 && inStr.length()>_intDigitLength) return false;
              if(inStr.indexOf(".")==(inStr.length()-1))return false;
              if(inStr.indexOf(".")==0){
                inStr="0"+inStr;
              }
              if(inStr!=null && inStr.indexOf(".")!=-1){
                String arrDgs[]=util.MiscFunc.SplitByStringTokenizer(inStr,".");
                if(arrDgs[0].length()>_intDigitLength) return false;
                if(arrDgs[1].length()>_floatDigitLength) return false;
                Double d = new Double(
                  ((Number)formatter.parse((String)inStr)).doubleValue());
                return true;
              }else{
                return exgui.verification.VerifyLib.isInteger(inStr);
              }
            } catch (java.text.ParseException ex) {
              return false;
            }
    }
    public String Obj2String(Object obj2kvt){
       if(obj2kvt==null) return "";
       if(obj2kvt instanceof Double){
          String value= String.valueOf(((Double)obj2kvt).doubleValue());
          return value;
        }else{
         //return obj2kvt.toString();
         String value=obj2kvt.toString();
          if(value.endsWith("0")&&value.indexOf(".")>0){
            value=value.substring(0,value.length()-1);
          }
          return value;
       }
    }
     public Object cellStringToObject(String String2kvt){
        if(String2kvt==null) return null;
        if(String2kvt.trim().length()==0) return null;
            try {
              Double d = new Double(
                ((Number)formatter.parse((String)String2kvt)).doubleValue());
              return d;
            } catch (java.text.ParseException ex) {
              return new Double(0.0);
            }
     }
  }



