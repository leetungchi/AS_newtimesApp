package newtimes.material;

import processhandler.template.PnlListQryRslt;
import exgui.ultratable.PagedDataFactory;
import java.util.HashMap;
/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class PnlMtlDtlListWithButton extends PnlListQryRslt {
  PagedDataFactory myHander=null;
  private static String TT_MillName    = " Mill Name";
  private static String TT_Mill_MTR_NO = " Mill\nMTR-NO";
  private static String TT_USD         = "USD";
  private static String TT_Local       = "Local";
  private static String TT_DupsMIN     = "DUPS\nMINQTY";
  private static String TT_DupsLEAD    = "DUPS\nLeadtime\n(days)";
  private static String TT_BulkMIN     = "BULK\nMINQTY";
  private static String TT_BulkLEAD    = "BULK\nLeadtime\n(days)";
  private newtimes.material.CONST.MTRDTL.APP.LIST MTRDTL_LIST= null;
  private newtimes.material.CONST.MTRDTL.EJB MTRDTL_EJB=null;
  private newtimes.material.CONST.COMMON COMMON=null;
  static int hmNull = 0;
  public PnlMtlDtlListWithButton(){
    HashMap hm = (HashMap)util.ApplicationProperites.getProperties(MTRDTL_LIST.CONDITIONS);
    hmNull = hm == null ? 1 : 2;
    MtrDtlDataFactory mtrDtlDataSrc = new MtrDtlDataFactory(hm);
    mtrDtlDataSrc = mtrDtlDataSrc;
    util.InsertionOrderedHashMap iso=new util.InsertionOrderedHashMap();

    util.InsertionOrderedHashMap headHm = new util.InsertionOrderedHashMap();
    headHm.put(TT_MillName,    MTRDTL_EJB.BYMKR_BRIEF);//modified by Chloe
    headHm.put(TT_Mill_MTR_NO, MTRDTL_EJB.MILL_NO);
    headHm.put(TT_USD,         MTRDTL_EJB.PRX_USD);
    headHm.put(TT_Local,       MTRDTL_EJB.PRX_LOCAL);
    headHm.put(TT_DupsMIN,     MTRDTL_EJB.DUPS_MINQTY);
    headHm.put(TT_DupsLEAD,    MTRDTL_EJB.DUPS_LEADTIME);
    headHm.put(TT_BulkMIN,     MTRDTL_EJB.BULK_MINQTY);
    headHm.put(TT_BulkLEAD,    MTRDTL_EJB.BULK_LEADTIME);
    pgTblList=
          new processhandler.template.PagedListTable4Qry(
            mtrDtlDataSrc,
            10,
            headHm,
            new java.util.Hashtable(),
            "History"," . . . ");
        setLayout(new java.awt.BorderLayout());
        setBackground(new java.awt.Color(204,204,225));
        setPagedTable();
        pgTblList.setGotopageNotifyer(this);
  }
  public java.util.Vector   getDisplayingRecords(){
    return pgTblList.getDisplayingRecords();
  }
  public javax.swing.JTable getJtable(){return pgTblList.getJtable();}
  public void goPage(int _rowPosition,int _rowCounts,boolean chk){
    pgTblList._rowPosition=_rowPosition ;
    pgTblList._rowCounts=_rowCounts;
    pgTblList.reload();
    //pgTblList.gotoRowPosition(_rowPosition);
  }
 public void nextPage(){
   pgTblList._rowPosition+=pgTblList._rowCounts;
   goPage(pgTblList._rowPosition,pgTblList._rowCounts,false);
 }
   public void gridTableMouseEventHandler(java.awt.event.MouseEvent e){

   }
  public PnlMtlDtlListWithButton(PagedDataFactory pagedDataFxy,
        int rowCount,util.InsertionOrderedHashMap columnMapping,
        java.util.Hashtable object2StringConvertor,
        String columnTitle,String buttonTitle
    ){
     super(pagedDataFxy,rowCount,columnMapping,object2StringConvertor,
           columnTitle,buttonTitle);
     myHander=pagedDataFxy;

     this.removeAll();
     //this.add(new JLabel("Please click the rows"),BorderLayout.NORTH);
     this.add(this.pgTblList,null);
     //this.pgTblList.firstPage();
  }


}
