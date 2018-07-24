package newtimes;

import javax.swing.*;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class LookAndFeel {
  private static javax.swing.LookAndFeel alloyLnF;
  private static com.incors.plaf.alloy.AlloyTheme glassTheme;
  private static javax.swing.LookAndFeel glassLnF;
  private static com.incors.plaf.alloy.AlloyTheme acidTheme;
  private static javax.swing.LookAndFeel acidLnF;
  private static com.incors.plaf.alloy.AlloyTheme bedouinTheme;
  private static javax.swing.LookAndFeel bedouinLnF;

  public LookAndFeel() {
  }

  public static void Alloy_LookAndFeel() {
    genLookAndFeel(0);
  }

  public static void Acid_LookAndFeel() {
    genLookAndFeel(1);
  }

  public static void Glass_LookAndFeel() {
    genLookAndFeel(2);
  }

  public static void Bedouin_LookAndFeel() {
    genLookAndFeel(3);
  }

  private static void genLookAndFeel(int i) {
    try {
      com.incors.plaf.alloy.AlloyLookAndFeel.setProperty("alloy.isLookAndFeelFrameDecoration", "true");
      switch(i) {
        case 0 :
          alloyLnF = new com.incors.plaf.alloy.AlloyLookAndFeel();
          UIManager.installLookAndFeel("Alloy", "com.incors.plaf.alloy.AlloyLookAndFeel");
          UIManager.setLookAndFeel(alloyLnF);
          break;
        case 1 :
          acidTheme = new com.incors.plaf.alloy.themes.acid.AcidTheme();
          acidLnF = new com.incors.plaf.alloy.AlloyLookAndFeel(acidTheme);
          UIManager.installLookAndFeel("Acid", "com.incors.plaf.alloy.AlloyLookAndFeel");
          UIManager.setLookAndFeel(acidLnF);
          break;
        case 2 :
          glassTheme = new com.incors.plaf.alloy.themes.glass.GlassTheme();
          glassLnF = new com.incors.plaf.alloy.AlloyLookAndFeel(glassTheme);
          UIManager.installLookAndFeel("Glass", "com.incors.plaf.alloy.AlloyLookAndFeel");
          UIManager.setLookAndFeel(glassLnF);
          break;
        case 3 :
          bedouinTheme = new com.incors.plaf.alloy.themes.acid.AcidTheme();
          bedouinLnF = new com.incors.plaf.alloy.AlloyLookAndFeel(bedouinTheme);
          UIManager.installLookAndFeel("Bedouin", "com.incors.plaf.alloy.AlloyLookAndFeel");
          UIManager.setLookAndFeel(bedouinLnF);
          break;
      }
    } catch(Exception lnf) {
      lnf.printStackTrace();
    } finally {
      com.incors.plaf.alloy.AlloyLookAndFeel.updateAllUIs();
    }
  }




}