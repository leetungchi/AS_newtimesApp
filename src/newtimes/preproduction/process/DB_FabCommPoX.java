package newtimes.preproduction.process;
import exgui.ultratable.PagedDataFactoryAdapter;
import database.datatype.Record;
import java.util.Vector;
/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class DB_FabCommPoX extends DB_FabComm {
  public DB_FabCommPoX(int prodSeq) {
    super(prodSeq);
    try{
      _prodSeq=prodSeq;
     newtimesejb.preproduction.Fab_Com_PoExtFavadeHome  ejbHome=
        (newtimesejb.preproduction.Fab_Com_PoExtFavadeHome)info_ejb.WeblogicServiceLocator.locateServiceHome(
        util.PublicVariable.SERVER_URL,"newtimesejb.preproduction.Fab_Com_PoExtFavade");
      super.ejb=ejbHome.create();
      super.blankRecord=ejb.getBlankRecord();
      blankRecord.set("record_create_user",util.PublicVariable.USER_RECORD.get("usr_code"));
      blankRecord.set("record_delete_flag","1");
      blankRecord.set("FAB_COMM_UNIT","PC");
      blankRecord.set("FAB_COMM_TYPE","FABRIC");
      blankRecord.set("FAB_COMM_DISCOUNT_KIND",new Integer(1));
      blankRecord.set("FAB_COMM_PROD_PK",_prodSeq);
      blankRecord.set("FAB_PROD_HEAD_PK",_prodSeq);
      blankRecord.set("FAB_COMM_CUR","USD");
      initOK=true;
      super.conditions=new java.util.HashMap();

    }catch(Exception exp){
      exp.printStackTrace();
      util.ExceptionLog.exp2File(exp,"");
      initOK=false;
    }
  }
  public void deleteRecord(Record rec2delete)throws Exception{
    rec2delete.set("record_delete_flag","0");
    rec2delete.set("record_modify_user",util.PublicVariable.USER_RECORD.get(0));
    java.util.Vector vct2del=new java.util.Vector();
    vct2del.add(rec2delete);
    updateRecords(vct2del);
  }
  int fieldIndex[]=
      { //fabric commission list
        0,1,2,3,4,5,6,7,8,9,10,11,12,20,//14 columns
        //fab-po fields
        0,1,2,3,4,5,6,7,8,9,10,11,12,13,21,22,23,//17 columns
        //fab-po style use count.
        24,25,26,27,28,29,// 6 columns
        -5,-5,-5,-5,-5,-5,-5,23
       };
  public Record completeRecord(Record fabCommRec,Record fabPoRec)throws Exception{
    Record rec=getBlankRecord();
    String fieldNames[]=(String[])rec.getFieldName().toArray(new String[0]);
    for(int i=0;i<fieldNames.length;i++){
      //String fieldIndexNo=(String)fieldIndexTable.get(fieldNames[i].toUpperCase());
      //if(fieldIndexNo==null)continue;
      if(fieldNames[i].startsWith("FAB_COMM_")){
        rec.set(i,fabCommRec.get(fieldIndex[i]));
        continue;
      }else if(fieldNames[i].startsWith("FAB_")){
        if(fieldNames[i].equals("FAB_CONTENT"))continue;//because this field can not be edit where.
        rec.set(i,fabPoRec.get(fieldIndex[i]));
        continue;
      }else{
        continue;
      }
    }

    return rec;
  }

  public java.util.Vector getRecords(int rowBgn,int rowcount)throws Exception{
         conditions.put("record_delete_flag","1");
         conditions.put("FAB_COMM_PROD_PK",new Integer(_prodSeq));
         //return ejb.getRecords(rowBgn,rowcount,conditions);
         //search and combine fab_comm and fab_po data,with union result
                                            //FAB_COMM_PROD_PK
         String prodHeadPk = conditions.get("FAB_COMM_PROD_PK").toString();
         StringBuffer sb = new StringBuffer();
         sb.append("select a.*,");
         sb.append("(select count(*) from style_fabpo_map where fab_po_seq_0=a.fab_seq) as FAB_use_count_0,");
         sb.append("(select count(*) from style_fabpo_map where fab_po_seq_1=a.fab_seq) as FAB_use_count_1,");
         sb.append("(select count(*) from style_fabpo_map where fab_po_seq_2=a.fab_seq) as FAB_use_count_2,");
         sb.append("(select count(*) from style_fabpo_map where fab_po_seq_3=a.fab_seq) as FAB_use_count_3,");
         sb.append("(select count(*) from style_fabpo_map where fab_po_seq_4=a.fab_seq) as FAB_use_count_4,");
         sb.append("(select count(*) from style_fabpo_map where fab_po_seq_5=a.fab_seq) as FAB_use_count_5");
         sb.append(" from FABRIC_PO a ");
         sb.append("where a.FAB_PROD_HEAD_PK=");
         sb.append(prodHeadPk);
         sb.append(" and a.record_delete_flag='1' order by FAB_SEQ");

         Vector vctFabComm =
             exgui2.CONST.BASIC_MAIN_EJB.getDatas(
                util.PublicVariable.USER_RECORD,
                "select * from  fab_comm where record_delete_flag='1' and FAB_COMM_PROD_PK=" +
                prodHeadPk +
                " order by FAB_COMM_PK ",1,99999
             ) ;

             Vector vctFabPo = exgui2.CONST.BASIC_MAIN_EJB.getDatas(
                    util.PublicVariable.USER_RECORD,
                    sb.toString(),1,99999
                 ) ;

             //tblFabComm.SQL2Records(sb.toString());
         Vector vct2Return = new Vector();
         int maxRowCount = (vctFabComm.size() < vctFabPo.size()) ? vctFabPo.size() :
             vctFabComm.size();
         //complete with fabcomm record
         for (int i = 0; i < maxRowCount; i++) {
           Record recblankFabPoComplex=null;// = getBlankRecord();
           Record recFabComm;
           Record recFabPo;
           if (i >= vctFabComm.size()) {
             recFabComm =exgui2.CONST.BASIC_MAIN_EJB.getBlankRecord("FAB_COMM_tbl"); //tblFabComm.newRecord();
             recFabComm.set(0, -1 * (i+1));
             recFabComm.set(1,prodHeadPk);
             recFabComm.set(2,"PC");//unit default value
             recFabComm.set(8,new Integer(1));//discount type
             recFabComm.set(20,"FABRIC");//comm_type
             recFabPo = (Record) vctFabPo.get(i);
           }else if (i >= vctFabPo.size()) {
             recFabPo =exgui2.CONST.BASIC_MAIN_EJB.getBlankRecord("fabric_po_tbl"); //tblFabPo.newRecord();
             recFabPo.getFieldName().add("FAB_USE_COUNT_0");
             recFabPo.getValueFields().add("0");
             recFabPo.getFieldName().add("FAB_USE_COUNT_1");
             recFabPo.getValueFields().add("0");
             recFabPo.getFieldName().add("FAB_USE_COUNT_2");
             recFabPo.getValueFields().add("0");
             recFabPo.getFieldName().add("FAB_USE_COUNT_3");
             recFabPo.getValueFields().add("0");
             recFabPo.getFieldName().add("FAB_USE_COUNT_4");
             recFabPo.getValueFields().add("0");
             recFabPo.getFieldName().add("FAB_USE_COUNT_5");
             recFabPo.getValueFields().add("0");
             recFabPo.set(0, -1 * (i+1));
             recFabPo.set(1,prodHeadPk);
             recFabComm = (Record) vctFabComm.get(i);
           }else {
             recFabPo = (Record) vctFabPo.get(i);
             recFabComm = (Record) vctFabComm.get(i);
           }
           recblankFabPoComplex = completeRecord(recFabComm, recFabPo);
           vct2Return.add(recblankFabPoComplex);
         }
         return vct2Return;

  }

  public Record addRecord(Record rec)throws Exception{
    Record rec2add=rec;
    if(rec2add==null)rec2add=getBlankRecord();
    //set both fab_comm and fab_Po key to minus,notify server to proceed insert process.
    rec2add.set(0,-1);
    rec2add.set(14,-1);
    System.out.println("call add rec,ejb in Db_FabCommPox is "+ejb.toString());
    return ejb.insertRecord(rec2add);
    //return super.addRecord(rec2add);
  }
}
