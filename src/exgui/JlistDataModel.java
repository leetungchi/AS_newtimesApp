package exgui;
import java.util.Vector;
import java.util.ArrayList;
import database.datatype.Record;
import javax.swing.*;
import util.MiscFunc;
import java.util.HashMap;
/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2002</p>
 * <p>Company: </p>
 * @author unascribed
 * @version 1.0
 */

class JlistDataModel extends AbstractListModel implements java.io.Serializable{
     java.util.ArrayList strings=new ArrayList();
     ArrayList selectedAt=new ArrayList();
    /**
     * to generate datamodel for jlist or other list object
     * @param recs--vectored records data
     * @param showColumn---the column name which the text from record to show in jlist object
     * @param compareColumn--the column name to find the data to match
     * @param selectedValue--the value to set the row as selected
     */
    JlistDataModel(){}
    JlistDataModel(Vector recs,String showColumn,String compareColumn,Object selectedValue){
      HashMap hm=new HashMap();
      hm.put(compareColumn,selectedValue);
      iniprc(recs,showColumn,hm);
    }
    JlistDataModel(Vector recs,String showColumn,HashMap obj2find){
     iniprc(recs,showColumn,obj2find);
    }
    private void iniprc(Vector recs,String showColumn,HashMap obj2find){
      try{
         for(int i=0;i<recs.size();i++){
           Record rec=(Record)recs.get(i);
           Object storedValue=rec.get(showColumn);
           strings.add(storedValue.toString());
           if(MiscFunc.isHashMapInRecod(rec,obj2find)) selectedAt.add(new Integer(i));
         }
      }catch(Exception e){
        e.printStackTrace();
        util.ExceptionLog.exp2File(e,"exp while producting datamodel");
      }

    }
     public int getSize(){
      return strings.size();
     }
     public Object getElementAt(int i){
      return strings.get(i);
     }
}