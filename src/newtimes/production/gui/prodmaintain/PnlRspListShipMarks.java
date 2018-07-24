package newtimes.production.gui.prodmaintain;
import exgui.ultratable.*;
import database.datatype.Record;
import exgui.chaindialog.*;
public class PnlRspListShipMarks extends exgui.ultratable.AbstractUltraTablePanel
  implements exgui.chaindialog.Responsible {
  public static int StartPosition;
  Responsible nextRsp;
  Record targetRecord;
public PnlRspListShipMarks(){
  _rowPosition=StartPosition;
  getJtable().addMouseListener(new tblListen());
  goPage(_rowPosition,10);
}
class tblListen extends java.awt.event.MouseAdapter{
  public void mouseClicked(java.awt.event.MouseEvent me){
    if(getJtable().getSelectedRow()<0)return;
    targetRecord=(Record)getDisplayingRecords().get(getJtable().getSelectedRow());
  }
}
public javax.swing.JComponent getGUI(){
  return this;
}
public void setDefalutNext(Responsible dfltRsp){
  nextRsp=dfltRsp;
}
public Responsible next()throws NextResponsibleIsNotReady{
    if(getJtable().getSelectedRow()==-1){
      exgui.verification.VerifyLib.showAlert("Please Select A Row","Please Select A Row");
      throw new NextResponsibleIsNotReady();
    }
    //SHIPMARK_PK, SHIPMARK_BYMKR_SEQ, SHIPMARK_MAIN_MARK, SHIPMARK_SIDE_MARK
    Object mainMarkObj=targetRecord.get(2);
    Object shidMarkObj=targetRecord.get(3);
    String mainMark=(mainMarkObj==null)?" ":mainMarkObj.toString();//get main mark;
    String sideMark=(shidMarkObj==null)?" ":shidMarkObj.toString();//get main mark;
    nextRsp=new PnlRspShowMark(mainMark,sideMark);
    return nextRsp;
}
public boolean isAllowOkNow(){return false;}

 protected  void refineEditors(MultiEditorJTable multiEditorJTableInSuper){
 }
  protected Record setObject2Record(Record rec,int columnAt,Object value2update){
    return null;
  }
  //force child to implement following methods.
  protected PagedDataFactory getPagedDataFactory(){
    return new Data2Gen();
  }
  protected util.InsertionOrderedHashMap getHeadColumnMap(){
    //SHIPMARK_PK, SHIPMARK_MAIN_MARK, SHIPMARK_SIDE_MARK
     util.InsertionOrderedHashMap iso=new util.InsertionOrderedHashMap();
     iso.put("REF No.","SHIPMARK_PK");
     iso.put(" Main Mark    ","SHIPMARK_MAIN_MARK");
     iso.put(" Side Mark    ","SHIPMARK_SIDE_MARK");
     return iso;
  }
  protected java.util.Hashtable getObject2StringConvertor(){
    return null;
  }
  protected int getEachPageRowCount(){
    return 10;
  }
 class Data2Gen extends exgui.ultratable.PagedDataFactoryAdapter{
   int buyerMakerSeq;
   public java.util.Vector getRecords(int bgn,int rowcount)throws Exception{
     String sql=(String)storedMap.get(PnlRspInit4ShipPackMark.KEY_SQL_TO_SEARCH_REMARK);
     return exgui2.CONST.BASIC_MAIN_EJB.getDatas(
        util.PublicVariable.USER_RECORD,
        sql,bgn,rowcount
      );
   }
 }
}
