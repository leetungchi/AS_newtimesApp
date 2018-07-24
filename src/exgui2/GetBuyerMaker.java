package exgui2;

import java.util.Vector;
import java.awt.event.*;
import java.awt.Cursor;
/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class GetBuyerMaker extends DialogFactory {
  private BasicMdlEJBs.BasicMaintainEJB.BasicMaintainEJB basicMainEJB =
    (BasicMdlEJBs.BasicMaintainEJB.BasicMaintainEJB)util.ApplicationProperites.getProperties("basicMainEJB");
  private int type = 0;

  /**
   * Definition values for buyer maker type.
   *
   *  Values    Buyer Maker Type
   * ===========================
   *     1      Buyer
   *     2      Maker
   *     3      Fabric Mill
   *     4      Wash Mill
   *     5      Sewing Shop
   *     6      Licensee
   *     7      Shipping
   *     8      Others
   * ===========================
   */
  public GetBuyerMaker(int _type) {
    type = _type;
  }
  public Vector setDB2ListItems() {
    java.util.Vector vData = new java.util.Vector();
    try {
      if (getFirstLetter != null) {
        if (getFirstLetter.equals("All")) {
          vData = basicMainEJB.getBuyerMakerAllByType(
              "BYMKR_SEQ,BYMKR_BRIEF", "BYMKR_BRIEF", type);
        } else {
          vData = basicMainEJB.getBuyerMakerByFirstLetter(
              getFirstLetter.toString(), "BYMKR_SEQ,BYMKR_BRIEF", String.valueOf(type));
        }

      }
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      return vData;
    }
  }
  public int setBuyerMakerType() {
    return type;
  }
 protected void btnSearch_actionPerformed(ActionEvent e) {
   try{
     if(txt1stTwnChar.getText().trim().length()==0){
       exgui.verification.VerifyLib.showPlanMsg(
      "Please Input A Character","Please Input A Character");
       return;
     }
     setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
     Vector vData = basicMainEJB.getBuyerMakerByFirstLetter(
         txt1stTwnChar.getText(), "BYMKR_SEQ,BYMKR_BRIEF",
         String.valueOf(type));
    this._count = 0;
    java.util.Vector vDB = vData;
    java.util.Vector vBrief = new java.util.Vector();
      vCode.clear();
      listItems.removeAll();
      for (int i = 0; i < vDB.size(); i++) {
        recDB = (database.datatype.Record)vDB.get(i);
        if (exgui2.PopAndSelect2Text._showField != null &&
            exgui2.PopAndSelect2Text._pkField != null) {
          vBrief.add(recDB.get(exgui2.PopAndSelect2Text._showField));
          vCode.add(recDB.get(exgui2.PopAndSelect2Text._pkField));
        }
      }
      listItems.setListData(vBrief);
   }catch(Exception exp){
     exp.printStackTrace();
   }finally{
     setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
   }
 }
}
