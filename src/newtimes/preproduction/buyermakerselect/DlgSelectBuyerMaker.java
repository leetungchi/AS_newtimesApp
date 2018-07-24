package newtimes.preproduction.buyermakerselect;

import java.awt.*;
import javax.swing.*;
import exgui.chaindialog.*;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class DlgSelectBuyerMaker extends ChainedDialogBox{
  public DlgSelectBuyerMaker(Frame frame,String title,boolean modal,Responsible initRsp){
    super(frame,title,modal,initRsp);
    initRsp.storedMap.put(Kies.KEY_DLG_OBJ,this);
  }
  public Object getDialogResult(){
    return resultHashMap;
  }
}