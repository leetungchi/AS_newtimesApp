package util;
import database.*;
import database.datatype.*;
import database.encoders.*;
import java.util.*;

/**
 * Title:
 * Description:
 * Copyright:    Copyright (c) 2001
 * Company:
 * @author
 * @version 1.0
 */

public class i18nMsg {
  protected static Hashtable  msgMap=new Hashtable();
  public static void setMsgDb(String localeLanguage,Database db){
    try{
      CommonTable msgTable=new CommonTable("message",db,"msg_id");
      HashMap hm=new HashMap();
      Vector records=msgTable.findAll("msg_id",false);
      for(int i=0;i<records.size();i++){
        Record rec=(Record)records.get(i);
        String msgMap2=(String)rec.get(localeLanguage);
        if(msgMap2!=null) msgMap.put(rec.get("e_message"),msgMap2);
      }
      records=null;
      msgTable=null;System.gc();
   }catch(Exception e){
     util.ExceptionLog.exp2File(e,"Exp while creating message maping in i18nMsg.class");
   }
  }
  public static String getMsg(String englishMsg){
    if(!msgMap.containsKey(englishMsg)) return englishMsg;
    return (String)msgMap.get(englishMsg);
  }
}