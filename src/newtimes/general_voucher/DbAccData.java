package newtimes.general_voucher;
import database.datatype.Record;
import java.util.*;
public  class DbAccData   extends exgui.ultratable.PagedDataFactoryAdapter{
    newtimesejb.GnVoucher.GnVoucherFacade ejb2update;
   public DbAccData(){
      try {
        newtimesejb.GnVoucher.GnVoucherFacadeHome ejbHome=
            (newtimesejb.GnVoucher.GnVoucherFacadeHome)
            info_ejb.WeblogicServiceLocator.locateServiceHome(
            util.PublicVariable.SERVER_URL,
            "newtimesejb.GnVoucher.GnVoucherFacade");
        ejb2update=ejbHome.create();
        Record rec= exgui2.CONST.BASIC_MAIN_EJB.getBlankRecord("GV_ACC_DATA_tbl");
        rec.set("record_create_user",util.PublicVariable.USER_RECORD.get(0));
        rec.set("record_delete_flag",-1);
        rec.set("cen_code",util.PublicVariable.USER_RECORD.get(4));
        blankRecord=rec;
      }catch(Exception exp){
        exp.printStackTrace();
      }
    }
    public Record getRecordByPk(int seq){
      try{
        Vector vct=exgui2.CONST.BASIC_MAIN_EJB.getDatas(util.PublicVariable.USER_RECORD,
                                                        "select * from GV_ACC_DATA where rec_seq="+seq,
                                                        1,99999);
         if(vct.size()==0)return null;
         return (Record)vct.get(0);
      }catch(Exception exp){
        exp.printStackTrace();
      }
      return null;

    }

    public void updateRecords(java.util.Vector vct)throws Exception{
      try{
        util.MiscFunc.showProcessingMessage();
        ejb2update.handleGnVoucherAccData(vct);
      }finally{
        util.MiscFunc.hideProcessingMessage();
      }

    }
  }

