package exgui;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JLabel;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class WhiteBkgBlueCharLabel extends BlueBkgWhiteCharLabel {
  public WhiteBkgBlueCharLabel() {
    super();
  }
  public WhiteBkgBlueCharLabel(String title) {
     super(title);
  }
  protected void setMyColor(){
    setBackground(Color.white);
    setFont(new java.awt.Font("Dialog", 1, 12));
    setForeground(new Color(143, 143, 188));
    setOpaque(true);
    setHorizontalAlignment(SwingConstants.CENTER);
  }
}