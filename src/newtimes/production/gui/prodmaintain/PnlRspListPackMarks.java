package newtimes.production.gui.prodmaintain;
import exgui.ultratable.*;
import database.datatype.Record;
import exgui.chaindialog.*;

public class PnlRspListPackMarks extends PnlRspListShipMarks {
  protected util.InsertionOrderedHashMap getHeadColumnMap(){
     util.InsertionOrderedHashMap iso=new util.InsertionOrderedHashMap();
     iso.put("REF No.","PACKING_PK");
     iso.put(" PACKING MARK CONTENT   ","PACKING_MARK");
     return iso;
  }
  public Responsible next()throws NextResponsibleIsNotReady{
      if(getJtable().getSelectedRow()==-1){
        exgui.verification.VerifyLib.showAlert("Please Select A Row","Please Select A Row");
        throw new NextResponsibleIsNotReady();
      }
      //PACKING_PK, PACKING_BYMKR_SEQ, PACKING_MARK
      Object mainMarkObj=targetRecord.get(2);
      String mainMark=(mainMarkObj==null)?" ":mainMarkObj.toString();//get main mark;
      nextRsp=new PnlRspShowMark(mainMark,null);
      return nextRsp;
  }

}
