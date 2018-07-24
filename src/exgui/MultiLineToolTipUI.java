/*
 * Author: Albert L. M. Ting <alt@artisan.com>
 *
 * Released into the public domain.
 *
 * $Revision: 1.24 $
 * $Id: MultiLineToolTipUI.java,v 1.24 1999/01/27 17:39:15 alt Exp $
 */

package exgui;

import java.awt.*;
import java.awt.event.*;
import java.util.*;

import javax.swing.*;
import javax.swing.plaf.ToolTipUI;
import javax.swing.plaf.ComponentUI;

/**
 * To add multiline tooltip support to your swing applications, just add this
 * static call to your main method.  Note, you only need to do this once, even
 * if you change LookAndFeel as the UIManager knows not to overwrite the user
 * defaults.  Moreover, it uses the current L&F foreground/background colors
 * <p><pre>
 *        MultiLineToolTipUI.initialize();
 * </pre><p>
 * @author Albert L. M. Ting
 */
public class MultiLineToolTipUI extends ToolTipUI {
  static MultiLineToolTipUI SINGLETON = new MultiLineToolTipUI();
  static boolean DISPLAY_ACCELERATOR=true;

  int m_inset = 3;
  int m_accelerator_offset = 15;

  private MultiLineToolTipUI() {
  }

  public static void initialize() {
    // don't hardcode the class name, fetch it dynamically.  This way we can
    // obfuscate.
    String key = "ToolTipUI";
    Class cls = SINGLETON.getClass();
    String name = cls.getName();
    UIManager.put(key,name);
    UIManager.put(name,cls);	// needed for 1.2
  }

  public static ComponentUI createUI(JComponent c) {
    return SINGLETON;
  }

  public void installUI(JComponent c) {
    LookAndFeel.installColorsAndFont(c,
				     "ToolTip.background",
				     "ToolTip.foreground",
				     "ToolTip.font");
    LookAndFeel.installBorder(c, "ToolTip.border");
  }

  public void uninstallUI(JComponent c) {
    LookAndFeel.uninstallBorder(c);
  }

  public static void setDisplayAcceleratorKey(boolean val) {
    DISPLAY_ACCELERATOR=val;
  }

  public Dimension getPreferredSize(JComponent c) {
    Font font = c.getFont();
    FontMetrics fontMetrics = Toolkit.getDefaultToolkit().getFontMetrics(font);
    int fontHeight = fontMetrics.getHeight();
    String tipText = ((JToolTip)c).getTipText();

    if (tipText == null) tipText = "";

    String lines[] = PlafMacros.breakupLines(tipText);
    int num_lines = lines.length;
    Dimension dimension;
    int width,height,onewidth;

    height = num_lines * fontHeight;
    width = 0;
    for (int i=0; i<num_lines; i++) {
      onewidth = fontMetrics.stringWidth(lines[i]);
      if (DISPLAY_ACCELERATOR && i == num_lines - 1) {
	String keyText = getAcceleratorString((JToolTip)c);
	if (!keyText.equals("")) {
	  onewidth += fontMetrics.stringWidth(keyText) + m_accelerator_offset;
	}
      }
      width = Math.max(width,onewidth);
    }
    return new Dimension(width+m_inset*2,height+m_inset*2);
  }

  public Dimension getMinimumSize(JComponent c) {
    return getPreferredSize(c);
  }

  public Dimension getMaximumSize(JComponent c) {
    return getPreferredSize(c);
  }

  public void paint(Graphics g, JComponent c) {
    Font font = c.getFont();
    FontMetrics fontMetrics =
      Toolkit.getDefaultToolkit().getFontMetrics(font);
    Dimension dimension = c.getSize();
    int fontHeight = fontMetrics.getHeight();
    int fontAscent = fontMetrics.getAscent();
    String tipText = ((JToolTip)c).getTipText();
    String lines[] = PlafMacros.breakupLines(tipText);
    int num_lines = lines.length;
    int height;
    int i;

    g.setColor(c.getBackground());
    g.fillRect(0, 0, dimension.width, dimension.height);
    g.setColor(c.getForeground());
    for (i=0, height=2+fontAscent; i<num_lines; i++, height+=fontHeight) {
      g.drawString(lines[i], m_inset, height);
      if (DISPLAY_ACCELERATOR && i == num_lines - 1) {
	String keyText = getAcceleratorString((JToolTip)c);
	if (!keyText.equals("")) {
	  Font smallFont =
	    new Font(font.getName(), font.getStyle(), font.getSize() - 2 );
	  g.setFont(smallFont);
	  g.drawString(keyText,
		       fontMetrics.stringWidth(lines[i])+m_accelerator_offset,
		       height);
	}
      }
    }
  }

  public String getAcceleratorString(JToolTip tip) {
    JComponent comp = tip.getComponent();
    if (comp == null) {
      return "";
    }
    KeyStroke[] keys =comp.getRegisteredKeyStrokes();
    String controlKeyStr = "";
    KeyStroke postTip = KeyStroke.getKeyStroke(KeyEvent.VK_F1,Event.CTRL_MASK);

    for (int i = 0; i < keys.length; i++) {
      if (postTip.equals(keys[i])) {
	// ignore, associated with ToolTipManager postTip action, in
	// swing1.1beta3 and onward
	continue;
      }
      char c = (char)keys[i].getKeyCode();
      int mod = keys[i].getModifiers();
      if ( mod == InputEvent.CTRL_MASK ) {
	controlKeyStr = "Ctrl+"+(char)keys[i].getKeyCode();
	break;
      } else if (mod == InputEvent.ALT_MASK) {
	controlKeyStr = "Alt+"+(char)keys[i].getKeyCode();
	break;
      }
    }
    return controlKeyStr;
  }
}

