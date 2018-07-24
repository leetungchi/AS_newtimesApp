package newtimes.production.gui.prodmaintain;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class PnlStyleList4AshWorth extends PnlStyleList {
  public PnlStyleList4AshWorth() {
  }
  public void refineEditors(exgui.ultratable.MultiEditorJTable mt){
    super.refineEditors(mt);
    ((exgui.MultiClassTableModel)mt.getJTable().getModel()).setCellEditablePolicy(new AshworthEditPolicy());
  }
  public class AshworthEditPolicy implements  exgui.CellEditablePolicy {
    public boolean isCellEditable(int row,int col){
      if(col>=STY_YY1_AT)return true;
      return false;
    }
  }
}
