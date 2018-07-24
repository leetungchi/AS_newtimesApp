package exgui;
import java.awt.event.*;
/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2002</p>
 * <p>Company: </p>
 * @author unascribed
 * @version 1.0
 */

public class DataBindTextWithChecker extends DataBindText{
  protected exgui.Object2String _obj2Strkvt=null;
  protected exgui.ultratable.CellTxtEditorFormat _klmVfy=null;
  boolean prcLostFocus=false;
  protected MyFocusListener myFksAdpt=null;
  public DataBindTextWithChecker(){}

  public  DataBindTextWithChecker(final javax.swing.text.JTextComponent jtx,
                                  String fromCurrRecordField,
                                  Object orgValueObj,
                                  int maxLength,
                                  exgui.Object2String obj2Strkvt,
                                  exgui.ultratable.CellTxtEditorFormat klmVfy
                                  ) {
       init(jtx,fromCurrRecordField,orgValueObj,maxLength,obj2Strkvt,klmVfy);

  }
  protected void init(
                                      final javax.swing.text.JTextComponent jtx,
                                      String fromCurrRecordField,
                                      Object orgValueObj,
                                      int maxLength,
                                      exgui.Object2String obj2Strkvt,
                                      exgui.ultratable.CellTxtEditorFormat klmVfy


  ){
    super.init(jtx, fromCurrRecordField, orgValueObj, maxLength);
    this._klmVfy = klmVfy;
    this._obj2Strkvt = obj2Strkvt;
    jtx.setText(_obj2Strkvt.Obj2String(orgValueObj));
    if(myFksAdpt==null){
      myFksAdpt= new MyFocusListener(jtx);
    }
    /*
    FocusListener flk[]=jtx.getFocusListeners();
    for(int i=0;i<flk.length;i++){
       if(flk[i] instanceof MyFocusListener)jtx.removeFocusListener(flk[i]);
    }
    */
    jtx.addFocusListener(myFksAdpt);
    jtx.setToolTipText(_klmVfy.formatPromptMsg());
    exgui.ultratable.KeyProcess keyeventprocessby= klmVfy.getKeyListener();
    if(keyeventprocessby!=null){
      keyeventprocessby.bind2TextComponent(jtx);
    }
    jtx.setCaretPosition(0);
  }
  public Object getSelectedValue(){
      return _klmVfy.cellStringToObject(
       ((javax.swing.text.JTextComponent)getGUIcomponent()).getText()
      );
  }
  public boolean isValidx(){
//       System.out.println(((javax.swing.JTextField)getGUIcomponent()).getText());
       return _klmVfy.isFormatValid(
         ((javax.swing.text.JTextComponent)getGUIcomponent()).getText()
         ,0,0
       );
  }

  class MyFocusListener extends FocusAdapter{
    protected javax.swing.text.JTextComponent myJtext;
    MyFocusListener(javax.swing.text.JTextComponent jtext){
      super();
      myJtext=jtext;
    }
    synchronized public void focusLost(FocusEvent e) {
      //System.out.println("lost focus event triggered");
      if (prcLostFocus) return;
      prcLostFocus = true;
      if (!isValidx()) {
        //System.out.println("get invailide condition.");
        exgui.verification.VerifyLib.showAllert(
               _klmVfy.formatPromptMsg()
            );
        javax.swing.SwingUtilities.invokeLater(
          new Runnable () {
            public void run() {
                  myJtext.grabFocus();
            }
          }
        );
        prcLostFocus = false;
        return ;
      }
      prcLostFocus=false;
    }
   }

}
