package newtimes.production;

import javax.swing.UIManager;
import java.awt.*;
import java.util.*;
/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class ApplicationTest {
  boolean packFrame = false;

  //Construct the application
  public ApplicationTest() {
    FrameTest frame = new FrameTest();
    //Validate frames that have preset sizes
    //Pack frames that have useful preferred size info, e.g. from their layout
    if (packFrame) {
      frame.pack();
    }
    else {
      frame.validate();
    }
    //Center the window
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    Dimension frameSize = frame.getSize();
    if (frameSize.height > screenSize.height) {
      frameSize.height = screenSize.height;
    }
    if (frameSize.width > screenSize.width) {
      frameSize.width = screenSize.width;
    }
    frame.setLocation((screenSize.width - frameSize.width) / 2, (screenSize.height - frameSize.height) / 2);
    frame.setVisible(true);
  }
  //Main method
  public static void main(String[] args) {
   java.util.HashMap
       DozeToDecMapping=new HashMap();
    DozeToDecMapping.put("1", "08");
    DozeToDecMapping.put("2", "16");
    DozeToDecMapping.put("3", "25");
    DozeToDecMapping.put("4", "33");
    DozeToDecMapping.put("5", "41");
    DozeToDecMapping.put("6", "50");
    DozeToDecMapping.put("7", "58");
    DozeToDecMapping.put("8", "66");
    DozeToDecMapping.put("9", "75");
    DozeToDecMapping.put("10", "83");
    DozeToDecMapping.put("11", "91");
    DozeToDecMapping.put("0", "0");

   java.util.HashMap  DecToDozeMapping=new HashMap();
    DecToDozeMapping.put("08","1");
    DecToDozeMapping.put("16","2");
    DecToDozeMapping.put("25","3");
    DecToDozeMapping.put("33","4");
    DecToDozeMapping.put("41","5");
    DecToDozeMapping.put("50","6");
    DecToDozeMapping.put("58","7");
    DecToDozeMapping.put("66","8");
    DecToDozeMapping.put("75","9");
    DecToDozeMapping.put("83","10");
    DecToDozeMapping.put("91","11");
    DecToDozeMapping.put("00", "0");

    newtimes.production.process.prodmaintain.DB_ColorSizeQtyHandler.DozeToDecMapping=DozeToDecMapping;
    newtimes.production.process.prodmaintain.DB_ColorSizeQtyHandler.DecToDozeMapping=DecToDozeMapping;
    System.out.println("100.00-1.08="+
                       newtimes.production.process.prodmaintain.DB_ColorSizeQtyHandler.
                       minusDzValue((float)100,(float)1.08));




    try {
      UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
      util.PublicVariable.SERVER_URL="127.0.0.1";
      util.ExceptionLog.setLogPath("c:\\testOfSinglten.log");
    }
    catch(Exception e) {
      e.printStackTrace();
    }

    new ApplicationTest();
  }
}