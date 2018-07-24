package exgui.chaindialog;
import java.awt.*;
import javax.swing.*;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

abstract public class ChainedDialogBox extends JDialog implements ChainedDialogNotify{
  BorderLayout borderLayout1 = new BorderLayout();
  PnlChained pnlChained1 = new PnlChained();
  public final static int DIALOG_OK=1;
  public final static int DIALOG_CANCEL=2;
  public final static int DIALOG_ERROR=3;
  protected java.util.HashMap resultHashMap=null;
  int dialogStatus=-1;
  public ChainedDialogBox(Frame frame, String title, boolean modal,Responsible initResponsible) {
    super(frame, title, modal);
    try {
      jbInit();
      pack();
      //begin the dialog...
      pnlChained1.setNofityTo(this);
      pnlChained1.Init(initResponsible);
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }

  public ChainedDialogBox() {
    this(null, "", false,null);
  }
  protected void jbInit() throws Exception {
    this.getContentPane().setLayout(borderLayout1);
    this.getContentPane().add(pnlChained1,  BorderLayout.CENTER);
  }
  public abstract Object getDialogResult();
  public int getDialogStatus(){
    return dialogStatus;
  }
  public void notifyOK(){
     resultHashMap=pnlChained1.dialogInfos;
     this.dispose();
     dialogStatus=DIALOG_OK;
  }
  public void notifyCancel(){
     this.dispose();
     dialogStatus=DIALOG_CANCEL;
  }
}
