package exgui2;

import javax.swing.*;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class GotoTarget {
  public static JPanel GoBack = null;
  private static java.util.LinkedList history = new java.util.LinkedList();

  public GotoTarget() {
  }

  public static void setGoBack(JPanel previousPanel) {
    GoBack = previousPanel;
  }

  public static void setGoHistory(JPanel thisPanel) {
    history.add(thisPanel);
  }

  public static java.util.LinkedList getGoHistory() {
    return history;
  }

  public static JPanel getPreviousPanel() {
    int i = history.size();
    JPanel prevPnl = null;
    if (i > 1)
      prevPnl = (JPanel)history.get(i - 2);
    return prevPnl;
  }

  public static JPanel remove(int i) {
    return (JPanel)history.remove(i);
  }

  public static java.util.LinkedList removeAllHistroy() {
    return new java.util.LinkedList();
  }

  public static JPanel removeLast() {
    return (JPanel)history.removeLast();
  }

  public static JPanel get(int i) {
    return (JPanel)history.get(i);
  }

  public static JPanel getFirst() {
    return (JPanel)history.getFirst();
  }

  public static JPanel getLast() {
    return (JPanel)history.getLast();
  }

}
