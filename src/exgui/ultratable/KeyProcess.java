package exgui.ultratable;

import java.awt.event.KeyListener;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public interface KeyProcess extends KeyListener {
  public void bind2TextComponent(javax.swing.text.JTextComponent comp);
}
