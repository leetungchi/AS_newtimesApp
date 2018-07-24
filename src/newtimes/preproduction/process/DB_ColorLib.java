package newtimes.preproduction.process;
import database.datatype.Record;
import java.util.*;
/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class DB_ColorLib extends exgui.ultratable.PagedDataFactoryAdapter {
  public static int CURRENT_PREPROD_SEQ;
  static DB_ColorLib me;
  newtimesejb.preproduction.ColorLibFacade myEJB;
  java.util.Vector unJoinedRecords=null;
  public static Record editingClibRecord;
  protected Vector mtrldtlGrp2Search;
  protected String inMtrldtlGrp2SearchString;
  private DB_ColorLib(){
    try{
     newtimesejb.preproduction.ColorLibFacadeHome ejbHome=
        (newtimesejb.preproduction.ColorLibFacadeHome)
         info_ejb.WeblogicServiceLocator.locateServiceHome(
           util.PublicVariable.SERVER_URL,"newtimesejb.preproduction.ColorLibFacade"
         );
      myEJB=ejbHome.create();
      blankRecord=myEJB.getBlankRecord();
      super.ejb=myEJB;
    }catch(Exception e){
      e.printStackTrace();
      exgui.verification.VerifyLib.showAlert("Server Connection Fail","Server Connection Fail");
    }
  }
  public static DB_ColorLib getInstance(){
    if(me==null){
      me=new DB_ColorLib();
    }
    return me;
  }
  public Vector getUnJoinedRecords(){
    return unJoinedRecords;
  }
  public Record getBlankRecord()throws Exception{
    Record rec=super.getBlankRecord();
    //rec.set("CLIB_PROD_HEAD_PK",XNT_EDITING_PREPROD_SEQ);
    return rec;
  }
  public void setTargetMtrlDtls(Vector vct){
    mtrldtlGrp2Search=vct;
    StringBuffer sb=new StringBuffer();
    for(int i=0;i<mtrldtlGrp2Search.size();i++){
      Record rec=(Record)mtrldtlGrp2Search.get(i);
      sb.append(rec.getInt(0));
      if(i<mtrldtlGrp2Search.size()-1)sb.append(",");
    }
    inMtrldtlGrp2SearchString=sb.toString();
  }
  public java.util.Vector getRecords(int bgn,int rowCount) throws Exception{
    System.out.println("inMtrldtlGrp2SearchString is "+inMtrldtlGrp2SearchString);
    return myEJB.getMtrlDefinedColorLib(inMtrldtlGrp2SearchString,bgn,rowCount);
  }
}