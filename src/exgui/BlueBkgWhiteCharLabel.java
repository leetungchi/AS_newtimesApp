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

public class BlueBkgWhiteCharLabel extends JLabel {
  public BlueBkgWhiteCharLabel() {
     super();
     setMyColor();
  }
  public BlueBkgWhiteCharLabel(String title){
    super(title);
    setMyColor();
  }
  protected void setMyColor(){
    setBackground(new Color(143, 143, 188));
    setFont(new java.awt.Font("Dialog", 1, 12));
    setForeground(Color.white);
    setOpaque(true);
    setHorizontalAlignment(SwingConstants.CENTER);
  }
}