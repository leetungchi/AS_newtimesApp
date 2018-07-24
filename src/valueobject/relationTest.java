package valueobject;
import database.*;
import database.datatype.*;
import java.util.Vector;
/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2002</p>
 * <p>Company: </p>
 * @author unascribed
 * @version 1.0
 */

public class relationTest {

  public relationTest() {
    try{
      util.ExceptionLog.setLogPath("c:\\newtimes.log");
      Database db=new Database("jdbc:microsoft:sqlserver://127.0.0.1:1433;databasename=MTFC","sa","","com.microsoft.jdbc.sqlserver.SQLServerDriver",13,new database.encoders.SQLEncoder());

      TableInterface rTbl=new CommonTable("relation_reg",db,"id");
      RelationFactory rlFx=new RelationFactoryImp(rTbl);
      TableInterface att1=new CommonTable("att_1",db,"sn,id");
      TableInterface att2=new CommonTable("att_2",db,"code");
      TableInterface att3=new CommonTable("att_3",db,"id");
      TableInterface itemsData=new CommonTable("items_data",db,"obj_id");
        //find out the items_data obj_id='c'

      Record recData=itemsData.findRecordByPk("c");

      long timebgn=System.currentTimeMillis();
      ValueObjectInterface att1_4_b=rlFx.getComposedObject(recData);
      System.out.println("takes"+(System.currentTimeMillis()-timebgn)/1000+ "seconds");
      treeString("",att1_4_b);



      /*
      Vector att1_rec_vct=new Vector();
      att1_rec_vct.add("4");
      att1_rec_vct.add("b");
      Record att1_1rec=att1.findRecordByPk(att1_rec_vct);

      rlFx.unbindRelation(recData,att1_1rec);
      System.out.println("after remove att1 4_b");
      att1_4_b=rlFx.getComposedObject(recData);
      treeString("",att1_4_b);
      */

      System.out.println("               begin of 2nd");
      timebgn=System.currentTimeMillis();
      att1_4_b=rlFx.getCurChildComposedObject(recData);
      System.out.println("takes"+(System.currentTimeMillis()-timebgn)/1000+ "seconds");
      treeString("",att1_4_b);

      System.out.println("               begin of 3rd");
      timebgn=System.currentTimeMillis();
      att1_4_b=rlFx.getCurChildComposedObject(recData);
      System.out.println("takes"+(System.currentTimeMillis()-timebgn)/1000+ "seconds");
      treeString("",att1_4_b);

      System.out.println("               begin of 4th");
      timebgn=System.currentTimeMillis();
      att1_4_b=rlFx.getCurChildComposedObject(recData);
      System.out.println("takes"+(System.currentTimeMillis()-timebgn)/1000+ "seconds");
      treeString("",att1_4_b);


      System.out.println("               begin of 5th");
      timebgn=System.currentTimeMillis();
      att1_4_b=rlFx.getComposedObject(recData);
      System.out.println("takes"+(System.currentTimeMillis()-timebgn)/1000+ "seconds");
      treeString("",att1_4_b);

      /*
      ValueObjectInterface ocp7=rlFx.getComposedObject(recData);
      Vector vctKtn=rlFx.getContainersRecordChain(ocp7);
      for(int i=0;i<vctKtn.size();i++){
        System.out.println("container:"+((Record)vctKtn.get(i)).toString());
      }
      */
      /*
      System.out.println("delete a tree--itemsData :id=c");
      rlFx.deleteTree(att1_4_b);
      */
       /*
      att1_rec_vct=new Vector();
      att1_rec_vct.add("1");
      att1_rec_vct.add("2");
      att1_1rec=att1.findRecordByPk(att1_rec_vct);
      Record itemsDataLastRec=itemsData.findRecordByPk("c");
      rlFx.bindRelation(itemsDataLastRec,att1_1rec);
      att1_rec_vct=new Vector();
      att1_rec_vct.add("4");
      att1_rec_vct.add("b");
      att1_1rec=att1.findRecordByPk(att1_rec_vct);
      rlFx.bindRelation(itemsDataLastRec,att1_1rec);
      rlFx.bindRelation(att1_1rec,att3.findRecordByPk("3"));

      Record att2_rec=att2.findRecordByPk("id3");
      rlFx.bindRelation(itemsDataLastRec,att2_rec);

      att1_rec_vct=new Vector();
      att1_rec_vct.add("4");
      att1_rec_vct.add("c");
      att1_1rec=att1.findRecordByPk(att1_rec_vct);
      rlFx.bindRelation(itemsDataLastRec,att1_1rec);
      Record apv=(new CommonTable("approver",db,"sn")).findRecordByPk(1);
      rlFx.bindRelation(att3.findRecordByPk("3"),apv);
      Record ocpu=(new CommonTable("occupation",db,"sn")).findRecordByPk(7);
      rlFx.bindRelation(att2_rec,ocpu);
      */
      System.out.println("finsh all proceess of relation table.");
      System.exit(0);
    }catch(Exception e){
      e.printStackTrace();
    }

  }
  public static void main(String[] args) {
    relationTest relationTest1 = new relationTest();
  }
  public void treeString(String opint,Object obj2print){
    String spaceString=opint;
    if(obj2print instanceof database.datatype.Record ){
      System.out.println(spaceString+"--"+((Record)obj2print).toString());
      return;
    }else if(obj2print instanceof valueobject.ValueObjectInterface ){
      System.out.println(" valueObjectInterface "+spaceString+((ValueObjectInterface)obj2print).getRecord().toString());
      opint+=" +-";
      Vector kpz=((ValueObjectInterface)obj2print).getComponents();
      for(int i=0;i<kpz.size();i++) treeString(opint,kpz.get(i));
    }
  }
}