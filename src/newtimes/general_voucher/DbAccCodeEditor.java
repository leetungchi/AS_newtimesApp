package newtimes.general_voucher;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class DbAccCodeEditor extends exgui.ultratable.DataBindComboboxTable{

  public DbAccCodeEditor() {
     super();
  }

  protected void txtInput_keyReleased(java.awt.event.KeyEvent e){
    if(txtInput.getText().trim().length()>4){
        popout.setVisible(false);
        e.consume();
      return;
    }
    super.txtInput_keyReleased(e);
  }
  public processhandler.template.PnlTableEditor getPnlList(){
    return super.pnl;
  }

}
