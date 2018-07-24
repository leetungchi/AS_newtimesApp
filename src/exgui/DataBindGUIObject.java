package exgui;

import javax.swing.JComponent;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2002</p>
 * <p>Company: </p>
 * @author unascribed
 * @version 1.0
 */

abstract public class DataBindGUIObject extends JComponent {
  protected String _match2RecField;
  /*
  public DataBindGUIObj(String match2RecField) {
    super();
    _match2RecField =match2RecField;
  }
  */
  public String getOrgRecField(){
   return _match2RecField;
  }
  abstract public boolean isChanged();
  abstract public JComponent getGUIcomponent();
}