package newtimes.material;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class UI_History {
  public static final int MENU      = 1;
  public static final int SEARCH    = 2;
  public static final int HEAD_LIST = 3;
  public static final int HEAD_EDIT = 4;
  public static final int HEAD_NEW  = 5;
  public static final int DTL_LIST  = 6;
  public static final int DTL_EDIT  = 7;
  public static final int DTL_NEW   = 8;
  public static final int RESTORE   = 9;
  public static final int RE_HEAD_LIST = 10;
  public static final int ERROR     = -1;
  public static final int UNKNOWN   = 0;

  private final newtimes.material.CONST.MTR.APP.SEARCH MTR_SEARCH = null;

  private java.util.Vector hist = null;
  UI_History() {
    hist = new java.util.Vector();
  }
  void insertState(final int currState, Object target){
    hist.add(new entry(currState, target));
  }

  void prevState(){
    entry prev = pop();
    if(prev.target instanceof newtimes.Frame1){
      newtimes.Frame1 currFrame = (newtimes.Frame1)prev.target;
      java.awt.Cursor tCur = currFrame.getCursor();
      currFrame.setCursor(new java.awt.Cursor(java.awt.Cursor.WAIT_CURSOR));
      switch (prev.state) {
        case MENU:
          currFrame.showPanel(new MaterialMenu(currFrame));
          break;
        case SEARCH:
          currFrame.showPanel(new MaterialSearch(currFrame, MTR_SEARCH.EXISTING));
          break;
        case HEAD_LIST:
          currFrame.showPanel(new MaterialList(currFrame, MTR_SEARCH.MTR_HEAD_LIST));
          break;
        case HEAD_NEW:
          currFrame.showPanel(new MaterialList(currFrame, MTR_SEARCH.MTR_NEW_REC));
          break;
        case RESTORE:
          currFrame.showPanel(new MaterialSearch(currFrame, MTR_SEARCH.DELETED));
          break;
        case RE_HEAD_LIST:
          currFrame.showPanel(new MaterialList(currFrame, MTR_SEARCH.DEL_MTR_HEAD_LIST));
        default:
      }
      currFrame.setCursor(tCur);
    }
    else if(prev.target instanceof MaterialList){
      MaterialList currPanel = (MaterialList)prev.target;
      java.awt.Cursor tCur = currPanel.getCursor();
      currPanel.setCursor(new java.awt.Cursor(java.awt.Cursor.WAIT_CURSOR));
      switch(prev.state){
        case DTL_LIST:
          currPanel.showMaterialDtlHistList();
          break;
        case HEAD_EDIT:
        default:

      }
      currPanel.setCursor(tCur);
    }

  }

  private entry pop(){
    int size = hist.size();
    if(size>0){
      return (entry)(hist.remove(size-1));
    }
    else{
      return null;
    }
  }

  private class entry{
    int state = UNKNOWN;
    Object target  =null;
    entry(int state, Object target){
      this.state = state;
      this.target = target;
    }
  }

}