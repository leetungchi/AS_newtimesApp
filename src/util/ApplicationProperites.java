package util;
import java.util.HashMap;
/**
 * Title:application properties place holder
 * Description:
 * Copyright:    Copyright (c) 2001
 * Company:inforich.com.tw
 * @author john.cheng(Crazy John)
 * @version 1.0
 */

public class ApplicationProperites {
 protected static HashMap hm=new HashMap();
 /**
  * to simulate system set properties function
  * @param keyObj key to map
  * @param valueObj value to put
  */
 public static void setProperties(Object keyObj,Object valueObj){
   hm.put(keyObj,valueObj);
 }
 /**
  * to get object from application properties
  * @param keyObj the index key by ApplicationProperties.setProperties(key,value)
  * @return the value to maps to thes key obj set by ApplicationProperties.setProperties(key,value)
  */
 public static Object getProperties(Object keyObj){
   return hm.get(keyObj);
 }
 /**
  * to hash map remove process from applicationProperties
  * @param keyObj the index key by ApplicationProperties.setProperties(key,value)
  * @ruturn previous value associated with specified key, or null if there was no mapping for key. A null return can also indicate that the map previously associated null with the specified key
  */
 public static Object removeProperites(Object keyObj){
  return  hm.remove(keyObj);
 }
}