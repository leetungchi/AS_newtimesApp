package newtimes.production.gui.prodmaintain;

import java.awt.*;
import javax.swing.*;
import exgui.chaindialog.*;
import java.util.Vector;
import java.awt.event.*;
public class PnlRspShowMark extends JPanel implements  Responsible{
  JScrollPane jScrollPane1 = new JScrollPane();
  JTextArea txtMarkContent = new JTextArea();
  String[] _MainMark;
  String[] _SideMark;
  JTextArea ara=null;
  public static String KEY_TEXT_AREA_DATA="newtimes.production.gui.prodmaintain.PnlRspShowMark_TEXT";
  BorderLayout borderLayout1 = new BorderLayout();
  public static String complementStringAlignRight(char char2Leading,String string2Follow,int length){
    if(string2Follow==null)return null;
    if(string2Follow.length()>=length)return string2Follow.substring(0,length);
    char chars[]=new char[length];
    java.util.Arrays.fill(chars,char2Leading);
    String leadingStr=new String(chars);
    return  string2Follow+leadingStr.substring(0, length - string2Follow.length()) ;
  }

  public PnlRspShowMark(String mainMark,String sideMark) {
    try {
      jbInit();
      //compose to jtable to make main mar & side mark as table and rows.
      if(sideMark==null||sideMark.trim().length()==0){
        txtMarkContent.setText(mainMark);
        return;
      }else{
        _MainMark=mainMark.split("\n") ;
        _SideMark=sideMark.split("\n");
        int maxCount=(_MainMark.length>_SideMark.length)?_MainMark.length:_SideMark.length;
        java.util.List stringLists=new java.util.ArrayList();
        int maxLengthOfMainMark=0;
        for(int i=0;i<maxCount;i++){
          String str=new String();
          if(i<_MainMark.length){
            if(maxLengthOfMainMark<_MainMark[i].length())maxLengthOfMainMark=_MainMark[i].length();
            str = _MainMark[i];
          }
          stringLists.add(str);
        }
        StringBuffer sb=new StringBuffer();
        for(int i=0;i<maxCount;i++){
          String str=(String)stringLists.get(i);
          str=complementStringAlignRight(' ',str,maxLengthOfMainMark);
          if(i<_SideMark.length){
            str+="       ";
            str+=_SideMark[i];
          }
          sb.append(str);
          sb.append("\n");
        }
        txtMarkContent.setText(sb.toString());
      }
    }
    catch(Exception e) {
      e.printStackTrace();
    }
  }
  private void jbInit() throws Exception {
    this.setLayout(borderLayout1);
    txtMarkContent.setText("");
    txtMarkContent.setFont(new java.awt.Font("DialogInput", 0, 12));
    this.add(jScrollPane1, BorderLayout.CENTER);
    jScrollPane1.getViewport().add(txtMarkContent, null);
  }
  public JComponent getGUI(){return this;}
  public void setDefalutNext(Responsible dfltRsp){}
  public Responsible next()throws NextResponsibleIsNotReady{
     storedMap.put(KEY_TEXT_AREA_DATA,txtMarkContent.getText());
     return null;
  }
  public boolean isAllowOkNow(){return true;}



}
