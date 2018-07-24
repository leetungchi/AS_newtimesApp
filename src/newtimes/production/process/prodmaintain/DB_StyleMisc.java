package newtimes.production.process.prodmaintain;
import exgui.ultratable.PagedDataFactoryAdapter;
import java.util.HashMap;
import java.util.Vector;
import database.datatype.Record;
public class DB_StyleMisc extends PagedDataFactoryAdapter {
  protected HashMap buyerMakers=null;
  boolean isInitOk;
  public DB_StyleMisc() {
    try{
      newtimesejb.production.StyleMiscFacadeHome ejbHome=
        (newtimesejb.production.StyleMiscFacadeHome)
        info_ejb.WeblogicServiceLocator.locateServiceHome(
           util.PublicVariable.SERVER_URL,
           "newtimesejb.production.StyleMiscFacade"
          );
       this.ejb=ejbHome.create();
       isInitOk=true;
    }catch(Exception e){
      e.printStackTrace();
      exgui.verification.VerifyLib.showAlert(
          "Server Side Error\nPlease Notify System Manager",
          "EJB Creation ERROR");
      isInitOk=false;
    }
  }
  public boolean isInitOK(){return isInitOk;}
  public Vector getWashMiller() throws Exception {
    Vector vct = ( (newtimesejb.production.StyleMiscFacade) ejb).getBuyerMakers(
        newtimesejb.production.StyleMiscFacade.BUYER_TYPE_WISH_MILL);
    return vct;
  }
  public Vector getRecords(int bgn,int rowcount)throws Exception{
    HashMap hm=new HashMap();
    hm.put("PROD_HEAD_PK",String.valueOf(newtimes.preproduction.Constants.CURRENT_PREPROD_HEAD_PK));
    return    ejb.getRecords(bgn,rowcount,hm);
  }
  public Vector getFabricMiller()throws Exception{
    if(buyerMakers==null){
      buyerMakers=((newtimesejb.production.StyleMiscFacade)ejb).getBuyerMakers4Othes();
    }
    Vector vct=(Vector)buyerMakers.get(
        newtimesejb.production.StyleMiscFacade.BUYER_TYPE_MILL);
    return vct;
  }
  public Vector getForwarder()throws Exception{
    if(buyerMakers==null){
      buyerMakers=((newtimesejb.production.StyleMiscFacade)ejb).getBuyerMakers4Othes();
    }
    Vector vct=(Vector)buyerMakers.get(
        newtimesejb.production.StyleMiscFacade.BUYER_TYPE_EXP_FWD);
    return vct;
  }
  public Vector getBiller()throws Exception{
    if(buyerMakers==null){
      buyerMakers=((newtimesejb.production.StyleMiscFacade)ejb).getBuyerMakers4Othes();
    }
    Vector vct=(Vector)buyerMakers.get(newtimesejb.production.StyleMiscFacade.BUYER_TYPE_BILL_TO);
    return vct;
  }
 public void uploadImage(int stySeq,String userId,String filePath)throws Exception{
   String fileExtention[]=util.MiscFunc.split(filePath,".");
   java.io.File uploadFile=new java.io.File(filePath);
   java.io.BufferedInputStream bis=new
    java.io.BufferedInputStream(
      new java.io.FileInputStream(uploadFile)
    );
    byte data2output[]=new byte[bis.available()];
    bis.read(data2output);
    bis.close();
    ((newtimesejb.production.StyleMiscFacade)ejb).uploadImage(stySeq,
     userId,fileExtention[fileExtention.length-1],data2output);
 }
 public javax.swing.Icon getImage(int stySeq)throws Exception{
   byte[] imgdata=((newtimesejb.production.StyleMiscFacade)ejb).getImage(stySeq);
   javax.swing.ImageIcon imgIcon=
       new javax.swing.ImageIcon(imgdata);
   return imgIcon;
 }
 public void updateRecordsForLog(Vector vct,String[] fields)throws Exception{
     if(vct==null || vct.size()==0)return;
     if(fields==null || fields.length==0)return;
      newtimesejb.TPE_MIS.TpeMisFuncHome ejbTpeMisHome=
          (newtimesejb.TPE_MIS.TpeMisFuncHome)
          info_ejb.WeblogicServiceLocator.locateServiceHome(util.PublicVariable.SERVER_URL,
                                                              "newtimesejb.TPE_MIS.TpeMisFunc");
    newtimesejb.TPE_MIS.TpeMisFunc ejbTpeMis=ejbTpeMisHome.create();
    java.util.HashMap hmPara=new java.util.HashMap();
    hmPara.put("TPEMISCFUNC_ACTION_CODE","ASHWORTH_STYLE_MODIFY_LOG");
    hmPara.put("user_code",util.PublicVariable.USER_RECORD.get(0));
    hmPara.put("STYLE_VCT",vct);
    hmPara.put("FIELD_NAMES",fields);
    ejbTpeMis.tpeMisFunc(hmPara);
 }
 public Vector getSewingShops()throws Exception{
   Vector vct=((newtimesejb.production.StyleMiscFacade)ejb).getBuyerMakers("5");
   return vct;
 }
}
