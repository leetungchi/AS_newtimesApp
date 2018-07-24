package exgui.ultratable;
import java.awt.event.KeyListener;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2002</p>
 * <p>Company: </p>
 * @author unascribed
 * @version 1.0
 */

public interface CellTxtEditorFormat {
   public int getMaxLength();
   public  boolean isFormatValid(String string2Varify,int checkingRow,int checkingColumn);
   public String formatPromptMsg();
   public Object cellStringToObject(String string2kvt);
   public KeyProcess getKeyListener();
}
