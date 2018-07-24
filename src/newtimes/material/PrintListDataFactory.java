package newtimes.material;

import exgui.ultratable.PagedDataFactory;
import java.util.Vector;
import database.datatype.Record;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class PrintListDataFactory implements PagedDataFactory {

  private MaterialMdlEJBs.StickerEJB.StickerData stickerEJB=
      (MaterialMdlEJBs.StickerEJB.StickerData)util.ApplicationProperites.getProperties("materialStickerEJB");
  private java.util.HashMap condition = null;
  public PrintListDataFactory(java.util.HashMap hm) {
    condition = hm;
  }
  public Vector getRecords(int startPosition, int rowCounts) throws Exception {
    java.util.HashMap clonedHm=(java.util.HashMap)util.MiscFunc.deepCopy(condition);
    if(clonedHm.get("attachedInMtrNoList")!=null){
      String storedOtherMtrList=(String)clonedHm.get("attachedInMtrNoList");
      String[] mtrNoList=util.MiscFunc.split(storedOtherMtrList,",");
      StringBuffer sb=new StringBuffer();
      for(int i=0;i<mtrNoList.length;i++){
        if(sb.length()>0)sb.append(",");
        sb.append("'");
        sb.append(mtrNoList[i]);
        sb.append("'");
      }
      clonedHm.put("attachedInMtrNoList",sb.toString());
    }

    return stickerEJB.getRecords(startPosition, rowCounts, clonedHm);
  }
  public void deleteRecord(Record rec2delete) throws Exception {
    //Do Nothing
  }
  public void restoreRecord(Record rec2restore) throws Exception {
    //Do Nothing
  }
  public Record addRecord(Record rec2add) throws Exception {
    /**@todo Implement this exgui.ultratable.PagedDataFactory method*/
    throw new java.lang.UnsupportedOperationException("Method addRecord() not yet implemented.");
  }
  public Record getBlankRecord() throws Exception {
    /**@todo Implement this exgui.ultratable.PagedDataFactory method*/
    throw new java.lang.UnsupportedOperationException("Method getBlankRecord() not yet implemented.");
  }
  public void updateRecords(Vector recs2update) throws Exception {
    //Do Nothing
  }
  public boolean listforRestore() {
    /**@todo Implement this exgui.ultratable.PagedDataFactory method*/
    throw new java.lang.UnsupportedOperationException("Method listforRestore() not yet implemented.");
  }

}
